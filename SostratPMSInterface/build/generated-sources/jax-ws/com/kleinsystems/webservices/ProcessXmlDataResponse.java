
package com.kleinsystems.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProcessXmlDataResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "processXmlDataResult"
})
@XmlRootElement(name = "ProcessXmlDataResponse")
public class ProcessXmlDataResponse {

    @XmlElement(name = "ProcessXmlDataResult")
    protected int processXmlDataResult;

    /**
     * Gets the value of the processXmlDataResult property.
     * 
     */
    public int getProcessXmlDataResult() {
        return processXmlDataResult;
    }

    /**
     * Sets the value of the processXmlDataResult property.
     * 
     */
    public void setProcessXmlDataResult(int value) {
        this.processXmlDataResult = value;
    }

}
