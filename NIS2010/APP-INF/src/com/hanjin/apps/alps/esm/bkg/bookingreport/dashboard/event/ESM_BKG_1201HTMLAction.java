/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : ESM_BKG_1201HTMLAction.java
 *@FileTitle : Dashboard
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.10.17
 *@LastModifier : Poong-yeon Cho
 *@LastVersion : 1.0
 * 2009.06.01 Poong-yeon Cho
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 =========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.CommonWebKeys;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * HTTP Parser<br>
 * @author Kim Gyoung Sub
 * @see EsmBkg1201Event 참조
 * @since J2EE 1.5
 */

public class ESM_BKG_1201HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * ESM_BKG_0066HTMLAction 객체를 생성
     */
    public ESM_BKG_1201HTMLAction() {}

    /**
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

//		FormCommand command = FormCommand.fromRequest(request);

		EsmBkg1201Event event = new EsmBkg1201Event();
		SignOnUserAccount account = (SignOnUserAccount)request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        String userId=account.getUsr_id();
		
        event.putValue("s_kind", (JSPUtil.getNull(request.getParameter("s_kind"))));
	    event.putValue("f_bkg_ofc_cd", (JSPUtil.getNull(request.getParameter("f_bkg_ofc_cd"))));
	    event.putValue("f_sub_bkg_ofc_cd", (JSPUtil.getNull(request.getParameter("f_sub_bkg_ofc_cd"))));
	    event.putValue("f_bkg_no", (JSPUtil.getNull(request.getParameter("f_bkg_no"))));
	    event.putValue("f_vvd", (JSPUtil.getNull(request.getParameter("f_vvd"))));
	    event.putValue("f_pol_nod_cd", (JSPUtil.getNull(request.getParameter("f_pol_nod_cd"))));
	    event.putValue("f_pod_nod_cd", (JSPUtil.getNull(request.getParameter("f_pod_nod_cd"))));
	    event.putValue("f_rhq_cd", (JSPUtil.getNull(request.getParameter("f_rhq_cd"))));
	    event.putValue("f_rep_id", (JSPUtil.getNull(request.getParameter("f_rep_id"))));
	    event.putValue("f_staff_id", (JSPUtil.getNull(request.getParameter("f_staff_id"))));
	    event.putValue("f_cust_kind_cd", (JSPUtil.getNull(request.getParameter("f_cust_kind_cd"))));
	    event.putValue("f_grp_cust_kind_cd", (JSPUtil.getNull(request.getParameter("f_grp_cust_kind_cd"))));
	    event.putValue("f_grp_cust_cd", (JSPUtil.getNull(request.getParameter("f_grp_cust_cd"))));
		event.putValue("f_usr_id", userId);
		
        event.putValue("combo_cust", (JSPUtil.getNull(request.getParameter("combo_cust"))));
        event.putValue("f_cust_cd", (JSPUtil.getNull(request.getParameter("f_cust_cd"))));
        event.putValue("combo_gcust", (JSPUtil.getNull(request.getParameter("combo_gcust"))));
        event.putValue("f_gcust_cd", (JSPUtil.getNull(request.getParameter("f_gcust_cd"))));
        event.putValue("combo_ctrt", (JSPUtil.getNull(request.getParameter("combo_ctrt"))));
        event.putValue("f_ctrt_no", (JSPUtil.getNull(request.getParameter("f_ctrt_no"))));
        event.putValue("f_rpt_fom_no", (JSPUtil.getNull(request.getParameter("f_rpt_fom_no"))));
		
        event.putValue("f_dbd_cre_dt", (JSPUtil.getNull(request.getParameter("f_dbd_cre_dt"))));
        event.putValue("f_dbd_cre_seq", (JSPUtil.getNull(request.getParameter("f_dbd_cre_seq"))));
        event.putValue("f_dest_cnt_cd", (JSPUtil.getNull(request.getParameter("f_dest_cnt_cd"))));
        event.putValue("f_irr_tp_cd", (JSPUtil.getNull(request.getParameter("f_irr_tp_cd"))));
        event.putValue("s_bkg_ofc_cd", (JSPUtil.getNull(request.getParameter("s_bkg_ofc_cd"))));
        
		request.setAttribute("Event", event);

		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param eventResponse
	 *            EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param event
	 *            Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}