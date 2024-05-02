/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_0963HTMLAction.java
*@FileTitle : Bundling
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.14
*@LastModifier : 김영철
*@LastVersion : 1.0
* --------------------------------------------------------
* history
* 2011.07.14 김영철 [CHM-201110224] [TRS] Flat rack CNTR Bundling 기능 추가요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.vo.BundlingListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.workordermanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WorkOrderManageSC로 실행요청<br>
 * - WorkOrderManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Young Chul
 * @see EsdTrs0963Event 참조
 * @since J2EE 1.4
 */

public class ESD_TRS_0963HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_TRS_0963HTMLAction 객체를 생성
	 */
	public ESD_TRS_0963HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0963Event event = new EsdTrs0963Event();
		TrsTrspSvcOrdVO trsTrspSvcOrdVO = new TrsTrspSvcOrdVO();
		BundlingListVO bundlingListVO = new BundlingListVO();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setTrsTrspSvcOrdVOs(trsTrspSvcOrdVO.fromRequestGrid(request));
		} else if (command.isCommand(FormCommand.MULTI01)) {
			event.setBundlingListVOs(bundlingListVO.fromRequestGrid(request));
		}else if (command.isCommand(FormCommand.MULTI02)) {
			event.setBundlingListVOs(bundlingListVO.fromRequestGrid(request));
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