/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0914HTMLAction.java
*@FileTitle : ACTUAL CUSTOMER POPUP
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-09
*@LastModifier : eunhee
*@LastVersion : 1.0
* 2009-09-03 eunhee
* 1.0 최초 생성
* -----------------------------------------------------------------
* History
* 2012.05.08 김종호 [CHM-201217449] [TRS] Additional 칼럼, Other S/O creation 화면 입력기능 일부 변경 : Actual Customer 자동 조회 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.actualcustomerpopup.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport; 
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.othersomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ActualCustomerSC로 실행요청<br>
 * - ActualCustomerSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author eunhee
 * @see EsdTrs0914Event 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0914HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_935HTMLAction 객체를 생성
	 */
	public ESD_TRS_0914HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdTrs0914Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0914Event event = null;
		
		if(command.isCommand(FormCommand.SEARCH07)){
			/* ACTUAL CUSTOMER POPUP : Header List	*/
			event = new EsdTrs0914Event();
			String dor_nod_cd = JSPUtil.getParameter(request, "dor_nod_cd", "");//Door Node
			String act_cust_cd = JSPUtil.getParameter(request, "act_cust_cd", "");//Customer Code
			String fctry_nm = JSPUtil.getParameter(request, "fctry_nm", "");//Factory Name		
			String bound_cd = JSPUtil.getParameter(request, "BOUND_CD", "");//BND -Main화면에서 넘겨 받음.
			String conti_cd = JSPUtil.getParameter(request, "CONTI_CD", "");//fm_loc_conti_cd -Main화면에서 넘겨 받음.
	
			event.setDor_nod_cd(dor_nod_cd);
			event.setAct_cust_cd(act_cust_cd);
			event.setFctry_nm(fctry_nm);
			event.setBound_cd(bound_cd);
			event.setConti_cd(conti_cd);			
		}else if(command.isCommand(FormCommand.SEARCH08)){
			/* ACTUAL CUSTOMER POPUP : Detail List	*/	
			event = new EsdTrs0914Event();
			String act_cust_cnt_cd = JSPUtil.getParameter(request, "ACT_CUST_CNT_CD", "");			
			String act_cust_seq = JSPUtil.getParameter(request, "ACT_CUST_SEQ", "");
			String usa_trsp_act_cust_no = JSPUtil.getParameter(request, "USA_TRSP_ACT_CUST_NO", "");
			String conti_cd = JSPUtil.getParameter(request, "CONTI_CD", "");//fm_loc_conti_cd -Main화면에서 넘겨 받음.
			
			event.setAct_cust_cnt_cd(act_cust_cnt_cd);
			event.setAct_cust_seq(act_cust_seq);
			event.setUsa_trsp_act_cust_no(usa_trsp_act_cust_no);
			event.setConti_cd(conti_cd);
		}else if(command.isCommand(FormCommand.SEARCH09)){
			/* ACTUAL CUSTOMER Name	*/
			event = new EsdTrs0914Event();
			String act_cust_cd = JSPUtil.getParameter(request, "act_cust_cd", "");//Customer Code
			event.setAct_cust_cd(act_cust_cd);
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