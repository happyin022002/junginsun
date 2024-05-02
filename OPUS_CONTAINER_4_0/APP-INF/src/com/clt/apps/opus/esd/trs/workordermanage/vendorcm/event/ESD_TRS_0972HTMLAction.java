/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESD_TRS_0972HTMLAction.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 
========================================================*/

package com.clt.apps.opus.esd.trs.workordermanage.vendorcm.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.workordermanage.vendorcm.vo.JoEdiRcvMsgVO;
import com.clt.apps.opus.esd.trs.workordermanage.vendorcm.vo.SearchJoEdiRcvMsgListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * 
 * @author
 * @see
 * @since J2EE 1.6
 */
public class ESD_TRS_0972HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_0972Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsdTrs0972Event event = new EsdTrs0972Event();
		FormCommand command = FormCommand.fromRequest(request);
		if (command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.MULTI02)) {
			event.setSearchJoEdiRcvMsgListVOs((SearchJoEdiRcvMsgListVO[]) getVOs(request, SearchJoEdiRcvMsgListVO.class, ""));
		} else {
			event.setParamVo((JoEdiRcvMsgVO) getVO(request, JoEdiRcvMsgVO.class));
		}
		return event;
	}

	/**
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}