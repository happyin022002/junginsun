/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0005HTMLAction.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * ESD_EAS_0005HTMLAction PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see HTMLActionSupport 참조
 * @since J2EE 1.4
 */
public class ESD_EAS_0005HTMLAction extends HTMLActionSupport {

	   /**
     * ESD_EAS_0005HTMLAction 객체를 생성
     */
    public ESD_EAS_0005HTMLAction() {
    }

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdEas0005Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
    	EsdEas0005Event event   = new EsdEas0005Event();
    	
    	if(command.isCommand(FormCommand.SEARCHLIST)){
    		String str_bkgno = JSPUtil.getNull(request.getParameter("bkgno"));
    		String str_blno  = JSPUtil.getNull(request.getParameter("blno"));
    		event.setBkgno(str_bkgno);
    		event.setBlno(str_blno);
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
