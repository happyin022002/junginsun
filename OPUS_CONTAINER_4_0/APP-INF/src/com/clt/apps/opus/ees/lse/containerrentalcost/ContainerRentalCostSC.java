/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerRentalCostSC.java
*@FileTitle : EQ Receivable Charge Summary By Charge Type
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.basic.PayableRentalCostBC;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.basic.PayableRentalCostBCImpl;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0007Event;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0007PopEvent;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0008Event;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0011Event;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0012Event;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0060Event;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0098Event;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostAuditVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostCreatVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostInvoiceCreateVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostOperationalInvoiceVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalInvoiceCostVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.ReportSearchPayableVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.basic.ReceivableRentalCostBC;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.basic.ReceivableRentalCostBCImpl;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.event.EesLse0019Event;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.event.EesLse0044Event;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.event.EesLse0045Event;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.event.EesLse0074Event;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration.ReceivableRentalCostDBDAO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableChargeVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceCostVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceInquiryVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo.ReportSearchReceivableVO;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.basic.LseCommonBC;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.basic.LseCommonBCImpl;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.vo.CdListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBC;
import com.clt.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.LsePayRntlChgCoVO;

/**
 * ContainerRentalCost Business Logic ServiceCommand - handling business transaction ContainerRentalCost
 *
 * @author 
 * @see ReceivableRentalCostDBDAO
 * @since J2EE 1.6
 */ 

