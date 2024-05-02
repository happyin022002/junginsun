/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_2006HTMLAction.java
*@FileTitle : USA Service Mode
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.CoaUsaSvcModVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.cim.cimcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 STDUnitCostSC로 실행요청<br>
 * - STDUnitCostSC로 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Chang Hun Kim
 * @see EsmCoa2006Event 참조
 * @since J2EE 1.4
 */

public class ESM_COA_2006HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_2006HTMLAction 객체를 생성
	 */
	public ESM_COA_2006HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmCoa2006Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmCoa2006Event event = new EsmCoa2006Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setCoaUsaSvcModVOS((CoaUsaSvcModVO[])getVOs(request, CoaUsaSvcModVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			//event.setCoaUsaSvcModVO((CoaUsaSvcModVO)getVO(request, CoaUsaSvcModVO .class));
			event.setOrgRgnCd(request.getParameter("f_org_rgn_cd"));
			event.setDestRgnCd(request.getParameter("f_dest_rgn_cd"));
			event.setSvcModCd(request.getParameter("f_svc_mod_cd"));
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