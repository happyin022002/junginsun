/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1021HTMLAction.java
*@FileTitle : MTY COD Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDPortVO;
import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.cim.cntrcodconfirm  (HTML DOM Value Parsing)<br>
 * @author 
 * @see cntrcodconfirmEvent 
 * @since J2EE 1.6
 */

public class EES_EQR_1021HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CIM_1038HTMLAction 
	 */
	public EES_EQR_1021HTMLAction() {}

	/**
	 * HTML DOM Parsing<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr1021Event event = new EesEqr1021Event();
		EmptyCODVVDVO emptyCODVVDVO = new EmptyCODVVDVO();
		if(command.isCommand(FormCommand.MULTI)) {
			event.setEmptyCODVVDPortVOs((EmptyCODVVDPortVO[])getVOs(request, EmptyCODVVDPortVO .class,""));
	//		event.setEmptyCODVVDVOs((EmptyCODVVDVO[])getVOs(request, EmptyCODVVDVO .class,""));
			event.setEmptyCODVVDVOs(emptyCODVVDVO.fromRequestGrid(request,"sub"));
			

		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			String week = request.getParameter("week");
			String vvd = request.getParameter("vvd");		
			event.setAttribute("week", week);
			event.setAttribute("vvd", vvd);
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			String week = request.getParameter("week");
			String trade = request.getParameter("trade");		
			event.setAttribute("week", week);
			event.setAttribute("trade", trade);
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