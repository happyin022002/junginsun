/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CustomsDeclarationJapanMQProxy.java
*@FileTitle : CustomsDeclarationJapanMQProxy
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.23
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.10.23 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.servicesio;

import org.apache.log4j.Logger;

import com.clt.apps.opus.esm.bkg.customsdeclaration.CustomsDeclarationJp24SC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event.EdiBkgJp24sysAmrAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event.EdiBkgJp24sysAtdAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event.UBizComOpusBkgJpn24Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;


/**
 * CustomsDeclarationJapanMQProxy
 *
 * @author KIM, Sang-Soo
 * @see opus.esm.bkg.customsdeclaration.CustomsDeclarationJp24SC
 * @since J2EE 1.6
 */
public class CustomsDeclarationJapanMQProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * [EDI_T_BKG_T_JP24CUS_ACK]
	 *
	 * EDI Receive <br>
	 *
	 * @param TransferEAI transferEAI
	 * @exception EventException, Exception
	 */
	public void receiveEDIForJapan24HR(TransferEAI transferEAI) throws EventException {
		String ediMessage = transferEAI.getMessage();

		try {
			FormCommand formCommand = new FormCommand();
			formCommand.setCommand(FormCommand.TRANS);

			UBizComOpusBkgJpn24Event uBizComOpusBkgJpn24Event = new UBizComOpusBkgJpn24Event();
			uBizComOpusBkgJpn24Event.setFormCommand(formCommand);
			uBizComOpusBkgJpn24Event.setFlatFile(ediMessage);

			CustomsDeclarationJp24SC customsDeclarationJp24SC = new CustomsDeclarationJp24SC();
			customsDeclarationJp24SC.perform(uBizComOpusBkgJpn24Event);

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

	/**
	 * [EDI_T_BKG_T_JP24SYS_AMR_ACK]
	 * EDI Receive <br>
	 *
	 * @param TransferEAI transferEAI
	 * @exception EventException, Exception
	 */
	public void receiveEDIForJp24SysAmr(TransferEAI transferEAI) throws EventException {
		String ediMessage = transferEAI.getMessage();

		try {
			FormCommand formCommand = new FormCommand();
			formCommand.setCommand(FormCommand.TRANS);

			EdiBkgJp24sysAmrAckEvent ediBkgJp24sysAmrAckEvent = new EdiBkgJp24sysAmrAckEvent();
			ediBkgJp24sysAmrAckEvent.setFormCommand(formCommand);
			ediBkgJp24sysAmrAckEvent.setFlatFile(ediMessage);

			CustomsDeclarationJp24SC customsDeclarationJp24SC = new CustomsDeclarationJp24SC();
			customsDeclarationJp24SC.perform(ediBkgJp24sysAmrAckEvent);

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

	/**
	 * [EDI_T_BKG_T_JP24SYS_ATD_ACK]
	 * EDI Receive <br>
	 *
	 * @param TransferEAI transferEAI
	 * @exception EventException, Exception
	 */
	public void receiveEDIForJp24SysAtd(TransferEAI transferEAI) throws EventException {
		String ediMessage = transferEAI.getMessage();

		try {
			FormCommand formCommand = new FormCommand();
			formCommand.setCommand(FormCommand.TRANS);

			EdiBkgJp24sysAtdAckEvent ediBkgJp24sysAtdAckEvent = new EdiBkgJp24sysAtdAckEvent();
			ediBkgJp24sysAtdAckEvent.setFormCommand(formCommand);
			ediBkgJp24sysAtdAckEvent.setFlatFile(ediMessage);

			CustomsDeclarationJp24SC customsDeclarationJp24SC = new CustomsDeclarationJp24SC();
			customsDeclarationJp24SC.perform(ediBkgJp24sysAtdAckEvent);

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