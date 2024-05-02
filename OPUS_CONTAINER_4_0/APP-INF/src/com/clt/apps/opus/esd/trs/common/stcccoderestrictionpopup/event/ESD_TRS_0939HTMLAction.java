/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_0939HTMLAction.java
 *@FileTitle : STCC Code Restriction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.stcccoderestrictionpopup.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.StringUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.TrsStccCdRstrVO;

/**
 * HTTP Parser<br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.6
 */
public class ESD_TRS_0939HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 9041178837950449809L;

	/**
	 * 
	 */
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsdTrs0939Event event = new EsdTrs0939Event();
		event.setSearchVo((TrsStccCdRstrVO) getVO(request, TrsStccCdRstrVO.class));
		event.setiPage(Integer.parseInt(StringUtil.xssFilter(CheckUtilities.isNullReplacement(request.getParameter("iPage"), "1"))));
		request.setAttribute("Event", event);
		return event;
	}
}
