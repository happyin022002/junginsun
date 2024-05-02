/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_083HTMLAction.java
*@FileTitle : USA Delivery Order Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2008-10-20
*@LastModifier : poong yeon cho
*@LastVersion : 1.0
* 2008-10-20 poong yeon cho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.usadeliveryordermanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.codemanage.usadeliveryordermanage.vo.UsaDeliveryOrderManageVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsTrspUsaDoDtlVO;
import com.hanjin.syscommon.common.table.TrsTrspUsaDoHdrVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.codemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 USADeliveryOrderManageSC로 실행요청<br>
 * - USADeliveryOrderManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author poong yeon cho
 * @see EsdTrs0083Event , ESD_TRS_083EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0083HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_083HTMLAction 객체를 생성
	 */
	public ESD_TRS_0083HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_083Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0083Event event = new EsdTrs0083Event();
		
//		int length = null==request.getParameterValues("" + "ibflag")?
//					0 : request.getParameterValues("" + "ibflag").length;
		
 		if(command.isCommand(FormCommand.SEARCH)
				|| command.isCommand(FormCommand.SEARCH01)	
				|| command.isCommand(FormCommand.SEARCH02)){
		   	event.setUsaDeliveryOrderManageVO((UsaDeliveryOrderManageVO)getVO(request, UsaDeliveryOrderManageVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI)){
		   	event.setUsaDeliveryOrderManageVO((UsaDeliveryOrderManageVO)getVO(request, UsaDeliveryOrderManageVO.class));
		    event.setTrsTrspUsaDoHdrVOs((TrsTrspUsaDoHdrVO[])getVOs(request, TrsTrspUsaDoHdrVO.class, ""));
		    event.setTrsTrspUsaDoDtlVOs((TrsTrspUsaDoDtlVO[])getVOs(request, TrsTrspUsaDoDtlVO.class, ""));
		    event.setForm_cre_usr_id(request.getParameter("form_cre_usr_id"));
		    event.setForm_usr_ofc_cd(request.getParameter("form_usr_ofc_cd"));
		}
		else;
		
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