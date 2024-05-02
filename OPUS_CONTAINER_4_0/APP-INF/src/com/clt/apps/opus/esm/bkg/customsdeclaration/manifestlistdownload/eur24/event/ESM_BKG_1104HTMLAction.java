/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0304HTMLAction.java
*@FileTitle : CndManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.06
*@LastModifier : 계기훈
*@LastVersion : 1.0
* 2010.09.06 계기훈
* 1.0 Creation
* -------------------------------------------------------
* History
* 2014.04.21 김보배 [CHM-201429518] ENS - Arrival Notice 화면 관련 시스템 보완요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24VesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalNoticeDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EurManifestListCondVO;
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
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_1104HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0745HTMLAction 객체를 생성
	 */
	public ESM_BKG_1104HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg1104Event event = new EsmBkg1104Event();
    	ManifestListCondVO manifestListCondVO = new EurManifestListCondVO(); 
		if(command.isCommand(FormCommand.SEARCH)) {
			Eur24VesselArrivalCondVO vesselArrivalCondVO = (Eur24VesselArrivalCondVO)getVO(request, Eur24VesselArrivalCondVO.class);
			event.setVesselArrivalCondVO(vesselArrivalCondVO);
		} else if(command.isCommand(FormCommand.SEARCH02)) {
			manifestListCondVO = (EurManifestListCondVO)getVO(request, EurManifestListCondVO.class);
			event.setManifestListCondVO(manifestListCondVO);
		} else if(command.isCommand(FormCommand.MULTI) || command.isCommand(FormCommand.MULTI02)) {
			event.setVesselArrivalDetailVO((Eur24VesselArrivalNoticeDetailVO)getVO(request, Eur24VesselArrivalNoticeDetailVO.class));
		} else if(command.isCommand(FormCommand.MULTI01)) {
			event.setEur24VesselArrivalTransmitVO((Eur24VesselArrivalTransmitVO) getVO(request, Eur24VesselArrivalTransmitVO.class));
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