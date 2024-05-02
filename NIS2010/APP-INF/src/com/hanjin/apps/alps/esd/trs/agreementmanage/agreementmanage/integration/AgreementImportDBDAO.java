/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementImportDBDAO.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010-03-26
*@LastModifier : jong hyek choi
*@LastVersion : 1.0 
* 2010-03-26 jong hyek choi
* 1.0 최초 생성
* 2010.11.23 이재위 1.24 [] [TRS] OPMS Design/Development Verification 을 위한 소스 점검
* 2011.06.24 황효근 1.26 [CHM-201111442][TRS] R9 CNTR 추가관련 로직 변경요청
* 2011.09.21 최종혁   [CHM-201113360] [TRS] AGMT delete function 변경 + Feeder term Rule 인식 변경 요청
* 2014.04.10 김현화 [CHM-201429759] AGMT Approval Date 및 Date Gap 추가 
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0220Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0221Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0240Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.DummyAgmtRateVO;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.SearchAgmtHdrVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TrsAgmtAplyVndrVO;
import com.hanjin.syscommon.common.table.TrsHjlHndlFeeVO;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * @author jong hyek choi
 * @see DBDAOSupport
 * @since J2EE 1.6
 * History
 * 2010.09.13 최종혁 [CHM-201005934] [TRS] AGMT Verification Error 내용 table 추가 요청
 */

