/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceEAIDAO.java
*@FileTitle : SEND EMAIL
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.29 정윤태
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvRdApplCdFtpVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvEmailFaxVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvEmlVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssueVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueOptionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.SetupOfficeVO;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.fax.FaxMetaInfo;
import com.clt.framework.component.fax.FaxUtility;
import com.clt.framework.component.javamail.Mail;
import com.clt.framework.component.javamail.MailGroup;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.component.javamail.SingleMailAttachedFile;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.vo.MailGroupResultVO;
import com.clt.framework.core.config.SiteConfigFactory;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.core.layer.integration.EAIException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
import com.clt.framework.component.ftp.FtpException;
import com.clt.framework.component.ftp.FtpMetaInfo;
import com.clt.framework.component.ftp.FtpUtility;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.framework.table.ComFtpSndInfoVO;
import com.clt.framework.component.util.upload.Uploader;

/**
 * InvoiceIssueEAIDAO <br>
 * - AccountReceivableInvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jung Hwi Taek
 * @see InvoiceIssueBCImpl 참조
 * @since J2EE 1.6
 */
public class InvoiceIssueEAIDAO extends EAIDAOSupport { 
	
	/**
	 * Issue 메일을 발송합니다<br>
	 * @param InvIssMainVO issMainVO
	 * @param SignOnUserAccount account
	 * @param String rdType
	 * @return String
	 * @exception EAIException 
	 */	
	public String sendGeneralInvoiceByFaxEmail(InvIssMainVO issMainVO, SignOnUserAccount account, String rdType) throws MailerAppException, EAIException, EventException {
	   	
    	
		String usrId = "";
		String usrNm = "";
		String accountCreUsrId = "";
		String accountUpdUsrId = "";
		
		if(account == null) {
			usrId = issMainVO.getUsrId();
			usrNm = issMainVO.getUsrNm();
			accountCreUsrId = issMainVO.getAccountCreUsrId();
			accountUpdUsrId = issMainVO.getAccountUpdUsrId();
		} else {
			usrId = account.getUsr_id();
			usrNm = account.getUsr_nm();
			accountCreUsrId = account.getCre_usr_id();
			accountUpdUsrId = account.getUpd_usr_id();
		}
	
		
		String sendFlag = issMainVO.getSendFlag();
		log.info("   \n########## issMainVO.getFKey() : "+issMainVO.getFKey());
		
		List<SingleMailAttachedFile> fileList = new ArrayList<SingleMailAttachedFile>();
		
		if(issMainVO.getFKey() != null && !"".equals(issMainVO.getFKey().trim())){
			SingleMailAttachedFile attatchedFile = new SingleMailAttachedFile();
			attatchedFile.setFileKey(issMainVO.getFKey());
			fileList.add(attatchedFile);
		}
		
		Date dt = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
		
		//String file_nm = "COM INV_"+issMainVO.getInvNo()+"_"+issMainVO.getBlSrcNo()+"_"+issMainVO.getVvd()+"_"+sf.format(dt)+".pdf";
		String file_nm = "INV_"+issMainVO.getInvNo()+"_"+issMainVO.getVvd()+"_"+sf.format(dt)+".pdf";
		
		String subject = "";
		String contents = "";
		
		subject = "Invoice Ref # "+issMainVO.getInvNo();
		contents = "**Please do not reply to this e-mail, as it will go to an unmonitored mailbox. If you need any assistance, please contact the appropriate NYK contact in your area.**"		 		
		 + "<br>"
         + "<br>Thank you for shipping with NYK Line. www.nykline.com"
		 + "<br><br>";
				
		String rd_name = issMainVO.getRdName();
		
		String attach = issMainVO.getAttach().equals("1") ? "Y" : "N";
		String attach2 = issMainVO.getAttach2().equals("1") ? "Y" : "N";
		
		String rdParam = "";
		//String logo = "ORIGINAL";
		
	   rdParam = "/rv frm1_inv_no["+issMainVO.getInvNo()+"]"
        + " frm1_logo["+rdType+"] frm1_login_nm ["+usrNm+"]"
        + " frm1_ofc_cd ["+issMainVO.getIssOfcCd()+"] frm1_line_num [15]"
        + " frm1_vsl_cd["+issMainVO.getVvd().substring(0,4)+"]"
        + " frm1_skd_voy_no["+issMainVO.getVvd().substring(4,8)+"]"
        + " frm1_skd_dir_cd["+issMainVO.getVvd().substring(8,9)+"]"
        + " frm1_port_cd ["+issMainVO.getPortCd()+"] frm1_att_gb ["+attach+"]"
        + " frm1_issue_type["+issMainVO.getInvNo().substring(2,3)+"]"
		+ " frm1_customer_name ["+issMainVO.getNameFlag()+"] frm1_title ["+issMainVO.getTitleFlag()+"]"
		+ " frm1_att_gb2["+attach2+"] frm1_cust_cnt_cd["+issMainVO.getCustCd().substring(0,2)+"] frm1_cust_seq["+Integer.parseInt(issMainVO.getCustCd().substring(2,8))+"]";

		if (sendFlag.equals("E")) {
		// Email 발송				
				
			List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
			
			ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();			
			comRptDsgnXptInfoVO.setXptFileNm(file_nm);
			comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			comRptDsgnXptInfoVO.setRdTmpltNm(rd_name);
			comRptDsgnXptInfoVO.setRdParaCtnt(rdParam);
			comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
			comRptDsgnXptInfoVO.setCreUsrId(accountCreUsrId);
			comRptDsgnXptInfoVO.setUpdUsrId(accountUpdUsrId);
			
			try {
				
				Mail mail = new Mail();
				mail.setFrom("shipment.info@notifications.nykline.com");
				mail.setBccRcvrEml("shipinfobcc@na.nykline.com");
				mail.setRecipient(issMainVO.getCustEml());
				mail.setSubject(subject);
				mail.setHtmlContent(contents);
				
				List<SingleMailAttachedFile> list1 = new ArrayList<SingleMailAttachedFile>();
				SingleMailAttachedFile attachedFile1 = new SingleMailAttachedFile();
				attachedFile1.setFileKey(issMainVO.getFKey());
				list1.add(attachedFile1);
				mail.addAttachedFile(list1);
								
				mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
				return mail.send();
				
//			} catch (RDMailSendException e) {
//				throw new EventException(e.getMessage());
			} catch (MailerAppException e) {
				throw new EventException(e.getMessage());
//			} catch (ReportDesignerExportException e) {
//				throw new EventException(e.getMessage());
			} catch (Exception e) {
				throw new EventException(e.getMessage()); 
			}
			
			
		} else {
		// Fax 발송	
			
			try {
				
				FaxMetaInfo info = new FaxMetaInfo("INV",     // 모듈명(ex.BKG)
						                   rd_name,   // MRD 파일 명 (ex.WO_NORMAL.mrd)
								           "N",  // 배치 유무(Y/N)
								           subject,     // 제목
								           rdParam, // RD Parameter (ex. [419][1][selho])
								           issMainVO.getCustNm()+";"+issMainVO.getCustFaxNo(), //이름+FAX번호 (받는 사람1;fax1,받는사람2,fax2)
									       issMainVO.getIssOfcCd(),    // 지역 FAX office
									       //account.getUsr_nm()  // 보내는 사람
									       //2010-06-21 김동진수석
									       usrId  // 보내는 사람
									       ); 
						
				return FaxUtility.registerDB(info);

			} catch (Exception ex){
				throw new EAIException(ex.getMessage(), ex);
			}			
			
		}	
        
	}
	
