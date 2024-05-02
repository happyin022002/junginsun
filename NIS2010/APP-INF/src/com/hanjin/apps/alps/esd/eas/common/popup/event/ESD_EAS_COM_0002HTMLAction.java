/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_EAS_COM_0002HTMLAction.java
*@FileTitle : Common Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2011-09-30
*@LastModifier : Kim Yong Jin
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.eas.common.popup.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.apps.alps.esd.eas.transportmanage.vo.DOFChgColInqmanageListVO;


/**
 * HTTP Parser<br>
 * - ESD_EAS_COM_0002 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CommonPopUpManagSC로 실행요청<br>
 * - CommonPopUpManagSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author yujin
 * @see EsdEasCom0002Event 참조
 * @since J2EE 1.4
 */
public class ESD_EAS_COM_0002HTMLAction extends HTMLActionSupport {


	/**
	 * ESD_EAS_COM_0002HTMLAction 객체를 생성
	 */
	public ESD_EAS_COM_0002HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EsdEasCom0002Event event = new EsdEasCom0002Event();
		
		event.setDOFChgColInqmanageListVo((DOFChgColInqmanageListVO)getVO(request, DOFChgColInqmanageListVO .class));
		
		String ctrlOfcCd = JSPUtil.getNull(request.getParameter("ctrl_ofc_cd"));
		
		event.getDOFChgColInqmanageListVo().setCtrlOfcCd(ctrlOfcCd);
		
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