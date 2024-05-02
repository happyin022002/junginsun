/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementCorrectionDBDAO.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011-05-11
*@LastModifier : 민정호
*@LastVersion : 1.2
* 2010-03-26 jong hyek choi
* 1.0 최초 생성
* 
* 1.1 2010-05-26 김종호 : Inquiry 기능 구현
* 1.2 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
* 1.3 2011.06.29 민정호 [CHM-201111442] R9 CNTR 추가관련 로직 변경요청
* 2011.07.20 김영철 [CHM-201111871] [TRS] R4J 소스 품질 조치 내역 수정
* 2011.09.21 최종혁   [CHM-201113360] [TRS] AGMT delete function 변경 + Feeder term Rule 인식 변경 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Collection;
import java.sql.Statement;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0227Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0230Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0231Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0235Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsAgmtEqRtHisVO;
import com.hanjin.syscommon.common.table.TrsAgmtScgRtHisVO;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * @author jong hyek choi
 * @see DBDAOSupport
 * @since J2EE 1.6
 */
public class AgreementHisDBDAO extends DBDAOSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Agreement Rate History정보 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRateHisAgmt(EsdTrs0227Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fm_agmtno", event.getFm_agmtno());   
		param.put("fm_trsp_agmt_rt_tp_cd", event.getFm_trsp_agmt_rt_tp_cd());
		param.put("fm_eq_knd_cd", event.getFm_eq_knd_cd());
		param.put("fm_trsp_cost_mod_cd", event.getFm_trsp_cost_mod_cd());
		param.put("fm_agmt_trsp_tp_cd", event.getFm_agmt_trsp_tp_cd());
		param.put("fm_cgo_tp_cd", event.getFm_cgo_tp_cd());
		param.put("fm_cust_cd", event.getFm_cust_cd());
		param.put("fm_cmdt_grp_cd", event.getFm_cmdt_grp_cd());
		param.put("fm_rail_svc_tp_cd", event.getFm_rail_svc_tp_cd());
		param.put("fm_fm_nod_cd", event.getFm_fm_nod_cd());
		param.put("fm_via_nod_cd", event.getFm_via_nod_cd());
		param.put("fm_dor_nod_cd", event.getFm_dor_nod_cd());
		param.put("fm_to_nod_cd", event.getFm_to_nod_cd());
		param.put("fm_fm_nod_yd", event.getFm_fm_nod_yd());
		param.put("fm_via_nod_yd", event.getFm_via_nod_yd());
		param.put("fm_dor_nod_yd", event.getFm_dor_nod_yd());
		param.put("fm_to_nod_yd", event.getFm_to_nod_yd());
		param.put("fm_trsp_dist_tp_cd", event.getFm_trsp_dist_tp_cd());
		param.put("fm_trsp_agmt_dist", event.getFm_trsp_agmt_dist());
		param.put("fm_dist_meas_ut_cd", event.getFm_dist_meas_ut_cd());
					
		List<String> arr_Eqtpsz = new ArrayList();
		arr_Eqtpsz = this.seperationParameter(event.getFm_eqtpsz(), ","); 
		param.put("fm_eqtpsz", arr_Eqtpsz);


		if(event.getEffective_date() != null){
			param.put("effective_date", event.getEffective_date());
		}		
		
		param.put("delete_yn", event.getDelete_yn());
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementHisDBDAOSearchRateHisAgmtRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * Agreement Surcharge Rate History정보 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchScgHisAgmt(EsdTrs0230Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		List<String> arr_Eqtpsz = new ArrayList();
		arr_Eqtpsz = this.seperationParameter(event.getFm_eqtpsz(), ","); 
		param.put("fm_eqtpsz", arr_Eqtpsz);
				
		param.put("fm_agmtno", event.getFm_agmtno());		
		
		param.put("fm_trsp_agmt_rt_tp_cd", event.getFm_trsp_agmt_rt_tp_cd());
		param.put("fm_eq_knd_cd", event.getFm_eq_knd_cd());
		param.put("fm_trsp_cost_mod_cd", event.getFm_trsp_cost_mod_cd());
		param.put("fm_agmt_trsp_tp_cd", event.getFm_agmt_trsp_tp_cd());
		param.put("fm_cgo_tp_cd", event.getFm_cgo_tp_cd());
		param.put("fm_cust_cd", event.getFm_cust_cd());
		param.put("fm_cmdt_grp_cd", event.getFm_cmdt_grp_cd());
		param.put("fm_rail_svc_tp_cd", event.getFm_rail_svc_tp_cd());
		param.put("fm_fm_nod_cd", event.getFm_fm_nod_cd());
		param.put("fm_via_nod_cd", event.getFm_via_nod_cd());
		param.put("fm_dor_nod_cd", event.getFm_dor_nod_cd());
		param.put("fm_to_nod_cd", event.getFm_to_nod_cd());
		param.put("fm_trsp_scg_cd", event.getFm_trsp_scg_cd());
		param.put("fm_agmt_route_all_flg", event.getFm_agmt_route_all_flg());
		param.put("fm_fm_nod_yd", event.getFm_fm_nod_yd());
		param.put("fm_via_nod_yd", event.getFm_via_nod_yd());
		param.put("fm_dor_nod_yd", event.getFm_dor_nod_yd());
		param.put("fm_to_nod_yd", event.getFm_to_nod_yd());
		param.put("delete_yn", event.getDelete_yn());
		
			
		if(event.getEffective_date() != null){
			param.put("effective_date", event.getEffective_date());
		}		
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementHisDBDAOSearchScgHisAgmtRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}

//###################################################################################################################시작	
	
	/**
	 * Agreement Rate Inquiry
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchDtlAgmt(EsdTrs0231Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		List<String> arr_Eqtpsz = new ArrayList();
		arr_Eqtpsz = this.seperationParameter(event.getEqtpsz(), ","); 
		param.put("eqtpsz", arr_Eqtpsz);
		param.put("fm_nod",  event.getSearch_fm_loc()+event.getSearch_fm_yard());
		param.put("via_nod", event.getSearch_via_loc()+event.getSearch_via_yard()); 
		param.put("to_nod", event.getSearch_to_loc()+event.getSearch_to_yard()); 
		param.put("dor_nod",  event.getSearch_door_loc()+event.getSearch_door_yard()); 
		param.put("costmode",event.getCostmode());
		param.put("cargo",event.getCargo());
		param.put("eqtype",event.getEqtype());
		param.put("fmAgmtTrspTpCd",event.getFmAgmtTrspTpCd());
		param.put("fmEffectiveAgmt",event.getFmEffectiveAgmt());
		param.put("fmVndrPrmrySeq",event.getFmVndrPrmrySeq());
		param.put("cur_page_cnt", event.getCurPageCnt());
		param.put("page_size", event.getPageSize());
		param.put("delete_yn", event.getDeleteYn());
		param.put("approval_date", event.getApprovalDate());
		log.debug("approval_date=========================="+event.getApprovalDate());
		
		if(event.getFmAgmtno().length() > 3){
			int fmAgmtnoLength = event.getFmAgmtno().length();
			param.put("trspAgmtOfcCtyCd",event.getFmAgmtno().substring(0, 3));		// 민정호-추가
			param.put("trspAgmtSeq",event.getFmAgmtno().substring(3, fmAgmtnoLength));				
		}
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementHisDBDAOSearchDtlAgmtRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * Agreement Rate Inquiry(Effective date 형식으로)
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchDtlAgmtEffDt(EsdTrs0231Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
//		String trsp_agmt_ofc_cty_cd = "";
//		int trsp_agmt_seq = 0;		
		
		List<String> arr_Eqtpsz = new ArrayList();
		arr_Eqtpsz = this.seperationParameter(event.getEqtpsz(), ","); 
		param.put("eqtpsz", arr_Eqtpsz);
		param.put("fm_nod",  event.getSearch_fm_loc()+event.getSearch_fm_yard());
		param.put("via_nod", event.getSearch_via_loc()+event.getSearch_via_yard()); 
		param.put("to_nod", event.getSearch_to_loc()+event.getSearch_to_yard()); 
		param.put("dor_nod",  event.getSearch_door_loc()+event.getSearch_door_yard()); 
		param.put("costmode",event.getCostmode());
		param.put("cargo",event.getCargo());
		param.put("eqtype",event.getEqtype());
		param.put("fmAgmtTrspTpCd",event.getFmAgmtTrspTpCd());
		param.put("fmEffectiveAgmt",event.getFmEffectiveAgmt());
		param.put("fmVndrPrmrySeq",event.getFmVndrPrmrySeq());
		param.put("cur_page_cnt", event.getCurPageCnt());				//
		param.put("page_size", event.getPageSize());					//
		param.put("delete_yn", event.getDeleteYn());
		param.put("approval_date", event.getApprovalDate());
				
		if(event.getFmAgmtno().length() > 3){
			int fmAgmtnoLength = event.getFmAgmtno().length();
			param.put("trspAgmtOfcCtyCd",event.getFmAgmtno().substring(0, 3));		// 민정호-추가
			param.put("trspAgmtSeq",event.getFmAgmtno().substring(3, fmAgmtnoLength));				
		}		

		if(event.getEffectiveDate() != null){
			param.put("effectiveDate", event.getEffectiveDate());
		}
		
		try {
			
//			if(event.getFmVndrPrmrySeq() != null){
//				dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementHisDBDAOSearchTrspAgmtRSQL(), param, param);
//				
//				List<String> arr_agmtno = new ArrayList();
////				arr_agmtno = this.seperationParameter(cntrno, ",");
////				arr_agmtno.add(arg0)
////				param.put("arr_cntrno", arr_cntrno);
////				if(dRs.next()){   
//				while( dRs.next() ) {
//					arr_agmtno.add(dRs.getString("TRSP_AGMT_OFC_CTY_CD")+dRs.getInt("TRSP_AGMT_SEQ"));
//					//param.put("arr_agmtno", arr_agmtno);
////					trsp_agmt_ofc_cty_cd = dRs.getString("TRSP_AGMT_OFC_CTY_CD");
////					trsp_agmt_seq = dRs.getInt("TRSP_AGMT_SEQ");
////					param.put("trsp_agmt_ofc_cty_cd", trsp_agmt_ofc_cty_cd);
////					param.put("trsp_agmt_seq", trsp_agmt_seq);					
//				}
//			}
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementHisDBDAOSearchDtlAgmtEffDtRSQL(), param, param);		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}	
	
	/**
	 * Agreement Rate Inquiry Count
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchDtlAgmtTot(EsdTrs0231Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		List<String> arr_Eqtpsz = new ArrayList();
		arr_Eqtpsz = this.seperationParameter(event.getEqtpsz(), ","); 
		param.put("eqtpsz", arr_Eqtpsz);
		param.put("fm_nod",  event.getSearch_fm_loc()+event.getSearch_fm_yard());
		param.put("via_nod", event.getSearch_via_loc()+event.getSearch_via_yard()); 
		param.put("to_nod", event.getSearch_to_loc()+event.getSearch_to_yard()); 
		param.put("dor_nod",  event.getSearch_door_loc()+event.getSearch_door_yard()); 
		param.put("costmode",event.getCostmode());
		param.put("cargo",event.getCargo());
		param.put("eqtype",event.getEqtype());
		param.put("fmAgmtTrspTpCd",event.getFmAgmtTrspTpCd());
		param.put("fmEffectiveAgmt",event.getFmEffectiveAgmt());
		param.put("fmVndrPrmrySeq",event.getFmVndrPrmrySeq());
		param.put("page_size", event.getPageSize());
		param.put("delete_yn", event.getDeleteYn());
		param.put("approval_date", event.getApprovalDate());
		
		if(event.getFmAgmtno().length() > 3){
			int fmAgmtnoLength = event.getFmAgmtno().length();
			param.put("trspAgmtOfcCtyCd",event.getFmAgmtno().substring(0, 3));		// 민정호-추가
			param.put("trspAgmtSeq",event.getFmAgmtno().substring(3, fmAgmtnoLength));				
		}		
				
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementHisDBDAOSearchDtlAgmtTotRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}
		
	/**
	 * Agreement Rate Inquiry Count(Effective date 형식으로)
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchDtlAgmtTotEffDt(EsdTrs0231Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		List<String> arr_Eqtpsz = new ArrayList();
		arr_Eqtpsz = this.seperationParameter(event.getEqtpsz(), ","); 
		param.put("eqtpsz", arr_Eqtpsz);
		param.put("fm_nod",  event.getSearch_fm_loc()+event.getSearch_fm_yard());
		param.put("via_nod", event.getSearch_via_loc()+event.getSearch_via_yard()); 
		param.put("to_nod", event.getSearch_to_loc()+event.getSearch_to_yard()); 
		param.put("dor_nod",  event.getSearch_door_loc()+event.getSearch_door_yard()); 
		param.put("costmode",event.getCostmode());
		param.put("cargo",event.getCargo());
		param.put("eqtype",event.getEqtype());
		param.put("fmAgmtTrspTpCd",event.getFmAgmtTrspTpCd());
		param.put("fmEffectiveAgmt",event.getFmEffectiveAgmt());
		param.put("fmVndrPrmrySeq",event.getFmVndrPrmrySeq());
		param.put("page_size", event.getPageSize());
		param.put("delete_yn", event.getDeleteYn());
		param.put("approval_date", event.getApprovalDate());
		
		if(event.getFmAgmtno().length() > 3){			
			int fmAgmtnoLength = event.getFmAgmtno().length();			
			param.put("trspAgmtOfcCtyCd",event.getFmAgmtno().substring(0, 3));		// 민정호-추가
			param.put("trspAgmtSeq",event.getFmAgmtno().substring(3, fmAgmtnoLength));				
		}
		
		if(event.getEffectiveDate() != null){
			param.put("effectiveDate", event.getEffectiveDate());
		}
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementHisDBDAOSearchDtlAgmtTotEffDtRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}	

//#############################################################################################################끝	
	
	/**
	 * Agreement Rate Inquiry
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchScgDtlAgmt(EsdTrs0235Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String eq_tp_sz = event.getFm_trsp_agmt_eq_tp_sz_cd();
		String eq_knd_cd = event.getFm_eq_knd_cd();
		String eq_tp = "";
		String eq_sz = "";
		param.put("rail_svc_tp_cd", event.getFm_rail_svc_tp_cd());
		param.put("agmt_trsp_tp_cd", event.getFm_agmt_trsp_tp_cd());
		param.put("trsp_agmt_ofc_cty_cd", event.getFm_trsp_agmt_ofc_cty_cd());
		param.put("trsp_agmt_seq", event.getFm_trsp_agmt_seq());
		param.put("trsp_agmt_rt_tp_ser_no", event.getFm_trsp_agmt_rt_tp_ser_no());
		param.put("vndr_seq", event.getFm_vndr_seq());
		param.put("ctrt_ofc_cd", event.getFm_ctrt_ofc_cd());
		param.put("eq_knd_cd", event.getFm_eq_knd_cd());
		param.put("trsp_agmt_eq_tp_sz_cd", event.getFm_trsp_agmt_eq_tp_sz_cd());
		param.put("cgo_tp_cd", event.getFm_cgo_tp_cd());
		param.put("fm_nod_cd", event.getFm_fm_nod_cd());
		param.put("via_nod_cd", event.getFm_via_nod_cd());
		param.put("dor_nod_cd", event.getFm_dor_nod_cd());
		param.put("to_nod_cd", event.getFm_to_nod_cd());
		param.put("trsp_agmt_bdl_qty", event.getFm_trsp_agmt_bdl_qty());
		param.put("wgt_meas_ut_cd", event.getFm_wgt_meas_ut_cd());
		param.put("basic_rt", event.getFm_basic_rt());
		param.put("curr_cd", event.getFm_curr_cd());
		param.put("way", event.getFm_way());

		if (eq_knd_cd.equals("U")) {
			if (eq_tp_sz.length() == 2) {
				eq_tp = eq_tp_sz.substring(0, 1);
				eq_sz = eq_tp_sz.substring(1, 2);
			}else if (eq_tp_sz.length() == 3) {
				if (eq_tp_sz.substring(0,2).equals("AL")) {
					eq_tp = eq_tp_sz.substring(0, 2);
					eq_sz = eq_tp_sz.substring(2, 3);
				}else{
					eq_tp = eq_tp_sz.substring(0, 1);
					eq_sz = eq_tp_sz.substring(1, 3);
				}
			}else if (eq_tp_sz.length() == 4) {
				eq_tp = eq_tp_sz.substring(0, 2);
				eq_sz = eq_tp_sz.substring(2, 4);
			}
		}else if (eq_knd_cd.equals("Z")) {
			if (eq_tp_sz.length() == 3 ) {
				eq_tp = eq_tp_sz.substring(0, 2);
				eq_sz = eq_tp_sz.substring(2, 3);
			}else if (eq_tp_sz.length() == 4 ) {
				eq_tp = eq_tp_sz.substring(0, 2);
				eq_sz = eq_tp_sz.substring(2, 4);
			}
		}else if (eq_knd_cd.equals("G")) {
			if (eq_tp_sz.length() == 2 ) {
				eq_tp = eq_tp_sz;
			}else if (eq_tp_sz.length() == 4 ) {
				eq_tp = eq_tp_sz.substring(0, 2);
				eq_tp = eq_tp_sz.substring(2, 4);
			}
		}
		param.put("eq_tp", eq_tp);
		param.put("eq_sz", eq_sz);
		
		if(event.getEffective_date() != null){
			param.put("effective_date", event.getEffective_date());
		}
				
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementHisDBDAOSearchScgDtlAgmtRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return
	 */
	public ArrayList seperationParameter(String sparameter, String sSeperate) {
		ArrayList arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}
	
	
	/**
	 * Type Size 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchTpSz(EsdTrs0231Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			AgreementHisDBDAOSearchTypeSizeRSQL template = new AgreementHisDBDAOSearchTypeSizeRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

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
	 * Agreement Rate History 삭제 여부 저장<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void saveTrsAgmtEqRtHis(EsdTrs0227Event event) throws DAOException {
		try {
			int insCnt[] = null;
			SQLExecuter sqlExe = new SQLExecuter("");
			TrsAgmtEqRtHisVO[] model = event.getTrsAgmtEqRtHisVOS();
			Map<String,Object> param = new HashMap<String,Object>();
			Collection<TrsAgmtEqRtHisVO> updateVoList = new ArrayList<TrsAgmtEqRtHisVO>();						
			String updUsrId = event.getFm_Account_Usr_Id();
						
			param.put("UPD_USR_ID", updUsrId);
			for ( int i=0; i<model.length; i++ ) {
				if ( model[i].getIbflag().equals("U")){
					updateVoList.add(model[i]);
				}
			}
			
			//2. Office Exception Delete
			if(updateVoList.size() > 0){	
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AgreementHisDBDAOUpdateTrsAgmtEqRtHisUSQL(), updateVoList, param, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		
	
	
	/**
	 * Agreement Surcharge Rate History 화면의 Rate History 삭제 여부 저장<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void saveScgHisAgmt(EsdTrs0230Event event) throws DAOException {
		try {
			int insCnt[] = null;
			SQLExecuter sqlExe = new SQLExecuter("");
			TrsAgmtScgRtHisVO[] model = event.getTrsAgmtScgRtHisVOS();
			Map<String,Object> param = new HashMap<String,Object>();
			Collection<TrsAgmtScgRtHisVO> updateVoList = new ArrayList<TrsAgmtScgRtHisVO>();						
			String updUsrId = event.getFm_Account_Usr_Id();
						
			param.put("UPD_USR_ID", updUsrId);
			for ( int i=0; i<model.length; i++ ) {
				if ( model[i].getIbflag().equals("U")){
					updateVoList.add(model[i]);
				}
			}
			
			//2. Office Exception Delete
			if(updateVoList.size() > 0){	
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AgreementHisDBDAOUpdateTrsAgmtScgRtHisUSQL(), updateVoList, param, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}			
}