/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TRSInterfaceRSC.java
*@FileTitle : trs 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2010-05-19
*@LastModifier : 김종호
*@LastVersion : 1.17
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
* 2010-05-17 김종호 : searchCustRefPartyManage 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.esd.trs.servicesio.canadacustoms.event.Esd076Hu01Event;
import com.hanjin.apps.alps.esd.trs.servicesio.canadacustomsvessel.event.Esd075Hu01Event;
import com.hanjin.apps.alps.esd.trs.servicesio.custpreference.event.CustPreferenceEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.eursoack.event.EdiEns002Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice210edi.event.Esd999Hu01Event;
import com.hanjin.apps.alps.esd.trs.servicesio.korsoack.event.EdiEns003Event;
import com.hanjin.apps.alps.esd.trs.servicesio.usarailwoack.event.EdiEns001Event;
import com.hanjin.apps.alps.esd.trs.servicesio.usatruckediwoack.event.EdiEns004Event;
import com.hanjin.apps.alps.esd.trs.servicesio.TRSInterfaceRSC;
import com.hanjin.apps.alps.esd.trs.servicesio.custrefparty.event.Esd078Hu01Event;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.cms.CMS0100001Document;
import com.hanjin.irep.enisEsd.ESD0400001Document;
import com.hanjin.irep.enisEsd.ESD0750001Document;
import com.hanjin.irep.enisEsd.ESD0760001Document;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;

