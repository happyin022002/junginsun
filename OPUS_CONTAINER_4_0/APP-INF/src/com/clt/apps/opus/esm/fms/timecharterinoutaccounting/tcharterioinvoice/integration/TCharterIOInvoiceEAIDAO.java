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

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.basic.TCharterIOInvoiceBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSendEmailVO;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.component.javamail.SingleMailAttachedFile;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;

/**
 * OPUS TCharterIOInvoiceDAO <br>
 * - OPUS-TimeCharterInOutAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
	 * @return String
	 * @throws MailerAppException
	 */
	public String sendEmail(CustomSendEmailVO customSendEmailVO, List<String> keys) throws DAOException {
		// 메일 성공 여부 메세지
		String resultMsg = "";
		//String uploadFileKey = "";
		
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
						
						StringBuffer uploadFileKeySb = new StringBuffer();

						//uploadFileKey = customSendEmailVO.getFileKey();
						uploadFileKeySb.append(customSendEmailVO.getFileKey());
						
						if(keys != null) {
							
							//uploadFileKey = uploadFileKey + ";";
							uploadFileKeySb.append(";");
							
							Iterator<String> iter = keys.iterator();
							
							while(iter.hasNext()) {
								//uploadFileKey =  uploadFileKey + iter.next() + ";";
								uploadFileKeySb.append(iter.next()+";");
							}
						}
						
						//String[] fileKeys = customSendEmailVO.getFileKey().split(";");
						String tmpUploadFileKey = uploadFileKeySb.toString();
						String[] fileKeys = tmpUploadFileKey.split(";");
						//String[] fileKeys = uploadFileKey.split(";");
						
						for(String fileKey:fileKeys){
							SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
							attachedFile.setFileKey(fileKey);
							list.add(attachedFile); 
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
	
}