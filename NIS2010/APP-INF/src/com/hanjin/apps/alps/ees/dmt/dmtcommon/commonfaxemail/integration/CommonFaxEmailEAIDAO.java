/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonFaxEmailEAIDAO.java
*@FileTitle : Fax Email Send
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.11.04 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.basic.CommonFaxEmailBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComFaxSndInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComRDFaxEmailSendInfoVO;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxSendException;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;

/**
 * ALPS DMTCommonFaxEmailEAIDAO <br>
 * - ALPS-InvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Mun Jung Cheol
 * @param <DmtComRDFaxEmailSendInfoVO>
 * @see CommonFaxEmailBCImpl 참조
 * @since J2EE 1.6
 */

public class CommonFaxEmailEAIDAO extends EAIDAOSupport {
    
    /**
    * [FAX] : [] 
    * [Invoice Info] 정보를 [Fax Send] 합니다.<br>
    * 
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param DmtComFaxSndInfoVO dmtComFaxSndInfoVO
    * @param SignOnUserAccount account
    * @return String
    * @throws DAOException
    */    
    public String sendFaxInvoice( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO , SignOnUserAccount account ) throws FaxSendException {

//        dmtComRDFaxEmailSendInfoVO.setRdFxemlFaxNo("DMT;3415");
//log.debug("\n ######################### DMTCommonFaxEmailEAIDAO sendFaxInvoice getRdFxemlSysCd [ \n " + dmtComRDFaxEmailSendInfoVO.getRdFxemlSysCd() + " \n ]");
//log.debug("\n ######################### DMTCommonFaxEmailEAIDAO sendFaxInvoice getRdFxemlFileName [ \n " + dmtComRDFaxEmailSendInfoVO.getRdFxemlFileName() + " \n ]");
//log.debug("\n ######################### DMTCommonFaxEmailEAIDAO sendFaxInvoice getRdFxemlBatFlg [ \n " + dmtComRDFaxEmailSendInfoVO.getRdFxemlBatFlg() + " \n ]");
//log.debug("\n ######################### DMTCommonFaxEmailEAIDAO sendFaxInvoice getRdFxemlFaxSndrId [ \n " + dmtComRDFaxEmailSendInfoVO.getRdFxemlFaxSndrId() + " \n ]");
//log.debug("\n ######################### DMTCommonFaxEmailEAIDAO sendFaxInvoice getOfc_cd [ \n " + account.getOfc_cd() + " \n ]");
//log.debug("\n ######################### DMTCommonFaxEmailEAIDAO sendFaxInvoice getRdFxemlRdParam [ \n " + dmtComRDFaxEmailSendInfoVO.getRdFxemlRdParam() + " \n ]");

    	
    	
        log.debug("\n ################## FaxNo [ "+dmtComRDFaxEmailSendInfoVO.getRdFxemlFaxNo() +"]");
    	
        
        /*********************************************
        올바른 FAX 수신자 번호 정보
		단건인 경우
		front2;1-905-282-9245
		다건인 경우
		front2;1-905-282-9245,front3;1-714-690-8693
		(2010-04-07 수정)
        *********************************************/
        String rcvInfo = null;
        
        if(dmtComRDFaxEmailSendInfoVO.getRdFxemlFaxNo().indexOf(';') != -1) {
        	// 다건인 경우
	        StringBuffer buf = new StringBuffer();
	        StringTokenizer stRcvr = new StringTokenizer(dmtComRDFaxEmailSendInfoVO.getRdFxemlFaxNo(), ";");
	        while( stRcvr.hasMoreTokens() ){
	            String tRcvvVal = stRcvr.nextToken();
	            buf.append(account.getUsr_id()).append(";").append(tRcvvVal).append(",");
	        }
	        
	        buf.deleteCharAt(buf.length()-1);
	        rcvInfo = buf.toString();
        } else {
        	// 단건인 경우
        	rcvInfo = account.getUsr_id() + ";" + dmtComRDFaxEmailSendInfoVO.getRdFxemlFaxNo();
        }
        
    	FaxMetaInfo faxMetaInfo = new FaxMetaInfo   (  
                                                     dmtComRDFaxEmailSendInfoVO.getRdFxemlSysCd()
                                                    ,dmtComRDFaxEmailSendInfoVO.getRdFxemlFileName()
                                                    ,dmtComRDFaxEmailSendInfoVO.getRdFxemlBatFlg()
                                                    //,"FAXTEST" // dmtComRDFaxEmailSendInfoVO.getRdFxemlTitle()
                                                    ,dmtComRDFaxEmailSendInfoVO.getRdFxemlTitle()
                                                    ,dmtComRDFaxEmailSendInfoVO.getRdFxemlRdParam()
                                                    //,"JMJ;3415" //dmtComRDFaxEmailSendInfoVO.getRdFxemlFaxNo()
                                                    //,account.getUsr_id()+";"+dmtComRDFaxEmailSendInfoVO.getRdFxemlFaxNo()
                                                    ,rcvInfo
                                                    ,account.getOfc_cd()
                                                    ,dmtComRDFaxEmailSendInfoVO.getRdFxemlFaxSndrId()
                                                    );
        
//        FaxMetaInfo faxMetaInfo = new FaxMetaInfo("DMT"
//                                                     ,"EES_DMT_4904_2.mrd"
//                                                     ,"N"
//                                                     ,"FAX SENDER"
//                                                     ,"/rp [A,N,Y,H,L] [2009-07-19] [2010-01-19] [ATLBB] [105767] [105767] [105767] [105767] [105767] [DTIC] [] [] [] [] [] [] [] [] [] [A,S,C,N] [A,S,C,N] [A,S,C,N] [*** OUTBOUND DETENTION OUTSTANDING ***] [C/O FRONTAGE WORLDWIDE, LLC] [P.O. BOX 2187, BUENA PARK, CA 90621] [ ] [SEALANE EXPRESS - NORFOLK] [60 CUTTLER MILL RD. SUITE 407] [GREAT NECK, NY] [ 11021] [] [NAME OF TES_ATLBB] [] [105767] [1-516-466-4278] [1-516-466-3739] [ ] [] [] [* ATLANTA OUTSTANDING DETENTION - Invoice date upto 11/30/09 *] [A delay in response to these notices will result in terminal restrictions] [and may forward to collection agency.] [Cnt: CINDY SHIN              E-mail : cindy@frontagellc.com] [Tel: 714-690-8694            Fax:714-690-8693] [ ] [PLEASE REVIEW AND REMIT TO SM Line Corporation.] [MAIL TO    FRONTAGE WORLDWIDE, LLC] [**         P.O. BOX 2187] [**         BUENA PARK, CA 90621] [Y] [Y] [Y] [ATM000002,]"
//                                                     ,"KIM;5320,KJH;3415"
//                                                     ,"ATLBB"
//                                                     ,"KJH");
        return FaxUtility.registerDB(faxMetaInfo);
    }
    
