/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MST_COMHTMLAction.java
*@FileTitle : MST COMMON PAGE
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.18 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.mstcommon.mstcommon.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.ComboInitDataINVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.AgmtInfoVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.CommonListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.mst.mstcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MSTCommonSC로 실행요청<br>
 * - MSTCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Ho Sun
 * @see MSTCommonEvent 참조
 * @since J2EE 1.6
 */ 

public class MST_COMHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * MST_COMHTMLAction 객체를 생성
	 */
	public MST_COMHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MSTCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		MstComEvent event = new MstComEvent();
		

		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setCommonListVO((CommonListVO)getVO(request, CommonListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setCommonListVO((CommonListVO)getVO(request, CommonListVO .class));
		} 
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setCommonListVO((CommonListVO)getVO(request, CommonListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setAgmtInfoVO((AgmtInfoVO)getVO(request, AgmtInfoVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setCommonListVO((CommonListVO)getVO(request, CommonListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setCommonListVO((CommonListVO)getVO(request, CommonListVO .class));			
		}
		else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setIntgCdId(request.getParameter("intgCdId"));
			event.setIntgCdVal(request.getParameter("intgCdVal"));
		}
		else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setComboInitDataINVOS((ComboInitDataINVO[])getVOs(request, ComboInitDataINVO .class,""));
		}
		else if(command.isCommand(FormCommand.COMMAND40)) {
			event.setInputUser(request.getParameter("input_user"));
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