/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonFaxEmailBC.java
*@FileTitle : Fax Email Send
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.11.04 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.basic;

import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComFaxSndInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComRDFaxEmailSendInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.FAXEmailByPayerVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Invoicemgt Business Logic Command Interface<br>
 * - ALPS-Invoicemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Mun Jung Cheol
 * @see DmtComFaxEmailEventResponse 참조
 * @since J2EE 1.6
 */

public interface CommonFaxEmailBC {
    /**
    * [Invoice Info]을 [Fax Send] 합니다.<br>
    * 
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param DmtComFaxSndInfoVO dmtComFaxSndInfoVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String sendFaxInvoice( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO , SignOnUserAccount account ) throws EventException;
    
    /**
    * [Invoice Info]을 [Email Send] 합니다.<br>
    * 
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param DmtComFaxSndInfoVO dmtComFaxSndInfoVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String sendEmailInvoice( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO , SignOnUserAccount account ) throws EventException;
    
    /**
    * [Fax Email Send Info]을 [Logging] 합니다.<br>
    * 
    * @param String returnKey
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param DmtComFaxSndInfoVO dmtComFaxSndInfoVO
    * @param SignOnUserAccount account
    * @exception EventException
    */
    public void insertDmtFaxEmlSndHistory( String returnKey , DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO , SignOnUserAccount account ) throws EventException;
    
    /**
    * [Invoice Info]을 [Email Send] 합니다.<br>
    * 
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String sendReportDesignerWithFiles( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , SignOnUserAccount account ) throws EventException;
  
    /**
     * Sender Email을 조회합니다.<br>
     * 
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */    
     
    public String searchSenderEmailByUser( SignOnUserAccount account ) throws EventException ;

    /**
     * Payer Email을 조회합니다.<br>
     * 
     * @param FAXEmailByPayerVO faxEmailByPayerVO
     * @return String
     * @exception EventException
     */    
	public String searchEmailByPayer(FAXEmailByPayerVO faxEmailByPayerVO) throws EventException ;
	
    /**
    * [Invoice Info]을 [Email Send] 합니다.<br>
    * 
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param String usrID
    * @param String sndCntrListFlg
    * @param String sndInvFlg
    * @return String
    * @exception EventException
    */
    public String sendReportDesignerWithBatchFiles( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , String usrID, String sndCntrListFlg, String sndInvFlg  ) throws EventException;
  
    
}
