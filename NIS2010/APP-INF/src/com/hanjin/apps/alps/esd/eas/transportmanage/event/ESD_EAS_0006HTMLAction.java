/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0006HTMLAction.java
*@FileTitle : C/H Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-29
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-29 yujin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.eas.transportmanage.vo.SearchMscCheckListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * ESD_EAS_0006HTMLAction PDTO(Data Transfer Object including Parameters)<br>
 * @author yujin
 * @see HTMLActionSupport 참조
 * @since J2EE 1.4
 */
public class ESD_EAS_0006HTMLAction extends HTMLActionSupport {

	   /**
     * ESD_EAS_0006HTMLAction 객체를 생성
     */
    public ESD_EAS_0006HTMLAction() {
    }

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdEas0006Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	
    	FormCommand command = FormCommand.fromRequest(request);
    	EsdEas0006Event event = new EsdEas0006Event();
    	
    	if(command.isCommand(FormCommand.SEARCHLIST)){
    		event.setSearchMscCheckListVo((SearchMscCheckListVO) getVO(request, SearchMscCheckListVO.class));
    	} else if(command.isCommand(FormCommand.SEARCH11)){//Sub-Office
    		event.setSearchMscCheckListVo((SearchMscCheckListVO) getVO(request, SearchMscCheckListVO.class));
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
