/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2052HTMLAction.java
*@FileTitle : RFA Guideline Creation - Location Group [Load Exce]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.08.03 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.vo.GrpLocGlineVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.vo.RsltPriRgGrpVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.PriRgGrpLocDtlVO;
import com.clt.syscommon.common.table.PriRgGrpLocVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.rfaguideline 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RFAGuidelineSC로 실행요청<br>
 * - RFAGuidelineSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CHOI SUNG MIN
 * @see RFAGuidelineEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_2052HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_2052HTMLAction 객체를 생성
	 */
	public ESM_PRI_2052HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RFAGuidelineEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri2052Event event = new EsmPri2052Event();
		
		if(command.isCommand(FormCommand.MULTI01)) {
			GrpLocGlineVO vo = new GrpLocGlineVO();
			vo.setPriRgGrpLocVOS((PriRgGrpLocVO[]) getVOs(request, PriRgGrpLocVO.class, "sheet1_"));
			vo.setPriRgGrpLocDtlVOS((PriRgGrpLocDtlVO[]) getVOs(request, PriRgGrpLocDtlVO.class, "sheet2_"));
			event.setGrpLocGlineVO(vo);
		} else if (command.isCommand(FormCommand.MULTI02)) {
			event.setRsltPriRgGrpVOs((RsltPriRgGrpVO[]) getVOs(request, RsltPriRgGrpVO.class, ""));			
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