/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DOFChgColPermanageBC
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.basic;

import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0009Event;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0009EventResponse;
import com.clt.apps.opus.esd.eas.transportmanage.integration.DOFChgColPermanageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * DOFChgColPermanageBCImpl PDTO(Data Transfer Object including Parameters)<br>
 */
public class DOFChgColPermanageBCImpl extends BasicCommandSupport implements DOFChgColPermanageBC {

	
	// Database Access Object 
	private transient DOFChgColPermanageDBDAO dbDao = null;

	/**
	 * OutstandingManageBCImpl Create Object<br>
	 * Create OutstandingManageDBDAO<br>
	 */
	public DOFChgColPermanageBCImpl(){
		dbDao = new DOFChgColPermanageDBDAO();
	}

	/**
	 * Drop off charge collection Performance Search list
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchDofChgColPerList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0009Event event=(EsdEas0009Event)e; 

		DBRowSet rowSet=null; 
		
		try {
			rowSet = dbDao.searchDofChgColPerList(event); 
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

}
