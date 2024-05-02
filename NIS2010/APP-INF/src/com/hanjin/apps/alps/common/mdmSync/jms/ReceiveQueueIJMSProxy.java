/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueIJMSProxy.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.common.mdmSync.jms.event.ReceiveQueueEvent;
import com.hanjin.apps.alps.common.mdmSync.jms.event.ReceiveQueueEventResponse;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.RejectMdmCustVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.jms.event.JmsReceiveQueueEvent;
import com.hanjin.framework.support.jms.event.JmsReceiveQueueHandler;
import com.hanjin.irep.mdm.MDM0010001Document;
import com.hanjin.irep.mdm.MDM0030001Document;
import com.hanjin.irep.mdm.MDM0040001Document;
import com.hanjin.irep.mdm.MDM0050001Document;
import com.hanjin.irep.mdm.MDM0060001Document;
import com.hanjin.irep.mdm.MDM0070001Document;
import com.hanjin.irep.mdm.MDM0090001Document;
import com.hanjin.irep.mdm.MDM0100001Document;
import com.hanjin.irep.mdm.MDM0110001Document;
import com.hanjin.irep.mdm.MDM0120001Document;
import com.hanjin.irep.mdm.MDM0170001Document;
import com.hanjin.irep.mdm.MDM0180001Document;
import com.hanjin.irep.mdm.MDM0190001Document;
import com.hanjin.irep.mdm.MDM0200001Document;
import com.hanjin.irep.mdm.MDM0210001Document;
import com.hanjin.irep.mdm.MDM0220001Document;
import com.hanjin.irep.mdm.MDM0230001Document;
import com.hanjin.irep.mdm.MDM0250001Document;
import com.hanjin.irep.mdm.MDM0270001Document;
import com.hanjin.irep.mdm.MDM0280001Document;
import com.hanjin.irep.mdm.MDM0290001Document;
import com.hanjin.irep.mdm.MDM0310001Document;
import com.hanjin.irep.mdm.MDM0320001Document;
import com.hanjin.irep.mdm.MDM0330001Document;
import com.hanjin.irep.mdm.MDM0340001Document;
import com.hanjin.irep.mdm.MDM0350001Document;
import com.hanjin.irep.mdm.MDM0360001Document;
import com.hanjin.irep.mdm.MDM0370001Document;
import com.hanjin.irep.mdm.MDM0380001Document;
import com.hanjin.irep.mdm.MDM0400001Document;
import com.hanjin.irep.mdm.MDM0410001Document;
import com.hanjin.irep.mdm.MDM0420001Document;
import com.hanjin.irep.mdm.MDM0430001Document;
import com.hanjin.irep.mdm.MDM0440001Document;
import com.hanjin.irep.mdm.MDM0450001Document;
import com.hanjin.irep.mdm.MDM0460001Document;
import com.hanjin.irep.mdm.MDM0470001Document;
import com.hanjin.irep.mdm.MDM0480001Document;
import com.hanjin.irep.mdm.MDM0490001Document;
import com.hanjin.irep.mdm.MDM0500001Document;
import com.hanjin.irep.mdm.MDM0510001Document;
import com.hanjin.irep.mdm.MDM0520001Document;
import com.hanjin.irep.mdm.MDM0530001Document;
import com.hanjin.irep.mdm.MDM0540001Document;
import com.hanjin.irep.mdm.MDM0550001Document;
import com.hanjin.irep.mdm.MDM0560001Document;
import com.hanjin.irep.mdm.MDM0570001Document;
//import com.hanjin.irep.mdm.MDM0580001Document;
import com.hanjin.irep.mdm.MDM0590001Document;
import com.hanjin.irep.mdm.MDM0600001Document;
import com.hanjin.irep.mdm.MDM0610001Document;
import com.hanjin.irep.mdm.MDM0630001Document;
import com.jf.transfer.TransferEAI;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS 서버에서 xml 메세지를 받아 RSC 에 넘겨준다.
 * Event 관리를 한다.
 * [주의]queue-mapping.xml에 메서드가 정의 되어 있어야 한다.
 * @author KJJ
 * @see 
 * @since J2EE 1.4
 */ 
public class ReceiveQueueIJMSProxy {

	protected transient Logger log = Logger
			.getLogger(this.getClass().getName());
	
