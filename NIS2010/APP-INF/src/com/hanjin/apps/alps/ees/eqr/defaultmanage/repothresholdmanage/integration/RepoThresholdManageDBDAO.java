/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RepoThresholdManageDBDAO.java
*@FileTitle : Red Light Alert 기준 조회/수정---이송 계획 Input Data
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-20
*@LastModifier : chung eun ho
*@LastVersion : 1.0
* 2009-07-20 chung eun ho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.basic.RepoThresholdManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.vo.RepoThresholdManageRsVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.vo.SearchRepoPlanRLAThresholdVO;
import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.EqrObFcastRedLgtAltVO;
import com.hanjin.syscommon.common.table.EqrRepoExePlnFbExptVO;
import com.hanjin.syscommon.common.table.EqrRepoExePlnFbVO;
import com.hanjin.syscommon.common.table.EqrRepoPlnRedLgtAltDtlVO;
import com.hanjin.syscommon.common.table.EqrRepoPlnRedLgtAltMstVO;


/**
 * ENIS-EQR에 대한 DB 처리를 담당<br>
 * - ENIS-EQR Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author chung eun ho
 * @see RepoThresholdManageBCImpl 참조
 * @since J2EE 1.6
 */
public class RepoThresholdManageDBDAO extends DBDAOSupport {

