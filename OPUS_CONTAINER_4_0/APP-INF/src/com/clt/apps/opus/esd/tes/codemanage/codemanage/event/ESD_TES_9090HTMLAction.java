/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_9090HTMLAction.java
*@FileTitle : User Password
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.06 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage.codemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.tes.codemanage.codemanage.vo.TesCodeManageCommonVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.syscommon.common.table.ComUserVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tes.codemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CodeManageSC에서 실행요청<br>
 * - CodeManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author yOng hO lEE
 * @see EsdTes9090Event 참조
 * @since J2EE 1.6
 */
public class ESD_TES_9090HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TES_9090HTMLAction 객체를 생성
	 */
	public ESD_TES_9090HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdTes9090Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request  
	 * @return Event 
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsdTes9090Event	event	= new EsdTes9090Event();

		event.setComUserVO				((ComUserVO)				getVO(request, ComUserVO .class));
		event.setTesCodeManageCommonVO	((TesCodeManageCommonVO)	getVO(request, TesCodeManageCommonVO .class));

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request  
	 * @param eventResponse 
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request  
	 * @param event 
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}