/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_CCD_0004HTMLAction.java
*@FileTitle : LeasingCompanyYard
*Open Issues :
*Change history :
*@LastModifyDate : 2012-02-16
*@LastModifier : Kim Min Soo
*@LastVersion : 1.0
* 2006-10-16 Kim Min Soo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.leasingcompanyyard.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.bizcommon.leasingcompanyyard.vo.SearchLeasingCompanyYardListVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.bizcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BIZCOMMONSC로 실행요청<br>
 * - BIZCOMMONSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Kim Min Soo
 * @see ComCom0004Event , COM_COM_0004EventResponse 참조
 * @since J2EE 1.4
 */
public class COM_COM_0004HTMLAction extends HTMLActionSupport {
	/**
	 * COM_ENS_0J1HTMLAction 객체를 생성
	 */
	public COM_COM_0004HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 COM_COM_0004Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		ComCom0004Event event = new ComCom0004Event();
//    	String lse_co_yd_cd        = JSPUtil.getParameter(request, "lse_co_yd_cd".trim(), "");
//    	String lse_co_yd_nm        = JSPUtil.getParameter(request, "lse_co_yd_nm".trim(), "");
    	String mdm_yn        = JSPUtil.getParameter(request, "mdm_yn".trim(), "");
    	
    	String delt_flg = "";
    	if("Y".equals(mdm_yn)){
    		delt_flg        = JSPUtil.getParameter(request, "delt_flg".trim(), "N");
    	}else{
    		delt_flg        = JSPUtil.getParameter(request, "delt_flg".trim(), "");
    	}
    	
    	int iPage           = JSPUtil.getParameterAsInt(request, "iPage", 1);  
    	
    	FormCommand f_cmd = FormCommand.fromRequest(request);
    	
    	event = new ComCom0004Event(mdm_yn, delt_flg, iPage);
    	
    	event.setSearchLeasingCompanyYardListVO((SearchLeasingCompanyYardListVO)getVO(request, SearchLeasingCompanyYardListVO .class));
                 
        event.setCommandClassName("BizCommonSC");
        event.setFormCommand(f_cmd);
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