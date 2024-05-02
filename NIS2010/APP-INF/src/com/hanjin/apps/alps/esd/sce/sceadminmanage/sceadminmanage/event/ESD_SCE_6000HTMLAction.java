/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_SCE_6000HTMLAction.java
*@FileTitle : SCE Admin
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.02
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.12.02 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.ManRplnRsltVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SceAdminObjVO;
import com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo.SearchLeaMonthlyWorkVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.syscommon.common.table.SceActTmlIfVO;
import com.hanjin.syscommon.common.table.SceBkgOpHisVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce.sceadminmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SceAdminManageSC로 실행요청<br>
 * - SceAdminManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim In-soo
 * @see SceAdminManageEvent 참조
 * @since J2EE 1.6
 */

public class ESD_SCE_6000HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_SCE_6000HTMLAction 객체를 생성
	 */
	public ESD_SCE_6000HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SceAdminManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

//		FormCommand command = FormCommand.fromRequest(request);
		EsdSce6000Event event = new EsdSce6000Event();

		event.setSceAdminObjVO((SceAdminObjVO) getVO(request, SceAdminObjVO.class));
		event.setSceActTmlIfVOs((SceActTmlIfVO[]) getVOs (request, SceActTmlIfVO.class));
		event.setManRplnRsltVOs((ManRplnRsltVO[]) getVOs (request, ManRplnRsltVO.class));
		event.setSceBkgOpHisVOs((SceBkgOpHisVO[]) getVOs (request, SceBkgOpHisVO.class));
		event.setSearchLeaMonthlyWorkVO((SearchLeaMonthlyWorkVO) getVO(request, SearchLeaMonthlyWorkVO.class));
		event.setSearchLeaMonthlyWorkVOs((SearchLeaMonthlyWorkVO[]) getVOs (request, SearchLeaMonthlyWorkVO.class));
		
		event.setLeaAccMon(request.getParameter("leaAccMon"));
		
		return event;
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