/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_8002HTMLAction.java
*@FileTitle : MTY Repo Inquiry by Period
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-17
*@LastModifier : dev098
*@LastVersion : 1.0
* 2009-08-17 dev098
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.MTYREPOByPeriodOptionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.eqr.eqtransportplannperform 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EQTransportPlanNPerformSC로 실행요청<br>
 * - EQTransportPlanNPerformSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author dev098
 * @see EesEqr8002Event 참조
 * @since J2EE 1.6
 */
public class EES_EQR_8002HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * EES_EQR_1049HTMLAction 객체를 생성
     */
    public EES_EQR_8002HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 CNTROperatioNPerformanceMgtEvent로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

        FormCommand command = FormCommand.fromRequest(request);
        EesEqr8002Event event = new EesEqr8002Event();

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