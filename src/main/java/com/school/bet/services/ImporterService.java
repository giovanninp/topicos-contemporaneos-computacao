package com.school.bet.services;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.Optional;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

public class ImporterService extends DefaultHandler {
    private String filePath = null;
    private SAXParserFactory factory = null;
    private SAXParser parser = null;
    private String currentElement = "";
    private IImporterCallback onValue = null;
    private Optional<IImporterCallback> onEnd = null;

    public ImporterService(String filePath, IImporterCallback onValue, Optional<IImporterCallback> onEnd) {
        super();
        this.filePath = filePath;
        this.factory = SAXParserFactory.newInstance();
        this.onValue = onValue;
        this.onEnd = onEnd;
    }

    public void execute() {
        try {
            this.parser = factory.newSAXParser();
            this.parser.parse(this.filePath, this);
        } catch (Exception e) {
            System.out.format("[ERROR] - %s", e.getMessage());
        }
    }

    public void startDocument() {
        System.out.println("\nStarting parse...\n");
    }

    public void endDocument() {
        System.out.println("\nEnding parse...\n");
    }

    public void startElement(String uri, String localName, String qName, Attributes atts) {
        String tag = qName;
        this.currentElement = tag;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        String tag = qName;
        this.currentElement = "";

        this.onEnd.ifPresent(v -> {
            v.call(tag, "");
        });
    }

    public void characters(char[] ch, int start, int length) {
        String text = new String(ch, start, length);

        this.onValue.call(this.currentElement, text);
    }

}
