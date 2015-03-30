//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.23 at 04:10:19 PM EST 
//


package de.epml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typeCoordinates complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="typeCoordinates">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.epml.de}tExtensibleElements">
 *       &lt;attribute name="xOrigin" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="leftToRight"/>
 *             &lt;enumeration value="rightToLeft"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="yOrigin" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="topToBottom"/>
 *             &lt;enumeration value="bottomToTop"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "typeCoordinates")
public class TypeCoordinates
    extends TExtensibleElements
{

    @XmlAttribute(name = "xOrigin", required = true)
    protected String xOrigin;
    @XmlAttribute(name = "yOrigin", required = true)
    protected String yOrigin;

    /**
     * Gets the value of the xOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXOrigin() {
        return xOrigin;
    }

    /**
     * Sets the value of the xOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXOrigin(String value) {
        this.xOrigin = value;
    }

    /**
     * Gets the value of the yOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYOrigin() {
        return yOrigin;
    }

    /**
     * Sets the value of the yOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYOrigin(String value) {
        this.yOrigin = value;
    }

}
