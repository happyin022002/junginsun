/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0116HTMLAction.java
*@FileTitle : Initial Allocation Ratio Input
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.10
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2009.07.24 이현주
* 1.0 Creation
* 2015.08.24 이혜민 standby booking management에서 reprocess시 같은 조건으로 수행중일때 동일 reprocess 못하도록 alert 띄워줌.
* 2016.03.17 Stand by BKG MGMT에 대한 Reprocess 정리 및 보완
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.BkgListForCompFirmBySPCVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.vo.SearchInitialSpaceAllocationRatioListVO;
import com.hanjin.apps.alps.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.SpcSbBkgVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.basicdatamanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BasicDataManageSC로 실행요청<br>
 * - BasicDataManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author HJ.LEE
 * @see BasicDataManageEvent 참조
 * @since J2EE 1.6
 */
public class ESM_SPC_0116HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_SPC_0116HTMLAction 객체를 생성
	 */
	public ESM_SPC_0116HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BasicDataManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSpc0116Event event = new EsmSpc0116Event();
		
		if(command.isCommand(FormCommand.SEARCHLIST)) { 
			event.setSearchInitialSpaceAllocationRatioListVO((SearchInitialSpaceAllocationRatioListVO)getVO(request, SearchInitialSpaceAllocationRatioListVO .class));
			
		}else if(command.isCommand(FormCommand.SEARCH)) { // Retrive
//			event.setBkgListForCompFirmBySPCVO( (BkgListForCompFirmBySPCVO)getVO(request, BkgListForCompFirmBySPCVO.class) );
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCH01)){ // office level 조회(화면 로딩시)
			event.setSearchOfficeCondVO( (SearchOfficeCondVO)getVO(request, SearchOfficeCondVO.class) );
			
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
			
		}else if(command.isCommand(FormCommand.SEARCH03)){ //현재 같은 조건으로 Reprocess되고 있는 백엔드잡이 있는지 체크
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCH04)){ 
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			
		}else if(command.isCommand(FormCommand.MULTI)){ // Branch Save
			event.setCompFirmBySPCVO( (SpcSbBkgVO)getVO(request, SpcSbBkgVO.class) );
			event.setCompFirmBySPCVOs( (SpcSbBkgVO[])getVOs(request, SpcSbBkgVO.class) );
			
		}else if(command.isCommand(FormCommand.MODIFY)){
			event.setBkgBlNoVOs((BkgBlNoVO[])getVOs(request, BkgBlNoVO.class, ""));
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class, ""));
			
		}else if(command.isCommand(FormCommand.MODIFY01)){ //Reprocess
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setCompFirmBySPCVOs( (SpcSbBkgVO[])getVOs(request, SpcSbBkgVO.class) );
			
		}else if(command.isCommand(FormCommand.MODIFY02)){ //Standby -> Firm
			event.setBkgListForCompFirmBySPCVO( (BkgListForCompFirmBySPCVO)getVO(request, BkgListForCompFirmBySPCVO.class) );
			event.setBkgListForCompFirmBySPCVOs( (BkgListForCompFirmBySPCVO[])getVOs(request, BkgListForCompFirmBySPCVO.class) );
			
		}else if(command.isCommand(FormCommand.MODIFY03)){ //Reprocess 시작 시 해당조건 삽입
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			
		}else if(command.isCommand(FormCommand.MODIFY04)){ //Reprocess 종료 시 해당조건 삭제
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
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