/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_018HTMLAction.java
*@FileTitle : Brokerage AP Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-22
*@LastModifier : Jung-Hyung, Kim
*@LastVersion : 1.0
* 2007-01-22 Jung-Hyung, Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceDetailForBRKGVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceMasterForBRKGVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoForPrint2VO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoForPrintVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoListForPrintVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.esm.agt.agtaudit 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AGTAuditSC로 실행요청<br>
 * - AGTAuditSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Junghyung_kim
 * @see EsmAgt0018Event , ESM_AGT_018EventResponse 참조
 * @since J2EE 1.4
 */
public class ESM_AGT_0018HTMLAction extends HTMLActionSupport {


	private static final long serialVersionUID = 1L;
	/**
	 * ESMAGT0018HTMLAction 객체를 생성
	 */
	public ESM_AGT_0018HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AGTAuditEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsmAgt0018Event event = new EsmAgt0018Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setAPActualInterfaceMasterForBRKGVO((APActualInterfaceMasterForBRKGVO)getVO(request, APActualInterfaceMasterForBRKGVO .class));
		}
		
		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setAPActualInterfaceDetailForBRKGVO((APActualInterfaceDetailForBRKGVO)getVO(request, APActualInterfaceDetailForBRKGVO .class));
		}
		
		if(command.isCommand(FormCommand.MULTI01)){
			event.setAPActualInterfaceMasterForBRKGVO((APActualInterfaceMasterForBRKGVO)getVO(request, APActualInterfaceMasterForBRKGVO .class));
			event.setAPActualInterfaceMasterForBRKGVOs((APActualInterfaceMasterForBRKGVO[])getVOs(request, APActualInterfaceMasterForBRKGVO .class, ""));
		}

		if(command.isCommand(FormCommand.MULTI02)){
			event.setAPActualInterfaceMasterForBRKGVO((APActualInterfaceMasterForBRKGVO)getVO(request, APActualInterfaceMasterForBRKGVO .class));
			event.setAPActualInterfaceMasterForBRKGVOs((APActualInterfaceMasterForBRKGVO[])getVOs(request, APActualInterfaceMasterForBRKGVO .class, ""));
		}
		
		if(command.isCommand(FormCommand.PRINT)){
			event.setBrkgInfoForPrintVO((BRKGInfoForPrintVO)getVO(request, BRKGInfoForPrintVO.class));
			event.setBrkgInfoForPrint2VO((BRKGInfoForPrint2VO)getVO(request, BRKGInfoForPrint2VO.class));
		}
		
		if(command.isCommand(FormCommand.SEARCH01)){
			event.setBrkgInfoListForPrintVO((BRKGInfoListForPrintVO)getVO(request, BRKGInfoListForPrintVO .class));
		}

		if(command.isCommand(FormCommand.SEARCH02)){
			event.setAPActualInterfaceVO((APActualInterfaceVO)getVO(request, APActualInterfaceVO .class));
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