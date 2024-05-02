/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_FCM_0012HTMLAction.java
*@FileTitle : Fuel Consumption Trend line M_Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.05.12 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.trendline.trendline.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.vop.vsk.vskcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 VSKCommonSC로 실행요청<br>
 * - VSKCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Ryu Hyuk
 * @see VSKCommonEvent 참조
 * @since J2EE 1.4
 */

public class VOP_FCM_0012HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_FCM_0012HTMLAction 객체를 생성
	 */
	public VOP_FCM_0012HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VSKCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopFcm0012Event event = new VopFcm0012Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setFcmTrndLineVO((FcmTrndLineVO)getVO(request, FcmTrndLineVO.class));
		} else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setFcmTrndLineVO((FcmTrndLineVO)getVO(request, FcmTrndLineVO.class));
		} else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setFcmNoonRptVOs((FcmNoonRptVO[])getVOs(request, FcmNoonRptVO.class, "sheet2_"));
		} else if(command.isCommand(FormCommand.SEARCH04)) {
			FcmTrndLineVO fVO = (FcmTrndLineVO)getVO(request, FcmTrndLineVO.class);
			fVO.setVslClssCd((String) request.getParameter("vsl_clss_cd_i"));
			fVO.setVslClssSubCd((String) request.getParameter("vsl_clss_sub_cd_i"));
			fVO.setVslSlanCd((String) request.getParameter("vsl_slan_cd_all"));
			fVO.setVslCd((String) request.getParameter("vsl_cd_i"));
			fVO.setSkdDirCd((String) request.getParameter("skd_dir_cd_all"));
			event.setFcmTrndLineVO(fVO);
		} else if(command.isCommand(FormCommand.MULTI)) {
			event.setFcmTrndLineVO((FcmTrndLineVO)getVO(request, FcmTrndLineVO.class));
			event.setFcmTrndLineVOs((FcmTrndLineVO[])getVOs(request, FcmTrndLineVO.class,"sheet1_"));
			event.setFcmNoonRptVOs((FcmNoonRptVO[])getVOs(request, FcmNoonRptVO.class, "sheet2_"));
		} else if(command.isCommand(FormCommand.MULTI01)) {
			FcmTrndLineVO fVO = (FcmTrndLineVO)getVO(request, FcmTrndLineVO.class);
			fVO.setVslClssCd((String) request.getParameter("vsl_clss_cd_i"));
			fVO.setVslClssSubCd((String) request.getParameter("vsl_clss_sub_cd_i"));
			fVO.setVslSlanCd((String) request.getParameter("vsl_slan_cd_all"));
			fVO.setVslCd((String) request.getParameter("vsl_cd_i"));
			fVO.setSkdDirCd((String) request.getParameter("skd_dir_cd_all"));
			event.setFcmTrndLineVO(fVO);
			event.setFcmTrndLineVOs((FcmTrndLineVO[])getVOs(request, FcmTrndLineVO.class,"sheet1_"));
			event.setFcmNoonRptVOs((FcmNoonRptVO[])getVOs(request, FcmNoonRptVO.class, "sheet2_"));
		} else if(command.isCommand(FormCommand.REMOVE)) {
			FcmTrndLineVO fVO = (FcmTrndLineVO)getVO(request, FcmTrndLineVO.class);
			fVO.setVslClssCd((String) request.getParameter("vsl_clss_cd_i"));
			fVO.setVslClssSubCd((String) request.getParameter("vsl_clss_sub_cd_i"));
			fVO.setVslSlanCd((String) request.getParameter("vsl_slan_cd_all"));
			fVO.setVslCd((String) request.getParameter("vsl_cd_i"));
			fVO.setSkdDirCd((String) request.getParameter("skd_dir_cd_all"));
			event.setFcmTrndLineVO(fVO);
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