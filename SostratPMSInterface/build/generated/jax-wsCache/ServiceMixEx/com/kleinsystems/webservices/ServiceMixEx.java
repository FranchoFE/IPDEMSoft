
package com.kleinsystems.webservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServiceMixEx", targetNamespace = "http://kleinsystems.com/webservices/", wsdlLocation = "http://10.132.247.92/Mars.Extension.ServiceMixWeb/ServiceMixEx.asmx?wsdl")
public class ServiceMixEx
    extends Service
{

    private final static URL SERVICEMIXEX_WSDL_LOCATION;
    private final static WebServiceException SERVICEMIXEX_EXCEPTION;
    private final static QName SERVICEMIXEX_QNAME = new QName("http://kleinsystems.com/webservices/", "ServiceMixEx");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://10.132.247.92/Mars.Extension.ServiceMixWeb/ServiceMixEx.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICEMIXEX_WSDL_LOCATION = url;
        SERVICEMIXEX_EXCEPTION = e;
    }

    public ServiceMixEx() {
        super(__getWsdlLocation(), SERVICEMIXEX_QNAME);
    }

    public ServiceMixEx(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICEMIXEX_QNAME, features);
    }

    public ServiceMixEx(URL wsdlLocation) {
        super(wsdlLocation, SERVICEMIXEX_QNAME);
    }

    public ServiceMixEx(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICEMIXEX_QNAME, features);
    }

    public ServiceMixEx(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServiceMixEx(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServiceMixExSoap
     */
    @WebEndpoint(name = "ServiceMixExSoap")
    public ServiceMixExSoap getServiceMixExSoap() {
        return super.getPort(new QName("http://kleinsystems.com/webservices/", "ServiceMixExSoap"), ServiceMixExSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServiceMixExSoap
     */
    @WebEndpoint(name = "ServiceMixExSoap")
    public ServiceMixExSoap getServiceMixExSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://kleinsystems.com/webservices/", "ServiceMixExSoap"), ServiceMixExSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns ServiceMixExSoap
     */
    @WebEndpoint(name = "ServiceMixExSoap12")
    public ServiceMixExSoap getServiceMixExSoap12() {
        return super.getPort(new QName("http://kleinsystems.com/webservices/", "ServiceMixExSoap12"), ServiceMixExSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServiceMixExSoap
     */
    @WebEndpoint(name = "ServiceMixExSoap12")
    public ServiceMixExSoap getServiceMixExSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://kleinsystems.com/webservices/", "ServiceMixExSoap12"), ServiceMixExSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICEMIXEX_EXCEPTION!= null) {
            throw SERVICEMIXEX_EXCEPTION;
        }
        return SERVICEMIXEX_WSDL_LOCATION;
    }

}