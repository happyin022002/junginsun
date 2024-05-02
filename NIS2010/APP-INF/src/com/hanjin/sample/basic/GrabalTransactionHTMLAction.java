/*========================================================
*Copyright(c) 2011 CyberLogitec
*ProcessChain    : BST
*@FileName       : GrabalTransactionHTMLAction.java
*@FileTitle      	 : 
*@Author           : Jeong-Hoon, KIM
*Open Issues     :
*Change history  :
*@LastModifyDate : 2011. 9. 30.
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
package com.hanjin.sample.basic;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * GrabalTransactionHTMLAction.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2011. 9. 30.
 */
public class GrabalTransactionHTMLAction extends HTMLActionSupport{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5325773027407680672L;

	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		GrobalTransactionEvent event = new GrobalTransactionEvent();
		return event;
	}

}

