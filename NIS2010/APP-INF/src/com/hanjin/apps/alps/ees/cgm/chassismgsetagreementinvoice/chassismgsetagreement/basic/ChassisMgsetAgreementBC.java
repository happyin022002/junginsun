/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAgreementBC.java
*@FileTitle : Lease Agreement List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.19 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementGroupVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementListINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementListMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermChangeResultINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermChangeResultMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusGroupVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSCpsAgreementGroupVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSCpsAgreementINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSCpsAgreementMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementGroupVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementListINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementListMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermChangeResultINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermChangeResultMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusGroupVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusMGTVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Chassismgsetagreementinvoice Business Logic Command Interface<br>
 * - ALPS-Chassismgsetagreementinvoice에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM CHANG SIK
 * @see Ees_cgm_1021EventResponse 참조
 * @since J2EE 1.4
 */

public interface ChassisMgsetAgreementBC {

	/**
	 * 입력된 Office에 속한 현재까지 저장되어 있는 Chassis의 장비 임대 계약 Agreement list 를 조회한다. [EES_CGM_1021]<br>
	 * 
	 * @param chsAgreementListINVO CHSAgreementListINVO 
	 * @return List<CHSAgreementListMGTVO>
	 * @exception EventException
	 */
	public List<CHSAgreementListMGTVO> searchCHSAgreementListBasic(CHSAgreementListINVO chsAgreementListINVO) throws EventException;
	
	/**
	 * 입력된 Office에 속한 현재까지 저장되어 있는 M.G.Set의 장비 임대 계약 Agreement list 를 조회한다. [EES_CGM_2023]<br>
	 * 
	 * @param mgsAgreementListINVO MGSAgreementListINVO 
	 * @return List<MGSAgreementListMGTVO>
	 * @exception EventException
	 */
	public List<MGSAgreementListMGTVO> searchMGSAgreementListBasic(MGSAgreementListINVO mgsAgreementListINVO) throws EventException;
	
	/**
	 * 기존에 저장된 장비 임차 계약의 기본정보를 조회한다. [EES_CGM_1117]<br>
	 * 
	 * @param chsAgreementListINVO CHSAgreementListINVO 
	 * @return List<CHSAgreementListMGTVO>
	 * @exception EventException
	 */
	public List<CHSAgreementListMGTVO> searchCHSAgreementSelectionListBasic(CHSAgreementListINVO chsAgreementListINVO) throws EventException;
	
	/**
	 * 기존에 저장된 장비 임차 계약의 기본정보를 조회한다. [EES_CGM_2022]<br>
	 * 
	 * @param mgsAgreementListINVO MGSAgreementListINVO 
	 * @return List<MGSAgreementListMGTVO>
	 * @exception EventException
	 */
	public List<MGSAgreementListMGTVO> searchMGSAgreementSelectionListBasic(MGSAgreementListINVO mgsAgreementListINVO) throws EventException;
	
	/**
	 * agreement 기본정보 및 Type Size 별 Depreciation rate & initial rate, <br>
	 * Surcharge, Rental rate 등의 모든 정보를 조회한다. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @return CHSAgreementGroupVO
	 * @exception EventException
	 */
	public CHSAgreementGroupVO searchCHSAgreementAllBasic(CHSAgreementINVO chsAgreementINVO) throws EventException;
	
