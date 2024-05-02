/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BreakBulkCargoDetailInquiryBC.java
*@FileTitle : BKG CGO SPE Detail Popup - BB
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/


package com.clt.apps.opus.esd.trs.common.breakbulkcargodetailinquiry.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS business logic handling.<br>
 *
 * @author juhyun
 * @see EsdTrs0937EventResponse 
 * @since J2EE 1.4
 */
public interface BreakBulkCargoDetailInquiryBC  {

	/**
	 * retrieve event handling<br>
	 * BreakBulkCargoDetailInquiry screen views for event handling<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchBreakBulkCargoDetailInquiry(Event e) throws EventException;
}