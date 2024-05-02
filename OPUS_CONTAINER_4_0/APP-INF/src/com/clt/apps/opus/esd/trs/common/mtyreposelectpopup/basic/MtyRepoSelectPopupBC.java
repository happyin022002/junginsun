/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MtyContainerSelectPopupBC.java
*@FileTitle : Empty Repo Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.mtyreposelectpopup.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 *
 * @author 
 * @see EsdTrs0909EventResponse
 * @since J2EE 1.4
 */
public interface MtyRepoSelectPopupBC  {

	/**
	 * Inquiry event process<br>
	 * MtyRepoSelectPopup - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_909Event
	 * @return EventResponse ESD_TRS_909EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMtyRepoSelectPopup(Event e) throws EventException;
	
	
}