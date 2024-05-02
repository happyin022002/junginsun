/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBFileUploadEventResponse.java
*@FileTitle : 3자구상 파일업로드 공통팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-02
*@LastModifier : Sun, CHOI
*@LastVersion : 1.1
* 2009-08-20 O Wan-Ki  1.0 최초생성
* 2009-12-02 Sun, CHOI 1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.fileupload.event;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.event.EventResponseSupport;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - TPBFileUpload 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - TPBFileUpload 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author Sun, CHOI
 * @see TPBFileUploadSC 참조
 * @since J2EE 1.4
 */
public class TPBFileUploadEventResponse extends EventResponseSupport {

	// Database ResultSet
	private DBRowSet   rowSet;

	// Success Flag
	private String successFlag;
	
	// fileNo, fileNoSeq 
	private String[] fileNoVal;

	/**
	 * TPBFileUploadEventResponse 객체를 생성
	 */
	public TPBFileUploadEventResponse() {
	}

	/**
	 * TPBFileUploadEventResponse 객체를 생성
	 * @param fileNoVal 
	 */
	public TPBFileUploadEventResponse(String[] fileNoVal) {
		this.fileNoVal = fileNoVal;
	}
	
	/**
	 * TPBFileUpload 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 TPBFileUploadEventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 */
	public TPBFileUploadEventResponse(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}

	/**
	 * TPBFileUpload 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 TPBFileUploadEventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 * @param successFlag 성공여부
	 */
	public TPBFileUploadEventResponse(DBRowSet rowSet, String successFlag) {
		this.rowSet=rowSet;
		this.successFlag=successFlag;
	}

	/**
	 * TPBFileUpload 요청을 처리한 서버 실행 성공여부(successFlag)를 담아 TPBFileUploadEventResponse 객체를 생성
	 * 
	 * @param successFlag 성공여부
	 */
	public TPBFileUploadEventResponse(String successFlag) {
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
		return this.fileNoVal;
	}
	
	/**
	 * 객체 표현 문자열(TPBFileUploadEventResponse)을 반환
	 * 
	 * @return String TPBFileUploadEventResponse
	 */
	public String toString() {
		return "TPBFileUploadEventResponse";
	}

	/**
	 * 이벤트 명(TPBFileUploadEventResponse)을 반환
	 * 
	 * @return String TPBFileUploadEventResponse
	 */
	public String getEventName() {
		return "TPBFileUploadEventResponse";
	}

}