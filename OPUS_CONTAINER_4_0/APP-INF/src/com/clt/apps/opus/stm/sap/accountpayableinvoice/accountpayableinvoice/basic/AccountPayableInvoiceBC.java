/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceBC.java
*@FileTitle : AccountPayableInvoiceBC
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.11
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.APManualInvoiceAccuralCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceAccrualCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceAccrualVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceApprovalInfoListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceApprovalListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryLineListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoicePayScheduleListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceReceiptCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceReceiptListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipDetailListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipPaymentListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoicePrintVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.SapInvoiceInterfaceDetailVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.SapInvoiceInterfaceHeaderVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.UnsettledAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.UnsettledEntryCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentSettlementInvoiceListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentSettlementApplyListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentSettlementUnapplyListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.AsaInfoVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchEntryVendorSumInfoVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentEntryLineVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchSelectedListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingInvoiceCancelCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingInvoiceCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingPaymentCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APAccountingListVO;


/**
 * OPUS-SAP Invoices Business Logic Command Interface<br>
 *
 * @author KIM, O R 
 * @see AccountPayableInvoiceSC 
 * @since J2EE 1.6
 */
public interface AccountPayableInvoiceBC {
	

	/**
	 * [STM_SAP_0010] Retrieve<br>
	 * [HEADER] - Invoice Header List retrieve<br>
	 *
	 * @param InvoiceEntryCondVO invoiceEntryCondVO
	 * @return List<InvoiceEntryListVO>
	 * @exception EventException
	 */
	public List<InvoiceEntryListVO> searchInvoiceEntryList(InvoiceEntryCondVO invoiceEntryCondVO) throws EventException;	

	
	/**
	 * [STM_SAP_0010] Retrieve<br>
	 * [LINE] tab - Invoice Line List retrieve<br>
	 *
	 * @param String invoiceID
	 * @return List<InvoiceEntryLineListVO>
	 * @exception EventException
	 */
	public List<InvoiceEntryLineListVO> searchInvoiceEntryLineList(String invoiceID) throws EventException;
	

	/**
	 * [STM_SAP_0010] Retrieve<br>
	 * [Payment Schedule] tab - Payment Schedule List retrieve<br>
	 *
	 * @param String invoiceID
	 * @return List<InvoicePayScheduleListVO>
	 * @exception EventException
	 */
	public List<InvoicePayScheduleListVO> searchInvoicePayScheduleList(String invoiceID) throws EventException;
	
	/**
	 * [STM_SAP_0010]
	 * [header] / [line] [payment schedule] tab list save<br>
	 *
	 * @param InvoiceEntryListVO[] invoiceEntryListVOs
	 * @param InvoiceEntryLineListVO[] invoiceEntryLineListVOs 
	 * @param InvoicePayScheduleListVO[] invoicePayScheduleListVOs
	 * @param SignOnUserAccount account
	 * @param String ap_ofc_cd
	 * @return String
	 * @exception EventException
	 */
	public String manageInvoiceEntryInfo(InvoiceEntryListVO[] invoiceEntryListVOs, InvoiceEntryLineListVO[] invoiceEntryLineListVOs, InvoicePayScheduleListVO[] invoicePayScheduleListVOs, SignOnUserAccount account, String ap_ofc_cd) throws EventException;

	
	/**
	 * [STM_SAP_0010]
	 * INVOICES list delete<br>
	 *
	 * @param InvoiceEntryListVO[] invoiceEntryListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeInvoiceEntryInfo(InvoiceEntryListVO[] invoiceEntryListVOs, SignOnUserAccount account) throws EventException ;
	
	
	/**
	 * [STM_SAP_0010]
	 * searchLineVendorInvoiceNoDupCheck <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchLineVendorInvoiceNoDupCheck(SapCommonVO sapCommonVO) throws EventException;
	
	
	/**
	 * [STM_SAP_0010]
	 * searchInvoiceStatusCheck <br>
	 * 
	 * @param String inv_seq
	 * @return String
	 * @exception EventException
	*/
	public String searchInvoiceStatusCheck(String inv_seq) throws EventException;
	
	/**
	 * [STM_SAP_0010]
	 * searchLineAccountTypeList <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return List<SapCommonVO> 
	 * @exception EventException
	*/
	public List<SapCommonVO> searchLineAccountTypeList(SapCommonVO sapCommonVO) throws EventException;
	
	/**
	 * [STM_SAP_0010]
	 * searchInvoiceLiabilityAccountCheck <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return List<SapCommonVO> 
	 * @exception EventException
	*/
	public List<SapCommonVO> searchInvoiceLiabilityAccountCheck(SapCommonVO sapCommonVO) throws EventException;
	

