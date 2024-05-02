/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Utils.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcommon;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * ENIS-EQR Business Utils<br>
 * @author 
 * @see DBDAO, class 
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
	 * dateTime format 
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
	 * Utils.createMap("key1:value1|key2:value2|key3:value3");
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
	 * Sting to token "," character.
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
	 * status
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
	 * Sting
	 * 
	 * @param str String
	 * @return String
	 */
	public static String convertStr(String str) {		
		return convertStr(str , false , 0);
	}
	/**
	 * @param str String
	 * @param DefaultCheck boolean
	 * @return String
	 */
	public static String convertStr(String str , boolean DefaultCheck) {		
		return convertStr(str , DefaultCheck , 0);
	}

	/**
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
		 
		if(buffer.toString().equals("") && DefaultCheck){
			buffer.append("''");
		}
		return buffer.toString();
	}
	
	/**
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
