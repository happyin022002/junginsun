/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_107HTMLAction.java
*@FileTitle : Expense Summary by S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2009-01-07
*@LastModifier : jh choi
*@LastVersion : 1.2
* 2009-01-07 jh choi
* 1.0 최초 생성
* @history
* N200901080023 2009-03-04 Expense Summary Report S/P 메뉴개발
* 2012.02.23 금병주[CHM-201216258] [TRS] Expense Summary Excel Down 버튼 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.expensesummary.event;

import java.util.Enumeration;
import java.util.HashMap;

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
 * - Parsing 한 정보를 Event로 변환, request에 담아 ExpenseSummarySC로 실행요청<br>
 * - ExpenseSummarySC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author poong yeon cho
 * @see EsdTrs0107Event , ESD_TRS_107EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0107HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_107HTMLAction 객체를 생성
	 */
	public ESD_TRS_0107HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_107Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		EsdTrs0107Event event = new EsdTrs0107Event();
		
		SearchHeaderVO searchHeaderVO = new SearchHeaderVO();
		searchHeaderVO.fromRequest(request);
		event.setSearchHeaderVO(searchHeaderVO);
		
		//grid flg event 로 전달 2012.02.22 kbj
		event.setGrid_flg(JSPUtil.getNull(request.getParameter("hid_grid_flg")));
		
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