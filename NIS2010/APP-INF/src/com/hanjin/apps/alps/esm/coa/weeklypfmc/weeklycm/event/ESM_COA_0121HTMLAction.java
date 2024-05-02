/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_COA_0121HTMLAction.java
*@FileTitle : Lane Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.31
*@LastModifier : SHKIM
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchSeasonalSMUCostListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchSeasonalSMUCostPopListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.CoaLaneDirConvVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.coa.weeklypfmc 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WeeklyPFMCSC로 실행요청<br>
 * - WeeklyPFMCSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Haeng-ji,Lee
 * @see WeeklyPFMCEvent 참조
 * @since J2EE 1.6
 */

public class ESM_COA_0121HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_0121HTMLAction 객체를 생성
	 */
	public ESM_COA_0121HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 WeeklyPFMCEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmCoa0121Event event = new EsmCoa0121Event();
		
		if(command.isCommand(FormCommand.MULTI01)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setCoaLaneDirConvVOS((CoaLaneDirConvVO[])getVOs(request, CoaLaneDirConvVO .class,""));
		}else if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setSearchSeasonalSMUCostPopListVO((SearchSeasonalSMUCostPopListVO)getVO(request, SearchSeasonalSMUCostPopListVO .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
		}else if(command.isCommand(FormCommand.SEARCHLIST10) || command.isCommand(FormCommand.SEARCHLIST11)) {
			event.setSearchSeasonalSMUCostPopListVO((SearchSeasonalSMUCostPopListVO)getVO(request, SearchSeasonalSMUCostPopListVO .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
						
		}else{
			event.setCoaLaneDirConvVO((CoaLaneDirConvVO)getVO(request, CoaLaneDirConvVO.class));
		}

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