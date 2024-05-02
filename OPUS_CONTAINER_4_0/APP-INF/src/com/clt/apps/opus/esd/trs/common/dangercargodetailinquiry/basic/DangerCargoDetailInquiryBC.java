/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DangerCargoDetailInquiryBC.java
*@FileTitle : BKG CGO SPE Detail Popup - DG
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.dangercargodetailinquiry.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 *
 * @author 
 * @see EsdTrs0938EventResponse 
 * @since J2EE 1.4
 */
public interface DangerCargoDetailInquiryBC  {

	/**
	 * Inquiry event process<br>
	 * DangerCargoDetailInquiry - Inquiry event process<br>
	 * 
	 * @param e EsdTrs0938Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchDangerCargoDetailInquiry(Event e) throws EventException;


}