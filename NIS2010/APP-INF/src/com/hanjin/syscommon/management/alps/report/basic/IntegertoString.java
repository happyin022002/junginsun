/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IntegertoString.java
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
 * NIS2010-ReportDesigner Integer to String Class<br>
 * - NIS2010-ReportDesigner int 형을 string 형 으로의 변환 클래스<br>
 *
 * @author YongHoo-Kim
 * @see  ReportInsertEventResponse 참조
 * @since J2SE 6.0
 */
public class IntegertoString {
	/**
	 * IntegertoString class 의 Default Constructor<br>
	 */
	public IntegertoString() {
	}
	/**
	 * RDnumber의 DB Insert 를 위한 String 형으로의 변환 처리<br>
	 * 
	 * @param int counter - 카운트 된 RDnumber
	 * @return RDnumber
	 */
	public String integerToString(int counter){
		return Integer.toString(counter);	
	}
}
