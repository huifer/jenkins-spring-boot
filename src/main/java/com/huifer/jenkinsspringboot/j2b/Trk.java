
package com.huifer.jenkinsspringboot.j2b;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.topografix.com/GPX/1/0}name"/&gt;
 *         &lt;element ref="{http://www.topografix.com/GPX/1/0}trkseg"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "trkseg"
})
@XmlRootElement(name = "trk")
public class Trk {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected Trkseg trkseg;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the trkseg property.
     * 
     * @return
     *     possible object is
     *     {@link Trkseg }
     *     
     */
    public Trkseg getTrkseg() {
        return trkseg;
    }

    /**
     * Sets the value of the trkseg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Trkseg }
     *     
     */
    public void setTrkseg(Trkseg value) {
        this.trkseg = value;
    }

}
