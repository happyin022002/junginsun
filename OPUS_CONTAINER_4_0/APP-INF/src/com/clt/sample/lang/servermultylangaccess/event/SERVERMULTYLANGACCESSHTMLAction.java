/*========================================================
 *Copyright(c) 2009 CyberLogitec
 *ProcessChain    : NPI
 *@FileName       : SERVERMULTYLANGACCESSHTMLAction.java
 *@FileTitle      : NIS2010
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : Jul 29, 2009
 *@LastModifier   : XXX
 *@LastVersion    : 1.0
=========================================================*/
package com.clt.sample.lang.servermultylangaccess.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.view.signon.web.SignOnFilter;
import com.clt.sample.lang.multylangaccess.event.MultyLangEvent;
import com.clt.syscommon.common.table.ComUserVO;

/**
 * 
 * SERVERMULTYLANGACCESSHTMLAction.java
 * @author XXX
 * @see 
 * @since J2SE 1.6
 * 2016. 1. 11.
 */
public class SERVERMULTYLANGACCESSHTMLAction extends HTMLActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SERVERMULTYLANGACCESSHTMLAction() {
	}

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
		
		String msgCdStr = "";
		if("EN".equals(lang_tp_cd)){
			msgCdStr = "JUN00001";
		}else if("KR".equals(lang_tp_cd)){
			msgCdStr = "JUN00002";
		}else if("CN".equals(lang_tp_cd)){
			msgCdStr = "JUN00003";
		}else{
			msgCdStr = "JUN00001";
		}
		
		throw new HTMLActionException(new ErrorHandler(msgCdStr).getMessage(), new EventException(new ErrorHandler(msgCdStr).getMessage()));

	}

	/**
	 * 
	 * doEnd
	 * @author XXX
	 * @param request
	 * @param eventResponse void
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

}
