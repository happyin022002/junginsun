/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CodSimulateBCImpl.java
 *@FileTitle : Change POD
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.24
 *@LastModifier : 채창호
 *@LastVersion : 1.0
 * 2009.08.24 채창호
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.10.12 김상수 [CHM-201006403-01] Session 정보 관련 수정 [getCre_Usr_id()을 getUsrID()으로 변경] 
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.integration.CodSimulateDBDAO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012MultiVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0140ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrVslLdisPlnCodTmpVO;
import com.hanjin.syscommon.common.table.EqrVslPlnCodQtyVO;

/**
 * ALPS-SimulationManage Business Logic Command Interface<br>
 * - ALPS-SimulationManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Chae Change Ho
 * @see EventResponse 참조
 * @since J2EE 1.6
 */
public class CodSimulateBCImpl extends BasicCommandSupport implements CodSimulateBC {

	// Database Access Object
	private transient CodSimulateDBDAO dbDao = null;

	/**
	 * CodSimulateBCImpl 객체 생성<br>
	 * CodSimulateDBDAO를 생성한다.<br>
	 */
	public CodSimulateBCImpl() {
		dbDao = new CodSimulateDBDAO();
	}
	/**
	 * [TMP테이블]을 [조회] 합니다.<br>
	 * TMP 테이블에 해당 REPO_PLN_ID가 존해하는가를 확인하고 
	 * user_id와 수정시간을 찾아서 리턴해준다.
	 * 
	 * @param eesEqr0012ConditionVO EesEqr0012ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchKeyRepoPlanInfo(EesEqr0012ConditionVO eesEqr0012ConditionVO) throws EventException {
		try {
			return dbDao.searchKeyRepoPlanInfo(eesEqr0012ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [Change POD화면에서 조건으로]을 [조회] 합니다.<br>
	 * 
	 * @param eesEqr0012ConditionVO EesEqr0012ConditionVO
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchRepoPlanInfo(EesEqr0012ConditionVO eesEqr0012ConditionVO ,SignOnUserAccount account) throws EventException {
		try {
			String user_id = account.getUsr_id();
			dbDao.deleteCodTempQty(eesEqr0012ConditionVO);
			dbDao.deleteCodTemp(eesEqr0012ConditionVO);
			dbDao.insertToCodTemp(eesEqr0012ConditionVO ,user_id );
			dbDao.insertToCodTempQty(eesEqr0012ConditionVO , user_id);
			return dbDao.searchRepoPlanInfo(eesEqr0012ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [FM_ECC_CD 정보와 출발시간, 도착시간]을 [조회] 합니다.<br>
	 * 
	 * @param eesEqr0012ConditionVO EesEqr0012ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrRepoInOutPlanVvdInfo(EesEqr0012ConditionVO eesEqr0012ConditionVO) throws EventException {
		try {
			return dbDao.searchCntrRepoInOutPlanVvdInfo(eesEqr0012ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [Lane ]을 [조회] 합니다.<br>
	 * 
	 * @param eesEqr0012ConditionVO EesEqr0012ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchLaneExistInfo(EesEqr0012ConditionVO eesEqr0012ConditionVO) throws EventException {
		try {
			return dbDao.searchLaneExistInfo(eesEqr0012ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * 멀티 이벤트 처리<br>
	 * [EES_EQR_0012 : Change POD 수정, 삭제]<br>
	 * 
	 * @param EqrVslLdisPlnCodTmpVO	EqrVslLdisPlnCodTmpVO[] -- 사용되지 않음..
	 * @param eqrVslPlnCodQtyVO		EqrVslPlnCodQtyVO[] 	-- 사용되지 않음..
	 * @param conditionVO			EesEqr0012ConditionVO
	 * @param mutiVO				EesEqr0012MultiVO[]
	 * @param account				SignOnUserAccount
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void modifyRepoPlanInfo(EqrVslLdisPlnCodTmpVO[] eqrVslLdisPlnCodTmpVO, EqrVslPlnCodQtyVO[] eqrVslPlnCodQtyVO ,EesEqr0012ConditionVO conditionVO ,EesEqr0012MultiVO[] mutiVO,SignOnUserAccount account) throws EventException{
		//다건 데이터를 처리가 불가능 하여 건당으로 처리 
		String new_pln_seq = null;
		String past_flg    = "";
		String pre_ts_flg  = "";
		String[] tyszall = conditionVO.getTpsztypeall().split(",");

		log.info("=====tpsz====" +conditionVO.getTpsztypeall());
		List volList 	 = null;
		int vol          = 0;    // type size별 vol 수량

		List flagList	 = null;
		String flag      = "";

		List fixList     = null;
		String fix          =  null;
		EesEqr0012MultiVO vo = null;

		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			for(int i = 0 ; i < mutiVO.length ; i++){
				vo = (EesEqr0012MultiVO)mutiVO[i];
				volList  = vo.getVolList();
				flagList = vo.getFlagList();
				fixList  = vo.getFixList();
				if (vo.getToEccCdFlg().equals("Y")) {
					// DB Data Dup Check
					if (dbDao.isDupVslTmpData(vo) > 0) {
						throw new EventException(new ErrorHandler("EQR10035").getMessage());
					} else {
						new_pln_seq = dbDao.getNextPlnSeq("EQR_VSL_LDIS_PLN_COD_TMP", vo.getRepoPlanId(), vo.getPlnYrwk()).getResultString();
					}
			
					if (vo.getPastRepoPlnFlg().equals("1")) {
						past_flg ="Y";
					} else {
						past_flg ="N";
					}
			
					if (vo.getLdisTsFlg().equals("")) {
						pre_ts_flg ="N";
					} else {
						pre_ts_flg = vo.getLdisTsFlg();
					}
					//새로 입력된 PLAN을 입력
					param.put("repo_pln_id",vo.getRepoPlanId());
					param.put("pln_yrwk", vo.getPlnYrwk());
					param.put("pln_seq", new_pln_seq);
					param.put("upd_usr_id",account.getUsr_id()) ;
					param.put("pln_seq1", new_pln_seq);
					param.put("vsl_lane_cd", vo.getLaneCd());
					param.put("vsl_cd" , vo.getVslCd());
					param.put("skd_voy_no", vo.getSkdVoyNo());
					param.put("skd_dir_cd", vo.getSkdDirCd());
					param.put("fm_ecc_cd", vo.getFmEccCd());
					param.put("fm_etd_dt", vo.getFmEtdDt());
					param.put("fm_yard", vo.getFmYard());
					param.put("to_ecc_cd", vo.getToEccCd());
					param.put("to_eta_dt", vo.getToEtbDt());
					param.put("to_yard"  , vo.getToYard());
					param.put("past_repo_pln_flg", past_flg);
					param.put("pre_pln_ts_flg", pre_ts_flg);
					param.put("cre_usr_id", account.getUsr_id());
					param.put("upd_usr_id", account.getUsr_id());
					dbDao.updateCodTmp(param , velParam);
			
					// 목적지가 변경이 일어나면 기존 목적지의 수량의 값을 모두 0으로 업데이트를 한다.
			
					for (int k=0 ; k < tyszall.length ; k++) {
						param.put("repo_pln_id", vo.getRepoPlanId());
						param.put("pln_yrwk", vo.getPlnYrwk());
						param.put("pln_seq", vo.getPlanSeq());
						param.put("cntr_tpsz_cd", tyszall[k]);
						dbDao.updateCodTmpQTyZero(param, velParam);
					}
			
					// 새로 입력된  PLAN에 수량을  INSERT을 한다. 
					for (int k=0 ; k < tyszall.length ; k++) {
						vol    = Integer.parseInt((String)volList.get(k));// 볼륨
						flag    = (String)flagList.get(k);	// save flag
						fix     = (String)fixList.get(k);
						// SAVE 가 "Y" 부분만 INSERT를 한다.
						if (flag.equals("Y")){
							param.put("repo_pln_id", vo.getRepoPlanId());
							param.put("pln_yrwk", vo.getPlnYrwk());
							param.put("pln_seq",  new_pln_seq);
							param.put("cntr_tpsz_cd", tyszall[k]);
							param.put("pln_seq1", new_pln_seq);
							param.put("cntr_qty" , vol);
							param.put("upd_usr_id" , account.getUsr_id());
							param.put("cre_usr_id" , account.getUsr_id());
							param.put("fix_vol",   fix);
							param.put("fix_ecc_cd", vo.getFixToEcc());
							dbDao.updateCodTmpQty(param, velParam);
						}
					}
				} else {
					param.put("repo_pln_id",vo.getRepoPlanId());
					param.put("pln_yrwk", vo.getPlnYrwk());
					param.put("pln_seq", vo.getPlanSeq());
					param.put("upd_usr_id",account.getUsr_id()) ;
					param.put("pln_seq1", vo.getPlanSeq());
					param.put("vsl_lane_cd", vo.getLaneCd());
					param.put("vsl_cd" , vo.getVslCd());
					param.put("skd_voy_no", vo.getSkdVoyNo());
					param.put("skd_dir_cd", vo.getSkdDirCd());
					param.put("fm_ecc_cd", vo.getFmEccCd());
					param.put("fm_etd_dt", vo.getFmEtdDt());
					param.put("fm_yard" , vo.getFmYard());
					param.put("to_ecc_cd", vo.getToEccCd());
					param.put("to_eta_dt", vo.getToEtbDt());
					param.put("to_yard",   vo.getToYard());
					param.put("past_repo_pln_flg", past_flg);
					param.put("pre_pln_ts_flg", pre_ts_flg);
					param.put("cre_usr_id", account.getUsr_id());
					param.put("upd_usr_id", account.getUsr_id());
			
					for (int k=0 ; k < tyszall.length ; k++) {
						vol    = Integer.parseInt((String)volList.get(k));// 볼륨
						flag    = (String)flagList.get(k);	// save flag
						fix     = (String)fixList.get(k);
				
						if (flag.equals("Y")){
							param.put("repo_pln_id", vo.getRepoPlanId());
							param.put("pln_yrwk", vo.getPlnYrwk());
							param.put("pln_seq",  vo.getPlanSeq());
							param.put("cntr_tpsz_cd", tyszall[k]);
							param.put("pln_seq1", vo.getPlanSeq());
							param.put("cntr_qty" , vol);
							param.put("upd_usr_id" , account.getUsr_id());
							param.put("cre_usr_id" , account.getUsr_id());
							param.put("fix_vol",   fix);
							param.put("fix_ecc_cd", vo.getFixToEcc());
							dbDao.updateCodTmpQty(param, velParam);
						}
					}
				}
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * [EES_EQR_0012 : Change POD 확정 적용 ]<br>
	 * 
	 * @param conditionVO EesEqr0012ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyComfirmRepoPlanInfo( EesEqr0012ConditionVO conditionVO ,SignOnUserAccount account) throws EventException{
		
		String repo_pln_Id = Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();
		String[] cost_cod_amt = new String[3];
		float cntr_qty_orign = 0;
		String gubun_flg = "P";
		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			// EQR_VSL_PLN_COD_QTY 테이블의 특정 REPO PLAN ID 데이터를 NULL로 변경
			param.put("repo_pln_id", repo_pln_Id);
			dbDao.updateCodTempToNull(param, velParam);
			// COD_SIM_FLG가 Y인 테이터를 조회하여 가져온다.
			CommonRsVO reVO = dbDao.searchCodTargetData(param, velParam);
			// PLN에 업데이트를 한다.
			while(reVO.getDbRowset().next()){
				// unit Cost을 가져 온다. 
            	// cost_cod_amt[0] : FM_COST  가져온다.
            	// cost_cod_amt[1] : TO_COST  가져온다.
            	// cost_cod_amd[2] : unit_cost 가져온다.
				cost_cod_amt = dbDao.searchUnitCost(gubun_flg, reVO.getDbRowset().getString("FM_ECC_CD"), reVO.getDbRowset().getString("TO_ECC_CD"),reVO.getDbRowset().getString("TRSP_MOD_CD"),reVO.getDbRowset().getString("CNTR_TPSZ_CD")).getResultStrArray();
				
				// 해당 파라메터를 셋팅을 한다.
				param.put("repo_pln_id", reVO.getDbRowset().getString("REPO_PLN_ID"));
				param.put("pln_yrwk"  , reVO.getDbRowset().getString("PLN_YRWK"));
				param.put("pln_seq", reVO.getDbRowset().getString("PLN_SEQ"));
				param.put("trsp_mod_cd", reVO.getDbRowset().getString("TRSP_MOD_CD"));
				param.put("vsl_lane_cd", reVO.getDbRowset().getString("VSL_LANE_CD"));
				param.put("vsl_cd", reVO.getDbRowset().getString("VSL_CD"));
				param.put("skd_voy_no", reVO.getDbRowset().getString("SKD_VOY_NO"));
				param.put("skd_dir_cd", reVO.getDbRowset().getString("SKD_DIR_CD"));
				param.put("fm_ecc_cd", reVO.getDbRowset().getString("FM_ECC_CD"));
				param.put("fm_etd_dt", reVO.getDbRowset().getString("FM_ETD_DT"));
				param.put("fm_yard", reVO.getDbRowset().getString("FM_YD_CD"));
				param.put("to_ecc_cd", reVO.getDbRowset().getString("TO_ECC_CD"));
				param.put("to_etb_dt", reVO.getDbRowset().getString("TO_ETB_DT"));
				param.put("to_yard", reVO.getDbRowset().getString("TO_YD_CD"));
				param.put("past_repo_pln_flg",reVO.getDbRowset().getString("PAST_REPO_PLN_FLG"));
				param.put("pre_pln_ts_flg", reVO.getDbRowset().getString("PRE_PLN_TS_FLG"));
				param.put("cntr_tpsz_cd", reVO.getDbRowset().getString("CNTR_TPSZ_CD"));
				param.put("cntr_qty", reVO.getDbRowset().getInt("CNTR_QTY"));
				// Modified By 2010.10.12 김상수 [CHM-201006403-01] Session 정보 관련 수정 [ getCre_Usr_id()을 getUsrID()으로 변경]
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id",  account.getUsr_id());
				// INSERT 시 수량이 0인 경우 lodg_port_cost_amt와 dchg_port_cost_amt의 unit Cost을 구하기 위해서 vol값을 1로 변경  수량은 변경 없음 
             	if (reVO.getDbRowset().getString("CNTR_QTY").equals("0")){
             		cntr_qty_orign  = 1;
             	}else {
             		cntr_qty_orign = reVO.getDbRowset().getFloat("CNTR_QTY");
             	}
             	if (!reVO.getDbRowset().getString("PAST_REPO_PLN_FLG").equals("Y")){
             		param.put("lodg_dchg_cost_amt", (reVO.getDbRowset().getFloat("CNTR_QTY") * Float.parseFloat(cost_cod_amt[0])) +(reVO.getDbRowset().getFloat("CNTR_QTY") * Float.parseFloat(cost_cod_amt[1])));
                 	param.put("pln_uc_amt", Float.parseFloat(cost_cod_amt[0]) + Float.parseFloat(cost_cod_amt[1]));  
                 	param.put("lodg_port_cost_amt", cntr_qty_orign * Float.parseFloat(cost_cod_amt[0]));
                 	param.put("dchg_port_cost_amt", cntr_qty_orign * Float.parseFloat(cost_cod_amt[1]));
                 	
             	} else {
					param.put("lodg_dchg_cost_amt", (reVO.getDbRowset().getFloat("CNTR_QTY") * Float.parseFloat(cost_cod_amt[0])) +(reVO.getDbRowset().getFloat("CNTR_QTY") * Float.parseFloat(cost_cod_amt[1])));
					param.put("pln_us_amt", Float.parseFloat(cost_cod_amt[0]) + Float.parseFloat(cost_cod_amt[1]));  
					param.put("lodg_port_cost_amt", cntr_qty_orign * Float.parseFloat(cost_cod_amt[0]));
					param.put("dchg_port_cost_amt", cntr_qty_orign * Float.parseFloat(cost_cod_amt[1]));
                     	
                }
             	param.put("pre_pln_cntr_qty", reVO.getDbRowset().getInt("PRE_PLN_CNTR_QTY"));
                param.put("cod_sim_flg", reVO.getDbRowset().getString("COD_SIM_FLG"));
                param.put("cod_dchg_pln_flg", reVO.getDbRowset().getString("COD_DCHG_PLN_FLG"));
                param.put("pre_pln_dchg_loc_cd", reVO.getDbRowset().getString("PRE_PLN_DCHG_LOC_CD"));
                
                // PLN 테이블에 insert를 한다.
                dbDao.mergeVesselPlanCOD(param, velParam);
                dbDao.mergeVesselPlanQtyCOD(param, velParam);
                
			}

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [Change POD화면에서 조건으로]을 [조회] 합니다.<br>
	 * 
	 * @param eesEqr0012ConditionVO EesEqr0012ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchPOLChangePlanCompare(EesEqr0012ConditionVO eesEqr0012ConditionVO ) throws EventException {
		try {
			return dbDao.searchPOLChangePlanCompare(eesEqr0012ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [Change POD화면에서 조건으로]을 [조회] 합니다.<br>
	 * 
	 * @param eesEqr0012ConditionVO EesEqr0012ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchPODChangePlanCompare(EesEqr0012ConditionVO eesEqr0012ConditionVO ) throws EventException {
		try {
			return dbDao.searchPODChangePlanCompare(eesEqr0012ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [bay PLN화면에서 조건으로]을 [조회] 합니다.<br>
	 * 
	 * @param conditionVO EesEqr0140ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchBayPlan(EesEqr0140ConditionVO conditionVO) throws EventException {
		String vvd			= conditionVO.getVvd();
		String bayport		= conditionVO.getBayport();
		String search_port	= "";
	
		try {
			if( bayport.equals("")){
				search_port= dbDao.searchBasisPort(vvd).getResultString();
			} else {
				search_port = bayport;
			}
			return dbDao.searchBayPlan(conditionVO , search_port);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}