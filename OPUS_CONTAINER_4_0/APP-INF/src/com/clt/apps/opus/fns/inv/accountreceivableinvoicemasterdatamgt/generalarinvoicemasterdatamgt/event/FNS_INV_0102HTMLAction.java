/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0102HTMLAction.java
*@FileTitle : Code Conversion for CPR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.28 한동훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import javax.servlet.http.HttpServletRequest;


import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvCprtCdConvVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Dong Hoon
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.6
 */

public class FNS_INV_0102HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0102HTMLAction 객체를 생성
	 */
	public FNS_INV_0102HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0102Event event = new FnsInv0102Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			String scNo = request.getParameter("sc_no");			
			String rfaNO = request.getParameter("rfa_no");
			String codeTy = request.getParameter("cdTp");
			
			event.setScNo(scNo);
			event.setRfaNO(rfaNO);
			event.setCodeTy(codeTy);	
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			String scNo = request.getParameter("sc_no");			
			String rfaNO = request.getParameter("rfa_no");
			event.setScNo(scNo);
			event.setRfaNO(rfaNO);
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			String copyGb = request.getParameter("copy_gb");			
			String copyText = request.getParameter("copy_text");
			
			String scNo = "";
			String rfaNO =  "";
			if(copyGb.equals("S")){
				scNo = copyText;
				rfaNO = "X";
			}else{
				scNo = "X";
				rfaNO = copyText;
			}			
			event.setScNo(scNo);
			event.setRfaNO(rfaNO);
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			String cdTp = request.getParameter("cdTp");
			String cd = request.getParameter("cd");
			event.setCdTp(cdTp);
			event.setCd(cd);	
		}else if(command.isCommand(FormCommand.MULTI)) {
			//event.setInvCprtCdConvVO((InvCprtCdConvVO)getVO(request, InvCprtCdConvVO .class));
			event.setInvCprtCdConvVOs((InvCprtCdConvVO[])getVOs(request, InvCprtCdConvVO .class,""));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setInvCprtCdConvVOs((InvCprtCdConvVO[])getVOs(request, InvCprtCdConvVO .class,"sheet1_"));
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