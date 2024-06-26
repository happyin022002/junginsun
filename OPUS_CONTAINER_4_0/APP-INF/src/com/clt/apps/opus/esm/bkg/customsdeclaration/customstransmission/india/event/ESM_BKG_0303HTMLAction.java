/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0303HTMLAction.java
 *@FileTitle : ESM_BKG_0303HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.01
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.07.01 경종윤
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaTransmitCondVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Kyoung Jong Yun
 * @see EsmBkg0303Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_0303HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	public ESM_BKG_0303HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		
		EsmBkg0303Event event = new EsmBkg0303Event();

		if (command.isCommand(FormCommand.MULTI)) {
			// Receive Log 조회
			IndiaTransmitCondVO condVO = (IndiaTransmitCondVO) getVO(request, IndiaTransmitCondVO.class);
			event.setIndiaTransmitCondVO(condVO);
		}
		request.setAttribute("Event", event);

		return event;
	}
}
