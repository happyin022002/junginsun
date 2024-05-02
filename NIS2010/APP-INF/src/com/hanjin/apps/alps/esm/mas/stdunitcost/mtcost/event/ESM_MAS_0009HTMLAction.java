/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0009HTMLAction.java
*@FileTitle : EQ Repo Cost (PA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2006.11.16 임옥영  최초 생성
* 2009.08.13 박수훈  ALPS New Framework 적용[0009]
* 1.0 Creation
* 
* Change history : 
* 2011.07.12 최성민 [CHM-201111826] R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCostListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost2ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost3ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost4ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost5ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost6ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost7ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost8ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost9ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost10ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost11ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost12ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost13ListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo.SearchMTCost14ListVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.mas.stdunitcost 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 STDUnitCostSC로 실행요청<br>
 * - STDUnitCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SOO HOON PARK
 * @see STDUnitCostEvent 참조
 * @since J2EE 1.6
 */

public class ESM_MAS_0009HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_MAS_0009HTMLAction 객체를 생성
	 */
	public ESM_MAS_0009HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 STDUnitCostEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmMas0009Event event = new EsmMas0009Event();
		

		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSearchMTCostListVO((SearchMTCostListVO)getVO(request, SearchMTCostListVO .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setSearchMTCost2ListVO((SearchMTCost2ListVO)getVO(request, SearchMTCost2ListVO .class));
			event.setSearchMTCostListVO((SearchMTCostListVO)getVO(request, SearchMTCostListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setSearchMTCost3ListVO((SearchMTCost3ListVO)getVO(request, SearchMTCost3ListVO .class));
			SearchMTCost2ListVO svo = (SearchMTCost2ListVO)getVO(request, SearchMTCost2ListVO .class);
			svo.unDataFormat();
			event.setSearchMTCost2ListVO(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setSearchMTCost4ListVO((SearchMTCost4ListVO)getVO(request, SearchMTCost4ListVO .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setSearchMTCost5ListVO((SearchMTCost5ListVO)getVO(request, SearchMTCost5ListVO .class));
			event.setSearchMTCost4ListVO((SearchMTCost4ListVO)getVO(request, SearchMTCost4ListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setSearchMTCost6ListVO((SearchMTCost6ListVO)getVO(request, SearchMTCost6ListVO .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setSearchMTCost7ListVO((SearchMTCost7ListVO)getVO(request, SearchMTCost7ListVO .class));
			event.setSearchMTCost6ListVO((SearchMTCost6ListVO)getVO(request, SearchMTCost6ListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setSearchMTCost8ListVO((SearchMTCost8ListVO)getVO(request, SearchMTCost8ListVO .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setSearchMTCost9ListVO((SearchMTCost9ListVO)getVO(request, SearchMTCost9ListVO .class));
			event.setSearchMTCost8ListVO((SearchMTCost8ListVO)getVO(request, SearchMTCost8ListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setSearchMTCost10ListVO((SearchMTCost10ListVO)getVO(request, SearchMTCost10ListVO .class));
			SearchMTCost9ListVO svo = (SearchMTCost9ListVO)getVO(request, SearchMTCost9ListVO .class);
			svo.unDataFormat();
			event.setSearchMTCost9ListVO(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setSearchMTCost11ListVO((SearchMTCost11ListVO)getVO(request, SearchMTCost11ListVO .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH12)) {
			event.setSearchMTCost12ListVO((SearchMTCost12ListVO)getVO(request, SearchMTCost12ListVO .class));
			event.setSearchMTCost11ListVO((SearchMTCost11ListVO)getVO(request, SearchMTCost11ListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH13)) {
			event.setSearchMTCost13ListVO((SearchMTCost13ListVO)getVO(request, SearchMTCost13ListVO .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH14)) {
			event.setSearchMTCost14ListVO((SearchMTCost14ListVO)getVO(request, SearchMTCost14ListVO .class));
			event.setSearchMTCost13ListVO((SearchMTCost13ListVO)getVO(request, SearchMTCost13ListVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND01)){
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			event.setFCostYrmon(svo.getFCostYrmon());
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