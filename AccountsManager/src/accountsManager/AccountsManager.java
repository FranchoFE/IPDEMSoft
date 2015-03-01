/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package accountsManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author ffelez
 */
public class AccountsManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException 
    {
        LinkedList<Account> accounts = readAccountsFromDB(); 
        readPointsFromDB(accounts);     
        
        /*
        Account account = readAccountFromFile("Accounts\\Cuenta_00651366140001014248.csv", "14248");
        System.out.println ("Total 14248: " + account.calcMovementsTotal());
        
        Account account2 = readAccountFromFile("Accounts\\Cuenta_00651366140001028303.csv", "28303");
        System.out.println ("Total 28303: " + account2.calcMovementsTotal());
        */
                
        AccountMainFrame frame = new AccountMainFrame();
        //frame.setAccount (account);
        //frame.setAccount (account2);
        for (Account account : accounts)
        {
            frame.setAccount (account);
        }
        frame.showAccounts();
        frame.setVisible (true);
    }

    private static LinkedList<String> getArrayFrom(String lineReaded, String separator) 
    {
        LinkedList<String> result = new LinkedList<>();
        int index = -1;
        index = lineReaded.indexOf(separator);
        while (index != -1)
        {
            result.add(lineReaded.substring(0, index));
            lineReaded = lineReaded.substring(index + separator.length());
            index = lineReaded.indexOf(separator);            
        }
        if (!lineReaded.isEmpty())
        {
            result.add (lineReaded);
        }
        return result;
    }

    private static Account readAccountFromFile(String fileName, String name) throws FileNotFoundException, IOException {
                        
        InputStreamReader isr = new InputStreamReader (new FileInputStream(fileName));
        BufferedReader br = new BufferedReader(isr);
        
        Account account = new Account(fileName, name);
        
        String lineReaded = br.readLine();
        lineReaded = br.readLine();
        lineReaded = br.readLine();
        lineReaded = br.readLine();
        lineReaded = br.readLine();
        lineReaded = lineReaded.replace((char) 65533, ' ');
        LinkedList<String> fields;
        fields = getArrayFrom(lineReaded, ";");
        
        lineReaded = br.readLine();
        while (lineReaded != null)
        {
            //System.out.println ("Leyendo " + lineReaded);
            
            lineReaded = lineReaded.replace((char) 65533, ' ');
            
            AccountPoint point = new AccountPoint();
            int fieldsNumber = fields.size();
            
            LinkedList<String> values;
            values = getArrayFrom(lineReaded, ";");
            
            if (fieldsNumber == values.size())
            {
                int i;
                for (i = 0; i < fieldsNumber; i++)
                {
                    point.addParameter (fields.get(i), values.get(i));
                }
                account.add (point);
            }
            else
            {
                System.err.println ("Error leyendo " + fileName + " con la línea " + lineReaded);
            }
            
            lineReaded = br.readLine();
        }
        return account;
    }

    private static void readPointsFromDB(LinkedList<Account> accounts) throws SQLException {
        MyDBConnection mdbc = new MyDBConnection();
        mdbc.init();
        Connection conn=mdbc.getMyConnection();
        
        for (Account account : accounts)
        {
            Statement stmt = conn.createStatement();
            ResultSet executeQuery = stmt.executeQuery("select Concept,value,Date,ValidDate from am_point where accountId = " + account.getId());
            while (executeQuery.next())
            {
                String concept = executeQuery.getString("Concept");
                Integer value = executeQuery.getInt("value");
                Date date = executeQuery.getDate("Date");
                Date validDate = executeQuery.getDate("ValidDate");
                
                AccountPoint point = new AccountPoint();
                point.addParameter("Concepto", concept);
                point.addParameter("Importe", "" + value);
                point.addParameter("Fecha Operaci n", "" + date);
                point.addParameter("Fecha Valor", "" + validDate);
                account.add(point);
            }
            executeQuery.close();
            stmt.close();
        }
        
        mdbc.destroy();
    }
    
    private static LinkedList<Account> readAccountsFromDB() throws SQLException {
        LinkedList<Account> accounts = new LinkedList<Account>();
        
        MyDBConnection mdbc = new MyDBConnection();
        mdbc.init();
        Connection conn=mdbc.getMyConnection();
        Statement stmt = conn.createStatement();
        ResultSet executeQuery = stmt.executeQuery("select id,name from am_accounts");
        while (executeQuery.next())
        {
            String name = executeQuery.getString("name");
            Integer id = executeQuery.getInt("id");
            
            Account account = new Account(id, name);
            accounts.add (account);
        }
        executeQuery.close();
        stmt.close();
        mdbc.destroy();
        
        return accounts;
    }
    
}
