/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AocPopUpDBDAO.java
*@FileTitle : Cost Batch
*Open Issues :
*Change history :
*@LastModifyDate : 2012-10-04
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aocpopup.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.aoc.common.aocpopup.vo.FdrCostBatchErrorVO;
import com.hanjin.apps.alps.esd.aoc.common.aocpopup.vo.InlandCostBatchErrorVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-AOC에 대한 DB 처리를 담당<br>
 * - ESD-AOC Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 
 * @see CostBatchBCImpl 참조
 * @since J2EE 1.4
 */
public class AocPopUpDBDAO extends DBDAOSupport {
	
	/**
	 * Inland Cost Batch Error 조회.<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	public List<InlandCostBatchErrorVO> searchInlandCostBatchError(InlandCostBatchErrorVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InlandCostBatchErrorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if( inputVO != null ){
				Map<String, String> mapVO = inputVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AocPopUpDBDAOSearchInlandCostBatchErrorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InlandCostBatchErrorVO .class);
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
	 * Inland Cost Batch Error 조회.<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws DAOException
	 */
	public List<FdrCostBatchErrorVO> searchFdrCostBatchError(FdrCostBatchErrorVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FdrCostBatchErrorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if( inputVO != null ){
				Map<String, String> mapVO = inputVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AocPopUpDBDAOSearchFdrCostBatchErrorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FdrCostBatchErrorVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
}