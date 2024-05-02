/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtBCImpl.java
*@FileTitle : DEM/DET Adjustment Request - After Booking Approval
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.faxemail.basic;

import com.clt.apps.opus.ees.dmt.dmtclosing.faxemail.integration.FaxEmailDBDAO;
import com.clt.apps.opus.ees.dmt.dmtclosing.faxemail.integration.FaxEmailEAIDAO;
import com.clt.apps.opus.ees.dmt.dmtclosing.faxemail.vo.GRWEmailNoticeVO;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-DMTClosing Business Logic Basic Command implementation<br>
 * @author
 * @see reference DAO of  EES_DMT_3001EventResponse,FaxEmailBC
 * @since J2EE 1.6
 */

public class FaxEmailBCImpl extends BasicCommandSupport implements FaxEmailBC {
	
	// Database Access Object
	private transient FaxEmailDBDAO 	faxEmailDBDAO 	= null;
	private transient FaxEmailEAIDAO 	faxEmailEAIDAO 	= null;
	
	/**
	 * FaxEmailBCImpl create object<br>
	 * create faxEmailDBDAO <br>
	 * create faxEmailEAIDAO<br>
	 */
	public FaxEmailBCImpl() {
		faxEmailDBDAO 	= new FaxEmailDBDAO();
		faxEmailEAIDAO 	= new FaxEmailEAIDAO();
	}
	
	/**
	 * [E-Mail] : []
	 * send email  Approval, Counter Offer, Rejected Before or After Booking data<br>
	 * 
	 * @param GRWEmailNoticeVO gRWEmailNoticeVO
	 * @exception EventException
	 */
	public void sendGRWEmail(GRWEmailNoticeVO gRWEmailNoticeVO) throws EventException {
		try {
			faxEmailEAIDAO.sendGRWMail(gRWEmailNoticeVO);
		}
		catch(MailerAppException e) {
			throw new EventException("DMT02036");
		}
	}
	
	/**
	 * search Requester email info. of Approval, Counter Offer, Rejected After Booking data<br>
	 * 
	 * @param String darNo
	 * @return String
	 * @exception EventException
	 */	
	public String searchAfterBookingUserEmailByDARNo(String darNo) throws EventException {
		try {
			return faxEmailDBDAO.searchAfterBookingUserEmailByDARNo(darNo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * search Requester email info. of Approval, Counter Offer, Rejected Before Booking data<br>
	 * 
	 * @param String darNo
	 * @param String mapgSeq
	 * @param String verNo
	 * @return String
	 * @exception EventException
	 */	
	public String searchBeforeBookingUserEmailByDARNo(String darNo, String mapgSeq, String verNo) throws EventException {
		try {
			return faxEmailDBDAO.searchBeforeBookingUserEmailByDARNo(darNo, mapgSeq, verNo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
}
