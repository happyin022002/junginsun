/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_079HTMLAction.java
*@FileTitle : Control Office Exception Case Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-27
*@LastModifier : poong
*@LastVersion : 1.0
* 2006-09-27 poong
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.vo.ControlOfficeExceptionSearchConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.TrsTrspOfcExptRuleVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.codemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CodeManageSC로 실행요청<br>
 * - CodeManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author poong
 * @see EsdTrs079Event , ESD_TRS_079EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0079HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_079HTMLAction 객체를 생성
	 */
	public ESD_TRS_0079HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_079Event로 파싱하여 request에 셋팅<br>
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
         TRS_TRSP_OFC_EXPT_RULE trs_trsp_ofc_expt_rule = TRS_TRSP_OFC_EXPT_RULE.fromRequestGrid(request, prefix);
        */ 
		FormCommand command = FormCommand.fromRequest(request);

		EsdTrs0079Event event = new EsdTrs0079Event();

		ControlOfficeExceptionSearchConditionVO vo = new ControlOfficeExceptionSearchConditionVO();
		if(command.isCommand(FormCommand.MULTI) || command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.MULTI02)) {
			TrsTrspOfcExptRuleVO trsTrspOfcExptRuleVO   = new TrsTrspOfcExptRuleVO();
			event.setTrsTrspOfcExptRuleVOS(trsTrspOfcExptRuleVO.fromRequestGrid(request));
			
			vo.fromRequest(request);
			event.setControlOfficeExceptionSearchConditionVO(vo);
		} else if(command.isCommand(FormCommand.SEARCH)) {
			vo.fromRequest(request);
			event.setControlOfficeExceptionSearchConditionVO(vo);
		}

		String searchStr = request.getParameter("searchStr");
		String ctrl_ofc_cd = request.getParameter("ctrl_ofc_cd");
		String trsp_so_eq_kind = request.getParameter("TRSP_SO_EQ_KIND");
		String isZone = request.getParameter("isZone");
		String form_usr_ofc_cd = request.getParameter("FORM_USR_OFC_CD");
		String form_cre_usr_id = request.getParameter("FORM_CRE_USR_ID");
		
		event.setSearchStr(searchStr);
		event.setCtrl_ofc_cd(ctrl_ofc_cd);
		event.setTRSP_SO_EQ_KIND(trsp_so_eq_kind);
		event.setIsZone(isZone);
		event.setFORM_USR_OFC_CD(form_usr_ofc_cd);
		event.setFORM_CRE_USR_ID(form_cre_usr_id);

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