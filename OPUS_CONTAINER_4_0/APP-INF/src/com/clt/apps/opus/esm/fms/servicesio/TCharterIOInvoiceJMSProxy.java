/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : TCharterIOInvoiceJMSProxy.java
 *@FileTitle : FNS056-0001 Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 최우석
 *@LastVersion : 1.0
 * 2009.06.18 최우석
 * 1.0 최초 생성
 =========================================================*/
package com.clt.apps.opus.esm.fms.servicesio;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.TimeCharterInOutAccountingSC;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFmsESM0660001Event;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFmsFNS0560001Event;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.irep.enisEsm.ESM0660001Document;
import com.clt.irep.erp.FNS0560001Document;
import com.jf.transfer.TransferEAI;

/**
 * JMS 서버에서 받은 xml 메세지를 Event에 담아 Service Command에 넘겨준다.
 * [주의]queue-mapping.xml에 메서드가 정의 되어 있어야 한다.
 * 
 * @author Choi,Woo-Seok
 * @see queue-mappinp.xml, TimeCharterInOutAccountingSC 참조
 * @since J2EE 1.6
 */
public class TCharterIOInvoiceJMSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * JMS Receive(FNS056-0001)<br>
	 * 
	 * @param eai TransferEAI
	 * @exception EventException, XmlException, Exception
	 */
	public void manageOwnerAccountInterface(TransferEAI eai) {
		String str = eai.getMessage();
		Event event = null;
		TimeCharterInOutAccountingSC timeCharterInOutAccountingSC = new TimeCharterInOutAccountingSC();
		
		try {
			event = new EsmFmsFNS0560001Event();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			FNS0560001Document doc = FNS0560001Document.Factory.parse(str);
			((EsmFmsFNS0560001Event)event).setXmlObject(doc);
			timeCharterInOutAccountingSC.perform(event);
			eai.commit(doc.getFNS0560001().getEAIHeader().getInstanceId());
		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error("XmlException ex : " + xe.toString(), xe);
			eai.rollback(xe);
		} catch (Exception ex){
			log.error("Exception e : " + ex.toString());
			eai.rollback(ex);
		}

		eai.close();
	}
	
	/**
	 * JMS Receive(ESM066_0001)<br>
	 * 
	 * @param eai TransferEAI
	 * @exception EventException, XmlException, Exception
	 */
	public void manageOffHireExpenseInterface(TransferEAI eai) {
		String str = eai.getMessage();
		Event event = null;
		TimeCharterInOutAccountingSC timeCharterInOutAccountingSC = new TimeCharterInOutAccountingSC();
		
		try {
			event = new EsmFmsESM0660001Event();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			ESM0660001Document doc = ESM0660001Document.Factory.parse(str);
			((EsmFmsESM0660001Event)event).setXmlObject(doc);
			timeCharterInOutAccountingSC.perform(event);
			eai.commit(doc.getESM0660001().getEAIHeader().getInstanceId());
		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error("XmlException ex : " + xe.toString(), xe);
			eai.rollback(xe);
		} catch (Exception ex){
			log.error("Exception e : " + ex.toString());
			eai.rollback(ex);
		}

		eai.close();
	}
}

