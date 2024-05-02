/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RDNIssueMailSendEAIDAO.java
*@FileTitle : RDN Issuance by Auditor
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.19 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration;

import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBCImpl;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltSearchRDNIssueMailingListVO;
import com.clt.framework.component.javamail.Mail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;

/**
 * OPUS RDNIssueMailSendEAIDAO <br>
 * - OPUS-EBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Day-Hoh Kim
 * @see RevenueDebitNoteBCImpl 참조
 * @since J2EE 1.6
 */
public class RDNIssueMailSendEAIDAO extends EAIDAOSupport{

	private final String FROM_MAIL = "noreply@nykline.com";
 
	/**
	 *  RDN Issuance by Auditor Issue 발생시 메일 대상자에게 메일을 발송한다. <br>
	 *
	 * @param  RsltSearchRDNIssueMailingListVO[] pVOS
	 * @param  RsltSearchRDNIssueMailingListVO vo
	 * @exception Exception
	 */
	public void doMailRDNIssue(RsltSearchRDNIssueMailingListVO[] pVOS, RsltSearchRDNIssueMailingListVO vo) throws Exception {
		int cnt = 0;
		if (pVOS != null)
		{
			cnt = pVOS.length;
		}
		String sTitle = "";
		StringBuffer sbContents = new StringBuffer();
		StringBuffer sbToMail = new StringBuffer();

		// 메일제목 셋팅
		sTitle = vo.getMailTitle() + " " + vo.getRdnIssDtWk();
		// 메일본문 셋팅
		sbContents.append("TO: " + vo.getRctOfcCd() + "\n");
		sbContents.append("FM: " + vo.getContFm() + "\n");
		sbContents.append("\n\n");
		sbContents.append("Revenue Debit Note" + "\n");
		sbContents.append("\n");
		sbContents.append("RDN No : " + vo.getRdnNo() + "\n");
		sbContents.append("RDN Amount : " + vo.getRdnAmount() + "\n");
		sbContents.append("Issue Date : " + vo.getRdnIssDt() + "\n");
		sbContents.append("B/L No : " + vo.getBlNo() + "\n");
		sbContents.append("Contract No : " + vo.getScRfaNo() + "\n");
		sbContents.append("\n");
		sbContents.append("Error Kind : " + vo.getErrorKind() + "\n");
		if (!"AUTO".equals(vo.getIbflag()))
		{
			// 자동전송의 경우 해당 라인을 뺀다.
			sbContents.append("Error Remarks : " + vo.getUmchRmk() + "\n");
		}
		sbContents.append("\n");
		sbContents.append("1. If you agree to this debit note, please issue C/A within 5 working days after receipt and the");
		sbContents.append("\n");
		sbContents.append("collection office should collect the above debited amount from party concerned. And please ");
		sbContents.append("\n");
		sbContents.append("report us the occurrence reason of this error case in details and countermeasures taken/to be");
		sbContents.append("\n");
		sbContents.append("taken.");
		sbContents.append("\n");
		sbContents.append("\n");
		sbContents.append("2. If you disagree to this debit note, please give us your cancel request or revise request");
		sbContents.append("\n");
		sbContents.append("through \"RDN Receipt by Office\" within 5 working days after receipt.");
		sbContents.append("\n\n\n");
		sbContents.append("Best Regards,");
		sbContents.append("\n");
		// 받는사람
		for (int i = 0; i < cnt; i++)
		{
			sbToMail.append(pVOS[i].getUsrEml() + ";");
		}

		Mail mail = new Mail();
		try
		{
			// 메일발송
			mail.setFrom(FROM_MAIL); // 보내는 사람 메일주소
			mail.setSubject(sTitle); // 메일제목
			mail.setRecipient(sbToMail.toString()); // 받는 사람 메일주소
			mail.setTextContent(sbContents.toString()); // Text로된 본문 내용
//			mail.setGroupwareMail();
			mail.send();
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}