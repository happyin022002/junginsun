/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7013HTMLAction.java
 *@FileTitle : EUR Add-on Guideline Creation / Amend – Load Excel
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.5.30
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.5.30 이은섭
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRDetailVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriTrfFdrRtVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.tariff 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TariffSC로 실행요청<br>
 * - TariffSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author LEE EUN SUP
 * @see EsmPri7013Event 참조
 * @since J2EE 1.6
 */
public class ESM_PRI_7013HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 7116963942112395646L;

	/**
	 * ESM_PRI_7013HTMLAction 객체를 생성
	 */
	public ESM_PRI_7013HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */

	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmPri7013Event event = new EsmPri7013Event();
		if (command.isCommand(FormCommand.MULTI)) {
			event.setFdrDetailVO((FDRDetailVO) getVO(request, FDRDetailVO.class));
			event.setPriTrfFdrRtVOs((PriTrfFdrRtVO[]) getVOs(request, PriTrfFdrRtVO.class));
		} else if (command.isCommand(FormCommand.SEARCH)) {
			// Validation 체크
			event.setPriTrfFdrRtVOs((PriTrfFdrRtVO[]) getVOs(request, PriTrfFdrRtVO.class));
		} else if (command.isCommand(FormCommand.SEARCH01)) {
			// Status 조회
			event.setFdrDetailVO((FDRDetailVO) getVO(request, FDRDetailVO.class));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			// LOCATION(POINT/BASE PORT) 체크
			event.setLocCd(JSPUtil.getParameter(request, "loc_cd"));
		} else if (command.isCommand(FormCommand.SEARCH03)) {
			// RHQ_CD 조회
			event.setFdrDetailVO((FDRDetailVO) getVO(request, FDRDetailVO.class));
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
