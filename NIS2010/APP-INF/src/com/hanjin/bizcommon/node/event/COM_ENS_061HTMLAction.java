/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_061HTMLAction.java
*@FileTitle : Node 조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-17
*@LastModifier : Hyung Choon
*@LastVersion : 1.0
* 2006-08-17 Hyung Choon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.node.event;

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
 * - Parsing 한 정보를 Event로 변환, request에 담아 BIZCOMMONSC로 실행요청<br>
 * - BIZCOMMONSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Hyung Choon
 * @see ComEns061Event , COM_ENS_061EventResponse 참조
 * @since J2EE 1.4
 */
public class COM_ENS_061HTMLAction extends HTMLActionSupport {

    /**
     * COM_ENS_061HTMLAction 객체를 생성
     */
    public COM_ENS_061HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 COM_ENS_061Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        
    	// 메인화면에서 Vessel팝업 버튼을 클릭 또는 Retrieve 버튼 클릭했을 경우
    	String cnt_cd       = JSPUtil.getParameter(request, "cnt_cd", "");
    	String loc_cd   	= JSPUtil.getParameter(request, "loc_cd", "");
    	String ofc_cd       = JSPUtil.getParameter(request, "ofc_cd", "");
    	String node_cd      = JSPUtil.getParameter(request, "node_cd", "");
    	String node_nm      = request.getParameter("node_nm");//        JSPUtil.getParameter(request, "node_nm", "");
    	String mode			= JSPUtil.getParameter(request, "mode", "");
    	String scc_cd		= JSPUtil.getParameter(request, "scc_cd", "");
    	if(mode == null || mode.equals("")) {
    		mode = "yard";
    	}
    	
    	String mode_only		= JSPUtil.getParameter(request, "mode_only".trim(), "N");
    	
    	int iPage           = JSPUtil.getParameterAsInt(request, "iPage", 1);  
    	
    	FormCommand f_cmd = FormCommand.fromRequest(request);
    	
    	ComEns061Event event = new ComEns061Event(cnt_cd, loc_cd, ofc_cd, node_cd, node_nm, mode, mode_only, scc_cd,iPage);
                 
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