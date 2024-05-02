/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6014_01HTMLAction.java
*@FileTitle : RFA Quotation Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.03 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocDtlListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.vo.RFAGroupLocationQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriRqGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriRqGrpLocVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.rfaquotation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RFAQuotationSC로 실행요청<br>
 * - RFAQuotationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Seung-Jun,Lee
 * @see RFAQuotationEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_6014_01HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_6014_01HTMLAction 객체를 생성
	 */
	public ESM_PRI_6014_01HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RFAQuotationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri601401Event event = new EsmPri601401Event();
		
		RFAGroupLocationQuotationVO groupLocationQuotationVO = new RFAGroupLocationQuotationVO();
		
		event.setGroupLocationQuotationVO(groupLocationQuotationVO) ;
		
		if (command.isCommand(FormCommand.SEARCH01)) {
			event.getGroupLocationQuotationVO().setPriRqGrpLocVO((PriRqGrpLocVO) getVO(request, PriRqGrpLocVO.class));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			event.getGroupLocationQuotationVO().setPriRqGrpLocVO((PriRqGrpLocVO) getVO(request, PriRqGrpLocVO.class));
		} else if (command.isCommand(FormCommand.MULTI01)) {
			event.getGroupLocationQuotationVO().setPriRqGrpLocVO((PriRqGrpLocVO) getVO(request, PriRqGrpLocVO.class));
			event.getGroupLocationQuotationVO().setPriRqGrpLocVOs((PriRqGrpLocVO[]) getVOs(request, PriRqGrpLocVO.class, "sheet1_"));
			event.getGroupLocationQuotationVO().setPriRqGrpLocDtlVOs((PriRqGrpLocDtlVO[]) getVOs(request, PriRqGrpLocDtlVO.class, "sheet2_"));
		} else if (command.isCommand(FormCommand.MULTI02)) {
			event.getGroupLocationQuotationVO().setRsltPriRqMnVO((RsltPriRqMnVO) getVO(request, RsltPriRqMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH03)) {
			event.getGroupLocationQuotationVO().setPriRqGrpLocVOs((PriRqGrpLocVO[]) getVOs(request, PriRqGrpLocVO.class));
			event.getGroupLocationQuotationVO().setPriRqGrpLocVO((PriRqGrpLocVO) getVO(request, PriRqGrpLocVO.class));
		} else if(command.isCommand(FormCommand.MULTI07)) {
			event.setRsltGrpLocDtlListVOs((RsltGrpLocDtlListVO[])getVOs(request, RsltGrpLocDtlListVO .class, "sheet1_loc_check_"));
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