package JavaPVT.HW_19_1;

/*
С помощью Stax считать список email-ов, создать список соответствующих
объектов Java и вывести его на консоль. Файл emails.xml
 */

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLStaxParser {

    public static void main(String[] args) {
        String fileName = "emails.xml";
        List<Email> emailsList = parseXMLFile(fileName);
        for (Email email : emailsList) {
            System.out.println(email.toString());
        }
    }

    private static List<Email> parseXMLFile(String fileName) {
        List<Email> emailsList = new ArrayList<>();
        Email email = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "email":
                            email = new Email();
                            Attribute idAttr = startElement.getAttributeByName(new QName("important"));
                            email.setImportant(idAttr.getValue());
                            break;
                        case "id":
                            xmlEvent = reader.nextEvent();
                            email.setId(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            break;
                        case "to":
                            xmlEvent = reader.nextEvent();
                            email.setTo(xmlEvent.asCharacters().getData());
                            break;
                        case "from":
                            xmlEvent = reader.nextEvent();
                            email.setFrom(xmlEvent.asCharacters().getData());
                            break;
                        case "heading":
                            xmlEvent = reader.nextEvent();
                            email.setHeading(xmlEvent.asCharacters().getData());
                            break;
                        case "body":
                            xmlEvent = reader.nextEvent();
                            email.setBody(xmlEvent.asCharacters().getData());
                            break;
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("email")) {
                        emailsList.add(email);
                    }
                }
            }
        } catch (FileNotFoundException |
                XMLStreamException e) {
            e.printStackTrace();
        }
        return emailsList;
    }
}
