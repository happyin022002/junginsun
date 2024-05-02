/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0217HTMLAction.java
*@FileTitle : M&R Colleague Tree
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.05.21 정영훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.ColleagueTreeGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.CustomMnrOfcCntcPsonVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.OfficeGeneralInfoMgtINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.planmanage 화면을 통해 서버로 전송되는 HTML DOM 
 *   객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PlanManageSC로 실행요청<br>
 * - PlanManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author chung young hun
 * @see PlanManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_MNR_0217HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0112HTMLAction 객체를 생성
	 */
	public EES_MNR_0217HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0217Event event = new EesMnr0217Event();
		
		ColleagueTreeGRPVO colleagueTreeGRPVO = new ColleagueTreeGRPVO();
		OfficeGeneralInfoMgtINVO officeGeneralInfoMgtINVO = new OfficeGeneralInfoMgtINVO();
		String combo1 = request.getParameter("combo1");
		if(combo1 == null)combo1 = "";
		if(combo1.equals("ALL")) combo1 = "%";
		String combo2 = request.getParameter("combo2");
		if(combo2 == null)combo2 = "";
		if(combo2.equals("ALL")) combo2 = "%";
		officeGeneralInfoMgtINVO.setOfcCd(combo2);
		officeGeneralInfoMgtINVO.setArHdQtrOfcCd(combo1);
		
		colleagueTreeGRPVO.setOfficeGeneralInfoMgtINVO(officeGeneralInfoMgtINVO);
		
		if(command.isCommand(FormCommand.MULTI)) {
			
			CustomMnrOfcCntcPsonVO[] arrCustomMnrOfcCntcPsonVO = (CustomMnrOfcCntcPsonVO[])getVOs(request, CustomMnrOfcCntcPsonVO.class);
			colleagueTreeGRPVO.setArrCustomMnrOfcCntcPsonVO(arrCustomMnrOfcCntcPsonVO);
		
		}
		
		event.setColleagueTreeGRPVO(colleagueTreeGRPVO);
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