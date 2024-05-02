/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : StringToInteger.java
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
 * NIS2010-ReportDesigner String to Integer Class<br>
 * - NIS2010-ReportDesigner string 형을 int 형 으로의 변환 클래스<br>
 *
 * @author YongHoo-Kim
 * @see  ReportInsertEventResponse 참조
 * @since J2SE 6.0
 */
public class StringToInteger {
	
	/**
	 * StringToInteger class 의 Default Constructor<br>
	 */
	public StringToInteger() {
	}
	
	/**
	 * RDnumber를 카운트 위한 int 형으로의 변환 처리<br>
	 * 
	 * @param String counter - 카운트 전 RDnumber
	 * @return RDnumber
	 */
	public int stringToInteger(String counter) {
		return Integer.parseInt(counter);
	}
}
