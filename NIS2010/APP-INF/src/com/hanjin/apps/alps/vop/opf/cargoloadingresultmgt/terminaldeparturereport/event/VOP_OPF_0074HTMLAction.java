/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VOP_OPF_0074HTMLAction.java
*@FileTitle : VNOR Mail Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.21
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.OpfVnorEmlStupVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.aon.bkk.datatransfer 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DataTransferSC로 실행요청<br>
 * - DataTransferSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see DataTransferEvent 참조 
 * @since J2EE 1.6
 */
public class VOP_OPF_0074HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UserHTMLAction 객체를 생성
	 */
	public VOP_OPF_0074HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 UserManagementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		/**
         ibSheet 사용시 fromRequestGrid를 사용하는데
         prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 )
         String prefix = "" ;
         COM_USER com_user = COM_USER.fromRequestGrid(request, prefix);
        */
    	FormCommand command = FormCommand.fromRequest(request);

    	VopOpf0074Event event = new VopOpf0074Event();
    	
    	if (command.isCommand(FormCommand.MULTI)) {
			event.setOpfVnorEmlStupVOs((OpfVnorEmlStupVO[])getVOs(request, OpfVnorEmlStupVO.class, ""));
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