	/**
	 * [STM_SAP_0010]
	 * manageInvoiceApprovalInfo <br>
	 *
	 * @param InvoiceEntryListVO[] invoiceEntryListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageInvoiceCancelInfo(InvoiceEntryListVO[] invoiceEntryListVOs,  SignOnUserAccount account) throws EventException;

	
	/**
	 * [STM_SAP_0010]
	 * searchAccountValiInfo <br>
	 * 
	 * @param String acct_cd
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchAccountValiInfo(String acct_cd) throws EventException;
	
	
	/**
	 * [STM_SAP_0010]
	 * searchVendorValiInfo <br>
	 * 
	 * @param String vendor_no
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchVendorValiInfo(String vendor_no) throws EventException;	
	
	/**
	 * [STM_SAP_0010]
	 * searchOffValiInfo <br>
	 * 
	 * @param String ofc_cd
	 * @param String securityFlag
	 * @param SignOnUserAccount account
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchOffValiInfo(String ofc_cd, String securityFlag, SignOnUserAccount account) throws EventException;	
	
	/**
	 * [STM_SAP_0010]
	 * searchInvoiceASAPeriodToDateInfo <br>
	 * 
	 * @param String asa_no
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchInvoiceASAPeriodToDateInfo(String asa_no) throws EventException;
	
	
	/**
	 * [STM_SAP_0010]
	 * searchLegrValiInfo <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return List<SapCommonVO> 
	 * @exception EventException
	*/
	public List<SapCommonVO> searchLegrValiInfo(SapCommonVO sapCommonVO) throws EventException;
	
	
	/**
	 * [STM_SAP_0010]
	 * searchAsaValiInfo <br>
	 * 
	 * @param String asa_no
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchAsaValiInfo(String asa_no) throws EventException;		
	
	/**
	 * [STM_SAP_0010]
	 * searchSupplierBankValiInfo <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchSupplierBankValiInfo(SapCommonVO sapCommonVO) throws EventException;	
	
	/**
	 * [STM_SAP_0010]
	 * searchInvoiceASACloseStatusCheck <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return String
	 * @exception EventException
	*/
	public String searchInvoiceASACloseStatusCheck(SapCommonVO sapCommonVO) throws EventException;
	
	/**
	 * [STM_SAP_0010]
	 * searchInvoiceInterfaceToSAKURAStatusCheck <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return String
	 * @exception EventException
	*/
	public String searchInvoiceInterfaceToSAKURAStatusCheck(SapCommonVO sapCommonVO) throws EventException;
	
	/**
	 * [STM_SAP_0010] [STM_SAP_0240]] [STM_SAP_0030]
	 * printInvoiceList <br>
	 * @param  InvoicePrintVO[] invoicePrintVOs
	 * @param  SignOnUserAccount account
	 * @param  String call_flag
	 * @return String
	 * @exception EventException
	*/	
	public String printInvoiceList(InvoicePrintVO[] invoicePrintVOs, SignOnUserAccount account, String call_flag) throws EventException;	

		
	/**
	 * [STM_SAP_0241] Retrieve<br>
	 * Prepayment Apply-Unapply Invoices - Header Info Retrieve <br>
	 *
	 * @param String inv_seq
	 * @return List<PrepaymentSettlementInvoiceListVO>
	 * @exception EventException
	 */
	public List<PrepaymentSettlementInvoiceListVO> searchPrepaymentSettlementInvoiceList(String inv_seq) throws EventException;	

	
	/**
	 * [STM_SAP_0241] Retrieve<br>
	 * Prepayment Apply-Unapply Invoices - Apply Info Retrieve <br>
	 *
	 * @param PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO
	 * @return List<PrepaymentSettlementApplyListVO>
	 * @exception EventException
	 */
	public List<PrepaymentSettlementApplyListVO> searchPrepaymentSettlementApplyList(PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO) throws EventException;	
	
	/**
	 * [STM_SAP_0241] Retrieve<br>
	 * Prepayment Apply-Unapply Invoices - Unapply Info Retrieve <br>
	 *
	 * @param PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO
	 * @return List<PrepaymentSettlementUnapplyListVO>
	 * @exception EventException
	 */
	public List<PrepaymentSettlementUnapplyListVO> searchPrepaymentSettlementUnapplyList(PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO) throws EventException;		

	/**
	 * [STM_SAP_0241]<br>
	 * searchPrepayGLDatePeriodInfo <br>
	 *
	 * @param String gl_date
	 * @param String off_cd 
	 * @return String
	 * @exception EventException
	 */
	public String searchPrepayGLDatePeriodInfo(String gl_date, String off_cd ) throws EventException;		


	/**
	 * [STM_SAP_0241]
	 * 
	 * @param PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO
	 * @param PrepaymentSettlementApplyListVO[] prepaymentSettlementApplyListVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String managePrepaymentApplyInfo(PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO,  PrepaymentSettlementApplyListVO[] prepaymentSettlementApplyListVOs, SignOnUserAccount account) throws EventException;

	
	/**
	 * [STM_SAP_0241]
	 * 
	 * @param PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO
	 * @param PrepaymentSettlementUnapplyListVO[] prepaymentSettlementUnapplyListVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String managePrepaymentUnApplyInfo(PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO,  PrepaymentSettlementUnapplyListVO[] prepaymentSettlementUnapplyListVOs, SignOnUserAccount account) throws EventException;


	
	/**
	 * [STM_SAP_0210]

	 * @category STM_SAP_0210
	 * @category modifyPaymentSelectedInvoiceReturnInfo
	 * @param List<PaymentBatchSelectedListVO> paymentBatchSelectedListVO
	 * @exception EventException
	 */
	public void modifyPaymentSelectedInvoiceReturnInfo(List<PaymentBatchSelectedListVO> paymentBatchSelectedListVO) throws EventException;

