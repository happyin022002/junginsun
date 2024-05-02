/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOSettlementBC.java
*@FileTitle : Owner's Account to Expenses
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.25 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic;

import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondReverseCsrForSubletVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchInterfaceStatusVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchInvoiceNoVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSlipApprovalVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSubletRevenueVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpSeqVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomInterfaceStatusVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchArSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchBrokerageListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchCustomerCodeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchInterfaceStatusDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchInterfaceStatusListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchInvoiceNoListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchManualSlipListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchPaymentSlipListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchReverseCsrForSubletListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchReverseCsrForSubletSaveListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipCorrectionDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipCorrectionListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletRevenueSlipListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletReveuneDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchTaxDetailEvidenceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchTaxMasterEvidenceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchVvdListByManualSlipVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestBodyVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestFileVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestHeaderVO;


/**
 * NIS2010-Timecharterinoutaccounting Business Logic Command Interface<br>
 * - NIS2010-Timecharterinoutaccounting에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Yoon, Seyeong  
 * @see Esm_fms_0039EventResponse 참조
 * @since J2EE 1.6
 */

public interface TCharterIOConsultationBC {
	
	/**
	 * Owner'sAccount Expense 데이터를 등록한다<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param usrId String
	 * @return slpSerNo String
	 * @exception EventException
	 */
	public String creationOwnerAccountExpense(CustomConsultationVO customConsultationVO,CustomCsulSlpVO[] customCsulSlpVOs, String usrId) throws EventException;
	
	/**
	 * Sublet Revenue slip(대선 전표)를 생성한다<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String manageSubletRevenueSlip(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * Sublet Revenue slip(대선 전표)를 조건으로 해서 대선 전표 계정 자료를 조회한다<br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchSubletRevenueSlipListVO>
	 * @exception EventException
	 */
	public List<SearchSubletRevenueSlipListVO> searchSubletRevenueSlipList(CustomCsulSlpSeqVO customCsulSlpSeqVO) throws EventException;

	/**
	 * 자발적, 비자발적 오류 처리할 전표에 대한 취소 작업 진행한다<br>
	 * 
	 * @param customInterfaceStatusVOs CustomInterfaceStatusVO[]
	 * @param statusFlag String
	 * @param SignOnUserAccount signOnUserAccount
	 * @param aproStep String
	 * @exception EventException
	 */
	public void manageInterfaceStatus(CustomInterfaceStatusVO[] customInterfaceStatusVOs, String statusFlag, SignOnUserAccount signOnUserAccount, String aproStep) throws EventException;

	/**
	 * 자발적, 비자발적 오류 처리할 전표를 조회한다<br>
	 * 
	 * @param condSearchInterfaceStatusVO CondSearchInterfaceStatusVO
	 * @return List<SearchInterfaceStatusListVO>
	 * @exception EventException
	 */
	public List<SearchInterfaceStatusListVO> searchInterfaceStatusList(CondSearchInterfaceStatusVO condSearchInterfaceStatusVO) throws EventException ;

	/**
	 * 자발적, 비자발적 오류 처리할 전표를 계정별 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchInterfaceStatusDetailListVO>
	 * @exception EventException
	 */
	public List<SearchInterfaceStatusDetailListVO> searchInterfaceStatusDetailList(String csrNo) throws EventException ;

	/**
	 * 기 지급한 선급금을 실제 비용 계정으로 정리하여 전표를 생성한다<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String managePrepaymentSettlement(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * 작성된 채권에 대한 채권 계상액 Detail History 조회한다<br>
	 * 
	 * @param condSearchSubletRevenueVO CondSearchSubletRevenueVO
	 * @return List<SearchSubletRevenueListVO>
	 * @exception EventException
	 */
	public List<SearchSubletRevenueListVO> searchSubletReveuneList(CondSearchSubletRevenueVO condSearchSubletRevenueVO) throws EventException;
	
	/**
	 * 작성된 채권에 대한 채권 계상액 Detail History 조회한다<br>
	 * 
	 * @param toInvNo String
	 * @return List<SearchSubletReveuneDetailListVO>
	 * @exception EventException
	 */
	public List<SearchSubletReveuneDetailListVO> searchSubletReveuneDetailList(String toInvNo) throws EventException;
	
