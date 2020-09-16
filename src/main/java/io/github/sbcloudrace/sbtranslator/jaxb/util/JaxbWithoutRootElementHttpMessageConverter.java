package io.github.sbcloudrace.sbtranslator.jaxb.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.xml.AbstractJaxb2HttpMessageConverter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.annotation.Annotation;

public class JaxbWithoutRootElementHttpMessageConverter extends AbstractJaxb2HttpMessageConverter<Object> {
    @Override
    protected Object readFromSource(Class<?> aClass, HttpHeaders httpHeaders, Source source) throws Exception {
        Object objTmp = null;
        try {
            StreamSource streamSource = (StreamSource) source;
            InputStream is = streamSource.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            JAXBContext jaxbContext = JAXBContext.newInstance(aClass);
            javax.xml.bind.Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            XMLStreamReader xsr = XMLInputFactory.newFactory().createXMLStreamReader(inputStreamReader);
            XMLReaderWithoutNamespace xr = new XMLReaderWithoutNamespace(xsr);
            JAXBElement<Object> jaxbElement = (JAXBElement<Object>) jaxbUnmarshaller.unmarshal(xr, aClass);
            objTmp = jaxbElement.getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objTmp;
    }

    @Override
    protected void writeToResult(Object o, HttpHeaders httpHeaders, Result result) throws Exception {
        // TODO move it to another converter, and add into configureMessageConverters
        // used in DebugController and DriverPersona/DeletePersona
        if (o instanceof String) {
            StreamResult streamResult = (StreamResult) result;
            streamResult.getOutputStream().write(((String) o).getBytes());
            return;
        }
        //TODO move it to another converter, and add into configureMessageConverters
        if (o instanceof RuntimeException) {
            RuntimeException exception = (RuntimeException) o;
            StreamResult streamResult = (StreamResult) result;
            streamResult.getOutputStream().write(exception.getMessage().getBytes());
            return;
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(o.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

        //this fix ClientConfigTrans and PersonaFriendsList
        Annotation[] annotations = o.getClass().getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof XsiSchemaLocation) {
                XsiSchemaLocation schemaAnnotation = (XsiSchemaLocation) annotation;
                String schemaLocation = schemaAnnotation.schemaLocation();
                jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schemaLocation);
            }
        }
        XmlType xmlTypeAnnotation = o.getClass().getAnnotation(XmlType.class);
        QName qname = new QName("", xmlTypeAnnotation.name());
        StringWriter stringWriter = new StringWriter();
        JAXBElement<Object> jaxbElement = new JAXBElement<Object>(qname, (Class<Object>) o.getClass(), null, o);
        jaxbMarshaller.marshal(jaxbElement, stringWriter);
        StreamResult streamResult = (StreamResult) result;
        streamResult.getOutputStream().write(stringWriter.toString().getBytes());
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return true;
    }
}
