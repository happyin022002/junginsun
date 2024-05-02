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
package com.hanjin.apps.alps.esm.bkg.servicesio;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.TerminalDocumentationSC;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkgUdevhjsAlpsBkgCllAckEvent;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event.AlpsbkgTEurbaplieEvent;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event.AlpsbkgTEurcusAckEven;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.event.AlpsbkgTPsacusAckEven;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
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
	 * JMS Receive(UDEVHJS_ALPSBKG_T_EURBAPLIE)<br>
	 * EUR 수신
	 * @param eai 
	 * @exception EventException
	 * @exception Exception
	 */
	public void alpsbkgTEurbaplieReceiveMQ(TransferEAI eai) throws DAOException, Exception {

		log.info("<<<<<<<<<< alpsbkgTEurbaplieReceiveMQ Start >>>>>>>>>>>>>>>>");		
		
		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");
		
		Event event = null;
		TerminalDocumentationSC terminalDocumentationSC = new TerminalDocumentationSC();		
		try {
			event = new AlpsbkgTEurbaplieEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			
			((AlpsbkgTEurbaplieEvent) event).setFlatFile(str);
			terminalDocumentationSC.perform(event);
			
			log.info("<<<<<<<<<< alpsbkgTEurbaplieReceiveMQ End >>>>>>>>>>>>>>>>");
			
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
	 * JMS Receive(UDEVHJS_ALPSBKG_T_EURCUS_ACK)<br>
	 * EUR 수신
	 * @param eai 
	 * @exception  EventException
	 * @@exception Exception
	 */
	public void udevhjsAlpsAkgTEurDgAckReceiveMQ(TransferEAI eai) throws DAOException, Exception  {

		
		log.info("<<<<<<<<<< udevhjsAlpsAkgTEurDgAckReceiveMQ Start >>>>>>>>>>>>>>>>");		
		
		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");
		
		Event event = null;
		TerminalDocumentationSC terminalDocumentationSC = new TerminalDocumentationSC();		
		try {
			event = new AlpsbkgTEurcusAckEven();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			
			((AlpsbkgTEurcusAckEven) event).setFlatFile(str);
			terminalDocumentationSC.perform(event);
			
			log.info("<<<<<<<<<< udevhjsAlpsAkgTEurDgAckReceiveMQ End >>>>>>>>>>>>>>>>");
			
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
	 * JMS Receive(UDEVHJS_ALPSBKG_T_NACCS)<br>
	 * 
	 * @param eai TransferEAI
	 * @exception EventException, XmlException, Exception
	 */
	public void alpsbkgCllAckMQ(TransferEAI eai) throws DAOException {

		
		String str = eai.getMessage();
		
		Event event = null;
		TerminalDocumentationSC terminalDocumentationSC = new TerminalDocumentationSC();		
		try {
			event = new EsmBkgUdevhjsAlpsBkgCllAckEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			
			((EsmBkgUdevhjsAlpsBkgCllAckEvent) event).setFlatFile(str);		
			terminalDocumentationSC.perform(event);
			
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
	 * JMS Receive(UDEVHJS_ALPSBKG_T_PSADG_ACK)<br>
	 * PSA 수신
	 * @param eai 
	 * @exception  EventException
	 * @@exception Exception
	 */
	public void udevhjsAlpsAkgTPSADGDgAckReceiveMQ(TransferEAI eai) throws DAOException, Exception  {

		
		log.info("<<<<<<<<<< udevhjsAlpsAkgTPsaDgAckReceiveMQ Start >>>>>>>>>>>>>>>>");		
		
		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");
		
		Event event = null;
		TerminalDocumentationSC terminalDocumentationSC = new TerminalDocumentationSC();		
		try {
			event = new AlpsbkgTPsacusAckEven();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			
			((AlpsbkgTPsacusAckEven) event).setFlatFile(str);
			terminalDocumentationSC.perform(event);
			
			log.info("<<<<<<<<<< udevhjsAlpsAkgTPsaDgAckReceiveMQ End >>>>>>>>>>>>>>>>");
			
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