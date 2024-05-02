/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : LaneServiceBC.java
 *@FileTitle : LaneServiceBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.07.15
 *@LastModifier : 함대성
 *@LastVersion : 1.0
 * 2010.07.15 함대성
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0140Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DewllNotifiySetupExpContainerVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwellNofifySendStsVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwellNotifyLMTDateVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwellRnsVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwllNtfcSrchVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchOneTimeSndHistVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * NIS2010-CustomerScheduleEdi Business Logic Command Interface<br>
 * - NIS2010-CustomerScheduleEdi에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author HAM DAE SUNG
 * @see
 * @since J2EE 1.4
 */
public interface DwellNotificationBC { 
	
	/**
	 * Dwell Type별 목록 <br>
	 * Dwell Type별 목록 조회 이벤트 처리<br>
	 * 
	 * @param e EsdSce0140Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDwellList(Event e) throws EventException;

	/**
	 * DWELL REASON 의 입력 내역 <br>
	 * DWELL REASON 의 입력 내역을 조회 이벤트 처리<br>
	 * 
	 * @param e EsdSce0140Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDwellResonByVVD(Event e) throws EventException;
	
	/**
	 * DWELL Emailing list를 조회 이벤트 처리<br>
	 * 
	 * @param e EsdSce0140Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDwellEmailList(Event e) throws EventException;
	
	/**
	 * DWELL REASON 의 입력 내역 <br>
	 * DWELL REASON 의 입력 내역을 수정 이벤트 처리<br>
	 * 
	 * @param e EsdSce0140Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse updateDwellResonByVVD(EsdSce0140Event e) throws EventException;

	/**
	 * Dwell Type별 Total Count 값 조회<br>
	 * Dwell Type별 Total Count 값 조회 이벤트 처리<br>
	 * 
	 * @param e EsdSce0140Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDwellTotalCnt(Event e) throws EventException;

	/**
	 * Microsoft Exception List 값 조회<br>
	 * Microsoft Exception List 값 조회 이벤트 처리<br>
	 * 
	 * @param e EsdSce0146Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMSExptList(Event e) throws EventException;
	
	/**
	 * Microsoft Exception List 값 저장<br>
	 * Microsoft Exception List 값 저장 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @param String usr_id
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyMSExptList(Event e, String usr_id) throws EventException;
	
	/** 
	 * Email List 조회
	 * 
	 * @param Event e
	 * @return List<DwllNtfcSrchVO>
	 * @exception EventException
	 */
	public List<DwllNtfcSrchVO> searchDwllNtfcSvcList(Event e) throws EventException;
		
	/** 
	 * Email List 조회(단건, Row Add일 경우)
	 * 
	 * @param DwllNtfcSrchVO dwllntfcsrchvo
	 * @return DwllNtfcSrchVO
	 * @exception EventException
	 */
	public DwllNtfcSrchVO searchDwllNtfcSvcItem(DwllNtfcSrchVO dwllntfcsrchvo) throws EventException;
	
	/**
	 * Dwell Notification Exception List 저장.<br>
	 * 
	 * @param Event e
	 * @param String usr_id
	 * @param String ofc_cd
	 * @return EventResponse
	 * @exception EventException
	 */
	 public EventResponse addDwllNtfcExptForSvc(Event e ,String usr_id, String ofc_cd ) throws EventException;
	 
	 /** 
		 * POPUP Email List 조회를 한다.
		 * 
		 * @param DwllNtfcSrchVO dwllntfcsrchvo
		 * @return List<DwllNtfcSrchVO>
		 * @exception EventException
		 */
	public List<DwllNtfcSrchVO> searchDwllNtfcSvcPopUpList(DwllNtfcSrchVO dwllntfcsrchvo) throws EventException;
	
	/**
	 * EMAIL 정보를 저장.<br>
	 * 
	 * @param Event e
	 * @param String account
	 * @param String ofcCd
	 * @return EventResponse
	 * @exception EventException
	 */
	 public EventResponse manageDwllNtfcSvcList(Event e ,String account, String ofcCd ) throws EventException;

	 /**
		 * Email Detail List 저장<br>
		 * 
		 * @param Event e
		 * @param String account
		 * @return EventResponse
		 * @exception EventException
		 */
	 public EventResponse modifyDwllNtfcSvcListDtl(Event e ,String account ) throws EventException;

	 /** 
		 *E-mail Sending Exception List 조회를 한다.
		 * 
		 * @param DwllNtfcSrchVO dwllntfcsrchvo
		 * @return List<DwllNtfcSrchVO>
		 * @exception EventException
		 */
	 public List<DwllNtfcSrchVO> searchDwllNtfcExptList(DwllNtfcSrchVO dwllntfcsrchvo) throws EventException;

	 
		/**
		 * E-mail Sending Exception List 저장을 한다.<br>
		 * 
		 * @param Event e
		 * @param String usrId
		 * @param String ofcCd
		 * @return EventResponse
		 * @exception EventException
		 */
	 public EventResponse addDwllNtfcExpt(Event e ,String usrId, String ofcCd ) throws EventException;

		/**
		 * Dwell Type별 E-Mail로 발송된 CNTR 개수를 조회 <br>
		 * Dwell Type별 E-Mail로 발송된 CNTR 개수를 조회 이벤트 처리<br>
		 * 
		 * @param Event e
		 * @return List<DwellNofifySendStsVO>
		 * @exception EventException
		 */
	public List<DwellNofifySendStsVO> searchDwellNofifySendSts(Event e) throws EventException;
		
