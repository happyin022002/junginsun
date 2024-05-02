/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0484HTMLAction.java
*@FileTitle : ManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.10.08 경종윤
* 1.0 Creation
*--------------------------------------------------------
* History
* 2011.02.23 이일민 [CHM-201108294] 구주 EU24 관련 SITPRO 수정 요청 (ENS Download 버튼 추가)
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCargoManifestCondForEdiVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kyoung Jong Yun
 * @see EsmBkg0484Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_0484HTMLAction extends HTMLActionSupport {
	
	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0257HTMLAction 객체를 생성
	 */
	public ESM_BKG_0484HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0484Event event = new EsmBkg0484Event();
		if (command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH04) || command.isCommand(FormCommand.SEARCH05)) { // Sitpro 조회 || VVD와 PORT 존재여부 조회 || ENS Download
			event.setSitProCargoManifestCondForEdiVO((SitProCargoManifestCondForEdiVO) getVO(request, SitProCargoManifestCondForEdiVO.class));
			if (command.isCommand(FormCommand.SEARCH05)) {
				event.setBkgNos(request.getParameterValues("bkg_nos"));
			}
		} else if(command.isCommand(FormCommand.MULTI)| command.isCommand(FormCommand.SEARCH06)) {  // Sitpro flat file 생성 및 전송
			event.setEuManifestTransmitVOs((EurManifestTransmitVO[])getVOs(request, EurManifestTransmitVO.class));
		} else if (command.isCommand(FormCommand.SEARCH03) || command.isCommand(FormCommand.SEARCH07)) {
			event.setKey(request.getParameter("key"));	// BackEndJob 으로 돌린 후 결과코드 조회	
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
