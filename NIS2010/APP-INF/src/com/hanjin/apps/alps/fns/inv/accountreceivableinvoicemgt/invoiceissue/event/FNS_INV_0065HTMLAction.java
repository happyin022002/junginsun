/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0065HTMLAction.java
*@FileTitle : (Vietnam) Invoice History Inquiry 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.10.26 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEActInvoiceVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jung Jin Park
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.6
 */

public class FNS_INV_0065HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0065HTMLAction 객체를 생성
	 */
	public FNS_INV_0065HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0065Event event = new FnsInv0065Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			InvoiceIssueDateVO invoiceIssueDateVO = new InvoiceIssueDateVO();
			
			// rev_tp_cd
			String arrInvTepe[] = request.getParameterValues("inv_type");
			String invType = "";
			
			if(arrInvTepe == null) {
				arrInvTepe = new String[1];
				arrInvTepe[0] = request.getParameter("inv_type");
			}
			
			if(arrInvTepe.length > 0) {
				for(int i=0; i<arrInvTepe.length; i++) {
					if(i==0) invType = invType + arrInvTepe[i];
					else invType = invType +","+ arrInvTepe[i];
				}
			}
			
			invoiceIssueDateVO = (InvoiceIssueDateVO)getVO(request, InvoiceIssueDateVO .class);
			invoiceIssueDateVO.setInvType(invType);
			
			event.setInvoiceIssueDateVO(invoiceIssueDateVO);
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			List<VIEActInvoiceVO> vieActInvoiceList = new ArrayList<VIEActInvoiceVO>();
			
			String updUsrId = request.getParameter("upd_usr_id");
			VIEActInvoiceVO[] arrVIEActInvoiceList = (VIEActInvoiceVO[]) getVOs(request, VIEActInvoiceVO.class , "sheet1_");
			
			if(arrVIEActInvoiceList != null) {
				vieActInvoiceList = Arrays.asList(arrVIEActInvoiceList);
				
				for (int i=0; i<vieActInvoiceList.size(); i++) {
					VIEActInvoiceVO vieActInvoiceVO = vieActInvoiceList.get(i);
					
					vieActInvoiceVO.setUpdUsrId(updUsrId);
				}
			}
			
			event.setVieActInvoiceVOs((VIEActInvoiceVO[])vieActInvoiceList.toArray(new VIEActInvoiceVO[vieActInvoiceList.size()]));
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