/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FNS_JOO_0081HTMLAction.java
*@FileTitle : Loading Port Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.25 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrSettlementBackupReportVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrStandardFormatVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.fns.joo.jointoperationagreementsettlement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 JointOperationAgreementSettlementSC로 실행요청<br>
 * - JointOperationAgreementSettlementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author jang kang cheol
 * @see JointOperationAgreementSettlementEvent 참조
 * @since J2EE 1.6
 */

public class FNS_JOO_0084HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_JOO_0084HTMLAction 객체를 생성
	 */
	public FNS_JOO_0084HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 JointOperationAgreementSettlementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsJoo0084Event event = new FnsJoo0084Event();
		event.setKey(request.getParameter("backendjob_key")); //BackEndJob 으로 돌린 후 결과 및 상태 조회

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setCntrSettlementBackupReportVO((CntrSettlementBackupReportVO)getVO(request, CntrSettlementBackupReportVO .class));
		}else if(command.isCommand(FormCommand.SEARCH01)) { // backend job
            event.setCntrSettlementBackupReportVO((CntrSettlementBackupReportVO)getVO(request, CntrSettlementBackupReportVO .class));
        }else if(command.isCommand(FormCommand.SEARCH02)) { //backendjob 3초 Loop
    		event.setKey(request.getParameter("backendjob_key")); //BackEndJob 으로 돌린 후 결과 및 상태 조회
        }else if(command.isCommand(FormCommand.COMMAND01)) {//backendjob 종료시
        	event.setCntrSettlementBackupReportVO((CntrSettlementBackupReportVO)getVO(request, CntrSettlementBackupReportVO .class));
        }else if(command.isCommand(FormCommand.SEARCH03)){ //Standard format Retrieve
        	event.setCntrConditionVO((CntrConditionVO)getVO(request, CntrConditionVO .class));
        }else if(command.isCommand(FormCommand.SEARCH04)){ //Previous Voyage and last Port
        	event.setCntrConditionVO((CntrConditionVO)getVO(request, CntrConditionVO .class));
        }else if(command.isCommand(FormCommand.SEARCH05)){ //Standard Format Excel Down
        	event.setCntrConditionVO((CntrConditionVO)getVO(request, CntrConditionVO .class));
        	event.setCntrStandardFormatPreVOs((CntrStandardFormatVO[])getVOs(request, CntrStandardFormatVO.class, "t2sheet1_"));
        	event.setCntrStandardFormatSumVOs((CntrStandardFormatVO[])getVOs(request, CntrStandardFormatVO.class, "t2sheet2_"));
			
        }else if(command.isCommand(FormCommand.COMMAND02)){//Standard format Excel File Backendjob
        	//BackEndJob 으로 돌린 후 결과코드 조회
			event.setKey(request.getParameter("backendjob_key"));
        }else if(command.isCommand(FormCommand.SEARCH06)){ //Standard format Title 재귀 호출.
        	event.setCntrConditionVO((CntrConditionVO)getVO(request, CntrConditionVO .class));
        }else if(command.isCommand(FormCommand.SEARCH07)){ //Standard format Retrieve(Back End Job)
        	event.setCntrConditionVO((CntrConditionVO)getVO(request, CntrConditionVO .class));
        }else if(command.isCommand(FormCommand.SEARCH08)){ //Standard format Retrieve(Back End Job 종료시)
        	event.setCntrConditionVO((CntrConditionVO)getVO(request, CntrConditionVO .class));
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