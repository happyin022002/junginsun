/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GemUtil.java
 *@FileTitle : Gem공통 함수 유틸 클래스
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.17
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.17 최정미 , 진윤오
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.common;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Vector;

import com.clt.framework.component.rowset.DBRowSet;

/**
 * GEM공통 자바 유틸 클래스 
 * @author cyo
 * @see
 * @since
 */
public class GemUtil {

	
	/**
	 * 관리자 여부 
	 */
	public static final String USR_AUTH_TP_CD = "S";
	
	/**
	 * dbRowSet을 특정 컬럼의 String[] 로 변환 
	 * @param dbRowSet dbrowset
	 * @param column  디비 컬럼명 
	 * @return 특정 컬럼의 String[]
	 * @throws SQLException 
	 */
	public static String[] getArrayString(DBRowSet dbRowSet , String column) throws SQLException {
		
		if (dbRowSet == null) {
			return null;
		}
		
		int cnt = dbRowSet.getRowCount();
		if (cnt == 0) {
			return new String[0];
		}
		
		String[] arr = new String[cnt];
		int i = 0;
		
		while (dbRowSet.next()) {
			arr[i++] = dbRowSet.getString(column);
		}
		
		return arr;
		
		
	}
	
	/**
	 * dbRowSet을 특정 컬럼의 String[] 로 변환 
	 * @param dbRowSet dbrowset
	 * @param idx  컬럼 index  1부터 시작  
	 * @return 특정 컬럼의 String[]
	 * @throws SQLException 
	 */
	public static String[] getArrayString(DBRowSet dbRowSet , int idx) throws SQLException {
		
		if (dbRowSet == null) {
			return null;
		}
		
		int cnt = dbRowSet.getRowCount();
		if (cnt == 0) {
			return new String[0];
		}
		
		String[] arr = new String[cnt];
		int i = 0;
		
		while (dbRowSet.next()) {
			arr[i++] = dbRowSet.getString(idx);
		}
		
		return arr;
		
		
	}	
	
	

	/**
	 * 배열을 특정문자를 추가하여 하나의 문자열로 반환 
	 * @param arr 입력 문자배열
	 * @param spChar 분리분자 기본값 "|"
	 * @return
	 */
	public static String addSpChar(String[] arr , String spChar) {
		
		if (arr == null) {
			return null;
		}
		
		if (arr.length == 0) {
			return "";
		}
		
		StringBuffer sb = new StringBuffer();
		
		if (spChar == null || spChar.trim().equals("")) {
			spChar = "|";
		}
		
		for (int i = 0; i < arr.length; i++) {			
			sb.append(spChar).append(arr[i]);
		}
		
		return sb.substring(1);
	}

	
	/**
	 * 배열을 특정문자를 추가하여 하나의 문자열로 반환 
	 * @param arr 입력 문자배열 기본값 "|" 
	 * @return
	 */
	public static String addSpChar(String[] arr) {		
		return addSpChar(arr, "|");
	}
	
	
	/**
	 *  인수가 넘버타입의 조건절인경우의 SQL의 IN절 문자 생성
	 *  [100,200,300] ==> "100,200,300"
	 * @author 진윤오
	 * @param e
	 * @return
	 */
	public static String getInSqlNum(String[] numStr) {
        
		StringBuffer sb = new StringBuffer();
		
		if ( numStr == null ) {
			return null;
		}
		
        for (int i = 0; i < numStr.length; i++) {
        	String in = numStr[i];        	
        	//넘버
        	sb.append(in.trim()).append(",");
		}
         
        return  sb.substring(0,sb.lastIndexOf(","));
        
	}	

	/**
	 *  인수가 문자타입의 조건절인경우의 SQL의 IN절 문자 생성
	 *  [100,200,300] ==> "'100','200','300'"
	 * @author 진윤오
	 * @param e
	 * @return
	 */
	public static String getInSqlChar(String[] str) {
		
		StringBuffer sb = new StringBuffer();
		
		if ( str == null || str.length == 0) {
			return null;
		}
		
		int cnt = 0;
		
        for (int i = 0; i < str.length; i++) {
        	String in = str[i];       	
        	if (in != null && !in.trim().equals("")) {
	        	sb.append("'");
	        	//문자  
	        	sb.append(in.trim()).append("',");
	        	cnt++;
        	}
		}
        
        if (cnt > 0) {
        	return sb.substring(0,sb.lastIndexOf(","));
        }
        
        return "";
        

	}		
	
