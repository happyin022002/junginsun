/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0533HTMLAction.java
*@FileTitle : Generate Arrival Manifest by Container
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.22
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.04.22 이수빈
* 1.0 Creation
* ------------------------------------------------------
* History
* 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondDataVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaMibTransmitVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InbondTransmissionSC로 실행요청<br>
 * - InbondTransmissionSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim DoWan
 * @see InbondTransmissionEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0533HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0533HTMLAction 객체를 생성
	 */
	public ESM_BKG_0533HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InbondTransmissionEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0533Event event = new EsmBkg0533Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setUsaInbondManifestDetailVOS((UsaInbondDataVO[])getVOs(request, UsaInbondDataVO.class, "t1sheet1_"));
			if(event.getUsaInbondManifestDetailVOS() == null){
				event.setUsaInbondManifestDetailVOS((UsaInbondDataVO[])getVOs(request, UsaInbondDataVO.class, "t2sheet1_"));
			}
		}else if(command.isCommand(FormCommand.SEARCH)) {
			event.setUsaInbondManifestListCondVO((UsaInbondManifestListCondVO)getVO(request, UsaInbondManifestListCondVO .class));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setUsaMibTransmitVOS((UsaMibTransmitVO [])getVOs(request, UsaMibTransmitVO .class, "t1sheet1_"));
			if(event.getUsaMibTransmitVOS() == null){
				event.setUsaMibTransmitVOS((UsaMibTransmitVO [])getVOs(request, UsaMibTransmitVO .class, "t2sheet1_"));
			}
			event.setUsaMibTransmitGubuns("Arr");
		}else if(command.isCommand(FormCommand.MULTI02)) {
			event.setUsaMibTransmitVOS((UsaMibTransmitVO [])getVOs(request, UsaMibTransmitVO .class, "t1sheet1_"));
			if(event.getUsaMibTransmitVOS() == null){
				event.setUsaMibTransmitVOS((UsaMibTransmitVO [])getVOs(request, UsaMibTransmitVO .class, "t2sheet1_"));
			}
			event.setUsaMibTransmitGubuns("Exp");	
		}else if(command.isCommand(FormCommand.MULTI03)) {
			event.setUsaMibTransmitVOS((UsaMibTransmitVO [])getVOs(request, UsaMibTransmitVO .class));
			event.setUsaMibDivInd("DIV");
		}
		else if (command.isCommand(FormCommand.SEARCH03))
		{
			// BackEndJob 으로 돌린 후 결과코드 조회
			event.setKey(request.getParameter("key"));
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