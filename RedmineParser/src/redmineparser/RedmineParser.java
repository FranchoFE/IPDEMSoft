/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package redmineparser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author ffelez
 */
public class RedmineParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
               
        
        LinkedList<RedmineTask> tasks = readTasks("redmine.csv");
        LinkedList<RedmineTask> projectTasksReaded = readTasks("project.csv");
        LinkedList<ProjectTask> projectTasks = new LinkedList<ProjectTask>();
        for (RedmineTask task : projectTasksReaded)
        {
            projectTasks.add (new ProjectTask (task));
        }
        
        LinkedList<String> columns = new LinkedList<>();
        columns.add ("#");
        columns.add ("Proyecto");
        columns.add ("Tipo");
        columns.add ("Estado");
        columns.add ("Asunto");
        columns.add ("Asignado a");
        columns.add ("% Realizado");
        
        HashMap<String, RedmineTaskFilter> filters = new HashMap<>();
        /*
        RedmineTaskFilter redmineTaskFilter = new RedmineTaskFilter("Tipo");
        LinkedList<String> values = new LinkedList<>();
        values.add("task");
        redmineTaskFilter.addValues (values);
        filters.put(redmineTaskFilter.getAttribute(), redmineTaskFilter);
        */
        
        RedmineParserFrame redmineParserFrame = new RedmineParserFrame();
        redmineParserFrame.setInterestedColumns (columns);
        redmineParserFrame.setFilters (filters);
        redmineParserFrame.setProjectTasks (projectTasks);
        redmineParserFrame.setTasks (tasks);
        redmineParserFrame.setVisible(true);
        redmineParserFrame.setSize(1000, 700);
        redmineParserFrame.setLocation(100, 100);        
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

    private static LinkedList<RedmineTask> readTasks(String fileName) throws FileNotFoundException, IOException {
        LinkedList<RedmineTask> result = new LinkedList<RedmineTask>();
                
        InputStreamReader isr = new InputStreamReader (new FileInputStream(fileName));
        BufferedReader br = new BufferedReader(isr);
        
        String lineReaded = br.readLine();
        LinkedList<String> fields;
        fields = getArrayFrom(lineReaded, ";");
        
        lineReaded = br.readLine();
        while (lineReaded != null)
        {
            RedmineTask redmineTask = new RedmineTask();
            int fieldsNumber = fields.size();
            
            LinkedList<String> values;
            values = getArrayFrom(lineReaded, ";");
            
            if (fieldsNumber == values.size())
            {
                int i;
                for (i = 0; i < fieldsNumber; i++)
                {
                    redmineTask.addParameter (fields.get(i), values.get(i));
                }
                result.add (redmineTask);
            }
            else
            {
                System.err.println ("Error leyendo " + fileName + " con la línea " + lineReaded);
            }
                  
            
            lineReaded = br.readLine();
        }
        return result;
    }
    
}
