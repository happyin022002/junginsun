/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_CONTINENTDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
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
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmContinent;
import com.hanjin.syscommon.common.table.MdmContinentVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmContinentDBDAO extends DBDAOSupport{
	
	/**
	 * 
	 * @param MdmContinentVOs
	 * @return
	 * @throws DAOException
	 */
	public boolean addMdmContinentUpdate(MdmContinentVO mdmContinentVO) throws DAOException {
		
		boolean isSuccessful = false; 
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("conti_cd", mdmContinentVO.getContiCd());
		param.put("conti_nm", mdmContinentVO.getContiNm());
		param.put("cre_usr_id", mdmContinentVO.getCreUsrId());
		param.put("cre_dt", mdmContinentVO.getCreDt());
		param.put("upd_usr_id", mdmContinentVO.getUpdUsrId());
		param.put("upd_dt", mdmContinentVO.getUpdDt());
		param.put("delt_flg", mdmContinentVO.getDeltFlg());
		param.put("eai_evnt_dt", mdmContinentVO.getEaiEvntDt());
		param.put("eai_if_id", mdmContinentVO.getEaiIfId());

		try {
			int rowCnt = 0;
			SQLExecuter sqlExe = new SQLExecuter("");

			rowCnt = sqlExe.executeUpdate((ISQLTemplate) new ReceiveQueueMdmContinentDBDAOAddMdmContinentUpdateUSQL(), param, velParam);

			if(rowCnt>0){
				isSuccessful = true;
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		} 
		
		return isSuccessful; 		
				
	}	
	
	/**
	 * insert, update
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean addMdmContinent(MdmContinentVO mdmContinentVO) throws DAOException {
		
		boolean isSuccessful = false; 
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("conti_cd", mdmContinentVO.getContiCd());
		param.put("conti_nm", mdmContinentVO.getContiNm());
		param.put("cre_usr_id", mdmContinentVO.getCreUsrId());
		param.put("cre_dt", mdmContinentVO.getCreDt());
		param.put("upd_usr_id", mdmContinentVO.getUpdUsrId());
		param.put("upd_dt", mdmContinentVO.getUpdDt());
		param.put("delt_flg", mdmContinentVO.getDeltFlg());
		param.put("eai_evnt_dt", mdmContinentVO.getEaiEvntDt());
		param.put("eai_if_id", mdmContinentVO.getEaiIfId());

		try {
			int rowCnt = 0;
			SQLExecuter sqlExe = new SQLExecuter("");

			rowCnt = sqlExe.executeUpdate((ISQLTemplate) new ReceiveQueueMdmContinentDBDAOAddMdmContinentInsertCSQL(), param, velParam);
			
			if(rowCnt>0){
				isSuccessful = true;
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		} 
		
		return isSuccessful; 		
		
	}
	
	/**
	 * 기존 데이타 유무 검색
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMdmContinentList(String pk) throws DAOException{
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("conti_cd", pk);
		
		boolean isSuccessful = false;
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ReceiveQueueMdmContinentDBDAOSearchMdmContinentListRSQL(),
					param, velParam);

			
			if(dbRowset.getRowCount() <= 0) isSuccessful = true;
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isSuccessful;	
	}
	
	/**
	 * delete
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean removeMdmContinent(List<MdmContinentVO> MdmContinentVOs) throws DAOException{
		
		boolean isSuccessful = false; 

		try {
			int rowCnt[] = null;

			SQLExecuter sqlExe = new SQLExecuter("");

			rowCnt = sqlExe.executeBatch(new ReceiveQueueMdmContinentDBDAORemoveMdmContinentUSQL(),MdmContinentVOs, null);
			
			for (int i = 0; i < rowCnt.length; i ++) {
				if (rowCnt[i] == Statement.EXECUTE_FAILED)
					isSuccessful = false;
				else
					isSuccessful = false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		} 
		
		return isSuccessful; 			

	}
}

