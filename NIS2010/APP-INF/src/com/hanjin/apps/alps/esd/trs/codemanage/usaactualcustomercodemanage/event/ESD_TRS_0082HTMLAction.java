/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_082HTMLAction.java
*@FileTitle : USA Actual Customer Code Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2007-10-16
*@LastModifier : Kim Jun Ho
*@LastVersion : 1.0
* 2007-10-16 Kim Jun Ho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.usaactualcustomercodemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsTrspUsaActCustDtlVO;
import com.hanjin.syscommon.common.table.TrsTrspUsaActCustVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.codemanage.usaactualcustomercodemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CodeManageSCSC로 실행요청<br>
 * - CodeManageSCSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Kim Jun Ho
 * @see EsdTrs0082Event , ESD_TRS_082EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0082HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_082HTMLAction 객체를 생성 
	 */
	public ESD_TRS_0082HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_082Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);

		TrsTrspUsaActCustVO trsTrspUsaActCustVO   = new TrsTrspUsaActCustVO();
		TrsTrspUsaActCustDtlVO trsTrspUsaActCustDtlVO = new TrsTrspUsaActCustDtlVO();
		TrsTrspUsaActCustVO[] tcz = null; 
		TrsTrspUsaActCustDtlVO[] tczDtl = null; 

		if(command.isCommand(FormCommand.MULTI) || command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.MULTI02)) {
			trsTrspUsaActCustVO.fromRequest(request);
			trsTrspUsaActCustDtlVO.fromRequest(request);
			tcz = trsTrspUsaActCustVO.fromRequestGrid(request);
			tczDtl = trsTrspUsaActCustDtlVO.fromRequestGrid(request);
		}
		
		EsdTrs0082Event event = new EsdTrs0082Event();

		String act_cust_cnt_cd = request.getParameter("act_cust_cnt_cd")!=null?request.getParameter("act_cust_cnt_cd"):"";
		String act_cust_bnd_cd = request.getParameter("act_cust_bnd_cd")!=null?request.getParameter("act_cust_bnd_cd"):"";
		String dor_nod_cd = request.getParameter("dor_nod_cd")!=null?request.getParameter("dor_nod_cd"):"";
		String status = request.getParameter("status")!=null?request.getParameter("status"):"";
		String bound = request.getParameter("bound")!=null?request.getParameter("bound"):"";
		String dor_loc = request.getParameter("dor_loc")!=null?request.getParameter("dor_loc"):"";
		String dor_nod = request.getParameter("dor_nod")!=null?request.getParameter("dor_nod"):"";
		String input_cust_cd = request.getParameter("input_cust_cd")!=null?request.getParameter("input_cust_cd"):"";
		String input_cust_nm = request.getParameter("input_cust_nm")!=null?request.getParameter("input_cust_nm"):"";
		String input_cre_ofc_cd = request.getParameter("input_cre_ofc_cd")!=null?request.getParameter("input_cre_ofc_cd"):"";
		String sel_trsp_act_cust_no = request.getParameter("sel_trsp_act_cust_no")!=null?request.getParameter("sel_trsp_act_cust_no"):"";
		
		String mst_dtl_indicator = request.getParameter("mst_dtl_indicator")!=null?request.getParameter("mst_dtl_indicator"):"";
		String login_ofc_cd = request.getParameter("login_ofc_cd")!=null?request.getParameter("login_ofc_cd"):"";
		String login_usr_id = request.getParameter("login_usr_id")!=null?request.getParameter("login_usr_id"):"";
		String login_date = request.getParameter("login_date")!=null?request.getParameter("login_date"):"";

		event.setAct_cust_cnt_cd(act_cust_cnt_cd);
		event.setAct_cust_bnd_cd(act_cust_bnd_cd);
		event.setDor_nod_cd(dor_nod_cd);
		event.setStatus(status);
		event.setBound(bound);
		event.setDor_loc(dor_loc);
		event.setDor_nod(dor_nod);
		event.setInput_cust_cd(input_cust_cd);
		event.setInput_cust_nm(input_cust_nm);
		event.setInput_cre_ofc_cd(input_cre_ofc_cd);	
		event.setSel_trsp_act_cust_no(sel_trsp_act_cust_no);
		
		event.setMST_DTL_INDICATOR(mst_dtl_indicator);
		event.setLogin_ofc_cd(login_ofc_cd);
		event.setLogin_usr_id(login_usr_id);
		event.setLogin_date(login_date);

		event.setTrsTrspUsaActCustVOs(tcz);	
		event.setTrsTrspUsaActCustDtlVOS(tczDtl);		
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