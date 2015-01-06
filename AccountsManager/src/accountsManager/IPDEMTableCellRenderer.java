/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountsManager;

import java.awt.Color;
import java.awt.Component;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Francho
 */
public class IPDEMTableCellRenderer extends DefaultTableCellRenderer 
{
    LinkedList<Integer> mCategories = null;
            
    public IPDEMTableCellRenderer(LinkedList<Integer> categories) 
    {  
        setOpaque(true);  
        mCategories = categories;
    }  
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
    {
        Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if (mCategories.get(row) == 0)
        {  
            renderer.setForeground(Color.blue);  
        }  
        else if (mCategories.get(row) == 1)
        {  
            renderer.setForeground(Color.red);  
        }  
        else if (mCategories.get(row) == 2)
        {  
            renderer.setForeground(Color.pink);  
        } 
        else if (mCategories.get(row) == 3)
        {  
            renderer.setForeground(Color.cyan);  
        }  
        else
        {  
            renderer.setForeground(Color.black);  
        }  
        return this;
    }
}
