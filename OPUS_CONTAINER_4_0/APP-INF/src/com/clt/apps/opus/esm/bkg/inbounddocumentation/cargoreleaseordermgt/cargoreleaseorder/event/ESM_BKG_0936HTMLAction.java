/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0936HTMLAction.java
*@FileTitle : D/O Revceiver ad Ultimate Consignee(Incl. House B/L No) Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.inboundnoticemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InboundBLMgtSC로 실행요청<br>
 * - InboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author
 * @see EsmBkg0936Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0936HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0936HTMLAction 객체를 생성
	 */
	public ESM_BKG_0936HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InboundNoticeMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0936Event event = new EsmBkg0936Event();
		if(command.isCommand(FormCommand.SEARCH)) {  // on load시 조회
			DoRcvrVO doRcvrVO = (DoRcvrVO)getVO(request, DoRcvrVO .class);
			if (doRcvrVO.getDoNo() != null && doRcvrVO.getDoNo().length() > 11) {
				doRcvrVO.setDoNoSplit(doRcvrVO.getDoNo().substring(10, 12));
				doRcvrVO.setDoNo(doRcvrVO.getDoNo().substring(0, 10));
			}
			
			if (doRcvrVO.getDoNoSplit() == null || doRcvrVO.getDoNoSplit().equals("")) {
				doRcvrVO.setDoNoSplit("00");
			}
			event.setDoRcvrVO(doRcvrVO);
			
		} else if(command.isCommand(FormCommand.MODIFY)) { // save 처리			
			DoRcvrVO doRcvrVO = (DoRcvrVO)getVO(request, DoRcvrVO .class);
			if (doRcvrVO.getDoNo() != null && doRcvrVO.getDoNo().length() > 11) {
				doRcvrVO.setDoNoSplit(doRcvrVO.getDoNo().substring(10, 12));
				doRcvrVO.setDoNo(doRcvrVO.getDoNo().substring(0, 10));
			}

			if (doRcvrVO.getDoNoSplit() == null || doRcvrVO.getDoNoSplit().equals("")) {
				doRcvrVO.setDoNoSplit("00");
			}
			
			event.setDoRcvrVO(doRcvrVO);
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