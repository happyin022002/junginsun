/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0047HTMLAction.java
*@FileTitle : Pick-up Status by Auth No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.30 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.lse.containerleasemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerLeaseMgtSC로 실행요청<br>
 * - ContainerLeaseMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jin Jun Sung
 * @see ContainerLeaseMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_LSE_0047HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0047HTMLAction 객체를 생성
	 */
	public EES_LSE_0047HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerLeaseMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesLse0047Event event = new EesLse0047Event();
		SearchApprovalVO searchApprovalVO  = new SearchApprovalVO();
		SearchApprovalDetailVO searchApprovalDetailVO = new SearchApprovalDetailVO();
		String locCd        = request.getParameter("loc_cd");       
		String locTp        = request.getParameter("loc_tp");       
		String periodStdt   = request.getParameter("period_stdt");  
		String periodEddt   = request.getParameter("period_eddt");  
		String authNo       = request.getParameter("auth_no");      
		String agmtCtyCd    = request.getParameter("agmt_cty_cd");  
		String agmtSeq      = request.getParameter("agmt_seq");     
		String newVanTpCd   = request.getParameter("new_van_tp_cd");
		String pkupDueDt    = request.getParameter("pkup_due_dt"); 
		String lstmCd       = request.getParameter("lstm_cd"); 
		String cntrTpszCd   = request.getParameter("cntr_tpsz_cd"); 
		
		String detailAuthNo     = request.getParameter("detail_auth_no");
		String detailAgmtCtyCd  = request.getParameter("detail_agmt_cty_cd");
		String detailAgmtSeq    = request.getParameter("detail_agmt_seq");
		String detailCntrTpszCd = request.getParameter("detail_cntr_tpsz_cd");
		String detailDivsion    = request.getParameter("detail_divsion");
		
		if(command.isCommand(FormCommand.SEARCH)) {			
			searchApprovalVO.setLocCd(locCd);
			searchApprovalVO.setLocTp(locTp);
			searchApprovalVO.setPeriodStdt(periodStdt);
			searchApprovalVO.setPeriodEddt(periodEddt);
			searchApprovalVO.setAuthNo(authNo);
			searchApprovalVO.setAgmtCtyCd(agmtCtyCd);
			searchApprovalVO.setAgmtSeq(agmtSeq);
			searchApprovalVO.setNewVanTpCd(newVanTpCd);
			searchApprovalVO.setPkupDueDt(pkupDueDt);
			searchApprovalVO.setLstmCd(lstmCd);
			searchApprovalVO.setCntrTpszCd(cntrTpszCd);
			event.setSearchApprovalVO((SearchApprovalVO)getVO(request, SearchApprovalVO .class)) ;
		}else if(command.isCommand(FormCommand.SEARCH01)){
			searchApprovalDetailVO.setLocCd(locCd);
			searchApprovalDetailVO.setLocTp(locTp);
			searchApprovalDetailVO.setPeriodStdt(periodStdt);
			searchApprovalDetailVO.setPeriodEddt(periodEddt);
			searchApprovalDetailVO.setAuthNo(authNo);
			searchApprovalDetailVO.setAgmtCtyCd(agmtCtyCd);
			searchApprovalDetailVO.setAgmtSeq(agmtSeq);
			searchApprovalDetailVO.setNewVanTpCd(newVanTpCd);
			searchApprovalDetailVO.setPkupDueDt(pkupDueDt);
			searchApprovalDetailVO.setLstmCd(lstmCd);
			searchApprovalDetailVO.setCntrTpszCd(cntrTpszCd);		
			
			searchApprovalDetailVO.setDetailAuthNo(detailAuthNo);
			searchApprovalDetailVO.setDetailAgmtCtyCd(detailAgmtCtyCd);
			searchApprovalDetailVO.setDetailAgmtSeq(detailAgmtSeq);
			searchApprovalDetailVO.setDetailCntrTpszCd(detailCntrTpszCd);
			searchApprovalDetailVO.setDetailDivsion(detailDivsion);			
			event.setSearchApprovalDetailVO((SearchApprovalDetailVO)getVO(request, SearchApprovalDetailVO.class)) ;
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