/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0015HTMLAction.java
*@FileTitle : Coastal SKD Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.06.11 Jung Jinwoo
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdSimDtlCalcInfoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstSkdSimVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VskVslSkdPhsIoHisVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdPortTariffVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.VskPortDistVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.vop.vsk.scheduleplanningoperation.vesselschedulemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SchedulePlanningOperationSC로 실행요청<br>
 * - SchedulePlanningOperationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jung Jinwoo
 * @see VopVsk0015Event 참조
 * @since J2EE 1.5
 */

public class VOP_VSK_0015HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0015HTMLAction 객체를 생성
	 */
	public VOP_VSK_0015HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SchedulePlanningOperationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand 	command = FormCommand.fromRequest(request);
		VopVsk0015Event event 	= new VopVsk0015Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setSwapCstSkdSimVO((SwapCstSkdSimVO)getVO(request, SwapCstSkdSimVO .class));
		} else if (command.isCommand(FormCommand.SEARCH01)){
			event.setYardVO((YardVO)getVO(request, YardVO .class));
		} else if (command.isCommand(FormCommand.SEARCH02)){
			event.setVskPortDistVO((VskPortDistVO)getVO(request, VskPortDistVO .class));
		} else if (command.isCommand(FormCommand.SEARCH03)){
			event.setYardVO((YardVO)getVO(request, YardVO .class));
			event.setVskPortDistVO((VskPortDistVO)getVO(request, VskPortDistVO .class));
			event.setSwapCstSkdSimVO((SwapCstSkdSimVO)getVO(request, SwapCstSkdSimVO .class));
		} else if (command.isCommand(FormCommand.SEARCH04)){
			event.setCstSkdSimDtlCalcInfoVO((CstSkdSimDtlCalcInfoVO)getVO(request, CstSkdSimDtlCalcInfoVO .class));
		} else if (command.isCommand(FormCommand.SEARCH05)){
			event.setYardVO((YardVO)getVO(request, YardVO .class));
		} else if (command.isCommand(FormCommand.SEARCH06)){
			event.setYardVO((YardVO)getVO(request, YardVO .class));
			event.setVskPortDistVO((VskPortDistVO)getVO(request, VskPortDistVO .class));
			event.setSwapCstSkdSimVO((SwapCstSkdSimVO)getVO(request, SwapCstSkdSimVO .class));
			event.setCstSkdSimDtlCalcInfoVO((CstSkdSimDtlCalcInfoVO)getVO(request, CstSkdSimDtlCalcInfoVO .class));
		} else if (command.isCommand(FormCommand.SEARCH08)){
			event.setSwapCstSkdSimVOs((SwapCstSkdSimVO[])getVOs(request, SwapCstSkdSimVO .class, "sheet1_"));
		} else if (command.isCommand(FormCommand.SEARCH09)){
			event.setSwapCstSkdSimVOs((SwapCstSkdSimVO[])getVOs(request, SwapCstSkdSimVO .class, "sheet2_"));
		} else if (command.isCommand(FormCommand.SEARCH10)){
			event.setVvdVO((VvdVO)getVO(request, VvdVO .class));
		} else if (command.isCommand(FormCommand.SEARCH11)){
			event.setCstSkdSimDtlCalcInfoVO((CstSkdSimDtlCalcInfoVO)getVO(request, CstSkdSimDtlCalcInfoVO .class));
		} else if (command.isCommand(FormCommand.SEARCH12)){
			event.setYardVO((YardVO)getVO(request, YardVO .class));
			event.setCstSkdSimDtlCalcInfoVO((CstSkdSimDtlCalcInfoVO)getVO(request, CstSkdSimDtlCalcInfoVO .class));
		
		} else if (command.isCommand(FormCommand.SEARCH13)){	//::Port Tariff Calculation:://
			event.setSwapCstSkdSimVO	((SwapCstSkdSimVO)  	this.getVO	(request, SwapCstSkdSimVO.class));
			//event.setSwapCstSkdSimVOs	((SwapCstSkdSimVO[])getVOs	(request, SwapCstSkdSimVO.class, "sheet1_"));
		
		} else if (command.isCommand(FormCommand.SEARCH14)){	//::Port Tariff Calculation >> Surcharge/Discount Exist Checking:://
			event.setSwapCstSkdSimVO	((SwapCstSkdSimVO)		this.getVO	(request, SwapCstSkdSimVO.class)	);
			event.setVvdPortTariffVOs	((VvdPortTariffVO[]) 	this.getVOs	(request, VvdPortTariffVO.class)	);
			
		} else if (command.isCommand(FormCommand.MULTI)){
			event.setSwapCstSkdSimVO((SwapCstSkdSimVO)getVO(request, SwapCstSkdSimVO .class));
//			event.setVskVslSkdPhsIoHisVO((VskVslSkdPhsIoHisVO)getVO(request, VskVslSkdPhsIoHisVO .class));
			event.setSwapCstSkdSimVOs((SwapCstSkdSimVO[])getVOs(request, SwapCstSkdSimVO .class, "sheet1_"));
			event.setVskVslSkdPhsIoHisVOs((VskVslSkdPhsIoHisVO[])getVOs(request, VskVslSkdPhsIoHisVO.class, "sheet4_")); 		//Phase In/Out History를 위해 추가
		} else if (command.isCommand(FormCommand.MULTI01)){
			event.setSwapCstSkdSimVO((SwapCstSkdSimVO)getVO(request, SwapCstSkdSimVO .class));
//			event.setVskVslSkdPhsIoHisVO((VskVslSkdPhsIoHisVO)getVO(request, VskVslSkdPhsIoHisVO .class));
			event.setSwapCstSkdSimVOs((SwapCstSkdSimVO[])getVOs(request, SwapCstSkdSimVO .class, "sheet2_"));
			event.setVskVslSkdPhsIoHisVOs((VskVslSkdPhsIoHisVO[])getVOs(request, VskVslSkdPhsIoHisVO.class, "sheet4_"));		//Phase In/Out History를 위해 추가
		} else if (command.isCommand(FormCommand.MULTI02)){
			event.setSwapCstSkdSimVO((SwapCstSkdSimVO)getVO(request, SwapCstSkdSimVO .class));
//			event.setVskVslSkdPhsIoHisVO((VskVslSkdPhsIoHisVO)getVO(request, VskVslSkdPhsIoHisVO .class));
			event.setSwapCstSkdSimVOs((SwapCstSkdSimVO[])getVOs(request, SwapCstSkdSimVO .class, "sheet2_"));
			event.setVskVslSkdPhsIoHisVOs((VskVslSkdPhsIoHisVO[])getVOs(request, VskVslSkdPhsIoHisVO.class, "sheet4_"));		//Phase In/Out History를 위해 추가
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