/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementCorrectionDBDAO.java
*@FileTitle : TRS Agreement Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.28
*@LastModifier : 최종혁
*@LastVersion : 1.1
* 2014.05.28 최종혁
* 1.0 최초 생성
-----------------------------------------------------------
* History
* 2010.10.05 최 선     1.1 [CHM-201006313] From, Via, Door, To POP UP 조회 추가
* 2011.09.21 최종혁   1.11 [CHM-201113360] [TRS] AGMT delete function 변경 + Feeder term Rule 인식 변경 요청
* 2014.05.28 최종혁 [CHM-201430241] AGMT Confirm 기능 추가
* 2014.10.29 최종혁 [CHM-201432544] Link 조회 기능 추가
* 2015.06.16 9014787 [CHM-201535825] Surcharge confirm 대상 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0224Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0226Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0229Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.SearchApprovalMgmtVO;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.SearchCorrSumAgmtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TrsAgmtRtTpVO;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * @author jong hyek choi
 * @see DBDAOSupport
 * @since J2EE 1.6
 */
public class AgreementCorrectionDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * Agreement Rate정보 조회
	 * 
	 * @param event EsdTrs0224Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCorrSumAgmt(EsdTrs0224Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		List<String> arr_ctrt_office = new ArrayList<String>();
		String ctrt_office = event.getFm_ctrt_ofc_cd();
		arr_ctrt_office = this.seperationParameter(ctrt_office, ","); 
		param.put("arr_ctrt_office", arr_ctrt_office);
		
		param.put("fm_agmtno", event.getFm_agmtno());
		param.put("fm_vndr_prmry_seq", event.getFm_vndr_prmry_seq());
		//param.put("fm_ctrt_ofc_cd", event.getFm_ctrt_ofc_cd());
		param.put("fm_trsp_agmt_rt_tp_cd", event.getFm_trsp_agmt_rt_tp_cd());
		param.put("fm_effective_agmt", event.getFm_effective_agmt());
		param.put("fm_hjscnt", event.getFm_hjscnt());
		param.put("fm_cust_cd", event.getFm_cust_cd());
		param.put("fm_trsp_cost_mod_cd", event.getFm_trsp_cost_mod_cd());
		param.put("fm_agmt_trsp_tp_cd", event.getFm_agmt_trsp_tp_cd());
		param.put("fm_cgo_tp_cd", event.getFm_cgo_tp_cd());
		param.put("fm_rail_svc_tp_cd", event.getFm_rail_svc_tp_cd());
		param.put("fm_cmdt_grp_cd", event.getFm_cmdt_grp_cd());
		param.put("fm_trsp_scg_cd", event.getFm_trsp_scg_cd());
		param.put("fm_cfm_flg", event.getFmCfmFlg());
		param.put("fm_link_flg", event.getFmLinkFlg());
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementCorrectionDBDAOSearchCorrSumAgmtRSQL(), param,param);
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
	 * Agreement Rate정보 삭제 처리
	 * 
	 * @param event EsdTrs0224Event
	 * @throws DAOException
	 */
	public void deleteCorrSumAgmt(EsdTrs0224Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		SearchCorrSumAgmtVO[] searchCorrSumAgmtVO = event.getSearchCorrSumAgmtVOs();
		List<SearchCorrSumAgmtVO> mVoList = new ArrayList<SearchCorrSumAgmtVO>();
//		DBRowSet dRs = null;
//		DBRowSet dRs_Scg = null;
//		SQLExecuter sqlExe = new SQLExecuter("");
//		int insCnt[] = null;
		try{
			param.put("fm_account_ofc_cd", 	event.getFm_account_ofc_cd());
			param.put("fm_account_usr_id", 	event.getFm_account_usr_id());
			
			for ( int i=0; i<searchCorrSumAgmtVO.length; i++ ) {
				mVoList.add(searchCorrSumAgmtVO[i]);
			}
			
			if (mVoList.size()>0) {
				param.put("x_trsp_agmt_ofc_cty_cd", 	mVoList.get(0).getTrspAgmtOfcCtyCd());
				param.put("x_trsp_agmt_seq", 	mVoList.get(0).getTrspAgmtSeq());
				param.put("x_trsp_agmt_rt_tp_ser_no", 	mVoList.get(0).getTrspAgmtRtTpSerNo());

				//History 테이블의 최종 Sequence 자료에 Delete flag를 update 한다.
				new SQLExecuter("DEFAULT").executeUpdate(new AgreementCorrectionDBDAODeleteCorrSumAgmtTargetUSQL(), param, param);

				//Surcharge History 테이블의 최종 Sequence 자료에 Delete flag를 update 한다.
				new SQLExecuter("DEFAULT").executeUpdate(new AgreementCorrectionDBDAODeleteCorrSumAgmtScgTargetUSQL(), param, param);
				
				//Current 테이블의 Delete flag를 update 한다.
				new SQLExecuter("DEFAULT").executeUpdate(new AgreementCorrectionDBDAODeleteCorrSumAgmtUSQL(), param, param);

				//Surcharge Current 테이블의 Delete flag를 update 한다.
				new SQLExecuter("DEFAULT").executeUpdate(new AgreementCorrectionDBDAODeleteCorrSumAgmtScgUSQL(), param, param);

				
//				//Rate History에 남길 대상 조회
//				dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementCorrectionDBDAODeleteCorrSumAgmtTargetRSQL(), param,param);
//				for(int k=0;dRs.next();k++) {
//					param.put("trsp_agmt_ofc_cty_cd", dRs.getString("TRSP_AGMT_OFC_CTY_CD"));
//					param.put("trsp_agmt_seq", dRs.getString("TRSP_AGMT_SEQ"));
//					param.put("trsp_agmt_rt_tp_ser_no", dRs.getString("TRSP_AGMT_RT_TP_SER_NO"));
//					param.put("trsp_agmt_nod_seq", dRs.getString("TRSP_AGMT_NOD_SEQ"));
//					param.put("trsp_agmt_rt_seq", dRs.getString("TRSP_AGMT_RT_SEQ"));
//					param.put("trsp_agmt_eq_tp_sz_cd", dRs.getString("TRSP_AGMT_EQ_TP_SZ_CD"));
//					param.put("eff_fm_dt", dRs.getString("EFF_FM_DT"));
//					param.put("eff_to_dt", dRs.getString("EFF_TO_DT"));
//					param.put("curr_cd", dRs.getString("CURR_CD"));
//					param.put("trsp_one_wy_rt", dRs.getString("TRSP_ONE_WY_RT"));
//					param.put("trsp_rnd_rt", dRs.getString("TRSP_RND_RT"));
//					param.put("wtr_rcv_term_cd", dRs.getString("WTR_RCV_TERM_CD"));
//					param.put("wtr_de_term_cd", dRs.getString("WTR_DE_TERM_CD"));
//					param.put("trsp_agmt_bdl_qty", dRs.getString("TRSP_AGMT_BDL_QTY"));
//					param.put("to_wgt", dRs.getString("TO_WGT"));
//					param.put("wgt_meas_ut_cd", dRs.getString("WGT_MEAS_UT_CD"));
//					param.put("trsp_rvs_aply_flg", dRs.getString("TRSP_RVS_APLY_FLG"));
//					param.put("eq_knd_cd", dRs.getString("EQ_KND_CD"));
//
//					//데이타를 삭제하기 전에 History 테이블에 기록한다.
//					new SQLExecuter("DEFAULT").executeUpdate(new AgreementCorrectionDBDAODeleteCorrSumAgmtTargetCSQL(), param, param);
//				}
//
//				
//				//Surcharge Rate History에 남길 대상 조회
//				dRs_Scg = new SQLExecuter("DEFAULT").executeQuery(new AgreementCorrectionDBDAODeleteCorrSumAgmtScgTargetRSQL(), param,param);
//				for(int k=0;dRs_Scg.next();k++) {
//					param.put("trsp_agmt_ofc_cty_cd", dRs_Scg.getString("TRSP_AGMT_OFC_CTY_CD"));
//					param.put("trsp_agmt_seq", dRs_Scg.getString("TRSP_AGMT_SEQ"));
//					param.put("trsp_agmt_rt_tp_ser_no", dRs_Scg.getString("TRSP_AGMT_RT_TP_SER_NO"));
//					param.put("trsp_agmt_scg_nod_seq", dRs_Scg.getString("TRSP_AGMT_SCG_NOD_SEQ"));
//					param.put("trsp_agmt_scg_rt_seq", dRs_Scg.getString("TRSP_AGMT_SCG_RT_SEQ"));
//					param.put("trsp_agmt_eq_tp_sz_cd", dRs_Scg.getString("TRSP_AGMT_EQ_TP_SZ_CD"));
//					param.put("eff_fm_dt", dRs_Scg.getString("EFF_FM_DT"));
//					param.put("eff_to_dt", dRs_Scg.getString("EFF_TO_DT"));
//					param.put("to_wgt", dRs_Scg.getString("TO_WGT"));
//					param.put("wgt_meas_ut_cd", dRs_Scg.getString("WGT_MEAS_UT_CD"));
//					param.put("curr_cd", dRs_Scg.getString("CURR_CD"));
//					param.put("trsp_one_wy_rt", dRs_Scg.getString("TRSP_ONE_WY_RT"));
//					param.put("trsp_rnd_rt", dRs_Scg.getString("TRSP_RND_RT"));
//					param.put("eq_knd_cd", dRs_Scg.getString("EQ_KND_CD"));
//
//					//Surcharge 데이타를 삭제하기 전에 History 테이블에 기록한다.
//					new SQLExecuter("DEFAULT").executeUpdate(new AgreementCorrectionDBDAODeleteCorrSumAgmtScgTargetCSQL(), param, param);
//				}
//
//				
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new AgreementCorrectionDBDAODeleteCorrSumAgmtDSQL(), mVoList, param, param);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to TRS Agreement Rate Delete"+ i + " SQL");
//				}
//				
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new AgreementCorrectionDBDAODeleteCorrSumAgmtScgDSQL(), mVoList, param, param);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to TRS Agreement Surcharge Rate Delete"+ i + " SQL");
//				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}
	
	/**
	 * Agreement Rate정보 조회
	 * 
	 * @param event EsdTrs0226Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCorrRateAgmt(EsdTrs0226Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fm_agmtno", event.getFm_agmtno());
		param.put("cur_page_cnt", event.getCur_page_cnt());
		param.put("page_size", event.getPage_size());
		param.put("fm_trsp_agmt_rt_tp_ser_no", event.getFm_trsp_agmt_rt_tp_ser_no());

		param.put("fm_fm_nod",  event.getSearchFmLoc()+event.getSearchFmYard());
		param.put("fm_via_nod", event.getSearchViaLoc()+event.getSearchViaYard()); 
		param.put("fm_to_nod",  event.getSearchToLoc()+event.getSearchToYard()); 
		param.put("fm_dor_nod", event.getSearchDoorLoc()+event.getSearchDoorYard()); 
		param.put("fm_trsp_agmt_dist", event.getFm_trsp_agmt_dist());
		param.put("fm_eq_knd_cd", event.getFm_eq_knd_cd());
		param.put("grid_flg", event.getGrid_flg());
		param.put("fm_effective_agmt", event.getFmEffectiveAgmt());
		param.put("fm_cfm_flg", event.getFmCfmFlg());
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementCorrectionDBDAOSearchCorrRateAgmtRSQL(), param,param);
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
	 * Agreement Rate총계 정보 조회
	 * 
	 * @param event EsdTrs0226Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCorrRateAgmtTot(EsdTrs0226Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fm_agmtno", event.getFm_agmtno());
		param.put("page_size", event.getPage_size());
		param.put("fm_trsp_agmt_rt_tp_ser_no", event.getFm_trsp_agmt_rt_tp_ser_no());
		
		param.put("fm_fm_nod",  event.getSearchFmLoc()+event.getSearchFmYard()); 
		param.put("fm_via_nod", event.getSearchViaLoc()+event.getSearchViaYard()); 
		param.put("fm_to_nod",  event.getSearchToLoc()+event.getSearchToYard()); 
		param.put("fm_dor_nod", event.getSearchDoorLoc()+event.getSearchDoorYard()); 
		param.put("fm_trsp_agmt_dist", event.getFm_trsp_agmt_dist());
		param.put("fm_eq_knd_cd", event.getFm_eq_knd_cd());
		param.put("grid_flg", event.getGrid_flg());
		param.put("fm_effective_agmt", event.getFmEffectiveAgmt());
		param.put("fm_cfm_flg", event.getFmCfmFlg());
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementCorrectionDBDAOSearchCorrRateAgmtTotRSQL(), param,param);
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
	 * Agreement Surcharge Rate정보 조회
	 * 
	 * @param event EsdTrs0229Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCorrScgAgmt(EsdTrs0229Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fm_agmtno", event.getFm_agmtno());
		param.put("fm_trsp_agmt_rt_tp_ser_no", event.getFm_trsp_agmt_rt_tp_ser_no());
		param.put("fm_eq_knd_cd", event.getFm_eq_knd_cd());
		param.put("cur_page_cnt", event.getCur_page_cnt());
		param.put("page_size", event.getPage_size());
		param.put("grid_flg", event.getGrid_flg());
		param.put("fm_effective_agmt", event.getFmEffectiveAgmt());
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementCorrectionDBDAOSearchCorrScgAgmtRSQL(), param,param);
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
	 * Agreement Surcharge Rate정보 조회
	 * 
	 * @param event EsdTrs0229Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCorrScgAgmtTot(EsdTrs0229Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fm_agmtno", event.getFm_agmtno());
		param.put("fm_trsp_agmt_rt_tp_ser_no", event.getFm_trsp_agmt_rt_tp_ser_no());
		param.put("fm_eq_knd_cd", event.getFm_eq_knd_cd());
		param.put("page_size", event.getPage_size());
		param.put("grid_flg", event.getGrid_flg());
		param.put("fm_effective_agmt", event.getFmEffectiveAgmt());
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementCorrectionDBDAOSearchCorrScgAgmtTotRSQL(), param,param);
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
	 * Agreement Summary 화면의 Agreement Confirm
	 * 
	 * @param event EsdTrs0224Event
	 * @param account SignOnUserAccount
	 * @throws DAOException
	 */
	public void confirmAgmt(EsdTrs0224Event event, SignOnUserAccount account) throws DAOException {
		try {
			SearchCorrSumAgmtVO[] VOs = event.getSearchCorrSumAgmtVOs();
			List<SearchCorrSumAgmtVO> Volist = new ArrayList<SearchCorrSumAgmtVO>();
			
			int insCnt[] = null;
			int insScgCnt[] = null;		//CHM-201535825 Surcharge confirm 대상 추가
			int iAuthCnt = 0;
			for(int i = 0; i < VOs.length; i++){
				VOs[i].setUpdUsrId(account.getUsr_id());
				VOs[i].setCreOfcCd(account.getOfc_cd());

				if (VOs[i].getIbflag().equals("U")){
					String  sCtrtOfcCd = VOs[i].getCtrtOfcCd();
					//Confirm 권한이 있는 오피스가 존재하는 체크 시작
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("cfm_usr_id", account.getUsr_id());
					DBRowSet dRs1 = new SQLExecuter("DEFAULT").executeQuery(new AgreementCorrectionDBDAOCfmAgmtAuthUserRSQL(), param,param);			

					for(int m=0; dRs1.next(); m++) {
						String sCfmOfcCd1 = dRs1.getString("CFM_OFC_CD");
						param.put("login_ofc_cd", sCfmOfcCd1);
						DBRowSet dRs2 = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOSearchAuthChkRSQL(), param,param);
						
						for(int n=0; dRs2.next(); n++) {
							String sCfmOfcCd2 = dRs2.getString("OFC_CD");
							if (sCtrtOfcCd.equals(sCfmOfcCd2)) {
								iAuthCnt++;
							}
						}
					}
					
					if (iAuthCnt == 0) {
						String err_msg = "Confirm Authority is needed for selected AGMT to confirm.";
						throw new DAOException((new ErrorHandler("TRS00099",new String[]{err_msg})).getMessage());
					}
					//Confirm 권한이 있는 오피스가 존재하는 체크 종료
					
					Volist.add(VOs[i]);
				}
			}
			
			//Confirm에 대한 history 기록 (속도에 영향이 있을 경우 제외해도 무방함.)
			// 속도 영향으로 주석처리함.CHM-201433506 Confirmation 관리 History 상 제거 요청 2015.01.08 by SHINS
//			if(Volist.size() > 0){	
//				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new AgreementCorrectionDBDAOCfmAgmtHisUSQL(), Volist, null);
//				for(int j = 0; j < insCnt.length; j++){
//					if(insCnt[j]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ j + " SQL (History)");
//				}
//			}

			if(Volist.size() > 0){	
				insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new AgreementCorrectionDBDAOCfmAgmtUSQL(), Volist, null);
				for(int j = 0; j < insCnt.length; j++){
					if(insCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ j + " SQL");
				}
				
				//CHM-201535825 Surcharge confirm 대상 추가
				insScgCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new AgreementCorrectionDBDAOCfmAgmtScgUSQL(), Volist, null);
				for(int j = 0; j < insScgCnt.length; j++){
					if(insScgCnt[j]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ j + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}
	
	/**
	 * Agreement Summary 화면의 Agreement Confirm Button 활성화
	 * 
	 * @param event EsdTrs0224Event
	 * @param account SignOnUserAccount
	 * @return String
	 * @throws DAOException
	 */
	public String confirmAgmtBtn(EsdTrs0224Event event, SignOnUserAccount account) throws DAOException {
			DBRowSet dbRowset = null;
			String btnConfirm = "F";
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("cfm_usr_id", account.getUsr_id());
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new AgreementCorrectionDBDAOConfirmAgmtBtnRSQL(), param, velParam);
				if (dbRowset.next()) {
					if(dbRowset.getInt("CNT") > 0 ){
						btnConfirm = "T";
					}else{
						btnConfirm = "F";
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ee) {
				log.error(ee.getMessage(), ee);
				throw new DAOException(ee.getMessage());
			}
			return btnConfirm;
	}
	
	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return ArrayList<String>
	 */
	public ArrayList<String> seperationParameter(String sparameter, String sSeperate) {
		ArrayList<String> arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList<String>();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}	
}
