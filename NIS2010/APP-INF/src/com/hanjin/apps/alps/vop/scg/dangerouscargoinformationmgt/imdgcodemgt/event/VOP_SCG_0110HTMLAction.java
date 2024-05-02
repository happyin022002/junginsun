/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0110HTMLAction.java
*@FileTitle : Packing Instruction Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2009.07.27 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.component.util.JSPUtil;

import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DangerousCargoInformationMgtSC로 실행요청<br>
 * - DangerousCargoInformationMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Hyun Uk
 * @see DangerousCargoInformationMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_SCG_0110HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_SCG_0072HTMLAction 객체를 생성
	 */
	public VOP_SCG_0110HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DangerousCargoInformationMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopScg0110Event event = new VopScg0110Event();
		

		if(command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH02) || command.isCommand(FormCommand.SEARCH03)) {
			event.setPreRestrictionInputVO((PreRestrictionInputVO)getVO(request, PreRestrictionInputVO .class));
			event.setPreRestrictionInputVOS((PreRestrictionInputVO[])getVOs(request, PreRestrictionInputVO .class));
		}else if(command.isCommand(FormCommand.SEARCH)) {
            
            String imdgPckTpCd = JSPUtil.getParameter(request, "imdg_pck_tp_cd");
            String imdgPckCd   = JSPUtil.getParameter(request, "imdg_pck_cd");
                                    
            event.setImdgPckTpCd(imdgPckTpCd);
            event.setImdgPckCd(imdgPckCd);
                        
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