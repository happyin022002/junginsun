/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : BLIssuanceEAIDAO.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.09.04
*@LastModifier   : 박준용
*@LastVersion    : 1.0
* 2009.09.04 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.ArrayList;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.FaxSendVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.MailSendVO;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.fax.FaxMetaInfo;
import com.clt.framework.component.fax.FaxUtility;
import com.clt.framework.component.ftp.FtpException;
import com.clt.framework.component.ftp.FtpMetaInfo;
import com.clt.framework.component.ftp.FtpUtility;
import com.clt.framework.component.javamail.Mail;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.component.javamail.SingleMailAttachedFile;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.component.util.io.FileUtils;
import com.clt.framework.core.config.SiteConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.EAIException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
/**
 * OPUS BLIssuanceEAIDAO <br>
 * - OPUS-OutboundBLMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Joon Yong Park
 * @see BLIssuanceBCImpl 참조
 * @since J2EE 1.4
 */
public class BLIssuanceEAIDAO extends EAIDAOSupport {

    //private transient Logger log = Logger.getLogger(BLIssuanceEAIDAO.class.getName());
	private String ccRcvrEml= null;

	/**
     * 스트링 변환 유틸리티 메소드
     * 스트링이 null이면 빈 스트링을 리턴한다.
     *
     * @param String string 체크할 스트링
     * @return String 스트링이 null인 경우 빈 스트링; 스트링이 null이 아닌 경우 스트링 자신
     */
    public static String nullToEmpty(String string) {
    	String strRtn = null;
        if (string == null) {
            strRtn = "";
        }else{
            strRtn = string;
        }
        return strRtn;
    }
    
