/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_ctm_0400HTMLAction.java
*@FileTitle : Container Movement Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.04.24 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.RCtmMvmtStsVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.CtmMvmtStsVO;



/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.ctm.equipmentmovementmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EquipmentMovementMgtSC로 실행요청<br>
 * - EquipmentMovementMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author KyungMin Woo
 * @see EquipmentMovementMgtEvent 참조
 * @since J2EE 1.4
 */
public class EES_CTM_0400HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ui_ctm_0400HTMLAction 객체를 생성
	 */
	public EES_CTM_0400HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EquipmentMovementMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
    	EesCtm0400Event event = new EesCtm0400Event();
		if(command.isCommand(FormCommand.MULTI)) {
			event.setCtmMvmtStsVOS((CtmMvmtStsVO[])getVOs(request, CtmMvmtStsVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {

			event.setRCtmMvmtStsVO((RCtmMvmtStsVO)getVO(request, RCtmMvmtStsVO .class));
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