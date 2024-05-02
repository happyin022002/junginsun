/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAO.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.05.29 최성환
* 1.0 Creation
* * --------------------------------------------------------
* History
* 2010.09.10 유병희 [] [EES-DMT] CSR 요청에 의해 SvrId 설정 변경으로 조회용 method추가 (searchBscSvrId() 신규)
* 2010.09.10 유병희 [] [EES-DMT] CSR 요청에 의해 searchSvrId()의 query file을 변경한다.(DMTCalculationDBDAOSearchOfficeInfoByFmYardCdRSQL -> DMTCalculationDBDAOSearchSvrIdRSQL)
* 2010.09.15 유병희 [] [EES-DMT] src품질검토 결과로 searchBscSvrId()의 변수 SvrId를 svrId로 변경합니다.
* 2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.BookingCustomerBasicVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ActCustInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.AFTExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BFRExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BKGRequestInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffInfoParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffKeyVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BkgContainerInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationTypeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChangePODTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerCntrVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerInvVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeDataVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeListVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CheckWeekEndParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CommodityExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DMIFnDTICFreeTimeEndDateVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtAFTGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtBFRGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtCmdtGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtSCGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DtocFreeTimeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DtocFreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DualTypeExceptionCustInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExceptionChargeCalculationVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExceptionCostParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExchangeRateParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.MovementParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.MovementVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OfficeInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.SCExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.StopDaysVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 DMTCalculationDBDAO <br>
 * - NIS2010-DMTCalulationUtil system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Choi Sung Hwan
 * @see DMTCalculationUtil 참조
 * @since J2EE 1.6
 */