	/**
	 * 화면에서 입력된 내용대로 최초 Agreement 생성 및 기존의 Agreement 정보를 수정한다. [EES_CGM_1020]<br>
	 * 
	 * @param chsAgreementINVOs List<CHSAgreementINVO[]> 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @return CHSAgreementMGTVO
	 * @exception EventException
	 */
	public CHSAgreementMGTVO modifyCHSAgreementBasic(List<CHSAgreementINVO[]> chsAgreementINVOs, CHSAgreementINVO chsAgreementINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 선택된 Agreement 를 삭제 처리 한다. [EES_CGM_1020] <br>
	 * 
	 * @param chsAgreementINVO CHSAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void removeCHSAgreementBasic(CHSAgreementINVO chsAgreementINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * agreement 기본정보 및 Type Size 별 Depreciation rate & initial rate, <br>
	 * Surcharge, Rental rate 등의 모든 정보를 조회한다. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO 
	 * @return MGSAgreementGroupVO
	 * @exception EventException
	 */
	public MGSAgreementGroupVO searchMGSAgreementAllBasic(MGSAgreementINVO mgsAgreementINVO) throws EventException;
	
	/**
	 * 화면에서 입력된 내용대로 최초 Agreement 생성(UI_CGM_2021) 및 기존의 Agreement 정보를 수정한다. [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @return MGSAgreementMGTVO
	 * @exception EventException
	 */
	public MGSAgreementMGTVO modifyMGSAgreementBasic(MGSAgreementINVO mgsAgreementINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 선택된 Agreement 를 삭제 처리 한다 [EES_CGM_2021]<br>
	 * 
	 * @param mgsAgreementINVO MGSAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void removeMGSAgreementBasic(MGSAgreementINVO mgsAgreementINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 선택된 Agreement 에 해당하는 Term change 대상이 될  Chassis 를 조회한다. [EES_CGM_1026]<br>
	 * 
	 * @param chsTermStatusINVO CHSTermStatusINVO 
	 * @return List<CHSTermStatusMGTVO>
	 * @exception EventException
	 */
	public List<CHSTermStatusMGTVO> searchCHSTermChangeEqListBasic(CHSTermStatusINVO chsTermStatusINVO) throws EventException;
	
	/**
	 * Chassis의 마스터 정보를 조회한다. [EES_CGM_1026]<br>
	 * 
	 * @param chsTermStatusINVO CHSTermStatusINVO 
	 * @return CHSTermStatusGroupVO
	 * @exception EventException
	 */
	public CHSTermStatusGroupVO searchCHSEqMainBasic(CHSTermStatusINVO chsTermStatusINVO) throws EventException;
	
	/**
	 * 선택된 Agreement 에 해당하는 Term change 대상이 될  M.G.Set list 를 조회한다. [EES_CGM_2026]<br>
	 * 
	 * @param mgsTermStatusINVO MGSTermStatusINVO 
	 * @return List<MGSTermStatusMGTVO>
	 * @exception EventException
	 */
	public List<MGSTermStatusMGTVO> searchMGSTermChangeEqListBasic(MGSTermStatusINVO mgsTermStatusINVO) throws EventException;
	
	/**
	 * M.G.Set 의 마스터 정보를 조회한다. [EES_CGM_2026]<br>
	 * 
	 * @param mgsTermStatusINVO MGSTermStatusINVO 
	 * @return MGSTermStatusGroupVO
	 * @exception EventException
	 */
	public MGSTermStatusGroupVO searchMGSEqMainBasic(MGSTermStatusINVO mgsTermStatusINVO) throws EventException;
	
	/**
	 * Term change 된 EQ 를 대상으로 EQ 카운트를 Summary 하여 보여준다. [EES_CGM_1118]<br>
	 * 
	 * @param chsTermChangeResultINVO CHSTermChangeResultINVO 
	 * @return List<CHSTermChangeResultMGTVO>
	 * @exception EventException
	 */
	public List<CHSTermChangeResultMGTVO> searchCHSTermChangeResultSmryBasic(CHSTermChangeResultINVO chsTermChangeResultINVO) throws EventException;
	
	/**
	 * Term change 된 EQ 를 대상으로 EQ 카운트를 Summary 하여 보여준다. [EES_CGM_2028]<br>
	 *  
	 * @param mgsTermChangeResultINVO MGSTermChangeResultINVO 
	 * @return List<MGSTermChangeResultMGTVO>
	 * @exception EventException
	 */
	public List<MGSTermChangeResultMGTVO> searchMGSTermChangeResultSmryBasic(MGSTermChangeResultINVO mgsTermChangeResultINVO) throws EventException;
	
	/**
	 * CPS Agreement 기본정보 및 Rate, Condition 등의 모든 정보를 조회한다.(Chassis)<br>
	 * 
	 * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	 * @return CHSCpsAgreementGroupVO
	 * @exception EventException
	 */
	public CHSCpsAgreementGroupVO searchCHSCpsAgreementAllBasic(CHSCpsAgreementINVO chsCpsAgreementINVO) throws EventException;
	
	/**
	 * Tab2에서 입력된 Yard Code로부터 Yard Name과 Tab1의 SCC를 체크한다.<br>
	 * 
	 * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	 * @return CHSCpsAgreementMGTVO
	 * @exception EventException
	 */
	public CHSCpsAgreementMGTVO checkCHSCpsAgreementYardBasic(CHSCpsAgreementINVO chsCpsAgreementINVO) throws EventException;
	
	/**
	 * 화면에서 입력된 내용대로 최초 NP(ZP) Agreement 생성 및 기존의 NP(ZP) Agreement 정보를 수정한다. [EES_CGM_1202]<br>
	 * 
	 * @param chsCpsAgreementINVOs List<CHSCpsAgreementINVO[]>
	 * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @return CHSCpsAgreementMGTVO
	 * @exception EventException
	 */
	public CHSCpsAgreementMGTVO modifyCHSCpsAgreementBasic(List<CHSCpsAgreementINVO[]> chsCpsAgreementINVOs, CHSCpsAgreementINVO chsCpsAgreementINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 선택된 NP(ZP) Agreement 를 삭제 처리 한다. [EES_CGM_1202] <br>
	 * 
	 * @param chsCpsAgreementINVO CHSCpsAgreementINVO 
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void removeCHSCpsAgreementBasic(CHSCpsAgreementINVO chsCpsAgreementINVO, SignOnUserAccount account) throws EventException;
}