/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_ZONE_DETAILDBDAO.java
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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmZnDtlVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmZnDtl;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmZnDtlDBDAO extends DBDAOSupport{
	
	
	/**
	 * insert
	 * ★2009-10-05 kim kwijin생성
	 * @param vos
	 * @return
	 * @throws DAOException
	 */
	public int[] addMdmZnDtl(Collection<MdmZnDtlVO> vos) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vos.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveQueueMdmZnDtlDBDAOAddMdmZnDtlCSQL(), vos,null);
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
	 * ★2009-10-05 kim kwijin생성
	 * @param vos
	 * @return
	 * @throws DAOException
	 */
	public int[] modifyMdmZnDtl(Collection<MdmZnDtlVO> vos) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vos.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveQueueMdmZnDtlDBDAOModifyMdmZnDtlUSQL(), vos,null);
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
	 * ★2009-10-05 kim kwijin수정
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMDM_ZN_DTLList(String pk, String pk1) throws DAOException{
		boolean isSuccessful = false; 
		DBRowSet dbRowset = null;
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("pk",pk);
			param.put("pk1", pk1);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueMdmZnDtlDBDAOSearchMdmZnDtlListRSQL(), param, null);
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
	public int[] removeMdmZnDtl(Collection<MdmZnDtlVO> vos) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(vos.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveQueueMdmZnDtlDBDAORemoveMdmZnDtlUSQL(), vos,null);
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
