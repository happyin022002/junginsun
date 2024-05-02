/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAO.java
*@FileTitle : Container Guideline Manage
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1     1.0      	SHIN DONG IL						2013.05.27		 Creation
*
*@LastModifyDate : 2013.05.27
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.05.27 SHIN DONG IL
* 1.0 Creation
* 
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanmtrepoplan.event;


import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanmtrepoplan.vo.EesEqr1013ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanmtrepoplan.vo.EesEqr1013MtRepoPlanVO;
//import com.clt.apps.opus.esd.tes.specialcargoquotationmanage.tariffconditionmanage.vo.ComTesCondDtlVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.eqr.repoplanmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RepoPlanManageSC로 실행<br>
 * - RepoPlanManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Haeng-ji,Lee
 * @see RepoPlanManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_1013HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	

	/**
	 * EES_EQR_1013HTMLAction 객체를 생성
	 */
	public EES_EQR_1013HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RepoPlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr1013Event event = new EesEqr1013Event();
		EesEqr1013ConditionVO conditionVO = new EesEqr1013ConditionVO(); 
		
		conditionVO = (EesEqr1013ConditionVO)getVO(request,EesEqr1013ConditionVO.class);
		conditionVO.setMainPage(request.getParameter("mainPage"));
		event.setEesEqr1013ConditionVO(conditionVO);
		
		if(command.isCommand(FormCommand.MULTI)){
			event.setEesEqr1013MtRepoPlanVO((EesEqr1013MtRepoPlanVO[])getVOs(request,EesEqr1013MtRepoPlanVO.class));
//		}else if(command.isCommand(FormCommand.REMOVE01)){
//		}else if(command.isCommand(FormCommand.SEARCH02)){
//		}else if(command.isCommand(FormCommand.DEFAULT)){
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