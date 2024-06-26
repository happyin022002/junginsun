/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0256HTMLAction.java
*@FileTitle : Unmatch B/L Inquiry by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.22 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.BkgRevUmchBkgVO;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchBLListbyAuditorVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.revenueaudit 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RevenueAuditSC로 실행요청<br>
 * - RevenueAuditSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Seung Jun Lee
 * @see RevenueAuditEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0256HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0256HTMLAction 객체를 생성
	 */
	public ESM_BKG_0256HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RevenueAuditEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0256Event event = new EsmBkg0256Event();
		
		if(command.isCommand(FormCommand.MULTI01)) {
			event.setBkgRevUmchBkgVOS((BkgRevUmchBkgVO[])getVOs(request, BkgRevUmchBkgVO .class,""));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setBkgRevUmchBkgVOS((BkgRevUmchBkgVO[])getVOs(request, BkgRevUmchBkgVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setRsltUnmatchBLListbyAuditorVO((RsltUnmatchBLListbyAuditorVO)getVO(request, RsltUnmatchBLListbyAuditorVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setRsltUnmatchBLListbyAuditorVO((RsltUnmatchBLListbyAuditorVO)getVO(request, RsltUnmatchBLListbyAuditorVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setComBakEndJbVO((ComBakEndJbVO)getVO(request, ComBakEndJbVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setComBakEndJbVO((ComBakEndJbVO)getVO(request, ComBakEndJbVO.class));
		}
		else if (command.isCommand(FormCommand.MULTI03)) {
			//event.setUnmatchBLVO((UnmatchBLVO)getVO(request, UnmatchBLVO.class));
			event.setAttribute("bkgNoArr", JSPUtil.getNullNoTrim(request.getParameter("bkg_no_arr")));
		}
		else if(command.isCommand(FormCommand.MULTI04)) {
			event.setAttribute("bkgNoArr", JSPUtil.getNullNoTrim(request.getParameter("bkg_no_arr")));
		}		

		event.setAttribute("KEY", request.getParameter("backendjob_key"));
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