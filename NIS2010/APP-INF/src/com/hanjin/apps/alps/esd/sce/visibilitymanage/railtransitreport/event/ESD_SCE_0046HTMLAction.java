/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_0046HTMLAction.java
*@FileTitle : Train & Rail Car Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-11
*@LastModifier : 전병석
*@LastVersion : 1.3
* 2009-08-05 전병석
* 1.0 최초 생성
* 2009-08-11
* 1.3 버전 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListOptionsVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchTRCListOptionsVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ExceptionManageSC로 실행요청<br>
 * - ExceptionManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Seong-mun Kang
 * @see ESD_SCE_046Event , ESD_SCE_046EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0046HTMLAction extends HTMLActionSupport {

    /**
     * ESD_SCE_046HTMLAction 객체를 생성
     */
    public ESD_SCE_0046HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 ESD_SCE_046Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("Event 0046 생성");
    	FormCommand command = FormCommand.fromRequest(request);
		EsdSce0046Event event = new EsdSce0046Event();
		
        if (command.isCommand(FormCommand.SEARCHLIST)) {
			log.debug("VO(SearchCLMListOptionsVO) 정의하였습니다.");
			event.setSchTrclOpts((SearchTRCListOptionsVO) getVO(request,SearchTRCListOptionsVO.class));
			
		}//if
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