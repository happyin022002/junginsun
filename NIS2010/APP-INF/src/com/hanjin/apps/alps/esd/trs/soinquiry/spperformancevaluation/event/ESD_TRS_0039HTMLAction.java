/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_039HTMLAction.java
*@FileTitle : S/P Performance Evaluation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-27
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-11-27 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsTrspVndrPerfEvVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.soinquiry 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_0039SC로 실행요청<br>
 * - ESD_TRS_0039SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author juhyun
 * @see EsdTrs0039Event참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0039HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_039HTMLAction 객체를 생성
	 */
	public ESD_TRS_0039HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdTrs0039Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		TrsTrspVndrPerfEvVO trsTrspVndrPerfEvVO   = new TrsTrspVndrPerfEvVO();
		TrsTrspVndrPerfEvVO[] vpe = null; 
		if(command.isCommand(FormCommand.MULTI)) {
			vpe = trsTrspVndrPerfEvVO.fromRequestGrid(request);
		}		
		EsdTrs0039Event event = new EsdTrs0039Event();	
		
		event.setWonumber(JSPUtil.getNull(request.getParameter("wonumber")));
		event.setHidCreDt(JSPUtil.getNull(request.getParameter("hid_cre_dt")));
		event.setHidCreUsrId(JSPUtil.getNull(request.getParameter("hid_cre_usr_id")));
		event.setHidCreOfcCd(JSPUtil.getNull(request.getParameter("hid_cre_ofc_cd")));
		event.setHidPeriod(JSPUtil.getNull(request.getParameter("hid_period")));
		event.setHidFromDate(JSPUtil.getNull(request.getParameter("hid_from_date")));
		event.setHidToDate(JSPUtil.getNull(request.getParameter("hid_to_date")));
		event.setHidProvider(JSPUtil.getNull(request.getParameter("hid_provider")));
		
		event.setTrsTrspVndrPerfEvVOs(vpe);		
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