/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableEstimateAuditDBDAO.java
*@FileTitle : Estimate expense
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* =======================================================

=========================================================*/
package com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.cntrcommon.Utils;
import com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.basic.PayableEstimateAuditBCImpl;
import com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.vo.EstimatedAuditVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * PayableEstimateAuditDBDAO <br>
 * ContainerCostAnalysis system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see PayableEstimateAuditBCImpl 참조
 * @since J2EE 1.6
 */
public class PayableEstimateAuditDBDAO extends DBDAOSupport {

	/**
	 * <br>
	 * 
	 * @param EstimatedAuditVO estimatedAuditVO
	 * @return List<EstimatedAuditVO>
	 * @throws DAOException
	 */

	@SuppressWarnings("unchecked")
	public List<EstimatedAuditVO> searchPayableEstimateAuditData(EstimatedAuditVO estimatedAuditVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstimatedAuditVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(estimatedAuditVO != null){
						
				String strPeriodEndt = estimatedAuditVO.getPeriodEddt();
			    if(strPeriodEndt != null){
			    	strPeriodEndt = strPeriodEndt.replaceAll("-", "");
			    	param.put("period_eddt"     , strPeriodEndt);
					velParam.put("period_eddt"  , strPeriodEndt);
			    }else{
			    	param.put("period_eddt"     , "");
					velParam.put("period_eddt"  , "");
			    }
			    
			    List arr_skr_acct_cd		= Utils.replaceStrToList(estimatedAuditVO.getSkr_acct_cd());
			    
				param.put("lse_ctrt_no"          , estimatedAuditVO.getLseCtrtNo());
				param.put("vndr_seq"             , estimatedAuditVO.getVndrSeq());
				param.put("lse_pay_chg_tp_cd"    , estimatedAuditVO.getLsePayChgTpCd());
				param.put("skr_acct_cd"          , estimatedAuditVO.getSkr_acct_cd());
				param.put("rev_month"            , estimatedAuditVO.getRevMonth());
				param.put("agmt_seq"             , estimatedAuditVO.getAgmtSeq());
				param.put("lstm_cd"             , estimatedAuditVO.getLstm_cd());
				
				velParam.put("lse_ctrt_no"          , estimatedAuditVO.getLseCtrtNo());
				velParam.put("vndr_seq"             , estimatedAuditVO.getVndrSeq());
				velParam.put("lse_pay_chg_tp_cd"    , estimatedAuditVO.getLsePayChgTpCd());
				velParam.put("skr_acct_cd"          , estimatedAuditVO.getSkr_acct_cd());
				velParam.put("rev_month"            , estimatedAuditVO.getRevMonth());
				velParam.put("agmt_seq"             , estimatedAuditVO.getAgmtSeq());
				velParam.put("lstm_cd"             , estimatedAuditVO.getLstm_cd());			
				
				velParam.put("arr_skr_acct_cd"          , arr_skr_acct_cd);
			}		
			
			dbRowset = new SQLExecuter("").executeQuery(new PayableEstimateAuditDBDAOsearchPayableEstimateAuditRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EstimatedAuditVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 임차료에 대한 추정 실적 계산 합니다.<br>
	 * 
	 * @param EstimatedAuditVO estimatedAuditVO
	 * @return List<EstimatedAuditVO>
	 * @throws DAOException
	 */

	@SuppressWarnings("unchecked")
	public List<EstimatedAuditVO> calculationPayableEstimateAuditData(EstimatedAuditVO estimatedAuditVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstimatedAuditVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(estimatedAuditVO != null){
				String strPeriodStdt = "";
				String strPeriodEndt = estimatedAuditVO.getPeriodEddt();
			    if(strPeriodEndt != null){
			    	strPeriodEndt = strPeriodEndt.replaceAll("-", "");
			    	strPeriodStdt = strPeriodEndt.substring(0, 4) + "01";
			    }
			    
			    param.put("period_stdt"     , strPeriodStdt);
				param.put("lse_ctrt_no"          , estimatedAuditVO.getLseCtrtNo());
				param.put("vndr_seq"             , estimatedAuditVO.getVndrSeq());
				param.put("lse_pay_chg_tp_cd"    , estimatedAuditVO.getLsePayChgTpCd());
				param.put("skr_acct_cd"          , estimatedAuditVO.getSkr_acct_cd());
				param.put("rev_month"            , estimatedAuditVO.getRevMonth());
				param.put("agmt_seq"             , estimatedAuditVO.getAgmtSeq());
				
			    if(strPeriodEndt != null){
			    	param.put("period_eddt"     , strPeriodEndt);
			    }
				param.put("period_dt"       , estimatedAuditVO.getPeriodEddt());
				
				velParam.put("period_stdt"  , strPeriodStdt);
				if(strPeriodEndt != null){
					velParam.put("period_eddt"  , strPeriodEndt);
				}
				velParam.put("period_dt"    , estimatedAuditVO.getPeriodEddt());
				velParam.put("lse_ctrt_no"          , estimatedAuditVO.getLseCtrtNo());
				velParam.put("vndr_seq"             , estimatedAuditVO.getVndrSeq());
				velParam.put("lse_pay_chg_tp_cd"    , estimatedAuditVO.getLsePayChgTpCd());
				velParam.put("skr_acct_cd"          , estimatedAuditVO.getSkr_acct_cd());
				velParam.put("rev_month"            , estimatedAuditVO.getRevMonth());
				velParam.put("agmt_seq"             , estimatedAuditVO.getAgmtSeq());				
				
				List arr_skr_acct_cd		= Utils.replaceStrToList(estimatedAuditVO.getSkr_acct_cd());
				velParam.put("arr_skr_acct_cd"          , arr_skr_acct_cd);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(new PayableEstimateAuditDBDAOcalculationPayableEstimateAuditRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EstimatedAuditVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 저장된 임차료에 대한 추정 실적을 삭제 합니다.<br>
	 * 
	 * @param String yearMonth
	 * @throws DAOException
	 */
	 public void removePayableEstimateAuditData( String yearMonth ) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(yearMonth != null){
				yearMonth = yearMonth.replaceAll("-", "");
				param.put("period_eddt" , yearMonth);
			    velParam.put("period_eddt" , yearMonth);
		    }else{
		    	param.put("period_eddt" , "");
			    velParam.put("period_eddt" , "");
		    }
		    
		    SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableEstimateAuditDBDAOremovePayableEstimateAuditDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
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
	 * 저장된 임차료에 대한 추정 실적을 저장 합니다.<br>
	 * 
	 * @param EstimatedAuditVO estimatedAuditVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	 public void addPayableEstimateAuditData( EstimatedAuditVO estimatedAuditVO ,  SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			String strActualMonth = estimatedAuditVO.getActualMonth();
			if(strActualMonth != null){
				strActualMonth = strActualMonth.replaceAll("-", "");
		    }
			String strRevMonth    = estimatedAuditVO.getRevMonth();
			if(strRevMonth != null){
				strRevMonth = strRevMonth.replaceAll("-", "");
		    }
			
			param.put("estm_seq_no"     , estimatedAuditVO.getSeq());
			if(strActualMonth != null){
				param.put("exe_yrmon"       , strActualMonth);
			}
			param.put("sys_src_id"      , estimatedAuditVO.getSysName());
			if(strRevMonth != null){
				param.put("rev_yrmon"       , strRevMonth);
			}
			param.put("acct_cd"         , estimatedAuditVO.getAcctCode());
			param.put("agmt_no"         , estimatedAuditVO.getAgmtNo());
			param.put("lse_pay_chg_tp_cd" , estimatedAuditVO.getLsePayChgTpCd());
			param.put("biz_ut_id"       , estimatedAuditVO.getBizUnit());
			param.put("cntr_tpsz_cd"    , estimatedAuditVO.getTpSz());
			param.put("cntr_qty"        , estimatedAuditVO.getEstQty());
			param.put("estm_amt"        , estimatedAuditVO.getEstimatedCost());
			//param.put("act_amt"         , estimatedAuditVO.getAcctCode());
			param.put("act_amt"         , estimatedAuditVO.getActualCost());
			param.put("accl_amt"        , estimatedAuditVO.getAccuralAmt());
			param.put("cre_usr_id"      , account.getUsr_id());
			param.put("upd_usr_id"      , account.getUsr_id());
			param.put("loc_cd"          , estimatedAuditVO.getLocCd());
			param.put("vsl_cd"          , estimatedAuditVO.getVslCd());
			param.put("skd_voy_no"      , estimatedAuditVO.getSkdVoyNo());
			param.put("skd_dir_cd"      , estimatedAuditVO.getSkdDirCd());
			param.put("rev_dir_cd"      , estimatedAuditVO.getRevDirCd());
			param.put("locl_curr_cd"    , estimatedAuditVO.getLoclCurrCd());			
			param.put("act_dt"          , estimatedAuditVO.getActDt());
			param.put("act_plc_cd"      , estimatedAuditVO.getActPlcCd());
			param.put("slan_cd"         , estimatedAuditVO.getSlanCd());
			param.put("acct_dtl_cd"     , estimatedAuditVO.getAcctDtlCd());
			param.put("cost_act_plc_cd" , estimatedAuditVO.getCostActPlcCd());
			param.put("vndr_seq" , estimatedAuditVO.getVndrSeq());
			
		    SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(new PayableEstimateAuditDBDAOaddPayableEstimateAuditCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
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