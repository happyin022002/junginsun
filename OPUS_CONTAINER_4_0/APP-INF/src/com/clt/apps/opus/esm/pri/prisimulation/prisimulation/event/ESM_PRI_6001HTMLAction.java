/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_6001HTMLAction.java
*@FileTitle : Verify Rate
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtInVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.pricommondata 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PRICommonDataSC로 실행요청<br>
 * - PRICommonDataSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Dong-Sun Moon
 * @see PRICommonDataEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_6001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_6001HTMLAction 객체를 생성
	 */
	public ESM_PRI_6001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PRICommonDataEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri6001Event event = new EsmPri6001Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
//			event.setPrdCreateParamVO((PrdCreateParamVO)getVO(request, PrdCreateParamVO.class ));
			event.setPrdMainInfoVO((PrdMainInfoVO)getVO(request, PrdMainInfoVO.class ));
			event.setAplyRtInVO((AplyRtInVO)getVO(request, AplyRtInVO.class ));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setAplyRtInVO((AplyRtInVO)getVO(request, AplyRtInVO.class ));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			String ctrtNo = JSPUtil.getParameter(request, "ctrt_no");
			event.setCtrtNo(ctrtNo);
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			String key = JSPUtil.getParameter(request, "key");
			event.setKey(key);
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setAplyRtInVO((AplyRtInVO)getVO(request, AplyRtInVO.class ));
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