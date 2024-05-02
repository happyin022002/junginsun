/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_9467HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.23
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2014.09.23 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;


import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgCustBlPprMgmtVO;

import javax.servlet.http.HttpServletRequest;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OutboundBLMgtSC로 실행요청<br>
 * - OutboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Jong-ho 
 * @see OutboundBLMgtEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_9467HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_9467HTMLAction 객체를 생성
	 */
	public ESM_BKG_9467HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OutboundBLMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg9467Event event = new EsmBkg9467Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setBkgCustBlPprMgmtVO((BkgCustBlPprMgmtVO)getVO(request, BkgCustBlPprMgmtVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			String ofcCd = JSPUtil.getParameter(request, "ofcCd");
			event.setOfcCd(ofcCd);
		}
		else if(command.isCommand(FormCommand.SEARCH02)||command.isCommand(FormCommand.SEARCH03)) {
			event.setBkgCustBlPprMgmtVO((BkgCustBlPprMgmtVO)getVO(request, BkgCustBlPprMgmtVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			event.setBkgCustBlPprMgmtVOs((BkgCustBlPprMgmtVO[])getVOs(request, BkgCustBlPprMgmtVO.class,""));
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			String bkg_no = JSPUtil.getParameter(request, "bkg_no");
			event.setBkgNo(bkg_no);
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