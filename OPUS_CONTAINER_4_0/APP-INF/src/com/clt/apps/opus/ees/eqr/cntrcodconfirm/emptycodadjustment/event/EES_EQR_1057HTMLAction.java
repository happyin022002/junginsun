/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1057HTMLAction.java
*@FileTitle : Hanger Rack MTY CNTR List / Damage MTY CNTR List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.DamageRevenueListOptionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.enis.ees.eqr.cntrcodconfirm (HTML DOM Value Parsing)<br>
 * @author 
 * @see EesEqr1057Event 
 * @since J2EE 1.6
 */
public class EES_EQR_1057HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * EES_EQR_1049HTMLAction 
     */
    public EES_EQR_1057HTMLAction() {}

    /**
     * HTML DOM Value Parsing<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

        FormCommand command = FormCommand.fromRequest(request);
        EesEqr1057Event event = new EesEqr1057Event();

        if(command.isCommand(FormCommand.SEARCH)) {

            String vvd = request.getParameter("vvd");
            String pod = request.getParameter("pod");
            event.setAttribute("vvd", vvd);
            event.setAttribute("pod", pod);
            
            event.setDamageRevenueListOptionVO((DamageRevenueListOptionVO)getVO(request, DamageRevenueListOptionVO .class));
            
        }else if(command.isCommand(FormCommand.SEARCH01)) {

            String vvd = request.getParameter("vvd");
            String pod = request.getParameter("pod");
            event.setAttribute("vvd", vvd);
            event.setAttribute("pod", pod);

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
     * HttpRequest attribute<br>
     * @param request HttpServletRequest HttpRequest
     * @param event Event interface
     */
    public void doEnd(HttpServletRequest request, Event event) {
        request.setAttribute("Event", event);
    }
}
