/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0110HTMLAction.java
*@FileTitle : Port Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.10 진마리아
* 1.0 Creation
* 
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.proformaschedulemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.RqstSimNoVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.vop.vsk.vskcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 VSKCommonSC로 실행요청<br>
 * - VSKCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Maria Chin
 * @see VopVsk0110Event 참조
 * @since J2EE 1.4
 */

public class VOP_VSK_0110HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VSK_GLO_HTMLAction 객체를 생성
	 */
	public VOP_VSK_0110HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VSKCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	VopVsk0110Event event = new VopVsk0110Event();
    	
    	String op = request.getParameter("op");
		event.setOp(op);
    	
//   		if("0202".equals(op)){
//   			if(command.isCommand(FormCommand.SEARCH)){
//    			event.setMdmVslSvcLaneVO((MdmVslSvcLaneVO)getVO(request, MdmVslSvcLaneVO.class));
//    		//checkVslCd
//    		}else if(command.isCommand(FormCommand.SEARCH02)){
//    			event.setMdmVslSvcLaneVO((MdmVslSvcLaneVO)getVO(request, MdmVslSvcLaneVO.class));
//    		}
//   		}else if("0043".equals(op)){
//   			if(command.isCommand(FormCommand.SEARCH)) {
//   				event.setLocationVO((LocationVO)getVO(request, LocationVO.class));
//   			}else if(command.isCommand(FormCommand.SEARCH01)) {
//   				event.setMdmCountryVO((MdmCountryVO)getVO(request, MdmCountryVO.class));
//   			}
//   		}else if("0219".equals(op)){
//   			if(command.isCommand(FormCommand.SEARCH)) {
//   				event.setVesselVO((VesselVO)getVO(request, VesselVO.class));
//   			}
//   		}else if("0244".equals(op)){
//   			if(command.isCommand(FormCommand.SEARCH)) {
//   				event.setMdmCountryVO((MdmCountryVO)getVO(request, MdmCountryVO.class));
//   			}
//   		}else if("0230".equals(op)){
//   			if(command.isCommand(FormCommand.SEARCH)) {
//   				event.setVvdPortLaneOtherVO((VvdPortLaneOtherVO)getVO(request, VvdPortLaneOtherVO.class));
//   			}
//		}else if("0212".equals(op)){
//			if(command.isCommand(FormCommand.SEARCH)) {
//				event.setPfLaneTypeVO((PfLaneTypeVO)getVO(request, PfLaneTypeVO.class));
//			}
//		}else if("0205".equals(op)){
////			event.setPhaseInOutVO((PhaseInOutVO)getVO(request, PhaseInOutVO.class));
//			
//			event.setAttribute("sVslSlanCd", request.getParameter("vsl_slan_cd"));
//			event.setAttribute("sVslCd", request.getParameter("vsl_cd"));
//			event.setAttribute("sVoyNo", request.getParameter("voy_no"));
//			event.setAttribute("sDirCd", request.getParameter("dir_cd"));
//			event.setAttribute("sPhaseType", request.getParameter("phase_type"));
//			event.setAttribute("sClptIndSeq", request.getParameter("clpt_ind_seq"));
//			
//			event.setAttribute("sPhaseDate", request.getParameter("phase_date"));
//			event.setAttribute("sPortList", request.getParameter("port_list"));
//			
//		}else if("0201".equals(op)){
//			if(command.isCommand(FormCommand.SEARCH)) {		
//				event.setRqstSimNoVO((RqstSimNoVO)getVO(request, RqstSimNoVO.class));
//			}
//		}else if("0044".equals(op)){
//			if(command.isCommand(FormCommand.SEARCH)) {		
//				event.setRqstSimNoVO((RqstSimNoVO)getVO(request, RqstSimNoVO.class));
//				event.setVesselVO((VesselVO)getVO(request, VesselVO.class));
//			}
//		}
		
		//0202
		if (command.isCommand(FormCommand.COMMAND11)) {
			event.setMdmVslSvcLaneVO((MdmVslSvcLaneVO)getVO(request, MdmVslSvcLaneVO.class));
   		}else if(command.isCommand(FormCommand.COMMAND12)) {
   			//checkVslCd
   			event.setMdmVslSvcLaneVO((MdmVslSvcLaneVO)getVO(request, MdmVslSvcLaneVO.class));
   		}
		//0043
   		else if(command.isCommand(FormCommand.COMMAND13)) {
   			event.setLocationVO((LocationVO)getVO(request, LocationVO.class));
   		}else if(command.isCommand(FormCommand.COMMAND14)) {
   			event.setMdmCountryVO((MdmCountryVO)getVO(request, MdmCountryVO.class));
   		}
		//0244
   		else if(command.isCommand(FormCommand.COMMAND15)) {
   			event.setMdmCountryVO((MdmCountryVO)getVO(request, MdmCountryVO.class));
   		}
		//0219
   		else if(command.isCommand(FormCommand.COMMAND16)) {
   			event.setVesselVO((VesselVO)getVO(request, VesselVO.class));
   		}
		//0230
   		else if(command.isCommand(FormCommand.COMMAND17)) {
   			event.setVvdPortLaneOtherVO((VvdPortLaneOtherVO)getVO(request, VvdPortLaneOtherVO.class));
   		}
		//0212
   		else if(command.isCommand(FormCommand.COMMAND18)) {
   			event.setPfLaneTypeVO((PfLaneTypeVO)getVO(request, PfLaneTypeVO.class));
   		}
		//0205
   		else if(command.isCommand(FormCommand.COMMAND19)) {
   			event.setAttribute("sVslSlanCd", request.getParameter("vsl_slan_cd"));
			event.setAttribute("sVslCd", request.getParameter("vsl_cd"));
			event.setAttribute("sVoyNo", request.getParameter("voy_no"));
			event.setAttribute("sDirCd", request.getParameter("dir_cd"));
			event.setAttribute("sPhaseType", request.getParameter("phase_type"));
			event.setAttribute("sClptIndSeq", request.getParameter("clpt_ind_seq"));
			
			event.setAttribute("sPhaseDate", request.getParameter("phase_date"));
			event.setAttribute("sPortList", request.getParameter("port_list"));
   		}
		//0201
   		else if(command.isCommand(FormCommand.COMMAND20)) {
   			event.setRqstSimNoVO((RqstSimNoVO)getVO(request, RqstSimNoVO.class));
   		}
		//0044
   		else if(command.isCommand(FormCommand.COMMAND21)) {
   			event.setRqstSimNoVO((RqstSimNoVO)getVO(request, RqstSimNoVO.class));
			event.setVesselVO((VesselVO)getVO(request, VesselVO.class));
   		}
		//0252
		
   		
    		
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