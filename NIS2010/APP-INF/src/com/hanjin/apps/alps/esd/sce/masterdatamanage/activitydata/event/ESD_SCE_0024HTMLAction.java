/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0024HTMLAction.java
*@FileTitle :  COP Scheduling Logic Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-08-29 Se-Hoon PARK
* 1.0 최초 생성
* 2009-10-06  : hyun-kyoung oh NIS2010 construction
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.vo.SearchSKDLogicListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.CommonWebKeys;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SceCopSkdLgcVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserManagerSC로 실행요청<br>
 * - UserManagerSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Se-Hoon PARK
 * @see EsdSce0024Event , EsdSce0024EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0024HTMLAction extends HTMLActionSupport {


    /**
     * ESD_SCE_0024HTMLAction 객체를 생성
     */
    public ESD_SCE_0024HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsdSce0024Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	//RequestDataSetBC dataSet = RequestDataSetBC.getInstance(request) ;
		SignOnUserAccount account = (SignOnUserAccount) request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		String userId = account.getUsr_id();      	
    	FormCommand command = FormCommand.fromRequest(request);        
		EsdSce0024Event event = new EsdSce0024Event();
		if (command.isCommand(FormCommand.SEARCHLIST)) {
			event.setSearchSKDLogicListVO((SearchSKDLogicListVO)getVO(request, SearchSKDLogicListVO .class));
		} else if (command.isCommand(FormCommand.MULTI)) {
			//String [] ibflag = request.getParameterValues("ibflag");
			event.setSceCopSkdLgcVOs((SceCopSkdLgcVO[])getVOs(request, SceCopSkdLgcVO .class, ""), userId);
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