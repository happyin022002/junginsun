/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMApprovalSC.java
*@FileTitle : ACMApprovalSC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.09 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.basic.AGNCommApprovalBC;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.basic.AGNCommApprovalBCImpl;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.event.EsmAcm0009Event;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.event.EsmAcm0013Event;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration.AGNCommApprovalDBDAO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommAsaNoVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommVendorVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.ReturnCSRDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.ReturnCSRMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.basic.FFCmpnApprovalBC;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.basic.FFCmpnApprovalBCImpl;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.event.EsmAcm0030Event;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalPrintDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalPrintMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.basic.SPCLCmpnApprovalBC;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.basic.SPCLCmpnApprovalBCImpl;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.event.EsmAcm0031Event;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalPrintDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalPrintMasterVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ACMApproval Business Logic ServiceCommand<br>
 * - OPUS-ACMApproval에 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM YOUNG-OH
 * @see AGNCommApprovalDBDAO
 * @since J2EE 1.6
 */

public class ACMApprovalSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ACMApproval system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ACMApprovalSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ACMApproval system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ACMApprovalSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-ACMApproval system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmAcm0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAGNCommApproval(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAGNCommApprovalDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //Approval Request
				eventResponse = approvalAGNCommApproval(e);
			} else if (e.getFormCommand().isCommand(FormCommand.PRINT)) {
				eventResponse = searchACMCommInfoPrint(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchACMApprovalCommon(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Audit Reject
				eventResponse = approvalAGNCommAuditReject(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReturnCSRMaster(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchReturnCSRDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //Reprocess to Audit Confirm
				eventResponse = reprocessReturnCSRAuditConfirm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { //CSR Cancel
				eventResponse = manageAGNCommCSRCancel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFFCmpnApprovalMaster(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFFCmpnApprovalDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) { //Approval Request
				eventResponse = approvalFFCmpnApproval(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchFFCmpnApprovalExcelDown(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = searchFFCmpnApprovalPrint(e);
			} else if (e.getFormCommand().isCommand(FormCommand.PRINT)) {
				eventResponse = searchFFCmpnApprovalCsrPrint(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSPCLCmpnApprovalMaster(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSPCLCmpnApprovalDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //Approval Request
				eventResponse = approvalSPCLCmpnApproval(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { //Ex.Rate Input
				eventResponse = manageSPCLCmpnApproval(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSPCLCmpnApprovalExcelDown(e);
			} else if (e.getFormCommand().isCommand(FormCommand.PRINT)) {
				eventResponse = searchSPCLCmpnApprovalPrint(e);
			}
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0009] Retrieve<br>
	 * Agent Commission CSR Creation 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGNCommApproval(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0009Event event = (EsmAcm0009Event)e;
		AGNCommApprovalBC command = new AGNCommApprovalBCImpl();

		try{
			List<AGNCommApprovalMasterVO> list = command.searchAGNCommApprovalMaster(event.getAgnCommApprovalMasterVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0009] Retrieve<br>
	 * Agent Commission CSR Creation 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGNCommApprovalDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0009Event event = (EsmAcm0009Event)e;
		AGNCommApprovalBC command = new AGNCommApprovalBCImpl();

		try{
			List<AGNCommApprovalDetailVO> list = command.searchAGNCommApprovalDetail(event.getAgnCommApprovalDetailVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * Agent Commission CSR Creation 목록을 Interface 한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse approvalAGNCommApproval(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0009Event event = (EsmAcm0009Event)e;
		AGNCommApprovalBC command = new AGNCommApprovalBCImpl();

		try{
			begin();
			command.approvalAGNCommApproval(event.getAgnCommApprovalMasterVOs(), event.getAgnCommApprovalMasterVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0009] Retrieve<br>
	 * Agent Commission CSR Creation ESM_ACM_0009 화면에 대한 보고서 출력 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchACMCommInfoPrint(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0009Event event = (EsmAcm0009Event)e;
		AGNCommApprovalBC command = new AGNCommApprovalBCImpl();

		try{
			List<AGNCommInfoPrintMasterVO> list1 = command.searchACMCommInfoPrintMaster(event.getAgnCommInfoPrintMasterVO());
			List<AGNCommInfoPrintDetailVO> list2 = command.searchACMCommInfoPrintDetail(event.getAgnCommInfoPrintDetailVO());
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0009] ASA No, Vendor Retrieve <br>
	 * Agent Commission CSR Creation ESM_ACM_0009 화면에 대한 ASA No, Vendor Code 조회 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchACMApprovalCommon(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0009Event event = (EsmAcm0009Event)e;
		AGNCommApprovalBC command = new AGNCommApprovalBCImpl();
		try{
			List<AGNCommAsaNoVO>  list1 = command.getAsaNoList(event.getAgnCommAsaNoVO());
			eventResponse.setRsVoList(list1);
			List<AGNCommVendorVO> list2 = command.getVendorInfo(event.getAgnCommVendorVO());
			// ETC-DATA로 setting
			eventResponse.setETCData(list2.get(0).getColumnValues());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0013] Retrieve<br>
	 * Returned CSR Master 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReturnCSRMaster(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0013Event event = (EsmAcm0013Event)e;
		AGNCommApprovalBC command = new AGNCommApprovalBCImpl();

		try{
			List<ReturnCSRMasterVO> list = command.searchReturnCSRMaster(event.getReturnCSRMasterVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0013] Retrieve<br>
	 * Returned CSR Detail 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReturnCSRDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0013Event event = (EsmAcm0013Event)e;
		AGNCommApprovalBC command = new AGNCommApprovalBCImpl();

		try{
			List<ReturnCSRDetailVO> list = command.searchReturnCSRDetail(event.getReturnCSRMasterVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0013] Reprocess to Audit Confirm<br>
	 * Returned CSR의 재처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reprocessReturnCSRAuditConfirm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0013Event event = (EsmAcm0013Event)e;
		AGNCommApprovalBC command = new AGNCommApprovalBCImpl();

		try{
			begin();
			List<ReturnCSRDetailVO> list = command.reprocessReturnCSRAuditConfirm(event.getReturnCSRMasterVO(), account);
			eventResponse.setRsVoList(list);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0013] CSR Cancel<br>
	 * Interface Cancel 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAGNCommCSRCancel(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0013Event event = (EsmAcm0013Event)e;
		AGNCommApprovalBC command = new AGNCommApprovalBCImpl();
		
		try{
			begin();
			command.manageAGNCommCSRCancel(event.getReturnCSRMasterVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [ESM_ACM_0030] Retrieve<br>
	 * FF Compensation CSR Creation 목록을 조회(Master)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFFCmpnApprovalMaster(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0030Event event = (EsmAcm0030Event)e;
		FFCmpnApprovalBC command = new FFCmpnApprovalBCImpl();

		try{
			List<FFCmpnApprovalMasterVO> list = command.searchFFCmpnApprovalMaster(event.getFfCmpnApprovalMasterVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0030] Retrieve<br>
	 * FF Compensation CSR Creation 목록을 조회(Detail)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFFCmpnApprovalDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0030Event event = (EsmAcm0030Event)e;
		FFCmpnApprovalBC command = new FFCmpnApprovalBCImpl();

		try{
			List<FFCmpnApprovalDetailVO> list = command.searchFFCmpnApprovalDetail(event.getFfCmpnApprovalDetailVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse approvalFFCmpnApproval(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0030Event event = (EsmAcm0030Event)e;
		FFCmpnApprovalBC command = new FFCmpnApprovalBCImpl();
		String aproStep = "";
		String dateDiv = "";
		String dateFm = "";
		String dateTo = "";
		String invDt = "";
		String ifOpt = "";
		String asaNo = "";
		String blNo = "";

		try{
			FFCmpnApprovalMasterVO[] ffCmpnApprovalMasterVOs = event.getFfCmpnApprovalMasterVOs();
			if(ffCmpnApprovalMasterVOs.length > 0) {
				aproStep = ffCmpnApprovalMasterVOs[0].getAproStep();
				dateDiv = ffCmpnApprovalMasterVOs[0].getDateDiv();
				dateFm = ffCmpnApprovalMasterVOs[0].getDateFm();
				dateTo = ffCmpnApprovalMasterVOs[0].getDateTo();
				invDt = ffCmpnApprovalMasterVOs[0].getInvDt();
				ifOpt = ffCmpnApprovalMasterVOs[0].getIfOpt();
				asaNo = ffCmpnApprovalMasterVOs[0].getAsaNo();
				blNo = ffCmpnApprovalMasterVOs[0].getBlNo();
			}
			for(int i=0; i<ffCmpnApprovalMasterVOs.length; i++) {
				begin();
				ffCmpnApprovalMasterVOs[i].setAproStep(aproStep);
				ffCmpnApprovalMasterVOs[i].setDateDiv(dateDiv);
				ffCmpnApprovalMasterVOs[i].setDateFm(dateFm);
				ffCmpnApprovalMasterVOs[i].setDateTo(dateTo);
				ffCmpnApprovalMasterVOs[i].setInvDt(invDt);
				ffCmpnApprovalMasterVOs[i].setIfOpt(ifOpt);
				ffCmpnApprovalMasterVOs[i].setAsaNo(asaNo);
				ffCmpnApprovalMasterVOs[i].setBlNo(blNo);
				command.approvalFFCmpnApproval(ffCmpnApprovalMasterVOs[i], event.getSignOnUserAccount());
				commit();
			}
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0030] Retrieve<br>
	 * FF Compensation CSR Creation 엑셀다운 목록을 조회(Excel)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFFCmpnApprovalExcelDown(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0030Event event = (EsmAcm0030Event)e;
		FFCmpnApprovalBC command = new FFCmpnApprovalBCImpl();

		try{
			List<FFCmpnApprovalMasterVO> list = command.searchFFCmpnApprovalExcelDown(event.getFfCmpnApprovalMasterVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * [ESM_ACM_0030] Retrieve<br>
	 * FF Compensation CSR Creation RD프린트 목록을 조회(Print)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFFCmpnApprovalPrint(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0030Event event = (EsmAcm0030Event)e;
		FFCmpnApprovalBC command = new FFCmpnApprovalBCImpl();

		try{
			List<FFCmpnApprovalPrintMasterVO> list1 = command.searchFFCmpnApprovalPrint(event.getFfCmpnApprovalPrintMasterVO());
			eventResponse.setRsVoList(list1);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * [ESM_ACM_0030] Retrieve<br>
	 * FF Compensation CSR Creation CSR_RD프린트 목록을 조회(Print)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFFCmpnApprovalCsrPrint(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0030Event event = (EsmAcm0030Event)e;
		FFCmpnApprovalBC command = new FFCmpnApprovalBCImpl();

		try{
			List<FFCmpnApprovalPrintMasterVO> list1 = command.searchFFCmpnApprovalPrintMaster(event.getFfCmpnApprovalPrintMasterVO());
			List<FFCmpnApprovalPrintDetailVO> list2 = command.searchFFCmpnApprovalPrintDetail(event.getFfCmpnApprovalPrintDetailVO());
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0031] Retrieve<br>
	 * Special Compensation CSR Creation 목록을 조회(Master)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSPCLCmpnApprovalMaster(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0031Event event = (EsmAcm0031Event)e;
		SPCLCmpnApprovalBC command = new SPCLCmpnApprovalBCImpl();

		try{
			List<SPCLCmpnApprovalMasterVO> list = command.searchSPCLCmpnApprovalMaster(event.getSpCLCmpnApprovalMasterVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0031] Retrieve<br>
	 * Special Compensation CSR Creation 목록을 조회(Detail)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSPCLCmpnApprovalDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0031Event event = (EsmAcm0031Event)e;
		SPCLCmpnApprovalBC command = new SPCLCmpnApprovalBCImpl();

		try{
			List<SPCLCmpnApprovalDetailVO> list = command.searchSPCLCmpnApprovalDetail(event.getSpCLCmpnApprovalDetailVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse approvalSPCLCmpnApproval(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0031Event event = (EsmAcm0031Event)e;
		SPCLCmpnApprovalBC command = new SPCLCmpnApprovalBCImpl();
		String aproStep = "";
		String invTaxRt = "";

		try{
			SPCLCmpnApprovalMasterVO[] spclCmpnApprovalMasterVOs = event.getSpCLCmpnApprovalMasterVOs();
			if(spclCmpnApprovalMasterVOs.length > 0) {
				aproStep = spclCmpnApprovalMasterVOs[0].getAproStep();
				invTaxRt = spclCmpnApprovalMasterVOs[0].getInvTaxRt();
			}
			for(int i=0; i<spclCmpnApprovalMasterVOs.length; i++) {
				begin();
				spclCmpnApprovalMasterVOs[i].setAproStep(aproStep);
				spclCmpnApprovalMasterVOs[i].setInvTaxRt(invTaxRt);
				command.approvalSPCLCmpnApproval(spclCmpnApprovalMasterVOs[i], event.getSignOnUserAccount());
				commit();
			}
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [ESM_ACM_0031] Ex.Rate Input<br>
	 * CSR 생성 전 Ex.rate 정보를 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSPCLCmpnApproval(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0031Event event = (EsmAcm0031Event)e;
		SPCLCmpnApprovalBC command = new SPCLCmpnApprovalBCImpl();

		try{
			begin();
			command.manageSPCLCmpnApproval(event.getSpCLCmpnApprovalMasterVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}		

	/**
	 * [ESM_ACM_0031] Retrieve<br>
	 * Special Compensation CSR Creation 엑셀다운 목록을 조회(Excel)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSPCLCmpnApprovalExcelDown(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0031Event event = (EsmAcm0031Event)e;
		SPCLCmpnApprovalBC command = new SPCLCmpnApprovalBCImpl();

		try{
			List<SPCLCmpnApprovalMasterVO> list = command.searchSPCLCmpnApprovalExcelDown(event.getSpCLCmpnApprovalMasterVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0031] Retrieve<br>
	 * Special Compensation CSR Creation RD프린트 목록을 조회(Print)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSPCLCmpnApprovalPrint(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0031Event event = (EsmAcm0031Event)e;
		SPCLCmpnApprovalBC command = new SPCLCmpnApprovalBCImpl();

		try{
			List<SPCLCmpnApprovalPrintMasterVO> list1 = command.searchSPCLCmpnApprovalPrintMaster(event.getSpCLCmpnApprovalPrintMasterVO());
			List<SPCLCmpnApprovalPrintDetailVO> list2 = command.searchSPCLCmpnApprovalPrintDetail(event.getSpCLCmpnApprovalPrintDetailVO());
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0009]  Audit Reject<br>
	 * Agent Commission CSR Creation화면의 Audit Reject기능을 수행한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse approvalAGNCommAuditReject(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0009Event event = (EsmAcm0009Event)e;
		AGNCommApprovalBC command = new AGNCommApprovalBCImpl();

		try{
			begin();
			command.approvalAGNCommAuditReject(event.getAgnCommApprovalMasterVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
}