/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementCorrectionDBDAO.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.05
*@LastModifier : 최종혁
*@LastVersion : 1.1
* 2010.03.26 최종혁
* 1.0 최초 생성
-----------------------------------------------------------
* History
* 2010.10.05 최 선     1.1 [CHM-201006313] From, Via, Door, To POP UP 조회 추가
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0224Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0226Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0229Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0238Event;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.AgmtAttachFileListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TrsAgmtRtTpVO;

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
	 * @param event
	 * @return
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
	 * @param event
	 * @throws DAOException
	 */
	public void deleteCorrSumAgmt(EsdTrs0224Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		TrsAgmtRtTpVO[] trsAgmtRtTpVOS = event.getTrsAgmtRtTpVOs();
		List<TrsAgmtRtTpVO> mVoList = new ArrayList<TrsAgmtRtTpVO>();
		DBRowSet dRs = null;
		DBRowSet dRs_Scg = null;
		SQLExecuter sqlExe = new SQLExecuter("");
		int insCnt[] = null;
		try{
			param.put("fm_account_ofc_cd", 	event.getFm_account_ofc_cd());
			param.put("fm_account_usr_id", 	event.getFm_account_usr_id());
			
			for ( int i=0; i<trsAgmtRtTpVOS.length; i++ ) {
				mVoList.add(trsAgmtRtTpVOS[i]);
			}
			
			if (mVoList.size()>0) {
				param.put("x_trsp_agmt_ofc_cty_cd", 	mVoList.get(0).getTrspAgmtOfcCtyCd());
				param.put("x_trsp_agmt_seq", 	mVoList.get(0).getTrspAgmtSeq());
				param.put("x_trsp_agmt_rt_tp_ser_no", 	mVoList.get(0).getTrspAgmtRtTpSerNo());

				//Rate History에 남길 대상 조회
				dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementCorrectionDBDAODeleteCorrSumAgmtTargetRSQL(), param,param);
				//for(int k=0;dRs.next();k++) {
				while(dRs.next()) {
					param.put("trsp_agmt_ofc_cty_cd", dRs.getString("TRSP_AGMT_OFC_CTY_CD"));
					param.put("trsp_agmt_seq", dRs.getString("TRSP_AGMT_SEQ"));
					param.put("trsp_agmt_rt_tp_ser_no", dRs.getString("TRSP_AGMT_RT_TP_SER_NO"));
					param.put("trsp_agmt_nod_seq", dRs.getString("TRSP_AGMT_NOD_SEQ"));
					param.put("trsp_agmt_rt_seq", dRs.getString("TRSP_AGMT_RT_SEQ"));
					param.put("trsp_agmt_eq_tp_sz_cd", dRs.getString("TRSP_AGMT_EQ_TP_SZ_CD"));
					param.put("eff_fm_dt", dRs.getString("EFF_FM_DT"));
					param.put("eff_to_dt", dRs.getString("EFF_TO_DT"));
					param.put("curr_cd", dRs.getString("CURR_CD"));
					param.put("trsp_one_wy_rt", dRs.getString("TRSP_ONE_WY_RT"));
					param.put("trsp_rnd_rt", dRs.getString("TRSP_RND_RT"));
					param.put("wtr_rcv_term_cd", dRs.getString("WTR_RCV_TERM_CD"));
					param.put("wtr_de_term_cd", dRs.getString("WTR_DE_TERM_CD"));
					param.put("trsp_agmt_bdl_qty", dRs.getString("TRSP_AGMT_BDL_QTY"));
					param.put("to_wgt", dRs.getString("TO_WGT"));
					param.put("wgt_meas_ut_cd", dRs.getString("WGT_MEAS_UT_CD"));
					param.put("trsp_rvs_aply_flg", dRs.getString("TRSP_RVS_APLY_FLG"));
					param.put("eq_knd_cd", dRs.getString("EQ_KND_CD"));

					//데이타를 삭제하기 전에 History 테이블에 기록한다.
					new SQLExecuter("DEFAULT").executeUpdate(new AgreementCorrectionDBDAODeleteCorrSumAgmtTargetCSQL(), param, param);
				}

				//Surcharge Rate History에 남길 대상 조회
				dRs_Scg = new SQLExecuter("DEFAULT").executeQuery(new AgreementCorrectionDBDAODeleteCorrSumAgmtScgTargetRSQL(), param,param);
				//for(int k=0;dRs_Scg.next();k++) {
				while(dRs_Scg.next()) {
					param.put("trsp_agmt_ofc_cty_cd", dRs_Scg.getString("TRSP_AGMT_OFC_CTY_CD"));
					param.put("trsp_agmt_seq", dRs_Scg.getString("TRSP_AGMT_SEQ"));
					param.put("trsp_agmt_rt_tp_ser_no", dRs_Scg.getString("TRSP_AGMT_RT_TP_SER_NO"));
					param.put("trsp_agmt_scg_nod_seq", dRs_Scg.getString("TRSP_AGMT_SCG_NOD_SEQ"));
					param.put("trsp_agmt_scg_rt_seq", dRs_Scg.getString("TRSP_AGMT_SCG_RT_SEQ"));
					param.put("trsp_agmt_eq_tp_sz_cd", dRs_Scg.getString("TRSP_AGMT_EQ_TP_SZ_CD"));
					param.put("eff_fm_dt", dRs_Scg.getString("EFF_FM_DT"));
					param.put("eff_to_dt", dRs_Scg.getString("EFF_TO_DT"));
					param.put("to_wgt", dRs_Scg.getString("TO_WGT"));
					param.put("wgt_meas_ut_cd", dRs_Scg.getString("WGT_MEAS_UT_CD"));
					param.put("curr_cd", dRs_Scg.getString("CURR_CD"));
					param.put("trsp_one_wy_rt", dRs_Scg.getString("TRSP_ONE_WY_RT"));
					param.put("trsp_rnd_rt", dRs_Scg.getString("TRSP_RND_RT"));
					param.put("eq_knd_cd", dRs_Scg.getString("EQ_KND_CD"));

					//Surcharge 데이타를 삭제하기 전에 History 테이블에 기록한다.
					new SQLExecuter("DEFAULT").executeUpdate(new AgreementCorrectionDBDAODeleteCorrSumAgmtScgTargetCSQL(), param, param);
				}

				insCnt = sqlExe.executeBatch((ISQLTemplate)new AgreementCorrectionDBDAODeleteCorrSumAgmtDSQL(), mVoList, param, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to TRS Agreement Rate Delete"+ i + " SQL");
				}
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AgreementCorrectionDBDAODeleteCorrSumAgmtScgDSQL(), mVoList, param, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to TRS Agreement Surcharge Rate Delete"+ i + " SQL");
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
	 * Agreement Rate정보 조회
	 * 
	 * @param event
	 * @return
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
	 * @param event
	 * @return
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
	 * @param event
	 * @return
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
	 * @param event
	 * @return
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
	 *  // More Candidate Popup(ESD_TRS_0921) Surcharge Rate 정보 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchMoreCadidateScgAgmt(EsdTrs0229Event event) throws DAOException { // More Candidate Popup(ESD_TRS_0921) Surcharge Rate
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fm_cost_mod_cd", event.getFmCostModCd()     );
		param.put("fm_crr_mod_cd", event.getFmCrrModCd()      );
		param.put("fm_cgo_tp_cd", event.getFmCgoTpCd()       );
		param.put("fm_loce", event.getFmLoce()          );
		param.put("fm_yard", event.getFmYard()          );
		param.put("via_loce", event.getViaLoce()         );
		param.put("via_yard", event.getViaYard()         );
		param.put("to_loce", event.getToLoce()          );
		param.put("to_yard", event.getToYard()          );
		param.put("dor_loce", event.getDorLoce()         );
		param.put("dor_yard", event.getDorYard()         );
		param.put("eq_tpsz_cd", event.getEqTpszCd()        );
		param.put("cntr_wgt", event.getCntrWgt()         );
		param.put("cntr_wgt_tp_cd", event.getCntrWgtTpCd()     );
		param.put("agmt_no", event.getAgmtNo()          );
		param.put("trsp_agmt_rt_tp_ser_no", event.getFm_trsp_agmt_rt_tp_ser_no()          );
		param.put("vndr_seq", event.getVndrSeq()         );
		param.put("trsp_bnd_cd", event.getTrspBndCd()       );
		param.put("spcl_cgo_cntr_tp_cd", event.getSpclCgoCntrTpCd() );
		param.put("trsp_agmt_eq_tp_sz_cd", event.getTrspAgmtEqTpSzCd());
		param.put("usr_def_rmk", event.getUsrDefRmk()       );
		param.put("basic_rate", event.getBasicRate()       );
		param.put("nego_amt", event.getNegoAmt()        );
		param.put("total_amt", event.getTotalAmt()       );
		param.put("basis_dt", event.getBasisDt()       );
		param.put("curr_cd", event.getCurrCd()       );
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementCorrectionDBDAOSearchMoreCandidateScgAgmtRSQL(), param,param);
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
	 * Inquires attach file of corresponding agreement.
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<AgmtAttachFileListVO> searchAgmtAtchFileList(EsdTrs0238Event event) throws DAOException {
		DBRowSet dRs = null;
		List<AgmtAttachFileListVO> list = new ArrayList<AgmtAttachFileListVO>();
		
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("agmt_no", event.getAgmtNo());
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementCorrectionDBDAOSearchAgmtAttachFileListRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dRs, AgmtAttachFileListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return list;
	}
	
	/**
	 * TRS_AGMT_IMG_STO 추가 (AgmtAttachFileListVO)  데이터를 생성한다.<br>
	 * 
	 * @param listVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addAgmtAtchFileList(List<AgmtAttachFileListVO> listVO) throws DAOException, Exception {
		try {
			int insCnt = 0;
			if(listVO.size() > 0) {
				//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<AgmtAttachFileListVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		AgmtAttachFileListVO agmtAttachFileListVO = (AgmtAttachFileListVO)list.next();
					Map<String, String> mapVO = agmtAttachFileListVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);

	    			insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new AgreementCorrectionDBDAOManageAgmtAttachFileListCSQL(), param, velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
	        	}
	        }
			return insCnt;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * TRS_AGMT_IMG_STO 추가 (AgmtAttachFileListVO) 데이터를 갱신한다.<br>
	 * 
	 * @param listVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyAgmtAtchFileList(List<AgmtAttachFileListVO> listVO) throws DAOException, Exception {
		try {
			int insCnt = 0;
			if(listVO.size() > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<AgmtAttachFileListVO> list = listVO.iterator();
	        	
	        	while(list.hasNext()){
	        		AgmtAttachFileListVO agmtAttachFileListVO = (AgmtAttachFileListVO)list.next();
					Map<String, String> mapVO = agmtAttachFileListVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
	    			insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new AgreementCorrectionDBDAOManageAgmtAttachFileListUSQL(), param, velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
	        	}
	        }
			return insCnt;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * TRS_AGMT_IMG_STO 추가 (AgmtAttachFileListVO) 데이터를 삭제한다.<br>
	 * 
	 * @param listVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeAgmtAtchFileList(List<AgmtAttachFileListVO> listVO) throws DAOException, Exception {
		try {
			int insCnt = 0;
			if(listVO.size() > 0) {
				//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<AgmtAttachFileListVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		AgmtAttachFileListVO agmtAttachFileListVO = (AgmtAttachFileListVO)list.next();
					Map<String, String> mapVO = agmtAttachFileListVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
	    			insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new AgreementCorrectionDBDAOManageAgmtAttachFileListDSQL(), param, velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
	        	}
	        }
			return insCnt;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return
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
