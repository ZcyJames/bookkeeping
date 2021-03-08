package com.chinasoft.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    /**
     * 解析字符串日期,不报错  异常返回null
     * @param
     * @param
     * @return
     * @author lsg
     * @created 2018-11-27 下午4:30:35
     *
     */
    public DateFormat(){

    }

    public static Date parseDate(String d,String format) {
        try {
            return new SimpleDateFormat(format).parse(d);
        } catch (ParseException e) {
            return null;
        }
    }
    /**
     * 解析对象到日期
     * @param
     * @return
     * @author lsg
     * @created 2018-11-27 下午4:08:10
     */
    public static Date parseDate(Object o) {
        if (o == null) {
            return null;
        }
        if (o instanceof Date) {
            return (Date) o;
        }
        if (o instanceof java.sql.Date) {
            return (Date) o;
        }
        if (o instanceof String) {
            // yyyy-MM-dd HH:mm:ss  /
            String d=(String) o;
            StringBuilder format=new StringBuilder("yyyy");
            if (d.charAt(4)=='-') {
                format.append("-MM-dd");
            }else if(d.charAt(4)=='/') {
                format.append("/MM/dd");
            }else if (d.charAt(4)=='_'){
                format.append("_MM_dd");
            }else {
                format.append("MMdd");
            }
            if (d.length()<format.length()) {
                return null;
            }else if (d.length()==format.length()) {
                return parseDate(d, format.toString());
            }
            if (d.charAt(format.length())==' ') {
                format.append(' ');
            }
            if (d.charAt(format.length()+2)==':') {
                format.append("HH:mm:ss");
            }else if (d.charAt(format.length()+2)=='/') {
                format.append("HH/mm/ss");
            }else {
                format.append("HHmmss");
            }
            if (d.length()<format.length()) {
                return null;
            }
            if (d.length()==format.length()) {
                return parseDate(d,format.toString());
            }
            if (d.charAt(format.length())=='.'&&d.length()==(format.length()+4)) {
                format.append(".SSS");
            }else if(d.length()==(format.length()+3)){
                format.append("SSS");
            }else {
                d=d.substring(0, format.length());
            }
            return parseDate(d, format.toString());
        }
        if (o instanceof Long) {
            long l=(long) o;
            if (l<10000000000l) {
                return new Date(l*1000);
            }
            return new Date(l);
        }
        if (o instanceof Integer) {
            long l=(int)o*1000;
            return new Date(l);
        }
        return null;
    }
    /*public static void main(String[] args) {
        Object o=null;
        o=new Date();
        //        o="2018-10-10 11:00:51.666";
        //        o="20181010110051666";
        //        o="2018/10/10 11:00:51";
        //        o="20181010 11:00:51.666";
        o="2018-10-10 11:00:51";
        //        o="2018-10-10 110051";
        Date parseDate = parseDate(o);
        System.out.println(parseDate);
        if (parseDate!=null) {
            *//*System.out.println(new DateTime(parseDate).toString("yyyy-MM-dd HH:mm:ss.SSS"));*//*
        }
    }*/

}
