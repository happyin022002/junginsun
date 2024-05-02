/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_PPL_0001_HTMLAction.java
*@FileTitle : Paperless
*Open Issues :
*Change history :
*@LastModifyDate : 2014-09-01
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014-09-01 차상영
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.paperless.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.bizcommon.packagetype.event.UiBkg0696Event;
import com.hanjin.bizcommon.packagetype.vo.PackageTypeVO;
import com.hanjin.bizcommon.paperless.vo.SearchPaperlessListVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.bizcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BizCommonSC로 실행요청<br>
 * - BizCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Hyunsu, Ryu
 * @see ComPpl0001Event , COM_PPL_0001_HTMLAction 참조
 * @since J2EE 1.4
 */
public class COM_PPL_0001_HTMLAction extends HTMLActionSupport {

    /**
     * COM_PPL_0001_HTMLAction 객체를 생성
     */
    public COM_PPL_0001_HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 COM_PPL_0001Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	
    	FormCommand command = FormCommand.fromRequest(request);
    	ComPpl0001Event event = new ComPpl0001Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchPaperlessListVO((SearchPaperlessListVO)getVO(request, SearchPaperlessListVO.class));
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