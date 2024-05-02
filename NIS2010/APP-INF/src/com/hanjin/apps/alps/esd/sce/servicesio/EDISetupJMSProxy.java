/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EDISetupJMSProxy.java
*@FileTitle : EDISetupJMSProxy
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-06
*@LastModifier : Jun Byoung Suk
*@LastVersion : 1.0
* 2009-09-06 Jun Byoung Suk
* 1.0 최초 생성
* 2010.11.08 김진승 [소스품질보완] throw EAIException 추가
=========================================================*/
package com.hanjin.apps.alps.esd.sce.servicesio;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.esd.sce.edisetup.EDISetupSC;
import com.hanjin.apps.alps.esd.sce.edisetup.event.EDISetupEvent;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.enisEsd.ESD0310001Document;
import com.hanjin.irep.enisEsd.ESD0320001Document;
import com.hanjin.irep.enisEsd.ESD0330001Document;
import com.hanjin.irep.enisEsd.ESD0340001Document;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;

/**
 * EAI_322_MSG 테이블 싱크를 위한 Event생성하여 ServiceCommand 호출<br>
 *
 * @author Jun Byoung Suk 
 * @see CLMReceiveEAIJMSProxy 참조
 * @since J2EE 1.4
 */
public class EDISetupJMSProxy {
	
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	/** 
	 * JMS 로부터 전문을 받아 처리하는 함수<br>
	 * 
	 * @param eai TransferEAI
	 * @throws  EAIException
	 */
	public void syncEdi_cgo_stnd_sts(TransferEAI eai) throws EAIException{
		String str = eai.getMessage();
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");		
		Event event = null;
		EDISetupSC rsc = new EDISetupSC();
		try{
			event = new EDISetupEvent();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MODIFY01);
			event.setFormCommand(f);
			((EDISetupEvent) event).setMessage(str);
			 rsc.perform(event);
			 eai.commit(ESD0310001Document.Factory.parse(str).getESD0310001().getEAIHeader().getInstanceId());
		} catch (EventException e) {
			eai.rollback(e);
			log.error("\n EventException: "+e.getMessage());
			throw new EAIException(e.getMessage());
		} catch (XmlException e) {
			eai.rollback(e);
			log.error("\n XmlException: "+e.getMessage());
			throw new EAIException(e.getMessage());
		} catch (EAIException e) {
			eai.rollback(e);
			log.error("\n EAIException: "+e.getMessage());
			throw new EAIException(e.getMessage());
		}//try
		eai.close();	
	}
    /** 
     * EAI로 부터 JMS를 통해 들어온 값을 받아서 처리한다.(ESD0320001)
     * @param eai TransferEAI  
     * @throws EAIException
     */
    public void syncEdi_group(TransferEAI eai) throws EAIException{
		String str = eai.getMessage();
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");		
		Event event = null;
		EDISetupSC rsc = new EDISetupSC();
		try{
			event = new EDISetupEvent();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MODIFY02);
			event.setFormCommand(f);
			((EDISetupEvent) event).setMessage(str);
			 rsc.perform(event);
			 eai.commit(ESD0320001Document.Factory.parse(str).getESD0320001().getEAIHeader().getInstanceId());
		} catch (EventException e) {
			eai.rollback(e);
			log.error("\n EventException: "+e.getMessage());
			throw new EAIException(e.getMessage());
		} catch (XmlException e) {
			eai.rollback(e);
			log.error("\n XmlException: "+e.getMessage());
			throw new EAIException(e.getMessage());
		} catch (EAIException e) {
			eai.rollback(e);
			log.error("\n EAIException: "+e.getMessage());
			throw new EAIException(e.getMessage());
		}//try
		eai.close();    	
    	
    }
    /** 
     * EAI로 부터 JMS를 통해 들어온 값을 받아서 처리한다.(ESD0320001)
     * @param eai TransferEAI  
     * @throws EAIException
     */    
    public void syncEdi_grp_cgo(TransferEAI eai) throws EAIException{
		String str = eai.getMessage();
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");		
		Event event = null;
		EDISetupSC rsc = new EDISetupSC();
		try{
			event = new EDISetupEvent();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MODIFY03);
			event.setFormCommand(f);
			((EDISetupEvent) event).setMessage(str);
			 rsc.perform(event);
			 eai.commit(ESD0330001Document.Factory.parse(str).getESD0330001().getEAIHeader().getInstanceId());	
		} catch (EventException e) {
			eai.rollback(e);
			log.error("\n EventException: "+e.getMessage());
			throw new EAIException(e.getMessage());
		} catch (XmlException e) {
			eai.rollback(e);
			log.error("\n XmlException: "+e.getMessage());
			throw new EAIException(e.getMessage());
		} catch (EAIException e) {
			eai.rollback(e);
			log.error("\n EAIException: "+e.getMessage());
			throw new EAIException(e.getMessage());
		}//try
		eai.close();    	
    }
    /** 
     * EAI로 부터 JMS를 통해 들어온 값을 받아서 처리한다.(ESD0320001)
     * @param eai TransferEAI  
     * @throws EAIException
     */    
	public void syncEdi_grp_cust(TransferEAI eai) throws EAIException{
		String str = eai.getMessage();
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");		
		Event event = null;
		EDISetupSC rsc = new EDISetupSC();
		try{
			event = new EDISetupEvent();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MODIFY04);
			event.setFormCommand(f);
			((EDISetupEvent) event).setMessage(str);			
			 rsc.perform(event);
			 eai.commit(ESD0340001Document.Factory.parse(str).getESD0340001().getEAIHeader().getInstanceId());
		} catch (EventException e) {
			eai.rollback(e);
			log.error("\n EventException: "+e.getMessage());
			throw new EAIException(e.getMessage());
		} catch (XmlException e) {
			eai.rollback(e);
			log.error("\n XmlException: "+e.getMessage());
			throw new EAIException(e.getMessage());
		} catch (EAIException e) {
			eai.rollback(e);
			log.error("\n EAIException: "+e.getMessage());
			throw new EAIException(e.getMessage());
		}//try
		eai.close();
		
	}	

}
