/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_093HTMLAction.java
*@FileTitle : Slip Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.27 
*@LastModifier : 이영두
*@LastVersion : 1.0
* 2015.07.27  이영두
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSlipApprovalVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TimeCharterInOutAccountingSC로 실행요청<br>
 * - TimeCharterInOutAccountingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Yoon, Seyeong
 * @see TimeCharterInOutAccountingEvent 참조
 * @since J2EE 1.6 
 */

public class ESM_FMS_0093HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_FMS_0052HTMLAction 객체를 생성
	 */
	public ESM_FMS_0093HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TimeCharterInOutAccountingEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmFms0093Event event = new EsmFms0093Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setSlipType(request.getParameter("slip_type"));
			event.setFletCtrtTpCd(request.getParameter("flet_ctrt_tp_cd"));
			event.setCsrNo(request.getParameter("save_csr_no"));
			event.setAproFlg(request.getParameter("apro_flg"));
			event.setCxlFlg(request.getParameter("cxl_flg"));			
			event.setCxlDesc(request.getParameter("cxl_desc"));
			event.setInterCoCd(request.getParameter("inter_co_cd"));
			event.setArInterCoCd(request.getParameter("ar_inter_co_cd"));
			event.setUrgPayFlg(request.getParameter("urg_pay_flg"));
			event.setLstAproFlg(request.getParameter("lst_apro_flg"));
			event.setAproRqstNo(request.getParameter("apro_rqst_no"));
			event.setAproRqstSeq(request.getParameter("apro_rqst_seq"));
			event.setAproDt(request.getParameter("apro_dt"));
			
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setCondSearchSlipApprovalVO((CondSearchSlipApprovalVO)getVO(request, CondSearchSlipApprovalVO .class));
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