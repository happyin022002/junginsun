/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_DOD_0013HTMLAction.java
*@FileTitle : Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.04
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.11.04 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo.SearchDodDrpOffChgVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.dod.doddropoff 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DodDropOffSC로 실행요청<br>
 * - DodDropOffSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Son, Jin-Hwan
 * @see DodDropOffEvent 참조
 * @since J2EE 1.6
 */

public class EES_DOD_0013HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_DOD_0013HTMLAction 객체를 생성
	 */
	public EES_DOD_0013HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DodDropOffEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesDod0013Event event = new EesDod0013Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setOpener(JSPUtil.getParameter(request, "opener", ""));
			event.setAuthAproRqstNo(JSPUtil.getParameter(request, "AUTH_APRO_RQST_NO", ""));
			event.setSearchDodDrpOffChgVOS((SearchDodDrpOffChgVO[])getVOs(request, SearchDodDrpOffChgVO.class, ""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setOpener(JSPUtil.getParameter(request, "opener", ""));
			event.setSearchDodDrpOffChgVO((SearchDodDrpOffChgVO)getVO(request, SearchDodDrpOffChgVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH02)) {
			event.setOpener(JSPUtil.getParameter(request, "opener", ""));
			event.setSearchDodDrpOffChgVO((SearchDodDrpOffChgVO)getVO(request, SearchDodDrpOffChgVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH08) || command.isCommand(FormCommand.SEARCH09)) {
			event.setBkgNo(request.getParameter("bkg_no"));
			event.setCntrNo(request.getParameter("cntr_no"));
			event.setCntrRtnYdCd(request.getParameter("cntr_rtn_yd_cd"));
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