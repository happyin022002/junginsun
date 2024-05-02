/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonFaxEmailBC.java
*@FileTitle : Fax Email Send
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.basic;

import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComFaxSndInfoVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComRDFaxEmailSendInfoVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Invoicemgt Business Logic Command Interface<br>
 *
 * @author 
 * @see reference  DmtComFaxEmailEventResponse
 * @since J2EE 1.6
 */

public interface CommonFaxEmailBC {
    /**
    * Invoice Info Send Fax.<br>
    * 
    * @param dmtComRDFaxEmailSendInfoVO DmtComRDFaxEmailSendInfoVO
    * @param dmtComFaxSndInfoVO DmtComFaxSndInfoVO
    * @return String
    * @exception EventException
    */
    public String sendFaxInvoice( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO) throws EventException;
    
    /**
    * Invoice Info Send Email<br>
    * 
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param DmtComFaxSndInfoVO dmtComFaxSndInfoVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String sendEmailInvoice( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO , SignOnUserAccount account ) throws EventException;

    
    /**
    * [Invoice Info Digital Sign FTP].<br>
    * 
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param DmtComFaxSndInfoVO dmtComFaxSndInfoVO
    * @param SignOnUserAccount account
    * @return String
    * @throws EventException 
    * @exception EventException
    */
    public String sendDigitalSignInvoiceByFTP( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO , SignOnUserAccount account ) throws EventException;

    /**
    * [Login Office of country Code]<br>
    * 
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String searchCountryCodeByOfcCd(SignOnUserAccount account ) throws EventException;
    
    /**
    * Logging Fax Email Send Info.<br>
    * 
    * @param String returnKey
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param DmtComFaxSndInfoVO dmtComFaxSndInfoVO
    * @param SignOnUserAccount account
    * @exception EventException
    */
    public void insertDmtFaxEmlSndHistory( String returnKey , DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO , SignOnUserAccount account ) throws EventException;
    
    /**
    * Invoice files Info Send Email<br>
    * 
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String sendReportDesignerWithFiles( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , SignOnUserAccount account ) throws EventException;
    
    /**
     * search Email of Sender<br>
     * 
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */    
     
    public String searchSenderEmailByUser( SignOnUserAccount account ) throws EventException ;
  
}
