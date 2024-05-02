/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_7001HTMLAction.java
*@FileTitle : MTY COD Confirmation
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-17
*@LastModifier : dev098
*@LastVersion : 1.0
* 2009-08-17 dev098
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODVVDPort01VO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.cntroperationperformancemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CNTROperatioNPerformanceMgtSC로 실행요청<br>
 * - CNTROperatioNPerformanceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Prak Kwang Seok
 * @see CNTROperatioNPerformanceMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_7001HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * EES_EQR_1049HTMLAction 객체를 생성
     */
    public EES_EQR_7001HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 CNTROperatioNPerformanceMgtEvent로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        FormCommand command = FormCommand.fromRequest(request);
        EesEqr7001Event event = new EesEqr7001Event();
        

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
     * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
     * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @param eventResponse EventResponse interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
        request.setAttribute("EventResponse", eventResponse);
    }

    /**
     * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
     * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @param event Event interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, Event event) {
        request.setAttribute("Event", event);
    }
}
 