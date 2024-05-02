/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOSettlementBC.java
*@FileTitle : Owner's Account to Expenses
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic;

import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondReverseCsrForSubletVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchInvoiceNoVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSlipApprovalVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSubletRevenueVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomConsultationVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpSeqVO;
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
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Timecharterinoutaccounting Business Logic Command Interface<br>
 * - OPUS-Timecharterinoutaccounting Biz Logic Interface<br>
 *
 * @author
 * @see Esm_fms_0039EventResponse 
 * @since J2EE 1.6
 */

public interface TCharterIOConsultationBC {
	
	/**
	 * Retrieving ReSublet Revenue slip data by ReSublet Revenue slip as a condition<br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchSubletRevenueSlipListVO>
	 * @exception EventException
	 */
	public List<SearchSubletRevenueSlipListVO> searchSubletRevenueSlipList(CustomCsulSlpSeqVO customCsulSlpSeqVO) throws EventException;

	/**
	 * Checking Center Code / City Code value<br>
	 * 
	 * @param ctrCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkCenterCode(String ctrCd) throws EventException;
	
	/**
	 * Checking Bunker Vvd value<br>
	 * 
	 * @param bunkerVvd String
	 * @return String
	 * @exception EventException
	 */
	public String checkVvdCode(String bunkerVvd) throws EventException;

	/**
	 * Retrieving Payment Slip information<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchPaymentSlipListVO>
	 * @exception EventException
	 */
	public List<SearchPaymentSlipListVO> searchPaymentSlipList(String csrNo) throws EventException;
	
	/**
	 * Retrieving related costs have to be handled by work-site operation regardless of Agreement Creation aside from Charter/Hire Out costs <br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchManualSlipListVO>
	 * @exception EventException
	 */
	public List<SearchManualSlipListVO> searchManualSlipList(CustomCsulSlpSeqVO customCsulSlpSeqVO) throws EventException;
	
	/**
	 * Retrieving Tax Master data relevant to CSR No. <br>
	 * 
	 * @param csrNo String
	 * @return SearchTaxMasterEvidenceVO
	 * @exception EventException
	 */
	public SearchTaxMasterEvidenceVO searchTaxMasterEvidence(String csrNo) throws EventException;
	
	/**
	 * Retrieving Tax Detail data relevant to CSR No. <br>
	 * 
	 * @param csrNo String
	 * @return List<SearchTaxDetailEvidenceListVO>
	 * @exception EventException
	 */
	public List<SearchTaxDetailEvidenceListVO> searchTaxDetailEvidenceList(String csrNo) throws EventException;
	
	/**
	 * Retrieving  Customer Code<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchCustomerCodeVO>
	 * @exception EventException
	 */
	public List<SearchCustomerCodeVO> searchCustomerCode(String fletCtrtNo) throws EventException;

	/**
	 * Generating Slip by arranging prepayments in actual costs accounts <br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param usrId String
	 * @return String
	 * @exception EventException
	 */
	public String managePrepaymentSettlement(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, String usrId) throws EventException;

	/**
	 * In Charter case, when slip is consulted, it is sent to ERP A/P
	 * In Hire Out case, when slip is consulted, it is sent to ERP A/R<br>
	 * 
	 * @param fletCtrtTpCd String
	 * @param csrNo String
	 * @param aproFlg String
	 * @param cxlDesc String
	 * @param account SignOnUserAccount
	 * @return List<SearchArSlipDetailListVO>
	 * @throws EventException
	 */
	public List<SearchArSlipDetailListVO> manageSlipApproval(String fletCtrtTpCd, String csrNo, String aproFlg, String cxlDesc, SignOnUserAccount account) throws EventException ;

	/**
	 * In Charter case, when slip is consulted, it is sent to ERP A/P
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipApprovalListVO>
	 * @throws EventException
	 */
	public List<SearchSlipApprovalListVO> searchSlipApprovalList(CondSearchSlipApprovalVO condSearchSlipApprovalVO) throws EventException;

	/**
	 * Retrieving Bond calculation amount Detail History about written Bond<br>
	 * 
	 * @param condSearchSubletRevenueVO CondSearchSubletRevenueVO
	 * @return List<SearchSubletRevenueListVO>
	 * @exception EventException
	 */
	public List<SearchSubletRevenueListVO> searchSubletReveuneList(CondSearchSubletRevenueVO condSearchSubletRevenueVO) throws EventException;
	
	/**
	 * Retrieving Bond calculation amount Detail History about written Bond<br>
	 * 
	 * @param toInvNo String
	 * @param csrNo String
	 * @return List<SearchSubletReveuneDetailListVO>
	 * @exception EventException
	 */
	public List<SearchSubletReveuneDetailListVO> searchSubletReveuneDetailList(String toInvNo, String csrNo) throws EventException;

	/**
	 * Retrieving conditional Slip Correction - Master information of written slip <br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipCorrectionListVO>
	 * @exception EventException
	 */
	public List<SearchSlipCorrectionListVO> searchSlipCorrectionList(CondSearchSlipApprovalVO condSearchSlipApprovalVO) throws EventException;
	
