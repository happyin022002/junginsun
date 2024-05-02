/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentBC.java
*@FileTitle : AccountPayablePaymentBC
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.14
*@LastModifier : sangyoung cha
*@LastVersion : 1.0
* 2014.03.14
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.basic;

import java.util.ArrayList;
import java.util.List;


import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic.AccountPayableInvoiceBC;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic.AccountPayableInvoiceBCImpl;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APTransactionCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APTransactionVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingDetailValidateInfoVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingInvoiceCancelCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingInvoiceCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingPaymentCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingPaymentLineCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.BankAccountAdjustmentListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.BankBalanceAdjustmentListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.BankBalanceByOfficeCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.BankBalanceByOfficeVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentDetailCurrSumListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentEntryLineVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentEntryVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentScheduleCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentScheduleListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentDetailListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentSlipCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentSlipLineListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentSlipListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchSelectedListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchEntryVendorSumInfoVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APAccountingListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentProcessListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentCSRInfoListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentCompleteCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentBANKExistsCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentBANKInfoCheckVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBC;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBCImpl;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LedgerCodeCombinationListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-SAP AccountPayablePaymentBC Business Logic Command Interface<br>
 *
 * @author ORKIM
 * @see AccountPayablePaymentSC 
 * @since J2EE 1.6
 */	
public interface AccountPayablePaymentBC {

	/**
	 * [STM_SAP_0050] Retrieve<br>
	 * Payment Schedule Inquiry - retrieve<br>
	 * @author hannah lee
	 * @param PaymentScheduleCondVO paymentScheduleCondVO
	 * @return List<PaymentScheduleListVO> 
	 * @exception EventException
	 */
	public List<PaymentScheduleListVO> searchPaymentScheduleList(PaymentScheduleCondVO paymentScheduleCondVO) throws EventException;

	/**
	 * [STM_SAP_0070] Retrieve<br>
	 * Payment Slip - Payment retrieve<br>
	 * @author hannah lee
	 * @param PaymentSlipCondVO paymentSlipCondVO
	 * @return List<PaymentSlipListVO> 
	 * @exception EventException
	 */
    public List<PaymentSlipListVO> searchPaymentSlipList(PaymentSlipCondVO paymentSlipCondVO) throws EventException;
    
	
    /**
	 * [STM_SAP_0070]  Retrieve<br>
	 * Payment Slip - Payment Detail retrieve<br>
	 * @author hannah lee
	 * @param String paySeq
	 * @return List<PaymentSlipLineListVO> 
	 * @exception EventException
	 */
	public List<PaymentSlipLineListVO> searchPaymentSlipLineList(String paySeq) throws EventException;
	    
	/**
	 * [STM_SAP_0130] Retrieve<br>
	 * Inquiry of Bank Balance - retrieve<br>
	 * @author hannah lee
	 * @param BankBalanceByOfficeCondVO bankBalanceByOfficeCondVO
	 * @return List<BankBalanceByOfficeVO> 
	 * @exception EventException
	 */ 
	public List<BankBalanceByOfficeVO> searchBankBalanceByOffice(BankBalanceByOfficeCondVO bankBalanceByOfficeCondVO) throws EventException;
		 
	
	/**
     * [STM_SAP_0330] Retrieve
     * Payment Detail Inquiry <br>
     * @author sangyoung cha
     * @param PaymentDetailListVO paymentDetailListVO   
     * @return List<PaymentDetailListVO>
     * @exception EventException
     */	
	public List<PaymentDetailListVO> searchPaymentDetailList(PaymentDetailListVO paymentDetailListVO) throws EventException;
	
	/**
     *  [ STM_SAP_0330] 
     * Payment Detail Inquiry Current Sum<br>
     * @author sangyoung cha
     * @param PaymentDetailCurrSumListVO paymentDetailCurrSumListVO 
     * @return  List<PaymentDetailCurrSumListVO>
     * @exception EventException
     */	
	public List<PaymentDetailCurrSumListVO> searchPaymentDetailCurrSumList(PaymentDetailCurrSumListVO paymentDetailCurrSumListVO) throws EventException;	
	
	/**
     *  [ STM_SAP_0060] 
     * Payment Entry List<br>
     * @author sangyoung cha
     * @param PaymentEntryVO paymentEntryVO
     * @return  List<PaymentEntryVO>
     * @exception EventException
     */	
	public List<PaymentEntryVO> searchPaymentEntryList(PaymentEntryVO paymentEntryVO) throws EventException;	
	