	/**
	 * [STM_SAP_0210]

	 * @category STM_SAP_0210
	 * @category modifyPaymentSelectedInvoiceFixInfo
	 * @param List<PaymentBatchSelectedListVO> paymentBatchSelectedListVO
	 * @exception EventException
	 */
	public void modifyPaymentSelectedInvoiceFixInfo(List<PaymentBatchSelectedListVO> paymentBatchSelectedListVO) throws EventException;
	 
	/**
	 * [STM_SAP_0210]

	 * @category STM_SAP_0210
	 * @category modifyPayCaptureSelectedInvoiceChangeInfo
	 * @param List<PaymentBatchListVO> paymentBatchListVO
	 * @exception EventException
	 */
	public void modifyPayCaptureSelectedInvoiceChangeInfo(List<PaymentBatchListVO> paymentBatchListVO) throws EventException;

	/**
	 * [STM_SAP_0210]
	 * managePaymentSelectedInvoiceInfo<br>
	 *
	 * @param PaymentBatchListVO[] paymentBatchListVOs
	 * @param PaymentBatchSelectedListVO[] paymentBatchSelectedListVOs
	 * @param String fCurrCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePaymentSelectedInvoiceInfo(PaymentBatchListVO[] paymentBatchListVOs, PaymentBatchSelectedListVO[] paymentBatchSelectedListVOs, String fCurrCd, SignOnUserAccount account) throws EventException;

	/**
	 * [STM_SAP_0210]
	 * managePaymentCaptureInfo<br>
	 *
	 * @param PaymentBatchListVO[] paymentBatchListVOs
	 * @param PaymentBatchSelectedListVO[] paymentBatchSelectedListVOs
	 * @param String fCurrCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePaymentCaptureInfo(PaymentBatchListVO[] paymentBatchListVOs, PaymentBatchSelectedListVO[] paymentBatchSelectedListVOs, String fCurrCd, SignOnUserAccount account) throws EventException;

	
	/**
	 * [STM_SAP_0210]
	 * managePaymentConfirmInfo<br>
	 *
	 * @param List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVOList
	 * @exception EventException
	 */
	public void managePaymentConfirmInfo(List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVOList) throws EventException;

	/**
	 * CREATE Invoice Interface Header<br>
	 * 
	 * @author ORKIM
	 * @category addInvoiceHeaderIF
	 * @param List<SapInvoiceInterfaceHeaderVO> sapInvoiceInterfaceHeaderVOList
	 * @exception EventException
	 */
	public void addInvoiceHeaderIF(List<SapInvoiceInterfaceHeaderVO> sapInvoiceInterfaceHeaderVOList) throws EventException;

	/**
	 * CREATE Invoice Interface Detail<br>
	 * 
	 * @author ORKIM
	 * @category addInvoiceLineIF
	 * @param List<SapInvoiceInterfaceDetailVO> sapInvoiceInterfaceDetailVOList
	 * @exception EventException
	 */
	public void addInvoiceLineIF(List<SapInvoiceInterfaceDetailVO> sapInvoiceInterfaceDetailVOList) throws EventException;
	 
	/**
	 * Search Invoice Header IF Next Sequence <br>
	 * 
	 * @author ORKIM
	 * @category searchInoviceHeaderIFNextSeq
	 * @return String rtnValue (SAP_INV_HDR_IF_SEQ.NEXTVAL)
	 * @exception EventException
	*/
	public String searchInoviceHeaderIFNextSeq() throws EventException;
	
	/**
	 * [STM_SAP_0220]
	 * modifyAccountingDetailInvLineFlag<br>
	 * 
	 * @author ORKIM
	 * @category modifyAccountingDetailInvLineFlag
	 * @param List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs
	 * @exception EventException
	 */
	public void modifyAccountingDetailInvLineFlag(List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs) throws EventException;
	
	/**
	 * [STM_SAP_0220]
	 * modifyAccountingDetailInvLineCancelFlag<br>
	 * 
	 * @author ORKIM
	 * @category modifyAccountingDetailInvLineFlag
	 * @param List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs
	 * @exception EventException
	 */
	public void modifyAccountingDetailInvLineCancelFlag(List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs) throws EventException;

