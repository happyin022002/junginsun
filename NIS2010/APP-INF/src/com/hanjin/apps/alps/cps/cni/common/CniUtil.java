/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CniUtil.java
 *@FileTitle : Cni공통 함수 유틸 클래스
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.17
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.17 최정미 , 진윤오
 * 2010.06.28 정윤태
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.common;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;


/**
 * Cni공통 자바 유틸 클래스 
 * @author cyo
 * @see
 * @since
 */
public class CniUtil {
	private static transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(CniUtil.class);
	
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
	 * @return 배열에 +"|" 문자
	 */
	public static String addSpChar(String[] arr) {		
		return addSpChar(arr, "|");
	}
	
	
	/**
	 *  인수가 넘버타입의 조건절인경우의 SQL의 IN절 문자 생성
	 *  [100,200,300] ==> "100,200,300"
	 * @author 진윤오
	 * @param 숫자 객체 배열
	 * @return sql 숫자 IN절
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
	 * @param 문자 객체 배열
	 * @return sql 숫자 IN절
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
	 * 로컬을 USD금액으로 환산
	 * 
	 * @author cyo
	 * @param lclAmt 로컬금액 
	 * @param utVal 로컬금액입력단위
	 * @param usdLoclXchRt   usd : LCL 비율
	 * @return USD금액
	 */
	public static BigDecimal getLclToUsdAmt(BigDecimal lclAmt , BigDecimal utVal , BigDecimal usdLoclXchRt) {
		
		if (utVal == null || utVal.intValue() == 0) {
			return new BigDecimal(0);
		}
		
		if (usdLoclXchRt == null || usdLoclXchRt.floatValue() <= 0) {
			return new BigDecimal(0);
		}


		
		BigDecimal usdAmt = lclAmt.multiply(utVal);		
		// 금액이 마이너스인경우 절삭 그외인경우 절상
		if (lclAmt.intValue() < 0) {
			usdAmt = usdAmt.divide(usdLoclXchRt, BigDecimal.ROUND_FLOOR);
		} else {
			usdAmt = usdAmt.divide(usdLoclXchRt, BigDecimal.ROUND_CEILING);	
		}
		
		return usdAmt;
	}	
	
	/**
	 * 로컬을 USD금액으로 환산
	 * 
	 * @author cyo
	 * @param lclAmt 로컬금액 
	 * @param utVal 로컬금액입력단위
	 * @param usdXchRt   usd : LCL 비율
	 * @return USD금액
	 */
	public static BigDecimal getUsdToLclAmt(BigDecimal usdAmt , BigDecimal usdXchRt) {
		
		if (usdAmt == null || usdAmt.intValue() == 0) {
			return new BigDecimal(0);
		}
		
		if (usdXchRt == null || usdXchRt.floatValue() <= 0) {
			return new BigDecimal(0);
		}

		BigDecimal lclAmt = usdAmt.multiply(usdXchRt);
		lclAmt = lclAmt.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		return lclAmt;
	}		
	
	/**
	 * 로컬을 KRW금액으로 환산
	 * 
	 * @author cyo	 
	 * @param lclAmt 로컬금액 
	 * @param utVal 로컬금액입력단위
	 * @param usdKrwXchRt usd : KRW 비율
	 * @param usdLoclXchRt USD : LCL 비율 
	 * @return KRW금액
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
	 * @param month 숫자
	 * @return 영문 월
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
	
    /**
     * 년도 반환
     * @return 현재 년도
    */
    public String getCurrYear(){
        GregorianCalendar cal = new GregorianCalendar();
        String year = String.valueOf(cal.get(Calendar.YEAR));
        return year;
    }	
	
    
	/**
	 * Cargo claim NO 정보 취득
	 * 500Byte char 0~20 Index
	 * @param account정보
	 * @return cargo claim no
	 */
	public static String getCargoClaimNo(SignOnUserAccount account) {
		
		String extData = account.getExtdata();
		
		if (StringUtils.isEmpty(extData)) {
			return extData;
		}	
		
		extData = extData.substring(0,20);
		
		return extData.trim();
	}    
	