	/** MDM0020001Document receive
	 *  @param str String
	 */
	public void manageMdmCrmCustomerReject(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();
		JmsReceiveQueueHandler handler = new JmsReceiveQueueHandler(str, RejectMdmCustVO.class);

		try {
			event = new JmsReceiveQueueEvent("manageMdmCrmCustomerReject");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			RejectMdmCustVO vo = (RejectMdmCustVO) handler.getObject();
			/*System.out.println(vo.getSrcSysCd());
			System.out.println(handler.getInstanceId());*/
			((JmsReceiveQueueEvent) event).setObject(vo);
			rsc.perform(event);
			
			eai.commit(handler.getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}

//	=================================1차 분===========================================//
	/** MDM0120001Document receive
	 *  @param str String
	 */
	public void manageMdmCommodity(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmCommodity");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0120001Document mdmDoc = MDM0120001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0120001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}

	/**
	 * MDM0100001Document receive
	 * @param str
	 */
	public void manageMdmGrpCmdt(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmGrpCmdt");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0100001Document mdmDoc = MDM0100001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0100001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0100001Document receive
	 * @param str
	 */
	public void manageMdmRepCmdt(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmRepCmdt");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0110001Document mdmDoc = MDM0110001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0110001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0010001Document 
	 * @param str
	 */
	public void manageMdmCustomer(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmCustomer");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0010001Document mdmDoc = MDM0010001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0010001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0030001Document
	 * @param str
	 */
	public void manageMdmCustAddr(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmCustAddr");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0030001Document mdmDoc = MDM0030001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0030001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0090001Document
	 * @param str
	 */
	public void manageMdmRevLane(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmRevLane");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0090001Document mdmDoc = MDM0090001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0090001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}

	/**
	 * MDM0040001Document
	 * @param str
	 */
	public void manageMdmSlsRep(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmSlsRep");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0040001Document mdmDoc = MDM0040001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0040001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}

	/**
	 * MDM0060001Document
	 * @param str
	 */
	public void manageMdmSubTrd(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmSubTrd");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0060001Document mdmDoc = MDM0060001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0060001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}

	/**
	 * MDM0050001Document
	 * @param str
	 */
	public void manageMdmTrade(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmTrade");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0050001Document mdmDoc = MDM0050001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0050001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}

	//=================================2차 분===========================================//
	/**
	 * MDM0360001Document
	 * @param str
	 */
	public void manageMdmAccount(TransferEAI eai) {
		String str = eai.getMessage();

		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmAccount");
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0360001Document mdmDoc = MDM0360001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();

			eai.commit(mdmDoc.getMDM0360001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}

	/**
	 * MDM0350001Document
	 * @param str
	 */
	public void manageMdmCharge(TransferEAI eai) {
		String str = eai.getMessage();

		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmCharge");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0350001Document mdmDoc = MDM0350001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0350001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}

	/**
	 * MDM0380001Document
	 * @param str
	 */
	public void manageMdmRepChg(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmRepChg");
			log.debug("\n manageMdmRepChg 1 : " );
			FormCommand f = new FormCommand();
			log.debug("\n manageMdmRepChg 2 : " );
			f.setCommand(FormCommand.SEARCH);
			log.debug("\n manageMdmRepChg 3 : " );
			event.setFormCommand(f);
			log.debug("\n manageMdmRepChg 4 : " );
			MDM0380001Document mdmDoc = MDM0380001Document.Factory.parse(str);
			log.debug("\n manageMdmRepChg 5 : " );
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			log.debug("\n manageMdmRepChg 6 : " );
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			log.debug("\n manageMdmRepChg 7 : " );
			eai.commit(mdmDoc.getMDM0380001().getEAIHeader().getInstanceId());
			log.debug("\n manageMdmRepChg 8 : " );
		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0320001Document
	 * @param str
	 */
	public void manageMdmCountry(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmCountry");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0320001Document mdmDoc = MDM0320001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0320001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}

	/**
	 * MDM0340001Document
	 * @param str
	 */
	public void manageMdmCurrency (TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event 			event 	= null;
		ReceiveQueueRSC rsc 	= new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmCurrency");
			log.debug("\n manageMdmCurrency 1 : " );
			FormCommand f = new FormCommand();
			log.debug("\n manageMdmCurrency 2 : " );
			f.setCommand(FormCommand.SEARCH);
			log.debug("\n manageMdmCurrency 3 : " );
			event.setFormCommand(f);
			log.debug("\n manageMdmCurrency 4 : " );

			MDM0340001Document mdmDoc = MDM0340001Document.Factory.parse(str);
			log.debug("\n manageMdmCurrency 5 : " );
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			log.debug("\n manageMdmCurrency 6 : " );
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			log.debug("\n manageMdmCurrency 7 : " );
			
			eai.commit(mdmDoc.getMDM0340001().getEAIHeader().getInstanceId());
			log.debug("\n manageMdmCurrency 8 : " );

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}

	/**
	 * MDM0170001Document
	 * @param str
	 */
	public void manageMdmCrCust(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmCrCust");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0170001Document mdmDoc = MDM0170001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0170001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0630001Document
	 * @param str
	 */
	public void manageMdmCustRep(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmCustRep");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0630001Document mdmDoc = MDM0630001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0630001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0180001Document
	 * @param str
	 */
	public void manageMdmCustPerfGrp(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmCustPerfGrp");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0180001Document mdmDoc = MDM0180001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0180001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0310001Document
	 * @param str
	 */
	public void manageMdmLocation(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmLocation");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0310001Document mdmDoc = MDM0310001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0310001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}

	/**
	 * MDM0270001Document
	 * @param str
	 */
	public void manageMdmOrganization(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmOrganization");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0270001Document mdmDoc = MDM0270001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0270001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0200001Document
	 * @param str
	 */
	public void manageMdmCntrVndrClss(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmCntrVndrClss");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0200001Document mdmDoc = MDM0200001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0200001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0220001Document
	 * @param eai TransferEAI
	 */
	public void manageMdmVndrCntcPnt(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmVndrCntcPnt");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0220001Document mdmDoc = MDM0220001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0220001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0210001Document
	 * @param str
	 */
	public void manageMdmVendorCustomerGeneral(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmVendorCustomerGeneral");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0210001Document mdmDoc = MDM0210001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0210001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0190001Document
	 * @param str
	 */
	public void manageMdmVendor(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmVendor");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0190001Document mdmDoc = MDM0190001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0190001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0250001Document
	 * @param str
	 */
	public void manageMdmVslCntr(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmVslCntr");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0250001Document mdmDoc = MDM0250001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0250001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}

	/**
	 * MDM0070001Document
	 * @param str
	 */
	public void manageMdmVslSvcLaneGeneral(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmVslSvcLaneGeneral");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0070001Document mdmDoc = MDM0070001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0070001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0290001Document
	 * @param str
	 */
	public void manageMdmYard(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmYard");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0290001Document mdmDoc = MDM0290001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0290001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	//===============================================3차 분=========================//
	/**
	 * MDM0480001Document
	 * @param str
	 */
	public void manageMdmActivity(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmActivity");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0480001Document mdmDoc = MDM0480001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0480001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0520001Document
	 * @param str
	 */
	public void manageMdmCntrSz(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmCntrSz");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0520001Document mdmDoc = MDM0520001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0520001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0530001Document
	 * @param str
	 */
	public void manageMdmCntrTp(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmCntrTp");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0530001Document mdmDoc = MDM0530001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0530001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0540001Document
	 * @param str
	 */
	public void manageMdmCntrTySz(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmCntrTySz");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0540001Document mdmDoc = MDM0540001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0540001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0460001Document
	 * @param str
	 */
	public void manageMdmContinent(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmContinent");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0460001Document mdmDoc = MDM0460001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0460001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0370001Document
	 * @param str
	 */
	public void manageMdmEqOrzCht(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmEqOrzCht");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0370001Document mdmDoc = MDM0370001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0370001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0490001Document
	 * @param str
	 */
	public void manageMdmMvmtSts(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmMvmtSts");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0490001Document mdmDoc = MDM0490001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0490001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0430001Document
	 * @param str
	 */
	public void manageMdmCstmsPckTp(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmCstmsPckTp");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0430001Document mdmDoc = MDM0430001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0430001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0440001Document
	 * @param str
	 */
	public void manageMdmPckTp(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmPckTp");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0440001Document mdmDoc = MDM0440001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0440001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0330001Document
	 * @param str
	 */
	public void manageMdmRegion(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmRegion");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0330001Document mdmDoc = MDM0330001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0330001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0400001Document
	 * @param str
	 */
	public void manageMdmSvcScp(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmSvcScp");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0400001Document mdmDoc = MDM0400001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0400001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0410001Document
	 * @param str
	 */
	public void manageMdmSvcScpLane(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmSvcScpLane");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0410001Document mdmDoc = MDM0410001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0410001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0420001Document
	 * @param str
	 */
	public void manageMdmSvcScpLmt(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmSvcScpLmt");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0420001Document mdmDoc = MDM0420001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0420001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0450001Document
	 * @param str
	 */
	public void manageMdmState(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmState");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0450001Document mdmDoc = MDM0450001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0450001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0470001Document
	 * @param str
	 */
	public void manageMdmSubcontinent(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmSubcontinent");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0470001Document mdmDoc = MDM0470001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0470001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0550001Document
	 * @param str
	 */
	public void manageMdmLseCoYd(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmLseCoYd");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0550001Document mdmDoc = MDM0550001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0550001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0500001Document
	 * @param str
	 */
	public void manageMdmZone(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmZone");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0500001Document mdmDoc = MDM0500001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0500001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0510001Document
	 * @param str
	 */
	public void manageMdmZnDtl(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmZnDtl");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0510001Document mdmDoc = MDM0510001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0510001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	//=============================추가분===========================================//
	/**
	 * MDM0560001Document
	 * @param
	 */
	public void manageMdmSvcScpGeneral(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmSvcScpGeneral");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0560001Document mdmDoc = MDM0560001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0560001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0570001Document
	 * @param str
	 */
	public void manageMdmZnGeneral(TransferEAI eai) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmZnGeneral");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0570001Document mdmDoc = MDM0570001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0570001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	

	
	/**
	 * MDM0590001Document
	 * @param str
	 */
	public void manageMdmVendorEtc(TransferEAI eai) {

		log.debug("======================================");		
		log.debug("//--->>>  manageMdmVendorEtc Start");
		log.debug("======================================");
		
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("manageMdmVendorEtc xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmVendorEtc");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0590001Document mdmDoc = MDM0590001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0590001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}
	
	/**
	 * MDM0600001Document
	 * @param str
	 */
	public void manageMdmCarrier(TransferEAI eai) {

		log.debug("======================================");		
		log.debug("//--->>>  manageMdmCarrier Start");
		log.debug("======================================");
		
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("manageMdmCarrier xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmCarrier");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0600001Document mdmDoc = MDM0600001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0600001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}	
	
	/**
	 * MDM0610001Document
	 * @param str
	 */
	public void manageMdmDaylight(TransferEAI eai) {

		log.debug("======================================");		
		log.debug("//--->>>  manageMdmDaylight Start");
		log.debug("======================================");
		
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("manageMdmDaylight xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();

		try {
			event = new ReceiveQueueEvent("manageMdmDaylight");

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			MDM0610001Document mdmDoc = MDM0610001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0610001().getEAIHeader().getInstanceId());

		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}

	/**
	 * MDM0230001Document
	 * @param str
	 */
	public void manageMdmVslBlk(TransferEAI eai) {
	
		log.debug("======================================");		
		log.debug("//--->>>  manageMdmVslBlk Start");
		log.debug("======================================");
		
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("manageMdmVslBlk xml : " + str);
		log.debug("======================================");
		Event event = null;
		ReceiveQueueRSC rsc = new ReceiveQueueRSC();
	
		try {
			event = new ReceiveQueueEvent("manageMdmVslBlk");
	
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);
	
			MDM0230001Document mdmDoc = MDM0230001Document.Factory.parse(str);
			((ReceiveQueueEvent) event).setXmlObject(mdmDoc);
			((ReceiveQueueEventResponse) rsc.perform(event)).getXmlObject();
			
			eai.commit(mdmDoc.getMDM0230001().getEAIHeader().getInstanceId());
	
		} catch (EventException ee) {
			log.error(" EventException e : " + ee.toString());
			eai.rollback(ee);
		} catch (XmlException xe) {
			log.error(" XmlException e : " + xe.toString());
			eai.rollback(xe);
		} catch (Exception e){
			log.error(" Exception e : " + e.toString());
			eai.rollback(e);
		}
		
		eai.close();
	}	
}
