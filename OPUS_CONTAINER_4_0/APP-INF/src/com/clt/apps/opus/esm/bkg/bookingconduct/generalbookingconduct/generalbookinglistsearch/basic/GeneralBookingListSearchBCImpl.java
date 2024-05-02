/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingListSearchBCImpl.java
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

import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration.GeneralBookingListSearchDBDAO;
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
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-GeneralBookingListSearch Business Logic Basic Command implementation<br>
 * - OPUS-GeneralBookingListSearchBC handling business transaction.<br>
 * 
 * @author KimByungKyu
 * @see ESM_BKG_0614EventResponse,GeneralBookingListSearchBC each DAO Class reference
 * @since J2EE 1.6
 */
public class GeneralBookingListSearchBCImpl extends BasicCommandSupport implements GeneralBookingListSearchBC {

	// Database Access Object
	private transient GeneralBookingListSearchDBDAO dbDao = null;

	/**
	 * Generating GeneralBookingListSearchBCImpl Object<br>
	 * Generating GeneralBookingListSearchDBDAO<br> 
	 */
	public GeneralBookingListSearchBCImpl() {
		dbDao = new GeneralBookingListSearchDBDAO();
	}
	/**
	 *  Retrieving of Compulsory Firm Booking Info.<br>
	 *
	 * @author KimByungKyu
	 * @param BkgListForCompFirmInputVO bkgListForCompFirmInputVO
	 * @return List<BkgListForCompFirmVO>
	 * @exception EventException
	 */
	public List<BkgListForCompFirmVO> searchBkgListForCompFirm(BkgListForCompFirmInputVO bkgListForCompFirmInputVO) throws EventException {
		try {
			return dbDao.searchBkgListForCompFirm(bkgListForCompFirmInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
		}
	}
	/**
	 * retrieving list for Booking close / reopen<br>
	 *
	 * @param BkgListForBayPlanInputVO bkgListForBayPlanInputVO
	 * @return List<BkgCoffTmListVO>
	 * @exception EventException
	 */
	public List<BkgCoffTmListVO> searchBkgCoffTm(BkgListForBayPlanInputVO bkgListForBayPlanInputVO) throws EventException {
		try {
			return dbDao.searchBkgCoffTm(bkgListForBayPlanInputVO);
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * retrieving of Booking Office<br>
	 * 
	 * @param String sPol
	 * @param String sVvd
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	public List<BkgComboVO> searchBkgOfcListForBkgClz(String sPol , String sVvd )throws EventException{
		try {
			return dbDao.searchBkgOfcListForBkgClz(sPol, sVvd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * retrieving of Booking list.(ESM_BKG_0614)<br>
	 * 
	 * @param BkgListForWorkWithBkgInputVO bkgListForWorkWithBkgInputVO
	 * @return List<BkgListForWorkWithBkgVO>
	 * @throws EventException
	 */
	public List<BkgListForWorkWithBkgVO> searchBkgListForWorkWithBkg(BkgListForWorkWithBkgInputVO bkgListForWorkWithBkgInputVO) throws EventException{
		try {
			return dbDao.searchBkgListForWorkWithBkg(bkgListForWorkWithBkgInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * retrieving of booking receipt notice(ESM_BKG_0098)<br>
	 * 
	 * @param BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputVO
	 * @return BkgReceiptListVO
	 * @throws EventException
	 */
	public BkgReceiptListVO searchBkgListForBkgReceiptNtc(BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputVO) throws EventException{
        BkgReceiptListVO bkgReceiptListVO = new BkgReceiptListVO();
        try {
        	bkgReceiptListVO.setBkgListForBkgReceiptVOs(dbDao.searchBkgListForBkgReceiptNtc(bkgListForBkgReceiptInputVO));
           	bkgReceiptListVO.setBkgListForBkgReceiptCntVOs(dbDao.searchBkgListForBkgReceiptNtcCnt(bkgListForBkgReceiptInputVO));
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return bkgReceiptListVO;
	}	

	/**
	 * retrieving of 301, 310 EDI Booking list(ESM_BKG_0702)<br>
	 * 
	 * @param BkgListFor301310EdiInputVO bkgListFor301310EdiInputVO
	 * @param String msgTypeCd
	 * @return List<BkgListFor301310EdiVO>
	 * @throws EventException
	 */
	public List<BkgListFor301310EdiVO> searchBkgListFor301310Edi(BkgListFor301310EdiInputVO bkgListFor301310EdiInputVO, String msgTypeCd) throws EventException{
		try {
			return dbDao.searchBkgListFor301310Edi(bkgListFor301310EdiInputVO, msgTypeCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * retrieving of Empty REPO BKG Inquiry<br>
	 *
	 * @param 	EmptyBkgListInputVO emptyBkgListInputVO
	 * @return 	EmptyBkgListInqVO
	 * @exception  EventException
	 */
	public EmptyBkgListInqVO searchEmptyBkgList(EmptyBkgListInputVO emptyBkgListInputVO) throws EventException{
		try {
			EmptyBkgListInqVO emptyBkgListInqVO = new EmptyBkgListInqVO();
			
			emptyBkgListInqVO.setEmptyBkgList(dbDao.searchEmptyBkgList(emptyBkgListInputVO));
			emptyBkgListInqVO.setEmptyCntrSumVO(dbDao.searchEmptyCntrSum(emptyBkgListInputVO));
			
			return emptyBkgListInqVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	

	/**
	 * retrieving of Booking list.(ESM_BKG_0616)<br>
	 * 
	 * @param BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO
	 * @return List<BkgListForGeneralTmlEdiVO>
	 * @throws EventException
	 */
	public List<BkgListForGeneralTmlEdiVO> searchBkgListForGeneralTmlEdi(BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO) throws EventException{
		try {
			return dbDao.searchBkgListForGeneralTmlEdi(bkgListForTmlEdiInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * retrieving of Booking list(ESM_BKG_0616)<br>
	 * 
	 * @param BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO
	 * @return List<BkgListForUsaTmlEdiVO>
	 * @throws EventException
	 */
	public List<BkgListForUsaTmlEdiVO> searchBkgListForUsaTmlEdi(BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO) throws EventException{
		try {
			return dbDao.searchBkgListForUsaTmlEdi(bkgListForTmlEdiInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * retrieving of Location Code(ESM_BKG_0616)<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchUsrCntCd(SignOnUserAccount account) throws EventException{
		try {
			return dbDao.searchUsrCntCd(account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * inserting remark and content into TRS_INTER_RMK(ESM_BKG_0098)<br>
	 * @param String bkgNo
	 * @param String btnTp
	 * @param SignOnUserAccount
	 * @param String interRmkCtnt
	 * @throws EventException
	 */
	public void addInternalRemark(String bkgNo,String btnTp, SignOnUserAccount account, String interRmkCtnt) throws EventException{
		try {
			dbDao.addInternalRemark(bkgNo, btnTp, account, interRmkCtnt);
		} catch (DAOException de){
			throw new EventException(new ErrorHandler("BKG40121", new String[] {de.getMessage().replaceAll("<\\|\\|>", ":")}).getMessage(), de);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
		
	}


}