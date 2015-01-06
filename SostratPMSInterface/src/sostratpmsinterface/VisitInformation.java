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
public class VisitInformation {
    public String shipId;
    public String initialPort;
    public String endPort;
    public String visitYear;
    public String visitNumber;
    
    public String visitAgent = "002083";
    
    public String entryCrew = "1";
    public String exitCrew = "2";
    public String entryPassengers = "3";
    public String exitPassengers = "4";
    public String exitCaptain = "felez";
    public String entryCaptain = "esteban";
    
    public String mmppLoad = "S";
    public String mmppUnload = "S";
    public String mmppTransit = "S";
    public String mmpp = "N";
    
    public String isps = "S";
    public String ispsDate = "2015-11-08T00:00:00+01:00";
    public String ispsLevel = "1";
    public String ispsProcedures = "S";
    public String ispsProtection = "";
    public String ispsAlternatives = "";
    
    public String parseInformation()
    {
        String result = "<SOSTRAT_DATA>\n";
        result+="<HEADER>\n";
        result+="<TYPE>RECORDSET</TYPE>\n";
        result+="<ACTION>UPDATE</ACTION>\n";
        result+="<OBJECTNAME>ESCALA</OBJECTNAME></HEADER>\n";
        result+="<RECORDSET>\n";
        result+="<ESCALA>\n";
        result+="<ESC_IDSUBPORT></ESC_IDSUBPORT>\n";
        result+="<ESC_ANYESCALA>" + visitYear + "</ESC_ANYESCALA>\n";
        result+="<ESC_NUMESCALA>" + visitNumber + "</ESC_NUMESCALA>\n";
        result+="<ESC_IDESTOPERATIU>" + "F" + "</ESC_IDESTOPERATIU>\n";
        result+="<ESC_ASPACTUAL></ESC_ASPACTUAL>\n";
        result+="<ESC_IDSERVEI></ESC_IDSERVEI>\n";
        result+="<ESC_DATSOLICITUD></ESC_DATSOLICITUD>\n";
        result+="<ESC_DATCONFIRMACIO></ESC_DATCONFIRMACIO>\n";
        result+="<ESC_DATAUTORITZACIO></ESC_DATAUTORITZACIO>\n";
        result+="<ESC_DATSOLDESSORTIDA></ESC_DATSOLDESSORTIDA>\n";
        result+="<ESC_DATDESSORTIDA></ESC_DATDESSORTIDA>\n";
        result+="<ESC_DATANULACIO></ESC_DATANULACIO>\n";
        result+="<ESC_DATDENEGACIO></ESC_DATDENEGACIO>\n";
        result+="<ESC_DATACTIVACIO></ESC_DATACTIVACIO>\n";
        result+="<ESC_PERLIQUIDACIO></ESC_PERLIQUIDACIO>\n";
        result+="<ESC_IDESTFACTURACIO></ESC_IDESTFACTURACIO>\n";
        result+="<ESC_DATULTFACTURACIO></ESC_DATULTFACTURACIO>\n";
        result+="<ESC_BASEPORT></ESC_BASEPORT>\n";
        result+="<ESC_DATRECCAPITANIA></ESC_DATRECCAPITANIA>\n";
        result+="<ESC_CAPAUTDENEGADA></ESC_CAPAUTDENEGADA>\n";
        result+="<ESC_DATCAPITANIA></ESC_DATCAPITANIA>\n";
        result+="<ESC_OBSERVACIONS></ESC_OBSERVACIONS>\n";
        result+="<ESC_EXEISPS></ESC_EXEISPS>\n";
        result+="<ESC_EXEFACL0L1></ESC_EXEFACL0L1>\n";
        result+="<ESC_EXEFACL7></ESC_EXEFACL7>\n";
        result+="<ESC_PENREVSOLICITUD></ESC_PENREVSOLICITUD>\n";
        result+="<ESC_NUMESCSERMARITIM></ESC_NUMESCSERMARITIM>\n";
        result+="<ESC_NUMESCVAIXELL></ESC_NUMESCVAIXELL>\n";
        result+="<ESC_NUMESCARMADOR></ESC_NUMESCARMADOR>\n";
        result+="<ESC_IDOPEALTA></ESC_IDOPEALTA>\n";
        result+="<ESC_IDOPEMODIFICACIO></ESC_IDOPEMODIFICACIO>\n";
        result+="<ESC_DATALTA></ESC_DATALTA>\n";
        result+="<ESC_DATMODIFICACIO></ESC_DATMODIFICACIO>\n";
        result+="<ESC_IDPROCALTA></ESC_IDPROCALTA>\n";
        result+="<ESC_IDPROCMODIFICACIO></ESC_IDPROCMODIFICACIO>\n";
        result+="<ESC_FACRESDESCOMPTE></ESC_FACRESDESCOMPTE>\n";
        result+="<ESC_GUID></ESC_GUID>\n";
        result+="<ESC_NUMTEUSESCALA></ESC_NUMTEUSESCALA>\n";
        result+="<ESC_IDTIPUSRESIDUS></ESC_IDTIPUSRESIDUS>\n";
        result+="<ESCA_ASPECTE>" + "R" + "</ESCA_ASPECTE>\n";
        result+="<ESCA_IDVAIXELL>" + shipId + "</ESCA_IDVAIXELL>\n";
        result+="<ESCA_PORTORIGEN>" + initialPort + "</ESCA_PORTORIGEN>\n";
        result+="<ESCA_PORTDESTI>" + endPort + "</ESCA_PORTDESTI>\n";
        result+="<ESCA_ETA></ESCA_ETA>\n";
        result+="<ESCA_ETD></ESCA_ETD>\n";
        result+="<ESCA_IDARMADOR></ESCA_IDARMADOR>\n";
        result+="<ESCA_IDCONSIGNATARI>" + visitAgent + "</ESCA_IDCONSIGNATARI>\n";
        result+="<ESCA_IDSERMARITIM></ESCA_IDSERMARITIM>\n";
        result+="<ESCA_PORTREGISTRE></ESCA_PORTREGISTRE>\n";
        result+="<ESCA_DATCONSTRUCCIO></ESCA_DATCONSTRUCCIO>\n";
        result+="<ESCA_DESTEMPORT></ESCA_DESTEMPORT>\n";
        result+="<ESCA_DESTEMDATVIGENCIA></ESCA_DESTEMDATVIGENCIA>\n";
        result+="<ESCA_DESTEMDATFI></ESCA_DESTEMDATFI>\n";
        result+="<ESCA_ACORESSOLIDS></ESCA_ACORESSOLIDS>\n";
        result+="<ESCA_IDACORESSOLIDS></ESCA_IDACORESSOLIDS>\n";
        result+="<ESCA_ACOEMPRESSOLIDS></ESCA_ACOEMPRESSOLIDS>\n";
        result+="<ESCA_ACOPORTRESSOLIDS></ESCA_ACOPORTRESSOLIDS>\n";
        result+="<ESCA_ACORESLIQUIDS></ESCA_ACORESLIQUIDS>\n";
        result+="<ESCA_IDACORESLIQUIDS></ESCA_IDACORESLIQUIDS>\n";
        result+="<ESCA_ACOEMPRESLIQUIDS></ESCA_ACOEMPRESLIQUIDS>\n";
        result+="<ESCA_ACOPORTRESLIQUIDS></ESCA_ACOPORTRESLIQUIDS>\n";
        result+="<ESCA_OBSEDI></ESCA_OBSEDI>\n";
        result+="<ESCA_DECCAPITA></ESCA_DECCAPITA>\n";
        result+="<ESCA_ESTFESTIU></ESCA_ESTFESTIU>\n";
        result+="<ESCA_TRAFUEL></ESCA_TRAFUEL>\n";
        result+="<ESCA_MOUINS></ESCA_MOUINS>\n";
        result+="<ESCA_MOUPORT></ESCA_MOUPORT>\n";
        result+="<ESCA_MOUDATDARINS></ESCA_MOUDATDARINS>\n";
        result+="<ESCA_MOUDEFPEN></ESCA_MOUDEFPEN>\n";
        result+="<ESCA_NUMTRIENTRADA>" + entryCrew + "</ESCA_NUMTRIENTRADA>\n";
        result+="<ESCA_NUMTRISORTIDA>" + exitCrew + "</ESCA_NUMTRISORTIDA>\n";
        result+="<ESCA_NUMPOLENTRADA></ESCA_NUMPOLENTRADA>\n";
        result+="<ESCA_NUMPOLSORTIDA></ESCA_NUMPOLSORTIDA>\n";
        result+="<ESCA_NUMPASENTRADA>" + entryPassengers + "</ESCA_NUMPASENTRADA>\n";
        result+="<ESCA_NUMPASSORTIDA>" + exitPassengers + "</ESCA_NUMPASSORTIDA>\n";
        result+="<ESCA_ARMNOM></ESCA_ARMNOM>\n";
        result+="<ESCA_ARMDOMICILI></ESCA_ARMDOMICILI>\n";
        result+="<ESCA_ARMCIUTAT></ESCA_ARMCIUTAT>\n";
        result+="<ESCA_ARMREGIO></ESCA_ARMREGIO>\n";
        result+="<ESCA_ARMCODPOSTAL></ESCA_ARMCODPOSTAL>\n";
        result+="<ESCA_ARMPAIS></ESCA_ARMPAIS>\n";
        result+="<ESCA_VAITIPUSEDI></ESCA_VAITIPUSEDI>\n";
        result+="<ESCA_VAITIPDETALL></ESCA_VAITIPDETALL>\n";
        result+="<ESCA_CAPNOMENTRADA>" + entryCaptain + "</ESCA_CAPNOMENTRADA>\n";
        result+="<ESCA_CAPNOMSORTIDA>" + exitCaptain + "</ESCA_CAPNOMSORTIDA>\n";
        result+="<ESCA_VAICODIMO></ESCA_VAICODIMO>\n";
        result+="<ESCA_VAINOM></ESCA_VAINOM>\n";
        result+="<ESCA_VAIPAIS></ESCA_VAIPAIS>\n";
        result+="<ESCA_VAICALLSIGN></ESCA_VAICALLSIGN>\n";
        result+="<ESCA_VAIASSCLUBPI></ESCA_VAIASSCLUBPI>\n";
        result+="<ESCA_VAIASSCASC></ESCA_VAIASSCASC>\n";
        result+="<ESCA_VAISOCCLASSIFICACIO></ESCA_VAISOCCLASSIFICACIO>\n";
        result+="<ESCA_VAICALMAXIM></ESCA_VAICALMAXIM>\n";
        result+="<ESCA_VAIMANEGA></ESCA_VAIMANEGA>\n";
        result+="<ESCA_VAIESLTOTAL></ESCA_VAIESLTOTAL>\n";
        result+="<ESCA_VAIPUNTAL></ESCA_VAIPUNTAL>\n";
        result+="<ESCA_VAIGT></ESCA_VAIGT>\n";
        result+="<ESCA_VAITPM></ESCA_VAITPM>\n";
        result+="<ESCA_VAIARBORADURA></ESCA_VAIARBORADURA>\n";
        result+="<ESCA_VAIPOTENCIA></ESCA_VAIPOTENCIA>\n";
        result+="<ESCA_VAIVELCREUER></ESCA_VAIVELCREUER>\n";
        result+="<ESCA_VAIVELMAXIMA></ESCA_VAIVELMAXIMA>\n";
        result+="<ESCA_VAITANCLLASTSEGREGATS></ESCA_VAITANCLLASTSEGREGATS>\n";
        result+="<ESCA_VAIHELIXS></ESCA_VAIHELIXS>\n";
        result+="<ESCA_VAISITHELIXS></ESCA_VAISITHELIXS>\n";
        result+="<ESCA_VAILONRAMPA1></ESCA_VAILONRAMPA1>\n";
        result+="<ESCA_VAIAMPRAMPA1></ESCA_VAIAMPRAMPA1>\n";
        result+="<ESCA_VAISITRAMPA1></ESCA_VAISITRAMPA1>\n";
        result+="<ESCA_VAILONRAMPA2></ESCA_VAILONRAMPA2>\n";
        result+="<ESCA_VAIAMPRAMPA2></ESCA_VAIAMPRAMPA2>\n";
        result+="<ESCA_VAISITRAMPA2></ESCA_VAISITRAMPA2>\n";
        result+="<ESCA_VAILONRAMPA3></ESCA_VAILONRAMPA3>\n";
        result+="<ESCA_VAIAMPRAMPA3></ESCA_VAIAMPRAMPA3>\n";
        result+="<ESCA_VAISITRAMPA3></ESCA_VAISITRAMPA3>\n";
        result+="<ESCA_VAILONRAMPA4></ESCA_VAILONRAMPA4>\n";
        result+="<ESCA_VAIAMPRAMPA4></ESCA_VAIAMPRAMPA4>\n";
        result+="<ESCA_VAISITRAMPA4></ESCA_VAISITRAMPA4>\n";
        result+="<ESCA_VAILONRAMPA5></ESCA_VAILONRAMPA5>\n";
        result+="<ESCA_VAIAMPRAMPA5></ESCA_VAIAMPRAMPA5>\n";
        result+="<ESCA_VAISITRAMPA5></ESCA_VAISITRAMPA5>\n";
        result+="<ESCA_VAILLASTBRUT></ESCA_VAILLASTBRUT>\n";
        result+="<ESCA_VAITANCFANG></ESCA_VAITANCFANG>\n";
        result+="<ESCA_VAITANCAIGUAOLEOSA></ESCA_VAITANCAIGUAOLEOSA>\n";
        result+="<ESCA_VAIAIGUABRUTA></ESCA_VAIAIGUABRUTA>\n";
        result+="<ESCA_VAIESCOMBRERIES></ESCA_VAIESCOMBRERIES>\n";
        result+="<ESCA_MMPPCARREGA>" + mmppLoad + "</ESCA_MMPPCARREGA>\n";
        result+="<ESCA_MMPPDESCARREGA>" + mmppUnload + "</ESCA_MMPPDESCARREGA>\n";
        result+="<ESCA_MMPPTRANSIT>" + mmppTransit + "</ESCA_MMPPTRANSIT>\n";
        result+="<ESCA_MMPPNO>" + mmpp + "</ESCA_MMPPNO>\n";
        result+="<ESCA_NMI></ESCA_NMI>\n";
        result+="<ESCA_DOBLECASC></ESCA_DOBLECASC>\n";
        result+="<ESCA_MOVTRANSPORT></ESCA_MOVTRANSPORT>\n";
        result+="<ESCA_CERARQUEIG></ESCA_CERARQUEIG>\n";
        result+="<ESCA_DATCERARQUEIG></ESCA_DATCERARQUEIG>\n";
        result+="<ESCA_ISPS>" + isps + "</ESCA_ISPS>\n";
        result+="<ESCA_ISPSDATCADUCITAT>" + ispsDate + "</ESCA_ISPSDATCADUCITAT>\n";
        result+="<ESCA_ISPSNIVEL>" + ispsLevel + "</ESCA_ISPSNIVEL>\n";
        result+="<ESCA_ISPS10ULT></ESCA_ISPS10ULT>\n";
        result+="<ESCA_ISPSPROCEDIMENTS>" + ispsProcedures + "</ESCA_ISPSPROCEDIMENTS>\n";
        result+="<ESCA_ISPSCERTIFICADOR></ESCA_ISPSCERTIFICADOR>\n";
        result+="<ESCA_ISPSNIVCOMENTARIS></ESCA_ISPSNIVCOMENTARIS>\n";
        result+="<ESCA_ISPSDETMESPROTECCIO>" + ispsProtection + "</ESCA_ISPSDETMESPROTECCIO>\n";
        result+="<ESCA_ISPSDETMESALTERNATIVES>" + ispsAlternatives + "</ESCA_ISPSDETMESALTERNATIVES>\n";
        result+="<ESCA_FACRECRESIDUS></ESCA_FACRECRESIDUS>\n";
        result+="<ESCA_IGSPRESENTAT></ESCA_IGSPRESENTAT>\n";
        result+="<ESCA_IGSVIGENCIA></ESCA_IGSVIGENCIA>\n";
        result+="<ESCA_EXEMPTRECOLLIDA></ESCA_EXEMPTRECOLLIDA>\n";
        result+="<ESCA_CARENTRADA></ESCA_CARENTRADA>\n";
        result+="<ESCA_ARMNAVILIERA></ESCA_ARMNAVILIERA>\n";
        result+="<ESCA_VAINUMTLS></ESCA_VAINUMTLS>\n";
        result+="<ESCA_MOUINSAMPLIADA></ESCA_MOUINSAMPLIADA>\n";
        result+="<ESCA_TRANSMERCREGLAMEN></ESCA_TRANSMERCREGLAMEN>\n";
        result+="<ESCA_VAIVOLUMNCARREGA></ESCA_VAIVOLUMNCARREGA>\n";
        result+="<ESCA_TANCSCARREGA></ESCA_TANCSCARREGA>\n";
        result+="<ESCA_TANCSLASTRE></ESCA_TANCSLASTRE>\n";
        result+="<ESCA_RECONINSOBLIGPREV></ESCA_RECONINSOBLIGPREV>\n";
        result+="<ESCA_VAITIPUS></ESCA_VAITIPUS>\n";
        result+="<ESCA_CARSORTIDA></ESCA_CARSORTIDA>\n";
        result+="<ESCA_AUTCABOT></ESCA_AUTCABOT></ESCALA></RECORDSET></SOSTRAT_DATA>";
        
        return result;
    }
    
}
