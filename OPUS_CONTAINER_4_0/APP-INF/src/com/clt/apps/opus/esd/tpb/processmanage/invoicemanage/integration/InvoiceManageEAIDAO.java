/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceManageEAIDAO.java
*@FileTitle : InvoiceManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : Sun, CHOI
*@LastVersion : 1.0
* 2009.07.17 Sun, CHOI
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration;
  
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.TPBRDFaxMailEAIVO;
import com.clt.framework.component.exception.CheckUtilsException;
import com.clt.framework.component.fax.FaxMetaInfo;
import com.clt.framework.component.fax.FaxSendException;
import com.clt.framework.component.fax.FaxUtility;
import com.clt.framework.component.ftp.FtpMetaInfo;
import com.clt.framework.component.ftp.FtpUtility;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.upload.Uploader;
import com.clt.framework.core.config.SiteConfigFactory;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComFtpSndInfoVO;
import com.clt.framework.table.ComRptDsgnXptInfoVO;



/**
 *  InvoiceManageEAIDAO <br>
 * - -InvoiceManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sun, CHOI
 * @see InvoiceManage 참조
 * @since J2EE 1.6
 */
public class InvoiceManageEAIDAO extends DBDAOSupport {

	/**
	 * This method sends RD FAXs
	 *
	 * @param RDFaxMailEAIVO rdFaxMailEAIVO
	 * @return String
	 * @throws FaxSendException
	 */
	public String rdFaxSend(TPBRDFaxMailEAIVO rdFaxMailEAIVO) throws FaxSendException {
		try {
			FaxMetaInfo faxMetaInfo =
				new FaxMetaInfo(rdFaxMailEAIVO.getSubSysCd(),
								rdFaxMailEAIVO.getTmplMrd(),
								"N",
								rdFaxMailEAIVO.getTitle(),
								rdFaxMailEAIVO.getTmplParam(),
								rdFaxMailEAIVO.getReceiverFax(),
								rdFaxMailEAIVO.getSenderUsrOfc(),	
								rdFaxMailEAIVO.getSenderUsrId());

			String faxNo = FaxUtility.registerDB(faxMetaInfo);
			FaxUtility.send(faxNo);
			return faxNo;
		} catch (FaxSendException e){
			log.error(e.getMessage(), e);
			throw new FaxSendException(new ErrorHandler(e).getMessage());
		} catch (Exception e){
			log.error(e.getMessage(), e);
			throw new FaxSendException(new ErrorHandler(e).getMessage());
		}
	}
	
//	/**
//	 * This method sends RD Mails
//	 *
//	 * @param RDFaxMailEAIVO rdFaxMailEAIVO
//	 * @return String
//	 * @throws RDMailSendException
//	 */
//	public String rdMailSend(TPBRDFaxMailEAIVO rdFaxMailEAIVO) throws RDMailSendException {
//		try {
////			public RDMailMetaInfo(  sys_cd,
////									tmplMrd,
////									batch_ind,
////									title,
////									content,
////									param,
////									sender_nm,
////									sender_email,
////									receiver_email,
////									crt_user);
//			RDMailMetaInfo rdMailMetaInfo =
//				new RDMailMetaInfo( rdFaxMailEAIVO.getSubSysCd(),
//									rdFaxMailEAIVO.getTmplMrd(),
//									"N",
//									rdFaxMailEAIVO.getTitle(),
//									rdFaxMailEAIVO.getContent(),
//									rdFaxMailEAIVO.getTmplParam(),
//									rdFaxMailEAIVO.getSenderUsrNm(),	
//									rdFaxMailEAIVO.getSenderUsrEml(),
//									rdFaxMailEAIVO.getReceiverEml(),	
//									rdFaxMailEAIVO.getSenderUsrId());
//
//			return RDMailUtility.registerDB(rdMailMetaInfo);
//
//		} catch (RDMailSendException e){
//			log.error(e.getMessage(), e);
//			throw new RDMailSendException(new ErrorHandler(e).getMessage());
//		} catch (Exception e){
//			log.error(e.getMessage(), e);
//			throw new RDMailSendException(new ErrorHandler(e).getMessage());
//		}
//	}
		
//	/**
//	 * This method sends RD Mails
//	 *
//	 * @param RDFaxMailEAIVO rdFaxMailEAIVO
//	 * @return String
//	 * @throws RDMailSendException
//	 */
//	public String rdMailSend1(TPBRDFaxMailEAIVO rdFaxMailEAIVO) throws RDMailSendException {
//		
//		Mail						mail					= null; 
//		ComRptDsgnXptInfoVO			comRptDsgnXptInfoVO		= null;
//		List<ComRptDsgnXptInfoVO>	comRptDsgnXptInfoVOs	= new ArrayList<ComRptDsgnXptInfoVO>();
//		
//		try {
//	    	mail	= new Mail();
//	    	mail.setRdSubSysCd	(rdFaxMailEAIVO.getSubSysCd());
//	    	mail.setBatFlg		("N");
//	    	mail.setSubject		(rdFaxMailEAIVO.getTitle());
//	    	mail.setTextContent	(rdFaxMailEAIVO.getContent());
//    		mail.setFrom		(rdFaxMailEAIVO.getSenderUsrEml(), rdFaxMailEAIVO.getSenderUsrNm());
//    		mail.setRecipient	(rdFaxMailEAIVO.getReceiverEml());
//
//    		comRptDsgnXptInfoVO	= new ComRptDsgnXptInfoVO();
//    		comRptDsgnXptInfoVO.setRdTmpltNm	(rdFaxMailEAIVO.getTmplParam());
//    		comRptDsgnXptInfoVO.setXptFileNm	(((new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date())).toString()+"TPB.pdf");
//    		comRptDsgnXptInfoVO.setRdParaCtnt	(rdFaxMailEAIVO.getTmplParam());
//    		comRptDsgnXptInfoVO.setCreUsrId		(rdFaxMailEAIVO.getSenderUsrId());
//			comRptDsgnXptInfoVO.setUpdUsrId		(rdFaxMailEAIVO.getSenderUsrId());
//    		comRptDsgnXptInfoVO.setXptFileTpCd	(ExportInfo.FTYPE_PDF);	
//    		comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
//
//    		mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
//    		mail.send();
//		} catch (Exception e){
//			log.error(e.getMessage(), e);
//			throw new RDMailSendException(new ErrorHandler(e).getMessage());
//		}
//		return null;
//	}
	
