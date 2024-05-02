/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0030HTMLAction.java
*@FileTitle : On Hire Approval Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.15 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.lse.containerleasemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerLeaseMgtSC로 실행요청<br>
 * - ContainerLeaseMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jin Jun Sung
 * @see ContainerLeaseMgtEvent 참조
 * @since J2EE 1.6
 */

public class EES_LSE_0030HTMLAction extends HTMLActionSupport {  

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0030HTMLAction 객체를 생성
	 */
	public EES_LSE_0030HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerLeaseMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesLse0030Event event = new EesLse0030Event();
		
		String strAuthNo    = request.getParameter("cntr_onh_auth_no");
		String strAgmtCtyCd = request.getParameter("agmt_cty_cd");
		String strAgmtSeq   = request.getParameter("agmt_seq");
		String strPkupFmDt  = request.getParameter("pkup_fm_dt");
		String strPkupDueDt = request.getParameter("pkup_due_dt");
		String strAproRmk   = request.getParameter("remarks");
		String strTpszCd    = request.getParameter("tpsz_cd");
	 	String strLocCd     = request.getParameter("loc_cd");
	 	String strLstmCd    = request.getParameter("combo1");
	 	String strTysz      = request.getParameter("tysz");
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setCntrOnhAuthNo(strAuthNo);
			event.setTysz(strTysz);
		}else if(command.isCommand(FormCommand.REMOVE)) {
			
			event.setCntrOnhAuthNo(strAuthNo);
			event.setAgmtCtyCd(strAgmtCtyCd);
			event.setAgmtSeq(strAgmtSeq);
			
		}else if(command.isCommand(FormCommand.MULTI)) {
			
			event.setOnhireApprovalVOs((OnhireApprovalVO[])getVOs(request, OnhireApprovalVO.class,""));
						
			event.setCntrOnhAuthNo(strAuthNo);
			event.setPkupFmDt(strPkupFmDt);
			event.setPkupDueDt(strPkupDueDt);
			event.setAproRmk(strAproRmk);
			event.setTpszCd(strTpszCd);
		 	event.setOnhLocCd(strLocCd);
		 	event.setLstmcd(strLstmCd);
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