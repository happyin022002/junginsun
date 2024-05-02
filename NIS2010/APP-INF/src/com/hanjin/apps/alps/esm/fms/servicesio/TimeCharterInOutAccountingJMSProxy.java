/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : TimeCharterInOutAccountingJMSProxy.java
 *@FileTitle : ERP Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.02
 *@LastModifier : 윤세영
 *@LastVersion : 1.0
 * 2009.09.02 윤세영
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.esm.fms.servicesio;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.TimeCharterInOutAccountingSC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFmsVslPortSkdSyncEvent;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFmsFNS012R002Event;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.erp.FNS012R002Document;
import com.hanjin.irep.nists.VSLPORTSKDSYNCDocument;
import com.jf.transfer.TransferEAI;

/**
 * JMS 서버에서 받은 xml 메세지를 Event에 담아 Service Command에 넘겨준다.
 * [주의]queue-mapping.xml에 메서드가 정의 되어 있어야 한다.
 * 
 * @author Yoon,Seyeong
 * @see queue-mappinp.xml, TimeCharterInOutAccountingSC 참조
 * @since J2EE 1.6
 */
public class TimeCharterInOutAccountingJMSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * JMS Receive(FNS008-R003)<br>
	 * 
	 * @param eai TransferEAI
	 * @exception EventException, XmlException, Exception
	 */
	public void receiveSlipApprovalToAR (TransferEAI eai) {
		String str = eai.getMessage();
		Event event = null;
		TimeCharterInOutAccountingSC timeCharterInOutAccountingSC = new TimeCharterInOutAccountingSC();
		
		try {
			
			event = new EsmFmsFNS012R002Event();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			FNS012R002Document doc = FNS012R002Document.Factory.parse(str);
			((EsmFmsFNS012R002Event)event).setXmlObject(doc);
			timeCharterInOutAccountingSC.perform(event);
			eai.commit(doc.getFNS012R002().getEAIHeader().getInstanceId());
			
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
	 * JMS Receive(VSL_PORT_SKD_SYNC)<br>
	 * 
	 * @param eai TransferEAI
	 * @exception EventException, XmlException, Exception
	 */
	public void receiveVvd (TransferEAI eai) {
		String str = eai.getMessage();
		Event event = null;
		TimeCharterInOutAccountingSC timeCharterInOutAccountingSC = new TimeCharterInOutAccountingSC();
		
		try {
			
			event = new EsmFmsVslPortSkdSyncEvent();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			VSLPORTSKDSYNCDocument doc = VSLPORTSKDSYNCDocument.Factory.parse(str);
			((EsmFmsVslPortSkdSyncEvent)event).setXmlObject(doc);
			timeCharterInOutAccountingSC.perform(event);
			eai.commit(doc.getVSLPORTSKDSYNC().getEAIHeader().getInstanceId());
			
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

