/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VOP_VSK_0030HTMLAction.java
*@FileTitle :  Drewry Vessel On-Time Report
*Open Issues :
*Change history : 2016.02.19
*@LastModifyDate : 2016.02.19 
*@LastModifier : 임예지
*@LastVersion : 1.0
*2016.02.19 임예지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdRtoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwPortListVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwSkdSearchVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.OnTimeRsltAnalGRPVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.VskVslDrwSkdVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.VskVslSkdRsltVO;
 

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.vsk.actualschedulemanagement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ActualScheduleManagementSC로 실행요청<br>
 * - ActualScheduleManagementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see ActualScheduleManagementEvent 참조
 * @since J2EE 1.6
 */

public class VOP_VSK_0030HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0030HTMLAction 객체를 생성
	 */
	public VOP_VSK_0030HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ActualScheduleManagementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0030Event event = new VopVsk0030Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setDrwSkdSearchVO((DrwSkdSearchVO)getVO(request, DrwSkdSearchVO.class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setVskVslDrwSkdVO((VskVslDrwSkdVO)getVO(request, VskVslDrwSkdVO.class));
		}else if(command.isCommand(FormCommand.MULTI)){
			DrwSkdSearchVO[] array = (DrwSkdSearchVO[])getVOs(request, DrwSkdSearchVO.class);
    		List<DrwSkdSearchVO> list 		= Arrays.asList(array); 
			List<DrwSkdSearchVO> paramVOs 	= new ArrayList<DrwSkdSearchVO>();
			for(int i=0; i<list.size(); i++){
				if(!"D".equals(list.get(i).getIbflag())){
					paramVOs.add(list.get(i));
				}
			}
			DrwSkdSearchVO vo = new DrwSkdSearchVO();
    		vo.setdrwSkdSaveVOs(paramVOs);
    		event.setDrwSkdSearchVO(vo);
    	}else if(command.isCommand(FormCommand.REMOVE)){
			DrwSkdSearchVO[] array = (DrwSkdSearchVO[])getVOs(request, DrwSkdSearchVO.class);
    		List<DrwSkdSearchVO> list 		= Arrays.asList(array); 
			List<DrwSkdSearchVO> paramVOs 	= new ArrayList<DrwSkdSearchVO>();
			for(int i=0; i<list.size(); i++){
				if("D".equals(list.get(i).getIbflag())){
					paramVOs.add(list.get(i));
				}
			}
			DrwSkdSearchVO vo = new DrwSkdSearchVO();
    		vo.setdrwSkdSaveVOs(paramVOs);
    		event.setDrwSkdSearchVO(vo);
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