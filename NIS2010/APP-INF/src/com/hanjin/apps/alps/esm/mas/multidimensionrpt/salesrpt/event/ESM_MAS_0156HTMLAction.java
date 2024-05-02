/**=========================================================
 *Copyright(c) 2007 CyberLogitec
 *@FileName       : ESM_MAS_156HTMLAction.java
 *@FileTitle      : Inquiry by BKG (ABC/STP)
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 2008-06-02
 *@LastModifier   : Park Eun Ju
 *@LastVersion    : 1.0
 * 2008-06-02 Park Eun Ju
 * 1.0 최초 생성
===========================================================
 ' History :
 ' 2008.08.29 박상희 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 디렉토리 변경  
 * 2009.10.20 김기식   New FrameWork 적용 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SalesOffiRepoConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;



/** 
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.esm.mas.MultiDimensionRPT 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MultiDimensionRPTSC로 실행요청<br>
 * - MultiDimensionRPTSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Park Eun Ju 
 * @see ESM_MAS_0156Event , ESM_MAS_0156EventResponse 참조
 * @since J2EE 1.4
 */
public class ESM_MAS_0156HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_MAS_070HTMLAction 객체를 생성
	 */
	public ESM_MAS_0156HTMLAction() {
		//
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESM_MAS_0156Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		//FormCommand command = FormCommand.fromRequest(request);
		EsmMas0156Event event = new EsmMas0156Event();

		event.setSalesOffiRepoConditionVO((SalesOffiRepoConditionVO)getVO(request, SalesOffiRepoConditionVO .class));
		
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