	/**
	 * Cargo claim NO 정보 설정
	 * 500Byte char 0~20 Index
	 * @param account정보
	 * @param cargo claim no 
	 */
	public static void setCargoClaimNo(SignOnUserAccount account,String cgoClmNo) {
		String extData = account.getExtdata();
		
		if (cgoClmNo == null) {
			cgoClmNo = "";
		}
		
		String rightData = extData.substring(20);		
		//공백설정
		while (cgoClmNo.length() < 20) {
			cgoClmNo = cgoClmNo + " ";
		}
		
		account.setExtdata(cgoClmNo + rightData);
		
	}    	
	
	/**
	 * Dw claim NO 정보 취득
	 * 500Byte char 20~40 Index
	 * @param account의 etcData정보
	 * @return cargo claim no
	 */
	public static String getDwClaimNo(SignOnUserAccount account) {
		String extData = account.getExtdata();
		if (StringUtils.isEmpty(extData)) {
			return extData;
		}		
		
		extData = extData.substring(20,40);
		
		return extData.trim();
		
	}   	
	
	/**
	 * Dw claim NO 정보 설정
	 * 500Byte char 20~40 Index
	 * @param account의 etcData정보
	 * @return cargo claim no
	 */
	public static void setDwClaimNo(SignOnUserAccount account,String dwClmNo) {
		String extData = account.getExtdata();
		
		if (dwClmNo == null) {
			dwClmNo = "";
		}
		
		String rightData = extData.substring(40);
		String leftData = extData.substring(0,20);
		while (dwClmNo.length() < 20) {
			dwClmNo = dwClmNo + " ";
		}
		
		account.setExtdata(leftData + dwClmNo + rightData);
		
	}  	
	
	
	/**
	 * Area 정보 취득
	 * 500Byte char 40~60 Index
	 * @param account의 etcData정보
	 * @return cargo claim no
	 */
	public static String getAreaInfo(SignOnUserAccount account) {
		String extData = account.getExtdata();
		if (StringUtils.isEmpty(extData)) {
			return extData;
		}		
		
		extData = extData.substring(40,60);
		
		return extData.trim();
		
	}   	
	
	/**
	 * Area 정보 설정
	 * 500Byte char 40~60 Index
	 * @param account의 etcData정보
	 * @param String area
	 */
	public static void setAreaInfo(SignOnUserAccount account,String area) {
		String extData = account.getExtdata();
		
		if (area == null) {
			area = "";
		}
		
		String rightData = extData.substring(60);
		String leftData = extData.substring(0,40);
		while (area.length() < 20) {
			area = area + " ";
		}
		
		account.setExtdata(leftData + area + rightData);
		
	}  		
    
	
	/**
	 * vvd 정보 취득
	 * 500Byte char 60~80 Index
	 * @param account의 etcData정보
	 * @return vvd
	 */
	public static String getVvd(SignOnUserAccount account) {
		String extData = account.getExtdata();
		if (StringUtils.isEmpty(extData)) {
			return extData;
		}		
		
		extData = extData.substring(60,80);
		
		return extData.trim();
		
	}   	
	
	/**
	 * vvd 정보 설정
	 * 500Byte char 60~80 Index
	 * @param account의 etcData정보
	 * @param String vvd
	 */
	public static void setVvd(SignOnUserAccount account,String vvd) {
		String extData = account.getExtdata();
		
		if (vvd == null) {
			vvd = "";
		}
		
		
		
		String rightData = extData.substring(80);
		
		
		String leftData = extData.substring(0,60);
		while (vvd.length() < 20) {
			vvd = vvd + " ";
		}
		
		account.setExtdata(leftData + vvd + rightData);
		
	}  			
	
	
	
	
	/**
	 * role 정보 취득
	 * 500Byte char 80~300 Index
	 * @param account의 etcData정보
	 * @return String roles
	 */
	public static String getRoles(SignOnUserAccount account) {
		String extData = account.getExtdata();
		if (StringUtils.isEmpty(extData)) {
			return "";
		}		
		
		
		
		extData = extData.substring(80,300);
		
		return extData.trim();
				
		
	}   	
	
