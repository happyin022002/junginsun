/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0504HTMLAction.java
*@FileTitle : Port Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.05.26 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.PortInformationMgtVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortCnlPassCondVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDistVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortDocBufTmVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortNworkVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortTrspCondVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.nis2010.vop.vsk.vesseloperationsupportmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 VesselOperationSupportMgtSC로 실행요청<br>
 * - VesselOperationSupportMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Jong Ock
 * @see VesselOperationSupportMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_VSK_0506HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0504HTMLAction 객체를 생성
	 */
	public VOP_VSK_0506HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VesselOperationSupportMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0504Event event = new VopVsk0504Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setPortInformationMgtVOS((PortInformationMgtVO[])getVOs(request, PortInformationMgtVO .class,"t1sheet1_"));
		} 
		else if(command.isCommand(FormCommand.MULTI01)) {
			event.setVskPortNworkVOS((VskPortNworkVO[])getVOs(request, VskPortNworkVO .class,"t2sheet1_"));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setVskPortDistVOS((VskPortDistVO[])getVOs(request, VskPortDistVO .class,"t3sheet1_"));
		}
		else if(command.isCommand(FormCommand.MULTI03)) {
			event.setVskPortDocBufTmVOS((VskPortDocBufTmVO[])getVOs(request, VskPortDocBufTmVO .class,"t4sheet1_"));
		}
		else if(command.isCommand(FormCommand.MULTI04)) {
			event.setVskPortCnlPassCondVOS((VskPortCnlPassCondVO[])getVOs(request, VskPortCnlPassCondVO .class,"t5sheet1_"));
		}
		else if(command.isCommand(FormCommand.MULTI05)) {
			event.setVskPortTrspCondVOS((VskPortTrspCondVO[])getVOs(request, VskPortTrspCondVO .class,"t6sheet1_"));
		}
		else if(command.isCommand(FormCommand.MULTI06)) {
			event.setVskPortTrspCondVOS((VskPortTrspCondVO[])getVOs(request, VskPortTrspCondVO .class,"t7sheet1_"));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			//event.setPortInformationMgtVO((PortInformationMgtVO)getVO(request, PortInformationMgtVO .class));
			event.setPortInformationConditionVO((PortInformationConditionVO)getVO(request, PortInformationConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setPortInformationConditionVO((PortInformationConditionVO)getVO(request, PortInformationConditionVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setPortInformationConditionVO((PortInformationConditionVO)getVO(request, PortInformationConditionVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setPortInformationConditionVO((PortInformationConditionVO)getVO(request, PortInformationConditionVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setPortInformationConditionVO((PortInformationConditionVO)getVO(request, PortInformationConditionVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setPortInformationConditionVO((PortInformationConditionVO)getVO(request, PortInformationConditionVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setPortInformationConditionVO((PortInformationConditionVO)getVO(request, PortInformationConditionVO .class));
		}		
		else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setPortInformationConditionVO((PortInformationConditionVO)getVO(request, PortInformationConditionVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND02)) {
			event.setPortInformationConditionVO((PortInformationConditionVO)getVO(request, PortInformationConditionVO .class));			
		}
		else if(command.isCommand(FormCommand.COMMAND03)) {
			event.setPortInformationConditionVO((PortInformationConditionVO)getVO(request, PortInformationConditionVO .class));			
		}
		else if(command.isCommand(FormCommand.COMMAND04)) {
			event.setPortInformationConditionVO((PortInformationConditionVO)getVO(request, PortInformationConditionVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND05)) {
			event.setPortInformationConditionVO((PortInformationConditionVO)getVO(request, PortInformationConditionVO .class));				
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