/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Utils.java
*@FileTitle : 시나리오 아이디 불러오기 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-20
*@LastModifier : 
*@LastVersion : 1.0
* 2006-09-20 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrcommon;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * ENIS-EQR Business Utils<br>
 * - ENIS-EQR에 대한 공통으로 사용되는 기능을 모은 class.<br>
 * 
 * @author ChangHoChae
 * @see DBDAO, 개별 class 참조
 * @since J2EE 1.4
 */
public class Utils {

	/** 
	 * 
	 * @param str
	 * @param spaceNum
	 * @param spaceString
	 * @param flag
	 * @return
	 */
	public static String fill(String str, int spaceNum, String spaceString, String flag) {
		String val = str.trim();
		StringBuffer fillString = new StringBuffer();

		if(val.length() > 0) {
			for(int i = 0 ; i < (spaceNum - val.length()) ; i++ ) {
				fillString.append(spaceString.toString());
			}
		}

		if(flag.equals("left")) {
			str = fillString.toString() + val;
		}else if(flag.equals("right")) {
			str = val + fillString.toString();
		}
	  
		return str;
	 }	
	
	/**
	 * 
	 * @return
	 */
	public String getCurrDate() {

        GregorianCalendar cal = new GregorianCalendar();
        StringBuffer date = new StringBuffer();
        
        date.append(cal.get(1));
        if(cal.get(2) < 9) date.append('0');
        date.append(cal.get(2) + 1);
        if(cal.get(5) < 10) date.append('0');
        date.append(cal.get(5));

        return date.toString();
    }
	/*
	 * dateTime format 대로 현재 일자를 반환 ( RD mail 전송시 파일명 생성에 활용 ) 10.01.11 Created By ChungEunHo
	 * @param dFormat String
	 * @return String
	 */
	public static String getDateTime(String dFormat) 
	{
		GregorianCalendar cal = new GregorianCalendar();
	
	    int year = cal.get(GregorianCalendar.YEAR);
	    int mon  = cal.get(GregorianCalendar.MONTH)+1;
	    int day  = cal.get(GregorianCalendar.DAY_OF_MONTH);
	    int hour = cal.get(GregorianCalendar.HOUR_OF_DAY);
	    int min  = cal.get(GregorianCalendar.MINUTE);
	    int sec  = cal.get(GregorianCalendar.SECOND);
	    int msec = cal.get(GregorianCalendar.MILLISECOND);
	
	    String sYear = year + "";
	    String sMon  = (mon  < 10 ? "0"+mon  : mon+"" );
	    String sDay  = (day  < 10 ? "0"+day  : day+"" );
	    String sHour = (hour < 10 ? "0"+hour : hour+"");
	    String sMin  = (min  < 10 ? "0"+min  : min+"" );
	    String sSec  = (sec  < 10 ? "0"+sec  : sec+"" );
	    String sMsec;
	    if(msec == 0)           sMsec = "000";
	    else if(msec < 10)      sMsec = "00" + msec;
	    else if(msec < 100) 	sMsec = "0" + msec;
	    else                    sMsec = "" + msec;
	
	    String rValue = dFormat;
	    rValue = replaceStringAll(rValue, "Y", sYear);
	    rValue = replaceStringAll(rValue, "M", sMon );
	    rValue = replaceStringAll(rValue, "D", sDay );
	    rValue = replaceStringAll(rValue, "h", sHour);
	    rValue = replaceStringAll(rValue, "m", sMin );
	    rValue = replaceStringAll(rValue, "s", sSec );
	    rValue = replaceStringAll(rValue, "i", sMsec );
	
	    return(rValue);
	}

    
	/**
	 * 2-->02
	 * 
	 * @param nums
	 * @return
	 */
    public static String toLen2 ( int nums ) {
        String num=String.valueOf(nums).toString();

        if( num.length() == 1 )  num = "0" + num;

        return num;
    }
    
    /**
     * 
     * @param in
     * @param find
     * @param replace
     * @return
     */
    public static String replaceStringAll(String in, String find, String replace ) {
           if (in == null) {
                  return "";
           }

           String source = in;
           String keyStr = find;
           String toStr = replace;


           int startIndex = 0;
           int curIndex = 0;
           StringBuffer result = new StringBuffer();

           while ( ( curIndex = source.indexOf(keyStr, startIndex) ) >= 0) {
                     result.append(source.substring(startIndex, curIndex))
                           .append(toStr);
                     startIndex = curIndex + keyStr.length();
           }

          if (startIndex <= source.length() ) {
                  result.append(source.substring(startIndex, source.length()));
          }

           return result.toString();
    }
    
