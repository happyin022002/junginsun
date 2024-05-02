/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : VendorCmBC.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 
========================================================*/

package com.clt.apps.opus.esd.trs.workordermanage.vendorcm.basic;

import java.util.ArrayList;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * VendorCmBC<br>
 * 
 * @author
 * @see
 * @since J2EE 1.6
 */
public interface VendorCmBC {
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchJoEdiHistory(Event e) throws EventException;

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchJoEdiRcvMsgList(Event e) throws EventException;

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList multipleAccept(Event e) throws EventException;

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList multipleReject(Event e) throws EventException;
}
