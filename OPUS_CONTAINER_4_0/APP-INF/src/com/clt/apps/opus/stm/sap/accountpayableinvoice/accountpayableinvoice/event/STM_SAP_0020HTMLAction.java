/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : STM_SAP_0020HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceApprovalInfoListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryListVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Dong Hoon
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class STM_SAP_0020HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0013HTMLAction 객체를 생성
	 */
	public STM_SAP_0020HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param HttpServletRequest request
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	StmSap0020Event event = new StmSap0020Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {								
		
			event.setOfcCd(JSPUtil.getParameter(request, "ofc_cd" , ""));
			event.setVndrNo(JSPUtil.getParameter(request, "vndr_no", ""));
			event.setCreDt(JSPUtil.getParameter(request, "cre_dt" , ""));
			event.setInvNo(JSPUtil.getParameter(request, "inv_no" , ""));
			
		} else if(command.isCommand(FormCommand.MULTI01)) {
	
			event.setLginUsrApOfc(JSPUtil.getParameter(request, "lgin_usr_ap_ofc" , ""));
			
			event.setInvoiceApprovalInfoListVOs((InvoiceApprovalInfoListVO[])getVOs(request, InvoiceApprovalInfoListVO.class, "sheet1_"));
			
		} else if(command.isCommand(FormCommand.MULTI02)) {
						
			event.setInvoiceEntryListVOs((InvoiceEntryListVO[])getVOs(request, InvoiceEntryListVO.class, "sheet1_"));
		
		}  else if(command.isCommand(FormCommand.COMMAND01)) {//cancel ASA close check
			
			event.setSapCommonVO((SapCommonVO)getVO(request, SapCommonVO.class));
		}
		
		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param EventResponse eventResponse
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}