	/**
     *  [ STM_SAP_0060] 
     * Payment Entry Line List<br>
     * @author sangyoung cha
     * @param String paySeq      
     * @return  List<PaymentEntryLineVO>
     * @exception EventException
     */	
	public List<PaymentEntryLineVO> searchPaymentEntryLineList(String paySeq) throws EventException;
	
	/**
	 * [STM_SAP_0060]
	 * searchLineVendorPaymentNoDupCheck <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchLineVendorPaymentNoDupCheck(SapCommonVO sapCommonVO) throws EventException;
	

	/**
	 * [STM_SAP_0060]
	 * [header] / [line] list save<br>
	 *
	 * @param PaymentEntryVO[] paymentEntryVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String managePaymentEntryInfo(PaymentEntryVO[] paymentEntryVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [STM_SAP_0060]
	 * Payment list Line save<br>
	 *
	 * @param List<PaymentEntryLineVO> insertVoListLine
	 * @param List<PaymentEntryLineVO> updateVoListLine
	 * @param List<PaymentEntryLineVO> deleteVoListLine
	 * @exception EventException
	 */
	public void managePaymentEntryLineInfo(List<PaymentEntryLineVO> insertVoListLine, List<PaymentEntryLineVO> updateVoListLine, List<PaymentEntryLineVO> deleteVoListLine) throws EventException ;	
	
	/**
	 * [STM_SAP_0060]
	 * searchPaymentStatusCheck <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return String
	 * @exception EventException
	*/
	public String searchPaymentStatusCheck(SapCommonVO sapCommonVO) throws EventException ;
	
	/**
	 * [STM_SAP_0060]
	 * Payment list delete<br>
	 *
	 * @param PaymentEntryVO[] paymentEntryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removePaymentEntryInfo(PaymentEntryVO[] paymentEntryVOs, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * [STM_SAP_0060]
	 * Payment list void<br>
	 *
	 * @param PaymentEntryVO[] paymentEntryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePaymentEntryVoid(PaymentEntryVO[] paymentEntryVOs, SignOnUserAccount account) throws EventException;
	
	/**
	* [STM_SAP_0210]
	* searchPaymentBatchList<br>
	*
	* @param PaymentBatchCondVO paymentBatchCondVO
	* @return List<PaymentBatchListVO>
	* @exception EventException
	*/
	public List<PaymentBatchListVO> searchPaymentBatchList(PaymentBatchCondVO paymentBatchCondVO) throws EventException;
		
	
	/**
	* [STM_SAP_0210]
	* searchPaymentBatchSelectedList<br>
	*
	* @param String pay_bat_seq
	* @param String pay_bat_nm
	* @return List<PaymentBatchSelectedListVO>
	* @exception EventException
	*/
	public List<PaymentBatchSelectedListVO> searchPaymentBatchSelectedList(String pay_bat_seq, String pay_bat_nm) throws EventException;
		 
	/**
	* [STM_SAP_0210]
	* searchPaymentPossibleInvoiceList<br>
	*
	* @param String inv_no
	* @param String pay_bat_seq
	* @param String pay_bat_nm
	* @return List<PaymentBatchSelectedListVO>
	* @exception EventException
	*/
	public List<PaymentBatchSelectedListVO> searchPaymentPossibleInvoiceList(String inv_no, String pay_bat_seq, String pay_bat_nm) throws EventException;
	
	/**
	* [STM_SAP_0210]
	* searchPaymentBatchUniqueCheck<br>
	*
	* @param String pay_bat_nm
	* @return String
	* @exception EventException
	*/
	public String searchPaymentBatchUniqueCheck(String pay_bat_nm) throws EventException;
	
	/**
	* [STM_SAP_0210]
	* searchPaymentBatchNameDupCheck<br>
	*
	* @param String pay_bat_nm
	* @return String
	* @exception EventException
	*/
	public String searchPaymentBatchNameDupCheck(String pay_bat_nm) throws EventException;
	
	/**
	* [STM_SAP_0210]
	* selectPaymentProcessDupCheck<br>
	*
	* @param String bank_acct_seq
	* @param String pay_mzd_lu_cd
	* @return String
	* @exception EventException
	*/
	public String selectPaymentProcessDupCheck(String bank_acct_seq, String pay_mzd_lu_cd) throws EventException;	
	
