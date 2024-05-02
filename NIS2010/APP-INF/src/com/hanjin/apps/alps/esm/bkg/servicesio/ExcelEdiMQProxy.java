/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ExcelEdiMQProxy.java
 *@FileTitle : Receive WebLogic JMS Queue Proxy by EXCEL
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-12-30
 *@LastModifier : 이일민
 *@LastVersion : 1.0
 * 2010-12-30 
 * 1.0 Creation
 * ------------------------------------------------------
 * HISTORY
 * 2010.12.30 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청
 * 2010.12.31 이일민 [] R4J 관련 주석 추가
 * 2011.05.16 이일민 Simple EDI 오류메일 전송
 * 2011.05.17 이일민 Simple EDI 오류메일 전송(sendErrLogMailBySimpleEDI 검색) - 원복
 * 2011.07.05 이일민 Simple EDI 오류메일 전송 라이브 적용
 * 2014.10.29 최도순 [CHM-201432429] SIMPLE BKG FAILURE MESSAGE 수정 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio;

import java.io.ByteArrayInputStream;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.EBookingConductSC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkgEBkgReceiptEvent;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

/**
 * It's ExcelEdiMQProxy.java
 * 
 * @author 
 * @see
 * @since J2EE 1.6 Dec 30, 2010
 */
public class ExcelEdiMQProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * JMS Receive(excel)<br>
	 * 
	 * @param eai TransferEAI
	 * @exception EventException
	 */
	public void receiptXterRqst(TransferEAI eai) throws EventException {
		EBookingConductSC eBookingConductSC = null;
		Event event = null;
		FormCommand f = null;
		try {
			eBookingConductSC = new EBookingConductSC();
	    	event = new EsmBkgEBkgReceiptEvent();
	    	f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
	    	((EsmBkgEBkgReceiptEvent)event).setRcvXls(new ByteArrayInputStream(eai.getByteMessage()));
	    	event.setAttribute("emailAddr", eai.getUsrHeaderMsg("FromEmailAddress"));  //리턴 메일주소
	    	event.setAttribute("emailSubject", eai.getUsrHeaderMsg("EmailSubject"));  //메일제목
	    	//event.setAttribute("fileName", eai.getUsrHeaderMsg("FileName"));  //파일명
	    	
	    	
	    	log.debug("FromEmailAddress===================="+eai.getUsrHeaderMsg("FromEmailAddress"));
	    	log.debug("EmailSubject==================="+eai.getUsrHeaderMsg("EmailSubject"));
	    	//log.debug( "FileName====================="+ eai.getUsrHeaderMsg("FileName"));
	    	
	    	eBookingConductSC.perform(event);
		} catch (EventException e) {
			eai.rollback(e);
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			eai.rollback(e);
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		}
		eai.close();
	}

/*	public static void main(String[] args) throws Exception {
		EBookingConductSC eBookingConductSC = null;
	    Event event = null;
    	FormCommand f = null;
    	String fileName = null;
    	InputStream bis = null;
    	byte[] byteArray = null;
		try {
	    	System.setProperty("java.naming.factory.initial","weblogic.jndi.WLInitialContextFactory");
	    	System.setProperty("java.naming.factory.url.pkgs","weblogic.jndi.factories:weblogic.corba.j2ee.naming.url:weblogic.jndi.factories:weblogic.corba.j2ee.naming.url");
	    	System.setProperty("java.naming.provider.url","t3://localhost:7001");
	    	System.setProperty("java.naming.security.principal","weblogic");
	    	System.setProperty("java.naming.security.credentials","weblogic");
	    	eBookingConductSC = new EBookingConductSC();
	    	event = new EsmBkgEBkgReceiptEvent();
			fileName = "D:\\ALPS\\E-BKG\\sample 7.xlsx";
			bis = new BufferedInputStream(new FileInputStream(fileName));
			byteArray = new byte[bis.available()]; 
			bis.read(byteArray);
	    	f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
	    	((EsmBkgEBkgReceiptEvent)event).setRcvXls(new ByteArrayInputStream(byteArray));
	    	event.setAttribute("emailAddr", "dosoonchoi@cyberlogitec.com");  //리턴 메일주소
	    	eBookingConductSC.perform(event);
		} catch (EventException ee) {
			throw new EventException(new ErrorHandler(ee).getMessage(), ee);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler(e).getMessage(), e);
	 	}
    }
*/
}
