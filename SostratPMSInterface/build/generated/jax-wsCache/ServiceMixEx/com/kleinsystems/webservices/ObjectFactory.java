
package com.kleinsystems.webservices;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.kleinsystems.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.kleinsystems.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProcessXmlData }
     * 
     */
    public ProcessXmlData createProcessXmlData() {
        return new ProcessXmlData();
    }

    /**
     * Create an instance of {@link ProcessRawDataResponse }
     * 
     */
    public ProcessRawDataResponse createProcessRawDataResponse() {
        return new ProcessRawDataResponse();
    }

    /**
     * Create an instance of {@link ProcessRawData }
     * 
     */
    public ProcessRawData createProcessRawData() {
        return new ProcessRawData();
    }

    /**
     * Create an instance of {@link ProcessSostratData }
     * 
     */
    public ProcessSostratData createProcessSostratData() {
        return new ProcessSostratData();
    }

    /**
     * Create an instance of {@link ProcessXmlDataResponse }
     * 
     */
    public ProcessXmlDataResponse createProcessXmlDataResponse() {
        return new ProcessXmlDataResponse();
    }

    /**
     * Create an instance of {@link ProcessSostratDataResponse }
     * 
     */
    public ProcessSostratDataResponse createProcessSostratDataResponse() {
        return new ProcessSostratDataResponse();
    }

}
