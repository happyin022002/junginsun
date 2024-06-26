/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0028HTMLAction.java
*@FileTitle : Invoice Data Manual Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.07 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BkgNoCaNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ManualInputVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Dosoon Choi
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.4
 */

public class FNS_INV_0028HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0028HTMLAction 객체를 생성
	 */
	public FNS_INV_0028HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0028Event event = new FnsInv0028Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			BkgNoCaNoVO[] bkgNoCaNoVOs = (BkgNoCaNoVO[]) getVOs(request, BkgNoCaNoVO.class,"sheet1_");			
			event.setBkgNoCaNoVOs(bkgNoCaNoVOs);
			event.setBkgNo(request.getParameter("bkg_no"));
			event.setVvd(request.getParameter("vvd"));
			event.setPol(request.getParameter("pol"));
			event.setPod(request.getParameter("pod"));
			event.setArIfNo(request.getParameter("ar_if_no"));
			event.setManDivInd(request.getParameter("man_div_ind"));
			
		} else if (command.isCommand(FormCommand.SEARCH01)) {
			ManualInputVO manualInputVO = new ManualInputVO();
			
			manualInputVO.setTrnkVvd(request.getParameter("trnk_vvd"));
			manualInputVO.setPodCd(request.getParameter("pod_cd"));
			manualInputVO.setPolCd(request.getParameter("pol_cd"));
			manualInputVO.setFmIfDt(request.getParameter("fm_if_dt"));	
			manualInputVO.setToIfDt(request.getParameter("to_if_dt"));	
			manualInputVO.setBlSrcNo(request.getParameter("bl_src_no"));
			
			event.setManualInputVO(manualInputVO);
		} else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setBackEndJobKey(request.getParameter("backendjob_key"));

		} else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setBackEndJobKey(request.getParameter("backendjob_key"));
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