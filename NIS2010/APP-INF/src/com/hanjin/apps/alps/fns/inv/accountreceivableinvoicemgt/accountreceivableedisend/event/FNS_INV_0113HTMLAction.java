/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0113HTMLAction.java
*@FileTitle : EDI Glovis Submission
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.25
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.08.09 이석준
* 1.0 Creation
* History
* 2011.11.30 권 민 [CHM-201114839] [INV] Glovis Invoice EDI 전송 기능 보완
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.GlovisInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.GlovisInputVO;
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
 * @author Choi Do Soon
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.6
 */

public class FNS_INV_0113HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0111HTMLAction 객체를 생성
	 */
	public FNS_INV_0113HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0113Event event = new FnsInv0113Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setGlovisInputVO((GlovisInputVO)getVO(request, GlovisInputVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			String btn_flag = request.getParameter("btn_flag");
			GlovisInvoiceEdiVO[] glovisInvoiceEdiVOs = (GlovisInvoiceEdiVO[])getVOs(request, GlovisInvoiceEdiVO.class, "sheet1_");
			event.setBtnflag(btn_flag);
			for (int i=0;i<glovisInvoiceEdiVOs.length;i++){
				glovisInvoiceEdiVOs[i].setCustSeq(request.getParameter("act_cust_seq"));
				glovisInvoiceEdiVOs[i].setCustCd(request.getParameter("act_cust_cnt_cd"));		
				glovisInvoiceEdiVOs[i].setCustNm(request.getParameter("cust_nm"));	
				glovisInvoiceEdiVOs[i].setCustEml(request.getParameter("cust_eml"));	
				glovisInvoiceEdiVOs[i].setIoBndCd(request.getParameter("io_bnd_cd"));
				glovisInvoiceEdiVOs[i].setUsrId(request.getParameter("usr_id"));	
				glovisInvoiceEdiVOs[i].setUsrEml(request.getParameter("usr_eml"));	
				glovisInvoiceEdiVOs[i].setEdiType(request.getParameter("edi_type"));	
				glovisInvoiceEdiVOs[i].setArOfcCd(request.getParameter("ar_ofc_cd"));
			}
			event.setGlovisInvoiceEdiVOs(glovisInvoiceEdiVOs);
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
	
	/**
	 * 입력된 값의 null 여부를 체크하여 boolean 으로 리턴한다.
	 * 
	 * @param String str
	 * @return boolean
	 */
	public boolean isNull(String str) {
        return (str==null || str.trim().length()==0 || "null".equals(str));
    }
}