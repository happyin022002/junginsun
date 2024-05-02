/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderIssueBC.java
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.29
*@LastModifier : 유선오
*@LastVersion : 1.12
* 2006-11-21 poong_yeon
* 1.0 최초 생성
*2010.09.09 이재위   1.1[SRM-201008617] [TRS] More candidate 조회 조건 수정 / (2) S/P select default 값 정정 요청 CSR
*                 1.2 N200901090011 W/O Issue 화면 보완요청
* 2011.02.10 민정호 1.3[CHM-201108602] [TRS]미주지역 Appt./Deli. time update 기능 추가
* 2011.07.14 김영철 1.4 [CHM-201110224] [TRS] Flat rack CNTR Bundling 기능 추가요청
* 2011.12.29 유선오 1.5 [CHM-201115242] [TRS] W/O preview 화면 관련 Validation 추가, BKG data 참조로직 변경요청
* 2012.12.11 이재위 1.6 [CHM-201221537] W/O issue 화면에 Currency / Negotiated 금액 save 버튼 생성 개발 요건
* 2015.07.20 9014787 [CHM-201536387] ALPS Auth 사후 결재 기능 개발
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.vo.BundlingListVO;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.vo.WoIssueListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-workordermanage Business Logic Command Interface<br>
 * - ESD-workordermanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author poong_yeon
 * @param <WoIssueListVO>
 * @see EsdTrs0023EventResponse 참조
 * @since J2EE 1.4
 */
public interface WorkOrderIssueBC  {

	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderIssue화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param woVO
	 * @return
	 * @throws EventException
	 */
	public ArrayList searchSurchargeList(List<WoIssueListVO> woVO) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderIssue화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param scgRs
	 * @return
	 * @throws EventException
	 */
	public ArrayList searchSurchargeList(DBRowSet scgRs) throws EventException;
	
	/**
	 * FRUSTRATE에 대한 처리.<br>
	 * WorkOrderIssue화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_023Event
	 * @return EventResponse ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse setFrustrate(Event e) throws EventException;
	
	/** 
	 * Appointment/Delivery Time 저장 처리.<br>
	 * WorkOrderIssue화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_023Event
	 * @return EventResponse ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse setAppDeli(Event e) throws EventException;	
	
	/**
	 * Curr Code / Nego Amt 저장 처리.<br>
	 * WorkOrderIssue화면에 대한 수정 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_023Event
	 * @return EventResponse ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyCurrNego(Event e) throws EventException;	
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderIssue화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_023Event
	 * @return EventResponse ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSpSelectList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderIssue화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_023Event
	 * @return EventResponse ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderIssueBySoNo(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderIssue화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchWorkOrderIssueList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * More Candidates 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchMoreCandidates(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * S/P SELECT 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchMdmOrganization(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Local currency에 대한 Usd currency 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLocalCurr2UsdCurr(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * 3RD PARTY BASIC INTERFACE BILLING CASE 목록을 가져온다.<br>
	 * 
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchBillingCaseCode() throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * 3RD PARTY BASIC INTERFACE 목록을 가져온다.<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTpbBasicAmt(Event e) throws EventException;
	

	/*
	 *  1.11 N200901090011 W/O Issue 화면 보완요청
	 */	
	/**
	 * 조회 이벤트 처리<br>
	 * 3RD PARTY BASIC INTERFACE 목록을 가져온다.<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWoIssuedSoList(Event e) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESD_TRS_0963 화면에 대한 조회 이벤트 처리 ( Bundling List 조회 )<br>
	 * 
	 * @param e
	 * @return List<BundlingListVO>
	 * @throws EventException
	 */
	public List<BundlingListVO> searchBundlingList(Event e) throws EventException;
	
	/**
	 * Bundling ( 저장 ) 이벤트 처리<br>
	 * ESD_TRS_0963 화면에 대한 조회 이벤트 처리 ( Bundling 저장 )<br>
	 *
	 * @param BundlingListVO[] bundlingListVO
	 * @param SignOnUserAccount account
	 * @param String gpYn
	 * @exception EventException
	 */
	public void setBundling (BundlingListVO[] bundlingListVO,SignOnUserAccount account, String gpYn) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview화면에 대한 issue 체크 상태 이벤트 처리<br>
	 * @param e
	 * @return EventResponse ESD_TRS_023EventResponse
	 * @throws EventException
	 */
	public EventResponse searchWorkOrderPreviewStatusCheck(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * More CNT Candidate화면에 대한 issue 체크 상태 이벤트 처리<br>
	 * @param e
	 * @return EventResponse ESD_TRS_023EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCntMoreCandidates(Event e) throws EventException;
		
	/**
	 * ReRate Apply 처리<br>
	 * ESD_TRS_023 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_023Event
	 * @return EventResponse ESD_TRS_023EventResponse
	 * @exception EventException
	 */
	public EventResponse searchReRateApplyList(Event e) throws EventException;
	
	/**
	 * W/O 저장 처리.<br>
	 * WorkOrderIssue화면에 대한 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse modifySave(Event e) throws EventException;
}