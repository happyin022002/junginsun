/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0239HTMLAction.java
*@FileTitle : Offece Control Info
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.02.10 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.vo.CustomMnrOfcGenInfoVO;
import com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.vo.OfficeGeneralInfoListGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.vo.OfficeGeneralInfoMgtINVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.mnr.planmanage 화면을 통해 서버로 전송되는 HTML DOM 
 *   객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralManageSC로 실행요청<br>
 * - GeneralManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author WanGyu Kim
 * @see EesMnr0239Event 참조
 * @since J2EE 1.6
 */

public class EES_MNR_0239HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**	
	 * EES_MNR_0239HTMLAction 객체를 생성
	 */
	public EES_MNR_0239HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 PlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0239Event event = new EesMnr0239Event();

		OfficeGeneralInfoListGRPVO officeGeneralInfoListGRPVO = new OfficeGeneralInfoListGRPVO();
		OfficeGeneralInfoMgtINVO officeGeneralInfoMgtINVO = new OfficeGeneralInfoMgtINVO();
		String combo1 = request.getParameter("ar_hd_qtr_ofc_cd");
		String combo2 = request.getParameter("ofc_cd");
		String combo3 = request.getParameter("cost_cd");
		if(command.isCommand(FormCommand.SEARCH)) {
			if(combo1 == null)combo1 = "";
			if(combo1.equals("ALL")) combo1 = "%";
			
			if(combo2 == null)combo2 = "";
			if(combo2.equals("ALL")) combo2 = "%";
			
			if(combo3 == null)combo3 = "";
			if(combo3.equals("ALL")) combo3 = "%";
			
			officeGeneralInfoMgtINVO.setArHdQtrOfcCd(combo1);
			officeGeneralInfoMgtINVO.setOfcCd(combo2);
			officeGeneralInfoMgtINVO.setCostCd(combo3);
			
			officeGeneralInfoListGRPVO.setOfficeGeneralInfoMgtINVO(officeGeneralInfoMgtINVO);
		} else if(command.isCommand(FormCommand.MULTI)) {
			CustomMnrOfcGenInfoVO[] arrCustomMnrOfcGenInfoVO = (CustomMnrOfcGenInfoVO[])getVOs(request, CustomMnrOfcGenInfoVO.class);
			officeGeneralInfoListGRPVO.setArrCustomMnrOfcGenInfoVO(arrCustomMnrOfcGenInfoVO);
		}
		
		event.setOfficeGeneralInfoListGRPVO(officeGeneralInfoListGRPVO);
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