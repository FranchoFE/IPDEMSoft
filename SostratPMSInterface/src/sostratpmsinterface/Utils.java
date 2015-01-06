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
class Utils {
    
    private static final String sessionId = "{C3D7DD4D-FE66-4a85-8573-5D7D175FB101}";
    private static final String processorId = "sm_sostratData";
    
    static void SendVisitData(VisitInformation visitInformation) 
    {
        String xmlMsg=visitInformation.parseInformation();
        processSostratData(sessionId, processorId, xmlMsg);
    }

    private static int processSostratData(java.lang.String sessionId, java.lang.String processorId, java.lang.String xmlMsg) {
        com.kleinsystems.webservices.ServiceMixEx service = new com.kleinsystems.webservices.ServiceMixEx();
        com.kleinsystems.webservices.ServiceMixExSoap port = service.getServiceMixExSoap12();
        return port.processSostratData(sessionId, processorId, xmlMsg);
    }

    static void SendLocationData(LocationInformation locationInformation) 
    {
        String xmlMsg=locationInformation.parseInformation();
        processSostratData(sessionId, processorId, xmlMsg);
    }

    static void SendStopData(StopInformation stopInformation) 
    {
        String xmlMsg=stopInformation.parseInformation();
        processSostratData(sessionId, processorId, xmlMsg);
    }
    
    
}
