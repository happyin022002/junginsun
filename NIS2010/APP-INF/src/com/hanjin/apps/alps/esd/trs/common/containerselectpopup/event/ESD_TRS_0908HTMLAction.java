/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_908HTMLAction.java
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.29
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2006.10.31 kim_sang_geun
* 1.0 최초 생성
* --------------------------------------------------------
* History
* 2010.09.29 최 선  1.1 [] 불필요 variable 정리
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.containerselectpopup.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.common 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CommonSC로 실행요청<br>
 * - CommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kim_sang_geun
 * @see EsdTrs0908Event , ESD_TRS_908EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0908HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_908HTMLAction 객체를 생성
	 */
	public ESD_TRS_0908HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_908Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		String [] bkg_no = request.getParameterValues("bkg_no");
		String bkgNo = request.getParameter("bkgNo");
		String orgBkgNo = request.getParameter("orgBkgNo");

		TrsTrspSvcOrdVO trsTrspSvcOrdVO = new TrsTrspSvcOrdVO();
		
		EsdTrs0908Event event = new EsdTrs0908Event();
		event.setBkgNos(bkg_no);
		event.setBkgNo(bkgNo);
		event.setOrgBkgNo(orgBkgNo);

		event.setTrsTrspSvcOrdVOs(trsTrspSvcOrdVO.fromRequestGrid(request));
		
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