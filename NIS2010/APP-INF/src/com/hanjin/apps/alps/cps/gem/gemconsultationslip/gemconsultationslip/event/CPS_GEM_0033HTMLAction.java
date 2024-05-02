/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CPS_GEM_0033HTMLAction.java
*@FileTitle : Consultation Slip
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.SerachConsultaionVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsulHdrVO;
import com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo.GemSubsCsulDtlVO;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.cps.gem.gemconsultationslip 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GEMConsultationSlipSC로 실행요청<br>
 * - GEMConsultationSlipSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see GEMConsultationSlipEvent 참조
 * @since J2EE 1.6
 */

public class CPS_GEM_0033HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * CPS_GEM_0033HTMLAction 객체를 생성
	 */
	public CPS_GEM_0033HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GEMConsultationSlipEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		CpsGem0033Event event = new CpsGem0033Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setGemSubsCsulHdrVO((GemSubsCsulHdrVO)getVO(request, GemSubsCsulHdrVO .class));
			event.setGemSubsCsulDtlVOs((GemSubsCsulDtlVO[])getVOs(request, GemSubsCsulDtlVO .class,""));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSerachConsultaionVO((SerachConsultaionVO)getVO(request, SerachConsultaionVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setSerachConsultaionVO((SerachConsultaionVO)getVO(request, SerachConsultaionVO .class));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setGemSubsCsulHdrVO((GemSubsCsulHdrVO)getVO(request, GemSubsCsulHdrVO .class));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setGemSubsCsulHdrVO((GemSubsCsulHdrVO)getVO(request, GemSubsCsulHdrVO .class));
		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setSerachConsultaionVO((SerachConsultaionVO)getVO(request, SerachConsultaionVO .class));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setGemSubsCsulHdrVO((GemSubsCsulHdrVO)getVO(request, GemSubsCsulHdrVO .class));
		}else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setSerachConsultaionVO((SerachConsultaionVO)getVO(request, SerachConsultaionVO .class));
		}else if(command.isCommand(FormCommand.MULTI02)) {
			event.setSerachConsultaionVO((SerachConsultaionVO)getVO(request, SerachConsultaionVO .class));
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