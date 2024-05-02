/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1055HTMLAction.java
*@FileTitle : MTY Discharge Plan by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import javax.servlet.http.HttpServletRequest;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDPortVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.eqr.cntrcodconfirm (HTML DOM Value Parsing)<br>
 * @author 
 * @see cntrcodconfirmEvent 
 * @since J2EE 1.6
 */

public class EES_EQR_1055HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_6003HTMLAction 
	 */
	public EES_EQR_1055HTMLAction() {}

	/**
	 * HTML DOM Value Parsing<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr1055Event event = new EesEqr1055Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setEmptyCODVVDPortVO((EmptyCODVVDPortVO)getVO(request, EmptyCODVVDPortVO .class));
		}

		return  event;
	}

	/**
	 * HttpRequest attribute<br>
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest attribute<br>
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}