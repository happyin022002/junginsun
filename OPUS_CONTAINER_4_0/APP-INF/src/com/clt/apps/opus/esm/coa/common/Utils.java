/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName 		: Utils.java
*@FileTitle 	: 
*Open Issues 	:
*Change history :
*@LastModifyDate: 2006-
*@LastModifier 	: eunju park
*@LastVersion 	: 1.0
* 2006- eunju park
* 1.0 최초 생성
* 2009.02.02 임옥영 N200901190016   COA_조직개편 관련 기능 수정 getCurrentCostYrmon추가
* 2009.03.26 박은주 : 품질검토결과 수정사항 반영     
* 2009.08.25 임옥영 checkStdCostCode DAO에 해당 메소드 없어서 Utils.java, CommonBC, CommonBCImple에서 삭제함  
* 2010.02.04 임옥영 :품질검토결과 반영   
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정 
=========================================================*/

package com.clt.apps.opus.esm.coa.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 * @author Administrator
 * @see 
 * @since J2EE 1.4
 */
public class Utils{
	private static transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Utils.class);
		
	/**
	 * 비교한 값이 참이면 rtnTrue를 거짓이면 rtnFalse값을 리턴하는 함수 
	 *        String rtnValue = Utils.iif(A.equals("1"), "Y", "N");
	 *        
	 * @param expression  비교문장
	 * @param rtnTrue     expression이 참일때 리턴할 값
	 * @param rtnFalse    expression이 거짓일때 리턴할 값.
	 * @return
	 */
	public static String iif(boolean expression, String rtnTrue, String rtnFalse){
		String rtnValue = "";
		
		if(expression){
			rtnValue = rtnTrue;
		}else{
			rtnValue = rtnFalse;
		}
		return rtnValue;
	}

	/**
	* 설명      : 1를 001로 세팅할 때 사용
	* 
	* @param  str         - String.valueOf(숫자)
	* @param  spaceNum    - 자리수
	* @param  spaceString - 채울 값
	* @param flag        - 왼쬭, 오른쪽
	* @return String
	*/
	public static String fillSpace(String str, int spaceNum, String spaceString, String flag){
		String val = str.trim();
		//String fillString = "";
		StringBuffer sb = new StringBuffer();
	
		if(val.length() > 0) {
			for(int i = 0 ; i < (spaceNum - val.length()) ; i++ ) {
				//fillString = fillString + spaceString.toString();
				sb.append(spaceString);
			}
		}
		
		if(flag.equals("left")) {
			//str = fillString + val;
			str = sb + val;
		}else if(flag.equals("right")) {
			//str = val + fillString;
			str = val + sb;
		}
	
		return str;
	}
	
	/**
	 * 1/0 --> Y/N로 바꾸어 리턴하는 함수
	 * 
	 * @param str			1/0
	 * @return String
	 */
	public static String change10ToYN(String str){
		String tmpS = "N";
		if(str != null){
			if("1".equals(str)){
				tmpS="Y";
			}
		}
		return tmpS;
	}
	
	/**
	 * 화면에서 넘긴 request 객체의 데이터를 HashMap에 입력하여 HashMap객체를 리턴한다.
	 * 
	 * key   : 화면의 컨트롤객체 이름
	 * value : 화면의 컨트롤객체 값
	 * 
	 * @param request
	 * @return HashMap
	 */
	@SuppressWarnings("unchecked")
	public static HashMap requestToHashMap(HttpServletRequest request){
		// requestToHashMap(HttpServletRequest request)
		HashMap hash = new HashMap();
		Map map = request.getParameterMap();
		Iterator it = map.keySet().iterator();
		Object key = null;
		String[] value = null;
		StringBuffer sysOut = new StringBuffer();
		
		while(it.hasNext()){
			key = it.next();
			value = (String[])map.get(key);
			hash.put(key, value);
			sysOut.append("\n key[" +Utils.fillSpace((String)key, 15, " ", "right")+ "] : [");
			for(int i=0; i<value.length; i++){
				sysOut.append(value[i] );
				if(i != value.length-1)sysOut.append( " : ");
			}
			sysOut.append("]");
		}
		
		log.info(sysOut.toString());
		
		return hash;
	}
	
	/**
	 * 화면에서 넘긴 request 객체의 데이터 중 특정항목에 대해서 Array로 리턴한다.
	 * 
	 * key   : 화면의 컨트롤객체 이름
	 * 
	 * @param request
	 * @param key
	 * @return String[]
	 */
	@SuppressWarnings("unchecked")
	public static String[] requestToArray(HttpServletRequest request, String key){
		String[] value = null;
		Map map = request.getParameterMap();
		
		value = (String[])map.get(key);
		return value;
	}
	
	/**
	 * 
	 * @param param
	 * @param seperator
	 * @return
	 */
	public static String addDateSeperator(String param, String seperator){
		String rtnValue="";
		
		if(param.length() == 6){
			rtnValue = param.substring(0,4) + seperator + param.substring(4,6);
		}else if(param.length() == 8){
			rtnValue = param.substring(0,4) + seperator + param.substring(4,6) + seperator + param.substring(6,8);
		}else{
			rtnValue = param;
		}
		return rtnValue;
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
	@SuppressWarnings("unchecked")
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
	 * 구분자를 넣은 문자열을 해쉬맵으로 생성한다.
	 * 예)
	 * Utils.createMapIsNull("key1:value1|key2:value2|key3:value3");
	 * 다음 데이터를 가진 해쉬맵으로 리턴한다.
	 * key1:value1
	 * key2:value2
	 * key3:value3
	 * 
	 * @param str
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static HashMap createMapIsNull(String str) {
		HashMap hm = new HashMap();
		StringTokenizer st = new StringTokenizer(str, "|");
		String temp = "";
		while (st.hasMoreTokens()) {
			temp = st.nextToken();

			// value값이 없어도 Map에 넣어주도록 함.
			if(temp.split(":").length > 1) {
				hm.put(temp.split(":")[0], temp.split(":")[1]);
				log.debug("["+temp.split(":")[0]+"]:["+temp.split(":")[1]+"]");
			} else {
				hm.put(temp.split(":")[0], "");
				log.debug("["+temp.split(":")[0]+"]:[]");
			}
		}
		return hm;
	}
	
	
	/**
	 * 현재 년월을 가져온다.
	 * 
	 * @param 
	 * @return ofc_cd
	 */
	public static String getCurrentMon(){

		int currentMonth = com.clt.framework.component.util.DateTime.getMonth();
		
log.debug("\n\nUtils.getCurrentCostMon currentMonth=" + currentMonth);		
		return currentMonth<10? "0"+  currentMonth :""+ currentMonth;
	}
	
	/**
	 * 여러개의 parameter 를 병합시켜 메소드
	 *
	 * @param String sparameter
	 * @param String sSeperate
	 * @return List<String>
	 */
	public static List<String> mergeParameter(String sparameter, String sSeperate) {
		List<String> arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList<String>();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}	
	
	/**
	 * 여러개의 parameter 를 나누어주는 메소드
	 * 
	 * @param String sparameter
	 * @param String sSeperate
	 * @return List<String>
	 */
	public static List<String> seperationParameter(String sparameter, String sSeperate) {
		List<String> arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList<String>();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}	
	
	
	/**
	 * yrmon 기준으로 count 만큼 이전 년월을 조회한다.
	 * 
	 * @param String yrmon
	 * @param int count
	 * @return String[]
	 */
	public static String[] getYearMonthList(String yrmon, int count) throws ParseException {	
		String[] value = new String[count];

		Calendar sDate = Calendar.getInstance();
		Calendar eDate = Calendar.getInstance();	
		
		if(!yrmon.equalsIgnoreCase("") && !yrmon.equalsIgnoreCase(null)) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
	        Date date = format.parse(yrmon); 
	        sDate.setTime(date); 
	        eDate.setTime(date);
		}
        
		//오늘날짜를 포함하여 산출하기 위하여 count-1 처리.
        eDate.add(Calendar.MONTH, (count-1) * -1); // count 만큼 이전 년월 
            		
		int iYear = sDate.get(Calendar.YEAR);
		int iMonth = sDate.get(Calendar.MONTH) + 1;
		
		value[0] = iYear + (iMonth < 10 ? "0"+iMonth: ""+iMonth); //오늘 날짜
		
		int cnt = 1;
		while(eDate.before(sDate)) {	
			sDate.add(Calendar.MONTH, -1); //일개월씩 감소
			
			iYear = sDate.get(Calendar.YEAR);
			iMonth = sDate.get(Calendar.MONTH) + 1;
			
			value[cnt] = iYear + (iMonth < 10 ? "0"+iMonth: ""+iMonth);
			cnt ++;
		}
		
		return value;
	}
	
}