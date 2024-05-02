/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceScopeDBDAO.java
*@FileTitle : Service Scope Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.07 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.basic.ServiceScopeBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.vo.CstSvcScpVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.vo.RsltMdmSvcScpLaneVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.vo.RsltMdmSvcScpLmtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmSvcScpVO;


/**
 * ALPS ServiceScopeDBDAO <br>
 * - ALPS-PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JaeYeon Kim
 * @see ServiceScopeBCImpl 참조
 * @since J2EE 1.6
 */
public class ServiceScopeDBDAO extends DBDAOSupport {

	/**
	 * Service Spope 정보를 조회합니다.<br>
	 * 
	 * @param CstSvcScpVO cstSvcScpVO
	 * @return List<MdmSvcScpVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmSvcScpVO> searchServiceScopeList(CstSvcScpVO cstSvcScpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmSvcScpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstSvcScpVO != null){
				Map<String, String> mapVO = cstSvcScpVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ServiceScopeDBDAOMdmSvcScpVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmSvcScpVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * Service Spope Lane 정보를 조회합니다.<br>
	 * 
	 * @param CstSvcScpVO cstSvcScpVO
	 * @return List<RsltMdmSvcScpLaneVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltMdmSvcScpLaneVO> searchServiceScopeLaneList(CstSvcScpVO cstSvcScpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltMdmSvcScpLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstSvcScpVO != null){
				Map<String, String> mapVO = cstSvcScpVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ServiceScopeDBDAOMdmSvcScpLaneVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltMdmSvcScpLaneVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * Service Spope Origin Destination 정보를 조회합니다.<br>
	 * 
	 * @param CstSvcScpVO cstSvcScpVO
	 * @return List<RsltMdmSvcScpLmtVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltMdmSvcScpLmtVO> searchServiceScopeOriginDestinationList(CstSvcScpVO cstSvcScpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltMdmSvcScpLmtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstSvcScpVO != null){
				Map<String, String> mapVO = cstSvcScpVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ServiceScopeDBDAOMdmSvcScpLmtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltMdmSvcScpLmtVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * Service Spope Origin Destination 정보를 조회합니다.<br>
	 * 
	 * @param CstSvcScpVO cstSvcScpVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkCodeValue(CstSvcScpVO cstSvcScpVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rsltVal = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cstSvcScpVO != null){
				Map<String, String> mapVO = cstSvcScpVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ServiceScopeDBDAOCheckCodeValueRSQL(), param, velParam);
			if(dbRowset != null && dbRowset.next()) {
				rsltVal = dbRowset.getString("FLAG");
			}

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rsltVal;
	}
}