/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonFaxEmailBCImpl.java
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

import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.integration.CommonFaxEmailDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.integration.CommonFaxEmailEAIDAO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComFaxSndInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComRDFaxEmailSendInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.FAXEmailByPayerVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-InvoiceMgt Business Logic Basic Command implementation<br>
 * - ALPS-InvoiceMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Mun Jung Cheol
 * @see DmtComFaxEmailEventResponse,DMTCommonFaxEmailBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class CommonFaxEmailBCImpl extends BasicCommandSupport implements CommonFaxEmailBC {

    // Database Access Object
    private transient CommonFaxEmailEAIDAO eaiDao = null;
    private transient CommonFaxEmailDBDAO dao = null;

    /**
     * FaxSendBCImpl 객체 생성<br>
     * FaxSendDBDAO를 생성한다.<br>
     */
    public CommonFaxEmailBCImpl() {
        eaiDao = new CommonFaxEmailEAIDAO();
        dao = new CommonFaxEmailDBDAO();
    }
    
    /**
    * [Invoice Info]을 [Fax Send] 합니다.<br>
    * 
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param DmtComFaxSndInfoVO dmtComFaxSndInfoVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String sendFaxInvoice( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO , SignOnUserAccount account ) throws EventException {
        try {
            return eaiDao.sendFaxInvoice( dmtComRDFaxEmailSendInfoVO , dmtComFaxSndInfoVO , account );
        } catch (Exception e) {
        	log.error("[Exception]"+e.getMessage());
            throw new EventException(e.getMessage());
        }
    }
    
    /**
    * [Invoice Info]을 [Email Send] 합니다.<br>
    * 
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param DmtComFaxSndInfoVO dmtComFaxSndInfoVO
    * @param SignOnUserAccount account
    * @return String
    * @throws EventException 
    * @exception EventException
    */
    public String sendEmailInvoice( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO , SignOnUserAccount account ) throws EventException {
    	log.debug("\n ###################################################### BCIMPL sendEmailInvoice");
//    	String sender_email_no = "";
    	String send_no = "";
    	
    	try {
//    		sender_email_no = dao.searchSenderEmailByUser(account);
//    		dmtComRDFaxEmailSendInfoVO.setRdFxemlEmlSndrAdd(sender_email_no);
    		send_no = eaiDao.sendEmailInvoice( dmtComRDFaxEmailSendInfoVO , dmtComFaxSndInfoVO , account );
    	} 
//    	catch (DAOException ex) {
//    		log.error("[DAOException]"+ex.getMessage());
//            throw new EventException(new ErrorHandler(ex).getMessage());
//        } 
    	catch (Exception e) {
        	log.error("[Exception]"+e.getMessage());
            throw new EventException(e.getMessage());
        }
    	return send_no;
    }
    
    /**
    * [Fax Email Send Info]을 [Logging] 합니다.<br>
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
    * [Invoice Info]을 [Email Send] 합니다.<br>
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
     * Sender Email을 조회합니다.<br>
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
    

     /**
      * Payer Email을 조회합니다.<br>
      * 
      * @param FAXEmailByPayerVO faxEmailByPayerVO
      * @return String
      * @exception EventException
      */
      public String searchEmailByPayer( FAXEmailByPayerVO faxEmailByPayerVO ) throws EventException {
      	String dfltEml = "";
      	
      	try {
      		dfltEml = dao.searchEmailByPayer(faxEmailByPayerVO);
      	} catch (DAOException ex) {
      		log.error("[DAOException]"+ex.getMessage());
              throw new EventException(new ErrorHandler(ex).getMessage());
          } catch (Exception e) {
          	log.error("[Exception]"+e.getMessage());
              throw new EventException(e.getMessage());
          }
      	return dfltEml;
      }    
      

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
      public String sendReportDesignerWithBatchFiles( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , String usrID, String sndCntrListFlg, String sndInvFlg  ) throws EventException {
      	log.debug("###################################################### BCIMPL sendReportDesignerWithFiles");
      	String send_no = "";
      	
      	try {
      		send_no = eaiDao.sendReportDesignerWithBatchFiles( dmtComRDFaxEmailSendInfoVO , usrID, sndCntrListFlg, sndInvFlg  );
      	} catch (Exception e) {
          	log.error("[Exception]"+e.getMessage());
              throw new EventException(e.getMessage());
          }
      	return send_no;
      }
}
