/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_016HTMLAction.java
*@FileTitle : Service Order 생성-Supplement
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-30 juhyun
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.vo.SupplementSearchVO;
import com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.vo.SupplementVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.supplementsomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ESD_TRS_016SC로 실행요청<br>
 * - ESD_TRS_016SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author juhyun
 * @see EsdTrs0016Event , ESD_TRS_016EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0016HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_016HTMLAction 객체를 생성
	 */
	public ESD_TRS_0016HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_016Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		String prefix = "surcharge_";
		String [] 	scibflag 	= request.getParameterValues(prefix+"ibflag");

		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0016Event event = new EsdTrs0016Event();
		
		if(command.isCommand(FormCommand.SEARCHLIST01) || command.isCommand(FormCommand.SEARCHLIST02)){
		   	event.setSupplementSearchVO((SupplementSearchVO)getVO(request, SupplementSearchVO.class));
		}
		else if(command.isCommand(FormCommand.ADD) || command.isCommand(FormCommand.REMOVE)){
		   	event.setSupplementSearchVO((SupplementSearchVO)getVO(request, SupplementSearchVO.class));
			event.setSupplementVOs((SupplementVO[])getVOs(request, SupplementVO.class, ""));
			if (scibflag != null){
				event.setSurchargeVOs((SurchargeVO[])getVOs(request, SurchargeVO.class, prefix));;
			}
		}
		else;
		
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