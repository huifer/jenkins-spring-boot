
package com.huifer.jenkinsspringboot.j2b;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.topografix.gpx._1._0 package. 
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

    private final static QName _Ele_QNAME = new QName("http://www.topografix.com/GPX/1/0", "ele");
    private final static QName _Time_QNAME = new QName("http://www.topografix.com/GPX/1/0", "time");
    private final static QName _Name_QNAME = new QName("http://www.topografix.com/GPX/1/0", "name");
    private final static QName _Desc_QNAME = new QName("http://www.topografix.com/GPX/1/0", "desc");
    private final static QName _Keywords_QNAME = new QName("http://www.topografix.com/GPX/1/0", "keywords");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.topografix.gpx._1._0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Trkpt }
     *
     */
    public Trkpt createTrkpt() {
        return new Trkpt();
    }

    /**
     * Create an instance of {@link Trkseg }
     *
     */
    public Trkseg createTrkseg() {
        return new Trkseg();
    }

    /**
     * Create an instance of {@link Trk }
     *
     */
    public Trk createTrk() {
        return new Trk();
    }

    /**
     * Create an instance of {@link Gpx }
     *
     */
    public Gpx createGpx() {
        return new Gpx();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.topografix.com/GPX/1/0", name = "ele")
    public JAXBElement<String> createEle(String value) {
        return new JAXBElement<String>(_Ele_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.topografix.com/GPX/1/0", name = "time")
    public JAXBElement<String> createTime(String value) {
        return new JAXBElement<String>(_Time_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.topografix.com/GPX/1/0", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.topografix.com/GPX/1/0", name = "desc")
    public JAXBElement<String> createDesc(String value) {
        return new JAXBElement<String>(_Desc_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.topografix.com/GPX/1/0", name = "keywords")
    public JAXBElement<String> createKeywords(String value) {
        return new JAXBElement<String>(_Keywords_QNAME, String.class, null, value);
    }

}
