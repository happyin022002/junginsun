/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0022HTMLAction.java
*@FileTitle :  Activity Attribute Management 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-08-29 Se-Hoon PARK
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.CommonWebKeys;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmActivityVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserManagerSC로 실행요청<br>
 * - UserManagerSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Se-Hoon PARK
 * @see EsdSce024Event , EsdSce024EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0022HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
     * ESD_SCE_024HTMLAction 객체를 생성
     */
    public ESD_SCE_0022HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsdSce024Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
		SignOnUserAccount account = (SignOnUserAccount) request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		String userId = account.getUsr_id();         
    	FormCommand command = FormCommand.fromRequest(request);		
    	//RequestDataSetBC dataSet = RequestDataSetBC.getInstance(request) ;
        
        EsdSce0022Event event = new EsdSce0022Event();

		if (command == null || command.isCommand(FormCommand.SEARCHLIST)) {
			command = null;
		} else if (command.isCommand(FormCommand.MODIFY)) {
			//String [] ibflag = request.getParameterValues("ibflag");
			event.setMdmActivityVOs((MdmActivityVO[])getVOs(request, MdmActivityVO .class,""), userId);
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