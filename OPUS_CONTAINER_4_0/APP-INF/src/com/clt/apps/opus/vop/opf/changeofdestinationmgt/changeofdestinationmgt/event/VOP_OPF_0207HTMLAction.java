/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0207HTMLAction.java
*@FileTitle : COD Tariff Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.29 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ChangeOfDestinationMgtConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.OpfCodDvsFeeVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.vop.opf.changeofdestinationmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ChangeOfDestinationMgtSC로 실행요청<br>
 * - ChangeOfDestinationMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Jong Ock
 * @see ChangeOfDestinationMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_OPF_0207HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_OPF_0207HTMLAction 객체를 생성
	 */
	public VOP_OPF_0207HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ChangeOfDestinationMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopOpf0207Event event = new VopOpf0207Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setOpfCodDvsFeeVOS((OpfCodDvsFeeVO[])getVOs(request, OpfCodDvsFeeVO .class,"sheet1_"));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			//event.setOpfCodDvsFeeVO((OpfCodDvsFeeVO)getVO(request, OpfCodDvsFeeVO .class));
			event.setChangeOfDestinationMgtConditionVO((ChangeOfDestinationMgtConditionVO)getVO(request, ChangeOfDestinationMgtConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setChangeOfDestinationMgtConditionVO((ChangeOfDestinationMgtConditionVO)getVO(request, ChangeOfDestinationMgtConditionVO .class));
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