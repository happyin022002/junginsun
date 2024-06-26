/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_5005HTMLAction.java
*@FileTitle : Service Scope Property Mapping Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.17
*@LastModifier : SHKIM
*@LastVersion : 1.0
* 2012.04.17 SHKIM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.event;

import javax.servlet.http.HttpServletRequest;

//import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.SvcScpPptVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltServiceScopePropertyVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.PriSvcScpPptMapgVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.pricommondata 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TariffSC로 실행요청<br>
 * - PRISC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SHKIM
 * @see PRI 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_5005HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_5004HTMLAction 객체를 생성
	 */
	public ESM_PRI_5005HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PRIEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri5005Event event = new EsmPri5005Event();
		
		if(command.isCommand(FormCommand.SEARCH)) { 
			event.setPriSvcScpPptMapgVO((PriSvcScpPptMapgVO)getVO(request, PriSvcScpPptMapgVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			event.setPriSvcScpPptMapgVO((PriSvcScpPptMapgVO)getVO(request, PriSvcScpPptMapgVO .class));
			event.setPriSvcScpPptMapgVOs((PriSvcScpPptMapgVO[])getVOs(request, PriSvcScpPptMapgVO.class,""));
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