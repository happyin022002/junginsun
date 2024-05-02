/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CnlBKGCntrmanageBC.java
*@FileTitle : Cancelled BKG's Cntr Tracing
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * CnlBKGCntrmanageBC PDTO(Data Transfer Object including Parameters)<br>
 */
public interface CnlBKGCntrmanageBC  {
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchCnlBKGCntrList(Event e) throws EventException;
	
}
