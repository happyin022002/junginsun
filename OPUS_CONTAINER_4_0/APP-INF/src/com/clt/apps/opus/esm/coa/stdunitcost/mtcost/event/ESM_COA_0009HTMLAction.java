/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0009HTMLAction.java
*@FileTitle : EQ Repo Cost (PA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2006.11.16 임옥영  최초 생성
* 2009.08.13 박수훈  New Framework 적용[0009]
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO10;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO11;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO12;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO13;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO14;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO2;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO3;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO4;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO5;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO6;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO7;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO8;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.SearchMTCostListVO9;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.coa.stdunitcost 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 STDUnitCostSC로 실행요청<br>
 * - STDUnitCostSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SOO HOON PARK
 * @see STDUnitCostEvent 참조
 * @since J2EE 1.6
 */

public class ESM_COA_0009HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_0009HTMLAction 객체를 생성
	 */
	public ESM_COA_0009HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 STDUnitCostEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmCoa0009Event event = new EsmCoa0009Event();
		

		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSearchMTCostListVO((SearchMTCostListVO)getVO(request, SearchMTCostListVO .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setSearchMTCostListVO2((SearchMTCostListVO2)getVO(request, SearchMTCostListVO2 .class));
			event.setSearchMTCostListVO((SearchMTCostListVO)getVO(request, SearchMTCostListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setSearchMTCostListVO3((SearchMTCostListVO3)getVO(request, SearchMTCostListVO3 .class));
			SearchMTCostListVO2 svo = (SearchMTCostListVO2)getVO(request, SearchMTCostListVO2 .class);
			svo.unDataFormat();
			event.setSearchMTCostListVO2(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setSearchMTCostListVO4((SearchMTCostListVO4)getVO(request, SearchMTCostListVO4 .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setSearchMTCostListVO5((SearchMTCostListVO5)getVO(request, SearchMTCostListVO5 .class));
			event.setSearchMTCostListVO4((SearchMTCostListVO4)getVO(request, SearchMTCostListVO4 .class));
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setSearchMTCostListVO6((SearchMTCostListVO6)getVO(request, SearchMTCostListVO6 .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setSearchMTCostListVO7((SearchMTCostListVO7)getVO(request, SearchMTCostListVO7 .class));
			event.setSearchMTCostListVO6((SearchMTCostListVO6)getVO(request, SearchMTCostListVO6 .class));
		}
		else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setSearchMTCostListVO8((SearchMTCostListVO8)getVO(request, SearchMTCostListVO8 .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setSearchMTCostListVO9((SearchMTCostListVO9)getVO(request, SearchMTCostListVO9 .class));
			event.setSearchMTCostListVO8((SearchMTCostListVO8)getVO(request, SearchMTCostListVO8 .class));
		}
		else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setSearchMTCostListVO10((SearchMTCostListVO10)getVO(request, SearchMTCostListVO10 .class));
			SearchMTCostListVO9 svo = (SearchMTCostListVO9)getVO(request, SearchMTCostListVO9 .class);
			svo.unDataFormat();
			event.setSearchMTCostListVO9(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setSearchMTCostListVO11((SearchMTCostListVO11)getVO(request, SearchMTCostListVO11 .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH12)) {
			event.setSearchMTCostListVO12((SearchMTCostListVO12)getVO(request, SearchMTCostListVO12 .class));
			event.setSearchMTCostListVO11((SearchMTCostListVO11)getVO(request, SearchMTCostListVO11 .class));
		}
		else if(command.isCommand(FormCommand.SEARCH13)) {
			event.setSearchMTCostListVO13((SearchMTCostListVO13)getVO(request, SearchMTCostListVO13 .class));
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
		}
		else if(command.isCommand(FormCommand.SEARCH14)) {
			event.setSearchMTCostListVO14((SearchMTCostListVO14)getVO(request, SearchMTCostListVO14 .class));
			event.setSearchMTCostListVO13((SearchMTCostListVO13)getVO(request, SearchMTCostListVO13 .class));
		}		
		else if(command.isCommand(FormCommand.MULTI01)) {
			SearchConditionVO svo = (SearchConditionVO)getVO(request, SearchConditionVO .class);
			svo.unDataFormat();
			event.setSearchConditionVO(svo);
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