/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Sang-Woo
 * @see  각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TRSInterfaceEAIProxy {

    /**
	 * Log
	 */
    protected transient Logger log = Logger.getLogger(this.getClass().getName());

	
	/**
	 * Canada Customs Vessel Manage 관련 정보 
	 * 
	 * @param eai
	 * @throws EventException
	 */
	public void manageCanadaCustomsVesselManage( TransferEAI eai ) throws EventException
	{ 
		String str = eai.getMessage();
		
		log.debug(" ESD0750001 start  : " );
		log.debug(" Xml str  : " + str );
		log.debug(" ESD0750001 end  : " );
		
		Event event = null;
		TRSInterfaceRSC rsc = new TRSInterfaceRSC();
		
		try {

			event = new Esd075Hu01Event();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);			
			event.setFormCommand(f);

			ESD0750001Document doc = ESD0750001Document.Factory.parse(str);		
			((Esd075Hu01Event)event).setXmlObject(doc);
			rsc.perform(event);
			
			eai.commit(doc.getESD0750001().getEAIHeader().getInstanceId());
				

			} catch (EventException e) {
				eai.rollback(e);
				
				log.error("err " + e.toString(), e);
				throw new EventException(e.getMessage());
			} catch (XmlException e1) {
				eai.rollback(e1);
				
				log.error(" XmlException e1 : " + e1.toString() );			
				throw new EventException(e1.getMessage());
			} catch (EAIException e2) {
				eai.rollback(e2);

				log.error(" EAIException e2 : " + e2.toString() );			
				throw new EventException(e2.getMessage());
			} 
		}
	
	/**
	 * Canada Customs Manage 관련 정보 
	 * 
	 * @param eai
	 * @throws EventException
	 */
	public void manageCanadaCustoms( TransferEAI eai ) throws EventException
	{
		String str = eai.getMessage();
		
		log.debug(" ESD0760001 start  : " );
		log.debug(" Xml str  : " + str );
		log.debug(" ESD0760001 end  : " );
		
		Event event = null;
		TRSInterfaceRSC rsc = new TRSInterfaceRSC();
		
		try {

			event = new Esd076Hu01Event();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);			
			event.setFormCommand(f);

			ESD0760001Document doc = ESD0760001Document.Factory.parse(str);		
			((Esd076Hu01Event)event).setXmlObject(doc);
			rsc.perform(event);

			eai.commit(doc.getESD0760001().getEAIHeader().getInstanceId());
				
			} catch (EventException e) {
				eai.rollback(e);
				
				log.error("err " + e.toString(), e);
				throw new EventException(e.getMessage());
			} catch (XmlException e1) {
				eai.rollback(e1);
				
				log.error(" XmlException e1 : " + e1.toString() );			
				throw new EventException(e1.getMessage());
			} catch (EAIException e2) {
				eai.rollback(e2);

				log.error(" EAIException e2 : " + e2.toString() );			
				throw new EventException(e2.getMessage());
			} 
		}
	
	/**
	 * EDI 관련 정보 * 
	 * 
	 * @param eai
	 * @throws EventException
	 */
	public void manageUSARailWoAck( TransferEAI eai ) throws EventException
	{
		String str = eai.getMessage();
		
		log.debug("USA EDI start  : "+str );
		Event event = null;
		TRSInterfaceRSC rsc = new TRSInterfaceRSC();
		
		try {

			event = new EdiEns001Event();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			// 전송 데이터셋에 Object를 assign한다. 
			((EdiEns001Event)event).setString(str);
					
			//EventResponse로 부터 전송 객체의 추출 
			rsc.perform(event);
			
			eai.commit(str.substring(0, 10));
				

			} catch (EventException e) {
				eai.rollback(e);
				
				log.error("err " + e.toString(), e);
				throw new EventException(e.getMessage());
			} catch (EAIException e1) {
				eai.rollback(e1);

				log.error(" EAIException e1 : " + e1.toString() );			
				throw new EventException(e1.getMessage());
			} 
		}
	
	/**
	 * EDI 관련 정보 (Eur S/O  정보)* 
	 * 
	 * @param eai
	 * @throws EventException
	 */
	public void manageEurSoAckManage( TransferEAI eai ) throws EventException
	{ 
		String str = eai.getMessage();
		
		log.debug("EUR EDI start  : "+str );
		Event event = null;
		TRSInterfaceRSC rsc = new TRSInterfaceRSC();
		
		try {

			event = new EdiEns002Event();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			// 전송 데이터셋에 Object를 assign한다. 
			((EdiEns002Event)event).setString(str);
					
			//EventResponse로 부터 전송 객체의 추출 
			rsc.perform(event);
			
			eai.commit(str.substring(0, 10));
				
			} catch (EventException e) {
				eai.rollback(e);
				
				log.error("err " + e.toString(), e);
				throw new EventException(e.getMessage());
			} catch (EAIException e1) {
				eai.rollback(e1);

				log.error(" EAIException e1 : " + e1.toString() );			
				throw new EventException(e1.getMessage());
			} 
		}
	
	/**
	 * EDI 관련 정보 (Kor S/O  정보)* 
	 * 
	 * @param eai
	 * @throws EventException
	 */
	public void manageKorSoAckManage( TransferEAI eai ) throws EventException
	{ 
		String str = eai.getMessage();
		
		log.debug("KOR EDI start  : "+str );
		Event event = null;
		TRSInterfaceRSC rsc = new TRSInterfaceRSC();
		
		try {

			event = new EdiEns003Event();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			// 전송 데이터셋에 Object를 assign한다. 
			((EdiEns003Event)event).setString(str);
					
			//EventResponse로 부터 전송 객체의 추출 
			rsc.perform(event);
			
			eai.commit(str.substring(0, 10));
				

			} catch (EventException e) {
				eai.rollback(e);
				
				log.error("err " + e.toString(), e);
				throw new EventException(e.getMessage());
			} catch (EAIException e1) {
				eai.rollback(e1);

				log.error(" EAIException e1 : " + e1.toString() );			
				throw new EventException(e1.getMessage());
			} 
		}
	
	/**
	 * EDI 관련 정보 * 
	 * 
	 * @param eai
	 * @throws EventException
	 */
	public void manageUSATruckEdiWoAck( TransferEAI eai ) throws EventException
	{ 
		String str = eai.getMessage();
		
		log.debug("USA TRUCK EDI start  : "+str );
		Event event = null;
		TRSInterfaceRSC rsc = new TRSInterfaceRSC();
		
		try {

			event = new EdiEns004Event();
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			event.setFormCommand(f);

			// 전송 데이터셋에 Object를 assign한다. 
			((EdiEns004Event)event).setString(str);
					
			//EventResponse로 부터 전송 객체의 추출 
			rsc.perform(event);
			
			eai.commit(str.substring(0, 10));
				
			} catch (EventException e) {
				eai.rollback(e);
				
				log.error("err " + e.toString(), e);
				throw new EventException(e.getMessage());
			} catch (EAIException e1) {
				eai.rollback(e1);

				log.error(" EAIException e1 : " + e1.toString() );	
				throw new EventException(e1.getMessage());
			} 
		}

	/**
	 * TRANSPORTATION TRUCK INVOICE EDI 정보 
	 * 
	 * @param eai
	 * @throws EventException
	 */
	public void manageTRSTruckInvoice( TransferEAI eai ) throws EventException
	{ 
		String str = eai.getMessage();
		
		log.error(" ESD9990001 start : " );
		log.error(" Xml str  : " + str );
		log.error(" ESD9990001 end  : " );
		
		Event event = null;
		TRSInterfaceRSC rsc = new TRSInterfaceRSC();

		try {

			event = new Esd999Hu01Event();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);			
			event.setFormCommand(f);

			// 전송 데이터셋에 Object를 assign한다. 	
			((Esd999Hu01Event)event).setString(str);		
			// EventResponse로 부터 전송 객체의 추출 
			rsc.perform(event);

			//eai.commit(doc.getESD9990001().getEAIHeader().getInstanceId());
			eai.commit(str.substring(0, 10));

			} catch (EventException e) {
				eai.rollback(e);
				log.error("err " + e.toString(), e);
				throw new EventException(e.getMessage());
			} catch (EAIException e1) {
				eai.rollback(e1);
				log.error(" EAIException e : " + e1.toString() );			
				throw new EventException(e1.getMessage());
			} 
		}
	
	/**
	 * CustPreference Receving Data 처리<br>
	 * @param eai TransferEAI
	 */
	public void manageCustPreference( TransferEAI eai ) {
		String str = eai.getMessage();
		
		log.debug("======================================");		
		log.debug("xml : " + str);
		log.debug("======================================");
		Event event = null;
		TRSInterfaceRSC rsc = new TRSInterfaceRSC();

		try {
			event = new CustPreferenceEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);

			ESD0400001Document doc = ESD0400001Document.Factory.parse(str);
			((CustPreferenceEvent) event).setXmlObject(doc);
			
			String isSuccessful = ((GeneralEventResponse)rsc.perform(event)).getUserMessage();

	    	log.debug("\n --------------------------------------------------------- " +
	  		          "\n           CustPreferenceIJMSProxy   result :" +isSuccessful +
	  			      "\n --------------------------------------------------------- ");
	    	

	    	eai.commit(doc.getESD0400001().getEAIHeader().getInstanceId());
			
		} catch (EventException e) {
			eai.rollback(e);
			log.error(" EventException e : " + e.toString());
		} catch (XmlException e) {
			eai.rollback(e);
			log.error(" XmlException e : " + e.toString());
		} catch (EAIException e) {
			eai.rollback(e);
			log.error(" EAIException e : " + e.toString());
		}

		eai.close();
	}
	
	/**
	 * crm referency party 정보 
	 * 
	 * @param eai
	 * @throws EventException
	 */
	public void manageCustRefParty( TransferEAI eai ) throws EventException
	{ 
//		 2007. 05. 01. Hyunsu modified 
		String str = eai.getMessage();
		
		log.debug(" CMS0100001 start  : " );
		log.debug(" Xml str  : " + str );
		log.debug(" CMS0100001 end  : " );

//		XmlObject xmlData = null;	
		Event event = null;
		TRSInterfaceRSC rsc = new TRSInterfaceRSC();
		
		try {

			event = new Esd078Hu01Event();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);			
			event.setFormCommand(f);
			CMS0100001Document doc = CMS0100001Document.Factory.parse(str);	
			//ESD0780001Document doc = ESD0780001Document.Factory.parse(str);		
			((Esd078Hu01Event)event).setXmlObject(doc);
			String isSuccessful = ((GeneralEventResponse)rsc.perform(event)).getUserMessage();
			
	    	log.debug("\n --------------------------------------------------------- " +
	  		          "\n              result :" +isSuccessful +
	  			      "\n --------------------------------------------------------- ");

			
//			 2007. 05. 01. Hyunsu modified 
			eai.commit(doc.getCMS0100001().getEAIHeader().getInstanceId());
				

			} catch (EventException e) {
//				 2007. 05. 01. Hyunsu modified
				eai.rollback(e);
				
				log.error("err " + e.toString(), e);
				throw new EventException(e.getMessage());
				//log.error(e.getMessage(), e);
				//e.printStackTrace();
			} catch (XmlException e1) {
//				 2007. 05. 01. Hyunsu modified
				eai.rollback(e1);
				
				log.error(" XmlException e1 : " + e1.toString() );			
				throw new EventException(e1.getMessage());
			} catch (EAIException e2) {
//				 2007. 05. 01. Hyunsu modified
				eai.rollback(e2);

				log.error(" EAIException e2 : " + e2.toString() );			
				throw new EventException(e2.getMessage());
			} 
		}
	
	
}