/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : BCM_CCD_0039HTMLAction.java
*@FileTitle : credit customer
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CreateMdmCustRepVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CreditCustomerVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerAddressVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.bcm.ccd.commoncode 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 commoncodeSC로 실행요청<br>
 * - commoncodeSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see commoncodeEvent 참조
 * @since J2EE 1.6
 */

public class BCM_CMS_0311HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * BCM_CCD_0039HTMLAction 객체를 생성
	 */
	public BCM_CMS_0311HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 commoncodeEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		BcmCms0311Event event = new BcmCms0311Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setCreditCustomerVO((CreditCustomerVO)getVO(request, CreditCustomerVO.class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setCreditCustomerVO((CreditCustomerVO)getVO(request, CreditCustomerVO.class));
			event.setCreateMdmCustRepVOS((CreateMdmCustRepVO[])getVOs(request, CreateMdmCustRepVO .class,"t2bsheet2_"));
			
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setCrCltOfcCd(request.getParameter("cr_clt_ofc_cd"));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setCrCurrCd(request.getParameter("cr_curr_cd"));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setActCustCd(request.getParameter("act_cust_cd"));
		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setCustCd(request.getParameter("cust_cd"));
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