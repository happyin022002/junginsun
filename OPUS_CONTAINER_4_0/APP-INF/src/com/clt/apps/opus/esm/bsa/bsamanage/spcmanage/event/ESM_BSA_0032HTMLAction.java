/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BSA_0032HTMLAction.java
*@FileTitle : Step Up/Down by VVD 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.09.28 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BsaVvdMstVO;
import com.clt.syscommon.common.table.BsaVvdPortDwnVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bsa.bsamanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BSAManageSC로 실행요청<br>
 * - BSAManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author NAMKOONG Jin Ho
 * @see BSAManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BSA_0032HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BSA_0032HTMLAction 객체를 생성
	 */
	public ESM_BSA_0032HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BSAManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBsa0032Event event = new EsmBsa0032Event();

		if(command.isCommand(FormCommand.SEARCHLIST01)||command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setSearchSpcConditionVO((SearchSpcConditionVO)getVO(request, SearchSpcConditionVO .class));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setBsaVvdMstVOs((BsaVvdMstVO[])getVOs(request, BsaVvdMstVO.class));
		}else if(command.isCommand(FormCommand.MULTI02)) {
			event.setBsaVvdPortDwnVOs((BsaVvdPortDwnVO[])getVOs(request, BsaVvdPortDwnVO.class));
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