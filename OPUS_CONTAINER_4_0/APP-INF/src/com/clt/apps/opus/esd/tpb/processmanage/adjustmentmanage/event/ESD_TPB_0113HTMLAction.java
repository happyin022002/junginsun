/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0113HTMLAction.java
*@FileTitle : AdjustmentManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.10.01 최 선 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.10.01 변종건 [CHM-201005566-01] [TPB] 지역본부/본사의 ROC 결정 후 2ND REVIEW를 위한 보완
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateResponsibleOfficeChangeApproveVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateResponsibleOfficeChangeRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.DeleteResponsibleOfficeChangeRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeInquiryVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tpb.AdjustmentManagemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AdjustmentManageManageSC로 실행요청<br>
 * - AdjustmentManageManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Sun, CHOI
 * @see AdjustmentManageManageEvent 참조
 * @since J2EE 1.6
 */

public class ESD_TPB_0113HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_TPB_0113HTMLAction 객체를 생성
	 */
	public ESD_TPB_0113HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AdjustmentManageManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
    	EsdTpb0113Event event = new EsdTpb0113Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setSearchResponsibleOfficeChangeVOS((SearchResponsibleOfficeChangeVO[])getVOs(request, SearchResponsibleOfficeChangeVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchResponsibleOfficeChangeVO((SearchResponsibleOfficeChangeVO)getVO(request, SearchResponsibleOfficeChangeVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setSearchResponsibleOfficeChangeInquiryVO((SearchResponsibleOfficeChangeInquiryVO)getVO(request, SearchResponsibleOfficeChangeInquiryVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			event.setCreateResponsibleOfficeChangeRequestVOS((CreateResponsibleOfficeChangeRequestVO[])getVOs(request, CreateResponsibleOfficeChangeRequestVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setCreateResponsibleOfficeChangeApproveVOS((CreateResponsibleOfficeChangeApproveVO[])getVOs(request, CreateResponsibleOfficeChangeApproveVO .class));
		}
		else if(command.isCommand(FormCommand.REMOVE)) {
			event.setDeleteResponsibleOfficeChangeRequestVOS((DeleteResponsibleOfficeChangeRequestVO[])getVOs(request, DeleteResponsibleOfficeChangeRequestVO .class));
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