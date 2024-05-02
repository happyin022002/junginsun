/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOEstimatedDBDAO.java
*@FileTitle : Estimated I/F To ERP(RV)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.06.24 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.basic.TCharterIOEstimatedBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.CustomEstmIfVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedHireResultListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedRevenueListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 TCharterIOEstimatedDBDAO <br>
 * - NIS2010-TimeCharterInOutAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon, Seyeong
 * @see TCharterIOEstimatedBCImpl 참조
 * @since J2EE 1.6
 */
public class TCharterIOEstimatedDBDAO extends DBDAOSupport {

	/**
	 * 
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 조회한다<br>
	 * 
	 * @param estRevMmFrom String
	 * @param estRevMmTo String
	 * @param fletCtrtTpCd String
	 * @param seachTpCd String
	 * @return List<SearchEstimatedRevenueListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEstimatedRevenueListVO> searchEstimatedRevenueList(String estRevMmFrom , String estRevMmTo , String fletCtrtTpCd, String seachTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEstimatedRevenueListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("fr_duration", estRevMmFrom);
			param.put("to_duration", estRevMmTo);
			param.put("flet_ctrt_tp_cd", fletCtrtTpCd);
			//retrieve인 경우
			if (seachTpCd.equals("C")) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOEstimatedDBDAOSearchEstimatedRevenueListVORSQL(), param, velParam);
			} else {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOEstimatedDBDAOSearchEstimatedRevenueCListVORSQL(), param, velParam);
			}
			
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEstimatedRevenueListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 조회한다<br>
	 * 
	 * @param customEstmIfVO List<CustomEstmIfVO>
	 * @throws DAOException
	 */
	public void addEstimatedRevenues(List<CustomEstmIfVO> customEstmIfVO) throws DAOException,Exception {
		try {
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("est_type", "RV");

			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customEstmIfVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOEstimatedDBDAOCustomEstmIfVOCSQL(), customEstmIfVO,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 조회한다<br>
	 * 
	 * @param estRevMm String
	 * @return List<SearchEstimatedProRevenueListVO>
	 * @exception EventException
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEstimatedProRevenueListVO> searchEstimatedProRevenueList(String estRevMm) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEstimatedProRevenueListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			
			param.put("exe_yrmon", estRevMm);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOEstimatedDBDAOSearchEstimatedProRevenueListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEstimatedProRevenueListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 결과를 등록한다<br>
	 * 
	 * @param customEstmIfVO List<CustomEstmIfVO>
	 * @throws DAOException
	 */
	public void addEstimatedProRevenues(List<CustomEstmIfVO> customEstmIfVO) throws DAOException,Exception {
		try {
	
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("est_type", "PV");
	
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customEstmIfVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOEstimatedDBDAOCustomEstmIfVOCSQL(), customEstmIfVO,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 자료를 조회한다<br>
	 * 
	 * @param estRevMmFrom String
	 * @param estRevMmTo String
	 * @param fletCtrtTpCd String
	 * @return List<SearchEstimatedHireResultListVO>
	 * @throws DAOException
	*/

	 @SuppressWarnings("unchecked")
	public List<SearchEstimatedHireResultListVO> searchEstimatedHireResultList(String estRevMmFrom , String estRevMmTo , String fletCtrtTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEstimatedHireResultListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			
			param.put("fr_duration", estRevMmFrom);
			param.put("to_duration", estRevMmTo);
			param.put("flet_ctrt_tp_cd", fletCtrtTpCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOEstimatedDBDAOSearchEstimatedHireResultListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEstimatedHireResultListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * 용/대선료 월별 수입대상항차 기준 항차 별 데이터를 삭제한다<br>
	 * 
	 * @param customEstmIfVO CustomEstmIfVO
	 * @throws DAOException
	 */
	public void removeEstimated(CustomEstmIfVO customEstmIfVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		
		try {
			Map<String, String> mapVO = customEstmIfVO.getColumnValues();
			param.putAll(mapVO);

			if(customEstmIfVO.getEstmVvdTpCd().equals("PV")) {
				velParam.put("est_type", "PV");
			} else {
				velParam.put("est_type", "RV");
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOEstimatedDBDAOCustomEstmIfVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
}