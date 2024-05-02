/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ReferCargoDetailInquiryBC.java
*@FileTitle : BKG CGO SPE Detail Popup - RF
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.refercargodetailinquiry.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 *
 * @author 
 * @see GeneralEventResponse
 * @since J2EE 1.4
 */
public interface ReferCargoDetailInquiryBC  {

	/**
	 * Inquiry event process<br>
	 * ReferCargoDetailInquiry - Inquiry event process<br>
	 * 
	 * @param e EsdTrs0935Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchReferCargoDetailInquiry(Event e) throws EventException;



}