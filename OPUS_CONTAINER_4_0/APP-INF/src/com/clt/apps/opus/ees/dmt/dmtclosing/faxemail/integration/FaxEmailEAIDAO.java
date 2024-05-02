/*========================================================
*Copyright(c) 2009 CyberLogitec
*ProcessChain    : NPI
*@FileName       : FaxEmailEAIDAO.java
*@FileTitle      : OPUS
*Open Issues     :
*Change history  :
*@LastModifyDate : Sep 21, 2009
*@LastModifier   : Sung-Hoon, LEE
*@LastVersion    : 1.0
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.faxemail.integration;

import com.clt.apps.opus.ees.dmt.dmtclosing.faxemail.basic.FaxEmailBCImpl;
import com.clt.apps.opus.ees.dmt.dmtclosing.faxemail.vo.GRWEmailNoticeVO;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.support.layer.integration.EAIDAOSupport;

/**
 * OPUS FaxEmailEAIDAO <br>
 * - OPUS-FaxEmail system Business Logic을 처리하기 위한 EAI 작업수행.<br>
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
			}
			else if ("EES_DMT_0001_02T.html".equals(gRWEmailNoticeVO.getHtmltemplate())) {
				templateMail.setArg("scno", 	gRWEmailNoticeVO.getScNo()		);
				templateMail.setArg("blno", 	gRWEmailNoticeVO.getBlNo()		);
			}
			
			templateMail.setArg("rfano", 	gRWEmailNoticeVO.getRfaNo()			);
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
}
