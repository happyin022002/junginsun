/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RehandExpmanageBCImpl.java
*@FileTitle : Rehandling Expense & TPB Check
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
=========================================================*/
package com.clt.apps.opus.esd.eas.terminalmanage.basic;

import com.clt.apps.opus.esd.eas.terminalmanage.event.EsdEas0001Event;
import com.clt.apps.opus.esd.eas.terminalmanage.event.EsdEas0901Event;
import com.clt.apps.opus.esd.eas.terminalmanage.integration.RehandExpmanageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ENIS-RehandExpmanage Business Logic Basic Command implementation<br>
 */
public class RehandExpmanageBCImpl   extends BasicCommandSupport implements RehandExpmanageBC {


	private transient RehandExpmanageDBDAO dbDao=null;

	/**
	 * RehandExpmanageBCImpl Create object <br>
	 * Create RehandExpmanageDBDAO.<br>
	 */
	public RehandExpmanageBCImpl(){
		dbDao = new RehandExpmanageDBDAO();
	}

	/**
	 * Retrieve Termanal Manage Rehanding Exp. COD vs. TPB 
	 * @param e EsdEas0001Event
	 * @return EventResponse
	 * @throws EventException
	 */
    public EventResponse searchRehandTPBCheckList(Event e) throws EventException {
    	EsdEas0001Event event  = (EsdEas0001Event)e ;
    	DBRowSet         rowSet = new DBRowSet();
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	rowSet = dbDao.searchRehandTPBCheckList(event);
    		eventResponse.setRsVo(rowSet);
    		return eventResponse;
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
    }
    
	/**
	 * Retrieve Expense Audit Remark
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchRehandExpnAudRmk(Event e) throws EventException {

		EsdEas0901Event	event	= (EsdEas0901Event)e;
		
		DBRowSet	rowSet	= null; 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			rowSet	= dbDao.searchRehandExpnAudRmk(event);
    		eventResponse.setRsVo(rowSet);
    		return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Modify Expense Audit Remark
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiRehandExpnAudRmk(Event e) throws EventException {

		EsdEas0901Event	event	= (EsdEas0901Event)e;
		
		try {
			dbDao.multiRehandExpnAudRmk(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
    

	/**
	 * RehandExpmanage biz scenario closing<br>
	 * Clearing related objects of RehandExpmanage <br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}