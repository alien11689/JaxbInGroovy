package com.blogspot.przybyszd.jaxbingroovy

import groovy.transform.EqualsAndHashCode

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.FIELD)
class Person {
    String firstName
    String lastName
    Integer age
}
