
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
 *         &lt;element name="ProcessSostratDataResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "processSostratDataResult"
})
@XmlRootElement(name = "ProcessSostratDataResponse")
public class ProcessSostratDataResponse {

    @XmlElement(name = "ProcessSostratDataResult")
    protected int processSostratDataResult;

    /**
     * Gets the value of the processSostratDataResult property.
     * 
     */
    public int getProcessSostratDataResult() {
        return processSostratDataResult;
    }

    /**
     * Sets the value of the processSostratDataResult property.
     * 
     */
    public void setProcessSostratDataResult(int value) {
        this.processSostratDataResult = value;
    }

}