/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0648HTMLAction.java
*@FileTitle : BL Copy
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.08.20 이일민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyInVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.outboundblmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OutboundBLMgtSC로 실행요청<br>
 * - OutboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Ilmin Lee
 * @see OutboundBLMgtEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0648HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0648HTMLAction 객체를 생성
	 */
	public ESM_BKG_0648HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OutboundBLMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0648Event event = new EsmBkg0648Event();
		log.debug("::CALL::> ESM_BKG_0648HTMLAction - " + command.getCommand());
		if(command.isCommand(FormCommand.SEARCH)) {  //RETRIEVE
			event.setBkgNo(JSPUtil.getParameter(request, "s_bkg_no", ""));
		} else if(command.isCommand(FormCommand.MULTI01)) {  //COPY
			event.setBlCopyIns((BlCopyInVO[])getVOs(request, BlCopyInVO.class, ""));
			if(null!=event.getBlCopyIns() && 0<event.getBlCopyIns().length) {
				for (int i=0; i<event.getBlCopyIns().length; i++) {
					event.getBlCopyIns()[i].setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
					event.getBlCopyIns()[i].setCustFlg(JSPUtil.getParameter(request, "cust_flg", ""));
					event.getBlCopyIns()[i].setMarkFlg(JSPUtil.getParameter(request, "mark_flg", ""));
					event.getBlCopyIns()[i].setDescFlg(JSPUtil.getParameter(request, "desc_flg", ""));
					event.getBlCopyIns()[i].setBkgStatus(JSPUtil.getParameter(request, "bkgStatus", ""));
					event.getBlCopyIns()[i].setBdrFlg(JSPUtil.getParameter(request, "bdrFlg", ""));
					event.getBlCopyIns()[i].setShprCd(JSPUtil.getParameter(request, "shprCd", ""));
				}
			}
		}
		return event;
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
