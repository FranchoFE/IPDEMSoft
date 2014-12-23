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
class RedmineTaskFilter {
    private LinkedList<String> mValues;
    private final String mAttribute;


    RedmineTaskFilter(String attribute) {
        mAttribute = attribute;
    }

    void addValues(LinkedList<String> values) {
        mValues = values;
    }

    String getAttribute() {
        return mAttribute;
    }

    boolean isValid(String value) 
    {
        boolean result = false;
        if (mValues.indexOf(value) != -1)
        {
            result = true;
        }
        return result;
    }
    
}
