/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInvoiceBC.java
*@FileTitle : Agreement Matching
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.basic;

import java.util.List;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableGRPVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSLessorAgmtMatchingINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSLessorAgmtMatchingMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSNuPoolChargeINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSNuPoolChargeMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSChargeCreationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSChargeCreationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSEstimateExpenseINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSEstimateExpenseMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceImportAuditINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceImportAuditMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceInquiryINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceInquiryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSLessorAgmtMatchingINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSLessorAgmtMatchingMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseMGTVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;

/**
 * OPUS-Chassismgsetagreementinvoice Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_cgm_1028EventResponse 
 * @since J2EE 1.4 
 */

public interface ChassisMgsetInvoiceBC {
	/**
	 * Retrieve agreement data matched to Lessor.(Chassis)[EES_CGM_1028]<br>
	 * 
	 * @param chsLessorAgmtMatchingINVO CHSLessorAgmtMatchingINVO
	 * @return List<CHSLessorAgmtMatchingMGTVO>
	 * @exception EventException
	 */
	public List<CHSLessorAgmtMatchingMGTVO> searchCHSLessorAgmtMatchingBasic(CHSLessorAgmtMatchingINVO chsLessorAgmtMatchingINVO) throws EventException;
	/**
	 * Save agreement data matched to Lessor.(Chassis)[EES_CGM_1028]<br>
	 * 
	 * @param chsLessorAgmtMatchingINVO CHSLessorAgmtMatchingINVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCHSLessorAgmtMatchingBasic (CHSLessorAgmtMatchingINVO[] chsLessorAgmtMatchingINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * After insert Agreement No., Checking whether data exists or not when Focus Out.(Chassis)[EES_CGM_1028]<br>
	 * 
	 * @param chsLessorAgmtMatchingINVO CHSLessorAgmtMatchingINVO
	 * @return CHSLessorAgmtMatchingMGTVO
	 * @exception EventException
	 */
	public CHSLessorAgmtMatchingMGTVO checkCHSAgmtBasic(CHSLessorAgmtMatchingINVO chsLessorAgmtMatchingINVO) throws EventException;
	
	/**
	 * Retrieve agreement data matched to Lessor.(M.G.Set)[EES_CGM_2086]<br>
	 * 
	 * @param mgsLessorAgmtMatchingINVO MGSLessorAgmtMatchingINVO
	 * @return List<MGSLessorAgmtMatchingMGTVO>
	 * @exception EventException
	 */
	public List<MGSLessorAgmtMatchingMGTVO> searchMGSLessorAgmtMatchingBasic(MGSLessorAgmtMatchingINVO mgsLessorAgmtMatchingINVO) throws EventException;
	/**
	 * Save agreement data matched to Lessor.(M.G.Set)[EES_CGM_2086]<br>
	 * 
	 * @param mgsLessorAgmtMatchingINVO MGSLessorAgmtMatchingINVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMGSLessorAgmtMatchingBasic (MGSLessorAgmtMatchingINVO[] mgsLessorAgmtMatchingINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * After insert Agreement No., Checking whether data exists or not when Focus Out.(M.G.Set)[EES_CGM_2086]<br>
	 * 
	 * @param mgsLessorAgmtMatchingINVO MGSLessorAgmtMatchingINVO
	 * @return MGSLessorAgmtMatchingMGTVO
	 * @exception EventException
	 */
	public MGSLessorAgmtMatchingMGTVO checkMGSAgmtBasic(MGSLessorAgmtMatchingINVO mgsLessorAgmtMatchingINVO) throws EventException;
	
