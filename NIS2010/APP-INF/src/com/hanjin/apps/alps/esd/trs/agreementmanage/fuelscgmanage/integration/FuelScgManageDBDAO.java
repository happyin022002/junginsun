/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : FuelScgManageDBDAO.java
*@FileTitle : Fuel Surcharge Mamange
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.15
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.DummyAgmtRateVO;
import com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.basic.ContractAttachBCImpl;
import com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.event.EsdTrs0280Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * Fuel Surcharge (FUA) Correction 에 대한 DB 처리를 담당<br>
 * - Fuel Surcharge (FUA) Correction Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SHIN DONG IL
 * @see ContractAttachBCImpl 참조
 * @since J2EE 1.6
 */


public class FuelScgManageDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *  Fuel Surcharge (FUA) Correction에 Grid 를 조회 합니다.<br>
	 * 
	 * @param event EsdTrs0280Event
	 * @return dbRowset
	 * @throws DAOException
	 */
	
	public DBRowSet searchFuelSurchargeList(EsdTrs0280Event event) throws DAOException {
		DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("fm_cmd", event.getFormCommand().getCommand());
		param.put("fm_agmt_no", event.getFm_agmtno());
        
		List<String> arr_ctrt_office = new ArrayList<String>();
		String ctrt_office = event.getFm_ctrt_ofc_cd();
		arr_ctrt_office = this.seperationParameter(ctrt_office, ","); 
		param.put("arr_ctrt_office", arr_ctrt_office);
		
		param.put("fm_vndr_prmry_seq", event.getFm_vndr_prmry_seq());
		
		param.put("fm_trsp_cost_mod_cd",event.getFm_trsp_cost_mod_cd());
		param.put("fm_agmt_trsp_tp_cd",event.getFm_agmt_trsp_tp_cd());
		param.put("fm_effective_agmt",event.getFm_effective_agmt());

		try {

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new FuelScgManageDBDAOSearchFUASurchargeListRSQL(), param, param);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
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
			dRs = new SQLExecuter("DEFAULT").executeQuery(new FuelScgManageDBDAOCreateNewAgmtTmpSeqRSQL(), null, null);
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
	 * @param account 
	 * @return event
	 * @throws DAOException
	 */
	public EsdTrs0280Event insertFeulScgAgmtVerifyData(EsdTrs0280Event event,SignOnUserAccount account) throws DAOException {
		DummyAgmtRateVO[] model = event.getDummyAgmtRateVOs();
		Collection<DummyAgmtRateVO> insModels = new ArrayList<DummyAgmtRateVO>();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("trsp_tmp_seq",event.getTrspAgmtTmpSeq());
//		param.put("fm_agmtno",event.getFm_agmtno());
//		param.put("fm_trsp_agmt_rt_tp_cd",event.getFm_trsp_agmt_rt_tp_cd());
//		param.put("fm_eq_knd_cd",event.getFm_eq_knd_cd());
//		String fm_eq_knd_cd = event.getFm_eq_knd_cd();
		
		param.put("ofc_cd", 	account.getOfc_cd());
		param.put("usr_id", 	account.getUsr_id());
		
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
				if (model[i].getEqO7().equals("1")) { //O7 2018.05.08 추가 [CSR #3841]
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

					}
				}
			}

			new SQLExecuter("DEFAULT").executeBatch(new FuelScgManageDBDAOInsertAgreementVerifyDataCSQL(),insModels, param, param);
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
	 * @return dRs DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet verifyFuelScgAgmt(EsdTrs0280Event event) throws DAOException {
		
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("trsp_tmp_seq",event.getTrspAgmtTmpSeq());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new FuelScgManageDBDAOVerifyFuelScgAgmtRSQL(), param, param);

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
	 * @return event
	 * @throws DAOException
	 */
	public EsdTrs0280Event deleteFuelScgAgmtVerifyData(EsdTrs0280Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("trsp_tmp_seq", event.getTrspAgmtTmpSeq());
			new SQLExecuter("DEFAULT").executeUpdate(new FuelScgManageDBDAODeleteFuelScgAgmtVerifyDataDSQL(), param, param);
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
	 * Agreement FUA Surcharge Rate 정보를 수정
	 * 
	 * @param event
	 * @param account 
	 * @return event
	 * @throws DAOException
	 * @throws Exception
	 */
	public EsdTrs0280Event multiCorrFuelScgRateAgmt(EsdTrs0280Event event,SignOnUserAccount account) throws DAOException,Exception {
		DBRowSet rs_Seq      = null;
		DBRowSet rs_Rate     = null;
		String sDupChk = "";
		String sEqSeq  = "";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("trsp_tmp_seq",event.getTrspAgmtTmpSeq());
		param.put("fm_agmtno",event.getFm_agmtno());
		param.put("usr_id", account.getUsr_id());
		param.put("ofc_cd", account.getOfc_cd());

		try{

			//INSERT, UPDATE 하기전에 체크박스 해제된 데이타를 모두 삭제처리한다.
			param.put("chk_delt", "Y");
			rs_Rate = new SQLExecuter("DEFAULT").executeQuery(new FuelScgManageDBDAOMultiCorrScgAgmtScgRateRSQL(), param, param);
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
				new SQLExecuter("DEFAULT").executeUpdate(new FuelScgManageDBDAOMultiCorrScgAgmtScgRateDelUSQL(), param, param);
				
				//Surcharge Rate History
				if (sDupChk.length()>0) { //이미 rate가 존재할 경우
					new SQLExecuter("DEFAULT").executeUpdate(new FuelScgManageDBDAOMultiCorrScgAgmtScgRateHisDelUSQL(), param, param);
				}
			}
			//INSERT, UPDATE를 한다.
			param.put("chk_delt", "N");
			rs_Rate = new SQLExecuter("DEFAULT").executeQuery(new FuelScgManageDBDAOMultiCorrScgAgmtScgRateRSQL(), param, param);
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
					rs_Seq = new SQLExecuter("DEFAULT").executeQuery(new FuelScgManageDBDAOMultiCorrRateAgmtEqRateSeqRSQL(), param, param);
					if (rs_Seq.next()) sEqSeq = rs_Seq.getString("EQ_RT_SEQ");
					param.put("trsp_agmt_scg_rt_seq", sEqSeq);
				}
				
				if (sDupChk.length()>0) { //이미 rate가 존재할 경우
					new SQLExecuter("DEFAULT").executeUpdate(new FuelScgManageDBDAOMultiCorrScgAgmtScgRateUSQL(), param, param);
				}else{
					new SQLExecuter("DEFAULT").executeUpdate(new FuelScgManageDBDAOMultiCorrScgAgmtScgRateCSQL(), param, param);
				}
				new SQLExecuter("DEFAULT").executeUpdate(new FuelScgManageDBDAOMultiCorrScgAgmtScgRateHisCSQL(), param, param);
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
	 * FUA SCG Agreement Rate정보 삭제 처리
	 * @param event
	 * @param account
	 * @throws DAOException
	 */
	public void deleteCorrFuelScgRateAgmt(EsdTrs0280Event event, SignOnUserAccount account) throws DAOException {
		DBRowSet rs_Rate     = null;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("trsp_tmp_seq",event.getTrspAgmtTmpSeq());
		param.put("ofc_cd",		 account.getOfc_cd());
		
		try{
			rs_Rate = new SQLExecuter("DEFAULT").executeQuery(new FuelScgManageDBDAODeleteCorrScgAgmtRSQL(), param, param);
			for(int k=0;rs_Rate.next();k++) {
				param.put("trsp_agmt_ofc_cty_cd", 	rs_Rate.getString("TRSP_AGMT_OFC_CTY_CD"));
				param.put("trsp_agmt_seq", 			rs_Rate.getString("TRSP_AGMT_SEQ"));
				param.put("trsp_agmt_rt_tp_ser_no", rs_Rate.getString("TRSP_AGMT_RT_TP_SER_NO"));
				param.put("trsp_agmt_scg_nod_seq", 	rs_Rate.getString("TRSP_AGMT_SCG_NOD_SEQ"));
				param.put("trsp_agmt_scg_rt_seq", 	rs_Rate.getString("TRSP_AGMT_SCG_RT_SEQ"));
				param.put("agmt_exp_dt", 			rs_Rate.getString("AGMT_EXP_DT"));

				param.put("usr_id",					account.getUsr_id());

				//History 자료를 DELETE로 UPDATE한다.
				new SQLExecuter("DEFAULT").executeUpdate(new FuelScgManageDBDAODeleteCorrScgAgmtHisUSQL(), param, param);
				
				new SQLExecuter("DEFAULT").executeUpdate(new FuelScgManageDBDAODeleteCorrScgAgmtUSQL(), param, param);
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
	 * setting vo
	 * 
	 * @param from_vo
	 * @param to_vo
	 */
	public void setVos(DummyAgmtRateVO from_vo, DummyAgmtRateVO to_vo) {
		to_vo.setAgmtNo(from_vo.getAgmtNo());
		to_vo.setTrspAgmtOfcCtyCd(from_vo.getTrspAgmtOfcCtyCd());
		to_vo.setTrspAgmtSeq(from_vo.getTrspAgmtSeq());
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
	}
	
	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return arrlist
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
}