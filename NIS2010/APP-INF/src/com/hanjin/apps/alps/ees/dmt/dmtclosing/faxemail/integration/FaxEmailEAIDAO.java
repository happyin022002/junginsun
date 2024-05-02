/*========================================================
*Copyright(c) 2009 CyberLogitec
*ProcessChain    : NPI
*@FileName       : FaxEmailEAIDAO.java
*@FileTitle      : NIS2010
*Open Issues     :
*Change history  :
*@LastModifyDate : Sep 21, 2009
*@LastModifier   : Sung-Hoon, LEE
*@LastVersion    : 1.0
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.integration;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.basic.FaxEmailBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo.GRWEmailChgDeltNoticeVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo.GRWEmailNoticeBasicCmdtVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.vo.GRWEmailNoticeVO;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;

/**
 * NIS2010 FaxEmailEAIDAO <br>
 * - NIS2010-FaxEmail system Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author Sunyoung 
 * @see FaxEmailBCImpl 참조
 * @since J2EE 1.6
 */

public class FaxEmailEAIDAO extends EAIDAOSupport {
	/**
	 * [E-Mail] : []
	 * [Approval, Counter Offer, Reject 된 Before 나 After Booking] 을 [Email Send] 합니다.<br>
	 * 
	 * @param GRWEmailNoticeVO gRWEmailNoticeVO
	 * @throws MailerAppException
	 */
	public void sendGRWMail(GRWEmailNoticeVO gRWEmailNoticeVO) throws MailerAppException {
		
		try {
			TemplateMail templateMail = new TemplateMail();
			
			templateMail.setFrom(			gRWEmailNoticeVO.getSender()		);
			templateMail.setSubject(		gRWEmailNoticeVO.getSubject()		);
			templateMail.setRecipient(		gRWEmailNoticeVO.getRecipient()		);
			templateMail.setHtmlTemplate(	gRWEmailNoticeVO.getHtmltemplate()	);
			
			templateMail.setArg("darno", 	gRWEmailNoticeVO.getDarNo()			);
			templateMail.setArg("apvlno", 	gRWEmailNoticeVO.getApvlNo()		);
			templateMail.setArg("status", 	gRWEmailNoticeVO.getStatus()		);
			
			if ("EES_DMT_0001_01T.html".equals(gRWEmailNoticeVO.getHtmltemplate())) {
				templateMail.setArg("verno", 	gRWEmailNoticeVO.getVerNo()		);
				templateMail.setArg("propno", 	gRWEmailNoticeVO.getPropNo()	);
				templateMail.setArg("rfano", 	gRWEmailNoticeVO.getRfaNo()			);
			}
			else if ("EES_DMT_0001_02T.html".equals(gRWEmailNoticeVO.getHtmltemplate())) {
				templateMail.setArg("scno", 	gRWEmailNoticeVO.getScNo()		);
				templateMail.setArg("blno", 	gRWEmailNoticeVO.getBlNo()		);
				templateMail.setArg("rfano", 	gRWEmailNoticeVO.getRfaNo()			);
				templateMail.setArg("textContent", 	gRWEmailNoticeVO.getTextcontent()			);					
			}
			else if ("EES_DMT_0001_03T.html".equals(gRWEmailNoticeVO.getHtmltemplate())) {
				templateMail.setArg("verno", 	gRWEmailNoticeVO.getVerNo()		);
				templateMail.setArg("propno", 	gRWEmailNoticeVO.getPropNo()	);
				templateMail.setArg("scno", 	gRWEmailNoticeVO.getScNo()		);
			}
			
			templateMail.setArg("custcd", 	gRWEmailNoticeVO.getCustCd()		);
			templateMail.setArg("custnm", 	gRWEmailNoticeVO.getCustNm()		);
			templateMail.setArg("comment", 	gRWEmailNoticeVO.getComments()		);
				
			templateMail.setGroupwareMail();
			templateMail.send();

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new MailerAppException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [E-Mail] : []
	 * [Invoice Cancel Info]을 [Email Send] 합니다.<br>
	 * 
	 * @param GRWEmailNoticeVO gRWEmailNoticeVO
	 * @return String
	 * @throws MailerAppException
	 */
	public String sendEmailforCancelInvoice(GRWEmailNoticeVO gRWEmailNoticeVO) throws MailerAppException {
		
		try {
			TemplateMail templateMail = new TemplateMail();
			
			templateMail.setFrom(		gRWEmailNoticeVO.getSender()	);
			templateMail.setRecipient(	gRWEmailNoticeVO.getRecipient()	);
			templateMail.setSubject(	gRWEmailNoticeVO.getSubject()	);
			templateMail.setTextContent(gRWEmailNoticeVO.getTextcontent());
			
			return templateMail.send();
		} 
		catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new MailerAppException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [E-Mail] : []
	 * [Approval, Counter Offer, Reject 된 Before 나 After Booking] 을 [Email Send] 합니다.<br>
	 * 
	 * @param GRWEmailNoticeBasicCmdtVO gRWEmailNoticeBasicCmdtVO
	 * @param List<SingleMailAttachedFile>  arFileList
	 * @throws MailerAppException
	 */
	public void sendGRWEmailBasicCmdt(GRWEmailNoticeBasicCmdtVO gRWEmailNoticeBasicCmdtVO, List<SingleMailAttachedFile>  arFileList) throws MailerAppException {
		
		try {
			TemplateMail templateMail = new TemplateMail();
			
			templateMail.setFrom(					gRWEmailNoticeBasicCmdtVO.getSender()			);
			templateMail.setSubject(				gRWEmailNoticeBasicCmdtVO.getSubject()			);
			templateMail.setRecipient(				gRWEmailNoticeBasicCmdtVO.getRecipient()		);
			templateMail.setHtmlTemplate(			gRWEmailNoticeBasicCmdtVO.getHtmltemplate()		);

			templateMail.setArg("expDtEng", 		gRWEmailNoticeBasicCmdtVO.getExpDtEng()			);
			templateMail.setArg("expDt7Eng", 		gRWEmailNoticeBasicCmdtVO.getExpDt7Eng()		);
			//첨부파일 설정.
			templateMail.setAttachedFile(arFileList);	
			
			
			templateMail.setGroupwareMail();
			templateMail.send();

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new MailerAppException(new ErrorHandler(ex).getMessage());
		} 
	}
	
	
	/**
	 * [Charge Deletion 요청에 대해 Approval, Reject 처리시 하위 Office 결재자들에게 Notice] 를 [Email Send] 합니다.<br>
	 * 
	 * @param GRWEmailChgDeltNoticeVO gRWEmailChgDeltNoticeVO
	 * @return String
	 * @throws MailerAppException
	 */	
	public String sendChgDeltNoticeGWMail(GRWEmailChgDeltNoticeVO gRWEmailChgDeltNoticeVO) throws MailerAppException {
		
		try {
			TemplateMail templateMail = new TemplateMail();
			templateMail.setFrom(						gRWEmailChgDeltNoticeVO.getSender()			);
			templateMail.setRecipient(					gRWEmailChgDeltNoticeVO.getRecipient()		);
			templateMail.setSubject(					gRWEmailChgDeltNoticeVO.getSubject()		);
			templateMail.setHtmlTemplate(				gRWEmailChgDeltNoticeVO.getHtmltemplate()	);
			
			templateMail.setArg("BKG_NO", 				gRWEmailChgDeltNoticeVO.getBkgNo()			);
			templateMail.setArg("CNTR_NO", 				gRWEmailChgDeltNoticeVO.getCntrNo()			);
			templateMail.setArg("DMDT_TRF_CD", 			gRWEmailChgDeltNoticeVO.getDmdtTrfCd()		);
			templateMail.setArg("CHG_DELT_STS_CD", 		gRWEmailChgDeltNoticeVO.getChgDeltStsCd()	);
			templateMail.setArg("CHG_DELT_PATH_CD", 	gRWEmailChgDeltNoticeVO.getChgDeltPathCd()	);
			templateMail.setArg("CHG_DELT_USR_OFC_CD", 	gRWEmailChgDeltNoticeVO.getChgDeltUsrOfcCd());
			
			templateMail.setGroupwareMail();
			
			return templateMail.send();
		} 
		catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new MailerAppException(new ErrorHandler(ex).getMessage());
		}
	}		
	

	/**
	 * [E-Mail] : []
	 * [Approval, Counter Offer, Reject 된 Before 나 After Booking] 을 [Email Send] 합니다.<br>
	 * 
	 * @param GRWEmailNoticeVO gRWEmailNoticeVO
	 * @throws MailerAppException
	 */
	public void sendEmailSalesRep(GRWEmailNoticeVO gRWEmailNoticeVO) throws MailerAppException {
		
		try {
			TemplateMail templateMail = new TemplateMail();
			
			templateMail.setFrom(			gRWEmailNoticeVO.getSender()		);
			templateMail.setSubject(		gRWEmailNoticeVO.getSubject()		);
			templateMail.setRecipient(		gRWEmailNoticeVO.getRecipient()		);
			templateMail.setHtmlTemplate(	gRWEmailNoticeVO.getHtmltemplate()	);
			
			templateMail.setArg("subject", 	gRWEmailNoticeVO.getSubject()		);
			templateMail.setArg("comment", 	gRWEmailNoticeVO.getComments()		);
				
			templateMail.setGroupwareMail();
			templateMail.send();

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new MailerAppException(new ErrorHandler(ex).getMessage());
		}
	}
}
