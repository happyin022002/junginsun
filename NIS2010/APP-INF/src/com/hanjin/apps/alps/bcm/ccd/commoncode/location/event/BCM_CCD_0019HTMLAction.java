/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BCM_CCD_0019HTMLAction.java
*@FileTitle : yard
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.event;
  
import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LocationVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

 
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.bcm.ccd.commoncode 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 commoncodeSC로 실행요청<br>
 * - commoncodeSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see commoncodeEvent 참조
 * @since J2EE 1.6
 */

public class BCM_CCD_0019HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * BCM_CCD_0019HTMLAction 객체를 생성
	 */
	public BCM_CCD_0019HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 commoncodeEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		BcmCcd0019Event event = new BcmCcd0019Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setLocCd(request.getParameter("loc_cd"));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setLocVO((LocationVO)getVO(request, LocationVO .class));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setMdmDatProcVO((MdmDatProcVO)getVO(request, MdmDatProcVO .class,""));
			event.setLocVO((LocationVO)getVO(request, LocationVO .class));
		}
//		else if(command.isCommand(FormCommand.SEARCH01)) {
//		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setScontiCd(request.getParameter("sconti_cd"));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setCntCd(request.getParameter("cnt_cd"));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setRgnCd(request.getParameter("rgn_cd"));
		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setSteCd(request.getParameter("ste_cd"));
		}else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setSccCd(request.getParameter("scc_cd"));
		}else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setRepZnCd(request.getParameter("rep_zn_cd"));
		}else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setSlsOfcCd(request.getParameter("sls_ofc_cd"));
		}else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setEqCtrlOfcCd(request.getParameter("eq_ctrl_ofc_cd"));
		}else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setFincCtrlOfcCd(request.getParameter("finc_ctrl_ofc_cd"));
		}else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setMtyPkupYdCd(request.getParameter("mty_pkup_yd_cd"));
		}else if(command.isCommand(FormCommand.SEARCH12)) {
			event.setEqRtnYdCd(request.getParameter("eq_rtn_yd_cd"));
		}else if(command.isCommand(FormCommand.SEARCH13)) {
			event.setHubLocCd(request.getParameter("hub_loc_cd"));
		}else if(command.isCommand(FormCommand.SEARCH14)) {
			event.setLocCd(request.getParameter("loc_cd"));
		}else if(command.isCommand(FormCommand.SEARCH15)) {
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