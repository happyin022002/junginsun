/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_CURRDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 * 2009-09-25 : Ho-Jin Lee Alps 전환
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmCurrencyDBDAO extends DBDAOSupport{
	/**
	 * insert, update
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public int addMdmCurrency(MdmCurrencyVO model) throws DAOException {
		
		int isResult = 0 ; 

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			log.info("\n <<<addMdmCurrency param>>="+param);
			Map<String, String> mapVO = model.getColumnValues();
			if(mapVO != null){
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			log.info("\n <<<addMdmCurrency param>>="+param);
			isResult = new SQLExecuter("").executeUpdate((ISQLTemplate) new ReceiveQueueMdmCurrencyDBDAOAddMdmCurrencyCSQL(), param, velParam);
			log.debug("\n <<<<isResult>>>="+isResult);				
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
		return isResult; 
	}
	
	public int modifyMdmCurrency(MdmCurrencyVO model) throws DAOException{
		int upResult = 0 ; 

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = model.getColumnValues();
			if(mapVO != null){
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			log.info("\n <<<modifyMdmCurrency param>>="+param);
			upResult = new SQLExecuter("").executeUpdate((ISQLTemplate) new ReceiveQueueMdmCurrencyDBDAOModifyMdmCurrencyUSQL(), param, velParam);
							
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
		return upResult; 
    }
	
	/**
	 * 기존 데이타 유무 검색
	 * @param curr_cd
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMDMCURRENCYList(String curr_cd) throws DAOException{
		boolean isSuccessful = false; 
		DBRowSet dbRowSet = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("curr_cd", curr_cd);
			log.info("\n <<<searchMDMCURRENCYList param>>="+param);
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueMdmCurrencyDBDAOSearchMdmCurrencyRSQL(), param, null);
//			if(dbRowSet.getRowCount() <= 0){
			if(!dbRowSet.next()){
				isSuccessful = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return isSuccessful;	
	}
	
	/**
	 * delete
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public int removeMdmCurrency(MdmCurrencyVO model) throws DAOException{
		int delResult = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			
			Map<String, String> mapVO = model.getColumnValues();
			if(mapVO != null){
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			log.info("\n <<<removeMdmCurrency param>>="+param);
			delResult = new SQLExecuter("").executeUpdate((ISQLTemplate) new ReceiveQueueMdmCurrencyDBDAORemoveMdmCurrencyDSQL(), param, velParam);
			
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
		return delResult; 	
	}

	
}
