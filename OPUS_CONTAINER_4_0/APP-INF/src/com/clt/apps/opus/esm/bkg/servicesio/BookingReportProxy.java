/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingReportProxy.java
 *@FileTitle : Receive WebLogic JMS Queue Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-08-23
 *@LastModifier : Kim Minjeong
 *@LastVersion : 1.0
 * 2010-08-23
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.bkg.servicesio;

import org.apache.log4j.Logger;

import com.clt.apps.opus.esm.bkg.bookingreport.BookingReportSC;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkgChnEdiReceiveEvent;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.jf.transfer.TransferEAI;

/**
 * BookingReportProxy.java
 * 
 * @author Kim Minjeong
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class BookingReportProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * JMS Receive(UDEVCOM_OPUSBKG_T_NACCS)<br>
	 * 
	 * @param eai TransferEAI
	 * @exception EventException, XmlException, Exception
	 */
	public void chnEdiReceiveMQ(TransferEAI eai) throws DAOException {
		log.info("<<<<<<<<<< chnEdiReceiveMQ Start >>>>>>>>>>>>>>>>");
		log.info("================================");
		log.info(eai.getMessage());
		log.info("================================");
		
		try
		{
			// 이벤트 세팅
			EsmBkgChnEdiReceiveEvent event = new EsmBkgChnEdiReceiveEvent();
			event.setRcvMsg(eai.getMessage());
			
			// SC 호출
			BookingReportSC bkgRepSC = new BookingReportSC();
			bkgRepSC.perform(event);
		}
		catch (Exception e)
		{
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		finally
		{
			eai.close();
			log.info("<<<<<<<<<< chnEdiReceiveMQ End >>>>>>>>>>>>>>>>");
		}
	}
}
