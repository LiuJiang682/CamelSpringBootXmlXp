package com.example.springboot;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

@Component
public class XmlProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
//        parsePlainString(exchange);
        parseWrapperObject(exchange);
    }

    private void parseWrapperObject(Exchange exchange) {
        WrapperObject wrapperObject = exchange.getIn().getBody(WrapperObject.class);
        System.out.println(wrapperObject.getHeader());
        System.out.println(wrapperObject.getBody());
        System.out.println(wrapperObject.getTrailer());
    }

    private void parsePlainString(final Exchange exchange) throws Exception {
        final String payload = exchange.getIn().getBody(String.class);
        System.out.println(payload);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//                documentBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ""); // Compliant
//                documentBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); // compliant
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new InputSource(new StringReader(payload)));
        System.out.println(document.getTextContent());
        DOMSource domSource = new DOMSource(document);
        System.out.println(domSource.toString());
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.transform(domSource, result);
        System.out.println("XML IN String format is: \n" + writer.toString());
    }
}
