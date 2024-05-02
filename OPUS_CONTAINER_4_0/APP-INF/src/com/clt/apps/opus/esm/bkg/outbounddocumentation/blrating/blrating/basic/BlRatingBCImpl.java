/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingBCImpl.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MemoSplitMasterBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurPayerVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroCfmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroListForCfmVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration.BlRatingDBDAO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgModiOfcPrcVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgQtyOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BlKrWhfExptVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeRemarkVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtAmtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtBkgChgVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtBkgInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtBkgNoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtBkgQtyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtCustVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtQtyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.DocLocVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ExchangeRateVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateQtyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RfaInformInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RfaInformOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchFocByFreightListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRatingApplyDateVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTpbInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.TroRevenueVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCntrRtVO;
import com.clt.syscommon.common.table.BkgInvTaxIfVO;
import com.clt.syscommon.common.table.BkgRateVO;

/**
 * OPUS-BlRating Business Logic Basic Command implementation<br>
 * - OPUS-BlRating handling business logic<br>
 * 
 * @author
 * @see ESM_BKG_0945EventResponse,BlRatingBC Related DAO class
 * @since J2EE 1.6
 */
public class BlRatingBCImpl extends BasicCommandSupport implements BlRatingBC {

	// Database Access Object
	private transient BlRatingDBDAO dbDao = null;

	/**
	 * BlRatingBCImpl objects creation<br>
	 * BlRatingDBDAO creation<br>
	 */
	public BlRatingBCImpl() {
		dbDao = new BlRatingDBDAO();
	}
	