public class ContainerRentalCostSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario ContainerRentalCost system <br>
	 * related objects creation<br>
	 */
	@Override
	public void doStart() {
		log.debug("ContainerRentalCostSC start");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * biz scenario closing ContainerRentalCost system<br>
	 * clearing related objects<br>
	 */
	@Override
	public void doEnd() {
		log.debug("ContainerRentalCostSC end");
	}

	/**
	 *
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
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
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {//Invoice No 
				eventResponse = searchNewReceivableInvoiceNumberService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//Preparation
				eventResponse = createReceivableRentalPreparationListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Charge Creation
				eventResponse = createReceivableChargeCreationListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {//Charge Recreation
				eventResponse = createReceivableChargeRecreationListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {//Invoice Summary 
				eventResponse = searchReceivableInvoiceSummaryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {//Invoice Amount 
				eventResponse = searchReceivableInvoiceAmountInfoService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {//Invoice Creation
				eventResponse = createReceivableInvoiceCreationListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {//Invoice Confirm
				eventResponse = createReceivableInvoiceConfirmListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchReceivableAgreementAvailInfoService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = createReceivableInvoiceChargeCreationBatchService(e);
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
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND07)) {
				eventResponse = createPayableRentalChargeCreationBatchService(e);
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
			}else {
				eventResponse = initVndrSeqComboDataService(e);
			}
		}

		return eventResponse;
	}
	/**
	 * EES_LSE_0074 : Retrieve<br>
	 * retrieving for Receivable Invoice<br>
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
	 * retrieving for Payable Invoice <br>
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
	 * checking Receivable Rental Charge execution<br>
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
	 * retrieving for new Receivable Rental Invoice Number<br>
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
	 * retrieving for Receivable Charge avail<br>
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
	 * retrieving for Receivable Rental Charge list<br>
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
	 * creating Receivable Rental Preparation list<br>
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
	 * creating Receivable Rental Charge Creation list<br>
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
	 * creating Receivable Rental Charge Recreation list<br>
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
	 * retrieving for Receivable Rental Charge (Re)Creation <br>
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
	 * retrieving for Receivable Rental Invoice Summary <br>
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
	 * retrieving for Receivable Rental Invoice Amount <br>
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
	 * creating Receivable Rental Invoice Creation by agreement No.<br>
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
	 * creating Receivable Rental Invoice Confirm by agreement No.<br>
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
		//BookingARCreationBC commad3 = new BookingARCreationBCImpl();
		List<ARInterfaceCreationVO> aRInterfaceCreationVOs = null;
	

		try{
			//01.data transforming for Account Receivable I/F
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
				String srcIfSeq = aRInterfaceCreationVOs.get(0).getInvArIfMnVO().getSrcIfSeq();
				String srcIfDt  = aRInterfaceCreationVOs.get(0).getInvArIfMnVO().getSrcIfDt();
				event.getSearchParamVO().setSrcIfSeq(srcIfSeq);
				event.getSearchParamVO().setSrcIfDt(srcIfDt);
				command.createReceivableInvoiceConfirmListBasic(event.getReceivableInvoiceVOs(), event.getSearchParamVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"ReceivableInvoiceConfirmList Create"}).getMessage());
				commit();
			}

			eventResponse.setETCData("arIfNo", arIfNo);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"ReceivableInvoiceConfirmList Create"}).getMessage());
			
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
	 * retrieving for Receivable Rental Invoice Cost<br>
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
	 * saving Receivable Rental Invoice Cost <br>
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
	 * saving Payable Rental Lessor Invoice File import <br>
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
	 * retrieving for Receivable Rental Invoice Charge I/F <br>
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
	 * canceling Receivable Rental Invoice Charge I/F<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelReceivableInvoiceInquiryListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0045Event event = (EesLse0045Event)e;
		ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();
		ReceivableInvoiceInquiryVO[] receivableInvoiceInquiryVOs = null;
		GeneralARInvoiceCreationBC command2	= new  GeneralARInvoiceCreationBCImpl();
		List<ARInterfaceCreationVO> aRInterfaceCreationVOs = null;
	    String arIfNo ="";
	    
		try{
			receivableInvoiceInquiryVOs = event.getReceivableInvoiceInquiryVOs();

			for(int i = 0; i < receivableInvoiceInquiryVOs.length; i++) {
				if(receivableInvoiceInquiryVOs[i].getBlInvIfFlg().equals("Y")) {//INV_AR_IF success
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
					//3.5 ERP I/F new logic Add			
					String arIfNoArr[] = arIfNo.split("::");			
					if(arIfNoArr[0].equals("S")){
						//04.Receivable Rental Invoice Cancel 일괄작업
						begin();
						command.cancelReceivableInvoiceInquiryBasic(receivableInvoiceInquiryVOs[i], account);
						commit();
					
					}
				}
				else
				{

				//04.Receivable Rental Invoice Cancel
				begin();
				command.cancelReceivableInvoiceInquiryBasic(receivableInvoiceInquiryVOs[i], account);
				eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"ReceivableInvoiceInquiryList Cancel"}).getMessage());
				commit();
				}
			}
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
	 * retrieving for Payable Rental Lessor Invoice File import <br>
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
	 * retrieving for Payable Charge Creation target Agreement
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
	
			PayableRentalCostVO payableRentalCostVO = command.searchPayableRentalBasic(searchVO.getChgCostYrmon(), searchVO.getVndrSeq(), searchVO.getLstmCd(), searchVO.getLsePayTpCd());
	
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
	 * creating Payable Rental Charge Creation(BackEndJob)<br>
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
	 * retrieving for Payable Rental Charge Creation (BackEndJob)<br>
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
	 * EES_LSE_0007 : Charge Creation or Delete Button Click<br>
	 * retrieving for BackEndJob result<br>
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
	 * saving Invoice No of Charge Creation data<br>
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
	 * EES_LSE_0007_01 : Open<br>
	 * retrieving for Audit<br>
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
	 * saving Payable Charge Audit to Audit complete
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
	 * back up Payable Charge Audit
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
	 * sanving Invoice Creation Data on CSR Temp Table<br>
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
	 * retrieving for Audit complete Charge Creation data
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
	 * EES_LSE_0012 : retrieving <br>
	 * retrieving for Rental payable invoice <br>
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
	 * retrieving for Operation lease Invoice Creation<br>
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
	
			PayableRentalCostVO resutlVO = command.searchOperatingPayableRentalBasic(event.getVndrSeq(), event.getBilFmDt(), event.getBilToDt(), event.getAgmtSeq());
	
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
	 * saving Operation lease Invoice Creation <br>
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
	 * creating Invoice Creation Data on CSR Temp Table<br>
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
	 * EES_LSE_0011 : Operating Invoice Creation <br>
	 *retrieving for  BackEndJob result<br>
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
	 * EES_LSE_0011 : LP Term Lessor select<br>
	 * retrieving for vendor sequence data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initVndrSeqComboDataService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LseCommonBC command = new LseCommonBCImpl();
		CdListVO vo = new CdListVO();
		List<CdListVO> list = new ArrayList<CdListVO>();

		try{
            //Container Use Company List
            vo.setEdmCd("CD20010");
            list = command.searchVndrSeqListBasic(vo);
            eventResponse.setCustomData("VNDR_SEQ", list);
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
	 * EES_LSE_0012 : Save<br>
	 * modifying Payable invoice to Cancel  <br>
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
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0007_01 : Open - BackEndJob<br>
	 * retrieving for Audit target(BackEndJob)<br>
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
	 * EES_LSE_0007_01 : Open - BackEndJob<br>
	 * loading BackEndJob result file<br>
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
	
	/**
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @throws EventException
	 */
	private EventResponse createPayableRentalChargeCreationBatchService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			EesLse0007Event event = (EesLse0007Event)e; 
			PayableRentalCostBC command = new PayableRentalCostBCImpl();
			
			String strStatus = command.createPayableRentalChargeCreationBatchService(event.getPayableRentalCostVO(), account);	//"[In] yyyymm : String , [in] laneCd : String
			
			eventResponse.setETCData("BackEndJobKey", strStatus);
			
			
			commit();
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
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @throws EventException
	 */
	private EventResponse createReceivableInvoiceChargeCreationBatchService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			begin();
			EesLse0019Event event = (EesLse0019Event)e;
			ReceivableRentalCostBC command = new ReceivableRentalCostBCImpl();
			String qtyYrMon = event.getQtyYrmon();
			
			String strStatus = command.createReceivableInvoiceChargeCreationBatchService(qtyYrMon, account);	 
			
			eventResponse.setETCData("BackEndJobKey", strStatus);
			
			commit();
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}
	
}