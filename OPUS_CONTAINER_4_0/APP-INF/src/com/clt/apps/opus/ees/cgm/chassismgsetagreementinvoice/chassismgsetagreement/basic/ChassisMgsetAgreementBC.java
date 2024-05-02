/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAgreementBC.java
*@FileTitle : Lease Agreement List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic;

import java.util.List;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementGroupVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementListINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementListMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermChangeResultINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermChangeResultMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusGroupVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementGroupVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementListINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementListMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermChangeResultINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermChangeResultMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusGroupVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusMGTVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Chassismgsetagreementinvoice Business Logic Command Interface<br>
 * - OPUS-Chassismgsetagreementinvoice Business Logic Interface<br>
 *
 * @author 
 * @see Ees_cgm_1021EventResponse reference
 * @since J2EE 1.4
 */

public interface ChassisMgsetAgreementBC {

	/**
	 * Retrieve Chassis Eq lease agreement list [EES_CGM_1021]<br>
	 * 
	 * @param chsAgreementListINVO CHSAgreementListINVO 
	 * @return List<CHSAgreementListMGTVO>
	 * @exception EventException
	 */
	public List<CHSAgreementListMGTVO> searchCHSAgreementListBasic(CHSAgreementListINVO chsAgreementListINVO) throws EventException;
	
	/**
	 * Retrieve M.G.Set Eq lease agreement list. [EES_CGM_2023]<br>
	 * 
	 * @param mgsAgreementListINVO MGSAgreementListINVO 
	 * @return List<MGSAgreementListMGTVO>
	 * @exception EventException
	 */
	public List<MGSAgreementListMGTVO> searchMGSAgreementListBasic(MGSAgreementListINVO mgsAgreementListINVO) throws EventException;
	
	/**
	 * Retrieve lease agreement info. [EES_CGM_1117]<br>
	 * 
	 * @param chsAgreementListINVO CHSAgreementListINVO 
	 * @return List<CHSAgreementListMGTVO>
	 * @exception EventException
	 */
	public List<CHSAgreementListMGTVO> searchCHSAgreementSelectionListBasic(CHSAgreementListINVO chsAgreementListINVO) throws EventException;
	
	/**
	 * Retrieve lease agreement info. [EES_CGM_2022]<br>
	 * 
	 * @param mgsAgreementListINVO MGSAgreementListINVO 
	 * @return List<MGSAgreementListMGTVO>
	 * @exception EventException
	 */
	public List<MGSAgreementListMGTVO> searchMGSAgreementSelectionListBasic(MGSAgreementListINVO mgsAgreementListINVO) throws EventException;
	
	/**
	 * agreement info and (by Type Size) Depreciation rate & initial rate, <br>
	 * Surcharge, Rental rate etc information retrieve. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @return CHSAgreementGroupVO
	 * @exception EventException
	 */
	public CHSAgreementGroupVO searchCHSAgreementAllBasic(CHSAgreementINVO chsAgreementINVO) throws EventException;
	
	/**
	 * New Agreement creation and existed Agreement information editing. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVOs List<CHSAgreementINVO[]> 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @return CHSAgreementMGTVO
	 * @exception EventException
	 */
	public CHSAgreementMGTVO modifyCHSAgreementBasic(List<CHSAgreementINVO[]> chsAgreementINVOs, CHSAgreementINVO chsAgreementINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * selected Agreement  deleting handling . [EES_CGM_1020] <br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void removeCHSAgreementBasic(CHSAgreementINVO chsAgreementINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * agreement info and (by Type Size) Depreciation rate & initial rate, <br>
	 * Surcharge, Rental rate etc information retrieve. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO 
	 * @return MGSAgreementGroupVO
	 * @exception EventException
	 */
	public MGSAgreementGroupVO searchMGSAgreementAllBasic(MGSAgreementINVO mgsAgreementINVO) throws EventException;
	
	/**
	 * Init Agreement creation(UI_CGM_2021) and existed Agreement information modification. [EES_CGM_2021]<br>
	 * 
	 * @param List<MGSAgreementINVO[]> mgsAgreementINVOs
	 * @param mgsAgreementINVO MGSAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @return MGSAgreementMGTVO
	 * @exception EventException
	 */
	public MGSAgreementMGTVO modifyMGSAgreementBasic(List<MGSAgreementINVO[]> mgsAgreementINVOs,MGSAgreementINVO mgsAgreementINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * selected Agreement  deleting handling  [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void removeMGSAgreementBasic(MGSAgreementINVO mgsAgreementINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * selected Agreement Term change Chassis  retrieve. [EES_CGM_1026]<br>
	 * 
	 * @param chsTermStatusINVO CHSTermStatusINVO 
	 * @return List<CHSTermStatusMGTVO>
	 * @exception EventException
	 */
	public List<CHSTermStatusMGTVO> searchCHSTermChangeEqListBasic(CHSTermStatusINVO chsTermStatusINVO) throws EventException;
	
	/**
	 * Chassis master information retrieve. [EES_CGM_1026]<br>
	 * 
	 * @param chsTermStatusINVO CHSTermStatusINVO 
	 * @return CHSTermStatusGroupVO
	 * @exception EventException
	 */
	public CHSTermStatusGroupVO searchCHSEqMainBasic(CHSTermStatusINVO chsTermStatusINVO) throws EventException;
	
	/**
	 * selected Agreement Term change M.G.Set list  retrieve. [EES_CGM_2026]<br>
	 * 
	 * @param mgsTermStatusINVO MGSTermStatusINVO 
	 * @return List<MGSTermStatusMGTVO>
	 * @exception EventException
	 */
	public List<MGSTermStatusMGTVO> searchMGSTermChangeEqListBasic(MGSTermStatusINVO mgsTermStatusINVO) throws EventException;
	
	/**
	 * M.G.Set master information retrieve. [EES_CGM_2026]<br>
	 * 
	 * @param mgsTermStatusINVO MGSTermStatusINVO 
	 * @return MGSTermStatusGroupVO
	 * @exception EventException
	 */
	public MGSTermStatusGroupVO searchMGSEqMainBasic(MGSTermStatusINVO mgsTermStatusINVO) throws EventException;
	
	/**
	 * Retrieve Summary of term changed Eq count. [EES_CGM_1118]<br>
	 * 
	 * @param chsTermChangeResultINVO CHSTermChangeResultINVO 
	 * @return List<CHSTermChangeResultMGTVO>
	 * @exception EventException
	 */
	public List<CHSTermChangeResultMGTVO> searchCHSTermChangeResultSmryBasic(CHSTermChangeResultINVO chsTermChangeResultINVO) throws EventException;
	
	/**
	 * Retrieve Summary of term changed Eq count. [EES_CGM_2028]<br>
	 *  
	 * @param mgsTermChangeResultINVO MGSTermChangeResultINVO 
	 * @return List<MGSTermChangeResultMGTVO>
	 * @exception EventException
	 */
	public List<MGSTermChangeResultMGTVO> searchMGSTermChangeResultSmryBasic(MGSTermChangeResultINVO mgsTermChangeResultINVO) throws EventException;
	
}