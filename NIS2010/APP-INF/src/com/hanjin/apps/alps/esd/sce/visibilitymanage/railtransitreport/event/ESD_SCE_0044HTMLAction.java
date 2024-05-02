/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_044HTMLAction.java
*@FileTitle : Car Location Message(Pop)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-06
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-12-06 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMCountPopVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListPopVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRInfoVO;
import com.hanjin.framework.component.util.JSPUtil;
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
 * @see EsdSce044Event , EsdSce044EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0044HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
    /**
     * ESD_SCE_044HTMLAction 객체를 생성
     */
    public ESD_SCE_0044HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsdSce044Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	log.debug("Event 0044 생성!!");
		EsdSce0044Event event = new EsdSce0044Event();   
//        HashMap map = null;
        FormCommand f_cmd = FormCommand.fromRequest(request);
        if (f_cmd.isCommand(FormCommand.SEARCHLIST)) {
        	log.debug("SEARCHLIST(cnt) 를 위한 호출"); 
        	SearchRTRInfoVO condition = new SearchRTRInfoVO();
        	condition.setRCntrNo(JSPUtil.getParameter(request, "r_cntr_no", ""));
        	event.setSearchRTRInfo(condition);
        	event.setSearchPopCnt((SearchCLMCountPopVO) getVO(request, SearchCLMCountPopVO.class));
        } else if (f_cmd.isCommand(FormCommand.SEARCH01)) {
        	log.debug("SEARCHLIST(List) 를 위한 호출"); 
        	SearchRTRInfoVO condition = new SearchRTRInfoVO();
        	condition.setRCntrNo(JSPUtil.getParameter(request, "r_cntr_no", ""));
        	event.setSearchRTRInfo(condition);
        	event.setSearchPopList((SearchCLMListPopVO) getVO(request, SearchCLMListPopVO.class));
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