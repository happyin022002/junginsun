/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportEAIDAO.java
*@FileTitle : Mail을 발송하는 기능
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.01
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.26 김기종
* 1.0 Creation
* 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
* 2012.07.20 김진주 SI Transfer 모니터링 중지(Cc메일 계정 삭제)
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueBkgHistListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailReturnInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSREmlCtntVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.io.FileUtils;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * It's PerformanceReportEAIDAO.java
 * @authorKim Ki Jong
 * @see 
 * @since J2EE 1.6
 * Apr 27, 2009
 */
public class PerformanceReportEAIDAO extends EAIDAOSupport{
	
	/**
	 * DPCS Reject 시 화주에게 Reject 메일 발송<br>
	 *
	 * @param DocQueueDetailReturnInVO vo
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void sendDpcsRejectEmail(DocQueueDetailReturnInVO vo,SignOnUserAccount account) throws DAOException{
		try{
			BookingUtil util = new BookingUtil();
			String senderMailAddr ="";
			if (vo.getFoInclEmlFlg().equals("Y")){
				senderMailAddr = util.searchGroupEmailAddrRSQL(vo.getBkgNo(), account.getUsr_id(),"EM","BL");
			}
			
			Mail mail = new Mail();
			mail.setFrom(senderMailAddr.equals("") ? account.getUsr_eml():senderMailAddr); //보내는 사람 메일주소
			mail.setSubject(vo.getEmlSubjCtnt()); //메일제목
			mail.setCcRcvrEml(senderMailAddr);
			mail.setRecipient(vo.getRtnToUsrEml()); //받는 사람 메일주소
			mail.setTextContent(vo.getMessage()); //Text로된 본문 내용
			
			// 메일발송
			mail.send();				
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * @param DocQueueBkgHistListVO docQueueBkgHistListVO
	 * @param SignOnUserAccount account
	 * @param String rcvMail
	 * @throws DAOException
	 */
	public void sendDpcsFaxEmail(DocQueueBkgHistListVO docQueueBkgHistListVO,
			SignOnUserAccount account, String rcvMail) throws DAOException{
		try{
//			BookingUtil util = new BookingUtil();
//			String senderMailAddr ="";
			String subject = "<"+docQueueBkgHistListVO.getSrUrgCd()+"/"+
			                     docQueueBkgHistListVO.getSrAmdTpCd()+"/"+
			                     docQueueBkgHistListVO.getBkgNo()+">";
			String mailContent = "<DUEDATE:"+docQueueBkgHistListVO.getSrDueDt()+">\n"+
								  "<SPLITFLAG:"+docQueueBkgHistListVO.getSplitFlg()+">\n"+
								  "<SPLITNO:"+docQueueBkgHistListVO.getBlSplitNo()+">\n"+
								  "<SPLITTOTAL:"+docQueueBkgHistListVO.getBlSplitTtlKnt()+">\n"+
								  "<FMSRNO:"+docQueueBkgHistListVO.getSrNo()+">\n"+
								  "<FMFAXREFNO:"+docQueueBkgHistListVO.getFaxLogRefNo()+">\n"+
								  "<ID:"+account.getUsr_id()+">\n"+
								  "<MAIL:"+docQueueBkgHistListVO.getFntOfcEml()+">\n"+
								  "<SOURCE:DCF>";
			//String targetImgFilePath = "//a_dpcs/module/BKG" + "/" + docQueueBkgHistListVO.getRcvOfcCd()
			//                         + "/" + docQueueBkgHistListVO.getImgFilePathCtnt()+ "/mail/";
			
			String targetImgFilePath = "/a_upload/FILE/EML/";
			
			log.debug("\n 1 targetImgFilePath:"+targetImgFilePath);
			FileUtils.mkdir(targetImgFilePath);
			
			log.debug("\n 2 targetImgFilePath:"+targetImgFilePath);
			FileUtils.fileCopy(docQueueBkgHistListVO.getImgFileRealPath(), targetImgFilePath+docQueueBkgHistListVO.getImgFileNm());
			
			
			log.debug("\n subject:"+subject);
			log.debug("\n mailContent:"+mailContent);
			Mail mail = new Mail();
			mail.setFrom(account.getUsr_eml()); //보내는 사람 메일주소
			log.debug("account.getUsr_eml():"+account.getUsr_eml() );
			mail.setSubject(subject); //메일제목
			mail.setRecipient(rcvMail); //받는 사람 메일주소
			mail.setTextContent(mailContent); //Text로된 본문 내용
//			mail.setTextContent("si test,,,,,,"); //Text로된 본문 내용
			
			// 파일 첨부를 위한 파일 List 선언
			List<SingleMailAttachedFile> list = new ArrayList<SingleMailAttachedFile>();
			// 첫번째 FileKey를 이용한 AttachedFile 객체 생성
			SingleMailAttachedFile attatchedFile = new SingleMailAttachedFile();
//			attatchedFile.setFileLocation(docQueueBkgHistListVO.getImgFileRealPath() );//+vo.getFileName());
			
			attatchedFile.setFileLocation(targetImgFilePath+docQueueBkgHistListVO.getImgFileNm() );//+vo.getFileName());
			
			attatchedFile.setFileName(docQueueBkgHistListVO.getImgFileNm());
//			attatchedFile.setFileKey("dpcs"); //주석
			
			list.add(attatchedFile);
			log.debug("\n si auto mail:---------1:"+docQueueBkgHistListVO.getImgFileRealPath()+docQueueBkgHistListVO.getImgFileNm());
 

			// 메일에 파일을 첨부하고 메일을 전송
			mail.setAttachedFile(list);
			log.debug("\n si auto mail:---------2");

			
			// 메일발송
			mail.send();					
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	

	
	/**
	 * 첨부파일의 재변환을 위해 메일을 전송한다.
	 * 첨부된 파일이 가로/세로 양식이 혼재된 경우 OCR인식률이 떨어져 재변환이 필요한 경우 사용하는 기능.
	 * @param SearchSREmlCtntVO vo
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void sendEmlConversionRequest(SearchSREmlCtntVO vo, SignOnUserAccount account) throws DAOException{
		try{
			String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
			 boolean isLive = false;     // Live 여부
			 if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
				 isLive = true;
			 }
			
			Mail mail = new Mail();
			mail.setFrom(account.getUsr_eml()); //보내는 사람 메일주소
			mail.setSubject(vo.getEmlSubjCtnt() + vo.getEmlOrgSubjCtnt()); //메일제목			
			mail.setTextContent(vo.getTextContent()+vo.getEmlMnCtnt()); //Text로된 본문 내용
			
			if(isLive == true){
				mail.setRecipient(vo.getRecipient()); //받는 사람 메일주소
			}else{
				mail.setRecipient("sitrans_test@smlines.com"); //받는 사람 메일주소
			}
			
			// 메일발송
			mail.send();					
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	
	/**
	 * RD 메일을 전송한다.(파일 미첨부)
	 * 
	 * @param Mail mail
	 * @return String
	 */
	public String sendRDEmail(Mail mail) throws Exception {
		
		return mail.send();
	}
 
}
