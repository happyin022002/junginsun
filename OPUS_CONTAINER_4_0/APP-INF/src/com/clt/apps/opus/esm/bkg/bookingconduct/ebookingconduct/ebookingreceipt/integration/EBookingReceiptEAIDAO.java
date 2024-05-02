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
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.ArrayList;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0902Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.framework.component.javamail.Mail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.framework.table.ComRptDsgnXptInfoVO;


/**
 * OPUS EBookingReceiptEAIDAO <br>
 * - OPUS-EBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jun Yong Jin
 * @see EBookingReceiptBCImpl 참조
 * @since J2EE 1.6
 */
public class EBookingReceiptEAIDAO extends EAIDAOSupport {
	/**
	 * ebkg 담당자에게 발생한 err에 대해 g/w mail로 전송한다.<br>
	 * @param errStr
	 * @param rcvMsg
	 * @param emailInfoList
	 * @param rcvMsgSeq
	 * @throws DAOException
	 */
	public void sendErrLogMail(String errStr, String rcvMsg, List<String> emailInfoList) throws DAOException { 
		try{
			StringBuffer sbContents = new StringBuffer(5000);

			sbContents.append("eBkg Receipt Error");
			sbContents.append("\nTime : " + System.currentTimeMillis());
			sbContents.append("\nException : " + errStr);
			sbContents.append("\nReceive Message : " + rcvMsg);
			
			log.debug("$$$$$$$$$$$\n EBookingReceiptEAIDAO.sendErrLogMail() contents ==>"+sbContents.toString());
			
			StringBuffer toEmail = new StringBuffer();
			if(emailInfoList != null){
				for(int i=0; i < emailInfoList.size(); i++){
					toEmail.append((String)emailInfoList.get(i));
					toEmail.append(";");
//					toEmail += (String)emailInfoList.get(i) + ";";
				}	
				log.debug("$$$$$$$$$$$\n EBookingReceiptEAIDAO.sendErrLogMail() toEmail ==>"+toEmail.toString());
				
				
				// 메일발송
				Mail mail = new Mail();
				mail.setFrom("noreply@nyk.com"); //보내는 사람 메일주소
				mail.setSubject("eBKG Receipt Error");  //메일제목
				mail.setRecipient(toEmail.toString());  //받는 사람 메일주소
				mail.setTextContent(sbContents.toString()); //Text 로 된 본문 내용

				mail.send();			
				log.debug("============= mail Info");
				log.debug("============= From      :noreply@nyk.com");
				log.debug("============= Subject   :eBKG Receipt Error");
				log.debug("============= Recipient :"+toEmail.toString());
				log.debug("$$$$$$$$$$$\n EBookingReceiptEAIDAO.sendErrLogMail() mail.send() OK!!");
			}
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}				
	}

	/**
	 *  eBKG 또는 eSI 처리 담당 Office에 eBKG, eSI 접수 통지 mail 발송 <br>
	 * @param emailAddress
	 * @param xterRqstNoVO
	 * @param subject
	 */
	public void sendXterRqstNotice(String emailAddress, XterRqstNoVO xterRqstNoVO, String subject) {
		try{
			if(emailAddress != null && !"".equals(emailAddress)){
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
				sbContents.append("\n							New e-Booking or e-SI request has arrived.<br/>Please check  the data to process this request<br/>");
				sbContents.append("\n							Request No : " + xterRqstNoVO.getRqstNo() );
				sbContents.append("\n							Sender Id : " + xterRqstNoVO.getSenderId()); 
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


				StringBuffer strArg = new StringBuffer("/rv");
				strArg.append(" frm1_sender_id[" + xterRqstNoVO.getSenderId() + "]");
				strArg.append(" frm1_rqst_no[" + xterRqstNoVO.getRqstNo() + "]"); 						
				strArg.append(" frm1_rqst_seq[" + xterRqstNoVO.getRqstSeq() + "]");
				strArg.append(" frm1_bkg_no[" + xterRqstNoVO.getBkgNo() + "]");
				strArg.append(" /riprnmargin /rwait");
				
				// Email 전송
				ComRptDsgnXptInfoVO rdVO = new ComRptDsgnXptInfoVO();
				if ("B".equals(xterRqstNoVO.getDocTpCd())) {
					rdVO.setRdTmpltNm("ESM_BKG_0230B.mrd");
				}else{
					rdVO.setRdTmpltNm("ESM_BKG_0230S.mrd");
				}
				rdVO.setRdParaCtnt(strArg.toString().trim());
				rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
//				rdVO.setXptFileNm("Request:" + xterRqstNoVO.getRqstNo() +".pdf");
				rdVO.setXptFileNm(xterRqstNoVO.getRqstNo() +".pdf");
				rdVO.setCreUsrId(("".equals(xterRqstNoVO.getUserId()) || xterRqstNoVO.getUserId() == null?"SYSTEM":xterRqstNoVO.getUserId()));
				rdVO.setUpdUsrId(("".equals(xterRqstNoVO.getUserId()) || xterRqstNoVO.getUserId() == null?"SYSTEM":xterRqstNoVO.getUserId()));
							
				List<ComRptDsgnXptInfoVO> rdVOs = new ArrayList<ComRptDsgnXptInfoVO>();
				rdVOs.add(rdVO);

				// 메일발송
				Mail mail = new Mail();
				mail.setComRptDsgnXptInfoVOs(rdVOs);	
				mail.setFrom("noreply@nykline.com"); 	//보내는 사람 메일주소
				mail.setRecipient(emailAddress);  		//받는 사람 메일주소
				mail.setSubject(subject);  //메일제목
				mail.setHtmlContent(sbContents.toString());
				//test이므로 임시 주석처리
				mail.send();	
			}			
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
		}		

	}

