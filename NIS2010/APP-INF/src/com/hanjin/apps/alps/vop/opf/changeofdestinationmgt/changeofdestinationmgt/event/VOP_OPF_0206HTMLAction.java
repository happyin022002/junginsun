/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0206HTMLAction.java
*@FileTitle : COD Approval Detail at RSO Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.22 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodAuthVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.BkgCodCostListVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODNoticeVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ChangeOfDestinationMgtConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgCodCostVO;
import com.hanjin.syscommon.common.table.BkgCodVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.opf.changeofdestinationmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ChangeOfDestinationMgtSC로 실행요청<br>
 * - ChangeOfDestinationMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Jong Ock
 * @see ChangeOfDestinationMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_OPF_0206HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_OPF_0206HTMLAction 객체를 생성
	 */
	public VOP_OPF_0206HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ChangeOfDestinationMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopOpf0206Event event = new VopOpf0206Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setBkgCodCostVOS((BkgCodCostVO[])getVOs(request, BkgCodCostVO .class, "sheet3_"));
			event.setCodAuthVO((CodAuthVO)getVO(request, CodAuthVO .class));
			event.setCODNoticeVO((CODNoticeVO)getVO(request, CODNoticeVO .class));
		}
		else if(command.isCommand(FormCommand.MODIFY)) {
			event.setBkgCodVO((BkgCodVO)getVO(request, BkgCodVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setChangeOfDestinationMgtConditionVO((ChangeOfDestinationMgtConditionVO)getVO(request, ChangeOfDestinationMgtConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setChangeOfDestinationMgtConditionVO((ChangeOfDestinationMgtConditionVO)getVO(request, ChangeOfDestinationMgtConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setChangeOfDestinationMgtConditionVO((ChangeOfDestinationMgtConditionVO)getVO(request, ChangeOfDestinationMgtConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			//event.setChangeOfDestinationMgtConditionVO((ChangeOfDestinationMgtConditionVO)getVO(request, ChangeOfDestinationMgtConditionVO .class));
			event.setBkgCodCostListVO((BkgCodCostListVO)getVO(request, BkgCodCostListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setChangeOfDestinationMgtConditionVO((ChangeOfDestinationMgtConditionVO)getVO(request, ChangeOfDestinationMgtConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setChangeOfDestinationMgtConditionVO((ChangeOfDestinationMgtConditionVO)getVO(request, ChangeOfDestinationMgtConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setChangeOfDestinationMgtConditionVO((ChangeOfDestinationMgtConditionVO)getVO(request, ChangeOfDestinationMgtConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setChangeOfDestinationMgtConditionVO((ChangeOfDestinationMgtConditionVO)getVO(request, ChangeOfDestinationMgtConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setChangeOfDestinationMgtConditionVO((ChangeOfDestinationMgtConditionVO)getVO(request, ChangeOfDestinationMgtConditionVO .class));
		}	
		else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setChangeOfDestinationMgtConditionVO((ChangeOfDestinationMgtConditionVO)getVO(request, ChangeOfDestinationMgtConditionVO .class));
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