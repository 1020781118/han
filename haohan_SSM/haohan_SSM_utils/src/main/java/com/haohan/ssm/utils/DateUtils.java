package com.haohan.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String dateToString(String dateFormat,Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        String format = simpleDateFormat.format(date);
        return format;
    }

    public static Date stringToDate(String dateFormat,String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Date parse = simpleDateFormat.parse(str);
        return parse;
    }
}
