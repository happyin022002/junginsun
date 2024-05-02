/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0028HTMLAction.java
*@FileTitle : SKD vs Delay
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.25
*@LastModifier : 황태진
*@LastVersion : 1.0
* 2009.10.08 유혁 
* 1.0 Creation
* 
* History 
* 2013.01.25 황태진    CHM-201322271-01 정시율 조회 조건 변경 및 멀티 저장 처리  

=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.OnTimeRsltAnalGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.VskPortTideVO;
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
 * @author RYU HYUK
 * @see ActualScheduleManagementEvent 참조
 * @since J2EE 1.6
 */

public class VOP_VSK_0028HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0028HTMLAction 객체를 생성
	 */
	public VOP_VSK_0028HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ActualScheduleManagementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand 	command = FormCommand.fromRequest(request);
    	VopVsk0028Event event 	= new VopVsk0028Event();
    	
    	if(command.isCommand(FormCommand.ADD) || command.isCommand(FormCommand.MULTI)){
    		VskVslSkdRsltVO[] array = (VskVslSkdRsltVO[])getVOs(request, VskVslSkdRsltVO.class);
    		List<VskVslSkdRsltVO> list 		= Arrays.asList(array);
			List<VskVslSkdRsltVO> paramVOs 	= new ArrayList<VskVslSkdRsltVO>();

			for(int i=0; i<list.size(); i++){
				if(!"D".equals(list.get(i).getIbflag())){
					paramVOs.add(list.get(i));
				}
			}
    		OnTimeRsltAnalGRPVO vo = new OnTimeRsltAnalGRPVO();
    		vo.setVskVslSkdRsltVOs(paramVOs);
    		event.setOnTimeRsltAnalGRPVO(vo);
    		
    	}else{
    		String[] pfEtbDts 	= request.getParameterValues("pf_etb_dt"	);
    		String[] pfEtdDts 	= request.getParameterValues("pf_etd_dt"	);
    		String[] clptSeq 	= request.getParameterValues("clpt_seq"		);
    		
    		OnTimeRsltAnalGRPVO vo = (OnTimeRsltAnalGRPVO)this.getVO(request, OnTimeRsltAnalGRPVO.class);
    		
    		vo.setPfEtbDts	(pfEtbDts	);
    		vo.setPfEtdDts	(pfEtdDts	);
    		vo.setClptSeq	(clptSeq	);
    		
    		event.setOnTimeRsltAnalGRPVO(vo);	
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