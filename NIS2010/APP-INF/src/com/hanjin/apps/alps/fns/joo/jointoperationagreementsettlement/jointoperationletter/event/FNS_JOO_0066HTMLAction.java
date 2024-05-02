/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0066HTMLAction.java
*@FileTitle : JO Member Information Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.18 함대성
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2010.11.08 이준범 [CHM-201006731-01]
* 1. 대상 기능
*   - JO Member Information Creation(JOO_0066)
*   - Inquiry of JO Member Information(JOO_0067)
* 2. 보완 대상
*   - Revenue Lane 정보 반영 
*   - MS Office( Excel, Worl, Power Point등) 첨부
*   - Carrier Name등 컬럼 반영
* 2010.12.02 이준범 [CHM-201007349-01]
* 1. 보완 기능 
*   - JO Member Information Creation
*   - Inquiry of JO Member Information
* 2. 보완 요청 사항
*   - 컬럼 추가 : PIC of HJS(ID),  Name of PIC,  RHQ, Office, Start Date,  Creation Date
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CarrierSeqVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustCdInfoVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustCdNmVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustMemberVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.PicOfUserInfoVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.JooCntcMbrVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 JointOperationAgreementSettlementSC로 실행요청<br>
 * - JointOperationAgreementSettlementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author HAM DAE SUNG
 * @see JointOperationAgreementSettlementEvent 참조
 * @since J2EE 1.6
 */

public class FNS_JOO_0066HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_JOO_0066HTMLAction 객체를 생성
	 */
	public FNS_JOO_0066HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 JointOperationAgreementSettlementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsJoo0066Event event = new FnsJoo0066Event();

		if(command.isCommand(FormCommand.MULTI)) {
			event.setCustMemberVOS((CustMemberVO[])getVOs(request, CustMemberVO.class, "sheet1_"));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setCustMemberVO((CustMemberVO)getVO(request, CustMemberVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			String joCntcPicId = JSPUtil.getParameter(request, "jo_cntc_pic_id","");
			event.setJoCntcPicId(joCntcPicId);
//			event.setPicOfUserInfoVO((PicOfUserInfoVO)getVO(request, PicOfUserInfoVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setCustCdNmVO((CustCdNmVO)getVO(request, CustCdNmVO .class));
			request.setAttribute("Event", event);
		}
		else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setCarrierSeqVO((CarrierSeqVO)getVO(request, CarrierSeqVO .class));
			request.setAttribute("Event", event);
		}else if(command.isCommand(FormCommand.REMOVE)) {
			event.setJooCntcMbrVO((JooCntcMbrVO)getVO(request, JooCntcMbrVO .class));
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