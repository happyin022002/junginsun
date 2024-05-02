/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountPayablePaymentSC.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.03.26
 *@LastModifier : sangyoung cha
 *@LastVersion : 1.0
 * 2014.03.03 authorName
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment;

import java.util.ArrayList;
import java.util.List;

import com.clt.framework.component.util.JSPUtil;

import com.clt.apps.opus.stm.sap.accountpayableinvoice.AccountPayableInvoiceSC;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic.AccountPayableInvoiceBC;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic.AccountPayableInvoiceBCImpl;

import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.basic.AccountPayablePaymentBC;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.basic.AccountPayablePaymentBCImpl;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.basic.AccountPayableCommonBC;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.basic.AccountPayableCommonBCImpl;
import com.clt.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic.ConsultationSlipRequestMgtBC;
import com.clt.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic.ConsultationSlipRequestMgtBCImpl;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBC;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBCImpl;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBC;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBCImpl;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0050Event;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0060Event;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0070Event;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0120Event;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0140Event;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0130Event;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0210Event;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0220Event;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0330Event;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentBANKExistsCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentBANKInfoCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentCSRInfoListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentProcessListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.BankAccountAdjustmentListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.BankBalanceByOfficeVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchEntryVendorSumInfoVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentDetailCurrSumListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentDetailListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentEntryLineVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentEntryVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentScheduleListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentSlipLineListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentSlipListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchSelectedListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APAccountingListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APTransactionVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceReceiptListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount; 


/**
 * AccountPayablePayment Business Logic ServiceCommand 
 * - Handling AccountPayablePayment Business transaction.
 * 
 * @author 
 * @see AccountPayablePaymentDBDAO
 * @since J2EE 1.6
 */ 
 
