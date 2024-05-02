/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAO.java
*@FileTitle : Service Order 생성화면 - Chassis or Genset
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.04
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2006.10.04 조풍연
* 1.0 최초 생성
* ----------------------------------------------------------
* History
* 2011.01.04 최 선         1.1 [CHM-201108174] Report 화면 중 S/P code 선택 시 오류팝업 수정요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.basic.ChassisGensetSOManageBCImpl;
import com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.event.CostcdVO;
import com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.event.EsdTrs0014Event;
import com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.vo.ChassisGensetVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;



/**
 * ESD-TRS에 대한 DB 처리를 담당<br> - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author poong
 * @see ChassisGensetSOManageBCImpl 참조
 * @since J2EE 1.4
 */
public class ChassisGensetSOManageDBDAO extends DBDAOSupport {

	/**
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchVendor(EsdTrs0014Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		String combo_svc_provider		= "";
		String ofc_cd					= "";
		String spot_bid_cnddt_term_seq	= "";
		
		//HashMap hashParam = event.getHashParam();
		
		//combo_svc_provider = (String) hashParam.get("TRSP_SO_VNDR_NO");
		combo_svc_provider		= event.getTrspSoVndrNo();
		ofc_cd 					= event.getFormUsrOfcCd();
		spot_bid_cnddt_term_seq	= event.getSpotBidCnddtTermSeq();
		
		
		if( combo_svc_provider == null|| combo_svc_provider.equals("")){
			combo_svc_provider = event.getComboSvcProvider();
		}

		param.put("VNDR_SEQ", combo_svc_provider);
		param.put("OFC_CD", ofc_cd);
		param.put("SPOT_BID_CNDDT_TERM_SEQ", spot_bid_cnddt_term_seq);
		
		try {
			dRs = new SQLExecuter("").executeQuery(new ChassisGensetSOManageDBDAOSearchVendorRSQL(), param,param);
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
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchVendorChld(EsdTrs0014Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		String combo_svc_provider_chld = null;
		
		HashMap hashParam = event.getHashParam();
		
		combo_svc_provider_chld = (String) hashParam.get("TRSP_SO_VNDR_NO");
		//combo_svc_provider_chld = event.getTrspSoVndrNo();
		
		if( combo_svc_provider_chld == null|| combo_svc_provider_chld.equals("")){
			combo_svc_provider_chld = event.getComboSvcProviderChld();
		}

		param.put("VNDR_SEQ", combo_svc_provider_chld);
		
		try {
			dRs = new SQLExecuter("").executeQuery(new ChassisGensetSOManageDBDAOSearchVendorRSQL(), param,param);
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
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchVendorPrnt(EsdTrs0014Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		String combo_svc_provider_prnt = null;
		
		HashMap hashParam = event.getHashParam();
		
		combo_svc_provider_prnt = (String) hashParam.get("TRSP_SO_VNDR_NO");
		//combo_svc_provider_prnt = event.getTrspSoVndrNo();
		
		if( combo_svc_provider_prnt == null|| combo_svc_provider_prnt.equals("")){
			combo_svc_provider_prnt = event.getComboSvcProviderPrnt();
		}

		param.put("VNDR_SEQ", combo_svc_provider_prnt);
		
		try {
			dRs = new SQLExecuter("").executeQuery(new ChassisGensetSOManageDBDAOSearchVendorRSQL(), param,param);
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
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchVendorList(EsdTrs0014Event event) throws DAOException {
		DBRowSet dRs = null;

		String vndr_cnt_cd = event.getVndrCntCd();
		String vndr_combo_search_bound = event.getVndrComboSearchBound();
		String user_id = null;
		try {
			user_id = event.getSignOnUserAccount().getUsr_id();

			Map<String, Object> param = new HashMap<String, Object>();			
			param.put("user_id", user_id);
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("vndr_combo_search_bound", vndr_combo_search_bound);
			velParam.put("vndr_cnt_cd", vndr_cnt_cd);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			ChassisGensetSOManageDBDAOsearchVendorListRSQL template = new ChassisGensetSOManageDBDAOsearchVendorListRSQL();	        
			dRs = sqlExe.executeQuery(template,param,velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}

	/**
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchChassisCorrectionList(EsdTrs0014Event event) throws DAOException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		DBRowSet dRs = null;

		Map<String, Object> param = new HashMap<String, Object>();
		List<String> eq_no = new ArrayList(); 
		
		String kind_chassis 	= event.getKndChassis();
		String fmdate 			= event.getFmdate();
		String todate 			= event.getTodate();
		String trs_tp_cd 		= event.getTrsTpCd();
		String search_fm_loc 	= event.getSearchFmLoc();
		String search_fm_yard 	= event.getSearchFmYard();
		String search_to_loc    = event.getSearchToLoc();
		String search_to_yard   = event.getSearchToYard();
		String trs_md_cd        = event.getTrsMdCd();
		String strEqNo 			= event.getFormEqNo();

		if(!strEqNo.equals("")){
			String arrEqNo[] 		= event.getFormEqNo().split(",");
			for(int i=0;i<arrEqNo.length;i++){   
				eq_no.add(arrEqNo[i]);   
			} 
		}
		
		param.put("kind_chassis", kind_chassis);
		param.put("fmdate", fmdate);
		param.put("todate", todate);
		param.put("trs_tp_cd", trs_tp_cd);
		param.put("trsp_so_fm_node", search_fm_loc+search_fm_yard);
		param.put("trsp_so_to_node", search_to_loc+search_to_yard);
		param.put("trs_md_cd", trs_md_cd);
		param.put("eq_no", eq_no);
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOSearchChassisCorrectionListRSQL(), param,param);
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
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchGensetCorrectionList(EsdTrs0014Event event) throws DAOException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		DBRowSet dRs = null;

		Map<String, Object> param = new HashMap<String, Object>();
		List<String> eq_no = new ArrayList(); 
		
		String kind_chassis 	= event.getKndChassis();
		String fmdate 			= event.getFmdate();
		String todate 			= event.getTodate();
		String trs_tp_cd 		= event.getTrsTpCd();
		String search_fm_loc 	= event.getSearchFmLoc();
		String search_fm_yard 	= event.getSearchFmYard();
		String search_to_loc    = event.getSearchToLoc();
		String search_to_yard   = event.getSearchToYard();
		String trs_md_cd        = event.getTrsMdCd();
		String strEqNo 			= event.getFormEqNo();

		if(!strEqNo.equals("")){
			String arrEqNo[] 		= event.getFormEqNo().split(",");
			for(int i=0;i<arrEqNo.length;i++){   
				eq_no.add(arrEqNo[i]);   
			} 
		}
		
		param.put("kind_chassis", kind_chassis);
		param.put("fmdate", fmdate);
		param.put("todate", todate);
		param.put("trs_tp_cd", trs_tp_cd);
		param.put("trsp_so_fm_node", search_fm_loc+search_fm_yard);
		param.put("trsp_so_to_node", search_to_loc+search_to_yard);
		param.put("trs_md_cd", trs_md_cd);
		param.put("eq_no", eq_no);
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOSearchGensetCorrectionListRSQL(), param,param);
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
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchImportedChassis(EsdTrs0014Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		List<String> eq_no = new ArrayList();   

		ChassisGensetVO[] chassisGensetVOs = event.getChassisGensetVOs();

		try {
			if(chassisGensetVOs.length > 0  || chassisGensetVOs != null){
				for(int i=0;i<chassisGensetVOs.length;i++){
					eq_no.add(chassisGensetVOs[i].getEqNo());
				}
			}
			param.put("eq_no", eq_no);
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOSearchImportedChassisRSQL(), param,param);
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
	 * ChassisGensetSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchImportedGenset(EsdTrs0014Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		List<String> eq_no = new ArrayList();   

		ChassisGensetVO[] chassisGensetVOs = event.getChassisGensetVOs();

		try {
			if(chassisGensetVOs.length > 0 ){
				for(int i=0;i<chassisGensetVOs.length;i++){
					eq_no.add(chassisGensetVOs[i].getEqNo());
				}
			}
			param.put("eq_no", eq_no);

			dRs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOSearchImportedGensetRSQL(), param,param);
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
	 * ChassisGensetSOManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet verifyEqNo(EsdTrs0014Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		List<String> eq_no = new ArrayList();   

		ChassisGensetVO[] chassisGensetVOs = event.getChassisGensetVOs();
				
		try {
			if(chassisGensetVOs.length > 0 ){
				for(int i=0;i<chassisGensetVOs.length;i++){
					eq_no.add(chassisGensetVOs[i].getEqNo());
				}
			}
			param.put("eq_no", eq_no);
			
	       if(event.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				dRs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOVerifyEqNoChassisRSQL(), param,param);
			}else{
				dRs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOVerifyEqNoMgSetRSQL(), param,param);
			}	
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
	 * ChassisGensetSOManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet verifyChassisGensetSOManage(EsdTrs0014Event event) throws DAOException {
		
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		List<String> eq_no_fm_loc = new ArrayList();   
		
		ChassisGensetVO[] model = event.getChassisGensetVOs();
		
		for(int i=0;i<model.length;i++){   
			eq_no_fm_loc.add(model[i].getEqNo()+model[i].getFmLocValue()+model[i].getFmYardValue());
		}   
		
		param.put("eq_no_fm_loc", eq_no_fm_loc);

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOVerifyChassisGensetSOManageRSQL(), param,param);
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
	 * ChassisGensetSOManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchChassisGensetSOManageList(EsdTrs0014Event event) throws DAOException {
		
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			param.put("fmdate", event.getFmdate());
			param.put("todate", event.getTodate());
			param.put("hire_loc",event.getHireLoc());
			param.put("hire_yd", event.getHireYd());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOSearchChassisGensetSOManageListRSQL(), param,param);

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
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchChassisSOManage(EsdTrs0014Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("eq_no", event.getEqNo());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOSearchChassisSOManageRSQL(), param,param);
			
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
	 * ChassisGensetSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchGensetSOManage(EsdTrs0014Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("eq_no", event.getEqNo());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOSearchGensetSOManageRSQL(), param,param);
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
	 * ChassisGensetSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param svcOrdV
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchTrspSvcOrdList(ArrayList svcOrdV) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		List<String> so_no = new ArrayList();  

		try {

			for (int i=0; i<svcOrdV.size(); i++){
				if( svcOrdV.get(i) != null){
					so_no.add((String) svcOrdV.get(i));
				}
			}
			param.put("so_no", so_no);
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOSearchTrspSvcOrdListRSQL(), param,param);

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
	 * ChassisGensetSOManage의 데이타 모델을 DB에 저장한다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public ArrayList addTRS_TRSP_SVC_ORD(EsdTrs0014Event event) throws DAOException {

		Map<String, Object> cmb_seq = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		
		ChassisGensetVO[] chassisGensetVOs = event.getChassisGensetVOs();
		CostcdVO costCdVO = new CostcdVO();
		ArrayList returnV = new ArrayList();
		DBRowSet dRs = null;  
		DBRowSet rs = null;


		String cost_mode = null;

		try {
			HashMap seqMap = new HashMap();
			for(int i=0;i<chassisGensetVOs.length;i++){
				String bundleSeq = "";
				String svcOrdSeq = "";
	
				String fmNode = null;
				String toNode = null;
				
				cost_mode = event.getKndChassis()+event.getKindHire();
				String lgs_cost_cd = null;
	
				if (chassisGensetVOs[i].getTrspSoCmbSeq() != null && !chassisGensetVOs[i].getTrspSoCmbSeq().equals("")) {
						bundleSeq = (String) seqMap.get(chassisGensetVOs[i].getTrspSoCmbSeq());
						if (bundleSeq == null || bundleSeq.equals("")) {
							rs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOAddTrsSvcCombineSeqRSQL(), cmb_seq,cmb_seq);
							rs.next();
							bundleSeq = rs.getString("bdl_seq");
							seqMap.put(chassisGensetVOs[i].getTrspSoCmbSeq(), bundleSeq);
						}
					} else {
						bundleSeq = "";
				}
	
				if (chassisGensetVOs[i].getIbflag().length() > 0) {
					dRs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOAddTrsSvcSeqRSQL(), cmb_seq,cmb_seq);
					dRs.next();
					svcOrdSeq = dRs.getString("svc_ord_seq");
	
					returnV.add(event.getFormUsrOfcCd().substring(0,3)+svcOrdSeq);
											
					fmNode = chassisGensetVOs[i].getFmLocValue() + chassisGensetVOs[i].getFmYardValue();
					toNode = chassisGensetVOs[i].getToLocValue() + chassisGensetVOs[i].getToYardValue();
					lgs_cost_cd = costCdVO.getCostCd(cost_mode, chassisGensetVOs[i].getTrspCrrModCd());
					//임시로 하드코딩-추후 삭제
					if(cost_mode.equals("ZD")){
						cost_mode="HD";
					}else if(cost_mode.equals("ZF")){
						cost_mode="HF";
					}else if(cost_mode.equals("ZN")){
						cost_mode="HN";
					}
					//----------------------
					param.put("trsp_cost_dtl_mod_cd", cost_mode); // Eq_no
					param.put("eq_no", chassisGensetVOs[i].getEqNo()); // Eq_no
					param.put("eq_tpsz_cd", chassisGensetVOs[i].getEqTpszCd()); // Eq_tpsz_cd
					param.put("fm_nod_cd", fmNode); // fmNode
					param.put("to_nod_cd", toNode); // toNode
					param.put("trsp_crr_mod_cd", chassisGensetVOs[i].getTrspCrrModCd()); // Trsp_crr_mod_cd
					param.put("inter_rmk", chassisGensetVOs[i].getInterRmk()); // Inter_rmk
					param.put("spcl_instr_rmk", chassisGensetVOs[i].getSpclInstrRmk()); // Spcl_instr_rmk
					param.put("trsp_so_ofc_cty_cd", event.getFormUsrOfcCd().substring(0,3));// model.getTrsp_so_ofc_cty_cd()); //Trsp_so_ofc_cty_cd
					param.put("trsp_so_seq", svcOrdSeq);// model.getTrsp_so_ofc_cty_cd()); //Trsp_so_ofc_cty_cd
					param.put("trsp_so_tp_cd", event.getSoTpCd()); // TRSP_SO_CD
					param.put("trsp_so_sts_cd", event.getSoStsCd()); // TRSP_SO_STS_CD
					param.put("kind_chassis", event.getKndChassis()); // eq_tp_cd
					param.put("bundleseq", bundleSeq); // bundleSeq
					param.put("trsp_so_cmb_tp_cd", chassisGensetVOs[i].getTrspSoCmbTpCd());// TRSP_SO_CMB_TP_CD - BS, BF
					param.put("kind_hire", event.getKindHire()); // kind_hire
						
					param.put("cntr_no", chassisGensetVOs[i].getCntrNo());// CNTR_NO
					param.put("cntr_tpsz_cd", chassisGensetVOs[i].getCntrTpszCd());// CNTR_NO
					param.put("ref_bkg_no", chassisGensetVOs[i].getRefBkgNo());// CNTR_NO
					param.put("ref_bl_no", chassisGensetVOs[i].getRefBlNo());// CNTR_NO
					param.put("org_gate_out_dt", chassisGensetVOs[i].getOrgGateOutDate());// CNTR_NO
					param.put("dest_gate_in_dt", chassisGensetVOs[i].getDestGateInTime());// CNTR_NO
						
					param.put("lgs_cost_cd", lgs_cost_cd); // ACCT_CD
					param.put("lgs_cost_cd", lgs_cost_cd); // ACCT_CD
					
					param.put("ttl_dist", chassisGensetVOs[i].getTtlDist()); // ttl_dist
					param.put("lnk_dist_div_cd", chassisGensetVOs[i].getLnkDistDivCd()); // lnk_dist_div_cd
					
					param.put("cre_ofc_cd", event.getFormUsrOfcCd()); // Cre_ofc_cd
					param.put("cre_usr_id", event.getFormUsrId()); // Cre_ofc_cd
					param.put("upd_usr_id", event.getFormUsrId()); // Cre_usr_id
					param.put("FORM_USR_OFC_CD", event.getFormUsrOfcCd()); // Cre_usr_id]
					
	
					new SQLExecuter("DEFAULT").executeUpdate(new ChassisGensetSOManageDBDAOAddTrsSvcOrdCSQL(), param,param);
				}
		 }
	}catch (SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	return returnV;
}

	/**
	 * ChassisGensetSOManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void removeChassisGensetList(EsdTrs0014Event event) throws DAOException {
//		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		List<String> soOfc = new ArrayList();
		List<String> soSeq = new ArrayList();
		
		String formUsrId = event.getFormUsrId();
		String formUsrOfcCd = event.getFormUsrOfcCd();
		
		ChassisGensetVO[] model = event.getChassisGensetVOs();
		
		for(int i=0;i<model.length;i++){   
			soOfc.add(model[i].getTrspSoOfcCtyCd());
			soSeq.add(model[i].getTrspSoSeq());
		} 
		
		try {
			if(soOfc.size()>0){
				for(int i=0;i<soOfc.size();i++){
					param.put("formUsrId", formUsrId);
					param.put("formUsrOfcCd", formUsrOfcCd);
					param.put("SoOfc", soOfc.get(i));
					param.put("SoSeq", soSeq.get(i));
					
			   new SQLExecuter("DEFAULT").executeUpdate(new ChassisGensetSOManageDBDAORemoveChassisGensetListUSQL(), param,param);
				}
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * ChassisGensetSOManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void modifyChassisGensetSOManage(EsdTrs0014Event event) throws DAOException {
		DBRowSet dRs = null;
		DBRowSet rs = null;
		
		boolean isUpdate = false;
		boolean isUpdate2 = false;
		
		Map<String, Object> cmb_seq = new HashMap<String, Object>();
		Map<String, Object> init_cmb_seq = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		
		ChassisGensetVO[] chassisGensetVOs = event.getChassisGensetVOs();
		
		String formUsrId = event.getFormUsrId();
		String formUsrOfcCd = event.getFormUsrOfcCd();

		HashMap seqMap = new HashMap();
		
		try {
			String bundleSeq = null;
			String trsp_so_cmb_seq = null;
			String trsp_so_ofc_cty_cd = "";
			String trsp_so_seq = "";
			
			for(int i=0;i<chassisGensetVOs.length;i++){

				trsp_so_ofc_cty_cd = chassisGensetVOs[i].getTrspSoOfcCtyCd(); 
				trsp_so_seq = chassisGensetVOs[i].getTrspSoSeq();
				cmb_seq.put("trsp_so_ofc_cty_cd", trsp_so_ofc_cty_cd);
				cmb_seq.put("trsp_so_seq", trsp_so_seq);
				
				dRs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOModifyChassisGensetSOManageRSQL(), cmb_seq,cmb_seq);
				dRs.next();
				trsp_so_cmb_seq = dRs.getString("trsp_so_cmb_seq");


				if(trsp_so_cmb_seq != null && !trsp_so_cmb_seq.trim().equals("")){
					isUpdate2 = true;
					init_cmb_seq.put("upd_usr_id",formUsrId);
					init_cmb_seq.put("FORM_USR_OFC_CD",formUsrOfcCd);
					init_cmb_seq.put("trsp_so_ofc_cty_cd",trsp_so_ofc_cty_cd);
					init_cmb_seq.put("trsp_so_seq",trsp_so_seq);
					init_cmb_seq.put("trsp_so_cmb_seq",trsp_so_cmb_seq);
				}//end if
				if (chassisGensetVOs[i].getTrspSoCmbSeq() != null && !chassisGensetVOs[i].getTrspSoCmbSeq().equals("")) {
					bundleSeq = (String) seqMap.get(chassisGensetVOs[i].getTrspSoCmbSeq());

					if (bundleSeq == null || bundleSeq.equals("")) {
						rs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOAddTrsSvcCombineSeqRSQL(), cmb_seq,cmb_seq);
						rs.next();
						bundleSeq = rs.getString("bdl_seq");
						seqMap.put(chassisGensetVOs[i].getTrspSoCmbSeq(), bundleSeq);

					}// end if
				} else {
					bundleSeq = "";
				}//end if

				if (chassisGensetVOs[i].getIbflag().length() > 0) {
					isUpdate = true;
					param.put("eq_no", chassisGensetVOs[i].getEqNo());
					param.put("trsp_so_cmb_seq", bundleSeq);
					param.put("fm_nod_cd", chassisGensetVOs[i].getFmLocValue()+ chassisGensetVOs[i].getFmYardValue());
					param.put("to_nod_cd", chassisGensetVOs[i].getToLocValue()+ chassisGensetVOs[i].getToYardValue()); 
					param.put("inter_rmk", chassisGensetVOs[i].getInterRmk()); 
					param.put("spcl_instr_rmk", chassisGensetVOs[i].getSpclInstrRmk());
					param.put("trsp_so_cmb_tp_cd", chassisGensetVOs[i].getTrspSoCmbTpCd());
					param.put("cntr_no", chassisGensetVOs[i].getCntrNo());
					param.put("cntr_tpsz_cd", chassisGensetVOs[i].getCntrTpszCd());
					param.put("ref_bkg_no", chassisGensetVOs[i].getRefBkgNo());
					param.put("ref_bl_no", chassisGensetVOs[i].getRefBlNo());
					param.put("org_gate_out_dt", chassisGensetVOs[i].getOrgGateOutDate());
					param.put("dest_gate_in_dt", chassisGensetVOs[i].getDestGateInDate());
					param.put("upd_usr_id", formUsrId);
					param.put("usr_ofc_cd", formUsrOfcCd);
					param.put("trsp_so_ofc_cty_cd", chassisGensetVOs[i].getTrspSoOfcCtyCd());
					param.put("trsp_so_seq", chassisGensetVOs[i].getTrspSoSeq());
					param.put("ttl_dist", chassisGensetVOs[i].getTtlDist());
					param.put("lnk_dist_div_cd", chassisGensetVOs[i].getLnkDistDivCd());
				}//end if
				if (isUpdate){
					new SQLExecuter("DEFAULT").executeUpdate(new ChassisGensetSOManageDBDAOModifyChassisGensetSOManageUSQL(), param,param);
				}//end if
				if (isUpdate2){
					 new SQLExecuter("DEFAULT").executeUpdate(new ChassisGensetSOManageDBDAOModifyChassisGensetSOManageCmbUSQL(), init_cmb_seq,init_cmb_seq);
				}//end if
			}//end for
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * ChassisGensetSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchContainerTpSzCdList(EsdTrs0014Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("EQ_TPSZ_CD", event.getEqTpszCd());
		try {
			dRs = new SQLExecuter("").executeQuery(new ChassisGensetSOManageDBDAOSearchContainerTpSzCdListRSQL(), param,param);
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
	 * ChassisGensetSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchChassisTpSzCdList(EsdTrs0014Event event) throws DAOException {
		DBRowSet dRs = null;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			String eq_tpsz_cd = event.getEqTpszCd();

			param.put("eq_tpsz_cd", eq_tpsz_cd);
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOsearchChassisTpSzCdListRSQL(), param,param);
	
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
	 * ChassisGensetSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchGensetTpSzCdList(EsdTrs0014Event event) throws DAOException {
		DBRowSet dRs = null;
		try {
			
			Map<String, Object> param = new HashMap<String, Object>();
			String eq_tpsz_cd = event.getEqTpszCd();

			param.put("eq_tpsz_cd", eq_tpsz_cd);			
			 
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ChassisGensetSOManageDBDAOSearchGensetTpSzCdListRSQL(), param,param);
	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}
	
}