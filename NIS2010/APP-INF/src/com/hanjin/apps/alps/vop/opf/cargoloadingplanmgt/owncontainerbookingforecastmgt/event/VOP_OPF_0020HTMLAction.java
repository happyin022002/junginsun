/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0020HTMLAction.java
*@FileTitle : CBF for Partner Line’s Booking (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.06.09 우지석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.PodComboVO;

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
 * @since J2EE 1.6
 */

public class VOP_OPF_0020HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_OPF_0020HTMLAction 객체를 생성
	 */
	public VOP_OPF_0020HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CargoLoadingPlanMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopOpf0020Event event = new VopOpf0020Event();
		
		//생성, 수정, 삭제
		if(command.isCommand(FormCommand.MULTI)) {
			CBFListOptionVO[][] list = new CBFListOptionVO[2][];
			
			int modifyCnt = 0;
			for(int cnt = 0; cnt < list.length; cnt++){
				list[cnt] = (CBFListOptionVO[])getVOs(request, CBFListOptionVO.class, "t" + (cnt + 1) + "sheet1_");
				modifyCnt += (list[cnt] == null ? 0 : list[cnt].length); 
			}		
			CBFListOptionVO[] listVo = new CBFListOptionVO[modifyCnt];

			int idx = 0;
			for(int cnt = 0; cnt < list.length; cnt++){
				if(list[cnt] != null){
					for(int cnt1 = 0; cnt1 < list[cnt].length; cnt1++){
						listVo[idx] = list[cnt][cnt1];
						++idx;
					}
				}
			}
			event.setCBFListOptionVOS(listVo);
		}
		//조회
		else if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setCBFListOptionVO((CBFListOptionVO)getVO(request, CBFListOptionVO .class));
			event.setCBFListOptionVO((CBFListOptionVO)getVO(request, CBFListOptionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setCBFListOptionVO((CBFListOptionVO)getVO(request, CBFListOptionVO .class));
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST03)) {
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			String vsl_cd        = request.getParameter("vsl_cd");
			String skd_voy_no    = request.getParameter("skd_voy_no");		
			String skd_dir_cd    = request.getParameter("skd_dir_cd");		
			String vsl_opr_tp_cd = request.getParameter("vsl_opr_tp_cd");		
			
			event.setAttribute("vsl_cd", vsl_cd);
			event.setAttribute("skd_voy_no", skd_voy_no);
			event.setAttribute("skd_dir_cd", skd_dir_cd);
			event.setAttribute("vsl_opr_tp_cd", vsl_opr_tp_cd);
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setCBFListOptionVO((CBFListOptionVO)getVO(request, CBFListOptionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setCBFListOptionVO((CBFListOptionVO)getVO(request, CBFListOptionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH12)) {
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH13)) {
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH14)) {
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH15)) {
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH16)) {
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH17)) {
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH18)) {
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH19)) {
			event.setPodComboVO((PodComboVO)getVO(request, PodComboVO .class));
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