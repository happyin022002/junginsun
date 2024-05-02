package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

public class BCM_CCD_0054HTMLAction extends HTMLActionSupport {

	public BCM_CCD_0054HTMLAction() {
		
	}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 BCM_CMS_0305Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		int iPage			= JSPUtil.getParameterAsInt(request, "iPage", 1);
		
		log.debug("iPage : " + iPage + ", Request iPage :" + JSPUtil.getParameter(request, "iPage"));
		
		BcmCcd0054Event event = new BcmCcd0054Event();

		event.setMdmVendorVO((VendorVO)getVO(request, VendorVO.class));
		event.setiPage(iPage);
		request.setAttribute("Event", event);
		
		return event;
	}

	/** 
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest
	 * @param eventResponse EventResponse 
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}
	
	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest
	 * @param event Event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}
