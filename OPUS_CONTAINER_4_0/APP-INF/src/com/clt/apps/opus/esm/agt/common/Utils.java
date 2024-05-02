/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Utils.java
*@FileTitle : AGT Utility
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-25
*@LastModifier : junghyung kim
*@LastVersion : 1.0
* 2006-08-25 junghyung kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
//import com.clt.apps.opus.esm.agt.common.basic.CommonBC;
//import com.clt.apps.opus.esm.agt.common.basic.CommonBCImpl;
//import com.clt.apps.opus.esm.agt.common.event.CommonEvent;

/**
 * jsp에서 기본적으로 사용하는 Util method 모음 각 method는 static 이므로, JSPUtil.methodXXX() 로 호출하여 사용한다. <br>
 * JSPUtil의 method 는 크게 Request, 문자열 변환, HTML, Date 그리고, math 관련 method로 구성되어 있다.
 *
 * @author junghyung kim
 * @see ESM_AGT_xxx.jsp 참조
 * @since J2EE 1.4
 */
public class Utils {
	
	private static transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Utils.class);
	

	/**
	 * 비교한 값이 참이면 rtnTrue를 거짓이면 rtnFalse값을 리턴하는 함수 
	 * String rtnValue = Utils.iif(A.equals("1"), "Y", "N");
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
		String fillString = "";
	
		if(val.length() > 0) {
			for(int i = 0 ; i < (spaceNum - val.length()) ; i++ ) {
				fillString = fillString + spaceString.toString();
			}
		}
		
		if(flag == "left") {
			str = fillString + val;
		}else if(flag == "right") {
			str = val + fillString;
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
		
		log.debug(sysOut.toString());
		
		return hash;
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
			hm.put(temp.split(":")[0], temp.split(":")[1]);
		}
		return hm;
	}

}