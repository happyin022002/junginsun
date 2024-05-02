/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountPayableInvoiceSC.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.03.03 authorName
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice;


import java.util.List;
import java.util.GregorianCalendar;
import com.clt.framework.component.util.JSPUtil;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.basic.AccountPayableCommonBC;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.basic.AccountPayableCommonBCImpl;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic.AccountPayableInvoiceBC;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic.AccountPayableInvoiceBCImpl;
import com.clt.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic.ConsultationSlipRequestMgtBC;
import com.clt.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic.ConsultationSlipRequestMgtBCImpl;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBC;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBCImpl;
import com.clt.apps.opus.stm.sac.costaccrual.costaccrual.basic.CostAccrualBC;
import com.clt.apps.opus.stm.sac.costaccrual.costaccrual.basic.CostAccrualBCImpl;
import com.clt.apps.opus.stm.sap.accountpayablepayment.AccountPayablePaymentSC;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.basic.AccountPayablePaymentBC;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.basic.AccountPayablePaymentBCImpl;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceApprovalListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryLineListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoicePayScheduleListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceReceiptListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipDetailListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipPaymentListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.SapInvoiceInterfaceDetailVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.SapInvoiceInterfaceHeaderVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.UnsettledAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentSettlementInvoiceListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentSettlementApplyListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentSettlementUnapplyListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.AsaInfoVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceAccrualVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.APManualInvoiceAccuralCondVO;

import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LedgerCodeCombinationListVO;

import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event.StmSap0010Event;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event.StmSap0020Event;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event.StmSap0030Event;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event.StmSap0040Event;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event.StmSap0250Event;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event.StmSap0340Event;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event.StmSap0240Event;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event.StmSap0241Event;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event.StmSap0150Event;


/**
 * AccountPayableInvoice Business Logic ServiceCommand 
 * - Handling AccountPayableInvoice Business transaction.
 * 
 * 
 * @author 
 * @see AccountPayableInvoiceDBDAO
 * @since J2EE 1.6
 */ 

public class AccountPayableInvoiceSC extends ServiceCommandSupport {

	private SignOnUserAccount account = null;

	/**
	 * Precede AccountPayableInvoice system <br>
	 *  Create Object when STM_SAP_invoices job call<br>
	 */
	public void doStart() {
		log.debug("AccountPayableInvoiceSC Start");
		try {
			//Checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());

		}
	}

	/**
	 * Follow AccountPayableInvoice system<br>
	 * Release Object when STM_SAP_invoices job end<br>
	 */
	public void doEnd() {
		log.debug("AccountPayableInvoiceSC End");
	}

