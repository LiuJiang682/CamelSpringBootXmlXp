package com.example.springboot;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "WrapperObject",
        namespace = "http://schema.jiang.liu.au",
        propOrder = {"header", "body", "trailer"}
)
public class WrapperObject {
    @XmlElement(
            name = "header",
            required = true
    )
    protected String header;
    @XmlElement(
            name = "body",
            required = true
    )
    protected String body;
    @XmlElement(
            name = "trailer",
            required = true
    )
    protected String trailer;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}
