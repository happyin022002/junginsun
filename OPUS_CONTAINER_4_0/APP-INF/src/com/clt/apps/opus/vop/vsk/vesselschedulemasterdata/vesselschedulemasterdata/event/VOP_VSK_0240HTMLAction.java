/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0240HTMLAction.java
*@FileTitle : Service Provider Group Registration (Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.08.24 서창열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.event;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanalAgencyLaneVO;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanelRegistGRPVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VendorVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.vop.vsk.vesselschedulemasterdata 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 VesselScheduleMasterDataSC로 실행요청<br>
 * - VesselScheduleMasterDataSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SEO CHANG YUL
 * @see VesselScheduleMasterDataEvent 참조
 * @since J2EE 1.6
 */

public class VOP_VSK_0240HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0240HTMLAction 객체를 생성
	 */
	public VOP_VSK_0240HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VesselScheduleMasterDataEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0240Event event = new VopVsk0240Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			CanelRegistGRPVO grpVO = new CanelRegistGRPVO();
			List<VendorVO> vendorVOList = null;
			List<CanalAgencyLaneVO> canalAgencyLaneVOList = null;
			
			// Vendor 
			VendorVO[] vendorVOs = (VendorVO[])getVOs(request, VendorVO.class,"sheet1_");

			if(vendorVOs != null){
				vendorVOList = Arrays.asList(vendorVOs);
			}
			
			// MDM_VSL_SVC_LANE, MDM_VSL_SVC_LANE_DIR 저장 데이타
			CanalAgencyLaneVO[] canalAgencyLaneVOS = (CanalAgencyLaneVO[])getVOs(request, CanalAgencyLaneVO.class, "sheet3_");
			if(canalAgencyLaneVOS != null){
				canalAgencyLaneVOList = Arrays.asList(canalAgencyLaneVOS);
			}
			if(vendorVOList != null) {
				grpVO.setVendorVOs(vendorVOList);
			}
			if(canalAgencyLaneVOList != null) {
				grpVO.setCanalAgencyLaneVOs(canalAgencyLaneVOList);
			}
			event.setCanelRegistGRPVO(grpVO);
//		}else if(command.isCommand(FormCommand.SEARCH)) {
//			String vndrSeq = request.getParameter("vndr_seq");
//			String eventNav = request.getParameter("eventNav");

//			CanalAgencyLaneVO canalAgencyLaneVO = new CanalAgencyLaneVO();
//			canalAgencyLaneVO.setVndrSeq(vndrSeq);
//			canalAgencyLaneVO.setEventNav(eventNav);
			
//			event.setCanalAgencyLaneVO(canalAgencyLaneVO);
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			String vndrSeq = request.getParameter("vndr_seq");

			VendorVO vendorVO = new VendorVO();
			vendorVO.setVndrSeq(vndrSeq);
			
			event.setVendorVO(vendorVO);
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