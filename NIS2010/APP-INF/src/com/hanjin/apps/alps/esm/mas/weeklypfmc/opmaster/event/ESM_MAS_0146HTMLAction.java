/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0146HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.03 김기대
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.event;


import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.mas.common.vo.CommonMasRsVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.MasVslRgstVO;
import com.hanjin.syscommon.common.table.MasVslSubTrdCapaVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WeeklyPFMCSC로 실행요청<br>
 * - WeeklyPFMCSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Ki Dae
 * @see EsmMas0146Event 참조
 * @since J2EE 1.6
 */
public class ESM_MAS_0146HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_MAS_0146HTMLAction 객체를 생성
	 */
	public ESM_MAS_0146HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmMas0146Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmMas0146Event event = new EsmMas0146Event();
    	CommonMasRsVO commonMasRsVO = new CommonMasRsVO();
    	
		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setCommonMasRsVO(commonMasRsVO);
		}	
		else if(command.isCommand(FormCommand.MULTI01)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setMasVslSubTrdCapaVOs((MasVslSubTrdCapaVO[])getVOs(request, MasVslSubTrdCapaVO.class));
			event.setMasVslRgstVOs((MasVslRgstVO[])getVOs(request, MasVslRgstVO.class));
			event.setCommonMasRsVO(commonMasRsVO);
			event.getCommonMasRsVO().requestToHashMap(request);
		}
		else{
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setCommonMasRsVO(commonMasRsVO);
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