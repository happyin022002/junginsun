/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1159HTMLAction.java
*@FileTitle : Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.21
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.05.21 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SearchCustomerInqryCondVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.bizcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BizCommonSC로 실행요청<br>
 * - BizCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author sangyool pak
 * @see EsmBkg1159Event , ESM_BKG_1159EventResponse 참조
 * @since J2EE 1.4
 */
public class ESM_BKG_1159HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
    /**
     * ESM_BKG_1159HTMLAction 객체를 생성
     */
    public ESM_BKG_1159HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 ESM_BKG_1159Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1159Event event = new EsmBkg1159Event();
		if(command.isCommand(FormCommand.SEARCH)) {
    	// 메인화면에서 Vessel팝업 버튼을 클릭 또는 Retrieve 버튼 클릭했을 경우   	
//    	String cust_cd      = JSPUtil.getParameter(request, "cust_cd".trim(), "");
//    	String cust_nm      = JSPUtil.getParameter(request, "cust_nm".trim(), "");
//    	String ofc_cd       = JSPUtil.getParameter(request, "ofc_cd".trim(), "");
//    	String include       = JSPUtil.getParameter(request, "include".trim(), "");
//    	String cust       = JSPUtil.getParameter(request, "cust".trim(), "");
    	       
    	int iPage           = JSPUtil.getParameterAsInt(request, "iPage", 1);
    	
    	event.setCustCd(request.getParameter("cust_cd"));
    	event.setCust(request.getParameter("cust"));
    	event.setIPage(iPage);
    	event.setSearchCustomerInqryCondVO((SearchCustomerInqryCondVO)getVO(request,SearchCustomerInqryCondVO .class ));
//		event.setCustSeq(request.getParameter("cust_seq"));
//		event.setCustNm(request.getParameter("cust_nm"));
//		event.setOfcCd(request.getParameter("ofc_cd"));

    	
//    	FormCommand f_cmd = FormCommand.fromRequest(request);
    	
    	log.debug("iPage : " + iPage + ", Request iPage :" + JSPUtil.getParameter(request, "iPage"));
    	
//    	EsmBkg1159Event event = new EsmBkg1159Event(cust_cd, cust_nm, ofc_cd, iPage, include, cust);            	
    	
//        event.setCommandClassName("GeneralBookingConductSC");
//        event.setFormCommand(f_cmd);
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