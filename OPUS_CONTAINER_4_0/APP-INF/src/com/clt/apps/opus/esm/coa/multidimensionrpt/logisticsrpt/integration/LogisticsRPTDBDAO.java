/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : MultiDimensionRPTDBDAO.java
 *@FileTitle : LogisticsRPTDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 2006-11-09 Sangwook_nam
 * 1.0 최초 생성
 * =========================================================
 * History
 =========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.basic.LogisticsRPTBCImpl;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLgstConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0080ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0080ListVO2;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0081ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0081ListVO2;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0082ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0082ListVO2;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0158ListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS-COA에 대한 DB 처리를 담당<br> - OPUS-COA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sangwook_nam
 * @see LogisticsRPTBCImpl 참조
 * @since J2EE 1.4
 */
public class LogisticsRPTDBDAO extends DBDAOSupport {
	 
    /**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0080ListVO>
	 * @throws DAOException
	*/
	public List<SearchLogisticsRPT0080ListVO> searchLogisticsRPT0080List(SearchLgstConditionVO searchLgstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLogisticsRPT0080ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchLgstConditionVO != null){
				Map<String, String> mapVO = searchLgstConditionVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRPTDBDAOSearchLogisticsRPT0080ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLogisticsRPT0080ListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0080ListVO2>
	 * @throws DAOException
	*/
	public List<SearchLogisticsRPT0080ListVO2> searchLogisticsRPT0080List2(SearchLgstConditionVO searchLgstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLogisticsRPT0080ListVO2> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchLgstConditionVO != null){
				Map<String, String> mapVO = searchLgstConditionVO .getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRPTDBDAOSearchLogisticsRPT0080ListVO2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLogisticsRPT0080ListVO2 .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0081ListVO>
	 * @throws DAOException
	*/
	public List<SearchLogisticsRPT0081ListVO> searchLogisticsRPT0081List(SearchLgstConditionVO searchLgstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLogisticsRPT0081ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchLgstConditionVO != null){
				Map<String, String> mapVO = searchLgstConditionVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRPTDBDAOSearchLogisticsRPT0081ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLogisticsRPT0081ListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0081ListVO2>
	 * @throws DAOException
	*/
	public List<SearchLogisticsRPT0081ListVO2> searchLogisticsRPT0081List2(SearchLgstConditionVO searchLgstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLogisticsRPT0081ListVO2> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchLgstConditionVO != null){
				Map<String, String> mapVO = searchLgstConditionVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRPTDBDAOSearchLogisticsRPT0081ListVO2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLogisticsRPT0081ListVO2 .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0082ListVO>
	 * @throws DAOException
	*/
	public List<SearchLogisticsRPT0082ListVO> searchLogisticsRPT0082List(SearchLgstConditionVO searchLgstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLogisticsRPT0082ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchLgstConditionVO != null){
				Map<String, String> mapVO = searchLgstConditionVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRPTDBDAOSearchLogisticsRPT0082ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLogisticsRPT0082ListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0082ListVO2>
	 * @throws DAOException
	*/
	public List<SearchLogisticsRPT0082ListVO2> searchLogisticsRPT0082List2(SearchLgstConditionVO searchLgstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLogisticsRPT0082ListVO2> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchLgstConditionVO != null){
				Map<String, String> mapVO = searchLgstConditionVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRPTDBDAOSearchLogisticsRPT0082ListVO2RSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLogisticsRPT0082ListVO2 .class);
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
	 * Logistics Vol. by Offic를 조회한다.<br>
	 * 
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0158ListVO>
	 * @throws DAOException
	*/
	public List<SearchLogisticsRPT0158ListVO> searchLogisticsRPT0158List(SearchLgstConditionVO searchLgstConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLogisticsRPT0158ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchLgstConditionVO != null){
				Map<String, String> mapVO = searchLgstConditionVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LogisticsRPTDBDAOSearchLogisticsRPT0158ListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLogisticsRPT0158ListVO .class);
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