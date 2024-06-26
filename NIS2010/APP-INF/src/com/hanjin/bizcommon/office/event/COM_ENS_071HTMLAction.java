/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_071HTMLAction.java
*@FileTitle : Office 조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-02
*@LastModifier : Hyunsu, Ryu
*@LastVersion : 1.0
* 2006-08-02 Hyunsu, Ryu
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.office.event;

import javax.servlet.http.HttpServletRequest;

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
 * @author Hyunsu, Ryu
 * @see ComEns071Event , COM_ENS_071EventResponse 참조
 * @since J2EE 1.4
 */
public class COM_ENS_071HTMLAction extends HTMLActionSupport {

    /**
     * COM_ENS_071HTMLAction 객체를 생성
     */
    public COM_ENS_071HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 COM_ENS_071Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        
        /* 
         ibSheet 사용시 fromRequestGrid를 사용하는데 
         prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 ) 
         String prefix = "" ;  
         OFFICE office = OFFICE.fromRequestGrid(request, prefix);
        */ 
    	
    	
    	// 메인화면에서 Vessel팝업 버튼을 클릭 또는 Retrieve 버튼 클릭했을 경우
    	String loc_cd      = JSPUtil.getParameter(request, "loc_cd".trim(), "");
    	String ofc_lev      = JSPUtil.getParameter(request, "ofc_lev".trim(), "");
    	String ofc_pts_cd  	= JSPUtil.getParameter(request, "ofc_pts_cd".trim(), "");
    	String ofc_cd       = JSPUtil.getParameter(request, "ofc_cd".trim(), "");
    	String ofc_nm       = JSPUtil.getParameter(request, "ofc_nm".trim(), "");
    	String calltype     = JSPUtil.getParameter(request, "CallType".trim(), "");
    	String ofc_addr     = JSPUtil.getParameter(request, "ofc_addr".trim(), "");
    	
    	int iPage           = JSPUtil.getParameterAsInt(request, "iPage", 1);  
    	
    	FormCommand f_cmd = FormCommand.fromRequest(request);
    	
    	log.debug("iPage : " + iPage + ", Request iPage :" + JSPUtil.getParameter(request, "iPage"));
    	
        ComEns071Event event = new ComEns071Event(loc_cd, ofc_lev, ofc_pts_cd, ofc_cd, ofc_nm, calltype, iPage,ofc_addr ); // table value object
          
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