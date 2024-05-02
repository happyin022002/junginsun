/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0055HTMLAction.java
*@FileTitle : On off Hire Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.19 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditDetailVO;
import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditSearchVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.lse.containercostanalysis 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerCostAnalysisSC로 실행요청<br>
 * - ContainerCostAnalysisSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jin Jun Sung
 * @see ContainerCostAnalysisEvent 참조
 * @since J2EE 1.6
 */

public class EES_LSE_0055HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0055HTMLAction 객체를 생성
	 */
	public EES_LSE_0055HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerCostAnalysisEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesLse0055Event event = new EesLse0055Event();
		OnOffHireAuditSearchVO onOffHireAuditSearchVO = new OnOffHireAuditSearchVO();
		OnOffHireAuditDetailVO onOffHireAuditDetailVO = new OnOffHireAuditDetailVO();
		
		String strVndrSeq       = request.getParameter("vndr_seq");
		String strAudVerSeq     = request.getParameter("aud_ver_seq");
		String strAgmtCty_cd    = request.getParameter("agmt_cty_cd");
		String strAgmtSeq       = request.getParameter("agmt_seq");
		String strLstmCd        = request.getParameter("lstm_cd");
		String strAuditTp       = request.getParameter("audit_tp");
		String strSearchMonth   = request.getParameter("search_month");
		String strSearchStdt    = request.getParameter("search_stdt");
		String strSearchEndt    = request.getParameter("search_endt");
		String strRefNo         = request.getParameter("ref_no");
		
		if(strSearchMonth != null){
		    strSearchMonth = strSearchMonth.replaceAll("-", "");
		}
		
		if(command.isCommand(FormCommand.SEARCH)) {
			//event
			onOffHireAuditSearchVO.setVndrSeq(strVndrSeq);
			onOffHireAuditSearchVO.setAudVerSeq(strAudVerSeq);
			onOffHireAuditSearchVO.setAgmtCtyCd(strAgmtCty_cd);
			onOffHireAuditSearchVO.setAgmtSeq(strAgmtSeq);
			onOffHireAuditSearchVO.setLstmCd(strLstmCd);
			onOffHireAuditSearchVO.setAuditTp(strAuditTp);
			if(strSearchMonth != null){
				onOffHireAuditSearchVO.setSearchMonth(strSearchMonth);
			}
			onOffHireAuditSearchVO.setSearchStdt(strSearchStdt);
			onOffHireAuditSearchVO.setSearchEnddt(strSearchEndt);
			
			event.setOnOffHireAuditSearchVO(onOffHireAuditSearchVO);
			
		}else if(command.isCommand(FormCommand.SEARCH01)){
			
			onOffHireAuditSearchVO.setVndrSeq(strVndrSeq);
			if(strSearchMonth != null){
				onOffHireAuditSearchVO.setSearchMonth(strSearchMonth);
			}
			onOffHireAuditSearchVO.setSearchStdt(strSearchStdt);
			onOffHireAuditSearchVO.setSearchEnddt(strSearchEndt);
			
			event.setOnOffHireAuditSearchVO(onOffHireAuditSearchVO);
		}else if(command.isCommand(FormCommand.SEARCH02)){
			
			onOffHireAuditDetailVO.setVndrSeq(strVndrSeq);
			onOffHireAuditDetailVO.setAudVerSeq(strAudVerSeq);
			onOffHireAuditDetailVO.setAgmtCtyCd(strAgmtCty_cd);
			onOffHireAuditDetailVO.setAgmtSeq(strAgmtSeq);
			onOffHireAuditDetailVO.setSearchStdt(strSearchStdt);
			onOffHireAuditDetailVO.setSearchEnddt(strSearchEndt);
			onOffHireAuditDetailVO.setRefNo(strRefNo);
			onOffHireAuditDetailVO.setAgmtCtyCd(strAgmtCty_cd);
			onOffHireAuditDetailVO.setAgmtSeq(strAgmtSeq);
			onOffHireAuditDetailVO.setAuditType(strAuditTp);
			
			event.setOnOffHireAuditDetailVO(onOffHireAuditDetailVO);
		}else if(command.isCommand(FormCommand.MULTI)){
			event.setVndrSeq(strVndrSeq);
			event.setAudVerSeq(strAudVerSeq);
			event.setSearchStdt(strSearchStdt);
			event.setSearchEndt(strSearchEndt);
			event.setAuditType(strAuditTp);
			event.setOnOffHireAuditDetailVOS((OnOffHireAuditDetailVO[])getVOs(request, OnOffHireAuditDetailVO.class,""));
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
	@Override
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