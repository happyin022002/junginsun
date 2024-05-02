/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0072HTMLAction.java
*@FileTitle : Cut-off VVD Entry for New A/R Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.05 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvCutOffLaneVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicemasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Dong Hoon
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.6
 */

public class FNS_INV_0072HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0072HTMLAction 객체를 생성
	 */
	public FNS_INV_0072HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0072Event event = new FnsInv0072Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setInvCutOffLaneVOS((InvCutOffLaneVO[])getVOs(request, InvCutOffLaneVO .class,""));
		}else if(command.isCommand(FormCommand.SEARCH)) {
			event.setOldOfc(request.getParameter("old_ar_ofc_cd"));
			event.setNewOfc(request.getParameter("new_ar_ofc_cd"));
			event.setInvCutOffLaneVO((InvCutOffLaneVO)getVO(request, InvCutOffLaneVO .class));
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSlanCd(request.getParameter("slan_cd"));
			event.setInvCutOffLaneVO((InvCutOffLaneVO)getVO(request, InvCutOffLaneVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setPortCd(request.getParameter("port_cd"));
			event.setInvCutOffLaneVO((InvCutOffLaneVO)getVO(request, InvCutOffLaneVO .class));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setVslCd(request.getParameter("vsl_cd"));
			event.setSkdVoyNo(request.getParameter("skd_voy_no"));
			event.setSkdDirCd(request.getParameter("skd_dir_cd"));
			event.setPortCd(request.getParameter("port_cd"));
			event.setIoBndCd(request.getParameter("io_bnd_cd"));
			event.setInvCutOffLaneVO((InvCutOffLaneVO)getVO(request, InvCutOffLaneVO .class));
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