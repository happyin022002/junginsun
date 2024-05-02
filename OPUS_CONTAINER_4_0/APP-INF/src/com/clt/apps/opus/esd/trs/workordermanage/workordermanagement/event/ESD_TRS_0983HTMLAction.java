/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_0983HTMLAction.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 *
 * @author juhyun
 * @see EsdTrs0983Event , EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0983HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = -4408975596460846280L;

	public ESD_TRS_0983HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_023Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0983Event event = new EsdTrs0983Event();
		if (command.isCommand(FormCommand.SEARCH)) {
			event.setTrsTrspSvcOrdVOs(new TrsTrspSvcOrdVO().fromRequestGrid(request));
		}
		return event;
	}

	/**
	 * 
	 * @param request
	 * @param event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}
