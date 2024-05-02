/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESD_PRD_0038HTMLAction.java
 *@FileTitle : Inland Cut Off Time
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.inlandcutoff.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.PrdInlndCutOffTmMgmtVO;

/**
 * 
 * @author
 * @see EsdPrd0038Event , ESD_PRD_038EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_PRD_0038HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 6333237295305704560L;
	public ESD_PRD_0038HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_PRD_0038Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsdPrd0038Event event = new EsdPrd0038Event();
		event.setPrdInlndCutOffTmMgmtVO((PrdInlndCutOffTmMgmtVO) getVO(request, PrdInlndCutOffTmMgmtVO.class));
		if (command.isCommand(FormCommand.SEARCH)) {
			event.setPrdInlndCutOffTmMgmtVO((PrdInlndCutOffTmMgmtVO) getVO(request, PrdInlndCutOffTmMgmtVO.class));
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setPrdInlndCutOffTmMgmtVOs((PrdInlndCutOffTmMgmtVO[]) getVOs(request, PrdInlndCutOffTmMgmtVO.class));
		} else if (command.isCommand(FormCommand.COMMAND01)) {
			event.setPrdInlndCutOffTmMgmtVO((PrdInlndCutOffTmMgmtVO) getVO(request, PrdInlndCutOffTmMgmtVO.class));
		}
		request.setAttribute("Event", event);
		return event;
	}
}
