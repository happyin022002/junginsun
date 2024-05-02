/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0249HTMLAction.java
*@FileTitle : Delay check (Pop-Up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.08 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskVslSkdHisVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.nis2010.vms.vsk.scheduleplanningoperation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SchedulePlanningOperationSC로 실행요청<br>
 * - SchedulePlanningOperationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Ryu Hyuk
 * @see SchedulePlanningOperationEvent 참조
 * @since J2EE 1.4
 */

public class VOP_VSK_0249HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0249HTMLAction 객체를 생성
	 */
	public VOP_VSK_0249HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SchedulePlanningOperationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0249Event event = new VopVsk0249Event();
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			MdmVslSvcLaneVO vo = new MdmVslSvcLaneVO();
			vo.setVslSlanCd(request.getParameter("vsl_slan_cd"));
			event.setMdmVslSvcLaneVO(vo);
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setVvdVO((VvdVO)getVO(request, VvdVO.class));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			LocationVO vo = new LocationVO();
			vo.setLocCd(request.getParameter("vps_loc_cd"));
			event.setLocationVO(vo);
		}else if(command.isCommand(FormCommand.MULTI)) {
			String[] nonBkgVvd = request.getParameterValues("non_bkg_vvd");
			String[] bkgVvd = request.getParameterValues("bkg_vvd");
			String[] vslSlanCd = request.getParameterValues("vsl_slan_cd");
			
			// vslSlanCd와 bkgVvd는 VOP_VSK_0249 화면의 좌측 sheet의 각 컬럼에 대응하는 값이다.
			// 그러므로 배열의 길이다 동일하다.
			
			if(nonBkgVvd!=null && nonBkgVvd.length!=0){
				ActivationVvdVO[] activationVvdVO1s = new ActivationVvdVO[nonBkgVvd.length];
				for(int i=0; i<activationVvdVO1s.length; i++){
					ActivationVvdVO vo = new ActivationVvdVO();
					vo.setVslCd(nonBkgVvd[i].substring(0, 4));
					vo.setSkdVoyNo(nonBkgVvd[i].substring(4, 8));
					vo.setSkdDirCd(nonBkgVvd[i].substring(8));
					activationVvdVO1s[i] = vo;
				}
				event.setActivationVvdVO1S(activationVvdVO1s);
			}
			
			if(bkgVvd!=null && bkgVvd.length!=0){
				//ActivationVvdVO[] activationVvdVO2s = new ActivationVvdVO[bkgVvd.length];
				ActivationVvdVO[] activationVvdVO2s = (ActivationVvdVO[])getVOs(request, ActivationVvdVO.class);
				for(int i=0; i<activationVvdVO2s.length; i++){
					ActivationVvdVO vo = activationVvdVO2s[i];
					vo.setVslSlanCd(vslSlanCd[i]);
					vo.setVslCd(bkgVvd[i].substring(0, 4));
					vo.setSkdVoyNo(bkgVvd[i].substring(4, 8));
					vo.setSkdDirCd(bkgVvd[i].substring(8));
					activationVvdVO2s[i] = vo;
				}
				event.setActivationVvdVO2S(activationVvdVO2s);
			}
			
			event.setVskVslSkdHisVO((VskVslSkdHisVO)getVO(request, VskVslSkdHisVO.class));
			
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