/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GetNextRdAppCdFacade.java
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
 * NIS2010-ReportDesigner Get Next RDnumber Facade Class<br>
 * - NIS2010-ReportDesigner 의 다음 RDnumber를 계산하기 위한 Facade 클래스<br>
 *
 * @author YongHoo-Kim
 * @see  ReportInsertEventResponse 참조
 * @since J2SE 6.0
 */
public class GetNextRdAppCdFacade {
	
	/**
	 * GetNextRdAppCdFacade class 의 Default Constructor<br>
	 */
	private GetNextRdAppCdFacade() {}
	
	/**
	 * RDnumber를 카운트 위한 int 형으로의 변환 처리<br>
	 * 
	 * @param String module - module명
	 * @param String rdSubSysCd
	 * @return DB insert 할 RdAppCd
	 */
	public static String nextRdAppCd(String module, String rdSubSysCd){
		String stringBeforeCounter;
		String stringAfterCounter;
		String resultString;
		int intBeforeCounter;
		int intAfterCounter;
		
		GetCounter getCounter = new GetCounter();
		StringToInteger stringToInteger = new StringToInteger();
		CountUp countUp = new CountUp();
		IntegertoString integertoString = new IntegertoString();
		ConcatenateString concat = new ConcatenateString();
		stringBeforeCounter = getCounter.getCounter(rdSubSysCd);
		intBeforeCounter = stringToInteger.stringToInteger(stringBeforeCounter);
		intAfterCounter = countUp.countUp(intBeforeCounter);
		stringAfterCounter = integertoString.integerToString(intAfterCounter);
		stringAfterCounter = concat.concatWithZero(stringAfterCounter);
		resultString = concat.concatWithModuleName(module, stringAfterCounter);
		
		return resultString;
	}
}
