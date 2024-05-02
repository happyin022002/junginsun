/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ROUTUnMatmanageBCImpl
*@FileTitle : Route Unmatch List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.basic;

import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0002Event;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0902Event;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0902EventResponse;
import com.clt.apps.opus.esd.eas.transportmanage.event.EsdEas0903Event;
import com.clt.apps.opus.esd.eas.transportmanage.integration.ROUTUnMatmanageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ROUTUnMatmanageBCImpl PDTO(Data Transfer Object including Parameters)<br>
 */
public class ROUTUnMatmanageBCImpl extends BasicCommandSupport implements ROUTUnMatmanageBC {

	
	// Database Access Object
	private transient ROUTUnMatmanageDBDAO dbDao = null;

	/**
	 * OutstandingManageBCImpl Create Object<br>
	 * Create OutstandingManageDBDAO<br>
	 */
	public ROUTUnMatmanageBCImpl(){
		dbDao = new ROUTUnMatmanageDBDAO();
	}

	/**
	 * Route Unmatch List Main
	 * @param e EsdEas0002Event
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchRoutUnMatList(Event e) throws EventException {

		EsdEas0002Event event=(EsdEas0002Event)e;
		
		DBRowSet rowSet=null; 
		try {
			rowSet = dbDao.searchRoutUnMatList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Route Unmatch List Detail First
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchRoutUnMatBlInforDetail(Event e) throws EventException {

		EsdEas0903Event event=(EsdEas0903Event)e;
		
		DBRowSet rowSet=null; 
		try {
			rowSet = dbDao.searchRoutUnMatBlInforDetail(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Route Unmatch List Detail Second
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchRoutUnMatSoInforDetail(Event e) throws EventException {

		EsdEas0903Event event=(EsdEas0903Event)e;
		
		DBRowSet rowSet=null; 
		try {
			rowSet = dbDao.searchRoutUnMatSoInforDetail(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Retrieve Expense Audit Remark
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchExpnAudRmk(Event e) throws EventException {

		EsdEas0902Event event=(EsdEas0902Event)e;
		
		DBRowSet rowSet=null; 
		try {
			rowSet = dbDao.searchExpnAudRmk(event.getDataSet());
			return new EsdEas0902EventResponse(rowSet,"SUCCESS");
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
	public EventResponse multiExpnAudRmk(Event e) throws EventException {

		EsdEas0902Event event=(EsdEas0902Event)e;
		
		try {
			dbDao.multiExpnAudRmk(event.getDataSet());
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

}
