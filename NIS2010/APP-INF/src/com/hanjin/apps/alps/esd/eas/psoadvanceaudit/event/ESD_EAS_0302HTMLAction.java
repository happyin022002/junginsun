/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : EDS_EAS_0302HTMLAction.java
*@FileTitle : Port (Service) Charge History
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-05
*@LastModifier : Do-Hyun Kim
*@LastVersion : 1.0
* 2014-12-05 Do-Hyun Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditListVO;

/**
 * EDS_EAS_0302HTMLAction ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author Do-Hyun Kim
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class ESD_EAS_0302HTMLAction extends HTMLActionSupport {

	   /**
     * EDS_EAS_0302HTMLAction 객체를 생성
     */
    public ESD_EAS_0302HTMLAction() {
    }

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdEas0302Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsdEas0302Event event = new EsdEas0302Event();
		
		if(command.isCommand(FormCommand.SEARCH)){ 
	    	event = new EsdEas0302Event();
			String issCtyCd = JSPUtil.getParameter(request, "iss_cty_cd", "");
			String soSeq = JSPUtil.getParameter(request, "so_seq", "");
			String soDtlSeq = JSPUtil.getParameter(request, "so_dtl_seq", "");
			String vesselClass = JSPUtil.getParameter(request, "vessel_class", "");
			String vessel = JSPUtil.getParameter(request, "vessel", "");
			String period1 = JSPUtil.getParameter(request, "period1", "");
			String period2 = JSPUtil.getParameter(request, "period2", "");
			String country = JSPUtil.getParameter(request, "country", "");
			String portCode = JSPUtil.getParameter(request, "port_cd", "");
			String yardCd = JSPUtil.getParameter(request, "yard_cd", "");
			String accountCode = JSPUtil.getParameter(request, "acct_cd", "");
			String costCode = JSPUtil.getParameter(request, "cost_cd", "");
			String vvd = JSPUtil.getParameter(request, "vvd", "");
			String rhq = JSPUtil.getParameter(request, "rhq", "");
			String expn_aud_sts_cd = JSPUtil.getParameter(request, "s_expn_aud_sts_cd", "");

			event.setIssCtyCd(issCtyCd);
			event.setSoSeq(soSeq);
			event.setSoDtlSeq(soDtlSeq);
			event.setVesselClass(vesselClass);
			event.setVessel(vessel);
			event.setPeriod1(period1);
			event.setPeriod2(period2);
			event.setCountry(country);
			event.setPortCode(portCode);
			event.setYardCd(yardCd);
			event.setAccountCode(accountCode);
			event.setCostCode(costCode);
			event.setVvd(vvd);
			event.setExpn_aud_sts_cd(expn_aud_sts_cd);
			event.setRhq(rhq);
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
