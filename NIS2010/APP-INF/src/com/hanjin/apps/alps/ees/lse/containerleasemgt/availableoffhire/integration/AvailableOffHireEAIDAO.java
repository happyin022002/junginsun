/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AvailableOffHireEAIDAO.java
*@FileTitle : Available Off Hire Q'ty List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.29 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.integration;


import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBCImpl;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.EmailSendInfoVO;


/**
 * ALPS AvailableOffHireDBDAO <br>
 * - ALPS-ContainerLeaseMgt system Business Logic을 처리하기 위한 메일전송 작업수행.<br>
 *
 * @author Jang Jun-Woo
 * @see AvailableOffHireBCImpl 참조
 * @since J2EE 1.6
 */
public class AvailableOffHireEAIDAO extends EAIDAOSupport {

	/**
	 * E-Mail 시스템 <br>
	 * 선택된 반납가능 대상 장비에 대한 내역을 메일로 발송합니다.<br>
	 *
	 * @param EmailSendInfoVO emailSendInfoVO
	 * @return String
	 * @throws MailerAppException
	 */
	public String sendToEmailAvailableOffHireContainerData(EmailSendInfoVO emailSendInfoVO) throws MailerAppException {
		TemplateMail mail = new TemplateMail();
		List<SingleMailAttachedFile> list = new ArrayList<SingleMailAttachedFile>();
		String sendNo = null;

		try {
			mail.setBccRcvrEml(emailSendInfoVO.getBlindCarbonCopy());
			mail.setCcRcvrEml(emailSendInfoVO.getCarbonCopy());
			mail.setFrom(emailSendInfoVO.getFrom());				//보내는 사람 메일주소
			mail.setSubject(emailSendInfoVO.getSubject());			//메일 제목
			mail.setRecipient(emailSendInfoVO.getRecipient());		//받는 사람 메일주소
			mail.setHtmlContent(emailSendInfoVO.getContent());		//메일 본문내용
			//mail.setGroupwareMail();								//Groupware SMTP

			//Mail Attach
			if(emailSendInfoVO.getFileKey() != null &&
			   !"".equalsIgnoreCase(emailSendInfoVO.getFileKey()) &&
			   !emailSendInfoVO.getFileKey().equalsIgnoreCase("null")) {

				String[] fileKeys = emailSendInfoVO.getFileKey().split(";");
				for(String fileKey:fileKeys){
					SingleMailAttachedFile attachedFile = new SingleMailAttachedFile();
					attachedFile.setFileKey(fileKey);
					list.add(attachedFile);
					mail.setAttachedFile(list);
				}
			}

			//Template 설정.
			if(emailSendInfoVO.getTemplate() != null && !"".equals(emailSendInfoVO.getTemplate())){
				mail.setHtmlTemplate(emailSendInfoVO.getTemplate());

				//Set Arguments
				String argument = emailSendInfoVO.getArgument();
				String[] argumentTemplates = argument.split(",");
				for(String argumentTemplate:argumentTemplates){
					String[] argumentSet = argumentTemplate.split(";");
					if(argumentSet.length != 2){
						throw new IllegalArgumentException();
					}
					mail.setArg(argumentSet[0], argumentSet[1]);
				}
			}

			sendNo = mail.send();
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new MailerAppException(new ErrorHandler(ex).getMessage());
		}

		return sendNo;
	}

}