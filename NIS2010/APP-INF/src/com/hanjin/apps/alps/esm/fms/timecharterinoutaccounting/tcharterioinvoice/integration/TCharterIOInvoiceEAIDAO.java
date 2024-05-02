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

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.vo.FileUploadListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.basic.TCharterIOInvoiceBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSendEmailVO;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.syscommon.common.util.ComFileUtil;

/**
 * NIS2010 TCharterIOInvoiceDAO <br>
 * - NIS2010-TimeCharterInOutAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jung, Yoon-Tae
 * @see TCharterIOInvoiceBCImpl 참조 
 * @since J2EE 1.5
 */
public class TCharterIOInvoiceEAIDAO extends EAIDAOSupport {
	
	/**
	 * 각 화면에서 메일을 발송한다<br>
	 * @param customSendEmailVO CustomSendEmailVO
	 * @param keys List<String>
	 * @param fileUpladListVOs List<FileUploadListVO>
	 * @return String
	 * @throws MailerAppException
	 */
	
	public String sendEmail(CustomSendEmailVO customSendEmailVO, List<String> keys, List<FileUploadListVO> fileUpladListVOs) throws DAOException {
		// 메일 성공 여부 메세지
		String resultMsg = "";
		//String uploadFileKey = "";
		StringBuffer uploadFileKey = new StringBuffer();
		String atchfileKey = "";
		
		try {
			
			if(customSendEmailVO.getRecipient() != null && 
					   !"".equalsIgnoreCase(customSendEmailVO.getRecipient()) &&
					   !customSendEmailVO.getRecipient().equalsIgnoreCase("null")) {
				
				// 2017.03.27 mail 주소 전체 발송되도록 변경
				//String[] recipients = customSendEmailVO.getRecipient().split(";");
				
				//for(String recipient:recipients){
			
					TemplateMail mail = new TemplateMail();
					
					//Mail Attach
					List<SingleMailAttachedFile> list = new ArrayList<SingleMailAttachedFile>();
			
					if(customSendEmailVO.getFileKey() != null && 
					   !"".equalsIgnoreCase(customSendEmailVO.getFileKey()) &&
					   !customSendEmailVO.getFileKey().equalsIgnoreCase("null")) {
						
						//uploadFileKey = customSendEmailVO.getFileKey();
						uploadFileKey.append(customSendEmailVO.getFileKey()); 
						
						log.debug("## keys = "+keys);						
						
						if(keys != null) {							
							//uploadFileKey = uploadFileKey + ";"; 
							uploadFileKey.append(";"); 							
							Iterator<String> iter = keys.iterator();							
							while(iter.hasNext()) {
								//uploadFileKey =  uploadFileKey + iter.next() + ";";
								uploadFileKey.append(iter.next() + ";"); 
							}
							atchfileKey = uploadFileKey.toString();							
						}else{
							atchfileKey = customSendEmailVO.getFileKey();
						}
						
						log.debug("## uploadFileKey = "+uploadFileKey);
						log.debug("### customSendEmailVO.getFileKey() = "+customSendEmailVO.getFileKey());
						log.debug("atchfileKey = "+atchfileKey);
						
//						String[] fileKeys = customSendEmailVO.getFileKey().split(";");
						String[] fileKeys = atchfileKey.split(";");						
												
						for(String fileKey:fileKeys){
							SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
							
							log.debug("### fileKey = "+fileKey);
							
							attachedFile.setFileKey(fileKey);
							list.add(attachedFile); 
							mail.setAttachedFile(list);
						}
						
						for(int i=0; i<fileUpladListVOs.size(); i++){
							SingleMailAttachedFile attachedFile2 = new SingleMailAttachedFile();							
							log.debug("### fileKey2 = "+fileUpladListVOs.get(i).getFileSavId());
							attachedFile2.setFileKey(ComFileUtil.copyUploadFile(fileUpladListVOs.get(i).getFileSavId()));
							list.add(attachedFile2); 
							mail.setAttachedFile(list);							
						}
					}
			
					mail.setBccRcvrEml(customSendEmailVO.getBlindCarbonCopy());
					mail.setCcRcvrEml(customSendEmailVO.getCarbonCopy());
					mail.setFrom(customSendEmailVO.getFrom());
					mail.setSubject(customSendEmailVO.getSubject());
					mail.setRecipient(customSendEmailVO.getRecipient());
					//mail.setRecipient(customSendEmailVO.getRecipient());
					String content = customSendEmailVO.getContent();
					
					content = content + customSendEmailVO.getSignature();
					content = JSPUtil.n2Br(content);
					//content = JSPUtil.n2Br(JSPUtil.replaceForHTML(content));
					mail.setHtmlContent(content);

					//mail.setHtmlContent(customSendEmailVO.getContent());

					//Template 설정.
					if(customSendEmailVO.getTemplate() != null && !"".equals(customSendEmailVO.getTemplate())){
						mail.setHtmlTemplate(customSendEmailVO.getTemplate());
						
						//Set Arguments
						String argument = customSendEmailVO.getArgument();
						String[] argumentTemplates = argument.split(",");
						for(String argumentTemplate:argumentTemplates){
							String[] argumentSet = argumentTemplate.split(";");
							if(argumentSet.length != 2){
								throw new IllegalArgumentException();
							}
							mail.setArg(argumentSet[0], argumentSet[1]);
						}
					}
					
					resultMsg = mail.send();
				//}
			}
		
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return resultMsg;
	}
	
	
/*	
	public String sendEmail(CustomSendEmailVO customSendEmailVO, List<String> keys) throws DAOException {
		// 메일 성공 여부 메세지
		String resultMsg = "";
		//String uploadFileKey = "";
		StringBuffer uploadFileKey = new StringBuffer();
		
		try {
			
			if(customSendEmailVO.getRecipient() != null && 
					   !"".equalsIgnoreCase(customSendEmailVO.getRecipient()) &&
					   !customSendEmailVO.getRecipient().equalsIgnoreCase("null")) {
				
				String[] recipients = customSendEmailVO.getRecipient().split(";");
				
				for(String recipient:recipients){
			
					TemplateMail mail = new TemplateMail();
					
					//Mail Attach
					List<SingleMailAttachedFile> list = new ArrayList<SingleMailAttachedFile>();
			
					if(customSendEmailVO.getFileKey() != null && 
					   !"".equalsIgnoreCase(customSendEmailVO.getFileKey()) &&
					   !customSendEmailVO.getFileKey().equalsIgnoreCase("null")) {
						
						//uploadFileKey = customSendEmailVO.getFileKey();
						uploadFileKey.append(customSendEmailVO.getFileKey()); 

						if(keys != null) {
							
							//uploadFileKey = uploadFileKey + ";"; 
							uploadFileKey.append(";"); 

							
							Iterator<String> iter = keys.iterator();
							
							while(iter.hasNext()) {
								//uploadFileKey =  uploadFileKey + iter.next() + ";";
								uploadFileKey.append(iter.next() + ";"); 
							}
						}
						
						log.debug("### customSendEmailVO.getFileKey() = "+customSendEmailVO.getFileKey());


--### customSendEmailVO.getFileKey() = duhxsg_20160525153656925.pdf 
--### fileKey = duhxsg_20160525153656925.pdf 
						
												
						String[] fileKeys = customSendEmailVO.getFileKey().split(";");
												
						for(String fileKey:fileKeys){
							SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
							
							log.debug("### fileKey = "+fileKey);
							
							attachedFile.setFileKey(fileKey);
							list.add(attachedFile); 
							mail.setAttachedFile(list);
						}
						
						List<FileUploadListVO> fileListVO = new ArrayList<FileUploadListVO>(); 						
						FileUploadListVO fileUploadListVO1 = new FileUploadListVO();
						FileUploadListVO fileUploadListVO2 = new FileUploadListVO();
						FileUploadListVO fileUploadListVO3 = new FileUploadListVO();
						FileUploadListVO fileUploadListVO4 = new FileUploadListVO();						
						FileUploadListVO fileUploadListVO5 = new FileUploadListVO();						
						
						fileUploadListVO1.setFileSavId("ifbxqs_20160517115346433.txt");
						fileListVO.add(fileUploadListVO1);
						fileUploadListVO2.setFileSavId("gdebfg_2016042711152749.txt");
						fileListVO.add(fileUploadListVO2);
						fileUploadListVO3.setFileSavId("untkgr_20160427143630665.txt");
						fileListVO.add(fileUploadListVO3);
						fileUploadListVO4.setFileSavId("hdvvjt_20160429190313633.txt");
						fileListVO.add(fileUploadListVO4);
						fileUploadListVO5.setFileSavId("asqfnq_20160517190548451.txt");
						fileListVO.add(fileUploadListVO5);
						
						String fileKey2 = "";
						SingleMailAttachedFile attachedFile2 = null;
						
						for(int i=0; i<fileListVO.size(); i++){
							attachedFile2 = new SingleMailAttachedFile();
							
							fileKey2 = fileListVO.get(i).getFileSavId();
							
							log.debug("### fileKey2 = "+fileKey2);
							
							attachedFile2.setFileKey(fileKey2);
							list.add(attachedFile2); 
							mail.setAttachedFile(list);							
						}						
					}
			
					mail.setBccRcvrEml(customSendEmailVO.getBlindCarbonCopy());
					mail.setCcRcvrEml(customSendEmailVO.getCarbonCopy());
					mail.setFrom(customSendEmailVO.getFrom());
					mail.setSubject(customSendEmailVO.getSubject());
					mail.setRecipient(recipient);
					//mail.setRecipient(customSendEmailVO.getRecipient());
					String content = customSendEmailVO.getContent();
					
					content = content + customSendEmailVO.getSignature();
					content = JSPUtil.n2Br(content);
					//content = JSPUtil.n2Br(JSPUtil.replaceForHTML(content));
					mail.setHtmlContent(content);

					//mail.setHtmlContent(customSendEmailVO.getContent());

					//Template 설정.
					if(customSendEmailVO.getTemplate() != null && !"".equals(customSendEmailVO.getTemplate())){
						mail.setHtmlTemplate(customSendEmailVO.getTemplate());
						
						//Set Arguments
						String argument = customSendEmailVO.getArgument();
						String[] argumentTemplates = argument.split(",");
						for(String argumentTemplate:argumentTemplates){
							String[] argumentSet = argumentTemplate.split(";");
							if(argumentSet.length != 2){
								throw new IllegalArgumentException();
							}
							mail.setArg(argumentSet[0], argumentSet[1]);
						}
					}
					
					resultMsg = mail.send();
				}
			}
		
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return resultMsg;
	}
*/
	
	
	
}