	/**
	 * Issue 메일을 발송합니다<br>
	 * @param InvIssMainVO issMainVO
	 * @param SignOnUserAccount account
	 * @param String custEml
	 * @param String rdType
	 * @return Mail
	 * @exception EAIException 
	 */	
	public Mail sendGeneralInvoiceByFaxEmailByGroup(InvIssMainVO issMainVO, SignOnUserAccount account, String custEml, String rdType) throws MailerAppException, EAIException, EventException {

		//String usrId = "";
		String usrNm = "";
		String accountCreUsrId = "";
		String accountUpdUsrId = "";
		
		
		
		if(account == null) {
			//usrId = issMainVO.getUsrId();
			usrNm = issMainVO.getUsrNm();
			accountCreUsrId = issMainVO.getAccountCreUsrId();
			accountUpdUsrId = issMainVO.getAccountUpdUsrId();
		} else {
			//usrId = account.getUsr_id();
			usrNm = account.getUsr_nm();
			accountCreUsrId = account.getCre_usr_id();
			accountUpdUsrId = account.getUpd_usr_id();
		}
		
		
		String sendFlag = issMainVO.getSendFlag();
		
		Date dt = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
		
		//String file_nm = "COM INV_"+issMainVO.getInvNo()+"_"+issMainVO.getBlSrcNo()+"_"+issMainVO.getVvd()+"_"+sf.format(dt)+".pdf";
		String file_nm = "INV_"+issMainVO.getInvNo()+"_"+issMainVO.getVvd()+"_"+sf.format(dt)+".pdf";
		
		String subject = "";
		String contents = "";
		
		subject = "Invoice Ref # "+issMainVO.getInvNo();
		contents = "**Please do not reply to this e-mail, as it will go to an unmonitored mailbox. If you need any assistance, please contact the appropriate NYK contact in your area.**"		 		
		 + "<br>"
         + "<br>Thank you for shipping with NYK Line. www.nykline.com"
		 + "<br><br>";
				
		String rd_name = issMainVO.getRdName();
		
		String attach = issMainVO.getAttach().equals("1") ? "Y" : "N";
		
		String rdParam = "";
		
	   rdParam = "/rv frm1_inv_no["+issMainVO.getInvNo()+"]"
        + " frm1_logo["+rdType+"] frm1_login_nm ["+usrNm+"]"
        + " frm1_ofc_cd ["+issMainVO.getIssOfcCd()+"] frm1_line_num [15]"
        + " frm1_vsl_cd["+issMainVO.getVvd().substring(0,4)+"]"
        + " frm1_skd_voy_no["+issMainVO.getVvd().substring(4,8)+"]"
        + " frm1_skd_dir_cd["+issMainVO.getVvd().substring(8,9)+"]"
        + " frm1_port_cd ["+issMainVO.getPortCd()+"] frm1_att_gb [N]"
        + " frm1_issue_type["+issMainVO.getInvNo().substring(2,3)+"]"
		+ " frm1_customer_name ["+issMainVO.getNameFlag()+"] frm1_title ["+issMainVO.getTitleFlag()+"]"
		+ " frm1_att_gb2[N] frm1_cust_cnt_cd[] frm1_cust_seq[]";
		
		log.info("   \n########## file_nm : "+file_nm);
		log.info("   \n########## subject : "+subject);
		log.info("   \n########## contents : "+contents);		
		log.info("   \n########## rd_name : "+rd_name);		
		log.info("   \n########## issMainVO.getIssOfcCd() : "+issMainVO.getIssOfcCd());
		log.info("   \n########## issMainVO.getVvd() : "+issMainVO.getVvd());
		log.info("   \n########## issMainVO.getPortCd() : "+issMainVO.getPortCd());
		log.info("   \n########## attach : "+attach);
		log.info("   \n########## rdParam : "+rdParam);	
		
		Mail mail = new Mail();
		if (sendFlag.equals("E")) {
		// Email 발송		
			
			List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
			
			ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();			
			comRptDsgnXptInfoVO.setXptFileNm(file_nm);
			comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			comRptDsgnXptInfoVO.setRdTmpltNm(rd_name);
			comRptDsgnXptInfoVO.setRdParaCtnt(rdParam);
			comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
			comRptDsgnXptInfoVO.setCreUsrId(accountCreUsrId);
			comRptDsgnXptInfoVO.setUpdUsrId(accountUpdUsrId);
			
			try {
				mail.setFrom("shipment.info@notifications.nykline.com");
				mail.setBccRcvrEml("shipinfobcc@na.nykline.com");
				mail.setRecipient(custEml);
				mail.setSubject(subject);
				mail.setHtmlContent(contents);
				//mail.setRdSubSysCd("INV");
				
				List<SingleMailAttachedFile> attachedFile = new ArrayList<SingleMailAttachedFile>();
				SingleMailAttachedFile singleMailAttachedFile = new SingleMailAttachedFile();
				//singleMailAttachedFile.setFileKey(issMainVO.getFKey());
				singleMailAttachedFile.setFileKey(issMainVO.getFSaveId()); 
				attachedFile.add(singleMailAttachedFile); 
				mail.addAttachedFile(attachedFile);
						
				log.info("   \n########## issMainVO.getFSaveId () 222 : "+issMainVO.getFSaveId()); 
								
				mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
				
//			} catch (RDMailSendException e) {
//				throw new EventException(e.getMessage());
			} catch (Exception e) {
				throw new EventException(e.getMessage()); 
			}
						
		} 
		
		return mail;
        
	}

	/**
	 * Issue 메일을 발송합니다<br>
	 * @param String ofcCd
	 * @param String custEml
	 * @param String vvd
	 * @param String portCd
	 * @param String accountCreUsrId
	 * @param String accountUpdUsrId
	 * @return Mail
	 * @exception EAIException 
	 */	
	public Mail sendGeneralInvoiceByFaxEmailWordingByVVD(String ofcCd, String custEml, String vvd, String portCd, String accountCreUsrId, String accountUpdUsrId ) throws MailerAppException, EAIException, EventException {

		String file_nm = "Wording.pdf";		
		String subject = "Wording Subject";
		String contents = "Wording Contents";
				
		String rd_name = "FNS_INV_0524_vvd.mrd";
		String rdParam = "/rv frm1_ar_ofc_cd["+ofcCd+"] frm1_vsl_cd["+vvd.substring(0,4)+"] frm1_skd_voy_no["+vvd.substring(4,8)+"] frm1_skd_dir_cd["+vvd.substring(8,9)+"] frm1_port_cd ["+portCd+"]";
		
		log.info("   \n########## file_nm : "+file_nm);
		log.info("   \n########## subject : "+subject);
		log.info("   \n########## contents : "+contents);		
		log.info("   \n########## rd_name2 : "+rd_name);		
		log.info("   \n########## rdParam2 : "+rdParam);	
		
		Mail mail = new Mail();
		// Email 발송		
			
		List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
		
		ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();			
		comRptDsgnXptInfoVO.setXptFileNm(file_nm);
		comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
		comRptDsgnXptInfoVO.setRdTmpltNm(rd_name);
		comRptDsgnXptInfoVO.setRdParaCtnt(rdParam);
		comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
		comRptDsgnXptInfoVO.setCreUsrId(accountCreUsrId);
		comRptDsgnXptInfoVO.setUpdUsrId(accountUpdUsrId);
		
		try {
			mail.setFrom("shipment.info@notifications.nykline.com");
			mail.setBccRcvrEml("shipinfobcc@na.nykline.com");
			mail.setRecipient(custEml);
			mail.setSubject(subject);
			mail.setHtmlContent(contents);
						
			mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
			
		} catch (Exception e) {
			throw new EventException(e.getMessage()); 
		}						
		
		return mail;
        
	}
	
