/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3522HTMLAction.java
*@FileTitle : Inland Rates Creation &amp; Amendment[Load Excel]
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.10
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.12.10 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.inlandrates.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.PriTrfInlndListVO;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.PriTrfInlndParamVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.PriTrfInlndRtVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.tariff 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TariffSC로 실행요청<br>
 * - TariffSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CHOI SUNGMIN
 * @see TariffEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_3522HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_3522HTMLAction 객체를 생성
	 */
	public ESM_PRI_3522HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TariffEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri3522Event event = new EsmPri3522Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setPriTrfInlndRtVOS((PriTrfInlndRtVO[])getVOs(request, PriTrfInlndRtVO .class));
		} else if(command.isCommand(FormCommand.MULTI)) {
			PriTrfInlndListVO vo = new PriTrfInlndListVO();		
			vo.setPriTrfInlndParamVO((PriTrfInlndParamVO)getVO(request, PriTrfInlndParamVO .class));
			vo.setPriTrfInlndRtVOs((PriTrfInlndRtVO[])getVOs(request, PriTrfInlndRtVO .class,"sheet1_"));
			event.setPriTrfInlndListVO(vo);
		} else {
			event.setPriTrfInlndParamVO((PriTrfInlndParamVO)getVO(request, PriTrfInlndParamVO .class));
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