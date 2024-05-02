/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1022HTMLAction.java
*@FileTitle : MTY Repo Inquiry by VVD
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

/**
 * HTTP Parser<br>
 * - com.clt.apps.enis.ees.eqr.cntrcodconfirm (HTML DOM Value Parsing)<br>
 * @author dev098
 * @see EesEqr1022Event 
 * @since J2EE 1.6
 */
public class EES_EQR_1022HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * EES_EQR_1049HTMLAction
     */
    public EES_EQR_1022HTMLAction() {}

    /**
     * HTML DOM Value Parsing<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        FormCommand command = FormCommand.fromRequest(request);
        EesEqr1022Event event = new EesEqr1022Event();
        

        if(command.isCommand(FormCommand.SEARCH)) {
            String vvd = request.getParameter("vvd");
            String version = request.getParameter("version");
            event.setAttribute("vvd", vvd);
            event.setAttribute("version", version);
        }else if(command.isCommand(FormCommand.SEARCH01)) {
            String vvd = request.getParameter("vvd");
            event.setAttribute("vvd", vvd);
        }

        request.setAttribute("Event", event);

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
     * HttpRequest attribute HttpRequest<br>
     * @param request HttpServletRequest HttpRequest
     * @param event Event interface
     */
    public void doEnd(HttpServletRequest request, Event event) {
        request.setAttribute("Event", event);
    }
}
