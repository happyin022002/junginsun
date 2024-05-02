/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0069HTMLAction.java
*@FileTitle : Pre Checking Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.23 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SpecialRequestVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.scg.cargoloadingapproval 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CargoLoadingApprovalSC로 실행요청<br>
 * - CargoLoadingApprovalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Hyun Uk
 * @see CargoLoadingApprovalEvent 참조
 * @since J2EE 1.6
 */

public class VOP_SCG_0069HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_SCG_0069HTMLAction 객체를 생성
	 */
	public VOP_SCG_0069HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CargoLoadingApprovalEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopScg0069Event event = new VopScg0069Event();
		

		if(command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH02) || command.isCommand(FormCommand.SEARCH03)|| command.isCommand(FormCommand.SEARCH05)) {
			event.setPreRestrictionInputVO((PreRestrictionInputVO)getVO(request, PreRestrictionInputVO .class));
			event.setPreRestrictionInputVOS((PreRestrictionInputVO[])getVOs(request, PreRestrictionInputVO .class));
		} else if(command.isCommand(FormCommand.MULTI)) {
			event.setSpecialRequestVO((SpecialRequestVO)getVO(request, SpecialRequestVO .class));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setScgPrnrAproRqstCgoVOS((ScgPrnrAproRqstCgoVO[])getVOs(request, ScgPrnrAproRqstCgoVO .class));
			event.setPreRestrictionInputVO((PreRestrictionInputVO)getVO(request, PreRestrictionInputVO .class));
			event.setPreRestrictionInputVOS((PreRestrictionInputVO[])getVOs(request, PreRestrictionInputVO .class));
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