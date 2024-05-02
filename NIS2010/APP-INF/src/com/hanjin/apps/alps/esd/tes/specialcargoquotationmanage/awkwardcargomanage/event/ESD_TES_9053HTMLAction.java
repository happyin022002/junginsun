/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_9053HTMLAction.java
*@FileTitle : AWK Cargo Tariff Excel Upload-T/S
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesAwkCgoTrfMngVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.tes.guaranteemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OogSC로 실행요청<br>
 * - OogSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see OogEvent 참조
 * @since J2EE 1.6
 */

public class ESD_TES_9053HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_TES_9053HTMLAction 객체를 생성
	 */
	public ESD_TES_9053HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GuaranteeManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsdTes9053Event event = new EsdTes9053Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setTesAwkCgoTrfMngVO ((TesAwkCgoTrfMngVO) getVO(request, TesAwkCgoTrfMngVO .class));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setTesAwkCgoTrfMngVO ((TesAwkCgoTrfMngVO) getVO(request, TesAwkCgoTrfMngVO .class));
			event.setTesAwkCgoTrfMngVOs ((TesAwkCgoTrfMngVO[]) getVOs(request, TesAwkCgoTrfMngVO .class));
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