/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_ZONE_TOTALDBDAO.java
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmZnDtlVO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmZoneVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmZnDtl;
import com.hanjin.syscommon.common.table.MdmZone;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmZnGeneralDBDAO extends DBDAOSupport{
	
	
	/**
	 * insert
	 * ★2009-10-06 kim kwijin생성
	 * @param vos
	 * @return
	 * @throws DAOException
	 */
	public int[] addMdmZnGeneral(Collection<MdmZoneVO> vos) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vos.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveQueueMdmZnGeneralDBDAOAddMdmZnGeneralCSQL(), vos,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * update
	 * ★2009-10-06 kim kwijin생성
	 * @param vos
	 * @return
	 * @throws DAOException
	 */
	public int[] modifyMdmZnGeneral(Collection<MdmZoneVO> vos) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vos.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveQueueMdmZnGeneralDBDAOModifyMdmZnGeneralUSQL(), vos,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
		
	}
	
	
	/**
	 * add prd_node
	 * ★2009-10-06 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int addPrdNode(MdmZoneVO vo)throws DAOException{
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
			result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveQueueMdmZnGeneralDBDAOAddPrdNodeCSQL(), param, velParam);
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
	 * modify prd_node
	 * ★2009-10-06 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int modifyPrdNode(MdmZoneVO vo)throws DAOException{
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
			result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveQueueMdmZnGeneralDBDAOModifyPrdNodeUSQL(), param, velParam);
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
	 * 기존 데이타 유무 확인
	 * ★2009-10-06 kim kwijin수정
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueMdmZnGeneralDBDAOSearchPrdNodeListRSQL(), param, null);
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
	 * delete prd_node
	 * ★2009-10-06 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int removePrdNode(MdmZoneVO vo) throws DAOException{
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
			result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveQueueMdmZnGeneralDBDAORemovePrdNodeUSQL(), param, velParam);
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
	 * insert mdmZnDtl
	 * ★2009-10-06 kim kwijin생성
	 * @param vos
	 * @param zn_cd
	 * @return
	 * @throws DAOException
	 */
	public int[] addMdmZnDtl(Collection<MdmZnDtlVO> vos) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vos.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveQueueMdmZnGeneralDBDAOAddMdmZnDtlCSQL(), vos,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * ★2009-10-06 kim kwijin생성
	 * @param vos
	 * @return
	 * @throws DAOException
	 */
	public int[] modifyMdmZnDtl(Collection<MdmZnDtlVO> vos) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vos.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveQueueMdmZnGeneralDBDAOModifyMdmZnDtlUSQL(), vos,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
		
	}
	
	
	/**
	 * 기존 데이타 유무 확인
	 * ★2009-10-06 kim kwijin수정
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMDM_ZONE_TOTALList(String pk) throws DAOException{
		boolean isSuccessful = false; 
		DBRowSet dbRowset = null;
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("pk",pk);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueMdmZnGeneralDBDAOSearchMdmZoneTotalListRSQL(), param, null);
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
	 * 기존 데이타 확인 유무
	 * ★2009-10-06 kim kwijin 수정
	 * @param pk
	 * @param pk1
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMDM_ZN_DTLList(String pk,String pk1) throws DAOException{
		boolean isSuccessful = false; 
		DBRowSet dbRowset = null;
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("pk",pk);
			param.put("pk1", pk1);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueMdmZnGeneralDBDAOSearchMdmZnDtlListRSQL(), param, null);
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
	 * @param vos
	 * @return
	 * @throws DAOException
	 */
	public int[] removeMdmZnGeneral(Collection<MdmZoneVO> vos) throws DAOException{
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vos.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveQueueMdmZnGeneralDBDAORemoveMdmZnGeneralUSQL(), vos,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
		
	}
	
	
	
}