	/**
	 * This method sends RD Mails
	 *
	 * @param  rdFaxMailEAIVO TPBRDFaxMailEAIVO
	 * @param  account SignOnUserAccount
	 * @param  strFileName String
	 * @param  strCntCd String
	 * @return  strSendKeyVal String
	 * @throws MailerAppException
	 * @throws CheckUtilsException
	 * @throws EventException
	 */
	@SuppressWarnings("unused")
	public String rdMailSend(TPBRDFaxMailEAIVO rdFaxMailEAIVO, SignOnUserAccount account, String strFileName, String strCntCd) throws MailerAppException, CheckUtilsException, EventException {		
		try {			
			String strSendKeyVal = "";
			
			if("IN".equals(strCntCd)){
				FtpMetaInfo ftpMetaInfo = new FtpMetaInfo();
				InvoiceManageDBDAO dbDao = new InvoiceManageDBDAO();
				
				String FtpServerIp = SubSystemConfigFactory.get("INV.INV_ISSUE.INDIA_FTP_SERVER.SVR_IP");
				String FtpUserId = SubSystemConfigFactory.get("INV.INV_ISSUE.INDIA_FTP_SERVER.USR_ID");
				String FtpUserPwd = SubSystemConfigFactory.get("INV.INV_ISSUE.INDIA_FTP_SERVER.USR_PW");
				
				//TEST용 정보
				//String FtpServerIp = "10.91.5.35";
				//String FtpUserId = "eSign";
				//String FtpUserPwd = "dr0w55aP";
				
				String ftpDirforPdf = "/OPUS Invoice/";
				
				String rtnVal = "";
				
				rtnVal = dbDao.searchRdApplCdFtp(rdFaxMailEAIVO.getTmplMrd()); // RD_APPL_CD, RD_SUB_SYS_CD
				
				ftpMetaInfo.setCreUsrId(account.getUsr_id());
				ftpMetaInfo.setFtp_svr_ip(FtpServerIp);
				ftpMetaInfo.setFtp_usr_id(FtpUserId);
				ftpMetaInfo.setFtp_usr_pw(FtpUserPwd);
				ftpMetaInfo.setTmplMrd(rtnVal.split(",")[0]); // RD_APPL_CD
				ftpMetaInfo.setSys_cd(rtnVal.split(",")[1]); // RD_SUB_SYS_CD		
				
				ftpMetaInfo.setParaInfoCtnt(rdFaxMailEAIVO.getTmplParam());
				ftpMetaInfo.setFtp_dir_ctnt(ftpDirforPdf+strFileName+".pdf");
				ftpMetaInfo.setExp_tp_cd("5");
				
				strSendKeyVal = FtpUtility.registerDB(ftpMetaInfo);
				
				//send txt file
				String contents = rdFaxMailEAIVO.getReceiverEml();
				String exportFilePath = SiteConfigFactory.getWhenNullThrowException("COM.FILE.UPLOAD.STRING");
				String fileExtention = SiteConfigFactory.getWhenNullThrowException("COM.FILE.UPLOAD.STRING.EXT");
				String ftpDirforTxt = "/OPUS Email/";
				//text file 생성
				Uploader.writeString(contents, strFileName);
				
				log.debug("\n INDIA FTP rdMailSend START ========================================="+
						  "\n FtpServerIp        ["+FtpServerIp+"]"+
						  "\n FtpUserId          ["+FtpUserId+"]"+
						  "\n FtpUserPwd         ["+FtpUserPwd+"]"+
						  "\n contents           ["+contents+"]"+
						  "\n exportFilePath     ["+exportFilePath+"]"+
						  "\n fileExtention      ["+fileExtention+"]"+
						  "\n ftpDirforTxt       ["+ftpDirforTxt+"]"+
						  "\n FtpFilePathUrlCtnt ["+exportFilePath + strFileName + fileExtention+"]"+
						  "\n setFtpDirCtnt      ["+ftpDirforTxt + strFileName + fileExtention+"]"+
						  "\n INDIA FTP rdMailSend E N D ========================================="
						);
				
				ComFtpSndInfoVO comFtpSndInfoVO = new ComFtpSndInfoVO();
				comFtpSndInfoVO.setCreUsrId(account.getUsr_id());
				comFtpSndInfoVO.setFtpFilePathUrlCtnt(exportFilePath + strFileName + fileExtention);
				comFtpSndInfoVO.setFtpDirCtnt(ftpDirforTxt + strFileName + fileExtention);
				comFtpSndInfoVO.setFtpSvrIp(FtpServerIp);
				comFtpSndInfoVO.setFtpUsrId(FtpUserId);
				comFtpSndInfoVO.setFtpUsrPwd(FtpUserPwd);
				comFtpSndInfoVO.setSubSysCd("TPB");  
				//txt file 전송
				FtpUtility.send(comFtpSndInfoVO);
				
			} else {
				TemplateMail template = new TemplateMail();
				
				template.setFrom(rdFaxMailEAIVO.getSenderUsrEml());
				//template.setFrom("shipinfobcc@na.nykline.com");
				template.setBccRcvrEml("shipinfobcc@na.nykline.com");
				
				template.setSubject(rdFaxMailEAIVO.getTitle()); 
				template.setRecipient(rdFaxMailEAIVO.getReceiverEml());
				template.setTextContent(rdFaxMailEAIVO.getContent());
				
				List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOss = new ArrayList<ComRptDsgnXptInfoVO>();
				
				ComRptDsgnXptInfoVO comRptDsgnXptInfoVOa = new ComRptDsgnXptInfoVO();
				comRptDsgnXptInfoVOa.setCreUsrId(rdFaxMailEAIVO.getSenderUsrId());
				comRptDsgnXptInfoVOa.setUpdUsrId(rdFaxMailEAIVO.getSenderUsrId());
				comRptDsgnXptInfoVOa.setRdTmpltNm(rdFaxMailEAIVO.getTmplMrd());
				comRptDsgnXptInfoVOa.setRdParaCtnt(rdFaxMailEAIVO.getTmplParam());
				comRptDsgnXptInfoVOa.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				comRptDsgnXptInfoVOa.setXptFileNm(((new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date())).toString()+"TPB.pdf");
				comRptDsgnXptInfoVOss.add(comRptDsgnXptInfoVOa);
		
				template.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOss);
				strSendKeyVal = template.send();	
			}		
			return strSendKeyVal;
		} catch (MailerAppException ex){
			log.error(ex.getMessage(), ex);
			throw new MailerAppException(new ErrorHandler(ex).getMessage());
		} catch (CheckUtilsException ex){
			log.error(ex.getMessage(), ex);
			throw new CheckUtilsException(new ErrorHandler(ex).getMessage());
		}  catch (Exception e) {
			throw new EventException(e.getMessage()); 
		}
	}
}