public class AgreementImportDBDAO extends DBDAOSupport {
	/**
	 * Agreement Header 정보를 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAgmtHdr(EsdTrs0220Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fm_agmtno", event.getFm_agmtno());
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOSearchAgmtHdrRSQL(), param,param);
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
	 * Agreement Child S/P정보 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAgmtChdVndr(EsdTrs0220Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fm_agmtno", event.getFm_agmtno());
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOSearchAgmtChdVndrRSQL(), param,param);
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
	 * Agreement S/P명 조회<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchVenderName(EsdTrs0220Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vndr_prmry_seq", event.getFm_vndr_prmry_seq());

		/* AGREEMENT KEY 존재여부 체크 로직 */
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOSearchVenderNameRSQL(), param, param);
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
	 * Agreement S/P명 조회<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchContractOffice(EsdTrs0220Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ctrt_ofc_cd", event.getFmCtrtOfcCd());

		/* AGREEMENT KEY 존재여부 체크 로직 */
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOSearchContractOfficeRSQL(), param, param);
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
	 * Agreement 중복여부 조회<br>
	 *
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAgmtDupChk(SearchAgmtHdrVO model) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, String> paramVo = model.getColumnValues();
		param.putAll(paramVo);

		/* AGREEMENT KEY 존재여부 체크 로직 */
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOSearchAgmtDupChkRSQL(), param, param);
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
	 * HJS-HJL Handling Fee Management 정보를 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchHjlHndlFee(EsdTrs0240Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		String ofc_cd = event.getOfc_cd();
		List<String> arr_ofc_cd = new ArrayList();
		arr_ofc_cd = this.seperationParameter(ofc_cd, ",");
		
		param.put("ofc_cd",arr_ofc_cd);
		param.put("fm_dt", event.getFm_dt());
		

		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOSearchHjlHndlFeeRSQL(), param,param);
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
	 * HJS-HJL Handling Fee Management 정보를 History 포함 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchHjlHndlFeeHis(EsdTrs0240Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		String ofc_cd = event.getOfc_cd();
		List<String> arr_ofc_cd = new ArrayList();
		arr_ofc_cd = this.seperationParameter(ofc_cd, ",");
		
		param.put("ofc_cd",arr_ofc_cd);
		param.put("fm_dt", event.getFm_dt());
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOSearchHjlHndlFeeHisRSQL(), param,param);
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
	 * Agreement Header 정보를 저장
	 * 
	 * @param model
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public String multiAgmtHdr(SearchAgmtHdrVO model) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt  = 0;
		DBRowSet dRs = null;
		String rtn_agmt_no = "";
		try {
			Map<String, String> paramVo = model.getColumnValues();
			param.putAll(paramVo);

			dRs  = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiAgmtHdrCreateSeqNoRSQL(), param, param);
			if(dRs.next()){	
				String seq = dRs.getString("seq");
				param.put("trsp_agmt_seq", Integer.parseInt(seq, 10)); 
				rtn_agmt_no = param.get("trsp_agmt_ofc_cty_cd") + dRs.getString("seq");
			}

			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiAgmtHdrCSQL(), param, param);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
			
			//PRIMARY S/P CODE 등록
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiAgmtHdrVndrRSQL(), param, param);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return rtn_agmt_no;
	}
	
	/**
	 * Agreement Header 정보를 업데이트
	 * 
	 * @param event
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiAgmtHdrRmk(EsdTrs0220Event event) throws DAOException,Exception {
		Map<String,Object> param = new HashMap<String,Object>();
		int insCnt  = 0;
		try {
			SearchAgmtHdrVO[] model = event.getSearchAgmtHdrVOs();
			Map<String, String> paramVo = model[0].getColumnValues();
			param.putAll(paramVo);
	
			String fm_account_ofc_cd = event.getFm_account_ofc_cd();
			String fm_account_usr_id = event.getFm_account_usr_id();
			param.put("fm_account_ofc_cd", 	fm_account_ofc_cd);
			param.put("fm_account_usr_id", 	fm_account_usr_id);		
			
			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiAgmtHdrRmkUSQL(), param, param);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * TrsAgmtAplyVndrVO의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param event
	 * @throws DAOException
	 */
	public void multiAgmtHdrVndr(EsdTrs0220Event event) throws DAOException {
		try {
			int insCnt[] = null;
			SQLExecuter sqlExe = new SQLExecuter("");
			TrsAgmtAplyVndrVO[] model = event.getTrsAgmtAplyVndrVOs();
			Map<String,Object> param = new HashMap<String,Object>();

			Collection<TrsAgmtAplyVndrVO> insertVoList = new ArrayList<TrsAgmtAplyVndrVO>();
			Collection<TrsAgmtAplyVndrVO> deleteVoList = new ArrayList<TrsAgmtAplyVndrVO>();

			String fm_account_ofc_cd = event.getFm_account_ofc_cd();
			String fm_account_usr_id = event.getFm_account_usr_id();
			param.put("fm_account_ofc_cd", 	fm_account_ofc_cd);
			param.put("fm_account_usr_id", 	fm_account_usr_id);
			
			for ( int i=0; i<model.length; i++ ) {
				if ( model[i].getIbflag().equals("I")){
					insertVoList.add(model[i]);
				} else if ( model[i].getIbflag().equals("D")){
					deleteVoList.add(model[i]);
				} 
			}
			
			//1. Insert
			if(insertVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AgreementImportDBDAOMultiAgmtHdrVndrCSQL(), insertVoList, param, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}

			//2. Delete
			if(deleteVoList.size() > 0){	
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AgreementImportDBDAOMultiAgmtHdrVndrUSQL(), deleteVoList, param, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * Verify시 필요한 Sequence를 조회한다.<br>
	 *
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet createNewAgmtTmpSeq() throws DAOException {
		DBRowSet dRs = null;
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOCreateNewAgmtTmpSeqRSQL(), null, null);
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
	 * setting vo
	 * 
	 * @param from_vo
	 * @param to_vo
	 */
	public void setVos(DummyAgmtRateVO from_vo, DummyAgmtRateVO to_vo) {
		to_vo.setEqKndCd(from_vo.getEqKndCd());
		to_vo.setCgoTpCd(from_vo.getCgoTpCd());
		to_vo.setAgmtTrspTpCd(from_vo.getAgmtTrspTpCd());
		to_vo.setTrspCostModCd(from_vo.getTrspCostModCd());
		to_vo.setCustCd(from_vo.getCustCd());
		to_vo.setCmdtGrpCd(from_vo.getCmdtGrpCd());
		to_vo.setRailSvcTpCd(from_vo.getRailSvcTpCd());
		to_vo.setFmNodCd(from_vo.getFmNodCd());
		to_vo.setViaNodCd(from_vo.getViaNodCd());
		to_vo.setDorNodCd(from_vo.getDorNodCd());
		to_vo.setToNodCd(from_vo.getToNodCd());
		to_vo.setFmNodYd(from_vo.getFmNodYd());
		to_vo.setViaNodYd(from_vo.getViaNodYd());
		to_vo.setDorNodYd(from_vo.getDorNodYd());
		to_vo.setToNodYd(from_vo.getToNodYd());
		to_vo.setEffFmDt(from_vo.getEffFmDt());
		to_vo.setEffToDt(from_vo.getEffToDt());
		to_vo.setToWgt(from_vo.getToWgt());
		to_vo.setCurrCd(from_vo.getCurrCd());
		to_vo.setTrspOneWyRt(from_vo.getTrspOneWyRt());
		to_vo.setTrspRndRt(from_vo.getTrspRndRt());
		to_vo.setTrspAgmtRtTpCd(from_vo.getTrspAgmtRtTpCd());
		to_vo.setWgtMeasUtCd(from_vo.getWgtMeasUtCd());
		to_vo.setTrspAgmtBdlQty(from_vo.getTrspAgmtBdlQty());
		to_vo.setWtrRcvTermCd(from_vo.getWtrRcvTermCd());
		to_vo.setWtrDeTermCd(from_vo.getWtrDeTermCd());
		to_vo.setTrspAgmtDist(from_vo.getTrspAgmtDist());
		to_vo.setDistMeasUtCd(from_vo.getDistMeasUtCd());
		to_vo.setTrspDistTpCd(from_vo.getTrspDistTpCd());
		to_vo.setTrspScgCd(from_vo.getTrspScgCd());
		to_vo.setAgmtRoutAllFlg((from_vo.getAgmtRoutAllFlg()));
		to_vo.setIbflag(from_vo.getIbflag());
		to_vo.setAgmtScgRtDivCd(from_vo.getAgmtScgRtDivCd());
		to_vo.setTrspRvsAplyFlg(from_vo.getTrspRvsAplyFlg());
		to_vo.setRowno(from_vo.getUiSeqno());
		to_vo.setAgmtAproDt(from_vo.getAgmtAproDt());
		to_vo.setCustNomiTrkrIndCd(from_vo.getCustNomiTrkrIndCd());
	}
	
	/**
	 * Pair Type AgreementFileImport 의 Verify 수행<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public EsdTrs0221Event insertAgreementVerifyData(EsdTrs0221Event event) throws DAOException {
		DummyAgmtRateVO[] model = event.getDummyAgmtRateVOs();
		Collection<DummyAgmtRateVO> insModels = new ArrayList<DummyAgmtRateVO>();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("trsp_tmp_seq",event.getTrspAgmtTmpSeq());
		param.put("fm_agmtno",event.getFm_agmtno());
		param.put("fm_trsp_agmt_rt_tp_cd",event.getFm_trsp_agmt_rt_tp_cd());
		param.put("fm_eq_knd_cd",event.getFm_eq_knd_cd());
		String fm_eq_knd_cd = event.getFm_eq_knd_cd();
		
		param.put("fm_account_ofc_cd", 	event.getFm_account_ofc_cd());
		param.put("fm_account_usr_id", 	event.getFm_account_usr_id());		
		
		int chk_row = 0;

		try{
			DummyAgmtRateVO dummy = new DummyAgmtRateVO(); //Equipment가 없을 경우엔 java오류가 발생하므로 오류발생을 방지하기 위해서 추가된 코드
			insModels.add(dummy);
			for(int i=0;i<model.length;i++){
				chk_row = 0;
				if (model[i].getEqD2().equals("1")) { //D2
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("D");
					model_sub.setTrspAgmtEqSzCd("2");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqD3().equals("1")) { //D3
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("D");
					model_sub.setTrspAgmtEqSzCd("3");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqD4().equals("1")) { //D4
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("D");
					model_sub.setTrspAgmtEqSzCd("4");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqD5().equals("1")) { //D5
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("D");
					model_sub.setTrspAgmtEqSzCd("5");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqD7().equals("1")) { //D7
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("D");
					model_sub.setTrspAgmtEqSzCd("7");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqD8().equals("1")) { //D8
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("D");
					model_sub.setTrspAgmtEqSzCd("8");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqD9().equals("1")) { //D9
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("D");
					model_sub.setTrspAgmtEqSzCd("9");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqDw().equals("1")) { //DW
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("D");
					model_sub.setTrspAgmtEqSzCd("W");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqDx().equals("1")) { //DX
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("D");
					model_sub.setTrspAgmtEqSzCd("X");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqR2().equals("1")) { //R2
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("R");
					model_sub.setTrspAgmtEqSzCd("2");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqR4().equals("1")) { //R4
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("R");
					model_sub.setTrspAgmtEqSzCd("4");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqR5().equals("1")) { //R5
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("R");
					model_sub.setTrspAgmtEqSzCd("5");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqR7().equals("1")) { //R7
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("R");
					model_sub.setTrspAgmtEqSzCd("7");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqR8().equals("1")) { //R8 2013.06.26
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("R");
					model_sub.setTrspAgmtEqSzCd("8");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqR9().equals("1")) { //R9 ([CHM-201111442-01] 황효근 추가
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("R");
					model_sub.setTrspAgmtEqSzCd("9");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqA2().equals("1")) { //A2
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("A");
					model_sub.setTrspAgmtEqSzCd("2");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqA4().equals("1")) { //A4
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("A");
					model_sub.setTrspAgmtEqSzCd("4");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqA5().equals("1")) { //A5
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("A");
					model_sub.setTrspAgmtEqSzCd("5");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqF2().equals("1")) { //F2
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("F");
					model_sub.setTrspAgmtEqSzCd("2");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqF4().equals("1")) { //F4
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("F");
					model_sub.setTrspAgmtEqSzCd("4");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqF5().equals("1")) { //F5
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("F");
					model_sub.setTrspAgmtEqSzCd("5");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqT2().equals("1")) { //T2
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("T");
					model_sub.setTrspAgmtEqSzCd("2");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqT4().equals("1")) { //T4
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("T");
					model_sub.setTrspAgmtEqSzCd("4");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqS2().equals("1")) { //S2
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("S");
					model_sub.setTrspAgmtEqSzCd("2");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqS4().equals("1")) { //S4
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("S");
					model_sub.setTrspAgmtEqSzCd("4");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqO2().equals("1")) { //O2
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("O");
					model_sub.setTrspAgmtEqSzCd("2");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqO4().equals("1")) { //O4
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("O");
					model_sub.setTrspAgmtEqSzCd("4");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqO5().equals("1")) { //O5 2012.10.15
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("O");
					model_sub.setTrspAgmtEqSzCd("5");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqO7().equals("1")) { //2018.05.08 추가 [CSR #3841]
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("O");
					model_sub.setTrspAgmtEqSzCd("7");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqP2().equals("1")) { //P2
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("P");
					model_sub.setTrspAgmtEqSzCd("2");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqP4().equals("1")) { //P4
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("P");
					model_sub.setTrspAgmtEqSzCd("4");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqSf2().equals("1")) { //SF2
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("SF");
					model_sub.setTrspAgmtEqSzCd("2");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqSf4().equals("1")) { //SF4
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("SF");
					model_sub.setTrspAgmtEqSzCd("4");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqSl2().equals("1")) { //SL2
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("SL");
					model_sub.setTrspAgmtEqSzCd("2");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqTa2().equals("1")) { //TA2
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("TA");
					model_sub.setTrspAgmtEqSzCd("2");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqGn4().equals("1")) { //GN4
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("GN");
					model_sub.setTrspAgmtEqSzCd("4");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqGn5().equals("1")) { //GN5
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("GN");
					model_sub.setTrspAgmtEqSzCd("5");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqEg5().equals("1")) { //EG5
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("EG");
					model_sub.setTrspAgmtEqSzCd("5");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqEg8().equals("1")) { //EG8
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("EG");
					model_sub.setTrspAgmtEqSzCd("8");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqZt4().equals("1")) { //ZT4
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("ZT");
					model_sub.setTrspAgmtEqSzCd("4");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqCb4().equals("1")) { //CB4
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("CB");
					model_sub.setTrspAgmtEqSzCd("4");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqCg().equals("1")) { //CG
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("CG");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqUg().equals("1")) { //UG
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("UG");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				
				if (model[i].getEqAlal().equals("1")) { //ALAL
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("AL");
					model_sub.setTrspAgmtEqSzCd("AL");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqDal().equals("1")) { //DAL
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("D");
					model_sub.setTrspAgmtEqSzCd("AL");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqRal().equals("1")) { //RAL
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("R");
					model_sub.setTrspAgmtEqSzCd("AL");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqAal().equals("1")) { //AAL
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("A");
					model_sub.setTrspAgmtEqSzCd("AL");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqFal().equals("1")) { //FAL
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("F");
					model_sub.setTrspAgmtEqSzCd("AL");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqTal().equals("1")) { //TAL
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("T");
					model_sub.setTrspAgmtEqSzCd("AL");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqSal().equals("1")) { //SAL
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("S");
					model_sub.setTrspAgmtEqSzCd("AL");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqOal().equals("1")) { //OAL
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("O");
					model_sub.setTrspAgmtEqSzCd("AL");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqPal().equals("1")) { //PAL
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("P");
					model_sub.setTrspAgmtEqSzCd("AL");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqAl2().equals("1")) { //AL2
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("AL");
					model_sub.setTrspAgmtEqSzCd("2");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqAl4().equals("1")) { //AL4
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("AL");
					model_sub.setTrspAgmtEqSzCd("4");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqAl5().equals("1")) { //AL5
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("AL");
					model_sub.setTrspAgmtEqSzCd("5");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqAl7().equals("1")) { //AL7
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("AL");
					model_sub.setTrspAgmtEqSzCd("7");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqAl8().equals("1")) { //AL8
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("AL");
					model_sub.setTrspAgmtEqSzCd("8");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqAl9().equals("1")) { //AL9
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("AL");
					model_sub.setTrspAgmtEqSzCd("9");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
////
				if (model[i].getEqSfal().equals("1")) { //SFAL
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("SF");
					model_sub.setTrspAgmtEqSzCd("AL");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqSlal().equals("1")) { //SLAL
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("SL");
					model_sub.setTrspAgmtEqSzCd("AL");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqTaal().equals("1")) { //TAAL
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("TA");
					model_sub.setTrspAgmtEqSzCd("AL");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqGnal().equals("1")) { //GNAL
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("GN");
					model_sub.setTrspAgmtEqSzCd("AL");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}
				if (model[i].getEqEgal().equals("1")) { //EGAL
					DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
					setVos(model[i], model_sub);
					model_sub.setTrspAgmtEqTpCd("EG");
					model_sub.setTrspAgmtEqSzCd("AL");
					model_sub.setDeltFlg("N"); 
					model_sub.setChkRowno((chk_row++)+"");
					insModels.add(model_sub);
				}

				//삭제 데이타 저장
				if (model[i].getOrgEqtype().length() > 0) {
					List<String> arr_orgEqno = new ArrayList();
					arr_orgEqno = this.seperationParameter(model[i].getOrgEqtype(), ",");
					for(int j=0;j<arr_orgEqno.size();j++){
						if(fm_eq_knd_cd.equals("U")) {
							DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
							setVos(model[i], model_sub);
							if (arr_orgEqno.get(j).length() == 2) {
								model_sub.setTrspAgmtEqTpCd(arr_orgEqno.get(j).substring(0, 1));
								model_sub.setTrspAgmtEqSzCd(arr_orgEqno.get(j).substring(1, 2));
							}else if (arr_orgEqno.get(j).length() == 3) {
								if (arr_orgEqno.get(j).substring(0,2).equals("AL")) {
									model_sub.setTrspAgmtEqTpCd(arr_orgEqno.get(j).substring(0, 2));
									model_sub.setTrspAgmtEqSzCd(arr_orgEqno.get(j).substring(2, 3));
								}else{
									model_sub.setTrspAgmtEqTpCd(arr_orgEqno.get(j).substring(0, 1));
									model_sub.setTrspAgmtEqSzCd(arr_orgEqno.get(j).substring(1, 3));
								}
							}else if (arr_orgEqno.get(j).length() == 4) {
								model_sub.setTrspAgmtEqTpCd(arr_orgEqno.get(j).substring(0, 2));
								model_sub.setTrspAgmtEqSzCd(arr_orgEqno.get(j).substring(2, 4));
							}
							
							model_sub.setChkRowno((chk_row++)+"");
							model_sub.setDeltFlg("Y"); 
							insModels.add(model_sub);
						}else if(fm_eq_knd_cd.equals("Z")) {
							DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
							setVos(model[i], model_sub);
							if (arr_orgEqno.get(j).length() == 3 ) {
								model_sub.setTrspAgmtEqTpCd(arr_orgEqno.get(j).substring(0, 2));
								model_sub.setTrspAgmtEqSzCd(arr_orgEqno.get(j).substring(2, 3));
							}else if (arr_orgEqno.get(j).length() == 4 ) {
								model_sub.setTrspAgmtEqTpCd(arr_orgEqno.get(j).substring(0, 2));
								model_sub.setTrspAgmtEqSzCd(arr_orgEqno.get(j).substring(2, 4));
							}
							
							model_sub.setChkRowno((chk_row++)+"");
							model_sub.setDeltFlg("Y");
							insModels.add(model_sub);
						}else{
							DummyAgmtRateVO model_sub = new DummyAgmtRateVO();
							setVos(model[i], model_sub);
							if (arr_orgEqno.get(j).length() == 2 ) {
								model_sub.setTrspAgmtEqTpCd(arr_orgEqno.get(j));
							}else if (arr_orgEqno.get(j).length() == 4 ) {
								model_sub.setTrspAgmtEqTpCd(arr_orgEqno.get(j).substring(0, 2));
								model_sub.setTrspAgmtEqSzCd(arr_orgEqno.get(j).substring(2, 4));
							}
							
							model_sub.setChkRowno((chk_row++)+"");
							model_sub.setDeltFlg("Y");
							insModels.add(model_sub);
						}
					}
				}
			}

			new SQLExecuter("DEFAULT").executeBatch(new AgreementImportDBDAOInsertAgreementVerifyDataCSQL(),insModels, param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return event;
	}
	
	/**
	 * Pair Type AgreementFileImport 의 Verify 수행<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet verifyAgmtPair(EsdTrs0221Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("trsp_tmp_seq",event.getTrspAgmtTmpSeq());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOVerifyAgmtPairRSQL(), param, param);
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
	 * Pair Type AgreementFileImport 의 Verify 수행<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet verifyAgmtDistance(EsdTrs0221Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("trsp_tmp_seq",event.getTrspAgmtTmpSeq());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOVerifyAgmtDistanceRSQL(), param, param);
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
	 * Pair Type AgreementFileImport 의 Verify 수행<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public EsdTrs0221Event deleteAgmtVerifyData(EsdTrs0221Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("trsp_tmp_seq", event.getTrspAgmtTmpSeq());
			new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAODeleteAgmtVerifyDataDSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return event;
	}

	/**
	 * Agreement Surcharge 의 Verify 수행<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet verifyAgmtSurcharge(EsdTrs0221Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("trsp_tmp_seq",event.getTrspAgmtTmpSeq());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOVerifyAgmtSurchargeRSQL(), param, param);

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
	public DBRowSet searchSubOfcCd(EsdTrs0221Event event) throws DAOException {
		DBRowSet dRs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			String ctrt_office = event.getFm_ctrt_ofc_cd();
			List<String> arr_office = new ArrayList();
			arr_office = this.seperationParameter(ctrt_office, ","); 
			param.put("arr_office", arr_office);
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOSearchSubOfcCdRSQL(), param,param);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}
	
	/**
	 * Agreement Rate정보 삭제 처리
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void deleteCorrRateAgmt(EsdTrs0221Event event) throws DAOException {
		DBRowSet rs_Rate     = null;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("trsp_tmp_seq",event.getTrspAgmtTmpSeq());
		param.put("fm_account_ofc_cd", 	event.getFm_account_ofc_cd());
		param.put("fm_account_usr_id", 	event.getFm_account_usr_id());
		try{
			rs_Rate = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAODeleteCorrRateAgmtRSQL(), param, param);
			for(int k=0;rs_Rate.next();k++) {
				param.put("trsp_agmt_ofc_cty_cd", rs_Rate.getString("TRSP_AGMT_OFC_CTY_CD"));
				param.put("trsp_agmt_seq", rs_Rate.getString("TRSP_AGMT_SEQ"));
				param.put("trsp_agmt_rt_tp_ser_no", rs_Rate.getString("TRSP_AGMT_RT_TP_SER_NO"));
				param.put("trsp_agmt_nod_seq", rs_Rate.getString("TRSP_AGMT_NOD_SEQ"));
				param.put("trsp_agmt_rt_seq", rs_Rate.getString("TRSP_AGMT_RT_SEQ"));
				param.put("agmt_exp_dt", rs_Rate.getString("AGMT_EXP_DT"));

				//History 자료를 DELETE로 UPDATE한다.
				new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAODeleteCorrRateAgmtHisUSQL(), param, param);
				
				new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAODeleteCorrRateAgmtUSQL(), param, param);
				
				//데이타를 삭제하기 전에 History 테이블에 기록한다.
//				new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAODeleteCorrRateAgmtHisCSQL(), param, param);
				
//				new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAODeleteCorrRateAgmtDSQL(), param, param);
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
	 * Agreement Header 정보를 저장
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public EsdTrs0221Event multiCorrRateAgmt(EsdTrs0221Event event) throws DAOException,Exception {
		DBRowSet rs_RateType = null;
		DBRowSet rs_Node     = null;
		DBRowSet rs_Seq      = null;
		DBRowSet rs_Rate     = null;
		String sDupChk = "";
		String sEqSeq  = "";
		String sToWgt  = "";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("trsp_tmp_seq",event.getTrspAgmtTmpSeq());
		param.put("fm_agmtno",event.getFm_agmtno());
		param.put("fm_account_ofc_cd", 	event.getFm_account_ofc_cd());
		param.put("fm_account_usr_id", 	event.getFm_account_usr_id());

		try{
			rs_RateType = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrRateAgmtRateTypeRSQL(), param, param);
			for(int k=0;rs_RateType.next();k++) {
				sDupChk = rs_RateType.getString("TRSP_AGMT_RT_TP_SER_NO");
				param.put("trsp_agmt_ofc_cty_cd", rs_RateType.getString("TRSP_AGMT_OFC_CTY_CD"));
				param.put("trsp_agmt_seq", rs_RateType.getString("TRSP_AGMT_SEQ"));
				param.put("trsp_agmt_rt_tp_cd", rs_RateType.getString("TRSP_AGMT_RT_TP_CD"));
				param.put("cgo_tp_cd", rs_RateType.getString("CGO_TP_CD"));
				param.put("cust_nomi_trkr_flg", rs_RateType.getString("CUST_NOMI_TRKR_FLG"));
				param.put("cust_nomi_trkr_ind_cd", rs_RateType.getString("CUST_NOMI_TRKR_IND_CD"));
				param.put("cust_cnt_cd", rs_RateType.getString("CUST_CNT_CD"));
				param.put("cust_seq", rs_RateType.getString("CUST_SEQ"));
				param.put("trsp_cost_mod_cd", rs_RateType.getString("TRSP_COST_MOD_CD"));
				param.put("agmt_trsp_tp_cd", rs_RateType.getString("AGMT_TRSP_TP_CD"));
				param.put("cmdt_grp_cd", rs_RateType.getString("CMDT_GRP_CD"));
				param.put("rail_svc_tp_cd", rs_RateType.getString("RAIL_SVC_TP_CD"));
				param.put("trsp_agmt_rt_tp_ser_no", rs_RateType.getString("TRSP_AGMT_RT_TP_SER_NO"));
				
				if (sDupChk.length()>0) { //이미 rate type이 존재할 경우
					new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtRateTypeUSQL(), param, param);
				}else{
					new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtRateTypeCSQL(), param, param);
				}
			}
			
			rs_Node = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrRateAgmtNodeRSQL(), param, param);
			for(int k=0;rs_Node.next();k++) {
				sDupChk = rs_Node.getString("TRSP_AGMT_NOD_SEQ");
				param.put("trsp_agmt_ofc_cty_cd", rs_Node.getString("TRSP_AGMT_OFC_CTY_CD"));
				param.put("trsp_agmt_seq", rs_Node.getString("TRSP_AGMT_SEQ"));
				param.put("fm_nod_cd", rs_Node.getString("FM_NOD_CD"));
				param.put("via_nod_cd", rs_Node.getString("VIA_NOD_CD"));
				param.put("dor_nod_cd", rs_Node.getString("DOR_NOD_CD"));
				param.put("to_nod_cd", rs_Node.getString("TO_NOD_CD"));
				param.put("trsp_agmt_dist", rs_Node.getString("TRSP_AGMT_DIST"));
				param.put("dist_meas_ut_cd", rs_Node.getString("DIST_MEAS_UT_CD"));
				param.put("trsp_dist_tp_cd", rs_Node.getString("TRSP_DIST_TP_CD"));
				param.put("trsp_agmt_rt_tp_ser_no", rs_Node.getString("TRSP_AGMT_RT_TP_SER_NO"));
				param.put("trsp_agmt_nod_seq", rs_Node.getString("TRSP_AGMT_NOD_SEQ"));
				
				if (sDupChk.length()>0) { //이미 rate node가 존재할 경우
					new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtNodeUSQL(), param, param);
				}else{
					new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtNodeCSQL(), param, param);
				}
			}
			//INSERT, UPDATE 하기전에 체크박스 해제된 데이타를 모두 삭제처리한다.
			param.put("chk_delt", "Y");
			rs_Rate = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrRateAgmtEqRateRSQL(), param, param);
			for(int k=0;rs_Rate.next();k++) {
				sDupChk = rs_Rate.getString("TRSP_AGMT_RT_SEQ");
				param.put("trsp_agmt_ofc_cty_cd", rs_Rate.getString("TRSP_AGMT_OFC_CTY_CD"));
				param.put("trsp_agmt_seq", rs_Rate.getString("TRSP_AGMT_SEQ"));
				param.put("eff_fm_dt", rs_Rate.getString("EFF_FM_DT"));
				param.put("eff_to_dt", rs_Rate.getString("EFF_TO_DT"));
				param.put("curr_cd", rs_Rate.getString("CURR_CD"));
				param.put("trsp_one_wy_rt", rs_Rate.getString("TRSP_ONE_WY_RT"));
				param.put("trsp_rnd_rt", rs_Rate.getString("TRSP_RND_RT"));
				param.put("wtr_rcv_term_cd", rs_Rate.getString("WTR_RCV_TERM_CD"));
				param.put("wtr_de_term_cd", rs_Rate.getString("WTR_DE_TERM_CD"));
				param.put("trsp_agmt_bdl_qty", rs_Rate.getString("TRSP_AGMT_BDL_QTY"));
				param.put("to_wgt", rs_Rate.getString("TO_WGT"));
				param.put("wgt_meas_ut_cd", rs_Rate.getString("WGT_MEAS_UT_CD"));
				param.put("trsp_rvs_aply_flg", rs_Rate.getString("TRSP_RVS_APLY_FLG"));
				param.put("trsp_agmt_eq_tp_sz_cd", rs_Rate.getString("TRSP_AGMT_EQ_TP_SZ_CD"));
				param.put("trsp_agmt_rt_tp_ser_no", rs_Rate.getString("TRSP_AGMT_RT_TP_SER_NO"));
				param.put("trsp_agmt_nod_seq", rs_Rate.getString("TRSP_AGMT_NOD_SEQ"));
				param.put("trsp_agmt_rt_seq", rs_Rate.getString("TRSP_AGMT_RT_SEQ"));
				param.put("eq_knd_cd", rs_Rate.getString("EQ_KND_CD"));
				param.put("delt_flg", rs_Rate.getString("DELT_FLG"));
				param.put("agmt_exp_dt", rs_Rate.getString("AGMT_EXP_DT"));
				param.put("agmt_apro_dt", rs_Rate.getString("AGMT_APRO_DT"));

				//Correction에서 체크박스를 해제 했을 경우 (Duplication이 아니라도 체크후 바로 해제했을 경우에도 삭제되상이 된다.)
				new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtEqRateDelUSQL(), param, param);

				//History 기록
				if (sDupChk.length()>0) { //이미 rate가 존재할 경우
				    new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtEqRateDelHisUSQL(), param, param);
				}
			    
//				//Correction에서 체크박스를 해제 했을 경우 (Duplication이 아니라도 체크후 바로 해제했을 경우에도 삭제되상이 된다.)
//				new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtEqRateDSQL(), param, param);
//				//History 기록
//				if (sDupChk.length()>0) { //이미 rate가 존재할 경우
//				    new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtEqRateHisCSQL(), param, param);
//				}
			}
			//INSERT, UPDATE를 한다.
			param.put("chk_delt", "N");
			rs_Rate = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrRateAgmtEqRateRSQL(), param, param);
			for(int k=0;rs_Rate.next();k++) {
				sDupChk = rs_Rate.getString("TRSP_AGMT_RT_SEQ");
				param.put("trsp_agmt_ofc_cty_cd", rs_Rate.getString("TRSP_AGMT_OFC_CTY_CD"));
				param.put("trsp_agmt_seq", rs_Rate.getString("TRSP_AGMT_SEQ"));
				param.put("eff_fm_dt", rs_Rate.getString("EFF_FM_DT"));
				param.put("eff_to_dt", rs_Rate.getString("EFF_TO_DT"));
				param.put("curr_cd", rs_Rate.getString("CURR_CD"));
				param.put("trsp_one_wy_rt", rs_Rate.getString("TRSP_ONE_WY_RT"));
				param.put("trsp_rnd_rt", rs_Rate.getString("TRSP_RND_RT"));
				param.put("wtr_rcv_term_cd", rs_Rate.getString("WTR_RCV_TERM_CD"));
				param.put("wtr_de_term_cd", rs_Rate.getString("WTR_DE_TERM_CD"));
				param.put("trsp_agmt_bdl_qty", rs_Rate.getString("TRSP_AGMT_BDL_QTY"));
				param.put("to_wgt", rs_Rate.getString("TO_WGT"));
				param.put("wgt_meas_ut_cd", rs_Rate.getString("WGT_MEAS_UT_CD"));
				param.put("trsp_rvs_aply_flg", rs_Rate.getString("TRSP_RVS_APLY_FLG"));
				param.put("trsp_agmt_eq_tp_sz_cd", rs_Rate.getString("TRSP_AGMT_EQ_TP_SZ_CD"));
				param.put("trsp_agmt_rt_tp_ser_no", rs_Rate.getString("TRSP_AGMT_RT_TP_SER_NO"));
				param.put("trsp_agmt_nod_seq", rs_Rate.getString("TRSP_AGMT_NOD_SEQ"));
				param.put("trsp_agmt_rt_seq", rs_Rate.getString("TRSP_AGMT_RT_SEQ"));
				param.put("eq_knd_cd", rs_Rate.getString("EQ_KND_CD"));
				param.put("delt_flg", rs_Rate.getString("DELT_FLG"));
				param.put("agmt_apro_dt", rs_Rate.getString("AGMT_APRO_DT"));
				
				if (sDupChk.length()>0) { //이미 rate가 존재할 경우
					param.put("trsp_agmt_rt_seq", rs_Rate.getString("TRSP_AGMT_RT_SEQ"));
				}else{
					rs_Seq = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrRateAgmtEqRateSeqRSQL(), param, param);
					if (rs_Seq.next()) sEqSeq = rs_Seq.getString("EQ_RT_SEQ");
					param.put("trsp_agmt_rt_seq", sEqSeq);
				}
				
				if (sDupChk.length()>0) { //이미 rate가 존재할 경우
					new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtEqRateUSQL(), param, param);
				}else{
					sToWgt = rs_Rate.getString("TO_WGT");
					if (sToWgt.equals("999999.99") || sToWgt.equals("0")) {
						param.put("wgt_meas_ut_cd", "XXX");
					}
					new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtEqRateCSQL(), param, param);
				}
				//History 기록
				new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrRateAgmtEqRateHisCSQL(), param, param);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return event;
	}
	
	
	/**
	 * Agreement Header 정보를 저장
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public EsdTrs0240Event saveHjlHndlFee(EsdTrs0240Event event) throws DAOException,Exception {
		
		TrsHjlHndlFeeVO[] trsHjlHndlFeeVOS = event.getTrsHjlHndlFeeVOs();
		Map<String,Object> param = new HashMap<String,Object>();

		try{

			for(int i=0; i<trsHjlHndlFeeVOS.length;i++) {
				
				param.put("hjl_ofc_cd", trsHjlHndlFeeVOS[i].getHjlOfcCd());
				param.put("vndr_seq", trsHjlHndlFeeVOS[i].getVndrSeq());
				param.put("curr_cd", trsHjlHndlFeeVOS[i].getCurrCd());
				param.put("cost_rcvr_amt", trsHjlHndlFeeVOS[i].getCostRcvrAmt());
				param.put("comm_amt", trsHjlHndlFeeVOS[i].getCommAmt());
				param.put("ttl_amt",trsHjlHndlFeeVOS[i].getTtlAmt());
				param.put("eff_fm_dt", trsHjlHndlFeeVOS[i].getEffFmDt());
				param.put("eff_to_dt", trsHjlHndlFeeVOS[i].getEffToDt());
				param.put("org_curr_cd", trsHjlHndlFeeVOS[i].getOrgCurrCd());
				param.put("org_cost_rcvr_amt", trsHjlHndlFeeVOS[i].getOrgCostRcvrAmt());
				param.put("org_comm_amt", trsHjlHndlFeeVOS[i].getOrgCommAmt());
				param.put("org_ttl_amt", trsHjlHndlFeeVOS[i].getOrgTtlAmt());
				param.put("org_eff_fm_dt", trsHjlHndlFeeVOS[i].getOrgEffFmDt());
				param.put("cre_usr_id", trsHjlHndlFeeVOS[i].getCreUsrId());
				param.put("cre_dt", trsHjlHndlFeeVOS[i].getCreDt());
				param.put("upd_usr_id", trsHjlHndlFeeVOS[i].getUpdUsrId());
				param.put("upd_dt",trsHjlHndlFeeVOS[i].getUpdDt());
				param.put("usr_id",event.getUsr_id());
				param.put("usr_ofc_cd",event.getUsr_ofc_cd());
				
				if(trsHjlHndlFeeVOS[i].getIbflag().equals("U") ||trsHjlHndlFeeVOS[i].getIbflag().equals("I") ){

					//History 기록
					new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOInsertHjlHndlFeeHisCSQL(), param, param);
					
					new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOUpdateHjlHndlFeeUSQL(), param, param);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return event;
	}
	
	/**
	 * Agreement Surcharge Rate 정보를 수정
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public EsdTrs0221Event multiCorrScgAgmt(EsdTrs0221Event event) throws DAOException,Exception {
		DBRowSet rs_Node     = null;
		DBRowSet rs_Seq      = null;
		DBRowSet rs_Rate     = null;
		String sDupChk = "";
		String sEqSeq  = "";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("trsp_tmp_seq",event.getTrspAgmtTmpSeq());
		param.put("fm_agmtno",event.getFm_agmtno());
		param.put("fm_account_ofc_cd", 	event.getFm_account_ofc_cd());
		param.put("fm_account_usr_id", 	event.getFm_account_usr_id());

		try{
			rs_Node = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrScgAgmtScgNodeRSQL(), param, param);
			for(int k=0;rs_Node.next();k++) {
				sDupChk = rs_Node.getString("TRSP_AGMT_SCG_NOD_SEQ");
				param.put("trsp_agmt_ofc_cty_cd", rs_Node.getString("TRSP_AGMT_OFC_CTY_CD"));
				param.put("trsp_agmt_seq", rs_Node.getString("TRSP_AGMT_SEQ"));
				param.put("trsp_scg_cd", rs_Node.getString("TRSP_SCG_CD"));
				param.put("agmt_rout_all_flg", rs_Node.getString("AGMT_ROUT_ALL_FLG"));
				param.put("fm_nod_cd", rs_Node.getString("FM_NOD_CD"));
				param.put("via_nod_cd", rs_Node.getString("VIA_NOD_CD"));
				param.put("dor_nod_cd", rs_Node.getString("DOR_NOD_CD"));
				param.put("to_nod_cd", rs_Node.getString("TO_NOD_CD"));
				param.put("trsp_agmt_rt_tp_ser_no", rs_Node.getString("TRSP_AGMT_RT_TP_SER_NO"));
				param.put("trsp_agmt_scg_nod_seq", rs_Node.getString("TRSP_AGMT_SCG_NOD_SEQ"));
				
				if (sDupChk.length()>0) { //이미 rate node가 존재할 경우
					new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgNodeUSQL(), param, param);
				}else{
					new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgNodeCSQL(), param, param);
				}
			}
			//INSERT, UPDATE 하기전에 체크박스 해제된 데이타를 모두 삭제처리한다.
			param.put("chk_delt", "Y");
			rs_Rate = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrScgAgmtScgRateRSQL(), param, param);
			for(int k=0;rs_Rate.next();k++) {
				sDupChk = rs_Rate.getString("TRSP_AGMT_SCG_RT_SEQ");
				param.put("trsp_agmt_ofc_cty_cd", rs_Rate.getString("TRSP_AGMT_OFC_CTY_CD"));
				param.put("trsp_agmt_seq", rs_Rate.getString("TRSP_AGMT_SEQ"));
				param.put("eff_fm_dt", rs_Rate.getString("EFF_FM_DT"));
				param.put("eff_to_dt", rs_Rate.getString("EFF_TO_DT"));
				param.put("to_wgt", rs_Rate.getString("TO_WGT"));
				param.put("wgt_meas_ut_cd", rs_Rate.getString("WGT_MEAS_UT_CD"));
				param.put("curr_cd", rs_Rate.getString("CURR_CD"));
				param.put("trsp_one_wy_rt", rs_Rate.getString("TRSP_ONE_WY_RT"));
				param.put("trsp_rnd_rt", rs_Rate.getString("TRSP_RND_RT"));
				param.put("trsp_agmt_eq_tp_sz_cd", rs_Rate.getString("TRSP_AGMT_EQ_TP_SZ_CD"));
				param.put("trsp_agmt_rt_tp_ser_no", rs_Rate.getString("TRSP_AGMT_RT_TP_SER_NO"));
				param.put("trsp_agmt_scg_nod_seq", rs_Rate.getString("TRSP_AGMT_SCG_NOD_SEQ"));
				param.put("trsp_agmt_scg_rt_seq", rs_Rate.getString("TRSP_AGMT_SCG_RT_SEQ"));
				param.put("eq_knd_cd", rs_Rate.getString("EQ_KND_CD"));
				param.put("delt_flg", rs_Rate.getString("DELT_FLG"));
				param.put("agmt_scg_rt_div_cd", rs_Rate.getString("AGMT_SCG_RT_DIV_CD"));
				param.put("agmt_exp_dt", rs_Rate.getString("AGMT_EXP_DT"));
				//Correction에서 체크박스를 해제 했을 경우 (Duplication이 아니라도 체크후 바로 해제했을 경우에도 삭제되상이 된다.)
				new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgRateDelUSQL(), param, param);
				
				//Surcharge Rate History
				if (sDupChk.length()>0) { //이미 rate가 존재할 경우
					new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgRateHisDelUSQL(), param, param);
				}
				
//				//Correction에서 체크박스를 해제 했을 경우 (Duplication이 아니라도 체크후 바로 해제했을 경우에도 삭제되상이 된다.)
//				new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgRateDSQL(), param, param);
//				//Surcharge Rate History
//				if (sDupChk.length()>0) { //이미 rate가 존재할 경우
//				    new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgRateHisCSQL(), param, param);
//				}
			}
			//INSERT, UPDATE를 한다.
			param.put("chk_delt", "N");
			rs_Rate = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrScgAgmtScgRateRSQL(), param, param);
			for(int k=0;rs_Rate.next();k++) {
				sDupChk = rs_Rate.getString("TRSP_AGMT_SCG_RT_SEQ");
				param.put("trsp_agmt_ofc_cty_cd", rs_Rate.getString("TRSP_AGMT_OFC_CTY_CD"));
				param.put("trsp_agmt_seq", rs_Rate.getString("TRSP_AGMT_SEQ"));
				param.put("eff_fm_dt", rs_Rate.getString("EFF_FM_DT"));
				param.put("eff_to_dt", rs_Rate.getString("EFF_TO_DT"));
				param.put("to_wgt", rs_Rate.getString("TO_WGT"));
				param.put("wgt_meas_ut_cd", rs_Rate.getString("WGT_MEAS_UT_CD"));
				param.put("curr_cd", rs_Rate.getString("CURR_CD"));
				param.put("trsp_one_wy_rt", rs_Rate.getString("TRSP_ONE_WY_RT"));
				param.put("trsp_rnd_rt", rs_Rate.getString("TRSP_RND_RT"));
				param.put("trsp_agmt_eq_tp_sz_cd", rs_Rate.getString("TRSP_AGMT_EQ_TP_SZ_CD"));
				param.put("trsp_agmt_rt_tp_ser_no", rs_Rate.getString("TRSP_AGMT_RT_TP_SER_NO"));
				param.put("trsp_agmt_scg_nod_seq", rs_Rate.getString("TRSP_AGMT_SCG_NOD_SEQ"));
				param.put("trsp_agmt_scg_rt_seq", rs_Rate.getString("TRSP_AGMT_SCG_RT_SEQ"));
				param.put("eq_knd_cd", rs_Rate.getString("EQ_KND_CD"));
				param.put("delt_flg", rs_Rate.getString("DELT_FLG"));
				param.put("agmt_scg_rt_div_cd", rs_Rate.getString("AGMT_SCG_RT_DIV_CD"));
				
				if (sDupChk.length()>0) { //이미 rate가 존재할 경우
					param.put("trsp_agmt_scg_rt_seq", rs_Rate.getString("TRSP_AGMT_SCG_RT_SEQ"));
				}else{
					rs_Seq = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOMultiCorrRateAgmtEqRateSeqRSQL(), param, param);
					if (rs_Seq.next()) sEqSeq = rs_Seq.getString("EQ_RT_SEQ");
					param.put("trsp_agmt_scg_rt_seq", sEqSeq);
				}
				
				if (sDupChk.length()>0) { //이미 rate가 존재할 경우
					new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgRateUSQL(), param, param);
				}else{
					new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgRateCSQL(), param, param);
				}
				//Surcharge Rate History
				new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAOMultiCorrScgAgmtScgRateHisCSQL(), param, param);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return event;
	}
	
	/**
	 * Agreement Rate정보 삭제 처리
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void deleteCorrScgAgmt(EsdTrs0221Event event) throws DAOException {
		DBRowSet rs_Rate     = null;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("trsp_tmp_seq",event.getTrspAgmtTmpSeq());
		param.put("fm_account_ofc_cd", 	event.getFm_account_ofc_cd());
		param.put("fm_account_usr_id", 	event.getFm_account_usr_id());
		try{
			rs_Rate = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAODeleteCorrScgAgmtRSQL(), param, param);
			for(int k=0;rs_Rate.next();k++) {
				param.put("trsp_agmt_ofc_cty_cd", rs_Rate.getString("TRSP_AGMT_OFC_CTY_CD"));
				param.put("trsp_agmt_seq", rs_Rate.getString("TRSP_AGMT_SEQ"));
				param.put("trsp_agmt_rt_tp_ser_no", rs_Rate.getString("TRSP_AGMT_RT_TP_SER_NO"));
				param.put("trsp_agmt_scg_nod_seq", rs_Rate.getString("TRSP_AGMT_SCG_NOD_SEQ"));
				param.put("trsp_agmt_scg_rt_seq", rs_Rate.getString("TRSP_AGMT_SCG_RT_SEQ"));
				param.put("agmt_exp_dt", rs_Rate.getString("AGMT_EXP_DT"));

				//History 자료를 DELETE로 UPDATE한다.
				new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAODeleteCorrScgAgmtHisUSQL(), param, param);
				
				new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAODeleteCorrScgAgmtUSQL(), param, param);		
				
//				//데이타를 삭제하기 전에 History 테이블에 기록한다.
//				new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAODeleteCorrScgAgmtHisCSQL(), param, param);
//				
//				new SQLExecuter("DEFAULT").executeUpdate(new AgreementImportDBDAODeleteCorrScgAgmtDSQL(), param, param);
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
	 * Agreement Contract Office 권한체크<br>
	 *
	 * @param event EsdTrs0221Event
	 * @param account SignOnUserAccount
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAuthChk(EsdTrs0221Event event, SignOnUserAccount account) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("login_ofc_cd", account.getOfc_cd());

		/* 로그인 오피스로 해당 오피스의 상위/하위 오피스 리스트를 조회 */
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementImportDBDAOSearchAuthChkRSQL(), param, param);
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
	 * @param sparameter
	 * @param sSeperate
	 * @return
	 */
	public String[] seperationParameterStr(String sparameter, String sSeperate) {
		String[] arreq = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arreq[j++] = st.nextToken();
			}
		}
		return arreq;
	}
	
}

