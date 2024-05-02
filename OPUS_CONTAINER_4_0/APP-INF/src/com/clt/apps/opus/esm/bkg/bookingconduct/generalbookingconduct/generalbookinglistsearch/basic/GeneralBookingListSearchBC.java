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
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgCoffTmListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListFor301310EdiInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListFor301310EdiVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBayPlanInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForCompFirmInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForCompFirmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForGeneralTmlEdiVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForTmlEdiInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForUsaTmlEdiVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForWorkWithBkgInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForWorkWithBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgReceiptListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.EmptyBkgListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.EmptyBkgListInqVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-GeneralBookingListSearch Business Logic Basic Command Interface<br>
 * - OPUS-GeneralBookingListSearch handling business transaction.<br>
 *
 * @author KimByungKyu 
 * @see Esm_bkg_0614EventResponse reference
 * @since J2EE 1.6
 */

public interface GeneralBookingListSearchBC {
	/**
	 *  Retrieving of Compulsory Firm Booking Info.<br>
	 *
	 * @author KimByungKyu
	 * @param BkgListForCompFirmInputVO bkgListForCompFirmInputVO
	 * @return List<BkgListForCompFirmVO>
	 * @exception EventException
	 */
	public List<BkgListForCompFirmVO> searchBkgListForCompFirm(BkgListForCompFirmInputVO bkgListForCompFirmInputVO) throws EventException;

	/**
	 *  Retrieving of Compulsory Firm Booking Info.<br>
	 *
	 * @author KimByungKyu
	 * @param BkgListForBayPlanInputVO bkgListForBayPlanInputVO
	 * @return List<BkgListForCompFirmVO>
	 * @exception EventException
	 */
	public List<BkgCoffTmListVO> searchBkgCoffTm(BkgListForBayPlanInputVO bkgListForBayPlanInputVO) throws EventException;

	/**
	 * retrieving list for Booking close / reopen<br>
	 *
	 * @param String pol
	 * @param String vvd
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	public List<BkgComboVO>searchBkgOfcListForBkgClz(String pol , String vvd )throws EventException;

	/**
	 * retrieving of Booking Office<br>
	 * 
	 * @param BkgListForWorkWithBkgInputVO bkgListForWorkWithBkgInputVO
	 * @return List<BkgListForWorkWithBkgVO>
	 * @exception EventException
	 */
	public List<BkgListForWorkWithBkgVO> searchBkgListForWorkWithBkg(BkgListForWorkWithBkgInputVO bkgListForWorkWithBkgInputVO) throws EventException;

	/**
	 * retrieving of Booking list.(ESM_BKG_0614)<br>
	 * 
	 * @param BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputVO
	 * @return BkgReceiptListVO
	 * @throws EventException
	 */
	public BkgReceiptListVO searchBkgListForBkgReceiptNtc(BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputVO) throws EventException;

	/**
	 * retrieving of booking receipt notice(ESM_BKG_0098)<br>
	 * 
	 * @param BkgListFor301310EdiInputVO bkgListFor301310EdiInputVO
	 * @param String msgTypeCd
	 * @return List<BkgListFor301310EdiVO>
	 * @throws EventException
	 */
	public List<BkgListFor301310EdiVO> searchBkgListFor301310Edi(BkgListFor301310EdiInputVO bkgListFor301310EdiInputVO, String msgTypeCd) throws EventException;
	
	/**
	 * retrieving of 301, 310 EDI Booking list(ESM_BKG_0702)<br>
	 * 
	 * @param EmptyBkgListInputVO emptyBkgListInputVO
	 * @return EmptyBkgListInqVO
	 * @throws EventException
	 */
	public EmptyBkgListInqVO searchEmptyBkgList(EmptyBkgListInputVO emptyBkgListInputVO) throws EventException;	

	/**
	 * retrieving of Empty REPO BKG Inquiry<br>
	 *
	 * @param 	BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO
	 * @return 	List<BkgListForGeneralTmlEdiVO>
	 * @exception  EventException
	 */
	public List<BkgListForGeneralTmlEdiVO> searchBkgListForGeneralTmlEdi(BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO) throws EventException;

	/**
	 * retrieving of Booking list.(ESM_BKG_0616)<br>
	 * 
	 * @param BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO
	 * @return List<BkgListForUsaTmlEdiVO>
	 * @throws EventException
	 */
	public List<BkgListForUsaTmlEdiVO> searchBkgListForUsaTmlEdi(BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO) throws EventException;

	/**
	 * retrieving of Booking list(ESM_BKG_0616)<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchUsrCntCd(SignOnUserAccount account) throws EventException;
	
	/**
	 * inserting remark and content into TRS_INTER_RMK(ESM_BKG_0098)<br>
	 * @param String bkgNo
	 * @param String btnTp
	 * @param SignOnUserAccount account
	 * @param String interRmkCtnt
	 * @throws EventException
	 */
	public void addInternalRemark(String bkgNo, String btnTp, SignOnUserAccount account, String interRmkCtnt) throws EventException;

}