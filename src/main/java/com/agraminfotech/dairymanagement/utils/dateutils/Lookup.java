package com.agraminfotech.dairymanagement.utils.dateutils;
/*
 *  @Created 8/25/2020
 *  @project cms
 *  @author Saroj
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class has a mapping from Bikram Sambat to Gregorian date
 * Current mapping is in range of 1970-2100
 * If you need extension in date range,
 * add more  dates referring to sites mentioned in README.md.
 * <p>
 * todo  it would be better if these lookup tables could be maintained in XML or JSON or in memory database.
 * </p>
 * <p>
 * There are certain year where there is not 365 days per year, verify these year with other calendar.
 * </p>
 */
public class Lookup {
    /**
     * Bikram Sambat new year equivalent Gregorian date
     * <p>
     * TODO map would be good format for faster calculation.
     */
    static ArrayList<String> adEquivalentDatesForNewNepaliYear = new ArrayList<>();
    /*
     * lookup table starting year
     */
    static int lookupNepaliYearStart = 1970;
    /*
     * number of days in each Nepali month for subsequent years we need to extend this
     * year adding more entries
     *  * TODO map would be good format for faster calculation and readability
     */
    static Map<Integer, Byte[]> numberOfDaysInNepaliMonth = new HashMap<>();

    static {
        //todo create some csv or sort sort of external collaborative data others can update who does not know java
        adEquivalentDatesForNewNepaliYear.add("1913-04-13");// 1970 Baisakh 1 english equivalent date
        adEquivalentDatesForNewNepaliYear.add("1914-04-13");
        adEquivalentDatesForNewNepaliYear.add("1915-04-13");
        adEquivalentDatesForNewNepaliYear.add("1916-04-13");
        adEquivalentDatesForNewNepaliYear.add("1917-04-13");
        adEquivalentDatesForNewNepaliYear.add("1918-04-12");
        adEquivalentDatesForNewNepaliYear.add("1919-04-13");
        adEquivalentDatesForNewNepaliYear.add("1920-04-13");
        adEquivalentDatesForNewNepaliYear.add("1921-04-13");
        adEquivalentDatesForNewNepaliYear.add("1922-04-13");
        adEquivalentDatesForNewNepaliYear.add("1923-04-13");
        adEquivalentDatesForNewNepaliYear.add("1924-04-13");
        adEquivalentDatesForNewNepaliYear.add("1925-04-13");
        adEquivalentDatesForNewNepaliYear.add("1926-04-13");
        adEquivalentDatesForNewNepaliYear.add("1927-04-13");
        adEquivalentDatesForNewNepaliYear.add("1928-04-13");
        adEquivalentDatesForNewNepaliYear.add("1929-04-13");
        adEquivalentDatesForNewNepaliYear.add("1930-04-13");
        adEquivalentDatesForNewNepaliYear.add("1931-04-13");
        adEquivalentDatesForNewNepaliYear.add("1932-04-13");
        adEquivalentDatesForNewNepaliYear.add("1933-04-13");// 1990 Baisakh 1
        adEquivalentDatesForNewNepaliYear.add("1934-04-13");
        adEquivalentDatesForNewNepaliYear.add("1935-04-13");
        adEquivalentDatesForNewNepaliYear.add("1936-04-13");
        adEquivalentDatesForNewNepaliYear.add("1937-04-13");
        adEquivalentDatesForNewNepaliYear.add("1938-04-13");
        adEquivalentDatesForNewNepaliYear.add("1939-04-13");
        adEquivalentDatesForNewNepaliYear.add("1940-04-13");
        adEquivalentDatesForNewNepaliYear.add("1941-04-13");
        adEquivalentDatesForNewNepaliYear.add("1942-04-13");
        adEquivalentDatesForNewNepaliYear.add("1943-04-14");// 2000 Baisakh 1
        adEquivalentDatesForNewNepaliYear.add("1944-04-13");// 2001 Baisakh 1
        adEquivalentDatesForNewNepaliYear.add("1945-04-13");
        adEquivalentDatesForNewNepaliYear.add("1946-04-13");
        adEquivalentDatesForNewNepaliYear.add("1947-04-14");// 2004
        adEquivalentDatesForNewNepaliYear.add("1948-04-13");
        adEquivalentDatesForNewNepaliYear.add("1949-04-13");
        adEquivalentDatesForNewNepaliYear.add("1950-04-13");
        adEquivalentDatesForNewNepaliYear.add("1951-04-14");
        adEquivalentDatesForNewNepaliYear.add("1952-04-13");
        adEquivalentDatesForNewNepaliYear.add("1953-04-13");
        adEquivalentDatesForNewNepaliYear.add("1954-04-13");
        adEquivalentDatesForNewNepaliYear.add("1955-04-14");
        adEquivalentDatesForNewNepaliYear.add("1956-04-13");
        adEquivalentDatesForNewNepaliYear.add("1957-04-13");
        adEquivalentDatesForNewNepaliYear.add("1958-04-13");
        adEquivalentDatesForNewNepaliYear.add("1959-04-14");
        adEquivalentDatesForNewNepaliYear.add("1960-04-13");
        adEquivalentDatesForNewNepaliYear.add("1961-04-13");
        adEquivalentDatesForNewNepaliYear.add("1962-04-13");
        adEquivalentDatesForNewNepaliYear.add("1963-04-14");// 2020
        adEquivalentDatesForNewNepaliYear.add("1964-04-13");
        adEquivalentDatesForNewNepaliYear.add("1965-04-13");
        adEquivalentDatesForNewNepaliYear.add("1966-04-13");
        adEquivalentDatesForNewNepaliYear.add("1967-04-14");
        adEquivalentDatesForNewNepaliYear.add("1968-04-13");
        adEquivalentDatesForNewNepaliYear.add("1969-04-13");
        adEquivalentDatesForNewNepaliYear.add("1970-04-14");
        adEquivalentDatesForNewNepaliYear.add("1971-04-14");
        adEquivalentDatesForNewNepaliYear.add("1972-04-13");
        adEquivalentDatesForNewNepaliYear.add("1973-04-13");
        adEquivalentDatesForNewNepaliYear.add("1974-04-14");
        adEquivalentDatesForNewNepaliYear.add("1975-04-14");
        adEquivalentDatesForNewNepaliYear.add("1976-04-13");
        adEquivalentDatesForNewNepaliYear.add("1977-04-13");
        adEquivalentDatesForNewNepaliYear.add("1978-04-14");
        adEquivalentDatesForNewNepaliYear.add("1979-04-14");
        adEquivalentDatesForNewNepaliYear.add("1980-04-13");
        adEquivalentDatesForNewNepaliYear.add("1981-04-13");
        adEquivalentDatesForNewNepaliYear.add("1982-04-14");
        adEquivalentDatesForNewNepaliYear.add("1983-04-14");
        adEquivalentDatesForNewNepaliYear.add("1984-04-13");
        adEquivalentDatesForNewNepaliYear.add("1985-04-13");
        adEquivalentDatesForNewNepaliYear.add("1986-04-14");
        adEquivalentDatesForNewNepaliYear.add("1987-04-14");
        adEquivalentDatesForNewNepaliYear.add("1988-04-13");
        adEquivalentDatesForNewNepaliYear.add("1989-04-13");
        adEquivalentDatesForNewNepaliYear.add("1990-04-14");
        adEquivalentDatesForNewNepaliYear.add("1991-04-14");
        adEquivalentDatesForNewNepaliYear.add("1992-04-13");
        adEquivalentDatesForNewNepaliYear.add("1993-04-13");
        adEquivalentDatesForNewNepaliYear.add("1994-04-14");// 2051
        adEquivalentDatesForNewNepaliYear.add("1995-04-14");// 2052
        adEquivalentDatesForNewNepaliYear.add("1996-04-13");
        adEquivalentDatesForNewNepaliYear.add("1997-04-13");
        adEquivalentDatesForNewNepaliYear.add("1998-04-14");
        adEquivalentDatesForNewNepaliYear.add("1999-04-14");
        adEquivalentDatesForNewNepaliYear.add("2000-04-13");
        adEquivalentDatesForNewNepaliYear.add("2001-04-14");
        adEquivalentDatesForNewNepaliYear.add("2002-04-14");
        adEquivalentDatesForNewNepaliYear.add("2003-04-14");// 2060
        adEquivalentDatesForNewNepaliYear.add("2004-04-13");
        adEquivalentDatesForNewNepaliYear.add("2005-04-14");
        adEquivalentDatesForNewNepaliYear.add("2006-04-14");
        adEquivalentDatesForNewNepaliYear.add("2007-04-14");
        adEquivalentDatesForNewNepaliYear.add("2008-04-13");
        adEquivalentDatesForNewNepaliYear.add("2009-04-14");
        adEquivalentDatesForNewNepaliYear.add("2010-04-14");
        adEquivalentDatesForNewNepaliYear.add("2011-04-14");
        adEquivalentDatesForNewNepaliYear.add("2012-04-13");
        adEquivalentDatesForNewNepaliYear.add("2013-04-14");// 2070
        adEquivalentDatesForNewNepaliYear.add("2014-04-14");
        adEquivalentDatesForNewNepaliYear.add("2015-04-14");
        adEquivalentDatesForNewNepaliYear.add("2016-04-13");
        adEquivalentDatesForNewNepaliYear.add("2017-04-14");
        adEquivalentDatesForNewNepaliYear.add("2018-04-14");
        adEquivalentDatesForNewNepaliYear.add("2019-04-14");
        adEquivalentDatesForNewNepaliYear.add("2020-04-13");
        adEquivalentDatesForNewNepaliYear.add("2021-04-14");
        adEquivalentDatesForNewNepaliYear.add("2022-04-14");
        adEquivalentDatesForNewNepaliYear.add("2023-04-14");// 2080
        adEquivalentDatesForNewNepaliYear.add("2024-04-13");// 2081
        adEquivalentDatesForNewNepaliYear.add("2025-04-14");// 2082
        adEquivalentDatesForNewNepaliYear.add("2026-04-14");// 2083
        adEquivalentDatesForNewNepaliYear.add("2027-04-14");// 2084
        adEquivalentDatesForNewNepaliYear.add("2028-04-13");// 2085
        adEquivalentDatesForNewNepaliYear.add("2029-04-14");// 2086
        adEquivalentDatesForNewNepaliYear.add("2030-04-14");// 2087
        adEquivalentDatesForNewNepaliYear.add("2031-04-15");// 2088
        adEquivalentDatesForNewNepaliYear.add("2032-04-14");// 2089
        adEquivalentDatesForNewNepaliYear.add("2033-04-14");// 2090
        adEquivalentDatesForNewNepaliYear.add("2034-04-14");// 2091
        adEquivalentDatesForNewNepaliYear.add("2035-04-13");// 2092
        adEquivalentDatesForNewNepaliYear.add("2036-04-14");// 2093
        adEquivalentDatesForNewNepaliYear.add("2037-04-14");// 2094
        adEquivalentDatesForNewNepaliYear.add("2038-04-14");// 2095
        adEquivalentDatesForNewNepaliYear.add("2039-04-15");// 2096
        adEquivalentDatesForNewNepaliYear.add("2040-04-13");// 2097
        adEquivalentDatesForNewNepaliYear.add("2041-04-14");// 2098
        adEquivalentDatesForNewNepaliYear.add("2042-04-14");// 2099
        adEquivalentDatesForNewNepaliYear.add("2043-04-14");// 2100
    }

