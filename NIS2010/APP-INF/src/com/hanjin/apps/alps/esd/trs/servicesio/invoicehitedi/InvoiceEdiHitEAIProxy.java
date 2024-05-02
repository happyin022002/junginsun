/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceEdiHitEAIProxy.java
*@FileTitle : HIT INVOICE EDI RECEIVE, PDF FILE ATTACH  & ACK 
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-24
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2016-06-24 SHIN DONG IL
* 1.0 최초생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.event.RcvInvEdiHitEvent;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

/**
 * Business Logic Basic Command implementation<br>
 * @author SHIN DONG IL
 * @see  각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class InvoiceEdiHitEAIProxy {

    /**
	 * Log
	 */
    protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * INVOICE EDI RECEIVE FOR HIT(HONGKONG INTERNATIONAL TERMINAL)  
	 * 
	 * @param eai
	 * @throws EventException
	 */
	public void receiveInvoiceEdi(TransferEAI eai) throws EventException{ 
		String str = eai.getMessage();
		Event event = null;	
		InvoiceEdiHitRSC rsc = new InvoiceEdiHitRSC();
		log.error("\n\n >>>>>>>>>>>>> InvoiceEdiHitEAIProxy.receiveInvoiceEdi(TransferEAI eai) Start "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"<<<<<<<<<< \n\n");
		try {

			event = new RcvInvEdiHitEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);			
			event.setFormCommand(f);

			// 전송 데이터셋에 Object를 assign한다. 	
			((RcvInvEdiHitEvent)event).setString(str);		
			// EventResponse로 부터 전송 객체의 추출 
			rsc.perform(event);
			log.error("\n\n >>>>>>>>>>>>> InvoiceEdiHitEAIProxy.receiveInvoiceEdi(TransferEAI eai) End <<<<<<<<<< \n\n");
		} catch (EventException e) {
			eai.rollback(e);
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		} catch (Exception e) {
			log.error("\n  ###### receiveInvoiceEdi() Exception- "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			log.error(e.getMessage());
			throw new EventException(e.getMessage());		
		} finally {
			eai.close();
		}
		log.error("\n ## DONE - InvoiceEdiHitEAIProxy.receiveInvoiceEdi:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+
				  "\n ################################################################################################################################ \n\n\n\n\n\n");	

	}
	/**
	 * INVOICE EDI RECEIVE FOR HIT(HONGKONG INTERNATIONAL TERMINAL) PDF FILE 수신
	 * 
	 * @param eai
	 * @throws EventException
	 */
	public void receiveInvoiceEdiPdfFile(TransferEAI eai) throws EventException{ 
		log.debug("\n\n >>>>>>>>>>>>> InvoiceEdiHitEAIProxy.receiveInvoiceEdiPdfFile Start "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+" <<<<<<<<<< \n\n");
		Event event = null;	
		InvoiceEdiHitRSC rsc = new InvoiceEdiHitRSC();
		byte[] fileBuf = null;
		String fileNm = "";

		try {

			event = new RcvInvEdiHitEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI01);
			fileBuf = eai.getByteMessage();
			log.debug("\n >>>>>>>>>>>>> receiveInvoiceEdiPdfFile() fileBuf Size:"+ fileBuf.length +"<<<<<<<<<<");
			
			fileNm = eai!=null?eai.getUsrHeaderMsg("PDFFileName"):"";
			log.debug("\n >>>>>>>>>>>>> receiveInvoiceEdiPdfFile() fileNm :"+fileNm+"<<<<<<<<<<");
			event.setFormCommand(f);
			// 전송 데이터셋에 Object를 assign한다.
			((RcvInvEdiHitEvent)event).setFileBuf(fileBuf);
			((RcvInvEdiHitEvent)event).setFileNm(fileNm);
			// EventResponse로 부터 전송 객체의 추출 
			rsc.perform(event);
			log.debug("\n >>>>>>>>>>>>> InvoiceEdiHitEAIProxy.receiveInvoiceEdiPdfFile End <<<<<<<<<<");
		} catch (EventException e) {
			eai.rollback(e);
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		} catch (Exception e) {
			log.error("\n  ###### InvoiceEdiHitEAIProxy.receiveInvoiceEdiPdfFile Exception e - "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
			log.error(e.getMessage());
			throw new EventException(e.getMessage());		
		}// finally {
		
		eai.close();
//		}
		log.error("\n ## DONE - InvoiceEdiHitEAIProxy.receiveInvoiceEdiPdfFile:"+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+
				  "\n ################################################################################################################################ \n\n\n\n\n\n");	
	}
}