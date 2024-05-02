/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1059HTMLAction.java
*@FileTitle : Pick up No. Notice Manual Send
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.11.26 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSendListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InboundBLMgtSC로 실행요청<br>
 * - InboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Park Mi Ok
 * @see InboundBLMgtSCEvent 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_1066HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_1059HTMLAction 객체를 생성
	 */
	public ESM_BKG_1066HTMLAction() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InboundBLMgtSCEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1066Event event = new EsmBkg1066Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setPkupNtcSendListVOs((PkupNtcSendListVO[])getVOs(request, PkupNtcSendListVO.class, "sheet1_"));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
		    event.setPkupNtcSearchVO((PkupNtcSearchVO)getVO(request, PkupNtcSearchVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI01) || // Fax
				command.isCommand(FormCommand.MULTI02) || // Email
				command.isCommand(FormCommand.MULTI11) || // Stop
				command.isCommand(FormCommand.MULTI12) // Resume
				) 
		{ 
			event.setPkupNtcSendListVOs((PkupNtcSendListVO[])getVOs(request, PkupNtcSendListVO.class, "sheet1_"));
		}
		else if(command.isCommand(FormCommand.MULTI20)) { // Verify
			event.setPkupNtcSendListVOs((PkupNtcSendListVO[])getVOs(request, PkupNtcSendListVO.class, "sheet1_"));
		}

		request.setAttribute("Event", event);

		return  event;
	}
}
