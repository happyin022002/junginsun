/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SAQ_0052HTMLAction.java
*@FileTitle : Confirmation and Distribution
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.28 주선영
* 1.0 Creation
* 2010.05.15 Lee Sang-Yong : 아키텍쳐위배사항 수정 COMMAND0X -> MULTI0X 변경
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.SaqMonQtaRlseTrdVO;
import com.clt.syscommon.common.table.SaqMonQtaRlseVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.saq.monthlysalesquotamanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MonthlySalesQuotaManageSC로 실행요청<br>
 * - MonthlySalesQuotaManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Ju Sun Young
 * @see MonthlySalesQuotaManageEvent 참조 
 * @since J2EE 1.6
 */

public class ESM_SAQ_0052HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SAQ_0052HTMLAction 객체를 생성
	 */
	public ESM_SAQ_0052HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MonthlySalesQuotaManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsmSaq0052Event event = new EsmSaq0052Event();
		
	   	String year = JSPUtil.getParameter(request, "year", "");
    	String quarter = JSPUtil.getParameter(request, "quarter", "");
     	String mqtaRlseVerNo = JSPUtil.getParameter(request, "mqta_rlse_ver_no", "");
     	String isNewVersion = JSPUtil.getParameter(request, "is_new_version", "");
     	 
		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO.class));
			event.getQuotaConditionVO().setQuarter(quarter);
		}else if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO.class));
			event.getQuotaConditionVO().setQuarter(quarter);
	    	event.setMqtaRlseVerNo(mqtaRlseVerNo);
	    	event.setIsNewVersion(isNewVersion);
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO.class));
			event.getQuotaConditionVO().setQuarter(quarter);
		}else if(command.isCommand(FormCommand.MULTI02)) {
			event.setSaqMonQtaRlseVO((SaqMonQtaRlseVO)getVO(request, SaqMonQtaRlseVO.class));
			event.setSaqMonQtaRlseTrdVOs((SaqMonQtaRlseTrdVO[])getVOs(request, SaqMonQtaRlseTrdVO.class,""));
	    	event.setYear(year);
	    	event.setQuarter(quarter);
	    	event.setMqtaRlseVerNo(mqtaRlseVerNo);
	    	event.setIsNewVersion(isNewVersion);
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