/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_ENS_0067HTMLAction.java
*@FileTitle : EDI_STS (공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-17
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009-09-17 전병석
* 1.0 최초 생성
* 2009-09-18
* 1.3 버전 커밋
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;
 
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEDIPerformanceOptionsVO;
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
 * @author jun byoung suk
 * @see EsdSce0067Event , COM_ENS_0B2EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0067HTMLAction extends HTMLActionSupport {
	/**
     * COM_ENS_0B2HTMLAction 객체를 생성
     */
    public ESD_SCE_0067HTMLAction() {}
    
    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsdSce006Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform (HttpServletRequest request) throws HTMLActionException {
    	EsdSce0067Event event = null;   	 
//		    	Enumeration eParam = request.getParameterNames();
//		    	while (eParam.hasMoreElements()) {
//		    	    //String pName = (String)eParam.nextElement();
//		    	    //String pValue = request.getParameter(pName);
//		    	}
		    	FormCommand command = FormCommand.fromRequest(request);
				event = new EsdSce0067Event();
				if (command.isCommand(FormCommand.SEARCH)) {
					event.setSchEpOpts((SearchEDIPerformanceOptionsVO) getVO(request,SearchEDIPerformanceOptionsVO.class));
				}
				request.setAttribute("Event", event);
    	return event;
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
