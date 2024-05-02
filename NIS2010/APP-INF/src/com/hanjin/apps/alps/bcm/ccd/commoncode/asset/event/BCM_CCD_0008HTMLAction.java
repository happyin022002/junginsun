/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BCM_CCD_0008HTMLAction.java
*@FileTitle : Container Vessel
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.28
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.02.28 조인영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.asset.event;
  
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerVesselVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.bcm.ccd.commoncode 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 commoncodeSC로 실행요청<br>
 * - commoncodeSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see commoncodeEvent 참조
 * @since J2EE 1.6
 */

public class BCM_CCD_0008HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * BCM_CCD_0008HTMLAction 객체를 생성
	 */
	public BCM_CCD_0008HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 commoncodeEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		BcmCcd0008Event event = new BcmCcd0008Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setContainerVesselVOS((ContainerVesselVO[])getVOs(request, ContainerVesselVO.class));
			
			//event.setContainerVesselVOS((ContainerVesselVO[])getVOs(request, ContainerVesselVO.class, "sheet1_"));
			
		} else if(command.isCommand(FormCommand.SEARCH)) {
			event.setContainerVesselVO((ContainerVesselVO)getVO(request, ContainerVesselVO.class));
			event.setVslCd(request.getParameter("vsl_cd"));
			
		} else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setCrrCd(request.getParameter("crr_cd"));
			
		} else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setVslRgstCntCd(request.getParameter("vsl_rgst_cnt_cd"));
			
		} else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setRgstPortCd(request.getParameter("rgst_port_cd"));
		} else if(command.isCommand(FormCommand.MULTI01)) {
			event.setMdmDatProcVO((MdmDatProcVO)getVO(request, MdmDatProcVO .class,""));
			event.setContainerVesselVOS((ContainerVesselVO[])getVOs(request, ContainerVesselVO.class));
		} else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setContainerVesselVO((ContainerVesselVO)getVO(request, ContainerVesselVO.class));
			event.setRqstNo(request.getParameter("rqst_no"));
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