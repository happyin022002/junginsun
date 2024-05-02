/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0257HTMLAction.java
*@FileTitle : ManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.0.23
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.23 경종윤
* 1.0 Creation
* -------------------------------------------------------
* History
* 2011.11.21 김보배 [CHM-201114279] [BKG] [UI_BKG_0257_Europe Customs EDI] U/I변경 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondVO;
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
 * @author Kyoung Jong Yun
 * @see EsmBkg0257Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_0257HTMLAction extends HTMLActionSupport {
	
	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0257HTMLAction 객체를 생성
	 */
	public ESM_BKG_0257HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
    	
		EsmBkg0257Event event = new EsmBkg0257Event();
		
//		if(command.isCommand(FormCommand.MULTI) || command.isCommand(FormCommand.SEARCH07) ) { // 유럽 EDI flat file 생성 및 전송 or 전송 대상 존재여부 조회
//			event.setEuManifestTransmitVO((EurManifestTransmitVO)getVO(request, EurManifestTransmitVO.class));
		if(command.isCommand(FormCommand.MULTI)) { // 유럽 EDI flat file 생성 및 전송
//			event.setEuManifestTransmitVO((EurManifestTransmitVO)getVO(request, EurManifestTransmitVO.class));
			event.setEuManifestTransmitVOs((EurManifestTransmitVO[])getVOs(request, EurManifestTransmitVO.class));
			
		} else if(command.isCommand(FormCommand.SEARCH05) 
				|| command.isCommand(FormCommand.SEARCH06) 
				) { // uvi 조회 or pol,pod validation 
			
			EurManifestTransmitVO eurManifestTransmitVO = (EurManifestTransmitVO)getVO(request, EurManifestTransmitVO.class);
			
			event.setVvdCd(eurManifestTransmitVO.getVvdCd());
			event.setPodCd(eurManifestTransmitVO.getPodCd());
			event.setPolCd(eurManifestTransmitVO.getPolCd());

		} else if (command.isCommand(FormCommand.SEARCH03)) {
			// BackEndJob 으로 돌린 후 결과코드 조회
			event.setKey(request.getParameter("key"));		
			
		} else if (command.isCommand(FormCommand.SEARCH08)){
			event.setManifestListCondVO((ManifestListCondVO)getVO(request, EurManifestListCondVO.class));
		} else if (command.isCommand(FormCommand.SEARCH09)){
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
