/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EacRegRptDBDAO.java
*@FileTitle : Expense Audit case Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.01
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.12.01 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.basic.EacRegRptBCImpl;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchOfcPerfVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchOfcStatisticsVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchRegRptVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchRhqStatisticsVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchSpPerfVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS EacRegRptDBDAO <br>
 * - ALPS-Eac system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see EacRegRptBCImpl 참조
 * @since J2EE 1.6
 */
public class EacRegRptDBDAO extends DBDAOSupport {	 
	 /**
	  * 오피스/월별 비용심사 실적 조회<br>
	  * 
	  * @param searchRegRptVO
	  * @return List<SearchOfcStatisticsVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchOfcStatisticsVO> searchOfcStatistics(SearchRegRptVO searchRegRptVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchOfcStatisticsVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchRegRptVO != null){
				 Map<String, String> mapVO = searchRegRptVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacRegRptDBDAOSearchOfcStatisticsRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOfcStatisticsVO .class);
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
	  * RHQ/월별 비용심사 실적 조회<br>
	  * 
	  * @param searchRegRptVO
	  * @return List<SearchRhqStatisticsVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchRhqStatisticsVO> searchRhqStatistics(SearchRegRptVO searchRegRptVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchRhqStatisticsVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchRegRptVO != null){
				 Map<String, String> mapVO = searchRegRptVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacRegRptDBDAOSearchRhqStatisticsRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRhqStatisticsVO .class);
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
	  * Audit office 또는 Responsible Office별 실적 조회<br>
	  * 
	  * @param searchRegRptVO
	  * @return List<SearchOfcPerfVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchOfcPerfVO> searchOfcPerf(SearchRegRptVO searchRegRptVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchOfcPerfVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchRegRptVO != null){
				 Map<String, String> mapVO = searchRegRptVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacRegRptDBDAOSearchOfcPerfRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOfcPerfVO .class);
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
	  * S/P별 실적 조회<br>
	  * 
	  * @param searchRegRptVO
	  * @return List<SearchSpPerfVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchSpPerfVO> searchSpPerf(SearchRegRptVO searchRegRptVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchSpPerfVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchRegRptVO != null){
				 Map<String, String> mapVO = searchRegRptVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacRegRptDBDAOSearchSpPerfRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSpPerfVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
}

