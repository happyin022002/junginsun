/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1205HTMLAction.java
*@FileTitle : Payable Charge Audit Result & Payable Amount Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.21
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2013.03.21 조경완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsInvoiceAuditResultCmmtCrMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsPayableInvoiceCreationINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.ees.cgm.chassismgsetagreementinvoice 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ChassisMgsetAgreementInvoiceSC로 실행요청<br>
 * - ChassisMgsetAgreementInvoiceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM CHANG SIK
 * @see ChassisMgsetAgreementInvoiceEvent 참조
 * @since J2EE 1.4   
 */

public class EES_CGM_1205HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CGM_1031HTMLAction 객체를 생성
	 */
	public EES_CGM_1205HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ChassisMgsetAgreementInvoiceEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EesCgm1205Event event = new EesCgm1205Event();
		
		CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO1 = new CHSCpsPayableInvoiceCreationINVO();
		CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO2 = new CHSCpsPayableInvoiceCreationINVO();
		CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO3 = new CHSCpsPayableInvoiceCreationINVO();
		CHSCpsInvoiceAuditResultCmmtCrMGTVO cHSCpsInvoiceAuditResultCmmtCrMGTVO = new CHSCpsInvoiceAuditResultCmmtCrMGTVO();
		
		if(command.isCommand(FormCommand.SEARCH)) {		
			
			CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO = (CHSCpsPayableInvoiceCreationINVO)getVO(request, CHSCpsPayableInvoiceCreationINVO.class);
			chsCpsPayableInvoiceCreationINVO.setCostYrmon(chsCpsPayableInvoiceCreationINVO.getCostYrmon().replace("-", ""));
			
			event.setChsCpsPayableInvoiceCreationINVO(chsCpsPayableInvoiceCreationINVO);
			
		} else if(command.isCommand(FormCommand.SEARCH04)) {
			
			event.setAgmtOfcCtyCd(request.getParameter("parent_agmt_ofc_cty_cd"));
			event.setAgmtSeq(request.getParameter("parent_agmt_seq"));
			event.setAgmtVerNo(request.getParameter("parent_agmt_ver_no"));
			event.setCostYrmon(request.getParameter("cost_yrmon").replace("-", ""));
			event.setCostYrmonSeq(request.getParameter("parent_cost_yrmon_seq"));
			
		} else if(command.isCommand(FormCommand.MULTI01)) {
			
			CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO = (CHSCpsPayableInvoiceCreationINVO)getVO(request, CHSCpsPayableInvoiceCreationINVO.class);
			chsCpsPayableInvoiceCreationINVO.setCostYrmon(chsCpsPayableInvoiceCreationINVO.getCostYrmon().replace("-", ""));
			
			event.setChsCpsPayableInvoiceCreationINVO(chsCpsPayableInvoiceCreationINVO);
			
			event.setChsCpsPayableInvoiceCreationINVO1(chsCpsPayableInvoiceCreationINVO1.fromRequestGrid(request,"t1sheet1"));
			event.setChsCpsPayableInvoiceCreationINVO2(chsCpsPayableInvoiceCreationINVO2.fromRequestGrid(request,"t2sheet1"));
			event.setChsCpsPayableInvoiceCreationINVO3(chsCpsPayableInvoiceCreationINVO3.fromRequestGrid(request,"t4sheet1"));
			if(event.getChsCpsPayableInvoiceCreationINVO().getParentChssCopInvTpCd().equals("CMT") || 
					event.getChsCpsPayableInvoiceCreationINVO().getParentChssCopInvTpCd().equals("MCD")) {
				event.setCHSCpsInvoiceAuditResultCmmtCrMGTVOs(cHSCpsInvoiceAuditResultCmmtCrMGTVO.fromRequestGrid(request, "t5sheet1"));
			}
			
		
		} else if(command.isCommand(FormCommand.MULTI02)) {
			CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO = (CHSConfirmPayableAmountINVO)getVO(request, CHSConfirmPayableAmountINVO.class);
			chsConfirmPayableAmountINVO.setCostYrmon(chsConfirmPayableAmountINVO.getCostYrmon().replace("-", ""));
			chsConfirmPayableAmountINVO.setInvDt(chsConfirmPayableAmountINVO.getInvDt().replace("-", ""));
			
			event.setChsConfirmPayableAmountINVO(chsConfirmPayableAmountINVO);
			
			event.setChsCpsPayableInvoiceCreationINVOS((CHSCpsPayableInvoiceCreationINVO[])getVOs(request, CHSCpsPayableInvoiceCreationINVO.class, ""));
				
		} else if(command.isCommand(FormCommand.MULTI03)) {
			event.setCHSCpsInvoiceAuditResultCmmtCrMGTVOs(cHSCpsInvoiceAuditResultCmmtCrMGTVO.fromRequestGrid(request, "t5sheet1"));
			
		} else if(command.isCommand(FormCommand.REMOVE)){
			
			CHSCpsPayableInvoiceCreationINVO chsCpsPayableInvoiceCreationINVO = (CHSCpsPayableInvoiceCreationINVO)getVO(request, CHSCpsPayableInvoiceCreationINVO.class);
			chsCpsPayableInvoiceCreationINVO.setCostYrmon(chsCpsPayableInvoiceCreationINVO.getCostYrmon().replace("-", ""));
			
			event.setChsCpsPayableInvoiceCreationINVO(chsCpsPayableInvoiceCreationINVO);
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