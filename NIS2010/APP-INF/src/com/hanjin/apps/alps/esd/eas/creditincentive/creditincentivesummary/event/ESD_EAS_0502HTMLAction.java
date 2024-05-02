/*============================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESD_EAS_0502HTMLAction.java
*@FileTitle : 
*@LastModifyDate : 2016.04.26.
*@LastModifier : 
*@LastVersion : 
* 2016.04.26. SHIN DONG IL
*============================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.event.EventSupport;

import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.event.EsdEas0502Event;

/**
 * ESD_EAS_0501HTMLAction PDTO(Data Transfer Object including Parameters)<br>
 * @author SHIN DONG IL
 * @see EventSupport 참조
 * @since J2EE 1.6
 */
public class ESD_EAS_0502HTMLAction extends HTMLActionSupport{
	/**
	 * ESD_EAS_0502HTMLAction 객체를 생성 
	 */
	public ESD_EAS_0502HTMLAction() {}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdEas0501Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsdEas0502Event event = new EsdEas0502Event();
		
		if(command.isCommand(FormCommand.SEARCHLIST01) || command.isCommand(FormCommand.SEARCHLIST02)){
			event.setRhqCd(JSPUtil.getParameter(request, "s_rhq_cd", ""));
			event.setSmmrDivCd(JSPUtil.getParameter(request, "s_smmr_div_cd", ""));
			event.setBseYr(JSPUtil.getParameter(request, "s_bse_yr", ""));
			event.setCrSrcCd(JSPUtil.getParameter(request, "s_cr_src_cd_tab1", ""));
		}else if(command.isCommand(FormCommand.SEARCHLIST03)){ 
			event.setFmDt(JSPUtil.getParameter(request, "s_fm_dt", "").replace("-", ""));
			event.setToDt(JSPUtil.getParameter(request, "s_to_dt", "").replace("-", ""));
			event.setCrSrcCd(JSPUtil.getParameter(request, "s_cr_src_cd_tab2", ""));
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