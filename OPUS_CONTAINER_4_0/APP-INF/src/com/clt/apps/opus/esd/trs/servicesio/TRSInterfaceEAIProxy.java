/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : TRSInterfaceRSC.java
 *@FileTitle : common trs 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio;

import org.apache.log4j.Logger;

import com.clt.apps.opus.esd.trs.servicesio.TRSInterfaceRSC;
import com.clt.apps.opus.esd.trs.servicesio.usarailwoack.event.EdiEns001Event;
import com.clt.apps.opus.esd.trs.servicesio.usarailwoack.event.EdiEns002Event;
import com.clt.apps.opus.esd.trs.servicesio.workorder.WorkOrderMainRSC;
import com.clt.apps.opus.esd.trs.servicesio.workorder.event.WorkOrderRcvEvent;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;

/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON handling business transaction.<br>
 * 
 * @author
 * @see Refer to each DAO classes
 * @since
 */
public class TRSInterfaceEAIProxy {

	/**
	 * Log
	 */
	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * . EDI-027-IN-Vendor-824, 997 (US - 824, 997)
	 * 
	 * @param eai
	 * @throws EventException
	 */
	public void manageUSARailWoAckMQ(TransferEAI eai) throws EventException {
		String str = eai.getMessage();
		log.debug("EDI-027-IN-Vendor-824, 997 (US - 824, 997) EDI start  : " + str);
		Event event = null;
		TRSInterfaceRSC rsc = new TRSInterfaceRSC();
		try {
			event = new EdiEns001Event();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			((EdiEns001Event) event).setString(str);
			rsc.perform(event);
			eai.commit(str.substring(0, 10));
		} catch (EventException e) {
			eai.rollback(e);
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		} catch (EAIException e1) {
			eai.rollback(e1);
			log.error(" EAIException e1 : " + e1.toString());
			throw new EventException(e1.getMessage());
		}
		log.debug("EDI-027-IN-Vendor-824, 997 (US - 824, 997) EDI END  : ");
	}

	/**
	 * EDI-026-IN-VENDOR-417 (US - 417)
	 * 
	 * @param eai
	 * @throws EventException
	 */
	public void manageUSARail417WoAckMQ(TransferEAI eai) throws EventException {
		String str = eai.getMessage();
		log.debug("EDI-026-IN-VENDOR-417 (US - 417) EDI START  : " + str);
		Event event = null;
		TRSInterfaceRSC rsc = new TRSInterfaceRSC();
		try {
			event = new EdiEns002Event();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			((EdiEns002Event) event).setString(str);
			rsc.perform(event);
			eai.commit(str.substring(0, 10));
		} catch (EventException e) {
			eai.rollback(e);
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		} catch (EAIException e1) {
			eai.rollback(e1);
			log.error(" EAIException e1 : " + e1.toString());
			throw new EventException(e1.getMessage());
		}
		log.debug("EDI-026-IN-VENDOR-417 (US - 417) EDI END  : ");
	}

	/**
	 * EDI-108-IN-VENDOR-JOEDI (Global - JOEDI)
	 * 
	 * @param eai
	 * @throws EventException
	 */
	public void manageGblWoAckMQ(TransferEAI eai) throws EventException {
		String str = eai.getMessage();

		log.debug("EDI-108-IN-VENDOR-JOEDI (Global - JOEDI) EDI START  : " + str);
		Event event = null;
		WorkOrderMainRSC rsc = new WorkOrderMainRSC();
		try {
			event = new WorkOrderRcvEvent();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			((WorkOrderRcvEvent) event).setEaiRcvContents(str);
			rsc.perform(event);
			eai.commit(str.substring(0, 10));
		} catch (EventException e) {
			eai.rollback(e);

			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		} catch (EAIException e1) {
			eai.rollback(e1);

			log.error(" EAIException e1 : " + e1.toString());
			throw new EventException(e1.getMessage());
		}
		log.debug("EDI-108-IN-VENDOR-JOEDI (Global - JOEDI) EDI END ");
	}
}