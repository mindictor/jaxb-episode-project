//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.02.21 at 03:21:21 PM PST 
//


package org.test.schema.schema_c.jaxb2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.test.schema.schema_a.jaxb2.SchemaABasicEnumeration;
import org.test.schema.schema_b.jaxb2.SchemaBComplexType;


/**
 * <p>Java class for SchemaCComplexType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SchemaCComplexType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="schemaAEnum" type="{http://org.test.schema/schema_a}SchemaABasicEnumeration"/&gt;
 *         &lt;element name="schemaBEnum" type="{http://org.test.schema/schema_b}SchemaBComplexType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchemaCComplexType", propOrder = {
    "schemaAEnum",
    "schemaBEnum"
})
@XmlRootElement(name = "schemaCComplexType")
public class SchemaCComplexType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SchemaABasicEnumeration schemaAEnum;
    @XmlElement(required = true)
    protected SchemaBComplexType schemaBEnum;

    /**
     * Gets the value of the schemaAEnum property.
     * 
     * @return
     *     possible object is
     *     {@link SchemaABasicEnumeration }
     *     
     */
    public SchemaABasicEnumeration getSchemaAEnum() {
        return schemaAEnum;
    }

    /**
     * Sets the value of the schemaAEnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemaABasicEnumeration }
     *     
     */
    public void setSchemaAEnum(SchemaABasicEnumeration value) {
        this.schemaAEnum = value;
    }

    /**
     * Gets the value of the schemaBEnum property.
     * 
     * @return
     *     possible object is
     *     {@link SchemaBComplexType }
     *     
     */
    public SchemaBComplexType getSchemaBEnum() {
        return schemaBEnum;
    }

    /**
     * Sets the value of the schemaBEnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemaBComplexType }
     *     
     */
    public void setSchemaBEnum(SchemaBComplexType value) {
        this.schemaBEnum = value;
    }

}