/*========================================================
*Copyright(c) 2011 CyberLogitec
*ProcessChain    : BST
*@FileName       : GrobalTransactionEvent.java
*@FileTitle      	 : 
*@Author           : Jeong-Hoon, KIM
*Open Issues     :
*Change history  :
*@LastModifyDate : 2011. 9. 30.
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
package com.hanjin.sample.basic;

import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * GrobalTransactionEvent.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2011. 9. 30.
 */
public class GrobalTransactionEvent extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3297174195416257134L;

	public GrobalTransactionEvent() {
		FormCommand command = new FormCommand();
		command.setCommand(1);
		setFormCommand(command);
	}
}

