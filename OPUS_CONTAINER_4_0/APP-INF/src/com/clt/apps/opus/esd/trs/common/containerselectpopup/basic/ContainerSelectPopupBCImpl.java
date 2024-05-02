/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ContainerSelectPopupBCImpl.java
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esd.trs.common.containerselectpopup.basic;

import com.clt.apps.opus.esd.trs.common.containerselectpopup.event.EsdTrs0908Event;
import com.clt.apps.opus.esd.trs.common.containerselectpopup.integration.ContainerSelectPopupDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

 

/**
 * ESD-OtherSOManage Business Logic Basic Command implementation<br>
 * - ESD-OtherSOManage handling business logic.<br>
 * 
 * @author 
 * @see ESD_TRS_908EventResponse,ContainerSelectPopupBC refer to each DAO classes
 * @since 
 */
public class ContainerSelectPopupBCImpl   extends BasicCommandSupport implements ContainerSelectPopupBC {

	// Database Access Object
	private transient ContainerSelectPopupDBDAO dbDao=null;

	/**
	 * ContainerSelectPopupBCImpl objects creation<br>
	 * Generate ContainerSelectPopupDBDAO.<br>
	 */
	public ContainerSelectPopupBCImpl(){
		dbDao = new ContainerSelectPopupDBDAO();
	}

	/**
	 * retrieve event process<br>
	 * ContainerSelectPopup retrieve event process<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerSelectPopup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0908Event event=(EsdTrs0908Event)e;
		
		//For transferring data to DB ResultSet object that implements 
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchContainerSelectPopup(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event process<br>
	 * ContainerSelectPopup retrieve event process<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerSelectMainList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0908Event event=(EsdTrs0908Event)e;
		
		try {
			
//			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			
			return  dbDao.searchContainerSelectMainList(event);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retrieve event process<br>
	 * ContainerSelectPopup retrieve event process<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerSelectReplaceTPSZList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0908Event event=(EsdTrs0908Event)e;
		
		// For transferring data to DB ResultSet object that implements 
		DBRowSet dRs =null;
		
		try {
			dRs=dbDao.searchContainerSelectReplaceTPSZList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(dRs);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retrieve event process<br>
	 * ContainerSelectPopup retrieve event process<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerSelectSubList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0908Event event=(EsdTrs0908Event)e;
		try {
			return dbDao.searchContainerSelectSubList(event);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retrieve event process<br>
	 * ContainerSelectPopup retrieve event process<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSplitBkgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0908Event event=(EsdTrs0908Event)e;
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchSplitBkgList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	

	/**
	 * TRS biz scenario closing<br>
	 * ContainerSelectPopup clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}