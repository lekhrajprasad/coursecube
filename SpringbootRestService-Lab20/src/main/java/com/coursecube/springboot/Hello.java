package com.coursecube.springboot;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hello {
    String name;
    String message;

    public Hello() {
    }

    public Hello(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
