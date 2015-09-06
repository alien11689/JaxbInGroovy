package com.blogspot.przybyszd.jaxbingroovy

import groovy.util.slurpersupport.GPathResult
import spock.lang.Specification

import javax.xml.bind.JAXBContext

class PersonJaxbTest extends Specification {

    def 'should unmarshall person xml to object'() {
    given:
        JAXBContext jc = JAXBContext.newInstance(Person)
        String xml = '<person><firstName>John</firstName><lastName>Smith</lastName><age>20</age></person>'
    expect:
        jc.createUnmarshaller().unmarshal(new StringReader(xml)) == new Person(firstName: 'John', lastName: 'Smith', age: 20)
    }

def 'should marshall person'() {
    given:
        JAXBContext jc = JAXBContext.newInstance(Person)
        Person p = new Person(firstName: 'John', lastName: 'Smith', age: 20)
        StringWriter sw = new StringWriter()
    when:
        jc.createMarshaller().marshal(p, sw)
    then:
        String xml = sw.toString()
        GPathResult gPathResult = new XmlSlurper().parseText(xml)
        gPathResult.name() == 'person'
        gPathResult.firstName == 'John'
        gPathResult.lastName == 'Smith'
        gPathResult.age == '20'
}
}
