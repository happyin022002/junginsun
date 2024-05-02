/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_ZONEDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-10-05
 *@LastModifier : Kim Kwijin
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmYardVO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmZoneVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmZone;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmZoneDBDAO extends DBDAOSupport{
	
	
	
	/**
	 * insert
	 * ★2009-10-05 kim kwijin생성
	 * @param vos
	 * @return
	 * @throws DAOException
	 */
	public int addMdmZone(MdmZoneVO vo) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveQueueMdmZoneDBDAOAddMdmZoneCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 *  update
	 *  ★2009-10-05 kim kwijin생성
	 * @param vos
	 * @return
	 * @throws DAOException
	 */
	public int modifyZone(MdmZoneVO vo) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveQueueMdmZoneDBDAOModifyMdmZoneUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	/**
	 * insert(prd_node table)
	 * ★2009-10-05 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int addPrdNode(MdmZoneVO vo) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveQueueMdmZoneDBDAOAddPrdNodeCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * update(prd_node table)
	 * ★2009-10-05 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int modifyPrdNode(MdmZoneVO vo) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveQueueMdmZoneDBDAOModifyPrdNodeUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	
	/**
	 * 기존 데이타 유무 확인
	 * ★2009-10-05 kim kwijin수정
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean searchPRD_NODEList(String pk) throws DAOException{
		boolean isSuccessful = false; 
		DBRowSet dbRowset = null;
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("pk",pk);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueMdmZoneDBDAOSearchPrdNodeListRSQL(), param, null);
			if(dbRowset.getRowCount() <= 0)
				isSuccessful = true;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isSuccessful;

	}
	
	
	
	/**
	 * Delete prd_node
	 * ★2009-10-05 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int removePrdNode(MdmZoneVO vo )throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveQueueMdmZoneDBDAORemovePrdNodeUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
		
	}
	
	
	
	/**
	 * 기존 데이타 유무 확인
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMDM_ZONEList(String pk) throws DAOException{
		boolean isSuccessful = false; 
		DBRowSet dbRowset = null;
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("pk",pk);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueMdmZoneDBDAOSearchMdmZoneListRSQL(), param, null);
			if(dbRowset.getRowCount() <= 0)
				isSuccessful = true;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isSuccessful;
	}
	
	
	/**
	 * delete
	 * ★2009-10-05 kim kwijin생성
	 * @param vos
	 * @return
	 * @throws DAOException
	 */
	public int removeMdmZone(MdmZoneVO vo) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveQueueMdmZoneDBDAORemoveMdmZoneUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
		
	}
	
}