	/**
	 * 작성된 전표의 조건별 Slip Approval Master 정보를 조회한다<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipApprovalListVO>
	 * @param String userId
	 * @exception EventException
	 */
	public List<SearchSlipApprovalListVO> searchSlipApprovalList(CondSearchSlipApprovalVO condSearchSlipApprovalVO, String userId) throws EventException;
	
	/**
	 * 작성된 전표의 조건별 Submit to GW 정보를 조회한다<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipApprovalListVO>
	 * @exception EventException
	 */
	public List<SearchSlipApprovalListVO> searchSlipSubmitToGWList(CondSearchSlipApprovalVO condSearchSlipApprovalVO) throws EventException;
	
	/**
	 * 작성된 전표의 조건별 Slip Inquiry Master 정보를 조회한다<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipApprovalListVO>
	 * @exception EventException
	 */
	public List<SearchSlipApprovalListVO> searchSlipInquiryList(CondSearchSlipApprovalVO condSearchSlipApprovalVO) throws EventException;
	
	
	/**
	 * 기 결제된 채권번호를 조회한다<br>
	 * 
	 * @param condSearchInvoiceNoVO CondSearchInvoiceNoVO
	 * @return List<SearchInvoiceNoListVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceNoListVO> searchInvoiceNoList(CondSearchInvoiceNoVO condSearchInvoiceNoVO) throws EventException;
	
	/**
	 * 작성된 전표의 조건별 Slip Inquiry Detail 정보를 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipDetailListVO>
	 * @exception EventException
	 */
	public List<SearchSlipDetailListVO> searchSlipDetailList(String csrNo) throws EventException;
	
	/**
	 * 작성된 전표의 조건별 Slip Correction - Master 정보를 조회한다<br>
	 * 
	 * @param condSearchSlipApprovalVO CondSearchSlipApprovalVO
	 * @return List<SearchSlipCorrectionListVO>
	 * @exception EventException
	 */
	public List<SearchSlipCorrectionListVO> searchSlipCorrectionList(CondSearchSlipApprovalVO condSearchSlipApprovalVO) throws EventException;
	
	/**
	 * Slip Correction 에서 Slip Master 의 Description 를 수정한다<br>
	 * 
	 * @param csrNo String
	 * @param csrDesc String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifySlipCorrection(String csrNo, String csrDesc, String usrId) throws EventException;
	
	/**
	 * 작성된 전표의 조건별 Slip Correction Detail 정보를 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchSlipCorrectionDetailListVO>
	 * @exception EventException
	 */
	public List<SearchSlipCorrectionDetailListVO> searchSlipCorrectionDetailList(String csrNo) throws EventException;
	
	/**
	 * 수입 채권 차감 분을 작성하기 위한 기 생성 채권을 조회한다<br>
	 * 
	 * @param condReverseCsrForSubletVO CondReverseCsrForSubletVO
	 * @return List<SearchReverseCsrForSubletListVO>
	 * @exception EventException
	 */
	public List<SearchReverseCsrForSubletListVO> searchReverseCsrForSubletList(CondReverseCsrForSubletVO condReverseCsrForSubletVO) throws EventException;
	
	/**
	 * Slip Correction 에서 Slip Detail 의 Description 를 수정한다<br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifySlipDetailCorrection(CustomCsulSlpVO[] customCsulSlpVOs, String csrNo, String usrId) throws EventException;
	
	/**
	 * Center Code / City Code 값을 체크한다<br>
	 * 
	 * @param ctrCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkCenterCode(String ctrCd) throws EventException;
	
	/**
	 * Bunker Vvd 값을 체크한다<br>
	 * 
	 * @param bunkerVvd String
	 * @return String
	 * @exception EventException
	 */
	public String checkVvdCode(String bunkerVvd) throws EventException;

