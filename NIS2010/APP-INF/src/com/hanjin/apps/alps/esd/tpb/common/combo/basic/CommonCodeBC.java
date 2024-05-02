/*=========================================================
*Copyright(c) 2006~2010 CyberLogitec
*@FileName : CommonCodeBC.java
*@FileTitle : 3자구상 유형등록
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-19
*@LastModifier : Sun, CHOI
*@LastVersion : 1.1
* 2006-10-09 Youngchang_Kim 1.0 최초 생성
* 2008-09-10 O Wan-Ki  		1.1  수정 : searchOfficeTopLevel method 추가
* 2009-11-19 Sun, CHOI      1.2 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.basic;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * alps-ESD Business Logic Command Interface<br>
 * - alps-ESD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Sun, CHOI
 * @see EsdTpb001EventResponse 참조
 * @since J2EE 1.4
 */
public interface CommonCodeBC  {

	/**
	 * Office change기능 추가로 인해 session의 ofc_cd를 기준으로 (session이 아닌) MDM의 cnt_cd를 조회 
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String getMDMCntCd(String ofc_cd) throws EventException;	
	/**
	 * 조회 이벤트 처리<br>
	 * CodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTpb001Event
	 * @return EventResponse EsdTpb001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCommonCode(Event e) throws EventException;

	/**
	 * Office Code를 기초로 Office Level조회 처리<br>
	 * @param officeCode - Office Code 
	 * @return String[] - Office Level / Office Code / RHQ Code / Head Office Code
	 * @exception EventException
	 */
	public String[] searchOfficeLevel(String officeCode) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param String mainCode
	 * @param String sDefaultSelectCode
	 * @param String[][] addOptionInfo
	 * @param String[] codeConditionPositiveArr
	 * @param String[] codeConditionNegativeArr
	 * @param int sortKey
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchCodeComboData(
			String mainCode, 
			String sDefaultSelectCode, 
			String[][] addOptionInfo, 
			String[] codeConditionPositiveArr, 
			String[] codeConditionNegativeArr, 
			int sortKey
			) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param String officeCode
	 * @param boolean isIncludeControlOffice
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchHandleOfficeLevel(String officeCode, boolean isIncludeControlOffice) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param String officeCode
	 * @return String searchOfficeTopLevel
	 * @exception EventException
	 */
	public String searchOfficeTopLevel(String officeCode) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * @return String
	 * @exception EventException
	 */
	public String searchTPBSeq() throws EventException;
	/**
	 * Office가 TPB Office인지 여부 Y/N 조회 <br>
	 * @param officeCode - Office Code 
	 * @return String - Y/N
	 * @exception EventException
	 */
	public String searchIsTPBOffice(String officeCode) throws EventException;
	/**
	 * CodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchBillingCaseCodeByTES() throws EventException;
	
	/** 
	 * ROC Office Code 조회.
	 * 
	 * @param String n3ptyCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckTPBROCOffice(String n3ptyCd) throws EventException;

}