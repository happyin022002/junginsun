/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeManageBC.java
*@FileTitle : Cost Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-07
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-07 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.codemanage.codemanage.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ENIS-ESD Business Logic Command Interface<br>
 * - ENIS-ESD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author jongbaemoon
 * @see ESD_TES_027EventResponse 참조
 * @see ESD_TES_028EventResponse 참조 
 * @since J2EE 1.4
 */
public interface CodeManageBC  {

	/**
	 * 리스트조회 이벤트 처리<br>
	 * CodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_028Event
	 * @return EventResponse ESD_TES_028EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCostCode(Event e) throws EventException;
	
	/**
	 * 리스트조회 이벤트 처리<br>
	 * CodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_0028Event
	 * @return EventResponse ESD_TES_028EventResponse
	 * @exception EventException
	 */
	public EventResponse createCostCode(Event e) throws EventException;
	
	/**
	 * 리스트조회 이벤트 처리<br>
	 * CodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_0028Event
	 * @return EventResponse ESD_TES_028EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyCostCode(Event e) throws EventException;
	
	/**
	 * 리스트조회 이벤트 처리<br>
	 * CodeManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_028Event
	 * @return EventResponse ESD_TES_028EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyCostCodeDelete(Event e) throws EventException;	

	/**
	 * 정보조회 이벤트 처리<br>
	 * ESD_TES_027 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_027Event
	 * @return EventResponse ESD_TES_027EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCostCodeInfo(Event e) throws EventException;
	
	/**
	 * 유저정보조회 이벤트 처리<br>
	 * ESD_TES_027 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_027Event
	 * @return EventResponse ESD_TES_027EventResponse
	 * @exception EventException
	 */
	public EventResponse checkMandatory(Event e) throws EventException;	
	
	/**
	 * 유저정보조회 이벤트 처리<br>
	 * ESD_TES_027 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_027Event
	 * @return EventResponse ESD_TES_027EventResponse
	 * @exception EventException
	 */
	public EventResponse checkAgreementPassWord(Event e) throws EventException;		
		
	/**
	 * 추가 수정 삭제 이벤트 처리<br>
	 * ESD_TES_028 에 대한 추가 수정 삭제 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_028Event
	 * @return EventResponse ESD_TES_028EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchCostcdOption(Event e) throws EventException;

	/**
	 * 추가 수정 삭제 이벤트 처리<br>
	 * ESD_TES_028 에 대한 추가 수정 삭제 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_028Event
	 * @return EventResponse ESD_TES_028EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchCostcdDetail(Event e) throws EventException;
	
	/**
	 * Acct Code 조회 이벤트 처리<br>
	 * ESD_TES_0027Event 에 대한 조회 이벤트 처리<br>
	 * 
	 * @return EventResponse 
	 * @exception EventException
	 */	
	public EventResponse searchAcctCodeList() throws EventException;	
	
	/**
	 * Carrier Code 조회 이벤트 처리<br>
	 * ESD_TES_031 에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_0031Event
	 * @return EventResponse 
	 * @exception EventException
	 */	
    public EventResponse searchCarrierCode(Event e) throws EventException;
    
//	/**
//	 * 추가 수정 삭제 이벤트 처리<br>
//	 * ESD_TES_031 에 대한 추가 수정 삭제 이벤트 처리<br>
//	 * 
//	 * @param e ESD_TES_031Event
//	 * @return EventResponse ESD_TES_031EventResponse
//	 * @exception EventException
//	 */
//    public EventResponse multiCarrierCode(Event e) throws EventException;	
}
