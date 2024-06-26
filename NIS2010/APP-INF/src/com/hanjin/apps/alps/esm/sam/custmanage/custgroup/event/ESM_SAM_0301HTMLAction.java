/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : ESM_SAM_0301HTMLAction.java
*@FileTitle : CustomerGroup
*Open Issues :
*Change history :
*@LastModifyDate : 2017-07-12
*@LastModifier : Lim Jaekwan
*@LastVersion : 1.0
* 2017-07-12 Lim Jaekwan
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custgroup.event;

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
 * @author Lim Jaekwan
 * @see EsmSam0301Event , EsmSam0301EventResponse 참조
 * @since J2EE 1.4
 */
public class ESM_SAM_0301HTMLAction extends HTMLActionSupport {

    /**
     * ESM_SAM_0301HTMLAction 객체를 생성
     */
    public ESM_SAM_0301HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 ESM_SAM_0301Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        
    	//팝업 버튼을 클릭 또는 Retrieve 버튼 클릭했을 경우
    	String cust_grp_id      = JSPUtil.getParameter(request, "cust_grp_id".trim(), "");
    	String cust_grp_nm      = JSPUtil.getParameter(request, "cust_grp_nm".trim(), "");
    	String ofc_cd       = JSPUtil.getParameter(request, "ofc_cd".trim(), "");
    	String mdm_yn       = JSPUtil.getParameter(request, "mdm_yn".trim(), "");
    	String delt_flg       = JSPUtil.getParameter(request, "delt_flg".trim(), "");
    	String cust_grp_abbr_nm       = JSPUtil.getParameter(request, "cust_grp_abbr_nm".trim(), "");
    	       
    	int iPage           = JSPUtil.getParameterAsInt(request, "iPage", 1);
    	
    	FormCommand f_cmd = FormCommand.fromRequest(request);
    	
    	log.debug("iPage : " + iPage + ", Request iPage :" + JSPUtil.getParameter(request, "iPage"));
    	
    	EsmSam0301Event event = new EsmSam0301Event(cust_grp_id, cust_grp_nm, ofc_cd, iPage, mdm_yn, delt_flg,cust_grp_abbr_nm);            	
    	
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