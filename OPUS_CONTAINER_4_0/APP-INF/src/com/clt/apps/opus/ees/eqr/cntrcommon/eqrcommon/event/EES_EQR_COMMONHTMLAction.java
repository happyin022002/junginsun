/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_COMMONHTMLACTION.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.spc.common HTML DOM Value Parsing<br>
 *
 * @author 
 * @see EsmSpcCodEvent , ESM_SPC_CODEventResponse 
 * @since J2EE 1.4
 */

public class EES_EQR_COMMONHTMLAction extends HTMLActionSupport {

	/**
	 * HTML DOM Value Parsing<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface
	 * @exception HTMLActionException 
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		//FormCommand command = FormCommand.fromRequest(request);
		EesEqrCodEvent event = new EesEqrCodEvent();
		
		
		request.setAttribute("Event", event);
		return event;
	}

	/**
	 * HttpRequest attribute<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest attribute<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}