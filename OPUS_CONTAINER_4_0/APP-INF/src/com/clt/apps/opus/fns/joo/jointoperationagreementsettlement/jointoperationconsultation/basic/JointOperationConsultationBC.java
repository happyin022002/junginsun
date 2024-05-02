/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationBC.java
*@FileTitle : Tax Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.basic;

import java.util.List;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CmbConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedGrpVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrSlipVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.LostCombinedDataVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipProcessVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.TaxVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.JooSettlementVO;
import com.clt.syscommon.common.table.JooStlCmbDtlVO;
import com.clt.syscommon.common.table.JooTaxDtlVO;
import com.clt.syscommon.common.table.JooTaxVO;
/**
 * OPUS-Jointoperationagreementsettlement Business Logic Command Interface<br>
 * - OPUS-Jointoperationagreementsettlement: Business Logic Interface<br>
 *
 * @author
 * @see Fns_joo_0044EventResponse
 * @since J2EE 1.4
 */

public interface JointOperationConsultationBC {
	/**
	 * retrieving Tax
	 * @param String taxInvYrmonFr
	 * @param String taxInvYrmonTo
	 * @return List<TaxVO>
	 * @throws EventException
	 */
	public List<TaxVO> searchTaxList(String taxInvYrmonFr, String taxInvYrmonTo) throws EventException;

//	/**
//	 * @param String erpIfFlg
//	 * @param String dtFlg
//	 * @param String fmDt
//	 * @param String toDt
//	 * @return List<ErpIfVO>
//	 * @throws EventException
//	 */
//	public List<ErpIfVO> searchARERPInterfaceList(String erpIfFlg, String dtFlg, String fmDt, String toDt) throws EventException;
	
//	/**
//	 * @param String erpIfFlg
//	 * @param String dtFlg
//	 * @param String fmDt
//	 * @param String toDt
//	 * @return List<ErpIfVO>
//	 * @throws EventException
//	 */
//	public List<ErpIfVO> searchAPERPInterfaceList(String erpIfFlg, String dtFlg, String fmDt, String toDt) throws EventException;	

	/**
	 * retrieving Slip 
	 * @param SlipConditionVO slipConditionVO
	 * @return List<SlipVO>
	 * @throws EventException
	 */
	public List<SlipVO> searchDetailSlipList(SlipConditionVO slipConditionVO) throws EventException;
	
	/**
	 * retrieving CSR list to approve
	 * @param CsrVO csrVO
	 * @return List<CsrVO>
	 * @throws EventException
	 */
	public List<CsrVO> searchConsultationList(CsrVO csrVO) throws EventException;
	
	/**
	 * 
	 * @param CsrVO csrVO
	 * @return List<CsrVO>
	 * @throws EventException
	 */
	public List<CsrVO> searchDetailConsultation(CsrVO csrVO) throws EventException;
	
	/**
	 * 
	 * @param CsrVO csrVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
	 */
	public String approvalConsultation(CsrVO csrVO, SignOnUserAccount signOnUserAccount) throws EventException;

//	/**
//	 * 
//	 * @param String csrNo
//	 * @return TaxGrpVO
//	 * @throws EventException
//	 */
//	public TaxGrpVO searchAPEvidence(String csrNo) throws EventException;

//	/**
//	 * 
//	 * @param String vndrSeq
//	 * @return List<JooTaxVO>
//	 * @throws EventException
//	 */
//	public List<JooTaxVO> searchVendorInfo(String vndrSeq) throws EventException;

	/**
	 * retrieving CSR list
	 * @param SlipConditionVO slipConditionVO
	 * @return List<CsrSlipVO>
	 * @throws EventException
	 */
	public List<CsrSlipVO> searchSlipList(SlipConditionVO slipConditionVO) throws EventException;
	
	/**
	 * retrieving office code of CSR
	 * @param SlipConditionVO slipConditionVO
	 * @return List<SlipConditionVO>
	 * @throws EventException
	 */
	public List<SlipConditionVO> searchCsrOfcList(SlipConditionVO slipConditionVO) throws EventException;

	/**
	 * retrieving Lane List, Settlement list of combined settlement
	 * @param CmbConditionVO cmbConditionVO
	 * @return CombinedGrpVO
	 * @throws EventException
	 */
	public CombinedGrpVO searchCombinedMonthlyClearanceList(CmbConditionVO cmbConditionVO) throws EventException;
	
	/**
	 * retrieving Lane List to combine
	 * @param CmbConditionVO cmbConditionVO
	 * @return List<JooSettlementVO>
	 * @throws EventException
	 */
	public List<JooSettlementVO> searchCombinedRlaneList(CmbConditionVO cmbConditionVO) throws EventException;
	
	/**
	 * retrieving settlement to combine in case of selecting multiple combined lane
	 * @param CmbConditionVO cmbConditionVO
	 * @return List<CombinedVO>
	 * @throws EventException
	 */
	public List<CombinedVO> searchCombinedMonthlyClearanceByLaneList (CmbConditionVO cmbConditionVO) throws EventException;

