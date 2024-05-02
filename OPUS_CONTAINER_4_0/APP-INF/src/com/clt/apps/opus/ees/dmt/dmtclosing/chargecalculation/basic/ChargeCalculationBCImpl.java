/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationBCImpl.java
*@FileTitle : Charge Calculation by Office & VVD
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier 
*@LastVersion : 
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration.ChargeCalculationDBDAO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.AfterExceptionTariffParmVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.AfterExceptionTariffVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.BasicCurrencyCoverageVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.BasicTariffParmVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.BeforeExceptionTariffVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.BkgContainerInfoVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.BookingCustomerBasicVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeBasicFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeByOfficeOrVVDVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationDetailVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDeletionRequstVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDetailVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargePartialPaymentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeStatusNRemarkVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ClockStopVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.CommodityGroupTariffVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.CommodityTariffParmVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DeleteReasonListVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgBkgCntrVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCalcVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCorrHisVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgTmCskStopVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.EDIVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ManualChargeCreationVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.MovementSZPBBParmVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.MovementSZPBBVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.OfficeTransferParmByChargeVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.SCExceptionTariffVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.VDMovementVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.OfficeNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.BKGChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTBalanceChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCancelChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCombinedChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTDualChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTGeneralChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffKeyVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationAMTVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationTypeParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerCntrVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerGrpVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerInvVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChrgDtlVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExchangeRateParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeEndParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeStartParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.LocationByBoundParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.LocationByBoundVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMgtVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.VVDCheckDataVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoEdiTransVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

import java.io.IOException;
import com.clt.syscommon.common.util.ScheduleUtil;

//import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTExceptionChargeCalculationUtil; 			//add
//import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExceptionChargeCalculationVO;				//add

/**
 * OPUS-DMTClosing Business Logic Basic Command implementation<br>
 * @author
 * @see reference DAO of  EES_DMT_3001EventResponse,ChargeCalculationBC
 * @since J2EE 1.6
 */
public class ChargeCalculationBCImpl extends BasicCommandSupport implements ChargeCalculationBC {

	// Database Access Object
	private static final long serialVersionUID = -4150151981336531750L;
	private transient ChargeCalculationDBDAO dbDao = null;
	private DMTCalculationUtil dmtCalculationUtil = null;

	/**
	 * ChargeCalculationBCImpl create object<br>
	 * create ChargeCalculationDBDAO<br>
	 */
	public ChargeCalculationBCImpl() {
		dbDao = new ChargeCalculationDBDAO();
		dmtCalculationUtil = new DMTCalculationUtil();
	}
	
	/**
	 * search Charge List by Office or VVD<br>
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchChargeListByOfficeOrVVD(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws EventException {
		try {
			return dbDao.searchChargeListByOfficeOrVVD(chargeByOfficeOrVVDVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge List by Office/VVD"}).getMessage());
		} catch (Exception ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge List by Office/VVD"}).getMessage());
		}
	}
	
	/**
	 * search Container List by Yard<br>
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO searchChargeListByPodEta(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws EventException {
		try {
			DmtResultVO dmtResultVO = new DmtResultVO();
			Map<String, String> resEtcData = new HashMap<String, String>();
			//Map<String, Object> responseData = new HashMap<String, Object>();
			
			String orgBkgNo = null;
			String orgBlNo = null;
			
			if( !"vvd_cd".equals(chargeByOfficeOrVVDVO.getCondType()) ) {
				orgBkgNo = chargeByOfficeOrVVDVO.getBkgNo();
				orgBlNo = chargeByOfficeOrVVDVO.getBlNo();
			}
			
			List<String> schNoList = new ArrayList<String>();
			boolean bkgNoFlag = true;
			String schNo = null;
			
			if(orgBkgNo != null) {
				if(!chargeByOfficeOrVVDVO.getBkgNo().equals("")) {
					schNo = chargeByOfficeOrVVDVO.getBkgNo();
				} else {
					schNo = chargeByOfficeOrVVDVO.getBlNo();
					bkgNoFlag = false;
				}
			} else {
				schNo = chargeByOfficeOrVVDVO.getVvdCd();
			}
			
			if(schNo.indexOf(',') != -1) {
				StringTokenizer st = new StringTokenizer(schNo, ",");
			    while (st.hasMoreTokens()) {
			    	schNoList.add(st.nextToken());
			    }
			} else {
				schNoList.add(schNo);
			}
			
			
			for(int i=0; i < schNoList.size(); i++) {
				// 3001 - case in not VVD_CD 
				if(orgBkgNo != null) {
					if(bkgNoFlag)
						chargeByOfficeOrVVDVO.setBkgNo(schNoList.get(i));
					else
						chargeByOfficeOrVVDVO.setBlNo(schNoList.get(i));
				}
				
				
				// calling DMTCalculationUtil.searchCalculationType() case in byPODETA  
				CalculationTypeParmVO calcTypeParmVO = dbDao.searchMdmLocation(chargeByOfficeOrVVDVO);
				
				if(calcTypeParmVO == null) {
					dmtResultVO.setResultCode("DMT01075");
					return dmtResultVO;	
				}
				
				if(!"vvd_cd".equals(chargeByOfficeOrVVDVO.getCondType()) && !"SINHO".equals(chargeByOfficeOrVVDVO.getUsrRhqOfcCd()) ) {
					if(!chargeByOfficeOrVVDVO.getUsrRhqOfcCd().equals(calcTypeParmVO.getLocRhqCd())) {
						dmtResultVO.setResultCode("DMT01129");
						return dmtResultVO;	
					}
				}
				
				calcTypeParmVO.setIoBnd("I");
				calcTypeParmVO.setPodEtaYn("Y");
				calcTypeParmVO.setPodLoc(chargeByOfficeOrVVDVO.getPodCd());
				calcTypeParmVO.setPolLoc(chargeByOfficeOrVVDVO.getPolCd());
				
				String calcType = dmtCalculationUtil.searchCalculationType(calcTypeParmVO);
				
				// 'D'ual / 'C'ombined(error)
				if("C".equals(calcType)) {
					/* 
					 case in searching  byPODETA  create new ChargeByBookingHeaderVO 
					 at Charge Calculation by Booking for header info Clearing
					*/
					if(chargeByOfficeOrVVDVO.getBypodeta().equals("booking")) {
						DmtChgBkgCntrVO dmtChgBkgCntrVO = new DmtChgBkgCntrVO();
						
						Map<String, String> etcData = dmtChgBkgCntrVO.getColumnValues();
						Set<String> keys = etcData.keySet();
						Iterator<String> it = keys.iterator();
						
						while(it.hasNext()) {
							String key = (String)it.next();
							etcData.put(key, "");
						}
						
						resEtcData.putAll(etcData);
					}
					
					String errMsg = new ErrorHandler("DMT01053").getUserMessage();
					errMsg = errMsg.replace("Location Code", calcTypeParmVO.getLocCd());
					
					dmtResultVO.setResultCode("DMT01053");
					dmtResultVO.setResultMsg(errMsg);
					dmtResultVO.setEtcData(resEtcData);
					
					return dmtResultVO; 
				}
			}
			
			// 3001 - case in no VVD_CD
			if(orgBkgNo != null) {
				chargeByOfficeOrVVDVO.setBkgNo(orgBkgNo);
				chargeByOfficeOrVVDVO.setBlNo(orgBlNo);
			}
			
			// search list onfo.
			List<ChargeCalculationContainerVO> list = dbDao.searchChargeListByPodEta(chargeByOfficeOrVVDVO);
			dmtResultVO.setChargeCalculationContainerVOs(list);
			
			//  case in exists data to search  byPODETA at Charge Calculation by Booking
			if(chargeByOfficeOrVVDVO.getBypodeta().equals("booking") && list.size() > 0) {
				
				ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
				chgArgVO.setBkgNo(chargeByOfficeOrVVDVO.getBkgNo());
				chgArgVO.setBlNo(chargeByOfficeOrVVDVO.getBlNo());
				chgArgVO.setDmdtChgStsCd(chargeByOfficeOrVVDVO.getDmdtChgStsCd());
				chgArgVO.setDmdtTrfCd(chargeByOfficeOrVVDVO.getDmdtTrfCd());
				chgArgVO.setBypodeta(chargeByOfficeOrVVDVO.getBypodeta());
				
				// header info.
				DmtChgBkgCntrVO dmtChgBkgCntrVO = dbDao.searchCalculationBookingContainer(chgArgVO);
				if(dmtChgBkgCntrVO != null) {
					Map<String, String> etcData = dmtChgBkgCntrVO.getColumnValues();
					//String bkgNo = (String)etcData.get("bkg_no");
					
					Set<String> keys = etcData.keySet();
					Iterator<String> it = keys.iterator();
					
					while(it.hasNext()) {
						String key = (String)it.next();
						if(etcData.get(key) == null)
							etcData.put(key, "");
					}

					dmtResultVO.setEtcData(etcData);
				}
			}
			
			return dmtResultVO;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge List by POD ETA"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge List by POD ETA"}).getMessage());
		}
	}
	
	
	/**
	 * Search Exchange Rate of GRP INV Creation Charge
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchGrpInvExRate(ChargeCalculationContainerVO[] chargeCalculationContainerVOs) throws EventException {
		try {
			
			List<ChargeCalculationContainerVO> list = new ArrayList<ChargeCalculationContainerVO>();
			ExchangeRateParmVO exchangeRateParmVO = new ExchangeRateParmVO();
			
			for(int i=0; i < chargeCalculationContainerVOs.length; i++) {
				ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs[i];
				String exRate = "1.000000";

				if(!chgCalcCntrVO.getArCurrCd().equals(chgCalcCntrVO.getBzcTrfCurrCd())) {
					String vvdCd = chgCalcCntrVO.getVvdCd();
					exchangeRateParmVO.setVslCd(vvdCd.substring(0,4));
					exchangeRateParmVO.setSkdVoyageNo(vvdCd.substring(4,8));
					exchangeRateParmVO.setSkdDirCd(vvdCd.substring(8));
					exchangeRateParmVO.setIoBnd(chgCalcCntrVO.getDmdtTrfCd().substring(2,3));
					exchangeRateParmVO.setPolLoc(chgCalcCntrVO.getPolCd());
					exchangeRateParmVO.setPodLoc(chgCalcCntrVO.getPodCd()); 
					exchangeRateParmVO.setFmCurCd(chgCalcCntrVO.getBzcTrfCurrCd());
					exchangeRateParmVO.setToCurCd(chgCalcCntrVO.getArCurrCd());  
					exchangeRateParmVO.setOfcCd(chgCalcCntrVO.getOfcCd());
		
					double exchangeRate = 0;
					exchangeRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
					exRate = JSPUtil.toDecimalFormat(exchangeRate, "#.######");
				}
				
				chgCalcCntrVO.setInvXchRt(exRate);
				list.add(chgCalcCntrVO);
			}
			
			return list;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Group Invoice Creation Exchange Rate"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Group Invoice Creation Exchange Rate"}).getMessage());
		}
	}

	
	/**
	 * Search Container Charge List by Booking no<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO searchChargeByBookingList(ChargeArgumentVO chargeArgumentVO) throws EventException {
		try {
			DmtResultVO dmtResultVO = new DmtResultVO();
			DmtChgBkgCntrVO dmtChgBkgCntrVO = dbDao.searchCalculationBookingContainer(chargeArgumentVO);			
			
			if(dmtChgBkgCntrVO != null) {
				Map<String, String> etcData = dmtChgBkgCntrVO.getColumnValues();
				String bkgNo = (String)etcData.get("bkg_no");
				
				if(bkgNo == null) {
					Set<String> keys = etcData.keySet();
					Iterator<String> it = keys.iterator();
					
					while(it.hasNext()) {
						String key = (String)it.next();
						etcData.put(key, "");
					}
				}
				dmtResultVO.setEtcData(etcData);
			}
			
			List<ChargeCalculationContainerVO> list = dbDao.searchCalculationCharge(chargeArgumentVO);
			dmtResultVO.setChargeCalculationContainerVOs(list);
			
			return dmtResultVO;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge Calculation by Booking"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge Calculation by Booking"}).getMessage());
		}
	}
	
	
	/**
	 * Search Charge by Container and  Tariff Type<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO 
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO searchChargeByContainer(ChargeArgumentVO chargeArgumentVO) throws EventException {
		try {
			DmtResultVO resultVO = new DmtResultVO();
			
			//Map<String, Object> responseData = new HashMap<String, Object>();
			ChargeCalculationContainerVO chgCalcCntrVO = null;
			
			
			// call menue --> search cntr_cyc_no 
			if(chargeArgumentVO.getCallFlag().equals("M")) {
				
				// search CNTR Cycle No and Charge Seqence of  most recently created Charge by CNTR No, Tariff Type, Location Division Code
				// when searching DATA  SVR_ID get based CNT_CD of login USER.
				ChargeArgumentVO retChgArgVO = dbDao.searchCycleNoNSequence(chargeArgumentVO);
			
				
				// when exists CNTR Cycle No, Charge Seqence of most recently created Charge,
				// Do run normally
				if(!retChgArgVO.getCntrCycNo().equals("")) {
					chargeArgumentVO.setSvrId(retChgArgVO.getSvrId());
					chargeArgumentVO.setCntrCycNo(retChgArgVO.getCntrCycNo());
					chargeArgumentVO.setDmdtChgLocDivCd(retChgArgVO.getDmdtChgLocDivCd());
					chargeArgumentVO.setChgSeq(retChgArgVO.getChgSeq());
					
					/* ****** Search Charge Calculation by CNTR *******
					 * It is differnt according to Pre-Calculation Data or real Charge data
					 * A) case in real Charge data : Data of Charge, Booking Container Master Table
					 * B) case in Pre-Calculation Data: Data of Pre-Charge, Pre-Booking Container Table
					 */
					chgCalcCntrVO = dbDao.searchChargeByContainer(chargeArgumentVO);
					
				} else {
					//  Not exist CNTR Cycle No, Charge Seqence of most recently created Charge,
					//  Create Empty VO object for blank print screen
					chgCalcCntrVO = new ChargeCalculationContainerVO();
				}
				
			} else {
				// chargeArgumentVO.getCallFlag --> "P" (call pop up)
				// include CNTR Cycle No, Charge Seqence.
				chgCalcCntrVO = dbDao.searchChargeByContainer(chargeArgumentVO);
			}
				
			Map<String, String> etcData = chgCalcCntrVO.getColumnValues();
			String cntrNo = chgCalcCntrVO.getCntrNo();
			
			/*
			 There is no data , clear and disply all blank field for Print
			*/
			if(cntrNo == null) {
				Set<String> keys = etcData.keySet();
				Iterator<String> it = keys.iterator();
				
				while(it.hasNext()) {
					String key = (String)it.next();
					etcData.put(key, "");
				}
				
				resultVO.setEtcData(etcData);
				
			} else {
				// exist data, do run
				OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
				overdayNDivParmVO.setSvrId(chargeArgumentVO.getSvrId());
				overdayNDivParmVO.setCntrNo(chargeArgumentVO.getCntrNo());
				overdayNDivParmVO.setCnmvCycNo(chargeArgumentVO.getCntrCycNo());
				overdayNDivParmVO.setDttCode(chargeArgumentVO.getDmdtTrfCd());
				overdayNDivParmVO.setLocDiv(chargeArgumentVO.getDmdtChgLocDivCd());
				overdayNDivParmVO.setDccSeq(chargeArgumentVO.getChgSeq());
				
				//------------- DivOverDay -----------
				OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
				//-----------------------------------------
				
				CalculationParmVO calculationParmVO = new CalculationParmVO();
				
				String trfAplyTpCd = chgCalcCntrVO.getDmdtTrfAplyTpCd();
				calculationParmVO.setDcApplRate(trfAplyTpCd);
				
				/*
					Create Charge amount by Tariff.
				    A) "G"(Basic Tariff) : search rate of Basic Tariff
				    B) "B"(Before Exception) : search calculrate charge rate of Before Exception Tariff and Currency of Before Exception
				    C) "S"(S/C Exception): search calculrate charge rate of S/C Exception Tariff and Currency of S/C Exception				    D) Charge에 적용된 Currency와 A), B), C)에서 계산한 Currency가 다른경우
				         1) Search Applied CurrencyExchange Rate  and  Charge amount multiplied by Exchange Rate
				         2) Calcultrated amount 1) round decimal place of Currency
				*/
				if(trfAplyTpCd.equals("G")) {
					// basicCalculation - Baisc Tariff
					String firstSvrID = null;
					
					if(chgCalcCntrVO.getOfcTrnsFlg().equals("Y")) {
						if(chargeArgumentVO.getBkgNo().equals(""))
							chargeArgumentVO.setBkgNo(chgCalcCntrVO.getBkgNo());
						
						ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
						chargeCalculationParmVO.setBkgNo(chargeArgumentVO.getBkgNo());
						chargeCalculationParmVO.setCntrNo(chargeArgumentVO.getCntrNo());
						chargeCalculationParmVO.setCntrCycNo(chargeArgumentVO.getCntrCycNo());
						chargeCalculationParmVO.setDmdtTrfCd(chargeArgumentVO.getDmdtTrfCd());
						chargeCalculationParmVO.setDmdtChgLocDivCd(chargeArgumentVO.getDmdtChgLocDivCd());
						
						firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
					} else
						firstSvrID = chargeArgumentVO.getSvrId();
					
					calculationParmVO.setSvrId(firstSvrID);
					calculationParmVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					calculationParmVO.setTrfSeq(chgCalcCntrVO.getBzcTrfSeq());
					calculationParmVO.setTrfGrpSeq(chgCalcCntrVO.getBzcTrfGrpSeq());
					calculationParmVO.setCntrts(chgCalcCntrVO.getCntrTpszCd());
					calculationParmVO.setOverDay(chgCalcCntrVO.getFxFtOvrDys());
					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
					calculationParmVO.setCurCd(chgCalcCntrVO.getBzcTrfCurrCd());
					
				} else if(trfAplyTpCd.equals("B")) {
					// beforeCalculation - Before BKG Exception
					calculationParmVO.setDarNo(chgCalcCntrVO.getRfaExptDarNo());
					calculationParmVO.setMapgSeq(chgCalcCntrVO.getRfaExptMapgSeq());
					calculationParmVO.setVerSeq(chgCalcCntrVO.getRfaExptVerSeq());
					calculationParmVO.setDtlSeq(chgCalcCntrVO.getRfaRqstDtlSeq());
					calculationParmVO.setCmbSeq("1");
					calculationParmVO.setCntrts(chgCalcCntrVO.getCntrTpszCd());
					calculationParmVO.setOverDay(chgCalcCntrVO.getFxFtOvrDys());
					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
					
				} else if(trfAplyTpCd.equals("S")) {
					// scCalculation - SC Exception
					calculationParmVO.setPropNo(chgCalcCntrVO.getScNo());
					calculationParmVO.setVerSeq(chgCalcCntrVO.getScExptVerSeq());
					calculationParmVO.setGrpSeq(chgCalcCntrVO.getScExptGrpSeq());
					calculationParmVO.setCntrts(chgCalcCntrVO.getCntrTpszCd());
					calculationParmVO.setOverDay(chgCalcCntrVO.getFxFtOvrDys());
					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
				}
					
				CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);
				
				List<ChrgDtlVO> list = calculationAMTVO.getChrgDtlVOS();
				String rateCurCd = calculationAMTVO.getRateCurCd();
				
				if(list != null && list.size() > 0) {
					for(int i=0; i < list.size(); i++) {
						ChrgDtlVO vo = list.get(i);
						vo.setRtCurCd(rateCurCd);
					}
				}
				
				// VO List setting
				if(list != null ) {
					resultVO.setChrgDtlVOs(list);
				}
				
				
				// deled field.
				String xchRt = "1.000000";
				
				if(!rateCurCd.equals(chgCalcCntrVO.getBzcTrfCurrCd())) {
					ExchangeRateParmVO exchangeRateParmVO = new ExchangeRateParmVO();
					String vvdCd = chgCalcCntrVO.getVvdCd();
					
					exchangeRateParmVO.setVslCd(vvdCd.substring(0,4));
					exchangeRateParmVO.setSkdVoyageNo(vvdCd.substring(4,8));
					exchangeRateParmVO.setSkdDirCd(vvdCd.substring(8));
					exchangeRateParmVO.setIoBnd(chgCalcCntrVO.getDmdtTrfCd().substring(2,3));
					exchangeRateParmVO.setPolLoc(chgCalcCntrVO.getPolCd());
					exchangeRateParmVO.setPodLoc(chgCalcCntrVO.getPodCd()); 
					exchangeRateParmVO.setFmCurCd(rateCurCd);
					exchangeRateParmVO.setToCurCd(chgCalcCntrVO.getBzcTrfCurrCd());  
					exchangeRateParmVO.setOfcCd(chgCalcCntrVO.getOfcCd());
					
					double exchRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
					xchRt = JSPUtil.toDecimalFormat(exchRate, "#.######");
				}
				
				etcData.put("xch_rt", xchRt);
				
				// Setting Max Sequence of Charge at EtcData
				String chgMaxSeq = dbDao.searchChargeMaxSequence(chargeArgumentVO);
				etcData.put("chg_max_seq", chgMaxSeq);
				
				// Awkward In/Out-Gauge
				String bkgCgoTp = etcData.get("dmdt_bkg_cgo_tp_cd");
				if("AWK".equals(bkgCgoTp)) {
					String awkInOut = "";
					awkInOut = dmtCalculationUtil.searchInOutGauge(chgCalcCntrVO.getCntrNo(), chgCalcCntrVO.getBkgNo());
					//throw new EventException(new ErrorHandler("DMT00006", new String[]{"the Awkward Cargo in/out-gauge"}).getMessage());
					
					etcData.put("awk_gauge", awkInOut);
				}
				
				// Return VO object :setting EtcData
				resultVO.setEtcData(etcData);
				
			} // if - else end
			
			return resultVO;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge Calculation by CNTR"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge Calculation by CNTR"}).getMessage());
		}
	}
	
	
	/**
	 * Confirm to created Charge <br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String confirmContainerCharge(ChargeCalculationContainerVO[] chargeCalculationContainerVOs,
			SignOnUserAccount account) throws EventException {
		try {
			ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
			
			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
				ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs[i];
				
				if ( chgCalcCntrVO.getIbflag().equals("U")) {
					// check duplication 
					com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO checkArgument 
						= new com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO();
					checkArgument.setSvrId(chgCalcCntrVO.getSvrId());
					checkArgument.setCntrNo(chgCalcCntrVO.getCntrNo());
					checkArgument.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					checkArgument.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					checkArgument.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					checkArgument.setChgSeq(chgCalcCntrVO.getChgSeq());
					checkArgument.setStsCd("CONFIRM");
	
					boolean isExist = dbDao.checkChargeByConfirmDeleteDeleteCancel(checkArgument);
					
					//Do error Porcess when There is no UPDATEABLE data
					if(!isExist){
						log.debug("error (0) "+new ErrorHandler("DMT01081").getUserMessage());
						return new ErrorHandler("DMT01081").getUserMessage();
					}
					
					com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = null;
					chargeArgumentVO = new com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
					chargeArgumentVO.setSvrId(chgCalcCntrVO.getSvrId());
					chargeArgumentVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					chargeArgumentVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					chargeArgumentVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					chargeArgumentVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					chargeArgumentVO.setChgSeq(chgCalcCntrVO.getChgSeq());
					
					int corrHisSeq = dmtCalculationUtil.checkChargeCorrection(chargeArgumentVO);
					
					DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
					dmtChgCorrHisVO.setSvrId(chgCalcCntrVO.getSvrId());
					dmtChgCorrHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					dmtChgCorrHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					dmtChgCorrHisVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					dmtChgCorrHisVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					dmtChgCorrHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
					dmtChgCorrHisVO.setBkgNo(chgCalcCntrVO.getBkgNo());
					dmtChgCorrHisVO.setCorrHisRmk("Confirmed");
					dmtChgCorrHisVO.setCreUsrId(account.getUsr_id());
					dmtChgCorrHisVO.setCreOfcCd(account.getOfc_cd());
					
					if(corrHisSeq == 0) {
						corrHisSeq++;
						dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
						dbDao.addChargeHistory(dmtChgCorrHisVO);
					}
					
					chgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
					chgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					chgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					chgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					chgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					chgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());
					
					dbDao.modifyChargeByConfirm(chgArgVO, account);
					
					corrHisSeq++;
					dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
					dbDao.addChargeHistory(dmtChgCorrHisVO);
				}
			}
		
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"confirm Container Charge"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"confirm Container Charge"}).getMessage());
		}
		return "";
	}
	
	
	/**
	 * modify CorrRmk of Charge
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @exception EventException
	 */
	public void modifyChargeCorrRmk(ChargeArgumentVO chargeArgumentVO) throws EventException {
		try {
			dbDao.modifyChargeCorrRmk(chargeArgumentVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify charge correction remark"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify charge correction remark"}).getMessage());
		}
	}
	
	
	/**
	 * recover status of  Deleted Charge<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String removeCancelCharge(ChargeCalculationContainerVO[] chargeCalculationContainerVOs,
			SignOnUserAccount account) throws EventException {
		try {
			ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
			
			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
				ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs[i];
				
				if ( chgCalcCntrVO.getIbflag().equals("U")) {
					//Check Duplication
					com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO checkArgument 
						= new com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO();
					checkArgument.setSvrId(chgCalcCntrVO.getSvrId());
					checkArgument.setCntrNo(chgCalcCntrVO.getCntrNo());
					checkArgument.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					checkArgument.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					checkArgument.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					checkArgument.setChgSeq(chgCalcCntrVO.getChgSeq());
					checkArgument.setStsCd("CANCEL");
	
					boolean isExist = dbDao.checkChargeByConfirmDeleteDeleteCancel(checkArgument);
					
					// Do error Porcess when There is no UPDATEABLE data
					if(!isExist){
						log.debug("error (0) "+new ErrorHandler("DMT01081").getUserMessage());
						return new ErrorHandler("DMT01081").getUserMessage();
					}
					
					com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = null;
					chargeArgumentVO = new com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
					chargeArgumentVO.setSvrId(chgCalcCntrVO.getSvrId());
					chargeArgumentVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					chargeArgumentVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					chargeArgumentVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					chargeArgumentVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					chargeArgumentVO.setChgSeq(chgCalcCntrVO.getChgSeq());
					
					int corrHisSeq = dmtCalculationUtil.checkChargeCorrection(chargeArgumentVO);
					
					DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
					dmtChgCorrHisVO.setSvrId(chgCalcCntrVO.getSvrId());
					dmtChgCorrHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					dmtChgCorrHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					dmtChgCorrHisVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					dmtChgCorrHisVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					dmtChgCorrHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
					dmtChgCorrHisVO.setBkgNo(chgCalcCntrVO.getBkgNo());
					dmtChgCorrHisVO.setCorrHisRmk("Delete Cancel");
					dmtChgCorrHisVO.setCreUsrId(account.getUsr_id());
					dmtChgCorrHisVO.setCreOfcCd(account.getOfc_cd());
					
					if(corrHisSeq == 0) {
						corrHisSeq++;
						dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
						dbDao.addChargeHistory(dmtChgCorrHisVO);
					}
					
					chgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
					chgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					chgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					chgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					chgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					chgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());
					
					dbDao.modifyDeleteCancelCharge(chgArgVO, account);
					
					corrHisSeq++;
					dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
					dbDao.addChargeHistory(dmtChgCorrHisVO);
				}
			}
		
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"DEL Cancel Charge"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"DEL Cancel Charge"}).getMessage());
		}
		return "";
	}
	
	
	/**
	 * Search precalculation amount before save and input DR Data of Charge to To Data<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO precalDRDateCharge(ChargeArgumentVO chargeArgumentVO,
				ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account) throws EventException {
		try {
			DmtResultVO resultVO = new DmtResultVO();
			ChargeCalculationContainerVO chgCalcCntrVO = null;
			
			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			DMTGeneralChargeCalculationUtil dmtGeneralChargeCalculationUtil = new DMTGeneralChargeCalculationUtil();
			DMTBalanceChargeCalculationUtil dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
			DMTCancelChargeCalculationUtil	dmtCancelChargeCalculationUtil	= new DMTCancelChargeCalculationUtil();
			DMTCombinedChargeCalculationUtil dmtCombinedChargeCalculationUtil = new DMTCombinedChargeCalculationUtil();
			
			String drDt = null;
			
			// remove '-' of FmMvmtDt, ToMvmtDt in  by CNTR screen
			if(chargeArgumentVO != null) {
				// call by BKG screen
				drDt = chargeArgumentVO.getDrDt().replace("-", "");
				
			}
			
			
			// ************** multi process*************
			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
				chgCalcCntrVO = chargeCalculationContainerVOs[i];
				
				//when calling by BKG , To MVMT Status change to 'PC',  set To MVMT to inputed D/R Date in screen 
				if(chargeArgumentVO != null) {
					chgCalcCntrVO.setToMvmtStsCd("PC");
					chgCalcCntrVO.setToMvmtDt(drDt);
				} else {
					// remove '-' of FmMvmtDt, ToMvmtDt in  by CNTR screen
					chgCalcCntrVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt().replace("-",""));
					chgCalcCntrVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt().replace("-",""));
				}
				
				ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
				chgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				chgArgVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				chgArgVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				
				
				String chgMaxSeq = dbDao.searchChargeMaxSequence(chgArgVO);
				
				if(!chgCalcCntrVO.getChgSeq().equals(chgMaxSeq)) {
					//"There is a balance charge !"
					resultVO.setResultCode("DMT01030");
					return resultVO;
				}
				
				boolean chgInvChk = dbDao.searchChargeInvoiceCheck(chgArgVO);
				if(chgInvChk) {
					//"Already Invoiced"
					resultVO.setResultCode("DMT01002");
					return resultVO;
				}
				
				
				ChargeCalculationContainerVO orgChgCalCntrVO = null;
				if(chgCalcCntrVO.getDulTpExptFlg().equals("Y")) {
					chgArgVO.setDulTpExptFlg("Y");
					orgChgCalCntrVO = (ChargeCalculationContainerVO)chgCalcCntrVO.clone();
				}
				
				
				String toMvmtStsCd = chgCalcCntrVO.getToMvmtStsCd();
				
				// DR Date Checking
				if(toMvmtStsCd.equals("DR")) {
					// String currDt = DateTime.getDateString().replace(".","");
					// Search current local date of User Office
					String currDt	= dbDao.searchCurrentDateByOffice(account.getOfc_cd());
					String toMvmtDt = chgCalcCntrVO.getToMvmtDt();
					
					if(currDt.compareTo(toMvmtDt) > 0) {
						// D/R Date should be same or later than current date
						resultVO.setResultCode("DMT01031");
						return resultVO;
					}
					
					// only Apply PreCal, DR Save 
					if(chgCalcCntrVO.getToMvmtYdCd().equals(""))
						chgCalcCntrVO.setToMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
					
				} else if(toMvmtStsCd.equals("CS")) {
					// Clock Stop
					String fmMvmtDt = chgCalcCntrVO.getFmMvmtDt();
					String toMvmtDt = chgCalcCntrVO.getToMvmtDt();
					
					if(fmMvmtDt.compareTo(toMvmtDt) >= 0) {
						// CS date should be later than From date
						resultVO.setResultCode("DMT01004");
						return resultVO;
					}
					
					// only Apply PreCal, DR Save 
					if(chgCalcCntrVO.getToMvmtYdCd().equals(""))
						chgCalcCntrVO.setToMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				}
				
				
				// Deelte when there is existing  PreCal Charge Booking Container info.
				//boolean isExist = dbDao.checkPreChargeBookingContainerExists(chgArgVO);
				//if(isExist)
				dbDao.deletePreChargeBookingContainer(chgArgVO);
				
				// Create PreCal  Charge Booking Container info.
				dbDao.createPreChargeBookingContainer(chgArgVO);
				
				
				// Deelte when there is existing PreCal Charge info.
				//isExist = dbDao.checkPreChargeCalculationExists(chgArgVO);
				//if(isExist)
				dbDao.deletePreChargeCalculation(chgArgVO);
				
				// Create  PreCal Charge info.
				dbDao.createPreChargeCalculation(chgArgVO);
				
				
				// ***********  ChargeCalculationUseData  ***********************************
				ChargePartialPaymentVO chgPartialPaymentVO = dbDao.searchChargeCalculationUseData(chgArgVO);
				
				
				chgCalcCntrVO.setFmMvmtDt(chgPartialPaymentVO.getFmMvmtDt());
				
				/*
				 Case in  "L"(Long Staying), "U"(Unfinished), "N"(No Charge),Do Re-Calculation Even though there is no To Date/Yard 
				 , initialize To Date
				 */
				String chgStsCd = chgCalcCntrVO.getDmdtChgStsCd();
				if( (chgStsCd.equals("L") || chgStsCd.equals("U") || chgStsCd.equals("N")) 
					&& chgPartialPaymentVO.getToMvmtDt().length() < 12 ) {
					chgCalcCntrVO.setToMvmtDt("");
				} else
					chgCalcCntrVO.setToMvmtDt(chgPartialPaymentVO.getToMvmtDt());
				
				
				// *****************************************************
				if("Y".equals(chgCalcCntrVO.getWebIndFlg()) && chgCalcCntrVO.getToMvmtStsCd().equals("DR")) {
					chgArgVO.setWebIndFlg("N");
					dbDao.modifyChargeWebIndicator(chgArgVO);
				}
				
				ChargeCalculationParmVO chgCalcParmVO = new ChargeCalculationParmVO();
				chgCalcParmVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgCalcParmVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgCalcParmVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgCalcParmVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgCalcParmVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgCalcParmVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				chgCalcParmVO.setActCntCd(chgPartialPaymentVO.getActCntCd());
				chgCalcParmVO.setActCustSeq(chgPartialPaymentVO.getActCustSeq());
				chgCalcParmVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				chgCalcParmVO.setCntrTpszCd(chgCalcCntrVO.getCntrTpszCd());
				chgCalcParmVO.setCustCntCd(chgPartialPaymentVO.getCustCntCd());
				chgCalcParmVO.setCustSeq(chgPartialPaymentVO.getCustSeq());
				chgCalcParmVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				chgCalcParmVO.setFmMvmtStsCd(chgCalcCntrVO.getFmMvmtStsCd());
				chgCalcParmVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				chgCalcParmVO.setIoBndCd(chgPartialPaymentVO.getIoBndCd());
				chgCalcParmVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				chgCalcParmVO.setToMvmtStsCd(chgCalcCntrVO.getToMvmtStsCd());
				chgCalcParmVO.setToMvmtYdCd(chgCalcCntrVO.getToMvmtYdCd());
				
				
				if(chgCalcCntrVO.getDulTpExptFlg().equals("Y")) {
					// search  Dual Charge of Dual Exception Charge abount Combined Charge.
					List<ChargeCalculationContainerVO> chgCalcCntrVOs = dbDao.searchDualChargeTariff(chgArgVO);
					
					if(chgCalcCntrVOs != null && chgCalcCntrVOs.size() > 0) {
						chgArgVO.setCallFlag("PRECAL");
						resultVO = dualExceptionChargeCalculation("PRECAL", orgChgCalCntrVO, chgCalcCntrVOs, account);
						
						// Error Return
						if(resultVO.getResultCode() != null) {
							return resultVO;
						}
					}
					
					retChgCalcCntrVO = dmtCombinedChargeCalculationUtil.combinedChargeCalculation(chgCalcParmVO);
					
				} else {
					if(chgCalcCntrVO.getCxlBkgChgFlg().equals("Y")) {
						retChgCalcCntrVO = dmtCancelChargeCalculationUtil.cancelChargeCalculation(chgCalcParmVO);
						if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					} else {
						if(!chgCalcCntrVO.getFmMvmtStsCd().equals("DR")) {
							retChgCalcCntrVO = dmtGeneralChargeCalculationUtil.generalChargeCalculation(chgCalcParmVO);
							
							if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
								//throw new EventException(retChgCalcCntrVO.getMsgDesc());
								resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						} else {
							retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
							if(retChgCalcCntrVO.getMsgCd().equals("-1")) {
								//throw new EventException(retChgCalcCntrVO.getMsgDesc());
								resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						}
					}
				}
				
				/*
				OfficeNRHQVO officeNRHQVO = null;
				if(chgCalcCntrVO.getOfcTrnsFlg().equals("Y")) {
					officeNRHQVO = dbDao.checkOfficeTransfer(chgArgVO); 
				}
				*/
				
				//get back MT Notification Indicator originally
				chgArgVO.setWebIndFlg(chgCalcCntrVO.getWebIndFlg());
				dbDao.modifyChargeWebIndicator(chgArgVO);
				
				
				if(!chgCalcCntrVO.getFmMvmtStsCd().equals("DR")) {
				
					// ------------define DmtChgBkgCntrVO object -----------------
					DmtChgBkgCntrVO dmtChgBkgCntrVO = new DmtChgBkgCntrVO();
					dmtChgBkgCntrVO.setSvrId(chgCalcCntrVO.getSvrId());
					dmtChgBkgCntrVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					dmtChgBkgCntrVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					
					dmtChgBkgCntrVO.setBlNo(chgCalcCntrVO.getBlNo());
					//--------------- ChargePartialPaymentVO -------------------
					dmtChgBkgCntrVO.setVslCd(chgPartialPaymentVO.getVslCd());
					dmtChgBkgCntrVO.setSkdVoyNo(chgPartialPaymentVO.getSkdVoyNo());
					dmtChgBkgCntrVO.setSkdDirCd(chgPartialPaymentVO.getSkdDirCd());
					//--------------------------------------------------------
					dmtChgBkgCntrVO.setVpsEtaDt(retChgCalcCntrVO.getVpsEtaDt());
					dmtChgBkgCntrVO.setScNo(retChgCalcCntrVO.getBrhScNo());
					dmtChgBkgCntrVO.setRfaNo(retChgCalcCntrVO.getBrhRfaNo());
					dmtChgBkgCntrVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
					dmtChgBkgCntrVO.setRepCmdtCd(retChgCalcCntrVO.getRepCmdtCd());
					dmtChgBkgCntrVO.setDcgoFlg(retChgCalcCntrVO.getDcgoFlg());
					dmtChgBkgCntrVO.setRcFlg(retChgCalcCntrVO.getRcFlg());
					dmtChgBkgCntrVO.setBbCgoFlg(retChgCalcCntrVO.getBbCgoFlg());
					dmtChgBkgCntrVO.setAwkCgoFlg(retChgCalcCntrVO.getAwkCgoFlg());
					dmtChgBkgCntrVO.setRdCgoFlg(retChgCalcCntrVO.getRdCgoFlg());
					dmtChgBkgCntrVO.setSocFlg(retChgCalcCntrVO.getSocFlg());
					dmtChgBkgCntrVO.setCntrPrtFlg(retChgCalcCntrVO.getCntrPrtFlg());
					dmtChgBkgCntrVO.setAdvShtgCd(retChgCalcCntrVO.getAdvShtgCd());
					dmtChgBkgCntrVO.setDmdtCntrTpCd(retChgCalcCntrVO.getCntrTp());
					dmtChgBkgCntrVO.setDmdtBkgCgoTpCd(retChgCalcCntrVO.getDmdtCgoTpCd());
					dmtChgBkgCntrVO.setPorCd(retChgCalcCntrVO.getPorCd());
					dmtChgBkgCntrVO.setPolCd(retChgCalcCntrVO.getPolCd());
					dmtChgBkgCntrVO.setPodCd(retChgCalcCntrVO.getPodCd());
					dmtChgBkgCntrVO.setDelCd(retChgCalcCntrVO.getDelCd());
					dmtChgBkgCntrVO.setBkgRcvTermCd(retChgCalcCntrVO.getBbRcvTermCd());
					dmtChgBkgCntrVO.setBkgDeTermCd(retChgCalcCntrVO.getBbDeTermCd());
					dmtChgBkgCntrVO.setBkgCntrQty(retChgCalcCntrVO.getBkgQty());
					dmtChgBkgCntrVO.setSlsOfcCd(retChgCalcCntrVO.getSalOfc());
					dmtChgBkgCntrVO.setRhqCd(retChgCalcCntrVO.getSalRhq());
					dmtChgBkgCntrVO.setUpdUsrId(account.getUsr_id());
					dmtChgBkgCntrVO.setUpdOfcCd(account.getOfc_cd());
					
					dbDao.modifyPreBookingContainer(dmtChgBkgCntrVO);
				}
				
				
				// *************define DmtChgCalcVO object *****************
				DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
				dmtChgCalcVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCalcVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCalcVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCalcVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCalcVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCalcVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				dmtChgCalcVO.setFmMvmtStsCd(chgCalcCntrVO.getFmMvmtStsCd());
				dmtChgCalcVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				dmtChgCalcVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				dmtChgCalcVO.setToMvmtStsCd(chgCalcCntrVO.getToMvmtStsCd());
				dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
				dmtChgCalcVO.setToMvmtYdCd(chgCalcCntrVO.getToMvmtYdCd());
				dmtChgCalcVO.setNotCreBalFlg("N");
				dmtChgCalcVO.setFtDys(retChgCalcCntrVO.getFtDys());
				dmtChgCalcVO.setFtCmncDt(retChgCalcCntrVO.getFtCmncDt());
				dmtChgCalcVO.setFtEndDt(retChgCalcCntrVO.getFtEndDt());
				dmtChgCalcVO.setFxFtOvrDys(retChgCalcCntrVO.getFxFtOvrDys());
				dmtChgCalcVO.setOrgFtOvrDys(retChgCalcCntrVO.getOrgFtOvrDys());
				dmtChgCalcVO.setScRfaExptOvrDys(retChgCalcCntrVO.getScRfaExptOvrDys());
				dmtChgCalcVO.setAftExptOvrDys(retChgCalcCntrVO.getAftExptOvrDys());
				dmtChgCalcVO.setBzcTrfCurrCd(retChgCalcCntrVO.getBzcTrfCurrCd());
				dmtChgCalcVO.setDmdtTrfAplyTpCd(retChgCalcCntrVO.getDmdtTrfAplyTpCd());
				dmtChgCalcVO.setOrgChgAmt(retChgCalcCntrVO.getOrgChgAmt());
				dmtChgCalcVO.setScRfaExptAmt(retChgCalcCntrVO.getScRfaExptAmt());
				dmtChgCalcVO.setAftExptDcAmt(retChgCalcCntrVO.getAftExptDcAmt());
				dmtChgCalcVO.setBilAmt(retChgCalcCntrVO.getBilAmt());
				dmtChgCalcVO.setDmdtChgStsCd(retChgCalcCntrVO.getDmdtChgStsCd());
				
				dmtChgCalcVO.setScRfaAmt(retChgCalcCntrVO.getScRfaAmt());
				dmtChgCalcVO.setAftExptAmt(retChgCalcCntrVO.getAftExptAmt());
				dmtChgCalcVO.setBzcTrfSeq(retChgCalcCntrVO.getBzcTrfSeq());
				dmtChgCalcVO.setBzcTrfGrpSeq(retChgCalcCntrVO.getBzcTrfGrpSeq());
				dmtChgCalcVO.setBzcTrfAplyDt(retChgCalcCntrVO.getBzcTrfAplyDt());		
				dmtChgCalcVO.setRfaExptAproNo(retChgCalcCntrVO.getRfaExptAproNo());
				dmtChgCalcVO.setRfaExptDarNo(retChgCalcCntrVO.getRfaExptDarNo());
				dmtChgCalcVO.setRfaExptMapgSeq(retChgCalcCntrVO.getRfaExptMapgSeq());		
				dmtChgCalcVO.setRfaExptVerSeq(retChgCalcCntrVO.getRfaExptVerSeq());
				dmtChgCalcVO.setRfaRqstDtlSeq(retChgCalcCntrVO.getRfaRqstDtlSeq());
				dmtChgCalcVO.setAftExptAproNo(retChgCalcCntrVO.getAftExptAproNo());
				dmtChgCalcVO.setAftExptDarNo(retChgCalcCntrVO.getAftExptDarNo());
				dmtChgCalcVO.setAftExptAdjSeq(retChgCalcCntrVO.getAftExptAdjSeq());
				dmtChgCalcVO.setScNo(retChgCalcCntrVO.getBrhScNo());
				dmtChgCalcVO.setScExptVerSeq(retChgCalcCntrVO.getScExptVerSeq());
				dmtChgCalcVO.setScExptGrpSeq(retChgCalcCntrVO.getScExptGrpSeq());
				dmtChgCalcVO.setScRfaExptAplyDt(retChgCalcCntrVO.getScRfaExptAplyDt());
				dmtChgCalcVO.setCorrRmk(chgCalcCntrVO.getCorrRmk());
				
				dmtChgCalcVO.setOfcCd(chgCalcCntrVO.getOfcCd());
				dmtChgCalcVO.setOfcRhqCd(chgCalcCntrVO.getOfcRhqCd());
				dmtChgCalcVO.setUpdUsrId(account.getUsr_id());
				dmtChgCalcVO.setUpdOfcCd(account.getOfc_cd());
				dmtChgCalcVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
				dmtChgCalcVO.setCmdtTrfSeq(retChgCalcCntrVO.getCmdtTrfSeq());
				dmtChgCalcVO.setCmdtExptAplyDt(retChgCalcCntrVO.getCmdtExptAplyDt());
				dmtChgCalcVO.setCmdtOvrDys(retChgCalcCntrVO.getCmdtOvrDys());
				dmtChgCalcVO.setCmdtExptAmt(retChgCalcCntrVO.getCmdtExptAmt());
				dmtChgCalcVO.setWebMtyDt(chgCalcCntrVO.getWebMtyDt().replace("-", ""));
				
				dbDao.modifyPreCharge(dmtChgCalcVO);
				
				
				if(chgCalcCntrVO.getDulTpExptFlg().equals("Y")) {
					// modify ORG_CHG_AMT, SC_RFA_EXPT_AMT of Dual Exception Charge
					dbDao.modifyOrgChgAmt(chgArgVO);
				}
				
			} // for - end

			
			// when calling by BKG(EES_DMT_3002.do) 
			if(chargeArgumentVO != null) {
				// setting Status of previous condition (sch_chg_sts --> dmdt_chg_sts_cd)
				chargeArgumentVO.setDmdtChgStsCd(chargeArgumentVO.getSchChgSts());
				
				// previous result list
				List<ChargeCalculationContainerVO> orgVOList = dbDao.searchCalculationCharge(chargeArgumentVO);
				
				//  PreCal procee list by same condition 
				chargeArgumentVO.setEstMk("P");
				List<ChargeCalculationContainerVO> precalVOList = dbDao.searchCalculationCharge(chargeArgumentVO);
				
				for(int i=0; i < orgVOList.size(); i++) {
					ChargeCalculationContainerVO orgChgCalcCntrVO = orgVOList.get(i);
					
					// chargeCalculationContainerVOs ===> in the previous result list, checked preCal target rows 
					for (int k=0; k < chargeCalculationContainerVOs.length; k++ ) {
						
						// in the previous result list, compairing checked preCal target, and find list of order.(for Replacing PreCal data)
						if (orgChgCalcCntrVO!=null && chargeCalculationContainerVOs[k]!=null && 
							orgChgCalcCntrVO.getSvrId().equals(chargeCalculationContainerVOs[k].getSvrId())
							&& orgChgCalcCntrVO.getCntrNo().equals(chargeCalculationContainerVOs[k].getCntrNo())
							&& orgChgCalcCntrVO.getCntrCycNo().equals(chargeCalculationContainerVOs[k].getCntrCycNo())
							&& orgChgCalcCntrVO.getDmdtTrfCd().equals(chargeCalculationContainerVOs[k].getDmdtTrfCd())
							&& orgChgCalcCntrVO.getDmdtChgLocDivCd().equals(chargeCalculationContainerVOs[k].getDmdtChgLocDivCd())
							&& orgChgCalcCntrVO.getChgSeq().equals(chargeCalculationContainerVOs[k].getChgSeq()) ) 
						{
							//  Replacing PreCal data in the previous result list

							for (int j=0; j < precalVOList.size(); j++ ) {
								ChargeCalculationContainerVO precalVO = precalVOList.get(j);

								if (orgChgCalcCntrVO!=null && precalVO!=null &&
									orgChgCalcCntrVO.getSvrId().equals(precalVO.getSvrId())
									&& orgChgCalcCntrVO.getCntrNo().equals(precalVO.getCntrNo())
									&& orgChgCalcCntrVO.getCntrCycNo().equals(precalVO.getCntrCycNo())
									&& orgChgCalcCntrVO.getDmdtTrfCd().equals(precalVO.getDmdtTrfCd())
									&& orgChgCalcCntrVO.getDmdtChgLocDivCd().equals(precalVO.getDmdtChgLocDivCd())
									&& orgChgCalcCntrVO.getChgSeq().equals(precalVO.getChgSeq()) ) 
								{
									orgVOList.set(i, precalVO);
									break;
								}
							}
							break;
						}
					}
				}
			
				// return applied PreCal data
				//return orgVOList;
				resultVO.setChargeCalculationContainerVOs(orgVOList);
			}
			return resultVO;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"precal charge"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"precal charge"}).getMessage());
		}
	}
	
	
	/**
	 *  Modify Container Charge . Operation(DR Save) Called by Charge By Booking screen
	 *
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO modifyCharge(ChargeArgumentVO chargeArgumentVO, ChargeCalculationContainerVO[] chargeCalculationContainerVOs
									,SignOnUserAccount account) throws EventException {
		try {
			DmtResultVO resultVO = new DmtResultVO();

			//List<ChargeCalculationContainerVO> list = new ArrayList<ChargeCalculationContainerVO>();
			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			DMTGeneralChargeCalculationUtil dmtGeneralChargeCalculationUtil = new DMTGeneralChargeCalculationUtil();
			DMTBalanceChargeCalculationUtil dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
			DMTCancelChargeCalculationUtil	dmtCancelChargeCalculationUtil	= new DMTCancelChargeCalculationUtil();
			DMTCombinedChargeCalculationUtil dmtCombinedChargeCalculationUtil = new DMTCombinedChargeCalculationUtil();

			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO utilChgArgVO = null;
			utilChgArgVO = new com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();

			String drDt = chargeArgumentVO.getDrDt().replace("-", "");
			

			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
				ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs[i];

				chgCalcCntrVO.setToMvmtStsCd("DR");
				chgCalcCntrVO.setToMvmtDt(drDt);

				chargeArgumentVO.setSvrId(chgCalcCntrVO.getSvrId());
				chargeArgumentVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chargeArgumentVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chargeArgumentVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chargeArgumentVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chargeArgumentVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				chargeArgumentVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				chargeArgumentVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				

				String chgMaxSeq = dbDao.searchChargeMaxSequence(chargeArgumentVO);

				if(!chgCalcCntrVO.getChgSeq().equals(chgMaxSeq)) {
					//"There is a balance charge !"
					resultVO.setResultCode("DMT01030");
					return resultVO;
				}

				boolean chgInvChk = dbDao.searchChargeInvoiceCheck(chargeArgumentVO);
				if(chgInvChk) {
					//"Already Invoiced"
					resultVO.setResultCode("DMT01002");
					return resultVO;
				}
				
				
				ChargeCalculationContainerVO orgChgCalCntrVO = null;
				if(chgCalcCntrVO.getDulTpExptFlg().equals("Y")) {
//					orgChgCalCntrVO = (ChargeCalculationContainerVO)chgCalcCntrVO.clone();					

					orgChgCalCntrVO = new ChargeCalculationContainerVO();
					
					orgChgCalCntrVO.setSvrId(chgCalcCntrVO.getSvrId());
					orgChgCalCntrVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					orgChgCalCntrVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());					
					orgChgCalCntrVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					orgChgCalCntrVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					orgChgCalCntrVO.setChgSeq(chgCalcCntrVO.getChgSeq());
					orgChgCalCntrVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
					orgChgCalCntrVO.setFmMvmtDtTime(chgCalcCntrVO.getFmMvmtDtTime());
					orgChgCalCntrVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
					orgChgCalCntrVO.setToMvmtDtTime(chgCalcCntrVO.getToMvmtDtTime());	
					
					orgChgCalCntrVO.setFmMvmtStsCd(chgCalcCntrVO.getFmMvmtStsCd());
					orgChgCalCntrVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
					orgChgCalCntrVO.setToMvmtStsCd(chgCalcCntrVO.getToMvmtStsCd());
					orgChgCalCntrVO.setToMvmtYdCd(chgCalcCntrVO.getToMvmtYdCd());
					orgChgCalCntrVO.setCorrRmk(chgCalcCntrVO.getCorrRmk());
					orgChgCalCntrVO.setWebIndFlg(chgCalcCntrVO.getWebIndFlg());
					orgChgCalCntrVO.setOfcCd(chgCalcCntrVO.getOfcCd());
					orgChgCalCntrVO.setOfcRhqCd(chgCalcCntrVO.getOfcRhqCd());
					orgChgCalCntrVO.setCustCntCd(chgCalcCntrVO.getCustCntCd());
					orgChgCalCntrVO.setCustSeq(chgCalcCntrVO.getCustSeq());
					orgChgCalCntrVO.setActCntCd(chgCalcCntrVO.getActCntCd());
					orgChgCalCntrVO.setActCustSeq(chgCalcCntrVO.getActCustSeq());
					orgChgCalCntrVO.setIoBndCd(chgCalcCntrVO.getIoBndCd());
					orgChgCalCntrVO.setOfcTrnsFlg(chgCalcCntrVO.getOfcTrnsFlg());
					orgChgCalCntrVO.setWebMtyDt(chgCalcCntrVO.getWebMtyDt());
					orgChgCalCntrVO.setDulTpExptFlg(chgCalcCntrVO.getDulTpExptFlg());
					orgChgCalCntrVO.setCxlBkgChgFlg(chgCalcCntrVO.getCxlBkgChgFlg());
					orgChgCalCntrVO.setBkgNo(chgCalcCntrVO.getBkgNo());
					orgChgCalCntrVO.setBlNo(chgCalcCntrVO.getBlNo());
					orgChgCalCntrVO.setCntrTpszCd(chgCalcCntrVO.getCntrTpszCd());
					orgChgCalCntrVO.setVslCd(chgCalcCntrVO.getVslCd());
					orgChgCalCntrVO.setSkdVoyNo(chgCalcCntrVO.getSkdVoyNo());
					orgChgCalCntrVO.setSkdDirCd(chgCalcCntrVO.getSkdDirCd());
				}
				
				String toMvmtStsCd = chgCalcCntrVO.getToMvmtStsCd();

				// DR Date Checking
				if(toMvmtStsCd.equals("DR")) {
					//String currDt = DateTime.getDateString().replace(".","");
					// Search current local date of User Office
					String currDt	= dbDao.searchCurrentDateByOffice(account.getOfc_cd());
					String toMvmtDt = chgCalcCntrVO.getToMvmtDt();

					if(currDt.compareTo(toMvmtDt) > 0) {
						// D/R Date should be same or later than current date
						resultVO.setResultCode("DMT01031");
						return resultVO;
					}

					// only Apply PreCal, DR Save
					if(chgCalcCntrVO.getToMvmtYdCd().equals(""))
						chgCalcCntrVO.setToMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());

				} else if(toMvmtStsCd.equals("CS")) {
					// Clock Stop
					String fmMvmtDt = chgCalcCntrVO.getFmMvmtDt();
					String toMvmtDt = chgCalcCntrVO.getToMvmtDt();

					if(fmMvmtDt.compareTo(toMvmtDt) >= 0) {
						// CS date should be later than From date
						resultVO.setResultCode("DMT01004");
						return resultVO;
					}

					// only Apply PreCal, DR Save
					if(chgCalcCntrVO.getToMvmtYdCd().equals(""))
						chgCalcCntrVO.setToMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				}


				utilChgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
				utilChgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				utilChgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				utilChgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				utilChgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				utilChgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());

				int corrHisSeq = dmtCalculationUtil.checkChargeCorrection(utilChgArgVO);

				DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
				dmtChgCorrHisVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCorrHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCorrHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCorrHisVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCorrHisVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCorrHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				dmtChgCorrHisVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				dmtChgCorrHisVO.setCorrHisRmk(chgCalcCntrVO.getCorrRmk());
				dmtChgCorrHisVO.setCreUsrId(account.getUsr_id());
				dmtChgCorrHisVO.setCreOfcCd(account.getOfc_cd());

				if(corrHisSeq == 0) {
					corrHisSeq++;
					dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));

					dbDao.addChargeHistory(dmtChgCorrHisVO);
				}

				// ***********  searchChargeCalculationUseData **************
				ChargePartialPaymentVO chgPartialPaymentVO = dbDao.searchChargeCalculationUseData(chargeArgumentVO);


				chgCalcCntrVO.setFmMvmtDt(chgPartialPaymentVO.getFmMvmtDt());

				/*
				  Case in  "L"(Long Staying), "U"(Unfinished), "N"(No Charge),Do Re-Calculation Even though there is no To Date/Yard 
				 , initialize To Date
				 */
				String chgStsCd = chgCalcCntrVO.getDmdtChgStsCd();
				if( (chgStsCd.equals("L") || chgStsCd.equals("U") || chgStsCd.equals("N"))
					&& chgPartialPaymentVO.getToMvmtDt().length() < 12 ) {
					chgCalcCntrVO.setToMvmtDt("");
				} else
					chgCalcCntrVO.setToMvmtDt(chgPartialPaymentVO.getToMvmtDt());


				// *****************************************************
				if("Y".equals(chgCalcCntrVO.getWebIndFlg()) && chgCalcCntrVO.getToMvmtStsCd().equals("DR")) {
					chargeArgumentVO.setWebIndFlg("N");
					dbDao.modifyChargeWebIndicator(chargeArgumentVO);
				}

				ChargeCalculationParmVO chgCalcParmVO = new ChargeCalculationParmVO();
				chgCalcParmVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgCalcParmVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgCalcParmVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgCalcParmVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgCalcParmVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgCalcParmVO.setChgSeq(chgCalcCntrVO.getChgSeq());

				chgCalcParmVO.setActCntCd(chgPartialPaymentVO.getActCntCd());
				chgCalcParmVO.setActCustSeq(chgPartialPaymentVO.getActCustSeq());
				chgCalcParmVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				chgCalcParmVO.setCntrTpszCd(chgCalcCntrVO.getCntrTpszCd());
				chgCalcParmVO.setCustCntCd(chgPartialPaymentVO.getCustCntCd());
				chgCalcParmVO.setCustSeq(chgPartialPaymentVO.getCustSeq());
				chgCalcParmVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				chgCalcParmVO.setFmMvmtStsCd(chgCalcCntrVO.getFmMvmtStsCd());
				chgCalcParmVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				chgCalcParmVO.setIoBndCd(chgPartialPaymentVO.getIoBndCd());
				chgCalcParmVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				chgCalcParmVO.setToMvmtStsCd(chgCalcCntrVO.getToMvmtStsCd());
				chgCalcParmVO.setToMvmtYdCd(chgCalcCntrVO.getToMvmtYdCd());
				
//				if(chgCalcCntrVO.getDulTpExptFlg().equals("Y")) {
//					// search  Dual Charge of Dual Exception Charge abount Combined Charge.
//					List<ChargeCalculationContainerVO> chgCalcCntrVOs = dbDao.searchDualChargeTariff(chargeArgumentVO);
//					
//					if(chgCalcCntrVOs != null && chgCalcCntrVOs.size() > 0) {
//						chargeArgumentVO.setCallFlag("DRSAVE");
//						if(orgChgCalCntrVO != null) {
//							resultVO = dualExceptionChargeCalculation("DRSAVE", orgChgCalCntrVO, chgCalcCntrVOs, account);
//						}else{
//							resultVO = dualExceptionChargeCalculation("DRSAVE", null, chgCalcCntrVOs, account);
//						}
//						
//						// error Return
//						if(resultVO.getResultCode() != null) {
//							return resultVO;
//						}
//					}
//					
//					retChgCalcCntrVO = dmtCombinedChargeCalculationUtil.combinedChargeCalculation(chgCalcParmVO);
				if("Y".equals(chgCalcCntrVO.getDulTpExptFlg())) {
					// Dual Exception Charge중 Combined Charge에 대한 Dual Charge를 조회한다..
					List<ChargeCalculationContainerVO> chgCalcCntrVOs = dbDao.searchDualChargeTariff(chargeArgumentVO);
					
					if(chgCalcCntrVOs != null && chgCalcCntrVOs.size() > 0) {
						chargeArgumentVO.setCallFlag("DRSAVE");
						resultVO = dualExceptionChargeCalculation("DRSAVE", orgChgCalCntrVO, chgCalcCntrVOs, account);
						
						// 오류 발생시 Return
						if(resultVO.getResultCode() != null) {
							return resultVO;
						}
					}
					
					//retChgCalcCntrVO = dmtCombinedChargeCalculationUtil.combinedChargeCalculation(chgCalcParmVO);
					//2011.04.29. 추가 ("DR"일때 아닐때 구분)
					if(!"DR".equals(chgCalcCntrVO.getFmMvmtStsCd())){
						retChgCalcCntrVO = dmtCombinedChargeCalculationUtil.combinedChargeCalculation(chgCalcParmVO);
						if("-1".equals(retChgCalcCntrVO.getMsgCd()) || "88".equals(retChgCalcCntrVO.getMsgCd())) {
							log.error("\n\n combinedChargeCalculation ERROR [Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					}else{
						dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
						retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
						
						if ("-1".equals(retChgCalcCntrVO.getMsgCd())) {
							log.error("\n\n[DMT02036][Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					}					
					
				} else {
					if(chgCalcCntrVO.getCxlBkgChgFlg().equals("Y")) {
						retChgCalcCntrVO = dmtCancelChargeCalculationUtil.cancelChargeCalculation(chgCalcParmVO);
						
						if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					} else {
						if(!chgCalcCntrVO.getFmMvmtStsCd().equals("DR")) {
							retChgCalcCntrVO = dmtGeneralChargeCalculationUtil.generalChargeCalculation(chgCalcParmVO);
		
							if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
								resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						} else {
							retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
		
							if(retChgCalcCntrVO.getMsgCd().equals("-1")) {
								resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						}
					}
				}
					
					
				if(!retChgCalcCntrVO.getMsgCd().equals("0")) {
					retChgCalcCntrVO.setDmdtChgStsCd("E");
				}

				// get back MT Notification Indicator originally
				//chargeArgumentVO.setWebIndFlg(chgCalcCntrVO.getWebIndFlg());
				//dbDao.modifyChargeWebIndicator(chargeArgumentVO);

				if(!chgCalcCntrVO.getFmMvmtStsCd().equals("DR")) {

					// ------------define DmtChgBkgCntrVO object -----------------
					DmtChgBkgCntrVO dmtChgBkgCntrVO = new DmtChgBkgCntrVO();
					dmtChgBkgCntrVO.setSvrId(chgCalcCntrVO.getSvrId());
					dmtChgBkgCntrVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					dmtChgBkgCntrVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());

					dmtChgBkgCntrVO.setBlNo(chgCalcCntrVO.getBlNo());
					//--------------- ChargePartialPaymentVO -------------------
					dmtChgBkgCntrVO.setVslCd(chgPartialPaymentVO.getVslCd());
					dmtChgBkgCntrVO.setSkdVoyNo(chgPartialPaymentVO.getSkdVoyNo());
					dmtChgBkgCntrVO.setSkdDirCd(chgPartialPaymentVO.getSkdDirCd());
					//--------------------------------------------------------
					dmtChgBkgCntrVO.setVpsEtaDt(retChgCalcCntrVO.getVpsEtaDt());
					dmtChgBkgCntrVO.setScNo(retChgCalcCntrVO.getBrhScNo());
					dmtChgBkgCntrVO.setRfaNo(retChgCalcCntrVO.getBrhRfaNo());
					dmtChgBkgCntrVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
					dmtChgBkgCntrVO.setRepCmdtCd(retChgCalcCntrVO.getRepCmdtCd());
					dmtChgBkgCntrVO.setDcgoFlg(retChgCalcCntrVO.getDcgoFlg());
					dmtChgBkgCntrVO.setRcFlg(retChgCalcCntrVO.getRcFlg());
					dmtChgBkgCntrVO.setBbCgoFlg(retChgCalcCntrVO.getBbCgoFlg());
					dmtChgBkgCntrVO.setAwkCgoFlg(retChgCalcCntrVO.getAwkCgoFlg());
					dmtChgBkgCntrVO.setRdCgoFlg(retChgCalcCntrVO.getRdCgoFlg());
					dmtChgBkgCntrVO.setSocFlg(retChgCalcCntrVO.getSocFlg());
					dmtChgBkgCntrVO.setCntrPrtFlg(retChgCalcCntrVO.getCntrPrtFlg());
					dmtChgBkgCntrVO.setAdvShtgCd(retChgCalcCntrVO.getAdvShtgCd());
					dmtChgBkgCntrVO.setDmdtCntrTpCd(retChgCalcCntrVO.getCntrTp());
					dmtChgBkgCntrVO.setDmdtBkgCgoTpCd(retChgCalcCntrVO.getDmdtCgoTpCd());
					dmtChgBkgCntrVO.setPorCd(retChgCalcCntrVO.getPorCd());
					dmtChgBkgCntrVO.setPolCd(retChgCalcCntrVO.getPolCd());
					dmtChgBkgCntrVO.setPodCd(retChgCalcCntrVO.getPodCd());
					dmtChgBkgCntrVO.setDelCd(retChgCalcCntrVO.getDelCd());
					dmtChgBkgCntrVO.setBkgRcvTermCd(retChgCalcCntrVO.getBbRcvTermCd());
					dmtChgBkgCntrVO.setBkgDeTermCd(retChgCalcCntrVO.getBbDeTermCd());
					dmtChgBkgCntrVO.setBkgCntrQty(retChgCalcCntrVO.getBkgQty());
					dmtChgBkgCntrVO.setSlsOfcCd(retChgCalcCntrVO.getSalOfc());
					dmtChgBkgCntrVO.setRhqCd(retChgCalcCntrVO.getSalRhq());
					dmtChgBkgCntrVO.setUpdUsrId(account.getUsr_id());
					dmtChgBkgCntrVO.setUpdOfcCd(account.getOfc_cd());

					dbDao.modifyBookingContainer(dmtChgBkgCntrVO);
				}

				/*
				OfficeNRHQVO officeNRHQVO = null;
				if(chgCalcCntrVO.getOfcTrnsFlg().equals("Y")) {
					officeNRHQVO = dbDao.checkOfficeTransfer(chargeArgumentVO);
				}
				*/


				// *************define DmtChgCalcVO object *****************
				DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
				dmtChgCalcVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCalcVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCalcVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCalcVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCalcVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCalcVO.setChgSeq(chgCalcCntrVO.getChgSeq());

				dmtChgCalcVO.setFmMvmtStsCd(chgCalcCntrVO.getFmMvmtStsCd());
				dmtChgCalcVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				dmtChgCalcVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				dmtChgCalcVO.setToMvmtStsCd(chgCalcCntrVO.getToMvmtStsCd());
				dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
				dmtChgCalcVO.setToMvmtYdCd(chgCalcCntrVO.getToMvmtYdCd());
				dmtChgCalcVO.setNotCreBalFlg("N");
				dmtChgCalcVO.setFtDys(retChgCalcCntrVO.getFtDys());
				dmtChgCalcVO.setFtCmncDt(retChgCalcCntrVO.getFtCmncDt());
				dmtChgCalcVO.setFtEndDt(retChgCalcCntrVO.getFtEndDt());
				dmtChgCalcVO.setFxFtOvrDys(retChgCalcCntrVO.getFxFtOvrDys());
				dmtChgCalcVO.setOrgFtOvrDys(retChgCalcCntrVO.getOrgFtOvrDys());
				dmtChgCalcVO.setScRfaExptOvrDys(retChgCalcCntrVO.getScRfaExptOvrDys());
				dmtChgCalcVO.setAftExptOvrDys(retChgCalcCntrVO.getAftExptOvrDys());
				dmtChgCalcVO.setBzcTrfCurrCd(retChgCalcCntrVO.getBzcTrfCurrCd());
				dmtChgCalcVO.setDmdtTrfAplyTpCd(retChgCalcCntrVO.getDmdtTrfAplyTpCd());
				dmtChgCalcVO.setOrgChgAmt(retChgCalcCntrVO.getOrgChgAmt());
				dmtChgCalcVO.setScRfaExptAmt(retChgCalcCntrVO.getScRfaExptAmt());
				dmtChgCalcVO.setAftExptDcAmt(retChgCalcCntrVO.getAftExptDcAmt());
				dmtChgCalcVO.setBilAmt(retChgCalcCntrVO.getBilAmt());
				dmtChgCalcVO.setDmdtChgStsCd(retChgCalcCntrVO.getDmdtChgStsCd());

				dmtChgCalcVO.setScRfaAmt(retChgCalcCntrVO.getScRfaAmt());
				dmtChgCalcVO.setAftExptAmt(retChgCalcCntrVO.getAftExptAmt());
				dmtChgCalcVO.setBzcTrfSeq(retChgCalcCntrVO.getBzcTrfSeq());
				dmtChgCalcVO.setBzcTrfGrpSeq(retChgCalcCntrVO.getBzcTrfGrpSeq());
				dmtChgCalcVO.setBzcTrfAplyDt(retChgCalcCntrVO.getBzcTrfAplyDt());
				dmtChgCalcVO.setRfaExptAproNo(retChgCalcCntrVO.getRfaExptAproNo());
				dmtChgCalcVO.setRfaExptDarNo(retChgCalcCntrVO.getRfaExptDarNo());
				dmtChgCalcVO.setRfaExptMapgSeq(retChgCalcCntrVO.getRfaExptMapgSeq());
				dmtChgCalcVO.setRfaExptVerSeq(retChgCalcCntrVO.getRfaExptVerSeq());
				dmtChgCalcVO.setRfaRqstDtlSeq(retChgCalcCntrVO.getRfaRqstDtlSeq());
				dmtChgCalcVO.setAftExptAproNo(retChgCalcCntrVO.getAftExptAproNo());
				dmtChgCalcVO.setAftExptDarNo(retChgCalcCntrVO.getAftExptDarNo());
				dmtChgCalcVO.setAftExptAdjSeq(retChgCalcCntrVO.getAftExptAdjSeq());
				dmtChgCalcVO.setScNo(retChgCalcCntrVO.getScNo());
				dmtChgCalcVO.setScExptVerSeq(retChgCalcCntrVO.getScExptVerSeq());
				dmtChgCalcVO.setScExptGrpSeq(retChgCalcCntrVO.getScExptGrpSeq());
				dmtChgCalcVO.setScRfaExptAplyDt(retChgCalcCntrVO.getScRfaExptAplyDt());
				dmtChgCalcVO.setCorrRmk(chgCalcCntrVO.getCorrRmk());

				dmtChgCalcVO.setOfcCd(chgCalcCntrVO.getOfcCd());
				dmtChgCalcVO.setOfcRhqCd(chgCalcCntrVO.getOfcRhqCd());
				dmtChgCalcVO.setUpdUsrId(account.getUsr_id());
				dmtChgCalcVO.setUpdOfcCd(account.getOfc_cd());
				dmtChgCalcVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
				dmtChgCalcVO.setCmdtTrfSeq(retChgCalcCntrVO.getCmdtTrfSeq());
				dmtChgCalcVO.setCmdtExptAplyDt(retChgCalcCntrVO.getCmdtExptAplyDt());
				dmtChgCalcVO.setCmdtOvrDys(retChgCalcCntrVO.getCmdtOvrDys());
				dmtChgCalcVO.setCmdtExptAmt(retChgCalcCntrVO.getCmdtExptAmt());
				dmtChgCalcVO.setWebMtyDt(chgCalcCntrVO.getWebMtyDt().replace("-", ""));

				dbDao.modifyChargeCalculation(dmtChgCalcVO);
				
				if(chgCalcCntrVO.getDulTpExptFlg().equals("Y")) {
					//modify ORG_CHG_AMT, SC_RFA_EXPT_AMT of  Dual Exception Charge
					dbDao.modifyOrgChgAmt(chargeArgumentVO);
				}

				/*******************************************************************************
				- Exist applied Clock Stop when Charge calculation, create History data.
				- logig
				  1. delete created Clock Stop History . (deleteClockStopHistory)
				  2. repeat putting in action  applied  Clock Stop count times, and Insert ( addClockStopHistory )
				*******************************************************************************/
				List<String> cStopNoList = retChgCalcCntrVO.getCStopNoList();

				if(cStopNoList != null && cStopNoList.size() > 0) {
					DmtChgTmCskStopVO dmtChgTmCskStopVO = new DmtChgTmCskStopVO();
					dmtChgTmCskStopVO.setSvrId(chgCalcCntrVO.getSvrId());
					dmtChgTmCskStopVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					dmtChgTmCskStopVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					dmtChgTmCskStopVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					dmtChgTmCskStopVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					dmtChgTmCskStopVO.setChgSeq(chgCalcCntrVO.getChgSeq());
					dmtChgTmCskStopVO.setCreOfcCd(account.getOfc_cd());

					modifyClockStopHistory(dmtChgTmCskStopVO, cStopNoList);
				}

				corrHisSeq++;
				dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
				dbDao.addChargeHistory(dmtChgCorrHisVO);

			} // for end

			return resultVO;

		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify charge"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify charge"}).getMessage());
		}
	}
	
	
	/**
	 * Calculate Dual Charge Combined Charge of Dual Exception Charge.
	 *
	 * @param String callFlag
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @param List<ChargeCalculationContainerVO> chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO dualExceptionChargeCalculation(String callFlag, ChargeCalculationContainerVO chargeCalculationContainerVO,
						List<ChargeCalculationContainerVO> chargeCalculationContainerVOs, SignOnUserAccount account) throws EventException {
		try {
			DmtResultVO resultVO = new DmtResultVO();
			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			DMTDualChargeCalculationUtil dmtDualChargeCalculationUtil = new DMTDualChargeCalculationUtil();
			
			ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
			
			/* ****************************************
			CTOC(POR) --> DTOC(POR, mandatory item), DMOF(POL), DMOF(POR, optional item)
			CTIC(DEL) --> DMIF(POD, mandatory item), DTIC(DEL), DMIF(DEL, optional item)
			
			DTOC, DMIF --> From info.
			DMOF, DTIC --> To info.
			
			callFlag: 'DRSAVE', 'BALANCE', 'PARTIAL', 'SAVE', 'WEBCANCEL', 'PRECAL'
			****************************************** */
			for (int i=0; i < 1; i++ ) {
				
				if(callFlag.equals("BALANCE")) {
					if(chargeCalculationContainerVOs.size() == 2 && i==0) {		// 'DTOC', 'DMIF'
						continue;
					}
				}
				
				ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs.get(i);
					
				if(	(chgCalcCntrVO.getDmdtTrfCd().equals("DTOC") && chgCalcCntrVO.getDmdtChgLocDivCd().equals("POR")) ||
					(chgCalcCntrVO.getDmdtTrfCd().equals("DMIF") && chgCalcCntrVO.getDmdtChgLocDivCd().equals("POD")) ) {
					
					String mvmtDt = chargeCalculationContainerVO.getFmMvmtDt();
					if(mvmtDt.length() == 12) mvmtDt = mvmtDt.substring(0, 8);
					chgCalcCntrVO.setFmMvmtDt(mvmtDt);
					chgCalcCntrVO.setFmMvmtYdCd(chargeCalculationContainerVO.getFmMvmtYdCd());
					chgCalcCntrVO.setFmMvmtStsCd(chargeCalculationContainerVO.getFmMvmtStsCd());
				}
				
				// DTIC, DMOF
				String mvmtDt = chargeCalculationContainerVO.getToMvmtDt();
				if(mvmtDt.length() == 12) mvmtDt = mvmtDt.substring(0, 8);
				chgCalcCntrVO.setToMvmtDt(mvmtDt);
				chgCalcCntrVO.setToMvmtYdCd(chargeCalculationContainerVO.getToMvmtYdCd());
				chgCalcCntrVO.setToMvmtStsCd(chargeCalculationContainerVO.getToMvmtStsCd());

				
				chgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				chgArgVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				chgArgVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());

				/*
				String chgMaxSeq = dbDao.searchChargeMaxSequence(chgArgVO);
				if(!chgCalcCntrVO.getChgSeq().equals(chgMaxSeq)) {
					//"There is a balance charge !"
					resultVO.setResultCode("DMT01030");
					return resultVO;
				}

				boolean chgInvChk = dbDao.searchChargeInvoiceCheck(chgArgVO);
				if(chgInvChk) {
					//"Already Invoiced"
					resultVO.setResultCode("DMT01002");
					return resultVO;
				}
				*/

				String toMvmtStsCd = chgCalcCntrVO.getToMvmtStsCd();

				// DR Date Checking
				if(toMvmtStsCd.equals("DR")) {
					// only Apply PreCal, DR Save
					if(callFlag.equals("PRECAL") || callFlag.equals("DRSAVE")) {
						if(chgCalcCntrVO.getToMvmtYdCd().equals(""))
							chgCalcCntrVO.setToMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
					}
				} else if(toMvmtStsCd.equals("CS")) {
					// Clock Stop
					/*
					String fmMvmtDt = chgCalcCntrVO.getFmMvmtDt();
					String toMvmtDt = chgCalcCntrVO.getToMvmtDt();

					if(fmMvmtDt.compareTo(toMvmtDt) >= 0) {
						// CS date should be later than From date
						resultVO.setResultCode("DMT01004");
						return resultVO;
					}*/

					// only Apply PreCal, DR Save
					if(callFlag.equals("PRECAL") || callFlag.equals("DRSAVE")) {
						if(chgCalcCntrVO.getToMvmtYdCd().equals(""))
							chgCalcCntrVO.setToMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
					}
				}
				
				/*
				if(callFlag.equals("PRECAL")) {
					chgArgVO.setDulTpExptFlg("Y");
					
					// delete previous  PreCal Charge Booking Container info.
					boolean isExist = dbDao.checkPreChargeBookingContainerExists(chgArgVO);
					if(isExist) {
						dbDao.deletePreChargeBookingContainer(chgArgVO);
					}
					
					// create PreCal  Charge Booking Container info.
					dbDao.createPreChargeBookingContainer(chgArgVO);
					
					// delete previous  PreCal Charge info.
					isExist = dbDao.checkPreChargeCalculationExists(chgArgVO);
					if(isExist) {
						dbDao.deletePreChargeCalculation(chgArgVO);
					}
					
					// create PreCal Charge info.
					dbDao.createPreChargeCalculation(chgArgVO);
				}
				*/

				// ***********  searchChargeCalculationUseData **************
				ChargePartialPaymentVO chgPartialPaymentVO = dbDao.searchChargeCalculationUseData(chgArgVO);


				chgCalcCntrVO.setFmMvmtDt(chgPartialPaymentVO.getFmMvmtDt());

				/*
				 Case in  "L"(Long Staying), "U"(Unfinished), "N"(No Charge),Do Re-Calculation Even though there is no To Date/Yard 
				 , initialize To Date
				 */
				String chgStsCd = chgCalcCntrVO.getDmdtChgStsCd();
				if( (chgStsCd.equals("L") || chgStsCd.equals("U") || chgStsCd.equals("N"))
					&& chgPartialPaymentVO.getToMvmtDt().length() < 12 ) {
					chgCalcCntrVO.setToMvmtDt("");
				} else
					chgCalcCntrVO.setToMvmtDt(chgPartialPaymentVO.getToMvmtDt());

				
				if(callFlag.equals("BALANCE")) {
					chgCalcCntrVO.setFmMvmtStsCd("DR");
					chgCalcCntrVO.setFmMvmtDt(chgCalcCntrVO.getToMvmtDt());
					chgCalcCntrVO.setToMvmtStsCd("");
					chgCalcCntrVO.setToMvmtDt("");
					chgCalcCntrVO.setToMvmtYdCd("");
					chgCalcCntrVO.setCorrRmk("Balance Creation");
					
				} else if(callFlag.equals("PARTIAL")) {	
					if("N".equals(chgCalcCntrVO.getWebIndFlg()) && chgCalcCntrVO.getToMvmtStsCd().equals("DR")) {
						chgArgVO.setWebIndFlg("N");
						dbDao.modifyChargeWebIndicator(chgArgVO);
					}
				} else {
					//Case in MT Notification Data (Update To Movement="DR" , Web Indicator="Y"), Web Indicator = "N" 
					if("Y".equals(chgCalcCntrVO.getWebIndFlg()) && chgCalcCntrVO.getToMvmtStsCd().equals("DR")
							|| callFlag.equals("WEBCANCEL")) {
						chgArgVO.setWebIndFlg("N");
						dbDao.modifyChargeWebIndicator(chgArgVO);
					}
				}
				

				ChargeCalculationParmVO chgCalcParmVO = new ChargeCalculationParmVO();
				chgCalcParmVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgCalcParmVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgCalcParmVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgCalcParmVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgCalcParmVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgCalcParmVO.setChgSeq(chgCalcCntrVO.getChgSeq());

				chgCalcParmVO.setActCntCd(chgPartialPaymentVO.getActCntCd());
				chgCalcParmVO.setActCustSeq(chgPartialPaymentVO.getActCustSeq());
				chgCalcParmVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				chgCalcParmVO.setCntrTpszCd(chgCalcCntrVO.getCntrTpszCd());
				chgCalcParmVO.setCustCntCd(chgPartialPaymentVO.getCustCntCd());
				chgCalcParmVO.setCustSeq(chgPartialPaymentVO.getCustSeq());
				chgCalcParmVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				chgCalcParmVO.setFmMvmtStsCd(chgCalcCntrVO.getFmMvmtStsCd());
				chgCalcParmVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				chgCalcParmVO.setIoBndCd(chgPartialPaymentVO.getIoBndCd());
				chgCalcParmVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				chgCalcParmVO.setToMvmtStsCd(chgCalcCntrVO.getToMvmtStsCd());
				chgCalcParmVO.setToMvmtYdCd(chgCalcCntrVO.getToMvmtYdCd());
				
				retChgCalcCntrVO = dmtDualChargeCalculationUtil.dualChargeCalculation(chgCalcParmVO);
				
				if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
					resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
					resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
					return resultVO;
				}
					
				if(!callFlag.equals("BALANCE") && !retChgCalcCntrVO.getMsgCd().equals("0")) {
					retChgCalcCntrVO.setDmdtChgStsCd("E");
				}

				// get back MT Notification Indicator originaly
				if(callFlag.equals("PRECAL")) {
					chgArgVO.setWebIndFlg(chgCalcCntrVO.getWebIndFlg());
					dbDao.modifyChargeWebIndicator(chgArgVO);
				}

				
				if(!callFlag.equals("BALANCE") && !chgCalcCntrVO.getFmMvmtStsCd().equals("DR")) {
					// ------------define DmtChgBkgCntrVO object -----------------
					DmtChgBkgCntrVO dmtChgBkgCntrVO = new DmtChgBkgCntrVO();
					dmtChgBkgCntrVO.setSvrId(chgCalcCntrVO.getSvrId());
					dmtChgBkgCntrVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					dmtChgBkgCntrVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());

					dmtChgBkgCntrVO.setBlNo(chgCalcCntrVO.getBlNo());
					//--------------- ChargePartialPaymentVO -------------------
					dmtChgBkgCntrVO.setVslCd(chgPartialPaymentVO.getVslCd());
					dmtChgBkgCntrVO.setSkdVoyNo(chgPartialPaymentVO.getSkdVoyNo());
					dmtChgBkgCntrVO.setSkdDirCd(chgPartialPaymentVO.getSkdDirCd());
					//--------------------------------------------------------
					dmtChgBkgCntrVO.setVpsEtaDt(retChgCalcCntrVO.getVpsEtaDt());
					dmtChgBkgCntrVO.setScNo(retChgCalcCntrVO.getBrhScNo());
					dmtChgBkgCntrVO.setRfaNo(retChgCalcCntrVO.getBrhRfaNo());
					dmtChgBkgCntrVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
					dmtChgBkgCntrVO.setRepCmdtCd(retChgCalcCntrVO.getRepCmdtCd());
					dmtChgBkgCntrVO.setDcgoFlg(retChgCalcCntrVO.getDcgoFlg());
					dmtChgBkgCntrVO.setRcFlg(retChgCalcCntrVO.getRcFlg());
					dmtChgBkgCntrVO.setBbCgoFlg(retChgCalcCntrVO.getBbCgoFlg());
					dmtChgBkgCntrVO.setAwkCgoFlg(retChgCalcCntrVO.getAwkCgoFlg());
					dmtChgBkgCntrVO.setRdCgoFlg(retChgCalcCntrVO.getRdCgoFlg());
					dmtChgBkgCntrVO.setSocFlg(retChgCalcCntrVO.getSocFlg());
					dmtChgBkgCntrVO.setCntrPrtFlg(retChgCalcCntrVO.getCntrPrtFlg());
					dmtChgBkgCntrVO.setAdvShtgCd(retChgCalcCntrVO.getAdvShtgCd());
					dmtChgBkgCntrVO.setDmdtCntrTpCd(retChgCalcCntrVO.getCntrTp());
					dmtChgBkgCntrVO.setDmdtBkgCgoTpCd(retChgCalcCntrVO.getDmdtCgoTpCd());
					dmtChgBkgCntrVO.setPorCd(retChgCalcCntrVO.getPorCd());
					dmtChgBkgCntrVO.setPolCd(retChgCalcCntrVO.getPolCd());
					dmtChgBkgCntrVO.setPodCd(retChgCalcCntrVO.getPodCd());
					dmtChgBkgCntrVO.setDelCd(retChgCalcCntrVO.getDelCd());
					dmtChgBkgCntrVO.setBkgRcvTermCd(retChgCalcCntrVO.getBbRcvTermCd());
					dmtChgBkgCntrVO.setBkgDeTermCd(retChgCalcCntrVO.getBbDeTermCd());
					dmtChgBkgCntrVO.setBkgCntrQty(retChgCalcCntrVO.getBkgQty());
					dmtChgBkgCntrVO.setSlsOfcCd(retChgCalcCntrVO.getSalOfc());
					dmtChgBkgCntrVO.setRhqCd(retChgCalcCntrVO.getSalRhq());
					dmtChgBkgCntrVO.setUpdUsrId(account.getUsr_id());
					dmtChgBkgCntrVO.setUpdOfcCd(account.getOfc_cd());

					if(callFlag.equals("PRECAL"))
						dbDao.modifyPreBookingContainer(dmtChgBkgCntrVO);
					else
						dbDao.modifyBookingContainer(dmtChgBkgCntrVO);
				}

				
				// *************define DmtChgCalcVO object*****************
				DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
				
				if(callFlag.equals("BALANCE")) {
					
					if(chargeCalculationContainerVOs.size() == 2) {
						chgArgVO.setDmdtTrfCd(chargeCalculationContainerVO.getDmdtTrfCd());
						chgArgVO.setDmdtChgLocDivCd(chargeCalculationContainerVO.getDmdtChgLocDivCd());
					}
					
					String chgMaxSeq = dbDao.searchChargeMaxSequence(chgArgVO);
					
					// Charge Sequence = Max Charge Sequence + 1
					String nextChgSeq = String.valueOf(NumberUtils.toInt(chgMaxSeq, 0) + 1);
					
					chgCalcCntrVO.setChgSeq(nextChgSeq);
					chgCalcCntrVO.setWebMtyDt(retChgCalcCntrVO.getMtDate());
					
					dmtChgCalcVO.setActCntCd(chgCalcParmVO.getActCntCd());
					dmtChgCalcVO.setActCustSeq(chgCalcParmVO.getActCustSeq());
					dmtChgCalcVO.setCustCntCd(chgCalcParmVO.getCustCntCd());
					dmtChgCalcVO.setCustSeq(chgCalcParmVO.getCustSeq());
					dmtChgCalcVO.setCreUsrId(account.getUsr_id());
					dmtChgCalcVO.setCreOfcCd(account.getOfc_cd());
				}
				
				dmtChgCalcVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCalcVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCalcVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCalcVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCalcVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCalcVO.setChgSeq(chgCalcCntrVO.getChgSeq());

				dmtChgCalcVO.setFmMvmtStsCd(chgCalcCntrVO.getFmMvmtStsCd());
				dmtChgCalcVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				dmtChgCalcVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				dmtChgCalcVO.setToMvmtStsCd(chgCalcCntrVO.getToMvmtStsCd());
				dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
				dmtChgCalcVO.setToMvmtYdCd(chgCalcCntrVO.getToMvmtYdCd());
				dmtChgCalcVO.setNotCreBalFlg("N");
				dmtChgCalcVO.setFtDys(retChgCalcCntrVO.getFtDys());
				dmtChgCalcVO.setFtCmncDt(retChgCalcCntrVO.getFtCmncDt());
				dmtChgCalcVO.setFtEndDt(retChgCalcCntrVO.getFtEndDt());
				dmtChgCalcVO.setFxFtOvrDys(retChgCalcCntrVO.getFxFtOvrDys());
				dmtChgCalcVO.setOrgFtOvrDys(retChgCalcCntrVO.getOrgFtOvrDys());
				dmtChgCalcVO.setScRfaExptOvrDys(retChgCalcCntrVO.getScRfaExptOvrDys());
				dmtChgCalcVO.setAftExptOvrDys(retChgCalcCntrVO.getAftExptOvrDys());
				dmtChgCalcVO.setBzcTrfCurrCd(retChgCalcCntrVO.getBzcTrfCurrCd());
				dmtChgCalcVO.setDmdtTrfAplyTpCd(retChgCalcCntrVO.getDmdtTrfAplyTpCd());
				dmtChgCalcVO.setOrgChgAmt(retChgCalcCntrVO.getOrgChgAmt());
				dmtChgCalcVO.setScRfaExptAmt(retChgCalcCntrVO.getScRfaExptAmt());
				dmtChgCalcVO.setAftExptDcAmt(retChgCalcCntrVO.getAftExptDcAmt());
				dmtChgCalcVO.setBilAmt(retChgCalcCntrVO.getBilAmt());
				dmtChgCalcVO.setDmdtChgStsCd(retChgCalcCntrVO.getDmdtChgStsCd());

				dmtChgCalcVO.setScRfaAmt(retChgCalcCntrVO.getScRfaAmt());
				dmtChgCalcVO.setAftExptAmt(retChgCalcCntrVO.getAftExptAmt());
				dmtChgCalcVO.setBzcTrfSeq(retChgCalcCntrVO.getBzcTrfSeq());
				dmtChgCalcVO.setBzcTrfGrpSeq(retChgCalcCntrVO.getBzcTrfGrpSeq());
				dmtChgCalcVO.setBzcTrfAplyDt(retChgCalcCntrVO.getBzcTrfAplyDt());
				dmtChgCalcVO.setRfaExptAproNo(retChgCalcCntrVO.getRfaExptAproNo());
				dmtChgCalcVO.setRfaExptDarNo(retChgCalcCntrVO.getRfaExptDarNo());
				dmtChgCalcVO.setRfaExptMapgSeq(retChgCalcCntrVO.getRfaExptMapgSeq());
				dmtChgCalcVO.setRfaExptVerSeq(retChgCalcCntrVO.getRfaExptVerSeq());
				dmtChgCalcVO.setRfaRqstDtlSeq(retChgCalcCntrVO.getRfaRqstDtlSeq());
				dmtChgCalcVO.setAftExptAproNo(retChgCalcCntrVO.getAftExptAproNo());
				dmtChgCalcVO.setAftExptDarNo(retChgCalcCntrVO.getAftExptDarNo());
				dmtChgCalcVO.setAftExptAdjSeq(retChgCalcCntrVO.getAftExptAdjSeq());
				dmtChgCalcVO.setScNo(retChgCalcCntrVO.getBrhScNo());
				dmtChgCalcVO.setScExptVerSeq(retChgCalcCntrVO.getScExptVerSeq());
				dmtChgCalcVO.setScExptGrpSeq(retChgCalcCntrVO.getScExptGrpSeq());
				dmtChgCalcVO.setScRfaExptAplyDt(retChgCalcCntrVO.getScRfaExptAplyDt());
				dmtChgCalcVO.setCorrRmk(chgCalcCntrVO.getCorrRmk());

				dmtChgCalcVO.setOfcCd(chgCalcCntrVO.getOfcCd());
				dmtChgCalcVO.setOfcRhqCd(chgCalcCntrVO.getOfcRhqCd());
				dmtChgCalcVO.setUpdUsrId(account.getUsr_id());
				dmtChgCalcVO.setUpdOfcCd(account.getOfc_cd());
				dmtChgCalcVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
				dmtChgCalcVO.setCmdtTrfSeq(retChgCalcCntrVO.getCmdtTrfSeq());
				dmtChgCalcVO.setCmdtExptAplyDt(retChgCalcCntrVO.getCmdtExptAplyDt());
				dmtChgCalcVO.setCmdtOvrDys(retChgCalcCntrVO.getCmdtOvrDys());
				dmtChgCalcVO.setCmdtExptAmt(retChgCalcCntrVO.getCmdtExptAmt());
				if(chgCalcCntrVO.getWebMtyDt() != null)
					dmtChgCalcVO.setWebMtyDt(chgCalcCntrVO.getWebMtyDt().replace("-", ""));

				
				if(callFlag.equals("PRECAL")) {
					dbDao.modifyPreCharge(dmtChgCalcVO);
					
				} else if(callFlag.equals("BALANCE")) {
					//  Insert into DMT_CHG_CALC 
					dmtChgCalcVO.setDulTpExptFlg(chgCalcCntrVO.getDulTpExptFlg());
					dbDao.addCharge(dmtChgCalcVO);
					
				} else {
					dbDao.modifyChargeCalculation(dmtChgCalcVO);
					
				}

			} // for end

			return resultVO;

		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"Dual Exception Charge Calculation"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"Dual Exception Charge Calculation"}).getMessage());
		}
	}
	
	
	/**
	 * Create Balance Charge data (Balance Creation)<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO createBalanceCharge(ChargeCalculationContainerVO[] chargeCalculationContainerVOs
											,SignOnUserAccount account) throws EventException {
		try {
			DmtResultVO resultVO = new DmtResultVO();
			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			DMTBalanceChargeCalculationUtil dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
			DMTCancelChargeCalculationUtil	dmtCancelChargeCalculationUtil	= new DMTCancelChargeCalculationUtil();
			DMTCombinedChargeCalculationUtil dmtCombinedChargeCalculationUtil = new DMTCombinedChargeCalculationUtil();
			
			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO utilChgArgVO = null;
			utilChgArgVO = new com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
			
			ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
			
			/* ******************** logic ******************************************
			0. Charge List execution repeat
			1. Status is F, C, I  and  no Balance Charge, 
			   the Charge is last, even though exists Balance Charge ,
			   when TO MVMT Status is not "DR", error process showing message[DMT01058].
			2. Calling balanceChargeCalculation , Balance Charge Calculat.
			**************************************************************************/
			
			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
				ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs[i];
				
				chgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				chgArgVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				chgArgVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());

				
				String chgMaxSeq = dbDao.searchChargeMaxSequence(chgArgVO);
				
				if(!chgCalcCntrVO.getChgSeq().equals(chgMaxSeq)) {
					//"There is already a balance charge!"
					resultVO.setResultCode("DMT01057");
					return resultVO;
				}
				
				// Status is F, C, I , and no Balance Charge and last Balance Charge data
				// Search Charge data , To MVMT Status is 'DR' 
				//BalanceCreationChargeVO balanceCreChgVO = dbDao.searchBalanceCreationCharge(chgArgVO);
				
				//chgCalcCntrVO.setFmMvmtDt(balanceCreChgVO.getFmMvmtDt());
				//chgCalcCntrVO.setFmMvmtStsCd(balanceCreChgVO.getFmMvmtStsCd());
				//chgCalcCntrVO.setFmMvmtYdCd(balanceCreChgVO.getFmMvmtYdCd());
				//chgCalcCntrVO.setToMvmtDt(balanceCreChgVO.getToMvmtDt());
				//chgCalcCntrVO.setToMvmtStsCd(balanceCreChgVO.getToMvmtStsCd());
				//chgCalcCntrVO.setToMvmtYdCd(balanceCreChgVO.getToMvmtYdCd());
				
				
				// ***********  searchChargeCalculationUseData **************
				ChargePartialPaymentVO chgPartialPaymentVO = dbDao.searchChargeCalculationUseData(chgArgVO);

				
				chgCalcCntrVO.setFmMvmtDt(chgPartialPaymentVO.getFmMvmtDt());

				/*
				  Case in  "L"(Long Staying), "U"(Unfinished), "N"(No Charge),Do Re-Calculation Even though there is no To Date/Yard 
				 , initialize To Date
				 */
				String chgStsCd = chgCalcCntrVO.getDmdtChgStsCd();
				if( (chgStsCd.equals("L") || chgStsCd.equals("U") || chgStsCd.equals("N"))
					&& chgPartialPaymentVO.getToMvmtDt().length() < 12 ) {
					chgCalcCntrVO.setToMvmtDt("");
				} else
					chgCalcCntrVO.setToMvmtDt(chgPartialPaymentVO.getToMvmtDt());

				
				
				/*
				if("Y".equals(chgCalcCntrVO.getWebIndFlg()) && chgCalcCntrVO.getToMvmtStsCd().equals("DR")) {
					chgArgVO.setWebIndFlg("N");
					dbDao.modifyChargeWebIndicator(chgArgVO);
				} */
				
				ChargeCalculationParmVO chgCalcParmVO = new ChargeCalculationParmVO();
				chgCalcParmVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgCalcParmVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgCalcParmVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgCalcParmVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgCalcParmVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgCalcParmVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				chgCalcParmVO.setActCntCd(chgPartialPaymentVO.getActCntCd());
				chgCalcParmVO.setActCustSeq(chgPartialPaymentVO.getActCustSeq());
				chgCalcParmVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				chgCalcParmVO.setCntrTpszCd(chgCalcCntrVO.getCntrTpszCd());
				chgCalcParmVO.setCustCntCd(chgPartialPaymentVO.getCustCntCd());
				chgCalcParmVO.setCustSeq(chgPartialPaymentVO.getCustSeq());
				chgCalcParmVO.setFmMvmtDt(chgCalcCntrVO.getToMvmtDt());
				chgCalcParmVO.setFmMvmtStsCd("DR");
				chgCalcParmVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				chgCalcParmVO.setIoBndCd(chgPartialPaymentVO.getIoBndCd());
				chgCalcParmVO.setToMvmtDt("");
				chgCalcParmVO.setToMvmtStsCd("");
				chgCalcParmVO.setToMvmtYdCd("");
				
				
				if(chgCalcCntrVO.getDulTpExptFlg().equals("Y")) {
					// search Dual Charge of Dual Exception Charge abount Combined Charge.
					List<ChargeCalculationContainerVO> chgCalcCntrVOs = dbDao.searchDualChargeTariff(chgArgVO);
					
					if(chgCalcCntrVOs != null && chgCalcCntrVOs.size() > 0) {
						chgArgVO.setCallFlag("BALANCE");
						resultVO = dualExceptionChargeCalculation("BALANCE", chgCalcCntrVO, chgCalcCntrVOs, account);
						
						// error Return
						if(resultVO.getResultCode() != null) {
							return resultVO;
						}
					}
					
					retChgCalcCntrVO = dmtCombinedChargeCalculationUtil.combinedChargeCalculation(chgCalcParmVO);
					
				} else {
					if(chgCalcCntrVO.getCxlBkgChgFlg().equals("Y")) {
						retChgCalcCntrVO = dmtCancelChargeCalculationUtil.cancelChargeCalculation(chgCalcParmVO);
						
						if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					} else {
						retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
						
						if(retChgCalcCntrVO.getMsgCd().equals("-1")) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					}
				}
				
					
				/*if(!retChgCalcCntrVO.getMsgCd().equals("0")) {
					retChgCalcCntrVO.setDmdtChgStsCd("E");
				}*/
				
				// Charge Sequence = Max Charge Sequence + 1
				String nextChgSeq = String.valueOf(NumberUtils.toInt(chgMaxSeq, 0) + 1);
				chgCalcCntrVO.setChgSeq(nextChgSeq);
				
				
				// after Charge Calculation , search SYS_AREA_GRP_ID of return OFC_CD
				String svrId = dbDao.searchRhqGrpId(retChgCalcCntrVO.getOfcCd());
				
				
				// checking  Charge Booking Container info
				ChargeArgumentVO chkChgArgVO = new ChargeArgumentVO();
				chkChgArgVO.setSvrId(svrId);
				chkChgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chkChgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				
				boolean chkExists = dbDao.checkChargeBookingContainerExists(chkChgArgVO);
				
		
				if(!chkExists) {
		
					DmtChgBkgCntrVO dmtChgBkgCntrVO = new DmtChgBkgCntrVO();
					dmtChgBkgCntrVO.setSvrId(svrId);
					dmtChgBkgCntrVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					dmtChgBkgCntrVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					dmtChgBkgCntrVO.setCntrTpszCd(chgCalcCntrVO.getCntrTpszCd());
					
					dmtChgBkgCntrVO.setBkgNo(chgCalcCntrVO.getBkgNo());
					dmtChgBkgCntrVO.setBlNo(chgCalcCntrVO.getBlNo());
					dmtChgBkgCntrVO.setVslCd(chgCalcCntrVO.getVvdCd().substring(0, 4));
					dmtChgBkgCntrVO.setSkdVoyNo(chgCalcCntrVO.getVvdCd().substring(4, 8));
					dmtChgBkgCntrVO.setSkdDirCd(chgCalcCntrVO.getVvdCd().substring(8));
					//--------------------------------------------------------
					dmtChgBkgCntrVO.setEstmTmOfArrDt(chgCalcCntrVO.getVpsEtaDt().replace("-", ""));
					dmtChgBkgCntrVO.setScNo(retChgCalcCntrVO.getBrhScNo());
					dmtChgBkgCntrVO.setRfaNo(retChgCalcCntrVO.getBrhRfaNo());
					dmtChgBkgCntrVO.setCustCntCd(chgCalcParmVO.getCustCntCd());
					dmtChgBkgCntrVO.setCustSeq(chgCalcParmVO.getCustSeq());
					
					dmtChgBkgCntrVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
					dmtChgBkgCntrVO.setRepCmdtCd(retChgCalcCntrVO.getRepCmdtCd());
					dmtChgBkgCntrVO.setDcgoFlg(retChgCalcCntrVO.getDcgoFlg());
					dmtChgBkgCntrVO.setRcFlg(retChgCalcCntrVO.getRcFlg());
					dmtChgBkgCntrVO.setBbCgoFlg(retChgCalcCntrVO.getBbCgoFlg());
					dmtChgBkgCntrVO.setAwkCgoFlg(retChgCalcCntrVO.getAwkCgoFlg());
					dmtChgBkgCntrVO.setRdCgoFlg(retChgCalcCntrVO.getRdCgoFlg());
					dmtChgBkgCntrVO.setSocFlg(retChgCalcCntrVO.getSocFlg());
					dmtChgBkgCntrVO.setCntrPrtFlg(retChgCalcCntrVO.getCntrPrtFlg());
					dmtChgBkgCntrVO.setAdvShtgCd(retChgCalcCntrVO.getAdvShtgCd());
					dmtChgBkgCntrVO.setDmdtCntrTpCd(retChgCalcCntrVO.getCntrTp());
					dmtChgBkgCntrVO.setDmdtBkgCgoTpCd(retChgCalcCntrVO.getDmdtCgoTpCd());
					dmtChgBkgCntrVO.setPorCd(retChgCalcCntrVO.getPorCd());
					dmtChgBkgCntrVO.setPolCd(retChgCalcCntrVO.getPolCd());
					dmtChgBkgCntrVO.setPodCd(retChgCalcCntrVO.getPodCd());
					dmtChgBkgCntrVO.setDelCd(retChgCalcCntrVO.getDelCd());
					dmtChgBkgCntrVO.setBkgRcvTermCd(retChgCalcCntrVO.getBbRcvTermCd());
					dmtChgBkgCntrVO.setBkgDeTermCd(retChgCalcCntrVO.getBbDeTermCd());
					dmtChgBkgCntrVO.setBkgCntrQty(retChgCalcCntrVO.getBkgQty());
					dmtChgBkgCntrVO.setSlsOfcCd(retChgCalcCntrVO.getSalOfc());
					dmtChgBkgCntrVO.setRhqCd(retChgCalcCntrVO.getSalRhq());
					dmtChgBkgCntrVO.setCreUsrId(account.getUsr_id());
					dmtChgBkgCntrVO.setCreOfcCd(account.getOfc_cd());
					dmtChgBkgCntrVO.setUpdUsrId(account.getUsr_id());
					dmtChgBkgCntrVO.setUpdOfcCd(account.getOfc_cd());
					
					// insert DMT_CHG_BKG_CNTR 
					dbDao.addBkgCntr(dmtChgBkgCntrVO);
				}
				
				
				// addCharge (Insert DMT_CHG_CALC)
				DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
				
				dmtChgCalcVO.setSvrId(svrId);
				dmtChgCalcVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCalcVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCalcVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCalcVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCalcVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				dmtChgCalcVO.setFmMvmtStsCd("DR");
				dmtChgCalcVO.setFmMvmtDt(chgCalcCntrVO.getToMvmtDt());
				dmtChgCalcVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				dmtChgCalcVO.setToMvmtStsCd("");
				dmtChgCalcVO.setToMvmtDt("");
				dmtChgCalcVO.setToMvmtYdCd("");
				dmtChgCalcVO.setNotCreBalFlg("N");
				dmtChgCalcVO.setFtDys(retChgCalcCntrVO.getFtDys());
				dmtChgCalcVO.setFtCmncDt(retChgCalcCntrVO.getFtCmncDt());
				dmtChgCalcVO.setFtEndDt(retChgCalcCntrVO.getFtEndDt());
				dmtChgCalcVO.setFxFtOvrDys(retChgCalcCntrVO.getFxFtOvrDys());
				dmtChgCalcVO.setOrgFtOvrDys(retChgCalcCntrVO.getOrgFtOvrDys());
				dmtChgCalcVO.setScRfaExptOvrDys(retChgCalcCntrVO.getScRfaExptOvrDys());
				dmtChgCalcVO.setAftExptOvrDys(retChgCalcCntrVO.getAftExptOvrDys());
				dmtChgCalcVO.setBzcTrfCurrCd(retChgCalcCntrVO.getBzcTrfCurrCd());
				dmtChgCalcVO.setDmdtTrfAplyTpCd(retChgCalcCntrVO.getDmdtTrfAplyTpCd());
				dmtChgCalcVO.setOrgChgAmt(retChgCalcCntrVO.getOrgChgAmt());
				dmtChgCalcVO.setScRfaExptAmt(retChgCalcCntrVO.getScRfaExptAmt());
				dmtChgCalcVO.setAftExptDcAmt(retChgCalcCntrVO.getAftExptDcAmt());
				dmtChgCalcVO.setBilAmt(retChgCalcCntrVO.getBilAmt());
				dmtChgCalcVO.setDmdtChgStsCd(retChgCalcCntrVO.getDmdtChgStsCd());
				
				dmtChgCalcVO.setScRfaAmt(retChgCalcCntrVO.getScRfaAmt());
				dmtChgCalcVO.setAftExptAmt(retChgCalcCntrVO.getAftExptAmt());
				dmtChgCalcVO.setBzcTrfSeq(retChgCalcCntrVO.getBzcTrfSeq());
				dmtChgCalcVO.setBzcTrfGrpSeq(retChgCalcCntrVO.getBzcTrfGrpSeq());
				dmtChgCalcVO.setBzcTrfAplyDt(retChgCalcCntrVO.getBzcTrfAplyDt());		
				dmtChgCalcVO.setRfaExptAproNo(retChgCalcCntrVO.getRfaExptAproNo());
				dmtChgCalcVO.setRfaExptDarNo(retChgCalcCntrVO.getRfaExptDarNo());
				dmtChgCalcVO.setRfaExptMapgSeq(retChgCalcCntrVO.getRfaExptMapgSeq());		
				dmtChgCalcVO.setRfaExptVerSeq(retChgCalcCntrVO.getRfaExptVerSeq());
				dmtChgCalcVO.setRfaRqstDtlSeq(retChgCalcCntrVO.getRfaRqstDtlSeq());
				dmtChgCalcVO.setAftExptAproNo(retChgCalcCntrVO.getAftExptAproNo());
				dmtChgCalcVO.setAftExptDarNo(retChgCalcCntrVO.getAftExptDarNo());
				dmtChgCalcVO.setAftExptAdjSeq(retChgCalcCntrVO.getAftExptAdjSeq());
				dmtChgCalcVO.setScNo(retChgCalcCntrVO.getBrhScNo());
				dmtChgCalcVO.setScExptVerSeq(retChgCalcCntrVO.getScExptVerSeq());
				dmtChgCalcVO.setScExptGrpSeq(retChgCalcCntrVO.getScExptGrpSeq());
				dmtChgCalcVO.setScRfaExptAplyDt(retChgCalcCntrVO.getScRfaExptAplyDt());
				dmtChgCalcVO.setCorrRmk("Balance Creation");
				
				dmtChgCalcVO.setOfcCd(retChgCalcCntrVO.getOfcCd());
				dmtChgCalcVO.setOfcRhqCd(retChgCalcCntrVO.getOfcRhq());		
				dmtChgCalcVO.setActCntCd(chgCalcParmVO.getActCntCd());
				dmtChgCalcVO.setActCustSeq(chgCalcParmVO.getActCustSeq());
				dmtChgCalcVO.setCustCntCd(chgCalcParmVO.getCustCntCd());
				dmtChgCalcVO.setCustSeq(chgCalcParmVO.getCustSeq());
				dmtChgCalcVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
				dmtChgCalcVO.setCmdtTrfSeq(retChgCalcCntrVO.getCmdtTrfSeq());
				dmtChgCalcVO.setCmdtExptAplyDt(retChgCalcCntrVO.getCmdtExptAplyDt());
				dmtChgCalcVO.setCmdtOvrDys(retChgCalcCntrVO.getCmdtOvrDys());
				dmtChgCalcVO.setCmdtExptAmt(retChgCalcCntrVO.getCmdtExptAmt());
				dmtChgCalcVO.setWebMtyDt(retChgCalcCntrVO.getMtDate());
				dmtChgCalcVO.setCreUsrId(account.getUsr_id());
				dmtChgCalcVO.setCreOfcCd(account.getOfc_cd());
				dmtChgCalcVO.setUpdUsrId(account.getUsr_id());
				dmtChgCalcVO.setUpdOfcCd(account.getOfc_cd());
				dmtChgCalcVO.setDulTpExptFlg(chgCalcCntrVO.getDulTpExptFlg());
				
				// insert into DMT_CHG_CALC
				dbDao.addCharge(dmtChgCalcVO);
				
				
				if(chgCalcCntrVO.getDulTpExptFlg().equals("Y")) {
					// modify ORG_CHG_AMT, SC_RFA_EXPT_AMT of Dual Exception Charge
					dbDao.modifyOrgChgAmt(chgArgVO);
				}
				
				
				DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
				dmtChgCorrHisVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCorrHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCorrHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCorrHisVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCorrHisVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCorrHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				dmtChgCorrHisVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				dmtChgCorrHisVO.setCorrHisRmk("Balance Creation");
				dmtChgCorrHisVO.setCreUsrId(account.getUsr_id());
				dmtChgCorrHisVO.setCreOfcCd(account.getOfc_cd());
				
				utilChgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
				utilChgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				utilChgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				utilChgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				utilChgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				utilChgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				int corrHisSeq = dmtCalculationUtil.checkChargeCorrection(utilChgArgVO);
				dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(++corrHisSeq));
				
				dbDao.addChargeHistory(dmtChgCorrHisVO);
				
			} // for end
			
			return resultVO;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"create balance charge"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"create balance charge"}).getMessage());
		}
	}
	
	/**
	 * when exists appiled Clock Stop Charge, create History <br>
	 * [logic]
	 * 1. delete previously created Clock Stop History (deleteClockStopHistory)
	 * 2. Insert for looping count of appiled  Clock Stop ( addClockStopHistory )
	 * 
	 * @param DmtChgTmCskStopVO dmtChgTmCskStopVO 
	 * @param List<String> cStopNoList
	 * @exception EventException
	 */
	public void modifyClockStopHistory(DmtChgTmCskStopVO dmtChgTmCskStopVO, List<String> cStopNoList) throws EventException {
		try {
			// delete previously created Clock Stop History
			dbDao.deleteClockStopHistory(dmtChgTmCskStopVO);
			
			if(cStopNoList != null && cStopNoList.size() > 0) {
				// Insert for looping count of appiled  Clock Stop
				String preClkStopNo = "";
			    for ( int i=0; i < cStopNoList.size(); i++ ) {
			     String clkStopNo = cStopNoList.get(i);
			     if(!preClkStopNo.equals(clkStopNo))
			     {
			      dmtChgTmCskStopVO.setClkStopNo(clkStopNo);
			      log.debug("111111111111111111 i  - " +i);
			      dbDao.addClockStopHistory(dmtChgTmCskStopVO);
			     }
			     preClkStopNo = clkStopNo;
			    }

			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify ClockStop History"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify ClockStop History"}).getMessage());
		}
	}
	
	
	

	/**
	 * in Request Booking<br>
	 * event of searching ChargeByCustomer<br>
	 * 
	 * @param ChargeByBookingCustomerParmVO   chargeByBookingCustomerParmVO
	 * @return ChargeByBookingCustomerGrpVO
	 * @exception EventException 
	 */
	public ChargeByBookingCustomerGrpVO searchChargeByCustomer(ChargeByBookingCustomerParmVO  chargeByBookingCustomerParmVO) throws EventException {
		ChargeByBookingCustomerGrpVO chargeByBookingCustomerGrpVO = new ChargeByBookingCustomerGrpVO();
		try {
			//[LOGIC] 
//			 after search previously created, 
//			if it's not exists - search	Basic data 
//			if it's  exists and exp_del_dt's not exists, seaarch rate divice of chg_calc_data: G/S/B
//			if it's  exists and exp_del_dt's  exists, Pre cal


			String exist = "";
			String tp_cd = "";
			String dmdt_trf_cd = "";
			
			String cntr_cyc_no = "";
			String dmdt_chg_loc_div_cd = "";
			String fm_mvmt_sts_cd = "";
			String fm_mvmt_dt = "";
			String fm_mvmt_yd_cd = "";
			String to_mvmt_sts_cd = "";
			String to_mvmt_yd_cd = "";
			String io_bnd = "";
			String cust_cnt_cd = "";
			String cust_seq = "";			
			String act_cnt_cd = "";
			String act_cust_seq = "";
			String bzc_trf_curr_cd = "";
			
			String bkg_no = chargeByBookingCustomerParmVO.getBkgNo();
			String pod_cd = chargeByBookingCustomerParmVO.getPodCd();
			String exp_del_dt = chargeByBookingCustomerParmVO.getExpDelDt();
			String[] cnstr_no = chargeByBookingCustomerParmVO.getCntrNo();
			
			if(bkg_no.equals("") || cnstr_no.equals("") || pod_cd.equals("") || cnstr_no == null || bkg_no == null || pod_cd == null){
				chargeByBookingCustomerGrpVO = new ChargeByBookingCustomerGrpVO();
				return chargeByBookingCustomerGrpVO;
			}
			
			log.info("***************************************************************************************");
			log.info("*[ searchChargeByCustomer[param] : bkg_no ] : "+bkg_no);
			log.info("*[ searchChargeByCustomer[param] : dmdt_tp ] : "+chargeByBookingCustomerParmVO.getDmdtTp());
			log.info("*[ searchChargeByCustomer[param] : exp_del_dt ] : "+exp_del_dt);
			log.info("*[ searchChargeByCustomer[param] : pod_cd ] : "+pod_cd);
			log.info("*[ searchChargeByCustomer[param] : cnstr_no ] : "+cnstr_no);
			if(chargeByBookingCustomerParmVO.getCntrNo().length > 0){
				for ( int i=0; i < chargeByBookingCustomerParmVO.getCntrNo().length; i++ ) {
					log.info("*[ searchChargeByCustomer[param] : cntr_no("+i+"): "+chargeByBookingCustomerParmVO.getCntrNo()[i]);
				}
			}
			log.info("***************************************************************************************");
			
			
			BKGChargeCalculationUtil bkgChargeCalculationUtil = null;
			List<ChargeByBookingCustomerCntrVO> chargeByBookingCustomerCntrVOS = new ArrayList<ChargeByBookingCustomerCntrVO>();
			ChargeByBookingCustomerCntrVO chargeByBookingCustomerCntrVO = null;
			ChargeByBookingCustomerCntrVO chargeByBookingCustomerCntr01 = null;
			ChargeByBookingCustomerCntrVO chargeByBookingCustomerCntr02 = null;
			
			List<ChargeByBookingCustomerInvVO> chargeByBookingCustomerInvVOS = new ArrayList<ChargeByBookingCustomerInvVO>();
			ChargeByBookingCustomerInvVO chargeByBookingCustomerInvVO = null;
			
			BookingCustomerBasicVO bookingCustomerBasicVO = null;
			for ( int i=0; i < chargeByBookingCustomerParmVO.getCntrNo().length; i++ ) {
				bkgChargeCalculationUtil = new BKGChargeCalculationUtil();
				String cntr_nos = chargeByBookingCustomerParmVO.getCntrNo()[i];				
				bookingCustomerBasicVO  = bkgChargeCalculationUtil.searchBookingCustomerBasicData(bkg_no, cntr_nos);
				
				exist = StringUtils.defaultString(bookingCustomerBasicVO.getExist());
				tp_cd = StringUtils.defaultString(bookingCustomerBasicVO.getTpCd());
				dmdt_trf_cd = StringUtils.defaultString(bookingCustomerBasicVO.getDmdtTrfCd());				
				cntr_cyc_no = StringUtils.defaultString(bookingCustomerBasicVO.getCntrCycNo());
				dmdt_chg_loc_div_cd = StringUtils.defaultString(bookingCustomerBasicVO.getDmdtChgLocDivCd());
				fm_mvmt_sts_cd = StringUtils.defaultString(bookingCustomerBasicVO.getFmMvmtStsCd());
				fm_mvmt_dt = StringUtils.defaultString(bookingCustomerBasicVO.getFmMvmtDt());
				fm_mvmt_yd_cd = StringUtils.defaultString(bookingCustomerBasicVO.getFmMvmtYdCd());
				to_mvmt_sts_cd = StringUtils.defaultString(bookingCustomerBasicVO.getToMvmtStsCd());
				to_mvmt_yd_cd = StringUtils.defaultString(bookingCustomerBasicVO.getToMvmtYdCd());
				io_bnd = StringUtils.defaultString(bookingCustomerBasicVO.getIoBnd());
				cust_cnt_cd = StringUtils.defaultString(bookingCustomerBasicVO.getCustCntCd());
				cust_seq = StringUtils.defaultString(bookingCustomerBasicVO.getCustSeq());				
				act_cnt_cd = StringUtils.defaultString(bookingCustomerBasicVO.getActCntCd());
				act_cust_seq = StringUtils.defaultString(bookingCustomerBasicVO.getActCustSeq());
				bzc_trf_curr_cd = StringUtils.defaultString(bookingCustomerBasicVO.getBzcTrfCurrCd());
				
				//3. Demurrage Type Setting - not exist, no dmdt_trf_cd. 
				// not exist  - after search info, to "X".
				chargeByBookingCustomerGrpVO.setDemurType(dmdt_trf_cd);		//('DMIF', 'CTIC')
				log.info("*****************************************************");
				log.info("[P0.Booking Customer Basic Data");
				log.info("exist:["+exist+"]");
				log.info("tp_cd:["+tp_cd+"]");
				log.info("dmdt_trf_cd:["+dmdt_trf_cd+"]");
				log.info("fm_mvmt_sts_cd:["+fm_mvmt_sts_cd+"]");
				log.info("fm_mvmt_dt:["+fm_mvmt_dt+"]");
				log.info("fm_mvmt_yd_cd:["+fm_mvmt_yd_cd+"]");
				log.info("to_mvmt_sts_cd:["+to_mvmt_sts_cd+"]");
				log.info("to_mvmt_yd_cd:["+to_mvmt_yd_cd+"]");
				log.info("io_bnd:["+io_bnd+"]");
				log.info("cust_cnt_cd:["+cust_cnt_cd+"]");
				log.info("cust_seq:["+cust_seq+"]");
				log.info("act_cnt_cd:["+act_cnt_cd+"]");
				log.info("[act_cust_seq:["+act_cust_seq+"]");
				log.info("*****************************************************");
				
				//	after search info, to "X".
				if(exist.equals("")){
					log.info("*****************************************************");
					log.info("P1. Basic data == '' ");
					log.info("[bkg_no]"+bkg_no);
					log.info("[cntr_nos]"+cntr_nos);
					log.info("[pod_cd]"+pod_cd);
					log.info("*****************************************************");
					chargeByBookingCustomerCntrVO = new ChargeByBookingCustomerCntrVO();
					chargeByBookingCustomerInvVO = new ChargeByBookingCustomerInvVO();
					
					//1. return  CONTAINER info.
					chargeByBookingCustomerCntrVO = bkgChargeCalculationUtil.searchBookingCustomerCntrPartialInfo(bkg_no, cntr_nos, pod_cd, "G");
					if(chargeByBookingCustomerCntrVO.getMsgCd().equals("0")){
						chargeByBookingCustomerCntrVOS.add(chargeByBookingCustomerCntrVO);
					} else {
						log.info("P1. searchBookingCustomerCntrPartialInfo : return -1");
					}
					
					//2. no data : INVOICE info. by CNTR_NO

					
					//3.if there is no data Demurrage Type Setting DMT_CHG_CALC , setting DMDT_TRF_CD.
					chargeByBookingCustomerGrpVO.setDemurType(chargeByBookingCustomerCntrVO.getDmdtTrfCd());
					
				} 
				// after search info, data exist.
				else {
					// not exp_del_dt 
					if(exp_del_dt.equals("") || exp_del_dt == null){
						log.info("*****************************************************");
						log.info("P2. Basic data != '' && exp_del_dt param data == '' ");
						log.info("[bkg_no]"+bkg_no);
						log.info("[cntr_nos]"+cntr_nos);
						log.info("[pod_cd]"+pod_cd);
						log.info("[tp_cd]"+tp_cd);
						log.info("*****************************************************");
						chargeByBookingCustomerCntrVO = new ChargeByBookingCustomerCntrVO();
						chargeByBookingCustomerCntr01 = new ChargeByBookingCustomerCntrVO();
						chargeByBookingCustomerCntr02 = new ChargeByBookingCustomerCntrVO();
						chargeByBookingCustomerInvVO = new ChargeByBookingCustomerInvVO();
						
						//1. return  CONTAINER info.
						chargeByBookingCustomerCntr01 = bkgChargeCalculationUtil.searchBookingCustomerCntrPartialInfo(bkg_no, cntr_nos, pod_cd, tp_cd);
						if(chargeByBookingCustomerCntr01.getMsgCd().equals("0")){
							chargeByBookingCustomerCntrVO.setFtDys(StringUtils.defaultString(chargeByBookingCustomerCntr01.getFtDys()));
							chargeByBookingCustomerCntrVO.setXcldSatFlg(StringUtils.defaultString(chargeByBookingCustomerCntr01.getXcldSatFlg()));
							chargeByBookingCustomerCntrVO.setXcldSunFlg(StringUtils.defaultString(chargeByBookingCustomerCntr01.getXcldSunFlg()));
							chargeByBookingCustomerCntrVO.setXcldHolFlg(StringUtils.defaultString(chargeByBookingCustomerCntr01.getXcldHolFlg()));
							chargeByBookingCustomerCntrVO.setCurrCd(StringUtils.defaultString(chargeByBookingCustomerCntr01.getCurrCd()));
							chargeByBookingCustomerCntrVO.setCntrRtAmt(StringUtils.defaultString(chargeByBookingCustomerCntr01.getCntrRtAmt()));
						} else {
							log.info("P2. searchBookingCustomerCntrPartialInfo : return -1");
						}
						
						
						chargeByBookingCustomerCntr02 = bkgChargeCalculationUtil.searchBookingCustomerCntr(bkg_no, cntr_nos);
						if(chargeByBookingCustomerCntr02.getMsgCd().equals("0")){
							chargeByBookingCustomerCntrVO.setFxFtOvrDys(StringUtils.defaultString(chargeByBookingCustomerCntr02.getFxFtOvrDys()));
							chargeByBookingCustomerCntrVO.setBzcTrfCurrCd(StringUtils.defaultString(chargeByBookingCustomerCntr02.getBzcTrfCurrCd()));  //charge data
							chargeByBookingCustomerCntrVO.setBilAmt(StringUtils.defaultString(chargeByBookingCustomerCntr02.getBilAmt()));
//							chargeByBookingCustomerCntrVO.setFtDys(StringUtils.defaultString(chargeByBookingCustomerCntr02.getFtDys()));
							chargeByBookingCustomerCntrVO.setFtDysCalc(StringUtils.defaultString(chargeByBookingCustomerCntr02.getFtDys())); //수정
							chargeByBookingCustomerCntrVO.setFtEndDt(StringUtils.defaultString(chargeByBookingCustomerCntr02.getFtEndDt()));
						} else {
							log.info("P2. searchBookingCustomerCntr : return -1");
						}
						
						// return case in normaly result for chargeByBookingCustomerCntr01 or chargeByBookingCustomerCntr02 .
						if(chargeByBookingCustomerCntr01.getMsgCd().equals("0") || chargeByBookingCustomerCntr02.getMsgCd().equals("0")){
							chargeByBookingCustomerCntrVO.setBkgNo(bkg_no);
							chargeByBookingCustomerCntrVO.setCntrNo(cntr_nos);
							//chargeByBookingCustomerCntrVO.setExpDelDt(StringUtils.defaultString(exp_del_dt));
							chargeByBookingCustomerCntrVO.setExpDelDt("");
							chargeByBookingCustomerCntrVO.setPodCd(StringUtils.defaultString(pod_cd));
							chargeByBookingCustomerCntrVOS.add(chargeByBookingCustomerCntrVO);
						} else {
							log.info("P2. chargeByBookingCustomerCntrVOS : return -1");
						}
						
						
						//2.Return INVOICE info. by CNTR_NO
						List<ChargeByBookingCustomerInvVO> listInvVO = bkgChargeCalculationUtil.searchChargeByBookingCustomerInvList(bkg_no, cntr_nos);
						
						if(listInvVO.size() > 0){
							for(int ii=0; ii < listInvVO.size(); ii++){
								chargeByBookingCustomerInvVO = new ChargeByBookingCustomerInvVO();
								ChargeByBookingCustomerInvVO invVOS = listInvVO.get(ii);
								chargeByBookingCustomerInvVO.setBkgNo(bkg_no);
								chargeByBookingCustomerInvVO.setCntrNo(cntr_nos);
								//chargeByBookingCustomerInvVO.setExpDelDt(StringUtils.defaultString(exp_del_dt));
								chargeByBookingCustomerInvVO.setExpDelDt("");
								chargeByBookingCustomerInvVO.setPodCd(StringUtils.defaultString(pod_cd));
								chargeByBookingCustomerInvVO.setDmdtInvStsCd(StringUtils.defaultString(invVOS.getDmdtInvStsCd()));
								chargeByBookingCustomerInvVO.setDmdtArIfCd(StringUtils.defaultString(invVOS.getDmdtArIfCd()));
								chargeByBookingCustomerInvVO.setFtEndDt(StringUtils.defaultString(invVOS.getFtEndDt())); //20100115 => DMT_CHG_CALC:FM_MVMT_DT 사용
								chargeByBookingCustomerInvVO.setToMvmtDt(StringUtils.defaultString(invVOS.getToMvmtDt()));
								chargeByBookingCustomerInvVO.setInvCurrCd(StringUtils.defaultString(invVOS.getInvCurrCd()));
								chargeByBookingCustomerInvVO.setInvChgAmt(StringUtils.defaultString(invVOS.getInvChgAmt()));
								chargeByBookingCustomerInvVO.setBilAmt(StringUtils.defaultString(invVOS.getBilAmt()));
								
								chargeByBookingCustomerInvVOS.add(chargeByBookingCustomerInvVO);
							}
						}
					} 
					//exists exp_del_dt
					else {
						log.info("*****************************************************");
						log.info("P3. Basic data != '' && exp_del_dt param data != '' ");
						log.info("[bkg_no]"+bkg_no);
						log.info("[cntr_nos]"+cntr_nos);
						log.info("[pod_cd]"+pod_cd);
						log.info("[tp_cd]"+tp_cd);
						log.info("*****************************************************");
						chargeByBookingCustomerCntrVO = new ChargeByBookingCustomerCntrVO();
						chargeByBookingCustomerCntr01 = new ChargeByBookingCustomerCntrVO();
						chargeByBookingCustomerCntr02 = new ChargeByBookingCustomerCntrVO();
						chargeByBookingCustomerInvVO = new ChargeByBookingCustomerInvVO();
						
						//1. Return CONTAINER info.
						
						chargeByBookingCustomerCntr01 = bkgChargeCalculationUtil.searchBookingCustomerCntrPartialInfo(bkg_no, cntr_nos, pod_cd, tp_cd);
						if(chargeByBookingCustomerCntr01.getMsgCd().equals("0")){
							chargeByBookingCustomerCntrVO.setFtDys(StringUtils.defaultString(chargeByBookingCustomerCntr01.getFtDys()));
							chargeByBookingCustomerCntrVO.setXcldSatFlg(StringUtils.defaultString(chargeByBookingCustomerCntr01.getXcldSatFlg()));
							chargeByBookingCustomerCntrVO.setXcldSunFlg(StringUtils.defaultString(chargeByBookingCustomerCntr01.getXcldSunFlg()));
							chargeByBookingCustomerCntrVO.setXcldHolFlg(StringUtils.defaultString(chargeByBookingCustomerCntr01.getXcldHolFlg()));
							chargeByBookingCustomerCntrVO.setCurrCd(StringUtils.defaultString(chargeByBookingCustomerCntr01.getCurrCd()));
							chargeByBookingCustomerCntrVO.setCntrRtAmt(StringUtils.defaultString(chargeByBookingCustomerCntr01.getCntrRtAmt()));
						} else {
							log.info("P3. searchBookingCustomerCntrPartialInfo : return -1");
						}
						
						ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
						chargeCalculationParmVO.setCntrNo(cntr_nos);			//param value
						chargeCalculationParmVO.setCntrCycNo(cntr_cyc_no);		//charge data
						chargeCalculationParmVO.setBkgNo(bkg_no);				//param value
						chargeCalculationParmVO.setFmMvmtDt(fm_mvmt_dt);		//charge data
						chargeCalculationParmVO.setFmMvmtYdCd(fm_mvmt_yd_cd);	//charge data
						chargeCalculationParmVO.setFmMvmtStsCd(fm_mvmt_sts_cd); //charge data
						chargeCalculationParmVO.setToMvmtDt(exp_del_dt);		//param value
						chargeCalculationParmVO.setToMvmtYdCd(to_mvmt_yd_cd);	//charge data
						chargeCalculationParmVO.setToMvmtStsCd(to_mvmt_sts_cd);	//charge data
						chargeCalculationParmVO.setDmdtTrfCd(dmdt_trf_cd);		//charge data						
						chargeCalculationParmVO.setIoBndCd(io_bnd);				//charge data
						chargeCalculationParmVO.setCustCntCd(cust_cnt_cd);		//charge data
						chargeCalculationParmVO.setCustSeq(cust_seq);			//charge data
						chargeCalculationParmVO.setActCntCd(act_cnt_cd);		//charge data
						chargeCalculationParmVO.setActCustSeq(act_cust_seq);	//charge data
						chargeCalculationParmVO.setDmdtChgLocDivCd(dmdt_chg_loc_div_cd); //charge data
						
						chargeByBookingCustomerCntr02 = bkgChargeCalculationUtil.preChargeCalculation(chargeCalculationParmVO);
						if(chargeByBookingCustomerCntr02.getMsgCd().equals("0")){
							chargeByBookingCustomerCntrVO.setFxFtOvrDys(StringUtils.defaultString(chargeByBookingCustomerCntr02.getFxFtOvrDys()));
							chargeByBookingCustomerCntrVO.setBzcTrfCurrCd(StringUtils.defaultString(bzc_trf_curr_cd)); //charge data
							chargeByBookingCustomerCntrVO.setBilAmt(StringUtils.defaultString(chargeByBookingCustomerCntr02.getBilAmt()));
							chargeByBookingCustomerCntrVO.setFtDysCalc(StringUtils.defaultString(chargeByBookingCustomerCntr02.getFtDys())); //수정
							chargeByBookingCustomerCntrVO.setFtEndDt(DMTCalculationUtil.nullToString(chargeByBookingCustomerCntr02.getFtEndDt(), 8));
						}
						
						// return case in normaly result for chargeByBookingCustomerCntr01 or chargeByBookingCustomerCntr02 .
						if(chargeByBookingCustomerCntr01.getMsgCd().equals("0") || chargeByBookingCustomerCntr02.getMsgCd().equals("0")){
							chargeByBookingCustomerCntrVO.setBkgNo(bkg_no);
							chargeByBookingCustomerCntrVO.setCntrNo(cntr_nos);
							chargeByBookingCustomerCntrVO.setExpDelDt(StringUtils.defaultString(exp_del_dt));
							chargeByBookingCustomerCntrVO.setPodCd(StringUtils.defaultString(pod_cd));
							chargeByBookingCustomerCntrVOS.add(chargeByBookingCustomerCntrVO);
						} else {
							log.info("P3. chargeByBookingCustomerCntrVOS : return -1");
						}
						
						
						//2. Return INVOICE info. by CNTR_NO
						List<ChargeByBookingCustomerInvVO> listInvVO = bkgChargeCalculationUtil.searchChargeByBookingCustomerInvList(bkg_no, cntr_nos);
						
						if(listInvVO.size() > 0){
							for(int ii=0; ii < listInvVO.size(); ii++){
								chargeByBookingCustomerInvVO = new ChargeByBookingCustomerInvVO();
								ChargeByBookingCustomerInvVO invVOS = listInvVO.get(ii);
								chargeByBookingCustomerInvVO.setBkgNo(bkg_no);
								chargeByBookingCustomerInvVO.setCntrNo(cntr_nos);
								chargeByBookingCustomerInvVO.setExpDelDt(StringUtils.defaultString(exp_del_dt));
								chargeByBookingCustomerInvVO.setPodCd(StringUtils.defaultString(pod_cd));
								chargeByBookingCustomerInvVO.setDmdtInvStsCd(StringUtils.defaultString(invVOS.getDmdtInvStsCd()));
								chargeByBookingCustomerInvVO.setDmdtArIfCd(StringUtils.defaultString(invVOS.getDmdtArIfCd()));
								chargeByBookingCustomerInvVO.setFtEndDt(StringUtils.defaultString(invVOS.getFtEndDt())); //20100115 => DMT_CHG_CALC:FM_MVMT_DT 사용 
								chargeByBookingCustomerInvVO.setToMvmtDt(StringUtils.defaultString(invVOS.getToMvmtDt()));
								chargeByBookingCustomerInvVO.setInvCurrCd(StringUtils.defaultString(invVOS.getInvCurrCd()));
								chargeByBookingCustomerInvVO.setInvChgAmt(StringUtils.defaultString(invVOS.getInvChgAmt()));
								chargeByBookingCustomerInvVO.setBilAmt(StringUtils.defaultString(invVOS.getBilAmt()));
								chargeByBookingCustomerInvVOS.add(chargeByBookingCustomerInvVO);
							}
						}
					}
				}
			}
			//1. Return CONTAINER info.
			chargeByBookingCustomerGrpVO.setChargeByBookingCustomerCntrVOS(chargeByBookingCustomerCntrVOS);
			//2. Return INVOICE info. by CNTR_NO
			chargeByBookingCustomerGrpVO.setChargeByBookingCustomerInvVOS(chargeByBookingCustomerInvVOS);
			
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge By Customer"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge By Customer"}).getMessage());
		}
		
		log.info("[1.getChargeByBookingCustomerCntrVOS()]");
		if(chargeByBookingCustomerGrpVO.getChargeByBookingCustomerCntrVOS() != null){
			if(chargeByBookingCustomerGrpVO.getChargeByBookingCustomerCntrVOS().size() > 0 ){
				for(int i = 0; i < chargeByBookingCustomerGrpVO.getChargeByBookingCustomerCntrVOS().size(); i++){
					ChargeByBookingCustomerCntrVO logCntrVO = chargeByBookingCustomerGrpVO.getChargeByBookingCustomerCntrVOS().get(i);
					
					log.info("["+chargeByBookingCustomerGrpVO.getChargeByBookingCustomerCntrVOS().size()+"] : "+i);
					log.info("[ChargeByBookingCustomerCntrVO:getBkgNo]"+logCntrVO.getBkgNo());
					log.info("[ChargeByBookingCustomerCntrVO:getCntrNo]"+logCntrVO.getCntrNo());
					log.info("[ChargeByBookingCustomerCntrVO:getExpDelDt]"+logCntrVO.getExpDelDt());
					log.info("[ChargeByBookingCustomerCntrVO:getPodCd]"+logCntrVO.getPodCd());
					log.info("[ChargeByBookingCustomerCntrVO:getFxFtOvrDys]"+logCntrVO.getFxFtOvrDys());
					log.info("[ChargeByBookingCustomerCntrVO:getBzcTrfCurrCd]"+logCntrVO.getBzcTrfCurrCd());
					log.info("[ChargeByBookingCustomerCntrVO:getBilAmt]"+logCntrVO.getBilAmt());
					log.info("[ChargeByBookingCustomerCntrVO:getFtEndDt]"+logCntrVO.getFtEndDt());
					log.info("[ChargeByBookingCustomerCntrVO:getFtDys]"+logCntrVO.getFtDys());
					log.info("[ChargeByBookingCustomerCntrVO:getFtDysCalc]"+logCntrVO.getFtDysCalc());
					log.info("[ChargeByBookingCustomerCntrVO:getXcldSatFlg]"+logCntrVO.getXcldSatFlg());
					log.info("[ChargeByBookingCustomerCntrVO:getXcldSunFlg]"+logCntrVO.getXcldSunFlg());
					log.info("[ChargeByBookingCustomerCntrVO:getXcldHolFlg]"+logCntrVO.getXcldHolFlg());
					log.info("[ChargeByBookingCustomerCntrVO:getCurrCd]"+logCntrVO.getCurrCd());
					log.info("[ChargeByBookingCustomerCntrVO:getCntrRtAmt]"+logCntrVO.getCntrRtAmt());
				}
			}
		}
		log.info("[2.getChargeByBookingCustomerInvVOS()]");
		if(chargeByBookingCustomerGrpVO.getChargeByBookingCustomerInvVOS() != null){
			if(chargeByBookingCustomerGrpVO.getChargeByBookingCustomerInvVOS() != null || chargeByBookingCustomerGrpVO.getChargeByBookingCustomerInvVOS().size() > 0 ){
				for(int i = 0; i < chargeByBookingCustomerGrpVO.getChargeByBookingCustomerInvVOS().size(); i++){
					ChargeByBookingCustomerInvVO logInvVOS = chargeByBookingCustomerGrpVO.getChargeByBookingCustomerInvVOS().get(i);
					log.info("["+chargeByBookingCustomerGrpVO.getChargeByBookingCustomerInvVOS().size()+"] : "+i);
					log.info("[getChargeByBookingCustomerInvVOS:getBkgNo]"+logInvVOS.getBkgNo());
					log.info("[getChargeByBookingCustomerInvVOS:getCntrNo]"+logInvVOS.getCntrNo());
					log.info("[getChargeByBookingCustomerInvVOS:getExpDelDt]"+logInvVOS.getExpDelDt());
					log.info("[getChargeByBookingCustomerInvVOS:getPodCd]"+logInvVOS.getPodCd());
					log.info("[getChargeByBookingCustomerInvVOS:getDmdtInvStsCd]"+logInvVOS.getDmdtInvStsCd());
					log.info("[getChargeByBookingCustomerInvVOS:getDmdtArIfCd]"+logInvVOS.getDmdtArIfCd());
					log.info("[getChargeByBookingCustomerInvVOS:getFtEndDt]"+logInvVOS.getFtEndDt());
					log.info("[getChargeByBookingCustomerInvVOS:getToMvmtDt]"+logInvVOS.getToMvmtDt());
					log.info("[getChargeByBookingCustomerInvVOS:getInvCurrCd]"+logInvVOS.getInvCurrCd());
					log.info("[getChargeByBookingCustomerInvVOS:getInvChgAmt]"+logInvVOS.getInvChgAmt());
					log.info("[getChargeByBookingCustomerInvVOS:getBilAmt]"+logInvVOS.getBilAmt());
				}
			}
		}
		log.info("[3.getDemurType]:"+chargeByBookingCustomerGrpVO.getDemurType());
		
		return chargeByBookingCustomerGrpVO;

	}
	
	
	/**
	 * search Charge List by Office or VVD<br>
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchChargeStatusListByOfficeOrVVD(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) 
		throws EventException {
		try {
			return dbDao.searchChargeListByStatus(chargeByOfficeOrVVDVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge Status List By Office Or VVD"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge Status List By Office Or VVD"}).getMessage());
		}
	}
	
	
	/**
	 *  when OfficeTransfer, if it is same RHQ Office then modify Charge info.(DMT_CHG_CALC, DMT_CHG_BKG_CNTR). 
	 * 
	 * @param OfficeTransferParmVO[] officeTransferParmVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String modifyChargeByOfficeTransfer(OfficeTransferParmVO[] officeTransferParmVOs, SignOnUserAccount account) throws EventException {
		try {
			String toOfcCd = officeTransferParmVOs[0].getToOfcCd();
			String fmSvrId = officeTransferParmVOs[0].getSvrId();
			//fmOfcCd
			String fmOfcCd = officeTransferParmVOs[0].getFmOfcCd();
			
			String toSvrId = dbDao.searchRhqGrpId(toOfcCd);
			
			boolean checkOfficeTransfer = false;
			
			if(fmSvrId.equals(toSvrId)) {
				for ( int i=0; i<officeTransferParmVOs.length; i++ ) {
					officeTransferParmVOs[i].setToOfcCd(toOfcCd);
					//fmOfcCd
					officeTransferParmVOs[i].setFmOfcCd(fmOfcCd);
					
					// Checking exist FROM OFFICE , if it's not exists, do error process(DMT01081)
					checkOfficeTransfer = dbDao.checkMultiChargeByOfficeTransfer(officeTransferParmVOs[i]);
					
					if(checkOfficeTransfer) {
						dbDao.modifyBookingContainerByOfficeTransfer(officeTransferParmVOs[i]);
						dbDao.modifyChargeByOfficeTransfer(officeTransferParmVOs[i], account);
					}else{
						return "DMT01081";
					}
				}
			} else {
				OfficeTransferParmByChargeVO ofcTrnsParmByChargeVO = new OfficeTransferParmByChargeVO();
				ofcTrnsParmByChargeVO.setFmSvrId(fmSvrId);
				ofcTrnsParmByChargeVO.setToSvrId(toSvrId);
				ofcTrnsParmByChargeVO.setToOfcCd(toOfcCd);
				
				OfficeTransferParmVO ofcTrnsParmVO = null;
				ChargeArgumentVO chargeVO = null;
				for ( int i=0; i<officeTransferParmVOs.length; i++ ) {
					ofcTrnsParmVO = officeTransferParmVOs[i];
					ofcTrnsParmVO.setToOfcCd(toOfcCd);
					ofcTrnsParmVO.setFmOfcCd(fmOfcCd);	//fmOfcCd
				
					ofcTrnsParmByChargeVO.setCntrNo(ofcTrnsParmVO.getCntrNo());
					ofcTrnsParmByChargeVO.setCntrCycNo(ofcTrnsParmVO.getCntrCycNo());
					ofcTrnsParmByChargeVO.setDmdtTrfCd(ofcTrnsParmVO.getDmdtTrfCd());
					ofcTrnsParmByChargeVO.setDmdtChgLocDivCd(ofcTrnsParmVO.getDmdtChgLocDivCd());
					ofcTrnsParmByChargeVO.setChgSeq(ofcTrnsParmVO.getChgSeq());
					
					//Checking exist FROM OFFICE , if it's not exists, do error process(DMT01081)
					checkOfficeTransfer = dbDao.checkMultiChargeByOfficeTransfer(ofcTrnsParmVO);

					if(checkOfficeTransfer) {
						chargeVO = new ChargeArgumentVO();                                                                                                                                                       
						chargeVO.setSvrId(dbDao.searchRhqGrpId(ofcTrnsParmByChargeVO.getToOfcCd()));                                                                                                             
						chargeVO.setCntrNo(ofcTrnsParmByChargeVO.getCntrNo());                                                                                                                                   
						chargeVO.setCntrCycNo(ofcTrnsParmByChargeVO.getCntrCycNo());                                                                                                                             
						                                                                                                                                                                                         
						if(!dbDao.checkChargeBookingContainerExists(chargeVO)){                                                                                                                                  
						// continue   though dupliocation error.                                                                                                                  
						//if there is no Charge Booking CNTR , create data.                                                                                                              
							dbDao.addBookingContainerByOfficeTransfer(ofcTrnsParmByChargeVO);                                                                                                                    
						} 						
						// backup origin Charge info. before OT.
						dbDao.addChargeBackupByOfficeTransfer(ofcTrnsParmByChargeVO);
						
						// modify origin Charge data(DMT_CHG_CALC) to the tune of OT(SYS_AREA_GRP_ID, OFC_CD, OFC_RHQ_CD 등)
						dbDao.modifyChargeByOfficeTransfer(ofcTrnsParmVO, account);
						
						// check exists more another charge and OT Charge.
						String isExist = dbDao.checkChargeByOfficeTransfer(ofcTrnsParmVO);
						
						// if there is no charge relative OT, delete Charge Booking Container , after backup.
						if(isExist.equals("N")) {
							dbDao.addBookingContainerBackupByOfficeTransfer(ofcTrnsParmByChargeVO);
							dbDao.deleteBookingContainerByOfficeTransfer(ofcTrnsParmVO);
						}
					}else{
						return "DMT01081";
					}
				}
			}
		
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"Office Transfer Charge"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"Office Transfer Charge"}).getMessage());
		}
		return "";
	}
	
	
	/**
	 *  when OfficeTransfer, if it is same RHQ Office then create Charge info.(DMT_CHG_CALC, DMT_CHG_BKG_CNTR) 
	 * 
	 * @param OfficeTransferParmVO[] officeTransferParmVOs 
	 * @exception EventException
	 */
	public void createChargeByOfficeTransfer(OfficeTransferParmVO[] officeTransferParmVOs) throws EventException {
		try {
			OfficeTransferParmByChargeVO ofcTrnsParmByChargeVO = new OfficeTransferParmByChargeVO();
			ofcTrnsParmByChargeVO.setFmSvrId(officeTransferParmVOs[0].getSvrId());
			ofcTrnsParmByChargeVO.setToSvrId(officeTransferParmVOs[0].getToSvrId());
			ofcTrnsParmByChargeVO.setToOfcCd(officeTransferParmVOs[0].getToOfcCd());
			
			OfficeTransferParmVO ofcTrnsParmVO = null;
			ChargeArgumentVO chargeVO = null;
			
			for ( int i=0; i<officeTransferParmVOs.length; i++ ) {
				ofcTrnsParmVO = officeTransferParmVOs[i];
				
				ofcTrnsParmByChargeVO.setCntrNo(ofcTrnsParmVO.getCntrNo());
				ofcTrnsParmByChargeVO.setCntrCycNo(ofcTrnsParmVO.getCntrCycNo());
				ofcTrnsParmByChargeVO.setDmdtTrfCd(ofcTrnsParmVO.getDmdtTrfCd());
				ofcTrnsParmByChargeVO.setDmdtChgLocDivCd(ofcTrnsParmVO.getDmdtChgLocDivCd());
				ofcTrnsParmByChargeVO.setChgSeq(ofcTrnsParmVO.getChgSeq());
				
				dbDao.addBookingContainerBackupByOfficeTransfer(ofcTrnsParmByChargeVO);
				dbDao.addChargeBackupByOfficeTransfer(ofcTrnsParmByChargeVO);
				
				chargeVO = new ChargeArgumentVO();                                                                                                                                                               
				chargeVO.setSvrId(dbDao.searchRhqGrpId(ofcTrnsParmByChargeVO.getToOfcCd()));                                                                                                                     
				chargeVO.setCntrNo(ofcTrnsParmByChargeVO.getCntrNo());                                                                                                                                           
				chargeVO.setCntrCycNo(ofcTrnsParmByChargeVO.getCntrCycNo());                                                                                                                                     
				                                                                                                                                                                                                 
				if(!dbDao.checkChargeBookingContainerExists(chargeVO)){                                                                                                                                          
					// continue   though dupliocation error.                                                                                                                          
					// if there is no Charge Booking CNTR , create data.                                                                                                                        
					dbDao.addBookingContainerByOfficeTransfer(ofcTrnsParmByChargeVO);                                                                                                                            
				} 
				
				// case in dupliocation error, Insert data after Delete data
				// data Transfer from Other area Office to created Office , delete origin Data
				int result = dbDao.addChargeByOfficeTransfer(ofcTrnsParmByChargeVO);
				if(result == -1) {// duplicaion
					// delete origin data
					dbDao.deleteChargeByOfficeTransfer(ofcTrnsParmVO);
					result = dbDao.addChargeByOfficeTransfer(ofcTrnsParmByChargeVO);
				}
				
				dbDao.modifyChargeTransferStatusByOfficeTransfer(ofcTrnsParmByChargeVO);
				
				//check exists more another charge and OT Charge.
				String isExist = dbDao.checkChargeByOfficeTransfer(ofcTrnsParmVO);
				
				// if there is no charge relative OT, delete Charge Booking Container 
				if(isExist.equals("N")) {
					dbDao.deleteBookingContainerByOfficeTransfer(ofcTrnsParmVO);
				}
			}
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"Office Transfer Charge"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"Office Transfer Charge"}).getMessage());
		}
	}
	
	
	/**
	 *  search  History by calculated Charge<br>
	 * 
	 * @param ChargeArgumentVO  chargeArgumentVO
	 * @return List<DmtChgCorrHisVO>
	 * @exception EventException
	 */
	public List<DmtChgCorrHisVO> searchCorrectionHistory(ChargeArgumentVO chargeArgumentVO) throws EventException {
		try {
			return dbDao.searchCorrectionHistory(chargeArgumentVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Correction History"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Correction History"}).getMessage());
		}
	}

	/**
	 *  search Partial Charge<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchPartialPayment(ChargeArgumentVO chargeArgumentVO) throws EventException {

		try {
			return dbDao.searchPartialPayment(chargeArgumentVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"PartialPayment"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"PartialPayment"}).getMessage());
		}
	}
	
	
	/**
	 * when Charge Delete, search list of Delete Reason Data<br>
	 * search Delete Reason Code and  Description in common table<br>
	 * 
	 * @return List<DeleteReasonListVO>
	 */
	public List<DeleteReasonListVO> searchDeleteReasonList() throws EventException {
		
		try {
			return dbDao.searchDeleteReasonList();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		}
	}
	
	
	/**
	 * Delete Charge when the clerk in charge of DEM/DET Billing  settle DEM/DET Charge,
	 * it's not customer' fault or need Manual Invoice.
	 * 
	 * - previously condition : not invoiced Status
	 * - after condition: Charge Status change "D"
	 * - logic
	 *	1. process a lot of Charges.
	 *	2. if Charge Status is 'I'(Invoice) showing message [DMT01002] and stop calculateion
	 *	3. Insert Correction History
	 *	4. Charge Status change "D"
	 *	5. Insert Correction History about changed Charge
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String removeCharge(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
		throws EventException {
		
		try {
			String result = "";
			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = null;
			chargeArgumentVO = new com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
			
			ChargeCalculationContainerVO chgCalcCntrVO  = chargeCalculationContainerVOs[0];
			String dmdtChgDeltRsnCd = chgCalcCntrVO.getDmdtChgDeltRsnCd();
			String corrRmk = chgCalcCntrVO.getCorrRmk();
			
			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
				chgCalcCntrVO = chargeCalculationContainerVOs[i];
				
				//Check Duplication
				com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO checkArgument 
					= new com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO();
				checkArgument.setSvrId(chgCalcCntrVO.getSvrId());
				checkArgument.setCntrNo(chgCalcCntrVO.getCntrNo());
				checkArgument.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				checkArgument.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				checkArgument.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				checkArgument.setChgSeq(chgCalcCntrVO.getChgSeq());
				checkArgument.setStsCd("DELETE");

				boolean isExist = dbDao.checkChargeByConfirmDeleteDeleteCancel(checkArgument);
				
				if(!isExist)
					return "DMT01081";
				
				ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
				chgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				String chgMaxSeq = dbDao.searchChargeMaxSequence(chgArgVO);
				
				if(!chgCalcCntrVO.getChgSeq().equals(chgMaxSeq)) {
					return "DMT01030"; //"There is a balance charge !"
				}
				
				ChargeStatusNRemarkVO chargeStatusNRemarkVO = dbDao.searchChargeStatusNRemark(chgArgVO);
				if(chargeStatusNRemarkVO == null) {
					return "DMT03009";
				}
				
				if(chargeStatusNRemarkVO.getDmdtChgStsCd().equals("I")) {
					return "DMT01026";
				}
				
				
				chgCalcCntrVO.setCorrRmk(corrRmk);
				chgCalcCntrVO.setDmdtChgDeltRsnCd(dmdtChgDeltRsnCd);
				chgCalcCntrVO.setUsrId(account.getUsr_id());
				chgCalcCntrVO.setOfcCd(account.getOfc_cd());
				
				chargeArgumentVO.setSvrId(chgCalcCntrVO.getSvrId());
				chargeArgumentVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chargeArgumentVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chargeArgumentVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chargeArgumentVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chargeArgumentVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				
				int corrHisSeq = dmtCalculationUtil.checkChargeCorrection(chargeArgumentVO);
				
				DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
				dmtChgCorrHisVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCorrHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCorrHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCorrHisVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCorrHisVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCorrHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				dmtChgCorrHisVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				dmtChgCorrHisVO.setCorrHisRmk(chgCalcCntrVO.getCorrRmk());
				dmtChgCorrHisVO.setCreUsrId(account.getUsr_id());
				dmtChgCorrHisVO.setCreOfcCd(account.getOfc_cd());
				
				if(corrHisSeq == 0) {
					corrHisSeq++;
					dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
					dbDao.addChargeHistory(dmtChgCorrHisVO);
				}
				
				dbDao.modifyDeleteCharge(chgCalcCntrVO);
				
				corrHisSeq++;
				dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
				dbDao.addChargeHistory(dmtChgCorrHisVO);
			
			} // for end
			
			return result;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00004", new String[]{"charge"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00004", new String[]{"charge"}).getMessage());
		}
	}
	
	
	
	
	/**
	 * Partial Charge<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO createPartialPayment(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
				throws EventException {
		try {
			DmtResultVO resultVO = new DmtResultVO();
			
			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			DMTGeneralChargeCalculationUtil	dmtGeneralChargeCalculationUtil 	= new DMTGeneralChargeCalculationUtil();
			DMTBalanceChargeCalculationUtil dmtBalanceChargeCalculationUtil 	= new DMTBalanceChargeCalculationUtil();
			DMTCancelChargeCalculationUtil	dmtCancelChargeCalculationUtil		= new DMTCancelChargeCalculationUtil();
			DMTCombinedChargeCalculationUtil dmtCombinedChargeCalculationUtil	= new DMTCombinedChargeCalculationUtil();
			
			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO utilChgArgVO = null;
			utilChgArgVO = new com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
			
			// get infomation grom first ChargeCalculationContainerVO .
			ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs[0];
			
			ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
			chgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
			chgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
			chgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
			chgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
			chgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
			chgArgVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
			chgArgVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
			
			// when Partial Payment , delete  General and  Balance charge
			dbDao.deleteChargeByPartial(chgArgVO);
			
			
			// if exists other area created Charge, search Charge Seq List.
			List<String> othSvrChgSeqList = dbDao.searchOthSvrChgSeqByPartial(chgArgVO);
			
			int chgSeq = 0;
			
			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
				chgCalcCntrVO = chargeCalculationContainerVOs[i];
				
				//calculate days of FromDate and ToDate one by one, if below ine day , show message(DMT01028 )and stop process
				int days = dbDao.checkFromToDate(chgCalcCntrVO.getFmMvmtDt(), chgCalcCntrVO.getToMvmtDt(), account.getOfc_cd());
				if(days < 1) {
					resultVO.setResultCode("DMT01028");
					return resultVO;
				}
				
				// setting charge seq
				if(i == 0) {
					chgSeq = NumberUtils.toInt(chgCalcCntrVO.getChgSeq(), 1);
				} else {
					if(othSvrChgSeqList.size() > 0) {
						boolean chkFlag = false;
						
						do {
							chkFlag = false;
							for(int j=0; j < othSvrChgSeqList.size(); j++) {
								if(chgSeq == NumberUtils.toInt(othSvrChgSeqList.get(j))) {
									++chgSeq;
									chkFlag = true;
									break;
								}
							}
						} while(chkFlag);
					}
					
					chgCalcCntrVO.setChgSeq(String.valueOf(chgSeq));
				}
				
				++chgSeq;
				
				
				// ************* DmtChgCalcVO  *****************
				DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
				dmtChgCalcVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCalcVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCalcVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCalcVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCalcVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCalcVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				dmtChgCalcVO.setFmMvmtStsCd(chgCalcCntrVO.getFmMvmtStsCd());
				dmtChgCalcVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				dmtChgCalcVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				dmtChgCalcVO.setToMvmtStsCd(chgCalcCntrVO.getToMvmtStsCd());
				dmtChgCalcVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				dmtChgCalcVO.setToMvmtYdCd(chgCalcCntrVO.getToMvmtYdCd());
				dmtChgCalcVO.setNotCreBalFlg("N");
				dmtChgCalcVO.setFtDys(chgCalcCntrVO.getFtDys());
				dmtChgCalcVO.setFtCmncDt(chgCalcCntrVO.getFtCmncDt());
				dmtChgCalcVO.setFtEndDt(chgCalcCntrVO.getFtEndDt());
				dmtChgCalcVO.setFxFtOvrDys(chgCalcCntrVO.getFxFtOvrDys());
				//dmtChgCalcVO.setOrgFtOvrDys(chgCalcCntrVO.getOrgFtOvrDys());
				//dmtChgCalcVO.setScRfaExptOvrDys(chgCalcCntrVO.getScRfaExptOvrDys());
				//dmtChgCalcVO.setAftExptOvrDys(chgCalcCntrVO.getAftExptOvrDys());
				dmtChgCalcVO.setBzcTrfCurrCd(chgCalcCntrVO.getBzcTrfCurrCd());
				dmtChgCalcVO.setDmdtTrfAplyTpCd(chgCalcCntrVO.getDmdtTrfAplyTpCd());
				dmtChgCalcVO.setOrgChgAmt(chgCalcCntrVO.getOrgChgAmt());
				dmtChgCalcVO.setScRfaExptAmt(chgCalcCntrVO.getScRfaExptAmt());
				dmtChgCalcVO.setAftExptDcAmt(chgCalcCntrVO.getAftExptDcAmt());
				dmtChgCalcVO.setBilAmt(chgCalcCntrVO.getBilAmt());
				dmtChgCalcVO.setDmdtChgStsCd(chgCalcCntrVO.getDmdtChgStsCd());
				
				//dmtChgCalcVO.setScRfaAmt(chgCalcCntrVO.getScRfaAmt());
				//dmtChgCalcVO.setAftExptAmt(chgCalcCntrVO.getAftExptAmt());
				dmtChgCalcVO.setBzcTrfSeq(chgCalcCntrVO.getBzcTrfSeq());
				dmtChgCalcVO.setBzcTrfGrpSeq(chgCalcCntrVO.getBzcTrfGrpSeq());
				//dmtChgCalcVO.setBzcTrfAplyDt(chgCalcCntrVO.getBzcTrfAplyDt());		
				dmtChgCalcVO.setRfaExptAproNo(chgCalcCntrVO.getRfaExptAproNo());
				dmtChgCalcVO.setRfaExptDarNo(chgCalcCntrVO.getRfaExptDarNo());
				dmtChgCalcVO.setRfaExptMapgSeq(chgCalcCntrVO.getRfaExptMapgSeq());		
				dmtChgCalcVO.setRfaExptVerSeq(chgCalcCntrVO.getRfaExptVerSeq());
				dmtChgCalcVO.setRfaRqstDtlSeq(chgCalcCntrVO.getRfaRqstDtlSeq());
				dmtChgCalcVO.setAftExptAproNo(chgCalcCntrVO.getAftExptAproNo());
				dmtChgCalcVO.setAftExptDarNo(chgCalcCntrVO.getAftExptDarNo());
				dmtChgCalcVO.setAftExptAdjSeq(chgCalcCntrVO.getAftExptAdjSeq());
				dmtChgCalcVO.setScNo(chgCalcCntrVO.getScNo());
				dmtChgCalcVO.setScExptVerSeq(chgCalcCntrVO.getScExptVerSeq());
				dmtChgCalcVO.setScExptGrpSeq(chgCalcCntrVO.getScExptGrpSeq());
				//dmtChgCalcVO.setScRfaExptAplyDt(chgCalcCntrVO.getScRfaExptAplyDt());
				dmtChgCalcVO.setCorrRmk(chgCalcCntrVO.getCorrRmk());
				
				dmtChgCalcVO.setOfcCd(chgCalcCntrVO.getOfcCd());
				//dmtChgCalcVO.setOfcRhqCd(chgCalcCntrVO.getOfcRhq());
				dmtChgCalcVO.setUpdUsrId(account.getUsr_id());
				dmtChgCalcVO.setUpdOfcCd(account.getOfc_cd());
				dmtChgCalcVO.setCmdtCd(chgCalcCntrVO.getCmdtCd());
				dmtChgCalcVO.setOfcTrnsFlg(chgCalcCntrVO.getOfcTrnsFlg());
				//dmtChgCalcVO.setCmdtTrfSeq(chgCalcCntrVO.getCmdtTrfSeq());
				//dmtChgCalcVO.setCmdtExptAplyDt(chgCalcCntrVO.getCmdtExptAplyDt());
				//dmtChgCalcVO.setCmdtOvrDys(chgCalcCntrVO.getCmdtOvrDys());
				//dmtChgCalcVO.setCmdtExptAmt(chgCalcCntrVO.getCmdtExptAmt());
				dmtChgCalcVO.setCreUsrId(account.getUsr_id());
				dmtChgCalcVO.setCreOfcCd(account.getOfc_cd());
				dmtChgCalcVO.setUpdUsrId(account.getUsr_id());
				dmtChgCalcVO.setUpdOfcCd(account.getOfc_cd());
				
				dmtChgCalcVO.setFmMvmtYr(chgCalcCntrVO.getFmMvmtYr());
				dmtChgCalcVO.setFmMvmtSeq(chgCalcCntrVO.getFmMvmtSeq());
				dmtChgCalcVO.setFmMvmtSplitNo(chgCalcCntrVO.getFmMvmtSplitNo());
				dmtChgCalcVO.setToMvmtYr(chgCalcCntrVO.getToMvmtYr());
				dmtChgCalcVO.setToMvmtSeq(chgCalcCntrVO.getToMvmtSeq());
				dmtChgCalcVO.setToMvmtSplitNo(chgCalcCntrVO.getToMvmtSplitNo());
				
				dmtChgCalcVO.setWebIndFlg(chgCalcCntrVO.getWebIndFlg());
				dmtChgCalcVO.setWebCreUsrId(chgCalcCntrVO.getWebCreUsrId());
				dmtChgCalcVO.setWebCreDt(chgCalcCntrVO.getWebCreDt());
				dmtChgCalcVO.setWebNtfyPicNm(chgCalcCntrVO.getWebNtfyPicNm());
				dmtChgCalcVO.setWebNtfyPicTelcmNo(chgCalcCntrVO.getWebNtfyPicTelcmNo());
				dmtChgCalcVO.setWebMtyDt(chgCalcCntrVO.getWebMtyDt().replace("-", ""));
				dmtChgCalcVO.setDulTpExptFlg(chgCalcCntrVO.getDulTpExptFlg());
				
				dbDao.addCharge(dmtChgCalcVO);
				
				

				utilChgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
				utilChgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				utilChgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				utilChgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				utilChgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				utilChgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				int corrHisSeq = dmtCalculationUtil.checkChargeCorrection(utilChgArgVO);
				
				DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
				dmtChgCorrHisVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCorrHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCorrHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCorrHisVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCorrHisVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCorrHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				dmtChgCorrHisVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				dmtChgCorrHisVO.setCorrHisRmk(chgCalcCntrVO.getCorrRmk());
				dmtChgCorrHisVO.setCreUsrId(account.getUsr_id());
				dmtChgCorrHisVO.setCreOfcCd(account.getOfc_cd());
				
				if(corrHisSeq == 0) {
					corrHisSeq++;
					dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
					dbDao.addChargeHistory(dmtChgCorrHisVO);
				}
				
				chgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				chgArgVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				chgArgVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				
				String toMvmtStsCd = chgCalcCntrVO.getToMvmtStsCd();
				ChargePartialPaymentVO chgPartialPaymentVO = null;
				
				if(toMvmtStsCd.equals("DR"))
					chgPartialPaymentVO = dbDao.searchChargeCalculationUseDataByDR(chgArgVO);
				else
					chgPartialPaymentVO = dbDao.searchChargeCalculationUseData(chgArgVO);
			
				
				chgCalcCntrVO.setFmMvmtDt(chgPartialPaymentVO.getFmMvmtDt());

				/*
				Case in  "L"(Long Staying), "U"(Unfinished), "N"(No Charge),Do Re-Calculation Even though there is no To Date/Yard 
				 , initialize To Date
				 */
				String chgStsCd = chgCalcCntrVO.getDmdtChgStsCd();
				if( (chgStsCd.equals("L") || chgStsCd.equals("U") || chgStsCd.equals("N"))
					&& chgPartialPaymentVO.getToMvmtDt().length() < 12 ) {
					chgCalcCntrVO.setToMvmtDt("");
				} else
					chgCalcCntrVO.setToMvmtDt(chgPartialPaymentVO.getToMvmtDt());

				
				if("N".equals(chgCalcCntrVO.getWebIndFlg()) && chgCalcCntrVO.getToMvmtStsCd().equals("DR")) {
					chgArgVO.setWebIndFlg("N");
					dbDao.modifyChargeWebIndicator(chgArgVO);
				}
				
				ChargeCalculationParmVO chgCalcParmVO = new ChargeCalculationParmVO();
				chgCalcParmVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgCalcParmVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgCalcParmVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgCalcParmVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgCalcParmVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgCalcParmVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				chgCalcParmVO.setActCntCd(chgPartialPaymentVO.getActCntCd());
				chgCalcParmVO.setActCustSeq(chgPartialPaymentVO.getActCustSeq());
				chgCalcParmVO.setBkgNo(chgPartialPaymentVO.getBkgNo());
				chgCalcParmVO.setCntrTpszCd(chgCalcCntrVO.getCntrTpszCd());
				chgCalcParmVO.setCustCntCd(chgPartialPaymentVO.getCustCntCd());
				chgCalcParmVO.setCustSeq(chgPartialPaymentVO.getCustSeq());
				chgCalcParmVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				chgCalcParmVO.setFmMvmtStsCd(chgCalcCntrVO.getFmMvmtStsCd());
				chgCalcParmVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				chgCalcParmVO.setIoBndCd(chgPartialPaymentVO.getIoBndCd());
				chgCalcParmVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				chgCalcParmVO.setToMvmtStsCd(chgCalcCntrVO.getToMvmtStsCd());
				chgCalcParmVO.setToMvmtYdCd(chgCalcCntrVO.getToMvmtYdCd());
				
				if(chgCalcCntrVO.getDulTpExptFlg().equals("Y")) {
					// search Dual Charge of Dual Exception Charge abount Combined Charge.
					List<ChargeCalculationContainerVO> chgCalcCntrVOs = dbDao.searchDualChargeTariff(chgArgVO);
					
					if(chgCalcCntrVOs != null && chgCalcCntrVOs.size() > 0) {
						resultVO = dualExceptionChargeCalculation("PARTIAL", chgCalcCntrVO, chgCalcCntrVOs, account);
						
						// error Return
						if(resultVO.getResultCode() != null) {
							return resultVO;
						}
					}
					
					retChgCalcCntrVO = dmtCombinedChargeCalculationUtil.combinedChargeCalculation(chgCalcParmVO);
					
				} else {
					if(chgCalcCntrVO.getCxlBkgChgFlg().equals("Y")) {
						dmtCancelChargeCalculationUtil	= new DMTCancelChargeCalculationUtil();
						retChgCalcCntrVO = dmtCancelChargeCalculationUtil.cancelChargeCalculation(chgCalcParmVO);
						
						if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					} else {
						if(!chgCalcCntrVO.getFmMvmtStsCd().equals("DR")) {
							retChgCalcCntrVO = dmtGeneralChargeCalculationUtil.generalChargeCalculation(chgCalcParmVO);
							
							if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
								resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						} else {
							retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
							
							if(retChgCalcCntrVO.getMsgCd().equals("-1")) {
								resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						}
					}
				}
				
				if(!retChgCalcCntrVO.getMsgCd().equals("0")) {
					retChgCalcCntrVO.setDmdtChgStsCd("E");
				}
				
				
				if(!chgCalcCntrVO.getFmMvmtStsCd().equals("DR")) {
					// [vvd code is null] searchVVDCode( bookingNo) 
					if(chgPartialPaymentVO.getVslCd() == null || chgPartialPaymentVO.getSkdVoyNo() == null
							|| chgPartialPaymentVO.getSkdDirCd() == null) {
						
						String vvdCode = dbDao.searchVVDCode(chgPartialPaymentVO.getBkgNo());
						// YSEA0006E (4:4:1)
						if(!vvdCode.equals("")) {
							chgPartialPaymentVO.setVslCd(vvdCode.substring(0, 4));
							chgPartialPaymentVO.setSkdVoyNo(vvdCode.substring(4, 8));
							chgPartialPaymentVO.setSkdDirCd(vvdCode.substring(8));
						}
					}
					
					// ------------ DmtChgBkgCntrVO -----------------
					DmtChgBkgCntrVO dmtChgBkgCntrVO = new DmtChgBkgCntrVO();
					dmtChgBkgCntrVO.setSvrId(chgCalcCntrVO.getSvrId());
					dmtChgBkgCntrVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					dmtChgBkgCntrVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					
					dmtChgBkgCntrVO.setBlNo(chgPartialPaymentVO.getBlNo());
					//--------------- ChargePartialPaymentVO -------------------
					dmtChgBkgCntrVO.setVslCd(chgPartialPaymentVO.getVslCd());
					dmtChgBkgCntrVO.setSkdVoyNo(chgPartialPaymentVO.getSkdVoyNo());
					dmtChgBkgCntrVO.setSkdDirCd(chgPartialPaymentVO.getSkdDirCd());
					//--------------------------------------------------------
					dmtChgBkgCntrVO.setVpsEtaDt(retChgCalcCntrVO.getVpsEtaDt());
					dmtChgBkgCntrVO.setScNo(retChgCalcCntrVO.getBrhScNo());
					dmtChgBkgCntrVO.setRfaNo(retChgCalcCntrVO.getBrhRfaNo());
					dmtChgBkgCntrVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
					dmtChgBkgCntrVO.setRepCmdtCd(retChgCalcCntrVO.getRepCmdtCd());
					dmtChgBkgCntrVO.setDcgoFlg(retChgCalcCntrVO.getDcgoFlg());
					dmtChgBkgCntrVO.setRcFlg(retChgCalcCntrVO.getRcFlg());
					dmtChgBkgCntrVO.setBbCgoFlg(retChgCalcCntrVO.getBbCgoFlg());
					dmtChgBkgCntrVO.setAwkCgoFlg(retChgCalcCntrVO.getAwkCgoFlg());
					dmtChgBkgCntrVO.setRdCgoFlg(retChgCalcCntrVO.getRdCgoFlg());
					dmtChgBkgCntrVO.setSocFlg(retChgCalcCntrVO.getSocFlg());
					dmtChgBkgCntrVO.setCntrPrtFlg(retChgCalcCntrVO.getCntrPrtFlg());
					dmtChgBkgCntrVO.setAdvShtgCd(retChgCalcCntrVO.getAdvShtgCd());
					dmtChgBkgCntrVO.setDmdtCntrTpCd(retChgCalcCntrVO.getCntrTp());
					dmtChgBkgCntrVO.setDmdtBkgCgoTpCd(retChgCalcCntrVO.getDmdtCgoTpCd());
					dmtChgBkgCntrVO.setPorCd(retChgCalcCntrVO.getPorCd());
					dmtChgBkgCntrVO.setPolCd(retChgCalcCntrVO.getPolCd());
					dmtChgBkgCntrVO.setPodCd(retChgCalcCntrVO.getPodCd());
					dmtChgBkgCntrVO.setDelCd(retChgCalcCntrVO.getDelCd());
					dmtChgBkgCntrVO.setBkgRcvTermCd(retChgCalcCntrVO.getBbRcvTermCd());
					dmtChgBkgCntrVO.setBkgDeTermCd(retChgCalcCntrVO.getBbDeTermCd());
					dmtChgBkgCntrVO.setBkgCntrQty(retChgCalcCntrVO.getBkgQty());
					dmtChgBkgCntrVO.setSlsOfcCd(retChgCalcCntrVO.getSalOfc());
					dmtChgBkgCntrVO.setRhqCd(retChgCalcCntrVO.getSalRhq());
					dmtChgBkgCntrVO.setUpdUsrId(account.getUsr_id());
					dmtChgBkgCntrVO.setUpdOfcCd(account.getOfc_cd());
					
					dbDao.modifyBookingContainer(dmtChgBkgCntrVO);
				}

				/*
				OfficeNRHQVO officeNRHQVO = null;
				if(chgCalcCntrVO.getOfcTrnsFlg().equals("Y")) {
					officeNRHQVO = dbDao.checkOfficeTransfer(chgArgVO); 
				}
				*/
				
				// ************* DmtChgCalcVO  *****************
				dmtChgCalcVO = new DmtChgCalcVO();
				dmtChgCalcVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCalcVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCalcVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCalcVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCalcVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCalcVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				dmtChgCalcVO.setFmMvmtStsCd(chgCalcCntrVO.getFmMvmtStsCd());
				dmtChgCalcVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				dmtChgCalcVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				dmtChgCalcVO.setToMvmtStsCd(chgCalcCntrVO.getToMvmtStsCd());
				dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
				dmtChgCalcVO.setToMvmtYdCd(chgCalcCntrVO.getToMvmtYdCd());
				dmtChgCalcVO.setNotCreBalFlg("N");
				dmtChgCalcVO.setFtDys(retChgCalcCntrVO.getFtDys());
				dmtChgCalcVO.setFtCmncDt(retChgCalcCntrVO.getFtCmncDt());
				dmtChgCalcVO.setFtEndDt(retChgCalcCntrVO.getFtEndDt());
				dmtChgCalcVO.setFxFtOvrDys(retChgCalcCntrVO.getFxFtOvrDys());
				dmtChgCalcVO.setOrgFtOvrDys(retChgCalcCntrVO.getOrgFtOvrDys());
				dmtChgCalcVO.setScRfaExptOvrDys(retChgCalcCntrVO.getScRfaExptOvrDys());
				dmtChgCalcVO.setAftExptOvrDys(retChgCalcCntrVO.getAftExptOvrDys());
				dmtChgCalcVO.setBzcTrfCurrCd(retChgCalcCntrVO.getBzcTrfCurrCd());
				dmtChgCalcVO.setDmdtTrfAplyTpCd(retChgCalcCntrVO.getDmdtTrfAplyTpCd());
				dmtChgCalcVO.setOrgChgAmt(retChgCalcCntrVO.getOrgChgAmt());
				dmtChgCalcVO.setScRfaExptAmt(retChgCalcCntrVO.getScRfaExptAmt());
				dmtChgCalcVO.setAftExptDcAmt(retChgCalcCntrVO.getAftExptDcAmt());
				dmtChgCalcVO.setBilAmt(retChgCalcCntrVO.getBilAmt());
				
				if(chgCalcCntrVO.getDmdtChgStsCd().equals("I"))
					dmtChgCalcVO.setDmdtChgStsCd(chgCalcCntrVO.getDmdtChgStsCd());
				else
					dmtChgCalcVO.setDmdtChgStsCd(retChgCalcCntrVO.getDmdtChgStsCd());
				
				dmtChgCalcVO.setScRfaAmt(retChgCalcCntrVO.getScRfaAmt());
				dmtChgCalcVO.setAftExptAmt(retChgCalcCntrVO.getAftExptAmt());
				dmtChgCalcVO.setBzcTrfSeq(retChgCalcCntrVO.getBzcTrfSeq());
				dmtChgCalcVO.setBzcTrfGrpSeq(retChgCalcCntrVO.getBzcTrfGrpSeq());
				dmtChgCalcVO.setBzcTrfAplyDt(retChgCalcCntrVO.getBzcTrfAplyDt());		
				dmtChgCalcVO.setRfaExptAproNo(retChgCalcCntrVO.getRfaExptAproNo());
				dmtChgCalcVO.setRfaExptDarNo(retChgCalcCntrVO.getRfaExptDarNo());
				dmtChgCalcVO.setRfaExptMapgSeq(retChgCalcCntrVO.getRfaExptMapgSeq());		
				dmtChgCalcVO.setRfaExptVerSeq(retChgCalcCntrVO.getRfaExptVerSeq());
				dmtChgCalcVO.setRfaRqstDtlSeq(retChgCalcCntrVO.getRfaRqstDtlSeq());
				dmtChgCalcVO.setAftExptAproNo(retChgCalcCntrVO.getAftExptAproNo());
				dmtChgCalcVO.setAftExptDarNo(retChgCalcCntrVO.getAftExptDarNo());
				dmtChgCalcVO.setAftExptAdjSeq(retChgCalcCntrVO.getAftExptAdjSeq());
				dmtChgCalcVO.setScNo(retChgCalcCntrVO.getScNo());
				dmtChgCalcVO.setScExptVerSeq(retChgCalcCntrVO.getScExptVerSeq());
				dmtChgCalcVO.setScExptGrpSeq(retChgCalcCntrVO.getScExptGrpSeq());
				dmtChgCalcVO.setScRfaExptAplyDt(retChgCalcCntrVO.getScRfaExptAplyDt());
				dmtChgCalcVO.setCorrRmk(chgCalcCntrVO.getCorrRmk());
				dmtChgCalcVO.setDmdtInvNo(chgCalcCntrVO.getDmdtInvNo());
				// ofc_cd of screen
				dmtChgCalcVO.setOfcCd(chgCalcCntrVO.getOfcCd());
				
				dmtChgCalcVO.setOfcRhqCd(chgCalcCntrVO.getOfcRhqCd());
				dmtChgCalcVO.setUpdUsrId(account.getUsr_id());
				dmtChgCalcVO.setUpdOfcCd(account.getOfc_cd());
				dmtChgCalcVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
				dmtChgCalcVO.setCmdtTrfSeq(retChgCalcCntrVO.getCmdtTrfSeq());
				dmtChgCalcVO.setCmdtExptAplyDt(retChgCalcCntrVO.getCmdtExptAplyDt());
				dmtChgCalcVO.setCmdtOvrDys(retChgCalcCntrVO.getCmdtOvrDys());
				dmtChgCalcVO.setCmdtExptAmt(retChgCalcCntrVO.getCmdtExptAmt());
				dmtChgCalcVO.setWebMtyDt(chgCalcCntrVO.getWebMtyDt().replace("-", ""));
				
				dbDao.modifyChargeCalculation(dmtChgCalcVO);
				
				
				// applied Clock Stop over one day (cStopNoList.size() > 0) run addClockStopHistory 
				List<String> cStopNoList = retChgCalcCntrVO.getCStopNoList();
				
				if(cStopNoList != null && cStopNoList.size() > 0) {
					DmtChgTmCskStopVO dmtChgTmCskStopVO = new DmtChgTmCskStopVO();
					dmtChgTmCskStopVO.setSvrId(chgCalcCntrVO.getSvrId());
					dmtChgTmCskStopVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					dmtChgTmCskStopVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					dmtChgTmCskStopVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					dmtChgTmCskStopVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					dmtChgTmCskStopVO.setChgSeq(chgCalcCntrVO.getChgSeq());
					dmtChgTmCskStopVO.setCreOfcCd(account.getOfc_cd());
					
					modifyClockStopHistory(dmtChgTmCskStopVO, cStopNoList);
				}
				
				corrHisSeq++;
				dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
				dbDao.addChargeHistory(dmtChgCorrHisVO);
				
				
				// ************* chgCalcCntrVO modify *********************
				chgCalcCntrVO.setBkgNo(chgPartialPaymentVO.getBkgNo());
				chgCalcCntrVO.setBlNo(chgPartialPaymentVO.getBlNo());
				chgCalcCntrVO.setActCustSeq(chgPartialPaymentVO.getActCntCd());
				chgCalcCntrVO.setCustCntCd(chgPartialPaymentVO.getCustCntCd());
				chgCalcCntrVO.setDmdtChgStsCd(chgCalcCntrVO.getDmdtChgStsCd());
				chgCalcCntrVO.setFxFtOvrDys(retChgCalcCntrVO.getFxFtOvrDys());
				chgCalcCntrVO.setBzcTrfSeq(retChgCalcCntrVO.getBzcTrfSeq());
				chgCalcCntrVO.setAftExptDcAmt(retChgCalcCntrVO.getAftExptDcAmt());
				chgCalcCntrVO.setScRfaExptAmt(retChgCalcCntrVO.getScRfaExptAmt());
				chgCalcCntrVO.setBzcTrfCurrCd(retChgCalcCntrVO.getBzcTrfCurrCd());
				chgCalcCntrVO.setFtDys(retChgCalcCntrVO.getFtDys());
				chgCalcCntrVO.setFtCmncDt(retChgCalcCntrVO.getFtCmncDt());
				chgCalcCntrVO.setFtEndDt(retChgCalcCntrVO.getFtEndDt());
				chgCalcCntrVO.setOrgChgAmt(retChgCalcCntrVO.getOrgChgAmt());
				chgCalcCntrVO.setBilAmt(retChgCalcCntrVO.getBilAmt());
				
				chargeCalculationContainerVOs[i] = chgCalcCntrVO;
				// ***********************************************************
				
				
				// No Charge : Delete All Balances
				// Invoiced Container is must have Charge.
				if( retChgCalcCntrVO.getDmdtChgStsCd().equals("N") ) {
					if(!chgCalcCntrVO.getDmdtInvNo().equals("")) {
						resultVO.setResultCode("DMT01029");
						return resultVO;
					}
					
					// Setting "Y" case in No Balance Flag
					dbDao.modifyChargeByNoBalance(chgArgVO);
					break;
				}
				
				
			} // for end
			
			resultVO.setChargeCalculationContainerVOArray(chargeCalculationContainerVOs);
			return resultVO;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"create Partial Payment"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"create Partial Payment"}).getMessage());
		}
	}
	
	
	/**
	 *  Delete all DR Balance Charge except General Charge<br>
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String cancelDRBalanceCharge(ChargeCalculationContainerVO chargeCalculationContainerVO, SignOnUserAccount account)
		throws EventException {
		
		try {
			String result = "";
			
			ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
			chgArgVO.setSvrId(chargeCalculationContainerVO.getSvrId());
			chgArgVO.setCntrNo(chargeCalculationContainerVO.getCntrNo());
			chgArgVO.setCntrCycNo(chargeCalculationContainerVO.getCntrCycNo());
			chgArgVO.setDmdtTrfCd(chargeCalculationContainerVO.getDmdtTrfCd());
			chgArgVO.setDmdtChgLocDivCd(chargeCalculationContainerVO.getDmdtChgLocDivCd());
			chgArgVO.setDulTpExptFlg(chargeCalculationContainerVO.getDulTpExptFlg());
			
			// if exists Invoice Issued Charge in Balance Charge, shoe message [DMT01036] and return error
			boolean chkVal = dbDao.checkChargeInvoiceByDRCancel(chgArgVO);
			
			if(chkVal) {
				return "DMT01036";
			}
			
			//search Balance Charge의 dCharge Sequence List of Balance Charge for deleting
			List<String> chgSeqList = dbDao.searchChargeByDRCancel(chgArgVO);
			
			if(chgSeqList != null && chgSeqList.size() > 0) {
				//dbDao.modifyChargeByDRCancel(chgArgVO);
				
				DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
				dmtChgCalcVO.setSvrId(chargeCalculationContainerVO.getSvrId());
				dmtChgCalcVO.setCntrNo(chargeCalculationContainerVO.getCntrNo());
				dmtChgCalcVO.setCntrCycNo(chargeCalculationContainerVO.getCntrCycNo());
				dmtChgCalcVO.setDmdtTrfCd(chargeCalculationContainerVO.getDmdtTrfCd());
				dmtChgCalcVO.setDmdtChgLocDivCd(chargeCalculationContainerVO.getDmdtChgLocDivCd());
				dmtChgCalcVO.setDeltUsrId(account.getUsr_id());
				dmtChgCalcVO.setDeltOfcCd(account.getOfc_cd());
				
				for(int i=0; i < chgSeqList.size(); i++) {
					String chgSeq = chgSeqList.get(i);
					dmtChgCalcVO.setChgSeq(chgSeq);
					
					// Insert Table into Charge Backup
					dbDao.addChargeBackup(dmtChgCalcVO);
				}
			}
			
			// Delete all Balance Charge
			dbDao.deleteChargeByDRCancel(chgArgVO);
			
			return result;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"cancel DRBalance Charge"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"cancel DRBalance Charge"}).getMessage());
		}
	}
	
	
	
	/**
	 * modify Container Charge info.(Save, Web Cancel)<br>
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO modifyChargeByContainer(ChargeCalculationContainerVO chargeCalculationContainerVO, SignOnUserAccount account)
		throws EventException {
		
		try {
			DmtResultVO resultVO = new DmtResultVO();
			DMTGeneralChargeCalculationUtil dmtGeneralChargeCalculationUtil = null;
			DMTBalanceChargeCalculationUtil dmtBalanceChargeCalculationUtil = null;
			DMTCancelChargeCalculationUtil	dmtCancelChargeCalculationUtil	= null;
			DMTCombinedChargeCalculationUtil dmtCombinedChargeCalculationUtil = null;
			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			
			
			chargeCalculationContainerVO.setFmMvmtDt(chargeCalculationContainerVO.getFmMvmtDt().replace("-", ""));
			chargeCalculationContainerVO.setToMvmtDt(chargeCalculationContainerVO.getToMvmtDt().replace("-", ""));
			
			ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
			chgArgVO.setSvrId(chargeCalculationContainerVO.getSvrId());
			chgArgVO.setCntrNo(chargeCalculationContainerVO.getCntrNo());
			chgArgVO.setCntrCycNo(chargeCalculationContainerVO.getCntrCycNo());
			chgArgVO.setDmdtTrfCd(chargeCalculationContainerVO.getDmdtTrfCd());
			chgArgVO.setDmdtChgLocDivCd(chargeCalculationContainerVO.getDmdtChgLocDivCd());
			chgArgVO.setChgSeq(chargeCalculationContainerVO.getChgSeq());
			chgArgVO.setFmMvmtDt(chargeCalculationContainerVO.getFmMvmtDt());
			chgArgVO.setToMvmtDt(chargeCalculationContainerVO.getToMvmtDt());
			
			/*
			- saving D/R Date case in no Balance Charge or Balance Charge is last.
			- is Balance Charge,  "There is a balance charge!" Alert message and return error.
			*/
			String chgMaxSeq = dbDao.searchChargeMaxSequence(chgArgVO);
			
			if(!chargeCalculationContainerVO.getChgSeq().equals(chgMaxSeq)) {
				//"There is a balance charge !"
				resultVO.setResultCode("DMT01030");
				return resultVO;
			}
			
			
			// check Invoiced Charge, and return error 
			boolean chgInvChk = dbDao.searchChargeInvoiceCheck(chgArgVO);
			if(chgInvChk) {
				//"Already Invoiced"
				resultVO.setResultCode("DMT01002");
				return resultVO;
			}
			
			// case in Web Cancel, clear To MVMT Date, To MVMT Yard, To MVMt Status
			/*if(chargeCalculationContainerVO.getWebCancelFlg().equals("Y")) {
				chargeCalculationContainerVO.setToMvmtDt("");
				chargeCalculationContainerVO.setToMvmtYdCd("");
				chargeCalculationContainerVO.setToMvmtStsCd("");
			}*/
			
			
			// case in To Movement Status is "DR" or "CS", compare current date and  To Date , if  To Date is more small, return error
			String toMvmtStsCd = chargeCalculationContainerVO.getToMvmtStsCd();
			
			// DR Date Checking
			if(toMvmtStsCd.equals("DR")) {
				//String currDt = DateTime.getDateString().replace(".","");
				// Search current local date of User Office
				String currDt	= dbDao.searchCurrentDateByOffice(account.getOfc_cd());
				String toMvmtDt	= chargeCalculationContainerVO.getToMvmtDt();
				
				if(currDt.compareTo(toMvmtDt) > 0) {
					// D/R Date should be same or later than current date
					resultVO.setResultCode("DMT01031");
					return resultVO;
				}
			} else if(toMvmtStsCd.equals("CS")) {
				// Clock Stop
				String fmMvmtDt = chargeCalculationContainerVO.getFmMvmtDt();
				String toMvmtDt = chargeCalculationContainerVO.getToMvmtDt();
				
				if(fmMvmtDt.compareTo(toMvmtDt) >= 0) {
					// CS date should be later than From date
					resultVO.setResultCode("DMT01004");
					return resultVO;
				}
			}
			
			
			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = null;
			chargeArgumentVO = new com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
			chargeArgumentVO.setSvrId(chargeCalculationContainerVO.getSvrId());
			chargeArgumentVO.setCntrNo(chargeCalculationContainerVO.getCntrNo());
			chargeArgumentVO.setCntrCycNo(chargeCalculationContainerVO.getCntrCycNo());
			chargeArgumentVO.setDmdtTrfCd(chargeCalculationContainerVO.getDmdtTrfCd());
			chargeArgumentVO.setDmdtChgLocDivCd(chargeCalculationContainerVO.getDmdtChgLocDivCd());
			chargeArgumentVO.setChgSeq(chargeCalculationContainerVO.getChgSeq());
			
			// if not exists Correction History of Charge, then  Insert Correction History.
			int corrHisSeq = dmtCalculationUtil.checkChargeCorrection(chargeArgumentVO);
			
			DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
			dmtChgCorrHisVO.setSvrId(chargeCalculationContainerVO.getSvrId());
			dmtChgCorrHisVO.setCntrNo(chargeCalculationContainerVO.getCntrNo());
			dmtChgCorrHisVO.setCntrCycNo(chargeCalculationContainerVO.getCntrCycNo());
			dmtChgCorrHisVO.setDmdtTrfCd(chargeCalculationContainerVO.getDmdtTrfCd());
			dmtChgCorrHisVO.setDmdtChgLocDivCd(chargeCalculationContainerVO.getDmdtChgLocDivCd());
			dmtChgCorrHisVO.setChgSeq(chargeCalculationContainerVO.getChgSeq());
			dmtChgCorrHisVO.setBkgNo(chargeCalculationContainerVO.getBkgNo());
			dmtChgCorrHisVO.setCorrHisRmk(chargeCalculationContainerVO.getCorrRmk());
			dmtChgCorrHisVO.setCreUsrId(account.getUsr_id());
			dmtChgCorrHisVO.setCreOfcCd(account.getOfc_cd());
			
			if(corrHisSeq == 0) {
				corrHisSeq++;
				dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
				dbDao.addChargeHistory(dmtChgCorrHisVO);
			}
			
			
			// ***********  ChargeCalculationUseData  *************
			ChargePartialPaymentVO chgPartialPaymentVO = dbDao.searchChargeCalculationUseData(chgArgVO);

			
			chargeCalculationContainerVO.setFmMvmtDt(chgPartialPaymentVO.getFmMvmtDt());
			
			/*
			 Case in  "L"(Long Staying), "U"(Unfinished), "N"(No Charge),Do Re-Calculation Even though there is no To Date/Yard 
				 , initialize To Date
			 */
			//String chgStsCd = chargeCalculationContainerVO.getDmdtChgStsCd();
			if( //(chgStsCd.equals("L") || chgStsCd.equals("U") || chgStsCd.equals("N")) && 
				chgPartialPaymentVO.getToMvmtDt().length() < 12 ) {
				chargeCalculationContainerVO.setToMvmtDt("");
			} else
				chargeCalculationContainerVO.setToMvmtDt(chgPartialPaymentVO.getToMvmtDt());
			
			
			//case in  MT Notificationed Data(To Movement="DR" and  Web Indicator="Y"), Web Indicator update to "N".
			if( ("Y".equals(chargeCalculationContainerVO.getWebIndFlg()) && chargeCalculationContainerVO.getToMvmtStsCd().equals("DR"))
					|| (chargeCalculationContainerVO.getWebCancelFlg().equals("Y")) ) {   // <--- Web Cancel  check condition
				chgArgVO.setWebIndFlg("N");
				dbDao.modifyChargeWebIndicator(chgArgVO);
			}
			
			
			ChargeCalculationParmVO chgCalcParmVO = new ChargeCalculationParmVO();
			chgCalcParmVO.setSvrId(chargeCalculationContainerVO.getSvrId());
			chgCalcParmVO.setCntrNo(chargeCalculationContainerVO.getCntrNo());
			chgCalcParmVO.setCntrCycNo(chargeCalculationContainerVO.getCntrCycNo());
			chgCalcParmVO.setDmdtTrfCd(chargeCalculationContainerVO.getDmdtTrfCd());
			chgCalcParmVO.setDmdtChgLocDivCd(chargeCalculationContainerVO.getDmdtChgLocDivCd());
			chgCalcParmVO.setChgSeq(chargeCalculationContainerVO.getChgSeq());
			
			chgCalcParmVO.setActCntCd(chgPartialPaymentVO.getActCntCd());
			chgCalcParmVO.setActCustSeq(chgPartialPaymentVO.getActCustSeq());
			chgCalcParmVO.setBkgNo(chargeCalculationContainerVO.getBkgNo());
			chgCalcParmVO.setCntrTpszCd(chargeCalculationContainerVO.getCntrTpszCd());
			chgCalcParmVO.setCustCntCd(chgPartialPaymentVO.getCustCntCd());
			chgCalcParmVO.setCustSeq(chgPartialPaymentVO.getCustSeq());
			chgCalcParmVO.setFmMvmtDt(chargeCalculationContainerVO.getFmMvmtDt());
			chgCalcParmVO.setFmMvmtStsCd(chargeCalculationContainerVO.getFmMvmtStsCd());
			chgCalcParmVO.setFmMvmtYdCd(chargeCalculationContainerVO.getFmMvmtYdCd());
			chgCalcParmVO.setIoBndCd(chgPartialPaymentVO.getIoBndCd());
			chgCalcParmVO.setToMvmtDt(chargeCalculationContainerVO.getToMvmtDt());
			chgCalcParmVO.setToMvmtStsCd(chargeCalculationContainerVO.getToMvmtStsCd());
			chgCalcParmVO.setToMvmtYdCd(chargeCalculationContainerVO.getToMvmtYdCd());
			
			
			if(chargeCalculationContainerVO.getDulTpExptFlg().equals("Y")) {
				//search Dual Charge of Dual Exception Charge abount Combined Charge.
				List<ChargeCalculationContainerVO> chgCalcCntrVOs = dbDao.searchDualChargeTariff(chgArgVO);
				
				if(chgCalcCntrVOs != null && chgCalcCntrVOs.size() > 0) {
					String callFlag = null;
					if(chargeCalculationContainerVO.getWebCancelFlg().equals("Y")) {
						callFlag = "WEBCANCEL";
					} else {
						callFlag = "SAVE";
					}
					
					chgArgVO.setCallFlag(callFlag);
					resultVO = dualExceptionChargeCalculation(callFlag, chargeCalculationContainerVO, chgCalcCntrVOs, account);
					
					// error Return
					if(resultVO.getResultCode() != null) {
						return resultVO;
					}
				}
				
				dmtCombinedChargeCalculationUtil = new DMTCombinedChargeCalculationUtil();
				retChgCalcCntrVO = dmtCombinedChargeCalculationUtil.combinedChargeCalculation(chgCalcParmVO);
				
			} else {
				if(chargeCalculationContainerVO.getCxlBkgChgFlg().equals("Y")) {
					dmtCancelChargeCalculationUtil	= new DMTCancelChargeCalculationUtil();
					retChgCalcCntrVO = dmtCancelChargeCalculationUtil.cancelChargeCalculation(chgCalcParmVO);
					
					if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
						resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
						resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
						return resultVO;
					}
				} else {
					//  if From Movement Status is not "DR"  calculate General Charge , is "DR" then  calculate Balance Charge
					if(!chargeCalculationContainerVO.getFmMvmtStsCd().equals("DR")) {
						dmtGeneralChargeCalculationUtil = new DMTGeneralChargeCalculationUtil();
						retChgCalcCntrVO = dmtGeneralChargeCalculationUtil.generalChargeCalculation(chgCalcParmVO);
						
						if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					} else {
						dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
						retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
						if(retChgCalcCntrVO.getMsgCd().equals("-1")) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					}
				}
			}
			
			// if Return of calculated Operation is not 0  , then Charge Status set "E"(Error)
			if(!retChgCalcCntrVO.getMsgCd().equals("0")) {
				retChgCalcCntrVO.setDmdtChgStsCd("E");
				chargeCalculationContainerVO.setCorrRmk(chargeCalculationContainerVO.getCorrRmk() + " " + retChgCalcCntrVO.getMsgDesc());
			}
			
			// if From Movement Status is not  "DR"  calculate General Charge and Parameter in BKG CNTR Data update into BKG CNTR Table 
			// but Parameter VVD Code of  Parameters is  Null, search Trunk VVD of Booking.
			if(!chargeCalculationContainerVO.getFmMvmtStsCd().equals("DR")) {
				
				// [if vvd code is null] searchVVDCode( bookingNo) 
				if(chgPartialPaymentVO.getVslCd() == null || chgPartialPaymentVO.getSkdVoyNo() == null
						|| chgPartialPaymentVO.getSkdDirCd() == null) {
					
					String vvdCode = dbDao.searchVVDCode(chgPartialPaymentVO.getBkgNo());
					// YSEA0006E (4:4:1)
					if(!vvdCode.equals("")) {
						chgPartialPaymentVO.setVslCd(vvdCode.substring(0, 4));
						chgPartialPaymentVO.setSkdVoyNo(vvdCode.substring(4, 8));
						chgPartialPaymentVO.setSkdDirCd(vvdCode.substring(8));
					}
				}
				
				// ------------ DmtChgBkgCntrVO  -----------------
				DmtChgBkgCntrVO dmtChgBkgCntrVO = new DmtChgBkgCntrVO();
				dmtChgBkgCntrVO.setSvrId(chargeCalculationContainerVO.getSvrId());
				dmtChgBkgCntrVO.setCntrNo(chargeCalculationContainerVO.getCntrNo());
				dmtChgBkgCntrVO.setCntrCycNo(chargeCalculationContainerVO.getCntrCycNo());
				
				dmtChgBkgCntrVO.setBlNo(chgPartialPaymentVO.getBlNo());
				//--------------- ChargePartialPaymentVO -------------------
				dmtChgBkgCntrVO.setVslCd(chgPartialPaymentVO.getVslCd());
				dmtChgBkgCntrVO.setSkdVoyNo(chgPartialPaymentVO.getSkdVoyNo());
				dmtChgBkgCntrVO.setSkdDirCd(chgPartialPaymentVO.getSkdDirCd());
				//--------------------------------------------------------
				dmtChgBkgCntrVO.setVpsEtaDt(retChgCalcCntrVO.getVpsEtaDt());
				dmtChgBkgCntrVO.setScNo(retChgCalcCntrVO.getBrhScNo());
				dmtChgBkgCntrVO.setRfaNo(retChgCalcCntrVO.getBrhRfaNo());
				dmtChgBkgCntrVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
				dmtChgBkgCntrVO.setRepCmdtCd(retChgCalcCntrVO.getRepCmdtCd());
				dmtChgBkgCntrVO.setDcgoFlg(retChgCalcCntrVO.getDcgoFlg());
				dmtChgBkgCntrVO.setRcFlg(retChgCalcCntrVO.getRcFlg());
				dmtChgBkgCntrVO.setBbCgoFlg(retChgCalcCntrVO.getBbCgoFlg());
				dmtChgBkgCntrVO.setAwkCgoFlg(retChgCalcCntrVO.getAwkCgoFlg());
				dmtChgBkgCntrVO.setRdCgoFlg(retChgCalcCntrVO.getRdCgoFlg());
				dmtChgBkgCntrVO.setSocFlg(retChgCalcCntrVO.getSocFlg());
				dmtChgBkgCntrVO.setCntrPrtFlg(retChgCalcCntrVO.getCntrPrtFlg());
				dmtChgBkgCntrVO.setAdvShtgCd(retChgCalcCntrVO.getAdvShtgCd());
				dmtChgBkgCntrVO.setDmdtCntrTpCd(retChgCalcCntrVO.getCntrTp());
				dmtChgBkgCntrVO.setDmdtBkgCgoTpCd(retChgCalcCntrVO.getDmdtCgoTpCd());
				dmtChgBkgCntrVO.setPorCd(retChgCalcCntrVO.getPorCd());
				dmtChgBkgCntrVO.setPolCd(retChgCalcCntrVO.getPolCd());
				dmtChgBkgCntrVO.setPodCd(retChgCalcCntrVO.getPodCd());
				dmtChgBkgCntrVO.setDelCd(retChgCalcCntrVO.getDelCd());
				dmtChgBkgCntrVO.setBkgRcvTermCd(retChgCalcCntrVO.getBbRcvTermCd());
				dmtChgBkgCntrVO.setBkgDeTermCd(retChgCalcCntrVO.getBbDeTermCd());
				dmtChgBkgCntrVO.setBkgCntrQty(retChgCalcCntrVO.getBkgQty());
				dmtChgBkgCntrVO.setSlsOfcCd(retChgCalcCntrVO.getSalOfc());
				dmtChgBkgCntrVO.setRhqCd(retChgCalcCntrVO.getSalRhq());
				dmtChgBkgCntrVO.setUpdUsrId(account.getUsr_id());
				dmtChgBkgCntrVO.setUpdOfcCd(account.getOfc_cd());
				
				dbDao.modifyBookingContainer(dmtChgBkgCntrVO);
			}
			
			// 11. if it is Office Transfered Charge, then changed Office and  RHQ set Office and RHQ of Charge, else save calculated Office and RHQ
			/*
			OfficeNRHQVO officeNRHQVO = null;
			if(chargeCalculationContainerVO.getOfcTrnsFlg().equals("Y")) {
				officeNRHQVO = dbDao.checkOfficeTransfer(chgArgVO); 
			}
			*/
			
			// ************* DmtChgCalcVO  *****************
			DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
			dmtChgCalcVO.setSvrId(chargeCalculationContainerVO.getSvrId());
			dmtChgCalcVO.setCntrNo(chargeCalculationContainerVO.getCntrNo());
			dmtChgCalcVO.setCntrCycNo(chargeCalculationContainerVO.getCntrCycNo());
			dmtChgCalcVO.setDmdtTrfCd(chargeCalculationContainerVO.getDmdtTrfCd());
			dmtChgCalcVO.setDmdtChgLocDivCd(chargeCalculationContainerVO.getDmdtChgLocDivCd());
			dmtChgCalcVO.setChgSeq(chargeCalculationContainerVO.getChgSeq());
			
			dmtChgCalcVO.setFmMvmtStsCd(chargeCalculationContainerVO.getFmMvmtStsCd());
			dmtChgCalcVO.setFmMvmtDt(chargeCalculationContainerVO.getFmMvmtDt());
			dmtChgCalcVO.setFmMvmtYdCd(chargeCalculationContainerVO.getFmMvmtYdCd());
			dmtChgCalcVO.setToMvmtStsCd(chargeCalculationContainerVO.getToMvmtStsCd());
			dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
			dmtChgCalcVO.setToMvmtYdCd(chargeCalculationContainerVO.getToMvmtYdCd());
			dmtChgCalcVO.setNotCreBalFlg("N");
			dmtChgCalcVO.setFtDys(retChgCalcCntrVO.getFtDys());
			dmtChgCalcVO.setFtCmncDt(retChgCalcCntrVO.getFtCmncDt());
			dmtChgCalcVO.setFtEndDt(retChgCalcCntrVO.getFtEndDt());
			dmtChgCalcVO.setFxFtOvrDys(retChgCalcCntrVO.getFxFtOvrDys());
			dmtChgCalcVO.setOrgFtOvrDys(retChgCalcCntrVO.getOrgFtOvrDys());
			dmtChgCalcVO.setScRfaExptOvrDys(retChgCalcCntrVO.getScRfaExptOvrDys());
			dmtChgCalcVO.setAftExptOvrDys(retChgCalcCntrVO.getAftExptOvrDys());
			dmtChgCalcVO.setBzcTrfCurrCd(retChgCalcCntrVO.getBzcTrfCurrCd());
			dmtChgCalcVO.setDmdtTrfAplyTpCd(retChgCalcCntrVO.getDmdtTrfAplyTpCd());
			dmtChgCalcVO.setOrgChgAmt(retChgCalcCntrVO.getOrgChgAmt());
			dmtChgCalcVO.setScRfaExptAmt(retChgCalcCntrVO.getScRfaExptAmt());
			dmtChgCalcVO.setAftExptDcAmt(retChgCalcCntrVO.getAftExptDcAmt());
			dmtChgCalcVO.setBilAmt(retChgCalcCntrVO.getBilAmt());
			dmtChgCalcVO.setDmdtChgStsCd(retChgCalcCntrVO.getDmdtChgStsCd());
			
			dmtChgCalcVO.setScRfaAmt(retChgCalcCntrVO.getScRfaAmt());
			dmtChgCalcVO.setAftExptAmt(retChgCalcCntrVO.getAftExptAmt());
			dmtChgCalcVO.setBzcTrfSeq(retChgCalcCntrVO.getBzcTrfSeq());
			dmtChgCalcVO.setBzcTrfGrpSeq(retChgCalcCntrVO.getBzcTrfGrpSeq());
			dmtChgCalcVO.setBzcTrfAplyDt(retChgCalcCntrVO.getBzcTrfAplyDt());		
			dmtChgCalcVO.setRfaExptAproNo(retChgCalcCntrVO.getRfaExptAproNo());
			dmtChgCalcVO.setRfaExptDarNo(retChgCalcCntrVO.getRfaExptDarNo());
			dmtChgCalcVO.setRfaExptMapgSeq(retChgCalcCntrVO.getRfaExptMapgSeq());		
			dmtChgCalcVO.setRfaExptVerSeq(retChgCalcCntrVO.getRfaExptVerSeq());
			dmtChgCalcVO.setRfaRqstDtlSeq(retChgCalcCntrVO.getRfaRqstDtlSeq());
			dmtChgCalcVO.setAftExptAproNo(retChgCalcCntrVO.getAftExptAproNo());
			dmtChgCalcVO.setAftExptDarNo(retChgCalcCntrVO.getAftExptDarNo());
			dmtChgCalcVO.setAftExptAdjSeq(retChgCalcCntrVO.getAftExptAdjSeq());
			dmtChgCalcVO.setScNo(retChgCalcCntrVO.getScNo());
			dmtChgCalcVO.setScExptVerSeq(retChgCalcCntrVO.getScExptVerSeq());
			dmtChgCalcVO.setScExptGrpSeq(retChgCalcCntrVO.getScExptGrpSeq());
			dmtChgCalcVO.setScRfaExptAplyDt(retChgCalcCntrVO.getScRfaExptAplyDt());
			dmtChgCalcVO.setCorrRmk(chargeCalculationContainerVO.getCorrRmk());
			
			dmtChgCalcVO.setOfcCd(chargeCalculationContainerVO.getOfcCd());
			dmtChgCalcVO.setOfcRhqCd(chargeCalculationContainerVO.getOfcRhqCd());
			dmtChgCalcVO.setUpdUsrId(account.getUsr_id());
			dmtChgCalcVO.setUpdOfcCd(account.getOfc_cd());
			dmtChgCalcVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
			dmtChgCalcVO.setCmdtTrfSeq(retChgCalcCntrVO.getCmdtTrfSeq());
			dmtChgCalcVO.setCmdtExptAplyDt(retChgCalcCntrVO.getCmdtExptAplyDt());
			dmtChgCalcVO.setCmdtOvrDys(retChgCalcCntrVO.getCmdtOvrDys());
			dmtChgCalcVO.setCmdtExptAmt(retChgCalcCntrVO.getCmdtExptAmt());
			dmtChgCalcVO.setWebMtyDt(chargeCalculationContainerVO.getWebMtyDt().replace("-", ""));
			
			// 12. update harge Master Table  set Cahrge
			dbDao.modifyChargeCalculation(dmtChgCalcVO);
			
			if(chargeCalculationContainerVO.getDulTpExptFlg().equals("Y")) {
				// modify ORG_CHG_AMT, SC_RFA_EXPT_AMT of Dual Exception Charge
				dbDao.modifyOrgChgAmt(chgArgVO);
			}
			
			
			// 13.if Clock Stop applied  over one day Insert Clock Stop History
			/*******************************************************************************
			- case in exist Clock Stop applied data , create History.
			- logic
			  1. exists previous Clock Stop applied  data, delete History . (deleteClockStopHistory)
			  2. 적용된 Clock Stop 갯수만큼 반복문을 실행하며 Insert 한다( addClockStopHistory )
			*******************************************************************************/
			List<String> cStopNoList = retChgCalcCntrVO.getCStopNoList();
			
			if(cStopNoList != null && cStopNoList.size() > 0) {
				DmtChgTmCskStopVO dmtChgTmCskStopVO = new DmtChgTmCskStopVO();
				dmtChgTmCskStopVO.setSvrId(chargeCalculationContainerVO.getSvrId());
				dmtChgTmCskStopVO.setCntrNo(chargeCalculationContainerVO.getCntrNo());
				dmtChgTmCskStopVO.setCntrCycNo(chargeCalculationContainerVO.getCntrCycNo());
				dmtChgTmCskStopVO.setDmdtTrfCd(chargeCalculationContainerVO.getDmdtTrfCd());
				dmtChgTmCskStopVO.setDmdtChgLocDivCd(chargeCalculationContainerVO.getDmdtChgLocDivCd());
				dmtChgTmCskStopVO.setChgSeq(chargeCalculationContainerVO.getChgSeq());
				dmtChgTmCskStopVO.setCreOfcCd(account.getOfc_cd());
				
				modifyClockStopHistory(dmtChgTmCskStopVO, cStopNoList);
			}
			
			//14. insert Correction History
			corrHisSeq++;
			dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
			dbDao.addChargeHistory(dmtChgCorrHisVO);
			
			
			return resultVO;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify Charge by Container"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify Charge by Container"}).getMessage());
		}
	}
	
	
	/**
	 * search Balance Count.<br>
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBalanceCount(ChargeCalculationContainerVO chargeCalculationContainerVO) throws EventException {
		try {
			String returnValue = dbDao.searchBalanceCount(chargeCalculationContainerVO);
			return returnValue;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Manual Batch by POD ETA"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Manual Batch by POD ETA"}).getMessage());
		}
	}
	
	
	/**
	 * search POD ETA date.<br>
	 * 
	 * @param ManualChargeCreationVO[] manualChargeCreationVOs
	 * @return List<ManualChargeCreationVO>
	 * @exception EventException
	 */
	public List<ManualChargeCreationVO> searchPODEta(ManualChargeCreationVO[] manualChargeCreationVOs) throws EventException {
		try {
			List<ManualChargeCreationVO> list = new ArrayList<ManualChargeCreationVO>();
				
			for(int i=0; i < manualChargeCreationVOs.length; i++) {
				ManualChargeCreationVO manualChargeCreationVO = manualChargeCreationVOs[i];
				
				String vpsEtaDt	= dbDao.searchPODEta(manualChargeCreationVO);
				manualChargeCreationVO.setVpsEtaDt(vpsEtaDt);
				
				list.add(manualChargeCreationVO);
			}
				
			return list;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Manual Batch by POD ETA"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Manual Batch by POD ETA"}).getMessage());
		}
	}
	
	
	/**
	 * search VD Movement Date by Container <br>
	 * 
	 * @param VDMovementVO[] vdMovementVOs
	 * @return List<VDMovementVO>
	 * @exception EventException
	 */
	public List<VDMovementVO> searchVDMovementByPodEta(VDMovementVO[] vdMovementVOs) throws EventException {
		try {
			List<VDMovementVO> list = new ArrayList<VDMovementVO>();
				
			for(int i=0; i < vdMovementVOs.length; i++) {
				VDMovementVO vdMovementVO = vdMovementVOs[i];
				
				String fmMvmtDt = dbDao.searchVDMovementByPodEta(vdMovementVO);
				vdMovementVO.setFmMvmtDt(fmMvmtDt);
				
				list.add(vdMovementVO);
			}
				
			return list;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"VD Movement Date"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"VD Movement Date"}).getMessage());
		}
	}
	
	
	/**
	 * not created Charge inBatch ,  create Manually . <br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO createManualCharge(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account) throws EventException {
		try {
			DmtResultVO resultVO = new DmtResultVO();
			DMTGeneralChargeCalculationUtil dmtGeneralChargeCalculationUtil = new DMTGeneralChargeCalculationUtil();
			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			
			DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
			int corrHisSeq = 0;
			
			for(int i=0; i < chargeCalculationContainerVOs.length; i++) {
				ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs[i];
				chgCalcCntrVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt().replace("-",""));
				
				ChargeCalculationParmVO chgCalcParmVO = new ChargeCalculationParmVO();
				chgCalcParmVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgCalcParmVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgCalcParmVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgCalcParmVO.setDmdtTrfCd("DMIF");
				chgCalcParmVO.setDmdtChgLocDivCd("POD");
				chgCalcParmVO.setChgSeq("1");
				
				chgCalcParmVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				chgCalcParmVO.setCntrTpszCd(chgCalcCntrVO.getCntrTpszCd());
				chgCalcParmVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				chgCalcParmVO.setFmMvmtStsCd("VD");
				chgCalcParmVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				chgCalcParmVO.setIoBndCd("I");
				chgCalcParmVO.setToMvmtDt("");
				chgCalcParmVO.setToMvmtStsCd("");
				chgCalcParmVO.setToMvmtYdCd("");
				
				String custCntCd = "";
				String custSeq = "";
				
				if( chgCalcCntrVO.getCneeCd().equals("") && !chgCalcCntrVO.getNtfyCd().equals("") ) {
					custCntCd = chgCalcCntrVO.getNtfyCd().substring(0, 2);
					custSeq = chgCalcCntrVO.getNtfyCd().substring(2);
				} else if(!chgCalcCntrVO.getCneeCd().equals("")) {
					custCntCd = chgCalcCntrVO.getCneeCd().substring(0, 2);
					custSeq = chgCalcCntrVO.getCneeCd().substring(2);
				}
				
				custSeq = String.valueOf(NumberUtils.toInt(custSeq, 0));
				chgCalcParmVO.setCustCntCd(custCntCd);
				chgCalcParmVO.setCustSeq(custSeq);
				
				String actCustCd = chgCalcCntrVO.getArActCd();
				if(!actCustCd.equals("")) {
					chgCalcParmVO.setActCntCd(actCustCd.substring(0,2));
					chgCalcParmVO.setActCustSeq(String.valueOf(NumberUtils.toInt(actCustCd.substring(2), 0)));
				}
				
				String flag = dmtCalculationUtil.searchDualTypeException(chgCalcParmVO);
				
				if("Y".equals(flag)) {
					String errMsg = new ErrorHandler("DMT01063").getUserMessage();
					errMsg = errMsg.replace("Value", chgCalcParmVO.getCntrNo());
					
					resultVO.setResultCode("DMT01063");
					resultVO.setResultMsg(errMsg);
					return resultVO;
				}
				
				retChgCalcCntrVO = dmtGeneralChargeCalculationUtil.generalChargeCalculation(chgCalcParmVO);
				
				if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
					resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
					resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
					return resultVO;
				}
				
				
				// check  Booking Container info, and update or insert)
				ChargeArgumentVO chkChgArgVO = new ChargeArgumentVO();
				chkChgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
				chkChgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chkChgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				
				boolean chkExists = dbDao.checkChargeBookingContainerExists(chkChgArgVO);
				
				//  Update Charge Booking Container 
				if(chkExists) {
					DmtChgBkgCntrVO dmtChgBkgCntrVO = new DmtChgBkgCntrVO();
					dmtChgBkgCntrVO.setSvrId(chgCalcCntrVO.getSvrId());
					dmtChgBkgCntrVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					dmtChgBkgCntrVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());

					//dmtChgBkgCntrVO.setBkgNo(chgCalcCntrVO.getBkgNo());
					dmtChgBkgCntrVO.setBlNo(chgCalcCntrVO.getBlNo());
					dmtChgBkgCntrVO.setVslCd(chgCalcCntrVO.getVvdCd().substring(0, 4));
					dmtChgBkgCntrVO.setSkdVoyNo(chgCalcCntrVO.getVvdCd().substring(4, 8));
					dmtChgBkgCntrVO.setSkdDirCd(chgCalcCntrVO.getVvdCd().substring(8));
					//--------------------------------------------------------
					dmtChgBkgCntrVO.setVpsEtaDt(retChgCalcCntrVO.getVpsEtaDt());
					dmtChgBkgCntrVO.setScNo(retChgCalcCntrVO.getBrhScNo());
					dmtChgBkgCntrVO.setRfaNo(retChgCalcCntrVO.getBrhRfaNo());
					dmtChgBkgCntrVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
					dmtChgBkgCntrVO.setRepCmdtCd(retChgCalcCntrVO.getRepCmdtCd());
					dmtChgBkgCntrVO.setDcgoFlg(retChgCalcCntrVO.getDcgoFlg());
					dmtChgBkgCntrVO.setRcFlg(retChgCalcCntrVO.getRcFlg());
					dmtChgBkgCntrVO.setBbCgoFlg(retChgCalcCntrVO.getBbCgoFlg());
					dmtChgBkgCntrVO.setAwkCgoFlg(retChgCalcCntrVO.getAwkCgoFlg());
					dmtChgBkgCntrVO.setRdCgoFlg(retChgCalcCntrVO.getRdCgoFlg());
					dmtChgBkgCntrVO.setSocFlg(retChgCalcCntrVO.getSocFlg());
					dmtChgBkgCntrVO.setCntrPrtFlg(retChgCalcCntrVO.getCntrPrtFlg());
					dmtChgBkgCntrVO.setAdvShtgCd(retChgCalcCntrVO.getAdvShtgCd());
					dmtChgBkgCntrVO.setDmdtCntrTpCd(retChgCalcCntrVO.getCntrTp());
					dmtChgBkgCntrVO.setDmdtBkgCgoTpCd(retChgCalcCntrVO.getDmdtCgoTpCd());
					dmtChgBkgCntrVO.setPorCd(retChgCalcCntrVO.getPorCd());
					dmtChgBkgCntrVO.setPolCd(retChgCalcCntrVO.getPolCd());
					dmtChgBkgCntrVO.setPodCd(retChgCalcCntrVO.getPodCd());
					dmtChgBkgCntrVO.setDelCd(retChgCalcCntrVO.getDelCd());
					dmtChgBkgCntrVO.setBkgRcvTermCd(retChgCalcCntrVO.getBbRcvTermCd());
					dmtChgBkgCntrVO.setBkgDeTermCd(retChgCalcCntrVO.getBbDeTermCd());
					dmtChgBkgCntrVO.setBkgCntrQty(retChgCalcCntrVO.getBkgQty());
					dmtChgBkgCntrVO.setSlsOfcCd(retChgCalcCntrVO.getSalOfc());
					dmtChgBkgCntrVO.setRhqCd(retChgCalcCntrVO.getSalRhq());
					dmtChgBkgCntrVO.setUpdUsrId(account.getUsr_id());
					dmtChgBkgCntrVO.setUpdOfcCd(account.getOfc_cd());

					dbDao.modifyBookingContainer(dmtChgBkgCntrVO);
					
				} else {
					// add Charge Booking Container info.
					DmtChgBkgCntrVO dmtChgBkgCntrVO = new DmtChgBkgCntrVO();
					dmtChgBkgCntrVO.setSvrId(chgCalcCntrVO.getSvrId());
					dmtChgBkgCntrVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					dmtChgBkgCntrVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					dmtChgBkgCntrVO.setCntrTpszCd(chgCalcCntrVO.getCntrTpszCd());
					
					dmtChgBkgCntrVO.setBkgNo(chgCalcCntrVO.getBkgNo());
					dmtChgBkgCntrVO.setBlNo(chgCalcCntrVO.getBlNo());
					dmtChgBkgCntrVO.setVslCd(chgCalcCntrVO.getVvdCd().substring(0, 4));
					dmtChgBkgCntrVO.setSkdVoyNo(chgCalcCntrVO.getVvdCd().substring(4, 8));
					dmtChgBkgCntrVO.setSkdDirCd(chgCalcCntrVO.getVvdCd().substring(8));
					//--------------------------------------------------------
					dmtChgBkgCntrVO.setEstmTmOfArrDt(chgCalcCntrVO.getVpsEtaDt());
					dmtChgBkgCntrVO.setScNo(retChgCalcCntrVO.getBrhScNo());
					dmtChgBkgCntrVO.setRfaNo(retChgCalcCntrVO.getBrhRfaNo());
					dmtChgBkgCntrVO.setCustCntCd(chgCalcParmVO.getCustCntCd());
					dmtChgBkgCntrVO.setCustSeq(chgCalcParmVO.getCustSeq());
					
					dmtChgBkgCntrVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
					dmtChgBkgCntrVO.setRepCmdtCd(retChgCalcCntrVO.getRepCmdtCd());
					dmtChgBkgCntrVO.setDcgoFlg(retChgCalcCntrVO.getDcgoFlg());
					dmtChgBkgCntrVO.setRcFlg(retChgCalcCntrVO.getRcFlg());
					dmtChgBkgCntrVO.setBbCgoFlg(retChgCalcCntrVO.getBbCgoFlg());
					dmtChgBkgCntrVO.setAwkCgoFlg(retChgCalcCntrVO.getAwkCgoFlg());
					dmtChgBkgCntrVO.setRdCgoFlg(retChgCalcCntrVO.getRdCgoFlg());
					dmtChgBkgCntrVO.setSocFlg(retChgCalcCntrVO.getSocFlg());
					dmtChgBkgCntrVO.setCntrPrtFlg(retChgCalcCntrVO.getCntrPrtFlg());
					dmtChgBkgCntrVO.setAdvShtgCd(retChgCalcCntrVO.getAdvShtgCd());
					dmtChgBkgCntrVO.setDmdtCntrTpCd(retChgCalcCntrVO.getCntrTp());
					dmtChgBkgCntrVO.setDmdtBkgCgoTpCd(retChgCalcCntrVO.getDmdtCgoTpCd());
					dmtChgBkgCntrVO.setPorCd(retChgCalcCntrVO.getPorCd());
					dmtChgBkgCntrVO.setPolCd(retChgCalcCntrVO.getPolCd());
					dmtChgBkgCntrVO.setPodCd(retChgCalcCntrVO.getPodCd());
					dmtChgBkgCntrVO.setDelCd(retChgCalcCntrVO.getDelCd());
					dmtChgBkgCntrVO.setBkgRcvTermCd(retChgCalcCntrVO.getBbRcvTermCd());
					dmtChgBkgCntrVO.setBkgDeTermCd(retChgCalcCntrVO.getBbDeTermCd());
					dmtChgBkgCntrVO.setBkgCntrQty(retChgCalcCntrVO.getBkgQty());
					dmtChgBkgCntrVO.setSlsOfcCd(retChgCalcCntrVO.getSalOfc());
					dmtChgBkgCntrVO.setRhqCd(retChgCalcCntrVO.getSalRhq());
					dmtChgBkgCntrVO.setCreUsrId(account.getUsr_id());
					dmtChgBkgCntrVO.setCreOfcCd(account.getOfc_cd());
					dmtChgBkgCntrVO.setUpdUsrId(account.getUsr_id());
					dmtChgBkgCntrVO.setUpdOfcCd(account.getOfc_cd());
					
					// insert into DMT_CHG_BKG_CNTR 
					dbDao.addBkgCntr(dmtChgBkgCntrVO);
				} // if - end
				
				// add Charge (Insert into DMT_CHG_CALC)
				DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
				dmtChgCalcVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCalcVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCalcVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCalcVO.setDmdtTrfCd("DMIF");
				dmtChgCalcVO.setDmdtChgLocDivCd("POD");
				dmtChgCalcVO.setChgSeq("1");
				
				dmtChgCalcVO.setFmMvmtStsCd("VD");
				dmtChgCalcVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				dmtChgCalcVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				dmtChgCalcVO.setToMvmtStsCd("");
				dmtChgCalcVO.setToMvmtDt("");
				dmtChgCalcVO.setToMvmtYdCd("");
				dmtChgCalcVO.setNotCreBalFlg("N");
				dmtChgCalcVO.setFtDys(retChgCalcCntrVO.getFtDys());
				dmtChgCalcVO.setFtCmncDt(retChgCalcCntrVO.getFtCmncDt());
				dmtChgCalcVO.setFtEndDt(retChgCalcCntrVO.getFtEndDt());
				dmtChgCalcVO.setFxFtOvrDys(retChgCalcCntrVO.getFxFtOvrDys());
				dmtChgCalcVO.setOrgFtOvrDys(retChgCalcCntrVO.getOrgFtOvrDys());
				dmtChgCalcVO.setScRfaExptOvrDys(retChgCalcCntrVO.getScRfaExptOvrDys());
				dmtChgCalcVO.setAftExptOvrDys(retChgCalcCntrVO.getAftExptOvrDys());
				dmtChgCalcVO.setBzcTrfCurrCd(retChgCalcCntrVO.getBzcTrfCurrCd());
				dmtChgCalcVO.setDmdtTrfAplyTpCd(retChgCalcCntrVO.getDmdtTrfAplyTpCd());
				dmtChgCalcVO.setOrgChgAmt(retChgCalcCntrVO.getOrgChgAmt());
				dmtChgCalcVO.setScRfaExptAmt(retChgCalcCntrVO.getScRfaExptAmt());
				dmtChgCalcVO.setAftExptDcAmt(retChgCalcCntrVO.getAftExptDcAmt());
				dmtChgCalcVO.setBilAmt(retChgCalcCntrVO.getBilAmt());
				dmtChgCalcVO.setDmdtChgStsCd(retChgCalcCntrVO.getDmdtChgStsCd());
				
				dmtChgCalcVO.setScRfaAmt(retChgCalcCntrVO.getScRfaAmt());
				dmtChgCalcVO.setAftExptAmt(retChgCalcCntrVO.getAftExptAmt());
				dmtChgCalcVO.setBzcTrfSeq(retChgCalcCntrVO.getBzcTrfSeq());
				dmtChgCalcVO.setBzcTrfGrpSeq(retChgCalcCntrVO.getBzcTrfGrpSeq());
				dmtChgCalcVO.setBzcTrfAplyDt(retChgCalcCntrVO.getBzcTrfAplyDt());		
				dmtChgCalcVO.setRfaExptAproNo(retChgCalcCntrVO.getRfaExptAproNo());
				dmtChgCalcVO.setRfaExptDarNo(retChgCalcCntrVO.getRfaExptDarNo());
				dmtChgCalcVO.setRfaExptMapgSeq(retChgCalcCntrVO.getRfaExptMapgSeq());		
				dmtChgCalcVO.setRfaExptVerSeq(retChgCalcCntrVO.getRfaExptVerSeq());
				dmtChgCalcVO.setRfaRqstDtlSeq(retChgCalcCntrVO.getRfaRqstDtlSeq());
				dmtChgCalcVO.setAftExptAproNo(retChgCalcCntrVO.getAftExptAproNo());
				dmtChgCalcVO.setAftExptDarNo(retChgCalcCntrVO.getAftExptDarNo());
				dmtChgCalcVO.setAftExptAdjSeq(retChgCalcCntrVO.getAftExptAdjSeq());
				dmtChgCalcVO.setScNo(retChgCalcCntrVO.getBrhScNo());
				dmtChgCalcVO.setScExptVerSeq(retChgCalcCntrVO.getScExptVerSeq());
				dmtChgCalcVO.setScExptGrpSeq(retChgCalcCntrVO.getScExptGrpSeq());
				dmtChgCalcVO.setScRfaExptAplyDt(retChgCalcCntrVO.getScRfaExptAplyDt());
				dmtChgCalcVO.setCorrRmk("Manual Batch by POD ETA");
				
				dmtChgCalcVO.setOfcCd(retChgCalcCntrVO.getOfcCd());
				dmtChgCalcVO.setOfcRhqCd(retChgCalcCntrVO.getOfcRhq());
				dmtChgCalcVO.setCustCntCd(chgCalcParmVO.getCustCntCd());
				dmtChgCalcVO.setCustSeq(chgCalcParmVO.getCustSeq());
				dmtChgCalcVO.setActCntCd(chgCalcParmVO.getActCntCd());
				dmtChgCalcVO.setActCustSeq(chgCalcParmVO.getActCustSeq());
				dmtChgCalcVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
				dmtChgCalcVO.setCmdtTrfSeq(retChgCalcCntrVO.getCmdtTrfSeq());
				dmtChgCalcVO.setCmdtExptAplyDt(retChgCalcCntrVO.getCmdtExptAplyDt());
				dmtChgCalcVO.setCmdtOvrDys(retChgCalcCntrVO.getCmdtOvrDys());
				dmtChgCalcVO.setCmdtExptAmt(retChgCalcCntrVO.getCmdtExptAmt());
				dmtChgCalcVO.setWebMtyDt(retChgCalcCntrVO.getMtDate());
				dmtChgCalcVO.setCreUsrId(account.getUsr_id());
				dmtChgCalcVO.setCreOfcCd(account.getOfc_cd());
				dmtChgCalcVO.setUpdUsrId(account.getUsr_id());
				dmtChgCalcVO.setUpdOfcCd(account.getOfc_cd());
				
				// insert into  DMT_CHG_CALC
				dbDao.addCharge(dmtChgCalcVO);
			
				dmtChgCorrHisVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCorrHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCorrHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCorrHisVO.setDmdtTrfCd("DMIF");
				dmtChgCorrHisVO.setDmdtChgLocDivCd("POD");
				dmtChgCorrHisVO.setChgSeq("1");
				dmtChgCorrHisVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				dmtChgCorrHisVO.setCorrHisRmk("Manual Charge Creation");
				dmtChgCorrHisVO.setCreUsrId(account.getUsr_id());
				dmtChgCorrHisVO.setCreOfcCd(account.getOfc_cd());
				
				++corrHisSeq;
				dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
				dbDao.addChargeHistory(dmtChgCorrHisVO);
				
			} // for - end
			
			return resultVO;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"create Manual Charge"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"create Manual Charge"}).getMessage());
		}
	}
	
	
	
	/**
	 * save CHARGE HISTORY.<br>
	 * 
	 * @param InvoiceIssueMgtVO invoiceIssueMgtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeChargeStatusForInvoice(InvoiceIssueMgtVO invoiceIssueMgtVO, SignOnUserAccount account) throws EventException {
		List<InvoiceIssueVO> invoiceIssueList = null;
		ChargeBookingInvoiceVO chargeBookinInvoiceVO = new ChargeBookingInvoiceVO();
		try {
			invoiceIssueList = invoiceIssueMgtVO.getInvoiceIssueVOs();
			chargeBookinInvoiceVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();
			
			for(int i = 0 ; i < invoiceIssueList.size() ; i++) {
    			InvoiceIssueVO invoiceIssueParam = (InvoiceIssueVO)invoiceIssueList.get(i);
    			//전체는 Truck를 update한다. 
    			com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO closingChargeArgumentVO = new com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO();
                closingChargeArgumentVO.setSvrId(invoiceIssueParam.getSvrId());
                closingChargeArgumentVO.setCntrNo(invoiceIssueParam.getCntrNo());
                closingChargeArgumentVO.setCntrCycNo(invoiceIssueParam.getCntrCycNo());
                closingChargeArgumentVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
                closingChargeArgumentVO.setDmdtChgLocDivCd(invoiceIssueParam.getDmdtChgLocDivCd());
                closingChargeArgumentVO.setChgSeq(invoiceIssueParam.getChgSeq());
                closingChargeArgumentVO.setTruckerCd(chargeBookinInvoiceVO.getTruckerCd());
                
                log.debug("\n trunck_cd ==>"+chargeBookinInvoiceVO.getTruckerCd());
 				
                //dbDao.modifyInvoiceNoByInvoice(closingChargeArgumentVO, account.getUsr_id(), account.getOfc_cd());
                dbDao.modifyChargeTruckerByInvoice(closingChargeArgumentVO, account.getUsr_id(), account.getOfc_cd());

    			// checked data , UPDATE to "U" 
    			if(invoiceIssueParam.getIbflag().equals("U")){
    			
    			
	    			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = new com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
	    			chargeArgumentVO.setSvrId(invoiceIssueParam.getSvrId());
	    			chargeArgumentVO.setCntrNo(invoiceIssueParam.getCntrNo());
	    			chargeArgumentVO.setCntrCycNo(invoiceIssueParam.getCntrCycNo());
	    			chargeArgumentVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
	    			chargeArgumentVO.setDmdtChgLocDivCd(invoiceIssueParam.getDmdtChgLocDivCd());
	    			chargeArgumentVO.setChgSeq(invoiceIssueParam.getChgSeq());
	    			
					int corrHisSeq = dmtCalculationUtil.checkChargeCorrection(chargeArgumentVO);
	    			
					DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
					dmtChgCorrHisVO.setSvrId(invoiceIssueParam.getSvrId());
					dmtChgCorrHisVO.setCntrNo(invoiceIssueParam.getCntrNo());
					dmtChgCorrHisVO.setCntrCycNo(invoiceIssueParam.getCntrCycNo());
					dmtChgCorrHisVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
					dmtChgCorrHisVO.setDmdtChgLocDivCd(invoiceIssueParam.getDmdtChgLocDivCd());
					dmtChgCorrHisVO.setChgSeq(invoiceIssueParam.getChgSeq());
					dmtChgCorrHisVO.setCorrHisRmk("");
					dmtChgCorrHisVO.setCreUsrId(account.getUsr_id());
					dmtChgCorrHisVO.setCreOfcCd(account.getOfc_cd());
	    		
					if(corrHisSeq == 0) {
						corrHisSeq++;
						dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
						dbDao.addChargeHistory(dmtChgCorrHisVO);
					}
					
					closingChargeArgumentVO = new com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO();
					closingChargeArgumentVO.setSvrId(invoiceIssueParam.getSvrId());
					closingChargeArgumentVO.setCntrNo(invoiceIssueParam.getCntrNo());
					closingChargeArgumentVO.setCntrCycNo(invoiceIssueParam.getCntrCycNo());
					closingChargeArgumentVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
					closingChargeArgumentVO.setDmdtChgLocDivCd(invoiceIssueParam.getDmdtChgLocDivCd());
					closingChargeArgumentVO.setChgSeq(invoiceIssueParam.getChgSeq());
					closingChargeArgumentVO.setDmdtChgStsCd("I");//dmdt_chg_sts_cd
					closingChargeArgumentVO.setDmdtInvNo(chargeBookinInvoiceVO.getDmdtInvNo());
					
					dbDao.modifyChargeStatusByInvoice(closingChargeArgumentVO, account.getUsr_id(), account.getOfc_cd());
					
					corrHisSeq++;
					dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
					dmtChgCorrHisVO.setCorrHisRmk("Invoice Creation");
					dbDao.addChargeHistory(dmtChgCorrHisVO);
    			}
			}
		
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"change Charge Status For Invoice"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"change Charge Status For Invoice"}).getMessage());
		}
	}
	
	
	/**
	 *  search calculated contents about Basic and Exception Tariff of Container Charge  and  Clock Stop .<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return ChargeCalculationDetailVO
	 * @exception EventException
	 */
	public ChargeCalculationDetailVO searchChargeDetail(ChargeArgumentVO chargeArgumentVO) throws EventException {
		try {
			ChargeCalculationDetailVO chgCalcDtlVO = new ChargeCalculationDetailVO();
			
			// search Charge Amount 
			ChargeDetailVO chgDtlVO = dbDao.chargeDetail(chargeArgumentVO);
			chgCalcDtlVO.setChargeDetailVO(chgDtlVO);
			
			
			CalculationAMTVO calculationAMTVO = null;
			List<ChrgDtlVO> list = null;
				
			// basicFreeTime(String z_svr_id, String z_dtt_code, long z_dtn_seq, long z_dtg_grp_id, long z_dbc_bkg_qty) BKG_CNTR_QTY
			long bzcTrfSeq		= NumberUtils.toLong(chgDtlVO.getBzcTrfSeq(), 0);
			long bzcTrfGrpSeq	= NumberUtils.toLong(chgDtlVO.getBzcTrfGrpSeq(), 0);
			long bkgCntrQty		= NumberUtils.toLong(chgDtlVO.getBkgCntrQty(), 0);
			//String svrID		= chargeArgumentVO.getSvrId();
			String dmdtTrfCd	= chargeArgumentVO.getDmdtTrfCd();
			
			
			// if it is O/T, then get fist SVR_ID. ( check include weekend, holiday of Basic Tariff)
			String firstSvrID = null;
			
			if(chgDtlVO.getOfcTrnsFlg().equals("Y")) {
				ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
				chargeCalculationParmVO.setBkgNo(chargeArgumentVO.getBkgNo());
				chargeCalculationParmVO.setCntrNo(chargeArgumentVO.getCntrNo());
				chargeCalculationParmVO.setCntrCycNo(chargeArgumentVO.getCntrCycNo());
				chargeCalculationParmVO.setDmdtTrfCd(chargeArgumentVO.getDmdtTrfCd());
				chargeCalculationParmVO.setDmdtChgLocDivCd(chargeArgumentVO.getDmdtChgLocDivCd());
				
				firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
			} else
				firstSvrID = chargeArgumentVO.getSvrId();
			
			
			long bzcFreeTime	= dmtCalculationUtil.basicFreeTime(firstSvrID, dmdtTrfCd, bzcTrfSeq, bzcTrfGrpSeq, bkgCntrQty);
			
			if(chargeArgumentVO.getDmdtChgLocDivCd().equals("TSP")) {
				/*
				 * T/S Demurrage Free Time
				 * 1) locCd: DEBRE, DEHAM --> bzcFreeTime = 7;
				 * 2) locCd: NLRTM, BEANR --> 
				 * 							  fm_mvmt_dt <=  2010/10/09 --> bzcFreeTime = 7
				 * 							  fm_mvmt_dt >   2010/10/09 --> bzcFreeTime = 10
				 */
				String locCd = chargeArgumentVO.getFmMvmtYdCd().substring(0, 5);
				
				if(locCd.equals("DEBRE") || locCd.equals("DEHAM")) {
					bzcFreeTime = 7;
				} else {
					String fmMvmtDt = StringUtils.defaultString(chargeArgumentVO.getFmMvmtDt());
					if( "20101009".compareTo(fmMvmtDt) >= 0 ) {
						bzcFreeTime = 7;
					} else {
						bzcFreeTime = 10;
					}
				}
			}
			
			
			BasicTariffParmVO bzcTrfParmVO = new BasicTariffParmVO();
			bzcTrfParmVO.setSvrId(firstSvrID);
			bzcTrfParmVO.setDmdtTrfCd(chargeArgumentVO.getDmdtTrfCd());
			bzcTrfParmVO.setDmdtChgLocDivCd(chargeArgumentVO.getDmdtChgLocDivCd());
			bzcTrfParmVO.setTrfSeq(chgDtlVO.getBzcTrfSeq());
			bzcTrfParmVO.setTrfGrpSeq(chgDtlVO.getBzcTrfGrpSeq());
			
			// Currency Code, Coverage Code 
			BasicCurrencyCoverageVO basicCurrencyCoverageVO = dbDao.searchBasicCurrencyCoverage(bzcTrfParmVO);
			
			
			// ********** DivOverDay
			OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
			overdayNDivParmVO.setSvrId(chargeArgumentVO.getSvrId());
			overdayNDivParmVO.setCntrNo(chargeArgumentVO.getCntrNo());
			overdayNDivParmVO.setCnmvCycNo(chargeArgumentVO.getCntrCycNo());
			overdayNDivParmVO.setDttCode(chargeArgumentVO.getDmdtTrfCd());
			overdayNDivParmVO.setLocDiv(chargeArgumentVO.getDmdtChgLocDivCd());
			overdayNDivParmVO.setDccSeq(chargeArgumentVO.getChgSeq());
			
			OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
			
			
			// ********** basicCalculation - Baisc Tariff
			CalculationParmVO calculationParmVO = new CalculationParmVO();
			
			calculationParmVO.setSvrId(firstSvrID);
			calculationParmVO.setDmdtTrfCd(chargeArgumentVO.getDmdtTrfCd());
			calculationParmVO.setTrfSeq(chgDtlVO.getBzcTrfSeq());
			calculationParmVO.setTrfGrpSeq(chgDtlVO.getBzcTrfGrpSeq());
			calculationParmVO.setCntrts(chgDtlVO.getCntrTpszCd());
			calculationParmVO.setOverDay(chgDtlVO.getOrgFtOvrDys());			
			calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
			calculationParmVO.setCurCd(chgDtlVO.getBzcTrfCurrCd());
				
			
			if(!"Y".equals(chgDtlVO.getDulTpExptFlg())) {
				calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
			
				// ##### Basic Tariff VO
				ChargeBasicFreeTimeVO orgChgBzcFtVO = dbDao.chargeBasicTariff(bzcTrfParmVO);
				
				List<ChargeBasicFreeTimeVO> chgBzcFtVOs = new ArrayList<ChargeBasicFreeTimeVO>();
				list = calculationAMTVO.getChrgDtlVOS();
				
				if(list != null && list.size() > 0) {
					int totOrgFtOvrDys = 0;
					
					for(int i=0; i < list.size(); i++) {
						ChrgDtlVO vo = list.get(i);
						
						ChargeBasicFreeTimeVO chgBzcFtVO = new ChargeBasicFreeTimeVO();
						chgBzcFtVO.setBzcTrfAplyDt(chgDtlVO.getBzcTrfAplyDt());
						chgBzcFtVO.setCvrgCd(basicCurrencyCoverageVO.getCvrgCd());

						chgBzcFtVO.setFtDys(String.valueOf(bzcFreeTime));
						chgBzcFtVO.setXcldSatFlg(orgChgBzcFtVO.getXcldSatFlg());
						chgBzcFtVO.setXcldSunFlg(orgChgBzcFtVO.getXcldSunFlg());
						chgBzcFtVO.setXcldHolFlg(orgChgBzcFtVO.getXcldHolFlg());
						
						totOrgFtOvrDys += NumberUtils.toInt(vo.getRtDay(), 0);
						
						chgBzcFtVO.setOrgFtOvrDys(vo.getRtDay());
						chgBzcFtVO.setCurrCd(basicCurrencyCoverageVO.getCurrCd());
						chgBzcFtVO.setFtOvrUndDys(vo.getRtOver() + "-" + (vo.getRtUnder().equals("0") ? "" : vo.getRtUnder()));	// + vo.getRtUnder());
						chgBzcFtVO.setCntrFtRtAmt(vo.getRtRate());
						chgBzcFtVO.setBzcChgCalc(vo.getRtChrg());
						
						chgBzcFtVOs.add(chgBzcFtVO);
					}
					
					if(list.size() > 1) {
						String orgFtOvrDys = String.valueOf(totOrgFtOvrDys);
						for(int i=0; i < list.size(); i++) {
							chgBzcFtVOs.get(i).setOrgFtOvrDys(orgFtOvrDys);
						}
					}
					
				} else { //if(list.size() == 0) {
				
					ChargeBasicFreeTimeVO chgBzcFtVO = new ChargeBasicFreeTimeVO();
					//log.debug(" list.size() == 0");	
					//log.debug(" orgChgBzcFtVO.getXcldSatFlg() = " + orgChgBzcFtVO.getXcldSatFlg());
					chgBzcFtVO.setBzcTrfAplyDt(chgDtlVO.getBzcTrfAplyDt());
					chgBzcFtVO.setCvrgCd(basicCurrencyCoverageVO.getCvrgCd());
					chgBzcFtVO.setCurrCd(basicCurrencyCoverageVO.getCurrCd());
	
					chgBzcFtVO.setXcldSatFlg(orgChgBzcFtVO.getXcldSatFlg());
					chgBzcFtVO.setXcldSunFlg(orgChgBzcFtVO.getXcldSunFlg());
					chgBzcFtVO.setXcldHolFlg(orgChgBzcFtVO.getXcldHolFlg());
					chgBzcFtVO.setFtDys(String.valueOf(bzcFreeTime));
					chgBzcFtVO.setOrgFtOvrDys(chgDtlVO.getOrgFtOvrDys());
					
					chgBzcFtVOs.add(chgBzcFtVO);
				}
				
				chgCalcDtlVO.setChargeBasicFreeTimeVOs(chgBzcFtVOs);
			}
				
			
			
			// [Commodity Code <> null]
			if(!chgDtlVO.getCmdtCd().equals("")) {
				
				CommodityTariffParmVO cmdtTrfParmVO = new CommodityTariffParmVO();
				cmdtTrfParmVO.setSvrId(chargeArgumentVO.getSvrId());
				cmdtTrfParmVO.setDmdtTrfCd(chargeArgumentVO.getDmdtTrfCd());
				cmdtTrfParmVO.setTrfSeq(chgDtlVO.getBzcTrfSeq());
				cmdtTrfParmVO.setCmdtCd(chgDtlVO.getCmdtCd());
				cmdtTrfParmVO.setCmdtTrfSeq(chgDtlVO.getCmdtTrfSeq());
				
				//check include Free Time, weekend and  holiday of  Commodity Exception Tariff  
				CommodityGroupTariffVO cmdtGrpTrfVO = dbDao.chargeCommodityTariff(cmdtTrfParmVO);
				
				if(cmdtGrpTrfVO != null) {
					cmdtGrpTrfVO.setCmdtExptAplyDt(chgDtlVO.getCmdtExptAplyDt());
					cmdtGrpTrfVO.setCmdtCd(chgDtlVO.getCmdtCd());
					cmdtGrpTrfVO.setCmdtOvrDys(chgDtlVO.getCmdtOvrDys());
					cmdtGrpTrfVO.setCurrCd(basicCurrencyCoverageVO.getCurrCd());
					cmdtGrpTrfVO.setCmdtExptAmt(chgDtlVO.getCmdtExptAmt());
					
					calculationParmVO.setOverDay(chgDtlVO.getCmdtOvrDys());			
					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
					
					calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
					list = calculationAMTVO.getChrgDtlVOS();
					
					double cmdtChgAmt = 0.0d;
					
					if(list != null && list.size() > 0) {
						for(int i=0; i < list.size(); i++) {
							ChrgDtlVO vo = list.get(i);
							cmdtChgAmt += NumberUtils.toDouble(vo.getRtChrg());
						}
						cmdtGrpTrfVO.setCmdtExptAmt(String.valueOf(cmdtChgAmt));
					}
					
					List<CommodityGroupTariffVO> commodityGroupTariffVOs = new ArrayList<CommodityGroupTariffVO>();
					commodityGroupTariffVOs.add(cmdtGrpTrfVO);
					chgCalcDtlVO.setCommodityGroupTariffVOs(commodityGroupTariffVOs);
				}
			}
			
			
			// [RFA DAR No <> NULL] 
			if(!chgDtlVO.getRfaExptDarNo().equals("")) {
				BeforeExceptionTariffVO rfaExptTrfVO = dbDao.chargeBeforeException(chgDtlVO);
				
				if(rfaExptTrfVO != null) {
					rfaExptTrfVO.setScRfaExptAplyDt(chgDtlVO.getScRfaExptAplyDt());
					rfaExptTrfVO.setScRfaExptOvrDys(chgDtlVO.getScRfaExptOvrDys());
					rfaExptTrfVO.setBzcTrfCurrCd(chgDtlVO.getBzcTrfCurrCd());
					rfaExptTrfVO.setScRfaExptAmt(chgDtlVO.getScRfaAmt());
					
					List<BeforeExceptionTariffVO> beforeExceptionTariffVOs = new ArrayList<BeforeExceptionTariffVO>();
					beforeExceptionTariffVOs.add(rfaExptTrfVO);
					chgCalcDtlVO.setBeforeExceptionTariffVOs(beforeExceptionTariffVOs);
				}
			}
				
			
			// [SC No <> NULL] 
			if(!chgDtlVO.getScNo().equals("")) {
				SCExceptionTariffVO scExptTrfVO = dbDao.chargeSCException(chgDtlVO);
				
				if(scExptTrfVO != null) {
					scExptTrfVO.setScRfaExptAplyDt(chgDtlVO.getScRfaExptAplyDt());
					scExptTrfVO.setScRfaExptOvrDys(chgDtlVO.getScRfaExptOvrDys());
					scExptTrfVO.setBzcTrfCurrCd(chgDtlVO.getBzcTrfCurrCd());
					scExptTrfVO.setScRfaExptAmt(chgDtlVO.getScRfaAmt());
					
					List<SCExceptionTariffVO> scExceptionTariffVOs = new ArrayList<SCExceptionTariffVO>();
					scExceptionTariffVOs.add(scExptTrfVO);
					chgCalcDtlVO.setScExceptionTariffVOs(scExceptionTariffVOs);
				}
			}
				
				
			// [AFTER DAR No <> NULL]
			if(!chgDtlVO.getAftExptDarNo().equals("")) {
				// AfterExceptionTariffParmVO 
				AfterExceptionTariffParmVO aftExptTrfParmVO = new AfterExceptionTariffParmVO();
				aftExptTrfParmVO.setAftExptDarNo(chgDtlVO.getAftExptDarNo());
				aftExptTrfParmVO.setAftExptAdjSeq(chgDtlVO.getAftExptAdjSeq());
				aftExptTrfParmVO.setSvrId(chargeArgumentVO.getSvrId());
				aftExptTrfParmVO.setCntrNo(chargeArgumentVO.getCntrNo());
				aftExptTrfParmVO.setCntrCycNo(chargeArgumentVO.getCntrCycNo());
				aftExptTrfParmVO.setDmdtTrfCd(chargeArgumentVO.getDmdtTrfCd());
				aftExptTrfParmVO.setDmdtChgLocDivCd(chargeArgumentVO.getDmdtChgLocDivCd());
				
				// check include Free Time, weekend and  holiday of  After Discount ,
				// search Currency, Discount Ratio or Discount Amount
				AfterExceptionTariffVO aftExptTrfVO = dbDao.chargeAfterException(aftExptTrfParmVO);
				
				if(aftExptTrfVO != null) {
					aftExptTrfVO.setAftExptAproNo(chgDtlVO.getAftExptAproNo());
					aftExptTrfVO.setAftExptOvrDys(chgDtlVO.getAftExptOvrDys());
					
					List<AfterExceptionTariffVO> afterExceptionTariffVOs = new ArrayList<AfterExceptionTariffVO>();
					afterExceptionTariffVOs.add(aftExptTrfVO);
					chgCalcDtlVO.setAfterExceptionTariffVOs(afterExceptionTariffVOs);
				}
			}
						
			//  search Clock Stop that applied charge.
			List<ClockStopVO> clockStopVOs = dbDao.chargeClockStop(chargeArgumentVO);
			
			if(clockStopVOs != null) {
				chgCalcDtlVO.setClockStopVOs(clockStopVOs);
			}
			
			return chgCalcDtlVO;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge Detail"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge Detail"}).getMessage());
		}
	}
	
	
	/**
	 * search Container Charge List by SZPBB Office created .<br>
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchChargeBySZPBB(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws EventException {
		try {
			return dbDao.searchChargeBySZPBB(chargeByOfficeOrVVDVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge by SZPBB"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge by SZPBB"}).getMessage());
		}
	}
	
	
	/**
	 * search  Movement Data about charge created by SZPBB Office <br>
	 * 
	 * @param MovementSZPBBParmVO[] movementSZPBBParmVOs
	 * @return List<MovementSZPBBVO>
	 * @exception EventException
	 */
	public List<MovementSZPBBVO> searchMovementBySZPBB(MovementSZPBBParmVO[] movementSZPBBParmVOs) throws EventException {
		try {
			List<MovementSZPBBVO> list = new ArrayList<MovementSZPBBVO>();
			
			for(int i=0; i < movementSZPBBParmVOs.length; i++) {
				MovementSZPBBParmVO movementSZPBBParmVO = movementSZPBBParmVOs[i];
				MovementSZPBBVO movementSZPBBVO = dbDao.searchMovementBySZPBB(movementSZPBBParmVO);
				
				if(movementSZPBBVO != null)
					list.add(movementSZPBBVO);
			}
			
			return list;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Movement by SZPBB"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Movement by SZPBB"}).getMessage());
		}
	}
	
	
	/**
	 * create "DMOF', "DMIF" Charge of SZPBB Office<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO createChargeBySZPBB(ChargeCalculationContainerVO[] chargeCalculationContainerVOs,
				SignOnUserAccount account) throws EventException {
		
		DmtResultVO resultVO = new DmtResultVO();
		List<ChargeCalculationContainerVO> list = new ArrayList<ChargeCalculationContainerVO>();
		
		com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffParmVO basicTariffParmVO = null;
		basicTariffParmVO = new com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffParmVO();
		
		LocationByBoundParmVO	locationByBoundParmVO	= new LocationByBoundParmVO();
		FreeTimeStartParmVO		freeTimeStartParmVO		= new FreeTimeStartParmVO();
		FreeTimeEndParmVO 		freeTimeEndParmVO		= new FreeTimeEndParmVO();
		OverdayNStatusParmVO	overdayNStatusParmVO	= new OverdayNStatusParmVO();
		CalculationParmVO 		calculationParmVO		= new CalculationParmVO();
		
		List<String> cstop_no_list = new ArrayList<String>();
		long idx_cstop	= 0;
		
		
		//try {
			
			/* ******************** logic ******************************************
			1.  for loop to count of Parameter from UI 
			    A) search  Booking Container info of previous created Charge 
			    B) set Effective Date
			         a) "DMOF" - set   "OC" Date
			         b) "DMIF" - set POD ETA
			    C) search Basic Tariff info.
			    D) set Free Time Start Date
			         a) if "DMIF" and  From Movement is "VD" and From Yardis equals POD, then set Free Time start date of VL/VD UPDATE info
			         b) if it's not a),  Call  searchFreeTimeStart( except Clock Stop)
			    E) set Free Time End Date
			         a) Call searchFreeTimeEnd( except Clock Stop)
			         b) if TrfCd id  "DMOF" and  To Movement status is "VL" , then set Free Time end date of VL/VD UPDATE info.
			    F) calculate Free Time Overdays
			    G) in F), if Status is  "F" or  "L" then calculate Charge
			    H) save Charge
			**************************************************************************/
			
			for ( int i=0; i < chargeCalculationContainerVOs.length; i++ ) {
				ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs[i];
				
				ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
				//chgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				//chgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				chgArgVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				
				// A)  search  Booking Container  info of previous createdCharge
				BkgContainerInfoVO bkgCntrInfoVO = null;
				
				try {
					bkgCntrInfoVO = dbDao.searchBookingContainerBySZPBB(chgArgVO);
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler("DMT00006", new String[]{"Booking Container by SZPBB"}).getMessage());
				}
				
				String effDt = "";
				String ioBndCd = "";
				
				// B) set Effective Date
				try {
					if(chgCalcCntrVO.getDmdtTrfCd().equals("DMOF")) {
						ioBndCd = "O";
						//effDt = dmtCalculationUtil.getMinOCVLDate(chgCalcCntrVO.getCntrNo(), NumberUtils.toLong(chgCalcCntrVO.getCntrCycNo()), "OC");
						effDt = chgCalcCntrVO.getFmMvmtDt();
					} else if(chgCalcCntrVO.getDmdtTrfCd().equals("DMIF")) {
						ioBndCd = "I";
						VVDNEtaVO vvEtaVO = dmtCalculationUtil.searchVVDNEta(chgCalcCntrVO.getBkgNo(), bkgCntrInfoVO.getPolCd(), bkgCntrInfoVO.getPodCd(), ioBndCd);
						effDt = vvEtaVO.getVpsEtaDt();
					}
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler("DMT00008", new String[]{"create Charge by SZPBB"}).getMessage());
				}
				
				
				locationByBoundParmVO.setIoBnd(ioBndCd);
				locationByBoundParmVO.setPorCntCd(bkgCntrInfoVO.getPorCntCd());
				locationByBoundParmVO.setPorRgnCd(bkgCntrInfoVO.getPorRgnCd());
				locationByBoundParmVO.setPorStateCd(bkgCntrInfoVO.getPorSteCd());
				locationByBoundParmVO.setPorLocCd(bkgCntrInfoVO.getPorCd());

				locationByBoundParmVO.setDelCntCd(bkgCntrInfoVO.getDelCntCd());
				locationByBoundParmVO.setDelRgnCd(bkgCntrInfoVO.getDelRgnCd());
				locationByBoundParmVO.setDelStateCd(bkgCntrInfoVO.getDelSteCd());
				locationByBoundParmVO.setDelLocCd(bkgCntrInfoVO.getDelCd());

				LocationByBoundVO locationByBoundVO = dmtCalculationUtil.setLocationByBound(locationByBoundParmVO);
				String bkgCntCd		=	locationByBoundVO.getBkgCntCd();
				String bkgRgnCd	  	=	locationByBoundVO.getBkgRgnCd();
				String bkgStateCd	=	locationByBoundVO.getBkgStateCd();
				String bkgLocCd  	=	locationByBoundVO.getBkgLocCd();
				
				// [logic] Awkward In/Out-Gauge
				String awkInOut = null;
				try {
					awkInOut = dmtCalculationUtil.searchInOutGauge(chgCalcCntrVO.getCntrNo(), chgCalcCntrVO.getBkgNo());
				} catch (Exception ex) {
					//throw new EventException("Get the Awkward Cargo in/out-gauge Error!", e);
					throw new EventException(new ErrorHandler("DMT00006", new String[]{"the Awkward Cargo in/out-gauge"}).getMessage());
				}
				
				log.debug(" bkgCntrInfoVO.getFmMvmtYdCd() *******" + bkgCntrInfoVO.getFmMvmtYdCd());
				// C) search Basic Tariff 정보
				basicTariffParmVO.setCvrgYdCd(bkgCntrInfoVO.getFmMvmtYdCd());
				basicTariffParmVO.setPorContiCd(bkgCntrInfoVO.getPorContiCd());
				basicTariffParmVO.setPorCntCd(bkgCntrInfoVO.getPorCntCd());
				basicTariffParmVO.setPorRgnCd(bkgCntrInfoVO.getPorRgnCd());
				basicTariffParmVO.setPorSteCd(bkgCntrInfoVO.getPorSteCd());
				basicTariffParmVO.setPorLocCd(bkgCntrInfoVO.getPorCd());

				basicTariffParmVO.setYrdContiCd(bkgCntrInfoVO.getYrdContiCd());
				basicTariffParmVO.setYrdCntCd(bkgCntrInfoVO.getYrdCntCd());
				basicTariffParmVO.setYrdRgnCd(bkgCntrInfoVO.getYrdRgnCd());
				basicTariffParmVO.setYrdSteCd(bkgCntrInfoVO.getYrdSteCd());
				basicTariffParmVO.setYrdLocCd(bkgCntrInfoVO.getFmMvmtYdCd().substring(0, 5));

				basicTariffParmVO.setPolContiCd(bkgCntrInfoVO.getPolContiCd());
				basicTariffParmVO.setPolCntCd(bkgCntrInfoVO.getPolCntCd());
				basicTariffParmVO.setPolRgnCd(bkgCntrInfoVO.getPolRgnCd());
				basicTariffParmVO.setPolSteCd(bkgCntrInfoVO.getPolSteCd());
				basicTariffParmVO.setPolLocCd(bkgCntrInfoVO.getPolCd());

				basicTariffParmVO.setDelContiCd(bkgCntrInfoVO.getDelContiCd());
				basicTariffParmVO.setDelCntCd(bkgCntrInfoVO.getDelCntCd());
				basicTariffParmVO.setDelRgnCd(bkgCntrInfoVO.getDelRgnCd());
				basicTariffParmVO.setDelSteCd(bkgCntrInfoVO.getDelSteCd());
				basicTariffParmVO.setDelLocCd(bkgCntrInfoVO.getDelCd());

				basicTariffParmVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				basicTariffParmVO.setEffDt(effDt);
				basicTariffParmVO.setDmdtCntrTpCd(bkgCntrInfoVO.getDmdtCntrTpCd());
				basicTariffParmVO.setDmdtCgoTpCd(bkgCntrInfoVO.getDmdtBkgCgoTpCd());
				basicTariffParmVO.setIoBndCd(ioBndCd);
				basicTariffParmVO.setAwkInOut(awkInOut);
				basicTariffParmVO.setSuthChnUseFlg("Y");
				
				BasicTariffKeyVO basicTariffKeyVO = null;
				try {
					basicTariffKeyVO = dmtCalculationUtil.searchBasicTariffByGeneration(basicTariffParmVO);
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler("DMT00006", new String[]{"Basic Tariff"}).getMessage());
				}
				

				if(DMTCalculationUtil.nullToString(basicTariffKeyVO.getSvrId()).equals("")){
					resultVO.setResultCode("-1");
					resultVO.setResultMsg("Basic Tariff Not Found!");
					return resultVO;
				}
				/*else {
					z_svr_id			= DMTCalculationUtil.nullToString(basicTariffKeyVO.getSvrId());
					z_dtt_code			= DMTCalculationUtil.nullToString(basicTariffKeyVO.getDmdtTrfCd());
					z_dtn_seq 			= DMTCalculationUtil.stringToLong(basicTariffKeyVO.getTrfSeq());
					z_dtg_grp_id		= DMTCalculationUtil.stringToLong(basicTariffKeyVO.getTrfGrpSeq());

					dtg_cmnc_tp			= DMTCalculationUtil.nullToString(basicTariffKeyVO.getDmdtChgCmncTpCd());
					dtg_cmnc_hr			= DMTCalculationUtil.nullToString(basicTariffKeyVO.getCmncHr());
					dtg_excl_sat		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldSatFlg());
					dtg_excl_sun		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldSunFlg());
					dtg_excl_holi		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldHolFlg());
					z_cur_cd			= DMTCalculationUtil.nullToString(basicTariffKeyVO.getCurrCd());
				}*/
				

				/*
				[logic] get Basic Tariff의 Free days  : Get Basic Free Days
				>>>>> z_dbc_bkg_qty -> Booking의 Container count
				*/
				String ftDys = "";
				
				try {
					long trfSeq = NumberUtils.toLong(basicTariffKeyVO.getTrfSeq(), 0);
					long trfGrpSeq = NumberUtils.toLong(basicTariffKeyVO.getTrfGrpSeq(), 0);
					long bkgCntrQty = NumberUtils.toLong(bkgCntrInfoVO.getBkgCntrQty(), 0);
					String svrID		= basicTariffKeyVO.getSvrId();
					String dmdtTrfCd	= basicTariffKeyVO.getDmdtTrfCd();
					
					long retFtDys = dmtCalculationUtil.basicFreeTime(svrID, dmdtTrfCd, trfSeq, trfGrpSeq, bkgCntrQty);
					ftDys = String.valueOf(retFtDys);
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler("DMT00006", new String[]{"Basic Tariff Free Days"}).getMessage());
				}	
			
				
				/*
				D) set Free Time Start Date

				*/
				// [logic] ********  Get Basic FreeTime Start ***********
				// Free Time Start Date
				String ftCmncDt = "";
				
				if( chgCalcCntrVO.getDmdtTrfCd().equals("DMIF") || chgCalcCntrVO.getDmdtTrfCd().equals("CTIC")
						&& bkgCntrInfoVO.getFmMvmtStsCd().equals("VD")
						&& DMTCalculationUtil.nullToString(bkgCntrInfoVO.getFmMvmtYdCd(),5).substring(0,5).equals(bkgCntrInfoVO.getPodCd())) {
					try {
						ftCmncDt = dbDao.searchVLVDDate(chgCalcCntrVO.getVvdCd(), bkgCntrInfoVO.getFmMvmtYdCd(), chgCalcCntrVO.getDmdtTrfCd(), "fm");
					} catch (Exception ex) {
						throw new EventException(new ErrorHandler("DMT00006", new String[]{"VLVDDate(Fixed CMNC Date)"}).getMessage());
					}	
				}
				
				if( ftCmncDt.length() == 0 ) {
					freeTimeStartParmVO.setFromDt(bkgCntrInfoVO.getFmMvmtDt());

					freeTimeStartParmVO.setBkgCntCd(bkgCntCd);
					freeTimeStartParmVO.setBkgRgnCd(bkgRgnCd);
					freeTimeStartParmVO.setBkgStateCd(bkgStateCd);
					freeTimeStartParmVO.setBkgLocCd(bkgLocCd);

					freeTimeStartParmVO.setYrdCntCd(bkgCntrInfoVO.getYrdCntCd());
					freeTimeStartParmVO.setYrdRgnCd(bkgCntrInfoVO.getYrdRgnCd());
					freeTimeStartParmVO.setYrdStateCd(bkgCntrInfoVO.getYrdSteCd());
					freeTimeStartParmVO.setYrdLocCd("");

					freeTimeStartParmVO.setDttCode(chgCalcCntrVO.getDmdtTrfCd());
					freeTimeStartParmVO.setOfcCd(bkgCntrInfoVO.getOfcCd());
					freeTimeStartParmVO.setExclSat(basicTariffKeyVO.getXcldSatFlg());
					freeTimeStartParmVO.setExclSun(basicTariffKeyVO.getXcldSunFlg());
					freeTimeStartParmVO.setExclHoli(basicTariffKeyVO.getXcldHolFlg());
					freeTimeStartParmVO.setCmncTp(basicTariffKeyVO.getDmdtChgCmncTpCd());
					freeTimeStartParmVO.setCmncHr(basicTariffKeyVO.getCmncHr());
					freeTimeStartParmVO.setSvrId(basicTariffKeyVO.getSvrId());

					freeTimeStartParmVO.setCstopIdx(String.valueOf(idx_cstop));
					freeTimeStartParmVO.setCStopNoList(cstop_no_list);
					freeTimeStartParmVO.setYardCd(bkgCntrInfoVO.getFmMvmtYdCd());

					FreeTimeVO freeTimeStartVO = null;
					try {
						freeTimeStartVO = dmtCalculationUtil.searchFreeTimeStart(freeTimeStartParmVO);
						ftCmncDt 		= DMTCalculationUtil.nullToString(freeTimeStartVO.getFtimeCmnc());
						idx_cstop 		= DMTCalculationUtil.stringToLong(freeTimeStartVO.getCstopIdx());
						cstop_no_list 	= freeTimeStartVO.getCStopNoList();
					} catch (Exception ex) {
						throw new EventException(new ErrorHandler("DMT00006", new String[]{"FreeTime Start"}).getMessage());
					}
				}
				
				/*
				E) set Free Time End Date

		        */

				/*
				[logic] Get Basic FreeTime End
				*/
				// condition >>> z_dc_ft_cmnc
				freeTimeEndParmVO.setFromDt(ftCmncDt);

				freeTimeEndParmVO.setBkgCntCd(bkgCntCd);
				freeTimeEndParmVO.setBkgRgnCd(bkgRgnCd);
				freeTimeEndParmVO.setBkgStateCd(bkgStateCd);
				freeTimeEndParmVO.setBkgLocCd(bkgLocCd);
				
				freeTimeEndParmVO.setYrdCntCd(bkgCntrInfoVO.getYrdCntCd());
				freeTimeEndParmVO.setYrdRgnCd(bkgCntrInfoVO.getYrdRgnCd());
				freeTimeEndParmVO.setYrdStateCd(bkgCntrInfoVO.getYrdSteCd());
				freeTimeEndParmVO.setYrdLocCd("");
				
				freeTimeEndParmVO.setDttCode(chgCalcCntrVO.getDmdtTrfCd());
				freeTimeEndParmVO.setOfcCd(bkgCntrInfoVO.getOfcCd());
				freeTimeEndParmVO.setExclSat(basicTariffKeyVO.getXcldSatFlg());
				freeTimeEndParmVO.setExclSun(basicTariffKeyVO.getXcldSunFlg());
				freeTimeEndParmVO.setExclHoli(basicTariffKeyVO.getXcldHolFlg());

				freeTimeEndParmVO.setFreeTime(String.valueOf(ftDys));
				freeTimeEndParmVO.setSvrId(basicTariffKeyVO.getSvrId());
				freeTimeEndParmVO.setCstopIdx(String.valueOf(idx_cstop));
				freeTimeEndParmVO.setCStopNoList(cstop_no_list);
				
				freeTimeEndParmVO.setYardCd(bkgCntrInfoVO.getFmMvmtYdCd());	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
				
				FreeTimeVO freeTimeEndVO = null;
				String ftEndDt = "";
				
				try {
					freeTimeEndVO	= dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
					ftEndDt  		= DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
					idx_cstop 		= DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
					cstop_no_list 	= freeTimeEndVO.getCStopNoList();
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler("DMT00006", new String[]{"FreeTime End"}).getMessage());
				}

				/*
				[logic] VL(To Date) Change
				*/
				if(	(chgCalcCntrVO.getDmdtTrfCd().equals("DMOF") || chgCalcCntrVO.getDmdtTrfCd().equals("CTOC")) 
						&& chgCalcCntrVO.getToMvmtStsCd().equals("VL")) {
					try {
						String vlvdDt = dbDao.searchVLVDDate(chgCalcCntrVO.getVvdCd(), chgCalcCntrVO.getToMvmtYdCd(), "", "to");
						if( vlvdDt.length() != 0 ){
							chgCalcCntrVO.setToMvmtDt(vlvdDt);
						}
					} catch (Exception ex) {
						throw new EventException(new ErrorHandler("DMT00006", new String[]{"VLVDDate(Fixed VL Date)"}).getMessage());
					}
				}
				
				/*
				F) calculate Free Time Overdays
					[logic] Get Grace Period Overday 
				*/
				String webMtDt = "";
				try {
					webMtDt = DMTCalculationUtil.nullToString(dmtCalculationUtil.getMTNotify(chgCalcCntrVO.getSvrId(), chgCalcCntrVO.getCntrNo()
									, NumberUtils.toLong(chgCalcCntrVO.getCntrCycNo(), 0), chgCalcCntrVO.getDmdtTrfCd(), bkgCntrInfoVO.getFmMvmtStsCd()));
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler("DMT00006", new String[]{"MT Notification"}).getMessage());
				}

				overdayNStatusParmVO.setToDate(chgCalcCntrVO.getToMvmtDt());
				overdayNStatusParmVO.setFtimeEnd(ftEndDt);
				overdayNStatusParmVO.setDttCode(chgCalcCntrVO.getDmdtTrfCd());
				overdayNStatusParmVO.setOfcCd(bkgCntrInfoVO.getOfcCd());
				overdayNStatusParmVO.setMtDate(webMtDt);
				overdayNStatusParmVO.setCstopIdx(String.valueOf(idx_cstop));
				overdayNStatusParmVO.setCStopNoList(cstop_no_list);
				overdayNStatusParmVO.setYardCd(bkgCntrInfoVO.getFmMvmtYdCd());	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
				
				String fxFtOvrDys = "";
				String orgFtOvrDys = "";
				String dmdtChgStsCd = "";
				
				OverdayNStatusVO overdayNStatusVO = null;
				try {
					overdayNStatusVO = dmtCalculationUtil.overdayNStatus(overdayNStatusParmVO);
					fxFtOvrDys		= DMTCalculationUtil.nullToString(overdayNStatusVO.getOverDay());
					orgFtOvrDys 	= fxFtOvrDys;
					dmdtChgStsCd 	= DMTCalculationUtil.nullToString(overdayNStatusVO.getStatus());
					idx_cstop 		= DMTCalculationUtil.stringToLong(overdayNStatusVO.getCstopIdx());
					cstop_no_list 	= overdayNStatusVO.getCStopNoList();
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler("DMT00006", new String[]{"Overday And Status"}).getMessage());
				}
				
				
				/***********************
				[logic]  Get Basic Amount
				************************/
				String orgChgAmt = "0";
				//String rateDtlCnt = "";
	
				if( dmdtChgStsCd.equals("L") || dmdtChgStsCd.equals("F") ){
					calculationParmVO.setSvrId(chgCalcCntrVO.getSvrId());
					calculationParmVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					calculationParmVO.setTrfSeq(basicTariffKeyVO.getTrfSeq());
					calculationParmVO.setTrfGrpSeq(basicTariffKeyVO.getTrfGrpSeq());
					calculationParmVO.setCntrts(chgCalcCntrVO.getCntrTpszCd());
					calculationParmVO.setOverDay(fxFtOvrDys);
					calculationParmVO.setDivOverDay("0");
					
					CalculationAMTVO calculationAMTVO = null;
					try {
						calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
						//rateDtlCnt = DMTCalculationUtil.nullToString(calculationAMTVO.getDtlCnt());
						orgChgAmt = DMTCalculationUtil.nullToString(calculationAMTVO.getTotal());
					} catch (Exception ex) {
						//throw new EventException("Charge & Total Function Error!", e);
						throw new EventException(new ErrorHandler("DMT00008", new String[]{"basic Calculation"}).getMessage());
					}
				}
	
				String dmdtTrfAplyTpCd = "G"; 		/* Applied Rate Set  */
				String billAmt = orgChgAmt;  		/* Basic  Amount Fixing */
				
				// Charge Sequence = Max Charge Sequence + 1
				//String nextChgSeq = String.valueOf(NumberUtils.toInt(chgMaxSeq, 0) + 1);
				//chgCalcCntrVO.setChgSeq(nextChgSeq);
				
				// addCharge (insert into DMT_CHG_CALC )
				DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
				dmtChgCalcVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCalcVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCalcVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCalcVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCalcVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCalcVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				dmtChgCalcVO.setFmMvmtStsCd(bkgCntrInfoVO.getFmMvmtStsCd());
				dmtChgCalcVO.setFmMvmtDt(bkgCntrInfoVO.getFmMvmtDt());
				dmtChgCalcVO.setFmMvmtYdCd(bkgCntrInfoVO.getFmMvmtYdCd());
				dmtChgCalcVO.setToMvmtStsCd(chgCalcCntrVO.getToMvmtStsCd());
				dmtChgCalcVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				dmtChgCalcVO.setToMvmtYdCd(chgCalcCntrVO.getToMvmtYdCd());
				dmtChgCalcVO.setToMvmtYr(chgCalcCntrVO.getToMvmtYr());
				dmtChgCalcVO.setToMvmtSeq(chgCalcCntrVO.getToMvmtSeq());
				dmtChgCalcVO.setToMvmtSplitNo(chgCalcCntrVO.getToMvmtSplitNo());
				dmtChgCalcVO.setNotCreBalFlg("N");
				dmtChgCalcVO.setFtDys(ftDys);
				dmtChgCalcVO.setFtCmncDt(ftCmncDt);
				dmtChgCalcVO.setFtEndDt(ftEndDt);
				dmtChgCalcVO.setFxFtOvrDys(fxFtOvrDys);
				dmtChgCalcVO.setOrgFtOvrDys(orgFtOvrDys);
//				dmtChgCalcVO.setScRfaExptOvrDys(retChgCalcCntrVO.getScRfaExptOvrDys());
//				dmtChgCalcVO.setAftExptOvrDys(retChgCalcCntrVO.getAftExptOvrDys());
				dmtChgCalcVO.setBzcTrfCurrCd(basicTariffKeyVO.getCurrCd());
				dmtChgCalcVO.setDmdtTrfAplyTpCd(dmdtTrfAplyTpCd);
				dmtChgCalcVO.setOrgChgAmt(orgChgAmt);
//				dmtChgCalcVO.setScRfaExptAmt(retChgCalcCntrVO.getScRfaExptAmt());
//				dmtChgCalcVO.setAftExptDcAmt(retChgCalcCntrVO.getAftExptDcAmt());
				dmtChgCalcVO.setBilAmt(billAmt);
				dmtChgCalcVO.setDmdtChgStsCd(dmdtChgStsCd);						
				
//				dmtChgCalcVO.setScRfaAmt(retChgCalcCntrVO.getScRfaAmt());
//				dmtChgCalcVO.setAftExptAmt(retChgCalcCntrVO.getAftExptAmt());
				dmtChgCalcVO.setBzcTrfSeq(basicTariffKeyVO.getTrfSeq());
				dmtChgCalcVO.setBzcTrfGrpSeq(basicTariffKeyVO.getTrfGrpSeq());
				dmtChgCalcVO.setBzcTrfAplyDt(effDt);		
//				dmtChgCalcVO.setRfaExptAproNo(retChgCalcCntrVO.getRfaExptAproNo());
//				dmtChgCalcVO.setRfaExptDarNo(retChgCalcCntrVO.getRfaExptDarNo());
//				dmtChgCalcVO.setRfaExptMapgSeq(retChgCalcCntrVO.getRfaExptMapgSeq());		
//				dmtChgCalcVO.setRfaExptVerSeq(retChgCalcCntrVO.getRfaExptVerSeq());
//				dmtChgCalcVO.setRfaRqstDtlSeq(retChgCalcCntrVO.getRfaRqstDtlSeq());
//				dmtChgCalcVO.setAftExptAproNo(retChgCalcCntrVO.getAftExptAproNo());
//				dmtChgCalcVO.setAftExptDarNo(retChgCalcCntrVO.getAftExptDarNo());
//				dmtChgCalcVO.setAftExptAdjSeq(retChgCalcCntrVO.getAftExptAdjSeq());
//				dmtChgCalcVO.setScNo(retChgCalcCntrVO.getScNo());
//				dmtChgCalcVO.setScExptVerSeq(retChgCalcCntrVO.getScExptVerSeq());
//				dmtChgCalcVO.setScExptGrpSeq(retChgCalcCntrVO.getScExptGrpSeq());
//				dmtChgCalcVO.setScRfaExptAplyDt(retChgCalcCntrVO.getScRfaExptAplyDt());
//				dmtChgCalcVO.setCorrRmk("");
				
//				dmtChgCalcVO.setOfcCd(chgCalcCntrVO.getOfcCd());
//				dmtChgCalcVO.setOfcRhqCd(chgCalcCntrVO.getOfcRhqCd());
//				dmtChgCalcVO.setActCntCd(chgCalcParmVO.getActCntCd());
//				dmtChgCalcVO.setActCustSeq(chgCalcParmVO.getActCustSeq());
//				dmtChgCalcVO.setCustCntCd(chgCalcParmVO.getCustCntCd());
//				dmtChgCalcVO.setCustSeq(chgCalcParmVO.getCustSeq());
//				dmtChgCalcVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
//				dmtChgCalcVO.setCmdtTrfSeq(retChgCalcCntrVO.getCmdtTrfSeq());
//				dmtChgCalcVO.setCmdtExptAplyDt(retChgCalcCntrVO.getCmdtExptAplyDt());
//				dmtChgCalcVO.setCmdtOvrDys(retChgCalcCntrVO.getCmdtOvrDys());
//				dmtChgCalcVO.setCmdtExptAmt(retChgCalcCntrVO.getCmdtExptAmt());
				dmtChgCalcVO.setWebMtyDt(webMtDt);
				dmtChgCalcVO.setCreUsrId(account.getUsr_id());
				dmtChgCalcVO.setCreOfcCd(account.getOfc_cd());
				dmtChgCalcVO.setUpdUsrId(account.getUsr_id());
				dmtChgCalcVO.setUpdOfcCd(account.getOfc_cd());
				
				
				// Insert into DMT_CHG_CALC
				boolean dupFlg = false;
				
				if(chgCalcCntrVO.getDmdtChgLocDivCd().equals("SZP")) {
					dupFlg = true;
				} else {
					try {
						dbDao.addChargeBySZPBB(dmtChgCalcVO);
						dbDao.modifyChargeChnDemKeyNoBySZPBB(dmtChgCalcVO);
					} catch (DAOException e) {
						if(e.getMessage().equals("1")) {
							dupFlg = true;
						} else {
							throw new EventException(new ErrorHandler("DMT00008", new String[]{"add Charge by SZPBB"}).getMessage());
						}
					} catch (Exception ex) {
						throw new EventException(new ErrorHandler("DMT00008", new String[]{"add Charge by SZPBB"}).getMessage());
					}
				}
				
				if(dupFlg) {
					try {
						dbDao.modifyChargeBySZPBB(dmtChgCalcVO);
					} catch (Exception ex) {
						throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify Charge by SZPBB"}).getMessage());
					}
				}
				
				if(ftCmncDt.length() > 8) ftCmncDt = ftCmncDt.substring(0,8);
				if(ftEndDt.length() > 8) ftEndDt = ftEndDt.substring(0,8);
				
				chgCalcCntrVO.setFtDys(ftDys);
				chgCalcCntrVO.setFtCmncDt(ftCmncDt);
				chgCalcCntrVO.setFtEndDt(ftEndDt);
				chgCalcCntrVO.setFxFtOvrDys(fxFtOvrDys);
				chgCalcCntrVO.setDmdtTrfAplyTpCd(dmdtTrfAplyTpCd);
				chgCalcCntrVO.setBzcTrfCurrCd(basicTariffKeyVO.getCurrCd());
				chgCalcCntrVO.setBilAmt(billAmt);
				chgCalcCntrVO.setDmdtChgStsCd(dmdtChgStsCd);
				chgCalcCntrVO.setWebMtyDt(webMtDt);
				
				list.add(chgCalcCntrVO);
				
				/*DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
				dmtChgCorrHisVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCorrHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCorrHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCorrHisVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCorrHisVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCorrHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				dmtChgCorrHisVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				dmtChgCorrHisVO.setCorrHisRmk("Balance Creation");
				dmtChgCorrHisVO.setCreUsrId(account.getUsr_id());
				dmtChgCorrHisVO.setCreOfcCd(account.getOfc_cd());
				
				dmtChgCorrHisVO.setCorrHisSeq("1");
				dbDao.addChargeHistory(dmtChgCorrHisVO);*/
				
			} // for end
			
			resultVO.setChargeCalculationContainerVOs(list);
			return resultVO;
			
		/*
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}*/
	}
	
	
	/**
	 * save CHARGE HISTORY about Invoice Group<br>
	 * 
	 * @param List<InvoiceIssueVO> invoiceIssueVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeChargeStatusForInvoiceByGroup(List<InvoiceIssueVO> invoiceIssueVOs, SignOnUserAccount account) throws EventException{
		
		try {
			for(int i = 0 ; i < invoiceIssueVOs.size() ; i++) {
				InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueVOs.get(i);
				
				com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = new com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
    			chargeArgumentVO.setSvrId(invoiceIssueDetail.getSvrId());
    			chargeArgumentVO.setCntrNo(invoiceIssueDetail.getCntrNo());
    			chargeArgumentVO.setCntrCycNo(invoiceIssueDetail.getCntrCycNo());
    			chargeArgumentVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
    			chargeArgumentVO.setDmdtChgLocDivCd(invoiceIssueDetail.getDmdtChgLocDivCd());
    			chargeArgumentVO.setChgSeq(invoiceIssueDetail.getChgSeq());
    			
				int corrHisSeq = dmtCalculationUtil.checkChargeCorrection(chargeArgumentVO);
    			
				DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
				dmtChgCorrHisVO.setSvrId(invoiceIssueDetail.getSvrId());
				dmtChgCorrHisVO.setCntrNo(invoiceIssueDetail.getCntrNo());
				dmtChgCorrHisVO.setCntrCycNo(invoiceIssueDetail.getCntrCycNo());
				dmtChgCorrHisVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
				dmtChgCorrHisVO.setDmdtChgLocDivCd(invoiceIssueDetail.getDmdtChgLocDivCd());
				dmtChgCorrHisVO.setChgSeq(invoiceIssueDetail.getChgSeq());
				dmtChgCorrHisVO.setCorrHisRmk("");
				dmtChgCorrHisVO.setCreUsrId(account.getUsr_id());
				dmtChgCorrHisVO.setCreOfcCd(account.getOfc_cd());
    		
				if(corrHisSeq == 0) {
					corrHisSeq++;
					dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
					dbDao.addChargeHistory(dmtChgCorrHisVO);
				}
				
				ChargeArgumentVO closingChargeArgumentVO = new ChargeArgumentVO();
				closingChargeArgumentVO.setSvrId(invoiceIssueDetail.getSvrId());
				closingChargeArgumentVO.setCntrNo(invoiceIssueDetail.getCntrNo());
				closingChargeArgumentVO.setCntrCycNo(invoiceIssueDetail.getCntrCycNo());
				closingChargeArgumentVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
				closingChargeArgumentVO.setDmdtChgLocDivCd(invoiceIssueDetail.getDmdtChgLocDivCd());
				closingChargeArgumentVO.setChgSeq(invoiceIssueDetail.getChgSeq());
				closingChargeArgumentVO.setDmdtChgStsCd("I");//dmdt_chg_sts_cd
				closingChargeArgumentVO.setDmdtInvNo(invoiceIssueDetail.getDmdtInvNo());
				
				dbDao.modifyChargeStatusByInvoice(closingChargeArgumentVO, account.getUsr_id(), account.getOfc_cd());
				
				corrHisSeq++;
				dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
				dmtChgCorrHisVO.setCorrHisRmk("Invoice Creation");
				dbDao.addChargeHistory(dmtChgCorrHisVO);
			}
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"change Charge Status For Invoice by Group"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"change Charge Status For Invoice by Group"}).getMessage());
		}		
	}	
	
	/**
	 * save CHARGE HISTORY about Invoice Cancel<br>
	 * 
	 * @param List<ChargeArgumentVO> chargeArgumentVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeChargeStatusForInvoiceByCancel(List<ChargeArgumentVO> chargeArgumentVOs, SignOnUserAccount account) throws EventException{
		try {
			for(int i = 0 ; i < chargeArgumentVOs.size() ; i++) {
				ChargeArgumentVO invCancelChargeArgumentVO = (ChargeArgumentVO)chargeArgumentVOs.get(i);
				
    			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = new com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
    			chargeArgumentVO.setSvrId(invCancelChargeArgumentVO.getSvrId());
    			chargeArgumentVO.setCntrNo(invCancelChargeArgumentVO.getCntrNo());
    			chargeArgumentVO.setCntrCycNo(invCancelChargeArgumentVO.getCntrCycNo());
    			chargeArgumentVO.setDmdtTrfCd(invCancelChargeArgumentVO.getDmdtTrfCd());
    			chargeArgumentVO.setDmdtChgLocDivCd(invCancelChargeArgumentVO.getDmdtChgLocDivCd());
    			chargeArgumentVO.setChgSeq(invCancelChargeArgumentVO.getChgSeq());
    			
				int corrHisSeq = dmtCalculationUtil.checkChargeCorrection(chargeArgumentVO);
    			
				DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
				dmtChgCorrHisVO.setSvrId(invCancelChargeArgumentVO.getSvrId());
				dmtChgCorrHisVO.setCntrNo(invCancelChargeArgumentVO.getCntrNo());
				dmtChgCorrHisVO.setCntrCycNo(invCancelChargeArgumentVO.getCntrCycNo());
				dmtChgCorrHisVO.setDmdtTrfCd(invCancelChargeArgumentVO.getDmdtTrfCd());
				dmtChgCorrHisVO.setDmdtChgLocDivCd(invCancelChargeArgumentVO.getDmdtChgLocDivCd());
				dmtChgCorrHisVO.setChgSeq(invCancelChargeArgumentVO.getChgSeq());
				dmtChgCorrHisVO.setCorrHisRmk("");
				dmtChgCorrHisVO.setCreUsrId(account.getUsr_id());
				dmtChgCorrHisVO.setCreOfcCd(account.getOfc_cd());
    		
				if(corrHisSeq == 0) {
					corrHisSeq++;
					dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
					dbDao.addChargeHistory(dmtChgCorrHisVO);
				}
				
				ChargeArgumentVO closingChargeArgumentVO = new ChargeArgumentVO();
				closingChargeArgumentVO.setSvrId(invCancelChargeArgumentVO.getSvrId());
				closingChargeArgumentVO.setCntrNo(invCancelChargeArgumentVO.getCntrNo());
				closingChargeArgumentVO.setCntrCycNo(invCancelChargeArgumentVO.getCntrCycNo());
				closingChargeArgumentVO.setDmdtTrfCd(invCancelChargeArgumentVO.getDmdtTrfCd());
				closingChargeArgumentVO.setDmdtChgLocDivCd(invCancelChargeArgumentVO.getDmdtChgLocDivCd());
				closingChargeArgumentVO.setChgSeq(invCancelChargeArgumentVO.getChgSeq());
				
				dbDao.modifyChargeStatusByInvoiceCancel(closingChargeArgumentVO, account.getUsr_id(), account.getOfc_cd());
				
				corrHisSeq++;
				dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
				dmtChgCorrHisVO.setCorrHisRmk("Invoice Cancel");
				dbDao.addChargeHistory(dmtChgCorrHisVO);
			}
		
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"change ChargeStatus For Invoice By Cancel"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"change ChargeStatus For Invoice By Cancel"}).getMessage());
		}	
	}
	
	
	/**
	 * save CHARGE Trucker info.<br>
	 * 
	 * @param InvoiceIssueMgtVO invoiceIssueMgtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeTruckerForInvoice(InvoiceIssueMgtVO invoiceIssueMgtVO, SignOnUserAccount account) throws EventException {
		List<InvoiceIssueVO> invoiceIssueList = null;
		ChargeBookingInvoiceVO chargeBookinInvoiceVO = new ChargeBookingInvoiceVO();
		try {
			invoiceIssueList = invoiceIssueMgtVO.getInvoiceIssueVOs();
			chargeBookinInvoiceVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();
			
			for(int i = 0 ; i < invoiceIssueList.size() ; i++) {
    			InvoiceIssueVO invoiceIssueParam = (InvoiceIssueVO)invoiceIssueList.get(i);
    			
    			log.debug("\n svr_id==>"+invoiceIssueParam.getSvrId());
    			log.debug("\n cntr_no==>"+invoiceIssueParam.getCntrNo());
    			log.debug("\n cntr_cyc_no==>"+invoiceIssueParam.getCntrCycNo());
    			log.debug("\n dmdt_trf_cd==>"+invoiceIssueParam.getDmdtTrfCd());
    			log.debug("\n dmdt_chg_loc_div_cd==>"+invoiceIssueParam.getDmdtChgLocDivCd());
    			log.debug("\n chg_seq==>"+invoiceIssueParam.getChgSeq());
    			log.debug("\n trucker_cd==>"+chargeBookinInvoiceVO.getTruckerCd());
    			
    			
    
    			com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO closingChargeArgumentVO = new com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO();
                closingChargeArgumentVO.setSvrId(invoiceIssueParam.getSvrId());
                closingChargeArgumentVO.setCntrNo(invoiceIssueParam.getCntrNo());
                closingChargeArgumentVO.setCntrCycNo(invoiceIssueParam.getCntrCycNo());
                closingChargeArgumentVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
                closingChargeArgumentVO.setDmdtChgLocDivCd(invoiceIssueParam.getDmdtChgLocDivCd());
                closingChargeArgumentVO.setChgSeq(invoiceIssueParam.getChgSeq());
                closingChargeArgumentVO.setTruckerCd(chargeBookinInvoiceVO.getTruckerCd());
                
                dbDao.modifyChargeTruckerByInvoice(closingChargeArgumentVO, account.getUsr_id(), account.getOfc_cd());
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"change Trucker For Invoice"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"change Trucker For Invoice"}).getMessage());
		}
	}	
	
	/**
	 * modify Booking Container info.<br>
	 * 
	 * @param DmtChgBkgCntrVO dmtChgBkgCntrVO
	 * @exception EventException
	 */
	public void modifyBookingContainer(DmtChgBkgCntrVO dmtChgBkgCntrVO ) throws EventException {
		try {
			dbDao.modifyBookingContainer(dmtChgBkgCntrVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify Booking Container"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify Booking Container"}).getMessage());
		}
	}	
	/**
	 * modify Charge Calculation info.<br>
	 * 
	 * @param DmtChgCalcVO dmtChgCalcVO
	 * @exception EventException
	 */
	public void modifyChargeCalculation(DmtChgCalcVO dmtChgCalcVO ) throws EventException {
		try {
			dbDao.modifyChargeCalculation(dmtChgCalcVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify Charge Calculation"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify Charge Calculation"}).getMessage());
		}
	}
	
	/**
	 * save Charge Calculation info.<br>
	 * 
	 * @param DmtChgCalcVO dmtChgCalcVO
	 * @exception EventException
	 */
	public void createCharge(DmtChgCalcVO dmtChgCalcVO ) throws EventException {
		try {
			dbDao.addCharge(dmtChgCalcVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"create Charge"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"create Charge"}).getMessage());
		}
	}
	
	/**
	 * case in exist Clock Stop ,  delete History<br>
	 * 
	 * @param DmtChgTmCskStopVO dmtChgTmCskStopVO
	 * @exception EventException
	 */
	public void deleteClockStopHistory(DmtChgTmCskStopVO dmtChgTmCskStopVO) throws EventException {
		
		try {
			dbDao.deleteClockStopHistory(dmtChgTmCskStopVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"delete ClockStop History"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"delete ClockStop History"}).getMessage());
		}
	}
	
	/**
	 * case in exist Clock Stop History, insert Clock Stop History.<br>
	 * 
	 * @param DmtChgTmCskStopVO dmtChgTmCskStopVO
	 * @exception EventException
	 */
	public void addClockStopHistory(DmtChgTmCskStopVO dmtChgTmCskStopVO) throws EventException {
		
		try {
			dbDao.addClockStopHistory(dmtChgTmCskStopVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"add ClockStop History"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"add ClockStop History"}).getMessage());
		}
	}

	/**
	 * save VVD info.<br>
	 * 
	 * @param VVDCheckDataVO vVDCheckDataVO
	 * @throws EventException
	 */
	public void modifyBookingContainerVVD(VVDCheckDataVO vVDCheckDataVO) throws EventException{
		VVDNEtaVO vVDNEtaVO = new VVDNEtaVO();
		
		try{
    		vVDNEtaVO = dmtCalculationUtil.searchVVDNEta(vVDCheckDataVO.getBkgNo()
    													, vVDCheckDataVO.getPolCd()
    													, vVDCheckDataVO.getPodCd()
    													, vVDCheckDataVO.getIoBnd());
    		if(vVDNEtaVO != null){
    			if(vVDNEtaVO.getVslCd() != null && vVDNEtaVO.getVslCd().length() > 0
        			&& vVDNEtaVO.getSkdVoyNo() != null && vVDNEtaVO.getSkdVoyNo().length() > 0
        			&& vVDNEtaVO.getSkdDirCd() != null && vVDNEtaVO.getSkdDirCd().length() > 0)
    			{
	                // modifyBookingContainerVVD
    				vVDNEtaVO.setIoBnd(vVDCheckDataVO.getIoBnd());
	                dbDao.modifyBookingContainerVVD(vVDNEtaVO);
	            }
    		}
	        
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify BookingContainer VVD"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify BookingContainer VVD"}).getMessage());
		}
	}
	
	/**
	 * sending EDI to other moduls.<br>
	 * 
	 * @param List<EDIVO> EDIVOs
	 * @throws EventException
	 */
	public void sendToEDI(List<EDIVO> eDIVOs) throws EventException {
		//BkgNtcHisVO			bkgNtcHisVO			= null;
		KorDoEdiTransVO		korDoEdiTransVO		= null;
		
		CargoReleaseOrderBC cargoReleaseOrderBC	= new CargoReleaseOrderBCImpl();
		
		try {
			if (eDIVOs != null && eDIVOs.size() > 0) {
				for (int i = 0 ; i < eDIVOs.size() ; i++) {
					//set EDI info.
					korDoEdiTransVO	= new KorDoEdiTransVO();
					korDoEdiTransVO.setBkgNo(		eDIVOs.get(i).getBkgNo() );
					korDoEdiTransVO.setDoType(		"KDL"					 );	//=>'KDL' default value 
					korDoEdiTransVO.setSelfTrnsFlg(	"N"						 ); //=>'N'  default value( for BKG )
					korDoEdiTransVO.setAcount(		eDIVOs.get(i).getAcount());	

					//send EDI
					//bkgNtcHisVO = cargoReleaseOrderBC.transmitEdiByKorDo(korDoEdiTransVO);
					cargoReleaseOrderBC.transmitEdiByKorDo(korDoEdiTransVO);

					eDIVOs.get(i).setEdiIssUsrId(	StringUtils.defaultIfEmpty(eDIVOs.get(i).getAcount().getUsr_id(), "BATCH" ));
					eDIVOs.get(i).setCreUsrId(		StringUtils.defaultIfEmpty(eDIVOs.get(i).getAcount().getUsr_id(), "BATCH" ));
					eDIVOs.get(i).setCreOfcCd(		StringUtils.defaultIfEmpty(eDIVOs.get(i).getAcount().getOfc_cd(), "BATCH" ));
					
					//return result for sending EDI log
					//log.info("\n[BKG No]: " + eDIVOs.get(i).getBkgNo() + "\n[EDI ID]: " + bkgNtcHisVO.getEdiId() + "\n[Result]: " + bkgNtcHisVO.getBkgNtcSndRsltCd());
					
					//save sending EDI history
					dbDao.addEDIHistory(eDIVOs.get(i));
				}
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());			
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * modify info. about CTOC/CTIC<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @exception EventException
	 */
	public void modifyOrgChgAmt(ChargeArgumentVO chargeArgumentVO) throws EventException {
		try {
			dbDao.modifyOrgChgAmt(chargeArgumentVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify Charge"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify Charge"}).getMessage());
		}
	}
	
	
	/**
	 * search Dual Charge Tariff List<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchDualChargeTariff(ChargeArgumentVO chargeArgumentVO) throws EventException {
		try {
			return dbDao.searchDualChargeTariff(chargeArgumentVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"DualChargeTariff List"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"DualChargeTariff List"}).getMessage());
		}
	}
	
	
	/**
	 * return result of  Back End Job.
	 *
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkBackEndJob(String key) throws EventException {
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
	}
	
	
	/**
	 * run Back End Job.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String doBackEndJob(ChargeArgumentVO chargeArgumentVO,
				ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account) throws EventException {
		try {
			ChargeCalculationBackEndJob	backEndJob			= new ChargeCalculationBackEndJob();
			BackEndJobManager			backEndJobManager 	= new BackEndJobManager();
			
			String backendjobId = chargeArgumentVO.getBackendjobId();
			
			//set parameter for BackEndJob
			backEndJob.setJobCommand(backendjobId);
			backEndJob.setChargeArgumentVO(chargeArgumentVO);
			backEndJob.setChargeCalculationContainerVOs(chargeCalculationContainerVOs);
			backEndJob.setSignOnUserAccount(account);
			
			String jobMessage = "DMT " + backendjobId + " Back End";
			
			//call BackEndJob 
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), jobMessage);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"execute charge calculation backend job"}).getMessage());
		}
	}
	
	/**    3104   
	 * DEM/DET Billing 담당자가 DEM/DET Charge 확정 하는 과정에서 화주의 귀책이 아니거나,
	 * Manual Invoice가 필요한 Charge를 Delete하기 위해서 Request 한다.
	 * 
	 * - 선조건: Delete할 Charge의 Status가 Invoice되지 않아야한다
	 * - 후조건: 해당 Charge의 Charge Status가 "R"로 변경
	 * - 처리로직
	 *	1. 여러건의 Charge를 처리한다.
	 *	2. Charge별 현재 Status가 Invoice되었으면 메시지[DMT01002]를 보여주고 계산을 중단한다.
	 *	3. delete 할 대상Charge를 DMT_CHG_DELT_RQST_APRO 에 저장한다.
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String requestChargeDeletion(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
		throws EventException {
		String message = "";
		
		try {
			String result = "";
			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = null;
			chargeArgumentVO = new com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
			
			ChargeCalculationContainerVO chgCalcCntrVO  = chargeCalculationContainerVOs[0];
			String dmdtChgDeltRsnCd = chgCalcCntrVO.getDmdtChgDeltRsnCd();
			String corrRmk = chgCalcCntrVO.getCorrRmk();
			
			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
				chgCalcCntrVO = chargeCalculationContainerVOs[i];
				
				//중복처리 방지 체크로직
				com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO checkArgument 
					= new com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO();
				checkArgument.setSvrId(chgCalcCntrVO.getSvrId());
				checkArgument.setCntrNo(chgCalcCntrVO.getCntrNo());
				checkArgument.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				checkArgument.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				checkArgument.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				checkArgument.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				boolean isExist = dbDao.checkRequestChargeDeletion(checkArgument);
				
				//Requst 상태인 데이터가 있는 경우 
				if(isExist)
					return "DMT01081";  //This has been done already. 
				
				
				String chgMaxSeq = dbDao.searchChargeMaxSequence(checkArgument);
				
				if(!chgCalcCntrVO.getChgSeq().equals(chgMaxSeq)) {
					checkArgument.setErrCode("DMT01130");
					message = new ErrorHandler("DMT01130").getUserMessage();
					message = JSPUtil.replace(message, "{?msg1}", chgCalcCntrVO.getCntrNo());
					checkArgument.setErrMsg(message);

					return message;				
					
					//return "DMT01130"; //Only the last balance charge of a cntr can be deleted. Please check the charge of cntr no. : {?msg1}
				}
				
				chgCalcCntrVO.setCorrRmk(corrRmk);
				chgCalcCntrVO.setDmdtChgDeltRsnCd(dmdtChgDeltRsnCd);
				chgCalcCntrVO.setCreUsrId(account.getUsr_id());
				chgCalcCntrVO.setCreOfcCd(account.getOfc_cd());
				chgCalcCntrVO.setOfcRhqCd(account.getRhq_ofc_cd()) ;
				
				
				dbDao.requestChargeDeletion(chgCalcCntrVO );
			
			} // for end
			
			return result;
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"Request Charge Deletion"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"Request Charge Deletion"}).getMessage());
		}
	}
	
	/**
	 * DMT Office List를 조회한다.  EES_DMT_3014<br>
	 * @param String OfcCd
	 * @param String rhq
	 * @return List<OfficeNameVO>
	 */
	public List<OfficeNameVO> searchDMTOfficeByApprovalOffice(String OfcCd, String rhq) throws EventException {
		
		try {
			return dbDao.searchDMTOfficeByApprovalOffice(OfcCd, rhq);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Charge Delete 대상 Data를 조회한다    3014<br>
	 * @param ChargeDeletionRequstVO chargeDeletionRequstVO
	 * 
	 * @return List<ChargeCalculationContainerVO>
	 */
	public List<ChargeCalculationContainerVO> searchChargeDeletionRequest(ChargeDeletionRequstVO chargeDeletionRequstVO) throws EventException {
			try {
				return dbDao.searchChargeDeletionRequest(chargeDeletionRequstVO);
			} catch (DAOException ex) {
				log.error("[DAOException]"+ex.getMessage());
				throw new EventException(new ErrorHandler(ex).getMessage());
			} catch (Exception ex) {
				log.error("[DAOException]"+ex.getMessage());
				throw new EventException(new ErrorHandler(ex).getMessage());
			}
		}
	/**
	 * Charge Deletion을 Reject한다.<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void rejectChargeDeletion(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account ) throws EventException {
		
		try {
					
			ChargeCalculationContainerVO chgCalcCntrVO  = chargeCalculationContainerVOs[0];
			
			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
				chgCalcCntrVO = chargeCalculationContainerVOs[i];
		
				ChargeArgumentVO checkArgument = new ChargeArgumentVO();
					
				checkArgument.setSvrId(chgCalcCntrVO.getSvrId());
				checkArgument.setCntrNo(chgCalcCntrVO.getCntrNo());
				checkArgument.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				checkArgument.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				checkArgument.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				checkArgument.setChgSeq(chgCalcCntrVO.getChgSeq());
				checkArgument.setOfcCd(chgCalcCntrVO.getOfcCd());
				checkArgument.setDeltSeq(chgCalcCntrVO.getDeltSeq());
				checkArgument.setUpdUsrId(account.getUsr_id()) ;
				checkArgument.setUpdOfcCd(account.getOfc_cd()) ;
				checkArgument.setRhqOfcCd(account.getRhq_ofc_cd()) ;
				checkArgument.setStsCd("J");
				
			
				dbDao.modifyChargeDeletion(checkArgument);
				
			} // for end
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"Reject Charge Deletion"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"Reject Charge Deletion"}).getMessage());
		}
	}
	/**
	 * Charge 정보를 재계산하여 수정한다.(Recalculation)<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO modifyChargeByBooking(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
		throws EventException {
		
		try {
				DmtResultVO resultVO = new DmtResultVO();
				DMTGeneralChargeCalculationUtil dmtGeneralChargeCalculationUtil = null;
				DMTBalanceChargeCalculationUtil dmtBalanceChargeCalculationUtil = null;
				DMTCancelChargeCalculationUtil	dmtCancelChargeCalculationUtil	= null;
				DMTCombinedChargeCalculationUtil dmtCombinedChargeCalculationUtil = null;
				com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
				ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs[i];
				
			
				chgCalcCntrVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt().replace("-", ""));
				chgCalcCntrVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt().replace("-", ""));
			
				ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
				chgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				chgArgVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				chgArgVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				/*
				- Balance Charge가 없거나, 있으면 마지막 Balance Charge만 D/R Date 저장 가능.
				- Balance Charge가 있는 Charge일 경우  "There is a balance charge!" Alert창  띄우며 오류 처리.
				*/
				String chgMaxSeq = dbDao.searchChargeMaxSequence(chgArgVO);
				
				if(!chgCalcCntrVO.getChgSeq().equals(chgMaxSeq)) {
					//"There is a balance charge !"
					resultVO.setResultCode("DMT01030");
					return resultVO;
				}
				
				
				// Charge가 Invoice되었는지 여부를 Check하여 Invoice되었으면 오류 처리
				boolean chgInvChk = dbDao.searchChargeInvoiceCheck(chgArgVO);
				if(chgInvChk) {
					//"Already Invoiced"
					resultVO.setResultCode("DMT01002");
					return resultVO;
				}
				
				// Web Cancel 일 경우, To MVMT Date, To MVMT Yard, To MVMt Status정보를  초기화
				/*if(chargeCalculationContainerVO.getWebCancelFlg().equals("Y")) {
					chargeCalculationContainerVO.setToMvmtDt("");
					chargeCalculationContainerVO.setToMvmtYdCd("");
					chargeCalculationContainerVO.setToMvmtStsCd("");
				}*/
				
			
				//  To Movement Status가 "DR"이나 "CS"인 경우, 현재 일자와 To Date를 비교하여 To Date가 작으면  오류 처리
				String toMvmtStsCd = chgCalcCntrVO.getToMvmtStsCd();
				
				// DR Date Checking
				if(toMvmtStsCd.equals("DR")) {
					//String currDt = DateTime.getDateString().replace(".","");
					// User Office별 현재일자 조회
					String currDt	= dbDao.searchCurrentDateByOffice(account.getOfc_cd());
					String toMvmtDt	= chgCalcCntrVO.getToMvmtDt();
					
					if(currDt.compareTo(toMvmtDt) > 0) {
						// D/R Date should be same or later than current date
						resultVO.setResultCode("DMT01031");
						return resultVO;
					}
				} else if(toMvmtStsCd.equals("CS")) {
					// Clock Stop
					String fmMvmtDt = chgCalcCntrVO.getFmMvmtDt();
					String toMvmtDt = chgCalcCntrVO.getToMvmtDt();
					
					if(fmMvmtDt.compareTo(toMvmtDt) >= 0) {
						// CS date should be later than From date
						resultVO.setResultCode("DMT01004");
						return resultVO;
					}
				}
			
				
				com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = null;
				chargeArgumentVO = new com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
				chargeArgumentVO.setSvrId(chgCalcCntrVO.getSvrId());
				chargeArgumentVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chargeArgumentVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chargeArgumentVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chargeArgumentVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chargeArgumentVO.setChgSeq(chgCalcCntrVO.getChgSeq());
			
				// 해당 Charge의 Correction History가 존재하는지 Check하여 없으면 Correction History를 Insert한다.
				int corrHisSeq = dmtCalculationUtil.checkChargeCorrection(chargeArgumentVO);
				
				DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
				dmtChgCorrHisVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCorrHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCorrHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCorrHisVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCorrHisVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCorrHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				dmtChgCorrHisVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				dmtChgCorrHisVO.setCorrHisRmk(chgCalcCntrVO.getCorrRmk());
				dmtChgCorrHisVO.setCreUsrId(account.getUsr_id());
				dmtChgCorrHisVO.setCreOfcCd(account.getOfc_cd());
				
				if(corrHisSeq == 0) {
					corrHisSeq++;
					dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
					dbDao.addChargeHistory(dmtChgCorrHisVO);
				}
				
				
				// ***********  ChargeCalculationUseData  *************
				ChargePartialPaymentVO chgPartialPaymentVO = dbDao.searchChargeCalculationUseData(chgArgVO);
				
				if(chgCalcCntrVO.getSvrId().equals("EUR")) {
					String obCntrFlg = dbDao.searchInOutBoundByMovement(chgCalcCntrVO.getCntrNo(), chgCalcCntrVO.getCntrCycNo(), chgCalcCntrVO.getFmMvmtYdCd());
					//log.debug("============> OB_CNTR_FLG : " + obCntrFlg);
					// 'N' --> 'I'  , 'Y' --> 'O'
					
					// DATA존재시, IN/OUT BOUND 값을 사용한다.
					if(!obCntrFlg.equals("")) {
						String ioBndCd = obCntrFlg.equals("N") ? "I" : "O";
						chgPartialPaymentVO.setIoBndCd(ioBndCd);
					}
				}
				
				chgCalcCntrVO.setFmMvmtDt(chgPartialPaymentVO.getFmMvmtDt());
				
				/*
				 "L"(Long Staying), "U"(Unfinished), "N"(No Charge) 인  경우, To Date/Yard를 입력하지 않아도 Re-Calculation 가능
				    즉, To Date를 초기화한다
				 */
				//String chgStsCd = chargeCalculationContainerVO.getDmdtChgStsCd();
				if( //(chgStsCd.equals("L") || chgStsCd.equals("U") || chgStsCd.equals("N")) && 
					chgPartialPaymentVO.getToMvmtDt().length() < 12 ) {
					chgCalcCntrVO.setToMvmtDt("");
				} else
					chgCalcCntrVO.setToMvmtDt(chgPartialPaymentVO.getToMvmtDt());
				
				
				// MT Notification된 Data의 경우(To Movement="DR"이고 Web Indicator="Y"), Web Indicator를 "N"으로 Update한다.
				if( ("Y".equals(chgCalcCntrVO.getWebIndFlg()) && chgCalcCntrVO.getToMvmtStsCd().equals("DR"))
						|| (chgCalcCntrVO.getWebCancelFlg().equals("Y")) ) {   // <--- Web Cancel 실행시 체크 조건
					chgArgVO.setWebIndFlg("N");
					dbDao.modifyChargeWebIndicator(chgArgVO);
				}
				
				
				ChargeCalculationParmVO chgCalcParmVO = new ChargeCalculationParmVO();
				chgCalcParmVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgCalcParmVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgCalcParmVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgCalcParmVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgCalcParmVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgCalcParmVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				chgCalcParmVO.setActCntCd(chgPartialPaymentVO.getActCntCd());
				chgCalcParmVO.setActCustSeq(chgPartialPaymentVO.getActCustSeq());
				chgCalcParmVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				chgCalcParmVO.setCntrTpszCd(chgCalcCntrVO.getCntrTpszCd());
				chgCalcParmVO.setCustCntCd(chgPartialPaymentVO.getCustCntCd());
				chgCalcParmVO.setCustSeq(chgPartialPaymentVO.getCustSeq());
				chgCalcParmVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				chgCalcParmVO.setFmMvmtStsCd(chgCalcCntrVO.getFmMvmtStsCd());
				chgCalcParmVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				chgCalcParmVO.setIoBndCd(chgPartialPaymentVO.getIoBndCd());
				chgCalcParmVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				chgCalcParmVO.setToMvmtStsCd(chgCalcCntrVO.getToMvmtStsCd());
				chgCalcParmVO.setToMvmtYdCd(chgCalcCntrVO.getToMvmtYdCd());
				
				
				if(chgCalcCntrVO.getDulTpExptFlg().equals("Y")) {
					// Dual Exception Charge중 Combined Charge에 대한 Dual Charge를 조회한다..
					List<ChargeCalculationContainerVO> chgCalcCntrVOs = dbDao.searchDualChargeTariff(chgArgVO);
					
					if(chgCalcCntrVOs != null && chgCalcCntrVOs.size() > 0) {
						String callFlag = null;
						if(chgCalcCntrVO.getWebCancelFlg().equals("Y")) {
							callFlag = "WEBCANCEL";
						} else {
							callFlag = "SAVE";
						}
						
						chgArgVO.setCallFlag(callFlag);
						resultVO = dualExceptionChargeCalculation(callFlag, chgCalcCntrVO, chgCalcCntrVOs, account);
						
						// 오류 발생시 Return
						if(resultVO.getResultCode() != null) {
							return resultVO;
						}
					}
					
					dmtCombinedChargeCalculationUtil = new DMTCombinedChargeCalculationUtil();
	//				retChgCalcCntrVO = dmtCombinedChargeCalculationUtil.combinedChargeCalculation(chgCalcParmVO);
					//2011.04.29. 추가 ("DR"일때 아닐때 구분)
					if(!chgCalcCntrVO.getFmMvmtStsCd().equals("DR")){
						retChgCalcCntrVO = dmtCombinedChargeCalculationUtil.combinedChargeCalculation(chgCalcParmVO);
						if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
							log.error("\n\n combinedChargeCalculation ERROR [Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					}else{
						dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
						retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
						
						if (retChgCalcCntrVO.getMsgCd().equals("-1")) {
							log.error("\n\n[DMT02036][Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					}				
				} else {
					if(chgCalcCntrVO.getCxlBkgChgFlg().equals("Y")) {
						dmtCancelChargeCalculationUtil	= new DMTCancelChargeCalculationUtil();
						retChgCalcCntrVO = dmtCancelChargeCalculationUtil.cancelChargeCalculation(chgCalcParmVO);
						
						if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					} else {
						// From Movement Status가 "DR"이 아니면 General Charge를 계산하고, "DR"이면 Balance Charge를 계산한다
						if(!chgCalcCntrVO.getFmMvmtStsCd().equals("DR")) {
							dmtGeneralChargeCalculationUtil = new DMTGeneralChargeCalculationUtil();
							retChgCalcCntrVO = dmtGeneralChargeCalculationUtil.generalChargeCalculation(chgCalcParmVO);
							
							if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
								resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						} else {
							dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
							retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
							if(retChgCalcCntrVO.getMsgCd().equals("-1")) {
								resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						}
					}
				}
			
			// 위에서 계산한 Operation의 Return값이 0이 아니면 Charge Status를 "E"(Error)로 Setting한다
				if(!retChgCalcCntrVO.getMsgCd().equals("0")) {
					retChgCalcCntrVO.setDmdtChgStsCd("E");
					chgCalcCntrVO.setCorrRmk(chgCalcCntrVO.getCorrRmk() + " " + retChgCalcCntrVO.getMsgDesc());
				}
				
				// From Movement Status가 "DR"이 아니면 General Charge를 계산하고 Parameter로 받은 Data중 BKG CNTR관련 Data를 BKG CNTR Table에 Data를   Update한다. 
				// 단 Parameter로 받은 Data중 VVD Code가 Null이면 Booking의 Trunk VVD를 조회한다.
				if(!chgCalcCntrVO.getFmMvmtStsCd().equals("DR")) {
					
					// [vvd code가 null이면] searchVVDCode( bookingNo) 
					if(chgPartialPaymentVO.getVslCd() == null || chgPartialPaymentVO.getSkdVoyNo() == null
							|| chgPartialPaymentVO.getSkdDirCd() == null) {
						
						String vvdCode = dbDao.searchVVDCode(chgPartialPaymentVO.getBkgNo());
						// YSEA0006E (4:4:1)
						if(!vvdCode.equals("")) {
							chgPartialPaymentVO.setVslCd(vvdCode.substring(0, 4));
							chgPartialPaymentVO.setSkdVoyNo(vvdCode.substring(4, 8));
							chgPartialPaymentVO.setSkdDirCd(vvdCode.substring(8));
						}
					}
					
					// ------------ DmtChgBkgCntrVO 객체 구성 -----------------
					DmtChgBkgCntrVO dmtChgBkgCntrVO = new DmtChgBkgCntrVO();
					dmtChgBkgCntrVO.setSvrId(chgCalcCntrVO.getSvrId());
					dmtChgBkgCntrVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					dmtChgBkgCntrVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					
					dmtChgBkgCntrVO.setBlNo(chgPartialPaymentVO.getBlNo());
					//--------------- ChargePartialPaymentVO -------------------
					dmtChgBkgCntrVO.setVslCd(chgPartialPaymentVO.getVslCd());
					dmtChgBkgCntrVO.setSkdVoyNo(chgPartialPaymentVO.getSkdVoyNo());
					dmtChgBkgCntrVO.setSkdDirCd(chgPartialPaymentVO.getSkdDirCd());
					//--------------------------------------------------------
					dmtChgBkgCntrVO.setVpsEtaDt(retChgCalcCntrVO.getVpsEtaDt());
					dmtChgBkgCntrVO.setScNo(retChgCalcCntrVO.getBrhScNo());
					dmtChgBkgCntrVO.setRfaNo(retChgCalcCntrVO.getBrhRfaNo());
					dmtChgBkgCntrVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
					dmtChgBkgCntrVO.setRepCmdtCd(retChgCalcCntrVO.getRepCmdtCd());
					dmtChgBkgCntrVO.setDcgoFlg(retChgCalcCntrVO.getDcgoFlg());
					dmtChgBkgCntrVO.setRcFlg(retChgCalcCntrVO.getRcFlg());
					dmtChgBkgCntrVO.setBbCgoFlg(retChgCalcCntrVO.getBbCgoFlg());
					dmtChgBkgCntrVO.setAwkCgoFlg(retChgCalcCntrVO.getAwkCgoFlg());
					dmtChgBkgCntrVO.setRdCgoFlg(retChgCalcCntrVO.getRdCgoFlg());
					dmtChgBkgCntrVO.setSocFlg(retChgCalcCntrVO.getSocFlg());
					dmtChgBkgCntrVO.setCntrPrtFlg(retChgCalcCntrVO.getCntrPrtFlg());
					dmtChgBkgCntrVO.setAdvShtgCd(retChgCalcCntrVO.getAdvShtgCd());
					dmtChgBkgCntrVO.setDmdtCntrTpCd(retChgCalcCntrVO.getCntrTp());
					dmtChgBkgCntrVO.setDmdtBkgCgoTpCd(retChgCalcCntrVO.getDmdtCgoTpCd());
					dmtChgBkgCntrVO.setPorCd(retChgCalcCntrVO.getPorCd());
					dmtChgBkgCntrVO.setPolCd(retChgCalcCntrVO.getPolCd());
					dmtChgBkgCntrVO.setPodCd(retChgCalcCntrVO.getPodCd());
					dmtChgBkgCntrVO.setDelCd(retChgCalcCntrVO.getDelCd());
					dmtChgBkgCntrVO.setBkgRcvTermCd(retChgCalcCntrVO.getBbRcvTermCd());
					dmtChgBkgCntrVO.setBkgDeTermCd(retChgCalcCntrVO.getBbDeTermCd());
					dmtChgBkgCntrVO.setBkgCntrQty(retChgCalcCntrVO.getBkgQty());
					dmtChgBkgCntrVO.setSlsOfcCd(retChgCalcCntrVO.getSalOfc());
					dmtChgBkgCntrVO.setRhqCd(retChgCalcCntrVO.getSalRhq());
					dmtChgBkgCntrVO.setUpdUsrId(account.getUsr_id());
					dmtChgBkgCntrVO.setUpdOfcCd(account.getOfc_cd());
					
					dbDao.modifyBookingContainer(dmtChgBkgCntrVO);
				}
				
				// 11. 해당 Charge가 Office Transfer 된 Charge면 변경된 Office와 RHQ를 Charge의 Office와 RHQ로 설정하고 아니면 계산시 설정된 Office와 RHQ를 저장한다
				/*
				OfficeNRHQVO officeNRHQVO = null;
				if(chargeCalculationContainerVO.getOfcTrnsFlg().equals("Y")) {
					officeNRHQVO = dbDao.checkOfficeTransfer(chgArgVO); 
				}
				*/
				
				// ************* DmtChgCalcVO 객체 구성 *****************
				DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
				dmtChgCalcVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCalcVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCalcVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCalcVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCalcVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCalcVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				dmtChgCalcVO.setFmMvmtStsCd(chgCalcCntrVO.getFmMvmtStsCd());
				dmtChgCalcVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				dmtChgCalcVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				dmtChgCalcVO.setToMvmtStsCd(chgCalcCntrVO.getToMvmtStsCd());
				dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
				dmtChgCalcVO.setToMvmtYdCd(chgCalcCntrVO.getToMvmtYdCd());
				dmtChgCalcVO.setNotCreBalFlg("N");
				dmtChgCalcVO.setFtDys(retChgCalcCntrVO.getFtDys());
				dmtChgCalcVO.setFtCmncDt(retChgCalcCntrVO.getFtCmncDt());
				dmtChgCalcVO.setFtEndDt(retChgCalcCntrVO.getFtEndDt());
				dmtChgCalcVO.setFxFtOvrDys(retChgCalcCntrVO.getFxFtOvrDys());
				dmtChgCalcVO.setOrgFtOvrDys(retChgCalcCntrVO.getOrgFtOvrDys());
				dmtChgCalcVO.setScRfaExptOvrDys(retChgCalcCntrVO.getScRfaExptOvrDys());
				dmtChgCalcVO.setAftExptOvrDys(retChgCalcCntrVO.getAftExptOvrDys());
				dmtChgCalcVO.setBzcTrfCurrCd(retChgCalcCntrVO.getBzcTrfCurrCd());
				dmtChgCalcVO.setDmdtTrfAplyTpCd(retChgCalcCntrVO.getDmdtTrfAplyTpCd());
				dmtChgCalcVO.setOrgChgAmt(retChgCalcCntrVO.getOrgChgAmt());
				dmtChgCalcVO.setScRfaExptAmt(retChgCalcCntrVO.getScRfaExptAmt());
				dmtChgCalcVO.setAftExptDcAmt(retChgCalcCntrVO.getAftExptDcAmt());
				dmtChgCalcVO.setBilAmt(retChgCalcCntrVO.getBilAmt());
				dmtChgCalcVO.setDmdtChgStsCd(retChgCalcCntrVO.getDmdtChgStsCd());
				
				dmtChgCalcVO.setScRfaAmt(retChgCalcCntrVO.getScRfaAmt());
				dmtChgCalcVO.setAftExptAmt(retChgCalcCntrVO.getAftExptAmt());
				dmtChgCalcVO.setBzcTrfSeq(retChgCalcCntrVO.getBzcTrfSeq());
				dmtChgCalcVO.setBzcTrfGrpSeq(retChgCalcCntrVO.getBzcTrfGrpSeq());
				dmtChgCalcVO.setBzcTrfAplyDt(retChgCalcCntrVO.getBzcTrfAplyDt());		
				dmtChgCalcVO.setRfaExptAproNo(retChgCalcCntrVO.getRfaExptAproNo());
				dmtChgCalcVO.setRfaExptDarNo(retChgCalcCntrVO.getRfaExptDarNo());
				dmtChgCalcVO.setRfaExptMapgSeq(retChgCalcCntrVO.getRfaExptMapgSeq());		
				dmtChgCalcVO.setRfaExptVerSeq(retChgCalcCntrVO.getRfaExptVerSeq());
				dmtChgCalcVO.setRfaRqstDtlSeq(retChgCalcCntrVO.getRfaRqstDtlSeq());
				dmtChgCalcVO.setAftExptAproNo(retChgCalcCntrVO.getAftExptAproNo());
				dmtChgCalcVO.setAftExptDarNo(retChgCalcCntrVO.getAftExptDarNo());
				dmtChgCalcVO.setAftExptAdjSeq(retChgCalcCntrVO.getAftExptAdjSeq());
				//dmtChgCalcVO.setScNo(retChgCalcCntrVO.getBrhScNo());
				dmtChgCalcVO.setScNo(retChgCalcCntrVO.getScNo());		//2011.01.24. AA 요청
				dmtChgCalcVO.setScExptVerSeq(retChgCalcCntrVO.getScExptVerSeq());
				dmtChgCalcVO.setScExptGrpSeq(retChgCalcCntrVO.getScExptGrpSeq());
				dmtChgCalcVO.setScRfaExptAplyDt(retChgCalcCntrVO.getScRfaExptAplyDt());
				dmtChgCalcVO.setCorrRmk(chgCalcCntrVO.getCorrRmk());
				
				dmtChgCalcVO.setOfcCd(chgCalcCntrVO.getOfcCd());
				dmtChgCalcVO.setOfcRhqCd(chgCalcCntrVO.getOfcRhqCd());
				dmtChgCalcVO.setUpdUsrId(account.getUsr_id());
				dmtChgCalcVO.setUpdOfcCd(account.getOfc_cd());
				dmtChgCalcVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
				dmtChgCalcVO.setCmdtTrfSeq(retChgCalcCntrVO.getCmdtTrfSeq());
				dmtChgCalcVO.setCmdtExptAplyDt(retChgCalcCntrVO.getCmdtExptAplyDt());
				dmtChgCalcVO.setCmdtOvrDys(retChgCalcCntrVO.getCmdtOvrDys());
				dmtChgCalcVO.setCmdtExptAmt(retChgCalcCntrVO.getCmdtExptAmt());
				dmtChgCalcVO.setWebMtyDt(chgCalcCntrVO.getWebMtyDt().replace("-", ""));
				
				// 12. 계산된 Cahrge를 Charge Master Table에 Update한다
				dbDao.modifyChargeCalculation(dmtChgCalcVO);
				
				if(chgCalcCntrVO.getDulTpExptFlg().equals("Y")) {
					// Dual Exception Charge의 ORG_CHG_AMT, SC_RFA_EXPT_AMT 필드값 수정
					dbDao.modifyOrgChgAmt(chgArgVO);
				}
				
				
				// 13. Clock Stop이 하루라도 적용되었으면 Clock Stop History를 Insert한다
				/*******************************************************************************
				- Charge 계산시 적용된 Clock Stop 이 있을경우 History 를 생성한다.
				- 처리로직
				  1. 기 생성된 Clock Stop History 를 삭제한다. (deleteClockStopHistory)
				  2. 적용된 Clock Stop 갯수만큼 반복문을 실행하며 Insert 한다( addClockStopHistory )
				*******************************************************************************/
				List<String> cStopNoList = retChgCalcCntrVO.getCStopNoList();
				
				if(cStopNoList != null && cStopNoList.size() > 0) {
					DmtChgTmCskStopVO dmtChgTmCskStopVO = new DmtChgTmCskStopVO();
					dmtChgTmCskStopVO.setSvrId(chgCalcCntrVO.getSvrId());
					dmtChgTmCskStopVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					dmtChgTmCskStopVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					dmtChgTmCskStopVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					dmtChgTmCskStopVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					dmtChgTmCskStopVO.setChgSeq(chgCalcCntrVO.getChgSeq());
					dmtChgTmCskStopVO.setCreOfcCd(account.getOfc_cd());
					
					modifyClockStopHistory(dmtChgTmCskStopVO, cStopNoList);
				}
				
				//14. Correction History를 Insert한다
				corrHisSeq++;
				dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
				dbDao.addChargeHistory(dmtChgCorrHisVO);
				
			}
				return resultVO;
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"Charge Recalculation By Booking"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"Charge Recalculation By Booking"}).getMessage());
		}
		//return null;
	}	

	/**
	 * Charge 정보를 재계산하여 수정한다.(Recalculation)<br>
	 * 
	 * @param bkgNo String
	 * @param cntrNo String
	 * @param ydCd String 
	 * @param notificationDt String 
	 * @param account SignOnUserAccount
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO modifyChargeByNTdate(String bkgNo, String cntrNo, String ydCd, String notificationDt, SignOnUserAccount account) {

		DmtResultVO resultVO = new DmtResultVO();
		resultVO.setResultCode("Y");
		try {
				account = new SignOnUserAccount("DMT BATCH", "", "", "", "", "", "", "", "", "", "", "", "BATCH", "",
						"", "", "", "", "", "", "", "");
			
				// retrieve ChargeCalculation with parameters
				ChargeCalculationContainerVO chargeCalCntrVO = new ChargeCalculationContainerVO();
				chargeCalCntrVO.setBkgNo(bkgNo);
				chargeCalCntrVO.setCntrNo(cntrNo);
				chargeCalCntrVO.setFmMvmtYdCd(ydCd);
				chargeCalCntrVO = dbDao.searchChargeDetail(chargeCalCntrVO);
				// throw exception when no data is retrieved
				if (chargeCalCntrVO==null) {
					throw new EventException(new ErrorHandler("DMT00008", new String[]{"NO Charge Calculation Data By Booking No., Container No., Yard Cd."}).getMessage());
				}
				ChargeCalculationContainerVO[] chargeCalculationContainerVOs = new ChargeCalculationContainerVO[] {chargeCalCntrVO};
			
				DMTGeneralChargeCalculationUtil dmtGeneralChargeCalculationUtil = null;
				DMTBalanceChargeCalculationUtil dmtBalanceChargeCalculationUtil = null;
				DMTCancelChargeCalculationUtil	dmtCancelChargeCalculationUtil	= null;
				DMTCombinedChargeCalculationUtil dmtCombinedChargeCalculationUtil = null;
				com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
				ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs[i];
				// set From_Movement_Date with Notification_Date from parameter
				chgCalcCntrVO.setFmMvmtDt(notificationDt);				
			
				chgCalcCntrVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt().replace("-", ""));
				chgCalcCntrVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt().replace("-", ""));
			
				ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
				chgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				chgArgVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				chgArgVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				/*
				- Balance Charge가 없거나, 있으면 마지막 Balance Charge만 D/R Date 저장 가능.
				- Balance Charge가 있는 Charge일 경우  "There is a balance charge!" Alert창  띄우며 오류 처리.
				*/
				String chgMaxSeq = dbDao.searchChargeMaxSequence(chgArgVO);
				
				if(!chgCalcCntrVO.getChgSeq().equals(chgMaxSeq)) {
					//"There is a balance charge !"
					resultVO.setResultCode("N");
					return resultVO;
				}
				
				
				// Charge가 Invoice되었는지 여부를 Check하여 Invoice되었으면 오류 처리
				boolean chgInvChk = dbDao.searchChargeInvoiceCheck(chgArgVO);
				if(chgInvChk) {
					//"Already Invoiced"
					resultVO.setResultCode("N");
					return resultVO;
				}
				
				// Web Cancel 일 경우, To MVMT Date, To MVMT Yard, To MVMt Status정보를  초기화
				/*if(chargeCalculationContainerVO.getWebCancelFlg().equals("Y")) {
					chargeCalculationContainerVO.setToMvmtDt("");
					chargeCalculationContainerVO.setToMvmtYdCd("");
					chargeCalculationContainerVO.setToMvmtStsCd("");
				}*/
				
			
				//  To Movement Status가 "DR"이나 "CS"인 경우, 현재 일자와 To Date를 비교하여 To Date가 작으면  오류 처리
				String toMvmtStsCd = chgCalcCntrVO.getToMvmtStsCd();
				
				// DR Date Checking
				if(toMvmtStsCd.equals("DR")) {
					//String currDt = DateTime.getDateString().replace(".","");
					// User Office별 현재일자 조회
					String currDt	= dbDao.searchCurrentDateByOffice(account.getOfc_cd());
					String toMvmtDt	= chgCalcCntrVO.getToMvmtDt();
					
					if(currDt.compareTo(toMvmtDt) > 0) {
						// D/R Date should be same or later than current date
						resultVO.setResultCode("N");
						return resultVO;
					}
				} else if(toMvmtStsCd.equals("CS")) {
					// Clock Stop
					String fmMvmtDt = chgCalcCntrVO.getFmMvmtDt();
					String toMvmtDt = chgCalcCntrVO.getToMvmtDt();
					
					if(fmMvmtDt.compareTo(toMvmtDt) >= 0) {
						// CS date should be later than From date
						resultVO.setResultCode("N");
						return resultVO;
					}
				}
			
				
				com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = null;
				chargeArgumentVO = new com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
				chargeArgumentVO.setSvrId(chgCalcCntrVO.getSvrId());
				chargeArgumentVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chargeArgumentVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chargeArgumentVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chargeArgumentVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chargeArgumentVO.setChgSeq(chgCalcCntrVO.getChgSeq());
			
				// 해당 Charge의 Correction History가 존재하는지 Check하여 없으면 Correction History를 Insert한다.
				int corrHisSeq = dmtCalculationUtil.checkChargeCorrection(chargeArgumentVO);
				
				DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
				dmtChgCorrHisVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCorrHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCorrHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCorrHisVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCorrHisVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCorrHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				dmtChgCorrHisVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				dmtChgCorrHisVO.setCorrHisRmk(chgCalcCntrVO.getCorrRmk());
				dmtChgCorrHisVO.setCreUsrId(account.getUsr_id());
				dmtChgCorrHisVO.setCreOfcCd(account.getOfc_cd());
				
				if(corrHisSeq == 0) {
					corrHisSeq++;
					dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
					dbDao.addChargeHistory(dmtChgCorrHisVO);
				}
				
				
				// ***********  ChargeCalculationUseData  *************
				ChargePartialPaymentVO chgPartialPaymentVO = dbDao.searchChargeCalculationUseData(chgArgVO);
				
				if(chgCalcCntrVO.getSvrId().equals("EUR")) {
					String obCntrFlg = dbDao.searchInOutBoundByMovement(chgCalcCntrVO.getCntrNo(), chgCalcCntrVO.getCntrCycNo(), chgCalcCntrVO.getFmMvmtYdCd());
					//log.debug("============> OB_CNTR_FLG : " + obCntrFlg);
					// 'N' --> 'I'  , 'Y' --> 'O'
					
					// DATA존재시, IN/OUT BOUND 값을 사용한다.
					if(!obCntrFlg.equals("")) {
						String ioBndCd = obCntrFlg.equals("N") ? "I" : "O";
						chgPartialPaymentVO.setIoBndCd(ioBndCd);
					}
				}
				
				//chgCalcCntrVO.setFmMvmtDt(chgPartialPaymentVO.getFmMvmtDt());
				
				/*
				 "L"(Long Staying), "U"(Unfinished), "N"(No Charge) 인  경우, To Date/Yard를 입력하지 않아도 Re-Calculation 가능
				    즉, To Date를 초기화한다
				 */
				//String chgStsCd = chargeCalculationContainerVO.getDmdtChgStsCd();
				if( //(chgStsCd.equals("L") || chgStsCd.equals("U") || chgStsCd.equals("N")) && 
					chgPartialPaymentVO.getToMvmtDt().length() < 12 ) {
					chgCalcCntrVO.setToMvmtDt("");
				} else
					chgCalcCntrVO.setToMvmtDt(chgPartialPaymentVO.getToMvmtDt());
				
				
				// MT Notification된 Data의 경우(To Movement="DR"이고 Web Indicator="Y"), Web Indicator를 "N"으로 Update한다.
				if( ("Y".equals(chgCalcCntrVO.getWebIndFlg()) && chgCalcCntrVO.getToMvmtStsCd().equals("DR"))) {
					chgArgVO.setWebIndFlg("N");
					dbDao.modifyChargeWebIndicator(chgArgVO);
				}
				
				
				ChargeCalculationParmVO chgCalcParmVO = new ChargeCalculationParmVO();
				chgCalcParmVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgCalcParmVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgCalcParmVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgCalcParmVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgCalcParmVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgCalcParmVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				chgCalcParmVO.setActCntCd(chgPartialPaymentVO.getActCntCd());
				chgCalcParmVO.setActCustSeq(chgPartialPaymentVO.getActCustSeq());
				chgCalcParmVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				chgCalcParmVO.setCntrTpszCd(chgCalcCntrVO.getCntrTpszCd());
				chgCalcParmVO.setCustCntCd(chgPartialPaymentVO.getCustCntCd());
				chgCalcParmVO.setCustSeq(chgPartialPaymentVO.getCustSeq());
				chgCalcParmVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				chgCalcParmVO.setFmMvmtStsCd(chgCalcCntrVO.getFmMvmtStsCd());
				chgCalcParmVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				chgCalcParmVO.setIoBndCd(chgPartialPaymentVO.getIoBndCd());
				chgCalcParmVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				chgCalcParmVO.setToMvmtStsCd(chgCalcCntrVO.getToMvmtStsCd());
				chgCalcParmVO.setToMvmtYdCd(chgCalcCntrVO.getToMvmtYdCd());
				
				
				if(chgCalcCntrVO.getDulTpExptFlg().equals("Y")) {
					// Dual Exception Charge중 Combined Charge에 대한 Dual Charge를 조회한다..
					List<ChargeCalculationContainerVO> chgCalcCntrVOs = dbDao.searchDualChargeTariff(chgArgVO);
					
					if(chgCalcCntrVOs != null && chgCalcCntrVOs.size() > 0) {
						String callFlag = "SAVE";
						
						chgArgVO.setCallFlag(callFlag);
						resultVO = dualExceptionChargeCalculation(callFlag, chgCalcCntrVO, chgCalcCntrVOs, account);
						
						// 오류 발생시 Return
						if(resultVO.getResultCode() != null) {
							resultVO.setResultCode("N");
							return resultVO;
						}
					}
					
					dmtCombinedChargeCalculationUtil = new DMTCombinedChargeCalculationUtil();
	//				retChgCalcCntrVO = dmtCombinedChargeCalculationUtil.combinedChargeCalculation(chgCalcParmVO);
					//2011.04.29. 추가 ("DR"일때 아닐때 구분)
					if(!chgCalcCntrVO.getFmMvmtStsCd().equals("DR")){
						retChgCalcCntrVO = dmtCombinedChargeCalculationUtil.combinedChargeCalculation(chgCalcParmVO);
						if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
							log.error("\n\n combinedChargeCalculation ERROR [Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
							resultVO.setResultCode("N");
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					}else{
						dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
						retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
						
						if (retChgCalcCntrVO.getMsgCd().equals("-1")) {
							log.error("\n\n[DMT02036][Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
							resultVO.setResultCode("N");
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					}				
				} else {
					if(chgCalcCntrVO.getCxlBkgChgFlg().equals("Y")) {
						dmtCancelChargeCalculationUtil	= new DMTCancelChargeCalculationUtil();
						retChgCalcCntrVO = dmtCancelChargeCalculationUtil.cancelChargeCalculation(chgCalcParmVO);
						
						if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
							resultVO.setResultCode("N");
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					} else {
						// From Movement Status가 "DR"이 아니면 General Charge를 계산하고, "DR"이면 Balance Charge를 계산한다
						if(!chgCalcCntrVO.getFmMvmtStsCd().equals("DR")) {
							dmtGeneralChargeCalculationUtil = new DMTGeneralChargeCalculationUtil();
							retChgCalcCntrVO = dmtGeneralChargeCalculationUtil.generalChargeCalculation(chgCalcParmVO);
							
							if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
								resultVO.setResultCode("N");
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						} else {
							dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
							retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
							if(retChgCalcCntrVO.getMsgCd().equals("-1")) {
								resultVO.setResultCode("N");
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						}
					}
				}
			
			// 위에서 계산한 Operation의 Return값이 0이 아니면 Charge Status를 "E"(Error)로 Setting한다
				if(!retChgCalcCntrVO.getMsgCd().equals("0")) {
					retChgCalcCntrVO.setDmdtChgStsCd("E");
					chgCalcCntrVO.setCorrRmk(chgCalcCntrVO.getCorrRmk() + " " + retChgCalcCntrVO.getMsgDesc());
				}
				
				// From Movement Status가 "DR"이 아니면 General Charge를 계산하고 Parameter로 받은 Data중 BKG CNTR관련 Data를 BKG CNTR Table에 Data를   Update한다. 
				// 단 Parameter로 받은 Data중 VVD Code가 Null이면 Booking의 Trunk VVD를 조회한다.
				if(!chgCalcCntrVO.getFmMvmtStsCd().equals("DR")) {
					
					// [vvd code가 null이면] searchVVDCode( bookingNo) 
					if(chgPartialPaymentVO.getVslCd() == null || chgPartialPaymentVO.getSkdVoyNo() == null
							|| chgPartialPaymentVO.getSkdDirCd() == null) {
						
						String vvdCode = dbDao.searchVVDCode(chgPartialPaymentVO.getBkgNo());
						// YSEA0006E (4:4:1)
						if(!vvdCode.equals("")) {
							chgPartialPaymentVO.setVslCd(vvdCode.substring(0, 4));
							chgPartialPaymentVO.setSkdVoyNo(vvdCode.substring(4, 8));
							chgPartialPaymentVO.setSkdDirCd(vvdCode.substring(8));
						}
					}
					
					// ------------ DmtChgBkgCntrVO 객체 구성 -----------------
					DmtChgBkgCntrVO dmtChgBkgCntrVO = new DmtChgBkgCntrVO();
					dmtChgBkgCntrVO.setSvrId(chgCalcCntrVO.getSvrId());
					dmtChgBkgCntrVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					dmtChgBkgCntrVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					
					dmtChgBkgCntrVO.setBlNo(chgPartialPaymentVO.getBlNo());
					//--------------- ChargePartialPaymentVO -------------------
					dmtChgBkgCntrVO.setVslCd(chgPartialPaymentVO.getVslCd());
					dmtChgBkgCntrVO.setSkdVoyNo(chgPartialPaymentVO.getSkdVoyNo());
					dmtChgBkgCntrVO.setSkdDirCd(chgPartialPaymentVO.getSkdDirCd());
					//--------------------------------------------------------
					dmtChgBkgCntrVO.setVpsEtaDt(retChgCalcCntrVO.getVpsEtaDt());
					dmtChgBkgCntrVO.setScNo(retChgCalcCntrVO.getBrhScNo());
					dmtChgBkgCntrVO.setRfaNo(retChgCalcCntrVO.getBrhRfaNo());
					dmtChgBkgCntrVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
					dmtChgBkgCntrVO.setRepCmdtCd(retChgCalcCntrVO.getRepCmdtCd());
					dmtChgBkgCntrVO.setDcgoFlg(retChgCalcCntrVO.getDcgoFlg());
					dmtChgBkgCntrVO.setRcFlg(retChgCalcCntrVO.getRcFlg());
					dmtChgBkgCntrVO.setBbCgoFlg(retChgCalcCntrVO.getBbCgoFlg());
					dmtChgBkgCntrVO.setAwkCgoFlg(retChgCalcCntrVO.getAwkCgoFlg());
					dmtChgBkgCntrVO.setRdCgoFlg(retChgCalcCntrVO.getRdCgoFlg());
					dmtChgBkgCntrVO.setSocFlg(retChgCalcCntrVO.getSocFlg());
					dmtChgBkgCntrVO.setCntrPrtFlg(retChgCalcCntrVO.getCntrPrtFlg());
					dmtChgBkgCntrVO.setAdvShtgCd(retChgCalcCntrVO.getAdvShtgCd());
					dmtChgBkgCntrVO.setDmdtCntrTpCd(retChgCalcCntrVO.getCntrTp());
					dmtChgBkgCntrVO.setDmdtBkgCgoTpCd(retChgCalcCntrVO.getDmdtCgoTpCd());
					dmtChgBkgCntrVO.setPorCd(retChgCalcCntrVO.getPorCd());
					dmtChgBkgCntrVO.setPolCd(retChgCalcCntrVO.getPolCd());
					dmtChgBkgCntrVO.setPodCd(retChgCalcCntrVO.getPodCd());
					dmtChgBkgCntrVO.setDelCd(retChgCalcCntrVO.getDelCd());
					dmtChgBkgCntrVO.setBkgRcvTermCd(retChgCalcCntrVO.getBbRcvTermCd());
					dmtChgBkgCntrVO.setBkgDeTermCd(retChgCalcCntrVO.getBbDeTermCd());
					dmtChgBkgCntrVO.setBkgCntrQty(retChgCalcCntrVO.getBkgQty());
					dmtChgBkgCntrVO.setSlsOfcCd(retChgCalcCntrVO.getSalOfc());
					dmtChgBkgCntrVO.setRhqCd(retChgCalcCntrVO.getSalRhq());
					dmtChgBkgCntrVO.setUpdUsrId(account.getUsr_id());
					dmtChgBkgCntrVO.setUpdOfcCd(account.getOfc_cd());
					
					dbDao.modifyBookingContainer(dmtChgBkgCntrVO);
				}
				
				// 11. 해당 Charge가 Office Transfer 된 Charge면 변경된 Office와 RHQ를 Charge의 Office와 RHQ로 설정하고 아니면 계산시 설정된 Office와 RHQ를 저장한다
				/*
				OfficeNRHQVO officeNRHQVO = null;
				if(chargeCalculationContainerVO.getOfcTrnsFlg().equals("Y")) {
					officeNRHQVO = dbDao.checkOfficeTransfer(chgArgVO); 
				}
				*/
				
				// ************* DmtChgCalcVO 객체 구성 *****************
				DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
				dmtChgCalcVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCalcVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCalcVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCalcVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCalcVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCalcVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				dmtChgCalcVO.setFmMvmtStsCd(chgCalcCntrVO.getFmMvmtStsCd());
				dmtChgCalcVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				dmtChgCalcVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				dmtChgCalcVO.setToMvmtStsCd(chgCalcCntrVO.getToMvmtStsCd());
				dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
				dmtChgCalcVO.setToMvmtYdCd(chgCalcCntrVO.getToMvmtYdCd());
				dmtChgCalcVO.setNotCreBalFlg("N");
				dmtChgCalcVO.setFtDys(retChgCalcCntrVO.getFtDys());
				dmtChgCalcVO.setFtCmncDt(retChgCalcCntrVO.getFtCmncDt());
				dmtChgCalcVO.setFtEndDt(retChgCalcCntrVO.getFtEndDt());
				dmtChgCalcVO.setFxFtOvrDys(retChgCalcCntrVO.getFxFtOvrDys());
				dmtChgCalcVO.setOrgFtOvrDys(retChgCalcCntrVO.getOrgFtOvrDys());
				dmtChgCalcVO.setScRfaExptOvrDys(retChgCalcCntrVO.getScRfaExptOvrDys());
				dmtChgCalcVO.setAftExptOvrDys(retChgCalcCntrVO.getAftExptOvrDys());
				dmtChgCalcVO.setBzcTrfCurrCd(retChgCalcCntrVO.getBzcTrfCurrCd());
				dmtChgCalcVO.setDmdtTrfAplyTpCd(retChgCalcCntrVO.getDmdtTrfAplyTpCd());
				dmtChgCalcVO.setOrgChgAmt(retChgCalcCntrVO.getOrgChgAmt());
				dmtChgCalcVO.setScRfaExptAmt(retChgCalcCntrVO.getScRfaExptAmt());
				dmtChgCalcVO.setAftExptDcAmt(retChgCalcCntrVO.getAftExptDcAmt());
				dmtChgCalcVO.setBilAmt(retChgCalcCntrVO.getBilAmt());
				dmtChgCalcVO.setDmdtChgStsCd(retChgCalcCntrVO.getDmdtChgStsCd());
				
				dmtChgCalcVO.setScRfaAmt(retChgCalcCntrVO.getScRfaAmt());
				dmtChgCalcVO.setAftExptAmt(retChgCalcCntrVO.getAftExptAmt());
				dmtChgCalcVO.setBzcTrfSeq(retChgCalcCntrVO.getBzcTrfSeq());
				dmtChgCalcVO.setBzcTrfGrpSeq(retChgCalcCntrVO.getBzcTrfGrpSeq());
				dmtChgCalcVO.setBzcTrfAplyDt(retChgCalcCntrVO.getBzcTrfAplyDt());		
				dmtChgCalcVO.setRfaExptAproNo(retChgCalcCntrVO.getRfaExptAproNo());
				dmtChgCalcVO.setRfaExptDarNo(retChgCalcCntrVO.getRfaExptDarNo());
				dmtChgCalcVO.setRfaExptMapgSeq(retChgCalcCntrVO.getRfaExptMapgSeq());		
				dmtChgCalcVO.setRfaExptVerSeq(retChgCalcCntrVO.getRfaExptVerSeq());
				dmtChgCalcVO.setRfaRqstDtlSeq(retChgCalcCntrVO.getRfaRqstDtlSeq());
				dmtChgCalcVO.setAftExptAproNo(retChgCalcCntrVO.getAftExptAproNo());
				dmtChgCalcVO.setAftExptDarNo(retChgCalcCntrVO.getAftExptDarNo());
				dmtChgCalcVO.setAftExptAdjSeq(retChgCalcCntrVO.getAftExptAdjSeq());
				//dmtChgCalcVO.setScNo(retChgCalcCntrVO.getBrhScNo());
				dmtChgCalcVO.setScNo(retChgCalcCntrVO.getScNo());		//2011.01.24. AA 요청
				dmtChgCalcVO.setScExptVerSeq(retChgCalcCntrVO.getScExptVerSeq());
				dmtChgCalcVO.setScExptGrpSeq(retChgCalcCntrVO.getScExptGrpSeq());
				dmtChgCalcVO.setScRfaExptAplyDt(retChgCalcCntrVO.getScRfaExptAplyDt());
				dmtChgCalcVO.setCorrRmk(chgCalcCntrVO.getCorrRmk());
				
				dmtChgCalcVO.setOfcCd(chgCalcCntrVO.getOfcCd());
				dmtChgCalcVO.setOfcRhqCd(chgCalcCntrVO.getOfcRhqCd());
				dmtChgCalcVO.setUpdUsrId(account.getUsr_id());
				dmtChgCalcVO.setUpdOfcCd(account.getOfc_cd());
				dmtChgCalcVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
				dmtChgCalcVO.setCmdtTrfSeq(retChgCalcCntrVO.getCmdtTrfSeq());
				dmtChgCalcVO.setCmdtExptAplyDt(retChgCalcCntrVO.getCmdtExptAplyDt());
				dmtChgCalcVO.setCmdtOvrDys(retChgCalcCntrVO.getCmdtOvrDys());
				dmtChgCalcVO.setCmdtExptAmt(retChgCalcCntrVO.getCmdtExptAmt());
				dmtChgCalcVO.setWebMtyDt(chgCalcCntrVO.getWebMtyDt().replace("-", ""));
				
				// 12. 계산된 Cahrge를 Charge Master Table에 Update한다
				dbDao.modifyChargeCalculation(dmtChgCalcVO);
				
				if(chgCalcCntrVO.getDulTpExptFlg().equals("Y")) {
					// Dual Exception Charge의 ORG_CHG_AMT, SC_RFA_EXPT_AMT 필드값 수정
					dbDao.modifyOrgChgAmt(chgArgVO);
				}
				
				
				// 13. Clock Stop이 하루라도 적용되었으면 Clock Stop History를 Insert한다
				/*******************************************************************************
				- Charge 계산시 적용된 Clock Stop 이 있을경우 History 를 생성한다.
				- 처리로직
				  1. 기 생성된 Clock Stop History 를 삭제한다. (deleteClockStopHistory)
				  2. 적용된 Clock Stop 갯수만큼 반복문을 실행하며 Insert 한다( addClockStopHistory )
				*******************************************************************************/
				List<String> cStopNoList = retChgCalcCntrVO.getCStopNoList();
				
				if(cStopNoList != null && cStopNoList.size() > 0) {
					DmtChgTmCskStopVO dmtChgTmCskStopVO = new DmtChgTmCskStopVO();
					dmtChgTmCskStopVO.setSvrId(chgCalcCntrVO.getSvrId());
					dmtChgTmCskStopVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					dmtChgTmCskStopVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					dmtChgTmCskStopVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					dmtChgTmCskStopVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					dmtChgTmCskStopVO.setChgSeq(chgCalcCntrVO.getChgSeq());
					dmtChgTmCskStopVO.setCreOfcCd(account.getOfc_cd());
					
					modifyClockStopHistory(dmtChgTmCskStopVO, cStopNoList);
				}
				
				//14. Correction History를 Insert한다
				corrHisSeq++;
				dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
				dbDao.addChargeHistory(dmtChgCorrHisVO);
				
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			//throw new EventException(new ErrorHandler("DMT00008", new String[]{"Charge Recalculation By Notification Date"}).getMessage());
			resultVO.setResultCode("N");
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			//throw new EventException(new ErrorHandler("DMT00008", new String[]{"Charge Recalculation By Notification Date"}).getMessage());
			resultVO.setResultCode("N");
		}
		return resultVO;
	}	

    /**
     * 화면에서 당일 일배치를 Call
     * @param ChargeArgumentVO chargeArgumentVO
	 * @param SignOnUserAccount account
     * @return
     * @throws EventException
     */
	public String createDailyBatchByBooking(ChargeArgumentVO chargeArgumentVO, SignOnUserAccount account) throws EventException {
		String result = "N";
		try {
			log.debug("[createDailyBatchByBooking bc=====================>]");
			String bkgNo 	= chargeArgumentVO.getBkgNo();	//bkg_no
			String cntrNo 	= chargeArgumentVO.getBatchCntr();
			String trfCd 	= chargeArgumentVO.getDmdtTrfCd();
			String batRunTmId 	= chargeArgumentVO.getBatRunTmId();
			String today 	= dbDao.searchCurrentDateByOffice(account.getOfc_cd());
			log.debug("[param]"+bkgNo+":"+cntrNo+":"+trfCd+ ":"+today + ":" + batRunTmId);
			String innerFlag = "";
			
			innerFlag = "#";
			String param = today + innerFlag + bkgNo + innerFlag + trfCd + innerFlag + batRunTmId + innerFlag + cntrNo;
			innerFlag = createDailyBatchByBooking(param);
			if (!innerFlag.equals("Y")) { 	// if not success
				result = "N";
			} else {
				result = "R";
//				dbDao.updateManualBatchHistroy(bkgNo, trfCd, batRunTmId, account);
			}

		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return result;    	
	}
	
   /**
	 * Monthly Batch Call
	 * @param String params
	 * @return
	 * @throws EventException
	 */
	public String createDailyBatchByBooking(String params) throws EventException{
		
		ScheduleUtil su = new ScheduleUtil();
       
		try {
			log.debug("EES_DMT_B004:::" + params);
			String job_id = su.directExecuteJob("EES_DMT_B004",params);
			log.debug("EES_DMT_B004 job_id:::" + job_id);

		} catch (IOException e) {
			log.error("[IOException]"+e.getMessage());
			throw new EventException(new ErrorHandler("COM12213", new String[]{"EES_DMT_B004 CALL::" + params}).getMessage(),e);
		} catch (InterruptedException e) {
			log.error("[InterruptedException]"+e.getMessage());
			throw new EventException(new ErrorHandler("COM12213", new String[]{"EES_DMT_B004 CALL::" + params}).getMessage(),e);
		} catch (DAOException e) {
			log.error("[DAOException]"+e.getMessage());
			throw new EventException(new ErrorHandler("COM12213", new String[]{"EES_DMT_B004 CALL::" + params}).getMessage(),e);
		} catch (Exception e){
			log.error("[Exception]"+e.getMessage());
			throw new EventException(new ErrorHandler("COM12213", new String[]{"EES_DMT_B004 CALL::" + params}).getMessage(),e);
		}
		
		return "Y";  //success
	}
	
    /**
     * 일 배치에 대한 대상 건수가 존재하는지 체크한다.
     * @param ChargeArgumentVO chargeArgumentVO
	 * @param SignOnUserAccount account
	 * @param String date
     * @return String
     * @throws EventException
     */
	public String checkDailyMovementCalculationByBooking(ChargeArgumentVO chargeArgumentVO, SignOnUserAccount account, String date) throws EventException {
		String retunValue = "N";
		String[] invoiceNo = null;
		try{
			String today 	= dbDao.searchCurrentDateByOffice(account.getOfc_cd());
			chargeArgumentVO.setToday(today);
			if(chargeArgumentVO.getBatchCntr() == null){
				chargeArgumentVO.setBatchCntr("");
			}
//    		boolean isDaily = dbDao.checkDailyMovementCalculationByBooking(chargeArgumentVO);
    		
//    		if(isDaily){	//배치대상건수가 존재하면 정상 - 다음체크로직 실행
    			invoiceNo = dbDao.checkChargeInvoiceByBooking(chargeArgumentVO);
    			
    			if(invoiceNo != null && invoiceNo.length > 0){
    				retunValue = "I";		//생성할 charge에 invoice가 존재함
    				StringBuffer sb = new StringBuffer();
    				for(int i = 0 ; i < invoiceNo.length; i++){
    					sb.append(",").append(invoiceNo[i]);
    				}
    				retunValue += sb.toString();
    			}else{

    				dbDao.addManualBatchHistroy(chargeArgumentVO, date, account);
    				dbDao.addManualBatchChargeBackup(chargeArgumentVO, account);
    				dbDao.deleteChargeByBooking(chargeArgumentVO);			//DELETE DMT_CHG_CALC
    				dbDao.addManualBatchBkgCntrBackup(chargeArgumentVO, account);
    				dbDao.deleteBookingChargeByBooking(chargeArgumentVO);	//DELETE DMT_CHG_BKG_CNTR
    				
    				retunValue = "Y";		//정상    				
    			}
//    		}else{
//    			retunValue = "N";			//생성할 charge가 존재하지 않음
//    		}
    		
	    } catch(DAOException ex) {
	    	log.error("[DAOException]"+ex.getMessage());
	        throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
	    } catch (Exception ex) {
	    	log.error("[Exception]"+ex.getMessage());
	        throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
	    }
		return retunValue;
	}		

    /**
     * 일 배치에 대한 대상 건수가 존재하는지 체크한다.
     * @param ChargeArgumentVO chargeArgumentVO
     * @return
     * @throws EventException
     */
	public String checkCalculationByBooking(ChargeArgumentVO chargeArgumentVO) throws EventException {
		String retunValue = "";
		try{
			retunValue = dbDao.checkCalculationByBooking(chargeArgumentVO);
	    } catch(DAOException ex) {
	    	log.error("[DAOException]"+ex.getMessage());
	        throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
	    } catch (Exception ex) {
	    	log.error("[Exception]"+ex.getMessage());
	        throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
	    }
		return retunValue;
	}	

    /**
     * 일자 조회
     * @return 
     * @throws EventException
     */
	public String searchDate() throws EventException {
		String retunValue = "";
		try{
			retunValue = dbDao.searchDate();
	    } catch(DAOException ex) {
	    	log.error("[DAOException]"+ex.getMessage());
	        throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
	    } catch (Exception ex) {
	    	log.error("[Exception]"+ex.getMessage());
	        throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
	    }
		return retunValue;
	}	
}