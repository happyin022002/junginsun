/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_051HTMLAction.java
*@FileTitle : 항로 Simulation 마스터 및 W/F 생성/조회/변경
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-28
*@LastModifier : eunju park
*@LastVersion : 1.0
* 2006-08-28 eunju park
* 1.0 최초 생성
* 2009.03.31 박상희 S2K-09U-002(Lane Simulation System 개선)
* 2010.02.18 serialVersionUID 선언
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.LaneInfoListConditionVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimLaneListVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimVesselListConditionVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimVesselListVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchVesselInfoConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.coa 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 LaneSimulationSC로 실행요청<br>
 * - LaneSimulationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author eunju park
 * @see EsmCoa0051Event 참조
 * @since J2EE 1.6
 */
public class ESM_COA_0051HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
    /**
     * ESM_COA_0051HTMLAction 객체를 생성
     */
    public ESM_COA_0051HTMLAction() {
    	//
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsmCoa0051Event 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmCoa0051Event event = new EsmCoa0051Event();
  	    if(command.isCommand(FormCommand.SEARCHLIST03)) {
  	    	event.setLaneInfoListConditionVO((LaneInfoListConditionVO)getVO(request, LaneInfoListConditionVO .class));
  	    } else if (command.isCommand(FormCommand.SEARCHLIST01)) {
  	    	event.setSearchSimLaneListConditionVO((SearchSimLaneListConditionVO)getVO(request, SearchSimLaneListConditionVO .class));
  	    } else if (command.isCommand(FormCommand.SEARCHLIST02)) {
  	    	event.setSearchSimVesselListConditionVO((SearchSimVesselListConditionVO)getVO(request, SearchSimVesselListConditionVO .class));
  	    } else if (command.isCommand(FormCommand.MULTI01)) {
  	    	event.setSearchSimLaneListVOS((SearchSimLaneListVO[])getVOs(request, SearchSimLaneListVO.class));
  	    } else if (command.isCommand(FormCommand.REMOVE01)) {
  	    	event.setSearchSimLaneListConditionVOS((SearchSimLaneListConditionVO[])getVOs(request, SearchSimLaneListConditionVO.class));
  	    } else if (command.isCommand(FormCommand.MULTI02)) {
  	    	event.setSearchSimVesselListVOS((SearchSimVesselListVO[])getVOs(request, SearchSimVesselListVO.class));
  	    } else if (command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH02)) {
  	    	event.setSearchVesselInfoConditionVO((SearchVesselInfoConditionVO)getVO(request, SearchVesselInfoConditionVO.class));
  	    }else{
  	    	event.setSearchSimLaneListConditionVO((SearchSimLaneListConditionVO)getVO(request, SearchSimLaneListConditionVO .class));
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