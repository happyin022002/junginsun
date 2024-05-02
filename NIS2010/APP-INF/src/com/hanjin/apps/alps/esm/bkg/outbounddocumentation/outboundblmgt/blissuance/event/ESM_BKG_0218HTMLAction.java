/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0218HTMLAction.java
*@FileTitle : Draft B/L & Waybill (Fax / E-Mail)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : Ilmin Lee
*@LastVersion : 1.0
* 2009.09.07 Ilmin Lee
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.InDblWblInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ObDblWblInVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.outboundblmgtsc 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OutboundBLMgtSCSC로 실행요청<br>
 * - OutboundBLMgtSCSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Ilmin Lee
 * @see OutboundBLMgtSCEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0218HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0218HTMLAction 객체를 생성
	 */
	public ESM_BKG_0218HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OutboundBLMgtSCEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0218Event event = new EsmBkg0218Event();
		log.debug("::CALL::> ESM_BKG_0218HTMLAction - " + command.getCommand());
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setObDblWblInVO((ObDblWblInVO)getVO(request, ObDblWblInVO .class));
		} else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setInDblWblInVO((InDblWblInVO)getVO(request, InDblWblInVO .class));
		} else if(command.isCommand(FormCommand.MULTI01)) {  //outbound-fax
			event.setDblWblVOs((DblWblVO[])getVOs(request, DblWblVO .class, "t1sheet1"));
		} else if(command.isCommand(FormCommand.MULTI02)) {  //outbound-email
			event.setDblWblVOs((DblWblVO[])getVOs(request, DblWblVO .class, "t1sheet1"));
		} else if(command.isCommand(FormCommand.MULTI03)) {  //outbound-groupemail
			event.setBkgEmlEdtVO((BkgEmlEdtVO)getVO(request, BkgEmlEdtVO.class));
			event.setDblWblVOs((DblWblVO[])getVOs(request, DblWblVO .class, "t1sheet1"));
		} else if(command.isCommand(FormCommand.MULTI04)) {  //outbound-email(S/R)
			event.setDblWblVOs((DblWblVO[])getVOs(request, DblWblVO .class, "t1sheet1"));
		} else if(command.isCommand(FormCommand.MULTI05)) {  //outbound-email(E/Q)
			event.setDblWblVOs((DblWblVO[])getVOs(request, DblWblVO .class, "t1sheet1"));
		} else if(command.isCommand(FormCommand.MULTI11)) {  //inbound-fax
			event.setDblWblVOs((DblWblVO[])getVOs(request, DblWblVO .class, "t2sheet1"));
		} else if(command.isCommand(FormCommand.MULTI12)) {  //inbound-email
			event.setDblWblVOs((DblWblVO[])getVOs(request, DblWblVO .class, "t2sheet1"));
		} else if(command.isCommand(FormCommand.MULTI13)) {  //inbound-groupemail
			event.setBkgEmlEdtVO((BkgEmlEdtVO)getVO(request, BkgEmlEdtVO.class));
			event.setDblWblVOs((DblWblVO[])getVOs(request, DblWblVO .class, "t2sheet1"));
		} else if(command.isCommand(FormCommand.SEARCH03)) {  //assign email
			event.setAttribute("bkgNos", new ArrayList<String>(Arrays.asList(JSPUtil.getParameter(request,"bkg_no").split("\\|"))));
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
