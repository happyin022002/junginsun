/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationDBDAO.java
*@FileTitle : Charge Calculation by Office & VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.05.22 황효근
* 1.0 Creation
* 2011.08.04 김경섭[] [EES-DMT] 표준위배 수정
* 2011.11.09 김현화[CHM-201113641-01] sendEDI시 checkEDI추가.(BKG_CSTMS_KR_MF_SEQ_NO)
* 2012.09.11 김현화[CHM-201219003-01]OP-MT Detention Calculation 화면/기능 개발. 
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.AftBkgPathSetupVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.AfterExceptionTariffParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.AfterExceptionTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.BalanceCreationChargeVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.BasicCurrencyCoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.BasicTariffParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.BeforeExceptionTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.BkgContainerInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeBasicFreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeByOfficeOrVVDVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDeletionRequstVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDeltSpecRsnRmkVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeInactivDetailVO;
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
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.EDIVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ExceptionCostVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.InactiveInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.InactiveListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.InactiveReasonVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ManualChargeCreationVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.MovementSZPBBParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.MovementSZPBBVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.OPMTChargeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.OfficeNRHQVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.OfficeTransferParmByChargeVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SCExceptionTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchChgDeltPathStupVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchDeleteMultiDetailReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchDeleteMultiReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchInactiveCheckVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.VDMovementVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.OfficeNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationTypeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExceptionChargeCalculationVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * NIS2010 ChargeCalculationDBDAO <br>
 * - NIS2010-DMTClosing system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see ChargeCalculationBCImpl 참조
 * @since J2EE 1.6
 */
