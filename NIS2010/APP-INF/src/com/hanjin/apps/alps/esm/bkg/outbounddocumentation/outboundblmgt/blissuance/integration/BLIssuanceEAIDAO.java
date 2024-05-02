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
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.ArrayList;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgBlIssRqstMailSndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.FaxSendVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.MailSendVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.N3ptyBlRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.SendMtyRlseOrdVO;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.util.io.FileUtils;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.EAIException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
/**
 * ALPS BLIssuanceEAIDAO <br>
 * - NIS2010-OutboundBLMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
            if ( !"".equals(emailInfo.getFileKey()) && emailInfo.getFileKey() != null ){
                mail.setAttachedFile(FileUtils.getAttachedFiles(emailInfo.getFileKey().split(";"),SiteConfigFactory.get("COM.FILE.UPLOAD.KEY")));
            }
			if (null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getEdtToEml())) {
				mail.setRecipient(bkgEmlEdtVO.getEdtToEml());
				mail.setCcRcvrEml(bkgEmlEdtVO.getEdtCcEml());
				mail.setSubject(bkgEmlEdtVO.getEdtSubject());
				mail.setHtmlContent(bkgEmlEdtVO.getEdtContents());
			} else {
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
				if("WB".equalsIgnoreCase(ntcKndCd) && !"".equals(info.getTmplParam2()) && null != info.getTmplParam2()){
					vo.setXptFileNm(info.getTmplMrdPdf().replace(".pdf", "(Rated).pdf"));
				}else{
					vo.setXptFileNm(info.getTmplMrdPdf());
				}
				
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
						mail.setSubject(bkgEmlEdtVO.getEdtSubject());
						mail.setHtmlContent(bkgEmlEdtVO.getEdtContents());
					} else {
						mail.setRecipient(info.getRcvEml());
						mail.setSubject(info.getTitle());
						mail.setTextContent(info.getContents());
						if (null!=ccRcvrEml && !"".equals(ccRcvrEml)) {
							mail.setCcRcvrEml(ccRcvrEml);
						}
					}
					retList.add(mail.send());
				} else {
					
					if("WB".equalsIgnoreCase(ntcKndCd) && !"".equals(info.getTmplParam2()) && null != info.getTmplParam2()){
						
						ComRptDsgnXptInfoVO vo2 = new ComRptDsgnXptInfoVO();
						vo2.setRdTmpltNm(info.getTmplMrd()); 
						vo2.setXptFileTpCd(ExportInfo.FTYPE_PDF);
						vo2.setXptFileNm(info.getTmplMrdPdf().replace(".pdf", "(Unrated).pdf"));
						vo2.setCreUsrId(info.getCrtUserId());
						vo2.setUpdUsrId(info.getCrtUserId());						
						vo2.setRdParaCtnt(info.getTmplParam2());
						vos.add(vo2);
					}
					
					template = new TemplateMail();
					template.setBatFlg(info.getBatchFlg());
					template.setComRptDsgnXptInfoVOs(vos);
					template.setFrom(info.getSndEml(),info.getSndNm());
					template.setAttachedFile(fileList);
					if (null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getEdtToEml())) {
log.debug("\n\n\n\n\n\n\nEMAIL(EDIT)\n\n\n\n\n\n\n");					
						template.setRecipient(bkgEmlEdtVO.getEdtToEml());
						template.setCcRcvrEml(bkgEmlEdtVO.getEdtCcEml());
						template.setSubject(bkgEmlEdtVO.getEdtSubject());
						template.setHtmlContent(bkgEmlEdtVO.getEdtContents());
					} else {
log.debug("\n\n\n\n\n\n\nEMAIL(NORMAL)\n\n\n\n\n\n\n");					
						template.setRecipient(info.getRcvEml());
						if (null!=ccRcvrEml && !"".equals(ccRcvrEml)) {
							template.setCcRcvrEml(ccRcvrEml);
						}
						template.setSubject(info.getTitle()); 
						if(null != info.getTextContents()){
							if("CN".equals(info.getTextContents())){
								template.setHtmlTemplate("WB".equalsIgnoreCase(ntcKndCd) ? "ESM_BKG_0218_02T.html" : ("NN".equalsIgnoreCase(ntcKndCd) ? "ESM_BKG_0218_03T.html" : "ESM_BKG_0218_05T.html"));
							}else if ("KR".equals(info.getTextContents())){
								template.setHtmlTemplate("WB".equalsIgnoreCase(ntcKndCd) ? "ESM_BKG_0218_02T.html" : ("NN".equalsIgnoreCase(ntcKndCd) ? "ESM_BKG_0218_03T.html" : "ESM_BKG_0218_06T.html"));
							}else{
								template.setHtmlTemplate("WB".equalsIgnoreCase(ntcKndCd) ? "ESM_BKG_0218_02T.html" : ("NN".equalsIgnoreCase(ntcKndCd) ? "ESM_BKG_0218_03T.html" : "ESM_BKG_0218_01T.html"));
							}
						}else{
							template.setHtmlTemplate("WB".equalsIgnoreCase(ntcKndCd) ? "ESM_BKG_0218_02T.html" : ("NN".equalsIgnoreCase(ntcKndCd) ? "ESM_BKG_0218_03T.html" : "ESM_BKG_0218_01T.html"));
						}
						
						for (String arg : info.getContents().split("@@")) {
							template.setArg(arg.split(";")[0],arg.split(";")[1]);
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
		String sndrInfo = "";
		try {
			for (int i=0; i<arrLen; i++) {
				
				if(!"".equals(faxInfos[i].getOffice()) && "SINSC".equals(faxInfos[i].getOffice())){
					sndrInfo = "SM Line"; //"HANJIN SIN";
				}else{
					sndrInfo = faxInfos[i].getCrtUserId();
				} 

				infos[i] = new FaxMetaInfo(faxInfos[i].getSysCd(),     // 모듈명(ex.BKG)
	 		               (0<=faxInfos[i].getTmplMrd().indexOf("/")) ? 
	 		            	   faxInfos[i].getTmplMrd().substring(faxInfos[i].getTmplMrd().lastIndexOf("/")+1) :
	 		            	   faxInfos[i].getTmplMrd(),  // MRD 파일 명 (ex.WO_NORMAL.mrd)
				           faxInfos[i].getBatchFlg(),  // 배치 유무(Y/N)
				           faxInfos[i].getTitle(),     // 제목
				           faxInfos[i].getTmplParam(), // RD Parameter (ex. [419][1][selho])
				           faxInfos[i].getRcvInfo(),   // 이름+FAX번호 (받는 사람1;fax1,받는사람2,fax2)
				           faxInfos[i].getOffice(),    // 지역 FAX office
				           sndrInfo  // 보내는 사람
				          ); 
 

			}
					
			return FaxUtility.registerDB(infos);

		} catch (Exception ex){
			throw new Exception(ex.getMessage(), ex);
		}
	}
	
	/**
	 * Email(E/Q)을 전송한다.
	 * 
	 * @param MailSendVO emailInfo
	 * @param String ntcKndCd
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws Exception
	 */
	public String sendEqEmail(MailSendVO emailInfo,String ntcKndCd, SignOnUserAccount account) throws Exception {
		MailSendVO[] infos = new MailSendVO[1];
		infos[0] = emailInfo;
		
		List<String> sendId = sendEqEmail(infos, ntcKndCd, account);
		if (sendId.size() > 0) return sendId.get(0);
		else return "";
	}
	
	/**
	 * Email(E/Q)을 전송한다.
	 * 
	 * @param MailSendVO[] emailInfos
	 * @param String ntcKndCd
	 * @param SignOnUserAccount account
	 * @return List<String>
	 * @throws Exception 
	 */
	public List<String> sendEqEmail(MailSendVO[] emailInfos,String ntcKndCd, SignOnUserAccount account) throws Exception {
		int arrLen = emailInfos.length;
//		List<SingleMailAttachedFile> fileList = null;
		MailSendVO info = null;
		List<String> retList = null;
//		List<ComRptDsgnXptInfoVO> vos = null;
//		ComRptDsgnXptInfoVO vo = null;
		TemplateMail template = null;
		Mail mail = null;
		try {
			retList = new ArrayList<String>();
			for (int i=0; i<arrLen; i++) {
				info = emailInfos[i];
//				fileList = new ArrayList<SingleMailAttachedFile>();
//				if(info.getFileKey() != null && 
//				   !"".equalsIgnoreCase(info.getFileKey()) &&
//				   !info.getFileKey().equalsIgnoreCase("null")) {
//					String[] fileKeys = info.getFileKey().split(";");
//					for(String fileKey:fileKeys) {
//						SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
//						attachedFile.setFileKey(fileKey);
//						fileList.add(attachedFile); 
//					}
//				}
//				vo = new ComRptDsgnXptInfoVO();
//				vo.setRdTmpltNm(info.getTmplMrd());
//				vo.setRdParaCtnt(info.getTmplParam());
//				vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
//				vo.setXptFileNm(info.getTmplMrdPdf());
//				vo.setCreUsrId(info.getCrtUserId());
//				vo.setUpdUsrId(info.getCrtUserId());
//				vos = new ArrayList<ComRptDsgnXptInfoVO>();
//				vos.add(vo);
				if (StringUtils.isEmpty(ntcKndCd)) {
					mail = new Mail();
					mail.setBatFlg(info.getBatchFlg());
//					mail.setComRptDsgnXptInfoVOs(vos);
					mail.setFrom(info.getSndEml(),info.getSndNm());
//					mail.setAttachedFile(fileList);
					mail.setRecipient(info.getRcvEml());
					mail.setSubject(info.getTitle());
					mail.setTextContent(info.getContents());
					retList.add(mail.send());
				} else {
					template = new TemplateMail();
					template.setBatFlg(info.getBatchFlg());
					template.setFrom(info.getSndEml(),info.getSndNm());
//					template.setAttachedFile(fileList);
					template.setRecipient(info.getRcvEml());
					template.setSubject(info.getTitle()); 
					if(account.getOfc_cd().startsWith("SEL")){
						template.setHtmlTemplate("ESM_BKG_0218_09T.html");
					}else{
						template.setHtmlTemplate("ESM_BKG_0218_10T.html");
					}

					
					for (String arg : info.getContents().split("@@")) {
						template.setArg(arg.split(";")[0],arg.split(";")[1]);
					}
					retList.add(template.send());
				}
			}
		} catch (MailerAppException mae) {
			throw new EAIException(mae.getMessage(), mae);
		} catch (Exception ex){
			throw new Exception(ex.getMessage(), ex);
		}
		return retList;
	}

	
	/**
	 * Email(S/R)을 전송한다.
	 * 
	 * @param MailSendVO emailInfo
	 * @param String ntcKndCd
	 * @param String cnOfcFlg
	 * @return String
	 * @throws Exception
	 */
	public String sendSrEmail(MailSendVO emailInfo,String ntcKndCd,String cnOfcFlg) throws Exception {
		MailSendVO[] infos = new MailSendVO[1];
		infos[0] = emailInfo;
		
		List<String> sendId = sendSrEmail(infos, ntcKndCd,cnOfcFlg);
		if (sendId.size() > 0) return sendId.get(0);
		else return "";
	}
	
	/**
	 * Email(S/R)을 전송한다.
	 * 
	 * @param MailSendVO[] emailInfos
	 * @param String ntcKndCd
	 * @param String cnOfcFlg
	 * @return List<String>
	 * @throws Exception 
	 */
	public List<String> sendSrEmail(MailSendVO[] emailInfos,String ntcKndCd, String cnOfcFlg) throws Exception {
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
					mail.setRecipient(info.getRcvEml());
					mail.setSubject(info.getTitle());
					mail.setTextContent(info.getContents());
					retList.add(mail.send());
				} else {
					template = new TemplateMail();
					template.setBatFlg(info.getBatchFlg());
					template.setFrom(info.getSndEml(),info.getSndNm());
					template.setAttachedFile(fileList);
					template.setRecipient(info.getRcvEml());
					template.setSubject(info.getTitle()); 
					if("Y".equals(cnOfcFlg)){
						template.setHtmlTemplate("ESM_BKG_0218_08T.html");
					}else{
						template.setHtmlTemplate("ESM_BKG_0218_04T.html");
					}

					
					for (String arg : info.getContents().split("@@")) {
						template.setArg(arg.split(";")[0],arg.split(";")[1]);
					}
					retList.add(template.send());
				}
			}
		} catch (MailerAppException mae) {
			throw new EAIException(mae.getMessage(), mae);
		} catch (Exception ex){
			throw new Exception(ex.getMessage(), ex);
		}
		return retList;
	}
	
	/**
	 * Template 메일을 전송한다.
	 * 
	 * @param BkgBlIssRqstMailSndVO bkgBlIssRqstMailSndVO
	 * @return String
	 * @throws Exception
	 */	
    public String sendBlIssRqstByMail(BkgBlIssRqstMailSndVO bkgBlIssRqstMailSndVO) throws Exception {
		String sndId = "";
		TemplateMail template = null;
		log.debug("@@@@@@ BLIssuanceEAIDAO : sendBlIssRqstByMail start : blNo = "+bkgBlIssRqstMailSndVO.getBlNo());
		try{
			String sUsrEml = "noreply@smlines.com";
			
			if (null!=bkgBlIssRqstMailSndVO.getBlNo() && !"".equals(bkgBlIssRqstMailSndVO.getBlNo())) {
				
				template = new TemplateMail();
				template.setBatFlg("N");
				template.setFrom(sUsrEml,bkgBlIssRqstMailSndVO.getUsr_nm());
				log.debug("@@@@@@ BLIssuanceEAIDAO : vo.getUsr_nm() = "+bkgBlIssRqstMailSndVO.getUsr_nm());
				template.setSubject(bkgBlIssRqstMailSndVO.getEmlTitNm());
				log.debug("@@@@@@ BLIssuanceEAIDAO : vo.getEmlTitNm() = "+bkgBlIssRqstMailSndVO.getEmlTitNm());
				template.setRecipient(bkgBlIssRqstMailSndVO.getRcvrEml());
				log.debug("@@@@@@ BLIssuanceEAIDAO : vo.getRcvrEml() = "+bkgBlIssRqstMailSndVO.getRcvrEml());
				//template.setCcRcvrEml(bkgBlIssRqstMailSndVO.getCcRcvrEml());
				template.setHtmlTemplate("ESM_BKG_1119_01.html"); 
				log.debug("@@@@@@ BLIssuanceEAIDAO : template.setHtmlTemplate ");
				template.setArg("subject",bkgBlIssRqstMailSndVO.getEmlTitNm());
				log.debug("@@@@@@ BLIssuanceEAIDAO : subject = EmlTitNm = "+bkgBlIssRqstMailSndVO.getEmlTitNm());
//				template.setArg("date",bkgBlIssRqstMailSndVO.getSndDt());
				// 고객명을 html 형식으로 변환
				template.setArg("custNm",bkgBlIssRqstMailSndVO.getRcvrNm().replaceAll("\n", "<br>"));
				log.debug("@@@@@@ BLIssuanceEAIDAO : custNm = "+bkgBlIssRqstMailSndVO.getRcvrNm().replaceAll("\n", "<br>"));
				template.setArg("blNo",bkgBlIssRqstMailSndVO.getBlNo());
				log.debug("@@@@@@ BLIssuanceEAIDAO : blNo = "+bkgBlIssRqstMailSndVO.getBlNo());
//				template.setArg("cntrNo",bkgBlIssRqstMailSndVO.getCntrNo());
				// 본문 내용을 html 형식으로 변환
//				String rmk = bkgBlIssRqstMailSndVO.getRmk();
//				rmk = rmk.replaceAll("\n", "<br>");
//				rmk = rmk.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
//				rmk = rmk.replaceAll("\\p{Space}", "&nbsp;");
//				
//				template.setArg("rmk",rmk);

				sndId = template.send();
				log.debug("@@@@@@ BLIssuanceEAIDAO : sndId = "+sndId);
				
			}
		} catch (MailerAppException mae) {
			this.log.error(mae.getCause());
			throw new Exception(mae.getMessage(), mae);
		} catch (Exception e){
			throw new Exception(e.getMessage(), e);
		}
		
		return sndId;
    }
    
	/**
	 * Late SI,AES/CAED Notice를 전송한다.
	 * @param MailSendVO emailInfo
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param String ntcKndCd
	 * @return String
	 * @throws Exception
	 */
	public String sendRmdEmail(MailSendVO emailInfo,BkgEmlEdtVO bkgEmlEdtVO,String ntcKndCd) throws Exception {
		MailSendVO[] infos = new MailSendVO[1];
		infos[0] = emailInfo;
		
		List<String> sendId = sendRmdEmail(infos,bkgEmlEdtVO,ntcKndCd);   
		if (sendId.size() > 0) return sendId.get(0);
		else return "";
	}
	
	/**
	 * Late SI,AES/CAED Notice를 전송한다.
	 * 
	 * @param MailSendVO[] emailInfos
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param String ntcKndCd
	 * @return List<String>
	 * @throws Exception 
	 */
	public List<String> sendRmdEmail(MailSendVO[] emailInfos,BkgEmlEdtVO bkgEmlEdtVO,String ntcKndCd) throws Exception {
		int arrLen = emailInfos.length;
		List<SingleMailAttachedFile> fileList = null;
		MailSendVO info = null;
		List<String> retList = null;
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
				if (StringUtils.isEmpty(ntcKndCd)) {
					mail = new Mail();
					mail.setBatFlg(info.getBatchFlg());
					mail.setFrom(info.getSndEml(),info.getSndNm());
					mail.setAttachedFile(fileList);
					if (null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getEdtToEml())) {
						mail.setRecipient(bkgEmlEdtVO.getEdtToEml());
//						mail.setCcRcvrEml(bkgEmlEdtVO.getEdtCcEml());
						mail.setSubject(bkgEmlEdtVO.getEdtSubject());
						mail.setHtmlContent(bkgEmlEdtVO.getEdtContents());
					} else {
						mail.setRecipient(info.getRcvEml());
						mail.setSubject(info.getTitle());
						mail.setTextContent(info.getContents());
					}
					retList.add(mail.send());
				} else {
					template = new TemplateMail();
					template.setBatFlg(info.getBatchFlg());
					template.setFrom(info.getSndEml(),info.getSndNm());
					template.setAttachedFile(fileList);
					if (null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getEdtToEml())) {
log.debug("\n\n\n\n\n\n\nEMAIL(EDIT)\n\n\n\n\n\n\n");					
						template.setRecipient(bkgEmlEdtVO.getEdtToEml());
//						template.setCcRcvrEml(bkgEmlEdtVO.getEdtCcEml());
						template.setSubject(bkgEmlEdtVO.getEdtSubject());
						template.setHtmlContent(bkgEmlEdtVO.getEdtContents());
					} else {
log.debug("\n\n\n\n\n\n\nEMAIL(NORMAL)\n\n\n\n\n\n\n");					
						template.setRecipient(info.getRcvEml());
						template.setSubject(info.getTitle()); 
						template.setHtmlTemplate("DR".equalsIgnoreCase(ntcKndCd) ? "ESM_BKG_0095_09T.html" : "ESM_BKG_0095_10T.html");
log.debug(info.getContents());
						for (String arg : info.getContents().split("@@")) {
							template.setArg(arg.split(";")[0],arg.split(";")[1]);
						}
					}
					retList.add(template.send());
				}
			}
		} catch (MailerAppException mae) {
			throw new EAIException(mae.getMessage(), mae);
		} catch (Exception ex){
			throw new Exception(ex.getMessage(), ex);
		}
		return retList;
	}
	
	
	
    /**
     * approval과 reject결과를 메일로 전송한다.
     * @param N3ptyBlRqstVO n3ptyBlRqstVO
     * @param SignOnUserAccount account
     * @return String
     * @throws Exception
     */
    public String sendN3ptyBlRqst(N3ptyBlRqstVO n3ptyBlRqstVO, SignOnUserAccount account) throws Exception {
		String sndId = "";
		TemplateMail template = null;

		try{
			
			if (null!=n3ptyBlRqstVO.getBkgNo() && !"".equals(n3ptyBlRqstVO.getBkgNo())) {
				
				template = new TemplateMail();
				template.setBatFlg("N");
				template.setFrom(account.getUsr_eml(),account.getUsr_nm());
				template.setSubject("3rd Party Billing & Issue Request Result (BKG# "+n3ptyBlRqstVO.getBkgNo()+")");
				template.setRecipient(n3ptyBlRqstVO.getUsrEml());
    			if("A".equals(n3ptyBlRqstVO.getN3ptyBlStsCd())){
    				template.setHtmlTemplate("ESM_BKG_9460_01T.html"); 
    			}else{
    				template.setHtmlTemplate("ESM_BKG_9460_02T.html");   
    			}

				template.setArg("bkgNo",n3ptyBlRqstVO.getBkgNo());
				sndId = template.send();
				log.debug("@@@@@@ BLIssuanceEAIDAO : sndId = "+sndId);
				
			}
		} catch (MailerAppException mae) {
			this.log.error(mae.getCause());
			throw new Exception(mae.getMessage(), mae);
		} catch (Exception e){
			throw new Exception(e.getMessage(), e);
		}
		
		return sndId;
    }
    
    /**
	 * Mail : BKG001
	 * RDMail을 전송한다.
	 * 
	 * @param DblWblVO[] emailInfos
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param SignOnUserAccount account
	 * @return List<String>
	 * @throws Exception
	 */
	private List<String> sendRDEmailForSamsung(DblWblVO[] emailInfos,BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws Exception {
		List<String> sndIds = null;
		List<ComRptDsgnXptInfoVO> vos = null;
		ArrayList<SingleMailAttachedFile> fileList = null;
		ComRptDsgnXptInfoVO vo = null;
		TemplateMail template = null;
		String bkgNo = null;
		try {
			sndIds = new ArrayList<String>();
			for (int i=0; i<emailInfos.length; i++) {
				bkgNo = emailInfos[i].getBkgNo();
				vo = new ComRptDsgnXptInfoVO();
				vo.setRdTmpltNm(emailInfos[i].getTmplmrd());
				vo.setRdParaCtnt(emailInfos[i].getTmplparam());
				vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				vo.setXptFileNm("MBL_SMLM"+bkgNo+".pdf");
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				vos = new ArrayList<ComRptDsgnXptInfoVO>();
				vos.add(vo);
				fileList = new ArrayList<SingleMailAttachedFile>();
				if(null!=bkgEmlEdtVO && bkgEmlEdtVO.getFileKey() != null ){
					String[] file = bkgEmlEdtVO.getFileKey().split(";");
					for( String fileKey:file ){
						SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
						attachedFile.setFileKey(fileKey);
						fileList.add(attachedFile); 
					}
				}
				
				template = new TemplateMail();
				template.setAttachedFile(fileList);
				template.setBatFlg(emailInfos[i].getBatchflg());
				template.setComRptDsgnXptInfoVOs(vos);
				template.setFrom(emailInfos[i].getSndeml(),"SM Line");
				template.setRecipient(emailInfos[i].getRcveml());
				template.setSubject(emailInfos[i].getTitle());
				template.setHtmlTemplate("ESM_BKG_0218_01T.html");
				template.setArg("blNoTitle","prealert:DR4E:SMLM"+emailInfos[i].getBkgNo());
				template.setArg("blNoBody",emailInfos[i].getBlNo());
				template.setCcRcvrEml("");
//				if (null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getEdtToEml())) {
//					template.setRecipient(bkgEmlEdtVO.getEdtToEml());
//					template.setCcRcvrEml(bkgEmlEdtVO.getEdtCcEml());
//					template.setSubject(bkgEmlEdtVO.getEdtSubject()); 
//					template.setHtmlContent(bkgEmlEdtVO.getEdtContents());
//				} else {
//					template.setRecipient(emailInfos[i].getRcvEml());
//					template.setCcRcvrEml(ccEmail);
//					template.setSubject(emailInfos[i].getTitle()); 
//					template.setHtmlTemplate("ESM_BKG_0252_01T.html");
//					template.setArg("bkgNoTitle","BKG No : "+bkgNo);
//					template.setArg("bkgNoBody",bkgNo);
//				}
				sndIds.add(template.send());
			}
		} catch (MailerAppException mae) {
			throw new EAIException(mae.getMessage(), mae);
		} catch (Exception ex){
			throw new EAIException(ex.getMessage(), ex);
		}
		return sndIds;
	}
	
	/**
	 * RD 메일을 전송한다.(파일 미첨부)
	 * 
	 * @param SendMtyRlseOrdVO sendMtyRlseOrdVO
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param String ccEmail
	 * @author Choi Do Soon
	 * @return String
	 * @throws Exception
	 */
	public String sendRDEmail(DblWblVO dblWblVO,BkgEmlEdtVO bkgEmlEdtVO,SignOnUserAccount account) throws Exception {
				
		DblWblVO[] infos = new DblWblVO[1];

		infos[0] = dblWblVO;
		
		List<String> sendId = sendRDEmailForSamsung(infos,bkgEmlEdtVO,account);
		
		if (sendId.size() > 0) return sendId.get(0);
		else return "";
	}

}