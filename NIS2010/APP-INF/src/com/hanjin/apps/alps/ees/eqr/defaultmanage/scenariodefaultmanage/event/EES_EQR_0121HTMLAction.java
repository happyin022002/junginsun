/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_121HTMLAction.java
*@FileTitle : 연간 신조 계획 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-02
*@LastModifier : chung eun ho
*@LastVersion : 1.0
* 2009-07-02 chung eun ho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0121ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.EqrNewVanLongTermVO;


/**
 * HTTP Parser<br> 
 * - com.hanjin.apps.enis.ees.eqr.defaultmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DefaultManageSC로 실행요청<br>
 * - DefaultManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author ChungEunHo
 * @see EesEqr0121Event 참조
 * @since J2EE 1.6
 */
public class EES_EQR_0121HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EES_EQR_121HTMLAction 객체를 생성
	 */
	public EES_EQR_0121HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EES_EQR_121Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand f_cmd = FormCommand.fromRequest(request);
    	EesEqr0121Event event = new EesEqr0121Event();   	
    	
    	event.setConditionVO((EesEqr0121ConditionVO)getVO(request, EesEqr0121ConditionVO.class)); // 조건 DTD setting
		
    	
    	// Sheet1 update, insert, delete 정보를 받기
    	if(f_cmd.isCommand(FormCommand.MULTI)) {
    		event.setEqrNewVanLongTermVOS((EqrNewVanLongTermVO[])getVOs(request, EqrNewVanLongTermVO .class,""));
    		event.setMAndFlagmonthSaveInfo(request);
			
        // Sheet2 update 정보를 받기	
		}else if(f_cmd.isCommand(FormCommand.MULTI01)) {
			EqrNewVanLongTermVO eqrNewVanLongTermVO = new EqrNewVanLongTermVO();			
			event.setEqrNewVanLongTermVOS((EqrNewVanLongTermVO[])eqrNewVanLongTermVO.fromRequestGrid(request, "w_"));
			// MweekSaveInfo, FlagweekSaveInfo  배열 셋팅 'm'+weekArr ,  'flag1'+weekArr 의  파마메타 명으로 입력받아 설정한다.
			event.setMAndFlagweekSaveInfo(request);
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