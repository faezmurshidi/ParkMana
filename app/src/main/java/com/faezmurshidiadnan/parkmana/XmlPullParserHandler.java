package com.faezmurshidiadnan.parkmana;

/**
 * Created by User on 20/05/16.
 */

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class XmlPullParserHandler {
    private List<Employee> employees= new ArrayList<Employee>();
    private Employee employee;
    private String text;

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Employee> parse(InputStream is) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser  parser = factory.newPullParser();

            parser.setInput(is, null);

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("entry")) {
                            // create a new instance of employee
                            employee = new Employee();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("entry")) {
                            // add employee object to list
                            employees.add(employee);
                        }else if (tagname.equalsIgnoreCase("development")) {
                            employee.setPlace(text);
                        }  else if (tagname.equalsIgnoreCase("Latitude")) {
                            employee.setLat(text);
                        }else if (tagname.equalsIgnoreCase("longitude")) {
                            employee.setLong(text);
                        } else if (tagname.equalsIgnoreCase("Lots")) {
                            employee.setLot(text);
                        }
                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }

        } catch (XmlPullParserException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}

        return employees;
    }
}