public class ChargeCalculationDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 7199763710750773208L;

	/**
	 * Office별 또는 VVD별 Charge List 정보를 조회한다.
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO
	 * @return List<ChargeCalculationContainerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChargeCalculationContainerVO> searchChargeListByOfficeOrVVD(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChargeCalculationContainerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chargeByOfficeOrVVDVO != null){
				Map<String, String> mapVO = chargeByOfficeOrVVDVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String trfCd = chargeByOfficeOrVVDVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(trfCd, ",");
			    while (st.hasMoreTokens()) {
			    	trfCdList.add(st.nextToken());
			    }
				velParam.put("trf_cd_list", trfCdList);
				
				String chgStsCd = chargeByOfficeOrVVDVO.getDmdtChgStsCd();
				List<String> chgStsCdList = new ArrayList<String>();
				StringTokenizer st2 = new StringTokenizer(chgStsCd, ",");
			    while (st2.hasMoreTokens()) {
			    	chgStsCdList.add(st2.nextToken());
			    }
				velParam.put("chg_sts_cd_list", chgStsCdList);
				
				
				if(chargeByOfficeOrVVDVO.getCondType().equals("cntr")) {
					if(!chargeByOfficeOrVVDVO.getBkgNo().equals("")) {
						String bkgNo = chargeByOfficeOrVVDVO.getBkgNo();
						List<String> bkgNoList = new ArrayList<String>();
						StringTokenizer st3 = new StringTokenizer(bkgNo, ",");
					    while (st3.hasMoreTokens()) {
					    	bkgNoList.add(st3.nextToken());
					    }
						velParam.put("bkg_no_list", bkgNoList);
					}
					
					if(!chargeByOfficeOrVVDVO.getBlNo().equals("")) {
						String blNo = chargeByOfficeOrVVDVO.getBlNo();
						List<String> blNoList = new ArrayList<String>();
						StringTokenizer st4 = new StringTokenizer(blNo, ",");
					    while (st4.hasMoreTokens()) {
					    	blNoList.add(st4.nextToken());
					    }
						velParam.put("bl_no_list", blNoList);
					}
					
					if(!chargeByOfficeOrVVDVO.getCntrNo().equals("")) {
						String cntrNo = chargeByOfficeOrVVDVO.getCntrNo();
						List<String> cntrNoList = new ArrayList<String>();
						StringTokenizer st5 = new StringTokenizer(cntrNo, ",");
					    while (st5.hasMoreTokens()) {
					    	cntrNoList.add(st5.nextToken());
					    }
						velParam.put("cntr_no_list", cntrNoList);
					}
				}
				
				if(!chargeByOfficeOrVVDVO.getOptItemList().equals("")) {
					String optItemList = chargeByOfficeOrVVDVO.getOptItemList();
					String [] arrList = optItemList.split(",");
					
					for(int i = 0; i < arrList.length; i ++){
						if ( arrList[i].equals("OP_BKG_INFO") ) {
							velParam.put("op_bkg_info", "OK");
						} else if ( arrList[i].equals("BKG_INFO") ) {
							velParam.put("bkg_info", "OK");
						} else if ( arrList[i].equals("CUST_INFO") ) {
							velParam.put("cust_info", "OK");
						} else if ( arrList[i].equals("CORR_INFO") ) {
							velParam.put("corr_info", "OK");
						}
					}
				}
				
				// 2016.07.12 Added
				if(!chargeByOfficeOrVVDVO.getAftDarStsCd().equals("")) {
					String aftDarStsCd = chargeByOfficeOrVVDVO.getAftDarStsCd();
					List<String> aftDarStsCdLsit = new ArrayList<String>();
					StringTokenizer tokenizer = new StringTokenizer(aftDarStsCd, ",");
				    while (tokenizer.hasMoreTokens()) {
				    	aftDarStsCdLsit.add(tokenizer.nextToken());
				    }
				    
				    if(aftDarStsCdLsit.contains("All")){
				    	// AFT DAR All 상태면 상태값이 있는 모든 FLG 조회
				    	velParam.put("aft_dar_sts_all_flg", "Y");
				    } else {
				    	if(aftDarStsCdLsit.contains("RC")){
				    		// Reject, Counter Offer 인 경우 해당 상태값을 넣어줌
				    		aftDarStsCdLsit.add("J");
				    		aftDarStsCdLsit.add("O");
				    		aftDarStsCdLsit.remove("RC");
				    	}
				    	if(aftDarStsCdLsit.contains("P")){
				    		velParam.put("aft_dar_sts_process_flg", "Y");
				    	}
				    }
				    velParam.put("aft_dar_sts_cd_list", aftDarStsCdLsit);
				}
				// 2016.07.12 Added

				String inactStsCd = chargeByOfficeOrVVDVO.getInactStsCd();
				List<String> inactStsCdList = new ArrayList<String>();
				StringTokenizer st5 = new StringTokenizer(inactStsCd, ",");
			    while (st5.hasMoreTokens()) {
			    	inactStsCdList.add(st5.nextToken());
			    }
				velParam.put("inact_sts_cd_list", inactStsCdList);
				
				String inactNo = chargeByOfficeOrVVDVO.getInactNo();
				List<String> inactNoList = new ArrayList<String>();
				StringTokenizer st6 = new StringTokenizer(inactNo, ",");
			    while (st6.hasMoreTokens()) {
			    	inactNoList.add(st6.nextToken());
			    }
				velParam.put("inact_no_list", inactNoList);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOChargeCalculationContainerVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeCalculationContainerVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 
	 /**
	 * SZPSC Office로 생성된 Container Charge List를 조회한다.<br>
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO
	 * @return List<ChargeCalculationContainerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChargeCalculationContainerVO> searchChargeBySZPBB(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChargeCalculationContainerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chargeByOfficeOrVVDVO != null){
				Map<String, String> mapVO = chargeByOfficeOrVVDVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				
				if(chargeByOfficeOrVVDVO.getCondType().equals("cntr")) {
					if(!chargeByOfficeOrVVDVO.getBkgNo().equals("")) {
						String bkgNo = chargeByOfficeOrVVDVO.getBkgNo();
						List<String> bkgNoList = new ArrayList<String>();
						StringTokenizer st3 = new StringTokenizer(bkgNo, ",");
					    while (st3.hasMoreTokens()) {
					    	bkgNoList.add(st3.nextToken());
					    }
						velParam.put("bkg_no_list", bkgNoList);
					}
					
					if(!chargeByOfficeOrVVDVO.getBlNo().equals("")) {
						String blNo = chargeByOfficeOrVVDVO.getBlNo();
						List<String> blNoList = new ArrayList<String>();
						StringTokenizer st4 = new StringTokenizer(blNo, ",");
					    while (st4.hasMoreTokens()) {
					    	blNoList.add(st4.nextToken());
					    }
						velParam.put("bl_no_list", blNoList);
					}
					
					if(!chargeByOfficeOrVVDVO.getCntrNo().equals("")) {
						String cntrNo = chargeByOfficeOrVVDVO.getCntrNo();
						List<String> cntrNoList = new ArrayList<String>();
						StringTokenizer st5 = new StringTokenizer(cntrNo, ",");
					    while (st5.hasMoreTokens()) {
					    	cntrNoList.add(st5.nextToken());
					    }
						velParam.put("cntr_no_list", cntrNoList);
					}
				}
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeBySZPBBRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeCalculationContainerVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 

	/**
	 * SZPSC Office로 발생한 Charge관련한 Movement Data를 조회한다.<br>
	 * 
	 * @param MovementSZPBBParmVO movementSZPBBParmVO
	 * @return MovementSZPBBVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public MovementSZPBBVO searchMovementBySZPBB(MovementSZPBBParmVO movementSZPBBParmVO) throws DAOException {
		
		List<MovementSZPBBVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(movementSZPBBParmVO != null) {
				Map<String, String> mapVO = movementSZPBBParmVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOMovementSZPBBVORSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MovementSZPBBVO .class);
			
			MovementSZPBBVO movementSZPBBVO = null;
			if(list != null && list.size() > 0) {
				movementSZPBBVO = (MovementSZPBBVO)list.get(0);
			}
			
			return movementSZPBBVO;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * SZPSC Office로 발생한 Charge관련한 Movement Data를 조회한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return BkgContainerInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgContainerInfoVO searchBookingContainerBySZPBB(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		
		List<BkgContainerInfoVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOBkgContainerInfoVORSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgContainerInfoVO .class);
			
			BkgContainerInfoVO bkgContainerInfoVO = null;
			if(list != null && list.size() > 0) {
				bkgContainerInfoVO = (BkgContainerInfoVO)list.get(0);
			}
			
			return bkgContainerInfoVO;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * SZPSC Office로 발생한 Charge관련한 Movement Data를 조회한다.<br>
	 * 
	 * @param String vvdCd
	 * @param String ydCd
	 * @param String trfCd
	 * @param String type
	 * @return String
	 * @throws DAOException
	 */
	public String searchVLVDDate(String vvdCd, String ydCd, String trfCd, String type) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			//Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.put("vvd_cd", vvdCd);
			param.put("yd_cd", ydCd);
			param.put("dmdt_trf_cd", trfCd);
			velParam.put("type", type);			
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchVLVDDateRSQL(), param, velParam);
			
			String result = "";
			if(dbRowset.next()) {
				result = dbRowset.getString(1);
			}
			
			return result;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 

	/**
	 * Yard별 Container List 정보를 조회한다.
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO
	 * @return List<ChargeCalculationContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChargeCalculationContainerVO> searchChargeListByPodEta(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<ChargeCalculationContainerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chargeByOfficeOrVVDVO != null){
				Map<String, String> mapVO = chargeByOfficeOrVVDVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if(!chargeByOfficeOrVVDVO.getBypodeta().equals("booking")) {
					String trfCd = chargeByOfficeOrVVDVO.getDmdtTrfCd();
					List<String> trfCdList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(trfCd, ",");
				    while (st.hasMoreTokens()) {
				    	trfCdList.add(st.nextToken());
				    }
					velParam.put("trf_cd_list", trfCdList);
				}
				
				if(chargeByOfficeOrVVDVO.getCondType().equals("cntr")) {
					if(!chargeByOfficeOrVVDVO.getBkgNo().equals("")) {
						String bkgNo = chargeByOfficeOrVVDVO.getBkgNo();
						List<String> bkgNoList = new ArrayList<String>();
						StringTokenizer st3 = new StringTokenizer(bkgNo, ",");
					    while (st3.hasMoreTokens()) {
					    	bkgNoList.add(st3.nextToken());
					    }
						velParam.put("bkg_no_list", bkgNoList);
					}
					
					if(!chargeByOfficeOrVVDVO.getBlNo().equals("")) {
						String blNo = chargeByOfficeOrVVDVO.getBlNo();
						List<String> blNoList = new ArrayList<String>();
						StringTokenizer st4 = new StringTokenizer(blNo, ",");
					    while (st4.hasMoreTokens()) {
					    	blNoList.add(st4.nextToken());
					    }
						velParam.put("bl_no_list", blNoList);
					}
					
					// 2016.07.12 Added
					if(!chargeByOfficeOrVVDVO.getAftDarStsCd().equals("")) {
						log.error("===Charge by Office===="+ chargeByOfficeOrVVDVO);
						String aftDarStsCd = chargeByOfficeOrVVDVO.getAftDarStsCd();
						List<String> aftDarStsCdLsit = new ArrayList<String>();
						StringTokenizer tokenizer = new StringTokenizer(aftDarStsCd, ",");
					    while (tokenizer.hasMoreTokens()) {
					    	aftDarStsCdLsit.add(tokenizer.nextToken());
					    }
					    
					    if(aftDarStsCdLsit.contains("All")){
					    	// AFT DAR All 상태면 상태값이 있는 모든 FLG 조회
					    	velParam.put("aft_dar_sts_all_flg", "Y");
					    } else {
					    	if(aftDarStsCdLsit.contains("RC")){
					    		// Reject, Counter Offer 인 경우 해당 상태값을 넣어줌
					    		aftDarStsCdLsit.add("J");
					    		aftDarStsCdLsit.add("O");
					    		aftDarStsCdLsit.remove("RC");
					    	}
					    	if(aftDarStsCdLsit.contains("P")){
					    		velParam.put("aft_dar_sts_process_flg", "Y");
					    	}
					    }
					    velParam.put("aft_dar_sts_cd_list", aftDarStsCdLsit);
					}
					// 2016.07.12 Added
					
				}
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeListByPodEtaRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeCalculationContainerVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	 /**
	 * Coverage 정보를 조회한다.
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO
	 * @return CalculationTypeParmVO
	 * @throws DAOException
	 */
	public CalculationTypeParmVO searchMdmLocation(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws DAOException {
	
		CalculationTypeParmVO calculationTypeParmVO = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeByOfficeOrVVDVO != null){
				Map<String, String> mapVO = chargeByOfficeOrVVDVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOMdmLocationRSQL(), param, velParam);
			if(dbRowset.next()) {
				calculationTypeParmVO = new CalculationTypeParmVO();
				calculationTypeParmVO.setCntCd(dbRowset.getString("cnt_cd"));
				calculationTypeParmVO.setRgnCd(dbRowset.getString("rgn_cd"));
				calculationTypeParmVO.setStateCd(dbRowset.getString("ste_cd"));
				calculationTypeParmVO.setLocCd(dbRowset.getString("loc_cd"));
				calculationTypeParmVO.setEffDt(dbRowset.getString("eff_dt"));
				calculationTypeParmVO.setLocRhqCd(dbRowset.getString("loc_rhq_cd"));
			}
			return calculationTypeParmVO;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Charge History 정보를 생성한다.
	 * 
	 * @param DmtChgCorrHisVO dmtChgCorrHisVO
	 * @throws DAOException
	 */
	public void addChargeHistory(DmtChgCorrHisVO dmtChgCorrHisVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dmtChgCorrHisVO.getColumnValues();
			
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODmtChgCorrHisVOCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 해당 Charge의 Charge Status 를 'Confirmed' 상태로 수정한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @throws DAOException
	 */
	public int modifyChargeByConfirm(ChargeArgumentVO chargeArgumentVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOChargeByConfirmUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	
	/**
	 * Charge 생성시 Snap Shop 정보인 Booking Container Data를 조회한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return DmtChgBkgCntrVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DmtChgBkgCntrVO searchCalculationBookingContainer(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		List<DmtChgBkgCntrVO> list = null;
		DmtChgBkgCntrVO dmtChgBkgCntrVO = null;
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if(chargeArgumentVO.getBypodeta().equals("")) {				
					String chgStsCd = chargeArgumentVO.getDmdtChgStsCd();
					List<String> chgStsCdList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(chgStsCd, ",");
				    while (st.hasMoreTokens()) {
				    	chgStsCdList.add(st.nextToken());
				    }
					velParam.put("chg_sts_cd_list", chgStsCdList);
				}
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAODmtChgBkgCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtChgBkgCntrVO.class);
			
			if(list != null && list.size() > 0) {
				dmtChgBkgCntrVO = (DmtChgBkgCntrVO)list.get(0);
			} else {
				dmtChgBkgCntrVO = new DmtChgBkgCntrVO();
			}
			
			return dmtChgBkgCntrVO;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 해당 Charge의 Charge Sequence 최대값을 조회한다. 
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchChargeMaxSequence (ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		//List<ChargeCalculationContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				//velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeMaxSequenceRSQL(), param, null);
			
			String maxChgSeq = "";
			if(dbRowset.next())
				maxChgSeq = dbRowset.getString(1);
			
			return maxChgSeq;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Charge Deletion Sequence, Charge Office Code 를 조회한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return Map<String, String>
	 * @throws DAOException
	 */
	public Map<String, String> searchChargeDeletionInfo(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query result
		Map<String, String> result = new HashMap<String, String>();
		
		try {
			if (chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
			
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionInfoRSQL(), param, null);

				if (dbRowset.next()) {
					result.put("CHG_OFC_CD", dbRowset.getString(1));
					result.put("DELT_SEQ",   dbRowset.getString(2));
				}
			}
		}
		catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}	
	
	
	/**
	 * Status가 Invoiced인 해당 Charge의 존재여부 정보를 조회한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchChargeInvoiceCheck (ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		//List<ChargeCalculationContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				//velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeInvoiceCheckRSQL(), param, null);
			boolean chgInvChk = false;
			
			if(dbRowset.next()) {
				chgInvChk = true;
			}
			return chgInvChk;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * Charge Booking CNTR의 해당 PreCal 정보 존재여부를 조회한다. 
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkPreChargeBookingContainerExists (ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		//List<ChargeCalculationContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAODmtChgPreCalcBkgCntrExistRSQL(), param, null);
			boolean isExist = false;
			
			if(dbRowset.next()) {
				int cnt = dbRowset.getInt(1);
				if(cnt > 0)
					isExist = true;
			}
			return isExist;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 *  해당 Charge의 Booking Container 정보를 Pre-Calculation 테이블에 추가한다.
	 *  
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @throws DAOException
	 */
	public void createPreChargeBookingContainer(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODmtChgPreCalcBkgCntrCSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 해당 Charge의 Booking Container 정보를 Pre-Calculation 테이블에서 삭제한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @throws DAOException
	 */
	public void deletePreChargeBookingContainer(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODmtChgPreCalcBkgCntrDSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to deletePreChargeCalculation SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 해당 Charge 정보가 Pre-Calculation 테이블에 존재하는지 여부를 조회한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkPreChargeCalculationExists (ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		//List<ChargeCalculationContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAODmtChgPreCalcExistRSQL(), param, null);
			boolean isExist = false;
			
			if(dbRowset.next()) {
				int cnt = dbRowset.getInt(1);
				if(cnt > 0)
					isExist = true;
			}
			return isExist;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 해당 Charge정보를 Pre-Calculation 테이블에 추가한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @throws DAOException
	 */
	public void createPreChargeCalculation(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODmtChgPreCalcCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 해당 Charge의 Pre-Calculation 정보를 삭제한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @throws DAOException
	 */
	public void deletePreChargeCalculation(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODmtChgPreCalcDSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to deletePreChargeCalculation SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Charge Calculation에 필요한 정보들을 조회한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return ChargePartialPaymentVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChargePartialPaymentVO searchChargeCalculationUseData(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		List<ChargePartialPaymentVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ChargePartialPaymentVO chargePartialPaymentVO = null;
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.put("bydr", chargeArgumentVO.getBydr());
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOChargePartialPaymentRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargePartialPaymentVO .class);
			
			if(list != null && list.size() > 0) {
				chargePartialPaymentVO = list.get(0);
			} else {
				throw new DAOException("BKG Data Select Error");
			}
			
			return chargePartialPaymentVO;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Charge Calculation에 필요한 정보들을 조회한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return ChargePartialPaymentVO
	 * @throws DAOException
	 */
	public ChargePartialPaymentVO searchChargeCalculationUseDataByDR(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		
		chargeArgumentVO.setBydr("DR");
		return searchChargeCalculationUseData(chargeArgumentVO);
	}
	
	
	/**
	 * 해당 Charge의 Web Indicator 정보를 수정한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @throws DAOException
	 */
	public void modifyChargeWebIndicator(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOChargeWebIndicatorUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Update MT Notification Error");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Charge가 발생된 Office(FM_OFC_CD)와 Charge를 Office Transfer받아 처리할 Office(TO_OFC_CD) 정보를 조회한다. 
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return OfficeNRHQVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public OfficeNRHQVO checkOfficeTransfer(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		List<OfficeNRHQVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		OfficeNRHQVO officeNRHQVO = null;
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOOfficeNRHQRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeNRHQVO.class);
			
			if(list != null && list.size() > 0) {
				officeNRHQVO = list.get(0);
			}
			return officeNRHQVO;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 *  Pre-Calculation한 Data의 Pre Booking Container 정보를 수정한다.
	 * 
	 * @param DmtChgBkgCntrVO dmtChgBkgCntrVO
	 * @throws DAOException
	 */
	public void modifyPreBookingContainer(DmtChgBkgCntrVO dmtChgBkgCntrVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dmtChgBkgCntrVO.getColumnValues();
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODmtChgPreCalcBkgCntrUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Update PreBookingContainer Error");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Pre-Calculation한 Data의 Pre Charge 정보를 수정한다.
	 * 
	 * @param DmtChgCalcVO dmtChgCalcVO
	 * @throws DAOException
	 */
	public void modifyPreCharge(DmtChgCalcVO dmtChgCalcVO)
		throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dmtChgCalcVO.getColumnValues();
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODmtChgPreCalcUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Update PreCharge Error");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 해당 Charge의 Booking Container 정보를 수정한다.
	 * 
	 * @param DmtChgBkgCntrVO dmtChgBkgCntrVO
	 * @throws DAOException
	 */
	public void modifyBookingContainer(DmtChgBkgCntrVO dmtChgBkgCntrVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dmtChgBkgCntrVO.getColumnValues();
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODmtChgBkgCntrUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Update PreBookingContainer Error");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 해당 Charge의 Correction Remark 정보를 수정한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @throws DAOException
	 */
	public void modifyChargeCorrRmk(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyChargeCorrRmkUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Update ChargeCorrRmk Error");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 해당 Charge의 Calculation 정보를 수정한다.
	 * 
	 * @param DmtChgCalcVO dmtChgCalcVO
	 * @throws DAOException
	 */
	public void modifyChargeCalculation(DmtChgCalcVO dmtChgCalcVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = dmtChgCalcVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODmtChgCalcUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Update PreCharge Error");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 이미 생성된 Clock Stop History 정보를 삭제한다.<br>
	 * 
	 * @param DmtChgTmCskStopVO dmtChgTmCskStopVO
	 * @throws DAOException
	 */
	public void deleteClockStopHistory(DmtChgTmCskStopVO dmtChgTmCskStopVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dmtChgTmCskStopVO.getColumnValues();
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODmtChgTmCskStopVODSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to deletePreChargeCalculation SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Clock Stop History가 존재하면 Clock Stop History를 Insert한다.<br>
	 * 
	 * @param DmtChgTmCskStopVO dmtChgTmCskStopVO
	 * @throws DAOException
	 */
	public void addClockStopHistory(DmtChgTmCskStopVO dmtChgTmCskStopVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dmtChgTmCskStopVO.getColumnValues();
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODmtChgTmCskStopVOCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			// PK Dup. Err가 아닌 경우에만 Error Log 남기도록 한다.(2010.04.05 수정)
			if(se.getErrorCode() != 1) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * No Balance Flag를 "Y"로 Setting한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @throws DAOException
	 */
	public void modifyChargeByNoBalance(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyChargeByNoBalanceUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("modifyChargeByNoBalance Error");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Charge Calculation 정보를 조회한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return List<ChargeCalculationContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChargeCalculationContainerVO> searchCalculationCharge(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		List<ChargeCalculationContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String chgStsCd = chargeArgumentVO.getDmdtChgStsCd();
				List<String> chgStsCdList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(chgStsCd, ",");
			    while (st.hasMoreTokens()) {
			    	chgStsCdList.add(st.nextToken());
			    }
				velParam.put("chg_sts_cd_list", chgStsCdList);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAODmtChgCalcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeCalculationContainerVO .class);
			return list;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Delete한 Charge를 이전 Status로 수정한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @param SignOnUserAccount account
	 * @return int
	 */
	public int modifyDeleteCancelCharge(ChargeArgumentVO chargeArgumentVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			param.put("ofc_cd", account.getOfc_cd());
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODeleteCancelChargeUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	
	/**
	 * Container별 Tariff Type별 Charge 한 건의 정보를 조회한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return ChargeCalculationContainerVO
	 */
	@SuppressWarnings("unchecked")
	public ChargeCalculationContainerVO searchChargeByContainer(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		
		List<ChargeCalculationContainerVO> list = null;
		ChargeCalculationContainerVO chgCalcCntrVO = null;
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOChargeByContainerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeCalculationContainerVO.class);
			
			if(list != null && list.size() > 0) {
				chgCalcCntrVO = (ChargeCalculationContainerVO)list.get(0);
			} else {
				chgCalcCntrVO = new ChargeCalculationContainerVO();
			}
			
			return chgCalcCntrVO;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 가장 최근에 생성된 Charge의 CNTR Cycle No, Charge Seqence 정보를 조회한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return ChargeArgumentVO
	 */
	@SuppressWarnings("unchecked")
	public ChargeArgumentVO searchCycleNoNSequence(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		
		List<ChargeArgumentVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.put("chg_type", chargeArgumentVO.getChgType());
			
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchCycleNoNSequenceRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeArgumentVO.class);
				
				if(list != null && list.size() > 0) {
					chargeArgumentVO = (ChargeArgumentVO)list.get(0);
				} else {
					chargeArgumentVO.setCntrCycNo("");
				}
			}
			
			return chargeArgumentVO;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 해당 Office의 날짜 / VVD 별 전체 CNTR List 정보를 조회한다.
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	 public DBRowSet searchChargeListByStatus(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chargeByOfficeOrVVDVO != null){
				Map<String, String> mapVO = chargeByOfficeOrVVDVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String ofcCd = chargeByOfficeOrVVDVO.getOfcCd();
				List<String> ofcCdList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(ofcCd, ",");
			    while (st.hasMoreTokens()) {
			    	ofcCdList.add(st.nextToken());
			    }
				velParam.put("ofc_cd_list", ofcCdList);
				
				String trfCd = chargeByOfficeOrVVDVO.getDmdtTrfCd();
				List<String> trfCdList = new ArrayList<String>();
				StringTokenizer st1 = new StringTokenizer(trfCd, ",");
			    while (st1.hasMoreTokens()) {
			    	trfCdList.add(st1.nextToken());
			    }
				velParam.put("trf_cd_list", trfCdList);
				
				String dmdtCntrTpCd = chargeByOfficeOrVVDVO.getDmdtCntrTpCd();
				List<String> dmdtCntrTpCdList = new ArrayList<String>();
				StringTokenizer st6 = new StringTokenizer(dmdtCntrTpCd, ",");
				if(!("").equals(dmdtCntrTpCd)){
				    while (st6.hasMoreTokens()) {
				    	dmdtCntrTpCdList.add(st6.nextToken());
				    }
				    velParam.put("dmdt_cntr_tp_cd_list", dmdtCntrTpCdList);
				}else {
					velParam.put("dmdt_cntr_tp_cd_list", "");
				}
				
				String dmdtBkgCgoTpCd = chargeByOfficeOrVVDVO.getDmdtBkgCgoTpCd();
				List<String> dmdtBkgCgoTpCdList = new ArrayList<String>();
				StringTokenizer st7 = new StringTokenizer(dmdtBkgCgoTpCd, ",");
				if(!("").equals(dmdtBkgCgoTpCd)){
				    while (st7.hasMoreTokens()) {
				    	dmdtBkgCgoTpCdList.add(st7.nextToken());
				    }
					velParam.put("dmdt_bkg_cgo_tp_cd_list", dmdtBkgCgoTpCdList);
				}else {
					velParam.put("dmdt_bkg_cgo_tp_cd_list", "");
					
				}
				
				String bkgRcvTermCd = chargeByOfficeOrVVDVO.getBkgRcvTermCd();
				List<String> bkgRcvTermCdList = new ArrayList<String>();
				StringTokenizer st8 = new StringTokenizer(bkgRcvTermCd, ",");
				if(!("").equals(bkgRcvTermCd)){
				    while (st8.hasMoreTokens()) {
				    	bkgRcvTermCdList.add(st8.nextToken());
				    }
					velParam.put("bkg_rcv_term_cd_list", bkgRcvTermCdList);
				}else {
					velParam.put("bkg_rcv_term_cd_list", "");
				}
				
				String bkgDeTermCd = chargeByOfficeOrVVDVO.getBkgDeTermCd();
				List<String> bkgDeTermCdList = new ArrayList<String>();
				StringTokenizer st9 = new StringTokenizer(bkgDeTermCd, ",");
				if(!("").equals(bkgDeTermCd)){
				    while (st9.hasMoreTokens()) {
				    	bkgDeTermCdList.add(st9.nextToken());
				    }
					velParam.put("bkg_de_term_cd_list", bkgDeTermCdList);
				}else {
					velParam.put("bkg_de_term_cd_list", "");
				}
				
				String fmMvmtStsCd = chargeByOfficeOrVVDVO.getFmMvmtStsCd();
				List<String> fmMvmtStsCdList = new ArrayList<String>();
				StringTokenizer st10 = new StringTokenizer(fmMvmtStsCd, ",");
				if(!("").equals(fmMvmtStsCd)){
				    while (st10.hasMoreTokens()) {
				    	fmMvmtStsCdList.add(st10.nextToken());
				    }
					velParam.put("fm_mvmt_sts_cd_list", fmMvmtStsCdList);
				}else {
					velParam.put("fm_mvmt_sts_cd_list", "");
				}
				
				String toMvmtStsCd = chargeByOfficeOrVVDVO.getToMvmtStsCd();
				List<String> toMvmtStsCdList = new ArrayList<String>();
				StringTokenizer st11 = new StringTokenizer(toMvmtStsCd, ",");
				if(!("").equals(toMvmtStsCd)){
				    while (st11.hasMoreTokens()) {
				    	toMvmtStsCdList.add(st11.nextToken());
				    }
					velParam.put("to_mvmt_sts_cd_list", toMvmtStsCdList);
				}else {
					velParam.put("to_mvmt_sts_cd_list", "");
				}
				
				String chgStsCd = chargeByOfficeOrVVDVO.getDmdtChgStsCd();
				
				if(( !chargeByOfficeOrVVDVO.getCondType().equals("date") ) || (chargeByOfficeOrVVDVO.getOptDate().equals("APP_DT")) || (chargeByOfficeOrVVDVO.getOptDate().equals("REV_MON")) ) {
					List<String> chgStsCdList = new ArrayList<String>();
					StringTokenizer st2 = new StringTokenizer(chgStsCd, ",");
					
				    while (st2.hasMoreTokens()) {
				    	String stsCd = st2.nextToken();
				    	chgStsCdList.add(stsCd);
				    }
					velParam.put("chg_sts_cd_list", chgStsCdList);
					
				} else {
					String allLongStayingFlg = "";
					List<String> chgStsCdList1 = new ArrayList<String>();
					List<String> chgStsCdList2 = new ArrayList<String>();
					List<String> chgStsCdList3 = new ArrayList<String>();
					StringTokenizer st2 = new StringTokenizer(chgStsCd, ",");
					
				    while (st2.hasMoreTokens()) {
				    	String stsCd = st2.nextToken();
				    	
				    	if(stsCd.equals("F") || stsCd.equals("N") || stsCd.equals("C") || stsCd.equals("I")) {
				    		chgStsCdList1.add(stsCd);
				    	} else if(stsCd.equals("T")) {
				    		allLongStayingFlg = "Y";
				    	} else if(stsCd.equals("E")) {
				    		chgStsCdList3.add(stsCd);
				    	} else { // 'L','D','U'
				    		chgStsCdList2.add(stsCd);
				    	}
				    }
				    
					velParam.put("chg_sts_cd_list1", chgStsCdList1);
					velParam.put("chg_sts_cd_list2", chgStsCdList2);
					velParam.put("chg_sts_cd_list3", chgStsCdList3);
					velParam.put("all_long_stay_flg", allLongStayingFlg);
				}
				
				if(chargeByOfficeOrVVDVO.getCondType().equals("cntr")) {
					if(!chargeByOfficeOrVVDVO.getBkgNo().equals("")) {
						String bkgNo = chargeByOfficeOrVVDVO.getBkgNo();
						List<String> bkgNoList = new ArrayList<String>();
						StringTokenizer st3 = new StringTokenizer(bkgNo, ",");
					    while (st3.hasMoreTokens()) {
					    	bkgNoList.add(st3.nextToken());
					    }
						velParam.put("bkg_no_list", bkgNoList);
					}
					
					if(!chargeByOfficeOrVVDVO.getBlNo().equals("")) {
						String blNo = chargeByOfficeOrVVDVO.getBlNo();
						List<String> blNoList = new ArrayList<String>();
						StringTokenizer st4 = new StringTokenizer(blNo, ",");
					    while (st4.hasMoreTokens()) {
					    	blNoList.add(st4.nextToken());
					    }
						velParam.put("bl_no_list", blNoList);
					}
					
					if(!chargeByOfficeOrVVDVO.getCntrNo().equals("")) {
						String cntrNo = chargeByOfficeOrVVDVO.getCntrNo();
						List<String> cntrNoList = new ArrayList<String>();
						StringTokenizer st5 = new StringTokenizer(cntrNo, ",");
					    while (st5.hasMoreTokens()) {
					    	cntrNoList.add(st5.nextToken());
					    }
						velParam.put("cntr_no_list", cntrNoList);
					}
				}
				
				if(!chargeByOfficeOrVVDVO.getOptItemList().equals("")) {
					String optItemList = chargeByOfficeOrVVDVO.getOptItemList();
					String [] arrList = optItemList.split(",");
					
					for(int i = 0; i < arrList.length; i ++){
						if ( arrList[i].equals("OP_BKG_INFO") ) {
							velParam.put("op_bkg_info", "OK");
						} else if ( arrList[i].equals("BKG_INFO") ) {
							velParam.put("bkg_info", "OK");
						} else if ( arrList[i].equals("CUST_INFO") ) {
							velParam.put("cust_info", "OK");
						} else if ( arrList[i].equals("CORR_INFO") ) {
							velParam.put("corr_info", "OK");
						}
					}
				}
				

				if(!chargeByOfficeOrVVDVO.getInactStsCd().equals("")) {
					String inanctStsCd = chargeByOfficeOrVVDVO.getInactStsCd();
					List<String> inactStsCdLsit = new ArrayList<String>();
					StringTokenizer st12 = new StringTokenizer(inanctStsCd, ",");
				    while (st12.hasMoreTokens()) {
				    	inactStsCdLsit.add(st12.nextToken());
				    }
					velParam.put("inact_sts_cd_list", inactStsCdLsit);
				}
				
				// 2016.07.13 Added AFT_DAR_STATUS 조건 추가
				if(!chargeByOfficeOrVVDVO.getAftDarStsCd().equals("")) {
					String aftDarStsCd = chargeByOfficeOrVVDVO.getAftDarStsCd();
					List<String> aftDarStsCdLsit = new ArrayList<String>();
					StringTokenizer tokenizer = new StringTokenizer(aftDarStsCd, ",");
				    while (tokenizer.hasMoreTokens()) {
				    	aftDarStsCdLsit.add(tokenizer.nextToken());
				    }
				    
				    if(aftDarStsCdLsit.contains("All")){
				    	// AFT DAR All 상태면 상태값이 있는 모든 FLG 조회
				    	velParam.put("aft_dar_sts_all_flg", "Y");
				    } else {
				    	if(aftDarStsCdLsit.contains("RC")){
				    		// Reject, Counter Offer 인 경우 해당 상태값을 넣어줌
				    		aftDarStsCdLsit.add("J");
				    		aftDarStsCdLsit.add("O");
				    		aftDarStsCdLsit.remove("RC");
				    	}
				    	if(aftDarStsCdLsit.contains("P")){
				    		velParam.put("aft_dar_sts_process_flg", "Y");
				    	}
				    }
				    velParam.put("aft_dar_sts_cd_list", aftDarStsCdLsit);
				}
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeListByStatusRSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	 
	 
	/**
	 * Office Transfer 에 따른 Charge Calculation 정보를 수정한다.
	 * 
	 * @param OfficeTransferParmVO officeTransferParmVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @throws DAOException
	 */
	public int modifyChargeByOfficeTransfer(OfficeTransferParmVO officeTransferParmVO, SignOnUserAccount account) 
		throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = officeTransferParmVO.getColumnValues();
			param.putAll(mapVO);
			param.put("upd_usr_id", account.getUsr_id());
			param.put("upd_ofc_cd", account.getOfc_cd());
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOChargeByOfficeTransferUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to ChargeByOfficeTransfer update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * Office Transfer 처리된 Charge의 Booking Container 정보 중에서 SYS_AREA_GRP_ID 정보를 수정한다.
	 * 
	 * @param OfficeTransferParmVO officeTransferParmVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyBookingContainerByOfficeTransfer(OfficeTransferParmVO officeTransferParmVO) 
		throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = officeTransferParmVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOBookingContainerByOfficeTransferUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to ChargeByOfficeTransfer update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * Office Transfer 처리된 Charge의 Booking Container 정보를 생성한다.
	 * 
	 * @param OfficeTransferParmByChargeVO officeTransferParmByChargeVO
	 * @throws DAOException
	 */
	public void addBookingContainerByOfficeTransfer(OfficeTransferParmByChargeVO officeTransferParmByChargeVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = officeTransferParmByChargeVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOBookingContainerByOfficeTransferCSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to BookingContainerByOfficeTransfer insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			if(se.getErrorCode() != 1)
				throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Office Transfer 처리된 Charge의 Calculation 정보를 생성한다.
	 * 
	 * @param OfficeTransferParmByChargeVO officeTransferParmByChargeVO
	 * @return int
	 * @throws DAOException
	 */
	public int addChargeByOfficeTransfer(OfficeTransferParmByChargeVO officeTransferParmByChargeVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		
		try {
			Map<String, String> mapVO = officeTransferParmByChargeVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOChargeByOfficeTransferCSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to ChargeByOfficeTransfer insert SQL");
			
			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			if(se.getErrorCode() == 1)
				return -1;
			else
				throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Office Transfer 처리와 관련해서 해당 Charge의 Calculation 정보를 삭제한다.
	 * 
	 * @param OfficeTransferParmVO officeTransferParmVO
	 * @throws DAOException
	 */
	public void deleteChargeByOfficeTransfer(OfficeTransferParmVO officeTransferParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = officeTransferParmVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOChargeByOfficeTransferDSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to ChargeByOfficeTransfer insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Charge Calculation 정보에서 Charge Status를 'T'(Transferred)로 수정한다.
	 * 
	 * @param OfficeTransferParmByChargeVO officeTransferParmByChargeVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyChargeTransferStatusByOfficeTransfer(OfficeTransferParmByChargeVO officeTransferParmByChargeVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = officeTransferParmByChargeVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOChargeTransferStatusByOfficeTransferUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to ChargeTransferStatusByOfficeTransfer update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * Charge Calculation 정보를 백업한다.
	 * 
	 * @param OfficeTransferParmByChargeVO officeTransferParmByChargeVO
	 * @throws DAOException
	 */
	public void addChargeBackupByOfficeTransfer(OfficeTransferParmByChargeVO officeTransferParmByChargeVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = officeTransferParmByChargeVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOChargeBackupByOfficeTransferCSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to ChargeBackupByOfficeTransfer insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Office Transfer 처리와 관련해 Charge Booking Container 정보를 백업한다. 
	 * 
	 * @param OfficeTransferParmByChargeVO officeTransferParmByChargeVO
	 * @throws DAOException
	 */
	public void addBookingContainerBackupByOfficeTransfer(OfficeTransferParmByChargeVO officeTransferParmByChargeVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = officeTransferParmByChargeVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOBookingContainerBackupByOfficeTransferCSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to BookingContainerBackupByOfficeTransfer insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Charge별 계산한 History 정보를 조회한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return List<DmtChgCorrHisVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DmtChgCorrHisVO> searchCorrectionHistory(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		List<DmtChgCorrHisVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAODmtChgCorrHisVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtChgCorrHisVO.class);
			return list;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * CNTR Movement 정보에 대해서 해당 CNTR의 In/Out Bound 정보를 조회한다.
	 * 
	 * @param String cntrNo
	 * @param String cntrCycNo
	 * @param String fmMvmtYdCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchInOutBoundByMovement(String cntrNo, String cntrCycNo, String fmMvmtYdCd) throws DAOException {
	
		//List<ChargeCalculationContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			//Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.put("cntr_no", cntrNo);
			param.put("cntr_cyc_no", cntrCycNo);
			param.put("fm_mvmt_yd_cd", fmMvmtYdCd);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchInOutBoundByMovementRSQL(), param, null);
			
			String result = "";
			if(dbRowset.next())
				result = dbRowset.getString(1);
			
			return result;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Partial할 대상 Charge 정보를 조회한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return List<ChargeCalculationContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChargeCalculationContainerVO> searchPartialPayment(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		List<ChargeCalculationContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				//velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchPartialPaymentRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeCalculationContainerVO.class);
			return list;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Partial Payment처리시 해당 Charge의 General 및 Balance 정보를 모두 삭제한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @throws DAOException
	 */
	public void deleteChargeByPartial(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODeleteChargeByPartialDSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to ChargeByOfficeTransfer insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Charge Delete Reason 정보를 조회한다.<br>
	 * 2010-07-19: 주석에 3번째 인자 추가
	 * 
	 * @param String fmMvmtDt
	 * @param String toMvmtDt
	 * @param String ofcCd
	 * @return int
	 * @throws DAOException
	 */
	public int checkFromToDate(String fmMvmtDt, String toMvmtDt, String ofcCd) throws DAOException {
	
		//List<DeleteReasonListVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("fm_mvmt_dt", fmMvmtDt);
			param.put("to_mvmt_dt", toMvmtDt);
			param.put("ofc_cd",		ofcCd);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckFromToDateRSQL(), param, null);
			
			int result = 0;
			if(dbRowset.next()) {
				result = dbRowset.getInt(1);
			}
			
			return result;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Partial할 대상 Charge의 SysAreaGrpID와 다른 Charge의 Charge Seq 정보를 조회한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return List<String>
	 * @throws DAOException
	 */
	public List<String> searchOthSvrChgSeqByPartial(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		List<String> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				//velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchOthSvrChgSeqByPartialRSQL(), param, null);
			
			list = new ArrayList<String>();
			while(dbRowset.next()) {
				list.add(dbRowset.getString(1));
			}
			
			return list;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Charge Table에 새 Charge 정보를 추가한다.
	 * 
	 * @param DmtChgCalcVO dmtChgCalcVO
	 * @throws DAOException
	 */
	public void addCharge(DmtChgCalcVO dmtChgCalcVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dmtChgCalcVO.getColumnValues();
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODmtChgCalcCSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
//			if(se.getErrorCode() == 1) {
//				String errMsg = new ErrorHandler("0107").getUserMessage();
//				errMsg.replace("value1", dmtChgCalcVO.getCntrNo());
//				errMsg.replace("value2", dmtChgCalcVO.getBkgNo());
//				throw new DAOException(errMsg);
//			} else
				throw new DAOException(new ErrorHandler(se).getMessage());
			
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * SZPSC Office의 "DMOF', "DMIF" Charge 정보를 Charge 테이블에 생성한다.<br>
	 * 
	 * @param DmtChgCalcVO dmtChgCalcVO
	 * @return int
	 * @throws DAOException
	 */
	public int addChargeBySZPBB(DmtChgCalcVO dmtChgCalcVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		
		try {
			Map<String, String> mapVO = dmtChgCalcVO.getColumnValues();
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOAddChargeBySZPBBCSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			if(se.getErrorCode() == 1)
				throw new DAOException("1");
			else
				throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}
	
	
	/**
	 * SZPBB Charge 생성시 SUTH_CHN_DEM_KEY_NO 필드 정보를 수정한다.
	 * 
	 * @param DmtChgCalcVO dmtChgCalcVO
	 * @throws DAOException
	 */
	public void modifyChargeChnDemKeyNoBySZPBB(DmtChgCalcVO dmtChgCalcVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = dmtChgCalcVO.getColumnValues();
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyChargeChnDemKeyNoBySZPBBUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * SZPSC Office 의 "DMOF', "DMIF" Charge 정보를 Charge 테이블에서 수정한다.
	 * 
	 * @param DmtChgCalcVO dmtChgCalcVO
	 * @throws DAOException
	 */
	public void modifyChargeBySZPBB(DmtChgCalcVO dmtChgCalcVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = dmtChgCalcVO.getColumnValues();
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyChargeBySZPBBUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Booking Table의 Trunk VVD를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchVVDCode(String bkgNo) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchVVDCodeRSQL(), param, null);
			
			String vvdCode = "";
			if(dbRowset.next())
				vvdCode = dbRowset.getString(1);
			
			return vvdCode;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Status가 F, C, I 이고, Balance Charge가 없거나 있일 경우 마지막 Balance Charge 이면서 
	 * To MVMT Status가 'DR' 인 Charge의 일부 정보를 조회한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return BalanceCreationChargeVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BalanceCreationChargeVO searchBalanceCreationCharge(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		List<BalanceCreationChargeVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOBalanceCreationChargeVORSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BalanceCreationChargeVO.class);
			
			BalanceCreationChargeVO balanceCreationChargeVO = null;
			if(list != null && list.size() > 0) {
				balanceCreationChargeVO = list.get(0);
			}
			
			return balanceCreationChargeVO;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Charge Delete Reason을 조회한다.<br>
	 * 
	 * @return List<DeleteReasonListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DeleteReasonListVO> searchDeleteReasonList() throws DAOException {
	
		List<DeleteReasonListVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		//Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAODeleteReasonListVORSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DeleteReasonListVO.class);
			return list;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 해당 Charge의 Status 와 Remark 정보를 조회한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return ChargeStatusNRemarkVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChargeStatusNRemarkVO searchChargeStatusNRemark(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		List<ChargeStatusNRemarkVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				//velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOChargeStatusNRemarkVORSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeStatusNRemarkVO.class);
			
			ChargeStatusNRemarkVO chargeStatusNRemarkVO = null;
			if(list != null && list.size() > 0) {
				chargeStatusNRemarkVO = (ChargeStatusNRemarkVO)list.get(0);
			}
			
			return chargeStatusNRemarkVO;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 'Deleted' 상태인 Charge의 정보를 수정한다.
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @throws DAOException
	 */
	public void modifyDeleteCharge(ChargeCalculationContainerVO chargeCalculationContainerVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = chargeCalculationContainerVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyDeleteChargeUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifyDeleteCharge SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Balance Charge중 Invoice Issued된 Charge가 존재하는지 체크한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkChargeInvoiceByDRCancel(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			boolean result = false;
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckChargeInvoiceByDRCancelRSQL(), param, null);
			if(dbRowset.next())
				result = true;
				
			return result;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Delete할 대상 Balance Charge의 Sequence List를 조회한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return List<String>
	 * @throws DAOException
	 */
	public List<String> searchChargeByDRCancel(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOChargeByDRCancelRSQL(), param, null);
			
			List<String> list = new ArrayList<String>();
			while(dbRowset.next())
				list.add(dbRowset.getString(1));
			
			return list;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * DRCancel에 따른 Balance Charge 삭제 전에 Charge Backup 정보를 생성한다.<br>
	 * 
	 * @param DmtChgCalcVO dmtChgCalcVO
	 * @throws DAOException
	 */
	public void addChargeBackup(DmtChgCalcVO dmtChgCalcVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dmtChgCalcVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOChargeBackupByDRCancelCSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/*
	 * General Charge의 To MVMT DT 정보를 Max Charge Seq의 Balance Charge To MVMT DT로 수정한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @throws DAOException
	 */
	/*
	public void modifyChargeByDRCancel(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyChargeByDRCancelUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modifyChargeByDRCancel SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	*/
	
	/**
	 * 모든 Balance Charge 정보를 삭제한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @throws DAOException
	 */
	public void deleteChargeByDRCancel(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOChargeByDRCancelDSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to ChargeByOfficeTransfer insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * POD ETA 날짜 정보를 조회한다.<br>
	 * 
	 * @param ManualChargeCreationVO manualChargeCreationVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPODEta(ManualChargeCreationVO manualChargeCreationVO) throws DAOException {
	
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(manualChargeCreationVO != null) {
				Map<String, String> mapVO = manualChargeCreationVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchPODEtaRSQL(), param, null);
			
			String result = "";
			if(dbRowset.next())
				result = dbRowset.getString(1);
			
			return result;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Container별 VD Movement Date 정보를 조회한다.<br>
	 * 
	 * @param VDMovementVO vdMovementVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchVDMovementByPodEta(VDMovementVO vdMovementVO) throws DAOException {
	
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vdMovementVO != null) {
				Map<String, String> mapVO = vdMovementVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchVDMovementByPodEtaRSQL(), param, null);
			
			String result = "";
			if(dbRowset.next())
				result = dbRowset.getString(1);
			
			return result;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Booking Container Table에 Data를 생성한다.<br>
	 * 
	 * @param DmtChgBkgCntrVO dmtChgBkgCntrVO
	 * @throws DAOException
	 */
	public void addBkgCntr(DmtChgBkgCntrVO dmtChgBkgCntrVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dmtChgBkgCntrVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODmtChgBkgCntrCSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Charge의 Amount 정보들을 조회한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return ChargeDetailVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChargeDetailVO chargeDetail(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.put("est_mk", chargeArgumentVO.getEstMk());
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOChargeDetailVORSQL(), param, velParam);
			
			ChargeDetailVO chgDtlVO = null;
			List<ChargeDetailVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeDetailVO.class);
			
			if(list != null && list.size() > 0) {
				chgDtlVO = (ChargeDetailVO)list.get(0);
			} 
			
			return chgDtlVO;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Basic Tariff의 주말, 공휴일 포함 여부를 조회한다.<br>
	 * 
	 * @param BasicTariffParmVO basicTariffParmVO
	 * @return ChargeBasicFreeTimeVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChargeBasicFreeTimeVO chargeBasicTariff(BasicTariffParmVO basicTariffParmVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(basicTariffParmVO != null) {
				Map<String, String> mapVO = basicTariffParmVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOChargeBasicFreeTimeVORSQL(), param, null);
			
			ChargeBasicFreeTimeVO chargeBasicFreeTimeVO = null;
			List<ChargeBasicFreeTimeVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeBasicFreeTimeVO.class);
			
			if(list != null && list.size() > 0) {
				chargeBasicFreeTimeVO = list.get(0);
			}
			
			return chargeBasicFreeTimeVO;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Basic Tariff Currency Code, Coverage Code 정보를 조회한다.<br>
	 * 
	 * @param BasicTariffParmVO basicTariffParmVO
	 * @return BasicCurrencyCoverageVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BasicCurrencyCoverageVO searchBasicCurrencyCoverage(BasicTariffParmVO basicTariffParmVO) throws DAOException {
	
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(basicTariffParmVO != null) {
				Map<String, String> mapVO = basicTariffParmVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOBasicCurrencyCoverageVORSQL(), param, null);
			
			BasicCurrencyCoverageVO basicCurrencyCoverageVO = null;
			List<BasicCurrencyCoverageVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, BasicCurrencyCoverageVO.class);
			
			if(list != null && list.size() > 0) {
				basicCurrencyCoverageVO = list.get(0);
			}
			
			return basicCurrencyCoverageVO;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Commodity Exception Tariff의 Free Time일수 및 주말, 공휴일 포함 여부를 조회한다.<br>
	 * 
	 * @param CommodityTariffParmVO commodityTariffParmVO
	 * @return CommodityGroupTariffVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommodityGroupTariffVO chargeCommodityTariff(CommodityTariffParmVO commodityTariffParmVO) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(commodityTariffParmVO != null) {
				Map<String, String> mapVO = commodityTariffParmVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCommodityGroupTariffVORSQL(), param, null);
			
			CommodityGroupTariffVO cmdtGrpTrfVO = null;
			List<CommodityGroupTariffVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommodityGroupTariffVO.class);
			
			if(list != null && list.size() > 0) {
				cmdtGrpTrfVO = list.get(0);
			}
			
			return cmdtGrpTrfVO;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Before Exception Tariff의 Free Time일수 및 주말, 공휴일 포함 여부를 조회한다.<br>
	 * 
	 * @param ChargeDetailVO chargeDetailVO
	 * @return BeforeExceptionTariffVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BeforeExceptionTariffVO chargeBeforeException(ChargeDetailVO chargeDetailVO) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeDetailVO != null) {
				Map<String, String> mapVO = chargeDetailVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOBeforeExceptionTariffVORSQL(), param, null);
			
			BeforeExceptionTariffVO beforeExceptionTariffVO = null;
			List<BeforeExceptionTariffVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, BeforeExceptionTariffVO.class);
			
			if(list != null && list.size() > 0) {
				beforeExceptionTariffVO = list.get(0);
			} 
			
			return beforeExceptionTariffVO;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * S/C Exception Tariff의 Free Time일수 및 주말, 공휴일 포함 여부를 조회한다.<br>
	 * 
	 * @param ChargeDetailVO chargeDetailVO
	 * @return SCExceptionTariffVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SCExceptionTariffVO chargeSCException(ChargeDetailVO chargeDetailVO) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeDetailVO != null) {
				Map<String, String> mapVO = chargeDetailVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSCExceptionTariffVORSQL(), param, null);
			
			SCExceptionTariffVO scExceptionTariffVO = null;
			List<SCExceptionTariffVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionTariffVO.class);
			
			if(list != null && list.size() > 0) {
				scExceptionTariffVO = list.get(0);
			} 
			
			return scExceptionTariffVO;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * After Discount의 Free Time일수 및 주말, 공휴일 포함 여부, Currency, Discount Ratio 또는 Discount Amount를 조회한다.<br>
	 * 
	 * @param AfterExceptionTariffParmVO afterExceptionTariffParmVO
	 * @return AfterExceptionTariffVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public AfterExceptionTariffVO chargeAfterException(AfterExceptionTariffParmVO afterExceptionTariffParmVO) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(afterExceptionTariffParmVO != null) {
				Map<String, String> mapVO = afterExceptionTariffParmVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOAfterExceptionTariffVORSQL(), param, null);
			
			AfterExceptionTariffVO afterExceptionTariffVO = null;
			List<AfterExceptionTariffVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, AfterExceptionTariffVO.class);
			
			if(list != null && list.size() > 0) {
				afterExceptionTariffVO = list.get(0);
			} 
			
			return afterExceptionTariffVO;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Charge에 적용된 Clock Stop 관련 정보를 조회한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return List<ClockStopVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ClockStopVO> chargeClockStop(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOClockStopVORSQL(), param, null);
			
			List<ClockStopVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ClockStopVO.class);
			return list;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * charge status 정보를 수정한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @param String usrId
	 * @param String ofcCd
	 * @throws DAOException
	 */
	public void modifyChargeStatusByInvoice(ChargeArgumentVO chargeArgumentVO, String usrId, String ofcCd) throws DAOException {
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				param.put("upd_usr_id", usrId);
				param.put("upd_ofc_cd", ofcCd);
				
				velParam.putAll(mapVO);
				velParam.put("upd_usr_id", usrId);
				velParam.put("upd_ofc_cd", ofcCd);
			}
			
			int result = new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyChargeStatusByInvoiceUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modifyChargeStatusByInvoice modify SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * charge OFC_CD, OFC_RHQ_CD 정보를 수정한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @param String usrId
	 * @param String ofcCd
	 * @throws DAOException
	 */
	public void modifyChargeOffice(ChargeArgumentVO chargeArgumentVO, String usrId, String ofcCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				param.put("upd_usr_id", usrId);
				param.put("upd_ofc_cd", ofcCd);
			}
			
			int result = new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)
					new ChargeCalculationDBDAOModifyChargeStatusByInvoiceUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modifyChargeStatusByInvoice modify SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * charge cancel status 정보를 수정한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @param String usrId
	 * @param String ofcCd
	 * @throws DAOException
	 */
	public void modifyChargeStatusByInvoiceCancel(ChargeArgumentVO chargeArgumentVO, String usrId, String ofcCd) throws DAOException {
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				param.put("upd_usr_id", usrId);
				param.put("upd_ofc_cd", ofcCd);
			}
			
			int result = new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyChargeStatusByInvoiceCancelUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modifyChargeStatusByInvoice modify SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Issued된 charge에 Invoice NO 정보를 수정한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @param String usrId
	 * @param String ofcCd
	 * @throws DAOException
	 */
	public void modifyInvoiceNoByInvoice(ChargeArgumentVO chargeArgumentVO, String usrId, String ofcCd) throws DAOException {
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				param.put("upd_usr_id", usrId);
				param.put("upd_ofc_cd", ofcCd);
			}
			
			int result = new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyInvoiceNoByInvoiceUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modifyInvoiceNoByInvoice modify SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}			
	
	/**
	 * charge status 정보를 수정한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @param String usrId
	 * @param String ofcCd
	 * @throws DAOException
	 */
	public void modifyChargeTruckerByInvoice(ChargeArgumentVO chargeArgumentVO, String usrId, String ofcCd) throws DAOException {
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				param.put("upd_usr_id", usrId);
				param.put("upd_ofc_cd", ofcCd);
			}
			
			int result = new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyChargeTruckerByInvoiceUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modifyChargeStatusByInvoice modify SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
    /**
     * VVD 정보를 저장 합니다.<br>
     * 
     * @param VVDNEtaVO vVDNEtaVO
     * @throws DAOException
     */
    public void modifyBookingContainerVVD(VVDNEtaVO vVDNEtaVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        //Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = vVDNEtaVO.getColumnValues();
            param.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyBookingContainerVVDUSQL(), param, null);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to modifyBookingContainerVVD SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
     }
	
	/**
	 * EDI 로 정보를 전송후 그 결과를 이력으로 생성 합니다. <br>
	 * 
	 * @param EDIVO eDIVO
	 * @throws DAOException
	 */
	public void addEDIHistory(EDIVO eDIVO) throws DAOException {	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (eDIVO != null) {
				Map<String, String> mapVO = eDIVO .getColumnValues();
				param.putAll(mapVO);
			}
			new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)
					new ChargeCalculationDBDAOAddEDIHistoryCSQL(), param, null);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Dual Exception Charge중 Combined Charge에 대한 Dual Charge를 조회한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return ChargeCalculationContainerVO
	 */
	@SuppressWarnings("unchecked")
	public List<ChargeCalculationContainerVO> searchDualChargeTariff(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		List<ChargeCalculationContainerVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchDualChargeTariffRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeCalculationContainerVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * Dual Exception Charge의 ORG_CHG_AMT, SC_RFA_EXPT_AMT 정보를 수정한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @throws DAOException
	 */
	public void modifyOrgChgAmt(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyOrgChgAmtUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Update MT Notification Error");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 해당 Office의 SYS_AREA_GRP_ID 정보를 조회한다.
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchRhqGrpId(String ofcCd) throws DAOException {
	
		//List<ChargeCalculationContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			//Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.put("ofc_cd", ofcCd);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchRhqGrpIdRSQL(), param, null);
			
			String result = "";
			if(dbRowset.next())
				result = dbRowset.getString(1);
			
			return result;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 해당 Charge Booking Cntr 정보에 대해서 Charge가 존재하는지 체크한다.
	 * 
	 * @param OfficeTransferParmVO officeTransferParmVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkChargeByOfficeTransfer(OfficeTransferParmVO officeTransferParmVO) throws DAOException {
	
		//List<ChargeCalculationContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = officeTransferParmVO.getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckChargeByOfficeTransferRSQL(), param, null);
			
			String result = "N";
			if(dbRowset.next())
				result = dbRowset.getString(1);
			
			return result;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 해당 Charge Booking Cntr 정보를 삭제한다.<br>
	 * 
	 * @param OfficeTransferParmVO officeTransferParmVO
	 * @throws DAOException
	 */
	public void deleteBookingContainerByOfficeTransfer(OfficeTransferParmVO officeTransferParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = officeTransferParmVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODeleteBookingContainerByOfficeTransferDSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete BookingContainer By OfficeTransfer");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * OFC_CD별 현재일자를 조회한다.
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCurrentDateByOffice(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String curr_day = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("ofc_cd", ofcCd);
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchCurrentDateByOfficeRSQL(), param, null);
			if(dbRowset.next()){
				curr_day = dbRowset.getString("curr_day");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return curr_day;
	}
	
	
	/**
	 * 해당 Charge Booking CNTR 정보 존재여부를 체크한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkChargeBookingContainerExists(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		//List<ChargeCalculationContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckChargeBookingContainerExistsRSQL(), param, null);
			boolean isExist = false;
			
			if(dbRowset.next()) {
				int cnt = dbRowset.getInt(1);
				if(cnt > 0)
					isExist = true;
			}
			return isExist;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 해당 Charge(Confirm, Delete, DeleteCancel) 정보 존재여부를 체크한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkChargeByConfirmDeleteDeleteCancel(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckChargeByConfirmDeleteDeleteCancelRSQL(), param, velParam);
			boolean isExist = false;
			
			if(dbRowset.next()) {
				int cnt = dbRowset.getInt(1);
				if(cnt > 0)
					isExist = true;
			}
			return isExist;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * 동일한 office 에 대해서 Charge가 존재하는지 체크한다.
	 * 
	 * @param OfficeTransferParmVO officeTransferParmVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkMultiChargeByOfficeTransfer(OfficeTransferParmVO officeTransferParmVO) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = officeTransferParmVO.getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckMultiChargeByOfficeTransferRSQL(), param, null);
			
			boolean isExist = false;
			
			if(dbRowset.next()) {
				int cnt = dbRowset.getInt(1);
				if(cnt > 0)
					isExist = true;
			}
			return isExist;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 해당 Deletion Request내용이 Request 상태인 데이터가 있는지 체크한다.Reject, Apporval된 데이터제외
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return boolean
	 * @throws DAOException
	 */
	public String checkRequestChargeDeletion(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String result = "";
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckRequestChargeDeletionRSQL(), param, velParam);
				
				if(dbRowset.next()) { 
					if( chargeArgumentVO.getBydr() != null ){ 
						if( ("OP").equals(chargeArgumentVO.getBydr())){
							result = dbRowset.getString(1);
						} else if( ("INV").equals(chargeArgumentVO.getBydr())){
							result = dbRowset.getString(1);
						} else {
							int cnt = dbRowset.getInt(1);
							if(cnt > 0){
								result = dbRowset.getString(2) + "|" + dbRowset.getString(3);
							}
						}
					}
				}
			}
			return result;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ChargeDeletion Request 정보를 생성한다.
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @throws DAOException
	 */
	public void requestChargeDeletion(ChargeCalculationContainerVO chargeCalculationContainerVO) throws DAOException {
		                              
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeCalculationContainerVO.getColumnValues();
			
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAORequestChargeDeletionCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Request된 ChargeDeletion Rejectc처리한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @throws DAOException
	 */
	public void modifyChargeDeletion(ChargeArgumentVO chargeArgumentVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyChargeDeletionUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Update ChargeDeletion Error");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}	
	
	/** DMT OFFICE 정보를 조회한다.<br>
	 * 
	 * @param String OfcCd
	 * @param String rhq 
	 * @return List<OfficeNameVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OfficeNameVO> searchDMTOfficeByApprovalOffice(String ofcCd, String rhq) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeNameVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if(ofcCd.equals("HAMRUO") || ofcCd.equals("NYCRAO")|| ofcCd.equals("SINRSO")|| ofcCd.equals("SHARCO") ) {
				param.put("ofc_cd", rhq);	
			}
			else{
			    param.put("ofc_cd", ofcCd);
			}
			velParam.put("rhq", rhq);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ChargeCalculationDBDAOsearchDMTOfficeByApprovalOfficeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OfficeNameVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Charge Delete 대상 Data를 조회한다. <br>
	 * 
	 * @param ChargeDeletionRequstVO chargeDeletionRequstVO
	 * @return List<ChargeCalculationContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChargeCalculationContainerVO> searchChargeDeletionRequest(ChargeDeletionRequstVO chargeDeletionRequstVO) throws DAOException {
	
		List<ChargeCalculationContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeDeletionRequstVO != null) {
				Map<String, String> mapVO = chargeDeletionRequstVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
	
				 
				if(!chargeDeletionRequstVO.getBkgNo().equals("")) {
					String bkgNo = chargeDeletionRequstVO.getBkgNo();
					List<String> bkgNoList = new ArrayList<String>();
					StringTokenizer st3 = new StringTokenizer(bkgNo, ",");
				    while (st3.hasMoreTokens()) {
				    	bkgNoList.add(st3.nextToken());
				    }
					velParam.put("bkg_no_list", bkgNoList);
				}
				
				
				String ofcCd = chargeDeletionRequstVO.getDmtOfcCd();
				List<String> ofcCdList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(ofcCd, ",");
			    while (st.hasMoreTokens()) {
			    	ofcCdList.add(st.nextToken());
			    }
				velParam.put("ofc_cd_list", ofcCdList);
				
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionRequestRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeCalculationContainerVO.class);
			return list;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 *  KOR EDI 전송할 대상 여부를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String checkEDI(String bkgNo) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("bkg_no", bkgNo);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckEDIRSQL(), param, null);
			
			String result = "N";
			if(dbRowset.next()) {
				result = dbRowset.getString(1);
			}
			
			return result;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 *  BKG의 F/T Date 와 비교하여 변경 여부를 check한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String ftEndDt
	 * @param String cntrNo
	 * @return String
	 * @throws DAOException
	 */
	public String checkEDOChargeFreeTime(String bkgNo, String ftEndDt, String cntrNo) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
	
		try{
			param.put("bkg_no", bkgNo);
			param.put("ft_end_dt", ftEndDt);
			param.put("cntr_no", cntrNo);
			velParam.put("ft_end_dt", ftEndDt);
			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckEDOChargeFreeTimeRSQL(), param, velParam);
			
			String result = "N";
			if(dbRowset.next()) {
				result = dbRowset.getString(1);
			}
			
			return result;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * OP-MT Detention Inquiry 대상 Charge List를 조회한다.
	 * 
	 * @param OPMTChargeParmVO oPMTChargeParmVO
	 * @return List<ChargeCalculationContainerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChargeCalculationContainerVO> searchOPMTChargeListbyInquiry(OPMTChargeParmVO oPMTChargeParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChargeCalculationContainerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(oPMTChargeParmVO != null){
				Map<String, String> mapVO = oPMTChargeParmVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if(oPMTChargeParmVO.getCondType().equals("ofc")) {
				String ofcCd = oPMTChargeParmVO.getOfcCd();
				List<String> ofcCdList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(ofcCd, ",");
			    while (st.hasMoreTokens()) {
			    	ofcCdList.add(st.nextToken());
			    }
				velParam.put("ofc_cd_list", ofcCdList);
				}
					
//			log.debug("====DAO  oPMTChargeParmVO.getDmdtChgStsCd()======="+oPMTChargeParmVO.getDmdtChgStsCd());
//				if(!oPMTChargeParmVO.getCondType().equals("bkg")) {
//					String chgStsCd = oPMTChargeParmVO.getDmdtChgStsCd();
//					List<String> chgStsCdList = new ArrayList<String>();
//					StringTokenizer st2 = new StringTokenizer(chgStsCd, ",");
//					
//				    while (st2.hasMoreTokens()) {
//				    	String stsCd = st2.nextToken();
//				    	chgStsCdList.add(stsCd);
//				    }
//					velParam.put("chg_sts_cd_list", chgStsCdList);
//					
//				} 
//*****************************************************************************					
//  2012.12.11 [CHM-201221701-01]OP-MT Detention 계산 방법 보완 2차 - By AA 임창빈수석				
				if(!oPMTChargeParmVO.getCondType().equals("bkg")) {
					List<String> chgStsCdList1 = new ArrayList<String>();
					List<String> chgStsCdList2 = new ArrayList<String>();
					List<String> chgStsCdList3 = new ArrayList<String>();
					
					String chgStsCd = oPMTChargeParmVO.getDmdtChgStsCd();
					StringTokenizer st2 = new StringTokenizer(chgStsCd, ",");
					
				    while (st2.hasMoreTokens()) {
				    	String stsCd = st2.nextToken();
				    	
				    	if(stsCd.equals("F") || stsCd.equals("N") || stsCd.equals("C") || stsCd.equals("I")) {
				    		chgStsCdList1.add(stsCd);
//				    	} else if(stsCd.equals("R")) {
//				    		allLongStayingFlg = "Y";
				    	} else if(stsCd.equals("E")) {
				    		chgStsCdList3.add(stsCd);
				    	} else { // 'L','D','U'
				    		chgStsCdList2.add(stsCd);
				    	}
				    }
				    
					velParam.put("chg_sts_cd_list1", chgStsCdList1);
					velParam.put("chg_sts_cd_list2", chgStsCdList2);
					velParam.put("chg_sts_cd_list3", chgStsCdList3);
				} 
				
				if(oPMTChargeParmVO.getCondType().equals("cntr")) {
					String cntrNo = oPMTChargeParmVO.getCntrNo();
					List<String> cntrNoList = new ArrayList<String>();
					StringTokenizer st5 = new StringTokenizer(cntrNo, ",");
				    while (st5.hasMoreTokens()) {
				    	cntrNoList.add(st5.nextToken());
				    }
					velParam.put("cntr_no_list", cntrNoList);
				}
				
				
				if(oPMTChargeParmVO.getCondType().equals("bkg")) {
					if(!oPMTChargeParmVO.getBkgNo().equals("")) {
						String bkgNo = oPMTChargeParmVO.getBkgNo();
						List<String> bkgNoList = new ArrayList<String>();
						StringTokenizer st3 = new StringTokenizer(bkgNo, ",");
					    while (st3.hasMoreTokens()) {
					    	bkgNoList.add(st3.nextToken());
					    }
						velParam.put("bkg_no_list", bkgNoList);
					}
					
				}
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchOPMTChargeListbyInquiryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeCalculationContainerVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * OP-MT Detention Calculation 대상 Charge List를 조회한다.
	 * 
	 * @param OPMTChargeParmVO oPMTChargeParmVO
	 * @return List<ChargeCalculationContainerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChargeCalculationContainerVO> searchOPMTChargeListbyCalculation(OPMTChargeParmVO oPMTChargeParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChargeCalculationContainerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(oPMTChargeParmVO != null){
				Map<String, String> mapVO = oPMTChargeParmVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if(oPMTChargeParmVO.getCondType().equals("ofc")) {
				String ofcCd = oPMTChargeParmVO.getOfcCd();
				List<String> ofcCdList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(ofcCd, ",");
			    while (st.hasMoreTokens()) {
			    	ofcCdList.add(st.nextToken());
			    }
				velParam.put("ofc_cd_list", ofcCdList);
				}
						
//				log.debug("====ssssDAO  oPMTChargeParmVO.getDmdtChgStsCd()======="+oPMTChargeParmVO.getDmdtChgStsCd());
//					if(!oPMTChargeParmVO.getCondType().equals("bkg")) {
//						String chgStsCd = oPMTChargeParmVO.getDmdtChgStsCd();
//						List<String> chgStsCdList = new ArrayList<String>();
//						StringTokenizer st2 = new StringTokenizer(chgStsCd, ",");
//						
//					    while (st2.hasMoreTokens()) {
//					    	String stsCd = st2.nextToken();
//					    	chgStsCdList.add(stsCd);
//					    }
//						velParam.put("chg_sts_cd_list", chgStsCdList);
//						
//					} 
//*****************************************************************************					
//  2012.12.11 [CHM-201221701-01]OP-MT Detention 계산 방법 보완 2차 - By AA 임창빈수석						
				if(!oPMTChargeParmVO.getCondType().equals("bkg")) {
					List<String> chgStsCdList1 = new ArrayList<String>();
					List<String> chgStsCdList2 = new ArrayList<String>();
					List<String> chgStsCdList3 = new ArrayList<String>();
					
					String chgStsCd = oPMTChargeParmVO.getDmdtChgStsCd();
					StringTokenizer st2 = new StringTokenizer(chgStsCd, ",");
					
				    while (st2.hasMoreTokens()) {
				    	String stsCd = st2.nextToken();
				    	
				    	if(stsCd.equals("F") || stsCd.equals("N") || stsCd.equals("C") || stsCd.equals("I")) {
				    		chgStsCdList1.add(stsCd);
//					    	} else if(stsCd.equals("R")) {
//					    		allLongStayingFlg = "Y";
				    	} else if(stsCd.equals("E")) {
				    		chgStsCdList3.add(stsCd);
				    	} else { // 'L','D','U'
				    		chgStsCdList2.add(stsCd);
				    	}
				    }
				    
					velParam.put("chg_sts_cd_list1", chgStsCdList1);
					velParam.put("chg_sts_cd_list2", chgStsCdList2);
					velParam.put("chg_sts_cd_list3", chgStsCdList3);
					
				} 
				
				if(oPMTChargeParmVO.getCondType().equals("cntr")) {
					String cntrNo = oPMTChargeParmVO.getCntrNo();
					List<String> cntrNoList = new ArrayList<String>();
					StringTokenizer st5 = new StringTokenizer(cntrNo, ",");
				    while (st5.hasMoreTokens()) {
				    	cntrNoList.add(st5.nextToken());
				    }
					velParam.put("cntr_no_list", cntrNoList);
				}
				
				
				if(oPMTChargeParmVO.getCondType().equals("bkg")) {
					if(!oPMTChargeParmVO.getBkgNo().equals("")) {
						String bkgNo = oPMTChargeParmVO.getBkgNo();
						List<String> bkgNoList = new ArrayList<String>();
						StringTokenizer st3 = new StringTokenizer(bkgNo, ",");
					    while (st3.hasMoreTokens()) {
					    	bkgNoList.add(st3.nextToken());
					    }
						velParam.put("bkg_no_list", bkgNoList);
					}
					
				}
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchOPMTChargeListbyCalculationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeCalculationContainerVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		 
	/**
	 * Exception cost Amount 정보들을 조회한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return List<ExceptionCostVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExceptionCostVO> searchExceptionCost(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchExceptionCostRSQL(), param, velParam);
		
			List<ExceptionCostVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ExceptionCostVO.class);
			return list;				
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		 

	/**
	 * Exception Cost 테이블에 데이터가 존재하는지 확인한다.
	 * 
	 * @param ExceptionChargeCalculationVO exceptionChargeCalculationVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkDmtExceptionChargeCalculation(ExceptionChargeCalculationVO exceptionChargeCalculationVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			//query parameter
			Map<String, String> mapVO = exceptionChargeCalculationVO.getColumnValues();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckDmtExceptionChargeCalculationRSQL(), param, velParam);
			boolean isExist = false;
			
			if(dbRowset.next()) {
				int cnt = dbRowset.getInt(1);
				if(cnt > 0)
					isExist = true;
			}
			
			return isExist;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}

	/**
	 * Exception Cost를 재계산 로직 처리한다.
	 * 
	 * @param ExceptionChargeCalculationVO exceptionChargeCalculationVO
	 * @throws DAOException
	 */
	public void mergeDmtExceptionChargeCalculation(ExceptionChargeCalculationVO exceptionChargeCalculationVO) throws DAOException {

	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			//query parameter
			Map<String, String> mapVO = exceptionChargeCalculationVO.getColumnValues();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOmergeDmtExceptionChargeCalculationUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Update ChargeDeletion Error");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}
		
	/**
	 * Split된 Booking vs Container(Q'ty : 소숫점일 경우) 실제 Charge가 발생한 Booking No 정보을 조회한다.<br>
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchBookingSplitNo(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(chargeByOfficeOrVVDVO != null) {
				Map<String, String> mapVO = chargeByOfficeOrVVDVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchBookingSplitNoRSQL(), param, velParam);
			
			String result = "";
			if(dbRowset.next())
				result = dbRowset.getString(1);
			
			return result;			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		

	/**
	 * DMT Booking, Container & Charge 정보를 조회한다<br>
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public String searchBookingChargeOB(String bkgNo) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchBookingChargeOBRSQL(), param, velParam);
			
			String result = "";
			if(dbRowset.next())
				result = dbRowset.getString(1);
			
			return result;			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	//###############################################< CHM-201533804 [DMT] Deletion Setup 화면 개발 영역 [S] >###############################################
	/**
	 * Charge Deletion Path Setup 테이블에 등록된 승인경로정보 조회 <br> 
	 * 
	 * @param SearchChgDeltPathStupVO searchChgDeltPathStupVO
	 * @return List<ChgDeltPathStupVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")	
	public List<ChgDeltPathStupVO> searchChargeDeletionPathSetupList(SearchChgDeltPathStupVO searchChgDeltPathStupVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChgDeltPathStupVO> list = new ArrayList<ChgDeltPathStupVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (searchChgDeltPathStupVO != null) {
				Map<String, String> mapVO = searchChgDeltPathStupVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String[] chgDeltOfcCdArray = searchChgDeltPathStupVO.getChgDeltOfcCd().split(",");
				velParam.put("chg_delt_ofc_cd_list",  Arrays.asList(chgDeltOfcCdArray));
			
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionPathSetupListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChgDeltPathStupVO.class);
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
	}	
	
	/**
	 * Charge Deletion Path Setup 에 등록된 정보중 변경 및 삭제된 정보에 대한 이력정보를 생성한다. <br> 
	 * 
	 * @param List<ChgDeltPathStupVO> chgDeltPathStupVOList
	 * @throws DAOException
	 */
	public void addChargeDeletionPathSetupHistory(List<ChgDeltPathStupVO> chgDeltPathStupVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if (chgDeltPathStupVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChargeCalculationDBDAOAddChargeDeletionPathSetupHistoryCSQL(), chgDeltPathStupVOList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Charge Deletion Office Setup 에 등록된 정보중 변경 및 삭제된 정보에 대한 이력정보를 생성한다. <br>
	 * 
	 * @param List<ChgDeltPathStupVO> chgDeltPathStupVOList
	 * @throws DAOException
	 */
	public void addChargeDeletionOfficeSetupHistory(List<ChgDeltPathStupVO> chgDeltPathStupVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if (chgDeltPathStupVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChargeCalculationDBDAOAddChargeDeletionOfficeSetupHistoryCSQL(), chgDeltPathStupVOList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 *  Charge Deletion Path Setup 에 등록된 정보를 삭제한다. <br> 
	 * 
	 * @param List<ChgDeltPathStupVO> chgDeltPathStupVOList
	 * @throws DAOException
	 */
	public void removeChargeDeletionPathSetup(List<ChgDeltPathStupVO> chgDeltPathStupVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int delCnt[] = null;
			if (chgDeltPathStupVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ChargeCalculationDBDAORemoveChargeDeletionPathSetupDSQL(), chgDeltPathStupVOList, null);
				for (int i = 0; i < delCnt.length; i++){
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Charge Deletion Office Setup 에 등록된 정보를 삭제한다. <br> 
	 * 
	 * @param List<ChgDeltPathStupVO> chgDeltPathStupVOList
	 * @throws DAOException
	 */
	public void removeChargeDeletionOfficeSetup(List<ChgDeltPathStupVO> chgDeltPathStupVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int delCnt[] = null;
			if (chgDeltPathStupVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ChargeCalculationDBDAORemoveChargeDeletionOfficeSetupDSQL(), chgDeltPathStupVOList, null);
				for (int i = 0; i < delCnt.length; i++){
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Charge Deletion Path Setup 에 등록된 정보를 수정한다. <br> 
	 * 
	 * @param List<ChgDeltPathStupVO> chgDeltPathStupVOList
	 * @throws DAOException
	 */
	public void modifyChargeDeletionPathSetup(List<ChgDeltPathStupVO> chgDeltPathStupVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int updCnt[] = null;
			if (chgDeltPathStupVOList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChargeCalculationDBDAOModifyChargeDeletionPathSetupUSQL(), chgDeltPathStupVOList, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Charge Deletion Path Setup 정보를 등록한다. <br> 
	 * 
	 * @param List<ChgDeltPathStupVO> chgDeltPathStupVOList
	 * @throws DAOException
	 */
	public void addChargeDeletionPathSetup(List<ChgDeltPathStupVO> chgDeltPathStupVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if (chgDeltPathStupVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChargeCalculationDBDAOAddChargeDeletionPathSetupCSQL(), chgDeltPathStupVOList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Charge Deletion Office Setup 정보를 등록한다. <br> 
	 * 
	 * @param List<ChgDeltOfcStupVO> chgDeltOfcStupVOList
	 * @throws DAOException
	 */
	public void addChargeDeletionOfficeSetup(List<ChgDeltOfcStupVO> chgDeltOfcStupVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if (chgDeltOfcStupVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChargeCalculationDBDAOAddChargeDeletionOfficeSetupCSQL(), chgDeltOfcStupVOList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * Charge Deletion Path Setup 에 기등록된 정보인지 조회한다. <br> 
	 * 
	 * @param ChgDeltPathStupVO chgDeltPathStupVO
	 * @return long
	 * @exception DAOException
	 */	
	public boolean isDuplicateChargeDeletionPathSetup(ChgDeltPathStupVO chgDeltPathStupVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean rtnValue = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (chgDeltPathStupVO != null) {
				Map<String, String> mapVO = chgDeltPathStupVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String[] chgDeltOfcCdArray = chgDeltPathStupVO.getChgDeltOfcCd().split(",");
				velParam.put("chg_delt_ofc_cd_list",  Arrays.asList(chgDeltOfcCdArray));
				
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchDuplicateChargeDeletionPathSetupRSQL(), param, velParam);
				
				if (dbRowset.next()) {
					rtnValue = "Y".equals(dbRowset.getString(1));
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnValue;
	}
	
	/**
	 * Charge Deletion Path Setup 에 기등록된 Office 목록을 조회해서 일련의 스트링으로 반환한다. <br> 
	 * 
	 * @param ChgDeltPathStupVO chgDeltPathStupVO
	 * @return String
	 * @exception DAOException
	 */	
	public String searchDuplicateChargeDeletionOffice(ChgDeltPathStupVO chgDeltPathStupVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (chgDeltPathStupVO != null) {
				Map<String, String> mapVO = chgDeltPathStupVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String[] chgDeltOfcCdArray = chgDeltPathStupVO.getChgDeltOfcCd().split(",");
				velParam.put("chg_delt_ofc_cd_list",  Arrays.asList(chgDeltOfcCdArray));
				
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchDuplicateChargeDeletionOfficeRSQL(), param, velParam);
				
				if (dbRowset.next()) {
					rtnValue = dbRowset.getString(1);
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnValue;
	}	
	
	/**
	 * Charge Deletion Path Setup History 테이블에 등록될 승인경로이력 시퀀스를 조회한다. <br> 
	 * 
	 * @param ChgDeltPathStupVO chgDeltPathStupVO
	 * @return long
	 * @exception DAOException
	 */	
	public long searchChargeDeletionPathSetupHistorySeq(ChgDeltPathStupVO chgDeltPathStupVO) throws DAOException {
		DBRowSet dbRowset = null;
		long rtnValue = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (chgDeltPathStupVO != null) {
				Map<String, String> mapVO = chgDeltPathStupVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionPathSetupHistorySeqRSQL(), param, velParam);
				
				if (dbRowset.next()) {
					rtnValue = dbRowset.getLong(1);
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnValue;
	}
	
	/**
	 * Charge Deletion Path Setup 테이블에 등록될 승인경로 시퀀스를 조회한다. <br> 
	 * 
	 * @return long
	 * @exception DAOException
	 */	
	public long searchChargeDeletionPathSetupSeq() throws DAOException {
		DBRowSet dbRowset = null;
		long rtnValue = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionPathSetupSeqRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				rtnValue = dbRowset.getLong(1);
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnValue;
	}		
	
	/**
	 * Charge Deletion 요청시 첨부된 파일정보를 삭제한다. <br>
	 * 
	 * @param ChgDeltRqstFileVO chgDeltRqstFileVOList
	 * @throws DAOException
	 */
	public void deleteChargeDeletionRequestFile(ChgDeltRqstFileVO chgDeltRqstFileVOList) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = chgDeltRqstFileVOList.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODeleteChargeDeletionRequestFileDSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to deleteChargeDeletionRequestFile SQL");
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Charge Deletion 요청시 첨부된 파일정보를 등록한다. <br>
	 * 
	 * @param List<ChgDeltRqstFileVO> chgDeltRqstFileVOList
	 * @throws DAOException
	 */
	public void addChargeDeletionRequestFile(List<ChgDeltRqstFileVO> chgDeltRqstFileVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if (chgDeltRqstFileVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChargeCalculationDBDAOAddChargeDeletionRequestFileCSQL(), chgDeltRqstFileVOList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " Charge Deletion Attached File SQL");
				}
			}
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Charge Deletion 요청시 Charge Deletion Path Setup 테이블에 등록된 정보를 기반으로 Charge Deletion Path 정보를 등록한다. <br> 
	 * 
	 * @param List<ChgDeltPathVO> chgDeltPathVOList
	 * @throws DAOException
	 */
	public void addChargeDeletionPath(List<ChgDeltPathVO> chgDeltPathVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if (chgDeltPathVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChargeCalculationDBDAOAddChargeDeletionPathCSQL(), chgDeltPathVOList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " Charge Deletion Path SQL");
				}
			}
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 현재 승인처리와 다른 승인처리를 한 하위 승인단계의 승인자가 존재하는지 체크한다. <br> 
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @return boolean
	 * @exception DAOException
	 */	
	public boolean isChargeDeletionSubPathUser(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (chgCalcCntrVO != null) {
				Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionSubPathUserRSQL(), param, velParam);
				
				if (dbRowset.next()) {
					result = "Y".equals(dbRowset.getString(1));
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}	
	
	/**
	 * 현재 승인처리와 다른 승인처리를 한 하위 승인단계의 승인자 E-Mail 주소를 조회한다. <br> 
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @return String
	 * @exception DAOException
	 */	
	public String searchChargeDeletionNoticeRcvrAddr(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (chgCalcCntrVO != null) {
				Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionNoticeRcvrAddrRSQL(), param, velParam);
				
				if (dbRowset.next()) {
					result = dbRowset.getString(1);
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}
	
	/**
	 * 최종 필수승인단계이상 최종 승인처리 여부를 체크한다 <br> 
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @return boolean
	 * @exception DAOException
	 */	
	public boolean isChargeDeletionLastApprovalPath(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (chgCalcCntrVO != null) {
				Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionLastApprovalPathRSQL(), param, velParam);
				
				if (dbRowset.next()) {
					result = "Y".equals(dbRowset.getString(1));
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}	
	
	/**
	 * Charge Deletion 의 요청상태를 조회한다. <br> 
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @return String
	 * @exception DAOException
	 */	
	public String searchChargeDeletionRequestStatus(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (chgCalcCntrVO != null) {
				Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionRequestStatusRSQL(), param, velParam);
				
				if (dbRowset.next()) {
					result = dbRowset.getString(1);
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}
	
	/**
	 * Charge Deletion 의 요청상태를 변경한다. <br> 
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @exception DAOException
	 */
	public void modifyChargeDeletionRequestStatus(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (chgCalcCntrVO != null) {
				Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				int result = new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyChargeDeletionRequestStatusUSQL(), param, velParam);
				if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Update MT Notification Error");
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 현재 승인단계의 승인처리상태를 변경한다. <br> 
	 * 
	 * @param ChgDeltPathVO chgDeltPathVO
	 * @exception DAOException
	 */
	public void modifyChargeDeletionPathStatus(ChgDeltPathVO chgDeltPathVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (chgDeltPathVO != null) {
				Map<String, String> mapVO = chgDeltPathVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				int result = new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyChargeDeletionPathStatusUSQL(), param, velParam);
				if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Update MT Notification Error");
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Charge Deletion 변경이력 시퀀스를 조회한다. <br> 
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @return long
	 * @exception DAOException
	 */	
	public long searchChargeDeletionChangeHistorySeq(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		long result = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (chgCalcCntrVO != null) {
				Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionChangeHistorySeqRSQL(), param, velParam);
				
				if (dbRowset.next()) {
					result = dbRowset.getLong(1);
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}
	
	
	/**
	 * 승인단계별 승인상태 변경이력을 생성한다. <br> 
	 * 
	 * @param ChgDeltCngHisVO chgDeltChgHisVO
	 * @exception DAOException
	 */
	public void addChargeDeletionChangeHistory(ChgDeltCngHisVO chgDeltChgHisVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (chgDeltChgHisVO != null) {
				Map<String, String> mapVO = chgDeltChgHisVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				int result = new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOAddChargeDeletionChangeHistoryCSQL(), param, velParam);
				if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert [AddChargeDeletionChangeHistory] SQL");
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * 승인처리후 하위Office 결재자에게 메일을 전송한 후, 메일전송번호를 변경이력에 갱신해준다. <br> 
	 * 
	 * @param List<ChgDeltCngHisVO> ChgDeltCngHisVOList
	 * @throws DAOException
	 */
	public void modifyChargeDeletionEmlSndNo(List<ChgDeltCngHisVO> ChgDeltCngHisVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int updCnt[] = null;
			if (ChgDeltCngHisVOList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChargeCalculationDBDAOModifyChargeDeletionEmlSndNoUSQL(), ChgDeltCngHisVOList, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " Charge Deletion Email Send No. SQL");
				}
			}
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Charge Deletion 승인처리에 필요한 승인경로를 조회합니다. <br>
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @return boolean
	 * @exception DAOException
	 */		
	public boolean isExistsChargeDeltApprovalPath(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (chgCalcCntrVO != null) {
				Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
						
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchExistsChargeDeltApprovalPathRSQL(), param, velParam);
	
				if (dbRowset.next()) {
					result = "Y".equals(dbRowset.getString(1));
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}

	/**
	 * 로그인 사용자가 본사 승인권한이 존재하는지 조회합니다. <br>
	 * 
	 * @param String lginUsrId
	 * @param String lginOfcCd
	 * @return boolean
	 * @exception DAOException
	 */	
	public boolean isChargeDeletionHOAuth(String lginUsrId, String lginOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try {
			param.put("usr_id",     lginUsrId);
			param.put("usr_ofc_cd", lginOfcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionHOAuthRSQL(), param, null);

			if (dbRowset.next()) {
				result = "Y".equals(dbRowset.getString(1));
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}	
	
	/**
	 * 로그인 사용자가 지역본부장(RHQ) 승인권한이 존재하는지 조회합니다. <br>
	 * 
	 * @param String lginUsrId
	 * @param String lginOfcCd
	 * @return boolean
	 * @exception DAOException
	 */	
	public boolean isChargeDeletionRHQAuth(String lginUsrId, String lginOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try {
			param.put("usr_id",     lginUsrId);
			param.put("usr_ofc_cd", lginOfcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionRHQAuthRSQL(), param, null);

			if (dbRowset.next()) {
				result = "Y".equals(dbRowset.getString(1));
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}	
	
	/**
	 * 로그인 사용자가 지점장(BBG) 승인권한이 존재하는지 조회합니다. <br>
	 * 
	 * @param String lginUsrId
	 * @param String lginOfcCd
	 * @return boolean
	 * @exception DAOException
	 */	
	public boolean isChargeDeletionBBGAuth(String lginUsrId, String lginOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try {
			param.put("usr_id",     lginUsrId);
			param.put("usr_ofc_cd", lginOfcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionBBGAuthRSQL(), param, null);

			if (dbRowset.next()) {
				result = "Y".equals(dbRowset.getString(1));
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}
	
	/**
	 * 로그인 사용자가 운영업무를 총괄하는 SCO 에 대한 승인권한이 존재하는지 조회합니다. <br>
	 * 
	 * @param String lginUsrId
	 * @param String lginOfcCd
	 * @return boolean
	 * @exception DAOException
	 */	
	public boolean isChargeDeletionOOMAuth(String lginUsrId, String lginOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try {
			param.put("usr_id",     lginUsrId);
			param.put("usr_ofc_cd", lginOfcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionOOMAuthRSQL(), param, null);

			if (dbRowset.next()) {
				result = "Y".equals(dbRowset.getString(1));
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}
	
	/**
	 * Charge Deletion Request File 을 조회합니다. <br>
	 * 
	 * @param ChgDeltRqstFileVO chgDeltRqstFileVO
	 * @return List<ChgDeltRqstFileVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")	
	public List<ChgDeltRqstFileVO> searchChargeDeletionRequestFileList(ChgDeltRqstFileVO chgDeltRqstFileVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChgDeltRqstFileVO> list = new ArrayList<ChgDeltRqstFileVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (chgDeltRqstFileVO != null) {
				Map<String, String> mapVO = chgDeltRqstFileVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionRequestFileListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChgDeltRqstFileVO.class);
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
	}	
	
	/**
	 * 승인가능한 승인단계인지 여부를 체크합니다.(상위 승인단계에 대한 승인처리가 이루어진 경우 승인불가) <br>
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @return boolean
	 * @exception DAOException
	 */	
	public boolean isChargeDeletionParentApprovalPath(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (chgCalcCntrVO != null) {
				Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
						
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionParentApprovalPathRSQL(), param, velParam);
	
				if (dbRowset.next()) {
					result = "Y".equals(dbRowset.getString(1));
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}
	
	/**
	 * 동일한 승인단계의 동일한 승인처리인지 여부를 체크합니다. <br>
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @return boolean
	 * @exception DAOException
	 */	
	public boolean isChargeDeletionDuplicateApprovalStatusByCurrPath(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (chgCalcCntrVO != null) {
				Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
						
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionDuplicateApprovalStatusByCurrPathRSQL(), param, velParam);
	
				if (dbRowset.next()) {
					result = "Y".equals(dbRowset.getString(1));
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}
	
	/**
	 * 최종 필수승인단계이상 최종 승인상태를 조회합니다. <br>
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @return boolean
	 * @exception DAOException
	 */	
	public String searchChargeDeletionLastApprovalStatus(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (chgCalcCntrVO != null) {
				Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
						
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionLastApprovalStatusRSQL(), param, velParam);
	
				if (dbRowset.next()) {
					result = dbRowset.getString(1);
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}
	
	/**
	 * Charge 의 상태가 변경가능한지 여부를 체크합니다. <br>
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @return boolean
	 * @exception DAOException
	 */	
	public boolean isChargeChangeStatus(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (chgCalcCntrVO != null) {
				Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
						
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeChangeStatusRSQL(), param, velParam);
	
				if (dbRowset.next()) {
					result = "Y".equals(dbRowset.getString(1));
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}
	
	/**
	 * Balance Charge 가 존재하는지 체크합니다. <br>
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @return boolean
	 * @exception DAOException
	 */	
	public boolean isExistsBalanceCharge(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (chgCalcCntrVO != null) {
				Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
						
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchExistsBalanceChargeRSQL(), param, velParam);
	
				if (dbRowset.next()) {
					result = "Y".equals(dbRowset.getString(1));
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}	
	
	/**
	 * Charge Correction 이력이 존재하는지 체크합니다. <br>
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @return boolean
	 * @exception DAOException
	 */	
	public boolean isExistsChargeCorrectionHistory(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (chgCalcCntrVO != null) {
				Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
						
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchExistsChargeCorrectionHistoryRSQL(), param, velParam);
	
				if (dbRowset.next()) {
					result = "Y".equals(dbRowset.getString(1));
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}	
	
	/**
	 * Charge Correction History 정보를 생성한다.
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @throws DAOException
	 */
	public void addChargeCorrectionHistory(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOAddChargeCorrectionHistoryCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert Charge Correction History SQL");
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Charge Deletion 승인처리에 따라 Charge 상태를 변경합니다.
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @throws DAOException
	 */
	public void modifyChargeStatusByChargeDeletion(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyChargeStatusByChargeDeletionUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update Charge Status SQL");
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Charge 가 삭제상태이거나, 삭제요청중인지 여부를 체크합니다. <br>
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @return boolean
	 * @exception DAOException
	 */	
	public boolean isRecalculationStatus(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (chgCalcCntrVO != null) {
				Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
						
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchRecalculationStatusRSQL(), param, velParam);
	
				if (dbRowset.next()) {
					result = "Y".equals(dbRowset.getString(1));
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}	
	
	/**
	 * C현재 승인단계가 처리가능한 승인단계인지 여부를 체크합니다. <br>
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @return boolean
	 * @exception DAOException
	 */	
	public boolean isChargeDeletionApprovalPath(ChargeCalculationContainerVO chgCalcCntrVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (chgCalcCntrVO != null) {
				Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
						
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionApprovalPathRSQL(), param, velParam);
	
				if (dbRowset.next()) {
					result = "Y".equals(dbRowset.getString(1));
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}
	//###############################################< CHM-201533804 [DMT] Deletion Setup 화면 개발 영역 [E] >###############################################
	
	/**
	 * Charge Delete Reason을 조회한다.<br>
	 * 
	 * @return List<SearchDeleteMultiReasonListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchDeleteMultiReasonListVO> searchDeleteMultiReasonList() throws DAOException {
	
		List<SearchDeleteMultiReasonListVO> list = null;
		DBRowSet dbRowset = null;
		
		try{
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchDeleteMultiReasonListRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDeleteMultiReasonListVO.class);
			return list;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Charge Delete Reason을 조회한다.<br>
	 * 
	 * @param SearchDeleteMultiReasonListVO searchDeleteMultiReasonListVO
	 * @return List<SearchDeleteMultiDetailReasonListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchDeleteMultiDetailReasonListVO> searchDeleteMultiDetailReasonList(SearchDeleteMultiReasonListVO searchDeleteMultiReasonListVO) throws DAOException {
	
		List<SearchDeleteMultiDetailReasonListVO> list = null;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (searchDeleteMultiReasonListVO != null) {
				Map<String, String> mapVO = searchDeleteMultiReasonListVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
						
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchDeleteMultiDetailReasonListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDeleteMultiDetailReasonListVO.class);
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * Charge Deletion Specific Code 별로 1~6단계까지 입력된 remark 정보를 저장할 Sequence 를 조회한다. <br>
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchChargeDeltSpecRsnRmkNextSequence() throws DAOException {
	
		DBRowSet dbRowset = null;
		String  result    = "";
		
		try {
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeltSpecRsnRmkNextSequenceRSQL(), null, null);

			if (dbRowset.next()) {
				result = String.valueOf(dbRowset.getLong(1));
			}
		}
		catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return result;
	}	
	
	/**
	 * Charge Deletion Specific Code 별로 1~6단계까지 입력된 remark 정보를 저장한다. <br>
	 * 
	 * @param List<ChargeDeltSpecRsnRmkVO> chargeDeltSpecRsnRmkVOList
	 * @throws DAOException
	 */
	public void addChargeDeltSpecRsnRmkList(List<ChargeDeltSpecRsnRmkVO> chargeDeltSpecRsnRmkVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int insCnt[] = null;
			if (chargeDeltSpecRsnRmkVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChargeCalculationDBDAOAddChargeDeltSpecRsnRmkListCSQL(), chargeDeltSpecRsnRmkVOList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Charge Delete Reason을 조회한다.<br>
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @return List<ChargeDeltSpecRsnRmkVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChargeDeltSpecRsnRmkVO> searchDeletionSpecificReasonRemarkList(ChargeCalculationContainerVO chargeCalculationContainerVO) throws DAOException {
	
		List<ChargeDeltSpecRsnRmkVO> list = null;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (chargeCalculationContainerVO != null) {
				Map<String, String> mapVO = chargeCalculationContainerVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
						
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchDeletionSpecificReasonRemarkListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeInactivDetailVO.class);
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	

	/**
	 * Charge 생성시 Snap Shop 정보인 Booking Container Data를 조회한다.
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return List<ChargeCalculationContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChargeCalculationContainerVO> searchCalculationBookingContainerUcFlag(String bkgNo, String cntrNo) throws DAOException {
	
		List<ChargeCalculationContainerVO> list = null;
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{

			param.put("bkg_no",     bkgNo);
			param.put("cntr_no",    cntrNo);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchCalculationBookingContainerUcFlagRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeCalculationContainerVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		

		return list;
	}
	

	/**
	 * Charge 생성시 Snap Shop 정보인 Booking Container Data를 조회한다.
	 * 
	 * @param String ucCsNo
	 * @param String blNo
	 * @return List<ChargeCalculationContainerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChargeCalculationContainerVO> searchCalculationBookingContainerUcFlagBlNo(String ucCsNo, String blNo) throws DAOException {
	
		List<ChargeCalculationContainerVO> list = null;
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{

			param.put("uc_cs_no",     ucCsNo);
			param.put("bl_no",    blNo);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchCalculationBookingContainerUcFlagBlNoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeCalculationContainerVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		

		return list;
	}
	
	/**
	 * 해당 Charge의 Charge Status 를 'Confirmed' 상태로 수정한다.
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @param String ucFlag
	 * @throws DAOException
	 */
	public void modifyChargeUcFlag(ChargeCalculationContainerVO chgCalcCntrVO, String ucFlag) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = chgCalcCntrVO.getColumnValues();
			param.putAll(mapVO);

			param.put("uc_flag",     ucFlag);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOChargeUcFlagUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * checkChargeCorrection 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return int
	 * @throws DAOException
	 */
	public int checkChargeCorrectionUcFlag(com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO chargeArgumentVO) throws DAOException {
		int corr_his_seq = 0;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(chargeArgumentVO != null){
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckChargeCorrectionUcFlagRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				corr_his_seq = dbRowset.getInt("corr_his_seq"); 
			} else {
				corr_his_seq = 0;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return corr_his_seq;
	}


	/**
	 * Charge History 정보를 생성한다.
	 * 
	 * @param DmtChgCorrHisVO dmtChgCorrHisVO
	 * @throws DAOException
	 */
	public void addChargeHistoryUcFlg(DmtChgCorrHisVO dmtChgCorrHisVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = dmtChgCorrHisVO.getColumnValues();
			
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODmtChgCorrHisVOCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	

	/**
	 * Container 별로  DualTpExptFlag 를 구하는 로직임.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchDulTpExptFlg(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		//List<ChargeCalculationContainerVO> list = null;
		//CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{

			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				//velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchDulTpExptFlagRSQL(), param, null);
			
			String result = "";
			if(dbRowset.next())
				result = dbRowset.getString(1);
			
			return result;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/*
	 * ■■■■■■■■■■■■■■ After BKG Approval Setup (S) ■■■■■■■■■■■■■■
	 */
	/**
	 * After BKG Approval Setup 테이블에 등록된 승인경로정보 조회 <br> 
	 * 
	 * @param AftBkgPathSetupVO aftBkgPathSetupVO
	 * @return List<AftBkgPathSetupVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")	
	public List<AftBkgPathSetupVO> searchAfterBookingApprovalPathSetupList(AftBkgPathSetupVO aftBkgPathSetupVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AftBkgPathSetupVO> list = new ArrayList<AftBkgPathSetupVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (aftBkgPathSetupVO != null) {
				Map<String, String> mapVO = aftBkgPathSetupVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String[] aftBkgOfcCdArray = aftBkgPathSetupVO.getAftBkgOfcCd().split(",");
				velParam.put("aft_bkg_ofc_cd_list",  Arrays.asList(aftBkgOfcCdArray));
			
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchAftBkgPathSetupListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AftBkgPathSetupVO.class);
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
	}
	
	/**
	 * After BKG Approval Path Setup 에 기등록된 정보인지 조회한다. <br> 
	 * 
	 * @param AftBkgPathSetupVO aftBkgPathSetupVO
	 * @return boolean
	 * @exception DAOException
	 */	
	public boolean isDuplicateAftBkgPathSetup(AftBkgPathSetupVO aftBkgPathSetupVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean rtnValue = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (aftBkgPathSetupVO != null) {
				Map<String, String> mapVO = aftBkgPathSetupVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				// 동일한 데이터를 가진 항목이 존재하는 지 확인
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchDuplicateAftBkgPathRSQL(), param, velParam);
				
				if (dbRowset.next()) {
					rtnValue = "Y".equals(dbRowset.getString(1));
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnValue;
	}
	
	/**
	 * After BKG Approval Path Setup 유효한 입력 날짜인지 확인  <br>
	 * 업데이트인 경우 수정 데이터는 검증에서 제외하기 위해 변경 SEQ리스트를 받아온다
	 * 
	 * @param AftBkgPathSetupVO aftBkgPathSetupVO
	 * @param List<String> updateSeqList
	 * @return String
	 * @exception DAOException
	 */	
	public String checkAvailableDate(AftBkgPathSetupVO aftBkgPathSetupVO, List<String> updateSeqList) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (aftBkgPathSetupVO != null) {
				Map<String, String> mapVO = aftBkgPathSetupVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if(updateSeqList != null && updateSeqList.size() > 0) {
					velParam.put("update_seq_list", updateSeqList);
				} else {
					velParam.put("update_seq_list", "");
				}
				
				// 포함되는 날짜를 가진 범위가 있는지 확인
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOValidateDateAftBkgPathRSQL(), param, velParam);
				
				if (dbRowset.next()) {
					// 존재하지 않아야('N')
					rtnValue = dbRowset.getString("DT_FLG");
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnValue;
	}
	
	/**
	 * After BKG Approval Path Setup 유효한 입력 날짜인지 확인  <br> 
	 * 
	 * @param AftBkgPathSetupVO aftBkgPathSetupVO
	 * @return String
	 * @exception DAOException
	 */	
	public String checkAvailableDate(AftBkgPathSetupVO aftBkgPathSetupVO) throws DAOException {
		
		return checkAvailableDate(aftBkgPathSetupVO, null);
	}
	
	/**
	 * After BKG Approval Path Setup 에서 금액 구간이 다른지 확인<br> 
	 * 
	 * @param AftBkgPathSetupVO aftBkgPathSetupVO
	 * @param List<String> updateSeqList
	 * @return String
	 * @exception DAOException
	 */	
	public String checkAvailableAmount(AftBkgPathSetupVO aftBkgPathSetupVO, List<String> updateSeqList) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (aftBkgPathSetupVO != null) {
				Map<String, String> mapVO = aftBkgPathSetupVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if(updateSeqList != null && updateSeqList.size() > 0) {
					velParam.put("update_seq_list", updateSeqList);
				} else {
					velParam.put("update_seq_list", "");
				}
				
				// 포함되는 금액을 가진 범위가 있는지 확인
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOValidateAmountAftBkgPathRSQL(), param, velParam);
				
				if (dbRowset.next()) {
					rtnValue = dbRowset.getString(1);
				}
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnValue;
	}
	
	/**
	 * After BKG Approval Path Setup 에서 금액 구간이 다른지 확인<br> 
	 * 
	 * @param AftBkgPathSetupVO aftBkgPathSetupVO
	 * @return String
	 * @exception DAOException
	 */	
	public String checkAvailableAmount(AftBkgPathSetupVO aftBkgPathSetupVO) throws DAOException {
		
		return checkAvailableAmount(aftBkgPathSetupVO, null);
	}
	
	/**
	 * After Booking Path Setup 정보를 등록한다. <br> 
	 * 
	 * @param AftBkgPathSetupVO aftBkgPathSetupVO
	 * @throws DAOException
	 */
	public void addAftBkgPathSetup(AftBkgPathSetupVO aftBkgPathSetupVO) throws DAOException {	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			Map<String, String> mapVO = aftBkgPathSetupVO.getColumnValues();			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			int insCnt = new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOAddAftBkgPathSetupCSQL(), param, velParam);
			if(insCnt == 0) {
				throw new DAOException("Fail to insert");
			}
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * After Booking Path Setup 에 등록된 정보를 수정한다. <br> 
	 * 
	 * @param AftBkgPathSetupVO aftBkgPathSetupVO
	 * @throws DAOException
	 */
	public void modifyAftBkgPathSetup(AftBkgPathSetupVO aftBkgPathSetupVO) throws DAOException {		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			Map<String, String> mapVO = aftBkgPathSetupVO.getColumnValues();			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			int updCnt = new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyAftBkgPathSetupUSQL(), param, velParam);
			if(updCnt == 0) {
				throw new DAOException("Fail to update");
			}
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * After Booking Path Setup 에 등록된 정보를 삭제한다. (DELT_FLG 값 변경) <br> 
	 * 
	 * @param List<AftBkgPathSetupVO> AftBkgPathSetupVOList
	 * @throws DAOException
	 */
	public void removeAftBkgPathSetup(List<AftBkgPathSetupVO> aftBkgPathSetupVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int updCnt[] = null;
			if (aftBkgPathSetupVOList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChargeCalculationDBDAODeleteAftBkgPathSetupUSQL(), aftBkgPathSetupVOList, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} 
		catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * DMT_AFT_BKG_PATH_OFC_STUP 테이블 AFT_BKG_PATH_STUP_SEQ 컬럼의 최댓값을 조회한다. 
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchAftBkgMaxSequence() throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchAftBkgMaxSequenceRSQL(), param, null);
			
			String maxSeq = "";
			if(dbRowset.next())
				maxSeq = dbRowset.getString(1);
			
			return maxSeq;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/*
	 * ■■■■■■■■■■■■■■ After BKG Approval Setup (E) ■■■■■■■■■■■■■■
	 */
	

	/**
	 * Charge Delete Reason을 조회한다.<br>
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @return List<ChargeInactivHisListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChargeInactivHisListVO> searchInactiveHistoryList(ChargeCalculationContainerVO chargeCalculationContainerVO) throws DAOException {
	
		List<ChargeInactivHisListVO> list = null;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (chargeCalculationContainerVO != null) {
				Map<String, String> mapVO = chargeCalculationContainerVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
						
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchInactHisListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeInactivHisListVO.class);
			}			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	

	/**
	 * checkChargeCorrection 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param ChargeInactivDetailVO chargeInactivDetailVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCharge(ChargeInactivDetailVO chargeInactivDetailVO) throws DAOException {
		String rtnValue = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(chargeInactivDetailVO != null){
				Map<String, String> mapVO = chargeInactivDetailVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				rtnValue = dbRowset.getString("rtnValue"); 
			} else {
				rtnValue = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * checkChargeCorrection 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param InactiveReasonVO inactiveReasonVO
	 * @return List<InactiveReasonVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InactiveReasonVO> searchInactiveReason(InactiveReasonVO inactiveReasonVO) throws DAOException {
		List<InactiveReasonVO> list = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(inactiveReasonVO != null){
				Map<String, String> mapVO = inactiveReasonVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				

				if(!inactiveReasonVO.getMnRsnCd().equals("")) {
					String mnRsnCd = inactiveReasonVO.getMnRsnCd();
					List<String> mnRsnCdList = new ArrayList<String>();
					StringTokenizer st1 = new StringTokenizer(mnRsnCd, ",");
				    while (st1.hasMoreTokens()) {
				    	mnRsnCdList.add(st1.nextToken());
				    }
					velParam.put("mn_rsn_cd_list", mnRsnCdList);
				}
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchInactiveReasonRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InactiveReasonVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Inactive List 조회.<br>
	 * @param InactiveInputVO inactiveInputVO
	 * @return List<InactiveListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InactiveListVO> searchInactiveList(InactiveInputVO inactiveInputVO) throws DAOException {
		List<InactiveListVO> list = null;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(inactiveInputVO != null){
				Map<String, String> mapVO = inactiveInputVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if(!inactiveInputVO.getInactStsCd().equals("")) {
					String inanctStsCd = inactiveInputVO.getInactStsCd();
					List<String> inactStsCdLsit = new ArrayList<String>();
					StringTokenizer st1 = new StringTokenizer(inanctStsCd, ",");
				    while (st1.hasMoreTokens()) {
				    	inactStsCdLsit.add(st1.nextToken());
				    }
					velParam.put("inact_sts_cd_list", inactStsCdLsit);
				}

				if(!inactiveInputVO.getOfcCd().equals("")) {
					String ofcCd = inactiveInputVO.getOfcCd();
					List<String> ofcCdList = new ArrayList<String>();
					StringTokenizer st2 = new StringTokenizer(ofcCd, ",");
				    while (st2.hasMoreTokens()) {
				    	ofcCdList.add(st2.nextToken());
				    }
					velParam.put("ofc_cd_list", ofcCdList);
				}

				if(!inactiveInputVO.getTrfCd().equals("")) {
					String trfCd = inactiveInputVO.getTrfCd();
					List<String> trfCdList = new ArrayList<String>();
					StringTokenizer st3 = new StringTokenizer(trfCd, ",");
				    while (st3.hasMoreTokens()) {
				    	trfCdList.add(st3.nextToken());
				    }
					velParam.put("trf_cd_list", trfCdList);
				}

				if(!inactiveInputVO.getInactNo().equals("")) {
					String inactNo = inactiveInputVO.getInactNo();
					List<String> inactNoList = new ArrayList<String>();
					StringTokenizer st4 = new StringTokenizer(inactNo, ",");
				    while (st4.hasMoreTokens()) {
				    	inactNoList.add(st4.nextToken());
				    }
					velParam.put("inact_no_list", inactNoList);
				}

				if(!inactiveInputVO.getApvlNo().equals("")) {
					String apvlNo = inactiveInputVO.getApvlNo();
					List<String> apvlNoList = new ArrayList<String>();
					StringTokenizer st5 = new StringTokenizer(apvlNo, ",");
				    while (st5.hasMoreTokens()) {
				    	apvlNoList.add(st5.nextToken());
				    }
					velParam.put("apvl_no_list", apvlNoList);
				}

				if(!inactiveInputVO.getBkgNo().equals("")) {
					String bkgNo = inactiveInputVO.getBkgNo();
					List<String> bkgNoList = new ArrayList<String>();
					StringTokenizer st6 = new StringTokenizer(bkgNo, ",");
				    while (st6.hasMoreTokens()) {
				    	bkgNoList.add(st6.nextToken());
				    }
					velParam.put("bkg_no_list", bkgNoList);
				}

				if(!inactiveInputVO.getBlNo().equals("")) {
					String blNo = inactiveInputVO.getBlNo();
					List<String> blNoList = new ArrayList<String>();
					StringTokenizer st7 = new StringTokenizer(blNo, ",");
				    while (st7.hasMoreTokens()) {
				    	blNoList.add(st7.nextToken());
				    }
					velParam.put("bl_no_list", blNoList);
				}

				if(!inactiveInputVO.getInactRsnCd().equals("")) {
					String inactRsnCd = inactiveInputVO.getInactRsnCd();
					List<String> inactRsnCdList = new ArrayList<String>();
					StringTokenizer st8 = new StringTokenizer(inactRsnCd, ",");
				    while (st8.hasMoreTokens()) {
				    	inactRsnCdList.add(st8.nextToken());
				    }
					velParam.put("inact_rsn_cd_list", inactRsnCdList);
				}

				if(!inactiveInputVO.getSpecRsnCd().equals("")) {
					String specRsnCd = inactiveInputVO.getSpecRsnCd();
					List<String> specRsnCdList = new ArrayList<String>();
					StringTokenizer st9 = new StringTokenizer(specRsnCd, ",");
				    while (st9.hasMoreTokens()) {
				    	specRsnCdList.add(st9.nextToken());
				    }
					velParam.put("spec_rsn_cd_list", specRsnCdList);
				}
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOInactiveListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InactiveListVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * checkChargeCorrection 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param SearchInactiveCheckVO searchInactiveCheckVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchBookingInfo(SearchInactiveCheckVO searchInactiveCheckVO) throws DAOException {
		String rtnValue = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(searchInactiveCheckVO != null){
				Map<String, String> mapVO = searchInactiveCheckVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchBookingInfoRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				rtnValue = dbRowset.getString("rtnValue"); 
			} else {
				rtnValue = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * 해당 Charge의 Calculation 정보를 수정한다.
	 * 
	 * @param DmtChgCalcVO dmtChgCalcVO
	 * @throws DAOException
	 */
	public void modifyBkgCntr(DmtChgCalcVO dmtChgCalcVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = dmtChgCalcVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyBkgCntrUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Update PreCharge Error");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 해당 SC No. 계약 Customer 가 US067219 인지 확인한다.
	 * 
	 * @param scNo
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchContractCustomer(String scNo) throws DAOException {
		boolean rtnValue = false;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("sc_no", scNo);			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchContractCustomerRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				rtnValue = dbRowset.getString("CUST_YN").equals("Y"); 
			} 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	
	/**
	 * 해당 Invoice No가 Cancel 상태인지 확인한다.
	 * 
	 * @param invNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchInvoiceStatus(String invNo) throws DAOException {
		String rtnValue = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("inv_no", invNo);			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchInvoiceStatusRSQL(), param, null);			
			if(dbRowset.next()){ 
				rtnValue = dbRowset.getString("CANCEL_FLG"); 
			} 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * 해당 Invoice No가 Cancel 상태인지 확인한다.
	 * 
	 * @param invNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchOcCnmvDt(String temp_bkg_no, String temp_cntr_no, String temp_cntr_cyc_no ) throws DAOException {
		String rtnValue = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("bkg_no", temp_bkg_no);
			param.put("cntr_no", temp_cntr_no);
			param.put("cntr_cyc_no", temp_cntr_cyc_no);
			
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionContainerMovementOcDtRSQL(), param, null);			
			if(dbRowset.next()){ 
				rtnValue = dbRowset.getString("OC_DT"); 
			} 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	
}