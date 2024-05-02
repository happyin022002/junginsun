/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpecialSOCheckBCImpl.java
*@FileTitle : Special S/O Check - Supplement & Other
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.basic;

import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0003Event;
import com.clt.apps.opus.esd.eas.transportmanage.integration.SpecialSOCheckDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ENIS-SpecialSOCheck Business Logic Basic Command implementation<br>
 * - handling business transaction abount ENIS-SpecialSOCheck.<br>
 */
public class SpecialSOCheckBCImpl   extends BasicCommandSupport implements SpecialSOCheckBC {

    // Database Access Object
    private transient SpecialSOCheckDBDAO  dbDao=null;

    /**
     * ExceptionManageBCImpl Create Object<br>
     * Create ExceptionManageDBDAO<br>
     */
    public SpecialSOCheckBCImpl(){
        dbDao = new SpecialSOCheckDBDAO();
    }
    
	/**
	 * Special SO Search List
	 * @param e EsdEas0003Event
	 * @return EventResponse
	 * @throws EventException
	 */
    public EventResponse searchSpecialSOCheckList(Event e) throws EventException {
    	EsdEas0003Event event  = (EsdEas0003Event)e ;
    	DBRowSet         rowSet = new DBRowSet();
       
        try {
        		rowSet = dbDao.searchSpecialSOCheckList(event);
    			GeneralEventResponse eventResponse = new GeneralEventResponse();	
    			eventResponse.setRsVo(rowSet);
    			return eventResponse;
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
    }

	/**
	 * Other SO Search List
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
    public EventResponse searchOtherSOCheckList(Event e) throws EventException {
    	EsdEas0003Event event  = (EsdEas0003Event)e ;
    	DBRowSet         rowSet = new DBRowSet();
       
        try {
        		rowSet = dbDao.searchOtherSOCheckList(event);
    			GeneralEventResponse eventResponse = new GeneralEventResponse();	
    			eventResponse.setRsVo(rowSet);
    			return eventResponse;        		

        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
    }
    
}

