# <center>SOAP ENDPOINT</center>
# Getting Started with Spring Initializr

1. Navigate to [Spring Initializr](https://start.spring.io). This service pulls in all the dependencies you need for an application and does most of the setup for you.

2. Choose either Gradle or Maven and the language you want to use. This guide assumes that you chose Java.

3. Click on "Dependencies" and select "Spring Web" and "Spring Web Services".

4. Click "Generate".

5. Download the resulting ZIP file, which is an archive of a web application configured with your choices.

Add the Spring-WS dependency
The project needs to include spring-ws-core and wsdl4j as dependencies in your build file.

The following example shows the changes you need to make to the pom.xml file if you use Maven:

```xml
<dependency>
    <groupId>wsdl4j</groupId>
    <artifactId>wsdl4j</artifactId>
</dependency>
```

## creating XML SCHEMA to define the Domain
This must be in src/main/resources/{name for your xsd}.xsd later this will be exported as wsdl

## <u>my xsd definition </u>:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
           xmlns:tns="http://superdev.io/student-service"
           targetNamespace="http://superdev.io/student-service"
           elementFormDefault="qualified">

    <xs:element name="getStudentRequest">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="id" type="xs:int"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:element name="getStudentResponse">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="student" type="tns:student"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

    <xs:complexType name="student">
        <xs:sequence>
            <xs:element name="id" type="xs:int"/>
            <xs:element name="studentNumber" type="xs:string"/>
            <xs:element name="grade" type="xs:int"/>
        </xs:sequence>
    </xs:complexType>

</xs:schema>

```
## Generating classes using the plugin

```xml
<plugin>
	<groupId>org.codehaus.mojo</groupId>
	<artifactId>jaxb2-maven-plugin</artifactId>
	<version>3.1.0</version>
	<executions>
		<execution>
			<id>xjc</id>
			<goals>
				<goal>xjc</goal>
			</goals>
		</execution>
	</executions>
	<configuration>
		<sources>
			<source>${project.basedir}/src/main/resources/countries.xsd</source>
		</sources>
	</configuration>
</plugin>
```

# Endpoint java
The ``` @Endpoint``` annotation registers the class with Spring WS as a potential candidate for processing incoming SOAP messages.

The ```@PayloadRoot``` annotation is then used by Spring WS to pick the handler method, based on the message’s namespace and localPart.

The ```@RequestPayload``` annotation indicates that the incoming message will be mapped to the method’s request parameter.

The ```@ResponsePayload``` annotation makes Spring WS map the returned value to the response payload.


# Web Service Config java
Spring WS uses a different servlet type for handling SOAP messages: ```MessageDispatcherServlet```. It is important to inject and set ApplicationContext to ```MessageDispatcherServlet```. Without that, Spring WS will not automatically detect Spring beans.

Naming this bean ```messageDispatcherServlet``` does not replace Spring Boot’s default DispatcherServlet bean.

```DefaultMethodEndpointAdapter``` configures the annotation-driven Spring WS programming model. This makes it possible to use the various annotations, such as @Endpoint (mentioned earlier).

```DefaultWsdl11Definition``` exposes a standard WSDL 1.1 by using XsdSchema

You need to specify bean names for MessageDispatcherServlet and DefaultWsdl11Definition. Bean names determine the URL under which the web service and the generated WSDL file are available. In this case, the WSDL will be available under ```http://<host>:<port>/ws/student.wsdl```.
This configuration also uses the WSDL location servlet transformation: servlet.setTransformWsdlLocations(true). If you visit ```http://localhost:8080/ws/student.wsdl```, the soap:address will have the proper address. If you instead visit the WSDL from the public facing IP address assigned to your machine, you will see that address instead.

# Testing
```bash
# Use data from file
curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws
```