	/**
	 * Issue 메일을 발송합니다<br>
	 * @param String ofcCd
	 * @param String custEml
	 * @param String custCd
	 * @param String accountCreUsrId
	 * @param String accountUpdUsrId
	 * @return Mail
	 * @exception EAIException 
	 */	
	public Mail sendGeneralInvoiceByFaxEmailWordingByCust(String ofcCd, String custEml, String custCd, String accountCreUsrId, String accountUpdUsrId) throws MailerAppException, EAIException, EventException {

		String file_nm = "Wording.pdf";		
		String subject = "Wording Subject";
		String contents = "Wording Contents";
				
		String rd_name = "FNS_INV_0524_cust.mrd";
		String rdParam = "/rv frm1_ar_ofc_cd["+ofcCd+"] frm1_cust_cnt_cd["+custCd.substring(0,2)+"] frm1_cust_seq["+Integer.parseInt(custCd.substring(2,8))+"]";
  		
		log.info("   \n########## file_nm : "+file_nm);
		log.info("   \n########## subject : "+subject);
		log.info("   \n########## contents : "+contents);		
		log.info("   \n########## rd_name2 : "+rd_name);		
		log.info("   \n########## rdParam2(cust) : "+rdParam);	
		
		Mail mail = new Mail();
		// Email 발송		
			
		List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
		
		ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();			
		comRptDsgnXptInfoVO.setXptFileNm(file_nm);
		comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
		comRptDsgnXptInfoVO.setRdTmpltNm(rd_name);
		comRptDsgnXptInfoVO.setRdParaCtnt(rdParam);
		comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
		comRptDsgnXptInfoVO.setCreUsrId(accountCreUsrId);
		comRptDsgnXptInfoVO.setUpdUsrId(accountUpdUsrId);
		
		try {
			mail.setFrom("shipment.info@notifications.nykline.com");
			mail.setBccRcvrEml("shipinfobcc@na.nykline.com");
			mail.setRecipient(custEml);
			mail.setSubject(subject);
			mail.setHtmlContent(contents);
						
			mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
			
		} catch (Exception e) {
			throw new EventException(e.getMessage()); 
		}						
		
		return mail;
        
	}	
	
	
	
