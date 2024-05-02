/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VSKGeneralUtil.java
 *@FileTitle : VSKGeneralUtil
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommonutil.vskgeneralutil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic.VesselScheduleMgtBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.EventException;

/**
 * SchedulePlanningOperation Utility<br>
 * - Provide utility using in SchedulePlanningOperation<br>
 * 
 * @author 
 * @see VesselScheduleMgtBCImpl
 * @since J2EE 1.4
 */
public class VSKGeneralUtil {
	
	private static Logger log = Logger.getLogger("com.clt.apps.scheduleplanningoperation.vesselschedulemgt");
	
	/** OFFICE CODE **/
	public static final String OFC_MODULE = "VSK";
	
	/** CANAL **/
	public static final String SUEZ_CANAL = "EGSCA";
	public static final String PANAMA_CANAL = "PAPCA";
	
	/** BATCH DATASOURCE **/
	public static final String BATCH_DATASOURCE = "VSK_OPUSBAT";
	
	/** MSG CODE **/
	public static final String VSK00011 = "VSK00011"; // Unexpected system error took place during data processing. Please try again. : {?msg1}
	
	/**
	 * Getting String type Date (yyyyMMdd)
	 *  
	 * @param String date
	 * @param int value
	 * @return String
	 */
	public static String getActionDate(String date, int value){
		
//		value = value-1;
		Calendar cal = Calendar.getInstance();
		cal.set(
				Integer.parseInt(date.substring(0,4)),
				Integer.parseInt(date.substring(4, 6))-1,
				Integer.parseInt(date.substring(6,8))
		);
		cal.add(Calendar.DAY_OF_MONTH, value);
		
		Date d = cal.getTime();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");

		return sf.format(d);
	}
	
