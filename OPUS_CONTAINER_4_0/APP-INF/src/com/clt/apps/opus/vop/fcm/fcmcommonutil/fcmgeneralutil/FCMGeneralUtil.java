/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FCMGeneralUtil.java
 *@FileTitle : FCMGeneralUtil
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.11.28
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.11.28 진마리아
 * 1.0 Creation
 * 2014.06.24 R4J패치 사전 검토
=========================================================*/
package com.clt.apps.opus.vop.fcm.fcmcommonutil.fcmgeneralutil;

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
 * NIS2010-SchedulePlanningOperation Utility<br>
 * - NIS2010-SchedulePlanningOperation에서 사용되는 유틸리티 기능을 제공한다.<br>
 * 
 * @author SEO CHANG YUL
 * @see VesselScheduleMgtBCImpl
 * @since J2EE 1.4
 */
public class FCMGeneralUtil {
	
	private static Logger log = Logger.getLogger("com.clt.apps.opus.vop.fcm.fcmcommonutil.fcmgeneralutil");
	
	/**
	 * 문자열에 해당하는 날짜에서 몇일전후의 날짜를 문자열(yyyyMMdd) 형식으로 구한다.
	 *  
	 * @param String date 기준 문자열 날짜
	 * @param int value 전후일수
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
	 * boolean 배열에 true인 값이 존재하면 false를 반환하고, 그렇지 않으면 true를 반환한다.
	 * 
	 * @param boolean[] validDate 조회할 boolean 배열
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
	 * 주어진 문자열에 대한 하는 날짜가 어떤 요일인지 구한다.
	 * 
	 * @param String date 문자열날짜
	 * @return 문자열 "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" 중 하나
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
	 * 주어진 자연수 타입 문자열의 길이가 4이하인 경우, 좌측을 0으로 채운다.
	 * 예) "14" ==> "0014"
	 * 
	 * @param String voyNo 자연수 타입의 문자열
	 * @return String
	 */
	public static String getVoyNo(String voyNo){
		
		int iVoyNo = (voyNo==null || voyNo.length()==0) ? 0 : Integer.parseInt(voyNo);
		
		String strVoyNo = Integer.toString(iVoyNo);
		
		String tmp = "0";
		
		StringBuffer sbTmp	= new StringBuffer();
		
		for (int i=strVoyNo.length(); i<4; i++ ) {
			sbTmp.append(tmp);
		}
		
		sbTmp.append(strVoyNo);
		
		return sbTmp.toString();
		
	}
	
	/**
	 * 주어진 자연수 타입 문자열의 길이가 4이하인 경우, 지정한 수만큼 증가시키고 좌측을 0으로 채운다.
	 * 예) "14" ==> "0014"
	 * 
	 * @param String voyNo 자연수 타입의 문자열
	 * @param int growth 증가치
	 * @return String
	 */
	public static String nextVoyNo(String voyNo, int growth){
		
		int iVoyNo = (voyNo==null || voyNo.length()==0) ? 0 : Integer.parseInt(voyNo);
		iVoyNo = iVoyNo + growth;
		
		String nextVoyNo = Integer.toString(iVoyNo);
		
		String tmp = "0";
		
		StringBuffer sbTmp	= new StringBuffer();
		
		for (int i=nextVoyNo.length(); i<4; i++ ) {
			sbTmp.append(tmp);
		}
		
		sbTmp.append(nextVoyNo);
		
		return sbTmp.toString();
		
	}
	
	/**
	 * 주어진 문자열을 특정 날짜 포맷으로 읽으후, 대상 날짜 포맷으로 변환한다.
	 * 
	 * @param String date 기준 날짜 문자열
	 * @param String srcFormat 변환전 날짜 포맷
	 * @param String destFormat 변환후 날짜 포맷
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
	 * 두개의 문자열을 각각의 지정된 날짜 포맷으로 비교한다.
	 * 결과값이 -1이면 date1이 이전일자(date1<date2), 0이면 같은일자(date1=date2), 1이면 date2가 이전일자(date1>date2)
	 *   
	 * @param String date1
	 * @param String format1
	 * @param String date2
	 * @param String format2
	 * @return int
	 * @exception EventException
	 * @author Hyuk Ryu
	 * @date 2009. 11. 16.
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
	 * 해당 날짜에 지연된 시간(분)을 계산하여 반환.
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
	 * 해당 시간(yyyyMMddHHmm)의 분값이 basemin 미만이면 절삭, 초과면 올림처리한다.
	 * 예를 들어, 2007(HHmm)은 basemin이 30이면 절삭되어 2000(HHmm)이 된다.
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
	 * 두 날짜의 시간차를 구한다.<br>
	 * 
	 * @param String sDate1
	 * @param String pattern1	ex) yyyyMMddHHmm, yyyyMMddHHmmss
	 * @param String sDate2
	 * @param String pattern2	ex) yyyyMMddHHmm, yyyyMMddHHmmss
	 * @param String flag 반환할 단위(s:초, m:분, h:시간, d:일, Default:m(분))
	 * @return long
	 * @throws EventException
	 * @author jinwoo
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
				// 초
				diff = diffMillis / (1000);
			}else if("m".equals(flag)){
				// 분
				diff = diffMillis / (60 * 1000);
			}else if("h".equals(flag)){
				// 시
				diff = diffMillis / (60 * 60 * 1000);
			}else if("d".equals(flag)){
				// 일
				diff = diffMillis / (24 * 60 * 60 * 1000);
			}else{
				//Default 분
				diff = diffMillis / (60 * 1000);
			}
		} catch (ParseException e) {
			log.error(e.getMessage());
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), e);
		}
		return diff;
	}
	
	/**
	 * 공통코드를 조회하여 dataFlag 값에 해당하는 형식으로 값을 리턴한다.
	 * @param String comnCode String 조회할 공통코드
	 * @param String dataFlag String 리턴할 값의 형식
	 * @return String 조회한 코드
	 * @author jinwoo
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
	 * 주어진 문자열이 null이거나 길이가 0인 빈문자열(empty String)인 경우 false를 반환하고,
	 * 그렇지 않은 경우 true를 반환한다.
	 * 
	 * @param String strValue 점검할 문자열
	 * @return boolean
	 */
	public static boolean isNotNull(String strValue){
		if(strValue == null || "".equals(strValue)){
			return false;
		}
		
		return true;
	}
	
