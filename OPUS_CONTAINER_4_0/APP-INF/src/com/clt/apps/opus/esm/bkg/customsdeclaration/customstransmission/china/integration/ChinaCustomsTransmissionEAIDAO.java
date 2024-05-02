/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ChinaCustomsTransmissionEAIDAO.java
 *@FileTitle : ChinaCustomsTransmissionEAIDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.SendMailVO;
import com.clt.framework.component.javamail.Mail;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;


/**
 * OPUS ChinaCustomsTransmissionEAIDAO <br>
 * - OPUS-ChinaCustomsTransmission system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author
 * @see
 * @since J2EE 1.6
 */
public class ChinaCustomsTransmissionEAIDAO extends EAIDAOSupport {

	/**
	 * E-mail 전송<br>
	 *
	 * @param SendMailVO sendMailVO
	 * @return String
	 * @exception MailerAppException
	 */
	public String sendMail(SendMailVO sendMailVO) throws MailerAppException {
		Mail mail = new Mail();
		mail.setFrom("noreply@nykline.com", ConstantMgr.getCompanyName());
		mail.setRecipient(sendMailVO.getRecipient());
		mail.setCcRcvrEml(sendMailVO.getCcRcvrEml());
		mail.setSubject(sendMailVO.getSubject());
		mail.setTextContent(sendMailVO.getTextContent());
/*
		// 파일 첨부를 위한 파일 List 선언
		List<SingleMailAttachedFile> singleMailAttachedFileList = new ArrayList<SingleMailAttachedFile>();
		// 첫번째 FileKey를 이용한 AttachedFile 객체 생성
		singleMailAttachedFileList.add(new SingleMailAttachedFile().setFileKey(sendMailVO.getFileKey));
		// 두번째 FileKey를 이용한 AttachedFile 객체 생성
		singleMailAttachedFileList.add(new SingleMailAttachedFile().setFileKey(sendMailVO.getFileKey1));
		// 메일에 파일을 첨부
		mail.setAttachedFile(singleMailAttachedFileList);
*/

		return mail.send();
	}

}
