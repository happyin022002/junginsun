/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInvoiceBC.java
*@FileTitle : Agreement Matching
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.30
*@LastModifier : Chang Young Kim
*@LastVersion : 1.5
* 2009.04.29 김창식 1.0 Creation
*Change history :
* 2014.07.31 Modified by Chang Young Kim
* 2015.03.30 [CHM-201534562] 미주샷시 임차료(사용료) 추정 비용 로직 검토 의뢰 (EES_CGM_1107)
* 2015-04-02 Chang Young Kim
*  [CHM-201431711] COPS Charge Creation - Charge Audit Result & Payable Amount Confirm
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableGRPVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsAuditResultUpdateINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsAuditResultUpdateMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsConfirmPayableGRPVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsInvoiceAuditResultCmmtCrMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsPayableInvoiceCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsPayableInvoiceCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSLessorAgmtMatchingINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSLessorAgmtMatchingMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSNuPoolChargeINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSNuPoolChargeMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPoolSCCReportINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPoolSCCReportMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSSCNOReportINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSSCNOReportMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSScExceptionINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSChargeCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSChargeCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSEstimateExpenseINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSEstimateExpenseMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceImportAuditINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceImportAuditMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceInquiryINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceInquiryMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSLessorAgmtMatchingINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSLessorAgmtMatchingMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseMGTVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApPayInvDtlVO;
import com.hanjin.syscommon.common.table.ApPayInvVO;

/**
 * ALPS-Chassismgsetagreementinvoice Business Logic Command Interface<br>
 * - ALPS-Chassismgsetagreementinvoice에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM CHANG SIK
 * @see Ees_cgm_1028EventResponse 참조
 * @since J2EE 1.4 
 */

public interface ChassisMgsetInvoiceBC {
	/**
	 * Lessor 와 match 되는 agreement 정보를 조회한다.(Chassis)[EES_CGM_1028]<br>
	 * 
	 * @param chsLessorAgmtMatchingINVO CHSLessorAgmtMatchingINVO
	 * @return List<CHSLessorAgmtMatchingMGTVO>
	 * @exception EventException
	 */
	public List<CHSLessorAgmtMatchingMGTVO> searchCHSLessorAgmtMatchingBasic(CHSLessorAgmtMatchingINVO chsLessorAgmtMatchingINVO) throws EventException;
	/**
	 * Lessor 와 match 되는 agreement 정보를 저장한다.(Chassis)[EES_CGM_1028]<br>
	 * 
	 * @param chsLessorAgmtMatchingINVO CHSLessorAgmtMatchingINVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCHSLessorAgmtMatchingBasic (CHSLessorAgmtMatchingINVO[] chsLessorAgmtMatchingINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Agreement No 입력 후 Focus Out 시 기존에 등록된 Agreement No. 인지 체크한다.(Chassis)[EES_CGM_1028]<br>
	 * 
	 * @param chsLessorAgmtMatchingINVO CHSLessorAgmtMatchingINVO
	 * @return CHSLessorAgmtMatchingMGTVO
	 * @exception EventException
	 */
	public CHSLessorAgmtMatchingMGTVO checkCHSAgmtBasic(CHSLessorAgmtMatchingINVO chsLessorAgmtMatchingINVO) throws EventException;
	
	/**
	 * Lessor 와 match 되는 agreement 정보를 조회한다.(M.G.Set)[EES_CGM_2086]<br>
	 * 
	 * @param mgsLessorAgmtMatchingINVO MGSLessorAgmtMatchingINVO
	 * @return List<MGSLessorAgmtMatchingMGTVO>
	 * @exception EventException
	 */
	public List<MGSLessorAgmtMatchingMGTVO> searchMGSLessorAgmtMatchingBasic(MGSLessorAgmtMatchingINVO mgsLessorAgmtMatchingINVO) throws EventException;
	/**
	 * Lessor 와 match 되는 agreement 정보를 저장한다.(M.G.Set)[EES_CGM_2086]<br>
	 * 
	 * @param mgsLessorAgmtMatchingINVO MGSLessorAgmtMatchingINVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMGSLessorAgmtMatchingBasic (MGSLessorAgmtMatchingINVO[] mgsLessorAgmtMatchingINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Agreement No 입력 후 Focus Out 시 기존에 등록된 Agreement No. 인지 체크한다.(M.G.Set)[EES_CGM_2086]<br>
	 * 
	 * @param mgsLessorAgmtMatchingINVO MGSLessorAgmtMatchingINVO
	 * @return MGSLessorAgmtMatchingMGTVO
	 * @exception EventException
	 */
	public MGSLessorAgmtMatchingMGTVO checkMGSAgmtBasic(MGSLessorAgmtMatchingINVO mgsLessorAgmtMatchingINVO) throws EventException;
	
