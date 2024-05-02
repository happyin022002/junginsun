/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1023HTMLAction.java
*@FileTitle : MTY Repo Inquiry by Period
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.MTYREPOByPeriodOptionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.enis.ees.eqr.cntrcodconfirm ( HTML DOM Value Parsing)<br>
 *
 * @author 
 * @see EesEqr1023Event 
 * @since J2EE 1.6
 */
public class EES_EQR_1023HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * EES_EQR_1049HTMLAction 
     */
    public EES_EQR_1023HTMLAction() {}

    /**
     * HTML DOM Value Parsing<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

        FormCommand command = FormCommand.fromRequest(request);
        EesEqr1023Event event = new EesEqr1023Event();

        if(command.isCommand(FormCommand.SEARCH)) {

            String fromdate     = request.getParameter( "fromdate"     );
            String enddate      = request.getParameter( "enddate"      );
            String location     = request.getParameter( "location"     );
            String inquirylevel = request.getParameter( "inquirylevel" );
            String div          = request.getParameter( "div"          );
            String tpsz         = request.getParameter( "tpsz"         );
            event.setAttribute( "fromdate"     , fromdate     );
            event.setAttribute( "enddate"      , enddate      );
            event.setAttribute( "location"     , location     );
            event.setAttribute( "inquirylevel" , inquirylevel );
            event.setAttribute( "div"          , div          );
            event.setAttribute( "tpsz"         , tpsz         );            

            event.setMTYREPOByPeriodOptionVO((MTYREPOByPeriodOptionVO)getVO(request, MTYREPOByPeriodOptionVO .class));
            
        }
		else if(command.isCommand(FormCommand.SEARCH01)) {
			String inquirylevel = request.getParameter("inquiryLevel");
			String location = request.getParameter("location");		
			event.setAttribute("inquirylevel", inquirylevel);
			event.setAttribute("location", location);
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
