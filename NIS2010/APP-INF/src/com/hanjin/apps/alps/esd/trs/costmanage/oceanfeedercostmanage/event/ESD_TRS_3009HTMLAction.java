/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_3009HTMLAction.java
*@FileTitle : Ocean Feeder Cost Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.07.03 변종건 [CHM-201217633] Ocean Feeder Cost Management 수정 및 신규 탭 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.event;


import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.FeederCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchFeederDgCostVO;
import com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo.SearchFeederReeferCostVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.inlandcostmanage.codemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ChangeOfDestinationMgtSC로 실행요청<br>
 * - InlandCostManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Jong Ock
 * @see InlandCostManageEvent 참조
 * @since J2EE 1.6
 */
public class ESD_TRS_3009HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_TRS_3009HTMLAction 객체를 생성
	 */
	public ESD_TRS_3009HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CostManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsdTrs3009Event event = new EsdTrs3009Event();
		
		if( command.isCommand(FormCommand.SEARCH) ){
			event.setInCostTrfNo(JSPUtil.getParameter(request, "in_cost_trf_no", ""));
		} else if( command.isCommand(FormCommand.SEARCH02) ){
			event.setInOfcCd(JSPUtil.getParameter(request, "in_ofc_cd", "") );
		} else if( command.isCommand(FormCommand.SEARCH03) ){
			event.setInCostTrfNo(JSPUtil.getParameter(request, "in_cost_trf_no", ""));
			event.setInOfcCd(JSPUtil.getParameter(request, "in_ofc_cd", ""));
		} else if( command.isCommand(FormCommand.MULTI01) ){
			event.setInBtnSts(JSPUtil.getParameter(request, "in_btn_sts", ""));			
			event.setInCostTrfNo(JSPUtil.getParameter(request, "in_cost_trf_no", ""));
			event.setFeederCostVOS((FeederCostVO[])getVOs(request, FeederCostVO .class,""));
		} else if( command.isCommand(FormCommand.MULTI02) ){
			event.setInBtnSts(JSPUtil.getParameter(request, "in_btn_sts", ""));
			event.setInCostTrfNo(JSPUtil.getParameter(request, "in_cost_trf_no", ""));
			event.setSearchFeederReeferCostVOs((SearchFeederReeferCostVO[])getVOs(request, SearchFeederReeferCostVO .class,""));
		} else if( command.isCommand(FormCommand.MULTI03) ){
			event.setInCostTrfNo(JSPUtil.getParameter(request, "in_cost_trf_no", ""));
		} else if( command.isCommand(FormCommand.MULTI04) ){
			event.setInCostTrfNo(JSPUtil.getParameter(request, "in_cost_trf_no", ""));
			event.setInRhqCd(JSPUtil.getParameter(request, "in_rhq_cd", ""));
		} else if( command.isCommand(FormCommand.MULTI05) ){
			event.setInBtnSts(JSPUtil.getParameter(request, "in_btn_sts", ""));
			event.setInCostTrfNo(JSPUtil.getParameter(request, "in_cost_trf_no", ""));
			event.setSearchFeederDgCostVOs((SearchFeederDgCostVO[])getVOs(request, SearchFeederDgCostVO .class,""));
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