/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EES_EQR_111HTMLAction.java
*@FileTitle         : Vessel Schedule 조회
*Open Issues     :
*@LastModifyDate : 2009-08-04
*@LastModifier   : ChungEunHo
*@LastVersion    : 2.0
*Change history  -------------------------------------------------------------------
* No.   Ver.     Modifier              modifier date    explanation
* 1      1.0       sangyool pak      2006-08-30       최초 생성
* 2      1.6       chae chang ho    2008-11-12       CSR No : N200811110008 - User 가 Vessel SKD 업데이트 할 수 있도록 시스템 보완.
* 3      1.7       HaengJi, Lee       2009-04-22       CSR No : N200904200110 - VVD Add 추가로 인한 로직 추가
* 4      2.0       ChungEunHo       2009-08-04       new frameWork 전환
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.EesEqr0111ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.EqrScnrVslSkdVO;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.ees.eqr.scenariomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ScenarioManageSC로 실행요청<br>
 * - ScenarioManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author ChungEunHo
 * @see EesEqr0111Event
 * @since J2EE 1.6
 */
public class EES_EQR_0111HTMLAction extends HTMLActionSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * EES_EQR_0111HTMLAction 객체를 생성
     */
    public EES_EQR_0111HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EES_EQR_111Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	
    	FormCommand f_cmd  = FormCommand.fromRequest(request);		
		
    	EesEqr0111Event event = new EesEqr0111Event();    	
    	
    	
    	// CSRNO : N200811110008 추가 시작 
    	// 변경 스케즐이나 insert 된 스케즐이 넘어가는 정보 
    	 if(f_cmd.isCommand(FormCommand.MULTI)) {
    		 event.setEqrScnrVslSkdVOS((EqrScnrVslSkdVO[])getVOs(request, EqrScnrVslSkdVO .class,"")); // 변경 될 DTD setting
    	 }
    	 
    	 // NIS sync 시 넘겨질 정보 
    	 if(f_cmd.isCommand(FormCommand.MULTI01)) {
    		 event.setEqrScnrVslSkdVOS((EqrScnrVslSkdVO[])getVOs(request, EqrScnrVslSkdVO .class,"")); // 변경 될 DTD setting
    	 }
    	 //    	 CSR No : N200904200110 - VVD Add 추가로 인한 로직 추가
    	 if(f_cmd.isCommand(FormCommand.MULTI02)) {
    		 event.setEqrScnrVslSkdVOS((EqrScnrVslSkdVO[])getVOs(request, EqrScnrVslSkdVO .class,"")); // 변경 될 DTD setting
    	 }
     //  CSRNO : N200811110008 추가 끝 
    	// Co, Lane, VVD 그리드 클릭시
    	 event.setConditionVO((EesEqr0111ConditionVO)getVO(request, EesEqr0111ConditionVO .class)); // 조회조건 셋팅 
    	 
    
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