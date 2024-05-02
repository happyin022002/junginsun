/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : BCM_CMS_0305HTMLAction.java
*@FileTitle : CustomerGroup 
*Open Issues :
*Change history :
*@LastModifyDate : 2012-02-21
*@LastModifier : Lim Jaekwan
*@LastVersion : 1.0
* 2012-02-21 Lim Jaekwan
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.event.BcmCms0301Event;
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
 * @see BcmCms0301Event , BcmCms0301EventResponse 참조
 * @since J2EE 1.4
 */
public class BCM_CMS_0305HTMLAction extends HTMLActionSupport {

    /**
     * BCM_CMS_0301HTMLAction 객체를 생성
     */
    public BCM_CMS_0305HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 BCM_CMS_0305Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        
    	// 메인화면에서 Vessel팝업 버튼을 클릭 또는 Retrieve 버튼 클릭했을 경우   	
    	String cust_cd      = JSPUtil.getParameter(request, "cust_cd".trim(), "");
    	String cust_nm      = JSPUtil.getParameter(request, "cust_nm".trim(), "");
    	String ofc_cd       = JSPUtil.getParameter(request, "ofc_cd".trim(), "");
    	String include      = JSPUtil.getParameter(request, "include".trim(), "");
    	String cust         = JSPUtil.getParameter(request, "cust".trim(), "");
    	String zip_cd       = JSPUtil.getParameter(request, "zip_cd".trim(), "");
    	String cust_grp_id  = JSPUtil.getParameter(request, "cust_grp_id".trim(), "");
    	String loc_cd  		= JSPUtil.getParameter(request, "loc_cd".trim(), "");
    	String ste_cd  		= JSPUtil.getParameter(request, "ste_cd".trim(), "");
    	String srep_cd  	= JSPUtil.getParameter(request, "srep_cd".trim(), "");
    	String delt_flg     = JSPUtil.getParameter(request, "delt_flg".trim(), "");
    	String cust_locl_lang_nm = JSPUtil.getParameter(request, "cust_locl_lang_nm".trim(), "");
    	String cust_rgst_no = JSPUtil.getParameter(request, "cust_rgst_no".trim(), "");
    	       
    	int iPage           = JSPUtil.getParameterAsInt(request, "iPage", 1);
    	
    	FormCommand f_cmd = FormCommand.fromRequest(request);
    	
    	log.debug("iPage : " + iPage + ", Request iPage :" + JSPUtil.getParameter(request, "iPage"));
    	
    	BcmCms0305Event event = new BcmCms0305Event(cust_cd, cust_nm, ofc_cd, iPage, include, cust, zip_cd, cust_grp_id, loc_cd, ste_cd, srep_cd, cust_locl_lang_nm, cust_rgst_no, delt_flg);            	
    	
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