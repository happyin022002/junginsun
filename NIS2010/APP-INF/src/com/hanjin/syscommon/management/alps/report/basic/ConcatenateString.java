/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ConcatenateString.java
*@FileTitle : Report Designer Insert
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-03
*@LastModifier : YongHoo-Kim
*@LastVersion : 1.0
* 2013-05-03 YongHoo-Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps.report.basic;

/**
 * NIS2010-ReportDesigner RD number String Concatenate Class<br>
 * - NIS2010-ReportDesigner RD번호를 부여하기 위한 String Concatenate 클래스<br>
 *
 * @author YongHoo-Kim
 * @see  ReportInsertEventResponse 참조
 * @since J2SE 6.0
 */
public class ConcatenateString {
	/**
	 * ConcatenateString class 의 Default Constructor<br>
	 */
	public ConcatenateString() {

	}
	
	/**
	 * RDnumber의 포멧을 정해주기 위한 String Concatenation 처리<br>
	 * 
	 * @param counter - 카운트 된 RDnumber
	 * @return RDnumber
	 */
	public String concatWithZero(String counter) {
		if (counter.length() == 3) {
			return counter;
		} else if (counter.length() == 2) {
			return "0" + counter;
		} else {
			return "00" + counter;
		}
	}
	
	/**
	 * RDnumber와 모듈명에 대한 String Concatenation 처리<br>
	 * 
	 * @param module -모듈명
	 * @param counter - 카운트 된 RDnumber
	 * @return 실제로 Insert 할 RD_APPL_CD 값
	 */
	public String concatWithModuleName(String module, String counter) {
		return module + counter;
	}
}
