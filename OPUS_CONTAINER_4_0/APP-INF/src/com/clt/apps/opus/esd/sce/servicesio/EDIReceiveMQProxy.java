/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EDIReceiveMQProxy
 *@FileTitle : Interface 연동
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-11-01
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009-11-01 
 * 1.0 최초 생성
 * 2010.11.08 김진승 [소스품질보완] throw EAIException 추가
 * 2014.11.04 김인규 BL Pickup list 추가
 =========================================================*/
package com.clt.apps.opus.esd.sce.servicesio;
 
import org.apache.log4j.Logger;

import com.clt.apps.opus.esd.sce.receiveeai.clmreceiveeai.CLMReceiveEAIRSC;
import com.clt.apps.opus.esd.sce.receiveeai.clmreceiveeai.event.EsdSce0151Event;
import com.clt.apps.opus.esd.sce.receiveeai.edi322receive.Edi322ReceiveRSC;
import com.clt.apps.opus.esd.sce.receiveeai.edi322receive.event.EsdSce0150Event;
import com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.EdiBLPickUpReceiveRSC;
import com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.event.EsdSceBLPickUpEvent;
import com.clt.apps.opus.esd.sce.visibilitymanage.edi214Receive.Edi214ReceiveRSC;
import com.clt.apps.opus.esd.sce.visibilitymanage.edi214Receive.event.EsdSce0085Event;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;

/**
 * edi 322 수신 Event생성하여 ServiceCommand 호출<br>
 *
 * @author 
 * @see Edi322ReceiveRSC 참조
 * @since J2EE 1.4
 */
public class EDIReceiveMQProxy {
	
	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	
/**
 * MQ : 
 * @param eai
 * @throws EAIException
 */
public void createEDI322data(TransferEAI eai) throws EAIException {

	String str = eai.getMessage();
	Event event = null;
	Edi322ReceiveRSC rsc = new Edi322ReceiveRSC();

	try {
		log.info("<<<<<<<<<< createEDI322data - BEGIN >>>>>>>>>>>>>>>>");

		event = new EsdSce0150Event();
		FormCommand f = new FormCommand();
		f.setCommand(FormCommand.SEARCH);
		event.setFormCommand(f);

		((EsdSce0150Event)event).setString(str);

	    rsc.perform(event);
	    
		log.info("<<<<<<<<<< createEDI322data - END >>>>>>>>>>>>>>>>");

		} catch (EventException e) {
			log.error("\n  JMSProxy.createEDI322data.EventException - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			log.error(e.getMessage());
			throw new EAIException(e.toString());
		}
	}

/**
 * MQ : 
 * @param eai
 * @throws EAIException
 */
	public void createClmdata(TransferEAI eai) throws EAIException {

		String str = eai.getMessage();
		Event event = null;
		CLMReceiveEAIRSC rsc = new CLMReceiveEAIRSC();
	
		try {
			log.info("<<<<<<<<<< createClmdata - BEGIN >>>>>>>>>>>>>>>>");
	
			event = new EsdSce0151Event();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);
	
			((EsdSce0151Event)event).setString(str);
					
			//((EsdSce0085EventResponse)rsc.perform(event)).getString();
		    rsc.perform(event);
		    
			log.info("<<<<<<<<<< createClmdata - END >>>>>>>>>>>>>>>>");
	
		} catch (EventException e) {
			log.error("\n  JMSProxy.createClmdata.EventException - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			log.error(e.getMessage());
			throw new EAIException(e.toString());
		}
	}

	/**
	 * MQ : 
	 * @param eai
	 * @throws EAIException
	 */
	public void createEDI214data(TransferEAI eai) throws EAIException {

		String str = eai.getMessage();
		Event event = null;
		Edi214ReceiveRSC rsc = new Edi214ReceiveRSC();
	
		try {
			log.info("<<<<<<<<<< createEDI214data - BEGIN >>>>>>>>>>>>>>>>");
	
			event = new EsdSce0085Event();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);
	
			((EsdSce0085Event)event).setString(str);
					
			rsc.perform(event);
			//((EsdSce0085EventResponse)rsc.perform(event)).getString();
			
			log.info("<<<<<<<<<< createEDI214data - END >>>>>>>>>>>>>>>>");
	
		} catch (EventException e) {
			log.error("\n  JMSProxy.createEDI214data.EventException - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			log.error(e.getMessage());
			throw new EAIException(e.toString());
		}
	
		log.error("\n ## DONE - JMSProxy.createEDIinvoice:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+
			  "\n ############################################################################ \n\n\n\n\n\n");		
	}
	
	/**
	 * MQ : 
	 * @param eai
	 * @throws EAIException
	 */
	public void createEDIBLPickUpdata(TransferEAI eai) throws EAIException {

		String str = eai.getMessage();
		Event event = null;
		EdiBLPickUpReceiveRSC rsc = new EdiBLPickUpReceiveRSC();

		try {
			log.info("<<<<<<<<<< createEDIBLPickUpdata - BEGIN >>>>>>>>>>>>>>>>");

			event = new EsdSceBLPickUpEvent();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			((EsdSceBLPickUpEvent)event).setString(str);

		    rsc.perform(event);
		    
			log.info("<<<<<<<<<< createEDIBLPickUpdata - END >>>>>>>>>>>>>>>>");

			} catch (EventException e) {
				log.error("\n  JMSProxy.createEDIBLPickUpdata.EventException - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				log.error(e.getMessage());
				throw new EAIException(e.toString());
			}
		}	
}