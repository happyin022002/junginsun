/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0613HTMLAction.java
*@FileTitle : US AMS: Manifest Transmit (MI)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.04.23 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaVesselCondVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 manifestlistdownloadSC로 실행요청<br>
 * - manifestlistdownloadSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim DoWan
 * @see manifestlistdownloadEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0613HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * ESM_BKG_0613HTMLAction 객체를 생성
     */
    public ESM_BKG_0613HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 manifestlistdownloadEvent로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);

		EsmBkg0613Event event = new EsmBkg0613Event();

		if (command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH01))
		{
			// MI Manifest Transmit 정보 조회
			event.setCondVO((UsaManifestSearchCondVO) getVO(request, UsaManifestSearchCondVO.class));
		}
		else if (command.isCommand(FormCommand.REMOVE01))
		{
			// MI Manifest Transmit B/L 삭제.
			event.setUsaManifestSearchDetailVOS ((UsaManifestSearchDetailVO[]) getVOs(request, UsaManifestSearchDetailVO.class, "sheet2_"));
			
		}
		else if (command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.MULTI02))
		{
			// MI Manifest Transmit 정보 전송
			event.setUsaManifestSearchDetailVOS ((UsaManifestSearchDetailVO[]) getVOs(request, UsaManifestSearchDetailVO.class, "sheet2_"));
		}
		else if (command.isCommand(FormCommand.SEARCH03))
		{
			// BackEndJob 으로 돌린 후 결과코드 조회
			event.setKey(request.getParameter("key"));				
		}
		else if (command.isCommand(FormCommand.COMMAND01))
		{
			// BackEndJob 으로 돌린 후 결과코드 조회
			event.setVesselCondVO((UsaVesselCondVO) getVO(request, UsaVesselCondVO.class));				
		}
		request.setAttribute("Event", event);

		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param eventResponse
	 *            EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param event
	 *            Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}