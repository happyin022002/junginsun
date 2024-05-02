/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0053HTMLAction.java
*@FileTitle : P/F SKD Creation (CCA)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.07.01 서창열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskPfSkdVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.nis2010.vop.vsk.scheduleplanningoperation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SchedulePlanningOperationSC로 실행요청<br>
 * - SchedulePlanningOperationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SEO CHANG YUL
 * @see SchedulePlanningOperationEvent 참조
 * @since J2EE 1.4
 */

public class VOP_VSK_0053HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0053HTMLAction 객체를 생성
	 */
	public VOP_VSK_0053HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SchedulePlanningOperationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0053Event event = new VopVsk0053Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			String minMaxSpd = request.getParameter("min_max_spd");

			PfSkdGRPVO grpVO = new PfSkdGRPVO();
			
			
			VskPfSkdVO[] tempVOs = (VskPfSkdVO[])getVOs(request, VskPfSkdVO.class,"sheet1_");
			VskPfSkdVO vskPfSkdVO = new VskPfSkdVO();

			for(int i=0; i<tempVOs.length; i++){
				vskPfSkdVO = tempVOs[i];
			}
			
			String vslSlanCd = vskPfSkdVO.getVslSlanCd();
			String pfSvcTpCd = vskPfSkdVO.getPfSvcTpCd();

			grpVO.setVskPfSkdVO(vskPfSkdVO);
			
			VskPfSkdDtlVO[] dtlVOs = (VskPfSkdDtlVO[])getVOs(request, VskPfSkdDtlVO.class,"sheet2_");
			List<VskPfSkdDtlVO> vskPfSkdDtlVOs = Arrays.asList(dtlVOs);
			
			for(int i=0; i<vskPfSkdDtlVOs.size(); i++){
				vskPfSkdDtlVOs.get(i).setVslSlanCd(vslSlanCd);
				vskPfSkdDtlVOs.get(i).setPfSvcTpCd(pfSvcTpCd);
			}
			
			VskPfSkdDtlVO vskPfSkdDtlVO = vskPfSkdDtlVOs.get(0);
			vskPfSkdDtlVO.setMinMaxSpd(minMaxSpd);
			vskPfSkdDtlVOs.set(0, vskPfSkdDtlVO);

			grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);
			
			event.setPfSkdGRPVO(grpVO);
		}else if(command.isCommand(FormCommand.SEARCH)) {
			event.setPfSkdVO((PfSkdVO)getVO(request, PfSkdVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			YardVO yardVO = new YardVO();
			String locCd = request.getParameter("loc_cd");
			yardVO.setLocCd(locCd);
			event.setYardVO((YardVO)getVO(request, YardVO .class));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			MdmVslSvcLaneVO mdmVslSvcLaneVO = new MdmVslSvcLaneVO();
			String vslSlanCd = request.getParameter("vslSlanCd");
			mdmVslSvcLaneVO.setVslSlanCd(vslSlanCd);
			event.setMdmVslSvcLaneVO((MdmVslSvcLaneVO)getVO(request, MdmVslSvcLaneVO .class));
		}else if(command.isCommand(FormCommand.COMMAND01)) {
			String minMaxSpd = request.getParameter("min_max_spd");
			PfSkdGRPVO grpVO = new PfSkdGRPVO();
			
			VskPfSkdVO[] tempVOs = (VskPfSkdVO[])getVOs(request, VskPfSkdVO.class,"sheet1_");
			VskPfSkdVO vskPfSkdVO = new VskPfSkdVO();

			for(int i=0; i<tempVOs.length; i++){
				vskPfSkdVO = tempVOs[i];
			}			

			grpVO.setVskPfSkdVO(vskPfSkdVO);
	
			VskPfSkdDtlVO[] dtlVOs = (VskPfSkdDtlVO[])getVOs(request, VskPfSkdDtlVO .class,"sheet2_");
			List<VskPfSkdDtlVO> vskPfSkdDtlVOs = Arrays.asList(dtlVOs);
			
			VskPfSkdDtlVO vskPfSkdDtlVO = vskPfSkdDtlVOs.get(0);
			vskPfSkdDtlVO.setMinMaxSpd(minMaxSpd);
			vskPfSkdDtlVOs.set(0, vskPfSkdDtlVO);
		
			grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);
			
			event.setPfSkdGRPVO(grpVO);
		}else if(command.isCommand(FormCommand.REMOVE)) {
			VskPfSkdVO[] tempVOs = (VskPfSkdVO[])getVOs(request, VskPfSkdVO.class,"sheet1_");
			VskPfSkdVO vskPfSkdVO = new VskPfSkdVO();

			for(int i=0; i<tempVOs.length; i++){
				vskPfSkdVO = tempVOs[i];
			}			
			event.setVskPfSkdVO(vskPfSkdVO);
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