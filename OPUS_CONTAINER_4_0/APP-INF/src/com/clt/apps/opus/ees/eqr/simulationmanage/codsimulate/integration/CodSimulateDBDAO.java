/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodSimulateDBDAO.java
*@FileTitle : Change POD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.08.24 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.common.Constants;
import com.clt.apps.opus.ees.eqr.common.Utils;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.integration.CommonDBDAOGetNextPlnSeqRSQL;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration.CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostCheckRSQL;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration.CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostECCRSQL;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration.CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostLCCRSQL;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.basic.CodSimulateBCImpl;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012ConditionVO;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012MultiVO;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0140ConditionVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterInquiryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 *  CodSimulateDBDAO <br>
 * - -SimulationManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Chae Change Ho
 * @see CodSimulateBCImpl 참조
 * @since J2EE 1.6
 */
public class CodSimulateDBDAO extends DBDAOSupport {
		
	/**
	 * [배포가 된 REPO_PLN_ID] 정보를 [조회] 합니다.<br>
	 * 
	 * @param eesEqr0012ConditionVO EesEqr0012ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchKeyRepoPlanInfo(EesEqr0012ConditionVO eesEqr0012ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO returnVO = new CommonRsVO();
		String keyinfo[] = new String[3];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        String repo_pln_id =  Constants.REPO_WORD+eesEqr0012ConditionVO.getYyyyww()+Constants.REPO_WEEK+eesEqr0012ConditionVO.getSeq();
		try{
			param.put("repo_pln_id", repo_pln_id);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAOSearchCODTempMasterRSQL(), param, velParam);
			if(dbRowset.next()){
				keyinfo[0] = dbRowset.getString("CRE_USR_ID").trim();
				keyinfo[1] = dbRowset.getString("CRE_DT").trim();
				keyinfo[2] = dbRowset.getString("REPO_PLN_ID").trim();
				log.debug("===>" + dbRowset.getString("CRE_USR_ID").trim());
			}else {
				keyinfo[0] = "";
				keyinfo[1] = "";
				keyinfo[2] = "";
			}
			returnVO.setResultStrArray(keyinfo);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, searchKeyRepoPlanInfo .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	 
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * @param EesEqr0012MultiVO eesEqr0012MultiVO
	 * @exception DAOException
	 */
	public void  deleteCodTemp(EesEqr0012MultiVO eesEqr0012MultiVO) throws DAOException {
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String repo_pln_id = eesEqr0012MultiVO.getRepoPlanId();
		String plan_seq = eesEqr0012MultiVO.getPlanSeq();
		
		try{
			param.put("repo_pln_id", repo_pln_id);
			param.put("plan_seq", plan_seq);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CodSimulateDBDAODeleteCodTempDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
			throw new DAOException("Fail to delete No SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param EesEqr0012MultiVO eesEqr0012MultiVO
	 * @exception DAOException
	 */
	public void  deleteCodTempQty(EesEqr0012MultiVO eesEqr0012MultiVO) throws DAOException {
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String repo_pln_id = eesEqr0012MultiVO.getRepoPlanId();
		String plan_seq = eesEqr0012MultiVO.getPlanSeq();
		
		try{
			param.put("repo_pln_id", repo_pln_id);
			param.put("plan_seq", plan_seq);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CodSimulateDBDAODeleteCodTempQtyDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
			throw new DAOException("Fail to delete No SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param eesEqr0012ConditionVO EesEqr0012ConditionVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void  insertToCodTemp(EesEqr0012ConditionVO eesEqr0012ConditionVO , String user_id) throws DAOException {
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String repo_pln_id =  Constants.REPO_WORD+eesEqr0012ConditionVO.getYyyyww()+Constants.REPO_WEEK+eesEqr0012ConditionVO.getSeq();
		try{
			param.put("repo_pln_id", repo_pln_id);
			param.put("cre_user_id", user_id);
			param.put("upd_user_id",user_id );
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CodSimulateDBDAOInsertToCodTempCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param eesEqr0012ConditionVO EesEqr0012ConditionVO
	 * @param user_id String
	 * @exception DAOException
	 */
	public void  insertToCodTempQty(EesEqr0012ConditionVO eesEqr0012ConditionVO , String user_id) throws DAOException {
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String repo_pln_id =  Constants.REPO_WORD+eesEqr0012ConditionVO.getYyyyww()+Constants.REPO_WEEK+eesEqr0012ConditionVO.getSeq();
		try{
			param.put("repo_pln_id", repo_pln_id);
			param.put("cre_user_id", user_id);
			param.put("upd_user_id",user_id );
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CodSimulateDBDAOInsertToCodTempQtyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [EES_EQR_0012] 신규생성되는 Repo ID에 대한 정보를 조회<br>
	 * 
	 * @param conditionVO EesEqr0012ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchRepoPlanPreInfo(EesEqr0012ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO returnVO = new CommonRsVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String repo_pln_id =  Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();

		String arrFmEccCd = Utils.convertStr(conditionVO.getFmecccd());
		String arrToEccCd = Utils.convertStr(conditionVO.getToecccd());
		String fmType     = conditionVO.getFmtype();
		String toType     = conditionVO.getTotype();
		String fmyrwk     = conditionVO.getFmplnyr() + conditionVO.getFmplnwk();
		String toyrwk     = conditionVO.getTotoplnyr() + conditionVO.getTotoplnwk();
		String arrlane    = Utils.convertStr(conditionVO.getLane());
		String arrtrad    = Utils.convertStr(conditionVO.getTrade());
		String arrvvd     = Utils.convertStr(conditionVO.getVvd());
		String conti      = conditionVO.getConti();
		String arrCntrTpsz1 = Utils.convertStr(conditionVO.getCntrtpszcd());
		ArrayList<String> arrCntrTpsz = (ArrayList<String>) Utils.replaceStrToList(conditionVO.getCntrtpszcd());

		try{
			param.put("repo_pln_id", repo_pln_id);
			param.put("conti", conti);
			param.put("fm_yrwk", fmyrwk);
			param.put("to_yrwk", toyrwk);
			velParam.put("arrtpszcd", arrCntrTpsz);
			velParam.put("fmecccd", arrFmEccCd);
			velParam.put("fmtype", fmType);
			velParam.put("arrfmecccd", arrFmEccCd);
			velParam.put("totype", toType);
			velParam.put("toecccd", arrToEccCd);
			velParam.put("arrtoecccd", arrToEccCd);
			velParam.put("arrcntrtpzcd", arrCntrTpsz1);
			velParam.put("lane", arrlane);
			velParam.put("vvd", arrvvd);
			velParam.put("trade", arrtrad);
			velParam.put("conti", conti);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAOSearchRepoPlanPreInfoRSQL(), param, velParam);
			returnVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}	

	/**
	 * [Change POD의 sheet 1번째] 정보를 [조회] 합니다.<br>
	 * 
	 * @param conditionVO EesEqr0012ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchRepoPlanInfo(EesEqr0012ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO returnVO = new CommonRsVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String repo_pln_id =  Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();

		String arrFmEccCd = Utils.convertStr(conditionVO.getFmecccd());
		String arrToEccCd = Utils.convertStr(conditionVO.getToecccd());
		String fmType     = conditionVO.getFmtype();
		String toType     = conditionVO.getTotype();
		String fmyrwk     = conditionVO.getFmplnyr() + conditionVO.getFmplnwk();
		String toyrwk     = conditionVO.getTotoplnyr() + conditionVO.getTotoplnwk();
		String arrlane    = Utils.convertStr(conditionVO.getLane());
		String arrtrad    = Utils.convertStr(conditionVO.getTrade());
		String arrvvd     = Utils.convertStr(conditionVO.getVvd());
		String conti      = conditionVO.getConti();
		String arrCntrTpsz1 = Utils.convertStr(conditionVO.getCntrtpszcd());
		ArrayList<String> arrCntrTpsz = (ArrayList<String>) Utils.replaceStrToList(conditionVO.getCntrtpszcd());

		try{
			param.put("repo_pln_id", repo_pln_id);
			param.put("conti", conti);
			param.put("fm_yrwk", fmyrwk);
			param.put("to_yrwk", toyrwk);
			param.put("fmecccd", arrFmEccCd);
			param.put("fmtype", fmType);
			param.put("totype", toType);
			param.put("toecccd", arrToEccCd);
			
			velParam.put("arrtpszcd", arrCntrTpsz);
			velParam.put("fmecccd", arrFmEccCd);
			velParam.put("fmtype", fmType);
			velParam.put("arrfmecccd", arrFmEccCd);
			velParam.put("totype", toType);
			velParam.put("toecccd", arrToEccCd);
			velParam.put("arrtoecccd", arrToEccCd);
			velParam.put("arrcntrtpzcd", arrCntrTpsz1);
			velParam.put("lane", arrlane);
			velParam.put("vvd", arrvvd);
			velParam.put("trade", arrtrad);
			velParam.put("conti", conti);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAOSearchCodTempRSQL(), param, velParam);
			returnVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	
	/**
	 * [EQR_SCNR_VSL_SKD 테이블에 스케즐] 정보를 [조회] 합니다.<br>
	 * 
	 * @param eesEqr0012ConditionVO EesEqr0012ConditionVO
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchCntrRepoInOutPlanVvdInfo(EesEqr0012ConditionVO eesEqr0012ConditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO returnVO = new CommonRsVO();
		String keyinfo[] = new String[7];
		StringBuffer inStr  = new StringBuffer();
		StringBuffer inStr1	= new StringBuffer();
		StringBuffer inStr2	= new StringBuffer();
		StringBuffer inStr3	= new StringBuffer();
		
		
		int j			= 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String fmToAt2 = eesEqr0012ConditionVO.getFmtoat2();
		String posCol  = eesEqr0012ConditionVO.getPoscol();
		String eccCdTmp  = eesEqr0012ConditionVO.getCol();
		try{
			param.put("repo_pln_id", eesEqr0012ConditionVO.getRepoPlnId());
			param.put("vsl_cd", eesEqr0012ConditionVO.getVslCd());
			param.put("skd_voy_no", eesEqr0012ConditionVO.getSkdVoyNo());
			param.put("skd_dir_cd",eesEqr0012ConditionVO.getSkdDirCd());
			param.put("vsl_lane_cd",eesEqr0012ConditionVO.getVslLaneCd());
			param.put("vsl_loc_cd", eesEqr0012ConditionVO.getVslLocCd());
			param.put("col", eesEqr0012ConditionVO.getCol());
			param.put("view_sc", eesEqr0012ConditionVO.getViewSc());
			param.put("ofc_cd", account.getOfc_cd());
			if(fmToAt2.equals("0")){
				if(posCol.equals("fm")){
					param.put("pln_yrwk", eesEqr0012ConditionVO.getFmfmplnyrwk2());
				}else{
					param.put("pln_yrwk", eesEqr0012ConditionVO.getTofmplnyrwk2());
				}
			}else{
				if(posCol.equals("fm")){
					param.put("pln_yrwk", eesEqr0012ConditionVO.getAtfmplnyrwk2());
				}else{//to
					param.put("pln_yrwk", eesEqr0012ConditionVO.getAtfmplnyrwk2());
				}
			}
			velParam.put("vsl_loc_cd" ,eesEqr0012ConditionVO.getVslLocCd());
			velParam.put("col" ,eesEqr0012ConditionVO.getCol());
			velParam.put("poscol", eesEqr0012ConditionVO.getPoscol());
			velParam.put("view_sc", eesEqr0012ConditionVO.getViewSc());
			velParam.put("ofc_cd", account.getOfc_cd());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAOSearchCODVskDataRSQL(), param, velParam);
			int k = 0;
			while (dbRowset.next()){
				// CSR NO : N200903060090 의거 변경
				// inStr2.append(((j == 0) ? "" : "|") + rs.getString ("VSL_LOC_CD").replaceAll("&","&amp;")+"\t" + rs.getString("VSL_ETA_DT").trim());
				
				if(eccCdTmp.equals("fm_ecc_cd_tmp")){
					inStr.append(((j == 0) ? "" : "|") + dbRowset.getString ("VSL_LOC_CD").replaceAll("&","&amp;")+"\t" + dbRowset.getString("VSL_ETD_DT").trim());
					inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString ("VSL_LOC_CD").trim());
				} else if(eccCdTmp.equals("to_ecc_cd_tmp")){
					if(!"".equals(eesEqr0012ConditionVO.getFmEtdDate())) {
						if(Integer.parseInt(eesEqr0012ConditionVO.getFmEtdDate()) <= Integer.parseInt(dbRowset.getString("VSL_ETB_DT").trim().substring(0, 10).replaceAll("-", ""))) {
							inStr.append(((k == 0) ? "" : "|") + dbRowset.getString ("VSL_LOC_CD").replaceAll("&","&amp;")+"\t" + dbRowset.getString("VSL_ETB_DT").trim().replaceAll("&","&amp;") +"\t" + dbRowset.getString("POD_USE_FLG").trim());
							inStr1.append(((k == 0) ? "" : "|") + dbRowset.getString ("VSL_LOC_CD").trim());
							k++;
						}
					}else{
						inStr.append(((j == 0) ? "" : "|") + dbRowset.getString ("VSL_LOC_CD").replaceAll("&","&amp;")+"\t" + dbRowset.getString("VSL_ETB_DT").trim().replaceAll("&","&amp;") +"\t" + dbRowset.getString("POD_USE_FLG").trim());
						inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString ("VSL_LOC_CD").trim());
					}
				}
				
				inStr2.append(((j == 0) ? "" : "|") + dbRowset.getString ("VSL_LOC_CD").replaceAll("&","&amp;")+"\t" + dbRowset.getString("VSL_ETB_DT").trim().replaceAll("&","&amp;")+"\t" + dbRowset.getString("YD_CD").trim());
				inStr3.append(((j == 0) ? "" : "|") + dbRowset.getString ("VSL_LOC_CD").trim());
				j++;
			}
	
			keyinfo[0] = inStr.toString();
			keyinfo[1] = inStr1.toString();
			if(posCol.equals("fm")){
				keyinfo[2] = inStr.toString();
				keyinfo[3] = inStr1.toString();
			}else {
				keyinfo[2] = inStr2.toString();
				keyinfo[3] = inStr3.toString();	
			}
	
			keyinfo[4] = j+"";//ROWCOUNT
			returnVO.setResultStrArray(keyinfo);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, searchKeyRepoPlanInfo .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	
	/**
	 * [EQR_SCNR_VSL_SKD 테이블에서 Lane] 정보를 [조회] 합니다.<br>
	 * 
	 * @param eesEqr0012ConditionVO EesEqr0012ConditionVO
	 * @return String
	 * @exception DAOException
	 */
	public CommonRsVO searchCODVskLaneData(EesEqr0012ConditionVO eesEqr0012ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String   LaneCd	  = null;
		CommonRsVO returnVO = new CommonRsVO();
		String keyinfo[] = new String[7];
		int j			= 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("vsl_cd", eesEqr0012ConditionVO.getVslCd());
			param.put("skd_voy_no", eesEqr0012ConditionVO.getSkdVoyNo());
			param.put("skd_dir_cd",eesEqr0012ConditionVO.getSkdDirCd());
			param.put("pln_yrwk", eesEqr0012ConditionVO.getFmfmplnyrwk2());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAOSearchCODVskLaneDataRSQL(), param, velParam);
			
			if (dbRowset.next()){
				LaneCd = dbRowset.getString("SLAN_CD");
				j++;
			}
			
			keyinfo[0]=LaneCd;
			keyinfo[1]=LaneCd;
			keyinfo[2]=LaneCd;
			keyinfo[3]=LaneCd;
			keyinfo[4] = j+"";//ROWCOUNT
			returnVO.setResultStrArray(keyinfo);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}

	/**
	 * [EQR_SCNR_VSL_SKD 스케즐에서 LANE] 정보를 [조회] 합니다.<br>
	 * 
	 * @param eesEqr0012ConditionVO EesEqr0012ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchLaneExistInfo(EesEqr0012ConditionVO eesEqr0012ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO returnVO = new CommonRsVO();
		String keyinfo[] = new String[7];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("repo_pln_id", eesEqr0012ConditionVO.getRepoPlnId());
			param.put("vsl_lane_cd",eesEqr0012ConditionVO.getVslLaneCd());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAOSearchLaneCodeRSQL(), param, velParam);
	
			while (dbRowset.next()){
				keyinfo[0] = dbRowset.getString("VSL_SLAN_CD");
			}
			returnVO.setResultStrArray(keyinfo);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	/**
	 * Change POD 된 데이터의 수량을 0으로 대체하고 cod_sim_flg ='Y'로 변경을 한다.<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @exception DAOException
	 */
	public void updateCodTmpQTyZero(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new CodSimulateDBDAOUpdateCodTempQtyZeroUSQL(), param, velparam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update No SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
	
	/**
	 * Change POD가 일어난 데이터를 update 및 insert를 한다. .<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @exception DAOException
	 */
	public void updateCodTmp(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {

		//Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new CodSimulateDBDAOMergeCodTempCSQL(), param, velparam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update No SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
			
	/**
	 * Change POD가 일어난 데이터를 update 및 insert를 한다.<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @exception DAOException
	*/
	public void updateCodTmpQty(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;

			updCnt = sqlExe.executeUpdate((ISQLTemplate)new CodSimulateDBDAOMergeCodTempQtyCSQL(), param, velparam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update No SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
			
	/**
	 * 변경이 일어날 PLAN의 PRE_PLN_DCHG_LOC_CD ,PRE_PLN_CNTR_QTY ,COD_DCHG_PLN_FLG의 데이터를 일괄적으로 NULL로 대치.<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @exception DAOException
	 */
	public void updateCodTempToNull(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			
			    updCnt = sqlExe.executeUpdate((ISQLTemplate)new CodSimulateDBDAOUpdateCodTempToNullUSQL(), param, velparam);
					if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No SQL");
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * COD target Master Data search 
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @return CommonVO getResultString()
	 * @exception DAOException
	*/
	public CommonRsVO searchCodTargetData (Map<String, Object> param , Map<String, Object> velparam) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO retVO = new CommonRsVO();
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAOSearchCodTargetDataRSQL(), param, velparam);
			retVO.setDbRowset(dbRowset);
	
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
		
		return retVO;
	}
	
	/**
	 * Vessel PLAN에 Insert와 update를 한다.(merge문).<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @exception DAOException
	 */
	public void mergeVesselPlanCOD(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			
			    updCnt = sqlExe.executeUpdate((ISQLTemplate)new CodSimulateDBDAOMergeVesselPlanCODCSQL(), param, velparam);
					if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No SQL");
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Vessel PLAN QTY에 Insert와 update를 한다.(merge문).<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @exception DAOException
	 */
	public void mergeVesselPlanQtyCOD(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			    updCnt = sqlExe.executeUpdate((ISQLTemplate)new CodSimulateDBDAOMergeVesselPlanQtyCODCSQL(), param, velparam);
					if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No SQL");
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	* [Change POD화면 sheet 2번째] 정보를 [행위] 합니다.<br>
	* 
	* @param conditionVO EesEqr0012ConditionVO
	* @return CommonRsVO
	* @exception DAOException
	*/
	public CommonRsVO searchPOLChangePlanCompare(EesEqr0012ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO returnVO = new CommonRsVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String repo_pln_id =  Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();

		String arrFmEccCd = Utils.convertStr(conditionVO.getFmecccd());
		String arrToEccCd = Utils.convertStr(conditionVO.getToecccd());
		String fmType     = conditionVO.getFmtype();
		String toType     = conditionVO.getTotype();
		String fmyrwk     = conditionVO.getFmplnyr() + conditionVO.getFmplnwk();
		String toyrwk     = conditionVO.getTotoplnyr() + conditionVO.getTotoplnwk();
		String arrlane    = Utils.convertStr(conditionVO.getLane());
		String arrtrad    = Utils.convertStr(conditionVO.getTrade());
		String arrvvd     = Utils.convertStr(conditionVO.getVvd());
		String conti      = conditionVO.getConti();
		String arrCntrTpsz1 = Utils.convertStr(conditionVO.getCntrtpszcd());
		ArrayList<String> arrCntrTpsz = (ArrayList<String>) Utils.replaceStrToList(conditionVO.getCntrtpszcd());

		try{
			param.put("repo_pln_id", repo_pln_id);
			param.put("conti", conti);
			param.put("fm_yrwk", fmyrwk);
			param.put("to_yrwk", toyrwk);
			velParam.put("arrtpszcd", arrCntrTpsz);
			velParam.put("fmecccd", arrFmEccCd);
			velParam.put("fmtype", fmType);
			velParam.put("arrfmecccd", arrFmEccCd);
			velParam.put("totype", toType);
			velParam.put("toecccd", arrToEccCd);
			velParam.put("arrtoecccd", arrToEccCd);
			velParam.put("arrcntrtpzcd", arrCntrTpsz1);
			velParam.put("lane", arrlane);
			velParam.put("vvd", arrvvd);
			velParam.put("trade", arrtrad);
			velParam.put("conti", conti);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAOGetPOLChangePlanCompareRSQL(), param, velParam);
			returnVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}	
	
	/**
	* [Change POD화면 sheet 3번째] 정보를 [조회] 합니다.<br>
	* 
	* @param conditionVO EesEqr0012ConditionVO
	* @return CommonRsVO
	* @exception DAOException
	*/
	public CommonRsVO searchPODChangePlanCompare(EesEqr0012ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO returnVO = new CommonRsVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String repo_pln_id =  Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();

		String arrFmEccCd = Utils.convertStr(conditionVO.getFmecccd());
		String arrToEccCd = Utils.convertStr(conditionVO.getToecccd());
		String fmType     = conditionVO.getFmtype();
		String toType     = conditionVO.getTotype();
		String fmyrwk     = conditionVO.getFmplnyr() + conditionVO.getFmplnwk();
		String toyrwk     = conditionVO.getTotoplnyr() + conditionVO.getTotoplnwk();
		String arrlane    = Utils.convertStr(conditionVO.getLane());
		String arrtrad    = Utils.convertStr(conditionVO.getTrade());
		String arrvvd     = Utils.convertStr(conditionVO.getVvd());
		String conti      = conditionVO.getConti();
		String arrCntrTpsz1 = Utils.convertStr(conditionVO.getCntrtpszcd());
		ArrayList<String> arrCntrTpsz = (ArrayList<String>) Utils.replaceStrToList(conditionVO.getCntrtpszcd());

		try{
			param.put("repo_pln_id", repo_pln_id);
			param.put("conti", conti);
			param.put("fm_yrwk", fmyrwk);
			param.put("to_yrwk", toyrwk);
			velParam.put("arrtpszcd", arrCntrTpsz);
			velParam.put("fmecccd", arrFmEccCd);
			velParam.put("fmtype", fmType);
			velParam.put("arrfmecccd", arrFmEccCd);
			velParam.put("totype", toType);
			velParam.put("toecccd", arrToEccCd);
			velParam.put("arrtoecccd", arrToEccCd);
			velParam.put("arrcntrtpzcd", arrCntrTpsz1);
			velParam.put("lane", arrlane);
			velParam.put("vvd", arrvvd);
			velParam.put("trade", arrtrad);
			velParam.put("conti", conti);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAOGetPODChangePlanCompareRSQL(), param, velParam);
			returnVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	
	/**
	 * REPO_PLN_ID, PLN_YRWK 를 기준으로 대상 테이블의 Next PLN_SEQ 를 취득한다. CommonDBDAO.getNextPlnSeq 참조
	 * 
	 * @param tableName
	 * @param repoPlnId
	 * @param plnYrwk
	 * @return CommonVO getResultString()
	 * @exception DAOException
	*/
	public CommonVO getNextPlnSeq(String tableName, String repoPlnId, String plnYrwk) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String result= "";
		
		try {
			velParam.put("table", tableName);
			param.put("repo_pln_id", repoPlnId);
			param.put("pln_yrwk", plnYrwk);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetNextPlnSeqRSQL(), param, velParam);
			while (dbRowset.next()){
				result =  dbRowset.getString("NEXT_PLN_SEQ");
			}
			retVO.setResultString(result);
	
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
		
		return retVO;
	}
	
	/**
	 * 신규프로젝트 No: S2Q-09P-004
	 * Added by Haeng-Ji,Lee
	 * Bay Port가 common 공통에서 검색이 안되는 경우, 재검색을 실시함<br>
	 * 
	 * @param vvd
	 * @return CommonRsVO getResultString()
	 * @exception DAOException
	*/
	@SuppressWarnings("null")
	public CommonRsVO searchBasisPort(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO retVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String result= "";
		
		try {
			if ( vvd != null) {
				if ( vvd != null || vvd.length() != 9 ) {
					if(vvd != null) param.put("vsl_cd", vvd.substring(0,4));
					if(vvd != null) param.put("skd_voy_no", vvd.substring(4,8));
					if(vvd != null) param.put("skd_dir_cd", vvd.substring(8,9));
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAOSearchBasisPortRSQL(), param, velParam);
			while (dbRowset.next()){
				result =  dbRowset.getString("BASIS");
			}
			retVO.setResultString(result);
	
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
		
		return retVO;
	}
	
	/**
	 * 신규프로젝트 No: S2Q-09P-004
	 * Added by Haeng-Ji,Lee
	 * Bay Plan의 모든 목록을 가져온다.<br>
	 * 
	 * @param conditionVO EesEqr0140ConditionVO
	 * @param search_port String
	 * @return CommonRsVO
	 * @exception DAOException
	*/
	@SuppressWarnings("null")
	public CommonRsVO searchBayPlan(EesEqr0140ConditionVO conditionVO ,String search_port) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO retVO = new CommonRsVO();
		
		String vvd			= conditionVO.getVvd();
		ArrayList<String> arrCntrTpsz = (ArrayList<String>) Utils.replaceStrToList(conditionVO.getTpsztypeall());
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if ( vvd != null) {
				if ( vvd != null || vvd.length() != 9 ) {
						if(vvd != null) param.put("vsl_cd", vvd.substring(0,4));
						if(vvd != null) param.put("skd_voy_no", vvd.substring(4,8));
						if(vvd != null) param.put("skd_dir_cd", vvd.substring(8,9));
				}
			}
			param.put("search_port", search_port);
			velParam.put("arrtpszcd", arrCntrTpsz);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAOSearchBayPlanRSQL(), param, velParam);
			retVO.setDbRowset(dbRowset);
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
		
		return retVO;
	}
	
	/** 
	 * ADDED BY SHIN YONGCHAN - 20080430
	 * UNIT COST 정보를 취득합니다.
	 * COD, REPO PLAN, EXE PLAN 3군데 화면에서 사용합니다. (소스는 각각의 DAO에 존재함)
	 *
	 * 1) EQR_ECC_ADD_PLN_COST 에 UNIT COST 존재하는지 확인
	 * 2) 존재하면       EQR_ECC_ADD_PLN_COST 에서 UNIT COST 취득
	 * 3) 존재하지 않으면 EQR_LCC_ADD_PLN_COST 에서 UNIT COST 획득  
	 * 
	 * @param Division 		: PLAN, EXEC, INTERNAL  구분( P, E, I)
	 * @param fm_ecc 		: FROM ECC (OR FROM YARD)
	 * @param to_ecc 		: TO ECC (OR TO YARD)
	 * @param trsp_mod_cd 	: trsp_mod_cd 구분(V,R,T,W,)
	 * @param cntr_tpsz_cd 	: cntr_tpsz_cd 구분
	 * @return CommonRsVO String[] (FROM UNIT COST, TO UNIT COST, UNIT COST)
	 * @exception DAOException
	 */	
	public CommonRsVO searchUnitCost(String division, String fm_ecc, String to_ecc, String trsp_mod_cd, String cntr_tpsz_cd) throws DAOException {

		DBRowSet dbRowsetChk = null;
		DBRowSet dbRowsetECC = null;
		DBRowSet dbRowsetLCC = null;
		CommonRsVO commonVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String[] returnStr = new String[3];
		int result = 0;
		
		
		try {
			SQLExecuter sQLExecuter = new SQLExecuter("");
			param.put("fm_ecc", fm_ecc);
			param.put("to_ecc", to_ecc);
			param.put("trsp_mod_cd", trsp_mod_cd);
			param.put("cntr_tpsz_cd", cntr_tpsz_cd);
			velParam.put("fm_ecc", fm_ecc);
			velParam.put("to_ecc", to_ecc);
			velParam.put("trsp_mod_cd", trsp_mod_cd);
			velParam.put("cntr_tpsz_cd", cntr_tpsz_cd);
			velParam.put("division", division);
			
			dbRowsetChk = sQLExecuter.executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostCheckRSQL(), param, velParam);
			
			while (dbRowsetChk.next()){
				result = dbRowsetChk.getInt(1);
				break;
			}		
			
			//-------------- ECC에 데이터 존재 
			if( result>0 ) {
				
				dbRowsetECC = sQLExecuter.executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostECCRSQL(), param, velParam);
				
				while(dbRowsetECC.next()) {
					returnStr[0]= dbRowsetECC.getString("FM_COST");
					returnStr[1]= dbRowsetECC.getString("TO_COST"); 
					returnStr[2]= dbRowsetECC.getString("UC_COST"); 				
				}		
				
			} else {
				
				dbRowsetLCC = sQLExecuter.executeQuery((ISQLTemplate)new CntrRepoExecutionPlanEstablishDBDAOSearchUnitCostLCCRSQL(), param, velParam);
				
				while(dbRowsetLCC.next()) {
					returnStr[0]= dbRowsetLCC.getString("FM_COST");
					returnStr[1]= dbRowsetLCC.getString("TO_COST"); 
					returnStr[2]= dbRowsetLCC.getString("UC_COST"); 				
				}				
			}
		
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

		commonVO.setResultStrArray(returnStr);
		return commonVO;
	}	
	
	/**
	 * EQR_VSL_LDIS_PLN_COD_TMP 테이블에 Duplicate Data가 있는지 조회
	 * 
	 * @param vo EesEqr0012MultiVO
	 * @return resultCnt
	 * @throws DAOException
	 * @throws Exception
	 */
	public int isDupVslTmpData(EesEqr0012MultiVO vo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int resultCnt = 0;
		String past_flg = null;
		
		try{
			Map<String, String> mapVO = vo .getColumnValues();
			param.putAll(mapVO);
			
			if (vo.getPastRepoPlnFlg().equals("1")) {
				past_flg ="Y";
			} else {
				past_flg ="N";
			}
			velParam.put("past_repo_pln_flg", past_flg);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAOSearchDupVslTmpDataRSQL(), param, velParam);
			
			while (dbRowset.next()) {
				resultCnt = dbRowset.getInt("CNT");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCnt;
	}
	
	/**
	 * 생성된 REPO_PLAN ID가 있는지 확인을 한다.<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @return resultCnt
	 * @exception DAOException
	 */
	public int duplicateCreateRepoPlanCheck(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int resultCnt = 0;
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAODuplicateCreateRepoPlanCheckRSQL(), param, velparam);
			
			while (dbRowset.next()) {
				resultCnt = dbRowset.getInt("CNT");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCnt;
	}
	
	
	/**
	 * 생성된 PLAN이 있는지 확인을 한다.<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @return resultCnt
	 * @exception DAOException
	 */
	public int duplicateCreateRepoPlanViewCheck(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int resultCnt = 0;
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAODuplicateCreateRepoPlanViewCheckRSQL(), param, velparam);
			
			while (dbRowset.next()) {
				resultCnt = dbRowset.getInt("PLANCNT");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCnt;
	}

	/**
	 * 강제로 scnario ID를 생성을 한다.<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @exception DAOException
	 */
	public void createManualScnrId(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			    updCnt = sqlExe.executeUpdate((ISQLTemplate)new CodSimulateDBDAOCreateManualScnrIdCSQL(), param, velparam);
					if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No SQL");
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 강제로 Plan ID를 생성을 한다.<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @exception DAOException
	 */
	public void createManualRepoPlanId(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			    updCnt = sqlExe.executeUpdate((ISQLTemplate)new CodSimulateDBDAOCreateManualRepoPlanIdCSQL(), param, velparam);
					if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No SQL");
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * Repo Plan Id 삭제 <br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @exception DAOException
	 */
	public void deleteRepoPlanId(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt = 0;
			    delCnt = sqlExe.executeUpdate((ISQLTemplate)new CodSimulateDBDAODeleteRepoPlanIdDSQL(), param, velparam);
					if(delCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No SQL");
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Pln Id Tmp 삭제.<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @exception DAOException
	 */
	public void deleteEqrPlnCodTmp(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt = 0;
			    delCnt = sqlExe.executeUpdate((ISQLTemplate)new CodSimulateDBDAODeleteEqrPlnCodTmpDSQL(), param, velparam);
					if(delCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No SQL");
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * TP/SZ별 Pln 삭제.<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @exception DAOException
	 */
	public void deleteEqrPlnCodQty(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt = 0;
			    delCnt = sqlExe.executeUpdate((ISQLTemplate)new CodSimulateDBDAODeleteEqrPlnCodQtyDSQL(), param, velparam);
					if(delCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No SQL");
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 신규 Repo Plan 제목 수정시에 EQR_EQ_REPO_PLN의 REPO_PLN_RMK 정보를 업데이트한다.<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @exception DAOException
	 */
	public void updateRepoPlnIdNm(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			
			    updCnt = sqlExe.executeUpdate((ISQLTemplate)new CodSimulateDBDAOUpdateRepoPlnIdNmUSQL(), param, velparam);
					if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No SQL");
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 불필요한 Garbage 정보를 삭제 한다.<br>
	 * 
	 * @param EesEqr0012MultiVO eesEqr0012MultiVO
	 * @exception DAOException
	 */
	public void deleteCodTempClean(EesEqr0012MultiVO eesEqr0012MultiVO) throws DAOException {	
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String repo_pln_id = eesEqr0012MultiVO.getRepoPlanId();
		String plan_seq = eesEqr0012MultiVO.getPlanSeq();		
		try{
			param.put("repo_pln_id", repo_pln_id);
			param.put("plan_seq", plan_seq);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CodSimulateDBDAODeleteCodTempCleanDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
			throw new DAOException("Fail to delete No SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 불필요한 Garbage 정보를 삭제 한다.<br>
	 * 
	 * @param EesEqr0012MultiVO eesEqr0012MultiVO
	 * @exception DAOException
	 */
	public void deleteCodTempQtyClean(EesEqr0012MultiVO eesEqr0012MultiVO) throws DAOException {
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String repo_pln_id = eesEqr0012MultiVO.getRepoPlanId();
		String plan_seq = eesEqr0012MultiVO.getPlanSeq();		
		try{
			param.put("repo_pln_id", repo_pln_id);
			param.put("plan_seq", plan_seq);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new CodSimulateDBDAOMergeCodTempQtyCleanDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
			throw new DAOException("Fail to delete No SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}	
	
	
	/**
	 * 
	 * @param eesEqr0012ConditionVO
	 * @return
	 * @throws DAOException
	 */
	public CommonRsVO searchCODVskLaneLocData(EesEqr0012ConditionVO eesEqr0012ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String   LaneCd	  = null;
		CommonRsVO returnVO = new CommonRsVO();
		String keyinfo = "";
		int j			= 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		StringBuffer inStr  = new StringBuffer();
		
		try{
			param.put("vsl_cd", eesEqr0012ConditionVO.getVslCd());
			param.put("skd_voy_no", eesEqr0012ConditionVO.getSkdVoyNo());
			param.put("skd_dir_cd",eesEqr0012ConditionVO.getSkdDirCd());
			param.put("pln_yrwk", eesEqr0012ConditionVO.getFmfmplnyrwk2());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodSimulateDBDAOSearchCODVskLaneLocDataRSQL(), param, velParam);
			
			while (dbRowset.next()){
				inStr.append(((j == 0) ? "" : ",") + dbRowset.getString ("VSL_LOC_CD").replaceAll("&","&amp;"));
				j++;
			}
			keyinfo = inStr.toString();			
			returnVO.setResultString(keyinfo);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
}
