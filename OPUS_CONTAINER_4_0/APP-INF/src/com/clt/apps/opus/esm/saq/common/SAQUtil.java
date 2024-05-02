/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : SAQUtil.java
*@FileTitle      : SAQUtil
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
 =========================================================*/

package com.clt.apps.opus.esm.saq.common;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;

import com.clt.framework.component.util.JSPUtil;

/**
 * SAQ 업무 관련 UTIL성 업무를 처리한다.
 * 
 * @author 송민석
 * @see
 * @since J2EE 1.4
 */
public class SAQUtil {
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * Common 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param str Original String
	 * @param replaceStr str이 Null일 경우 반환 받고자 하는 값.
	 * @return String 변환된 값.
	 */
	public static String getNvl(String str, String replaceStr) {
		if (str == null || str.trim().length() == 0)
			return replaceStr;
		return str;
	}
	
	/**
	 * 제수가 0일때 0을 return<br>
	 * 
	 * @param num 계산된값.
	 * @return 0 또는 num
	 */
	public static double getNaNToZero(double num ) {
		
		if (Double.isNaN(num))
			return 0.0;
		return num;
	}
	

	/**
	 * fnum 값을 체크하여 0 인 경우 "" 으로 리턴한다.
	 * 
	 * @param fnum
	 * @return
	 */
	public static String getZeroToNullString(float fnum) {
		return fnum == 0 ? "" : String.valueOf(fnum);
	}

	/**
	 * dnum 값을 체크하여 0 인 경우 "" 으로 리턴한다.
	 * 
	 * @param dnum
	 * @return
	 */
	public static String getZeroToNullString(double dnum) {
		return dnum == 0 ? "" : String.valueOf(dnum);
	}

	/**
	 * 
	 * @param double num
	 * @param int base
	 * @return String
	 */
/*	public static String getSign(double num, int base) {
		String rtn = "";
		if (num > base) {
			rtn = "+";
		} else if (num < base) {
			rtn = "-";
		} else {
			rtn = "";
		}
		return rtn;
	}*/

	/**
	 * 
	 * @param double num
	 * @return double
	 */
	public static double abs(double num) {
		return ((num >= 0) ? 1 : -1) * num;
	}

	/**
	 * num1/num2 를 (%)로 환산하여 소수점 1 자리까지 ROUND하여 리턴한다.
	 * 
	 * @param double num1
	 * @param double num2
	 * @return double 
	 */
	public static double getRatio(double num1, double num2) {
		if (num2 == 0)
			return 0;
		return JSPUtil.round((num1 / num2 * 100) - 100, -1);
	}
	/**
	 * 
	 * @return
	 */
	public static String[] getColors() {
		String[] colors = { "225,244,226", "237,255,168", "235,240,255"};
		return colors;
	}
	/**
	 * 
	 * @return
	 */
	public static String[] getHighlightColors() {
		String[] colors = { "242,199,237", "146,232,226", "146,232,158"};
		return colors;
	}	
	/**
	 * 
	 * @param i
	 * @return
	 */
	public static String[] getColors(int i) {
		String[] colors = getColors();
		int size = colors.length;
		String[] cs = new String[i];
		for(int r = 0 ; r < i ; r++) {
			cs[r] = colors[r%size];
		}
		return cs;
	}

	/**
	 * 
	 * @param i
	 * @return
	 */
	public static String getColor(int i) {
		String[] colors = getColors();
		int size = colors.length;
		int r = i;
		if (r < 0) {
			r = 0;
		}
		return colors[r%size];
	}
	
	/**
	 * 
	 * @param i
	 * @return
	 */
	public static String[] getHighlightColors(int i) {
		String[] colors = getHighlightColors();
		int size = colors.length;
		String[] cs = new String[i];
		for(int r = 0 ; r < i ; r++) {
			cs[r] = colors[r%size];
		}
		return cs;
	}

