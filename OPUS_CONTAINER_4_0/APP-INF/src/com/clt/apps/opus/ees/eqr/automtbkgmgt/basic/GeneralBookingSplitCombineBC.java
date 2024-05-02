/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSplitCombineBC.java
*@FileTitle : DG Split
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.15 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.automtbkgmgt.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.AkSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BbSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgForSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForCombineVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForMstBkgSelectVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CntrListForCombineVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByBkgInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByRouteInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineCommonInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.DgSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.RfSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.TroSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.ValidateCombineVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.VslSkdCngNoticeVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodSplitVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Generalbookingconduct Business Logic Command Interface<br>
 * - OPUS-Generalbookingconduct business logic Interface.<br>
 *
 * @author Choi Yeoung Hee
 * @see Esm_bkg_0709EventResponse reference
 * @since J2EE 1.6
 */

public interface GeneralBookingSplitCombineBC {
	/**
	 * when split dg cargo, reference data retrieve.<br>
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<DgSplitVO>
	 * @exception EventException
	 */
	public List<DgSplitVO> searchDgSplit(BkgBlNoVO bkgBlNoVO) throws EventException; 

	/**
	 * when split reefer cargo, reference data retrieve.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<RfSplitVO>
	 * @exception EventException
	 */
	public List<RfSplitVO> searchRfSplit(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * when split awkward cargo, reference data retrieve.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<AkSplitVO>
	 * @exception EventException
	 */
	public List<AkSplitVO> searchAkSplit(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * when split awkward cargo, reference data retrieve.<br>	
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<BbSplitVO>
	 * @exception EventException
	 */
	public List<BbSplitVO> searchBbSplit(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * when tro split, reference data retrieve.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<TroSplitVO>
	 * @exception EventException
	 */
	public List<TroSplitVO> searchTroSplit(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * when split in booking split screen, reference data retrieve.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  SignOnUserAccount account
	 * @return BkgForSplitVO
	 * @exception EventException
	 */
	public BkgForSplitVO searchBkgForSplit(BkgBlNoVO bkgBlNoVO,SignOnUserAccount account) throws EventException;

	/**
	 * Booking Split validate check
	 * 
	 * @param SplitBkgVO splitBkgVO
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception EventException
	 */
	public String validateSplit(SplitBkgVO splitBkgVO,BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * using changed VVD,POL, Booking retrieve.
	 * @author	Kim Byung Kyu
	 * @param 	List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs
	 * @exception 	EventException
	 */
	public void sendVslSkdCngNotice(List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs) throws EventException;

	/**
	 * BKG container list retrieve.(ESM_BKG_0732)
	 * @author	Jun Yong Jin
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return	List<CntrListForCombineVO>
	 * @exception 	EventException
	 */
	public List<CntrListForCombineVO> searchCntrListForCombine(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * Master Booking으로 Combine할 Booking List를 조회한다.(ESM_BKG_0974)
	 * @author	Jun Yong Jin
	 * @param 	BkgBlNoVO[] bkgBlNoVOs
	 * @return	List<BkgListForMstBkgSelectVO>
	 * @exception 	EventException
	 */
	public List<BkgListForMstBkgSelectVO> searchBkgListForMstBkgSelect(BkgBlNoVO[] bkgBlNoVOs) throws EventException;

	/**
	 * Combine Booking List retrieve.(ESM_BKG_0974)
	 * @author	Jun Yong Jin
	 * @param 	CombineCommonInputVO combineCommonInputVO
	 * @param 	CombineByRouteInputVO combineByRouteInputVO
	 * @return	List<BkgListForCombineVO>
	 * @exception 	EventException
	 */
	public List<BkgListForCombineVO> searchBkgListForCombineByRoute(CombineCommonInputVO combineCommonInputVO, CombineByRouteInputVO combineByRouteInputVO) throws EventException;

	/**
	 * Combine  Booking list retrieve. - by Route(ESM_BKG_0076)
	 * @author	Jun Yong Jin
	 * @param 	CombineCommonInputVO combineCommonInputVO
	 * @param 	CombineByBkgInputVO[] CombineByBkgInputVOs
	 * @return	List<BkgListForCombineVO>
	 * @exception 	EventException
	 */
	public List<BkgListForCombineVO> searchBkgListForCombineByBkg(CombineCommonInputVO combineCommonInputVO, CombineByBkgInputVO[] CombineByBkgInputVOs) throws EventException;

	/**
	 * Combine Booking Validate check. - by BKG(ESM_BKG_0076)
	 * @author	Jun Yong Jin
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return	ValidateCombineVO
	 * @exception 	EventException
	 */
	public ValidateCombineVO validateCombine(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	 
	/**
	 * Cod split retrieve<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @param  SignOnUserAccount account
	 * @return CodSplitVO 
	 * @exception EventException
	 */
	public CodSplitVO searchCodSplit(BkgBlNoVO bkgBlNoVO,String codRqstSeq,SignOnUserAccount account) throws EventException;
	
	/**
	 * Empty Booking Split no creation.
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param   SignOnUserAccount account
	 * @return 	BkgForSplitVO
	 * @exception 	EventException
	 */
	public BkgBlNoVO searchMtySplitBkgNo(BkgBlNoVO bkgBlNoVO,SignOnUserAccount account) throws EventException;

	/** 
	 * when split, route info retrieve.
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return 	String
	 * @exception 	EventException
	 */
	public String searchNewTsRoute(BkgBlNoVO bkgBlNoVO) throws EventException;	
	
	/**
	 * 
	 * @param bkgNo
	 * @param tagetBkgNo
	 * @param blSplitNo
	 * @throws EventException
	 */
	public void bkgXterRqstMstUpdate(String bkgNo, String tagetBkgNo, String blSplitNo) throws EventException;	
}