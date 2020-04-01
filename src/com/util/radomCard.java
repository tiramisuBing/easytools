package com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/*
 * 身份证号码结构：
 * 根据〖中华人民共和国国家标准GB11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
 * 排列顺序从左至右依次为：6位数字地址码，8位数字出生日期码，3位数字顺序码和1位数字校验码。
 * 地址码（前6位）：表示对象常住户口所在县（市、镇、区）的行政区划代码，按GB/T2260的规定执行。
 * 前1、2位数字表示：所在省份的代码；
 * 第3、4位数字表示：所在城市的代码；
 * 第5、6位数字表示：所在区县的代码；
 * 出生日期码，（第7位 - 14位）：表示编码对象出生年、月、日，按GB按GB/T7408的规定执行，年、月、日代码之间不用分隔符。
 * 顺序码（第15位至17位）：表示在同一地址码所标示的区域范围内，对同年、同月、同日出生的人编订的顺序号，顺序码的奇数分配给男性，偶数分配给女性。
 * 第15、16位数字表示：所在地的派出所的代码；</li>  * <li>第17位数字表示性别：奇数表示男性，偶数表示女性；
 * 第18位数字是校检码：也有的说是个人信息码，一般是随计算机的随机产生，用来检验身份证的正确性。校检码可以是0~9的数字，有时也用x表示。
 * 校验码（第18位数）：十七位数字本体码加权求和公式 s = sum(Ai*Wi), i = 0..16，先对前17位数字的权求和；
 * Ai:表示第i位置上的身份证号码数字值.Wi:表示第i位置上的加权因子.Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2；
 * 计算模 Y = mod(S, 11)  通过模得到对应的模 Y: 0 1 2 3 4 5 6 7 8 9 10 校验码: 1 0 X 9 8 7 6 5 4 3 2
 * 计算步骤：1.将前17位数分别乘以不同的系数。从第1位到第17位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
 * 2.将这17位数字和系数相乘的结果相加。
 * 3.用加出来和除以11，看余数是多少
 * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字，分别对应的最后一位身份证的号码为：1 0 X 9 8 7 6 5 4 3 2
 */
public class radomCard {

	// 18位身份证号码各位的含义:
	// 1-2位省、自治区、直辖市代码；
	// 3-4位地级市、盟、自治州代码；
	// 5-6位县、县级市、区代码；
	// 7-14位出生年月日，比如19670401代表1967年4月1日；
	// 15-17位为顺序号，其中17位（倒数第二位）男为单数，女为双数；
	// 18位为校验码，0-9和X。
	// 作为尾号的校验码，是由把前十七位数字带入统一的公式计算出来的，
	// 计算的结果是0-10，如果某人的尾号是0－9，都不会出现X，但如果尾号是10，那么就得用X来代替，
	// 因为如果用10做尾号，那么此人的身份证就变成了19位。X是罗马数字的10，用X来代替10
	public static void main(String[] args) {
		radomCard cre = new radomCard();
		String[] randomID = cre.getRandomID();
		System.out.println(randomID[0]);
		System.out.println(randomID[1]);
		System.out.println(randomID[2]);
		if (randomID[2].charAt(2) % 2 == 0) {
			System.out.println("girl");
		} else {
			System.out.println("boy");
		}
	}

	public char calcTrailingNumber(char[] chars) {
		if (chars.length < 17) {
			return ' ';
		}
		int[] c = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
		char[] r = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
		int[] n = new int[17];
		int result = 0;
		for (int i = 0; i < n.length; i++) {
			n[i] = Integer.parseInt(chars[i] + "");
		}
		for (int i = 0; i < n.length; i++) {
			result += c[i] * n[i];
		}
		return r[result % 11];
	}

	public String[] getRandomID() {
		// 随机生成省、自治区、直辖市代码 1-2
		String[] provinces = { "11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35", "36", "37",
				"41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65", "71",
				"81", "82" };
		String province = randomOne(provinces);
		// 随机生成地级市、盟、自治州代码 3-4
		String city = randomCityCode(18);
		// 随机生成县、县级市、区代码 5-6
		String county = randomCityCode(28);
		// 随机生成出生年月 7-14
		String birth = randomBirth(20, 40);
		// 随机生成顺序号 15-17(随机性别)
		String no = new Random().nextInt(899) + 100 + "";
		// 拼接身份证号码
		String id = province + city + county + birth + no;
		// 随机生成校验码 18
		radomCard c = new radomCard();
		char n = c.calcTrailingNumber(id.toCharArray());
		String id_n = id + n;
		return new String[] { id_n, birth, no };
	}

	/**
	 * 从String[] 数组中随机取出其中一个String字符串
	 */
	public String randomOne(String[] s) {
		return s[new Random().nextInt(s.length - 1)];
	}

	/**
	 * 随机生成两位数的字符串（01-max）,不足两位的前面补0
	 */
	public String randomCityCode(int max) {
		int i = new Random().nextInt(max) + 1;
		return i > 9 ? i + "" : "0" + i;
	}

	/**
	 * 随机生成minAge到maxAge年龄段的人的生日日期
	 */
	public String randomBirth(int minAge, int maxAge) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
		Calendar date = Calendar.getInstance();
		date.setTime(new Date());// 设置当前日期
		// 随机设置日期为前maxAge年到前minAge年的任意一天
		int randomDay = 365 * minAge + new Random().nextInt(365 * (maxAge - minAge));
		date.set(Calendar.DATE, date.get(Calendar.DATE) - randomDay);
		return dft.format(date.getTime());
	}

}