	/**
	 * 
	 * @param i
	 * @return
	 */
	public static String getHighlightColor(int i) {
		String[] colors = getHighlightColors();
		int size = colors.length;
		int r = i;
		if (r < 0) {
			r = 0;
		}
		return colors[r%size];
	}	
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	 public static String getStringToCurr(String str) 
	{ 
		if(str.equals("") || str == null) {
			return "";
		} else {
			long l = Long.parseLong(str); 
			 
			Locale locale = new Locale("ko", "KOR"); 
			NumberFormat nf = NumberFormat.getInstance(locale); 
			return nf.format(l); 

		}
	} 
	/**
	 * 구분자를 넣은 문자열을 해쉬맵으로 생성한다.
	 * 예)
	 * Utils.createMap("key1:value1|key2:value2|key3:value3");
	 * 다음 데이터를 가진 해쉬맵으로 리턴한다.
	 * key1:value1
	 * key2:value2
	 * key3:value3
	 * 
	 * @param str
	 * @return
	 */
	public static HashMap createMap(String str) {
		HashMap hm = new HashMap();
		StringTokenizer st = new StringTokenizer(str, "|");
		String temp = "";
		while (st.hasMoreTokens()) {
			temp = st.nextToken();
			if(temp.split(":").length > 1) {
				hm.put(temp.split(":")[0], temp.split(":")[1]);
			}
		}
		return hm;
	}	 
	
	/**
	 * 년월 -> 년Quarter로 변환 <br>
	 * 
	 * @param yrMon
	 * @return String
	 * @throws DAOException
	 */  	
	public static String getYrMonToYrQtr(String yrMon){
		String yr = null;
		String mon = null;
		String qtr = null;
		
		yr = yrMon.substring(0, 4);
		mon = yrMon.substring(4, 6);
		
		if(mon.compareTo("01") >= 0 && mon.compareTo("03") <= 0){
			qtr = "1Q";
		}else if(mon.compareTo("04") >= 0 && mon.compareTo("06") <= 0){
			qtr = "2Q";
		}else if(mon.compareTo("07") >= 0 && mon.compareTo("09") <= 0){
			qtr = "3Q";						
		}else if(mon.compareTo("10") >= 0 && mon.compareTo("12") <= 0){
			qtr = "4Q";						
		}
		
		return yr+qtr;
	}
	
	/**
	 * 년Quarter -> 년월로 변환 <br>
	 * 
	 * @param yrQtr
	 * @return String
	 * @throws DAOException
	 */  	
	public static String getYrQtrToYrMon(String yrQtr){
		String yr = null;
		String mon = null;
		String qtr = null;
		
		yr = yrQtr.substring(0, 4);
		qtr = yrQtr.substring(4, 6);
		
		if ( qtr.equals("1Q") ){
			mon = "01";
		} else if ( qtr.equals("2Q") ){
			mon = "04";		
		} else if ( qtr.equals("3Q") ){
			mon = "07";
		} else if ( qtr.equals("4Q") ){
			mon = "10";							
		}
		return yr+mon;
	}	
	
	/**
	 * 이전쿼타 반환 <br>
	 * 
	 * @param yrQtr
	 * @return String
	 * @throws DAOException
	 */  	
	public static String getBefYrQtr(String yrQtr){
		String yr = null;
		String qtr = null;
		String befYr = null;
		String befQtr = null;
			
		yr = yrQtr.substring(0, 4);
		qtr = yrQtr.substring(4, 6);
		
		if(qtr.equals("1Q")){
			befYr = (Integer.parseInt(yr) -1)+"";
			befQtr = "4Q";
		}else if(qtr.equals("2Q")){
			befYr = yr;
			befQtr = "1Q";
		}else if(qtr.equals("3Q")){
			befYr = yr;			
			befQtr = "2Q";
		}else if(qtr.equals("4Q")){
			befYr = yr;			
			befQtr = "3Q";			
		}
		
		return befYr+befQtr;
	}
	
	
	/**
	 * 현재시간반환 <br>
	 * 
	 * @return String
	 * @throws DAOException
	 */  	
	public static String getCurrentTime(){
		
		Calendar dateTime = Calendar.getInstance();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = formatter.format(dateTime.getTime());
		   		
		return str;
	}	
}
