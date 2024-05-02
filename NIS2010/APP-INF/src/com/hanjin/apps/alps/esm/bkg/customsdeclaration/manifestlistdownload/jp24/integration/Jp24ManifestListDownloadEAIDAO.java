/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : Jp24ManifestListDownloadEAIDAO.java
 *@FileTitle : Jp24ManifestListDownloadEAIDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.06.28
 *@LastModifier : 김상수
 *@LastVersion : 1.0
 * 2013.06.28 김상수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.basic.Jp24ManifestListDownloadTransmitCargoInfoDetailBackEndJob;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.SendMailVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;


/**
 * ALPS Jp24ManifestListDownloadEAIDAO <br>
 * - ALPS-Jp24ManifestListDownload system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Sang-Soo
 * @see Jp24ManifestListDownloadTransmitCargoInfoDetailBackEndJob 참조
 * @since J2EE 1.6
 */
public class Jp24ManifestListDownloadEAIDAO extends EAIDAOSupport {

	/**
	 * E-mail 전송<br>
	 *
	 * @param SendMailVO sendMailVO
	 * @return String
	 * @exception MailerAppException
	 */
	public String sendMail(SendMailVO sendMailVO) throws MailerAppException {
		Mail mail = new Mail();
		mail.setFrom(sendMailVO.getFromEmail(), sendMailVO.getFromName());
		mail.setSubject(sendMailVO.getSubject());
		mail.setRecipient(sendMailVO.getRecipient());
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

	/**
	 *  EDI Transmit 공통 함수 (임시 하드코딩)
	 * @param SendFlatFileVO sendFlatFileVO
	 * @return FlatFileAckVO flatFileAckVO
	 * @throws Exception
	 */
	public FlatFileAckVO sendFlatFile(SendFlatFileVO sendFlatFileVO ) throws Exception {

		String integrationId = "BKG" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());

		TransferEAI eai = new IBMSendQClient("203.246.130.159:1414", this.getClass());
		/*
		BKG.IBMMQ.URL=203.246.130.159:1414
		BKG.IBMMQ.TRANSFERTYPE=MQJMS_TP_CLIENT_MQ_TCPIP
		BKG.IBMMQ.CHANNEL=WEBCHL
		BKG.IBMMQ.FACTORY=NIS2010_T
		BKG.IBMMQ.TARGETCLIENT=MQJMS_CLIENT_NONJMS_MQ
	*/
		eai.setTransferType("MQJMS_TP_CLIENT_MQ_TCPIP");
		eai.setChannel("WEBCHL");
		eai.setFactory("NIS2010_T");
		eai.setQueue("ALPSBKG_T_UDEVHJS_NACCS");
		eai.setTargetClient("MQJMS_CLIENT_NONJMS_MQ");
		eai.setMessage(sendFlatFileVO.getFlatFile());

		FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
		flatFileAckVO.setSendId(integrationId);

		try {
			if ("SUCCESS".equals(eai.commit(integrationId))) {
				flatFileAckVO.setAckStsCd("A");
			} else {
				flatFileAckVO.setAckStsCd("E");
			}
		} catch (Exception ea) {
			eai.rollback(ea);
			log.error(ea.getMessage(), ea);
			throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
		}

		eai.close();
		return flatFileAckVO;
	}
}
