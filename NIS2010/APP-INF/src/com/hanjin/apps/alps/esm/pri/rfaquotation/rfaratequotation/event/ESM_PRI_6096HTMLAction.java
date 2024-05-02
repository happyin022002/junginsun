/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_6096HTMLAction.java
 *@FileTitle : Rate Quotation Horizontal Load Excel
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.30
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RFARateQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListHorizontalExcelForIHCVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListHorizontalLoadExcelForIHCVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriRqRtCmdtHdrVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scquotation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RFAQuotationSC로 실행요청<br>
 * - RFAQuotationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Eun-Sup, Lee
 * @see RFAQuotationEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_6096HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_PRI_6096HTMLAction 객체를 생성
	 */
	public ESM_PRI_6096HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RFAQuotationEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmPri6096Event event = new EsmPri6096Event();

		RFARateQuotationVO rateQuotationVO = new RFARateQuotationVO();
		rateQuotationVO.setFicRtTpCd(JSPUtil.getParameter(request, "fic_rt_tp_cd"));
		rateQuotationVO.setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd"));
		event.setRateQuotationVO(rateQuotationVO);

		if (command.isCommand(FormCommand.SEARCH01)) {
			event.getRateQuotationVO().setPriRqRtCmdtHdrVO((PriRqRtCmdtHdrVO) getVO(request, PriRqRtCmdtHdrVO.class));
			event.getRateQuotationVO().setRsltRtListHorizontalExcelForIHCVOs(
					(RsltRtListHorizontalExcelForIHCVO[]) getVOs(request, RsltRtListHorizontalExcelForIHCVO.class, ""));
		} else if (command.isCommand(FormCommand.MODIFY01)) {
			event.getRateQuotationVO().setPriRqRtCmdtHdrVO((PriRqRtCmdtHdrVO) getVO(request, PriRqRtCmdtHdrVO.class));
			event.getRateQuotationVO().setRsltRtListHorizontalLoadExcelForIHCVOs(
					(RsltRtListHorizontalLoadExcelForIHCVO[]) getVOs(request, RsltRtListHorizontalLoadExcelForIHCVO.class, ""));
		}
		request.setAttribute("Event", event);
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