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
 * <p>Java class for GetClustersRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetClustersRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClusterFilter" type="{urn:qut-edu-au:schema:apromore:manager}ClusterFilterType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetClustersRequestType", propOrder = {
    "clusterFilter"
})
public class GetClustersRequestType
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ClusterFilter", required = true)
    protected ClusterFilterType clusterFilter;

    /**
     * Gets the value of the clusterFilter property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterFilterType }
     *     
     */
    public ClusterFilterType getClusterFilter() {
        return clusterFilter;
    }

    /**
     * Sets the value of the clusterFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterFilterType }
     *     
     */
    public void setClusterFilter(ClusterFilterType value) {
        this.clusterFilter = value;
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
            ClusterFilterType theClusterFilter;
            theClusterFilter = this.getClusterFilter();
            strategy.appendField(locator, this, "clusterFilter", buffer, theClusterFilter);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof GetClustersRequestType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final GetClustersRequestType that = ((GetClustersRequestType) object);
        {
            ClusterFilterType lhsClusterFilter;
            lhsClusterFilter = this.getClusterFilter();
            ClusterFilterType rhsClusterFilter;
            rhsClusterFilter = that.getClusterFilter();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "clusterFilter", lhsClusterFilter), LocatorUtils.property(thatLocator, "clusterFilter", rhsClusterFilter), lhsClusterFilter, rhsClusterFilter)) {
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
            ClusterFilterType theClusterFilter;
            theClusterFilter = this.getClusterFilter();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "clusterFilter", theClusterFilter), currentHashCode, theClusterFilter);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}