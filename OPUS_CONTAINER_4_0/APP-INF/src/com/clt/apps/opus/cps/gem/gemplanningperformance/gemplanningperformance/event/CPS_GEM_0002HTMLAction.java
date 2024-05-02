/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_GEM_0002HTMLAction.java
*@FileTitle : Processing Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.04.21 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemApprovalStepVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemItemVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.GemRequestVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.ItemVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningStatusCondVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningStatusVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchProcessingStatusVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * [CPS_GEM-0002] Processing Status
 * HTTP Parser<br> 
 * @author choijungmi
 * @see CpsGem0002Event 참조
 * @since J2EE 1.4
 */

public class CPS_GEM_0002HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GEM_0002HTMLAction 객체를 생성
	 */
	public CPS_GEM_0002HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>	
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		CpsGem0002Event event = new CpsGem0002Event();		
		// RequestNo 
		String genExpnRqstNo = JSPUtil.getParameter(request, "gen_expn_rqst_no" , "");
		event.setGenExpnRqstNo(genExpnRqstNo);
		// 오피스 정보 
		String ofcCd = JSPUtil.getParameter(request, "ofc_cd" , "");
		event.setOfcCd(ofcCd);
		//비용코드 
		String genExpnCd = JSPUtil.getParameter(request, "gen_expn_cd" , "");
		event.setGenExpnCd(genExpnCd);
		//예산 년도
		String plnYrmon = JSPUtil.getParameter(request, "pln_yrmon" , "");
		event.setPlnYrmon(plnYrmon);
		
		//[Retrieve]
		if(command.isCommand(FormCommand.SEARCHLIST)) {			
			PlanningStatusCondVO  planningStatusCondVO = 
				(PlanningStatusCondVO) getVO(request,
						PlanningStatusCondVO.class);			
			event.setPlanningStatusCondVO(planningStatusCondVO);
		}
		
		//[grid select]
		else if(command.isCommand(FormCommand.SEARCHLIST01)) {			
			SearchProcessingStatusVO searchProcessingStatusVO = 
				(SearchProcessingStatusVO) getVO(request,
						SearchProcessingStatusVO.class);			
			event.setSearchProcessingStatusVO(searchProcessingStatusVO);
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