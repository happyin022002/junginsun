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
=========================================================*/
package com.clt.apps.opus.esm.bkg.servicesio;

import java.io.ByteArrayInputStream;

import org.apache.log4j.Logger;

import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.EBookingConductSC;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkgEBkgReceiptEvent;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.controller.html.FormCommand;
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

//main 으로 수행시 sc의 begin,commit,rollback 제거하고 수행
//	public static void main(String[] args) throws Exception {
//		EBookingConductSC eBookingConductSC = null;
//	    Event event = null;
//    	FormCommand f = null;
//    	String fileName = null;
//    	InputStream bis = null;
//    	byte[] byteArray = null;
//		try {
//	    	eBookingConductSC = new EBookingConductSC();
//	    	event = new EsmBkgEBkgReceiptEvent();
////			fileName = "C:\\Users\\9010653.CLT\\Desktop\\SimpleEDI\\20101227_Simple_EDI_New_Format_data.xls";
//			fileName = "C:\\Users\\9010653.CLT\\Desktop\\SimpleEDI\\SGN032494600_V2.xls";
//			bis = new BufferedInputStream(new FileInputStream(fileName));
//			byteArray = new byte[bis.available()]; 
//			bis.read(byteArray);
//	    	f = new FormCommand();
//			f.setCommand(FormCommand.MULTI);
//			event.setFormCommand(f);
//	    	((EsmBkgEBkgReceiptEvent)event).setRcvXls(new ByteArrayInputStream(byteArray));
//	    	System.setProperty("java.naming.factory.initial","weblogic.jndi.WLInitialContextFactory");
//	    	eBookingConductSC.perform(event);
//		} catch (EventException ee) {
//			ee.printStackTrace();
//			throw new Exception(new ErrorHandler(ee).getMessage());
//	 	} catch (Exception e) {
//			e.printStackTrace();
//	 		throw new Exception(new ErrorHandler(e).getMessage());
//	 	}
//    }

}
