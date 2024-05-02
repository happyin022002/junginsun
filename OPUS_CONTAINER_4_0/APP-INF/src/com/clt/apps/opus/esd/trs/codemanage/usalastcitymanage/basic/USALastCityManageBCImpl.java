/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UsaLastCityManagementBCImpl.java
*@FileTitle : USA Last City for T&E Cargo
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.basic;

import java.sql.SQLException;

import com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.event.EsdTrs0076Event;
import com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.integration.USALastCityManageDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

 
/**
 * ESD-TRS Business Logic Basic Command implementation<br>

 * 
 * @author 
 * @see ESD_TRS_076EventResponse,USALastCityManageBC
 * @since J2EE 1.4
 */
@SuppressWarnings("unused")
public class USALastCityManageBCImpl   extends BasicCommandSupport implements USALastCityManageBC {

	// Database Access Object
	private transient USALastCityManageDBDAO dbDao=null;

	/**
	 * USALastCityManageBCImpl <br>
	 * USALastCityManageDBDAO<br>
	 */
	public USALastCityManageBCImpl(){
		dbDao = new USALastCityManageDBDAO();
	}

	/**
	 * Inquiry event process<br>
	 * USALastCityManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_076EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSALastCityManageList(Event e) throws EventException {
		
		EsdTrs0076Event event=(EsdTrs0076Event)e;
		DBRowSet rowSet=null; // DB ResultSet for sending data
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet=dbDao.searchUSALastCityManageList(event.getTrsDmstLstCtyVO());
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}

	/**
	 * Multi-event processing<br>
	 * ESD_TRS_076  - Multi-event processing<br>
	 * 
	 * @param e ESD_TRS_076Event
	 * @return EventResponse ESD_TRS_076EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUSALastCityManage(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0076Event event=(EsdTrs0076Event)e;		
		try {			
			dbDao.multiTRS_DMST_LST_CTY(event.getTrsDmstLstCtyVos(), event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}


	/**
	 * SEARCH01 event processing<br>
	 * ESD_TRS_077  - SEARCH01 event processing<br>
	 * 
	 * @param e ESD_TRS_077Event
	 * @return EventResponse ESD_TRS_077EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLocalCodeManage(Event e) throws EventException{
		// PDTO(Data Transfer Object including Parameters)		
		EsdTrs0076Event event=(EsdTrs0076Event)e;
		DBRowSet rowSet=null; // DB ResultSet for sending data
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String comboText = "";
		try {
			rowSet=dbDao.searchLocalCodeManage(event);
			while(rowSet.next()){
				comboText = rowSet.getString("LOC_CD");
			}			
			eventResponse.setETCData("CNT_CD", comboText);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());			
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}	
	
	/**
	 * Inquiry event process<br>
	 * USALastCityManage - Inquiry event process for Combo<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_076EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSALastCityComboList(Event e) throws EventException {
		
		EsdTrs0076Event event=(EsdTrs0076Event)e;
		DBRowSet rowSet=null; // DB ResultSet for sending data
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			rowSet=dbDao.searchUSALastCityComboList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		}
	}
	
	/**
	 * End process of TRS task scenario<br>
	 * Releasing the related implicit object when USALastCityManage task is end.<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}