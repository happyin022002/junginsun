/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationBC.java
*@FileTitle : Tax Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.18 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ArDisabledVVDVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ApIfErrVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ArDataInqVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CmbConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedGrpVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrSlipVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ErpIfVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.LostCombinedDataVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipProcessVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.TaxGrpVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.TaxVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.JooCrrMrgVO;
import com.hanjin.syscommon.common.table.JooSettlementVO;
import com.hanjin.syscommon.common.table.JooStlCmbDtlVO;
import com.hanjin.syscommon.common.table.JooTaxDtlVO;
import com.hanjin.syscommon.common.table.JooTaxVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.AgmtDocVO;

/**
 * ALPS-Jointoperationagreementsettlement Business Logic Command Interface<br>
 * - ALPS-Jointoperationagreementsettlement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Park Hee Dong
 * @see Fns_joo_0044EventResponse 참조
 * @since J2EE 1.4
 */

public interface JointOperationConsultationBC {
	/**
	 * Tax를 조회한다.
	 * @param String taxInvYrmonFr
	 * @param String taxInvYrmonTo
	 * @return List<TaxVO>
	 * @throws EventException
	 */
	public List<TaxVO> searchTaxList(String taxInvYrmonFr, String taxInvYrmonTo) throws EventException;

	/**
	 * AR Data ERP Interface를 조회한다.
	 * @param String erpIfFlg
	 * @param String dtFlg
	 * @param String fmDt
	 * @param String toDt
	 * @return List<ErpIfVO>
	 * @throws EventException
	 */
	public List<ErpIfVO> searchARERPInterfaceList(String erpIfFlg, String dtFlg, String fmDt, String toDt) throws EventException;
	
	/**
	 * AP Data ERP Interface를 조회한다.
	 * @param String erpIfFlg
	 * @param String dtFlg
	 * @param String fmDt
	 * @param String toDt
	 * @return List<ErpIfVO>
	 * @throws EventException
	 */
	public List<ErpIfVO> searchAPERPInterfaceList(String erpIfFlg, String dtFlg, String fmDt, String toDt) throws EventException;	

	/**
	 * 전표를 조회한다. 
	 * @param SlipConditionVO slipConditionVO
	 * @return List<SlipVO>
	 * @throws EventException
	 */
	public List<SlipVO> searchDetailSlipList(SlipConditionVO slipConditionVO) throws EventException;
	
	/**
	 * 승인할 CSR 리스트를 조회한다.
	 * @param CsrVO csrVO
	 * @return List<CsrVO>
	 * @throws EventException
	 */
	public List<CsrVO> searchConsultationList(CsrVO csrVO) throws EventException;
	
	/**
	 * CSR No.로 Approval 대상 CSR정보를 조회한다.
	 * @param CsrVO csrVO
	 * @return List<CsrVO>
	 * @throws EventException
	 */
	public List<CsrVO> searchDetailConsultation(CsrVO csrVO) throws EventException;
	
