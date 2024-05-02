/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueApPeriodDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 * 2008-06-17 : schema변경
 * 2010-03-09 [CHM-201002999] : ERP  결산 정보(컬럼)을 ENIS/ALPS로 I/F 요청
 =========================================================*/
package com.clt.apps.opus.common.tableSync.jms.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.ApPeriodVO;

/**
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueApPeriodDBDAO extends DBDAOSupport{

	/**
	 * insert
	 * @param apPeriodVO ApPeriodVO
	 * @return insCnt int
	 * @throws DAOException
	 */
	public int addApPeriod(ApPeriodVO apPeriodVO) throws DAOException {
		
		int insCnt = 0;
		//query parameter
		Map<String, Object> param		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = apPeriodVO.getColumnValues();
			
			if ( mapVO != null ) {
				param	.putAll( mapVO );
				velParam.putAll( mapVO );
			}
			
			if (!"".equals( mapVO.get("sys_div_cd") ) && !"".equals( mapVO.get("eff_yrmon") ) &&
				!"".equals( mapVO.get("ofc_cd") )&& !"".equals( mapVO.get("ar_ap_div_cd") )	) {
				insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueApPeriodDBDAOAddApPeriodCSQL(),  param, velParam);
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
		return insCnt; 
	}
	
	
	/**
	 * update
	 * @param apPeriodVO ApPeriodVO
	 * @return updCnt int
	 * @throws DAOException
	 */
	public int modifyApPeriod(ApPeriodVO apPeriodVO) throws DAOException {
		

		int updCnt = 0;
		//query parameter
		Map<String, Object> param		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = apPeriodVO.getColumnValues();
				
			if ( mapVO != null ) {
				param	.putAll( mapVO );
				velParam.putAll( mapVO );
			}
			
			if (!"".equals( mapVO.get("sys_div_cd") ) && !"".equals( mapVO.get("eff_yrmon") ) &&
				!"".equals( mapVO.get("ofc_cd") )&& !"".equals( mapVO.get("ar_ap_div_cd") )	) {
				updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueApPeriodDBDAOModifyApPeriodUSQL(),  param, velParam);
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
		
		return updCnt; 
	}

	
	/**
	 * 기존 데이타 유무 확인.<br>
	 * @param apPeriodVO ApPeriodVO
	 * @return isSuccessful boolean
	 * @throws DAOException
	 */
	public boolean searchApPeriodList(ApPeriodVO apPeriodVO) throws DAOException{
			
		DBRowSet			dbRowSet	= null;
		//query parameter
		Map<String, Object> param		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();

		boolean			isSuccessful	= false; 
		
		try {
			
			if ( apPeriodVO != null ) {
				Map<String, String>	mapVO = apPeriodVO.getColumnValues();
				
				param	.putAll( mapVO );
				velParam.putAll( mapVO );
			}
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueApPeriodDBDAOSearchApPeriodListRSQL(), param, null);
			
			if ( dbRowSet.getRowCount() <= 0 ) {
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
}