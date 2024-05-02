/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtBCImpl.java
*@FileTitle : DEM/DET Adjustment Request - After Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration.ChargeAmountDiscountMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGCNTRRequestVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailInputVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGGRPVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListInputVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGRequestVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.BackEndJobResultVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerParmVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.CommentHistoryVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgBkgCntrVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCalcVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgTmCskStopVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCancelChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCombinedChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTGeneralChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBC;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBCImpl;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-DMTClosing Business Logic Basic Command implementation<br>
 * - handling business transaction OPUS-DMTClosing <br>
 *
 * @author 
 * @see reference DAO class of EES_DMT_2008EventResponse,ChargeAmountDiscountMgtBC
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtBCImpl extends BasicCommandSupport
		implements ChargeAmountDiscountMgtBC {

	// Database Access Object
	private transient	ChargeAmountDiscountMgtDBDAO	chgAmtDisMgtDBDAO	= null;
	
	private 	ChargeCalculationBC				chgCalcCommand		= null;
	private		InvoiceIssueCollectionMgtBC		invIssCommand		= null;
	
	
	/**
	 * ChargeCalculationBCImpl create object <br>
	 * creating ChargeCalculationDBDAO<br>
	 */
	public ChargeAmountDiscountMgtBCImpl() {
		chgAmtDisMgtDBDAO 		= new ChargeAmountDiscountMgtDBDAO();
		new DMTCalculationUtil();
		
		chgCalcCommand			= new ChargeCalculationBCImpl();
		invIssCommand			= new InvoiceIssueCollectionMgtBCImpl();
	}
	
	/**
	 * search After Booking list. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<AfterBKGListVO>
	 * @exception EventException
	 */
	public List<AfterBKGListVO> searchAfterBookingList(AfterBKGListInputVO afterBKGListInputVO) throws EventException {
		List<AfterBKGListVO> resultVOS = null;
		try {
			resultVOS = chgAmtDisMgtDBDAO.searchAfterBookingList(afterBKGListInputVO);
			if (resultVOS == null || resultVOS.size() < 1) {
				resultVOS = chgAmtDisMgtDBDAO.searchAfterBookingListInBooking(afterBKGListInputVO);
			}			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
		return resultVOS;
	}
	
	/**
	 * etc. info of After Booking  <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<AfterBKGListInputVO>
	 * @exception EventException
	 */
	public List<AfterBKGListInputVO> searchAfterBookingDAR(AfterBKGListInputVO afterBKGListInputVO) throws EventException {
		List<AfterBKGListInputVO> resultVOS = null;
		try {
			resultVOS = chgAmtDisMgtDBDAO.searchAfterBookingDAR(afterBKGListInputVO);
			if (resultVOS == null || resultVOS.size() < 1) {
				resultVOS = chgAmtDisMgtDBDAO.searchAfterBookingDARInBooking(afterBKGListInputVO);
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
		return resultVOS;
	}
	
	/**
	 * search CNTR. info of Booking No <br>
	 * 
	 * @param ChargeBookingContainerParmVO chargeBookingContainerParmVO
	 * @return List<ChargeBookingContainerVO>
	 * @exception EventException
	 */
	public List<ChargeBookingContainerVO> searchContainerChargeByBooking(
				ChargeBookingContainerParmVO chargeBookingContainerParmVO) throws EventException {
		
		try {
			return chgAmtDisMgtDBDAO.searchContainerChargeByBooking(chargeBookingContainerParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * search Quantity of CNTR.<br>
	 * 
	 * @param ChargeBookingContainerParmVO chargeBookingContainerParmVO
	 * @return List<ChargeBookingContainerVO>
	 * @exception EventException
	 */
	public List<ChargeBookingContainerVO> searchContainerQuantity(ChargeBookingContainerParmVO chargeBookingContainerParmVO) throws EventException {
		try {
			return chgAmtDisMgtDBDAO.searchContainerQuantity(chargeBookingContainerParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * search Currency of CNTR. <br>
	 * 
	 * @param ChargeBookingContainerParmVO chargeBookingContainerParmVO
	 * @return List<ChargeBookingContainerVO>
	 * @exception EventException
	 */
	public List<ChargeBookingContainerVO> searchContainerCurrency(ChargeBookingContainerParmVO chargeBookingContainerParmVO) throws EventException {
		try {
			return chgAmtDisMgtDBDAO.searchContainerCurrency(chargeBookingContainerParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * search Comment History <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<CommentHistoryVO>
	 * @exception EventException
	 */
	public List<CommentHistoryVO> searchCommentHistory(AfterBKGListInputVO afterBKGListInputVO) throws EventException {

		try {
			return chgAmtDisMgtDBDAO.searchCommentHistory(afterBKGListInputVO);
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * search Booking Data  <br>
	 * 
	 * @param AfterBKGDetailInputVO afterBKGDetailInputVO
	 * @return List<AfterBKGDetailVO>
	 * @exception EventException
	 */
	public List<AfterBKGDetailVO> searchBookingData(AfterBKGDetailInputVO afterBKGDetailInputVO) throws EventException {
		List<AfterBKGDetailVO> resultVOS = null;
		try {
			resultVOS = chgAmtDisMgtDBDAO.searchBookingData(afterBKGDetailInputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
		return resultVOS;
	}
	
	/**
	 * search Tariff Type of BKG/B/L No  <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkCalcuationType(AfterBKGListInputVO afterBKGListInputVO) throws EventException {
		boolean result = false;
		try {
			result = chgAmtDisMgtDBDAO.checkCalculationType(afterBKGListInputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
		return result;
	}
	
	/**
	 * search Location Code of BKG/B/L No Tariff Type <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLocationByBKGBLNo(AfterBKGListInputVO afterBKGListInputVO) throws EventException {
		String locCd = null;
		try {
			if (afterBKGListInputVO.getTariff().startsWith("DM")) {
				locCd = chgAmtDisMgtDBDAO.searchFromYardByBKGBLNo(afterBKGListInputVO);
				if ("".equals(locCd)) {
					locCd = chgAmtDisMgtDBDAO.searchLocationByBKGBLNo(afterBKGListInputVO);
				}
			}
			else {
				locCd = chgAmtDisMgtDBDAO.searchLocationByBKGBLNo(afterBKGListInputVO);
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
		return locCd;
	}
	
	/**
	 * Check duplication Tariff Type and  BKG or B/L No. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return String
	 * @exception EventException
	 */
	public String checkDupTariffBKGBLNo(AfterBKGListInputVO afterBKGListInputVO) throws EventException {
		try {
			return chgAmtDisMgtDBDAO.checkDupTariffBKGBLNo(afterBKGListInputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * check existing Balance Charge of CNTR  <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkBalanceCharge(AfterBKGListInputVO afterBKGListInputVO) throws EventException {
		try {
			return chgAmtDisMgtDBDAO.checkBalanceCharge(afterBKGListInputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Cancel  After Booking DAR <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void cancelAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException {
		try {
			chgAmtDisMgtDBDAO.modifyAfterBookingStatus(afterProgressVO);
			chgAmtDisMgtDBDAO.addCommentHistory(afterProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Approved After Booking DAR  <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void approveAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException {
		try {
			//1.change staus
			chgAmtDisMgtDBDAO.modifyAfterBookingStatus(afterProgressVO);
			//2.create History
			chgAmtDisMgtDBDAO.addCommentHistory(afterProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * do Calculate of approval After Booking <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @param SignOnUserAccount account
	 * @param DmtResultVO dmtResultVO
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */	
	public List<ChargeCalculationContainerVO> processCalculation(AfterProgressVO afterProgressVO, SignOnUserAccount account, DmtResultVO dmtResultVO) throws EventException {
		
		List<ChargeCalculationContainerVO> 		chgCalcContainerVOS 	= null;
		
		try {
			// Calculation case in approval #######################################################################################
			DMTGeneralChargeCalculationUtil 	dmtGeneralChargeCalcUtil 		= new DMTGeneralChargeCalculationUtil();
			DMTCombinedChargeCalculationUtil 	dmtCombinedChargeCalcUtil 		= new DMTCombinedChargeCalculationUtil();
			DMTCancelChargeCalculationUtil		dmtCancelChargeCalculationUtil 	= new DMTCancelChargeCalculationUtil();
			
			String 								darNo 							= null;
			ChargeArgumentVO 					chargeArgumentVO				= null;
			ChargeCalculationParmVO 			chgCalcParmVO 					= null;
			ChargeCalculationContainerVO 		chgCalcContainerVO 				= null;
			//List<ChargeBookingContainerVO> 		chgBKGContainerVOS 				= null;
			
			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			
			//1. search target. 
			chgCalcContainerVOS = chgAmtDisMgtDBDAO.searchChargeCalculationList(afterProgressVO.getAftExptDarNo());
			
			//1-1. handling target --------------------------------------------------------------------------------------------
			if (chgCalcContainerVOS != null && chgCalcContainerVOS.size() > 0) {
				for (int i = 0 ; i < chgCalcContainerVOS.size() ; i++) {
					
					chgCalcContainerVO 	= chgCalcContainerVOS.get(i);
					darNo		 		= chgCalcContainerVO.getAftExptDarNo();
					
			
					chgCalcParmVO 		= new ChargeCalculationParmVO();
					chgCalcParmVO.setSvrId(				chgCalcContainerVO.getSvrId()			);
					chgCalcParmVO.setCntrNo(			chgCalcContainerVO.getCntrNo()			);
					chgCalcParmVO.setCntrCycNo(			chgCalcContainerVO.getCntrCycNo()		);
					chgCalcParmVO.setDmdtTrfCd(			chgCalcContainerVO.getDmdtTrfCd()		);
					chgCalcParmVO.setDmdtChgLocDivCd(	chgCalcContainerVO.getDmdtChgLocDivCd()	);
					chgCalcParmVO.setChgSeq(			chgCalcContainerVO.getChgSeq()			);
					chgCalcParmVO.setBkgNo(				chgCalcContainerVO.getBkgNo()			);
					chgCalcParmVO.setCntrTpszCd(		chgCalcContainerVO.getCntrTpszCd()		);
					chgCalcParmVO.setFmMvmtDt(			chgCalcContainerVO.getFmMvmtDt()		);
					chgCalcParmVO.setFmMvmtStsCd(		chgCalcContainerVO.getFmMvmtStsCd()		);
					chgCalcParmVO.setFmMvmtYdCd(		chgCalcContainerVO.getFmMvmtYdCd()		);
					chgCalcParmVO.setToMvmtDt(			chgCalcContainerVO.getToMvmtDt()		);
					chgCalcParmVO.setToMvmtStsCd(		chgCalcContainerVO.getToMvmtStsCd()		);
					chgCalcParmVO.setToMvmtYdCd(		chgCalcContainerVO.getToMvmtYdCd()		);
					chgCalcParmVO.setCustCntCd(			chgCalcContainerVO.getCustCntCd()		);
					chgCalcParmVO.setCustSeq(			chgCalcContainerVO.getCustSeq()			);
					chgCalcParmVO.setActCntCd(			chgCalcContainerVO.getActCntCd()		);
					chgCalcParmVO.setActCustSeq(		chgCalcContainerVO.getActCustSeq()		);
					chgCalcParmVO.setIoBndCd(			chgCalcContainerVO.getIoBndCd()			);

//					String flag = dmtCalculationUtil.searchDualTypeException(chgCalcParmVO);
					// ------------------------------------------------------------------------------------------------------------------

					
					//2. comparing Dual Type Exception ------------------------------------------------------------------------------------
					//2-1) if "Y" then					
					if ("Y".equals(chgCalcContainerVO.getDulTpExptFlg())) {
						
						//RETURN = combinedChargeCalculation
						retChgCalcCntrVO = dmtCombinedChargeCalcUtil.combinedChargeCalculation(chgCalcParmVO);
					}
					//2-2) if !"Y" then
					else {
						if (chgCalcContainerVO.getCxlBkgChgFlg().equals("Y")) {
							retChgCalcCntrVO = dmtCancelChargeCalculationUtil.cancelChargeCalculation(chgCalcParmVO);
							
							if (retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
								dmtResultVO.setResultCode(	retChgCalcCntrVO.getMsgCd()		);
								dmtResultVO.setResultMsg(	retChgCalcCntrVO.getMsgDesc()	);
								
								return null;
							}
						} 
						else {
							//RETURN = generalChargeCalculation
							retChgCalcCntrVO = dmtGeneralChargeCalcUtil.generalChargeCalculation(chgCalcParmVO);
							
							if (retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
								dmtResultVO.setResultCode(	retChgCalcCntrVO.getMsgCd()		);
								dmtResultVO.setResultMsg(	retChgCalcCntrVO.getMsgDesc()	);
								
								return null;
							}								
					    }
					}

					
					//Exception of failure Process
					if (!"0".equals(retChgCalcCntrVO.getMsgCd())) {
						throw new EventException("DMT02036");
					}
					// ------------------------------------------------------------------------------------------------------------------
					
					//3. DMT_BKG_CNTR TABLE UPDATE --------------------------------------------------------------------------------------
					// ------------ DmtChgBkgCntrVO create object -----------------
					DmtChgBkgCntrVO dmtChgBkgCntrVO = new DmtChgBkgCntrVO();
					dmtChgBkgCntrVO.setSvrId(			chgCalcContainerVO.getSvrId()			);
					dmtChgBkgCntrVO.setCntrNo(			chgCalcContainerVO.getCntrNo()			);
					dmtChgBkgCntrVO.setCntrCycNo(		chgCalcContainerVO.getCntrCycNo()		);
					dmtChgBkgCntrVO.setBlNo(			chgCalcContainerVO.getBlNo()			);
					//--------------- ChargePartialPaymentVO -------------------
					dmtChgBkgCntrVO.setVslCd(			chgCalcContainerVO.getVslCd()			);
					dmtChgBkgCntrVO.setSkdVoyNo(		chgCalcContainerVO.getSkdVoyNo()		);
					dmtChgBkgCntrVO.setSkdDirCd(		chgCalcContainerVO.getSkdDirCd()		);
					//--------------------------------------------------------
					dmtChgBkgCntrVO.setVpsEtaDt(		retChgCalcCntrVO.getVpsEtaDt()			);
					dmtChgBkgCntrVO.setScNo(			retChgCalcCntrVO.getBrhScNo()			);
					dmtChgBkgCntrVO.setRfaNo(			retChgCalcCntrVO.getBrhRfaNo()			);
					dmtChgBkgCntrVO.setCmdtCd(			retChgCalcCntrVO.getCmdtCd()			);
					dmtChgBkgCntrVO.setRepCmdtCd(		retChgCalcCntrVO.getRepCmdtCd()			);
					dmtChgBkgCntrVO.setDcgoFlg(			retChgCalcCntrVO.getDcgoFlg()			);
					dmtChgBkgCntrVO.setRcFlg(			retChgCalcCntrVO.getRcFlg()				);
					dmtChgBkgCntrVO.setBbCgoFlg(		retChgCalcCntrVO.getBbCgoFlg()			);
					dmtChgBkgCntrVO.setAwkCgoFlg(		retChgCalcCntrVO.getAwkCgoFlg()			);
					dmtChgBkgCntrVO.setRdCgoFlg(		retChgCalcCntrVO.getRdCgoFlg()			);
					dmtChgBkgCntrVO.setSocFlg(			retChgCalcCntrVO.getSocFlg()			);
					dmtChgBkgCntrVO.setCntrPrtFlg(		retChgCalcCntrVO.getCntrPrtFlg()		);
					dmtChgBkgCntrVO.setAdvShtgCd(		retChgCalcCntrVO.getAdvShtgCd()			);
					dmtChgBkgCntrVO.setDmdtCntrTpCd(	retChgCalcCntrVO.getCntrTp()			);
					dmtChgBkgCntrVO.setDmdtBkgCgoTpCd(	retChgCalcCntrVO.getDmdtCgoTpCd()		);
					dmtChgBkgCntrVO.setPorCd(			retChgCalcCntrVO.getPorCd()				);
					dmtChgBkgCntrVO.setPolCd(			retChgCalcCntrVO.getPolCd()				);
					dmtChgBkgCntrVO.setPodCd(			retChgCalcCntrVO.getPodCd()				);
					dmtChgBkgCntrVO.setDelCd(			retChgCalcCntrVO.getDelCd()				);
					dmtChgBkgCntrVO.setBkgRcvTermCd(	retChgCalcCntrVO.getBbRcvTermCd()		);
					dmtChgBkgCntrVO.setBkgDeTermCd(		retChgCalcCntrVO.getBbDeTermCd()		);
					dmtChgBkgCntrVO.setBkgCntrQty(		retChgCalcCntrVO.getBkgQty()			);
					dmtChgBkgCntrVO.setSlsOfcCd(		retChgCalcCntrVO.getSalOfc()			);
					dmtChgBkgCntrVO.setRhqCd(			retChgCalcCntrVO.getSalRhq()			);
					dmtChgBkgCntrVO.setUpdUsrId(		afterProgressVO.getUpdUsrId()			);
					dmtChgBkgCntrVO.setUpdOfcCd(		afterProgressVO.getUpdOfcCd()			);
	
					chgCalcCommand.modifyBookingContainer(dmtChgBkgCntrVO);
					// ------------------------------------------------------------------------------------------------------------------
	
					// ************* DmtChgCalcVO create object  *****************
					DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
					
					//4-2) (RETURN != 0) change DMDT_CHG_STS_CD to "E" case in return value of process 2 is wrong
					// ------------------------------------------------------------------------------------------------------------------
					if(!retChgCalcCntrVO.getMsgCd().equals("0")) {
						retChgCalcCntrVO.setDmdtChgStsCd("E");
					}
					
					//6. DMT_CHG_CALC TABLE UPDATE --------------------------------------------------------------------------------------
					dmtChgCalcVO.setSvrId(				chgCalcContainerVO.getSvrId()			);
					dmtChgCalcVO.setCntrNo(				chgCalcContainerVO.getCntrNo()			);
					dmtChgCalcVO.setCntrCycNo(			chgCalcContainerVO.getCntrCycNo()		);
					dmtChgCalcVO.setDmdtTrfCd(			chgCalcContainerVO.getDmdtTrfCd()		);
					dmtChgCalcVO.setDmdtChgLocDivCd(	chgCalcContainerVO.getDmdtChgLocDivCd()	);
					dmtChgCalcVO.setChgSeq(				chgCalcContainerVO.getChgSeq()			);
					
					dmtChgCalcVO.setFmMvmtStsCd(		chgCalcContainerVO.getFmMvmtStsCd()		);
					dmtChgCalcVO.setFmMvmtDt(			chgCalcContainerVO.getFmMvmtDt()		);
					dmtChgCalcVO.setFmMvmtYdCd(			chgCalcContainerVO.getFmMvmtYdCd()		);
					dmtChgCalcVO.setToMvmtStsCd(		chgCalcContainerVO.getToMvmtStsCd()		);
					dmtChgCalcVO.setToMvmtDt(			chgCalcContainerVO.getToMvmtDt()		);
					dmtChgCalcVO.setToMvmtYdCd(			chgCalcContainerVO.getToMvmtYdCd()		);
					dmtChgCalcVO.setNotCreBalFlg(		"N"										);
					dmtChgCalcVO.setFtDys(				retChgCalcCntrVO.getFtDys()				);
					dmtChgCalcVO.setFtCmncDt(			retChgCalcCntrVO.getFtCmncDt()			);
					dmtChgCalcVO.setFtEndDt(			retChgCalcCntrVO.getFtEndDt()			);
					dmtChgCalcVO.setFxFtOvrDys(			retChgCalcCntrVO.getFxFtOvrDys()		);
					dmtChgCalcVO.setOrgFtOvrDys(		retChgCalcCntrVO.getOrgFtOvrDys()		);
					dmtChgCalcVO.setScRfaExptOvrDys(	retChgCalcCntrVO.getScRfaExptOvrDys()	);
					dmtChgCalcVO.setAftExptOvrDys(		retChgCalcCntrVO.getAftExptOvrDys()		);
					dmtChgCalcVO.setBzcTrfCurrCd(		retChgCalcCntrVO.getBzcTrfCurrCd()		);
					dmtChgCalcVO.setDmdtTrfAplyTpCd(	retChgCalcCntrVO.getDmdtTrfAplyTpCd()	);
					dmtChgCalcVO.setOrgChgAmt(			retChgCalcCntrVO.getOrgChgAmt()			);
					dmtChgCalcVO.setScRfaExptAmt(		retChgCalcCntrVO.getScRfaExptAmt()		);
					dmtChgCalcVO.setAftExptDcAmt(		retChgCalcCntrVO.getAftExptDcAmt()		);
					dmtChgCalcVO.setBilAmt(				retChgCalcCntrVO.getBilAmt()			);
					
					// Change STATUS to "I" case in "I"(ISSUED) After Calculate ====================
					if ("I".equals(chgCalcContainerVO.getDmdtChgStsCd())) {
						dmtChgCalcVO.setDmdtChgStsCd("I");
					}
					else {
						dmtChgCalcVO.setDmdtChgStsCd(retChgCalcCntrVO.getDmdtChgStsCd());
					}
					//============================================================================
					
					dmtChgCalcVO.setScRfaAmt(			retChgCalcCntrVO.getScRfaAmt()			);
					dmtChgCalcVO.setAftExptAmt(			retChgCalcCntrVO.getAftExptAmt()		);
					dmtChgCalcVO.setBzcTrfSeq(			retChgCalcCntrVO.getBzcTrfSeq()			);
					dmtChgCalcVO.setBzcTrfGrpSeq(		retChgCalcCntrVO.getBzcTrfGrpSeq()		);
					dmtChgCalcVO.setBzcTrfAplyDt(		retChgCalcCntrVO.getBzcTrfAplyDt()		);		
					dmtChgCalcVO.setRfaExptAproNo(		retChgCalcCntrVO.getRfaExptAproNo()		);
					dmtChgCalcVO.setRfaExptDarNo(		retChgCalcCntrVO.getRfaExptDarNo()		);
					dmtChgCalcVO.setRfaExptMapgSeq(		retChgCalcCntrVO.getRfaExptMapgSeq()	);		
					dmtChgCalcVO.setRfaExptVerSeq(		retChgCalcCntrVO.getRfaExptVerSeq()		);
					dmtChgCalcVO.setRfaRqstDtlSeq(		retChgCalcCntrVO.getRfaRqstDtlSeq()		);
					dmtChgCalcVO.setAftExptAproNo(		retChgCalcCntrVO.getAftExptAproNo()		);
					dmtChgCalcVO.setAftExptDarNo(		retChgCalcCntrVO.getAftExptDarNo()		);
					dmtChgCalcVO.setAftExptAdjSeq(		retChgCalcCntrVO.getAftExptAdjSeq()		);
					dmtChgCalcVO.setScNo(				retChgCalcCntrVO.getScNo()				);
					dmtChgCalcVO.setScExptVerSeq(		retChgCalcCntrVO.getScExptVerSeq()		);
					dmtChgCalcVO.setScExptGrpSeq(		retChgCalcCntrVO.getScExptGrpSeq()		);
					dmtChgCalcVO.setScRfaExptAplyDt(	retChgCalcCntrVO.getScRfaExptAplyDt()	);
					dmtChgCalcVO.setCorrRmk(			chgCalcContainerVO.getCorrRmk()			);
					
					//OFC_CD, OFC_RHQ_CD, DMDT_INV_NO are setting to Origin values  ========
					dmtChgCalcVO.setOfcCd(				chgCalcContainerVO.getOfcCd()			);
					dmtChgCalcVO.setOfcRhqCd(			chgCalcContainerVO.getOfcRhqCd()		);
					dmtChgCalcVO.setDmdtInvNo(			chgCalcContainerVO.getDmdtInvNo()		);
					//================================================================================
	
					dmtChgCalcVO.setUpdUsrId(			afterProgressVO.getUpdUsrId()			);
					dmtChgCalcVO.setUpdOfcCd(			afterProgressVO.getUpdOfcCd()			);
					dmtChgCalcVO.setCmdtCd(				retChgCalcCntrVO.getCmdtCd()			);
					dmtChgCalcVO.setCmdtTrfSeq(			retChgCalcCntrVO.getCmdtTrfSeq()		);
					dmtChgCalcVO.setCmdtExptAplyDt(		retChgCalcCntrVO.getCmdtExptAplyDt()	);
					dmtChgCalcVO.setCmdtOvrDys(			retChgCalcCntrVO.getCmdtOvrDys()		);
					dmtChgCalcVO.setCmdtExptAmt(		retChgCalcCntrVO.getCmdtExptAmt()		);
					dmtChgCalcVO.setWebMtyDt(			chgCalcContainerVO.getWebMtyDt()		);
	
					chgCalcCommand.modifyChargeCalculation(dmtChgCalcVO);
					
					if (chgCalcContainerVO.getDulTpExptFlg().equals("Y")) {
						// Change value of fields  ORG_CHG_AMT, SC_RFA_EXPT_AMT of Dual Exception Charge
						if(chargeArgumentVO != null) chgCalcCommand.modifyOrgChgAmt(chargeArgumentVO);
					}					
					// ------------------------------------------------------------------------------------------------------------------
					
					// Stop Porcess after DMT_CHG_CALC TABLE UPDATE Case in return error in porcess 2 .
					if ("E".equals(retChgCalcCntrVO.getDmdtChgStsCd())) {
						continue;
					}
					
					//7. save CLOCK STOP HISTORY ----------------------------------------------------------------------------------
					//   addClockStopHistory case in Clock Stop is over ond day Clock Stop (cStopNoList.size() > 0) 
					List<String> cStopNoList = retChgCalcCntrVO.getCStopNoList();
					if(cStopNoList != null && cStopNoList.size () > 0) {
						DmtChgTmCskStopVO dmtChgTmCskStopVO = new DmtChgTmCskStopVO();
						dmtChgTmCskStopVO.setSvrId(				chgCalcContainerVO.getSvrId()			);
						dmtChgTmCskStopVO.setCntrNo(			chgCalcContainerVO.getCntrNo()			);
						dmtChgTmCskStopVO.setCntrCycNo(			chgCalcContainerVO.getCntrCycNo()		);
						dmtChgTmCskStopVO.setDmdtTrfCd(			chgCalcContainerVO.getDmdtTrfCd()		);
						dmtChgTmCskStopVO.setDmdtChgLocDivCd(	chgCalcContainerVO.getDmdtChgLocDivCd()	);
						dmtChgTmCskStopVO.setChgSeq(			chgCalcContainerVO.getChgSeq()			);
	
						// delete Clock Stop History.
						chgCalcCommand.deleteClockStopHistory(dmtChgTmCskStopVO);
						
						// Insert for loop until Clock Stop count
						for (int j = 0 ; j < cStopNoList.size() ; j++) {
							String clkStopNo = cStopNoList.get(j);
							dmtChgTmCskStopVO.setClkStopNo(clkStopNo);
							
							chgCalcCommand.addClockStopHistory(dmtChgTmCskStopVO);
						}
					}
					// ------------------------------------------------------------------------------------------------------------------
					
					//8.UPDATE DMT_INV_MN TABLE---------------------------------------------------------------------------------
					invIssCommand.modifyInvoiceAdjustAmount(darNo);
					// ------------------------------------------------------------------------------------------------------------------
					
				}
			}
			
			//##############################################################################################################################
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		catch (EventException ex) {
			log.error("[EventException]"+ex.getMessage());
			throw ex;
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
		return chgCalcContainerVOS;
	}
	
	/**
	 * Counter Offered modify After Booking DAR  <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void counterofferAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException {
		try {
			chgAmtDisMgtDBDAO.modifyAfterBookingStatus(afterProgressVO);
			chgAmtDisMgtDBDAO.addCommentHistory(afterProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * After Booking DAR Change to Reject <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void rejectAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException {
		try {
			chgAmtDisMgtDBDAO.modifyAfterBookingStatus(afterProgressVO);
			chgAmtDisMgtDBDAO.addCommentHistory(afterProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * After Booking DAR creation, modify, delete. <br>
	 * 
	 * @param AfterBKGGRPVO afterBKGGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void requestAfterBookingDAR(AfterBKGGRPVO afterBKGGRPVO, 
			SignOnUserAccount account) throws EventException {
		
		try {
			if (afterBKGGRPVO == null) throw new EventException("");
			
			AfterProgressVO afterProgressVO = afterBKGGRPVO.getAfterProgressVO();
			if (afterProgressVO != null) {
				afterProgressVO.setCreUsrId(account.getUsr_id());
				afterProgressVO.setCreOfcCd(account.getOfc_cd());
				afterProgressVO.setUpdUsrId(account.getUsr_id());
				afterProgressVO.setUpdOfcCd(account.getOfc_cd());
			}
			
			List<AfterBKGRequestVO> afterBKGRequestVOS = afterBKGGRPVO.getAfterBKGRequestVOS();
			List<AfterBKGRequestVO> insertAfterBKGRequestVOS = new ArrayList<AfterBKGRequestVO>();
			List<AfterBKGRequestVO> updateAfterBKGRequestVOS = new ArrayList<AfterBKGRequestVO>();
			List<AfterBKGRequestVO> deleteAfterBKGRequestVOS = new ArrayList<AfterBKGRequestVO>();

			if (afterBKGRequestVOS != null) {
				for (int i = 0 ; i < afterBKGRequestVOS.size(); i++) {
					if (afterBKGRequestVOS.get(i).getIbflag().equals("I")) {
						afterBKGRequestVOS.get(i).setCreUsrId(account.getUsr_id());
						afterBKGRequestVOS.get(i).setCreOfcCd(account.getOfc_cd());
						insertAfterBKGRequestVOS.add(afterBKGRequestVOS.get(i));
					} else if (afterBKGRequestVOS.get(i).getIbflag().equals("U")) {
						afterBKGRequestVOS.get(i).setUpdUsrId(account.getUsr_id());
						afterBKGRequestVOS.get(i).setUpdOfcCd(account.getOfc_cd());
						updateAfterBKGRequestVOS.add(afterBKGRequestVOS.get(i));
					} else if (afterBKGRequestVOS.get(i).getIbflag().equals("D")) {
						deleteAfterBKGRequestVOS.add(afterBKGRequestVOS.get(i));
					}
				}
			}
			
			List<AfterBKGCNTRRequestVO> afterBKGCNTRRequestVOS = afterBKGGRPVO.getAfterBKGCNTRRequestVOS();	
			List<AfterBKGCNTRRequestVO> insertAfterBKGCNTRRequestVOS = new ArrayList<AfterBKGCNTRRequestVO>();
			List<AfterBKGCNTRRequestVO> updateAfterBKGCNTRRequestVOS = new ArrayList<AfterBKGCNTRRequestVO>();
			List<AfterBKGCNTRRequestVO> deleteAfterBKGCNTRRequestVOS = new ArrayList<AfterBKGCNTRRequestVO>();

			if (afterBKGCNTRRequestVOS != null) {
				for (int i = 0 ; i < afterBKGCNTRRequestVOS.size(); i++) {
					if (afterBKGCNTRRequestVOS.get(i).getIbflag().equals("I")) {
						afterBKGCNTRRequestVOS.get(i).setCreUsrId(account.getUsr_id());
						afterBKGCNTRRequestVOS.get(i).setCreOfcCd(account.getOfc_cd());
						insertAfterBKGCNTRRequestVOS.add(afterBKGCNTRRequestVOS.get(i));
					} else if (afterBKGCNTRRequestVOS.get(i).getIbflag().equals("U")) {
						afterBKGCNTRRequestVOS.get(i).setUpdUsrId(account.getUsr_id());
						afterBKGCNTRRequestVOS.get(i).setUpdOfcCd(account.getOfc_cd());
						updateAfterBKGCNTRRequestVOS.add(afterBKGCNTRRequestVOS.get(i));
					} else if (afterBKGCNTRRequestVOS.get(i).getIbflag().equals("D")) {
						deleteAfterBKGCNTRRequestVOS.add(afterBKGCNTRRequestVOS.get(i));
					}
				}
			}
			
			//1.[Delete Action] * delete first *
			if (deleteAfterBKGCNTRRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.removeAfterBookingContainer(deleteAfterBKGCNTRRequestVOS);
			}
			if (deleteAfterBKGRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.removeAfterBookingDAR(deleteAfterBKGRequestVOS);
			}	

			//2.[Insert Action]
			// Save Comment History.
			// Skip in BackEndJob 
			if (afterProgressVO != null && !"Y".equals(afterProgressVO.getBackendJobFlag())) {
				
				if (!chgAmtDisMgtDBDAO.isDupAfterBookingRequest(afterProgressVO))
					chgAmtDisMgtDBDAO.addAfterBookingRequest(afterProgressVO);
				else
					chgAmtDisMgtDBDAO.modifyAfterBookingRequest(afterProgressVO);
			
				chgAmtDisMgtDBDAO.addCommentHistory(afterProgressVO);
			}
			
			if (insertAfterBKGRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.addAfterBookingDAR(insertAfterBKGRequestVOS);
			}				
			if (insertAfterBKGCNTRRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.addAfterBookingContainer(insertAfterBKGCNTRRequestVOS);
			}
			
			//3.[Update Action]
			if (updateAfterBKGRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.modifyAfterBookingDAR(updateAfterBKGRequestVOS);
			}
			if (updateAfterBKGCNTRRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.modifyAfterBookingContainer(updateAfterBKGCNTRRequestVOS);
			}				
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * search Calcuation Type of Location Code and I/O Bound Code <br>
	 * 
	 * @param String locCd
	 * @param String ioBndCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCalcTypeCode(String locCd, String ioBndCd) throws EventException {
		try {
			return chgAmtDisMgtDBDAO.searchCalcTypeCode(locCd, ioBndCd);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Approval to BackEndJob <br>
	 *
	 * @param AfterBKGGRPVO afterBKGGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String doBackEndJobApproval(AfterBKGGRPVO afterBKGGRPVO, SignOnUserAccount account) {
		ChargeAmountDiscountBackEndJob	backEndJob 			= new ChargeAmountDiscountBackEndJob();
		BackEndJobManager				backEndJobManager 	= new BackEndJobManager();
		
		// define paramater for BackEndJob
		backEndJob.setUserAccount(account);
		backEndJob.setAfterBKGGRPVO(afterBKGGRPVO);
		
		//call BackEndJob 
		return backEndJobManager.execute(backEndJob, afterBKGGRPVO.getAfterProgressVO().getCreUsrId(), "EES_DMT_2009 Create Back End");
	}
	
	/**
	 * Back End Job common. return staus<br>
	 *
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkBackEndJobApproval(String key) throws EventException {
		
		DBRowSet rowSet;
		try {
			String[] result = new String[2];
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			
			if(rowSet.next()) {
				//Thread.sleep(1000);
				result[0] = rowSet.getString("jb_sts_flg");
				result[1] = rowSet.getString("jb_usr_err_msg");
			}
			return result;
		} catch(Exception ex){
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT0006", new String[]{"BackEndJob Status"}).getUserMessage(),ex);
		}
		
//		DBRowSet rowSet;
//		try {
////			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
////			
////			rowSet.next();
////			Thread.sleep(1000);
////			//return (String) rowSet.getObject("jb_sts_flg");
//			
//			
//			String[] result = new String[2];
//			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
//			
//			if(rowSet.next()) {
//				//Thread.sleep(1000);
//				result[0] = rowSet.getString("jb_sts_flg");
//				result[1] = rowSet.getString("jb_usr_err_msg");
//			}
//			return result;
//		} 
////		catch (BackEndJobException e) {
////			throw new EventException(new ErrorHandler("DMT0006", new String[]{""}).getUserMessage(),e);
////		} 
////		catch (SQLException e) {
////			throw new EventException(new ErrorHandler("DMT0006", new String[]{""}).getUserMessage(),e);
////		} 
////		catch (InterruptedException e) {
////			throw new EventException(new ErrorHandler("DMT0006", new String[]{""}).getUserMessage(),e);
////		} 
//		catch(Exception e){
//			throw new EventException(new ErrorHandler("DMT0006", new String[]{""}).getUserMessage(),e);
//		}
	}
	
	/**
	 * result Return Back End Job <br>
	 *
	 * @param String key
	 * @return BackEndJobResultVO
	 * @exception EventException
	 */
	public BackEndJobResultVO completeBackEndJobApproval(String key) throws EventException {
		BackEndJobResultVO backEndJobResultVO = null;
		
		try {
			backEndJobResultVO = (BackEndJobResultVO)BackEndJobResult.loadFromFile(key);
		} 
		catch (BackEndJobException ex) {
			log.error("[BackEndJobException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT0006", new String[]{""}).getUserMessage(),ex);
		} 
		catch(Exception ex){
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT0006", new String[]{""}).getUserMessage(),ex);
		}
		return backEndJobResultVO;
	}
	
	/**
	 * Update Date info. of After Booking Request<br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @return String
	 * @exception EventException
	 */
	public String searchUpdateDate(AfterProgressVO afterProgressVO) throws EventException {
		try {
			return chgAmtDisMgtDBDAO.searchUpdateDate(afterProgressVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}	
}
