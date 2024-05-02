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
* --------------------------------------------------------
* History
* 2011.08.04 오요한 [CHM-201111930] Invoice Issue 프로그램 개선
* 2014.08.26 최도순 [CHM-201431413] 미주지역 Inv Issue 프로그램 개발 요청
* 2014.10.07 최도순[CHM-201432279] 미주지역 invoice Issue 메뉴 보완 요청
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvEmailFaxVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvEmlVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceIssueSndToErpVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueOptionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.NYCEmlVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.NYCInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.SetupOfficeVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailGroup;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.vo.MailGroupResultVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;

/**
 * ALPS InvoiceIssueEAIDAO <br>
 * - ALPS-AccountReceivableInvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
		
		//String file_nm = "HJS INV_"+issMainVO.getInvNo()+"_"+issMainVO.getBlSrcNo()+"_"+issMainVO.getVvd()+"_"+sf.format(dt)+".pdf";
		String file_nm = "SML INV_"+issMainVO.getInvNo()+"_"+issMainVO.getVvd()+"_"+sf.format(dt)+".pdf";
		
		String subject = "";
		String contents = "";
		
		if (!issMainVO.getIssOfcCd().equalsIgnoreCase("HKGSC")) {
//			subject = "HJS INV : "+issMainVO.getInvNo()+" - "+issMainVO.getBlSrcNo()+" - "+issMainVO.getVvd();
			subject = "SML INV : "+issMainVO.getInvNo()+" - "+issMainVO.getBlSrcNo()+" - "+issMainVO.getVvd();	
			contents = "Please find attached invoice as detailed below."		 		
	         + "<br>Should you have any query, please respond detailing your query to the sender's email address." 
	         + "<br>"
	         + "<br>Invoice No. "+issMainVO.getInvNo()+" - B/L No. "+issMainVO.getBlSrcNo()+" - VVD "+issMainVO.getVvd()
	         + "<br>"
	         + "<br>*Person in charge : "+account.getUsr_nm()
	         + "<br>"
			 + "<br>Thank you.";
		} else {
//			subject = "HJS INV : "+issMainVO.getInvNo()+" - "+issMainVO.getVvd();
			subject = "SML INV : "+issMainVO.getInvNo()+" - "+issMainVO.getVvd();
			contents = "Please find attached invoice as detailed below."		 		
	         + "<br>Should you have any query, please respond detailing your query to the sender's email address." 
	         + "<br>"
	         + "<br>Invoice No. "+issMainVO.getInvNo()+" - VVD "+issMainVO.getVvd()+" - B/L No."
	         + "<br>"+issMainVO.getBlSrcNo().replace("\r\n", "/")
	         + "<br>"
	         + "<br>*Person in charge : "+account.getUsr_nm()	
	         + "<br>"
			 + "<br>Thank you.";
		}
				
		String rd_name = issMainVO.getRdName();
		if (issMainVO.getIssOfcCd().equals("SGNSC")) {
			if (issMainVO.getInvIssCmbFlg().equals("Y")) {
				rd_name = "FNS_INV_0531_MULTI.mrd";
			} else {
				rd_name = "FNS_INV_0531_SINGLE.mrd";
			}	
		}
		String attach = issMainVO.getAttach().equals("1") ? "Y" : "N";
		String attach2 = issMainVO.getAttach2().equals("1") ? "Y" : "N";
//		String issueType = "";
//		if(issMainVO.getIssOfcCd().equals("DXBSC")){			
//			issueType = issMainVO.getIssueType();
//		}
		
		String rdParam = "";
		//String logo = "ORIGINAL";
		String formOfcCd = issMainVO.getIssOfcCd();
		
		if ("BOMSC".equals(issMainVO.getIssOfcCd()) || "SYDSC".equals(issMainVO.getIssOfcCd()) ||"FXTSC".equals(issMainVO.getIssOfcCd()) || "LEHSC".equals(issMainVO.getIssOfcCd())) {
			formOfcCd = account.getOfc_cd();
		}

		
	    if (issMainVO.getIssOfcCd().equals("SGNSC")) {		                                                    	
		                                 
			rdParam = "/rv frm1_inv_no["+issMainVO.getInvNo()+"]"
	        + " frm1_logo["+rdType+"] frm1_login_nm ["+account.getUsr_nm()+"]"
	        + " frm1_ofc_cd ["+issMainVO.getIssOfcCd()+"] frm1_line_num [15]"
	        + " frm1_vsl_cd["+issMainVO.getVvd().substring(0,4)+"]"
	        + " frm1_skd_voy_no["+issMainVO.getVvd().substring(4,8)+"]"
	        + " frm1_skd_dir_cd["+issMainVO.getVvd().substring(8,9)+"]"
	        + " frm1_port_cd ["+issMainVO.getPortCd()+"] frm1_att_gb ["+attach+"]"
	        + " frm1_issue_type["+issMainVO.getInvNo().substring(2,3)+"] frm1_inv_gb ["+issMainVO.getInvNo().substring(0,1)+"] frm1_ar_ofc_cd["+issMainVO.getIssOfcCd()+"]"
			+ " frm1_customer_name ["+issMainVO.getNameFlag()+"] frm1_title ["+issMainVO.getTitleFlag()+"]"
			+ " frm1_att_gb2["+attach2+"] frm1_cust_cnt_cd["+issMainVO.getCustCd().substring(0,2)+"] frm1_cust_seq["+Integer.parseInt(issMainVO.getCustCd().substring(2,8))+"]";
		
	    } else {

			rdParam = "/rv frm1_inv_no["+issMainVO.getInvNo()+"]"
	        + " frm1_logo["+rdType+"] frm1_login_nm ["+account.getUsr_nm()+"]"
	        + " frm1_ar_if_no ["+issMainVO.getIfNo()+"]"
	        + " frm1_ofc_cd ["+formOfcCd+"] frm1_line_num [15]"
	        + " frm1_vsl_cd["+issMainVO.getVvd().substring(0,4)+"]"
	        + " frm1_skd_voy_no["+issMainVO.getVvd().substring(4,8)+"]"
	        + " frm1_skd_dir_cd["+issMainVO.getVvd().substring(8,9)+"]"
	        + " frm1_port_cd ["+issMainVO.getPortCd()+"] frm1_att_gb ["+attach+"]"
	        + " frm1_issue_type["+issMainVO.getInvNo().substring(2,3)+"]"
			+ " frm1_customer_name ["+issMainVO.getNameFlag()+"] frm1_title ["+issMainVO.getTitleFlag()+"]"
			+ " frm1_att_gb2["+attach2+"] frm1_cust_cnt_cd["+issMainVO.getCustCd().substring(0,2)+"] frm1_cust_seq["+Integer.parseInt(issMainVO.getCustCd().substring(2,8))+"]";

	    }
	
		log.info("   \n########## file_nm : "+file_nm);
		log.info("   \n########## subject : "+subject);
		log.info("   \n########## contents : "+contents);		
		log.info("   \n########## rd_name : "+rd_name);		
		log.info("   \n########## issMainVO.getIssOfcCd() : "+issMainVO.getIssOfcCd());
		log.info("   \n########## issMainVO.getVvd() : "+issMainVO.getVvd());
		log.info("   \n########## issMainVO.getPortCd() : "+issMainVO.getPortCd());
		log.info("   \n########## attach : "+attach);
		log.info("   \n########## rdParam(fax) : "+rdParam);	
		
		if (sendFlag.equals("E")) {
		// Email 발송				
				
			List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
			
			ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();			
			comRptDsgnXptInfoVO.setXptFileNm(file_nm);
			comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			comRptDsgnXptInfoVO.setRdTmpltNm(rd_name);
			comRptDsgnXptInfoVO.setRdParaCtnt(rdParam);
			comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
			comRptDsgnXptInfoVO.setCreUsrId(account.getCre_usr_id());
			comRptDsgnXptInfoVO.setUpdUsrId(account.getUpd_usr_id());
			
			try {
				
				Mail mail = new Mail();
				mail.setFrom(account.getUsr_eml(), account.getUsr_nm());
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
								           issMainVO.getIssOfcCd()+";"+issMainVO.getCustFaxNo(), //이름+FAX번호 (받는 사람1;fax1,받는사람2,fax2)
									       issMainVO.getIssOfcCd(),    // 지역 FAX office
									       //account.getUsr_nm()  // 보내는 사람
									       //2010-06-21 김동진수석
									       account.getUsr_id()  // 보내는 사람
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

		String sendFlag = issMainVO.getSendFlag();
		
		String autoInvIssFlg =  issMainVO.getAutoInvIssFlg();
		String userNm = issMainVO.getUserNm();
		String userEml =issMainVO.getUserEml();
		String personNm = "";
//		String personEml = "";
		String userId = issMainVO.getCreUsrId();
		
		log.info("\n########## issMainVO.getInvNo() : "+issMainVO.getInvNo());
		log.info("\n########## issMainVO.getFKey() : "+issMainVO.getFKey());
		
		Date dt = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
		
		//String file_nm = "HJS INV_"+issMainVO.getInvNo()+"_"+issMainVO.getBlSrcNo()+"_"+issMainVO.getVvd()+"_"+sf.format(dt)+".pdf";
		String file_nm = "SML INV_"+issMainVO.getInvNo()+"_"+issMainVO.getVvd()+"_"+sf.format(dt)+".pdf";
		
		String subject = "";
		String contents = "";
		
        if(autoInvIssFlg.equals("Y")){
        	personNm = userNm;
        }else{
        	personNm = account.getUsr_nm();
        }
		
		if (!issMainVO.getIssOfcCd().equalsIgnoreCase("HKGSC")) {
//			subject = "HJS INV : "+issMainVO.getInvNo()+" - "+issMainVO.getBlSrcNo()+" - "+issMainVO.getVvd();	
			subject = "SML INV : "+issMainVO.getInvNo()+" - "+issMainVO.getBlSrcNo()+" - "+issMainVO.getVvd();
			contents = "Please find attached invoice as detailed below."		 		
	         + "<br>Should you have any query, please respond detailing your query to the sender's email address." 
	         + "<br>"
	         + "<br>Invoice No. "+issMainVO.getInvNo()+" - B/L No. "+issMainVO.getBlSrcNo()+" - VVD "+issMainVO.getVvd()
	         + "<br>"
	         + "<br>*Person in charge : "+personNm
	         + "<br>"
			 + "<br>Thank you.";
		} else {
//			subject = "HJS INV : "+issMainVO.getInvNo()+" - "+issMainVO.getVvd();
			subject = "SML INV : "+issMainVO.getInvNo()+" - "+issMainVO.getVvd();		
			contents = "Please find attached invoice as detailed below."		 		
	         + "<br>Should you have any query, please respond detailing your query to the sender's email address." 
	         + "<br>"
	         + "<br>Invoice No. "+issMainVO.getInvNo()+" - VVD "+issMainVO.getVvd()+" - B/L No."
	         + "<br>"+issMainVO.getBlSrcNo().replace("\r\n", "/")
	         + "<br>"
	         + "<br>*Person in charge : "+personNm	
	         + "<br>"
			 + "<br>Thank you.";
		}
				
		String rd_name = issMainVO.getRdName();
		
		if (issMainVO.getIssOfcCd().equals("SGNSC")) {
			if (issMainVO.getInvIssCmbFlg().equals("Y")) {
				rd_name = "FNS_INV_0531_MULTI.mrd";
			} else {
				rd_name = "FNS_INV_0531_SINGLE.mrd";
			}	
		}
		
		String attach = issMainVO.getAttach().equals("1") ? "Y" : "N";
//		String issueType = "";
//		if(issMainVO.getIssOfcCd().equals("DXBSC")){			
//			issueType = issMainVO.getIssueType();
//		}
		
		String rdParam = "";
		
		String formOfcCd = issMainVO.getIssOfcCd();
		
		if ("BOMSC".equals(issMainVO.getIssOfcCd()) || "SYDSC".equals(issMainVO.getIssOfcCd()) ||"FXTSC".equals(issMainVO.getIssOfcCd()) || "LEHSC".equals(issMainVO.getIssOfcCd())) {
			
			if(autoInvIssFlg.equals("Y")){
				formOfcCd = issMainVO.getIssOfcCd();
			} else {			
				formOfcCd = account.getOfc_cd();
			}

		}
		
	    if (issMainVO.getIssOfcCd().equals("SGNSC")) {		                                                    	
		                                 
	    	rdParam = "/rv frm1_inv_no["+issMainVO.getInvNo()+"]"
	        + " frm1_logo["+rdType+"] frm1_login_nm ["+personNm+"]"
	        + " frm1_ofc_cd ["+issMainVO.getIssOfcCd()+"] frm1_line_num [15]"
	        + " frm1_vsl_cd["+issMainVO.getVvd().substring(0,4)+"]"
	        + " frm1_skd_voy_no["+issMainVO.getVvd().substring(4,8)+"]"
	        + " frm1_skd_dir_cd["+issMainVO.getVvd().substring(8,9)+"]"
	        + " frm1_port_cd ["+issMainVO.getPortCd()+"] frm1_att_gb [N]"
	        + " frm1_issue_type["+issMainVO.getInvNo().substring(2,3)+"] frm1_inv_gb ["+issMainVO.getInvNo().substring(0,1)+"] frm1_ar_ofc_cd["+issMainVO.getIssOfcCd()+"]"
			+ " frm1_customer_name ["+issMainVO.getNameFlag()+"] frm1_title ["+issMainVO.getTitleFlag()+"]"
			+ " frm1_att_gb2[N] frm1_cust_cnt_cd[] frm1_cust_seq[]";
		
	    } else {
	    	
	    	rdParam = "/rv frm1_inv_no["+issMainVO.getInvNo()+"]"
	        + " frm1_logo["+rdType+"] frm1_login_nm ["+personNm+"]"
	        + " frm1_ofc_cd ["+formOfcCd+"] frm1_line_num [15]"
	        + " frm1_ar_if_no ["+issMainVO.getIfNo()+"]"
	        + " frm1_vsl_cd["+issMainVO.getVvd().substring(0,4)+"]"
	        + " frm1_skd_voy_no["+issMainVO.getVvd().substring(4,8)+"]"
	        + " frm1_skd_dir_cd["+issMainVO.getVvd().substring(8,9)+"]"
	        + " frm1_port_cd ["+issMainVO.getPortCd()+"] frm1_att_gb [N]"
	        + " frm1_issue_type["+issMainVO.getInvNo().substring(2,3)+"]"
			+ " frm1_customer_name ["+issMainVO.getNameFlag()+"] frm1_title ["+issMainVO.getTitleFlag()+"]"
			+ " frm1_att_gb2[N] frm1_cust_cnt_cd[] frm1_cust_seq[]";

	    }
		
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
	        if(autoInvIssFlg.equals("Y")){
				comRptDsgnXptInfoVO.setCreUsrId(userId);
				comRptDsgnXptInfoVO.setUpdUsrId(userId);
	        }else{
				comRptDsgnXptInfoVO.setCreUsrId(account.getCre_usr_id());
				comRptDsgnXptInfoVO.setUpdUsrId(account.getUpd_usr_id());
	        }

			try {
				if(autoInvIssFlg.equals("Y")){
					mail.setFrom(userEml, userNm);
				}else{
					mail.setFrom(account.getUsr_eml(), account.getUsr_nm());
				}
				mail.setRecipient(custEml);
				mail.setSubject(subject);
				mail.setHtmlContent(contents);
				//mail.setRdSubSysCd("INV");
				
				List<SingleMailAttachedFile> attachedFile = new ArrayList<SingleMailAttachedFile>();
				SingleMailAttachedFile singleMailAttachedFile = new SingleMailAttachedFile();
				singleMailAttachedFile.setFileKey(issMainVO.getFKey());
				attachedFile.add(singleMailAttachedFile);
				mail.addAttachedFile(attachedFile);
						
				log.info("   \n########## issMainVO.getFKey()222 : "+issMainVO.getFKey());
								
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
	 * @param SignOnUserAccount account
	 * @param String autoInvIssFlg
	 * @param String userId
	 * @param String userEml
	 * @param String userNm
	 * @return Mail
	 * @exception EAIException 
	 */	
	public Mail sendGeneralInvoiceByFaxEmailWordingByVVD(String ofcCd, String custEml, String vvd, String portCd, SignOnUserAccount account, String autoInvIssFlg, String userId, String userEml, String userNm) throws MailerAppException, EAIException, EventException {

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
		
		if(autoInvIssFlg.equals("Y")){
			comRptDsgnXptInfoVO.setCreUsrId(userId);
			comRptDsgnXptInfoVO.setUpdUsrId(userId);
		} else {
			comRptDsgnXptInfoVO.setCreUsrId(account.getCre_usr_id());
			comRptDsgnXptInfoVO.setUpdUsrId(account.getUpd_usr_id());
		}

		
		try {
			
			if(autoInvIssFlg.equals("Y")){
				mail.setFrom(userEml, userNm);
			} else {
				mail.setFrom(account.getUsr_eml(), account.getUsr_nm());
			}
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
	 * @param SignOnUserAccount account
	 * @param String autoInvIssFlg
	 * @param String userId
	 * @param String userEml
	 * @param String userNm
	 * @return Mail
	 * @exception EAIException 
	 */	
	public Mail sendGeneralInvoiceByFaxEmailWordingByCust(String ofcCd, String custEml, String custCd, SignOnUserAccount account, String autoInvIssFlg, String userId, String userEml, String userNm) throws MailerAppException, EAIException, EventException {

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
		if(autoInvIssFlg.equals("Y")){
			comRptDsgnXptInfoVO.setCreUsrId(userId);
			comRptDsgnXptInfoVO.setUpdUsrId(userId);
		} else {
			comRptDsgnXptInfoVO.setCreUsrId(account.getCre_usr_id());
			comRptDsgnXptInfoVO.setUpdUsrId(account.getUpd_usr_id());
		}

		
		try {
			if(autoInvIssFlg.equals("Y")){
				mail.setFrom(userEml, userNm);
			} else {
				mail.setFrom(account.getUsr_eml(), account.getUsr_nm());
			}

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
	 * 
	 * @param InvEmailFaxVO invEmailFaxVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EAIException 
	 */	
	public String sendKORInvoiceByFaxEmail(InvEmailFaxVO invEmailFaxVO, SignOnUserAccount account) throws MailerAppException, EAIException, EventException {
		String sendFlag = invEmailFaxVO.getSendFlg();
		
		Date dt = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		
//		String file_nm = "HANJIN SHIPPING FREIGHT INVOICE("+invEmailFaxVO.getFileName()+")_"+sf.format(dt)+".pdf";
//		String subject = "HANJIN SHIPPING FREIGHT INVOICE("+invEmailFaxVO.getSubject()+")";
		String file_nm = "SM LINE CORPORATION FREIGHT INVOICE("+invEmailFaxVO.getFileName()+")_"+sf.format(dt)+".pdf";
		String subject = "SM LINE CORPORATION FREIGHT INVOICE("+invEmailFaxVO.getSubject()+")";
	
//		String contents = "안녕하세요. 한진해운입니다."
		String contents = "안녕하세요. SM상선입니다."		
         + "<br>귀하께서 요청하신 B/L No("+invEmailFaxVO.getSubject()+")에 대한 FREIGHT INVOICE가 발행되었습니다." 
         + "<br>첨부 확인 해 주시기 바랍니다."
         + "<br>확인 후 이상이 있으면 아래 담당자에게 문의하시기 바랍니다."
//         + "<br>관련 INVOICE 출력은 한진해운 홈페이지에서도 가능하오니 많은 이용 바랍니다."
//         + "<br><a target='_blank' title='http://hantax.hanjin.com/' href='http://hantax.hanjin.com/' target='_blank'><FONT face='돋움'>http://hantax.hanjin.com/</FONT></A> "
         + "<br>관련 INVOICE 출력은 SM상선 홈페이지에서도 가능하오니 많은 이용 바랍니다."
         + "<br><a target='_blank' title='http://smltax.smlines.com/' href='http://smltax.smlines.com/' target='_blank'><FONT face='돋움'>http://smltax.smlines.com/</FONT></A> "
         + "<br>"
         + "<br>담당자 : "+account.getUsr_nm()+"("+account.getXtn_phn_no()+")";

		String rd_name = "FNS_INV_0519.mrd";
		String rdParam = "/rv frm1_inv_no["+invEmailFaxVO.getInvNo()+"] frm1_inv_seq["+invEmailFaxVO.getInvSeq()+"] frm1_ar_ofc_cd ["+invEmailFaxVO.getArOfcCd()+"]";
		
		// Email 발송
		Mail mail = new Mail();
		if (sendFlag.equals("E")) {			
			
			List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();

			ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();			
			comRptDsgnXptInfoVO.setXptFileNm(file_nm);
			comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
			comRptDsgnXptInfoVO.setRdTmpltNm(rd_name);
			comRptDsgnXptInfoVO.setRdParaCtnt(rdParam);
			comRptDsgnXptInfoVO.setCreUsrId(account.getCre_usr_id());
			comRptDsgnXptInfoVO.setUpdUsrId(account.getUpd_usr_id());
			
			comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
			
			try {
				
				mail.setFrom(account.getUsr_eml(), account.getUsr_nm());
				mail.setRecipient(invEmailFaxVO.getRecipient());
				mail.setSubject(subject);
				mail.setHtmlContent(contents);
				mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
				return mail.send();
			} catch (MailerAppException e) {
				throw new EventException(e.getMessage(), e);
			} catch (Exception e) {
				throw new EventException(e.getMessage(), e);
			}
		}
		// Fax 발송	
		else {
			try {
				FaxMetaInfo info = new FaxMetaInfo("INV",     // 모듈명(ex.BKG)
						                   "FNS_INV_0519.mrd",   // MRD 파일 명 (ex.WO_NORMAL.mrd)
								           "N",  // 배치 유무(Y/N)
								           subject,     // 제목
								           rdParam, // RD Parameter (ex. [419][1][selho])
								           //invEmailFaxVO.getArOfcCd()+";5336", //22층 테스트 용 번호
								           invEmailFaxVO.getArOfcCd()+";"+invEmailFaxVO.getRecipient(), //이름+FAX번호 (받는 사람1;fax1,받는사람2,fax2)
								           invEmailFaxVO.getArOfcCd(),    // 지역 FAX office
									       //account.getUsr_nm()  // 보내는 사람
								           //2010-06-21 김동진수석
								           account.getUsr_id()
									       );
				
				return FaxUtility.registerDB(info);
			} catch (Exception ex){
				throw new EAIException(ex.getMessage(), ex);
			}			
		}	
	}
	
	/**
	 * Invoice 를 발행하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return InvoiceIssueSndToErpVO
	 * @throws Exception
	 * @throws DAOException
	 */
	public InvoiceIssueSndToErpVO getBackEndJobResutIssueGeneralInvoice(String key) throws Exception, DAOException {
		log.info("\n########## key : "+key);	
		try {
			return (InvoiceIssueSndToErpVO)BackEndJobResult.loadFromFile(key);
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
		
		String autoInvIssFlg = "";
		String userNm = "";
		String userEml = "";
		String personNm = "";
//		String personEml = "";
		String userId = "";
		
		List<InvEmlVO> invEmlVOs = new ArrayList<InvEmlVO>();
		InvEmlVO[] invEmlArrayVOs = null;
		
		// cust의 eml flg가 Separate인 경우
		List<InvIssMainVO> invIssMainVOs = new ArrayList<InvIssMainVO>();
		
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
    	String rdTypeSnd = "";
    	
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
		log.info("\n issLehbb================>>>>>>>>>>>"+issLehbb+"::"+logoGb);		
    	try {		
    		
    		// Email 전송 처리
    		if (sendFlag.equals("E")) {
    			
    			//svrId = dbDao.searchSeverId(ofcCd);
    			setupOfficeVO = dbDao.searchSetupOfficeForIssue(ofcCd);
    			if (setupOfficeVO != null) {
    				invMltBlIssFlg = setupOfficeVO.getInvMltBlIssFlg();
    			}
    		    		
	    		// 메일주소별로 Split       			
				for (int i=0; i<issMainVOs.length; i++) {
					
					issMainVOs[i].setSendFlag(issOptionVO.getSendFlag());
					issMainVOs[i].setIssOfcCd(issOptionVO.getIssOfcCd());
					issMainVOs[i].setRdName(issOptionVO.getRdName());
					issMainVOs[i].setNameFlag(issOptionVO.getNameFlag());
					issMainVOs[i].setTitleFlag(issOptionVO.getTitleFlag());
					issMainVOs[i].setIssueType(issOptionVO.getIssueType());
	
					
					autoInvIssFlg = issMainVOs[0].getAutoInvIssFlg();
					userEml = issMainVOs[0].getUserEml();
					userNm = issMainVOs[0].getUserNm();
					userId = issMainVOs[0].getCreUsrId();
					
					StringTokenizer emlTkn = new StringTokenizer(issMainVOs[i].getCustEml(), ";");
					
					
					// cust의 정보가 Separate인 경우 Separate용 Vo에 담는다.
					if (issMainVOs[i].getInvEmlSplitFlg().equals("Y")){
						invIssMainVOs.add(issMainVOs[i]);
						continue;
					} 
					
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
							invEmlVOs.add(invEmlVO);
							
							log.info("\n########## custEmlSplit : "+custEmlSplit);
				    	
				    	}
					
					} 
				    
				    //LEHSC 일 경우, logoGb 체크하여 추가한다
				    if (issLehbb.equals("Y") && logoGb.equals("3")) {
				    	
					    StringTokenizer emlTkn2 = new StringTokenizer(issMainVOs[i].getCustEml(), ";");
						
					    while (emlTkn2.hasMoreTokens()) {
					    	custEmlSplit = emlTkn2.nextToken();
					    		
					    	if (!custEmlSplit.equals("")) {
								Mail mail = eaiDao.sendGeneralInvoiceByFaxEmailByGroup(issMainVOs[i], account, custEmlSplit, "COPY");		
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
								invEmlVO.setRdType("COPY");
								invEmlVO.setBlSrcNoTitle(issMainVOs[i].getBlSrcNo());
								invEmlVOs.add(invEmlVO);													    	
					    	}
						
						}
				    }    
				    
            		//CHM-201218430	유럽지역 invoice issue 보완 요청(INV copy 수 관련) 대응
				    // VLCBB 는 RD 메일에 COPY 본을 하나 추가한다
//				    log.info("issOptionVO.getCopyCnt()==========>>>>>>>>"+issOptionVO.getCopyCnt());
//				    String copyCnt = issOptionVO.getCopyCnt();
//				    int copyCntInt = 0;
//				    if(copyCnt != null && !copyCnt.equals("")){
//				    	copyCntInt = Integer.parseInt(copyCnt);
//				    }
//				    if (issOptionVO.getIssOfcCd().equals("VLCBB") && !sendType.equals("PE2")) {
//				    	
//					    StringTokenizer emlTkn2 = new StringTokenizer(issMainVOs[i].getCustEml(), ";");
//						
//					    while (emlTkn2.hasMoreTokens()) {
//					    	custEmlSplit = emlTkn2.nextToken();
//					    		
//					    	if (!custEmlSplit.equals("")) {
//								Mail mail = eaiDao.sendGeneralInvoiceByFaxEmailByGroup(issMainVOs[i], account, custEmlSplit, "COPY");		
//								InvEmlVO invEmlVO = new InvEmlVO();
//								
//								invEmlVO.setMail(mail);					
//								invEmlVO.setCustEml(custEmlSplit);
//								invEmlVO.setVvd(issMainVOs[i].getVvd());
//								invEmlVO.setCustCd(issMainVOs[i].getCustCd());
//								invEmlVO.setInvNo(issMainVOs[i].getInvNo());
//								invEmlVO.setBlSrcNo(issMainVOs[i].getInvNo()+" - "+issMainVOs[i].getBlSrcNo().replace("\r\n", "/"));
//								invEmlVO.setInvSeq(issMainVOs[i].getInvSeq());
//								invEmlVO.setPortCd(issMainVOs[i].getPortCd());
//								invEmlVO.setAttach(issMainVOs[i].getAttach());
//								invEmlVO.setAttachView(issMainVOs[i].getAttachView());
//								invEmlVO.setAttach2(issMainVOs[i].getAttach2());
//								invEmlVO.setAttachView2(issMainVOs[i].getAttachView2());
//								invEmlVO.setRdType("COPY");
//								invEmlVO.setBlSrcNoTitle(issMainVOs[i].getBlSrcNo());
//								if(copyCntInt <= 1){
//									invEmlVOs.add(invEmlVO);
//								}else{
//									for(int k = 0; k<copyCntInt; k++){
//										invEmlVOs.add(invEmlVO);
//									}
//								}
//					    	
//					    	}
//						
//						} 	
//				    
//				    }
				    					
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
					
		            
		            // vvd, custCd, custEml 별로 Grouping 하여 전송		            
		            MailGroup mailGroup = new MailGroup();    	
		            mailGroup.setRdSubSysCd("INV");
		            //log.info("\n########## ofcCd_1 : "+ofcCd);
		            mailGroup.setOfficeCode(ofcCd);
		            if(autoInvIssFlg.equals("Y")){
		            	mailGroup.setFrom(userEml, userNm);
		            }else{
			    		mailGroup.setFrom(account.getUsr_eml(), account.getUsr_nm());
		            }
		    		mailGroup.addMail(invEmlArrayVOs[0].getMail());
		    		invNo = invNo + invEmlArrayVOs[0].getInvNo() + "&" + invEmlArrayVOs[0].getRdType()+ "/";
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
		    		
		    		if (invEmlArrayVOs[0].getAttach().equals("1")) {
            			attachCnt++;	
            		}
		    		
		    		if (invEmlArrayVOs[0].getAttach2().equals("1")) {
            			attachCnt2++;	
            		}
		    		
		            for(int i = 1; i < invEmlArrayVOs.length ; i++ ){		
		            	
						log.info("\n########## invEmlArrayVOs[i].getCustCd() : "+invEmlArrayVOs[i].getCustCd());
						log.info("\n########## invEmlArrayVOs[i-1].getCustCd() : "+invEmlArrayVOs[i-1].getCustCd()); 
		            	
		            	if (!invEmlArrayVOs[i].getCustCd().equals(invEmlArrayVOs[i-1].getCustCd())) {

		            		// custemer 별 letter wordding 추가
		            		if ((attach2.equals("1") || attachCnt2 > 0) && attachView2.equals("YES")) {
		            			Mail wordingMailByCust = eaiDao.sendGeneralInvoiceByFaxEmailWordingByCust(issOptionVO.getIssOfcCd(), custEml, custCd, account, autoInvIssFlg, userId, userEml, userNm);
								mailGroup.addMail(wordingMailByCust);
		            		}		            		

		            		attachCnt2 = 0;
		            		
		            	}
		            	
		            	if (!invEmlArrayVOs[i].getVvd().equals(invEmlArrayVOs[i-1].getVvd())) {

		            		// vvd 별 letter wordding 추가
		            		if ((attach.equals("1") || attachCnt > 0) && attachView.equals("YES")) {
		            			Mail wordingMailByVVD = eaiDao.sendGeneralInvoiceByFaxEmailWordingByVVD(issOptionVO.getIssOfcCd(), custEml, vvd, portCd, account, autoInvIssFlg, userId, userEml, userNm);
								mailGroup.addMail(wordingMailByVVD);
		            		}		            		

		            		attachCnt = 0;
		            		
		            	}
		            	
		            	log.info("\n########## invEmlVOs.size()1 : "+invEmlArrayVOs[i].getCustCd());
		            	log.info("\n########## invEmlVOs.size()2 : "+invEmlArrayVOs[i].getAttach2());
		            	log.info("\n########## invEmlVOs.size()3 : "+invEmlArrayVOs[i-1].getAttach2());
		            	
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
		            		invNo = invNo + invEmlArrayVOs[i].getInvNo() + "&" + invEmlArrayVOs[i].getRdType() + "/";
		            		
		            		//CHM-201218430	유럽지역 invoice issue 보완 요청(INV copy 수 관련) 대응
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
							
							if (invEmlArrayVOs[i].getCustCd().equals(invEmlArrayVOs[i-1].getCustCd()) 
								&& (attach2.equals("1") || attachCnt2 > 0) && attachView2.equals("YES")) {
								
								// custemer 별 letter wordding 추가
								Mail wordingMailByCust1 = eaiDao.sendGeneralInvoiceByFaxEmailWordingByCust(issOptionVO.getIssOfcCd(), custEml, custCd, account, autoInvIssFlg, userId, userEml, userNm);
								mailGroup.addMail(wordingMailByCust1);
							}
							log.info("\n########## invMltBlIssFlg : "+invMltBlIssFlg);
							
							if (invMltBlIssFlg.equals("N")) {
								if (blNoCnt > 1) {
//									subject = "HJS INV : VVD - "+vvd;
									subject = "SML INV : VVD - "+vvd;
								} else {
//									subject = "HJS INV : VVD - "+vvd+"_B/L No - "+blNoTitle;
									subject = "SML INV : VVD - "+vvd+"_B/L No - "+blNoTitle;
								}
								
							} else {							
//								subject = "HJS INV : VVD - "+vvd;
								subject = "SML INV : VVD - "+vvd;
							}
							
							if(autoInvIssFlg.equals("Y")){
								personNm = userNm;
							} else {
								personNm = account.getUsr_nm();
							}
							
							if(ofcCd.equals("FXTSC")){
								contents = "Please find attached invoice as detailed below."		 		
								         + "<br>Should you have any query, please respond detailing your query to the sender's email address." 
								         + "<br>"					         
								         + "<br>Invoices are as followings,"
								         + "<br>"
								         + "<br>Invoice No.          &nbsp;&nbsp;&nbsp;B/L No"
								         + "<br>========================"
								         + "<br>"+blNo
								         + "<br>*Person in charge : "+personNm
								         + "<br>"
										 + "<br>Thank you."
										 + "<br>Contact Information for SM Line Corporation Felixstowe Branch Office: "
										 + "<br>UK Import Merchant Haulage Release Team: 01394 606833 – ukreleases@uk.hanjin.com "
										 + "<br>UK Import Carrier Haulage Team: 01394 606834 – ukdeliveries@uk.hanjin.com "
										 + "<br>Accounts Receivable Team: 01394 606835 – fxtar@uk.hanjin.com "
										 + "<br>Import Documentation Team: 01394 606836 – importdocs@uk.hanjin.com "
										 + "<br>Export Documentation Team : 01394 606815 – documentation@uk.hanjin.com ";
							}else if(ofcCd.equals("HAMSC")){
								contents = "Please find attached invoice as detailed below."		 		
								         + "<br>Should you have any query, please respond detailing your query to the sender's email address." 
								         + "<br>"
								         + "<br>Invoice No.          &nbsp;&nbsp;&nbsp;B/L No"
								         + "<br>========================"
								         + "<br>"+blNo
								         + "<br>*Person in charge : "+personNm
								         + "<br>"
										 + "<br>Thank you.";
							}else{ 
								contents = "Please find attached invoice as detailed below."		 		
								         + "<br>Should you have any query, please respond detailing your query to the sender's email address." 
								         + "<br>"					         
								         + "<br>Invoices are as followings,"
								         + "<br>"
								         + "<br>Invoice No.          &nbsp;&nbsp;&nbsp;B/L No"
								         + "<br>========================"
								         + "<br>"+blNo
								         + "<br>*Person in charge : "+personNm
								         + "<br>"
										 + "<br>Thank you.";
							}
							  

							mailGroup.setSubject(subject);	
							mailGroup.setHtmlContent(contents);
							
							//////////////////////////////////////////////////////
							
							log.info("\n########## attachCnt_1 : "+attachCnt);
							
							if (invEmlArrayVOs[i].getVvd().equals(invEmlArrayVOs[i-1].getVvd()) 
								&& (attach.equals("1") || attachCnt > 0) && attachView.equals("YES")) {
								
								// vvd 별 letter wordding 추가
								Mail wordingMailByVVD1 = eaiDao.sendGeneralInvoiceByFaxEmailWordingByVVD(issOptionVO.getIssOfcCd(), custEml, vvd, portCd, account, autoInvIssFlg, userId, userEml, userNm);
								mailGroup.addMail(wordingMailByVVD1);
								
							}
							//groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+".pdf", mailCapa);	
							if (invMltBlIssFlg.equals("N")) {
								
								if (blNoCnt > 1) {
									groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+".pdf", mailCapa);
								} else {
									groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+"_BL No-"+blNoTitle+".pdf", mailCapa);
								}
								
							} else {							
								groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+".pdf", mailCapa);
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
							
							mailGroup = new MailGroup();
							mailGroup.setRdSubSysCd("INV");
							//log.info("\n########## ofcCd_2 : "+ofcCd);
							mailGroup.setOfficeCode(ofcCd);
							if(autoInvIssFlg.equals("Y")){
								mailGroup.setFrom(userEml, userNm);
							} else {
								mailGroup.setFrom(account.getUsr_eml(), account.getUsr_nm());
							}
							mailGroup.addMail(invEmlArrayVOs[i].getMail());
							invNo = invNo + invEmlArrayVOs[i].getInvNo() + "&" + invEmlArrayVOs[i].getRdType() + "/";
							
							//CHM-201218430	유럽지역 invoice issue 보완 요청(INV copy 수 관련) 대응
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
							
						}
		            	    		            	
		            }	
		            
		            log.info("\n########## invMltBlIssFlg2 : "+invMltBlIssFlg);
		            	
		            if (invMltBlIssFlg.equals("N")) {
						if (blNoCnt > 1) {
//							subject = "HJS INV : VVD - "+vvd;
							subject = "SML INV : VVD - "+vvd;
						} else {
//							subject = "HJS INV : VVD - "+vvd+"_B/L No - "+blNoTitle;
							subject = "SML INV : VVD - "+vvd+"_B/L No - "+blNoTitle;
						}
						
					} else {							
//						subject = "HJS INV : VVD - "+vvd;
						subject = "SML INV : VVD - "+vvd;
					}
		            
					if(autoInvIssFlg.equals("Y")){
						personNm = userNm;
					} else {
						personNm = account.getUsr_nm();
					}
		            
					if(ofcCd.equals("FXTSC")){
						contents = "Please find attached invoice as detailed below."		 		
						         + "<br>Should you have any query, please respond detailing your query to the sender's email address." 
						         + "<br>"
						         + "<br>Invoices are as followings,"
						         + "<br>"
						         + "<br>Invoice No.          &nbsp;&nbsp;&nbsp;B/L No"
						         + "<br>========================"
						         + "<br>"+blNo
						         + "<br>*Person in charge : "+personNm
						         + "<br>"
								 + "<br>Thank you."
						         + "<br>"
								 + "<br>Contact Information for SM Line Corporation Felixstowe Branch Office: "
								 + "<br>UK Import Merchant Haulage Release Team: 01394 606833 – ukreleases@uk.hanjin.com "
								 + "<br>UK Import Carrier Haulage Team: 01394 606834 – ukdeliveries@uk.hanjin.com "
								 + "<br>Accounts Receivable Team: 01394 606835 – fxtar@uk.hanjin.com "
								 + "<br>Import Documentation Team: 01394 606836 – importdocs@uk.hanjin.com "
								 + "<br>Export Documentation Team : 01394 606815 – documentation@uk.hanjin.com ";					         
					}else if(ofcCd.equals("HAMSC")){
						contents = "Please find attached invoice as detailed below."		 		
						         + "<br>Should you have any query, please respond detailing your query to the sender's email address." 
						         + "<br>"
						         + "<br>Invoice No.          &nbsp;&nbsp;&nbsp;B/L No"
						         + "<br>========================"
						         + "<br>"+blNo
						         + "<br>*Person in charge : "+personNm
						         + "<br>"
								 + "<br>Thank you.";
					}else{
						contents = "Please find attached invoice as detailed below."		 		
						         + "<br>Should you have any query, please respond detailing your query to the sender's email address." 
						         + "<br>"
						         + "<br>Invoices are as followings,"
						         + "<br>"
						         + "<br>Invoice No.          &nbsp;&nbsp;&nbsp;B/L No"
						         + "<br>========================"
						         + "<br>"+blNo
						         + "<br>*Person in charge : "+personNm
						         + "<br>"
								 + "<br>Thank you.";
					}

					mailGroup.setSubject(subject);	
					mailGroup.setHtmlContent(contents);
					
					log.info("\n########## attachCnt_2 : "+attachCnt);
		            		
					if ((attach2.equals("1") || attachCnt2 > 0) && attachView2.equals("YES")) {
						
						// customer 별 letter wordding 추가
						Mail wordingMailByCust2 = eaiDao.sendGeneralInvoiceByFaxEmailWordingByCust(issOptionVO.getIssOfcCd(), custEml, custCd, account, autoInvIssFlg, userId, userEml, userNm);
						mailGroup.addMail(wordingMailByCust2);
						
					}
												
					if ((attach.equals("1") || attachCnt > 0) && attachView.equals("YES")) {
						
						// vvd 별 letter wordding 추가
						Mail wordingMailByVVD2 = eaiDao.sendGeneralInvoiceByFaxEmailWordingByVVD(issOptionVO.getIssOfcCd(), custEml, vvd, portCd, account, autoInvIssFlg, userId, userEml, userNm);
						mailGroup.addMail(wordingMailByVVD2);
						
					}
					
					//groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+".pdf", mailCapa);
					if (invMltBlIssFlg.equals("N")) {
						
						if (blNoCnt > 1) {
							groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+".pdf", mailCapa);
						} else {
							groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+"_BL No-"+blNoTitle+".pdf", mailCapa);
						}
						
					} else {							
						groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+".pdf", mailCapa);
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
					
					// 전송정보를 INV_AR_ISS_SND 에 저장
					for (int j = 0; j < invEmlSendNoVOs.size(); j++) {
						
						log.info("\n########## invEmlSendNoVOs.size() : "+invEmlSendNoVOs.size());
						
						StringTokenizer invNoTkn = new StringTokenizer(invEmlSendNoVOs.get(j).getInvNo(), "/");
						while (invNoTkn.hasMoreTokens()) {
					    	invNoSplit = invNoTkn.nextToken();
					    	StringTokenizer invSeqTkn = new StringTokenizer(invNoSplit, "&");
					    	
					    	invNoSnd = invSeqTkn.nextToken();
					    	rdTypeSnd = invSeqTkn.nextToken();
					    	log.info("\n########## invNoSnd : "+invNoSnd);
					    	log.info("\n########## rdTypeSnd : "+rdTypeSnd);
					    	
					    	if (rdTypeSnd.equals("ORIGINAL")) {
					    		if(autoInvIssFlg.equals("Y")){
					    			dbDao.createSendNo(invNoSnd, "E", invEmlSendNoVOs.get(j), userId);
					    		} else {
					    			dbDao.createSendNo(invNoSnd, "E", invEmlSendNoVOs.get(j), account.getUsr_id());
					    		}
					    	}
					    						    	
						}
						
					}
					
				}	
				
				// Separate 데이타가 있는 경우 
				if (invIssMainVOs != null && invIssMainVOs.size() > 0) {
					// Separate용 method를 호출한다.
					for(InvIssMainVO vo : invIssMainVOs ){
						sendGeneralInvoiceByFaxEmailForSeperate(vo, issOptionVO,account);
					}
				}
				
			// FAX 전송 처리	
    		} else if (sendFlag.equals("F")) {
    			
    			InvEmlVO invEmlSendNoVO = new InvEmlVO();
    			rdType = "ORIGINAL";
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
    			for (int i=0; i<issMainVOs.length; i++) {
    				issMainVOs[i].setSendFlag(issOptionVO.getSendFlag());
    				issMainVOs[i].setIssOfcCd(issOptionVO.getIssOfcCd());
    				issMainVOs[i].setRdName(issOptionVO.getRdName());
    				issMainVOs[i].setNameFlag(issOptionVO.getNameFlag());
    				issMainVOs[i].setTitleFlag(issOptionVO.getTitleFlag());
    				issMainVOs[i].setIssueType(issOptionVO.getIssueType());
    				
    				// FAX 전송
    				sndNo = eaiDao.sendGeneralInvoiceByFaxEmail(issMainVOs[i], account, rdType);
    				log.info("\n########## sndNo : "+sndNo);
    				if(issLehbb.equals("Y") && logoGb.equals("3")){
    					eaiDao.sendGeneralInvoiceByFaxEmail(issMainVOs[i], account, "COPIE");
    				}
    				
    				    				
    				invEmlSendNoVO.setCustEml(issMainVOs[i].getCustFaxNo());
    				invEmlSendNoVO.setOfcCd(issOptionVO.getIssOfcCd());
    				invEmlSendNoVO.setEmlSndNo(sndNo);
    				
    				//dbDao.modifySendNo(issMainVOs[i], issOptionVO.getSendFlag(), sndNo, account.getUsr_id());
    				// 전송정보를 INV_AR_ISS_SND 에 저장
    				dbDao.createSendNo(issMainVOs[i].getInvNo(), "F", invEmlSendNoVO, account.getUsr_id());

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
	 * e-mail을 seperate로 전송한다. <br>
     * @param issMainVO
     * @param issOptionVO
     * @param account
     * @throws EventException
     */
    private void sendGeneralInvoiceByFaxEmailForSeperate(InvIssMainVO issMainVO, IssueOptionVO issOptionVO, SignOnUserAccount account) throws EventException {
    	
    	String sendFlag = issOptionVO.getSendFlag();
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
		
		String autoInvIssFlg = "";
		String userNm = "";
		String userEml = "";
		String personNm = "";
//		String personEml = "";
		String userId = "";
		
		List<InvEmlVO> invEmlVOs = new ArrayList<InvEmlVO>();
		InvEmlVO[] invEmlArrayVOs = null;
				
		List<List<MailGroupResultVO>> groupMailKeys = null;
		
		// LEHSC 일 경우 한번더 보내기 위해서 List형
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
    	String rdTypeSnd = "";
    	
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
		log.info("\n issLehbb================>>>>>>>>>>>"+issLehbb+"::"+logoGb);		
    	try {		
    		
    		// Email 전송 처리 
    		if (sendFlag.equals("E")) {
    			
    			//svrId = dbDao.searchSeverId(ofcCd);
    			setupOfficeVO = dbDao.searchSetupOfficeForIssue(ofcCd);
    			if (setupOfficeVO != null) {
    				invMltBlIssFlg = setupOfficeVO.getInvMltBlIssFlg();
    			}
					
				issMainVO.setSendFlag(issOptionVO.getSendFlag());
				issMainVO.setIssOfcCd(issOptionVO.getIssOfcCd());
				issMainVO.setRdName(issOptionVO.getRdName());
				issMainVO.setNameFlag(issOptionVO.getNameFlag());
				issMainVO.setTitleFlag(issOptionVO.getTitleFlag());
				issMainVO.setIssueType(issOptionVO.getIssueType());
				
				autoInvIssFlg = issMainVO.getAutoInvIssFlg();
				userEml = issMainVO.getUserEml();
				userNm = issMainVO.getUserNm();
				userId = issMainVO.getCreUsrId();

				StringTokenizer emlTkn = new StringTokenizer(issMainVO.getCustEml(), ";");
				
			    while (emlTkn.hasMoreTokens()) {
			    	custEmlSplit = emlTkn.nextToken();
			    		
			    	if (!custEmlSplit.equals("")) {				    		
			    		Mail mail = eaiDao.sendGeneralInvoiceByFaxEmailByGroup(issMainVO, account, custEmlSplit, rdType);	

						InvEmlVO invEmlVO = new InvEmlVO();
						
						invEmlVO.setMail(mail);					
						invEmlVO.setCustEml(custEmlSplit);
						invEmlVO.setVvd(issMainVO.getVvd());
						invEmlVO.setCustCd(issMainVO.getCustCd());
						invEmlVO.setInvNo(issMainVO.getInvNo());
						invEmlVO.setBlSrcNo(issMainVO.getInvNo()+" - "+issMainVO.getBlSrcNo().replace("\r\n", "/"));
						invEmlVO.setInvSeq(issMainVO.getInvSeq());
						invEmlVO.setPortCd(issMainVO.getPortCd());
						invEmlVO.setAttach(issMainVO.getAttach());
						invEmlVO.setAttachView(issMainVO.getAttachView());
						invEmlVO.setAttach2(issMainVO.getAttach2());
						invEmlVO.setAttachView2(issMainVO.getAttachView2());
						invEmlVO.setRdType("ORIGINAL");
						invEmlVO.setBlSrcNoTitle(issMainVO.getBlSrcNo());
						invEmlVOs.add(invEmlVO);
						log.info("\n########## custEmlSplit : "+custEmlSplit);
			    	
			    	}
				
				} 
			    
			    //LEHSC 일 경우, logoGb 체크하여 추가한다
			    if (issLehbb.equals("Y") && logoGb.equals("3")) {
			    	
				    StringTokenizer emlTkn2 = new StringTokenizer(issMainVO.getCustEml(), ";");
					
				    while (emlTkn2.hasMoreTokens()) {
				    	custEmlSplit = emlTkn2.nextToken();
				    		
				    	if (!custEmlSplit.equals("")) {
							Mail mail = eaiDao.sendGeneralInvoiceByFaxEmailByGroup(issMainVO, account, custEmlSplit, "COPY");		
							InvEmlVO invEmlVO = new InvEmlVO();
							
							invEmlVO.setMail(mail);					
							invEmlVO.setCustEml(custEmlSplit);
							invEmlVO.setVvd(issMainVO.getVvd());
							invEmlVO.setCustCd(issMainVO.getCustCd());
							invEmlVO.setInvNo(issMainVO.getInvNo());
							invEmlVO.setBlSrcNo(issMainVO.getInvNo()+" - "+issMainVO.getBlSrcNo().replace("\r\n", "/"));
							invEmlVO.setInvSeq(issMainVO.getInvSeq());
							invEmlVO.setPortCd(issMainVO.getPortCd());
							invEmlVO.setAttach(issMainVO.getAttach());
							invEmlVO.setAttachView(issMainVO.getAttachView());
							invEmlVO.setAttach2(issMainVO.getAttach2());
							invEmlVO.setAttachView2(issMainVO.getAttachView2());
							invEmlVO.setRdType("COPY");
							invEmlVO.setBlSrcNoTitle(issMainVO.getBlSrcNo());
							invEmlVOs.add(invEmlVO);													    	
				    	}
					}
			    }    		
				
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
						
		            // vvd, custCd, custEml 별로 Grouping 하여 전송		            
		            MailGroup mailGroup = new MailGroup();    	
		            mailGroup.setRdSubSysCd("INV");
		            //log.info("\n########## ofcCd_1 : "+ofcCd);
		            mailGroup.setOfficeCode(ofcCd);
		    		
		            if(autoInvIssFlg.equals("Y")){
		            	mailGroup.setFrom(userEml, userNm);
		            } else {
			            mailGroup.setFrom(account.getUsr_eml(), account.getUsr_nm());
		            }
		    		
		    		mailGroup.addMail(invEmlArrayVOs[0].getMail());
		    		invNo = invNo + invEmlArrayVOs[0].getInvNo() + "&" + invEmlArrayVOs[0].getRdType()+ "/";
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
		    		
		    		if (invEmlArrayVOs[0].getAttach().equals("1")) {
            			attachCnt++;	
            		}
		    		
		    		if (invEmlArrayVOs[0].getAttach2().equals("1")) {
            			attachCnt2++;	
            		}
		    		
		            for(int i = 1; i < invEmlArrayVOs.length ; i++ ){		            	
		            	
		            	if (!invEmlArrayVOs[i].getCustCd().equals(invEmlArrayVOs[i-1].getCustCd())) {

		            		// custemer 별 letter wordding 추가
		            		if ((attach2.equals("1") || attachCnt2 > 0) && attachView2.equals("YES")) {
		            			Mail wordingMailByCust = eaiDao.sendGeneralInvoiceByFaxEmailWordingByCust(issOptionVO.getIssOfcCd(), custEml, custCd, account, "N", "", "", "");
								mailGroup.addMail(wordingMailByCust);
		            		}		            		

		            		attachCnt2 = 0;
		            		
		            	}
		            	
		            	if (!invEmlArrayVOs[i].getVvd().equals(invEmlArrayVOs[i-1].getVvd())) {

		            		// vvd 별 letter wordding 추가
		            		if ((attach.equals("1") || attachCnt > 0) && attachView.equals("YES")) {
		            			Mail wordingMailByVVD = eaiDao.sendGeneralInvoiceByFaxEmailWordingByVVD(issOptionVO.getIssOfcCd(), custEml, vvd, portCd, account, "N", "", "", "");
								mailGroup.addMail(wordingMailByVVD);
		            		}		            		

		            		attachCnt = 0;
		            		
		            	}
		            	
		            	log.info("\n########## invEmlVOs.size()1 : "+invEmlArrayVOs[i].getCustCd());
		            	log.info("\n########## invEmlVOs.size()2 : "+invEmlArrayVOs[i].getAttach2());
		            	log.info("\n########## invEmlVOs.size()3 : "+invEmlArrayVOs[i-1].getAttach2());
		            	
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
		            		invNo = invNo + invEmlArrayVOs[i].getInvNo() + "&" + invEmlArrayVOs[i].getRdType() + "/";

	            			blNo = blNo + invEmlArrayVOs[i].getBlSrcNo() + "<br>";
	            			blNoTitle = blNoTitle + invEmlArrayVOs[i].getBlSrcNoTitle();
	            			blNoCnt++;
		            		
		            		vvd = invEmlArrayVOs[i].getVvd();
		            		portCd = invEmlArrayVOs[i].getPortCd();
		            		custEml = invEmlArrayVOs[i].getCustEml();
		            		attach = invEmlArrayVOs[i].getAttach();
		            		attachView = invEmlArrayVOs[i].getAttachView();
		            		custCd = invEmlArrayVOs[i].getCustCd();
				    		attach2 = invEmlArrayVOs[i].getAttach2();
				    		attachView2 = invEmlArrayVOs[i].getAttachView2();		            			            		
		            		
									            			            		
						} else {
							
							if (invEmlArrayVOs[i].getCustCd().equals(invEmlArrayVOs[i-1].getCustCd()) 
								&& (attach2.equals("1") || attachCnt2 > 0) && attachView2.equals("YES")) {
								
								// custemer 별 letter wordding 추가
								Mail wordingMailByCust1 = eaiDao.sendGeneralInvoiceByFaxEmailWordingByCust(issOptionVO.getIssOfcCd(), custEml, custCd, account, "N", "", "", "");
								mailGroup.addMail(wordingMailByCust1);
							}
							log.info("\n########## invMltBlIssFlg : "+invMltBlIssFlg);
							
							
							// Multi인 경우에도 subject를 Seperate한다.
//							subject = "HJS INV : VVD - "+vvd+"_B/L No - "+blNoTitle + " / Inv no. "+issMainVO.getInvNo();
							subject = "SML INV : VVD - "+vvd+"_B/L No - "+blNoTitle + " / Inv no. "+issMainVO.getInvNo();

							
							if(autoInvIssFlg.equals("Y")){
								personNm = userNm;
							} else {
								personNm = account.getUsr_nm();
							}
							
							if(ofcCd.equals("FXTSC")){
								contents = "Please find attached invoice as detailed below."		 		
								         + "<br>Should you have any query, please respond detailing your query to the sender's email address." 
								         + "<br>"					         
								         + "<br>Invoices are as followings,"
								         + "<br>"
								         + "<br>Invoice No.          &nbsp;&nbsp;&nbsp;B/L No"
								         + "<br>========================"
								         + "<br>"+blNo
								         + "<br>*Person in charge : "+personNm
								         + "<br>"
										 + "<br>Thank you."
										 + "<br>"
										 + "<br>Contact Information for SM Line Corporation Felixstowe Branch Office: "
										 + "<br>UK Import Merchant Haulage Release Team: 01394 606833 – ukreleases@uk.hanjin.com "
										 + "<br>UK Import Carrier Haulage Team: 01394 606834 – ukdeliveries@uk.hanjin.com "
										 + "<br>Accounts Receivable Team: 01394 606835 – fxtar@uk.hanjin.com "
										 + "<br>Import Documentation Team: 01394 606836 – importdocs@uk.hanjin.com "
										 + "<br>Export Documentation Team : 01394 606815 – documentation@uk.hanjin.com ";	
								
							}else if(ofcCd.equals("HAMSC")){
								contents = "Please find attached invoice as detailed below."		 		
								         + "<br>Should you have any query, please respond detailing your query to the sender's email address." 
								         + "<br>"
								         + "<br>Invoice No.          &nbsp;&nbsp;&nbsp;B/L No"
								         + "<br>========================"
								         + "<br>"+blNo
								         + "<br>*Person in charge : "+personNm
								         + "<br>"
										 + "<br>Thank you.";
 							} else {
								contents = "Please find attached invoice as detailed below."		 		
								         + "<br>Should you have any query, please respond detailing your query to the sender's email address." 
								         + "<br>"					         
								         + "<br>Invoices are as followings,"
								         + "<br>"
								         + "<br>Invoice No.          &nbsp;&nbsp;&nbsp;B/L No"
								         + "<br>========================"
								         + "<br>"+blNo
								         + "<br>*Person in charge : "+personNm
								         + "<br>"
										 + "<br>Thank you.";
							}
							

							mailGroup.setSubject(subject);	
							mailGroup.setHtmlContent(contents);
							
							//////////////////////////////////////////////////////
							
							log.info("\n########## attachCnt_1 : "+attachCnt);
							
							if (invEmlArrayVOs[i].getVvd().equals(invEmlArrayVOs[i-1].getVvd()) 
								&& (attach.equals("1") || attachCnt > 0) && attachView.equals("YES")) {
								
								// vvd 별 letter wordding 추가
								Mail wordingMailByVVD1 = eaiDao.sendGeneralInvoiceByFaxEmailWordingByVVD(issOptionVO.getIssOfcCd(), custEml, vvd, portCd, account, "N", "", "", "");
								mailGroup.addMail(wordingMailByVVD1);
								
							}
							
							// Seperate는 Multi여도 Merge하지 않는다.
							groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+"_BL No-"+blNoTitle+"_INV-"+invEmlArrayVOs[i].getInvNo()+".pdf", mailCapa);
														
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
							
							mailGroup = new MailGroup();
							mailGroup.setRdSubSysCd("INV");
							//log.info("\n########## ofcCd_2 : "+ofcCd);
							mailGroup.setOfficeCode(ofcCd);
							
							if(autoInvIssFlg.equals("Y")){
								mailGroup.setFrom(userEml, userNm);
							} else {
								mailGroup.setFrom(account.getUsr_eml(), account.getUsr_nm());
							}					
							
							mailGroup.addMail(invEmlArrayVOs[i].getMail());
							invNo = invNo + invEmlArrayVOs[i].getInvNo() + "&" + invEmlArrayVOs[i].getRdType() + "/";

	            			blNo = blNo + invEmlArrayVOs[i].getBlSrcNo() + "<br>";
	            			blNoTitle = blNoTitle + invEmlArrayVOs[i].getBlSrcNoTitle();
	            			blNoCnt++;
		            		
							vvd = invEmlArrayVOs[i].getVvd();
							portCd = invEmlArrayVOs[i].getPortCd();
							custEml = invEmlArrayVOs[i].getCustEml();
							attach = invEmlArrayVOs[i].getAttach();
							attachView = invEmlArrayVOs[i].getAttachView();
							custCd = invEmlArrayVOs[i].getCustCd();
				    		attach2 = invEmlArrayVOs[i].getAttach2();
				    		attachView2 = invEmlArrayVOs[i].getAttachView2();
							
						}
		            	    		            	
		            }	
		            
		            log.info("\n########## invMltBlIssFlg2 : "+invMltBlIssFlg);
		            	
//		            subject = "HJS INV : VVD - "+vvd+"_B/L No - "+blNoTitle + " / Inv no. "+issMainVO.getInvNo();
		            subject = "SML INV : VVD - "+vvd+"_B/L No - "+blNoTitle + " / Inv no. "+issMainVO.getInvNo();
		            
					if(autoInvIssFlg.equals("Y")){
						personNm = userNm;
					} else {
						personNm = account.getUsr_nm();
					}
		            
		            if(ofcCd.equals("FXTSC")){
						contents = "Please find attached invoice as detailed below."		 		
						         + "<br>Should you have any query, please respond detailing your query to the sender's email address." 
						         + "<br>"
						         + "<br>Invoices are as followings,"
						         + "<br>"
						         + "<br>Invoice No.          &nbsp;&nbsp;&nbsp;B/L No"
						         + "<br>========================"
						         + "<br>"+blNo
						         + "<br>*Person in charge : "+personNm
						         + "<br>"
								 + "<br>Thank you."
								 + "<br>"
								 + "<br>Contact Information for SM Line Corporation Felixstowe Branch Office: "
								 + "<br>UK Import Merchant Haulage Release Team: 01394 606833 – ukreleases@uk.hanjin.com "
								 + "<br>UK Import Carrier Haulage Team: 01394 606834 – ukdeliveries@uk.hanjin.com "
								 + "<br>Accounts Receivable Team: 01394 606835 – fxtar@uk.hanjin.com "
								 + "<br>Import Documentation Team: 01394 606836 – importdocs@uk.hanjin.com "
								 + "<br>Export Documentation Team : 01394 606815 – documentation@uk.hanjin.com ";	
						         
		            }else if(ofcCd.equals("HAMSC")){
						contents = "Please find attached invoice as detailed below."		 		
						         + "<br>Should you have any query, please respond detailing your query to the sender's email address." 
						         + "<br>"
						         + "<br>Invoice No.          &nbsp;&nbsp;&nbsp;B/L No"
						         + "<br>========================"
						         + "<br>"+blNo
						         + "<br>*Person in charge : "+personNm
						         + "<br>"
								 + "<br>Thank you.";
					} else {
						contents = "Please find attached invoice as detailed below."		 		
						         + "<br>Should you have any query, please respond detailing your query to the sender's email address." 
						         + "<br>"
						         + "<br>Invoices are as followings,"
						         + "<br>"
						         + "<br>Invoice No.          &nbsp;&nbsp;&nbsp;B/L No"
						         + "<br>========================"
						         + "<br>"+blNo
						         + "<br>*Person in charge : "+personNm
						         + "<br>"
								 + "<br>Thank you.";
		            }
		            
					mailGroup.setSubject(subject);	
					mailGroup.setHtmlContent(contents);
					
					log.info("\n########## attachCnt_2 : "+attachCnt);
		            		
					if ((attach2.equals("1") || attachCnt2 > 0) && attachView2.equals("YES")) {
						
						// customer 별 letter wordding 추가
						Mail wordingMailByCust2 = eaiDao.sendGeneralInvoiceByFaxEmailWordingByCust(issOptionVO.getIssOfcCd(), custEml, custCd, account, "N", "", "", "");
						mailGroup.addMail(wordingMailByCust2);
						
					}
												
					if ((attach.equals("1") || attachCnt > 0) && attachView.equals("YES")) {
						
						// vvd 별 letter wordding 추가
						Mail wordingMailByVVD2 = eaiDao.sendGeneralInvoiceByFaxEmailWordingByVVD(issOptionVO.getIssOfcCd(), custEml, vvd, portCd, account, "N", "", "", "");
						mailGroup.addMail(wordingMailByVVD2);
						
					}
					
					// Seperate는 Multi여도 Merge하지 않는다.
					groupMailKeys = mailGroup.sendMailGroupMergeAndSplit(sf.format(dt)+"_VVD-"+vvd+"_BL No-"+blNoTitle+"_INV-"+issMainVO.getInvNo()+".pdf", mailCapa);

					
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
					
					// 전송정보를 INV_AR_ISS_SND 에 저장
					for (int j = 0; j < invEmlSendNoVOs.size(); j++) {
						
						log.info("\n########## invEmlSendNoVOs.size() : "+invEmlSendNoVOs.size());
						
						StringTokenizer invNoTkn = new StringTokenizer(invEmlSendNoVOs.get(j).getInvNo(), "/");
						while (invNoTkn.hasMoreTokens()) {
					    	invNoSplit = invNoTkn.nextToken();
					    	StringTokenizer invSeqTkn = new StringTokenizer(invNoSplit, "&");
					    	
					    	invNoSnd = invSeqTkn.nextToken();
					    	rdTypeSnd = invSeqTkn.nextToken();
					    	log.info("\n########## invNoSnd : "+invNoSnd);
					    	log.info("\n########## rdTypeSnd : "+rdTypeSnd);
					    	
					    	if (rdTypeSnd.equals("ORIGINAL")) {
					    		if(autoInvIssFlg.equals("Y")){
					    			dbDao.createSendNo(invNoSnd, "E", invEmlSendNoVOs.get(j), userId);
					    		} else {
					    			dbDao.createSendNo(invNoSnd, "E", invEmlSendNoVOs.get(j), account.getUsr_id());
					    		}
					    	}			    	
						}
					}
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
	 * NYC Issue 메일을 발송합니다<br>[CHM-201431413] 미주지역 Inv Issue 프로그램 개발 요청
	 * 
	 * @param List<NYCInvoiceVO> nYCInvoiceVOs
	 * @param InvEmailFaxVO invEmailFaxVO
	 * @param NYCEmlVO nycEmlVo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EAIException 
	 */	
	public String sendNYCInvoiceByFaxEmail(List<NYCInvoiceVO> nYCInvoiceVOs, InvEmailFaxVO invEmailFaxVO, NYCEmlVO nycEmlVo, SignOnUserAccount account) throws MailerAppException, EAIException, EventException {
		String sendFlag = invEmailFaxVO.getSendFlg();
				
		String subject = invEmailFaxVO.getSubject();
		String contents = "";

		String rd_name = "FNS_INV_0139.mrd";
		
		String rdParam = "";
		StringBuffer rdParamBuff = new StringBuffer();
		
		rdParamBuff.append(" form_type[2] ");
		rdParamBuff.append(" form_dataOnly[N] ");
		rdParamBuff.append(" form_manifest[N] ");
		rdParamBuff.append(" form_usrId["+account.getUsr_id()+"] ");
		rdParamBuff.append(" form_hiddeData[N] ");
		rdParamBuff.append(" form_level[(1)] ");
		rdParamBuff.append(" form_remark[] ");
		rdParamBuff.append(" form_Cntr[1] ");
		rdParamBuff.append(" form_mainOnly[N]");
		rdParamBuff.append(" form_CorrNo[]");
		rdParamBuff.append(" form_his_cntr[BKG_CONTAINER]");
		rdParamBuff.append(" form_his_bkg[BKG_BOOKING] ");
		rdParamBuff.append(" form_his_mkd[BKG_BL_MK_DESC]");
		rdParamBuff.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
		rdParamBuff.append(" form_his_bl[BKG_BL_DOC] ");
		rdParamBuff.append(" form_arofccd[" + invEmailFaxVO.getArOfcCd() + "] ");
		rdParamBuff.append(" form_stamp_type[" +  invEmailFaxVO.getArgument() + "] ");
		rdParamBuff.append(" /rp [] ");
		rdParamBuff.append(" /riprnmargin /rpypos [0]" +"|");
		
		
		StringBuffer contentBuff = new StringBuffer();
		
		contentBuff.append("<table border='0' cellspacing='0' cellpadding='0' width='740' style='width:554.85pt;margin-left:-1.15pt;border-collapse:collapse'>");
		contentBuff.append("	<tr>");
		contentBuff.append("		<td width='252' nowrap='' valign='bottom' style='width:189.35pt;border:solid windowtext 1.0pt;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
		contentBuff.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>Customer Name</span></b></p>");
		contentBuff.append("		</td>");
		contentBuff.append("		<td width='104' nowrap='' valign='bottom' style='width:77.8pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
		contentBuff.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>B/L No</span></b></p>");
		contentBuff.append("		</td>");
		contentBuff.append("		<td width='71' nowrap='' valign='bottom' style='width:52.9pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
		contentBuff.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>Credit Limit</span></b></p>");
		contentBuff.append("		</td>");
		contentBuff.append("		<td width='84' nowrap='' valign='bottom' style='width:62.75pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
		contentBuff.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>S/A Date</span></b></p>");
		contentBuff.append("		</td>");
		contentBuff.append("		<td width='76' nowrap='' valign='bottom' style='width:57.35pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
		contentBuff.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>Due Date</span></b></p>");
		contentBuff.append("		</td>");
		contentBuff.append("		<td width='153' nowrap='' valign='bottom' style='width:114.7pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
		contentBuff.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>&nbsp; TTL USD </span></b></p>");
		contentBuff.append("		</td>");
		contentBuff.append("	</tr>");
		
		// Email 발송
		Mail mail = new Mail();
		if (sendFlag.equals("E")) {			
			
			List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
			
			if("S".equals(nycEmlVo.getMailType())){
				

				contents = invEmailFaxVO.getContent();
				
				rdParam = "/rv form_bkgNo[( " + invEmailFaxVO.getInvNo() + " )] " + rdParamBuff.toString();
				
//				String file_nm = "HANJIN SHIPPING BILL OF LADING_"+invEmailFaxVO.getInvNo().replaceAll("'", "") + ".pdf";
				String file_nm = "SM LINE CORPORATION BILL OF LADING_"+invEmailFaxVO.getInvNo().replaceAll("'", "") + ".pdf";
				
				ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();			
				comRptDsgnXptInfoVO.setXptFileNm(file_nm);
				comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				comRptDsgnXptInfoVO.setRdTmpltNm(rd_name);
				comRptDsgnXptInfoVO.setRdParaCtnt(rdParam);
				comRptDsgnXptInfoVO.setCreUsrId(account.getCre_usr_id());
				comRptDsgnXptInfoVO.setUpdUsrId(account.getUpd_usr_id());
				
				comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
				
			} else {
				for( int i=0; i < nYCInvoiceVOs.size();  i++){						
					
					String bkgNo = "'"+nYCInvoiceVOs.get(i).getBkgNo()+"'";	
					
//					String file_nm = "HANJIN SHIPPING BILL OF LADING_"+bkgNo.replaceAll("'", "")+".pdf";
					String file_nm = "SM LINE CORPORATION BILL OF LADING_"+bkgNo.replaceAll("'", "")+".pdf";
					
					rdParam = "/rv form_bkgNo[( " + bkgNo + " )] " + rdParamBuff.toString();
					
					ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();			
					comRptDsgnXptInfoVO.setXptFileNm(file_nm);
					comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
					comRptDsgnXptInfoVO.setRdTmpltNm(rd_name);
					comRptDsgnXptInfoVO.setRdParaCtnt(rdParam);
					comRptDsgnXptInfoVO.setCreUsrId(account.getCre_usr_id());
					comRptDsgnXptInfoVO.setUpdUsrId(account.getUpd_usr_id());
					
					comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
					
					
					contentBuff.append("	<tr>");
					contentBuff.append("		<td width='252' nowrap='' valign='bottom' style='width:189.35pt;border:solid windowtext 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
					contentBuff.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ nYCInvoiceVOs.get(i).getCustNm() +"</span>");
					contentBuff.append("		</td>");
					contentBuff.append("		<td width='104' nowrap='' valign='bottom' style='width:77.8pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
					contentBuff.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ nYCInvoiceVOs.get(i).getBlSrcNo() +"</span>");
					contentBuff.append("		</td>");
					contentBuff.append("		<td width='71' nowrap='' valign='bottom' style='width:52.9pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
					contentBuff.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ nYCInvoiceVOs.get(i).getCrAmt() +"</span>");
					contentBuff.append("		</td>");
					contentBuff.append("		<td width='84' nowrap='' valign='bottom' style='width:62.75pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
					contentBuff.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ nYCInvoiceVOs.get(i).getSailArrDt() +"</span>");
					contentBuff.append("		</td>");
					contentBuff.append("		<td width='76' nowrap='' valign='bottom' style='width:57.35pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
					contentBuff.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ nYCInvoiceVOs.get(i).getDueDt() +"</span>");
					contentBuff.append("		</td>");
					contentBuff.append("		<td width='153' nowrap='' valign='bottom' style='width:114.7pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 10.4pt 0cm 5.4pt;height:15.0pt'>");
					contentBuff.append("			<span lang='EN-US' style='font-size:8.0pt;'>&nbsp; $ </span><span lang='EN-US' style='font-size:8.0pt;'>&nbsp; "+ nYCInvoiceVOs.get(i).getTtlAmt() +" </span>");
					contentBuff.append("		</td>");
					contentBuff.append("	</tr>");

				}
				contentBuff.append("</table><br><br><br><br>");
				contentBuff.append("<p style='margin:0cm;margin-bottom:.0001pt;font-size:12.0pt;font-family:&quot;Times New Roman&quot;,&quot;serif&quot;;'>");
				contentBuff.append("	<b><i><span lang='EN-US' style='color:#1F497D;'>"+ account.getUsr_nm() +"</span></i></b>");
				contentBuff.append("	<span lang='EN-US' style='font-size:10.0pt;font-family:&quot;Calibri&quot;,&quot;sans-serif&quot;;color:#244061'><b>|</b>&nbsp;");
				contentBuff.append("	Account Receivable&nbsp;<b>|</b> SM Line Corporation America, LLC. </span>");
				contentBuff.append("</p>");
				contentBuff.append("<p style='margin:0cm;margin-bottom:.0001pt;'>");
				contentBuff.append("	<span lang='EN-US' style='font-size:10.0pt;font-family:&quot;Calibri&quot;,&quot;sans-serif&quot;;color:#1F497D'>2195 W. CHANDLER BLVD., SUITE 100, CHANDLER, AZ 85224</span>");
				contentBuff.append("</p>");
				contentBuff.append("<p style='margin:0cm;margin-bottom:.0001pt;'>");
				contentBuff.append("	<span lang='EN-US' style='font-size:10.0pt;font-family:&quot;Calibri&quot;,&quot;sans-serif&quot;;color:#1F497D'>Email: ");
				contentBuff.append("	<a href='mailto:seng@us.hanjin.com' target='_blank'>"+ account.getUsr_eml() +"</a>");
				contentBuff.append("	Group Email: <a href='mailto:atobar@us.hanjin.com' target='_blank'>ecobar@us.hanjin.com</a></span>");
				contentBuff.append("</p>");
				contentBuff.append("<p style='margin:0cm;margin-bottom:.0001pt;'>");
				contentBuff.append("	<span lang='EN-US' style='font-size:10.0pt;font-family:&quot;Calibri&quot;,&quot;sans-serif&quot;;color:#1F497D'>Main #<b>:</b> 480-927-3600 Direct #<b>:</b>"+ account.getXtn_phn_no()+"</span>");
				contentBuff.append("</p>");
				
				
				contents = invEmailFaxVO.getContent() + contentBuff.toString();
			}
			
			try {
				
				mail.setFrom(account.getUsr_eml(), account.getUsr_nm());
				mail.setRecipient(invEmailFaxVO.getRecipient());
				mail.setCcRcvrEml(nycEmlVo.getEdtCcEml());
				mail.setSubject(subject);
				mail.setHtmlContent(contents);
				mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
				return mail.send();
			} catch (MailerAppException e) {
				throw new EventException(e.getMessage(), e);
			} catch (Exception e) {
				throw new EventException(e.getMessage(), e);
			}
		}
		// Fax 발송	
		else {
			
			rdParam = "/rv form_bkgNo[( " + invEmailFaxVO.getInvNo() + " )] " + rdParamBuff.toString();
			
			try {
				FaxMetaInfo info = new FaxMetaInfo("INV",     // 모듈명(ex.BKG)
						                   "FNS_INV_0139.mrd",   // MRD 파일 명 (ex.WO_NORMAL.mrd)
								           "N",  // 배치 유무(Y/N)
								           subject,     // 제목
								           rdParam, // RD Parameter (ex. [419][1][selho])
								           //invEmailFaxVO.getArOfcCd()+";5336", //22층 테스트 용 번호
								           invEmailFaxVO.getArOfcCd()+";"+invEmailFaxVO.getRecipient(), //이름+FAX번호 (받는 사람1;fax1,받는사람2,fax2)
								           invEmailFaxVO.getArOfcCd(),    // 지역 FAX office
									       //account.getUsr_nm()  // 보내는 사람
								           //2010-06-21 김동진수석
								           account.getUsr_id()
									       );
				
				return FaxUtility.registerDB(info);
			} catch (Exception ex){
				throw new EAIException(ex.getMessage(), ex);
			}			
		}	
	}
	
}
