/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TerminalDocumentationProxy.java
 *@FileTitle : Receive WebLogic JMS Queue Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-09-15
 *@LastModifier : Kyong Jong Yun
 *@LastVersion : 1.0
 * 2009-07-01
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.bkg.servicesio;

import org.apache.log4j.Logger;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.SpecialManifestSC;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.OpusBkgTEurbaplieEvent;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.OpusBkgTEurcusAckEven;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

/**
 * It's GEMPlanningPerformanceJMSProxy.java
 *
 * @author Hyunsu, Ryu
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class TerminalDocumentationProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());


	/**
	 * 유럽 BAPLIE 수신<BR>
	 * JMS Receive(UDEVCOM_OPUSBKG_T_EURBAPLIE)<br>
	 * EUR 수신
	 * @param eai
	 * @exception EventException
	 * @exception Exception
	 */
	public void opusbkgTEurbaplieReceiveMQ(TransferEAI eai) throws DAOException, Exception {

		log.info("<<<<<<<<<< opusbkgTEurbaplieReceiveMQ Start >>>>>>>>>>>>>>>>");

		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");

		Event event = null;
		SpecialManifestSC specialManifestSC = new SpecialManifestSC();
		try {
			event = new OpusBkgTEurbaplieEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);

			((OpusBkgTEurbaplieEvent) event).setFlatFile(str);
			specialManifestSC.perform(event);

			log.info("<<<<<<<<<< opusbkgTEurbaplieReceiveMQ End >>>>>>>>>>>>>>>>");

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

	/**
	 * 구주위험물 신고 응답메시지 수신 수신<BR>
	 * JMS Receive(UDEVCOM_OPUSBKG_T_EURCUS_ACK)<br>
	 * EUR 수신
	 * @param eai
	 * @exception  EventException
	 * @@exception Exception
	 */
	public void udevcomOpusAkgTEurDgAckReceiveMQ(TransferEAI eai) throws DAOException, Exception  {


		log.info("<<<<<<<<<< udevcomOpusAkgTEurDgAckReceiveMQ Start >>>>>>>>>>>>>>>>");

		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");

		Event event = null;
		SpecialManifestSC specialManifestSC = new SpecialManifestSC();
		try {
			event = new OpusBkgTEurcusAckEven();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);

			((OpusBkgTEurcusAckEven) event).setFlatFile(str);
			specialManifestSC.perform(event);

			log.info("<<<<<<<<<< udevcomOpusAkgTEurDgAckReceiveMQ End >>>>>>>>>>>>>>>>");

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

	/**
	 * JMS Receive(UDEVCOM_OPUSBKG_T_NACCS)<br>
	 *
	 * @param eai TransferEAI
	 * @exception EventException, XmlException, Exception
	 */
	public void opusbkgCllAckMQ(TransferEAI eai) throws DAOException {


		String str = eai.getMessage();

		Event event = null;
		SpecialManifestSC specialManifestSC = new SpecialManifestSC();
		try {
			event = new OpusBkgTEurbaplieEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);

			((OpusBkgTEurbaplieEvent) event).setFlatFile(str);
			specialManifestSC.perform(event);

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