//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.23 at 04:10:32 PM EST 
//


package org.apromore.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for SearchForSimilarProcessesOutputMsgType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchForSimilarProcessesOutputMsgType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Result" type="{urn:qut-edu-au:schema:apromore:manager}ResultType"/>
 *         &lt;element name="ProcessSummaries" type="{urn:qut-edu-au:schema:apromore:manager}ProcessSummariesType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchForSimilarProcessesOutputMsgType", propOrder = {
    "result",
    "processSummaries"
})
public class SearchForSimilarProcessesOutputMsgType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "Result", required = true)
    protected ResultType result;
    @XmlElement(name = "ProcessSummaries", required = true)
    protected ProcessSummariesType processSummaries;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link ResultType }
     *     
     */
    public ResultType getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultType }
     *     
     */
    public void setResult(ResultType value) {
        this.result = value;
    }

    /**
     * Gets the value of the processSummaries property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessSummariesType }
     *     
     */
    public ProcessSummariesType getProcessSummaries() {
        return processSummaries;
    }

    /**
     * Sets the value of the processSummaries property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessSummariesType }
     *     
     */
    public void setProcessSummaries(ProcessSummariesType value) {
        this.processSummaries = value;
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            ResultType theResult;
            theResult = this.getResult();
            strategy.appendField(locator, this, "result", buffer, theResult);
        }
        {
            ProcessSummariesType theProcessSummaries;
            theProcessSummaries = this.getProcessSummaries();
            strategy.appendField(locator, this, "processSummaries", buffer, theProcessSummaries);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SearchForSimilarProcessesOutputMsgType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SearchForSimilarProcessesOutputMsgType that = ((SearchForSimilarProcessesOutputMsgType) object);
        {
            ResultType lhsResult;
            lhsResult = this.getResult();
            ResultType rhsResult;
            rhsResult = that.getResult();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "result", lhsResult), LocatorUtils.property(thatLocator, "result", rhsResult), lhsResult, rhsResult)) {
                return false;
            }
        }
        {
            ProcessSummariesType lhsProcessSummaries;
            lhsProcessSummaries = this.getProcessSummaries();
            ProcessSummariesType rhsProcessSummaries;
            rhsProcessSummaries = that.getProcessSummaries();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "processSummaries", lhsProcessSummaries), LocatorUtils.property(thatLocator, "processSummaries", rhsProcessSummaries), lhsProcessSummaries, rhsProcessSummaries)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            ResultType theResult;
            theResult = this.getResult();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "result", theResult), currentHashCode, theResult);
        }
        {
            ProcessSummariesType theProcessSummaries;
            theProcessSummaries = this.getProcessSummaries();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "processSummaries", theProcessSummaries), currentHashCode, theProcessSummaries);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
