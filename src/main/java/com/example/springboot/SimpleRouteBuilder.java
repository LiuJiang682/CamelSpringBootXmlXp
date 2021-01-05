package com.example.springboot;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleRouteBuilder extends RouteBuilder {

    @Autowired
    private XmlProcessor xmlProcessor;

    @Override
    public void configure() throws Exception {
        from("activemq:event")
                .process(xmlProcessor)
                .to("log:sample");

//        from("timer:bar")
//                .setBody(constant("Hello from Camel"))
//                .to("activemq:foo");
    }

//    @Override
//    public RouteBuilder buildRoute() {
//
//    }
}
