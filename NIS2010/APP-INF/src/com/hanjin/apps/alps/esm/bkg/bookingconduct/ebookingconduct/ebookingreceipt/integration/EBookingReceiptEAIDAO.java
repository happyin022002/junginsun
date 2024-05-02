/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EBookingReceiptEAIDAO.java
 *@FileTitle : EDI test
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.05
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.06.05 전용진
 * 1.0 Creation 
 * 2011.01.18 전성진 [] 에러메일 수신인 추가
 * 2011.04.18 손은주 [CHM-201110188-01] [ALPS] BKG/SI Notification (EDI) 메뉴 오픈 요청
 * 2011.04.21 손은주 [CHM-201110188-01] [ALPS] BKG/SI Notification (EDI) 메뉴 오픈 요청 - sendXterRqstNotice() 삭제
 * 2011.07.05 이일민 Simple EDI 오류메일 전송 라이브 적용 - 이메일 주소 변경
 * 2011.07.14 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
 * 2012.07.20 김진주 e-BKG 수신 오류 메일발송대상 추가(EBD - Dcube admin계정)
 * 2012.11.09 김진주 e-BKG 수신 오류 메일발송대상 변경
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ErrMsgToEsvcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterShprInfoVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.edi.EAIHeaderType;
import com.hanjin.irep.edi.EDI0010001Document;
import com.hanjin.irep.edi.EDI0020001Document;
import com.hanjin.irep.edi.EDI0010001Document.EDI0010001;
import com.hanjin.irep.edi.EDI0010001Document.EDI0010001.DataArea.IBOOKINGCollection;
import com.hanjin.irep.edi.EDI0010001Document.EDI0010001.DataArea.IBOOKINGCollection.IBOOKINGRequest;
import com.hanjin.irep.edi.EDI0020001Document.EDI0020001;
import com.hanjin.irep.edi.EDI0020001Document.EDI0020001.DataArea.IBKGCUSTCollection;
import com.hanjin.irep.edi.EDI0020001Document.EDI0020001.DataArea.IBKGCUSTCollection.IBKGCUSTRequest;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.WeblogicSendQClient;


/**
 * ALPS EBookingReceiptEAIDAO <br>
 * - ALPS-EBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jun Yong Jin
 * @see EBookingReceiptBCImpl 참조
 * @since J2EE 1.6
 */
public class EBookingReceiptEAIDAO extends EAIDAOSupport {
	/**
	 * ebkg 담당자에게 발생한 err에 대해 g/w mail로 전송한다.<br>
	 *
	 * @param errStr String
	 * @param rcvMsg String
	 * @throws DAOException
	 */
	public void sendErrLogMail(String errStr, String rcvMsg) throws DAOException { 
		try{
			StringBuffer sbContents = new StringBuffer(5000);

			sbContents.append("eBkg Receipt Error");
			sbContents.append("\nTime : " + System.currentTimeMillis());
			sbContents.append("\nException : " + errStr);
			sbContents.append("\nReceive Message : " + rcvMsg);
			// 메일발송
			Mail mail = new Mail();
			mail.setFrom("noreply@smlines.com"); //보내는 사람 메일주소
			if(rcvMsg != null && rcvMsg.contains("IB_EDI_ID:EXCEL")){
				mail.setSubject("Simple BKG/SI Receipt Error");  //메일제목
			} else {
				mail.setSubject("eBKG Receipt Error");  //메일제목
			}
			mail.setRecipient("isjung@hipluscard.co.kr");  //받는 사람 메일주소
			mail.setTextContent(sbContents.toString()); //Text 로 된 본문 내용

			// Text 를 이용한 파일 첨부
/*			List<SingleMailAttachedFile> list = new ArrayList<SingleMailAttachedFile>();

			SingleMailAttachedFile atchFile = new SingleMailAttachedFile();
			atchFile.setFileName("rcv_msg_" + System.currentTimeMillis() + ".txt");
			atchFile.setFileContent(rcvMsg);
			list.add(atchFile);
			mail.setAttachedFile(list);*/

			mail.send();			

		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}				
	}

