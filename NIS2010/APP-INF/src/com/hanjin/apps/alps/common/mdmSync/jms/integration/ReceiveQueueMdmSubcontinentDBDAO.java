/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_SUB_CONTINENTDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-10-05
 *@LastModifier : Kim kwi-jin
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmSubcontinentVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmSubcontinentDBDAO extends DBDAOSupport{
	
	
	/**
	 * addMdmSubcontinent(다건)
	 * ★2009-10-05 kim kwijin생성
	 * @param vos
	 * @return
	 * @throws DAOException
	 */
	public int[] addMdmSubcontinent(Collection<MdmSubcontinentVO> vos) throws DAOException{
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vos.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveQueueMdmSubcontinentDBDAOInsertMdmSubcontinentCSQL(), vos,null);
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
	 * modifyMdmSubcontinent(다건)
	 * ★2009-10-05 kim kwijin생성
	 * @param vos
	 * @return
	 * @throws DAOException
	 */
	public int[] modifyMdmSubcontinent(Collection<MdmSubcontinentVO> vos) throws DAOException{
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vos.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveQueueMdmSubcontinentDBDAOModifyMdmSubcontinentUSQL(), vos,null);
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
	 * addMdmSubcontinent
	 * ★2009-10-05 kim kwijin생성
	 * @param vos
	 * @return
	 * @throws DAOException
	 */
	public int addMdmSubcontinent(MdmSubcontinentVO vo) throws DAOException{
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
			result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveQueueMdmSubcontinentDBDAOInsertMdmSubcontinentCSQL(), param, velParam);
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
	 * modifyMdmSubcontinent
	 * ★2009-10-05 kim kwijin생성
	 * @param vos
	 * @return
	 * @throws DAOException
	 */
	public int modifyMdmSubcontinent (MdmSubcontinentVO vo) throws DAOException{
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
			result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveQueueMdmSubcontinentDBDAOModifyMdmSubcontinentUSQL(), param, velParam);
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
	 * ★2009-10-05 kim kwijin생성
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMDM_SUBCONTINENTList(String pk) throws DAOException{
		DBRowSet dbRowset = null;
		boolean isSuccessful = false; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
//				param.put("class_name", this.getClass().getName());
				log.debug("\n\n ========= pk:"+pk);
				param.put("sconti_cd", pk);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueMdmSubcontinentDBDAOSearchMdmSubContinentListRSQL(), param, null);
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
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int removeMdmSubcontinent(MdmSubcontinentVO vo) throws DAOException{
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
			result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveQueueMdmSubcontinentDBDAORemoveMdmSubcontinentUSQL(), param, velParam);
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