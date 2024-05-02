/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CanadaCustomsDBDAO.java
*@FileTitle : Canada Customs 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-22
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.canadacustoms.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.servicesio.canadacustomsvessel.basic.CanadaCustomsVesselBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.EdiCndCstmsIbdVO;

/**
 * eNIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Sang-Woo
 * @see CanadaCustomsVesselBCImpl 참조
 * @since J2EE 1.4
 */
public class CanadaCustomsDBDAO extends DBDAOSupport {

	/**
	 * JMS ReceiveInterface(Receive) 처리한다.<br>
	 * 
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public boolean addCanadaCustomsManage(EdiCndCstmsIbdVO model) throws DAOException {
		boolean isSuccessful = false; 
		String bl_no = null;	
		String eai_event_dt = null;
		bl_no = model.getBlNo();
		eai_event_dt = model.getEaiEvntDt();
	
		try {
			
			if(bl_no == null || bl_no.equals("") ){ throw new Exception("BL_NO is mandatory."); }			
			if(eai_event_dt == null || eai_event_dt.equals("") ){ throw new Exception("EAI_EVNT_DT is mandatory."); }
			if (!searchCanadaCustomsManageList(bl_no)) {
				Collection<EdiCndCstmsIbdVO> insertVoList = new ArrayList<EdiCndCstmsIbdVO>();
				insertVoList.add(model);
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
				CanadaCustomsDBDAOaddCanadaCustomsManageCSQL template = new CanadaCustomsDBDAOaddCanadaCustomsManageCSQL();			
				sqlExe.executeBatch(template, insertVoList,null, null);	
			} else {
				Collection<EdiCndCstmsIbdVO> updateVoList = new ArrayList<EdiCndCstmsIbdVO>();
				updateVoList.add(model);
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
				CanadaCustomsDBDAOaddCanadaCustomsManageUSQL template = new CanadaCustomsDBDAOaddCanadaCustomsManageUSQL();			
				sqlExe.executeBatch(template, updateVoList,null, null);                                              			 									
					
			}	
			isSuccessful = true;
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
	 * JMS ReceiveInterface(Receive) 처리한다.<br>
	 * 
	 * @param pk1 
	 * @return boolean 처리 성공여부
	 * @throws DAOException
	 */	
	public boolean searchCanadaCustomsManageList(String pk1) throws DAOException{
		boolean isSuccessful = false; 

		DBRowSet rs = null;


		try {
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bl_no", pk1);

			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			CanadaCustomsDBDAOsearchCanadaCustomsManageListRSQL template = new CanadaCustomsDBDAOsearchCanadaCustomsManageListRSQL();	        
			rs = sqlExe.executeQuery(template, param, null);
			
			if ( rs!= null && rs.next()){
				log.debug("rs.getString(1): "+rs.getString(1));
				if( !rs.getString(1).equals("0") ){isSuccessful = true;}
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
	 * JMS ReceiveInterface(Receive) 처리한다.<br>
	 * 
	 * @param model EdiCndCstmsIbdVO
	 * @return boolean 처리 성공여부
	 * @throws DAOException
	 */		
	public boolean deleteCanadaCustomsManage(EdiCndCstmsIbdVO model) throws DAOException{
		boolean isSuccessful = false;

		String bl_no = null;
		String eai_event_dt = null;
		bl_no = model.getBlNo();
		eai_event_dt = model.getEaiEvntDt();
		try {
			
			if(bl_no == null || bl_no.equals("") ){ throw new Exception("BL_NO is mandatory."); }			
			if(eai_event_dt == null || eai_event_dt.equals("") ){ throw new Exception("EAI_EVNT_DT is mandatory."); }
			if (searchCanadaCustomsManageList(bl_no)) {		
				Collection<EdiCndCstmsIbdVO> deleteVoList = new ArrayList<EdiCndCstmsIbdVO>();
				deleteVoList.add(model);
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
				CanadaCustomsDBDAOdeleteCanadaCustomsManageDSQL template = new CanadaCustomsDBDAOdeleteCanadaCustomsManageDSQL();			
				sqlExe.executeBatch(template, deleteVoList,null, null);
			}
			isSuccessful = true;

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