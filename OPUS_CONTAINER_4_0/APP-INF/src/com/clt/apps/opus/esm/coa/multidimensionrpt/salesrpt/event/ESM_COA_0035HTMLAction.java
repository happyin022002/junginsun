/*
 * =========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName 		: ESM_COA_135HTMLAcion.java
 *@FileTitle 		: STP Income Inquiry
 *Open Issues 		:
 *Change history 	:
 *@LastModifyDate	: 2007-04-06
 *@LastModifier 	: Ari
 *@LastVersion 		: 1.0
 * 2007-04-06 Ari
 * 1.0 최초 생성
 ===========================================================
 ' History :
 ' 2008.08.29 박상희 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 디렉토리 변경 
 * =========================================================
 */
package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoConditionVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.coa.MultiDimensionRPT 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MultiDimensionRPTSC로 실행요청<br>
 * - MultiDimensionRPTSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Ari
 * @see EsmCoa0035Event , ESM_COA_0035EventResponse 참조
 * @since J2EE 1.4
 */
public class ESM_COA_0035HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_COA_0035HTMLAction 객체를 생성
	 */
	public ESM_COA_0035HTMLAction() {
		//
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmCoa0035Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) {

		//FormCommand command = FormCommand.fromRequest(request);
		EsmCoa0035Event event = new EsmCoa0035Event();

		event.setSalesOffiRepoConditionVO((SalesOffiRepoConditionVO)getVO(request, SalesOffiRepoConditionVO .class));
		event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
		
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