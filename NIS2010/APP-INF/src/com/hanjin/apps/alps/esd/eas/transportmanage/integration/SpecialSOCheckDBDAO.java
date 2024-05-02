/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SpecialSOCheckDBDAO.java
*@FileTitle : Special S/O Check - Supplement & Other
*Open Issues :
*Change history :
*@LastModifyDate : 2007-12-07
*@LastModifier : Jun Ho Kim
*@LastVersion : 1.0
* 2007-12-07 Jun Ho Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.transportmanage.basic.SpecialSOCheckBCImpl;
import com.hanjin.apps.alps.esd.eas.transportmanage.event.EsdEas0003Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ENIS-SpecialSOCheck에 대한 DB 처리를 담당<br>
 * - ENIS-SpecialSOCheck Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jun Ho Kim
 * @see SpecialSOCheckBCImpl 참조
 * @since J2EE 1.4
 */
public class SpecialSOCheckDBDAO extends DBDAOSupport {

	/**
	 * SpecialSOCheck의 모든 목록을 가져온다.<br>
	 * @param EsdEas0003Event event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSpecialSOCheckList(EsdEas0003Event event) throws DAOException {
		DBRowSet dRs = null;
		
		try{
			String so_ofc_cd    = event.getSoOfcCd();
			String io_bound     =  event.getBound();
			String so_month     =  event.getSoMonth();
			String fm_so_date   =  event.getFmSoDate();
			String to_so_date   =  event.getToSoDate();
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("so_ofc_cd",so_ofc_cd);
			param.put("io_bound",io_bound);
			param.put("so_month",so_month);
			param.put("fm_so_date",fm_so_date);
			param.put("to_so_date",to_so_date);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			SpecialSOCheckDBDAOsearchSpecialSOCheckListRSQL template = new SpecialSOCheckDBDAOsearchSpecialSOCheckListRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);
     
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
		return dRs;
	}

	/**
	 * Other S/O 의 모든 목록을 가져온다.<br>
	 * @param EsdEas0003Event event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */	
	public DBRowSet searchOtherSOCheckList(EsdEas0003Event event) throws DAOException {
		DBRowSet dRs = null;
		try{
			String so_ofc_cd    = event.getSoOfcCd();
			String io_bound     =  event.getBound();
			String so_month     =  event.getSoMonth();
			String fm_so_date   =  event.getFmSoDate();
			String to_so_date   =  event.getToSoDate();
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("so_ofc_cd",so_ofc_cd);
			param.put("io_bound",io_bound);
			param.put("so_month",so_month);
			param.put("fm_so_date",fm_so_date);
			param.put("to_so_date",to_so_date);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			SpecialSOCheckDBDAOsearchOtherSOCheckListRSQL template = new SpecialSOCheckDBDAOsearchOtherSOCheckListRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);				
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
		return dRs;
	}
	
}

