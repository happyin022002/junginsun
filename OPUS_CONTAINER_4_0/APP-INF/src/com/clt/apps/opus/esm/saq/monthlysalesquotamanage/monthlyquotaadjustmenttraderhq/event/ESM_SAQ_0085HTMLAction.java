/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SAQ_0085HTMLAction.java
*@FileTitle : Regional Group Vs. Trade Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : ChoiI.M.C
*@LastVersion : 1.0
* 2007-02-23 byyoo
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.SaqMonQtaTrdVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.saq.monthlysalesquotamanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MonthlySalesQuotaManageSC로 실행요청<br>
 * - MonthlySalesQuotaManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author ChoiI.M.C
 * @see MonthlySalesQuotaManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SAQ_0085HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SAQ_0085HTMLAction 객체를 생성
	 */
	public ESM_SAQ_0085HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MonthlySalesQuotaManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSaq0085Event event = new EsmSaq0085Event();
		SaqMonQtaTrdVO saqMonQtaTrdVO = new SaqMonQtaTrdVO();
		SaqMonQtaTrdVO[] saqMonQtaTrdVOs = null;
		
		// LANE TAB 조회시..
		String ofcCd = JSPUtil.getParameter(request, "ctrt_rhq_cd", "");
		
		if (command.isCommand(FormCommand.SEARCHLIST)) {			// 하단 조정단 조회
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO .class));
		} else if (command.isCommand(FormCommand.SEARCHLIST04)) {	// 상단 Regional Group/Lane 탭 조회
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO .class));
			event.getQuotaConditionVO().setOfcCd(ofcCd);
		} else if (command.isCommand(FormCommand.MODIFY01)) {		// 하단 조정값 저장
		//COMMAND01 ->MODIFY01
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO .class));
			saqMonQtaTrdVOs = saqMonQtaTrdVO.fromRequestGrid(request, event.getQuotaConditionVO());
			event.setSaqMonQtaTrdVOs(saqMonQtaTrdVOs);
		} else if (command.isCommand(FormCommand.MODIFY02)) {		// Save As New Version 
		//COMMAND02 ->MODIFY02
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO .class));
			saqMonQtaTrdVOs = saqMonQtaTrdVO.fromRequestGrid(request, event.getQuotaConditionVO());
			event.setSaqMonQtaTrdVOs(saqMonQtaTrdVOs);
		} else if (command.isCommand(FormCommand.MODIFY03)) {		// Cancel Current Version (02 step)
		//COMMAND09 ->MODIFY03
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO .class));
		} else if (command.isCommand(FormCommand.MODIFY04)) {		// Confirm (02 step)
		//COMMAND11 ->MODIFY04
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO .class));
		} else if (command.isCommand(FormCommand.MODIFY05)) {		// Cancel Confirm (02 step)
		//COMMAND12 ->MODIFY05
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO .class));
		} else if (command.isCommand(FormCommand.MODIFY06)) {		// Final Confirm
		//COMMAND13 ->MODIFY06
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO .class));
		} else if (command.isCommand(FormCommand.MODIFY07)) {		// Notify (02 step)
		//COMMAND21 ->MODIFY07
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO .class));
		} else if (command.isCommand(FormCommand.MODIFY08)) {		// Cancel Notification (02 step)
		//COMMAND22 ->MODIFY08
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO .class));
		} else if (command.isCommand(FormCommand.MODIFY09)) {		// Check whether there are zero load
		//COMMAND30 ->MODIFY09
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO .class));
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