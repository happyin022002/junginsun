/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_8003HTMLAction.java
*@FileTitle : Awkward Cargo Pricing Application
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.18
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.02.18 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.AwkCgoExtraCostByRouteVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCgoVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCntrTpszVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkHdrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkRqstVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.specialcargoquotation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SpecialCargoQuotationSC로 실행요청<br>
 * - SpecialCargoQuotationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Dong-sun Moon
 * @see SpecialCargoQuotationEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_8003HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_8003HTMLAction 객체를 생성
	 */
	public ESM_PRI_8003HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SpecialCargoQuotationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri8003Event event = new EsmPri8003Event();
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setPriScqAwkHdrVO((PriScqAwkHdrVO)getVO(request, PriScqAwkHdrVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setPriScqAwkHdrVO((PriScqAwkHdrVO)getVO(request, PriScqAwkHdrVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setPriScqAwkHdrVO((PriScqAwkHdrVO)getVO(request, PriScqAwkHdrVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setPriScqAwkCntrTpszVO((PriScqAwkCntrTpszVO)getVO(request, PriScqAwkCntrTpszVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setPriScqAwkHdrVO((PriScqAwkHdrVO)getVO(request, PriScqAwkHdrVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setPriScqAwkHdrVO((PriScqAwkHdrVO)getVO(request, PriScqAwkHdrVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setPriScqAwkHdrVO((PriScqAwkHdrVO)getVO(request, PriScqAwkHdrVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH12)) {
			event.setPriScqAwkHdrVO((PriScqAwkHdrVO)getVO(request, PriScqAwkHdrVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			PriScqAwkRqstVO vo = new PriScqAwkRqstVO();
			vo.setPriScqAwkHdrVOs((PriScqAwkHdrVO[])getVOs(request, PriScqAwkHdrVO .class,"sheet3_"));
			vo.setPriScqAwkCgoVOs((PriScqAwkCgoVO[])getVOs(request, PriScqAwkCgoVO .class,"sheet1_"));
			vo.setAwkCgoExtraCostByRouteVOs((AwkCgoExtraCostByRouteVO[])getVOs(request, AwkCgoExtraCostByRouteVO .class,"sheet2_"));
			event.setPriScqAwkRqstVO(vo);
		}
		else if(command.isCommand(FormCommand.MULTI11)) {
			PriScqAwkRqstVO vo = new PriScqAwkRqstVO();
			vo.setPriScqAwkHdrVO((PriScqAwkHdrVO)getVO(request, PriScqAwkHdrVO .class));
			vo.setPriScqAwkCgoVOs((PriScqAwkCgoVO[])getVOs(request, PriScqAwkCgoVO .class,"sheet1_"));
			vo.setAwkCgoExtraCostByRouteVOs((AwkCgoExtraCostByRouteVO[])getVOs(request, AwkCgoExtraCostByRouteVO .class,"sheet2_"));
			event.setPriScqAwkRqstVO(vo);
		}
		else if(command.isCommand(FormCommand.MULTI12)) {
			event.setPriScqAwkHdrVO((PriScqAwkHdrVO)getVO(request, PriScqAwkHdrVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI13)) {
			event.setPriScqAwkHdrVO((PriScqAwkHdrVO)getVO(request, PriScqAwkHdrVO .class));
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