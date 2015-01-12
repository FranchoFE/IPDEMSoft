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
class StopInformation 
{
    public String visitYear;
    public String visitNumber;
    public String shipId;
    public String location;
    public String eta;
    public String etd;
    
    public String parseInformation()
    {
        String result = "<SOSTRAT_DATA>\n";
        result+="<HEADER>   <TYPE>RECORDSET</TYPE>   <ACTION>INSERT</ACTION>   <OBJECTNAME>ATRACADA</OBJECTNAME></HEADER><RECORDSET><ATRACADA>";
        result+="<A_IDSUBPORT>B</A_IDSUBPORT>";
        result+="<A_ANYESCALA>" + visitYear + "</A_ANYESCALA>";
        result+="<A_NUMESCALA>" + visitNumber + "</A_NUMESCALA>";
        result+="<A_SEQATRACADA>1</A_SEQATRACADA>";
        result+="<A_DATSOLICITUD>2013-04-23T10:32:00+02:00</A_DATSOLICITUD>";
        result+="<A_DATCONFIRMACIO>2013-04-23T10:32:00+02:00</A_DATCONFIRMACIO>";
        result+="<A_DATAUTORITZACIO>2013-04-23T11:50:00+02:00</A_DATAUTORITZACIO>";
        result+="<A_DATANULACIO></A_DATANULACIO>";
        result+="<A_DATDENEGACIO></A_DATDENEGACIO>";
        result+="<A_IDESTATATRACADA>F</A_IDESTATATRACADA>";
        result+="<A_ASPACTUAL>R</A_ASPACTUAL>";
        result+="<A_PRAPRESORTIDA></A_PRAPRESORTIDA>";
        result+="<A_PRAPREPRACTIC></A_PRAPREPRACTIC>";
        result+="<A_PRAEMBPRACTIC></A_PRAEMBPRACTIC>";
        result+="<A_PRAFONDEJAT></A_PRAFONDEJAT>";
        result+="<A_DATCERNOOPERACIO></A_DATCERNOOPERACIO>";
        result+="<A_OPECERNOOPERACIO></A_OPECERNOOPERACIO>";
        result+="<A_PENREVSOLICITUD>N</A_PENREVSOLICITUD>";
        result+="<A_OBSAUTORITZACIO>CEMESA.</A_OBSAUTORITZACIO>";
        result+="<A_IDOPEALTA>ADMINESCALAS</A_IDOPEALTA>";
        result+="<A_IDOPEMODIFICACIO>ADMINESCALAS</A_IDOPEMODIFICACIO>";
        result+="<A_DATALTA>2013-04-16T08:53:11+02:00</A_DATALTA>";
        result+="<A_DATMODIFICACIO>2013-04-25T01:02:37+02:00</A_DATMODIFICACIO>";
        result+="<A_IDPROCALTA>BERMAN</A_IDPROCALTA>";
        result+="<A_IDPROCMODIFICACIO>WSOPPR</A_IDPROCMODIFICACIO>";
        result+="<AE_ASPECTE>R</AE_ASPECTE>";
        result+="<AE_ETA>" + eta + "</AE_ETA>";
        result+="<AE_ETD>" + etd + "</AE_ETD>";
        result+="<AE_CALENTRADA>6</AE_CALENTRADA>";
        result+="<AE_CALSORTIDA>6</AE_CALSORTIDA>";
        result+="<AE_EXEPRACTICATGE>N</AE_EXEPRACTICATGE>";
        result+="<AE_EXEFACTURACIO>N</AE_EXEFACTURACIO>";
        result+="<AE_ESTPROLONGADA>N</AE_ESTPROLONGADA>";
        result+="<AE_AVERIES>N</AE_AVERIES>";
        result+="<AE_OBSERVACIONS>CEMESA</AE_OBSERVACIONS>";
        result+="<OM_OCUPACIO>17040</OM_OCUPACIO>";
        result+="<OM_IDALINEACIO>" + location + "</OM_IDALINEACIO>";
        result+="<OM_IDTIPOOCUPACIO>T</OM_IDTIPOOCUPACIO>";
        result+="<OM_IDVAIXELL>" + shipId + "</OM_IDVAIXELL>";
        result+="<OM_INICI>" + eta + "</OM_INICI>";
        result+="<OM_FI>" + etd + "</OM_FI>";
        result+="<OM_ESLORA>132</OM_ESLORA>";
        result+="<OM_MANEGA></OM_MANEGA>";
        result+="<OM_CALAT>7.31</OM_CALAT>";
        result+="<OM_AJUST></OM_AJUST>";
        result+="<OM_BIAIX></OM_BIAIX>";
        result+="<OM_IDTIPAMARRATGE>AXX</OM_IDTIPAMARRATGE>";
        result+="<OM_MODINICIAL>3</OM_MODINICIAL>";
        result+="<OM_MODFINAL>5</OM_MODFINAL>";
        result+="<OM_IDTERMINAL></OM_IDTERMINAL>";
        result+="<OM_XPROA></OM_XPROA>";
        result+="<OM_YPROA></OM_YPROA>";
        result+="<OM_XPOPA></OM_XPOPA>";
        result+="<OM_YPOPA></OM_YPOPA>";
        result+="<OM_COMENTARIS></OM_COMENTARIS>";
        result+="<OM_IDOPEALTA>ADMINESCALAS</OM_IDOPEALTA>";
        result+="<OM_IDOPEMODIFICACIO>ADMINESCALAS</OM_IDOPEMODIFICACIO>";
        result+="<OM_DATALTA>2013-04-16T08:53:12+02:00</OM_DATALTA>";
        result+="<OM_IDPROCALTA>BERMAN</OM_IDPROCALTA>";
        result+="<OM_IDPROCMODIFICACIO>WSOPPR</OM_IDPROCMODIFICACIO>";
        result+="<OM_GUID>1.99934016E8</OM_GUID>";
        result+="<OM_IDTERADDICIONAL></OM_IDTERADDICIONAL>";
        result+="</ATRACADA>";
        result+="</RECORDSET></SOSTRAT_DATA>";
        
        return result;
    }
}
