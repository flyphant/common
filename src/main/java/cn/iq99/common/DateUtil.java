package cn.iq99.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	 /**
	  * 日期格式：yyyyMMdd
	  */
	 public static final String DATE_SHORT = "yyyyMMdd";

	 /**
	  * 日期格式：yyyy-MM-dd
	  */
	 public static final String DATE_LONG = "yyyy-MM-dd";

	 /**
	  * 时间格式：HHmmss
	  */
	 public static final String TIME_SHORT = "HHmmss";

	 /**
	  * 时间格式：HH:mm:ss
	  */
	 public static final String TIME_LONG = "HH:mm:ss";

	 /**
	  * 日期时间格式：yyyyMMddHHmmss
	  */
	 public static final String DATETIME_SHORT = "yyyyMMddHHmmss";

	 /**
	  * 日期时间格式：yyyy-MM-dd HH:mm:ss
	  */
	 public static final String DATETIME_LONG = "yyyy-MM-dd HH:mm:ss";

	 /**
	  * 日期时间毫秒格式：yyyyMMddHHmmssSSS
	  */
	 public static final String DATETIMEMILLIS = "yyyyMMddHHmmssSSS";
	 
	 /**
	  * 比较时间大小
	  * @param date1
	  * @param date2
	  * @return date1> date2 true;
	  * 		date1< date2 false;
	  */
	 public static boolean compareDate(Date date1,Date date2){
		 if(date1.getTime()>date2.getTime()){
			 return true;
		 }else{
			 return false;
		 }
	 }
	 
	 /**
	  * 格式化时间
	  * @param time
	  * @param format
	  * @return
	  * @throws ParseException
	  */
	 public static Date getDate(String time,String format) throws ParseException{
		 DateFormat df=new SimpleDateFormat(format);
		 
		 return df.parse(time);
	 }
	
	/**
	 * 获取昨天日期
	 * 日期格式:yyyyMMdd
	 * @return
	 */
	public static String getLastDate(){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date date=cal.getTime();
		SimpleDateFormat sp=new SimpleDateFormat(DATE_SHORT);
		return sp.format(date);
	}
	
	/**
	 * 获取当天日期
	 * 日期格式:yyyyMMdd
	 * @return
	 */
	public static String getTodayDate(){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		Date date=cal.getTime();
		SimpleDateFormat sp=new SimpleDateFormat(DATE_SHORT);
		return sp.format(date);
	}
}
