/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SAQ_0148HTMLAction.java
*@FileTitle : Monthly Sales Quota Adjustment Trade Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 최민철
*@LastVersion : 1.0
* 2009.08.17 최민철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
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
 * @author Choi.M.C
 * @see MonthlySalesQuotaManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SAQ_0148HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SAQ_0148HTMLAction 객체를 생성
	 */
	public ESM_SAQ_0148HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MonthlySalesQuotaManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSaq0148Event event = new EsmSaq0148Event();
		SaqMonQtaTrdVO saqMonQtaTrdVO = new SaqMonQtaTrdVO();
		SaqMonQtaTrdVO[] saqMonQtaTrdVOs = null;
		
		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO .class));
		}else if(command.isCommand(FormCommand.MULTI)){

			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO .class));
			saqMonQtaTrdVOs = saqMonQtaTrdVO.fromRequestGrid(request, event.getQuotaConditionVO(), "0148");
			event.setSaqMonQtaTrdVOs(saqMonQtaTrdVOs);
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