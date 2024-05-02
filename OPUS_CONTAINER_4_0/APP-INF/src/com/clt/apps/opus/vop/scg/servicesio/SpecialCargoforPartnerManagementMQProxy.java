/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoforPartnerManagementMQProxy.java
*@FileTitle : SpecialCargoforPartnerManagementMQProxy
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.servicesio;

import org.apache.log4j.Logger;

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.SpecialCargoUtilityManagementSC;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.event.DgCgoAproRqstEvent;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

/** 
 *  SpecialCargoforPartnerManagementMQProxy <br>
 * 
 * @author
 * @see
 * @since J2EE 1.6
 */
public class SpecialCargoforPartnerManagementMQProxy {
	
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
     * receiveSpecialCargoApprRqstFromPartnerLines <br>
	 * 
	 * @param TransferEAI eai
	 * @exception EventException
	 */
	public void receiveSpecialCargoApprRqstFromPartnerLines(TransferEAI eai) throws EventException {
		
		String str = eai.getMessage();
		log.debug("=====================================================");
		log.debug("[SpecialCargoforPartnerManagementMQProxy]");
		log.debug(str);
		log.debug("=====================================================");
		Event event = null;
		SpecialCargoUtilityManagementSC sc = new SpecialCargoUtilityManagementSC();

		try{
			event = new DgCgoAproRqstEvent();
	
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI01);
			event.setFormCommand(f);
			
			((DgCgoAproRqstEvent) event).setFlatFileText(str);
			sc.perform(event);
			eai.commit(str.substring(0,10));
		} catch (EventException e) {
			eai.rollback(e);			
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		} catch (Exception e) {
			eai.rollback(e);
			log.error(" Exception e : " + e.toString() );	
			throw new EventException(e.getMessage());
		}
		eai.close();
	}
	
	/**
     * receiveSpecialCargoApprRqstAckFromPartnerLines <br>
	 * 
	 * @param TransferEAI eai
	 * @exception EventException
	 */
	public void receiveSpecialCargoApprRqstAckFromPartnerLines(TransferEAI eai) throws EventException{
		String str = eai.getMessage();
		log.debug("=====================================================");
		log.debug("[receiveSpecialCargoApprRqstAckFromPartnerLines]");
		log.debug(str);
		log.debug("=====================================================");
		Event event = null;
		SpecialCargoUtilityManagementSC sc = new SpecialCargoUtilityManagementSC();

		try{
			event = new DgCgoAproRqstEvent();
	
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI02);
			event.setFormCommand(f);
			
			((DgCgoAproRqstEvent) event).setFlatFileText(str);
			sc.perform(event);
			eai.commit(str.substring(0,10));
		} catch (EventException e) {
			eai.rollback(e);			
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		} catch (Exception e) {
			eai.rollback(e);
			log.error(" Exception e : " + e.toString() );	
			throw new EventException(e.getMessage());
		}
		eai.close();
	}
	
}
