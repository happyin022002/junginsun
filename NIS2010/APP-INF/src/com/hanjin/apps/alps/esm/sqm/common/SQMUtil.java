/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SQMUtil.java
*@FileTitle : SQMUtil
*Open Issues :
*Change history :
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.common;

import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * NIS2010-SQMUtil Common Utility - 공통 로직을 처리한다.
 *
 * @see 
 * @since J2EE 1.6
 */
public class SQMUtil {
	
    private static transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SQMUtil.class);
	
 
    
	/**
	 * String이 java의 null 일 경우 원하는 값으로 치환한다.
	 * 
	 * @param String str Original String
	 * @param String replaceStr str이 Null일 경우 반환 받고자 하는 값.
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
	
    /**
     * code와 name으로 구성된 VO를 파라메터로 받아 '|'와 '\t'를 구분자로 하여
     * multicombo에서 사용가능한 String 배열로 구성해 return한다.
     * 
     * JSP LAYER에서의 사용 예)
     *  GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
     *  // Service Scope Combo Data 생성
     *  List<RsltCdListVO> comboData = (List<RsltCdListVO>)eventResponse.getCustomData("SvcScpCombo");
     *  svcScpCombo = SQMUtil.getValueObject2StringArray(comboData);
     *  
     *  <script language="javascript">
     *      var svcScpComboValue = "<%=svcScpCombo[0]%>";
     *      var svcScpComboText = "<%=svcScpCombo[1]%>";
     *  </script>
     *  
     * @param List<?> comboData
     * @return String[] 0번 idx에 code, 1번 idx에 text
     */
    public static String[] getValueObject2StringArray(List<?> comboData ) {
        return getValueObject2StringArray(comboData,true ,"|","\t","getCode","getName"); 
    }

    /**
     * code와 name으로 구성된 VO를 파라메터로 받아 '|' 구분자로 하여
     * multicombo에서 사용가능한 String 배열로 구성해 return한다.
     * 
     * 
     * JSP LAYER에서의 사용 예)
     *  GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
     *  // Service Scope Combo Data 생성
     *  List<RsltCdListVO> comboData = (List<RsltCdListVO>)eventResponse.getCustomData("SvcScpCombo");
     *  svcScpCombo = SQMUtil.getValueObject2StringArray(comboData,false);
     * 
     *  <script language="javascript">
     *      var svcScpComboValue = "<%=svcScpCombo[0]%>";
     *      var svcScpComboText = "<%=svcScpCombo[1]%>";
     *  </script>
     * 
     * @param List<?> comboData
     * @param boolean isIncludeCd false 일경우 Name에 Code를 같이 붙이지 않는다.
     * @return String[] 0번 idx에 code, 1번 idx에 text
     */
    public static String[] getValueObject2StringArray(List<?> comboData ,boolean isIncludeCd) {
        return getValueObject2StringArray(comboData,isIncludeCd ,"|","\t","getCode","getName"); 
    }

    /**
     * code와 name으로 구성된 VO를 파라메터로 받아 '|'와 '\t'를 구분자로 하여
     * multicombo에서 사용가능한 String 배열로 구성해 return한다.
     * 
     * @param List<?> comboData
     * @param boolean isIncludeCd false 일경우 Name에 Code를 같이 붙이지 않는다.
     * @param String rowSep 코드와 텍스트의 구분자
     * @param String colSep 텍스트에서 다중 컬럼을 구분하는 구분자
     * @return String[] 0번 idx에 code, 1번 idx에 text
     */
    public static String[] getValueObject2StringArray(List<?> comboData,boolean isIncludeCd,String rowSep,String colSep ) {
        return getValueObject2StringArray(comboData,isIncludeCd ,rowSep,colSep,"getCode","getName"); 
    }

    /**
     * code와 name으로 구성된 VO를 파라메터로 받아 '|'와 '\t'를 구분자로 하여
     * multicombo에서 사용가능한 String 배열로 구성해 return한다.
     * 
     * @param List<?> comboData
     * @param boolean isIncludeCd false 일경우 Name에 Code를 같이 붙이지 않는다.
     * @param String rowSep 코드와 텍스트의 구분자
     * @param String colSep 텍스트에서 다중 컬럼을 구분하는 구분자
     * @param String methodNmOfCd Code값을 읽어올수 있는 method명
     * @param String methodNmOfNm Name값을 읽어올수 있는 method명
     * @return String[] 0번 idx에 code, 1번 idx에 text
     */
    public static String[] getValueObject2StringArray(List<?> comboData,boolean isIncludeCd,String rowSep,String colSep,String methodNmOfCd,String methodNmOfNm){
        StringBuffer code = new StringBuffer();
        StringBuffer text = new StringBuffer();
        String[] rtnV = {"",""};
        try{
        
            if (comboData.size() > 0) {
                Class<?> tmp1 = null;
                Method mtd1 = null;
                Method mtd2 = null;
                String strNm = null;
                String strCd = null;
                int dataCount = comboData.size();
                for (int i = 0; i < dataCount; i++) {
                    tmp1 = comboData.get(i).getClass();
                    mtd1 = tmp1.getMethod(methodNmOfNm, new Class[0]);
                    strNm = (String)mtd1.invoke(comboData.get(i), new Object[0]);
                    mtd2 = tmp1.getMethod(methodNmOfCd, new Class[0]);
                    strCd = (String)mtd2.invoke(comboData.get(i), new Object[0]);
                    if( strNm == null ) strNm = "";
                    if( strCd == null ) strCd = "";
                    if (i != 0) {
                        text.append(rowSep);
                        code.append(rowSep);
                    }
                    if( isIncludeCd == true) {
                        text.append(strCd).append(colSep).append(strNm);
                    } else {
                        text.append(strNm);
                    }
                    code.append(strCd);
                }
            }
            rtnV[0] = code.toString();
            rtnV[1] = text.toString();   
        }catch(Exception de){
        	log.error("err " + de.toString(), de);
            return null;
        }
        return rtnV;
    }   
	
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
	 * Sting문자를 입력받아 ","구분자로 잘라 List의 형태로 반환.
	 * 
	 * @param str String
	 * @return List<String>
	 */
	public static List<String> replaceStringToList(String str) {
		List<String>  array = new ArrayList<String>();
		
		StringTokenizer tokenTpszcd = new StringTokenizer(str, ",");
		
		while (tokenTpszcd.hasMoreTokens()) {
			array.add(tokenTpszcd.nextToken());
		}
		
		return array;
	}

}
