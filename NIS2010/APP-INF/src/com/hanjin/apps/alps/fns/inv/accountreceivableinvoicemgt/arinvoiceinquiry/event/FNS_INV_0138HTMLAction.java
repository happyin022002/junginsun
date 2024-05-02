/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0138HTMLAction.java
*@FileTitle : Invoice Detail Inquiry for AKLBA
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.15
*@LastModifier : 김준호
*@LastVersion : 1.0
* 2009.09.07 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BillInputVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Choi Do Soon
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.4
 */

public class FNS_INV_0138HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0138HTMLAction 객체를 생성
	 */
	public FNS_INV_0138HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0138Event event = new FnsInv0138Event();
		 
		if(command.isCommand(FormCommand.SEARCH)) {	//open
			BillInputVO billInputVO = new BillInputVO();
			
			billInputVO.setOfcCd(request.getParameter("ar_ofc_cd").trim());
			billInputVO.setFmDt(request.getParameter("fm_dt").trim());
			billInputVO.setToDt(request.getParameter("to_dt").trim());
			
//			billInputVO.setIoBndCd(request.getParameter("io_bnd_cd").trim());
//			billInputVO.setActCustCntCd(request.getParameter("act_cust_cnt_cd").trim());
//			billInputVO.setActCustSeq(request.getParameter("act_cust_seq").trim());
//			billInputVO.setDtType(request.getParameter("dt_type").trim());
//			billInputVO.setVvdCd(request.getParameter("vvd_cd").trim());
//			billInputVO.setSvcScpCd(request.getParameter("svc_scp_cd").trim());
//			billInputVO.setPorCd(request.getParameter("por_cd").trim());
//			billInputVO.setPolCd(request.getParameter("pol_cd").trim());
//			billInputVO.setPodCd(request.getParameter("pod_cd").trim());
//			billInputVO.setDelCd(request.getParameter("del_cd").trim());
//			billInputVO.setIssOpt(request.getParameter("iss_opt").trim());
//			billInputVO.setArHdQtrOfcCd(request.getParameter("ar_hd_qtr_ofc_cd").trim());

			event.setBillInputVO(billInputVO);
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