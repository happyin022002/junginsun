/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_010HTMLAction.java
*@FileTitle : Agent Commission Maintenance & Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-01
*@LastModifier : Junghyung_kim
*@LastVersion : 1.0
* 2006-12-01 Junghyung_kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.AgtAgnCommVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.agt.agtaudit 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AGTAuditSC로 실행요청<br>
 * - AGTAuditSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Junghyung_kim
 * @see EsmAgt0042Event , ESM_AGT_010EventResponse 참조
 * @since J2EE 1.4
 */
public class ESM_AGT_0042HTMLAction extends HTMLActionSupport {


	private static final long serialVersionUID = 1L;
	/**
	 * ESMAGT0042HTMLAction 객체를 생성
	 */
	public ESM_AGT_0042HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AGTAuditEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsmAgt0042Event event = new EsmAgt0042Event();
		

		switch (command.getCommand()) {
		case FormCommand.SEARCH:
			event.setAgtAgnCommVO((AgtAgnCommVO)getVO(request, AgtAgnCommVO.class));
			break;
		case FormCommand.MULTI:
			event.setAgtAgnCommVOS((AgtAgnCommVO[])getVOs(request, AgtAgnCommVO.class));
			event.setAgtAgnCommVO((AgtAgnCommVO)getVO(request, AgtAgnCommVO.class));
			log.debug("\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>FormCommand.MULTI:\n");
			log.debug("\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>FormCommand.MULTI:"+(AgtAgnCommVO)getVO(request, AgtAgnCommVO.class)==null?"0":"1"+"\n");
			break;
		case FormCommand.MODIFY:
			event.setAgtAgnCommVOS((AgtAgnCommVO[])getVOs(request, AgtAgnCommVO.class));
			event.setAgtAgnCommVO((AgtAgnCommVO)getVO(request, AgtAgnCommVO.class));
			break;
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