	/**
	 * Invoice 를 발행하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException, DAOException
	 */
	@SuppressWarnings("unchecked")
	public String getBackEndJobResutIssueGeneralInvoice(String key) throws Exception, DAOException {
		log.info("\n########## key : "+key);	
		try {
			return (String)BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * e-mail, FAX를 전송한다. <br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param IssueOptionVO issOptionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
    public void sendGeneralInvoiceByFaxEmail(InvIssMainVO[] issMainVOs, IssueOptionVO issOptionVO, SignOnUserAccount account) throws EventException {
    	   	
    	
    	String usrId = "";
    	//String usrNm = "";
    	String accountCreUsrId = "";
    	String accountUpdUsrId = "";
    	
    	if(account == null) {
    		usrId = issMainVOs[0].getUsrId();
    		//usrNm = issMainVOs[0].getUsrNm();
    		accountCreUsrId = issMainVOs[0].getAccountCreUsrId();
    		accountUpdUsrId = issMainVOs[0].getAccountUpdUsrId();
    	} else {
    		usrId = account.getUsr_id();
    		//usrNm = account.getUsr_nm();
    		accountCreUsrId = account.getCre_usr_id();
    		accountUpdUsrId = account.getUpd_usr_id();
    	}
    	
    	log.debug("sendGeneralInvoiceByFaxEmail:::usrId:::" + usrId);
    	log.debug("sendGeneralInvoiceByFaxEmail:::accountCreUsrId:::" + accountCreUsrId);
    	log.debug("sendGeneralInvoiceByFaxEmail:::accountUpdUsrId:::" + accountUpdUsrId);
    	
    	
    	String sendFlag = issOptionVO.getSendFlag();
    	String sndNo = "";
    	String vvd = "";
    	String custCd = "";
    	String custEml = "";
    	String custEmlSplit = "";
    	String portCd = "";
    	String attach = "";
    	int attachCnt = 0;
    	String attachView = "";
    	String attach2 = "";
    	int attachCnt2 = 0;
    	String attachView2 = "";    	
    	
    	String subject = "";
		String contents = "";
		
		String invNo = "";
		String blNo = "";
		String newInvNo = "";
		String attachInvNo = "";  //2016.06.30 Adding Rep. Invoice No in file name
		
		List<InvEmlVO> invEmlVOs = new ArrayList<InvEmlVO>();
		InvEmlVO[] invEmlArrayVOs = null;
		
		List<List<MailGroupResultVO>> groupMailKeys = null;
		List<InvEmlVO> invEmlSendNoVOs = new ArrayList<InvEmlVO>();
		String emlSendNoTmp = "";
		String invNoSplit = "";
		
		int mailCapa = 10000000;
		
		Date dt = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("MMM.dd", Locale.ENGLISH);
		
		String ofcCd = issOptionVO.getIssOfcCd();
		String sendType = issOptionVO.getSendType();
		String rdType = "";				
		
		if (sendType.equals("PE2")) {
			rdType = "COPY";
		} else {
			rdType = "ORIGINAL";
		}
		
		String invNoSnd = "";
    	//String rdTypeSnd = "";
    	
    	//String svrId = "";
    	SetupOfficeVO setupOfficeVO = null;
    	String invMltBlIssFlg = "";
    	int blNoCnt = 0;
    	String blNoTitle = "";
    	
    	String issLehbb = issOptionVO.getIssLehbb();;
		String logoGb = issOptionVO.getLogoGb();
		if(issLehbb == null) issLehbb = "";
		if(logoGb == null) logoGb = "";	
		
		// Database Access Object
		InvoiceIssueDBDAO dbDao = new InvoiceIssueDBDAO();
		InvoiceIssueEAIDAO eaiDao = new InvoiceIssueEAIDAO();
		
		if(issLehbb.equals("Y")){
			if(logoGb.equals("1")){
				rdType = "COPIE2";
			}else if(logoGb.equals("2")){
				rdType = "COPIE";
			}else if(logoGb.equals("3")){
				rdType = "COPIE2";
			}
		}
		
		String ofcSprtEmlInvFlg = "N";
		String custSprtEmlInvFlg = "N";
		
		log.info("\n issLehbb================>>>>>>>>>>>"+issLehbb+"::"+logoGb);		
    	try {		
    		
    		// Email 전송 처리
    		if (sendFlag.equals("E")) {
    			
    			//svrId = dbDao.searchSeverId(ofcCd);
    			setupOfficeVO = dbDao.searchSetupOfficeForIssue(ofcCd);
    			if (setupOfficeVO != null) {
    				invMltBlIssFlg = setupOfficeVO.getInvMltBlIssFlg();
    			}
    			
    			ofcSprtEmlInvFlg = dbDao.searchSplitEmailFlagByOffice(ofcCd);
    		    		
	    		// 메일주소별로 Split       			
				for (int i=0; i<issMainVOs.length; i++) {
					
					issMainVOs[i].setSendFlag(issOptionVO.getSendFlag());
					issMainVOs[i].setIssOfcCd(issOptionVO.getIssOfcCd());
//					issMainVOs[i].setRdName(issOptionVO.getRdName());
					issMainVOs[i].setNameFlag(issOptionVO.getNameFlag());
					issMainVOs[i].setTitleFlag(issOptionVO.getTitleFlag());
					issMainVOs[i].setIssueType(issOptionVO.getIssueType());
					
					//office email split flag 가 N이면 customer email split 정보를 한번 더 가져와 체크한다.
					if ("N".equals(ofcSprtEmlInvFlg)) {
						custSprtEmlInvFlg = dbDao.searchSplitEmailFlagByCust(issMainVOs[i].getCustCd().substring(0,2),issMainVOs[i].getCustCd().substring(2) );
					} else {
						custSprtEmlInvFlg = "Y";	
					}
	
					StringTokenizer emlTkn = new StringTokenizer(issMainVOs[i].getCustEml(), ";");
					
				    while (emlTkn.hasMoreTokens()) {
				    	custEmlSplit = emlTkn.nextToken();
				    		
				    	if (!custEmlSplit.equals("")) {				    		
				    		Mail mail = eaiDao.sendGeneralInvoiceByFaxEmailByGroup(issMainVOs[i], account, custEmlSplit, rdType);	

							InvEmlVO invEmlVO = new InvEmlVO();
							
							invEmlVO.setMail(mail);					
							invEmlVO.setCustEml(custEmlSplit);
							invEmlVO.setVvd(issMainVOs[i].getVvd());
							invEmlVO.setCustCd(issMainVOs[i].getCustCd());
							invEmlVO.setInvNo(issMainVOs[i].getInvNo());
							invEmlVO.setBlSrcNo(issMainVOs[i].getInvNo()+" - "+issMainVOs[i].getBlSrcNo().replace("\r\n", "/"));
							invEmlVO.setInvSeq(issMainVOs[i].getInvSeq());
							invEmlVO.setPortCd(issMainVOs[i].getPortCd());
							invEmlVO.setAttach(issMainVOs[i].getAttach());
							invEmlVO.setAttachView(issMainVOs[i].getAttachView());
							invEmlVO.setAttach2(issMainVOs[i].getAttach2());
							invEmlVO.setAttachView2(issMainVOs[i].getAttachView2());
							invEmlVO.setRdType("ORIGINAL");
							invEmlVO.setBlSrcNoTitle(issMainVOs[i].getBlSrcNo());
							invEmlVO.setOfcSprtEmlInvFlg(ofcSprtEmlInvFlg);
							invEmlVO.setCustSprtEmlInvFlg(custSprtEmlInvFlg);
							invEmlVOs.add(invEmlVO);
							
							log.info("\n########## custEmlSplit : "+custEmlSplit);
				    	
				    	}
					
					} 
				    
				    // VLCBB 는 RD 메일에 COPY 본을 하나 추가한다
				    log.info("issOptionVO.getCopyCnt()==========>>>>>>>>"+issOptionVO.getCopyCnt());
				    					
				} // for
				
				log.info("\n########## invEmlVOs.size() : "+invEmlVOs.size());
				
				if (invEmlVOs.size() > 0) {
				
					invEmlArrayVOs = new InvEmlVO[invEmlVOs.size()];
					invEmlArrayVOs = invEmlVOs.toArray(invEmlArrayVOs);
					
					// vvd, cust_cd, mail 별로 Sorting 					
		            for (int i = 0; i < invEmlArrayVOs.length - 1; i++) {
						for(int j = 0; j < invEmlArrayVOs.length - 1; j++){					
							if((invEmlArrayVOs[j].getVvd()+invEmlArrayVOs[j].getCustCd()+invEmlArrayVOs[j].getCustEml()).compareTo(invEmlArrayVOs[j+1].getVvd()+invEmlArrayVOs[j+1].getCustCd()+invEmlArrayVOs[j+1].getCustEml()) > 1){
			                               
				                InvEmlVO invEmlVOTmp = invEmlArrayVOs[j];
			                    invEmlArrayVOs[j] = invEmlArrayVOs[j+1];
			                    invEmlArrayVOs[j+1] = invEmlVOTmp;
			                
			                }	                				
						}				
					}
		            
		            log.info("\n########## invEmlArrayVOs.length : "+invEmlArrayVOs.length);
		            
		            // vvd, custCd, custEml 별로 Grouping 하여 전송		            
		            MailGroup mailGroup = new MailGroup();    	
		            mailGroup.setRdSubSysCd("INV");
		            //log.info("\n########## ofcCd_1 : "+ofcCd);
		            mailGroup.setOfficeCode(ofcCd);
		    		mailGroup.setFrom("shipment.info@notifications.nykline.com");
		    		mailGroup.setBccRcvrEml("shipinfobcc@na.nykline.com");
		    		mailGroup.addMail(invEmlArrayVOs[0].getMail());
		    		invNo = invNo + invEmlArrayVOs[0].getInvNo() + "/";
		    		blNo = blNo + invEmlArrayVOs[0].getBlSrcNo() + "<br>";
		    		blNoTitle = blNoTitle + invEmlArrayVOs[0].getBlSrcNoTitle();
		    		blNoCnt++;
		    		vvd = invEmlArrayVOs[0].getVvd();
		    		portCd = invEmlArrayVOs[0].getPortCd();
		    		custEml = invEmlArrayVOs[0].getCustEml();
		    		attach = invEmlArrayVOs[0].getAttach();
		    		attachView = invEmlArrayVOs[0].getAttachView();
		    		custCd = invEmlArrayVOs[0].getCustCd();
		    		attach2 = invEmlArrayVOs[0].getAttach2();
		    		attachView2 = invEmlArrayVOs[0].getAttachView2();
		    		attachInvNo = invEmlArrayVOs[0].getInvNo(); //2016.06.30 Adding Rep. Invoice No in file name
		    		
		    		if (invEmlArrayVOs[0].getAttach().equals("1")) {
            			attachCnt++;	
            		}
		    		
		    		if (invEmlArrayVOs[0].getAttach2().equals("1")) {
            			attachCnt2++;	
            		}
		    		
		            for(int i = 1; i < invEmlArrayVOs.length ; i++ ){	
		            	
		            	if ( invEmlArrayVOs[i].getOfcSprtEmlInvFlg().equals("N") && invEmlArrayVOs[i].getCustSprtEmlInvFlg().equals("N")   ) { 
		            	
	            	
			            	log.info("\n########## invEmlArrayVOs[i].getCustCd() : "+invEmlArrayVOs[i].getCustCd());
			            	log.info("\n########## invEmlArrayVOs[i].getAttach2() : "+invEmlArrayVOs[i].getAttach2());
			            	log.info("\n########## invEmlArrayVOs[i-1].getAttach2() : "+invEmlArrayVOs[i-1].getAttach2());
			            	
			            	if (invEmlArrayVOs[i].getCustCd().equals(invEmlArrayVOs[i-1].getCustCd()) 
				            	&& (invEmlArrayVOs[i].getAttach2().equals("1") || invEmlArrayVOs[i-1].getAttach2().equals("1"))) {
		            			attachCnt2++;
		            		}
			            	
			            	if (invEmlArrayVOs[i].getVvd().equals(invEmlArrayVOs[i-1].getVvd()) 
			            		&& (invEmlArrayVOs[i].getAttach().equals("1") || invEmlArrayVOs[i-1].getAttach().equals("1"))) {
		            			attachCnt++;	
		            		} 
			            	
			            	if ( invEmlArrayVOs[i].getVvd().equals(invEmlArrayVOs[i-1].getVvd())
			            		&& invEmlArrayVOs[i].getCustCd().equals(invEmlArrayVOs[i-1].getCustCd())
			            		&& invEmlArrayVOs[i].getCustEml().equals(invEmlArrayVOs[i-1].getCustEml())) {
			            				            		
			            		mailGroup.addMail(invEmlArrayVOs[i].getMail());
			            		invNo = invNo + invEmlArrayVOs[i].getInvNo() + "/";
	//		            		if (issOptionVO.getIssOfcCd().equals("VLCBB")) {
	//		            			if(i%2 == 0) {
	//		            				blNo = blNo + invEmlArrayVOs[i].getBlSrcNo() + "<br>";
	//		            				blNoTitle = blNoTitle + invEmlArrayVOs[i].getBlSrcNoTitle();
	//		            				blNoCnt++;
	//		            			}
	//		            		} else {
			            			blNo = blNo + invEmlArrayVOs[i].getBlSrcNo() + "<br>";
			            			blNoTitle = blNoTitle + invEmlArrayVOs[i].getBlSrcNoTitle();
			            			blNoCnt++;
	//		            		}
			            		
			            		vvd = invEmlArrayVOs[i].getVvd();
			            		portCd = invEmlArrayVOs[i].getPortCd();
			            		custEml = invEmlArrayVOs[i].getCustEml();
			            		attach = invEmlArrayVOs[i].getAttach();
			            		attachView = invEmlArrayVOs[i].getAttachView();
			            		custCd = invEmlArrayVOs[i].getCustCd();
					    		attach2 = invEmlArrayVOs[i].getAttach2();
					    		attachView2 = invEmlArrayVOs[i].getAttachView2();		            			            		
			            		
										            			            		
							} else {
	//							
	//							if (invEmlArrayVOs[i].getCustCd().equals(invEmlArrayVOs[i-1].getCustCd()) 
	//								&& (attach2.equals("1") || attachCnt2 > 0) && attachView2.equals("YES")) {
	//								
	//								// custemer 별 letter wordding 추가
	//								Mail wordingMailByCust1 = eaiDao.sendGeneralInvoiceByFaxEmailWordingByCust(issOptionVO.getIssOfcCd(), custEml, custCd, account);
	//								mailGroup.addMail(wordingMailByCust1);
	//							}
								log.info("\n########## invMltBlIssFlg : "+invMltBlIssFlg);
								
								newInvNo = invNo.substring(0, invNo.length()-1);
								subject = "Invoice Ref # "+newInvNo;
								
								contents = "**Please do not reply to this e-mail, as it will go to an unmonitored mailbox. If you need any assistance, please contact the appropriate NYK contact in your area.**"
										 + "<br>"
								         + "<br>Thank you for shipping with NYK Line. www.nykline.com"
										 + "<br><br>";
								mailGroup.setSubject(subject);	
								mailGroup.setHtmlContent(contents);
								
								//////////////////////////////////////////////////////
								
								log.info("\n########## attachCnt_1 : "+attachCnt);
								
	//							if (invEmlArrayVOs[i].getVvd().equals(invEmlArrayVOs[i-1].getVvd()) 
	//								&& (attach.equals("1") || attachCnt > 0) && attachView.equals("YES")) {
	//								
	//								// vvd 별 letter wordding 추가
	//								Mail wordingMailByVVD1 = eaiDao.sendGeneralInvoiceByFaxEmailWordingByVVD(issOptionVO.getIssOfcCd(), custEml, vvd, portCd, account);
	//								mailGroup.addMail(wordingMailByVVD1);
	//								
	//							}
								//groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+".pdf", mailCapa);	
								if (invMltBlIssFlg.equals("N")) {									
									if (blNoCnt > 1) {
										groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+"_"+attachInvNo+".pdf", mailCapa);  //2016.06.30 Adding Rep. Invoice No in file name
									} else {
										groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+"_BL No-"+blNoTitle+".pdf", mailCapa);
									}									
								} else {	
									groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+"_"+attachInvNo+".pdf", mailCapa);  //2016.06.30 Adding Rep. Invoice No in file name
								}
								
								for (int idx1 = 0; idx1 < groupMailKeys.size(); idx1++) {
									
									for (int idx2 = 0; idx2 < groupMailKeys.get(idx1).size(); idx2++) {
										
										log.info("\n########## invNo1 : "+invNo);									
										
										if (!groupMailKeys.get(idx1).get(idx2).getEmlSndNo().equals(emlSendNoTmp)) {
											InvEmlVO invEmlSendNoVO = new InvEmlVO();
											invEmlSendNoVO.setEmlSndNo(groupMailKeys.get(idx1).get(idx2).getEmlSndNo());
											invEmlSendNoVO.setInvNo(invNo);
											invEmlSendNoVO.setCustEml(groupMailKeys.get(idx1).get(idx2).getToEmlCtnt());
											invEmlSendNoVO.setOfcCd(ofcCd);
											invEmlSendNoVOs.add(invEmlSendNoVO);
										}
										
										emlSendNoTmp = groupMailKeys.get(idx1).get(idx2).getEmlSndNo();
										
									}
								}
								
								invNo = "";		
								blNo = "";
								blNoCnt = 0;
								blNoTitle = "";
								attachInvNo = "";  //2016.06.30 Adding Rep. Invoice No in file name
								
								mailGroup = new MailGroup();
								mailGroup.setRdSubSysCd("INV");
								//log.info("\n########## ofcCd_2 : "+ofcCd);
								mailGroup.setOfficeCode(ofcCd);
								mailGroup.setFrom("shipment.info@notifications.nykline.com");
								mailGroup.setBccRcvrEml("shipinfobcc@na.nykline.com");
								mailGroup.addMail(invEmlArrayVOs[i].getMail());
								invNo = invNo + invEmlArrayVOs[i].getInvNo() + "/";
	//							if (issOptionVO.getIssOfcCd().equals("VLCBB")) {
	//		            			if(i%2 == 0) {
	//		            				blNo = blNo + invEmlArrayVOs[i].getBlSrcNo() + "<br>";
	//		            				blNoTitle = blNoTitle + invEmlArrayVOs[i].getBlSrcNoTitle();
	//		            				blNoCnt++;
	//		            			}
	//		            		} else {
			            			blNo = blNo + invEmlArrayVOs[i].getBlSrcNo() + "<br>";
			            			blNoTitle = blNoTitle + invEmlArrayVOs[i].getBlSrcNoTitle();
			            			blNoCnt++;
	//		            		}
								vvd = invEmlArrayVOs[i].getVvd();
								portCd = invEmlArrayVOs[i].getPortCd();
								custEml = invEmlArrayVOs[i].getCustEml();
								attach = invEmlArrayVOs[i].getAttach();
								attachView = invEmlArrayVOs[i].getAttachView();
								custCd = invEmlArrayVOs[i].getCustCd();
					    		attach2 = invEmlArrayVOs[i].getAttach2();
					    		attachView2 = invEmlArrayVOs[i].getAttachView2();
					    		attachInvNo = invEmlArrayVOs[i].getInvNo(); //2016.06.30 Adding Rep. Invoice No in file name
								
							}
		            	} else { // Split 안하겠다. 
		            		
		            		log.debug("no split=============");
		            			            		
		            		
		            		newInvNo = invNo.substring(0, invNo.length()-1);
							subject = "Invoice Ref # "+newInvNo;
							
							contents = "**Please do not reply to this e-mail, as it will go to an unmonitored mailbox. If you need any assistance, please contact the appropriate NYK contact in your area.**"
									 + "<br>"
							         + "<br>Thank you for shipping with NYK Line. www.nykline.com"
									 + "<br><br>";
							mailGroup.setSubject(subject);	
							mailGroup.setHtmlContent(contents);
							
							//////////////////////////////////////////////////////
							
							log.info("\n########## attachCnt_1 : "+attachCnt);
							
//							if (invEmlArrayVOs[i].getVvd().equals(invEmlArrayVOs[i-1].getVvd()) 
//								&& (attach.equals("1") || attachCnt > 0) && attachView.equals("YES")) {
//								
//								// vvd 별 letter wordding 추가
//								Mail wordingMailByVVD1 = eaiDao.sendGeneralInvoiceByFaxEmailWordingByVVD(issOptionVO.getIssOfcCd(), custEml, vvd, portCd, account);
//								mailGroup.addMail(wordingMailByVVD1);
//								
//							}
							//groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+".pdf", mailCapa);	
							if (invMltBlIssFlg.equals("N")) {
								
								if (blNoCnt > 1) {
									groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+"_"+attachInvNo+".pdf", mailCapa);  //2016.06.30 Adding Rep. Invoice No in file name
								} else {
									groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+"_BL No-"+blNoTitle+".pdf", mailCapa);
								}
								
							} else {	
								groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+"_"+attachInvNo+".pdf", mailCapa); //2016.06.30 Adding Rep. Invoice No in file name
							}
							
							for (int idx1 = 0; idx1 < groupMailKeys.size(); idx1++) {
								
								for (int idx2 = 0; idx2 < groupMailKeys.get(idx1).size(); idx2++) {
									
									log.info("\n########## invNo1 : "+invNo);									
									
									if (!groupMailKeys.get(idx1).get(idx2).getEmlSndNo().equals(emlSendNoTmp)) {
										InvEmlVO invEmlSendNoVO = new InvEmlVO();
										invEmlSendNoVO.setEmlSndNo(groupMailKeys.get(idx1).get(idx2).getEmlSndNo());
										invEmlSendNoVO.setInvNo(invNo);
										invEmlSendNoVO.setCustEml(groupMailKeys.get(idx1).get(idx2).getToEmlCtnt());
										invEmlSendNoVO.setOfcCd(ofcCd);
										invEmlSendNoVOs.add(invEmlSendNoVO);
									}
									
									emlSendNoTmp = groupMailKeys.get(idx1).get(idx2).getEmlSndNo();
									
								}
							}
							
							invNo = "";		
							blNo = "";
							blNoCnt = 0;
							blNoTitle = "";
							attachInvNo = "";  //2016.06.30 Adding Rep. Invoice No in file name
							
							mailGroup = new MailGroup();
							mailGroup.setRdSubSysCd("INV");
							//log.info("\n########## ofcCd_2 : "+ofcCd);
							mailGroup.setOfficeCode(ofcCd);
							mailGroup.setFrom("shipment.info@notifications.nykline.com");
							mailGroup.setBccRcvrEml("shipinfobcc@na.nykline.com");
							mailGroup.addMail(invEmlArrayVOs[i].getMail());
							invNo = invNo + invEmlArrayVOs[i].getInvNo() + "/";
//							if (issOptionVO.getIssOfcCd().equals("VLCBB")) {
//		            			if(i%2 == 0) {
//		            				blNo = blNo + invEmlArrayVOs[i].getBlSrcNo() + "<br>";
//		            				blNoTitle = blNoTitle + invEmlArrayVOs[i].getBlSrcNoTitle();
//		            				blNoCnt++;
//		            			}
//		            		} else {
		            			blNo = blNo + invEmlArrayVOs[i].getBlSrcNo() + "<br>";
		            			blNoTitle = blNoTitle + invEmlArrayVOs[i].getBlSrcNoTitle();
		            			blNoCnt++;
//		            		}
							vvd = invEmlArrayVOs[i].getVvd();
							portCd = invEmlArrayVOs[i].getPortCd();
							custEml = invEmlArrayVOs[i].getCustEml();
							attach = invEmlArrayVOs[i].getAttach();
							attachView = invEmlArrayVOs[i].getAttachView();
							custCd = invEmlArrayVOs[i].getCustCd();
				    		attach2 = invEmlArrayVOs[i].getAttach2();
				    		attachView2 = invEmlArrayVOs[i].getAttachView2();
				    		attachInvNo = invEmlArrayVOs[i].getInvNo(); //2016.06.30 Adding Rep. Invoice No in file name

		            	}
		            	    		            	
		            }  // end of for 	
		            
