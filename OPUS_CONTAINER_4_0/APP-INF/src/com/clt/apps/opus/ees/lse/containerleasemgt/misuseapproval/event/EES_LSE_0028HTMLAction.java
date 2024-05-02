/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0028HTMLAction.java
*@FileTitle : Mis Use In & Out Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.14 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseApprovalVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseReqContainerVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseRequestVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.lse.containerleasemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerLeaseMgtSC로 실행요청<br>
 * - ContainerLeaseMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Jun-Woo
 * @see ContainerLeaseMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_LSE_0028HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0028HTMLAction 객체를 생성
	 */
	public EES_LSE_0028HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerLeaseMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesLse0028Event event = new EesLse0028Event();
		
		switch(command.getCommand()) {
			case FormCommand.SEARCH01 :	//조회 - 최대 승인번호
				event.setOfcCd(request.getParameter("ofc_cd"));
				break;
			case FormCommand.SEARCH02 :	//조회 - 요청번호 목록
				break;
			case FormCommand.SEARCH03 :	//조회 - 요청내역 정보	
			case FormCommand.SEARCH :	//조회 - 요청장비 목록
				event.setRqstNo(request.getParameter("rqst_no"));
				break;
			case FormCommand.MULTI :	//멀티
				event.setMisUseRequestVO((MisUseRequestVO)getVO(request, MisUseRequestVO .class));
				event.setMisUseApprovalVO((MisUseApprovalVO)getVO(request, MisUseApprovalVO .class));
				event.setMisUseReqContainerVOs((MisUseReqContainerVO[])getVOs(request, MisUseReqContainerVO.class, "sheet1_"));	
				break;
			default :	//do nothing
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