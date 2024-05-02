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
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration.GeneralBookingListSearchDBDAO;
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
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCoffTmVO;

/**
 * ALPS-GeneralBookingConduct Business Logic Basic Command implementation<br>
 * - ALPS-GeneralBookingConduct에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Byung Kyu
 * @see ESM_BKG_0102EventResponse,GeneralBookingListSearchBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class GeneralBookingListSearchBCImpl extends BasicCommandSupport implements GeneralBookingListSearchBC {

	// Database Access Object
	private transient GeneralBookingListSearchDBDAO dbDao = null;

	/**
	 * GeneralBookingListSearchBCImpl 객체 생성<br>
	 * GeneralBookingListSearchDBDAO를 생성한다.<br>
	 */
	public GeneralBookingListSearchBCImpl() {
		dbDao = new GeneralBookingListSearchDBDAO();
	}
	/**
	 *  Compulsory Firm 대상 Booking 정보를 조회한다.<br>
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
	 * Booking close / reopen하기 위한 list를 조회한다.<br>
	 *
	 * @param BkgListForBayPlanInputVO bkgListForBayPlanInputVO
	 * @param String subChk
	 * @return List<BkgCoffTmListVO>
	 * @exception EventException
	 */
	public List<BkgCoffTmListVO> searchBkgCoffTm(BkgListForBayPlanInputVO bkgListForBayPlanInputVO, String subChk) throws EventException {
		try {
			return dbDao.searchBkgCoffTm(bkgListForBayPlanInputVO, subChk);
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
    		throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Booking Close 화면에 drop down으로 보여질 Booking Office를 조회<br>
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
	 * Booking Close 화면에 Yard 및 drop down으로 보여질 calling seq 를 조회<br>
	 *
	 * @author	
	 * @param 	BkgCoffTmVO bkgCoffTmVO
	 * @return 	VslSkdVO
	 * @exception EventException
	 */
	 public VslSkdVO searchBkgCoffTmYd(BkgCoffTmVO bkgCoffTmVO) throws EventException{
		try {
			return dbDao.searchBkgCoffTmYd(bkgCoffTmVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	
	/**
	 * 작업을 진행할 Booking 리스트를 조회한다.(ESM_BKG_0614)<br>
	 * 
	 * @author Jun Yong Jin
	 * @param BkgListForWorkWithBkgInputVO bkgListForWorkWithBkgInputVO
	 * @return List<BkgListForWorkWithBkgVO>
	 * @throws EventException
	 */
	public List<BkgListForWorkWithBkgVO> searchBkgListForWorkWithBkg(BkgListForWorkWithBkgInputVO bkgListForWorkWithBkgInputVO) throws EventException{
		try {
			if(bkgListForWorkWithBkgInputVO.getBkgFromDt() != null
					&& bkgListForWorkWithBkgInputVO.getBkgFromDt().length() > 0
					&& bkgListForWorkWithBkgInputVO.getBkgFromDt().length() < 10){
				throw new EventException((String)new ErrorHandler("BKG06012", new String[]{bkgListForWorkWithBkgInputVO.getBkgFromDt()}).getMessage());
			}
			if(bkgListForWorkWithBkgInputVO.getBkgToDt() != null
					&& bkgListForWorkWithBkgInputVO.getBkgToDt().length() > 0
					&& bkgListForWorkWithBkgInputVO.getBkgToDt().length() < 10){
				throw new EventException((String)new ErrorHandler("BKG06012", new String[]{bkgListForWorkWithBkgInputVO.getBkgToDt()}).getMessage());
			}
			return dbDao.searchBkgListForWorkWithBkg(bkgListForWorkWithBkgInputVO);
		} catch (EventException ex){
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * booking receipt notice를 보낼 Booking 리스트를 조회한다.(ESM_BKG_0098)<br>
	 * 
	 * @author Jun Yong Jin
	 * @param BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputVO
	 * @return BkgReceiptListVO
	 * @throws EventException
	 */
	public BkgReceiptListVO searchBkgListForBkgReceiptNtc(BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputVO) throws EventException{
        BkgReceiptListVO bkgReceiptListVO = new BkgReceiptListVO();
        try {
			if(bkgListForBkgReceiptInputVO.getBkgFromDt() != null
					&& bkgListForBkgReceiptInputVO.getBkgFromDt().length() > 0
					&& bkgListForBkgReceiptInputVO.getBkgFromDt().length() < 10){
				throw new EventException((String)new ErrorHandler("BKG06012", new String[]{bkgListForBkgReceiptInputVO.getBkgFromDt()}).getMessage());
			}
			if(bkgListForBkgReceiptInputVO.getBkgToDt() != null
					&& bkgListForBkgReceiptInputVO.getBkgToDt().length() > 0
					&& bkgListForBkgReceiptInputVO.getBkgToDt().length() < 10){
				throw new EventException((String)new ErrorHandler("BKG06012", new String[]{bkgListForBkgReceiptInputVO.getBkgToDt()}).getMessage());
			}
        	bkgReceiptListVO.setBkgListForBkgReceiptVOs(dbDao.searchBkgListForBkgReceiptNtc(bkgListForBkgReceiptInputVO));
           	bkgReceiptListVO.setBkgListForBkgReceiptCntVOs(dbDao.searchBkgListForBkgReceiptNtcCnt(bkgListForBkgReceiptInputVO));
        } catch (EventException ex){
        	throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return bkgReceiptListVO;
	}

	/**
	 * 301, 310 EDI를 전송할 Booking 리스트를 조회한다.(ESM_BKG_0702)<br>
	 * 
	 * @author Jun Yong Jin
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
	 * Empty REPO BKG Inquiry 조회<br>
	 *
	 * @author 	KimByungKyu
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
	 * Empty REPO BKG Hanger Inquiry 조회<br>
	 *
	 * @author 	DYRYU
	 * @param 	EmptyBkgListInputVO emptyBkgListInputVO
	 * @return 	List<EmptyBkgHangerListVO>
	 * @exception 	EventException
	 */
	public List<EmptyBkgHangerListVO> searchEmptyBkgHangerList(EmptyBkgListInputVO emptyBkgListInputVO) throws EventException{
		try {
			return dbDao.searchEmptyBkgHangerList(emptyBkgListInputVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * 미주외 지역의 terminal edi를 보낼 Booking 리스트를 조회한다.(ESM_BKG_0616)<br>
	 * 
	 * @author Jun Yong Jin
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
	 * 미주 지역에서 terminal edi에 대한 송수신 이력과 전송대상 Booking 리스트를 조회한다.(ESM_BKG_0616)<br>
	 * 
	 * @author Jun Yong Jin
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
	 * 로그인 사용자의 Id로 Location Code를 조회한다.(ESM_BKG_0616)<br>
	 * 
	 * @author Jun Yong Jin
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
	 * Consignee, Notify Code의 정확도를 조회한다<br>
	 * 
	 * @author DaeYoung Ryu
	 * @param ArrNtcSearchVO arrNtcSearchVO
	 * @param SignOnUserAccount account
	 * @return List<CustCdValidationVO>
	 * @throws EventException
	 */
	public List<CustCdValidationVO> searchPreCheckForCodeAccuracyMatch(
			ArrNtcSearchVO arrNtcSearchVO, SignOnUserAccount account) throws EventException{
		try {
			if (arrNtcSearchVO.getPageNo() == null || arrNtcSearchVO.getPageNo().equals("") || 
					Integer.valueOf( arrNtcSearchVO.getPageNo()).intValue() == 0) {
				arrNtcSearchVO.setPageNo("1");
			}
			arrNtcSearchVO.setUsrId(account.getUsr_id());
			arrNtcSearchVO.setOfcCd(account.getOfc_cd());
			return dbDao.searchPreCheckForCodeAccuracyMatch(arrNtcSearchVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
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
			ArrNtcSearchVO arrNtcSearchVO, SignOnUserAccount account) throws EventException{
		try {
			if (arrNtcSearchVO.getPageNo() == null || arrNtcSearchVO.getPageNo().equals("") || 
					Integer.valueOf( arrNtcSearchVO.getPageNo()).intValue() == 0) {
				arrNtcSearchVO.setPageNo("1");
			}
			arrNtcSearchVO.setUsrId(account.getUsr_id());
			arrNtcSearchVO.setOfcCd(account.getOfc_cd());
			return dbDao.searchPreCheckForCodeAccuracyUnmatch(arrNtcSearchVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
}