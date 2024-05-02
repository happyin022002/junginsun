/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ActualCustomerPopupBCImpl.java
*@FileTitle : Other SO creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.actualcustomerpopup.basic;

import com.clt.apps.opus.esd.trs.common.actualcustomerpopup.event.EsdTrs0914Event;
import com.clt.apps.opus.esd.trs.common.actualcustomerpopup.integration.ActualCustomerPopupDBDAO;
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
 * @see OtherSOManageBC refer to DAO classes 
 * @since 
 */
public class ActualCustomerPopupBCImpl   extends BasicCommandSupport implements ActualCustomerPopupBC {

	// Database Access Object
	private transient ActualCustomerPopupDBDAO dbDao=null;

	/**
	 * ActualCustomerPopupBCImpl objects creation<br>
	 * Generate ActualCustomerPopupDBDAO.<br>
	 */
	public ActualCustomerPopupBCImpl(){
		dbDao = new ActualCustomerPopupDBDAO();
	}	
	
	/**
	 * retrieve event process<br>
	 * Actual customer Popup List retrieve event process<br>
	 * 
	 * @param e EsdTrs0914Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchActualCustomerList(Event e) throws EventException {
		DBRowSet rowSet=null; 
		EsdTrs0914Event event=(EsdTrs0914Event)e;
		try {
			
			rowSet=dbDao.searchActualCustomerList(event);
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
	 * Actual customer Popup  Detail retrieve event process<br>
	 * 
	 * @param e EsdTrs0914Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchActualCustomer(Event e) throws EventException {
		DBRowSet rowSet=null; 
		EsdTrs0914Event event=(EsdTrs0914Event)e;
		try {
			rowSet=dbDao.searchActualCustomer(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;		
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}		
	}
	
	
	/**
	 * ActualCustomerPopup biz scenario closing<br>
	 * ActualCustomerPopup clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}