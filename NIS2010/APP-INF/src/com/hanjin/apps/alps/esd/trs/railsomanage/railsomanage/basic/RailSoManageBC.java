/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailSoManageBC.java
*@FileTitle : USA Rail Billing S/O를 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-23
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-11-23 kim_sang_geun
* 1.0 최초 생성 
* --------------------------------------------------------
* history 
* 2012.01.16 금병주 [CHM-201215713] [TRS] S/O 다중작업에 의한 COP status 오류 방지로직 추가요청 (US rail)
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.basic; 

import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.event.EsdTrs0201Event;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.syscommon.common.table.TrsTrspRailBilOrdVO;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kim_sang_geun
 * @see EsdTrs0201EventResponse 참조
 * @since J2EE 1.4
 */
public interface RailSoManageBC  {
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP In Bound<br>
	 * @param e ESD_TRS_201Event
	 * @return List<TrsTrspRailBilOrdVO>
	 * @exception EventException
	 */
	public List<TrsTrspRailBilOrdVO> search01RailSoManageSel(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP In Bound<br>
	 * 
	 * @return
	 * @throws EventException
	 */
	public String search01RailSoManageSeq() throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP In Bound<br>
	 * 
	 * @param vo
	 * @param lSeq
	 * @param sCtrlUserId
	 * @throws EventException
	 */
	public void search01RailSoManageIns(List<TrsTrspRailBilOrdVO> vo, String lSeq, String sCtrlUserId) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP In Bound<br>
	 * 
	 * @param lSeq
	 * @throws EventException
	 */
	public void search01RailSoManageUpd(String lSeq) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP In Bound<br>
	 * 
	 * @param lSeq
	 * @return
	 * @throws EventException
	 */
	public EventResponse search01RailSoManage(String lSeq) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP In Bound<br>
	 * 
	 * @param lSeq
	 * @throws EventException
	 */
	public void search01RailSoManageDel(String lSeq) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP Out Bound<br>
	 * @param e ESD_TRS_201Event
	 * @return List<TrsTrspRailBilOrdVO>
	 * @exception EventException
	 */
	public List<TrsTrspRailBilOrdVO> search06RailSoManageSel(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP Out Bound<br>
	 * 
	 * @param vo
	 * @param lSeq
	 * @param sCtrlUserId
	 * @throws EventException
	 */
	public void search06RailSoManageIns(List<TrsTrspRailBilOrdVO> vo, String lSeq, String sCtrlUserId) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP Out Bound<br>
	 * 
	 * @param lSeq
	 * @throws EventException
	 */
	public void search06RailSoManageUpd(String lSeq) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP Out Bound<br>
	 * 
	 * @param lSeq
	 * @return
	 * @throws EventException
	 */
	public EventResponse search06RailSoManage(String lSeq) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * COP Out Bound<br>
	 * 
	 * @param lSeq
	 * @throws EventException
	 */
	public void search06RailSoManageDel(String lSeq) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * BKG,COP CNTR List search<br>
	 * COP Out Bound<br>
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailsoBybkgcntr(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * Empty Repo<br>
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search08RailSoManage(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * Empty Repo<br>
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search09RailSoManage(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * Empty Verify Checked<br>
	 * 
	 * @param soffice_cd
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search11RailSoManage(String soffice_cd, Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * IN BOUND Verify Checked<br>
	 * 
	 * @param soffice_cd
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search02RailSoManage(String soffice_cd, Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 * Correction<br>
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRailSoCorrectionTargetList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search04RailSoManage(Event e) throws EventException;


	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse searchIrgCandidate(Event e) throws EventException;

	
	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
//	public EventResponse search05RailSoManage(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * RailSoManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param soffice_cd
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search07RailSoManage(String soffice_cd, Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Request Service Provider Inquiry화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search13RailSoManage(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Request Empty Container Check화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse search14RailSoManage(Event e) throws EventException;
	
	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TRS_201 에 대한 추가 이벤트 처리<br>
	 * US Rail Billing - Correction
	 * 
	 * @param e
	 * @param row
	 * @return
	 * @throws EventException
	 */
	public EventResponse modifyRailSoManage(Event e, int row) throws EventException;

	/**
	 * 삭제 이벤트 처리<br>
	 * ESD_TRS_029 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse removeRailSoManage(Event e) throws EventException;
	
	
	/**
	 * ESD_TRS_0203: Row Delete
	 * CHM-201327803 Empty Repo & EQ On/Off Hire 개선 사항2
	 * Check된 복수개의 Row Delete
	 * 2013.11.27 by SHIN DONG IL
	 * @param e Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse removeEmptyRepoPlanForRail(Event e) throws EventException;
	
	/**
	 * 삭제 이벤트 처리<br>
	 * ESD_TRS_029 에 대한 추가 이벤트 처리<br>
	 *
	 * @param soffice_cd
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse removeRailSoManageForSpp(String soffice_cd, Event e) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_201 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e
	 * @param row
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiRailSoManage(Event e, int row) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_201 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e EsdTrs0201Event
	 * @param account SignOnUserAccount
	 * @return String
	 * @throws EventException
	 */
	public String multiRailSoCandidate(Event e, SignOnUserAccount account) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_203 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e ESD_TRS_201Event
	 * @return EventResponse ESD_TRS_201EventResponse
	 * @exception EventException
	 */
	public EventResponse multi02RailSoManage(Event e) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_203 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e
	 * @param row
	 * @return
	 * @throws EventException
	 */
	public EventResponse multi02RailSoManageForNoTranjection(Event e, int row) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_959 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param soffice_cd
	 * @param suer_ctl_id
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multi01RailSoManage(String soffice_cd, String suer_ctl_id, Event e) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_201 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param soffice_cd
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiProcRailSoManage(String soffice_cd) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_201 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param customData
	 * @param soffice_cd
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiProcRailSoManageForNoTranjection(Map<String, Object> customData, String soffice_cd) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_201 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e
	 * @param row
	 * @param customData
	 * @param soffice_cd
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiProcRailSoManageForWRS(Event e, int row, Map<String, Object> customData, String soffice_cd) throws EventException;
	
	/**
	 * S/O correction 시 S/O가 delete 됬는지 여부 체크
	 * 
	 * @param sofficeCd
	 * @param event
	 * @return String S/O no
	 * @throws EventException
	 */
	public String verifyRailSoManageDeltChk(String sofficeCd, EsdTrs0201Event event) throws EventException;

}