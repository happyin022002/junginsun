/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_037HTMLAction.java
*@FileTitle : Other Information info(Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-28
*@LastModifier : Sang-Jun Kwon
*@LastVersion : 1.0
* 2006-12-28 Sang-Jun Kwon
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.AgtAgnCtrtRefVO;
import com.clt.syscommon.common.table.AgtAgnOtrRefVO;



/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.agt.agtagreement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AGTAgreementSC로 실행요청<br>
 * - AGTAgreementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Sang-Jun Kwon
 * @see EsmAgt0037Event , ESM_AGT_0037EventResponse 참조
 * @since J2EE 1.4
 */
public class ESM_AGT_0037HTMLAction extends HTMLActionSupport {

	/**
	 * ESM_AGT_0037HTMLAction 객체를 생성
	 */
	public ESM_AGT_0037HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESM_AGT_0037Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		    	
		FormCommand command = FormCommand.fromRequest(request);
		EsmAgt0037Event event = new EsmAgt0037Event();
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setAgtAgnOtrRefVO((AgtAgnOtrRefVO)getVO(request, AgtAgnOtrRefVO.class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setAgtAgnOtrRefVO((AgtAgnOtrRefVO)getVO(request, AgtAgnOtrRefVO.class));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setAgtAgnCtrtRefVO((AgtAgnCtrtRefVO)getVO(request, AgtAgnCtrtRefVO.class));
		}else if(command.isCommand(FormCommand.SEARCH04)){
			event.setAgtAgnCtrtRefVO((AgtAgnCtrtRefVO)getVO(request, AgtAgnCtrtRefVO.class));
		}else if(command.isCommand(FormCommand.SEARCH05)){
			event.setAgtAgnOtrRefVO((AgtAgnOtrRefVO)getVO(request, AgtAgnOtrRefVO.class));
		}else if(command.isCommand(FormCommand.SEARCH06)){
			event.setAgtAgnOtrRefVO((AgtAgnOtrRefVO)getVO(request, AgtAgnOtrRefVO.class));		
		}
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