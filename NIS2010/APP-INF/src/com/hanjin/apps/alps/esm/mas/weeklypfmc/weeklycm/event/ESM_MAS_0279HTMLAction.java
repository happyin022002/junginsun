/*=========================================================
*Copyright(c) 2014 CyberLogitec
**@FileName : ESM_MAS_0279HTMLAction.java
*@FileTitle : DEM/DET Cost Report by BKG (Detail)
*Open Issues :
*Change history :
*@LastModifyDate : 2015-03-17
*@LastModifier : Je Ryang Yoo
*@LastVersion :
*  2015-03-17 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.DEMDETCostReportbyBKGDetailVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 NetworkCostSC로 실행요청<br>
 * - NetworkCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Je Ryang Yoo
 * @see EsmMas0279Event 참조
 * @since J2EE 1.6
 */
public class ESM_MAS_0279HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_MAS_0279HTMLAction 객체를 생성
	 */
	public ESM_MAS_0279HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmMas0279Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
    	EsmMas0279Event event = new EsmMas0279Event();  	
    			
		// 조회
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setDEMDETCostReportbyBKGDetailVO((DEMDETCostReportbyBKGDetailVO)getVO(request, DEMDETCostReportbyBKGDetailVO.class));			
		}
		// 저장
		else if(command.isCommand(FormCommand.MULTI)) {			
			event.setDEMDETCostReportbyBKGDetailVOs((DEMDETCostReportbyBKGDetailVO[])getVOs(request, DEMDETCostReportbyBKGDetailVO.class, ""));			
		}
		else {
			event.setDEMDETCostReportbyBKGDetailVO((DEMDETCostReportbyBKGDetailVO)getVO(request, DEMDETCostReportbyBKGDetailVO.class));
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
		}

		request.setAttribute("Event", event);
		
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
