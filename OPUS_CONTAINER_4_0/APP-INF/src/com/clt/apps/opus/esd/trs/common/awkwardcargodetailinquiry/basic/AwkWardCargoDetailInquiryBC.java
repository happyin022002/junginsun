/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AwkWardCargoDetailInquiryBC.java
*@FileTitle : BKG CGO SPE Detail Popup - AK
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esd.trs.common.awkwardcargodetailinquiry.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * An interface to the business logic for AwkWardCargoDetailInquiry<br>
 *
 * @author 
 * @see Refer to EsdTrs0936EventResponse 
 * @since J2EE 1.4 
 */
public interface AwkWardCargoDetailInquiryBC  {

	/**
	 * retrieve event process<br>
	 * AwkWardCargoDetailInquiry retrieve event process<br>
	 * 
	 * @param e EsdTrs0936Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchAwkWardCargoDetailInquiry(Event e) throws EventException;


}