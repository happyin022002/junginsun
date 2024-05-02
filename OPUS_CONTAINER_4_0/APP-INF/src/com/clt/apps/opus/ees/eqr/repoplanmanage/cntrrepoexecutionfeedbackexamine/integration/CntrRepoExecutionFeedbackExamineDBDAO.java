/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionFeedbackExamineDBDAO.java
*@FileTitle : 컨테이너 이송실행 실적 및 Feedback 조회
*Open Issues :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.common.Utils;
import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.basic.CntrRepoExecutionFeedbackExamineBCImpl;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.vo.EesEqr0063ConditionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 *  CntrRepoExecutionFeedbackExamineDBDAO <br>
 * - -RepoPlanManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see CntrRepoExecutionFeedbackExamineBCImpl 참조
 * @since J2EE 1.6
 */
public class CntrRepoExecutionFeedbackExamineDBDAO extends DBDAOSupport {

	/**
	 * 컨테이너 이송실행 실적 및 Feedback 조회 이벤트 처리 (Sheet1)<br>
	 * 
	 * @param EesEqr0063ConditionVO conditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchCntrRepoExecutionFeedback(EesEqr0063ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			String fmPlnSYrWk   = conditionVO.getFmplnsyr() + conditionVO.getFmplnswk();
			String fmPlnEYrWk   = conditionVO.getFmplneyr() + conditionVO.getFmplnewk();
			String toPlnSYrWk   = conditionVO.getToplnsyr() + conditionVO.getToplnswk();
			String toPlnEYrWk   = conditionVO.getToplneyr() + conditionVO.getToplnewk();
			ArrayList arrFmEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getFmecccd());
			ArrayList arrToEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getToecccd());
			ArrayList arrOddtpszCd = (ArrayList) Utils.replaceStrToList(conditionVO.getOddtpsz());
			ArrayList arrLane = (ArrayList) Utils.replaceStrToList(conditionVO.getLane());
		
			param.putAll(mapVO);
			param.put("fmPlnSYrWk", fmPlnSYrWk);
			param.put("fmPlnEYrWk", fmPlnEYrWk);
			param.put("toPlnSYrWk", toPlnSYrWk);
			param.put("toPlnEYrWk", toPlnEYrWk);
			
			velParam.putAll(mapVO);
			velParam.put("fmPlnSYrWk", fmPlnSYrWk);
			velParam.put("fmPlnEYrWk", fmPlnEYrWk);
			velParam.put("toPlnSYrWk", toPlnSYrWk);
			velParam.put("toPlnEYrWk", toPlnEYrWk);
			
			velParam.put("arrFmEccCd", arrFmEccCd);
			velParam.put("arrToEccCd", arrToEccCd);
			velParam.put("arrOddtpszCd", arrOddtpszCd);
			velParam.put("arrLane", arrLane);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionFeedbackExamineDBDAOSearchCntrRepoExecutionFeedbackRSQL(), param, velParam);
			
			rsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * 해당주차의 전주차를 가져오는 로직
	 * 
	 * @param yrwk
	 * @return
	 * @exception DAOException
	 */
	public CommonRsVO searchBeforePlnWk(String yrwk) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("yrwk", yrwk);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionFeedbackExamineDBDAOSearchBeforePlnWkRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				rsVO.setResultString(dbRowset.getString("PLNWEEK"));
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * 컨테이너 이송실행 실적 및 Feedback 조회 이벤트 처리 (Sheet2)<br>
	 * 
	 * @param EesEqr0063ConditionVO conditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchCntrRepoExecutionFeedbcakExamine(EesEqr0063ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			String plnYrWk = conditionVO.getPlnYrwk().substring(0,4) + conditionVO.getPlnYrwk().substring(5,7);
			String beforePlnSYrWk = searchBeforePlnWk(conditionVO.getFmsyrwk()).getResultString();
			ArrayList arrHeadTitle = (ArrayList) Utils.replaceStrToList(conditionVO.getHeadtitle());
			ArrayList arroddtpszCd = (ArrayList) Utils.replaceStrToList(conditionVO.getOddtpsz());
		
			param.putAll(mapVO);
			param.put("plnYrWk", plnYrWk);
			param.put("beforePlnSYrWk", beforePlnSYrWk);
			
			velParam.putAll(mapVO);
			velParam.put("arrHeadTitle", arrHeadTitle);
			velParam.put("arroddtpszCd", arroddtpszCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionFeedbackExamineDBDAOSearchCntrRepoExecutionFeedbackExamineRSQL(), param, velParam);
			
			rsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
}