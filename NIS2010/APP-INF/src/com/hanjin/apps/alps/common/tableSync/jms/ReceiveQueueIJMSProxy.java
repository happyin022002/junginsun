/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueIJMSProxy.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.9
 * 2006-12-21 Kim Jung-Jae - 1.0 최초 생성
 * 2009-03-10 Lee Haeng-Ji - 1.9 추가 (신규프로젝트 No  : S2Q-09P-004, 프로젝트명 : Bay Plan I/F )
 *                               manageOPF_BAY_PLN_LDIS() 추가
 * 2009-09-25 : Ho-Jin Lee - manageArRoutRnk, manageArAgnStmtAgmt 추가                               
 =========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.common.tableSync.jms.event.ReceiveQueueEvent;
import com.hanjin.apps.alps.common.tableSync.jms.event.ReceiveQueueEventResponse;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.erp.FNS0400001Document;
import com.hanjin.irep.erp.FNS0410001Document;
import com.hanjin.irep.erp.FNS0420001Document;
import com.hanjin.irep.erp.FNS0440001Document;
import com.hanjin.irep.erp.FNS0450001Document;
import com.hanjin.irep.erp.FNS0460001Document;
import com.hanjin.irep.erp.FNS0470001Document;
import com.hanjin.irep.erp.FNS0480002Document;
import com.hanjin.irep.erp.FNS0520001Document;
import com.jf.transfer.TransferEAI;

/**
 * JMS 서버에서 xml 메세지를 받아 RSC 에 넘겨준다.
 * Event 관리를 한다.
 * [주의]queue-mapping.xml에 메서드가 정의 되어 있어야 한다.
 * @author Kim Jung-Jae
 * @see
 * @since J2EE 1.4  
 */
public class ReceiveQueueIJMSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * FNS0410001Document
	 * @param str
	 * @throws EventException
	 */
	public void manageArFincDirConv( TransferEAI eai ) throws EventException {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageArFincDirConv");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			FNS0410001Document arDoc = FNS0410001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(arDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(arDoc.getFNS0410001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error("err " + ee.toString(), ee);
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException xe : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error("Exception e: " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	/**
	 * FNS0470001Document
	 * @param str
	 * @throws EventException
	 */
	public void manageGlMonXchRt( TransferEAI eai ) throws EventException {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageGlMonXchRt");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			FNS0470001Document arDoc = FNS0470001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(arDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(arDoc.getFNS0470001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error("err " + ee.toString(), ee);
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException xe : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error("Exception e: " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	/**
	 * FNS0400001Document
	 * @param str
	 * @throws EventException
	 */
	public void manageArRoutRnk( TransferEAI eai ) throws EventException {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageArRoutRnk");
			log.info("\n <<1>>");
			FormCommand f = new FormCommand();
			log.info("\n <<2>>");
			f.setCommand(FormCommand.SEARCH);
			log.info("\n <<3>>");
			event.setFormCommand(f);
			log.info("\n <<4>>");
			FNS0400001Document arDoc = FNS0400001Document.Factory.parse(str);
			log.info("\n <<5>>"+ arDoc);
			((ReceiveQueueEvent) event).setXmlObject(arDoc);
			log.info("\n <<6>>");
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			log.info("\n <<7>>");
			eai.commit(arDoc.getFNS0400001().getEAIHeader().getInstanceId());
			log.info("\n <<8>>");
		} catch (EventException ee) {
			log.error("err " + ee.toString(), ee);
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException xe : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error("Exception e: " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * FNS0440001Document
	 * @param str
	 * @throws EventException
	 */
	public void manageArAgnStmtAgmt( TransferEAI eai ) throws EventException {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("\n xml : \n" + str);
		log.debug("======================================");
		Event event = null;
		log.info("\n == 1 Event event = null =");
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();
		log.info("\n == 2 ReceiveQueueRSC rsc = new ReceiveQueueRSC() =");

		try {
			event = new ReceiveQueueEvent("manageArAgnStmtAgmt");
			log.info("\n ==3 event = new ReceiveQueueEvent('manageArAgnStmtAgmt')=");
			FormCommand f = new FormCommand();
			log.info("\n ==4 FormCommand f = new FormCommand()=");
			f.setCommand(FormCommand.SEARCH);
			log.info("\n ==5 f.setCommand(FormCommand.SEARCH)=");
			event.setFormCommand(f);
			log.info("\n ==6 event.setFormCommand(f)=");

			FNS0440001Document arDoc = FNS0440001Document.Factory.parse(str);
			log.info("\n ==7 FNS0440001Document arDoc = FNS0440001Document.Factory.parse(str)=");
			
			if(arDoc == null){
				throw new Exception("\n arDoc Parse Failed!!!!!!!!!!!!!!!!!!!!"); 
			}
			((ReceiveQueueEvent) event).setXmlObject(arDoc);
			log.info("\n ==8 ((ReceiveQueueEvent) event).setXmlObject(arDoc)=");
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			log.info("\n ==9 ((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject()=");
			
			eai.commit(arDoc.getFNS0440001().getEAIHeader().getInstanceId());
			log.info("\n ==10 eai.commit(arDoc.getFNS0440001().getEAIHeader().getInstanceId())=");

		} catch (EventException ee) {
			log.error("err " + ee.toString(), ee);
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException xe : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error("Exception e: " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}

	/**
	 * FNS0460001Document
	 * @param str
	 * @throws EventException
	 */
	public void manageApLuVal( TransferEAI eai ) throws EventException {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageApLuVal");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			FNS0460001Document arDoc = FNS0460001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(arDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(arDoc.getFNS0460001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error("err " + ee.toString(), ee);
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException xe : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error("Exception e: " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * FNS0520001Document
	 * @param str
	 * @throws EventException
	 */
	public void manageApWorkplace( TransferEAI eai ) throws EventException {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageApWorkplace");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			FNS0520001Document arDoc = FNS0520001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(arDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(arDoc.getFNS0520001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error("err " + ee.toString(), ee);
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException xe : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error("Exception e: " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}

	/**
	 * FNS0420001Document
	 * @param str
	 * @throws EventException
	 */
	public void manageArMstRevVvd( TransferEAI eai ) throws EventException {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageArMstRevVvd");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			FNS0420001Document arDoc = FNS0420001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(arDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(arDoc.getFNS0420001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error("err " + ee.toString(), ee);
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException xe : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error("Exception e: " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	
	/**
	 * FNS0480002Document
	 * @param str
	 * @throws EventException
	 */
	public void manageApPeriod( TransferEAI eai ) throws EventException {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageApPeriod");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			FNS0480002Document arDoc = FNS0480002Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(arDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(arDoc.getFNS0480002().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error("err " + ee.toString(), ee);
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException xe : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error("Exception e: " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * FNS0450001Document
	 * @param str
	 * @throws EventException
	 */
	public void manageApTax( TransferEAI eai ) throws EventException {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageApTax");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			FNS0450001Document arDoc = FNS0450001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(arDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			eai.commit(arDoc.getFNS0450001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error("err " + ee.toString(), ee);
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException xe : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error("Exception e: " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}	
	
}


