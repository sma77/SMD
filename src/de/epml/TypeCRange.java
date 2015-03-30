//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.23 at 04:10:19 PM EST 
//


package de.epml;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typeCRange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="typeCRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice minOccurs="0">
 *         &lt;element name="configuration">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="optionality">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="mnd"/>
 *                       &lt;enumeration value="off"/>
 *                       &lt;enumeration value="opt"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="range">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="node"/>
 *                       &lt;enumeration value="reducedRange"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="goto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                 &lt;attribute name="increment">
 *                   &lt;simpleType>
 *                     &lt;union memberTypes=" {http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;enumeration value="k"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/union>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="decrement">
 *                   &lt;simpleType>
 *                     &lt;union memberTypes=" {http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;enumeration value="k"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/union>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "typeCRange", propOrder = {
    "configuration"
})
public class TypeCRange {

    protected TypeCRange.Configuration configuration;

    /**
     * Gets the value of the configuration property.
     * 
     * @return
     *     possible object is
     *     {@link TypeCRange.Configuration }
     *     
     */
    public TypeCRange.Configuration getConfiguration() {
        return configuration;
    }

    /**
     * Sets the value of the configuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeCRange.Configuration }
     *     
     */
    public void setConfiguration(TypeCRange.Configuration value) {
        this.configuration = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="optionality">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="mnd"/>
     *             &lt;enumeration value="off"/>
     *             &lt;enumeration value="opt"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="range">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="node"/>
     *             &lt;enumeration value="reducedRange"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="goto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *       &lt;attribute name="increment">
     *         &lt;simpleType>
     *           &lt;union memberTypes=" {http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
     *             &lt;simpleType>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                 &lt;enumeration value="k"/>
     *               &lt;/restriction>
     *             &lt;/simpleType>
     *           &lt;/union>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="decrement">
     *         &lt;simpleType>
     *           &lt;union memberTypes=" {http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
     *             &lt;simpleType>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                 &lt;enumeration value="k"/>
     *               &lt;/restriction>
     *             &lt;/simpleType>
     *           &lt;/union>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Configuration {

        @XmlAttribute(name = "optionality")
        protected String optionality;
        @XmlAttribute(name = "range")
        protected String range;
        @XmlAttribute(name = "goto")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger _goto;
        @XmlAttribute(name = "increment")
        protected String increment;
        @XmlAttribute(name = "decrement")
        protected String decrement;

        /**
         * Gets the value of the optionality property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOptionality() {
            return optionality;
        }

        /**
         * Sets the value of the optionality property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOptionality(String value) {
            this.optionality = value;
        }

        /**
         * Gets the value of the range property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRange() {
            return range;
        }

        /**
         * Sets the value of the range property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRange(String value) {
            this.range = value;
        }

        /**
         * Gets the value of the goto property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getGoto() {
            return _goto;
        }

        /**
         * Sets the value of the goto property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setGoto(BigInteger value) {
            this._goto = value;
        }

        /**
         * Gets the value of the increment property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIncrement() {
            return increment;
        }

        /**
         * Sets the value of the increment property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIncrement(String value) {
            this.increment = value;
        }

        /**
         * Gets the value of the decrement property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDecrement() {
            return decrement;
        }

        /**
         * Sets the value of the decrement property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDecrement(String value) {
            this.decrement = value;
        }

    }

}