/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0010HTMLAction.java
*@FileTitle : Lane Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.06.16 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.nis2010.vop.vsk.vesseloperationsupportmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 VesselOperationSupportMgtSC로 실행요청<br>
 * - VesselOperationSupportMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Suk Hyun
 * @see VesselOperationSupportMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_VSK_0702HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0010HTMLAction 객체를 생성
	 */
	public VOP_VSK_0702HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VesselOperationSupportMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopVsk0702Event event = new VopVsk0702Event();
		
		if(command.isCommand(FormCommand.MULTI)){
			MdmVslSvcLaneVO[][] list = new MdmVslSvcLaneVO[5][];  
			
			int modifyCnt = 0;
			for(int cnt = 0; cnt < list.length; cnt++){
				list[cnt] = (MdmVslSvcLaneVO[])getVOs(request, MdmVslSvcLaneVO.class, "sheet" + (cnt + 1) + "_");
				modifyCnt += (list[cnt] == null ? 0 : list[cnt].length); 
			}
			
			MdmVslSvcLaneVO[] listVo = new MdmVslSvcLaneVO[modifyCnt];
			
			int idx = 0;
			for(int cnt = 0; cnt < list.length; cnt++){
				if(list[cnt] != null){
					for(int cnt1 = 0; cnt1 < list[cnt].length; cnt1++){
						listVo[idx] = list[cnt][cnt1];
						++idx;
					}
				}
			}
			
			event.setMdmVslSvcLaneVOS(listVo);
			//event.setMdmVslSvcLaneVOS((MdmVslSvcLaneVO[])getVOs(request, MdmVslSvcLaneVO.class, "sheet1_"));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setMdmVslSvcLaneVO((MdmVslSvcLaneVO)getVO(request, MdmVslSvcLaneVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setMdmVslSvcLaneVO((MdmVslSvcLaneVO)getVO(request, MdmVslSvcLaneVO.class));
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