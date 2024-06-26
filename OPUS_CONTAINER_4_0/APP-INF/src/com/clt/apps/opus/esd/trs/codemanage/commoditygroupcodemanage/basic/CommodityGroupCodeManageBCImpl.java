/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityGroupCodeManageBCImpl.java
*@FileTitle : Commodity Group Code Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.basic;

import java.sql.SQLException;

import com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.event.EsdTrs0075Event;
import com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.integration.CommodityGroupCodeManageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

 
/**
 * ESD-TRS Business Logic Basic Command implementation<br>

 * 
 * @author
 * @see ESD_TRS_0075EventResponse,CommodityGroupCodeManageBC
 * @since J2EE 1.6
 */
public class CommodityGroupCodeManageBCImpl   extends BasicCommandSupport implements CommodityGroupCodeManageBC {

	// Database Access Object
	private transient CommodityGroupCodeManageDBDAO dbDao=null;

	/**
	 * CommodityGroupCodeManageBCImpl <br>
	 * CommodityGroupCodeManageDBDAO<br>
	 */
	public CommodityGroupCodeManageBCImpl(){
		dbDao = new CommodityGroupCodeManageDBDAO();
	}

	/**
	 * Inquiry event process<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_075EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCommodityGroupCodeManageList(Event e) throws EventException {
		EsdTrs0075Event event 	= (EsdTrs0075Event)e;
		DBRowSet rowSet 		= null;
		try {
			rowSet = dbDao.searchCommodityGroupCodeManageList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Inquiry event process<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_075EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMdm_commodity(Event e) throws EventException {	
		EsdTrs0075Event event 	= (EsdTrs0075Event)e;
		DBRowSet rowSet 		= null; 
		try {
			rowSet=dbDao.searchMdm_commodity(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Inquiry event process<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_075EventResponse
	 * @exception EventException
	 */
	public EventResponse searchrep_commodity(Event e) throws EventException {
		
		EsdTrs0075Event event 	= (EsdTrs0075Event)e;
		DBRowSet rowSet 		= null; 
		try {
			rowSet=dbDao.searchrep_commodity(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);

			if(rowSet.next())				
				eventResponse.setETCData("CNT_CD", rowSet.getString("rep_cmdt_nm"));
			else
				eventResponse.setETCData("CNT_CD", "Not Found Rep.Commodity Name");

			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	/**
	 * Inquiry event process<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_075EventResponse
	 * @exception EventException
	 */
	public EventResponse search_commodity(Event e) throws EventException {	
		EsdTrs0075Event event 	= (EsdTrs0075Event)e;
		DBRowSet rowSet 		= null; 
		FormCommand formcommand = e.getFormCommand();	
		
		try {
			rowSet=dbDao.search_commodity(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);

			if(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH02))
					eventResponse.setETCData("CNT_CD", rowSet.getString("rep_cmdt_nm"));
				else if(formcommand.isCommand(FormCommand.SEARCH03))
					eventResponse.setETCData("CNT_CD", rowSet.getString("cmdt_nm"));
			}else{
				eventResponse.setETCData("CNT_CD", "Not Found Commodity Name");				
			}
			return eventResponse;	
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	/**
	 * Inquiry event process<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_075EventResponse
	 * @exception EventException
	 */
	public EventResponse search_vndr(Event e) throws EventException {	
		EsdTrs0075Event event	=(EsdTrs0075Event)e;
		DBRowSet rowSet			= null; 
		FormCommand formcommand = e.getFormCommand();	
		 
		try {

			rowSet=dbDao.search_vndr(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			
			if(rowSet.next()){				
				if(formcommand.isCommand(FormCommand.SEARCH04)){
					eventResponse.setETCData("CNT_CD", rowSet.getString("vndr_nm_eng"));
				}else if(formcommand.isCommand(FormCommand.SEARCH05)){
					eventResponse.setETCData("CNT_CD", rowSet.getString("vndr_no"));
					eventResponse.setETCData("VNDR_NM", rowSet.getString("vndr_nm_eng"));
				}
			}
	 			
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}	

	/**
	 * Inquiry event process<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_075EventResponse
	 * @exception EventException
	 */
	public EventResponse search_vndr_commodity(Event e) throws EventException {
		EsdTrs0075Event event	= (EsdTrs0075Event)e;
		DBRowSet rowSet			= null; 
		try {
			rowSet=dbDao.search_vndr_commodity(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		

	/**
	 * Inquiry event process<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_075EventResponse
	 * @exception EventException
	 */
	public EventResponse search_sub_commodity(Event e) throws EventException {
		EsdTrs0075Event event	= (EsdTrs0075Event)e;
		DBRowSet rowSet			= null; 
		try {
			rowSet=dbDao.search_sub_commodity(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	

	/**
	 * Multi-event processing<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_075EventResponse
	 * @exception EventException
	 */
	public EventResponse multi_vndr_commodity(Event e) throws EventException {
		EsdTrs0075Event event = (EsdTrs0075Event)e;
		try {
			dbDao.multi_vndr_commodity(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Multi-event processing<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_075EventResponse
	 * @exception EventException
	 */
	public EventResponse multi_delete_commodity(Event e) throws EventException {
		EsdTrs0075Event event = (EsdTrs0075Event)e;
		try {
			dbDao.multi_delete_commodity(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * Multi-event processing<br>
	 * CommodityGroupCodeManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_075EventResponse
	 * @exception EventException
	 */
	public EventResponse multi_part_commodity(Event e) throws EventException {
		EsdTrs0075Event event = (EsdTrs0075Event)e;
		try {
			dbDao.multi_part_commodity(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * End process of TRS task scenario<br>
	 * Releasing the related implicit object when CommodityGroupCodeManage task is end.<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}