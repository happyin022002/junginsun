/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SAQ_0077HTMLAction.java
*@FileTitle : Model Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 김종호
*@LastVersion : 1.1
* 2006-12-21 byyoo
* 1.0 최초 생성
* 2009.08.31 김종호
* 1.1 Creation (new F/W 전환작업)   
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.saq.monthlysalesquotamanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MonthlySalesQuotaManageSC로 실행요청<br>
 * - MonthlySalesQuotaManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jong-Ho Kim
 * @see MonthlySalesQuotaManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SAQ_0077HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SAQ_0077HTMLAction 객체를 생성
	 */
	public ESM_SAQ_0077HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MonthlySalesQuotaManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSaq0077Event event = new EsmSaq0077Event();
		
//		//vo 선언
//		QuotaConditionVO quotaConditionVO = new QuotaConditionVO();
//		//페이지 상단 혹은 내부에서 조건으로  받을 변수 선언
//    	String year = JSPUtil.getParameter(request, "year", "");
//    	String quarter = JSPUtil.getParameter(request, "bse_qtr_cd", "");
//    	String version = JSPUtil.getParameter(request, "version", "");
//    	String unit = JSPUtil.getParameter(request, "unit", "");
//    	//내부적으로 월계산에 사용될 변수
//		String repMonth = JSPUtil.getParameter(request, "repMonth", "");
//		//vo에 값 세팅
//    	quotaConditionVO.setYear(year);
//    	quotaConditionVO.setQuarter(quarter);
//    	quotaConditionVO.setVersion(version);
//    	quotaConditionVO.setUnit(unit);
//    	quotaConditionVO.setRepMonth(repMonth);
//		//event에 vo 세팅		
//    	event.setQuotaConditionVO(quotaConditionVO);
// 이러한 처리를 아래와 같이 한방에 할 수 있다. 		

		
		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST03)) {
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO.class));
		}
//		else if(command.isCommand(FormCommand.COMMAND01)) {
			// 기존 COMMAND코드의 경우 프로세스 끝에 그리드시트를 새로고침하도록 설정이 되어있기에  
			// 이를 MULTI코드로 바꿔서 업데이트 및 인서트 시 정상적인 처리가 되도록 변경.
		else if(command.isCommand(FormCommand.MULTI01)) {
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO.class));
		}
		else if(command.isCommand(FormCommand.MODIFY01)) {
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO.class));
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