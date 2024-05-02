/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationBCImpl.java
*@FileTitle : Charge Calculation by Office & VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : Hwang HyoKeun
*@LastVersion : 1.0
* 2009.05.21 Hwang HyoKeun
* 1.0 Creation
* 2010.10.20 김태균 [CHM-201006558-01] [EES-DMT] confirm, delete, delete cancel, office transfer 멀티 팝업창에서 처리 안되게 처리
* 2010.10.26 황효근 [CHM-201006671-01] [EES-DMT] T/S Demurrage Free Time 변경
* 2010.10.28 김태균 [] [EES-DMT] 표준위배 수정 및 office transfer 수정사항 반영
* 2010.11.01 황효근 [CHM-201006866-01] [EES-DMT] T/S Demurrage Free Time 재조정
* 2010.11.19 황효근 [CHM-201007214-01] [EES-DMT] Manual Batch by POD ETA 로직 수정
* 2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
* 2010.12.07 김태균 [] [EES-DMT] 표준위배 수정
* 2011.01.24 김태균 [CHM-201108455-01] [DMT] Invoice Error - HKG086108700 :  Partial invoice
* 2011.05.11.김태균 [CHM-201110489-01] [DMT] Balance Charge에 대한 Free Time 적용 배제 요청
* 2011.06.01.김경섭 [] Charge Booking CNTR 정보가 존재하지 여부를 확인하여 등록한다.
* 2011.08.04 김경섭[] [EES-DMT] 표준위배 수정
* 2011.10.11 김현화[] sendEDI시 checkEDI추가.(BKG_CSTMS_KR_MF_SEQ_NO)
* 2011.11.01 김현화[] searchFirstSvrID  FmMvmtYdCd 추가.
* 2011.11.09 김현화[] sendEDOChargeFreeTime추가.(반영 전)
* 2011.11.15 김현화[CHM-201114242-01] Chare Generation 및 재계산시의 Error시 Charge 기초 Data 관련 : ToMvmDt 로직 수정
* 2012.01.17 김현화[] EDO 전송시 chg_seq가 1이 아닌 내용 제외처리
* 2012.01.30 김현화[] EDO 전송대상 선정 로직 추가.- DMIF(DUL_TP_EXPT_FLG = 'N'), CTIC(DUL_TP_EXPT_FLG = 'Y') 만  전송되도록 함.
* 2012.09.11 김현화[CHM-201219003-01]OP-MT Detention Calculation 화면/기능 개발.
* 2013.01.29 김종옥 [CHM-201222168] [DMT] 화면 단에 Exception Cost 계산 Logic 추가  
* 2013.02.08 임창빈[CHM-201322395] DMT OP-MT Detention 계산 방법 보완 3차
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import weblogic.wsee.util.StringUtil;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration.ChargeCalculationDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.AftBkgPathSetupVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.AfterExceptionTariffParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.AfterExceptionTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.BasicCurrencyCoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.BasicTariffParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.BeforeExceptionTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.BkgContainerInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.BookingCustomerBasicVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeBasicFreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeByOfficeOrVVDVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDeletionRequstVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDeltSpecRsnRmkVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeInactivDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeInactivFileVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeInactivHisListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargePartialPaymentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeStatusNRemarkVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChgDeltCngHisVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChgDeltOfcStupVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChgDeltPathStupVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChgDeltPathVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChgDeltRqstFileVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ClockStopVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.CommodityGroupTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.CommodityTariffParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DeleteReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgBkgCntrVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCalcVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCorrHisVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgTmCskStopVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.EDIVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ExceptionCostVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.InactiveInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.InactiveListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.InactiveReasonVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ManualChargeCreationVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.MovementSZPBBParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.MovementSZPBBVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.OPMTChargeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.OfficeTransferParmByChargeVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SCExceptionTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchChgDeltPathStupVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchDeleteMultiDetailReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchDeleteMultiReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchInactiveCheckVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.VDMovementVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.OfficeNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.BKGChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTBalanceChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCancelChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCombinedChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTDualChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTExceptionChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTGeneralChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffKeyVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationAMTVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationTypeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerCntrVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerInvVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChrgDtlVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExceptionChargeCalculationVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExchangeRateParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeEndParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeStartParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.LocationByBoundParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.LocationByBoundVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMgtVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.VVDCheckDataVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoEdiTransVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-DMTClosing Business Logic Basic Command implementation<br>
 * - NIS2010-DMTClosing에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_3001EventResponse,ChargeCalculationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationBCImpl extends BasicCommandSupport implements ChargeCalculationBC {

	// Database Access Object
	private static final long serialVersionUID = -4150151981336531750L;
	private transient ChargeCalculationDBDAO dbDao = null;
	private DMTCalculationUtil dmtCalculationUtil = null;

	/**
	 * ChargeCalculationBCImpl 객체 생성<br>
	 * ChargeCalculationDBDAO를 생성한다.<br>
	 */
	public ChargeCalculationBCImpl() {
		dbDao = new ChargeCalculationDBDAO();
		dmtCalculationUtil = new DMTCalculationUtil();
	}
	
	/**
	 * Office별 또는 VVD별 Charge List를 조회한다<br>
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
	 * Yard별 Container List를 조회한다<br>
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
				if(!"".equals(chargeByOfficeOrVVDVO.getBkgNo())) {
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
				// 3001 - VVD_CD 조회가 아닐 경우
				if(orgBkgNo != null) {
					if(bkgNoFlag)
						chargeByOfficeOrVVDVO.setBkgNo(schNoList.get(i));
					else
						chargeByOfficeOrVVDVO.setBlNo(schNoList.get(i));
				}
				
				
				// byPODETA 인 경우, DMTCalculationUtil.searchCalculationType() 호출
				CalculationTypeParmVO calcTypeParmVO = dbDao.searchMdmLocation(chargeByOfficeOrVVDVO);
				
				if(calcTypeParmVO == null) {
					dmtResultVO.setResultCode("DMT01075");
					return dmtResultVO;	
				}
				
				if(!"vvd_cd".equals(chargeByOfficeOrVVDVO.getCondType()) && !"SELHO".equals(chargeByOfficeOrVVDVO.getUsrRhqOfcCd()) ) {
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
				
				// 'D'ual / 'C'ombined(오류처리)
				if("C".equals(calcType)) {
					/* 
					Charge Calculation by Booking 에서의  byPODETA 조회시 화면 헤더정보 영역 Clear를 위해
					빈 ChargeByBookingHeaderVO 객체 생성후 설정
					*/
					if("booking".equals(chargeByOfficeOrVVDVO.getBypodeta())) {
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
			
			// 3001 - VVD_CD 조회가 아닐 경우
			if(orgBkgNo != null) {
				chargeByOfficeOrVVDVO.setBkgNo(orgBkgNo);
				chargeByOfficeOrVVDVO.setBlNo(orgBlNo);
			}
			
			// 리스트 정보 조회
			List<ChargeCalculationContainerVO> list = dbDao.searchChargeListByPodEta(chargeByOfficeOrVVDVO);
			dmtResultVO.setChargeCalculationContainerVOs(list);
			
			// Charge Calculation by Booking 에서  byPODETA 조회 (조회 결과 데이터 존재)
			if("booking".equals(chargeByOfficeOrVVDVO.getBypodeta()) && list.size() > 0) {
				
				ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
				chgArgVO.setBkgNo(chargeByOfficeOrVVDVO.getBkgNo());
				chgArgVO.setBlNo(chargeByOfficeOrVVDVO.getBlNo());
				chgArgVO.setDmdtChgStsCd(chargeByOfficeOrVVDVO.getDmdtChgStsCd());
				chgArgVO.setDmdtTrfCd(chargeByOfficeOrVVDVO.getDmdtTrfCd());
				chgArgVO.setBypodeta(chargeByOfficeOrVVDVO.getBypodeta());
				
				// 헤더정보 조회
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
	 * GRP INV Creation 대상 Charge의 Exchange Rate 정보를 조회한다.
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
	 * Booking별 Container Charge List 조회<br>
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
	 * Container별 Tariff Type별 Charge 한건을 조회한다<br>
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
			
			
			// 메뉴경로로 호출 --> cntr_cyc_no 조회해와야 함
			if("M".equals(chargeArgumentVO.getCallFlag())) {
				
				// CNTR No, Tariff Type, Location Division Code로 가장 최근에 생성된 Charge의 CNTR Cycle No, Charge Seqence를 조회한다.
				// DATA 조회시, SVR_ID는 로그인 USER의 CNT_CD를 기준으로 조회한다.
				ChargeArgumentVO retChgArgVO = dbDao.searchCycleNoNSequence(chargeArgumentVO);
			
				
				// 가장 최근에 생성된 Charge의 CNTR Cycle No, Charge Seqence 정보 조회건 존재시,
				// 정상적인 조회 처리로직 진행
				if(!"".equals(retChgArgVO.getCntrCycNo())) {
					chargeArgumentVO.setSvrId(retChgArgVO.getSvrId());
					chargeArgumentVO.setCntrCycNo(retChgArgVO.getCntrCycNo());
					chargeArgumentVO.setDmdtChgLocDivCd(retChgArgVO.getDmdtChgLocDivCd());
					chargeArgumentVO.setChgSeq(retChgArgVO.getChgSeq());
					
					/* ****** Charge Calculation by CNTR 정보 조회 *******
					 * 조회하는 Data가 Pre-Calculation한 Data인지  실제 Charge금액인지 여부에 따라 달리 조회한다.
					 * A) 실제 Charge Data 조회시에는 Charge, Booking Container Master Table의 Data를 조회
					 * B) Pre-Calculation Data조회시에는 Pre-Charge, Pre-Booking Container Table의 Data를 조회한다
					 */
					chgCalcCntrVO = dbDao.searchChargeByContainer(chargeArgumentVO);
					
				} else {
					// 가장 최근에 생성된 Charge의 CNTR Cycle No, Charge Seqence 정보 조회건이  없으면,
					// 빈 화면 출력을 위한   Empty VO 객체를 생성한다.
					chgCalcCntrVO = new ChargeCalculationContainerVO();
				}
				
			} else {
				// chargeArgumentVO.getCallFlag --> "P" (팝업으로 호출)
				// CNTR Cycle No, Charge Seqence 정보를 포함하고 있다.
				chgCalcCntrVO = dbDao.searchChargeByContainer(chargeArgumentVO);
			}
				
			Map<String, String> etcData = chgCalcCntrVO.getColumnValues();
			String cntrNo = chgCalcCntrVO.getCntrNo();

			etcData.put("inact_sts_nm", chgCalcCntrVO.getInactStsNm());
			resultVO.setEtcData(etcData);
			
			/*
			조회 데이터가 없는 경우, 화면에는 대부분의 필드란에 공백으로 출력해줘야 하기 때문에
			모든 필드들을 공백으로 초기화 시켜야 한다.
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
				// 조회 데이터가 존재하는 경우, 해당 로직을 처리한다.
				OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
				overdayNDivParmVO.setSvrId(chargeArgumentVO.getSvrId());
				overdayNDivParmVO.setCntrNo(chargeArgumentVO.getCntrNo());
				overdayNDivParmVO.setCnmvCycNo(chargeArgumentVO.getCntrCycNo());
				overdayNDivParmVO.setDttCode(chargeArgumentVO.getDmdtTrfCd());
				overdayNDivParmVO.setLocDiv(chargeArgumentVO.getDmdtChgLocDivCd());
				overdayNDivParmVO.setDccSeq(chargeArgumentVO.getChgSeq());
				
				//------------- DivOverDay 조회 -----------
				OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
				//-----------------------------------------
				
				CalculationParmVO calculationParmVO = new CalculationParmVO();
				
				String trfAplyTpCd = chgCalcCntrVO.getDmdtTrfAplyTpCd();
				calculationParmVO.setDcApplRate(trfAplyTpCd);
				calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
				calculationParmVO.setFtDys(chgCalcCntrVO.getFtDys());				// 2014.03.12
				calculationParmVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());		// 2014.03.12
				calculationParmVO.setOrgFtOvrDys(chgCalcCntrVO.getOrgFtOvrDys());	// 2014.03.12
				
				calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
				
				/*
					Charge에 적용된 Tariff에 따라 Charge금액을 계산한다.
				    A) "G"(Basic Tariff)인 경우 Basic Tariff의 Rate별 계산금액을 조회한다
				    B) "B"(Before Exception)인 경우 Before Exception Tariff의 Rate별 계산금액을 조회하고 Before Exception의 Currency를 조회한다
				    C) "S"(S/C Exception)인 경우 S/C Exception Tariff의 Rate별 계산금액을 조회하고 S/C Exception의 Currency를 조회한다
				    D) Charge에 적용된 Currency와 A), B), C)에서 계산한 Currency가 다른경우
				         1) 적용된 CurrencyExchange Rate를 조회하여 Charge 계산금액을 Exchange Rate를 곱한다
				         2) 1)에서 계산한 금액을 Currency별로 반올림처리 한다
				*/
				if("G".equals(trfAplyTpCd)) {
					// basicCalculation - Baisc Tariff
					String firstSvrID = null;
					
					if("Y".equals(chgCalcCntrVO.getOfcTrnsFlg())) {
						if("".equals(chargeArgumentVO.getBkgNo()))
							chargeArgumentVO.setBkgNo(chgCalcCntrVO.getBkgNo());
						
						ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
						chargeCalculationParmVO.setBkgNo(chargeArgumentVO.getBkgNo());
						chargeCalculationParmVO.setCntrNo(chargeArgumentVO.getCntrNo());
						chargeCalculationParmVO.setCntrCycNo(chargeArgumentVO.getCntrCycNo());
						chargeCalculationParmVO.setDmdtTrfCd(chargeArgumentVO.getDmdtTrfCd());
						chargeCalculationParmVO.setDmdtChgLocDivCd(chargeArgumentVO.getDmdtChgLocDivCd());
						chargeCalculationParmVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd()); //2011.10.28
						
						//log.debug(" searchChargeByContainer  FmMvmtYdCd ==========="+chargeCalculationParmVO.getFmMvmtYdCd());
						
						firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
					} else
						firstSvrID = chargeArgumentVO.getSvrId();
					
					calculationParmVO.setSvrId(firstSvrID);
					calculationParmVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					calculationParmVO.setTrfSeq(chgCalcCntrVO.getBzcTrfSeq());
					calculationParmVO.setDmdtDeTermCd(chgCalcCntrVO.getBzcDmdtDeTermCd());			// dmdt_de_term_cd
					calculationParmVO.setTrfGrpSeq(chgCalcCntrVO.getBzcTrfGrpSeq());
					calculationParmVO.setCntrts(chgCalcCntrVO.getCntrTpszCd());
					calculationParmVO.setOverDay(chgCalcCntrVO.getFxFtOvrDys());
					calculationParmVO.setCurCd(chgCalcCntrVO.getBzcTrfCurrCd());
					calculationParmVO.setTrfAplyDt(chgCalcCntrVO.getBzcTrfAplyDt());				// 2014.03.12

					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
					calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
					
//					if (DMTCalculationUtil.stringToDouble(chgCalcCntrVO.getScRfaExptAmt()) > 0) {
					if (!"".equals(chgCalcCntrVO.getScRfaExptAplyDt())){
						calculationParmVO.setDmdtTrfAplyTpCd("B");				
						calculationParmVO.setTrfAplyDt(chgCalcCntrVO.getScRfaExptAplyDt());					// 방글라데시 로직 때문에 추가. ("B" 또는 "S"로 넣기면 됨)
					} else {
						calculationParmVO.setDmdtTrfAplyTpCd("G");									// 2014.03.12
					}
				} else if("B".equals(trfAplyTpCd)) {
					// beforeCalculation - Before BKG Exception
					calculationParmVO.setDarNo(chgCalcCntrVO.getRfaExptDarNo());
					calculationParmVO.setMapgSeq(chgCalcCntrVO.getRfaExptMapgSeq());
					calculationParmVO.setVerSeq(chgCalcCntrVO.getRfaExptVerSeq());
					calculationParmVO.setDtlSeq(chgCalcCntrVO.getRfaRqstDtlSeq());
					calculationParmVO.setCmbSeq("1");
					calculationParmVO.setCntrts(chgCalcCntrVO.getCntrTpszCd());
					calculationParmVO.setOverDay(chgCalcCntrVO.getFxFtOvrDys());
					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
					calculationParmVO.setTrfAplyDt(chgCalcCntrVO.getScRfaExptAplyDt());				// 2014.03.12
					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
					calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
					calculationParmVO.setDmdtTrfAplyTpCd("B");										// 2014.03.12
				} else if("S".equals(trfAplyTpCd)) {
					// scCalculation - SC Exception
					calculationParmVO.setPropNo(chgCalcCntrVO.getScNo());
					calculationParmVO.setVerSeq(chgCalcCntrVO.getScExptVerSeq());
					calculationParmVO.setGrpSeq(chgCalcCntrVO.getScExptGrpSeq());
					calculationParmVO.setCntrts(chgCalcCntrVO.getCntrTpszCd());
					calculationParmVO.setOverDay(chgCalcCntrVO.getFxFtOvrDys());
					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
					calculationParmVO.setTrfAplyDt(chgCalcCntrVO.getScRfaExptAplyDt());		
					calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());// 2014.03.12
					calculationParmVO.setDmdtTrfAplyTpCd("S");										// 2014.03.12
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
				resultVO.setChrgDtlVOs(list);
				
				
				// 해당 필드가 화면에서 삭제됨.
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
				
				// Charge의 Max Sequence를 조회해서  EtcData에 세팅한다.
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
				
				// Return VO객체에  EtcData 설정 
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
	 * Charge 발생된 금액에 대해서 확정(Confirm)한다<br>
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
				
				if ( "U".equals(chgCalcCntrVO.getIbflag())) {
					//중복처리 방지 체크로직
					com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO checkArgument 
						= new com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO();
					checkArgument.setSvrId(chgCalcCntrVO.getSvrId());
					checkArgument.setCntrNo(chgCalcCntrVO.getCntrNo());
					checkArgument.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					checkArgument.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					checkArgument.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					checkArgument.setChgSeq(chgCalcCntrVO.getChgSeq());
					checkArgument.setStsCd("CONFIRM");
	
					boolean isExist = dbDao.checkChargeByConfirmDeleteDeleteCancel(checkArgument);
					
					//UPDATE할 내용이 없으면 오류 처리 함
					if(!isExist){
						log.debug("error (0) "+new ErrorHandler("DMT01081").getUserMessage());
						return new ErrorHandler("DMT01081").getUserMessage();
					}
					
					com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = null;
					chargeArgumentVO = new com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
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
	 * 해당 Charge의 Correction Remark 정보를 수정한다.
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
	
	
//	/**
//	 * Delete한 Charge를 이전 Status로 복구한다<br>
//	 * 
//	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
//	 * @param SignOnUserAccount account
//	 * @return String
//	 * @exception EventException
//	 */
//	public String removeCancelCharge(ChargeCalculationContainerVO[] chargeCalculationContainerVOs,
//			SignOnUserAccount account) throws EventException {
//		try {
//			ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
//			
//			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
//				ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs[i];
//				
//				if ( "U".equals(chgCalcCntrVO.getIbflag())) {
//					//중복처리 방지 체크로직
//					com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO checkArgument 
//						= new com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO();
//					checkArgument.setSvrId(chgCalcCntrVO.getSvrId());
//					checkArgument.setCntrNo(chgCalcCntrVO.getCntrNo());
//					checkArgument.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
//					checkArgument.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
//					checkArgument.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
//					checkArgument.setChgSeq(chgCalcCntrVO.getChgSeq());
//					checkArgument.setStsCd("CANCEL");
//	
//					boolean isExist = dbDao.checkChargeByConfirmDeleteDeleteCancel(checkArgument);
//					
//					//UPDATE할 내용이 없으면 오류 처리 함
//					if(!isExist){
//						log.debug("error (0) "+new ErrorHandler("DMT01081").getUserMessage());
//						return new ErrorHandler("DMT01081").getUserMessage();
//					}
//					
//					com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = null;
//					chargeArgumentVO = new com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
//					chargeArgumentVO.setSvrId(chgCalcCntrVO.getSvrId());
//					chargeArgumentVO.setCntrNo(chgCalcCntrVO.getCntrNo());
//					chargeArgumentVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
//					chargeArgumentVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
//					chargeArgumentVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
//					chargeArgumentVO.setChgSeq(chgCalcCntrVO.getChgSeq());
//					
//					int corrHisSeq = dmtCalculationUtil.checkChargeCorrection(chargeArgumentVO);
//					
//					DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
//					dmtChgCorrHisVO.setSvrId(chgCalcCntrVO.getSvrId());
//					dmtChgCorrHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
//					dmtChgCorrHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
//					dmtChgCorrHisVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
//					dmtChgCorrHisVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
//					dmtChgCorrHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
//					dmtChgCorrHisVO.setBkgNo(chgCalcCntrVO.getBkgNo());
//					dmtChgCorrHisVO.setCorrHisRmk("Delete Cancel");
//					dmtChgCorrHisVO.setCreUsrId(account.getUsr_id());
//					dmtChgCorrHisVO.setCreOfcCd(account.getOfc_cd());
//					
//					if(corrHisSeq == 0) {
//						corrHisSeq++;
//						dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
//						dbDao.addChargeHistory(dmtChgCorrHisVO);
//					}
//					
//					chgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
//					chgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
//					chgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
//					chgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
//					chgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
//					chgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());
//					
//					dbDao.modifyDeleteCancelCharge(chgArgVO, account);
//					
//					corrHisSeq++;
//					dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
//					dbDao.addChargeHistory(dmtChgCorrHisVO);
//				}
//			}
//		
//		} catch (DAOException ex) {
//			log.error("[DAOException]"+ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00008", new String[]{"DEL Cancel Charge"}).getMessage());
//		} catch (Exception ex) {
//			log.error("[Exception]"+ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00008", new String[]{"DEL Cancel Charge"}).getMessage());
//		}
//		return "";
//	}
	
	
	/**
	 * Charge의 To Data에 DR Data를 입력하고 저장전에 미리 얼마의 금액이 계산되는지 조회한다.<br>
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
			
			com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			DMTGeneralChargeCalculationUtil dmtGeneralChargeCalculationUtil = new DMTGeneralChargeCalculationUtil();
			DMTBalanceChargeCalculationUtil dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
			DMTCancelChargeCalculationUtil	dmtCancelChargeCalculationUtil	= new DMTCancelChargeCalculationUtil();
			DMTCombinedChargeCalculationUtil dmtCombinedChargeCalculationUtil = new DMTCombinedChargeCalculationUtil();
			
			String drDt = null;
			
			// by CNTR 화면에서 호출시 FmMvmtDt, ToMvmtDt값에서 '-' 제거
			if(chargeArgumentVO != null) {
				// by BKG 화면에서 호출
				drDt = chargeArgumentVO.getDrDt().replace("-", "");
				
			}
			
			log.debug("==precalDRDateCharge()=======11111");
			log.debug("==precalDRDateCharge()=======11111 : " + chargeCalculationContainerVOs.length);
			log.debug("==precalDRDateCharge()=======11111 + chargeCalculationContainerVOs[0].getBkgNo() : "+chargeCalculationContainerVOs[0].getBkgNo());
			log.debug("==precalDRDateCharge()=======11111 + chargeCalculationContainerVOs[0].getCntrNo() : "+chargeCalculationContainerVOs[0].getCntrNo());
			// ************** 다중건 처리 *************
			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
				chgCalcCntrVO = chargeCalculationContainerVOs[i];
				log.debug("==precalDRDateCharge()=======22222");
				// by BKG 화면에서 호출시  To MVMT Status를 'PC'로, To MVMT Date를 입력되어서 넘어온 D/R Date로 세팅해준다. 
				if(chargeArgumentVO != null) {
					log.debug("==precalDRDateCharge()=======22222 + PC");
					chgCalcCntrVO.setToMvmtStsCd("PC");
					chgCalcCntrVO.setToMvmtDt(drDt);
				} else {
					// by CNTR 화면에서 호출시 FmMvmtDt, ToMvmtDt값에서 '-' 제거
					chgCalcCntrVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt().replace("-",""));
					chgCalcCntrVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt().replace("-",""));
					if(chgCalcCntrVO.getFmMvmtDtTime() != null ){
						chgCalcCntrVO.setFmMvmtDtTime(chgCalcCntrVO.getFmMvmtDtTime().replace(":",""));
					} else {
						chgCalcCntrVO.setFmMvmtDtTime("0000");
					}
					if(chgCalcCntrVO.getToMvmtDtTime() != null ){
						chgCalcCntrVO.setToMvmtDtTime(chgCalcCntrVO.getToMvmtDtTime().replace(":",""));
					} else {
						chgCalcCntrVO.setToMvmtDtTime("0000");
					}
						
						
				}

				log.debug("==precalDRDateCharge()=======ToMvmtDtTime : "+chgCalcCntrVO.getToMvmtDtTime());
				
				ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
				chgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				chgArgVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				chgArgVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				chgArgVO.setFmMvmtDtTime(chgCalcCntrVO.getFmMvmtDtTime());
				chgArgVO.setToMvmtDtTime(chgCalcCntrVO.getToMvmtDtTime());
				
				
				String chgMaxSeq = dbDao.searchChargeMaxSequence(chgArgVO);

				log.debug("==precalDRDateCharge()=======chgMaxSeq : "+chgMaxSeq);
				
				if(!chgCalcCntrVO.getChgSeq().equals(chgMaxSeq)) {
					//"There is a balance charge !"
					resultVO.setResultCode("DMT01030");
					return resultVO;
				}
				
				boolean chgInvChk = dbDao.searchChargeInvoiceCheck(chgArgVO);
				log.debug("==precalDRDateCharge()=======chgInvChk : "+chgInvChk);
				if(chgInvChk) {
					//"Already Invoiced"
					resultVO.setResultCode("DMT01002");
					return resultVO;
				}
				
				ChargeCalculationContainerVO orgChgCalCntrVO = null;
				log.debug("==precalDRDateCharge()=======chgCalcCntrVO.getDulTpExptFlg() : "+chgCalcCntrVO.getDulTpExptFlg());
				
				String dulTpExptFlg = dbDao.searchDulTpExptFlg(chgArgVO);				
				if( ("Y").equals(dulTpExptFlg) ){
					chgCalcCntrVO.setDulTpExptFlg(dulTpExptFlg);
				}
				
				if(("Y").equals(chgCalcCntrVO.getDulTpExptFlg())) {
					chgArgVO.setDulTpExptFlg("Y");
					
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

//					orgChgCalCntrVO = (ChargeCalculationContainerVO)chgCalcCntrVO.clone();
				}
				
				String toMvmtStsCd = chgCalcCntrVO.getToMvmtStsCd();
				
				// DR Date Checking
				if(("DR").equals(toMvmtStsCd)) {
					// String currDt = DateTime.getDateString().replace(".","");
					// User Office별 현재일자 조회
					String currDt	= dbDao.searchCurrentDateByOffice(account.getOfc_cd());
					String toMvmtDt = chgCalcCntrVO.getToMvmtDt();
					
					if(currDt.compareTo(toMvmtDt) > 0) {
						// D/R Date should be same or later than current date
						resultVO.setResultCode("DMT01031");
						return resultVO;
					}
					
					// PreCal, DR Save 시에만 적용
					if(("").equals(chgCalcCntrVO.getToMvmtYdCd()))
						chgCalcCntrVO.setToMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
					
				} else if(("CS").equals(toMvmtStsCd)) {
					// Clock Stop
					String fmMvmtDt = chgCalcCntrVO.getFmMvmtDt();
					String toMvmtDt = chgCalcCntrVO.getToMvmtDt();
					
					if(fmMvmtDt.compareTo(toMvmtDt) >= 0) {
						// CS date should be later than From date
						resultVO.setResultCode("DMT01004");
						return resultVO;
					}
					
					// PreCal, DR Save 시에만 적용
					if(("").equals(chgCalcCntrVO.getToMvmtYdCd()))
						chgCalcCntrVO.setToMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				}
				

				log.debug("==precalDRDateCharge()=======22222222 ");
				// 기존의  PreCal Charge Booking Container 정보가 존재하면 삭제한다.
				//boolean isExist = dbDao.checkPreChargeBookingContainerExists(chgArgVO);
				//if(isExist)
				dbDao.deletePreChargeBookingContainer(chgArgVO);
				
				// PreCal  Charge Booking Container 정보를 생성한다.
				dbDao.createPreChargeBookingContainer(chgArgVO);
				
				
				// 기존의  PreCal Charge 정보가 존재하면 삭제한다.
				//isExist = dbDao.checkPreChargeCalculationExists(chgArgVO);
				//if(isExist)
				dbDao.deletePreChargeCalculation(chgArgVO);
				
				// PreCal Charge 정보를 생성한다.
				dbDao.createPreChargeCalculation(chgArgVO);
				
				
				// ***********  ChargeCalculationUseData  ***********************************
				ChargePartialPaymentVO chgPartialPaymentVO = dbDao.searchChargeCalculationUseData(chgArgVO);
				
				if(("EUR").equals(chgCalcCntrVO.getSvrId())) {
					String obCntrFlg = dbDao.searchInOutBoundByMovement(chgCalcCntrVO.getCntrNo(), chgCalcCntrVO.getCntrCycNo(), chgCalcCntrVO.getFmMvmtYdCd());
					//log.debug("============> OB_CNTR_FLG : " + obCntrFlg);
					// 'N' --> 'I'  , 'Y' --> 'O'
					
					// DATA존재시, IN/OUT BOUND 값을 사용한다.
					if(!("").equals(obCntrFlg)) {
						String ioBndCd = "N".equals(obCntrFlg) ? "I" : "O";
						chgPartialPaymentVO.setIoBndCd(ioBndCd);
					}
				}
				
				chgCalcCntrVO.setFmMvmtDt(chgPartialPaymentVO.getFmMvmtDt());
				
				/*
				 "L"(Long Staying), "U"(Unfinished), "N"(No Charge) 인  경우, To Date/Yard를 입력하지 않아도 Re-Calculation 가능
				    즉, To Date를 초기화한다
				 */
				String chgStsCd = chgCalcCntrVO.getDmdtChgStsCd();
				// 2012.02.23 "E" 추가. KimHyunHWA
				if( (("L").equals(chgStsCd) || ("U").equals(chgStsCd) || ("N").equals(chgStsCd)|| ("E").equals(chgStsCd))
					&& chgPartialPaymentVO.getToMvmtDt().length() < 12 ) {
					chgCalcCntrVO.setToMvmtDt("");
				} else
					chgCalcCntrVO.setToMvmtDt(chgPartialPaymentVO.getToMvmtDt());
				
				//log.debug("==khh==chgCalcCntrVO.getToMvmtDt()======="+chgCalcCntrVO.getToMvmtDt());
				// *****************************************************
				if(("Y").equals(chgCalcCntrVO.getWebIndFlg()) && ("DR").equals(chgCalcCntrVO.getToMvmtStsCd())) {
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
				
				log.debug("==khh2==chgCalcParmVO.getToMvmtDt()======="+chgCalcParmVO.getToMvmtDt());
				if(("Y").equals(chgCalcCntrVO.getDulTpExptFlg())) {
					log.debug("lcb [001]\n");
					
					// Dual Exception Charge중 Combined Charge에 대한 Dual Charge를 조회한다..
					List<ChargeCalculationContainerVO> chgCalcCntrVOs = dbDao.searchDualChargeTariff(chgArgVO);
					log.debug("lcb [002]\n");
					if(chgCalcCntrVOs != null && chgCalcCntrVOs.size() > 0) {
						chgArgVO.setCallFlag("PRECAL");
						resultVO = dualExceptionChargeCalculation("PRECAL", orgChgCalCntrVO, chgCalcCntrVOs, account);
						log.debug("lcb [003]\n");
						// 오류 발생시 Return
						if(resultVO.getResultCode() != null) {
							return resultVO;
						}
					}
					log.debug("lcb [004]\n");
					
					//2011.04.29. 추가 ("DR"일때 아닐때 구분)
					if(!("DR").equals(chgCalcCntrVO.getFmMvmtStsCd())){
						retChgCalcCntrVO = dmtCombinedChargeCalculationUtil.combinedChargeCalculation(chgCalcParmVO);
						log.debug("lcb [005]\n");
						if("-1".equals(retChgCalcCntrVO.getMsgCd()) || "88".equals(retChgCalcCntrVO.getMsgCd())) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							log.debug("lcb [006]\n");
							return resultVO;
						}
					}else{
						dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
						retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
						log.debug("lcb [007]\n");
						if (("-1").equals(retChgCalcCntrVO.getMsgCd())) {
							log.error("\n\n[DMT02036][Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
							//throw new EventException(retChgCalcCntrVO.getMsgDesc());
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					}
					log.debug("lcb [008]\n");
				} else {
					log.debug("lcb [009]\n");
					log.debug("lcb [009] getCxlBkgChgFlg : " + chgCalcCntrVO.getCxlBkgChgFlg());
					log.debug("lcb [009] getDmdtTrfCd : " + chgCalcCntrVO.getDmdtTrfCd());
					log.debug("lcb [009] getFmMvmtStsCd : " + chgCalcCntrVO.getFmMvmtStsCd());
					
					if(("Y".equals(chgCalcCntrVO.getCxlBkgChgFlg())) ||
						(("DTOC".equals(chgCalcCntrVO.getDmdtTrfCd()) || "CTOC".equals(chgCalcCntrVO.getDmdtTrfCd()) ) &&  "OP".equals(chgCalcCntrVO.getFmMvmtStsCd()) &&  "MT".equals(chgCalcCntrVO.getToMvmtStsCd()))
						) {
						log.debug("lcb [010]\n");
						// CxlBkgChgFlg = "Y" : 이미 Booking Cancel 되었음을 의미한다. (배치 프로그램.)
						// TRF CD("DTOC", "CTOC") && FM ("OP") && To ("MT") 현재 Booking Canecl인 아니지만, 곧 Cancel 된다고 생각하면 된다.(화면에서 입력된 경우)
						
						retChgCalcCntrVO = dmtCancelChargeCalculationUtil.cancelChargeCalculation(chgCalcParmVO);
						if(("-1").equals(retChgCalcCntrVO.getMsgCd()) || ("88").equals(retChgCalcCntrVO.getMsgCd())) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							log.debug("lcb [011]\n");
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					} else {
						log.debug("lcb [012]\n");
						if(!("DR").equals(chgCalcCntrVO.getFmMvmtStsCd())) {
							retChgCalcCntrVO = dmtGeneralChargeCalculationUtil.generalChargeCalculation(chgCalcParmVO);
							log.debug("lcb [013]\n");
							if(("-1").equals(retChgCalcCntrVO.getMsgCd()) || ("88").equals(retChgCalcCntrVO.getMsgCd())) {
								resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
								
								log.debug("lcb [014]\n");
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						} else {
							retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
							if("-1".equals(retChgCalcCntrVO.getMsgCd())) {
								log.debug("lcb [015]\n");
								resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						}
					}
				}
				log.debug("lcb [016]\n");
				// MT Notification Indicator 원래 상태로 돌려줌
				chgArgVO.setWebIndFlg(chgCalcCntrVO.getWebIndFlg());
				dbDao.modifyChargeWebIndicator(chgArgVO);
				log.debug("lcb [017]\n");
				if(!("DR").equals(chgCalcCntrVO.getFmMvmtStsCd())) {
					log.debug("lcb [018]\n");
					// ------------ DmtChgBkgCntrVO 객체 구성 -----------------
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
					log.debug("lcb [019]\n");
					dbDao.modifyPreBookingContainer(dmtChgBkgCntrVO);
				}
				
				log.debug("lcb [020]\n");
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
				//dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt()); 2011.11.15 김현화
				// ToMvmtDt가 없는 경우 원래 Data 유지하도록 함. 2011.12.05  김현화
				String retToMvmtDt = retChgCalcCntrVO.getToMvmtDt();
				log.debug("lcb [022]\n");
				// nullPointException 발생때문에 수정함. 2012.05.18 김현화				
				if ( retToMvmtDt!= null && !("").equals(retToMvmtDt) ){
					dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
				}else{
					dmtChgCalcVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				}
				log.debug("lcb [023]\n");
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
				dmtChgCalcVO.setBzcDmdtDeTermCd(retChgCalcCntrVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
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
				log.debug("lcb [024]\n");
				dbDao.modifyPreCharge(dmtChgCalcVO);
				log.debug("lcb [025]\n");
				
				if(("Y").equals(chgCalcCntrVO.getDulTpExptFlg())) {
					log.debug("lcb [026]\n");
					// Dual Exception Charge의 ORG_CHG_AMT, SC_RFA_EXPT_AMT 필드값 수정
					dbDao.modifyOrgChgAmt(chgArgVO);
				}
				log.debug("lcb [027]\n");
			} // for - end

			log.debug("lcb [028]\n");
			// by BKG(EES_DMT_3002.do) 화면에서 호출시 처리 부분
			if(chargeArgumentVO != null) {
				// 원래의 조회 조건중 Status값을 설정(sch_chg_sts --> dmdt_chg_sts_cd)
				chargeArgumentVO.setDmdtChgStsCd(chargeArgumentVO.getSchChgSts());
				log.debug("lcb [029]\n");
				// 원래의 조회 결과 리스트
				List<ChargeCalculationContainerVO> orgVOList = dbDao.searchCalculationCharge(chargeArgumentVO);
				log.debug("lcb [030]\n");
				// 동일한 검색 조건에 해당되는 PreCal 처리건 리스트 
				chargeArgumentVO.setEstMk("P");
				List<ChargeCalculationContainerVO> precalVOList = dbDao.searchCalculationCharge(chargeArgumentVO);
				
				for(int i=0; i < orgVOList.size(); i++) {
					ChargeCalculationContainerVO orgChgCalcCntrVO = orgVOList.get(i);
					log.debug("lcb [031]\n");
					// chargeCalculationContainerVOs ===> 원래 조회결과 리스트 중, 	PreCal 대상으로 체크되어서 넘어온 그리드의 Row값들
					for (int k=0; k < chargeCalculationContainerVOs.length; k++ ) {
						log.debug("lcb [032]\n");
						// 기존 조회 리스트에서 체크된 PreCal 처리 대상건을 비교, 리스트 순서를 알아낸다.(PreCal 처리건으로 대체하기 위함)
						// 2010-07-19: checkChargeCalculationContainerKeys()의 구현 내용을 풀어줌
//						if(checkChargeCalculationContainerKeys(orgChgCalcCntrVO, chargeCalculationContainerVOs[k])) {
						if (orgChgCalcCntrVO!=null && chargeCalculationContainerVOs[k]!=null && 
							orgChgCalcCntrVO.getSvrId().equals(chargeCalculationContainerVOs[k].getSvrId())
							&& orgChgCalcCntrVO.getCntrNo().equals(chargeCalculationContainerVOs[k].getCntrNo())
							&& orgChgCalcCntrVO.getCntrCycNo().equals(chargeCalculationContainerVOs[k].getCntrCycNo())
							&& orgChgCalcCntrVO.getDmdtTrfCd().equals(chargeCalculationContainerVOs[k].getDmdtTrfCd())
							&& orgChgCalcCntrVO.getDmdtChgLocDivCd().equals(chargeCalculationContainerVOs[k].getDmdtChgLocDivCd())
							&& orgChgCalcCntrVO.getChgSeq().equals(chargeCalculationContainerVOs[k].getChgSeq()) ) 
						{
							log.debug("lcb [033]\n");
							// 기존 조회 리스트에서 PreCal 처리건으로 대체
							// 2010-07-19: checkChargeCalculationContainerKeys()의 내용을 풀어줌
							for (int j=0; j < precalVOList.size(); j++ ) {
								ChargeCalculationContainerVO precalVO = precalVOList.get(j);
								log.debug("lcb [034]\n");
//								if(checkChargeCalculationContainerKeys(orgChgCalcCntrVO, precalVO)) {
								if (orgChgCalcCntrVO!=null && precalVO!=null &&
									orgChgCalcCntrVO.getSvrId().equals(precalVO.getSvrId())
									&& orgChgCalcCntrVO.getCntrNo().equals(precalVO.getCntrNo())
									&& orgChgCalcCntrVO.getCntrCycNo().equals(precalVO.getCntrCycNo())
									&& orgChgCalcCntrVO.getDmdtTrfCd().equals(precalVO.getDmdtTrfCd())
									&& orgChgCalcCntrVO.getDmdtChgLocDivCd().equals(precalVO.getDmdtChgLocDivCd())
									&& orgChgCalcCntrVO.getChgSeq().equals(precalVO.getChgSeq()) ) 
								{
									log.debug("lcb [035]\n");
									orgVOList.set(i, precalVO);
									break;
								}
							}
							break;
						}
					}
				}
				log.debug("lcb [036]\n");
				// PreCal 처리건의 수정내용이 반영된 조회 리스트 리턴
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
	 * Container Charge 정보를 수정한다. Charge By Booking에서 Call하는 Operation(DR Save)
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

			com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			DMTGeneralChargeCalculationUtil dmtGeneralChargeCalculationUtil = new DMTGeneralChargeCalculationUtil();
			DMTBalanceChargeCalculationUtil dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
			DMTCancelChargeCalculationUtil	dmtCancelChargeCalculationUtil	= new DMTCancelChargeCalculationUtil();
			DMTCombinedChargeCalculationUtil dmtCombinedChargeCalculationUtil = new DMTCombinedChargeCalculationUtil();

			com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO utilChgArgVO = null;
			utilChgArgVO = new com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
			ChargeCalculationContainerVO[] chargeResultVOs = chargeCalculationContainerVOs;

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
				chargeArgumentVO.setFmMvmtDtTime(chgCalcCntrVO.getFmMvmtDtTime());
				chargeArgumentVO.setToMvmtDtTime(chgCalcCntrVO.getToMvmtDtTime());

				String checkScRfaExptApltDt = null;

				if ("1".equals(chgCalcCntrVO.getChgSeq())) {
					ChargeStatusNRemarkVO checkScRfaExptApltDtVO = null;
					ChargeArgumentVO checkArgumentVO = new ChargeArgumentVO();
					
					checkArgumentVO.setSvrId(chgCalcCntrVO.getSvrId());
					checkArgumentVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					checkArgumentVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					checkArgumentVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					checkArgumentVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					checkArgumentVO.setChgSeq(chgCalcCntrVO.getChgSeq());
	
					checkScRfaExptApltDtVO = dbDao.searchChargeStatusNRemark(checkArgumentVO);
					checkScRfaExptApltDt = checkScRfaExptApltDtVO.getScRfaExptApltDt();
				}
				
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
				if("Y".equals(chgCalcCntrVO.getDulTpExptFlg())) {
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
				if("DR".equals(toMvmtStsCd)) {
					//String currDt = DateTime.getDateString().replace(".","");
					// User Office별 현재일자 조회
					String currDt	= dbDao.searchCurrentDateByOffice(account.getOfc_cd());
					String toMvmtDt = chgCalcCntrVO.getToMvmtDt();

					if(currDt.compareTo(toMvmtDt) > 0) {
						// D/R Date should be same or later than current date
						resultVO.setResultCode("DMT01031");
						return resultVO;
					}

					// PreCal, DR Save 시에만 적용
					if("".equals(chgCalcCntrVO.getToMvmtYdCd()))
						chgCalcCntrVO.setToMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());

				} else if("CS".equals(toMvmtStsCd)) {
					// Clock Stop
					String fmMvmtDt = chgCalcCntrVO.getFmMvmtDt();
					String toMvmtDt = chgCalcCntrVO.getToMvmtDt();

					if(fmMvmtDt.compareTo(toMvmtDt) >= 0) {
						// CS date should be later than From date
						resultVO.setResultCode("DMT01004");
						return resultVO;
					}

					// PreCal, DR Save 시에만 적용
					if("".equals(chgCalcCntrVO.getToMvmtYdCd()))
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

				if("EUR".equals(chgCalcCntrVO.getSvrId())) {
					String obCntrFlg = dbDao.searchInOutBoundByMovement(chgCalcCntrVO.getCntrNo(), chgCalcCntrVO.getCntrCycNo(), chgCalcCntrVO.getFmMvmtYdCd());
					
					// DATA존재시, IN/OUT BOUND 값을 사용한다.('N' --> 'I', 'Y' --> 'O')
					if(!"".equals(obCntrFlg)) {
						String ioBndCd = "N".equals(obCntrFlg) ? "I" : "O";
						chgPartialPaymentVO.setIoBndCd(ioBndCd);
					}
				}

				chgCalcCntrVO.setFmMvmtDt(chgPartialPaymentVO.getFmMvmtDt());

				/*
				 "L"(Long Staying), "U"(Unfinished), "N"(No Charge) 인  경우, To Date/Yard를 입력하지 않아도 Re-Calculation 가능
				  즉, To Date를 초기화한다
				 */
				String chgStsCd = chgCalcCntrVO.getDmdtChgStsCd();
				if( ("L".equals(chgStsCd) || "U".equals(chgStsCd) || "N".equals(chgStsCd))
					&& chgPartialPaymentVO.getToMvmtDt().length() < 12 ) {
					chgCalcCntrVO.setToMvmtDt("");
				} else
					chgCalcCntrVO.setToMvmtDt(chgPartialPaymentVO.getToMvmtDt());


				// *****************************************************
				if("Y".equals(chgCalcCntrVO.getWebIndFlg()) && "DR".equals(chgCalcCntrVO.getToMvmtStsCd())) {
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
					if(("Y".equals(chgCalcCntrVO.getCxlBkgChgFlg())) ||
						(("DTOC".equals(chgCalcCntrVO.getDmdtTrfCd()) || "CTOC".equals(chgCalcCntrVO.getDmdtTrfCd()) ) && "OP".equals(chgCalcCntrVO.getFmMvmtStsCd()) && "MT".equals(chgCalcCntrVO.getToMvmtStsCd()))
						){
						
						// CxlBkgChgFlg = "Y" : 이미 Booking Cancel 되었음을 의미한다. (배치 프로그램.)
						// TRF CD("DTOC", "CTOC") && FM ("OP") && To ("MT") 현재 Booking Canecl인 아니지만, 곧 Cancel 된다고 생각하면 된다.(화면에서 입력된 경우)
						
						retChgCalcCntrVO = dmtCancelChargeCalculationUtil.cancelChargeCalculation(chgCalcParmVO);
						
						if("-1".equals(retChgCalcCntrVO.getMsgCd()) || "88".equals(retChgCalcCntrVO.getMsgCd())) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					} else {
						if(!"DR".equals(chgCalcCntrVO.getFmMvmtStsCd())) {
							retChgCalcCntrVO = dmtGeneralChargeCalculationUtil.generalChargeCalculation(chgCalcParmVO);
		
							if("-1".equals(retChgCalcCntrVO.getMsgCd()) || "88".equals(retChgCalcCntrVO.getMsgCd())) {
								resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						} else {
							retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
		
							if("-1".equals(retChgCalcCntrVO.getMsgCd())) {
								resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						}
					}
				}
					
					
				if(!"0".equals(retChgCalcCntrVO.getMsgCd())) {
					retChgCalcCntrVO.setDmdtChgStsCd("E");
				}

				// MT Notification Indicator 원래 상태로 돌려줌
				//chargeArgumentVO.setWebIndFlg(chgCalcCntrVO.getWebIndFlg());
				//dbDao.modifyChargeWebIndicator(chargeArgumentVO);

				if(!"DR".equals(chgCalcCntrVO.getFmMvmtStsCd())) {

					// ------------ DmtChgBkgCntrVO 객체 구성 -----------------
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
				//dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt()); 2011.11.15 김현화
				//ToMvmtDt가 없는 경우 원래 Data 유지하도록 함. 2011.12.05  김현화
				String retToMvmtDt = retChgCalcCntrVO.getToMvmtDt();

				// nullPointException 발생때문에 수정함. 2012.05.18 김현화				
				if ( retToMvmtDt!= null && !("").equals(retToMvmtDt) ){
					dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
				}else{
					dmtChgCalcVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				}
				
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
				dmtChgCalcVO.setBzcDmdtDeTermCd(retChgCalcCntrVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
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
				dmtChgCalcVO.setUclmFlg(chgCalcCntrVO.getUclmFlg());

				dbDao.modifyChargeCalculation(dmtChgCalcVO);
				
				if("Y".equals(chgCalcCntrVO.getDulTpExptFlg())) {
					// Dual Exception Charge의 ORG_CHG_AMT, SC_RFA_EXPT_AMT 필드값 수정
					dbDao.modifyOrgChgAmt(chargeArgumentVO);
				}

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

				corrHisSeq++;
				dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
				dbDao.addChargeHistory(dmtChgCorrHisVO);
				chargeResultVOs[i].setFtEndDt(dmtChgCalcVO.getFtEndDt()); //2011.11.30
				chargeResultVOs[i].setChgSeq(dmtChgCalcVO.getChgSeq());   //2012.01.12 추가-EDO 전송시  필요.
				chargeResultVOs[i].setDmdtTrfCd(dmtChgCalcVO.getDmdtTrfCd()); //2012.01.26  추가-EDO 전송시  필요.
				
				log.debug("\n[Exception Cost] --------------------------------------------[Start]"  );
				log.debug("\n[Exception Cost] checkScRfaExptApltDt : " + checkScRfaExptApltDt);
				log.debug("\n[Exception Cost] getScRfaExptAplyDt : " + retChgCalcCntrVO.getScRfaExptAplyDt());
				log.debug("\n[Exception Cost] getCntrTpszCd : " + chgCalcParmVO.getCntrTpszCd().substring(0, 1) );
				log.debug("\n[Exception Cost] getDmdtChgStsCd : " + dmtChgCalcVO.getDmdtChgStsCd() );
				log.debug("\n[Exception Cost] getDulTpExptFlg : " + "Y".equals(dmtChgCalcVO.getDulTpExptFlg()) );
				log.debug("\n[Exception Cost] getDmdtTrfCd : " + dmtChgCalcVO.getDmdtTrfCd());
				log.debug("\n[Exception Cost] getChgSeq : " + dmtChgCalcVO.getChgSeq() );
				log.debug("\n[Exception Cost] --------------------------------------------[End]"  );
				
				//Exception Cost를 재계산 로직 추가
				if( (checkScRfaExptApltDt != null || retChgCalcCntrVO.getScRfaExptAplyDt() != null)
					&& ("USA".equals(chgCalcParmVO.getSvrId()) || "EUR".equals(chgCalcParmVO.getSvrId()))
					&& "D".equals(chgCalcParmVO.getCntrTpszCd().substring(0, 1)) //수정
					&& (    "C".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "F".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "I".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "L".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "N".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "U".equals(dmtChgCalcVO.getDmdtChgStsCd())
					    )
					&& (    "DMIF".equals(dmtChgCalcVO.getDmdtTrfCd())
					     || "DTIC".equals(dmtChgCalcVO.getDmdtTrfCd())
					     || "CTIC".equals(dmtChgCalcVO.getDmdtTrfCd())
					    )							     
					&& !("Y".equals(dmtChgCalcVO.getDulTpExptFlg()) && "D".equals(dmtChgCalcVO.getDmdtTrfCd().substring(0, 1)))  //수정  
					&& ("1".equals(dmtChgCalcVO.getChgSeq()))
				  )
				{
					DMTExceptionChargeCalculationUtil exceptionChargeCalculationUtil = new DMTExceptionChargeCalculationUtil();
					ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();

					chargeCalculationParmVO.setBkgNo(chgCalcParmVO.getBkgNo());
					chargeCalculationParmVO.setSvrId(chgCalcParmVO.getSvrId()); //수정
					chargeCalculationParmVO.setCntrNo(chgCalcParmVO.getCntrNo());
					chargeCalculationParmVO.setCntrCycNo(String.valueOf(chgCalcParmVO.getCntrCycNo()));
					chargeCalculationParmVO.setDmdtTrfCd(chgCalcParmVO.getDmdtTrfCd());
					chargeCalculationParmVO.setDmdtChgLocDivCd(chgCalcParmVO.getDmdtChgLocDivCd());
					chargeCalculationParmVO.setChgSeq(String.valueOf(chgCalcParmVO.getChgSeq()));
					chargeCalculationParmVO.setDmdtChgStsCd(dmtChgCalcVO.getDmdtChgStsCd());
					chargeCalculationParmVO.setFmMvmtDt(chgCalcParmVO.getFmMvmtDt());
					chargeCalculationParmVO.setFmMvmtYdCd(chgCalcParmVO.getFmMvmtYdCd());
					chargeCalculationParmVO.setFmMvmtStsCd(chgCalcParmVO.getFmMvmtStsCd());
					chargeCalculationParmVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
					chargeCalculationParmVO.setToMvmtYdCd(retChgCalcCntrVO.getToMvmtYdCd());
					chargeCalculationParmVO.setToMvmtStsCd(retChgCalcCntrVO.getToMvmtStsCd());
					chargeCalculationParmVO.setDmdtTrfAplyTpCd(retChgCalcCntrVO.getDmdtTrfAplyTpCd());
					chargeCalculationParmVO.setBzcTrfSeq(String.valueOf(retChgCalcCntrVO.getBzcTrfSeq()));
					chargeCalculationParmVO.setBzcDmdtDeTermCd(retChgCalcCntrVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
					chargeCalculationParmVO.setBzcTrfGrpSeq(String.valueOf(retChgCalcCntrVO.getBzcTrfGrpSeq()));
					chargeCalculationParmVO.setRfaExptDarNo(retChgCalcCntrVO.getRfaExptDarNo());
					chargeCalculationParmVO.setRfaExptMapgSeq(String.valueOf(retChgCalcCntrVO.getRfaExptMapgSeq()));
					chargeCalculationParmVO.setRfaExptVerSeq(String.valueOf(retChgCalcCntrVO.getRfaExptVerSeq()));
					chargeCalculationParmVO.setRfaRqstDtlSeq(String.valueOf(retChgCalcCntrVO.getRfaRqstDtlSeq()));
					chargeCalculationParmVO.setScNo(retChgCalcCntrVO.getScNo());
					chargeCalculationParmVO.setScExptVerSeq(String.valueOf(retChgCalcCntrVO.getScExptVerSeq()));
					chargeCalculationParmVO.setScExptGrpSeq(String.valueOf(retChgCalcCntrVO.getScExptGrpSeq()));
					chargeCalculationParmVO.setCntrTpszCd(chgCalcParmVO.getCntrTpszCd());
					chargeCalculationParmVO.setIoBndCd(chgCalcParmVO.getIoBndCd());
					chargeCalculationParmVO.setOfcCd(retChgCalcCntrVO.getOfcCd());
					chargeCalculationParmVO.setDulTpExptFlg(chgCalcParmVO.getDulTpExptFlg());
					chargeCalculationParmVO.setCgoTpCd(chgCalcParmVO.getCgoTpCd());

					ExceptionChargeCalculationVO exceptionChargeCalculationVO = null;
					exceptionChargeCalculationVO = exceptionChargeCalculationUtil.exceptionChargeCalculation(chargeCalculationParmVO);

					exceptionChargeCalculationVO.setBkgNo(chgCalcParmVO.getBkgNo());
					exceptionChargeCalculationVO.setCntrNo(chgCalcParmVO.getCntrNo());
					exceptionChargeCalculationVO.setCntrCycNo(String.valueOf(chgCalcParmVO.getCntrCycNo()));
					exceptionChargeCalculationVO.setDmdtTrfCd(chgCalcParmVO.getDmdtTrfCd());
					exceptionChargeCalculationVO.setDmdtChgLocDivCd(chgCalcParmVO.getDmdtChgLocDivCd());
					exceptionChargeCalculationVO.setChgSeq(String.valueOf(chgCalcParmVO.getChgSeq()));
					exceptionChargeCalculationVO.setDmdtChgStsCd(dmtChgCalcVO.getDmdtChgStsCd());
					
					exceptionChargeCalculationVO.setOfcCd(retChgCalcCntrVO.getOfcCd());
					exceptionChargeCalculationVO.setCntrTpszCd(chgCalcParmVO.getCntrTpszCd());
					exceptionChargeCalculationVO.setUpdUsrId(account.getUsr_id());
					exceptionChargeCalculationVO.setUpdOfcCd(account.getOfc_cd());

					dbDao.mergeDmtExceptionChargeCalculation(exceptionChargeCalculationVO);
				}

			} // for end


	        resultVO.setChargeCalculationContainerVOArray(chargeResultVOs);//2011.11.30
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
	 * Dual Exception Charge중 Combined Charge에 대한 Dual Charge에 대해서 Calculate 처리한다.
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
			com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			DMTDualChargeCalculationUtil dmtDualChargeCalculationUtil = new DMTDualChargeCalculationUtil();
			
			ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
			
			/**************************************************************************************************************
			CTOC(POR) --> DTOC(POR, 필수), DMOF(POL), DMOF(POR, 옵션)
			CTIC(DEL) --> DMIF(POD, 필수), DTIC(DEL), DMIF(DEL, 옵션)
			
			DTOC, DMIF --> From 정보 계승
			DMOF, DTIC --> To 정보 계승
			
			callFlag: 'DRSAVE', 'BALANCE', 'PARTIAL', 'SAVE', 'WEBCANCEL', 'PRECAL'
			*************************************************************************************************************/
			
			String usrId = null;
			String ofcCd = null ;
			
			for (int i=0; i < 1; i++ ) {
				
				if("BALANCE".equals(callFlag)) {
					if(chargeCalculationContainerVOs.size() == 2 && i==0) {		// 'DTOC', 'DMIF'
						continue;
					}
				}
				
				ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs.get(i);
					
				if(	("DTOC".equals(chgCalcCntrVO.getDmdtTrfCd()) && "POR".equals(chgCalcCntrVO.getDmdtChgLocDivCd())) ||
					("DMIF".equals(chgCalcCntrVO.getDmdtTrfCd()) && "POD".equals(chgCalcCntrVO.getDmdtChgLocDivCd())) ) {
					
					String fmMvmtDt = chargeCalculationContainerVO.getFmMvmtDt();
					if(fmMvmtDt.length() == 12) fmMvmtDt = fmMvmtDt.substring(0, 8);
					// From 데이터 셋팅
					chgCalcCntrVO.setFmMvmtDt(fmMvmtDt);
					chgCalcCntrVO.setFmMvmtYdCd(chargeCalculationContainerVO.getFmMvmtYdCd());
					chgCalcCntrVO.setFmMvmtStsCd(chargeCalculationContainerVO.getFmMvmtStsCd());
				}
				
				// CUP 시스템에 입력된 데이터인지 확인.
				String csToMvmtStsCd	= chargeCalculationContainerVO.getToMvmtStsCd();
				
				if ((account == null) && "CS".equals(csToMvmtStsCd) ){
					// account가 null 이라면 외부 (Home Page) 호출에 Clock Stop 이다.
					usrId = "CUP_CLOCK_STOP";
					ofcCd = "CUPHOM";
				} else{
					usrId = account.getUsr_id();
					ofcCd = account.getOfc_cd();
				}
				
				// DTIC, DMOF
				String toMvmtDt = chargeCalculationContainerVO.getToMvmtDt();
				
				if(toMvmtDt.length() == 12) toMvmtDt = toMvmtDt.substring(0, 8);
				// To 데이터 셋팅
				chgCalcCntrVO.setToMvmtDt(toMvmtDt);
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
				chgArgVO.setFmMvmtDtTime(chgCalcCntrVO.getFmMvmtDtTime());
				chgArgVO.setToMvmtDtTime(chgCalcCntrVO.getToMvmtDtTime());

				String toMvmtStsCd = chgCalcCntrVO.getToMvmtStsCd();

				// DR Date Checking
				// To Yard 정보가 없을 경우, From Yard 로 셋팅한다. (FM_MVMT_YD_CD = TO_MVMT_YD_CD)
				if("DR".equals(toMvmtStsCd)) {
					// PreCal, DR Save 시에만 적용
					if("PRECAL".equals(callFlag) || "DRSAVE".equals(callFlag)) {
						if("".equals(chgCalcCntrVO.getToMvmtYdCd()))
							chgCalcCntrVO.setToMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
					}
				} else if("CS".equals(toMvmtStsCd)) {
					// PreCal, DR Save 시에만 적용
					if("PRECAL".equals(callFlag) || "DRSAVE".equals(callFlag)) {
						if("".equals(chgCalcCntrVO.getToMvmtYdCd()))
							chgCalcCntrVO.setToMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
					}
				}

				// ***********  searchChargeCalculationUseData **************
				ChargePartialPaymentVO chgPartialPaymentVO = dbDao.searchChargeCalculationUseData(chgArgVO);

				if("EUR".equals(chgCalcCntrVO.getSvrId())) {
					String obCntrFlg = dbDao.searchInOutBoundByMovement(chgCalcCntrVO.getCntrNo(), chgCalcCntrVO.getCntrCycNo(), chgCalcCntrVO.getFmMvmtYdCd());
					
					// DATA존재시, IN/OUT BOUND 값을 사용한다. ('N' --> 'I'  , 'Y' --> 'O')
					if(!"".equals(obCntrFlg)) {
						String ioBndCd = "N".equals(obCntrFlg) ? "I" : "O";
						chgPartialPaymentVO.setIoBndCd(ioBndCd);
					}
				}

				chgCalcCntrVO.setFmMvmtDt(chgPartialPaymentVO.getFmMvmtDt());

				/*
				 "L"(Long Staying), "U"(Unfinished), "N"(No Charge) 인  경우, To Date/Yard를 입력하지 않아도 Re-Calculation 가능
					즉, To Date를 초기화한다
				 */
				String chgStsCd = chgCalcCntrVO.getDmdtChgStsCd();
				if( ("L".equals(chgStsCd) || "U".equals(chgStsCd) || "N".equals(chgStsCd))
					&& chgPartialPaymentVO.getToMvmtDt().length() < 12 ) {
					chgCalcCntrVO.setToMvmtDt("");
				} else {
					chgCalcCntrVO.setToMvmtDt(chgPartialPaymentVO.getToMvmtDt());
				}
				
				if("BALANCE".equals(callFlag)) {
					chgCalcCntrVO.setFmMvmtStsCd("DR");
					chgCalcCntrVO.setFmMvmtDt(chgCalcCntrVO.getToMvmtDt());
					chgCalcCntrVO.setToMvmtStsCd("");
					chgCalcCntrVO.setToMvmtDt("");
					chgCalcCntrVO.setToMvmtYdCd("");
					chgCalcCntrVO.setCorrRmk("Balance Creation");
				} else if("PARTIAL".equals(callFlag)) {	
					if("N".equals(chgCalcCntrVO.getWebIndFlg()) && "DR".equals(chgCalcCntrVO.getToMvmtStsCd())) {
						chgArgVO.setWebIndFlg("N");
						dbDao.modifyChargeWebIndicator(chgArgVO);
					}
				} else {
					// MT Notification된 Data의 경우(To Movement="DR"이고 Web Indicator="Y"), Web Indicator를 "N"으로 Update한다.
					if("Y".equals(chgCalcCntrVO.getWebIndFlg()) && "DR".equals(chgCalcCntrVO.getToMvmtStsCd())
							|| "WEBCANCEL".equals(callFlag)) {
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
				
				if("-1".equals(retChgCalcCntrVO.getMsgCd()) || "88".equals(retChgCalcCntrVO.getMsgCd())) {
					resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
					resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
					return resultVO;
				}
					
				if(!"BALANCE".equals(callFlag) && !"0".equals(retChgCalcCntrVO.getMsgCd())) {
					retChgCalcCntrVO.setDmdtChgStsCd("E");
				}

				// MT Notification Indicator 원래 상태로 돌려줌
				if("PRECAL".equals(callFlag)) {
					chgArgVO.setWebIndFlg(chgCalcCntrVO.getWebIndFlg());
					dbDao.modifyChargeWebIndicator(chgArgVO);
				}
				
				if(!"BALANCE".equals(callFlag) && !"DR".equals(chgCalcCntrVO.getFmMvmtStsCd())) {
					// ------------ DmtChgBkgCntrVO 객체 구성 -----------------
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
					
					dmtChgBkgCntrVO.setUpdUsrId(usrId);
					dmtChgBkgCntrVO.setUpdOfcCd(ofcCd);

					if("PRECAL".equals(callFlag))
						dbDao.modifyPreBookingContainer(dmtChgBkgCntrVO);
					else
						dbDao.modifyBookingContainer(dmtChgBkgCntrVO);
				}

				
				// ************* DmtChgCalcVO 객체 구성 *****************
				DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
				
				if("BALANCE".equals(callFlag)) {
					
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
					dmtChgCalcVO.setCreUsrId(usrId);
					dmtChgCalcVO.setCreOfcCd(ofcCd);
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
				//ToMvmtDt가 없는 경우 원래 Data 유지하도록 함. 2011.12.05  김현화
				String retToMvmtDt = retChgCalcCntrVO.getToMvmtDt();

				// nullPointException 발생때문에 수정함. 2012.05.18 김현화				
				if ( retToMvmtDt!= null && !("").equals(retToMvmtDt) ){
					dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
				}else{
					dmtChgCalcVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				}
				
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
				dmtChgCalcVO.setBzcDmdtDeTermCd(retChgCalcCntrVO.getBzcDmdtDeTermCd()); // dmdt_de_term_cd
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
				dmtChgCalcVO.setUpdUsrId(usrId);
				dmtChgCalcVO.setUpdOfcCd(ofcCd);
				dmtChgCalcVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
				dmtChgCalcVO.setCmdtTrfSeq(retChgCalcCntrVO.getCmdtTrfSeq());
				dmtChgCalcVO.setCmdtExptAplyDt(retChgCalcCntrVO.getCmdtExptAplyDt());
				dmtChgCalcVO.setCmdtOvrDys(retChgCalcCntrVO.getCmdtOvrDys());
				dmtChgCalcVO.setCmdtExptAmt(retChgCalcCntrVO.getCmdtExptAmt());
				dmtChgCalcVO.setUclmFlg(chgCalcCntrVO.getUclmFlg());
				
				if(chgCalcCntrVO.getWebMtyDt() != null) {
					dmtChgCalcVO.setWebMtyDt(chgCalcCntrVO.getWebMtyDt().replace("-", ""));
				}
				
				if("PRECAL".equals(callFlag)) {
					dbDao.modifyPreCharge(dmtChgCalcVO);
				} else if("BALANCE".equals(callFlag)) {
					// DMT_CHG_CALC 테이블에  Insert 처리
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
	 * Balance Charge를 생성한다.(Balance Creation)<br>
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
			com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			DMTBalanceChargeCalculationUtil dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
			DMTCancelChargeCalculationUtil	dmtCancelChargeCalculationUtil	= new DMTCancelChargeCalculationUtil();
			DMTCombinedChargeCalculationUtil dmtCombinedChargeCalculationUtil = new DMTCombinedChargeCalculationUtil();
			
			com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO utilChgArgVO = null;
			utilChgArgVO = new com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
			
			ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
			
			ChargeCalculationContainerVO[] chargeResultVOs = chargeCalculationContainerVOs;
			
			/* ******************** 처리로직 ******************************************
			0. Charge의 List를 반복실행한다
			1. Status가 F, C, I 이고 Balance Charge없는 경우나, 
			   Balance Charge가 존재해도 해당 Charge가 마지막으로 생성된 Charge이며, 
			   TO MVMT Status가 DR인 경우가 아니면  메세지[DMT01058]을 보여주고 오류처리한다.
			2. balanceChargeCalculation을 Call하여 Balance Charge를 Calculation한다
			**************************************************************************/
			long prmChgSeq = 0;
			
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
				chgArgVO.setFmMvmtDtTime(chgCalcCntrVO.getFmMvmtDtTime());
				chgArgVO.setToMvmtDtTime(chgCalcCntrVO.getToMvmtDtTime());
				
				String chgMaxSeq = dbDao.searchChargeMaxSequence(chgArgVO);
				
				if(!chgCalcCntrVO.getChgSeq().equals(chgMaxSeq)) {
					//"There is already a balance charge!"
					resultVO.setResultCode("DMT01057");
					return resultVO;
				}								
				
				prmChgSeq = DMTCalculationUtil.stringToLong(chgCalcCntrVO.getChgSeq()) + 1;
				chgCalcCntrVO.setChgSeq(String.valueOf(prmChgSeq));
				
				// ***********  searchChargeCalculationUseData **************
				ChargePartialPaymentVO chgPartialPaymentVO = dbDao.searchChargeCalculationUseData(chgArgVO);
				
				if("EUR".equals(chgCalcCntrVO.getSvrId())) {
					String obCntrFlg = dbDao.searchInOutBoundByMovement(chgCalcCntrVO.getCntrNo(), chgCalcCntrVO.getCntrCycNo(), chgCalcCntrVO.getFmMvmtYdCd());
					//log.debug("============> OB_CNTR_FLG : " + obCntrFlg);
					// 'N' --> 'I'  , 'Y' --> 'O'
					
					// DATA존재시, IN/OUT BOUND 값을 사용한다.
					if(!"".equals(obCntrFlg)) {
						String ioBndCd = "N".equals(obCntrFlg) ? "I" : "O";
						chgPartialPaymentVO.setIoBndCd(ioBndCd);
					}
				}
				
				chgCalcCntrVO.setFmMvmtDt(chgPartialPaymentVO.getFmMvmtDt());

				/*
				 "L"(Long Staying), "U"(Unfinished), "N"(No Charge) 인  경우, To Date/Yard를 입력하지 않아도 Re-Calculation 가능
					즉, To Date를 초기화한다
				 */
				String chgStsCd = chgCalcCntrVO.getDmdtChgStsCd();
				if( ("L".equals(chgStsCd) || "U".equals(chgStsCd) || "N".equals(chgStsCd))
					&& chgPartialPaymentVO.getToMvmtDt().length() < 12 ) {
					chgCalcCntrVO.setToMvmtDt("");
				} else {
					chgCalcCntrVO.setToMvmtDt(chgPartialPaymentVO.getToMvmtDt());
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
				chgCalcParmVO.setFmMvmtDt(chgCalcCntrVO.getToMvmtDt());
				chgCalcParmVO.setFmMvmtStsCd("DR");
				chgCalcParmVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				chgCalcParmVO.setIoBndCd(chgPartialPaymentVO.getIoBndCd());
				chgCalcParmVO.setToMvmtDt("");
				chgCalcParmVO.setToMvmtStsCd("");
				chgCalcParmVO.setToMvmtYdCd("");
				
				if("Y".equals(chgCalcCntrVO.getDulTpExptFlg())) {
					// Dual Exception Charge중 Combined Charge에 대한 Dual Charge를 조회한다..
					List<ChargeCalculationContainerVO> chgCalcCntrVOs = dbDao.searchDualChargeTariff(chgArgVO);
					
					if(chgCalcCntrVOs != null && chgCalcCntrVOs.size() > 0) {
						chgArgVO.setCallFlag("BALANCE");
						resultVO = dualExceptionChargeCalculation("BALANCE", chgCalcCntrVO, chgCalcCntrVOs, account);
						
						// 오류 발생시 Return
						if(resultVO.getResultCode() != null) {
							return resultVO;
						}
					}
					
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
					if(("Y".equals(chgCalcCntrVO.getCxlBkgChgFlg())) ||
						(("DTOC".equals(chgCalcCntrVO.getDmdtTrfCd()) || "CTOC".equals(chgCalcCntrVO.getDmdtTrfCd()) ) && "OP".equals(chgCalcCntrVO.getFmMvmtStsCd()) && "MT".equals(chgCalcCntrVO.getToMvmtStsCd()))
						) {
						
						// CxlBkgChgFlg = "Y" : 이미 Booking Cancel 되었음을 의미한다. (배치 프로그램.)
						// TRF CD("DTOC", "CTOC") && FM ("OP") && To ("MT") 현재 Booking Canecl인 아니지만, 곧 Cancel 된다고 생각하면 된다.(화면에서 입력된 경우)
						
						retChgCalcCntrVO = dmtCancelChargeCalculationUtil.cancelChargeCalculation(chgCalcParmVO);
						
						if("-1".equals(retChgCalcCntrVO.getMsgCd()) || "88".equals(retChgCalcCntrVO.getMsgCd())) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					} else {
						retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
						
						if("-1".equals(retChgCalcCntrVO.getMsgCd())) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					}
				}
				
				// Charge Sequence = Max Charge Sequence + 1
				String nextChgSeq = String.valueOf(NumberUtils.toInt(chgMaxSeq, 0) + 1);
				chgCalcCntrVO.setChgSeq(nextChgSeq);
				
				// 2010-07-07 추가 (Charge Calculation 이후 리턴된  OFC_CD 에 대한 SYS_AREA_GRP_ID 조회)
				String svrId = dbDao.searchRhqGrpId(retChgCalcCntrVO.getOfcCd());
				
				// 2010-07-07 추가 (해당 Charge Booking Container 정보 존재하는지 체크)
				ChargeArgumentVO chkChgArgVO = new ChargeArgumentVO();
				chkChgArgVO.setSvrId(svrId);
				chkChgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chkChgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				
				boolean chkExists = dbDao.checkChargeBookingContainerExists(chkChgArgVO);
				
				// 해당 Charge Booking Container 정보가 없으면 추가
				if(!chkExists) {
					// ************  DMT_CHG_BKG_CNTR 데이터 추가 ******************
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
					
					// DMT_CHG_BKG_CNTR 테이블에  Data를  Insert 한다.
					dbDao.addBkgCntr(dmtChgBkgCntrVO);
				}
				
				// addCharge (DMT_CHG_CALC 테이블에 Insert)
				DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
				
				// 2010-07-06 수정 (SYS_AREA_GRP_ID를 위에서 조회된 값으로 설정)
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
				dmtChgCalcVO.setBzcDmdtDeTermCd(retChgCalcCntrVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
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
				dmtChgCalcVO.setOfcRhqCd(retChgCalcCntrVO.getOfcRhq());		// 2010-07-05 수정
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
				dmtChgCalcVO.setUclmFlg(chgCalcCntrVO.getUclmFlg());
				
				// DMT_CHG_CALC 테이블에  Insert 처리
				dbDao.addCharge(dmtChgCalcVO);
				
				if("Y".equals(chgCalcCntrVO.getDulTpExptFlg())) {
					// Dual Exception Charge의 ORG_CHG_AMT, SC_RFA_EXPT_AMT 필드값 수정
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
				
				chargeResultVOs[i].setFtEndDt(dmtChgCalcVO.getFtEndDt());  //2011.11.30
				chargeResultVOs[i].setChgSeq(dmtChgCalcVO.getChgSeq());    //2012.01.12 추가-EDO 전송시  필요.
			} // for end
			
			resultVO.setChargeCalculationContainerVOArray(chargeResultVOs); //2011.11.30
			
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
	 * Charge 계산시 적용된 Clock Stop 이 있을경우 History 를 생성한다<br>
	 * [처리로직]
	 * 1. 기 생성된 Clock Stop History를 삭제한다 (deleteClockStopHistory)
	 * 2. 적용된 Clock Stop 갯수만큼 반복문을 실행하며 Insert한다( addClockStopHistory )
	 * 
	 * @param DmtChgTmCskStopVO dmtChgTmCskStopVO 
	 * @param List<String> cStopNoList
	 * @exception EventException
	 */
	public void modifyClockStopHistory(DmtChgTmCskStopVO dmtChgTmCskStopVO, List<String> cStopNoList) throws EventException {
		try {
			// 기 생성된 Clock Stop History 를 삭제한다.
			dbDao.deleteClockStopHistory(dmtChgTmCskStopVO);
			
			if(cStopNoList != null && cStopNoList.size() > 0) {
				// 적용된 Clock Stop 갯수만큼 반복문을 실행하며 Insert 한다.
				for ( int i=0; i < cStopNoList.size(); i++ ) {
					String clkStopNo = cStopNoList.get(i);
					dmtChgTmCskStopVO.setClkStopNo(clkStopNo);
					
					dbDao.addClockStopHistory(dmtChgTmCskStopVO);
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
	 * Booking 요청시 처리<br>
	 * searchChargeByCustomer에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ChargeByBookingCustomerParmVO   chargeByBookingCustomerParmVO
	 * @return ChargeByBookingCustomerGrpVO
	 * @exception EventException 
	 */
	public ChargeByBookingCustomerGrpVO searchChargeByCustomer(ChargeByBookingCustomerParmVO  chargeByBookingCustomerParmVO) throws EventException {
		ChargeByBookingCustomerGrpVO chargeByBookingCustomerGrpVO = new ChargeByBookingCustomerGrpVO();
		try {
			//[LOGIC] 
//			기준정보 조회 후 데이타가 존재 X
//				Basic data 조회
//			기준정보 조회 후 데이타가 존재 0
//				exp_del_dt 존재 X
//					chg_calc_data 조회 rate 구분: G/S/B
//				exp_del_dt 존재 0
//					Pre cal

			String exist = "";
			String dmdtTrfCd = "";
			
			String cntrCycNo = "";
			String dmdtChgLocDivCd = "";
			String fmMvmtStsCd = "";
			String fmMvmtDt = "";
			String fmMvmtYdCd = "";
			String toMvmtStsCd = "";
			String toMvmtYdCd = "";
			String ioBndCd = "";
			String custCntCd = "";
			String custSeq = "";			
			String actCntCd = "";
			String actCustSeq = "";
			String bzcTrfCurrCd = "";
			
			String bkgNo       = chargeByBookingCustomerParmVO.getBkgNo();
			String podCd       = chargeByBookingCustomerParmVO.getPodCd();
			String expDelDt    = chargeByBookingCustomerParmVO.getExpDelDt();
			String trfAplyTpCd = chargeByBookingCustomerParmVO.getDmdtTp();
			String[] cntrNos   = chargeByBookingCustomerParmVO.getCntrNo();
			
			if (StringUtils.isEmpty(bkgNo) || StringUtils.isEmpty(podCd) || cntrNos == null) {
				chargeByBookingCustomerGrpVO = new ChargeByBookingCustomerGrpVO();
				return chargeByBookingCustomerGrpVO;
			}
			
			// 로그관련 코드부분==================================================================================
			StringBuilder sbLog = new StringBuilder();
			
			if (log.isDebugEnabled()) {
				sbLog.append("\n\n");
				sbLog.append("\n[ searchChargeByCustomer ][param] BKG No.       :: " + bkgNo      );
				sbLog.append("\n[ searchChargeByCustomer ][param] Tariff Type   :: " + trfAplyTpCd);
				sbLog.append("\n[ searchChargeByCustomer ][param] POD           :: " + podCd      );
				sbLog.append("\n[ searchChargeByCustomer ][param] EXP. DEL DATE :: " + expDelDt   );
				sbLog.append("\n[ searchChargeByCustomer ][param] CNTR No.      :: ");
				for (String cntrNo : cntrNos) {
					sbLog.append(cntrNo).append(", ");
				}
				log.debug(sbLog.toString());
				
				sbLog.setLength(0);
			}
			//===================================================================================================
			
			BKGChargeCalculationUtil bkgChargeCalculationUtil = new BKGChargeCalculationUtil();
			List<ChargeByBookingCustomerCntrVO> chargeByBookingCustomerCntrVOS = new ArrayList<ChargeByBookingCustomerCntrVO>();
			ChargeByBookingCustomerCntrVO chargeByBookingCustomerCntrVO = null;
			ChargeByBookingCustomerCntrVO chargeByBookingCustomerCntr01 = null;
			ChargeByBookingCustomerCntrVO chargeByBookingCustomerCntr02 = null;
			
			List<ChargeByBookingCustomerInvVO> chargeByBookingCustomerInvVOS = new ArrayList<ChargeByBookingCustomerInvVO>();
			ChargeByBookingCustomerInvVO chargeByBookingCustomerInvVO = null;
			
			BookingCustomerBasicVO bookingCustomerBasicVO = null;
			for (String cntrNo : cntrNos) {
				
				ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO = new ChargeByOfficeOrVVDVO();
				chargeByOfficeOrVVDVO.setBkgNo(bkgNo);
				chargeByOfficeOrVVDVO.setCntrNo(cntrNo);
				
				// [CHM-201327779] [DMT] BKB Split case에 대한 LFD 조회
				// Booking vs Container = 1 : 0.5 로 Container 가 Split 된 경우 DMT Charge 에서는 특정 Booking에 Contaier가 할당
				// 되기 때문에 BKG 호출시 BKG_NO, CNTR_NO로 조회가 되지 않기 때문에 아래 DAO를 호출하여 Like 검색을 통해 Charge가 생성된 Booking No를 찾는다.
				
				bkgNo = dbDao.searchBookingSplitNo(chargeByOfficeOrVVDVO);
				log.info("*[ searchChargeByCustomer[param] : bkg_no 2 	] : "+bkgNo);
				bookingCustomerBasicVO  = bkgChargeCalculationUtil.searchBookingCustomerBasicData(bkgNo, cntrNo);
				
				exist = StringUtils.defaultString(bookingCustomerBasicVO.getExist());
				// 어떤 Tariff Type 이 적용되었는지 나타냄 (G : Basic Tariff, S : S/C Exception Tariff, B : RFA Exception Tariff)
				trfAplyTpCd = StringUtils.defaultString(bookingCustomerBasicVO.getTpCd());	
				dmdtTrfCd = StringUtils.defaultString(bookingCustomerBasicVO.getDmdtTrfCd());				
				cntrCycNo = StringUtils.defaultString(bookingCustomerBasicVO.getCntrCycNo());
				dmdtChgLocDivCd = StringUtils.defaultString(bookingCustomerBasicVO.getDmdtChgLocDivCd());
				fmMvmtStsCd = StringUtils.defaultString(bookingCustomerBasicVO.getFmMvmtStsCd());
				fmMvmtDt = StringUtils.defaultString(bookingCustomerBasicVO.getFmMvmtDt());
				fmMvmtYdCd = StringUtils.defaultString(bookingCustomerBasicVO.getFmMvmtYdCd());
				toMvmtStsCd = StringUtils.defaultString(bookingCustomerBasicVO.getToMvmtStsCd());
				toMvmtYdCd = StringUtils.defaultString(bookingCustomerBasicVO.getToMvmtYdCd());
				ioBndCd = StringUtils.defaultString(bookingCustomerBasicVO.getIoBnd());
				custCntCd = StringUtils.defaultString(bookingCustomerBasicVO.getCustCntCd());
				custSeq = StringUtils.defaultString(bookingCustomerBasicVO.getCustSeq());				
				actCntCd = StringUtils.defaultString(bookingCustomerBasicVO.getActCntCd());
				actCustSeq = StringUtils.defaultString(bookingCustomerBasicVO.getActCustSeq());
				bzcTrfCurrCd = StringUtils.defaultString(bookingCustomerBasicVO.getBzcTrfCurrCd());
				
				//3. Demurrage Type Setting - exist가 없다면 아래 dmdt_trf_cd도 없다. 
				// 없을 경우 아래  - 기준정보 조회 후 데이타가 존재 X 로직에서 처리 함.
				chargeByBookingCustomerGrpVO.setDemurType(dmdtTrfCd);		//('DMIF', 'CTIC')

				// 로그 코드부분==================================================================================
				if (log.isDebugEnabled()) {
					sbLog.append("\n\n");
					sbLog.append("\n*******************************************************************");
					sbLog.append("\n P0.Booking Customer Basic Data");
					sbLog.append("\n[ searchChargeByCustomer ] exist          : [" + exist       +"]");
					sbLog.append("\n[ searchChargeByCustomer ] tp_cd          : [" + trfAplyTpCd +"]");
					sbLog.append("\n[ searchChargeByCustomer ] dmdt_trf_cd    : [" + dmdtTrfCd   +"]");
					sbLog.append("\n[ searchChargeByCustomer ] fm_mvmt_sts_cd : [" + fmMvmtStsCd +"]");
					sbLog.append("\n[ searchChargeByCustomer ] fm_mvmt_dt     : [" + fmMvmtDt    +"]");
					sbLog.append("\n[ searchChargeByCustomer ] fm_mvmt_yd_cd  : [" + fmMvmtYdCd  +"]");
					sbLog.append("\n[ searchChargeByCustomer ] to_mvmt_sts_cd : [" + toMvmtStsCd +"]");
					sbLog.append("\n[ searchChargeByCustomer ] to_mvmt_yd_cd  : [" + toMvmtYdCd  +"]");
					sbLog.append("\n[ searchChargeByCustomer ] io_bnd         : [" + ioBndCd     +"]");
					sbLog.append("\n[ searchChargeByCustomer ] cust_cnt_cd    : [" + custCntCd   +"]");
					sbLog.append("\n[ searchChargeByCustomer ] cust_seq       : [" + custSeq     +"]");
					sbLog.append("\n[ searchChargeByCustomer ] act_cnt_cd     : [" + actCntCd    +"]");
					sbLog.append("\n[ searchChargeByCustomer ] [act_cust_seq  : [" + actCustSeq  +"]");
					sbLog.append("\n*******************************************************************");
					log.debug(sbLog.toString());
					
					sbLog.setLength(0);
				}
				//=================================================================================================	
				
				//	기준정보 조회 후 데이타가 존재 X
				if (StringUtils.isEmpty(exist)) {
					
					// 로그 코드부분=====================================================================================		
					if (log.isDebugEnabled()) {
						sbLog.append("\n\n");			
						sbLog.append("\n*****************************************************");
						sbLog.append("\n P1. Basic data == '' ");
						sbLog.append("\n[ searchChargeByCustomer ] bkg_no   : [" + bkgNo  + "]");
						sbLog.append("\n[ searchChargeByCustomer ] cntr_nos : [" + cntrNo + "]");
						sbLog.append("\n[ searchChargeByCustomer ] pod_cd   : [" + podCd  + "]");
						sbLog.append("\n*****************************************************");			
						log.debug(sbLog.toString());
						
						sbLog.setLength(0);
					}
					//===================================================================================================
					
					chargeByBookingCustomerCntrVO = new ChargeByBookingCustomerCntrVO();
					chargeByBookingCustomerInvVO = new ChargeByBookingCustomerInvVO();
					
					//1. CONTAINER 정보 리턴
					chargeByBookingCustomerCntrVO = bkgChargeCalculationUtil.searchBookingCustomerCntrPartialInfo(bkgNo, cntrNo, cntrNo, "G");
					if ("0".equals(chargeByBookingCustomerCntrVO.getMsgCd())) {
						chargeByBookingCustomerCntrVOS.add(chargeByBookingCustomerCntrVO);
					} 
					else {
						log.info("P1. searchBookingCustomerCntrPartialInfo : return -1");
					}
					
					//2. CNTR_NO별로 해당하는 INVOICE 정보 리턴 없음
					// 정보가 없어서 다른 로직 처리 없음.
					
					//3. Demurrage Type Setting DMT_CHG_CALC에 데이터가 없다면  DMDT_TRF_CD 셋팅.
					chargeByBookingCustomerGrpVO.setDemurType(chargeByBookingCustomerCntrVO.getDmdtTrfCd());
					
				} 
				//기준정보 조회 후 데이타가 존재 0
				else {
					//exp_del_dt 존재 X
					if (StringUtils.isEmpty(expDelDt)) {
					    // 로그 코드부분=====================================================================================		
						if (log.isDebugEnabled()) {
							sbLog.append("\n\n");			
							sbLog.append("\n*****************************************************");
							sbLog.append("\n P2. Basic data != '' && exp_del_dt param data == '' ");
							sbLog.append("\n[ searchChargeByCustomer ] bkg_no   : [" + bkgNo       + "]");
							sbLog.append("\n[ searchChargeByCustomer ] cntr_nos : [" + cntrNo      + "]");
							sbLog.append("\n[ searchChargeByCustomer ] pod_cd   : [" + podCd       + "]");
							sbLog.append("\n[ searchChargeByCustomer ] tp_cd    : [" + trfAplyTpCd + "]");
							sbLog.append("\n*****************************************************");			
							log.debug(sbLog.toString());
							
							sbLog.setLength(0);
						}
						//===================================================================================================	
						chargeByBookingCustomerCntrVO = new ChargeByBookingCustomerCntrVO();
						chargeByBookingCustomerCntr01 = new ChargeByBookingCustomerCntrVO();
						chargeByBookingCustomerCntr02 = new ChargeByBookingCustomerCntrVO();
						chargeByBookingCustomerInvVO = new ChargeByBookingCustomerInvVO();
						
						//1. CONTAINER 정보 리턴
						chargeByBookingCustomerCntr01 = bkgChargeCalculationUtil.searchBookingCustomerCntrPartialInfo(bkgNo, cntrNo, podCd, trfAplyTpCd);
						
						if ("0".equals(chargeByBookingCustomerCntr01.getMsgCd())) {
							chargeByBookingCustomerCntrVO.setFtDys(StringUtils.defaultString(chargeByBookingCustomerCntr01.getFtDys()));
							chargeByBookingCustomerCntrVO.setXcldSatFlg(StringUtils.defaultString(chargeByBookingCustomerCntr01.getXcldSatFlg()));
							chargeByBookingCustomerCntrVO.setXcldSunFlg(StringUtils.defaultString(chargeByBookingCustomerCntr01.getXcldSunFlg()));
							chargeByBookingCustomerCntrVO.setXcldHolFlg(StringUtils.defaultString(chargeByBookingCustomerCntr01.getXcldHolFlg()));
							chargeByBookingCustomerCntrVO.setCurrCd(StringUtils.defaultString(chargeByBookingCustomerCntr01.getCurrCd()));
							chargeByBookingCustomerCntrVO.setCntrRtAmt(StringUtils.defaultString(chargeByBookingCustomerCntr01.getCntrRtAmt()));
							chargeByBookingCustomerCntrVO.setCntrTpszCd(StringUtils.defaultString(chargeByBookingCustomerCntr01.getCntrTpszCd()));
						} 
						else {
							log.info("P2. searchBookingCustomerCntrPartialInfo : return -1");
						}
						
						
						chargeByBookingCustomerCntr02 = bkgChargeCalculationUtil.searchBookingCustomerCntr(bkgNo, cntrNo);
						if ("0".equals(chargeByBookingCustomerCntr02.getMsgCd())) {
							chargeByBookingCustomerCntrVO.setFxFtOvrDys(StringUtils.defaultString(chargeByBookingCustomerCntr02.getFxFtOvrDys()));
							chargeByBookingCustomerCntrVO.setBzcTrfCurrCd(StringUtils.defaultString(chargeByBookingCustomerCntr02.getBzcTrfCurrCd()));  //charge data
							chargeByBookingCustomerCntrVO.setBilAmt(StringUtils.defaultString(chargeByBookingCustomerCntr02.getBilAmt()));
							chargeByBookingCustomerCntrVO.setFtDysCalc(StringUtils.defaultString(chargeByBookingCustomerCntr02.getFtDys())); //수정
							chargeByBookingCustomerCntrVO.setFtEndDt(StringUtils.defaultString(chargeByBookingCustomerCntr02.getFtEndDt()));
						} 
						else {
							log.info("P2. searchBookingCustomerCntr : return -1");
						}
						
						//chargeByBookingCustomerCntr01 또는 chargeByBookingCustomerCntr02 둘 중 값이 정상적일 경우에만 정상적으로 리턴함.
						if ("0".equals(chargeByBookingCustomerCntr01.getMsgCd()) || "0".equals(chargeByBookingCustomerCntr02.getMsgCd())) {
							chargeByBookingCustomerCntrVO.setBkgNo(bkgNo);
							chargeByBookingCustomerCntrVO.setCntrNo(cntrNo);
							chargeByBookingCustomerCntrVO.setExpDelDt(StringUtils.defaultString(expDelDt));
							chargeByBookingCustomerCntrVO.setPodCd(StringUtils.defaultString(podCd));
							chargeByBookingCustomerCntrVOS.add(chargeByBookingCustomerCntrVO);
						} 
						else {
							log.info("P2. chargeByBookingCustomerCntrVOS : return -1");
						}
						
						
						//2. CNTR_NO별로 해당하는 INVOICE 정보 리턴
						List<ChargeByBookingCustomerInvVO> listInvVO = bkgChargeCalculationUtil.searchChargeByBookingCustomerInvList(bkgNo, cntrNo);
						
						if (listInvVO.size() > 0) {
							for (ChargeByBookingCustomerInvVO invVOS : listInvVO) {
								chargeByBookingCustomerInvVO = new ChargeByBookingCustomerInvVO();
								chargeByBookingCustomerInvVO.setBkgNo(bkgNo);
								chargeByBookingCustomerInvVO.setCntrNo(cntrNo);
								chargeByBookingCustomerInvVO.setExpDelDt(StringUtils.defaultString(expDelDt));
								chargeByBookingCustomerInvVO.setPodCd(StringUtils.defaultString(podCd));
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
					//exp_del_dt 존재 0
					else {
					    // 로그 코드부분=====================================================================================		
						if (log.isDebugEnabled()) {
							sbLog.append("\n\n");			
							sbLog.append("\n*****************************************************");
							sbLog.append("\n P3. Basic data != '' && exp_del_dt param data != '' ");
							sbLog.append("\n[ searchChargeByCustomer ] bkg_no   : [" + bkgNo       + "]");
							sbLog.append("\n[ searchChargeByCustomer ] cntr_nos : [" + cntrNo      + "]");
							sbLog.append("\n[ searchChargeByCustomer ] pod_cd   : [" + podCd       + "]");
							sbLog.append("\n[ searchChargeByCustomer ] tp_cd    : [" + trfAplyTpCd + "]");
							sbLog.append("\n*****************************************************");			
							log.debug(sbLog.toString());
							
							sbLog.setLength(0);
						}
						//===================================================================================================
						chargeByBookingCustomerCntrVO = new ChargeByBookingCustomerCntrVO();
						chargeByBookingCustomerCntr01 = new ChargeByBookingCustomerCntrVO();
						chargeByBookingCustomerCntr02 = new ChargeByBookingCustomerCntrVO();
						chargeByBookingCustomerInvVO = new ChargeByBookingCustomerInvVO();
						
						//1. CONTAINER 정보 리턴
						
						chargeByBookingCustomerCntr01 = bkgChargeCalculationUtil.searchBookingCustomerCntrPartialInfo(bkgNo, cntrNo, podCd, trfAplyTpCd);
						if ("0".equals(chargeByBookingCustomerCntr01.getMsgCd())) {
							chargeByBookingCustomerCntrVO.setFtDys(StringUtils.defaultString(chargeByBookingCustomerCntr01.getFtDys()));
							chargeByBookingCustomerCntrVO.setXcldSatFlg(StringUtils.defaultString(chargeByBookingCustomerCntr01.getXcldSatFlg()));
							chargeByBookingCustomerCntrVO.setXcldSunFlg(StringUtils.defaultString(chargeByBookingCustomerCntr01.getXcldSunFlg()));
							chargeByBookingCustomerCntrVO.setXcldHolFlg(StringUtils.defaultString(chargeByBookingCustomerCntr01.getXcldHolFlg()));
							chargeByBookingCustomerCntrVO.setCurrCd(StringUtils.defaultString(chargeByBookingCustomerCntr01.getCurrCd()));
							chargeByBookingCustomerCntrVO.setCntrRtAmt(StringUtils.defaultString(chargeByBookingCustomerCntr01.getCntrRtAmt()));
							chargeByBookingCustomerCntrVO.setCntrTpszCd(StringUtils.defaultString(chargeByBookingCustomerCntr01.getCntrTpszCd()));
						} 
						else {
							log.info("P3. searchBookingCustomerCntrPartialInfo : return -1");
						}
						
						ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
						chargeCalculationParmVO.setCntrNo(cntrNo);				//param value
						chargeCalculationParmVO.setCntrCycNo(cntrCycNo);		//charge data
						chargeCalculationParmVO.setBkgNo(bkgNo);				//param value
						chargeCalculationParmVO.setFmMvmtDt(fmMvmtDt);			//charge data
						chargeCalculationParmVO.setFmMvmtYdCd(fmMvmtYdCd);		//charge data
						chargeCalculationParmVO.setFmMvmtStsCd(fmMvmtStsCd);    //charge data
						chargeCalculationParmVO.setToMvmtDt(expDelDt);			//param value
						chargeCalculationParmVO.setToMvmtYdCd(toMvmtYdCd);		//charge data
						chargeCalculationParmVO.setToMvmtStsCd(toMvmtStsCd);	//charge data
						chargeCalculationParmVO.setDmdtTrfCd(dmdtTrfCd);		//charge data						
						chargeCalculationParmVO.setIoBndCd(ioBndCd);			//charge data
						chargeCalculationParmVO.setCustCntCd(custCntCd);		//charge data
						chargeCalculationParmVO.setCustSeq(custSeq);			//charge data
						chargeCalculationParmVO.setActCntCd(actCntCd);			//charge data
						chargeCalculationParmVO.setActCustSeq(actCustSeq);		//charge data
						chargeCalculationParmVO.setDmdtChgLocDivCd(dmdtChgLocDivCd); //charge data
						
						chargeByBookingCustomerCntr02 = bkgChargeCalculationUtil.preChargeCalculation(chargeCalculationParmVO);
						if ("0".equals(chargeByBookingCustomerCntr02.getMsgCd())) {
							chargeByBookingCustomerCntrVO.setFxFtOvrDys(StringUtils.defaultString(chargeByBookingCustomerCntr02.getFxFtOvrDys()));
							chargeByBookingCustomerCntrVO.setBzcTrfCurrCd(StringUtils.defaultString(bzcTrfCurrCd)); //charge data
							chargeByBookingCustomerCntrVO.setBilAmt(StringUtils.defaultString(chargeByBookingCustomerCntr02.getBilAmt()));
							chargeByBookingCustomerCntrVO.setFtDysCalc(StringUtils.defaultString(chargeByBookingCustomerCntr02.getFtDys())); //수정
							chargeByBookingCustomerCntrVO.setFtEndDt(DMTCalculationUtil.nullToString(chargeByBookingCustomerCntr02.getFtEndDt(), 8));
						}
						
						//chargeByBookingCustomerCntr01 또는 chargeByBookingCustomerCntr02 둘 중 값이 정상적일 경우에만 정상적으로 리턴함.
						if ("0".equals(chargeByBookingCustomerCntr01.getMsgCd()) || "0".equals(chargeByBookingCustomerCntr02.getMsgCd())) {
							chargeByBookingCustomerCntrVO.setBkgNo(bkgNo);
							chargeByBookingCustomerCntrVO.setCntrNo(cntrNo);
							chargeByBookingCustomerCntrVO.setExpDelDt(StringUtils.defaultString(expDelDt));
							chargeByBookingCustomerCntrVO.setPodCd(StringUtils.defaultString(podCd));
							chargeByBookingCustomerCntrVOS.add(chargeByBookingCustomerCntrVO);
						} 
						else {
							log.info("P3. chargeByBookingCustomerCntrVOS : return -1");
						}
						
						
						//2. CNTR_NO별로 해당하는 INVOICE 정보 리턴
						List<ChargeByBookingCustomerInvVO> listInvVO = bkgChargeCalculationUtil.searchChargeByBookingCustomerInvList(bkgNo, cntrNo);
						
						if (listInvVO.size() > 0) {
							for (ChargeByBookingCustomerInvVO invVOS : listInvVO) {
								chargeByBookingCustomerInvVO = new ChargeByBookingCustomerInvVO();
								chargeByBookingCustomerInvVO.setBkgNo(bkgNo);
								chargeByBookingCustomerInvVO.setCntrNo(cntrNo);
								chargeByBookingCustomerInvVO.setExpDelDt(StringUtils.defaultString(expDelDt));
								chargeByBookingCustomerInvVO.setPodCd(StringUtils.defaultString(podCd));
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
			//1. CONTAINER 정보 리턴
			chargeByBookingCustomerGrpVO.setChargeByBookingCustomerCntrVOS(chargeByBookingCustomerCntrVOS);
			//2. CNTR_NO별로 해당하는 INVOICE 정보 리턴
			chargeByBookingCustomerGrpVO.setChargeByBookingCustomerInvVOS(chargeByBookingCustomerInvVOS);
			
			
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge By Customer"}).getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge By Customer"}).getMessage());
		}
		
		log.info("[1.getChargeByBookingCustomerCntrVOS()]");
		if (chargeByBookingCustomerGrpVO.getChargeByBookingCustomerCntrVOS() != null) {
			if (chargeByBookingCustomerGrpVO.getChargeByBookingCustomerCntrVOS().size() > 0) {
				for (ChargeByBookingCustomerCntrVO logCntrVO : chargeByBookingCustomerGrpVO.getChargeByBookingCustomerCntrVOS()) {
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
		if (chargeByBookingCustomerGrpVO.getChargeByBookingCustomerInvVOS() != null) {
			if (chargeByBookingCustomerGrpVO.getChargeByBookingCustomerInvVOS() != null || chargeByBookingCustomerGrpVO.getChargeByBookingCustomerInvVOS().size() > 0) {
				for (ChargeByBookingCustomerInvVO logInvVOS : chargeByBookingCustomerGrpVO.getChargeByBookingCustomerInvVOS()) {
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
	 *  Office별 또는 VVD별 Charge 생성한 List를 조회한다.<br>
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchChargeStatusListByOfficeOrVVD(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) 
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
	 * OfficeTransfer시 동일한 RHQ Office 인 경우, 해당 Charge 관련정보(DMT_CHG_CALC, DMT_CHG_BKG_CNTR)를 수정한다. 
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
					
					//FROM OFFICE 가 존재하는지 체크 함 , 존재하지 않으면 에러 처리함(DMT01081)
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
					
					//FROM OFFICE 가 존재하는지 체크 함 , 존재하지 않으면 에러 처리함(DMT01081)
					checkOfficeTransfer = dbDao.checkMultiChargeByOfficeTransfer(ofcTrnsParmVO);

					if(checkOfficeTransfer) {
						chargeVO = new ChargeArgumentVO();
						chargeVO.setSvrId(dbDao.searchRhqGrpId(ofcTrnsParmByChargeVO.getToOfcCd()));
						chargeVO.setCntrNo(ofcTrnsParmByChargeVO.getCntrNo());
						chargeVO.setCntrCycNo(ofcTrnsParmByChargeVO.getCntrCycNo());
						
						if(!dbDao.checkChargeBookingContainerExists(chargeVO)){
							// 중복오류 발생해도(sqlcode==1) 오류처리하지 않고 그대로 진행한다.
							//2011.06.01 수정: Charge Booking CNTR 정보가 존재하지 않으면 등록한다.
							dbDao.addBookingContainerByOfficeTransfer(ofcTrnsParmByChargeVO);
						}
						
						// OT처리 전에 기존 Charge 정보를 백업한다.
						dbDao.addChargeBackupByOfficeTransfer(ofcTrnsParmByChargeVO);
						
						// 기존 Charge 데이터(DMT_CHG_CALC)를 OT처리에 맞게 정보를 수정한다.(SYS_AREA_GRP_ID, OFC_CD, OFC_RHQ_CD 등)
						dbDao.modifyChargeByOfficeTransfer(ofcTrnsParmVO, account);
						
						// OT된 Charge와 관련된 다른 Charge정보가 더 존재하는지 체크한다.
						String isExist = dbDao.checkChargeByOfficeTransfer(ofcTrnsParmVO);
						
						// OT된 Charge와 관련된 다른 Charge정보가 없을 경우, Charge Booking Container 정보를 백업후 삭제한다.
						if("N".equals(isExist)) {
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
	 * OfficeTransfer시 다른 RHQ Office 인 경우, 해당 Charge 관련정보(DMT_CHG_CALC, DMT_CHG_BKG_CNTR)를 생성하고 수정한다. 
	 * 
	 * @param OfficeTransferParmVO[] officeTransferParmVOs 
	 * @exception EventException
	 */
	public void createChargeByOfficeTransfer(OfficeTransferParmVO[] officeTransferParmVOs) throws EventException {
		try {
			String fmSvrId = officeTransferParmVOs[0].getSvrId();
			
			OfficeTransferParmByChargeVO ofcTrnsParmByChargeVO = new OfficeTransferParmByChargeVO();
			ofcTrnsParmByChargeVO.setFmSvrId(fmSvrId);
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
				String toSvrId = dbDao.searchRhqGrpId(ofcTrnsParmByChargeVO.getToOfcCd());
				chargeVO.setSvrId(toSvrId);
				chargeVO.setCntrNo(ofcTrnsParmByChargeVO.getCntrNo());
				chargeVO.setCntrCycNo(ofcTrnsParmByChargeVO.getCntrCycNo());
				
				if(!dbDao.checkChargeBookingContainerExists(chargeVO)){
					// 중복오류 발생해도(sqlcode==1) 오류처리하지 않고 그대로 진행한다.
					//2011.06.01 수정: Charge Booking CNTR 정보가 존재하지 않으면 등록한다.
					dbDao.addBookingContainerByOfficeTransfer(ofcTrnsParmByChargeVO);
				}
				
				// Charge 정보를 타지역으로 Office Transfer 작업을 실행한다.
				dbDao.addChargeByOfficeTransfer(ofcTrnsParmByChargeVO);
				
				if(!fmSvrId.equals(toSvrId)){
					// From 과 To Server ID를 다를 경우
					// 이미 To 정보를 생성해 놓았기 때문에 From 정보를 삭제 처리한다.
					// OT 된 Charge 정보를 삭제처리 한다.
					dbDao.modifyChargeTransferStatusByOfficeTransfer(ofcTrnsParmByChargeVO);
				}
				
				// OT된 Charge와 관련된 다른 Charge정보가 더 존재하는지 체크한다.
				String isExist = dbDao.checkChargeByOfficeTransfer(ofcTrnsParmVO);
				
				// OT된 Charge와 관련된 다른 Charge정보가 없을 경우, Charge Booking Container 정보를 삭제한다.
				if("N".equals(isExist)) {
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
	 *  Charge별 계산한 History를 조회<br>
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
	 *  Partial할 대상 Charge를 조회한다<br>
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
	 * Charge Delete시 Delete Reason Data들의 List를 조회한다<br>
	 * 공통코드 테이블에서 Delete Reason Code와 Description을 조회한다<br>
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
	 * DEM/DET Billing 담당자가 DEM/DET Charge 확정 하는 과정에서 화주의 귀책이 아니거나,
	 * Manual Invoice가 필요한 Charge를 Delete한다.
	 * 
	 * - 선조건: Delete할 Charge의 Status가 Invoice되지 않아야한다
	 * - 후조건: 해당 Charge의 Charge Status가 "D"로 변경
	 * - 처리로직
	 *	1. 여러건의 Charge를 처리한다.
	 *	2. Charge별 현재 Status가 Invoice되었으면 메시지[DMT01002]를 보여주고 계산을 중단한다.
	 *	3. 현재 Charge의 Correction History를 Insert한다
	 *	4. Charge의 Status를 "D"로 변경한다
	 *	5. 변경된 Charge의 Correction History를 Insert한다
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
			com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = null;
			chargeArgumentVO = new com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
			
			ChargeCalculationContainerVO chgCalcCntrVO  = chargeCalculationContainerVOs[0];
			// 2012.01.05 각각의 chgCalcCntrVO 내용 반영되도록 수정함.
			//String dmdtChgDeltRsnCd = chgCalcCntrVO.getDmdtChgDeltRsnCd();
			//String corrRmk = chgCalcCntrVO.getCorrRmk();
			
			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
				chgCalcCntrVO = chargeCalculationContainerVOs[i];
				
				//중복처리 방지 체크로직
				com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO checkArgument 
					= new com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO();
				checkArgument.setSvrId(chgCalcCntrVO.getSvrId());
				checkArgument.setCntrNo(chgCalcCntrVO.getCntrNo());
				checkArgument.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				checkArgument.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				checkArgument.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				checkArgument.setChgSeq(chgCalcCntrVO.getChgSeq());
				checkArgument.setStsCd("DELETE");

				boolean isExist = dbDao.checkChargeByConfirmDeleteDeleteCancel(checkArgument);
				//UPDATE할 내용이 없으면 오류 처리 함
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
				
				if("I".equals(chargeStatusNRemarkVO.getDmdtChgStsCd())) {
					return "DMT01026";
				}
				
				String chgOfc = chgCalcCntrVO.getOfcCd();
				//chgCalcCntrVO.setCorrRmk(corrRmk);
				//chgCalcCntrVO.setDmdtChgDeltRsnCd(dmdtChgDeltRsnCd);
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
				
				checkArgument.setOfcCd(chgOfc);
				checkArgument.setDeltSeq(chgCalcCntrVO.getDeltSeq());
				checkArgument.setRhqOfcCd(account.getRhq_ofc_cd()) ;
				checkArgument.setUpdUsrId(account.getUsr_id());
				checkArgument.setUpdOfcCd(account.getOfc_cd());
				checkArgument.setStsCd("A");
			    // ChargeDeletion Approval
				dbDao.modifyChargeDeletion(checkArgument);			
			
				ExceptionChargeCalculationVO exceptionChargeCalculationVO = new ExceptionChargeCalculationVO();

				exceptionChargeCalculationVO.setBkgNo(dmtChgCorrHisVO.getBkgNo());
				exceptionChargeCalculationVO.setCntrNo(dmtChgCorrHisVO.getCntrNo());
				exceptionChargeCalculationVO.setCntrCycNo(dmtChgCorrHisVO.getCntrCycNo());
				exceptionChargeCalculationVO.setDmdtTrfCd(chargeArgumentVO.getDmdtTrfCd());
				exceptionChargeCalculationVO.setDmdtChgLocDivCd(chargeArgumentVO.getDmdtChgLocDivCd());
				exceptionChargeCalculationVO.setChgSeq(chargeArgumentVO.getChgSeq());
				exceptionChargeCalculationVO.setDmdtChgStsCd("D"); //Delete
				exceptionChargeCalculationVO.setUpdUsrId(account.getUsr_id());
				exceptionChargeCalculationVO.setUpdOfcCd(account.getOfc_cd());

				if (dbDao.checkDmtExceptionChargeCalculation(exceptionChargeCalculationVO)) {
					dbDao.mergeDmtExceptionChargeCalculation(exceptionChargeCalculationVO);
				}
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
	 * 하나의 Charge를 Partial한다.<br>
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
			
			com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			DMTGeneralChargeCalculationUtil	dmtGeneralChargeCalculationUtil 	= new DMTGeneralChargeCalculationUtil();
			DMTBalanceChargeCalculationUtil dmtBalanceChargeCalculationUtil 	= new DMTBalanceChargeCalculationUtil();
			DMTCancelChargeCalculationUtil	dmtCancelChargeCalculationUtil		= new DMTCancelChargeCalculationUtil();
			DMTCombinedChargeCalculationUtil dmtCombinedChargeCalculationUtil	= new DMTCombinedChargeCalculationUtil();
			
			com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO utilChgArgVO = null;
			utilChgArgVO = new com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
			
			// 첫번째 ChargeCalculationContainerVO 객체에서 우선 필요한 정보를 가져온다.
			ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs[0];
			
			ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
			chgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
			chgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
			chgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
			chgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
			chgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
			chgArgVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
			chgArgVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
			chgArgVO.setFmMvmtDtTime(chgCalcCntrVO.getFmMvmtDtTime());
			chgArgVO.setToMvmtDtTime(chgCalcCntrVO.getToMvmtDtTime());
			
			// Partial Payment처리시 해당 Charge의 General 및 Balance를 모두 삭제
			dbDao.deleteChargeByPartial(chgArgVO);
			
			
			// 타지역 Charge가 존재시 Charge Seq List를 가져온다.
			List<String> othSvrChgSeqList = dbDao.searchOthSvrChgSeqByPartial(chgArgVO);
			
			int chgSeq = 0;
			
			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
				chgCalcCntrVO = chargeCalculationContainerVOs[i];
				
				// 한 건씩 FromDate와 ToDate의 일수를 계산하여 1일 미만이면 DMT01028 메시지 출력 후 처리를 중단한다.
				int days = dbDao.checkFromToDate(chgCalcCntrVO.getFmMvmtDt(), chgCalcCntrVO.getToMvmtDt(), account.getOfc_cd());
				if(days < 1) {
					resultVO.setResultCode("DMT01028");
					return resultVO;
				}
				
				// charge seq 설정하는 부분 (2010-05-27 수정)
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
				
				
				// ************* DmtChgCalcVO 객체 구성 *****************
				DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
				dmtChgCalcVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCalcVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCalcVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCalcVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCalcVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCalcVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				dmtChgCalcVO.setFmMvmtStsCd(chgCalcCntrVO.getFmMvmtStsCd());
				dmtChgCalcVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt()+chgCalcCntrVO.getFmMvmtDtTime());
//				dmtChgCalcVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				dmtChgCalcVO.setFmMvmtYdCd(chgCalcCntrVO.getFmMvmtYdCd());
				dmtChgCalcVO.setToMvmtStsCd(chgCalcCntrVO.getToMvmtStsCd());
//				dmtChgCalcVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				dmtChgCalcVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt()+chgCalcCntrVO.getToMvmtDtTime());
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
				dmtChgCalcVO.setBzcTrfSeq(chgCalcCntrVO.getBzcTrfSeq());
				dmtChgCalcVO.setBzcDmdtDeTermCd(chgCalcCntrVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
				dmtChgCalcVO.setBzcTrfGrpSeq(chgCalcCntrVO.getBzcTrfGrpSeq());
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
				dmtChgCalcVO.setUpdUsrId(account.getUsr_id());
				dmtChgCalcVO.setUpdOfcCd(account.getOfc_cd());
				dmtChgCalcVO.setCmdtCd(chgCalcCntrVO.getCmdtCd());
				dmtChgCalcVO.setOfcTrnsFlg(chgCalcCntrVO.getOfcTrnsFlg());
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
				dmtChgCalcVO.setUclmFlg(chgCalcCntrVO.getUclmFlg());
				
				// Charge Table Data를 Insert한다
				dbDao.addCharge(dmtChgCalcVO);
				
				String checkScRfaExptApltDt = null;
				
				if ("1".equals(chgCalcCntrVO.getChgSeq())) {
					ChargeStatusNRemarkVO checkScRfaExptApltDtVO = null;
					ChargeArgumentVO checkArgumentVO = new ChargeArgumentVO();
					
					checkArgumentVO.setSvrId(chgCalcCntrVO.getSvrId());
					checkArgumentVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					checkArgumentVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					checkArgumentVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					checkArgumentVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					checkArgumentVO.setChgSeq(chgCalcCntrVO.getChgSeq());
					
					checkScRfaExptApltDtVO = dbDao.searchChargeStatusNRemark(checkArgumentVO);
					checkScRfaExptApltDt = checkScRfaExptApltDtVO.getScRfaExptApltDt();
				}
				
				// com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO 객체
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
				chgArgVO.setFmMvmtDtTime(chgCalcCntrVO.getFmMvmtDtTime());
				chgArgVO.setToMvmtDtTime(chgCalcCntrVO.getToMvmtDtTime());
				
				String toMvmtStsCd = chgCalcCntrVO.getToMvmtStsCd();
				ChargePartialPaymentVO chgPartialPaymentVO = null;
				
				if("DR".equals(toMvmtStsCd))
					chgPartialPaymentVO = dbDao.searchChargeCalculationUseDataByDR(chgArgVO);
				else
					chgPartialPaymentVO = dbDao.searchChargeCalculationUseData(chgArgVO);
			
				
				if("EUR".equals(chgCalcCntrVO.getSvrId())) {
					String obCntrFlg = dbDao.searchInOutBoundByMovement(chgCalcCntrVO.getCntrNo(), chgCalcCntrVO.getCntrCycNo(), chgCalcCntrVO.getFmMvmtYdCd());
					//log.debug("============> OB_CNTR_FLG : " + obCntrFlg);
					//'N' --> 'I'  , 'Y' --> 'O'
					
					// DATA존재시, IN/OUT BOUND 값을 사용한다.
					if(!"".equals(obCntrFlg)) {
						String ioBndCd = "N".equals(obCntrFlg) ? "I" : "O";
						chgPartialPaymentVO.setIoBndCd(ioBndCd);
					} else {
						chgPartialPaymentVO.setIoBndCd(chgCalcCntrVO.getDmdtTrfCd().substring(2, 3));
					}
				}
				
				chgCalcCntrVO.setFmMvmtDt(chgPartialPaymentVO.getFmMvmtDt());

				/*
				 "L"(Long Staying), "U"(Unfinished), "N"(No Charge) 인  경우, To Date/Yard를 입력하지 않아도 Re-Calculation 가능
					즉, To Date를 초기화한다
				 */
				String chgStsCd = chgCalcCntrVO.getDmdtChgStsCd();
				if( ("L".equals(chgStsCd) || "U".equals(chgStsCd) || "N".equals(chgStsCd))
					&& chgPartialPaymentVO.getToMvmtDt().length() < 12 ) {
					chgCalcCntrVO.setToMvmtDt("");
				} else
					chgCalcCntrVO.setToMvmtDt(chgPartialPaymentVO.getToMvmtDt());

				
				if("N".equals(chgCalcCntrVO.getWebIndFlg()) && "DR".equals(chgCalcCntrVO.getToMvmtStsCd())) {
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
				
				if("Y".equals(chgCalcCntrVO.getDulTpExptFlg())) {
					// Dual Exception Charge중 Combined Charge에 대한 Dual Charge를 조회한다..
					List<ChargeCalculationContainerVO> chgCalcCntrVOs = dbDao.searchDualChargeTariff(chgArgVO);
					
					if(chgCalcCntrVOs != null && chgCalcCntrVOs.size() > 0) {
						resultVO = dualExceptionChargeCalculation("PARTIAL", chgCalcCntrVO, chgCalcCntrVOs, account);
						
						// 오류 발생시 Return
						if(resultVO.getResultCode() != null) {
							return resultVO;
						}
					}
					
//					retChgCalcCntrVO = dmtCombinedChargeCalculationUtil.combinedChargeCalculation(chgCalcParmVO);
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
					if(("Y".equals(chgCalcCntrVO.getCxlBkgChgFlg())) ||
						(("DTOC".equals(chgCalcCntrVO.getDmdtTrfCd()) || "CTOC".equals(chgCalcCntrVO.getDmdtTrfCd()) ) && "OP".equals(chgCalcCntrVO.getFmMvmtStsCd()) && "MT".equals(chgCalcCntrVO.getToMvmtStsCd()))
						) {
						
						// CxlBkgChgFlg = "Y" : 이미 Booking Cancel 되었음을 의미한다. (배치 프로그램.)
						// TRF CD("DTOC", "CTOC") && FM ("OP") && To ("MT") 현재 Booking Canecl인 아니지만, 곧 Cancel 된다고 생각하면 된다.(화면에서 입력된 경우)
						
						dmtCancelChargeCalculationUtil	= new DMTCancelChargeCalculationUtil();
						retChgCalcCntrVO = dmtCancelChargeCalculationUtil.cancelChargeCalculation(chgCalcParmVO);
						
						if("-1".equals(retChgCalcCntrVO.getMsgCd()) || "88".equals(retChgCalcCntrVO.getMsgCd())) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					} else {
						if(!"DR".equals(chgCalcCntrVO.getFmMvmtStsCd())) {
							retChgCalcCntrVO = dmtGeneralChargeCalculationUtil.generalChargeCalculation(chgCalcParmVO);
							
							if("-1".equals(retChgCalcCntrVO.getMsgCd()) || "88".equals(retChgCalcCntrVO.getMsgCd())) {
								resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						} else {
							retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
							
							if("-1".equals(retChgCalcCntrVO.getMsgCd())) {
								resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						}
					}
				}
				
				if(!"0".equals(retChgCalcCntrVO.getMsgCd())) {
					retChgCalcCntrVO.setDmdtChgStsCd("E");
				}
				
				if(!"DR".equals(chgCalcCntrVO.getFmMvmtStsCd())) {
					// [vvd code가 null이면] searchVVDCode( bookingNo) 
					if(chgPartialPaymentVO.getVslCd() == null || chgPartialPaymentVO.getSkdVoyNo() == null
							|| chgPartialPaymentVO.getSkdDirCd() == null) {
						
						String vvdCode = dbDao.searchVVDCode(chgPartialPaymentVO.getBkgNo());
						// YSEA0006E (4:4:1)
						if(!"".equals(vvdCode)) {
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
				
				// ************* DmtChgCalcVO 객체 구성 *****************
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
				//dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt()); 2011.11.15  김현화
				//ToMvmtDt가 없는 경우 원래 Data 유지하도록 함. 2011.12.05  김현화
				String retToMvmtDt = retChgCalcCntrVO.getToMvmtDt();
				
				// nullPointException 발생때문에 수정함. 2012.05.18 김현화				
				if ( retToMvmtDt!= null && !("").equals(retToMvmtDt) ){
					dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
				}else{
					dmtChgCalcVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				}				
				
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
				
				if("I".equals(chgCalcCntrVO.getDmdtChgStsCd()))
					dmtChgCalcVO.setDmdtChgStsCd(chgCalcCntrVO.getDmdtChgStsCd());
				else
					dmtChgCalcVO.setDmdtChgStsCd(retChgCalcCntrVO.getDmdtChgStsCd());
				
				dmtChgCalcVO.setScRfaAmt(retChgCalcCntrVO.getScRfaAmt());
				dmtChgCalcVO.setAftExptAmt(retChgCalcCntrVO.getAftExptAmt());
				dmtChgCalcVO.setBzcTrfSeq(retChgCalcCntrVO.getBzcTrfSeq());
				dmtChgCalcVO.setBzcDmdtDeTermCd(retChgCalcCntrVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
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
				dmtChgCalcVO.setScNo(retChgCalcCntrVO.getScNo());		//2011.01.24. AA 요청
				dmtChgCalcVO.setScExptVerSeq(retChgCalcCntrVO.getScExptVerSeq());
				dmtChgCalcVO.setScExptGrpSeq(retChgCalcCntrVO.getScExptGrpSeq());
				dmtChgCalcVO.setScRfaExptAplyDt(retChgCalcCntrVO.getScRfaExptAplyDt());
				dmtChgCalcVO.setCorrRmk(chgCalcCntrVO.getCorrRmk());
				dmtChgCalcVO.setDmdtInvNo(chgCalcCntrVO.getDmdtInvNo());
				// 화면상의 ofc_cd 유지
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
				dmtChgCalcVO.setUclmFlg(chgCalcCntrVO.getUclmFlg());
				
				dbDao.modifyChargeCalculation(dmtChgCalcVO);
				
				
				// Clock Stop이 하루이상 적용되었으면(cStopNoList.size() > 0) addClockStopHistory 실행
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
				
				
				// ************* chgCalcCntrVO 정보 갱신 *********************
				chgCalcCntrVO.setBkgNo(chgPartialPaymentVO.getBkgNo());
				chgCalcCntrVO.setBlNo(chgPartialPaymentVO.getBlNo());
				chgCalcCntrVO.setActCustSeq(chgPartialPaymentVO.getActCntCd());
				chgCalcCntrVO.setCustCntCd(chgPartialPaymentVO.getCustCntCd());
				chgCalcCntrVO.setDmdtChgStsCd(chgCalcCntrVO.getDmdtChgStsCd());
				chgCalcCntrVO.setFxFtOvrDys(retChgCalcCntrVO.getFxFtOvrDys());
				chgCalcCntrVO.setBzcTrfSeq(retChgCalcCntrVO.getBzcTrfSeq());
				chgCalcCntrVO.setBzcDmdtDeTermCd(retChgCalcCntrVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
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
				
				log.debug("\n[Exception Cost] --------------------------------------------[Start]"  );
				log.debug("\n[Exception Cost] checkScRfaExptApltDt : " + checkScRfaExptApltDt);
				log.debug("\n[Exception Cost] getScRfaExptAplyDt : " + retChgCalcCntrVO.getScRfaExptAplyDt());
				log.debug("\n[Exception Cost] getCntrTpszCd : " + chgCalcParmVO.getCntrTpszCd().substring(0, 1) );
				log.debug("\n[Exception Cost] getDmdtChgStsCd : " + dmtChgCalcVO.getDmdtChgStsCd() );
				log.debug("\n[Exception Cost] getDmdtTrfCd : " + dmtChgCalcVO.getDmdtTrfCd());
				log.debug("\n[Exception Cost] getDulTpExptFlg : " + "Y".equals(dmtChgCalcVO.getDulTpExptFlg()) );
				log.debug("\n[Exception Cost] getChgSeq : " + dmtChgCalcVO.getChgSeq() );
				log.debug("\n[Exception Cost] --------------------------------------------[End]"  );
				
				//Exception Cost를 재계산 로직 추가
				if( (checkScRfaExptApltDt != null || retChgCalcCntrVO.getScRfaExptAplyDt() != null)
				    && ("USA".equals(chgCalcParmVO.getSvrId()) || "EUR".equals(chgCalcParmVO.getSvrId()))
					&& "D".equals(chgCalcParmVO.getCntrTpszCd().substring(0, 1)) //수정
					&& (    "C".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "F".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "I".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "L".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "N".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "U".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "D".equals(dmtChgCalcVO.getDmdtChgStsCd())
					    )
					&& (    "DMIF".equals(dmtChgCalcVO.getDmdtTrfCd())
					     || "DTIC".equals(dmtChgCalcVO.getDmdtTrfCd())
					     || "CTIC".equals(dmtChgCalcVO.getDmdtTrfCd())
					    )							     
					&& !("Y".equals(dmtChgCalcVO.getDulTpExptFlg()) && "D".equals(dmtChgCalcVO.getDmdtTrfCd().substring(0, 1)))  //수정   
					&& ("1".equals(dmtChgCalcVO.getChgSeq()))
				  )
				{
					DMTExceptionChargeCalculationUtil exceptionChargeCalculationUtil = new DMTExceptionChargeCalculationUtil();
					ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();

					chargeCalculationParmVO.setBkgNo(chgCalcParmVO.getBkgNo());
					chargeCalculationParmVO.setSvrId(chgCalcParmVO.getSvrId()); //수정
					chargeCalculationParmVO.setCntrNo(chgCalcParmVO.getCntrNo());
					chargeCalculationParmVO.setCntrCycNo(String.valueOf(chgCalcParmVO.getCntrCycNo()));
					chargeCalculationParmVO.setDmdtTrfCd(chgCalcParmVO.getDmdtTrfCd());
					chargeCalculationParmVO.setDmdtChgLocDivCd(chgCalcParmVO.getDmdtChgLocDivCd());
					chargeCalculationParmVO.setChgSeq(String.valueOf(chgCalcParmVO.getChgSeq()));
					chargeCalculationParmVO.setDmdtChgStsCd(dmtChgCalcVO.getDmdtChgStsCd());
					chargeCalculationParmVO.setFmMvmtDt(chgCalcParmVO.getFmMvmtDt());
					chargeCalculationParmVO.setFmMvmtYdCd(chgCalcParmVO.getFmMvmtYdCd());
					chargeCalculationParmVO.setFmMvmtStsCd(chgCalcParmVO.getFmMvmtStsCd());
					chargeCalculationParmVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
					chargeCalculationParmVO.setToMvmtYdCd(retChgCalcCntrVO.getToMvmtYdCd());
					chargeCalculationParmVO.setToMvmtStsCd(retChgCalcCntrVO.getToMvmtStsCd());
					chargeCalculationParmVO.setDmdtTrfAplyTpCd(retChgCalcCntrVO.getDmdtTrfAplyTpCd());
					chargeCalculationParmVO.setBzcTrfSeq(String.valueOf(retChgCalcCntrVO.getBzcTrfSeq()));
					chargeCalculationParmVO.setBzcDmdtDeTermCd(retChgCalcCntrVO.getBzcDmdtDeTermCd());	// dmdt_de_term_cd
					chargeCalculationParmVO.setBzcTrfGrpSeq(String.valueOf(retChgCalcCntrVO.getBzcTrfGrpSeq()));
					chargeCalculationParmVO.setRfaExptDarNo(retChgCalcCntrVO.getRfaExptDarNo());
					chargeCalculationParmVO.setRfaExptMapgSeq(String.valueOf(retChgCalcCntrVO.getRfaExptMapgSeq()));
					chargeCalculationParmVO.setRfaExptVerSeq(String.valueOf(retChgCalcCntrVO.getRfaExptVerSeq()));
					chargeCalculationParmVO.setRfaRqstDtlSeq(String.valueOf(retChgCalcCntrVO.getRfaRqstDtlSeq()));
					chargeCalculationParmVO.setScNo(retChgCalcCntrVO.getScNo());
					chargeCalculationParmVO.setScExptVerSeq(String.valueOf(retChgCalcCntrVO.getScExptVerSeq()));
					chargeCalculationParmVO.setScExptGrpSeq(String.valueOf(retChgCalcCntrVO.getScExptGrpSeq()));
					chargeCalculationParmVO.setCntrTpszCd(chgCalcParmVO.getCntrTpszCd());
					chargeCalculationParmVO.setIoBndCd(chgCalcParmVO.getIoBndCd());
					chargeCalculationParmVO.setOfcCd(retChgCalcCntrVO.getOfcCd());
					chargeCalculationParmVO.setDulTpExptFlg(chgCalcParmVO.getDulTpExptFlg());
					chargeCalculationParmVO.setCgoTpCd(chgCalcParmVO.getCgoTpCd());

					ExceptionChargeCalculationVO exceptionChargeCalculationVO = null;
					exceptionChargeCalculationVO = exceptionChargeCalculationUtil.exceptionChargeCalculation(chargeCalculationParmVO);

					exceptionChargeCalculationVO.setBkgNo(chgCalcParmVO.getBkgNo());
					exceptionChargeCalculationVO.setCntrNo(chgCalcParmVO.getCntrNo());
					exceptionChargeCalculationVO.setCntrCycNo(String.valueOf(chgCalcParmVO.getCntrCycNo()));
					exceptionChargeCalculationVO.setDmdtTrfCd(chgCalcParmVO.getDmdtTrfCd());
					exceptionChargeCalculationVO.setDmdtChgLocDivCd(chgCalcParmVO.getDmdtChgLocDivCd());
					exceptionChargeCalculationVO.setChgSeq(String.valueOf(chgCalcParmVO.getChgSeq()));
					exceptionChargeCalculationVO.setDmdtChgStsCd(dmtChgCalcVO.getDmdtChgStsCd());
					
					exceptionChargeCalculationVO.setOfcCd(retChgCalcCntrVO.getOfcCd());
					exceptionChargeCalculationVO.setCntrTpszCd(chgCalcParmVO.getCntrTpszCd());
					exceptionChargeCalculationVO.setUpdUsrId(account.getUsr_id());
					exceptionChargeCalculationVO.setUpdOfcCd(account.getOfc_cd());

					dbDao.mergeDmtExceptionChargeCalculation(exceptionChargeCalculationVO);
				}				
				
				// No Charge : Delete All Balances
				// Invoiced Container는 No Charge 일 수 없다.
				if( "N".equals(retChgCalcCntrVO.getDmdtChgStsCd()) ) {
					if(!"".equals(chgCalcCntrVO.getDmdtInvNo())) {
						resultVO.setResultCode("DMT01029");
						return resultVO;
					}
					
					// No Balance Flag를 "Y"로 Setting한다
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
	 * General Charge를 제외한 DR로 생성된 모든 Balance Charge를 삭제한다.<br>
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
			
			// Balance Charge중 Invoice Issued된 Charge가 존재하면, 메시지[DMT01036]를 출력후 오류처리한다.
			boolean chkVal = dbDao.checkChargeInvoiceByDRCancel(chgArgVO);
			
			if(chkVal) {
				return "DMT01036";
			}
			
			// Delete할 대상 Balance Charge의 Charge Sequence List를 조회한다
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
				dmtChgCalcVO.setUclmFlg(chargeCalculationContainerVO.getUclmFlg());
				
				for(int i=0; i < chgSeqList.size(); i++) {
					String chgSeq = chgSeqList.get(i);
					dmtChgCalcVO.setChgSeq(chgSeq);
					
					// Charge Backup Table에 Insert한다.
					dbDao.addChargeBackup(dmtChgCalcVO);
				}
			}
			
			// 모든 Balance Charge를 Delete한다
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
	 * Container Charge 정보를 수정한다.(Save, Web Cancel)<br>
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
			com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			
			// 로직 추가 근거 : CHM-201533804 [DMT] Deletion Setup 화면 개발  2015.02.09    ===========
			// Charge 가 삭제상태이거나, 삭제요청중인 경우, Charge 재계산 대상에서 제외한다.===========
			if (!dbDao.isRecalculationStatus(chargeCalculationContainerVO)) {
				throw new EventException(new ErrorHandler("DMT06043", new String[]{chargeCalculationContainerVO.getCntrNo()}).getMessage());
			}
			//=========================================================================================
			
			String usrId = null;
			String ofcCd = null;
			String toMvmtStsCd = chargeCalculationContainerVO.getToMvmtStsCd();

			if ((account == null) && "CS".equals(toMvmtStsCd) ){
				// account가 null 이라면 외부 (Home Page) 호출에 Clock Stop 이다.
				usrId = "CUP_CLOCK_STOP";
				ofcCd = "CUPHOM";

			} 
			else {
				usrId = account.getUsr_id();
				ofcCd = account.getOfc_cd();
			}

			chargeCalculationContainerVO.setFmMvmtDt(chargeCalculationContainerVO.getFmMvmtDt().replace("-", ""));
			chargeCalculationContainerVO.setFmMvmtDtTime(chargeCalculationContainerVO.getFmMvmtDtTime().replace(":", ""));
			chargeCalculationContainerVO.setToMvmtDt(chargeCalculationContainerVO.getToMvmtDt().replace("-", ""));
			chargeCalculationContainerVO.setToMvmtDtTime(chargeCalculationContainerVO.getToMvmtDtTime().replace(":", ""));

			ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
			chgArgVO.setSvrId(chargeCalculationContainerVO.getSvrId());
			chgArgVO.setCntrNo(chargeCalculationContainerVO.getCntrNo());
			chgArgVO.setCntrCycNo(chargeCalculationContainerVO.getCntrCycNo());
			chgArgVO.setDmdtTrfCd(chargeCalculationContainerVO.getDmdtTrfCd());
			chgArgVO.setDmdtChgLocDivCd(chargeCalculationContainerVO.getDmdtChgLocDivCd());
			chgArgVO.setChgSeq(chargeCalculationContainerVO.getChgSeq());
			chgArgVO.setFmMvmtDt(chargeCalculationContainerVO.getFmMvmtDt());
			chgArgVO.setFmMvmtDtTime(chargeCalculationContainerVO.getFmMvmtDtTime());
			chgArgVO.setToMvmtDt(chargeCalculationContainerVO.getToMvmtDt());
			chgArgVO.setToMvmtDtTime(chargeCalculationContainerVO.getToMvmtDtTime());

			String checkScRfaExptApltDt  = null;
			
			if ("1".equals(chargeCalculationContainerVO.getChgSeq())) {
				ChargeStatusNRemarkVO checkScRfaExptApltDtVO = null;
				ChargeArgumentVO checkArgumentVO = new ChargeArgumentVO();
				
				checkArgumentVO.setSvrId(chargeCalculationContainerVO.getSvrId());
				checkArgumentVO.setCntrNo(chargeCalculationContainerVO.getCntrNo());
				checkArgumentVO.setCntrCycNo(chargeCalculationContainerVO.getCntrCycNo());
				checkArgumentVO.setDmdtTrfCd(chargeCalculationContainerVO.getDmdtTrfCd());
				checkArgumentVO.setDmdtChgLocDivCd(chargeCalculationContainerVO.getDmdtChgLocDivCd());
				checkArgumentVO.setChgSeq(chargeCalculationContainerVO.getChgSeq());
				
				checkScRfaExptApltDtVO = dbDao.searchChargeStatusNRemark(checkArgumentVO);
				checkScRfaExptApltDt = checkScRfaExptApltDtVO.getScRfaExptApltDt();
			}
			
			/*
			- Balance Charge가 없거나, 있으면 마지막 Balance Charge만 D/R Date 저장 가능.
			- Balance Charge가 있는 Charge일 경우  "There is a balance charge!" Alert창  띄우며 오류 처리.
			*/
			String chgMaxSeq = dbDao.searchChargeMaxSequence(chgArgVO);
			
			if(!chargeCalculationContainerVO.getChgSeq().equals(chgMaxSeq)) {
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
		
			//  To Movement Status가 "DR"이나 "CS"인 경우, 현재 일자와 To Date를 비교하여 To Date가 작으면  오류 처리
			// DR Date Checking
			if ("DR".equals(toMvmtStsCd)) {
				//String currDt = DateTime.getDateString().replace(".","");
				// User Office별 현재일자 조회
				String currDt	= dbDao.searchCurrentDateByOffice(ofcCd);
				String toMvmtDt	= chargeCalculationContainerVO.getToMvmtDt();
				
				if(currDt.compareTo(toMvmtDt) > 0) {
					// D/R Date should be same or later than current date
					resultVO.setResultCode("DMT01031");
					return resultVO;
				}
			} 
			else if ("CS".equals(toMvmtStsCd)) {
				// Clock Stop
				String fmMvmtDt = chargeCalculationContainerVO.getFmMvmtDt();
				String toMvmtDt = chargeCalculationContainerVO.getToMvmtDt();
				
				if (fmMvmtDt.compareTo(toMvmtDt) >= 0) {
					// CS date should be later than From date
					resultVO.setResultCode("DMT01004");
					return resultVO;
				}
			}
			
			com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = null;
			chargeArgumentVO = new com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
			chargeArgumentVO.setSvrId(chargeCalculationContainerVO.getSvrId());
			chargeArgumentVO.setCntrNo(chargeCalculationContainerVO.getCntrNo());
			chargeArgumentVO.setCntrCycNo(chargeCalculationContainerVO.getCntrCycNo());
			chargeArgumentVO.setDmdtTrfCd(chargeCalculationContainerVO.getDmdtTrfCd());
			chargeArgumentVO.setDmdtChgLocDivCd(chargeCalculationContainerVO.getDmdtChgLocDivCd());
			chargeArgumentVO.setChgSeq(chargeCalculationContainerVO.getChgSeq());
			
			// 해당 Charge의 Correction History가 존재하는지 Check하여 없으면 Correction History를 Insert한다.
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
			dmtChgCorrHisVO.setCreUsrId(usrId);
			dmtChgCorrHisVO.setCreOfcCd(ofcCd);
			
			if(corrHisSeq == 0) {
				corrHisSeq++;
				dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
				dbDao.addChargeHistory(dmtChgCorrHisVO);
			}
			 
			// ***********  ChargeCalculationUseData  *************
			ChargePartialPaymentVO chgPartialPaymentVO = dbDao.searchChargeCalculationUseData(chgArgVO);
			
			if ("EUR".equals(chargeCalculationContainerVO.getSvrId())) {
				String obCntrFlg = dbDao.searchInOutBoundByMovement(chargeCalculationContainerVO.getCntrNo(), chargeCalculationContainerVO.getCntrCycNo(), chargeCalculationContainerVO.getFmMvmtYdCd());
				//log.debug("============> OB_CNTR_FLG : " + obCntrFlg);
				// 'N' --> 'I'  , 'Y' --> 'O'
				
				// DATA존재시, IN/OUT BOUND 값을 사용한다.
				if (!"".equals(obCntrFlg)) {
					String ioBndCd = "N".equals(obCntrFlg) ? "I" : "O";
					chgPartialPaymentVO.setIoBndCd(ioBndCd);
				}
			}

			/*
			 "L"(Long Staying), "U"(Unfinished), "N"(No Charge) 인  경우, To Date/Yard를 입력하지 않아도 Re-Calculation 가능
			    즉, To Date를 초기화한다
			 */
			//String chgStsCd = chargeCalculationContainerVO.getDmdtChgStsCd();
			chargeCalculationContainerVO.setFmMvmtDt(chgPartialPaymentVO.getFmMvmtDt());
			if ( //(chgStsCd.equals("L") || chgStsCd.equals("U") || chgStsCd.equals("N")) && 
				chgPartialPaymentVO.getToMvmtDt().length() < 12 ) {
				chargeCalculationContainerVO.setToMvmtDt("");
			} 
			else
				chargeCalculationContainerVO.setToMvmtDt(chgPartialPaymentVO.getToMvmtDt());
			
			// MT Notification된 Data의 경우(To Movement="DR"이고 Web Indicator="Y"), Web Indicator를 "N"으로 Update한다.
			if (("Y".equals(chargeCalculationContainerVO.getWebIndFlg()) && 
			    "DR".equals(chargeCalculationContainerVO.getToMvmtStsCd())) ||
			    ( "Y".equals(chargeCalculationContainerVO.getWebCancelFlg()) ) ) {   // <--- Web Cancel 실행시 체크 조건
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
			
			if ("Y".equals(chargeCalculationContainerVO.getDulTpExptFlg())) {
				// Dual Exception Charge중 Combined Charge에 대한 Dual Charge를 조회한다..
				List<ChargeCalculationContainerVO> chgCalcCntrVOs = dbDao.searchDualChargeTariff(chgArgVO);

				if (chgCalcCntrVOs != null && chgCalcCntrVOs.size() > 0) {
					String callFlag = null;
					if ("Y".equals(chargeCalculationContainerVO.getWebCancelFlg())) {
						callFlag = "WEBCANCEL";
					} 
					else {
						callFlag = "SAVE";
					}
					
					chgArgVO.setCallFlag(callFlag);
					resultVO = dualExceptionChargeCalculation(callFlag, chargeCalculationContainerVO, chgCalcCntrVOs, account);
					
					// 오류 발생시 Return
					if (resultVO.getResultCode() != null) {
						return resultVO;
					}
				}

				dmtCombinedChargeCalculationUtil = new DMTCombinedChargeCalculationUtil();
				//2011.04.29. 추가 ("DR"일때 아닐때 구분)
				if (!("DR".equals(chargeCalculationContainerVO.getFmMvmtStsCd()))) {
					retChgCalcCntrVO = dmtCombinedChargeCalculationUtil.combinedChargeCalculation(chgCalcParmVO);
					if("-1".equals(retChgCalcCntrVO.getMsgCd()) || "88".equals(retChgCalcCntrVO.getMsgCd())) {
						log.error("\n\n combinedChargeCalculation ERROR [Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
						resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
						resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
						return resultVO;
					}
				} 
				else {
					dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
					retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
					
					if (("-1").equals(retChgCalcCntrVO.getMsgCd())) {
						log.error("\n\n[DMT02036][Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
						resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
						resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
						return resultVO;
					}
				}				
			} 
			else {

				//=================================================================================
				// CSR #XXXX OC-MT Calculation 처리 2018.02.28 by jameskai (시작)
				//=================================================================================
				/*-----------------------------------------------------------
				    [ 실행 CASE ]
				 	1. Cancel Booking 인 경우
				 	2. OP - MT 인 경우
				 	3. OC - MT 인 경우 (신규 추가됨)
				 ------------------------------------------------------------*/
				String cxlBkg = chargeCalculationContainerVO.getCxlBkgChgFlg();
				String trfCd  = chargeCalculationContainerVO.getDmdtTrfCd();
				String fmSts  = chargeCalculationContainerVO.getFmMvmtStsCd();
				String toSts  = chargeCalculationContainerVO.getToMvmtStsCd();
				
				if ("Y".equals(cxlBkg) || (trfCd.indexOf("O") != -1 && "OP".equals(fmSts) && "MT".equals(toSts)) || ("DMOF".equals(trfCd) && "OC".equals(fmSts) && "MT".equals(toSts))) {
				
				//if ((("Y").equals(chargeCalculationContainerVO.getCxlBkgChgFlg())) ||
				//	(("DTOC".equals(chargeCalculationContainerVO.getDmdtTrfCd()) || "CTOC".equals(chargeCalculationContainerVO.getDmdtTrfCd())) &&  "OP".equals(chargeCalculationContainerVO.getFmMvmtStsCd()) &&  "MT".equals(chargeCalculationContainerVO.getToMvmtStsCd()))
				//	) {
					
					// CxlBkgChgFlg = "Y" : 이미 Booking Cancel 되었음을 의미한다. (배치 프로그램.)
					// TRF CD("DTOC", "CTOC") && FM ("OP") && To ("MT") 현재 Booking Cancel인 아니지만, 곧 Cancel 된다고 생각하면 된다.(화면에서 입력된 경우)
					
					dmtCancelChargeCalculationUtil	= new DMTCancelChargeCalculationUtil();
					retChgCalcCntrVO = dmtCancelChargeCalculationUtil.cancelChargeCalculation(chgCalcParmVO);
					
					if("-1".equals(retChgCalcCntrVO.getMsgCd()) || "88".equals(retChgCalcCntrVO.getMsgCd())) {
						resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
						resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
						return resultVO;
					}
				} 
				//=================================================================================
				// CSR #XXXX OC-MT Calculation 처리 2018.02.28 by jameskai (종료)
				//=================================================================================				
				else {
					// From Movement Status가 "DR"이 아니면 General Charge를 계산하고, "DR"이면 Balance Charge를 계산한다
					if (!"DR".equals(chargeCalculationContainerVO.getFmMvmtStsCd())) {
						dmtGeneralChargeCalculationUtil = new DMTGeneralChargeCalculationUtil();
						retChgCalcCntrVO = dmtGeneralChargeCalculationUtil.generalChargeCalculation(chgCalcParmVO);
						
						if ("-1".equals(retChgCalcCntrVO.getMsgCd()) || "88".equals(retChgCalcCntrVO.getMsgCd())) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					} 
					else {
						dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
						retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
						if ("-1".equals(retChgCalcCntrVO.getMsgCd())) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					}
				}
			}

			// 위에서 계산한 Operation의 Return값이 0이 아니면 Charge Status를 "E"(Error)로 Setting한다
			if (!"0".equals(retChgCalcCntrVO.getMsgCd())) {
				retChgCalcCntrVO.setDmdtChgStsCd("E");
				chargeCalculationContainerVO.setCorrRmk(chargeCalculationContainerVO.getCorrRmk() + " " + retChgCalcCntrVO.getMsgDesc());
			}
			
			// From Movement Status가 "DR"이 아니면 General Charge를 계산하고 Parameter로 받은 Data중 BKG CNTR관련 Data를 BKG CNTR Table에 Data를   Update한다. 
			// 단 Parameter로 받은 Data중 VVD Code가 Null이면 Booking의 Trunk VVD를 조회한다.
			if (!"DR".equals(chargeCalculationContainerVO.getFmMvmtStsCd())) {
				// [vvd code가 null이면] searchVVDCode( bookingNo) 
				if (chgPartialPaymentVO.getVslCd() == null || chgPartialPaymentVO.getSkdVoyNo() == null
						|| chgPartialPaymentVO.getSkdDirCd() == null) {
					
					String vvdCode = dbDao.searchVVDCode(chgPartialPaymentVO.getBkgNo());
					// YSEA0006E (4:4:1)
					if (!"".equals(vvdCode)) {
						chgPartialPaymentVO.setVslCd(vvdCode.substring(0, 4));
						chgPartialPaymentVO.setSkdVoyNo(vvdCode.substring(4, 8));
						chgPartialPaymentVO.setSkdDirCd(vvdCode.substring(8));
					}
				}

				// ------------ DmtChgBkgCntrVO 객체 구성 -----------------
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
				dmtChgBkgCntrVO.setUpdUsrId(usrId);
				dmtChgBkgCntrVO.setUpdOfcCd(ofcCd);
				
				dbDao.modifyBookingContainer(dmtChgBkgCntrVO);
			}
			
			// 11. 해당 Charge가 Office Transfer 된 Charge면 변경된 Office와 RHQ를 Charge의 Office와 RHQ로 설정하고 아니면 계산시 설정된 Office와 RHQ를 저장한다
			// ************* DmtChgCalcVO 객체 구성 *****************
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
			//dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt()); 2011.11.15  김현화
			//ToMvmtDt가 없는 경우 원래 Data 유지하도록 함. 2011.12.05  김현화
			String retToMvmtDt = retChgCalcCntrVO.getToMvmtDt();
			// nullPointException 발생때문에 수정함. 2012.05.18 김현화				
			if (retToMvmtDt!= null && !("").equals(retToMvmtDt)) {
				dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
			} 
			else {
				dmtChgCalcVO.setToMvmtDt(chargeCalculationContainerVO.getToMvmtDt());
			}
			
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
			dmtChgCalcVO.setBzcDmdtDeTermCd(retChgCalcCntrVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
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
			dmtChgCalcVO.setCorrRmk(chargeCalculationContainerVO.getCorrRmk());
			
			dmtChgCalcVO.setOfcCd(chargeCalculationContainerVO.getOfcCd());
			dmtChgCalcVO.setOfcRhqCd(chargeCalculationContainerVO.getOfcRhqCd());
			dmtChgCalcVO.setUpdUsrId(usrId);
			dmtChgCalcVO.setUpdOfcCd(ofcCd);
			dmtChgCalcVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
			dmtChgCalcVO.setCmdtTrfSeq(retChgCalcCntrVO.getCmdtTrfSeq());
			dmtChgCalcVO.setCmdtExptAplyDt(retChgCalcCntrVO.getCmdtExptAplyDt());
			dmtChgCalcVO.setCmdtOvrDys(retChgCalcCntrVO.getCmdtOvrDys());
			dmtChgCalcVO.setCmdtExptAmt(retChgCalcCntrVO.getCmdtExptAmt());
			dmtChgCalcVO.setWebMtyDt(chargeCalculationContainerVO.getWebMtyDt().replace("-", ""));
			dmtChgCalcVO.setUclmFlg(chargeCalculationContainerVO.getUclmFlg()); //2013.09.06. 현업요청

			// 12. 계산된 Cahrge를 Charge Master Table에 Update한다
			dbDao.modifyChargeCalculation(dmtChgCalcVO);
			
			if ("Y".equals(chargeCalculationContainerVO.getDulTpExptFlg())) {
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
			
			if (cStopNoList != null && cStopNoList.size() > 0) {
				DmtChgTmCskStopVO dmtChgTmCskStopVO = new DmtChgTmCskStopVO();
				dmtChgTmCskStopVO.setSvrId(chargeCalculationContainerVO.getSvrId());
				dmtChgTmCskStopVO.setCntrNo(chargeCalculationContainerVO.getCntrNo());
				dmtChgTmCskStopVO.setCntrCycNo(chargeCalculationContainerVO.getCntrCycNo());
				dmtChgTmCskStopVO.setDmdtTrfCd(chargeCalculationContainerVO.getDmdtTrfCd());
				dmtChgTmCskStopVO.setDmdtChgLocDivCd(chargeCalculationContainerVO.getDmdtChgLocDivCd());
				dmtChgTmCskStopVO.setChgSeq(chargeCalculationContainerVO.getChgSeq());
				dmtChgTmCskStopVO.setCreOfcCd(ofcCd);
				
				modifyClockStopHistory(dmtChgTmCskStopVO, cStopNoList);
			}

			//14. Correction History를 Insert한다
			corrHisSeq++;
			dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
			dbDao.addChargeHistory(dmtChgCorrHisVO);
		
			ChargeCalculationContainerVO[] chargeResultVOs = new ChargeCalculationContainerVO[1];
			ChargeCalculationContainerVO chargeResultVO = chargeCalculationContainerVO;
			chargeResultVO.setFtEndDt(dmtChgCalcVO.getFtEndDt());
			chargeResultVO.setDmdtTrfCd(dmtChgCalcVO.getDmdtTrfCd()); //2012.01.26 EDO 전송check 용
			chargeResultVO.setDulTpExptFlg(chargeCalculationContainerVO.getDulTpExptFlg()); //2012.01.26 EDO 전송check 용

			log.debug("\n[Exception Cost] --------------------------------------------[Start]"  );
			log.debug("\n[Exception Cost] checkScRfaExptApltDt : " + checkScRfaExptApltDt);
			log.debug("\n[Exception Cost] getScRfaExptAplyDt : " + retChgCalcCntrVO.getScRfaExptAplyDt());
			log.debug("\n[Exception Cost] getCntrTpszCd : " + chgCalcParmVO.getCntrTpszCd().substring(0, 1) );
			log.debug("\n[Exception Cost] getDmdtChgStsCd : " + dmtChgCalcVO.getDmdtChgStsCd() );
			log.debug("\n[Exception Cost] getDmdtTrfCd : " + dmtChgCalcVO.getDmdtTrfCd());
			log.debug("\n[Exception Cost] getDulTpExptFlg : " + "Y".equals(dmtChgCalcVO.getDulTpExptFlg()));
			log.debug("\n[Exception Cost] getChgSeq : " + dmtChgCalcVO.getChgSeq() );
			log.debug("\n[Exception Cost] --------------------------------------------[End]"  );
			
			//Exception Cost를 재계산 로직 추가
			if ((checkScRfaExptApltDt != null || retChgCalcCntrVO.getScRfaExptAplyDt() != null)
				&& ("USA".equals(chgCalcParmVO.getSvrId()) || "EUR".equals(chgCalcParmVO.getSvrId()))
				&& "D".equals(chgCalcParmVO.getCntrTpszCd().substring(0, 1)) //수정
				&& (    "C".equals(dmtChgCalcVO.getDmdtChgStsCd())
				     || "F".equals(dmtChgCalcVO.getDmdtChgStsCd())
				     || "I".equals(dmtChgCalcVO.getDmdtChgStsCd())
				     || "L".equals(dmtChgCalcVO.getDmdtChgStsCd())
				     || "N".equals(dmtChgCalcVO.getDmdtChgStsCd())
				     || "U".equals(dmtChgCalcVO.getDmdtChgStsCd())
				     || "D".equals(dmtChgCalcVO.getDmdtChgStsCd())
				    )
				&& (    "DMIF".equals(dmtChgCalcVO.getDmdtTrfCd())
				     || "DTIC".equals(dmtChgCalcVO.getDmdtTrfCd())
				     || "CTIC".equals(dmtChgCalcVO.getDmdtTrfCd())
				    )							     
				&& !("Y".equals(dmtChgCalcVO.getDulTpExptFlg()) && "D".equals(dmtChgCalcVO.getDmdtTrfCd().substring(0, 1)))  //수정   
				&& ("1".equals(dmtChgCalcVO.getChgSeq()))
			  )
			{

				DMTExceptionChargeCalculationUtil exceptionChargeCalculationUtil = new DMTExceptionChargeCalculationUtil();
				ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();

				chargeCalculationParmVO.setBkgNo(chgCalcParmVO.getBkgNo());
				chargeCalculationParmVO.setSvrId(chgCalcParmVO.getSvrId()); //수정
				chargeCalculationParmVO.setCntrNo(chgCalcParmVO.getCntrNo());
				chargeCalculationParmVO.setCntrCycNo(String.valueOf(chgCalcParmVO.getCntrCycNo()));
				chargeCalculationParmVO.setDmdtTrfCd(chgCalcParmVO.getDmdtTrfCd());
				chargeCalculationParmVO.setDmdtChgLocDivCd(chgCalcParmVO.getDmdtChgLocDivCd());
				chargeCalculationParmVO.setChgSeq(String.valueOf(chgCalcParmVO.getChgSeq()));
				chargeCalculationParmVO.setDmdtChgStsCd(dmtChgCalcVO.getDmdtChgStsCd());
				chargeCalculationParmVO.setFmMvmtDt(chgCalcParmVO.getFmMvmtDt());
				chargeCalculationParmVO.setFmMvmtYdCd(chgCalcParmVO.getFmMvmtYdCd());
				chargeCalculationParmVO.setFmMvmtStsCd(chgCalcParmVO.getFmMvmtStsCd());
				chargeCalculationParmVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
				chargeCalculationParmVO.setToMvmtYdCd(retChgCalcCntrVO.getToMvmtYdCd());
				chargeCalculationParmVO.setToMvmtStsCd(retChgCalcCntrVO.getToMvmtStsCd());
				chargeCalculationParmVO.setDmdtTrfAplyTpCd(retChgCalcCntrVO.getDmdtTrfAplyTpCd());
				chargeCalculationParmVO.setBzcTrfSeq(String.valueOf(retChgCalcCntrVO.getBzcTrfSeq()));
				chargeCalculationParmVO.setBzcDmdtDeTermCd(retChgCalcCntrVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
				chargeCalculationParmVO.setBzcTrfGrpSeq(String.valueOf(retChgCalcCntrVO.getBzcTrfGrpSeq()));
				chargeCalculationParmVO.setRfaExptDarNo(retChgCalcCntrVO.getRfaExptDarNo());
				chargeCalculationParmVO.setRfaExptMapgSeq(String.valueOf(retChgCalcCntrVO.getRfaExptMapgSeq()));
				chargeCalculationParmVO.setRfaExptVerSeq(String.valueOf(retChgCalcCntrVO.getRfaExptVerSeq()));
				chargeCalculationParmVO.setRfaRqstDtlSeq(String.valueOf(retChgCalcCntrVO.getRfaRqstDtlSeq()));
				chargeCalculationParmVO.setScNo(retChgCalcCntrVO.getScNo());
				chargeCalculationParmVO.setScExptVerSeq(String.valueOf(retChgCalcCntrVO.getScExptVerSeq()));
				chargeCalculationParmVO.setScExptGrpSeq(String.valueOf(retChgCalcCntrVO.getScExptGrpSeq()));
				chargeCalculationParmVO.setCntrTpszCd(chgCalcParmVO.getCntrTpszCd());
				chargeCalculationParmVO.setIoBndCd(chgCalcParmVO.getIoBndCd());
				chargeCalculationParmVO.setOfcCd(retChgCalcCntrVO.getOfcCd());
				chargeCalculationParmVO.setDulTpExptFlg(chgCalcParmVO.getDulTpExptFlg());
				chargeCalculationParmVO.setCgoTpCd(chgCalcParmVO.getCgoTpCd());

				ExceptionChargeCalculationVO exceptionChargeCalculationVO = null;
				exceptionChargeCalculationVO = exceptionChargeCalculationUtil.exceptionChargeCalculation(chargeCalculationParmVO);

				exceptionChargeCalculationVO.setBkgNo(chgCalcParmVO.getBkgNo());
				exceptionChargeCalculationVO.setCntrNo(chgCalcParmVO.getCntrNo());
				exceptionChargeCalculationVO.setCntrCycNo(String.valueOf(chgCalcParmVO.getCntrCycNo()));
				exceptionChargeCalculationVO.setDmdtTrfCd(chgCalcParmVO.getDmdtTrfCd());
				exceptionChargeCalculationVO.setDmdtChgLocDivCd(chgCalcParmVO.getDmdtChgLocDivCd());
				exceptionChargeCalculationVO.setChgSeq(String.valueOf(chgCalcParmVO.getChgSeq()));
				exceptionChargeCalculationVO.setDmdtChgStsCd(dmtChgCalcVO.getDmdtChgStsCd());
				
				exceptionChargeCalculationVO.setOfcCd(retChgCalcCntrVO.getOfcCd());
				exceptionChargeCalculationVO.setCntrTpszCd(chgCalcParmVO.getCntrTpszCd());
				exceptionChargeCalculationVO.setUpdUsrId(usrId);
				exceptionChargeCalculationVO.setUpdOfcCd(ofcCd);

				dbDao.mergeDmtExceptionChargeCalculation(exceptionChargeCalculationVO);
			}
			
			chargeResultVOs[0] = chargeResultVO;
			resultVO.setChargeCalculationContainerVOArray(chargeResultVOs);

			return resultVO;
			
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify Charge by Container"}).getMessage());
		}
		catch (EventException ex) {
			log.error("[EventException]"+ex.getMessage());
			throw ex;
		}		
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify Charge by Container"}).getMessage());
		}
	}
	
	
	/**
	 * POD ETA 날짜를 조회한다.<br>
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
	 * Container별 VD Movement Date를 조회한다.<br>
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
	 * Batch로 생성되지 않은 Charge를 미리 Manual로 생성한다.<br>
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
			com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			
			DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
			ChargeCalculationContainerVO[] chargeResultVOs = chargeCalculationContainerVOs; //2011.12.22 추가
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
				
				String custCntCd = null;
				String custSeq = null;
				
				if( "".equals(chgCalcCntrVO.getCneeCd()) && !"".equals(chgCalcCntrVO.getNtfyCd()) ) {
					custCntCd = chgCalcCntrVO.getNtfyCd().substring(0, 2);
					custSeq = chgCalcCntrVO.getNtfyCd().substring(2);
				} else if(!"".equals(chgCalcCntrVO.getCneeCd())) {
					custCntCd = chgCalcCntrVO.getCneeCd().substring(0, 2);
					custSeq = chgCalcCntrVO.getCneeCd().substring(2);
				}
				
				custSeq = String.valueOf(NumberUtils.toInt(custSeq, 0));
				chgCalcParmVO.setCustCntCd(custCntCd);
				chgCalcParmVO.setCustSeq(custSeq);
				
				String actCustCd = chgCalcCntrVO.getArActCd();
				if(!"".equals(actCustCd)) {
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
				
				if("-1".equals(retChgCalcCntrVO.getMsgCd()) || "88".equals(retChgCalcCntrVO.getMsgCd())) {
					resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
					resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
					return resultVO;
				}
				
				// 2010.11.19 수정 (해당 Charge Booking Container 정보 존재하는지 체크, 있으면 update 없으면 insert)
				ChargeArgumentVO chkChgArgVO = new ChargeArgumentVO();
				chkChgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
				chkChgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chkChgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				
				boolean chkExists = dbDao.checkChargeBookingContainerExists(chkChgArgVO);
				
				// 해당 Charge Booking Container 정보가 있으면 Update
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
					// 해당 Charge Booking Container 정보가 없으면 추가
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
					
					// DMT_CHG_BKG_CNTR 테이블에  Data를  Insert 한다.
					dbDao.addBkgCntr(dmtChgBkgCntrVO);
				} // if - end
				
				// add Charge (DMT_CHG_CALC 테이블에 Insert)
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
				dmtChgCalcVO.setBzcDmdtDeTermCd(retChgCalcCntrVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
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
				
				// DMT_CHG_CALC 테이블에  Insert 처리
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
				chargeResultVOs[i].setFtEndDt(dmtChgCalcVO.getFtEndDt()); //2011.12.22 추가
				chargeResultVOs[i].setChgSeq(dmtChgCalcVO.getChgSeq());   //2012.01.12 추가-EDO 전송시  필요.
				chargeResultVOs[i].setDmdtTrfCd(dmtChgCalcVO.getDmdtTrfCd());   //2012.01.26 추가-EDO 전송시  필요.
				chargeResultVOs[i].setDulTpExptFlg(dmtChgCalcVO.getDulTpExptFlg());   //2012.01.30 추가-EDO 전송시  필요.
				
				log.debug("\n[Exception Cost] --------------------------------------------[Start]"  );
				log.debug("\n[Exception Cost] getScRfaExptAplyDt : " + retChgCalcCntrVO.getScRfaExptAplyDt());
				log.debug("\n[Exception Cost] getCntrTpszCd : " + chgCalcParmVO.getCntrTpszCd().substring(0, 1) );
				log.debug("\n[Exception Cost] getDmdtChgStsCd : " + dmtChgCalcVO.getDmdtChgStsCd() );
				log.debug("\n[Exception Cost] getDmdtTrfCd : " + dmtChgCalcVO.getDmdtTrfCd());
				log.debug("\n[Exception Cost] getDulTpExptFlg : " + "Y".equals(dmtChgCalcVO.getDulTpExptFlg()) );
				log.debug("\n[Exception Cost] getChgSeq : " + dmtChgCalcVO.getChgSeq() );
				log.debug("\n[Exception Cost] --------------------------------------------[End]"  );
				
				//Exception Cost를 재계산 로직 추가
				if( ( retChgCalcCntrVO.getScRfaExptAplyDt() != null )
					&& ("USA".equals(chgCalcParmVO.getSvrId()) || "EUR".equals(chgCalcParmVO.getSvrId()))
					&& "D".equals(chgCalcParmVO.getCntrTpszCd().substring(0, 1)) //수정
					&& ( "C".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "F".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "I".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "L".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "N".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "U".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "D".equals(dmtChgCalcVO.getDmdtChgStsCd())
					    )
					&& (    "DMIF".equals(dmtChgCalcVO.getDmdtTrfCd())
					     || "DTIC".equals(dmtChgCalcVO.getDmdtTrfCd())
					     || "CTIC".equals(dmtChgCalcVO.getDmdtTrfCd())
					    )							     
					&& !("Y".equals(dmtChgCalcVO.getDulTpExptFlg()) && "D".equals(dmtChgCalcVO.getDmdtTrfCd().substring(0, 1)))  //수정   
					&& ("1".equals(dmtChgCalcVO.getChgSeq()))
				  )
				{
					DMTExceptionChargeCalculationUtil exceptionChargeCalculationUtil = new DMTExceptionChargeCalculationUtil();
					ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();

					chargeCalculationParmVO.setBkgNo(chgCalcParmVO.getBkgNo());
					chargeCalculationParmVO.setSvrId(chgCalcParmVO.getSvrId()); //수정
					chargeCalculationParmVO.setCntrNo(chgCalcParmVO.getCntrNo());
					chargeCalculationParmVO.setCntrCycNo(String.valueOf(chgCalcParmVO.getCntrCycNo()));
					chargeCalculationParmVO.setDmdtTrfCd(chgCalcParmVO.getDmdtTrfCd());
					chargeCalculationParmVO.setDmdtChgLocDivCd(chgCalcParmVO.getDmdtChgLocDivCd());
					chargeCalculationParmVO.setChgSeq(String.valueOf(chgCalcParmVO.getChgSeq()));
					chargeCalculationParmVO.setDmdtChgStsCd(dmtChgCalcVO.getDmdtChgStsCd());
					chargeCalculationParmVO.setFmMvmtDt(chgCalcParmVO.getFmMvmtDt());
					chargeCalculationParmVO.setFmMvmtYdCd(chgCalcParmVO.getFmMvmtYdCd());
					chargeCalculationParmVO.setFmMvmtStsCd(chgCalcParmVO.getFmMvmtStsCd());
					chargeCalculationParmVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
					chargeCalculationParmVO.setToMvmtYdCd(retChgCalcCntrVO.getToMvmtYdCd());
					chargeCalculationParmVO.setToMvmtStsCd(retChgCalcCntrVO.getToMvmtStsCd());
					chargeCalculationParmVO.setDmdtTrfAplyTpCd(retChgCalcCntrVO.getDmdtTrfAplyTpCd());
					chargeCalculationParmVO.setBzcTrfSeq(String.valueOf(retChgCalcCntrVO.getBzcTrfSeq()));
					chargeCalculationParmVO.setBzcDmdtDeTermCd(retChgCalcCntrVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
					chargeCalculationParmVO.setBzcTrfGrpSeq(String.valueOf(retChgCalcCntrVO.getBzcTrfGrpSeq()));
					chargeCalculationParmVO.setRfaExptDarNo(retChgCalcCntrVO.getRfaExptDarNo());
					chargeCalculationParmVO.setRfaExptMapgSeq(String.valueOf(retChgCalcCntrVO.getRfaExptMapgSeq()));
					chargeCalculationParmVO.setRfaExptVerSeq(String.valueOf(retChgCalcCntrVO.getRfaExptVerSeq()));
					chargeCalculationParmVO.setRfaRqstDtlSeq(String.valueOf(retChgCalcCntrVO.getRfaRqstDtlSeq()));
					chargeCalculationParmVO.setScNo(retChgCalcCntrVO.getScNo());
					chargeCalculationParmVO.setScExptVerSeq(String.valueOf(retChgCalcCntrVO.getScExptVerSeq()));
					chargeCalculationParmVO.setScExptGrpSeq(String.valueOf(retChgCalcCntrVO.getScExptGrpSeq()));
					chargeCalculationParmVO.setCntrTpszCd(chgCalcParmVO.getCntrTpszCd());
					chargeCalculationParmVO.setIoBndCd(chgCalcParmVO.getIoBndCd());
					chargeCalculationParmVO.setOfcCd(retChgCalcCntrVO.getOfcCd());
					chargeCalculationParmVO.setDulTpExptFlg(chgCalcParmVO.getDulTpExptFlg());
					chargeCalculationParmVO.setCgoTpCd(chgCalcParmVO.getCgoTpCd());

					ExceptionChargeCalculationVO exceptionChargeCalculationVO = null;
					exceptionChargeCalculationVO = exceptionChargeCalculationUtil.exceptionChargeCalculation(chargeCalculationParmVO);

					exceptionChargeCalculationVO.setBkgNo(chgCalcParmVO.getBkgNo());
					exceptionChargeCalculationVO.setCntrNo(chgCalcParmVO.getCntrNo());
					exceptionChargeCalculationVO.setCntrCycNo(String.valueOf(chgCalcParmVO.getCntrCycNo()));
					exceptionChargeCalculationVO.setDmdtTrfCd(chgCalcParmVO.getDmdtTrfCd());
					exceptionChargeCalculationVO.setDmdtChgLocDivCd(chgCalcParmVO.getDmdtChgLocDivCd());
					exceptionChargeCalculationVO.setChgSeq(String.valueOf(chgCalcParmVO.getChgSeq()));
					exceptionChargeCalculationVO.setDmdtChgStsCd(dmtChgCalcVO.getDmdtChgStsCd());
					
					exceptionChargeCalculationVO.setOfcCd(retChgCalcCntrVO.getOfcCd());
					exceptionChargeCalculationVO.setCntrTpszCd(chgCalcParmVO.getCntrTpszCd());
					exceptionChargeCalculationVO.setUpdUsrId(account.getUsr_id());
					exceptionChargeCalculationVO.setUpdOfcCd(account.getOfc_cd());

					dbDao.mergeDmtExceptionChargeCalculation(exceptionChargeCalculationVO);
				}				
			} // for - end
			
			resultVO.setChargeCalculationContainerVOArray(chargeResultVOs); //2011.12.22 추가
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
	 * CHARGE HISTORY를 저장한다.<br>
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
    			com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO closingChargeArgumentVO = new com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO();
                closingChargeArgumentVO.setSvrId(invoiceIssueParam.getSvrId());
                closingChargeArgumentVO.setCntrNo(invoiceIssueParam.getCntrNo());
                closingChargeArgumentVO.setCntrCycNo(invoiceIssueParam.getCntrCycNo());
                closingChargeArgumentVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
                closingChargeArgumentVO.setDmdtChgLocDivCd(invoiceIssueParam.getDmdtChgLocDivCd());
                closingChargeArgumentVO.setChgSeq(invoiceIssueParam.getChgSeq());
                closingChargeArgumentVO.setTruckerCd(chargeBookinInvoiceVO.getTruckerCd());
                
                log.debug("\n trunck_cd ==>"+chargeBookinInvoiceVO.getTruckerCd());
 				
                dbDao.modifyChargeTruckerByInvoice(closingChargeArgumentVO, account.getUsr_id(), account.getOfc_cd());

    			//체크를 하게 되면 Invoice 상태로 UPDATE한다. 
    			if("U".equals(invoiceIssueParam.getIbflag())){
	    			com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = new com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
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
					
					closingChargeArgumentVO = new com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO();
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
	 * 해당 Container Charge에 적용된 Basic 및 Exception Tariff와 Clock Stop 등의 계산 내역을 조회한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return ChargeCalculationDetailVO
	 * @exception EventException
	 */
	public ChargeCalculationDetailVO searchChargeDetail(ChargeArgumentVO chargeArgumentVO) throws EventException {
		try {
			ChargeCalculationDetailVO chgCalcDtlVO = new ChargeCalculationDetailVO();
			
			// Charge의 Amount 정보들을 조회한다
			ChargeDetailVO chgDtlVO = dbDao.chargeDetail(chargeArgumentVO);
			chgCalcDtlVO.setChargeDetailVO(chgDtlVO);
			
			
			CalculationAMTVO calculationAMTVO = null;
			List<ChrgDtlVO> list = null;
				
			// basicFreeTime(String z_svr_id, String z_dtt_code, long z_dtn_seq, long z_dtg_grp_id, long z_dbc_bkg_qty) BKG_CNTR_QTY
			String dmdtTrfCd	= chargeArgumentVO.getDmdtTrfCd();
			long bzcTrfSeq		= NumberUtils.toLong(chgDtlVO.getBzcTrfSeq(), 0);
			String bzcDmdtDeTermCd	= chgDtlVO.getBzcDmdtDeTermCd();
			long bzcTrfGrpSeq	= NumberUtils.toLong(chgDtlVO.getBzcTrfGrpSeq(), 0);
			long bkgCntrQty		= NumberUtils.toLong(chgDtlVO.getBkgCntrQty(), 0);
			
			
			// O/T된 건일 경우, 최초의 SVR_ID를 가져온다. (Basic Tariff의 주말, 공휴일 포함 여부를 조회한다)
			String firstSvrID = null;
			
			if("Y".equals(chgDtlVO.getOfcTrnsFlg())) {
				ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
				chargeCalculationParmVO.setBkgNo(chargeArgumentVO.getBkgNo());
				chargeCalculationParmVO.setCntrNo(chargeArgumentVO.getCntrNo());
				chargeCalculationParmVO.setCntrCycNo(chargeArgumentVO.getCntrCycNo());
				chargeCalculationParmVO.setDmdtTrfCd(chargeArgumentVO.getDmdtTrfCd());
				chargeCalculationParmVO.setDmdtChgLocDivCd(chargeArgumentVO.getDmdtChgLocDivCd());
				chargeCalculationParmVO.setFmMvmtYdCd(chgDtlVO.getFmMvmtYdCd()); //2011.10.28
				
				//log.debug("searchChargeDetail  FmMvmtYdCd == "+chargeCalculationParmVO.getFmMvmtYdCd());
				firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
			} else {
				firstSvrID = chargeArgumentVO.getSvrId();
			}
			
			long bzcFreeTime	= dmtCalculationUtil.basicFreeTime(firstSvrID, dmdtTrfCd, bzcTrfSeq, bzcDmdtDeTermCd, bzcTrfGrpSeq, bkgCntrQty);
			
			if("TSP".equals(chargeArgumentVO.getDmdtChgLocDivCd())) {
				/*
				 * 2010.11.01 T/S Demurrage Free Time 변경
				 * 1) locCd: DEBRE, DEHAM --> bzcFreeTime = 7;
				 * 2) locCd: NLRTM, BEANR --> 
				 * 							  fm_mvmt_dt <=  2010/10/09 --> bzcFreeTime = 7
				 * 							  fm_mvmt_dt >   2010/10/09 --> bzcFreeTime = 10
				 */
				String locCd = chargeArgumentVO.getFmMvmtYdCd().substring(0, 5);
				
				if("DEBRE".equals(locCd) || "DEHAM".equals(locCd)) {
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
			bzcTrfParmVO.setDmdtDeTermCd(chgDtlVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
			bzcTrfParmVO.setTrfGrpSeq(chgDtlVO.getBzcTrfGrpSeq());
			
			// Currency Code, Coverage Code 조회
			BasicCurrencyCoverageVO basicCurrencyCoverageVO = dbDao.searchBasicCurrencyCoverage(bzcTrfParmVO);
			
			if (basicCurrencyCoverageVO == null) {
				throw new EventException (new ErrorHandler("DMT06022").getMessage());
			}
			
			// ********** DivOverDay 조회
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
			calculationParmVO.setDmdtDeTermCd(chgDtlVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
			calculationParmVO.setTrfGrpSeq(chgDtlVO.getBzcTrfGrpSeq());
			
			calculationParmVO.setCntrts(chgDtlVO.getCntrTpszCd());
			calculationParmVO.setOverDay(chgDtlVO.getOrgFtOvrDys());			
			calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
			calculationParmVO.setCurCd(chgDtlVO.getBzcTrfCurrCd());
			calculationParmVO.setFtDys(chgDtlVO.getBzcFtDys());						// 2014.03.12
			calculationParmVO.setFmMvmtYdCd(chgDtlVO.getFmMvmtYdCd());				// 2014.03.12
			calculationParmVO.setTrfAplyDt(chgDtlVO.getBzcTrfAplyDt());				// 2014.03.12
			calculationParmVO.setOrgFtOvrDys(chgDtlVO.getOrgFtOvrDys());			// 2014.03.12
			
			calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
			
//			if (DMTCalculationUtil.stringToDouble(chgDtlVO.getScRfaExptAmt()) > 0) {	// 2014.03.12
			if (!"".equals(chgDtlVO.getScRfaExptAplyDt())) {	// 2014.03.12
				calculationParmVO.setDmdtTrfAplyTpCd("B");							// 방글라데시 로직 때문에 추가. ("B" 또는 "S"로 넣기면 됨)
				calculationParmVO.setTrfAplyDt(chgDtlVO.getScRfaExptAplyDt());				// 2014.03.12
			} else {
				calculationParmVO.setDmdtTrfAplyTpCd("G");
			}
			
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
						
						if("Y".equals(chgDtlVO.getCxlBkgChgFlg())) {
							String ftDys = "KOR".equals(firstSvrID) ? "1" : "0";
							chgBzcFtVO.setFtDys(ftDys);
							chgBzcFtVO.setXcldSatFlg("N");
							chgBzcFtVO.setXcldSunFlg("N");
							chgBzcFtVO.setXcldHolFlg("N");
						} else {
							chgBzcFtVO.setFtDys(String.valueOf(bzcFreeTime));
							chgBzcFtVO.setXcldSatFlg(orgChgBzcFtVO.getXcldSatFlg());
							chgBzcFtVO.setXcldSunFlg(orgChgBzcFtVO.getXcldSunFlg());
							chgBzcFtVO.setXcldHolFlg(orgChgBzcFtVO.getXcldHolFlg());
						}
						
						totOrgFtOvrDys += NumberUtils.toInt(vo.getRtDay(), 0);
						
						chgBzcFtVO.setOrgFtOvrDys(vo.getRtDay());
						chgBzcFtVO.setCurrCd(basicCurrencyCoverageVO.getCurrCd());
						chgBzcFtVO.setFtOvrUndDys(vo.getRtOver() + "-" + ("0".equals(vo.getRtUnder()) ? "" : vo.getRtUnder()));	// + vo.getRtUnder());
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
			if(!"".equals(chgDtlVO.getCmdtCd())) {
				CommodityTariffParmVO cmdtTrfParmVO = new CommodityTariffParmVO();
				cmdtTrfParmVO.setSvrId(chargeArgumentVO.getSvrId());
				cmdtTrfParmVO.setDmdtTrfCd(chargeArgumentVO.getDmdtTrfCd());
				cmdtTrfParmVO.setTrfSeq(chgDtlVO.getBzcTrfSeq());
				cmdtTrfParmVO.setCmdtCd(chgDtlVO.getCmdtCd());
				cmdtTrfParmVO.setCmdtTrfSeq(chgDtlVO.getCmdtTrfSeq());
				
				// Commodity Exception Tariff의 Free Time일수 및 주말, 공휴일 포함 여부를 조회한다.
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
			if(!"".equals(chgDtlVO.getRfaExptDarNo())) {
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
			if(!"".equals(chgDtlVO.getScNo())) {
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
			if(!"".equals(chgDtlVO.getAftExptDarNo())) {
				// AfterExceptionTariffParmVO 파라미터 데이터 구성
				AfterExceptionTariffParmVO aftExptTrfParmVO = new AfterExceptionTariffParmVO();
				aftExptTrfParmVO.setAftExptDarNo(chgDtlVO.getAftExptDarNo());
				aftExptTrfParmVO.setAftExptAdjSeq(chgDtlVO.getAftExptAdjSeq());
				aftExptTrfParmVO.setSvrId(chargeArgumentVO.getSvrId());
				aftExptTrfParmVO.setCntrNo(chargeArgumentVO.getCntrNo());
				aftExptTrfParmVO.setCntrCycNo(chargeArgumentVO.getCntrCycNo());
				aftExptTrfParmVO.setDmdtTrfCd(chargeArgumentVO.getDmdtTrfCd());
				aftExptTrfParmVO.setDmdtChgLocDivCd(chargeArgumentVO.getDmdtChgLocDivCd());
				
				// After Discount의 Free Time일수 및 주말, 공휴일 포함 여부, Currency, Discount Ratio 또는 Discount Amount를 조회한다
				AfterExceptionTariffVO aftExptTrfVO = dbDao.chargeAfterException(aftExptTrfParmVO);
				
				if(aftExptTrfVO != null) {
					aftExptTrfVO.setAftExptAproNo(chgDtlVO.getAftExptAproNo());
					aftExptTrfVO.setAftExptOvrDys(chgDtlVO.getAftExptOvrDys());
					
					List<AfterExceptionTariffVO> afterExceptionTariffVOs = new ArrayList<AfterExceptionTariffVO>();
					afterExceptionTariffVOs.add(aftExptTrfVO);
					chgCalcDtlVO.setAfterExceptionTariffVOs(afterExceptionTariffVOs);
				}
			}
						
			// Charge에 적용된 Clock Stop 관련 정보를 조회한다.
			List<ClockStopVO> clockStopVOs = dbDao.chargeClockStop(chargeArgumentVO);
			
			if(clockStopVOs != null) {
				chgCalcDtlVO.setClockStopVOs(clockStopVOs);
			}
			
			// Exception Cost 정보를 조회함. 2012.10.09추가
			List<ExceptionCostVO> exceptionCostVOs = dbDao.searchExceptionCost(chargeArgumentVO);
			chgCalcDtlVO.setExceptionCostVOs(exceptionCostVOs);
			
			return chgCalcDtlVO;
			
		} catch (EventException ex) {
			throw new EventException(ex.getMessage());
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge Detail"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge Detail"}).getMessage());
		}
	}
	
	
	/**
	 * SZPSC Office로 생성된 Container Charge List를 조회한다.<br>
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
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge by SZPSC"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Charge by SZPSC"}).getMessage());
		}
	}
	
	
	/**
	 * SZPSC Office로 발생한 Charge관련한 Movement Data를 조회한다.<br>
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
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Movement by SZPSC"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Movement by SZPSC"}).getMessage());
		}
	}
	
	
	/**
	 * SZPSC Office의 "DMOF', "DMIF" Charge를 생성한다.<br>
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
		
		com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffParmVO basicTariffParmVO = null;
		basicTariffParmVO = new com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffParmVO();
		
		LocationByBoundParmVO	locationByBoundParmVO	= new LocationByBoundParmVO();
		FreeTimeStartParmVO		freeTimeStartParmVO		= new FreeTimeStartParmVO();
		FreeTimeEndParmVO 		freeTimeEndParmVO		= new FreeTimeEndParmVO();
		OverdayNStatusParmVO	overdayNStatusParmVO	= new OverdayNStatusParmVO();
		CalculationParmVO 		calculationParmVO		= new CalculationParmVO();
		
		List<String> cstop_no_list = new ArrayList<String>();
		long idx_cstop	= 0;
		
		//try {
			
			/* ******************** 처리로직 ******************************************
			1. UI에서 Parameter로 받은 Charge 수 만큼 Loop작업한다
			    A) 기 생성된 Charge의 Booking Container 등의 정보를 조회한다
			    B) Effective Date를 설정한다
			         a) "DMOF"인 경우 "OC" Date를 설정한다
			         b) "DMIF"인 경우 POD ETA를 설정한다
			    C) Basic Tariff 정보를 조회한다
			    D) Free Time Start Date를 설정한다
			         a) "DMIF"이고 From Movement가 "VD"면서 From Yard와 POD가 같으면 VL/VD UPDATE정보의 Free Time 시작일을 조회하여 설정한다
			         b) a)의 경우가 아니면 Free Time Start Date를 조회하는 searchFreeTimeStart를 Call한다( Clock Stop은 제외)
			    E) Free Time End Date를 설정한다
			         a) Free Time End Date를 조회하는 searchFreeTimeEnd를 Call한다( Clock Stop은 제외)
			         b) "DMOF"이고 To Movement가 "VL"이면 VL/VD UPDATE 정보의 Free Time 종료일을 설정한다
			    F) Free Time Over일수를 계산한다
			    G) F)에서 Status가 "F"나 "L"이면 Charge를 계산한다
			    H) Charge를 저장한다
			**************************************************************************/
			
			for ( int i=0; i < chargeCalculationContainerVOs.length; i++ ) {
				ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs[i];
				
				ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
				chgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				chgArgVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				
				// A) 기 생성된 Charge의 Booking Container 등의 정보를 조회한다
				BkgContainerInfoVO bkgCntrInfoVO = null;
				
				try {
					bkgCntrInfoVO = dbDao.searchBookingContainerBySZPBB(chgArgVO);
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler("DMT00006", new String[]{"Booking Container by SZPSC"}).getMessage());
				}
				
				String effDt = null;
				String ioBndCd = null;
				
				// B) Effective Date를 설정한다.
				try {
					if("DMOF".equals(chgCalcCntrVO.getDmdtTrfCd())) {
						ioBndCd = "O";
						effDt = chgCalcCntrVO.getFmMvmtDt();
					} else if("DMIF".equals(chgCalcCntrVO.getDmdtTrfCd())) {
						ioBndCd = "I";
						VVDNEtaVO vvEtaVO = dmtCalculationUtil.searchVVDNEta(chgCalcCntrVO.getBkgNo(), bkgCntrInfoVO.getPolCd(), bkgCntrInfoVO.getPodCd(), ioBndCd);
						effDt = vvEtaVO.getVpsEtaDt();
					}
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler("DMT00008", new String[]{"create Charge by SZPSC"}).getMessage());
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
				
				//log.debug(" bkgCntrInfoVO.getFmMvmtYdCd() *******" + bkgCntrInfoVO.getFmMvmtYdCd());
				// C) Basic Tariff 정보를 조회한다
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
				

				if("".equals(DMTCalculationUtil.nullToString(basicTariffKeyVO.getSvrId()))){
					resultVO.setResultCode("-1");
					resultVO.setResultMsg("Basic Tariff Not Found!");
					return resultVO;
				}

				/*
				[logic] Basic Tariff의 Free days 가져오기 : Get Basic Free Days
				>>>>> z_dbc_bkg_qty -> Booking의 Container 물량
				*/
				String ftDys = "";
				
				try {
					String dmdtTrfCd	= basicTariffKeyVO.getDmdtTrfCd();
					long trfSeq = NumberUtils.toLong(basicTariffKeyVO.getTrfSeq(), 0);
					String dmdtDeTermCd = basicTariffKeyVO.getDmdtDeTermCd();
					long trfGrpSeq = NumberUtils.toLong(basicTariffKeyVO.getTrfGrpSeq(), 0);
					long bkgCntrQty = NumberUtils.toLong(bkgCntrInfoVO.getBkgCntrQty(), 0);
					String svrID		= basicTariffKeyVO.getSvrId();
					
					long retFtDys = dmtCalculationUtil.basicFreeTime(svrID, dmdtTrfCd, trfSeq, dmdtDeTermCd, trfGrpSeq, bkgCntrQty);
					ftDys = String.valueOf(retFtDys);
				} catch (Exception ex) {
					throw new EventException(new ErrorHandler("DMT00006", new String[]{"Basic Tariff Free Days"}).getMessage());
				}	
			
				
				/*
				D) Free Time Start Date를 설정한다
		         	a) "DMIF"이고 From Movement가 "VD"면서  From Yard 와  POD가 같으면  VL/VD UPDATE정보의 Free Time 시작일을 조회하여 설정한다
		         	b) a)의 경우가 아니면 Free Time Start Date를 조회하는 searchFreeTimeStart를 Call한다( Clock Stop은 제외)
				*/
				// [logic] ********  Get Basic FreeTime Start ***********
				// Free Time Start Date
				String ftCmncDt = "";
				
				if( ("DMIF".equals(chgCalcCntrVO.getDmdtTrfCd()) || "CTIC".equals(chgCalcCntrVO.getDmdtTrfCd()))
						&& "VD".equals(bkgCntrInfoVO.getFmMvmtStsCd())
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
					freeTimeStartParmVO.setYardCd(bkgCntrInfoVO.getFmMvmtYdCd());	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
					//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
					freeTimeStartParmVO.setYrdLocCd(bkgCntrInfoVO.getFmMvmtYdCd().substring(0, 5));  
					freeTimeStartParmVO.setIoBndCd(ioBndCd);
					freeTimeStartParmVO.setBkgDeTermCd(chgCalcCntrVO.getBkgDeTermCd());
					freeTimeStartParmVO.setBkgRcvTermCd(chgCalcCntrVO.getBkgRcvTermCd());
					
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
				E) Free Time End Date를 설정한다
		         	a) Free Time End Date를 조회하는 searchFreeTimeEnd를 Call한다( Clock Stop은 제외)
		         	b) "DMOF"이고 To Movement가 "VL"이면 VL/VD UPDATE 정보의 Free Time 종료일을 설정한다
		        */

				/*
				[logic] Get Basic FreeTime End
				*/
				// 위의 조회값 입력 >>> z_dc_ft_cmnc
				freeTimeEndParmVO.setFromDt(ftCmncDt);

				freeTimeEndParmVO.setBkgCntCd(bkgCntCd);
				freeTimeEndParmVO.setBkgRgnCd(bkgRgnCd);
				freeTimeEndParmVO.setBkgStateCd(bkgStateCd);
				freeTimeEndParmVO.setBkgLocCd(bkgLocCd);
				
				freeTimeEndParmVO.setYrdCntCd(bkgCntrInfoVO.getYrdCntCd());
				freeTimeEndParmVO.setYrdRgnCd(bkgCntrInfoVO.getYrdRgnCd());
				freeTimeEndParmVO.setYrdStateCd(bkgCntrInfoVO.getYrdSteCd());
				
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
				//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
				freeTimeEndParmVO.setYrdLocCd(bkgCntrInfoVO.getFmMvmtYdCd().substring(0, 5));
				freeTimeEndParmVO.setIoBndCd(ioBndCd);
				freeTimeEndParmVO.setBkgDeTermCd(chgCalcCntrVO.getBkgDeTermCd());
				freeTimeEndParmVO.setBkgRcvTermCd(chgCalcCntrVO.getBkgRcvTermCd());
				
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
				if(	("DMOF".equals(chgCalcCntrVO.getDmdtTrfCd()) || "CTOC".equals(chgCalcCntrVO.getDmdtTrfCd())) 
						&& "VL".equals(chgCalcCntrVO.getToMvmtStsCd())) {
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
				F) Free Time Over일수를 계산한다
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
				//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
				overdayNStatusParmVO.setYrdLocCd(bkgCntrInfoVO.getFmMvmtYdCd().substring(0, 5));  
				overdayNStatusParmVO.setBkgCntCd(bkgCntCd);
				overdayNStatusParmVO.setBkgStateCd(bkgStateCd);
				overdayNStatusParmVO.setBkgRgnCd(bkgRgnCd);
				overdayNStatusParmVO.setBkgLocCd(bkgLocCd);
				overdayNStatusParmVO.setIoBndCd(ioBndCd);
				overdayNStatusParmVO.setBkgDeTermCd(chgCalcCntrVO.getBkgDeTermCd());
				overdayNStatusParmVO.setBkgRcvTermCd(chgCalcCntrVO.getBkgRcvTermCd());
				overdayNStatusParmVO.setSvrId(basicTariffKeyVO.getSvrId());
				overdayNStatusParmVO.setYrdCntCd(bkgCntrInfoVO.getYrdCntCd());
				overdayNStatusParmVO.setYrdStateCd(bkgCntrInfoVO.getYrdSteCd());
				overdayNStatusParmVO.setYrdRgnCd(bkgCntrInfoVO.getYrdRgnCd());
				
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
	
				if( "L".equals(dmdtChgStsCd) || "F".equals(dmdtChgStsCd) ){
					calculationParmVO.setSvrId(chgCalcCntrVO.getSvrId());
					calculationParmVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					calculationParmVO.setTrfSeq(basicTariffKeyVO.getTrfSeq());
					calculationParmVO.setDmdtDeTermCd(basicTariffKeyVO.getDmdtDeTermCd());		// dmdt_de_term_cd
					calculationParmVO.setTrfGrpSeq(basicTariffKeyVO.getTrfGrpSeq());
					calculationParmVO.setCntrts(chgCalcCntrVO.getCntrTpszCd());
					calculationParmVO.setOverDay(fxFtOvrDys);
					calculationParmVO.setDivOverDay("0");
					calculationParmVO.setFtDys(String.valueOf(ftDys));							// 2014.03.12
					calculationParmVO.setFmMvmtYdCd(bkgCntrInfoVO.getFmMvmtYdCd());				// 2014.03.12
					calculationParmVO.setTrfAplyDt(effDt);										// 2014.03.12
					
					CalculationAMTVO calculationAMTVO = null;
					try {
						calculationParmVO.setOrgFtOvrDys(chgCalcCntrVO.getOrgFtOvrDys());		// 2014.03.12
						calculationParmVO.setDmdtTrfAplyTpCd("G");								// 2014.03.12
						
						calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
						
						orgChgAmt = DMTCalculationUtil.nullToString(calculationAMTVO.getTotal());
					} catch (Exception ex) {
						//throw new EventException("Charge & Total Function Error!", e);
						throw new EventException(new ErrorHandler("DMT00008", new String[]{"basic Calculation"}).getMessage());
					}
				}
	
				String dmdtTrfAplyTpCd = "G"; 		/* Applied Rate Set  */
				String billAmt = orgChgAmt;  		/* Basic  Amount Fixing */
				
				// addCharge (DMT_CHG_CALC 테이블에 Insert)
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

				dmtChgCalcVO.setBzcTrfCurrCd(basicTariffKeyVO.getCurrCd());
				dmtChgCalcVO.setDmdtTrfAplyTpCd(dmdtTrfAplyTpCd);
				dmtChgCalcVO.setOrgChgAmt(orgChgAmt);

				dmtChgCalcVO.setBilAmt(billAmt);
				dmtChgCalcVO.setDmdtChgStsCd(dmdtChgStsCd);						

				dmtChgCalcVO.setBzcTrfSeq(basicTariffKeyVO.getTrfSeq());
				dmtChgCalcVO.setBzcDmdtDeTermCd(basicTariffKeyVO.getDmdtDeTermCd());		// dmdt_de_term_cd
				dmtChgCalcVO.setBzcTrfGrpSeq(basicTariffKeyVO.getTrfGrpSeq());
				dmtChgCalcVO.setBzcTrfAplyDt(effDt);		

				dmtChgCalcVO.setWebMtyDt(webMtDt);
				dmtChgCalcVO.setCreUsrId(account.getUsr_id());
				dmtChgCalcVO.setCreOfcCd(account.getOfc_cd());
				dmtChgCalcVO.setUpdUsrId(account.getUsr_id());
				dmtChgCalcVO.setUpdOfcCd(account.getOfc_cd());
				
				// DMT_CHG_CALC 테이블에  Insert 처리
				boolean dupFlg = false;
				
				if("SZP".equals(chgCalcCntrVO.getDmdtChgLocDivCd())) {
					dupFlg = true;
				} else {
					try {
						dbDao.addChargeBySZPBB(dmtChgCalcVO);
						dbDao.modifyChargeChnDemKeyNoBySZPBB(dmtChgCalcVO);
					} catch (DAOException e) {
						if("1".equals(e.getMessage())) {
							dupFlg = true;
						} else {
							throw new EventException(new ErrorHandler("DMT00008", new String[]{"add Charge by SZPSC"}).getMessage());
						}
					} catch (Exception ex) {
						throw new EventException(new ErrorHandler("DMT00008", new String[]{"add Charge by SZPSC"}).getMessage());
					}
				}
				
				if(dupFlg) {
					try {
						dbDao.modifyChargeBySZPBB(dmtChgCalcVO);
					} catch (Exception ex) {
						throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify Charge by SZPSC"}).getMessage());
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
			} // for end
			
			resultVO.setChargeCalculationContainerVOs(list);
			return resultVO;
	}
	
	/**
	 * Invoice Group에 대한 CHARGE HISTORY를 저장한다.<br>
	 * 
	 * @param List<InvoiceIssueVO> invoiceIssueVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeChargeStatusForInvoiceByGroup(List<InvoiceIssueVO> invoiceIssueVOs, SignOnUserAccount account) throws EventException{
		
		try {
			for(int i = 0 ; i < invoiceIssueVOs.size() ; i++) {
				InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueVOs.get(i);
				
				com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = new com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
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
	 * Invoice Cancel에 대한 CHARGE HISTORY를 저장한다.<br>
	 * 
	 * @param List<ChargeArgumentVO> chargeArgumentVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeChargeStatusForInvoiceByCancel(List<ChargeArgumentVO> chargeArgumentVOs, SignOnUserAccount account) throws EventException{
		try {
			for(int i = 0 ; i < chargeArgumentVOs.size() ; i++) {
				ChargeArgumentVO invCancelChargeArgumentVO = (ChargeArgumentVO)chargeArgumentVOs.get(i);
				
    			com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = new com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
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
	 * CHARGE Trucker 정보를 저장한다.<br>
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
    			
    			//전체는 Truck를 update한다. 
    			com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO closingChargeArgumentVO = new com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO();
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
	 * Booking Container 정보를 갱신한다.<br>
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
	 * Charge Calculation 정보를 갱신한다.<br>
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
	 * Charge Calculation 정보를 저장한다.<br>
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
	 * Clock Stop 이 있을경우 History 를 삭제한다<br>
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
	 * Clock Stop History가 존재하면 Clock Stop History를 Insert한다.<br>
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
	 * VVD 정보를 저장 합니다.<br>
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
	 * EDI 로 각 모듈별 정보를 전송 합니다.<br>
	 * 
	 * @param List<EDIVO> EDIVOs
	 * @throws EventException
	 */
	public void sendToEDI(List<EDIVO> eDIVOs) throws EventException {
		KorDoEdiTransVO		korDoEdiTransVO		= null;
		
		CargoReleaseOrderBC cargoReleaseOrderBC	= new CargoReleaseOrderBCImpl();
		
		try {
			if (eDIVOs != null && eDIVOs.size() > 0) {
				for (int i = 0 ; i < eDIVOs.size() ; i++) {
					//2011.10.11 김현화[] sendEDI시 checkEDI추가.(BKG_CSTMS_KR_MF_SEQ_NO)
					String bkgNo = eDIVOs.get(i).getBkgNo();
					String sendFg = dbDao.checkEDI(bkgNo);
					int n = 0;
					
					if (sendFg == null || "N".equals(sendFg)) continue;
					
					// BKG no별 1건으로 보내도록 함. 2011.12.14 김현화
					  for(int j = 0 ; j < i ; j++){
						  if (( i > 0) && (i > j)){
	                        if ( bkgNo.equals(eDIVOs.get(j).getBkgNo())){
	                        	  if ("Y".equals(sendFg)){
								       n++;
	                        	   }
							     }
							 }
						}
						if ( n >= 1 ) continue;
					
					//EDI 로 보낼 정보를 설정한다.
					korDoEdiTransVO	= new KorDoEdiTransVO();
					korDoEdiTransVO.setBkgNo(		eDIVOs.get(i).getBkgNo() );
					korDoEdiTransVO.setDoType(		"KDL"					 );	//=>'KDL' 고정 값 (Dem/Det 에서 호출 의미 )
					korDoEdiTransVO.setSelfTrnsFlg(	"N"						 ); //=>'N'  고정값 ( BKG용 )
					korDoEdiTransVO.setAcount(		eDIVOs.get(i).getAcount());	

					//EDI 로 전송한다.
					cargoReleaseOrderBC.transmitEdiByKorDo(korDoEdiTransVO);
					//log.debug("cargoReleaseOrderBC========transmitEdiByKorDo")	;
					eDIVOs.get(i).setEdiIssUsrId(	StringUtils.defaultIfEmpty(eDIVOs.get(i).getAcount().getUsr_id(), "BATCH" ));
					eDIVOs.get(i).setCreUsrId(		StringUtils.defaultIfEmpty(eDIVOs.get(i).getAcount().getUsr_id(), "BATCH" ));
					eDIVOs.get(i).setCreOfcCd(		StringUtils.defaultIfEmpty(eDIVOs.get(i).getAcount().getOfc_cd(), "BATCH" ));
					
					//EDI 전송 결과를 로그로 남긴다.
					//log.info("\n[BKG No]: " + eDIVOs.get(i).getBkgNo() + "\n[EDI ID]: " + bkgNtcHisVO.getEdiId() + "\n[Result]: " + bkgNtcHisVO.getBkgNtcSndRsltCd());
					
					//EDI 로 전송한 이력을 쌓는다.
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
	 * CTOC/CTIC 대상으로 해당 정보를 수정한다.<br>
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
	 * Dual Charge Tariff List를 조회한다<br>
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
	 * 해당 Back End Job의 상태를 리턴한다.
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
	 * 해당 Back End Job을 실행시킨다.
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

			// 로직 추가 근거 : CHM-201533804 [DMT] Deletion Setup 화면 개발  2015.02.09    ================
			// Charge 가 삭제상태이거나, 삭제요청중인 경우, Charge 재계산 대상에서 제외한다.================
			if ("RECALC".equals(backendjobId)) {
				for (ChargeCalculationContainerVO chgCalcCntrVO : chargeCalculationContainerVOs) {
					// Charge 가 삭제상태이거나, 삭제요청중인 경우, 업무예외를 발생시킨다.
					if (!dbDao.isRecalculationStatus(chgCalcCntrVO)) {
						// Container (CNTR No. : ) 는 삭제되었거나, 삭제요청중 입니다.
						throw new EventException(new ErrorHandler("DMT06043", new String[]{chgCalcCntrVO.getCntrNo()}).getMessage());
					}
				}
			}
			//==============================================================================================
			
			//BackEndJob 처리를 위해서 필요한 정보를 매개변수로 설정해준다.
			backEndJob.setJobCommand(backendjobId);
			backEndJob.setChargeArgumentVO(chargeArgumentVO);
			backEndJob.setChargeCalculationContainerVOs(chargeCalculationContainerVOs);
			backEndJob.setSignOnUserAccount(account);
			
			String jobMessage = "DMT " + backendjobId + " Back End";
			
			//BackEndJob 모듈을 호출한다.
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), jobMessage);
		} catch (EventException ex) {
			log.error("[EventException]"+ex.getMessage());
			throw ex;
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
	 * @param ChargeInactivDetailVO[] chargeInactivDetailVOs
	 * @param ChargeInactivFileVO[] chargeInactivFileVOs
	 * @param SignOnUserAccount account
	 * @param String rqstNo
	 * @return String
	 * @exception EventException
	 */
	public String requestChargeDeletion(ChargeInactivDetailVO[] chargeInactivDetailVOs, ChargeInactivFileVO[] chargeInactivFileVOs, SignOnUserAccount account, String rqstNo)
		throws EventException {

		String fileFlg = "";
		
		try {
			String result = "";
			
			if (chargeInactivDetailVOs != null && chargeInactivDetailVOs.length > 0) {
			
				com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO checkArgument = null;
				
				ChargeCalculationContainerVO chgCalcCntrVO = null;
				
				fileFlg = chargeInactivDetailVOs[0].getFileFlg();
				
				for (ChargeInactivDetailVO chgInactivVO : chargeInactivDetailVOs) {
					
					chgCalcCntrVO = new ChargeCalculationContainerVO();
					checkArgument = new com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO();
					
					//중복처리 방지 체크로직
					checkArgument.setSvrId(chgInactivVO.getSvrId());
					checkArgument.setCntrNo(chgInactivVO.getCntrNo());
					checkArgument.setCntrCycNo(chgInactivVO.getCntrCycNo());
					checkArgument.setDmdtTrfCd(chgInactivVO.getDmdtTrfCd());
					checkArgument.setDmdtChgLocDivCd(chgInactivVO.getDmdtChgLocDivCd());
					checkArgument.setChgSeq(chgInactivVO.getChgSeq());
					checkArgument.setStsCd("R");
					checkArgument.setBydr("C");
				
					String isExist = dbDao.checkRequestChargeDeletion(checkArgument);
					
					//Requst 상태인 데이터가 있는 경우 
					if (!isExist.equals(""))
						return "DMT01081";  //This has been done already. 

					if("DMGOMC".equals(chgInactivVO.getDmdtChgDeltSpecRsnCd()) || "SLIOMC".equals(chgInactivVO.getDmdtChgDeltSpecRsnCd()) || "SLIDTO".equals(chgInactivVO.getDmdtChgDeltSpecRsnCd())){
						isExist = "";
						checkArgument.setBydr("OP");
						isExist = dbDao.checkRequestChargeDeletion(checkArgument);
						log.debug("[checkRequestChargeDeletion] OP >>>> " + isExist);
						//Requst 상태인 데이터가 있는 경우 
						if (!isExist.equals("Y"))
							return chgInactivVO.getCntrNo() + " OP, MT is invalid!";  //This has been done already. 
					}
					
					if("ERCEDI".equals(chgInactivVO.getDmdtChgDeltSpecRsnCd())){
						checkArgument.setDmdtInvNo(chgInactivVO.getDetail6Type());
						isExist = "";
						checkArgument.setBydr("INV");
						isExist = dbDao.checkRequestChargeDeletion(checkArgument);
						//Requst 상태인 데이터가 있는 경우 
						if (!isExist.equals("Y"))
							return "Invoice was already Cancelled.(" + chgInactivVO.getCntrNo() + ")";
					} else if("ERCDCA".equals(chgInactivVO.getDmdtChgDeltSpecRsnCd())){
						checkArgument.setDmdtInvNo(chgInactivVO.getDetail7Type());
						isExist = "";
						checkArgument.setBydr("INV");
						isExist = dbDao.checkRequestChargeDeletion(checkArgument);
						//Requst 상태인 데이터가 있는 경우 
						if (!isExist.equals("Y"))
							return "Invoice was already Cancelled.(" + chgInactivVO.getCntrNo() + ")";
					} else if("SLINIK".equals(chgInactivVO.getDmdtChgDeltSpecRsnCd())||"SLIHPP".equals(chgInactivVO.getDmdtChgDeltSpecRsnCd())){
						checkArgument.setDmdtInvNo(chgInactivVO.getDetail3Type());
						isExist = "";
						checkArgument.setBydr("INV");
						isExist = dbDao.checkRequestChargeDeletion(checkArgument);
						//Requst 상태인 데이터가 있는 경우 
						if (!isExist.equals("Y"))
							return "Invoice was already Cancelled.(" + chgInactivVO.getCntrNo() + ")";
					} else if("CRESTT".equals(chgInactivVO.getDmdtChgDeltSpecRsnCd())){
						if(!"DTIC".equals(chgInactivVO.getDmdtTrfCd()) && !"CTIC".equals(chgInactivVO.getDmdtTrfCd())){
							return "is invalid!(" + chgInactivVO.getCntrNo() + ")";
						}
					}
					
					checkArgument.setBydr("");
					
					String deltinfo = dbDao.checkRequestChargeDeletion(checkArgument);
					
//					String chgMaxSeq = dbDao.searchChargeMaxSequence(checkArgument);
					
//					if(!chgInactivVO.getChgSeq().equals(chgMaxSeq)) {
//						message = "Only the last balance charge of a cntr can be deleted. Please check the charge of cntr no. : " + chgInactivVO.getCntrNo();
//						checkArgument.setErrMsg(message);
//	
//						return message;	
//					}					
			
					// Deletion Specific Reason 별로 입력된 1~6 단계별 상세사유 등록 [Start] #########################################
					// 2. Deletion Specific Reason 별 입력된 1~6 단계별 상세사유 등록을 위한 시퀀스 조회
					String deltSpecRsnRmkSeq = "";
					if (!"".equals(deltinfo)){
						deltSpecRsnRmkSeq = chgInactivVO.getDeltSpecRsnRmkSeq();						
					} else {
						deltSpecRsnRmkSeq = dbDao.searchChargeDeltSpecRsnRmkNextSequence();
					}
					log.debug("[requestChargeDeletion] deltSpecRsnRmkSeq : " + deltSpecRsnRmkSeq);
					
					List<ChargeDeltSpecRsnRmkVO> chargeDeltSpecRsnRmkVOList = new ArrayList<ChargeDeltSpecRsnRmkVO>();

					String[] arrDeltRmk         = chgInactivVO.getChgDeltSpecRsnRmk().split("\\|");
					
					int deltRmkLvl = 1;
					for (String deltRmk : arrDeltRmk) {
						ChargeDeltSpecRsnRmkVO chargeDeltSpecRsnRmkVO = new ChargeDeltSpecRsnRmkVO();
						chargeDeltSpecRsnRmkVO.setDeltSpecRsnRmkSeq(deltSpecRsnRmkSeq);
						chargeDeltSpecRsnRmkVO.setDeltRmkLvl(String.valueOf(deltRmkLvl));
						chargeDeltSpecRsnRmkVO.setDeltRmk(deltRmk);
						chargeDeltSpecRsnRmkVO.setCreUsrId(account.getUsr_id());
						chargeDeltSpecRsnRmkVO.setCreOfcCd(account.getOfc_cd());
						chargeDeltSpecRsnRmkVO.setUpdUsrId(account.getUsr_id());
						chargeDeltSpecRsnRmkVO.setUpdOfcCd(account.getOfc_cd());
						chargeDeltSpecRsnRmkVOList.add(chargeDeltSpecRsnRmkVO);
						
						deltRmkLvl++;
					}
					
					// 3. Deletion Specific Reason 별 입력된 1~6 단계별 상세사유 등록
					log.debug("[requestChargeDeletion] add count >>>> " + chargeDeltSpecRsnRmkVOList.size());
					log.debug("[requestChargeDeletion] execute >>>> addChargeDeltSpecRsnRmkList [S]");
					dbDao.addChargeDeltSpecRsnRmkList(chargeDeltSpecRsnRmkVOList);
					log.debug("[requestChargeDeletion] execute >>>> addChargeDeltSpecRsnRmkList [E]");
					// Deletion Specific Reason 별로 입력된 1~6 단계별 상세사유 등록 [END] #########################################
					

					chgCalcCntrVO.setSvrId(chgInactivVO.getSvrId());
					chgCalcCntrVO.setCntrNo(chgInactivVO.getCntrNo());
					chgCalcCntrVO.setCntrCycNo(chgInactivVO.getCntrCycNo());
					chgCalcCntrVO.setDmdtTrfCd(chgInactivVO.getDmdtTrfCd());
					chgCalcCntrVO.setDmdtChgLocDivCd(chgInactivVO.getDmdtChgLocDivCd());
					chgCalcCntrVO.setChgSeq(chgInactivVO.getChgSeq());
					
					if (!"".equals(deltinfo)){
						chgCalcCntrVO.setChgOfcCd(chgInactivVO.getOfcCd());
						chgCalcCntrVO.setOfcCd(chgInactivVO.getOfcCd());
						chgCalcCntrVO.setDeltSeq(chgInactivVO.getDeltSeq());
					} else {
						// Deletion Sequence, Charge Office Code 를 Deletion Request 쿼리에서 직접입력하지 않고, 아래처럼 조회해서 사용하도록 변경함.
						Map<String, String> chgDeltMap = dbDao.searchChargeDeletionInfo(checkArgument);
						
						chgCalcCntrVO.setChgOfcCd(chgDeltMap.get("CHG_OFC_CD"));
						chgCalcCntrVO.setOfcCd(chgDeltMap.get("CHG_OFC_CD"));
						chgCalcCntrVO.setDeltSeq(chgDeltMap.get("DELT_SEQ"));
					}
					
					chgCalcCntrVO.setCreUsrId(account.getUsr_id());
					chgCalcCntrVO.setCreOfcCd(account.getOfc_cd());
					
					chgCalcCntrVO.setDmdtChgDeltRsnCd(chgInactivVO.getDmdtChgDeltSpecRsnCd().substring(0, 3));
					chgCalcCntrVO.setDmdtChgDeltSpecRsnCd(chgInactivVO.getDmdtChgDeltSpecRsnCd());
					chgCalcCntrVO.setDeltSpecRsnRmkSeq(deltSpecRsnRmkSeq);
					chgCalcCntrVO.setCorrRmk(chgInactivVO.getDeltRmk());

					chgCalcCntrVO.setOfcRhqCd(account.getRhq_ofc_cd()) ;
					chgCalcCntrVO.setFileSavId(chgInactivVO.getFileSavId());
					
					chgCalcCntrVO.setInactRqstNo(rqstNo);
					chgCalcCntrVO.setChgDeltPathCd("RQT");
					if ( "D".equals(chgInactivVO.getIbflag())){
						chgCalcCntrVO.setChgDeltStsCd("C");
					} else {
						chgCalcCntrVO.setChgDeltStsCd("R");
					}

					log.debug("[requestChargeDeletion] execute >>>> requestChargeDeletion [S]");
					dbDao.requestChargeDeletion(chgCalcCntrVO);
					log.debug("[requestChargeDeletion] execute >>>> requestChargeDeletion [E]");
					
					// Deletion 첨부파일 등록 #################################################################################
					if (!StringUtils.isEmpty(chgCalcCntrVO.getFileSavId()) || fileFlg.equals("Y") || "".equals(deltinfo)) {
						// 첨부파일이 존재할 경우, 등록해준다.
						log.debug("[requestChargeDeletion] execute >>>> addChargeDeletionRequestFile [S]");
						this.addChargeDeletionRequestFile(chgCalcCntrVO, chargeInactivFileVOs, account);
						log.debug("[requestChargeDeletion] execute >>>> addChargeDeletionRequestFile [E]");
					}
					
					if ( "".equals(deltinfo) ){
						// Deletion Authority 승인프로세스 실행 ####################################################################
						log.debug("[requestChargeDeletion] execute >>>> addChargeDeletionPathSetup [S]");
						this.addChargeDeletionPathSetup(chgCalcCntrVO, account);
						log.debug("[requestChargeDeletion] execute >>>> addChargeDeletionPathSetup [E]");
						// Deletion Authority 승인프로세스 종료 ####################################################################
					}

					// Histroy 추가 함.
					this.addChargeDeletionChangeHistory(chgCalcCntrVO);
				} // for end
			}

			return result;
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"Request Charge Deletion"}).getMessage());
		}	
		catch (Exception ex) { 
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
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		catch (Exception ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
//	/**
//	 * Charge Deletion을 Reject한다.<br>
//	 * 
//	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
//	 * @param SignOnUserAccount account 
//	 * @exception EventException
//	 */
//	public void rejectChargeDeletion(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account ) throws EventException {
//		
//		try {
//					
//			ChargeCalculationContainerVO chgCalcCntrVO  = chargeCalculationContainerVOs[0];
//			
//			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
//				chgCalcCntrVO = chargeCalculationContainerVOs[i];
//		
//				ChargeArgumentVO checkArgument = new ChargeArgumentVO();
//					
//				checkArgument.setSvrId(chgCalcCntrVO.getSvrId());
//				checkArgument.setCntrNo(chgCalcCntrVO.getCntrNo());
//				checkArgument.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
//				checkArgument.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
//				checkArgument.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
//				checkArgument.setChgSeq(chgCalcCntrVO.getChgSeq());
//				checkArgument.setOfcCd(chgCalcCntrVO.getOfcCd());
//				checkArgument.setDeltSeq(chgCalcCntrVO.getDeltSeq());
//				checkArgument.setUpdUsrId(account.getUsr_id()) ;
//				checkArgument.setUpdOfcCd(account.getOfc_cd()) ;
//				checkArgument.setRhqOfcCd(account.getRhq_ofc_cd()) ;
//				checkArgument.setStsCd("J");
//				
//			
//				dbDao.modifyChargeDeletion(checkArgument);
//				
//			} // for end
//			
//		} catch (DAOException ex) {
//			log.error("[DAOException]"+ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00008", new String[]{"Reject Charge Deletion"}).getMessage());
//		} catch (Exception ex) {
//			log.error("[Exception]"+ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00008", new String[]{"Reject Charge Deletion"}).getMessage());
//		}
//	}
	
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
				com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
				ChargeCalculationContainerVO[] chargeResultVOs = chargeCalculationContainerVOs;
				
			for ( int i=0; i<chargeCalculationContainerVOs.length; i++ ) {
				ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs[i];

				// 로직 추가 근거 : CHM-201533804 [DMT] Deletion Setup 화면 개발  2015.02.09    ===========
				// Charge 가 삭제상태이거나, 삭제요청중인 경우, Charge 재계산 대상에서 제외한다.===========
				if (!dbDao.isRecalculationStatus(chgCalcCntrVO)) continue;
				//=========================================================================================
								
				chgCalcCntrVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt().replace("-", ""));
				chgCalcCntrVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt().replace("-", ""));
				chgCalcCntrVO.setFmMvmtDtTime(chgCalcCntrVO.getFmMvmtDtTime().replace(":", ""));
				chgCalcCntrVO.setToMvmtDtTime(chgCalcCntrVO.getToMvmtDtTime().replace(":", ""));
				
				ChargeArgumentVO chgArgVO = new ChargeArgumentVO();
				
				chgArgVO.setSvrId(chgCalcCntrVO.getSvrId());
				chgArgVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgArgVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgArgVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgArgVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgArgVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				chgArgVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
				chgArgVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				chgArgVO.setFmMvmtDtTime(chgCalcCntrVO.getFmMvmtDtTime());
				chgArgVO.setToMvmtDtTime(chgCalcCntrVO.getToMvmtDtTime());
				
				String checkScRfaExptApltDt = "";
				
				if ("1".equals(chgArgVO.getChgSeq())) {
					ChargeStatusNRemarkVO checkScRfaExptApltDtVO = null;
					ChargeArgumentVO checkArgumentVO = new ChargeArgumentVO();
				
					checkArgumentVO.setSvrId(chgArgVO.getSvrId());
					checkArgumentVO.setCntrNo(chgArgVO.getCntrNo());
					checkArgumentVO.setCntrCycNo(chgArgVO.getCntrCycNo());
					checkArgumentVO.setDmdtTrfCd(chgArgVO.getDmdtTrfCd());
					checkArgumentVO.setDmdtChgLocDivCd(chgArgVO.getDmdtChgLocDivCd());
					checkArgumentVO.setChgSeq(chgArgVO.getChgSeq());
	
					checkScRfaExptApltDtVO = dbDao.searchChargeStatusNRemark(checkArgumentVO);
					checkScRfaExptApltDt = checkScRfaExptApltDtVO.getScRfaExptApltDt();
				}
				
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
				
				//  To Movement Status가 "DR"이나 "CS"인 경우, 현재 일자와 To Date를 비교하여 To Date가 작으면  오류 처리
				String toMvmtStsCd = chgCalcCntrVO.getToMvmtStsCd();
				
				if("DR".equals(toMvmtStsCd)) {
					// DR Date Checking
					// From < To 일 경우만 통과
					// User Office별 현재일자 조회
					String currDt	= dbDao.searchCurrentDateByOffice(account.getOfc_cd());
					String toMvmtDt	= chgCalcCntrVO.getToMvmtDt();
					
					if(currDt.compareTo(toMvmtDt) > 0) {
						// D/R Date should be same or later than current date
						resultVO.setResultCode("DMT01031");
						return resultVO;
					}
				} else if("CS".equals(toMvmtStsCd)) {
					// Clock Stop
					// From <= To 일 경우만 통과
					String fmMvmtDt = chgCalcCntrVO.getFmMvmtDt();
					String toMvmtDt = chgCalcCntrVO.getToMvmtDt();
					
					if(fmMvmtDt.compareTo(toMvmtDt) >= 0) {
						// CS date should be later than From date
						resultVO.setResultCode("DMT01004");
						return resultVO;
					}
				}
				
				com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = null;
				chargeArgumentVO = new com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
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
				
				if("EUR".equals(chgCalcCntrVO.getSvrId())) {
					String obCntrFlg = dbDao.searchInOutBoundByMovement(chgCalcCntrVO.getCntrNo(), chgCalcCntrVO.getCntrCycNo(), chgCalcCntrVO.getFmMvmtYdCd());
					//log.debug("============> OB_CNTR_FLG : " + obCntrFlg);
					// 'N' --> 'I'  , 'Y' --> 'O'
					
					// DATA존재시, IN/OUT BOUND 값을 사용한다.
					if(!"".equals(obCntrFlg)) {
						String ioBndCd = "N".equals(obCntrFlg) ? "I" : "O";
						chgPartialPaymentVO.setIoBndCd(ioBndCd);
					}
				}
				
				chgCalcCntrVO.setFmMvmtDt(chgPartialPaymentVO.getFmMvmtDt());
				
				/*
				 "L"(Long Staying), "U"(Unfinished), "N"(No Charge) 인  경우, To Date/Yard를 입력하지 않아도 Re-Calculation 가능
				    즉, To Date를 초기화한다
				 */
				if( chgPartialPaymentVO.getToMvmtDt().length() < 12 ) {
					chgCalcCntrVO.setToMvmtDt("");
				} else {
					chgCalcCntrVO.setToMvmtDt(chgPartialPaymentVO.getToMvmtDt());
				}
				
				// MT Notification된 Data의 경우(To Movement="DR"이고 Web Indicator="Y"), Web Indicator를 "N"으로 Update한다.
				if( ("Y".equals(chgCalcCntrVO.getWebIndFlg()) && "DR".equals(chgCalcCntrVO.getToMvmtStsCd()))
						|| ("Y".equals(chgCalcCntrVO.getWebCancelFlg())) ) {   // <--- Web Cancel 실행시 체크 조건
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
				
				if("Y".equals(chgCalcCntrVO.getDulTpExptFlg())) {
					// [Dual Exception Charge] 처리
					// Combined Charge에 대한 Dual Charge를 조회한다.
					List<ChargeCalculationContainerVO> chgCalcCntrVOs = dbDao.searchDualChargeTariff(chgArgVO);
					
					if(chgCalcCntrVOs != null && chgCalcCntrVOs.size() > 0) {
						String callFlag = null;
						if("Y".equals(chgCalcCntrVO.getWebCancelFlg())) {
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
					if(("Y".equals(chgCalcCntrVO.getCxlBkgChgFlg())) ||
						(("DTOC".equals(chgCalcCntrVO.getDmdtTrfCd()) || "CTOC".equals(chgCalcCntrVO.getDmdtTrfCd())) && "OP".equals(chgCalcCntrVO.getFmMvmtStsCd()) && "MT".equals(chgCalcCntrVO.getToMvmtStsCd()))
						) {
						// [Booking Cancel] 처리
						// CxlBkgChgFlg = "Y" : 이미 Booking Cancel 되었음을 의미한다. (배치 프로그램.)
						// TRF CD("DTOC", "CTOC") && FM ("OP") && To ("MT") 현재 Booking Canecl인 아니지만, 곧 Cancel 된다고 생각하면 된다.(화면에서 입력된 경우)
						
						dmtCancelChargeCalculationUtil	= new DMTCancelChargeCalculationUtil();
						retChgCalcCntrVO = dmtCancelChargeCalculationUtil.cancelChargeCalculation(chgCalcParmVO);
						
						if("-1".equals(retChgCalcCntrVO.getMsgCd()) || "88".equals(retChgCalcCntrVO.getMsgCd())) {
							resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
							resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
							return resultVO;
						}
					} else {
						// From Movement Status가 "DR"이 아니면 General Charge를 계산하고, "DR"이면 Balance Charge를 계산한다
						if(!"DR".equals(chgCalcCntrVO.getFmMvmtStsCd())) {
							dmtGeneralChargeCalculationUtil = new DMTGeneralChargeCalculationUtil();
							retChgCalcCntrVO = dmtGeneralChargeCalculationUtil.generalChargeCalculation(chgCalcParmVO);
							
							if("-1".equals(retChgCalcCntrVO.getMsgCd()) || "88".equals(retChgCalcCntrVO.getMsgCd())) {
								resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						} else {
							dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
							retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
							if("-1".equals(retChgCalcCntrVO.getMsgCd())) {
								resultVO.setResultCode(retChgCalcCntrVO.getMsgCd());
								resultVO.setResultMsg(retChgCalcCntrVO.getMsgDesc());
								return resultVO;
							}
						}
					}
				}
			
				// 위에서 계산한 Operation의 Return값이 0이 아니면 Charge Status를 "E"(Error)로 Setting한다
				if(!"0".equals(retChgCalcCntrVO.getMsgCd())) {
					retChgCalcCntrVO.setDmdtChgStsCd("E");
					chgCalcCntrVO.setCorrRmk(chgCalcCntrVO.getCorrRmk() + " " + retChgCalcCntrVO.getMsgDesc());
				}
				
				// From Movement Status가 "DR"이 아니면 General Charge를 계산하고 Parameter로 받은 Data중 BKG CNTR관련 Data를 BKG CNTR Table에 Data를   Update한다. 
				// 단 Parameter로 받은 Data중 VVD Code가 Null이면 Booking의 Trunk VVD를 조회한다.
//				if(!"DR".equals(chgCalcCntrVO.getFmMvmtStsCd())) {
//					
//					// [vvd code가 null이면] searchVVDCode( bookingNo) 
//					if(chgPartialPaymentVO.getVslCd() == null || chgPartialPaymentVO.getSkdVoyNo() == null
//							|| chgPartialPaymentVO.getSkdDirCd() == null) {
//						
//						String vvdCode = dbDao.searchVVDCode(chgPartialPaymentVO.getBkgNo());
//						// YSEA0006E (4:4:1)
//						if(!"".equals(vvdCode)) {
//							chgPartialPaymentVO.setVslCd(vvdCode.substring(0, 4));
//							chgPartialPaymentVO.setSkdVoyNo(vvdCode.substring(4, 8));
//							chgPartialPaymentVO.setSkdDirCd(vvdCode.substring(8));
//						}
//					}
					
					// ------------ DmtChgBkgCntrVO 객체 구성 -----------------
//					DmtChgBkgCntrVO dmtChgBkgCntrVO = new DmtChgBkgCntrVO();
//					dmtChgBkgCntrVO.setSvrId(chgCalcCntrVO.getSvrId());
//					dmtChgBkgCntrVO.setCntrNo(chgCalcCntrVO.getCntrNo());
//					dmtChgBkgCntrVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
//					
//					dmtChgBkgCntrVO.setBlNo(chgPartialPaymentVO.getBlNo());
//					//--------------- ChargePartialPaymentVO -------------------
//					dmtChgBkgCntrVO.setVslCd(chgPartialPaymentVO.getVslCd());
//					dmtChgBkgCntrVO.setSkdVoyNo(chgPartialPaymentVO.getSkdVoyNo());
//					dmtChgBkgCntrVO.setSkdDirCd(chgPartialPaymentVO.getSkdDirCd());
//					//--------------------------------------------------------
//					dmtChgBkgCntrVO.setVpsEtaDt(retChgCalcCntrVO.getVpsEtaDt());
//					dmtChgBkgCntrVO.setScNo(retChgCalcCntrVO.getBrhScNo());
//					dmtChgBkgCntrVO.setRfaNo(retChgCalcCntrVO.getBrhRfaNo());
//					dmtChgBkgCntrVO.setCmdtCd(retChgCalcCntrVO.getCmdtCd());
//					dmtChgBkgCntrVO.setRepCmdtCd(retChgCalcCntrVO.getRepCmdtCd());
//					dmtChgBkgCntrVO.setDcgoFlg(retChgCalcCntrVO.getDcgoFlg());
//					dmtChgBkgCntrVO.setRcFlg(retChgCalcCntrVO.getRcFlg());
//					dmtChgBkgCntrVO.setBbCgoFlg(retChgCalcCntrVO.getBbCgoFlg());
//					dmtChgBkgCntrVO.setAwkCgoFlg(retChgCalcCntrVO.getAwkCgoFlg());
//					dmtChgBkgCntrVO.setRdCgoFlg(retChgCalcCntrVO.getRdCgoFlg());
//					dmtChgBkgCntrVO.setSocFlg(retChgCalcCntrVO.getSocFlg());
//					dmtChgBkgCntrVO.setCntrPrtFlg(retChgCalcCntrVO.getCntrPrtFlg());
//					dmtChgBkgCntrVO.setAdvShtgCd(retChgCalcCntrVO.getAdvShtgCd());
//					dmtChgBkgCntrVO.setDmdtCntrTpCd(retChgCalcCntrVO.getCntrTp());
//					dmtChgBkgCntrVO.setDmdtBkgCgoTpCd(retChgCalcCntrVO.getDmdtCgoTpCd());
//					dmtChgBkgCntrVO.setPorCd(retChgCalcCntrVO.getPorCd());
//					dmtChgBkgCntrVO.setPolCd(retChgCalcCntrVO.getPolCd());
//					dmtChgBkgCntrVO.setPodCd(retChgCalcCntrVO.getPodCd());
//					dmtChgBkgCntrVO.setDelCd(retChgCalcCntrVO.getDelCd());
//					dmtChgBkgCntrVO.setBkgRcvTermCd(retChgCalcCntrVO.getBbRcvTermCd());
//					dmtChgBkgCntrVO.setBkgDeTermCd(retChgCalcCntrVO.getBbDeTermCd());
//					dmtChgBkgCntrVO.setBkgCntrQty(retChgCalcCntrVO.getBkgQty());
//					dmtChgBkgCntrVO.setSlsOfcCd(retChgCalcCntrVO.getSalOfc());
//					dmtChgBkgCntrVO.setRhqCd(retChgCalcCntrVO.getSalRhq());
//					dmtChgBkgCntrVO.setUpdUsrId(account.getUsr_id());
//					dmtChgBkgCntrVO.setUpdOfcCd(account.getOfc_cd());
//					
//					dbDao.modifyBookingContainer(dmtChgBkgCntrVO);	
//				}
				
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
				//ToMvmtDt가 없는 경우 원래 Data 유지하도록 함. 2011.12.05  김현화
				String retToMvmtDt = retChgCalcCntrVO.getToMvmtDt();

				// nullPointException 발생때문에 수정함. 2012.05.18 김현화				
				if ( retToMvmtDt!= null && !("").equals(retToMvmtDt) ){
					dmtChgCalcVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
				}else{
					dmtChgCalcVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
				}
				
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
				dmtChgCalcVO.setBzcDmdtDeTermCd(retChgCalcCntrVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
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
				dmtChgCalcVO.setUclmFlg(chgCalcCntrVO.getUclmFlg());
				
				// DMT_CHG_BKG_CNTR 최신 Booking 정보를 넣어줌.
				dbDao.modifyBkgCntr(dmtChgCalcVO);

				// 12. 계산된 Cahrge를 Charge Master Table에 Update한다
				dbDao.modifyChargeCalculation(dmtChgCalcVO);
				
				if("Y".equals(chgCalcCntrVO.getDulTpExptFlg())) {
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
				
				chargeResultVOs[i].setFtEndDt(dmtChgCalcVO.getFtEndDt());   //2011.11.30
				
				log.debug("\n[Exception Cost] --------------------------------------------[Start]"  );
				log.debug("\n[Exception Cost] checkScRfaExptApltDt : " + checkScRfaExptApltDt);
				log.debug("\n[Exception Cost] getScRfaExptAplyDt : " + retChgCalcCntrVO.getScRfaExptAplyDt());
				log.debug("\n[Exception Cost] getCntrTpszCd : " + chgCalcParmVO.getCntrTpszCd().substring(0, 1) );
				log.debug("\n[Exception Cost] getDmdtChgStsCd : " + dmtChgCalcVO.getDmdtChgStsCd() );
				log.debug("\n[Exception Cost] getDmdtTrfCd : " + dmtChgCalcVO.getDmdtTrfCd());
				log.debug("\n[Exception Cost] getDulTpExptFlg : " + "Y".equals(dmtChgCalcVO.getDulTpExptFlg()) );
				log.debug("\n[Exception Cost] getChgSeq : " + dmtChgCalcVO.getChgSeq() );
				log.debug("\n[Exception Cost] --------------------------------------------[End]"  );
				
				//Exception Cost를 재계산 로직 추가
				if( (checkScRfaExptApltDt != null || retChgCalcCntrVO.getScRfaExptAplyDt() != null)
					&& ("USA".equals(chgCalcParmVO.getSvrId()) || "EUR".equals(chgCalcParmVO.getSvrId()))
					&& "D".equals(chgCalcParmVO.getCntrTpszCd().substring(0, 1)) //수정
					&& ( "C".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "F".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "I".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "L".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "N".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "U".equals(dmtChgCalcVO.getDmdtChgStsCd())
					     || "D".equals(dmtChgCalcVO.getDmdtChgStsCd())
					    )
					&& (    "DMIF".equals(dmtChgCalcVO.getDmdtTrfCd())
					     || "DTIC".equals(dmtChgCalcVO.getDmdtTrfCd())
					     || "CTIC".equals(dmtChgCalcVO.getDmdtTrfCd())
					    )							     
					&& !("Y".equals(dmtChgCalcVO.getDulTpExptFlg()) && "D".equals(dmtChgCalcVO.getDmdtTrfCd().substring(0, 1)))  //수정
					&& ("1".equals(dmtChgCalcVO.getChgSeq()))
				  )
				{
					DMTExceptionChargeCalculationUtil exceptionChargeCalculationUtil = new DMTExceptionChargeCalculationUtil();
					ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();

					chargeCalculationParmVO.setBkgNo(chgCalcParmVO.getBkgNo());
					chargeCalculationParmVO.setSvrId(chgCalcParmVO.getSvrId()); //수정
					chargeCalculationParmVO.setCntrNo(chgCalcParmVO.getCntrNo());
					chargeCalculationParmVO.setCntrCycNo(String.valueOf(chgCalcParmVO.getCntrCycNo()));
					chargeCalculationParmVO.setDmdtTrfCd(chgCalcParmVO.getDmdtTrfCd());
					chargeCalculationParmVO.setDmdtChgLocDivCd(chgCalcParmVO.getDmdtChgLocDivCd());
					chargeCalculationParmVO.setChgSeq(String.valueOf(chgCalcParmVO.getChgSeq()));
					chargeCalculationParmVO.setDmdtChgStsCd(dmtChgCalcVO.getDmdtChgStsCd());
					chargeCalculationParmVO.setFmMvmtDt(chgCalcParmVO.getFmMvmtDt());
					chargeCalculationParmVO.setFmMvmtYdCd(chgCalcParmVO.getFmMvmtYdCd());
					chargeCalculationParmVO.setFmMvmtStsCd(chgCalcParmVO.getFmMvmtStsCd());
					chargeCalculationParmVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
					chargeCalculationParmVO.setToMvmtYdCd(retChgCalcCntrVO.getToMvmtYdCd());
					chargeCalculationParmVO.setToMvmtStsCd(retChgCalcCntrVO.getToMvmtStsCd());
					chargeCalculationParmVO.setDmdtTrfAplyTpCd(retChgCalcCntrVO.getDmdtTrfAplyTpCd());
					chargeCalculationParmVO.setBzcTrfSeq(String.valueOf(retChgCalcCntrVO.getBzcTrfSeq()));
					chargeCalculationParmVO.setBzcDmdtDeTermCd(retChgCalcCntrVO.getBzcDmdtDeTermCd());	// dmdt_de_term_cd
					chargeCalculationParmVO.setBzcTrfGrpSeq(String.valueOf(retChgCalcCntrVO.getBzcTrfGrpSeq()));
					chargeCalculationParmVO.setRfaExptDarNo(retChgCalcCntrVO.getRfaExptDarNo());
					chargeCalculationParmVO.setRfaExptMapgSeq(String.valueOf(retChgCalcCntrVO.getRfaExptMapgSeq()));
					chargeCalculationParmVO.setRfaExptVerSeq(String.valueOf(retChgCalcCntrVO.getRfaExptVerSeq()));
					chargeCalculationParmVO.setRfaRqstDtlSeq(String.valueOf(retChgCalcCntrVO.getRfaRqstDtlSeq()));
					chargeCalculationParmVO.setScNo(retChgCalcCntrVO.getScNo());
					chargeCalculationParmVO.setScExptVerSeq(String.valueOf(retChgCalcCntrVO.getScExptVerSeq()));
					chargeCalculationParmVO.setScExptGrpSeq(String.valueOf(retChgCalcCntrVO.getScExptGrpSeq()));
					chargeCalculationParmVO.setCntrTpszCd(chgCalcParmVO.getCntrTpszCd());
					chargeCalculationParmVO.setIoBndCd(chgCalcParmVO.getIoBndCd());
					chargeCalculationParmVO.setOfcCd(retChgCalcCntrVO.getOfcCd());
					chargeCalculationParmVO.setDulTpExptFlg(chgCalcParmVO.getDulTpExptFlg());
					chargeCalculationParmVO.setCgoTpCd(chgCalcParmVO.getCgoTpCd());

					ExceptionChargeCalculationVO exceptionChargeCalculationVO = null;
					exceptionChargeCalculationVO = exceptionChargeCalculationUtil.exceptionChargeCalculation(chargeCalculationParmVO);

					exceptionChargeCalculationVO.setBkgNo(chgCalcParmVO.getBkgNo());
					exceptionChargeCalculationVO.setCntrNo(chgCalcParmVO.getCntrNo());
					exceptionChargeCalculationVO.setCntrCycNo(String.valueOf(chgCalcParmVO.getCntrCycNo()));
					exceptionChargeCalculationVO.setDmdtTrfCd(chgCalcParmVO.getDmdtTrfCd());
					exceptionChargeCalculationVO.setDmdtChgLocDivCd(chgCalcParmVO.getDmdtChgLocDivCd());
					exceptionChargeCalculationVO.setChgSeq(String.valueOf(chgCalcParmVO.getChgSeq()));
					exceptionChargeCalculationVO.setDmdtChgStsCd(dmtChgCalcVO.getDmdtChgStsCd());
					
					exceptionChargeCalculationVO.setOfcCd(retChgCalcCntrVO.getOfcCd());
					exceptionChargeCalculationVO.setCntrTpszCd(chgCalcParmVO.getCntrTpszCd());
					exceptionChargeCalculationVO.setUpdUsrId(account.getUsr_id());
					exceptionChargeCalculationVO.setUpdOfcCd(account.getOfc_cd());

					dbDao.mergeDmtExceptionChargeCalculation(exceptionChargeCalculationVO);
				}
			}
			
			resultVO.setChargeCalculationContainerVOArray(chargeResultVOs);//2011.11.30
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
	 * EDOCharge Free time End date 변경된 경우 EDI 정보를 전송 합니다.<br>
	 * @param List<EDIVO> ftEndDtEDIVOs
	 * @throws EventException
	 */
	
	public void sendEDOChargeFreeTime(List<EDIVO> ftEndDtEDIVOs) throws EventException {

	    	List<EdoEdiTransVO> list = new ArrayList<EdoEdiTransVO>();
		    CargoReleaseOrderBC cargoReleaseOrderBC	= new CargoReleaseOrderBCImpl();
		   
		try {
			if (ftEndDtEDIVOs != null && ftEndDtEDIVOs.size() > 0) {
	
				for (int i = 0 ; i < ftEndDtEDIVOs.size() ; i++) {
								
					String bkgNo = ftEndDtEDIVOs.get(i).getBkgNo();
					String ftEndDt = ftEndDtEDIVOs.get(i).getFtEndDt();
					String cntrNo = ftEndDtEDIVOs.get(i).getCntrNo();
					EdoEdiTransVO edoEdiTransVO = new EdoEdiTransVO();
					int n = 0;
				
					String sendFg = dbDao.checkEDOChargeFreeTime(bkgNo, ftEndDt, cntrNo);


					if (sendFg == null || "N".equals(sendFg)) continue;
					
					for(int j = 0 ; j < i ; j++){
					  if (( i > 0) && (i > j)){
                        if ( bkgNo.equals(ftEndDtEDIVOs.get(j).getBkgNo())){
                        	  if ("Y".equals(sendFg)){
							       n++;
                        	   }
						     }
						 }
					}
					if ( n >= 1 ) continue;
				
					
					//EDI 로 보낼 정보를 설정한다.
					edoEdiTransVO.setBkgNo(ftEndDtEDIVOs.get(i).getBkgNo()); 
					edoEdiTransVO.setEdoAckCd( "A"	);  // =>  고정값
					edoEdiTransVO.setEdoTpCd("5JN");	//=> 고정값
					edoEdiTransVO.setAcount(ftEndDtEDIVOs.get(i).getAcount());	
			
				    list.add(edoEdiTransVO);

				}
				//EDI 로 전송한다.
				
	                int arrLength = list.size();
	                
					EdoEdiTransVO[] edoEdiTrans = new EdoEdiTransVO[arrLength];
	                for(int k=0; k < arrLength ; k++){
	                	edoEdiTrans[k] = list.get(k);
	                }
	               // log.debug("DMT===<<<<<<<==transmitEdiByEdoDmt ")	;
	               // 2011.11.22 KOR EDO 기능 막음. 2011.11.28 다시 오픈
				    cargoReleaseOrderBC.transmitEdiByEdoDmt(edoEdiTrans);		
				 
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
	 *  OP-MT Detention Inquiry Charge List를 조회한다.<br>
	 * 
	 * @param OPMTChargeParmVO oPMTChargeParmVO
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchOPMTChargeListbyInquiry(OPMTChargeParmVO oPMTChargeParmVO) 
		throws EventException {
		try {
			return dbDao.searchOPMTChargeListbyInquiry(oPMTChargeParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"OP-MT Detention Charge List by Inquiry"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"OP-MT Detention Charge List by Inquiry"}).getMessage());
		}
	}
	
	/**
	 * OP-MT Detention Calculation Charge List를 조회한다<br>
	 * 
	 * @param OPMTChargeParmVO oPMTChargeParmVO
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchOPMTChargeListbyCalculation(OPMTChargeParmVO oPMTChargeParmVO) throws EventException {
		try {
			return dbDao.searchOPMTChargeListbyCalculation(oPMTChargeParmVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"OP-MT Detention Charge List by Calculation"}).getMessage());
		} catch (Exception ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"OP-MT Detention Charge List by Calculation"}).getMessage());
		}
	}
	
	/**
	 * DMT Booking, Container & Charge 정보를 조회한다<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return ChargeCalculationContainerVO
	 * @exception EventException
	 */
	public ChargeCalculationContainerVO searchBookingNChargeInfo(ChargeArgumentVO chargeArgumentVO) throws EventException {
		try {
			return dbDao.searchChargeByContainer(chargeArgumentVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"DMT Booking, Container and Charge Information"}).getMessage());
		} catch (Exception ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"DMT Booking, Container and Charge Information"}).getMessage());
		}
	}
	
	/**
	 * DMT Booking SUM Charge 정보를 조회한다 ( DTOC, DMOF )<br>
	 * @param bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String searchBookingChargeOB(String bkgNo) throws EventException {
		try {
			return dbDao.searchBookingChargeOB(bkgNo);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"DMT Booking Charge SUM (DTOC, DMOF)"}).getMessage());
		} catch (Exception ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"DMT Booking Charge SUM (DTOC, DMOF)"}).getMessage());
		}
	}
	
	//###############################################< CHM-201533804 [DMT] Deletion Setup 화면 개발 영역 [S] >###############################################	
	/**
	 * Deletion Authority Setup 에 등록된 승인경로정보 조회
	 * @param SearchChgDeltPathStupVO searchChgDeltPathStupVO
	 * @return List<ChgDeltPathStupVO>
	 * @throws EventException
	 */	
	public List<ChgDeltPathStupVO> searchChargeDeletionPathSetupList(SearchChgDeltPathStupVO searchChgDeltPathStupVO) throws EventException {

		try {
			return dbDao.searchChargeDeletionPathSetupList(searchChgDeltPathStupVO);
		} 
		catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"charge deletion path setup list"}).getUserMessage());
		} 
		catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"charge deletion path setup list"}).getUserMessage());
		}
	}
	
	/**
	 * Deletion Authority Setup 메뉴에서 등록 및 수정, 삭제된 설정정보에 대한 트랜잭션처리를 관리합니다. <br> 
	 * 
	 * @param ChgDeltPathStupVO[] chgDeltPathStupVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageChargeDeletionPathSetup(ChgDeltPathStupVO[] chgDeltPathStupVOs, SignOnUserAccount account) throws EventException {
		
		try {
			List<ChgDeltPathStupVO> insertVoList 	= new ArrayList<ChgDeltPathStupVO>();
			List<ChgDeltPathStupVO> deleteVoList	= new ArrayList<ChgDeltPathStupVO>();
			List<ChgDeltPathStupVO> updateVoList 	= new ArrayList<ChgDeltPathStupVO>();
			List<ChgDeltPathStupVO> historyVoList	= new ArrayList<ChgDeltPathStupVO>();
			
			if (chgDeltPathStupVOs != null) {
				
				for (ChgDeltPathStupVO chgDeltPathStupVO : chgDeltPathStupVOs) {
					
					chgDeltPathStupVO.setCreUsrId(account.getUsr_id());
					chgDeltPathStupVO.setCreOfcCd(account.getOfc_cd());
					chgDeltPathStupVO.setUpdUsrId(account.getUsr_id());
					chgDeltPathStupVO.setUpdOfcCd(account.getOfc_cd());
					
					// 트랜잭션별로 데이터를 분리한다.
					if ("D".equals(chgDeltPathStupVO.getIbflag())) {

						deleteVoList.add(chgDeltPathStupVO);
					} 
					else if("I".equals(chgDeltPathStupVO.getIbflag())) {		
						
						insertVoList.add(chgDeltPathStupVO);
					} 
					else if("U".equals(chgDeltPathStupVO.getIbflag())) {
						
						updateVoList.add(chgDeltPathStupVO);
					}
				}
				
				// 필수입력여부는 신규, 수정항목에 대해서, 유효성 체크(DB조회) 는 신규 항목에 대해서만 실행합니다.
				if (insertVoList.size() > 0 || updateVoList.size() > 0) {
					log.debug("\n[manageDeletionAuthoritySetup] >>>>>. 필수입력여부 체크");
					
					// 1. 필수입력항목에 대한 체크를 실행합니다.
					// 1.1 신규입력항목
					this.checkMandatoryChargeDeletionPathSetup(insertVoList);
					// 1.2 기존입력항목
					this.checkMandatoryChargeDeletionPathSetup(updateVoList);
					
					log.debug("\n[manageDeletionAuthoritySetup] >>>>>. 입력값 유효성 체크(중복체크)");
					// 2. 입력된 항목에 대한 유효성 체크를 실행합니다.(중복체크)
					this.checkValidateChargeDeletionPathSetup(insertVoList);
				}
				
				// 이력 정보 관리
				historyVoList.addAll(deleteVoList);
				historyVoList.addAll(updateVoList);
				
				// 이력을 생성한다.
				if (historyVoList.size() > 0) {
					//>>. Deletion Authority Setup History Sequence 설정
					this.setChargeDeletionPathSetupHistorySeq(historyVoList);
					
					dbDao.addChargeDeletionPathSetupHistory(historyVoList);
					dbDao.addChargeDeletionOfficeSetupHistory(historyVoList);	
				}
				
				// 삭제작업을 제일 먼저 실행한다.
				if (deleteVoList.size() > 0) { 	//삭제

					//실제 데이터 삭제
					dbDao.removeChargeDeletionOfficeSetup(deleteVoList);
					dbDao.removeChargeDeletionPathSetup(deleteVoList);
				}
				
				// 변경작업을 실행한다.
				if (updateVoList.size() > 0) { 	//수정

					//실제 데이터 수정
					dbDao.modifyChargeDeletionPathSetup(updateVoList);			//마스터 정보 수정				
				}	
				// 등록작업을 실행한다.
				if (insertVoList.size() > 0) { //등록
					//>>. Deletion Authority Setup Sequence 설정
					this.setChargeDeletionPathSetupSeq(insertVoList);
					
					dbDao.addChargeDeletionPathSetup(insertVoList);
					dbDao.addChargeDeletionOfficeSetup(this.getDeltAuthOfcStupVOList(insertVoList));
				}				
			}
		} 
		catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"charge deletion path setup"}).getUserMessage());
		} 
		catch (EventException ex) {
			log.error(ex.getMessage());
			throw ex;
		}		
		catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"charge deletion path setup"}).getUserMessage());
		}	
	}
	
	/**
	 * 필수입력항목에 대한 체크를 수행합니다. <br> 
	 * 
	 * @param List<ChgDeltPathStupVO> chgDeltPathStupVOList
	 * @exception EventException
	 */	
	private void checkMandatoryChargeDeletionPathSetup(List<ChgDeltPathStupVO> chgDeltPathStupVOList) throws EventException {
		
		try {		
			// 필수입력체크
			for (ChgDeltPathStupVO chgDeltPathStupVO : chgDeltPathStupVOList) {
				
				//>. Effective Date 입력값 체크
				if (StringUtil.isEmpty(chgDeltPathStupVO.getEffDt())) {
					//>. 업무예외발생
					//>. DMT02046 : {?msg1} is mandatory. Please enter {?msg1}.
					throw new EventException(new ErrorHandler("DMT02046", new String[]{"Eff DT", "Eff DT"}).getUserMessage());
				}
				//>. RHQ 입력값 체크
				if (StringUtil.isEmpty(chgDeltPathStupVO.getChgDeltRhqCd())) {
					//>. 업무예외발생
					//>. DMT02046 : {?msg1} is mandatory. Please enter {?msg1}.
					throw new EventException(new ErrorHandler("DMT02046", new String[]{"RHQ", "RHQ"}).getUserMessage());
				}
				//>. OFC 입력값 체크
				if (StringUtil.isEmpty(chgDeltPathStupVO.getChgDeltOfcCd())) {
					//>. 업무예외발생
					//>. DMT02046 : {?msg1} is mandatory. Please enter {?msg1}.
					throw new EventException(new ErrorHandler("DMT02046", new String[]{"OFC", "OFC"}).getUserMessage());
				}			
				//>. BBG, RHQ, SELHO 선택 항목 중 1개 이상 선택여부 체크
				if (StringUtil.isEmpty(chgDeltPathStupVO.getDmdtBrncFlg()) 
					&& StringUtil.isEmpty(chgDeltPathStupVO.getDmdtRhqFlg())
					&& StringUtil.isEmpty(chgDeltPathStupVO.getDmdtHoFlg())) {
					//>. 업무예외발생
					//>. DMT02046 : {?msg1} is mandatory. Please enter {?msg1}.
					throw new EventException(new ErrorHandler("DMT02046", new String[]{"BBG or RHQ or SELHO", "BBG or RHQ or SELHO"}).getUserMessage());
				}
				
				//>. Expiration Date 입력시 Effective Date 와의 유효성 체크
				if (!StringUtils.isEmpty(chgDeltPathStupVO.getExpDt())) {
					SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
					
			       Date effDt = date.parse(chgDeltPathStupVO.getEffDt());  
	               Date expDt = date.parse(chgDeltPathStupVO.getExpDt());
	      
	                if (!expDt.after(effDt)) {
						//>. 업무예외발생
	                	//>. DMT02046 : {?msg1} must be less than {?msg1}.
						throw new EventException(new ErrorHandler("DMT02047", new String[]{"Eff DT", "Exp DT"}).getUserMessage());
	                }
				}
			}
		}
		catch (EventException ex) {
			log.error(ex.getMessage());
			throw ex;
		}
		catch (Exception ex) {
			log.error(ex.getMessage());
			// DMT00003 : Failed to save $s. Please try it again.
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"during checking mandatory"}).getUserMessage());
		}			
	}
	
	/**
	 * 입력항목값에 대한 유효성 체크를 수행합니다. <br> 
	 * 
	 * @param List<ChgDeltPathStupVO> chgDeltPathStupVOList
	 * @exception EventException
	 */	
	private void checkValidateChargeDeletionPathSetup(List<ChgDeltPathStupVO> chgDeltPathStupVOList) throws EventException {
		
		try {
			// 유효입력체크
			for (ChgDeltPathStupVO chgDeltPathStupVO : chgDeltPathStupVOList) {
				
				//>. 중복입력여부 체크
				if (dbDao.isDuplicateChargeDeletionPathSetup(chgDeltPathStupVO)) {
					
					String dupOfcCds = dbDao.searchDuplicateChargeDeletionOffice(chgDeltPathStupVO);
					
					StringBuilder sb = new StringBuilder();
					sb.append("\n");
//					sb.append("     ").append("Eff DT").append(" = '").append(chgDeltPathStupVO.getEffDt()).append("'").append("\n");
//					sb.append("     ").append("Exp DT").append(" = '").append(StringUtils.defaultIfEmpty(chgDeltPathStupVO.getExpDt(), "")).append("'").append("\n");
//					sb.append("     ").append("RHQ").append(" = '").append(chgDeltPathStupVO.getChgDeltRhqCd()).append("'").append("\n");
					sb.append("     ").append("Duplicate Office").append(" = [").append(dupOfcCds).append("]");
					//>. 업무예외발생
					//>. DMT02048 : The duplicated data exists.{?msg1}
					throw new EventException(new ErrorHandler("DMT02048", new String[]{sb.toString()}).getUserMessage());
				}
			}
		}
		catch (DAOException ex) {
			log.error(ex.getMessage());
			// DMT00003 : Failed to save $s. Please try it again.
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"during checking duplicate input"}).getUserMessage());
		} 
		catch (EventException ex) {
			log.error(ex.getMessage());
			throw ex;
		}		
		catch (Exception ex) {
			log.error(ex.getMessage());
			// DMT00003 : Failed to retrieve $s. Please try it again.
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"during checking duplicate input"}).getUserMessage());
		}		
	}
	
	/**
	 * Deletion Authority Office Setup Sequence 를 설정합니다. <br> 
	 * 
	 * @param List<DeltAuthStupVO> insertVoList
	 * @exception EventException
	 */		
	private void setChargeDeletionPathSetupHistorySeq(List<ChgDeltPathStupVO> chgDeltPathStupVOList) throws EventException {
		
		try {
			for (ChgDeltPathStupVO chgDeltPathStupVO : chgDeltPathStupVOList) {
				
				// Deletion Authority Setup History Sequence 추출
				long seq = dbDao.searchChargeDeletionPathSetupHistorySeq(chgDeltPathStupVO);
				chgDeltPathStupVO.setChgDeltPathStupHisSeq(String.valueOf(seq));
			}
		}
		catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"during setting charge deletion path history sequence"}).getUserMessage());
		} 
		catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"during setting charge deletion path history sequence"}).getUserMessage());
		}		
	}
	
	/**
	 * Deletion Authority Setup Sequence 를 설정합니다. <br> 
	 * 
	 * @param List<ChgDeltPathStupVO> chgDeltPathStupVOList
	 * @exception EventException
	 */		
	private void setChargeDeletionPathSetupSeq(List<ChgDeltPathStupVO> chgDeltPathStupVOList) throws EventException {
		
		try {
			// Deletion Authority Setup Sequence 추출
			long seq = dbDao.searchChargeDeletionPathSetupSeq();
			
			for (ChgDeltPathStupVO chgDeltPathStupVO : chgDeltPathStupVOList) {
				chgDeltPathStupVO.setChgDeltPathStupSeq(String.valueOf(seq));
				seq++;
			}
		}
		catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"during setting charge deletion path sequence"}).getUserMessage());
		} 
		catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"during setting charge deletion path sequence"}).getUserMessage());
		}		
	}
	
	/**
	 * Deletion Authority Setup Sequence 를 설정합니다. <br> 
	 * 
	 * @param List<ChgDeltPathStupVO> chgDeltPathStupVOList
	 * @return List<DeltAuthOfcStupVO>
	 * @exception EventException
	 */		
	private List<ChgDeltOfcStupVO> getDeltAuthOfcStupVOList(List<ChgDeltPathStupVO> chgDeltPathStupVOList) throws EventException {
		List<ChgDeltOfcStupVO> chgDeltOfcStupVOList = new ArrayList<ChgDeltOfcStupVO>();
		
		ChgDeltOfcStupVO chgDeltOfcStupVO = new ChgDeltOfcStupVO();
		
		for (ChgDeltPathStupVO chgDeltPathStupVO : chgDeltPathStupVOList) {
			String[] arrOfcCd = chgDeltPathStupVO.getChgDeltOfcCd().split(",");
			
			for (String ofcCd : arrOfcCd) {
				chgDeltOfcStupVO = new ChgDeltOfcStupVO();
				chgDeltOfcStupVO.setChgDeltPathStupSeq(chgDeltPathStupVO.getChgDeltPathStupSeq());
				chgDeltOfcStupVO.setChgDeltOfcCd(ofcCd);
				chgDeltOfcStupVO.setCreUsrId(chgDeltPathStupVO.getCreUsrId());
				chgDeltOfcStupVO.setCreOfcCd(chgDeltPathStupVO.getCreOfcCd());
				chgDeltOfcStupVO.setUpdUsrId(chgDeltPathStupVO.getUpdUsrId());
				chgDeltOfcStupVO.setUpdOfcCd(chgDeltPathStupVO.getUpdOfcCd());
				chgDeltOfcStupVOList.add(chgDeltOfcStupVO);
			}
		}
		
		return chgDeltOfcStupVOList;
	}	
	
	/**
	 * Charge Deletion 요청시 첨부한 파일을 등록한다. <br>
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */	
	private void addChargeDeletionRequestFile(ChargeCalculationContainerVO chgCalcCntrVO, ChargeInactivFileVO[] chargeInactivFileVOs, SignOnUserAccount account) throws EventException {
		
		List<ChgDeltRqstFileVO> chgDeltRqstFileVOList = new ArrayList<ChgDeltRqstFileVO>();
		ChgDeltRqstFileVO chgDeltRqstFileVO = new ChgDeltRqstFileVO();
		
		ChgDeltRqstFileVO deltFileVO  = new ChgDeltRqstFileVO();
		
		try {
			
			deltFileVO.setSysAreaGrpId(chgCalcCntrVO.getSvrId());
			deltFileVO.setCntrNo(chgCalcCntrVO.getCntrNo());
			deltFileVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
			deltFileVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
			deltFileVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
			deltFileVO.setChgSeq(chgCalcCntrVO.getChgSeq());
			deltFileVO.setChgOfcCd(chgCalcCntrVO.getChgOfcCd());
			deltFileVO.setDeltSeq(chgCalcCntrVO.getDeltSeq());			

			dbDao.deleteChargeDeletionRequestFile(deltFileVO);
			
			String[] fileSavIds = chgCalcCntrVO.getFileSavId().split(",");
			
			for (String fileSavId : fileSavIds) {
				chgDeltRqstFileVO = new ChgDeltRqstFileVO();
				chgDeltRqstFileVO.setSysAreaGrpId(chgCalcCntrVO.getSvrId());
				chgDeltRqstFileVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chgDeltRqstFileVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chgDeltRqstFileVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chgDeltRqstFileVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chgDeltRqstFileVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				chgDeltRqstFileVO.setChgOfcCd(chgCalcCntrVO.getChgOfcCd());
				chgDeltRqstFileVO.setDeltSeq(chgCalcCntrVO.getDeltSeq());
				chgDeltRqstFileVO.setFileSavId(fileSavId);
				chgDeltRqstFileVO.setCreUsrId(account.getUsr_id());
				chgDeltRqstFileVO.setCreOfcCd(account.getOfc_cd());
				chgDeltRqstFileVO.setUpdUsrId(account.getUsr_id());
				chgDeltRqstFileVO.setUpdOfcCd(account.getOfc_cd());	

				if ( !"".equals(fileSavId) )
					chgDeltRqstFileVOList.add(chgDeltRqstFileVO);					
			}
			
			if ( chargeInactivFileVOs != null && chargeInactivFileVOs.length > 0 ){
				for (ChargeInactivFileVO FileVOs : chargeInactivFileVOs) {
					chgDeltRqstFileVO = new ChgDeltRqstFileVO();
					chgDeltRqstFileVO.setSysAreaGrpId(chgCalcCntrVO.getSvrId());
					chgDeltRqstFileVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					chgDeltRqstFileVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					chgDeltRqstFileVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					chgDeltRqstFileVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					chgDeltRqstFileVO.setChgSeq(chgCalcCntrVO.getChgSeq());
					chgDeltRqstFileVO.setChgOfcCd(chgCalcCntrVO.getChgOfcCd());
					chgDeltRqstFileVO.setDeltSeq(chgCalcCntrVO.getDeltSeq());
					chgDeltRqstFileVO.setFileSavId(FileVOs.getFileSavId());
					chgDeltRqstFileVO.setCreUsrId(account.getUsr_id());
					chgDeltRqstFileVO.setCreOfcCd(account.getOfc_cd());
					chgDeltRqstFileVO.setUpdUsrId(account.getUsr_id());
					chgDeltRqstFileVO.setUpdOfcCd(account.getOfc_cd());	
					
					if ( !"".equals(FileVOs.getFileSavId()) )
						chgDeltRqstFileVOList.add(chgDeltRqstFileVO);
				}
			}
			
			if (chgDeltRqstFileVOList.size() > 0) {
				dbDao.addChargeDeletionRequestFile(chgDeltRqstFileVOList);
			}
		}
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"attached file for charge deletion"}).getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"attached file for charge deletion"}).getMessage());
		}		
	}
	
	/**
	 * Charge Deletion 요청을 처리하기 위한 승인경로정보를 설정한다. <br>
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */	
	private void addChargeDeletionPathSetup(ChargeCalculationContainerVO chgCalcCntrVO, SignOnUserAccount account) throws EventException {
		
		try {
			// 1. Charge Deletion 승인처리를 위해 필요한 승인경로정보를 조회한다. 존재하지 않을 경우, 업무예외를 발생한다.
			SearchChgDeltPathStupVO searchChgDeltPathStupVO = new SearchChgDeltPathStupVO();
			searchChgDeltPathStupVO.setChgDeltOfcCd(account.getOfc_cd());
			searchChgDeltPathStupVO.setCrntFlg("Y");
			
			List<ChgDeltPathStupVO> chgDeltPathStupVOList = dbDao.searchChargeDeletionPathSetupList(searchChgDeltPathStupVO);
			// 해당 승인경로가 존재하지 않을 경우 
			if (chgDeltPathStupVOList == null || chgDeltPathStupVOList.size() == 0) {
				// >> 업무예외 발생
				// >> DMT02049 : [$s] does not exist!  Please check up Again!
				throw new EventException(new ErrorHandler("DMT02049", new String[]{"Deletion Authority Setup"}).getMessage());
			}
			
			// 2. Charge Deletion Approval Path 정보를 등록한다.
			// >> 2.1 Charge Deletion Approval Path 정보를 구성한다.
			List<ChgDeltPathVO> chgDeltPathVOList = this.getChargeDeletionPath(chgCalcCntrVO, chgDeltPathStupVOList.get(0), account);
			// >> 2.2 Charge Deletion Approval Path 정보를 등록한다.
			dbDao.addChargeDeletionPath(chgDeltPathVOList);
			
//			// 3. Charge Deletion Approval Path 별로 Charge Deletion Approval User 정보를 등록한다.
//			// >> 3.1 Charge Deletion Approval User 정보를 구성한다.
//			List<ChgDeltUsrVO> chgDeltUsrVOList = this.getChargeDeletionUser(chgDeltPathVOList);
//			// >> 3.2 Charge Deletion Approval User 정보를 등록한다.
//			dbDao.addChargeDeletionUser(chgDeltUsrVOList);
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"charge deletion path setup"}).getMessage());
		} 
		catch (EventException ex) {
			log.error("[EventException]"+ex.getMessage());
			throw ex;
		} 		
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"charge deletion path setup"}).getMessage());
		}
	}
	
	/**
	 * Charge Deletion 승인경로설정정보로 승인처리를 위해 필요한 승인단계정보를 생성한다. <br>
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @param ChgDeltPathStupVO chgDeltPathStupVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */		
	private List<ChgDeltPathVO> getChargeDeletionPath(ChargeCalculationContainerVO chgCalcCntrVO, ChgDeltPathStupVO chgDeltPathStupVO, SignOnUserAccount account) throws EventException {
		
		List<ChgDeltPathVO> chgDeltPathVOList = new ArrayList<ChgDeltPathVO>();
		ChgDeltPathVO chgDeltPathVO = new ChgDeltPathVO();
		
		int iPathCnt = 4;	//1:OOM(OFC O.Manager), 2:BBG, 3:RHQ, 4:SELHO
		for (int i = 1; i <= iPathCnt; i++) {
			chgDeltPathVO = new ChgDeltPathVO();
			
			chgDeltPathVO.setSysAreaGrpId(chgCalcCntrVO.getSvrId());
			chgDeltPathVO.setCntrNo(chgCalcCntrVO.getCntrNo());
			chgDeltPathVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
			chgDeltPathVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
			chgDeltPathVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
			chgDeltPathVO.setChgSeq(chgCalcCntrVO.getChgSeq());
			chgDeltPathVO.setChgOfcCd(chgCalcCntrVO.getChgOfcCd());
			chgDeltPathVO.setDeltSeq(chgCalcCntrVO.getDeltSeq());
			chgDeltPathVO.setChgDeltPathCd(this.getChgDeltPathCd(i));
			chgDeltPathVO.setChgDeltPathLvl(String.valueOf(i));
			chgDeltPathVO.setChgDeltStsCd(" ");
			chgDeltPathVO.setChgDeltPathCplsFlg(this.getChgDeltPathCplsFlg(chgDeltPathStupVO, i));	
			chgDeltPathVO.setCreUsrId(account.getUsr_id());
			chgDeltPathVO.setCreOfcCd(account.getOfc_cd());
			chgDeltPathVO.setUpdUsrId(account.getUsr_id());
			chgDeltPathVO.setUpdOfcCd(account.getOfc_cd());	
			
			chgDeltPathVOList.add(chgDeltPathVO);
		}
		
		return chgDeltPathVOList;
	}
	
//	/**
//	 * Charge Deletion 승인경로설정정보로 승인처리를 위해 필요한 승인단계별 승인자정보를 생성한다. <br>
//	 * @param ChgDeltPathVO chgDeltPathVO
//	 * @throws EventException
//	 */		
//	private List<ChgDeltUsrVO> getChargeDeletionUser(List<ChgDeltPathVO> chgDeltPathVOList) throws EventException {
//
//		List<ChgDeltUsrVO> chgDeltUsrVOList = new ArrayList<ChgDeltUsrVO>();
//		
//		try {
//			// 승인단계별 승인권한자를 조회한다.
//			for (ChgDeltPathVO chgDeltPathVO : chgDeltPathVOList) {
//				chgDeltUsrVOList.addAll(dbDao.searchChargeDeletionUserListByPath(chgDeltPathVO));
//			}
//		}
//		catch (DAOException ex) {
//			log.error("[DAOException]"+ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00003", new String[]{""}).getMessage());
//		} 
//		catch (Exception ex) {
//			log.error("[Exception]"+ex.getMessage());
//			throw new EventException(new ErrorHandler("DMT00003", new String[]{""}).getMessage());
//		}
//
//		return chgDeltUsrVOList;
//	}
	
	/**
	 * Charge Deletion 승인경로레벨별 승인경로코드를 반환한다. <br>
	 * @param int iChgDeltPathLvl
	 * @return  chgDeltPathCd
	 */			
	private String getChgDeltPathCd(int iChgDeltPathLvl) {
		String chgDeltPathCd = "";
		
		switch (iChgDeltPathLvl) {
		case 1: chgDeltPathCd = "OOM"; break;
		case 2: chgDeltPathCd = "BBG"; break;
		case 3: chgDeltPathCd = "RHQ"; break;
		case 4: chgDeltPathCd = "HDO"; break;
		}
		
		return chgDeltPathCd;
	}
	
	/**
	 * Charge Deletion 승인경로레벨별 필수여부코드를 반환한다. <br>
	 * @param ChgDeltPathStupVO chgDeltPathStupVO
	 * @param int iChgDeltPathLvl
	 * @return  chgDeltPathCd
	 */		
	private String getChgDeltPathCplsFlg(ChgDeltPathStupVO chgDeltPathStupVO, int iChgDeltPathLvl) {
		String chgDeltPathCplsFlg = "";
		
		switch (iChgDeltPathLvl) {
		case 1: chgDeltPathCplsFlg = "1".equals(chgDeltPathStupVO.getDmdtBrncOfcOpMgrFlg()) ? "Y" : "N"; break;
		case 2: chgDeltPathCplsFlg = "1".equals(chgDeltPathStupVO.getDmdtBrncFlg())         ? "Y" : "N"; break;
		case 3: chgDeltPathCplsFlg = "1".equals(chgDeltPathStupVO.getDmdtRhqFlg())          ? "Y" : "N"; break;
		case 4: chgDeltPathCplsFlg = "1".equals(chgDeltPathStupVO.getDmdtHoFlg())           ? "Y" : "N"; break;
		}
		
		return chgDeltPathCplsFlg;		
	}
	
	/**
	 * Charge Deletion 승인처리 전 승인권한과 승인상태의 유효여부를 체크합니다. <br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void checkChargeDeletionValidation(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
		throws EventException {
		
		String chgDeltPathCd = "";
		try {
			
			chgDeltPathCd = chargeCalculationContainerVOs[0].getChgDeltPathCd();
			log.debug("\n[checkChargeDeletionValidation] STEP-START");
			for (ChargeCalculationContainerVO chgCalcCntrVO : chargeCalculationContainerVOs) {
				
				chgCalcCntrVO.setChgDeltUsrId(account.getUsr_id());
				chgCalcCntrVO.setCreUsrId(account.getUsr_id());
				chgCalcCntrVO.setCreOfcCd(account.getOfc_cd());
				chgCalcCntrVO.setChgDeltPathCd(chgDeltPathCd);
				
				log.debug("\n[checkChargeDeletionValidation] STEP-1 : 승인경로 존재여부 체크");
				//STEP-1. 해당 Charge Deletion 요청건에 대한 승인경로가 존재하는지 여부를 체크한다.
				if (!dbDao.isExistsChargeDeltApprovalPath(chgCalcCntrVO)) {
					//승인경로가 없습니다.
					throw new EventException(new ErrorHandler("DMT06036", new String[]{""}).getMessage());
				}
				
				log.debug("\n[승인처리 전 유효성체크] STEP-2 : 승인권한 존재여부 체크( 입력승인권한 : " + chgCalcCntrVO.getChgDeltPathCd() + ")");
				//STEP-2. 승인권한자인지 여부를 체크한다.
				if ("OOM".equals(chgCalcCntrVO.getChgDeltPathCd())) {
					// OOM 승인권한자가 아닐 경우, 업무예외 발생
					if (!dbDao.isChargeDeletionOOMAuth(account.getUsr_id(), account.getOfc_cd())) {
						log.debug("\n[승인처리 전 유효성체크] STEP-2[ERR] : OOM 승인권한 미존재!!(업무예외발생)");
						//BBG 승인권한이 없습니다.
						throw new EventException(new ErrorHandler("DMT06037", new String[]{"for OOM"}).getMessage());
					}					
				}
				else if ("BBG".equals(chgCalcCntrVO.getChgDeltPathCd())) {
					// BBG 승인권한자가 아닐 경우, 업무예외 발생
					if (!dbDao.isChargeDeletionBBGAuth(account.getUsr_id(), account.getOfc_cd())) {
						log.debug("\n[승인처리 전 유효성체크] STEP-2[ERR] : BBG 승인권한 미존재!!(업무예외발생)");
						//BBG 승인권한이 없습니다.
						throw new EventException(new ErrorHandler("DMT06037", new String[]{"for BBG"}).getMessage());
					}
				}
				else if ("RHQ".equals(chgCalcCntrVO.getChgDeltPathCd())) {
					// RHQ 승인권한자가 아닐 경우, 업무예외 발생
					if (!dbDao.isChargeDeletionRHQAuth(account.getUsr_id(), account.getOfc_cd())) {
						log.debug("\n[승인처리 전 유효성체크] STEP-2[ERR] : RHQ 승인권한 미존재!!(업무예외발생)");
						//RHQ 승인권한이 없습니다.
						throw new EventException(new ErrorHandler("DMT06037", new String[]{"for RHQ"}).getMessage());
					}					
				}				
				else if ("HDO".equals(chgCalcCntrVO.getChgDeltPathCd())) {
					// HO 승인권한자가 아닐 경우, 업무예외 발생
					if (!dbDao.isChargeDeletionHOAuth(account.getUsr_id(), account.getOfc_cd())) {
						log.debug("\n[승인처리 전 유효성체크] STEP-2[ERR] : HO 승인권한 미존재!!(업무예외발생)");
						//HO 승인권한이 없습니다.
						throw new EventException(new ErrorHandler("DMT06037", new String[]{"for SELHO"}).getMessage());
					}						
				}
				// 승인권한이 존재하지 않을 경우, 업무예외발생
				else {
					log.debug("\n[승인처리 전 유효성체크] STEP-2[ERR] : 승인권한 미존재!!(업무예외발생)");
					//승인권한이 없습니다.
					throw new EventException(new ErrorHandler("DMT06037", new String[]{""}).getMessage());
				}
				
				//STEP-2.1 현재 승인단계가 처리가능한 승인단계인지 여부를 체크한다.
				log.debug("\n[승인처리 전 유효성체크] STEP-2.1 : 현재 승인단계가 처리가능한 승인단계인지 여부 체크");
				if (!dbDao.isChargeDeletionApprovalPath(chgCalcCntrVO)) {
					log.debug("\n[승인처리 전 유효성체크] STEP-2.1[ERR] : 현 단계는 승인처리가 불가합니다. 설정정보를 참조하세요!!(업무예외발생)");
					throw new EventException(new ErrorHandler("DMT06038", new String[]{chgCalcCntrVO.getChgDeltPathCd()}).getMessage());
				}
				
				log.debug("\n[승인처리 전 유효성체크] STEP-3 : 승인완료된 상위OFFICE 존재여부 체크");
				if (!dbDao.isChargeDeletionParentApprovalPath(chgCalcCntrVO)) {
					log.debug("\n[승인처리 전 유효성체크] STEP-3[ERR] : 승인완료된 상위OFFICE 존재함!!(업무예외발생)");
					throw new EventException(new ErrorHandler("DMT06047", new String[]{chgCalcCntrVO.getChgDeltPathCd()}).getMessage());
				}
				
				log.debug("\n[승인처리 전 유효성체크] STEP-4 : 동일 승인단계 중복된 승인상태처리 체크");
				if (dbDao.isChargeDeletionDuplicateApprovalStatusByCurrPath(chgCalcCntrVO)) {
					log.debug("\n[승인처리 전 유효성체크] STEP-4[ERR] : 동일 승인단계 중복된 승인상태처리 존재함!!(업무예외발생)");
					throw new EventException(new ErrorHandler("DMT06039", new String[]{chgCalcCntrVO.getChgDeltPathCd()}).getMessage());
				}				
			}
		}
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"charge deletion approval status"}).getMessage());
		}
		catch (EventException ex) {
			log.error("[EventException]"+ex.getMessage());
			throw ex;
		}
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"charge deletion approval status"}).getMessage());
		}
	}
		
	/**
	 * Charge Deletion 요청에 대해서 각 승인단계별 권한자가 승인 or 거절시 해당 처리를 실행한다. <br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyChargeDeletionProcessStatus(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
		throws EventException {
		
		ExceptionChargeCalculationVO exptChgCalcVO = new ExceptionChargeCalculationVO();
		String inactAproNo = "";
		String corrRmk = "";

		try {
			
			inactAproNo = chargeCalculationContainerVOs[0].getInactAproNo();
			corrRmk     = chargeCalculationContainerVOs[0].getCorrRmk();
			
			log.debug("\n[승인처리] STEP-START");
			for (ChargeCalculationContainerVO chgCalcCntrVO : chargeCalculationContainerVOs) {
				
				chgCalcCntrVO.setChgDeltUsrId(account.getUsr_id());
				chgCalcCntrVO.setCreUsrId(account.getUsr_id());
				chgCalcCntrVO.setCreOfcCd(account.getOfc_cd());
				
				chgCalcCntrVO.setInactAproNo(inactAproNo);
				chgCalcCntrVO.setCorrRmk(corrRmk);
				
				log.debug("\n[승인처리] STEP-1 : 최종필수승인단계이상 최종승인처리여부 체크");
				if (dbDao.isChargeDeletionLastApprovalPath(chgCalcCntrVO)) {
					log.debug("\n[승인처리] STEP-1.1 : 최종필수승인단계이상 최종승인상태임");
					
					log.debug("\n[승인처리] STEP-1.1.1 : 최종필수승인단계이상 최종승인상태조회");
					String chgDeltStsCd = dbDao.searchChargeDeletionLastApprovalStatus(chgCalcCntrVO);
					
					log.debug("\n[승인처리] STEP-1.1.2 : 최종필수승인단계이상 최종승인상태(" + chgDeltStsCd + ")와 변경승인상태(" + chgCalcCntrVO.getChgDeltStsCd() + ") 비교");
					if (chgCalcCntrVO.getChgDeltStsCd().equals(chgDeltStsCd)) {
						log.debug("\n[승인처리] STEP-1.1.2[ERR] : 중복된 승인처리!!(업무예외발생)");
						throw new EventException(new ErrorHandler("DMT06040", new String[]{""}).getMessage());
					}
					
					log.debug("\n[승인처리] STEP-1.1.3 : 최종필수승인단계이상 최초 REJECT 인지 비교");
					if (StringUtils.isBlank(chgDeltStsCd) && "J".equals(chgCalcCntrVO.getChgDeltStsCd())) {
						
						log.debug("\n[승인처리] STEP-1.1.3.1 : CHARGE DELETION REQUEST 상태 변경");
						this.modifyChargeDeletionRequestStatus(chgCalcCntrVO);
					}
					else {
						log.debug("\n[승인처리] STEP-1.1.3.2 : CHARGE 상태 변경 가능여부 체크");
						// 기존 조회쿼리를 사용하기 때문에, 아래와 같이 Charge Status Code 를 Charge Delt Status Code 로 설정해준다.
						chgCalcCntrVO.setDmdtChgStsCd(chgCalcCntrVO.getChgDeltStsCd());
						if (!dbDao.isChargeChangeStatus(chgCalcCntrVO)) {
							log.debug("\n[승인처리] STEP-1.1.3.2[ERR] : CHARGE 상태 변경 불가!!(업무예외발생)");
							throw new EventException(new ErrorHandler("DMT06041", new String[]{chgCalcCntrVO.getCntrNo()}).getMessage());							
						}
						
//						log.debug("\n[승인처리] STEP-1.1.3.3 : 최종 CHARGE 여부 체크");
//						if (dbDao.isExistsBalanceCharge(chgCalcCntrVO)) {
//							log.debug("\n[승인처리] STEP-5.1.3.3[ERR] : 최종 CHARGE 아님!!(업무예외발생)");
//							throw new EventException(new ErrorHandler("DMT06042", new String[]{chgCalcCntrVO.getCntrNo()}).getMessage());								
//						}
						
						log.debug("\n[승인처리] STEP-1.1.3.4 : CHARGE CORRECTION HISTORY 존재여부 체크");
						if (!dbDao.isExistsChargeCorrectionHistory(chgCalcCntrVO)) {
							
							log.debug("\n[승인처리] STEP-1.1.3.4.1 : [최초] CHARGE CORRECTION HISTORY 생성");
							dbDao.addChargeCorrectionHistory(chgCalcCntrVO);
						}
						
						log.debug("\n[승인처리] STEP-1.1.3.5 : CHARGE 상태 변경");
						// >>. Charge Deletion 승인처리에 따라 Charge 상태를 변경한다.
						// >>. - 승인 후 취소한 경우, 해당 Charge 에 대한 배치가 실행될 수 있도록 Calculation Date 변경한다. 
						dbDao.modifyChargeStatusByChargeDeletion(chgCalcCntrVO);
						
						log.debug("\n[승인처리] STEP-1.1.3.6 : CHARGE CORRECTION HISTORY 생성");
						// >>. 변경된 Charge 에 대한 Charge Correction 이력을 생성한다.
						dbDao.addChargeCorrectionHistory(chgCalcCntrVO);
						
						log.debug("\n[승인처리] STEP-1.1.3.7 : CHARGE DELETION REQUEST 상태 변경");
						// >>. Charge Deletion Request 의 상태를 변경한다.
						this.modifyChargeDeletionRequestStatus(chgCalcCntrVO);	
						
						log.debug("\n[승인처리] STEP-1.1.3.8 : CHARGE DELETION 변경승인상태가 '승인' 인지 여부 비교");
						// >>. Exception cost calc. 배치 실행 결과가 존재한다면
						if ("A".equals(chgCalcCntrVO.getChgDeltStsCd())) {
							
							exptChgCalcVO.setBkgNo(chgCalcCntrVO.getBkgNo());
							exptChgCalcVO.setCntrNo(chgCalcCntrVO.getCntrNo());
							exptChgCalcVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
							exptChgCalcVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
							exptChgCalcVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
							exptChgCalcVO.setChgSeq(chgCalcCntrVO.getChgSeq());
							exptChgCalcVO.setDmdtChgStsCd("D"); //Delete
							exptChgCalcVO.setUpdUsrId(account.getUsr_id());
							exptChgCalcVO.setUpdOfcCd(account.getOfc_cd()); 
							
							log.debug("\n[승인처리] STEP-1.1.3.8.1 : CHARGE EXCEPTION COST 존재여부 체크");
							if (dbDao.checkDmtExceptionChargeCalculation(exptChgCalcVO)) {
								
								log.debug("\n[승인처리] STEP-1.1.3.8.1.1 : CHARGE EXCEPTION COST 를 0 으로 초기화");
								// >>. Charge 가 Delete 되었기 때문에, Exception cost calc. 배치 실행 결과를 0 으로 초기화한다.
								dbDao.mergeDmtExceptionChargeCalculation(exptChgCalcVO);
							}
						}
						
						log.debug("\n[승인처리] STEP-1.1.3.9 : 최종상태가 승인이고, 현재 승인처리상태가 거절인 경우 CHG CNTR. 는 원복된다. 이 경우, 한국지역일 경우에는 EDI 전송대상이 된다.");
						this.setEDISendYN(chgCalcCntrVO, chgDeltStsCd);
					}
				}
				else {
					log.debug("\n[승인처리] STEP-1.2 : 최종필수승인단계이상 최종승인처리상태가 아님");
					// >>. Charge Deletion 요청상태를 변경한다.
					this.modifyChargeDeletionRequestStatus(chgCalcCntrVO);					
				}
				
				log.debug("\n[승인처리] STEP-2 : 최종필수승인단계이상 변경승인상태가 하위OFFICE 의 승인상태와 다른지 체크");
				//STEP-6. 승인처리결과가 다른 하위OFC 의 승인처리 존재여부를 체크한다.(6, 7 번 단계 앞에 있어야 됨)
				if (dbDao.isChargeDeletionSubPathUser(chgCalcCntrVO)) {
					log.debug("\n[승인처리] STEP-2.1 : NOTICE 대상 메일주소 조회");
					//	>>. 존재할 경우, Notice 메일을 보내준다.(XA 트랜잭션을 지원하지 않기 때문에, SC 에서 현 트랜잭션을 종료하고 메일을 전송토록 해준다.)
					chgCalcCntrVO.setEmlSndYn("Y");
					//  >>. Notice 대상 메일정보를 조회한다.
					chgCalcCntrVO.setEmlRcvrAddr(dbDao.searchChargeDeletionNoticeRcvrAddr(chgCalcCntrVO));
					log.debug("\n[승인처리] STEP-2.2 : NOTICE 대상 메일주소 :: " + chgCalcCntrVO.getEmlRcvrAddr());
				}
				
				log.debug("\n[승인처리] STEP-3 : 현 승인단계(" + chgCalcCntrVO.getChgDeltPathCd() + ")에 대해 변경승인상태(" + chgCalcCntrVO.getChgDeltStsCd() + ")로 반영");
				//STEP-7. Charge Deletion 요청에 대한 승인단계의 승인처리상태를 변경한다.
				this.modifyChargeDeletionPathStatus(chgCalcCntrVO);
				
				log.debug("\n[승인처리] STEP-4 : 승인단계별 승인변경이력 생성");
				//STEP-8. 승인단계별 승인상태 변경이력을 생성한다.
				this.addChargeDeletionChangeHistory(chgCalcCntrVO);
			}
			log.debug("\n[승인처리] STEP-END");
		}
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"charge deletion approval status"}).getMessage());
		}
		catch (EventException ex) {
			log.error("[EventException]"+ex.getMessage());
			throw ex;
		}
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"charge deletion approval status"}).getMessage());
		}		
	}
	
	/**
	 * Charge Deletion 요청에 대한 승인단계의 승인처리상태를 변경한다. <br>
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @exception EventException
	 */	
	private void modifyChargeDeletionRequestStatus(ChargeCalculationContainerVO chgCalcCntrVO) throws EventException {
		
		// CHARGE DELETION RQUEST STS CD 정의 ===============================================================================================
		//     >> C : Request Cancel
		//	   >> R : Request
		//     >> A : Approval	-> BBG, RHQ, HDO 승인단계별로 코드가 분리되어 사용되도록 변경함(AS-IS 데이터 때문에 코드값 유지함)
		//     >> J : Reject	-> BBG, RHQ, HDO 승인단계별로 코드가 분리되어 사용되도록 변경함(AS-IS 데이터 때문에 코드값 유지함)
		// OOM >> O : OOM Approval, P : OOM Reject (OOM -> OFC Operation Manager)
		// BBG >> B : BB Approval, 	E : BB Reject
		// RHQ >> Q : RHQ Approval, F : RHQ Reject
		// HDO >> H : HO Approval,  G : HO Reject
		// ==================================================================================================================================   
		
		try {
			//>>. 승인경로VO 로 변환해준다.
			if ("OOM".equals(chgCalcCntrVO.getChgDeltPathCd())) {
				if ("A".equals(chgCalcCntrVO.getChgDeltStsCd())) {
					chgCalcCntrVO.setDmdtDeltRqstStsCd("O");
				}
				else if ("J".equals(chgCalcCntrVO.getChgDeltStsCd())) {
					chgCalcCntrVO.setDmdtDeltRqstStsCd("P");
					chgCalcCntrVO.setInactAproNo("");
				}				
			}
			else if ("BBG".equals(chgCalcCntrVO.getChgDeltPathCd())) {
				if ("A".equals(chgCalcCntrVO.getChgDeltStsCd())) {
					chgCalcCntrVO.setDmdtDeltRqstStsCd("B");
				}
				else if ("J".equals(chgCalcCntrVO.getChgDeltStsCd())) {
					chgCalcCntrVO.setDmdtDeltRqstStsCd("E");
					chgCalcCntrVO.setInactAproNo("");
				}
			}
			else if ("RHQ".equals(chgCalcCntrVO.getChgDeltPathCd())) {
				if ("A".equals(chgCalcCntrVO.getChgDeltStsCd())) {
					chgCalcCntrVO.setDmdtDeltRqstStsCd("Q");
				}
				else if ("J".equals(chgCalcCntrVO.getChgDeltStsCd())) {
					chgCalcCntrVO.setDmdtDeltRqstStsCd("F");
					chgCalcCntrVO.setInactAproNo("");
				}
			}
			else if ("HDO".equals(chgCalcCntrVO.getChgDeltPathCd())) {
				if ("A".equals(chgCalcCntrVO.getChgDeltStsCd())) {
					chgCalcCntrVO.setDmdtDeltRqstStsCd("H");
				}
				else if ("J".equals(chgCalcCntrVO.getChgDeltStsCd())) {
					chgCalcCntrVO.setDmdtDeltRqstStsCd("G");
					chgCalcCntrVO.setInactAproNo("");
				}
			}
			
			//>>. 현재 승인단계의 승인처리상태를 변경한다.
			dbDao.modifyChargeDeletionRequestStatus(chgCalcCntrVO);
		}
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT06032", new String[]{"cntr's("+ chgCalcCntrVO.getCntrNo() +") deletion request status"}).getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT06032", new String[]{"cntr's("+ chgCalcCntrVO.getCntrNo() +") deletion request status"}).getMessage());
		}		
	}
	
	/**
	 * Charge Deletion 요청에 대한 승인단계의 승인처리상태를 변경한다. <br>
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @exception EventException
	 */	
	private void modifyChargeDeletionPathStatus(ChargeCalculationContainerVO chgCalcCntrVO) throws EventException {
		
		try {
			//>>. 승인경로VO 로 변환해준다.
			ChgDeltPathVO chgDeltPathVO = new ChgDeltPathVO();
			chgDeltPathVO.setSysAreaGrpId(chgCalcCntrVO.getSvrId());
			chgDeltPathVO.setCntrNo(chgCalcCntrVO.getCntrNo());
			chgDeltPathVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
			chgDeltPathVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
			chgDeltPathVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
			chgDeltPathVO.setChgSeq(chgCalcCntrVO.getChgSeq());
			chgDeltPathVO.setChgOfcCd(chgCalcCntrVO.getOfcCd());
			chgDeltPathVO.setDeltSeq(chgCalcCntrVO.getDeltSeq());
			chgDeltPathVO.setChgDeltPathCd(chgCalcCntrVO.getChgDeltPathCd());
			chgDeltPathVO.setChgDeltStsCd(chgCalcCntrVO.getChgDeltStsCd());
			chgDeltPathVO.setCreUsrId(chgCalcCntrVO.getCreUsrId());
			chgDeltPathVO.setCreOfcCd(chgCalcCntrVO.getCreOfcCd());
			chgDeltPathVO.setUpdUsrId(chgCalcCntrVO.getCreUsrId());
			chgDeltPathVO.setUpdOfcCd(chgCalcCntrVO.getCreOfcCd());
			
			//>>. 현재 승인단계의 승인처리상태를 변경한다.
			dbDao.modifyChargeDeletionPathStatus(chgDeltPathVO);
		}
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT06032", new String[]{"cntr's("+ chgCalcCntrVO.getCntrNo() +") deletion approval status"}).getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT06032", new String[]{"cntr's("+ chgCalcCntrVO.getCntrNo() +") deletion approval status"}).getMessage());
		}		
	}
	
	/**
	 * Charge Deletion 요청에 대한 승인단계의 승인처리상태 변경이력을 생성한다. <br>
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @exception EventException
	 */	
	private void addChargeDeletionChangeHistory(ChargeCalculationContainerVO chgCalcCntrVO) throws EventException  {
		
		try {
			//>>. 승인상태이력변경VO 로 변환해준다.
			ChgDeltCngHisVO chgDeltChgHisVO = new ChgDeltCngHisVO();
			chgDeltChgHisVO.setSysAreaGrpId(chgCalcCntrVO.getSvrId());
			chgDeltChgHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
			chgDeltChgHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
			chgDeltChgHisVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
			chgDeltChgHisVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
			chgDeltChgHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
			chgDeltChgHisVO.setChgOfcCd(chgCalcCntrVO.getOfcCd());
			chgDeltChgHisVO.setDeltSeq(chgCalcCntrVO.getDeltSeq());
			chgDeltChgHisVO.setChgDeltPathCd(chgCalcCntrVO.getChgDeltPathCd());
			chgDeltChgHisVO.setChgDeltUsrId(chgCalcCntrVO.getCreUsrId());
			chgDeltChgHisVO.setChgDeltStsCd(chgCalcCntrVO.getChgDeltStsCd());
			chgDeltChgHisVO.setCreUsrId(chgCalcCntrVO.getCreUsrId());
			chgDeltChgHisVO.setCreOfcCd(chgCalcCntrVO.getCreOfcCd());
			chgDeltChgHisVO.setUpdUsrId(chgCalcCntrVO.getCreUsrId());
			chgDeltChgHisVO.setUpdOfcCd(chgCalcCntrVO.getCreOfcCd());
			
			chgDeltChgHisVO.setInactRmk(chgCalcCntrVO.getCorrRmk());
			
			//>>. 승인변경이력 시퀀스를 조회한다.
			long seq = dbDao.searchChargeDeletionChangeHistorySeq(chgCalcCntrVO);
			chgDeltChgHisVO.setDeltCngHisSeq(String.valueOf(seq));
			chgCalcCntrVO.setDeltCngHisSeq(String.valueOf(seq));
			
			//>>. 승인단계별 승인상태 변경이력을 생성한다.
			dbDao.addChargeDeletionChangeHistory(chgDeltChgHisVO);
		}
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"cntr's("+ chgCalcCntrVO.getCntrNo() +") deletion approval history"}).getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"cntr's("+ chgCalcCntrVO.getCntrNo() +") deletion approval history"}).getMessage());
		}		
	}
	
	/**
	 * 승인처리후 하위Office 결재자에게 메일을 전송한 후, 메일전송번호를 변경이력에 갱신해준다. <br>
	 * 
	 * @param List<ChargeCalculationContainerVO> chargeCalculationContainerVOList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyChargeDeletionEmlSndNo(List<ChargeCalculationContainerVO> chargeCalculationContainerVOList, SignOnUserAccount account)
		throws EventException {

		List<ChgDeltCngHisVO> ChgDeltCngHisVOList = new ArrayList<ChgDeltCngHisVO>();
		ChgDeltCngHisVO chgDeltCngHisVO = new ChgDeltCngHisVO();
		
		try {
			for (ChargeCalculationContainerVO chgCalcCntrVO : chargeCalculationContainerVOList) {
				if ("Y".equals(chgCalcCntrVO.getEmlSndYn())) {
					chgDeltCngHisVO = new ChgDeltCngHisVO();
					
					chgDeltCngHisVO.setSysAreaGrpId(chgCalcCntrVO.getSvrId());
					chgDeltCngHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
					chgDeltCngHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
					chgDeltCngHisVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
					chgDeltCngHisVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
					chgDeltCngHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
					chgDeltCngHisVO.setChgOfcCd(chgCalcCntrVO.getOfcCd());
					chgDeltCngHisVO.setDeltSeq(chgCalcCntrVO.getDeltSeq());
					chgDeltCngHisVO.setDeltCngHisSeq(chgCalcCntrVO.getDeltCngHisSeq());
					chgDeltCngHisVO.setChgDeltPathCd(chgCalcCntrVO.getChgDeltPathCd());
					chgDeltCngHisVO.setChgDeltUsrId(chgCalcCntrVO.getChgDeltUsrId());
					chgDeltCngHisVO.setChgDeltStsCd(chgCalcCntrVO.getChgDeltStsCd());
					chgDeltCngHisVO.setEmlSndNo(chgCalcCntrVO.getEmlSndNo());
					
					ChgDeltCngHisVOList.add(chgDeltCngHisVO);
				}
			}
			
			//>>. 승인단계별 승인상태 변경이력을 생성한다.
			dbDao.modifyChargeDeletionEmlSndNo(ChgDeltCngHisVOList);
		}
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT06032", new String[]{"the email send no. of cntr deletion"}).getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT06032", new String[]{"the email send no. of cntr deletion"}).getMessage());
		}			
	}
	
	/**
	 * 로그인 사용자의 승인권한이 있는 승인경로를 조회한다. <br>
	 * 
	 * @param String lginUsrId
	 * @param String lginOfcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchChargeDeletionPath(String lginUsrId, String lginOfcCd) throws EventException {
		
		String chgDeltPathCd = "";
		
		try {		
			if (dbDao.isChargeDeletionHOAuth(lginUsrId, lginOfcCd)) {
				chgDeltPathCd = "HDO";
			}
			else if (dbDao.isChargeDeletionRHQAuth(lginUsrId, lginOfcCd)) {
				chgDeltPathCd = "RHQ";
			}
			else if (dbDao.isChargeDeletionBBGAuth(lginUsrId, lginOfcCd)) {
				chgDeltPathCd = "BBG";
			}
			else if (dbDao.isChargeDeletionOOMAuth(lginUsrId, lginOfcCd)) {
				chgDeltPathCd = "OOM";
			}			
		}
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"the authority of login user"}).getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"the authority of login user"}).getMessage());
		}
		
		return chgDeltPathCd;
	}
	
	/**
	 * Charge Deletion Request File 을 조회합니다. <br>
	 * @param ChgDeltRqstFileVO chgDeltRqstFileVO
	 * @return List<ChgDeltRqstFileVO>
	 * @throws EventException
	 */	
	public List<ChgDeltRqstFileVO> searchChargeDeletionRequestFileList(ChgDeltRqstFileVO chgDeltRqstFileVO) throws EventException {

		try {		
			return dbDao.searchChargeDeletionRequestFileList(chgDeltRqstFileVO);
		}
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"attached file"}).getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"attached file"}).getMessage());
		}		
	}
	
	/**
	 * Charge Deletion 요청을 취소합니다. <br>
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */		
	public void cancelChargeDeletionRequest(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account) throws EventException {
		
		String dmdtDeltRqstStsCd = "";

		try {
			for (ChargeCalculationContainerVO chgCalcCntrVO : chargeCalculationContainerVOs) {

				chgCalcCntrVO.setCreUsrId(account.getUsr_id());
				chgCalcCntrVO.setCreOfcCd(account.getOfc_cd());
				
				log.debug("\n[승인요청취소처리] STEP-1 : CHARGE 삭제요청자(" + chgCalcCntrVO.getOfcCd() + ")와 로그인사용자(" + account.getOfc_cd() + ")가 동일OFFICE 유저인지 체크");
				//1. Charge Deletion 요청자와 로그인 사용자가 동일한 OFFICE 유저인지 체크한다.
				if (!account.getOfc_cd().equals(chgCalcCntrVO.getOfcCd())) {
					log.debug("\n[승인요청취소처리] STEP-1[ERR] : CHARGE 삭제요청자와 로그인사용자가 동일OFFICE 유저가 아님!!(업무예외발생)");
					throw new EventException(new ErrorHandler("DMT06033", new String[]{chgCalcCntrVO.getOfcCd(), account.getOfc_cd()}).getMessage());
				}
				
				log.debug("\n[승인요청취소처리] STEP-2 : CHARGE 요청상태 조회");				
				//2. Charge Deletion 요청상태를 조회한다.
				dmdtDeltRqstStsCd = dbDao.searchChargeDeletionRequestStatus(chgCalcCntrVO);
				
				if (StringUtils.isEmpty(dmdtDeltRqstStsCd)) {
					log.debug("\n[승인요청취소처리] STEP-2[ERR] : CHARGE 요청상태 - 미존재!!(업무예외발생)");
					// >>. Charge Deletion 요청상태가 존재하지 않습니다.
					throw new EventException(new ErrorHandler("DMT06034", new String[]{chgCalcCntrVO.getCntrNo()}).getMessage());
				}
				else if (!"R".equals(dmdtDeltRqstStsCd)) {
					log.debug("\n[승인요청취소처리] STEP-2[ERR] : CHARGE 요청상태 - 승인처리진행중!!(업무예외발생)");
					// >>. Charge Deletion 요청상태는 승인처리 진행중입니다.
					throw new EventException(new ErrorHandler("DMT06035", new String[]{chgCalcCntrVO.getCntrNo()}).getMessage());
				}
				
				log.debug("\n[승인요청취소처리] STEP-3 : CHARGE 요청상태 - 취소로 변경");				
				//3. Charge Deletion 요청상태 갱신(취소 : 'C')
				chgCalcCntrVO.setDmdtDeltRqstStsCd("C");
				dbDao.modifyChargeDeletionRequestStatus(chgCalcCntrVO);
				
				chgCalcCntrVO.setChgDeltPathCd("BBG");
				chgCalcCntrVO.setChgDeltStsCd("C");
				this.addChargeDeletionChangeHistory(chgCalcCntrVO);
			}
		}
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT06032", new String[]{"cntr's deletion request status"}).getMessage());
		} 
		catch (EventException ex) {
			log.error("[EventException]"+ex.getMessage());
			throw ex;
		} 		
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT06032", new String[]{"cntr's deletion request status"}).getMessage());
		}
	}
	
	/**
	 * Charge Deletion 이 EDI 전송대상인지 여부를 설정합니다. <br>
	 * @param ChargeCalculationContainerVO ChgCalcCntrVO
	 * @param String chgDeltStsCd
	 * @throws EventException
	 */		
	private void setEDISendYN(ChargeCalculationContainerVO ChgCalcCntrVO, String chgDeltStsCd) throws EventException {

		try {
			// 최종승인상태가 '승인'(Charge 는 삭제상태) 이고, 현재 승인처리여부는 '승인거절'일 경우, 삭제상태의 Charge 를 원상태로 복원한다.
			// 삭제된 Charge 상태가 복원된 경우 & 한국지역인 경우 EDI 전송대상이 된다.
			if ("A".equals(chgDeltStsCd) && "J".equals(ChgCalcCntrVO.getChgDeltStsCd())) {
				String ydCd = StringUtils.defaultIfEmpty(ChgCalcCntrVO.getFmMvmtYdCd(), "");

				if (ydCd.length() == 7) {
					String locCd = ydCd.substring(0, 5);

					if ("KOR".equals(ChgCalcCntrVO.getSvrId()) 
							&& ("KRPUS".equals(locCd) ||
								"KRKAN".equals(locCd) ||
								"KRINC".equals(locCd) ||
								"KRPYT".equals(locCd) ||
								"KRUSN".equals(locCd) ||
								"KRGIN".equals(locCd) ||
								"KRPTK".equals(locCd)) ) {
						
						ChgCalcCntrVO.setSndToEdiYn("Y");
					}
				}
			}
		}
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT06032", new String[]{"cntr's deletion request status"}).getMessage());
		}
	}
	//###############################################< CHM-201533804 [DMT] Deletion Setup 화면 개발 영역 [E] >###############################################
	
	/**
	 * Charge Delete시 Delete Reason Data들의 List를 조회한다<br>
	 * 공통코드 테이블에서 Delete Reason Code와 Description을 조회한다<br>
	 * 
	 * @return List<SearchDeleteMultiReasonListVO>
	 */
	public List<SearchDeleteMultiReasonListVO> searchDeleteMultiReasonList() throws EventException {
		
		try {
			return dbDao.searchDeleteMultiReasonList();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		}
	}
	
	/**
	 * Charge Delete시 Delete Reason Data들의 List를 조회한다<br>
	 * 공통코드 테이블에서 Delete Reason Code와 Description을 조회한다<br>
	 * 
	 * @param SearchDeleteMultiReasonListVO searchDeleteMultiReasonListVO
	 * @return List<SearchDeleteMultiDetailReasonListVO>
	 * @exception EventException
	 */
	public List<SearchDeleteMultiDetailReasonListVO> searchDeleteMultiDetailReasonList(SearchDeleteMultiReasonListVO searchDeleteMultiReasonListVO) throws EventException {
		
		try {
			return dbDao.searchDeleteMultiDetailReasonList(searchDeleteMultiReasonListVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		}
	}
	
	/**
	 * Charge Deletion 요청시 입력한 Specific Reason 별 Remark 상세내역을 조회한다.<br>
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @return List<ChargeDeltSpecRsnRmkVO>
	 * @exception EventException
	 */
	public List<ChargeDeltSpecRsnRmkVO> searchDeletionSpecificReasonRemarkList(ChargeCalculationContainerVO chargeCalculationContainerVO) throws EventException {
		
		try {

			if ( chargeCalculationContainerVO.getDeltSeq() == null ){
				com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO checkArgument = new com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO();
				
				//중복처리 방지 체크로직
				checkArgument.setSvrId(chargeCalculationContainerVO.getSvrId());
				checkArgument.setCntrNo(chargeCalculationContainerVO.getCntrNo());
				checkArgument.setCntrCycNo(chargeCalculationContainerVO.getCntrCycNo());
				checkArgument.setDmdtTrfCd(chargeCalculationContainerVO.getDmdtTrfCd());
				checkArgument.setDmdtChgLocDivCd(chargeCalculationContainerVO.getDmdtChgLocDivCd());
				checkArgument.setChgSeq(chargeCalculationContainerVO.getChgSeq());
				checkArgument.setStsCd(chargeCalculationContainerVO.getChgDeltStsCd());
				
				String result = dbDao.checkRequestChargeDeletion(checkArgument);
				
				if ( !"".equals(result) ){
					String[] arrresult			= result.split("\\|");
		
					chargeCalculationContainerVO.setChgOfcCd(arrresult[0]);
					chargeCalculationContainerVO.setDeltSeq(arrresult[1]);
				}
			}
			return dbDao.searchDeletionSpecificReasonRemarkList(chargeCalculationContainerVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		}		
	}
	

	/**
	 * Inactive History 을 조회한다.<br>
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @return List<ChargeInactivHisListVO>
	 * @exception EventException
	 */
	public List<ChargeInactivHisListVO> searchInactiveHistoryList(ChargeCalculationContainerVO chargeCalculationContainerVO) throws EventException {
		
		try {
			return dbDao.searchInactiveHistoryList(chargeCalculationContainerVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		}		
	}
	

	/**
	 * 해당 Charge의 Correction UC Flag 정보를 수정한다.
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String ucFlag
	 * @param String ofcCd
	 * @param String usrId
	 * @exception EventException
	 */
	public void modifyChargeUcFlag (String bkgNo, String cntrNo, String ucFlag, String ofcCd, String usrId) throws EventException {
		try {
						
			List<ChargeCalculationContainerVO> chgCalcCntrVOs = null;
			
			chgCalcCntrVOs = dbDao.searchCalculationBookingContainerUcFlag(bkgNo, cntrNo);
				
			for (ChargeCalculationContainerVO chgCalcCntrVO : chgCalcCntrVOs) {
				
				com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = null;
				chargeArgumentVO = new com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
				chargeArgumentVO.setSvrId(chgCalcCntrVO.getSvrId());
				chargeArgumentVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chargeArgumentVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chargeArgumentVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chargeArgumentVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chargeArgumentVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				int corrHisSeq = checkChargeCorrectionUcFlag(chargeArgumentVO);
				
				DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
				dmtChgCorrHisVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCorrHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCorrHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCorrHisVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCorrHisVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCorrHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				dmtChgCorrHisVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				if( "Y".equals(ucFlag)){
					dmtChgCorrHisVO.setCorrHisRmk("UC flag check");
				} else {
					dmtChgCorrHisVO.setCorrHisRmk("UC flag uncheck");	
				}
				dmtChgCorrHisVO.setCreUsrId(usrId);
				dmtChgCorrHisVO.setCreOfcCd(ofcCd);
				
				if(corrHisSeq == 0) {
					corrHisSeq++;
					dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
					dbDao.addChargeHistoryUcFlg(dmtChgCorrHisVO);
				}
				
				chgCalcCntrVO.setOfcCd(ofcCd);
				chgCalcCntrVO.setUsrId(usrId);
				dbDao.modifyChargeUcFlag(chgCalcCntrVO, ucFlag);
				
				corrHisSeq++;
				dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
				dbDao.addChargeHistoryUcFlg(dmtChgCorrHisVO);
			}
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify charge uc flag"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify charge uc flag"}).getMessage());
		}
	}
	

	/**
	 * 해당 Charge의 Correction UC Flag 정보를 수정한다.
	 * 
	 * @param String ucCsNo
	 * @param String blNo
	 * @exception EventException
	 */
	public void modifyChargeUcFlagBlNo (String ucCsNo, String blNo) throws EventException {
		try {
						
			List<ChargeCalculationContainerVO> chgCalcCntrVOs = null;
			
			chgCalcCntrVOs = dbDao.searchCalculationBookingContainerUcFlagBlNo(ucCsNo, blNo);
				
			for (ChargeCalculationContainerVO chgCalcCntrVO : chgCalcCntrVOs) {
				
				com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO = null;
				chargeArgumentVO = new com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO();
				chargeArgumentVO.setSvrId(chgCalcCntrVO.getSvrId());
				chargeArgumentVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				chargeArgumentVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				chargeArgumentVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				chargeArgumentVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				chargeArgumentVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				int corrHisSeq = checkChargeCorrectionUcFlag(chargeArgumentVO);
				
				DmtChgCorrHisVO dmtChgCorrHisVO = new DmtChgCorrHisVO();
				dmtChgCorrHisVO.setSvrId(chgCalcCntrVO.getSvrId());
				dmtChgCorrHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtChgCorrHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtChgCorrHisVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtChgCorrHisVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtChgCorrHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				dmtChgCorrHisVO.setBkgNo(chgCalcCntrVO.getBkgNo());
				if( "Y".equals(chgCalcCntrVO.getUclmFlg())){
					dmtChgCorrHisVO.setCorrHisRmk("UC flag check");
				} else {
					dmtChgCorrHisVO.setCorrHisRmk("UC flag uncheck");	
				}
				dmtChgCorrHisVO.setCreOfcCd(chgCalcCntrVO.getOfcCd());
				dmtChgCorrHisVO.setCreUsrId(chgCalcCntrVO.getUsrId());
				
				if(corrHisSeq == 0) {
					corrHisSeq++;
					dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
					dbDao.addChargeHistoryUcFlg(dmtChgCorrHisVO);
				}
				
				dbDao.modifyChargeUcFlag(chgCalcCntrVO, chgCalcCntrVO.getUclmFlg());
				
				corrHisSeq++;
				dmtChgCorrHisVO.setCorrHisSeq(String.valueOf(corrHisSeq));
				dbDao.addChargeHistoryUcFlg(dmtChgCorrHisVO);
			}
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify charge uc flag"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify charge uc flag"}).getMessage());
		}
	}

	/**
	 *  checkChargeCorrection 대한 해당 데이터를 조회한다. <br>
	 * Charge의 Correction History가 존재하는지 여부를 조회하여 존재시 1을, 미존재시 0을 Return한다<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return int
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public int checkChargeCorrectionUcFlag(com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO) throws EventException, DAOException{
	
		int corrHisSeq = 0;
		int retValue = 0;
		
		retValue = dbDao.checkChargeCorrectionUcFlag(chargeArgumentVO);
	
		// Charge의 Correction History가 존재하는지 여부를 조회하여 존재시 1을, 미존재시 0을 Return한다
		if(retValue > 0){
			corrHisSeq = retValue;
		} else {
			corrHisSeq = 0;
		}
			
		log.debug("[ReturnValue:checkChargeCorrection]>> : "+ corrHisSeq);
		return corrHisSeq;
	}

	/**
	 * After BKG Approval 등록된 경로 목록을 조회한다. 
	 * 
	 * @param AftBkgPathSetupVO aftBkgPathSetupVO
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<AftBkgPathSetupVO> searchAftBkgPathList(AftBkgPathSetupVO aftBkgPathSetupVO) throws EventException {

		List<AftBkgPathSetupVO> aftBkgList = null;
		try {
			aftBkgPathSetupVO.setRhqCd(aftBkgPathSetupVO.getRhqOfcCd());
			aftBkgList = dbDao.searchAfterBookingApprovalPathSetupList(aftBkgPathSetupVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify charge uc flag"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify charge uc flag"}).getMessage());
		}				
		return aftBkgList;
	}
	
	/**
	 * After BKG Approval Setup 메뉴에서 등록 및 수정, 삭제된 설정정보에 대한 트랜잭션처리를 관리합니다. <br> 
	 * 
	 * @param AftBkgPathSetupVO[] aftBkgPathSetupVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAftBkgPathSetup(AftBkgPathSetupVO[] aftBkgPathSetupVOs, SignOnUserAccount account) throws EventException {
		
		try {
			List<AftBkgPathSetupVO> insertVoList 	= new ArrayList<AftBkgPathSetupVO>();
			List<AftBkgPathSetupVO> deleteVoList	= new ArrayList<AftBkgPathSetupVO>();
			List<AftBkgPathSetupVO> updateVoList 	= new ArrayList<AftBkgPathSetupVO>();
			
			if (aftBkgPathSetupVOs != null) {
				
				// Insert가 있는 경우 SEQ 등록이 필요하기 때문에 최대 SEQ 조회 후 등록될 SEQ 값을 미리 VO에 등록한다.
				int maxSeq = Integer.valueOf(dbDao.searchAftBkgMaxSequence());
				log.debug("\n[manageAftBkgPathSetup] maxSeq = " + maxSeq);
				
				// update의 경우 DB에서 유효성 검증할 때 자기 자신의 데이터와 중복 비교하는 상황이 생기기에 제외할 수 있도록 SEQ 리스트를 저장해둔다.
				List<String> updateSeqList = new ArrayList<String>();
				
				for (AftBkgPathSetupVO aftBkgPathSetupVO : aftBkgPathSetupVOs) {
					
					aftBkgPathSetupVO.setCreUsrId(account.getUsr_id());
					aftBkgPathSetupVO.setUpdUsrId(account.getUsr_id());
					
					// 트랜잭션별로 데이터를 분리한다.
					if ("D".equals(aftBkgPathSetupVO.getIbflag())) {

						deleteVoList.add(aftBkgPathSetupVO);
					} 
					else if("I".equals(aftBkgPathSetupVO.getIbflag())) {
						aftBkgPathSetupVO.setAftBkgPathStupSeq(String.valueOf(++maxSeq));
						insertVoList.add(aftBkgPathSetupVO);
					} 
					else if("U".equals(aftBkgPathSetupVO.getIbflag())) {
						updateSeqList.add(aftBkgPathSetupVO.getAftBkgPathStupSeq());
						updateVoList.add(aftBkgPathSetupVO);
					}
				}
				
				// 신규, 수정항목에 대해서 필수입력여부, 유효성 체크(DB조회) 실행
				if (insertVoList.size() > 0 || updateVoList.size() > 0) {
					log.debug("\n[manageAftBkgPathSetup] >>>>>. 필수입력여부 체크");
					
					// 1. 필수입력항목에 대한 체크를 실행합니다.
					this.checkMandatoryAftBkgPathSetup(insertVoList);
					this.checkMandatoryAftBkgPathSetup(updateVoList);
					
					log.debug("\n[manageAftBkgPathSetup] >>>>>. 입력값 유효성 체크(중복체크)");
					// 2. 입력된 항목에 대한 유효성 체크를 실행합니다.(중복체크)
//					this.checkValidateAftBkgPathSetup(insertVoList);
//					this.checkValidateAftBkgPathSetup(updateVoList);
				}
				
				
				// 삭제작업을 제일 먼저 실행한다.
				if (deleteVoList.size() > 0) { 	//삭제
					//데이터 삭제 Flag 변경
					dbDao.removeAftBkgPathSetup(deleteVoList);
				}				
				// 변경작업을 실행한다.
				if (updateVoList.size() > 0) { 	//수정
					//실제 데이터 수정
//					dbDao.modifyAftBkgPathSetup(updateVoList);			//마스터 정보 수정
					for(AftBkgPathSetupVO aftBkgPathSetupVO :updateVoList) {
						checkValidateAftBkgPathSetup(aftBkgPathSetupVO, updateSeqList);
						dbDao.modifyAftBkgPathSetup(aftBkgPathSetupVO);
					}
				}	
				// 등록작업을 실행한다.
				if (insertVoList.size() > 0) { //등록					
//					dbDao.addAftBkgPathSetup(insertVoList);
					for(AftBkgPathSetupVO aftBkgPathSetupVO :insertVoList) {
						checkValidateAftBkgPathSetup(aftBkgPathSetupVO);
						dbDao.addAftBkgPathSetup(aftBkgPathSetupVO);
					}
				}
				
				
			}
		} 
		catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"after booking approval path setup"}).getUserMessage());
		} 
		catch (EventException ex) {
			log.error(ex.getMessage());
			throw ex;
		}		
		catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"after booking approval path setup"}).getUserMessage());
		}	
	}
	
	/**
	 * After BKG Path 필수입력항목에 대한 체크를 수행합니다. <br> 
	 * 
	 * @param List<AftBkgPathSetupVO> aftBkgPathSetupVOList
	 * @exception EventException
	 */	
	private void checkMandatoryAftBkgPathSetup(List<AftBkgPathSetupVO> aftBkgPathSetupVOList) throws EventException {
		
		try {		
			// 필수입력체크
			for (AftBkgPathSetupVO aftBkgPathSetupVO : aftBkgPathSetupVOList) {
				
				//>. Effective Date 입력값 체크
				if (StringUtil.isEmpty(aftBkgPathSetupVO.getEffDt())) {
					//>. 업무예외발생
					//>. DMT02046 : {?msg1} is mandatory. Please enter {?msg1}.
					throw new EventException(new ErrorHandler("COM12201", new String[]{"Eff DT", "Eff DT"}).getUserMessage());
				}
				//>. From & To DC Amount 입력값 체크 >> 둘 중 최소 하나의 값은 있어야 함
				if (StringUtil.isEmpty(aftBkgPathSetupVO.getFmDcAmt()) && StringUtil.isEmpty(aftBkgPathSetupVO.getToDcAmt())) {
					//>. 업무예외발생
					//>. DMT02046 : {?msg1} is mandatory. Please enter {?msg1}.
					throw new EventException(new ErrorHandler("COM12201", new String[]{"Fm or To Amount required"}).getUserMessage());
				}
				//>. RHQ 입력값 체크
				if (StringUtil.isEmpty(aftBkgPathSetupVO.getRhqCd())) {
					//>. 업무예외발생
					//>. DMT02046 : {?msg1} is mandatory. Please enter {?msg1}.
					throw new EventException(new ErrorHandler("COM12201", new String[]{"RHQ", "RHQ"}).getUserMessage());
				}
				//>. 선택 항목 중 1개 이상 선택여부 체크
				if ("0".equals(aftBkgPathSetupVO.getBrncOfcPicChkFlg()) 
					&& StringUtil.isEmpty(aftBkgPathSetupVO.getBrncOfcMgrAproFlg())
					&& StringUtil.isEmpty(aftBkgPathSetupVO.getRhqPicChkFlg())
					&& StringUtil.isEmpty(aftBkgPathSetupVO.getRhqMgrAproFlg())
					&& StringUtil.isEmpty(aftBkgPathSetupVO.getHoPicChkFlg())
					&& StringUtil.isEmpty(aftBkgPathSetupVO.getHoMgrAproFlg())) {
					//>. 업무예외발생
					//>. DMT02046 : {?msg1} is mandatory. Please enter {?msg1}.
					throw new EventException(new ErrorHandler("COM12201", new String[]{"BOG or BBG or RHQ or HO", "BOG or BBG or RHQ or HO"}).getUserMessage());
				}				
				//>. Expiration Date 입력시 Effective Date 와의 유효성 체크
				if (!StringUtils.isEmpty(aftBkgPathSetupVO.getExpDt())) {
					SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
					
					Date effDt = date.parse(aftBkgPathSetupVO.getEffDt());  
					Date expDt = date.parse(aftBkgPathSetupVO.getExpDt());
	      
	                if (!expDt.after(effDt)) {
						//>. 업무예외발생
	                	//>. DMT02046 : {?msg1} must be less than {?msg1}.
						throw new EventException("Eff DT must be less than Exp DT");
	                }
				}
				//>. To DC Amount 입력시 From DC Amount 와의 유효성 체크
				if (!StringUtils.isEmpty(aftBkgPathSetupVO.getFmDcAmt()) && !StringUtils.isEmpty(aftBkgPathSetupVO.getToDcAmt())) {
					
					float fmAmt = Float.valueOf(aftBkgPathSetupVO.getFmDcAmt());
					float toAmt = Float.valueOf(aftBkgPathSetupVO.getToDcAmt());
					
//					if (toAmt < fmAmt) {
					if (0 > Double.compare(toAmt, fmAmt)) {
						//>. 업무예외발생
						//>. DMT02046 : {?msg1} must be less than {?msg1}.
						throw new EventException("From Amount must be less than To Amount");
					}
				}
			}
		}
		catch (EventException ex) {
			log.error(ex.getMessage());
			throw ex;
		}
		catch (Exception ex) {
			log.error(ex.getMessage());
			// DMT00003 : Failed to save $s. Please try it again.
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"during checking mandatory"}).getUserMessage());
		}			
	}
	
	
	/**
	 * After BKG Path 입력항목값에 대한 유효성 체크를 수행합니다. <br> 
	 * 
	 * @param List<AftBkgPathSetupVO> aftBkgPathSetupVOList
	 * @exception EventException
	 */	
	private void checkValidateAftBkgPathSetup(AftBkgPathSetupVO aftBkgPathSetupVO) throws EventException {
		
		checkValidateAftBkgPathSetup(aftBkgPathSetupVO, null);
	}
	
	/**
	 * After BKG Path 입력항목값에 대한 유효성 체크를 수행합니다. <br> 
	 * 
	 * @param List<AftBkgPathSetupVO> aftBkgPathSetupVOList
	 * @param List<Integer> updateSeqList
	 * @exception EventException
	 */	
	private void checkValidateAftBkgPathSetup(AftBkgPathSetupVO aftBkgPathSetupVO, List<String> updateSeqList) throws EventException {
		
		try {
			//>. 중복입력여부 체크
			if (dbDao.isDuplicateAftBkgPathSetup(aftBkgPathSetupVO)) {					
				
//					String dupOfcCds = dbDao.searchDuplicateAftBkgPath(aftBkgPathSetupVO);
				
				StringBuilder sb = new StringBuilder();
				sb.append("\n");
//					sb.append("     ").append("Eff DT").append(" = '").append(chgDeltPathStupVO.getEffDt()).append("'").append("\n");
//					sb.append("     ").append("Exp DT").append(" = '").append(StringUtils.defaultIfEmpty(chgDeltPathStupVO.getExpDt(), "")).append("'").append("\n");
//					sb.append("     ").append("RHQ").append(" = '").append(chgDeltPathStupVO.getChgDeltRhqCd()).append("'").append("\n");
//					sb.append("     ").append("Duplicate Office").append(" = [").append(dupOfcCds).append("]");
				//>. 업무예외발생
				//>. DMT02048 : The duplicated data exists.{?msg1}
				throw new EventException("중복 데이터");
			}
			
			//>. 유효한 날짜인지 체크
			String dateFlag = dbDao.checkAvailableDate(aftBkgPathSetupVO, updateSeqList);
			String amtFlag = dbDao.checkAvailableAmount(aftBkgPathSetupVO, updateSeqList);
	
			if ((dateFlag.equals("E") || dateFlag.equals("R")) && amtFlag.equals("E")) {
				throw new EventException("Duplicated date or USD Amount. Please check your input.");
			}
		}
		catch (DAOException ex) {
			log.error(ex.getMessage());
			// DMT00003 : Failed to save $s. Please try it again.
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"during checking duplicate input"}).getUserMessage());
		} 
		catch (EventException ex) {
			log.error(ex.getMessage());
			throw ex;
		}		
		catch (Exception ex) {
			log.error(ex.getMessage());
			// DMT00003 : Failed to retrieve $s. Please try it again.
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"during checking duplicate input"}).getUserMessage());
		}		
	}

	/**
	 * Inactive History 을 조회한다.<br>
	 * 
	 * @param ChargeInactivDetailVO chargeInactivDetailVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCharge(ChargeInactivDetailVO chargeInactivDetailVO) throws EventException {
		
		try {
			return dbDao.searchCharge(chargeInactivDetailVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		}		
	}

	/**
	 * Inactive Reason 을 조회한다.<br>
	 * 
	 * @param InactiveReasonVO inactiveReasonVO
	 * @return List<InactiveReasonVO>
	 * @exception EventException
	 */
	public List<InactiveReasonVO> searchInactiveReason(InactiveReasonVO inactiveReasonVO) throws EventException {		
		try {
			return dbDao.searchInactiveReason(inactiveReasonVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		}		
	}

	/**
	 * Inactive List 을 조회한다.<br>
	 * 
	 * @param InactiveInputVO inactiveInputVO
	 * @param SignOnUserAccount account
	 * @return List<InactiveListVO>
	 * @exception EventException
	 */
	public List<InactiveListVO> searchInactiveList(InactiveInputVO inactiveInputVO, SignOnUserAccount account) throws EventException {		
		try {
			inactiveInputVO.setUsrId(account.getUsr_id());
			inactiveInputVO.setUsrOfcCd(account.getOfc_cd());
			return dbDao.searchInactiveList(inactiveInputVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		}		
	}
	
	/**
	 * Booking Info, INV Validation<br>
	 * 
	 * @param SearchInactiveCheckVO searchInactiveCheckVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBookingInfo(SearchInactiveCheckVO searchInactiveCheckVO) throws EventException {
		
		try {
			return dbDao.searchBookingInfo(searchInactiveCheckVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		}		
	}
	
	/**
	 * Inactive 최종인지 아닌지 확인하는 부분임.<br>
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isChargeDeletionLastApprovalPath(ChargeCalculationContainerVO chgCalcCntrVO) throws EventException {
		
		try {
			return dbDao.isChargeDeletionLastApprovalPath(chgCalcCntrVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		}		
	}	
	
	/**
	 * Inactive Reason 중 FESCO S/C case Contract Customer(US067219)여부를 확인한다<br>
	 * 
	 * @param String scNo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean searchContractCustomer(String scNo) throws EventException {
		try {
			return dbDao.searchContractCustomer(scNo);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		}
	}
	
	/**
	 * Inactive Reason 중 FESCO S/C case 입력받은 Invoice Cancel 여부를 확인한다<br>
	 * 
	 * @param String invNo
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceStatus(String invNo) throws EventException {
		try {
			return dbDao.searchInvoiceStatus(invNo);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		}
	}
	
	/**
	 * OC 시점의 Container Movement Date 조회
	 * @param String temp_bkg_no, String temp_cntr_no, String temp_cntr_cyc_no
	 * @return String
	 * @throws EventException
	 */
	
	public String searchOcCnmvDt(String temp_bkg_no, String temp_cntr_no, String temp_cntr_cyc_no ) throws EventException {
		try {
			return dbDao.searchOcCnmvDt( temp_bkg_no,  temp_cntr_no,  temp_cntr_cyc_no);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Exemption Reason Entry"}).getMessage());
		}
	}
	
	
}

