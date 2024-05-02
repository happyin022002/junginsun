/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceBC.java
*@FileTitle : Charterer's Account
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.basic;

import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamConsultationVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCalOffhireInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCharterInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchCalPrepaymentInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerInvoiceAutoMatchVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOwnrAcctSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSendEmailVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.InvoiceContainerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchChaterInvoiceSdmsListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireSelectionListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceAutoMatchListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVvdListByCharterVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVvdListByOffHireVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchInvoiceByPaymentSlipVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchArSlipDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchInvoiceListByRevenueSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterListByPaymentSlipVO;

/**
 * OPUS-Timecharterinoutaccounting Business Logic Command Interface<br>
 * - OPUS-Timecharterinoutaccounting Biz Logic Interface<br>
 *
 * @author Yoon-Tae, Jung
 * @see Ui_fms_0016EventResponse 
 * @since J2EE 1.5
 */

public interface TCharterIOInvoiceBC {
	
	/**
	 * Retrieving data on Charterer's Account window(Retrieving account related to Charterer Costs)<br>
	 * 
	 * @param condCharterInvoiceVO CondCharterInvoiceVO
	 * @return List<SearchCharterInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchCharterInvoiceListVO> searchCharterInvoiceList(CondCharterInvoiceVO condCharterInvoiceVO) throws EventException;
	
	/**
	 * Retrieving data on Charterer's Account window(Retrieving account related to Charterer Costs)<br>
	 * 
	 * @param condCharterInvoiceVO CondCharterInvoiceVO
	 * @return List<SearchCharterInvoiceSumVO>
	 * @exception EventException
	 */
	public List<SearchCharterInvoiceSumVO> searchCharterInvoiceSum(CondCharterInvoiceVO condCharterInvoiceVO) throws EventException;
	
	/**
	 * Getting Voyage corresponding to fletCtrlNo and bnkYrmon<br>
	 * 
	 * @param fletCtrtNo String
	 * @param revYrmon String
	 * @return List<SearchVvdByBunkerVO>
	 * @exception EventException
	 */
	public List<SearchVvdListByCharterVO> searchVvdListByCharter(String fletCtrtNo, String revYrmon) throws EventException;
	
	
	/**
	 * Changing Charterer Costs on Charterer's Account window<br>
	 * 
	 * @param customInvoiceVO CustomInvoiceVO
	 * @param customInvDtlVOs CustomInvDtlVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageCharterInvoice(CustomInvoiceVO customInvoiceVO, CustomInvDtlVO[] customInvDtlVOs, String usrId) throws EventException;
	
	/**
	 * Sending Email on Agreement Creation window<br>
	 * 
	 * @param customSendEmailVO CustomSendEmailVO
	 * @param keys List<String>
	 * @return String
	 * @exception EventException
	 */
	public String sendEmail(CustomSendEmailVO customSendEmailVO, List<String> keys) throws EventException;
	
