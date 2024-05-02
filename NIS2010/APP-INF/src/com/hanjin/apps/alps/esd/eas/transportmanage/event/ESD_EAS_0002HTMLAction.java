/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_002HTMLAction.java
*@FileTitle : Route UnMatch List
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-30
*@LastModifier : ho-sam lee
*@LastVersion : 1.0
* 2008-01-30 ho-sam lee
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
 * ESD_EAS_002HTMLAction ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class ESD_EAS_0002HTMLAction extends HTMLActionSupport {

	   /**
     * ESD_EAS_002HTMLAction 객체를 생성
     */
    public ESD_EAS_0002HTMLAction() {
    }

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdEas0002Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsdEas0002Event event = null;
		
		if(command.isCommand(FormCommand.SEARCH)){    	
	    	event = new EsdEas0002Event();
			String ctrl_ofc_cd = JSPUtil.getParameter(request, "ctrl_ofc_cd", "");
			String s_bnd = JSPUtil.getParameter(request, "s_bnd", "");
			String org = JSPUtil.getParameter(request, "org", "");
			String dest = JSPUtil.getParameter(request, "dest", "");
			String search_choice = JSPUtil.getParameter(request, "search_choice", "");
			String somonth = JSPUtil.getParameter(request, "somonth", "");
			String fromsodate = JSPUtil.getParameter(request, "fromsodate", "");
			String tosodate = JSPUtil.getParameter(request, "tosodate", "");
			String port = JSPUtil.getParameter(request, "port", "");
			
			event.setCtrlOfcCd(ctrl_ofc_cd);
			event.setSBnd(s_bnd);
			event.setOrg(org);
			event.setDest(dest);
			event.setSearchChoice(search_choice);
			event.setSomonth(somonth);
			event.setFromsodate(fromsodate);
			event.setTosodate(tosodate);
			event.setPort(port);
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
