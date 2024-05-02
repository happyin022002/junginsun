/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_003HTMLAction.java
*@FileTitle : Special S/O Check - Supplement & Other
*Open Issues :
*Change history :
*@LastModifyDate : 2007-12-14
*@LastModifier : Jun Ho Kim
*@LastVersion : 1.0
* 2007-12-14 Jun Ho Kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;


/**
 * ESD_EAS_003HTMLAction ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author jhkim
 * @see HTMLActionSupport 참조
 * @since J2EE 1.4
 */
public class ESD_EAS_0003HTMLAction extends HTMLActionSupport {

	   /**
     * ESD_EAS_003HTMLAction 객체를 생성
     */
    public ESD_EAS_0003HTMLAction() {
    }

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_EAS_003Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsdEas0003Event event = null;
		
		
		event = new EsdEas0003Event();
		String so_ofc_cd = JSPUtil.getParameter(request, "so_ofc_cd", "");
		String bound = JSPUtil.getParameter(request, "bound", "");
		String so_month = JSPUtil.getParameter(request, "so_month", "");
		String fm_so_date = JSPUtil.getParameter(request, "fm_so_date", "");
		String to_so_date = JSPUtil.getParameter(request, "to_so_date", "");
		
		event.setSoOfcCd(so_ofc_cd);
		event.setBound(bound);
		event.setSoMonth(so_month);
		event.setFmSoDate(fm_so_date);
		event.setToSoDate(to_so_date);
		
		
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
