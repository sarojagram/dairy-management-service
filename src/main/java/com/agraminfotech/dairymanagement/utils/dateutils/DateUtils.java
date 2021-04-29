package com.agraminfotech.dairymanagement.utils.dateutils;
/*
 *  @Created 8/25/2020
 *  @project cms
 *  @author Saroj
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    static DateFormat formatter;
    static DateConverter dateConverter = new DateConverter();

    public static String getFinalDateInString(String dateStr, String operationDateSetting,boolean includeTime, boolean alwaysInAD) throws ParseException {
        if(dateStr == null || dateStr.isEmpty()) return "";
        boolean isDateSettingInBS = operationDateSetting.equalsIgnoreCase("bs");
        if(includeTime){
            formatter = getDateFormatter(true);
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Kathmandu");
            formatter.setTimeZone(timeZone);
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
            dateStr = formatter.format(date);
        }
        return alwaysInAD ? (isDateSettingInBS ? dateConverter.convertBsToAd(dateStr,includeTime): dateStr):
                (isDateSettingInBS ? dateConverter.convertAdToBs(dateStr,includeTime): dateStr);
    }

    public static Date getFinalInADDateFormat(String dateStr, String operationDateSetting,boolean includeTime) throws ParseException {
        if(dateStr == null || dateStr.isEmpty()) return null;
        boolean isDateSettingInBS = operationDateSetting.equalsIgnoreCase("bs");
        dateStr = addCurrentTimeToDate(dateStr, includeTime);
        return getDateFormatter(includeTime).parse(isDateSettingInBS ? dateConverter.convertBsToAd(dateStr,includeTime): dateStr);
    }

    public static String convertADToBs(String date,boolean includeTime) throws ParseException {
        return dateConverter.convertAdToBs(date, includeTime);
    }

    public static Date getCurrentDate(String operationDateSetting,boolean includeTime) throws ParseException {
        return getFinalInADDateFormat(getCurrentDateInStr(includeTime),operationDateSetting,includeTime);
    }
    public static String getCurrentDateInString(String operationDateSetting,boolean includeTime) throws ParseException {
        return getFinalDateInString(getCurrentDateInStr(includeTime),operationDateSetting,includeTime,false);
    }

    public static String getCurrentDateInStr(boolean includeTime) {
        formatter = getDateFormatter(includeTime);
        return formatter.format(new Date());
    }

    public static Date getCurrentDate(boolean includeTime) throws ParseException {
        formatter = getDateFormatter(includeTime);
        return formatter.parse(formatter.format(new Date()));
    }

    public static Date parseStringToDate(String dateStr,boolean includeTime) throws ParseException {
        formatter = getDateFormatter(includeTime);
        return formatter.parse(dateStr);
    }

    public static DateFormat getDateFormatter(boolean hasTime) {
        return new SimpleDateFormat( hasTime ? "yyyy-MM-dd HH:mm:ss" : "yyy-MM-dd"); }

    public static String getCurrentTime() throws ParseException {
        Date date = getCurrentDate(true);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(date.getTime()) + "";
    }

    public static String addCurrentTimeToDate (String date, boolean isTimeAlso) throws ParseException {
        if(isTimeAlso){
            String[] dateTimeArray = date.split(" ");
            return dateTimeArray.length == 2 ? date : date + " " + getCurrentTime();
        }else return date;
    }

    public static int getCurrentYear(){
        LocalDate localDate = LocalDate.now();
        return localDate.getYear();
    }
     public static String getDateBeforeToday(Integer age, String ageType){
        if(age == null) return  "";
        String birthDate = "";
        if(ageType.equalsIgnoreCase("years")) birthDate =  LocalDate.now().minusYears(age).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        else if(ageType.equalsIgnoreCase("months")) birthDate =   LocalDate.now().minusMonths(age).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        else birthDate =  LocalDate.now().minusDays(age).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return  birthDate;
     }







}
