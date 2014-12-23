/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package accountsManager;

import java.util.HashMap;

/**
 *
 * @author SESA218968
 */
class AccountPoint {

    String concept = "";
    String date = "";
    String validDate = "";
    double value = 0.0;
    
    void addParameter(String name, String value) 
    {
        if (name.equals("Concepto"))
        {
            concept = value;
        }
        else if (name.equals("Fecha Operaci n"))
        {
            date = value;
        }
        else if (name.equals("Fecha Valor"))
        {
            validDate = value;
        }
        else if (name.equals("Importe"))
        {
            this.value = Double.valueOf(value.replace(".", "").replace(",", "."));
        }
        
    }
    
}
