/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DOFChgColInqmanageBC
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.basic;

import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0005Event;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0008Event;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0008EventResponse;
import com.clt.apps.opus.esd.eas.transportmanage.integration.DOFChgColInqmanageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * DOFChgColInqmanageBCImpl PDTO(Data Transfer Object including Parameters)<br>
 */
public class DOFChgColInqmanageBCImpl extends BasicCommandSupport implements DOFChgColInqmanageBC {

	
	// Database Access Object 
	private transient DOFChgColInqmanageDBDAO dbDao = null;

	/**
	 * OutstandingManageBCImpl Create Object<br>
	 * Create OutstandingManageDBDAO<br>
	 */
	public DOFChgColInqmanageBCImpl(){
		dbDao = new DOFChgColInqmanageDBDAO();
	}
	
	/**
	 * Drop off charge col inquery Search list
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchDofChgColList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0008Event event  = (EsdEas0008Event)e ;

		DBRowSet rowSet=null; 
		
		try {
			rowSet = dbDao.searchDofChgColList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

}
