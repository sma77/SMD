//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.23 at 04:10:21 PM EST 
//


package org.apromore.pnml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for simulationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="simulationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="simulationname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="simulationdate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="transitionsequence" type="{pnml.apromore.org}transitionsequenceType"/>
 *         &lt;element name="netFingerprint" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simulationType", propOrder = {
    "simulationname",
    "simulationdate",
    "transitionsequence",
    "netFingerprint"
})
public class SimulationType {

    @XmlElement(required = true)
    protected String simulationname;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar simulationdate;
    @XmlElement(required = true)
    protected TransitionsequenceType transitionsequence;
    @XmlElement(required = true)
    protected String netFingerprint;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the simulationname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSimulationname() {
        return simulationname;
    }

    /**
     * Sets the value of the simulationname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSimulationname(String value) {
        this.simulationname = value;
    }

    /**
     * Gets the value of the simulationdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSimulationdate() {
        return simulationdate;
    }

    /**
     * Sets the value of the simulationdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSimulationdate(XMLGregorianCalendar value) {
        this.simulationdate = value;
    }

    /**
     * Gets the value of the transitionsequence property.
     * 
     * @return
     *     possible object is
     *     {@link TransitionsequenceType }
     *     
     */
    public TransitionsequenceType getTransitionsequence() {
        return transitionsequence;
    }

    /**
     * Sets the value of the transitionsequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransitionsequenceType }
     *     
     */
    public void setTransitionsequence(TransitionsequenceType value) {
        this.transitionsequence = value;
    }

    /**
     * Gets the value of the netFingerprint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetFingerprint() {
        return netFingerprint;
    }

    /**
     * Sets the value of the netFingerprint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetFingerprint(String value) {
        this.netFingerprint = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
