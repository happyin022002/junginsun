/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SingleTransportationSOManageBC.java
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-10-30 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.basic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kim_sang_geun
 * @see EsdTrs0012EventResponse 참조
 * @since J2EE 1.4
 */
public interface SingleTransportationSOManageBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_012Event
	 * @return EventResponse ESD_TRS_012EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSingleTransportationSOManage(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_012Event
	 * @return EventResponse ESD_TRS_012EventResponse
	 * @exception EventException
	 */
	public EventResponse search01SingleTransportationSOManage(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_012Event
	 * @return EventResponse ESD_TRS_012EventResponse
	 * @exception EventException
	 */
	public EventResponse search02SingleTransportationSOManage(Event e) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_012 에 대한 추가 이벤트 처리<br>
	 * @param soffice_cd
	 * @param e EsdTrs0012Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse modifySingleTransportationSOManage(String soffice_cd, Event e) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_012 에 대한 추가 이벤트 처리<br>
	 * @param soffice_cd
	 * @param e EsdTrs0012Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse modify01SingleTransportationSOManage(String soffice_cd, Event e) throws EventException;
	
	/**
	 * ESD_TRS_0012: Row Delete
	 * CHM-201327803 Empty Repo & EQ On/Off Hire 개선 사항2
	 * Check된 복수개의 Row Delete
	 * 2013.11.27 by SHIN DONG IL
	 * @param e Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse removeEmptyRepoPlan(Event e) throws EventException;
	
	/**
	 * 삭제 이벤트 처리<br>
	 * ESD_TRS_012 에 대한 추가 이벤트 처리<br>
	 * @param soffice_cd
	 * @param e EsdTrs0012Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse removeSingleTransportationSOManage(String soffice_cd, Event e) throws EventException;


	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * @param e EsdTrs0012Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search03SingleTransportationSOManage(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * @param e EsdTrs0012Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search04SingleTransportationSOManage(Event e) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * @param soffice_cd
	 * @param e EsdTrs0012Event
	 * @return response GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse search05SingleTransportationSOManage(String soffice_cd,Event e) throws EventException;
	
	/**
	 * CHM-201327722 MT repo & EQ on/off-hire 메뉴 개선사항1
	 * 2013.11.21 by SHIN DONG IL
	 * Off Hire일 경우 Node Combo정보를 MDM YARD와 LSE YARD정보를 모두 가져온다.
	 * ESD_TRS_0012
	 * @param e Event
	 * @return String
	 * @throws EventException
	 */
	public String searchNodCdForOffHire(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * @param e EsdTrs0012Event
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchMultiSingleTransportationSo(Event e) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * @param e EsdTrs0012Event
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap searchEmptyRepoCombineSeq(Event e) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * @param chk_param
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchVerifyECC(Map<String, Object> chk_param) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * SingleTransportationSOManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchEmptyRepoSeq() throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_012 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param insModels Collection<SingleTransportationVO> 
	 * @param param Map<String, Object>
	 * @return EventResponse ESD_TRS_012EventResponse
	 * @exception EventException
	 */
	public EventResponse multiSingleTransportationSOManage5(Collection<SingleTransportationVO> insModels, Map<String, Object> param) throws EventException;
	
	
	/**
	 * Save 이벤트 처리<br>
	 * ESD_TRS_012 에 대한 추가 이벤트 처리<br>
	 * @param e EsdTrs0012Event
	 * @param account SignOnUserAccount 
	 * @return String
	 * @exception EventException
	 */
	public String multi01SingleTransportationSOManage( Event e,SignOnUserAccount account) throws EventException;

	
}