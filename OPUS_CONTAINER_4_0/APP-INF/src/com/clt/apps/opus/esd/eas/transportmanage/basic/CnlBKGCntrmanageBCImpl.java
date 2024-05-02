/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CnlBKGCntrmanageBC.java
*@FileTitle : Cancelled BKG's Cntr Tracing
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.basic;

import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0004Event;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0005Event;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0005EventResponse;
import com.clt.apps.opus.esd.eas.transportmanage.integration.CnlBKGCntrmanageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 * CnlBKGCntrmanageBCImpl PDTO(Data Transfer Object including Parameters)<br>
 */
public class CnlBKGCntrmanageBCImpl extends BasicCommandSupport implements CnlBKGCntrmanageBC {

    // Database Access Object
    private transient CnlBKGCntrmanageDBDAO dbDao=null;

    /**
     * CnlBKGCntrmanageBCImpl<br>
     * CnlBKGCntrmanageDBDAO<br>
     */
    public CnlBKGCntrmanageBCImpl(){
        dbDao = new CnlBKGCntrmanageDBDAO();
    }
    
    /**
	 * searchCnlBKGCntrList
     * @param e
     * @return
     * @throws EventException
     */
    public EventResponse searchCnlBKGCntrList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0005Event event  = (EsdEas0005Event)e ;
		DBRowSet rowSet=null; 

        try {
        	rowSet = dbDao.searchCnlBKGCntrList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
    }

}
