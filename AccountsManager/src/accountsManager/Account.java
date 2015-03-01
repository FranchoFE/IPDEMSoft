/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package accountsManager;

import java.util.LinkedList;

/**
 *
 * @author SESA218968
 */
class Account {

    private final String mName;
    LinkedList<AccountPoint> points = new LinkedList<AccountPoint>();
    private final String mFileName;
    private int mId;
    
    
    Account(String fileName, String name) 
    {
        mFileName = fileName;    
        mName = name;
        mId = -1;
    }
    
    Account(int id, String name) 
    {
        mFileName = "DB Id: " + id;    
        mName = name;
        mId = id;
    }

    void add(AccountPoint point) 
    {
        points.add(point);
    }

    double calcMovementsTotal() {
        double total = 0;
        for (AccountPoint point : points)
        {
            total += point.value;
        }
        return total;
    }

    String getName() {
        return mName;
    }

    String getFileName() {
        return mFileName;
    }

    Integer getId() {
        return mId;
    }
    
}
