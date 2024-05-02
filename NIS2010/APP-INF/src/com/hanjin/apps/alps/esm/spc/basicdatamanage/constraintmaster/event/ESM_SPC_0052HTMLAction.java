/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0052HTMLAction.java
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.22 한상훈
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2015.06.24 이혜민 [CHM-201535810] [SPC] Fixed Rate 계약 정보의 SPC 적용 개발 요청 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.CustomerControlGroupVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchOfficeBKGInControlVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchSpaceAllocationLaneControlOptionVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.spaceallocationmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SpaceAllocationManageSC로 실행요청<br>
 * - SpaceAllocationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Sang Hoon
 * @see SpaceAllocationManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SPC_0052HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SPC_0052HTMLAction 객체를 생성
	 */
	public ESM_SPC_0052HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SpaceAllocationManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSpc0052Event event = new EsmSpc0052Event();
		

		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
			
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setSearchSpaceAllocationLaneControlOptionVOs((SearchSpaceAllocationLaneControlOptionVO[])getVOs(request, SearchSpaceAllocationLaneControlOptionVO .class,""));
			
		}else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
			
		}else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setSearchSpaceAllocationLaneControlOptionVOs((SearchSpaceAllocationLaneControlOptionVO[])getVOs(request, SearchSpaceAllocationLaneControlOptionVO .class,""));
			
		}else if(command.isCommand(FormCommand.REMOVE)) {
			event.setSearchSpaceAllocationLaneControlOptionVO((SearchSpaceAllocationLaneControlOptionVO)getVO(request, SearchSpaceAllocationLaneControlOptionVO .class,""));
			
		}else if(command.isCommand(FormCommand.SEARCHLIST04)) { //BKG Control Option LIST
			event.setSearchSpaceAllocationControlofficeVO((SqmQtaLaneOfcVO)getVO(request, SqmQtaLaneOfcVO .class,""));
			
		}else if(command.isCommand(FormCommand.SEARCHLIST03)) { //Booking Control option List
			event.setSearchSpaceAllocationBKGControlofficeVO((SearchOfficeBKGInControlVO)getVO(request, SearchOfficeBKGInControlVO .class,""));
			
		}else if(command.isCommand(FormCommand.MULTI02)) { //BKG Control Option Office LIST Insert/Update/Delete
			SearchOfficeBKGInControlVO searchOfficeBKGInControlVO = new SearchOfficeBKGInControlVO();
			event.setSearchOfficeBKGInControlVOs(searchOfficeBKGInControlVO.fromRequestGrid(request));
			
		}else if(command.isCommand(FormCommand.SEARCHLIST05)) { //BKG Control Option LIST
			event.setSearchSpaceAllocationBKGControlofficeVO((SearchOfficeBKGInControlVO)getVO(request, SearchOfficeBKGInControlVO .class,""));
			
		}else if(command.isCommand(FormCommand.SEARCHLIST06)) { //BKG Control Option LIST
			event.setSearchCustomerControlCodeVO((CustomerControlGroupVO)getVO(request, CustomerControlGroupVO .class,""));
			
		}else if(command.isCommand(FormCommand.SEARCHLIST07)) { //SC NO 유효성 체크
			event.setScNo (JSPUtil.getParameter(request, "scNo"));	
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