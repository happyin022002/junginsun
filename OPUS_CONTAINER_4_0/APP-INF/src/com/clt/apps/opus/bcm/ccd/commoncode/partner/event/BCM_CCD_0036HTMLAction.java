/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BCM_CCD_0036HTMLAction.java
*@FileTitle : customer address
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerAddressVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerPerformanceVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.bcm.ccd.commoncode 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 commoncodeSC로 실행요청<br>
 * - commoncodeSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see commoncodeEvent 참조
 * @since J2EE 1.6
 */

public class BCM_CCD_0036HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * BCM_CCD_0036HTMLAction 객체를 생성
	 */
	public BCM_CCD_0036HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 commoncodeEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		BcmCcd0036Event event = new BcmCcd0036Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setCustomerAddressVO((CustomerAddressVO)getVO(request, CustomerAddressVO .class,""));
		}else if(command.isCommand(FormCommand.MULTI)) {
				event.setCustomerAddressVOS((CustomerAddressVO[])getVOs(request, CustomerAddressVO .class,"sheet1_"));
				event.setMdmCustomerVOS((MdmCustomerVO[])getVOs(request, MdmCustomerVO.class,"sheet1_"));
				String custCntCd = JSPUtil.getParameter(request, "cust_cnt_cd");
				event.setCustCntCd(custCntCd);	
				String custSeq = JSPUtil.getParameter(request, "cust_seq");
				event.setCustSeq(custSeq);
				String addrTpCd = JSPUtil.getParameter(request, "addr_tp_cd");
				event.setAddrTpCd(addrTpCd);
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setCustCd(request.getParameter("cust_cd"));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setCntCd(request.getParameter("cnt_cd"));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setSteCd(request.getParameter("ste_cd"));
		}
//		else if(command.isCommand(FormCommand.SEARCH01)){
//		}

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