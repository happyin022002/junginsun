/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FaxEmailBC.java
*@FileTitle : DEM/DET Adjustment Request - After Booking Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.09.21 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo.GRWEmailChgDeltNoticeVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo.GRWEmailNoticeBasicCmdtVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo.GRWEmailNoticeVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo.GRWEmailSalesRepVO;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * NIS2010-Dmtclosing Business Logic Command Interface<br>
 * - NIS2010-Dmtclosing에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SungHoon, Lee 
 * @see Ees_dmt_2009EventResponse 참조
 * @since J2EE 1.6
 */

public interface FaxEmailBC {
	
	/**
	 * [E-Mail] : []
	 * [Approval, Counter Offer, Reject 된 Before 나 After Booking] 을 [Email Send] 합니다.<br>
	 * 
	 * @param GRWEmailNoticeVO gRWEmailNoticeVO
	 * @exception EventException
	 */
	public void sendGRWEmail(GRWEmailNoticeVO gRWEmailNoticeVO) throws EventException;
	
	/**
	 * [Approval, Counter Offer, Reject 된 After Booking 요청자의] Email 정보를 [조회] 합니다.<br>
	 * 
	 * @param String darNo
	 * @return String
	 * @exception EventException
	 */	
	public String searchAfterBookingUserEmailByDARNo(String darNo) throws EventException;
	
	/**
	 * [Approval, Counter Offer, Reject 된 Before Booking 요청자의] Email 정보를 [조회] 합니다.<br>
	 * 
	 * @param String darNo
	 * @param String mapgSeq
	 * @param String verNo
	 * @return String
	 * @exception EventException
	 */	
	public String searchBeforeBookingUserEmailByDARNo(String darNo, String mapgSeq, String verNo) throws EventException;
	
    /**
     * [Invoice Cancel Info]을 [Email Send] 합니다.<br>
     * 
     * @param String receiver
     * @param String sender
     * @param String content
     * @return String
     * @throws EventException 
     * @exception EventException
     */
    public String sendEmailforCancelInvoice(String receiver, String sender, String content) throws EventException;	
    

	/**
	 * [E-Mail] : []
	 * [Basic Tariff, Commodity Exception] 을 [Email Send] 합니다.<br>
	 * 
	 * @param GRWEmailNoticeBasicCmdtVO gRWEmailNoticeBasicCmdtVO 
	 * @param List<GRWEmailNoticeBasicCmdtVO> noticeXmlVOs
	 * @exception EventException
	 */
	public void sendGRWEmailBasicCmdt(GRWEmailNoticeBasicCmdtVO gRWEmailNoticeBasicCmdtVO, List<GRWEmailNoticeBasicCmdtVO> noticeXmlVOs) throws EventException;
    
	/**
	 * [Charge Deletion 요청에 대해 Approval, Reject 처리시 하위 Office 결재자들에게 Notice] 를 [Email Send] 합니다.<br>
	 * 
	 * @param GRWEmailChgDeltNoticeVO gRWEmailChgDeltNoticeVO
	 * @return String
	 * @throws MailerAppException
	 */	
	public String sendChgDeltNoticeGWMail(GRWEmailChgDeltNoticeVO gRWEmailChgDeltNoticeVO) throws EventException;    

	/**
	 * [E-Mail] : Sales Rep. Email Send 합니다.<br>
	 * 
	 * @param GRWEmailNoticeVO gRWEmailNoticeVO
	 * @param List<GRWEmailSalesRepVO> salesRepList
	 * @exception EventException
	 */
	public void sendEmailSalesRep(GRWEmailNoticeVO gRWEmailNoticeVO, List<GRWEmailSalesRepVO> salesRepList) throws EventException;    
}