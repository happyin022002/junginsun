/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_910HTMLAction.java
*@FileTitle : ESM_BKG_910HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.01 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Min Jeong
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 **/
public class ESM_BKG_0910HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	/**************************************************************************
	 * ESM_BKG_0329HTMLAction 객체를 생성
	 **************************************************************************/
	public ESM_BKG_0910HTMLAction() {}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) 
	throws HTMLActionException 
	{
    	EsmBkg0910Event event = new EsmBkg0910Event();
    	  
    	request.setAttribute("Event", event);

		return  event;
	}
}