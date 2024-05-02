/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7021_01HTMLAction.java
 *@FileTitle : Cost Table Interface - Add-on Tariff  TAB
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.5.08
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.5.08 이은섭
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo.AddOnCostTraiffListVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.tariff 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TariffSC로 실행요청<br>
 * - TariffSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author LEE EUN SUP
 * @see EsmPri702101Event 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_7021_01HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 7116963942112395646L;

	/**
	 * ESM_PRI_7021_01HTMLAction 객체를 생성
	 */
	public ESM_PRI_7021_01HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmPri702101Event event = new EsmPri702101Event();
		if (command.isCommand(FormCommand.SEARCHLIST)) {
			event.setSvcScpCd(JSPUtil.getParameter(request, "svcScpCd"));
			event.setRhq_cd(JSPUtil.getParameter(request, "rhq_cd"));
			event.setOrg_dest_tp_cd(JSPUtil.getParameter(request, "org_dest_tp_cd"));
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setAddOnCostTraiffListVOs((AddOnCostTraiffListVO[]) getVOs(request, AddOnCostTraiffListVO.class, "sheet2_"));
		}
		return event;
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
