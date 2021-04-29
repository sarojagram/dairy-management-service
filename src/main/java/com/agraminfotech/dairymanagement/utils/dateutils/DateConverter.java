package com.agraminfotech.dairymanagement.utils.dateutils;
/*
 *  @Created 8/25/2020
 *  @project cms
 *  @author Saroj
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

/**
 * Class has functionality to convert bikram sambat to Gregorian(AD) date
 */
public class DateConverter {

    private static final Logger logger = LoggerFactory.getLogger(DateConverter.class);

    static DateFormat formatter;
    public static DateFormat getDateFormatter(boolean hasTime) {return new SimpleDateFormat( hasTime ? "yyyy-MM-dd HH:mm:ss" : "yyy-MM-dd"); }

    //EEE MMM dd HH:mm:ss z yyyy to yyyy-MM-dd
    public static String parseFormat(String dateStr) throws ParseException {
        SimpleDateFormat parseFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        return getDateFormatter(false).format(parseFormat.parse(dateStr));
    }
    /**
     * Converts Nepali Bikram Sambat date to Gregorian date
     *
     * @param bsDate nepali date
     * @return english date
     */
    String convertBsToAd(String bsDate,boolean includeTime) {
        if(bsDate == null || bsDate.isEmpty()) return null;

        String[] dateTimeArray = bsDate.split(" ");
        String onlyDate = dateTimeArray[0];
        String onlyTime = dateTimeArray.length == 2 ? dateTimeArray[1]: "00:00:00";
        String[] dateArray = onlyDate.split("-");

        int bsYear = Integer.parseInt(dateArray[0]);
        int bsMonth = Integer.parseInt(dateArray[1]);
        int bsDayOfMonth = Integer.parseInt(dateArray[2]);
        String finalDate = null;
        try{
            if (validateBsDate(bsYear, bsMonth, bsDayOfMonth)) {
                finalDate = convertBsToAd(bsMonth,bsDayOfMonth,bsYear) + " " + (includeTime ? onlyTime : "");
            } else {
                throw new IllegalStateException("invalid BS date");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return finalDate;
    }

    /**
     * Converts Gregorian date to Bikram Sambat date
     *
     * @param adDate english date format string "dd-MM-yyyy"
     * @return Bikram Sambat date - String type yyyy-MM-dd. There would be 1 digit month and day of month.
     */
    String convertAdToBs(String adDate, boolean includeTime) throws ParseException {

        String[] dateTimeArray = adDate.split(" ");
        String adDateOnly = dateTimeArray[0];
        String timeOnly = dateTimeArray.length == 2 ? dateTimeArray[1]: "00:00:00";
        String[] adDateParts = adDateOnly.split("-");

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inputAdDate = LocalDate.parse(adDateOnly);
        LocalDate lookupNearestAdDate = null;
        int equivalentNepaliYear = Lookup.lookupNepaliYearStart;
        Byte[] monthDay = null;

        // todo use +57 years addition logic to make calculation faster
        for (int i = 0; i < Lookup.adEquivalentDatesForNewNepaliYear.size(); i++) {
            String[] adEquivalentDateForNewNepaliYear = Lookup.adEquivalentDatesForNewNepaliYear.get(i).split("-");
            if (adEquivalentDateForNewNepaliYear[0].equals(adDateParts[0])) {
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                lookupNearestAdDate = LocalDate.parse(Lookup.adEquivalentDatesForNewNepaliYear.get(i), formatter1);
                monthDay = Lookup.numberOfDaysInNepaliMonth.get(i + Lookup.lookupNepaliYearStart);
                equivalentNepaliYear += i;
                if (inputAdDate.isBefore(lookupNearestAdDate)) {
                    if (i == 0) {
                        throw new DateRangeNotSupported("Date supplied before supported date.");
                    }
                    lookupNearestAdDate = LocalDate.parse(Lookup.adEquivalentDatesForNewNepaliYear.get(i - 1), formatter1);
                    equivalentNepaliYear -= 1;
                    monthDay = Lookup.numberOfDaysInNepaliMonth.get(i + Lookup.lookupNepaliYearStart - 1);
                }
            }
        }
        assert lookupNearestAdDate != null;
        //Positive day difference
        long difference = ChronoUnit.DAYS.between(lookupNearestAdDate, inputAdDate);

        int nepMonth = 0;
        int nepDay = 1;
        int daysInMonth;
        while (difference != 0) {
            if (difference >= 0) {
                //number of days in  Nepali months
                daysInMonth = monthDay[nepMonth];
                nepDay++;
                if (nepDay > daysInMonth) {
                    nepMonth++;
                    nepDay = 1;
                }
                if (nepMonth >= 12) {
                    equivalentNepaliYear++;
                    nepMonth = 0;
                }
                difference--;
            }
        }
//month index is initialised as 0 so increasing by 1
        nepMonth += 1;
        String nepMonthStr = nepMonth > 9 ? nepMonth +"": "0"+nepMonth;
        String nepDayStr = nepDay > 9 ? nepDay + "" : "0"+nepDay;
        return equivalentNepaliYear + "-" + nepMonthStr + "-" + nepDayStr + " " + (includeTime ? timeOnly: "");
    }

    /**
     * Converts nepali bikram sambat date to Gregorian date
     *
     * @param nepaliMonth      nepali date month
     * @param nepaliDayOfMonth nepali date day of month
     * @param nepaliYear       index to look number of days in month
     * @return english date
     */
    private String convertBsToAd(int nepaliMonth, int nepaliDayOfMonth,
                               int nepaliYear) throws ParseException {
        // number of days
        // passed
        // since
        // start of year
        // 1 is decreased as year start day has already included
        int numberOfDaysPassed = nepaliDayOfMonth - 1;
        for (int i = 0; i <= nepaliMonth - 2; i++) {
            numberOfDaysPassed += Lookup.numberOfDaysInNepaliMonth.get(nepaliYear)[i];
        }
        // From look up table we need to find corresponding english date
        // for
        // nepali new year
        // we need to add number of days passed from new year to english
        // date
        // which will find
        // corresponding english date
        // we need what starts
        // where...
        /*String dateFormat = "dd-MMM-yyyy";
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                dateFormat);*/
        formatter = getDateFormatter(false);
        formatter.setLenient(false);
        Calendar c1 = Calendar.getInstance();
        try {
            c1.setTime(formatter.parse(Lookup.adEquivalentDatesForNewNepaliYear.get(getLookupIndex(nepaliYear))));
        } catch (ParseException e) {
            logger.error("error", e);
        }
        c1.add(Calendar.DATE, numberOfDaysPassed);
        return parseFormat(c1.getTime().toString());
    }

    /**
     * validates nepali date
     *
     * @param bsYear       nepali date year part
     * @param bsMonth      nepali date month part
     * @param bsDayOfMonth nepali date day of month
     * @return boolean returns false  if there is no lookup for provided year ,
     */
    private boolean validateBsDate(int bsYear, int bsMonth, int bsDayOfMonth) {
        if (bsYear < Lookup.lookupNepaliYearStart) {
            throw new DateRangeNotSupported("Bikam Sambat is earlier than supported date");
        } else if (bsYear > (Lookup.lookupNepaliYearStart + Lookup.numberOfDaysInNepaliMonth.size() - 1)) {
            throw new DateRangeNotSupported("Bikram Sambat is later than supported date");
        } else {
            logger.debug("debug: converter supports  year {} ", bsYear);
            if (bsMonth >= 1 && bsMonth <= 12) {
                logger.debug("debug: month between 1 and 12");
                int dayOfMonth = Lookup.numberOfDaysInNepaliMonth.get(bsYear)[bsMonth - 1];
                logger.debug("debug:total days in month {} ", dayOfMonth);
                if (bsDayOfMonth <= dayOfMonth) {
                    return true;
                } else {
                    String message = String.format("invalid day of month  %d for year  %d  and month  %d ", bsDayOfMonth, bsYear, bsMonth);
                    logger.warn(message);
                    throw new InvalidBsDayOfMonthException(
                            message);
                }
            }
        }
        return false;
    }

    /**
     * gets array lookup index in lookup datastructure
     *
     * @param bsYear nepali year
     * @return index where year is
     */
    private int getLookupIndex(int bsYear) {
        logger.debug("lookup index {} ", (bsYear - Lookup.lookupNepaliYearStart));
        return bsYear - Lookup.lookupNepaliYearStart;
    }

}