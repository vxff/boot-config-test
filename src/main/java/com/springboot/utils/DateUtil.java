package com.springboot.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author chengfan
 * @version 2018年9月29日
 */
public class DateUtil {
	
	/**
	 * 精确到秒的完整时间 如：yyyy-MM-dd HH:mm:ss
	 */
	public static String FORMAT_FULL_S = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
	 */
	public static String FORMAT_FULL_MS = "yyyy-MM-dd HH:mm:ss.S";
	
	/**
	 * 在日期上增加数个整月
	 * 
	 * @param date
	 *            日期
	 * @param n
	 *            要增加的月数
	 * @return
	 */
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
	
	/**
	 * 在日期上增加天数
	 * 
	 * @param date
	 *            日期
	 * @param n
	 *            要增加的天数
	 * @return
	 */
	public static Date addDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, n);
		return cal.getTime();
	}

	/**
	 * 获取日期的星期第几天
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeek(Date date) {
		String[] weeks = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (week_index < 0) {
			week_index = 0;
		}
		return weeks[week_index];
	}
	
	/**
	 * 获取时间戳
	 */
	public static String getTimeString() {
		SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL_S);
		Calendar calendar = Calendar.getInstance();
		return df.format(calendar.getTime());
	}
	
	/**
	 * 按默认格式的字符串距离今天的天数
	 * 
	 * @param date
	 *            日期字符串
	 * @return
	 */
	public static int countDays(Date date) {
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}

}
