/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0019HTMLAction.java
*@FileTitle : CBF for Own Booking (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.18 우지석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFListOptionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.OPUS.vop.opf.cargoloadingplanmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CargoLoadingPlanMgtSC로 실행요청<br>
 * - CargoLoadingPlanMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Ji Seok Woo
 * @see CargoLoadingPlanMgtEvent 참조
 * @since J2EE 1.4
 */

public class VOP_OPF_0019HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * VOP_OPF_0019HTMLAction 객체를 생성
	 */
	public VOP_OPF_0019HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CargoLoadingPlanMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command   = FormCommand.fromRequest(request);
		VopOpf0019Event event = new VopOpf0019Event();
		
		//Retrieve
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setCBFListOptionVO((CBFListOptionVO)getVO(request, CBFListOptionVO .class));
		}
		//Display
		else if(command.isCommand(FormCommand.REPLY)) {
			event.setCBFListOptionVO((CBFListOptionVO)getVO(request, CBFListOptionVO .class));
		}
		//POL
		else if(command.isCommand(FormCommand.SEARCH01)) {
			String vsl_cd     = request.getParameter("vsl_cd");
			String skd_voy_no = request.getParameter("skd_voy_no");		
			String skd_dir_cd = request.getParameter("skd_dir_cd");	
			
			event.setAttribute("vsl_cd",     vsl_cd);
			event.setAttribute("skd_voy_no", skd_voy_no);
			event.setAttribute("skd_dir_cd", skd_dir_cd);
		}
		//POL Info
		else if(command.isCommand(FormCommand.SEARCH02)) {
			String vsl_cd     = request.getParameter("vsl_cd");
			String skd_voy_no = request.getParameter("skd_voy_no");		
			String skd_dir_cd = request.getParameter("skd_dir_cd");		
			String yd_cd      = request.getParameter("yd_cd");		
			
			event.setAttribute("vsl_cd",     vsl_cd);
			event.setAttribute("skd_voy_no", skd_voy_no);
			event.setAttribute("skd_dir_cd", skd_dir_cd);
			event.setAttribute("yd_cd",      yd_cd);
		}
		//Check existence of CBF
		else if(command.isCommand(FormCommand.SEARCH06)) {
			CBFListOptionVO cBFListOptionVO = (CBFListOptionVO)getVO(request, CBFListOptionVO .class);
			
			event.setCBFListOptionVO(cBFListOptionVO);
		}
		//Delete
		else if(command.isCommand(FormCommand.REMOVE)) {
			CBFListOptionVO cBFListOptionVO = (CBFListOptionVO)getVO(request, CBFListOptionVO.class);
			event.setCBFListOptionVO(cBFListOptionVO);
		}
		//Save
		else if(command.isCommand(FormCommand.MULTI)) {
			CBFListOptionVO   cBFListOptionVO   = (CBFListOptionVO)getVO(request, CBFListOptionVO.class);
			CBFListOptionVO[] cBFListVolumnVOs  = (CBFListOptionVO[])getVOs(request, CBFListOptionVO.class, "sheet1_");
			CBFListOptionVO[] cBFListSpecialVOs = (CBFListOptionVO[])getVOs(request, CBFListOptionVO.class, "sheet2_");

			event.setCBFListOptionVO(cBFListOptionVO);
			event.setCBFListVolumnVOS(cBFListVolumnVOs);
			event.setCBFListSpecialVOS(cBFListSpecialVOs);
		}
		//Detail
		else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setCBFListOptionVO((CBFListOptionVO)getVO(request, CBFListOptionVO .class));
		}
		//CBF, Booking Status 상태 조회
		else if(command.isCommand(FormCommand.SEARCH07)) {
			String vsl_cd     = request.getParameter("vsl_cd");
			String skd_voy_no = request.getParameter("skd_voy_no");		
			String skd_dir_cd = request.getParameter("skd_dir_cd");		
			String yd_cd      = request.getParameter("yd_cd");		
			
			event.setAttribute("vsl_cd", vsl_cd);
			event.setAttribute("skd_voy_no", skd_voy_no);
			event.setAttribute("skd_dir_cd", skd_dir_cd);
			event.setAttribute("yd_cd", yd_cd);
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