	/**
	 * proceeding job each Even<br>
	 *  Handling every Event on  AccountPayableInvoice system<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("StmSap0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceEntryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchInvoiceEntryLineList(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchInvoicePayScheduleList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageInvoiceEntryInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageInvoiceCancelInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeInvoiceEntryInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.PRINT)) {
				eventResponse = printInvoiceEntryInfo(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchLineVendorInvoiceNoDupCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchInvoiceStatusCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = searchLineAccountTypeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = searchInvoiceLiabilityAccountCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = searchAccountValiInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) {
				eventResponse = searchVendorValiInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND07)) {
				eventResponse = searchOffValiInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND08)) {
				eventResponse = searchLegrValiInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
				eventResponse = searchAsaValiInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND10)) {
				eventResponse = searchSupplierBankValiInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND11)) {
				eventResponse = searhAsaInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND12)) {
				eventResponse = searchAsaIFTransYN(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND13)) {
				eventResponse = searchInvoiceASACloseStatusCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND14)) {
				eventResponse = searchInvoiceInterfaceToSAKURAStatusCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND15)) {
				eventResponse = searchOfficeRegionEnableVendorCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND16)) {
				eventResponse = searchInvoiceASAPeriodToDateInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND17)) {
				eventResponse = searchLocalCurrencyofPaymnetMethodCheck(e);
			}         
		} else if (e.getEventName().equalsIgnoreCase("StmSap0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceApprovalList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyInvoiceApprovalInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageInvoiceApprovalInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchInvoiceASACloseStatusCheckApprove(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSap0040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceReceiptList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageInvoiceReceiptEntryInfo(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageInvoiceReceiptInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = modifyInvoiceReceiptReleaseInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = manageInvoiceRejectInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchInvoiceASACloseStatusReceiptCheck(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSap0240Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceEntryListPrepay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchInvoiceEntryLineListPrepay(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchInvoicePayScheduleListPrepay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageInvoiceEntryInfoPrepay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageInvoiceCancelInfoPrepay(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeInvoiceEntryInfoPrepay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.PRINT)) {
				eventResponse = printInvoiceEntryInfoPrepay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchLineVendorInvoiceNoDupCheckPrepay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchInvoiceStatusCheckPrepay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = searchLineAccountTypeListPrepay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = searchInvoiceLiabilityAccountCheckPrepay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = searchAccountValiInfoPrepay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) {
				eventResponse = searchVendorValiInfoPrepay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND07)) {
				eventResponse = searchOffValiInfoPrepay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND08)) {
				eventResponse = searchLegrValiInfoPrepay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
				eventResponse = searchAsaValiInfoPrepay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND10)) {
				eventResponse = searchSupplierBankValiInfoPrepay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND11)) {
				eventResponse = searchOfficeRegionEnableVendorPrepayCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND12)) {
				eventResponse = searchLocalCurrencyofPaymnetMethodPrepayCheck(e);
			}     			
		} else if (e.getEventName().equalsIgnoreCase("StmSap0241Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPrepaymentSettlementInvoiceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPrepaymentApplyUnapplyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchPrepayGLDatePeriodInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = managePrepaymentApplyInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = managePrepaymentUnApplyInfo(e);
			}   
		} else if (e.getEventName().equalsIgnoreCase("StmSap0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceSlipList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchInvoiceSlipDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchInvoiceSlipPaymentList(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.PRINT)) {
				eventResponse = printInvoiceEntryInfoSlip(e);
			}   
		   
		} else if (e.getEventName().equalsIgnoreCase("StmSap0340Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {				
				eventResponse = searchUnsettledAccountSummaryExistsCheck(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {				
				eventResponse = selectUnsettledAccountCapturePeriodCheck(e);
			} 		
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchUnsettledAccountList(e);
			} 		
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {				
				eventResponse = manageUnsettledAcctCaptureInfo(e);
			} 		
											
		} else if (e.getEventName().equalsIgnoreCase("StmSap0250Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {				
				eventResponse = manageSapIfValidateImportCheckEvent(e);
			} 		
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {				
				eventResponse = callSAKURAPaymentIF(e);
			} 		
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {				
				eventResponse = callSAKURAInvoiceIF(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {				
				eventResponse = callSAKURAInvoiceInvDateBaseIF(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {				
				eventResponse = callASAInvoiceManualIF(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSap0150Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchInvoiceAccrualList(e);
			} 		
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {	
				eventResponse = manageInvoiceAccrualInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {	
				eventResponse = manageInvoiceAccrualCancelInfo(e);
			}
		}  		  		
	
			return eventResponse;
	}
	

	/**
	 * [STM_SAP_0010] Retrieve<br>
	 * Invoice Header List retrieve<br> * 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	 	
	private EventResponse searchInvoiceEntryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0010Event event = (StmSap0010Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			List<InvoiceEntryListVO> list = command.searchInvoiceEntryList(event.getInvoiceEntryCondVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	

	/**
	 * [STM_SAP_0010] Retrieve<br>
	 * Invoice LINE List retrieve<br> * 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse searchInvoiceEntryLineList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0010Event event = (StmSap0010Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			List<InvoiceEntryLineListVO> list = command.searchInvoiceEntryLineList(event.getInvSeq());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	

	/**
	 * [STM_SAP_0010] Retrieve<br>
	 * Invoice Payments Scheduled List retrieve<br> * 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse searchInvoicePayScheduleList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0010Event event = (StmSap0010Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			List<InvoicePayScheduleListVO> list = command.searchInvoicePayScheduleList(event.getInvSeq());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
		
	/**
	 * [STM_SAP_0010] Save <br>
	 * Invoices save <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse manageInvoiceEntryInfo(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0010Event event = (StmSap0010Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		AccountPayableCommonBC  command2 = new AccountPayableCommonBCImpl();
		
		try{
			begin();
			
			String[] rtnVal = command2.searchOfcCdByUserId(account.getUsr_id(), account.getOfc_cd());
			String ap_ofc_cd = rtnVal[0];
			
			String inv_seq = command.manageInvoiceEntryInfo(event.getInvoiceEntryListVOs(), event.getInvoiceEntryLineListVOs(), event.getInvoicePayScheduleListVOs(), account, ap_ofc_cd);
			eventResponse.setETCData("inv_seq", inv_seq);
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
	 * [STM_SAP_0010] Delete <br>
	 * Invoices delete <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse removeInvoiceEntryInfo(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0010Event event = (StmSap0010Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			begin();
			command.removeInvoiceEntryInfo(event.getInvoiceEntryListVOs(),  account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * [STM_SAP_0010] Print <br>
	 * Invoices print <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse printInvoiceEntryInfo(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0010Event event = (StmSap0010Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			begin();
			String inv_rqst_seq = command.printInvoiceList(event.getInvoicePrintVOs(),  account, "INVOICE");
			eventResponse.setETCData("INV_RQST_SEQ", inv_rqst_seq);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * [STM_SAP_0240] Print <br>
	 * Invoices print <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse printInvoiceEntryInfoPrepay(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0240Event event = (StmSap0240Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			begin();
			String inv_rqst_seq = command.printInvoiceList(event.getInvoicePrintVOs(),  account, "INVOICE");
			eventResponse.setETCData("INV_RQST_SEQ", inv_rqst_seq);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * [STM_SAP_0030] Print <br>
	 * Invoices print <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse printInvoiceEntryInfoSlip(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0030Event event = (StmSap0030Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		
		try{
			begin();
			String inv_rqst_seq = command.printInvoiceList(event.getInvoicePrintVOs(),  account, "SLIP"); 
			eventResponse.setETCData("INV_RQST_SEQ", inv_rqst_seq);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * [STM_SAP_0010] <br>
	 * searchLineVendorInvoiceNoDupCheck (COMMAND01) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLineVendorInvoiceNoDupCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0010Event event = (StmSap0010Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
			
			SapCommonVO rtnVo = command.searchLineVendorInvoiceNoDupCheck(event.getSapCommonVO());
			
			if ( rtnVo != null ) {
				eventResponse.setETCData("dup_flg", rtnVo.getValue1());	 // 'E' is Error (Dup)
				eventResponse.setETCData("dup_msg", rtnVo.getValue2());	
			} else {
				eventResponse.setETCData("dup_flg", "NO_DATA");	
				eventResponse.setETCData("dup_msg", "NO_DATA");
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [STM_SAP_0010] <br>
	 * searchLineVendorInvoiceNoDupCheck (COMMAND02) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceStatusCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0010Event event = (StmSap0010Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			String rtnValue = command.searchInvoiceStatusCheck(event.getInvSeq());

			eventResponse.setETCData("chk_status", rtnValue);		
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * [STM_SAP_0010] <br>
	 * searchLineAccountTypeList (COMMAND03) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLineAccountTypeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0010Event event = (StmSap0010Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			List<SapCommonVO> list = command.searchLineAccountTypeList(event.getSapCommonVO());
			eventResponse.setRsVoList(list);
			
			if ( list != null && list.size() > 0) {
				eventResponse.setETCData("chk_account", list.get(0).getValue0());				
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0010] <br>
	 * searchInvoiceLiabilityAccountCheck (COMMAND04) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceLiabilityAccountCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0010Event event = (StmSap0010Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			List<SapCommonVO> list = command.searchInvoiceLiabilityAccountCheck(event.getSapCommonVO());
			eventResponse.setRsVoList(list);
			
			if ( list != null && list.size() > 0) {

				int idx = 0;
				if ( list.size() == 1 ) {
					idx = 0;
				} else {
					String paramVendor = event.getSapCommonVO().getValue0();
					if ( paramVendor.equals(list.get(0).getValue6())) {
						idx = 0;
					}else {
						idx = 1;
					}					
				}
				
				eventResponse.setETCData("company_code", list.get(idx).getValue0());	
				eventResponse.setETCData("region_code", list.get(idx).getValue1());				
				eventResponse.setETCData("center_code", list.get(idx).getValue2());				
				eventResponse.setETCData("account_code", list.get(idx).getValue3());				
				eventResponse.setETCData("intercompany_code", list.get(idx).getValue4());				
				eventResponse.setETCData("vvd_code", list.get(idx).getValue5());	
				eventResponse.setETCData("cd_cmb_seq", list.get(idx).getValue7());		
				
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0010] Cancel <br>
	 * Invoices save <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse manageInvoiceCancelInfo(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0010Event event = (StmSap0010Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			
			begin();
			command.manageInvoiceCancelInfo(event.getInvoiceEntryListVOs(), account);
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
	 * [STM_SAP_0010] <br>
	 * searchAccountValiInfo (COMMAND05) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccountValiInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0010Event event = (StmSap0010Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			SapCommonVO rtnVo = command.searchAccountValiInfo(event.getSapCommonVO().getValue0());
			
			if ( rtnVo != null ) {
				eventResponse.setETCData("acct_cd", rtnVo.getValue0());	
				eventResponse.setETCData("pnd_tgt_flg", rtnVo.getValue1());	// 미결계정 여부 
				eventResponse.setETCData("acct_eng_nm", rtnVo.getValue2());	
			} else {
				eventResponse.setETCData("acct_cd", "NO_DATA");	
				eventResponse.setETCData("pnd_tgt_flg", "NO_DATA");
				eventResponse.setETCData("acct_eng_nm", "NO_DATA");
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * [STM_SAP_0010] <br>
	 * searchVendorValiInfo (COMMAND06) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorValiInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0010Event event = (StmSap0010Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			SapCommonVO rtnVo = command.searchVendorValiInfo(event.getSapCommonVO().getValue0());
			
			if ( rtnVo != null ) {
				eventResponse.setETCData("vendor_seq", rtnVo.getValue0());	
				eventResponse.setETCData("subs_co_cd", rtnVo.getValue1());		//Vendor's Inter Company		
			} else {
				eventResponse.setETCData("vendor_seq", "NO_DATA");	
				eventResponse.setETCData("subs_co_cd", "NO_DATA");	
			}
	
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * [STM_SAP_0010] <br>
	 * searchOffValiInfo (COMMAND07) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffValiInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0010Event event = (StmSap0010Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			SapCommonVO rtnVo = command.searchOffValiInfo(event.getSapCommonVO().getValue0(), event.getSapCommonVO().getValue1(), account);
			if ( rtnVo != null ) {
				eventResponse.setETCData("ofc_cd", rtnVo.getValue0());		
				eventResponse.setETCData("so_if_cd",  rtnVo.getValue1());		//상계정산대리점인경우 'O'		
				eventResponse.setETCData("ap_ctr_cd",  rtnVo.getValue2());
				eventResponse.setETCData("finc_rgn_cd",  rtnVo.getValue3());
				eventResponse.setETCData("ofc_cnt_cd",  rtnVo.getValue4());
			} else {
				eventResponse.setETCData("ofc_cd", "NO_DATA");		
				eventResponse.setETCData("so_if_cd",  "NO_DATA");	
				eventResponse.setETCData("ap_ctr_cd",  "NO_DATA");	
				eventResponse.setETCData("finc_rgn_cd",  "NO_DATA");
				eventResponse.setETCData("ofc_cnt_cd",  "NO_DATA");
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * [STM_SAP_0010] <br>
	 * searchLegrValiInfo (COMMAND08) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLegrValiInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0010Event event = (StmSap0010Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			List<SapCommonVO> list = command.searchLegrValiInfo(event.getSapCommonVO());
			eventResponse.setRsVoList(list);
		      
			if ( list != null && list.size() > 0) {
				eventResponse.setETCData("cd_cmb_seq", list.get(0).getValue0());			
				eventResponse.setETCData("company_code", list.get(0).getValue1());	
				eventResponse.setETCData("region_code", list.get(0).getValue2());				
				eventResponse.setETCData("center_code", list.get(0).getValue3());				
				eventResponse.setETCData("account_code", list.get(0).getValue4());				
				eventResponse.setETCData("intercompany_code", list.get(0).getValue5());				
				eventResponse.setETCData("vvd_code", list.get(0).getValue6());	
				
			} else {
				eventResponse.setETCData("cd_cmb_seq", "NO_DATA");			
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	/**
	 * [STM_SAP_0010] <br>
	 * searchAsaValiInfo (COMMAND09) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAsaValiInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0010Event event = (StmSap0010Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			SapCommonVO rtnVo = command.searchAsaValiInfo(event.getSapCommonVO().getValue0());
			if ( rtnVo != null ) {
				eventResponse.setETCData("asa_no", rtnVo.getValue0());		
				eventResponse.setETCData("asa_sts_cd",  rtnVo.getValue1());					
			} else {
				eventResponse.setETCData("asa_no", "NO_DATA");		
				eventResponse.setETCData("asa_sts_cd",  "NO_DATA");		
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0010] <br>
	 * searchSupplierBankValiInfo (COMMAND10) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSupplierBankValiInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0010Event event = (StmSap0010Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
			
			SapCommonVO rtnVo = command.searchSupplierBankValiInfo(event.getSapCommonVO());
			
			if ( rtnVo != null ) {
				eventResponse.setETCData("bank_acct_prio_cd", rtnVo.getValue1());	 
				eventResponse.setETCData("bank_acct_seq", rtnVo.getValue2());	
				eventResponse.setETCData("bank_acct_vndr_seq", rtnVo.getValue3());	
			} else {
				eventResponse.setETCData("bank_acct_prio_cd", "NO_DATA");	 
				eventResponse.setETCData("bank_acct_seq", "NO_DATA");	
				eventResponse.setETCData("bank_acct_vndr_seq", "NO_DATA");	
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [STM_SAP_0010] <br>
	 * searhAsaInfoList<br> * 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	 	
	private EventResponse searhAsaInfoList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0010Event event = (StmSap0010Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			String ofc_cd = event.getSapCommonVO().getValue1();
			String inv_seq = event.getSapCommonVO().getValue2();
			String inv_curr_cd = event.getSapCommonVO().getValue3();
			List<AsaInfoVO> list = command.searhAsaInfoList(ofc_cd, inv_seq, inv_curr_cd);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [STM_SAP_0010] COMMAND12 <br>
	 * searchAsaIFTransYN<br> * 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	 	
	private EventResponse searchAsaIFTransYN(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0010Event event = (StmSap0010Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			String inv_seq = event.getInvSeq();
			String trans_yn = command.searchAsaIFTransYN(inv_seq);
			eventResponse.setETCData("TRANS_YN",trans_yn);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [STM_SAP_0010] <br>
	 * searchInvoiceASACloseStatusCheck (COMMAND13) <br>
	 * @author jokyungsam
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceASACloseStatusCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0010Event event = (StmSap0010Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
				
		try {
				
			String asa_yn = command.searchInvoiceASACloseStatusCheck(event.getSapCommonVO());
			eventResponse.setETCData("value0", asa_yn);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0010] <br>
	 * searchInvoiceInterfaceToSAKURAStatusCheck (COMMAND14) <br>
	 * @author jokyungsam
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceInterfaceToSAKURAStatusCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0010Event event = (StmSap0010Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
				
		try {
				
			String sakura_if_yn = command.searchInvoiceInterfaceToSAKURAStatusCheck(event.getSapCommonVO());
			if (sakura_if_yn != null) {
				eventResponse.setETCData("value0", sakura_if_yn);
			} else {
				eventResponse.setETCData("value0", "N");
			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0010] COMMAND15 <br>
	 * searchOfficeRegionEnableVendorCheck<br> * 
	 * @author KSJO
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	 	
	private EventResponse searchOfficeRegionEnableVendorCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0010Event event = (StmSap0010Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			String ofc_cd = event.getSapCommonVO().getValue0();
			String vndr_cd = event.getSapCommonVO().getValue1();

			String enable_flg = command.searchOfficeRegionEnableVendorCheck(ofc_cd, vndr_cd);
			eventResponse.setETCData("enable_flg",enable_flg);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0010] COMMAND17 <br>
	 * searchLocalCurrencyofPaymnetMethodCheck<br> * 
	 * @author KSJO
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	 	
	private EventResponse searchLocalCurrencyofPaymnetMethodCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0010Event event = (StmSap0010Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			String vndr_cd = event.getSapCommonVO().getValue0();
			String inv_curr_cd = event.getSapCommonVO().getValue1();
			String liab_acct_cd = event.getSapCommonVO().getValue2();

			String localCurrency = command.searchInvoiceInterfaceLocalCurrencyofACHPaymentMethodCheck(vndr_cd, inv_curr_cd, liab_acct_cd);
			eventResponse.setETCData("local_currency",localCurrency);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0010] <br>
	 * searchInvoiceASAPeriodToDateInfo (COMMAND16) <br>
	 * @author KSJO
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceASAPeriodToDateInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0010Event event = (StmSap0010Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			SapCommonVO rtnVo = command.searchInvoiceASAPeriodToDateInfo(event.getSapCommonVO().getValue0());
			if ( rtnVo != null ) {
				eventResponse.setETCData("asa_to_date", rtnVo.getValue0());		
			} else {
				eventResponse.setETCData("asa_to_date", "NO_DATA");		
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0240] COMMAND11 <br>
	 * searchOfficeRegionEnableVendorPrepayCheck<br> * 
	 * @author KSJO
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	 	
	private EventResponse searchOfficeRegionEnableVendorPrepayCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0240Event event = (StmSap0240Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			String ofc_cd = event.getSapCommonVO().getValue0();
			String vndr_cd = event.getSapCommonVO().getValue1();

			String enable_flg = command.searchOfficeRegionEnableVendorPrepayCheck(ofc_cd, vndr_cd);
			eventResponse.setETCData("enable_flg",enable_flg);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0240] COMMAND12 <br>
	 * searchLocalCurrencyofPaymnetMethodPrepayCheck<br> * 
	 * @author KSJO
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	 	
	private EventResponse searchLocalCurrencyofPaymnetMethodPrepayCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0240Event event = (StmSap0240Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			String vndr_cd = event.getSapCommonVO().getValue0();
			String inv_curr_cd = event.getSapCommonVO().getValue1();
			String liab_acct_cd = event.getSapCommonVO().getValue2();

			String localCurrency = command.searchInvoiceInterfaceLocalCurrencyofACHPaymentMethodCheck(vndr_cd, inv_curr_cd, liab_acct_cd);
			eventResponse.setETCData("local_currency",localCurrency);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0240] Retrieve<br>
	 * Invoice Header List retrieve<br> * 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	 	
	private EventResponse searchInvoiceEntryListPrepay(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0240Event event = (StmSap0240Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			List<InvoiceEntryListVO> list = command.searchInvoiceEntryList(event.getInvoiceEntryCondVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	

	/**
	 * [STM_SAP_0240] Retrieve<br>
	 * Invoice LINE List retrieve<br> * 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse searchInvoiceEntryLineListPrepay(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0240Event event = (StmSap0240Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			List<InvoiceEntryLineListVO> list = command.searchInvoiceEntryLineList(event.getInvSeq());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	

	/**
	 * [STM_SAP_0240] Retrieve<br>
	 * Invoice Payments Scheduled List retrieve<br> * 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse searchInvoicePayScheduleListPrepay(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0240Event event = (StmSap0240Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			List<InvoicePayScheduleListVO> list = command.searchInvoicePayScheduleList(event.getInvSeq());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
		
	/**
	 * [STM_SAP_0240] Save <br>
	 * Invoices save <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse manageInvoiceEntryInfoPrepay(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0240Event event = (StmSap0240Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		AccountPayableCommonBC  command2 = new AccountPayableCommonBCImpl();
		
		try{
			begin();
			
			String[] rtnVal = command2.searchOfcCdByUserId(account.getUsr_id(), account.getOfc_cd());
			String ap_ofc_cd = rtnVal[0];
			
			String inv_seq = command.manageInvoiceEntryInfo(event.getInvoiceEntryListVOs(), event.getInvoiceEntryLineListVOs(), event.getInvoicePayScheduleListVOs(), account, ap_ofc_cd);
			eventResponse.setETCData("inv_seq", inv_seq);
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
	 * [STM_SAP_0240] Delete <br>
	 * Invoices delete <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse removeInvoiceEntryInfoPrepay(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0240Event event = (StmSap0240Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			begin();
			command.removeInvoiceEntryInfo(event.getInvoiceEntryListVOs(),  account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * [STM_SAP_0240] <br>
	 * searchLineVendorInvoiceNoDupCheck (COMMAND01) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLineVendorInvoiceNoDupCheckPrepay(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0240Event event = (StmSap0240Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
			
			SapCommonVO rtnVo = command.searchLineVendorInvoiceNoDupCheck(event.getSapCommonVO());
			
			if ( rtnVo != null ) {
				eventResponse.setETCData("dup_flg", rtnVo.getValue0());	 // 'E' is Error (Dup)
				eventResponse.setETCData("dup_msg", rtnVo.getValue1());	
			} else {
				eventResponse.setETCData("dup_flg", "NO_DATA");	
				eventResponse.setETCData("dup_msg", "NO_DATA");
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [STM_SAP_0240] <br>
	 * searchLineVendorInvoiceNoDupCheck (COMMAND02) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceStatusCheckPrepay(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0240Event event = (StmSap0240Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			String rtnValue = command.searchInvoiceStatusCheck(event.getInvSeq());

			eventResponse.setETCData("chk_status", rtnValue);		
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * [STM_SAP_0240] <br>
	 * searchLineAccountTypeList (COMMAND03) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLineAccountTypeListPrepay(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0240Event event = (StmSap0240Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			List<SapCommonVO> list = command.searchLineAccountTypeList(event.getSapCommonVO());
			eventResponse.setRsVoList(list);
			
			if ( list != null && list.size() > 0) {
				eventResponse.setETCData("chk_account", list.get(0).getValue0());				
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0240] <br>
	 * searchInvoiceLiabilityAccountCheck (COMMAND04) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceLiabilityAccountCheckPrepay(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0240Event event = (StmSap0240Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			List<SapCommonVO> list = command.searchInvoiceLiabilityAccountCheck(event.getSapCommonVO());
			eventResponse.setRsVoList(list);
			
			if ( list != null && list.size() > 0) {

				int idx = 0;
				if ( list.size() == 1 ) {
					idx = 0;
				} else {
					String paramVendor = event.getSapCommonVO().getValue0();
					if ( paramVendor.equals(list.get(0).getValue6())) {
						idx = 0;
					}else {
						idx = 1;
					}					
				}
				
				eventResponse.setETCData("company_code", list.get(idx).getValue0());	
				eventResponse.setETCData("region_code", list.get(idx).getValue1());				
				eventResponse.setETCData("center_code", list.get(idx).getValue2());				
				eventResponse.setETCData("account_code", list.get(idx).getValue3());				
				eventResponse.setETCData("intercompany_code", list.get(idx).getValue4());				
				eventResponse.setETCData("vvd_code", list.get(idx).getValue5());	
				eventResponse.setETCData("cd_cmb_seq", list.get(idx).getValue7());		
				
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0240] Cancel <br>
	 * Invoices save <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse manageInvoiceCancelInfoPrepay(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0240Event event = (StmSap0240Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			
			begin();
			command.manageInvoiceCancelInfo(event.getInvoiceEntryListVOs(), account);
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
	 * [STM_SAP_0240] <br>
	 * searchAccountValiInfo (COMMAND05) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccountValiInfoPrepay(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0240Event event = (StmSap0240Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			SapCommonVO rtnVo = command.searchAccountValiInfo(event.getSapCommonVO().getValue0());
			
			if ( rtnVo != null ) {
				eventResponse.setETCData("acct_cd", rtnVo.getValue0());	
				eventResponse.setETCData("pnd_tgt_flg", rtnVo.getValue1());	// 미결계정 여부 
				eventResponse.setETCData("acct_eng_nm", rtnVo.getValue2());	
			} else {
				eventResponse.setETCData("acct_cd", "NO_DATA");	
				eventResponse.setETCData("pnd_tgt_flg", "NO_DATA");
				eventResponse.setETCData("acct_eng_nm", "NO_DATA");
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * [STM_SAP_0240] <br>
	 * searchAccountValiInfo (COMMAND06) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorValiInfoPrepay(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0240Event event = (StmSap0240Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			SapCommonVO rtnVo = command.searchVendorValiInfo(event.getSapCommonVO().getValue0());
			
			if ( rtnVo != null ) {
				eventResponse.setETCData("vendor_seq", rtnVo.getValue0());	
				eventResponse.setETCData("subs_co_cd", rtnVo.getValue1());		//Vendor's Inter Company		
			} else {
				eventResponse.setETCData("vendor_seq", "NO_DATA");	
				eventResponse.setETCData("subs_co_cd", "NO_DATA");	
			}
	
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * [STM_SAP_0240] <br>
	 * searchOffValiInfoPrepay (COMMAND07) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffValiInfoPrepay(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0240Event event = (StmSap0240Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			SapCommonVO rtnVo = command.searchOffValiInfo(event.getSapCommonVO().getValue0(), event.getSapCommonVO().getValue1(), account);
			if ( rtnVo != null ) {
				eventResponse.setETCData("ofc_cd", rtnVo.getValue0());		
				eventResponse.setETCData("so_if_cd",  rtnVo.getValue1());		//상계정산대리점인경우 'O'		
				eventResponse.setETCData("ap_ctr_cd",  rtnVo.getValue2());
				eventResponse.setETCData("finc_rgn_cd",  rtnVo.getValue3());
				eventResponse.setETCData("ofc_cnt_cd",  rtnVo.getValue4());
			} else {
				eventResponse.setETCData("ofc_cd", "NO_DATA");		
				eventResponse.setETCData("so_if_cd",  "NO_DATA");	
				eventResponse.setETCData("ap_ctr_cd",  "NO_DATA");	
				eventResponse.setETCData("finc_rgn_cd",  "NO_DATA");	
				eventResponse.setETCData("ofc_cnt_cd",  "NO_DATA");
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	
	
	/**
	 * [STM_SAP_0240] <br>
	 * searchLegrValiInfoPrepay (COMMAND08) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLegrValiInfoPrepay(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0240Event event = (StmSap0240Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			List<SapCommonVO> list = command.searchLegrValiInfo(event.getSapCommonVO());
			eventResponse.setRsVoList(list);
		      
			if ( list != null && list.size() > 0) {
				eventResponse.setETCData("cd_cmb_seq", list.get(0).getValue0());			
				eventResponse.setETCData("company_code", list.get(0).getValue1());	
				eventResponse.setETCData("region_code", list.get(0).getValue2());				
				eventResponse.setETCData("center_code", list.get(0).getValue3());				
				eventResponse.setETCData("account_code", list.get(0).getValue4());				
				eventResponse.setETCData("intercompany_code", list.get(0).getValue5());				
				eventResponse.setETCData("vvd_code", list.get(0).getValue6());	
				
			} else {
				eventResponse.setETCData("cd_cmb_seq", "NO_DATA");			
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	/**
	 * [STM_SAP_0240] <br>
	 * searchAsaValiInfoPrepay (COMMAND09) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAsaValiInfoPrepay(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0240Event event = (StmSap0240Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			SapCommonVO rtnVo = command.searchAsaValiInfo(event.getSapCommonVO().getValue0());
			if ( rtnVo != null ) {
				eventResponse.setETCData("asa_no", rtnVo.getValue0());		
				eventResponse.setETCData("asa_sts_cd",  rtnVo.getValue1());					
			} else {
				eventResponse.setETCData("asa_no", "NO_DATA");		
				eventResponse.setETCData("asa_sts_cd",  "NO_DATA");		
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0240] <br>
	 * searchSupplierBankValiInfo (COMMAND10) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSupplierBankValiInfoPrepay(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0240Event event = (StmSap0240Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		try {
			
			SapCommonVO rtnVo = command.searchSupplierBankValiInfo(event.getSapCommonVO());
			
			if ( rtnVo != null ) {
				eventResponse.setETCData("bank_acct_prio_cd", rtnVo.getValue1());	 
				eventResponse.setETCData("bank_acct_seq", rtnVo.getValue2());	
				eventResponse.setETCData("bank_acct_vndr_seq", rtnVo.getValue3());	
			} else {
				eventResponse.setETCData("bank_acct_prio_cd", "NO_DATA");	 
				eventResponse.setETCData("bank_acct_seq", "NO_DATA");	
				eventResponse.setETCData("bank_acct_vndr_seq", "NO_DATA");	
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * [STM_SAP_0241] <br>
	 * Prepayment Apply-Unapply Invoices - Header Info Retrieve <br> * 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	 	
	private EventResponse searchPrepaymentSettlementInvoiceList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0241Event event = (StmSap0241Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			List<PrepaymentSettlementInvoiceListVO> list = command.searchPrepaymentSettlementInvoiceList(event.getInvSeq());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}		

	/**
	 * [STM_SAP_0241] <br>
	 * Prepayment Apply-Unapply Invoices - Apply, Unapply Info Retrieve <br> * 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	 	
	private EventResponse searchPrepaymentApplyUnapplyList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0241Event event = (StmSap0241Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			List<PrepaymentSettlementApplyListVO> list1 = command.searchPrepaymentSettlementApplyList(event.getPrepaymentSettlementInvoiceListVO());
			List<PrepaymentSettlementUnapplyListVO> list2 = command.searchPrepaymentSettlementUnapplyList(event.getPrepaymentSettlementInvoiceListVO());
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
	 * [STM_SAP_0241] <br>
	 * searchPrepayGLDatePeriodInfo <br> * 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	 	
	private EventResponse searchPrepayGLDatePeriodInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0241Event event = (StmSap0241Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		AccountPayableCommonBC  command2 = new AccountPayableCommonBCImpl();
		
		try{
			String arg_gl_dt = event.getSapCommonVO().getValue0();
			String arg_ofc_cd = event.getSapCommonVO().getValue1();
			
			String chk_prd = command2.searchGLDatePeriodCheck(arg_gl_dt, arg_ofc_cd);
			String gl_dt;
			
			if (chk_prd != null && chk_prd.equals("O")) {
				gl_dt = arg_gl_dt;				
			} else {
				gl_dt = command.searchPrepayGLDatePeriodInfo(arg_gl_dt, arg_ofc_cd);
			}
			if (gl_dt != null && !gl_dt.equals("")) {
				eventResponse.setETCData("gl_dt", gl_dt);	 
			} else {
				eventResponse.setETCData("gl_dt", "NO_DATA");	 
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [STM_SAP_0241] Apply <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse managePrepaymentApplyInfo(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0241Event event = (StmSap0241Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			begin();
			String inv_seq = command.managePrepaymentApplyInfo(event.getPrepaymentSettlementInvoiceListVO(), event.getPrepaymentSettlementApplyListVOs(), account);
			eventResponse.setETCData("inv_seq", inv_seq);
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
	 * [STM_SAP_0241] Unapply <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse managePrepaymentUnApplyInfo(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0241Event event = (StmSap0241Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			begin();
			String inv_seq = command.managePrepaymentUnApplyInfo(event.getPrepaymentSettlementInvoiceListVO(), event.getPrepaymentSettlementUnapplyListVOs(), account);
			eventResponse.setETCData("inv_seq", inv_seq);
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
     * [STM_SAP_0020]
     * Unsettled Summary List -  retrieve<br> 
	 * @author JBLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
    private EventResponse searchInvoiceApprovalList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0020Event event = (StmSap0020Event) e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		
		try {
			List<InvoiceApprovalListVO> list = command.searchInvoiceApprovalList(event.getOfcCd(), event.getVndrNo(), event.getCreDt(), event.getInvNo());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
	 * [STM_SAP_0020]
	 * Invoice Approval List -  retrieve<br> 
	 * @author JBLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
	private EventResponse modifyInvoiceApprovalInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0020Event event = (StmSap0020Event) e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		
		try {
			 begin();
			 command.modifyInvoiceApprovalInfo(event.getInvoiceApprovalInfoListVOs(), event.getLginUsrApOfc(), account);
			 eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			 commit();
		} catch (EventException ex) {
			rollback(); //2016.05.23 Adding
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback(); //2016.05.23 Adding
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}    
	
   
	
    /**
	 * [STM_SAP_0020]
	 * Invoice Cancel<br> 
	 * @author JBLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
	private EventResponse manageInvoiceApprovalInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0020Event event = (StmSap0020Event) e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		try {
			 begin();
			 command.manageInvoiceApprovalInfo(event.getInvoiceEntryListVOs(), account.getUsr_id());
			 eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			 commit();
		} catch (EventException ex) {
			rollback(); //2016.05.23 Adding
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback(); //2016.05.23 Adding
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0020] <br>
	 * searchInvoiceASACloseStatusCheckApprove (COMMAND01) <br>
	 * @author jokyungsam
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceASACloseStatusCheckApprove(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0020Event event = (StmSap0020Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
				
		try {
				
			String asa_yn = command.searchInvoiceASACloseStatusCheck(event.getSapCommonVO());
			eventResponse.setETCData("value0", asa_yn);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0040]
	 * CSR Receipt Entry - retrieve<br> 
	 * @author JBLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
    private EventResponse searchInvoiceReceiptList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0040Event event = (StmSap0040Event) e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		
		try {
			List<InvoiceReceiptListVO> list = command.searchInvoiceReceiptList(event.getInvoiceReceiptCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
    
    /**
	 * [STM_SAP_0040]
	 * CSR Receipt Entry - Confirm<br> 
	 * @author JBLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
	private EventResponse manageInvoiceReceiptInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0040Event event = (StmSap0040Event) e;
		AccountPayableInvoiceBC command1 = new AccountPayableInvoiceBCImpl();
		AccountPayableCommonBC  command2 = new AccountPayableCommonBCImpl();
		
		String loclTm = "";
		try {
			 begin();
			 //AP Office Local Time
			 loclTm = command2.searchLocalTime(account.getUsr_id(), account.getOfc_cd());

			 command1.manageInvoiceReceiptInfo(event.getInvoiceReceiptListVOs(), event.getLginUsrApOfc(), loclTm, account.getUsr_id());
			 eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			 commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
	 * [STM_SAP_0040]
	 * CSR Receipt Entry - Reject<br> 
	 * @author JBLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
	private EventResponse manageInvoiceRejectInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0040Event event = (StmSap0040Event) e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		AccountPayablePaymentSC paySC = new AccountPayablePaymentSC();
		
		try {
			 begin();
			 command.manageInvoiceApprovalInfo(event.getInvoiceEntryListVOs(), account.getUsr_id());
			 for (int i=0; i<event.getInvoiceEntryListVOs().length; i++) { 	
				 paySC.manageSOInterface(event.getInvoiceEntryListVOs()[i].getInvNo(), "J");
			 }
			 
			 eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			 commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0040] <br>
	 * searchInvoiceASACloseStatusReceiptCheck (COMMAND01) <br>
	 * @author jokyungsam
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceASACloseStatusReceiptCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0040Event event = (StmSap0040Event) e;
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
				
		try {
				
			String asa_yn = command.searchInvoiceASACloseStatusCheck(event.getSapCommonVO());
			eventResponse.setETCData("value0", asa_yn);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
	 * [STM_SAP_0040]
	 * CSR Receipt Entry - Release<br> 
	 * @author JBLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
	private EventResponse modifyInvoiceReceiptReleaseInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0040Event event = (StmSap0040Event) e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		try {
			 begin();
			 command.modifyInvoiceReceiptReleaseInfo(event.getInvoiceReceiptListVOs(), account.getUsr_id());
			 eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			 commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
	 * [STM_SAP_0040]
	 * CSR Receipt Entry - save<br> 
	 * @author JBLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
	private EventResponse manageInvoiceReceiptEntryInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0040Event event = (StmSap0040Event) e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		try {
			 begin();
			 command.manageInvoiceReceiptEntryInfo(event.getInvoiceReceiptListVOs(), account.getUsr_id());
			 eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			 commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [STM_SAP_0030]
	 * Invoice Slip - Invoice Header Retrieve<br>
	 * @author Hannah Lee
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceSlipList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0030Event event = (StmSap0030Event) e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		
		try{
			List<InvoiceSlipListVO> list = command.searchInvoiceSlipList(event.getInvoiceSlipCondVO(), account);
			
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
				
	}
	
	/**
	 * [STM_SAP_0030]
   	 *  Invoice Slip - Invoice Line (TAB) Retrieve<br>
	 * @author Hannah Lee
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceSlipDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0030Event event = (StmSap0030Event) e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		
		try{
			List<InvoiceSlipDetailListVO> list = command.searchInvoiceSlipDetailList(event.getInvSeq(), event.getInvCurrCd());
			
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
				
	}
	
	/**
	 * [STM_SAP_0030]
	 *  Invoice Slip - Invoice Payment (TAB) Retrieve<br>
	 *
	 * @author Hannah Lee
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceSlipPaymentList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0030Event event = (StmSap0030Event) e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		
		try{
			List<InvoiceSlipPaymentListVO> list = command.searchInvoiceSlipPaymentList(event.getInvSeq());
			
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
				
	}


	/**
	 * [STM_SAP_0340] <br>
	 * Unsettled Summary에  전월 미결 자료 내역이 존재 여부 체크 <br>
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnsettledAccountSummaryExistsCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0340Event event = (StmSap0340Event) e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		
		try {			
			SapCommonVO rtnVo = command.searchUnsettledAccountSummaryExistsCheck(event.getSapCommonVO().getValue0());			
			if ( rtnVo != null ) {
				eventResponse.setETCData("value0", rtnVo.getValue0());	
			} else {
				eventResponse.setETCData("value0", "NO_DATA");	
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [STM_SAP_0340] <br>
	 * Capture 처리할 대상월의 Period가 닫혀 있는지를 확인 체크<br>
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse selectUnsettledAccountCapturePeriodCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0340Event event = (StmSap0340Event) e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		
		try {			
			SapCommonVO rtnVo = command.selectUnsettledAccountCapturePeriodCheck(event.getSapCommonVO().getValue0());			
			if ( rtnVo != null ) {
				eventResponse.setETCData("value0", rtnVo.getValue0());	
			} else {
				eventResponse.setETCData("value0", "NO_DATA");	
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	

	/**
	 * [STM_SAP_0340]
	 * Unsettled Report By Account -  retrieve<br> 
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
	private EventResponse searchUnsettledAccountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0340Event event = (StmSap0340Event) e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		
		try {
			List<UnsettledAccountListVO> list = command.searchUnsettledAccountList(event.getUnsettledEntryCondVO(), account);	
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
    /**
	 * [STM_SAP_0340]
	 * Unsettled Report By Account - capture<br> 
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
	private EventResponse manageUnsettledAcctCaptureInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0340Event event = (StmSap0340Event) e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		try {
			 begin();
			 command.manageUnsettledAcctCaptureInfo(event.getUnsettledEntryCondVO().getUnstlYrmon(), account.getUsr_id());
			 eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			 commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}

    /**
	 * [STM_SAP_0250]
	 * Open Interface Invoices<br> 
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
	private EventResponse manageSapIfValidateImportCheckEvent(Event e) throws EventException {		
		StmSap0250Event event = (StmSap0250Event) e;
		EventResponse apEventResponse = new GeneralEventResponse();

		String ifSourceType 	= event.getSapCommonVO().getValue0();
		String csrNo 			= event.getSapCommonVO().getValue1();		
		String usrId            = account.getUsr_id();

		
		//begin();
		// 자바에서는 manageSapIfValidateImportCheck 를 직접 호출
		apEventResponse = manageSapIfValidateImportCheck(ifSourceType, csrNo, usrId);
		//commit();
		
		//eventResponse.setETCData("SUCCESS_FLG", flag);  
	    //eventResponse.setETCData("RESULT_MSG", msg);
		
		/*Map<String, String> mapVO = new HashMap<String, String>();
		mapVO = apEventResponse.getETCData();
		String success_flg = mapVO.get("SUCCESS_FLG");
		String result_msg = mapVO.get("RESULT_MSG");
		
		log.debug("success_flg:::::" + success_flg);
		log.debug("result_msg:::::" + result_msg);
		*/

		
		return apEventResponse;
	}
	
    /**
	 * [STM_SAP_0250]
	 * Open Interface Invoices<br> 
	 * @author sangyoung cha
	 * @param String ifSourceType
	 * @param String csrNo
	 * @param String usrId
	 * @return EventResponse
	 * @exception EventException
    */
	public EventResponse manageSapIfValidateImportCheck(String ifSourceType, String csrNo, String usrId) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		AccountPayableInvoiceBC apCommand = new AccountPayableInvoiceBCImpl();
		ConsultationSlipRequestMgtBC csrCommand = new ConsultationSlipRequestMgtBCImpl();
		StatementCommonBC scoCommand = new StatementCommonBCImpl();
		AccountPayablePaymentBC payCommand = new AccountPayablePaymentBCImpl();
		
		String strResultMsg = "";
		String strResultFlag = "FAIL";
		String strASAClearAcct = "NODATA";
		
		String transactionFlag = "ONE";
		
		if ("S/O_BIZ".equals(ifSourceType)) {
			ifSourceType = "S/O";
			transactionFlag = "ONE";
		} else if ("A/P".equals(ifSourceType)) {
			transactionFlag = "ONE";
		} else {
			transactionFlag = "TWO";
		}
		
		try {
			if (!"ONE".equals(transactionFlag)) {
				 begin();
			 }
			 
			 SapInvoiceInterfaceHeaderVO headerVo 		= null;			 
			 List<SapInvoiceInterfaceDetailVO> lineVo 	= null;			 		 				 
			 		
			 //I/F대상 테이블의 Header 내역을 VO로 생성 처리
			 if(ifSourceType.equals("A/P")) {
				 headerVo = apCommand.searchSapInvoiceInterfaceHeader(csrNo);
			 }
			 else if(ifSourceType.equals("S/O")) {
				 String ifRequestSeq = apCommand.searchInvoiceInterfaceReqNumCheck(); //Interface Request 에 대한 Sequence Value 임시 변수에 저장
				 headerVo = apCommand.searchSoInvoiceInterfaceHeader(csrNo, ifRequestSeq);
			 }
			if(headerVo == null) {
				 strResultMsg = new ErrorHandler("BKG95017", new String[]{"interface"}).getUserMessage();
				 eventResponse.setUserMessage(strResultMsg); //There is no data to $s. Please check again.
				 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				 return eventResponse;
			}
				 				 
			  
			 //if_source_type = 'S/O' 인 경우에만 해당 Detail 내역을 Summary하여 AP 본 테이블에 넣어야 하기 때문에 Summary 조건에 맞게 자료 처리 여부를 검증하여 만약 조건별로 안되어 있는 경우 에러 처리하고 종료
			 if(ifSourceType.equals("S/O")) {
				 
				 headerVo.setAttrCtnt15("Y"); //..
				 
				 // erp line number 중복 여부
				 String errorCnt = apCommand.searchInvoiceLineNumDupCheck(csrNo);	
				 
				 if(errorCnt!=null && !errorCnt.equals("")) {
					 strResultMsg = new ErrorHandler("SAP00006", new String[]{}).getUserMessage(); //Duplicate Line Number per Account Segments!
					 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					 return eventResponse;
				 }
			 }
			 
			 //I/F대상 테이블의 Detail(Line) 내역을 VO로 생성 처리
			 if(ifSourceType.equals("A/P")) {
				 lineVo = apCommand.searchSapInvoiceInterfaceDetail(csrNo);
			 }
			 else if(ifSourceType.equals("S/O")) {
				 lineVo = apCommand.searchSoInvoiceInterfaceDetail(csrNo, headerVo.getInvIfSeq());
			 }			 
			 
			 
			 String invSumAmt = "";
			 if(ifSourceType.equals("A/P")) {
				 invSumAmt = JSPUtil.getNull(apCommand.searchInvoiceInterfaceDetailApIfSumAmtCheck(csrNo)) ; //Line의 합계 금액을 가져온다.	
			 }
			 else if(ifSourceType.equals("S/O")) {
				 invSumAmt = JSPUtil.getNull(apCommand.searchInvoiceInterfaceDetailSumAmtCheck(csrNo)) ; //Line의 합계 금액을 가져온다.			 			 			 
			 }
			 
			 //Header의 금액와 Line의 합계 금액 일치 여부 검증				 
			 if(!JSPUtil.getNull(headerVo.getInvAmt()).equals(invSumAmt)) {	
				 strResultMsg = new ErrorHandler("SAP00007", new String[]{}).getUserMessage(); //Difference between CSR Amount and Sum of Line Amount!
				 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				 return eventResponse;
			 }
			 
			//Header의 Invoice date 오루 검증				 
			if(!isValidDate(headerVo.getInvDt()))  {	
				 strResultMsg = new ErrorHandler("COM12241", new String[]{"Invoice date:(" + headerVo.getInvDt() + ")" }).getUserMessage(); //($s) is invalid.
				 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				 return eventResponse;
			}
			
			//Header의 GL date 오루 검증				 
			if(!isValidDate(headerVo.getGlDt()))  {	
				 strResultMsg = new ErrorHandler("COM12241", new String[]{"GL date:(" + headerVo.getGlDt() + ")" }).getUserMessage(); //($s) is invalid.
				 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				 return eventResponse;
			}
			 			 
			 // Header의 증빙유형 존재 여부
			 if(JSPUtil.getNull(headerVo.getAttrCateNm()).equals("")) {
				 strResultMsg = new ErrorHandler("SAP00008", new String[]{}).getUserMessage();	//Attribute Category(Evidence Type) is Required!
				 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				 return eventResponse;
			 }
			 				 
			 // Header의 Currency에 대한 사용 가능 여부 체크			
			 String currCd = "";
			 String currPrecisionAmt = "";
			// Currency에 대한 정보를 가져 옴.
			 SapCommonVO currInfo = apCommand.searchInvoiceInterfaceCurrUseCheck(headerVo.getInvAmt(), headerVo.getInvCurrCd());
			 if(currInfo == null || JSPUtil.getNull(currInfo.getValue0()).equals("")) { // Header의 Currency Code Check 여부
				 strResultMsg = new ErrorHandler("SAP00009", new String[]{}).getUserMessage();	//Currency is not used!
				 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				 return eventResponse;
			 }
			 else {
				 currCd = JSPUtil.getNull(currInfo.getValue0());
				 currPrecisionAmt = JSPUtil.getNull(currInfo.getValue1());
				 headerVo.setFunctionalCurrency(JSPUtil.getNull(currInfo.getValue2()));
			 }			 
			 
			 // Header의 PRECISION ERROR 체크			 
			if(!currPrecisionAmt.equals(headerVo.getInvAmt())) {
				strResultMsg = new ErrorHandler("SAP00010", new String[]{}).getUserMessage();	//Header amount precision Error!
				settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				return eventResponse;
			}
			 
			 // Header의 Invoice Currency를 Functional Currency로 변경하는 경우에 해당 환율 정보 존재 여부 체크
			 if(!headerVo.getInvCurrCd().equals(headerVo.getFunctionalCurrency())) {
				 SapCommonVO currExchInfo = apCommand.searchInvoiceInterfaceCurrExchangeRateCheck(headerVo.getGlDt(), headerVo.getInvCurrCd(), headerVo.getFunctionalCurrency());
				 if(currExchInfo == null || JSPUtil.getNull(currExchInfo.getValue2()).equals("")) { //conv_xch_rt
						strResultMsg = new ErrorHandler("SAP00011", new String[]{}).getUserMessage();	//Exchange Rate of Invoice Currency is Not Exists!
						settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
						return eventResponse;
				 }
				 else {
					 headerVo.setInvXchRt(JSPUtil.getNull(currExchInfo.getValue2()));
					 headerVo.setInvXchRtTpCd(JSPUtil.getNull(currExchInfo.getValue1()));
					 headerVo.setInvXchDt(JSPUtil.getNull(currExchInfo.getValue0()));
				 }
			 }
			 else {
				 headerVo.setInvXchRt("");
				 headerVo.setInvXchRtTpCd("");
				 headerVo.setInvXchDt("");					 
			 }

			 
			 // Header의 CSR Number 중복 Check
			 if(!JSPUtil.getNull(headerVo.getInvNo()).equals("")) {				 
				 String dupInvNo = JSPUtil.getNull(apCommand.searchInvoiceInterfaceInvNODupCheck(headerVo.getInvNo()));
				 
				 if(!dupInvNo.equals("")) {
				 	strResultMsg = new ErrorHandler("SAP00012", new String[]{dupInvNo}).getUserMessage();	//Duplicate CSR Number : 
					settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					return eventResponse;
				 }
			 }
			 
			 
			 //Header의 GL(Front System) Date 체크
			 String glSystemDivFlg = "";
			 if(JSPUtil.getNull(headerVo.getIfSrcNm()).equals("BMS")) {
				 glSystemDivFlg = "21";
			 }
			 else if(JSPUtil.getNull(headerVo.getIfSrcNm()).equals("SO_TRANS") ||
					 JSPUtil.getNull(headerVo.getIfSrcNm()).equals("SO_TERMINAL") ||
					 JSPUtil.getNull(headerVo.getIfSrcNm()).equals("BROKERAGE") ||
					 JSPUtil.getNull(headerVo.getIfSrcNm()).equals("SO_PORT") ||
					 JSPUtil.getNull(headerVo.getIfSrcNm()).equals("SO_M&R") ||
					 JSPUtil.getNull(headerVo.getIfSrcNm()).equals("SO_CCC") ||
					 JSPUtil.getNull(headerVo.getIfSrcNm()).equals("SO_LEASE") ||
					 JSPUtil.getNull(headerVo.getIfSrcNm()).equals("EQ") ||
					 JSPUtil.getNull(headerVo.getIfSrcNm()).equals("SO_CHASSIS") ||
					 JSPUtil.getNull(headerVo.getIfSrcNm()).equals("SO_MGSET") ||
					 JSPUtil.getNull(headerVo.getIfSrcNm()).equals("NIS AR")
			 ) {
				 glSystemDivFlg = "15";
			 }
			 else if(JSPUtil.getNull(headerVo.getIfSrcNm()).equals("COMMISSION")) {
				 glSystemDivFlg = "23";
			 }
			 else if(JSPUtil.getNull(headerVo.getIfSrcNm()).equals("CDAM") ||
					 JSPUtil.getNull(headerVo.getIfSrcNm()).equals("FMS")) {
				 glSystemDivFlg = "17";
			 }
			 else if(JSPUtil.getNull(headerVo.getIfSrcNm()).equals("JO")) {
				 glSystemDivFlg = "19";
			 }
			 else {
				 glSystemDivFlg = "34";
			 }
			 
			 String periodUseFlag = JSPUtil.getNull(apCommand.searchInvoiceInterfaceFrontGLDateCheck(headerVo.getGlDt(), glSystemDivFlg, headerVo.getOfcCd()));			 
			 if(periodUseFlag.equals("C")) {
				strResultMsg = new ErrorHandler("SAP00013", new String[]{}).getUserMessage();	//No Open GL(Front System) Period IN GL Date Period!
				settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				return eventResponse;
			 }
			 			 
			 // Header의 GL Date - 2 체크
			 String apPeriodUseFlag = JSPUtil.getNull(apCommand.searchInvoiceInterfaceAPGLDateCheck(headerVo.getGlDt()));			 
			 if(apPeriodUseFlag.equals("C")) {
					strResultMsg = new ErrorHandler("SAP00014", new String[]{}).getUserMessage();	//No Open GL(Front System) Period IN GL Date Period!
					settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					return eventResponse;
			 }
			 	
			 // Header의 VENDOR Number validation 체크
			 String supplierNo = JSPUtil.getNull(apCommand.searchInvoiceInterfaceSupplierActiveCheck(headerVo.getVndrNo()));					 
			 if(supplierNo.equals("")) {
					strResultMsg = new ErrorHandler("SAP00015", new String[]{}).getUserMessage();	//Invalid vendor Number!
					settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					return eventResponse;
			 }
			 
			 // Header의 INVOICE TYPE에 따른 CSR AMOUNT 부호 체크			
			 if(headerVo.getInvTpLuCd().equals("CREDIT")) {
				if(Double.valueOf(headerVo.getInvAmt()).doubleValue() > 0) {	
					strResultMsg = new ErrorHandler("SAP00016", new String[]{}).getUserMessage();	//Invalid Sign of inv_amount field!
					settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					return eventResponse;
				}
			 }
			 else {
				 if(Double.valueOf(headerVo.getInvAmt()).doubleValue() < 0) {	
					strResultMsg = new ErrorHandler("SAP00016", new String[]{}).getUserMessage();	//Invalid Sign of inv_amount field!
					settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					return eventResponse;
				 }
			 }
			 
			 //Header의 Payment Term 체크
			 if(JSPUtil.getNull(headerVo.getInvTermNm()).equals("")) {
				 headerVo.setInvTermNm("0");
			 }			 
			 //String termsName = JSPUtil.getNull(apCommand.searchInvoiceInterfaceTermsNameCheck(headerVo.getInvTermNm()));			 
			 //if(termsName.equals("")) {
			 //	strResultMsg = new ErrorHandler("SAP00017", new String[]{}).getUserMessage();	//Invalid Payment Term Name!
			 //	settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
			 //	return eventResponse;
			 //}
			 
			 // Header의 Invoice Interface Source Validation 체크
			 String systemSource = JSPUtil.getNull(apCommand.searchInvoiceInterfaceSystemSourceCheck(headerVo.getIfSrcNm()));			 
			 if(systemSource.equals("")) {
				strResultMsg = new ErrorHandler("SAP00018", new String[]{}).getUserMessage();	//Invalid Payment Term Name!
				settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				return eventResponse;
			 }
			 			
			 // Header의 payment Method Lookup Code Validation 체크 -- 2015.02.13 이전 내역. Vendor에서 가져오는 부분 그대로 사용
			 SapCommonVO paymentMethodInfo = apCommand.searchInvoiceInterfacePaymentMethodCheck(headerVo.getVndrNo());		
			 
			 // Header의 payment Method Lookup Code Validation 체크 (Front에서 넘어온 Method로 처크)
			 SapCommonVO appaymentMethodInfo = apCommand.searchInvoiceInterfaceApPaymentMethodCodeCheck(headerVo.getApPayMzdLuCd());
			 // Payment Method Check 추가 처리 2015.02.13
			 if(JSPUtil.getNull(headerVo.getApPayMzdLuCd()).equals("") || JSPUtil.getNull(appaymentMethodInfo.getValue0()).equals("") )  {
				strResultMsg = new ErrorHandler("COM12241", new String[]{"Payment Method of Vendor[" + headerVo.getVndrNo() + "]"}).getUserMessage();	//($s) is invalid.
				settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				return eventResponse;
			 }
			 // ASA 처럼 Invoice amount가 0인 경우 Payment Method가 X인 경우 처리 가능, 그외의 경우 처리 불가
			 if(JSPUtil.getNull(headerVo.getApPayMzdLuCd()).equals("X") && JSPUtil.getNull(appaymentMethodInfo.getValue0()).equals("X") && !JSPUtil.getNull(headerVo.getInvAmt()).equals("0") ) {
				strResultMsg = new ErrorHandler("SAP00060", new String[]{}).getUserMessage();	//Supplier Code has no Payment Method. Please kindly check.
				settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				return eventResponse;
			 }
			 
			 if(!JSPUtil.getNull(appaymentMethodInfo.getValue0()).equals("")) {
			 	 headerVo.setApPayMzdLuCd(appaymentMethodInfo.getValue0());
			 }
			 
			 // 2016.02.29 -- Payment Method가 TT(M)인 경우, Vendor의 Bank Account Flag가 존재하야여 한다.
			 if(JSPUtil.getNull(appaymentMethodInfo.getValue0()).equals("M")) {
				 if(!JSPUtil.getNull(paymentMethodInfo.getValue2()).equals("Y")) {
					 strResultMsg = new ErrorHandler("SAP00057", new String[]{appaymentMethodInfo.getValue1()}).getUserMessage();	//In case of [$s] Payment method, Vendor must have Bank account flag. Please use other vendor.
					 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					 return eventResponse;
				 }
			 } else if(JSPUtil.getNull(appaymentMethodInfo.getValue0()).equals("N")) {
				// ACH Payment 인 경우 Local Currency 와 동일한 Currencyd르 사용해야 한다.
				String localCurrCd = JSPUtil.getNull(apCommand.searchInvoiceInterfaceLocalCurrencyofACHPaymentMethodCheck(headerVo.getVndrNo(), headerVo.getInvCurrCd(), headerVo.getLiabCoaAcctNo()));
				if(!headerVo.getInvCurrCd().equals(localCurrCd)) {
					strResultMsg = new ErrorHandler("SAP00058", new String[]{appaymentMethodInfo.getValue1()}).getUserMessage();	//Case of [$s] Payment method, Curr of CSR and Local Curr must have same. Please use same Curr.
					settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					return eventResponse;
				}
			 }
			 
//			 if(!JSPUtil.getNull(headerVo.getApPayMzdLuCd()).equals("") && !JSPUtil.getNull(appaymentMethodInfo.getValue0()).equals("") )  {
//				 if(JSPUtil.getNull(headerVo.getApPayMzdLuCd()).equals(JSPUtil.getNull(paymentMethodInfo.getValue0())) )  {
//					strResultMsg = new ErrorHandler("COM12241", new String[]{"Payment Method"}).getUserMessage();	//($s) is invalid.
//					settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
//					return eventResponse;
//				 }
//			 }
			 
//			 if( JSPUtil.getNull(paymentMethodInfo.getValue0()).equals("") )  {
//				 strResultMsg = new ErrorHandler("COM12241", new String[]{"Payment Method"}).getUserMessage();	//($s) is invalid.
//				 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
//				 return eventResponse;				 
//			 } else {
//				 headerVo.setApPayMzdLuCd(paymentMethodInfo.getValue0());
//			 }

			 if(JSPUtil.getNull(paymentMethodInfo.getValue1()).equals("I")) {
				 headerVo.setInvRcvDt(""); 
			 }
			 else {
				 headerVo.setInvRcvDt(headerVo.getInvTermDt()); 
			 }
			 
			 // Header의 Pay Group Lookup code 체크 			 
			 if(JSPUtil.getNull(headerVo.getPayGrpLuCd()).equals("")) {
				strResultMsg = new ErrorHandler("SAP00019", new String[]{}).getUserMessage();	//Invalid Pay Group Lookup code!
				settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				return eventResponse;
			 }
			 else {
				 String paygroupLookupCode = JSPUtil.getNull(apCommand.searchInvoiceInterfacePayGroupExistsCheck(headerVo.getPayGrpLuCd(), headerVo.getOfcCd()));				 
				 if(paygroupLookupCode.equals("")) {
					strResultMsg = new ErrorHandler("SAP00020", new String[]{headerVo.getPayGrpLuCd(), headerVo.getOfcCd()}).getUserMessage();	//Invalid Pay Group code '|| @[header_vo.pay_grp_lu_cd] || 'On '|| @[header_vo.ofc_cd]
					settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					return eventResponse;
				 }
			 }
			 
			 //Header의 Intercompany segment Value & Vendor Interco Value 체크
			 if(JSPUtil.getNull(headerVo.getLiabCoaInterCoCd()).equals("")) {
				 if(JSPUtil.getNull(headerVo.getLiabCdCmbSeq()).equals("")) {
					strResultMsg = new ErrorHandler("SAP00021", new String[]{}).getUserMessage();	//Vendor Intercompany Value No Exists!
					settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					return eventResponse;
				 }
				 else {
					 String intercompanyCode = JSPUtil.getNull(apCommand.searchInvoiceInterfaceInterCompanyCheck(headerVo.getLiabCdCmbSeq()));	
					 if(!intercompanyCode.equals("")) {
						 headerVo.setLiabCoaInterCoCd(intercompanyCode);
					 }
					 else {
						 headerVo.setLiabCoaInterCoCd("00");
					 }
				 }
			 }
			 
			 String vendorIntercompanyCode = JSPUtil.getNull(apCommand.searchInvoiceInterfaceVendorInterCompanyCheck(headerVo.getVndrNo()));
			 
			 if(!vendorIntercompanyCode.equals(headerVo.getLiabCoaInterCoCd())) {
				strResultMsg = new ErrorHandler("SAP00022", new String[]{}).getUserMessage();	//Not corresponding Value Between Vendor Intercompany Value and Coa Interconpany Value!
				settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				return eventResponse;
			 }
			 
			 // Header의 vvd vs account Validaion 체크			 
			 if(JSPUtil.getNull(headerVo.getLiabCoaAcctNo()).equals("") && JSPUtil.getNull(headerVo.getLiabCoaVvdCd()).equals("")) {
				 if(JSPUtil.getNull(headerVo.getLiabCdCmbSeq()).equals("")) {
						strResultMsg = new ErrorHandler("SAP00024", new String[]{}).getUserMessage();	//VVD & Account Value No Exists!
						settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
						return eventResponse;
				 }
				 else {
					 SapCommonVO accVvdInfo = apCommand.searchInvoiceInterfaceAccountAndVVDCheck(headerVo.getLiabCdCmbSeq());
					 
					 if(!JSPUtil.getNull(accVvdInfo.getValue0()).equals("") || !JSPUtil.getNull(accVvdInfo.getValue1()).equals("")) {
						 headerVo.setLiabCoaAcctNo(accVvdInfo.getValue0());
						 headerVo.setLiabCoaVvdCd(accVvdInfo.getValue1());
					 }
				 }
			 }
			
			/* SapCommonVO vvdLevelInfo = apCommand.searchInvoiceInterfaceAccountAndVVDLevelCheck(headerVo.getLiabCoaAcctNo(), headerVo.getLiabCoaVvdCd());
			 String acctCd = JSPUtil.getNull(vvdLevelInfo.getValue0());
			 String vvdLevel1 = JSPUtil.getNull(vvdLevelInfo.getValue1());
			 String vvdLevel2 = JSPUtil.getNull(vvdLevelInfo.getValue2());
			 String vvdLevel3 = JSPUtil.getNull(vvdLevelInfo.getValue3());
			 String vvdLevel4 = JSPUtil.getNull(vvdLevelInfo.getValue4());
			 String vvdLevel5 = JSPUtil.getNull(vvdLevelInfo.getValue5());
			 String vvdLevel6 = JSPUtil.getNull(vvdLevelInfo.getValue6());
			 String vvdCd = JSPUtil.getNull(vvdLevelInfo.getValue7());
			 String vvdCommonLevel = JSPUtil.getNull(vvdLevelInfo.getValue8());
			 
			 if(vvdCommonLevel.equals("")) { // 1.l_vvd_level이 Null  인경우 Account의 VVD Level1 ~ 6에 모두 'N' Value이어야 함.				
				 String vvdLevel1YN = vvdLevel1.equals("") ? "N" : vvdLevel1;
				 String vvdLevel2YN = vvdLevel2.equals("") ? "N" : vvdLevel2;
				 String vvdLevel3YN = vvdLevel3.equals("") ? "N" : vvdLevel3;
				 String vvdLevel4YN = vvdLevel4.equals("") ? "N" : vvdLevel4;
				 String vvdLevel5YN = vvdLevel5.equals("") ? "N" : vvdLevel5;
				 String vvdLevel6YN = vvdLevel6.equals("") ? "N" : vvdLevel6;
				 
				 if(vvdLevel1YN.equals("Y") || vvdLevel2YN.equals("Y") || vvdLevel3YN.equals("Y") || vvdLevel4YN.equals("Y") || vvdLevel5YN.equals("Y") || vvdLevel6YN.equals("Y")) {
					strResultMsg = new ErrorHandler("SAP00026", new String[]{"1"}).getUserMessage();	//Bad Combination between Account and VVD Segments!!! Error 1.. Please verify code combination!
					settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					return eventResponse; 
						 
				 }
			 }
			 else { // 2.l_vvd_value가 Null 이 아닌경우 해당 VVD Value에 해당하는 VVD Level이 'Y' 값을 가지고 있어야 함.
				 if(vvdCommonLevel.equals("1")) {
					 if(!vvdLevel1.equals("Y")) {
							strResultMsg = new ErrorHandler("SAP00026", new String[]{"2"}).getUserMessage();	//Bad Combination between Account and VVD Segments!!! Error 1.. Please verify code combination!
							settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
							return eventResponse; 							 
					 }
				 }
				 else if(vvdCommonLevel.equals("2")) {
					 if(!vvdLevel2.equals("Y")) {
							strResultMsg = new ErrorHandler("SAP00026", new String[]{"3"}).getUserMessage();	//Bad Combination between Account and VVD Segments!!! Error 1.. Please verify code combination!
							settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
							return eventResponse; 							 
					 }
				 }
				 else if(vvdCommonLevel.equals("3")) {
					 if(!vvdLevel3.equals("Y")) {
							strResultMsg = new ErrorHandler("SAP00026", new String[]{"4"}).getUserMessage();	//Bad Combination between Account and VVD Segments!!! Error 1.. Please verify code combination!
							settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
							return eventResponse; 							 
					 }
				 }
				 else if(vvdCommonLevel.equals("4")) {
					 if(!vvdLevel4.equals("Y")) {
						 strResultMsg = new ErrorHandler("SAP00026", new String[]{"5"}).getUserMessage();	//Bad Combination between Account and VVD Segments!!! Error 1.. Please verify code combination!
						 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
						 return eventResponse; 						 
					 }
				 }
				 else if(vvdCommonLevel.equals("5")) {
					 if(!vvdLevel5.equals("Y")) {
						 strResultMsg = new ErrorHandler("SAP00026", new String[]{"6"}).getUserMessage();	//Bad Combination between Account and VVD Segments!!! Error 1.. Please verify code combination!
						 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
						 return eventResponse; 							 
					 }
				 }				 				 
				 else if(vvdCommonLevel.equals("6")) {
					 if(!vvdLevel6.equals("Y")) {
						 strResultMsg = new ErrorHandler("SAP00026", new String[]{"7"}).getUserMessage();	//Bad Combination between Account and VVD Segments!!! Error 1.. Please verify code combination!
						 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
						 return eventResponse; 							 
					 }
				 }					 
			 }  */
			 
			 // Header의 Liability Account validation 체크			 
			 if(!JSPUtil.getNull(headerVo.getLiabCdCmbSeq()).equals("")) {
				 String cdCmbSeq = JSPUtil.getNull(apCommand.searchInvoiceInterfaceCodeCombinationCheck(headerVo.getLiabCdCmbSeq()));
				 
				 if(cdCmbSeq.equals("")) {
					 strResultMsg = new ErrorHandler("SAP00027", new String[]{}).getUserMessage();	//Code Combination Error: Request Accounting Department To Register CCID!
					 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					 return eventResponse; 
				 }
			 }
			 else {
				 SapCommonVO vo = new SapCommonVO();
				 vo.setValue0(headerVo.getLiabCoaCoCd());
				 vo.setValue1(headerVo.getLiabCoaRgnCd());
				 vo.setValue2(headerVo.getLiabCoaCtrCd());
				 vo.setValue3(headerVo.getLiabCoaAcctNo());
				 vo.setValue4(headerVo.getLiabCoaInterCoCd());
				 vo.setValue5(headerVo.getLiabCoaVvdCd());
				 
				 SapCommonVO combineCombinationInfo = apCommand.searchInvoiceInterfaceCombineCombinationCheck(vo);
				 String cdCmbSeq = JSPUtil.getNull(combineCombinationInfo.getValue0());
				 
				 if(!cdCmbSeq.equals("")) {
					 headerVo.setLiabCdCmbSeq(cdCmbSeq);
				 }
				 else {
					 
					 //strResultMsg = new ErrorHandler("SAP00027", new String[]{}).getUserMessage();	//Code Combination Error: Request Accounting Department To Register CCID!
					 //settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					 //return eventResponse;
					 
					 LedgerCodeCombinationListVO ccidVO = new LedgerCodeCombinationListVO();
					 ccidVO.setSgmCtnt1(headerVo.getLiabCoaCoCd());
					 ccidVO.setSgmCtnt2(headerVo.getLiabCoaRgnCd());
					 ccidVO.setSgmCtnt3(headerVo.getLiabCoaCtrCd());
					 ccidVO.setSgmCtnt4(headerVo.getLiabCoaAcctNo());
					 ccidVO.setSgmCtnt5(headerVo.getLiabCoaInterCoCd());
					 ccidVO.setSgmCtnt6(headerVo.getLiabCoaVvdCd());
					 
					 String ccidChk[] = scoCommand.manageLedgerCodeCombinationBiz(ccidVO, usrId);
					 
					 if(ccidChk[0].equals("OK")) {
						 headerVo.setLiabCdCmbSeq(ccidChk[1]); 
					 } else {
						 strResultMsg =  "Header " + ccidChk[0];
						 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
						 return eventResponse; 
					 }
					 
				 }
			 }			 
			 
			 // Header의 Office code 체크			 
			 if(JSPUtil.getNull(headerVo.getOfcCd()).equals("")) {
				 strResultMsg = new ErrorHandler("SAP00029", new String[]{}).getUserMessage();	//Office Code No Exists!
				 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				 return eventResponse;
			 }
			 else {				 
				 String officeCode = JSPUtil.getNull(apCommand.searchInvoiceInterfaceAPOfficeCheck(headerVo.getOfcCd()));
				 
				 if(officeCode.equals("")) {
					 strResultMsg = new ErrorHandler("SAP00030", new String[]{}).getUserMessage();	//Invalid AP Office code!
					 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					 return eventResponse;
				 }
			 }
			 
			 // Header의 Office Region 정보와 각 Vendor의 Country 정보를 비교하여  11(본사) 지역에는 해당 본사 지역 Country의 Vendor만 사용하고, 11외 지역은 본사 외 Country의 Vendor을 사용하도록 처리
			 String EnableVendorCheck = JSPUtil.getNull(apCommand.searchInvoiceInterfaceOfficeEnableVendorCheck(headerVo.getOfcCd(), headerVo.getVndrNo()));
			 
			 if(EnableVendorCheck.equals("N")) {
				strResultMsg = new ErrorHandler("SAP00055", new String[]{headerVo.getOfcCd(), headerVo.getVndrNo()}).getUserMessage();	//Region of ($s)office and country of ($s)vendor are different. Please use the same region.
				settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				return eventResponse;
			 }
			 			 
			 // Header의 Prepayment apply valication 체크			 
			 if(!JSPUtil.getNull(headerVo.getPpayInvNo()).equals("")) {
				 String prepayInvoiceNumber = JSPUtil.getNull(apCommand.searchInvoiceInterfacePrepaymentAvailableCheck(headerVo.getPpayInvNo(), headerVo.getPpayInvLineNo(), headerVo.getPpayAplyAmt()));
			 
				 if(prepayInvoiceNumber.equals("")) {
					 strResultMsg = new ErrorHandler("SAP00031", new String[]{}).getUserMessage();	//Invalid Prepay Application Infomation!
					 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					 return eventResponse;
				 }
			 }
			 
			 // Header의 ASA Master Validation 체크
			 if(!headerVo.getOfcCd().equals("SZPBB") && !headerVo.getOfcCd().equals("XMNBB")) {
				 String officeAsaFlag = apCommand.searchInvoiceInterfaceASAOfficeCheck(headerVo.getOfcCd());
				 
				 if(JSPUtil.getNull(headerVo.getAttrCateNm()).equals("Invoices") && JSPUtil.getNull(officeAsaFlag).equals("O") && (JSPUtil.getNull(headerVo.getAttrCtnt2()).equals("") || (!JSPUtil.getNull(headerVo.getInvAmt()).equals("0")))) {
					 strResultMsg = new ErrorHandler("SAP00032", new String[]{}).getUserMessage();	//Cannot insert null into ASA No!
					 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					 return eventResponse;
				 }
			 }
			 
			 // Header의 ASA Master Use Validation 체크 및 ASA currency 사용 여부 체크	
			 if(JSPUtil.getNull(headerVo.getAttrCateNm()).equals("Invoices") && !JSPUtil.getNull(headerVo.getAttrCtnt2()).equals("")) {
				 String asaNumber = JSPUtil.getNull(apCommand.searchInvoiceInterfaceASAMasterCheck(headerVo.getAttrCtnt2()));
				 
				 if(asaNumber.equals("")) {
					 strResultMsg = new ErrorHandler("SAP00033", new String[]{}).getUserMessage();	//Invalid ASA No!
					 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					 return eventResponse;
				 }
				 
				 String asaCurrency = JSPUtil.getNull(apCommand.searchInvoiceInterfaceASAMasterCurrencyCheck(headerVo.getAttrCtnt2(), headerVo.getInvCurrCd()));
				 
				 if(asaCurrency.equals("")) {
					 strResultMsg = new ErrorHandler("SAP00052", new String[]{}).getUserMessage();	//Currency code value of CSR is not matched to Currency code value of ASA. Please use same currency.
					 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					 return eventResponse;
				 }
				 
				 strASAClearAcct = JSPUtil.getNull(apCommand.searchInvoiceInterfaceASAClearingAccountCheck());
				 
				 if(strASAClearAcct.equals("")) {
					 strResultMsg = new ErrorHandler("COM12198", new String[]{}).getUserMessage();	//There is no data to search.
					 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					 return eventResponse;
				 }
			 }
			 
			 // Header의 TES 자료중 JOINT Data Validation 체크
			 String clearingCount = "";
			 if(ifSourceType.equals("A/P")) {
				 clearingCount = apCommand.searchInvoiceInterfaceAPClearingAcctCheck(csrNo);
			 }
			 else if(ifSourceType.equals("S/O")) {
				 clearingCount = apCommand.searchInvoiceInterfaceSOClearingAcctCheck(csrNo);
			 }
			 
			 if(JSPUtil.getNull(headerVo.getIfSrcNm()).equals("SO_TERMINAL") && JSPUtil.getNull(headerVo.getAttrCtnt2()).equals("") && JSPUtil.getNull(headerVo.getAttrCtnt9()).equals("") && Integer.parseInt(clearingCount) > 0) {
				 headerVo.setAttrCtnt9(headerVo.getInvNo());
			 }
			 
			 // Header의 Evidence Validation 체크			 
			 if(JSPUtil.getNull(headerVo.getAttrCateNm()).equals("TAX")) {				 
				 headerVo.setLAttributeCategory("TAX");
			 }
			 else if(JSPUtil.getNull(headerVo.getAttrCateNm()).equals("CAL")) {				 
				 headerVo.setLAttributeCategory("VAT");
			 }
			 else if(JSPUtil.getNull(headerVo.getAttrCateNm()).equals("Invoices")) {				 
				 headerVo.setLAttributeCategory("INVOICES");
			 }
			 else if(JSPUtil.getNull(headerVo.getAttrCateNm()).equals("Refund")) {				 
				 headerVo.setLAttributeCategory("REFUND");
			 }
			 else if(JSPUtil.getNull(headerVo.getAttrCateNm()).equals("기타") || JSPUtil.getNull(headerVo.getAttrCateNm()).equals("ETC") ) {				 
				 headerVo.setLAttributeCategory("ETC");
			 }
			 else if(JSPUtil.getNull(headerVo.getAttrCateNm()).equals("AR AP Offset")) {				 
				 headerVo.setLAttributeCategory("ARAPOFFSET");
			 }
			 else if(JSPUtil.getNull(headerVo.getAttrCateNm()).equals("법인영수증")) {				 
				 headerVo.setLAttributeCategory("CREDITCARD");
			 }			 
			 
			 //------------------------ Line 부분 Validation 처리 
			 //------------------------ Line은 해당 Loop을 돌면서 검증 해야 함	
			 SapInvoiceInterfaceDetailVO line 	= null;
			 int lineSize 						= lineVo.size();
			 for(int i=0; i<lineSize; i++) {
				 line = (SapInvoiceInterfaceDetailVO) lineVo.get(i);
				 
				 //CreationUser Setting
				 lineVo.get(i).setCreationUser(headerVo.getCreationUser());
				 
				 if(JSPUtil.getNull(line.getDtrbAmt()).equals("")) {
					 strResultMsg = new ErrorHandler("SAP00034", new String[]{}).getUserMessage();	//Line Amount is Null Error!
					 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					 return eventResponse;
				 }
				 
				 // Line Currency에 대한 정보를 가져온다.
				 SapCommonVO lCurrInfo = apCommand.searchInvoiceInterfaceLineCurrUseCheck(line.getDtrbAmt(), headerVo.getInvCurrCd());	
				 // Line의 PRECISION ERROR 체크				 
				 if(!JSPUtil.getNull(lCurrInfo.getValue1()).equals(line.getDtrbAmt())) {	
					 strResultMsg = new ErrorHandler("SAP00035", new String[]{}).getUserMessage();	//Line amount precision Error!
					 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					 return eventResponse;
				 }
				 
				 // Line의 Exchange Rate 기준 여부를 가져온다.
				 String exchangeratetype = JSPUtil.getNull(apCommand.searchInvoiceInterfaceExchangeMethodCheck());			 
				 if(exchangeratetype.equals("")) {
					strResultMsg = new ErrorHandler("SAP00011", new String[]{}).getUserMessage();	//Invalid Payment Term Name!
					settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					return eventResponse;
				 } else {
					 line.setExchangeRateType(exchangeratetype);
				 }
				 
				 // LINE type exchange rate case
				 if (exchangeratetype.equals("LINE")) {
					 if(JSPUtil.getNull(headerVo.getInvTpLuCd()).equals("PREPAYMENT")) {
 
						// Header의 G/L Date 및 Invoice Currency를 Functional Currency로 변경하여 Line의 Funcational 금액 처리
						 if(!headerVo.getInvCurrCd().equals(headerVo.getFunctionalCurrency())) {
							 SapCommonVO currPreExchInfo = apCommand.searchInvoiceInterfaceCurrExchangeRateCheck(headerVo.getGlDt(), headerVo.getInvCurrCd(), headerVo.getFunctionalCurrency());
							 if(currPreExchInfo == null || JSPUtil.getNull(currPreExchInfo.getValue2()).equals("")) { //conv_xch_rt
									strResultMsg = new ErrorHandler("SAP00011", new String[]{}).getUserMessage();	//Exchange Rate of Invoice Currency is Not Exists!
									settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
									return eventResponse;
							 }
							 else {
								 line.setDtrbXchRt(JSPUtil.getNull(currPreExchInfo.getValue2()));
								 line.setDtrbXchRtTpCd(JSPUtil.getNull(currPreExchInfo.getValue1()));
								 line.setDtrbXchDt(JSPUtil.getNull(currPreExchInfo.getValue0()));
							 }
						 }
						 else {
							 line.setDtrbXchRt("");
							 line.setDtrbXchRtTpCd("");
							 line.setDtrbXchDt("");				 
						 }

					 } else {
						 String linegldate = "";
						 if(JSPUtil.getNull(line.getAttrCtnt11()).equals("")) {
							 linegldate = JSPUtil.getNull(headerVo.getGlDt());
						 } else {
							 linegldate = JSPUtil.getNull(line.getAttrCtnt11());
						 }
						// Header의 Invoice Currency를 기준으로 Line의 Functional Currency로 변경하는 경우에 해당 환율 정보 존재 여부 체크
						 if(!headerVo.getInvCurrCd().equals(headerVo.getFunctionalCurrency())) {
							 SapCommonVO currLineExchInfo = apCommand.searchInvoiceInterfaceCurrExchangeRateCheck(linegldate, headerVo.getInvCurrCd(), headerVo.getFunctionalCurrency());
							 if(currLineExchInfo == null || JSPUtil.getNull(currLineExchInfo.getValue2()).equals("")) { //conv_xch_rt
									strResultMsg = new ErrorHandler("SAP00011", new String[]{}).getUserMessage();	//Exchange Rate of Invoice Currency is Not Exists!
									settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
									return eventResponse;
							 }
							 else {
								 line.setDtrbXchRt(JSPUtil.getNull(currLineExchInfo.getValue2()));
								 line.setDtrbXchRtTpCd(JSPUtil.getNull(currLineExchInfo.getValue1()));
								 line.setDtrbXchDt(JSPUtil.getNull(currLineExchInfo.getValue0()));
							 }
						 }
						 else {
							 line.setDtrbXchRt("");
							 line.setDtrbXchRtTpCd("");
							 line.setDtrbXchDt("");					 
						 }
					 }
				 }
				 
				 // Line의 Intercompany segment Value & Vendor Interco Value 체크
				 if(JSPUtil.getNull(line.getDtrbCoaInterCoCd()).equals("")) {
					 if(JSPUtil.getNull(line.getDtrbCdCmbSeq()).equals("")) {
						 strResultMsg = new ErrorHandler("SAP00036", new String[]{}).getUserMessage();	//Line COA Intercompany Value No Exists!
						 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
						 return eventResponse;
					 }
					 else {
						String lIntercompanyCode = apCommand.searchInvoiceInterfaceLineInterCompanyCheck(line.getDtrbCdCmbSeq());
						if(!lIntercompanyCode.equals("")) {
							line.setDtrbCoaInterCoCd(lIntercompanyCode);
						}
						else {
							line.setDtrbCoaInterCoCd("00");
						}
					 }
				 }
				
				 if(!vendorIntercompanyCode.equals(JSPUtil.getNull(line.getDtrbCoaInterCoCd()))) {
					 strResultMsg = new ErrorHandler("SAP00037", new String[]{}).getUserMessage();	//Not corresponding Value Between Vendor Intercompany Value and Line Coa Interconpany Value!
					 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					 return eventResponse;
				 }
				 
				 // Line의 vvd vs account Validaion 체크				 
				 if(JSPUtil.getNull(line.getDtrbCoaAcctNo()).equals("") && JSPUtil.getNull(line.getDtrbCoaVvdCd()).equals("")) {
					 if(JSPUtil.getNull(line.getDtrbCdCmbSeq()).equals("")) {
						 strResultMsg = new ErrorHandler("SAP00038", new String[]{}).getUserMessage();	//Line VVD & Account Value No Exists!
						 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
						 return eventResponse;
					 }
					 else {
						 SapCommonVO lAccVvdInfo = apCommand.searchInvoiceInterfaceLineAccountAndVVDCheck(line.getDtrbCdCmbSeq());
						 
						 if(!JSPUtil.getNull(lAccVvdInfo.getValue0()).equals("") || !JSPUtil.getNull(lAccVvdInfo.getValue1()).equals("")) {
							 line.setDtrbCoaAcctNo(lAccVvdInfo.getValue0());
							 line.setDtrbCoaVvdCd(lAccVvdInfo.getValue1());
						 }
					 }
				 }
				 
			/*	 SapCommonVO lVvdLevelInfo = apCommand.searchInvoiceInterfaceAccountAndVVDLevelCheck(line.getDtrbCoaAcctNo(), line.getDtrbCoaVvdCd()); //(헤더 체크시 쓰인 AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAccountAndVVDLevelCheckRSQL 재활용)
				 String lAcctCd = JSPUtil.getNull(lVvdLevelInfo.getValue0());
				 String lVvdLevel1 = JSPUtil.getNull(lVvdLevelInfo.getValue1());
				 String lVvdLevel2 = JSPUtil.getNull(lVvdLevelInfo.getValue2());
				 String lVvdLevel3 = JSPUtil.getNull(lVvdLevelInfo.getValue3());
				 String lVvdLevel4 = JSPUtil.getNull(lVvdLevelInfo.getValue4());
				 String lVvdLevel5 = JSPUtil.getNull(lVvdLevelInfo.getValue5());
				 String lVvdLevel6 = JSPUtil.getNull(lVvdLevelInfo.getValue6());
				 String lVvdCd = JSPUtil.getNull(lVvdLevelInfo.getValue7());
				 String lVvdCommonLevel = JSPUtil.getNull(lVvdLevelInfo.getValue8());				 
				 		 
				 if(lVvdCommonLevel.equals("")) { // 1.l_vvd_level이 Null  인경우 Account의 VVD Level1 ~ 6에 모두 'N' Value이어야 함.
					 String lVvdLevel1YN = lVvdLevel1.equals("") ? "N" : lVvdLevel1;
					 String lVvdLevel2YN = lVvdLevel2.equals("") ? "N" : lVvdLevel2;
					 String lVvdLevel3YN = lVvdLevel3.equals("") ? "N" : lVvdLevel3;
					 String lVvdLevel4YN = lVvdLevel4.equals("") ? "N" : lVvdLevel4;
					 String lVvdLevel5YN = lVvdLevel5.equals("") ? "N" : lVvdLevel5;
					 String lVvdLevel6YN = lVvdLevel6.equals("") ? "N" : lVvdLevel6;
					 
					 if(lVvdLevel1YN.equals("Y") || lVvdLevel2YN.equals("Y") || lVvdLevel3YN.equals("Y") || lVvdLevel4YN.equals("Y") || lVvdLevel5YN.equals("Y") || lVvdLevel6YN.equals("Y")) {
						 strResultMsg = new ErrorHandler("SAP00039", new String[]{"1"}).getUserMessage(); //Bad Combination between Account and VVD Segments!!! Error 1.. Please verify code combination!
						 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
						 return eventResponse;
					 }					 
				 }
				 else { // 2.l_vvd_value가 Null 이 아닌경우 해당 VVD Value에 해당하는 VVD Level이 'Y' 값을 가지고 있어야 함.					 
					 if(lVvdCommonLevel.equals("1")) {
						 if(!lVvdLevel1.equals("Y")) {
							 strResultMsg = new ErrorHandler("SAP00039", new String[]{"2"}).getUserMessage(); //Bad Combination between Account and VVD Segments!!! Error 1.. Please verify code combination!
							 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
							 return eventResponse;
						 }
					 }
					 else if(lVvdCommonLevel.equals("2")) {
						 if(!lVvdLevel2.equals("Y")) {
							 strResultMsg = new ErrorHandler("SAP00039", new String[]{"3"}).getUserMessage(); //Bad Combination between Account and VVD Segments!!! Error 1.. Please verify code combination!
							 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
							 return eventResponse;								 
						 }						 
					 }
					 else if(lVvdCommonLevel.equals("3")) {
						 if(!lVvdLevel3.equals("Y")) {
							 strResultMsg = new ErrorHandler("SAP00039", new String[]{"4"}).getUserMessage(); //Bad Combination between Account and VVD Segments!!! Error 1.. Please verify code combination!
							 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
							 return eventResponse;								 
						 }	
					 }
					 else if(lVvdCommonLevel.equals("4")) {
						 if(!lVvdLevel4.equals("Y")) {
							 strResultMsg = new ErrorHandler("SAP00039", new String[]{"5"}).getUserMessage(); //Bad Combination between Account and VVD Segments!!! Error 1.. Please verify code combination!
							 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
							 return eventResponse;								 
						 }							 
					 }
					 else if(lVvdCommonLevel.equals("5")) {
						 if(!lVvdLevel5.equals("Y")) {
							 strResultMsg = new ErrorHandler("SAP00039", new String[]{"6"}).getUserMessage(); //Bad Combination between Account and VVD Segments!!! Error 1.. Please verify code combination!
							 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
							 return eventResponse;								 
						 }							 
					 }
					 else if(lVvdCommonLevel.equals("6")) {
						 if(!lVvdLevel6.equals("Y")) {
							 strResultMsg = new ErrorHandler("SAP00039", new String[]{"7"}).getUserMessage(); //Bad Combination between Account and VVD Segments!!! Error 1.. Please verify code combination!
							 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
							 return eventResponse;								 
						 }							 
					 }					 
				 }  */
				 				 
				 //Line의 Expense Account validation 체크				 
				 if(!JSPUtil.getNull(line.getDtrbCdCmbSeq()).equals("")) {
					 String lCdCmbSeq = JSPUtil.getNull(apCommand.searchInvoiceInterfaceCodeCombinationCheck(line.getDtrbCdCmbSeq())); //(헤더 체크시 쓰인 AccountPayableInvoiceDBDAOSearchInvoiceInterfaceCodeCombinationCheckRSQL 을 재활용)					 
					 
					 if(lCdCmbSeq.equals("")) {
						 strResultMsg = new ErrorHandler("SAP00040", new String[]{}).getUserMessage(); //Line Code Combination Error: Request Accounting Department To Register CCID!
						 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
						 return eventResponse;
					 }
				 }
				 else {
					 SapCommonVO lvo = new SapCommonVO();
					 lvo.setValue0(line.getDtrbCoaCoCd());
					 lvo.setValue1(line.getDtrbCoaRgnCd());
					 lvo.setValue2(line.getDtrbCoaCtrCd());
					 lvo.setValue3(line.getDtrbCoaAcctNo());
					 lvo.setValue4(line.getDtrbCoaInterCoCd());
					 lvo.setValue5(line.getDtrbCoaVvdCd());
					 
					 SapCommonVO lCombineCombinationInfo = apCommand.searchInvoiceInterfaceCombineCombinationCheck(lvo); //(헤더 체크시 쓰인 AccountPayableInvoiceDBDAOSearchInvoiceInterfaceCombineCombinationCheckRSQL 재활용)
					 String lCdCmbSeq = JSPUtil.getNull(lCombineCombinationInfo.getValue0());
					 
					 if(!lCdCmbSeq.equals("")) {
						 line.setDtrbCdCmbSeq(lCdCmbSeq);
					 }
					 else {
						 //strResultMsg = new ErrorHandler("SAP00040", new String[]{}).getUserMessage(); //Line Code Combination Error: Request Accounting Department To Register CCID!
						 //settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
						 //return eventResponse;
						 LedgerCodeCombinationListVO ccidVO = new LedgerCodeCombinationListVO();
						 ccidVO.setSgmCtnt1(line.getDtrbCoaCoCd());
						 ccidVO.setSgmCtnt2(line.getDtrbCoaRgnCd());
						 ccidVO.setSgmCtnt3(line.getDtrbCoaCtrCd());
						 ccidVO.setSgmCtnt4(line.getDtrbCoaAcctNo());
						 ccidVO.setSgmCtnt5(line.getDtrbCoaInterCoCd());
						 ccidVO.setSgmCtnt6(line.getDtrbCoaVvdCd());
						 
						 String ccidChk[] = scoCommand.manageLedgerCodeCombinationBiz(ccidVO, usrId);
						 
						 if(ccidChk[0].equals("OK")) {
							 line.setDtrbCdCmbSeq(ccidChk[1]); 
						 } else {
							 strResultMsg = "Line CCID " + ccidChk[0];
							 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
							 return eventResponse;
						 }
					 }
				 }
				 
				 // Line의 Vendor Invoice No에 입력에 대한 필수 여부 체크
				 if(JSPUtil.getNull(headerVo.getAttrCateNm()).equals("Invoices") || JSPUtil.getNull(headerVo.getAttrCateNm()).equals("INVOICES")) {
					 if(line.getAttrCtnt1().equals("")) {
						 if(ifSourceType.equals("A/P")) {
							 strResultMsg = new ErrorHandler("SAP00053", new String[]{}).getUserMessage();	//Vendor Invoice No is Null !. This data with INVOICE evidence is mandatory item
							 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
							 return eventResponse;
						 }
						 else if(ifSourceType.equals("S/O")) {
							 strResultMsg = new ErrorHandler("SAP00053", new String[]{}).getUserMessage();	//Vendor Invoice No is Null !. This data with INVOICE evidence is mandatory item
							 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
							 return eventResponse;
						 }
					 }
				 }
				 
				 // Line의  Vendor Invoice Duplicate 체크
				 if(!line.getAttrCtnt1().equals("")) {
					 String vndrDupReason = JSPUtil.getNull(apCommand.searchInvoiceInterfaceLineVndrInvNoDupCheckRSQL(headerVo.getVndrNo(), csrNo, line.getAttrCtnt1()));
					 
					 if(!vndrDupReason.equals("")) {
						 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, vndrDupReason, transactionFlag );
						 return eventResponse;
					 }
				 }
				 
				 // Line의 Activity Date/Place/Service Lane에 대한 필수값 여부 체크
				 // VVD 가 CNTC, COMC 로 시작하는 항차인경우 SERVICE LANE 체크 
				 if(ifSourceType.equals("S/O")) {
					 if(JSPUtil.getNull(line.getAttrCtnt11()).equals("")) {
						 strResultMsg = new ErrorHandler("SAP00049", new String[]{}).getUserMessage();	//Activity Date is Null ! This data is mandantory item
						 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
						 return eventResponse;
					 }
					 
					 // Line이 954113인 경우 해당 Activity Date와 ASA Period의 TO Date 간 동일 년월을 사용하도록 체크
					 if(JSPUtil.getNull(line.getDtrbCoaAcctNo()).equals(strASAClearAcct) && !JSPUtil.getNull(headerVo.getAttrCtnt2()).equals("")) {
						 if(!JSPUtil.getNull(headerVo.getAttrCtnt2()).substring(3,6).equals(JSPUtil.getNull(line.getAttrCtnt11()).substring(3,6))) {
							 strResultMsg = new ErrorHandler("SAP00056", new String[]{}).getUserMessage();	//Month of ASA no and Month of activity date(954113 acct.) are different. Please use the same Month.
							 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
							 return eventResponse;
						 }
					 }
					 
					 if(JSPUtil.getNull(line.getAttrCtnt12()).equals("")) {
						 strResultMsg = new ErrorHandler("SAP00050", new String[]{}).getUserMessage();	//Activity Place is Null ! This data is mandantory item
						 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
						 return eventResponse;
					 }
					 
					 if(JSPUtil.getNull(line.getAttrCtnt14()).equals("")) {
						 strResultMsg = new ErrorHandler("SAP00051", new String[]{}).getUserMessage();	//Service Lane is Null ! This data is mandantory item
						 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
						 return eventResponse;
					 }
					 
					 if(JSPUtil.getNull(line.getDtrbCoaVvdCd()).startsWith("CNTC") || JSPUtil.getNull(line.getDtrbCoaVvdCd()).startsWith("COMC")) {
						 AccountPayableCommonBC apComCommand = new AccountPayableCommonBCImpl();
						 String arRevSLanCd = JSPUtil.getNull(apComCommand.searchAPLineServiceLaneCheck(line.getDtrbCoaVvdCd()));
						 if (!arRevSLanCd.equals(line.getAttrCtnt14())) {
							 strResultMsg = new ErrorHandler("SAP00059", new String[]{line.getAttrCtnt14(), line.getDtrbCoaVvdCd() }).getUserMessage();	//Service lane($s) is not matched with VVD($s). Please kindly check. 
							 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
							 return eventResponse;
						 }						 
					 }
				 }
				 
				 // Line의 Item Line 에 Tax Code 유무 확인 체크
				 if(!JSPUtil.getNull(headerVo.getIfSrcNm()).equals("BMS") && JSPUtil.getNull(line.getLineTpLuCd()).equals("ITEM") && !JSPUtil.getNull(line.getDtrbVatCd()).equals("")) {
					 strResultMsg = new ErrorHandler("SAP00041", new String[]{}).getUserMessage(); //ITEM Line TAX Code Error!
					 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					 return eventResponse;
				 }
				 
				 // Line의 Tax Line 에 Tax Code 유무 확인 체크
				 /*if(JSPUtil.getNull(line.getLineTpLuCd()).equals("TAX") && JSPUtil.getNull(line.getDtrbVatCd()).equals("")) {
					 strResultMsg = new ErrorHandler("SAP00042", new String[]{}).getUserMessage(); //TAX Line TAX Code Error!
					 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					 return eventResponse;
				 }*/
				 	 				 
				 if(!JSPUtil.getNull(line.getDtrbVatCd()).equals("")) {
					 String apTaxNm = apCommand.searchInvoiceInterfaceLineTaxCodeCheck(line.getDtrbVatCd()).getValue1();
					 
					 if(JSPUtil.getNull(apTaxNm).equals("")) {
						 strResultMsg = new ErrorHandler("SAP00043", new String[]{}).getUserMessage(); //Invalid AP Tax Code!
						 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
						 return eventResponse;
					 } else {
						 line.setDtrbVatCd(apTaxNm);
					 }
				 }
				 
				 // Line의 Unsettled Account Entry 가능 여부  체크
				 if(!JSPUtil.getNull(line.getDtrbCoaAcctNo()).equals("")) {
					 String lUnsettledFlag = JSPUtil.getNull(apCommand.searchInvoiceInterfaceLineUnsettleAccountCheck(line.getDtrbCoaAcctNo()).getValue1());
					 
					 //Prepayment Invoice 이면 Item Line에 Unsettled Account = 'Y' 인놈만 Entry 가능
					 if(JSPUtil.getNull(headerVo.getInvTpLuCd()).equals("PREPAYMENT")) {
						 if(JSPUtil.getNull(line.getLineTpLuCd()).equals("ITEM")) {
							 if(lUnsettledFlag.equals("N")) {
								 strResultMsg = new ErrorHandler("SAP00044", new String[]{}).getUserMessage(); //You must choose Unsettled Account for Item Line of Prepayment Invoice!
								 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
								 return eventResponse;
							 }
						 }
						 else {
							 if(lUnsettledFlag.equals("Y")) {
								 strResultMsg = new ErrorHandler("SAP00045", new String[]{}).getUserMessage(); //You can choose Unsettled Account Only for Item Line of Prepayment Invoice!
								 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
								 return eventResponse;
							 }
						 }
					 }
					 else { 
						 // Prepayment Invoice가 아니면 Prepay Line이 아니면 Unsettled Account ='Y'가 아닌 놈만 Entry 가능하다.
						 if(!JSPUtil.getNull(line.getLineTpLuCd()).equals("PREPAY")) {
							 if(lUnsettledFlag.equals("Y") && !JSPUtil.getNull(line.getDtrbCoaAcctNo()).equals("111071")) {
								 strResultMsg = new ErrorHandler("SAP00046", new String[]{}).getUserMessage(); //You cannot choose Unsettled Account except for Prepayment Invoice Item Line!
								 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
								 return eventResponse;
							 }
						 }
					 }
				 }
				 
				 // Line의 선급금 Type이면서 Item Line에 (-)금액이 들어올 경우 에러 처리  체크				 
				 if(JSPUtil.getNull(headerVo.getInvTpLuCd()).equals("PREPAYMENT") && JSPUtil.getNull(line.getLineTpLuCd()).equals("ITEM") && Double.valueOf(line.getDtrbAmt()).doubleValue() < 0) {
					 strResultMsg = new ErrorHandler("SAP00047", new String[]{}).getUserMessage(); //You cannot enter a negative distribution amount on a prepayment. Please enter a positive distribution amount.!
					 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
					 return eventResponse;
				 }
				 
			 } // end for
			 
			 // header 및 line insert 처리			 
			 apCommand.manageSapIfValidateImportCheck(headerVo, lineVo, usrId);
			 
			 //Manually ASA I/F 
			 apCommand.manageAsaClearingIF(headerVo.getInvNo());
			 
			 // 성공 flag 저장
			 if(ifSourceType.equals("A/P")) {
				 apCommand.manageAPInvoiceInterfaceSucess(csrNo);
			 }
			 if(ifSourceType.equals("S/O")) {
				 csrCommand.manageSoInvoiceInterfaceSucess(csrNo);
				 //SAKURA I/F Call  (approval을 먼저 수행해야 함)
				 apCommand.manageInterfaceSAP(csrNo, usrId);
				 //AP Invoice Accounting Call
				 payCommand.manageAccountingCaptureCsrNo(csrNo, usrId);
			 }
			 
			 // 성공 메세지 반환
			 strResultMsg = new ErrorHandler("SAP00005", new String[]{csrNo}).getUserMessage();	// CSR No ($s) is transmited successfully. 			
			 eventResponse.setUserMessage(strResultMsg);
			 eventResponse.setETCData("SUCCESS_FLG", "SUCCESS");	 
			 eventResponse.setETCData("RESULT_MSG", strResultMsg);			
			 
			 if (!"ONE".equals(transactionFlag)) {
				 commit();
			 }
			
			 
		} catch (EventException ex) {
			if (!"ONE".equals(transactionFlag)) {
				 rollback();
			 }
			
			 // 실패(오라클) 메세지 반환
			 if(ex.getMessage().length() > 100) {
				 strResultMsg = ex.getMessage().substring(0,100);		
			 } else {
				 strResultMsg = ex.getMessage();
			 }
			 
			 if(strResultMsg.indexOf("SAR00001") > 0) {
				 strResultMsg = new ErrorHandler("SAP00062", new String[]{}).getUserMessage();	// It's not available to create ASA Outstanding to SAR module. Please check Rep. Customer of Office.	
				 eventResponse.setUserMessage(strResultMsg);
				 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				 throw new EventException(new ErrorHandler("SAP00062", new String[]{}).getMessage());
			 } else {
				 eventResponse.setUserMessage(strResultMsg);
				 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
				 throw new EventException(new ErrorHandler(ex).getMessage(), ex); 
			 }
			 
			//throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			if (!"ONE".equals(transactionFlag)) {
				rollback();
			 }
			 // 실패(오라클) 메세지 반환
			 if(ex.getMessage().length() > 100) {
				 strResultMsg = ex.getMessage().substring(0,100);		
			 } else {
				 strResultMsg = ex.getMessage();
			 }
			 eventResponse.setUserMessage(strResultMsg);
			 settingResultIF(eventResponse, ifSourceType, csrNo, strResultFlag, strResultMsg, transactionFlag );
			 //eventResponse.setETCData("SUCCESS_FLG", "FAIL");	 
			 //eventResponse.setETCData("RESULT_MSG", strResultMsg);	
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
    /**
	 * [STM_SAP_0250]
	 * Open Interface Invoices - settingResultIF <br> 
	 * @author ORKIM
	 * @param EventResponse eventResponse
	 * @param String ifSourceType
	 * @param String csrNo
	 * @param String flag
	 * @param String msg
	 * @param String transactionFlag
	 * @return EventResponse
	 * @exception EventException
    */
 	private void settingResultIF(EventResponse eventResponse, String ifSourceType, String csrNo, String flag, String msg, String transactionFlag) throws EventException {
	
 		
 		AccountPayableInvoiceBC apCommand = new AccountPayableInvoiceBCImpl();
		ConsultationSlipRequestMgtBC csrCommand = new ConsultationSlipRequestMgtBCImpl();
 		
		try {
			if(ifSourceType.equals("A/P")) {
				apCommand.manageAPInvoiceInterfaceResult(csrNo, msg); 
			} else if(ifSourceType.equals("S/O")) {
				csrCommand.manageSoInvoiceInterfaceResult(csrNo, msg); 
			}	
			eventResponse.setUserMessage(msg); 
			
		 	eventResponse.setETCData("SUCCESS_FLG", flag);	 
		 	eventResponse.setETCData("RESULT_MSG", msg);
		 	
		 	if (!"ONE".equals(transactionFlag)) {
				 commit();
			}
		 		
		} catch (EventException ex) {
			if (!"ONE".equals(transactionFlag)) {
				 rollback();
			}
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			if (!"ONE".equals(transactionFlag)) {
				 rollback();
			}
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
 	}
 	
	
    /**
	 * [STM_SAP_0250]
	 * callSAKURAPaymentIF<br> 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
	private EventResponse callSAKURAPaymentIF(Event e) throws EventException {		
		EventResponse apEventResponse = new GeneralEventResponse();
		//AccountPayablePaymentSC paySC = new AccountPayablePaymentSC();

		AccountPayableInvoiceBC apCommand = new AccountPayableInvoiceBCImpl();

						
		apCommand.callSAKURAPaymentIF();
        
		//paySC.manageAPIFPayment();
		return apEventResponse;
	}	
	
	/**
	 * [STM_SAP_0250]
	 * callASAInvoiceManualIF<br> 
	 * @author KSJO
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
	private EventResponse callASAInvoiceManualIF(Event e) throws EventException {		
		StmSap0250Event event = (StmSap0250Event) e;
		EventResponse apEventResponse = new GeneralEventResponse();

		AccountPayableInvoiceBC apCommand = new AccountPayableInvoiceBCImpl();
		
		String csrNo 			= event.getSapCommonVO().getValue5();
		
		apCommand.manageAsaClearingIF(csrNo);  //"BATCH"
        
		return apEventResponse;
	}
	
	/**
	 * [STM_SAP_0250]
	 * callSAKURAInvoiceIF<br> 
	 * @author KSJO
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
	private EventResponse callSAKURAInvoiceIF(Event e) throws EventException {		
		StmSap0250Event event = (StmSap0250Event) e;
		EventResponse apEventResponse = new GeneralEventResponse();
		AccountPayableInvoiceBC apCommand = new AccountPayableInvoiceBCImpl();

		String csrNo 			= event.getSapCommonVO().getValue2();
		String usrId            = account.getUsr_id();
				
		apCommand.manageInterfaceSAP(csrNo, usrId);

		return apEventResponse;
	}
	
	/**
	 * [STM_SAP_0250]
	 * callSAKURAInvoiceInvDateBaseIF<br> 
	 * @author KSJO
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
	private EventResponse callSAKURAInvoiceInvDateBaseIF(Event e) throws EventException {		
		StmSap0250Event event = (StmSap0250Event) e;
		EventResponse apEventResponse = new GeneralEventResponse();
		AccountPayableInvoiceBC apCommand = new AccountPayableInvoiceBCImpl();
		AccountPayableInvoiceBCImpl command = new AccountPayableInvoiceBCImpl();
		
		String invfromdt 		= event.getSapCommonVO().getValue3();
		String invtodt 			= event.getSapCommonVO().getValue4();
				
		try {
		
			List<SapCommonVO> rtnVoList = command.searchSakuraInterfaceCSRInfo(invfromdt, invtodt);
			
			if (rtnVoList != null ) {
				 
				 String usrId = account.getUsr_id();
				 for (int i=0; i<rtnVoList.size(); i++) {
					 
					 String csrNo = rtnVoList.get(i).getValue0();
					 apCommand.manageInterfaceSAP(csrNo, usrId);
				 }
			 }

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return apEventResponse;
	}
	
	/**
	* SAKURA I/F for PAYMENT - 0040의 Receipt Confirm 메소드의 기능을 SAKURA payment 에서 호출  
	* manageInvoiceReceiptInfo <br> 
	* @author ORKIM
	* @param InvoiceReceiptListVO[] invoiceReceiptListVOs
	* @param String usr_id
	* @param String ofc_cd
	* @exception EventException
	*/ 
	public void manageInvoiceReceiptInfo(InvoiceReceiptListVO[] invoiceReceiptListVOs, String usr_id, String ofc_cd) throws EventException {
		AccountPayableInvoiceBC command1 = new AccountPayableInvoiceBCImpl();
		AccountPayableCommonBC  command2 = new AccountPayableCommonBCImpl();
		
		String loclTm = "";
		try {
			 loclTm = command2.searchLocalTime(usr_id, ofc_cd);
			 command1.manageInvoiceReceiptInfo(invoiceReceiptListVOs, ofc_cd, loclTm,usr_id);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [STM_SAP_0150] Retrieve<br>
	 * AP Cost Accrual Interface retrieve<br> * 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse searchInvoiceAccrualList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0150Event event = (StmSap0150Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			List<InvoiceAccrualVO> list = command.searchInvoiceAccrualList(event.getInvoiceAccrualCondVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}		
	
	/**
	 * [STM_SAP_0250] Valid<br>
	 * isValidDate Valid<br> * 
	 * @author ORKIM
	 * @param String inputeDate
	 * @return boolean

	*/	
	private boolean isValidDate(String inputeDate) throws EventException {
		
		boolean rtnValue = false;
		if (inputeDate != null && !inputeDate.equals("") && inputeDate.length() == 8) {
			int yy = Integer.parseInt(inputeDate.substring(0,4));
			int mm = Integer.parseInt(inputeDate.substring(4,6));
			int dd = Integer.parseInt(inputeDate.substring(6,8));
			
			GregorianCalendar cal = new GregorianCalendar();
		    cal.set(yy, mm, dd);
		    try {
		    	cal.getTime();
		    } catch (IllegalArgumentException ex) {
		    	rtnValue = false;
		    	throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		    } 
		    rtnValue = true;

		} else {
			rtnValue = false;
		}
		return rtnValue;
	}
	
	/**
	 * [STM_SAP_0150] Accural I/F<br>
	 * AP Cost Accrual Interface I/F<br> * 
	 * @author KSJO
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
	private EventResponse manageInvoiceAccrualInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0150Event event = (StmSap0150Event)e;
		AccountPayableInvoiceBC command1 = new AccountPayableInvoiceBCImpl();
		CostAccrualBC           command2 = new CostAccrualBCImpl();
		
		try {
			 begin();
			 
			 for (int i=0; i<event.getInvoiceAccrualVOs().length; i++) {
				 APManualInvoiceAccuralCondVO apInvoiceAccrualCondVO = new APManualInvoiceAccuralCondVO();
				 
				 apInvoiceAccrualCondVO.setInvSeq(event.getInvoiceAccrualVOs()[i].getInvSeq());
				 apInvoiceAccrualCondVO.setGlYymm(event.getInvoiceAccrualVOs()[i].getGlDt().substring(0, 6));
				 apInvoiceAccrualCondVO.setCsrNo(event.getInvoiceAccrualVOs()[i].getInvNo());
				 apInvoiceAccrualCondVO.setUsrId(account.getUsr_id());
				 
				 command2.manageInvoiceAccrualSacInfo(apInvoiceAccrualCondVO);
				 
				 command1.modifyAPManualInvoiceAccrualFlag(apInvoiceAccrualCondVO);
				 
			 }
			 			 
			 eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			 
			 commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0150] Accural I/F Cancel<br>
	 * AP Cost Accrual Interface I/F<br> * 
	 * @author KSJO
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
	private EventResponse manageInvoiceAccrualCancelInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0150Event event = (StmSap0150Event)e;
		AccountPayableInvoiceBC command1 = new AccountPayableInvoiceBCImpl();
		CostAccrualBC           command2 = new CostAccrualBCImpl();
		
		try {
			 begin();
			 
			 for (int i=0; i<event.getInvoiceAccrualVOs().length; i++) {
				 APManualInvoiceAccuralCondVO apInvoiceAccrualCondVO = new APManualInvoiceAccuralCondVO();
				 
				 apInvoiceAccrualCondVO.setInvSeq(event.getInvoiceAccrualVOs()[i].getInvSeq());
				 apInvoiceAccrualCondVO.setGlYymm(event.getInvoiceAccrualVOs()[i].getGlDt().substring(0, 6));
				 apInvoiceAccrualCondVO.setCsrNo(event.getInvoiceAccrualVOs()[i].getInvNo());
				 apInvoiceAccrualCondVO.setUsrId(account.getUsr_id());
				 
				 command2.removeInvoiceAccrualSacInfo(apInvoiceAccrualCondVO); //modify 2016.08.19
				 
				 command1.modifyAPManualInvoiceAccrualCancelFlag(apInvoiceAccrualCondVO);
				 
			 }
			 			 
			 eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			 
			 commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
}