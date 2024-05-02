/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0118HTMLAction.java
*@FileTitle : COP Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2008-08-01
*@LastModifier : sanghyun-kim
*@LastVersion : 1.0
* 2008-08-01 sanghyun-kim
* 1.0 최초 생성
* 2009.09.03 - 오현경  - NIS2010 Construction
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.CommonWebKeys;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import java.util.Enumeration;
import java.util.HashMap;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 COPManageSC로 실행요청<br>
 * - COPManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author sanghyun-kim
 * @see EsdSce0118Event , EsdSce0118EventResponse 참조
 * @since J2EE 1.4
 */

public class ESD_SCE_0118HTMLAction extends HTMLActionSupport {
	/**
     * ESD_SCE_0118HTMLAction 객체를 생성
     */
    public ESD_SCE_0118HTMLAction() {
    }
    
    /**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdSce0002Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
		SignOnUserAccount account = (SignOnUserAccount) request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		String userId = account.getUsr_id();
    	
    	FormCommand command = FormCommand.fromRequest(request);
    	EsdSce0118Event event = new EsdSce0118Event();
		if (command.isCommand(FormCommand.SEARCHLIST) || command.isCommand(FormCommand.SEARCHLIST01) || command.isCommand(FormCommand.MODIFY01)){
			event.setConditionVO((COPInquiryVO)getVO(request, COPInquiryVO .class));
			event.getConditionVO().setUsrId(userId);
		}

        return event;
    }
    
    /** request 내의 parameter의 값을 HashMap으로 반환한다.
     * @param request
     * @return hMap
     */
    public HashMap getParameterArray(HttpServletRequest request){
        String keyName = "";
        String keyValue = "";
        HashMap hMap = new HashMap();
        
        for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ){
            try{
	            keyName = (String)en.nextElement();
	            keyValue = JSPUtil.getParameter(request, keyName.trim(), "");
            }catch(Exception ex){
            	log.error("err " + ex.toString(), ex);
                keyValue = "";
            }
            hMap.put(keyName, keyValue);
        }
        return hMap;
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
    /** HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
     * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @param event Event interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, Event event) {
        request.setAttribute("Event", event);
    }
}
