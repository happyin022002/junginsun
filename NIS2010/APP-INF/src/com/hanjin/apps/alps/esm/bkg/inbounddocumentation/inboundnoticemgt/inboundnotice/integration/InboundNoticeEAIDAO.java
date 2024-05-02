/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InboundNoticeEAIDAO.java
*@FileTitle : Inbound Notice EAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.07.13 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.common.Constants;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.FaxSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.RDMailSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.TmpMailSendVO;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailGroup;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.util.io.FileUtils;
import com.hanjin.framework.component.vo.MailGroupResultVO;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
import com.hanjin.syscommon.common.util.MessageUtil;

/**
 * ALPS InboundNoticeEAIDAO <br>
 * - ALPS-InboundNoticeMgt system EAIDAO 연동을 처리하기 위한 작업수행.<br>
 * 
 * @author Park Mi-Ok
 * @see InboundNoticeEAIDAO
 * @since J2EE 1.4
 */
public class InboundNoticeEAIDAO extends EAIDAOSupport {


	/**
	 * Fax 를 전송한다.(Fax Queue에 전송)<br>
	 * 
	 * @param FaxSendVO faxInfo
	 * @return String
	 * @throws Exception
	 */
	public String sendFax(FaxSendVO faxInfo) throws Exception {
		
		List<FaxSendVO> infos = new ArrayList<FaxSendVO>();
		
		infos.add(faxInfo);		
		
		List<String> sendId = sendFax(infos);
		
		if (sendId.size() > 0) return sendId.get(0);
		else return "";
	}
	 
	
	/**
	 * Fax 를 전송한다.(Fax Queue에 전송)<br>
	 * 
	 * @param List<FaxSendVO> faxInfos
	 * @return List<String>
	 * @throws Exception
	 */
	public List<String> sendFax(List<FaxSendVO> faxInfos) throws Exception {
		List<FaxMetaInfo> metaInfos = new ArrayList<FaxMetaInfo>();
		
		try {
			for (int i=0; i<faxInfos.size(); i++) {
				FaxSendVO faxInfo = faxInfos.get(i);
				FaxMetaInfo metaInfo = new FaxMetaInfo(faxInfo.getSysCd(),     // 모듈명(ex.BKG)
					 		               faxInfo.getTmplMrd(),   // MRD 파일 명 (ex.WO_NORMAL.mrd)
							               faxInfo.getBatchFlg(),  // 배치 유무(Y/N)
								           faxInfo.getTitle(),     // 제목
								           faxInfo.getTmplParam(), // RD Parameter (ex. [419][1][selho])
								           //faxInfo.getRcvInfo(),   // 이름+FAX번호 (받는 사람1;fax1,받는사람2,fax2)
								           faxInfo.getRcvInfo().replaceAll("\r\n", " "),   // 이름+FAX번호 (받는 사람1;fax1,받는사람2,fax2)
								           faxInfo.getOffice(),    // 지역 FAX office
								           faxInfo.getCrtUserId()  // 보내는 사람 
								          ); 
				metaInfos.add(metaInfo);
			}
					
			return FaxUtility.registerDB(metaInfos);

		} catch (Exception ex){
			throw new Exception(ex.getMessage(), ex);
		}
	}	
	

