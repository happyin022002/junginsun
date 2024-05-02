/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PaperlessDBDAO.java
*@FileTitle : Paperless
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.01
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.09.01 차상영
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.paperless.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.bizcommon.paperless.vo.SearchPaperlessListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 PaperlessDBDAO <br>
 * - NIS2010-BizCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author cha sangyoung
 * @see PaperlessBCImpl 참조
 * @since J2EE 1.4
 */
public class PaperlessDBDAO extends DBDAOSupport {

	
	/**
	 * 조회 이벤트 처리<br>
	 *  Paperless화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param searchPaperlessListVO   SearchPaperlessListVO
	 * @return List<SearchPaperlessListVO>
	 * @exception DAOException
	 */
	public List<SearchPaperlessListVO> searchPaperlessListALPSA(SearchPaperlessListVO searchPaperlessListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPaperlessListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchPaperlessListVO != null){
				Map<String, String> mapVO = searchPaperlessListVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PaperlessDBDAOSearchPaperlessListALPSARSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPaperlessListVO .class);
            
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
	 * 조회 이벤트 처리<br>
	 *  Paperless화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param searchPaperlessListVO   SearchPaperlessListVO
	 * @return List<SearchPaperlessListVO>
	 * @exception DAOException
	 */
	public List<SearchPaperlessListVO> searchPaperlessListALPSB(SearchPaperlessListVO searchPaperlessListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPaperlessListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchPaperlessListVO != null){
				Map<String, String> mapVO = searchPaperlessListVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("CIM_HJSBAT").executeQuery((ISQLTemplate)new PaperlessDBDAOSearchPaperlessListALPSBRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPaperlessListVO .class);
            
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
