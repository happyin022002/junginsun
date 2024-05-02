/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_BKG_1502HTMLAction.java
*@FileTitle : ESM_BKG_1502HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.05
*@LastModifier :
*@LastVersion : 1.0
* 2013.07.05
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpMarkDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.GetMdmCustomerVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - ESM_BKG_1502 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationJP24SC로 실행요청<br>
 * - CustomsDeclarationJP24SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM, Sang-Soo
 * @see EsmBkg1502Event 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_1502HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1502HTMLAction 객체를 생성
	 */
	public ESM_BKG_1502HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmBkg1502Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1502Event event = new EsmBkg1502Event();

		if (command.isCommand(FormCommand.SEARCH)    // RETRIEVE
		 || command.isCommand(FormCommand.COMMAND01)) {    // TRANSMIT
			event.setAdvJpBlVO((AdvJpBlVO)getVO(request, AdvJpBlVO.class));
		} else if (command.isCommand(FormCommand.SEARCH01)) {  // (btn_shpr, btn_cnee, btn_ntfy)
			event.setGetMdmCustomerVO((GetMdmCustomerVO)getVO(request, GetMdmCustomerVO.class));
		} else if (command.isCommand(FormCommand.MULTI01)) {    // SAVE
			event.setAdvJpBlVO((AdvJpBlVO)getVO(request, AdvJpBlVO.class));
			event.setAdvJpContainerVOs((AdvJpContainerVO[])getVOs(request, AdvJpContainerVO.class, "container_"));
			event.setAdvJpMarkDescVOs((AdvJpMarkDescVO[])getVOs(request, AdvJpMarkDescVO.class, "markdesc_"));
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