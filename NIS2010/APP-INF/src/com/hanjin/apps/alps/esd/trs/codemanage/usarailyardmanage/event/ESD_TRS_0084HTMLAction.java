/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_084HTMLAction.java
*@FileTitle : UsaRailYardManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009-05-11
*@LastModifier : Jun Yong Park
*@LastVersion : 1.0
* 2009-05-11 Jun Yong Park
* 1.0 최초 생성
* N200905150040 2009-05-20 [TRS]USA RAIL YARD 정보 저장 화면 개발
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.usarailyardmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.codemanage.usarailyardmanage.vo.UsaRailYardManageVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.CommonWebKeys;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.codemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UsaRailYardManageSC로 실행요청<br>
 * - UsaRailYardManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author poong yeon cho
 * @see EsdTrs0084Event , ESD_TRS_084EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0084HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_084HTMLAction 객체를 생성
	 */
	public ESD_TRS_0084HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_084Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {	
		
		FormCommand command = FormCommand.fromRequest(request);
		UsaRailYardManageVO usaRailYardManageVO   = new UsaRailYardManageVO();
		UsaRailYardManageVO[] vpe = null;
		EsdTrs0084Event event = new EsdTrs0084Event();
		if(command.isCommand(FormCommand.SEARCH)) {
			String yard = JSPUtil.getParameter(request, "yard", "");
			String rail_yard = JSPUtil.getParameter(request, "rail_yard", "");
			event.setYard(yard);
			event.setRailYard(rail_yard);
			
		}else if(command.isCommand(FormCommand.MULTI)) {
			String yard = JSPUtil.getParameter(request, "yard", "");
			String rail_yard = JSPUtil.getParameter(request, "rail_yard", "");			
			vpe = usaRailYardManageVO.fromRequestGrid(request);
			SignOnUserAccount account = (SignOnUserAccount)request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			String userId=account.getUsr_id();
			event.setYard(yard);
			event.setRailYard(rail_yard);
			event.setUsaRailYardManageVOs(vpe);	
			event.setUserId(userId);
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