	/**
	 * RD List 를 Mail 한통만 발송(S)
	 * 이용 UI ; 0946(Group A/N Merge Popup)
	 * @param RDMailSendVO rdEmailInfo
	 * @param List<ComRptDsgnXptInfoVO> reportDesignerExportVOs
	 * @return String
	 * @throws Exception
	 */
		@SuppressWarnings("unchecked")
        public String sendReportDesignerWithFiles(RDMailSendVO rdEmailInfo, List<ComRptDsgnXptInfoVO> reportDesignerExportVOs) throws EventException {
			log.debug("--------------- 다건의 RD을 메일 한건만 발송 ");
			try {

				Mail mail = new Mail();
				
				mail.setFrom(rdEmailInfo.getSndrEml(),rdEmailInfo.getSndrNm()); // 보내는 사람 메일주소				
				mail.setRecipient(rdEmailInfo.getRcvrEml()); // 받는 사람 메일주소
				mail.setSubject(rdEmailInfo.getEmlTitNm()); // 메일 제목
				
				//String[] strArr = null;				
				String contents = "";
				if(rdEmailInfo.getTemplate() != null && !"".equals(rdEmailInfo.getTemplate())){
					contents = FileUtils.fileReader(SiteConfigFactory.get("COM.HANJIN.JAF.MAIL.TEMPLATE.DIR"), rdEmailInfo.getTemplate());
					//Set Arguments
					Map<String, String> arguments = rdEmailInfo.getArguments();

					Iterator k = arguments.keySet().iterator();
				    //strArr = new String[arguments.size()];
				     
				    while(k.hasNext()){
				    	String argName = (String) k.next();
				    	
				    	contents = contents.replaceAll("<@ "+argName+" >", arguments.get(argName));
				    	log.debug("~~~~~~~~~~~ contents + "+ contents);
				    }
				} else {
					contents = rdEmailInfo.getTextContent();
					
				}				
				mail.setHtmlContent(contents);
				log.debug("------------------ file upload filekey " + rdEmailInfo.getFileKey());
				log.debug("------------------ SiteConfigFactory.get(COM.FILE.UPLOAD.KEY) " + SiteConfigFactory.get("COM.FILE.UPLOAD.KEY"));
				for(int xx=0;xx<reportDesignerExportVOs.size();xx++){
					log.debug("---------------" + reportDesignerExportVOs.get(xx).getCreUsrId());
				}
				if ( !"".equals(rdEmailInfo.getFileKey()) && rdEmailInfo.getFileKey() != null ){					
					mail.setAttachedFile(FileUtils.getAttachedFiles(rdEmailInfo.getFileKey().split(";"),SiteConfigFactory.get("COM.FILE.UPLOAD.KEY")));
					
				}
				mail.setCreUsrIds(rdEmailInfo.getUserId());
				mail.setComRptDsgnXptInfoVOs(reportDesignerExportVOs);	
				
				return mail.send();

			} catch (MailerAppException e) {
				throw new EventException(e.getMessage(), e);
			} catch (Exception e) {				
				throw new EventException(e.getMessage(), e);
			}
		}	

		

