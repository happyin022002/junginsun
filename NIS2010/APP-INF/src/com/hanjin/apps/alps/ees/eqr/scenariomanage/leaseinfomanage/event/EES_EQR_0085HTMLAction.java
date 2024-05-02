/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_085HTMLAction.java
*@FileTitle : S/T off-Hire 정보 조회/ 수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-10
*@LastModifier : ChungEunHo
*@LastVersion : 1.0
* 2009-08-10 ChungEunHo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo.EesEqr0085ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.EqrScnrShrtTermOffhCondVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.scenariomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ScenarioManageSC로 실행요청<br>
 * - ScenarioManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author ChangHoChae
 * @see EesEqr0085Event , EES_EQR_085EventResponse 참조
 * @since J2EE 1.6
 */
public class EES_EQR_0085HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EES_EQR_085HTMLAction 객체를 생성
	 */
	public EES_EQR_0085HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EES_EQR_085Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand f_cmd  = FormCommand.fromRequest(request);    	
	       
        EesEqr0085Event event = new EesEqr0085Event();    	
        // 화면에서 조건값을 가져와서 저장을 한다.
        event.setConditionVO((EesEqr0085ConditionVO)getVO(request,EesEqr0085ConditionVO.class));
                
        if (f_cmd.isCommand(FormCommand.MULTI))
        {
        	EqrScnrShrtTermOffhCondVO eqrScnrShrtTermOffhCondVO = new EqrScnrShrtTermOffhCondVO();
        	String tpSzType = event.getConditionVO().getTpsztype();		//JSPUtil.getParameter(request, "TPSZtype".trim(),"");     
        	String loc     = event.getConditionVO().getLoc();			//JSPUtil.getParameter(request, "LOC".trim(),"");        	
        	event.setEqrScnrShrtTermOffhCondVOS((EqrScnrShrtTermOffhCondVO[])eqrScnrShrtTermOffhCondVO.fromRequestGridArrayList(request, tpSzType , loc));
        	
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