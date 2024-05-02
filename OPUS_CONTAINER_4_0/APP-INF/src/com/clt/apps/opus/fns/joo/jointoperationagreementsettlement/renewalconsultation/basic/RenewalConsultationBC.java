/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtBC.java
*@FileTitle : Settlement Item & Account Code List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.basic;

import java.util.List;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipProcessVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.ActualDetailVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.ConsultationConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.InvoiceDetailVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.InvoiceVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.SettlementTargetVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-renewalmasterdatamgt Business Logic Command Interface<br>
 * - OPUS-renewalmasterdatamgt: Business Logic Interface<br>
 *
 * @author
 * @see Ui_joo_0028EventResponse
 * @since J2EE 1.4
 */

public interface RenewalConsultationBC {

    /**
	 * Retrieve/Create (Back End Job) : Select Target VVD For Settlement Creation화면 조회/생성. 
	 * 
	 * @category FNS_JOO_0101
	 * @param SettlementTargetVO settlementTargetVO
     * @param String jobFlg
     * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
     */
    public String searchSettlementTargetBackEndJobList(SettlementTargetVO settlementTargetVO, String jobFlg, SignOnUserAccount signOnUserAccount) throws EventException;
	

    /**
	 * Save (Back End Job) : Select Target VVD For Settlement Creation 저장. 
	 * 
	 * @category FNS_JOO_0101
	 * @param SettlementTargetVO[] settlementTargetVOS
     * @param String jobFlg
     * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
     */
    public String manageSettlementTargetBackEndJobList(SettlementTargetVO[] settlementTargetVOS, String jobFlg, SignOnUserAccount signOnUserAccount) throws EventException;
    
    /**
     * Retrieve Common BackEndJob Status
     * 
     * @param String key
     * @return String
     * @throws EventException
     */
	public String searchComBackEndJobStatus(String key) throws EventException;
	
	/**
	 * Retrieve : Select actual payer/receiver for slip 조회.
	 * 
	 * @category FNS_JOO_0104
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceVO>
	 * @throws Exception
	 */
	public List<InvoiceVO> searchActualPayerReceiverList(ConsultationConditionVO consultationConditionVO) throws EventException;
	

    /**
	 * Save : Select actual payer/receiver for slip 저장. 
	 * 
	 * @category FNS_JOO_0104
	 * @param ConsultationConditionVO consultationConditionVO
	 * @param InvoiceVO[] invoiceVOS
     * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
     */
    public void manageActualPayerReceiverList(ConsultationConditionVO consultationConditionVO, InvoiceVO[] invoiceVOS, SignOnUserAccount signOnUserAccount) throws EventException;


	/**
	 * Retrieve : Actual Detail Invoice No Combo Item 조회.
	 * 
	 * @category FNS_JOO_0105
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<ActualDetailVO>
	 * @throws Exception
	 */
	public List<ActualDetailVO> searchInvoiceNoList(ConsultationConditionVO consultationConditionVO) throws EventException;

	/**
	 * Retrieve : Actual Detail Invoice 조회.
	 * 
	 * @category FNS_JOO_0105
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<ActualDetailVO>
	 * @throws Exception
	 */
	public List<ActualDetailVO> searchActualDetailList(ConsultationConditionVO consultationConditionVO) throws EventException;

	/**
	 * Retrieve : Invoice Creation 대상 조회.
	 * 
	 * @category FNS_JOO_0102
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceVO>
	 * @throws Exception
	 */
	public List<InvoiceVO> searchInvoiceTargetList(ConsultationConditionVO consultationConditionVO) throws EventException;

	/**
	 * Retrieve : Invoice Creation 대상 Detail 조회.
	 * 
	 * @category FNS_JOO_0102
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceDetailVO>
	 * @throws Exception
	 */
	public List<InvoiceDetailVO> searchInvoiceTargetDetailList(ConsultationConditionVO consultationConditionVO) throws EventException;
	

    /**
	 * Save : Invoice/Slip Creation. : Manual
	 * 
	 * @category FNS_JOO_0102
	 * @param InvoiceVO[] invoiceVOS
	 * @param InvoiceDetailVO[] invoiceDetailVOS
     * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
     */
    public void manageInvoiceList(InvoiceVO[] invoiceVOS, InvoiceDetailVO[] invoiceDetailVOS, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * Retrieve : CSR Creation 조회.
	 * 
	 * @category FNS_JOO_0103
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<SlipProcessVO>
	 * @throws Exception
	 */
	public List<SlipProcessVO> searchCsrCreationList(ConsultationConditionVO consultationConditionVO) throws EventException;    
	
	/**
	 * SAVE- CSR Creation List : AP/AR 생성.<br>
	 * 
	 * @category FNS_JOO_0103
	 * @param SlipProcessVO[] slipProcessVOS
     * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
     */
    public void manageConsultationList(SlipProcessVO[] slipProcessVOS, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * Retrieve : Invoice Delete 대상 조회.
	 * 
	 * @category FNS_JOO_0106
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceVO>
	 * @throws Exception
	 */
	public List<InvoiceVO> searchInvoiceDeleteList(ConsultationConditionVO consultationConditionVO) throws EventException;
	
    /**
	 * Save : Invoice Delete 대상삭제
	 * 
	 * @category FNS_JOO_0106
	 * @param InvoiceVO[] invoiceVOS
     * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
     */
    public void manageInvoiceDeleteList(InvoiceVO[] invoiceVOS, SignOnUserAccount signOnUserAccount) throws EventException;


	/**
	 * Retrieve : Invoice Inquiry : Summary 조회.
	 * 
	 * @category FNS_JOO_0107
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceVO>
	 * @throws Exception
	 */
	public List<InvoiceVO> searchInvoiceReportSummaryList(ConsultationConditionVO consultationConditionVO) throws EventException;

	/**
	 * Retrieve : Invoice Inquiry : Detail 조회.
	 * 
	 * @category FNS_JOO_0107
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceDetailVO>
	 * @throws Exception
	 */
	public List<InvoiceDetailVO> searchInvoiceReportDetailList(ConsultationConditionVO consultationConditionVO) throws EventException;

	/**
	 * Retrieve : Settlement Target Summary 조회.
	 * 
	 * @category FNS_JOO_0108
	 * @param ConsultationConditionVO consultationConditionVO
	 * @return List<InvoiceVO>
	 * @throws Exception
	 */
	public List<InvoiceVO> searchSettlementTargetSummaryList(ConsultationConditionVO consultationConditionVO) throws EventException;
}