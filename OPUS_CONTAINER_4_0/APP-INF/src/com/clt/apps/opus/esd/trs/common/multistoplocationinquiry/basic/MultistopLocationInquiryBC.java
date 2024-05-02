/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MultistopLocationInquiryBC.java
*@FileTitle : Multi-stop Location Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.multistoplocationinquiry.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 *
 * @author 
 * @see EsdTrs0933EventResponse
 * @since J2EE 1.4
 */
public interface MultistopLocationInquiryBC  {


	/**
	 * Inquiry event process<br>
	 * MultistopLocationInquiry - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchMultistopLocationInquiryList(Event e) throws EventException;

}