/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ComboxEventResponse.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-11
*@LastModifier : 김원섭
*@LastVersion : 1.0
* 2006-10-11 김원섭
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esm.spc.common.common.event;

import com.hanjin.framework.support.layer.event.EventResponseSupport;
import com.hanjin.framework.component.rowset.DBRowSet;
import java.lang.String;
import java.util.HashMap;

/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - Combox 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - Combox 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author 김원섭
 * @see CommonHTMLAction 참조
 * @since J2EE 1.4
 */

public class ComboxEventResponse extends EventResponseSupport {

	DBRowSet rowSet = null;

	DBRowSet[] rowSets = null;

	String successFlag = null;

	HashMap h = null;

	/**
	 * ComboxEventResponse 객체를 생성
	 */
	public ComboxEventResponse() {
		h = new HashMap();
	}

	/**
	 * Combox 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 ComboxEventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 */
	public ComboxEventResponse(DBRowSet rowSet) {
		this();
		this.rowSet = rowSet;
	}

	/**
	 * Combox 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를  담아 ComboxEventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 * @param successFlag 성공여부
	 */
	public ComboxEventResponse(DBRowSet rowSet, String successFlag) {
		this(rowSet);
		this.successFlag = successFlag;
	}

	/**
	 * Combox 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를  담아 ComboxEventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 * @param h 
	 * @param successFlag 성공여부
	 */
	public ComboxEventResponse(DBRowSet rowSet, HashMap h, String successFlag) {
		this(rowSet, successFlag);
		this.h = h;
	}

	/**
	 * Combox 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 ComboxEventResponse 객체를 생성
	 * 
	 * @param rowSets 서버 실행 결과
	 */
	public ComboxEventResponse(DBRowSet[] rowSets) {
		this();
		this.rowSets = rowSets;
	}

	/**
	 * Combox 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를  담아 ComboxEventResponse 객체를 생성
	 * 
	 * @param rowSets 서버 실행 결과
	 * @param successFlag 성공여부
	 */
	public ComboxEventResponse(DBRowSet[] rowSets, String successFlag) {
		this(rowSets);
		this.successFlag = successFlag;
	}

	/**
	 * Combox 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를  담아 ComboxEventResponse 객체를 생성
	 * 
	 * @param rowSets 서버 실행 결과
	 * @param h
	 * @param successFlag 성공여부
	 */
	public ComboxEventResponse(DBRowSet[] rowSets, HashMap h, String successFlag) {
		this(rowSets, successFlag);
		this.h = h;
	}

	/**
	 * Hash 값을 반환한다.
	 * 
	 * @param key  
	 * @return String key에 해당하는 Hash 값
	 */
	public String getHashData(String key) {
		String ret = (String) h.get(key);
		return ret;
	}

	/**
	 * HashMap을 반환한다.
	 * 
	 * @return HashMap HashMap
	 */
	public HashMap getHashMap() {
		return this.h;
	}

	/**
	 * 첫번째 DBRowSet을 반환한다.
	 * 
	 * @return DBRowSet DBRowSet
	 */
	public DBRowSet getRs() {
		if (rowSet != null)
			return rowSet;
		if (rowSets.length > 0)
			return rowSets[0];
		return null;
	}

	/**
	 * DBRowSet을 반환한다.
	 * 
	 * @param i  
	 * @return DBRowSet 인덱스에 해당하는 DBRowSet 값
	 */
	public DBRowSet getRs(int i) {
		if (rowSet != null && i == 0)
			return rowSet;
		if (rowSets.length > 0 && i >= 0 && i < rowSets.length)
			return rowSets[i];
		return null;
	}

	/**
	 * 전체 DBRowSet을 반환한다.
	 * 
	 * @return DBRowSet[]
	 */
	public DBRowSet[] getRowSets() {
		return rowSets;
	}

	/**
	 * 성공여부를 반환한다.
	 * 
	 * @return String 
	 */
	public String getSuccessFlag() {
		return this.successFlag;
	}

	/**
	 * event 명을 반환한다.
	 * 
	 * @return String 
	 */
	public String getEventName() {
		return "ComboxEventResponse";
	}
}