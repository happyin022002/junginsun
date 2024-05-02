/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0014HTMLAction.java
*@FileTitle : US domestic cost/credit 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : 김보배
*@LastVersion : 1.0 
* 2012.10.16 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestTransmitVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.vo.SearchUSDomesticVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.coa.stdunitcost 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 STDUnitCostSC로 실행요청<br>
 * - STDUnitCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author BOBAE KIM
 * @see STDUnitCostEvent 참조
 * @since J2EE 1.6
 */

public class ESM_COA_0014HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_0009HTMLAction 객체를 생성
	 */
	public ESM_COA_0014HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 STDUnitCostEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmCoa0014Event event = new EsmCoa0014Event();

		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSearchUSDomesticVO((SearchUSDomesticVO)getVO(request, SearchUSDomesticVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02) || command.isCommand(FormCommand.SEARCH03)) {
			SearchUSDomesticVO searchUSDomesticVO = (SearchUSDomesticVO)getVO(request, SearchUSDomesticVO .class);
			event.setFCostYrmon(searchUSDomesticVO.getFCostYrmon());
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			SearchUSDomesticVO[] searchUSDomesticVOs = (SearchUSDomesticVO[])getVOs(request, SearchUSDomesticVO.class);
			event.setSearchUSDomesticVOs(searchUSDomesticVOs);
		}
		else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setSearchUSDomesticVO((SearchUSDomesticVO)getVO(request, SearchUSDomesticVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND02)) {
			// BackEndJob 으로 돌린 후 결과코드 조회
			event.setKey(request.getParameter("key"));
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