	/**
	 * [STM_SAP_0210]
	 * managePaymentBatchEntryInfo<br>
	 *
	 * @param PaymentBatchListVO[] paymentBatchListVOs
	 * @param SignOnUserAccount account
	 * @return String pay_bat_seq
	 * @exception EventException
	 */
	public String managePaymentBatchEntryInfo(PaymentBatchListVO[] paymentBatchListVOs, SignOnUserAccount account) throws EventException;
	
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
	 * @return String
	 * @exception EventException
	 */
	public String managePaymentCaptureInfo(PaymentBatchListVO[] paymentBatchListVOs, PaymentBatchSelectedListVO[] paymentBatchSelectedListVOs, String fCurrCd, SignOnUserAccount account) throws EventException;
	

	/**
	 * [STM_SAP_0210]
	 * managePaymentConfirmInfo<br>
	 *
	 * @param PaymentBatchListVO[] paymentBatchListVOs
	 * @param PaymentBatchSelectedListVO[] paymentBatchSelectedListVOs
	 * @param String fCurrCd
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int managePaymentConfirmInfoCheck(PaymentBatchListVO[] paymentBatchListVOs, PaymentBatchSelectedListVO[] paymentBatchSelectedListVOs, String fCurrCd, SignOnUserAccount account) throws EventException;
	
	/**
	* [STM_SAP_0210]
	* searchPaymentBatchEntryVendorSumInfo<br>
	*
	* @param String pay_bat_seq
	* @param String pay_bat_nm
	* @return List<PaymentBatchEntryVendorSumInfoVO>
	* @exception EventException
	*/
	public List<PaymentBatchEntryVendorSumInfoVO> searchPaymentBatchEntryVendorSumInfo(String pay_bat_seq, String pay_bat_nm) throws EventException;
	
	/**
	 * [STM_SAP_0210]
	 * managePaymentConfirmInfo<br>
	 *
	 * @param List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVOList
	 * @param String functional_currency
	 * @param SignOnUserAccount account
	 * @return List<PaymentBatchEntryVendorSumInfoVO>
	 * @exception EventException
	 */
	public List<PaymentBatchEntryVendorSumInfoVO>  managePaymentConfirmInfo(List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVOList, String functional_currency, SignOnUserAccount account) throws EventException;
	
	/**
	 * [STM_SAP_0210]
	 * removePaymentSelectedInvoiceAllInfo<br>
	 *
	 * @param List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVOList
	 * @exception EventException
	 */
	public void  removePaymentSelectedInvoiceAllInfo(List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVOList) throws EventException;
	
	/**
	* [STM_SAP_0220]
	* searchAPAccountingList<br>
	*
	* @param AccountingCondVO accountingCondVO
	* @return List<APAccountingListVO>
	* @exception EventException
	*/
	public List<APAccountingListVO> searchAPAccountingList(AccountingCondVO accountingCondVO) throws EventException;
		
	/**
	 * [STM_SAP_0220]
	 * manageAccountingCaptureInfo BackEndJob process
	 * 
	 * @author ORKIM
	 * @param String capture_period
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String manageAccountingCaptureInfo(String capture_period, String userId) throws EventException;
	
	/**
	 * [STM_SAP_0220]
	 * manageAccountingCaptureCsrNo 
	 * 
	 * @author ORKIM
	 * @param String csrNo
	 * @param String userId
	 * @return String
	 * @exception EventException
	 */
	public String manageAccountingCaptureCsrNo(String csrNo, String userId) throws EventException;	
	
	/**
	 * [STM_SAP_0220]
	 * return  Back End Job' status.
	 *
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkBackEndJob(String key) throws EventException;
	
	
	/**
	 * [STM_SAP_0220]
	 * Accounting list delete<br>
	 *
	 * @param List<APAccountingListVO> updateVoList
	 * @exception EventException
	 */
	public void removeAccountingInfo(List<APAccountingListVO> updateVoList) throws EventException ;	
	
	/**
	 * [STM_SAP_0220]
	 * Accounting list delete<br>
	 *
	 * @param List<APAccountingListVO> updateVoList
	 * @exception EventException
	 */
	public void modifyAccountingDetailPaymentLineRestore(List<APAccountingListVO> updateVoList) throws EventException ;	
	
    /**
	 * [STM_SAP_0120]
	 * Bank Balance Adjustment - retrieve<br> 
	 * @author JBLEE
	 * @param BankBalanceByOfficeCondVO bankBalanceByOfficeCondVO
	 * @return List<BankAccountAdjustmentListVO>
	 * @exception EventException
    */   
	public List<BankAccountAdjustmentListVO> searchBankAccountAdjustmentList(BankBalanceByOfficeCondVO bankBalanceByOfficeCondVO) throws EventException;
	