	/**
	 * 주어진 문자열이 null이거나 길이가 0인 빈문자열(empty String)인 경우 true를 반환하고,
	 * 그렇지 않은 경우 false를 반환한다.
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
	 * str1 이 Null 이 아니면 str1 을 반환, Null 이면 str2 반환
	 * 
	 * @param str1
	 * @param str2
	 * @return String
	 * @author jinwoo
	 */
	public static String nvl(String str1, String str2){
		String rtnStr = str1;
		
		if(!isNotNull(str1)){
			rtnStr = str2;
		}
		
		return rtnStr;
	}
	
	/**
	 * 입력받은 문자열중 대문자가 있으면 "_"+소문자로 변경하여 반환한다.
	 * 
	 * @param str
	 * @return
	 */
	public static String convertFiledName(String str){
		if(isNull(str)) return "";
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			if(Character.isUpperCase(ch)){
				sb.append("_"+Character.toLowerCase(ch));
			}else{
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	/**
	 * turnPortIndCd 를 받아 해당 Port 가 Virtual Port 인지 판단.
	 * 
	 * @param String turnPortIndCd
	 * @return boolean
	 * @author jinwoo
	 */
	public static boolean isVirtualPort(String turnPortIndCd){
		boolean rtnFlg = false;
		if("F".equals(turnPortIndCd) || "V".equals(turnPortIndCd) || "D".equals(turnPortIndCd)){
			rtnFlg = true;
		}
		return rtnFlg;
	}
	
	/**
	 * Stirng 을 int 로 전환
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
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
		return value;
	}
	
	/**
	 * 주어진 문자열이 NULL이거나 빈 문자열이면 숫자 0을 반환하고
	 * 그렇지 않은 경우 주어진 문자열을 반환한다.
	 * 
	 * @param String sParam 점검할 문자열
	 * @return String
	 * @author jinwoo
	 */
	public static String getCheckNullToZero(String sParam){
		if(sParam == null || "".equals(sParam)){
			return "0";
		}
		
		return sParam;
	}
	
	/**
	 * Date Type의 String 을 받아 구분자를 제거하고 반환한다.
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
	 * Number Type의 String 을 받아 (,)구분자를 제거하고 반환한다.
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
	 * 입력받은 Data 를 해당 자리수만큼으로 변환하여 결과값을 String 으로 반환한다.
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
	 * 인수가 문자타입의 조건절인경우의 SQL의 IN절 문자 생성
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
	 * 주어진 문자열이 NULL이거나 빈 문자열이면 문자 ""을 반환하고
	 * 그렇지 않은 경우 주어진 문자열을 반환한다.
	 * 
	 * @param String sParam 점검할 문자열
	 * @return String
	 * @author jinwoo
	 */
	public static String getCheckNullToString(String sParam){
		if(sParam == null || "".equals(sParam)){
			return "";
		}
		
		return sParam;
	}
	
	/**
	 * 주어진 문자열이 NULL이거나 빈 문자열이면 문자 "N"을 반환하고
	 * 그렇지 않은 경우 주어진 문자열을 반환한다.
	 * 
	 * @param String sParam 점검할 문자열
	 * @return String
	 * @author jinwoo
	 */
	public static String getCheckNotToString(String sParam){
		if(sParam == null || "".equals(sParam)){
			return "N";
		}
		
		return sParam;
	}
	
	/**
	 * SUN 의 BASE64Encode 를 이용한 Encode.
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
	 * SUN 의 BASE64Encode 를 이용한 Decode.
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
