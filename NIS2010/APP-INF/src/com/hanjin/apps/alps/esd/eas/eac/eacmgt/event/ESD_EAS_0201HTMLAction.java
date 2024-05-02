/*=========================================================

*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0201HTMLAction.java
*@FileTitle : Expense Audit case Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;



import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACRgstVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACTpbDtlVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacSearchVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgHamoTrfVO;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.eas.eac 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EacSC로 실행요청<br>
 * - EacSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author HI
 * @see EacEvent 참조
 * @since J2EE 1.6
 */

public class ESD_EAS_0201HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_EAS_0201HTMLAction 객체를 생성
	 */
	public ESD_EAS_0201HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EacEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdEas0201Event event = new EsdEas0201Event();
		

		if(command.isCommand(FormCommand.SEARCHLIST01)) { // 콤보조회 
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
		}else if(command.isCommand(FormCommand.SEARCH)) {
			event.setEacRegistrationVO((EACRgstVO)getVO(request, EacSearchVO.class));
		}else if(command.isCommand(FormCommand.SEARCH01)) {  // 공통 코드 조회 하는 콤보값 
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.COMMAND01)) { // 로그인한 유저의 ofc 레벨 
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCH02)) {  // 콤보조회 
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCH03)) {  // Currency 콤보 조회 
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCH04)) {  // Exchange Rate 조회 
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCH05)) {  // S/P Code 조회 
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCH06)) {  // Location 에 값이 존재하는지 체크 한다
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCH07)) {  // Responsible Office 에 값이 존재하는지 체크 한다
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCH08)) {  // Contact Point 콤보 조회 
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCH09)) {  // Expense Audit case Registration 저장전 중복된 데이터 인지 확인한다. 
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCH11)) {  // EAC Registration 을 조회한다
			event.setEacRegistrationVO((EACRgstVO)getVO(request, EACRgstVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCH12)) {  // Rejection Notice Tab 을 선택시 조회쿼리
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCH14)) {  // Booking No 가 존재하는지 확인한다.
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCH15)) {  // I/F 전에 중복 여부를 체크한다.
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCH16)) {  // Personnel Config, Office Config 가 등록되어 있는지 확인하고 발송자 메일 정보를 조회한다
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCH17)) {  // Yard Cdoe 에 값이 존재하는지 체크 한다
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.MULTI01)) {   // Expense Audit case Registration 를 저장한다.
			
			event.setEacTpbDtlVOs((EACTpbDtlVO[])getVOs(request, EACTpbDtlVO .class,""));
			event.setEacRegistrationVO((EACRgstVO)getVO(request, EACRgstVO.class));
			
		}else if(command.isCommand(FormCommand.MULTI02)) {   // TPB 테이블에 자료 등록.
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.COMMAND02)) { // RHQ OFFCE 콤보조회
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.COMMAND03)) { // OFFCE 콤보조회
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.COMMAND04)) { // 로그인한 유저의 ofc 레벨 
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.COMMAND05)) { // Responsible Office 가 TPB 에 등록된 office 인지 확인한다.
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.COMMAND06)) { // 입력한 3rdParty Value 값이 유효한지 체크한다.
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
			
		}else if(command.isCommand(FormCommand.REMOVE01)) { // 삭제 
			event.setEacSearchVO((EacSearchVO)getVO(request, EacSearchVO.class));
		}else if(command.isCommand(FormCommand.MODIFY01)) { // issue 
			event.setEacSearchVOs((EacSearchVO[])getVOs(request, EacSearchVO.class,""));
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
