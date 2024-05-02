/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CIM_COMHTMLAction.java
*@FileTitle :CIM_COMMON PAGE
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * parsing value from com.clt.apps.opus.ees.cim.cimcommon screen as java variables
 * converting parsed information to Event, requesting to execute CimCommonSC with request
 * setting EvenetResponse transmitting result from MSTCommonSC to View(JSP)as request
 * @author NamKoong
 * @see CIMCommonEvent reference
 * @since J2EE 1.6
 */ 

public class CIM_COMHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * creating MST_COMHTMLAction object
	 */
	public CIM_COMHTMLAction() {}

	/**
	 * parsing value of HTML DOM object as java variables
	 * setting HttpRequst information parsed MSTCommonEvent as request
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event 
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		CimComEvent event = new CimComEvent();
		

		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setIntgCdId(request.getParameter("intgCdId"));
			event.setIntgCdVal(request.getParameter("intgCdVal"));
		}
		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * saving business scenario result in attribute of HttpRequest
	 * setting ResultSet to request to transmit executing result from ServiceCommand to View(JSP)
	 * 
	 * @param request HttpServletRequest 
	 * @param eventResponse EventResponse 
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * setting HttpRequest parsing result as request
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event 
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}