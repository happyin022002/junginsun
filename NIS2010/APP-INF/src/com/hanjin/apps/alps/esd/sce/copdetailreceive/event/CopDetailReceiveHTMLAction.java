/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveHTMLAction.java
*@FileTitle : Cop Detail Receive Admin
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.01
*@LastModifier : 안정선
*@LastVersion : 1.0
* 2010.06.01 안정선
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copdetailreceive.event;
import javax.servlet.http.HttpServletRequest;

//import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.CopDetailReceiveVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
//import com.hanjin.framework.support.controller.html.CommonWebKeys;
//import com.hanjin.framework.support.controller.html.FormCommand;
//import com.hanjin.framework.support.view.signon.SignOnUserAccount;
//import com.hanjin.syscommon.common.table.SceCopDtlVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce.bkgcopmanagemain 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BkgCopManageMainSC로 실행요청<br>
 * - BkgCopManageMainSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim In-soo
 * @see BkgCopManageMainEvent 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * CopDetailReceiveHTMLAction 객체를 생성
	 */
	public CopDetailReceiveHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BkgCopManageMainEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		//SignOnUserAccount account = (SignOnUserAccount) request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		//String userId = account.getUsr_id();     
    	//FormCommand command = FormCommand.fromRequest(request);
		CopDetailReceiveEvent event = new CopDetailReceiveEvent();
		
//		if(command.isCommand(FormCommand.SEARCH)) {
//			//event.setSceCopDtlVO((SceCopDtlVO)getVO(request, SceCopDtlVO .class));
//		} else {
//			try {
//				//event.setCopDetailReceiveVO((CopDetailReceiveVO)getVO(request, CopDetailReceiveVO .class));	
//			} catch (Exception e) {

//				log.error(e.getMessage(),e);
//			}
//		}
		
//		if(command.isCommand(FormCommand.COMMAND01)) { // booking creation test
//			
//			
//		} 
//		
//		if(command.isCommand(FormCommand.COMMAND02)) { // booking creation test
//			try {
//				event.setSceCopDtlVO((SceCopDtlVO)getVO(request, SceCopDtlVO .class));	
//			} catch (Exception e) {
//				log.error(e.getMessage(),e);
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
