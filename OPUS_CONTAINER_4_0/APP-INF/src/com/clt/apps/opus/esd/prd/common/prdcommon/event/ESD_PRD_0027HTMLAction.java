/*=========================================================
 *	Copyright(c) 2006 CyberLogitec
 *	@FileName : COM_ENS_0C1HTMLAction.java
 *	@FileTitle : ServiceProvider정보조회(공통 Popup)
 *	Open Issues :
 *	Change history :
 *	@LastModifyDate : 2006-08-07
 *	@LastModifier : sungseok, choi
 *	@LastVersion : 1.0
 * 	2006-08-07 sungseok, choi
 * 	1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;

/**
 * HTTP Parser<br>
 * com.clt.bizcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * Parsing 한 정보를 Event로 변환, request에 담아 BizCommonSC로 실행요청<br>
 * BizCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author
 * @see ESD_PRD_0027HTMLAction
 * @since J2EE 1.4
 */
public class ESD_PRD_0027HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1507861815810800285L;

	/**
	 * @title @SuppressWarnings("rawtypes") Obejct Creation<br>
	 * @return
	 * @author
	 * @date
	 */
	public ESD_PRD_0027HTMLAction() {
	}

	/**
	 * ESD_PRD_0027HTMLAction 객체를 생성
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsdPrd0027Event event = new EsdPrd0027Event();
		event.setComIntgCdDtlVO((ComIntgCdDtlVO) getVO(request, ComIntgCdDtlVO.class));
		request.setAttribute("Event", event);
		return event;
	}
}
