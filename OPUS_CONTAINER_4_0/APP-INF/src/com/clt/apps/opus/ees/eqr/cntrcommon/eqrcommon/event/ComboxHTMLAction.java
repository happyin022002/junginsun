/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ComboxHTMLAction.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.event;

import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.core.layer.event.Event;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * HTTP Parser<br> 
 * - com.clt.apps.opus.esm.spc.common HTML DOM Value Parsing<br>
 * @author
 * @see ComboxEvent , ComboxEventResponse 
 * @since J2EE 1.4
 */

public class ComboxHTMLAction extends HTMLActionSupport {

	/**
	 * HTML DOM Value Parsing<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand f_cmd = FormCommand.fromRequest(request);
		ComboxEvent event = new ComboxEvent();
		event.setCommandClassName("CntrCommonSC");
		event.setFormCommand(f_cmd);
		request.setAttribute("Event", event);
		return event;
	}

	/**
	 * HttpRequest attribute장<br>
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest attribute <br>
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}