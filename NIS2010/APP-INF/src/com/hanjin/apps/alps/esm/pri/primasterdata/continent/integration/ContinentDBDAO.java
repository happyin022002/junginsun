/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContinentDBDAO.java
*@FileTitle : Continent-Subcontinent Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.14 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.continent.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.primasterdata.continent.basic.ContinentBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.continent.vo.ContinentVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmContinentVO;
import com.hanjin.syscommon.common.table.MdmSubcontinentVO;


/**
 * ALPS ContinentDBDAO <br>
 * - ALPS-PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author JaeYeon Kim
 * @see ContinentBCImpl 참조
 * @since J2EE 1.6
 */
public class ContinentDBDAO extends DBDAOSupport {

	/**
	 * Continent List 정보를 조회합니다. <br>
	 * 
	 * @param ContinentVO continentVO
	 * @return List<MdmContinentVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmContinentVO> searchContinentList(ContinentVO continentVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmContinentVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(continentVO != null){
				Map<String, String> mapVO = continentVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContinentDBDAOMdmContinentVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmContinentVO .class);
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
	 * Sub Continent List 정보를 조회합니다. <br>
	 * 
	 * @param ContinentVO continentVO
	 * @return List<MdmSubcontinentVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmSubcontinentVO> searchSubcontinentList(ContinentVO continentVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmSubcontinentVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(continentVO != null){
				Map<String, String> mapVO = continentVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContinentDBDAOMdmSubcontinentVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmSubcontinentVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}