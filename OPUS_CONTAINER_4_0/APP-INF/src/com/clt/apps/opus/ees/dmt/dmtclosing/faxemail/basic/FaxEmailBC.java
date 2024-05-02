/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FaxEmailBC.java
*@FileTitle : DEM/DET Adjustment Request - After Booking Approval
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.faxemail.basic;

import com.clt.apps.opus.ees.dmt.dmtclosing.faxemail.vo.GRWEmailNoticeVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * OPUS-Dmtclosing Business Logic Command Interface<br>
 * @author
 * @see reference DAO of  EES_DMT_3001EventResponse,FaxEmailBC
  * @since J2EE 1.6
 */

public interface FaxEmailBC {
	
	/**
	 * [E-Mail] : []
	 * send email  Approval, Counter Offer, Rejected Before or After Booking data .<br>
	 * 
	 * @param GRWEmailNoticeVO gRWEmailNoticeVO
	 * @exception EventException
	 */
	public void sendGRWEmail(GRWEmailNoticeVO gRWEmailNoticeVO) throws EventException;
	
	/**
	 * search Requester email info. of Approval, Counter Offer, Rejected After Booking data <br>
	 * 
	 * @param String darNo
	 * @return String
	 * @exception EventException
	 */	
	public String searchAfterBookingUserEmailByDARNo(String darNo) throws EventException;
	
	/**
	 * search Requester email info. of Approval, Counter Offer, Rejected Before Booking data<br>
	 * 
	 * @param String darNo
	 * @param String mapgSeq
	 * @param String verNo
	 * @return String
	 * @exception EventException
	 */	
	public String searchBeforeBookingUserEmailByDARNo(String darNo, String mapgSeq, String verNo) throws EventException;	
}