   /**
	 * [STM_SAP_0120]
	 * Bank Account Adjustment - Recalculate<br> 
	 * @author JBLEE
	 * @param BankBalanceAdjustmentListVO[] bankBalanceAdjustmentListVOs
	 * @param String usrId
	 * @exception EventException
   */
	public void manageBankAccountAdjustment(BankBalanceAdjustmentListVO[] bankBalanceAdjustmentListVOs, String usrId) throws EventException;

   /**
	 * [STM_SAP_0140]
	 * Inquiry of Transaction - Retrieve<br> 
	 * @author ORKIM
	 * @param APTransactionCondVO aPTransactionCondVO
	 * @return List<APTransactionVO>
	 * @exception EventException
  */   
	public List<APTransactionVO> searchInquiryofTransactionList(APTransactionCondVO aPTransactionCondVO) throws EventException;
	
   /**
	 * [STM_SAP_0140]
	 * Inquiry of Transaction - Retrieve BeginBalance <br> 
	 * @author ORKIM
	 * @param APTransactionCondVO aPTransactionCondVO
	 * @return String
	 * @exception EventException
   */ 
	public String searchInquiryofTrxBeginBalance(APTransactionCondVO aPTransactionCondVO) throws EventException;
	
   /**
	 * [STM_SAP_0140]
	 * Inquiry of Transaction - Retrieve Sum <br> 
	 * @author ORKIM
	 * @param APTransactionCondVO aPTransactionCondVO
	 * @return String[]
	 * @exception EventException
   */ 
	public String[] searchInquiryofTransactionSum(APTransactionCondVO aPTransactionCondVO) throws EventException;	
	
	/**
	 * [STM_SAP_0060] Retrieve<br>
	 * Payment Schedule Inquiry - retrieve<br>
	 * @author ORKIM
	 * @param String csr_no
	 * @param String flag
	 * @return String
	 * @exception EventException
	 */
	public String manageSOInterface(String csr_no, String flag) throws EventException;	
	
	/**
	 * Interface<br>
	 * searchInvHdrSrcCd<br>
	 * @author ORKIM
	 * @param String csr_no
	 * @return String
	 * @exception EventException
	 */
	public String searchInvHdrSrcCd(String csr_no) throws EventException;	
	
	/**
	 * Interface<br>
	 * searchSAPToSOInterfaceData <br>
	 * @author ORKIM
	 * @param String csr_no
	 * @return String[]
	 * @exception EventException     
	 */
	public String[] searchSAPToSOInterfaceData(String csr_no) throws EventException;	
	
	/**
	 * Interface<br>
	 * searchSAPToSOInterfaceDataBatch <br>
	 * @author ORKIM
	 * @param String pay_bat_seq
	 * @param String pay_bat_nm
	 * @param String vndr_no
	 * @return List<PaymentEntryLineVO>
	 * @exception EventException
	 */
	public List<PaymentEntryLineVO>  searchSAPToSOInterfaceDataBatch(String pay_bat_seq, String pay_bat_nm, String vndr_no) throws EventException;	
	
	/**
	 * [STM_SAP_0060]
	 * [header] / [line] list delete validation <br>
	 *
	 * @param String pay_seq
	 * @return String
	 * @exception EventException
	 */
	public String searchPaymentApplyCheck(String pay_seq) throws EventException;

   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPIFPaymentProcessList <br> 
	 * @author ORKIM
	 * @return List<APIFPaymentProcessListVO>
	 * @exception EventException
   */ 
	public List<APIFPaymentProcessListVO>  searchAPIFPaymentProcessList() throws EventException;

	
   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPPaymentBatchProcessName <br> 
	 * @author ORKIM
	 * @return String
	 * @exception EventException
   */ 
	public String searchAPPaymentBatchProcessName() throws EventException;

	

   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPIFPaymentCSRInfoList <br> 
	 * @author ORKIM
	 * @param APIFPaymentProcessListVO aPIFPaymentProcessListVO
	 * @return List<APIFPaymentCSRInfoListVO>
	 * @exception EventException
   */ 
	public List<APIFPaymentCSRInfoListVO>  searchAPIFPaymentCSRInfoList(APIFPaymentProcessListVO aPIFPaymentProcessListVO) throws EventException;
	
	

   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPIFPaymentCompleteCheck <br> 
	 * @author ORKIM
	 * @param  APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO
	 * @return List<APIFPaymentCompleteCheckVO>
	 * @exception EventException
   */ 
	public List<APIFPaymentCompleteCheckVO>  searchAPIFPaymentCompleteCheck(APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO) throws EventException;

	
   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPIFPaymentBANKExistsCheck <br> 
	 * @author ORKIM
	 * @param  APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO
	 * @return List<APIFPaymentBANKExistsCheckVO>
	 * @exception EventException
   */ 
	public List<APIFPaymentBANKExistsCheckVO>  searchAPIFPaymentBANKExistsCheck(APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO) throws EventException;


   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPIFPaymentBANKInfoCheck <br> 
	 * @author ORKIM
	 * @param  APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO
	 * @return List<APIFPaymentBANKInfoCheckVO>
	 * @exception EventException
   */ 
	public List<APIFPaymentBANKInfoCheckVO>  searchAPIFPaymentBANKInfoCheck(APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO) throws EventException;

	
   /**
	 * SAKURA I/F for PAYMENT  
	 * searchNextPaySeq <br> 
	 * @author ORKIM
	 * @return String
	 * @exception EventException
   */ 
	public String searchNextPaySeq() throws EventException;	
	
