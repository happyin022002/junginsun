/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CountUp.java
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
 * NIS2010-ReportDesigner rdAppCd number count up class<br>
 * - NIS2010-ReportDesigner 의 rdAppCd number 증가시키는 클래스<br>
 *
 * @author YongHoo-Kim
 * @see  ReportInsertEventResponse 참조
 * @since J2SE 6.0
 */
public class CountUp {	
	/**
	 * CountUp class 의 Default Constructor<br>
	 */
	public CountUp() {
	}
	/**
	 * RDnumber count up 처리<br>
	 * 
	 * @param counter - rdAppCd의 숫자부분
	 * @return rdAppCd의 count 된 값
	 */
	public int countUp(int counter) {
		return ++counter;
	}

}
