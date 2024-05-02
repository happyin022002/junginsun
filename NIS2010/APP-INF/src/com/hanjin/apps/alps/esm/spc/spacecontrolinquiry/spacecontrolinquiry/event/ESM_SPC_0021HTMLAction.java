/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0021HTMLAction.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.10 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

//import com.hanjin.syscommon.common.table.SPC_ALOC_CTRL_OPT;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021SusrLaneViewListVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.spacecontrolinquiry 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SpacecontrolinquirySC로 실행요청<br>
 * - SpacecontrolinquirySC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Sang Hoon
 * @see SpacecontrolinquiryEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SPC_0021HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SPC_0021HTMLAction 객체를 생성
	 */
	public ESM_SPC_0021HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SpacecontrolinquiryEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSpc0021Event event = new EsmSpc0021Event();
		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setSearchSpaceControlInquiryConditionVO((SearchSpaceControlInquiryConditionVO)getVO(request, SearchSpaceControlInquiryConditionVO .class));
		}else if(command.isCommand(FormCommand.SEARCHLIST03)) {
			event.setSearchSpaceControlInquiryConditionVO((SearchSpaceControlInquiryConditionVO)getVO(request, SearchSpaceControlInquiryConditionVO .class));
		}else if(command.isCommand(FormCommand.SEARCHLIST05)) {
			event.setSearchSpaceControlInquiryConditionVO((SearchSpaceControlInquiryConditionVO)getVO(request, SearchSpaceControlInquiryConditionVO .class));
		}else if(command.isCommand(FormCommand.SEARCHLIST10)) {	// 20120614 SHKIM
			event.setSearchSpaceControlInquiryConditionVO((SearchSpaceControlInquiryConditionVO)getVO(request, SearchSpaceControlInquiryConditionVO .class));
		}else if(command.isCommand(FormCommand.SEARCHLIST11)) {
			event.setSearchSpaceControlInquiryConditionVO((SearchSpaceControlInquiryConditionVO)getVO(request, SearchSpaceControlInquiryConditionVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {	// 2012.01.19 SHKIM
			event.setSearchSpaceControlInquiry021SusrLaneViewListVO((SearchSpaceControlInquiry021SusrLaneViewListVO)getVO(request, SearchSpaceControlInquiry021SusrLaneViewListVO .class));
		}else if(command.isCommand(FormCommand.SEARCHLIST09)) {	// 2012.01.19 SHKIM
			event.setSearchSpaceControlInquiry021SusrLaneViewListVO((SearchSpaceControlInquiry021SusrLaneViewListVO)getVO(request, SearchSpaceControlInquiry021SusrLaneViewListVO .class));
		}else if(command.isCommand(FormCommand.SEARCHLIST12)) {
	    	event.setSearchSpaceControlInquiryConditionVO((SearchSpaceControlInquiryConditionVO)getVO(request, SearchSpaceControlInquiryConditionVO .class));
	    }else if(command.isCommand(FormCommand.SEARCHLIST13)) {
	    	event.setSearchSpaceControlInquiryConditionVO((SearchSpaceControlInquiryConditionVO)getVO(request, SearchSpaceControlInquiryConditionVO .class));
	    }else if(command.isCommand(FormCommand.SEARCHLIST14)) {
	    	event.setSearchSpaceControlInquiryConditionVO((SearchSpaceControlInquiryConditionVO)getVO(request, SearchSpaceControlInquiryConditionVO .class));
	    }else if(command.isCommand(FormCommand.SEARCHLIST15)) {
	    	event.setSearchSpaceControlInquiryConditionVO((SearchSpaceControlInquiryConditionVO)getVO(request, SearchSpaceControlInquiryConditionVO .class));
	    }else if(command.isCommand(FormCommand.SEARCHLIST16)) {
	    	event.setSearchSpaceControlInquiryConditionVO((SearchSpaceControlInquiryConditionVO)getVO(request, SearchSpaceControlInquiryConditionVO .class));
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