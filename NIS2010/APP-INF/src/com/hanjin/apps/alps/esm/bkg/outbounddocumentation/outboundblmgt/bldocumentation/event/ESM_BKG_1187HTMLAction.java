/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 		: ESM_BKG_1187HTMLAction.java
*@FileTitle 	: VERMAS Transmit to Terminal
*Open Issues 	:
*Change history :
*
*@LastModifyDate : 2016.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgListForTmlVermasEdiInputVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.repoplanmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RepoPlanManageSC로 실행요청<br>
 * - RepoPlanManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see RepoPlanManageEvent 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_1187HTMLAction extends HTMLActionSupport {
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * ESM_BKG_1187HTMLAction 객체를 생성
	 */
	public ESM_BKG_1187HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RepoPlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1187Event event = new EsmBkg1187Event();

		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setBkgListForTmlVermasEdiInputVO((BkgListForTmlVermasEdiInputVO)getVO(request, BkgListForTmlVermasEdiInputVO .class));
		} else if(command.isCommand(FormCommand.MULTI)){
        	event.setTypeGbn(JSPUtil.getParameter(request, "type_gbn"));
        	event.setBracCd(JSPUtil.getParameter(request, "brac_cd"));
			event.setBkgBlNoVOs((BkgBlNoVO[])getVOs(request, BkgBlNoVO .class,"sheet1_"));
			event.setCustTpIdVOs((CustTpIdVO[])getVOs(request, CustTpIdVO .class,"sheet1_"));
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