    private Lookup() {
    }

    static {
        //number after // is Nepali year
        numberOfDaysInNepaliMonth.put(1970, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 1970
        numberOfDaysInNepaliMonth.put(1971, new Byte[]{31, 31, 32, 31, 32, 30, 30, 29, 30, 29,
                30, 30});// 1971
        numberOfDaysInNepaliMonth.put(1972, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 30});// 1972
        numberOfDaysInNepaliMonth.put(1973, new Byte[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});// 1973
        numberOfDaysInNepaliMonth.put(1974, new Byte[]{31, 31, 32, 30, 31, 31, 30, 29, 30, 29,
                30, 30});// 1974
        numberOfDaysInNepaliMonth.put(1975, new Byte[]{31, 31, 32, 32, 30, 31, 30, 29, 30, 29,
                30, 30});// 1975
        numberOfDaysInNepaliMonth.put(1976, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});// 1976
        numberOfDaysInNepaliMonth.put(1977, new Byte[]{30, 32, 31, 32, 31, 31, 29, 30, 29, 30,
                29, 31});// 1977
        numberOfDaysInNepaliMonth.put(1978, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 1978
        numberOfDaysInNepaliMonth.put(1979, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});// 1979
        numberOfDaysInNepaliMonth.put(1980, new Byte[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});// 1980
        numberOfDaysInNepaliMonth.put(1981, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                30, 30});// 1981
        numberOfDaysInNepaliMonth.put(1982, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 1982
        numberOfDaysInNepaliMonth.put(1983, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});// 1983
        numberOfDaysInNepaliMonth.put(1984, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});// 1984
        numberOfDaysInNepaliMonth.put(1985, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                30, 30});// 1985
        numberOfDaysInNepaliMonth.put(1986, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 1986
        numberOfDaysInNepaliMonth.put(1987, new Byte[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29,
                30, 30});// 1987
        numberOfDaysInNepaliMonth.put(1988, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});// 1988
        numberOfDaysInNepaliMonth.put(1989, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});// 1989
        numberOfDaysInNepaliMonth.put(1990, new Byte[]{30, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 1990
        numberOfDaysInNepaliMonth.put(1991, new Byte[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29,
                30, 30});// 1991
        numberOfDaysInNepaliMonth.put(1992, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 30});// 1992
        numberOfDaysInNepaliMonth.put(1993, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});// 1993
        numberOfDaysInNepaliMonth.put(1994, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});// 1994
        numberOfDaysInNepaliMonth.put(1995, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});// 1995
        numberOfDaysInNepaliMonth.put(1996, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});// 1996
        numberOfDaysInNepaliMonth.put(1997, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});// 1997
        numberOfDaysInNepaliMonth.put(1998, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});// 1998
        numberOfDaysInNepaliMonth.put(1999, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});// 1999
        numberOfDaysInNepaliMonth.put(2000, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                29, 31});// 2000
        numberOfDaysInNepaliMonth.put(2001, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 2001
        numberOfDaysInNepaliMonth.put(2002, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});// 2002 366 days
        numberOfDaysInNepaliMonth.put(2003, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31}); //2003
        numberOfDaysInNepaliMonth.put(2004, new Byte[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2005, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30}); //2005
        numberOfDaysInNepaliMonth.put(2006, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2007, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2008, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                29, 31});
        numberOfDaysInNepaliMonth.put(2009, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2010, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30}); //2010
        numberOfDaysInNepaliMonth.put(2011, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2012, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2013, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2014, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2015, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31}); //2015
        numberOfDaysInNepaliMonth.put(2016, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2017, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2018, new Byte[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2019, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2020, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30}); //2020
        numberOfDaysInNepaliMonth.put(2021, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2022, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2023, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2024, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2025, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 2025
        numberOfDaysInNepaliMonth.put(2026, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2027, new Byte[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2028, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2029, new Byte[]{31, 31, 32, 31, 32, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2030, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31}); //2030
        numberOfDaysInNepaliMonth.put(2031, new Byte[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2032, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2033, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2034, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2035, new Byte[]{30, 32, 31, 32, 31, 31, 29, 30, 30, 29,
                29, 31}); //2035
        numberOfDaysInNepaliMonth.put(2036, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 2036
        numberOfDaysInNepaliMonth.put(2037, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2038, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2039, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                30, 30});//2039
        numberOfDaysInNepaliMonth.put(2040, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2041, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30}); // 2041
        numberOfDaysInNepaliMonth.put(2042, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2043, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2044, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2045, new Byte[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2046, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2047, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2048, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 2048
        numberOfDaysInNepaliMonth.put(2049, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2050, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2051, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2052, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});// 2052
        numberOfDaysInNepaliMonth.put(2053, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 30}); //2053
        numberOfDaysInNepaliMonth.put(2054, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2055, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2056, new Byte[]{31, 31, 32, 31, 32, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2057, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2058, new Byte[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2059, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2060, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});// 2060
        numberOfDaysInNepaliMonth.put(2061, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2062, new Byte[]{30, 32, 31, 32, 31, 31, 29, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2063, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2064, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2065, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2066, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                29, 31});
        numberOfDaysInNepaliMonth.put(2067, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2068, new Byte[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2069, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2070, new Byte[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29,
                30, 30});// 2070
        numberOfDaysInNepaliMonth.put(2071, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2072, new Byte[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2073, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 31});
        numberOfDaysInNepaliMonth.put(2074, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2075, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2076, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2077, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                29, 31});
        numberOfDaysInNepaliMonth.put(2078, new Byte[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2079, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29,
                30, 30});
        numberOfDaysInNepaliMonth.put(2080, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29,
                30, 30});// 2080
        numberOfDaysInNepaliMonth.put(2081, new Byte[]{31, 31, 32, 32, 31, 30, 30, 30, 29, 30,
                30, 30});// 2081
        numberOfDaysInNepaliMonth.put(2082, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                30, 30});// 2082
        numberOfDaysInNepaliMonth.put(2083, new Byte[]{31, 31, 32, 31, 31, 30, 30, 30, 29, 30,
                30, 30});// 2083
        numberOfDaysInNepaliMonth.put(2084, new Byte[]{31, 31, 32, 31, 31, 30, 30, 30, 29, 30,
                30, 30});// 2084
        numberOfDaysInNepaliMonth.put(2085, new Byte[]{31, 32, 31, 32, 31, 31, 30, 30, 29, 30,
                30, 30});// 2085
        numberOfDaysInNepaliMonth.put(2086, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                30, 30});// 2086
        numberOfDaysInNepaliMonth.put(2087, new Byte[]{31, 31, 32, 31, 31, 31, 30, 30, 29, 30,
                30, 30});// 2087
        numberOfDaysInNepaliMonth.put(2088, new Byte[]{30, 31, 32, 32, 30, 31, 30, 30, 29, 30,
                30, 30});// 2088
        numberOfDaysInNepaliMonth.put(2089, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                30, 30});// 2089
        numberOfDaysInNepaliMonth.put(2090, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                30, 30});// 2090
        numberOfDaysInNepaliMonth.put(2091, new Byte[]{31, 31, 32, 31, 31, 31, 30, 30, 29, 30,
                30, 30});// 2091
        numberOfDaysInNepaliMonth.put(2092, new Byte[]{31, 31, 32, 32, 31, 30, 30, 30, 29, 30,
                30, 30});// 2092
        numberOfDaysInNepaliMonth.put(2093, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                30, 30});// 2093
        numberOfDaysInNepaliMonth.put(2094, new Byte[]{31, 31, 32, 31, 31, 30, 30, 30, 29, 30,
                30, 30});// 2094
        numberOfDaysInNepaliMonth.put(2095, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 30,
                30, 30});// 2095
        numberOfDaysInNepaliMonth.put(2096, new Byte[]{30, 31, 32, 32, 31, 30, 30, 29, 30, 29,
                30, 30});// 2096
        numberOfDaysInNepaliMonth.put(2097, new Byte[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30,
                30, 30});// 2097
        numberOfDaysInNepaliMonth.put(2098, new Byte[]{31, 31, 32, 31, 31, 31, 29, 30, 29, 30,
                30, 31});// 2098
        numberOfDaysInNepaliMonth.put(2099, new Byte[]{31, 31, 32, 31, 31, 31, 30, 29, 29, 30,
                30, 30});// 2099
        numberOfDaysInNepaliMonth.put(2100, new Byte[]{31, 32, 31, 32, 30, 31, 30, 29, 30, 29,
                30, 30});// 2100
    }

}