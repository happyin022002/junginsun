/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingMasterDataJMSProxy.java
 *@FileTitle : Receive WebLogic JMS Queue Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-10-19
 *@LastModifier : 이일민
 *@LastVersion : 1.0
 * 2009-10-06
 * 1.0 최초 생성
 * ------------------------------------------------------
 * 2010.11.30 김영철 [] R4J - Catch 구분의 Throw 문자 사용점검.
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.BookingMasterDataSC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.Edi0050001Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.Edi0060001Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.Edi0070001Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

/**
 * It's BookingMasterDataJMSProxy.java
 * 
 * @author 이일민
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class BookingMasterDataJMSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * BKG_EDI_TRD_PRNR_SUB_LNK 연동을 처리합니다.
	 * 
	 * @param TransferEAI eai
	 * @exception DAOException
	 */
	public void receiveBkgEdiTrdPrnrSubLnk(TransferEAI eai) throws DAOException, Exception {
		log.info("<<<<<<<<<< BookingMasterDataJMSProxy(receiveBkgEdiTrdPrnrSubLnk) Start >>>>>>>>>>>>>>>>");		
		String str = null;
		Event event = null;
		BookingMasterDataSC bookingMasterDataSC = null;
		FormCommand f = null;
		try {
			str = eai.getMessage();
			log.info("======================================");
			log.info("xml : " + str);
			log.info("======================================");
			event = new Edi0050001Event();
			bookingMasterDataSC = new BookingMasterDataSC();		
			f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			((Edi0050001Event)event).setMessage(str);
			bookingMasterDataSC.perform(event);
			log.info("<<<<<<<<<< BookingMasterDataJMSProxy(receiveBkgEdiTrdPrnrSubLnk) End >>>>>>>>>>>>>>>>");
		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
			throw new EventException(new ErrorHandler(ee).getMessage(), ee);
		} catch (Exception e) {
			log.error("Exception e : " + e.toString());
			eai.rollback(e);
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		}
		eai.close();
	}

	/**
	 * BKG_EDI_SUB_LNK_MSG 연동을 처리합니다.
	 * 
	 * @param TransferEAI eai
	 * @exception DAOException
	 */
	public void receiveBkgEdiSubLnkMsg(TransferEAI eai) throws DAOException, Exception {
		log.info("<<<<<<<<<< BookingMasterDataJMSProxy(receiveBkgEdiSubLnkMsg) Start >>>>>>>>>>>>>>>>");		
		String str = null;
		Event event = null;
		BookingMasterDataSC bookingMasterDataSC = null;
		FormCommand f = null;
		try {
			str = eai.getMessage();
			log.info("======================================");
			log.info("xml : " + str);
			log.info("======================================");
			event = new Edi0060001Event();
			bookingMasterDataSC = new BookingMasterDataSC();		
			f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			((Edi0060001Event)event).setMessage(str);
			bookingMasterDataSC.perform(event);
			log.info("<<<<<<<<<< BookingMasterDataJMSProxy(receiveBkgEdiSubLnkMsg) End >>>>>>>>>>>>>>>>");
		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
			throw new EventException(new ErrorHandler(ee).getMessage(), ee);
		} catch (Exception e) {
			log.error("Exception e : " + e.toString());
			eai.rollback(e);
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		}
		eai.close();
	}

	/**
	 * BKG_EDI_PRNR_PORT_LANE 연동을 처리합니다.
	 * 
	 * @param TransferEAI eai
	 * @exception DAOException
	 */
	public void receiveBkgEdiPrnrPortLane(TransferEAI eai) throws DAOException, Exception {
		log.info("<<<<<<<<<< BookingMasterDataJMSProxy(receiveBkgEdiPrnrPortLane) Start >>>>>>>>>>>>>>>>");		
		String str = null;
		Event event = null;
		BookingMasterDataSC bookingMasterDataSC = null;
		FormCommand f = null;
		try {
			str = eai.getMessage();
			log.info("======================================");
			log.info("xml : " + str);
			log.info("======================================");
			event = new Edi0070001Event();
			bookingMasterDataSC = new BookingMasterDataSC();		
			f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			((Edi0070001Event)event).setMessage(str);
			bookingMasterDataSC.perform(event);
			log.info("<<<<<<<<<< BookingMasterDataJMSProxy(receiveBkgEdiPrnrPortLane) End >>>>>>>>>>>>>>>>");
		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
			throw new EventException(new ErrorHandler(ee).getMessage(), ee);
		} catch (Exception e) {
			log.error("Exception e : " + e.toString());
			eai.rollback(e);
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		}
		eai.close();
	}

}
