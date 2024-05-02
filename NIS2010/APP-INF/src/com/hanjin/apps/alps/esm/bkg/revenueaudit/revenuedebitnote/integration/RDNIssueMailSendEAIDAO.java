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
package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBCImpl;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltSearchRDNIssueMailingListVO;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;

/**
 * ALPS RDNIssueMailSendEAIDAO <br>
 * - ALPS-EBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Day-Hoh Kim
 * @see RevenueDebitNoteBCImpl 참조
 * @since J2EE 1.6
 */
public class RDNIssueMailSendEAIDAO extends EAIDAOSupport{

	private final String FROM_MAIL = "system@smlines.com";
 
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
		sbContents.append("1. RDN is automatically issued when B/L Rating has not been passed even after PCT(Port Closing Time).");
		sbContents.append("\n");
		sbContents.append("As soon as you receive the RDN e-mail, the Rating staff will perform B/L Rating immediately and ");
		sbContents.append("\n");
		sbContents.append("should manage so that our company’s revenue will not be missed.");
		sbContents.append("\n");
		sbContents.append("In order to prevent the RDN from occurring in the future, ");
		sbContents.append("\n");
        sbContents.append("all Rating staff should thoroughly manage all B/L Rating prior to PCT(Port Closing Time). ");
		sbContents.append("\n");
		sbContents.append("\n");
		sbContents.append("2. If you disagree to this debit note, please give us your cancel request");
		sbContents.append("\n");
		sbContents.append("together with the evidence through e-mail within 2 working days after receipt.");
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
			mail.setGroupwareMail();
			mail.send();
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}