    /**
    * [E-Mail] : []
    * [Invoice Info] 정보를 [Email Send] 합니다.<br>
    * 
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param DmtComFaxSndInfoVO dmtComFaxSndInfoVO
    * @param SignOnUserAccount account
    * @return String
    * @throws DAOException
    */    
    public String sendEmailInvoice( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO , SignOnUserAccount account ) {
        String sndNo = "";
        try {
//            List<SingleMailAttachedFile> fileList = new ArrayList<SingleMailAttachedFile>();
            String tempVal = (String)dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlTmpltParam();
            
            StringTokenizer st = new StringTokenizer(tempVal, "|");
            String[] strArr = new String[st.countTokens()];
            StringTokenizer st2 = new StringTokenizer(tempVal, "|");
            
            int tknInt = 0;
            while (st2.hasMoreTokens()) {
                strArr[tknInt++] = st2.nextToken();
            }            

            TemplateMail template = new TemplateMail();
            template.setFrom        ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrAdd() );
            template.setSubject     ( dmtComRDFaxEmailSendInfoVO.getRdFxemlTitle     () );
            template.setRecipient   ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlRcvrAdd() );
            template.setCcRcvrEml   ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrAdd() );
            template.setHtmlTemplate( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlTemplt () );
            
            log.debug("\n ################## Recipient Mail [ "+dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlRcvrAdd() +"]");
            log.debug("\n ################## CcRcvrEml Mail [ "+dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrAdd() +"]");
            
            String tArg = dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlTmpltParam();
            if ( !tArg.equals("") ) {
                String[] arrArg = StringUtils.split(tArg,"|");
                for ( int iArg = 0 ; iArg < arrArg.length ; iArg++ ) {
                    String[] arrArg2 = StringUtils.split(arrArg[iArg],";");
                    template.setArg( arrArg2[0] , arrArg2[1] );
                }
            }

            List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
            
            ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
            comRptDsgnXptInfoVO.setCreUsrId   ( account.getUsr_id                            () );
            comRptDsgnXptInfoVO.setUpdUsrId   ( account.getUsr_id                            () );
            comRptDsgnXptInfoVO.setRdTmpltNm  ( dmtComRDFaxEmailSendInfoVO.getRdFxemlFileName() );
            comRptDsgnXptInfoVO.setRdParaCtnt ( dmtComRDFaxEmailSendInfoVO.getRdFxemlRdParam () );
            comRptDsgnXptInfoVO.setXptFileTpCd( ExportInfo.FTYPE_PDF                            );
            comRptDsgnXptInfoVO.setXptFileNm  ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlAtchFile()+".pdf" );
            
            comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
            
            template.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
            //EUR 인증 Mail 전송
            template.setOfficeCode(account.getOfc_cd());

            log.debug("\n ######################### DMTCommonFaxEmailEAIDAO sendEmailInvoice getRdFxemlRdParam [" + dmtComRDFaxEmailSendInfoVO.getRdFxemlRdParam() + "]");
            sndNo = template.send();
            log.debug("\n ######################### DMTCommonFaxEmailEAIDAO sendEmailInvoice sndNo [" + sndNo + "]");
            if ( sndNo.equals("") ) {
                throw new Exception("FAIL TO CREATE EML_SND_NO TABLE COM_EML_SND_INFO");
            }
        } catch(SQLException se){
 			log.error(se.getMessage(),se);
 		} catch (Exception e){
            log.error(e.getMessage());
        }
        return sndNo;
    }

    /**
    * [E-Mail] : []
    * 다수개의 RD [Invoice Info] 정보를 [Email Send] 합니다<br>
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param SignOnUserAccount account
    * @return String 
    * @exception throws EventException 
    */
    public String sendReportDesignerWithFiles( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , SignOnUserAccount account ) {
        
        log.debug("####### DMTCommonFaxEmailEAIDAO sendReportDesignerWithFiles S.T.A.R.T");
        String sndNo = "";
        try {
            
            TemplateMail template = new TemplateMail();
            template.setFrom        ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrAdd() );
            template.setSubject     ( dmtComRDFaxEmailSendInfoVO.getRdFxemlTitle     () );
            template.setRecipient   ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlRcvrAdd() );
            template.setCcRcvrEml   ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrAdd() );
            template.setHtmlTemplate( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlTemplt () );
            String tArg = dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlTmpltParam();
            if ( !tArg.equals("") ) {
                String[] arrArg = tArg.split("|");
                for ( int iArg = 0 ; iArg < arrArg.length ; iArg++ ) {
                    String[] arrArg2 = arrArg[iArg].split(";");
                    template.setArg( arrArg2[0] , arrArg2[1] );
                }
            }
            
            List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
            
            ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
            comRptDsgnXptInfoVO.setCreUsrId   ( account.getUsr_id                            () );
            comRptDsgnXptInfoVO.setUpdUsrId   ( account.getUsr_id                            () );
            comRptDsgnXptInfoVO.setRdTmpltNm  ( dmtComRDFaxEmailSendInfoVO.getRdFxemlFileName() );
            comRptDsgnXptInfoVO.setRdParaCtnt ( dmtComRDFaxEmailSendInfoVO.getRdFxemlRdParam () );

            log.debug("ots paraCtnt===>"+dmtComRDFaxEmailSendInfoVO.getRdFxemlRdParam ());
            
            comRptDsgnXptInfoVO.setXptFileTpCd( ExportInfo.FTYPE_PDF                            );
            comRptDsgnXptInfoVO.setXptFileNm  ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlAtchFile()+".pdf"              );
            comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
            
            ComRptDsgnXptInfoVO comRptDsgnXptInfoVO2 = new ComRptDsgnXptInfoVO();
            comRptDsgnXptInfoVO2.setCreUsrId   ( account.getUsr_id                            ()   );
            comRptDsgnXptInfoVO2.setUpdUsrId   ( account.getUsr_id                            ()   );
            comRptDsgnXptInfoVO2.setRdTmpltNm  ( "EES_DMT_4907.mrd"                                );
            log.debug("attach paraCtnt===>"+"/rp ["+dmtComRDFaxEmailSendInfoVO.getInvno()+"]["+dmtComRDFaxEmailSendInfoVO.getCreof() +"]["+dmtComRDFaxEmailSendInfoVO.getCreof() +"]");
            
            comRptDsgnXptInfoVO2.setRdParaCtnt ( "/rp ["+dmtComRDFaxEmailSendInfoVO.getInvno()+"]["+dmtComRDFaxEmailSendInfoVO.getCreof() +"]["+dmtComRDFaxEmailSendInfoVO.getCreof() +"]" );
            comRptDsgnXptInfoVO2.setXptFileTpCd( ExportInfo.FTYPE_XLS                              );
            comRptDsgnXptInfoVO2.setXptFileNm  ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlAtchFile()+"_Detail.xls"                 );
            comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO2);
            
            template.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
            
            //EUR 인증 Mail 전송
            template.setOfficeCode(account.getOfc_cd());

            
            sndNo = template.send();

            log.debug("####### DMTCommonFaxEmailEAIDAO sendReportDesignerWithFiles sndNo ["+sndNo+"]");
            log.debug("####### DMTCommonFaxEmailEAIDAO sendReportDesignerWithFiles E.N.D");
        } catch (Exception e) {
            log.error("Exception : "+e.getMessage());
//            throw new EventException(e.getMessage());
        }
        return sndNo;        
    }
    

    /**
    * [E-Mail] : []
    * 다수개의 RD [Invoice Info] 정보를 [Email Send] 합니다<br>
    * 
    * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
    * @param String usrID
    * @param String sndCntrListFlg
    * @param String sndInvFlg
    * @return String
    * @exception EventException
    */
      public String sendReportDesignerWithBatchFiles( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , String usrID, String sndCntrListFlg, String sndInvFlg  ) {
        
        log.debug("####### DMTCommonFaxEmailEAIDAO sendReportDesignerWithBatchFiles S.T.A.R.T");
        String sndNo = "";
        try {
            
            TemplateMail template = new TemplateMail();
            template.setFrom        ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrAdd() );
            template.setSubject     ( dmtComRDFaxEmailSendInfoVO.getRdFxemlTitle     () );
            template.setRecipient   ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlRcvrAdd() );
