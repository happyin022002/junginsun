/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaRailYardManageBCImpl.java
*@FileTitle : UsaRailYardManage
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usarailyardmanage.basic;

import com.clt.apps.opus.esd.trs.codemanage.usarailyardmanage.event.EsdTrs0084Event;
import com.clt.apps.opus.esd.trs.codemanage.usarailyardmanage.integration.UsaRailYardManageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;



/**
 * ENIS-UsaRailYardManage Business Logic Basic Command implementation<br>
 * - ENIS-UsaRailYardManage handling business logic.<br>
 * 
 * @author 
 * @see UsaRailYardManageBC  refer to Each DAO classes
 * @since 
 */
public class UsaRailYardManageBCImpl extends BasicCommandSupport implements UsaRailYardManageBC {

	// Database Access Object
	private transient UsaRailYardManageDBDAO dbDao=null;

	/**
	 * UsaRailYardManageBCImpl object creation<br>
	 * Generate UsaRailYardManageDBDAO.<br>
	 */
	public UsaRailYardManageBCImpl(){
		dbDao = new UsaRailYardManageDBDAO();
	}

	/**
	 * retrieve event process<br>
	 * UsaRailYardManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_0084Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchUsaRailYardManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0084Event event=(EsdTrs0084Event)e;
		
		DBRowSet rowSet=null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet=dbDao.searchUsaRailYardManage(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * multi event process<br>
	 * ESD_TRS_084 multi event process<br>
	 * 
	 * @param e ESD_TRS_0084Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiUsaRailYardManage(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0084Event event=(EsdTrs0084Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.multiUsaRailYardManage(event);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * UsaRailYardManage biz scenario closing<br>
	 * UsaRailYardManage clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}