   /**
	 * SAKURA I/F for PAYMENT  
	 * manageAPIFPayment <br> 
	 * @author ORKIM
	 * @param List<PaymentEntryVO> payEntryVOList
	 * @param List<PaymentEntryLineVO> payEntryLineVOList
	 * @param List<APIFPaymentProcessListVO> ifProcessVOList
	 * @exception EventException
   */ 
	public void manageAPIFPayment(List<PaymentEntryVO> payEntryVOList, List<PaymentEntryLineVO> payEntryLineVOList, List<APIFPaymentProcessListVO> ifProcessVOList) throws EventException;		
	
   /**
	 * SAKURA I/F for PAYMENT  
	 * addPaymentHeader <br> 
	 * @author ORKIM
	 * @param List<PaymentEntryVO> payEntryVOList
	 * @exception EventException
   */ 
	public void addPaymentHeader(List<PaymentEntryVO> payEntryVOList) throws EventException ;	
	
   /**
	 * SAKURA I/F for PAYMENT  
	 * addPaymentLine <br> 
	 * @author ORKIM
	 * @param List<PaymentEntryLineVO> payEntryLineVOList
	 * @exception EventException
   */ 
	public void addPaymentLine(List<PaymentEntryLineVO> payEntryLineVOList) throws EventException ;		
	
   /**
	 * SAKURA I/F for PAYMENT  
	 * modifyAPIFPaymentStatus <br> 
	 * @author ORKIM
	 * @param List<APIFPaymentProcessListVO> ifProcessVOList
	 * @exception EventException
   */ 
	public void modifyAPIFPaymentStatus(List<APIFPaymentProcessListVO> ifProcessVOList) throws EventException ;
	
   /**
	 * checkAPAccountSetup
	 * @author ORKIM
	 * @param  String callFlag
	 * @param  String[] argParam
	 * @param  String[] arrAcctParams
	 * @return String[]
	 * @exception EventException
   */ 	
	public String[] checkAPAccountSetup(String callFlag, String[] argParam, String[] arrAcctParams) throws EventException;
		
   /**
	 * processInvoice
	 * @author ORKIM
	 * @param  String[] arrAcctParams
	 * @exception EventException
   */ 	
	public void processInvoice(String[] arrAcctParams) throws EventException;
	
   /**
	 * processInvoiceCancellation
	 * @author ORKIM
	 * @param  String[] arrAcctParams
	 * @exception EventException
   */ 
	public void processInvoiceCancellation(String[] arrAcctParams) throws EventException;

   /**
	 * processPayment
	 * @author ORKIM
	 * @param  String[] arrAcctParams
	 * @exception EventException
   */	
	public void processPayment(String[] arrAcctParams) throws EventException;	
	
   /**
	 * processPaymentCancel
	 * @author ORKIM
	 * @param  String[] arrAcctParams
	 * @exception EventException
   */	
	public void processPaymentCancel(String[] arrAcctParams) throws EventException;	
	
   /**
	 * processPrepaymentApply
	 * @author ORKIM
	 * @param  String[] arrAcctParams
	 * @exception EventException
   */		
	public void processPrepaymentApply(String[] arrAcctParams) throws EventException;	
	
   /**
	 * processPrepaymentUnapply
	 * @author ORKIM
	 * @param  String[] arrAcctParams
	 * @exception EventException
   */		
	public void processPrepaymentUnapply(String[] arrAcctParams) throws EventException;	
	
	
   /**
	 * processErrorCheck
	 * @author ORKIM
	 * @param  String[] arrAcctParams
	 * @exception EventException
   */		
	public void processErrorCheck(String[] arrAcctParams) throws EventException;	
	
}