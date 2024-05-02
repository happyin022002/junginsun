/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EMS_PRI_2053HTMLAction.java
 *@FileTitle : RFA Proposal Creation - Arbitrary[Load Excel](Add On Tariff Management)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.09.26
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltPriRpScpArbKeyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltPriRpScpTrspAddChgVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriRpScpTrspAddChgVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.rfaguideline 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RFAGuidelineSC로 실행요청<br>
 * - RFAGuidelineSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author LEE EUN SUP
 * @see RFAGuidelineEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_2053HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_PRI_2053HTMLAction 객체를 생성
	 */
	public ESM_PRI_2053HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RFAGuidelineEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmPri2053Event event = new EsmPri2053Event();

		if (command.isCommand(FormCommand.MULTI)) {
			event.setPriRpScpTrspAddChgVOs((PriRpScpTrspAddChgVO[]) getVOs(request, PriRpScpTrspAddChgVO.class, ""));
		} else if (command.isCommand(FormCommand.MULTI02)) {
			event.setRsltPriRpScpTrspAddChgVOs((RsltPriRpScpTrspAddChgVO[]) getVOs(request, RsltPriRpScpTrspAddChgVO.class, ""));
		} else {
			event.setRsltPriRpScpArbKeyVO((RsltPriRpScpArbKeyVO) getVO(request, RsltPriRpScpArbKeyVO.class));
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