public class DMTCalculationDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 4986337897746217501L;

	
	/**
	 *  searchBscSvrId 대한 해당 데이터를 조회한다. (2010-09-10 생성) 
	 *  src품질검토 결과로 searchBscSvrId()의 변수 SvrId를 svrId로 변경합니다. (2010-09-15 수정)
	 * @param zDcFmYdCd
	 * @return
	 * @throws DAOException
	 */
	public String searchBscSvrId(String zDcFmYdCd) throws DAOException {
		DBRowSet dbRowset = null;
		String svrId = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("fm_yd_cd", zDcFmYdCd);
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchBscSvrIdRSQL(), param, velParam);
			
			if (dbRowset.next()){
				svrId = dbRowset.getString("svrid");
			} else {
				log.debug("============================================================================");
				log.debug(" searchBscSvrId:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return svrId;
	}
	
	/**
	 * searchBookingContainerQuantity 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String zBkgNo
	 * @return int
	 * @throws DAOException
	 */
	public int searchBookingContainerQuantity(String zBkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		int bkgQty = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", zBkgNo);
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchBookingContainerQuantityRSQL(), param, velParam);
			
			if(dbRowset.next()){
				bkgQty = dbRowset.getInt("bkgqty");
			} else {
				log.debug("============================================================================");
				log.debug(" searchBookingContainerQuantity:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bkgQty;
	}

	/**
	 * searchInVVDNEta 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String  bookingNo
	 * @param String  podCode
	 * @return VVDNEtaVO 
	 * @throws DAOException
	 */
	public VVDNEtaVO searchInVVDNEta(String bookingNo, String podCode) throws DAOException {
		VVDNEtaVO vvdEtaVO = new VVDNEtaVO();
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bookingNo);
			param.put("pod_cd", podCode);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOsearchInVVDNEtaRSQL(), param, velParam);
			
			if(dbRowset.next()){
				vvdEtaVO.setVslCd(dbRowset.getString("vsl_cd"));
				vvdEtaVO.setSkdVoyNo(dbRowset.getString("skd_voy_no"));
				vvdEtaVO.setSkdDirCd(dbRowset.getString("skd_dir_cd"));
				vvdEtaVO.setVpsEtaDt(dbRowset.getString("vps_eta_dt"));
				vvdEtaVO.setBkgNo(dbRowset.getString("bkg_no"));
				vvdEtaVO.setClptIndSeq(dbRowset.getString("clpt_ind_seq"));
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vvdEtaVO;
	}

	/**
	 * searchOutVVDNEta 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String  bkgNo
	 * @param String  polCode
	 * @return VVDNEtaVO 
	 * @throws DAOException
	 */
	public VVDNEtaVO searchOutVVDNEta(String bkgNo, String polCode) throws DAOException {
		VVDNEtaVO vvdEtaVO = new VVDNEtaVO();
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			param.put("pol_cd", polCode);

			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOsearchOutVVDNEtaRSQL(), param, velParam);
			
			if(dbRowset.next()){
				vvdEtaVO.setVslCd(dbRowset.getString("vsl_cd"));
				vvdEtaVO.setSkdVoyNo(dbRowset.getString("skd_voy_no"));
				vvdEtaVO.setSkdDirCd(dbRowset.getString("skd_dir_cd"));
				vvdEtaVO.setVpsEtaDt(dbRowset.getString("vps_eta_dt"));
				vvdEtaVO.setBkgNo(dbRowset.getString("bkg_no"));
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vvdEtaVO;
	}
	

	/**
	 * searchOfficeInfoByFmYardCd 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String  zDbcIoBnd
	 * @param String  zDcFmYdCd
	 * @return OfficeInfoVO
	 * @throws DAOException
	 */
	public OfficeInfoVO searchOfficeInfoByFmYardCd(String zDbcIoBnd, String zDcFmYdCd)  throws DAOException {
		OfficeInfoVO officeInfoVO = new OfficeInfoVO();
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			velParam.put("io_bnd", zDbcIoBnd);
			param.put("fm_yd_cd", zDcFmYdCd);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchOfficeInfoByFmYardCdRSQL(), param, velParam);
			
			if(dbRowset.next()){
				officeInfoVO.setOfcCd(dbRowset.getString("ofc_cd"));
				officeInfoVO.setCollectYn(dbRowset.getString("collect_yn"));
				officeInfoVO.setOfcRhq(dbRowset.getString("ofc_rhq"));
			} else {
				log.debug("============================================================================");
				log.debug(" OfficeInfoVO searchOfficeInfoByFmYardCd:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return officeInfoVO;
	}	
	 

	/**
	 * searchOfficeInfoByToYardCd 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String  zDbcIoBnd
	 * @param String  zDcToYdCd
	 * @return OfficeInfoVO
	 * @throws DAOException
	 */
	public OfficeInfoVO searchOfficeInfoByToYardCd(String zDbcIoBnd, String zDcToYdCd) throws DAOException {
		OfficeInfoVO officeInfoVO = new OfficeInfoVO();
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			velParam.put("io_bnd", zDbcIoBnd);
			param.put("to_yd_cd", zDcToYdCd);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchOfficeInfoByToYardCdRSQL(), param, velParam);
			
			if(dbRowset.next()){
				officeInfoVO.setCollectYn(dbRowset.getString("collect_yn"));
			} else {
				log.debug("============================================================================");
				log.debug(" OfficeInfoVO searchOfficeInfoByToYardCd:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return officeInfoVO;
	}


	/**
	 * searchBkgContainerInfo 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String  zBkgNo
	 * @param String  zCntrNo  
	 * @param String  zDcFmYdCd
	 * @param String  type
	 * @param String  svrId  
	 * @param String  dmdtTrfCd
	 * @param Long  cntrCycNo
	 * @return BkgContainerInfoVO
	 * @throws DAOException
	 */
	public BkgContainerInfoVO searchBkgContainerInfo(String zBkgNo, String zCntrNo  , String zDcFmYdCd, String type, String svrId, String dmdtTrfCd, Long cntrCycNo) throws DAOException {
		BkgContainerInfoVO bkgContainerInfoVO = new BkgContainerInfoVO();
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", 		zBkgNo);
			param.put("cntr_no", 		zCntrNo);
			param.put("fm_yd_cd", 		zDcFmYdCd);
			param.put("svr_id", 		svrId);
			param.put("dmdt_trf_cd",	dmdtTrfCd);
			param.put("cntr_cyc_no",	cntrCycNo);
			//
			velParam.put("bkg_sts_cd", 	type);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchBkgContainerInfoRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				bkgContainerInfoVO.setBlNo(dbRowset.getString("bl_no"));
				
				bkgContainerInfoVO.setPorCd(dbRowset.getString("por_cd"));
				bkgContainerInfoVO.setPorContiCd(dbRowset.getString("por_conti_cd"));
				bkgContainerInfoVO.setPorCntCd(dbRowset.getString("por_cnt_cd"));
				bkgContainerInfoVO.setPorRgnCd(dbRowset.getString("por_rgn_cd"));
				bkgContainerInfoVO.setPorSteCd(dbRowset.getString("por_ste_cd"));
				
				bkgContainerInfoVO.setPodCd(dbRowset.getString("pod_cd"));
				bkgContainerInfoVO.setPolCd(dbRowset.getString("pol_cd"));
				bkgContainerInfoVO.setPolContiCd(dbRowset.getString("pol_conti_cd"));
				bkgContainerInfoVO.setPolCntCd(dbRowset.getString("pol_cnt_cd"));
				bkgContainerInfoVO.setPolRgnCd(dbRowset.getString("pol_rgn_cd"));
				bkgContainerInfoVO.setPolSteCd(dbRowset.getString("pol_ste_cd"));
				
				bkgContainerInfoVO.setDelCd(dbRowset.getString("del_cd"));
				bkgContainerInfoVO.setDelContiCd(dbRowset.getString("del_conti_cd"));
				bkgContainerInfoVO.setDelCntCd(dbRowset.getString("del_cnt_cd"));
				bkgContainerInfoVO.setDelRgnCd(dbRowset.getString("del_rgn_cd"));
				bkgContainerInfoVO.setDelSteCd(dbRowset.getString("del_ste_cd"));
				
				bkgContainerInfoVO.setYrdCd(dbRowset.getString("yrd_cd"));
				bkgContainerInfoVO.setYrdContiCd(dbRowset.getString("yrd_conti_cd"));
				bkgContainerInfoVO.setYrdCntCd(dbRowset.getString("yrd_cnt_cd"));
				bkgContainerInfoVO.setYrdRgnCd(dbRowset.getString("yrd_rgn_cd"));
				bkgContainerInfoVO.setYrdSteCd(dbRowset.getString("yrd_ste_cd"));
				
				bkgContainerInfoVO.setDcgoFlg(dbRowset.getString("dcgo_flg"));
				bkgContainerInfoVO.setRcFlg(dbRowset.getString("rc_flg"));
				bkgContainerInfoVO.setAwkCgoFlg(dbRowset.getString("awk_cgo_flg"));
				bkgContainerInfoVO.setRdCgoFlg(dbRowset.getString("rd_cgo_flg"));
				bkgContainerInfoVO.setBbCgoFlg(dbRowset.getString("bb_cgo_flg"));
				bkgContainerInfoVO.setSocFlg(dbRowset.getString("soc_flg"));
				bkgContainerInfoVO.setCntrPrtFlg(dbRowset.getString("cntr_prt_flg"));
				bkgContainerInfoVO.setAdvShtgCd(dbRowset.getString("adv_shtg_cd"));
				bkgContainerInfoVO.setObSlsOfcCd(dbRowset.getString("ob_sls_ofc_cd"));
				bkgContainerInfoVO.setSalRhq(dbRowset.getString("sal_rhq"));
				bkgContainerInfoVO.setScNo(dbRowset.getString("sc_no"));
				bkgContainerInfoVO.setRfaNo(dbRowset.getString("rfa_no"));
				bkgContainerInfoVO.setCmdtCd(dbRowset.getString("cmdt_cd"));
				bkgContainerInfoVO.setRepCmdtCd(dbRowset.getString("rep_cmdt_cd"));
				bkgContainerInfoVO.setPstRlyPortCd(dbRowset.getString("pst_rly_port_cd"));
				bkgContainerInfoVO.setDeTermCd(dbRowset.getString("de_term_cd"));
				bkgContainerInfoVO.setRcvTermCd(dbRowset.getString("rcv_term_cd"));
				bkgContainerInfoVO.setPreRlyPortCd(dbRowset.getString("pre_rly_port_cd"));
				
				bkgContainerInfoVO.setBbRcvTermCd(dbRowset.getString("bb_rcv_term_cd"));
				bkgContainerInfoVO.setBbDeTermCd(dbRowset.getString("bb_de_term_cd"));
				bkgContainerInfoVO.setIbflag("");
			} else {
				bkgContainerInfoVO.setIbflag("NoDataFound");
				log.debug("============================================================================");
				log.debug(" searchBkgContainerInfo:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bkgContainerInfoVO;
	}

	/**
	 * searchCancelBkgContainerInfo 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String  zBkgNo
	 * @param String  zCntrNo  
	 * @param String  zDcFmYdCd
	 * @return BkgContainerInfoVO
	 * @throws DAOException
	 */
	public BkgContainerInfoVO searchCancelBkgContainerInfo(String zBkgNo, String zCntrNo  , String zDcFmYdCd ) throws DAOException {
		BkgContainerInfoVO bkgContainerInfoVO = new BkgContainerInfoVO();
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", 		zBkgNo);
			param.put("cntr_no", 		zCntrNo);
			param.put("fm_yd_cd", 		zDcFmYdCd);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchCancelBkgContainerInfoRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				bkgContainerInfoVO.setBlNo(dbRowset.getString("bl_no"));
				
				bkgContainerInfoVO.setPorCd(dbRowset.getString("por_cd"));
				bkgContainerInfoVO.setPorContiCd(dbRowset.getString("por_conti_cd"));
				bkgContainerInfoVO.setPorCntCd(dbRowset.getString("por_cnt_cd"));
				bkgContainerInfoVO.setPorRgnCd(dbRowset.getString("por_rgn_cd"));
				bkgContainerInfoVO.setPorSteCd(dbRowset.getString("por_ste_cd"));
				
				bkgContainerInfoVO.setPodCd(dbRowset.getString("pod_cd"));
				bkgContainerInfoVO.setPolCd(dbRowset.getString("pol_cd"));
				bkgContainerInfoVO.setPolContiCd(dbRowset.getString("pol_conti_cd"));
				bkgContainerInfoVO.setPolCntCd(dbRowset.getString("pol_cnt_cd"));
				bkgContainerInfoVO.setPolRgnCd(dbRowset.getString("pol_rgn_cd"));
				bkgContainerInfoVO.setPolSteCd(dbRowset.getString("pol_ste_cd"));
				
				bkgContainerInfoVO.setDelCd(dbRowset.getString("del_cd"));
				bkgContainerInfoVO.setDelContiCd(dbRowset.getString("del_conti_cd"));
				bkgContainerInfoVO.setDelCntCd(dbRowset.getString("del_cnt_cd"));
				bkgContainerInfoVO.setDelRgnCd(dbRowset.getString("del_rgn_cd"));
				bkgContainerInfoVO.setDelSteCd(dbRowset.getString("del_ste_cd"));
				
				bkgContainerInfoVO.setYrdCd(dbRowset.getString("yrd_cd"));
				bkgContainerInfoVO.setYrdContiCd(dbRowset.getString("yrd_conti_cd"));
				bkgContainerInfoVO.setYrdCntCd(dbRowset.getString("yrd_cnt_cd"));
				bkgContainerInfoVO.setYrdRgnCd(dbRowset.getString("yrd_rgn_cd"));
				bkgContainerInfoVO.setYrdSteCd(dbRowset.getString("yrd_ste_cd"));
				
				bkgContainerInfoVO.setDcgoFlg(dbRowset.getString("dcgo_flg"));
				bkgContainerInfoVO.setRcFlg(dbRowset.getString("rc_flg"));
				bkgContainerInfoVO.setAwkCgoFlg(dbRowset.getString("awk_cgo_flg"));
				bkgContainerInfoVO.setRdCgoFlg(dbRowset.getString("rd_cgo_flg"));
				bkgContainerInfoVO.setBbCgoFlg(dbRowset.getString("bb_cgo_flg"));
				bkgContainerInfoVO.setSocFlg(dbRowset.getString("soc_flg"));
				bkgContainerInfoVO.setCntrPrtFlg(dbRowset.getString("cntr_prt_flg"));
				bkgContainerInfoVO.setAdvShtgCd(dbRowset.getString("adv_shtg_cd"));
				bkgContainerInfoVO.setObSlsOfcCd(dbRowset.getString("ob_sls_ofc_cd"));
				bkgContainerInfoVO.setSalRhq(dbRowset.getString("sal_rhq"));
				bkgContainerInfoVO.setScNo(dbRowset.getString("sc_no"));
				bkgContainerInfoVO.setRfaNo(dbRowset.getString("rfa_no"));
				bkgContainerInfoVO.setCmdtCd(dbRowset.getString("cmdt_cd"));
				bkgContainerInfoVO.setRepCmdtCd(dbRowset.getString("rep_cmdt_cd"));
				bkgContainerInfoVO.setPstRlyPortCd(dbRowset.getString("pst_rly_port_cd"));
				bkgContainerInfoVO.setDeTermCd(dbRowset.getString("de_term_cd"));
				bkgContainerInfoVO.setRcvTermCd(dbRowset.getString("rcv_term_cd"));
				bkgContainerInfoVO.setPreRlyPortCd(dbRowset.getString("pre_rly_port_cd"));
				
				bkgContainerInfoVO.setBbRcvTermCd(dbRowset.getString("bb_rcv_term_cd"));
				bkgContainerInfoVO.setBbDeTermCd(dbRowset.getString("bb_de_term_cd"));
				bkgContainerInfoVO.setIbflag("");
			} else {
				bkgContainerInfoVO.setIbflag("NoDataFound");
				log.debug("============================================================================");
				log.debug(" searchBkgContainerInfo:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bkgContainerInfoVO;
	}	
	

	/**
	 * changePODTariff 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String  prmLocCd
	 * @param String prmDcIoBnd
	 * @param String prmPostRly
	 * @param String prmPreRly
	 * @param String type
	 * @param String locType
	 * @return ChangePODTariffVO
	 * @throws DAOException
	 */
	public ChangePODTariffVO changePODTariff(String prmLocCd, String prmDcIoBnd, 
			String prmPostRly, String prmPreRly, String type, String locType) throws DAOException {

		ChangePODTariffVO changePODTariffVO = new ChangePODTariffVO();
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(locType.equals("ORG")){  //fixORGLocation
				
				velParam.put("loc_type",	"ORG");
				velParam.put("type",		"N");
				param.put("del_cd", 		prmLocCd);
			} 
			else if(locType.equals("DEL")){   //fixDELLocation
				velParam.put("loc_type",	"DEL");
				if(type.equals("Y")){
					velParam.put("type",	"Y");
					param.put("io_bnd", 	prmDcIoBnd);
					param.put("post_rly", 	prmPostRly);
					param.put("pre_rly", 	prmPreRly);
				} else {
					velParam.put("type",	"N");
					param.put("pod_cd", 	prmLocCd);
				}
			}	
	
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOChangePODTariffRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				changePODTariffVO.setContiCd(dbRowset.getString("conti_cd"));
				changePODTariffVO.setCntCd(dbRowset.getString("cnt_cd"));
				changePODTariffVO.setRgnCd(dbRowset.getString("rgn_cd"));
				changePODTariffVO.setSteCd(dbRowset.getString("ste_cd"));
				changePODTariffVO.setLocCd(dbRowset.getString("loc_cd"));
			} else {
				log.debug("============================================================================");
				log.debug(" changePODTariff:::: No Data");
				log.debug("============================================================================");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return changePODTariffVO;
	}


	/**
	 * searchAwkInOut 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String  zBkgNo
	 * @param String  zCntrNo  
	 * @return String
	 * @throws DAOException
	 */
	public String searchAwkInOut(String zBkgNo, String zCntrNo) throws DAOException {
		String awk_in_out = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			param.put("bkg_no", zBkgNo);
			param.put("cntr_no", zCntrNo);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchAwkInOutRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				awk_in_out = dbRowset.getString("awk_in_out");
			} else {
				log.debug("============================================================================");
				log.debug(" searchAwkInOut:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return awk_in_out;
	}
	

	/**
	 * searchBasicTariffByGeneration 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param BasicTariffParmVO basicTariffParmVO
	 * @return BasicTariffKeyVO
	 * @throws DAOException
	 */
	public BasicTariffKeyVO searchBasicTariffByGeneration(BasicTariffParmVO basicTariffParmVO) throws DAOException {
		BasicTariffKeyVO basicTariffKeyVO = new BasicTariffKeyVO();
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(basicTariffParmVO != null){
				Map<String, String> mapVO = basicTariffParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchBasicTariffByGenerationRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				basicTariffKeyVO.setSvrId(dbRowset.getString("svr_id"));
				basicTariffKeyVO.setDmdtTrfCd(dbRowset.getString("dmdt_trf_cd"));
				basicTariffKeyVO.setTrfSeq(dbRowset.getString("trf_seq"));
				basicTariffKeyVO.setDmdtDeTermCd(dbRowset.getString("dmdt_de_term_cd"));				
				basicTariffKeyVO.setTrfGrpSeq(dbRowset.getString("trf_grp_seq"));
				
				basicTariffKeyVO.setDmdtChgCmncTpCd(dbRowset.getString("dmdt_chg_cmnc_tp_cd"));
				basicTariffKeyVO.setCmncHr(dbRowset.getString("cmnc_hr"));
				basicTariffKeyVO.setXcldSatFlg(dbRowset.getString("xcld_sat_flg"));
				basicTariffKeyVO.setXcldSunFlg(dbRowset.getString("xcld_sun_flg"));
				basicTariffKeyVO.setXcldHolFlg(dbRowset.getString("xcld_hol_flg"));
				basicTariffKeyVO.setCurrCd(dbRowset.getString("curr_cd"));
				basicTariffKeyVO.setDmdtTrfGrpTpCd(dbRowset.getString("dmdt_trf_grp_tp_cd"));
				basicTariffKeyVO.setEndHr(dbRowset.getString("end_hr"));
			} else {
				log.debug("============================================================================");
				log.debug(" searchBasicTariffByGeneration:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return basicTariffKeyVO;
	}


	/**
	 * searchCalculationType 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param CalculationTypeParmVO calculationTypeParmVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCalculationType(CalculationTypeParmVO calculationTypeParmVO) throws DAOException {
		String dmdtCalcTpCd = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(calculationTypeParmVO != null){
				Map<String, String> mapVO = calculationTypeParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchCalculationTypeRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				dmdtCalcTpCd = dbRowset.getString("dmdt_calc_tp_cd");
			} else {
				log.debug("============================================================================");
				log.debug(" searchCalculationType:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dmdtCalcTpCd;
	}

	/**
	 * basicFreeTime 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String zSvrId  
	 * @param String zDttCode
	 * @param long zDtnSeq
	 * @param String zDmdtDeTermCd
	 * @param long zDtgGrpId
	 * @param long zDbcBkgQty
	 * @return long
	 * @throws DAOException
	 */
	public long basicFreeTime(String zSvrId  , String zDttCode, long zDtnSeq, String zDmdtDeTermCd, long zDtgGrpId, long zDbcBkgQty) throws DAOException {
		long ft_dys = 0;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("svr_id", 			zSvrId  );
			param.put("dtt_code", 			zDttCode);
			param.put("dmdt_de_term_cd", 	zDmdtDeTermCd);
			param.put("dtn_seq", 			zDtnSeq);
			param.put("grp_id", 			zDtgGrpId);
			param.put("qty", 				zDbcBkgQty);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchBasicFreeTimeRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				ft_dys = dbRowset.getLong("ft_dys");
			} else {
				log.debug("============================================================================");
				log.debug(" basicFreeTime:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ft_dys;
		
	}

	/**
	 * Booking Container 정보를 조회한다. <br>
	 * 
	 * @param DtocFreeTimeParmVO dtocFreeTimeParmVO
	 * @return DtocFreeTimeVO
	 * @throws DAOException
	 */
	public DtocFreeTimeVO getDTOCFtime(DtocFreeTimeParmVO dtocFreeTimeParmVO) throws DAOException {
		DtocFreeTimeVO dtocFreeTimeVO = new DtocFreeTimeVO();
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dtocFreeTimeParmVO != null){
				Map<String, String> mapVO = dtocFreeTimeParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchDtocFreeTimeRSQL(), param, velParam);

			if(dbRowset.next()){ 
				dtocFreeTimeVO.setCntrTpszCd(dbRowset.getString("cntr_tpsz_cd"));
				dtocFreeTimeVO.setBkgNo(dbRowset.getString("bkg_no"));
				dtocFreeTimeVO.setDcgoFlg(dbRowset.getString("dcgo_flg"));
				dtocFreeTimeVO.setRcFlg(dbRowset.getString("rc_flg"));
				dtocFreeTimeVO.setAwkCgoFlg(dbRowset.getString("awk_cgo_flg"));
				dtocFreeTimeVO.setRdCgoFlg(dbRowset.getString("rd_cgo_flg"));
				dtocFreeTimeVO.setBbCgoFlg(dbRowset.getString("bb_cgo_flg"));
				dtocFreeTimeVO.setSocFlg(dbRowset.getString("soc_flg"));
				dtocFreeTimeVO.setCntrPrtFlg(dbRowset.getString("cntr_prt_flg"));
				dtocFreeTimeVO.setAdvShtgCd(dbRowset.getString("adv_shtg_cd"));
				
				dtocFreeTimeVO.setPorCd(dbRowset.getString("por_cd"));
				dtocFreeTimeVO.setPorContiCd(dbRowset.getString("por_conti_cd"));
				dtocFreeTimeVO.setPorCntCd(dbRowset.getString("por_cnt_cd"));
				dtocFreeTimeVO.setPorRgnCd(dbRowset.getString("por_rgn_cd"));
				dtocFreeTimeVO.setPorSteCd(dbRowset.getString("por_ste_cd"));
				
				dtocFreeTimeVO.setPolCd(dbRowset.getString("pol_cd"));
				dtocFreeTimeVO.setPolContiCd(dbRowset.getString("pol_conti_cd"));
				dtocFreeTimeVO.setPolCntCd(dbRowset.getString("pol_cnt_cd"));
				dtocFreeTimeVO.setPolRgnCd(dbRowset.getString("pol_rgn_cd"));
				dtocFreeTimeVO.setPolSteCd(dbRowset.getString("pol_ste_cd"));
				
				dtocFreeTimeVO.setDelCd(dbRowset.getString("del_cd"));
				dtocFreeTimeVO.setDelContiCd(dbRowset.getString("del_conti_cd"));
				dtocFreeTimeVO.setDelCntCd(dbRowset.getString("del_cnt_cd"));
				dtocFreeTimeVO.setDelRgnCd(dbRowset.getString("del_rgn_cd"));
				dtocFreeTimeVO.setDelSteCd(dbRowset.getString("del_ste_cd"));
				
				dtocFreeTimeVO.setYrdCd(dbRowset.getString("yrd_cd"));
				dtocFreeTimeVO.setYrdContiCd(dbRowset.getString("yrd_conti_cd"));
				dtocFreeTimeVO.setYrdCntCd(dbRowset.getString("yrd_cnt_cd"));
				dtocFreeTimeVO.setYrdRgnCd(dbRowset.getString("yrd_rgn_cd"));
				dtocFreeTimeVO.setYrdSteCd(dbRowset.getString("yrd_ste_cd"));
				
				dtocFreeTimeVO.setDeTermCd(dbRowset.getString("de_term_cd"));
				dtocFreeTimeVO.setRcvTermCd(dbRowset.getString("rcv_term_cd"));
				
				dtocFreeTimeVO.setCmdtCd(dbRowset.getString("cmdt_cd"));
				dtocFreeTimeVO.setScNo(dbRowset.getString("sc_no"));
				dtocFreeTimeVO.setRfaNo(dbRowset.getString("rfa_no"));

				dtocFreeTimeVO.setRepCmdtCd(dbRowset.getString("rep_cmdt_cd"));
			} else {
				log.debug("============================================================================");
				log.debug(" getDTOCFtime:::: No Data");
				log.debug("============================================================================");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dtocFreeTimeVO;
	}

	/**
	 * checkChargeCorrection 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return int
	 * @throws DAOException
	 */
	public int checkChargeCorrection(ChargeArgumentVO chargeArgumentVO) throws DAOException {
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
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOCheckChargeCorrectionRSQL(), param, velParam);
			
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
	 * getFixedCmnc 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String  zVslCd
	 * @param String  zSkdVoyageNo
	 * @param String  zSkdDirCd
	 * @param String  zYdCd
	 * @param String  zDttCode
	 * @param String  type
	 * @return String
	 * @throws DAOException
	 */
	public String getFixedCmnc(String zVslCd, String zSkdVoyageNo,
			String zSkdDirCd, String zYdCd, String zDttCode, String type, String zClptIndSeq) throws DAOException {
		String fixed_cmnc = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("vsl_cd", 		zVslCd);
			param.put("skd_voyage_no", 	zSkdVoyageNo);
			param.put("skd_dir_cd", 	zSkdDirCd);
			param.put("yd_cd", 			zYdCd);
			param.put("dtt_code", 		zDttCode);
			param.put("clpt_ind_seq", 		zClptIndSeq);
			
			velParam.put("type", type);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetFixedCmncRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				fixed_cmnc = dbRowset.getString("fixed_cmnc");
			} else {
				log.debug("============================================================================");
				log.debug(" getFixedCmnc:::: No Data				");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fixed_cmnc;
	}
	

	/**
	 * getNextDay 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String prmFromDt
	 * @return String
	 * @throws DAOException
	 */
	public String getNextDay(String prmFromDt) throws DAOException {
		String from_dt = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("from_dt", prmFromDt);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetNextDayRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				from_dt = dbRowset.getString("from_dt");
			} else {
				log.debug("============================================================================");
				log.debug(" getNextDay:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return from_dt;
	}

	/**
	 * getInterchangeHR 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String  prmFromDt
	 * @param String  prmCmncHr
	 * @return String
	 * @throws DAOException
	 */
	public String getInterchangeHR(String prmFromDt, String prmCmncHr) throws DAOException {
		String from_dt = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("from_dt", prmFromDt);
			param.put("cmnc_hr", prmCmncHr);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetInterchangeHRRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				from_dt = dbRowset.getString("from_dt");
			} else {
				log.debug("============================================================================");
				log.debug(" getInterchangeHR:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return from_dt;
	}

	/**
	 * getGlobalName 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String getGlobalName() throws DAOException {
		String zSvrId = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetGlobalNameRSQL(), param, velParam);
			if(dbRowset.next()){ 
				zSvrId = dbRowset.getString("svr_id");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return zSvrId;
	}

	/**
	 * getPrevDay 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String  prmFromDt
	 * @return List<FreeTimeVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<FreeTimeVO> getPrevDay(String prmFromDt) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<FreeTimeVO> list = null;

		try{
			param.put("from_dt", prmFromDt);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetPrevDayRSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FreeTimeVO .class);
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
	 * getPlusDay 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String rtnFtimeCmnc
	 * @return List<FreeTimeVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<FreeTimeVO> getPlusDay(String rtnFtimeCmnc) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<FreeTimeVO> list = null;
		
		try{
			param.put("ftime_cmnc", rtnFtimeCmnc);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetPlusDayRSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FreeTimeVO .class);
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
	 * getTimeClockStopToDt 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String  prmDttCode
	 * @param String  prmOfcCd
	 * @param String  rtnFtimeCmnc
	 * @param String  prmYardCd
	 * @param String  termCd
	 * @return List<FreeTimeVO>
	 * @throws DAOException
	 */
	public List<FreeTimeVO> getTimeClockStopToDt(String prmDttCode, String prmOfcCd, String rtnFtimeCmnc, String prmYardCd, String termCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<FreeTimeVO> list = new ArrayList<FreeTimeVO>();
		
		try{
			param.put("dtt_code", prmDttCode);
			param.put("ofc_cd", prmOfcCd);
			param.put("ftime_cmnc", rtnFtimeCmnc);
			param.put("yd_cd", prmYardCd);
			param.put("term_cd", termCd);
						
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetTimeClockStopToDtRSQL(), param, velParam);
			
			if (dbRowset.next()){ 
				FreeTimeVO ftvo = new FreeTimeVO();
				ftvo.setCstopNo(dbRowset.getString("tmp_cstop_no"));
				ftvo.setRtnFtimeCmnc(dbRowset.getString("rtn_ftime_cmnc"));
				list.add(ftvo);
			} else {
				log.debug("============================================================================");
				log.debug(" getTimeClockStopToDt:::: No Data");
				log.debug("============================================================================");	
			}
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
	 * getHolidayToDt 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String  rtnFtimeCmnc
	 * @param String  cntCd
	 * @param String  rgnCd
	 * @param String  stateCd
	 * @param String  locCd
	 * @return String
	 * @throws DAOException
	 */
	public String getHolidayToDt(String rtnFtimeCmnc, String cntCd, String rgnCd, String stateCd, String locCd) throws DAOException {

		String ddh_date = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ftime_cmnc", rtnFtimeCmnc);
			param.put("cnt_cd", 	cntCd);
			param.put("rgn_cd", 	rgnCd);
			param.put("state_cd", 	stateCd);
			param.put("loc_cd", 	locCd);
						
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetHolidayToDtRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				ddh_date =  dbRowset.getString("ddh_date");
			} else {
				log.debug("============================================================================");
				log.debug(" getHolidayToDt:::: No Data");
				log.debug("============================================================================");	
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ddh_date;
	}

	/**
	 * getMTDate 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String prmSvrId
	 * @param String prmCntrNo
	 * @param String prmCnmvCycNo
	 * @param String prmDttCode
	 * @param String prmFmCnms
	 * @return String
	 * @throws DAOException
	 */
	public String getMTDate(String prmSvrId, String prmCntrNo, long prmCnmvCycNo, String prmDttCode, String prmFmCnms) throws DAOException {
		String prm_mt_date = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("svr_id", 		prmSvrId);
			param.put("cntr_no", 		prmCntrNo);
			param.put("cnmv_cyc_no", 	prmCnmvCycNo);
			param.put("dtt_code", 		prmDttCode);
			param.put("fm_cnms", 		prmFmCnms);
					
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetMTDateRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				prm_mt_date =  dbRowset.getString("prm_mt_date");
			} else {
				log.debug("============================================================================");
				log.debug(" getMTDate:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return prm_mt_date;
	}

	/**
	 * getOverdayStatus 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String  str
	 * @param String  str2
	 * @param String  str3
	 * @param String  type
	 * @param String  ofcCd
	 * @return List<OverdayNStatusVO>
	 * @throws DAOException
	 */
	public List<OverdayNStatusVO> getOverdayStatus(String str, String str2, long str3, String type, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<OverdayNStatusVO> list = new ArrayList<OverdayNStatusVO>();
		
		try{
			if(type.equals("1")){
				param.put("ftime_end", str2);
				param.put("ofc_cd", ofcCd);
			} else if(type.equals("2") || type.equals("3")){
				param.put("to_date", str);
				param.put("ftime_end", str2);
			} else if(type.equals("4")){
				param.put("to_date", str);
				param.put("ftime_end", str2);
				param.put("cstop_total rtn_over_day", str3);
			} else if(type.equals("5")){
				param.put("to_date", str);
				param.put("mt_date", str2);
				param.put("ofc_cd", ofcCd);
			}   else if(type.equals("6")){
				param.put("to_date", str);
				param.put("end_hr", str2);
			}  
			
			velParam.put("type", type);
						
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetOverdayStatusRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				OverdayNStatusVO osvo = new OverdayNStatusVO();
				if(type.equals("1") || type.equals("2")){
					osvo.setPrmToDate(dbRowset.getString("prm_to_date"));
					osvo.setPrmFtimeEnd(dbRowset.getString("prm_ftime_end"));
				} else if(type.equals("3")){
					osvo.setCheckNum(dbRowset.getString("check_num"));
				} else if(type.equals("4")){
					osvo.setOverDay(dbRowset.getString("rtn_over_day"));
				} else if(type.equals("5")){
					osvo.setCheckGrace(dbRowset.getString("check_grace"));
				} else if(type.equals("6")){
					osvo.setPrmToDate(dbRowset.getString("prm_to_date"));
				}  
				list.add(osvo);
			} else {
				log.debug("============================================================================");
				log.debug(" getOverdayStatus:::: No Data");
				log.debug("============================================================================");
			}
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
	 * getStopDays 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String prmToDate
	 * @param String prmDttCode
	 * @param String prmOfcCd
	 * @param String prmFtimeEnd
	 * @param String prmYardCd
	 * @param String termCd
	 * @return List<StopDaysVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<StopDaysVO> getStopDays(String prmToDate, String prmDttCode, String prmOfcCd, String prmFtimeEnd, String prmYardCd, String termCd)  throws DAOException {

		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<StopDaysVO> list = null;
		try{
			param.put("to_date", 	prmToDate);
			param.put("dtt_code", 	prmDttCode);
			param.put("ofc_cd", 	prmOfcCd);
			param.put("ftime_end", 	prmFtimeEnd);
			param.put("yd_cd", 		prmYardCd);
			param.put("term_cd",    termCd);
		
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetStopDaysRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StopDaysVO .class);
			
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
	 * General Charge Rate Data 를 조회한다.<br>
	 * 
	 * @param CalculationParmVO calculationParmVO
	 * @return List<ChargeListVO>
	 * @throws DAOException 
	 */
	public List<ChargeListVO> searchDivChrgList(CalculationParmVO calculationParmVO) throws DAOException {

		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<ChargeListVO> list = new ArrayList<ChargeListVO>();
		ChargeListVO chargListVO = null;
		try{
			
			param.put("svr_id", 		calculationParmVO.getSvrId());
			param.put("dtt_code", 		calculationParmVO.getDmdtTrfCd());
			param.put("dtn_seq", 		calculationParmVO.getTrfSeq());
			param.put("dmdt_de_term_cd",calculationParmVO.getDmdtDeTermCd());
			param.put("grp_id", 		calculationParmVO.getTrfGrpSeq());

			param.put("cntrts", 		calculationParmVO.getCntrts());
			param.put("over_day", 		calculationParmVO.getOverDay());
			param.put("div_over_day", 	calculationParmVO.getDivOverDay());
			param.put("fm_mvmt_yd_cd", 	calculationParmVO.getFmMvmtYdCd());
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchDivChrgListRSQL(), param, velParam);
				
			while(dbRowset.next()) {
				chargListVO = new ChargeListVO();
				chargListVO.setFtOvrDys(dbRowset.getString("ft_over"));
				chargListVO.setFtUndDys(dbRowset.getString("ft_under"));
				chargListVO.setRtAmt(dbRowset.getString("rate"));
				
				list.add(chargListVO);
			}

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
	 * searchCommodityExceptionByGeneration 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param CommodityExceptionParmVO commodityExceptionParmVO
	 * @return DmtCmdtGrpVO
	 * @throws DAOException
	 */
	public DmtCmdtGrpVO searchCommodityExceptionByGeneration(CommodityExceptionParmVO commodityExceptionParmVO) throws DAOException {
		DmtCmdtGrpVO dmtCmdtGrpVO = new DmtCmdtGrpVO();
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(commodityExceptionParmVO != null){
				Map<String, String> mapVO = commodityExceptionParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchCommodityExceptionByGenerationRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				dmtCmdtGrpVO.setDcrSeq(dbRowset.getString("dcr_seq")); 
				dmtCmdtGrpVO.setExclSat(dbRowset.getString("excl_sat"));
				dmtCmdtGrpVO.setExclSun(dbRowset.getString("excl_sun"));
				dmtCmdtGrpVO.setExclHoli(dbRowset.getString("excl_holi"));
				dmtCmdtGrpVO.setAddDay(dbRowset.getString("add_day"));
				dmtCmdtGrpVO.setTtlDay(dbRowset.getString("ttl_day"));
			} else {
				log.debug("============================================================================");
				log.debug(" searchCommodityExceptionByGeneration:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dmtCmdtGrpVO;
	}

	/**
	 * SearchDivSChrgList 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String prmScNo
	 * @param long prmVerSeq
	 * @param long prmGrpSeq
	 * @param String prmCntrts
	 * @param long prmOverDay
	 * @param long prmDivOverDay
	 * @return List<ChargeListVO>
	 * @throws DAOException
	 */
	public List<ChargeListVO> searchDivSChrgList(String prmScNo, long prmVerSeq, long prmGrpSeq,	String prmCntrts, long prmOverDay, long prmDivOverDay)throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		List<ChargeListVO> list = new ArrayList<ChargeListVO>();
		ChargeListVO chargListVO = null;

		try{
			param.put("sc_no", 			prmScNo);
			param.put("ver_seq", 		prmVerSeq);
			param.put("grp_seq", 		prmGrpSeq);
			
			param.put("cntrts", 		prmCntrts);
			param.put("over_day", 		prmOverDay);
			param.put("div_over_day", 	prmDivOverDay);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchDivSChrgListRSQL(), param, velParam);
			
			while(dbRowset.next()) {
				chargListVO = new ChargeListVO();
				chargListVO.setFtOvrDys(dbRowset.getString("ft_over"));
				chargListVO.setFtUndDys(dbRowset.getString("ft_under"));
				chargListVO.setRtAmt(dbRowset.getString("rate"));
				
				list.add(chargListVO);
			} 

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
	 * SearchDivBChrgList 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String prmDarNo
	 * @param long prmMapgNo
	 * @param long prmVerSeq
	 * @param long prmDtlSeq
	 * @param long prmCmbSeq
	 * @param String prmCntrts
	 * @param long prmOverDay
	 * @param long prmDivOverDay
	 * @return List<ChargeListVO>
	 * @throws DAOException
	 */
	public List<ChargeListVO> searchDivBChrgList(String prmDarNo, long prmMapgNo, long prmVerSeq, long prmDtlSeq, long prmCmbSeq,	String prmCntrts, long prmOverDay, long prmDivOverDay) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<ChargeListVO> list = new ArrayList<ChargeListVO>();
		ChargeListVO chargListVO = null;
		try{
			param.put("dar_no", 		prmDarNo);
			param.put("mapg_seq", 		prmMapgNo);
			param.put("ver_seq", 		prmVerSeq);
			param.put("dtl_seq", 		prmDtlSeq);
			param.put("cmb_seq", 		prmCmbSeq);
			param.put("cntrts", 		prmCntrts);
			param.put("over_day", 		prmOverDay);
			param.put("div_over_day", 	prmDivOverDay);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchDivBChrgListRSQL(), param, velParam);
			
			while(dbRowset.next()) {
				chargListVO = new ChargeListVO();
				chargListVO.setFtOvrDys(dbRowset.getString("ft_over"));
				chargListVO.setFtUndDys(dbRowset.getString("ft_under"));
				chargListVO.setRtAmt(dbRowset.getString("rate"));
				
				list.add(chargListVO);
			} 

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
	 * findMvmtStsCd 해당하는 Container Movement Event Date를 조회한다.<br>
	 * @param String zCntrNo
	 * @param long zCnmvCycNo
	 * @param String findMvmtStsCd
	 * @param String startMvmtStsCd
	 * @return String
	 * @throws DAOException
	 */
	public String getMinOCVLDate(String zCntrNo, long zCnmvCycNo, String findMvmtStsCd, String startMvmtStsCd)  throws DAOException {
		String rtn_dtg_efft_dt = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cntr_no", 			zCntrNo);
			param.put("cnmv_cyc_no", 		zCnmvCycNo);
			param.put("mvmt_sts_cd", 		findMvmtStsCd);
			param.put("start_mvmt_sts_cd", 	startMvmtStsCd);

			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetMinVLDateRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				rtn_dtg_efft_dt =  dbRowset.getString("rtn_dtg_efft_dt");
			} else {
				log.debug("============================================================================");
				log.debug(" getMinOCVLDate:::: No Data");
				log.debug("============================================================================");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn_dtg_efft_dt;
	}

	/**
	 * searchAFTExceptionByGeneration 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param AFTExceptionParmVO aftExceptionParmVO
	 * @return DmtAFTGrpVO
	 * @throws DAOException
	 */
	public DmtAFTGrpVO searchAFTExceptionByGeneration(AFTExceptionParmVO aftExceptionParmVO) throws DAOException {
		DmtAFTGrpVO dmtAFTGrpVO = new DmtAFTGrpVO();
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(aftExceptionParmVO != null){
				Map<String, String> mapVO = aftExceptionParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchAFTExceptionByGenerationRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				dmtAFTGrpVO.setApprNo(dbRowset.getString("appr_no"));
				dmtAFTGrpVO.setDarNo(dbRowset.getString("dar_no"));
				dmtAFTGrpVO.setAdjSeq(dbRowset.getString("adj_seq"));
				
				dmtAFTGrpVO.setFtimeMk(dbRowset.getString("ftime_mk"));
				dmtAFTGrpVO.setAddDay(dbRowset.getString("add_day"));
				dmtAFTGrpVO.setTtlDay(dbRowset.getString("ttl_day"));
				dmtAFTGrpVO.setExclSat(dbRowset.getString("excl_sat"));
				dmtAFTGrpVO.setExclSun(dbRowset.getString("excl_sun"));
				dmtAFTGrpVO.setExclHoli(dbRowset.getString("excl_holi"));
				dmtAFTGrpVO.setDcMk(dbRowset.getString("dc_mk"));
				dmtAFTGrpVO.setCurCd(dbRowset.getString("cur_cd"));
				dmtAFTGrpVO.setDcAmt(dbRowset.getString("dc_amt"));
				dmtAFTGrpVO.setDcRate(dbRowset.getString("dc_rate"));
			} else {
				log.debug("============================================================================");
				log.debug(" searchAFTExceptionByGeneration:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dmtAFTGrpVO;

	}
	
	
	/**
	 * searchSCExceptionByGeneration 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param SCExceptionParmVO scExceptionParmVO
	 * @return DmtSCGrpVO
	 * @throws DAOException
	 */
	public DmtSCGrpVO searchSCExceptionByGeneration(SCExceptionParmVO scExceptionParmVO)  throws DAOException {
		DmtSCGrpVO dmtSCGrpVO = new DmtSCGrpVO();
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(scExceptionParmVO != null){
				Map<String, String> mapVO = scExceptionParmVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchSCExceptionByGenerationRSQL(), param, velParam);
			if(dbRowset.next()){ 
				dmtSCGrpVO.setPropNo(dbRowset.getString("prop_no"));
				dmtSCGrpVO.setVerSeq(dbRowset.getString("ver_seq"));
				dmtSCGrpVO.setGrpSeq(dbRowset.getString("grp_seq"));
				
				dmtSCGrpVO.setFtimeMk(dbRowset.getString("ftime_mk"));
				dmtSCGrpVO.setExclSat(dbRowset.getString("excl_sat"));
				dmtSCGrpVO.setExclSun(dbRowset.getString("excl_sun"));
				dmtSCGrpVO.setExclHoli(dbRowset.getString("excl_holi"));
				dmtSCGrpVO.setFtAddMk(dbRowset.getString("ft_add_mk"));
				dmtSCGrpVO.setFtAddDay(dbRowset.getString("ft_add_day"));
				dmtSCGrpVO.setFtAdjMk(dbRowset.getString("ft_adj_mk"));
				dmtSCGrpVO.setRtAdjMk(dbRowset.getString("rt_adj_mk"));
				dmtSCGrpVO.setCurCd(dbRowset.getString("cur_cd"));
			} else {
				log.debug("============================================================================");
				log.debug(" searchSCExceptionByGeneration:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dmtSCGrpVO;
	}
	
	

	/**
	 * getLCLExRate 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param ExchangeRateParmVO exchangeRateParmVO
	 * @param String SqlOrder
	 * @return double
	 * @throws DAOException
	 */
	public double getLCLExRate(ExchangeRateParmVO exchangeRateParmVO, String SqlOrder) throws DAOException {
		double tmp_usd_lcl = 0.0;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("vsl_cd", 		DMTCalculationUtil.nullToString(exchangeRateParmVO.getVslCd()));
			param.put("skd_voyage_no", 	DMTCalculationUtil.nullToString(exchangeRateParmVO.getSkdVoyageNo()));
			param.put("skd_dir_cd", 	DMTCalculationUtil.nullToString(exchangeRateParmVO.getSkdDirCd()));
			
			param.put("io_bnd", 		DMTCalculationUtil.nullToString(exchangeRateParmVO.getIoBnd()));
			param.put("pod_loc", 		DMTCalculationUtil.nullToString(exchangeRateParmVO.getPodLoc()));
			param.put("pol_loc", 		DMTCalculationUtil.nullToString(exchangeRateParmVO.getPolLoc()));
			
			param.put("cur_cd", 		DMTCalculationUtil.nullToString(exchangeRateParmVO.getToCurCd()));
			param.put("fm_cur_cd", 		DMTCalculationUtil.nullToString(exchangeRateParmVO.getFmCurCd()));	// 20100429 추가
			velParam.put("sql_order", SqlOrder); //201003.24 - 1 , 2 에 따라 sql 변경
						
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetLCLExRateRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				tmp_usd_lcl =  dbRowset.getDouble("tmp_usd_lcl");
			} else {
				log.debug("============================================================================");
				log.debug(" getLCLExRate:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return tmp_usd_lcl;
	}

	/**
	 * getMonthlyRate 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String curCd
	 * @return double
	 * @throws DAOException
	 */
	public double getMonthlyRate(String curCd) throws DAOException {
		double acct_rate = 0.0;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			param.put("cur_cd", curCd);
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetMonthlyRateRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				acct_rate =  dbRowset.getDouble("acct_rate");
			} else {
				log.debug("============================================================================");
				log.debug(" getMonthlyRate:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return acct_rate;
	}

	/**
	 * getRoundRate 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param double acctRateTo
	 * @param double acctRateFrom
	 * @return double
	 * @throws DAOException
	 */
	public double getRoundRate(double acctRateTo, double acctRateFrom) throws DAOException {
		double tmp_monthly_rate = 0;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			param.put("acct_rate_to", 	acctRateTo);
			param.put("acct_rate_from", acctRateFrom);
						
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetRoundRateRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				tmp_monthly_rate =  dbRowset.getDouble("tmp_monthly_rate");
			} else {
				log.debug("============================================================================");
				log.debug(" getRoundRate:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return tmp_monthly_rate;
	}

	/**
	 * getSCEFreeTime 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String prmScNo
	 * @param long prmVerSeq
	 * @param long prmGrpSeq
	 * @param long prmQty
	 * @return long
	 * @throws DAOException
	 */
	public long getSCEFreeTime(String prmScNo, long prmVerSeq, long prmGrpSeq, long prmQty) throws DAOException {
		long ft_day = 0;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("sc_no", 	prmScNo);
			param.put("ver_seq", prmVerSeq);
			param.put("grp_seq", prmGrpSeq);
			param.put("qty", prmQty);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOgetSCEFreeTimeRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				ft_day =  dbRowset.getLong("ft_day");
			} else {
				log.debug("============================================================================");
				log.debug(" getSCEFreeTime:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ft_day;
	}
	/**
	 * searchBFRExceptionByGeneration 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param BFRExceptionParmVO bfrExceptionParmVO
	 * @return DmtBFRGrpVO
	 * @throws DAOException
	 */
	public DmtBFRGrpVO searchBFRExceptionByGeneration(BFRExceptionParmVO bfrExceptionParmVO) throws DAOException {
		DmtBFRGrpVO dmtBFRGrpVO = new DmtBFRGrpVO();
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{

			if(bfrExceptionParmVO != null){
				Map<String, String> mapVO = bfrExceptionParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchBFRExceptionByGenerationRSQL(), param, velParam);

			if(dbRowset.next()){ 
				dmtBFRGrpVO.setApprNo(dbRowset.getString("appr_no"));
				dmtBFRGrpVO.setDarNo(dbRowset.getString("dar_no"));
				dmtBFRGrpVO.setMapgSeq(dbRowset.getString("mapg_seq"));
				dmtBFRGrpVO.setVerSeq(dbRowset.getString("ver_seq"));
				dmtBFRGrpVO.setDtlSeq(dbRowset.getString("dtl_seq"));
				dmtBFRGrpVO.setCmbSeq(dbRowset.getString("cmb_seq"));
				
				dmtBFRGrpVO.setFtimeMk(dbRowset.getString("ftime_mk"));
				dmtBFRGrpVO.setAddDay(dbRowset.getString("add_day"));
				dmtBFRGrpVO.setTtlDay(dbRowset.getString("ttl_day"));
				dmtBFRGrpVO.setExclSat(dbRowset.getString("excl_sat"));
				dmtBFRGrpVO.setExclSun(dbRowset.getString("excl_sun"));
				dmtBFRGrpVO.setExclHoli(dbRowset.getString("excl_holi"));
				dmtBFRGrpVO.setRateMk(dbRowset.getString("rate_mk"));
				dmtBFRGrpVO.setCurCd(dbRowset.getString("cur_cd"));
			} else {
				log.debug("============================================================================");
				log.debug(" searchBFRExceptionByGeneration:::: No Data");
				log.debug("============================================================================");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dmtBFRGrpVO;
	}
	
	
	/**
	 * getCustInfo 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String zBkgNo
	 * @return List<ActCustInfoVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<ActCustInfoVO> getCustInfo(String zBkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<ActCustInfoVO> list = null;

		try{
			param.put("bkg_no", 		zBkgNo);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetCustInfoRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActCustInfoVO .class);
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
	 * trimCurrencyAmount 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param double prmAmt
	 * @param String type
	 * @return double
	 * @throws DAOException
	 */
	public double trimCurrencyAmount(double prmAmt, String type) throws DAOException {
		double tmpAmt = 0.0;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("amt", prmAmt);
			velParam.put("type", type);

			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOTrimCurrencyAmountRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				tmpAmt =  dbRowset.getDouble("tmp_amt");
			} else {
				log.debug("============================================================================");
				log.debug(" trimCurrencyAmount:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return tmpAmt;
	}

	/**
	 * OverdayNDiv 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param OverdayNDivParmVO overdayNDivParmVO
	 * @param String type
	 * @return OverdayNDivVO
	 * @throws DAOException
	 */
	public OverdayNDivVO overdayNDiv(OverdayNDivParmVO overdayNDivParmVO, String type) throws DAOException {
		OverdayNDivVO overdayNDivVO = new OverdayNDivVO();
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			velParam.put("type", type);
			if(overdayNDivParmVO != null){
				Map<String, String> mapVO = overdayNDivParmVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOOverdayNDivRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				overdayNDivVO.setDivOverDay(dbRowset.getString("rtn_val"));
				overdayNDivVO.setOrgFtOvrDys(dbRowset.getString("org_ft_ovr_dys"));
			} else {
				log.debug("============================================================================");
				log.debug(" searchBasicTariffByGeneration:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return overdayNDivVO;
	}

	/**
	 * getChargeData 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param chargeCalculationParmVO
	 * @return List<ChargeDataVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<ChargeDataVO> getChargeData(ChargeCalculationParmVO chargeCalculationParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<ChargeDataVO> list = null;

		try{
			if(chargeCalculationParmVO != null){
				Map<String, String> mapVO = chargeCalculationParmVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetChargeDataRSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeDataVO .class);
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
	 * bbsChargeCalculation 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param 	CalculationParmVO calculationParmVO
	 * @return 	String
	 * @throws 	DAOException
	 */
	public String bbsChargeCalculation(CalculationParmVO calculationParmVO) throws DAOException {
		String curCd = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(calculationParmVO != null){
				Map<String, String> mapVO = calculationParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOBbsChargeCalculationRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				curCd = dbRowset.getString("curr_cd");
			} else {
				log.debug("============================================================================");
				log.debug(" String bbsChargeCalculation:::: No Data");
				log.debug("============================================================================");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return curCd;
	}
	
	/**
	 * checkWeekEnd 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param CheckWeekEndParmVO checkWeekEndParmVO
	 * @return String
	 * @throws 	DAOException
	 */

	public String checkWeekEnd(CheckWeekEndParmVO checkWeekEndParmVO) throws DAOException {	
		
		String exist = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(checkWeekEndParmVO != null){
				Map<String, String> mapVO = checkWeekEndParmVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOCheckWeekEndRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				exist = dbRowset.getString("exist");
			} else {
				log.debug("============================================================================");
				log.debug(" String checkWeekEnd:::: No Data");
				log.debug("============================================================================");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return exist;
	}

	/**
	 * getDualTypeExceptionCustInfoBySC 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param 	String zBrhScNo
	 * @return 	List<DualTypeExceptionCustInfoVO>
	 * @throws 	DAOException
	 */
	public List<DualTypeExceptionCustInfoVO> getDualTypeExceptionCustInfoBySC(String zBrhScNo)throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<DualTypeExceptionCustInfoVO> list = new ArrayList<DualTypeExceptionCustInfoVO>();
		
		try{
			param.put("sc_no", 		zBrhScNo);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetDualTypeExceptionCustInfoBySCRSQL(), param, velParam);

			if (dbRowset.next()){
				DualTypeExceptionCustInfoVO vo = new DualTypeExceptionCustInfoVO();
				vo.setCustCntCd(dbRowset.getString("cust_cnt_cd"));
				vo.setCustSeq(dbRowset.getString("cust_seq"));
				list.add(vo);
			} else {
				log.debug("============================================================================");
				log.debug(" getDualTypeExceptionCustInfoBySC:::: No Data												  ");
				log.debug("============================================================================");
			}
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
	 * getDualTypeExceptionCustInfoBySC 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param 	String zBrhRfaNo
	 * @return 	List<DualTypeExceptionCustInfoVO>
	 * @throws 	DAOException
	 */
	public List<DualTypeExceptionCustInfoVO> getDualTypeExceptionCustInfoByRFA(String zBrhRfaNo)throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<DualTypeExceptionCustInfoVO> list = new ArrayList<DualTypeExceptionCustInfoVO>();
		
		try{
			param.put("rfa_no", 		zBrhRfaNo);

			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetDualTypeExceptionCustInfoByRFARSQL(), param, velParam);

			if (dbRowset.next()){
				DualTypeExceptionCustInfoVO vo = new DualTypeExceptionCustInfoVO();
				vo.setCustCntCd(dbRowset.getString("ctrt_cust_cnt_cd"));
				vo.setCustSeq(dbRowset.getString("ctrt_cust_seq"));
				list.add(vo);
			} else {
				log.debug("============================================================================");
				log.debug(" getDualTypeExceptionCustInfoByRFA:::: No Data												  ");
				log.debug("============================================================================");
			}
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
	 * searchDualTypeExceptionBySC 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param 	SCExceptionParmVO scExceptionParmVO
	 * @return 	String
	 * @throws 	DAOException
	 */
	public String searchDualTypeExceptionBySC(SCExceptionParmVO scExceptionParmVO)throws DAOException {
		DBRowSet dbRowset = null;
		String dualFlag = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(scExceptionParmVO != null){
				Map<String, String> mapVO = scExceptionParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchDualTypeExceptionBySCRSQL(), param, velParam);
			if(dbRowset.next()){
				dualFlag = dbRowset.getString("dualFlag");
			} else {
				log.debug("============================================================================");
				log.debug(" searchDualTypeExceptionBySC:::: No Data												  ");
				log.debug("============================================================================");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dualFlag;
	}
	
	
	/**
	 * searchDualTypeExceptionByRFA 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param 	BFRExceptionParmVO bfrExceptionParmVO
	 * @return 	String
	 * @throws 	DAOException
	 */
	public String searchDualTypeExceptionByRFA(BFRExceptionParmVO bfrExceptionParmVO)throws DAOException {
		DBRowSet dbRowset = null;
		String dualFlag = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bfrExceptionParmVO != null){
				Map<String, String> mapVO = bfrExceptionParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchDualTypeExceptionByRFARSQL(), param, velParam);
			if(dbRowset.next()){
				dualFlag = dbRowset.getString("dualflag");
			} else {
				log.debug("============================================================================");
				log.debug(" searchDualTypeExceptionByRFA:::: No Data												  ");
				log.debug("============================================================================");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dualFlag;
	}

	/**
	 * getMinMovement 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param 	MovementParmVO movementParmVO
	 * @return 	MovementVO
	 * @throws 	DAOException 
	 */
	public MovementVO getMinMovement(MovementParmVO movementParmVO) throws DAOException {
		MovementVO movementVO = new MovementVO();
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(movementParmVO != null){
				Map<String, String> mapVO = movementParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetMinMovementRSQL(), param, velParam);
			
			if(dbRowset.next()){
				movementVO.setCnmvYy(dbRowset.getString("min_cnmv_yy"));
				movementVO.setCnmvSeq(dbRowset.getString("min_cnmv_seq"));
				movementVO.setCnmvSplit(dbRowset.getString("min_cnmv_split"));
				movementVO.setCnmsCd(dbRowset.getString("min_cnms_cd"));
				movementVO.setOrgYdCd(dbRowset.getString("min_org_yd_cd"));
				movementVO.setCnmvDtTm(dbRowset.getString("min_cnmv_dt_tm"));
			} else {
				log.debug("============================================================================");
				log.debug(" getMinMovement:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return movementVO;
	}
	
	/**
	 * getMaxMovement 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param 	MovementParmVO movementParmVO
	 * @return 	MovementVO
	 * @throws 	DAOException 
	 */
	public MovementVO getMaxMovement(MovementParmVO movementParmVO) throws DAOException {
		MovementVO movementVO = new MovementVO();
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(movementParmVO != null){
				Map<String, String> mapVO = movementParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetMaxMovementRSQL(), param, velParam);
			
			if(dbRowset.next()){
				movementVO.setCnmvYy(dbRowset.getString("max_cnmv_yy"));
				movementVO.setCnmvSeq(dbRowset.getString("max_cnmv_seq"));
				movementVO.setCnmvSplit(dbRowset.getString("max_cnmv_split"));
				movementVO.setCnmsCd(dbRowset.getString("max_cnms_cd"));
				movementVO.setOrgYdCd(dbRowset.getString("max_org_yd_cd"));
				movementVO.setCnmvDtTm(dbRowset.getString("max_cnmv_dt_tm"));
			} else {
				log.debug("============================================================================");
				log.debug(" getMaxMovement:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return movementVO;
	}
	
	/**
	 * getPreMovement 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param 	MovementParmVO movementParmVO
	 * @return 	MovementVO
	 * @throws 	DAOException 
	 */
	public MovementVO getPreMovement(MovementParmVO movementParmVO) throws DAOException {
		MovementVO movementVO = new MovementVO();
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(movementParmVO != null){
				Map<String, String> mapVO = movementParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOGetPreMovementRSQL(), param, velParam);
			
			if(dbRowset.next()){
				movementVO.setBkgNo(dbRowset.getString("pre_bkg_no"));
				movementVO.setCnmvYy(dbRowset.getString("pre_cnmv_yy"));
				movementVO.setCnmvSeq(dbRowset.getString("pre_cnmv_seq"));
				movementVO.setCnmvSplit(dbRowset.getString("pre_cnmv_split"));
				movementVO.setCnmsCd(dbRowset.getString("pre_cnms_cd"));
				movementVO.setOrgYdCd(dbRowset.getString("pre_org_yd_cd"));
				movementVO.setCnmvDtTm(dbRowset.getString("pre_cnmv_dt_tm"));
				movementVO.setFullFlg(dbRowset.getString("pre_full_flg"));
				movementVO.setCnmvCycNo(dbRowset.getString("pre_cnmv_cyc_no"));
				movementVO.setBhCnmvCycNo(dbRowset.getString("bh_pre_cnmv_cyc_no")); // 복화 운송 시 OC 이전 ID Cycle 를 찾은 결과
			} else {
				log.debug("============================================================================");
				log.debug(" getPreMovement:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return movementVO;
	}

	/**
	 * isCntrOfcTrans 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String zSvrId
	 * @param String zCntrNo
	 * @param long zCnmvCycNo   
	 * @param String zDttCode
	 * @param String zLocDiv
	 * @param long zDccSeq
	 * @return 	List<OfficeInfoVO>
	 * @throws 	DAOException 
	 */
	public List<OfficeInfoVO> isCntrOfcTrans(String zSvrId, String zCntrNo, long zCnmvCycNo, String zDttCode, String zLocDiv, long zDccSeq) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<OfficeInfoVO> list = new ArrayList<OfficeInfoVO>();
		
		try{
			param.put("svr_id", 		zSvrId);
			param.put("cntr_no", 		zCntrNo);
			param.put("cnmv_cyc_no", 	zCnmvCycNo);
			param.put("dtt_code", 		zDttCode);
			param.put("loc_div", 		zLocDiv);
			param.put("dcc_seq", 		zDccSeq);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOIsCntrOfcTransRSQL(), param, velParam);
			if(dbRowset.next()){
				OfficeInfoVO ovo = new OfficeInfoVO();
				ovo.setOfcCd(dbRowset.getString("dot_to_ofc_cd"));
				ovo.setOfcRhq(dbRowset.getString("ofc_rhq"));
				list.add(ovo);
			} else {
				log.debug("============================================================================");
				log.debug(" isCntrOfcTrans:::: No Data												  ");
				log.debug("============================================================================");
			}
			
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
	 * searchBKGRequestInfo 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String  zBkgNo
	 * @param String  zCntrNo  
	 * @param String  zDcFmYdCd
	 * @return BKGRequestInfoVO
	 * @throws DAOException
	 */
	public BKGRequestInfoVO searchBKGRequestInfo(String zBkgNo,	String zCntrNo  , String zDcFmYdCd) throws DAOException {
		BKGRequestInfoVO bkgRequestInfoVO = new BKGRequestInfoVO();
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no", 		zBkgNo);
			param.put("cntr_no", 		zCntrNo);
			param.put("fm_yd_cd", 		zDcFmYdCd);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchBKGRequestInfoRSQL(), param, velParam);

			if(dbRowset.next()){ 
				bkgRequestInfoVO.setBlNo(dbRowset.getString("bl_no"));
				bkgRequestInfoVO.setPorCd(dbRowset.getString("por_cd"));
				bkgRequestInfoVO.setPorContiCd(dbRowset.getString("por_conti_cd"));
				bkgRequestInfoVO.setPorCntCd(dbRowset.getString("por_cnt_cd"));
				bkgRequestInfoVO.setPorRgnCd(dbRowset.getString("por_rgn_cd"));
				bkgRequestInfoVO.setPorSteCd(dbRowset.getString("por_ste_cd"));
				
				bkgRequestInfoVO.setPodCd(dbRowset.getString("pod_cd"));
				bkgRequestInfoVO.setPolCd(dbRowset.getString("pol_cd"));
				bkgRequestInfoVO.setPolContiCd(dbRowset.getString("pol_conti_cd"));
				bkgRequestInfoVO.setPolCntCd(dbRowset.getString("pol_cnt_cd"));
				bkgRequestInfoVO.setPolRgnCd(dbRowset.getString("pol_rgn_cd"));
				bkgRequestInfoVO.setPolSteCd(dbRowset.getString("pol_ste_cd"));
				
				bkgRequestInfoVO.setDelCd(dbRowset.getString("del_cd"));
				bkgRequestInfoVO.setDelContiCd(dbRowset.getString("del_conti_cd"));
				bkgRequestInfoVO.setDelCntCd(dbRowset.getString("del_cnt_cd"));
				bkgRequestInfoVO.setDelRgnCd(dbRowset.getString("del_rgn_cd"));
				bkgRequestInfoVO.setDelSteCd(dbRowset.getString("del_ste_cd"));
				
				bkgRequestInfoVO.setYrdCd(dbRowset.getString("yrd_cd"));
				bkgRequestInfoVO.setYrdContiCd(dbRowset.getString("yrd_conti_cd"));
				bkgRequestInfoVO.setYrdCntCd(dbRowset.getString("yrd_cnt_cd"));
				bkgRequestInfoVO.setYrdRgnCd(dbRowset.getString("yrd_rgn_cd"));
				bkgRequestInfoVO.setYrdSteCd(dbRowset.getString("yrd_ste_cd"));
				
				bkgRequestInfoVO.setDcgoFlg(dbRowset.getString("dcgo_flg"));
				bkgRequestInfoVO.setRcFlg(dbRowset.getString("rc_flg"));
				bkgRequestInfoVO.setAwkCgoFlg(dbRowset.getString("awk_cgo_flg"));
				bkgRequestInfoVO.setRdCgoFlg(dbRowset.getString("rd_cgo_flg"));
				bkgRequestInfoVO.setBbCgoFlg(dbRowset.getString("bb_cgo_flg"));
				bkgRequestInfoVO.setSocFlg(dbRowset.getString("soc_flg"));
				bkgRequestInfoVO.setCntrPrtFlg(dbRowset.getString("cntr_prt_flg"));
				bkgRequestInfoVO.setAdvShtgCd(dbRowset.getString("adv_shtg_cd"));
				bkgRequestInfoVO.setObSlsOfcCd(dbRowset.getString("ob_sls_ofc_cd"));
				bkgRequestInfoVO.setScNo(dbRowset.getString("sc_no"));
				bkgRequestInfoVO.setRfaNo(dbRowset.getString("rfa_no"));
				bkgRequestInfoVO.setCmdtCd(dbRowset.getString("cmdt_cd"));
				bkgRequestInfoVO.setRepCmdtCd(dbRowset.getString("rep_cmdt_cd"));
				bkgRequestInfoVO.setPstRlyPortCd(dbRowset.getString("pst_rly_port_cd"));
				bkgRequestInfoVO.setDeTermCd(dbRowset.getString("de_term_cd"));
				bkgRequestInfoVO.setPreRlyPortCd(dbRowset.getString("pre_rly_port_cd"));
				
				bkgRequestInfoVO.setBkgNo(dbRowset.getString("bkg_no"));
				bkgRequestInfoVO.setCntrNo(dbRowset.getString("cntr_no"));
				bkgRequestInfoVO.setCntrTpszCd(dbRowset.getString("cntr_tpsz_cd"));
				bkgRequestInfoVO.setCnmvCycNo(dbRowset.getString("cnmv_cyc_no"));
				bkgRequestInfoVO.setIoBndCd(dbRowset.getString("io_bnd_cd"));
				bkgRequestInfoVO.setDmdtTrfCd(dbRowset.getString("dmdt_trf_cd"));
				bkgRequestInfoVO.setIbflag("");
			} else {
				bkgRequestInfoVO.setIbflag("NoDataFound");
				
				log.debug("============================================================================");
				log.debug(" searchBKGRequestInfo:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bkgRequestInfoVO;
	}

	/**
	 * searchBookingCustomerBasicData 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String  zBkgNo
	 * @param String  zCntrNo  
	 * @return BookingCustomerBasicVO
	 * @throws DAOException
	 */
	public BookingCustomerBasicVO searchBookingCustomerBasicData(String zBkgNo, String zCntrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		BookingCustomerBasicVO bookingCustomerBasicVO = new BookingCustomerBasicVO();
		
		log.info("[bkg_no]"+zBkgNo);
		log.info("[cntr_nos]"+zCntrNo);
		try{
			param.put("bkg_no", 		zBkgNo);
			param.put("cntr_no", 		zCntrNo);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchBookingCustomerBasicDataRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				bookingCustomerBasicVO.setExist(dbRowset.getString("exist"));
				bookingCustomerBasicVO.setTpCd(dbRowset.getString("tp_cd"));
				bookingCustomerBasicVO.setDmdtTrfCd(dbRowset.getString("dmdt_trf_cd"));
				bookingCustomerBasicVO.setDmdtChgLocDivCd(dbRowset.getString("dmdt_chg_loc_div_cd"));
				bookingCustomerBasicVO.setCntrCycNo(dbRowset.getString("cntr_cyc_no"));
				bookingCustomerBasicVO.setFmMvmtStsCd(dbRowset.getString("fm_mvmt_sts_cd"));
				bookingCustomerBasicVO.setFmMvmtDt(dbRowset.getString("fm_mvmt_dt"));
				bookingCustomerBasicVO.setFmMvmtYdCd(dbRowset.getString("fm_mvmt_yd_cd"));
				bookingCustomerBasicVO.setToMvmtStsCd(dbRowset.getString("to_mvmt_sts_cd"));
				bookingCustomerBasicVO.setToMvmtYdCd(dbRowset.getString("to_mvmt_yd_cd"));
				bookingCustomerBasicVO.setIoBnd(dbRowset.getString("io_bnd"));
				bookingCustomerBasicVO.setCustCntCd(dbRowset.getString("cust_cnt_cd"));
				bookingCustomerBasicVO.setCustSeq(dbRowset.getString("cust_seq"));
				bookingCustomerBasicVO.setActCntCd(dbRowset.getString("act_cnt_cd"));
				bookingCustomerBasicVO.setActCustSeq(dbRowset.getString("act_cust_seq"));
				bookingCustomerBasicVO.setBzcTrfCurrCd(dbRowset.getString("bzc_trf_curr_cd"));
				
			} else {
				log.debug("============================================================================");
				log.debug(" searchBookingCustomerBasicData:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bookingCustomerBasicVO;
	}

	 /**
	 * searchCntrInfo 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String bkgNo 
	 * @param String cntrNo
	 * @return ChargeByBookingCustomerCntrVO
	 * @throws DAOException
	 */
	public ChargeByBookingCustomerCntrVO searchBookingCustomerCntr(String bkgNo, String cntrNo) throws DAOException {
		ChargeByBookingCustomerCntrVO chargeByBookingCustomerCntrVO = new ChargeByBookingCustomerCntrVO();
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bkg_no",  bkgNo);
			param.put("cntr_no", cntrNo);
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchBookingCustomerCntrRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				chargeByBookingCustomerCntrVO.setCntrNo(dbRowset.getString("cntr_no"));
				chargeByBookingCustomerCntrVO.setFxFtOvrDys(dbRowset.getString("fx_ft_ovr_dys"));
				chargeByBookingCustomerCntrVO.setBzcTrfCurrCd(dbRowset.getString("bzc_trf_curr_cd"));
				chargeByBookingCustomerCntrVO.setBilAmt(dbRowset.getString("bil_amt"));
				chargeByBookingCustomerCntrVO.setFtDys(dbRowset.getString("ft_dys"));
				chargeByBookingCustomerCntrVO.setFtEndDt(dbRowset.getString("ft_end_dt"));
				chargeByBookingCustomerCntrVO.setMsgCd("0");
			} else {
				log.debug("============================================================================");
				log.debug(" searchBookingCustomerCntr:::: No Data");
				log.debug("============================================================================");
				chargeByBookingCustomerCntrVO.setMsgCd("-1");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return chargeByBookingCustomerCntrVO;
	}

	 /**
	 * searchChargeByBookingCustomerInvList 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String bkgNo 
	 * @param String cntrNo
	 * @return List<ChargeByBookingCustomerInvVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChargeByBookingCustomerInvVO> searchChargeByBookingCustomerInvList(String bkgNo, String cntrNo)throws DAOException {
			DBRowSet dbRowset = null;
			List<ChargeByBookingCustomerInvVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				param.put("bkg_no", 		bkgNo);
				param.put("cntr_no", 		cntrNo);
				
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchCustomerInvListRSQL(), param, velParam);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeByBookingCustomerInvVO .class);
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
	 * searchDMIFFreeTimeEndDate 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String svrId
	 * @param String cntrNo
	 * @param long cntrCycNo
	 * @param String dmdtTrfCd
	 * @param String dmdtChgLocDivCd
	 * @param long chgSeq
	 * @return DMIFnDTICFreeTimeEndDateVO
	 * @throws DAOException
	 */
	public DMIFnDTICFreeTimeEndDateVO searchDMIFFreeTimeEndDate(String svrId, String cntrNo, long cntrCycNo, String dmdtTrfCd,
											String dmdtChgLocDivCd, long chgSeq) throws DAOException {
		DMIFnDTICFreeTimeEndDateVO dmifnDTICFreeTimeEndDateVO = new DMIFnDTICFreeTimeEndDateVO();

		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("svr_id", svrId);
			param.put("cntr_no", cntrNo);
			param.put("cntr_cyc_no", cntrCycNo);
			param.put("dmdt_trf_cd", dmdtTrfCd);
			param.put("dmdt_chg_loc_div_cd", dmdtChgLocDivCd);
			param.put("chg_seq", chgSeq);
			
			velParam.put("svr_id", svrId);
			velParam.put("cntr_no", cntrNo);
			velParam.put("cntr_cyc_no", cntrCycNo);
			velParam.put("dmdt_trf_cd", dmdtTrfCd);
			velParam.put("dmdt_chg_loc_div_cd", dmdtChgLocDivCd);
			velParam.put("chg_seq", chgSeq);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchDMIFFreeTimeEndDateRSQL(), param, velParam);
			
			if(dbRowset.next()){
				dmifnDTICFreeTimeEndDateVO.setDmifFtEnd(dbRowset.getString("dmif_ft_end"));
			} else {
				log.debug("============================================================================");
				log.debug(" searchDMIFFreeTimeEndDate:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("============================================================================");
		log.debug(" searchDMIFFreeTimeEndDate[return]::dmif_ft_end:"+dmifnDTICFreeTimeEndDateVO.getDmifFtEnd());
		log.debug("============================================================================");
		
		return dmifnDTICFreeTimeEndDateVO;

	}
	
	/**
	 * searchDTICFreeTimeEndDate 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String svrId
	 * @param String cntrNo
	 * @param long cntrCycNo
	 * @param String dmdtTrfCd
	 * @param String dmdtChgLocDivCd
	 * @param long chgSeq
	 * @return DMIFnDTICFreeTimeEndDateVO
	 * @throws DAOException
	 */
	public DMIFnDTICFreeTimeEndDateVO searchDTICFreeTimeEndDate(String svrId, String cntrNo, long cntrCycNo, String dmdtTrfCd,
																	String dmdtChgLocDivCd, long chgSeq) throws DAOException {
		DMIFnDTICFreeTimeEndDateVO dmifnDTICFreeTimeEndDateVO = new DMIFnDTICFreeTimeEndDateVO();

		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("svr_id", svrId);
			param.put("cntr_no", cntrNo);
			param.put("cntr_cyc_no", cntrCycNo);
			param.put("dmdt_trf_cd", dmdtTrfCd);
			param.put("dmdt_chg_loc_div_cd", dmdtChgLocDivCd);
			param.put("chg_seq", chgSeq);
			
			velParam.put("svr_id", svrId);
			velParam.put("cntr_no", cntrNo);
			velParam.put("cntr_cyc_no", cntrCycNo);
			velParam.put("dmdt_trf_cd", dmdtTrfCd);
			velParam.put("dmdt_chg_loc_div_cd", dmdtChgLocDivCd);
			velParam.put("chg_seq", chgSeq);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchDTICFreeTimeEndDateRSQL(), param, velParam);
			
			if(dbRowset.next()){
				dmifnDTICFreeTimeEndDateVO.setDticFtEnd(dbRowset.getString("dtic_ft_end"));
				dmifnDTICFreeTimeEndDateVO.setDticFtOver(dbRowset.getString("dtic_ft_over"));
			} else {
				log.debug("============================================================================");
				log.debug(" searchDTICFreeTimeEndDate:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("============================================================================");
		log.debug(" searchDTICFreeTimeEndDate[return]::dtic_ft_end:"+dmifnDTICFreeTimeEndDateVO.getDticFtEnd());
		log.debug(" searchDTICFreeTimeEndDate[return]::dtic_ft_over:"+dmifnDTICFreeTimeEndDateVO.getDticFtOver());
		log.debug("============================================================================");
		return dmifnDTICFreeTimeEndDateVO;

	}
	
	
	/**
	 * return: Select Sever ID 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String zOfcCd
	 * @return String
	 * @throws DAOException
	 * 
	 * 2010-09-10 : query file을 변경한다.(DMTCalculationDBDAOSearchOfficeInfoByFmYardCdRSQL -> DMTCalculationDBDAOSearchSvrIdRSQL)
	 */
	public String searchSvrId(String zOfcCd)  throws DAOException {
		String rtnSvrId = "";
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			velParam.put("ofc_cd", zOfcCd);
			param.put("ofc_cd", zOfcCd);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchSvrIdRSQL(), param, velParam);
			
			if(dbRowset.next()){
				rtnSvrId = dbRowset.getString("SYS_AREA_GRP_ID");
			} else {
				log.debug("============================================================================");
				log.debug(" searchSvrId:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnSvrId;
	}
	
	
	/**
	 * Charge가 Office Transfer 되기 전 최초의 SYS_AREA_GRP_ID 정보를 조회한다.
	 * 
	 * @param ChargeCalculationParmVO chargeCalculationParmVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchFirstSvrID(ChargeCalculationParmVO chargeCalculationParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if(chargeCalculationParmVO != null){
				Map<String, String> mapVO = chargeCalculationParmVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery(
								(ISQLTemplate) new DMTCalculationDBDAOSearchFirstSvrIDRSQL(), param, null);
			
			String result = "";
			if(dbRowset.next())
				result = dbRowset.getString(1);
			
			return result;
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Calc 적용된 Basic Tariff Info 값을 불러온다.<br>
	 * @param BasicTariffInfoParamVO basicTariffParmVO
	 * @return BasicTariffKeyVO
	 * @throws DAOException
	 */
	public BasicTariffKeyVO searchBasicTariffInfo(BasicTariffInfoParamVO basicTariffParmVO) throws DAOException {
		BasicTariffKeyVO basicTariffKeyVO = new BasicTariffKeyVO();
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(basicTariffParmVO != null){
				Map<String, String> mapVO = basicTariffParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchBasicTariffInfoRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				basicTariffKeyVO.setSvrId(dbRowset.getString("sys_area_grp_id"));
				basicTariffKeyVO.setDmdtTrfCd(dbRowset.getString("dmdt_trf_cd"));
				basicTariffKeyVO.setTrfSeq(dbRowset.getString("trf_seq"));
				basicTariffKeyVO.setTrfSeq(dbRowset.getString("trf_seq"));
				basicTariffKeyVO.setDmdtDeTermCd(dbRowset.getString("dmdt_de_term_cd"));
				basicTariffKeyVO.setTrfGrpSeq(dbRowset.getString("trf_grp_seq"));
				
				basicTariffKeyVO.setDmdtChgCmncTpCd(dbRowset.getString("dmdt_chg_cmnc_tp_cd"));
				basicTariffKeyVO.setCmncHr(dbRowset.getString("cmnc_hr"));
				basicTariffKeyVO.setXcldSatFlg(dbRowset.getString("xcld_sat_flg"));
				basicTariffKeyVO.setXcldSunFlg(dbRowset.getString("xcld_sun_flg"));
				basicTariffKeyVO.setXcldHolFlg(dbRowset.getString("xcld_hol_flg"));
				basicTariffKeyVO.setCurrCd(dbRowset.getString("curr_cd"));
				basicTariffKeyVO.setDmdtTrfGrpTpCd(dbRowset.getString("dmdt_trf_grp_tp_cd"));
			} else {
				log.debug("============================================================================");
				log.debug(" searchBasicTariffInfo:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return basicTariffKeyVO;
	}
	
	/**
	 *  RFA Exception info 정보를 조회한다.<br>
	 * @param String zDarNo 
	 * @param long zMapgSeq
	 * @param long zVerSeq
	 * @param long zDtlSeq
	 * @return DmtBFRGrpVO
	 * @throws DAOException
	 */
	public DmtBFRGrpVO searchRFAExceptionInfo(String zDarNo, long zMapgSeq, long zVerSeq, long zDtlSeq) throws DAOException {
		DmtBFRGrpVO dmtBFRGrpVO = new DmtBFRGrpVO();
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	//	Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("dar_no", zDarNo);
			param.put("mapg_seq", zMapgSeq);
			param.put("ver_seq", zVerSeq);
			param.put("dtl_seq", zDtlSeq);
			
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchRFAExceptionInfoRSQL(), param, null);

			if(dbRowset.next()){ 
				
				//dmtBFRGrpVO.setCmbSeq(dbRowset.getString("cmb_seq"));
				
				dmtBFRGrpVO.setFtimeMk(dbRowset.getString("ftime_mk"));
				dmtBFRGrpVO.setAddDay(dbRowset.getString("add_day"));
				dmtBFRGrpVO.setTtlDay(dbRowset.getString("ttl_day"));
				dmtBFRGrpVO.setExclSat(dbRowset.getString("excl_sat"));
				dmtBFRGrpVO.setExclSun(dbRowset.getString("excl_sun"));
				dmtBFRGrpVO.setExclHoli(dbRowset.getString("excl_holi"));
				dmtBFRGrpVO.setRateMk(dbRowset.getString("rate_mk"));
				dmtBFRGrpVO.setCurCd(dbRowset.getString("curr_cd"));
				dmtBFRGrpVO.setCmbSeq(dbRowset.getString("cmb_seq"));
			} else {
				log.debug("============================================================================");
				log.debug(" search RFA Exception info:::: No Data");
				log.debug("============================================================================");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dmtBFRGrpVO;
	}

	/**
	 * Exception info 정보를 조회한다.<br>
	 * @param String sc_no
	 * @param long sc_expt_ver_seq
	 * @param long sc_expt_grp_seq
	 * @return DmtSCGrpVO
	 * @throws DAOException
	 */
	public DmtSCGrpVO searchSCExceptionInfo(String sc_no, long sc_expt_ver_seq, long sc_expt_grp_seq )  throws DAOException {
		DmtSCGrpVO dmtSCGrpVO = new DmtSCGrpVO();
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("sc_no", sc_no);
			param.put("sc_expt_ver_seq", sc_expt_ver_seq);
			param.put("sc_expt_grp_seq", sc_expt_grp_seq);

		
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchSCExceptionInfoRSQL(), param, null);
			if(dbRowset.next()){ 
				dmtSCGrpVO.setPropNo(dbRowset.getString("prop_no"));
				dmtSCGrpVO.setVerSeq(dbRowset.getString("ver_seq"));
				dmtSCGrpVO.setGrpSeq(dbRowset.getString("grp_seq"));
				
				dmtSCGrpVO.setFtimeMk(dbRowset.getString("ftime_mk"));
				dmtSCGrpVO.setExclSat(dbRowset.getString("excl_sat"));
				dmtSCGrpVO.setExclSun(dbRowset.getString("excl_sun"));
				dmtSCGrpVO.setExclHoli(dbRowset.getString("excl_holi"));
				dmtSCGrpVO.setFtAddMk(dbRowset.getString("ft_add_mk"));
				dmtSCGrpVO.setFtAddDay(dbRowset.getString("ft_add_day"));
				dmtSCGrpVO.setFtAdjMk(dbRowset.getString("ft_adj_mk"));
				dmtSCGrpVO.setRtAdjMk(dbRowset.getString("rt_adj_mk"));
				dmtSCGrpVO.setCurCd(dbRowset.getString("cur_cd"));
			} else {
				log.debug("============================================================================");
				log.debug(" searchSCExceptionInfo:::: No Data");
				log.debug("============================================================================");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dmtSCGrpVO;
	}
	
	/**
	 * Exception cost 정보를 조회한다.<br>
	 * @param  ExceptionCostParmVO exceptionCostParmVO
	 * @return ExceptionChargeCalculationVO
	 * @throws DAOException
	 */
	public ExceptionChargeCalculationVO searchExceptionCostbyYard(ExceptionCostParmVO exceptionCostParmVO)  throws DAOException {
		ExceptionChargeCalculationVO exceptionChargeCalculationVO = new ExceptionChargeCalculationVO();
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			
			if(exceptionCostParmVO != null){
				Map<String, String> mapVO = exceptionCostParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
		
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchExceptionCostRateRSQL(), param, velParam);
				
				
				if(dbRowset.next()){ 
					exceptionChargeCalculationVO.setYdCd(dbRowset.getString("yd_cd"));
					exceptionChargeCalculationVO.setYdExptCostSeq(dbRowset.getString("yd_expt_cost_seq"));
					exceptionChargeCalculationVO.setIncurQty(dbRowset.getString("incur_qty"));
					exceptionChargeCalculationVO.setIncurCntrTeuKnt(dbRowset.getString("incur_cntr_teu_knt"));
					exceptionChargeCalculationVO.setExptQty(dbRowset.getString("expt_qty"));
					exceptionChargeCalculationVO.setExptCntrTeuKnt(dbRowset.getString("expt_cntr_teu_knt"));
					exceptionChargeCalculationVO.setIncurAmt(dbRowset.getString("incur_amt"));
					exceptionChargeCalculationVO.setExptFtAmt(dbRowset.getString("expt_ft_amt"));
					exceptionChargeCalculationVO.setExptDys(dbRowset.getString("expt_dys"));
					exceptionChargeCalculationVO.setExptTrfRtAdjAmt(dbRowset.getString("expt_trf_rt_adj_amt"));
					exceptionChargeCalculationVO.setExptCostAmt(dbRowset.getString("expt_cost_amt"));
				} else {
					log.debug("============================================================================");
					log.debug(" searchExceptionCost:::: No Data");
					log.debug("============================================================================");
					exceptionChargeCalculationVO.setYdCd(exceptionCostParmVO.getYdCd());
					exceptionChargeCalculationVO.setYdExptCostSeq("0");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return exceptionChargeCalculationVO;
	}
	
	/**
	 * Exception cost calc 유형 결정.<br>
	 * @param  String to_mvmt_dt
	 * @param  String expt_ft_end_dt
	 * @return String
	 * @throws DAOException
	 */
	public String searchExceptionCostCase(String to_mvmt_dt, String expt_ft_end_dt)  throws DAOException {
		String calc_fg = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			
			param.put("to_mvmt_dt", 		to_mvmt_dt);
			param.put("expt_ft_end_dt", 	expt_ft_end_dt);
			
		   dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchExceptionCostCaseRSQL(), param, null);
			if(dbRowset.next()){ 
				calc_fg = dbRowset.getString("cal_fg");
			} else {
				log.debug("============================================================================");
				log.debug(" searchExceptionCostCase:::: No Data");
				log.debug("============================================================================");
		
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return calc_fg;
	}
	

	/**
	 * 방글라데시 로직 적용 <br>
	 * @param  String in_cnt_cd
	 * @param  String prm_trf_aply_dt
	 * @return String
	 * @throws DAOException
	 */
	public String searchBangladeshFlg(String in_cnt_cd, String prm_trf_aply_dt)  throws DAOException {
		String bd_flg = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			
			param.put("in_cnt_cd", 		in_cnt_cd);
			param.put("prm_trf_aply_dt", 	prm_trf_aply_dt);
			
		   dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchBangladeshFlgRSQL(), param, null);
			if(dbRowset.next()){ 
				bd_flg = dbRowset.getString("bd_flg");
			} else {
				log.debug("============================================================================");
				log.debug(" searchExceptionCostCase:::: No Data");
				log.debug("============================================================================");
				bd_flg = "N";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return bd_flg;
	}

	/**
	 * Exception delete 유형 결정.<br>
	 * @param  String zDcToDate
	 * @param  String zDcFmYdCd
	 * @return String
	 * @throws DAOException
	 */
	public String getExceptionDeleteFlag(String zDcToDate, String zDcFmYdCd)  throws DAOException {
		String calc_fg = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			
			param.put("to_mvmt_dt", 		zDcToDate);
			param.put("fm_yd_cd", 		zDcFmYdCd);
			
		   dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchExceptionDeleteRSQL(), param, null);
			if(dbRowset.next()){ 
				calc_fg = dbRowset.getString("cal_fg");
			} else {
				calc_fg = "N";
				log.debug("============================================================================");
				log.debug(" searchExceptionCostCase:::: No Data");
				log.debug("============================================================================");
		
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return calc_fg;
	}


	/**
	 * Dual Exception delete 유형 결정.<br>
	 * @param  String zDcToDate
	 * @param  String zDcFmYdCd
	 * @return String
	 * @throws DAOException
	 */
	public String getDualExceptionDeleteFlag(String zCntrNo, long zCnmvCycNo, String zDttCode)  throws DAOException {
		String calc_fg = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			
			param.put("cntr_no", 		zCntrNo);
			param.put("cyc_no", 		zCnmvCycNo);
			param.put("trf_cd", 		zDttCode);
			
		   dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationDBDAOSearchDualExceptionDeleteRSQL(), param, null);
			if(dbRowset.next()){ 
				calc_fg = dbRowset.getString("DUL_TP_EXPT_FLG");
			} else {
				calc_fg = "N";
				log.debug("============================================================================");
				log.debug(" searchExceptionCostCase:::: No Data");
				log.debug("============================================================================");
		
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return calc_fg;
	}
	
}
