/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderManageSC.java
*@FileTitle : Transportation Report & Code / USA 404 EDI Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010-02-10
*@LastModifier : 민정호
*@LastVersion : 1.93
* 2006-11-07 poong_yeon
* 1.0 최초 생성
* 1.92 N200901090011 W/O Issue 화면 보완요청
* 1.95 N200905250130 [TRS]US RAIL EDI 발송시 RF CNTR Temp 체크 로직 추가
* N200906020130 2009-06-09 [TRS-Rail EDI] DG 정보 오전송에 따른 보완
* 1.77 2010.09.09 이재위 [SRM-201008617] [TRS] More candidate 조회 조건 수정 / (2) S/P select default 값 정정 요청 CSR
* 2.0  2011.02.10 민정호 [CHM-201108602] [TRS]미주지역 Appt./Deli. time update 기능 추가
* 2011.07.14 김영철  1.10[CHM-201110224] [TRS] Flat rack CNTR Bundling 기능 추가요청
* 2011.07.21 손은주   1.11[CHM-201111573-01]	[TRS] S/O history function 추가 요청
* 2011.12.09 민정호  1.83[CLT-111121293] R4J 패치 이후 발생한 결함 건 수정(Null dereference)
* 2011.12.29 유선오  1.84[CHM-201115242] [TRS] W/O preview 화면 관련 Validation 추가, BKG data 참조로직 변경요청
* 2012.04.12 김인수 1.85 [CHM-201216040] [TRS] US rail S/O 에 대한 S/O history function 연결 요청
* 2012.12.11 이재위 1.87 [CHM-201221537] W/O issue 화면에 Currency / Negotiated 금액 save 버튼 생성 개발 요건
* 2013.02.26 조인영 [CHM-201323086] W/O Issue - Preview - confirm 시 Inv No 존재하면 confirm 불가
* 2013.02.26 조인영 [CHM-201323802] S/O inquiry 화면의 DEL date logic 수정
* 2015.07.20 9014787 [CHM-201536387] ALPS Auth 사후 결재 기능 개발
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBC;
import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBCImpl;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic.ReplanManageBCImpl;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBC;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBCImpl;
import com.hanjin.apps.alps.esd.trs.common.trscommon.vo.TrsSOHistoryVO;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.basic.SingleTransportationSOManageBC;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.basic.SingleTransportationSOManageBCImpl;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0002Event;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.apps.alps.esd.trs.workordermanage.predispatchsenthistory.basic.PreDispatchSentHistoryBC;
import com.hanjin.apps.alps.esd.trs.workordermanage.predispatchsenthistory.basic.PreDispatchSentHistoryBCImpl;
import com.hanjin.apps.alps.esd.trs.workordermanage.predispatchsenthistory.event.EsdTrs0021Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.predispatchstatus.basic.PreDispatchStatusBC;
import com.hanjin.apps.alps.esd.trs.workordermanage.predispatchstatus.basic.PreDispatchStatusBCImpl;
import com.hanjin.apps.alps.esd.trs.workordermanage.predispatchstatus.event.EsdTrs0020Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.basic.USA404EDIStatusInquiryBC;
import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.basic.USA404EDIStatusInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0028Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.basic.WorkOrderCCManageBC;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.basic.WorkOrderCCManageBCImpl;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.event.EsdTrs0072Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.basic.WorkOrderInquiryBC;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.basic.WorkOrderInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.event.EsdTrs0025Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.event.EsdTrs0939Event;			// CHM-201536387 ALPS Auth 사후 결재 기능 개발
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBC;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBCImpl;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event.EsdTrs0023Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event.EsdTrs0921Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event.EsdTrs0963Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event.EsdTrs0980Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.vo.BundlingListVO;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.vo.WoIssueListVO;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.basic.WorkOrderPreviewBC;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.basic.WorkOrderPreviewBCImpl;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderremark.basic.WorkOrderRemarkBC;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderremark.basic.WorkOrderRemarkBCImpl;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderremark.event.EsdTrs0078Event;
//import com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
//import com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
//import com.hanjin.syscommon.common.table.CoaBkgComIfVO;
import com.hanjin.syscommon.common.table.TrsTrspEdiRailOrdVO;
//[CHM-201534153] 관리회계개선 프로젝트 1단계 Pre CM/OP Simulation Live 반영 요청
import com.hanjin.apps.alps.esd.trs.common.util.CommonUtil;
import com.hanjin.bizcommon.authorization.util.AuthorizationApprovalUtil;							// CHM-201536387 ALPS Auth 사후 결재 기능 개발

/**
 * ESD-WorkOrderManage Business Logic ServiceCommand<br>
 * - ESD-WorkOrderManage에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author poong_yeon
 * @see ESD_TRS_072EventResponse,WorkOrderCCManageDBDAO 참조
 * @since J2EE 1.4
 */
