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
* -------------------------------------------------------
* history
* 2011.06.15 김영철 [CHM-201111434-01] 전체 VVD 및 Location, Yard 비교 (Pre/Trunk/Post 순서대로 점검)
* 2011.06.28 김영철 [] hitchment 인 경우에는 전체 VVD 및 Location, Yard 비교 제외
* 2011.07.14 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.AkSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BbSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgForSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForCombineVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForMstBkgSelectVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CntrListForCombineVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByBkgInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByRouteInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineCommonInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.DgSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.RfSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.TroSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.ValidateCombineVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.VslSkdCngNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodSplitVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Generalbookingconduct Business Logic Command Interface<br>
 * - ALPS-Generalbookingconduct에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Choi Yeoung Hee
 * @see Esm_bkg_0709EventResponse 참조
 * @since J2EE 1.6
 */

public interface GeneralBookingSplitCombineBC {
	/**
	 * dg cargo split시 참고할 data를 조회한다.<br>
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<DgSplitVO>
	 * @exception EventException
	 */
	public List<DgSplitVO> searchDgSplit(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * reefer cargo split시 참고할 data를 조회한다.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<RfSplitVO>
	 * @exception EventException
	 */
	public List<RfSplitVO> searchRfSplit(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * awkward cargo split시 참고할 data를 조회한다.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<AkSplitVO>
	 * @exception EventException
	 */
	public List<AkSplitVO> searchAkSplit(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * break bulk cargo split시 참고할 data를 조회한다.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<BbSplitVO>
	 * @exception EventException
	 */
	public List<BbSplitVO> searchBbSplit(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * tro split시 참고할 data를 조회한다.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<TroSplitVO>
	 * @exception EventException
	 */
	public List<TroSplitVO> searchTroSplit(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * booking split 화면에서 split시 참고할 data를 조회한다.<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  SignOnUserAccount account
	 * @return BkgForSplitVO
	 * @exception EventException
	 */
	public BkgForSplitVO searchBkgForSplit(BkgBlNoVO bkgBlNoVO,SignOnUserAccount account) throws EventException;

	/**
	 * Booking Split validate체크
	 * 
	 * @param SplitBkgVO splitBkgVO
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception EventException
	 */
	public String validateSplit(SplitBkgVO splitBkgVO,BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * 변경된 VVD,POL로 기존에 생성되어 있는 Booking을 조회한다.
	 * @author	Kim Byung Kyu
	 * @param 	List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs
	 * @exception 	EventException
	 */
	public void sendVslSkdCngNotice(List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs) throws EventException;

	/**
	 * BKG의 컨테이너 목록을 조회한다.(ESM_BKG_0732)
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
	 * Combine할 Booking 목록을 조회한다. - by Route(ESM_BKG_0076)
	 * @author	Jun Yong Jin
	 * @param 	CombineCommonInputVO combineCommonInputVO
	 * @param 	CombineByRouteInputVO combineByRouteInputVO
	 * @return	List<BkgListForCombineVO>
	 * @exception 	EventException
	 */
	public List<BkgListForCombineVO> searchBkgListForCombineByRoute(CombineCommonInputVO combineCommonInputVO, CombineByRouteInputVO combineByRouteInputVO) throws EventException;

	/**
	 * Combine할 Booking 목록을 조회한다. - by BKG(ESM_BKG_0076)
	 * @author	Jun Yong Jin
	 * @param 	CombineCommonInputVO combineCommonInputVO
	 * @param 	CombineByBkgInputVO[] CombineByBkgInputVOs
	 * @return	List<BkgListForCombineVO>
	 * @exception 	EventException
	 */
	public List<BkgListForCombineVO> searchBkgListForCombineByBkg(CombineCommonInputVO combineCommonInputVO, CombineByBkgInputVO[] CombineByBkgInputVOs) throws EventException;

	/**
	 * Combine할 Booking의 Validate을 검사한다. - by BKG(ESM_BKG_0076)
	 * @author	Jun Yong Jin
	 * @param sourceBkg
	 * @param bkgBlNoVO
	 * @param hitchmentYn
	 * @return	ValidateCombineVO
	 * @exception EventException
	 */
	public ValidateCombineVO validateCombine(BkgBlNoVO[] sourceBkg, BkgBlNoVO bkgBlNoVO, String hitchmentYn) throws EventException;
	
	 
	/**
	 * Cod split를 조회한다<br>
	 * 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String codRqstSeq
	 * @param  SignOnUserAccount account
	 * @return CodSplitVO 
	 * @exception EventException
	 */
	public CodSplitVO searchCodSplit(BkgBlNoVO bkgBlNoVO,String codRqstSeq,SignOnUserAccount account) throws EventException;
	
	/**
	 * Empty Booking Split번호를 생성한다.
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param   SignOnUserAccount account
	 * @return 	BkgForSplitVO
	 * @exception 	EventException
	 */
	public BkgBlNoVO searchMtySplitBkgNo(BkgBlNoVO bkgBlNoVO,SignOnUserAccount account) throws EventException;

	/** 
	 * split시 변경된 route의 정보를 조회한다.
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return 	String
	 * @exception 	EventException
	 */
	public String searchNewTsRoute(BkgBlNoVO bkgBlNoVO) throws EventException;	
}