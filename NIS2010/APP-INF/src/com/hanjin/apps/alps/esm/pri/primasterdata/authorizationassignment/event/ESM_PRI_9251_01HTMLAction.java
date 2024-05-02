/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_9251_01HTMLAction.java
 *@FileTitle : RFA Auth Hardcoding Management (Retro) - Office Level
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.09.02
 *@LastModifier : Min-Gyung Lee
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthAproVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthHisVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.primasterdata 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PRIMasterDataSC 실행요청<br>
 * - PRIMasterDataSC View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Min-Gyung Lee
 * @see HTMLActionSupport 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_9251_01HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_9251_01HTMLAction 객체를 생성
	 */
	public ESM_PRI_9251_01HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCReportEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri925101Event event = new EsmPri925101Event();
		
		if (command.isCommand(FormCommand.SEARCH01)) {
			event.setRsltAuthAproVO((RsltAuthAproVO) getVO(request, RsltAuthAproVO.class));
	    }else if(command.isCommand(FormCommand.MULTI)){
	    	RsltAuthAproVO[] vos = (RsltAuthAproVO[]) getVOs(request, RsltAuthAproVO.class, "");
	    	for (int i = 0; i < vos.length; i++) {
				vos[i].setPrcCtrtTpCd(request.getParameter("prc_ctrt_tp_cd"));
				vos[i].setPrcOfcAuthTpCd(request.getParameter("prc_ofc_auth_tp_cd"));
			}
	    	event.setRsltAuthAproVOS(vos);
	    	
	    	RsltAuthHisVO[] hisvos = (RsltAuthHisVO[]) getVOs(request, RsltAuthHisVO.class, "");
	    	for (int i = 0; i < hisvos.length; i++) {
	    		hisvos[i].setPrcCtrtTpCd(request.getParameter("prc_ctrt_tp_cd"));
	    		hisvos[i].setPrcOfcAuthTpCd(request.getParameter("prc_ofc_auth_tp_cd"));
			}
	    	event.setRsltAuthHisVOS(hisvos);
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