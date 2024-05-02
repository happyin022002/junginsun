/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7011HTMLAction.java
*@FileTitle : DEM/DET User Role Match
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.26
*@LastModifier : Kim YC
*@LastVersion : 1.0

* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.ApproSetupVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchApproSetupInfoListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand; 

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.apls.ees.dmt.dmtexceptionmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DMTExceptionMgtSC로 실행요청<br>
 * - DMTInvoiceMgtSC 에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lim Chang Bin
 * @see DMTExceptionMgtEvent 참조
 * @since J2EE 1.4
 */

public class EES_DMT_7011HTMLAction extends HTMLActionSupport {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 InvoiceMgtEvent로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        
        FormCommand command = FormCommand.fromRequest(request);
        EesDmt7011Event event = new EesDmt7011Event();
        
        if(command.isCommand(FormCommand.SEARCH)) {
 	         event.setApproSetupVO((ApproSetupVO)getVO(request, ApproSetupVO .class));
		} else if(command.isCommand(FormCommand.MULTI)) {
			event.setSearchApproSetupInfoListVOs((SearchApproSetupInfoListVO[])getVOs(request, SearchApproSetupInfoListVO .class, ""));
		} else if(command.isCommand(FormCommand.SEARCH01)) {
			 event.setSearchApproSetupInfoListVO((SearchApproSetupInfoListVO)getVO(request, SearchApproSetupInfoListVO .class));
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
