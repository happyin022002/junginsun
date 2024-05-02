/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_pri_0010HTMLAction.java
*@FileTitle : Standard Note Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.17 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.vo.StndNoteGlineVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriSgStndNoteHdrVO;
import com.hanjin.syscommon.common.table.PriSgStndNoteVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scguideline 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCGuidelineSC로 실행요청<br>
 * - SCGuidelineSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Seung Jun Lee
 * @see SCGuidelineEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_0010HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ui_pri_0010HTMLAction 객체를 생성
	 */
	public ESM_PRI_0010HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCGuidelineEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri0010Event event = new EsmPri0010Event();
		
		StndNoteGlineVO stndNoteGlineVO = new StndNoteGlineVO();
		
		event.setStndnoteglinevo(stndNoteGlineVO) ;
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			
			event.setPriSgStndNoteHdrVO((PriSgStndNoteHdrVO)getVO(request, PriSgStndNoteHdrVO .class));
			event.getStndnoteglinevo().setSearchGubun("1");
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setPriSgStndNoteVO((PriSgStndNoteVO)getVO(request, PriSgStndNoteVO .class));
			event.getStndnoteglinevo().setSearchGubun("2");
//			log.debug("#######################################################");
//			log.debug(event.getStndnoteglinevo().getSearchGubun());
//			log.debug("#######################################################");
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setPriSgStndNoteVO((PriSgStndNoteVO)getVO(request, PriSgStndNoteVO .class));
			event.getStndnoteglinevo().setSearchGubun("3");
//			log.debug("****************************setPriSgStndNoteVO*****************************");
//			log.debug(event.getPriSgStndNoteVO().getNoteSeq());
//			log.debug("******************************setPriSgStndNoteVO***************************");
//			
//			log.debug("*********************************************************");
//			log.debug(event.getStndnoteglinevo().getSearchGubun());
//			log.debug("*********************************************************");
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setPriSgStndNoteVO((PriSgStndNoteVO)getVO(request, PriSgStndNoteVO .class));
			event.getStndnoteglinevo().setSearchGubun("4");
//			log.debug("*********************************************************");
//			log.debug("searchGubun dddddddddd: " + event.getStndnoteglinevo().getSearchGubun());
//			log.debug("*********************************************************");
		}
		
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setPriSgStndNoteHdrVO((PriSgStndNoteHdrVO)getVO(request, PriSgStndNoteHdrVO .class));
			event.getStndnoteglinevo().setSearchGubun("5");
//			log.debug("*********************************************************");
//			log.debug("searchGubun dddddddddd: " + event.getStndnoteglinevo().getSearchGubun());
//			log.debug("*********************************************************");
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