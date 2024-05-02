/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ContainerSelectPopupBC.java
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.containerselectpopup.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * An interface to the business logic for ContainerSelectPopup<br>
 *
 * @author 
 * @see Refer to EsdTrs0908EventResponse
 * @since 
 */
public interface ContainerSelectPopupBC  {

	/**
	 * retrieve event process<br>
	 * ContainerSelectPopup retrieve event process<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerSelectPopup(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * ContainerSelectPopup retrieve event process<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerSelectMainList(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * ContainerSelectPopup retrieve event process<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerSelectSubList(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * ContainerSelectPopup retrieve event process<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerSelectReplaceTPSZList(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * ContainerSelectPopup the split bkg, current bkg list to bring up.<br>
	 * 
	 * @param e ESD_TRS_908Event
	 * @return EventResponse ESD_TRS_908EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSplitBkgList(Event e) throws EventException;
}