	/**
	 * Modifying Description of Slip Master at Slip Correction <br>
	 * 
	 * @param csrNo String
	 * @param csrDesc String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifySlipCorrection(String csrNo, String csrDesc, String usrId) throws EventException;

	/**
	 * Retrieving created Bond to create import bond subtraction part<br>
	 * 
	 * @param condReverseCsrForSubletVO CondReverseCsrForSubletVO
	 * @return List<SearchReverseCsrForSubletVOList>
	 * @exception EventException
	 */
	public List<SearchReverseCsrForSubletListVO> searchReverseCsrForSubletList(CondReverseCsrForSubletVO condReverseCsrForSubletVO) throws EventException;
	
	/**
	 * Retrieving created Bond to create import bond subtraction part<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param usrid String
	 * @return String
	 * @exception EventException
	 */
	public String manageReverseCsrForSublet(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, String usrId) throws EventException;
	
	/**
	 * Retrieving created Bond to create import bond subtraction part by Invoice condition <br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchReverseCsrForSubletSaveListVO>
	 * @exception EventException
	 */
	
	public List<SearchReverseCsrForSubletSaveListVO> searchReverseCsrForSubletSaveList(CustomCsulSlpSeqVO customCsulSlpSeqVO) throws EventException;
	
	/**
	 * Generating Sublet Revenue slip<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param usrid String
	 * @return String
	 * @exception EventException
	 */
	public String manageSubletRevenueSlip(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, String usrId) throws EventException;
	
	/**
	 * Insert/Modify related costs have to be handled by work-site operation regardless of Agreement Creation aside from Charter/Hire Out costs<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param customTaxVOs CustomTaxVO[]
	 * @param customTaxDtlVOs CustomTaxDtlVO[]
	 * @param usrId String
	 * @return String
	 * @exception EventException
	 */
	public String manageManualSlip(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, CustomTaxVO[] customTaxVOs, CustomTaxDtlVO[] customTaxDtlVOs, String usrId) throws EventException;

	/**
	 * Retrieving created Brokerage to handle it in Manual Slip<br>
	 * 
	 * @param currCd String
	 * @return List<SearchBrokerageListVO>
	 * @exception EventException
	 */
	public List<SearchBrokerageListVO> searchBrokerageList(String currCd) throws EventException;

	/**
	 * Retrieving Financial Voyage in Manual Slip<br>
	 * 
	 * @param fletCtrtNo String
	 * @param fmDt String
	 * @param toDt String
	 * @return List<SearchVvdListByManualSlipVO>
	 * @exception EventException
	 */
	public List<SearchVvdListByManualSlipVO> searchVvdListByManualSlip(String fletCtrtNo, String fmDt, String toDt) throws EventException;

	/**
	 * Retrieving approved slip number<br>
	 * 
	 * @param condSearchInvoiceNoVO CondSearchInvoiceNoVO
	 * @return List<SearchInvoiceNoListVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceNoListVO> searchInvoiceNoList(CondSearchInvoiceNoVO condSearchInvoiceNoVO) throws EventException;

	/**
	 * Retrieving conditional Slip Inquiry Detail information of written slip<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipDetailListVO>
	 * @exception EventException
	 */
	public List<SearchSlipDetailListVO> searchSlipDetailList(String csrNo) throws EventException;

	/**
	 * Modifying Description of Slip Detail at Slip Correction<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipCorrectionDetailListVO>
	 * @throws EventException
	 */
	public List<SearchSlipCorrectionDetailListVO> searchSlipCorrectionDetailList(String csrNo) throws EventException;

	/**
	 * Modifying Description of Slip Detail at Slip Correction<br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException 
	 */
	public void modifySlipDetailCorrection(CustomCsulSlpVO[] customCsulSlpVOs, String csrNo, String usrId) throws EventException;

	/**
	 * Creating slip by using Prepayment, Vessel Operation Stoppage Cost, Charterer Cost, Owner's Account<br>
	 * 
	 * @param customPamConsultationVOs CustomPamConsultationVO[]
	 * @param customPamCsulSlpVOs CustomPamCsulSlpVO[]
	 * @param customTaxVOs CustomTaxVO[]
	 * @param customTaxDtlVOs CustomTaxDtlVO[]
	 * @return String
	 * @exception EventException
	 */
	public String managePaymentSlip(CustomPamConsultationVO[] customPamConsultationVOs, CustomPamCsulSlpVO[] customPamCsulSlpVOs, CustomTaxVO[] customTaxVOs, CustomTaxDtlVO[] customTaxDtlVOs) throws EventException;
	
	/**
	 * Retrieving conditional Slip Inquiry information of written slip<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipApprovalListVO>
	 * @exception EventException
	 */
	public List<SearchSlipApprovalListVO> searchConsultationSlipList(CondSearchSlipApprovalVO condSearchSlipApprovalVO) throws EventException;
	
	/**
	 * CSR No. 에 해당하는 Consultation Master 데이타 조회<br>
	 * 
	 * @param csrNo String
	 * @return SearchPaymentSlipMasterVO
	 * @exception EventException
	 */
	public SearchPaymentSlipMasterVO searchPaymentSlipMaster(String csrNo) throws EventException;
	
}