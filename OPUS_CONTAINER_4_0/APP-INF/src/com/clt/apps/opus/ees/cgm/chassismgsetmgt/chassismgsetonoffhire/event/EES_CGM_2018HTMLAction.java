/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2018HTMLAction.java
*@FileTitle : M.G Set 의 Status History 조회및 수정하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.16 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSStatusInfoINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSStatusInfoMGTVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.cgm.chassismgsetmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ChassisMgsetMgtSC로 실행요청<br>
 * - ChassisMgsetMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CHOI MIN HOI
 * @see ChassisMgsetMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_CGM_2018HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CGM_2018HTMLAction 객체를 생성
	 */
	public EES_CGM_2018HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ChassisMgsetMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesCgm2018Event event = new EesCgm2018Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setMgsStatusInfoINVO((MGSStatusInfoINVO)getVO(request, MGSStatusInfoINVO .class));
		} else if(command.isCommand(FormCommand.MULTI01)) {
			event.setMgsStatusInfoMGTVOs((MGSStatusInfoMGTVO[])getVOs(request, MGSStatusInfoMGTVO .class,""));
		} else if(command.isCommand(FormCommand.MULTI02)) {
			event.setMgsStatusInfoMGTVOs((MGSStatusInfoMGTVO[])getVOs(request, MGSStatusInfoMGTVO .class,""));
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