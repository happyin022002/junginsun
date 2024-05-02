/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqrCodEvent.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.event;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event.EesCtm0451Event;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.CimCStockVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.RDFaxMailEAIVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.spc.common HTML DOM Value Parsing<br>
 *
 * @author 
 * @see EsmSpcCodEvent , ESM_SPC_CODEventResponse 
 * @since J2EE 1.4
 */

public class EES_EQR_CODHTMLAction extends HTMLActionSupport {

	/**
	 * HTML DOM Value Parsing<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface
	 * @exception HTMLActionException 
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand f_cmd = FormCommand.fromRequest(request);
		HashMap params = new HashMap();
		Enumeration e = request.getParameterNames();
		while(e.hasMoreElements()){
			String key = (String)e.nextElement();
			
			if("|f_cmd|mcode|ipc|del|mrhq|trdCd|subTrdCd".indexOf(key) >= 0){
				params.put(key, request.getParameter(key));
			}
			else{
				params.put(key, request.getParameterValues(key));
			}
		}
		
		EesEqrCodEvent event = new EesEqrCodEvent();
		event.setParams(params);
		event.setCommandClassName("CntrCommonSC");
		event.setFormCommand(f_cmd);
		request.setAttribute("Event", event);
		return event;
	}

	/**
	 * HttpRequest attribute<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest attribute<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}