/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USALastCityManageBC.java
*@FileTitle : USA Last City for T&E Cargo
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 *
 * @author
 * @see EsdTrs0076EventResponse  
 * @since J2EE 1.4
 */
public interface USALastCityManageBC  {

	/**
	 * Multi-event processing<br>
	 * ESD_TRS_076  - Multi-event processing<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiUSALastCityManage(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * UsaLastCityManagement - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchUSALastCityManageList(Event e) throws EventException;
	
	/**
	 * SEARCH01 event processing<br>
	 * ESD_TRS_076  - SEARCH01 event processing<br>
	 * 
	 * @param e ESD_TRS_077Event
	 * @return EventResponse ESD_TRS_077EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchLocalCodeManage(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * UsaLastCityManagement - Inquiry event process for Combo<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchUSALastCityComboList(Event e) throws EventException;
		

}