	/**
	 * role 정보 설정
	 * 500Byte char 80~300 Index
	 * @param account의 etcData정보
	 * @param String roles
	 */
	public static void setRoles(SignOnUserAccount account,String roles) {
		String extData = account.getExtdata();
		
		if (roles == null) {
			roles = "";
		}
		
		String rightData = extData.substring(300);
		String leftData = extData.substring(0,80);
		while (roles.length() < 220) {
			roles = roles + " ";
		}
		
		account.setExtdata(leftData + roles + rightData);
		
	}  		
	
	/**
	 * role 정보 비교
	 * @param SignOnUserAccount account 의 etcData정보
	 * @param String role
	 * @return true 롤과 일치하는경우
	 */
	public static boolean equalsRole(SignOnUserAccount account,String role) {
				
		String roles = getRoles(account);
		
		if (roles == null || role.length() == 0 || role == null) {
			return false;
		}
		
		if (roles.indexOf(role) == -1) {		
			return false;
		} else {
			return true;
		}
		
	}
	
	/**
	 * Area 정보 비교
	 * @param SignOnUserAccount account account의 etcData정보
	 * @param String area
	 * @return true 롤과 일치하는경우
	 */
	public static boolean equalsArea(SignOnUserAccount account,String area) {
				
		String usrArea = getAreaInfo(account);
		
		if (area == null || area.length() == 0 || area == null) {
			return false;
		}
		
		if (usrArea.indexOf(area) == -1) {		
			return false;
		} else {
			return true;
		}
		
	} 
	
	
	/**
	 * yyyy-mm-dd 데이타 yyyymmdd로 변경
	 * @param String yyyymmdd
	 * @return String
	 */
	public static String getFmtDt(String yyyymmdd) {		
		
		if (yyyymmdd != null && yyyymmdd.indexOf("-") != -1) {
			return yyyymmdd.replaceAll("\\-", "");			
		} 
		
		return yyyymmdd;
		
	}	
	
	
	/**
	 * yyyymmdd로 yyyy-mm-dd 변경
	 * @param String yyyymmdd
	 * @return String
	 */
	public static String getDtFmt(String yyyymmdd) {		
		
		if (StringUtils.isEmpty(yyyymmdd)) {
			return "";
		}
		
		if (yyyymmdd.length() == 8) {
			return yyyymmdd.substring(0,4) + "-" +
			yyyymmdd.substring(4,6) + "-" +
			yyyymmdd.substring(6,8);
		} else {
			return yyyymmdd;
		}

	}	
	
	/**
	 * 1000.00 --> 1,000.00 변경
	 * @param String num
	 * @return String
	 */
	public static String getNumberFmt(String num) {		
		
		if (StringUtils.isEmpty(num)) {
			return "";
		}
		
		if (StringUtils.isNumeric(num)) {
			DecimalFormat df = new DecimalFormat("###,###.##");
			return df.format(new BigDecimal(num));
		} else {
			return num;
		}

	}	
	
	/**
	 * 숫자열을 정의된 pattern 대로 변환하여 return.(1000.00 --> 1,000.00 변경)
	 * @param String amount
	 * @param String pattern
	 * @return String
	 */
	public static String toDecimalFormat(String amount, String pattern) {
		
		if (StringUtils.isEmpty(amount)) {
			return "";
		}
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		DecimalFormat df = (DecimalFormat) nf;
		String retr = "";

		df.setMinimumFractionDigits(2);
		df.setMaximumFractionDigits(2);
		df.setDecimalSeparatorAlwaysShown(true);
		// String pattern = "###,###.00";
		df.applyPattern(pattern);

		try {
			retr = df.format(Double.parseDouble(amount));
		} catch (IllegalArgumentException e) {
			log.error(e.getMessage(),e);	
			return "";
		}

		return retr;
	}
	
	/**
	 * 금액
	 * 1,000.00 --> 1000.00
	 * @param String amt
	 * @return String
	 */
	public static String removeCommaAmt(String amt) {		
		
		if (StringUtils.isEmpty(amt)) {
			return "0";
		}
		
		return amt.replaceAll("\\,", "");

	}		
}
