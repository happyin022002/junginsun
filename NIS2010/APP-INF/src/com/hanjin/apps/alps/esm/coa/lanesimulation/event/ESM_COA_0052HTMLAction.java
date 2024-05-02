/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_052HTMLAction.java
*@FileTitle : Proforma SKD 조회/변경
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-06
*@LastModifier : Park Eun Ju
*@LastVersion : 1.0
* 2006-09-06 Park Eun Ju
* 1.0 최초 생성
* 2009.03.31 박은주 S2K-09U-002(Lane Simulation System 개선)
* 2010.02.18 serialVersionUID 선언
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.event;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.MergyVolProjConditionVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimCalcVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimConditionVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimLaneRPBListVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimPortListVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimYardConditionVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchTMLOPDysListVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
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
 * @author Park Eun Ju
 * @see EsmCoa0052Event 참조
 * @since J2EE 1.6
 */
public class ESM_COA_0052HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
    /**
     * ESM_COA_0052HTMLAction 객체를 생성
     */
    public ESM_COA_0052HTMLAction() {
    	//
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 ESM_COA_052Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmCoa0052Event event = new EsmCoa0052Event();
      
  	    if(command.isCommand(FormCommand.SEARCHLIST04)) { 
  	    	event.setSearchSimLaneListConditionVO((SearchSimLaneListConditionVO)getVO(request, SearchSimLaneListConditionVO .class));
  	    } else if(command.isCommand(FormCommand.SEARCHLIST06)) {
  	    	event.setSearchSimConditionVO((SearchSimConditionVO)getVO(request, SearchSimConditionVO .class));
  	    } else if(command.isCommand(FormCommand.SEARCHLIST05)) {
  	    	event.setSearchSimConditionVO((SearchSimConditionVO)getVO(request, SearchSimConditionVO .class));  	    	
    	} else if(command.isCommand(FormCommand.MULTI02)) {
  	    	event.setSearchSimLaneRPBListVOS((SearchSimLaneRPBListVO[])getVOs(request, SearchSimLaneRPBListVO .class));
  	    } else if(command.isCommand(FormCommand.MULTI03)|| 
  	    			command.isCommand(FormCommand.MULTI04)) {
  	    	event.setMergyVolProjConditionVOS((MergyVolProjConditionVO[])getVOs(request, MergyVolProjConditionVO .class));
  	    	event.setMergyVolProjConditionVO((MergyVolProjConditionVO)getVO(request, MergyVolProjConditionVO .class));
    	}else if(command.isCommand(FormCommand.MULTI07)) {
  	    	event.setMergyVolProjConditionVO((MergyVolProjConditionVO)getVO(request, MergyVolProjConditionVO .class));
  	    	event.setSearchSimLaneListConditionVO((SearchSimLaneListConditionVO)getVO(request, SearchSimLaneListConditionVO .class));
  	    } else if(command.isCommand(FormCommand.SEARCHLIST07) ||
  	    			command.isCommand(FormCommand.MULTI08)) {
  	    	event.setSearchTMLOPDysListVO((SearchTMLOPDysListVO)getVO(request, SearchTMLOPDysListVO .class));
  	    } else if(command.isCommand(FormCommand.MULTI05)) {
  	    	event.setSearchTMLOPDysListVO((SearchTMLOPDysListVO)getVO(request, SearchTMLOPDysListVO .class));
  	    	event.setSearchTMLOPDysListVOS((SearchTMLOPDysListVO[])getVOs(request, SearchTMLOPDysListVO .class));
  	    } else if(command.isCommand(FormCommand.SEARCHLIST01)) {
  	    	event.setSearchSimLaneListConditionVO((SearchSimLaneListConditionVO)getVO(request, SearchSimLaneListConditionVO .class));
  	    } else if(command.isCommand(FormCommand.SEARCHLIST02)) {
  	    	event.setSearchSimYardConditionVO((SearchSimYardConditionVO)getVO(request, SearchSimYardConditionVO .class));
  	    } else if(command.isCommand(FormCommand.MULTI01)) {
  	    	event.setSearchSimPortListVOS((SearchSimPortListVO[])getVOs(request, SearchSimPortListVO .class));
  	    	event.setSearchSimLaneListConditionVO((SearchSimLaneListConditionVO)getVO(request, SearchSimLaneListConditionVO .class));
  	    } else if(command.isCommand(FormCommand.MULTI06)) {
  	    	event.setSearchSimPortListVOS((SearchSimPortListVO[])getVOs(request, SearchSimPortListVO .class));
  	    	event.setSearchSimLaneListConditionVO((SearchSimLaneListConditionVO)getVO(request, SearchSimLaneListConditionVO .class));
  	    } else if(command.isCommand(FormCommand.MULTI09)) {
//       calculation local BC 사용 version  ####################################################################
//   	    SearchSimCalcVO grpVO = new SearchSimCalcVO();
//  	    SearchSimPortListVO[] dtlVOs = (SearchSimPortListVO[])getVOs(request, SearchSimPortListVO .class);
//			List<SearchSimPortListVO> searchSimPortListVOs = Arrays.asList(dtlVOs);
//			grpVO.setSearchSimPortListVOs(searchSimPortListVOs);
//			event.setSearchSimCalcVO(grpVO);
//       #######################################################################################################  	    	
  	    	
  	    	//Calcu logic VSK BC 사용 version ##############################################
  	    	SearchSimCalcVO tmpVO = new SearchSimCalcVO();
  	    	
  	    	SearchSimPortListVO[] tmpVOs = (SearchSimPortListVO[])getVOs(request, SearchSimPortListVO .class);
			List<SearchSimPortListVO> searchSimPortListVOs = Arrays.asList(tmpVOs);
			tmpVO.setSearchSimPortListVOs(searchSimPortListVOs);

			event.setSearchSimCalcVO(tmpVO);  	    	
  	    	
    		PfSkdGRPVO grpVO = new PfSkdGRPVO ();
  	    	VskPfSkdDtlVO[] dtlVOs = (VskPfSkdDtlVO[])getVOs(request, VskPfSkdDtlVO .class);
			List<VskPfSkdDtlVO> vskPfSkdDtlVOs = Arrays.asList(dtlVOs);
//        	for(int i=0;i< vskPfSkdDtlVOs.size() ; i++) {
//        		Map colValues = ((AbstractValueObject)vskPfSkdDtlVOs.get(i)).getColumnValues();
//        		for(int j=0;j<colValues.size();j++) {
//        			if(j==0)
//        		}	
//      		}
			grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);
			event.setPfSkdGRPVO(grpVO);  	
			//##############################################################################
			
  	    } else if(command.isCommand(FormCommand.SEARCHLIST03)) {
  	    	event.setSearchSimLaneListConditionVO((SearchSimLaneListConditionVO)getVO(request, SearchSimLaneListConditionVO .class));
  	    }else{
  	    	event.setSearchSimLaneListConditionVO((SearchSimLaneListConditionVO)getVO(request, SearchSimLaneListConditionVO .class));
  	    }
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