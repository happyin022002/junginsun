/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0009HTMLAction.java
*@FileTitle : Drop Off Charge Collection Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-21
*@LastModifier : choice
*@LastVersion : 1.0
* 2009-10-21 choice
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_0009HTMLAction ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class ESD_EAS_0009HTMLAction extends HTMLActionSupport {

	/**
     * ESD_EAS_0009HTMLAction 객체를 생성
     */
    public ESD_EAS_0009HTMLAction() {
    }

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdEas0009Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	
		FormCommand command = FormCommand.fromRequest(request);
		EsdEas0009Event event = new EsdEas0009Event();

		String ctrl_ofc_cd   = JSPUtil.getNull(request.getParameter("ctrl_ofc_cd"));
		String search_choice = JSPUtil.getNull(request.getParameter("search_choice"));
		String fromtrodate   = JSPUtil.getNull(request.getParameter("fromtrodate"));
		String totrodate     = JSPUtil.getNull(request.getParameter("totrodate"));
		String location      = JSPUtil.getNull(request.getParameter("location"));
		String haul_cd       = JSPUtil.getNull(request.getParameter("haul_cd"));
		
    	if(command.isCommand(FormCommand.SEARCH)){

    		event.setCtrlOfcCd(ctrl_ofc_cd);
    		event.setSearchChoice(search_choice);
    		event.setFromtrodate(fromtrodate);
    		event.setTotrodate(totrodate);
    		event.setLocation(location);
    		event.setHaulCd(haul_cd);
    	}

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