	/**
	 * EES_EQR_001Event 의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * EES_EQR_001
	 * @return RepoThresholdManageRsVO
	 * @exception DAOException
	 */
	public RepoThresholdManageRsVO searchCntrRepoPlanInputDataRLAThreshold() throws DAOException {
		RepoThresholdManageRsVO retVO = new RepoThresholdManageRsVO();
		DBRowSet dRs = null;

		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("intg_cd_id_1", Constants.INTG_CD_ID_1);
			param.put("intg_cd_id_2", Constants.INTG_CD_ID_2);
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new RepoThresholdManageDBDAOSearchCntrInputDataRSQL(), param, null);			
			retVO.setDBRowSet(dRs);
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
	 * EES_EQR_001Event 의 존재여부.<br> 2009-07-20 정은호 사용하지 않는 메소드로 확인됨
	 * 
	 * @return boolean
	 * @exception DAOException
	 * searchCntrRepoPlanRLAIsExist
	 */
	
	
	/**
	 * EqrInpDatRedLgtAltVO 의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.( 수정 )<br>
	 * EES_EQR_0001
	 * 
	 * @param List updtModels
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void multiCntrRepoPlanInputDataRLAThreshold(List updtModels) throws DAOException {
		int updtCnt[] = null; 		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			updtCnt = sqlExe.executeBatch((ISQLTemplate)new RepoThresholdManageDBDAOUpdateCntrInputDataRLAUSQL(), updtModels,null);
			for(int i = 0; i < updtCnt.length; i++){
				if(updtCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * RepoThresholdManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @return List<SearchRepoPlanRLAThresholdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchRepoPlanRLAThresholdVO> searchCntrRepoPlanRLAThreshold() throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRepoPlanRLAThresholdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepoThresholdManageDBDAOSearchRepoPlanRLAThresholdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRepoPlanRLAThresholdVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * RepoThresholdManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param rccCd String
	 * @param tpsz String
	 * @return DBRowSet
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchCntrRepoPlanRLADTLThreshold(String rccCd, String tpsz) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			ArrayList tpszarr = (ArrayList) Utils.replaceStrToList(tpsz);
			
			velParam.put("tpszarr", tpszarr);
			param.put("rcc_cd", rccCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepoThresholdManageDBDAOSearchRepoPlanRLADTLThresholdRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrRepoPlnRedLgtAltMstVO>
	 * @exception DAOException
	 */
	public void modifyCntrRepoPlanRLAThreshold(List<EqrRepoPlnRedLgtAltMstVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RepoThresholdManageDBDAOMergeRepoPlanRLAThresholdCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrRepoPlnRedLgtAltDtlVO>
	 * @exception DAOException
	 */
	public void modifyCntrRepoPlanRLADTLThreshold(List<EqrRepoPlnRedLgtAltDtlVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RepoThresholdManageDBDAOMergeRepoPlanRLADTLThresholdCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * RepoThresholdManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param tpsz String
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchExecutionFeedback(String tpsz) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			ArrayList tpszarr = (ArrayList) Utils.replaceStrToList(tpsz);
			
			velParam.put("tpszarr", tpszarr);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepoThresholdManageDBDAOSearchExecutionFeedBackRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * RepoThresholdManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param tpsz String
	 * @return DBRowSet
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchExecutionFeedbackExpt(String tpsz) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			ArrayList tpszarr = (ArrayList) Utils.replaceStrToList(tpsz);
			
			velParam.put("tpszarr", tpszarr);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepoThresholdManageDBDAOSearchExecutionFeedBackExptRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrRepoExePlnFbVO>
	 * @exception DAOException
	 */
	public void mergeExecutionFeedBack(List<EqrRepoExePlnFbVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RepoThresholdManageDBDAOMergeExecutionFeedBackCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrRepoExePlnFbVO>
	 * @exception DAOException
	 */
	public void mergeSubExecutionFeedBack(List<EqrRepoExePlnFbVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RepoThresholdManageDBDAOMergeSubExecutionFeedBackCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrRepoExePlnFbExptVO>
	 * @exception DAOException
	 */
	public void mergeExecutionFeedBackExpt(List<EqrRepoExePlnFbExptVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RepoThresholdManageDBDAOMergeExecutionFeedBackExptCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param delModels List
	 * @param isMain String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void deleteExecutionFeedBackExpt(List delModels, String isMain) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			List<EqrRepoExePlnFbVO> mainDelModels = new ArrayList<EqrRepoExePlnFbVO>();
			List<EqrRepoExePlnFbExptVO> subDelModels = new ArrayList<EqrRepoExePlnFbExptVO>();
			
			if ("Y".equals(isMain)) {
				mainDelModels = delModels;
			} else {
				subDelModels = delModels;
			}
			
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("ismain", isMain);
			
			if(mainDelModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RepoThresholdManageDBDAODeleteExecutionFeedBackExptDSQL(), mainDelModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			} else if (subDelModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RepoThresholdManageDBDAODeleteExecutionFeedBackExptDSQL(), subDelModels, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * RepoThresholdManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param tpsz String
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchCntrForecastRLAThreshold(String tpsz) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			ArrayList tpszarr = (ArrayList) Utils.replaceStrToList(tpsz);
			
			velParam.put("tpszarr", tpszarr);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepoThresholdManageDBDAOSearchCntrFcastRLAThresholdRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * RepoThresholdManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param eqrObFcastRedLgtAltVOs EqrObFcastRedLgtAltVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO checkCntrFcstRLSThreshold(EqrObFcastRedLgtAltVO eqrObFcastRedLgtAltVOs) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = eqrObFcastRedLgtAltVOs .getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepoThresholdManageDBDAOCheckCntrFcstRLSThresholdRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrObFcastRedLgtAltVO>
	 * @exception DAOException
	 */
	public void insertCntrFcstRLSThreshold(List<EqrObFcastRedLgtAltVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RepoThresholdManageDBDAOInsertCntrFcstRLSThresholdCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrObFcastRedLgtAltVO>
	 * @exception DAOException
	 */
	public void updateCntrFcstRLSThresholdRatio(List<EqrObFcastRedLgtAltVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RepoThresholdManageDBDAOUpdateCntrFcstRLSThresholdRatioUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrObFcastRedLgtAltVO>
	 * @exception DAOException
	 */
	public void updateCntrFcstRLSThresholdVol(List<EqrObFcastRedLgtAltVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RepoThresholdManageDBDAOUpdateCntrFcstRLSThresholdVolUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	
}
