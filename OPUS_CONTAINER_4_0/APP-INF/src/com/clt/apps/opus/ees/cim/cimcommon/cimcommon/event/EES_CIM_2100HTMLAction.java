/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_2100HTMLAction.java
*@FileTitle : Container Type Size Division
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
import com.clt.syscommon.common.table.CimTpSzDpSeqVO;


/**
 * HTTP Parser<br>
 * parsing value from com.clt.apps.opus.ees.cim.cimcommon  screen as java variables
 * converting parsed information to Event, requesting to execute CimCommonSC with request
 * setting EvenetResponse transmitting result from CimCommonSC to View(JSP)as request
 * @author 
 * @see EesCim2100Event reference
 * @since J2EE 1.4
 */

public class EES_CIM_2100HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * creating EES_CIM_2100HTMLAction object
	 */
	public EES_CIM_2100HTMLAction() {}

	/**
	 * parsing value of HTML DOM object as java variables
	 * setting HttpRequst information parsed EesCim2100Event as request
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event 
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesCim2100Event event = new EesCim2100Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setCimTpSzDpSeqVOS((CimTpSzDpSeqVO[])getVOs(request, CimTpSzDpSeqVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setCimTpSzDpSeqVO((CimTpSzDpSeqVO)getVO(request, CimTpSzDpSeqVO .class));
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