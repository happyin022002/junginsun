/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : EesCim0067Event.java
*@FileTitle : UC File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.04
*@LastModifier : DO-HYUN KIM
*@LastVersion : 1.0
* 2014.07.04
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * EES_CIM_0067 에 대한 RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EES_CIM_0065 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EES_CIM_0065 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author DO-HYUN KIM
 * @see EES_CIM_0067HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesCim0067Event extends EventResponseSupport {

	// Database ResultSet
	private DBRowSet   rowSet;

	// Success Flag
	private String successFlag;
	
	// fileNo, fileNoSeq 
	private String[] fileNoVal;

	/**
	 * EesCim0067Event 객체를 생성
	 */
	public EesCim0067Event() {
	}

	/**
	 * EesCim0067Event 객체를 생성
	 * @param fileNoVal 
	 */
	public EesCim0067Event(String[] fileNoVal) {
		this.fileNoVal = fileNoVal;
	}
	
	/**
	 * CIMFileUpload 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EesCim0067Event 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 */
	public EesCim0067Event(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}

	/**
	 * CIMFileUpload 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 EesCim0067Event 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 * @param successFlag 성공여부
	 */
	public EesCim0067Event(DBRowSet rowSet, String successFlag) {
		this.rowSet=rowSet;
		this.successFlag=successFlag;
	}

	/**
	 * CIMFileUpload 요청을 처리한 서버 실행 성공여부(successFlag)를 담아 EesCim0067Event 객체를 생성
	 * 
	 * @param successFlag 성공여부
	 */
	public EesCim0067Event(String successFlag) {
		this.successFlag=successFlag;
	}
	
	/**
	 * DB ResultSet 반환작업
	 * 
	 * @return DBRowSet 서버 실행 결과
	 */
	public DBRowSet getRs() {
		return this.rowSet;
	}

	/**
	 * @return SuccessFlg
	 */
	public String getSuccessFlag() {
		return this.successFlag ;
	}

	/**
	 * @return fileNoVal
	 */
	public String[] getFileNoVal() {
		String[] rtnVOs = null;
		if (this.fileNoVal != null) {
			rtnVOs = Arrays.copyOf(fileNoVal, fileNoVal.length);
		}
		return rtnVOs;
	}
	
	/**
	 * 객체 표현 문자열(EesCim0067Event)을 반환
	 * 
	 * @return String EesCim0067Event
	 */
	public String toString() {
		return "EesCim0067Event";
	}

	/**
	 * 이벤트 명(EesCim0067Event)을 반환
	 * 
	 * @return String EesCim0067Event
	 */
	public String getEventName() {
		return "EesCim0067Event";
	}

}