		/**
		 * RD List 를 Mail 주소별 Group으로 발송(S)
		 * 이용 UI ; 0381(Arrival Notice Send)
		 * @param List<RDMailSendVO> rdEmailInfos
		 * @return List<String>
		 * @throws Exception
		 */
		public List<String> sendEmailGroupRDWithFiles(List<RDMailSendVO> rdEmailInfos) throws EventException {			
			try {
				
				MailGroup mailGroup = new MailGroup();
				for(int x=0;x<rdEmailInfos.size();x++){
					RDMailSendVO rdEmailInfo = rdEmailInfos.get(x);					
					//Mail mail = new Mail();
					TemplateMail mail = new TemplateMail();
					
					
					mail.setFrom(rdEmailInfo.getSndrEml()); // 보내는 사람 메일주소
					mail.setRecipient(rdEmailInfo.getRcvrEml()); // 받는 사람 메일주소
					mail.setSubject(rdEmailInfo.getEmlTitNm()); // 메일 제목

					String contents = "";
					if(rdEmailInfo.getTemplate() != null && !"".equals(rdEmailInfo.getTemplate())){
						contents = FileUtils.fileReader(SiteConfigFactory.get("COM.HANJIN.JAF.MAIL.TEMPLATE.DIR"), rdEmailInfo.getTemplate());
						
						//Set Arguments
						Map<String, String> arguments = rdEmailInfo.getArguments();
	
						Iterator<String> k = arguments.keySet().iterator();
						//String[] strArr = new String[arguments.size()];
					    
					    while(k.hasNext()){
					    	String argName = (String) k.next();					    	
					    	contents = contents.replaceAll("<@ "+argName+" >", arguments.get(argName));					    	
					    }
					} else {
						contents = rdEmailInfo.getTextContent();
						
					}
					
					mail.setHtmlContent(contents);					
					if ( !"".equals(rdEmailInfo.getFileKey()) && rdEmailInfo.getFileKey() != null ){					
						mail.setAttachedFile(FileUtils.getAttachedFiles(rdEmailInfo.getFileKey().split(";"),SiteConfigFactory.get("COM.FILE.UPLOAD.KEY")));						
					}
					
					
					//RD 파일 추가
					mail.setComRptDsgnXptInfoVOs(rdEmailInfo.getComRptDsgnXptInfoVOs());
					
					//Group 발신정보등록
					mailGroup.setFrom(rdEmailInfo.getSndrEml(),rdEmailInfo.getSndrNm());
					mailGroup.setSubject(rdEmailInfo.getEmlTitNm());	
					//mailGroup.setEmlCtnt(new StringBuilder(contents));
					mailGroup.setHtmlContent(contents);
					//mailGroup.setTextContent(contents);
					//Group Mail 추가						
					mailGroup.addMail(mail);
					
					log.debug("---------------------------- contents "+contents);
					
					
					
				}				
				//그룹된 메일 전송
				
				List<String> b = new ArrayList<String>();				
				log.debug("---------------------------- mailGroup.getEmlCtnt() "+mailGroup.getEmlCtnt());
				//List<List<MailGroupResultVO>> retSndOutList = mailGroup.sendMailGroup();					
				List<List<MailGroupResultVO>> retSndOutList = mailGroup.sendMailGroupSplit(Constants.EML_ATTACH_SIZE);
				//List<List<MailGroupResultVO>> retSndOutList = mailGroup.sendMailGroupSplit(10 * 100 * 1024);//1M
				
				log.debug("----------------- rdEmailInfos size "+rdEmailInfos.size());
				log.debug("----------------- retSndOutList size "+retSndOutList.size());
				
				for(int i=0;i<retSndOutList.size();i++){
					List<MailGroupResultVO> retSndList = retSndOutList.get(i);
					for(int j=0;j<retSndList.size();j++){
						MailGroupResultVO groupResultVO = retSndList.get(j);
						b.add(groupResultVO.getEmlSndNo());
						log.debug("-----------------  그룹된 getEmlSndNo " + j + " : "+ groupResultVO.getEmlSndNo());
						log.debug("-----------------  그룹된 getToEmlCtnt " + j + " : "+ groupResultVO.getToEmlCtnt());
					}
				}
				
				return b;
			
			} catch (MailerAppException e) {				
				throw new EventException(e.getMessage(),e);
			} catch (Exception e) {
				throw new EventException(e.getMessage(),e);
			}
		}
	
	
	/**
	 * RD 메일을 전송한다.(Template 메일인 경우)
	 * 
	 * @param RDMailSendVO emailInfo
	 * @return String Email SendID
	 * @throws Exception
	 */	
    public String sendEmail(RDMailSendVO emailInfo) throws Exception {

		TemplateMail mail = new TemplateMail();
				
		//Mail Attach  (ex) file1;file2;...
		List<SingleMailAttachedFile> list = new ArrayList<SingleMailAttachedFile>();

		if(emailInfo.getFileKey() != null && 
		   !"".equalsIgnoreCase(emailInfo.getFileKey()) &&
		   !emailInfo.getFileKey().equalsIgnoreCase("null")) {

			String[] fileKeys = emailInfo.getFileKey().split(";");
			for(String fileKey:fileKeys){
				SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
				attachedFile.setFileKey(fileKey);
				list.add(attachedFile); 
				mail.setAttachedFile(list);
			}
		}

		mail.setFrom(emailInfo.getSndrEml(), emailInfo.getSndrNm());
		mail.setSubject(emailInfo.getEmlTitNm());
		//mail.setRecipient(emailInfo.getRcvrEml(), emailInfo.getRcvrNm());
		mail.setRecipient(emailInfo.getRcvrEml());
		
		mail.setHtmlContent(emailInfo.getHtmlContent());
		
		
		//Template 설정
		if(emailInfo.getTemplate() != null && !"".equals(emailInfo.getTemplate())){
			mail.setHtmlTemplate(emailInfo.getTemplate());
			
			//Set Arguments
			Map<String, String> arguments = emailInfo.getArguments();
			
			if (arguments != null) {
				Iterator k = arguments.keySet().iterator();
			    while (k.hasNext()) {		      
			    	String argName = (String) k.next();		      
					mail.setArg(argName, arguments.get(argName));
			    }
			}
		}
		
		mail.setComRptDsgnXptInfoVOs(emailInfo.getComRptDsgnXptInfoVOs());
		
		return mail.send();
	}

