# jaxb-episode-project
This is a project illustrates problems using maven-jaxb2-plugin to build model classses from four separate but related schema

Dear Dr. Aleksei Valikov,

I have been attempting to incorporate Episodes and Catalogs to integrate four separate and related XSD schemas into a project using your maven-jaxb2-plugin. I have scoured the documentation, and not being very fluent in XML syntax, bindings and transformation, it has been quite a challenge.

I work with proprietary schema and applications for the Jet Propulsion Laboratory in Pasadena. I distilled my project down to sanitized and very simple schema files, and managed to come up with a solution that _ALMOST_ meets my requirements. I have created this GitHub project so that I can communicate to you my success, and ask if there is any way to solve my other requirements.

The requirement that I had to violate was that I couldn't modify the XML schemas in any way. So, my main question is this:

**Is there a way to affect these schema through build-time binding rather than original schema modification?**
    
Any assistance would be greatly appreciated. Thank you in advance

Anyway, here is how I modified the schema in order to make it work:

1. All four individual, original schemas used the same namespace:
```
    <xs:schema targetNamespace="http://org.test.schema"
	    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns="http://org.test.schema"
      elementFormDefault="qualified">
```

  - They now each use a different one with the same base:
```
    <xs:schema targetNamespace="http://org.test.schema/schema_a"
	    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns="http://org.test.schema/schema_a"
	    elementFormDefault="qualified">
    <xs:schema targetNamespace="http://org.test.schema/schema_b"
	    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns="http://org.test.schema/schema_b"
	    xmlns:a="http://org.test.schema/schema_a"
	    elementFormDefault="qualified">
    <xs:schema targetNamespace="http://org.test.schema/schema_c"
	    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns="http://org.test.schema/schema_c"
	    xmlns:a="http://org.test.schema/schema_a" xmlns:b="http://org.test.schema/schema_b"
	    elementFormDefault="qualified">
    <xs:schema targetNamespace="http://org.test.schema/schema_d"
	    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns="http://org.test.schema/schema_d"
	    xmlns:a="http://org.test.schema/schema_a" xmlns:b="http://org.test.schema/schema_b"
	    elementFormDefault="qualified">

```

2. I had to convert 'include' directives to 'import' directives, for example
```
    <xs:include schemaLocation="schema_a.xsd"/>
    <xs:include schemaLocation="schema_b.xsd"/>
```

  - became:
```
  <xs:import namespace="http://www.jpl.nasa.gov/dsn/0211-SM-SEQ/common"
    schemaLocation="http://www.jpl.nasa.gov/dsn/0211-SM-SEQ/common/0211-CommonTypes-V1.0.0.xsd" />
  <xs:import namespace="http://www.jpl.nasa.gov/dsn/0211-SM-SEQ/profile"
    schemaLocation="http://www.jpl.nasa.gov/dsn/0211-SM-SEQ/profile/0211-SessionProfile-V1.0.0.xsd" />
```
3. And finally, all referenced element types in all schemas now most use the 'schema_a:XXXX' or 'schema_b:YYYY' syntax:
```
	<xs:complexType name="SchemaCComplexType">
		<xs:sequence>
			<xs:element name="schemaAEnum" type="SchemaABasicEnumeration" />
			<xs:element name="schemaBEnum" type="SchemaBComplexType" />
		</xs:sequence>
	</xs:complexType>
```

  - bacame:
```
	<xs:complexType name="SchemaCComplexType">
		<xs:sequence>
			<xs:element name="schemaAEnum" type="a:SchemaABasicEnumeration" />
			<xs:element name="schemaBEnum" type="b:SchemaBComplexType" />
		</xs:sequence>
	</xs:complexType>
```

