/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_INV_0029HTMLAction.java
 *@FileTitle : Manual System Clear
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.04
 *@LastModifier : 한동훈
 *@LastVersion : 1.0
 * 2009.06.04 한동훈
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.SysClearVO;
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
 * 
 * @author Han Dong Hoon
 * @see AccountReceivableInvoiceMgtEvent 참조
 * @since J2EE 1.6
 */

public class FNS_INV_0029HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * FNS_INV_0029HTMLAction 객체를 생성
	 */
	public FNS_INV_0029HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		FnsInv0029Event event = new FnsInv0029Event();

		if (command.isCommand(FormCommand.MULTI)) {
			SysClearVO sysClearVo = new SysClearVO();
			
			sysClearVo.setOfcCd(request.getParameter("ofc_cd"));
			sysClearVo.setBlNo(request.getParameter("bl_src_no"));
			sysClearVo.setVvdCd(request.getParameter("vvd_cd"));
			sysClearVo.setCustCd(request.getParameter("cust_cd"));
			sysClearVo.setOtsSmryCd(request.getParameter("ots_smry_cd"));
			
			event.setSysClearVo(sysClearVo);
		}else if(command.isCommand(FormCommand.MULTI01)){
			SysClearVO sysClearVo = new SysClearVO();
			
			sysClearVo.setIfNo1(request.getParameter("if_no1"));
			sysClearVo.setIfNo2(request.getParameter("if_no2"));
			sysClearVo.setIfNo3(request.getParameter("if_no3"));
			sysClearVo.setIfNo4(request.getParameter("if_no4"));
			sysClearVo.setIfNo5(request.getParameter("if_no5"));
			sysClearVo.setIfNo6(request.getParameter("if_no6"));
			sysClearVo.setOfcCd(request.getParameter("ofc_cd"));
			sysClearVo.setOtsSmryCd(request.getParameter("ots_smry_cd"));
			
			event.setSysClearVo(sysClearVo);
		}

		request.setAttribute("Event", event);

		return event;
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