/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GetCounter.java
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
 * NIS2010-ReportDesigner get rdAppCd number part<br>
 * - NIS2010-ReportDesigner 의 rdAppCd number 부분을 얻는 클래스<br>
 *
 * @author YongHoo-Kim
 * @see  ReportInsertEventResponse 참조
 * @since J2SE 6.0
 */
public class GetCounter {
	/**
	 * GetCounter class 의 Default Constructor<br>
	 */
	public GetCounter() {
	}
	/**
	 * RDnumber를 숫자부분 분리를 위한 처리<br>
	 * 
	 * @param rdAppCd
	 * @return rdAppCd의 숫자부분
	 */
	public String getCounter(String rdAppCd) {
		return rdAppCd.substring(3);
	}
}
