/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0107HTMLAction.java
*@FileTitle :JO Settlement Status Information
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.29 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.StlStsVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

 

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 JointOperationMasterDataMgtSC 실행요청<br>
 * - JointOperationMasterDataMgtSC View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author JungHo Min
 * @see JointOperationMasterDataMgt Event 참조
 * @since J2EE 1.6
 */

public class FNS_JOO_0107HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_JOO_0103HTMLAction 객체를 생성
	 */
	public FNS_JOO_0107HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 JointOperationAgreementSettlementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsJoo0107Event event = new FnsJoo0107Event();
						
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setStlStsVO((StlStsVO)getVO(request, StlStsVO .class));
//		} else if(command.isCommand(FormCommand.COMMAND21)) {
//			if(request.getParameter("in_vsl_cd") != null) event.setIn_vsl_cd(JSPUtil.getNull(request.getParameter("in_vsl_cd")));
//			if(request.getParameter("in_skd_voy_no") != null) event.setIn_skd_voy_no(JSPUtil.getNull(request.getParameter("in_skd_voy_no")));
//			if(request.getParameter("in_skd_dir_cd") != null) event.setIn_skd_dir_cd(JSPUtil.getNull(request.getParameter("in_skd_dir_cd")));
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