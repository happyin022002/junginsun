/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScgUtil.java
*@FileTitle : 공통유틸
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.15
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.15 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.common;

import java.sql.SQLException;

import com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.integration.SCGExternalFinderDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;

/**
 * SCG공통 자바 유틸 클래스 
 * @author cyo
 * @see SCGExternalFinderDBDAO
 * @since J2EE 1.4
 */
public class ScgUtil {
	public static final String CODE_DELIMITTER = "|##|" ;
	/**
	 * dbRowSet을 특정 컬럼의 String[] 로 변환 
	 * @param dbRowSet dbrowset
	 * @param column  디비 컬럼명 
	 * @return 특정 컬럼의 String[]
	 * @throws EventException 
	 */
	public static String[] getArrayString(DBRowSet dbRowSet , String column) throws EventException {
		
		if (dbRowSet == null) {
			return null;
		}
		
		int cnt = dbRowSet.getRowCount();
		if (cnt == 0) {
			return new String[0];
		}
		
		String[] arr = new String[cnt];
		int i = 0;
		try {
			while (dbRowSet.next()) {
				arr[i++] = dbRowSet.getString(column);
			}			
			return arr;

        } catch(SQLException se){
            throw new EventException("Code Exception : " + se.getMessage());
        } catch(Exception e){
        	throw new EventException(e.getMessage());
        }
		
	}
	
	/**
	 * dbRowSet을 특정 컬럼의 String[] 로 변환 
	 * @param dbRowSet dbrowset
	 * @param idx  컬럼 index  1부터 시작  
	 * @return 특정 컬럼의 String[]
	 * @throws EventException 
	 */
	public static String[] getArrayString(DBRowSet dbRowSet , int idx) throws EventException {
		
		if (dbRowSet == null) {
			return null;
		}
		
		int cnt = dbRowSet.getRowCount();
		if (cnt == 0) {
			return new String[0];
		}
		
		String[] arr = new String[cnt];
		int i = 0;
		try {
			while (dbRowSet.next()) {
				arr[i++] = dbRowSet.getString(idx);
			}
			
			return arr;
			
        } catch(SQLException se){
            throw new EventException("Code Exception : " + se.getMessage());
        } catch(Exception e){
        	throw new EventException(e.getMessage());
        }
		
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
	 * 배열을 특정문자를 추가하여 하나의 문자열로 반환 
	 * @param arr 입력 문자배열 기본값 "|" 
	 * @param sDelimeter
	 * @return
	 */
	public static String addUserSpChar(String[] arr, String sDelimeter) {		
		return addSpChar(arr, sDelimeter);
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
		
		if ( str == null ) {
			return null;
		}
		
		sb.append("'");
		
        for (int i = 0; i < str.length; i++) {
        	String in = str[i];       	
        	//문자  
        	sb.append(in.trim()).append("','");		
		}
        
        return sb.substring(0,sb.lastIndexOf(","));

	}		
 
}