	/**
	 * Retrieve saved Pool Charge list.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @return List<CHSCoPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSCoPoolChargeMGTVO> searchCHSCoPoolChargeListBasic(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws EventException;
	
	/**
	 * Retrieve initial Pool Charge list.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @return List<CHSCoPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSCoPoolChargeMGTVO> searchCHSCoPoolChargeInitBasic(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws EventException;
	
	/**
	 * Retrieve Co-Pool Charge Main information.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @return CHSCoPoolChargeMGTVO
	 * @exception EventException
	 */
	public CHSCoPoolChargeMGTVO searchCHSCoPoolChargeMainBasic(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws EventException;
	
	/**
	 * Retrieve saved Pool Charge details.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @return List<CHSCoPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSCoPoolChargeMGTVO> searchCHSCoPoolChargeDtlBasic(CHSCoPoolChargeINVO chsCoPoolChargeINVO) throws EventException;
	 
	/**
	 * Manage Co Pool Charge.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVOS CHSCoPoolChargeINVO[]
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSCoPoolChargeBasic (CHSCoPoolChargeINVO[] chsCoPoolChargeINVOS, CHSCoPoolChargeINVO chsCoPoolChargeINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Editing Co Pool Charge.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVOS CHSCoPoolChargeINVO[]
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCHSCoPoolChargeBasic (CHSCoPoolChargeINVO[] chsCoPoolChargeINVOS, CHSCoPoolChargeINVO chsCoPoolChargeINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Deleting saved Pool Charge information.(Chassis)[EES_CGM_1123]<br>
	 * 
	 * @param chsCoPoolChargeINVO CHSCoPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeCHSCoPoolChargeBasic (CHSCoPoolChargeINVO chsCoPoolChargeINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve Charge creation list on this month.(Chassis)[EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @return List<CHSChargeCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSChargeCreationMGTVO> searchCHSChargeCreationListBasic(CHSChargeCreationINVO chsChargeCreationINVO) throws EventException;
	
	/**
	 * Retrieve Charge Creation result value.(Chassis)[EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @return List<CHSChargeCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSChargeCreationMGTVO> searchCHSChargeCreationResultBasic(CHSChargeCreationINVO chsChargeCreationINVO) throws EventException;
	
	/**
	 *Create that month Charge of selected agreement this month.(Chassis)[EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVOS CHSChargeCreationINVO[]
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSChargeBasic (CHSChargeCreationINVO[] chsChargeCreationINVOS, 
					CHSChargeCreationINVO chsChargeCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Delete selected Charge.(Chassis)[EES_CGM_1029]<br>
	 * 
	 * @param chsChargeCreationINVOS CHSChargeCreationINVO[]
	 * @param chsChargeCreationINVO CHSChargeCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeCHSChargeBasic (CHSChargeCreationINVO[] chsChargeCreationINVOS, 
					CHSChargeCreationINVO chsChargeCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve Charge creation list on this month.(M.G.Set)[EES_CGM_2023]<br>
	 * 
	 * @param mgsChargeCreationINVO MGSChargeCreationINVO
	 * @return List<MGSChargeCreationMGTVO>
	 * @exception EventException
	 */
	public List<MGSChargeCreationMGTVO> searchMGSChargeCreationListBasic(MGSChargeCreationINVO mgsChargeCreationINVO) throws EventException;
	
	/**
	 * Retrieve Charge Creation result value.(M.G.Set)[EES_CGM_2023]<br>
	 * 
	 * @param mgsChargeCreationINVO MGSChargeCreationINVO
	 * @return List<MGSChargeCreationMGTVO>
	 * @exception EventException
	 */
	public List<MGSChargeCreationMGTVO> searchMGSChargeCreationResultBasic(MGSChargeCreationINVO mgsChargeCreationINVO) throws EventException;
	
	/**
	 * Create that month Charge of selected agreement that month.(M.G.Set)[EES_CGM_2023]<br>
	 * 
	 * @param mgsChargeCreationINVOS MGSChargeCreationINVO[]
	 * @param mgsChargeCreationINVO MGSChargeCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createMGSChargeBasic (MGSChargeCreationINVO[] mgsChargeCreationINVOS, 
					MGSChargeCreationINVO mgsChargeCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Delete selected Charge.(M.G.Set)[EES_CGM_2023]<br>
	 * 
	 * @param mgsChargeCreationINVOS MGSChargeCreationINVO[]
	 * @param mgsChargeCreationINVO MGSChargeCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeMGSChargeBasic (MGSChargeCreationINVO[] mgsChargeCreationINVOS, 
					MGSChargeCreationINVO mgsChargeCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve saved Pool Estimate Amount.  [EES_CGM_1125]<br>
	 * 
	 * @param poolEstmExpenseINVO PoolEstmExpenseINVO 
	 * @return List<PoolEstmExpenseMGTVO>
	 * @exception EventException
	 */
	public List<PoolEstmExpenseMGTVO> searchPoolEstimateAmtBasic(PoolEstmExpenseINVO poolEstmExpenseINVO) throws EventException;
	
	/**
	 * Save CGM_CHSS_POOL_EXPN_ESTM entity. Save .  [EES_CGM_1125]<br>
	 * 
	 * @param poolEstmExpenseMGTVOs PoolEstmExpenseMGTVO[] 
     * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void modifyPoolEstimateAmtBasic (PoolEstmExpenseMGTVO[] poolEstmExpenseMGTVOs , SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve Estimate amount by Year, Month, Pool List of Pool type. Retrieve .  [EES_CGM_1126]<br>
	 * 
	 * @param poolEstmExpenseINVO PoolEstmExpenseINVO 
	 * @return List<PoolEstmExpenseMGTVO>
	 * @exception EventException
	 */
	public List<PoolEstmExpenseMGTVO> searchPoolEstimateReportBasic(PoolEstmExpenseINVO poolEstmExpenseINVO) throws EventException;
	
	/**
	 * Action Verify by EQ unit Invoice draft data that loaded on page.(Chassis)[EES_CGM_1030]<br>
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
	 * Action Verify Insert by EQ unit Invoice draft data that loaded on page.(Chassis)[EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVOs CHSInvoiceImportAuditINVO[]
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void verifyCHSInvoiceDraftInsertBasic(CHSInvoiceImportAuditINVO[] cHSInvoiceImportAuditINVOs,
			CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO,SignOnUserAccount account) throws EventException;

	/**
	 * Action Verify Search by EQ unit Invoice draft data that loaded on page.(Chassis)[EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @return List<CHSInvoiceImportAuditMGTVO>
	 * @exception EventException
	 */
	public List<CHSInvoiceImportAuditMGTVO> verifyCHSInvoiceDraftSearchBasic(CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO) throws EventException;
	
	/**
	 * Action Verify Insert by EQ unit Invoice draft data that loaded on page.(M.G.Set)[EES_CGM_2085]<br>
	 * 
	 * @param mGSInvoiceImportAuditINVOs MGSInvoiceImportAuditINVO[]
	 * @param mGSInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void verifyMGSInvoiceDraftInsertBasic(MGSInvoiceImportAuditINVO[] mGSInvoiceImportAuditINVOs,
			MGSInvoiceImportAuditINVO mGSInvoiceImportAuditINVO,SignOnUserAccount account) throws EventException;

	/**
	 * Action Verify Search by EQ unit Invoice draft data that loaded on page.(M.G.Set)[EES_CGM_2085]<br>
	 * 
	 * @param mGSInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @return List<MGSInvoiceImportAuditMGTVO>
	 * @exception EventException
	 */
	public List<MGSInvoiceImportAuditMGTVO> verifyMGSInvoiceDraftSearchBasic(MGSInvoiceImportAuditINVO mGSInvoiceImportAuditINVO) throws EventException;
	
	/**
	 * Audit and Save invoice draft that loaded on Invoice import page.(Chssis)[EES_CGM_1030]<br>
	 * 
	 * @param cHSInvoiceImportAuditINVOs CHSInvoiceImportAuditINVO[]
	 * @param cHSInvoiceImportAuditINVO CHSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void auditCHSInvoiceDraftBasic(CHSInvoiceImportAuditINVO[] cHSInvoiceImportAuditINVOs, 
			CHSInvoiceImportAuditINVO cHSInvoiceImportAuditINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Audit and Save invoice draft that loaded on Invoice import page.(M.G.Set)[EES_CGM_2085]<br>
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
	 *  Audit and Save invoice draft that loaded on Invoice import page.(M.G.Set)[EES_CGM_2085]<br>
	 * 
	 * @param mGSInvoiceImportAuditINVOs MGSInvoiceImportAuditINVO[]
	 * @param mGSInvoiceImportAuditINVO MGSInvoiceImportAuditINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void auditMGSInvoiceDraftBasic(MGSInvoiceImportAuditINVO[] mGSInvoiceImportAuditINVOs, 
			MGSInvoiceImportAuditINVO mGSInvoiceImportAuditINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve Agreement Audit result that selected at Lease payable amount confirm page open. (Chassis)[EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO 
	 * @return CHSConfirmPayableGRPVO
	 * @exception EventException
	 */
	public CHSConfirmPayableGRPVO searchCHSInvoiceAuditResultBasic(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) throws EventException;
	
	/**
	 * Save Invoice Audit result status by Eq. (Chassis)[EES_CGM_1031]<br>
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
	 * Confirm handling cost by payable amount of page. (Chassis)[EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVOS CHSConfirmPayableAmountINVO[]
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void confirmCHSPayableAmountBasic(CHSConfirmPayableAmountINVO[] chsConfirmPayableAmountINVOS, 
			CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Cancel handling Confirmed cost by payable amount of page. (Chassis)[EES_CGM_1031]<br>
	 * 
	 * @param chsConfirmPayableAmountINVO CHSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelCHSPayableAmountBasic(CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve Agreement Audit result that selected at Lease payable amount confirm page open. (M.G.Set) [EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO 
	 * @return CHSConfirmPayableGRPVO
	 * @exception EventException
	 */
	public CHSConfirmPayableGRPVO searchMGSInvoiceAuditResultBasic(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) throws EventException;
	
	/**
	 * Save Invoice Audit result status by Eq. (M.G.Set)[EES_CGM_2098]<br>
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
	 * Confirm handling cost by payable amount of page. (M.G.Set)[EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVOS MGSConfirmPayableAmountINVO[]
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void confirmMGSPayableAmountBasic(MGSConfirmPayableAmountINVO[] mgsConfirmPayableAmountINVOS, 
			MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Cancel handling Confirmed cost by payable amount of page. (M.G.Set)[EES_CGM_2098]<br>
	 * 
	 * @param mgsConfirmPayableAmountINVO MGSConfirmPayableAmountINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelMGSPayableAmountBasic(MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Check handling about Invoice No.(Chassis)[EES_CGM_1123][EES_CGM_1124]<br>
	 * 
	 * @param invNo String
	 * @param chssMgstInvKndCd String
	 * @param costYrmon String
	 * @exception EventException 
	 */
	public void checkCHSInvoiceNoBasic(String invNo, String chssMgstInvKndCd, String costYrmon) throws EventException;
	
	/**
	 * Retrieve Neutral Pool Charge list.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @return List<CHSNuPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSNuPoolChargeMGTVO> searchCHSNuPoolChargeListBasic(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws EventException;
	
	/**
	 * Retrieve initial item of Neutral Pool Charge list.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @return List<CHSNuPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSNuPoolChargeMGTVO> searchCHSNuPoolChargeInitBasic(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws EventException;
	
	/**
	 * Retrieve main information of Neutral Pool Charge list.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @return CHSNuPoolChargeMGTVO
	 * @exception EventException
	 */
	public CHSNuPoolChargeMGTVO searchCHSNuPoolChargeMainBasic(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws EventException;
	
	/**
	 * Retrieve details of Neutral Pool Charge list.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @return List<CHSNuPoolChargeMGTVO>
	 * @exception EventException
	 */
	public List<CHSNuPoolChargeMGTVO> searchCHSNuPoolChargeDtlBasic(CHSNuPoolChargeINVO chsNuPoolChargeINVO) throws EventException;
	 
	/**
	 * Managing saved Neutral Charge.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVOS CHSNuPoolChargeINVO[]
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSNuPoolChargeBasic (CHSNuPoolChargeINVO[] chsNuPoolChargeINVOS, CHSNuPoolChargeINVO chsNuPoolChargeINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Editing saved Neutral Charge.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVOS CHSNuPoolChargeINVO[]
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCHSNuPoolChargeBasic (CHSNuPoolChargeINVO[] chsNuPoolChargeINVOS, CHSNuPoolChargeINVO chsNuPoolChargeINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Deleting saved Neutral Pool Charge information.(Chassis)[EES_CGM_1124]<br>
	 * 
	 * @param chsNuPoolChargeINVO CHSNuPoolChargeINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeCHSNuPoolChargeBasic (CHSNuPoolChargeINVO chsNuPoolChargeINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve Invoice List.(Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param SignOnUserAccount account
	 * @return List<CHSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSPayableInvoiceCreationMGTVO> searchCHSInvoiceListBasic (CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve detail of selected Invoice.(Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @return List<CHSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<CHSPayableInvoiceCreationMGTVO> searchCHSInvoiceDetailBasic (CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO) throws EventException;
	
	/**
	 * Creation invoice from contents of page (Issue date, effective date, receive date, revenue VVD, etc) (Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVOS CHSPayableInvoiceCreationINVO[]
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createCHSInvoiceBasic(CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS, 
			CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Cancel handling Confirmed Invoice to Charge Creation status. (Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVOS CHSPayableInvoiceCreationINVO[]
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelCHSInvoiceBasic(CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS, 
			CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve value that pushed to AP_INV_MAIN from Payable Invoice Creation. (Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO searchCHSInvoiceCreateMainBasic(CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve value that pushed to AP_INV_DTL from Payable Invoice Creation.(Chassis)[EES_CGM_1034]<br>
	 * 
	 * @param chsPayableInvoiceCreationINVO CHSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] searchCHSInvoiceCreateDetailBasic(CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve Invoice List. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @param SignOnUserAccount account
	 * @return List<MGSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<MGSPayableInvoiceCreationMGTVO> searchMGSInvoiceListBasic (MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve detail of selected Invoice. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @return List<MGSPayableInvoiceCreationMGTVO>
	 * @exception EventException
	 */
	public List<MGSPayableInvoiceCreationMGTVO> searchMGSInvoiceDetailBasic (MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO) throws EventException;
	
	/**
	 * Creation invoice from contents of page (Issue date, effective date, receive date, revenue VVD, etc) (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVOS MGSPayableInvoiceCreationINVO[]
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createMGSInvoiceBasic(MGSPayableInvoiceCreationINVO[] mgsPayableInvoiceCreationINVOS, 
			MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Cancel handling Confirmed Invoice to Charge Creation status. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVOS MGSPayableInvoiceCreationINVO[]
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelMGSInvoiceBasic(MGSPayableInvoiceCreationINVO[] mgsPayableInvoiceCreationINVOS, 
			MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve value that pushed to AP_INV_MAIN from Payable Invoice Creation. (M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO searchMGSInvoiceCreateMainBasic(MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve value that pushed to AP_INV_DTL from Payable Invoice Creation.(M.G.Set)[EES_CGM_2035]<br>
	 * 
	 * @param mgsPayableInvoiceCreationINVO MGSPayableInvoiceCreationINVO
	 * @param account SignOnUserAccount
	 * @return ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] searchMGSInvoiceCreateDetailBasic(MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve chassis Estimated settlement by month. [EES_CGM_1107]<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @return List<CHSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<CHSEstimateExpenseMGTVO> searchCHSEstimateExpenseBasic(CHSEstimateExpenseINVO cHSEstimateExpenseINVO) throws EventException;
	
	/**
	 * Calculate chassis Estimated settlement by month. [EES_CGM_1107]<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @return List<CHSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<CHSEstimateExpenseMGTVO> searchCHSEstimateExpenseCalcBasic(CHSEstimateExpenseINVO cHSEstimateExpenseINVO) throws EventException;
	
	/**
	 * Retrieve chassis Estimated settlement summary by month. [EES_CGM_1107]<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @return List<CHSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<CHSEstimateExpenseMGTVO> searchCHSEstimateExpenseSummaryBasic(CHSEstimateExpenseINVO cHSEstimateExpenseINVO) throws EventException;
	
	/**
	 * Handling chassis Estimated settlement by month. [EES_CGM_1107]<br>
	 * 
	 * @param cHSEstimateExpenseINVO CHSEstimateExpenseINVO
	 * @param cHSEstimateExpenseINVOs CHSEstimateExpenseINVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCHSEstimateExpenseCalcBasic(CHSEstimateExpenseINVO cHSEstimateExpenseINVO, CHSEstimateExpenseINVO[] cHSEstimateExpenseINVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve M.G. Set Estimated settlement by month. [EES_CGM_2206]<br>
	 * 
	 * @param mGSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @return List<MGSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<MGSEstimateExpenseMGTVO> searchMGSEstimateExpenseBasic(MGSEstimateExpenseINVO mGSEstimateExpenseINVO) throws EventException;
	
	/**
	 * Calculate  M.G. Set Estimated settlement by month. [EES_CGM_2206]<br>
	 * 
	 * @param mGSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @return List<MGSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<MGSEstimateExpenseMGTVO> searchMGSEstimateExpenseCalcBasic(MGSEstimateExpenseINVO mGSEstimateExpenseINVO) throws EventException;
	
	/**
	 * Retrieve M.G. Set Estimated settlement summary by month. [EES_CGM_2206]<br>
	 * 
	 * @param mGSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @return List<MGSEstimateExpenseMGTVO>
	 * @exception EventException
	 */
	public List<MGSEstimateExpenseMGTVO> searchMGSEstimateExpenseSummaryBasic(MGSEstimateExpenseINVO mGSEstimateExpenseINVO) throws EventException;	
	
	/**
	 * Handling M.G. Set Estimated settlement by month. [EES_CGM_2206]<br>
	 * 
	 * @param mGSEstimateExpenseINVO MGSEstimateExpenseINVO
	 * @param mGSEstimateExpenseINVOs MGSEstimateExpenseINVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMGSEstimateExpenseCalcBasic(MGSEstimateExpenseINVO mGSEstimateExpenseINVO, MGSEstimateExpenseINVO[] mGSEstimateExpenseINVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve invoice summary of chassis.(Chassis)[EES_CGM_1035]<br>
	 * 
	 * @param cHSInvoiceInquiryINVO CHSInvoiceInquiryINVO
	 * @return List<CHSInvoiceInquiryMGTVO>
	 * @exception EventException
	 */
	public List<CHSInvoiceInquiryMGTVO> searchCHSInvoiceInqListBasic (CHSInvoiceInquiryINVO cHSInvoiceInquiryINVO) throws EventException;
	
	/**
	 * Retrieve invoice detail data of chassis.(Chassis)[EES_CGM_1035]<br>
	 * 
	 * @param cHSInvoiceInquiryINVO CHSInvoiceInquiryINVO
	 * @return List<CHSInvoiceInquiryMGTVO>
	 * @exception EventException
	 */
	public List<CHSInvoiceInquiryMGTVO> searchCHSInvoiceInqDtlBasic (CHSInvoiceInquiryINVO cHSInvoiceInquiryINVO) throws EventException;
	
	/**
	 * Retrieve invoice summary of M.G.Set.(M.G.Set)[EES_CGM_2036]<br>
	 * 
	 * @param mGSInvoiceInquiryINVO MGSInvoiceInquiryINVO
	 * @return List<MGSInvoiceInquiryMGTVO>
	 * @exception EventException
	 */
	public List<MGSInvoiceInquiryMGTVO> searchMGSInvoiceInqListBasic (MGSInvoiceInquiryINVO mGSInvoiceInquiryINVO) throws EventException;
	
	/**
	 * Retrieve invoice detail data of M.G.Set.(M.G.Set)[EES_CGM_2036]<br>
	 * 
	 * @param mGSInvoiceInquiryINVO MGSInvoiceInquiryINVO
	 * @return List<MGSInvoiceInquiryMGTVO>
	 * @exception EventException
	 */
	public List<MGSInvoiceInquiryMGTVO> searchMGSInvoiceInqDtlBasic (MGSInvoiceInquiryINVO mGSInvoiceInquiryINVO) throws EventException;
	
}