/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MSCCheckmanageBCImpl.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.basic;

import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0006Event;
import com.clt.apps.opus.esd.eas.transportmanage.integration.MSCCheckmanageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * MSCCheckmanageBCImpl ���� PDTO(Data Transfer Object including Parameters)<br>
 */
public class MSCCheckmanageBCImpl extends BasicCommandSupport implements MSCCheckmanageBC {

    // Database Access Object
    private transient MSCCheckmanageDBDAO dbDao=null;

    /**
     * MSCCheckmanageBCImpl Create Object<br>
     * Create MSCCheckmanageDBDAO<br>
     */
    public MSCCheckmanageBCImpl(){
        dbDao = new MSCCheckmanageDBDAO();
    }
    
	/**
	 * MSC Check Search List.
	 * @param e
	 * @return
	 * @throws EventException
	 */
    public EventResponse searchMSCList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
    	EsdEas0006Event event  = (EsdEas0006Event)e ;

		DBRowSet rowSet=null;
       
		try {
        	rowSet = dbDao.searchMSCList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
    }

	/**
	 * Search EURO TRO Office
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSubOfcList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
    	EsdEas0006Event event  = (EsdEas0006Event)e ;

		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchSubOfcList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
    
}
