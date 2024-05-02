/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0053HTMLAction.java
*@FileTitle : 컨테이너 수급 예측실적 및 정확도 조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		jungran yang					2006-10-24		1.0 최초 생성
* 2		1.0		Lee Byoung Hun				2009.09.03		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.09.03
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0053ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0053MultiVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.repoplanmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RepoPlanManageSC로 실행요청<br>
 * - RepoPlanManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see RepoPlanManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0053HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0053HTMLAction 객체를 생성
	 */
	public EES_EQR_0053HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RepoPlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0053Event event = new EesEqr0053Event();
		
		String tpszType = JSPUtil.getParameter(request, "cntrTpszCd_3","");
		
		// Retrieve 버튼 클릭시
		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setEesEqr0053ConditionVO((EesEqr0053ConditionVO)getVO(request, EesEqr0053ConditionVO .class));
		}
		
		// Save 버튼 클릭시
		else if (command.isCommand(FormCommand.MULTI)) {
			event.setEesEqr0053ConditionVO((EesEqr0053ConditionVO)getVO(request, EesEqr0053ConditionVO .class));
			event.setEesEqr0053MultiVOS(new EesEqr0053MultiVO().fromRequestGridArrayList(request, tpszType));
		}
		
		// Sheet2 조회 (Sheet1 내용을 더블클릭시)
		else if (command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setEesEqr0053ConditionVO((EesEqr0053ConditionVO)getVO(request, EesEqr0053ConditionVO .class));
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