	/**
	 * Defining type of registered receivable account to balance an acting Ship Owner costs in case of paying Owner Account<br>
	 * Retrieving data as condition<br>
	 * 
	 * @param condSearchOwnerInvoiceVO CondSearchOwnerInvoiceVO
	 * @return List<SearchOwnerInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchOwnerInvoiceListVO> searchOwnerInvoiceList(CondSearchOwnerInvoiceVO condSearchOwnerInvoiceVO) throws EventException;
	
	/**
	 * Defining type of registered receivable account to balance an acting Ship Owner costs in case of paying Owner Account<br>
	 * Changing data<br>
	 * 
	 * @param customOwnrAcctSlpVOs CustomOwnrAcctSlpVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void modifyOwnerInvoice(CustomOwnrAcctSlpVO[] customOwnrAcctSlpVOs, String usrid) throws EventException;
	
	/**
	 * Retrieving Owner Invoice data automatically matching by debtor and creditor costs related to Owner's Account costs<br>
	 * 
	 * @param condSearchOwnerInvoiceAutoMatchVO CondSearchOwnerInvoiceAutoMatchVO
	 * @return List<SearchOwnerInvoiceAutoMatchListVO>
	 * @exception EventException
	 */
	public List<SearchOwnerInvoiceAutoMatchListVO> searchOwnerInvoiceAutoMatchList(CondSearchOwnerInvoiceAutoMatchVO condSearchOwnerInvoiceAutoMatchVO) throws EventException;
	
	
	/**
	 * Retrieving data on Off-Hire Expenses window(In case of clicking Creation button)<br>
	 * 
	 * @param condCalOffhireInvoiceVO CondCalOffhireInvoiceVO
	 * @return List<SearchCalOffhireInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceList(CondCalOffhireInvoiceVO condCalOffhireInvoiceVO) throws EventException;
	
	/**
	 * Retrieving SUM data on Off-Hire Expenses window(In case of clicking Creation button)<br>
	 * 
	 * @param condCalOffhireInvoiceVO CondCalOffhireInvoiceVO
	 * @return List<SearchCalOffhireInvoiceListSumVO>
	 * @exception EventException
	 */
	public List<SearchCalOffhireInvoiceListSumVO> searchCalOffhireInvoiceListSum(CondCalOffhireInvoiceVO condCalOffhireInvoiceVO) throws EventException;
	
	/**
	 * Getting Voyage corresponding to CtrtNo and Duration <br>
	 * 
	 * @param fletCtrtNo String
	 * @param effDt String
	 * @param expDt String
	 * @param vslCd String
	 * @return List<SearchVvdListByOffHireVO>
	 * @exception EventException
	 */
	public List<SearchVvdListByOffHireVO> searchVvdListByOffHire(String fletCtrtNo, String effDt, String expDt, String vslCd) throws EventException;
	
	/**
	 * Registering and Changing Offhire Expenses information on Off-Hire Expenses window<br>
	 * 
	 * @param customOffInvoiceVO CustomOffInvoiceVO
	 * @param customOffInvDtlVOs CustomOffInvDtlVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageOffhireInvoice(CustomOffInvoiceVO customOffInvoiceVO, CustomOffInvDtlVO[] customOffInvDtlVOs, String usrId) throws EventException;
	
	/**
	 * Retrieving data on Off-Hire Expenses window(In case of clicking Inquiry button)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @return List<SearchOffhireInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchOffhireInvoiceListVO> searchOffhireInvoiceList(String fletCtrtNo, String invSeq) throws EventException;
	
	/**
	 * Retrieving SUM data on Off-Hire Expenses window(In case of clicking Inquiry button)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @return List<SearchCalOffhireInvoiceListSumVO>
	 * @exception EventException
	 */
	public List<SearchCalOffhireInvoiceListSumVO> searchOffhireInvoiceListSum(String fletCtrtNo, String invSeq) throws EventException;
	
	/**
	 * Retrieving data on Offhire Selection window(POPUP)<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchOffhireSelectionListVO>
	 * @exception EventException
	 */
	public List<SearchOffhireSelectionListVO> searchOffhireSelectionList(String fletCtrtNo) throws EventException;
	
	/**
	 * Deleting Offhire Expense information on Off-Hire Expenses window<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @exception EventException
	 */
	public void removeOffhireInvoice(String fletCtrtNo, String invSeq) throws EventException;
	
