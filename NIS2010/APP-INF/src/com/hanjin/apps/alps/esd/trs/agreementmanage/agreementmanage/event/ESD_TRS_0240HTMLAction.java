/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESD_TRS_0240HTMLAction.java
 *@FileTitle : HJL Handling Fee
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012-05-23
 *@LastModifier : SHIN DONG IL
 *@LastVersion : 1.0
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsHjlHndlFeeVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.agreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CYDoorSOManageSC로 실행요청<br>
 * - CYDoorSOManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 2007621
 * @see EsdTrs0240Event , ESD_TRS_0240EventResponse 참조
 * @since J2EE 1.4
 */

public class ESD_TRS_0240HTMLAction extends HTMLActionSupport {
	
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_0240HTMLAction 객체를 생성
	 */
	public ESD_TRS_0240HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdTrs0240Event 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
	
		EsdTrs0240Event event = new EsdTrs0240Event();
		
		if(command.isCommand(FormCommand.MULTI01)){
			event.setTrsHjlHndlFeeVOs((TrsHjlHndlFeeVO[])getVOs(request, TrsHjlHndlFeeVO .class,""));
		}
		
		String usr_id = JSPUtil.getNull(request.getParameter("usr_id"));
		String usr_ofc_cd = JSPUtil.getNull(request.getParameter("usr_ofc_cd"));
		String ofc_cd = JSPUtil.getNull(request.getParameter("ofc_cd"));
		String fm_dt = JSPUtil.getNull(request.getParameter("fm_dt"));


		event.setUsr_id(usr_id);
		event.setUsr_ofc_cd(usr_ofc_cd);
		event.setOfc_cd(ofc_cd);
		event.setFm_dt(fm_dt);

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