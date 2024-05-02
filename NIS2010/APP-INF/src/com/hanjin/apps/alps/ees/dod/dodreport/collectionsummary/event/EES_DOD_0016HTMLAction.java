/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EES_DOD_0016HTMLAction.java
*@FileTitle : DOD Collection Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-11
*@LastModifier : Hong Seong Pil
*@LastVersion : 1.0
* 2016-05-11 Hong Seong Pil
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.CollectionSummaryByCustomerVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DOD_0016HTMLAction PDTO(Data Transfer Object including Parameters)<br>
 * @author Hong Seong Pil
 * @see EventSupport 참조
 * @since J2EE 1.4 
 */
public class EES_DOD_0016HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
     * EES_DOD_0008HTMLAction 객체를 생성
     */
	public EES_DOD_0016HTMLAction() {
	}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EesDod0008Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EesDod0016Event event = new EesDod0016Event();
    	
    	if(command.isCommand(FormCommand.SEARCH)) {
    		event.setCollectionSummaryByCustomerVO((CollectionSummaryByCustomerVO)getVO(request, CollectionSummaryByCustomerVO.class));
    	}
    	
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
