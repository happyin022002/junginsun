/*=========================================================
*Copyright(c) 20006 CyberLogitec
*@FileName : EsdSce0010EventResponse.java
*@FileTitle : COP EST DATE/TIME 일괄 업데이트
*Open Issues :
*Change history :
*@LastModifyDate : 20006-10-02
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 20006-10-02 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copupdate.event;

import java.util.ArrayList;

import com.clt.apps.opus.esd.sce.common.util.basic.RequestDataSetBC;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.support.layer.event.EventResponseSupport;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EsdSce0010 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EsdSce0010 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author Seong-mun Kang
 * @see CopManageSC 참조
 * @since J2EE 1.4
 */
@SuppressWarnings({"deprecation", "rawtypes"})
public class EsdSce0010EventResponse extends EventResponseSupport {
	private static final long serialVersionUID = 1L;

	// Database ResultSet
	private DBRowSet   rowSet;
	
	// DataSet
	private RequestDataSetBC dataSet ;

	// Success Flag
	private String successFlag;
	
	private ArrayList dRsArray = new ArrayList();

	/**
	 * EsdSce0010EventResponse 객체를 생성
	 */
	public EsdSce0010EventResponse() {
	}

	/**
	 * EsdSce0010 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce0010EventResponse 객체를 생성
	 * 
	 * @param DBRowSet rowSet
	 */
	public EsdSce0010EventResponse(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}
	
	/**
	 * EsdSce0010 결과를 담아 EsdSce0010EventResponse 객체를 생성
	 * 
	 * @param String successFlag
	 */
	public EsdSce0010EventResponse(String successFlag) {
		this.successFlag = successFlag;
	}
	
	/**
	 * 처리 결과를 DataSet에 담아 객체 생성
	 * 
	 * @param RequestDataSetBC dataSet
	 */
	public EsdSce0010EventResponse(RequestDataSetBC dataSet) {
		this.dataSet = dataSet;
		
	}
	
	/**
	 * 처리 결과를 DataSet에 담아 객체 생성
	 * 
	 * @param RequestDataSetBC dataSet
	 * @param ArrayList dRsArray
	 */
	public EsdSce0010EventResponse(RequestDataSetBC dataSet, ArrayList dRsArray) {
		this.dataSet = dataSet;
		this.dRsArray = dRsArray;
	}

	/**
	 * EsdSce0010 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 EsdSce0010EventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 * @param successFlag 성공여부
	 */
	public EsdSce0010EventResponse(DBRowSet rowSet, String successFlag) {
		this.rowSet=rowSet;
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
	 * DataSet 반환작업
	 * 
	 * @return dataSet
	 */
	public RequestDataSetBC getDataSet() {
		return this.dataSet;
	}

	/**
	 * return SuccessFlg
	 */
	public String getSuccessFlag() {
		return this.successFlag ;
	}

	/**
	 * 객체 표현 문자열(EsdSce0010EventResponse)을 반환
	 * 
	 * @return String EsdSce0010EventResponse
	 */
	public String toString() {
		return "EsdSce0010EventResponse";
	}

	/**
	 * 이벤트 명(EsdSce0010EventResponse)을 반환
	 * 
	 * @return String EsdSce0010EventResponse
	 */
	public String getEventName() {
		return "EsdSce0010EventResponse";
	}

	public ArrayList getDRsArray() {
		return dRsArray;
	}

}