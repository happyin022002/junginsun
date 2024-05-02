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
 =========================================================*/
package com.hanjin.apps.alps.esd.sce.servicesio;
 
import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esd.sce.receiveeai.clmreceiveeai.CLMReceiveEAIRSC;
import com.hanjin.apps.alps.esd.sce.receiveeai.clmreceiveeai.event.EsdSce0151Event;
import com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.Edi322ReceiveRSC;
import com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.event.EsdSce0150Event;
import com.hanjin.apps.alps.esd.sce.receiveeai.holdstatusreceive.EdiHoldStatusReceiveRSC;
import com.hanjin.apps.alps.esd.sce.receiveeai.holdstatusreceive.event.EsdSce0152Event;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.Edi214ReceiveRSC;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.edi214receive.event.EsdSce0085Event;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
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
				
		//((EsdSce0085EventResponse)rsc.perform(event)).getString();
	    rsc.perform(event);
	    
		log.info("<<<<<<<<<< createEDI322data - END >>>>>>>>>>>>>>>>");

		} catch (EventException e) {
			log.error("\n  JMSProxy.createEDI322data.EventException - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			log.error(e.getMessage());
//			log.error("stack trace start====>");
//            e.printStackTrace();
//            log.error("<===stack trace end");
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
	 * MQ : Hold Status 수신 
	 * @param eai
	 * @throws EAIException
	 */
	public void createHoldStatusData(TransferEAI eai) throws EAIException {
		log.info("<<<<<<<<<< createHoldStatusData - START >>>>>>>>>>>>>>>>");
		String str = eai.getMessage();
		Event event = null;
		EdiHoldStatusReceiveRSC rsc = new EdiHoldStatusReceiveRSC();
		log.info("str = "+str);
		
		try {
			log.info("<<<<<<<<<< createHoldStatusData - TRY BEGIN >>>>>>>>>>>>>>>>");

			event = new EsdSce0152Event();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			((EsdSce0152Event)event).setString(str);
					
		    rsc.perform(event);
		    
			log.info("<<<<<<<<<< createHoldStatusData - END >>>>>>>>>>>>>>>>");

			} catch (EventException e) {
				log.error("\n  JMSProxy.createHoldStatusData.EventException - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
				log.error(e.getMessage());
//				log.error("stack trace start====>");
//	            e.printStackTrace();
//	            log.error("<===stack trace end");
				throw new EAIException(e.toString());
			}
	}

}