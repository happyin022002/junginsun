/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderCCManageBCImpl.java
*@FileTitle : Transportation Report & Code
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.basic;

import com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.event.EsdTrs0072Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.integration.WorkOrderCCManageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ESD-WorkOrderManage Business Logic Basic Command implementation<br>
 * 
 * @author 
 * @see ESD_TRS_072EventResponse,WorkOrderCCManageBC
 * @since J2EE 1.4
 */
public class WorkOrderCCManageBCImpl   extends BasicCommandSupport implements WorkOrderCCManageBC {

	// Database Access Object
	private transient WorkOrderCCManageDBDAO dbDao=null;

	/**
	 * WorkOrderCCManageBCImpl <br>
	 * WorkOrderCCManageDBDAO<br>
	 */
	public WorkOrderCCManageBCImpl(){
		dbDao = new WorkOrderCCManageDBDAO();
	}

	/**
	 * Inquiry event process<br>
	 * WorkOrderCCManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return 
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderCCManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0072Event event=(EsdTrs0072Event)e;
		DBRowSet rowSet=null; // DB ResultSet for sending data
		
		try {
			rowSet=dbDao.searchWorkOrderCCManageList(event);
			
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
	 * WorkOrderCCManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_072Event
	 * @return EventResponse ESD_TRS_072EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderCCFaxList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0072Event event=(EsdTrs0072Event)e;
		DBRowSet rowSet=null; // DB ResultSet for sending data
		
		try {
			rowSet=dbDao.searchWorkOrderCCFaxList(event);
			
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
	 * WorkOrderCCManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_072Event
	 * @return EventResponse ESD_TRS_072EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderCCEmailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0072Event event=(EsdTrs0072Event)e;
		DBRowSet rowSet=null; // DB ResultSet for sending data
		
		try {
			rowSet=dbDao.searchWorkOrderCCEmailList(event);
			
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
	 * ESD_TRS_072  - Multi-event processing<br>
	 * 
	 * @param e ESD_TRS_072Event
	 * @return EventResponse ESD_TRS_072EventResponse
	 * @exception EventException
	 */
	public EventResponse multiWorkOrderCCManageList(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0072Event event=(EsdTrs0072Event)e;		
		try {
			dbDao.multiWorkOrderCCManageList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * End process of WorkOrderManage task scenario<br>
	 * Releasing the related implicit object when WorkOrderCCManage task is end.<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}