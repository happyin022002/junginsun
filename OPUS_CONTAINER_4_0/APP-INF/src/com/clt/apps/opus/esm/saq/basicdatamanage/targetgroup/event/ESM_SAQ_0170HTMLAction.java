/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_SAQ_0170HTMLAction.java
*@FileTitle      : Year/Month Set for Cost Management
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchCostManagement0170ListVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.SaqCostApplBseVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.saq.basicdatamanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BasicDataManageSC로 실행요청<br>
 * - BasicDataManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jong-Ho Kim
 * @see BasicDataManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SAQ_0170HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SAQ_0170HTMLAction 객체를 생성
	 */
	public ESM_SAQ_0170HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BasicDataManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		SaqCostApplBseVO saqCostApplBseVO = new SaqCostApplBseVO();
		SaqCostApplBseVO[] saqCostApplBseVOs = null;
		
		
		// 4개 미만 의 검색조건  Event에 Setting하기.
		String bseYr     = JSPUtil.getParameter(request, "bse_yr", "");
		String bseQtrCd = JSPUtil.getParameter(request, "bse_qtr_cd",	"");

		EsmSaq0170Event event = new EsmSaq0170Event(bseYr, bseQtrCd);
		
		
		if(command.isCommand(FormCommand.MULTI01)) {			
// 
//이걸 		event.setSaqCostApplBseVOS((SaqCostApplBseVO[])getVOs(request, SaqCostApplBseVO .class,""));
//			아래 두줄처럼 변경
			saqCostApplBseVOs = saqCostApplBseVO.fromRequestGrid(request,  bseYr, bseQtrCd);
			event.setSaqCostApplBseVOS(saqCostApplBseVOs);
		}
		else if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setSearchCostManagementListVO((SearchCostManagement0170ListVO)getVO(request, SearchCostManagement0170ListVO .class));
		}
		
		else if(command.isCommand(FormCommand.MULTI02)) {
//			event.setSaqCostApplBseCopyVOS((SaqCostApplBseVO[])getVOs(request, SaqCostApplBseVO .class,""));
			saqCostApplBseVOs = saqCostApplBseVO.fromRequestGrid(request,  bseYr, bseQtrCd);
			event.setSaqCostApplBseCopyVOS(saqCostApplBseVOs);
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