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

import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0007Event;
import com.clt.apps.opus.esd.eas.transportmanage.integration.DOFChgTrfmanageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * DOFChgTrfmanageBCImpl PDTO(Data Transfer Object including Parameters)<br>
 */
public class DOFChgTrfmanageBCImpl extends BasicCommandSupport implements DOFChgTrfmanageBC {

	
	// Database Access Object
	private transient DOFChgTrfmanageDBDAO dbDao = null;

	/**
	 * OutstandingManageBCImpl Create Object<br>
	 * Create OutstandingManageDBDAO<br>
	 */
	public DOFChgTrfmanageBCImpl(){
		dbDao = new DOFChgTrfmanageDBDAO();
	}

	/**
	 * search DofChgTrfList<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDofChgTrfList(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
		
		DBRowSet rowSet=null; 
		try {
			rowSet = dbDao.searchDofChgTrfList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * search Effective date<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEffDT(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
		
		DBRowSet rowSet=null; 
		try {

			rowSet = dbDao.searchEffDT(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;			
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Create, Modifu, Delete  multiDofChgTrf 
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiDofChgTrf(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
    	try {
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
        	dbDao.multiDofChgTrf(event);
        	return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}

	/**
	 * search EURO Office code<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse searchEUROffcd(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
		
    	try {
    		DBRowSet rowSet=null; 
    		rowSet=dbDao.searchEUROffcd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;	
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
	/**
	 * search duplication count<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse searchDofChgDupCnt(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
		DBRowSet rowSet=null; 
    	try {
    		
    		rowSet=dbDao.searchDofChgDupCnt(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;	
	
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
	/**
	 * verify Location by MDM<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse verifyLocCd(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
		DBRowSet rowSet=null; 
    	try {
    		
    		rowSet=dbDao.verifyLocCd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;	
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
	/**
	 * verify Customer Cd by MDM<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse verifyCustCd(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
		DBRowSet rowSet=null; 
    	try {
    		
    		rowSet=dbDao.verifyCustCd(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;	
			
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
	/**
	 * verify Container Type Siez by MDM<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse verifyTpSz(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
		DBRowSet rowSet=null; 
    	try {
    		
    		rowSet=dbDao.verifyTpSz(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;	
			
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
	/**
	 * verify Currency by MDM<br>
	 * @param e EsdEas0007Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	public EventResponse verifyCurr(Event e) throws EventException {

		EsdEas0007Event event=(EsdEas0007Event)e;
		DBRowSet rowSet=null; 
    	try {
    		
    		rowSet=dbDao.verifyCurr(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
}
