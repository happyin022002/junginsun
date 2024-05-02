/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0510HTMLAction.java
*@FileTitle : Lane Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.16 장석현
* 1.0 Creation
*
* History
* 2011.04.28 진마리아 [CHM-201110229-01] Lane informtion내 PIC의 Vessel 칼럼을 Carrier로 변경 요청건 - Carrier Code 체크로직 생성
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.VskPortBnkRfuelRtoSheetVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskLanePicVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.vop.vsk.vesseloperationsupportmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 VesselOperationSupportMgtSC로 실행요청<br>
 * - VesselOperationSupportMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Suk Hyun
 * @see VesselOperationSupportMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_VSK_0510HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0510HTMLAction 객체를 생성
	 */
	public VOP_VSK_0510HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VesselOperationSupportMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0510Event event = new VopVsk0510Event();
		if(command.isCommand(FormCommand.MULTI)) {
			VskLanePicVO[][] list = new VskLanePicVO[3][];  
			
			int modifyCnt = 0;
			for(int cnt = 0; cnt < list.length; cnt++){
				list[cnt] = (VskLanePicVO[])getVOs(request, VskLanePicVO.class, "t2sheet" + (cnt + 1) + "_");
				modifyCnt += (list[cnt] == null ? 0 : list[cnt].length); 
			}
			
			VskLanePicVO[] listVo = new VskLanePicVO[modifyCnt];
			
			int idx = 0;
			for(int cnt = 0; cnt < list.length; cnt++){
				if(list[cnt] != null){
					for(int cnt1 = 0; cnt1 < list[cnt].length; cnt1++){
						listVo[idx] = list[cnt][cnt1];
						++idx;
					}
				}
			}	
			event.setVskLanePicVOS(listVo);
			event.setVskPortBnkRfuelRtoSheetVOS((VskPortBnkRfuelRtoSheetVO[])getVOs(request, VskPortBnkRfuelRtoSheetVO.class, "t3sheet1_"));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setMdmVslSvcLaneVO((MdmVslSvcLaneVO)getVO(request, MdmVslSvcLaneVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setMdmVslSvcLaneVO((MdmVslSvcLaneVO)getVO(request, MdmVslSvcLaneVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setVskLanePicVO((VskLanePicVO)getVO(request, VskLanePicVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setVskLanePicVO((VskLanePicVO)getVO(request, VskLanePicVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setVskLanePicVO((VskLanePicVO)getVO(request, VskLanePicVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setCrrCd(request.getParameter("crr_cd"));
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