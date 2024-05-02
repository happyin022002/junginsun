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
package com.clt.apps.opus.esm.bkg.servicesio;

import org.apache.log4j.Logger;

import com.clt.apps.opus.esm.bkg.customsdeclaration.CustomsDeclarationJapanTerminalSC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.event.JapanOpusBkgNaccsReplyEvent;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
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
	public void opusBkgTerminalNaccsReplyMQ(TransferEAI eai) throws DAOException {

		String str = eai.getMessage();

		Event event = null;
		CustomsDeclarationJapanTerminalSC customsDeclarationJapanTerminalSC = new CustomsDeclarationJapanTerminalSC();
		try {
			event = new JapanOpusBkgNaccsReplyEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);

			((JapanOpusBkgNaccsReplyEvent) event).setFlatFile(str);
			customsDeclarationJapanTerminalSC.perform(event);

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