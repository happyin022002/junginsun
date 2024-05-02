/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAO.java
*@FileTitle : Container Guideline Manage
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1     1.0      	SHIN DONG IL						2013.05.27		 Creation
*
*@LastModifyDate : 2013.05.27
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.05.27 SHIN DONG IL
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanmtrepoplan.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanmtrepoplan.basic.CntrPlanMTRepoPlanBC;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanmtrepoplan.vo.EesEqr1013ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.Utils;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.EqrCtrlMtyDchgPlnVO;
import com.clt.syscommon.common.table.EqrCtrlMtyLodgPlnVO;
import com.clt.syscommon.common.table.EqrCtrlMtyDchgPlnQtyVO;

/**
 * OPUS CntrPlanMTRepoPlanDBDAO <br>
 * - OPUS-CntrPlanGuide system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 	SHIN DONG IL
 * @see 	CntrPlanMTRepoPlanBCImpl.java 참조
 * @since 	J2EE 1.6
 */
public class CntrPlanMTRepoPlanDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * 화면 Loading시 기본 설정 데이터 조회
	 * @param condVO
	 * @return CommonVO
	 * @throws DAOException
	 */
	public CommonVO searchLoadingTrendByLaneDefault(EesEqr1013ConditionVO condVO) throws DAOException {

		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, String> mapVO = condVO.getColumnValues();
		
		param.putAll(mapVO);
		CommonVO retVO = new CommonVO();
		
		String[] returnStr = new String[CntrPlanMTRepoPlanBC.MTY_REPO_PLN_DEF_VAL_LENGTH];
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanMTRepoPlanDBDAOSearchLoadingTrendByLaneDefaultRSQL(), param, param);
			while(dbRowset.next()) {
				returnStr[0] = JSPUtil.getNull(dbRowset.getString("ETA_FM_DT"));
				returnStr[1] = JSPUtil.getNull(dbRowset.getString("ETA_TO_DT"));
				returnStr[2] = JSPUtil.getNull(dbRowset.getString("FM_WK"));
				returnStr[3] = JSPUtil.getNull(dbRowset.getString("TO_WK"));
				returnStr[4] = JSPUtil.getNull(dbRowset.getString("RCC_CD"));
				returnStr[5] = JSPUtil.getNull(dbRowset.getString("OFC_TP_CD"));
				returnStr[6] = JSPUtil.getNull(dbRowset.getString("PLN_RSN_HDR_CODE_N_TEXT"));
				returnStr[7] = JSPUtil.getNull(dbRowset.getString("PLN_RSN_SUB_CODE_N_TEXT"));
				returnStr[8] = JSPUtil.getNull(dbRowset.getString("LOGIN_OFC_CONTI_CD"));
			}
			retVO.setResultStrArray(returnStr);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVO;
	}
	
	/**
	 * VVD Combo 대상 조회
	 * @param condVO
	 * @return List<EesEqr1013ConditionVO>
	 * @throws DAOException
	 */
	public List<EesEqr1013ConditionVO> searchVvdResult(EesEqr1013ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
//		Map<String, String> mapVO = condVO.getColumnValues();
		
		List<EesEqr1013ConditionVO> list = null;

		if (condVO!=null){
			if (condVO.getLane()!=null && !condVO.getLane().trim().equals("")){//Lane 입력하였을 경우
				condVO.setTrade("");
				condVO.setSubtrade("");
			} else if(condVO.getSubtrade()!=null && !condVO.getSubtrade().equals("")){//Sub Trade 입력하였을 경우
				condVO.setTrade("");
			}
			
			List arr_trd_cd 	= Utils.replaceStrToList(condVO.getTrade());
			List arr_sub_trd_cd = Utils.replaceStrToList(condVO.getSubtrade());
			List arr_lane 		= Utils.replaceStrToList(condVO.getLane());
			
			log.debug("\n  condVO: " + condVO.toString() + "\n");
			log.debug("\n  condVO: " + condVO.getRccCd() + "\n");
//			param.putAll(mapVO);
			param.put("s_dt_tp_cd", JSPUtil.getNull(condVO.getSDtTpCd()));
			param.put("s_eta_dt", JSPUtil.getNull(condVO.getSEtaDt()));
			param.put("s_eff_st_dt", JSPUtil.getNull(condVO.getSEffStDt()));
			param.put("s_eff_end_dt", JSPUtil.getNull(condVO.getSEffEndDt()));
			param.put("s_loc_cd", JSPUtil.getNull(condVO.getSLocCd()));
			param.put("s_sub_loc_cd", JSPUtil.getNull(condVO.getSSubLocCd()));
			param.put("s_fcbf_st_dt", JSPUtil.getNull(condVO.getSFcbfStDt()));
			param.put("s_fcbf_end_dt", JSPUtil.getNull(condVO.getSFcbfEndDt()));
			param.put("rcc_cd", JSPUtil.getNull(condVO.getRccCd()));
			param.put("loc_tp_cd_second", JSPUtil.getNull(condVO.getLocTpCdSecond()));
			param.put("loc_cd_second", JSPUtil.getNull(condVO.getLocCdSecond()));
			param.put("s_vvd_cd", JSPUtil.getNull(condVO.getSVvdCd()));
			param.put("trade", JSPUtil.getNull(condVO.getTrade()));
			param.put("subtrade", JSPUtil.getNull(condVO.getSubtrade()));
			param.put("lane", JSPUtil.getNull(condVO.getLane()));		
			param.put("arr_trd_cd", JSPUtil.getNull(arr_trd_cd));
			param.put("arr_sub_trd_cd", JSPUtil.getNull(arr_sub_trd_cd));
			param.put("arr_lane", JSPUtil.getNull(arr_lane));
			velParam.put("s_dt_tp_cd", JSPUtil.getNull(condVO.getSDtTpCd()));
			velParam.put("s_eta_dt", JSPUtil.getNull(condVO.getSEtaDt()));
			velParam.put("s_eff_st_dt", JSPUtil.getNull(condVO.getSEffStDt()));
			velParam.put("s_eff_end_dt", JSPUtil.getNull(condVO.getSEffEndDt()));
			velParam.put("s_loc_cd", JSPUtil.getNull(condVO.getSLocCd()));
			velParam.put("s_sub_loc_cd", JSPUtil.getNull(condVO.getSSubLocCd()));
			velParam.put("s_fcbf_st_dt", JSPUtil.getNull(condVO.getSFcbfStDt()));
			velParam.put("s_fcbf_end_dt", JSPUtil.getNull(condVO.getSFcbfEndDt()));
			velParam.put("rcc_cd", JSPUtil.getNull(condVO.getRccCd()));
			velParam.put("loc_tp_cd_second", JSPUtil.getNull(condVO.getLocTpCdSecond()));
			velParam.put("loc_cd_second", JSPUtil.getNull(condVO.getLocCdSecond()));
			velParam.put("s_vvd_cd", JSPUtil.getNull(condVO.getSVvdCd()));
			velParam.put("trade", JSPUtil.getNull(condVO.getTrade()));
			velParam.put("subtrade", JSPUtil.getNull(condVO.getSubtrade()));
			velParam.put("lane", JSPUtil.getNull(condVO.getLane()));		
			velParam.put("arr_trd_cd", JSPUtil.getNull(arr_trd_cd));
			velParam.put("arr_sub_trd_cd", JSPUtil.getNull(arr_sub_trd_cd));
			velParam.put("arr_lane", JSPUtil.getNull(arr_lane));
			
			try {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanMTRepoPlanDBDAOSearchVvdResultRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, EesEqr1013ConditionVO.class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}			
		}
		return list;
	}
	
	/**
	 * PlnRsnHdr 조회
	 * @return String
	 * @throws DAOException
	 */
	public String searchPlnRsnHdrList() throws DAOException {
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		String retval = null;
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CntrPlanMTRepoPlanDBDAOSearchPlnRsnHdrListRSQL(),param, velParam);
			if (dbRowset.next()){
				retval = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}
	
	/**
	 * PlnRsnSub 조회
	 * @param condVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPlnRsnSubList(EesEqr1013ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String retval = null;
		
		param.put("plnRsnHdrCd", condVO.getPlnRsnHdrCd());
		velParam.put("plnRsnHdrCd", condVO.getPlnRsnHdrCd());
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CntrPlanMTRepoPlanDBDAOSearchPlnRsnSubListRSQL(),param, velParam);
			if (dbRowset.next()){
				retval = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}
	
	/**
	 * Mty Plan 조회
	 * @param condVO
	 * @return CommonRsVO
	 * @throws DAOException
	 */
	public CommonRsVO searchMtyRepoPlanList(EesEqr1013ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;

		CommonRsVO commonRsVO = new CommonRsVO();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("vvdRetrieveVal", 	condVO.getVvdRetrieveVal());
		param.put("rcc_cd", 			JSPUtil.getNull(condVO.getRccCd()));
		param.put("loc_tp_cd_second",	JSPUtil.getNull(condVO.getLocTpCdSecond()));
		param.put("loc_cd_second", 		JSPUtil.getNull(condVO.getLocCdSecond()));
		param.put("ofc_cd", 			JSPUtil.getNull(condVO.getOfcCd()));		
		
		velParam.put("rcc_cd", 			JSPUtil.getNull(condVO.getRccCd()));
		velParam.put("loc_tp_cd_second",JSPUtil.getNull(condVO.getLocTpCdSecond()));
		velParam.put("loc_cd_second", 	JSPUtil.getNull(condVO.getLocCdSecond()));
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanMTRepoPlanDBDAOSearchMtyRepoPlanListRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * Mt Repo Reference data 조회
	 * @param condVO
	 * @return CommonRsVO
	 * @throws DAOException
	 */
	public CommonRsVO searchMtyRepoRefList(EesEqr1013ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;

		CommonRsVO commonRsVO = new CommonRsVO();
		Map<String, Object> param = new HashMap<String, Object>();

		List<String> pols_lst = Utils.replaceStrToList(JSPUtil.getNull(condVO.getSPolCd()));
		String lastPol = pols_lst!=null&&pols_lst.size()>0?pols_lst.get(pols_lst.size()-1):"";
//		log.debug("\n @@@@@ searchMtyRepoRefList - lastPol : "  + JSPUtil.getNull(lastPol) + " @@@@@@@@ \n");
		
		try {
			if (condVO!=null && condVO.getRlane()!=null && !condVO.getRlane().trim().equals("") && pols_lst!=null){
				param.put("trade", JSPUtil.getNull(condVO.getTrade()));
				param.put("subtrade", JSPUtil.getNull(condVO.getSubtrade()));
				param.put("rlane", JSPUtil.getNull(condVO.getRlane()));
				param.put("s_vvd_cd", JSPUtil.getNull(condVO.getSVvdCd()));
				param.put("s_eta_dt", JSPUtil.getNull(condVO.getSEtaDt()));
				param.put("s_pol_cd", pols_lst); //Utils.replaceStrToList(JSPUtil.getNull(condVO.getSPolCd())));
				param.put("qty_tp", "1");
				param.put("last_pol_cd", JSPUtil.getNull(lastPol));
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanMTRepoPlanDBDAOSearchMtyRepoRefListRSQL(), param, param);
				commonRsVO.setDbRowset(dbRowset);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * MtyLodgPln 저장
	 * @param insEqrCtrlMtyLodgPlnVOLst
	 * @throws DAOException
	 */
	public void manageMtyLodgPln(List<EqrCtrlMtyLodgPlnVO> insEqrCtrlMtyLodgPlnVOLst) throws DAOException {
		
		int [] rsCnt = null;
		
		try {
			if(insEqrCtrlMtyLodgPlnVOLst.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CntrPlanMTRepoPlanDBDAOManageMtyLodgPlnUSQL(),insEqrCtrlMtyLodgPlnVOLst, null, null);
				for(int i = 0; i < rsCnt.length; i++){
					if (rsCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * MtyDchgPln 저장
	 * @param insEqrCtrlMtyDchgPlnVOLst
	 * @throws DAOException
	 */
	public void manageMtyDchgPln(List<EqrCtrlMtyDchgPlnVO> insEqrCtrlMtyDchgPlnVOLst) throws DAOException {
		
		int [] rsCnt = null;
		
		try {
			if(insEqrCtrlMtyDchgPlnVOLst.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CntrPlanMTRepoPlanDBDAOManageMtyDchgPlnUSQL(),insEqrCtrlMtyDchgPlnVOLst, null, null);
				for(int i = 0; i < rsCnt.length; i++){
					if (rsCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * MtyDchgPlnQty 저장
	 * @param insEqrCtrlMtyDchgPlnQtyVOLst
	 * @throws DAOException
	 */
	public void manageMtyDchgPlnQty(List<EqrCtrlMtyDchgPlnQtyVO> insEqrCtrlMtyDchgPlnQtyVOLst) throws DAOException {
		
		int [] rsCnt = null;
		
		try {
			if(insEqrCtrlMtyDchgPlnQtyVOLst.size() > 0){
				rsCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CntrPlanMTRepoPlanDBDAOManageMtyDchgPlnQtyUSQL(),insEqrCtrlMtyDchgPlnQtyVOLst, null, null);
				for(int i = 0; i < rsCnt.length; i++){
					if (rsCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}