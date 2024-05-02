/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_9998HTMLAction.java
*@FileTitle : Bkg Cop Manage Admin
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.09.21 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.BkgCopManageVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.SceCopHdrVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.sce.bkgcopmanagemain 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BkgCopManageMainSC로 실행요청<br>
 * - BkgCopManageMainSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim In-soo
 * @see BkgCopManageMainEvent 참조
 * @since J2EE 1.6
 */

public class ESD_SCE_9998HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_SCE_9998HTMLAction 객체를 생성
	 */
	public ESD_SCE_9998HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BkgCopManageMainEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
//		SignOnUserAccount account = (SignOnUserAccount) request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
//		String userId = account.getUsr_id();     
    	FormCommand command = FormCommand.fromRequest(request);
		EsdSce9998Event event = new EsdSce9998Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setSceCopHdrVO((SceCopHdrVO)getVO(request, SceCopHdrVO .class));
		} else {
			event.setBkgCopManageVO((BkgCopManageVO)getVO(request, BkgCopManageVO .class));	
		}
//		if(command.isCommand(FormCommand.COMMAND01)) { // booking creation test
//			
//			
//		} 
//		
//		if(command.isCommand(FormCommand.COMMAND02)) { // booking creation test
//			try {
//				event.setSceCopHdrVO((SceCopHdrVO)getVO(request, SceCopHdrVO .class));	
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//		} 

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