	/**
	 * [STM_SAP_0220]
	 * modifyAccountingDetailPrepayApplyLineFlag<br>
	 * 
	 * @author ORKIM
	 * @category modifyAccountingDetailPrepayApplyLineFlag
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception EventException
	 */
	public void modifyAccountingDetailPrepayApplyLineFlag(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws EventException;

	/**
	 * [STM_SAP_0220]
	 * modifyAccountingDetailInvoiceLineRestore<br>
	 * 
	 * @author ORKIM
	 * @category modifyAccountingDetailInvoiceLineRestore
	 * @param List<APAccountingListVO> aPAccountingListVOs
	 * @exception EventException
	 */
	public void modifyAccountingDetailInvoiceLineRestore(List<APAccountingListVO> aPAccountingListVOs) throws EventException;

	
	/**
	 * [STM_SAP_0010] <br>
	 * searhAsaInfoList<br>
	 *
	 * @param String ofc_cd
	 * @param String inv_seq
	 * @param String inv_curr_cd
	 * @return List<AsaInfoVO>
	 * @exception EventException
	 */
	public List<AsaInfoVO> searhAsaInfoList(String ofc_cd, String inv_seq, String inv_curr_cd) throws EventException;
	
	/**
	 * [STM_SAP_0010]
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchAsaIFTransYN
	 * @param String inv_seq
	 * @return String
	 * @exception EventException
	 */
	public String searchAsaIFTransYN(String inv_seq) throws EventException;  
	
	/**
	 * [STM_SAP_0010]
	 * searchOfficeRegionEnableVendorCheck<br> 
	 * @author KSJO
	 * @param String ofcCd
	 * @param String vndrCd
	 * @return String
	 * @exception EventException
    */    
    public String searchOfficeRegionEnableVendorCheck(String ofcCd, String vndrCd) throws EventException;
    
    /**
	 * [STM_SAP_0240]
	 * searchOfficeRegionEnableVendorPrepayCheck<br> 
	 * @author KSJO
	 * @param String ofcCd
	 * @param String vndrCd
	 * @return String
	 * @exception EventException
    */    
    public String searchOfficeRegionEnableVendorPrepayCheck(String ofcCd, String vndrCd) throws EventException;
	
    /**
	 * [STM_SAP_0020]
	 * Invoice Approval List -  retrieve<br> 
	 * @author JBLEE
	 * @param String ofcCd
	 * @param String vndrNo
	 * @param String creDt
	 * @param String invNo
	 * @return List<InvoiceApprovalListVO>
	 * @exception EventException
    */    
    public List<InvoiceApprovalListVO> searchInvoiceApprovalList(String ofcCd, String vndrNo, String creDt, String invNo) throws EventException;
    
    /**
	 * [STM_SAP_0020]
	 * Invoice Approval<br> 
	 * @author JBLEE
	 * @param InvoiceApprovalInfoListVO[] invoiceApprovalInfoListVOs
	 * @param String lginUsrApOfc
	 * @param SignOnUserAccount account
	 * @exception EventException
    */    
    public void modifyInvoiceApprovalInfo(InvoiceApprovalInfoListVO[] invoiceApprovalInfoListVOs, String lginUsrApOfc, SignOnUserAccount account) throws EventException; 
    
    /**
	 * [STM_SAP_0020]
	 * Invoice Cancel<br> 
	 * @author JBLEE
	 * @param InvoiceEntryListVO[] invoiceEntryListVOs
	 * @param String usrId
	 * @exception EventException
    */    
    public void manageInvoiceApprovalInfo(InvoiceEntryListVO[] invoiceEntryListVOs, String usrId) throws EventException;
    	
    /**
	 *[STM_SAP_0040]
	 * CSR Receipt Entry - retrieve<br> 
	 * @author JBLEE
	 * @param InvoiceReceiptCondVO invoiceReceiptCondVO
	 * @return List<InvoiceReceiptListVO>
	 * @exception EventException
    */   
	public List<InvoiceReceiptListVO> searchInvoiceReceiptList(InvoiceReceiptCondVO invoiceReceiptCondVO) throws EventException;
	
    /**
	 *[STM_SAP_0040]
	 * CSR Receipt Entry - Confirm<br> 
	 * @author JBLEE
	 * @param InvoiceReceiptListVO[] invoiceReceiptListVOs
	 * @param String lginUsrApOfc
	 * @param String loclTm
	 * @param String usrId
	 * @exception EventException
    */    
    public void manageInvoiceReceiptInfo(InvoiceReceiptListVO[] invoiceReceiptListVOs, String lginUsrApOfc, String loclTm, String usrId) throws EventException;
    
    /**
	 * [STM_SAP_0040]
	 * CSR Receipt Entry - Release<br> 
	 * @author JBLEE
	 * @param InvoiceReceiptListVO[] invoiceReceiptListVOs
	 * @param String usrId
	 * @exception EventException
    */    
    public void modifyInvoiceReceiptReleaseInfo(InvoiceReceiptListVO[] invoiceReceiptListVOs, String usrId) throws EventException;
    
    /**
	 * [STM_SAP_0040]
	 * CSR Receipt Entry - save<br> 
	 * @author JBLEE
	 * @param InvoiceReceiptListVO[] invoiceReceiptListVOs
	 * @param String usrId
	 * @exception EventException
    */    
    public void manageInvoiceReceiptEntryInfo(InvoiceReceiptListVO[] invoiceReceiptListVOs, String usrId) throws EventException;
    
    /**
	 * [STM_SAP_B001]
	 * ASA Interface Update<br> 
	 * @author JBLEE
	 * @param List<InvoiceEntryLineListVO> invoiceEntryLineListVOs
	 * @exception EventException
    */    
    public void modifyASAInterfaceFlag(List<InvoiceEntryLineListVO> invoiceEntryLineListVOs) throws EventException;
    
     /**
	 * [STM_SAP_0030]
	 *  Invoice Slip - Invoice Header Retrieve<br>
	 *
	 * @author Hannah Lee
	 * @param InvoiceSlipCondVO invoiceSlipCondVO
	 * @param SignOnUserAccount account
	 * @return List<InvoiceSlipListVO>
	 * @exception EventException
	 */
    public List<InvoiceSlipListVO> searchInvoiceSlipList(InvoiceSlipCondVO invoiceSlipCondVO, SignOnUserAccount account) throws EventException;
    
    /**
   	 * [STM_SAP_0030]
   	 *  Invoice Slip - Invoice Line (TAB) Retrieve<br>
   	 *
   	 * @author Hannah Lee
   	 * @param String invSeq
   	 * @param String invCurrCd 
   	 * @return List<InvoiceSlipDetailListVO>
   	 * @exception EventException
   	 */
    public List<InvoiceSlipDetailListVO> searchInvoiceSlipDetailList(String invSeq, String invCurrCd) throws EventException;
       
    /**
	 * [STM_SAP_0030]
	 *  Invoice Slip - Invoice Payment (TAB) Retrieve<br>
	 *
	 * @author Hannah Lee
	 * @param String invSeq
	 * @return List<InvoiceSlipPaymentListVO>
	 * @exception EventException
	 */
    public List<InvoiceSlipPaymentListVO> searchInvoiceSlipPaymentList(String invSeq) throws EventException;      
  	
    
    /**
	 * [STM_SAP_0060]
	 *  Payment Entry Invoice & Skd 등록<br>
	 *
	 * @author sangyoung cha
	 * @param List<PaymentEntryLineVO> insertVoListLine
	 * @exception EventException
	 */    
    public void managePaymentInvSkd(List<PaymentEntryLineVO> insertVoListLine) throws EventException;
    
    /**
	 * [STM_SAP_0060]
	 *  Payment Entry Invoice & Skd 취소 및 환원<br>
	 *
	 * @author sangyoung cha
	 * @param List<PaymentEntryLineVO> voidVoLineList
	 * @exception EventException
	 */    
    public void managePaymentInvSkdCancel(List<PaymentEntryLineVO> voidVoLineList) throws EventException;    
    
    /**
	 * [STM_SAP_0340]
	 *  Unsettled Summary에  전월 미결 자료 내역이 존재 여부 체크<br>
	 *
	 * @author sangyoung cha
	 * @param String glDt
	 * @return SapCommonVO
	 * @exception EventException
	 */
    public SapCommonVO searchUnsettledAccountSummaryExistsCheck(String glDt) throws EventException;  
 
    /**
     * [STM_SAP_0340]
     * Unsettled Report By Account -  retrieve<br> 
     * @author sangyoung cha
     * @param UnsettledEntryCondVO unsettledEntryCondVO
     * @param SignOnUserAccount account
     * @return List<UnsettledAccountListVO>
     * @exception EventException
	*/    
    public List<UnsettledAccountListVO> searchUnsettledAccountList(UnsettledEntryCondVO unsettledEntryCondVO, SignOnUserAccount account) throws EventException ;
    
    /**
	 * [STM_SAP_0340]
	 *  Capture 처리할 대상월의 Period가 닫혀 있는지를 확인 체크<br>
	 *
	 * @author sangyoung cha
	 * @param String unstlYrmon
	 * @return SapCommonVO
	 * @exception EventException
	 */
    public SapCommonVO selectUnsettledAccountCapturePeriodCheck(String unstlYrmon) throws EventException;
    
    /**
	 * [STM_SAP_0340]
	 *  Unsettled Report By Account - capture <br>
	 *
	 * @author sangyoung cha
	 * @param String unstlYrmon
	 * @param String usrId
	 * @exception EventException
	 */    
    public void manageUnsettledAcctCaptureInfo(String unstlYrmon, String usrId) throws EventException;    
    
	
    /**
	 * [STM_SAP_0250]
	 *  SAP_IF_VALIDATE_IMPORT_CHECK <br>
	 *
	 * @author sangyoung cha
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceReqNumCheck() throws EventException;
    
    
    /**
	 * [STM_SAP_0250]
	 *  searchSapInvoiceInterfaceHeader <br>
	 *
	 * @author sangyoung cha
	 * @param String csrNo
	 * @return SapInvoiceInterfaceHeaderVO
	 * @exception EventException
	 */    
    public SapInvoiceInterfaceHeaderVO searchSapInvoiceInterfaceHeader(String csrNo) throws EventException ;
    
    
    /**
	 * [STM_SAP_0250]
	 *  searchSoInvoiceInterfaceHeader <br>
	 *
	 * @author sangyoung cha
	 * @param String csrNo
	 * @param String ifRequestSeq
	 * @return SapInvoiceInterfaceHeaderVO
	 * @exception EventException
	 */    
    public SapInvoiceInterfaceHeaderVO searchSoInvoiceInterfaceHeader(String csrNo, String ifRequestSeq) throws EventException;
    
    
	/**
	 * STM_SAP_0250 : interface batch
	 *  searchInvoiceLineNumDupCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String csrNo
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceLineNumDupCheck(String csrNo) throws EventException;
    
    
    /**
     * [STM_SAP_0250]
     * searchSapInvoiceInterfaceDetail<br> 
     * @author sangyoung cha
     * @param String csrNo
     * @return List<SapInvoiceInterfaceDetailVO>
     * @exception EventException
	*/    
    public List<SapInvoiceInterfaceDetailVO> searchSapInvoiceInterfaceDetail(String csrNo) throws EventException;
    

    /**
     * [STM_SAP_0250]
     * searchSoInvoiceInterfaceDetail<br> 
     * @author sangyoung cha
     * @param String csrNo
     * @param String ifRequestSeq
     * @return List<SapInvoiceInterfaceDetailVO>
     * @exception EventException
	*/    
    public List<SapInvoiceInterfaceDetailVO> searchSoInvoiceInterfaceDetail(String csrNo, String ifRequestSeq) throws EventException;
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceDetailApIfSumAmtCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String csrNo
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceDetailApIfSumAmtCheck(String csrNo) throws EventException;
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceDetailSumAmtCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String csrNo
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceDetailSumAmtCheck(String csrNo) throws EventException;
    
    /**
 	 * [STM_SAP_0250]
 	 *  manageAPInvoiceInterfaceResult <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String csrNo
 	 * @param String ifErrRsn
 	 * @exception EventException
 	 */    
     public void manageAPInvoiceInterfaceResult(String csrNo, String ifErrRsn) throws EventException;
     
     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceCurrUseCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String invAmt
 	 * @param String invCurrCd
 	 * @return SapCommonVO
 	 * @exception EventException
 	 */    
     public SapCommonVO searchInvoiceInterfaceCurrUseCheck(String invAmt, String invCurrCd) throws EventException ;
 
     
     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceCurrExchangeRateCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String glDt
 	 * @param String invCurrCd
 	 * @param String functionalCurrency
 	 * @return SapCommonVO
 	 * @exception EventException
 	 */    
     public SapCommonVO searchInvoiceInterfaceCurrExchangeRateCheck(String glDt, String invCurrCd, String functionalCurrency) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceInvNODupCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String invNo
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfaceInvNODupCheck(String invNo) throws EventException;
     
     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceFrontGLDateCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String glDt
 	 * @param String glSystemDivFlg
 	 * @param String ofcCd
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfaceFrontGLDateCheck(String glDt, String glSystemDivFlg, String ofcCd) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceAPGLDateCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String glDt
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfaceAPGLDateCheck(String glDt) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceSupplierActiveCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String vndrNo
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfaceSupplierActiveCheck(String vndrNo) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceTermsNameCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String invTermNm
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfaceTermsNameCheck(String invTermNm) throws EventException;
     
     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceExchangeMethodCheck <br>
 	 *
 	 * @author Kyungsam Jo
 	 * @return String
 	 * @exception EventException
 	 */     
      public String searchInvoiceInterfaceExchangeMethodCheck() throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceSystemSourceCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String ifSrcNm
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfaceSystemSourceCheck(String ifSrcNm) throws EventException;
     
     /**
  	 * [STM_SAP_0250]
  	 *  searchInvoiceInterfaceLocalCurrencyofACHPaymentMethodCheck <br>
  	 *
  	 * @author KS Jo
  	 * @param String ifVndNo
  	 * @param String ifCurrCd
  	 * @param String ifLiabAcct
  	 * @return String
  	 * @exception EventException
  	 */    
      public String searchInvoiceInterfaceLocalCurrencyofACHPaymentMethodCheck(String ifVndNo, String ifCurrCd, String ifLiabAcct) throws EventException;
 

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfacePaymentMethodCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String vndrNo
 	 * @return SapCommonVO
 	 * @exception EventException
 	 */    
     public SapCommonVO searchInvoiceInterfacePaymentMethodCheck(String vndrNo) throws EventException;
     
     /**
  	 * [STM_SAP_0250]
  	 *  searchInvoiceInterfaceApPaymentMethodCodeCheck <br>
  	 *
  	 * @author jo kyung sam
  	 * @param String paymentMethod
  	 * @return SapCommonVO
  	 * @exception EventException
  	 */    
      public SapCommonVO searchInvoiceInterfaceApPaymentMethodCodeCheck(String paymentMethod) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfacePayGroupExistsCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String payGrpLuCd
 	 * @param String ofcCd
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfacePayGroupExistsCheck(String payGrpLuCd, String ofcCd) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceInterCompanyCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String liabCdCmbSeq
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfaceInterCompanyCheck(String liabCdCmbSeq) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceVendorInterCompanyCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String vndrNo
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfaceVendorInterCompanyCheck(String vndrNo) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceAccountAndVVDCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String liabCdCmbSeq
 	 * @return SapCommonVO
 	 * @exception EventException
 	 */    
     public SapCommonVO searchInvoiceInterfaceAccountAndVVDCheck(String liabCdCmbSeq) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceAccountAndVVDLevelCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String liabCoaAcctNo
 	 * @param String liabCoaVvdCd
 	 * @return SapCommonVO
 	 * @exception EventException
 	 */    
     public SapCommonVO searchInvoiceInterfaceAccountAndVVDLevelCheck(String liabCoaAcctNo, String liabCoaVvdCd) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceCodeCombinationCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String liabCdCmbSeq
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfaceCodeCombinationCheck(String liabCdCmbSeq) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceCombineCombinationCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param SapCommonVO vo
 	 * @return SapCommonVO
 	 * @exception EventException
 	 */    
     public SapCommonVO searchInvoiceInterfaceCombineCombinationCheck(SapCommonVO vo) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceAPOfficeCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String ofcCd
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfaceAPOfficeCheck(String ofcCd) throws EventException ;
     
     
     /**
  	 * [STM_SAP_0250]
  	 *  searchInvoiceInterfaceOfficeEnableVendorCheck <br>
  	 *
  	 * @author kyungsam jo
  	 * @param String ofcCd
	 * @param String vndrCd
	 * @return String
	 * @exception EventException
  	 */    
      public String searchInvoiceInterfaceOfficeEnableVendorCheck(String ofcCd, String vndrCd) throws EventException;
      

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfacePrepaymentAvailableCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String ppayInvNo
 	 * @param String ppayInvLineNo
 	 * @param String ppayAplyAmt
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfacePrepaymentAvailableCheck(String ppayInvNo, String ppayInvLineNo, String ppayAplyAmt) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceASAOfficeCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String ofcCd
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfaceASAOfficeCheck(String ofcCd) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceASAMasterCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String attrCtnt2
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfaceASAMasterCheck(String attrCtnt2) throws EventException;
     
     
     /**
  	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceASAMasterCurrencyCheck <br>
	 *
	 * @author jo kyung sam
	 * @param String attrCtnt2
	 * @param String Invcurrencycode
	 * @return String
	 * @exception EventException
  	 */    
      public String searchInvoiceInterfaceASAMasterCurrencyCheck(String attrCtnt2, String Invcurrencycode) throws EventException;
      
     
      /**
    	 * [STM_SAP_0250]
  	 *  searchInvoiceInterfaceASAClearingAccountCheck <br>
  	 *
  	 * @author jo kyung sam
  	 * @return String
  	 * @exception EventException
    	 */    
        public String searchInvoiceInterfaceASAClearingAccountCheck() throws EventException; 
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceAPClearingAcctCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String csrNo
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfaceAPClearingAcctCheck(String csrNo) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceSOClearingAcctCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String csrNo
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfaceSOClearingAcctCheck(String csrNo) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceLineCurrUseCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String dtrbAmt
 	 * @param String invCurrCd
 	 * @return SapCommonVO
 	 * @exception EventException
 	 */    
     public SapCommonVO searchInvoiceInterfaceLineCurrUseCheck(String dtrbAmt, String invCurrCd) throws EventException;
     
     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceLineInterCompanyCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String dtrbCdCmbSeq
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfaceLineInterCompanyCheck(String dtrbCdCmbSeq) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceLineAccountAndVVDCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String dtrbCdCmbSeq
 	 * @return SapCommonVO
 	 * @exception EventException
 	 */    
     public SapCommonVO searchInvoiceInterfaceLineAccountAndVVDCheck(String dtrbCdCmbSeq) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceLineVndrInvNoDupCheckRSQL <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String vndrNo
 	 * @param String csrNo
 	 * @param String attrCtnt1
 	 * @return String
 	 * @exception EventException
 	 */    
     public String searchInvoiceInterfaceLineVndrInvNoDupCheckRSQL(String vndrNo, String csrNo, String attrCtnt1) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceLineTaxCodeCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String dtrbVatCd
 	 * @return SapCommonVO
 	 * @exception EventException
 	 */    
     public SapCommonVO searchInvoiceInterfaceLineTaxCodeCheck(String dtrbVatCd) throws EventException;
     

     /**
 	 * [STM_SAP_0250]
 	 *  searchInvoiceInterfaceLineUnsettleAccountCheck <br>
 	 *
 	 * @author sangyoung cha
 	 * @param String dtrbCoaAcctNo
 	 * @return SapCommonVO
 	 * @exception EventException
 	 */    
     public SapCommonVO searchInvoiceInterfaceLineUnsettleAccountCheck(String dtrbCoaAcctNo) throws EventException;
 

 	/**
 	 * [STM_SAP_0250]
 	 * manageSapIfValidateImportCheck <br>
 	 *
 	 * @param SapInvoiceInterfaceHeaderVO headerVo
 	 * @param List<SapInvoiceInterfaceDetailVO> lineVo
 	 * @param String usrId
 	 * @exception EventException
 	 */
 	public void manageSapIfValidateImportCheck(SapInvoiceInterfaceHeaderVO headerVo, List<SapInvoiceInterfaceDetailVO> lineVo,  String usrId) throws EventException;
 	

    /**
	 * [STM_SAP_0250]
	 *  manageAPInvoiceInterfaceSucess <br>
	 *
	 * @author sangyoung cha
	 * @param String csrNo
	 * @exception EventException
	 */    
    public void manageAPInvoiceInterfaceSucess(String csrNo) throws EventException;
	/**
	 * [SAKURA I/F]
	 * manageInterfaceSAP <br>
	 * 
	 * @author ORKIM
	 * @category manageInterfaceSAP
	 * @param String csrNo
	 * @param String usr_id
	 * @exception EventException
	*/   
    public void manageInterfaceSAP(String csrNo, String usr_id) throws EventException;    
    
	/**
	 * [STM_SAP_0010]
	 * searchInvoiceLinePrepayCheck <br>
	 *
	 * @param String inv_seq
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceLinePrepayCheck(String inv_seq) throws EventException;
    
	
   /**
	 * SAKURA I/F for PAYMENT  
	 * modifyPaymentInvoice <br> 
	 * @author ORKIM
	 * @param List<PaymentEntryLineVO> payEntryLineVOList
	 * @exception EventException
   */ 
	public void modifyPaymentInvoice(List<PaymentEntryLineVO> payEntryLineVOList) throws EventException ;
	
   /**
	 * SAKURA I/F for PAYMENT  
	 * modifyPaymentSchedule <br> 
	 * @author ORKIM
	 * @param List<PaymentEntryLineVO> payEntryLineVOList
	 * @exception EventException
   */ 
	public void modifyPaymentSchedule(List<PaymentEntryLineVO> payEntryLineVOList) throws EventException;
	
	/**
	 * [STM_SAP_0250]
	 * searchSakuraInterfaceCSRInfo <br>
	 * 
	 * @param String invfromdt
	 * @param String invtodt
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public List<SapCommonVO> searchSakuraInterfaceCSRInfo(String invfromdt, String invtodt) throws EventException;
	
	/**
	 * [STM_SAP_0150]
	 * SearchInvoiceAccrualList <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0150
	 * @category SearchInvoiceAccrualList
	 * @param InvoiceAccrualCondVO invoiceAccrualCondVO
	 * @return List<InvoiceAccrualVO>
	 * @exception EventException
	 */
	public List<InvoiceAccrualVO> searchInvoiceAccrualList(InvoiceAccrualCondVO invoiceAccrualCondVO) throws  EventException;	
	
	/**
	 * [STM_SAP_0150]
	 * ModifyAPManualInvoiceAccrualFlag <br> 
	 * 
	 * @author KSJO
	 * @category STM_SAP_0150
	 * @category ModifyAPManualInvoiceAccrualFlag
	 * @param APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO
	 * @exception EventException
	 */
	public void modifyAPManualInvoiceAccrualFlag(APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO) throws EventException;
	
	/**
	 * [STM_SAP_0150]
	 * ModifyAPManualInvoiceAccrualCancelFlag <br> 
	 * 
	 * @author KSJO
	 * @category STM_SAP_0150
	 * @category ModifyAPManualInvoiceAccrualCancelFlag
	 * @param APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO
	 * @exception EventException
	 */
	public void modifyAPManualInvoiceAccrualCancelFlag(APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO) throws EventException;
	
	/**
	 * [STM_SAP_0250]
	 * callSAKURAPaymentIF <br>
	 * 
	 * @author KSJO
	 * @category STM_SAP_0250
	 * @category callSAKURAPaymentIF
	 * @exception EventException
	 */
	public void callSAKURAPaymentIF() throws EventException;
	
	/**
	 * [STM_SAR_5002]
	 * callASAInvoiceInterface <br>
	 * 
	 * @author KSJO
	 * @category STM_SAR_5002
	 * @category callASAInvoiceInterface
	 * @exception EventException
	 */
	public void callASAInvoiceInterface() throws EventException;
	
	/**
	 * [STM_SAR_5002]
	 * searchASAInvoiceUnInterfaceCheck <br>
	 * 
	 * @author KSJO
	 * @category searchASAInvoiceUnInterfaceCheck
	 * @param String asa_no
	 * @return String
	 * @exception EventException
	 */
	public String searchASAInvoiceUnInterfaceCheck(String asa_no) throws EventException;
	
	/**
	 * Asa Clearing 대상 조회<br>
	 * 
	 * @author ORKIM
	 * @category manageAsaClearingIF
	 * @param String inv_no
	 * @exception EventException
	 */
	public void manageAsaClearingIF(String inv_no) throws EventException;	
	
	/**
	 * [CSR I/F - Approval]
	 * searchCSRNoDupChk <br>
	 *
	 * @author OKRYEKIM
	 * @param String csr_no
	 * @return String
	 * @exception EventException
	 */
	public String searchCSRNoDupChk(String csr_no) throws EventException;	
}
