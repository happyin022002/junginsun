/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_SAQ_0126HTMLAction.java
*@FileTitle      : Trade Group (Monthly Quota Inquiry)
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.saq.monthlysalesquotainquiry 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MonthlySalesQuotaInquirySC로 실행요청<br>
 * - MonthlySalesQuotaInquirySC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jong-Ho Kim
 * @see MonthlySalesQuotaInquiryEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SAQ_0126HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SAQ_0126HTMLAction 객체를 생성
	 */
	public ESM_SAQ_0126HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MonthlySalesQuotaInquiryEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSaq0126Event event = new EsmSaq0126Event();
		

		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			// event.setQuotaConditionVO((QuotaConditionVO)getVO(request, QuotaConditionVO.class));
			// 원래 위와 같이 사용하는 코드를 아래와 같이 사용함.
			// MonthlyQuotaInquiryDBDAO 에서 사용하는 quarter 값이 js 파일에서도 quarter로 사용되는데, 
			// 공용 조건VO에 이미 bse_qtr_cd 라는 이름으로 setQuarter 함수를 등록해놓았기 때문에 
			// 이를 사용하기 위해 VO에서 모든 정보를 가져온 뒤 setQuarter의 사용하는 값을 quarter로 재등록하는 작업이 필요했다.   
			QuotaConditionVO quotaConditionVO = (QuotaConditionVO)getVO(request, QuotaConditionVO.class);
			quotaConditionVO.setQuarter(JSPUtil.getParameter(request, "quarter"));
			quotaConditionVO.setOrgType("HO"); //기존 소스 BCImpl에서 조건 파라미터 중 orgType을 하드코딩으로 입력하였기에 다음과 같이 처리.
			event.setQuotaConditionVO(quotaConditionVO);
		}
		else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			QuotaConditionVO quotaConditionVO = (QuotaConditionVO)getVO(request, QuotaConditionVO.class);
			quotaConditionVO.setQuarter(JSPUtil.getParameter(request, "quarter"));
			quotaConditionVO.setOrgType("HO");
			event.setQuotaConditionVO(quotaConditionVO);
		}
		else if(command.isCommand(FormCommand.SEARCHLIST03)) {
			QuotaConditionVO quotaConditionVO = (QuotaConditionVO)getVO(request, QuotaConditionVO.class);
			quotaConditionVO.setQuarter(JSPUtil.getParameter(request, "quarter"));
			event.setQuotaConditionVO(quotaConditionVO);
		}
		else if(command.isCommand(FormCommand.SEARCHLIST13)) {
			QuotaConditionVO quotaConditionVO = (QuotaConditionVO)getVO(request, QuotaConditionVO.class);
			quotaConditionVO.setQuarter(JSPUtil.getParameter(request, "quarter"));
			event.setQuotaConditionVO(quotaConditionVO);
		}
		else if(command.isCommand(FormCommand.SEARCHLIST04)) {
			QuotaConditionVO quotaConditionVO = (QuotaConditionVO)getVO(request, QuotaConditionVO.class);
			quotaConditionVO.setQuarter(JSPUtil.getParameter(request, "quarter"));
			
			event.setQuotaConditionVO(quotaConditionVO);
		}
		else if(command.isCommand(FormCommand.SEARCHLIST05)) {
			QuotaConditionVO quotaConditionVO = (QuotaConditionVO)getVO(request, QuotaConditionVO.class);
			event.setQuotaConditionVO(quotaConditionVO);
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