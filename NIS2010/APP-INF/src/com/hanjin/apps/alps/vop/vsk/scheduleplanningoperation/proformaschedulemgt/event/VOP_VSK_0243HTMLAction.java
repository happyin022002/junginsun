/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0243HTMLAction.java
*@FileTitle : EOTP 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.08.05 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.VskPfSkdVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SchedulePlanningOperationSC로 실행요청<br>
 * - SchedulePlanningOperationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SEO CHANG YUL
 * @see SchedulePlanningOperationEvent 참조
 * @since J2EE 1.6
 */

public class VOP_VSK_0243HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0243HTMLAction 객체를 생성
	 */
	public VOP_VSK_0243HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SchedulePlanningOperationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0243Event event = new VopVsk0243Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			String histYr = request.getParameter("hist_yr");
			PfSkdGRPVO grpVO = new PfSkdGRPVO();
			
			VskPfSkdVO[] tempVOs = (VskPfSkdVO[])getVOs(request, VskPfSkdVO.class,"sheet1_");
			VskPfSkdVO vskPfSkdVO = new VskPfSkdVO();
		
			for(int i=0; i<tempVOs.length; i++){
				vskPfSkdVO = tempVOs[i];
			}			
			vskPfSkdVO.setPfSkdRmk(histYr);
			grpVO.setVskPfSkdVO(vskPfSkdVO);
			
			VskPfSkdDtlVO[] dtlVOs = (VskPfSkdDtlVO[])getVOs(request, VskPfSkdDtlVO .class,"sheet2_");
			List<VskPfSkdDtlVO> vskPfSkdDtlVOs = Arrays.asList(dtlVOs);
		
			grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);
			
			event.setPfSkdGRPVO(grpVO);
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			String histYr 	= request.getParameter("hist_yr");
			String eventNav = request.getParameter("eventNav");
			String portNm 	= request.getParameter("portNm");
			
			PfSkdGRPVO grpVO = new PfSkdGRPVO();
			
			VskPfSkdVO[] tempVOs = (VskPfSkdVO[])getVOs(request, VskPfSkdVO.class,"sheet1_");
			VskPfSkdVO vskPfSkdVO = new VskPfSkdVO();
		
			for(int i=0; i<tempVOs.length; i++){
				vskPfSkdVO = tempVOs[i];
			}			
			vskPfSkdVO.setPfSkdRmk(histYr);
			vskPfSkdVO.setPagerows(eventNav);
			vskPfSkdVO.setCreUsrId(portNm);
			grpVO.setVskPfSkdVO(vskPfSkdVO);
			
			VskPfSkdDtlVO[] dtlVOs = (VskPfSkdDtlVO[])getVOs(request, VskPfSkdDtlVO .class,"sheet2_");
			List<VskPfSkdDtlVO> vskPfSkdDtlVOs = Arrays.asList(dtlVOs);
		
			grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);
			
			event.setPfSkdGRPVO(grpVO);
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