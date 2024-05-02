/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtBCImpl.java
*@FileTitle : DEM/DET Adjustment Request - After Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.07.21 이성훈
* 1.0 Creation
* 2010.09.16 김태균 [] [EES-DMT] AFTER BOOKING BACKENDJOB 메시지 수정
* 2011.05.11.김태균 [CHM-201110489-01] [DMT] Balance Charge에 대한 Free Time 적용 배제 요청
* 2013.02.08 임창빈[CHM-201322395] DMT OP-MT Detention 계산 방법 보완 3차
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration.ChargeAmountDiscountMgtDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ActualCostListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGCNTRRequestVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGGRPVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGRequestVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBkgRqstAproStsParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBkgRqstAproStsVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingAproItmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingDetailFlgVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingDetailReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingExptClrRqstVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingFileListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingFullHistoryVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingMasListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingPfmcListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingReasonDescVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingReasonDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingRequestDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingRsnRmkVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.BackEndJobResultVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.CommentHistoryVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgBkgCntrVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCalcVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgTmCskStopVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTBalanceChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCancelChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCombinedChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTGeneralChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBCImpl;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-DMTClosing Business Logic Basic Command implementation<br>
 * - NIS2010-DMTClosing에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see EES_DMT_2008EventResponse,ChargeAmountDiscountMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtBCImpl extends BasicCommandSupport
		implements ChargeAmountDiscountMgtBC {

	// Database Access Object
	private transient	ChargeAmountDiscountMgtDBDAO	chgAmtDisMgtDBDAO = null;
	
	private		DMTCalculationUtil				dmtCalculationUtil	= null;
	private 	ChargeCalculationBC				chgCalcCommand		= null;
	private		InvoiceIssueCollectionMgtBC		invIssCommand		= null;
	
	
	/**
	 * ChargeCalculationBCImpl 객체 생성<br>
	 * ChargeCalculationDBDAO를 생성한다.<br>
	 */
	public ChargeAmountDiscountMgtBCImpl() {
		chgAmtDisMgtDBDAO 		= new ChargeAmountDiscountMgtDBDAO();
		dmtCalculationUtil 		= new DMTCalculationUtil();
		
		// 2010.05.20 수정
		chgCalcCommand			= new ChargeCalculationBCImpl();
		invIssCommand			= new InvoiceIssueCollectionMgtBCImpl();
	}
	
	/**
	 * After Booking 목록을 조회 합니다. <br>
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
	 * After Booking 의 기타정보를 조회 합니다. <br>
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
	 * Booking No. 에 해당하는 컨테이너 정보를 조회 합니다. <br>
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
	 * 컨테이너의 Quantity를 조회 합니다. <br>
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
	 * 컨테이너의 Currency를 조회 합니다. <br>
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
	 * Comment History를 조회 합니다. <br>
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
	 * Booking Data 를 조회 합니다. <br>
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
	 * BKG/B/L No 의 Tariff Type 이 맞는지 조회 합니다. <br>
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
	 * BKG/B/L No 의 Tariff Type 에 맞는 Location Code를 조회 합니다. <br>
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
	 * Tariff Type 과 BKG 또는 B/L No. 가 중복되는지 조회 합니다. <br>
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
	 * Balance Charge 가 있는 CNTR 인지 조회 합니다. <br>
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
	 * 등록된 After Booking DAR 를 Cancel 상태로 수정 합니다. <br>
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
	 * 등록된 After Booking DAR 를 Approved 상태로 수정 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void approveAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException {
		try {
			//1.상태변경
			chgAmtDisMgtDBDAO.modifyAfterBookingStatus(afterProgressVO);
			//2.History 생성
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
	 * After Booking 에 대한 승인처리시 Calculation 을 실행 합니다. <br>
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
			//승인처리시 Calculation 처리를 해준다 ############################################################################################
			DMTGeneralChargeCalculationUtil 	dmtGeneralChargeCalcUtil 		= new DMTGeneralChargeCalculationUtil();
			DMTCombinedChargeCalculationUtil 	dmtCombinedChargeCalcUtil 		= new DMTCombinedChargeCalculationUtil();
			DMTCancelChargeCalculationUtil		dmtCancelChargeCalculationUtil 	= new DMTCancelChargeCalculationUtil();
			DMTBalanceChargeCalculationUtil		dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
			
			String 								darNo 							= null;
			ChargeArgumentVO 					chargeArgumentVO				= null;
			ChargeCalculationParmVO 			chgCalcParmVO 					= null;
			ChargeCalculationContainerVO 		chgCalcContainerVO 				= null;
			List<ChargeBookingContainerVO> 		chgBKGContainerVOS 				= null;
			
			com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			
			//1. 대상조회
			chgCalcContainerVOS = chgAmtDisMgtDBDAO.searchChargeCalculationList(afterProgressVO.getAftExptDarNo());
			
			//1-1. 대상조회 후 FOR문으로 대상처리 --------------------------------------------------------------------------------------------
			if (chgCalcContainerVOS != null && chgCalcContainerVOS.size() > 0) {
				for (int i = 0 ; i < chgCalcContainerVOS.size() ; i++) {
					
					chgCalcContainerVO 	= chgCalcContainerVOS.get(i);
					darNo		 		= chgCalcContainerVO.getAftExptDarNo();
					
					//매개변수로 사용될 객체 설정.
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

					
					//2. Dual Type Exception 여부 비교 ------------------------------------------------------------------------------------
					//2-1) "Y" 이면					
					if ("Y".equals(chgCalcContainerVO.getDulTpExptFlg())) {
//						retChgCalcCntrVO = dmtCombinedChargeCalcUtil.combinedChargeCalculation(chgCalcParmVO);
						//2011.04.29. 추가 ("DR"일때 아닐때 구분)
						if(!chgCalcContainerVO.getFmMvmtStsCd().equals("DR")){
							retChgCalcCntrVO = dmtCombinedChargeCalcUtil.combinedChargeCalculation(chgCalcParmVO);
							if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
								log.error("\n\n combinedChargeCalculation ERROR [Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
								throw new EventException(retChgCalcCntrVO.getMsgDesc());
							}
						}else{
							dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
							retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
							
							if (retChgCalcCntrVO.getMsgCd().equals("-1")) {
								log.error("\n\n[DMT02036][Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
								throw new EventException(retChgCalcCntrVO.getMsgDesc());
							}
						}
					}
					//2-2) "Y"가 아니면
					else {
						if((chgCalcContainerVO.getCxlBkgChgFlg().equals("Y")) ||
							((chgCalcContainerVO.getDmdtTrfCd().equals("DTOC") || chgCalcContainerVO.getDmdtTrfCd().equals("CTOC") ) && chgCalcContainerVO.getFmMvmtStsCd().equals("OP") && chgCalcContainerVO.getToMvmtStsCd().equals("MT"))
							) {
								
							// CxlBkgChgFlg = "Y" : 이미 Booking Cancel 되었음을 의미한다. (배치 프로그램.)
							// TRF CD("DTOC", "CTOC") && FM ("OP") && To ("MT") 현재 Booking Canecl인 아니지만, 곧 Cancel 된다고 생각하면 된다.(화면에서 입력된 경우)
								
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

					
					//위 실행된 Process 가 정상처리가 되지 않았다면 Exception 처리를 해준다.
					if (!"0".equals(retChgCalcCntrVO.getMsgCd())) {
						throw new EventException("DMT02036");
					}
					// ------------------------------------------------------------------------------------------------------------------
					
					//3. DMT_BKG_CNTR TABLE UPDATE --------------------------------------------------------------------------------------
					// ------------ DmtChgBkgCntrVO 객체 구성 -----------------
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
	
					// ************* DmtChgCalcVO 객체 구성 *****************
					DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
					
					//4-2) 2번에서 RETURN된 DATA가 정상이 아닌 경우(RETURN != 0) DMDT_CHG_STS_CD를 "E"로 변경한다
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
					
					//"I"(ISSUED)인 경우 계산후 생성된 STATUS를 "I"로 변경한다. =======================
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
					
					//OFC_CD, OFC_RHQ_CD, DMDT_INV_NO 는 기존 값(DMT_CHG_CALC)을 그대로 설정한다. ========
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
					dmtChgCalcVO.setUclmFlg(			chgCalcContainerVO.getUclmFlg()  		);
					
					dmtChgCalcVO.setBzcDmdtDeTermCd(	retChgCalcCntrVO.getBzcDmdtDeTermCd() );
					dmtChgCalcVO.setUclmFlg(	chgCalcContainerVO.getUclmFlg() );
	
					chgCalcCommand.modifyChargeCalculation(dmtChgCalcVO);
					
					if (chgCalcContainerVO.getDulTpExptFlg().equals("Y")) {
						// Dual Exception Charge의 ORG_CHG_AMT, SC_RFA_EXPT_AMT 필드값 수정
						chargeArgumentVO = new ChargeArgumentVO();
						chargeArgumentVO.setSvrId(				chgCalcContainerVO.getSvrId()			);
						chargeArgumentVO.setCntrNo(				chgCalcContainerVO.getCntrNo()			);
						chargeArgumentVO.setCntrCycNo(			chgCalcContainerVO.getCntrCycNo()		);
						chargeArgumentVO.setDmdtTrfCd(			chgCalcContainerVO.getDmdtTrfCd()		);
						chargeArgumentVO.setDmdtChgLocDivCd(	chgCalcContainerVO.getDmdtChgLocDivCd()	);
						chargeArgumentVO.setChgSeq(				chgCalcContainerVO.getChgSeq()			);
						chargeArgumentVO.setFmMvmtDt(			chgCalcContainerVO.getFmMvmtDt()		);
						chargeArgumentVO.setToMvmtDt(			chgCalcContainerVO.getToMvmtDt()		);
						
						chgCalcCommand.modifyOrgChgAmt(chargeArgumentVO);
					}					
					// ------------------------------------------------------------------------------------------------------------------
					
					// 2 번에서 조회된 결과가 에러일 경우 DMT_CHG_CALC TABLE UPDATE 까지만 마치고 그 이하 프로세스는 태우지 않는다.
					if ("E".equals(retChgCalcCntrVO.getDmdtChgStsCd())) {
						continue;
					}
					
					//7. CLOCK STOP HISTORY 를 저장한다. ----------------------------------------------------------------------------------
					//   Clock Stop이 하루이상 적용되었으면(cStopNoList.size() > 0) addClockStopHistory 실행
					List<String> cStopNoList = retChgCalcCntrVO.getCStopNoList();
					if(cStopNoList != null && cStopNoList.size() > 0) {
						DmtChgTmCskStopVO dmtChgTmCskStopVO = new DmtChgTmCskStopVO();
						dmtChgTmCskStopVO.setSvrId(				chgCalcContainerVO.getSvrId()			);
						dmtChgTmCskStopVO.setCntrNo(			chgCalcContainerVO.getCntrNo()			);
						dmtChgTmCskStopVO.setCntrCycNo(			chgCalcContainerVO.getCntrCycNo()		);
						dmtChgTmCskStopVO.setDmdtTrfCd(			chgCalcContainerVO.getDmdtTrfCd()		);
						dmtChgTmCskStopVO.setDmdtChgLocDivCd(	chgCalcContainerVO.getDmdtChgLocDivCd()	);
						dmtChgTmCskStopVO.setChgSeq(			chgCalcContainerVO.getChgSeq()			);
	
						// 기 생성된 Clock Stop History 를 삭제한다.
						chgCalcCommand.deleteClockStopHistory(dmtChgTmCskStopVO);
						
						// 적용된 Clock Stop 갯수만큼 반복문을 실행하며 Insert 한다.
						for (int j = 0 ; j < cStopNoList.size() ; j++) {
							String clkStopNo = cStopNoList.get(j);
							dmtChgTmCskStopVO.setClkStopNo(clkStopNo);
							
							chgCalcCommand.addClockStopHistory(dmtChgTmCskStopVO);
						}
					}
					// ------------------------------------------------------------------------------------------------------------------
					
					//8. DMT_INV_MN TABLE을 UPDATE한다. ----------------------------------------------------------------------------------
					invIssCommand.modifyInvoiceAdjustAmount(darNo);
					// ------------------------------------------------------------------------------------------------------------------
					
					//9. "KOR"지역인 경우 터미널에 EDI를 전송한다. ( 차후 구현 예정) ----------------------------------------------------------
					//9-1) 대상을 조회한 후 FOR문으로 대상처리	(9 - (1 )
					List<String> list = chgAmtDisMgtDBDAO.searchBKGListByDARNo(darNo);
					if (list != null && list.size() > 0) {
						for (int j = 0 ; j <  list.size() ; j++) {
					
							//9-2) Booking에 속한 Container 중, After Exception 적용된 Container를 조회한 후 FOR문으로 대상 처리 	(9 - (2 )
							chgBKGContainerVOS = chgAmtDisMgtDBDAO.searchContainerListAppliedAfterExceptionByDARNo(darNo, list.get(j));
							if (chgBKGContainerVOS != null && chgBKGContainerVOS.size() > 0) {
								for (int k = 0 ; k < chgBKGContainerVOS.size(); k++) {
									
									//9-3) DMDT_TRF_CD == 'DMIF'인 경우 searchDTICFreeTimeEndDate를 호출하여 FREE TIME END DATE 및 FREE TIME OVER DAY를 조회한다
									if ("DMIF".equals(chgBKGContainerVOS.get(k).getDmdtTrfCd())) {
										dmtCalculationUtil.searchDTICFreeTimeEndDate(
														  chgCalcContainerVO.getSvrId()
														, chgCalcContainerVO.getCntrNo()
														, Long.parseLong(chgCalcContainerVO.getCntrCycNo())
														, chgCalcContainerVO.getDmdtTrfCd()
														, chgCalcContainerVO.getDmdtChgLocDivCd()
														, Long.parseLong(chgCalcContainerVO.getChgSeq()));
									}
									//9-4) DMDT_TRF_CD == 'DMIC'인 경우 searchDMIFFreeTimeEndDate를 호출하여 FREE TIME END DATE를 조회한다.
									//     DTIC FREE TIME OVER DAY를 조회한다	(9 - (4 )
									else if ("DTIC".equals(chgBKGContainerVOS.get(k).getDmdtTrfCd())) {
										dmtCalculationUtil.searchDMIFFreeTimeEndDate(
													  	  chgCalcContainerVO.getSvrId()
														, chgCalcContainerVO.getCntrNo()
														, Long.parseLong(chgCalcContainerVO.getCntrCycNo())
														, chgCalcContainerVO.getDmdtTrfCd()
														, chgCalcContainerVO.getDmdtChgLocDivCd()
														, Long.parseLong(chgCalcContainerVO.getChgSeq()));												
									}
								}
							}
						}
					}
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
	 * 등록된 After Booking DAR 를 Counter Offered 상태로 수정 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void counterofferAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException {
		try {
			chgAmtDisMgtDBDAO.modifyAfterBookingStatus(afterProgressVO);
			chgAmtDisMgtDBDAO.modifyAfterBookingApprovalStatus(afterProgressVO);
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
	 * 등록된 After Booking DAR 를 Reject 상태로 수정 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void rejectAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException {
		try {
			chgAmtDisMgtDBDAO.modifyAfterBookingStatus(afterProgressVO);
			chgAmtDisMgtDBDAO.modifyAfterBookingApprovalStatus(afterProgressVO);
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
	 * After Booking DAR를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param AfterBKGGRPVO afterBKGGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void requestAfterBookingDAR(AfterBKGGRPVO afterBKGGRPVO,	SignOnUserAccount account) throws EventException {
		
		try {
			if (afterBKGGRPVO == null) throw new EventException("");
			
			AfterProgressVO afterProgressVO = afterBKGGRPVO.getAfterProgressVO();
			
			String	usrId	= "";
			String	ofcCd	= "";
			
			if (account != null) {
				// ALPS 호출시 Session 정보가 있다.
				usrId	= account.getUsr_id();
				ofcCd	= account.getOfc_cd();
			} else {
				// 모바일 호출 시 Session 내 User 정보가 없다.
				usrId	= afterProgressVO.getCreUsrId();
				ofcCd	= afterProgressVO.getCreOfcCd();
			}
			
			if (afterProgressVO != null) {
				afterProgressVO.setCreUsrId( usrId );
				afterProgressVO.setCreOfcCd( ofcCd );
				afterProgressVO.setUpdUsrId( usrId );
				afterProgressVO.setUpdOfcCd( ofcCd );
			}
			
			List<AfterBKGRequestVO> afterBKGRequestVOS = afterBKGGRPVO.getAfterBKGRequestVOS();
			List<AfterBKGRequestVO> insertAfterBKGRequestVOS = new ArrayList<AfterBKGRequestVO>();
			List<AfterBKGRequestVO> updateAfterBKGRequestVOS = new ArrayList<AfterBKGRequestVO>();
			List<AfterBKGRequestVO> deleteAfterBKGRequestVOS = new ArrayList<AfterBKGRequestVO>();

			if (afterBKGRequestVOS != null && !afterBKGRequestVOS.isEmpty()) {
				for (AfterBKGRequestVO afterBKGRequestVO : afterBKGRequestVOS) {
					if ("I".equals(afterBKGRequestVO.getIbflag())) {
						afterBKGRequestVO.setCreUsrId( usrId );
						afterBKGRequestVO.setCreOfcCd( ofcCd );
						
						insertAfterBKGRequestVOS.add(afterBKGRequestVO);
					} 
					else if ("U".equals(afterBKGRequestVO.getIbflag())) {
						afterBKGRequestVO.setUpdUsrId( usrId );
						afterBKGRequestVO.setUpdOfcCd( ofcCd );
						
						updateAfterBKGRequestVOS.add(afterBKGRequestVO);
					} 
					else if ("D".equals(afterBKGRequestVO.getIbflag())) {
						deleteAfterBKGRequestVOS.add(afterBKGRequestVO);
					}
				}
			}
			
			List<AfterBKGCNTRRequestVO> afterBKGCNTRRequestVOS = afterBKGGRPVO.getAfterBKGCNTRRequestVOS();	
			List<AfterBKGCNTRRequestVO> insertAfterBKGCNTRRequestVOS = new ArrayList<AfterBKGCNTRRequestVO>();
			List<AfterBKGCNTRRequestVO> updateAfterBKGCNTRRequestVOS = new ArrayList<AfterBKGCNTRRequestVO>();
			List<AfterBKGCNTRRequestVO> deleteAfterBKGCNTRRequestVOS = new ArrayList<AfterBKGCNTRRequestVO>();

			if (afterBKGCNTRRequestVOS != null && !afterBKGCNTRRequestVOS.isEmpty()) {
				for (AfterBKGCNTRRequestVO afterBKGCNTRRequestVO : afterBKGCNTRRequestVOS) {
					if ("I".equals(afterBKGCNTRRequestVO.getIbflag())) {
						afterBKGCNTRRequestVO.setCreUsrId( usrId );
						afterBKGCNTRRequestVO.setCreOfcCd( ofcCd );
						
						insertAfterBKGCNTRRequestVOS.add(afterBKGCNTRRequestVO);
					} 
					else if ("U".equals(afterBKGCNTRRequestVO.getIbflag())) {
						afterBKGCNTRRequestVO.setUpdUsrId( usrId );
						afterBKGCNTRRequestVO.setUpdOfcCd( ofcCd );
						
						updateAfterBKGCNTRRequestVOS.add(afterBKGCNTRRequestVO);
					} 
					else if ("D".equals(afterBKGCNTRRequestVO.getIbflag())) {
						deleteAfterBKGCNTRRequestVOS.add(afterBKGCNTRRequestVO);
					}
				}
			}
			
			//1.[Delete Action] * 반드시 삭제 Action 이 먼저 실행되어야 한다. *
			if (deleteAfterBKGCNTRRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.removeAfterBookingContainer(deleteAfterBKGCNTRRequestVOS);
			}
			if (deleteAfterBKGRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.removeAfterBookingDAR(deleteAfterBKGRequestVOS);
			}	

			//2.[Insert Action]
			//Comment History 를 저장한다.
			//BackEndJob 으로 실행되는 Approval 처리시 아래로직은 실행하지 않는다. 
			if (afterProgressVO != null && !"Y".equals(afterProgressVO.getBackendJobFlag())) {
				
				if (!chgAmtDisMgtDBDAO.isDupAfterBookingRequest(afterProgressVO))
					chgAmtDisMgtDBDAO.addAfterBookingRequest(afterProgressVO);					// ( 1 레벨 ) DMT_AFT_BKG_ADJ_RQST
				else
					chgAmtDisMgtDBDAO.modifyAfterBookingRequest(afterProgressVO);
			
				chgAmtDisMgtDBDAO.addCommentHistory(afterProgressVO);
			}
			
			if (insertAfterBKGRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.addAfterBookingDAR(insertAfterBKGRequestVOS);					// ( 2 레벨 ) DMT_AFT_BKG_ADJ_RQST_DTL
			}				
			if (insertAfterBKGCNTRRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.addAfterBookingContainer(insertAfterBKGCNTRRequestVOS);		// ( 3 레벨 ) DMT_AFT_BKG_CNTR
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
	 * Location Code 와 I/O Bound Code 에 해당하는 Calcuation Type을 조회 합니다. <br>
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
	 * 승인처리를 위해서 BackEndJob 을 실행 합니다. <br>
	 *
	 * @param AfterBKGGRPVO afterBKGGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String doBackEndJobApproval(AfterBKGGRPVO afterBKGGRPVO, SignOnUserAccount account) {
		ChargeAmountDiscountBackEndJob	backEndJob 			= new ChargeAmountDiscountBackEndJob();
		BackEndJobManager				backEndJobManager 	= new BackEndJobManager();

		//BackEndJob 처리를 위해서 필요한 정보를 매개변수로 설정해준다.
		backEndJob.setUserAccount(account);
		backEndJob.setAfterBKGGRPVO(afterBKGGRPVO);
		
		//BackEndJob 모듈을 호출한다.
		return backEndJobManager.execute(backEndJob, afterBKGGRPVO.getAfterProgressVO().getCreUsrId(), "EES_DMT_2009 Create Back End");
	}
	
	/**
	 * Back End Job 공통. 상태를 리턴 합니다.<br>
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
	 * Back End Job 의 결과를 리턴 합니다.<br>
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
	 * After Booking Request 의 Update Date 정보를 조회 합니다.<br>
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
		
	/**
	 * 등록된 After Booking DAR 를 Office별로 결제 상태로 수정 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void approveOfcAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException {
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
	 * AfterBooking 승인처리 후, Reject/Counter Offer 실행시 가상Inovice 생성된게 있다면, 가상Invoice 를 취소한다. <br>
	 * 
	 * @param String aftExptDarNo
	 * @param String loginUsrId
	 * @param String loginOfcCd
	 * @exception EventException
	 */
	public void cancelVirtualInvoice(String aftExptDarNo, String loginUsrId, String loginOfcCd) throws EventException {

		try {
			if (chgAmtDisMgtDBDAO.isExistsVirtualInvoice(aftExptDarNo)) {
				chgAmtDisMgtDBDAO.cancelVirtualInvoice(aftExptDarNo, loginUsrId, loginOfcCd);
			}
		}
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * After Booking Actual Cost List 조회 <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return List<ActualCostListVO>
	 * @exception EventException
	 */
	public List<ActualCostListVO> searchActualCostList(AfterBKGListInputVO InputVO) throws EventException {
		try {
			return chgAmtDisMgtDBDAO.searchActualCostList(InputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}


	/**
	 * After Booking File List 조회 <br>
	 * 
	 * @param AfterBookingFileListVO InputVO
	 * @return List<AfterBookingFileListVO>
	 * @exception EventException
	 */
	public List<AfterBookingFileListVO> searchAfterBookingFileList(AfterBookingFileListVO InputVO) throws EventException{
		List<AfterBookingFileListVO> afterBookingFileListVOs =  new ArrayList<AfterBookingFileListVO>();
		List<AfterBookingFileListVO> comUpldFile		     =  null;
		try {
			afterBookingFileListVOs = chgAmtDisMgtDBDAO.searchAfterBookingFileList(InputVO);

			for (AfterBookingFileListVO afterBookingFileListVO : afterBookingFileListVOs) {		
				comUpldFile				 =  null;

				comUpldFile = chgAmtDisMgtDBDAO.searchComUpldFile(afterBookingFileListVO.getFileSavId());
				afterBookingFileListVO.setFileNm(comUpldFile.get(0).getFileNm());
				afterBookingFileListVO.setFileSize(comUpldFile.get(0).getFileSize());
				afterBookingFileListVO.setFilePath(comUpldFile.get(0).getFilePath());
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
		return afterBookingFileListVOs;
	}


	/**
	 * After Booking Expt Clr Rqst  조회 <br>
	 * 
	 * @param AfterBKGListVO[] InputVOs
	 * @return List<AfterBookingExptClrRqstVO>
	 * @exception EventException
	 */
	public List<AfterBookingExptClrRqstVO> searchAfterBookingExptClrRqst(AfterBKGListVO[] InputVOs) throws EventException{
		try {
			List<AfterBookingExptClrRqstVO> afterBookingExptClrRqstVOList = new ArrayList<AfterBookingExptClrRqstVO>();
			List<AfterBookingExptClrRqstVO> afterBookingExptClrRqstVOs = null;
			for (int i = 0 ; i < InputVOs.length ; i++) {
				afterBookingExptClrRqstVOs  = new ArrayList<AfterBookingExptClrRqstVO>();
				afterBookingExptClrRqstVOs = chgAmtDisMgtDBDAO.searchAfterBookingExptClrRqst(InputVOs[i]);
				
				for (AfterBookingExptClrRqstVO afterBookingExptClrRqstVO : afterBookingExptClrRqstVOs) {
					afterBookingExptClrRqstVOList.add(afterBookingExptClrRqstVO);
				}
			}
			
			return afterBookingExptClrRqstVOList;
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * After Booking FULL HISTORY 조회 <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return List<AfterBookingFullHistoryVO>
	 * @exception EventException
	 */
	public List<AfterBookingFullHistoryVO> searchAfterBookingFullHistory(AfterBKGListInputVO InputVO) throws EventException{
		try {
			return chgAmtDisMgtDBDAO.searchAfterBookingFullHistory(InputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * After Booking Reason Detail List 조회 <br>
	 * 
	 * @return List<AfterBookingReasonDescVO>
	 * @exception EventException
	 */
	public List<AfterBookingReasonDescVO> searchAfterBookingReasonDesc() throws EventException{
		try {
			return chgAmtDisMgtDBDAO.searchAfterBookingReasonDesc();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * After Booking Reason Detail List 조회 <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return List<AfterBookingReasonDetailVO>
	 * @exception EventException
	 */
	public List<AfterBookingReasonDetailVO> searchAfterBookingReasonDetail(AfterBKGListInputVO InputVO) throws EventException{
		try {
			return chgAmtDisMgtDBDAO.searchAfterBookingReasonDetail(InputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * After Booking Detail Reason List 조회 <br>
	 * 
	 * @param AfterBookingReasonDescVO InputVO
	 * @return List<AfterBookingDetailReasonListVO>
	 * @exception EventException
	 */
	public List<AfterBookingDetailReasonListVO> searchAfterBookingDetailReasonList(AfterBookingReasonDescVO InputVO) throws EventException{
		try {
			return chgAmtDisMgtDBDAO.searchAfterBookingDetailReasonList(InputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * After Booking Detail Reason List 조회 <br>
	 * 
	 * @param AfterBookingPfmcListVO InputVO
	 * @return List<AfterBookingPfmcListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("null")
	public List<AfterBookingPfmcListVO> searchAfterBookingPfmcList(AfterBookingPfmcListVO InputVO) throws EventException{
		try {

			List<AfterBookingPfmcListVO> resultVOS = null;
			if ( InputVO != null ){
				if ( !"".equals(InputVO.getFmDt())){
					resultVOS = chgAmtDisMgtDBDAO.searchAfterBookingPfmcList(InputVO);
				} else {
					resultVOS =  chgAmtDisMgtDBDAO.searchAfterBookingPfmc(InputVO);
				}
			}
			return resultVOS;
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}


	/**
	 * After Booking Approval Item List 조회 <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return List<AfterBookingAproItmVO>
	 * @exception EventException
	 */
	public List<AfterBookingAproItmVO> searchAfterBookingAproItm(AfterBKGListInputVO InputVO) throws EventException{
		try {
			return chgAmtDisMgtDBDAO.searchAfterBookingAproItm(InputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	

	/**
	 * After Booking Detail Request 생성 합니다. <br>
	 * 
	 * @param AfterBookingRequestDetailVO afterBookingRequestDetailVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
	public void createAfterBookingRequestDetail(AfterBookingRequestDetailVO afterBookingRequestDetailVO, SignOnUserAccount account) throws EventException{

		AfterBookingRsnRmkVO afterBookingRsnRmkVO = null;
		String specRsnCd = null;
				
		try {

			if (afterBookingRequestDetailVO == null) throw new EventException("");
			
			if ( "Y".equals(afterBookingRequestDetailVO.getInputVO().getRqstFlg()) ){
				
				
				AfterProgressVO afterProgressVO = afterBookingRequestDetailVO.getAfterProgressVO();
				
				if (afterProgressVO != null ) {
					afterProgressVO.setUpdUsrId(account.getUpd_usr_id());
					afterProgressVO.setUpdOfcCd(account.getOfc_cd());
					afterProgressVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
					
					chgAmtDisMgtDBDAO.modifyAfterUcCggPsblFlg(afterProgressVO);
				}
				
				List<ActualCostListVO> actualCostListVOs = afterBookingRequestDetailVO.getActualCostListVOs();
	
				if (actualCostListVOs != null && !actualCostListVOs.isEmpty()) {
					for (ActualCostListVO actualCostListVO : actualCostListVOs) {
						actualCostListVO.setUpdUsrId(account.getUpd_usr_id());
						actualCostListVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
					}
					chgAmtDisMgtDBDAO.modifyAfterBookingActualCost(actualCostListVOs);
				}
				
				/* DMT PFMC 저장 */
				List<AfterBookingPfmcListVO> afterBookingPfmcListVOs = afterBookingRequestDetailVO.getAfterBookingPfmcListVOs();
	
				if (afterBookingPfmcListVOs != null && !afterBookingPfmcListVOs.isEmpty()) {
					
					AfterBookingPfmcListVO afterBookingPfmcListVO = new AfterBookingPfmcListVO();			
					afterBookingPfmcListVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());			
					chgAmtDisMgtDBDAO.removeAfterBookingPfmc(afterBookingPfmcListVO);
					
					for (AfterBookingPfmcListVO afterBookingPfmcListVO1 : afterBookingPfmcListVOs) {
						afterBookingPfmcListVO1.setUpdUsrId(account.getUpd_usr_id());
						afterBookingPfmcListVO1.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
					}
					
					chgAmtDisMgtDBDAO.addAfterBookingPfmc(afterBookingPfmcListVOs);
				}
				

				/* MAS 저장 */
				List<AfterBookingMasListVO> afterBookingMasListVOs = afterBookingRequestDetailVO.getAfterBookingMasListVOs();
	
				if (afterBookingMasListVOs != null && !afterBookingMasListVOs.isEmpty()) {
					
					AfterBookingMasListVO afterBookingMasListVO = new AfterBookingMasListVO();			
					afterBookingMasListVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());			
					chgAmtDisMgtDBDAO.removeAfterBookingMasRqst(afterBookingMasListVO);
					
					for (AfterBookingMasListVO afterBookingMasListVO1 : afterBookingMasListVOs) {
						afterBookingMasListVO1.setUpdUsrId(account.getUpd_usr_id());
						afterBookingMasListVO1.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
					}
					
					chgAmtDisMgtDBDAO.addAfterBookingMasRqst(afterBookingMasListVOs);
				}
				
				
				List<AfterBookingExptClrRqstVO> afterBookingExptClrRqstVOs = afterBookingRequestDetailVO.getAfterBookingExptClrRqstVOs();
	
				if (afterBookingExptClrRqstVOs != null && !afterBookingExptClrRqstVOs.isEmpty()) {
					for (AfterBookingExptClrRqstVO afterBookingExptClrRqstVO : afterBookingExptClrRqstVOs) {
						afterBookingExptClrRqstVO.setUpdUsrId(account.getUpd_usr_id());
						afterBookingExptClrRqstVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
					}				
					chgAmtDisMgtDBDAO.modifyAfterBookingExptClrRqst(afterBookingExptClrRqstVOs);
				}
				
				
	
				List<AfterBookingFullHistoryVO> afterBookingFullHistoryVOs = afterBookingRequestDetailVO.getAfterBookingFullHistoryVOs();
				List<AfterBookingFullHistoryVO> updateFullHistoryVOs = new ArrayList<AfterBookingFullHistoryVO>();
				List<AfterBookingFullHistoryVO> deleteFullHistoryVOs = new ArrayList<AfterBookingFullHistoryVO>();
	
				if (afterBookingFullHistoryVOs != null && !afterBookingFullHistoryVOs.isEmpty()) {
					for (AfterBookingFullHistoryVO afterBookingFullHistoryVO : afterBookingFullHistoryVOs) {
						afterBookingFullHistoryVO.setUpdDt(account.getUpd_dt());
						afterBookingFullHistoryVO.setUpdUsrId(account.getUpd_usr_id());
						afterBookingFullHistoryVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
						
						if ( "D".equals(afterBookingFullHistoryVO.getIbflag())){
							deleteFullHistoryVOs.add(afterBookingFullHistoryVO);
						} else {
							updateFullHistoryVOs.add(afterBookingFullHistoryVO);
						}
					}
					chgAmtDisMgtDBDAO.removeAfterBookingFullHIstory(deleteFullHistoryVOs);
					chgAmtDisMgtDBDAO.modifyAfterBookingFullHIstory(updateFullHistoryVOs);
				}
				
				List<AfterBookingRsnRmkVO> afterBookingRsnRmkVOs = new ArrayList<AfterBookingRsnRmkVO>();
				
				specRsnCd = afterBookingRequestDetailVO.getAfterBookingReasonDescVO().getSpecRsnCd();
				
				if ( specRsnCd != null && !"".equals(specRsnCd)){
					afterBookingRsnRmkVO = new AfterBookingRsnRmkVO();
					
					afterBookingRsnRmkVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
					afterBookingRsnRmkVO.setAftBkgFileDivCd(specRsnCd);
					afterBookingRsnRmkVO.setAftBkgRmkLvl("0");
					afterBookingRsnRmkVO.setAftBkgRsnRmkRqstSeq("1");
					afterBookingRsnRmkVO.setUpdUsrId(account.getUpd_usr_id());
					
					afterBookingRsnRmkVOs.add(afterBookingRsnRmkVO); 
		
					List<AfterBookingFileListVO> afterBookingFileListVOS = new ArrayList<AfterBookingFileListVO>();
					AfterBookingFileListVO removeFileListVO = new AfterBookingFileListVO();
					
					removeFileListVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
					removeFileListVO.setAftBkgFileDivCd(specRsnCd);
					removeFileListVO.setAftBkgRmkLvl("remove");
					
					afterBookingFileListVOS.add(removeFileListVO);
					
					chgAmtDisMgtDBDAO.removeBookingFileUpload(afterBookingFileListVOS);
					
					chgAmtDisMgtDBDAO.removeAfterBookingRsnRmk(afterBookingRsnRmkVOs);
					
					List<AfterBookingReasonDetailVO> afterBookingReasonDetailVOs = afterBookingRequestDetailVO.getAfterBookingReasonDetailVOs();
					
					if (afterBookingReasonDetailVOs != null && !afterBookingReasonDetailVOs.isEmpty()) {
						int rmkRqstSeq = 0;
						for (AfterBookingReasonDetailVO afterBookingReasonDetailVO : afterBookingReasonDetailVOs) {
							rmkRqstSeq = rmkRqstSeq + 1;
							if ( !"".equals(afterBookingReasonDetailVO.getDetail1Type()) || "U".equals(afterBookingReasonDetailVO.getIbflag())){
									afterBookingRsnRmkVO = new AfterBookingRsnRmkVO();						
									afterBookingRsnRmkVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
									afterBookingRsnRmkVO.setAftBkgFileDivCd(specRsnCd);
									afterBookingRsnRmkVO.setAftBkgRmkLvl("1");
									afterBookingRsnRmkVO.setAftBkgRsnRmkRqstSeq(rmkRqstSeq+"");
									afterBookingRsnRmkVO.setAftBkgRmk(afterBookingReasonDetailVO.getDetail1Type());
									afterBookingRsnRmkVO.setUpdUsrId(account.getUpd_usr_id());						
									afterBookingRsnRmkVOs.add(afterBookingRsnRmkVO);
							}
							if ( !"".equals(afterBookingReasonDetailVO.getDetail2Type()) || "U".equals(afterBookingReasonDetailVO.getIbflag())){
								afterBookingRsnRmkVO = new AfterBookingRsnRmkVO();						
								afterBookingRsnRmkVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
								afterBookingRsnRmkVO.setAftBkgFileDivCd(specRsnCd);
								afterBookingRsnRmkVO.setAftBkgRmkLvl("2");
								afterBookingRsnRmkVO.setAftBkgRsnRmkRqstSeq(rmkRqstSeq+"");
								afterBookingRsnRmkVO.setAftBkgRmk(afterBookingReasonDetailVO.getDetail2Type());
								afterBookingRsnRmkVO.setUpdUsrId(account.getUpd_usr_id());						
								afterBookingRsnRmkVOs.add(afterBookingRsnRmkVO);
							}
							if ( !"".equals(afterBookingReasonDetailVO.getDetail3Type()) || "U".equals(afterBookingReasonDetailVO.getIbflag())){
								afterBookingRsnRmkVO = new AfterBookingRsnRmkVO();						
								afterBookingRsnRmkVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
								afterBookingRsnRmkVO.setAftBkgFileDivCd(specRsnCd);
								afterBookingRsnRmkVO.setAftBkgRmkLvl("3");
								afterBookingRsnRmkVO.setAftBkgRsnRmkRqstSeq(rmkRqstSeq+"");
								afterBookingRsnRmkVO.setAftBkgRmk(afterBookingReasonDetailVO.getDetail3Type());
								afterBookingRsnRmkVO.setUpdUsrId(account.getUpd_usr_id());						
								afterBookingRsnRmkVOs.add(afterBookingRsnRmkVO);
							}
							if ( !"".equals(afterBookingReasonDetailVO.getDetail4Type()) || "U".equals(afterBookingReasonDetailVO.getIbflag())){	
								afterBookingRsnRmkVO = new AfterBookingRsnRmkVO();						
								afterBookingRsnRmkVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
								afterBookingRsnRmkVO.setAftBkgFileDivCd(specRsnCd);
								afterBookingRsnRmkVO.setAftBkgRmkLvl("4");
								afterBookingRsnRmkVO.setAftBkgRsnRmkRqstSeq(rmkRqstSeq+"");
								afterBookingRsnRmkVO.setAftBkgRmk(afterBookingReasonDetailVO.getDetail4Type());
								afterBookingRsnRmkVO.setUpdUsrId(account.getUpd_usr_id());						
								afterBookingRsnRmkVOs.add(afterBookingRsnRmkVO);
							}
							if ( !"".equals(afterBookingReasonDetailVO.getDetail5Type()) || "U".equals(afterBookingReasonDetailVO.getIbflag())){	
								afterBookingRsnRmkVO = new AfterBookingRsnRmkVO();						
								afterBookingRsnRmkVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
								afterBookingRsnRmkVO.setAftBkgFileDivCd(specRsnCd);
								afterBookingRsnRmkVO.setAftBkgRmkLvl("5");
								afterBookingRsnRmkVO.setAftBkgRsnRmkRqstSeq(rmkRqstSeq+"");
								afterBookingRsnRmkVO.setAftBkgRmk(afterBookingReasonDetailVO.getDetail5Type());
								afterBookingRsnRmkVO.setUpdUsrId(account.getUpd_usr_id());						
								afterBookingRsnRmkVOs.add(afterBookingRsnRmkVO);
							}
							if ( !"".equals(afterBookingReasonDetailVO.getDetail6Type()) || "U".equals(afterBookingReasonDetailVO.getIbflag())){
								afterBookingRsnRmkVO = new AfterBookingRsnRmkVO();						
								afterBookingRsnRmkVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
								afterBookingRsnRmkVO.setAftBkgFileDivCd(specRsnCd);
								afterBookingRsnRmkVO.setAftBkgRmkLvl("6");
								afterBookingRsnRmkVO.setAftBkgRsnRmkRqstSeq(rmkRqstSeq+"");
								afterBookingRsnRmkVO.setAftBkgRmk(afterBookingReasonDetailVO.getDetail6Type());
								afterBookingRsnRmkVO.setUpdUsrId(account.getUpd_usr_id());						
								afterBookingRsnRmkVOs.add(afterBookingRsnRmkVO);
							}
							if ( !"".equals(afterBookingReasonDetailVO.getDetail7Type()) || "U".equals(afterBookingReasonDetailVO.getIbflag())){	
								afterBookingRsnRmkVO = new AfterBookingRsnRmkVO();						
								afterBookingRsnRmkVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
								afterBookingRsnRmkVO.setAftBkgFileDivCd(specRsnCd);
								afterBookingRsnRmkVO.setAftBkgRmkLvl("7");
								afterBookingRsnRmkVO.setAftBkgRsnRmkRqstSeq(rmkRqstSeq+"");
								afterBookingRsnRmkVO.setAftBkgRmk(afterBookingReasonDetailVO.getDetail7Type());
								afterBookingRsnRmkVO.setUpdUsrId(account.getUpd_usr_id());						
								afterBookingRsnRmkVOs.add(afterBookingRsnRmkVO);
							}
							if ( !"".equals(afterBookingReasonDetailVO.getDetail8Type()) || "U".equals(afterBookingReasonDetailVO.getIbflag())){	
								afterBookingRsnRmkVO = new AfterBookingRsnRmkVO();						
								afterBookingRsnRmkVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
								afterBookingRsnRmkVO.setAftBkgFileDivCd(specRsnCd);
								afterBookingRsnRmkVO.setAftBkgRmkLvl("8");
								afterBookingRsnRmkVO.setAftBkgRsnRmkRqstSeq(rmkRqstSeq+"");
								afterBookingRsnRmkVO.setAftBkgRmk(afterBookingReasonDetailVO.getDetail8Type());
								afterBookingRsnRmkVO.setUpdUsrId(account.getUpd_usr_id());						
								afterBookingRsnRmkVOs.add(afterBookingRsnRmkVO);
							}
							if ( !"".equals(afterBookingReasonDetailVO.getDetail9Type()) || "U".equals(afterBookingReasonDetailVO.getIbflag())){	
								afterBookingRsnRmkVO = new AfterBookingRsnRmkVO();						
								afterBookingRsnRmkVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
								afterBookingRsnRmkVO.setAftBkgFileDivCd(specRsnCd);
								afterBookingRsnRmkVO.setAftBkgRmkLvl("9");
								afterBookingRsnRmkVO.setAftBkgRsnRmkRqstSeq(rmkRqstSeq+"");
								afterBookingRsnRmkVO.setAftBkgRmk(afterBookingReasonDetailVO.getDetail9Type());
								afterBookingRsnRmkVO.setUpdUsrId(account.getUpd_usr_id());						
								afterBookingRsnRmkVOs.add(afterBookingRsnRmkVO);
							}
						}				
					}
					chgAmtDisMgtDBDAO.modifyAfterBookingRsnRmk(afterBookingRsnRmkVOs);
				}

				List<AfterBookingFileListVO> afterBookingFileListVOs = afterBookingRequestDetailVO.getAfterBookingFileListVOs();
				
				List<AfterBookingFileListVO> updateAfterBookingFileListVOS = new ArrayList<AfterBookingFileListVO>();
				List<AfterBookingFileListVO> deleteAfterBookingFileListVOS = new ArrayList<AfterBookingFileListVO>();
	
				if (afterBookingFileListVOs != null && !afterBookingFileListVOs.isEmpty()) {
					for (AfterBookingFileListVO afterBookingFileListVO : afterBookingFileListVOs) {					
						if ("I".equals(afterBookingFileListVO.getIbflag()) || "U".equals(afterBookingFileListVO.getIbflag())) {
	
							afterBookingFileListVO.setUpdUsrId(account.getUpd_usr_id());
							afterBookingFileListVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
							
							updateAfterBookingFileListVOS.add(afterBookingFileListVO);
						} 
						else if ("D".equals(afterBookingFileListVO.getIbflag())) {
							afterBookingFileListVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
							deleteAfterBookingFileListVOS.add(afterBookingFileListVO);
						}
					}
					if ( deleteAfterBookingFileListVOS != null){
						chgAmtDisMgtDBDAO.removeBookingFileUpload(deleteAfterBookingFileListVOS);
					}
					if ( updateAfterBookingFileListVOS != null){
						chgAmtDisMgtDBDAO.modifyAfterBookingFileUpload(updateAfterBookingFileListVOS);
					}
				}
				
			} else {

//				List<AfterBookingAproItmVO> afterBookingAproItmVOs = afterBookingRequestDetailVO.getAfterBookingAproItmVOs();
//
//				if (afterBookingAproItmVOs != null && !afterBookingAproItmVOs.isEmpty()) {
//					for (AfterBookingAproItmVO afterBookingAproItmVO : afterBookingAproItmVOs) {	
//						afterBookingAproItmVO.setUpdUsrId(account.getUpd_usr_id());
//						afterBookingAproItmVO.setAftExptDarNo(afterBookingRequestDetailVO.getInputVO().getDarNo());
//						afterBookingAproItmVO.setAftBkgPathCd(afterBookingRequestDetailVO.getInputVO().getApvlPathCd());
//					}
//					chgAmtDisMgtDBDAO.modifyAfterBookingAproRmk(afterBookingAproItmVOs);
//				}
			}
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * After Booking DAR를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param AfterBKGGRPVO afterBKGGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void requestAfterBookingTSave(AfterBKGGRPVO afterBKGGRPVO,	SignOnUserAccount account) throws EventException {
		
		try {
			if (afterBKGGRPVO == null) throw new EventException("");
			
			AfterProgressVO afterProgressVO = afterBKGGRPVO.getAfterProgressVO();
			
			String	usrId	= "";
			String	ofcCd	= "";
			
			if (account != null) {
				// ALPS 호출시 Session 정보가 있다.
				usrId	= account.getUsr_id();
				ofcCd	= account.getOfc_cd();
			} else {
				// 모바일 호출 시 Session 내 User 정보가 없다.
				usrId	= afterProgressVO.getCreUsrId();
				ofcCd	= afterProgressVO.getCreOfcCd();
			}
			
			if (afterProgressVO != null) {
				afterProgressVO.setCreUsrId( usrId );
				afterProgressVO.setCreOfcCd( ofcCd );
				afterProgressVO.setUpdUsrId( usrId );
				afterProgressVO.setUpdOfcCd( ofcCd );
			}
			
			List<AfterBKGRequestVO> afterBKGRequestVOS = afterBKGGRPVO.getAfterBKGRequestVOS();
			List<AfterBKGRequestVO> insertAfterBKGRequestVOS = new ArrayList<AfterBKGRequestVO>();
			List<AfterBKGRequestVO> updateAfterBKGRequestVOS = new ArrayList<AfterBKGRequestVO>();
			List<AfterBKGRequestVO> deleteAfterBKGRequestVOS = new ArrayList<AfterBKGRequestVO>();

			if (afterBKGRequestVOS != null && !afterBKGRequestVOS.isEmpty()) {
				for (AfterBKGRequestVO afterBKGRequestVO : afterBKGRequestVOS) {
					if ("I".equals(afterBKGRequestVO.getIbflag())) {
						afterBKGRequestVO.setCreUsrId( usrId );
						afterBKGRequestVO.setCreOfcCd( ofcCd );
						
						insertAfterBKGRequestVOS.add(afterBKGRequestVO);
					} 
					else if ("U".equals(afterBKGRequestVO.getIbflag())) {
						afterBKGRequestVO.setUpdUsrId( usrId );
						afterBKGRequestVO.setUpdOfcCd( ofcCd );
						
						updateAfterBKGRequestVOS.add(afterBKGRequestVO);
					} 
					else if ("D".equals(afterBKGRequestVO.getIbflag())) {
						deleteAfterBKGRequestVOS.add(afterBKGRequestVO);
					}
				}
			}
			
			List<AfterBKGCNTRRequestVO> afterBKGCNTRRequestVOS = afterBKGGRPVO.getAfterBKGCNTRRequestVOS();	
			List<AfterBKGCNTRRequestVO> insertAfterBKGCNTRRequestVOS = new ArrayList<AfterBKGCNTRRequestVO>();
			List<AfterBKGCNTRRequestVO> updateAfterBKGCNTRRequestVOS = new ArrayList<AfterBKGCNTRRequestVO>();
			List<AfterBKGCNTRRequestVO> deleteAfterBKGCNTRRequestVOS = new ArrayList<AfterBKGCNTRRequestVO>();

			if (afterBKGCNTRRequestVOS != null && !afterBKGCNTRRequestVOS.isEmpty()) {
				for (AfterBKGCNTRRequestVO afterBKGCNTRRequestVO : afterBKGCNTRRequestVOS) {
					if ("I".equals(afterBKGCNTRRequestVO.getIbflag())) {
						afterBKGCNTRRequestVO.setCreUsrId( usrId );
						afterBKGCNTRRequestVO.setCreOfcCd( ofcCd );
						
						insertAfterBKGCNTRRequestVOS.add(afterBKGCNTRRequestVO);
					} 
					else if ("U".equals(afterBKGCNTRRequestVO.getIbflag())) {
						afterBKGCNTRRequestVO.setUpdUsrId( usrId );
						afterBKGCNTRRequestVO.setUpdOfcCd( ofcCd );
						
						updateAfterBKGCNTRRequestVOS.add(afterBKGCNTRRequestVO);
					} 
					else if ("D".equals(afterBKGCNTRRequestVO.getIbflag())) {
						deleteAfterBKGCNTRRequestVOS.add(afterBKGCNTRRequestVO);
					}
				}
			}
			
			//1.[Delete Action] * 반드시 삭제 Action 이 먼저 실행되어야 한다. *
			if (deleteAfterBKGCNTRRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.removeAfterBookingContainer(deleteAfterBKGCNTRRequestVOS);
			}
			if (deleteAfterBKGRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.removeAfterBookingDAR(deleteAfterBKGRequestVOS);
			}	

			if (insertAfterBKGRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.addAfterBookingDAR(insertAfterBKGRequestVOS);					// ( 2 레벨 ) DMT_AFT_BKG_ADJ_RQST_DTL
			}				
			if (insertAfterBKGCNTRRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.addAfterBookingContainer(insertAfterBKGCNTRRequestVOS);		// ( 3 레벨 ) DMT_AFT_BKG_CNTR
			}
			
			//3.[Update Action]
			if (updateAfterBKGRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.modifyAfterBookingDAR(updateAfterBKGRequestVOS);
			}
			if (updateAfterBKGCNTRRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.modifyAfterBookingContainer(updateAfterBKGCNTRRequestVOS);
			}	
			
			if (afterProgressVO != null && !"Y".equals(afterProgressVO.getBackendJobFlag())) {
				
				if (!chgAmtDisMgtDBDAO.isDupAfterBookingRequest(afterProgressVO))
					chgAmtDisMgtDBDAO.addAfterBookingRequest(afterProgressVO);					// ( 1 레벨 ) DMT_AFT_BKG_ADJ_RQST
				else
					chgAmtDisMgtDBDAO.modifyAfterBookingRequest(afterProgressVO);

				if ( "R".equals(afterProgressVO.getDmdtExptRqstStsCd())){
					chgAmtDisMgtDBDAO.modifyAfterBookingAproItm(afterProgressVO);
					chgAmtDisMgtDBDAO.modifyAfterBookingAproPath(afterProgressVO);
				}
//				if ( !"T".equals(afterProgressVO.getDmdtExptRqstStsCd())){
					chgAmtDisMgtDBDAO.addCommentHistory(afterProgressVO);
//				}
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
	 * After Booking Detail 목록을 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<AfterBookingDetailFlgVO>
	 * @throws DAOException
	 */
	public List<AfterBookingDetailFlgVO> searchAfterBookingDetailFlg(AfterBKGListInputVO afterBKGListInputVO) throws EventException{
		try {
			return chgAmtDisMgtDBDAO.searchAfterBookingDetailFlg(afterBKGListInputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * After Booking DAR를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param AfterBKGGRPVO afterBKGGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void requestAfterBookingSave(AfterBKGGRPVO afterBKGGRPVO,	SignOnUserAccount account) throws EventException {
		
		try {
			if (afterBKGGRPVO == null) throw new EventException("");
			
			AfterProgressVO afterProgressVO = afterBKGGRPVO.getAfterProgressVO();
			
			String	usrId	= "";
			String	ofcCd	= "";
			
			if (account != null) {
				// ALPS 호출시 Session 정보가 있다.
				usrId	= account.getUsr_id();
				ofcCd	= account.getOfc_cd();
			} else {
				// 모바일 호출 시 Session 내 User 정보가 없다.
				usrId	= afterProgressVO.getCreUsrId();
				ofcCd	= afterProgressVO.getCreOfcCd();
			}
			
			if (afterProgressVO != null) {
				afterProgressVO.setCreUsrId( usrId );
				afterProgressVO.setCreOfcCd( ofcCd );
				afterProgressVO.setUpdUsrId( usrId );
				afterProgressVO.setUpdOfcCd( ofcCd );
			}
			
			List<AfterBKGRequestVO> afterBKGRequestVOS = afterBKGGRPVO.getAfterBKGRequestVOS();
			List<AfterBKGRequestVO> insertAfterBKGRequestVOS = new ArrayList<AfterBKGRequestVO>();
			List<AfterBKGRequestVO> updateAfterBKGRequestVOS = new ArrayList<AfterBKGRequestVO>();
			List<AfterBKGRequestVO> deleteAfterBKGRequestVOS = new ArrayList<AfterBKGRequestVO>();

			if (afterBKGRequestVOS != null && !afterBKGRequestVOS.isEmpty()) {
				for (AfterBKGRequestVO afterBKGRequestVO : afterBKGRequestVOS) {
					if ("I".equals(afterBKGRequestVO.getIbflag())) {
						afterBKGRequestVO.setCreUsrId( usrId );
						afterBKGRequestVO.setCreOfcCd( ofcCd );
						
						insertAfterBKGRequestVOS.add(afterBKGRequestVO);
					} 
					else if ("U".equals(afterBKGRequestVO.getIbflag())) {
						afterBKGRequestVO.setUpdUsrId( usrId );
						afterBKGRequestVO.setUpdOfcCd( ofcCd );
						
						updateAfterBKGRequestVOS.add(afterBKGRequestVO);
					} 
					else if ("D".equals(afterBKGRequestVO.getIbflag())) {
						deleteAfterBKGRequestVOS.add(afterBKGRequestVO);
					}
				}
			}
			
			List<AfterBKGCNTRRequestVO> afterBKGCNTRRequestVOS = afterBKGGRPVO.getAfterBKGCNTRRequestVOS();	
			List<AfterBKGCNTRRequestVO> insertAfterBKGCNTRRequestVOS = new ArrayList<AfterBKGCNTRRequestVO>();
			List<AfterBKGCNTRRequestVO> updateAfterBKGCNTRRequestVOS = new ArrayList<AfterBKGCNTRRequestVO>();
			List<AfterBKGCNTRRequestVO> deleteAfterBKGCNTRRequestVOS = new ArrayList<AfterBKGCNTRRequestVO>();

			if (afterBKGCNTRRequestVOS != null && !afterBKGCNTRRequestVOS.isEmpty()) {
				for (AfterBKGCNTRRequestVO afterBKGCNTRRequestVO : afterBKGCNTRRequestVOS) {
					if ("I".equals(afterBKGCNTRRequestVO.getIbflag())) {
						afterBKGCNTRRequestVO.setCreUsrId( usrId );
						afterBKGCNTRRequestVO.setCreOfcCd( ofcCd );
						
						insertAfterBKGCNTRRequestVOS.add(afterBKGCNTRRequestVO);
					} 
					else if ("U".equals(afterBKGCNTRRequestVO.getIbflag())) {
						afterBKGCNTRRequestVO.setUpdUsrId( usrId );
						afterBKGCNTRRequestVO.setUpdOfcCd( ofcCd );
						
						updateAfterBKGCNTRRequestVOS.add(afterBKGCNTRRequestVO);
					} 
					else if ("D".equals(afterBKGCNTRRequestVO.getIbflag())) {
						deleteAfterBKGCNTRRequestVOS.add(afterBKGCNTRRequestVO);
					}
				}
			}
			
			//1.[Delete Action] * 반드시 삭제 Action 이 먼저 실행되어야 한다. *
			if (deleteAfterBKGCNTRRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.removeAfterBookingContainer(deleteAfterBKGCNTRRequestVOS);
			}
			if (deleteAfterBKGRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.removeAfterBookingDAR(deleteAfterBKGRequestVOS);
			}	

			//2.[Insert Action]
			//Comment History 를 저장한다.
			//BackEndJob 으로 실행되는 Approval 처리시 아래로직은 실행하지 않는다. 
			if (afterProgressVO != null && !"Y".equals(afterProgressVO.getBackendJobFlag())) {
				
				if (!chgAmtDisMgtDBDAO.isDupAfterBookingRequest(afterProgressVO))
					chgAmtDisMgtDBDAO.addAfterBookingRequest(afterProgressVO);					// ( 1 레벨 ) DMT_AFT_BKG_ADJ_RQST
				else
					chgAmtDisMgtDBDAO.modifyAfterBookingRequest(afterProgressVO);
			
				chgAmtDisMgtDBDAO.addCommentHistory(afterProgressVO);
			}
			
			if (insertAfterBKGRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.addAfterBookingDAR(insertAfterBKGRequestVOS);					// ( 2 레벨 ) DMT_AFT_BKG_ADJ_RQST_DTL
			}				
			if (insertAfterBKGCNTRRequestVOS.size() > 0) {
				chgAmtDisMgtDBDAO.addAfterBookingContainer(insertAfterBKGCNTRRequestVOS);		// ( 3 레벨 ) DMT_AFT_BKG_CNTR
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
	 * After Booking Approvl Path 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<CommentHistoryVO>
	 * @exception EventException
	 */
	public List<CommentHistoryVO> searchAproPath(AfterBKGListInputVO afterBKGListInputVO) throws EventException {

		try {
			return chgAmtDisMgtDBDAO.searchAproPath(afterBKGListInputVO);			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * After Booking DAR를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void modifyAfterBookingStatusUpdate(AfterProgressVO afterProgressVO,	SignOnUserAccount account) throws EventException {
		
		try {
				if (afterProgressVO == null) throw new EventException("");
							
				String	usrId	= "";
				String	ofcCd	= "";
				
				if (account != null) {
					// ALPS 호출시 Session 정보가 있다.
					usrId	= account.getUsr_id();
					ofcCd	= account.getOfc_cd();
				} else {
					// 모바일 호출 시 Session 내 User 정보가 없다.
					usrId	= afterProgressVO.getCreUsrId();
					ofcCd	= afterProgressVO.getCreOfcCd();
				}
				
				if (afterProgressVO != null) {
					afterProgressVO.setCreUsrId( usrId );
					afterProgressVO.setCreOfcCd( ofcCd );
					afterProgressVO.setUpdUsrId( usrId );
					afterProgressVO.setUpdOfcCd( ofcCd );
				}
				
				if (afterProgressVO != null) {
					chgAmtDisMgtDBDAO.modifyAfterBookingRequest(afterProgressVO);
					chgAmtDisMgtDBDAO.modifyAfterBookingApprovalStatus(afterProgressVO);
					chgAmtDisMgtDBDAO.addCommentHistory(afterProgressVO);
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
	 * After Booking Path Code, Role Status Code 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAfterBookingPathRole(AfterBKGListInputVO InputVO) throws EventException {
		try {
			return chgAmtDisMgtDBDAO.searchAfterBookingPathRole(InputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * After Booking Path Code, Role Status Code 조회 합니다. <br>
	 * 
	 * @param ChargeBookingContainerParmVO paramVO
	 * @return String
	 * @exception EventException
	 */
	public String searchExchangeRate(ChargeBookingContainerParmVO paramVO) throws EventException {
		try {
			return chgAmtDisMgtDBDAO.searchExchangeRate(paramVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * BKG/B/L No 의 Tariff Type 에 맞는 Location Code를 조회 합니다. <br>
	 * 
	 * @param ChargeBookingContainerVO chargeBookingContainerVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAfterBookingRsnVal(ChargeBookingContainerVO chargeBookingContainerVO) throws EventException {
		try {
			return chgAmtDisMgtDBDAO.searchAfterBookingRsnVal(chargeBookingContainerVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * After Booking Reason Detail List 조회 <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return List<AfterBookingReasonDetailVO>
	 * @exception EventException
	 */
	public List<AfterBookingReasonDetailVO> searchAfterBookingReasonUcTtl(AfterBKGListInputVO InputVO) throws EventException{
		try {
			List<AfterBookingReasonDetailVO> List = chgAmtDisMgtDBDAO.searchAfterBookingReasonUcTtl(InputVO);
			
			for (AfterBookingReasonDetailVO afterBookingReasonDetailVO : List) {
				ChargeBookingContainerVO chargeBookingContainerVO = new ChargeBookingContainerVO();
				
				chargeBookingContainerVO.setBkgNo(afterBookingReasonDetailVO.getDetail1Type());
				chargeBookingContainerVO.setCntrNo(afterBookingReasonDetailVO.getDetail2Type());
				chargeBookingContainerVO.setDmdtTrfCd(afterBookingReasonDetailVO.getDetail3Type());
				
				String rsnVal = chgAmtDisMgtDBDAO.searchAfterBookingRsnVal(chargeBookingContainerVO);
				
				String[] arrRsnVal         = rsnVal.split("\\|");				

				afterBookingReasonDetailVO.setDetail3Type(arrRsnVal[0].toString());
				afterBookingReasonDetailVO.setDetail4Type(arrRsnVal[1].toString());
			}
			
			return List;
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * After Booking Actual Cost List 조회 <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return String
	 * @exception EventException
	 */
	public String searchUcCgoPsblFlg(AfterBKGListInputVO InputVO) throws EventException {
		try {
			return chgAmtDisMgtDBDAO.searchUcCgoPsblFlg(InputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * After Booking Detail Reason List 조회 <br>
	 * 
	 * @param AfterBookingMasListVO InputVO
	 * @return List<AfterBookingMasListVO>
	 * @exception EventException
	 */
	public List<AfterBookingMasListVO> searchAfterBookingMasList(AfterBookingMasListVO InputVO) throws EventException{
		try {

			List<AfterBookingMasListVO> resultVOS = null;
			if ( InputVO != null ){
				if ( "Y".equals(InputVO.getRetriveFlg())){
					resultVOS = chgAmtDisMgtDBDAO.searchAfterBookingMasList(InputVO);
				} else {
					resultVOS = chgAmtDisMgtDBDAO.searchAfterBookingMasRqstList(InputVO);
				}
			}
			return resultVOS;
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * VVD 유무 <br>
	 * 
	 * @param String vvdCd
	 * @return String
	 * @exception EventException
	 */
	public String searchAfterBookingVvdCd(String vvdCd) throws EventException {
		try {
			return chgAmtDisMgtDBDAO.searchAfterBookingVvdCd(vvdCd);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}


	/**
	 * After Booking 제목 조회 합니다. <br>
	 * 
	 * @param String darNo
	 * @return String
	 * @exception EventException
	 */
	public String searchAfterBookingSubject(String darNo) throws EventException {
		try {
			return chgAmtDisMgtDBDAO.searchAfterBookingSubject(darNo);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	/**
	 * After Booking Request & Approval STS List 조회 <br>
	 * 
	 * @param AfterBkgRqstAproStsParamVO afterBkgRqstAproStsParamVO
	 * @param SignOnUserAccount account
	 * @return List<AfterBkgRqstAproStsVO>
	 * @exception EventException
	 */
	public List<AfterBkgRqstAproStsVO> searchAfterBookingrRequestApprovalStatusList(AfterBkgRqstAproStsParamVO afterBkgRqstAproStsParamVO, SignOnUserAccount account) throws EventException {
		try {			
			return chgAmtDisMgtDBDAO.searchAfterBookingrRequestApprovalStatusList(afterBkgRqstAproStsParamVO, account);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * After Booking DAR를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param AfterBKGGRPVO afterBKGGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void approvalAfterBookingDAR(AfterBKGGRPVO afterBKGGRPVO,	SignOnUserAccount account) throws EventException {
		
		try {
			if (afterBKGGRPVO == null) throw new EventException("");
			
			AfterProgressVO afterProgressVO = afterBKGGRPVO.getAfterProgressVO();
			
			String	usrId	= "";
			String	ofcCd	= "";
			
			if (account != null) {
				// ALPS 호출시 Session 정보가 있다.
				usrId	= account.getUsr_id();
				ofcCd	= account.getOfc_cd();
			} else {
				// 모바일 호출 시 Session 내 User 정보가 없다.
				usrId	= afterProgressVO.getCreUsrId();
				ofcCd	= afterProgressVO.getCreOfcCd();
			}
			
			if (afterProgressVO != null) {
				afterProgressVO.setCreUsrId( usrId );
				afterProgressVO.setCreOfcCd( ofcCd );
				afterProgressVO.setUpdUsrId( usrId );
				afterProgressVO.setUpdOfcCd( ofcCd );
			}
			
			chgAmtDisMgtDBDAO.modifyApprovalAfterBookingContainer(afterProgressVO);
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
	 * After Booking Office Code Check 로직 조회 <br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchOfcChkFlg() throws EventException {
		try {			
			return chgAmtDisMgtDBDAO.searchOfcChkFlg();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}

}