	/**
	 * Retrieving data on Prepayments window(In case of clicking Creation button)<br>
	 * 
	 * @param condSearchCalPrepaymentInvoiceListVO CondSearchCalPrepaymentInvoiceListVO
	 * @return List<SearchCalPrepaymentInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchCalPrepaymentInvoiceListVO> searchCalPrepaymentInvoiceList(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws EventException;
	
	/**
	 * Retrieving SUM data on Prepayments window(In case of clicking Inquiry button)<br>
	 * 
	 * @param condSearchCalPrepaymentInvoiceListVO CondSearchCalPrepaymentInvoiceListVO
	 * @return List<SearchCalPrepaymentInvoiceListSumVO>
	 * @exception EventException
	 */
	public List<SearchCalPrepaymentInvoiceListSumVO> searchCalPrepaymentInvoiceListSum(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws EventException;
	
	/**
	 * Registering Invoice information on Prepayments window<br>
	 * 
	 * @param customPreInvoiceVO CustomPreInvoiceVO
	 * @param customPreInvDtlVOs CustomPreInvDtlVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void creatPrepaymentInvoice(CustomPreInvoiceVO customPreInvoiceVO, CustomPreInvDtlVO[] customPreInvDtlVOs, String usrId) throws EventException;
	
	/**
	 * Changing/Deleting Invoice information on Prepayments window<br>
	 * 
	 * @param customPreInvoiceVO CustomPreInvoiceVO
	 * @param customPreInvDtlVOs CustomPreInvDtlVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void managePrepaymentInvoice(CustomPreInvoiceVO customPreInvoiceVO, CustomPreInvDtlVO[] customPreInvDtlVOs, String usrId) throws EventException;
	
	/**
	 * Retrieving Contract information about Owner ship/Charter/Hire Out<br>
	 * Retrieving data on Prepayments window(In case of selecting Inquiry)<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ppayHirNo String
	 * @param invSeq String
	 * @return InvoiceContainerVO
	 * @exception EventException
	 */
	public InvoiceContainerVO searchPrepaymentInvoiceList(String fletCtrtNo, String ppayHirNo, String invSeq) throws EventException;
	
	/**
	 * Handing DELETE - Only in case slip is not generated<br>
	 * Handling DELETE event of Prepayments window<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @exception EventException
	 */
	public void removePrepaymentInvoice(String fletCtrtNo, String invSeq) throws EventException;

	/**
	 * Changing Owner Account Expense <br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void modifyOwnerAccountExpense(CustomCsulSlpVO[] customCsulSlpVOs, String usrid) throws EventException;
	
	/**
	 * Modifying Invoice account related to Broker in case of generating Manual slip<br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @exception EventException
	 */
	public void modifyManualSlip(CustomCsulSlpVO[] customCsulSlpVOs) throws EventException;
	
	/**
	 * Updating Invoice table after generating Slip <br>
	 * 
	 * @param customPamConsultationVOs CustomPamConsultationVO[]
	 * @param customPamCsulSlpVOs CustomPamCsulSlpVO[]
	 * @param slpSerNo String
	 * @exception EventException
	 */
	public void modifyPaymentSlipInvoices(CustomPamConsultationVO[] customPamConsultationVOs, CustomPamCsulSlpVO[] customPamCsulSlpVOs, String slpSerNo) throws EventException;
	
	/**
	 * Updating Owner's Account table after generating slip<br>
	 * 
	 * @param customPamConsultationVOs CustomPamConsultationVO[]
	 * @param customPamCsulSlpVOs CustomPamCsulSlpVO[]
	 * @param slpSerNo String
	 * @exception EventException
	 */
	public void modifyPaymentSlipOwnerAccounts(CustomPamConsultationVO[] customPamConsultationVOs, CustomPamCsulSlpVO[] customPamCsulSlpVOs, String slpSerNo) throws EventException;
	
	/**
	 * Retrieving payment data occurred by mistake of unloading among Owner payable accounts<br>
	 * 
	 * @param fletCtrtNo String
	 * @param fromPayDt String
	 * @param toPayDt String
	 * @param appFlg String
	 * @return List<SearchChaterInvoiceSdmsListVO>
	 * @exception EventException
	 */
	public List<SearchChaterInvoiceSdmsListVO> searchChaterInvoiceSdmsList(String fletCtrtNo, String fromPayDt, String toPayDt, String appFlg) throws EventException;
	
	/**
	 * Getting SDMS INV No.(Criteria of Existing/Not Existing)<br>
	 * 
	 * @param invNo String
	 * @return String
	 * @exception EventException
	 */
	public String checkSdmsInvoiceNo(String invNo) throws EventException;
	
	/**
	 * Getting Hire No.(Criteria of Existing/Not Existing)<br>
	 * 
	 * @param fletCtrtNo String 
	 * @param hireNo String
	 * @return String
	 * @exception EventException
	 */
	public String searchHireNo(String fletCtrtNo, String hireNo) throws EventException;

	/**
	 * Retrieving basic information related to Calculation after selecting Contract number on Payment Slip window<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchInvoiceByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceByPaymentSlipVO> searchInvoiceByPaymentSlip(String fletCtrtNo) throws EventException ;

	/**
	 * Retrieving basic information related to Calculation after selecting Contract number on Payment Slip window<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchInvoiceByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceByPaymentSlipVO> searchInvoiceByPaymentSlip2(String fletCtrtNo) throws EventException ;

	/**
	 * Retrieving Prepayments data which have not approved yet<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ofcCd String
	 * @param csrCurrCd String
	 * @return List<SearchPrepaymentListByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchPrepaymentListByPaymentSlipVO> searchPrepaymentListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws EventException;
	
	/**
	 * Updating IF NO into Invoice in case Hire Out Slip is approved<br>
	 * 
	 * @param searchArSlipDetailListVO List<SearchArSlipDetailListVO>
	 * @exception EventException
	 */
	public void modifySlipApprovalInvoice(List<SearchArSlipDetailListVO> searchArSlipDetailListVO) throws EventException;
	
	/**
	 * Changing Slip number in Invoice into Null in case Charter Slip or Hire Out Slip is canceled<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifySlipApprovalCancelInvoice(String csrNo, String usrId) throws EventException;
	
	/**
	 * Changing Slip number in Account into Null in case Charter Slip is canceled<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
//	public void modifySlipApprovalCancelOwnerAccount(String csrNo, String usrId) throws EventException;
	
	/**
	 * Modifying related data in Calculation table when Hire Out Slip is generated<br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @exception EventException
	 */
	public void modifySubletRevenueSlip(CustomCsulSlpVO[] customCsulSlpVOs) throws EventException;

	/**
	 * Retrieving Monthly data among created data When Hire Revenue Bond is generated<br>
	 * 
	 * @param fletCtrtNo String
	 * @param currCd String
	 * @param slpOfcCd String
	 * @return List<SearchInvoiceListByRevenueSlipVO>
	 * @exception EventException, Exception
	 */
	public List<SearchInvoiceListByRevenueSlipVO> searchPrepaymentListByRevenueSlip(String fletCtrtNo, String currCd, String slpOfcCd) throws EventException;
	
	/**
	  * 품의되지 않은 Charterer's Account 대상 자료를 조회한다<br>
	  * 
	  * @param fletCtrtNo String
	  * @param ofcCd String
	  * @param csrCurrCd String
	  * @return List<SearchCharterListByPaymentSlipVO>
	  * @exception EventException
	  */
	public List<SearchCharterListByPaymentSlipVO> searchCharterListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws EventException;
	
	
	/**
	 * Retrieving the data which is selected to be handled as payment slip on created Offhire Expenses / Window<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ofcCd String
	 * @param csrCurrCd String
	 * @return List<SearchOffhireListByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchOffhireListByPaymentSlipVO> searchOffhireListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws EventException;

	/**
	 * Retrieving the data which is selected to be handled as payment slip on created Owner’s Account / Window<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ofcCd String
	 * @param csrCurrCd String
	 * @return List<SearchOwnerListByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchOwnerListByPaymentSlipVO> searchOwnerListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws EventException;

	/**
	 * Off-Hire Expenses 화면에서 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condCalOffhireInvoiceVO CondCalOffhireInvoiceVO
	 * @return List<SearchCalOffhireInvoiceListVO>
	 * @exception EventException
	 */
	public List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceCheck(CondCalOffhireInvoiceVO condCalOffhireInvoiceVO) throws EventException;

    
    /** 
	 * 입력한 Duration이 유효한지 체크한다.<br>
	 * 
	 * @param CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO
	 * @return String chkFlag
	 * @exception EventException
	 */
    public String searchCalPrepaymentInvoiceCheckDuration(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws EventException;
}