/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1024HTMLAction.java
*@FileTitle : MTY COD Confirmation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.vo.EmptyCODVVDPort01VO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.eqr.cntroperationperformancemgt ( HTML DOM Value Parsing)<br>
 * @author 
 * @see CNTROperatioNPerformanceMgtEvent
 * @since J2EE 1.6
 */

public class EES_EQR_1024HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * EES_EQR_1049HTMLAction 
     */
    public EES_EQR_1024HTMLAction() {}

    /**
     * HTML DOM Value Parsing<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        FormCommand command = FormCommand.fromRequest(request);
        EesEqr1024Event event = new EesEqr1024Event();
        

        if(command.isCommand(FormCommand.SEARCH)) {
            String vvd = request.getParameter("vvd");
            String version = request.getParameter("version");
            event.setAttribute("vvd", vvd);
            event.setAttribute("version", version);
        }else if(command.isCommand(FormCommand.SEARCH01)) {
            String vvd = request.getParameter("vvd");
            event.setAttribute("vvd", vvd);
        }else if(command.isCommand(FormCommand.SEARCH02)) {
            String vvd = request.getParameter("vvd");
            String editPort = request.getParameter("editPort");
            String editIbFlag = request.getParameter("editIbFlag");
            event.setAttribute("vvd", vvd);
            event.setAttribute("editPort", editPort);
            event.setAttribute("editIbFlag", editIbFlag);
        }else if(command.isCommand(FormCommand.SEARCH03)) {
            String yardcode = request.getParameter("yardcode");
            event.setAttribute("yardcode", yardcode);
        }else if(command.isCommand(FormCommand.SEARCH04)) {
            String vvd = request.getParameter("vvd");
            String editPort = request.getParameter("editPort");
            String editIbFlag = request.getParameter("editIbFlag");
            event.setAttribute("vvd", vvd);
            event.setAttribute("editPort", editPort);
            event.setAttribute("editIbFlag", editIbFlag);
        }else if(command.isCommand(FormCommand.MULTI)) {
            String vvd = request.getParameter("vvd");
            String lane = request.getParameter("lane");
            String bay = request.getParameter("bay");
            String version = request.getParameter("version");
            String remark = request.getParameter("remark");
            String sh2RC = request.getParameter("sh2RC");
            String n1stEtb = request.getParameter("n1stEtb");
            event.setAttribute("vvd", vvd);
            event.setAttribute("lane", lane);
            event.setAttribute("bay", bay);
            event.setAttribute("version", version);
            event.setAttribute("remark", remark);
            event.setAttribute("sh2RC", sh2RC);
            event.setAttribute("n1stEtb", n1stEtb);
            event.setEmptyCODVVDPortVOS((EmptyCODVVDPort01VO[])getVOs(request, EmptyCODVVDPort01VO.class,""));
        }else if(command.isCommand(FormCommand.MULTI01)) { 
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
     * HttpRequest attribute
     * @param request HttpServletRequest HttpRequest
     * @param event Event interface
     */
    public void doEnd(HttpServletRequest request, Event event) {
        request.setAttribute("Event", event);
    }
}
 