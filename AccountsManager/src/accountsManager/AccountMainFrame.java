/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package accountsManager;

import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author SESA218968
 */
public class AccountMainFrame extends javax.swing.JFrame {
    private LinkedList<Account> accounts = new LinkedList<Account>();

    /**
     * Creates new form AccountMainFrame
     */
    public AccountMainFrame() {
        initComponents();
        
        setSize(1200, 800);
        setLocation(200, 100);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        mTabbedPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("Accounts Manager");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(mTabbedPane, gridBagConstraints);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane mTabbedPane;
    // End of variables declaration//GEN-END:variables

    void setAccount(Account account) {
        accounts.add (account);
    }
 
    void showAccounts() {
        for (Account account: accounts) 
        {
            javax.swing.JPanel panel = new javax.swing.JPanel();
            panel.setName (account.getName());
            panel.setLayout(new java.awt.GridBagLayout());
            
            javax.swing.JLabel label = new javax.swing.JLabel();
            java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.weightx = 0.0;
            gridBagConstraints.weighty = 0.0;
            gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
            panel.add(label, gridBagConstraints);
            
            javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
            javax.swing.JTable jTable1 = new javax.swing.JTable();
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null}
                },
                new String [] {
                    "Concepto", "Valor", "Fecha", "Fecha Validez"
                }
            ));
            jScrollPane1.setViewportView(jTable1);
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.weighty = 1.0;
            gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
            panel.add(jScrollPane1, gridBagConstraints);

            // Se añade la pestaña al panel
            mTabbedPane.addTab(account.getName(), panel);
            
            int totalValue = addPoints (account, jTable1);
            label.setText (account.getFileName() + " (" + totalValue + ")");
        }
    }

    private int addPoints(Account account, JTable table) 
    {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(account.points.size());
        
        int total = 0;
        
        int i = 0;
        for (AccountPoint point : account.points)
        {
            model.setValueAt(point.concept, i, 0);
            model.setValueAt(point.value, i, 1);
            model.setValueAt(point.date, i, 2);
            model.setValueAt(point.validDate, i, 3);
            i++;
            
            total += point.value;
        }
        
        return total;
    }
}
