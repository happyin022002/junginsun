/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CHAuditTroArmanageBCImpl.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.basic;

import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0004Event;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0004EventResponse;
import com.clt.apps.opus.esd.eas.transportmanage.integration.CHAuditTroArmanageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * CHAuditTroArmanageBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * @see EventResponse reference

 * @since J2EE 1.4
 */
public class CHAuditTroArmanageBCImpl extends BasicCommandSupport implements CHAuditTroArmanageBC {

    // Database Access Object
    private transient CHAuditTroArmanageDBDAO dbDao=null;

    /**
     * ExceptionManageBCImpl Create Object<br>
     * Create ExceptionManageDBDAO<br>
     */
    public CHAuditTroArmanageBCImpl(){
        dbDao = new CHAuditTroArmanageDBDAO();
    }
    
	/**
	 * search ChAuditBKGList<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
    public EventResponse searchChAuditList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0004Event event  = (EsdEas0004Event)e ;

		DBRowSet rowSet=null;
       
        try {
        	rowSet = dbDao.searchChAuditList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
    }

	/**
	 * search ChAuditBKGList per BKG unit<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
    public EventResponse searchChAuditBKGList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0004Event event  = (EsdEas0004Event)e ;
	
		DBRowSet rowSet=null;
       
        try {
        	rowSet = dbDao.searchChAuditBKGList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
    }
    
	/**
	 * search SubOfficeList <br>
	 * @param e
	 * @return
	 * @throws EventException
	 */    
	public EventResponse searchSubOfficeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EsdEas0004Event event  = (EsdEas0004Event)e ;

		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchSubOfficeList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
    
}