//            template.setCcRcvrEml   ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrAdd() );
            template.setHtmlTemplate( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlTemplt () );
//            String tArg = dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlTmpltParam();
//            if ( !tArg.equals("") ) {
//                String[] arrArg = tArg.split("|");
//                for ( int iArg = 0 ; iArg < arrArg.length ; iArg++ ) {
//                    String[] arrArg2 = arrArg[iArg].split(";");
//                    template.setArg( arrArg2[0] , arrArg2[1] );
//                }
//            }
            
            List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
            
            ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
            comRptDsgnXptInfoVO.setCreUsrId   ( usrID );
            comRptDsgnXptInfoVO.setUpdUsrId   ( usrID );
            comRptDsgnXptInfoVO.setRdTmpltNm  ( dmtComRDFaxEmailSendInfoVO.getRdFxemlFileName() );
            comRptDsgnXptInfoVO.setRdParaCtnt ( dmtComRDFaxEmailSendInfoVO.getRdFxemlRdParam () );

            log.debug("ots paraCtnt===>"+dmtComRDFaxEmailSendInfoVO.getRdFxemlRdParam ());
            
            comRptDsgnXptInfoVO.setXptFileTpCd( ExportInfo.FTYPE_PDF                            );
            comRptDsgnXptInfoVO.setXptFileNm  ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlAtchFile()+".pdf"              );
            comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
            
            if ( "Y".equals(sndCntrListFlg)){
	            ComRptDsgnXptInfoVO comRptDsgnXptInfoVO2 = new ComRptDsgnXptInfoVO();
	            comRptDsgnXptInfoVO2.setCreUsrId   ( usrID   );
	            comRptDsgnXptInfoVO2.setUpdUsrId   ( usrID   );
	            comRptDsgnXptInfoVO2.setRdTmpltNm  ( "EES_DMT_4907.mrd"                                );
	            log.debug("attach paraCtnt===>"+"/rp ["+dmtComRDFaxEmailSendInfoVO.getInvno()+"]["+dmtComRDFaxEmailSendInfoVO.getCreof() +"]["+dmtComRDFaxEmailSendInfoVO.getCreof() +"]");
	            
	            comRptDsgnXptInfoVO2.setRdParaCtnt ( "/rp ["+dmtComRDFaxEmailSendInfoVO.getInvno()+"]["+dmtComRDFaxEmailSendInfoVO.getCreof() +"]["+dmtComRDFaxEmailSendInfoVO.getCreof() +"]" );
	            comRptDsgnXptInfoVO2.setXptFileTpCd( ExportInfo.FTYPE_XLS                              );
	            comRptDsgnXptInfoVO2.setXptFileNm  ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlAtchFile()+"_Detail.xls"                 );
	            comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO2);
            }
            
            template.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
            
            //EUR 인증 Mail 전송
            template.setOfficeCode(dmtComRDFaxEmailSendInfoVO.getOffcd());

            
            sndNo = template.send();

            log.debug("####### DMTCommonFaxEmailEAIDAO sendReportDesignerWithBatchFiles sndNo ["+sndNo+"]");
            log.debug("####### DMTCommonFaxEmailEAIDAO sendReportDesignerWithBatchFiles E.N.D");
        } catch (Exception e) {
            log.error("Exception : "+e.getMessage());
//            throw new EventException(e.getMessage());
        }
        return sndNo;        
    }
}