	/**
	 * Returning false in case true exist in boolean array, else returning true
	 * 
	 * @param boolean[] validDate
	 * @return boolean
	 */
	public static boolean isFinish(boolean[] validDate){
		boolean flag = true;
		for(boolean b : validDate){
			if(b){
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * Getting day with given date
	 * 
	 * @param String date
	 * @return String
	 */
	public static String getDay(String date){
		
		if(date==null || date.trim().length()==0){
			return "";
		}
		
		String day = null;
		Calendar cal = Calendar.getInstance();
		cal.set(
				Integer.parseInt(date.substring(0,4)),
				Integer.parseInt(date.substring(4, 6))-1,
				Integer.parseInt(date.substring(6,8))
		);
		if(Calendar.SUNDAY == cal.get(Calendar.DAY_OF_WEEK)){
			day = "SUN";
		}else if(Calendar.MONDAY == cal.get(Calendar.DAY_OF_WEEK)){
			day = "MON";
		}else if(Calendar.TUESDAY == cal.get(Calendar.DAY_OF_WEEK)){
			day = "TUE";
		}else if(Calendar.WEDNESDAY == cal.get(Calendar.DAY_OF_WEEK)){
			day = "WED";
		}else if(Calendar.THURSDAY == cal.get(Calendar.DAY_OF_WEEK)){
			day = "THU";
		}else if(Calendar.FRIDAY == cal.get(Calendar.DAY_OF_WEEK)){
			day = "FRI";
		}else if(Calendar.SATURDAY == cal.get(Calendar.DAY_OF_WEEK)){
			day = "SAT";
		}else{
			day = "";
		}
		return day;
	}
	
	/**
	 * in case of given String length <=4, fill with 0 from left
	 * ex) "14" ==> "0014"
	 * 
	 * @param String voyNo
	 * @return String
	 */
	public static String getVoyNo(String voyNo){
		
		int iVoyNo = (voyNo==null || voyNo.length()==0) ? 0 : Integer.parseInt(voyNo);
		
		String strVoyNo = Integer.toString(iVoyNo);
		StringBuffer sbVoyNo = new StringBuffer();
		String tmp = "0";
		while(strVoyNo.length()<4){
//			strVoyNo = tmp + strVoyNo;
			sbVoyNo.append(tmp);
			sbVoyNo.append(strVoyNo);
			strVoyNo = sbVoyNo.toString();//0추가
			sbVoyNo.delete(0, sbVoyNo.length());//초기화
		}
		
		return strVoyNo;
		
	}
	
	/**
	 * in case of given String length <=4, increasing some value and fill with 0 from left
	 * 예) "14" ==> "0014"
	 * 
	 * @param String voyNo
	 * @param int growth
	 * @return String
	 */
	public static String nextVoyNo(String voyNo, int growth){
		
		int iVoyNo = (voyNo==null || voyNo.length()==0) ? 0 : Integer.parseInt(voyNo);
		iVoyNo = iVoyNo + growth;
		
		String nextVoyNo = Integer.toString(iVoyNo);
		StringBuffer sbNextVoyNo = new StringBuffer();
		
		String tmp = "0";
		while(nextVoyNo.length()<4){
//			nextVoyNo = tmp + nextVoyNo;
			sbNextVoyNo.append(tmp);
			sbNextVoyNo.append(nextVoyNo);
			nextVoyNo = sbNextVoyNo.toString();//0추가
			sbNextVoyNo.delete(0, sbNextVoyNo.length());//초기화
		}
		
		return nextVoyNo;
		
	}
	
	/**
	 * Change Data format
	 * 
	 * @param String date
	 * @param String srcFormat
	 * @param String destFormat
	 * @return String
	 * @exception EventException
	 */
	public static String changeDateFormat(String date, String srcFormat, String destFormat) throws EventException {
		if("".equals(date)){
			return "";
		}
		String str = null;
		SimpleDateFormat sf = new SimpleDateFormat(srcFormat);
		try {
			Date d = sf.parse(date);
			sf.applyPattern(destFormat);
			str = sf.format(d);
		} catch (ParseException e) {
			log.error(e.getMessage());
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), e);
		}
		return str;
	}
	
	/**
	 * Comparing two String with specific data format
	 *   
	 * @param String date1
	 * @param String format1
	 * @param String date2
	 * @param String format2
	 * @return int
	 * @exception EventException
	 */
	public static int compareSkdDate(String date1, String format1, String date2, String format2) throws EventException {
		SimpleDateFormat sf = new SimpleDateFormat();
		try{
			sf.applyPattern(format1);
			Date d1 = sf.parse(date1);
			sf.applyPattern(format2);
			Date d2 = sf.parse(date2);
			
			if(d1.before(d2)){
				return -1;
			}else if(d1.after(d2)){
				return 1;
			}else{
				return 0;
			}
			
		} catch (ParseException e) {
			log.error(e.getMessage());
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), e);
		}
	}
	
	/**
	 * Returning delayed time(minute)
	 * 
	 * @param String sDate
	 * @param int min
	 * @return String
	 * @throws EventException
	 */
	public static String addDelayTime(String sDate, int min) throws EventException {
		String pattern = "yyyyMMddHHmm";
		String dlayDate = "";
		try{
			DateFormat df = new SimpleDateFormat(pattern);
			Date date = new SimpleDateFormat(pattern).parse(sDate);
			Calendar calendar = new GregorianCalendar();
			
			calendar.setTime(date);
			calendar.add(Calendar.MINUTE, min);
			
			dlayDate = df.format(calendar.getTime());
		} catch (ParseException e) {
			log.error(e.getMessage());
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), e);
		}
		return dlayDate;
	}
	
	/**
	 * round Minute of Time based on parameter(basemin)
	 * ex) sDate : 2007(HHmm), basemin : 30 -> 2000(HHmm)
	 * 
	 * @param sDate
	 * @param basemin
	 * @return String
	 * @throws EventException
	 */
	public static String controlTime(String sDate, int basemin) throws EventException {
		String pattern = "yyyyMMddHHmm";
		String dlayDate = "";
		try{
			DateFormat df = new SimpleDateFormat(pattern);
			Date date = new SimpleDateFormat(pattern).parse(sDate);
			Calendar calendar = new GregorianCalendar();
			
			calendar.setTime(date);
			int min = calendar.get(Calendar.MINUTE);
			
			if(basemin > min){
				calendar.add(Calendar.MINUTE, -min);
			}else if(basemin < min){
				calendar.add(Calendar.MINUTE, 60-min);
			}
			
			dlayDate = df.format(calendar.getTime());
		} catch (ParseException e) {
			log.error(e.getMessage());
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), e);
		}
		return dlayDate;
	}
	
	/**
	 * Calculating difference of 2 days
	 * 
	 * @param String sDate1
	 * @param String pattern1	ex) yyyyMMddHHmm, yyyyMMddHHmmss
	 * @param String sDate2
	 * @param String pattern2	ex) yyyyMMddHHmm, yyyyMMddHHmmss
	 * @param String flag 반환할 단위(s:초, m:분, h:시간, d:일, Default:m(분))
	 * @return long
	 * @throws EventException
	 */
	public static long dateDiff(String sDate1, String pattern1, String sDate2, String pattern2, String flag) throws EventException {
		long  diff = 0L;
		
		try{
			Date date1 = new SimpleDateFormat(pattern1).parse(sDate1);
			Calendar dateCal1 = new GregorianCalendar();
			dateCal1.setTime(date1);
	
			Date date2 = new SimpleDateFormat(pattern2).parse(sDate2);
			Calendar dateCal2 = new GregorianCalendar();
			dateCal2.setTime(date2);
			     
			long diffMillis = dateCal2.getTimeInMillis() - dateCal1.getTimeInMillis();
	
			if("s".equals(flag)){
				// seq
				diff = diffMillis / (1000);
			}else if("m".equals(flag)){
				// min
				diff = diffMillis / (60 * 1000);
			}else if("h".equals(flag)){
				// hour
				diff = diffMillis / (60 * 60 * 1000);
			}else if("d".equals(flag)){
				// day
				diff = diffMillis / (24 * 60 * 60 * 1000);
			}else{
				//Default minute
				diff = diffMillis / (60 * 1000);
			}
		} catch (ParseException e) {
			log.error(e.getMessage());
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), e);
		}
		return diff;
	}
	
	/**
	 * Retrieving common code and Returning code base on dataFlag
	 * @param String comnCode
	 * @param String dataFlag
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	public static String comnCodeList(String comnCode, String dataFlag){
//		String tempCd = "CD00717";
		if(comnCode == null || "".equals(comnCode)){
			return "";
		}
		
		CodeUtil codeUtil = CodeUtil.getInstance();		
		ArrayList<CodeInfo> list = (ArrayList<CodeInfo>)codeUtil.getCodeSelect(comnCode, 1);
		StringBuilder sb = new StringBuilder();
		
		if(list != null && list.size() > 0){
			if("onlycode".equals(dataFlag)){
				sb.append(list.get(0).getCode());
				
				for (int i=1; i<list.size(); i++) {
					sb.append("|");
					sb.append(list.get(i).getCode());
				}
			}else if("onlyname".equals(dataFlag)){
				sb.append(list.get(0).getName());
				
				for (int i=1; i<list.size(); i++) {
					sb.append("|");
					sb.append(list.get(i).getName());
				}
			}else{
				sb.append(list.get(0).getCode());
				sb.append("\t");
				sb.append(list.get(0).getName());
				
				for (int i=1; i<list.size(); i++) {
					sb.append("|");
					sb.append(list.get(i).getCode());
					sb.append("\t");
					sb.append(list.get(i).getName());
				}
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * Returning false in case inputed String is null or length is 0, else true
	 * 
	 * @param String strValue
	 * @return boolean
	 */
	public static boolean isNotNull(String strValue){
		if(strValue == null || "".equals(strValue)){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Returning true in case inputed String is null or length is 0, else false
	 * 
	 * @param String strValue 점검할 문자열
	 * @return boolean
	 */
	public static boolean isNull(String strValue){
		if(strValue == null || "".equals(strValue)){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returning str1 in case str1 is not null, else str2
	 * 
	 * @param str1
	 * @param str2
	 * @return String
	 */
	public static String nvl(String str1, String str2){
		String rtnStr = str1;
		
		if(!isNotNull(str1)){
			rtnStr = str2;
		}
		
		return rtnStr;
	}
	
	/**
	 * Replacing Upper Case to "_"+Lower Case
	 * 
	 * @param str
	 * @return
	 */
	public static String convertFiledName(String str){
		if(isNull(str)) return "";
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<str.length(); i++){
//			System.out.println(str.charAt(i));
			char ch = str.charAt(i);
			if(Character.isUpperCase(ch)){
				sb.append("_"+Character.toLowerCase(ch));
			}else{
				sb.append(ch);
			}
		}
//		System.out.println(sb.toString());
		return sb.toString();
	}
	
	/**
	 * Judging port from turnPortIndCd is virtual port
	 * 
	 * @param String turnPortIndCd
	 * @return boolean
	 */
	public static boolean isVirtualPort(String turnPortIndCd){
		boolean rtnFlg = false;
		if("F".equals(turnPortIndCd) || "V".equals(turnPortIndCd) || "D".equals(turnPortIndCd)){
			rtnFlg = true;
		}
		return rtnFlg;
	}
	
	/**
	 * Converting Stirng to int
	 * 
	 * @param String str
	 * @return int
	 * @throws EventException
	 */
	public static int convertNumberByString(String str) throws EventException{
		int value = 0;
		try{
			value = Integer.parseInt(str);
		}catch(NumberFormatException ne){
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
		return value;
	}
	
	/**
	 * Returning 0 in case inputed String is null or empty, else inputed String
	 * 
	 * @param String sParam
	 * @return String
	 */
	public static String getCheckNullToZero(String sParam){
		if(sParam == null || "".equals(sParam)){
			return "0";
		}
		
		return sParam;
	}
	
	/**
	 * Deleting division String and Returning
	 * ex) "2008-12-21 07:12" => "200812210712"
	 * 
	 * @param String sDate
	 * @return String
	 */
	public static String replaceDateTypeToString(String sDate){
		String returnStr = "";
		
		if(isNotNull(sDate)){
			returnStr = sDate.replace("-", "");
			returnStr = returnStr.replace(":", "");
			returnStr = returnStr.replace(" ", "");
			returnStr = returnStr.replace("/", "");
		}
		
		return returnStr;
	}
	
	/**
	 * Deleting ',' and Returning
	 * ex) "999,999,999.99" => "999999999.99"
	 * 
	 * @param String sNumber
	 * @return String
	 */
	public static String replaceNumberTypeToString(String sNumber){
		String returnStr = "";

		if(isNotNull(sNumber)){
			returnStr = sNumber.replace(",", "");
		}

		return returnStr;
	}
	
	/**
	 * Converting by number of digits and Returning as String
	 * 
	 * @param double dValue
	 * @param int scale
	 * @return String
	 */
	public static String roundHalfUp(double dValue, int scale){
		BigDecimal bDecimal = new BigDecimal(dValue).setScale(scale, BigDecimal.ROUND_HALF_UP);
		return bDecimal.toString();
	}

	/**
	 * Making String for using 'IN' in 'SQL'
	 * 'A,B,C' ==> "'A','B','C'"
	 *  
	 * @param String[] strArr
	 * @return String
	 */
	public static String replaceSqlChar(String[] strArr) {
		
		StringBuilder sb = new StringBuilder();
		
		if (strArr == null || strArr.length < 1) {
			return null;
		}
		
		sb.append("'");
		sb.append(strArr[0]);
        for (int i=1; i<strArr.length; i++) {
        	sb.append("','");
        	sb.append(strArr[i].trim());
		}
        sb.append("'");
        
        return sb.toString();
	}
	
	/**
	 * Returning "" in case inputed String is null or empty, else inputed String
	 * 
	 * @param String sParam
	 * @return String
	 */
	public static String getCheckNullToString(String sParam){
		if(sParam == null || "".equals(sParam)){
			return "";
		}
		
		return sParam;
	}
	
	/**
	 * Returning N in case inputed String is null or empty, else inputed String
	 * 
	 * @param String sParam 점검할 문자열
	 * @return String
	 */
	public static String getCheckNotToString(String sParam){
		if(sParam == null || "".equals(sParam)){
			return "N";
		}
		
		return sParam;
	}
	
	/**
	 * Encoding using BASE64Encode of SUN
	 * @param String sEncode
	 * @return String
	 */
	public static String encode(String sEncode){
		if(sEncode == null || sEncode.trim().length() == 0)	return null;

		String result = null;

		try{
			BASE64Encoder b64e = new BASE64Encoder();
			ByteArrayInputStream bais = new ByteArrayInputStream(sEncode.getBytes());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] bytes = (byte[]) null;

			b64e.encodeBuffer(bais, baos);
			bytes = baos.toByteArray();
			result = (new String(bytes)).trim();

		}catch(Exception e){
			log.error(e.getMessage());
		}

		return result;
	}
	
	/**
	 * Decoding using BASE64Encode of SUN
	 * 
	 * @param String sDecode
	 * @return String
	 */
	public static String decode(String sDecode){
		if(sDecode == null || sDecode.trim().length() == 0) return null;
		
		String result = null;

		try{
			BASE64Decoder b64d = new BASE64Decoder();
			ByteArrayInputStream bais = new ByteArrayInputStream(sDecode.getBytes());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] bytes = (byte[]) null;

			b64d.decodeBuffer(bais, baos);
			bytes = baos.toByteArray();
			result = new String(bytes);

		}catch(Exception e){
			log.error(e.getMessage());
		}

		return result;
	}
}
