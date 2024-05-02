/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0022HTMLAction.java
*@FileTitle : Empty Repo Constraint 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-17
*@LastModifier : ChungEunHo
*@LastVersion : 1.0
* 2009-08-17 ChungEunHo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.event.EesEqr0022Event;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.EqrScnrRepoCnstVO;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.defaultmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DefaultManageSC로 실행요청<br>
 * - DefaultManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author ChungEunHo
 * @see EesEqr0022Event  참조
 * @since J2EE 1.6
 */
public class EES_EQR_0022HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EES_EQR_022HTMLAction 객체를 생성
	 */
	public EES_EQR_0022HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EES_EQR_022Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		// 2015.02.25 CHM-201534210 EQR 소스 보안
		EesEqr0022Event event = new EesEqr0022Event();
		    	
		// Scenario ID
		String yyyyww = JSPUtil.getParameter(request, "yyyyww".trim() , "");
		String seq	  =	JSPUtil.getParameter(request, "seq".trim() , "");
		String scnrid = Constants.SCNR_WORD + yyyyww + Constants.SCNR_WEEK + seq;
		
		String tpsz = JSPUtil.getParameter(request, "tpsz".trim() , "");	
		String cnsttype = JSPUtil.getParameter(request, "cnsttype".trim() , "");
		
		String maxInfoTable = "EQR_SCNR_REPO_CNST";
	   	String maxInfoCondition = "";
		FormCommand f_cmd = FormCommand.fromRequest(request);
		EqrScnrRepoCnstVO eqrScnrRepoCnstVO = new EqrScnrRepoCnstVO();
		eqrScnrRepoCnstVO.fromRequest(request);
		 
		 if(f_cmd.isCommand(FormCommand.SEARCHLIST)) {
			 //EqrScnrRepoCnstVO[] eqr_scnr_repo_cnsts = eqrScnrRepoCnstVO.fromRequestGridArrayList(request , tpsztype);
			 event = new EesEqr0022Event(null, cnsttype, scnrid, tpsz);
			 event.setMaxInfoTable(maxInfoTable);
			 event.setMaxInfoCondition(maxInfoCondition);    
			 }
			
		 if(f_cmd.isCommand(FormCommand.MULTI)) {
			 EqrScnrRepoCnstVO[] eqr_scnr_repo_cnsts = eqrScnrRepoCnstVO.fromRequestGridArrayList(request , "");
			 event = new EesEqr0022Event(eqr_scnr_repo_cnsts, cnsttype, scnrid, tpsz);
			 event.setMaxInfoTable(maxInfoTable);
			 event.setMaxInfoCondition(maxInfoCondition);    
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