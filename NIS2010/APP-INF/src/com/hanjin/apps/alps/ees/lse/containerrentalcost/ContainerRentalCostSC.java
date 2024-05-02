/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerRentalCostSC.java
*@FileTitle : EQ Receivable Charge Summary By Charge Type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.17 진준성
* 1.0 Creation
* History
* 2011.05.16 나상보 [CHM-201110759-01] Split 02-BKG 이외 모듈에서 INVOICE 로 I/F 하는 로직에 ERP 호출 분리
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.basic.PayableRentalCostBC;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.basic.PayableRentalCostBCImpl;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0007Event;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0007PopEvent;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0008Event;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0011Event;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0012Event;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0060Event;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0098Event;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostAuditVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostCreatVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostInvoiceCreateVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostOperationalInvoiceVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalInvoiceCostVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.ReportSearchPayableVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.basic.ReceivableRentalCostBC;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.basic.ReceivableRentalCostBCImpl;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.event.EesLse0019Event;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.event.EesLse0044Event;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.event.EesLse0045Event;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.event.EesLse0074Event;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration.ReceivableRentalCostDBDAO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableChargeVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceCostVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceInquiryVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReportSearchReceivableVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBC;
import com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBCImpl;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApPayInvDtlVO;
import com.hanjin.syscommon.common.table.ApPayInvVO;
import com.hanjin.syscommon.common.table.LsePayRntlChgCoVO;

/**
 * ALPS-ContainerRentalCost Business Logic ServiceCommand - ALPS-ContainerRentalCost 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Jin Jun Sung
 * @see ReceivableRentalCostDBDAO
 * @since J2EE 1.6
 */

