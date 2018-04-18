package com.wl.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * java8 时间API的使用-王雷-2018年4月16日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientApplicationTests {

	@Test
	public void testLocalDateTime(){
		LocalDateTime now = LocalDateTime.now();
		System.out.println("********************************************"+now+"***************************************");

		// 将当前日期时间减去两天
		LocalDateTime dateTime2 = now.minusDays(2);
		System.out.println("********************************************"+dateTime2+"****************************************");

		// 将当前日期时间加上五天
		LocalDateTime dateTime3 = now.plusDays(5);
		System.out.println("********************************************"+dateTime3+"****************************************");

		// 输出当前日期时间的年份
		System.out.println("********************************************"+now.getYear()+"****************************************");

		// 构造一个指定日期时间的对象
		LocalDateTime dateTime = LocalDateTime.of(2016, 10, 23, 8, 20);
		System.out.println("********************************************"+dateTime+"****************************************");
	}


	@Test
	public void testInstant() {
		// 获取当前时间的时间戳
		Instant instant = Instant.now();
		// 因为中国在东八区，所以这句输出的时间跟我的电脑时间是不同的
		System.out.println("********************************************"+instant);

		// 既然中国在东八区，则要偏移8个小时，这样子获取到的时间才是自己电脑的时间
		OffsetDateTime dateTime = instant.atOffset(ZoneOffset.ofHours(8));
		System.out.println(dateTime);

		// 转换成毫秒，如果是当前时间的时间戳，结果跟System.currentTimeMillis()是一样的
		long milli = instant.toEpochMilli();
		System.out.println(milli);
	}

	/**
	 * 表示间隔的有两个类
	 * java.time.Duration用于计算两个“时间”间隔
	 * java.time.Period用于计算两个“日期”间隔
	 */
	@Test
	public void testDuration() {
		LocalTime start = LocalTime.now();
		try {
			//让线程睡眠3s
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		LocalTime end = LocalTime.now();
		//获取end和start的时间间隔
		Duration duration = Duration.between(start, end);

		//可能会输出PT3S或者输出PT3.001S，至于多出来的0.001秒其实就是除去线程睡眠时间执行计算时间间隔那句代码消耗的时间
		System.out.println("********************************************"+duration);
	}


	/**
	 * 表示间隔的有两个类
	 * java.time.Duration用于计算两个“时间”间隔
	 * java.time.Period用于计算两个“日期”间隔
	 */
	@Test
	public void testPeriod() {
		//起始时间指定为2015年3月4日
		LocalDate start = LocalDate.of(2015, 3, 4);
		//终止时间指定为2017年8月23日
		LocalDate end = LocalDate.of(2017, 8, 23);

		Period period = Period.between(start, end);
		//输出P2Y5M19D，Y代表年，M代表月，D代表日，说明start和end的日期间隔是2年5个月19天
		System.out.println("********************************************"+period);
	}

	@Test
	public void testDateTimeFormatter() {
		// 获取预定义的格式，DateTimeFormatter类预定了很多种格式
		DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;
		// 获取当前日期时间
		LocalDate now = LocalDate.now();
		// 指定格式化器格式日期时间
		String strNow = now.format(dtf);
		System.out.println("********************************************"+strNow);

		// 自定义格式
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
		String strNow2 = now.format(formatter);
		System.out.println(strNow2);

		// 将字符串转换成日期
		LocalDate date = LocalDate.parse(strNow2, formatter);
		System.out.println(date);
	}

	@Test
	public void testZonedDateTime() {
		Set<String> set = ZoneId.getAvailableZoneIds();
		set.forEach(System.out::println);
	}
}
