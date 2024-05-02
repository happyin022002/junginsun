/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VOP_VSK_0034HTMLAction.java
*@FileTitle :  Trade Set-Up(Popup)
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

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwSkdSearchVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwTrdInfoVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo.VskPortNworkVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
 
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.vsk.actualschedulemanagement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ActualScheduleManagementSC로 실행요청<br>
 * - ActualScheduleManagementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see ActualScheduleManagementEvent 참조
 * @since J2EE 1.6
 */

public class VOP_VSK_0034HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0034HTMLAction 객체를 생성
	 */
	public VOP_VSK_0034HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ActualScheduleManagementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0034Event event = new VopVsk0034Event();
		

		if(command.isCommand(FormCommand.MULTI)) {
//			event.setDrwPortListVO((DrwPortListVO)getVO(request, DrwPortListVO.class));
		}else if(command.isCommand(FormCommand.ADD)){	
//			event.setDrwTrdInfoVO((DrwTrdInfoVO)getVO(request, DrwTrdInfoVO.class));
//			event.setDrwPortInfoVOs((DrwTrdInfoVO[])getVOs(request, DrwTrdInfoVO.class, "shhet1_"));
			
			DrwTrdInfoVO[] array = (DrwTrdInfoVO[])getVOs(request, DrwTrdInfoVO.class);
    		List<DrwTrdInfoVO> list 		= Arrays.asList(array); 
			List<DrwTrdInfoVO> paramVOs 	= new ArrayList<DrwTrdInfoVO>();
			for(int i=0; i<list.size(); i++){
				if(!"D".equals(list.get(i).getIbflag())){
					paramVOs.add(list.get(i));
				}
			}
			DrwTrdInfoVO vo = new DrwTrdInfoVO();
    		vo.setdrwTrdSaveVOs(paramVOs);

    	}else if(command.isCommand(FormCommand.REMOVE)){	
//			event.setDrwPortInfoVOs((DrwTrdInfoVO[])getVOs(request, DrwTrdInfoVO.class, "shhet1_"));
//			event.setVskPortNworkVOS((VskPortNworkVO[])getVOs(request, VskPortNworkVO .class,"t2sheet1_"));
			DrwTrdInfoVO[] array = (DrwTrdInfoVO[])getVOs(request, DrwTrdInfoVO.class);
    		List<DrwTrdInfoVO> list 		= Arrays.asList(array); 
			List<DrwTrdInfoVO> paramVOs 	= new ArrayList<DrwTrdInfoVO>();
			for(int i=0; i<list.size(); i++){
				if("D".equals(list.get(i).getIbflag())){
					paramVOs.add(list.get(i));
				}
			}
			DrwTrdInfoVO vo = new DrwTrdInfoVO();
    		vo.setdrwTrdSaveVOs(paramVOs);

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