	/**
	 * CSR 승인처리 한다.
	 * @param CsrVO csrVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
	 */
	public String approvalConsultation(CsrVO csrVO, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * AP CSR의 Evience를 조회한다.
	 * @param String csrNo
	 * @return TaxGrpVO
	 * @throws EventException
	 */
	public TaxGrpVO searchAPEvidence(String csrNo) throws EventException;

	/**
	 * AP CSR의 Evidence정보를 입력하기 위해 Vendor 정보 조회한다.
	 * @param String vndrSeq
	 * @return List<JooTaxVO>
	 * @throws EventException
	 */
	public List<JooTaxVO> searchVendorInfo(String vndrSeq) throws EventException;

	/**
	 * CSR List를 조회한다.
	 * @param SlipConditionVO slipConditionVO
	 * @return List<CsrSlipVO>
	 * @throws EventException
	 */
	public List<CsrSlipVO> searchSlipList(SlipConditionVO slipConditionVO) throws EventException;
	
	/**
	 * CSR의 Office code를 distinct로 조회한다.
	 * @param SlipConditionVO slipConditionVO
	 * @return List<SlipConditionVO>
	 * @throws EventException
	 */
	public List<SlipConditionVO> searchCsrOfcList(SlipConditionVO slipConditionVO) throws EventException;

	/**
	 * Combined 된 Settlement의 Lane List와 Settlement list를 동시에 조회한다. 
	 * @param CmbConditionVO cmbConditionVO
	 * @return CombinedGrpVO
	 * @throws EventException
	 */
	public CombinedGrpVO searchCombinedMonthlyClearanceList(CmbConditionVO cmbConditionVO) throws EventException;
	
	/**
	 * Combined 대상 Lane List를 조회한다.
	 * @param CmbConditionVO cmbConditionVO
	 * @return List<JooSettlementVO>
	 * @throws EventException
	 */
	public List<JooSettlementVO> searchCombinedRlaneList(CmbConditionVO cmbConditionVO) throws EventException;
	
	/**
	 * Combined Lane 을 multi 선택한 경우 선택된 Lane들의 Combined 대상 Settlement를 조회한다.
	 * @param CmbConditionVO cmbConditionVO
	 * @return List<CombinedVO>
	 * @throws EventException
	 */
	public List<CombinedVO> searchCombinedMonthlyClearanceByLaneList (CmbConditionVO cmbConditionVO) throws EventException;

	/**
	 * Combining 처리한다.
	 * @param CmbConditionVO cmbConditionVO
	 * @param CombinedVO[] combinedVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return int
	 * @throws EventException
	 */
	public int manageCombinedMonthlyClearance(CmbConditionVO cmbConditionVO, CombinedVO[] combinedVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * Combined 된 Settlement 정보를 취소한다.
	 * @param CmbConditionVO cmbConditionVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void removeCombinedMonthlyClearance(CmbConditionVO cmbConditionVO, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * AP CSR 정보를 조회한다.
	 * @param SlipProcessVO slipProcessVO
	 * @return List<SlipProcessVO>
	 * @throws EventException
	 */
	public List<SlipProcessVO> searchAPConsultation(SlipProcessVO slipProcessVO) throws EventException;

	/**
	 * AP CSR정보를 생성한다.
	 * - slp_ser_no 채번 (단건)
	 * - joo_stl_seq에 update 또는 insert (단건)
	 * - joo_stl_cmb에 csr no. update (단건)
	 * - joo_csr에 입력 (단건)
	 * - joo_slip에 입력 (DR n건)
	 * - joo_slip에 입력 (CR 단건)
	 * - joo_tax 에 입력
	 * - joo_tax_dtl 에 입력
	 * @param SlipProcessVO[] slipProcessVOs
	 * @param JooTaxVO[] jooTaxVOs
	 * @param JooTaxDtlVO[] jooTaxDtlVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
	 */
	public String createAPConsultation(SlipProcessVO[] slipProcessVOs, JooTaxVO[] jooTaxVOs, JooTaxDtlVO[] jooTaxDtlVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * CSR Creation 에서 Effective Date 입력시 해당 월의 마감여부를 조회한다.
	 * @param SlipProcessVO slipProcessVO
	 * @return SlipProcessVO
	 * @throws EventException
	 */
	public SlipProcessVO searchCloseYn(SlipProcessVO slipProcessVO) throws EventException;
	
	/**
	 * AR CSR을 생성한다.
	 * - slp_ser_no 채번 (단건)
	 * - joo_stl_seq에 update 또는 insert (단건)
	 * - joo_stl_cmb에 csr no. update (단건)
	 * - joo_csr에 입력 (단건)
	 * - joo_slip에 입력 (DR n건)
	 * - joo_slip에 입력 (CR n건)
	 * @param SlipProcessVO[] slipProcessVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
	 */
	public String createARConsultation(SlipProcessVO[] slipProcessVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * Reverse전표생성시 
	 * 1. JOO_STL_CMB.RVS_CMB_FLG = 'Y' UPDATE
	 * 2. JOO_STL_CMB_DTL, JOO_SLIP 조회
	 * 3. JOO_SLP_SEQ INSERT OR UPDATE (SLP_SER_NO 채번)
	 * 4. JOO_CSR INSERT
	 * 5. JOO_STL_CMB INSERT
	 * 6. JOO_STL_CMB_DTL INSERT
	 * 7. JOO_SLIP INSERT
	 * JOO_SETTLEMENT 의 CMB_CFM_FLG = 'N'으로 UPDATE하기 위해 JOO_STL_CMB_DTL LIST를 RETURN한다.
	 * @param CsrVO csrVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<JooStlCmbDtlVO>
	 * @throws EventException
	 */
	public List<JooStlCmbDtlVO> reverseConsultation(CsrVO csrVO, SignOnUserAccount signOnUserAccount) throws EventException;
 
    /**
     * AR정보중 Disabled된 VVD 정보를 조회합니다.<br>
     *
     * @param  ArDisabledVVDVO arDisabledVVDVO
     * @throws EventException
     * @return List<ArDisabledVVDVO>
     * @author jang kang cheol
     */
    public List<ArDisabledVVDVO> searchARDisabledVVD(ArDisabledVVDVO arDisabledVVDVO)  throws EventException;
    
    /**
     * 
     * AR정보를 조회합니다.<br>
     *
     * @param  ArDataInqVO arDataInqVO
     * @throws EventException
     * @return List<ArDataInqVO>
     * @author jang kang cheol
     */
    public List<ArDataInqVO> searchARDataInquiry(ArDataInqVO arDataInqVO ) throws EventException;

    /**
     * 
     * AR_total정보를 조회합니다.<br>
     *
     * @param  ArDataInqVO arDataInqVO
     * @throws EventException
     * @return List<ArDataInqVO>
     * @author jang kang cheol
     */
    public List<ArDataInqVO> searchARDataInquirySum(ArDataInqVO arDataInqVO ) throws EventException;
    
	/**
	 * AP I/F Error난 list를 조회한다.
	 * @param CsrVO csrVO
	 * @return List<ApIfErrVO>
	 * @throws EventException
	 */
	public List<ApIfErrVO> searchApIfErrList(CsrVO csrVO) throws EventException ;
 
	/**
	 * Reject전표생성시 
	 * 1. JOO_STL_CMB.RVS_CMB_FLG = 'Y' UPDATE
	 * 2. JOO_STL_CMB_DTL, JOO_SLIP 조회
	 * 3. JOO_SLP_SEQ INSERT OR UPDATE (SLP_SER_NO 채번)
	 * 4. JOO_CSR INSERT
	 * 5. JOO_STL_CMB INSERT
	 * 6. JOO_STL_CMB_DTL INSERT
	 * 7. JOO_SLIP INSERT
	 * JOO_SETTLEMENT 의 CMB_CFM_FLG = 'N'으로 UPDATE하기 위해 JOO_STL_CMB_DTL LIST를 RETURN한다.
	 * @param CsrVO csrVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<JooStlCmbDtlVO>
	 * @throws EventException
	 */
	public List<JooStlCmbDtlVO> rejectConsultation(CsrVO csrVO, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * Settlement되었는데 Combined 되지 않거나 Comined되었으나 CSR생성되지 않은 data를 조회한다.
	 * @param SlipConditionVO slipConditionVO
	 * @return List<LostCombinedDataVO>
	 * @throws EventException
	 */
	public List<LostCombinedDataVO> searchLostCombinedDataList(SlipConditionVO slipConditionVO) throws EventException;

	/**
	 * CSR의 Office code를 distinct로 조회한다.
	 * @param SlipConditionVO slipConditionVO
	 * @return List<SlipConditionVO>
	 * @throws EventException
	 */
	public List<SlipConditionVO> searchStlOfcList(SlipConditionVO slipConditionVO) throws EventException;

	/**
	 * CSR No.로 Approval 대상 CSR정보를 조회한다.
	 * FNS_JOO_0068 에서 사용한다. (Reverse가능, Approval Step과 무관하게 query)
	 * @param CsrVO csrVO
	 * @return List<CsrVO>
	 * @throws EventException
	 */
	public List<CsrVO> searchCsrDetail(CsrVO csrVO) throws EventException;

    /**
     * BackEndJob의 수행결과를 조회한다.
     * @param String key
     * @return String
     * @throws EventException
     */
	public String searchBakEndJobStatus(String key) throws EventException;
	
	/**
	 * GW문서를 저장한다( 수정)<br>
	 * 
	 * @param csrNo String
	 * @param updUsrId String 
	 * @param slipProcessVOs SlipProcessVO[]
	 * @exception EventException
	 */
	public void manageGW(String csrNo, String updUsrId, SlipProcessVO[] slipProcessVOs) throws EventException;	
	
	
	/**
	 * CSR No.로 GW Contract Link 목록 조회한다.<br>
	 * 
	 * @param String csrNo
	 * @return List<AgmtDocVO>
	 * @throws EventException
	 */
	public List<AgmtDocVO> searchGWDoc(String csrNo) throws EventException;	
	
	
	/**
	 * GW Contract Link 목록 정보를 저장한다.
	 *  
	 * @param String csrNo   
	 * @param AgmtDocVO[] agmtDocVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageGWDoc(String csrNo, AgmtDocVO[] agmtDocVOs, SignOnUserAccount signOnUserAccount) throws EventException;	
	
	/**
	 * 기 정산된 데이타가 존재하는 경우 Double Click시 History 조회한다
	 * 
	 * @param CmbConditionVO cmbConditionVO
	 * @return List<CombinedVO>
	 * @throws EventException
	 */
	public List<CombinedVO> searchCombinedDupList(CmbConditionVO cmbConditionVO) throws EventException;	
	
	/**
	 * CSR cancel 처리한다.
	 * @param CsrVO csrVO
	 * @throws EventException
	 */
	public void manageCsrCancel(CsrVO csrVO) throws EventException;
}