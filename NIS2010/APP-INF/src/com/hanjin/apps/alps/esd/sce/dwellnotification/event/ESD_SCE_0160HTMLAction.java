/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_SCE_0160HTMLAction.java
*@FileTitle : Dwell Notification
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.15
*@LastModifier : 채창호
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwllNtfcSrchVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchDwellVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchDwellReasonByVVDVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwellRnsVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce.copmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CopManageSC로 실행요청<br>
 * - CopManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author eunju son
 * @see EsdSce0160Event 참조
 * @since J2EE 1.6
 */
public class ESD_SCE_0160HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESD_SCE_0160HTMLAction 객체를 생성
	 */
	public ESD_SCE_0160HTMLAction() {}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VisibilityManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsdSce0160Event event = new EsdSce0160Event();
		DwellRnsVO dellvo = new DwellRnsVO();
		if(command.isCommand(FormCommand.MULTI01)){
			event.setDwellRsnByVvdVOs((SearchDwellReasonByVVDVO[])getVOs(request,SearchDwellReasonByVVDVO.class,""));
		}else if(command.isCommand(FormCommand.SEARCH02)){
			event.setFr_eta_dt(request.getParameter("fr_eta_dt")!=null?request.getParameter("fr_eta_dt"):"");
			event.setTo_eta_dt(request.getParameter("to_eta_dt")!=null?request.getParameter("to_eta_dt"):"");
			event.setPort_cd(request.getParameter("port_cd")!=null?request.getParameter("port_cd"):"");
			event.setVvd_cd(request.getParameter("vvd_cd")!=null?request.getParameter("vvd_cd"):"");
		}else if(command.isCommand(FormCommand.SEARCH03)){
			event.setDwll_tm_tp_cd(request.getParameter("dwell_tm_tp_cd")!=null?request.getParameter("dwell_tm_tp_cd"):"");
			event.setCntr_no(request.getParameter("cntr_no")!=null?request.getParameter("cntr_no"):"");
			event.setEml_snd_dt(request.getParameter("eml_snd_dt")!=null?request.getParameter("eml_snd_dt"):"");
			event.setEml_addr(request.getParameter("eml_addr")!=null?request.getParameter("eml_addr"):"");
			event.setSc_no(request.getParameter("sc_no")!=null?request.getParameter("sc_no"):"");
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setDwellRnsVO((DwellRnsVO)getVO(request, DwellRnsVO .class));
		}else if(command.isCommand(FormCommand.MULTI02)){
			event.setDwellRnsVOs(dellvo.fromRequestGrid(request, ""));
	    }else{
			event.setSearchDwellVO((SearchDwellVO)getVO(request, SearchDwellVO.class, ""));
			event.setRail_so_flg(request.getParameter("rail_so_flg")!=null?request.getParameter("rail_so_flg"):"");
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
