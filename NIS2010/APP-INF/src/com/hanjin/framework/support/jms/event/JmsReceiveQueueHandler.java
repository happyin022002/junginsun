package com.hanjin.framework.support.jms.event;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Field;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class JmsReceiveQueueHandler extends DefaultHandler {

	private String instanceId = null;
	private Object object = null;
	
    /**
     * Parses an XML file into memory
     */
    public JmsReceiveQueueHandler(String toXml, Class<?> clazz) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
        	this.object = clazz.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(new ByteArrayInputStream(toXml.getBytes()), this);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Event: Parser starts reading an element
     */
    @Override
    public void startElement(String s1, String s2, String elementName, Attributes attributes) throws SAXException {
    	Class<?> cls = object.getClass();
        for(int i = 0; i < attributes.getLength(); i++) {
        	if(getFidleName(attributes, i).equalsIgnoreCase("INSTANCEID")){
        		setInstanceId(attributes.getValue(i));
        	}else{
				try {
					Field fidle = cls.getDeclaredField(getFidleName(attributes, i));
					fidle.setAccessible(true);
					fidle.set(object, attributes.getValue(i));
				} catch (SecurityException e1) {
				} catch (NoSuchFieldException e1) {
				} catch (IllegalArgumentException e) {
				} catch (IllegalAccessException e) {
				}
        	}
        }
    }

    private String getFidleName(Attributes attributes, int index){
    	String localName = attributes.getLocalName(index);
    	return localName.substring(0, 1).toLowerCase() + localName.substring(1, localName.length());
    }
    
	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