	/**
	 * 수입 채권 차감 분을 작성하기 위한 기 생성 채권을 생성한다<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String manageReverseCsrForSublet(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * 수입 채권 차감 분을 작성하기 위한 기 생성 채권을 Invoice 조건으로 조회한다<br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchReverseCsrForSubletSaveListVO>
	 * @exception EventException
	 */
	
	public List<SearchReverseCsrForSubletSaveListVO> searchReverseCsrForSubletSaveList(CustomCsulSlpSeqVO customCsulSlpSeqVO) throws EventException;

	/**
	 * 용선인 경우 전표가 승인되면 ERP A/P 로 전송된다
	 * 대선인 경우 전표가 승인되면 ERP A/R 로 전송된다<br>
	 * 
	 * @param fletCtrtTpCd String
	 * @param csrNo String
	 * @param aproFlg String
	 * @param cxlDesc String
	 * @param usrId String
	 * @param interCoCd String
	 * @param arInterCoCd String
	 * @param aproFlgUpdateYn String
	 * @param ofcCd String
	 * @param String slipAproFlg
	 * @param String asaNo
	 * @return List<SearchArSlipDetailListVO> searchArSlipDetailListVO 
	 * @exception EventException
	 */
	public List<SearchArSlipDetailListVO> manageSlipApproval(String fletCtrtTpCd, String csrNo, String aproFlg, String cxlDesc, String usrId, String interCoCd, String arInterCoCd, String aproFlgUpdateYn, String ofcCd, String slipAproFlg, String asaNo) throws EventException ;
	
	/**
	 * Manual Slip에서 재무 항차 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param fmDt String
	 * @param toDt String
	 * @return List<SearchVvdListByManualSlipVO>
	 * @exception EventException
	 */
	public List<SearchVvdListByManualSlipVO> searchVvdListByManualSlip(String fletCtrtNo, String fmDt, String toDt) throws EventException;

	/**
	 * 생성된 Brokerage를 Manual 전표에서 처리하기 위해 조회한다<br>
	 * 
	 * @param currCd String
	 * @return List<SearchBrokerageListVO>
	 * @exception EventException
	 */
	public List<SearchBrokerageListVO> searchBrokerageList(String currCd) throws EventException;
	 
	/**
	 * Prepayment, 운항정지비용, 용선주 비용, Owner's Account 관련를 이용하여 전표를 생성한다<br>
	 * 
	 * @param customPamConsultationVOs CustomPamConsultationVO[]
	 * @param customPamCsulSlpVOs CustomPamCsulSlpVO[]
	 * @param customTaxVOs CustomTaxVO[]
	 * @param customTaxDtlVOs CustomTaxDtlVO[]
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String managePaymentSlip(CustomPamConsultationVO[] customPamConsultationVOs, CustomPamCsulSlpVO[] customPamCsulSlpVOs, CustomTaxVO[] customTaxVOs, CustomTaxDtlVO[] customTaxDtlVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * Payment Slip 정보를 조회한다<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchPaymentSlipListVO>
	 * @exception EventException
	 */
	public List<SearchPaymentSlipListVO> searchPaymentSlipList(String csrNo) throws EventException;
	
	/**
	 * 용/ 대선료 관련 비용 이외에 선박계약(Agreement Creation)과 상관없이 현업에서 처리해야 할 관련 제반 비용을 등록 및 변경한다<br>
	 * 
	 * @param customConsultationVO CustomConsultationVO
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @param customTaxVOs CustomTaxVO[]
	 * @param customTaxDtlVOs CustomTaxDtlVO[]
	 * @param usrId String
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String manageManualSlip(CustomConsultationVO customConsultationVO, CustomCsulSlpVO[] customCsulSlpVOs, CustomTaxVO[] customTaxVOs, CustomTaxDtlVO[] customTaxDtlVOs, String usrId, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * 용/ 대선료 관련 비용 이외에 선박계약(Agreement Creation)과 상관없이 현업에서 처리해야 할 관련 제반 비용을 조회한다<br>
	 * 
	 * @param customCsulSlpSeqVO CustomCsulSlpSeqVO
	 * @return List<SearchManualSlipListVO>
	 * @exception EventException
	 */
	public List<SearchManualSlipListVO> searchManualSlipList(CustomCsulSlpSeqVO customCsulSlpSeqVO) throws EventException;
	
