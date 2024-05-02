/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonHTMLAction.java
*@FileTitle : PRICommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.04.16 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.MdmChargeVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.pricommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PRICommonSC로 실행요청<br>
 * - PRICommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Seung-Jun,Lee
 * @see RASCommonEvent 참조
 * @since J2EE 1.6
 */

public class RASCommonHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * PRICommonHTMLAction 객체를 생성
	 */
	public RASCommonHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PRICommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		RASCommonEvent event = new RASCommonEvent();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setRsltCdListVO((RsltCdListVO)getVO(request, RsltCdListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH20)) {
			event.setRsltCdListVO((RsltCdListVO)getVO(request, RsltCdListVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH19)) {
			event.setRsltCdListVO((RsltCdListVO)getVO(request, RsltCdListVO .class));
		}				
		else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setRsltCdListVO((RsltCdListVO)getVO(request, RsltCdListVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND02)) {
			event.setRsltCdListVO((RsltCdListVO)getVO(request, RsltCdListVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND03)) {
			event.setRsltCdListVO((RsltCdListVO)getVO(request, RsltCdListVO .class));
		}	
		else if(command.isCommand(FormCommand.COMMAND04)) {
			event.setRsltCdListVO((RsltCdListVO)getVO(request, RsltCdListVO .class));
		}		
		else if(command.isCommand(FormCommand.COMMAND05)) {
			event.setRsltCdListVO((RsltCdListVO)getVO(request, RsltCdListVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND40)) {
			event.setRsltCdListVO((RsltCdListVO)getVO(request, RsltCdListVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND13)) {
			event.setRsltCdListVO((RsltCdListVO)getVO(request, RsltCdListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST09)) {
            event.setMdmChargeVO((MdmChargeVO)getVO(request, MdmChargeVO.class));
        }
        else{
			event.setRsltCdListVO((RsltCdListVO)getVO(request, RsltCdListVO .class));
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