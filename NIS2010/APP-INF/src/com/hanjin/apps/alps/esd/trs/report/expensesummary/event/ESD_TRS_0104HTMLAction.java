/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_104HTMLAction.java
*@FileTitle : Expense Summary by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009-01-08
*@LastModifier : ah young Han
*@LastVersion : 1.0
* 2009-01-08 ah young Han
* 1.0 최초 생성
* ----------------------------------------------------------
* History
* N200901080024  2009-02-27 'Report(Expense Summary by Office) 메뉴 개발 요청 '
* 2012.02.15 금병주 1.6 [CHM-201216258] [TRS] Expense Summary Excel Down 버튼 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.expensesummary.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.report.expensesummary.vo.SearchHeaderVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.report 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TRSReportSC로 실행요청<br>
 * - TRSReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author ah young Han
 * @see EsdTrs0104Event , ESD_TRS_104EventResponse 참조
 * @since J2EE 1.4
 */   
public class ESD_TRS_0104HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_104HTMLAction 객체를 생성
	 */    
	public ESD_TRS_0104HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_104Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {		
		EsdTrs0104Event event = new EsdTrs0104Event();
		SearchHeaderVO searchHeaderVO = new SearchHeaderVO();
		searchHeaderVO.fromRequest(request);
		event.setSearchHeaderVO(searchHeaderVO);

		//grid flg event 로 전달 2012.02.15 kbj
		event.setGrid_flg(JSPUtil.getNull(request.getParameter("hid_grid_flg")));
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