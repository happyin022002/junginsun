/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_025HTMLAction.java
*@FileTitle : W/O 발행내역을 조회하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-26
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-12-26 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.syscommon.common.table.TrsTrspWrkOrdVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.workordermanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WorkOrderManageSC로 실행요청<br>
 * - WorkOrderManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author poong_yeon
 * @see EsdTrs0025Event , ESD_TRS_025EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0025HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_025HTMLAction 객체를 생성
	 */
	public ESD_TRS_0025HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_025Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		
		int codeLength = 0;
		String [] ibflag = request.getParameterValues("ibflag");
		if (ibflag != null) codeLength = ibflag.length;
		
		
		TrsTrspWrkOrdVO [] trsTrspWrkOrdVOs = (new TrsTrspWrkOrdVO()).fromRequestGrid(request);

		EsdTrs0025Event event = new EsdTrs0025Event(); 
		
		event.setTrsTrspWrkOrdVOs(trsTrspWrkOrdVOs);
		
			
		String fmDate = request.getParameter("fmdate");
		String toDate = request.getParameter("todate");
		String comboSvcProvider = request.getParameter("combo_svc_provider");
		String woNo = request.getParameter("wo_no");
		String woIssueOffice = request.getParameter("wo_issue_office");
		String woIssueUser = request.getParameter("wo_issue_user");
		String selEts = request.getParameter("sel_ets");
		String woIssSts = request.getParameter("wo_iss_sts");
		String selCostMode = request.getParameter("sel_costmode");
		String issueType = request.getParameter("issue_type");
		String selTransMode = request.getParameter("sel_transmode");
		String woNoA = request.getParameter("wo_no_a");
		
		// CHM-201535923 W/O Inquiry 개선2
		String woIssKnt = request.getParameter("wo_iss_knt");
		event.setFmDate(fmDate);
		event.setToDate(toDate);
		event.setComboSvcProvider(comboSvcProvider);
		event.setWoNo(woNo);
		event.setWoIssueOffice(woIssueOffice);
		event.setWoIssueUser(woIssueUser);
		event.setSelEts(selEts);
		event.setWoIssSts(woIssSts);
		event.setSelCostMode(selCostMode);
		event.setIssueType(issueType);
		event.setSelTransMode(selTransMode);
		event.setWoNoA(woNoA);	
		// CHM-201535923 W/O Inquiry 개선2
		event.setWoIssKnt(woIssKnt);
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