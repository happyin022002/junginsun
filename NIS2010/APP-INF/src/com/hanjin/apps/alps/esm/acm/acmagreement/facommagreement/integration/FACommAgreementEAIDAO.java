/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACommAgreementEAIDAO.java
*@FileTitle : FAC Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.03 김봉균
* 1.0 Creation
 =========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.facommagreement.integration;

import com.hanjin.apps.alps.esm.acm.acmagreement.facommagreement.vo.FACAgreementVO;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ACM에 대한 EAI 처리를 담당<br> - ALPS-ACM Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author KIM, Bong-Gyoon
 * @see FACommAgreementBCImpl 참조
 * @since J2EE 1.6
 */
public class FACommAgreementEAIDAO extends EAIDAOSupport {

	/**
	 * EAI 연동시 해당 VO에 데이타를 셋팅한다.<br>
	 * 
	 * @param String sts
	 * @param String subject
	 * @param String htmlTmp
	 * @param FACAgreementVO[] facAgreementVOs
	 * @param SignOnUserAccount account
	 * @param String dt
	 * @throws DAOException
	 */
	public void sendACMTemplateMail(String sts, String subject, String htmlTmp, FACAgreementVO[] facAgreementVOs,
			SignOnUserAccount account, String dt) throws DAOException {
		
		String str1 = "agreements";
		String str2 = "them";
		String style_str = "padding:0px; border: #CAE2E9 1px solid; font-family: Arial; font-size: 10px;";
		String ofc_cd = null;
		String iCount = null;
		String recipientsEml = null;
		
		String[] recipientsEml_arr = null;
		String[] recipientsName_arr = null;
		
		StringBuffer tr_str = new StringBuffer();
		
		try{
			if(facAgreementVOs.length > 0){
				for(int i=0; i<facAgreementVOs.length; i++){
					tr_str.append("	<tr style='height:20; '>");
					tr_str.append("		<td style='"+style_str+"' align='center'>" + facAgreementVOs[i].getFrtCntSeq() + "</td>");
					tr_str.append("		<td style='"+style_str+"' >" + facAgreementVOs[i].getFfLglEngNm() + "</td>");
					tr_str.append("		<td style='"+style_str+"' align='center'>" + facAgreementVOs[i].getFacDivCd() + "</td>");
					tr_str.append("		<td style='"+style_str+"' align='right'>" + facAgreementVOs[i].getBkgFacRt() + "</td>");
					tr_str.append("		<td style='"+style_str+"' align='right'>" + facAgreementVOs[i].getBkgFacBlAmt() + "</td>");
					tr_str.append("		<td style='"+style_str+"' align='right'>" + facAgreementVOs[i].getFacBxAmt() + "</td>");
					tr_str.append("		<td style='"+style_str+"' align='right'>" + facAgreementVOs[i].getFacTeuAmt() + "</td>");
					tr_str.append("		<td style='"+style_str+"' align='right'>" + facAgreementVOs[i].getFacFeuAmt() + "</td>");
					tr_str.append("		<td style='"+style_str+"' align='right'>" + facAgreementVOs[i].getFacRfTeuAmt() + "</td>");
					tr_str.append("		<td style='"+style_str+"' align='right'>" + facAgreementVOs[i].getFacRfFeuAmt() + "</td>");
					tr_str.append("		<td style='"+style_str+"'>" + facAgreementVOs[i].getFacChgCtnt() + "</td>");
					tr_str.append("	</tr>");
					log.info("\n facAgreementVOs[i].getFacOfcCd()="+facAgreementVOs[i].getFacOfcCd());
					log.info("\n facAgreementVOs[i].getCnt()="+facAgreementVOs[0].getCnt());
				}
				ofc_cd = facAgreementVOs[0].getFacOfcCd();
				iCount = facAgreementVOs[0].getCnt();
				// 받는 사람의 정보를 가져온다.
				log.debug("facAgreementVOs[0].getRecipientsEml()==>"+facAgreementVOs[0].getRecipientsEml());
				recipientsEml_arr = facAgreementVOs[0].getRecipientsEml().split(";");
				log.debug("facAgreementVOs[0].getRecipientsName()==>"+facAgreementVOs[0].getRecipientsName());
				recipientsName_arr = facAgreementVOs[0].getRecipientsName().split(";");
			}
			
			TemplateMail mailer = new TemplateMail();
			mailer.setHtmlTemplate(htmlTmp); // 테이블형태로 데이타를 보여주기 위해서 html 형식으로만 Mail을 발송한다.
			
			// 보내는 사람의 정보를 셋팅한다.
			mailer.setFrom(account.getUsr_eml(), account.getUsr_nm());
			// TITLE을 셋팅한다.
			mailer.setSubject(subject);
			// Mail 양식에 맞춰 데이타를 셋팅한다.
			mailer.setArg("ofc_cd", ofc_cd);
			mailer.setArg("date", dt);

			log.debug("sts====>"+sts);
			if( Integer.parseInt(iCount) > 0 ) {					
				str1 = "agreement";
				str2 = "it";
			}

			// Mail 양식에 맞춰 데이타를 셋팅한다.
			mailer.setArg("cnt", iCount);
			mailer.setArg("str1", str1);
			mailer.setArg("str2", str2);
			mailer.setArg("tr_str", tr_str==null?"":tr_str.toString());

			// 받는 사람의 정보를 Loop를 돌면서 셋팅한 후 Mail을 보낸다.
			for(int j=0; recipientsEml_arr!=null && j<recipientsEml_arr.length; j++) {

				recipientsEml = recipientsEml_arr[j]==null?"":recipientsEml_arr[j];

				if(recipientsEml.length() > 0) {
					mailer.setRecipient(recipientsEml);
					mailer.setArg("name", recipientsName_arr[j]);
					mailer.send();
					log.info("\n "+j+"번째 recipientsEml :: "+recipientsEml);
					log.info("\n "+j+"번째recipientsName_arr :: "+recipientsName_arr[j]);
				}
			}

			log.info("\n Mail Send Success");

		}catch (MailerAppException me) {
			log.info("\n Mail Send Error \n"+me.getMessage());
			throw new DAOException(new ErrorHandler(me).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());			
		} 
		
	}
}