    /**
	 * 구분자를 넣은 문자열을 해쉬맵으로 생성한다.(JMS에서 사용)
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
	public static HashMap<String,String> createMap(String str) {
		HashMap<String,String> hm = new HashMap<String,String>();
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
	 * Sting문자를 입력받아 ","구분자로 잘라 List의 형태로 반환.
	 * 
	 * @param str String
	 * @return List<String>
	 */
	public static List<String> replaceStrToList(String str) {
		ArrayList<String>  array = new ArrayList<String>();
		
		StringTokenizer tokenTpszcd = new StringTokenizer(str, ",");
		
		while (tokenTpszcd.hasMoreTokens()) {
			array.add(tokenTpszcd.nextToken());
		}
		
		return array;
	}

	/**
	 * status에 따른 컬럼명 반환
	 * 
	 * @param status String
	 * @return String
	 */
	public static String locationType(String status){
		String locType = null;
		if( status.equals("R") ){
			locType = "RCC_CD";
		} else if( status.equals("L") ){
			locType = "LCC_CD";
		} else if( status.equals("E") ){
			locType = "ECC_CD";
		} else if( status.equals("C") ){
			locType = "CNT_CD";
		}
		
		return locType;
	}
	/**
	 * Sting문자를 입력받아 ","구분자로 자르고 해당 문자를 ''로 감싼 형태로 다시 반환.
	 * 
	 * @param str String
	 * @return String
	 */
	public static String convertStr(String str) {		
		return convertStr(str , false , 0);
	}
	/**
	 * Sting문자를 입력받아 ","구분자로 자르고 해당 문자를 ''로 감싼 형태로 다시 반환.
	 * 
	 * @param str String
	 * @param DefaultCheck boolean
	 * @return String
	 */
	public static String convertStr(String str , boolean DefaultCheck) {		
		return convertStr(str , DefaultCheck , 0);
	}

	/**
	 * Sting문자를 입력받아 ","구분자로 자르고 해당 문자를 ''로 감싼 형태로 다시 반환.
	 * 
	 * @param str String
	 * @param DefaultCheck boolean
	 * @param int length
	 * @return String
	 */
	public static String convertStr(String str , boolean DefaultCheck , int length) {
		StringBuffer buffer = new StringBuffer(512);
		StringTokenizer tokenTpszcd = new StringTokenizer(str, ",");
		int strSize = tokenTpszcd.countTokens();
		while (tokenTpszcd.hasMoreTokens()) {
			strSize--;
			String addStr = tokenTpszcd.nextToken();
			if(length != 0 && addStr != null && addStr.length() >= length){
				addStr = addStr.substring(0, length);
			}
			buffer.append("'" + addStr + "'");
			if (strSize != 0){
				buffer.append(",");
			}
		}
		// in 절에 sql 에러를 막기위한 조건
		if(buffer.toString().equals("") && DefaultCheck){
			buffer.append("''");
		}
		return buffer.toString();
	}
	
	/**
	 * 15개의 Container Type Size를 10개의 Type Size로 변환적용하기 위한 메소드.
	 * 
	 * @param tpsz String
	 * @return List<String>
	 */
	public static List<String> convertTpsz(String tpsz) {
		ArrayList<String>  array = new ArrayList<String>();
		//String tranTpsz = "";
		StringTokenizer tokenTpsz = new StringTokenizer(tpsz, ",");
		String tpsz_cd = "";
		
		while (tokenTpsz.hasMoreTokens()) {
			tpsz_cd = tokenTpsz.nextToken();
			
			if( tpsz_cd.equals("S2")){
				tpsz_cd = "O2";
			} else if ( tpsz_cd.equals("S4") ){
				tpsz_cd	= "O4";
			} else if ( tpsz_cd.equals("A2") ){
				tpsz_cd	= "F2";
			} else if ( tpsz_cd.equals("A4") ){
				tpsz_cd	= "F4";
			} else if ( tpsz_cd.equals("F5") ){
				tpsz_cd	= "F4";
			}
			array.add(tpsz_cd);
		}
		return array;
	}
}