		/**
		 * Dwell Type별 E-Mail로 발송된 CNTR 개수를 Customer Code별 조회 <br>
		 * Dwell Type별 E-Mail로 발송된 CNTR 개수를 Customer Code별 조회 이벤트 처리<br>
		 * 
		 * @param Event e
		 * @return List<DwellNofifySendStsVO>
		 * @exception EventException
		 */
	public List<DwellNofifySendStsVO> searchDwellNofifySendStsDtl(Event e) throws EventException;	
	
	/**
	 * Dwell Notification은 USNYC기준으로 화면 표시하도록 처리된다.
	 * 이에 대응해서 화면 처리가 되도록 정보를 제공
	 * @return DwellNotifyLMTDateVO
	 * @throws EventException
	 */
	public DwellNotifyLMTDateVO searchDwellNotifyLMTDate() throws EventException;

	 /** 
	 *Set up for Exception by Container List 조회를 한다.
	 * 
	 * @param DewllNotifiySetupExpContainerVO dewllnotifiysetupexpcontainervo
	 * @return List<DewllNotifiySetupExpContainerVO>
	 * @exception EventException
	 */
	public List<DewllNotifiySetupExpContainerVO> searchDwllNtfcExptCntList(DewllNotifiySetupExpContainerVO dewllnotifiysetupexpcontainervo) throws EventException;

 
	/**
	 * Set up for Exception by Container 저장을 한다.<br>
	 * 
	 * @param Event e
	 * @param String usrId
	 * @param String ofcCd
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse addDwllNtfcExptCnt(Event e ,String usrId ,String ofcCd) throws EventException;
	
	/** 
	 * SCNO 기준으로 조회를 한다.
	 * 
	 * @param DewllNotifiySetupExpContainerVO containervo
	 * @return DewllNotifiySetupExpContainerVO
	 * @exception EventException
	 */
	public DewllNotifiySetupExpContainerVO searchDwllNtfcExptCntMastBkg(DewllNotifiySetupExpContainerVO containervo) throws EventException;

	/**
	 * Candidate Inquiry by Dwell Type별 목록 <br>
	 * Candidate Inquiry by Dwell Type별 목록 조회 이벤트 처리<br>
	 * 
	 * @param e EsdSce0160Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDwellCandidateList(Event e) throws EventException;
	
	/** 
	 * Customer Type Code 조회.
	 * 
	 * @param String custCd
	 * @return String
	 * @exception EventException
	 */
	public String searchRvisCntrCustTpCd(String custCd) throws EventException;
	
	
	/** 
	 * 해당 SC No를 조회한다.
	 * 
	 * @param String custCd
	 * @return String
	 * @exception EventException
	 */
	public String searchScNoInfo(String custCd) throws EventException;


	 /**
	 * cnrt_no 별 sned option 상태 저장.<br>
	 * 
	 * @param Event e
	 * @param String account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyDwllEmailSendOption(Event e ,String account ) throws EventException;
	
	 /** 
	 * Candidate POPUP Email List 조회를 한다.
	 * 
	 * @param DwllNtfcSrchVO dwllntfcsrchvo
	 * @return List<DwllNtfcSrchVO>
	 * @exception EventException
	 */
	public List<DwllNtfcSrchVO> searchCandidateDwllNtfcSvcPopUpList(DwllNtfcSrchVO dwllntfcsrchvo) throws EventException;

	/**
	 * Candidate EMAIL 정보 저장.<br>
	 * 
	 * @param Event e
	 * @param String account
	 * @param String ofcCd
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse manageCandidateDwllNtfcSvcList(Event e ,String account, String ofcCd ) throws EventException;
	
	 /** 
	 * UI_ESD_SCE_0160 조회화면의 Dwell rns을 조회<br>.
	 * 
	 * @param DwellRnsVO dwllvo
	 * @return DwellRnsVO
	 * @exception EventException
	 */
	public DwellRnsVO searchDwellRsn(DwellRnsVO dwllvo) throws EventException;

	
	/**
	 * UI_ESD_SCE_0160 조회화면의 Dwell rns을 저장.<br>
	 * 
	 * @param Event e
	 * @param String account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse manageDwellRsn(Event e ,String account) throws EventException;

	/**
	 *dwell rsn [저장] 합니다.<br>
	 * 
	 * @param DwellRnsVO dwellRnsVO
     * @param String[] cloumndata
	 * @param String account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse manageDwellRsn1(DwellRnsVO dwellRnsVO ,String[] cloumndata ,String account) throws EventException;

	/** 
	 * Customer Code 유/무 조회
	 * 
	 * @param String custCd
	 * @return String
	 * @exception EventException
	 */
	public String checkCustCd(String custCd) throws EventException;

	/** 
	 * Dwell Notification Exception 항목 단건 조회.
	 * 
	 * @param DwllNtfcSrchVO dwllntfcsrchvo
	 * @return DwllNtfcSrchVO
	 * @exception EventException
	 */
	public DwllNtfcSrchVO searchDwllNtfcExptItem(DwllNtfcSrchVO dwllntfcsrchvo) throws EventException;
	
	 /** 
	 * Candidate POPUP Email List 조회를 한다.
	 * 
	 * @param SearchOneTimeSndHistVO searchOneTimeSndHistVO
	 * @return List<SearchOneTimeSndHistVO>
	 * @exception EventException
	 */
	public List<SearchOneTimeSndHistVO> searchOneTimeSndHistList(SearchOneTimeSndHistVO searchOneTimeSndHistVO) throws EventException;

	/**
	 * UI_ESD_SCE_0160 조회화면의 Tab별 Total Count 값 조회<br>
	 * 
	 * @param e EsdSce0160Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDwellCandidateTotalCnt(Event e) throws EventException;

}