public class ContainerRentalCostSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ContainerRentalCost system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	@Override
	public void doStart() {
		log.debug("ContainerRentalCostSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ContainerRentalCost system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	@Override
	public void doEnd() {
		log.debug("ContainerRentalCostSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ContainerRentalCost system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesLse0074Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceivableRentalReportService(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesLse0060Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPayableRentalReportService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceivableRentalChargeListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = isExecuteReceivableRentalChargeService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//Callback
				eventResponse = searchReceivableRentalChargeInfoService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {//Invoice No 조회
				eventResponse = searchNewReceivableInvoiceNumberService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//Preparation
				eventResponse = createReceivableRentalPreparationListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Charge Creation
				eventResponse = createReceivableChargeCreationListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {//Charge Recreation
				eventResponse = createReceivableChargeRecreationListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {//Invoice Summary 조회
				eventResponse = searchReceivableInvoiceSummaryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {//Invoice Amount 조회
				eventResponse = searchReceivableInvoiceAmountInfoService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {//Invoice Creation
				eventResponse = createReceivableInvoiceCreationListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {//Invoice Confirm
				eventResponse = createReceivableInvoiceConfirmListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {//유효성 검증
				eventResponse = searchReceivableAgreementAvailInfoService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceivableInvoiceCostListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageReceivableInvoiceCostListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceivableInvoiceInquiryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = cancelReceivableInvoiceInquiryListService(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = importPayableLessorInvoiceService(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0098Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPayableLessorInvoiceService(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPayableRentalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = createPayableRentalChargeService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = removePayableRentalChargeService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = searchBakEndJobResultService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = modifyPayableRentalChargeMasterInvoiceNoService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = searchPayableRentalInvoiceCreateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) {
				eventResponse = createPayableRentalInvoiceService(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0007PopEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPayableRentalChargeAuditService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createPayableRentalAuditService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = rejectPayableRentalAuditService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchPayableRentalChargeAuditBackEndService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchBakEndJobResultService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = loadResultPayableRentalChargeAuditBackEndService(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPayableRentalInvoiceService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyPayableRentalChargeService(e);
			}
		} else if ( e.getEventName().equalsIgnoreCase("EesLse0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOperatingPayableRentalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOperatingPayableRentalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = createOperatingPayableRentalInvoiceService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchOperatingBakEndJobResultService(e);
			}
		}

		return eventResponse;
	}
	/**
	 * EES_LSE_0074 : Retrieve<br>
	 * Receivable Invoice 한 결과에 대하여 실적을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceivableRentalReportService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EesLse0074Event event = (EesLse0074Event)e;
			ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();
	
			List<ReportSearchReceivableVO> list = command.searchReceivableRentalReportBasic(event.getReportSearchReceivableVO());
			if ( list.size() > 0 ) {
			    eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0060 : Retrieve<br>
	 * Payable Invoice 한 결과에 대하여 실적을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPayableRentalReportService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EesLse0060Event event = (EesLse0060Event)e;
			PayableRentalCostBC command = new PayableRentalCostBCImpl();
	
			List<ReportSearchPayableVO> list = command.searchPayableRentalReportBasic(event.getReportSearchPayableVO());
			if ( list.size() > 0 ) {
			    eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}	
		return eventResponse;
	}

	/**
	 * EES_LSE_0019 : Open<br>
	 * 입력 월에 대한 Receivable Rental Charge 작업 실행여부를 확인합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse isExecuteReceivableRentalChargeService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EesLse0019Event event = (EesLse0019Event)e;
			ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();
	
			boolean execFlag = command.isExecuteReceivableRentalChargeBasic(event.getSearchParamVO());
			eventResponse.setETCData("exec_flag", execFlag ? "TRUE" : "FALSE");
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0019 : Open<br>
	 * 신규 Receivable Rental Invoice Number를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchNewReceivableInvoiceNumberService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EesLse0019Event event = (EesLse0019Event)e;
			ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();
			String invoiceNo = command.searchNewReceivableInvoiceNumberBasic(event.getQtyYrmon());
	
			if ( invoiceNo != null ) {
				eventResponse.setETCData("invoice_no", invoiceNo);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0019 : AGMT No.(Change)<br>
	 * 입력받은 AGMT No.에 대한 Receivable Charge 허용여부를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceivableAgreementAvailInfoService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EesLse0019Event event = (EesLse0019Event)e;
			ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();
			List<ReceivableChargeVO> list = command.searchReceivableAgreementAvailInfoBasic(event.getAgmtSeq(), event.getQtyYrmon());
	
			if ( list.size() == 1 ) {
				eventResponse.setETCData(list.get(0).getColumnValues());
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0019 : Retrieve<br>
	 * 입력 월에 대한 Receivable Rental Charge 작업 현황목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceivableRentalChargeListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0019Event event = (EesLse0019Event)e;
			ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();
			List<ReceivableChargeVO> list = command.searchReceivableRentalChargeListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0019 : Preparation<br>
	 * 입력 월에 대한 Receivable Rental Preparation 일괄작업을 수행합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createReceivableRentalPreparationListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0019Event event = (EesLse0019Event)e;
		ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();

		try{
			begin();
			command.createReceivableRentalPreparationListBasic(event.getSearchParamVO(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0019 : Charge Creation<br>
	 * 계약번호별 Receivable Rental Charge Creation 일괄작업을 수행합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createReceivableChargeCreationListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0019Event event = (EesLse0019Event)e;
		ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();

		try{
			begin();
			command.manageReceivableChargeCreationListBasic(event.getReceivableChargeVOs(), account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"ReceivableChargeCreationList Create"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0019 : Charge Recreation<br>
	 * 계약번호별 Receivable Rental Charge Recreation 일괄작업을 수행합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createReceivableChargeRecreationListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0019Event event = (EesLse0019Event)e;
		ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();

		try{
			begin();
			command.manageReceivableChargeRecreationListBasic(event.getReceivableChargeVOs(), account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"ReceivableChargeRecreationList Create"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0019 : Callback<br>
	 * Receivable Rental Charge (Re)Creation 처리된 내역을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceivableRentalChargeInfoService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EesLse0019Event event = (EesLse0019Event)e;
			ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();
			List<ReceivableChargeVO> list = command.searchReceivableRentalChargeInfoBasic(event.getSearchParamVO());
	
			if ( list.size() == 1 ) {
				eventResponse.setETCData(list.get(0).getColumnValues());
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0019 : Invoice No(Change)<br>
	 * Receivable Rental Invoice Summary 내역을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceivableInvoiceSummaryListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EesLse0019Event event = (EesLse0019Event)e;
			ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();
			List<ReceivableInvoiceVO> list = command.searchReceivableInvoiceSummaryListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0019 : Invoice Issue Date(Change)<br>
	 * Receivable Rental Invoice Amount 정보를 확인합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceivableInvoiceAmountInfoService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EesLse0019Event event = (EesLse0019Event)e;
			ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();
			List<ReceivableInvoiceVO> list = command.searchReceivableInvoiceAmountInfoBasic(event.getSearchParamVO());
	
			if ( list.size() == 1 ) {
				eventResponse.setETCData(list.get(0).getColumnValues());
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0019 : Invoice Creation<br>
	 * 계약번호별 Receivable Rental Invoice Creation 일괄작업을 수행합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createReceivableInvoiceCreationListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0019Event event = (EesLse0019Event)e;
		ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();

		try{
			begin();
			command.createReceivableInvoiceCreationListBasic(event.getReceivableInvoiceVOs(), event.getSearchParamVO(), account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"ReceivableInvoiceCreationList Create"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0019 : Invoice Confirm<br>
	 * 계약번호별 Receivable Rental Invoice Confirm 일괄작업을 수행합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createReceivableInvoiceConfirmListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0019Event event = (EesLse0019Event)e;
		ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();
		GeneralARInvoiceCreationBC command2	= new  GeneralARInvoiceCreationBCImpl();
		List<ARInterfaceCreationVO> aRInterfaceCreationVOs = null;

		try{
			//01.Account Receivable I/F를 위한 자료변환 작업
			event.getSearchParamVO().setCreUsrId(account.getUsr_id());
			aRInterfaceCreationVOs = command.searchGeneralARInterfaceCreationBasic(event.getSearchParamVO());
			//02.Receivable Rental Invoice Creation AR I/F
			begin();
			aRInterfaceCreationVOs = command2.interfaceGeneralARInvoiceToIF(aRInterfaceCreationVOs);
			commit();
			//03.Receivable Rental Invoice Creation 
			begin();
			String arIfNo = command2.interfaceGeneralARInvoiceToINV(aRInterfaceCreationVOs);
			commit();
			//3.5 ERP I/F 신규 로직 추가			
			String arIfNoArr[] = arIfNo.split("::");			
			if(arIfNoArr[0].equals("S")){
				begin();
				command2.interfaceARInvoiceToERPAR(arIfNoArr[1]);
				commit();
				
				//04.Receivable Rental Invoice Creation 일괄작업
				begin();
				String srcIfSeq = aRInterfaceCreationVOs.get(0).getInvArIfMnVO().getSrcIfSeq();
				String srcIfDt  = aRInterfaceCreationVOs.get(0).getInvArIfMnVO().getSrcIfDt();
				event.getSearchParamVO().setSrcIfSeq(srcIfSeq);
				event.getSearchParamVO().setSrcIfDt(srcIfDt);
				command.createReceivableInvoiceConfirmListBasic(event.getReceivableInvoiceVOs(), event.getSearchParamVO(), account);
				//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"ReceivableInvoiceConfirmList Create"}).getMessage());
				commit();
			}
			eventResponse.setETCData("arIfNo", arIfNo);

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0044 : Retrieve<br>
	 * Receivable Rental Invoice Cost 목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceivableInvoiceCostListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EesLse0044Event event = (EesLse0044Event)e;
			ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();
			List<ReceivableInvoiceCostVO> list = command.searchReceivableInvoiceCostListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0044 : Save<br>
	 * Receivable Rental Invoice Cost 목록을 일괄 저장합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageReceivableInvoiceCostListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0044Event event = (EesLse0044Event)e;
		ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();

		try{
			begin();
			command.manageReceivableInvoiceCostListBasic(event.getReceivableInvoiceCostVOs(), account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"ReceivableInvoiceCostList Manage"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0008 : Save<br>
	 * Payable Rental Lessor Invoice File import 데이터를 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse importPayableLessorInvoiceService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0008Event event = (EesLse0008Event)e;
		PayableRentalCostBC command = new PayableRentalCostBCImpl();

		try{
			begin();
			String[] result = command.importPayableLessorInvoiceBasic(event.getPayableRentalCostVO(), account);
			commit();

			eventResponse.setETCData("result",  result[0]);
			eventResponse.setETCData("agmt_no", result[1]);
			eventResponse.setETCData("ctrt_no", result[2]);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0045 : Retrieve<br>
	 * Receivable Rental Invoice Charge I/F 현황을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceivableInvoiceInquiryListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0045Event event = (EesLse0045Event)e;
			ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();
			List<ReceivableInvoiceInquiryVO> list = command.searchReceivableInvoiceInquiryListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0045 : Cancel<br>
	 * Receivable Rental Invoice Charge I/F 처리내역을 취소합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelReceivableInvoiceInquiryListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0045Event event = (EesLse0045Event)e;
		ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();
		GeneralARInvoiceCreationBC command2	= new  GeneralARInvoiceCreationBCImpl();
		List<ARInterfaceCreationVO> aRInterfaceCreationVOs = null;
		ReceivableInvoiceInquiryVO[] receivableInvoiceInquiryVOs = null;
		String arIfNo ="";
		try{
			receivableInvoiceInquiryVOs = event.getReceivableInvoiceInquiryVOs();

			for(int i = 0; i < receivableInvoiceInquiryVOs.length; i++) {
				if(receivableInvoiceInquiryVOs[i].getBlInvIfFlg().equals("Y")) {//INV_AR_IF 성공자료
					//01.Account Receivable I/F를 위한 자료변환 작업
					receivableInvoiceInquiryVOs[i].setCreUsrId(account.getUsr_id());
					aRInterfaceCreationVOs = command.searchGeneralARInterfaceCancelBasic(receivableInvoiceInquiryVOs[i]);
					//02.Receivable Rental Invoice Cancel AR I/F
					begin();
					aRInterfaceCreationVOs = command2.interfaceGeneralARInvoiceToIF(aRInterfaceCreationVOs);
					commit();
					//03.Receivable Rental Invoice Cancel ERP I/F
					begin();
					 arIfNo = command2.interfaceGeneralARInvoiceToINV(aRInterfaceCreationVOs);
					commit();
					//3.5 ERP I/F 신규 로직 추가			
					String arIfNoArr[] = arIfNo.split("::");			
					if(arIfNoArr[0].equals("S")){
						begin();
						command2.interfaceARInvoiceToERPAR(arIfNoArr[1]);
						commit();
						//04.Receivable Rental Invoice Cancel 일괄작업
						begin();
						command.cancelReceivableInvoiceInquiryBasic(receivableInvoiceInquiryVOs[i], account);
						commit();
					}
				}
				else
				{
					//04.Receivable Rental Invoice Cancel 일괄작업
					begin();
					command.cancelReceivableInvoiceInquiryBasic(receivableInvoiceInquiryVOs[i], account);
					commit();
					arIfNo = "S::";
				}	
			}
			eventResponse.setETCData("arIfNo", arIfNo);
		} catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0008Pop : Agreement No Double Click<br>
	 * Payable Rental Lessor Invoice File import 데이터 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPayableLessorInvoiceService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0098Event event = (EesLse0098Event)e;
			PayableRentalCostBC command = new PayableRentalCostBCImpl();
	
			PayableRentalCostVO vo = command.searchPayableLessorInvoiceBasic(event.getPayableRentalCostVO());
			List<LsePayRntlChgCoVO> list = vo.getLsePayRntlChgCoVOs();
			if ( list.size() > 0 ) {
			    eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0007 : Retreive<br>
	 * Payable Charge Creation 대상 Agreement를 조회.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPayableRentalService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0007Event event = (EesLse0007Event)e;
			PayableRentalCostVO searchVO = event.getPayableRentalCostVO();
			PayableRentalCostBC command = new PayableRentalCostBCImpl();
	
			PayableRentalCostVO payableRentalCostVO = command.searchPayableRentalBasic(searchVO.getChgCostYrmon(), searchVO.getVndrSeq(), searchVO.getLstmCd());
	
			List<PayableRentalCostCreatVO> list = payableRentalCostVO.getPayableRentalCostCreatVOs();
			if ( list.size() > 0 ) {
			    eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * EES_LSE_0007 : Charge Creation Button Click<br>
	 * Payable Rental Charge Creation 생성일괄작업(BackEndJob)을 수행합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createPayableRentalChargeService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0007Event event = (EesLse0007Event)e;
			PayableRentalCostVO vo = event.getPayableRentalCostVO();
			PayableRentalCostBC command = new PayableRentalCostBCImpl();
			eventResponse.setETCData("BackEndJobKey", command.createPayableRentalChargeBasic(vo, account));
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0007 : Charge Delete Button Click<br>
	 * Payable Rental Charge Creation 삭제일괄작업(BackEndJob)을 수행합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removePayableRentalChargeService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0007Event event = (EesLse0007Event)e;
			PayableRentalCostVO vo = event.getPayableRentalCostVO();
			PayableRentalCostBC command = new PayableRentalCostBCImpl();
			eventResponse.setETCData("BackEndJobKey", command.removePayableRentalChargeBasic(vo, account));
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0007 : Charge Creation 또는 Delete Button Click<br>
	 * BackEndJob의 실행결과를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBakEndJobResultService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			PayableRentalCostBC command = new PayableRentalCostBCImpl();
			String status = command.searchBakEndJobResultBasic((String)e.getAttribute("KEY"));
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * EES_LSE_0007 : Sheet Invoice No. OnChange<br>
	 * Charge Creation 데이터의 Invoice No 를 저장한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyPayableRentalChargeMasterInvoiceNoService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0007Event event = (EesLse0007Event)e;
		PayableRentalCostVO vo = event.getPayableRentalCostVO();
		PayableRentalCostBC command = new PayableRentalCostBCImpl();

		try{
			begin();
			command.modifyPayableRentalChargeMasterInvoiceNoBasic(vo, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0007_01 : 화면 Open<br>
	 * Audit 할 대상을 조회.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPayableRentalChargeAuditService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0007PopEvent event = (EesLse0007PopEvent)e;
			PayableRentalCostBC command = new PayableRentalCostBCImpl();
	
			PayableRentalCostVO resultVO = command.searchPayableRentalAuditBasic(event.getPayableRentalCostVO());
	
			List<List<PayableRentalCostAuditVO>> resultVOs = resultVO.getPayableRentalCostAuditVOs();
	
			eventResponse.setRsVoList(resultVOs.get(0));
			eventResponse.setRsVoList(resultVOs.get(1));
			eventResponse.setRsVoList(resultVOs.get(2));
			eventResponse.setRsVoList(resultVOs.get(3));
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0007_01 : Confirm button click<br>
	 * Payable Charge Audit 대상을 Audit 완료로 저장함.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createPayableRentalAuditService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0007PopEvent event = (EesLse0007PopEvent)e;
		PayableRentalCostVO searchVO = event.getPayableRentalCostVO();
		PayableRentalCostBC command = new PayableRentalCostBCImpl();

		try{
			begin();
			command.createPayableRentalAuditBasic(searchVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0007_01 : Reject button click<br>
	 * Payable Charge Audit 대상을 백업하고 Audit 이전으로 저장함.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse rejectPayableRentalAuditService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0007PopEvent event = (EesLse0007PopEvent)e;
		PayableRentalCostVO searchVO = event.getPayableRentalCostVO();
		PayableRentalCostBC command = new PayableRentalCostBCImpl();

		try{
			begin();
			command.rejectPayableRentalAuditBasic(searchVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0007 : Invoice Creation Button Click<br>
	 * Invoice Creation Data 를 CSR Temp Table에 저장한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createPayableRentalInvoiceService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0007Event event = (EesLse0007Event)e;
			PayableRentalCostVO vo = event.getPayableRentalCostVO();
			PayableRentalCostBC command = new PayableRentalCostBCImpl();
			eventResponse.setETCData("BackEndJobKey", command.createPayableRentalInvoiceBasic(vo, account));
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0007 : sheet2 check box click<br>
	 * Audit 완료 된 Charge Creation 데이터를 선택하여 Invoice 생성을 위한 Data 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPayableRentalInvoiceCreateService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0007Event event = (EesLse0007Event)e;
			PayableRentalCostBC command = new PayableRentalCostBCImpl();
	
			PayableRentalCostVO payableRentalCostVO = command.searchPayableRentalInvoiceCreateBasic(event.getPayableRentalCostVO());
	
			List<PayableRentalCostInvoiceCreateVO> list = payableRentalCostVO.getPayableRentalCostInvoiceCreateVOs();
			if ( list.size() > 0 ) {
			    eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0012 : 조회<br>
	 * Rental payable invoice 처리에 대한 진행 상황을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPayableRentalInvoiceService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0012Event event = (EesLse0012Event)e;
			PayableRentalCostBC command = new PayableRentalCostBCImpl();
	
			List<PayableRentalInvoiceCostVO> list = command.searchPayableRentalInvoiceBasic(event.getPayableRentalInvoiceCostVO());
			if ( list.size() > 0 ) {
			    eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0011 : Retreive<br>
	 * Operation lease Invoice Creation 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOperatingPayableRentalService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0011Event event = (EesLse0011Event)e;
			PayableRentalCostBC command = new PayableRentalCostBCImpl();
	
			PayableRentalCostVO resutlVO = command.searchOperatingPayableRentalBasic(event.getVndrSeq(), event.getBilFmDt(), event.getBilToDt());
	
			List<PayableRentalCostOperationalInvoiceVO> list = resutlVO.getPayableRentalCostOperationalInvoiceVOs();
			if ( list.size() > 0 ) {
			    eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0011 : SO Creation<br>
	 * Operation lease Invoice Creation 일괄작업을 수행합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOperatingPayableRentalService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0011Event event = (EesLse0011Event)e;
		PayableRentalCostBC command = new PayableRentalCostBCImpl();

		try{
			begin();
			command.manageOperatingPayableRentalBasic(event.getPayableRentalCostVO(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0011 : Invoice Creation Button Click<br>
	 * Invoice Creation Data 를 CSR Temp Table에 저장한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createOperatingPayableRentalInvoiceService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0011Event event = (EesLse0011Event)e;
			PayableRentalCostVO vo = event.getPayableRentalCostVO();
			PayableRentalCostBC command = new PayableRentalCostBCImpl();
			eventResponse.setETCData("BackEndJobKey", command.createOperatingPayableRentalInvoiceBasic(vo, account));
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0011 : Operating Invoice Creation 버튼 클릭<br>
	 * BackEndJob의 실행결과를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOperatingBakEndJobResultService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0011Event event = (EesLse0011Event)e;
			PayableRentalCostBC command = new PayableRentalCostBCImpl();
	
			String status = command.searchBakEndJobResultBasic((String)event.getAttribute("KEY"));
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EES_LSE_0012 : Save 버튼 클릭<br>
	 * Payable invoice 를 Cancel 처리함  <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyPayableRentalChargeService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0012Event event = (EesLse0012Event)e;
        PayableRentalCostBC command  = new PayableRentalCostBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();
		try{
			begin();
			PayableRentalInvoiceCostVO[] payableRentalInvoiceCostVOS = event.getPayableRentalInvoiceCostVOS();
			for(int i=0; i < payableRentalInvoiceCostVOS.length; i++){
			    ApPayInvVO apPayInvVO = new ApPayInvVO();
			    ApPayInvDtlVO[] apPayInvDtlVOs = new ApPayInvDtlVO[0];

			    apPayInvVO.setUpdUsrId(account.getUsr_id());
			    apPayInvVO.setInvOfcCd(account.getOfc_cd());
			    apPayInvVO.setDeltFlg("Y");
			    apPayInvVO.setInvRgstNo(payableRentalInvoiceCostVOS[i].getIfRgstNo());

			    // CSR 메소드 실행
			    command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
			}
			//LSE Cancel
			command.modifyPayableRentalChargeBasic(payableRentalInvoiceCostVOS);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0007_01 : 화면 Open - BackEndJob<br>
	 * Audit 할 대상을 조회하는 BackEndJob 실행합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPayableRentalChargeAuditBackEndService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0007PopEvent event = (EesLse0007PopEvent)e;
			PayableRentalCostBC command = new PayableRentalCostBCImpl();
			String status = command.searchPayableRentalChargeAuditBackEndBasic(event.getPayableRentalCostVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0007_01 : 화면 Open - BackEndJob<br>
	 * BackEndJob의 실행결과로 생성된 파일을 로드합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse loadResultPayableRentalChargeAuditBackEndService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PayableRentalCostBC command = new PayableRentalCostBCImpl();
		String key = (String)e.getAttribute("KEY");
		List list = null;

		try {
			list = (List<PayableRentalCostAuditVO>)BackEndJobResult.loadFromFile(key);

			PayableRentalCostVO resultVO = command.searchPayableRentalAuditBasic(list);

			List<List<PayableRentalCostAuditVO>> resultVOs = resultVO.getPayableRentalCostAuditVOs();

			eventResponse.setRsVoList(resultVOs.get(0));
			eventResponse.setRsVoList(resultVOs.get(1));
			eventResponse.setRsVoList(resultVOs.get(2));
			eventResponse.setRsVoList(resultVOs.get(3));

			return eventResponse;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
}