	/**
	 * EDI전송 오류 발생 시 오류메시지를 EAI로 전송한다.<br>
	 *
	 * @param errMsgToEsvcVO ErrMsgToEsvcVO
	 * @param xterRqstNoVO XterRqstNoVO
	 * @exception EAIException
	 */
	public void sendErrMsgToEsvc(ErrMsgToEsvcVO errMsgToEsvcVO, XterRqstNoVO xterRqstNoVO) throws EAIException  {
		TransferEAI eai  = null;
		try {
			log.debug("=======================================");
			log.debug("    \n Parameter Marshalling Start!    ");
			log.debug("=======================================");
			EDI0010001Document docReq = EDI0010001Document.Factory.newInstance();
			EDI0010001 edi0010001Req = docReq.addNewEDI0010001();

			String timeStamp = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
			//Set Header
			EAIHeaderType headerType = (EAIHeaderType)edi0010001Req.addNewEAIHeader();
			headerType.setInstanceId("EDI001_0001_" + timeStamp + "_" + xterRqstNoVO.getRqstNo() + "_" + xterRqstNoVO.getRqstSeq());

			EDI0010001.DataArea dataArea = edi0010001Req.addNewDataArea();
			IBOOKINGCollection iBOOKINGCollReq = dataArea.addNewIBOOKINGCollection();

			IBOOKINGRequest iBOOKINGRequest = iBOOKINGCollReq.addNewIBOOKINGRequest();

			iBOOKINGRequest.setEAISTS		(errMsgToEsvcVO.getEaiSts());
			iBOOKINGRequest.setEAIDT		(errMsgToEsvcVO.getEaiDt());
			iBOOKINGRequest.setCOMPANY		(errMsgToEsvcVO.getCompany());
			iBOOKINGRequest.setIBNO			(errMsgToEsvcVO.getIbNo());
			iBOOKINGRequest.setIBSEQ		(errMsgToEsvcVO.getIbSeq());	            
			iBOOKINGRequest.setIBBKGNO		(errMsgToEsvcVO.getIbBkgNo());
			iBOOKINGRequest.setIBCFMIND		(errMsgToEsvcVO.getIbCfmInd());
			iBOOKINGRequest.setIBBKGOFC		(errMsgToEsvcVO.getIbBkgOfc());
			iBOOKINGRequest.setIBCFMUSRID	(errMsgToEsvcVO.getIbCfmUsrId());
			iBOOKINGRequest.setIBCDATE		(errMsgToEsvcVO.getIbCDate());
			iBOOKINGRequest.setIBRDATE		(errMsgToEsvcVO.getIbRDate());
			iBOOKINGRequest.setEAIIFTP		(errMsgToEsvcVO.getEaiIfTp());
			iBOOKINGRequest.setIBNUERROR	(errMsgToEsvcVO.getIbNuError());	            
			iBOOKINGRequest.setIBMSGFLAG	(errMsgToEsvcVO.getIbMsgFlag());
			iBOOKINGRequest.setIBEDIID		(errMsgToEsvcVO.getIbEdiId());
			iBOOKINGRequest.setIBFFREFNO	(errMsgToEsvcVO.getIbFfRefNo());

    		eai = new WeblogicSendQClient(SubSystemConfigFactory.get("COM.ALPSJ.JMS.SEND.URL"), this.getClass());

            log.debug("document:"+ docReq.toString());
       		eai.setFactory(SubSystemConfigFactory.get("COM.ALPSJ.JMS.FACTORY")); 
       		eai.setQueue(SubSystemConfigFactory.get("COM.ALPSJ.JMS.QUEUE"));  

       		log.debug("========================ERR Msg Interface Start===================================");
       		log.debug(errMsgToEsvcVO.getIbNuError());
	        eai.setMessage(docReq.toString()); 
	        eai.setDestination("EDI001_0001");
	        eai.commit(headerType.getInstanceId());
	        log.debug("========================ERR Msg Interface End===================================");

		} catch (EAIException ex) {
			eai.rollback(ex);
			log.error(ex.getMessage(),ex);
			throw new EAIException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EAIException(new ErrorHandler(ex).getMessage());
		} finally { // 2011.07.14
			if ( eai != null ) {
				eai.close();
			}		
		}
	}