	/**
	 * processing combining
	 * @param CmbConditionVO cmbConditionVO
	 * @param CombinedVO[] combinedVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return int
	 * @throws EventException
	 */
	public int manageCombinedMonthlyClearance(CmbConditionVO cmbConditionVO, CombinedVO[] combinedVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * canceling combined settlement information
	 * @param CmbConditionVO cmbConditionVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void removeCombinedMonthlyClearance(CmbConditionVO cmbConditionVO, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * retrieving AP CSR
	 * @param SlipProcessVO slipProcessVO
	 * @return List<SlipProcessVO>
	 * @throws EventException
	 */
	public List<SlipProcessVO> searchAPConsultation(SlipProcessVO slipProcessVO) throws EventException;

	/**
	 * creating AP CSR
	 * @param SlipProcessVO[] slipProcessVOs
	 * @param JooTaxVO[] jooTaxVOs
	 * @param JooTaxDtlVO[] jooTaxDtlVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
	 */
	public String createAPConsultation(SlipProcessVO[] slipProcessVOs, JooTaxVO[] jooTaxVOs, JooTaxDtlVO[] jooTaxDtlVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * retrieving monthly closing status in case of inputting effective date
	 * @param SlipProcessVO slipProcessVO
	 * @return SlipProcessVO
	 * @throws EventException
	 */
	public SlipProcessVO searchCloseYn(SlipProcessVO slipProcessVO) throws EventException;
	
	/**
	 * creating AP CSR
	 * @param SlipProcessVO[] slipProcessVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
	 */
	public String createARConsultation(SlipProcessVO[] slipProcessVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * 1. JOO_STL_CMB.RVS_CMB_FLG = 'Y' UPDATE
	 * 2. JOO_STL_CMB_DTL, JOO_SLIP 
	 * 3. JOO_SLP_SEQ INSERT OR UPDATE (SLP_SER_NO )
	 * 4. JOO_CSR INSERT
	 * 5. JOO_STL_CMB INSERT
	 * 6. JOO_STL_CMB_DTL INSERT
	 * 7. JOO_SLIP INSERT
	 * @param CsrVO csrVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<JooStlCmbDtlVO>
	 * @throws EventException
	 */
	public List<JooStlCmbDtlVO> reverseConsultation(CsrVO csrVO, SignOnUserAccount signOnUserAccount) throws EventException;
 
//    /**
//     *
//     * @param  ArDisabledVVDVO arDisabledVVDVO
//     * @throws EventException
//     * @return List<ArDisabledVVDVO>
//     * @author 
//     */
//    public List<ArDisabledVVDVO> searchARDisabledVVD(ArDisabledVVDVO arDisabledVVDVO)  throws EventException;
    
//    /**
//     * 
//     *
//     * @param  ArDataInqVO arDataInqVO
//     * @throws EventException
//     * @return List<ArDataInqVO>
//     * @author 
//     */
//    public List<ArDataInqVO> searchARDataInquiry(ArDataInqVO arDataInqVO ) throws EventException;
    
//	/**
//	 * @param CsrVO csrVO
//	 * @return List<ApIfErrVO>
//	 * @throws EventException
//	 */
//	public List<ApIfErrVO> searchApIfErrList(CsrVO csrVO) throws EventException ;
 
//	/**
//	 * 1. JOO_STL_CMB.RVS_CMB_FLG = 'Y' UPDATE
//	 * 2. JOO_STL_CMB_DTL, JOO_SLIP 
//	 * 3. JOO_SLP_SEQ INSERT OR UPDATE (SLP_SER_NO)
//	 * 4. JOO_CSR INSERT
//	 * 5. JOO_STL_CMB INSERT
//	 * 6. JOO_STL_CMB_DTL INSERT
//	 * 7. JOO_SLIP INSERT
//	 * @param CsrVO csrVO
//	 * @param SignOnUserAccount signOnUserAccount
//	 * @return List<JooStlCmbDtlVO>
//	 * @throws EventException
//	 */
//	public List<JooStlCmbDtlVO> rejectConsultation(CsrVO csrVO, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * retrieving lost combined data 
	 * @param SlipConditionVO slipConditionVO
	 * @return List<LostCombinedDataVO>
	 * @throws EventException
	 */
	public List<LostCombinedDataVO> searchLostCombinedDataList(SlipConditionVO slipConditionVO) throws EventException;

	/**
	 * retrieving office code of CSR
	 * @param SlipConditionVO slipConditionVO
	 * @return List<SlipConditionVO>
	 * @throws EventException
	 */
	public List<SlipConditionVO> searchStlOfcList(SlipConditionVO slipConditionVO) throws EventException;

	/**
	 * @param CsrVO csrVO
	 * @return List<CsrVO>
	 * @throws EventException
	 */
	public List<CsrVO> searchCsrDetail(CsrVO csrVO) throws EventException;

    /**
     * retrieving result of BackEndJob
     * @param String key
     * @return String
     * @throws EventException
     */
	public String searchBakEndJobStatus(String key) throws EventException;
	/**
	 * AR_MST_REV_VVD Checked.
	 * @param SlipProcessVO slipProcessVO
	 * @return String
	 * @throws EventException
	 */
	public String getCheckArMasterRevenueVvd(SlipProcessVO slipProcessVO) throws EventException;
	
	/**
	 * setting Approval process
	 * @param SlipProcessVO slipProcessVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void createCSREPApproval(SlipProcessVO slipProcessVO, SignOnUserAccount signOnUserAccount) throws EventException;
	
}