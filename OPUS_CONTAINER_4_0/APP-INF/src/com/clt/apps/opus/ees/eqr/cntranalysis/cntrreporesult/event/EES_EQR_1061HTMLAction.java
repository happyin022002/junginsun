/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0144HTMLAction.java
*@FileTitle : EES_EQR_0144HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntranalysis.cntrreporesult.event;

import com.clt.apps.opus.ees.eqr.cntranalysis.cntrreporesult.vo.EmptyRepoResultOptionVO;
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.eqr.repoplanmanage <br>
 * @author 
 * @see RepoPlanManageEvent 
 * @since J2EE 1.6
 */

public class EES_EQR_1061HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0144HTMLAction 
	 */
	public EES_EQR_1061HTMLAction() {}

	/**
	 * HTML DOM Value Parsing<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);		
		EesEqr1061Event event = new EesEqr1061Event();
				
		// Retrieve 
		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setEmptyRepoResultOptionVO((EmptyRepoResultOptionVO)getVO(request, EmptyRepoResultOptionVO .class));
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