	/**
	 * 기능 : 문자열 분리
	 * 
	 * @author choijungmi
	 * @param source
	 * @param sp
	 * @return
	 */
	public String[] split(String source , String sp) throws Exception { 
		Vector<Object> newarray = new Vector<Object>();
		int i = 0;
		int inpos = 0;
		String temp = "";
		String[] sarray = null;
		
		try{
			while(source.length() > 0){
				inpos = source.indexOf(sp);
				if(inpos < 0){
					inpos = source.length();
				}
				temp = source.substring(0 , inpos);
				newarray.addElement(temp);
				if(inpos != source.length()){
					source = source.substring((inpos + sp.length()),source.length());
				}else{
					source = "";
				}
				i ++;
			}
			sarray = new String[i];
			for(int j = 0 ; j < i ; j++){
				sarray[j] = newarray.elementAt(j).toString();
			}
		}catch (Exception e){
			throw  e;
		}
		return sarray;
	}
	
	
	
	
	
	/**
	 * 로컬을 USD금액으로 환산
	 * 
	 * @author cyo
	 * @param source
	 * @param lclAmt 로컬금액 
	 * @param utVal 로컬금액입력단위
	 * @param usdLoclXchRt   usd : LCL 비율
	 * @return
	 */
	public static BigDecimal getLclToUsdAmt(BigDecimal lclAmt , BigDecimal utVal , BigDecimal usdLoclXchRt) {
		
		if (utVal == null || utVal.intValue() == 0) {
			return new BigDecimal(0);
		}
		
		if (usdLoclXchRt == null || usdLoclXchRt.floatValue() <= 0) {
			return new BigDecimal(0);
		}


		
		BigDecimal usdAmt = lclAmt.multiply(utVal);		
		
		if (lclAmt.intValue() < 0) {
			usdAmt = usdAmt.divide(usdLoclXchRt, BigDecimal.ROUND_FLOOR);
		} else {
			usdAmt = usdAmt.divide(usdLoclXchRt, BigDecimal.ROUND_CEILING);	
		}
		
		return usdAmt;
	}	
	
	/**
	 * 로컬을 KRW금액으로 환산
	 * 
	 * @author cyo
	 * @param source
	 * @param lclAmt 로컬금액 
	 * @param utVal 로컬금액입력단위
	 * @param usdKrwXchRt usd : KRW 비율
	 * @param usdLoclXchRt USD : LCL 비율 
	 * @return
	 */
	public static  BigDecimal getLclToKrwAmt(BigDecimal lclAmt , BigDecimal utVal , BigDecimal usdKrwXchRt , BigDecimal usdLoclXchRt) {
		if (utVal == null || utVal.intValue() == 0) {
			return new BigDecimal(0);
		}
		
		if (usdKrwXchRt == null || usdKrwXchRt.floatValue() <= 0) {
			return new BigDecimal(0);
		}
		
		if (usdLoclXchRt == null || usdLoclXchRt.floatValue() <= 0) {
			return new BigDecimal(0);
		}
				
		BigDecimal krwAmt = lclAmt.multiply(utVal);
		BigDecimal krwRatio = 
			usdKrwXchRt.divide(new BigDecimal(1000)).divide(usdLoclXchRt, BigDecimal.ROUND_CEILING);
		krwAmt = krwAmt.multiply(krwRatio);		
		return krwAmt;
	}	
	
	/**
	 * 숫자 월 영문 표시
	 * @param month
	 * @return
	 */
	public static String getEngMonthName(String month) {
		int mon  = Integer.valueOf(month);	
		switch (mon) {
		case 1:
			return "JAN";
		case 2:
			return "FEB";
		case 3:
			return "MAR";
		case 4:
			return "APR";
		case 5:
			return "MAY";
		case 6:
			return "JUN";
		case 7:
			return "JUL";
		case 8:
			return "AUG";
		case 9:
			return "SEP";
		case 10:
			return "OCT";
		case 11:
			return "NOV";
		case 12:
			return "DEC";
		default:
			return "";			
		}
	
	}
	
}