public class WorkOrderManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * WorkOrderManage 업무 시나리오 선행작업<br>
	 * WorkOrderCCManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("WorkOrderManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * WorkOrderManage 업무 시나리오 마감작업<br>
	 * WorkOrderCCManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("WorkOrderManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ESD-WorkOrderManage 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
				
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0072Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWorkOrderCCManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchWorkOrderCCFaxList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchWorkOrderCCEmailList(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiWorkOrderCCManageList(e);				
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0078Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
//				eventResponse = addWorkOrderRemark(e);
//			} else 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchWorkOrderRemarkList(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
//				eventResponse = modifyWorkOrderRemark(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeWorkOrderRemark(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiWorkOrderRemark(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWorkOrderIssueList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchWorkOrderIssueBySoNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSpSelectList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchLocalCurr2UsdCurr(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchBillingCaseCode();
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchTpbBasicAmt(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchWoIssuedSoList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchWorkOrderPreviewStatusCheck(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchReRateApplyList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = setFrustrate(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {				
				eventResponse = setAppDeli(e);		
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {				
				eventResponse = modifyCurrNego(e);		
			}
			// CHM-201536387 ALPS Auth 사후 결재 기능 개발
			else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {				
				eventResponse = modifySave(e);		
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSODeleteCheck(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchWorkOrderPreviewGroup(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchWorkOrderPreviewIssuedGroup(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchEdiInquiryList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = resendEDIAsia(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = resendEDIEur(e);
			}else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				try{
					eventResponse = addWorkOrderPreview(e);
				} catch (DAOException de) {
					log.error("err " + de.toString(), de);
					this.rollback();
					throw new EventException(de.getMessage());
				} catch (MailerAppException me) {
					log.error("err " + me.toString(), me);
					throw new EventException(me.getMessage());
				}							
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				try{
					eventResponse = addWorkOrderPreviewIssued(e);
				} catch (DAOException de) {
					log.error("err " + de.toString(), de);
					this.rollback();
					throw new EventException(de.getMessage());
				} catch (MailerAppException me) {
					log.error("err " + me.toString(), me);
					throw new EventException(me.getMessage());
				}
			}
			
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWorkOrderInquiryList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchWorkOrderInquiry(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchWorkOrderList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSvcOrdHisList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				// Cancel 건 까지 조회
				eventResponse = searchWorkOrderInquiryAddCancel(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0028Event")) {  // US RAIL EDI 화면.
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //Search Use
				eventResponse = searchUSA404EDIStatusInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //Confirm Message Send
				eventResponse = search02USA404EDIStatusInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //EDI Send Cop
				eventResponse = multiUSA404EDIStatusInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //CONFIM MESSAGE Send
				eventResponse = multi01USA404EDIStatusInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { //Cancellation EDI send
				eventResponse = multi02USA404EDIStatusInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { //FRUSTRATE
				eventResponse = multi03USA404EDIStatusInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { // 404EDI RESEND (Rail Billing Correction : UI204)
				eventResponse = multiUS404EDIResend(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPreDispatchStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = search01PreDispatchStatus(e);
			} else {
				eventResponse = null;
			}			
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPreDispatchSentHistory(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = search01PreDispatchSentHistory(e);
			} else {
				eventResponse = null;
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsdTrs0921Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMoreCandidates(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmOrganization(e);
			} else {
				eventResponse = null;
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsdTrs0963Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBundlingList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //Bundling
				eventResponse = multiBundling(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { //Remove Bundling
				eventResponse = removeBundling(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0980Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntMoreCandidates(e);
			}
		}
		// CHM-201536387 ALPS Auth 사후 결재 기능 개발
		else if (e.getEventName().equalsIgnoreCase("EsdTrs0939Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAuthWrkOrdList(e);
			}
		}
		return eventResponse;
	}


	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0025Event event = (EsdTrs0025Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			WorkOrderInquiryBC command = new WorkOrderInquiryBCImpl();
			eventResponse = command.searchWorkOrderInquiryList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0025Event event = (EsdTrs0025Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			WorkOrderInquiryBC command = new WorkOrderInquiryBCImpl();
			eventResponse = command.searchWorkOrderList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcOrdHisList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0025Event event = (EsdTrs0025Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			WorkOrderInquiryBC command = new WorkOrderInquiryBCImpl();
			eventResponse = command.searchSvcOrdHisList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0025Event event = (EsdTrs0025Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			WorkOrderInquiryBC command = new WorkOrderInquiryBCImpl();
			eventResponse = command.searchWorkOrderInquiry(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderInquiryAddCancel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0025Event event = (EsdTrs0025Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			WorkOrderInquiryBC command = new WorkOrderInquiryBCImpl();
			eventResponse = command.searchWorkOrderInquiryAddCancel(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse resendEDIEur(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event = (EsdTrs0024Event)e;
		
		try {
			this.begin();
			WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
			command.resendEDIEur(event);
			this.commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			this.rollback();
			throw new EventException(de.getMessage());
		}
		return null;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse resendEDIAsia(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event = (EsdTrs0024Event)e;
		
		try {
			this.begin();
			WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
			command.resendEDIAsia(event);
			this.commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			this.rollback();
			throw new EventException(de.getMessage());
		}
		return null;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse addWorkOrderPreview(Event e) throws EventException, DAOException, MailerAppException {
		
		EsdTrs0024Event event = (EsdTrs0024Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String woFaxUseFlg 	= null;
		String woEmlUseFlg 	= null;
		List<String> bkgNoList = new ArrayList<String>(); 
		
		List woArrMail = new ArrayList();
		
		WorkOrderPreviewBC command = null;
		TrsCommonBC commCommand =  null;
		
		String[] ffArray = null;
		ArrayList ediFlatFileArray = null;
		
		WorkOrderPreviewVO wrkOrdPrvVO	= event.getWorkOrderPreviewVO();
		TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();

		Boolean isFax= false;
		try {
			this.begin();
			command = new WorkOrderPreviewBCImpl();
			commCommand =  new TrsCommonBCImpl();
			woFaxUseFlg = wrkOrdPrvVO.getWoFaxUseFlg();
			woEmlUseFlg = wrkOrdPrvVO.getWoEmlUseFlg();
			
			if(woFaxUseFlg == null || !woFaxUseFlg.equals("FAX")){
				wrkOrdPrvVO.setWoN1stFaxNo("");
				wrkOrdPrvVO.setWoN2ndFaxNo("");
				wrkOrdPrvVO.setWoN3rdFaxNo("");
			}
			
			if(woEmlUseFlg == null || !woEmlUseFlg.equals("EML")){
				wrkOrdPrvVO.setWoN1stEml("");
				wrkOrdPrvVO.setWoN2ndEml("");
				wrkOrdPrvVO.setWoN3rdEml("");
			}

			event.setWorkOrderPreviewVO(wrkOrdPrvVO);
			bkgNoList = command.getBkgNoIfVndrChanged(event);
			
			/**
			 * 2013.02.26 조인영 [CHM-201323086]
			 * W/O Issue - Preview - confirm 시 Inv No 존재하면 confirm 불가
			 */
			DBRowSet rs = null;
			int checkAmt = 0;
			rs = command.searchInvNo(event);
			DBRowSet tmpRs = (DBRowSet) rs.clone();
			while(tmpRs.next()){
				if (!tmpRs.getString("INV_NO").equals("")){
					checkAmt ++;
					break;
					}
				}
			if (checkAmt != 0){
				throw new EventException(new ErrorHandler("TRS50104").getMessage());
			}
			ediFlatFileArray = command.addWorkOrderPreview(event, account);
			
			//TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY 입력
			soHisVo.setWoPrvGrpSeq(wrkOrdPrvVO.getWoPrvGrpSeq());
			soHisVo.setWoIssNo(wrkOrdPrvVO.getWoIssNo());
			soHisVo.setTrspSoEvntCd("WI");
			soHisVo.setCreUsrId(account.getUsr_id());
			soHisVo.setCreOfcCd(account.getOfc_cd());
			commCommand.multiSoHistory(soHisVo);
			
			/* TRS-COA IF */
			for(int i=0; i<bkgNoList.size(); i++){
				if(null!=bkgNoList.get(i) && !"".equals(bkgNoList.get(i))){
//					modifyCoaCommonInterface((String)bkgNoList.get(i), event.getFormCreUsrId());
					//MAS I/F [CHM-201534153] 관리회계개선 프로젝트 1단계 Pre CM/OP Simulation Live 반영 요청
					CommonUtil.modifyMasCommonInterface((String)bkgNoList.get(i),"S/O Modify", event.getFormCreUsrId());
				}		
			}
			//----Email--
			if(woEmlUseFlg != null && woEmlUseFlg.equals("EML")){
		        DBRowSet wonoRowSet = null;
		        wonoRowSet = command.searchWoNo(event);				
		        woArrMail=command.emailSend(event,wonoRowSet);
			}
			//------------
			//-----FAX------
			if(woFaxUseFlg != null && woFaxUseFlg.equals("FAX")){
				command.sendEaiFax(event,account.getUsr_id());
			}	
			//-------------
			// CHM-201536387 ALPS Auth 사후 결재 기능 개발
			if(event.getAuthAproRqstNo() != null && !"".equals(event.getAuthAproRqstNo())){
				AuthorizationApprovalUtil authorizationApprovalUtil = new AuthorizationApprovalUtil();
				authorizationApprovalUtil.updateAuthAproCfm(event.getAuthAproRqstNo());
			}
			this.commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			this.rollback();
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		
		try
		{
			wrkOrdPrvVO = event.getWorkOrderPreviewVO();

			String faxNo01=wrkOrdPrvVO.getFaxNo01()==null?"":wrkOrdPrvVO.getFaxNo01();
			String faxNo02=wrkOrdPrvVO.getFaxNo02()==null?"":wrkOrdPrvVO.getFaxNo02();
			String faxNo03=wrkOrdPrvVO.getFaxNo03()==null?"":wrkOrdPrvVO.getFaxNo03();
			if(!faxNo01.equals("")||!faxNo02.equals("")||!faxNo03.equals("")){
				isFax=true;
			}			

			if((isFax) || (null != woArrMail && woArrMail.size()>0)){
				command.addFaxAndEmailNo(event);
			}

			// 2009.05.24 잦은 timeout Exception으로 인해 edi send 부분을 tranjection에서 분리함
			for(int ediCnt = 0 ; ediFlatFileArray != null && ediCnt < ediFlatFileArray.size(); ediCnt++ ) {
				ffArray = (String[]) ediFlatFileArray.get(ediCnt);
				if(ffArray != null){
					if("EUR_ASIA".equals(ffArray[0])){
						command.sendFlatMessage(ffArray[1], ffArray[2]);
					}else if("USA".equals(ffArray[0])){
						command.sendUsaFlatMessage(ffArray[1]);
					}else if("317".equals(ffArray[0])){
						command.send317FlatMessage(ffArray[1]);
					}
				}
			}

			// SCE 연동
			DBRowSet rowSet = null;
			rowSet = command.searchEdiSendingList(event);
			
			Edi315SendBC callSend = new Edi315SendBCImpl();
 			Edi315SendVO edi315SendVo = null;

 			while(rowSet.next()){
 				edi315SendVo = new Edi315SendVO();
 				edi315SendVo.setCopNo(rowSet.getString("cop_no"));
 				edi315SendVo.setCostActGrpSeq(rowSet.getString("cost_act_grp_seq"));
 				edi315SendVo.setEdiStatus("WO");
 				edi315SendVo.setCreId(event.getFormCreUsrId());
 				edi315SendVo.setUpdId(event.getFormCreUsrId());
 				
				callSend.edi315Send(edi315SendVo);
			} 
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse addWorkOrderPreviewIssued(Event e) throws EventException, DAOException, MailerAppException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event = (EsdTrs0024Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String woFaxUseFlg = null;
		String woEmlUseFlg = null;

		List woArrMail = new ArrayList();
		
		WorkOrderPreviewBC command = null;
		EsdTrs0002Event event0002 = null;
		SingleTransportationSOManageBC command0002 = null;
		TrsCommonBC commCommand =  null;
		String user_id = event.getSignOnUserAccount().getUsr_id();
		String user_ofc_cd = event.getSignOnUserAccount().getOfc_cd();
		String[] ffArray = null;
		ArrayList ediFlatFileArray = null;
		
		WorkOrderPreviewVO wrkOrdPrvVO	= event.getWorkOrderPreviewVO();
		
		//TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY 입력
		TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();  
		
		Boolean isFax= false;

		try {
			this.begin();
			command = new WorkOrderPreviewBCImpl();
			commCommand =  new TrsCommonBCImpl();
			
			woFaxUseFlg = wrkOrdPrvVO.getWoFaxUseFlg();
			woEmlUseFlg = wrkOrdPrvVO.getWoEmlUseFlg();
			
			if(woFaxUseFlg == null || !woFaxUseFlg.equals("FAX")){
				wrkOrdPrvVO.setWoN1stFaxNo("");
				wrkOrdPrvVO.setWoN2ndFaxNo("");
				wrkOrdPrvVO.setWoN3rdFaxNo("");
			}
			
			if(woEmlUseFlg == null || !woEmlUseFlg.equals("EML")){
				wrkOrdPrvVO.setWoN1stEml("");
				wrkOrdPrvVO.setWoN2ndEml("");
				wrkOrdPrvVO.setWoN3rdEml("");
			}
			/**
			 * 2013.02.26 조인영 [CHM-201323086]
			 * W/O Issue - Preview - confirm 시 Inv No 존재하면 confirm 불가
			 */
			DBRowSet rs = null;
			int checkAmt = 0;
			rs = command.searchInvNo(event);
			DBRowSet tmpRs = (DBRowSet) rs.clone();
			while(tmpRs.next()){
				if (!tmpRs.getString("INV_NO").equals("")){
					checkAmt ++;
					break;
					}
				}
			if (checkAmt != 0){
				throw new EventException(new ErrorHandler("TRS50104").getMessage());
			}
			

			/*[CHM-201640094] WO 사후 Approval 보완 - s */ 
			if("N".equals(wrkOrdPrvVO.getWoIssStsCd()) || "R".equals(wrkOrdPrvVO.getWoIssStsCd()) || "C".equals(wrkOrdPrvVO.getWoIssStsCd())){
				String authAproRqstNo = command.searchAuthAproRqstNo(event);
				
				if(authAproRqstNo != null && !"".equals(authAproRqstNo)){
					AuthorizationApprovalUtil authorizationApprovalUtil = new AuthorizationApprovalUtil();
					authorizationApprovalUtil.cancelAuthApro(authAproRqstNo);
				}

			}
//			command.modifyWorkOrderPreviewWrkOrdHisCancel(event);
			/*[CHM-201640094] WO 사후 Approval 보완 - e */
			
			ediFlatFileArray = command.addWorkOrderPreviewIssued(event, account);
			
			//TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY 입력
			
			soHisVo.setWoPrvGrpSeq(wrkOrdPrvVO.getWoPrvGrpSeq());
			soHisVo.setWoIssNo(wrkOrdPrvVO.getWoIssNo());
			if( "N".equals(wrkOrdPrvVO.getWoIssStsCd())){
				soHisVo.setTrspSoEvntCd("WC");
				soHisVo.setTrspSoHisDesc("WO Canceled");
			}else{
				soHisVo.setTrspSoEvntCd("WI");
				if( "R".equals(wrkOrdPrvVO.getWoIssStsCd())){
					soHisVo.setTrspSoHisDesc("WO Reissued");
				}else{
					soHisVo.setTrspSoHisDesc("WO Correction");
				}
			}
			soHisVo.setCreUsrId(account.getUsr_id());
			soHisVo.setCreOfcCd(account.getOfc_cd());
			commCommand.multiSoHistory(soHisVo);
			
			
			//----Email--
			if(woEmlUseFlg != null && woEmlUseFlg.equals("EML")){
		        DBRowSet wonoRowSet = null;
		        wonoRowSet = command.searchWoNo(event);				
				woArrMail = command.emailSend(event,wonoRowSet);
			}
			//------------			

			// delete wo 처리 start
			SingleTransportationVO[] singleTransportationVOs = null;
			singleTransportationVOs = command.searchDeleteSoList(event);
			if (singleTransportationVOs != null && singleTransportationVOs.length > 0){
				event0002 = new EsdTrs0002Event();
				event0002.setSingleTransportationVOs(singleTransportationVOs);
				event0002.setForm_cre_usr_id(user_id);
				event0002.setForm_usr_ofc_cd(user_ofc_cd);
				command0002 = new SingleTransportationSOManageBCImpl();
				eventResponse = command0002.removeSingleTransportationSOManage(event0002);
				
			}
//			 delete wo 처리 end
			//-----FAX------
			if(woFaxUseFlg != null && woFaxUseFlg.equals("FAX")){
				command.sendEaiFax(event,account.getUsr_id());
			}
			//-------------------
			// CHM-201536387 ALPS Auth 사후 결재 기능 개발
			if(event.getAuthAproRqstNo() != null && !"".equals(event.getAuthAproRqstNo())){
				AuthorizationApprovalUtil authorizationApprovalUtil = new AuthorizationApprovalUtil();
				authorizationApprovalUtil.updateAuthAproCfm(event.getAuthAproRqstNo());
			}
			
			this.commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			this.rollback();
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}

		try
		{				
			wrkOrdPrvVO = event.getWorkOrderPreviewVO();

			String faxNo01=wrkOrdPrvVO.getFaxNo01()==null?"":wrkOrdPrvVO.getFaxNo01();
			String faxNo02=wrkOrdPrvVO.getFaxNo02()==null?"":wrkOrdPrvVO.getFaxNo02();
			String faxNo03=wrkOrdPrvVO.getFaxNo03()==null?"":wrkOrdPrvVO.getFaxNo03();
			if(!faxNo01.equals("")||!faxNo02.equals("")||!faxNo03.equals("")){
				isFax=true;
			}
			
			if((isFax) || (null != woArrMail && woArrMail.size()>0)){
				command.addFaxAndEmailNo(event);
			}
			
			// 2009.05.24 잦은 timeout Exception으로 인해 edi send 부분을 tranjaction에서 분리함
			for(int ediCnt = 0 ; ediFlatFileArray != null && ediCnt < ediFlatFileArray.size(); ediCnt++ ) {
				ffArray = (String[]) ediFlatFileArray.get(ediCnt);
				if(ffArray != null){
					
					if("EUR_ASIA".equals(ffArray[0])){
						command.sendFlatMessage(ffArray[1], ffArray[2]);
					}else if("USA".equals(ffArray[0])){
						command.sendUsaFlatMessage(ffArray[1]);
					}else if("317".equals(ffArray[0])){
						command.send317FlatMessage(ffArray[1]);
					}
					
				}
			}

			// SCE 연동
			DBRowSet rowSet = null;
			rowSet = command.searchEdiSendingList(event);
			
			Edi315SendBC callSend = new Edi315SendBCImpl();
 			Edi315SendVO edi315SendVo = null;

			while(rowSet.next()){
 				edi315SendVo = new Edi315SendVO();
 				edi315SendVo.setCopNo(rowSet.getString("cop_no"));
 				edi315SendVo.setCostActGrpSeq(rowSet.getString("cost_act_grp_seq"));
 				edi315SendVo.setEdiStatus("WO");
 				edi315SendVo.setCreId(event.getFormCreUsrId());
 				edi315SendVo.setUpdId(event.getFormCreUsrId());
 				
				callSend.edi315Send(edi315SendVo);
			} 
 			
			
			//COA I/F
			DBRowSet bkgRowSet = null;
			bkgRowSet = command.searchBkgCancelList(event);
			while(bkgRowSet.next()){									
//				CostAssignBC coaCommand = new CostAssignBCImpl();
//				CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
//				coaBkgComIfVo.setBkgNo(bkgRowSet.getString("bkg_no"));
//				coaBkgComIfVo.setCostSrcSysCd("TRS");//TRS, TES, SCE, BKG등 SUB SYSTEM CODE
//				coaBkgComIfVo.setIfRmk("W/O Cancel. RQST By BKG");
//				coaBkgComIfVo.setCreUsrId(user_id);
//				coaBkgComIfVo.setUpdUsrId(user_id);
//
//				int result_cnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
//				if (result_cnt < 0)
//					throw new EventException((new ErrorHandler("TRS00099",new String[]{"COA I/F Error"})).getMessage());
				
				//MAS I/F [CHM-201534153] 관리회계개선 프로젝트 1단계 Pre CM/OP Simulation Live 반영 요청
				CommonUtil.modifyMasCommonInterface(bkgRowSet.getString("bkg_no"),"W/O Cancel. RQST By BKG",user_id);
			}
			
			
		} catch (Exception de) {
			this.rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * EdiInquiryList 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEdiInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event = (EsdTrs0024Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
			eventResponse = command.searchEdiInquiryList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderPreviewIssuedGroup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event = (EsdTrs0024Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			this.begin();
			WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
			command.searchWorkOrderPreviewIssuedGroup(event);
			this.commit();
			this.begin();
			eventResponse = command.searchWorkOrderPreviewIssueStatus(event);
			this.commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			this.rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderPreviewGroup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event = (EsdTrs0024Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			
			WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
			this.begin();
			command.searchWorkOrderPreviewGroup(event);
			this.commit();
			this.begin();
			eventResponse = command.searchWorkOrderPreviewIssueStatus(event);
			this.commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			this.rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderCCManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchWorkOrderIssueList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event)e;
//		List<DBRowSet> rsList = new ArrayList<DBRowSet>();
		int i =1;
		
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchWorkOrderIssueList(event);
			List<WoIssueListVO> woModel = new ArrayList<WoIssueListVO>();

			woModel = (List) eventResponse.getRsVoList();
			if(woModel.size()>0){
			ArrayList scgArr = command.searchSurchargeList(woModel);
			if(scgArr.size()>0){
				DBRowSet scgRs = (DBRowSet) scgArr.get(0);
				@SuppressWarnings("unused")
				String[] colValue = null;
				String scgXml = null;
				StringBuffer sbScgXml = new StringBuffer();
				StringBuffer colOrder = new StringBuffer();
				
				if( scgRs != null ){
					colValue = new String[scgRs.getMetaData().getColumnCount()];
					for(int k=1; k<scgRs.getMetaData().getColumnCount()+1 ; k++) {
						colOrder.append("surcharge_"+scgRs.getMetaData().getColumnName(k).toLowerCase());
						//colValue[k-1] = "surcharge_"+scgRs.getMetaData().getColumnName(k);
						if(k != scgRs.getMetaData().getColumnCount()) colOrder.append("|");
					}
				}
//				소스품질 결함사항 수정 2014.05.22
//				scgXml = "<SHEET>";
//				scgXml = scgXml + "<DATA COLORDER='"+colOrder+"'>";
				sbScgXml.append("<SHEET>");
				sbScgXml.append("<DATA COLORDER='"+colOrder+"'>");
				
				for(int k=0; k<scgArr.size(); k++){
					scgRs = (DBRowSet) scgArr.get(k);
					while (scgRs!=null && scgRs.next()) {
						i = 1;
//						scgXml = scgXml + "<TR>";
						sbScgXml.append("<TR>");
						for (int j = 0 ; j < scgRs.getMetaData().getColumnCount() ; j++) {
//							scgXml = scgXml + "<TD>"+JSPUtil.getNull(scgRs.getString(i++))+"</TD>";
							sbScgXml.append("<TD>"+JSPUtil.getNull(scgRs.getString(i++))+"</TD>");
						}
//						scgXml = scgXml + "</TR>";
						sbScgXml.append("</TR>");
					}
				}
//				scgXml = scgXml + "</DATA></SHEET>";
				sbScgXml.append("</DATA></SHEET>");
				scgXml = sbScgXml.toString();
				
				eventResponse.setETCData("scgXml", scgXml);
				}
			}
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception f){
			log.error("err " + f.toString(), f);
			throw new EventException(f.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderCCManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchWorkOrderIssueBySoNo(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event)e;
//		List<DBRowSet> rsList = new ArrayList<DBRowSet>();
		int i =1;
		
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchWorkOrderIssueBySoNo(event);
			List<WoIssueListVO> woModel = new ArrayList<WoIssueListVO>();

			woModel = (List) eventResponse.getRsVoList();
			if(woModel.size()>0){
			ArrayList scgArr = command.searchSurchargeList(woModel);
			if(scgArr.size()>0){
				DBRowSet scgRs = (DBRowSet) scgArr.get(0);
				@SuppressWarnings("unused")
				String[] colValue = null;
				String scgXml = null;
				StringBuffer sbScgXml = new StringBuffer();
				StringBuffer colOrder = new StringBuffer();
				
				if( scgRs != null ){
					colValue = new String[scgRs.getMetaData().getColumnCount()];
					for(int k=1; k<scgRs.getMetaData().getColumnCount()+1 ; k++) {
						colOrder.append("surcharge_"+scgRs.getMetaData().getColumnName(k));
						//colValue[k-1] = "surcharge_"+scgRs.getMetaData().getColumnName(k);
						if(k != scgRs.getMetaData().getColumnCount()) colOrder.append("|");
					}
				}
//				소스품질 결함 사항 조치 2014.05.22 SHIN DONG IL
//				scgXml = "<SHEET>";
//				scgXml = scgXml + "<DATA COLORDER='"+colOrder+"'>";
				sbScgXml.append("<SHEET>");
				sbScgXml.append("<DATA COLORDER='"+colOrder+"'>");
				
				
				for(int k=0; k<scgArr.size(); k++){
					scgRs = (DBRowSet) scgArr.get(k);
					while (scgRs!=null && scgRs.next()) {
						i = 1;
//						scgXml = scgXml + "<TR>";
						sbScgXml.append("<TR>");
						for (int j = 0 ; j < scgRs.getMetaData().getColumnCount() ; j++) {
//							scgXml = scgXml + "<TD>"+JSPUtil.getNull(scgRs.getString(i++))+"</TD>";
							sbScgXml.append("<TD>"+JSPUtil.getNull(scgRs.getString(i++))+"</TD>");
						}
//						scgXml = scgXml + "</TR>";
						sbScgXml.append("</TR>");
					}
				}
//				scgXml = scgXml + "</DATA></SHEET>";
				sbScgXml.append("</DATA></SHEET>");
				scgXml = sbScgXml.toString();
				
				eventResponse.setETCData("scgXml", scgXml);
				}
			}
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception f){
			log.error("err " + f.toString(), f);
			throw new EventException(f.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderCCManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchSpSelectList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event)e;
//		List<DBRowSet> rsList = new ArrayList<DBRowSet>();
		int i =1;
		
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchSpSelectList(event);
			List<WoIssueListVO> woModel = new ArrayList<WoIssueListVO>();

			woModel = (List) eventResponse.getRsVoList();
			if(woModel.size()>0){
			ArrayList scgArr = command.searchSurchargeList(woModel);
			if(scgArr.size()>0){
				DBRowSet scgRs = (DBRowSet) scgArr.get(0);
				@SuppressWarnings("unused")
				String[] colValue = null;
				String scgXml = null;
				StringBuffer sbScgXml = new StringBuffer();
				StringBuffer colOrder = new StringBuffer();
				
				if( scgRs != null ){
					colValue = new String[scgRs.getMetaData().getColumnCount()];
					for(int k=1; k<scgRs.getMetaData().getColumnCount()+1 ; k++) {
						colOrder.append("surcharge_"+scgRs.getMetaData().getColumnName(k));
						//colValue[k-1] = "surcharge_"+scgRs.getMetaData().getColumnName(k);
						if(k != scgRs.getMetaData().getColumnCount()) colOrder.append("|");
					}
				}
//				소스품질 결함 수정 2014.05.22 SHIN DONG IL
//				scgXml = "<SHEET>";
//				scgXml = scgXml + "<DATA COLORDER='"+colOrder+"'>";
				sbScgXml.append("<SHEET>");
				sbScgXml.append("<DATA COLORDER='"+colOrder+"'>");
				
				for(int k=0; k<scgArr.size(); k++){
					scgRs = (DBRowSet) scgArr.get(k);
					while (scgRs!=null && scgRs.next()) {
						i = 1;
//						scgXml = scgXml + "<TR>";
						sbScgXml.append("<TR>");
						for (int j = 0 ; j < scgRs.getMetaData().getColumnCount() ; j++) {
//							scgXml = scgXml + "<TD>"+JSPUtil.getNull(scgRs.getString(i++))+"</TD>";	
							sbScgXml.append("<TD>"+JSPUtil.getNull(scgRs.getString(i++))+"</TD>");
						}
//						scgXml = scgXml + "</TR>";
						sbScgXml.append("<TR>");
					}
				}
//				scgXml = scgXml + "</DATA></SHEET>";
				sbScgXml.append("</DATA></SHEET>");
				scgXml =sbScgXml.toString();
				
				eventResponse.setETCData("scgXml", scgXml);
				
				}
			}
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception f){
			log.error("err " + f.toString(), f);
			throw new EventException(f.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderCCManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocalCurr2UsdCurr(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event)e;
		
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchLocalCurr2UsdCurr(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * More CNT Candidate 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntMoreCandidates(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0980Event event = (EsdTrs0980Event)e;
		
		try {
			
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchCntMoreCandidates(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * FRUSTRATE에 대한 처리를 한다.<br>
	 * WorkOrderCCManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse setFrustrate(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event)e;
		
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			TrsCommonBC commCommand =  new TrsCommonBCImpl();
//			SingleTransportationSOManageBC command002 = new SingleTransportationSOManageBCImpl();
			
			begin();
			eventResponse = (EventResponse) command.setFrustrate(event);
//			ArrayList modelList = (ArrayList) eventResponse.getRsList();
//			TRO i/f 삭제됨
//			command002.interfaceFrustrateForTRO(modelList);
			WoIssueListVO[] model = event.getWoIssueListVOs();
			if( model != null && model.length > 0 ){
				for( int i=0; i<model.length; i++ ){
					//TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY 입력
					TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();
					soHisVo.setTrspSoOfcCtyCd(model[i].getTrspSoOfcCtyCd());
					soHisVo.setTrspSoSeq(model[i].getTrspSoSeq());
					soHisVo.setTrspSoEvntCd("SF");
					soHisVo.setCreUsrId(event.getSignOnUserAccount().getUsr_id());	
					soHisVo.setCreOfcCd(event.getSignOnUserAccount().getOfc_cd());
					commCommand.multiSoHistory(soHisVo);
				}
			}
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * Appointment/Delivery Time 저장 처리를 한다.<br>
	 * WorkOrderCCManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse setAppDeli(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event)e;
		
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();			
			begin();
			eventResponse = (EventResponse) command.setAppDeli(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * Curr Code / Nego Amount 저장 처리를 한다.<br>
	 * WorkOrderCCManage 화면에 대한 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCurrNego(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event)e;
		
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();			
			begin();
			eventResponse = (EventResponse) command.modifyCurrNego(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * 추가 이벤트 처리<br>
	 * WorkOrderCCManage의 event에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiWorkOrderRemark(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0078Event event = (EsdTrs0078Event)e;
//		EventResponse eventResponse = null;
		try {
			begin();
			WorkOrderRemarkBC command = new WorkOrderRemarkBCImpl();
			command.multiWorkOrderRemark(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return this.searchWorkOrderRemarkList(e);
		//return eventResponse;
	}
	
	/**
	 * 추가 이벤트 처리<br>
	 * WorkOrderCCManage의 event에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeWorkOrderRemark(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0078Event event = (EsdTrs0078Event)e;
//		EventResponse eventResponse = null;
		try {
			begin();
			WorkOrderRemarkBC command = new WorkOrderRemarkBCImpl();
			command.removeWorkOrderRemark(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
 
		return this.searchWorkOrderRemarkList(e);
		//return eventResponse; 
	}
	
	/**
	 * 추가 이벤트 처리<br>
	 * WorkOrderCCManage의 event에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
//	private EventResponse modifyWorkOrderRemark(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		EsdTrs0078Event event = (EsdTrs0078Event)e;
//		EventResponse eventResponse = null;
//
//		try {
//			begin();
//			WorkOrderRemarkBC command = new WorkOrderRemarkBCImpl();
//			command.modifyWorkOrderRemark(event);
//			commit();
//		} catch (EventException de) {
//			rollback();
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		
////		return eventResponse; //this.searchWorkOrderRemarkList(e);
//		return this.searchWorkOrderRemarkList(e);
//	}
	
	/**
	 * 추가 이벤트 처리<br>
	 * WorkOrderCCManage의 event에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
//	private EventResponse addWorkOrderRemark(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		EsdTrs0078Event event = (EsdTrs0078Event)e;
//
//		try {
//			begin();
//			WorkOrderRemarkBC command = new WorkOrderRemarkBCImpl();
//			command.addWorkOrderRemark(event);
//			commit();
//		} catch (EventException de) {
//			rollback();
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		
//		return this.searchWorkOrderRemarkList(e);
//	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderCCManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderRemarkList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0078Event event = (EsdTrs0078Event)e;
		try {
			WorkOrderRemarkBC command = new WorkOrderRemarkBCImpl();
			eventResponse = command.searchWorkOrderRemarkList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderCCManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderCCManageList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0072Event event 		= (EsdTrs0072Event)e;
		
		try {
			WorkOrderCCManageBC command = new WorkOrderCCManageBCImpl();
			eventResponse 				= command.searchWorkOrderCCManageList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderCCManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderCCFaxList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0072Event 	event 			= (EsdTrs0072Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse 		eventResponse 	= null;
		
		try {
			WorkOrderCCManageBC command = new WorkOrderCCManageBCImpl();
			eventResponse 				= command.searchWorkOrderCCFaxList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderCCManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderCCEmailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0072Event 	event 			= (EsdTrs0072Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse 		eventResponse 	= null;
		
		try {
			WorkOrderCCManageBC command = new WorkOrderCCManageBCImpl();
			eventResponse 				= command.searchWorkOrderCCEmailList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	

	/**
	 * 멀티 이벤트 처리<br>
	 * WorkOrderCCManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiWorkOrderCCManageList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0072Event 	event 			= (EsdTrs0072Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse 		eventResponse 	= null;
		
		try {
			begin();
			WorkOrderCCManageBC command = new WorkOrderCCManageBCImpl();
			command.multiWorkOrderCCManageList(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		if("FAX".equals(event.getFaxEmailIndicator())){
			eventResponse = this.searchWorkOrderCCFaxList(e);
		}
		else{
			eventResponse = this.searchWorkOrderCCEmailList(e);
		}
		
		//return this.searchWorkOrderCCManageList(e);
		return eventResponse;
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 404EDI 조회
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSA404EDIStatusInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event = (EsdTrs0028Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
			eventResponse = command.searchUSA404EDIStatusInquiry(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * Confimr Message Send Popup
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search02USA404EDIStatusInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event = (EsdTrs0028Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
			eventResponse = command.search02USA404EDIStatusInquiry(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	




	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * 404EDI CONFIM MESSAGE Send
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi01USA404EDIStatusInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event = (EsdTrs0028Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
			command.multi01USA404EDIStatusInquiry(event);
			command.faxEdiSend(event);
			command.emailEdiSend(event);
			commit();
		}catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse; 
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUSA404EDIStatusInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event = (EsdTrs0028Event)e;
		EventResponse eventResponse = null;
		EventResponse eventResponseSub = null;
		GeneralEventResponse eventResponseReturn = new GeneralEventResponse();
		USA404EDIStatusInquiryBC command = null;
		try {
			String userId = "SPP_IF";
			String sofficeCd = "PHXSA"; 
			if (event != null && event.getSignOnUserAccount() != null) {
				userId = event.getSignOnUserAccount().getUsr_id();
			} 
			if (account != null)
				sofficeCd = account.getOfc_cd();
			
			/*
			 * 2009.05.26 - 1.95 N200905250130 [TRS]US RAIL EDI 발송시 RF CNTR Temp 체크 로직 추가
			 * N200906020130 2009-06-09 [TRS-Rail EDI] DG 정보 오전송에 따른 보완
			 */
			command = new USA404EDIStatusInquiryBCImpl();
			command.verifyObReeferCntr(event);  // O/B FULL CNTR REEFER에 관한 VERIFY (404 EDI 발송 시 CNTR, 온도 누락 방지 위해)
			command.verifyObDgCntr(event);  // O/B FULL CNTR DG에 관한 VERIFY (404 EDI 발송 시 DG 정보 누락 방지 위해)
			
			String trsp_so_ofc_cty_cd = null;
			String trsp_so_seq        = null;
			begin();
			eventResponse = command.multiUSA404EDIStatusInquiry(event);     // COP,EQR,TRS 데이터 셋팅. (EDI HIST 등, COP 업뎃)
			TrsCommonBC commCommand =  new TrsCommonBCImpl();
			TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();
			
			//COP Replan을 위해 
			TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
			ReplanManageBC replanManageBC = new ReplanManageBCImpl();//BC생성
						
			for ( int i=0; i<model.length; i++ ) {
				
				trsp_so_ofc_cty_cd = model[i].getTrspSoOfcCtyCd();
				trsp_so_seq = model[i].getTrspSoSeq();
				
				if (model[i].getCgoTpCd().equals("F")) {
					model[i].setTrspSoStsCd("I");
					
					//COP TRS S/O Status Update
					replanManageBC.modifySoList(model[i]);
				}
				//history 생성
				
				soHisVo.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
				soHisVo.setTrspSoSeq(trsp_so_seq);
				soHisVo.setTrspSoEvntCd("WI");
				soHisVo.setRoutRplnFlg("N"); //route 변경시 Y
				soHisVo.setCreUsrId(userId);	
				soHisVo.setCreOfcCd(sofficeCd);
				soHisVo.setSrcCd("USRAIL");
				commCommand.multiSoHistory(soHisVo);
			}
			eventResponseSub = command.search03USA404EDIStatusSend(eventResponse.getRsVoList()); // EDI 404 기초 데이터 Search
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		try {
			command.search03SubUSA404EDIStatusSend(eventResponseSub.getRs()); // EDI 404 FLATFILE 만들어서 실제 송신.
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			this.multiUSA404EDIRollbackStatusInquiry(event);
			throw new EventException(de.getMessage());
		}
		return eventResponseReturn;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiUSA404EDIRollbackStatusInquiry(Event e) throws EventException {
		try {
			begin();
			USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
			command.multiUSA404EDIRollbackInquiry(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return null;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * 404EDI Cancellation EDI Send
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi02USA404EDIStatusInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event = (EsdTrs0028Event)e;
		EventResponse eventResponse = null;
		EventResponse eventResponseSub = null;
		GeneralEventResponse eventResponseReturn = new GeneralEventResponse();
		try {
			String userId = "SPP_IF";
			String sofficeCd = "PHXSA"; 
			if (event != null && event.getSignOnUserAccount() != null) {
				userId = event.getSignOnUserAccount().getUsr_id();
			} 
			if (account != null)
				sofficeCd = account.getOfc_cd();
			/*
			 * 2009.05.26 - 1.95 N200905250130 [TRS]US RAIL EDI 발송시 RF CNTR Temp 체크 로직 추가
			 * N200906020130 2009-06-09 [TRS-Rail EDI] DG 정보 오전송에 따른 보완
			 */
			USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
			command.verifyObReeferCntr(event);  // O/B FULL CNTR REEFER에 관한 VERIFY (404 EDI 발송 시 CNTR, 온도 누락 방지 위해)
			command.verifyObDgCntr(event);  // O/B FULL CNTR DG에 관한 VERIFY (404 EDI 발송 시 DG 정보 누락 방지 위해)
			
			String trsp_so_ofc_cty_cd = null;
			String trsp_so_seq        = null;
			begin();
			eventResponse = command.multi02USA404EDIStatusInquiry(event);			
			TrsCommonBC commCommand =  new TrsCommonBCImpl();
			
			//COP Replan을 위해
			ReplanManageBC replanManageBC = new ReplanManageBCImpl();//BC생성
			TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
			
			// history 생성을 위하여 선 List 를 생성 후 TRS 정보 update 후 history 를 생성한다.
			List<TrsSOHistoryVO> soHistList = new ArrayList<TrsSOHistoryVO> ();
			
			for ( int i=0; i<model.length; i++ ) {
				
				trsp_so_ofc_cty_cd = model[i].getTrspSoOfcCtyCd();
				trsp_so_seq = model[i].getTrspSoSeq();
				
				TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();
				soHisVo.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
				soHisVo.setTrspSoSeq(trsp_so_seq);
				soHisVo.setTrspSoEvntCd("WC");
				soHisVo.setRoutRplnFlg("N"); //route 변경시 Y
				soHisVo.setSrcCd("USRAIL");
//				soHisVo.setWoPrvGrpSeq(wrkOrdPrvVO.getWoPrvGrpSeq());
//				soHisVo.setWoIssNo(wrkOrdPrvVO.getWoIssNo());
				
				if (model[i].getCgoTpCd().equals("F")) {
					if( model[i].getWoRjctRsn().equals("RBB") ) { //Request By BKG
						//COA I/F
//						CostAssignBC coaCommand = new CostAssignBCImpl();
//						CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
//						coaBkgComIfVo.setBkgNo(model[i].getBkgNo());
//						coaBkgComIfVo.setCostSrcSysCd("TRS");//TRS, TES, SCE, BKG등 SUB SYSTEM CODE
//						coaBkgComIfVo.setIfRmk("US RAIL 404 EDI CANCEL");
//						coaBkgComIfVo.setCreUsrId(userId);
//						coaBkgComIfVo.setUpdUsrId(userId);
//
//						int result_cnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
//						if (result_cnt < 0)
//							throw new EventException((new ErrorHandler("SAQ00099",new String[]{"COA I/F Error"})).getMessage());
						//MAS I/F [CHM-201534153] 관리회계개선 프로젝트 1단계 Pre CM/OP Simulation Live 반영 요청
						CommonUtil.modifyMasCommonInterface(model[i].getBkgNo(),"US RAIL 404 EDI CANCEL",userId);
						
						model[i].setTrspSoStsCd("D");						
					}else{
						model[i].setTrspSoStsCd("C");						
					}
					
					//COP TRS S/O Status Update
					replanManageBC.modifySoList(model[i]);
					
				}
				
				//history 생성
				soHisVo.setCreUsrId(userId);	
				soHisVo.setCreOfcCd(sofficeCd);
				soHisVo.setSrcCd("USRAIL");
				soHistList.add(soHisVo);
			}
			
			eventResponseSub = command.search04USA404EDIStatusSend(eventResponse.getRsVoList()); // EDI 404 Search
			command.multi02USA404EDIStatusInquiryRBB(event);
			
			for (int i = 0 ; i < soHistList.size(); i ++) { // 이렇게 한 이유는 multi02USA404EDIStatusInquiryRBB 를 처리 한 후 history 를 보내야 정확한 wo reject reason 을 기록하기 때문임
				commCommand.multiSoHistory(soHistList.get(i));
			}
			commit();
			
			command.search04SubUSA404EDIStatusSend(eventResponseSub.getRs()); // EDI 404
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponseReturn;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * FRUSTRATE
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi03USA404EDIStatusInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event = (EsdTrs0028Event)e;
		GeneralEventResponse eventResponseReturn = new GeneralEventResponse();
		
		try {
			String userId = "SPP_IF";
			String sofficeCd = "PHXSA"; 
			if (event != null && event.getSignOnUserAccount() != null) {
				userId = event.getSignOnUserAccount().getUsr_id();
			} 
			if (account != null)
				sofficeCd = account.getOfc_cd();
			
			begin();
			USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
			command.multi03USA404EDIStatusInquiry(event);
			
			String trsp_so_ofc_cty_cd = null;
			String trsp_so_seq        = null;
			TrsCommonBC commCommand =  new TrsCommonBCImpl();
			TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();
			//COP Replan을 위해 
			TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
			ReplanManageBC replanManageBC = new ReplanManageBCImpl();//BC생성
			 
			for ( int i=0; i<model.length; i++ ) {
				
				trsp_so_ofc_cty_cd = model[i].getTrspSoOfcCtyCd();
				trsp_so_seq = model[i].getTrspSoSeq();
				
				if (model[i].getCgoTpCd().equals("F")) {
					model[i].setTrspSoStsCd("F");
					
					//COP TRS S/O Status Update
					replanManageBC.modifySoList(model[i]);
				}
				
				//history 생성
				
				soHisVo.setTrspSoOfcCtyCd(trsp_so_ofc_cty_cd);
				soHisVo.setTrspSoSeq(trsp_so_seq);
				soHisVo.setTrspSoEvntCd("SF");
				soHisVo.setRoutRplnFlg("N"); //route 변경시 Y
				soHisVo.setCreUsrId(userId);	
				soHisVo.setCreOfcCd(sofficeCd);
				soHisVo.setSrcCd("USRAIL");
				commCommand.multiSoHistory(soHisVo);
			}
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponseReturn; //this.searchUSA404EDIStatusInquiry(e);
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * multiUS404EDIResend(US Rail Correction) event에 대한 멀티 이벤트 처리<br>
	 * EDI RESEND (404EDI)
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUS404EDIResend(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0028Event event = (EsdTrs0028Event)e;
		EventResponse eventResponse = null;
		EventResponse eventResponseSub = null;
		GeneralEventResponse eventResponseReturn = new GeneralEventResponse();
		USA404EDIStatusInquiryBC command = null;		
		
		try {
			/*
			 * 2009.05.26 - 1.95 N200905250130 [TRS]US RAIL EDI 발송시 RF CNTR Temp 체크 로직 추가
			 * N200906020130 2009-06-09 [TRS-Rail EDI] DG 정보 오전송에 따른 보완
			 */
			command 				= new USA404EDIStatusInquiryBCImpl();
			command.verifyObReeferCntr(event);  // O/B FULL CNTR REEFER에 관한 VERIFY (404 EDI 발송 시 CNTR, 온도 누락 방지 위해)
			command.verifyObDgCntr(event);  // O/B FULL CNTR DG에 관한 VERIFY (404 EDI 발송 시 DG 정보 누락 방지 위해)
		
			begin();			
			eventResponse = command.modifyUS404EDIResendRailBilOrd(event);	// COP,EQR,TRS 데이터 셋팅. (EDI HIST 등, COP 업뎃)
			eventResponseSub = command.searchUS404EDIResendList(eventResponse.getRsVoList()); // EDI 404 Search			
			commit();			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		try {		
			//JSK:20080704:확인할것.
			command.resendUS404EDIResend(eventResponseSub.getRs()); // EDI 404 FLATFILE 만들어서 실제 송신. ref)search03SubUSA404EDIStatusSend			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			this.addUSA404EDIResendRollback(event);	//multiUSA404EDIRollbackStatusInquiry
			throw new EventException(de.getMessage());
		}
		return eventResponseReturn;
	}	
	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * 404EDI Send
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse addUSA404EDIResendRollback(Event e) throws EventException {
		try {
			begin();
			USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
			command.addUSA404EDIResendRollback(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return null;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * PreDispatchStatus의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreDispatchStatus(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0020Event event = (EsdTrs0020Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;		
		try {	        
			PreDispatchStatusBC command = new PreDispatchStatusBCImpl();
			eventResponse = command.searchPreDispatchStatus(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * PreDispatchStatus의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search01PreDispatchStatus(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0020Event event = (EsdTrs0020Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			PreDispatchStatusBC command = new PreDispatchStatusBCImpl();
			eventResponse = command.search01PreDispatchStatus(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * PreDispatchSentHistory의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreDispatchSentHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0021Event event = (EsdTrs0021Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;		
		try {
			PreDispatchSentHistoryBC command = new PreDispatchSentHistoryBCImpl();
			eventResponse = command.searchPreDispatchSentHistory(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * PreDispatchSentHistory의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search01PreDispatchSentHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0021Event event = (EsdTrs0021Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			PreDispatchSentHistoryBC command = new PreDispatchSentHistoryBCImpl();
			eventResponse = command.search01PreDispatchSentHistory(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * More Candidates  event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMoreCandidates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0921Event event = (EsdTrs0921Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchMoreCandidates(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrder Preview event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSODeleteCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0024Event event = (EsdTrs0024Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
			eventResponse = command.searchSODeleteCheck(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 3RD PARTY BASIC INTERFACE BILLING CASE 목록을 가져온다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBillingCaseCode() throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = null;
		
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = (GeneralEventResponse) command.searchBillingCaseCode();			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 3RD PARTY BASIC INTERFACE 목록을 가져온다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTpbBasicAmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0023Event event = (EsdTrs0023Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = null;
		
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = (GeneralEventResponse) command.searchTpbBasicAmt(event);			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
/*
 * 1.92 N200901090011 W/O Issue 화면 보완요청
 */
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderCCManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchWoIssuedSoList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchWoIssuedSoList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
		
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrderPreview 화면의 issue 상테체크에 대한 조회 이벤트 처리<br>
	 * @param e
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchWorkOrderPreviewStatusCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0023Event event = (EsdTrs0023Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchWorkOrderPreviewStatusCheck(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * S/P Select 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmOrganization(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0921Event event = (EsdTrs0921Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchMdmOrganization(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * COA Interface 처리<br>
	 * WorkOrderPreview화면에 대한 COA Interface 처리<br>
	 * 
	 * @param bkgNo
	 * @param usrId
	 * @throws EventException
	 */
//	public void modifyCoaCommonInterface(String bkgNo, String usrId) throws EventException{
//		
//		try {
//			CostAssignBC coaCommand = new CostAssignBCImpl();
//			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
//			coaBkgComIfVo.setBkgNo(bkgNo); 
//			coaBkgComIfVo.setCostSrcSysCd("TRS");//TRS, TES, SCE, BKG등 SUB SYSTEM CODE
//			coaBkgComIfVo.setIfRmk("S/O Modify");
//			coaBkgComIfVo.setCreUsrId(usrId);
//			coaBkgComIfVo.setUpdUsrId(usrId);
//	
//			int resultCnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
//			if (resultCnt < 0)
//				throw new EventException((new ErrorHandler("SAQ00099",new String[]{"COA I/F Error"})).getMessage());
//			
//		}catch(EventException ex){
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(ex.getMessage()); 
//		}
//	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESD_TRS_0963 화면에 대한 조회 이벤트 처리 ( Bundling List 조회 )<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBundlingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0963Event event = (EsdTrs0963Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
//		EventResponse eventResponse = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.debug("SC====================");
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			List<BundlingListVO> list = command.searchBundlingList(event);
			
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Bundling 이벤트 처리<br>
	 * ESD_TRS_0963 화면에 대한 Bundling 이벤트 처리 ( Bundling 처리 )<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiBundling(Event e) throws EventException {

		EsdTrs0963Event event = (EsdTrs0963Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		log.debug("SC====================");
		try {
			begin();
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();			
			command.setBundling(event.getBundlingListVOs(),account,"B");	
			eventResponse.setETCData("SuccessYn", "Y");
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Bundling 이벤트 처리<br>
	 * ESD_TRS_0963 화면에 대한 Bundling 이벤트 처리 ( Remove Bundling 처리 )<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeBundling(Event e) throws EventException {

		EsdTrs0963Event event = (EsdTrs0963Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		log.debug("SC====================");
		try {
			begin();
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();			
			command.setBundling(event.getBundlingListVOs(),account,"");	
			eventResponse.setETCData("SuccessYn", "Y");
			commit();			

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;	
			
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
	}


	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrder Issue 화면에 대한 조회 이벤트 처리<br>
	 * @param e EsdTrs0023Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReRateApplyList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event)e;
		
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchReRateApplyList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * WorkOrder Auth 화면에 대한 조회 이벤트 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthWrkOrdList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0939Event event = (EsdTrs0939Event)e;
		
		try {
			WorkOrderInquiryBC command = new WorkOrderInquiryBCImpl();
			eventResponse = command.searchAuthWrkOrdList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * W/O 저장 처리를 한다.<br>
	 * Work Order Issue 화면에 대한 수정 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySave(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event)e;
		
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();			
			begin();
			eventResponse = (EventResponse) command.modifySave(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}
// ///////////////////////////////////////////////////////////////////////////////////////////////////////
// ///////////////////////////////////////////////////////////////////////////////////////////////////////
//
//public EventResponse perform(Event e) throws EventException {
//
//	//RDTO(Data Transfer Object including DB ResultSet) 를 구현한 객체
//	EventResponse response = null;
//
//	ESD_TRS_072Event Event = (ESD_TRS_072Event) e;
//
//	if (e.getCommandName.equalsIgnoreCase("EduPollMngCmd")) {
//		if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
//			response = searchEduPollMngList(event.getEDUCATION_SEARCH_BEAN());
//		} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
//			response = multiEduPollMng(event.getEDUCATION_SEARCH_BEAN(), event.getPI_EDU_POLLS(), account.getUserid());
//		} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
//			response = searchEduPollResultList(event.getEDUCATION_SEARCH_BEAN());
//		} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
//			response = multiEduPollResultMng(event.getEDUCATION_SEARCH_BEAN(), event.getPI_EDU_POLL_RESULTS(), account.getUserid());
//		}
//	}else if (e.getCommandName.equalsIgnoreCase("EduPoll2MngCmd")) {
//		if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
//			response = searchEduPollMngList(event.getEDUCATION_SEARCH_BEAN());
//		} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
//			response = multiEduPollMng(event.getEDUCATION_SEARCH_BEAN(), event.getPI_EDU_POLLS(), account.getUserid());
//		} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
//			response = searchEduPollResultList(event.getEDUCATION_SEARCH_BEAN());
//		} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
//			response = multiEduPollResultMng(event.getEDUCATION_SEARCH_BEAN(), event.getPI_EDU_POLL_RESULTS(), account.getUserid());
//		}
//	}
//
//	return response;
//}