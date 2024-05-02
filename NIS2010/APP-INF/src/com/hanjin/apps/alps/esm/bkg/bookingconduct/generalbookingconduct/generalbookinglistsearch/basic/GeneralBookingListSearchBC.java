/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingListSearchBC.java
*@FileTitle : Compulsory Firm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.26 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgCoffTmListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListFor301310EdiInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListFor301310EdiVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBayPlanInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForCompFirmInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForCompFirmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForGeneralTmlEdiVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForTmlEdiInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForUsaTmlEdiVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForWorkWithBkgInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForWorkWithBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgReceiptListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.EmptyBkgHangerListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.EmptyBkgListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.EmptyBkgListInqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdValidationVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCoffTmVO;

/**
 * ALPS-Generalbookingconduct Business Logic Command Interface<br>
 * - ALPS-Generalbookingconduct에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Byung Kyu
 * @see Esm_bkg_0102EventResponse 참조
 * @since J2EE 1.6
 */

public interface GeneralBookingListSearchBC {
	/**
	 * Compulsory Firm 대상 Booking 정보를 조회한다.<br>
	 *
	 * @param bkgListForCompFirmInputVO BkgListForCompFirmInputVO
	 * @return List<BkgListForCompFirmVO>
	 * @exception EventException
	 */
	public List<BkgListForCompFirmVO> searchBkgListForCompFirm(BkgListForCompFirmInputVO bkgListForCompFirmInputVO) throws EventException;

	/**
	 * Booking close / reopen하기 위한 list를 조회한다.<br>
	 *
	 * @param BkgListForBayPlanInputVO bkgListForBayPlanInputVO
	 * @param String subChk
	 * @return List<BkgCoffTmListVO>
	 * @exception EventException
	 */
	public List<BkgCoffTmListVO> searchBkgCoffTm(BkgListForBayPlanInputVO bkgListForBayPlanInputVO, String subChk) throws EventException;

	/**
	 * Booking Close 화면에 drop down으로 보여질 Booking Office를 조회<br>
	 * 
	 * @param String pol
	 * @param String vvd
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	public List<BkgComboVO>searchBkgOfcListForBkgClz(String pol , String vvd )throws EventException;

	/**
	 * Booking Close 화면에 Yard 및 drop down으로 보여질 calling seq 를 조회<br>
	 *
	 * @author	
	 * @param 	BkgCoffTmVO bkgCoffTmVO
	 * @return 	VslSkdVO
	 * @exception EventException
	 */
	 public VslSkdVO searchBkgCoffTmYd(BkgCoffTmVO bkgCoffTmVO) throws EventException;
	 
	/**
	 * 작업을 진행할 Booking 리스트를 조회한다.(ESM_BKG_0614)<br>
	 * 
	 * @author Jun Yong Jin
	 * @param BkgListForWorkWithBkgInputVO bkgListForWorkWithBkgInputVO
	 * @return List<BkgListForWorkWithBkgVO>
	 * @throws EventException
	 */
	public List<BkgListForWorkWithBkgVO> searchBkgListForWorkWithBkg(BkgListForWorkWithBkgInputVO bkgListForWorkWithBkgInputVO) throws EventException;

	/**
	 * booking receipt notice를 보낼 Booking 리스트를 조회한다.(ESM_BKG_0098)<br>
	 * 
	 * @author Jun Yong Jin
	 * @param BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputVO
	 * @return BkgReceiptListVO
	 * @throws EventException
	 */
	public BkgReceiptListVO searchBkgListForBkgReceiptNtc(BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputVO) throws EventException;

	/**
	 * 301, 310 EDI를 전송할 Booking 리스트를 조회한다.(ESM_BKG_0702)<br>
	 * 
	 * @author Jun Yong Jin
	 * @param BkgListFor301310EdiInputVO bkgListFor301310EdiInputVO
	 * @param String msgTypeCd
	 * @return List<BkgListFor301310EdiVO>
	 * @throws EventException
	 */
	public List<BkgListFor301310EdiVO> searchBkgListFor301310Edi(BkgListFor301310EdiInputVO bkgListFor301310EdiInputVO, String msgTypeCd) throws EventException;
	
	/**
	 * Empty REPO BKG Inquiry 조회<br>
	 *
	 * @author 		KimByungKyu
	 * @param 		EmptyBkgListInputVO emptyBkgListInputVO
	 * @return 		EmptyBkgListInqVO
	 * @exception 	EventException
	 */
	public EmptyBkgListInqVO searchEmptyBkgList(EmptyBkgListInputVO emptyBkgListInputVO) throws EventException;	

	/**
	 * 미주외 지역의 terminal edi를 보낼 Booking 리스트를 조회한다.(ESM_BKG_0616)<br>
	 * 
	 * @author Jun Yong Jin
	 * @param BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO
	 * @return List<BkgListForGeneralTmlEdiVO>
	 * @throws EventException
	 */
	public List<BkgListForGeneralTmlEdiVO> searchBkgListForGeneralTmlEdi(BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO) throws EventException;

	/**
	 * 미주 지역에서 terminal edi에 대한 송수신 이력과 전송대상 Booking 리스트를 조회한다.(ESM_BKG_0616)<br>
	 * 
	 * @author Jun Yong Jin
	 * @param BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO
	 * @return List<BkgListForUsaTmlEdiVO>
	 * @throws EventException
	 */
	public List<BkgListForUsaTmlEdiVO> searchBkgListForUsaTmlEdi(BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO) throws EventException;

	/**
	 * 로그인 사용자의 Id로 Location Code를 조회한다.(ESM_BKG_0616)<br>
	 *
	 * @author Jun Yong Jin
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws DAOException
	 */
	public String searchUsrCntCd(SignOnUserAccount account) throws EventException;

	/**
	 * Consignee, Notify Code의 정확도를 조회한다<br>
	 * 
	 * @author DaeYoung Ryu
	 * @param ArrNtcSearchVO arrNtcSearchVO
	 * @param SignOnUserAccount account
	 * @return List<CustCdValidationVO>
	 * @throws EventException
	 */
	public List<CustCdValidationVO> searchPreCheckForCodeAccuracyMatch(
			ArrNtcSearchVO arrNtcSearchVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Consignee, Notify Code의 정확도를 조회한다<br>
	 * 
	 * @author DaeYoung Ryu
	 * @param ArrNtcSearchVO arrNtcSearchVO
	 * @param SignOnUserAccount account
	 * @return List<CustCdValidationVO>
	 * @throws EventException
	 */
	public List<CustCdValidationVO> searchPreCheckForCodeAccuracyUnmatch(
			ArrNtcSearchVO arrNtcSearchVO, SignOnUserAccount account) throws EventException;

	 /**
	 * Empty REPO BKG Hanger Inquiry 조회<br>
	 *
	 * @author 	DYRYU
	 * @param 	EmptyBkgListInputVO emptyBkgListInputVO
	 * @return 	List<EmptyBkgHangerListVO>
	 * @exception 	EventException
	 */
	public List<EmptyBkgHangerListVO> searchEmptyBkgHangerList(EmptyBkgListInputVO emptyBkgListInputVO) throws EventException;

}