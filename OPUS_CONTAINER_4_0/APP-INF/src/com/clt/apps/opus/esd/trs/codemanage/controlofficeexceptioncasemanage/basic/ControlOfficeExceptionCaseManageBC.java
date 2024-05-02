/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ControlOfficeExceptionCaseManageBC.java
*@FileTitle : Control Office Exception Case Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 *
 * @author 
 * @see EsdTrs0079EventResponse
 * @since J2EE 1.4
 */
public interface ControlOfficeExceptionCaseManageBC  {

	/**
	 * Inquiry event process<br>
	 * ESD_TRS_079  - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchControlOfficeExceptionCaseManageList(Event e) throws EventException;

	/**
	 * Multi-event processing<br>
	 * ESD_TRS_079  - Multi-event processing<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse multiControlOfficeExceptionCaseManage(Event e) throws EventException;

	/**
	 * SEARCH01 event processing<br>
	 * ESD_TRS_079  - SEARCH01 event processing<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYardCodeManage(Event e) throws EventException;
	
	/**
	 * SEARCH01 event processing<br>
	 * ESD_TRS_079  - SEARCH01 event processing<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYardCodeName(Event e) throws EventException;
	
	/**
	 * SEARCH02 event processing<br>
	 * ESD_TRS_079  - SEARCH02 event processing<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCountryCodeManage(Event e) throws EventException;
	
	/**
	 * SEARCH03 event processing<br>
	 * ESD_TRS_079  - SEARCH03 event processing<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchControlOfficeCodeManage(Event e) throws EventException;
	
	/**
	 * SEARCH03 event processing<br>
	 * ESD_TRS_079  - SEARCH03 event processing<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEquipmentSZ(Event e) throws EventException;
	
	/**
	 * SEARCH03 event processing<br>
	 * ESD_TRS_079  - SEARCH03 event processing<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEquipmentTP(Event e) throws EventException;
	
	/**
	 * SEARCH03 event processing<br>
	 * ESD_TRS_079  - SEARCH03 event processing<br>
	 * 
	 * @param e ESD_TRS_079Event
	 * @return EventResponse ESD_TRS_079EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyControlOfficeCD(Event e) throws EventException;

}