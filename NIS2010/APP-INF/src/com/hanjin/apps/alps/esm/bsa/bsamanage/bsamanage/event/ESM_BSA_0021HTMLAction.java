/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BSA_0021HTMLAction.java
*@FileTitle : Inquire/Edit BSA Table JO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.03 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaTableSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bsa.bsamanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BSAManageSC로 실행요청<br>
 * - BSAManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Ki Dae
 * @see EsmBsa0021Event 참조
 * @since J2EE 1.6
 */
public class ESM_BSA_0021HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * TESTHTMLAction 객체를 생성
	 */
	public ESM_BSA_0021HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmBsa0021Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("################# ESM_BSA_0021HTMLAction.perform() ############################[START]");
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmBsa0021Event event = new EsmBsa0021Event();
    	
		if(command.isCommand(FormCommand.SEARCHLIST01)
			|| command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setSearchBsaConditionVO((SearchBsaConditionVO)getVO(request, SearchBsaConditionVO.class));
		}	
		else if(command.isCommand(FormCommand.MULTI01)
				|| command.isCommand(FormCommand.MULTI02)
				|| command.isCommand(FormCommand.REMOVE01)
				|| command.isCommand(FormCommand.REMOVE02)) {
			event.setBsaTableSaveVOs((BsaTableSaveVO[])getVOs(request, BsaTableSaveVO.class,	"M_"));
		}
		else if(command.isCommand(FormCommand.MULTI03)
				|| command.isCommand(FormCommand.MULTI04)) {
			event.setSearchBsaConditionVO((SearchBsaConditionVO)getVO(request, SearchBsaConditionVO.class));
		}
		
		log.debug("################# ESM_BSA_0021HTMLAction.perform() ############################[END]");
		
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