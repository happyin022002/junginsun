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

package com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.basic.CommonFaxEmailBCImpl;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComFaxSndInfoVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.vo.DmtComRDFaxEmailSendInfoVO;
import com.clt.framework.component.fax.FaxMetaInfo;
import com.clt.framework.component.fax.FaxSendException;
import com.clt.framework.component.fax.FaxUtility;
import com.clt.framework.component.ftp.FtpException;
import com.clt.framework.component.ftp.FtpMetaInfo;
import com.clt.framework.component.ftp.FtpUtility;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.upload.Uploader;
import com.clt.framework.core.config.SiteConfigFactory;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.core.layer.integration.EAIException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComFtpSndInfoVO;
import com.clt.framework.table.ComRptDsgnXptInfoVO;

/**
 * OPUS DMTCommonFaxEmailEAIDAO <br>
 * - OPUS-InvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
	 * @param dmtComRDFaxEmailSendInfoVO DmtComRDFaxEmailSendInfoVO
	 * @param dmtComFaxSndInfoVO DmtComFaxSndInfoVO
	 * @param payerInfo String[]
	 * @return
	 * @throws FaxSendException
	 */
    public String sendFaxInvoice( DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO, String[] payerInfo ) throws FaxSendException {
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
	            buf.append(payerInfo[0]).append(";").append(tRcvvVal).append(",");
	        }
	        
	        buf.deleteCharAt(buf.length()-1);
	        rcvInfo = buf.toString();
        } else {
        	// 단건인 경우
        	rcvInfo = payerInfo[0] + ";" + dmtComRDFaxEmailSendInfoVO.getRdFxemlFaxNo();
        }
        
    	FaxMetaInfo faxMetaInfo = new FaxMetaInfo   (  
                                                     dmtComRDFaxEmailSendInfoVO.getRdFxemlSysCd()
                                                    ,dmtComRDFaxEmailSendInfoVO.getRdFxemlFileName()
                                                    ,dmtComRDFaxEmailSendInfoVO.getRdFxemlBatFlg()
                                                    ,dmtComRDFaxEmailSendInfoVO.getRdFxemlTitle()
                                                    ,dmtComRDFaxEmailSendInfoVO.getRdFxemlRdParam()
                                                    ,rcvInfo
                                                    ,payerInfo[1]
                                                    ,dmtComRDFaxEmailSendInfoVO.getRdFxemlFaxSndrId()
                                                    );

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
            if(dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrFixed() != null && dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrFixed().length() > 0) { // when fix sender email exists
            	template.setFrom        ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrFixed() );
            } else {
            	template.setFrom        ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrAdd() );
            }
            template.setSubject     ( dmtComRDFaxEmailSendInfoVO.getRdFxemlTitle     () );
            template.setRecipient   ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlRcvrAdd() );
            if(dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrFixed() != null && dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrFixed().length() > 0) { // when fix sender email exists
            	template.setCcRcvrEml   ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrFixed() );
            } else {
            	template.setCcRcvrEml   ( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrAdd() );
            }
            
            //2016.03.23 Add
            CommonFaxEmailDBDAO dbDao = new CommonFaxEmailDBDAO();
            String bccRcvrEml = dbDao.searchDefaultMailAddress();
            if(!StringUtils.isEmpty(bccRcvrEml)){
            	log.debug("\n ################## BccRcvrEml is Not Null Mail ["+bccRcvrEml+"]");
            	template.setBccRcvrEml   (bccRcvrEml);
        	}
                        
            template.setHtmlTemplate( dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlTemplt () );            
            
            log.debug("\n ########################################################################"+
                      "\n From Mail       ["+dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrFixed()+"] or ["+dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlRcvrAdd() +"]"+
                      "\n Recipient Mail  ["+dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlRcvrAdd() +"]"+
                      "\n CcRcvrEml Mail  ["+dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrFixed()+"] or ["+dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrAdd() +"]"+
                      "\n BccRcvrEml Mail ["+bccRcvrEml+"]"+
                      "\n ########################################################################");
            
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
            
            //2016.03.23 Add
            CommonFaxEmailDBDAO dbDao = new CommonFaxEmailDBDAO();
            String bccRcvrEml = dbDao.searchDefaultMailAddress();
            if(!StringUtils.isEmpty(bccRcvrEml)){
            	log.debug("\n ################## BccRcvrEml is Not Null Mail ["+bccRcvrEml+"]");
            	template.setBccRcvrEml   (bccRcvrEml);
        	}
            
            log.debug("\n ########################################################################"+
                      "\n From Mail       ["+dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlRcvrAdd() +"]"+
                      "\n Recipient Mail  ["+dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlRcvrAdd() +"]"+
                      "\n CcRcvrEml Mail  ["+dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlSndrAdd() +"]"+
                      "\n BccRcvrEml Mail ["+bccRcvrEml+"]"+
                      "\n ########################################################################");
            
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
	 * Digital Sign Invoice FTP를 전송합니다.<br>
	 * 2016.03.23 : India 일경우 eSign System으로 FTP를 전송 함.
	 * 
	 * @param DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO
	 * @param DmtComFaxSndInfoVO dmtComFaxSndInfoVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EAIException 
	 */	
	public String sendDigitalSignInvoiceByFTP(DmtComRDFaxEmailSendInfoVO dmtComRDFaxEmailSendInfoVO , DmtComFaxSndInfoVO dmtComFaxSndInfoVO , SignOnUserAccount account) throws FtpException, EAIException, EventException {
		log.debug("\n####### DMTCommonFaxEmailEAIDAO sendDigitalSignInvoiceByFTP S.T.A.R.T");
		String ftpSendNo = "";
		
		String ftpFileNm = dmtComRDFaxEmailSendInfoVO.getPayc()+"_"+dmtComRDFaxEmailSendInfoVO.getInvno()+".pdf"; //Customer Code_Invoice No.pdf 
		//String FtpServerIp = "10.91.5.40";
		//String FtpUserId = "eSign";
		//String FtpUserPwd = "";
		//String FtpSystemCd = "INV";
		
		//String ftpServerIp 	= SubSystemConfigFactory.get("INV.INV_ISSUE.INDIA_FTP_SERVER.SVR_IP");
		//String ftpUserId 	= SubSystemConfigFactory.get("INV.INV_ISSUE.INDIA_FTP_SERVER.USR_ID");
		//String ftpUserPwd 	= SubSystemConfigFactory.get("INV.INV_ISSUE.INDIA_FTP_SERVER.USR_PW");
		
		//TEST용 정보
		String ftpServerIp = "10.91.5.35";
		String ftpUserId = "eSign";
		String ftpUserPwd = "dr0w55aP";
		
		String ftpDirforPdf = "/OPUS Invoice/";
		String expTpCd 	= "5";
		String rdName 	= dmtComRDFaxEmailSendInfoVO.getRdFxemlFileName();
		String rdParam 	= dmtComRDFaxEmailSendInfoVO.getRdFxemlRdParam ();
		
		

		log.info("   \n########## ftpFileNm   : "+ftpFileNm);
		log.info("   \n########## Ftp_Svr_Ip  : "+ftpServerIp);
		log.info("   \n########## Ftp_Usr_Id  : "+ftpUserId);	
		log.info("   \n########## Ftp_Usr_Pwd : "+ftpUserPwd);	
		log.info("   \n########## rdName      : "+rdName);		
		log.info("   \n########## rdParam     : "+rdParam);	
		
		String[] rdApplCdInfo = new String[2];
		try {
			CommonFaxEmailDBDAO dbDao = new CommonFaxEmailDBDAO();
			FtpMetaInfo ftpMetaInfo = new FtpMetaInfo();
			
			rdApplCdInfo = dbDao.searchRdApplCdFtp(rdName);
			
			log.info("   \n########## setSys_cd  : "+rdApplCdInfo[1]);
			log.info("   \n########## setTmplMrd : "+rdApplCdInfo[0]);		
			
			ftpMetaInfo.setCreUsrId		(account.getUsr_id());
			ftpMetaInfo.setFtp_svr_ip	(ftpServerIp);
			ftpMetaInfo.setFtp_usr_id	(ftpUserId);
			ftpMetaInfo.setFtp_usr_pw	(ftpUserPwd);
			ftpMetaInfo.setSys_cd		(rdApplCdInfo[1]);
			ftpMetaInfo.setTmplMrd		(rdApplCdInfo[0]);
			ftpMetaInfo.setParaInfoCtnt	(rdParam);
			ftpMetaInfo.setFtp_dir_ctnt	(ftpDirforPdf+ftpFileNm);
			ftpMetaInfo.setExp_tp_cd	(expTpCd);

			ftpSendNo = FtpUtility.registerDB(ftpMetaInfo);	
			
			//send txt file
			String contents = dmtComRDFaxEmailSendInfoVO.getRdFxemlEmlRcvrAdd(); // 화면에서 받는 사람의 email 주소를 받아서 넣어줍니다. 확인 바랍니다~
			String exportFileName = dmtComRDFaxEmailSendInfoVO.getPayc()+"_"+dmtComRDFaxEmailSendInfoVO.getInvno();
			String exportFilePath = SiteConfigFactory.getWhenNullThrowException("COM.FILE.UPLOAD.STRING");
			String fileExtention = SiteConfigFactory.getWhenNullThrowException("COM.FILE.UPLOAD.STRING.EXT");
			String ftpDirforTxt = "/OPUS Email/";
			//text file 생성
			Uploader.writeString(contents, exportFileName);
			
			ComFtpSndInfoVO comFtpSndInfoVO = new ComFtpSndInfoVO();
			comFtpSndInfoVO.setCreUsrId(account.getUsr_id());
			comFtpSndInfoVO.setFtpFilePathUrlCtnt(exportFilePath + exportFileName + fileExtention);
			comFtpSndInfoVO.setFtpDirCtnt(ftpDirforTxt + exportFileName + fileExtention);
			comFtpSndInfoVO.setFtpSvrIp(ftpServerIp);
			comFtpSndInfoVO.setFtpUsrId(ftpUserId);
			comFtpSndInfoVO.setFtpUsrPwd(ftpUserPwd);
			comFtpSndInfoVO.setSubSysCd("DMT");  
			//txt file 전송
			FtpUtility.send(comFtpSndInfoVO);			
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception e) {
			throw new EventException(e.getMessage()); 
		}
		
		log.debug("\n####### ftpSendNo ["+ftpSendNo+"].");
		
		log.debug("\n####### DMTCommonFaxEmailEAIDAO sendDigitalSignInvoiceByFTP E.N.D.");
		return ftpSendNo;
        
	}
}