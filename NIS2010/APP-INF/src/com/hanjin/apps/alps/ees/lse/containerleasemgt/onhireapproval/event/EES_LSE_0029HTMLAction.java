/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0029HTMLAction.java
*@FileTitle : On Hire Approval creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.09 진준성
* 1.0 Creation
* *******************************************************************
* 2013.08.13 채창호 [CHM-201325598]Split 02-EQR T/F 관련 LEGACY 연계 방안 및 일정
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalVO;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.lse.containerleasemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerLeaseMgtSC로 실행요청<br>
 * - ContainerLeaseMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jin Jun Sung
 * @see ContainerLeaseMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_LSE_0029HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0029HTMLAction 객체를 생성
	 */
	public EES_LSE_0029HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerLeaseMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesLse0029Event event = new EesLse0029Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
		 	
		 	String strLocCd     = request.getParameter("loc_cd");		 	
		 	String strLstmCd    = request.getParameter("combo1");
		 	String strPkupDueDt = request.getParameter("pkup_due_dt");
		 	String strAproRmk   = request.getParameter("apro_rmk");
		 	String strTpszCd    = request.getParameter("tpsz_cd");
		 	String reqno        = request.getParameter("reqno");
		 	
		 	event.setLocCd(strLocCd);    
		 	event.setLeaseTerm(strLstmCd);
		 	event.setPkupDueDt(strPkupDueDt);
		 	event.setAproRmk(strAproRmk);
		 	event.setTpszCd(strTpszCd);
		 	event.setReqno(reqno);
		 	
		 	event.setOnhireApprovalVOs((OnhireApprovalVO[])getVOs(request, OnhireApprovalVO.class,""));
			
		}else {
			
		 	event.setOnhireApprovalVO((OnhireApprovalVO)getVO(request, OnhireApprovalVO.class));	
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