	/**
	 * 저장된 Pool Charge 목록을 조회한다.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @return List<CHSCoPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSCoPoolChargeMGTVO> searchCHSCoPoolChargeListBasic(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws EventException;
	
	/**
	 * Co-op Pool Charge 초기 항목을 조회한다.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @return List<CHSCoPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSCoPoolChargeMGTVO> searchCHSCoPoolChargeInitBasic(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws EventException;
	
	/**
	 * Co-Pool Charge Main 정보를 조회한다.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @return CHSCoPoolChargeMGTVO
	 * @exception EventException
	 */
	public CHSCoPoolChargeMGTVO searchCHSCoPoolChargeMainBasic(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws EventException;
	
	/**
	 * 저장된 Pool Charge 상세 내역을 조회한다.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @return List<CHSCoPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSCoPoolChargeMGTVO> searchCHSCoPoolChargeDtlBasic(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws EventException;
	 
	/**
	 * 입력된 Co Pool Charge 를 관리한다.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVOS CHSCoPoolChargeINVO[]
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSCoPoolChargeBasic (CHSCoPoolChargeINVO[] chsCoPoolChargeINVOS, CHSCoPoolChargeINVO chsCoPoolChargeINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 입력된 Co Pool Charge 를 수정한다.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVOS CHSCoPoolChargeINVO[]
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCHSCoPoolChargeBasic (CHSCoPoolChargeINVO[] chsCoPoolChargeINVOS, CHSCoPoolChargeINVO chsCoPoolChargeINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 기저장된 Pool Charge 정보를 삭제한다.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeCHSCoPoolChargeBasic (CHSCoPoolChargeINVO chsCoPoolChargeINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 해당월의 Charge 생성 리스트를 조회한다.(Chassis)[EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @return List<CHSChargeCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSChargeCreationMGTVO> searchCHSChargeCreationListBasic(CHSChargeCreationINVO chsChargeCreationINVO) throws EventException;
	
	/**
	 * Charge Creation 한 결과값을 조회한다.(Chassis)[EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @return List<CHSChargeCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSChargeCreationMGTVO> searchCHSChargeCreationResultBasic(CHSChargeCreationINVO chsChargeCreationINVO) throws EventException;
	
	/**
	 * 선택된 Agreement 에 대해, 해당 월의 Charge 를 생성한다.(Chassis)[EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVOS CHSChargeCreationINVO[]
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSChargeBasic (CHSChargeCreationINVO[] chsChargeCreationINVOS, 
					CHSChargeCreationINVO chsChargeCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 선택된 Charge 를 삭제한다.(Chassis)[EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVOS CHSChargeCreationINVO[]
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeCHSChargeBasic (CHSChargeCreationINVO[] chsChargeCreationINVOS, 
					CHSChargeCreationINVO chsChargeCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 해당월의 Charge 생성 리스트를 조회한다.(M.G.Set)[EES_CGM_2023]<br>
	 * 
	 * @param mgsChargeCreationINVO MGSChargeCreationINVO
	 * @return List<MGSChargeCreationMGTVO>
	 * @exception EventException
	 */
	public List<MGSChargeCreationMGTVO> searchMGSChargeCreationListBasic(MGSChargeCreationINVO mgsChargeCreationINVO) throws EventException;
	
	/**
	 * Charge Creation 한 결과값을 조회한다.(M.G.Set)[EES_CGM_2023]<br>
	 * 
	 * @param mgsChargeCreationINVO MGSChargeCreationINVO
	 * @return List<MGSChargeCreationMGTVO>
	 * @exception EventException
	 */
	public List<MGSChargeCreationMGTVO> searchMGSChargeCreationResultBasic(MGSChargeCreationINVO mgsChargeCreationINVO) throws EventException;
	
	/**
	 * 선택된 Agreement 에 대해, 해당 월의 Charge 를 생성한다.(M.G.Set)[EES_CGM_2023]<br>
	 * 
	 * @param mgsChargeCreationINVOS MGSChargeCreationINVO[]
	 * @param mgsChargeCreationINVO MGSChargeCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createMGSChargeBasic (MGSChargeCreationINVO[] mgsChargeCreationINVOS, 
					MGSChargeCreationINVO mgsChargeCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 선택된 Charge 를 삭제한다.(M.G.Set)[EES_CGM_2023]<br>
	 * 
	 * @param mgsChargeCreationINVOS MGSChargeCreationINVO[]
	 * @param mgsChargeCreationINVO MGSChargeCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeMGSChargeBasic (MGSChargeCreationINVO[] mgsChargeCreationINVOS, 
					MGSChargeCreationINVO mgsChargeCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 저장된 Pool Estimate Amount 를 조회한다. Retrieve .  [EES_CGM_1125]<br>
	 * 
	 * @param poolEstmExpenseINVO PoolEstmExpenseINVO 
	 * @return List<PoolEstmExpenseMGTVO>
	 * @exception EventException
	 */
	public List<PoolEstmExpenseMGTVO> searchPoolEstimateAmtBasic(PoolEstmExpenseINVO poolEstmExpenseINVO) throws EventException;
	
	/**
	 * CGM_CHSS_POOL_EXPN_ESTM 엔티티에 저장 . Save .  [EES_CGM_1125]<br>
	 * 
	 * @param poolEstmExpenseMGTVOs PoolEstmExpenseMGTVO[] 
     * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void modifyPoolEstimateAmtBasic (PoolEstmExpenseMGTVO[] poolEstmExpenseMGTVOs , SignOnUserAccount account) throws EventException;
	
	/**
	 * 입력된 년도, Pool TYPE 에 해당하는 Pool List 별, 월별 Estimate amount 를 조회하였다. Retrieve .  [EES_CGM_1126]<br>
	 * 
	 * @param poolEstmExpenseINVO PoolEstmExpenseINVO 
	 * @return List<PoolEstmExpenseMGTVO>
	 * @exception EventException
	 */
	public List<PoolEstmExpenseMGTVO> searchPoolEstimateReportBasic(PoolEstmExpenseINVO poolEstmExpenseINVO) throws EventException;
	
	/**
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify 수행한다.(Chassis)[EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVOs CHSInvoiceImportAuditINVO[]
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @return List<CHSInvoiceImportAuditMGTVO>
	 * @exception EventException
	 */
	public List<CHSInvoiceImportAuditMGTVO> verifyCHSInvoiceDraftBasic(CHSInvoiceImportAuditINVO[] cHSInvoiceImportAuditINVOs,
			CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify Insert수행한다.(Chassis)[EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVOs CHSInvoiceImportAuditINVO[]
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void verifyCHSInvoiceDraftInsertBasic(CHSInvoiceImportAuditINVO[] cHSInvoiceImportAuditINVOs,
			CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO,SignOnUserAccount account) throws EventException;

	/**
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify Search수행한다.(Chassis)[EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @return List<CHSInvoiceImportAuditMGTVO>
	 * @exception EventException
	 */
	public List<CHSInvoiceImportAuditMGTVO> verifyCHSInvoiceDraftSearchBasic(CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO) throws EventException;
	
	/**
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify Insert수행한다.(M.G.Set)[EES_CGM_2085]<br>
	 * 
	 * @param mGSInvoiceImportAuditINVOs MGSInvoiceImportAuditINVO[]
	 * @param mGSInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void verifyMGSInvoiceDraftInsertBasic(MGSInvoiceImportAuditINVO[] mGSInvoiceImportAuditINVOs,
			MGSInvoiceImportAuditINVO mGSInvoiceImportAuditINVO,SignOnUserAccount account) throws EventException;

	/**
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify Search수행한다.(M.G.Set)[EES_CGM_2085]<br>
	 * 
	 * @param mGSInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @return List<MGSInvoiceImportAuditMGTVO>
	 * @exception EventException
	 */
	public List<MGSInvoiceImportAuditMGTVO> verifyMGSInvoiceDraftSearchBasic(MGSInvoiceImportAuditINVO mGSInvoiceImportAuditINVO) throws EventException;
	
	/**
	 * Invoice import 화면에서 로드된 invoice draft 를 Audit 하고 저장한다.(Chssis)[EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVOs CHSInvoiceImportAuditINVO[]
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void auditCHSInvoiceDraftBasic(CHSInvoiceImportAuditINVO[] cHSInvoiceImportAuditINVOs, 
			CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 화면에 LOAD 된 Invoice draft 데이터를 EQ 단위로 Verify 수행한다.(M.G.Set)[EES_CGM_2085]<br>
	 * 
	 * @param mGSInvoiceImportAuditINVOs MGSInvoiceImportAuditINVO[]
	 * @param mGSInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @return List<MGSInvoiceImportAuditMGTVO>
	 * @exception EventException
	 */
	public List<MGSInvoiceImportAuditMGTVO> verifyMGSInvoiceDraftBasic(MGSInvoiceImportAuditINVO[] mGSInvoiceImportAuditINVOs,
			MGSInvoiceImportAuditINVO mGSInvoiceImportAuditINVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Invoice import 화면에서 로드된 invoice draft 를 Audit 하고 저장한다.(M.G.Set)[EES_CGM_2085]<br>
	 * 
	 * @param mGSInvoiceImportAuditINVOs MGSInvoiceImportAuditINVO[]
	 * @param mGSInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void auditMGSInvoiceDraftBasic(MGSInvoiceImportAuditINVO[] mGSInvoiceImportAuditINVOs, 
			MGSInvoiceImportAuditINVO mGSInvoiceImportAuditINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Lease payable amount confirm 화면에서 화면 open 시 선택된 Agreement Audit result 를 조회한다. (Chassis)[EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO 
	 * @return CHSConfirmPayableGRPVO
	 * @exception EventException
	 */
	public CHSConfirmPayableGRPVO searchCHSInvoiceAuditResultBasic(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws EventException;
	
	/**
	 * Eq 별 Invoice Audit result 상태를 저장한다. (Chassis)[EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVOs List<CHSConfirmPayableAmountINVO[]> 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @return List<CHSConfirmPayableAmountMGTVO>
	 * @exception EventException
	 */
	public List<CHSConfirmPayableAmountMGTVO> manageCHSInvoiceAuditResultBasic(List<CHSConfirmPayableAmountINVO[]> chsConfirmPayableAmountINVOs, 
			CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 화면의 Payable Amount 대로 비용 확정(confirm) 처리한다. (Chassis)[EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVOS CHSConfirmPayableAmountINVO[]
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void confirmCHSPayableAmountBasic(CHSConfirmPayableAmountINVO[] chsConfirmPayableAmountINVOS, 
			CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 화면의 Payable Amount 대로 비용 확정(cancel) 을 취소 처리한다. (Chassis)[EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelCHSPayableAmountBasic(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Lease payable amount confirm 화면에서 화면 open 시 선택된 Agreement Audit result 를 조회한다. (M.G.Set) [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO 
	 * @return CHSConfirmPayableGRPVO
	 * @exception EventException
	 */
	public CHSConfirmPayableGRPVO searchMGSInvoiceAuditResultBasic(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws EventException;
	
	/**
	 * Eq 별 Invoice Audit result 상태를 저장한다. (M.G.Set)[EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVOs List<MGSConfirmPayableAmountINVO[]> 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @return List<MGSConfirmPayableAmountMGTVO>
	 * @exception EventException
	 */
	public List<MGSConfirmPayableAmountMGTVO> manageMGSInvoiceAuditResultBasic(List<MGSConfirmPayableAmountINVO[]> mgsConfirmPayableAmountINVOs, 
			MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 화면의 Payable Amount 대로 비용 확정(confirm) 처리한다. (M.G.Set)[EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVOS MGSConfirmPayableAmountINVO[]
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void confirmMGSPayableAmountBasic(MGSConfirmPayableAmountINVO[] mgsConfirmPayableAmountINVOS, 
			MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 화면의 Payable Amount 대로 비용 확정(cancel) 취소 처리한다. (M.G.Set)[EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelMGSPayableAmountBasic(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Invoice No 에 대한 체크 처리한다.(Chassis)[EES_CGM_1123][EES_CGM_1124]<br>
	 * 
	 * @param invNo String
	 * @param chssMgstInvKndCd String
	 * @param costYrmon String
	 * @exception EventException 
	 */
	public void checkCHSInvoiceNoBasic(String invNo, String chssMgstInvKndCd, String costYrmon) throws EventException;
	
	/**
	 * 저장된 Neutral Pool Charge 목록을 조회한다.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @return List<CHSNuPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSNuPoolChargeMGTVO> searchCHSNuPoolChargeListBasic(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws EventException;
	
	/**
	 * Neutral Pool Charge 초기 항목을 조회한다.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @return List<CHSNuPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSNuPoolChargeMGTVO> searchCHSNuPoolChargeInitBasic(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws EventException;
	
	/**
	 * Neutral Charge Main 정보를 조회한다.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @return CHSNuPoolChargeMGTVO
	 * @exception EventException
	 */
	public CHSNuPoolChargeMGTVO searchCHSNuPoolChargeMainBasic(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws EventException;
	
	/**
	 * 저장된 Neutral Pool Charge 상세 내역을 조회한다.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @return List<CHSNuPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSNuPoolChargeMGTVO> searchCHSNuPoolChargeDtlBasic(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws EventException;
	 
	/**
	 * 입력된 Neutral Charge 를 관리한다.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVOS CHSNuPoolChargeINVO[]
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSNuPoolChargeBasic (CHSNuPoolChargeINVO[] chsNuPoolChargeINVOS, CHSNuPoolChargeINVO chsNuPoolChargeINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 입력된 Neutral Charge 를 수정한다.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVOS CHSNuPoolChargeINVO[]
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCHSNuPoolChargeBasic (CHSNuPoolChargeINVO[] chsNuPoolChargeINVOS, CHSNuPoolChargeINVO chsNuPoolChargeINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 기저장된 Neutral Pool Charge 정보를 삭제한다.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeCHSNuPoolChargeBasic (CHSNuPoolChargeINVO chsNuPoolChargeINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Invoice List 를 조회한다.(Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @return List<CHSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSPayableInvoiceCreationMGTVO> searchCHSInvoiceListBasic (CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO) throws EventException;
	
	/**
	 * 선택된 Invoice 에 속한 Detail 건들을 조회한다.(Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @return List<CHSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSPayableInvoiceCreationMGTVO> searchCHSInvoiceDetailBasic (CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO) throws EventException;
	
	/**
	 * Invoice Creation 화면에서 입력된 제반 사항(Issue date, effective date, receive date, revenue VVD 등) <br>
	 * 내용으로 Invoice 를 생성한다. (Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVOS CHSPayableInvoiceCreationINVO[]
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSInvoiceBasic(CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS, 
			CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Confirm 된 Invoice 를 Charge Creation 상태로 Cancel 처리한다. (Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVOS CHSPayableInvoiceCreationINVO[]
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelCHSInvoiceBasic(CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS, 
			CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Payable Invoice Creation 에서 AP_INV_MAIN 에 넘길 값을 조회한다. (Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO searchCHSInvoiceCreateMainBasic(CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Payable Invoice Creation 에서 AP_INV_DTL 에 넘길 값을 조회한다. (Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] searchCHSInvoiceCreateDetailBasic(CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Invoice List 를 조회한다. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @return List<MGSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<MGSPayableInvoiceCreationMGTVO> searchMGSInvoiceListBasic (MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO) throws EventException;
	
	/**
	 * 선택된 Invoice 에 속한 Detail 건들을 조회한다. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @return List<MGSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<MGSPayableInvoiceCreationMGTVO> searchMGSInvoiceDetailBasic (MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO) throws EventException;
	
	/**
	 * Invoice Creation 화면에서 입력된 제반 사항(Issue date, effective date, receive date, revenue VVD 등) <br>
	 * 내용으로 Invoice 를 생성한다. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVOS MGSPayableInvoiceCreationINVO[]
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createMGSInvoiceBasic(MGSPayableInvoiceCreationINVO[] mgsPayableInvoiceCreationINVOS, 
			MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Confirm 된 Invoice 를 Charge Creation 상태로 Cancel 처리한다. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVOS MGSPayableInvoiceCreationINVO[]
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelMGSInvoiceBasic(MGSPayableInvoiceCreationINVO[] mgsPayableInvoiceCreationINVOS, 
			MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Payable Invoice Creation 에서 AP_INV_MAIN 에 넘길 값을 조회한다. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO searchMGSInvoiceCreateMainBasic(MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Payable Invoice Creation 에서 AP_INV_DTL 에 넘길 값을 조회한다. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @return ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] searchMGSInvoiceCreateDetailBasic(MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 월별 Chassis 추정결산 조회. [EES_CGM_1107]<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @return List<CHSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<CHSEstimateExpenseMGTVO> searchCHSEstimateExpenseBasic(CHSEstimateExpenseINVO cHSEstimateExpenseINVO) throws EventException;
	
	/**
	 * 월별 Chassis 추정결산 산정. BackEndJob [EES_CGM_1107]<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String searchCHSEstimateExpenseCalcBasicBackEndJobStart(CHSEstimateExpenseINVO cHSEstimateExpenseINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 월별 Chassis 추정결산 Summary 조회. [EES_CGM_1107]<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @return List<CHSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<CHSEstimateExpenseMGTVO> searchCHSEstimateExpenseSummaryBasic(CHSEstimateExpenseINVO cHSEstimateExpenseINVO) throws EventException;
	
	/**
	 * 월별 Chassis 추정결산 처리. [EES_CGM_1107]<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @param cHSEstimateExpenseINVOs CHSEstimateExpenseINVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCHSEstimateExpenseCalcBasic(CHSEstimateExpenseINVO cHSEstimateExpenseINVO, CHSEstimateExpenseINVO[] cHSEstimateExpenseINVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * 월별 M.G. Set 추정결산 조회. [EES_CGM_2206]<br>
	 * 
	 * @param mGSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @return List<MGSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<MGSEstimateExpenseMGTVO> searchMGSEstimateExpenseBasic(MGSEstimateExpenseINVO mGSEstimateExpenseINVO) throws EventException;
	
	/**
	 * 월별 M.G. Set 추정결산 산정. [EES_CGM_2206]<br>
	 * 
	 * @param mGSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @return List<MGSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<MGSEstimateExpenseMGTVO> searchMGSEstimateExpenseCalcBasic(MGSEstimateExpenseINVO mGSEstimateExpenseINVO) throws EventException;
	
	/**
	 * 월별 M.G. Set 추정결산 Summary 조회. [EES_CGM_2206]<br>
	 * 
	 * @param mGSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @return List<MGSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<MGSEstimateExpenseMGTVO> searchMGSEstimateExpenseSummaryBasic(MGSEstimateExpenseINVO mGSEstimateExpenseINVO) throws EventException;	
	
	/**
	 * 월별 M.G. Set 추정결산 처리. [EES_CGM_2206]<br>
	 * 
	 * @param mGSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @param mGSEstimateExpenseINVOs MGSEstimateExpenseINVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMGSEstimateExpenseCalcBasic(MGSEstimateExpenseINVO mGSEstimateExpenseINVO, MGSEstimateExpenseINVO[] mGSEstimateExpenseINVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Chassis의 INVOICE를 Summary 하여 보여준다.(Chassis)[EES_CGM_1035]<br>
	 * 
	 * @param cHSInvoiceInquiryINVO CHSInvoiceInquiryINVO
	 * @return List<CHSInvoiceInquiryMGTVO>
	 * @exception EventException
	 */
	public List<CHSInvoiceInquiryMGTVO> searchCHSInvoiceInqListBasic (CHSInvoiceInquiryINVO cHSInvoiceInquiryINVO) throws EventException;
	
	/**
	 * Chassis의 INVOICE Detail 데이터를 보여준다.(Chassis)[EES_CGM_1035]<br>
	 * 
	 * @param cHSInvoiceInquiryINVO CHSInvoiceInquiryINVO
	 * @return List<CHSInvoiceInquiryMGTVO>
	 * @exception EventException
	 */
	public List<CHSInvoiceInquiryMGTVO> searchCHSInvoiceInqDtlBasic (CHSInvoiceInquiryINVO cHSInvoiceInquiryINVO) throws EventException;
	
	/**
	 * M.G.Set의 INVOICE를 Summary 하여 보여준다.(M.G.Set)[EES_CGM_2036]<br>
	 * 
	 * @param mGSInvoiceInquiryINVO MGSInvoiceInquiryINVO
	 * @return List<MGSInvoiceInquiryMGTVO>
	 * @exception EventException
	 */
	public List<MGSInvoiceInquiryMGTVO> searchMGSInvoiceInqListBasic (MGSInvoiceInquiryINVO mGSInvoiceInquiryINVO) throws EventException;
	
	/**
	 * M.G.Set의 INVOICE Detail 데이터를 보여준다.(M.G.Set)[EES_CGM_2036]<br>
	 * 
	 * @param mGSInvoiceInquiryINVO MGSInvoiceInquiryINVO
	 * @return List<MGSInvoiceInquiryMGTVO>
	 * @exception EventException
	 */
	public List<MGSInvoiceInquiryMGTVO> searchMGSInvoiceInqDtlBasic (MGSInvoiceInquiryINVO mGSInvoiceInquiryINVO) throws EventException;
	
	/**
	 * Cps Charge Creation 할 대상을 조회한다.(Chassis)[EES_CGM_1203]<br>
	 * 
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @return List<CHSChargeCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSChargeCreationMGTVO> searchCHSCpsChargeCreationListBasic(CHSChargeCreationINVO chsChargeCreationINVO) throws EventException;
	
	/**
	 * Charge Creation 한 결과값을 조회한다.(Cps Chassis)[EES_CGM_1203]<br>
	 * 
	 * @param chsChargeCreationINVO   CHSChargeCreationINVO
	 * @return List<CHSChargeCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSChargeCreationMGTVO> searchCHSCpsChargeCreationResultBasic(CHSChargeCreationINVO chsChargeCreationINVO) throws EventException;
	
	/**
	 * Invoice import 화면에서 로드된 invoice draft 를 Audit 하고 저장한다.(Chssis)[EES_CGM_1204]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVOs CHSInvoiceImportAuditINVO[]
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String auditCHSCpsInvoiceDraftBackEndJobStart (CHSInvoiceImportAuditINVO[] cHSInvoiceImportAuditINVOs, CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO, SignOnUserAccount account) throws EventException;

	/**
	 * Invoice import 화면에서 Usage/Rebill를 제외한 Invoice Type을 Save한다. : Only CGM_LSE_CHG_HDR (Chassis)[EES_CGM_1204]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void saveCHSCpsInvoiceDraft (CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * CPS payable amount confirm 화면에서 화면 open 시 선택된 Agreement Audit result 를 조회한다. (Chassis)  [EES_CGM_1205]<br>
	 * Invoice Type : Usage/Rebill[UNR], Repo(Migration)[MIG], Revenue Sharing[RSH], Cost Sharing[CSH]
	 * 
	 * @param CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO
	 * @return CHSCpsConfirmPayableGRPVO
	 * @exception EventException
	 */
	public CHSCpsConfirmPayableGRPVO searchCHSCpsInvoiceAuditResultBasic(CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO) throws EventException;

	/**
	 * CPS payable amount confirm 화면에서 화면 open 시 선택된 Agreement Audit result 를 조회한다.(Chassis) [EES_CGM_1205]<br>
	 * Invoice Type : Min Commitment[CMT], MH Credit[MCD]
	 * 
	 * @param String agmtOfcCtyCd
	 * @param String agmtSeq
	 * @param String agmtVerNo
	 * @param String costYrmon
	 * @param String costYrmonSeq 
	 * @return List<CHSCpsInvoiceAuditResultCmmtCrMGTVO>
	 * @exception EventException
	 */
	public List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> searchCHSCpsInvoiceAuditResultCmmtCrBasic(String agmtOfcCtyCd, String agmtSeq, String agmtVerNo, String costYrmon, String costYrmonSeq)  throws EventException;

	/**
	 * Eq 별 Invoice Audit result 상태를 저장한다. (Chassis)[EES_CGM_1205]<br>
	 * 
	 * @param List<CHSCpsPayableInvoiceCreationINVO[]> chsCpsPayableInvoiceCreationINVOs
	 * @param CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO
	 * @param SignOnUserAccount account
	 * @return List<CHSCpsPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSCpsPayableInvoiceCreationMGTVO> manageCHSCpsInvoiceAuditResultBasic(List<CHSCpsPayableInvoiceCreationINVO[]> chsCpsPayableInvoiceCreationINVOs, CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 화면의 Payable Amount 대로 비용 확정(confirm) 처리한다. (Chassis)[EES_CGM_1205]<br>
	 * 
	 * @param CHSCpsPayableInvoiceCreationINVO[] chsCpsPayableInvoiceCreationINVOs
	 * @param CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmCHSCpsPayableAmountBasic(CHSCpsPayableInvoiceCreationINVO[] chsCpsPayableInvoiceCreationINVOs, CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 화면의 Payable Amount 대로 비용 확정(confirm) 취소처리한다. (Chassis)[EES_CGM_1025]<br>
	 * 
	 * @param CHSCpsPayableInvoiceCreationINVO cHSCpsPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelCHSCpsPayableAmountBasic(CHSCpsPayableInvoiceCreationINVO cHSCpsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Min Commitment/MH Credit Tab의 내용을 저장한다.(Chassis)[EES_CGM_1205] <br>
	 * 
	 * @param CHSCpsInvoiceAuditResultCmmtCrMGTVO[] cHSCpsInvoiceAuditResultCmmtCrMGTVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCHSCpsInvoiceAuditResultCmmtCrBasic(CHSCpsInvoiceAuditResultCmmtCrMGTVO[] cHSCpsInvoiceAuditResultCmmtCrMGTVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * 선택된 Charge 를 삭제한다.(Chassis)[EES_CGM_1203]<br>
	 * 
	 * @param chsChargeCreationINVOS CHSChargeCreationINVO[]
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeCHSCpsChargeBasic (CHSChargeCreationINVO[] chsChargeCreationINVOS, CHSChargeCreationINVO chsChargeCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Invoice List 를 조회한다.(Chassis)[EES_CGM_1207]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @return List<CHSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSPayableInvoiceCreationMGTVO> searchCHSCpsInvoiceListBasic (CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO) throws EventException;
	
	/**
	 * 선택된 Invoice 에 속한 Detail 건들을 조회한다.(Chassis)[EES_CGM_1207]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @return List<CHSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSPayableInvoiceCreationMGTVO> searchCHSCpsInvoiceDetailBasic (CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO) throws EventException;
	
	/**
	 * Invoice Creation 화면에서 입력된 제반 사항(Issue date, effective date, receive date) <br>
	 * 내용으로 Invoice 를 생성한다. (Chassis)[EES_CGM_1207]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVOS CHSPayableInvoiceCreationINVO[]
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSCpsInvoiceBasic(CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS, CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Confirm 된 Invoice 를 Charge Creation 상태로 Cancel 처리한다. (Chassis)[EES_CGM_1207]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVOS CHSPayableInvoiceCreationINVO[]
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelCHSCpsInvoiceBasic(CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS, CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 현재일을 기준으로 -3월, 현재월 을 조회<br>
	 * 
	 * @return CHSPoolSCCReportINVO
	 * @exception EventException
	 */
	public CHSPoolSCCReportINVO searchDefaultMonthWeek() throws EventException;	
	
	/**
	 * 주어진 기간의 년월 목록을 조회<br>
	 * 
	 * @param CHSPoolSCCReportINVO chsPoolSCCReportINVO
	 * @return List<CHSPoolSCCReportMGTVO>
	 * @exception EventException
	 */
	public List<CHSPoolSCCReportMGTVO> searchMonthList(CHSPoolSCCReportINVO chsPoolSCCReportINVO) throws EventException;	
	
	/**
	 * Chassis Amount Pool단위 조회 <br>
	 * 
	 * @param CHSPoolSCCReportINVO chsPoolSCCReportINVO
	 * @return List<CHSPoolSCCReportMGTVO>
	 * @exception EventException
	 */
	public List<CHSPoolSCCReportMGTVO> searchCHSPoolReportBasic(CHSPoolSCCReportINVO chsPoolSCCReportINVO) throws EventException;	
	
	/**
	 * Chassis Amount S/C NO 단위 조회 <br>
	 * 
	 * @param CHSSCNOReportINVO chsSCNOReportINVO
	 * @return List<CHSSCNOReportMGTVO>
	 * @exception EventException
	 */
	public List<CHSSCNOReportMGTVO> searchCHSSCNOReportBasic(CHSSCNOReportINVO chsSCNOReportINVO) throws EventException;
	
	/**
	 * Chassis Exception Qinquiry list 조회 <br>
	 * 
	 * @param CHSScExceptionINVO cHSScExceptionINVO
	 * @return List<CHSScExceptionINVO>
	 * @exception EventException
	 */
	public List<CHSScExceptionINVO> searchCHSSCExceptionService(CHSScExceptionINVO cHSScExceptionINVO) throws EventException;	

	/**
	 * SCC정보를 체크합니다. <br>
	 *
	 * @param CHSScExceptionINVO cHSScExceptionINVO
	 * @return List<CHSScExceptionINVO>
	 * @exception EventException
	 */ 
	public List<CHSScExceptionINVO> searchVerifySccService(CHSScExceptionINVO cHSScExceptionINVO) throws EventException;
	
	/**
	 * SCNo.정보를 체크합니다. <br>
	 *
	 * @param CHSScExceptionINVO cHSScExceptionINVO
	 * @return List<CHSScExceptionINVO>
	 * @exception EventException
	 */ 
	public List<CHSScExceptionINVO> searchVerifyScNoService(CHSScExceptionINVO cHSScExceptionINVO) throws EventException;
	
	/**
	 * "CGM_LSE_INV_TMP"."CHG_CRE_SEQ"의 MAX Value를 전달.<br>
	 *
	 * @return int
	 * @exception EventException
	 */ 
	public int getMaxSeqAuditResultUpdate() throws EventException;
	
	/**
	 * 데이터를 CGM_LSE_INV_TMP에 insert. <br>
	 *
	 * @param CHSCpsAuditResultUpdateINVO[] cHSCpsAuditResultUpdateINVOS
	 * @param int maxSeq
	 * @param SignOnUserAccount account
	 * @return int insCnt
	 * @exception EventException
	 */ 
	public int insertAuditResultUpdate(CHSCpsAuditResultUpdateINVO[] cHSCpsAuditResultUpdateINVOS, int maxSeq, SignOnUserAccount account) throws EventException;
	
	/**
	 * CGM_LSE_INV_TMP에 insert된 데이터를 CGM_LSE_CHG_DTL와 비교 Check한 <br>
	 * 데이터 List를 조회 후 전달 <br>
	 *
	 * @param int maxSeq
	 * @param String costYrmon
	 * @param String costYrmonSeq
	 * @param String agmtOfcCtyCd
	 * @param String agmtSeq
	 * @param String agmtVerNo
	 * @return List<CHSCpsAuditResultUpdateMGTVO>
	 * @exception EventException
	 */ 
	public List<CHSCpsAuditResultUpdateMGTVO> checkAuditResultUpdate(int maxSeq, String costYrmon, String costYrmonSeq, String agmtOfcCtyCd, String agmtSeq, String agmtVerNo) throws EventException;
	
	/**
	 * 데이터를 CGM_LSE_CHG_DTL에 update. <br>
	 *
	 * @param CHSCpsAuditResultUpdateINVO[] cHSCpsAuditResultUpdateINVOS
	 * @param SignOnUserAccount account
	 * @return int insCnt
	 * @exception EventException
	 */ 
	public int updateAuditResultUpdate(CHSCpsAuditResultUpdateINVO[] cHSCpsAuditResultUpdateINVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * Invoice No 중복 체크 처리한다.(Chassis)[EES_CGM_1204]<br>
	 * 
	 * @param CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO
	 * @return long invCnt
	 * @exception EventException 
	 */
	public long checkCHSInvoiceNoDupBasic(CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO) throws EventException;
	
	/**
	 * MAS(MAS_DMDT_COST_RPT_BKG_DTL)에서 Pool Estimate Amount 를 조회한다. Calculation (BackEndJob) [EES_CGM_1225]<br>
	 * 
	 * @param poolEstmExpenseINVO PoolEstmExpenseINVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String searchZPPoolEstimateAmtFromMASBasicBackEndJobStart(PoolEstmExpenseINVO poolEstmExpenseINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 저장된 Pool Estimate Amount(ZP) 를 조회한다. Retrieve .  [EES_CGM_1225]<br>
	 * 
	 * @param poolEstmExpenseINVO PoolEstmExpenseINVO 
	 * @return List<PoolEstmExpenseMGTVO>
	 * @exception EventException
	 */
	public List<PoolEstmExpenseMGTVO> searchZPPoolEstimateAmtBasic(PoolEstmExpenseINVO poolEstmExpenseINVO) throws EventException;
	
	/**
	 * CGM_CHSS_POOL_EXPN_ESTM 엔티티에 저장 . Save .  [EES_CGM_1225]<br>
	 * 
	 * @param poolEstmExpenseMGTVOs PoolEstmExpenseMGTVO[] 
     * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void modifyZPPoolEstimateAmtBasic (PoolEstmExpenseMGTVO[] poolEstmExpenseMGTVOs , SignOnUserAccount account) throws EventException;
	

}