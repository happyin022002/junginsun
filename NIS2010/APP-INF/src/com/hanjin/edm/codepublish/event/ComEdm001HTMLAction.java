/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_COM_EDM_001HTMLAction.java
*@FileTitle : 공통코드관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-07
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-09-07 SeongWook Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.edm.codepublish.event;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.COM_CODEDOMAIN;
import com.hanjin.syscommon.common.table.COM_CODEVALUE;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.edm.codepublish 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CodePublishSC로 실행요청<br>
 * - CodePublishSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author SeongWook Kim
 * @see ComEdm001Event , UI_COM_EDM_001EventResponse 참조
 * @since J2EE 1.4
 */
public class ComEdm001HTMLAction extends HTMLActionSupport {

	/**
	 * UI_COM_EDM_001HTMLAction 객체를 생성
	 */
	public ComEdm001HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 UI_COM_EDM_001Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		String id         = JSPUtil.getParameter(request, "id        ".trim(), "");
        String codeid     = JSPUtil.getParameter(request, "codeid    ".trim(), "");
        String name       = JSPUtil.getParameter(request, "name      ".trim(), "");
        String definition = JSPUtil.getParameter(request, "definition".trim(), "");
        String datatype   = JSPUtil.getParameter(request, "datatype  ".trim(), "");
        String precision  = JSPUtil.getParameter(request, "precision ".trim(), "");
        String var1       = JSPUtil.getParameter(request, "var1      ".trim(), "");
        String var2       = JSPUtil.getParameter(request, "var2      ".trim(), "");
        String var4       = JSPUtil.getParameter(request, "var4      ".trim(), "");
        String var5       = JSPUtil.getParameter(request, "var5      ".trim(), "");
        String searchtype = JSPUtil.getParameter(request, "searchtype".trim(), "0");
        String selectedcodes = JSPUtil.getParameter(request, "selectedcodes".trim(), "0");
		String f_cmd         = JSPUtil.getParameter(request, "f_cmd        ".trim(), "-1");
        
		/* 
         ibSheet 사용시 fromRequestGrid를 사용하는데 
         prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 ) 
         String prefix = "" ;  
         T_CODEDOMAIN t_codedomain = T_CODEDOMAIN.fromRequestGrid(request, prefix);
        */ 
        COM_CODEDOMAIN t_codedomain = COM_CODEDOMAIN.fromRequest(request);
        /* 
         ibSheet 사용시 fromRequestGrid를 사용하는데 
         prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 ) 
         String prefix = "" ;  
         T_CODEVALUE  t_codevalue  = T_CODEVALUE .fromRequestGrid(request, prefix);
        */ 
        COM_CODEVALUE  t_codevalue  = COM_CODEVALUE.fromRequest(request);

    	Collection t_codes = null;
        if(Integer.parseInt(f_cmd)==FormCommand.MULTI){
        	t_codes = COM_CODEDOMAIN.fromRequestGrid(request,"");
        }
        
        ComEdm001Event event = null; 
        
		event = new ComEdm001Event(
                t_codedomain,  // table value object
                t_codes     ,  // table value Collection object
                t_codevalue ,  // table value object
                null,  // table value Collection object
                id          ,  // form tag name
                codeid      ,  // form tag name
                name        ,  // form tag name
                definition  ,  // form tag name
                datatype    ,  // form tag name
                precision   ,  // form tag name
                var1        ,  // form tag name
                var2        ,  // form tag name
                var4        ,  // form tag name
                var5        ,
                searchtype  ,
                selectedcodes); // form tag name
        
		
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