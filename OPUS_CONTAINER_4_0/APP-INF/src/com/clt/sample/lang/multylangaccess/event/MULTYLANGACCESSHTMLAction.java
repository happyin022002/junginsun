/*========================================================
 *Copyright(c) 2009 CyberLogitec
 *ProcessChain    : NPI
 *@FileName       : MULTYLANGACCESSHTMLAction.java
 *@FileTitle      : NIS2010
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : Jul 29, 2009
 *@LastModifier   : XXX
 *@LastVersion    : 1.0
=========================================================*/
package com.clt.sample.lang.multylangaccess.event;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.view.signon.web.SignOnFilter;
import com.clt.syscommon.common.table.ComUserVO;

/**
 * 
 * MULTYLANGACCESSHTMLAction.java
 * @author XXX
 * @see 
 * @since J2SE 1.6
 * 2016. 1. 11.
 */
public class MULTYLANGACCESSHTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MULTYLANGACCESSHTMLAction() {}
	
	/**
	 * 
	 * perform
	 * @author XXX
	 * @param request
	 * @return
	 * @throws HTMLActionException Event
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		String lang_tp_cd = (String) request.getSession().getAttribute(SignOnFilter.FORM_LANG_TP_CD_TYPE);
		
		MultyLangEvent event = new MultyLangEvent();
		ComUserVO testVo = (ComUserVO)getVO(request, ComUserVO.class);
		testVo.setLangTpCd(lang_tp_cd);
		event.setComUserVO(testVo);
		request.setAttribute("Event", event);
		
		return event;
	}

	
	/**
	 * 
	 * doEnd
	 * @author XXX
	 * @param request
	 * @param eventResponse void
	 */
	public void doEnd(ServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}
	
	
}
