
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_0012HTMLAction.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.11 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.PortStlAmtVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.tot.tonnagetaxoutput 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TonnageTaxOutputSC로 실행요청<br>
 * - TonnageTaxOutputSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Chang Soo
 * @see TonnageTaxOutputEvent 참조
 * @since J2EE 1.4
 */

public class FNS_TOT_0012HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_TOT_0012HTMLAction 객체를 생성
	 */
	public FNS_TOT_0012HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TonnageTaxOutputEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsTot0012Event event = new FnsTot0012Event();
        log.debug("::CALL::> FNS_TOT_0012HTMLAction - " + command.getCommand());
        log.debug("FormCommand.SEARCH - " + FormCommand.SEARCH);
        
		if(command.isCommand(FormCommand.MULTI)) {
			event.setPortStlAmtVOs((PortStlAmtVO[])getVOs(request, PortStlAmtVO.class,"sheet1_"));

		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			event.setPortStlAmtVOs((PortStlAmtVO[])getVOs(request, PortStlAmtVO.class,"sheet1_"));

		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			 log.debug("::CALL::> FNS_TOT_0012HTMLAction -여기");
			event.setPortStlAmtVO((PortStlAmtVO)getVO(request, PortStlAmtVO.class));
			
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