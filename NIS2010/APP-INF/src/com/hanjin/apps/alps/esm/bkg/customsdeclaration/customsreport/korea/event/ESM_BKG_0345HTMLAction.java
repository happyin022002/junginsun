/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0345HTMLAction.java
*@FileTitle : ESM_BKG_0345HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 7. 3.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 7. 3. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorWareHouseCondVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 *  HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅
 * 
 * @author 박상훈
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */
public class ESM_BKG_0345HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 2792293631096541043L;

	public ESM_BKG_0345HTMLAction() {}

	/**
	 * 요청 처리부 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		// FormCommand 처리
		FormCommand command = FormCommand.fromRequest(request);
		// EVENT 생성
		EsmBkg0345Event event = new EsmBkg0345Event();
		
		// COMMAND 구분에 따른 처리
		if(command.isCommand(FormCommand.SEARCH)) 
    	{
			// 조회의 경우 처리
			KorWareHouseCondVO korWareHouseCondVO = (KorWareHouseCondVO)getVO(request, KorWareHouseCondVO.class);
			event.setKorWareHouseCondVO(korWareHouseCondVO);
    	}
		
		// 응답결과에 event 할당
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
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) 
	{
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) 
	{
		request.setAttribute("Event", event);
	}

}
