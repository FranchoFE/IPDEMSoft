/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package redmineparser;

import java.util.LinkedList;

/**
 *
 * @author ffelez
 */
class ProjectTask extends RedmineTask
{

    LinkedList<String> mRedmineTasksString = new LinkedList<>();
    String mName = "";
    double doneWork = 0;
    double doneWorkEstimated = 0;
    int pendiente = 0;
    
    public ProjectTask() 
    {
        super();
    }

    public ProjectTask(RedmineTask task) 
    {
        super();
        mElements = task.mElements;
        mName = task.getValue("1-Nombre");
        String elements = task.getValue("3-Tareas");
        String[] split = elements.split(",");
        for (int i = 0; i < split.length; i++)
        {
            addElement (split[i]);
        }
    }

    void addElement(String element)
    {
        mRedmineTasksString.add (element);
    }

    boolean computeTask(RedmineTask task) 
    {
        boolean exists = mRedmineTasksString.contains(task.getValue("#"));
        if (exists)
        {
            doneWorkEstimated += Double.valueOf(task.getValue ("Tiempo estimado").replace(",", "."));
            doneWork += Double.valueOf(task.getValue ("Tiempo dedicado").replace(",", "."));
            double initialEstimated = Double.valueOf(getValue ("4-Estimado Inicial").replace(",", "."));
            pendiente += Integer.valueOf (task.getValue ("hours to end"));
                                    
            mElements.put("5-Estimado", Double.toString(doneWorkEstimated) + " (" + Integer.toString((int) doneWorkEstimated/8) + ")");
            mElements.put("6-Dedicado", Double.toString(doneWork) + " (" + Integer.toString((int) doneWork/8) + ")");
            mElements.put("7-% Dedicado", Integer.toString((int) (doneWork/(doneWork + pendiente)*100)) + "%");
            mElements.put("9-Desvio Actual", Double.toString (doneWork + pendiente - initialEstimated));
            mElements.put("8-Pendiente", Integer.toString (pendiente));
        }
        
        return exists;
    }

    void clear() {
        doneWork = 0;
        doneWorkEstimated = 0;
    }
}