	/**
	 * Searching the Master Info of BKG_CHG_RT_HIS Data
	 * 
	 * @param RateInVO rateInVO
	 * @exception EventException
	 */
	public void autoRatingHistory(RateInVO rateInVO)  throws EventException{
		
		List<BkgChgRateVO> insertVoList = new ArrayList<BkgChgRateVO>();
		BkgChgRateVO[] bkgChgRateHisVOs = rateInVO.getBkgChgRateVOs();

		SignOnUserAccount account 	= rateInVO.getAccount();
		String bkgNo 				= rateInVO.getBkg_no();
		int cnt 					= bkgChgRateHisVOs.length;

		try {
			
			for (int i = 0; i < cnt; i++) {
				bkgChgRateHisVOs[i].setBkgNo(bkgNo);
				bkgChgRateHisVOs[i].setCreUsrId(account.getUsr_id());
				bkgChgRateHisVOs[i].setUpdUsrId(account.getUsr_id());
				insertVoList.add(bkgChgRateHisVOs[i]);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.autoRatingHistory(insertVoList, rateInVO.getCaflag());
			}
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}
	/**
	 * Modifying the Master Info of BKG_CHG_RT Data
	 * 
	 * @param RateMainInfoVO  rateMainInfoVO 
	 * @param String caflag
	 * @exception EventException
	 */
	public void modifyChgRateMaster(RateMainInfoVO rateMainInfoVO, String caflag) throws EventException {
		try {
			dbDao.modifyChgRateMaster(rateMainInfoVO, caflag);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Updating the Status after Audit in PRI<br>
	 * 
	 * @param String  bkgNo
	 * @param String  audSts
	 * @param SignOnUserAccount  account
	 * @param String  caFlg
	 * @exception EventException
	 */
	public void modifyAudSts(String bkgNo, String audSts, SignOnUserAccount account, String caFlg) throws EventException {
		try {
			dbDao.modifyAudSts(bkgNo, audSts, account.getUsr_id(), caFlg);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Updating the ctrtTpCd
	 * 
	 * @param String  bkgNo
	 * @param String  ctrtTpCd
	 * @param SignOnUserAccount  account
	 * @param String  caFlg
	 * @exception EventException
	 */
	public void modifyCtrtTpCd(String bkgNo, String ctrtTpCd, SignOnUserAccount account, String caFlg) throws EventException {
		try {
			dbDao.modifyCtrtTpCd(bkgNo, ctrtTpCd, account.getUsr_id(), caFlg);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}
	

	/**
	 * Updating the revAudDt after Audit in PRI<br>
	 * 
	 * @param String  bkgNo
	 * @param String  revAudDt
	 * @param SignOnUserAccount   account
	 * @exception EventException
	 */

	public void modifyAudDt(String bkgNo, String revAudDt, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyAudDt(bkgNo, revAudDt, account.getUsr_id());

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Insert to BKG_RATE for the CHG in TRO<br>
	 * 
	 * @param String  bkgNo
	 * @param String  caFlg
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */

	public void createRateForTro(String bkgNo, String caFlg, SignOnUserAccount account) throws EventException {
		try {
			dbDao.createRateForTro(bkgNo, caFlg, account.getUsr_id());
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Searching for Booking customer screen<br>
	 * ESM_BKG_0961 Booking customer Inquiry << Use Case UC-BKG-012:Rating Creation>>
	 * 
	 * @param PpdCctCustInVO  ppdCctCustInVO
	 * @return List<PpdCctCustOutVO>
	 * @exception EventException
	 */
	public List<PpdCctCustOutVO> searchPayerCode(PpdCctCustInVO ppdCctCustInVO) throws EventException {
		try {
			return dbDao.searchPayerCode(ppdCctCustInVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Searching the Freight & Charge_S/C Note<br>
	 * 
	 * @param ScNoteInVO  scNoteInVO
	 * @return List<ScNoteOutVO>
	 * @exception EventException
	 */
	public List<ScNoteOutVO> searchScNote(ScNoteInVO scNoteInVO) throws EventException {
		try {
			return dbDao.searchScNote(scNoteInVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Searching the Freight & Charge_Freight & Charge Remark<br>
	 * 
	 * @param String  bkg_no
	 * @param String ca_flg
	 * @return List<ChargeRemarkVO>
	 * @exception EventException
	 */
	public List<ChargeRemarkVO> searchChargeRemark(String bkg_no, String ca_flg) throws EventException {
		try {
			return dbDao.searchChargeRemark(bkg_no, ca_flg);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Searching the Freight & Charge_Freight & Charge Remark<br>
	 * 
	 * @param String  bkg_no
	 * @param String diff_rmk
	 * @param String inter_rmk
	 * @param String  user_id
	 * @param String ca_flg
	 * @exception EventException
	 */
	public void manageChargeRemark(String bkg_no, String diff_rmk, String inter_rmk, String user_id, String ca_flg) throws EventException {
		try {
			dbDao.manageChargeRemark(bkg_no, diff_rmk, inter_rmk, user_id, ca_flg);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Searching the Freight & Charge_BKG Q'TY Inquiry<br>
	 * 
	 * @param String  bkg_no
	 * @return List<BkgQtyOutVO>
	 * @exception EventException
	 */
	public List<BkgQtyOutVO> searchQtyForRate(String bkg_no) throws EventException {
		try {
			return dbDao.searchQtyForRate(bkg_no);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Searching the Freight & Charge_S/C Information<br>
	 * 
	 * @param ScInformInVO  scInformInVO
	 * @return ScInformOutVO
	 * @exception EventException
	 */
	public ScInformOutVO searchScInform(ScInformInVO scInformInVO) throws EventException {
		ScInformOutVO scInformOutVO = new ScInformOutVO();

		try {

			scInformOutVO.setScBkgInformVOs(dbDao.searchScBkgInform(scInformInVO));
			scInformOutVO.setScCustInformVOs(dbDao.searchScCustInform(scInformInVO));

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
		return scInformOutVO;
	}

	/**
	 * Searching the Freight & Charge_S/C Information<br>
	 * Searching the BKG Customer and S/C Customer in PRI
	 * 
	 * @param ScInformInVO  scInformInVO
	 * @return List<ScInformListVO>
	 * @exception EventException
	 */
	public List<ScInformListVO> searchScInformList(ScInformInVO scInformInVO) throws EventException {
		try {
			return dbDao.searchScInformList(scInformInVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Searching the TP/CGO/QTY<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<RateQtyVO>
	 * @exception EventException
	 */
	public List<RateQtyVO> searchRateQtyList(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchRateQtyList(bkgBlNoVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Searching the Freight & Charge_Taa Information<br>
	 * 
	 * @param TaaInformInVO  taaInformInVO
	 * @return TaaInformOutVO
	 * @exception EventException
	 */
	public TaaInformOutVO searchTaaInform(TaaInformInVO taaInformInVO) throws EventException {
		TaaInformOutVO taaInformOutVO = new TaaInformOutVO();

		try {

			taaInformOutVO.setTaaBkgInformVOs(dbDao.searchTaaBkgInform(taaInformInVO));
			taaInformOutVO.setTaaCustInformVOs(dbDao.searchTaaCustInform(taaInformInVO));

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
		return taaInformOutVO;
	}

	/**
	 * Searching the Freight & Charge_Taa Information<br>
	 * Searching the Taa Customer in BKG Customer and PRI
	 * 
	 * @param TaaInformInVO  taaInformInVO
	 * @return List<TaaInformListVO>
	 * @exception EventException
	 */
	public List<TaaInformListVO> searchTaaInformList(TaaInformInVO taaInformInVO) throws EventException {
		try {
			return dbDao.searchTaaInformList(taaInformInVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Searching the Freight & Charge_S/C Information in RFA<br>
	 * 
	 * @param RfaInformInVO  rfaInformInVO
	 * @return RfaInformOutVO
	 * @exception EventException
	 */
	public RfaInformOutVO searchRfaInform(RfaInformInVO rfaInformInVO) throws EventException {
		RfaInformOutVO rfaInformVO = new RfaInformOutVO();
		try {

			rfaInformVO.setRfaBkgInformVO(dbDao.searchRfaBkgInform(rfaInformInVO));
			rfaInformVO.setRfaCustInformVO(dbDao.searchRfaCustInform(rfaInformInVO));
			// rfaInformVO.setRfaInformListVOs(dbDao.searchRfaInformList(rfaInformInVO));

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
		return rfaInformVO;
	}

	/**
	 * Searching the Covered B/L No of Master BKG by BKG No.<br>
	 * 
	 * @param String   bkg_no
	 * @param String   bl_no
	 * @param String    caFlg
	 * @return List<CoveredBlListVO>
	 * @exception EventException
	 */
	public List<CoveredBlListVO> searchCoveredBl(String bkg_no, String bl_no,String caFlg) throws EventException {
		try {
			return dbDao.searchCoveredBl(bkg_no, bl_no, caFlg);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Updating the Master B/L of Covered B/L as Null<br>
	 * 
	 * Master B/L's POR(%s) is not match for Covered B/L's (%s) [BKG00811]
	 * Master B/L's DEL(%s) is not match for Covered B/L's (%s) [BKG00812]
	 * Master B/L's shipper(%s) is not match for Covered B/L's (%s) [BKG00813]
	 * Master B/L's first VVD(%s) is not match for Covered B/L's (%s)[BKG00814]
	 * Covered B/L No(%s) Canceled [BKG00815] X ==(PASS if it is NOT X) Covered B/L
	 * No(%s) Freight Code [OFT] exists [BKG00816] NULL != (PASS if it is NULL)
	 * 
	 * @param String bkg_no
	 * @param String master_bl_no
	 * @param CoveredBlListVO[] coveredBlListVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageCoveredBl(String bkg_no, String master_bl_no, CoveredBlListVO[] coveredBlListVOs, SignOnUserAccount account) throws EventException {

		String r_message = "";
		BookingUtil bookingUtil = new BookingUtil();

		try {

			log.debug("=============================================");
			log.debug(" [MASTER BL_NO]  BL_VALIDATION check ");
			log.debug("=============================================");

			for (int i = 0; i < coveredBlListVOs.length; i++) {
				String covered_bl_no = coveredBlListVOs[i].getBlNo();

				if ("D".equals(coveredBlListVOs[i].getIbflag())) continue;

				CoveredBlVO coveredBlVO = dbDao.searchMstCvrdInfo(master_bl_no, covered_bl_no);
				if (coveredBlVO == null) {
					// [%s] does not exist. Please check B/L No. again.
					throw new EventException((String) new ErrorHandler("BKG08062", new String[] { covered_bl_no }).getMessage());
				}
				if (!coveredBlVO.getMstPorCd().equals(coveredBlVO.getCoverPorCd()) || !coveredBlVO.getMstDelCd().equals(coveredBlVO.getCoverDelCd()) || !coveredBlVO.getMstVvd().equals(coveredBlVO.getCoverVvd()) 
						  //|| !coveredBlVO.getMstShipper().equals(coveredBlVO.getCoverShipper())
				) {
					// POR, DEL and first VVD should be the same. Please check
					// B/L number again.
					throw new EventException((String) new ErrorHandler("BKG08054").getMessage());
				} else if (coveredBlVO.getMstBkgSts().equals("X") || coveredBlVO.getCoverBkgSts().equals("X")) {
					// [%s] is cancelled booking. Please check B/L number again
					throw new EventException((String) new ErrorHandler("BKG08058", new String[] { covered_bl_no }).getMessage());
				}

			}

			log.debug("=============================================");
			log.debug(" [save]  BKG_RATE save");
			log.debug("=============================================");

			String userId = account.getUsr_id();

			BkgBlNoVO bkgBlNoVo = new BkgBlNoVO();
			bkgBlNoVo.setBkgNo(bkg_no);
			bkgBlNoVo.setCaUsrId(userId);
			bkgBlNoVo = bookingUtil.searchBkgBlNoVO(bkgBlNoVo);

			String caFlg = bkgBlNoVo.getCaFlg();

			log.debug("=============================================");
			log.debug(" [save]  MstCvrdInfo save  ");
			log.debug("=============================================");

			List<CoveredBlListVO> insertVoList = new ArrayList<CoveredBlListVO>();
			List<CoveredBlListVO> updateVoList = new ArrayList<CoveredBlListVO>();
			List<CoveredBlListVO> deletetVoList = new ArrayList<CoveredBlListVO>();
			List<CoveredBlListVO> masterVoList = new ArrayList<CoveredBlListVO>();

			String bl_no = null;
			for (int i = 0; i < coveredBlListVOs.length; i++) {
				// bl_no
				bl_no = coveredBlListVOs[i].getBlNo();
				
				if(bl_no == null)
					throw new EventException((String) new ErrorHandler("BKG00609").getMessage());
				
				
				if(bl_no!=null && !"".equals(bl_no)){
					if(bl_no.length()>=12){
						bl_no = bl_no.substring(0,12);
					}else if(bl_no.length()>=10){
						bl_no = bl_no.substring(0,10);
					}
				}
				
				// bl_no check
				String exist_bkg_no = bookingUtil.searchBkgNoByBlNo(bl_no);
				if (exist_bkg_no == null || exist_bkg_no.length() == 0) {
					r_message = r_message + (String) new ErrorHandler("BKG08062", new String[] { bl_no }).getMessage() + "\r";
					continue;
				}

				if (coveredBlListVOs[i].getIbflag().equals("U")) {
					// update as null the existing bl_no
					coveredBlListVOs[i].setBkgNo(exist_bkg_no);
					coveredBlListVOs[i].setBlCvrdTpCd("N");
					coveredBlListVOs[i].setMstCvrdBlNo("");
					coveredBlListVOs[i].setBlNo(coveredBlListVOs[i].getOldBlNo());
					coveredBlListVOs[i].setUserId(userId);
					updateVoList.add(coveredBlListVOs[i]);

					// set a new bl_no inputted by user
					coveredBlListVOs[i].setIbflag("I");
					coveredBlListVOs[i].setBlNo(bl_no);
				}

				if (coveredBlListVOs[i].getIbflag().equals("I")) {

					coveredBlListVOs[i].setBkgNo(exist_bkg_no);
					coveredBlListVOs[i].setBlCvrdTpCd("C");
					coveredBlListVOs[i].setMstCvrdBlNo(master_bl_no);
					coveredBlListVOs[i].setUserId(userId);
					insertVoList.add(coveredBlListVOs[i]);
				}

				if (coveredBlListVOs[i].getIbflag().equals("D")) {
					coveredBlListVOs[i].setBkgNo(exist_bkg_no);
					coveredBlListVOs[i].setBlCvrdTpCd("N");
					coveredBlListVOs[i].setMstCvrdBlNo("");
					coveredBlListVOs[i].setUserId(userId);
					coveredBlListVOs[i].setBlNo(coveredBlListVOs[i].getBlNo());
					deletetVoList.add(coveredBlListVOs[i]);
				}
			}
			int db_cnt = 0;
			if (deletetVoList.size() > 0) {
				db_cnt = dbDao.modifyCoveredBl(deletetVoList, caFlg);
			}
			if (insertVoList.size() > 0) {
				db_cnt = dbDao.modifyCoveredBl(insertVoList, caFlg);
			}
			if (updateVoList.size() > 0) {
				db_cnt = dbDao.modifyCoveredBl(updateVoList, caFlg);
			}

			log.debug("* db_cnt : " + db_cnt);

			CoveredBlListVO coveredBlListVO = new CoveredBlListVO();
			coveredBlListVO.setBkgNo(bookingUtil.searchBkgNoByBlNo(master_bl_no));
			coveredBlListVO.setBlCvrdTpCd("M");
			coveredBlListVO.setBlNo(master_bl_no);
			coveredBlListVO.setUserId(userId);
			masterVoList.add(coveredBlListVO);
			db_cnt = dbDao.modifyCoveredBl(masterVoList, caFlg);
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}

		return r_message;
	}

	/**
	 * Modifying the Master Info of BKG_CHG_RT Data
	 * 
	 * @param CoveredBlListVO coveredBlListVO
	 * @param String caflag
	 * @exception EventException
	 */
	public void modifyCoveredBl(CoveredBlListVO coveredBlListVO, String caflag) throws EventException {

		try {

			List<CoveredBlListVO> coveredBlListVOs = new ArrayList<CoveredBlListVO>();
			coveredBlListVOs.add(coveredBlListVO);
			dbDao.modifyCoveredBl(coveredBlListVOs, caflag);

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Searching the Exchange Rate<br>
	 * 
	 * @param String     bkg_no
	 * @return List<ExchangeRateVO>
	 * @exception EventException
	 */
	public List<ExchangeRateVO> searchXchRt(String bkg_no) throws EventException {
		try {
			return dbDao.searchXchRt(bkg_no);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Searching the Freight & Charge<br>
	 * 
	 * @param RateInVO    rateInVO
	 * @return RateOutVO
	 * @exception EventException
	 */
	public RateOutVO searchRate(RateInVO rateInVO) throws EventException {
		RateOutVO rateOutVO = new RateOutVO();
		BookingUtil bookingUtil = new BookingUtil();

		String bkg_no = rateInVO.getBkg_no();
		String bl_no = rateInVO.getBl_no();
		String caflag = null;

		try {

			log.debug(" ========== searchRate [C/A FLAG] ==========> ");
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkg_no);
			bkgBlNoVO.setBlNo(bl_no);
			bkgBlNoVO.setCaUsrId(rateInVO.getAccount().getUsr_id());
			BkgBlNoVO blvo = bookingUtil.searchBkgBlNoVO(bkgBlNoVO);
			if (blvo == null || blvo.getBkgNo() == null)
				return rateOutVO;

			// C/A FLAG (Default = N)
			caflag = blvo.getCaFlg();
			rateOutVO.setCaflag(caflag);

			log.debug(" ========== searchRate [BDR FLAG] ========== ");
			rateOutVO.setBdrflag(bookingUtil.searchBdrFlgByBkg(bkgBlNoVO));

			log.debug(" ========== searchRateMainInfo [Rate List] ========== ");
			rateOutVO.setRateMainInfoVOs(dbDao.searchRateMainInfo(bkg_no, caflag));
			rateOutVO.setRateEtcInfoVOs(dbDao.searchRateEtcInfo(bkg_no, caflag));

			rateOutVO.setRateCntrInfoVOs(dbDao.searchRateCntrInfo(bkg_no, caflag));

			// 1. charge list
			List<BkgChgRateVO> rBkgChgRates = dbDao.searchChgRate(bkg_no, caflag);
			rateOutVO.setBkgChgRateVOs(rBkgChgRates);

			// charge list
			rateOutVO.setRateEtcInfo1VOs(dbDao.searchRateEtcInfo1(bkg_no, caflag));
			
			StringBuffer rOfc_cd = new StringBuffer();
			// 2. NOT exist the charge list
			log.debug("@@@@@@@@@@@@@@@@@@@@@@@@"+rBkgChgRates.size());

				// Prepaid
				PpdCctCustInVO ppdCctCustInVO = new PpdCctCustInVO();
				ppdCctCustInVO.setBkgNo(bkg_no);
				ppdCctCustInVO.setCallType("PPD");
				List<PpdCctCustOutVO> pList = dbDao.searchPayerCode(ppdCctCustInVO);
				if (pList.size() > 0) {
					for (PpdCctCustOutVO ppdCctCustOutVO : pList) {

						rOfc_cd.append(ppdCctCustOutVO.getOfcCd());
						rOfc_cd.append("|");

						rOfc_cd.append(ppdCctCustOutVO.getCustCntCd());
						rOfc_cd.append("|");

						rOfc_cd.append(ppdCctCustOutVO.getCustSeq());
						rOfc_cd.append("|");
						break;
					}
				} else {
					rOfc_cd.append("|||");
				}

				// Collect
				ppdCctCustInVO.setCallType("CCT");
				List<PpdCctCustOutVO> cList = dbDao.searchPayerCode(ppdCctCustInVO);

				if (cList.size() > 0) {
					for (PpdCctCustOutVO ppdCctCustOutVO : cList) {

						rOfc_cd.append(ppdCctCustOutVO.getOfcCd());
						rOfc_cd.append("|");

						rOfc_cd.append(ppdCctCustOutVO.getCustCntCd());
						rOfc_cd.append("|");

						rOfc_cd.append(ppdCctCustOutVO.getCustSeq());
						break;
					}
				} else {
					rOfc_cd.append("||");
				}
			// init ofc_cd 
			rateOutVO.setROfc_cd(rOfc_cd.toString());
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00627", new String[] {}).getMessage(), ex);
		}

		return rateOutVO;
	}

	/**
	 * Modifying the multiple Master Info of BKG_CHG_RT Data
	 * 
	 * @param RateInVO    rateInVO
	 * @exception EventException
	 */
	public void manageRate(RateInVO rateInVO) throws EventException {

		BookingUtil bookingUtil = new BookingUtil();
		try {
			// 01. validation
			BkgChgRateVO[] bkgChgRateVOs = rateInVO.getBkgChgRateVOs();
			RateMainInfoVO[] rateMainInfoVOs = rateInVO.getRateMainInfoVOs();
			// RateMainInfoVO[] rateMainInfoVOs =rateInVO.getRateMainInfoVOs();
			SignOnUserAccount account = rateInVO.getAccount();
			String bkgNo = rateInVO.getBkg_no();
			String bl_no = rateInVO.getBl_no();
			String caflag = rateInVO.getCaflag();
			String autoRate = rateInVO.getAutoRate();
			String removeAll = rateInVO.getRemoveAll();
			String covered_bl = rateInVO.getCovered_bl();

			// Save only HIDE status if it is BDR
			BkgBlNoVO bkgBlNoVo = new BkgBlNoVO();
			bkgBlNoVo.setBkgNo(bkgNo);
			String bdrFlag = bookingUtil.searchBdrFlgByBkg(bkgBlNoVo);
			if ("Y".equalsIgnoreCase(bdrFlag) && "N".equalsIgnoreCase(caflag)) {
				if (bkgChgRateVOs == null)
					return;
				int cnt = bkgChgRateVOs.length;
				List<BkgChgRateVO> updateVoList = new ArrayList<BkgChgRateVO>();

				for (int i = 0; i < cnt; i++) {
					if (bkgChgRateVOs[i].getIbflag().equals("U")) {
						bkgChgRateVOs[i].setBkgNo(bkgNo);
						bkgChgRateVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(bkgChgRateVOs[i]);
					}
				}
				// UPDATE only
				if (updateVoList.size() > 0) {
					dbDao.modifyChgRate(updateVoList, caflag);
				}
				return;
			}

			// Check for c and m only
			String rt_bl_tp_cd = rateMainInfoVOs[0].getRtBlTpCd();
			if (rt_bl_tp_cd.equalsIgnoreCase("C")) {
				log.debug("=============================================");
				log.debug(" [VALIDATION BL_NO]  BL_VALIDATION check ");
				log.debug("=============================================");

				String master_bl_no = bl_no;
				String covered_bl_no = covered_bl;

				if (rt_bl_tp_cd.equalsIgnoreCase("C")) {
					master_bl_no = covered_bl;
					covered_bl_no = bl_no;
				}

				if (master_bl_no.equals(covered_bl_no)) {
					// Master B/L No. can't be used for covered B/L No. Please
					// check B/L No. again.
					throw new EventException((String) new ErrorHandler("BKG08060", new String[] { covered_bl_no }).getMessage());
				}
				// validation checked
				CoveredBlVO coveredBlVO = dbDao.searchMstCvrdInfo(master_bl_no, covered_bl_no);
				if (coveredBlVO == null) {
					// [%s] does not exist. Please check B/L No. again.
					throw new EventException((String) new ErrorHandler("BKG08062", new String[] { covered_bl_no }).getMessage());
				}
				if (!coveredBlVO.getMstPorCd().equals(coveredBlVO.getCoverPorCd()) || !coveredBlVO.getMstDelCd().equals(coveredBlVO.getCoverDelCd()) || !coveredBlVO.getMstVvd().equals(coveredBlVO.getCoverVvd()) 
						 //|| !coveredBlVO.getMstShipper().equals(coveredBlVO.getCoverShipper())
						) {
					// POR, DEL and first VVD should be the same. Please check
					// B/L number again.
					throw new EventException((String) new ErrorHandler("BKG08054").getMessage());
				} else if (coveredBlVO.getMstBkgSts().equals("X") || coveredBlVO.getCoverBkgSts().equals("X")) {
					// [%s] is cancelled booking. Please check B/L number again
					throw new EventException((String) new ErrorHandler("BKG08058", new String[] { covered_bl_no }).getMessage());
				}

			}

//SC before call searchTaxSurchargeList (by kimtaekyun 2016.03.30) 			
//			log.debug("=============================================");
//			log.debug(" [MainInfo]  Modify if retriev option changed ");
//			log.debug("=============================================");
//
//			// Session user_id setting
//			rateMainInfoVOs[0].setUserId(account.getUsr_id());
//
//			// Save changed ChgRateBkgRate
//			dbDao.modifyChgRateBkgRate(rateMainInfoVOs[0], caflag);

			
			// REMOVE ALL and SAVE if AUTO RATING 
			if ("Y".equals(autoRate)||"Y".equals(removeAll)) {
				log.debug("=============================================");
				log.debug(" REMOVE ALL and SAVE if AUTO RATING ");
				log.debug("=============================================");

				dbDao.removeChgRateAll(bkgNo, caflag);
			}
			
			log.debug("=============================================");
			log.debug(" [ChgRate] Modify CHARGE SHEET   " + caflag);
			log.debug("=============================================");

			if (bkgChgRateVOs != null) {
				int cnt = bkgChgRateVOs.length;
				// 02. biz logic
				List<BkgChgRateVO> insertVoList = new ArrayList<BkgChgRateVO>();
				List<BkgChgRateVO> updateVoList = new ArrayList<BkgChgRateVO>();
				List<BkgChgRateVO> deleteVoList = new ArrayList<BkgChgRateVO>();

				log.debug("=============================================");
				log.debug(" [validation] Add the item NOT saved manually  ");
				log.debug("=============================================");
				
				for (int i = 0; i < cnt; i++) {
					if (bkgChgRateVOs[i].getIbflag() == null) 			continue;

					String sCharge = bkgChgRateVOs[i].getChgCd();
					String sCurrency = bkgChgRateVOs[i].getCurrCd();
					String sPerCode = bkgChgRateVOs[i].getRatUtCd();
					if (!bkgChgRateVOs[i].getIbflag().equals("D")) {
						String rCharge = bookingUtil.existChargeCode(sCharge);
						String rCurrency = bookingUtil.existCurrencyCode(sCurrency);
						String rPerCode = bookingUtil.existPerCode(sPerCode);
						if (!"Y".equals(rCharge)) {
							throw new EventException((String) new ErrorHandler("BKG08142", new String[] { sCharge }).getMessage());
						}
						if (!"Y".equals(rCurrency)) {
							throw new EventException((String) new ErrorHandler("BKG08143", new String[] { sCurrency }).getMessage());
						}
						if (!"Y".equals(rPerCode)) {
							throw new EventException((String) new ErrorHandler("BKG08144", new String[] { sPerCode }).getMessage());
						}
					}

					// SEND 'U' if AUTO RATING
					if ("Y".equals(autoRate)) {
						if (bkgChgRateVOs[i].getIbflag().equals("U")) {
							bkgChgRateVOs[i].setBkgNo(bkgNo);
							bkgChgRateVOs[i].setCreUsrId(account.getUsr_id());
							bkgChgRateVOs[i].setUpdUsrId(account.getUsr_id());
							insertVoList.add(bkgChgRateVOs[i]);
						}

					}else{
						if (bkgChgRateVOs[i].getIbflag().equals("U")) {
							String bkg_no = bkgChgRateVOs[i].getBkgNo();
							if(bkg_no == null || bkg_no.equals("")){
								bkgChgRateVOs[i].setIbflag("I");
							}
						}
						if (bkgChgRateVOs[i].getIbflag().equals("I")) {
							bkgChgRateVOs[i].setBkgNo(bkgNo);
							bkgChgRateVOs[i].setCreUsrId(account.getUsr_id());
							bkgChgRateVOs[i].setUpdUsrId(account.getUsr_id());
							insertVoList.add(bkgChgRateVOs[i]);
						} else if (bkgChgRateVOs[i].getIbflag().equals("U")) {
							bkgChgRateVOs[i].setBkgNo(bkgNo);
							bkgChgRateVOs[i].setUpdUsrId(account.getUsr_id());
							updateVoList.add(bkgChgRateVOs[i]);
						} else if (bkgChgRateVOs[i].getIbflag().equals("D")) {
							bkgChgRateVOs[i].setBkgNo(bkgNo);
							deleteVoList.add(bkgChgRateVOs[i]);
						}
					}
				}

				if (deleteVoList.size() > 0) {
					dbDao.removeChgRate(deleteVoList, caflag);
				}
				if (insertVoList.size() > 0) {
					dbDao.addChgRate(insertVoList, caflag);
				}
				if (updateVoList.size() > 0) {
					dbDao.modifyChgRate(updateVoList, caflag);
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * removeCntrRateByCntr

	 * @param String  bkgNo
	 * @param String cntrNo
	 * @param String cntrRtSeq
	 * @exception EventException
	 */
	public void removeCntrRateByCntr(String bkgNo, String cntrNo, String cntrRtSeq) throws EventException {
		try {
			dbDao.removeCntrRateByCntr(bkgNo, cntrNo, cntrRtSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * changeCntrRate

	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrNoOld
	 * @exception EventException
	 */
	public void changeCntrRate(String bkgNo, String cntrNo, String cntrNoOld) throws EventException {
		try {
			List<BkgCntrRtVO> list = dbDao.searchCntrRateByCntr(bkgNo, cntrNoOld, "");
			dbDao.removeCntrRateByCntr(bkgNo, cntrNoOld, "");

			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					BkgCntrRtVO bkgCntrRtVO = list.get(i);
					bkgCntrRtVO.setCntrNo(cntrNo);
					dbDao.insertCntrRateByCntr(bkgCntrRtVO);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Cargo Receiving Date 

	 * @param bkgNo
	 * @param crdDt
	 * @param caFlg
	 * @exception EventException
	 */
	public void manageCrdDt(String bkgNo, String crdDt, String caFlg) throws EventException {
		try {
			dbDao.manageCrdDt(bkgNo, crdDt, caFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Copying the manual rate in the bkg_rate table and bkg_chg_rate table when the booking split<br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO[] targetBkg
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyManualChgByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, SignOnUserAccount account) throws EventException {
		try {
			for (int i = 0; i < targetBkg.length; i++) {
				if (!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())) {
					dbDao.copyBkgRateByBkg(sourceBkg, targetBkg[i], account);
					dbDao.createRateForTro(targetBkg[i].getBkgNo(),"N", account.getUsr_id());
					dbDao.copyManualChg(sourceBkg, targetBkg[i], account);
				}
			}
		} catch (DAOException de) {
			// log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0079_02c : confirm (ESM_BKG_0906)    
     * permitted if boundCd == 'I'
	 * 
	 * @param TroCfmVO  troCfmVO
	 * @param SignOnUserAccount  account
	 * @return String
	 * @exception EventException
	 */
	public String createCHRevenue(TroCfmVO troCfmVO, SignOnUserAccount account) throws EventException {
		try {
			String strMasterBkgNo = "";
			BookingUtil command = new BookingUtil();

			String payerCntCd = "";
			String payerSeq = "";
			String bkgNo = "";
			String ofcCd = "";
			String ioBndCd = "";

			EurPayerVO eurPayerVO = troCfmVO.getEurPayerVO();
			if (eurPayerVO != null) {
				payerCntCd = eurPayerVO.getPayerCntCd();
				payerSeq = eurPayerVO.getPayerSeq();
				bkgNo = eurPayerVO.getBkgNo();
				ofcCd = eurPayerVO.getCctOfcCd();
				ioBndCd = eurPayerVO.getIoBndCd();
			}

			// 1) searchMdmCust check
			if (payerCntCd.length() > 0)
				command.searchMdmCust(payerCntCd, payerSeq, "N");

			// 2) memoSplitBkgNo find
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkgNo);
			MemoSplitMasterBkgVO memoSplitMasterBkgVO = command.searchMemoSplitMstBkg(bkgBlNoVO);
			if (memoSplitMasterBkgVO == null) {
				strMasterBkgNo = bkgNo;
			} else {
				String strSplitBkgNo = JSPUtil.getNullNoTrim(memoSplitMasterBkgVO.getBkgNo());
				String strSplitRsnCd = JSPUtil.getNullNoTrim(memoSplitMasterBkgVO.getSplitRsnCd());
				if (!"".equals(strSplitBkgNo)) {
					while (!"".equals(strSplitBkgNo)) {
						bkgBlNoVO.setBkgNo(strSplitBkgNo);
						memoSplitMasterBkgVO = command.searchMemoSplitMstBkg(bkgBlNoVO);
						if (memoSplitMasterBkgVO == null) {
							strMasterBkgNo = strSplitBkgNo;
							break;
						}
						strSplitBkgNo = JSPUtil.getNullNoTrim(memoSplitMasterBkgVO.getBkgNo());
						strSplitRsnCd = JSPUtil.getNullNoTrim(memoSplitMasterBkgVO.getSplitRsnCd());
						if ("M".equals(strSplitRsnCd)) {
							strMasterBkgNo = strSplitBkgNo;
						}
					}
				} else {
					strMasterBkgNo = bkgNo;
				}
			}
			TroListForCfmVO[] arrTroListForCfmVO = troCfmVO.getArrTroListForCfmVO();

			bkgBlNoVO.setBkgNo(strMasterBkgNo);

			for (int i = 0; i < arrTroListForCfmVO.length; i++) {
				if (!"Yes".equals(arrTroListForCfmVO[i].getAllInRtCd())) {
					String currCd = command.searchMdmCurr(arrTroListForCfmVO[i].getCurrCd());
					if ("".equals(currCd)) {
						throw new EventException(new ErrorHandler("BKG00898").getMessage());
					}

					TroRevenueVO troRevenueVO = new TroRevenueVO();
					troRevenueVO.setBkgNo(strMasterBkgNo);
					troRevenueVO.setHaulageCd(arrTroListForCfmVO[i].getHlgTpCd());
					troRevenueVO.setCurrCd(currCd);
					troRevenueVO.setRate(arrTroListForCfmVO[i].getTrnsRevAmt());
					troRevenueVO.setCntrNo(arrTroListForCfmVO[i].getCntrNo());
					troRevenueVO.setCltOfcCd(ofcCd);
					troRevenueVO.setPayerCntCd(payerCntCd);
					troRevenueVO.setPayerCustSeq(payerSeq);
					troRevenueVO.setCreUsrId(account.getUsr_id());
					troRevenueVO.setUpdUsrId(account.getUsr_id());
					troRevenueVO.setIoBndCd(ioBndCd);
					troRevenueVO.setChgCd("A");
					troRevenueVO.setCntrTpszCd(arrTroListForCfmVO[i].getCntrTpszCd());
					
					if (arrTroListForCfmVO[i].getTrnsRevAmt() != null && arrTroListForCfmVO[i].getTrnsRevAmt().length() > 0 
							&& 0 < Double.compare(Double.parseDouble(JSPUtil.getNullNoTrim(arrTroListForCfmVO[i].getTrnsRevAmt(),"0")), 0.00d)
							&& arrTroListForCfmVO[i].getIoBndCd() != null
							&& arrTroListForCfmVO[i].getCntrTpszCd() != null) {
						dbDao.addT1Revenue(troRevenueVO);
					}
					double rate = Double.parseDouble(JSPUtil.getNullNoTrim(arrTroListForCfmVO[i].getTrnsRevAmt(),"0"));
					if ("Yes".equals(arrTroListForCfmVO[i].getVatFlg())
							&& arrTroListForCfmVO[i].getCntrTpszCd() != null) {
						double vatRevenue = 0.00;
						if (!"EUR".equals(currCd)) {
							vatRevenue = dbDao.searchVATtoEur(currCd, rate);
						} else {
							vatRevenue = Double.parseDouble(JSPUtil.getNullNoTrim(arrTroListForCfmVO[i].getTrnsRevAmt(),"0"));
						}
						if (vatRevenue > 0) {
							TroRevenueVO vatRevenueVO = new TroRevenueVO();
							vatRevenueVO.setBkgNo(strMasterBkgNo);
							vatRevenueVO.setCntrNo(arrTroListForCfmVO[i].getCntrNo());
							vatRevenueVO.setCltOfcCd(ofcCd);
							vatRevenueVO.setPayerCntCd(payerCntCd);
							vatRevenueVO.setPayerCustSeq(payerSeq);
							vatRevenueVO.setCreUsrId(account.getUsr_id());
							vatRevenueVO.setUpdUsrId(account.getUsr_id());
							vatRevenueVO.setCntrTpszCd(arrTroListForCfmVO[i].getCntrTpszCd());
							vatRevenueVO.setChgCd("A");
							vatRevenueVO.setIoBndCd(ioBndCd);
							dbDao.addVATRevenue(vatRevenue, vatRevenueVO, ofcCd);
						}
					}
					
					if (arrTroListForCfmVO[i].getAddRevAmt() != null && arrTroListForCfmVO[i].getAddRevAmt().length() > 0 
							&& 0 < Double.compare(Double.parseDouble(JSPUtil.getNullNoTrim(arrTroListForCfmVO[i].getAddRevAmt(),"0")), 0.00d)  
							&& arrTroListForCfmVO[i].getAddRevChgCd().length() > 0
							&& arrTroListForCfmVO[i].getCntrTpszCd() != null) {
						log.debug("\n ################################# additional charge 생성 !! ");
						TroRevenueVO addRevenueVO = new TroRevenueVO();
						addRevenueVO.setBkgNo(strMasterBkgNo);
						addRevenueVO.setCurrCd(currCd);
						addRevenueVO.setRate(arrTroListForCfmVO[i].getAddRevAmt());
						addRevenueVO.setCntrNo(arrTroListForCfmVO[i].getCntrNo());
						addRevenueVO.setCltOfcCd(ofcCd);
						addRevenueVO.setPayerCntCd(payerCntCd);
						addRevenueVO.setPayerCustSeq(payerSeq);
						addRevenueVO.setCreUsrId(account.getUsr_id());
						addRevenueVO.setUpdUsrId(account.getUsr_id());
						log.debug("\n ######################### arrTroListForCfmVO[i].getCntrTpszCd()" + arrTroListForCfmVO[i].getCntrTpszCd());
						addRevenueVO.setCntrTpszCd(arrTroListForCfmVO[i].getCntrTpszCd());
						addRevenueVO.setIoBndCd(ioBndCd);
						addRevenueVO.setChgCd(arrTroListForCfmVO[i].getAddRevChgCd());
						dbDao.addT1Revenue(addRevenueVO);
					}
					
	
				}
			}

			return strMasterBkgNo;

		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Copying the rehandling charge from bkg_cod_cost table to bkg_chg_rt table
	 * 
	 * @param String   codRqstSeq
	 * @param BkgBlNoVO   bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addCodRehandlingChg(String codRqstSeq, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.addCodRehandlingChg(codRqstSeq, bkgBlNoVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Copying the bkg_chg_rt Info of sourceBkg to targetBkg(ESM_BKG_0076)
	 * 
	 * @param BkgBlNoVO[] sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void copyChgRateByBkg(BkgBlNoVO[] sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws EventException {
		try {
			if (sourceBkg != null) {
				for (int i = 0; i < sourceBkg.length; i++) {
					dbDao.copyChgRateByBkg(sourceBkg[i], targetBkg, account);
					dbDao.copyAutoRtHisByBkg(sourceBkg[i], targetBkg, account);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Copying the BKG tables for C/A
	 * 
	 * @param BkgBlNoVO   bkgBlNoVO
	 * @param String   copyTypeCd
	 * @exception EventException
	 */
	public void createRateCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
		try {
			if ("BKG".equals(copyTypeCd)) {
				// 01.
				dbDao.removeChgRateCA(bkgBlNoVO, copyTypeCd);
				// 02.
				dbDao.removeRateCA(bkgBlNoVO, copyTypeCd);
				// 03.BKG_AUTO_RT_HIS
				dbDao.removeAutoRateHisCA(bkgBlNoVO, copyTypeCd);
			}

			// 01.
			dbDao.createRateCA(bkgBlNoVO, copyTypeCd);
			// 02.
			dbDao.createChgRateCA(bkgBlNoVO, copyTypeCd);
			// 03.BKG_AUTO_RT_HIS
			dbDao.createAutoRtHisCA(bkgBlNoVO, copyTypeCd);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Deleting the BKG tables for C/A
	 * 
	 * @param BkgBlNoVO  bkgBlNoVO
	 * @param String  copyTypeCd
	 * @exception EventException
	 */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
		try {
			// 01.
			dbDao.removeChgRateCA(bkgBlNoVO, copyTypeCd);
			// 02.
			dbDao.removeRateCA(bkgBlNoVO, copyTypeCd);
			// 03.BKG_AUTO_RT_HIS
			dbDao.removeAutoRateHisCA(bkgBlNoVO, copyTypeCd);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Searching the Container Rate
	 * 
	 * @param bkgNo
	 * @return CntrRtOutVO
	 * @exception EventException
	 */
	public CntrRtOutVO searchCntrRate(String bkgNo) throws EventException {
		CntrRtOutVO cntrRtOutVO = new CntrRtOutVO();
		try {
			CntrRtBkgInfoVO cntrRtBkgInfoVO = dbDao.searchCntrRtBkgInfo(bkgNo);
			List<CntrRtQtyVO> cntrRtQtyVOs = dbDao.searchCntrRtQty(bkgNo);
			List<CntrRtVO> cntrRtVOs = dbDao.searchCntrRt(bkgNo);
			List<CntrRtAmtVO> cntrRtAmtVOs = dbDao.searchCntrRtAmt(bkgNo);
			List<CntrRtCustVO> cntrRtCustVOs = dbDao.searchCntrRtCust(bkgNo);

			cntrRtOutVO.setCntrRtBkgInfoVO(cntrRtBkgInfoVO);
			cntrRtOutVO.setCntrRtQtyVOs(cntrRtQtyVOs);
			cntrRtOutVO.setCntrRtVOs(cntrRtVOs);
			cntrRtOutVO.setCntrRtAmtVOs(cntrRtAmtVOs);
			cntrRtOutVO.setCntrRtCustVOs(cntrRtCustVOs);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
		return cntrRtOutVO;
	}

	/**
	 * Modifying the Container Rate
	 * 
	 * @param cntrRtVOs
	 * @param account
	 * @exception EventException
	 */
	public void manageCntrRate(List<CntrRtVO> cntrRtVOs, SignOnUserAccount account) throws EventException {
		try {

			List<CntrRtVO> updateVoList = new ArrayList<CntrRtVO>();
			int len = cntrRtVOs == null ? 0 : cntrRtVOs.size();
			for (int i = 0; i < len; i++) {
				CntrRtVO cntrRtVO = cntrRtVOs.get(i);

				cntrRtVO.setCreUsrId(account.getUsr_id());
				cntrRtVO.setUpdUsrId(account.getUsr_id());
				log.debug("CntrRtVO -> " + cntrRtVO.getIbflag() + " : " + cntrRtVO.getBkgNo() + " : " + cntrRtVO.getCntrNo());
				updateVoList.add(cntrRtVO);
			}

			if (updateVoList.size() > 0) {
				dbDao.manageCntrRate(updateVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Copying the ppd ofc and cct ofc
	 * 
	 * @param BkgBlNoVO  sourceBkg
	 * @param BkgBlNoVO  targetBkg
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyPpdCctByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws EventException {
		try {
			dbDao.copyPpdCctByBkg(sourceBkg, targetBkg, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rate by Container
	 * 
	 * @param bkgNo
	 * @param account
	 * @exception EventException
	 */
	public void distributeCntrRate(String bkgNo, SignOnUserAccount account) throws EventException {

		BookingUtil utilCmd = new BookingUtil();

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		BkgBlNoVO bkgBlNoOut = null;

		try {

			List<CntrRtBkgNoVO> cntrRtBkgNoVOs = dbDao.searchCntrRtBkgNo(bkgNo, "N");
			int len = cntrRtBkgNoVOs == null ? 0 : cntrRtBkgNoVOs.size();
			log.debug("********** cnrRtBkgNoVOs.size():" + len);

			/* check booking_confirm_flag */
			boolean checkBkgCfrm = false;
			for (int i = 0; i < len; i++) {
				String tmp = dbDao.checkCntrCfrmByBkg(cntrRtBkgNoVOs.get(i).getBkgNo(), "N");
				
				if ("CNTCFM".equals(tmp)) {
					checkBkgCfrm = true;
					break;
				}
				
			}

			if (checkBkgCfrm) {

				// remove old
				dbDao.removeCntrRt(cntrRtBkgNoVOs);

				for (int i = 0; i < 1; i++) {
				
					String bkg_no = cntrRtBkgNoVOs.get(i).getBkgNo();
					String bl_cvrd_tp_cd = null;
					if ("M".equals(cntrRtBkgNoVOs.get(i).getBlCvrdTpCd()) || "C".equals(cntrRtBkgNoVOs.get(i).getBlCvrdTpCd())) {
						bl_cvrd_tp_cd = "Y";
					} else {
						bl_cvrd_tp_cd = "N";
					}

					// set bkg_no
					bkgBlNoIN.setBkgNo(bkg_no);
					bkgBlNoIN.setCaUsrId(account.getUsr_id());

					// search Bkg_No
					bkgBlNoOut = utilCmd.searchBkgBlNoVO(bkgBlNoIN);

					if (bkgBlNoOut == null || bkgBlNoOut.getBkgNo() == null) {
						throw new RuntimeException((String)new ErrorHandler("BKG01049", new String[] { bkg_no }).getMessage());
					}
					if ("X".equals(bkgBlNoOut.getBkgStsCd())) {
						throw new RuntimeException((String)new ErrorHandler("BKG00433", new String[] { bkg_no }).getMessage());
					}
					if ("Y".equals(bkgBlNoOut.getCaFlg())) {
						throw new RuntimeException((String)new ErrorHandler("BKG08036", new String[] { bkg_no }).getMessage());
					}

					log.debug("********** distributeCharge:" + bkgBlNoOut.getBkgNo() + ":cnt~" + i);
					// Distribution
					this.distributeCharge(bkgBlNoOut.getBkgNo(), bl_cvrd_tp_cd, bkgBlNoOut.getCaFlg(), account.getUsr_id());
				}
			} else {
				log.debug("!!Not Confirmed Booking!! [" + bkgNo + "]");
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Charge by Container
	 * 
	 * @param bkgNo
	 * @param mstFlag
	 * @param caFlag
	 * @param userId
	 * @throws EventException
	 */
	private void distributeCharge(String bkgNo, String mstFlag, String caFlag, String userId) throws EventException {

		List<BkgCntrRtVO> cntrRtVOs = new ArrayList<BkgCntrRtVO>();
		List<CntrRtBkgChgVO> chgRateVOs = null;
		List<CntrRtCntrVO> cntrVOs = null;
		List<CntrRtBkgQtyVO> qtyVOs = null;

		float bkg_ttl_amt = 0F;
		float cntr_ttl_amt = 0F;

		String flag45 = "";   // Before Container Type 
		String bfChgCd = ""; // Before Chg Cd

		try {
			/* 1. search bkg_charge_rate */
			chgRateVOs = dbDao.searchChgRateByBkg(bkgNo, mstFlag, caFlag);

			Comparator<CntrRtBkgChgVO> comparator1 = new Comparator<CntrRtBkgChgVO>() {
				public int compare(CntrRtBkgChgVO vo1, CntrRtBkgChgVO vo2) {
					int retInt = vo1.getChgCd().compareTo(vo2.getChgCd()); 
					if( retInt == 0 ){
						return (vo2.getRatUtCd().compareTo(vo1.getRatUtCd()));
					}
					return retInt;
				}
			};
			Collections.sort(chgRateVOs, comparator1);
			
			int rtCnt = chgRateVOs == null ? 0 : chgRateVOs.size();
			log.debug("***** 1. CHG_RT_CNT : " + rtCnt);
			if (rtCnt == 0)
				return;

			/* 2. search bkg_container */
			cntrVOs = dbDao.searchContainerByBkg(bkgNo, mstFlag, caFlag);
			int cntrCnt = (cntrVOs == null) ? 0 : cntrVOs.size();
			log.debug("***** 2. CNTR_CNT : " + cntrCnt);
			if (cntrCnt == 0)
				return;
			float cntrTtlVol = 0F;
			for (int i = 0; i < cntrCnt; i++) {
				cntrTtlVol += (cntrVOs.get(i).getCntrVolQty() == null || "".equals(cntrVOs.get(i).getCntrVolQty())) ? 0 : Float.parseFloat(cntrVOs.get(i).getCntrVolQty());
			}
			log.debug("         CNTR_TTL_VOL : " + cntrTtlVol);

			/* 3. eq-substitution */
			qtyVOs = dbDao.searchBkgQty(bkgNo, caFlag);
			int qtyCnt = qtyVOs == null ? 0 : qtyVOs.size();
			log.debug("***** 3. QTY_CNT : " + qtyCnt);
//			for (int i = 0; i < qtyCnt; i++) {
//				String cntrTpszCd = qtyVOs.get(i).getCntrTpszCd();
//				String eqSubstCntrTpszCd = qtyVOs.get(i).getEqSubstCntrTpszCd();
//				float eqSubstCgoQty = Float.parseFloat(qtyVOs.get(i).getEqSubstCgoQty());
//				float cntrVolQty = 0F;
//
//				for (int j = 0; j < cntrCnt; j++) {
//					if (eqSubstCgoQty <= 0)
//						break;
//					if (cntrTpszCd.equals(cntrVOs.get(j).getCntrTpszCd())) {
//						cntrVolQty = (cntrVOs.get(j).getCntrVolQty() == null || "".equals(cntrVOs.get(j).getCntrVolQty())) ? 0 : Float.parseFloat(cntrVOs.get(j).getCntrVolQty());
//						eqSubstCgoQty -= cntrVolQty;
//						cntrVOs.get(j).setEqSubstTpszCd(eqSubstCntrTpszCd);
//						cntrVOs.get(j).setEqSubstFlg("Y");
//						log.debug("         EQ-SUBST : " + cntrTpszCd + " (" + cntrVolQty + ")  -> " + eqSubstCntrTpszCd + " : " + eqSubstCgoQty);
//					}
//				}
//			}
			for (int i = 0; i < qtyCnt; i++) {
				String cntrTpszCd = qtyVOs.get(i).getCntrTpszCd();
				String eqSubstCntrTpszCd = qtyVOs.get(i).getEqSubstCntrTpszCd();
				float eqSubstCgoQty = Float.parseFloat(qtyVOs.get(i).getOpCntrQty());
				float cntrVolQty = 0F;
				
				for (int j = 0; j < cntrCnt; j++) {
					if (eqSubstCgoQty <= 0)
						break;
					if (cntrTpszCd.equals(cntrVOs.get(j).getCntrTpszCd()) && !"Y".equals(cntrVOs.get(j).getEqSubstFlg())) {
						cntrVolQty = (cntrVOs.get(j).getCntrVolQty() == null || "".equals(cntrVOs.get(j).getCntrVolQty())) ? 0 : Float.parseFloat(cntrVOs.get(j).getCntrVolQty());
						eqSubstCgoQty -= cntrVolQty;
						cntrVOs.get(j).setEqSubstTpszCd(eqSubstCntrTpszCd);
						cntrVOs.get(j).setEqSubstFlg("Y");
						log.debug("         EQ-SUBST : " + cntrTpszCd + " (" + cntrVolQty + ")  -> " + eqSubstCntrTpszCd + " : " + eqSubstCgoQty);
					}
				}
			}

			/* 4. search cntr tpsz */
			// String cntrTpszs =
			// "A2,A4,D2,D3,D4,D5,D7,D8,D9,DW,DX,F2,F4,F5,O2,O4,P2,P4,Q2,Q4,R2,R4,R5,R7,S2,S4,T2,T4";
			String cntrTpszs = dbDao.searchCntrTpsz();
			log.debug("***** 4. CNTR_TPSZ : " + cntrTpszs);

			HashMap<String, List<String>> ratUtCdMap = new HashMap<String, List<String>>();
			List<String> ratUtCdList = null;
			
			for (int x = 0; x < rtCnt; x++){
				CntrRtBkgChgVO chgRateVO = chgRateVOs.get(x);
				
				String chg_cd = chgRateVO.getChgCd();
				
				ratUtCdList = new ArrayList<String>();
				for (int j = 0; j < cntrCnt; j++) {
					ratUtCdList.add(cntrVOs.get(j).getCntrTpszCd());
				}
				ratUtCdMap.put(chg_cd, ratUtCdList);
			}
			
			/* 5. distribute rate */
			for (int i = 0; i < rtCnt; i++) {
				CntrRtBkgChgVO chgRateVO = chgRateVOs.get(i);
				// getter
				String chg_cd = chgRateVO.getChgCd();
				String rat_ut_cd = chgRateVO.getRatUtCd();
				String cgo_cate_cd = chgRateVO.getCgoCateCd();
				float chg_ut_amt = (chgRateVO.getChgUtAmt() == null || "".equals(chgRateVO.getChgUtAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgUtAmt());
				float rat_as_qty = (chgRateVO.getRatAsQty() == null || "".equals(chgRateVO.getRatAsQty())) ? 0 : Float.parseFloat(chgRateVO.getRatAsQty());
				float chg_amt = (chgRateVO.getChgAmt() == null || "".equals(chgRateVO.getChgAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgAmt());
				// total amount of booking
				bkg_ttl_amt += chg_amt;
				log.debug("***** 5. BkgChgRateVO : ChgCd = " + chg_cd + ", RatUtCd = " + rat_ut_cd + ", CgoCateCd = " + cgo_cate_cd + ", ChgUtAmt = " + chg_ut_amt + ", RatAsQty = " + rat_as_qty + ", ChgAmt = " + chg_amt);

				// Pertype is NOT TPSZ
				if (cntrTpszs.indexOf(rat_ut_cd) == -1) {
					// 'B' Type
					if ("BL".equals(rat_ut_cd) || "SD".equals(rat_ut_cd)) {
						float cntr_dist_vol = 0F;
						List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
						for (int n = 0; n < tempRtVOs.size(); n++) {
							BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
							// sum dist amount
							cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
							// add vo to list
							cntrRtVOs.add(cntrRtVO);
						}
						// check total amount and distributed amount
						if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
							log.debug("!!! 'B' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
						} else {
							log.debug("!!! 'B' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
						}
						// sum of container amount
						cntr_ttl_amt += cntr_dist_vol;

						// 'C' Type
					} else if ("PC".equals(rat_ut_cd)) {
						float oft_amt = 0F;
						float oft_sum = 0F;
						String oft_per_type = null;
						String oft_cgo_type = null;

						// OFT Summary
						for (int k = 0; k < rtCnt; k++) {
							if ("OFT".equals(chgRateVOs.get(k).getChgCd())) {
								oft_sum += (chgRateVOs.get(k).getChgAmt() == null || "".equals(chgRateVOs.get(k).getChgAmt())) ? 0 : Float.parseFloat(chgRateVOs.get(k).getChgAmt());
							}
						}

						float cntr_dist_vol = 0F;
						List<BkgCntrRtVO> tmpCntrRtVOs = new ArrayList<BkgCntrRtVO>();
						for (int k = 0; k < rtCnt; k++) {
							if ("OFT".equals(chgRateVOs.get(k).getChgCd())) {
								oft_amt = (chgRateVOs.get(k).getChgAmt() == null || "".equals(chgRateVOs.get(k).getChgAmt())) ? 0 : Float.parseFloat(chgRateVOs.get(k).getChgAmt());
								oft_per_type = chgRateVOs.get(k).getRatUtCd();
								oft_cgo_type = chgRateVOs.get(k).getCgoCateCd();

								float cntr_vol_sum = 0F;
								ArrayList<CntrRtCntrVO> al = new ArrayList<CntrRtCntrVO>();
								for (int m = 0; m < cntrCnt; m++) {
									CntrRtCntrVO cntrVO = cntrVOs.get(m);
									// 'DG' Cargo
									if ("DG".equals(oft_cgo_type)) {
										if (oft_per_type.equals(cntrVO.getEqSubstTpszCd()) && "Y".equals(cntrVO.getDcgoFlg())) {
											cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
											al.add(cntrVO);
											log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
										}
										// 'RF' Cargo
									} else if ("RF".equals(oft_cgo_type)) {
										if (oft_per_type.equals(cntrVO.getEqSubstTpszCd()) && "Y".equals(cntrVO.getRcFlg())) {
											cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
											al.add(cntrVO);
											log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
										}
										// 'AK' Cargo
									} else if ("AK".equals(oft_cgo_type)) {
										if (oft_per_type.equals(cntrVO.getEqSubstTpszCd()) && "Y".equals(cntrVO.getAwkCgoFlg())) {
											cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
											al.add(cntrVO);
											log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
										}
										// 'BB' Cargo
									} else if ("BB".equals(oft_cgo_type)) {
										if (oft_per_type.equals(cntrVO.getEqSubstTpszCd()) && "Y".equals(cntrVO.getBbCgoFlg())) {
											cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
											al.add(cntrVO);
											log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
										}
										// 'DR' Cargo
									} else {
										if (oft_per_type.equals(cntrVO.getEqSubstTpszCd()) && "N".equals(cntrVO.getDcgoFlg()) && "N".equals(cntrVO.getRcFlg()) && "N".equals(cntrVO.getAwkCgoFlg()) && "N".equals(cntrVO.getBbCgoFlg())) {
											cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
											al.add(cntrVO);
											log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
										}
									}
								}

								if (cntr_vol_sum > 0) {
									List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByPercent(chgRateVO, oft_amt, oft_sum, cntr_vol_sum, al);
									for (int n = 0; n < tempRtVOs.size(); n++) {
										tmpCntrRtVOs.add(tempRtVOs.get(n));
									}
								} else {
									cntr_vol_sum = 0F;
									al = new ArrayList<CntrRtCntrVO>();
									for (int m = 0; m < cntrCnt; m++) {
										CntrRtCntrVO cntrVO = cntrVOs.get(m);
										if (oft_per_type.equals(cntrVO.getEqSubstTpszCd())) {
											cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
											al.add(cntrVO);
											log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
										}
									}

									if (cntr_vol_sum > 0) {
										List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByPercent(chgRateVO, oft_amt, oft_sum, cntr_vol_sum, al);
										for (int n = 0; n < tempRtVOs.size(); n++) {
											tmpCntrRtVOs.add(tempRtVOs.get(n));
										}
									} else {
										List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByPercent(chgRateVO, oft_amt, oft_sum, cntrTtlVol, cntrVOs);
										for (int n = 0; n < tempRtVOs.size(); n++) {
											tmpCntrRtVOs.add(tempRtVOs.get(n));
										}
									}
								}
							}// end of IF
						}// end of FOR

						// check sum
						float chk_sum1 = 0F;
						float chk_sum2 = 0F;
						float cntr_ut_amt = 0F;
						float cntr_amt = 0F;
						int tmpCnt = tmpCntrRtVOs.size();
						for (int k = 0; k < tmpCnt; k++) {
							BkgCntrRtVO cntrRtVO = tmpCntrRtVOs.get(k);
							// log.debug("* PC : " + cntrRtVO.getRatUtCd() +
							// " - "+ cntrRtVO.getChgUtAmt() + " / " +
							// cntrRtVO.getChgAmt());
							cntr_ut_amt = (cntrRtVO.getChgUtAmt() == null || "".equals(cntrRtVO.getChgUtAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgUtAmt());
							cntr_amt = (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
							// check the last ratio
							if ((k + 1) == tmpCnt) {
								cntrRtVO.setChgUtAmt(String.valueOf(oft_sum - chk_sum1));
								cntrRtVO.setChgAmt(String.valueOf(chg_amt - chk_sum2));
							}
							// dist. volumn
							cntr_dist_vol += cntr_amt;
							// rearrange VO
							cntrRtVOs.add(cntrRtVO);
							// check sum
							chk_sum1 += cntr_ut_amt;
							chk_sum2 += cntr_amt;
						}
						// check total amount and distributed amount
						if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
							log.debug("!!! 'C' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
						} else {
							log.debug("!!! 'C' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
						}
						// sum of container amount
						cntr_ttl_amt += cntr_dist_vol;

						// Void Type (Q2)
					} else if ("Q2".equals(rat_ut_cd)) {
						float cntr_vol_sum = 0F;
						ArrayList<CntrRtCntrVO> al = new ArrayList<CntrRtCntrVO>();
						for (int m = 0; m < cntrCnt; m++) {
							CntrRtCntrVO cntrVO = cntrVOs.get(m);
							if ((cntrVO.getEqSubstTpszCd().endsWith("2") || cntrVO.getEqSubstTpszCd().endsWith("3")) && "Y".equals(cntrVO.getAwkCgoFlg())) {
								cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
								al.add(cntrVO);
							}
						}

						if (cntr_vol_sum > 0) {
							float cntr_dist_vol = 0F;
							List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
							for (int n = 0; n < tempRtVOs.size(); n++) {
								BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
								// sum dist amount
								cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
								// add vo to list
								cntrRtVOs.add(cntrRtVO);
							}
							// check total amount and distributed amount
							if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
								log.debug("!!! 'Q' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
							} else {
								log.debug("!!! 'Q' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
							}
							// sum of container amount
							cntr_ttl_amt += cntr_dist_vol;
						} else {
							cntr_vol_sum = 0F;
							al = new ArrayList<CntrRtCntrVO>();
							for (int m = 0; m < cntrCnt; m++) {
								CntrRtCntrVO cntrVO = cntrVOs.get(m);
								if (cntrVO.getEqSubstTpszCd().endsWith("2") || cntrVO.getEqSubstTpszCd().endsWith("3")) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
								}
							}

							if (cntr_vol_sum > 0) {
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'Q' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'Q' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							} else {
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'Q' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'Q' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							}
						}

						// Void Type (Q4)
					} else if ("Q4".equals(rat_ut_cd)) {
						float cntr_vol_sum = 0F;
						ArrayList<CntrRtCntrVO> al = new ArrayList<CntrRtCntrVO>();
						for (int m = 0; m < cntrCnt; m++) {
							CntrRtCntrVO cntrVO = cntrVOs.get(m);
							if ((cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")) && "Y".equals(cntrVO.getAwkCgoFlg())) {
								cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
								al.add(cntrVO);
							}
						}

						if (cntr_vol_sum > 0) {
							float cntr_dist_vol = 0F;
							List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
							for (int n = 0; n < tempRtVOs.size(); n++) {
								BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
								// sum dist amount
								cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
								// add vo to list
								cntrRtVOs.add(cntrRtVO);
							}
							// check total amount and distributed amount
							if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
								log.debug("!!! 'Q' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
							} else {
								log.debug("!!! 'Q' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
							}
							// sum of container amount
							cntr_ttl_amt += cntr_dist_vol;
						} else {
							cntr_vol_sum = 0F;
							al = new ArrayList<CntrRtCntrVO>();
							for (int m = 0; m < cntrCnt; m++) {
								CntrRtCntrVO cntrVO = cntrVOs.get(m);
								if (cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
								}
							}

							if (cntr_vol_sum > 0) {
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'Q' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'Q' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							} else {
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'Q' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'Q' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							}
						}

						// 'E' Type
					} else if ("20".equals(rat_ut_cd)) {
						float cntr_vol_sum = 0F;
						ArrayList<CntrRtCntrVO> al = new ArrayList<CntrRtCntrVO>();
						for (int m = 0; m < cntrCnt; m++) {
							CntrRtCntrVO cntrVO = cntrVOs.get(m);
							// 'DG' Cargo
							if ("DG".equals(cgo_cate_cd)) {
								if ((cntrVO.getEqSubstTpszCd().endsWith("2") || cntrVO.getEqSubstTpszCd().endsWith("3")) && "Y".equals(cntrVO.getDcgoFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'RF' Cargo
							} else if ("RF".equals(cgo_cate_cd)) {
								if ((cntrVO.getEqSubstTpszCd().endsWith("2") || cntrVO.getEqSubstTpszCd().endsWith("3")) && "Y".equals(cntrVO.getRcFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'AK' Cargo
							} else if ("AK".equals(cgo_cate_cd)) {
								if ((cntrVO.getEqSubstTpszCd().endsWith("2") || cntrVO.getEqSubstTpszCd().endsWith("3")) && "Y".equals(cntrVO.getAwkCgoFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'BB' Cargo
							} else if ("BB".equals(cgo_cate_cd)) {
								if ((cntrVO.getEqSubstTpszCd().endsWith("2") || cntrVO.getEqSubstTpszCd().endsWith("3")) && "Y".equals(cntrVO.getBbCgoFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'DR' Cargo
							} else {
								if ((cntrVO.getEqSubstTpszCd().endsWith("2") || cntrVO.getEqSubstTpszCd().endsWith("3")) && "N".equals(cntrVO.getDcgoFlg()) && "N".equals(cntrVO.getRcFlg()) && "N".equals(cntrVO.getAwkCgoFlg()) && "N".equals(cntrVO.getBbCgoFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
							}
						}

						if (cntr_vol_sum > 0) {
							float cntr_dist_vol = 0F;
							List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
							for (int n = 0; n < tempRtVOs.size(); n++) {
								BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
								// sum dist amount
								cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
								// add vo to list
								cntrRtVOs.add(cntrRtVO);
							}
							// check total amount and distributed amount
							if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
								log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
							} else {
								log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
							}
							// sum of container amount
							cntr_ttl_amt += cntr_dist_vol;
						} else {
							cntr_vol_sum = 0F;
							al = new ArrayList<CntrRtCntrVO>();
							for (int m = 0; m < cntrCnt; m++) {
								CntrRtCntrVO cntrVO = cntrVOs.get(m);
								if (cntrVO.getEqSubstTpszCd().endsWith("2") || cntrVO.getEqSubstTpszCd().endsWith("3")) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
							}

							if (cntr_vol_sum > 0) {
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							} else {
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							}
						}

						// 'E' Type
					} else if ("40".equals(rat_ut_cd)) {
						float cntr_vol_sum = 0F;
						ArrayList<CntrRtCntrVO> al = new ArrayList<CntrRtCntrVO>();
						ArrayList<String> ratUtCd40List = (ArrayList<String>)ratUtCdMap.get(chg_cd);
			
						for (int m = 0; m < cntrCnt; m++) {
							CntrRtCntrVO cntrVO = cntrVOs.get(m);
							// 'DG' Cargo
							if ("DG".equals(cgo_cate_cd)) {
								if ((cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")) && "Y".equals(cntrVO.getDcgoFlg())) {
									// Initialize the flag45, bfChgCd if Next Container Type is NOT 4  
									if("40".equals(ratUtCd40List.get(m))){
										if(m != (ratUtCd40List.size()-1) &&  !"40".equals(ratUtCd40List.get(m+1))){
											flag45 = "";
											bfChgCd = "";
										}
									}
									// Except the Container if D5,D4 is calculated before
									if(bfChgCd.equals(chg_cd) && (flag45.equals(cntrVO.getEqSubstTpszCd())))
										continue;

									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'RF' Cargo
							} else if ("RF".equals(cgo_cate_cd)) {
								if ((cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")) && "Y".equals(cntrVO.getRcFlg())) {
									// Initialize the flag45, bfChgCd if Next Container Type is NOT 4  
									if("40".equals(ratUtCd40List.get(m))){
										if(m != (ratUtCd40List.size()-1) &&  !"40".equals(ratUtCd40List.get(m+1))){
											flag45 = "";
											bfChgCd = "";
										}
									}
									
									if(bfChgCd.equals(chg_cd) && (flag45.equals(cntrVO.getEqSubstTpszCd())))
										continue;
									// Except the Container if D5,D4 is calculated before
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'AK' Cargo
							} else if ("AK".equals(cgo_cate_cd)) {
								if ((cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")) && "Y".equals(cntrVO.getAwkCgoFlg())) {
									// Initialize the flag45, bfChgCd if Next Container Type is NOT 4  
									if("40".equals(ratUtCd40List.get(m))){
										if(m != (ratUtCd40List.size()-1) &&  !"40".equals(ratUtCd40List.get(m+1))){
											flag45 = "";
											bfChgCd = "";
										}
									}
									
									if(bfChgCd.equals(chg_cd) && (flag45.equals(cntrVO.getEqSubstTpszCd())))
										continue;
									// Except the Container if D5,D4 is calculated before
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'BB' Cargo
							} else if ("BB".equals(cgo_cate_cd)) {
								if ((cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")) && "Y".equals(cntrVO.getBbCgoFlg())) {
									// Initialize the flag45, bfChgCd if Next Container Type is NOT 4  
									if("40".equals(ratUtCd40List.get(m))){
										if(m != (ratUtCd40List.size()-1) &&  !"40".equals(ratUtCd40List.get(m+1))){
											flag45 = "";
											bfChgCd = "";
										}
									}
									
									if(bfChgCd.equals(chg_cd) && (flag45.equals(cntrVO.getEqSubstTpszCd())))
										continue;
									// Except the Container if D5,D4 is calculated before
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'DR' Cargo
							} else {
								if ((cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")) && "N".equals(cntrVO.getDcgoFlg()) && "N".equals(cntrVO.getRcFlg()) && "N".equals(cntrVO.getAwkCgoFlg()) && "N".equals(cntrVO.getBbCgoFlg())) {
									// Initialize the flag45, bfChgCd if Next Container Type is NOT 4  
									if("40".equals(ratUtCd40List.get(m))){
										if(m != (ratUtCd40List.size()-1) &&  !"40".equals(ratUtCd40List.get(m+1))){
											flag45 = "";
											bfChgCd = "";
										}
									}

									if(bfChgCd.equals(chg_cd) && (flag45.equals(cntrVO.getEqSubstTpszCd()))){
										continue;
									}
									// Except the Container if D5,D4 is calculated before
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
							}
						}
						
						if (cntr_vol_sum > 0) {
							float cntr_dist_vol = 0F;
							List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
							for (int n = 0; n < tempRtVOs.size(); n++) {
								BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
								// sum dist amount
								cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
								// add vo to list
								cntrRtVOs.add(cntrRtVO);
							}
							// check total amount and distributed amount
							// if(chg_amt == cntr_dist_vol){
							if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
								log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
							} else {
								log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
							}
							// sum of container amount
							cntr_ttl_amt += cntr_dist_vol;
						} else {
							cntr_vol_sum = 0F;
							al = new ArrayList<CntrRtCntrVO>();
							for (int m = 0; m < cntrCnt; m++) {
								CntrRtCntrVO cntrVO = cntrVOs.get(m);
								if (cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
							}

							if (cntr_vol_sum > 0) {
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							} else {
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							}
						}

						// 'E' Type
					} else if ("45".equals(rat_ut_cd)) {
						float cntr_vol_sum = 0F;
						ArrayList<CntrRtCntrVO> al = new ArrayList<CntrRtCntrVO>();
						for (int m = 0; m < cntrCnt; m++) {
							CntrRtCntrVO cntrVO = cntrVOs.get(m);
							// 'DG' Cargo
							if ("DG".equals(cgo_cate_cd)) {
								if (cntrVO.getEqSubstTpszCd().endsWith("7") && "Y".equals(cntrVO.getDcgoFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'RF' Cargo
							} else if ("RF".equals(cgo_cate_cd)) {
								if (cntrVO.getEqSubstTpszCd().endsWith("7") && "Y".equals(cntrVO.getRcFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'AK' Cargo
							} else if ("AK".equals(cgo_cate_cd)) {
								if (cntrVO.getEqSubstTpszCd().endsWith("7") && "Y".equals(cntrVO.getAwkCgoFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'BB' Cargo
							} else if ("BB".equals(cgo_cate_cd)) {
								if (cntrVO.getEqSubstTpszCd().endsWith("7") && "Y".equals(cntrVO.getBbCgoFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
								// 'DR' Cargo
							} else {
								if (cntrVO.getEqSubstTpszCd().endsWith("7") && "N".equals(cntrVO.getDcgoFlg()) && "N".equals(cntrVO.getRcFlg()) && "N".equals(cntrVO.getAwkCgoFlg()) && "N".equals(cntrVO.getBbCgoFlg())) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
							}
						}

						if (cntr_vol_sum > 0) {
							float cntr_dist_vol = 0F;
							List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
							for (int n = 0; n < tempRtVOs.size(); n++) {
								BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
								// sum dist amount
								cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
								// add vo to list
								cntrRtVOs.add(cntrRtVO);
							}
							// check total amount and distributed amount
							if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
								log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
							} else {
								log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
							}
							// sum of container amount
							cntr_ttl_amt += cntr_dist_vol;
						} else {
							cntr_vol_sum = 0F;
							al = new ArrayList<CntrRtCntrVO>();
							for (int m = 0; m < cntrCnt; m++) {
								CntrRtCntrVO cntrVO = cntrVOs.get(m);
								if (cntrVO.getEqSubstTpszCd().endsWith("7")) {
									cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
									al.add(cntrVO);
									log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
								}
							}

							if (cntr_vol_sum > 0) {
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							} else {
								float cntr_dist_vol = 0F;
								List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
								for (int n = 0; n < tempRtVOs.size(); n++) {
									BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
									// sum dist amount
									cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
									// add vo to list
									cntrRtVOs.add(cntrRtVO);
								}
								// check total amount and distributed amount
								if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
									log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
								} else {
									log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
								}
								// sum of container amount
								cntr_ttl_amt += cntr_dist_vol;
							}
						}

						// 'P' Type
					} else if ("BX".equals(rat_ut_cd) || "UN".equals(rat_ut_cd) || "CT".equals(rat_ut_cd)) {
						float cntr_dist_vol = 0F;
						List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
						for (int n = 0; n < tempRtVOs.size(); n++) {
							BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
							// sum dist amount
							cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
							// add vo to list
							cntrRtVOs.add(cntrRtVO);
						}
						// check total amount and distributed amount
						if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
							log.debug("!!! 'P' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
						} else {
							log.debug("!!! 'P' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
						}
						// sum of container amount
						cntr_ttl_amt += cntr_dist_vol;

						// 'R' Type
					} else if ("RM".equals(rat_ut_cd)) {
						float cntr_dist_vol = 0F;
						List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
						for (int n = 0; n < tempRtVOs.size(); n++) {
							BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
							// sum dist amount
							cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
							// add vo to list
							cntrRtVOs.add(cntrRtVO);
						}
						// check total amount and distributed amount
						if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
							log.debug("!!! 'R' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
						} else {
							log.debug("!!! 'R' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
						}
						// sum of container amount
						cntr_ttl_amt += cntr_dist_vol;

						// 'W' Type
					} else if ("MT".equals(rat_ut_cd) || "ST".equals(rat_ut_cd) || "TN".equals(rat_ut_cd) || "LB".equals(rat_ut_cd)) {
						float cntr_wgt_sum = 0F;
						for (int m = 0; m < cntrCnt; m++) {
							cntr_wgt_sum += (cntrVOs.get(m).getCntrWgt() == null || "".equals(cntrVOs.get(m).getCntrWgt())) ? 0 : Float.parseFloat(cntrVOs.get(m).getCntrWgt());
						}

						float cntr_dist_wgt = 0F;
						List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByWeight(chgRateVO, cntr_wgt_sum, cntrVOs);
						for (int n = 0; n < tempRtVOs.size(); n++) {
							BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
							// sum dist amount
							cntr_dist_wgt += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
							// add vo to list
							cntrRtVOs.add(cntrRtVO);
						}
						// check total amount and distributed amount
						if (Float.compare(chg_amt, cntr_dist_wgt) == 0) {
							log.debug("!!! 'W' Type - OK : " + chg_amt + " = " + cntr_dist_wgt);
						} else {
							log.debug("!!! 'W' Type - NO : " + chg_amt + " = " + cntr_dist_wgt);
						}
						// sum of container amount
						cntr_ttl_amt += cntr_dist_wgt;

						// 'M' Type
					} else if ("CM".equals(rat_ut_cd) || "BM".equals(rat_ut_cd)) {
						float cntr_meas_sum = 0F;
						for (int m = 0; m < cntrCnt; m++) {
							cntr_meas_sum += (cntrVOs.get(m).getMeasQty() == null || "".equals(cntrVOs.get(m).getMeasQty())) ? 0 : Float.parseFloat(cntrVOs.get(m).getMeasQty());
						}

						float cntr_dist_meas = 0F;
						List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByMeasure(chgRateVO, cntr_meas_sum, cntrVOs);
						for (int n = 0; n < tempRtVOs.size(); n++) {
							BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
							// sum dist amount
							cntr_dist_meas += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
							// add vo to list
							cntrRtVOs.add(cntrRtVO);
						}
						// check total amount and distributed amount
						if (Float.compare(chg_amt, cntr_dist_meas) == 0) {
							log.debug("!!! 'M' Type - OK : " + chg_amt + " = " + cntr_dist_meas);
						} else {
							log.debug("!!! 'M' Type - NO : " + chg_amt + " = " + cntr_dist_meas);
						}
						// sum of container amount
						cntr_ttl_amt += cntr_dist_meas;

						// error!
					} else {
						// log.error("! ERROR ! - '" + rat_ut_cd +
						// "' Is Invalid Rating Unit!!!");
					}

				} else {
					float cntr_vol_sum = 0F;
					ArrayList<CntrRtCntrVO> al = new ArrayList<CntrRtCntrVO>();

					for (int m = 0; m < cntrCnt; m++) {
						CntrRtCntrVO cntrVO = cntrVOs.get(m);

						// 'DG' Cargo
						if ("DG".equals(cgo_cate_cd)) {
							if (rat_ut_cd.equals(cntrVO.getEqSubstTpszCd()) && "Y".equals(cntrVO.getDcgoFlg())) {
								// Setting the 'Before value' for accurate calculation if the CNTR Type is D5 or D4
								if(cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")){
									flag45 = cntrVO.getEqSubstTpszCd();
									bfChgCd = chg_cd;
								}

								cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
								al.add(cntrVO);
								log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
							}
							// 'RF' Cargo
						} else if ("RF".equals(cgo_cate_cd)) {
							if (rat_ut_cd.equals(cntrVO.getEqSubstTpszCd()) && "Y".equals(cntrVO.getRcFlg())) {
								// Setting the 'Before value' for accurate calculation if the CNTR Type is D5 or D4
								if(cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")){
									flag45 = cntrVO.getEqSubstTpszCd();
									bfChgCd = chg_cd;
								}

								cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
								al.add(cntrVO);
								log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
							}
							// 'AK' Cargo
						} else if ("AK".equals(cgo_cate_cd)) {
							if (rat_ut_cd.equals(cntrVO.getEqSubstTpszCd()) && "Y".equals(cntrVO.getAwkCgoFlg())) {
								// Setting the 'Before value' for accurate calculation if the CNTR Type is D5 or D4
								if(cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")){
									flag45 = cntrVO.getEqSubstTpszCd();
									bfChgCd = chg_cd;
								}
								
								cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
								al.add(cntrVO);
								log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
							}
							// 'BB' Cargo
						} else if ("BB".equals(cgo_cate_cd)) {
							if (rat_ut_cd.equals(cntrVO.getEqSubstTpszCd()) && "Y".equals(cntrVO.getBbCgoFlg())) {
								// Setting the 'Before value' for accurate calculation if the CNTR Type is D5 or D4
								if(cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")){
									flag45 = cntrVO.getEqSubstTpszCd();
									bfChgCd = chg_cd;
								}

								cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
								al.add(cntrVO);
								log.debug("::" + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_vol_sum);
							}
							// 'DR' Cargo
						} else {
							if (rat_ut_cd.equals(cntrVO.getEqSubstTpszCd()) && "N".equals(cntrVO.getDcgoFlg()) && "N".equals(cntrVO.getRcFlg()) && "N".equals(cntrVO.getAwkCgoFlg()) && "N".equals(cntrVO.getBbCgoFlg())) {
								// Setting the 'Before value' for accurate calculation if the CNTR Type is D5 or D4
								if(cntrVO.getEqSubstTpszCd().endsWith("4") || cntrVO.getEqSubstTpszCd().endsWith("5")){
									flag45 = cntrVO.getEqSubstTpszCd();
									bfChgCd = chg_cd;
								}

								cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
								al.add(cntrVO);
								log.debug("::" + rat_ut_cd + "->" + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") -" + cntr_vol_sum + ")");
							}
						}
					}

					if (cntr_vol_sum > 0) {
						float cntr_dist_vol = 0F;
						List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
						for (int n = 0; n < tempRtVOs.size(); n++) {
							BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
							// sum dist amount
							cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
							// add vo to list
							cntrRtVOs.add(cntrRtVO);
						}
						// check total amount and distributed amount
						if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
							log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
						} else {
							log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
						}
						// sum of container amount
						cntr_ttl_amt += cntr_dist_vol;
					} else {
						cntr_vol_sum = 0F;
						al = new ArrayList<CntrRtCntrVO>();
						for (int m = 0; m < cntrCnt; m++) {
							CntrRtCntrVO cntrVO = cntrVOs.get(m);
							if (rat_ut_cd.equals(cntrVO.getEqSubstTpszCd())) {
								cntr_vol_sum += (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
								al.add(cntrVO);
								log.debug(":::::add>" + cntrVO.getCntrNo() + ":" + cntrVO.getCntrTpszCd() + "(" + cntr_vol_sum + ")");
							}
						}

						if (cntr_vol_sum > 0) {
							float cntr_dist_vol = 0F;
							List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntr_vol_sum, al);
							for (int n = 0; n < tempRtVOs.size(); n++) {
								BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
								// sum dist amount
								cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
								// add vo to list
								cntrRtVOs.add(cntrRtVO);
							}
							// check total amount and distributed amount
							if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
								log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
							} else {
								log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
							}
							// sum of container amount
							cntr_ttl_amt += cntr_dist_vol;
						} else {
							float cntr_dist_vol = 0F;
							List<BkgCntrRtVO> tempRtVOs = this.distributeChargeByVolumn(chgRateVO, cntrTtlVol, cntrVOs);
							for (int n = 0; n < tempRtVOs.size(); n++) {
								BkgCntrRtVO cntrRtVO = tempRtVOs.get(n);
								// sum dist amount
								cntr_dist_vol += (cntrRtVO.getChgAmt() == null || "".equals(cntrRtVO.getChgAmt())) ? 0 : Float.parseFloat(cntrRtVO.getChgAmt());
								// add vo to list
								cntrRtVOs.add(cntrRtVO);
							}
							// check total amount and distributed amount
							if (Float.compare(chg_amt, cntr_dist_vol) == 0) {
								log.debug("!!! 'E' Type - OK : " + chg_amt + " = " + cntr_dist_vol);
							} else {
								log.debug("!!! 'E' Type - NO : " + chg_amt + " = " + cntr_dist_vol);
							}
							// sum of container amount
							cntr_ttl_amt += cntr_dist_vol;
						}
					}
				}// end of IF - CntrTpsz
			} // end of FOR

			/* 6. validate rate amount */
			log.debug("***** 6. VALIDATE CHARGE AMOUNT");

			/* 7. update/insert bkg_cntr_rt */

			if (cntrRtVOs.size() > 0) {
				// remove CntrRate
				for (int m = 0; m < cntrRtVOs.size(); m++) {
					log.debug("***** 7. BkgChgRateVO : ChgCd = " + cntrRtVOs.get(m).getChgCd() + ", CurrCd = " + cntrRtVOs.get(m).getCurrCd() + ", ChgUtAmt = " + cntrRtVOs.get(m).getChgUtAmt() + ", RatAsQty = " + cntrRtVOs.get(m).getRatAsQty() + ", RatUtCd = " + cntrRtVOs.get(m).getRatUtCd()
							+ ", ChgAmt = " + cntrRtVOs.get(m).getChgAmt() + ", FrtTermCd = " + cntrRtVOs.get(m).getFrtTermCd() + ", CgoCateCd = " + cntrRtVOs.get(m).getCgoCateCd() + ", ImdgClssCd = " + cntrRtVOs.get(m).getImdgClssCd() + ", MstBkgNo = " + cntrRtVOs.get(m).getMstBkgNo());
					// set user id
					cntrRtVOs.get(m).setCreUsrId(userId);
					// create new
					dbDao.addCntrRt(cntrRtVOs.get(m), caFlag);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Volumn 
	 * @param chgRateVO
	 * @param cntr_vol_sum
	 * @param cntrVOs
	 * @return List<BkgCntrRtVO>
	 */
	private List<BkgCntrRtVO> distributeChargeByVolumn(CntrRtBkgChgVO chgRateVO, float cntr_vol_sum, List<CntrRtCntrVO> cntrVOs) {

		List<BkgCntrRtVO> tempRtVOs = new ArrayList<BkgCntrRtVO>();

		// String chg_cd = chgRateVO.getChgCd();
		float chg_ut_amt = (chgRateVO.getChgUtAmt() == null || "".equals(chgRateVO.getChgUtAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgUtAmt());
		float rat_as_qty = (chgRateVO.getRatAsQty() == null || "".equals(chgRateVO.getRatAsQty())) ? 0 : Float.parseFloat(chgRateVO.getRatAsQty());
		float chg_amt = (chgRateVO.getChgAmt() == null || "".equals(chgRateVO.getChgAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgAmt());
		String rat_ut_cd = chgRateVO.getRatUtCd();
		// String cgo_cate_cd = chgRateVO.getCgoCateCd();

		float cntr_vol = 0F;
		float cntr_amt = 0F;
		float cntr_rate = 0F;
		float chk_sum1 = 0F;
		float chk_sum2 = 0F;

		int cntrCnt = (cntrVOs == null) ? 0 : cntrVOs.size();
		for (int m = 0; m < cntrCnt; m++) {
			CntrRtCntrVO cntrVO = cntrVOs.get(m);
			BkgCntrRtVO cntrRtVO = new BkgCntrRtVO();

			log.debug("distributeChargeByVolumn :"+m+":"+cntrVO.getBkgNo()+":"+cntrVO.getCntrVolQty()+":"+chgRateVO.getChgCd());

			cntr_vol = (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());

			// check the last ratio
			if ((m + 1) == cntrCnt) {
				cntr_rate = rat_as_qty - chk_sum1;
				cntr_amt = chg_amt - chk_sum2;
			} else {
				cntr_rate = Math.round(rat_as_qty * cntr_vol / cntr_vol_sum * 1000) / 1000F;
				cntr_amt = chg_ut_amt * cntr_rate;
			}
			log.debug("# volumn : " + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + rat_as_qty + " * " + cntr_vol + " / " + cntr_vol_sum + " = " + cntr_rate);
			log.debug("           " + rat_ut_cd + " -> " + chg_ut_amt + " * " + cntr_rate + " = " + cntr_amt);
			// set cntr_rate amt_info
			cntrRtVO.setChgUtAmt(String.valueOf(chg_ut_amt));
			cntrRtVO.setRatAsQty(String.valueOf(cntr_rate));
			cntrRtVO.setRatUtCd(rat_ut_cd);
			cntrRtVO.setChgAmt(String.valueOf(cntr_amt));
			// set cntr_rate etc_info
			cntrRtVO.setChgCd(chgRateVO.getChgCd());
			cntrRtVO.setCurrCd(chgRateVO.getCurrCd());
			cntrRtVO.setFrtInclXcldDivCd(chgRateVO.getFrtInclXcldDivCd());
			cntrRtVO.setFrtTermCd(chgRateVO.getFrtTermCd());
			cntrRtVO.setN3ptyRcvOfcCd(chgRateVO.getN3ptyRcvOfcCd());
			cntrRtVO.setN3ptyCustCntCd(chgRateVO.getN3ptyCustCntCd());
			cntrRtVO.setN3ptyCustSeq(chgRateVO.getN3ptyCustSeq());
			cntrRtVO.setCgoCateCd(chgRateVO.getCgoCateCd());
			cntrRtVO.setRcvTermCd(chgRateVO.getRcvTermCd());
			cntrRtVO.setDeTermCd(chgRateVO.getDeTermCd());
			cntrRtVO.setImdgClssCd(chgRateVO.getImdgClssCd());
			cntrRtVO.setAutoRatCd(chgRateVO.getAutoRatCd());
			cntrRtVO.setPrnHdnFlg(chgRateVO.getPrnHdnFlg());
			cntrRtVO.setDpSeq(chgRateVO.getDpSeq());
			cntrRtVO.setInvStsCd(chgRateVO.getInvStsCd());
			cntrRtVO.setAplyXchRto(chgRateVO.getAplyXchRto());
			cntrRtVO.setAgmtRatUtCd(chgRateVO.getAgmtRatUtCd());
			cntrRtVO.setBkgNo(cntrVO.getBkgNo());
			cntrRtVO.setMstBkgNo(cntrVO.getMstCvrdBlNo());
			cntrRtVO.setCntrNo(cntrVO.getCntrNo());
			cntrRtVO.setCntrTpszCd(cntrVO.getCntrTpszCd());
			cntrRtVO.setBkgQty(cntrVO.getCntrVolQty());
			// add vo to list
			tempRtVOs.add(cntrRtVO);
			// check sum
			chk_sum1 += cntr_rate;
			chk_sum2 += cntr_amt;
		}

		return tempRtVOs;
	}

	/**
	 * Weight 
	 * @param chgRateVO
	 * @param cntr_vol_sum
	 * @param cntrVOs
	 * @return List<BkgCntrRtVO>
	 */
	private List<BkgCntrRtVO> distributeChargeByWeight(CntrRtBkgChgVO chgRateVO, float cntr_wgt_sum, List<CntrRtCntrVO> cntrVOs) {

		List<BkgCntrRtVO> tempRtVOs = new ArrayList<BkgCntrRtVO>();

		// String chg_cd = chgRateVO.getChgCd();
		float chg_ut_amt = (chgRateVO.getChgUtAmt() == null || "".equals(chgRateVO.getChgUtAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgUtAmt());
		float rat_as_qty = (chgRateVO.getRatAsQty() == null || "".equals(chgRateVO.getRatAsQty())) ? 0 : Float.parseFloat(chgRateVO.getRatAsQty());
		float chg_amt = (chgRateVO.getChgAmt() == null || "".equals(chgRateVO.getChgAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgAmt());
		String rat_ut_cd = chgRateVO.getRatUtCd();
		// String cgo_cate_cd = chgRateVO.getCgoCateCd();

		float cntr_wgt = 0F;
		float cntr_amt = 0F;
		float cntr_rate = 0F;
		float chk_sum1 = 0F;
		float chk_sum2 = 0F;

		int cntrCnt = (cntrVOs == null) ? 0 : cntrVOs.size();
		for (int m = 0; m < cntrCnt; m++) {
			CntrRtCntrVO cntrVO = cntrVOs.get(m);
			BkgCntrRtVO cntrRtVO = new BkgCntrRtVO();

			cntr_wgt = (cntrVO.getCntrWgt() == null || "".equals(cntrVO.getCntrWgt())) ? 0 : Float.parseFloat(cntrVO.getCntrWgt());

			// check the last ratio
			if ((m + 1) == cntrCnt) {
				cntr_rate = rat_as_qty - chk_sum1;
				cntr_amt = chg_amt - chk_sum2;
			} else {
				cntr_rate = Math.round(rat_as_qty * cntr_wgt / cntr_wgt_sum * 1000) / 1000F;
				cntr_amt = chg_ut_amt * cntr_rate;
			}
			log.debug("# weight : " + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + rat_as_qty + " * " + cntr_wgt + " / " + cntr_wgt_sum + " = " + cntr_rate);
			log.debug("           " + rat_ut_cd + " -> " + chg_ut_amt + " * " + cntr_rate + " = " + cntr_amt);
			// set cntr_rate amt_info
			cntrRtVO.setChgUtAmt(String.valueOf(chg_ut_amt));
			cntrRtVO.setRatAsQty(String.valueOf(cntr_rate));
			cntrRtVO.setRatUtCd(rat_ut_cd);
			cntrRtVO.setChgAmt(String.valueOf(cntr_amt));
			// set cntr_rate etc_info
			cntrRtVO.setChgCd(chgRateVO.getChgCd());
			cntrRtVO.setCurrCd(chgRateVO.getCurrCd());
			cntrRtVO.setFrtInclXcldDivCd(chgRateVO.getFrtInclXcldDivCd());
			cntrRtVO.setFrtTermCd(chgRateVO.getFrtTermCd());
			cntrRtVO.setN3ptyRcvOfcCd(chgRateVO.getN3ptyRcvOfcCd());
			cntrRtVO.setN3ptyCustCntCd(chgRateVO.getN3ptyCustCntCd());
			cntrRtVO.setN3ptyCustSeq(chgRateVO.getN3ptyCustSeq());
			cntrRtVO.setCgoCateCd(chgRateVO.getCgoCateCd());
			cntrRtVO.setRcvTermCd(chgRateVO.getRcvTermCd());
			cntrRtVO.setDeTermCd(chgRateVO.getDeTermCd());
			cntrRtVO.setImdgClssCd(chgRateVO.getImdgClssCd());
			cntrRtVO.setAutoRatCd(chgRateVO.getAutoRatCd());
			cntrRtVO.setPrnHdnFlg(chgRateVO.getPrnHdnFlg());
			cntrRtVO.setDpSeq(chgRateVO.getDpSeq());
			cntrRtVO.setInvStsCd(chgRateVO.getInvStsCd());
			cntrRtVO.setAplyXchRto(chgRateVO.getAplyXchRto());
			cntrRtVO.setAgmtRatUtCd(chgRateVO.getAgmtRatUtCd());
			cntrRtVO.setBkgNo(cntrVO.getBkgNo());
			cntrRtVO.setMstBkgNo(cntrVO.getMstCvrdBlNo());
			cntrRtVO.setCntrNo(cntrVO.getCntrNo());
			cntrRtVO.setCntrTpszCd(cntrVO.getCntrTpszCd());
			cntrRtVO.setBkgQty(cntrVO.getCntrVolQty());
			// add vo to list
			tempRtVOs.add(cntrRtVO);
			// check sum
			chk_sum1 += cntr_rate;
			chk_sum2 += cntr_amt;
		}

		return tempRtVOs;
	}

	/**
	 * Measure 
	 * @param chgRateVO
	 * @param cntr_vol_sum
	 * @param cntrVOs
	 * @return List<BkgCntrRtVO>
	 */
	private List<BkgCntrRtVO> distributeChargeByMeasure(CntrRtBkgChgVO chgRateVO, float cntr_meas_sum, List<CntrRtCntrVO> cntrVOs) {

		List<BkgCntrRtVO> tempRtVOs = new ArrayList<BkgCntrRtVO>();

		// String chg_cd = chgRateVO.getChgCd();
		float chg_ut_amt = (chgRateVO.getChgUtAmt() == null || "".equals(chgRateVO.getChgUtAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgUtAmt());
		float rat_as_qty = (chgRateVO.getRatAsQty() == null || "".equals(chgRateVO.getRatAsQty())) ? 0 : Float.parseFloat(chgRateVO.getRatAsQty());
		float chg_amt = (chgRateVO.getChgAmt() == null || "".equals(chgRateVO.getChgAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgAmt());
		String rat_ut_cd = chgRateVO.getRatUtCd();
		// String cgo_cate_cd = chgRateVO.getCgoCateCd();

		float cntr_meas = 0F;
		float cntr_amt = 0F;
		float cntr_rate = 0F;
		float chk_sum1 = 0F;
		float chk_sum2 = 0F;

		int cntrCnt = (cntrVOs == null) ? 0 : cntrVOs.size();
		for (int m = 0; m < cntrCnt; m++) {
			CntrRtCntrVO cntrVO = cntrVOs.get(m);
			BkgCntrRtVO cntrRtVO = new BkgCntrRtVO();

			cntr_meas = (cntrVO.getMeasQty() == null || "".equals(cntrVO.getMeasQty())) ? 0 : Float.parseFloat(cntrVO.getMeasQty());

			// check the last ratio
			if ((m + 1) == cntrCnt) {
				cntr_rate = rat_as_qty - chk_sum1;
				cntr_amt = chg_amt - chk_sum2;
			} else {
				cntr_rate = Math.round(rat_as_qty * cntr_meas / cntr_meas_sum * 1000) / 1000F;
				cntr_amt = chg_ut_amt * cntr_rate;
			}
			log.debug("# measure : " + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + rat_as_qty + " * " + cntr_meas + " / " + cntr_meas_sum + " = " + cntr_rate);
			log.debug("            " + rat_ut_cd + " -> " + chg_ut_amt + " * " + cntr_rate + " = " + cntr_amt);
			// set cntr_rate amt_info
			cntrRtVO.setChgUtAmt(String.valueOf(chg_ut_amt));
			cntrRtVO.setRatAsQty(String.valueOf(cntr_rate));
			cntrRtVO.setRatUtCd(rat_ut_cd);
			cntrRtVO.setChgAmt(String.valueOf(cntr_amt));
			// set cntr_rate etc_info
			cntrRtVO.setChgCd(chgRateVO.getChgCd());
			cntrRtVO.setCurrCd(chgRateVO.getCurrCd());
			cntrRtVO.setFrtInclXcldDivCd(chgRateVO.getFrtInclXcldDivCd());
			cntrRtVO.setFrtTermCd(chgRateVO.getFrtTermCd());
			cntrRtVO.setN3ptyRcvOfcCd(chgRateVO.getN3ptyRcvOfcCd());
			cntrRtVO.setN3ptyCustCntCd(chgRateVO.getN3ptyCustCntCd());
			cntrRtVO.setN3ptyCustSeq(chgRateVO.getN3ptyCustSeq());
			cntrRtVO.setCgoCateCd(chgRateVO.getCgoCateCd());
			cntrRtVO.setRcvTermCd(chgRateVO.getRcvTermCd());
			cntrRtVO.setDeTermCd(chgRateVO.getDeTermCd());
			cntrRtVO.setImdgClssCd(chgRateVO.getImdgClssCd());
			cntrRtVO.setAutoRatCd(chgRateVO.getAutoRatCd());
			cntrRtVO.setPrnHdnFlg(chgRateVO.getPrnHdnFlg());
			cntrRtVO.setDpSeq(chgRateVO.getDpSeq());
			cntrRtVO.setInvStsCd(chgRateVO.getInvStsCd());
			cntrRtVO.setAplyXchRto(chgRateVO.getAplyXchRto());
			cntrRtVO.setAgmtRatUtCd(chgRateVO.getAgmtRatUtCd());
			cntrRtVO.setBkgNo(cntrVO.getBkgNo());
			cntrRtVO.setMstBkgNo(cntrVO.getMstCvrdBlNo());
			cntrRtVO.setCntrNo(cntrVO.getCntrNo());
			cntrRtVO.setCntrTpszCd(cntrVO.getCntrTpszCd());
			cntrRtVO.setBkgQty(cntrVO.getCntrVolQty());
			// add vo to list
			tempRtVOs.add(cntrRtVO);
			// check sum
			chk_sum1 += cntr_rate;
			chk_sum2 += cntr_amt;
		}

		return tempRtVOs;
	}

	/**
	 * Percent 
	 * 
	 * @param CntrRtBkgChgVO chgRateVO
	 * @param float oft_amt
	 * @param float oft_sum
	 * @param float cntr_vol_sum
	 * @param List   <CntrRtCntrVO> cntrVOs
	 * @return List<BkgCntrRtVO>
	 */
	private List<BkgCntrRtVO> distributeChargeByPercent(CntrRtBkgChgVO chgRateVO, float oft_amt, float oft_sum, float cntr_vol_sum, List<CntrRtCntrVO> cntrVOs) {

		List<BkgCntrRtVO> tempRtVOs = new ArrayList<BkgCntrRtVO>();

		// String chg_cd = chgRateVO.getChgCd();
		// float chg_ut_amt = (chgRateVO.getChgUtAmt()==null ||
		// "".equals(chgRateVO.getChgUtAmt())) ? 0 :
		// Float.parseFloat(chgRateVO.getChgUtAmt());
		float rat_as_qty = (chgRateVO.getRatAsQty() == null || "".equals(chgRateVO.getRatAsQty())) ? 0 : Float.parseFloat(chgRateVO.getRatAsQty());
		float chg_amt = (chgRateVO.getChgAmt() == null || "".equals(chgRateVO.getChgAmt())) ? 0 : Float.parseFloat(chgRateVO.getChgAmt());
		String rat_ut_cd = chgRateVO.getRatUtCd();
		// String cgo_cate_cd = chgRateVO.getCgoCateCd();

		float cntr_vol = 0F;
		float cntr_ut_amt = 0F;
		float cntr_amt = 0F;
		// float cntr_rate = 0F;

		int cntrCnt = (cntrVOs == null) ? 0 : cntrVOs.size();
		for (int m = 0; m < cntrCnt; m++) {
			CntrRtCntrVO cntrVO = cntrVOs.get(m);
			BkgCntrRtVO cntrRtVO = new BkgCntrRtVO();

			// container volumn
			cntr_vol = (cntrVO.getCntrVolQty() == null || "".equals(cntrVO.getCntrVolQty())) ? 0 : Float.parseFloat(cntrVO.getCntrVolQty());
			// check the last ratio
			cntr_amt = Math.round(oft_amt * chg_amt / oft_sum * cntr_vol / cntr_vol_sum * 100) / 100F;
			cntr_ut_amt = Math.round(cntr_amt * 100 / rat_as_qty * 100) / 100F;
			log.debug("# percent : " + rat_ut_cd + " -> " + cntrVO.getCntrNo() + "(" + cntrVO.getCntrTpszCd() + ") : " + cntr_amt + " * 100 / " + rat_as_qty + " = " + cntr_ut_amt);
			log.debug("            " + rat_ut_cd + " -> " + oft_amt + " * " + chg_amt + " / " + oft_sum + " * " + cntr_vol + " / " + cntr_vol_sum + " = " + cntr_amt);
			// set cntr_rate amt_info
			cntrRtVO.setChgUtAmt(String.valueOf(cntr_ut_amt));
			cntrRtVO.setRatAsQty(String.valueOf(rat_as_qty));
			cntrRtVO.setRatUtCd(rat_ut_cd);
			cntrRtVO.setChgAmt(String.valueOf(cntr_amt));
			// set cntr_rate etc_info
			cntrRtVO.setChgCd(chgRateVO.getChgCd());
			cntrRtVO.setCurrCd(chgRateVO.getCurrCd());
			cntrRtVO.setFrtInclXcldDivCd(chgRateVO.getFrtInclXcldDivCd());
			cntrRtVO.setFrtTermCd(chgRateVO.getFrtTermCd());
			cntrRtVO.setN3ptyRcvOfcCd(chgRateVO.getN3ptyRcvOfcCd());
			cntrRtVO.setN3ptyCustCntCd(chgRateVO.getN3ptyCustCntCd());
			cntrRtVO.setN3ptyCustSeq(chgRateVO.getN3ptyCustSeq());
			cntrRtVO.setCgoCateCd(chgRateVO.getCgoCateCd());
			cntrRtVO.setRcvTermCd(chgRateVO.getRcvTermCd());
			cntrRtVO.setDeTermCd(chgRateVO.getDeTermCd());
			cntrRtVO.setImdgClssCd(chgRateVO.getImdgClssCd());
			cntrRtVO.setAutoRatCd(chgRateVO.getAutoRatCd());
			cntrRtVO.setPrnHdnFlg(chgRateVO.getPrnHdnFlg());
			cntrRtVO.setDpSeq(chgRateVO.getDpSeq());
			cntrRtVO.setInvStsCd(chgRateVO.getInvStsCd());
			cntrRtVO.setAplyXchRto(chgRateVO.getAplyXchRto());
			cntrRtVO.setAgmtRatUtCd(chgRateVO.getAgmtRatUtCd());
			cntrRtVO.setBkgNo(cntrVO.getBkgNo());
			cntrRtVO.setMstBkgNo(cntrVO.getMstCvrdBlNo());
			cntrRtVO.setCntrNo(cntrVO.getCntrNo());
			cntrRtVO.setCntrTpszCd(cntrVO.getCntrTpszCd());
			cntrRtVO.setBkgQty(cntrVO.getCntrVolQty());
			// add vo to list
			tempRtVOs.add(cntrRtVO);
		}

		return tempRtVOs;
	}

	/**
	 * Modifying the exempted reason and exempted shipper Info of KOREA Wharfage
	 * 
	 * @param BlKrWhfExptVO  blKrWhfExptVO
	 * @param SignOnUserAccount  account
	 * @exception EventException
	 */
	@Override
	public void modifyBlKrWhfExpt(BlKrWhfExptVO blKrWhfExptVO, SignOnUserAccount account) throws EventException {
		try {

			blKrWhfExptVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyBlKrWhfExpt(blKrWhfExptVO);

		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Updating or Inserting the Wharfage Info 
	 * 
	 * @param BkgRateVO  bkgRateVO
	 * @exception EventException
	 */
	public void manageWhfExptInfo(BkgRateVO bkgRateVO) throws EventException {

		try {
			BkgRateVO rateVO = dbDao.searchWhfExptInfo(bkgRateVO);
			if (rateVO == null) {
				// INSERT
				dbDao.addWhfExptInfo(bkgRateVO);
			} else {
				// UPDATE
				dbDao.modifyWhfExptInfo(bkgRateVO);
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * manage Frt Term Cd
	 * @param String bkgNo
	 * @param String frtTermCd
	 * @param String frtTermPrnFlg
	 * @param SignOnUserAccount account
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageFrtTerm(String bkgNo, String frtTermCd, String frtTermPrnFlg, SignOnUserAccount account, String caFlg) throws EventException {
		try {
			if (dbDao.modifyFrtTerm(bkgNo, frtTermCd, frtTermPrnFlg, account.getUsr_id(), caFlg) == 0) {
				dbDao.addFrtTerm(bkgNo, frtTermCd, frtTermPrnFlg, account.getUsr_id(), caFlg);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rating Application Date Search.<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<SearchRatingApplyDateVO>
	 * @exception EventException
	 */

	public List<SearchRatingApplyDateVO> searchRatingApplyDate(String bkgNo,String caFlg) throws EventException {
		try {
			List<SearchRatingApplyDateVO> list1 = dbDao.searchRatingApplyDateList(bkgNo,caFlg);
			return list1;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * Searching the TPB Info<br>
	 * 
	 * @param String  bkgNo
	 * @param String   ntcSeq
	 * @return List<SearchTpbInfoVO>
	 * @exception EventException
	 */
	public List<SearchTpbInfoVO> searchTpbInfo(String bkgNo, String ntcSeq) throws EventException {
		try {
			return dbDao.searchTpbInfo(bkgNo, ntcSeq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Searching the Collect, 3rd Collect<br>
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<SearchFocByFreightListVO>
	 * @exception EventException
	 */
	public List<SearchFocByFreightListVO> searchFocByFreightList(String bkgNo, String caFlg) throws EventException {
		try {
			List<SearchFocByFreightListVO> list1 = dbDao.searchFocByFreightList(bkgNo,caFlg);
			return list1;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Updating the PPD, CLT CNT_CODE<br>
	 * 
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @param String caFlg
	 * @exception EventException
	 */
	public void modifyRateCntCd(String bkgNo, SignOnUserAccount account, String caFlg) throws EventException {
		try {
			if(!dbDao.checkChgRtExist(bkgNo, caFlg)){
				dbDao.modifyRateCntCd(bkgNo, account.getUsr_id(), caFlg);
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * callBkgModiIssOfcPrc
	 * @param  BkgModiOfcPrcVO bkgModiOfcPrcVO
	 * @throws EventException
	 */
    public void callBkgModiIssOfcPrc(BkgModiOfcPrcVO bkgModiOfcPrcVO) throws EventException {
		try {
			dbDao.callBkgModiIssOfcPrc(bkgModiOfcPrcVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

	/**
	 * callBkgModiChgOfcPrc
	 * @param  BkgModiOfcPrcVO bkgModiOfcPrcVO
	 * @throws EventException
	 */
    public void callBkgModiChgOfcPrc(BkgModiOfcPrcVO bkgModiOfcPrcVO) throws EventException {
		try {
			if(!dbDao.checkChgRtExist(bkgModiOfcPrcVO.getInBkgNo(), bkgModiOfcPrcVO.getInCaFlg())){
				dbDao.callBkgModiChgOfcPrc(bkgModiOfcPrcVO);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

	/**
	 * booking split 시 bkg_rate 테이블과 bkg_chg_rate 테이블의 manual rate 부분을 복사한다. <br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO[] targetBkg
	 * @param SignOnUserAccount account
	 * @param String splitRsnCd
	 * @throws EventException
	 */
	public void copyManualChgByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, SignOnUserAccount account, String splitRsnCd) throws EventException {
		try {
			for (int i = 0; i < targetBkg.length; i++) {
				if (!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())) {
					dbDao.copyBkgRateByBkg(sourceBkg, targetBkg[i], account);
					dbDao.createRateForTro(targetBkg[i].getBkgNo(),"N", account.getUsr_id());
					if("C".equals(splitRsnCd)){
						dbDao.copyManualChg(sourceBkg, targetBkg[i], account);
					}
				}
			}
		} catch (DAOException de) {
			// log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Searching Doc Adjustment<br>
	 * 
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caFlg
	 * @return List<DocLocVO>
	 * @exception EventException
	 */
	public List<DocLocVO> searchDocAdjInfo(RateMainInfoVO rateMainInfoVO, String caFlg) throws EventException {
		BkgBlNoVO bkgBlNoVO = null;
		List<DocLocVO> list = null;
		try{
			bkgBlNoVO = new BkgBlNoVO();
			
			bkgBlNoVO.setBkgNo(rateMainInfoVO.getBkgNo());
			bkgBlNoVO.setCaFlg(caFlg);
			
			list = dbDao.searchDocLoc(bkgBlNoVO);
			
		} catch (DAOException de) {
			// log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return list;
	}

	/**
	 * Updating Doc Adjustment<br>
	 * 
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caFlg
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageDocAdj(RateMainInfoVO rateMainInfoVO, String caFlg, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyDocLoc(rateMainInfoVO,caFlg,account);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}

	}    
	
	/**
	 * Saving the BKG list for recalculating TAX - exchange rate change<br>
	 * 
	 * @param List<BkgInvTaxIfVO> listVO
	 * @throws EventException
	 */
	public void addInvTaxIf(List<BkgInvTaxIfVO> listVO) throws EventException {
		try {
			dbDao.addInvTaxIf(listVO);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getMessage(), ex);
		}
		
	}    
	
	/**
	 * Saving the BKG list for recalculating TAX - exchange rate change<br>
	 * 
	 * @param BkgChgRateVO[] bkgChgRateVOs
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageTaxRateBatch(BkgChgRateVO[] bkgChgRateVOs, String bkgNo, SignOnUserAccount account) throws EventException{
		try {
			List<BkgChgRateVO> insertVoList = new ArrayList<BkgChgRateVO>();
			List<BkgChgRateVO> updateVoList = new ArrayList<BkgChgRateVO>();
			List<BkgChgRateVO> deleteVoList = new ArrayList<BkgChgRateVO>();

			for(int i=0; i<bkgChgRateVOs.length; i++){
				if (bkgChgRateVOs[i].getIbflag().equals("I")) {
					bkgChgRateVOs[i].setBkgNo(bkgNo);
					bkgChgRateVOs[i].setCreUsrId(account.getUsr_id());
					bkgChgRateVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(bkgChgRateVOs[i]);
				} else if (bkgChgRateVOs[i].getIbflag().equals("U")) {
					bkgChgRateVOs[i].setBkgNo(bkgNo);
					bkgChgRateVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(bkgChgRateVOs[i]);
				} else if (bkgChgRateVOs[i].getIbflag().equals("D")) {
					bkgChgRateVOs[i].setBkgNo(bkgNo);
					deleteVoList.add(bkgChgRateVOs[i]);
				}
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeChgRate(deleteVoList, "");
			}
			if (insertVoList.size() > 0) {
				dbDao.addChgRate(insertVoList, "");
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyChgRate(updateVoList, "");
			}
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * BKG_RATE<br>
	 * 
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caflag
	 * @exception DAOException
	 */
    public void modifyChgRateBkgRate(RateMainInfoVO rateMainInfoVO ,String caflag) throws EventException{
    	try{
    		dbDao.modifyChgRateBkgRate(rateMainInfoVO, caflag);
    	} catch (DAOException de) {
    		throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getMessage(), de);
    	} catch (Exception ex) {
    		throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getMessage(), ex);
    	}
    }
}
