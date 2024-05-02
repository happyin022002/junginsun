/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6005_03HTMLAction.java
*@FileTitle : S/C Quotation Rate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.12 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RateQuotationVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriSqRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSqRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSqRtCmdtVO;
import com.hanjin.syscommon.common.table.PriSqRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriSqRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriSqRtVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scquotation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCQuotationSC로 실행요청<br>
 * - SCQuotationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Seung-Jun,Lee
 * @see SCQuotationEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_6005_03HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_6005_03HTMLAction 객체를 생성
	 */
	public ESM_PRI_6005_03HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCQuotationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri600503Event event = new EsmPri600503Event();
	
		RateQuotationVO rateQuotationVO = new RateQuotationVO();
		
		event.setRateQuotationVO(rateQuotationVO);
		
		if(command.isCommand(FormCommand.MULTI01)) {
			event.getRateQuotationVO().setPriSqRtCmdtHdrVO((PriSqRtCmdtHdrVO)getVO(request, PriSqRtCmdtHdrVO .class));
			event.getRateQuotationVO().setPriSqRtCmdtHdrVOs((PriSqRtCmdtHdrVO[]) getVOs(request, PriSqRtCmdtHdrVO.class, "sheet1_"));
			event.getRateQuotationVO().setPriSqRtCmdtVOs((PriSqRtCmdtVO[]) getVOs(request, PriSqRtCmdtVO.class, "sheet5_"));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.getRateQuotationVO().setPriSqRtCmdtHdrVO((PriSqRtCmdtHdrVO)getVO(request, PriSqRtCmdtHdrVO .class));
			event.getRateQuotationVO().setPriSqRtCmdtRoutVO((PriSqRtCmdtRoutVO)getVO(request, PriSqRtCmdtRoutVO .class));
			event.getRateQuotationVO().setPriSqRtCmdtRoutVOs((PriSqRtCmdtRoutVO[]) getVOs(request, PriSqRtCmdtRoutVO.class, "sheet2_"));
			event.getRateQuotationVO().setPriSqRtVOs((PriSqRtVO[]) getVOs(request, PriSqRtVO.class, "sheet4_"));
			event.getRateQuotationVO().setPriSqRtRoutOrgPntVOs((PriSqRtRoutPntVO[]) getVOs(request, PriSqRtRoutPntVO.class, "sheet6_"));
			event.getRateQuotationVO().setPriSqRtRoutOrgViaVOs((PriSqRtRoutViaVO[]) getVOs(request, PriSqRtRoutViaVO.class, "sheet7_"));
			event.getRateQuotationVO().setPriSqRtRoutDestViaVOs((PriSqRtRoutViaVO[]) getVOs(request, PriSqRtRoutViaVO.class, "sheet8_"));
			event.getRateQuotationVO().setPriSqRtRoutDestPntVOs((PriSqRtRoutPntVO[]) getVOs(request, PriSqRtRoutPntVO.class, "sheet9_"));
		}
		//gline copy
		else if(command.isCommand(FormCommand.MULTI03)) {
			event.getRateQuotationVO().setRsltPriSqMnVO((RsltPriSqMnVO)getVO(request, RsltPriSqMnVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.getRateQuotationVO().setPriSqRtCmdtHdrVO((PriSqRtCmdtHdrVO)getVO(request, PriSqRtCmdtHdrVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.getRateQuotationVO().setPriSqRtCmdtHdrVO((PriSqRtCmdtHdrVO)getVO(request, PriSqRtCmdtHdrVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.getRateQuotationVO().setPriSqRtCmdtRoutVO((PriSqRtCmdtRoutVO)getVO(request, PriSqRtCmdtRoutVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) { //Calculate
			event.getRateQuotationVO().setPriSqRtCmdtRoutVO((PriSqRtCmdtRoutVO)getVO(request, PriSqRtCmdtRoutVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH05)) { //Monitor Calculate
			event.getRateQuotationVO().setPriSqRtCmdtRoutVO((PriSqRtCmdtRoutVO)getVO(request, PriSqRtCmdtRoutVO .class));
		}
		//excel down ver
		else if(command.isCommand(FormCommand.SEARCH10)) {
			event.getRateQuotationVO().setPriSqRtCmdtHdrVO((PriSqRtCmdtHdrVO)getVO(request, PriSqRtCmdtHdrVO .class));
		}
		//excel down hor
		else if(command.isCommand(FormCommand.SEARCH11)) {
			event.getRateQuotationVO().setPriSqRtCmdtHdrVO((PriSqRtCmdtHdrVO)getVO(request, PriSqRtCmdtHdrVO .class));
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