/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : ExceptionAckRailRoadBC.java
 *@FileTitle : Exception Ack Rail Road
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016-04-19
 *@LastModifier : S.W. KIM
 *@LastVersion : 1.0
 * 2016-04-19 ksw	   	1.0  최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.exceptionackrailroad.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ExceptionAckRailRoad Business Logic Command Interface<br>
 * An interface to the business logic for ExceptionAckRailRoadBC<br>
 * 
 * @author
 * @see Refer to EsdTrs0077EventResponse
 * @since J2EE 1.6
 */
public interface ExceptionAckRailRoadBC {

	/**
	 * Exception Rail Road Vendor - RETRIEVE
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchExceptionAckRailRoadVendorList(Event e) throws EventException;

	/**
	 * Exception Rail Road Vendor - SAVE
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void multiExceptionAckRailRoadVendor(Event e) throws EventException;

}