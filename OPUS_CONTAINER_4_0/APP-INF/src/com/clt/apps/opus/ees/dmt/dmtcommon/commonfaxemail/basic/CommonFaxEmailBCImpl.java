/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonFaxEmailBCImpl.java
*@FileTitle : Fax Email Send
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.basic;

import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.integration.CommonFaxEmailDBDAO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.integration.CommonFaxEmailEAIDAO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComFaxSndInfoVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComRDFaxEmailSendInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-InvoiceMgt Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see reference DAO of DmtComFaxEmailEventResponse,DMTCommonFaxEmailBC
 * @since J2EE 1.6
 */

public class CommonFaxEmailBCImpl extends BasicCommandSupport implements CommonFaxEmailBC {

    // Database Access Object
    private transient CommonFaxEmailEAIDAO eaiDao = null;
    private transient CommonFaxEmailDBDAO dao = null;

    /**
     * FaxSendBCImpl create object<br>
     * create FaxSendDBDAO<br>
     */
    public CommonFaxEmailBCImpl() {
        eaiDao = new CommonFaxEmailEAIDAO();
        dao = new CommonFaxEmailDBDAO();
    }
    
    /**
    * Invoice Info Send Fax <br>
    * 
    * @param dmtComRDFaxEmailSendInfoVO DmtComRDFaxEmailSendInfoVO
    * @param dmtComFaxSndInfoVO DmtComFaxSndInfoVO
    * @return String
    * @exception EventException
    */
    public String sendFaxInvoice( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO) throws EventException {
        try {
        	//dao.getClass();
        	String payerInfo[] = dao.searchPayerName(dmtComRDFaxEmailSendInfoVO.getPayc());
            return eaiDao.sendFaxInvoice( dmtComRDFaxEmailSendInfoVO , dmtComFaxSndInfoVO , payerInfo );
        } catch (Exception e) {
        	log.error("[Exception]"+e.getMessage());
            throw new EventException(e.getMessage());
        }
    }
    
    /**
    * [Invoice Info Send Email].<br>
    * 
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param DmtComFaxSndInfoVO dmtComFaxSndInfoVO
    * @param SignOnUserAccount account
    * @return String
    * @throws EventException 
    * @exception EventException
    */
    public String sendEmailInvoice( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO , SignOnUserAccount account ) throws EventException {
    	log.debug("\n ###################################################### BCIMPL sendEmailInvoice S.T.A.R.T.");
    	String sender_email_no = "";
    	String send_no = "";
    	
    	try {
    		if(dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrFixed() == null || dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrFixed().length() == 0) { // when fix sender email exists
    			sender_email_no = dao.searchSenderEmailByUser(account);
    			dmtComRDFaxEmailSendInfoVO.setRdFxemlEmlSndrAdd(sender_email_no);
    		}
    		send_no = eaiDao.sendEmailInvoice( dmtComRDFaxEmailSendInfoVO , dmtComFaxSndInfoVO , account );
    	} catch (DAOException ex) {
    		log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception e) {
        	log.error("[Exception]"+e.getMessage());
            throw new EventException(e.getMessage());
        }
    	log.debug("\n ###################################################### BCIMPL sendEmailInvoice E.N.D.");
    	return send_no;
    }
    

    
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
    public String sendDigitalSignInvoiceByFTP( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO , SignOnUserAccount account ) throws EventException {
    	log.debug("\n ###################################################### BCIMPL sendDigitalSignInvoiceByFTP S.T.A.R.T.");
    	String sender_email_no = "";
    	String send_no = "";
    	
    	try {
    		if(dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrFixed() == null || dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrFixed().length() == 0) { // when fix sender email exists
    			sender_email_no = dao.searchSenderEmailByUser(account);
    			dmtComRDFaxEmailSendInfoVO.setRdFxemlEmlSndrAdd(sender_email_no);
    		}    		
    		//2016.03.24 Login Office Code의 Country Code : IN, Invoice Email 일 경우에만 Digital Sign FTP로 파일 전송.
    		send_no = eaiDao.sendDigitalSignInvoiceByFTP( dmtComRDFaxEmailSendInfoVO , dmtComFaxSndInfoVO , account );    		
    	} catch (DAOException ex) {
    		log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception e) {
        	log.error("[Exception]"+e.getMessage());
            throw new EventException(e.getMessage());
        }
    	log.debug("\n ###################################################### BCIMPL sendDigitalSignInvoiceByFTP E.N.D.");
    	return send_no;
    }
    

    
    /**
    * [Login Office of country Code]<br>
    * 
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String searchCountryCodeByOfcCd(SignOnUserAccount account ) throws EventException {
    	log.debug("###################################################### BCIMPL searchCountryCodeByOfcCd START.");
    	String cntCd = "";    	
    	try {
    		cntCd = dao.searchCountryCodeByOfcCd(account.getOfc_cd());
    	} catch (DAOException ex) {
    		log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception e) {
        	log.error("[Exception]"+e.getMessage());
            throw new EventException(e.getMessage());
        }
    	log.debug("###################################################### BCIMPL searchCountryCodeByOfcCd E N D.");
    	return cntCd;
    }
    
    /**
    * [Logging Fax Email Send Info].<br>
    * 
    * @param String returnKey
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param DmtComFaxSndInfoVO dmtComFaxSndInfoVO
    * @param SignOnUserAccount account
    * @exception EventException
    */
    public void insertDmtFaxEmlSndHistory( String returnKey , DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO , SignOnUserAccount account ) throws EventException {
        log.debug("\n ###################################################### BCIMPL sendEmailInvoice");
        try{
        	if(dmtComFaxSndInfoVO.getBatFlg().equals("E")) {
        		dmtComRDFaxEmailSendInfoVO.setRdFxemlFaxNo("");
        	} else if(dmtComFaxSndInfoVO.getBatFlg().equals("F")) {
        		dmtComRDFaxEmailSendInfoVO.setRdFxemlEmlRcvrAdd("");
        	}
            dao.insertDmtFaxEmlSndHistory( returnKey , dmtComRDFaxEmailSendInfoVO , dmtComFaxSndInfoVO , account );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception e) {
        	log.error("[Exception]"+e.getMessage());
            throw new EventException(e.getMessage());
        }
    }
    
    /**
    * [Invoice files Info Send Email]<br>
    * 
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String sendReportDesignerWithFiles( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , SignOnUserAccount account ) throws EventException {
    	log.debug("###################################################### BCIMPL sendReportDesignerWithFiles");
    	String sender_email_no = "";
    	String send_no = "";
    	
    	try {
    		sender_email_no = dao.searchSenderEmailByUser(account);
    		dmtComRDFaxEmailSendInfoVO.setRdFxemlEmlSndrAdd(sender_email_no);
    		send_no = eaiDao.sendReportDesignerWithFiles( dmtComRDFaxEmailSendInfoVO , account );
    	} catch (DAOException ex) {
    		log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception e) {
        	log.error("[Exception]"+e.getMessage());
            throw new EventException(e.getMessage());
        }
    	return send_no;
    }
    
    /**
     * search Email of Sender.<br>
     * 
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
     public String searchSenderEmailByUser( SignOnUserAccount account ) throws EventException {
     	String dfltEml = "";
     	
     	try {
     		dfltEml = dao.searchSenderEmailByUser(account);
     	} catch (DAOException ex) {
     		log.error("[DAOException]"+ex.getMessage());
             throw new EventException(new ErrorHandler(ex).getMessage());
         } catch (Exception e) {
         	log.error("[Exception]"+e.getMessage());
             throw new EventException(e.getMessage());
         }
     	return dfltEml;
     }    
}
