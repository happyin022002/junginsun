/*=========================================================
*Copyright(c) 2017 Hi-Plus Card
*@FileName : ESM_BKG_0991HTMLAction.java
*@FileTitle : ESM_BKG-0991
*Open Issues :
*Change history :
*	2017.09.07 하대성 2017 Renewal Version Transmit 반영
*@LastModifyDate : 2017.09.07
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2009.05.26 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM SEUNG MIN
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */
public class ESM_BKG_0991HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0991HTMLAction 객체를 생성 
	 */
	public ESM_BKG_0991HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg0991Event event = new EsmBkg0991Event();
    	JapanManifestTransmitContainerVO japanManifestTransmitContainerVO = new JapanManifestTransmitContainerVO();
    	JapanManifestTransmitCondVO japanManifestTransmitCondVO = new JapanManifestTransmitCondVO();
    	JapanManifestTransmitVO[] japanManifestTransmitVOs = null;
    	if(command.isCommand(FormCommand.MULTI)) { 
			japanManifestTransmitVOs = (JapanManifestTransmitVO[])getVOs(request, JapanManifestTransmitVO.class);
			japanManifestTransmitCondVO = (JapanManifestTransmitCondVO)getVO(request, JapanManifestTransmitCondVO.class);
			japanManifestTransmitContainerVO.setJapanManifestTransmitCondVO(japanManifestTransmitCondVO);
			japanManifestTransmitContainerVO.setJapanManifestTransmitVOs(japanManifestTransmitVOs);
			event.setManifestTransmitVO((ManifestTransmitVO)japanManifestTransmitContainerVO);
		} else if(command.isCommand(FormCommand.MULTI11)) {
			japanManifestTransmitVOs = (JapanManifestTransmitVO[])getVOs(request, JapanManifestTransmitVO.class);
			japanManifestTransmitCondVO = (JapanManifestTransmitCondVO)getVO(request, JapanManifestTransmitCondVO.class);
			japanManifestTransmitContainerVO.setJapanManifestTransmitCondVO(japanManifestTransmitCondVO);
			japanManifestTransmitContainerVO.setJapanManifestTransmitVOs(japanManifestTransmitVOs);
			event.setManifestTransmitVO((ManifestTransmitVO)japanManifestTransmitContainerVO);
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