	/**
	 * e-svc Reject 시 화주에게 Reject 메일 발송<br>
	 *
	 * @param senderEml String
	 * @param cntcEml String
	 * @param rjctRsnRmk String
	 * @throws DAOException
	 */
	public void sendXterRqstRejectEmail(String senderEml, String cntcEml, String rjctRsnRmk) throws DAOException{
		try{
			if(cntcEml != null){
				StringBuffer sbContents = new StringBuffer(500);

				sbContents.append("\n<html>");
				sbContents.append("\n<head>");
				sbContents.append("\n<title>            </title>");
				sbContents.append("\n<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
				sbContents.append("\n</head>");
				sbContents.append("\n<body>");
				sbContents.append("\n<table width='100%' border='0' cellpadding='0' cellspacing='0' style='padding-top: 2; padding-left: 5;'>");
				sbContents.append("\n	<tr>");
				sbContents.append("\n		<td valign='top'>");
				sbContents.append("\n		<table border='0' cellpadding='0' cellspacing='0' width='600'>");
				sbContents.append("\n			<tr>");
				sbContents.append("\n				<td height='25'>");
				sbContents.append("\n				<table border='0' cellpadding='0' cellspacing='0' width='100%'>");
				sbContents.append("\n					<tr>");
				sbContents.append("\n						<td width='100%' colspan='2'>");
				sbContents.append("\n 					  <textarea name='reject_reason' style='width:100%;height:500'>"+rjctRsnRmk+"</textarea>");
				sbContents.append("\n						</td>");
				sbContents.append("\n					</tr>");
				sbContents.append("\n					<tr>");
				sbContents.append("\n						<td width='40%'>");
				sbContents.append("\n						</td>");
				sbContents.append("\n						<td></td>");
				sbContents.append("\n					</tr>");
				sbContents.append("\n				</table>");
				sbContents.append("\n				</td>");
				sbContents.append("\n			</tr>");
				sbContents.append("\n		</table>");	
				sbContents.append("\n		</td>");
				sbContents.append("\n	</tr>");
				sbContents.append("\n</table>");
				sbContents.append("\n</body>");
				sbContents.append("\n</html>");


				// 메일발송
				Mail mail = new Mail();
				mail.setFrom(senderEml); //보내는 사람 메일주소
				mail.setSubject("Your e-Booking & SI request is declined due to below reason");  //메일제목
				mail.setRecipient(cntcEml);  //받는 사람 메일주소
				mail.setTextContent(rjctRsnRmk); //Text로된 본문 내용
				//			   mail.setHtmlContent(sbContents.toString());
				mail.send();				
			}			
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}

	/**
	 * upload 완료시 E-svc로 화주 정보를 전송한다.<br>
	 *
	 * @param xterShprInfoVO XterShprInfoVO 
	 * @param xterRqstNoVO XterRqstNoVO 
	 * @exception EAIException
	 */
	public void sendXterShprToEsvc(XterShprInfoVO xterShprInfoVO, XterRqstNoVO xterRqstNoVO) throws EAIException {
		TransferEAI eai = null;
		try {
			log.debug("=======================================");
			log.debug("    \n Parameter Marshalling Start!    ");
			log.debug("=======================================");
			EDI0020001Document docReq = EDI0020001Document.Factory.newInstance();
			EDI0020001 edi0020001Req = docReq.addNewEDI0020001();

			String timeStamp = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
			//Set Header
			EAIHeaderType headerType = (EAIHeaderType)edi0020001Req.addNewEAIHeader();
			headerType.setInstanceId("EDI002_0001_" + timeStamp + "_" + xterRqstNoVO.getRqstNo() + "_" + xterRqstNoVO.getRqstSeq());

			EDI0020001.DataArea dataArea = edi0020001Req.addNewDataArea();
			IBKGCUSTCollection iBKGCUSTCollReq = dataArea.addNewIBKGCUSTCollection();

			IBKGCUSTRequest iBKGCUSTRequest = iBKGCUSTCollReq.addNewIBKGCUSTRequest();

			iBKGCUSTRequest.setCOMPANY		("SMLM");
			iBKGCUSTRequest.setIBNO			(xterRqstNoVO.getRqstNo());
			iBKGCUSTRequest.setIBSEQ		(xterRqstNoVO.getRqstSeq());
			iBKGCUSTRequest.setIBEDIID		(xterRqstNoVO.getSenderId());
			
			if ( xterShprInfoVO != null ) {
				iBKGCUSTRequest.setEAISTS		(xterShprInfoVO.getOptCd());
				iBKGCUSTRequest.setEAIDT		(xterShprInfoVO.getTimestamp());
				iBKGCUSTRequest.setIBCSTP		(xterShprInfoVO.getIbcsTp());
				iBKGCUSTRequest.setCNTCD        (xterShprInfoVO.getCntCd());
				iBKGCUSTRequest.setCUSTCD       (xterShprInfoVO.getCustCd());
			}

    		eai = new WeblogicSendQClient(SubSystemConfigFactory.get("COM.ALPSJ.JMS.SEND.URL"), this.getClass());
            
       		eai.setFactory(SubSystemConfigFactory.get("COM.ALPSJ.JMS.FACTORY")); 
       		eai.setQueue(SubSystemConfigFactory.get("COM.ALPSJ.JMS.QUEUE"));  

       		log.debug("========================Shipper info Interface Start===================================");         	     
   	     
	        eai.setMessage(docReq.toString()); 
	        eai.setDestination("EDI002_0001");
	        eai.commit(headerType.getInstanceId());
	        log.debug("========================Shipper info Interface Start===================================");

		} catch (EAIException ex) {
			eai.rollback(ex);
			log.error(ex.getMessage(),ex);
			throw new EAIException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EAIException(new ErrorHandler(ex).getMessage());
		} finally { // 2011.07.14
			if ( eai != null ) {
				eai.close();
			}		
		}
	}

	/**
	 * @param Map<String, Object> infoEml
	 * @throws DAOException
	 */
	public void sendSiTransErrMail(Map<String, Object> infoEml) throws DAOException { 
		try{
			StringBuffer sbContents = new StringBuffer(5000);
			sbContents.append("\n\nThe SI has not been processed due to incorrect information. \n\nPlease correct and resend it.\n\n \n");
//			sbContents.append("\nException : " + errStr);
//			sbContents.append("\nReceive Message : " + rcvMsg);
			// 메일발송
			Mail mail = new Mail();
			mail.setFrom((String) infoEml.get("FROM_EMAIL")); //보내는 사람 메일주소
			mail.setSubject((String) infoEml.get("EML_SUBJ_CTNT"));  //메일제목
			mail.setRecipient((String) infoEml.get("TO_EMAIL"));  //받는 사람 메일주소
			mail.setTextContent(sbContents.toString()); //Text 로 된 본문 내용

			// Text 를 이용한 파일 첨부
/*			List<SingleMailAttachedFile> list = new ArrayList<SingleMailAttachedFile>();

			SingleMailAttachedFile atchFile = new SingleMailAttachedFile();
			atchFile.setFileName("rcv_msg_" + System.currentTimeMillis() + ".txt");
			atchFile.setFileContent(rcvMsg);
			list.add(atchFile);
			mail.setAttachedFile(list);*/

			mail.send();			

		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
		
	}
	/**
	 * e-svc pending 시 화주에게 Reject 메일 발송<br>
	 *
	 * @param senderEml String
	 * @param cntcEml String
	 * @param pendingRsnRmk String
	 * @throws DAOException
	 */
	public void sendXterRqstPendingNotice(String senderEml, String cntcEml, String pendingRsnRmk) throws DAOException { 
		try{
			if(cntcEml != null){
				StringBuffer sbContents = new StringBuffer(500);

				sbContents.append("\n<html>");
				sbContents.append("\n<head>");
				sbContents.append("\n<title>            </title>");
				sbContents.append("\n<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
				sbContents.append("\n</head>");
				sbContents.append("\n<body>");
				sbContents.append("\n<table width='100%' border='0' cellpadding='0' cellspacing='0' style='padding-top: 2; padding-left: 5;'>");
				sbContents.append("\n	<tr>");
				sbContents.append("\n		<td valign='top'>");
				sbContents.append("\n		<table border='0' cellpadding='0' cellspacing='0' width='600'>");
				sbContents.append("\n			<tr>");
				sbContents.append("\n				<td height='25'>");
				sbContents.append("\n				<table border='0' cellpadding='0' cellspacing='0' width='100%'>");
				sbContents.append("\n					<tr>");
				sbContents.append("\n						<td width='100%' colspan='2'>");
				sbContents.append("\n 					  <textarea name='reject_reason' style='width:100%;height:500'>"+pendingRsnRmk+"</textarea>");
				sbContents.append("\n						</td>");
				sbContents.append("\n					</tr>");
				sbContents.append("\n					<tr>");
				sbContents.append("\n						<td width='40%'>");
				sbContents.append("\n						</td>");
				sbContents.append("\n						<td></td>");
				sbContents.append("\n					</tr>");
				sbContents.append("\n				</table>");
				sbContents.append("\n				</td>");
				sbContents.append("\n			</tr>");
				sbContents.append("\n		</table>");	
				sbContents.append("\n		</td>");
				sbContents.append("\n	</tr>");
				sbContents.append("\n</table>");
				sbContents.append("\n</body>");
				sbContents.append("\n</html>");


				// 메일발송
				Mail mail = new Mail();
				mail.setFrom(senderEml); //보내는 사람 메일주소
				mail.setSubject("Your e-Booking & SI request is pending due to below reason");  //메일제목
				mail.setRecipient(cntcEml);  //받는 사람 메일주소
				mail.setTextContent(pendingRsnRmk); //Text로된 본문 내용
				//			   mail.setHtmlContent(sbContents.toString());
				mail.send();				
			}			
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
		
	}

	/**
	 * 
	 * @param rqstNo
	 * @param msg
	 * @throws DAOException
	 */
	public void sendAutoBkgMail(String rqstNo, String msg) throws DAOException { 
		try{
			StringBuffer sbContents = new StringBuffer(5000);

			sbContents.append("Manual Auto Booking ");
			sbContents.append("\nRqst No : " + rqstNo);
			sbContents.append("\nMessage : " + msg);
			// 메일발송
			Mail mail = new Mail();
			mail.setFrom("noreply@smlines.com"); //보내는 사람 메일주소
			mail.setSubject("Manual Auto Booking");  //메일제목
			mail.setRecipient("isjung@hipluscard.co.kr");  //받는 사람 메일주소
			mail.setTextContent(sbContents.toString()); //Text 로 된 본문 내용
			mail.send();			
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}				
	}
}