package com.shendu.hikvision.shengaohkv;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * Hello world!
 *
 */
public class App {

    private static void parseXML(String filePath) {
	System.out.println("I am in parse xml." + " file path => " + filePath);
	SAXReader reader = new SAXReader();
	Document document = null;
	try {
	    document = reader.read(filePath);
	    // System.out.println(document.asXML());
	    Element root = document.getRootElement();
	    for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
		Element element = it.next();
		System.out.println(element.attributeValue("id"));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	List<Node> list = document.selectNodes("//book/title");
	for (Node node : list) {
	    System.out.println(node.getText());
	}
    }

    public static void main(String[] args) {
	System.out.println("Hello World!");
	parseXML("/home/ray/test.xml");
    }
}
