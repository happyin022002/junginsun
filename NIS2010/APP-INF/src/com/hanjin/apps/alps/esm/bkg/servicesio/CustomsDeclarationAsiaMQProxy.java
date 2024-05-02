/*=========================================================
*Copyright(c) 2013 CyberLogitec 
*@FileName : CustomsDeclarationAsiaMQProxy.java
*@FileTitle : CustomsDeclarationAsiaMQProxy
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.23
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.10.23 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.CustomsDeclarationAsiaSC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.UdevhjsAlpsbkgTJpn24Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;


/**
 * CustomsDeclarationAsiaMQProxy
 *
 * @author KIM, Sang-Soo
 * @see alps.esm.bkg.customsdeclaration.CustomsDeclarationAsiaSC
 * @since J2EE 1.6
 */
public class CustomsDeclarationAsiaMQProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * EDI Receive <br>
	 *
	 * @param TransferEAI transferEAI
	 * @exception EventException, Exception
	 */
	public void receiveEDIForJapan24HR(TransferEAI transferEAI) throws EventException {
		String ediMessage = transferEAI.getMessage();

		try {
			FormCommand formCommand = new FormCommand();
			formCommand.setCommand(FormCommand.MULTI);

			UdevhjsAlpsbkgTJpn24Event udevhjsAlpsbkgTJpn24Event = new UdevhjsAlpsbkgTJpn24Event();
			udevhjsAlpsbkgTJpn24Event.setFormCommand(formCommand);
			udevhjsAlpsbkgTJpn24Event.setFlatFile(ediMessage);

			CustomsDeclarationAsiaSC customsDeclarationAsiaSC = new CustomsDeclarationAsiaSC();
			customsDeclarationAsiaSC.perform(udevhjsAlpsbkgTJpn24Event);

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