public class AccountPayablePaymentSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Precede AccountPayablePayment system <br>
	 *  Create Object when STM_SAP_payments job call<br>
	 */
	public void doStart() {
		try {
			//Checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());

		}
	}

	/**
	 * Follow AccountPayablePayment system<br>
	 * Release Object when STM_SAP_payments job end<br>
	 */
	public void doEnd() {
		log.debug("AccountPayablePaymentSC 종료");
	}

	/**
	 * proceeding job each Even<br>
	 *  Handling every Event on  AccountPayablePayment system<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("StmSap0050Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPaymentScheduleList(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("StmSap0070Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPaymentSlipList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPaymentSlipLineList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.PRINT)) {
				eventResponse = printPaymentSlipInfo(e);
			} 			
		}
		else if(e.getEventName().equalsIgnoreCase("StmSap0130Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBankBalanceByOffice(e);
			}			
		}
		else if(e.getEventName().equalsIgnoreCase("StmSap0120Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBankAccountAdjustmentList(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBankAccountAdjustment(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("StmSap0140Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInquiryofTransactionList(e);
			}			
		}
		else if(e.getEventName().equalsIgnoreCase("StmSap0330Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPaymentDetailList(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPaymentDetailCurrSumList(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("StmSap0060Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPaymentEntryList(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPaymentEntryLineList(e);
			}		
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchLineVendorPaymentNoDupCheck(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchPaymentStatusCheck(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = searchOffValiInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = searchPaymentApplyCheck(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = managePaymentEntryInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = managePaymentEntryVoid(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removePaymentEntryInfo(e);	
			}
		    else if (e.getFormCommand().isCommand(FormCommand.PRINT)) {
				eventResponse = printPaymentEntryInfo(e);
			} 
		}
		else if(e.getEventName().equalsIgnoreCase("StmSap0210Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPaymentBatchList(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPaymentBatchSelectedList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	//SEARCH INV DATA 
				eventResponse = searchPaymentPossibleInvoiceList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {	//BATCH SAVE
				eventResponse = managePaymentBatchEntryInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {	//TARGET SAVE
				eventResponse = managePaymentSelectedInvoiceInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {	//CAPTURE
				eventResponse = managePaymentCaptureInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {	//PAY CONFIRM
				eventResponse = managePaymentConfirmInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	//BATCH NAME CHECK
				eventResponse = searchPaymentBatchUniqueCheck(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {	//BANKACCOUNT, PAY METHOD CHECK
				eventResponse = selectPaymentProcessDupCheck(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("StmSap0220Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAPAccountingList(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {	//CAPTURE
				eventResponse = manageAccountingCaptureInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {	//CAPTURE CSR_NO
				eventResponse = manageAccountingCaptureCsrNo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {	//DELETE
				eventResponse = removeAccountingInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	//BACKENDJOB STATUS CHECK
				eventResponse = checkBackEndJob(e);
			}
		}
		return eventResponse;
	}
	

	/**
	 * [STM_SAP_0050] Retrieve<br>
	 * Payment Schedule Inquiry - Retrieve<br>
	 * @author Hannah Lee
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentScheduleList(Event e) throws EventException {
		
		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0050Event event = (StmSap0050Event) e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
				
		try {
			List<PaymentScheduleListVO> list = command.searchPaymentScheduleList(event.getPaymentScheduleCondVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * [STM_SAP_0070] Retrieve<br>
	 * Payment Slip - Payment Retrieve<br>
	 * @author Hannah Lee
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentSlipList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0070Event event = (StmSap0070Event) e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
				
		try {
			List<PaymentSlipListVO> list = command.searchPaymentSlipList(event.getPaymentSlipCondVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0070] Retrieve<br>
	 * Payment Slip - Payment Detail Retrieve<br>
	 * @author Hannah Lee
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentSlipLineList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0070Event event = (StmSap0070Event) e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
				
		try {
			List<PaymentSlipLineListVO> list = command.searchPaymentSlipLineList(event.getPaySeq());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0070] Print <br>
	 * Payment print <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse printPaymentSlipInfo(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    StmSap0070Event event = (StmSap0070Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			begin();
			if (event.getInvoicePrintVOs() != null ) { 
				for(int i=0; i < event.getInvoicePrintVOs().length; i++) {
					event.getInvoicePrintVOs()[i].setInvSeq(event.getInvoicePrintVOs()[i].getPaySeq());
				}
				
				String inv_rqst_seq = command.printInvoiceList(event.getInvoicePrintVOs(),  account, "SLIP");
				eventResponse.setETCData("INV_RQST_SEQ", inv_rqst_seq);
				eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			}
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
	 * [STM_SAP_0130] Retrieve<br>
	 * Inquiry of Bank Balance - Retrieve<br>
	 * @author Hannah Lee
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBankBalanceByOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0130Event event = (StmSap0130Event) e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
				
		try {
			List<BankBalanceByOfficeVO> list = command.searchBankBalanceByOffice(event.getBankBalanceByOfficeCondVO());
			eventResponse.setRsVoList(list);
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0330] Retrieve<br>
	 *  Retrieve Payment Detail<br>
	 * @author sangyoung cha
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0330Event event = (StmSap0330Event) e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
				
		try {
			List<PaymentDetailListVO> list = command.searchPaymentDetailList(event.getPaymentDetailListVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0330] Retrieve<br>
	 *  Retrieve Payment Detail Current Sum<br>
	 * @author sangyoung cha
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentDetailCurrSumList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0330Event event = (StmSap0330Event) e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
				
		try {
			List<PaymentDetailCurrSumListVO> list = command.searchPaymentDetailCurrSumList(event.getPaymentDetailCurrSumListVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0060] Retrieve<br>
	 *  Retrieve Payment Entry List<br>
	 * @author sangyoung cha
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentEntryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0060Event event = (StmSap0060Event) e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
				
		try {
			List<PaymentEntryVO> list = command.searchPaymentEntryList(event.getPaymentEntryVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [STM_SAP_0060] Retrieve<br>
	 * Payment LINE List retrieve<br> * 
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse searchPaymentEntryLineList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0060Event event = (StmSap0060Event)e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();

		try{
			List<PaymentEntryLineVO> list = command.searchPaymentEntryLineList(event.getPaySeq());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * [STM_SAP_0060] <br>
	 * searchLineVendorPaymentNoDupCheck (COMMAND01) <br>
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLineVendorPaymentNoDupCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0060Event event = (StmSap0060Event) e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
		
		try {
			
			SapCommonVO rtnVo = command.searchLineVendorPaymentNoDupCheck(event.getSapCommonVO());	
			eventResponse.setETCData("value0", rtnVo.getValue0());			
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0060] Save <br>
	 * Payment Entry save <br>
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse managePaymentEntryInfo(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0060Event event = (StmSap0060Event)e;
		AccountPayablePaymentBC payCommand = new AccountPayablePaymentBCImpl();
		AccountPayableInvoiceBC invCommand = new AccountPayableInvoiceBCImpl();
		
		try{
			begin();
			
			PaymentEntryVO[] paymentEntryVOs = event.getPaymentEntryVOs();
			PaymentEntryLineVO[] paymentEntryLineVOs = event.getPaymentEntryLineVOs();
			
			if (paymentEntryVOs != null ) {
				String paySeq = payCommand.managePaymentEntryInfo(paymentEntryVOs, account);
							
				if (paymentEntryLineVOs != null ) {
					List<PaymentEntryLineVO> insertVoListLine = new ArrayList<PaymentEntryLineVO>();
					List<PaymentEntryLineVO> updateVoListLine = new ArrayList<PaymentEntryLineVO>();
					List<PaymentEntryLineVO> deleteVoListLine = new ArrayList<PaymentEntryLineVO>();
					
					for (int i=0; i<paymentEntryLineVOs.length; i++) {
						
						paymentEntryLineVOs[i].setUsrId(account.getUsr_id());	
						if (paymentEntryLineVOs[i].getIbflag().equals("I")) {
							paymentEntryLineVOs[i].setPaySeq(paySeq);
							
							insertVoListLine.add(paymentEntryLineVOs[i]);
						} else if (paymentEntryLineVOs[i].getIbflag().equals("U")) {
							updateVoListLine.add(paymentEntryLineVOs[i]);
						} else if (paymentEntryLineVOs[i].getIbflag().equals("D")) {
							deleteVoListLine.add(paymentEntryLineVOs[i]);
						}
					}
					
					payCommand.managePaymentEntryLineInfo(insertVoListLine, updateVoListLine, deleteVoListLine);
					invCommand.managePaymentInvSkd(insertVoListLine);
					
					String csr_no = "";
					
					
					// SAVE 'D', VOID, DELETE 'P' 
					if (insertVoListLine != null ) {
						for(int i=0; i<insertVoListLine.size(); i++) {
							csr_no = insertVoListLine.get(i).getInvNo();
							manageSOInterface(csr_no, "D");
						}
					}
					
					if (updateVoListLine != null ) {
						for(int i=0; i<updateVoListLine.size(); i++) {
							csr_no = updateVoListLine.get(i).getInvNo();
							manageSOInterface(csr_no, "D");
						}
					}
					
					if (deleteVoListLine != null ) {
						for(int i=0; i<deleteVoListLine.size(); i++) {
							csr_no = deleteVoListLine.get(i).getInvNo();
							manageSOInterface(csr_no, "DEL");
						}
					}
					
				}
							
			}
						
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
	 * SO Interface <br>
	 * [STM_SAP_0060] Payment Entry : Save 'D', Delete, Void 'DEL' --> 'P' 로 내부 변환
	 * [STM_SAP_0210] Payment Batch : Pay Confirm 'D'
	 * [STM_SAP_0040] CSR Receipt : Reject 'J'
	 * 공통 CSR : flag 'D' - Payment, 'J' - Reject, 'P' - Delete, Void
	 * TRS : flag 'PD' - Payment, 'RJ' - Reject, 'IF' - Delete, Void
	 * @author ORKIM
	 * @param String csr_no
	 * @param String flag
	 * @exception EventException
	*/		
	public void manageSOInterface(String csr_no, String flag)  throws EventException {
		
		AccountPayablePaymentBC payCommand = new AccountPayablePaymentBCImpl();
		ConsultationSlipRequestMgtBC csrCommand = new ConsultationSlipRequestMgtBCImpl();
		CSRIssueTransferSlipManageBC trsCommand = new CSRIssueTransferSlipManageBCImpl();
		CARIssueTransferSlipManageBC tesCommand = new CARIssueTransferSlipManageBCImpl();
		
		try {			
			String srcCd = payCommand.searchInvHdrSrcCd(csr_no);
			
			
			String pay_dt = "";
			String pay_method = "";
			//String pay_amt = "";
			
			//Reject flag 는 payment 처리전이라 하기의 데이타가 없다.
			if(!flag.equals("J")) {
				String[] tmpData = payCommand.searchSAPToSOInterfaceData(csr_no);
				pay_dt 		= JSPUtil.getNull(tmpData[0]);
				pay_method 	= JSPUtil.getNull(tmpData[1]);
				//pay_amt 	= JSPUtil.getNull(tmpData[2]);
			}
			
			if(flag.equals("D")) {
				csrCommand.modifyAPInvoiceByStmSap(csr_no);  
				csrCommand.modifySoPayInvoiceInterface(csr_no, flag);
			} else if(flag.equals("P") || flag.equals("DEL")) {
				
				csrCommand.modifyAPInvoiceDeleteByStmSap(csr_no);
				csrCommand.modifySoPayInvoiceInterface(csr_no, "P");
			} else if(flag.equals("J")) {
				csrCommand.modifySoPayInvoiceInterface(csr_no, "J");
				csrCommand.modifyAPInvoiceRejectByStmSap(csr_no, "E", "CSR Receipt Error", "");				 
			}
			
			if(srcCd.equals("SO_TERMINAL")){				
				if(flag.equals("D")) {
					flag = "PD";
				} else if(flag.equals("P")) {
					flag = "RJ";
				} else if(flag.equals("DEL")) {
					flag = "IF";
				} else if(flag.equals("J")) {
					flag = "RJ";
				}									

				tesCommand.modifyTESInvHdrForPay(csr_no, flag, pay_dt);   
				
			}else if(srcCd.equals("SO_TRANS")){ 
				if(flag.equals("D")) {
					flag = "PD";
				} else if(flag.equals("P")) {
					flag = "RJ";
				} else if(flag.equals("DEL")) {
					flag = "IF";
				} else if(flag.equals("J")) {
					flag = "RJ";
				}									

				trsCommand.trsUpdateCSRInvAudSts(csr_no, flag, pay_dt, pay_method);    
			}			
			
			
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
		
	
	/**
	 * [STM_SAP_0060] <br>
	 * searchPaymentStatusCheck (COMMAND02) <br>
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentStatusCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0060Event event = (StmSap0060Event) e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
				
		try {
				
			eventResponse.setETCData("value0", command.searchPaymentStatusCheck(event.getSapCommonVO()));			
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	

	/**
	 * [STM_SAP_0060] <br>
	 * searchOffValiInfo (COMMAND03) <br>
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffValiInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0060Event event = (StmSap0060Event) e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			SapCommonVO rtnVo = command.searchOffValiInfo(event.getSapCommonVO().getValue0(), event.getSapCommonVO().getValue1(), account);
			if ( rtnVo != null ) {
				eventResponse.setETCData("ofc_cd", rtnVo.getValue0());		
				eventResponse.setETCData("so_if_cd",  rtnVo.getValue1());		//상계정산대리점인경우 'O'		
				eventResponse.setETCData("ap_ctr_cd",  rtnVo.getValue2());
				eventResponse.setETCData("finc_rgn_cd",  rtnVo.getValue3());
			} else {
				eventResponse.setETCData("ofc_cd", "NO_DATA");		
				eventResponse.setETCData("so_if_cd",  "NO_DATA");	
				eventResponse.setETCData("ap_ctr_cd",  "NO_DATA");	
				eventResponse.setETCData("finc_rgn_cd",  "NO_DATA");	
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [STM_SAP_0060] <br>
	 * searchPaymentApplyCheck (COMMAND04) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentApplyCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0060Event event = (StmSap0060Event) e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
		
		try {
		
			String applyYN = command.searchPaymentApplyCheck(event.getPaySeq());
			if ( applyYN != null ) {
				eventResponse.setETCData("apply_yn", applyYN);		
			} else {
				eventResponse.setETCData("apply_yn", "NO_DATA");		
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}			
	
	/**
	 * [STM_SAP_0060] Delete <br>
	 * Payment delete <br>
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse removePaymentEntryInfo(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0060Event event = (StmSap0060Event)e;
		AccountPayablePaymentBC payCommand = new AccountPayablePaymentBCImpl();
		AccountPayableInvoiceBC invCommand = new AccountPayableInvoiceBCImpl();
		
		try{
			begin();
			PaymentEntryVO[] paymentEntryVOs = event.getPaymentEntryVOs();
			PaymentEntryLineVO[] paymentEntryLineVOs = event.getPaymentEntryLineVOs();
			
			String csr_no = "";
			
			if (paymentEntryVOs != null ) {
				payCommand.removePaymentEntryInfo(paymentEntryVOs, account);
				
				List<PaymentEntryLineVO> voidVoLineList = new ArrayList<PaymentEntryLineVO>();
				if (paymentEntryLineVOs != null ) {
					for (int i=0; i<paymentEntryLineVOs.length; i++) {					
						paymentEntryLineVOs[i].setUsrId(account.getUsr_id());	
						csr_no = paymentEntryLineVOs[i].getInvNo();
						voidVoLineList.add(paymentEntryLineVOs[i]);	
						manageSOInterface(csr_no, "DEL");
						
					}
					if (voidVoLineList.size() > 0) {
						invCommand.managePaymentInvSkdCancel(voidVoLineList);
					}					
				}
			}
			
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
	 * [STM_SAP_0060] Void <br>
	 * Payment void <br>
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse managePaymentEntryVoid(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0060Event event = (StmSap0060Event)e;
		AccountPayablePaymentBC payCommand = new AccountPayablePaymentBCImpl();
		AccountPayableInvoiceBC invCommand = new AccountPayableInvoiceBCImpl();
		
		String csr_no = "";
		
		try{
			begin();
			PaymentEntryVO[] paymentEntryVOs = event.getPaymentEntryVOs();
			PaymentEntryLineVO[] paymentEntryLineVOs = event.getPaymentEntryLineVOs();
			
			if (paymentEntryVOs != null ) {
				payCommand.managePaymentEntryVoid(paymentEntryVOs, account);
				
				List<PaymentEntryLineVO> voidVoLineList = new ArrayList<PaymentEntryLineVO>();
				if (paymentEntryLineVOs != null ) {
					for (int i=0; i<paymentEntryLineVOs.length; i++) {					
						paymentEntryLineVOs[i].setUsrId(account.getUsr_id());	
						csr_no = paymentEntryLineVOs[i].getInvNo();
						voidVoLineList.add(paymentEntryLineVOs[i]);
						manageSOInterface(csr_no, "DEL");
					}
					if (voidVoLineList.size() > 0) {
						invCommand.managePaymentInvSkdCancel(voidVoLineList);
					}					
				}				
			}
			
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
	 * [STM_SAP_0060] Print <br>
	 * Payment print <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/	
	private EventResponse printPaymentEntryInfo(Event e) throws EventException {

	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    StmSap0060Event event = (StmSap0060Event)e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();

		try{
			begin();
			if (event.getInvoicePrintVOs() != null ) { 
				for(int i=0; i < event.getInvoicePrintVOs().length; i++) {
					event.getInvoicePrintVOs()[i].setInvSeq(event.getInvoicePrintVOs()[i].getPaySeq());
					event.getInvoicePrintVOs()[i].setCheckbox(event.getInvoicePrintVOs()[i].getChkFlg());
				}
				
				String inv_rqst_seq = command.printInvoiceList(event.getInvoicePrintVOs(),  account, "SLIP");
				eventResponse.setETCData("INV_RQST_SEQ", inv_rqst_seq);
				eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			}
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
     * [STM_SAP_0210] - SEARCH 
     * Payment Batches<br>
     * @author KIM OK RYE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */	
	private EventResponse searchPaymentBatchList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0210Event event = (StmSap0210Event)e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();

		try{
			List<PaymentBatchListVO> list = command.searchPaymentBatchList(event.getPaymentBatchCondVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}


	/**
     * [STM_SAP_0210] - SEARCH02 
     * Payment Batches<br>
     * @author KIM OK RYE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */	
	private EventResponse searchPaymentBatchSelectedList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0210Event event = (StmSap0210Event)e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();

		try{
			List<PaymentBatchSelectedListVO> list = command.searchPaymentBatchSelectedList(event.getPayBatSeq(), event.getPayBatNm());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
     * [STM_SAP_0210] - SEARCH03
     * Payment Batches<br>
     * @author KIM OK RYE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */	
	private EventResponse searchPaymentPossibleInvoiceList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0210Event event = (StmSap0210Event)e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();

		try{
			List<PaymentBatchSelectedListVO> list = command.searchPaymentPossibleInvoiceList(event.getInvNo()
					                                                                       , event.getPayBatSeq()
					                                                                       , event.getPayBatNm());
			eventResponse.setRsVoList(list);
			if(list != null && list.size() > 0) {
				eventResponse.setETCData(list.get(0).getColumnValues());
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
     * [STM_SAP_0210]  - MULTI01 
     * Payment Batches<br>
     * @author KIM OK RYE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */	
	private EventResponse managePaymentBatchEntryInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0210Event event = (StmSap0210Event)e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();

		try{
			
			begin();
			String pay_bat_seq = command.managePaymentBatchEntryInfo(event.getPaymentBatchListVOs() ,account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
			eventResponse.setETCData("pay_bat_seq", pay_bat_seq);
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
     * [STM_SAP_0210] - MULTI02  
     * Payment Batches<br>
     * @author KIM OK RYE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */	
	private EventResponse managePaymentSelectedInvoiceInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0210Event event = (StmSap0210Event)e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
		AccountPayableInvoiceBC invCommand = new AccountPayableInvoiceBCImpl();

		try{
			begin();
			command.managePaymentSelectedInvoiceInfo(  	  event.getPaymentBatchListVOs()
					                                 	, event.getPaymentBatchSelectedListVOs()
					                                 	, event.getFunctionalCurrency()
					                                 	, account);
			invCommand.managePaymentSelectedInvoiceInfo(  event.getPaymentBatchListVOs()
                    								 	, event.getPaymentBatchSelectedListVOs()
                    								 	, event.getFunctionalCurrency()
                    								 	, account);
			commit();
			
			eventResponse.setETCData("pay_bat_seq", event.getPaymentBatchListVOs()[0].getPayBatSeq());
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			
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
     * [STM_SAP_0210] - MULTI03
     * Payment Batches<br>
     * @author KIM OK RYE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */	
	private EventResponse managePaymentCaptureInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0210Event event = (StmSap0210Event)e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
		AccountPayableInvoiceBC invCommand = new AccountPayableInvoiceBCImpl();
		
		try{			
			begin();
			String pay_sts_cd = command.managePaymentCaptureInfo(       event.getPaymentBatchListVOs()
					                                        , event.getPaymentBatchSelectedListVOs()
					                                        , event.getFunctionalCurrency()
					                                    	, account);
			if ( pay_sts_cd != null && pay_sts_cd.equals("CAPTURE") ) {

				invCommand.managePaymentCaptureInfo(	event.getPaymentBatchListVOs()
	                    							  , event.getPaymentBatchSelectedListVOs()
	                    							  , event.getFunctionalCurrency()
	                    							  , account);
				eventResponse.setETCData("pay_sts_cd", pay_sts_cd);
			}
			commit();
			
			eventResponse.setETCData("pay_bat_seq", event.getPaymentBatchListVOs()[0].getPayBatSeq());			
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			
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
     * [STM_SAP_0210]  - MULTI04
     * Payment Batches<br>
     * @author KIM OK RYE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */	
	private EventResponse managePaymentConfirmInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0210Event event = (StmSap0210Event)e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
		AccountPayableInvoiceBC invCommand = new AccountPayableInvoiceBCImpl();
		AccountPayableCommonBC  comCommand = new AccountPayableCommonBCImpl();
		
		int cnt = 0;
		try{
			begin();
			
			String functional_currency = comCommand.searchFunctionalCurrencyCode().get(0).getValue0();
			
			cnt = command.managePaymentConfirmInfoCheck(     event.getPaymentBatchListVOs()
																, event.getPaymentBatchSelectedListVOs()
																, event.getFunctionalCurrency()
																, account);
			
			if (cnt > 0) {
				
				List<PaymentBatchEntryVendorSumInfoVO> list = command.searchPaymentBatchEntryVendorSumInfo( 
						                                                     event.getPaymentBatchListVOs()[0].getPayBatSeq()
						                                                    ,event.getPaymentBatchListVOs()[0].getPayBatNm() );
				List<PaymentBatchEntryVendorSumInfoVO> list2 = command.managePaymentConfirmInfo( list, functional_currency, account );
				
				List<PaymentBatchEntryVendorSumInfoVO> sumList = new ArrayList<PaymentBatchEntryVendorSumInfoVO>();
				sumList.add(list2.get(0));
				invCommand.managePaymentConfirmInfo( sumList);
				
				//개별 csr_no 에 따라 어디에서 온 데이타인지 파악하여 각 so 업무에 paid 정보 세팅.
				List<PaymentEntryLineVO> list3 = command.searchSAPToSOInterfaceDataBatch(list.get(0).getPayBatSeq(), list.get(0).getPayBatNm(), list.get(0).getVndrNo());
				String csr_no = "";
				if(list3 != null && list3.size() > 0) {
					for(int i=0; i<list3.size(); i++) {
						csr_no = list3.get(i).getInvNo();
						manageSOInterface(csr_no, "D");
					}
				}
				
				command.removePaymentSelectedInvoiceAllInfo( sumList );
 			} 
			
			eventResponse.setETCData("cnt", cnt + "");
			eventResponse.setETCData("pay_bat_seq", event.getPaymentBatchListVOs()[0].getPayBatSeq());
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
     * [STM_SAP_0210]  - COMMAND01
     * Payment Batches<br>
     * @author KIM OK RYE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */	
	private EventResponse searchPaymentBatchUniqueCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0210Event event = (StmSap0210Event)e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();

		try{
			String rtnVal = command.searchPaymentBatchUniqueCheck(event.getPayBatNm());
			if (rtnVal == null) {
				eventResponse.setETCData("pay_bat_nm", event.getPayBatNm());
			} else {
				eventResponse.setETCData("pay_bat_nm", "");
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
     * [STM_SAP_0210]  - COMMAND02
     * Payment Batches<br>
     * @author KIM OK RYE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */	
	private EventResponse selectPaymentProcessDupCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0210Event event = (StmSap0210Event)e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();

		try{
			String rtnVal = command.selectPaymentProcessDupCheck(event.getSapCommonVO().getValue1(), event.getSapCommonVO().getValue2());
			if (rtnVal == null) {
				eventResponse.setETCData("cnt", "0");
			} else {
				eventResponse.setETCData("cnt", rtnVal);
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
     * [STM_SAP_0220]  - SEARCH
     * Payment Batches<br>
     * @author KIM OK RYE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */	
	private EventResponse searchAPAccountingList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0220Event event = (StmSap0220Event)e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();

		try{
			List<APAccountingListVO> list = command.searchAPAccountingList(event.getAccountingCondVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
     * [STM_SAP_0220]  - MULTI01
     * Capture Period<br>
     * @author KIM OK RYE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */	
	private EventResponse manageAccountingCaptureInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0220Event event = (StmSap0220Event)e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();

		try{
			begin();
			String backEndJobKey = command.manageAccountingCaptureInfo(event.getCapturePeriod(), account.getUsr_id());
			commit();
			eventResponse.setETCData("BackEndJobKey", backEndJobKey);
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
     * [STM_SAP_0220]  - MULTI02
     * Capture Period per CSRNo<br>
     * @author KIM OK RYE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */	
	private EventResponse manageAccountingCaptureCsrNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0220Event event = (StmSap0220Event)e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();

		try{
			begin();
			command.manageAccountingCaptureCsrNo(event.getCsrNo(), account.getUsr_id());
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
     * [STM_SAP_0220]  - REMOVE01
     * DELETE<br>
     * @author KIM OK RYE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */	
	private EventResponse removeAccountingInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0220Event event = (StmSap0220Event)e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
		AccountPayableInvoiceBC invCommand = new AccountPayableInvoiceBCImpl();
		
		try{
			begin();
			List<APAccountingListVO> updateVoList = new ArrayList<APAccountingListVO>();
			for (int i=0; i<event.getaPAccountingListVOs().length; i++) {
				event.getaPAccountingListVOs()[i].setUsrId(account.getUsr_id());
				updateVoList.add(event.getaPAccountingListVOs()[i]);
			}
			
			if (updateVoList.size() > 0 && (  updateVoList.get(0).getAcctgEvntTpCd().equals("PAYMENT") ||  updateVoList.get(0).getAcctgEvntTpCd().equals("PAYMENT CANCELLATION") ) ) { 
				command.modifyAccountingDetailPaymentLineRestore(updateVoList);
			} else {
				invCommand.modifyAccountingDetailInvoiceLineRestore(updateVoList);
			}
			command.removeAccountingInfo(updateVoList);
			
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
     * [STM_SAP_0220]  - COMMAND01
     * After Capture Period - backendjob status check <br>
     * @author KIM OK RYE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */	
	private EventResponse checkBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0220Event event = (StmSap0220Event)e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
		
		try{
			
			String[] result = command.checkBackEndJob(event.getBackEndJobKey());
			eventResponse.setETCData("jb_sts_flg",		result[0]);
			eventResponse.setETCData("jb_usr_err_msg",	result[1]);
			
		}catch(EventException ex){
			throw ex;
		}
		return eventResponse;
	}	

	/**
	 * [STM_SAP_0120]
	 * Bank Balance Adjustment - retrieve<br> 
	 * @author JBLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
   */
   private EventResponse searchBankAccountAdjustmentList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0120Event event = (StmSap0120Event) e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
		
		try {
			List<BankAccountAdjustmentListVO> list = command.searchBankAccountAdjustmentList(event.getBankBalanceByOfficeCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
   
	/**
	 * [STM_SAP_0120]
	 * Bank Balance Adjustment - retrieve<br> 
	 * @author JBLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
   */
   private EventResponse manageBankAccountAdjustment(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0120Event event = (StmSap0120Event) e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
		
		try {
			 begin();
			 command.manageBankAccountAdjustment(event.getBankBalanceAdjustmentListVOs(), account.getUsr_id());
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
	 * [STM_SAP_0140]
	 * Inquiry of Transaction - retrieve<br> 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
  */
  private EventResponse searchInquiryofTransactionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0140Event event = (StmSap0140Event) e;
		AccountPayablePaymentBC command = new AccountPayablePaymentBCImpl();
		
		try {
			List<APTransactionVO> list = command.searchInquiryofTransactionList(event.getAPTransactionCondVO());
			eventResponse.setRsVoList(list);
			
			if(list != null && list.size() > 0) {
				eventResponse.setETCData("CURR_POINT",	list.get(0).getCurrPoint());
			} else {
				eventResponse.setETCData("CURR_POINT",	"0");
			}
			
			eventResponse.setETCData("BEGINING_AMOUNT",	command.searchInquiryofTrxBeginBalance(event.getAPTransactionCondVO()));
			
			String[] result = command.searchInquiryofTransactionSum(event.getAPTransactionCondVO());
			eventResponse.setETCData("PAYMENT_AMOUNT",	result[0]);
			eventResponse.setETCData("RECEIPT_AMOUNT",	result[1]);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	} 
  
	/**
	* SAKURA I/F for PAYMENT  
	* manageAPIFPayment <br> 
	* @author ORKIM
	* @exception EventException
	*/ 
	public void manageAPIFPayment() throws EventException {
		try {
			
			AccountPayableInvoiceBC invCommand = new AccountPayableInvoiceBCImpl();
			AccountPayablePaymentBC payCommand = new AccountPayablePaymentBCImpl();
			AccountPayableCommonBC  comCommand = new AccountPayableCommonBCImpl();
			
			String result_flag = "E";

			List<APIFPaymentProcessListVO> ifProcessVOList  = payCommand.searchAPIFPaymentProcessList();
			
			String payment_batch_name = payCommand.searchAPPaymentBatchProcessName();
			
			if(ifProcessVOList != null && ifProcessVOList.size() > 0 ) {
				
				List<PaymentEntryVO> payEntryVOList = new ArrayList<PaymentEntryVO>();
				List<PaymentEntryLineVO> payEntryLineVOList = new ArrayList<PaymentEntryLineVO>();
				List<APIFPaymentProcessListVO> processList = new ArrayList<APIFPaymentProcessListVO>();
				
				for(int i=0; i < ifProcessVOList.size(); i++ ) {
					//begin();	
					//단건씩 처리하기 위해 초기화를 시킨다.
					payEntryVOList.clear();
					payEntryLineVOList.clear();
					processList.clear();
					APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO = null;

					List<APIFPaymentCSRInfoListVO> APIFPaymentCSRInfoListVOs  = payCommand.searchAPIFPaymentCSRInfoList(ifProcessVOList.get(i));
					
					if (APIFPaymentCSRInfoListVOs != null && APIFPaymentCSRInfoListVOs.size() > 0) { 
						aPIFPaymentCSRInfoListVO = APIFPaymentCSRInfoListVOs.get(0);
					}
					
					if(aPIFPaymentCSRInfoListVO != null && aPIFPaymentCSRInfoListVO.getInvSeq() != null && !aPIFPaymentCSRInfoListVO.getInvSeq().equals("")) {
						
						if(aPIFPaymentCSRInfoListVO.getPayStsFlg().equals("N")) {
							List<APIFPaymentBANKExistsCheckVO> APIFPaymentBANKExistsCheckVOs  = payCommand.searchAPIFPaymentBANKExistsCheck(aPIFPaymentCSRInfoListVO);
						
							//계좌 미존재시 Insert 처리
							if(APIFPaymentBANKExistsCheckVOs == null || APIFPaymentBANKExistsCheckVOs.size() == 0 ) {
						
								//String bank_account_id = comCommand.searchBankAccountSequenceInfo();
								BankAccountListVO bankAcctVO = new BankAccountListVO();
								//bankAcctVO.setBankAcctSeq(bank_account_id); 
								bankAcctVO.setBankAcctNm("VIRTUAL" + aPIFPaymentCSRInfoListVO.getInvPayCurrCd());
								bankAcctVO.setBankAcctNo("VIRTUAL" + aPIFPaymentCSRInfoListVO.getInvPayCurrCd());
								bankAcctVO.setBankBrncSeq("90000");
								bankAcctVO.setCurrCd(aPIFPaymentCSRInfoListVO.getInvPayCurrCd());
								bankAcctVO.setBankAcctTpNm("INTERNAL");
								bankAcctVO.setMltCurrFlg("Y");
								bankAcctVO.setAcctTpCd("P");
								bankAcctVO.setBankAcctAltnNm("VIRTUAL" + aPIFPaymentCSRInfoListVO.getInvPayCurrCd());
								bankAcctVO.setBankAcctStDt(aPIFPaymentCSRInfoListVO.getSysToday());
								bankAcctVO.setUsrId(aPIFPaymentCSRInfoListVO.getUsrId());
								
								comCommand.addBankAccountEntry(bankAcctVO);
							}
							
							//계좌정보가져오기
							APIFPaymentBANKInfoCheckVO aPIFPaymentBANKInfoCheckVO = payCommand.searchAPIFPaymentBANKInfoCheck(aPIFPaymentCSRInfoListVO).get(0);
							
							//Payment Header
							PaymentEntryVO paymentEntryVO = new PaymentEntryVO();
							String payment_seq = payCommand.searchNextPaySeq();
							paymentEntryVO.setPaySeq(payment_seq);
							paymentEntryVO.setBankAcctSeq(aPIFPaymentBANKInfoCheckVO.getBankAcctSeq());
							paymentEntryVO.setBankAcctNm(aPIFPaymentBANKInfoCheckVO.getBankAcctNm());
							paymentEntryVO.setPayDt(aPIFPaymentCSRInfoListVO.getAcctgDt());
							String payNo = ""; //ifProcessVOList.get(i).getVoucherNo().length() > 10 ? ifProcessVOList.get(i).getVoucherNo().substring(0,10) : ifProcessVOList.get(i).getVoucherNo();
							paymentEntryVO.setPayNo(payNo);
							paymentEntryVO.setPayTpCd("B");
							paymentEntryVO.setPayAmt(aPIFPaymentCSRInfoListVO.getPayAmt());
							paymentEntryVO.setCurrCd(aPIFPaymentCSRInfoListVO.getInvPayCurrCd());
							paymentEntryVO.setPayMzdLuCd(aPIFPaymentCSRInfoListVO.getPayMzdLuCd());
							paymentEntryVO.setVndrNm(aPIFPaymentCSRInfoListVO.getVndrNm());
							paymentEntryVO.setBankAcctNo(aPIFPaymentBANKInfoCheckVO.getBankAcctNo());
							paymentEntryVO.setVndrNo(aPIFPaymentCSRInfoListVO.getVndrNo());
							paymentEntryVO.setPayXchRt(aPIFPaymentCSRInfoListVO.getPayXchRt());
							paymentEntryVO.setPayXchDt(aPIFPaymentCSRInfoListVO.getPayXchDt());
							paymentEntryVO.setPayFuncAmt(aPIFPaymentCSRInfoListVO.getPayFuncAmt());
							paymentEntryVO.setXterBankAcctSeq(aPIFPaymentCSRInfoListVO.getXterBankAcctSeq());
							paymentEntryVO.setOfcCd(aPIFPaymentCSRInfoListVO.getOfcCd());
							paymentEntryVO.setPayBatNm(payment_batch_name);
							paymentEntryVO.setUsrId(aPIFPaymentCSRInfoListVO.getUsrId());
							
							payEntryVOList.add(paymentEntryVO);				
							
							//Payment Line
							PaymentEntryLineVO paymentEntryLineVO = new PaymentEntryLineVO();
							
							paymentEntryLineVO.setPaySeq(payment_seq);
							paymentEntryLineVO.setInvSeq(aPIFPaymentCSRInfoListVO.getInvSeq());
							paymentEntryLineVO.setInvNo(aPIFPaymentCSRInfoListVO.getCsrNo());
							paymentEntryLineVO.setAcctgDt(aPIFPaymentCSRInfoListVO.getAcctgDt());
							paymentEntryLineVO.setPayAmt(aPIFPaymentCSRInfoListVO.getPayAmt());
							paymentEntryLineVO.setPayFuncAmt(aPIFPaymentCSRInfoListVO.getPayFuncAmt());
							paymentEntryLineVO.setLiabCdCmbSeq(aPIFPaymentCSRInfoListVO.getLiabCdCmbSeq());
							paymentEntryLineVO.setXterBankAcctSeq(aPIFPaymentCSRInfoListVO.getXterBankAcctSeq());
							paymentEntryLineVO.setPaySkdNo(aPIFPaymentCSRInfoListVO.getPaySkdNo());
							paymentEntryLineVO.setUsrId(aPIFPaymentCSRInfoListVO.getUsrId());
							
							payEntryLineVOList.add(paymentEntryLineVO);
							
							//Receipt Check
							if(aPIFPaymentCSRInfoListVO.getAttrCtnt13().equals("") || !aPIFPaymentCSRInfoListVO.getApApstsCd().equals("MANUALLY APPROVED")) {
								AccountPayableInvoiceSC invSC = new AccountPayableInvoiceSC();
								
								InvoiceReceiptListVO[] invoiceReceiptListVOs = new InvoiceReceiptListVO[1];
								invoiceReceiptListVOs[0] = new InvoiceReceiptListVO();
								invoiceReceiptListVOs[0].setInvSeq(aPIFPaymentCSRInfoListVO.getInvSeq());
								invoiceReceiptListVOs[0].setInvCurrCd(aPIFPaymentCSRInfoListVO.getInvPayCurrCd());
								invoiceReceiptListVOs[0].setUsrId(aPIFPaymentCSRInfoListVO.getUsrId());
								
								invSC.manageInvoiceReceiptInfo(invoiceReceiptListVOs,aPIFPaymentCSRInfoListVO.getUsrId(), aPIFPaymentCSRInfoListVO.getOfcCd() );
								
							}
							
							//Payment Insert, Invoice Update
							payCommand.addPaymentHeader(payEntryVOList);
							payCommand.addPaymentLine(payEntryLineVOList);
							invCommand.modifyPaymentInvoice(payEntryLineVOList);
							invCommand.modifyPaymentSchedule(payEntryLineVOList);
							
							//SO I/F update
							manageSOInterface(aPIFPaymentCSRInfoListVO.getCsrNo(), "D");	
						}
						
						result_flag = "S";
					} else {
						result_flag = "E";
					}
					
					ifProcessVOList.get(i).setDatRsltFlg(result_flag);
					processList.add(ifProcessVOList.get(i));
					
					//Result Update
					payCommand.modifyAPIFPaymentStatus(processList);
	
					//commit();
	
				} // end of for
			} // end of if
	
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	} 

}
