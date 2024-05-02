/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_2017HTMLAction.java
*@FileTitle : Basic RFA Auto Amendment Request
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstPriRpAmendVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRoutVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.rfaproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RFAProposalSC로 실행요청<br>
 * - RFAProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Byeon Young Joo
 * @see RFAProposalEvent 참조
 * @since J2EE 1.4
 */
public class ESM_PRI_2017HTMLAction extends HTMLActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_PRI_2017HTMLAction 객체를 생성
	 */
	public ESM_PRI_2017HTMLAction() {
	}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RFAProposalEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmPri2017Event event = new EsmPri2017Event();
		event.setMstRfaNo(request.getParameter("mst_rfa_no"));
		
		if (command.isCommand(FormCommand.SEARCH)) {
			event.setPriRpScpRtCmdtRoutVO((PriRpScpRtCmdtRoutVO)getVO(request, PriRpScpRtCmdtRoutVO.class));
			
		} else if (command.isCommand(FormCommand.MULTI)) {	// Amend
			event.setRsltRoutHdrSmryListVO((RsltRoutHdrSmryListVO)getVO(request, RsltRoutHdrSmryListVO.class));
			event.setCstPriRpAmendVO((CstPriRpAmendVO)getVO(request, CstPriRpAmendVO .class));
            event.setPriRpMnVO((PriRpMnVO)getVO(request, PriRpMnVO.class));
            event.setRsltRfaPropCopyVO((RsltRfaPropCopyVO)getVO(request, RsltRfaPropCopyVO.class));
            event.setRsltRoutHdrSmryListVOs((RsltRoutHdrSmryListVO[])getVOs(request, RsltRoutHdrSmryListVO.class,"sheet1_"));


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
