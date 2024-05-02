/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : STM_SAR_9999HTMLAction.java
*@FileTitle : batch & Interface execute
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.15
*@LastModifier : myoungsin park
*@LastVersion : 1.0
* 2015.01.15 myoungsin park
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author myoungsin park
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.6
 */

public class STM_SAR_9999HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0086HTMLAction 객체를 생성
	 */
	public STM_SAR_9999HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	//FormCommand command = FormCommand.fromRequest(request);
		StmSar9999Event event = new StmSar9999Event();
		
		event.setRateYm(request.getParameter("rate_ym"));
		event.setIfNo(request.getParameter("if_no"));
		event.setAdjNo(request.getParameter("adj_no"));
		event.setOffsetNo(request.getParameter("offset_no")); 
		event.setReceiptNo(request.getParameter("receipt_no"));
		event.setAsaNo(request.getParameter("asa_no"));  
		event.setArHdQtrOfcCd(request.getParameter("ar_hd_qtr_ofc_cd"));   
		event.setOfcCd(request.getParameter("ofc_cd"));    
		event.setMissDt(request.getParameter("miss_dt"));    
		event.setMissSlan(request.getParameter("miss_slan"));    
		event.setMissVvd(request.getParameter("miss_vvd"));    
		event.setMigDt(request.getParameter("mig_dt"));    
		event.setMigVvd(request.getParameter("mig_vvd"));  
		event.setOtsIfNo(request.getParameter("ots_if_no"));
		
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
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}