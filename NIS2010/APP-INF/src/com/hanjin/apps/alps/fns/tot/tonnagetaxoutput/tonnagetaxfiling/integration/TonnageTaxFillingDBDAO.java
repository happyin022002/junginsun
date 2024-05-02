/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxFillingDBDAO.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.25
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 2010.11.25 이병훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.FnsTot0027ConditionVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchActualBsaSummaryVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchBasicBsaSummaryVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchHiringOutAndLayingUpSummaryVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchSummaryCreationBatchVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS TonnageTaxFillingDBDAO <br>
 * - ALPS-TonnageTaxOutput system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Byoung Hun
 * @see TonnageTaxFillingBCImpl 참조
 * @since J2EE 1.4
 */
public class TonnageTaxFillingDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * FNS_TOT_0024 : SEARCH <br>
	 * 운항중인 모든 선박(피더선박 제외)들의 기본 BSA 변동별 내역을 조회한다.<br>
	 * 
	 * @param year String
	 * @return List<SearchBasicBsaSummaryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchBasicBsaSummaryVO> searchBasicBsaSummary(String year) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBasicBsaSummaryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("year", year);
			
			dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate)new TonnageTaxFillingDBDAOSearchBasicBsaSummaryRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBasicBsaSummaryVO .class);
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
	 * FNS_TOT_0025 : SEARCH <br>
	 * 운항중인 모든 선박(피더선박 제외)들의 초과 BSA 변동별 내역을 조회한다.<br>
	 * 
	 * @param year String
	 * @return List<SearchActualBsaSummaryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchActualBsaSummaryVO> searchActualBsaSummary(String year) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchActualBsaSummaryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("year", year);
			
			dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate)new TonnageTaxFillingDBDAOSearchActualBsaSummaryRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchActualBsaSummaryVO .class);
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
	 * FNS_TOT_0026 : SEARCH <br>
	 * 대선선박과 계선선박의 내역을 조회한다.<br>
	 * 
	 * @param year String
	 * @return List<SearchActualBsaSummaryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchHiringOutAndLayingUpSummaryVO> searchHiringOutAndLayingUpSummary(String year) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchHiringOutAndLayingUpSummaryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("year", year);
			
			dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate)new TonnageTaxFillingDBDAOSearchHiringOutAndLayingUpSummaryRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchHiringOutAndLayingUpSummaryVO .class);
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
	 * 운항중인 모든 선박(피더선박 제외)들의 최신 Update Date 조회한다.<br>
	 * 
	 * @param year String
	 * @return String
	 * @exception DAOException
	 */
	public String searchBasicBsaSummaryUpdate(String year) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String upd_dt = "";
		
		try{
			param.put("year", year);
			
			dbRowset = new SQLExecuter("TOT_HJSBAT").executeQuery((ISQLTemplate)new TonnageTaxFillingDBDAOSearchUpdateRSQL(), param, null);
			while(dbRowset.next()) {
				upd_dt = dbRowset.getString("UPD_DT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return upd_dt;
	}
	
	/**
	 * FNS_TOT_0027 : Retrive <br>
	 * 해당기간의 배치 history정보를 조회한다. <br>
	 * 
	 * @param conditionVO FnsTot0027ConditionVO
	 * @param hisType String
	 * @return List<SearchSummaryCreationBatchVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSummaryCreationBatchVO> searchSummaryCreationBatch(FnsTot0027ConditionVO conditionVO, String hisType) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchSummaryCreationBatchVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(conditionVO != null){
					Map<String, String> mapVO = conditionVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				
                velParam.put("his_type", hisType);
                
		        SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
				dbRowset = sqlExe.executeQuery(new TonnageTaxFillingDBDAOSearchSummaryCreationBatchRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSummaryCreationBatchVO .class);
			}catch(SQLException ex){
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				throw new DAOException(ex.getMessage(), ex);
			}
			return list;
	 }	
	
	/**
	 * FNS_TOT_0027 : Submit <br>
	 * 해당기간의 배치 history정보를 저장한다. <br>
	 * 
	 * @param conditionVO FnsTot0027ConditionVO
	 * @param usrId String
	 * @exception DAOException
	 */
	public void addSummaryCreationBatch (FnsTot0027ConditionVO conditionVO, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			param.put("cre_usr_id", usrId);
			
            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxFillingDBDAOAddSummaryCreationBatchCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new DAOException(ex.getMessage(), ex);
		}
	}		 

	/**
	 * FNS_TOT_0027 : Cancel <br>
	 * 해당기간의 배치history정보를 삭제한다. <br>
	 * 
	 * @param jobID String
	 * @exception DAOException
	 */
	public void removeSummaryCreationBatch (String jobID) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("jb_id", jobID);

            SQLExecuter sqlExe = new SQLExecuter("TOT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TonnageTaxFillingDBDAORemoveSummaryCreationBatchDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException ex) {
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new DAOException(ex.getMessage(), ex);
		}
	}

}
