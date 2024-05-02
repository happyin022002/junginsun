/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0161HTMLAction.java
*@FileTitle : Disposal Invoice Issue & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.09.21 함형석
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.04.05 신혜정 [CHM-201217201] Disposal Invoice Issue 화면내 [Confirm], [Cancel] 처리시, invoice no 체크 로직 추가
					  1. [Confirm] 처리시, invoice no 유,무에 따른 체크 로직 추가
					   - invoice no 가 있을 경우 confirm 된 데이타 확인 후 존재시 return 처리
					   - invoice no 가 없을 경우(invoice status=New) Verify List 의 disposal no, eq_no 리스트로 invoice no 존재 확인후 있으면 return 처리
					  2. [Cancel] 처리시, Cancel invoice no 체크 로직 추가
					   - 기 Cancel invoice no 존재시 return 처리
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.CustomReceivableINVInquiryListVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.CustomReceivableInvoiceDetailINVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.ReceivableINVInquiryINVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.ReceivableInvoiceGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.accountmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountManageSC로 실행요청<br>
 * - AccountManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 함형석
 * @see AccountManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_MNR_0161HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0161HTMLAction 객체를 생성
	 */
	public EES_MNR_0161HTMLAction() {} 

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0161Event event = new EesMnr0161Event();
		
		ReceivableInvoiceGRPVO receivableInvoiceGRPVO = new ReceivableInvoiceGRPVO();
		DisposalGRPVO disposalGRPVO = new DisposalGRPVO();
		
		//조회 리스트
		if(command.isCommand(FormCommand.SEARCH)) {
			receivableInvoiceGRPVO.setReceivableINVInquiryINVO((ReceivableINVInquiryINVO)getVO(request, ReceivableINVInquiryINVO.class));
		} 
		//Detail 조회 리스트
		else if(command.isCommand(FormCommand.SEARCH01)) {
			receivableInvoiceGRPVO.setReceivableINVInquiryINVO((ReceivableINVInquiryINVO)getVO(request, ReceivableINVInquiryINVO .class));
			receivableInvoiceGRPVO.setArrayCustomReceivableINVInquiryListVOs((CustomReceivableINVInquiryListVO[])getVOs(request, CustomReceivableINVInquiryListVO.class));
		}		
		else if(command.isCommand(FormCommand.MULTI)) {
			receivableInvoiceGRPVO.setReceivableINVInquiryINVO((ReceivableINVInquiryINVO)getVO(request, ReceivableINVInquiryINVO .class));
			receivableInvoiceGRPVO.setArrayCustomReceivableInvoiceDetailINVOs((CustomReceivableInvoiceDetailINVO[])getVOs(request, CustomReceivableInvoiceDetailINVO.class, "sheet2_"));
			disposalGRPVO.setArrCustomMnrDispDtlVOS((CustomMnrDispDtlVO[])getVOs(request, CustomMnrDispDtlVO.class, "sheet2_"));
			disposalGRPVO.setCustomMnrDispDtlVO((CustomMnrDispDtlVO)getVO(request, CustomMnrDispDtlVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			receivableInvoiceGRPVO.setReceivableINVInquiryINVO((ReceivableINVInquiryINVO)getVO(request, ReceivableINVInquiryINVO .class));
			receivableInvoiceGRPVO.setArrayCustomReceivableInvoiceDetailINVOs((CustomReceivableInvoiceDetailINVO[])getVOs(request, CustomReceivableInvoiceDetailINVO.class, "sheet2_"));
			disposalGRPVO.setArrCustomMnrDispDtlVOS((CustomMnrDispDtlVO[])getVOs(request, CustomMnrDispDtlVO.class, "sheet2_"));
			disposalGRPVO.setCustomMnrDispDtlVO((CustomMnrDispDtlVO)getVO(request, CustomMnrDispDtlVO.class));
		}		
		else if(command.isCommand(FormCommand.MULTI01)) {
			receivableInvoiceGRPVO.setReceivableINVInquiryINVO((ReceivableINVInquiryINVO)getVO(request, ReceivableINVInquiryINVO .class));
		}
		else if(command.isCommand(FormCommand.REMOVE)) {
			receivableInvoiceGRPVO.setReceivableINVInquiryINVO((ReceivableINVInquiryINVO)getVO(request, ReceivableINVInquiryINVO .class));
			disposalGRPVO.setCustomMnrDispDtlVO((CustomMnrDispDtlVO)getVO(request, CustomMnrDispDtlVO.class));
		}
		// Invoice Issue의 Confirm, Cancel 시 invoice no 에 대한 검증 실시
		else if(command.isCommand(FormCommand.COMMAND01)) {
			receivableInvoiceGRPVO.setReceivableINVInquiryINVO((ReceivableINVInquiryINVO)getVO(request, ReceivableINVInquiryINVO .class));
			receivableInvoiceGRPVO.setArrayCustomReceivableInvoiceDetailINVOs((CustomReceivableInvoiceDetailINVO[])getVOs(request, CustomReceivableInvoiceDetailINVO.class, "sheet2_"));
		}
		
		event.setReceivableInvoiceGRPVO(receivableInvoiceGRPVO);
		event.setDisposalGRPVO(disposalGRPVO);
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