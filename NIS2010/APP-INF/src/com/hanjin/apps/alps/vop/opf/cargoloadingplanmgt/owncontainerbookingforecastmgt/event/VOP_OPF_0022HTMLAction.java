/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0022HTMLAction.java
*@FileTitle : CBF - Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.13
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.10.13 김도현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFIFSummaryListVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.InvAuditDataValidVO;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.vop.opf.cargoloadingplanmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CargoLoadingPlanMgtSC로 실행요청<br>
 * - CargoLoadingPlanMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Ji Seok Woo
 * @see CargoLoadingPlanMgtEvent 참조
 * @since J2EE 1.4
 */

public class VOP_OPF_0022HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * VOP_OPF_0022HTMLAction 객체를 생성
	 */
	public VOP_OPF_0022HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CargoLoadingPlanMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command   = FormCommand.fromRequest(request);
		VopOpf0022Event event = new VopOpf0022Event();
		
		//Retrieve
		if(command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH04) || command.isCommand(FormCommand.SEARCH05) || command.isCommand(FormCommand.SEARCH06) || command.isCommand(FormCommand.SEARCH07) || command.isCommand(FormCommand.SEARCH08) || command.isCommand(FormCommand.SEARCH09) || command.isCommand(FormCommand.SEARCH10) || command.isCommand(FormCommand.SEARCH11) || command.isCommand(FormCommand.COMMAND01) || command.isCommand(FormCommand.COMMAND02) || command.isCommand(FormCommand.COMMAND03)|| command.isCommand(FormCommand.COMMAND04)|| command.isCommand(FormCommand.COMMAND05)) {
			event.setCBFIFSummaryListVO((CBFIFSummaryListVO)getVO(request, CBFIFSummaryListVO .class));
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
		//POL Info, CBF, Booking Status 상태 조회
		else if(command.isCommand(FormCommand.SEARCH02) || command.isCommand(FormCommand.SEARCH03)) {
			String vsl_cd     = request.getParameter("vsl_cd");
			String skd_voy_no = request.getParameter("skd_voy_no");		
			String skd_dir_cd = request.getParameter("skd_dir_cd");		
			String yd_cd      = request.getParameter("yd_cd");		
			
			event.setAttribute("vsl_cd",     vsl_cd);
			event.setAttribute("skd_voy_no", skd_voy_no);
			event.setAttribute("skd_dir_cd", skd_dir_cd);
			event.setAttribute("yd_cd",      yd_cd);
		}
		//Save
		else if(command.isCommand(FormCommand.MULTI)) {
			CBFIFSummaryListVO   cBFIFSummaryListVO   = (CBFIFSummaryListVO)getVO(request, CBFIFSummaryListVO.class);
			CBFIFSummaryListVO[] cBFIFSummaryListVOs  = (CBFIFSummaryListVO[])getVOs(request, CBFIFSummaryListVO.class, "sheet1_");
			CBFIFSummaryListVO[] cBFIFSummarySpecialListVOs  = (CBFIFSummaryListVO[])getVOs(request, CBFIFSummaryListVO.class, "sheet2_");
			
			event.setCBFIFSummaryListVO(cBFIFSummaryListVO);
			event.setCBFIFSummaryListVOS(cBFIFSummaryListVOs);
			event.setCbfIFSummarySpecialListVOs(cBFIFSummarySpecialListVOs);
		}
//		else if(command.isCommand(FormCommand.COMMAND02)) {
//			CBFIFSummaryListVO   cBFIFSummaryListVO   = (CBFIFSummaryListVO)getVO(request, CBFIFSummaryListVO.class);
//			
//			log.debug("cBFIFSummaryListVO"+cBFIFSummaryListVO);
//			event.setCBFIFSummaryListVO(cBFIFSummaryListVO);
//		}

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