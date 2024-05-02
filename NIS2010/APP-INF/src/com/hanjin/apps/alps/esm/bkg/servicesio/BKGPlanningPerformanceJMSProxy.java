/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BKGPlanningPerformanceJMSProxy.java
 *@FileTitle : Receive WebLogic JMS Queue Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-10-19
 *@LastModifier : 이일민
 *@LastVersion : 1.0
 * 2009-10-06
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.BookingMasterDataSC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.Cms0070001Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

/**
 * It's BKGPlanningPerformanceJMSProxy.java
 * 
 * @author 이일민
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class BKGPlanningPerformanceJMSProxy {
	
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * BKG_EDI_TRD_PRNR_SUB_LNK 연동을 처리합니다.
	 * 
	 * @param TransferEAI eai
	 * @exception DAOException
	 */
	public void customerSalesRep(TransferEAI eai) throws DAOException, Exception {
		log.info("<<<<<<<<<< Customer Sales Rep Start >>>>>>>>>>>>>>>>");		
		
		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");
		
		Event event = null;
		BookingMasterDataSC bookingMasterDataSC = new BookingMasterDataSC();		
		try {
			event = new Cms0070001Event();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			
			((Cms0070001Event) event).setMessage(str);
			bookingMasterDataSC.perform(event);
			
			log.info("<<<<<<<<<< Customer Sales Rep End >>>>>>>>>>>>>>>>");
			
		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
	         throw new EventException(new ErrorHandler(ee).getMessage(), ee);
		} catch (Exception e){
			log.error("Exception e : " + e.toString());
			eai.rollback(e);
	         throw new EventException(new ErrorHandler(e).getMessage(), e);
		}
		
		eai.close();
	}
}
