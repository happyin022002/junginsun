/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0393HTMLAction.java
*@FileTitle : House B/L Data Input Checklist
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.07.30 이수빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.HusBlInpChkCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaHblCheckCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlCondVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Subin
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0393HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0393HTMLAction 객체를 생성
	 */
	public ESM_BKG_0393HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0393Event event = new EsmBkg0393Event();

		event.setCustoms(request.getParameter("customs"));
		
		if( command.isCommand(FormCommand.SEARCH) )	{
			if ("CA".equals(event.getCustoms()))
			{
				event.setHouseBlCondVO((HusBlInpChkCondVO)getVO(request, HusBlInpChkCondVO.class));
			}
			else
			{
				event.setHouseBlCondVO((HouseBlCondVO)getVO(request, UsaHblCheckCondVO.class));
			}
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