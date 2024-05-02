/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SAQ_0164HTMLAction.java
*@FileTitle : Quota Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier :  Choi.M.C
*@LastVersion : 1.0
* 2008-04-04 Y.S.CHOI (CSR No. N200804035819)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.SaqMonCfmTgtVvdVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.saq.monthlysalesquotamanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MonthlySalesQuotaManageSC로 실행요청<br>
 * - MonthlySalesQuotaManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author ChoiI.M.C
 * @see MonthlySalesQuotaManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SAQ_0164HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SAQ_0164HTMLAction 객체를 생성
	 */
	public ESM_SAQ_0164HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MonthlySalesQuotaManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSaq0164Event event = new EsmSaq0164Event();
		SaqMonCfmTgtVvdVO saqMonCfmTgtVvdVO = new SaqMonCfmTgtVvdVO();
		SaqMonCfmTgtVvdVO[] saqMonCfmTgtVvdVOs = null;
		
		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO .class));
		}else if(command.isCommand(FormCommand.MULTI)){
			
			event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO .class));
			saqMonCfmTgtVvdVOs = saqMonCfmTgtVvdVO.fromRequestGrid(request, event.getQuotaConditionVO());
			event.setSaqMonCfmTgtVvdVOs(saqMonCfmTgtVvdVOs);
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