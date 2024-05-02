/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsDeclarationAustraliaMQProxy.java
*@FileTitle : CustomsDeclarationAustraliaMQProxy
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.servicesio;

import org.apache.log4j.Logger;

import com.clt.apps.opus.esm.bkg.customsdeclaration.CustomsDeclarationAustraliaSC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.event.UBizComOpusBkgAusAckEvent;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;


/**
 * CustomsDeclarationAustraliaMQProxy
 *
 * @author
 * @see opus.esm.bkg.customsdeclaration.CustomsDeclarationAustraliaSC
 * @since J2EE 1.6
 */
public class CustomsDeclarationAustraliaMQProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * EDI Receive <br>
	 *
	 * @param TransferEAI transferEAI
	 * @exception EventException, Exception
	 */
	public void receiveEDIForAusAck(TransferEAI transferEAI) throws EventException {
		String ediMessage = transferEAI.getMessage();

		try {
			FormCommand formCommand = new FormCommand();
			formCommand.setCommand(FormCommand.TRANS);

			UBizComOpusBkgAusAckEvent uBizComOpusBkgAusAckEvent = new UBizComOpusBkgAusAckEvent();
			uBizComOpusBkgAusAckEvent.setFormCommand(formCommand);
			uBizComOpusBkgAusAckEvent.setFlatFile(ediMessage);

			CustomsDeclarationAustraliaSC customsDeclarationAustraliaSC = new CustomsDeclarationAustraliaSC();
			customsDeclarationAustraliaSC.perform(uBizComOpusBkgAusAckEvent);

			// instance id추출하여 완료여부 전달
			transferEAI.commit(ediMessage.substring(0, 10));

		} catch (EventException ex) {
			transferEAI.rollback(ex);
			log.error("EventException ex : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			transferEAI.rollback(ex);
			log.error("Exception ex : " + ex.toString());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		transferEAI.close();
	}

}