/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_2019HTMLAction.java
*@FileTitle : CBF Summary Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.27 우지석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFPartnerEDIVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFPartnerConditionVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgNonDgCgoKwVO;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.ScgRgnShpOprCdVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.vop.opf.cargoloadingplanmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CargoLoadingPlanMgtSC로 실행요청<br>
 * - CargoLoadingPlanMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Ji Seok Woo
 * @see CargoLoadingPlanMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_OPF_2024HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_OPF_2024HTMLAction 객체를 생성
	 */
	public VOP_OPF_2024HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CargoLoadingPlanMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	VopOpf2024Event event = new VopOpf2024Event();
		
   
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setCBFPartnerConditionVO((CBFPartnerConditionVO)getVO(request, CBFPartnerConditionVO .class));
		}
		
		else if(command.isCommand(FormCommand.COMMAND02) || command.isCommand(FormCommand.SEARCH02) || command.isCommand(FormCommand.SEARCH03) ) {
			event.setCBFPartnerEDIVO((CBFPartnerEDIVO)getVO(request, CBFPartnerEDIVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			event.setCBFPartnerEDIVOS((CBFPartnerEDIVO[])getVOs(request, CBFPartnerEDIVO .class,""));
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