/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package redmineparser;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author ffelez
 */
class RedmineTask {

    HashMap<String, String> mElements = new HashMap<>();
    
    public RedmineTask() 
    {
    }

    void addParameter(String name, String value) 
    {
        mElements.put (name, value);
    }

    String getValue(String attName) 
    {    
        return mElements.get(attName);
    }
    
    public LinkedList<String> getElementKeys()
    {
        LinkedList<String> keys = new LinkedList<String>();
        keys.addAll(mElements.keySet());
        Collections.sort(keys);
        return keys;
    }
}