	/**
	 * RD 메일을 전송한다.(Template 메일인 경우)
	 * 
	 * @param List<RDMailSendVO> emailInfos
	 * @return List<String> Email SendID
	 * @exception Exception
	 */	
    public List<String> sendEmailGroup(List<RDMailSendVO> emailInfos) throws Exception {

    	MailGroup  mailGroup = new MailGroup();
		TemplateMail mail = null;
		List<SingleMailAttachedFile> list = null;
		RDMailSendVO emailInfo = null; 
		
		for (int i=0; i<emailInfos.size(); i++) 
		{
			emailInfo= emailInfos.get(i);
			
			
			mail = new TemplateMail();
			list = new ArrayList<SingleMailAttachedFile>(); // Mail Attach  (ex) file1;file2;...

			if(emailInfo.getFileKey() != null && 
			   !"".equalsIgnoreCase(emailInfo.getFileKey()) &&
			   !emailInfo.getFileKey().equalsIgnoreCase("null")) {

				String[] fileKeys = emailInfo.getFileKey().split(";");
				for(String fileKey:fileKeys){
					SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
					attachedFile.setFileKey(fileKey);
					list.add(attachedFile); 
					mail.setAttachedFile(list);
				}
			}

			mail.setFrom(emailInfo.getSndrEml(), emailInfo.getSndrNm());
			mail.setSubject(emailInfo.getEmlTitNm());
			mail.setRecipient(emailInfo.getRcvrEml());
			mail.setHtmlContent(emailInfo.getHtmlContent());
		
			
			//Group 발신정보등록
			mailGroup.setFrom(emailInfo.getSndrEml(), emailInfo.getSndrNm());
			mailGroup.setSubject(emailInfo.getEmlTitNm());	
			mailGroup.setHtmlContent(emailInfo.getHtmlContent());

			
			//Template 설정
			if(emailInfo.getTemplate() != null && !"".equals(emailInfo.getTemplate())){
				mail.setHtmlTemplate(emailInfo.getTemplate());
				mailGroup.setHtmlTemplate(emailInfo.getTemplate());
				
				//Set Arguments
				Map<String, String> arguments = emailInfo.getArguments();
				
				if (arguments != null) {
					Iterator k = arguments.keySet().iterator();
				    while (k.hasNext()) {		      
				    	String argName = (String) k.next();		      
						mail.setArg(argName, arguments.get(argName));
						mailGroup.setArg(argName, arguments.get(argName));
				    }
				}
			}
			mail.setComRptDsgnXptInfoVOs(emailInfo.getComRptDsgnXptInfoVOs());
			

			//Group Mail 추가						
			mailGroup.addMail(mail);
		}

		List<List<MailGroupResultVO>> retSndOutList = mailGroup.sendMailGroupSplit(Constants.EML_ATTACH_SIZE);					

		MailGroupResultVO groupResultVO = null;
		List<String> sndNoList = new ArrayList<String>();

		for(int i=0;i<retSndOutList.size();i++){
			List<MailGroupResultVO> retSndList = retSndOutList.get(i);
			for(int j=0;j<retSndList.size();j++){
				groupResultVO = retSndList.get(j);
				sndNoList.add(groupResultVO.getEmlSndNo());
			}
		}

		return sndNoList;
	}

	
	
	/**
	 * 그룹웨어 메일 전송
	 * @param TmpMailSendVO tmpMailInfo
	 * @return String
	 * @throws MailerAppException
	 */
	@SuppressWarnings("unchecked")
	public String sendGwEmail(TmpMailSendVO tmpMailInfo) throws MailerAppException {
		TemplateMail mail = new TemplateMail();
		
		//Mail Attach  (ex) file1;file2;...
		List<SingleMailAttachedFile> list = new ArrayList<SingleMailAttachedFile>();

		if(tmpMailInfo.getFileKey() != null && 
		   !"".equalsIgnoreCase(tmpMailInfo.getFileKey()) &&
		   !tmpMailInfo.getFileKey().equalsIgnoreCase("null")) {

			String[] fileKeys = tmpMailInfo.getFileKey().split(";");
			for(String fileKey:fileKeys){
				SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
				attachedFile.setFileKey(fileKey);
				list.add(attachedFile); 
				mail.setAttachedFile(list);
			}
		}

		mail.setFrom(tmpMailInfo.getSndrEml(), tmpMailInfo.getSndrNm());
		mail.setSubject(tmpMailInfo.getEmlTitNm());
		mail.setRecipient(tmpMailInfo.getRcvrEml());
		mail.setHtmlContent(tmpMailInfo.getHtmlContent());
		
		
		//Template 설정
		if(tmpMailInfo.getTemplate() != null && !"".equals(tmpMailInfo.getTemplate())){
			mail.setHtmlTemplate(tmpMailInfo.getTemplate());
			
			//Set Arguments
			Map<String, String> arguments = tmpMailInfo.getArguments();
			
			if (arguments != null) {
				Iterator k = arguments.keySet().iterator();
			    while (k.hasNext()) {		      
			    	String argName = (String) k.next();		      
			    	
					mail.setArg(argName, arguments.get(argName));
			    }
			}
		}
		
		mail.setGroupwareMail();
		
		return mail.send();	
	}


	/**
	 * 업무시스템에서 자동으로 Message를 발송
	 * @param String sndNm	 보내는사람 이름
	 * @param String sndrId 보내는사람 아이디
	 * @param String rcvNm	 받는사람 이름
	 * @param String rcvrId 받는사람 아이디
	 * @param String content 메시지 내용
	 * @return	String 메시지 ID
	 * @throws Exception
	 */
	public String sendAlert(String sndNm, String sndrId, String rcvNm, String rcvrId, String content) throws Exception {
		
//		log.info("== Alert Information =====================================================\n" +
//				 "	sndNm   : " + sndNm + "\n" +
//				 "	sndrId  : " + sndrId + "\n" +		
//				 "	rcvNm   : " + rcvNm + "\n" +
//				 "	rcvrId  : " + rcvrId + "\n" +		
//				 "	content : " + content + "\n" +
//				 "==========================================================================\n");
		
		return new MessageUtil().messageInsert(sndNm, sndrId, rcvNm, rcvrId, content);
	}
}