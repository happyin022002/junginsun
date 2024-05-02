/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0028HTMLAction.java
*@FileTitle : Proposal & Amendment Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.08 변영주
* 1.0 Creation
=========================================================
* History
* 2011.03.29 김민아 [CHM-201109656-01] Scope별 Partial Accept All 기능 추가 - Ori/Dest , LOC Group, CMDT Group, Arbitrary, GOH 5개 Terms를 Scope별로 한번에 Quick Accept 가능하도록 기능 추가.
* 2011.05.11 김민아 [CHM-201110738-01] Quick Accept All 실행시 GOH Final Rate 데이터 copy 되도록 수정요청 : ARB Update 오류 - 파라미터 prop_sts_cd 추가
* 2013.01.15 이은섭 [CHM-201322418-01] SC fling cancel 기능 관련 변경 요청 
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpDlRecVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCProposalSC로 실행요청<br>
 * - SCProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Hyun Sung Gil
 * @see SCProposalEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_0028HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_0028HTMLAction 객체를 생성
	 */
	public ESM_PRI_0028HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri0028Event event = new EsmPri0028Event();
		
		if(command.isCommand(FormCommand.SEARCH)){ 
			event.setPriSpDlRecVo((PriSpDlRecVO)getVO(request, PriSpDlRecVO.class));
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