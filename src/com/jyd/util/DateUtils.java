package com.jyd.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String getFormatDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(new Date());
	}
	
	public static String getFormatDate2(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		return sdf.format(new Date());
	}
}
