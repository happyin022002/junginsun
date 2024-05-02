/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_025HTMLAction.java
*@FileTitle : Freight Forwarder VS Vendor Matching Info for Brokerage
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : Junghyung_kim
*@LastVersion : 1.0
* 2006-11-22 Junghyung_kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.event;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.agt.agtmaster.agtofficeinfo.event.EsmAgt0022Event;
import com.hanjin.apps.alps.esm.agt.common.Utils;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.AgtBrogCustMtchVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.esm.agt.agtmaster 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AGTMasterSC로 실행요청<br>
 * - AGTMasterSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Junghyung_kim
 * @see EsmAgt0025Event , ESM_AGT_025EventResponse 참조
 * @since J2EE 1.4
 */
public class ESM_AGT_0025HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_AGT_025HTMLAction 객체를 생성
	 */
	public ESM_AGT_0025HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESM_AGT_025Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmAgt0025Event event = new EsmAgt0025Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setAgtBrogCustMtchVO((AgtBrogCustMtchVO)getVO(request, AgtBrogCustMtchVO.class));
		}
		if(command.isCommand(FormCommand.MULTI)){
			event.setAgtBrogCustMtchVOs((AgtBrogCustMtchVO[])getVOs(request, AgtBrogCustMtchVO .class,""));
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