		            log.info("\n########## invMltBlIssFlg2 : "+invMltBlIssFlg);
		            
		            newInvNo = invNo.substring(0, invNo.length()-1);
					subject = "Invoice Ref # "+newInvNo;
					
					contents = "**Please do not reply to this e-mail, as it will go to an unmonitored mailbox. If you need any assistance, please contact the appropriate NYK contact in your area.**"
							 + "<br>"
					         + "<br>Thank you for shipping with NYK Line. www.nykline.com"
							 + "<br><br>";
					
					mailGroup.setSubject(subject);	
					mailGroup.setHtmlContent(contents);
					
					log.info("\n########## attachCnt_2 : "+attachCnt);
		            		
					if ((attach2.equals("1") || attachCnt2 > 0) && attachView2.equals("YES")) {
						
						// customer 별 letter wordding 추가
						Mail wordingMailByCust2 = eaiDao.sendGeneralInvoiceByFaxEmailWordingByCust(issOptionVO.getIssOfcCd(), custEml, custCd, accountCreUsrId, accountUpdUsrId);
						mailGroup.addMail(wordingMailByCust2);
						
					}
												
					if ((attach.equals("1") || attachCnt > 0) && attachView.equals("YES")) {
						
						// vvd 별 letter wordding 추가
						Mail wordingMailByVVD2 = eaiDao.sendGeneralInvoiceByFaxEmailWordingByVVD(issOptionVO.getIssOfcCd(), custEml, vvd, portCd, accountCreUsrId, accountUpdUsrId);
						mailGroup.addMail(wordingMailByVVD2);
						
					}
					
