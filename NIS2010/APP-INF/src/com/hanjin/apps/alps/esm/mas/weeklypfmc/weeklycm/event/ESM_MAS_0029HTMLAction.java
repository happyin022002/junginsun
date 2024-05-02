/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0029HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.03 김기대
* 1.0 Creation
*=========================================================
* History 
* 2011.06.02 최성민 [CHM-201111115-01] Split 02-Split 03-ALPS Error 처리 요청 - SEARCH11, SEARCH12 추가
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;


import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.MultiMasMonVvdVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.WeeklyCMCommonVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WeeklyPFMCSC로 실행요청<br>
 * - WeeklyPFMCSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Ki Dae
 * @see EsmMas0029Event 참조
 * @since J2EE 1.6
 */
public class ESM_MAS_0029HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * TESTHTMLAction 객체를 생성
	 */
	public ESM_MAS_0029HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmMas0029Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmMas0029Event event = new EsmMas0029Event();  		
    	
		if(command.isCommand(FormCommand.SEARCHLIST01)) {// Retrieve
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setWeeklyCMCommonVO((WeeklyCMCommonVO)getVO(request, WeeklyCMCommonVO.class));
		}	
		else if(command.isCommand(FormCommand.MULTI01)) {// Save
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setWeeklyCMCommonVO((WeeklyCMCommonVO)getVO(request, WeeklyCMCommonVO.class));
			event.setWeeklyCMCommonVOs((WeeklyCMCommonVO[])getVOs(request, WeeklyCMCommonVO.class, "NoPrefix#ibflag"));
			event.setMultiMasMonVvdVOs((MultiMasMonVvdVO[])getVOs(request, MultiMasMonVvdVO.class));
		}				
		else if(command.isCommand(FormCommand.MULTI02)) {// Creation
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setWeeklyCMCommonVO((WeeklyCMCommonVO)getVO(request, WeeklyCMCommonVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI03)) {// Menual Batch
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setWeeklyCMCommonVO((WeeklyCMCommonVO)getVO(request, WeeklyCMCommonVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI04)) {// TsQty
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setWeeklyCMCommonVO((WeeklyCMCommonVO)getVO(request, WeeklyCMCommonVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI05)) {// BSA Flag가 Y인것들을 BSA VVD의 값을 0으로 만들어 준다.(BSA 0)
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setWeeklyCMCommonVO((WeeklyCMCommonVO)getVO(request, WeeklyCMCommonVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI06)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setMultiMasMonVvdVOs((MultiMasMonVvdVO[])getVOs(request, MultiMasMonVvdVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setComBakEndJbVO((ComBakEndJbVO)getVO(request, ComBakEndJbVO.class));
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
		}	
		else if(command.isCommand(FormCommand.SEARCH12)) {
			event.setComBakEndJbVO((ComBakEndJbVO)getVO(request, ComBakEndJbVO .class));
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
		}
		else{
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setWeeklyCMCommonVO((WeeklyCMCommonVO)getVO(request, WeeklyCMCommonVO.class));
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
