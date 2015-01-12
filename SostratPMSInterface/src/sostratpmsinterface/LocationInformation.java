/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sostratpmsinterface;

/**
 *
 * @author ffelez
 */
class LocationInformation 
{
    public String id;
    public String name;
    public String code;
    public String length;
    public String maxLength;

    LocationInformation(String id, String name, String code, String length, String maxLength) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.length = length;
        this.maxLength = maxLength;
    }

    String parseInformation() 
    {        
        String result = "<SOSTRAT_DATA>\n";
        result+="<HEADER>   <TYPE>RECORDSET</TYPE>   <ACTION>INSERT</ACTION>   <OBJECTNAME>ALINEACIO_DADES</OBJECTNAME></HEADER><RECORDSET>\n";
        result+="<ALINEACIO_DADES>\n";
        result+="<IDALINEACIO>" + id + "</IDALINEACIO>\n";
        result+="<NOMALINEACIO>" + name + "</NOMALINEACIO>\n";
        result+="<CODALINEACIO>" + code + "</CODALINEACIO>\n";
        result+="<DATINIVIGENCIA>2010-04-23T10:32:00+02:00</DATINIVIGENCIA>\n";
        result+="<DATFIVIGENCIA>2015-04-23T10:32:00+02:00</DATFIVIGENCIA>\n";
        result+="<ESLMAXIMA>" + length + "</ESLMAXIMA>\n";
        result+="<LONGITUD>" + maxLength + "</LONGITUD>\n";
        result+="</ALINEACIO_DADES>\n";
        result+="</RECORDSET></SOSTRAT_DATA>\n";
        
        return result;
    }
}
