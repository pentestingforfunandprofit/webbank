
<%@ page import="com.thoughtworks.xstream.XStream" %>
<%!

public static class Date {
    int year = 2004;
    int month = 8;
    int day = 15;
}
%>
<%!
public static class Deserialize {

    public static void main(String[] args) {

        XStream xstream = new XStream();

        Date date = new Date();

        xstream.alias("date", Date.class);

        String xml = xstream.toXML(date);

        System.out.print(xml);

        Date newdate = (Date)xstream.fromXML(xml);
        newdate.month = 12;
        newdate.day = 2;

        String newxml = xstream.toXML(newdate);

        System.out.print("\n\n" + newxml);
    }
}
%>
