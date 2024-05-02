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
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.AfterExceptionTariffParmVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.AfterExceptionTariffVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.BalanceCreationChargeVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.BasicCurrencyCoverageVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.BasicTariffParmVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.BeforeExceptionTariffVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.BkgContainerInfoVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeBasicFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeByOfficeOrVVDVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
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
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.EDIVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ManualChargeCreationVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.MovementSZPBBParmVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.MovementSZPBBVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.OfficeNRHQVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.OfficeTransferParmByChargeVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.SCExceptionTariffVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.VDMovementVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.OfficeNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationTypeParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS ChargeCalculationDBDAO <br>
 * - OPUS-DMTClosing system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOChargeCalculationContainerVORSQL(), param, velParam);
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
	 * SZPBB Office로 생성된 Container Charge List를 조회한다.<br>
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeBySZPBBRSQL(), param, velParam);
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
	 * SZPBB Office로 발생한 Charge관련한 Movement Data를 조회한다.<br>
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOMovementSZPBBVORSQL(), param, null);
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
	 * SZPBB Office로 발생한 Charge관련한 Movement Data를 조회한다.<br>
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOBkgContainerInfoVORSQL(), param, null);
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
	 * SZPBB Office로 발생한 Charge관련한 Movement Data를 조회한다.<br>
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchVLVDDateRSQL(), param, velParam);
			
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
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeListByPodEtaRSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOMdmLocationRSQL(), param, velParam);
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAODmtChgBkgCntrRSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeMaxSequenceRSQL(), param, null);
			
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeInvoiceCheckRSQL(), param, null);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAODmtChgPreCalcBkgCntrExistRSQL(), param, null);
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAODmtChgPreCalcExistRSQL(), param, null);
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOChargePartialPaymentRSQL(), param, velParam);
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOOfficeNRHQRSQL(), param, null);
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAODmtChgCalcRSQL(), param, velParam);
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOChargeByContainerRSQL(), param, velParam);
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
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchCycleNoNSequenceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeArgumentVO.class);
			
			if(chargeArgumentVO != null) {
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
	 * @return List<ChargeCalculationContainerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChargeCalculationContainerVO> searchChargeListByStatus(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws DAOException {
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
				
				
				String chgStsCd = chargeByOfficeOrVVDVO.getDmdtChgStsCd();
				
				if(!chargeByOfficeOrVVDVO.getCondType().equals("date")) {
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
					StringTokenizer st2 = new StringTokenizer(chgStsCd, ",");
					
				    while (st2.hasMoreTokens()) {
				    	String stsCd = st2.nextToken();
				    	
				    	if(stsCd.equals("F") || stsCd.equals("N") || stsCd.equals("C") || stsCd.equals("I")) {
				    		chgStsCdList1.add(stsCd);
				    	} else if(stsCd.equals("R")) {
				    		allLongStayingFlg = "Y";
				    	} else { // 'L','E','D','U'
				    		chgStsCdList2.add(stsCd);
				    	}
				    }
				    
					velParam.put("chg_sts_cd_list1", chgStsCdList1);
					velParam.put("chg_sts_cd_list2", chgStsCdList2);
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
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeListByStatusRSQL(), param, velParam);
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAODmtChgCorrHisVORSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchInOutBoundByMovementRSQL(), param, null);
			
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchPartialPaymentRSQL(), param, null);
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckFromToDateRSQL(), param, null);
			
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchOthSvrChgSeqByPartialRSQL(), param, null);
			
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
	 * SZPBB Office의 "DMOF', "DMIF" Charge 정보를 Charge 테이블에 생성한다.<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * SZPBB Office 의 "DMOF', "DMIF" Charge 정보를 Charge 테이블에서 수정한다.
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchVVDCodeRSQL(), param, null);
			
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOBalanceCreationChargeVORSQL(), param, null);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAODeleteReasonListVORSQL(), null, null);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOChargeStatusNRemarkVORSQL(), param, null);
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckChargeInvoiceByDRCancelRSQL(), param, null);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOChargeByDRCancelRSQL(), param, null);
			
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
	 * Search Balance Count.<br>
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchBalanceCount(ChargeCalculationContainerVO chargeCalculationContainerVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String returnValue = "";
		try {
			Map<String, String> mapVO = chargeCalculationContainerVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchBalanceCountRSQL(), param, null);
			
			if(dbRowset.next()) {
				returnValue = dbRowset.getString(1);
			} else {
				returnValue = "0";
			}
			
			return returnValue;
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchPODEtaRSQL(), param, null);
			
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchVDMovementByPodEtaRSQL(), param, null);
			
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOChargeDetailVORSQL(), param, velParam);
			
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOChargeBasicFreeTimeVORSQL(), param, null);
			
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOBasicCurrencyCoverageVORSQL(), param, null);
			
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCommodityGroupTariffVORSQL(), param, null);
			
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOBeforeExceptionTariffVORSQL(), param, null);
			
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSCExceptionTariffVORSQL(), param, null);
			
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOAfterExceptionTariffVORSQL(), param, null);
			
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOClockStopVORSQL(), param, null);
			
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
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyChargeStatusByInvoiceUSQL(), param, velParam);
			
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
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)
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
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyChargeStatusByInvoiceCancelUSQL(), param, null);
			
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
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyInvoiceNoByInvoiceUSQL(), param, null);
			
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
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyChargeTruckerByInvoiceUSQL(), param, null);
			
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
            
            SQLExecuter sqlExe = new SQLExecuter("");
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
			new SQLExecuter("").executeUpdate((ISQLTemplate)
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchDualChargeTariffRSQL(), param, velParam);
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchRhqGrpIdRSQL(), param, null);
			
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckChargeByOfficeTransferRSQL(), param, null);
			
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchCurrentDateByOfficeRSQL(), param, null);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckChargeBookingContainerExistsRSQL(), param, null);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckChargeByConfirmDeleteDeleteCancelRSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckMultiChargeByOfficeTransferRSQL(), param, null);
			
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
	public boolean checkRequestChargeDeletion(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckRequestChargeDeletionRSQL(), param, velParam);
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
				
			SQLExecuter sqlExe = new SQLExecuter("");
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
			if(ofcCd.equals("HAMUOG") || ofcCd.equals("NYCNOG")|| ofcCd.equals("SINWOG")|| ofcCd.equals("SHAAOG") ) {
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDeletionRequestRSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckEDIRSQL(), param, null);
			
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
	 * Container별 Tariff Type별 Charge 한 건의 정보를 조회한다.<br>
	 * 
	 * @param ChargeCalculationContainerVO chargeCalCntrVO
	 * @return ChargeCalculationContainerVO
	 */
	@SuppressWarnings("unchecked")
	public ChargeCalculationContainerVO searchChargeDetail(ChargeCalculationContainerVO chargeCalCntrVO) throws DAOException {
		
		List<ChargeCalculationContainerVO> list = null;
		ChargeCalculationContainerVO chgCalcCntrVO = null;
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chargeCalCntrVO != null) {
				Map<String, String> mapVO = chargeCalCntrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchChargeDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeCalculationContainerVO.class);
			
			if(list != null && list.size() > 0) {
				chgCalcCntrVO = (ChargeCalculationContainerVO)list.get(0);
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
	 * 일 배치에 대한 대상 건수가 존재하는지 체크한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkDailyMovementCalculationByBooking(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckDailyMovementCalculationByBookingRSQL(), param, velParam);
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
	 * Charge가 Invoice가 되거나, Credit Note이고 AR Interface 안된건의  존재여부를 조회한다. 
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return boolean
	 * @throws DAOException
	 */
	public String[] checkChargeInvoiceByBooking (ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] invoiceNo = null;
		
		try{
			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckChargeInvoiceByBookingRSQL(), param, velParam);
			log.debug("size======>"+dbRowset.getRowCount());
			if(dbRowset.getRowCount() == 0)	return null;
			
			invoiceNo = new String[dbRowset.getRowCount()];
			int i = 0;
			while(dbRowset.next()){
				invoiceNo[i] = dbRowset.getString(1);
				i++;
			}
			return invoiceNo;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	

	/**
	 * 해당 Charge의 Charge Calc 정보를 삭제한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @throws DAOException
	 */
	public void deleteChargeByBooking(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODeleteChargeByBookingDSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * 해당 Charge의 Booking Charge 정보를 삭제한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @throws DAOException
	 */
	public void deleteBookingChargeByBooking(ChargeArgumentVO chargeArgumentVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAODeleteBookingChargeByBookingDSQL(), param, velParam);
						
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		

	/**
	 * 일 배치에 대한 대상 건수가 존재하는지 체크한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkCalculationByBooking(ChargeArgumentVO chargeArgumentVO) throws DAOException {
	
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
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOCheckCalculationByBookingRSQL(), param, velParam);

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
	 * 일자 조회
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchDate() throws DAOException {
	
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		
        String result = "";
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChargeCalculationDBDAOSearchDateRSQL(), param, velParam);

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
	 * Manual Batch History 정보를 생성한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @param String date
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addManualBatchHistroy(ChargeArgumentVO chargeArgumentVO, String date, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {


			if(chargeArgumentVO != null) {
				Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
				param.putAll(mapVO);
				param.put("user_id", account.getUpd_usr_id());
				param.put("bat_run_tm_id", date);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOAddManualBatchHistoryCSQL(), param, param);
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
	 * Manual Batch History 정보를 생성한다.
	 * 
	 * @param String bkgNo
	 * @param String trfCd
	 * @param String batRunTmId
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void updateManualBatchHistroy(String bkgNo, String trfCd, String batRunTmId, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			
			param.put("user_id", account.getUpd_usr_id());
			param.put("bat_run_tm_id", batRunTmId);
			param.put("bkg_no", bkgNo);
			param.put("trf_cd", trfCd);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOModifyManualBatchHistoryUSQL(), param, null);
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
	 * Manual Batch 에서  삭제 전에 Charge Backup 정보를 생성한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addManualBatchChargeBackup(ChargeArgumentVO chargeArgumentVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			param.put("delt_usr_id", account.getUpd_usr_id());
			param.put("delt_ofc_cd", account.getOfc_cd());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOChargeBackupManualBatchCSQL(), param, param);
			
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
	 * Manual Batch 에서  삭제 전에 Booking Contianer Backup 정보를 생성한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addManualBatchBkgCntrBackup(ChargeArgumentVO chargeArgumentVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = 0;
			result = sqlExe.executeUpdate((ISQLTemplate)new ChargeCalculationDBDAOBkgCntrBackupManualBatchCSQL(), param, param);
			
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
}