					//groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+".pdf", mailCapa);
					if (invMltBlIssFlg.equals("N")) {
						
						if (blNoCnt > 1) {
							groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+"_"+attachInvNo+".pdf", mailCapa);  //2016.06.30 Adding Rep. Invoice No in file name
						} else {
							groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+"_BL No-"+blNoTitle+".pdf", mailCapa);
						}
						
					} else {							
						groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+"_"+attachInvNo+".pdf", mailCapa);  //2016.06.30 Adding Rep. Invoice No in file name
					}
					
					
					
					// mailGroup 객체에서 Send No 추출					
					for (int idx1 = 0; idx1 < groupMailKeys.size(); idx1++) {
						log.info("\n########## groupMailKeys.size() : "+groupMailKeys.size());
						for (int idx2 = 0; idx2 < groupMailKeys.get(idx1).size(); idx2++) {
							
							log.info("\n########## invNo2 : "+invNo);
							
							if (!groupMailKeys.get(idx1).get(idx2).getEmlSndNo().equals(emlSendNoTmp)) {
								InvEmlVO invEmlSendNoVO = new InvEmlVO();
								invEmlSendNoVO.setEmlSndNo(groupMailKeys.get(idx1).get(idx2).getEmlSndNo());
								invEmlSendNoVO.setInvNo(invNo);
								invEmlSendNoVO.setCustEml(groupMailKeys.get(idx1).get(idx2).getToEmlCtnt());
								invEmlSendNoVO.setOfcCd(ofcCd);
								invEmlSendNoVOs.add(invEmlSendNoVO);
							}
							
							emlSendNoTmp = groupMailKeys.get(idx1).get(idx2).getEmlSndNo();
							
						}
					}
					
					
					//Email Split 과 상관없는 공통영역 ================================================================
					
					
					// 전송정보를 INV_AR_ISS_SND 에 저장
					for (int j = 0; j < invEmlSendNoVOs.size(); j++) {
						
						log.info("\n########## invEmlSendNoVOs.size() : "+invEmlSendNoVOs.size());
						
						StringTokenizer invNoTkn = new StringTokenizer(invEmlSendNoVOs.get(j).getInvNo(), "/");
						while (invNoTkn.hasMoreTokens()) {
					    	invNoSplit = invNoTkn.nextToken();
					    	StringTokenizer invSeqTkn = new StringTokenizer(invNoSplit, "&");
					    	
					    	invNoSnd = invSeqTkn.nextToken();
//					    	rdTypeSnd = invSeqTkn.nextToken();
					    	log.info("\n########## invNoSnd : "+invNoSnd);
//					    	log.info("\n########## rdTypeSnd : "+rdTypeSnd);
					    	
//					    	if (rdTypeSnd.equals("ORIGINAL")) {
					    		dbDao.createSendNo(invNoSnd, "E", invEmlSendNoVOs.get(j), usrId);
//					    	}
					    						    	
						}
						
					}
					
				}	
				
			// FAX 전송 처리	
    		} else if (sendFlag.equals("F")) {
    			
    			InvEmlVO invEmlSendNoVO = new InvEmlVO();
    			rdType = "ORIGINAL";
//    			if(issLehbb.equals("Y")){
//    				if(logoGb.equals("1")){
//    					rdType = "COPIE2";
//    				}else if(logoGb.equals("2")){
//    					rdType = "COPIE";
//    				}else if(logoGb.equals("3")){
//    					rdType = "COPIE2";
//    				}
//    			}
    			log.info("\n issLehbb================>>>>>>>>>>>"+issLehbb+"::"+logoGb);
    			for (int i=0; i<issMainVOs.length; i++) {
    				issMainVOs[i].setSendFlag(issOptionVO.getSendFlag());
    				issMainVOs[i].setIssOfcCd(issOptionVO.getIssOfcCd());
    			//	issMainVOs[i].setRdName(issOptionVO.getRdName());
    				issMainVOs[i].setNameFlag(issOptionVO.getNameFlag());
    				issMainVOs[i].setTitleFlag(issOptionVO.getTitleFlag());
    				issMainVOs[i].setIssueType(issOptionVO.getIssueType());
    				
    				// FAX 전송
    				sndNo = eaiDao.sendGeneralInvoiceByFaxEmail(issMainVOs[i], account, rdType);
    				log.info("\n########## sndNo : "+sndNo);
//    				if(issLehbb.equals("Y") && logoGb.equals("3")){
//    					eaiDao.sendGeneralInvoiceByFaxEmail(issMainVOs[i], account, "COPIE");
//    				}
    				
    				    				
    				invEmlSendNoVO.setCustEml(issMainVOs[i].getCustFaxNo());
    				invEmlSendNoVO.setOfcCd(issOptionVO.getIssOfcCd());
    				invEmlSendNoVO.setEmlSndNo(sndNo);
    				
    				//dbDao.modifySendNo(issMainVOs[i], issOptionVO.getSendFlag(), sndNo, account.getUsr_id());
    				// 전송정보를 INV_AR_ISS_SND 에 저장
    				dbDao.createSendNo(issMainVOs[i].getInvNo(), "F", invEmlSendNoVO, usrId);

    			}
    			
    		}
			
	    } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00066",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00066",new String[]{}).getMessage(), ex);
		}
    	
	}	
    
    /**
	 * FTP로 전송한다. <br>
	 * 
	 * @param InvIssMainVO[] issMainVOs
	 * @param IssueOptionVO issOptionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
    public void sendGeneralInvoiceByFTP(InvIssMainVO[] issMainVOs, IssueOptionVO issOptionVO, SignOnUserAccount account) throws EventException {

    	String usrId = "";
    	
    	if(account == null) {
    		usrId = issMainVOs[0].getUsrId();
    	} else {
    		usrId = account.getUsr_id();
    	}
    	
    	String sendFlag = issOptionVO.getSendFlag();
    	String sndNo = "";
		String sendType = issOptionVO.getSendType();
		String rdType = "";				
		rdType = "ORIGINAL";
		
		if (sendType.equals("PE2")) {
			rdType = "COPY";
		} else {
			rdType = "ORIGINAL";
		}
		
    	String issLehbb = issOptionVO.getIssLehbb();;
		String logoGb = issOptionVO.getLogoGb();
		if(issLehbb == null) issLehbb = "";
		if(logoGb == null) logoGb = "";	
		
		// Database Access Object
		InvoiceIssueDBDAO dbDao = new InvoiceIssueDBDAO();
		InvoiceIssueEAIDAO eaiDao = new InvoiceIssueEAIDAO();
		
		if(issLehbb.equals("Y")){
			if(logoGb.equals("1")){
				rdType = "COPIE2";
			}else if(logoGb.equals("2")){
				rdType = "COPIE";
			}else if(logoGb.equals("3")){
				rdType = "COPIE2";
			}
		}
		log.info("\n issLehbb================>>>>>>>>>>>"+issLehbb+"::"+logoGb);		
    	try {		
    		
    		// FTP 전송 처리
    		if (sendFlag.equals("E")) {
    			
    			InvEmlVO invEmlSendNoVO = new InvEmlVO();
		
	    		// 메일주소별로 Split       			
				for (int i=0; i<issMainVOs.length; i++) {
					issMainVOs[i].setSendFlag(issOptionVO.getSendFlag());
					issMainVOs[i].setIssOfcCd(issOptionVO.getIssOfcCd());
					issMainVOs[i].setNameFlag(issOptionVO.getNameFlag());
					issMainVOs[i].setTitleFlag(issOptionVO.getTitleFlag());
					issMainVOs[i].setIssueType(issOptionVO.getIssueType());
					
					// FTP 전송
    				log.info("\n########## rdType : "+rdType);
    				sndNo = eaiDao.sendGeneralInvoiceByFTP(issMainVOs[i], account, rdType);
    				log.info("\n########## sndNo : "+sndNo);

    				
    				invEmlSendNoVO.setCustEml(issMainVOs[i].getCustEml());
    				invEmlSendNoVO.setOfcCd(issOptionVO.getIssOfcCd());
    				invEmlSendNoVO.setEmlSndNo(sndNo);

    				// 전송정보를 INV_AR_ISS_SND 에 저장
    				dbDao.createSendNo(issMainVOs[i].getInvNo(), "T", invEmlSendNoVO, usrId);
				    					
				} // for
			
    		} 
			
	    } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00066",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00066",new String[]{}).getMessage(), ex);
		}
    	
	}	
    
    /**
	 * Issue FTP를 전송합니다.<br>
	 * @param InvIssMainVO issMainVO
	 * @param SignOnUserAccount account
	 * @param String rdType
	 * @return String
	 * @exception EAIException 
	 */	
	public String sendGeneralInvoiceByFTP(InvIssMainVO issMainVO, SignOnUserAccount account, String rdType) throws FtpException, EAIException, EventException {

		String usrNm = "";
		String usrId = "";
		
		if(account == null) {
			usrNm = issMainVO.getUsrNm();
			usrId = issMainVO.getUsrId();
		} else {
			usrNm = account.getUsr_nm();
			usrId = account.getUsr_id();
		}
		
		String FtpSendNo = "";
		String sendFlag = issMainVO.getSendFlag();
		String file_nm = "/OPUS Invoice/"+issMainVO.getCustCd()+"_"+issMainVO.getInvNo()+".pdf";
		//String FtpServerIp = "10.91.5.40";
		//String FtpUserId = "eSign";
		//String FtpUserPwd = "";
		//String FtpSystemCd = "INV";
		String ExpTpCd = "5";
		String rd_name = issMainVO.getRdName();
		String rdParam = "";
		
		// address
		String FtpServerIp = SubSystemConfigFactory.get("INV.INV_ISSUE.INDIA_FTP_SERVER.SVR_IP");
		String FtpUserId = SubSystemConfigFactory.get("INV.INV_ISSUE.INDIA_FTP_SERVER.USR_ID");
		String FtpUserPwd = SubSystemConfigFactory.get("INV.INV_ISSUE.INDIA_FTP_SERVER.USR_PW");
		
		
		// Database Access Object
		InvoiceIssueDBDAO dbDao = new InvoiceIssueDBDAO();
				
		InvRdApplCdFtpVO invRdApplCdFtp = new InvRdApplCdFtpVO();

		log.info("   \n########## usrId : "+usrId);
		log.info("   \n########## usrNm : "+usrNm);
		log.info("   \n########## file_nm : "+file_nm);
		log.info("   \n########## Ftp_Svr_Ip : "+FtpServerIp);
		log.info("   \n########## Ftp_Usr_Id : "+FtpUserId);	
		log.info("   \n########## Ftp_Usr_Pwd : "+FtpUserPwd);	
		log.info("   \n########## rd_name : "+rd_name);		
		log.info("   \n########## issMainVO.getIssOfcCd() : "+issMainVO.getIssOfcCd());
		log.info("   \n########## issMainVO.getVvd() : "+issMainVO.getVvd());
		log.info("   \n########## issMainVO.getPortCd() : "+issMainVO.getPortCd());
		
	    rdParam = "/rv frm1_inv_no["+issMainVO.getInvNo()+"]"
        + " frm1_logo["+rdType+"] frm1_login_nm ["+usrNm+"]"
        + " frm1_ofc_cd ["+issMainVO.getIssOfcCd()+"] frm1_line_num [15]"
        + " frm1_vsl_cd["+issMainVO.getVvd().substring(0,4)+"]"
        + " frm1_skd_voy_no["+issMainVO.getVvd().substring(4,8)+"]"
        + " frm1_skd_dir_cd["+issMainVO.getVvd().substring(8,9)+"]"
        + " frm1_port_cd ["+issMainVO.getPortCd()+"] frm1_att_gb [N]"
        + " frm1_issue_type["+issMainVO.getInvNo().substring(2,3)+"]"
		+ " frm1_customer_name ["+issMainVO.getNameFlag()+"] frm1_title ["+issMainVO.getTitleFlag()+"]"
		+ " frm1_att_gb2[N] frm1_cust_cnt_cd[] frm1_cust_seq[]";
		
		log.info("   \n########## rdParam : "+rdParam);	
		
		FtpMetaInfo ftpMetaInfo = new FtpMetaInfo();
		if (sendFlag.equals("E")) {
		// FTP 발송		
			try {
				//1.send RD file
				invRdApplCdFtp = dbDao.searchRdApplCdFtp(rd_name);

				log.info("   \n########## setSys_cd : "+invRdApplCdFtp.getRdSubSysCd());
				log.info("   \n########## setTmplMrd : "+invRdApplCdFtp.getRdApplCd());		
				
				ftpMetaInfo.setCreUsrId(usrId);
				ftpMetaInfo.setFtp_svr_ip(FtpServerIp);
				ftpMetaInfo.setFtp_usr_id(FtpUserId);
				ftpMetaInfo.setFtp_usr_pw(FtpUserPwd);
				ftpMetaInfo.setSys_cd(invRdApplCdFtp.getRdSubSysCd());
				ftpMetaInfo.setTmplMrd(invRdApplCdFtp.getRdApplCd());
				ftpMetaInfo.setParaInfoCtnt(rdParam);
				ftpMetaInfo.setFtp_dir_ctnt(file_nm);
				ftpMetaInfo.setExp_tp_cd(ExpTpCd);
				// RD file 전송
				FtpSendNo = FtpUtility.registerDB(ftpMetaInfo);

				//2.send txt file
				String contents = issMainVO.getCustEml();
				String exportFileName = issMainVO.getCustCd()+"_"+issMainVO.getInvNo();
				String exportFilePath = SiteConfigFactory.getWhenNullThrowException("COM.FILE.UPLOAD.STRING");
				String fileExtention = SiteConfigFactory.getWhenNullThrowException("COM.FILE.UPLOAD.STRING.EXT");
				String ftpDirectory = "/OPUS Email/";
				//text file 생성
				Uploader.writeString(contents, exportFileName);
				
				ComFtpSndInfoVO comFtpSndInfoVO = new ComFtpSndInfoVO();
				//COM_FTP_SND_INFO.UPD_USR_ID column
				comFtpSndInfoVO.setCreUsrId(usrId);
				//COM_FTP_SND_INFO.FTP_FILE_PATH_URL_CTNT column
				comFtpSndInfoVO.setFtpFilePathUrlCtnt(exportFilePath + exportFileName + fileExtention);
				//인도 ftp 루트 디렉토리 이 후에 실제로 파일 올릴 경로, COM_FTP_SND_INFO FTP_DIR_CTNT column
				comFtpSndInfoVO.setFtpDirCtnt(ftpDirectory + exportFileName + fileExtention);
				comFtpSndInfoVO.setFtpSvrIp(FtpServerIp);
				comFtpSndInfoVO.setFtpUsrId(FtpUserId);
				comFtpSndInfoVO.setFtpUsrPwd(FtpUserPwd);
				comFtpSndInfoVO.setSubSysCd("INV");  
				//txt file 전송
				FtpUtility.send(comFtpSndInfoVO);
				
//			} catch (RDMailSendException e) {
//				throw new EventException(e.getMessage());
			} catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("INV00066",new String[]{}).getMessage(), ex);
			} catch (Exception e) {
				throw new EventException(e.getMessage()); 
			}
						
		} 
		
		return FtpSendNo;
        
	}
	
	
}
