/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : BCM_CMS_0304HTMLAction.java
*@FileTitle : customer
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

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.bcm.cms.commoncode 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 commoncodeSC로 실행요청<br>
 * - commoncodeSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see commoncodeEvent 참조
 * @since J2EE 1.6
 */

public class BCM_CMS_0304HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * BCM_CMS_0304HTMLAction 객체를 생성
	 */
	public BCM_CMS_0304HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 commoncodeEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
        
    	// 메인화면에서 Vessel팝업 버튼을 클릭 또는 Retrieve 버튼 클릭했을 경우   	
    	String cust_cnt_cd  = JSPUtil.getParameter(request, "cust_cnt_cd".trim(), "");
    	String cust_nm      = JSPUtil.getParameter(request, "cust_nm".trim(), "");
    	String loc_cd       = JSPUtil.getParameter(request, "loc_cd".trim(), "");
    	String cust_rgst_no = JSPUtil.getParameter(request, "cust_rgst_no".trim(), "");
    	String match_rule   = JSPUtil.getParameter(request, "match_rule".trim(), "");

    	int iPage           = JSPUtil.getParameterAsInt(request, "iPage", 1);
    	
    	FormCommand f_cmd = FormCommand.fromRequest(request);
    	
    	log.debug("iPage : " + iPage + ", Request iPage :" + JSPUtil.getParameter(request, "iPage"));
    	
    	BcmCms0304Event event = new BcmCms0304Event(cust_cnt_cd, cust_nm, loc_cd, cust_rgst_no, match_rule, iPage);            	
    	
        event.setCommandClassName("CustManageSC");
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