/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_4005HTMLAction.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.21
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2009.05.06 전윤주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.vo.NoteConversionGroupLocationVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriNoteConvGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriNoteConvGrpLocVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.surcharge 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SurchargeSC로 실행요청<br>
 * - SurchargeSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Seung Jun Lee
 * @see SurchargeEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_4005HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_4005HTMLAction 객체를 생성
	 */
	public ESM_PRI_4005HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SurchargeEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri4005Event event = new EsmPri4005Event();
		
		NoteConversionGroupLocationVO noteConversionGroupLocationVO = new NoteConversionGroupLocationVO();
		event.setNoteConversionGroupLocationVO(noteConversionGroupLocationVO) ;
		
		if(command.isCommand(FormCommand.MULTI01)) {
			event.getNoteConversionGroupLocationVO().setPriNoteConvGrpLocVOs((PriNoteConvGrpLocVO[])getVOs(request, PriNoteConvGrpLocVO .class,"sheet1_"));
			event.getNoteConversionGroupLocationVO().setPriNoteConvGrpLocDtlVOs((PriNoteConvGrpLocDtlVO[])getVOs(request, PriNoteConvGrpLocDtlVO .class,"sheet2_"));
		/*	
			log.debug("====================================================");
			log.debug("priScgGrpLocDtlVOs[i].getEffDt : " +event.getNoteConversionGroupLocationVO().getPriNoteConvGrpLocDtlVOs()[0].getEffDt());
			log.debug("priScgGrpLocDtlVOs[i].getExpDt : " +event.getNoteConversionGroupLocationVO().getPriNoteConvGrpLocDtlVOs()[0].getExpDt());
			log.debug("====================================================");		
		*/	
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.getNoteConversionGroupLocationVO().setSearchGubun("1");
			event.getNoteConversionGroupLocationVO().setPriNoteConvGrpLocVO((PriNoteConvGrpLocVO)getVO(request, PriNoteConvGrpLocVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.getNoteConversionGroupLocationVO().setSearchGubun("2");
			event.getNoteConversionGroupLocationVO().setPriNoteConvGrpLocDtlVO((PriNoteConvGrpLocDtlVO)getVO(request, PriNoteConvGrpLocDtlVO .class));
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