	/**
	 * CSR No. 에 해당하는 Tax Master 데이타 조회<br>
	 * 
	 * @param csrNo String
	 * @return SearchTaxMasterEvidenceVO
	 * @exception EventException
	 */
	public SearchTaxMasterEvidenceVO searchTaxMasterEvidence(String csrNo) throws EventException;
	
	/**
	 * CSR No. 에 해당하는 Tax Detail 데이타 조회<br>
	 * 
	 * @param csrNo String
	 * @return List<SearchTaxDetailEvidenceListVO>
	 * @exception EventException
	 */
	public List<SearchTaxDetailEvidenceListVO> searchTaxDetailEvidenceList(String csrNo) throws EventException;
	
	/**
	 * AR INTERFACE 결과를 업데이트 작업 진행한다<br>
	 * 
	 * @param xmlObject XmlObject
	 * @exception EventException
	 */
	public void receiveSlipApprovalToAR (XmlObject xmlObject) throws EventException;

	/**
	 * Cumstomer Code를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchCustomerCodeVO>
	 * @exception EventException
	 */
	public List<SearchCustomerCodeVO> searchCustomerCode(String fletCtrtNo) throws EventException;
	
	/**
	 * 승인처리 등록한다.<br>
	 * 
	 * @param usrId String
	 * @param csrNo String
	 * @param ofcCd String 
	 * @param String batchEvntYN
	 * @exception EventException
	 */
	public void manageApproveFMS (String usrId, String csrNo, String ofcCd, String batchEvntYN) throws EventException;
	
	/**
	 * 승인처리 등록한다.<br>
	 * 
	 * @param usrId String
	 * @param csrNo String
	 * @param ofcCd String 
	 * @exception EventException
	 */
	public void manageApproveFMS (String usrId, String csrNo, String ofcCd) throws EventException;
	
	/**
	 * 비승인처리 등록한다.<br>
	 * 
	 * @param usrId String 
	 * @param csrNo String
	 * @param ofcCd String 
	 * @exception EventException
	 */
	public void manageDisapproveFMS (String usrId, String csrNo, String ofcCd) throws EventException;		

	/**
	 * 조회 이벤트 처리<br>
	 * CSR Agreement Info List
	 * @param csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 * @exception EventException 
	 */
	public List<ComCsrRequestAgmtVO> printFmsCsrAgmtInfo(String csrNo) throws EventException;	
	
	
	/**
	 * Settlement GW 정보 eai 전송<br>
	 * 
	 * @param String csrNo
	 * @return List<ComCsrRequestBodyVO> 
	 * @exception EventException
	 */	
	public List<ComCsrRequestBodyVO> printComCsrBodyInfo(String csrNo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CSR Header Info
	 * @param csrNo
	 * @return ComCsrRequestHeaderVO
	 */
	public ComCsrRequestHeaderVO printComCsrHeaderInfo(String csrNo) throws EventException;
	
	
	/**
	 * AR-GW결재 AR_INV_HDR 저장한다.<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageArInvHdr(String csrNo, String usrId) throws EventException;	
	
	/**
	 * GW에서 결과 값 전송<br>
	 * AR_INV_HDR 의  GW Url, Request_id 업데이트
	 * 
	 * @param csr_no String
	 * @param request_id String
	 * @param gw_url String
	 * @exception EventException
	 */
	public void updateAproGwUrl(String csr_no, String request_id, String gw_url) throws EventException;		

	/**
	 * CSR File Info List
	 * @param csrNo
	 * @return List<ComCsrRequestFileVO>
	 */
	public List<ComCsrRequestFileVO> printComCsrFileInfo(String csrNo) throws EventException;
	
	/**
	 * CSR cancel 처리한다.<br>
	 * 
	 * @param fletCtrtTpCd String
	 * @param csrNo String
	 * @param cxlDesc String
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageCsrCancel(String fletCtrtTpCd, String csrNo, String cxlDesc, String usrId) throws EventException;
}
