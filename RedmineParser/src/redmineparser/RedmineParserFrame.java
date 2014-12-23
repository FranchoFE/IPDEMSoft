/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package redmineparser;

import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ffelez
 */
public class RedmineParserFrame extends javax.swing.JFrame {
    private LinkedList<RedmineTask> mTasks;
    private LinkedList<String> mColumns;
    private HashMap<String, RedmineTaskFilter> mFilters;
    private LinkedList<RedmineTask> mFilteredTask;
    private LinkedList<ProjectTask> mProjectTasks;
    private boolean filter = true;
    LinkedList<String> errorTasks = null;

    /**
     * Creates new form RedmineParserFrame
     */
    public RedmineParserFrame() {
        initComponents();
        
                
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ListSelectionModel selectionModel = jTable2.getSelectionModel();

        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (mRBProject.isSelected() && !e.getValueIsAdjusting() && filter)
                {
                    changeFilter();
                }
            }
        });
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mWarnings = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        mRBAll = new javax.swing.JRadioButton();
        mRBOpened = new javax.swing.JRadioButton();
        mRBProject = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMinimumSize(new java.awt.Dimension(100, 100));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 100));
        jScrollPane1.setRequestFocusEnabled(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jLabel1.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jLabel1, gridBagConstraints);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(52, 52));

        mWarnings.setMinimumSize(new java.awt.Dimension(100, 100));
        mWarnings.setPreferredSize(new java.awt.Dimension(100, 100));
        jScrollPane2.setViewportView(mWarnings);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jScrollPane2, gridBagConstraints);

        buttonGroup1.add(mRBAll);
        mRBAll.setSelected(true);
        mRBAll.setText("Todas");
        mRBAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRBAllActionPerformed(evt);
            }
        });
        jPanel2.add(mRBAll);

        buttonGroup1.add(mRBOpened);
        mRBOpened.setText("Abiertas");
        mRBOpened.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRBOpenedActionPerformed(evt);
            }
        });
        jPanel2.add(mRBOpened);

        buttonGroup1.add(mRBProject);
        mRBProject.setText("Proyecto");
        mRBProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRBProjectActionPerformed(evt);
            }
        });
        jPanel2.add(mRBProject);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jPanel2, gridBagConstraints);

        jScrollPane3.setMinimumSize(new java.awt.Dimension(100, 100));
        jScrollPane3.setName(""); // NOI18N
        jScrollPane3.setPreferredSize(new java.awt.Dimension(100, 100));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jScrollPane3, gridBagConstraints);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mRBOpenedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRBOpenedActionPerformed
        changeFilter();
    }//GEN-LAST:event_mRBOpenedActionPerformed

    private void mRBAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRBAllActionPerformed
        changeFilter();
    }//GEN-LAST:event_mRBAllActionPerformed

    private void mRBProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRBProjectActionPerformed
        changeFilter();
    }//GEN-LAST:event_mRBProjectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JRadioButton mRBAll;
    private javax.swing.JRadioButton mRBOpened;
    private javax.swing.JRadioButton mRBProject;
    private javax.swing.JTextPane mWarnings;
    // End of variables declaration//GEN-END:variables

    void setTasks(LinkedList<RedmineTask> tasks) {
        mTasks = tasks;
        
        errorTasks = checkTasks();
        
        actualizeProjects();
        
        actualizeView();
    }

    void setInterestedColumns(LinkedList<String> columns) {
        mColumns = columns;        
    }

    private void actualize() 
    {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        model.setColumnIdentifiers(mColumns.toArray());
        model.setNumRows(mFilteredTask.size());
        
        int i = 0;
        for (RedmineTask task : mFilteredTask)
        {
            boolean valid = true;
            LinkedList<String> values = new LinkedList<>();
            for (String attName : mColumns)
            {
                String value = task.getValue(attName);
                
                RedmineTaskFilter filter = mFilters.get(attName);
                if (filter != null)
                {
                    valid = filter.isValid (value);
                }
                
                if (!valid)
                {
                    break;
                }
                
                values.add(value);
            }
            
            if (valid)
            {
                int j = 0;
                for (String value : values)
                {
                    model.setValueAt(value, i, j);
                    j++; 
                }
                i++;
            }
        }
        
        jLabel1.setText("Elementos: " + mTasks.size() + ". Visibles " + mFilteredTask.size());
    }

    void setFilters(HashMap<String, RedmineTaskFilter> filters) {
        mFilters = filters;
    }

    private LinkedList<String> checkTasks() {
        LinkedList<String> results1 = new LinkedList<String>();
        LinkedList<String> results2 = new LinkedList<String>();
        
        for (ProjectTask projectTask : mProjectTasks)
        {
            projectTask.clear();
        }
        
        // Se recorren todas las tareas para ir realizando las comprobaciones pertinentes
        for (RedmineTask task : mTasks)
        {
            // Para las que están finalizadas, se mira que no tengan horas pendientes
            if (task.getValue("Estado").equals("resolved"))
            {
                // No está al 100%
                if (!task.getValue("% Realizado").equals("100") && !task.getValue("Tipo").equals("travel"))
                {
                    results1.add ("La tarea " + task.getValue("#") + " está finalizada pero completada " + task.getValue("% Realizado") + "%");
                }
            }
            
            // Si es una tarea de desarrollo, debe estar dentro de una del project
            if (task.getValue("Proyecto").equals("Desarrollo VTMOS Algeciras"))
            {
                boolean exists = false;
                for (ProjectTask projectTask : mProjectTasks)
                {
                    if (projectTask.computeTask(task))
                    {
                        exists = true;
                        break;
                    }
                }
                
                if (!exists)
                {
                    results2.add ("La tarea " + task.getValue("#") + " de desarrollo no está dentro de ninguna del project");
                }
            }
        }
        
        LinkedList<String> results = results1;
        results.addAll(results2);
        return results;
    }

    private void actualizeChecked(LinkedList<String> results) 
    {
        String text = "";
        for (String result : results)
        {
            text += result + "\n";
        }
        mWarnings.setText(text);
    }

    private void filterTasks() {
        
        mFilteredTask = new LinkedList<RedmineTask>();
        
        for (RedmineTask task : mTasks)
        {
            boolean valid = true;
            for (String attName : mColumns)
            {
                String value = task.getValue(attName);
                
                RedmineTaskFilter filter = mFilters.get(attName);
                if (filter != null)
                {
                    valid = filter.isValid (value);
                }
                
                if (!valid)
                {
                    break;
                }
            }
            
            if (valid)
            {
                mFilteredTask.add (task);
            }
        }
    }

    void setProjectTasks(LinkedList<ProjectTask> projectTasks) 
    {
        mProjectTasks = projectTasks;
    }

    private void changeFilter() 
    {
        boolean all = false;
        boolean project = false;
        if (mRBAll.isSelected())
        {
            all = true;
        }
        else if (mRBProject.isSelected())
        {
            project = true;
        }
        
        mFilters.remove("Estado");
        mFilters.remove("#");
        if (!project && !all)
        {
            mFilters.remove("#");
            
            RedmineTaskFilter filter = new RedmineTaskFilter ("Estado");
            LinkedList<String> values = new LinkedList<String>();
            values.add ("assigned");
            values.add ("new");
            filter.addValues(values);
            mFilters.put("Estado", filter);
        }
        else if (project && !all)
        {
            mFilters.remove("Estado");
            mFilters.remove("#"); 
            
            int selectedRow = jTable2.getSelectedRow();
            if (selectedRow != -1)
            {
                String tasks = (String) jTable2.getValueAt(selectedRow, 2);
            
                RedmineTaskFilter filter = new RedmineTaskFilter ("#");
                LinkedList<String> values = new LinkedList<String>();

                String[] split = tasks.split(",");
                for (int i = 0; i < split.length; i++)
                {
                    values.add(split[i]);
                }

                filter.addValues(values);
                mFilters.put("#", filter);
            }
        }
        
        filter = false;
        actualizeView();
        filter = true;
    }

    private void actualizeView() {
        filterTasks();
        
        actualize();
        
        actualizeChecked(errorTasks);
        
        showProjectStatus();
    }

    private void showProjectStatus() 
    {
        for (ProjectTask task : mProjectTasks)
        {
            String errorString = task.getValue("8-% Desvío Actual");
            if ((errorString != null) && !errorString.isEmpty())
            {
                errorString = ". El plan inicial era de " + task.getValue("4-Estimado Inicial") + " días, pero ahora consideramos " + task.getValue("5-Estimado") + " días";
            }
            else
            {
                errorString = "";
            }
            System.out.println ("Tarea " + task.getValue("1-Nombre") + " de " + task.getValue("2-Proyecto") + " grado de avance " + 
                    task.getValue("7-% Dedicado") + errorString);
        }
    }
    
    private void actualizeProjects() 
    {
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        
        model2.setColumnIdentifiers(mProjectTasks.getFirst().getElementKeys().toArray());
        model2.setNumRows(mProjectTasks.size());
        
        int i = 0;
        for (ProjectTask task : mProjectTasks)
        {
            int j = 0;
            for (String attName : task.getElementKeys())
            {
                String value = task.getValue(attName);
                
                model2.setValueAt(value, i, j);
                j++; 
            }
            i++;
        }
    }

}