	/**
	 * e-svc Reject 시 화주에게 Reject 메일 발송<br>
	 *
	 * @param EsmBkg0902Event event
	 * @throws DAOException
	 */
	public void sendXterRqstRejectEmail(EsmBkg0902Event event) throws DAOException{
		String senderEml = event.getUsrEml();
		String cntcEml = event.getCntcEml();
		String rjctRsnRmk =  event.getRjctRsnRmk();
		String blPrfShprFlg = event.getBlPrfShprFlg();
		String reqNo = event.getRqstNo();
		String reqSeq = event.getRqstSeq();
		String docTpCd = event.getDocTpCd();
		String xterBkgRqstStsCd = event.getXterBkgRqstStsCd();
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
				if(null != blPrfShprFlg && blPrfShprFlg.equals("Y")){
					mail.setSubject("NYK Group - Internet B/L Change Request Not  Accepted ");  //메일제목
				}else{
					if(docTpCd.equals("S")){
						if(reqSeq.equals("1"))
							mail.setSubject("New Internet Shipping Instruction Rejected - < " + reqNo + " >");  //메일제목
						else
							mail.setSubject("Internet Shipping Instruction Change Request Rejected - < " + reqNo + " >");  //메일제목
					}else if(docTpCd.equals("U")){
						mail.setSubject("Internet Bill of Lading Change Request Rejected - < " + reqNo + " >");  //메일제목
					}else{
						if(xterBkgRqstStsCd.equals("X")){
							mail.setSubject("Internet Booking Cencellation Request Rejected - < " + reqNo + " >");  //메일제목
						}else{
							if(reqSeq.equals("1"))
								mail.setSubject("Internet Booking Request Rejected - < " + reqNo + " >");  //메일제목
							else
								mail.setSubject("Internet Booking Change Request Rejected - < " + reqNo + " >");  //메일제목
						}
					}
				}
				
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
	 * e-svc Reject 시 화주에게 Reject 메일 발송<br>
	 *
	 * @param senderEml String
	 * @param cntcEml String
	 * @param rjctRsnRmk String
	 * @throws DAOException
	 */
//	public void sendXterRqstRejectEmail(String senderEml, String cntcEml, String rjctRsnRmk, String blPrfShprFlg) throws DAOException{
//		try{
//			if(cntcEml != null){
//				StringBuffer sbContents = new StringBuffer(500);
//
//				sbContents.append("\n<html>");
//				sbContents.append("\n<head>");
//				sbContents.append("\n<title>            </title>");
//				sbContents.append("\n<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//				sbContents.append("\n</head>");
//				sbContents.append("\n<body>");
//				sbContents.append("\n<table width='100%' border='0' cellpadding='0' cellspacing='0' style='padding-top: 2; padding-left: 5;'>");
//				sbContents.append("\n	<tr>");
//				sbContents.append("\n		<td valign='top'>");
//				sbContents.append("\n		<table border='0' cellpadding='0' cellspacing='0' width='600'>");
//				sbContents.append("\n			<tr>");
//				sbContents.append("\n				<td height='25'>");
//				sbContents.append("\n				<table border='0' cellpadding='0' cellspacing='0' width='100%'>");
//				sbContents.append("\n					<tr>");
//				sbContents.append("\n						<td width='100%' colspan='2'>");
//				sbContents.append("\n 					  <textarea name='reject_reason' style='width:100%;height:500'>"+rjctRsnRmk+"</textarea>");
//				sbContents.append("\n						</td>");
//				sbContents.append("\n					</tr>");
//				sbContents.append("\n					<tr>");
//				sbContents.append("\n						<td width='40%'>");
//				sbContents.append("\n						</td>");
//				sbContents.append("\n						<td></td>");
//				sbContents.append("\n					</tr>");
//				sbContents.append("\n				</table>");
//				sbContents.append("\n				</td>");
//				sbContents.append("\n			</tr>");
//				sbContents.append("\n		</table>");	
//				sbContents.append("\n		</td>");
//				sbContents.append("\n	</tr>");
//				sbContents.append("\n</table>");
//				sbContents.append("\n</body>");
//				sbContents.append("\n</html>");
//
//
//				// 메일발송
//				Mail mail = new Mail();
//				mail.setFrom(senderEml); //보내는 사람 메일주소
//				if(null != blPrfShprFlg && blPrfShprFlg.equals("Y")){
//					mail.setSubject("NYK Group - Internet B/L Change Request Not  Accepted ");  //메일제목
//				}else{
////					mail.setSubject("Your e-Booking & SI request was rejected due to below reason");  //메일제목
//					mail.setSubject("Internet Booking Request Rejected - < " + + " >");  //메일제목
//				}
//				
//				mail.setRecipient(cntcEml);  //받는 사람 메일주소
//				mail.setTextContent(rjctRsnRmk); //Text로된 본문 내용
//				//			   mail.setHtmlContent(sbContents.toString());
//				mail.send();				
//			}			
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}		
//	}
	
}