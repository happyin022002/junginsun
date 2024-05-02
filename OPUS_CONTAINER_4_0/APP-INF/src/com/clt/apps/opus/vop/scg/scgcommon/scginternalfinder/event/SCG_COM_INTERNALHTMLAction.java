/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCG_COM_INTERNALHTMLAction.java
*@FileTitle : SCG COMMON
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.02 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo.SearchUNNumberVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.ScgImdgClssCdVO;
import com.clt.syscommon.common.table.ScgImdgSpclProviVO;
import com.clt.syscommon.common.table.ScgImdgUnNoVO;
import com.clt.syscommon.common.table.ScgIrrTpCdVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.vop.scg.scgcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCGCommonSC로 실행요청<br>
 * - SCGCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Dohyoung Lee
 * @see SCGCommonEvent 참조
 * @since J2EE 1.6
 */

public class SCG_COM_INTERNALHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * SCG_COM_INTERNALHTMLAction 객체를 생성
	 */
	public SCG_COM_INTERNALHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCGCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		ScgComInternalEvent event = new ScgComInternalEvent();
		

		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setScgImdgUnNoVO((ScgImdgUnNoVO)getVO(request, ScgImdgUnNoVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setScgImdgClssCdVO((ScgImdgClssCdVO)getVO(request, ScgImdgClssCdVO .class));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setScgImdgSpclProviVO((ScgImdgSpclProviVO)getVO(request, ScgImdgSpclProviVO .class));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setScgIrrTpCdVO((ScgIrrTpCdVO)getVO(request, ScgIrrTpCdVO .class));
		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setSearchUNNumberVO( (SearchUNNumberVO)getVO(request, SearchUNNumberVO .class));
        }else if(command.isCommand(FormCommand.SEARCH06)) {
            event.setSearchUNNumberVO( (SearchUNNumberVO)getVO(request, SearchUNNumberVO .class));
        }else if(command.isCommand(FormCommand.SEARCH09)) {
            event.setScgImdgUnNoVO( (ScgImdgUnNoVO)getVO(request, ScgImdgUnNoVO .class));
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