/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_8006HTMLAction.java
*@FileTitle : Break Bulk Cargo Pricing Application
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.12
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.02.12 문동선
* 1.0 Creation
=========================================================
* History 
* 2013.08.12 송호진 [CHM-201325335] Container Type & Q'ty 정보 Historical 관리 & Route 별 비용 Local Currency 적용
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCgoVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCntrTpszVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCntrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbHdrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbRoutCostVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbRqstVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.specialcargo 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 specialcargoSC로 실행요청<br>
 * - specialcargoSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Dong-sun Moon
 * @see specialcargoEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_8006HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_8006HTMLAction 객체를 생성
	 */
	public ESM_PRI_8006HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 specialcargoEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsmPri8006Event event = new EsmPri8006Event();
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setPriScqBbHdrVO((PriScqBbHdrVO)getVO(request, PriScqBbHdrVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setPriScqBbCgoVO((PriScqBbCgoVO)getVO(request, PriScqBbCgoVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setPriScqBbCntrVO((PriScqBbCntrVO)getVO(request, PriScqBbCntrVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setPriScqBbCntrTpszVO((PriScqBbCntrTpszVO)getVO(request, PriScqBbCntrTpszVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setPriScqBbHdrVO((PriScqBbHdrVO)getVO(request, PriScqBbHdrVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setPriScqBbHdrVO((PriScqBbHdrVO)getVO(request, PriScqBbHdrVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			PriScqBbRqstVO vo = new PriScqBbRqstVO();
			vo.setPriScqBbHdrVOs((PriScqBbHdrVO[])getVOs(request, PriScqBbHdrVO .class,"sheet1_"));
			vo.setPriScqBbCgoVOs((PriScqBbCgoVO[])getVOs(request, PriScqBbCgoVO .class,"sheet2_"));
			vo.setPriScqBbCntrVOs((PriScqBbCntrVO[])getVOs(request, PriScqBbCntrVO .class,"sheet3_"));
			event.setPriScqBbRqstVO(vo);
		}
		else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setPriScqBbRoutCostVO((PriScqBbRoutCostVO)getVO(request, PriScqBbRoutCostVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			PriScqBbRoutCostVO[] vos = (PriScqBbRoutCostVO[])getVOs(request, PriScqBbRoutCostVO .class,"");
			event.setPriScqBbRoutCostVOS(vos);
		}
		else if(command.isCommand(FormCommand.MULTI03)) {
			PriScqBbCntrVO[] vos = (PriScqBbCntrVO[])getVOs(request, PriScqBbCntrVO .class,"");
			event.setPriScqBbCntrVOS(vos);
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