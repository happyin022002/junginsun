/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TimeCharterInOutAccountingSC.java
*@FileTitle : Contract
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.fms.fmscommonutil.BizComFmsUtil;
import com.clt.apps.opus.esm.fms.fmscommonutil.FmsConstants;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.basic.TCharterIOBasicRegisterBC;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.basic.TCharterIOBasicRegisterBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0003Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0004Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0005Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0006Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0037Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0038Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0068Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0069Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0070Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0076Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0085Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomAcctCateVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomAcctItmVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomOwnerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomVvdVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchAccountItemListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchEmailAddressListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchFinalRevenueVvdListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchFinanVvdListByChaterSdmsVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchOwnerNameListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenuePortListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenueVvdInquiryListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenueVvdListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchVendorCustomerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchVvdCreationListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.basic.TCharterIOBunkerRegisterBC;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.basic.TCharterIOBunkerRegisterBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.event.EsmFms0027Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.event.EsmFms0050Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.CustomBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchIdVslCdByBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchVvdByBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBC;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0021Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0032Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms00331Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0033Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms00401Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0040Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0041Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0042Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0043Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0044Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0045Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0052Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0086Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0087Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomConsultationVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamConsultationVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchArSlipDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchBrokerageListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchCustomerCodeVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchInvoiceNoListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchManualSlipListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchPaymentSlipListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchPaymentSlipMasterVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchReverseCsrForSubletListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchReverseCsrForSubletSaveListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipCorrectionDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipCorrectionListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletRevenueListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletRevenueSlipListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletReveuneDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchTaxDetailEvidenceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchTaxMasterEvidenceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchVvdListByManualSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.basic.TCharterIOContractBC;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.basic.TCharterIOContractBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.event.EsmFms0001Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.event.EsmFms0002Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.event.EsmFms0023Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.ContractContainerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.FileCountVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchCharterPtyFileListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContracNoListByVesselVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByCharterVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByPrepaymentVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractListByPrepaymentHireNoVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractTypeCodeVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractTypeListByContractVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchFileCertificationListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchHireListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchHireSysDateVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchIdVslListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOtrExpnListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOtrExpnSysDateListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOwnerNameVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchPayTermListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.TCharterIOContractVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.basic.TCharterIOEstimatedBC;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.basic.TCharterIOEstimatedBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.event.EsmFms0046Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.event.EsmFms0048Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.event.EsmFms0049Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.CustomEstmIfVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedRevenueListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.basic.TCharterIOInvoiceBC;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.basic.TCharterIOInvoiceBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0012Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0014Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0016Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0017Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0018Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0024Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0025Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0026Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0028Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0034Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0075Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0078Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0079Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSdmsSettlementVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSendEmailVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.InvoiceContainerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchChaterInvoiceSdmsListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchInvoiceListByRevenueSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireSelectionListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceAutoMatchListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentHireNoListSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentHireNoListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVvdListByCharterVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVvdListByOffHireVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.basic.TCharterIOSettlementBC;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.basic.TCharterIOSettlementBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.event.EsmFms0035Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.event.EsmFms0074Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchInvoiceByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleVvdListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.AccountPayableInvoiceSC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.basic.StevedoreDamageMgtBC;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.basic.StevedoreDamageMgtBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-TimeCharterInOutAccounting Business Logic ServiceCommand
 * 
 * @author 
 * @see ITCharterIOContractDBDAO, TCharterIOBunkerRegisterDBDAO, TCharterIOBasicRegisterDBDAO
 * @since J2EE 1.5
 */

public class TimeCharterInOutAccountingSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Prework for TimeCharterInOutAccounting system business scenario<br>
	 * Generating inner-object when Contract business scenario<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
		}
	}

	/**
	 * Closing work for TimeCharterInOutAccounting system business scenario<br>
	 * Terminating related inner-object when finishing Contract business scenario<br>
	 */
	public void doEnd() {
		log.debug("TimeCharterInOutAccountingSC 종료");
	}

	/**
	 * Branch processing of all events generated in OPUS-TimeCharterInOutAccounting system<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// Required to use in case SC handles several events (separated by event unit)
		if(e.getEventName().equalsIgnoreCase("EsmFms0001Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContract(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContractByPrepayment(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchContractByOffHire(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchOwnerName(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchStandardCodeListByContract();
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchContractByCharter(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchContractListByPrepaymentHireNo(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = createContract(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageContract(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeContract(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0002Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgreement(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0003Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccountCateList();
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageAccountCate (e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0004Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVendorCodeList();
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageVendorCode(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0005Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomerCodeList();
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageCustomerCode(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0006Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOwnerList();
			    
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchOwnerTypeCodeList();
			
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
			    eventResponse = searchStandardCodeList(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageOwner(e);
			}			
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0012Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCalPrepaymentInvoiceList(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPrepaymentInvoiceList(e);
			
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchHireNo(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = creatPrepaymentInvoice(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = managePrepaymentInvoice(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removePrepaymentInvoice(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0014Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCalOffhireInvoiceList(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOffhireInvoiceList(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVvdListByOffHire(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOffhireInvoice(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeOffhireInvoice(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0016Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCharterInvoiceList(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVvdListByCharter(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCharterInvoice(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0017Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChaterInvoiceSdmsList(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkSdmsInvoiceNo(e);
				
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0018Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchOwnerInvoiceList(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchOwnerInvoiceAutoMatchList(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = modifyOwnerInvoice(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0021Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContracNoListByVessel(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkCenterCode(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkVvdCode(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePaymentSlip(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPaymentSlipByCsrNo(e);				
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0023Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContracNoListByVessel(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContractTypeListByContract(e);
			}			
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0026Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffhireListByPaymentSlip(e);
			}
			
		}  else if(e.getEventName().equalsIgnoreCase("EsmFms0027Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBunkerListByPaymentSlip(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0032Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSubletRevenueSlip(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCustomerCode(e);
			}
		
		}
		else if(e.getEventName().equalsIgnoreCase("EsmFms0024Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPrepaymentListByPaymentSlip(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0025Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCharterListByPaymentSlip(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0026Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffhireListByPaymentSlip(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0027Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBunkerListByPaymentSlip(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0028Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOwnerListByPaymentSlip(e);
			}
	    } else if(e.getEventName().equalsIgnoreCase("EsmFms0035Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchInvoiceByPaymentSlip(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = managePrepaymentSettlement(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0033Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchReverseCsrForSubletList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageReverseCsrForSublet(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsmFms00331Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchInvoiceNoList(e);
			}
		
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0034Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPrepaymentListByRevenueSlip(e);
			}

		} else if(e.getEventName().equalsIgnoreCase("EsmFms0037Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchRevenueVvdList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchVvdCreationList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
			    eventResponse = searchFinalRevenueVvdList (e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageRevenueVvd(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0038Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchRevenueVvdInquiryList(e);
			}			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0040Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManualSlip(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsmFms00401Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchBrokerageList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVvdListByManualSlip(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0041Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSlipApprovalList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = rejectConsultation(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0042Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSlipDetailList(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0043Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSlipCorrectionList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = modifySlipCorrection(e);
			}

		} else if(e.getEventName().equalsIgnoreCase("EsmFms0044Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSlipCorrectionDetailList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = modifySlipDetailCorrection(e);
			}

		} else if(e.getEventName().equalsIgnoreCase("EsmFms0045Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchSubletReveuneList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchSubletReveuneDetailList(e);
			}			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0046Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchEstimatedRevenueCreList(e); 	// Create Action
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = createEstimatedHireRevenue(e);			// Save Action.
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchEstimatedResultByHireList(e);// Retriev Action : 등록된 Estimate 조회.
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0048Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchEstimatedProRevenueList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = createEstimatedProRevenue(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchEstimatedResultByProList(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0049Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEstimatedHireResultList(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0050Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBunkerList(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchIdVslCdListByBunker(e);	
			
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVvdListByBunker(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkLocCdByBunker(e);
			
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchContractTypeCode(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchStandardCodeListByBunker();
				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBunker(e);
			}			
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0068Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRevenuePortList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRevenuePort(e);
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeAllRevenuePort(e);
			}
		
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0069Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccountItemDetailList();
			    
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = checkAccountCode(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageAccountItemName(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0070Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVendorCustomerList(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVendorCustomerName(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0074Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchPrepaymentSettleList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchPrepaymentSettleVvdList(e);
			}		
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0075Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searhAttachFileKey(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0076Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccountItemList(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkCurrencyCode(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFinanVvdListByChaterSdms(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0078Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffhireSelectionList(e);
			}
		
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0079Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = sendEmail(e);
			}	
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0083Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOwnerNameList();
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0084Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchEmailAddressList(e);
			} 
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0085Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchEmailAddressList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageEmailAddress(e);
			} 
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0086Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchTaxEvidence(e);
			}								 
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0052Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSlipApprovalList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageSlipApproval(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0087Event")) {//2015.11.27 Add
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchConsultationSlipList(e);
			}
		}

		return eventResponse;
	}
	
	/**
	 * Retrieving a prepayment contract<br>
	 * Getting Contract Type/Owner Code/Owner Name/Duration/Hire Information/Other(s) Lump sum information for CtrtNo on Prepayment window<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractByPrepayment(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			ContractContainerVO contractContainerVO = command.searchContractByPrepayment(event.getFletCtrtNo());
			
			SearchContractByPrepaymentVO searchContractByPrepaymentVO = contractContainerVO.getSearchContractByPrepaymentVO();
			SearchHireSysDateVO searchHireSysDateVO = contractContainerVO.getSearchHireSysDateVO();
			List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = contractContainerVO.getSearchOtrExpnSysDateListVOs();

			Map<String,String> etcData = new HashMap<String,String>();
			
			//********************** Getting CONTRACT table data(START) **********************//
			
			if(searchContractByPrepaymentVO != null) {
				eventResponse.setETCData("fletCtrtNo",searchContractByPrepaymentVO.getFletCtrtNo());
				eventResponse.setETCData("vslCd",searchContractByPrepaymentVO.getVslCd());
				eventResponse.setETCData("vslEngNm",searchContractByPrepaymentVO.getVslEngNm());
				eventResponse.setETCData("fletCtrtTpCd",searchContractByPrepaymentVO.getFletCtrtTpCd());
				eventResponse.setETCData("custCntCd",searchContractByPrepaymentVO.getCustCntCd());
				eventResponse.setETCData("custSeq",searchContractByPrepaymentVO.getCustSeq());
				eventResponse.setETCData("vndrLglEngNm",searchContractByPrepaymentVO.getVndrLglEngNm());
				eventResponse.setETCData("ownrNm",searchContractByPrepaymentVO.getOwnrNm());
				eventResponse.setETCData("effDt",searchContractByPrepaymentVO.getEffDt());
				eventResponse.setETCData("fromTime",searchContractByPrepaymentVO.getFromTime());
				eventResponse.setETCData("expDt",searchContractByPrepaymentVO.getExpDt());
				eventResponse.setETCData("toTime",searchContractByPrepaymentVO.getToTime());
				eventResponse.setETCData("invUsdDys",searchContractByPrepaymentVO.getInvUsdDys());
				eventResponse.setETCData("acmmRtAmt",searchContractByPrepaymentVO.getAcmmRtAmt());
				eventResponse.setETCData("fletBrogRtAmt",searchContractByPrepaymentVO.getFletBrogRtAmt());
				eventResponse.setETCData("acmmFlg",searchContractByPrepaymentVO.getAcmmFlg());
				eventResponse.setETCData("brogFlg",searchContractByPrepaymentVO.getBrogFlg());
				eventResponse.setETCData("invSeq",searchContractByPrepaymentVO.getInvSeq());
				eventResponse.setETCData("payHirNo",searchContractByPrepaymentVO.getPayHirNo());
			}else{
				eventResponse.setETCData("fletCtrtNo","");
				eventResponse.setETCData("vslCd","");
				eventResponse.setETCData("vslEngNm","");
				eventResponse.setETCData("fletCtrtTpCd","");
				eventResponse.setETCData("custCntCd","");
				eventResponse.setETCData("custSeq","");
				eventResponse.setETCData("vndrLglEngNm","");
				eventResponse.setETCData("ownrNm","");
				eventResponse.setETCData("effDt","");
				eventResponse.setETCData("fromTime","");
				eventResponse.setETCData("expDt","");
				eventResponse.setETCData("toTime","");
				eventResponse.setETCData("invUsdDys","");
				eventResponse.setETCData("acmmRtAmt","");
				eventResponse.setETCData("fletBrogRtAmt","");
				eventResponse.setETCData("acmmFlg","");
				eventResponse.setETCData("brogFlg","");
				eventResponse.setETCData("invSeq","");
				eventResponse.setETCData("payHirNo","");
			}

			//*********************** Getting CONTRACT table data(END) ************************//
			
			//************* Getting latest Hire Information(START) ************//
			
			if(searchHireSysDateVO != null) {
				eventResponse.setETCData("hirEffDt",searchHireSysDateVO.getEffDt());
				eventResponse.setETCData("hirEffDtTime",searchHireSysDateVO.getEffDtTime()); 
				eventResponse.setETCData("hirExpDt",searchHireSysDateVO.getExpDt());
				eventResponse.setETCData("hirExpDtTime",searchHireSysDateVO.getExpDtTime()); 
				eventResponse.setETCData("hirHirCurrN1stCd",searchHireSysDateVO.getHirCurrN1stCd());
				eventResponse.setETCData("hirHirRtN1stAmt",searchHireSysDateVO.getHirRtN1stAmt());
				eventResponse.setETCData("hirHirCurrN2ndCd",searchHireSysDateVO.getHirCurrN2ndCd());
				eventResponse.setETCData("hirHirRtN2ndAmt",searchHireSysDateVO.getHirRtN2ndAmt());
			} else {
				eventResponse.setETCData("hirEffDt","");
				eventResponse.setETCData("hirEffDtTime",""); 
				eventResponse.setETCData("hirExpDt","");
				eventResponse.setETCData("hirExpDtTime",""); 
				eventResponse.setETCData("hirHirCurrN1stCd","");
				eventResponse.setETCData("hirHirRtN1stAmt","");
				eventResponse.setETCData("hirHirCurrN2ndCd","");
				eventResponse.setETCData("hirHirRtN2ndAmt","");
			}
			
			
			//************* Getting latest Hire Information(END) **************//
			
			eventResponse.setETCData(etcData);

			eventResponse.setRsVoList(searchOtrExpnSysDateListVOs);
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Getting Hire No/Contract Type for CtrtNo at Prepayment <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractListByPrepaymentHireNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchContractListByPrepaymentHireNoVO> searchContractListByPrepaymentHireNoVOs = command.searchContractListByPrepaymentHireNo(event.getFletCtrtNo());
			
			StringBuilder sb = new StringBuilder();
			
			String fletCtrtTpCd = "";
			
			if(searchContractListByPrepaymentHireNoVOs.size() > 0) {
				for(int i=0; i<searchContractListByPrepaymentHireNoVOs.size(); i++) {
					sb.append(searchContractListByPrepaymentHireNoVOs.get(i).getPpayHirNo()+"|");
				}
				
				fletCtrtTpCd = searchContractListByPrepaymentHireNoVOs.get(0).getFletCtrtTpCd();
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("payHirNo",sb.toString());
			etcData.put("fletCtrtTpCd",fletCtrtTpCd);
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Off-Hire Contract<br>
	 * Getting Contract Type/Owner Code/Owner Name/Hire Information/Other(s) Lump sum information for CtrtNo at Off-Hire Expenses<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractByOffHire(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			ContractContainerVO contractContainerVO = command.searchContractByOffHire(event.getFletCtrtNo());
			
			SearchContractByInvoiceVO searchContractByInvoiceVO = contractContainerVO.getSearchContractByInvoiceVO();
			SearchHireSysDateVO searchHireSysDateVO = contractContainerVO.getSearchHireSysDateVO();
			List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = contractContainerVO.getSearchOtrExpnSysDateListVOs();

			Map<String,String> etcData = new HashMap<String,String>();
			
			//********************** Getting CONTRACT table data(START) **********************//
			
			eventResponse.setETCData("fletCtrtNo",searchContractByInvoiceVO.getFletCtrtNo());
			eventResponse.setETCData("vslCd",searchContractByInvoiceVO.getVslCd());
			eventResponse.setETCData("vslEngNm",searchContractByInvoiceVO.getVslEngNm());
			eventResponse.setETCData("fletCtrtTpCd",searchContractByInvoiceVO.getFletCtrtTpCd());
			eventResponse.setETCData("custCntCd",searchContractByInvoiceVO.getCustCntCd());
			eventResponse.setETCData("custSeq",searchContractByInvoiceVO.getCustSeq());
			eventResponse.setETCData("vndrLglEngNm",searchContractByInvoiceVO.getVndrLglEngNm());
			eventResponse.setETCData("ownrNm",searchContractByInvoiceVO.getOwnrNm());
			eventResponse.setETCData("acmmRtAmt",searchContractByInvoiceVO.getAcmmRtAmt());
			eventResponse.setETCData("fletBrogRtAmt",searchContractByInvoiceVO.getFletBrogRtAmt());
			eventResponse.setETCData("acmmFlg",searchContractByInvoiceVO.getAcmmFlg());
			eventResponse.setETCData("brogFlg",searchContractByInvoiceVO.getBrogFlg());

			//*********************** Getting CONTRACT table data(END) ************************//
			
			//************* Getting latest Hire Information(START) ************//
			
			if(searchHireSysDateVO != null) {
				eventResponse.setETCData("effDt",searchHireSysDateVO.getEffDt());
				eventResponse.setETCData("effDtTime",searchHireSysDateVO.getEffDtTime()); 
				eventResponse.setETCData("expDt",searchHireSysDateVO.getExpDt());
				eventResponse.setETCData("expDtTime",searchHireSysDateVO.getExpDtTime()); 
				eventResponse.setETCData("hirCurrN1stCd",searchHireSysDateVO.getHirCurrN1stCd());
				eventResponse.setETCData("hirRtN1stAmt",searchHireSysDateVO.getHirRtN1stAmt().trim());
				eventResponse.setETCData("hirCurrN2ndCd",searchHireSysDateVO.getHirCurrN2ndCd());
				eventResponse.setETCData("hirRtN2ndAmt",searchHireSysDateVO.getHirRtN2ndAmt().trim());
			} else {
				eventResponse.setETCData("effDt","");
				eventResponse.setETCData("effDtTime",""); 
				eventResponse.setETCData("expDt","");
				eventResponse.setETCData("expDtTime",""); 
				eventResponse.setETCData("hirCurrN1stCd","");
				eventResponse.setETCData("hirRtN1stAmt","");
				eventResponse.setETCData("hirCurrN2ndCd","");
				eventResponse.setETCData("hirRtN2ndAmt","");
			}
			
			//************* Getting latest Hire Information(END) **************//
			
			eventResponse.setETCData(etcData);

			eventResponse.setRsVoList(searchOtrExpnSysDateListVOs);
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Retrieving Contract<br>
	 * Retrieving contract information about Owner ship/Charter in/Hire Out at Agreement Inquiry(SEARCH)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0002Event event = (EsmFms0002Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		try{
			ContractContainerVO contractContainerVO = command.searchAgreement(event.getFletCtrtNo());
			
			SearchContractVO searchContractVO = contractContainerVO.getSearchContractVO();
			List<SearchHireListVO> searchHireListVOs= contractContainerVO.getSearchHireListVOs();
			List<SearchOtrExpnListVO> searchOtrExpnListVOs = contractContainerVO.getSearchOtrExpnListVOs();
			List<SearchPayTermListVO> searchPayTermListVOs = contractContainerVO.getSearchPayTermListVOs();
			List<SearchCharterPtyFileListVO> searchCharterPtyFileListVOs = contractContainerVO.getSearchCharterPtyFileListVOs();
			List<SearchFileCertificationListVO> searchFileCertificationListVOs = contractContainerVO.getSearchFileCertificationListVOs();
			List<SearchIdVslListVO> searchIdVslListVOs = contractContainerVO.getSearchIdVslListVOs();
			SearchHireSysDateVO searchHireSysDateVO = contractContainerVO.getSearchHireSysDateVO();
			List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = contractContainerVO.getSearchOtrExpnSysDateListVOs();

			Map<String,String> etcData = new HashMap<String,String>();
			
			//********************** Getting CONTRACT table data(START) **********************//
			
			eventResponse.setETCData("fletCtrtNo",searchContractVO.getFletCtrtNo());
			eventResponse.setETCData("vslCd",searchContractVO.getVslCd());
			eventResponse.setETCData("vslEngNm",searchContractVO.getVslEngNm());
			eventResponse.setETCData("fletCtrtTpCd",searchContractVO.getFletCtrtTpCd());
			eventResponse.setETCData("fletCtrtFactCd",searchContractVO.getFletCtrtFactCd());
			eventResponse.setETCData("cpDt",searchContractVO.getCpDt());
			eventResponse.setETCData("oriEffDt",searchContractVO.getEffDt()); 
			eventResponse.setETCData("fromTime",searchContractVO.getFromTime());
			eventResponse.setETCData("oriExpDt",searchContractVO.getExpDt());
			eventResponse.setETCData("toTime",searchContractVO.getToTime());
			eventResponse.setETCData("declFlg",searchContractVO.getDeclFlg());
			eventResponse.setETCData("vndrSeq",searchContractVO.getVndrSeq());
			eventResponse.setETCData("custCntCd",searchContractVO.getCustCntCd());
			eventResponse.setETCData("custSeq",searchContractVO.getCustSeq());
			eventResponse.setETCData("vndrLglEngNm",searchContractVO.getVndrLglEngNm());
			eventResponse.setETCData("ownrNm",searchContractVO.getOwnrNm());
			eventResponse.setETCData("acmmRtAmt",searchContractVO.getAcmmRtAmt());
			eventResponse.setETCData("fletOlayCommRtAmt",searchContractVO.getFletOlayCommRtAmt());
			eventResponse.setETCData("vslCntCd",searchContractVO.getVslCntCd());
			eventResponse.setETCData("cntNm",searchContractVO.getCntNm());
			eventResponse.setETCData("fletBrogRtAmt",searchContractVO.getFletBrogRtAmt());
			eventResponse.setETCData("oaRsvCurrCd",searchContractVO.getOaRsvCurrCd());
			eventResponse.setETCData("oaRsvAmt",searchContractVO.getOaRsvAmt());
			eventResponse.setETCData("actFoilBodQty",searchContractVO.getActFoilBodQty());
			eventResponse.setETCData("actDoilBodQty",searchContractVO.getActDoilBodQty());
			eventResponse.setETCData("foilBodOutPrc",searchContractVO.getFoilBodOutPrc());
			eventResponse.setETCData("doilBodOutPrc",searchContractVO.getDoilBodOutPrc());
			eventResponse.setETCData("actFoilBorQty",searchContractVO.getActFoilBorQty());
			eventResponse.setETCData("actDoilBorQty",searchContractVO.getActDoilBorQty());
			eventResponse.setETCData("foilBorOutPrc",searchContractVO.getFoilBorOutPrc());
			eventResponse.setETCData("doilBorOutPrc",searchContractVO.getDoilBorOutPrc());
			eventResponse.setETCData("vslBldDt",searchContractVO.getVslBldDt());
			eventResponse.setETCData("shpSpdQty",searchContractVO.getShpSpdQty());
			eventResponse.setETCData("vslDzndCapa",searchContractVO.getVslDzndCapa());
			eventResponse.setETCData("bse14tonVslCapa",searchContractVO.getBse14tonVslCapa());
			eventResponse.setETCData("rfCntrPlgQty",searchContractVO.getRfCntrPlgQty());
			eventResponse.setETCData("ddwtCgoCapaQty",searchContractVO.getDdwtCgoCapaQty());
			eventResponse.setETCData("grsWgt",searchContractVO.getGrsWgt());
			eventResponse.setETCData("nrtWgt",searchContractVO.getNrtWgt());
			eventResponse.setETCData("grFlg",searchContractVO.getGrFlg());
			eventResponse.setETCData("fletGmtLmtCd",searchContractVO.getFletGmtLmtCd());
			eventResponse.setETCData("bodPortCd",searchContractVO.getBodPortCd());
			eventResponse.setETCData("borPortCd",searchContractVO.getBorPortCd());

			//*********************** Getting CONTRACT table data(END) ************************//
			
			//************* Getting latest Hire Information(START) ************//
			
			if(searchHireSysDateVO != null) {
				eventResponse.setETCData("effDt",searchHireSysDateVO.getEffDt());
				eventResponse.setETCData("effDtTime",searchHireSysDateVO.getEffDtTime()); 
				eventResponse.setETCData("expDt",searchHireSysDateVO.getExpDt());
				eventResponse.setETCData("expDtTime",searchHireSysDateVO.getExpDtTime()); 
				eventResponse.setETCData("hirCurrN1stCd",searchHireSysDateVO.getHirCurrN1stCd());
				eventResponse.setETCData("hirRtN1stAmt",searchHireSysDateVO.getHirRtN1stAmt());
				eventResponse.setETCData("hirCurrN2ndCd",searchHireSysDateVO.getHirCurrN2ndCd());
				eventResponse.setETCData("hirRtN2ndAmt",searchHireSysDateVO.getHirRtN2ndAmt());
			} else {
				eventResponse.setETCData("effDt","");
				eventResponse.setETCData("effDtTime",""); 
				eventResponse.setETCData("expDt","");
				eventResponse.setETCData("expDtTime",""); 
				eventResponse.setETCData("hirCurrN1stCd","");
				eventResponse.setETCData("hirRtN1stAmt","");
				eventResponse.setETCData("hirCurrN2ndCd","");
				eventResponse.setETCData("hirRtN2ndAmt","");
			}
			
			//************* Getting latest Hire Information(END) **************//
			
			eventResponse.setETCData(etcData);

			eventResponse.setRsVoList(searchHireListVOs);
			eventResponse.setRsVoList(searchOtrExpnListVOs);
			eventResponse.setRsVoList(searchPayTermListVOs);
			eventResponse.setRsVo(searchContractVO);
			eventResponse.setRsVoList(searchCharterPtyFileListVOs);
			eventResponse.setRsVoList(searchFileCertificationListVOs);
			eventResponse.setRsVoList(searchIdVslListVOs);
			eventResponse.setRsVoList(searchOtrExpnSysDateListVOs);
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * Retrieving contract<br>
	 * Retrieving contract information about Owner ship/Charter in/Hire Out(SEARCH)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContract(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		try{
			ContractContainerVO contractContainerVO = command.searchContract(event.getFletCtrtNo());
			
			SearchContractVO searchContractVO = contractContainerVO.getSearchContractVO();
			List<SearchHireListVO> searchHireListVOs= contractContainerVO.getSearchHireListVOs();
			List<SearchOtrExpnListVO> searchOtrExpnListVOs = contractContainerVO.getSearchOtrExpnListVOs();
			List<SearchPayTermListVO> searchPayTermListVOs = contractContainerVO.getSearchPayTermListVOs();
			List<SearchCharterPtyFileListVO> searchCharterPtyFileListVOs = contractContainerVO.getSearchCharterPtyFileListVOs();
			List<SearchFileCertificationListVO> searchFileCertificationListVOs = contractContainerVO.getSearchFileCertificationListVOs();
			List<SearchIdVslListVO> searchIdVslListVOs = contractContainerVO.getSearchIdVslListVOs();
			SearchHireSysDateVO searchHireSysDateVO = contractContainerVO.getSearchHireSysDateVO();
			List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = contractContainerVO.getSearchOtrExpnSysDateListVOs();

			Map<String,String> etcData = new HashMap<String,String>();
			
			//********************** Getting CONTRACT table data(START) **********************//
			
			eventResponse.setETCData("fletCtrtNo",searchContractVO.getFletCtrtNo());
			eventResponse.setETCData("vslCd",searchContractVO.getVslCd());
			eventResponse.setETCData("vslEngNm",searchContractVO.getVslEngNm());
			eventResponse.setETCData("fletCtrtTpCd",searchContractVO.getFletCtrtTpCd());
			eventResponse.setETCData("fletCtrtFactCd",searchContractVO.getFletCtrtFactCd());
			eventResponse.setETCData("cpDt",searchContractVO.getCpDt());
			eventResponse.setETCData("oriEffDt",searchContractVO.getEffDt()); 
			eventResponse.setETCData("fromTime",searchContractVO.getFromTime());
			eventResponse.setETCData("oriExpDt",searchContractVO.getExpDt());
			eventResponse.setETCData("toTime",searchContractVO.getToTime());
			eventResponse.setETCData("declFlg",searchContractVO.getDeclFlg());
			eventResponse.setETCData("vndrSeq",searchContractVO.getVndrSeq());
			eventResponse.setETCData("custCntCd",searchContractVO.getCustCntCd());
			eventResponse.setETCData("custSeq",searchContractVO.getCustSeq());
			eventResponse.setETCData("vndrLglEngNm",searchContractVO.getVndrLglEngNm());
			eventResponse.setETCData("ownrNm",searchContractVO.getOwnrNm());
			eventResponse.setETCData("acmmRtAmt",searchContractVO.getAcmmRtAmt());
			eventResponse.setETCData("fletOlayCommRtAmt",searchContractVO.getFletOlayCommRtAmt());
			eventResponse.setETCData("vslCntCd",searchContractVO.getVslCntCd());
			eventResponse.setETCData("cntNm",searchContractVO.getCntNm());
			eventResponse.setETCData("fletBrogRtAmt",searchContractVO.getFletBrogRtAmt());
			eventResponse.setETCData("oaRsvCurrCd",searchContractVO.getOaRsvCurrCd());
			eventResponse.setETCData("oaRsvAmt",searchContractVO.getOaRsvAmt());
			eventResponse.setETCData("actFoilBodQty",searchContractVO.getActFoilBodQty());
			eventResponse.setETCData("actDoilBodQty",searchContractVO.getActDoilBodQty());
			eventResponse.setETCData("foilBodOutPrc",searchContractVO.getFoilBodOutPrc());
			eventResponse.setETCData("doilBodOutPrc",searchContractVO.getDoilBodOutPrc());
			eventResponse.setETCData("actFoilBorQty",searchContractVO.getActFoilBorQty());
			eventResponse.setETCData("actDoilBorQty",searchContractVO.getActDoilBorQty());
			eventResponse.setETCData("foilBorOutPrc",searchContractVO.getFoilBorOutPrc());
			eventResponse.setETCData("doilBorOutPrc",searchContractVO.getDoilBorOutPrc());
			eventResponse.setETCData("vslBldDt",searchContractVO.getVslBldDt());
			eventResponse.setETCData("shpSpdQty",searchContractVO.getShpSpdQty());
			eventResponse.setETCData("vslDzndCapa",searchContractVO.getVslDzndCapa());
			eventResponse.setETCData("bse14tonVslCapa",searchContractVO.getBse14tonVslCapa());
			eventResponse.setETCData("rfCntrPlgQty",searchContractVO.getRfCntrPlgQty());
			eventResponse.setETCData("ddwtCgoCapaQty",searchContractVO.getDdwtCgoCapaQty());
			eventResponse.setETCData("grsWgt",searchContractVO.getGrsWgt());
			eventResponse.setETCData("nrtWgt",searchContractVO.getNrtWgt());
			eventResponse.setETCData("grFlg",searchContractVO.getGrFlg());
			eventResponse.setETCData("fletGmtLmtCd",searchContractVO.getFletGmtLmtCd());
			eventResponse.setETCData("bodPortCd",searchContractVO.getBodPortCd());
			eventResponse.setETCData("borPortCd",searchContractVO.getBorPortCd());

			//*********************** Getting CONTRACT table data(END) ************************//
			
			//************* getting latest Hire Information(START) ************//
			
			if(searchHireSysDateVO != null) {
				eventResponse.setETCData("effDt",searchHireSysDateVO.getEffDt());
				eventResponse.setETCData("effDtTime",searchHireSysDateVO.getEffDtTime()); 
				eventResponse.setETCData("expDt",searchHireSysDateVO.getExpDt());
				eventResponse.setETCData("expDtTime",searchHireSysDateVO.getExpDtTime()); 
				eventResponse.setETCData("hirCurrN1stCd",searchHireSysDateVO.getHirCurrN1stCd());
				eventResponse.setETCData("hirRtN1stAmt",searchHireSysDateVO.getHirRtN1stAmt());
				eventResponse.setETCData("hirCurrN2ndCd",searchHireSysDateVO.getHirCurrN2ndCd());
				eventResponse.setETCData("hirRtN2ndAmt",searchHireSysDateVO.getHirRtN2ndAmt());
			} else {
				eventResponse.setETCData("effDt","");
				eventResponse.setETCData("effDtTime",""); 
				eventResponse.setETCData("expDt","");
				eventResponse.setETCData("expDtTime",""); 
				eventResponse.setETCData("hirCurrN1stCd","");
				eventResponse.setETCData("hirRtN1stAmt","");
				eventResponse.setETCData("hirCurrN2ndCd","");
				eventResponse.setETCData("hirRtN2ndAmt","");
			}
			
			//************* Getting latest Hire Information(END) **************//
			
			eventResponse.setETCData(etcData);

			eventResponse.setRsVoList(searchHireListVOs);
			eventResponse.setRsVoList(searchOtrExpnListVOs);
			eventResponse.setRsVoList(searchPayTermListVOs);
			eventResponse.setRsVo(searchContractVO);
			eventResponse.setRsVoList(searchCharterPtyFileListVOs);
			eventResponse.setRsVoList(searchFileCertificationListVOs);
			eventResponse.setRsVoList(searchIdVslListVOs);
			eventResponse.setRsVoList(searchOtrExpnSysDateListVOs);
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Generating new contract<br>
	 * Saving the information about Owner ship/Charter in/Hire Out(CREATION)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse createContract(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		//Integrated VO related to Agreement Creation(Contract)
		TCharterIOContractVO tCharterIOContractVO = (TCharterIOContractVO)event.getVO("voContract");
		
		List<String> keys = event.getKeys();
		String cefFileCnt = event.getCefFileCnt();
		String cpfFileCnt = event.getCpfFileCnt();
		
		try{	
			begin();
			FileCountVO fileCountVO = new FileCountVO();
			fileCountVO.setCefFileCnt(cefFileCnt);
			fileCountVO.setCpfFileCnt(cpfFileCnt);
			
			String fletCtrtNo = command.createContract(tCharterIOContractVO, keys, fileCountVO, account.getUsr_id());
			
			//Generated Contract No
			event.setFletCtrtNo(fletCtrtNo);
			eventResponse = (GeneralEventResponse)searchContract(event);
			
			eventResponse.setETCData("fletCtrtNo", fletCtrtNo);
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
		
	}
	
	/**
	 * Insert/Modify/Delete Contract Information<br>
	 * Saving Owner Ship/Charter in/Hire Out information(SAVE)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContract(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		TCharterIOContractVO tCharterIOContractVO = (TCharterIOContractVO)event.getVO("voContract");
		
		List<String> keys = event.getKeys();
		String fletCtrtNo = event.getFletCtrtNo();
		String cefFileCnt = event.getCefFileCnt();
		String cpfFileCnt = event.getCpfFileCnt();
		
		try{	
			begin();
			FileCountVO fileCountVO = new FileCountVO();
			fileCountVO.setCefFileCnt(cefFileCnt);
			fileCountVO.setCpfFileCnt(cpfFileCnt);
			
			command.manageContract(tCharterIOContractVO, keys, fileCountVO, account.getUsr_id());
			
			event.setFletCtrtNo(fletCtrtNo);
			eventResponse = (GeneralEventResponse)searchContract(event);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
		
	}
	
	/**
	 * Delete all contract information<br>
	 * Deleting Owner Ship/Charter in/Hire Out information(DELETE)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */	
	private EventResponse removeContract(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		try{	
			begin();

			command.removeContract(event.getFletCtrtNo());
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Contract Information(POPUP)<br>
	 * Retrieving Vessel information at POPUP window on Contract window, and then selecting<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContracNoListByVessel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0023Event event = (EsmFms0023Event)e;
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();

		try{
			List<SearchContracNoListByVesselVO> searchContracNoListByVesselVO = command.searchContracNoListByVessel(event.getVslCd(), event.getFletCtrtTpCd(), event.getCtrtFlag());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(searchContracNoListByVesselVO);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Contract Information POPUP<br>
	 * Retrieving Account Item List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccountItemList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0076Event event = (EsmFms0076Event)e;
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();

		try{
			List<SearchAccountItemListVO> searchAccountItemListVO = command.searchAccountItemList(event.getFletAcctCateCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(searchAccountItemListVO);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving data on Bunker window<br>
	 * Inserting Target Month / Vessel Code / Contract No, then retrieving corresponding Bunker Data<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBunkerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0050Event event = (EsmFms0050Event)e;
		  
		TCharterIOBunkerRegisterBC command = new TCharterIOBunkerRegisterBCImpl();
		  
		try {
			List<SearchBunkerVO> searchBunkerVO = command.searchBunkerList(event.getSearchBunkerVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse = (GeneralEventResponse)searchIdVslCdListByBunker(e);
			
			eventResponse.setRsVoList(searchBunkerVO);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Insert/Modify/Delete data on Bunker window<br>
	 * Saving data on Bunker window<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBunker(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0050Event event = (EsmFms0050Event)e;
		
		TCharterIOBunkerRegisterBC command = new TCharterIOBunkerRegisterBCImpl();
		
		//TCharterIOContractBC ctrtCommand = new TCharterIOContractBCImpl();
		
		try {
			CustomBunkerVO[] customBunkerVOs = event.getCustomBunkerVOS();
			
			//SearchBunkerVO searchbunkervo = event.getSearchBunkerVO();
			
			//String fletCtrtNo = searchbunkervo.getFletCtrtNo(); 
			//String bnkYrmon = "";//searchbunkervo.getBnkYrmon();
			String usrId = account.getUsr_id();
			
			begin();
			command.manageBunker(customBunkerVOs, usrId);
			
			//Getting information planning to update
			//2015.08.03 NYK Modify
			/*
			List<ContractByBunkerVO> contractByBunkerVO = command.searchContractByBunker(fletCtrtNo, bnkYrmon);
			
			//Updating Contract Table
			if(contractByBunkerVO.size() > 0) {
				ctrtCommand.modifyContractByBunker(contractByBunkerVO.get(0));
			}*/
			
			eventResponse = (GeneralEventResponse)searchBunkerList(e);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Retrieving Vessel Code to retrieve Bunker Data Popup<br>
	 * Getting vslCd corresponding to contract number<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIdVslCdListByBunker(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0050Event event = (EsmFms0050Event)e;
		
		TCharterIOBunkerRegisterBC command = new TCharterIOBunkerRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchIdVslCdByBunkerVO> searchIdVslCdByBunkerVO = command.searchIdVslCdListByBunker(event.getFletCtrtNo());
			
			StringBuilder sb = new StringBuilder();
			
			if(searchIdVslCdByBunkerVO.size() > 0) {
				for(int i=0; i<searchIdVslCdByBunkerVO.size(); i++) {
					sb.append(searchIdVslCdByBunkerVO.get(i).getVslCd()+"|");
				}
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("vslCd",sb.toString());
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Voyage information to insert Bunker Data<br>
	 * Getting Voyage corresponding to vslCd and bnkDt<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVvdListByBunker(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0050Event event = (EsmFms0050Event)e;
		
		TCharterIOBunkerRegisterBC command = new TCharterIOBunkerRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchVvdByBunkerVO> searchVvdByBunkerVO = command.searchVvdListByBunker(event.getCurrVslCd(), event.getBunkerDt(), event.getFletCtrtNo());
			
			StringBuilder sb = new StringBuilder();
			
			if(searchVvdByBunkerVO.size() > 0) {
				for(int i=0; i<searchVvdByBunkerVO.size(); i++) {
					sb.append(searchVvdByBunkerVO.get(i).getVvd()+"|");
				}
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("vvd",sb.toString());
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Location Code to insert Bunker Data<br>
	 * Getting Location Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocCdByBunker(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0050Event event = (EsmFms0050Event)e;
		
		TCharterIOBunkerRegisterBC command = new TCharterIOBunkerRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			String locCd = "";
			locCd = command.checkLocCdByBunker(event.getCurrPortCd());
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("locCd",locCd);
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Contract Type<br>
	 * Getting Contract Type corresponding to CtrtNo<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractTypeCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0050Event event = (EsmFms0050Event)e;
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchContractTypeCodeVO> searchContractTypeCodeVO = command.searchContractTypeCode(event.getFletCtrtNo());
			
			String ctrtType = searchContractTypeCodeVO.get(0).getFletCtrtTpCd();
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("ctrtType",ctrtType);
			
			eventResponse.setETCData(etcData);
			
			if(ctrtType == null || ctrtType.equals("")) {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01022",new String[]{}).getUserMessage());
			}
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Getting Common Code to insert Bunker Data<br>
	 * Getting Common Code on Bunker window<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStandardCodeListByBunker() throws EventException {
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			int[] sortKey = {0, 0};
			
			String[] cdId      = {"CD01743", "CD01749"};
			String[] etcCodeNm = {"bnkType", "uomCode"};
			String[] etcTextNm = {"", "uomText"};
			
			List<Collection<CodeInfo>> codeInfoList = new ArrayList<Collection<CodeInfo>>();
			
			codeInfoList = command.getStandardCommonCode(cdId, sortKey);
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData = getStandardCommonCodeList(codeInfoList, etcCodeNm, etcTextNm);
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;

		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} 
	}
	
	/**
	 * Getting Common Code(Contract Type, Contract Fact, Payment Term) on Agreement Creation window<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStandardCodeListByContract() throws EventException {
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			int[] sortKey = {0, 0, 0};
			
			String[] cdId      = {"CD01513", "CD01746", "CD01516"};
			String[] etcCodeNm = {"fletCtrtTpCd", "fletCtrtFactCd", "ctrtPayTermCd"};
			String[] etcTextNm = {"fletCtrtTpNm", "fletCtrtFactNm", "ctrtPayTermNm"};
			
			List<Collection<CodeInfo>> codeInfoList = new ArrayList<Collection<CodeInfo>>();
			
			codeInfoList = command.getStandardCommonCode(cdId, sortKey);
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData = getStandardCommonCodeList(codeInfoList, etcCodeNm, etcTextNm);
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;

		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Charter's Account Contract information<br>
	 * Getting Contract Type/Owner Code/Owner Name corresponding to CtrtNo<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractByCharter(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchContractByCharterVO> searchContractByCharterVO = command.searchContractByCharter(event.getFletCtrtNo());
			
			String fletCtrtNo   = searchContractByCharterVO.get(0).getFletCtrtNo();
			String vslCd		= searchContractByCharterVO.get(0).getVslCd();
			String vslEngNm		= searchContractByCharterVO.get(0).getVslEngNm();
			String fletCtrtTpCd = searchContractByCharterVO.get(0).getFletCtrtTpCd();
			String custCntCd    = searchContractByCharterVO.get(0).getCustCntCd();
			String custSeq      = searchContractByCharterVO.get(0).getCustSeq();
			String vndrLglEngNm = searchContractByCharterVO.get(0).getVndrLglEngNm();
			String ownrNm       = searchContractByCharterVO.get(0).getOwnrNm();
			String ibflag       = searchContractByCharterVO.get(0).getIbflag();
			
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("fletCtrtNo",fletCtrtNo);
			etcData.put("vslCd",vslCd);
			etcData.put("vslEngNm",vslEngNm);
			etcData.put("fletCtrtTpCd",fletCtrtTpCd);
			etcData.put("custCntCd",custCntCd);
			etcData.put("custSeq",custSeq);
			etcData.put("vndrLglEngNm",vndrLglEngNm);
			etcData.put("ownrNm",ownrNm);
			etcData.put("ibflag",ibflag);
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Getting Currency Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCurrencyCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0076Event event = (EsmFms0076Event)e;
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			String currCd = "";
			currCd = command.checkCurrencyCode(event.getCurrCd());
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("currCd",currCd);
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
   /**
	* Retrieving Owner List<br>
	* 
	* @return response EventResponse
	* @exception EventException
	*/
    private EventResponse searchOwnerList() throws EventException {
	    
    	TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
    	try {
    		List<CustomOwnerVO> customOwnerVO = command.searchOwnerList();

    		GeneralEventResponse eventResponse = new GeneralEventResponse();
	   
    		eventResponse.setRsVoList(customOwnerVO);
	   
    		return eventResponse;
	   
    	} catch(EventException ex) {
    		throw new EventException(new ErrorHandler(ex).getMessage(), ex);
    	} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	 
    /**
	 * Retrieving OwnerType Code<br>
	 * Getting Common Code(Type, Uom) on Bunker window<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchOwnerTypeCodeList() throws EventException {
    	
    	TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	  
    	try{
    		int[] sortKey = {0};
			
			String[] cdId      = {"CD01750"};
			String[] etcCodeNm = {"comboCode"};
			String[] etcTextNm = {"comboText"};
			
			List<Collection<CodeInfo>> codeInfoList = new ArrayList<Collection<CodeInfo>>();
			
			codeInfoList = command.getStandardCommonCode(cdId, sortKey);
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData = getStandardCommonCodeList(codeInfoList, etcCodeNm, etcTextNm);
			
			eventResponse.setETCData(etcData);
	   
    		return eventResponse;

    	} catch(Exception ex) {
    		throw new EventException(new ErrorHandler(ex).getMessage(), ex);
    	}
	 }
	 
	/**
	 * Retrieving data on Charterer's Account window<br>
	 * Retrieving account related to Charterer Cost
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchCharterInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	EsmFms0016Event event = (EsmFms0016Event)e;
		  
    	TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		  
		try {
			List<SearchCharterInvoiceListVO> searchCharterInvoiceListVOs = command.searchCharterInvoiceList(event.getCondCharterInvoiceVO());
			
			List<SearchCharterInvoiceSumVO> searchCharterInvoiceSumVOs = command.searchCharterInvoiceSum(event.getCondCharterInvoiceVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(searchCharterInvoiceListVOs);
			eventResponse.setRsVoList(searchCharterInvoiceSumVOs);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    
    /**
	 * Retrieving Voyage corresponding to Charter's Account<br>
	 * Getting Voyage corresponding to fletCtrtNo and bnkYrmon<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVvdListByCharter(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0016Event event = (EsmFms0016Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchVvdListByCharterVO> searchVvdListByCharterVO = command.searchVvdListByCharter(event.getFletCtrtNo(), event.getRevYrmon());
			
			StringBuilder sb = new StringBuilder();
			
			if(searchVvdListByCharterVO.size() > 0) {
				for(int i=0; i<searchVvdListByCharterVO.size(); i++) {
					sb.append(searchVvdListByCharterVO.get(i).getVvd()+"|");
				}
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("vvd",sb.toString());
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Changing charterer Cost on Charterer's Account window<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCharterInvoice(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0016Event event = (EsmFms0016Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		// BC related to SDMS Interface
		StevedoreDamageMgtBC opfCmd = new StevedoreDamageMgtBCImpl();
		
		try {
			// INVOICE MASTER VO
			CustomInvoiceVO customInvoiceVO = event.getCustomInvoiceVO();
			
			// INVOICE DETAIL VO
			CustomInvDtlVO[] customInvDtlVOs = event.getCustomInvDtlVOS();
			
			// Handling SDMS INSERT 
			CustomSdmsSettlementVO[] customSdmsSettlementVOs = event.getCustomSdmsSettlementVOS();
			
			String usrId = account.getUsr_id();
			
			begin();
			
			/************ Handling SDMS Interface START ************/ 
			
			// Handling SDMS INSERT  
			if(customSdmsSettlementVOs != null) {
				opfCmd.addSettlementFMS(customSdmsSettlementVOs);
			} 
			
			// Handling SDMS DELETE 
			if(null != customInvDtlVOs) {
				opfCmd.removeSettlementFMS(customInvDtlVOs);
			}else{
				customInvDtlVOs = null;
			}
			
			/************ Handling SDMS Interface END ***************/ 
			if(null != customInvDtlVOs){
				command.manageCharterInvoice(customInvoiceVO, customInvDtlVOs, usrId);
			}else{
				command.manageCharterInvoice(customInvoiceVO, null, usrId);
			}
			
			eventResponse = (GeneralEventResponse)searchCharterInvoiceList(e);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Creating Payment slip<br>
	 * Creating slip by using Prepayment, Vessel Operation Stoppage Cost, Charterer Cost, Owner's Account<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	
	private EventResponse managePaymentSlip(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0021Event event = (EsmFms0021Event)e;
		
		//ExternalFinderBC etfCmd = new ExternalFinderBCImpl();
		
		TCharterIOInvoiceBC invCmd = new TCharterIOInvoiceBCImpl();
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
		
		TCharterIOBunkerRegisterBC bnkCmd = new TCharterIOBunkerRegisterBCImpl();
		
		try {
			// SLP Master VO
			CustomPamConsultationVO[] customPamConsultationVOs = event.getCustomPamConsultationVOS();
			
			// SLP Detail VO
			CustomPamCsulSlpVO[] customPamCsulSlpVOs = event.getCustomPamCsulSlpVOS();
			
			// Tax Invoice / Invoice Master VO
			CustomTaxVO[] customTaxVOs = event.getCustomTaxVOS();
			
			// Tax Invoice / Invoice Detail VO
			CustomTaxDtlVO[] customTaxDtlVOs = event.getCustomTaxDtlVOS();
			
			// SLP Serial Number
			String slpSerNo = "";
			
			// CSR No.(slip Generation Number)
			String csrNo = "";
			
			//2015.11.19 NYK Not Used.
			/*
			//Checking Voyage level and deciding either new Contract number or old Contract number then re-setting VO the old Contract number 
			for (int i=0; i<customPamCsulSlpVOs.length; i++) {
				if(   customPamCsulSlpVOs[i].getBunkerVvd() != null && !customPamCsulSlpVOs[i].getBunkerVvd().equals("")) {
					
					String level = etfCmd.checkAcctCdVvdLevel(customPamCsulSlpVOs[i].getAcctCd(), customPamCsulSlpVOs[i].getBunkerVvd());
					if (!level.equals("2")) {	
						throw new EventException(new ErrorHandler("FMS01478",new String[]{customPamCsulSlpVOs[i].getAcctCd(), customPamCsulSlpVOs[i].getBunkerVvd()}).getMessage());
					}
				}
			}*/
			
			begin();
			
			// Creating slip 
			slpSerNo = command.managePaymentSlip(customPamConsultationVOs, customPamCsulSlpVOs, customTaxVOs, customTaxDtlVOs);
			
			// Updating Bunker Table
			bnkCmd.modifyPaymentSlipBunkers(customPamConsultationVOs, customPamCsulSlpVOs, slpSerNo);
			
			// Updating Invoice Table
			invCmd.modifyPaymentSlipInvoices(customPamConsultationVOs, customPamCsulSlpVOs, slpSerNo);
			
			// Updating Owner's Account Table
			invCmd.modifyPaymentSlipOwnerAccounts(customPamConsultationVOs, customPamCsulSlpVOs, slpSerNo);
			
			//eventResponse = (GeneralEventResponse)searchCharterInvoiceList(e);
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			csrNo = "07"+customPamConsultationVOs[0].getSlpTp()+customPamConsultationVOs[0].getSlpOfcCd()+customPamConsultationVOs[0].getSlpIssDt().substring(2,6)+slpSerNo;
			//csrNo = "07"+customPamConsultationVOs[0].getSlpTp()+customPamConsultationVOs[0].getSlpOfcCd()+customPamConsultationVOs[0].getSlpIssDt().substring(2)+slpSerNo;
			
			// Retrieving slip Generation data
			List<SearchPaymentSlipListVO> searchPaymentSlipListVO = command.searchPaymentSlipList(csrNo);
			
			etcData.put("csrNo",csrNo); 
			
			eventResponse.setETCData(etcData);
			
			eventResponse.setRsVoList(searchPaymentSlipListVO);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}

	
	/**
	 * Search Payment slip by Csr No<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchPaymentSlipByCsrNo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0021Event event = (EsmFms0021Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
		
		try {
			// CSR No.(parameter Number)
			String csrNo = event.getCondSearchSlipCorrectionVO().getCsrNo();
			Map<String,String> etcData = new HashMap<String,String>();
			
			//TODO 2015.11.27 마스터 정보를 조회해야 함.
			SearchPaymentSlipMasterVO searchPaymentSlipMasterVO = command.searchPaymentSlipMaster(csrNo);
			//SLP_DESC , SLP_FUNC_CD : slp_tp, EVID_TP_CD, RQST_DT, EFF_DT, VNDR_SEQ, VNDR_LGL_ENG_NM, PPAY_HIR_NO
			String slpDesc = "";
			String slpTp = "";
			String evidTpCd = "";
			String rqstDt = "";
			String effDt = "";
			String vndrSeq = "";
			String vndrNm = "";
			String ppayHirNo = "";
			String csrCurrCd = "";
			if(searchPaymentSlipMasterVO != null){
				slpDesc 	= searchPaymentSlipMasterVO.getSlpDesc();
				slpTp 		= searchPaymentSlipMasterVO.getSlpFuncCd();
				evidTpCd 	= searchPaymentSlipMasterVO.getEvidTpCd();
				rqstDt 		= searchPaymentSlipMasterVO.getRqstDt();
				effDt 		= searchPaymentSlipMasterVO.getEffDt();
				vndrSeq 	= searchPaymentSlipMasterVO.getVndrSeq();
				vndrNm 		= searchPaymentSlipMasterVO.getVndrLglEngNm();
				ppayHirNo 	= searchPaymentSlipMasterVO.getPpayHirNo();
				csrCurrCd 	= searchPaymentSlipMasterVO.getCsrCurrCd();
			}
			
			etcData.put("slpDesc"	,slpDesc); 
			etcData.put("slpTp"		,slpTp); 
			etcData.put("evidTpCd"	,evidTpCd); 
			etcData.put("rqstDt"	,rqstDt); 
			etcData.put("effDt"		,effDt); 
			etcData.put("vndrSeq"	,vndrSeq); 
			etcData.put("vndrNm"	,vndrNm); 
			etcData.put("ppayHirNo"	,ppayHirNo); 
			etcData.put("csrCurrCd"	,csrCurrCd); 
			
			// Retrieving slip Generation data
			List<SearchPaymentSlipListVO> searchPaymentSlipListVO = command.searchPaymentSlipList(csrNo);
			
			etcData.put("csrNo",csrNo); 
			
			eventResponse.setETCData(etcData);
			eventResponse.setRsVoList(searchPaymentSlipListVO);
			//eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
   /**
	 * Retrieving Name information corresponding to Owner Code<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOwnerName(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		try{
			List<SearchOwnerNameVO> searchOwnerNameVO = command.searchOwnerName(event.getFletCtrtTpCd(), event.getCustCntCd(), event.getVndrSeq(), event.getCustSeq());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("ownrNm",searchOwnerNameVO.get(0).getOwnrNm());
			etcData.put("lglEngNm",searchOwnerNameVO.get(0).getLglEngNm());
			
			eventResponse.setETCData(etcData);
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Retrieving VendorCode<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorCodeList() throws EventException {
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<SearchVendorCustomerVO> searchVendorCustomerVO = command.searchVendorCodeList();
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchVendorCustomerVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	 
	/**
	 * Owner Information Insert / Modify / Delete<br>
	 * Saving Data on Owner window<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
    private EventResponse manageOwner(Event e) throws EventException {
	  
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
	  
    	EsmFms0006Event event = (EsmFms0006Event)e;
	  
    	TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	  
    	try {
    		CustomOwnerVO[] customOwnerVOs = event.getCustomOwnerVOS();
	   
    		String usrId = account.getUsr_id();
	   
    		begin();
    		command.manageOwner(customOwnerVOs, usrId);
    		
    		eventResponse = (GeneralEventResponse)searchOwnerList();
    		   
    		eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
    		
    		commit();
	   
    	} catch(EventException ex) {
    		rollback();
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler(ex).getMessage(), ex);
    	} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	  
    	return eventResponse;
	 }

	/**
	 * Owner Data Insert / Modify / Delete<br>
	 * Saving Data on Owner window<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVendorCode(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0004Event event = (EsmFms0004Event)e;
	
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	
		try {
			SearchVendorCustomerVO[] searchVendorCustomerVOs = event.getSearchVendorCustomerVOS();
	
			String usrId = account.getUsr_id();
	
			begin();
			
			command.manageVendorCode(searchVendorCustomerVOs, usrId);
    		
    		eventResponse = (GeneralEventResponse)searchVendorCodeList();
    		
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());

    		commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }

    /**
	 * Saving CustomerCode on Owner window(Insert / Modify / Delete)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCustomerCode(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0005Event event = (EsmFms0005Event)e;
	
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	
		try {
			SearchVendorCustomerVO[] searchVendorCustomerVOs = event.getSearchVendorCustomerVOS();
	
			String usrId = account.getUsr_id();
	
			begin();
			
			command.manageCustomerCode(searchVendorCustomerVOs, usrId);
    		
    		eventResponse = (GeneralEventResponse)searchCustomerCodeList();
    		
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }

   /**
	* Retrieving CustomerCode on Bunker window<br>
	* 
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchCustomerCodeList() throws EventException {
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<SearchVendorCustomerVO> searchVendorCustomerVO = command.searchCustomerCodeList();
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchVendorCustomerVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

   /**
	* Retrieving VendorCustomer on Bunker window<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchVendorCustomerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0070Event event = (EsmFms0070Event)e;
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<SearchVendorCustomerVO> searchVendorCustomerVO = command.searchVendorCustomerList(event.getAgmtFlag(), event.getCondFlag(), event.getVendorCustomerName());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchVendorCustomerVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

   /**
	* Retrieving OwnerName on Bunker window<br>
	* 
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchOwnerNameList() throws EventException {
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<SearchOwnerNameListVO> searchOwnerNameListVO = command.searchOwnerNameList();
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchOwnerNameListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

   /**
	* Retrieving VendorCustomerName on Bunker window<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchVendorCustomerName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0070Event event = (EsmFms0070Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<SearchVendorCustomerVO> searchVendorCustomerVO = command.searchVendorCustomerName(event.getCondFlag(), event.getCdCnt(), event.getCdSeq());
	
			if(searchVendorCustomerVO.size() > 0) {
				Map<String,String> etcData = new HashMap<String,String>();
				
				etcData.put("cdCnt",searchVendorCustomerVO.get(0).getCdCnt());
				etcData.put("cdSeq",searchVendorCustomerVO.get(0).getCdSeq());
				etcData.put("cdName",searchVendorCustomerVO.get(0).getCdName());
				
				eventResponse.setETCData(etcData);
				
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01304",new String[]{}).getUserMessage());
			}
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;

	}
	
   /**
	* Retrieving AccountItemDetail on Item Detail Management window<br>
	* 
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchAccountItemDetailList() throws EventException {
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<CustomAcctItmVO> customAcctItmVO = command.searchAccountItemDetailList();
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(customAcctItmVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	
    /**
	 * Retrieving Account Item List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse checkAccountCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0069Event event = (EsmFms0069Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	
		try{
			//List<CustomAcctItmVO> customAcctItmVO = command.checkAccountCode(event.getAcctCd());
			List<CustomAcctItmVO> customAcctItmVO = command.checkAccountCode(event.getCustomAcctItmVO());
			
			if(customAcctItmVO != null && customAcctItmVO.size() > 0) {
				//Map<String,String> etcData = new HashMap<String,String>();				
				//etcData.put("cdName",customAcctItmVO.get(0).getAcctCd());
				
				eventResponse.setETCData("acctNm", customAcctItmVO.get(0).getAcctNm());
				
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01316",new String[]{}).getUserMessage());
			}
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
    
    /**
	 * Saving AccountCate on Account Code window(Insert / Modify / Delete)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAccountCate(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0003Event event = (EsmFms0003Event)e;
	
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	
		try {
			CustomAcctCateVO[] customAcctCateVOs = event.getCustomAcctCateVOS();
	
			String usrId = account.getUsr_id();
	
			begin();
			command.manageAccountCate(customAcctCateVOs, usrId);
			
			eventResponse = (GeneralEventResponse)searchAccountCateList();
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }

	/**
	* Retrieving AccountCate on Account Code window<br>
	* 
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchAccountCateList() throws EventException {
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<CustomAcctCateVO > customAcctCateVO  = command.searchAccountCateList();
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(customAcctCateVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

	/**
	 * Saving AccountItemName on Item Detail Management window(Insert / Modify / Delete)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAccountItemName(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0069Event event = (EsmFms0069Event)e;
	
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	
		try {
			CustomAcctItmVO[] customAcctItmVOs = event.getCustomAcctItmVOS();
	
			String usrId = account.getUsr_id();
	
			begin();
			command.manageAccountItemName(customAcctItmVOs, usrId);
			
			eventResponse = (GeneralEventResponse)searchAccountItemDetailList();
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }
	
	/**
     * Getting Common Code<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchStandardCodeList(Event e) throws EventException {
    	
    	EsmFms0006Event event = (EsmFms0006Event)e;
    	
    	TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
    	
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	
    	try{
    		
    		String[] cdId      = event.getComCdId().split(":");
    		String[] etcCodeNm = event.getComCode().split(":");
    		String[] etcTextNm = event.getComText().split(":");
    		
    		int comSize = cdId.length;
    		
    		int[] sortKey = new int[comSize];
    		
    		for (int i=0; i<comSize; i++) {
    			sortKey[i] = 0;
    		}
    		
    		List<Collection<CodeInfo>> codeInfoList = new ArrayList<Collection<CodeInfo>>();
			
			codeInfoList = command.getStandardCommonCode(cdId, sortKey);
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData = getStandardCommonCodeList(codeInfoList, etcCodeNm, etcTextNm);
			
			eventResponse.setETCData(etcData);
    		
    		return eventResponse;

    	} catch(Exception ex) {
    		throw new EventException(new ErrorHandler(ex).getMessage(), ex);
    	}
    }
    
    /**
	 * Sending Email on Contract Information window<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse sendEmail(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0079Event event = (EsmFms0079Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		  
		try {
			CustomSendEmailVO customSendMailVO = event.getCustomSendEmailVO();
			
			String signature = "";
			String usrNm = account.getUsr_nm();
			String ofcNm = account.getOfc_eng_nm();
			String phnNo = account.getXtn_phn_no();
			String faxNo = account.getFax_no();
			
			//서명
			StringBuilder sb = new StringBuilder();
			
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: navy; FONT-FAMILY: 바탕,serif'></SPAN>&nbsp;</P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: navy; FONT-FAMILY: 바탕,serif'></SPAN>&nbsp;</P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: navy; FONT-FAMILY: 바탕,serif'></SPAN>&nbsp;</P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: navy; FONT-FAMILY: 바탕,serif'></SPAN>&nbsp;</P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: navy; FONT-FAMILY: 바탕,serif'></SPAN>&nbsp;</P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: navy; FONT-FAMILY: 바탕,serif'>Best Regards.</SPAN></P>");
			sb.append("<P class=MsoNormal style='mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: #595959; FONT-FAMILY: 바탕,serif'></SPAN>&nbsp;</P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: red; FONT-FAMILY: 바탕,serif'>________________________________________________________</SPAN></P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; LINE-HEIGHT: 150%; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><U><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: teal; LINE-HEIGHT: 150%; FONT-FAMILY: 바탕,serif'>"+usrNm+"</SPAN></U></P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; LINE-HEIGHT: 150%; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: purple; LINE-HEIGHT: 150%; FONT-FAMILY: 바탕,serif'>"+ofcNm+", OPUS Shipping</SPAN></P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: purple; FONT-FAMILY: 바탕,serif'>25-11 Yoido-dong, Youngdeungpo-gu, Seoul 150-878, KOREA</SPAN></P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: blue; FONT-FAMILY: 돋움체'>Tel: "+phnNo+" / Fax: "+faxNo+"</SPAN></P>");
			
			signature = sb.toString();
			
			customSendMailVO.setSignature(signature);
			
			//UPLOAD KEY
			List<String> keys = event.getKeys();
			
			begin();
			
			String successMsg = command.sendEmail(customSendMailVO, keys);
			
			commit();
			
			if(successMsg != null && !successMsg.equals("")) {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01186",new String[]{}).getUserMessage());
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01187",new String[]{}).getUserMessage());
			}
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    
    
    /**
	 * Retrieving OwnerInvoice <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchOwnerInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	
		EsmFms0018Event event = (EsmFms0018Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			event.getCondSearchOwnerInvoiceVO().setSheetNo("1");
			List<SearchOwnerInvoiceListVO> searchOwnerInvoiceListVO1 = command.searchOwnerInvoiceList(event.getCondSearchOwnerInvoiceVO());
			
			event.getCondSearchOwnerInvoiceVO().setSheetNo("2");
			List<SearchOwnerInvoiceListVO> searchOwnerInvoiceListVO2 = command.searchOwnerInvoiceList(event.getCondSearchOwnerInvoiceVO());

			eventResponse.setRsVoList(searchOwnerInvoiceListVO1);
			eventResponse.setRsVoList(searchOwnerInvoiceListVO2);
		
	    } catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * Saving OwnerInvoice (Insert / Modify / Delete)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse modifyOwnerInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0018Event event = (EsmFms0018Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try{
			begin();
			if (event.getCustomOwnrAcctSlpVOS() != null) {
				command.modifyOwnerInvoice(event.getCustomOwnrAcctSlpVOS(),account.getUsr_id());
				
				if(event.getSearchType().equalsIgnoreCase("S")) {
					eventResponse = (GeneralEventResponse)searchOwnerInvoiceList(e);
				} else {
					eventResponse = (GeneralEventResponse)searchOwnerInvoiceAutoMatchList(e);
				}
				
				eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
				commit();
			}
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Retrieving OwnerInvoiceAutoMatch<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchOwnerInvoiceAutoMatchList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	
		EsmFms0018Event event = (EsmFms0018Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();

		try {
			event.getCondSearchOwnerInvoiceAutoMatchVO().setSheetNo("1");
			List<SearchOwnerInvoiceAutoMatchListVO> searchOwnerInvoiceAutoMatchListVO1 = 
												command.searchOwnerInvoiceAutoMatchList(event.getCondSearchOwnerInvoiceAutoMatchVO());
			
			event.getCondSearchOwnerInvoiceAutoMatchVO().setSheetNo("2");
			List<SearchOwnerInvoiceAutoMatchListVO> searchOwnerInvoiceAutoMatchListVO2 = 
												command.searchOwnerInvoiceAutoMatchList(event.getCondSearchOwnerInvoiceAutoMatchVO());
			
			eventResponse.setRsVoList(searchOwnerInvoiceAutoMatchListVO1);
			eventResponse.setRsVoList(searchOwnerInvoiceAutoMatchListVO2);

	    } catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}
    
    /**
	 * Retrieving CalPrepaymentInvoice on Prepayments window(In case selecting Creation)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCalPrepaymentInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0012Event event = (EsmFms0012Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		  
		try {
			
			String chkDuration = command.searchCalPrepaymentInvoiceCheckDuration(event.getCondSearchCalPrepaymentInvoiceListVO());
			
			if(StringUtils.isNotEmpty(chkDuration) && "N".equals(chkDuration)) {	// Over 되는 Hire Duration 체크.
			
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01167",new String[]{}).getUserMessage());
				eventResponse.setETCData("CHK_FLG",chkDuration);
			}else{
			
				List<SearchCalPrepaymentInvoiceListVO> searchCalPrepaymentInvoiceListVOs = command.searchCalPrepaymentInvoiceList(event.getCondSearchCalPrepaymentInvoiceListVO());
				List<SearchCalPrepaymentInvoiceListSumVO> searchCalPrepaymentInvoiceListSumVOs = command.searchCalPrepaymentInvoiceListSum(event.getCondSearchCalPrepaymentInvoiceListVO());
				
				eventResponse.setRsVoList(searchCalPrepaymentInvoiceListVOs);
				eventResponse.setRsVoList(searchCalPrepaymentInvoiceListSumVOs);
				
				/*if(searchCalPrepaymentInvoiceListVOs.size() < 1) {
					eventResponse.setUserMessage((String) new ErrorHandler("FMS01167",new String[]{}).getUserMessage());
				}*/
				eventResponse.setETCData("CHK_FLG",chkDuration);
			}
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving data on Prepayments window(in case selecting Inquiry)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPrepaymentInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0012Event event = (EsmFms0012Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		  
		try {
			InvoiceContainerVO invoiceContainerVO = command.searchPrepaymentInvoiceList(event.getFletCtrtNo(), event.getPpayHirNo(), event.getInvSeq());
			
			List<SearchContractListByPrepaymentHireNoVO> searchContractListByPrepaymentHireNoVOs = invoiceContainerVO.getSearchContractListByPrepaymentHireNoVOs();
			SearchPrepaymentInvoiceVO searchPrepaymentInvoiceVO = invoiceContainerVO.getSearchPrepaymentInvoiceVO();
			SearchHireSysDateVO searchHireSysDateVO = invoiceContainerVO.getSearchHireSysDateVO();
			List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = invoiceContainerVO.getSearchOtrExpnSysDateListVOs();
			List<SearchPrepaymentHireNoListVO> searchPrepaymentHireNoListVOs= invoiceContainerVO.getSearchPrepaymentHireNoListVOs();
			List<SearchPrepaymentHireNoListSumVO> searchPrepaymentHireNoListSumVOs = invoiceContainerVO.getSearchPrepaymentHireNoListSumVOs();

			Map<String,String> etcData = new HashMap<String,String>();

			//********************** Getting CONTRACT table data(START) **********************//
			
			eventResponse.setETCData("fletCtrtNo",searchPrepaymentInvoiceVO.getFletCtrtNo());
			eventResponse.setETCData("vslCd",searchPrepaymentInvoiceVO.getVslCd());
			eventResponse.setETCData("vslEngNm",searchPrepaymentInvoiceVO.getVslEngNm());
			eventResponse.setETCData("fletCtrtTpCd",searchPrepaymentInvoiceVO.getFletCtrtTpCd());
			eventResponse.setETCData("custCntCd",searchPrepaymentInvoiceVO.getCustCntCd());
			eventResponse.setETCData("custSeq",searchPrepaymentInvoiceVO.getCustSeq());
			eventResponse.setETCData("vndrLglEngNm",searchPrepaymentInvoiceVO.getVndrLglEngNm());
			eventResponse.setETCData("ownrNm",searchPrepaymentInvoiceVO.getOwnrNm());
			eventResponse.setETCData("effDt",searchPrepaymentInvoiceVO.getEffDt());
			eventResponse.setETCData("fromTime",searchPrepaymentInvoiceVO.getFromTime());
			eventResponse.setETCData("expDt",searchPrepaymentInvoiceVO.getExpDt());
			eventResponse.setETCData("toTime",searchPrepaymentInvoiceVO.getToTime());
			eventResponse.setETCData("invUsdDys",searchPrepaymentInvoiceVO.getInvUsdDys());
			eventResponse.setETCData("acmmRtAmt",searchPrepaymentInvoiceVO.getAcmmRtAmt());
			eventResponse.setETCData("fletBrogRtAmt",searchPrepaymentInvoiceVO.getFletBrogRtAmt());
			eventResponse.setETCData("acmmFlg",searchPrepaymentInvoiceVO.getAcmmFlg());
			eventResponse.setETCData("brogFlg",searchPrepaymentInvoiceVO.getBrogFlg());
			eventResponse.setETCData("invSeq",searchPrepaymentInvoiceVO.getInvSeq());
			
			//*********************** Getting CONTRACT table data(END) ************************//
			
			//************* Getting latest Hire table data [Hire Information] (START) ************//
			
			if(searchHireSysDateVO != null) {
				eventResponse.setETCData("hirEffDt",searchHireSysDateVO.getEffDt());
				eventResponse.setETCData("hirEffDtTime",searchHireSysDateVO.getEffDtTime()); 
				eventResponse.setETCData("hirExpDt",searchHireSysDateVO.getExpDt());
				eventResponse.setETCData("hirExpDtTime",searchHireSysDateVO.getExpDtTime()); 
				eventResponse.setETCData("hirHirCurrN1stCd",searchHireSysDateVO.getHirCurrN1stCd());
				eventResponse.setETCData("hirHirRtN1stAmt",searchHireSysDateVO.getHirRtN1stAmt());
				eventResponse.setETCData("hirHirCurrN2ndCd",searchHireSysDateVO.getHirCurrN2ndCd());
				eventResponse.setETCData("hirHirRtN2ndAmt",searchHireSysDateVO.getHirRtN2ndAmt());
			} else {
				eventResponse.setETCData("hirEffDt","");
				eventResponse.setETCData("hirEffDtTime",""); 
				eventResponse.setETCData("hirExpDt","");
				eventResponse.setETCData("hirExpDtTime",""); 
				eventResponse.setETCData("hirHirCurrN1stCd","");
				eventResponse.setETCData("hirHirRtN1stAmt","");
				eventResponse.setETCData("hirHirCurrN2ndCd","");
				eventResponse.setETCData("hirHirRtN2ndAmt","");
			}
			
			//************* Getting latest Hire table data [Hire Information] (END) **************//
			
			//*************************** Getting Hire No - For Combo (START) **********************//

			if(   searchContractListByPrepaymentHireNoVOs != null 
			   && searchContractListByPrepaymentHireNoVOs.size() > 0) {
				
				StringBuilder sb = new StringBuilder();
				//String payHirNo = "";
				//String fletCtrtTpCd = "";
				
				for(int i=0; i<searchContractListByPrepaymentHireNoVOs.size(); i++) {
					sb.append(searchContractListByPrepaymentHireNoVOs.get(i).getPpayHirNo()+"|");
				}
				
				etcData.put("payHirNo",sb.toString());
			}
			
			//*************************** Getting Hire No - For Combo (END) ************************//
			
			eventResponse.setETCData(etcData);
			
			eventResponse.setRsVoList(searchOtrExpnSysDateListVOs);
			eventResponse.setRsVoList(searchPrepaymentHireNoListVOs);
			eventResponse.setRsVoList(searchPrepaymentHireNoListSumVOs);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving CalOffhireInvoice on Off-Hire Expenses window(In case selecting Creation)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCalOffhireInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0014Event event = (EsmFms0014Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String,String> etcData = new HashMap<String,String>();
		
		try {
			List<SearchCalOffhireInvoiceListVO> dupCheckList = command.searchCalOffhireInvoiceCheck(event.getCondCalOffhireInvoiceVO());
			
			if(null != dupCheckList && dupCheckList.size() > 0) {	// 동일 기간 OFF-HIRE 입력 불가.
			
				eventResponse.setUserMessage("Your input offhire data is duplicated in data base.");
				etcData.put("DUP_FLG","Y");
			}else{
			
				List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceListVOs = command.searchCalOffhireInvoiceList(event.getCondCalOffhireInvoiceVO());
				
				List<SearchCalOffhireInvoiceListSumVO> searchCalOffhireInvoiceListSumVOs = command.searchCalOffhireInvoiceListSum(event.getCondCalOffhireInvoiceVO());
				
				eventResponse.setRsVoList(searchCalOffhireInvoiceListVOs);
				eventResponse.setRsVoList(searchCalOffhireInvoiceListSumVOs);
				
				if(searchCalOffhireInvoiceListVOs.size() < 1) {
					eventResponse.setUserMessage((String) new ErrorHandler("FMS01167",new String[]{}).getUserMessage());
				}
				etcData.put("DUP_FLG","N");
			}
			eventResponse.setETCData(etcData);
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Getting Voyage corresponding to CtrtNo and Duration<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVvdListByOffHire(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0014Event event = (EsmFms0014Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchVvdListByOffHireVO> searchVvdListByOffHireVO = command.searchVvdListByOffHire(event.getFletCtrtNo(), event.getEffDt(), event.getExpDt(), event.getVslCd());
			
			StringBuilder sb = new StringBuilder();
			
			if(searchVvdListByOffHireVO.size() > 0) {
				for(int i=0; i<searchVvdListByOffHireVO.size(); i++) {
					sb.append(searchVvdListByOffHireVO.get(i).getVvd()+"|");
				}
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("bunker_vvd",sb.toString());
			etcData.put("bunker_vvd_text",sb.toString());
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    
    /**
	 * Registering and Modifying Offhire Expenses information on Off-Hire Expenses window<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOffhireInvoice(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0014Event event = (EsmFms0014Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			CustomOffInvoiceVO customOffInvoiceVO = event.getCustomOffInvoiceVO();
			
			CustomOffInvDtlVO[] customOffInvDtlVOs = event.getCustomOffInvDtlVOS();
			
			String usrId = account.getUsr_id();

			begin();
			command.manageOffhireInvoice(customOffInvoiceVO, customOffInvDtlVOs, usrId);
			
			eventResponse = (GeneralEventResponse)searchOffhireInvoiceList(e);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	

	/**
	 * Retrieving OffhireInvoice data on Off-Hire Expenses window(In case selecting Inquiry )<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffhireInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0014Event event = (EsmFms0014Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		  
		try {
			List<SearchOffhireInvoiceListVO> searchOffhireInvoiceListVOs = command.searchOffhireInvoiceList(event.getFletCtrtNo(), event.getInvSeq());
			
			List<SearchCalOffhireInvoiceListSumVO> searchCalOffhireInvoiceListSumVOs = command.searchOffhireInvoiceListSum(event.getFletCtrtNo(), event.getInvSeq());
			
			//Map<String,String> sumData = new HashMap<String,String>();
			
			//sumData = getCalOffhireInvoiceListSum(searchCalOffhireInvoiceListSumVOs);
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("invSeq",searchOffhireInvoiceListVOs.get(0).getInvSeq());
			etcData.put("DUP_FLG","N"); // Dummy EtcData.
			//etcData.put("totalAmount1",sumData.get("totalAmount1"));
			//etcData.put("totalAmount2",sumData.get("totalAmount2"));
			
			eventResponse.setRsVoList(searchOffhireInvoiceListVOs);
			eventResponse.setRsVoList(searchCalOffhireInvoiceListSumVOs);
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Deleting Prepayments information - In case slip is not be generated<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */	
	private EventResponse removePrepaymentInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0012Event event = (EsmFms0012Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{	
			begin();

			command.removePrepaymentInvoice(event.getFletCtrtNo(), event.getInvSeq());
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	

   /**
	* Retrieving OffhireSelection information on Offhire Selection window<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchOffhireSelectionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0078Event event = (EsmFms0078Event)e;
	    
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			List<SearchOffhireSelectionListVO> searchOffhireSelectionListVO = command.searchOffhireSelectionList(event.getFletCtrtNo());
	
			eventResponse.setRsVoList(searchOffhireSelectionListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
	
	/**
	 * Deleting Owner Ship/Charter In/Hire Out information<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */	
	private EventResponse removeOffhireInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0014Event event = (EsmFms0014Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{	
			begin();

			command.removeOffhireInvoice(event.getFletCtrtNo(), event.getInvSeq());
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Registering Invoice information on Prepayments window<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse creatPrepaymentInvoice(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0012Event event = (EsmFms0012Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			CustomPreInvoiceVO customPreInvoiceVO = event.getCustomPreInvoiceVO();
			
			CustomPreInvDtlVO[] customPreInvDtlVOs = event.getCustomPreInvDtlVOS();
			
			String usrId = account.getUsr_id();

			begin();
			command.creatPrepaymentInvoice(customPreInvoiceVO, customPreInvDtlVOs, usrId);
			
			eventResponse = (GeneralEventResponse)searchPrepaymentInvoiceList(e);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Changing/Deleting Invoice information on Prepayments window<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse managePrepaymentInvoice(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0012Event event = (EsmFms0012Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			CustomPreInvoiceVO customPreInvoiceVO = event.getCustomPreInvoiceVO();
			
			CustomPreInvDtlVO[] customPreInvDtlVOs = event.getCustomPreInvDtlVOS();
			
			String usrId = account.getUsr_id();

			begin();
			command.managePrepaymentInvoice(customPreInvoiceVO, customPreInvDtlVOs, usrId);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * Saving RevenueVvd on Revenue VVD Creation window(Insert / Modify / Delete)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRevenueVvd(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0037Event event = (EsmFms0037Event)e;
	
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	
		try {
			CustomVvdVO[] customVvdVOs = event.getCustomVvdVOS();
	
			String usrId = account.getUsr_id();
	
			begin();
			
			command.manageRevenueVvd(customVvdVOs, usrId);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
	
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }

	/**
	* Retrieving RevenueVvd on Revenue VVD Creation window<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchRevenueVvdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0037Event event = (EsmFms0037Event)e;
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {

			List<SearchRevenueVvdListVO> searchRevenueVvdListVO = command.searchRevenueVvdList(event.getRevYrmon(), event.getSlanCd(), event.getRlaneCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchRevenueVvdListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}

	/**
	* Retrieving FinalRevenueVvd on Revenue VVD Creation window<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchFinalRevenueVvdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0037Event event = (EsmFms0037Event)e;
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {

			List<SearchFinalRevenueVvdListVO> searchFinalRevenueVvdListVO = command.searchFinalRevenueVvdList(event.getRevYrmon(), event.getSlanCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchFinalRevenueVvdListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}

	/**
	* Getting VvdCreation on Revenue VVD Creation window<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchVvdCreationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0037Event event = (EsmFms0037Event)e;
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {

			List<SearchVvdCreationListVO> searchVvdCreationListVO = command.searchVvdCreationList(event.getRevYrmon(), event.getSlanCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchVvdCreationListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}
	
	/**
	 * Event occurring when opening Contract Retrieve window<br>
	 * Getting Contract Type information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractTypeListByContract(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0023Event event = (EsmFms0023Event)e;
		  
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchContractTypeListByContractVO> searchContractTypeListByContractVO = command.searchContractTypeListByContract(event.getTypeFlag());
			
			//fletCtrtTpCd
			StringBuilder sb1 = new StringBuilder();
			
			//fletCtrtTpNm
			StringBuilder sb2 = new StringBuilder();
			
			if(searchContractTypeListByContractVO.size() > 0) {
				for(int i=0; i<searchContractTypeListByContractVO.size(); i++) {
					sb1.append(searchContractTypeListByContractVO.get(i).getCode()+"|");
					sb2.append(searchContractTypeListByContractVO.get(i).getName()+"|");
				}
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("flet_ctrt_tp_cd",sb1.toString());
			etcData.put("flet_ctrt_tp_nm",sb2.toString());
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	* Retrieving RevenueVvdInquiry information on Revenue VVD Inquiry window<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchRevenueVvdInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0038Event event = (EsmFms0038Event)e;
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
	
			List<SearchRevenueVvdInquiryListVO> searchRevenueVvdInquiryListVO = command.searchRevenueVvdInquiryList(event.getRevYrmonFrom(), event.getRevYrmonTo(), event.getSlanCd(), event.getRlaneCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchRevenueVvdInquiryListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}

   /**
	* Getting EstimatedRevenue information on Estimated I/F To ERP(RV) window<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchEstimatedRevenueCreList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0046Event event = (EsmFms0046Event)e;
	    
		TCharterIOEstimatedBC command = new TCharterIOEstimatedBCImpl();
	    
		try {
	
			List<SearchEstimatedRevenueListVO> searchEstimatedRevenueListVO = command.searchEstimatedRevenueCreList(event.getConditionEstmIfVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchEstimatedRevenueListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}

	/**
	 * Generating EstimatedRevenue information on Estimated I/F To ERP(RV) window<br>
	 * 2015.10.26 Create Estimated
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse createEstimatedHireRevenue(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0046Event event = (EsmFms0046Event)e;
	
		TCharterIOEstimatedBC command = new TCharterIOEstimatedBCImpl();
	
		try {
			SearchEstimatedRevenueListVO[] searchEstimatedRevenueListVOs = event.getSearchEstimatedRevenueListVOS();
	
			String usrId = account.getUsr_id();
	
			begin();
			
			command.createEstimatedHireRevenue(searchEstimatedRevenueListVOs, account.getOfc_cd() ,usrId);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
	
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }
	
	/**
	 * Generating EstimatedProRevenue information on Estimated I/F To ERP(PV) window<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse createEstimatedProRevenue(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0048Event event = (EsmFms0048Event)e;
	
		TCharterIOEstimatedBC command = new TCharterIOEstimatedBCImpl();
	
		try {
			CustomEstmIfVO[] customEstmIfVOs = event.getCustomEstmIfVOS();
	
			String usrId = account.getUsr_id();
	
			begin();
			
			command.createEstimatedProRevenue(customEstmIfVOs, account.getOfc_cd() ,usrId);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
	
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }

   /**
	* Retrieving EstimatedProRevenue information on Estimated I/F To ERP(PV) window<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchEstimatedProRevenueList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0048Event event = (EsmFms0048Event)e;
	    
		TCharterIOEstimatedBC command = new TCharterIOEstimatedBCImpl();
	    
		try {
	
			List<SearchEstimatedProRevenueListVO> searchEstimatedProRevenueListVO = command.searchEstimatedProRevenueList(event.getConditionEstmIfVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchEstimatedProRevenueListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}

   /**
	* Retrieving EstimatedHireResult information on Estimated I/F To ERP(RV) window<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchEstimatedHireResultList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0049Event event = (EsmFms0049Event)e;
	    
		TCharterIOEstimatedBC command = new TCharterIOEstimatedBCImpl();
	    
		try {
	
			List<SearchEstimatedRevenueListVO> searchEstimatedRevenueListVO = command.searchEstimatedResultByHireList(event.getConditionEstmIfVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchEstimatedRevenueListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}
	
	/**
	 * Retrieving Revenue Port related to Charter/Hire Out<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRevenuePortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0068Event event = (EsmFms0068Event)e;
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<SearchRevenuePortListVO> searchRevenuePortListVO = command.searchRevenuePortList(event.getSlanCd(), event.getRLaneCd());
			eventResponse.setRsVoList(searchRevenuePortListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Deleting all Revenue Port<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeAllRevenuePort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			begin();
			command.removeAllRevenuePort();
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Modifying Revenue Port<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRevenuePort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0068Event event = (EsmFms0068Event)e;
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
		
		try {
			begin();
			if(event.getSearchType().equals("interface")) {
				command.removeAllRevenuePort();
			}
			command.manageRevenuePort(event.getCustomBsePortVOS(),account.getUsr_id());
			eventResponse = (GeneralEventResponse)searchRevenuePortList(e);
			eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Retrieving Bunker Vvd<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse checkVvdCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0021Event event = (EsmFms0021Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	
		try{
			String bunkerVvd = command.checkVvdCode(event.getBunkerVvd());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("bunkerVvd",bunkerVvd);
			
			eventResponse.setETCData(etcData);
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
    
    /**
	 * Retrieving Center Code<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse checkCenterCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0021Event event = (EsmFms0021Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	
		try{
			String slpLocCd = command.checkCenterCode(event.getCtrCd());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("slpLocCd",slpLocCd);
			
			eventResponse.setETCData(etcData);
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}

   /**
	* Retrieving Tax Data corresponding to CSR No. <br>
	* 
	* @param
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchTaxEvidence(Event e) throws EventException {
	    
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0086Event event = (EsmFms0086Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	    
		try {
			SearchTaxMasterEvidenceVO searchTaxMasterEvidenceVO = command.searchTaxMasterEvidence(event.getCsrNo());
			
			List<SearchTaxDetailEvidenceListVO> searchTaxDetailEvidenceListVO = command.searchTaxDetailEvidenceList(event.getCsrNo());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			if(searchTaxMasterEvidenceVO != null) {
				
				eventResponse.setETCData("taxInvYrmon",searchTaxMasterEvidenceVO.getTaxInvYrmon());
				eventResponse.setETCData("ofcCd",searchTaxMasterEvidenceVO.getOfcCd());
				eventResponse.setETCData("docEvidTpCd",searchTaxMasterEvidenceVO.getDocEvidTpCd());
				eventResponse.setETCData("taxVatTpCd",searchTaxMasterEvidenceVO.getTaxVatTpCd());
				eventResponse.setETCData("taxNaidFlg",searchTaxMasterEvidenceVO.getTaxNaidFlg());
				eventResponse.setETCData("taxDivCd",searchTaxMasterEvidenceVO.getTaxDivCd());
				eventResponse.setETCData("faFlg",searchTaxMasterEvidenceVO.getFaFlg());
				eventResponse.setETCData("taxPlCd",searchTaxMasterEvidenceVO.getTaxPlCd());
				eventResponse.setETCData("taxNslFlg",searchTaxMasterEvidenceVO.getTaxNslFlg());
				eventResponse.setETCData("splRgstNo",searchTaxMasterEvidenceVO.getSplRgstNo());
				eventResponse.setETCData("ownrNm",searchTaxMasterEvidenceVO.getOwnrNm());
				eventResponse.setETCData("coNm",searchTaxMasterEvidenceVO.getCoNm());
				eventResponse.setETCData("bzctNm",searchTaxMasterEvidenceVO.getBzctNm());
				eventResponse.setETCData("bztpNm",searchTaxMasterEvidenceVO.getBztpNm());
				eventResponse.setETCData("splAddr",searchTaxMasterEvidenceVO.getSplAddr());
				eventResponse.setETCData("issDt",searchTaxMasterEvidenceVO.getIssDt());
				eventResponse.setETCData("splAmt",searchTaxMasterEvidenceVO.getSplAmt());
				eventResponse.setETCData("taxAmt",searchTaxMasterEvidenceVO.getTaxAmt());
				eventResponse.setETCData("totalAmt",searchTaxMasterEvidenceVO.getTotalAmt());
			}
			
			eventResponse.setETCData(etcData);
			
			eventResponse.setRsVoList(searchTaxDetailEvidenceListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

	/**
	 * Retrieving generated Brokerage to handling it on Manual slip<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchEmailAddressList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
    	
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<SearchEmailAddressListVO> searchEmailAddressListVO = command.searchEmailAddressList();
			eventResponse.setRsVoList(searchEmailAddressListVO);
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * Getting SDMS information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchChaterInvoiceSdmsList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	
		EsmFms0017Event event = (EsmFms0017Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			List<SearchChaterInvoiceSdmsListVO> searchChaterInvoiceSdmsListVO = command.searchChaterInvoiceSdmsList(event.getFletCtrtNo(), event.getFromPayDt(), event.getToPayDt(), event.getAppFlg());
			eventResponse.setRsVoList(searchChaterInvoiceSdmsListVO);
	    } catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return eventResponse;
	}
    
    /**
	 * Retrieving INV No. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse checkSdmsInvoiceNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0017Event event = (EsmFms0017Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
	
		try{
			String invNo = command.checkSdmsInvoiceNo(event.getInvNo());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("invNo",invNo);
			
			eventResponse.setETCData(etcData);
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
    
    /**
	 * Getting E-mail information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEmailAddress(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0085Event event = (EsmFms0085Event)e;
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
		
		try {
			begin();
			command.manageEmailAddress(event.getCustomEmailAddressVOS(),account.getUsr_id());
			eventResponse = (GeneralEventResponse)searchEmailAddressList(e);
			eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Getting SDMS FinanVvdList<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFinanVvdListByChaterSdms(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0076Event event = (EsmFms0076Event)e;
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchFinanVvdListByChaterSdmsVO> searchFinanVvdListByChaterSdmsVO = command.searchFinanVvdListByChaterSdms(event.getVslCd(), event.getDirection(), event.getRevYrmon());
			
			StringBuilder sb = new StringBuilder();
			
			if(searchFinanVvdListByChaterSdmsVO.size() > 0) {
				for(int i=0; i<searchFinanVvdListByChaterSdmsVO.size(); i++) {
					sb.append(searchFinanVvdListByChaterSdmsVO.get(i).getVvd()+"|");
				}
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("vvd",sb.toString());
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	* Retrieving Cumstomer Code<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchCustomerCode(Event e) throws EventException {
	    
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0032Event event = (EsmFms0032Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();

		try {
			List<SearchCustomerCodeVO> searchCustomerCodeVOList = command.searchCustomerCode(event.getFletCtrtNo());
			if(null != searchCustomerCodeVOList && searchCustomerCodeVOList.size() > 0){
				eventResponse.setETCData("CustCntCd", searchCustomerCodeVOList.get(0).getCustCntCd());
				eventResponse.setETCData("CustSeq", searchCustomerCodeVOList.get(0).getCustSeq());
				eventResponse.setETCData("CustLglEngNm", searchCustomerCodeVOList.get(0).getCustLglEngNm());
			}else{
				eventResponse.setETCData("CustCntCd", "");
				eventResponse.setETCData("CustSeq", "");
				eventResponse.setETCData("CustLglEngNm", "");
			}
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
	
   
    /**
	 * Getting Common Code information<br>
	 * 
	 * @param codeInfoList List<Collection<CodeInfo>>
	 * @param etcCodeNm String[]
	 * @param etcTextNm String[]
	 * @return Map<String, String>
	 * @exception EventException
	 */
    private Map<String, String> getStandardCommonCodeList(List<Collection<CodeInfo>> codeInfoList, String[] etcCodeNm, String[] etcTextNm) throws EventException{
		
	    try{
			if(codeInfoList == null) return null;
			
			// Common Code value
			StringBuilder comboCode = new StringBuilder();
			
			// Common Name value
			StringBuilder comboText = new StringBuilder();
			
			CodeInfo codeInfo = null;
			Iterator<CodeInfo> iterator = null;
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			for(int i=0; i<codeInfoList.size(); i++) {

				iterator = codeInfoList.get(i).iterator();

				while(iterator.hasNext()) {
					codeInfo = iterator.next();
					
					comboCode.append(codeInfo.getCode()+"|");
					comboText.append(codeInfo.getName()+"|");
					
					etcData.put(etcCodeNm[i],comboCode.toString());
					etcData.put(etcTextNm[i],comboText.toString());
				}
				
				comboCode.setLength(0);
				comboText.setLength(0);
			}

			return etcData;
			
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Checking Hire No existing on Prepayments<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHireNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0012Event event = (EsmFms0012Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			String hireNo = "";
			hireNo = command.searchHireNo(event.getFletCtrtNo(), event.getPpayHirNo());
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("hireNo",hireNo);
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Retrieving Contract Type, Vendor Code, Vendor Name related to Contract number on Owner Account to Expense windowbr>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceByPaymentSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0035Event event = (EsmFms0035Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
	//import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchInvoiceByPaymentSlipVO;
		try{
			List<SearchInvoiceByPaymentSlipVO> searchInvoiceByPaymentSlipVO = command.searchInvoiceByPaymentSlip(event.getFletCtrtNo());
			List<SearchInvoiceByPaymentSlipVO> searchInvoiceByPaymentSlipVO2 = command.searchInvoiceByPaymentSlip2(event.getFletCtrtNo());
			if(searchInvoiceByPaymentSlipVO.size() > 0) {
				//Contract Type value of Contract Code Search popup
				//NYK Modify 2014.10.22
				//if (searchInvoiceByPaymentSlipVO.get(0).getFletCtrtTpNm().equals("T/C Out") && !searchInvoiceByPaymentSlipVO2.get(0).getVndrSeq().equals("")) {
				if (searchInvoiceByPaymentSlipVO.get(0).getFletCtrtTpCd().equals("TO") && !searchInvoiceByPaymentSlipVO2.get(0).getVndrSeq().equals("")) {
					Map<String,String> etcData = new HashMap<String,String>();
					etcData.put("fletCtrtTpCd",searchInvoiceByPaymentSlipVO.get(0).getFletCtrtTpCd());
					etcData.put("vndrSeq",searchInvoiceByPaymentSlipVO2.get(0).getVndrSeq());
					etcData.put("vndrNm",searchInvoiceByPaymentSlipVO2.get(0).getVndrLglEngNm());
					etcData.put("fletCtrtTpNm",searchInvoiceByPaymentSlipVO.get(0).getFletCtrtTpNm());
					eventResponse.setETCData(etcData);
				} else {
					Map<String,String> etcData = new HashMap<String,String>();
					etcData.put("fletCtrtTpCd",searchInvoiceByPaymentSlipVO.get(0).getFletCtrtTpCd());
					etcData.put("vndrSeq",searchInvoiceByPaymentSlipVO.get(0).getVndrSeq());
					etcData.put("vndrNm",searchInvoiceByPaymentSlipVO.get(0).getVndrLglEngNm());
					etcData.put("fletCtrtTpNm",searchInvoiceByPaymentSlipVO.get(0).getFletCtrtTpNm());
					eventResponse.setETCData(etcData);
				}
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01505",new String[]{}).getUserMessage());
			}
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	

	/**
	 * Saving data on Owner's Account Expense window<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse managePrepaymentSettlement(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		//ExternalFinderBC etfCmd = new ExternalFinderBCImpl();
	
		EsmFms0035Event event = (EsmFms0035Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	
		try {
			CustomConsultationVO customConsultationVO = event.getCustomConsultationVO();
			CustomCsulSlpVO[] customCsulSlpVOs = event.getCustomCsulSlpVOS();
	
			String usrId = account.getUsr_id();
	
			begin();
			//2015.11.19 NYK Not Used.
			/*
			//Checking Voyage level and deciding either new Contract number or old Contract number then re-setting VO the old Contract number 
			for (int i=0; i<customCsulSlpVOs.length; i++) {
				//Checking Voyage level

				if(   customCsulSlpVOs[i].getVvdCd() != null 
				   && !customCsulSlpVOs[i].getVvdCd().equals("")) {
					
					String level = etfCmd.checkAcctCdVvdLevel(customCsulSlpVOs[i].getAcctCd(), customCsulSlpVOs[i].getVvdCd());
					if (!level.equals("2")) {	
						throw new EventException(new ErrorHandler("FMS01478",new String[]{customCsulSlpVOs[i].getAcctCd(), customCsulSlpVOs[i].getVvdCd()}).getMessage());
					}
				}
			}*/
			   
			//String slpSerNo = command.managePrepaymentSettlement(customConsultationVO, customCsulSlpVOs, usrId);
			String rtnCsrNo = command.managePrepaymentSettlement(customConsultationVO, customCsulSlpVOs, usrId);
	
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			//Ser No. 
			Map<String,String> etcData = new HashMap<String,String>();
	
			//etcData.put("slp_ser_no",slpSerNo);
			etcData.put("csr_no",rtnCsrNo);
			
			eventResponse.setETCData(etcData);
			
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }
	

	   /**
		* Retrieving prepayment data which is not consulted<br>
		* 
		* @param e Event
		* @return response EventResponse
		* @exception EventException
		*/
		private EventResponse searchPrepaymentListByPaymentSlip(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			EsmFms0024Event event = (EsmFms0024Event)e;
		    
			TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
		    
			try {
				
				List<SearchPrepaymentListByPaymentSlipVO> searchPrepaymentListByPaymentSlipVO = command.searchPrepaymentListByPaymentSlip(event.getFletCtrtNo(), event.getOfcCd(), event.getCsrCurrCd());
		
				eventResponse.setRsVoList(searchPrepaymentListByPaymentSlipVO);
		
				return eventResponse;
		
			} catch(EventException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage(), ex);
			} catch(Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler(ex).getMessage(), ex);
			}
	    }
	
	/**
	 * Getting Slip Approval information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception
	 */
	private EventResponse searchSlipApprovalList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0041Event event = (EsmFms0041Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();

		try {
			List<SearchSlipApprovalListVO> searchSlipApprovalListVO = command.searchSlipApprovalList(event.getCondSearchSlipApprovalVO());
			eventResponse.setRsVoList(searchSlipApprovalListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * In Charter case, when slip is consulted, it is sent to ERP A/P
	 * In Hire Out case, when slip is consulted, it is sent to ERP A/R<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSlipApproval(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0052Event event = (EsmFms0052Event)e;
	
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
		AccountPayableInvoiceSC invSC = new AccountPayableInvoiceSC();

		try {
	
			begin();
			
			/* In Charter case, when slip is consulted, it is sent to ERP A/P
			 * In Hire Out case, when slip is consulted, it is sent to ERP A/R*/
			String tmpFletCtrtTpCd = event.getFletCtrtTpCd();
			String tmpAproFlg 	= event.getAproFlg();
			String tmpCsrNo 	= event.getCsrNo();
			String tmpCxlDesc 	= event.getCxlDesc();
			String tmpSlipType 	= event.getSlipType();
			if (tmpSlipType.equals("RV")) {
				tmpFletCtrtTpCd = "RV";
			}
			
			log.debug("\n ============================================================="
					+ "\n manageSlipApproval-------------------------------------------"
					+ "\n Approval Flag    	["+tmpAproFlg+"]"
					+ "\n tmpFletCtrtTpCd  	["+tmpFletCtrtTpCd+"]"
					+ "\n tmpCsrNo         	["+tmpCsrNo+"]"
					+ "\n tmpCxlDesc       	["+tmpCxlDesc+"]"
					+ "\n Slip Type     	["+tmpSlipType+"]"
					+ "\n =============================================================");
			
			log.debug("\n manageSlipApproval ["+tmpCsrNo+"] Approval Yes TO And AR => TCharterIOConsultationBCImpl.manageSlipApproval Call.");
			List<SearchArSlipDetailListVO> searchArSlipDetailListVO = command.manageSlipApproval(tmpFletCtrtTpCd, tmpCsrNo, tmpAproFlg, tmpCxlDesc, account);

			TCharterIOInvoiceBC invcommand = new TCharterIOInvoiceBCImpl();
			
			if ("Y".equals(tmpAproFlg)) {//Approval  
				if (FmsConstants.KEY_SLP_TP_CD_AR_20.equals(tmpCsrNo.substring(0,2))) {//AR	
						if( searchArSlipDetailListVO != null && StringUtils.isNotEmpty(searchArSlipDetailListVO.get(0).getFletIssTpCd())) {
							log.debug("\n manageSlipApproval ["+tmpCsrNo+"] Approval Yes TO And AR => modifySlipApprovalInvoice Call.");
							invcommand.modifySlipApprovalInvoice(searchArSlipDetailListVO);
						}
				}
			} else {//Cancel
				log.debug("\n manageSlipApproval ["+tmpCsrNo+"] Approval Cancel Call Start.");
				
				//AP, AR in common, in case Charter/Hire Out slip is canceled, slip number on Invoice is changed into NULL
				invcommand.modifySlipApprovalCancelInvoice(event.getCsrNo(), account.getUsr_id());
				
				TCharterIOBunkerRegisterBC bnkcommand = new TCharterIOBunkerRegisterBCImpl();
				//In case Charter slip is canceled, slip information on Bunker is changed into NULL
				bnkcommand.modifyApArSlipApprovalCancelBunker(event.getCsrNo(), account.getUsr_id());
				
				//Executing in case AP - TI or value is existed
				/*if (event.getFletCtrtTpCd().equals("TI") || event.getFletCtrtTpCd().equals("")) {
					//in case Charter slip is canceled, slip number on Owner's Account is changed into NULL
					//invcommand.modifySlipApprovalCancelOwnerAccount(event.getCsrNo(), usrId);

					TCharterIOBunkerRegisterBC bnkcommand = new TCharterIOBunkerRegisterBCImpl();
					//In case Charter slip is canceled, slip information on Bunker is changed into NULL
					bnkcommand.modifySlipApprovalCancelBunker(event.getCsrNo(), account.getUsr_id());
				
				// In case Hire out -  AP, AR in common(Bunker Handling) 
				} else if(event.getFletCtrtTpCd().equals("TO")) {
					TCharterIOBunkerRegisterBC bnkcommand = new TCharterIOBunkerRegisterBCImpl();
					//In case Charter slip is canceled, slip information on Bunker is changed into NULL
					bnkcommand.modifyApArSlipApprovalCancelBunker(event.getCsrNo(), account.getUsr_id());
				}*/
				log.debug("\n manageSlipApproval ["+tmpCsrNo+"] Approval Cancel Call E n d.");
			}
			
			int    errCnt = 0;
			String errMsg = "";
			
			if ("Y".equals(tmpAproFlg)) {
				log.debug("\n manageSlipApproval ["+tmpCsrNo+"] Approval Yes Call.");
				//if ("TI".equals(fletCtrtTpCd) || "OW".equals(fletCtrtTpCd) || "".equals(fletCtrtTpCd) || ("TO".equals(fletCtrtTpCd) && "07".equals(tmpCsrNo.substring(0,2)))) {	//AP
				if (FmsConstants.KEY_SLP_TP_CD_AP_07.equals(tmpCsrNo.substring(0,2))) {	//AP
					log.debug("\n manageSlipApproval ["+tmpCsrNo+"] AP Approval => AccountPayableInvoiceSC.manageSapIfValidateImportCheck Call.");
					
					EventResponse apEventResponse = new GeneralEventResponse();
					apEventResponse = invSC.manageSapIfValidateImportCheck("S/O_BIZ", tmpCsrNo, account.getUsr_id());
					
					Map<String, String> mapVO = apEventResponse.getETCData();
					
					if ("FAIL".equals(mapVO.get("SUCCESS_FLG")) ) {
						errCnt++;
						errMsg = mapVO.get("RESULT_MSG");						
					}
				} else {//AR	
					log.debug("\n manageSlipApproval ["+tmpCsrNo+"] AR Approval => AccountReceivableOutstandingBCImpl.createOutstandingByInterface Call.");
					AccountReceivableOutstandingBC sarOtsIfCommand = new AccountReceivableOutstandingBCImpl();
					
					for (int row = 0; row < searchArSlipDetailListVO.size(); row++) {
						sarOtsIfCommand.createOutstandingByInterface(searchArSlipDetailListVO.get(row).getToIfNo() + "1");
					}
				}
			}
			
			if (errCnt > 0) {
				rollback();
				eventResponse.setUserMessage((String) new ErrorHandler("COM12217", new String[]{"["+event.getCsrNo()+"]" + "\n" + errMsg}).getUserMessage());
			} else {						
				commit();
				eventResponse.setUserMessage((String) new ErrorHandler("COM12191", new String[]{event.getCsrNo()}).getUserMessage());
			}
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }

	/**
	 * Retrieving Bond approximate amount History about created Bond<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubletReveuneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0045Event event = (EsmFms0045Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	    
		try {
			List<SearchSubletRevenueListVO> searchSubletRevenueListVO = command.searchSubletReveuneList(event.getCondSearchSebletRevenueVO());
			eventResponse.setRsVoList(searchSubletRevenueListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Retrieving Bond approximate amount History about created Bond<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubletReveuneDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0045Event event = (EsmFms0045Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	    
		try {
			List<SearchSubletReveuneDetailListVO> searchSubletReveuneDetailListVO = command.searchSubletReveuneDetailList(event.getToInvNo(), event.getCsrNo());
			eventResponse.setRsVoList(searchSubletReveuneDetailListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Getting SlipCorrection Master information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception
	 */
	private EventResponse searchSlipCorrectionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0043Event event = (EsmFms0043Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
		
		try {
			List<SearchSlipCorrectionListVO> searchSlipCorrectionListVO = command.searchSlipCorrectionList(event.getCondSearchSlipApprovalVO());
			eventResponse.setRsVoList(searchSlipCorrectionListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * Modifying Description of Slip Master on Slip Correction<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySlipCorrection(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0043Event event = (EsmFms0043Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
		
		try {
			String usrId = account.getUsr_id();

			begin();
			command.modifySlipCorrection(event.getCsrNo(), event.getCsrDesc(), usrId);
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Retrieving ReverseCsrForSublet information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception
	 */
	private EventResponse searchReverseCsrForSubletList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0033Event event = (EsmFms0033Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();

		try {
			List<SearchReverseCsrForSubletListVO> searchReverseCsrForSubletListVO = command.searchReverseCsrForSubletList(event.getCondReverseCsrForSubletVO());
			eventResponse.setRsVoList(searchReverseCsrForSubletListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * Saving ReverseCsrForSublet information(Insert / Modify / delete)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageReverseCsrForSublet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0033Event event = (EsmFms0033Event)e;
		
		TCharterIOConsultationBC tCharterIOConsultationBC = new TCharterIOConsultationBCImpl();
		
		try{
			
			begin();
			String slpSerNo = tCharterIOConsultationBC.manageReverseCsrForSublet(event.getCustomConsultationVO(), event.getCustomCsulSlpVOS(), account.getUsr_id());
			
			event.getCustomCsulSlpSeqVO().setSlpSerNo(slpSerNo);
			
			//2014.10.01 NYK Modify yyMM 포맷으로 변경.
			String tmpSlpIssDt = BizComFmsUtil.getFormatSlpIssueDate(event.getCustomCsulSlpSeqVO().getSlpIssDt().replaceAll("-", ""));
			event.getCustomCsulSlpSeqVO().setSlpIssDt(tmpSlpIssDt);	
			
			List<SearchReverseCsrForSubletSaveListVO> searchReverseCsrForSubletSaveListVO = tCharterIOConsultationBC.searchReverseCsrForSubletSaveList(event.getCustomCsulSlpSeqVO());
			
			eventResponse.setRsVoList(searchReverseCsrForSubletSaveListVO);
			
			eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * Saving SubletRevenueSlip Information(Insert / Modify / Delete)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSubletRevenueSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0032Event event = (EsmFms0032Event)e;
		
		TCharterIOConsultationBC tCharterIOConsultationBC = new TCharterIOConsultationBCImpl();
		
		TCharterIOInvoiceBC tCharterIOInvoiceBC = new TCharterIOInvoiceBCImpl();
		
		TCharterIOBunkerRegisterBC tCharterIOBunkerRegisterBC = new TCharterIOBunkerRegisterBCImpl();
		
		try{
			
			begin();
			
			String slpSerNo = tCharterIOConsultationBC.manageSubletRevenueSlip(event.getCustomConsultationVO(), event.getCustomCsulSlpVOS(), account.getUsr_id());
			
			event.getCustomCsulSlpSeqVO().setSlpSerNo(slpSerNo);
			//2014.10.01 NYK Modify yyMM 포맷으로 변경.
			String tmpSlpIssDt = BizComFmsUtil.getFormatSlpIssueDate(event.getCustomCsulSlpSeqVO().getSlpIssDt().replaceAll("-", ""));
			event.getCustomCsulSlpSeqVO().setSlpIssDt(tmpSlpIssDt);	
			
			tCharterIOInvoiceBC.modifySubletRevenueSlip(event.getCustomCsulSlpVOS());

			tCharterIOBunkerRegisterBC.modifySubletRevenueSlip(event.getCustomCsulSlpVOS());
			
			List<SearchSubletRevenueSlipListVO> searchSubletRevenueSlipListVO = tCharterIOConsultationBC.searchSubletRevenueSlipList(event.getCustomCsulSlpSeqVO());
			
			eventResponse.setRsVoList(searchSubletRevenueSlipListVO);
			
			eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
	 * Saving Manual Slip(Insert / Modify / Delete)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManualSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0040Event event = (EsmFms0040Event)e;
		
		//ExternalFinderBC externalFinderBC = new ExternalFinderBCImpl();
		
		TCharterIOConsultationBC tCharterIOConsultationBC = new TCharterIOConsultationBCImpl();
		
		TCharterIOInvoiceBC tCharterIOInvoiceBC = new TCharterIOInvoiceBCImpl();
		
		try{
			//2015.11.19 NYK Not Used.			
			/*
			CustomCsulSlpVO[] customCsulSlpVOs = event.getCustomCsulSlpVOS();
			//Checking Voyage level
			for (int i=0; i<customCsulSlpVOs.length; i++) {
				if(   customCsulSlpVOs[i].getVvdCd() != null 
				   && !customCsulSlpVOs[i].getVvdCd().equals("")) {
					
					String level = externalFinderBC.checkAcctCdVvdLevel(customCsulSlpVOs[i].getAcctCd(), customCsulSlpVOs[i].getVvdCd());
					if (!level.equals("2")) {	
						throw new EventException(new ErrorHandler("FMS01478",new String[]{customCsulSlpVOs[i].getAcctCd(), customCsulSlpVOs[i].getVvdCd()}).getMessage());
					}
				}
			}*/
			
			begin();
			
			String slpSerNo = tCharterIOConsultationBC.manageManualSlip(event.getCustomConsultationVO(), event.getCustomCsulSlpVOS(), event.getCustomTaxVOS(), event.getCustomTaxDtlVOS(), account.getUsr_id());
			
			event.getCustomCsulSlpSeqVO().setSlpSerNo(slpSerNo);
			//2014.10.01 NYK Modify yyMM 포맷으로 변경.
			String tmpSlpIssDt = BizComFmsUtil.getFormatSlpIssueDate(event.getCustomCsulSlpSeqVO().getSlpIssDt().replaceAll("-", ""));
			event.getCustomCsulSlpSeqVO().setSlpIssDt(tmpSlpIssDt);			
			
			tCharterIOInvoiceBC.modifyManualSlip(event.getCustomCsulSlpVOS());
			
			List<SearchManualSlipListVO> searchManualSlipListVO = tCharterIOConsultationBC.searchManualSlipList(event.getCustomCsulSlpSeqVO());
			
			eventResponse.setRsVoList(searchManualSlipListVO);
			
			eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
	 * Retrieving created Brokerage to handle on Manual Slip<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchBrokerageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	EsmFms00401Event event = (EsmFms00401Event)e;
    	
    	TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
    	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			List<SearchBrokerageListVO> searchBrokerageListVO = command.searchBrokerageList(event.getCurrCd());
			eventResponse.setRsVoList(searchBrokerageListVO);
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
	
	/**
	 * Retrieving COA Voyage on Manual Slip<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchVvdListByManualSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	EsmFms00401Event event = (EsmFms00401Event)e;
    	
    	TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
    	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			List<SearchVvdListByManualSlipVO> searchVvdListByManualSlipVO = command.searchVvdListByManualSlip(event.getFletCtrtNo(), event.getFmDt(), event.getToDt());

			StringBuilder sb = new StringBuilder();
			Map<String,String> etcData = new HashMap<String,String>();
			
			if(searchVvdListByManualSlipVO.size() > 0) {
				for(int i=0; i<searchVvdListByManualSlipVO.size(); i++) {
					sb.append(searchVvdListByManualSlipVO.get(i).getVvdCd() + "|");
				}
			}

			etcData.put("vvdCd", sb.toString());
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
	
	/**
	 * Retrieving paid Bond number<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceNoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms00331Event event = (EsmFms00331Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	    
		try {
			List<SearchInvoiceNoListVO> searchInvoiceNoListVO = command.searchInvoiceNoList(event.getCondSearchInvoiceNoVO());
			eventResponse.setRsVoList(searchInvoiceNoListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * Getting Slip Detail information <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception
	 */
	private EventResponse searchSlipDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0042Event event = (EsmFms0042Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
		
		try {
			List<SearchSlipDetailListVO> searchSlipDetailListVO = command.searchSlipDetailList(event.getCsrNo());
			eventResponse.setRsVoList(searchSlipDetailListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}

	/**
	 * Getting SlipCorrectionDetail information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception
	 */
	private EventResponse searchSlipCorrectionDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0044Event event = (EsmFms0044Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
		
		try {
			List<SearchSlipCorrectionDetailListVO> searchSlipCorrectionDetailListVO = command.searchSlipCorrectionDetailList(event.getCsrNo());
			eventResponse.setRsVoList(searchSlipCorrectionDetailListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}

	/**
	 * Modifying Description of Slip Detail on Slip Correction<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySlipDetailCorrection(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0044Event event = (EsmFms0044Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
		
		try {
			
			CustomCsulSlpVO[] customCsulSlpVOs = event.getCustomCsulSlpVOS();
			
			String csrNo = event.getCsrNo();
			String usrId = account.getUsr_id();

			begin();
			command.modifySlipDetailCorrection(customCsulSlpVOs, csrNo, usrId);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * Retrieving Prepayment information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception
	 */
	private EventResponse searchPrepaymentListByRevenueSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0034Event event = (EsmFms0034Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();

		try {
			List<SearchInvoiceListByRevenueSlipVO> searchInvoiceListByRevenueSlipVO = command.searchPrepaymentListByRevenueSlip(event.getFletCtrtNo(), event.getCurrCd(), account.getOfc_cd());
			eventResponse.setRsVoList(searchInvoiceListByRevenueSlipVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	
    /**
	 * 품의되지 않은 Charterer's Account 대상 자료를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchCharterListByPaymentSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	EsmFms0025Event event = (EsmFms0025Event)e;
	    
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			
			List<SearchCharterListByPaymentSlipVO> searchCharterListByPaymentSlipVO = command.searchCharterListByPaymentSlip(event.getFletCtrtNo(), event.getOfcCd(), event.getCsrCurrCd());
	
			eventResponse.setRsVoList(searchCharterListByPaymentSlipVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    
	 /**
	 * Retrieving the data which is selected to be handled as payment slip on created Offhire Expenses / Window <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchOffhireListByPaymentSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	EsmFms0026Event event = (EsmFms0026Event)e;
	    
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			
			List<SearchOffhireListByPaymentSlipVO> searchOffhireListByPaymentSlipVO = command.searchOffhireListByPaymentSlip(event.getFletCtrtNo(), event.getOfcCd(), event.getCsrCurrCd());
	
			eventResponse.setRsVoList(searchOffhireListByPaymentSlipVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

    /**
	 * Retrieving the data which is selected to be handled as payment slip on created Owner’s Account / Window<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchOwnerListByPaymentSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	EsmFms0028Event event = (EsmFms0028Event)e;
	    
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			
			List<SearchOwnerListByPaymentSlipVO> searchOwnerListByPaymentSlipVO = command.searchOwnerListByPaymentSlip(event.getFletCtrtNo(), event.getOfcCd(), event.getCsrCurrCd());
	
			eventResponse.setRsVoList(searchOwnerListByPaymentSlipVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

    /**
	 * Retrieving the data which is selected to be handled as payment slip on created BOD / BOR Data / Window<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchBunkerListByPaymentSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	EsmFms0027Event event = (EsmFms0027Event)e;
	    
    	TCharterIOBunkerRegisterBC command = new TCharterIOBunkerRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			//NYK Modify 2014.10.22
			List<SearchBunkerListByPaymentSlipVO> searchBunkerListByPaymentSlipVO = command.searchBunkerListByPaymentSlip(event.getSearchBunkerConditionVO());
	
			eventResponse.setRsVoList(searchBunkerListByPaymentSlipVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * Getting file Key attached in E-Mail<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searhAttachFileKey(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0075Event event = (EsmFms0075Event)e;

		try {
			eventResponse.setETCData("fileKey", event.getKeys().get(0));
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	* 미 정리된 선급금 전표를 조회한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchPrepaymentSettleList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0074Event event = (EsmFms0074Event)e;
	    
		TCharterIOSettlementBC command = new TCharterIOSettlementBCImpl();
	    
		try {
			List<SearchPrepaymentSettleListVO > searchPrepaymentSettleListVO  = command.searchPrepaymentSettleList(event.getCondSearchPrepaymentSettleVO(), event.getSignOnUserAccount());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchPrepaymentSettleListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

   /**
	* 미 정리된 선급금 전표를 항차별로 분리한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchPrepaymentSettleVvdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0074Event event = (EsmFms0074Event)e;
	    
		TCharterIOSettlementBC command = new TCharterIOSettlementBCImpl();
	    
		try {
			List<SearchPrepaymentSettleVvdListVO > searchPrepaymentSettleVvdListVO  = command.searchPrepaymentSettleVvdList(event.getCondSearchPrepaymentSettleVvdVO());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			if (searchPrepaymentSettleVvdListVO.size() > 0) {
				//항차가 존재하지 않음
				if (searchPrepaymentSettleVvdListVO.get(0).getVvdCd().equals("NOVVD")) {
					eventResponse.setUserMessage((String) new ErrorHandler("FMS01509",new String[]{}).getUserMessage());
				//불연속 항차
				} else if (searchPrepaymentSettleVvdListVO.get(0).getVvdCd().equals("DISVVD")) {
					eventResponse.setUserMessage((String) new ErrorHandler("FMS01510",new String[]{}).getUserMessage());
				} else {					
					log.debug("111 searchPrepaymentSettleVvdListVO.size() = "+searchPrepaymentSettleVvdListVO.size());
					//NYK Modify 2014.10.06
					//searchPrepaymentSettleVvdListVO.remove(searchPrepaymentSettleVvdListVO.size()-1);				
					eventResponse.setRsVoList(searchPrepaymentSettleVvdListVO);
					log.debug("222 searchPrepaymentSettleVvdListVO.size() = "+searchPrepaymentSettleVvdListVO.size());	
				}
			}
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	
	/**
	 * ESM_FMS_0041 : Reject
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse rejectConsultation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmFms0041Event event = (EsmFms0041Event) e;
		TCharterIOConsultationBC command  = new TCharterIOConsultationBCImpl();
		try {
			begin();
			SearchSlipApprovalListVO vo = event.getSearchSlipApprovalListVO();
			String tmpFletCtrtTpCd = vo.getFletCtrtTpCd();
			String tmpAproFlg = vo.getAproFlg();
			String tmpCsrNo = vo.getSlpNo();
			String tmpCxlDesc = vo.getCxlDesc();
			String tmpRcvErrFlg = vo.getRcvErrFlg(); //AP Reject Flag.(Y) 
			
			log.debug("\n ============================================================="
					+ "\n rejectConsultation-------------------------------------------"
					+ "\n Approval Flag    	["+tmpAproFlg+"]"
					+ "\n tmpFletCtrtTpCd  	["+tmpFletCtrtTpCd+"]"
					+ "\n tmpCsrNo         	["+tmpCsrNo+"]"
					+ "\n tmpCxlDesc       	["+tmpCxlDesc+"]"
					+ "\n tmpRcvErrFlg     	["+tmpRcvErrFlg+"]"
					+ "\n =============================================================");
			
			if("Y".equals(tmpRcvErrFlg)){
				log.debug("\n rejectConsultation ["+tmpCsrNo+"] Approval Cancel Call Start.");
				command.manageSlipApproval(tmpFletCtrtTpCd, tmpCsrNo, tmpAproFlg, tmpCxlDesc, account);
				
				
				TCharterIOInvoiceBC invcommand = new TCharterIOInvoiceBCImpl();
				//AP, AR in common, in case Charter/Hire Out slip is canceled, slip number on Invoice is changed into NULL
				invcommand.modifySlipApprovalCancelInvoice(tmpCsrNo, account.getUsr_id());
				
				TCharterIOBunkerRegisterBC bnkcommand = new TCharterIOBunkerRegisterBCImpl();
				//In case Charter slip is canceled, slip information on Bunker is changed into NULL
				bnkcommand.modifyApArSlipApprovalCancelBunker(tmpCsrNo, account.getUsr_id());
				
				/*
				//Executing in case AP - TI or value is existed
				if (tmpFletCtrtTpCd.equals("TI") || tmpFletCtrtTpCd.equals("")) {
					//in case Charter slip is canceled, slip number on Owner's Account is changed into NULL
					//invcommand.modifySlipApprovalCancelOwnerAccount(event.getCsrNo(), usrId);
	
					TCharterIOBunkerRegisterBC bnkcommand = new TCharterIOBunkerRegisterBCImpl();
					//In case Charter slip is canceled, slip information on Bunker is changed into NULL
					bnkcommand.modifySlipApprovalCancelBunker(tmpCsrNo, account.getUsr_id());
				
				// In case Hire out -  AP, AR in common(Bunker Handling) 
				} else if(tmpFletCtrtTpCd.equals("TO")) {
					TCharterIOBunkerRegisterBC bnkcommand = new TCharterIOBunkerRegisterBCImpl();
					//In case Charter slip is canceled, slip information on Bunker is changed into NULL
					bnkcommand.modifyApArSlipApprovalCancelBunker(tmpCsrNo, account.getUsr_id());
				}*/
				log.debug("\n rejectConsultation ["+tmpCsrNo+"] Approval Cancel Call E n d.");
			}
			commit();
			eventResponse.setUserMessage((String) new ErrorHandler("COM12191", new String[]{tmpCsrNo}).getUserMessage());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	

   /**
	* Getting EstimatedRevenue information Search on Estimated I/F To ERP(RV) window<br>
	* 기 등록된 Data Retrieve
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchEstimatedResultByHireList(Event e) throws EventException {
		EsmFms0046Event event = (EsmFms0046Event)e;
	    
		TCharterIOEstimatedBC command = new TCharterIOEstimatedBCImpl();
	    
		try {
	
			List<SearchEstimatedRevenueListVO> searchEstimatedRevenueListVO = command.searchEstimatedResultByHireList(event.getConditionEstmIfVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchEstimatedRevenueListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}	

   /**
	* Getting EstimatedRevenue information Search on Estimated I/F To ERP(PV) window<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchEstimatedResultByProList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0048Event event = (EsmFms0048Event)e;
	    
		TCharterIOEstimatedBC command = new TCharterIOEstimatedBCImpl();
	    
		try {
	
			List<SearchEstimatedRevenueListVO> searchEstimatedRevenueListVO = command.searchEstimatedResultByProList(event.getConditionEstmIfVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchEstimatedRevenueListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}
	
	/**
	 * Getting Slip Approval information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception
	 */
	private EventResponse searchConsultationSlipList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0087Event event = (EsmFms0087Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();

		try {
			List<SearchSlipApprovalListVO> searchSlipApprovalListVO = command.searchConsultationSlipList(event.getCondSearchSlipApprovalVO());
			eventResponse.setRsVoList(searchSlipApprovalListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}
}