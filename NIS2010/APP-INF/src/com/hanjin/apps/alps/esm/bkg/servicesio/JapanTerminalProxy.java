/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : JapanTerminalProxy.java
 *@FileTitle : Receive WebLogic JMS Queue Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012-03-07
 *@LastModifier : KIM JONG OCK
 *@LastVersion : 1.0
 * 2012-03-07 
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.CustomsDeclarationSC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.event.JapanAlpsBkgNaccsReplyEvent;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

/**
 * It's JapanTerminalProxy.java
 * 
 * @author
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class JapanTerminalProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * JMS Receive <br>
	 * 
	 * @param eai TransferEAI
	 * @exception EventException, XmlException, Exception
	 */
	public void alpsBkgTerminalNaccsReplyMQ(TransferEAI eai) throws DAOException {

		String str = eai.getMessage();
		
		Event event = null;
		CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();		
		try {
			event = new JapanAlpsBkgNaccsReplyEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			
			((JapanAlpsBkgNaccsReplyEvent) event).setFlatFile(str);
			customsDeclarationSC.perform(event);
			
		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new DAOException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		eai.close();
	}	
}