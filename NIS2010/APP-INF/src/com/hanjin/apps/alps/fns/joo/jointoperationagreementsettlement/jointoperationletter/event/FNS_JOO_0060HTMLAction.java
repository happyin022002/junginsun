/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0060HTMLAction.java
*@FileTitle : MCS Letter Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.07 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.LetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.McsCombinedVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 JointOperationAgreementSettlementSC로 실행요청<br>
 * - JointOperationAgreementSettlementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author jang kang cheol
 * @see JointOperationAgreementSettlementEvent 참조
 * @since J2EE 1.6
 */

public class FNS_JOO_0060HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_JOO_0060HTMLAction 객체를 생성
	 */
	public FNS_JOO_0060HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 JointOperationAgreementSettlementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsJoo0060Event event = new FnsJoo0060Event();
		
        /*************************get Text No ( Template ID )*********************************/
		if(command.isCommand(FormCommand.SEARCH01)) {
            event.setOfccd( JSPUtil.getParameter(request, "ofccd") );
            event.setFlag(  JSPUtil.getParameter(request, "flag") ); 
            event.setLetterVO ( (LetterVO )getVO (request, LetterVO.class ) );   
		}
        /*************************get Template ( On Change ) *********************************/
        if(command.isCommand(FormCommand.SEARCH02)) {
            event.setTextno(   JSPUtil.getParameter(request, "jo_tmplt_no") );
            event.setJocrrcd(  JSPUtil.getParameter(request, "jo_crr_cd") );     
            event.setLetterVO ( (LetterVO )getVO (request, LetterVO.class ) );   
        }
 	

        /************************* Retrieve *********************************/        
        if(command.isCommand(FormCommand.SEARCHLIST01)) {
            event.setMcsCombinedVO( (McsCombinedVO)getVO(request, McsCombinedVO.class) );
        }
        if(command.isCommand(FormCommand.SEARCHLIST02)) {
            event.setLetterVO( (LetterVO)getVO(request, LetterVO.class) );
        }
        /************************* Save *********************************/        
        if(command.isCommand(FormCommand.MULTI01)) {
 
            event.setLetterVO ( (LetterVO )getVO (request, LetterVO.class ) );            
            event.setLetterVOs( (LetterVO[])getVOs(request, LetterVO.class,"sheet1_") );
        }
        /************************* Send *********************************/        
        if(command.isCommand(FormCommand.MULTI02)) {
            event.setLetterVO ( (LetterVO )getVO (request, LetterVO.class ) );        
        }          
        
        event.setLetterVO ( (LetterVO )getVO (request, LetterVO.class ) );   
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