	/**
	 * RD 메일을 전송한다.
	 * 
	 * @param MailSendVO emailInfo
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs
	 * @return String
	 * @throws EventException
	 */
	public String sendReportDesignerWithFiles(MailSendVO emailInfo, BkgEmlEdtVO bkgEmlEdtVO, List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs) throws EventException {
    	Mail mail = null;
        try {
			mail = new Mail();
			mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
			mail.setFrom(emailInfo.getSndEml());
			mail.setRptMrgFlg("Y"); //Merge Flag
            if ( !"".equals(emailInfo.getFileKey()) && emailInfo.getFileKey() != null ){
                mail.setAttachedFile(FileUtils.getAttachedFiles(emailInfo.getFileKey().split(";"),SiteConfigFactory.get("COM.FILE.UPLOAD.KEY")));
            }
			if (null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getEdtToEml())) {
				mail.setRecipient(bkgEmlEdtVO.getEdtToEml());
				mail.setCcRcvrEml(bkgEmlEdtVO.getEdtCcEml());
				mail.setSubject(bkgEmlEdtVO.getEdtSubject());
				mail.setHtmlContent(bkgEmlEdtVO.getEdtContents());
			} else {
				log.debug("[TO    MAIL]"+emailInfo.getRcvEml());
				log.debug("[cc    MAIL]"+emailInfo.getCcEml());
				log.debug("[TITLE MAIL]"+emailInfo.getTitle());
				log.debug("[CTNT  MAIL]"+emailInfo.getContents());
	            mail.setRecipient(emailInfo.getRcvEml()); // 받는 사람 메일주소
	            mail.setCcRcvrEml(emailInfo.getCcEml()); //cc mail 주소
	            mail.setSubject(emailInfo.getTitle()); // 메일 제목
	            mail.setHtmlContent(emailInfo.getContents()); // 메일 본문내용
			}
			
    		return mail.send();
        } catch (MailerAppException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
	}
	/**
	 * RD 메일을 전송한다.
	 * 
	 * @param MailSendVO emailInfo
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs
	 * @param String ntcKndCd
	 * @param String ccRcvEml
	 * @return String 
	 * @throws EventException
	 */
	public String sendReportDesignerWithFiles2(MailSendVO emailInfo, BkgEmlEdtVO bkgEmlEdtVO, List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs,String ntcKndCd,String ccRcvrEml) throws EventException {
//    	Mail mail = null;
    	TemplateMail template = null;
        try {
        	
        	template = new TemplateMail();
			template.setBatFlg(emailInfo.getBatchFlg());
			template.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
			template.setFrom(emailInfo.getSndEml(),emailInfo.getSndNm());
			template.setRptMrgFlg("Y");
			template.setRptMrgFileNm(emailInfo.getTmplMrdPdf());
//			template.setAttachedFile(fileList);
log.debug("\n\n\n\n\n\n\nEMAIL(NORMAL)\n\n\n\n\n\n\n");
			template.setRecipient(emailInfo.getRcvEml());
			if (null!=ccRcvrEml && !"".equals(ccRcvrEml)) {
				template.setCcRcvrEml(ccRcvrEml);
			}
			if(null!=emailInfo.getBccRcvrEml() && !"".equals(emailInfo.getBccRcvrEml())){
				template.setBccRcvrEml(emailInfo.getBccRcvrEml());
			}
			template.setSubject(emailInfo.getTitle()); 
			template.setHtmlTemplate("WB".equalsIgnoreCase(ntcKndCd) ? "ESM_BKG_0218_02T.html" : ("CW".equalsIgnoreCase(ntcKndCd) ?  "ESM_BKG_0218_04T.html" : ("NN".equalsIgnoreCase(ntcKndCd) ? "ESM_BKG_0218_03T.html" : "ESM_BKG_0218_01T.html")));
			String arg1 = "";
			String arg2 = "";
			for (String arg : emailInfo.getContents().split("@@")) {
				if(arg.split(";").length==1){		//data가 존재하지 않으면 에러 발생 
					arg1=arg.split(";")[0];
					arg2="";
				}else{
					arg1=arg.split(";")[0];
					arg2=arg.split(";")[1];
				}
				template.setArg(arg1,arg2);
			}
			return template.send();
//			retList.add(template.send());
//			mail = new Mail();
//			mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
//			mail.setFrom(emailInfo.getSndEml());
//			mail.setRptMrgFlg("Y"); //Merge Flag
//            if ( !"".equals(emailInfo.getFileKey()) && emailInfo.getFileKey() != null ){
//                mail.setAttachedFile(FileUtils.getAttachedFiles(emailInfo.getFileKey().split(";"),SiteConfigFactory.get("COM.FILE.UPLOAD.KEY")));
//            }
//			if (null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getEdtToEml())) {
//				mail.setRecipient(bkgEmlEdtVO.getEdtToEml());
//				mail.setCcRcvrEml(bkgEmlEdtVO.getEdtCcEml());
//				mail.setSubject(bkgEmlEdtVO.getEdtSubject());
//				mail.setHtmlContent(bkgEmlEdtVO.getEdtContents());
//			} else {
//				log.debug("[TO    MAIL]"+emailInfo.getRcvEml());
//				log.debug("[cc    MAIL]"+emailInfo.getCcEml());
//				log.debug("[TITLE MAIL]"+emailInfo.getTitle());
//				log.debug("[CTNT  MAIL]"+emailInfo.getContents());
//	            mail.setRecipient(emailInfo.getRcvEml()); // 받는 사람 메일주소
//	            mail.setCcRcvrEml(emailInfo.getCcEml()); //cc mail 주소
//	            mail.setSubject(emailInfo.getTitle()); // 메일 제목
//	            mail.setHtmlContent(emailInfo.getContents()); // 메일 본문내용
//			}
//			
//    		return mail.send();
        } catch (MailerAppException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
	}
	/**
	 * RD 메일을 전송한다.
	 * 
	 * @param MailSendVO emailInfo
	 * @param String ntcKndCd
	 * @return String
	 * @throws Exception
	 */
	public String sendEmail(MailSendVO emailInfo,String ntcKndCd) throws Exception {
		MailSendVO[] infos = new MailSendVO[1];
		infos[0] = emailInfo;
		List<String> sendId = sendEmail(infos,null,ntcKndCd);
		if (sendId.size() > 0) return sendId.get(0);
		else return "";
	}

	/**
	 * RD 메일을 전송한다.
	 * 
	 * @param MailSendVO emailInfo
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param String ntcKndCd
	 * @param String ccRcvrEml
	 * @return String
	 * @throws Exception
	 */
	public String sendEmail(MailSendVO emailInfo,BkgEmlEdtVO bkgEmlEdtVO,String ntcKndCd,String ccRcvrEml) throws Exception {
		MailSendVO[] infos = new MailSendVO[1];
		infos[0] = emailInfo;
		this.ccRcvrEml = ccRcvrEml;
		
		List<String> sendId = sendEmail(infos,bkgEmlEdtVO,ntcKndCd);
		if (sendId.size() > 0) return sendId.get(0);
		else return "";
	}

	/**
	 * RD 메일을 전송한다.
	 * 
	 * @param MailSendVO[] emailInfos
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param String ntcKndCd
	 * @return List<String>
	 * @throws Exception 
	 */
	public List<String> sendEmail(MailSendVO[] emailInfos,BkgEmlEdtVO bkgEmlEdtVO,String ntcKndCd) throws Exception {
		int arrLen = emailInfos.length;
		List<SingleMailAttachedFile> fileList = null;
		MailSendVO info = null;
		List<String> retList = null;
		List<ComRptDsgnXptInfoVO> vos = null;
		ComRptDsgnXptInfoVO vo = null;
		TemplateMail template = null;
		Mail mail = null;
		try {
			retList = new ArrayList<String>();
			for (int i=0; i<arrLen; i++) {
				info = emailInfos[i];
				fileList = new ArrayList<SingleMailAttachedFile>();
				if(info.getFileKey() != null && 
				   !"".equalsIgnoreCase(info.getFileKey()) &&
				   !info.getFileKey().equalsIgnoreCase("null")) {
					String[] fileKeys = info.getFileKey().split(";");
					for(String fileKey:fileKeys) {
						SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
						attachedFile.setFileKey(fileKey);
						fileList.add(attachedFile); 
					}
				}
				vo = new ComRptDsgnXptInfoVO();
				vo.setRdTmpltNm(info.getTmplMrd());
				vo.setRdParaCtnt(info.getTmplParam());
				vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				vo.setXptFileNm(info.getTmplMrdPdf());
				vo.setCreUsrId(info.getCrtUserId());
				vo.setUpdUsrId(info.getCrtUserId());
				vos = new ArrayList<ComRptDsgnXptInfoVO>();
				vos.add(vo);
				if (StringUtils.isEmpty(ntcKndCd)) {
					mail = new Mail();
					mail.setBatFlg(info.getBatchFlg());
					mail.setComRptDsgnXptInfoVOs(vos);
					mail.setFrom(info.getSndEml(),info.getSndNm());
					mail.setAttachedFile(fileList);
					if (null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getEdtToEml())) {
						mail.setRecipient(bkgEmlEdtVO.getEdtToEml());
						mail.setCcRcvrEml(bkgEmlEdtVO.getEdtCcEml());
						if(null!=info.getBccRcvrEml() && !"".equals(info.getBccRcvrEml())){
							mail.setBccRcvrEml(info.getBccRcvrEml());
						}
						mail.setSubject(bkgEmlEdtVO.getEdtSubject());
						mail.setHtmlContent(bkgEmlEdtVO.getEdtContents());
					} else {
						mail.setRecipient(info.getRcvEml());
						mail.setSubject(info.getTitle());
						mail.setTextContent(info.getContents());
						if (null!=ccRcvrEml && !"".equals(ccRcvrEml)) {
							mail.setCcRcvrEml(ccRcvrEml);
						}
						if(null!=info.getBccRcvrEml() && !"".equals(info.getBccRcvrEml())){
							mail.setBccRcvrEml(info.getBccRcvrEml());
						}
					}
					retList.add(mail.send());
				} else {
					template = new TemplateMail();
					template.setBatFlg(info.getBatchFlg());
					template.setComRptDsgnXptInfoVOs(vos);
					template.setFrom(info.getSndEml(),info.getSndNm());
					template.setAttachedFile(fileList);
					if (null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getEdtToEml())) {
log.debug("\n\n\n\n\n\n\nEMAIL(EDIT)\n\n\n\n\n\n\n");
						template.setRecipient(bkgEmlEdtVO.getEdtToEml());
						template.setCcRcvrEml(bkgEmlEdtVO.getEdtCcEml());
						if(null!=info.getBccRcvrEml() && !"".equals(info.getBccRcvrEml())){
							template.setBccRcvrEml(info.getBccRcvrEml());
						}
						template.setSubject(bkgEmlEdtVO.getEdtSubject());
						template.setHtmlContent(bkgEmlEdtVO.getEdtContents());
					} else {
log.debug("\n\n\n\n\n\n\nEMAIL(NORMAL)\n\n\n\n\n\n\n");
						template.setRecipient(info.getRcvEml());
						if (null!=ccRcvrEml && !"".equals(ccRcvrEml)) {
							template.setCcRcvrEml(ccRcvrEml);
						}
						if(null!=info.getBccRcvrEml() && !"".equals(info.getBccRcvrEml())){
							template.setBccRcvrEml(info.getBccRcvrEml());
						}
						template.setSubject(info.getTitle()); 
						template.setHtmlTemplate("WB".equalsIgnoreCase(ntcKndCd) ? "ESM_BKG_0218_02T.html" : ("CW".equalsIgnoreCase(ntcKndCd) ?  "ESM_BKG_0218_04T.html" : ("NN".equalsIgnoreCase(ntcKndCd) ? "ESM_BKG_0218_03T.html" : "ESM_BKG_0218_01T.html")));
						String arg1 = "";
						String arg2 = "";
						for (String arg : info.getContents().split("@@")) {
							if(arg.split(";").length==1){		//data가 존재하지 않으면 에러 발생 
								arg1=arg.split(";")[0];
								arg2="";
							}else{
								arg1=arg.split(";")[0];
								arg2=arg.split(";")[1];
							}
							template.setArg(arg1,arg2);
						}
					}
					retList.add(template.send());
				}
			}
			this.ccRcvrEml = null;
		} catch (MailerAppException mae) {
			throw new EAIException(mae.getMessage(), mae);
		} catch (Exception ex){
			throw new Exception(ex.getMessage(), ex);
		}
		return retList;
	}
	
	/**
	 * Fax 를 전송한다.(Fax Queue에 전송)
	 * 
	 * @param FaxSendVO faxInfo
	 * @return String
	 * @throws Exception
	 */
	public String sendFax(FaxSendVO faxInfo) throws Exception {
		
		FaxSendVO infos[] = new FaxSendVO[1];
		
		infos[0] = faxInfo;
		
		List<String> sendId = sendFax(infos);
		
		if (sendId.size() > 0) return sendId.get(0);
		else return "";
	}
	
	/**
	 * Fax 를 전송한다.(Fax Queue에 전송)
	 * 
	 * @param FaxSendVO[] faxInfos
	 * @return List<String>
	 * @throws Exception
	 */
	public List<String> sendFax(FaxSendVO[] faxInfos) throws Exception {
		
		int arrLen = faxInfos.length;
		FaxMetaInfo[] infos = new FaxMetaInfo[arrLen];
		
		try {
			for (int i=0; i<arrLen; i++) {
				infos[i] = new FaxMetaInfo(faxInfos[i].getSysCd(),     // 모듈명(ex.BKG)
					 		               (0<=faxInfos[i].getTmplMrd().indexOf("/")) ? 
					 		            	   faxInfos[i].getTmplMrd().substring(faxInfos[i].getTmplMrd().lastIndexOf("/")+1) :
					 		            	   faxInfos[i].getTmplMrd(),  // MRD 파일 명 (ex.WO_NORMAL.mrd)
								           faxInfos[i].getBatchFlg(),  // 배치 유무(Y/N)
								           faxInfos[i].getTitle(),     // 제목
								           faxInfos[i].getTmplParam(), // RD Parameter (ex. [419][1][selho])
								           faxInfos[i].getRcvInfo(),   // 이름+FAX번호 (받는 사람1;fax1,받는사람2,fax2)
								           faxInfos[i].getOffice(),    // 지역 FAX office
								           faxInfos[i].getCrtUserId()  // 보내는 사람
								          ); 
			}
					
			return FaxUtility.registerDB(infos);

		} catch (Exception ex){
			throw new Exception(ex.getMessage(), ex);
		}
	}
	
	/**
	 *  sendInternetAuthMail 메일을 전송한다.
	 * @param Mail amail
	 * @return String
	 * @throws Exception
	 */
	public String sendInternetAuthMail(Mail amail) throws Exception {
		//Mail amail = new Mail();
		//amail.setRecipient(mail.getRcvEml());
		//amail.setFrom(mail.getSndEml());
		//amail.setSubject(mail.getTitle());
		//amail.setHtmlContent(mail.getContents());

    //	emailInfo.setRcvEml(recipientArr[i]);
    //	emailInfo.setSndEml(account.getUsr_eml());
    //	emailInfo.setCrtUserId(account.getUsr_id());
    //	emailInfo.setTitle(subject);
    //	emailInfo.setContents(cntent);	
		//MailEAIDAO mailEAIDAO = new MailEAIDAO();
		//return mailEAIDAO.doMail(emailInfo);
		return amail.send();
	}

	/**
	 * sendFileRpt 파일을 Ftp 전송한다.
	 * @param ftpMetaInfo
	 * @return String
	 * @throws FtpException
	 */
	public String sendFileRpt(FtpMetaInfo ftpMetaInfo) throws FtpException {
		return FtpUtility.registerDB(ftpMetaInfo);
	}	
	
	
	/**
	 * ESM_BKG_0726 modify B/L(onboard date, issue date etc) by group 결과를 BackEndJob 결과확인<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception Exception, DAOException
	 */
	public String searchGroupBlUpdateBackEndJobResult(String key) throws Exception {
		try {
			log.debug("<<<<<<"+key);
			return (String)BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new Exception(ex.getMessage(), ex);
		}
	}	
	
	/**
	 * Original B/L download 결과를 BackEndJob 결과확인<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception Exception, DAOException
	 */
	public String searchDownLoadOBLBackEndJobResult(String key) throws Exception {
		try {
			log.debug("<<<<<<"+key);
			return (String)BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new Exception(ex.getMessage(), ex);
		}
	}		
	
	
	/**
	 * BL을 ftp로 전송 후 성공 실패 메일을 전송한다.
	 * 
	 * @param MailSendVO emailInfos
	 * @param String[] params
	 * @param String emailType
	 * @return String
	 * @throws Exception 
	 */
	public String sendEmailResultFTP(MailSendVO info,String[] params, String emailType) throws Exception {
		String reSndId = "";
		
		
		try{
			
			
			StringBuffer sbContents = new StringBuffer(500);

			if("6".equals(emailType)){
				sbContents.append("\n<html>");
				sbContents.append("\n<head>");
				sbContents.append("\n<title></title>");
				sbContents.append("\n<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
				sbContents.append("\n</head>");
				sbContents.append("\n<body>");
				sbContents.append("\n<div>");
				sbContents.append("\n<br>Attn: Helpdesk");
				sbContents.append("\n<br>The Bill of Lading PDF process has failed dut to a system error.");
				sbContents.append("\n<table>");
				sbContents.append("\n<tr><td>Destination File Name     </td><td> : ").append(params[0]).append(" </td></tr>");
				sbContents.append("\n<tr><td>Server Name               </td><td> : ").append(params[1]).append(" </td></tr>");
				sbContents.append("\n<tr><td>Directory Name            </td><td> : ").append(params[2]).append(" </td></tr>");
				sbContents.append("\n<tr><td>Forwarder Reference #     </td><td> : ").append(params[3]).append(" </td></tr>");
				sbContents.append("\n<tr><td>Booking #                 </td><td> : ").append(params[4]).append(" </td></tr>");
				sbContents.append("\n<tr><td>Bill of Lading #          </td><td> : ").append(params[5]).append(" </td></tr>");
				sbContents.append("\n<tr><td>CP name                   </td><td> : ").append(params[6]).append(" </td></tr>");
				sbContents.append("\n<tr><td>Date/Time                 </td><td> : ").append(params[7]).append(" </td></tr>");
				sbContents.append("\n<tr><td>Failure Reason            </td><td> : PDF Creation failed due to: Local System Error: PDF Full Set failed to create     </td></tr>");
				sbContents.append("\n</table>");
				sbContents.append("\n");
				sbContents.append("\n</div>");
				sbContents.append("\n</body>");
				sbContents.append("\n</html>");
			}else if("3".equalsIgnoreCase(emailType)){
				sbContents.append("\n<html>");
				sbContents.append("\n<head>");
				sbContents.append("\n<title></title>");
				sbContents.append("\n<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
				sbContents.append("\n</head>");
				sbContents.append("\n<title>Email notification sample </title>");
				sbContents.append("\n<body>");
				sbContents.append("\n<div>");
				sbContents.append("\n<br>Attn: Helpdesk");
				sbContents.append("\n<br>The Bill of Lading PDF process has succeeded.");
				sbContents.append("\n<table>");
				sbContents.append("\n<tr><td>Destination File Name     </td><td> : ").append(params[0]).append(" </td></tr>");
				sbContents.append("\n<tr><td>Server Name               </td><td> : ").append(params[1]).append(" </td></tr>");
				sbContents.append("\n<tr><td>Directory Name            </td><td> : ").append(params[2]).append(" </td></tr>");
				sbContents.append("\n<tr><td>Forwarder Reference #     </td><td> : ").append(params[3]).append(" </td></tr>");
				sbContents.append("\n<tr><td>Booking #                 </td><td> : ").append(params[4]).append(" </td></tr>");
				sbContents.append("\n<tr><td>Bill of Lading #          </td><td> : ").append(params[5]).append(" </td></tr>");
				sbContents.append("\n<tr><td>CP name                   </td><td> : ").append(params[6]).append(" </td></tr>");
				sbContents.append("\n<tr><td>Date/Time                 </td><td> : ").append(params[7]).append(" </td></tr>");
				sbContents.append("\n</table>");
				sbContents.append("\n");
				sbContents.append("\n</div>");
				sbContents.append("\n</body>");
				sbContents.append("\n</html>");
			}
			
			//filename+ "@@filename;"+ftpSvrNm +"@@ftpSvrNm;"+sbFieldir.toString() + "@@ftpSvrDirNm;" + bkgNo+"@@bkgNo;" + dateTime +"@@datetime;";
			
			Mail mail = new Mail();
//			mail.setComRptDsgnXptInfoVOs(rdVOs);	
			mail.setFrom(info.getSndEml(),info.getSndNm()); 	//보내는 사람 메일주소
			mail.setRecipient(info.getRcvEml());  		//받는 사람 메일주소
			mail.setSubject(info.getTitle());  //메일제목
			mail.setHtmlContent(sbContents.toString());
			reSndId = mail.send();
			log.debug("[EAMIL_SND_ID]"+reSndId);			
			log.debug(sbContents.toString());			
			
		}catch(Exception ex){
			throw new Exception(ex.getMessage(), ex);
		}
		return reSndId;
		
		
//		String reSndId = "";
//		TemplateMail template = null;
//		try {
//			template = new TemplateMail();
//			template.setBatFlg(info.getBatchFlg());
//			template.setFrom(info.getSndEml(),info.getSndNm());
//			template.setRecipient(info.getRcvEml());
//			template.setSubject(info.getTitle()); 
//			template.setHtmlTemplate("3".equalsIgnoreCase(emailType) ? "ESM_BKG_0079_11T.html" : "ESM_BKG_0079_12T.html");	//3, success, 1: fail
//			String arg1 = "";
//			String arg2 = "";
//			for (String arg : info.getContents().split("@@")) {
//				if(arg.split(";").length==1){		//data가 존재하지 않으면 에러 발생 
//					arg1=arg.split(";")[0];
//					arg2="";
//				}else{
//					arg1=arg.split(";")[0];
//					arg2=arg.split(";")[1];
//				}
//				template.setArg(arg1,arg2);
//			}
//			reSndId = template.send();
//		} catch (MailerAppException mae) {
//			throw new EAIException(mae.getMessage(), mae);
//		} catch (Exception ex){
//			throw new Exception(ex.getMessage(), ex);
//		}
//		return reSndId;
	}
}