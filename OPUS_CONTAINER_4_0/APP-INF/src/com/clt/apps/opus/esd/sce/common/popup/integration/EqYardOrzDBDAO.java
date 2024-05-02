/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EqYardOrzDBDAO.java
*@FileTitle : EsdSce114
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.07.30 신한성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.popup.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.common.popup.vo.ComOfficeManagementVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.EQYARDManageConditionVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.EQYARDManageVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * EqYardOrzDBDAO <br>
 * - common system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Shin Han Sung
 * @see popupBCImpl 참조
 * @since J2EE 1.6
 */
public class EqYardOrzDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * EQ YARD 조회
	 * 
	 * @param EQYARDManageConditionVO eqYARDManageConditionVO
	 * @return List<EQYARDManageVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EQYARDManageVO> searchEQYARDManage(EQYARDManageConditionVO eqYARDManageConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EQYARDManageVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eqYARDManageConditionVO != null){
				Map<String, String> mapVO = eqYARDManageConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EqYardOrzDBDAOSearchEQYARDManageRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EQYARDManageVO .class);
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
	 * @param ComOfficeManagementVO comOfficeManagementVO
	 * @return List<ComOfficeManagementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ComOfficeManagementVO> searchExptInqMapgOfc(ComOfficeManagementVO comOfficeManagementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComOfficeManagementVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comOfficeManagementVO != null){
				Map<String, String> mapVO = comOfficeManagementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EqYardOrzDBDAOSearchExptInqMapgOfcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComOfficeManagementVO .class);
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
	 * @param ComOfficeManagementVO comOfficeManagementVO
	 * @return List<ComOfficeManagementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ComOfficeManagementVO> searchExptMapgOfc(ComOfficeManagementVO comOfficeManagementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComOfficeManagementVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			log.debug(comOfficeManagementVO.getDist());
			if(comOfficeManagementVO != null){
				Map<String, String> mapVO = comOfficeManagementVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				log.debug("dist = " + velParam.get("dist"));
				
				if (velParam.get("dist").equals("mapgofccd")) {
					if (velParam.get("ofc_txt") != null && !velParam.get("ofc_txt").equals("")) {
						if (velParam.get("ofc_txt") != null & !((String) velParam.get("ofc_txt")).trim().equals("")) {
							velParam.put("ofc_txt", ((String) velParam.get("ofc_txt")).toUpperCase().split(","));
						}
					}
				}
			}					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EqYardOrzDBDAOSearchExptMapgOfcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComOfficeManagementVO .class);
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