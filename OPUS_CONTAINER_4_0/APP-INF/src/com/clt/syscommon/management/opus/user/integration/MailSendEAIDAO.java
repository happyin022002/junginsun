/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FaxSendEAIDAO.java
*@FileTitle : Send Fax JMS Queue EAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-08
*@LastModifier : SW Jean
*@LastVersion : 1.0
* 2009-09-07 SW Jean
* 1.0 Creation
--------------------------------------------------------
* History 
* 2014.12.08  전상화 		   
=========================================================*/
package com.clt.syscommon.management.opus.user.integration;


import com.clt.framework.component.javamail.Mail;
import com.clt.framework.component.util.CryptUtil;
import com.clt.framework.core.config.SiteConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.syscommon.management.opus.user.vo.ComUserVO;


/**
 * ALPS FASendEAIDAO <br>
 * - ALPS-EquipmentManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.6
 */
public class MailSendEAIDAO   extends EAIDAOSupport{


	/**
	 * 
	 * sendEMail
	 * @author SW Jean
	 * @param comuservo
	 * @throws EventException void
	 */
	public void sendEMail(ComUserVO[] comuservo)  throws EventException {
		
		try {
			ComUserVO model = null;
			String newPasaword ="";
			
			String subjectText ="";
			
			StringBuilder textContent = new StringBuilder();
			
			String environment ="";
			String urlChangpassword="";
			
			if(! "NULL".equals(SiteConfigFactory.get("COM.CLT.PASSWORD.ENVIRONMENT", "NULL")))
				environment= SiteConfigFactory.get("COM.CLT.PASSWORD.ENVIRONMENT", "NULL");

			if(! "NULL".equals(SiteConfigFactory.get("COM.CLT.PASSWORD.URL.CHANGPASSWORD", "NULL")))
				urlChangpassword = SiteConfigFactory.get("COM.CLT.PASSWORD.URL.CHANGPASSWORD", "NULL");

			
			for (int i = 0; i < comuservo .length; i++) {
				model = comuservo[i];
				newPasaword = CryptUtil.decryptString(model.getUsrPwd());
				subjectText="OPUS Container Password Change in "+environment+" <User Name: "+model.getUsrNm()+", User ID: "+model.getUsrId() +">";
				textContent.append("This is an auto generated message and DO NOT reply to this message.  \n");
				textContent.append("If you have any question, please contact your local RHD or SYSTECH.   \n");
				textContent.append("Please note your password has been changed as below.   \n");
				textContent.append("Your new password :        "+ newPasaword +"     \n");
				textContent.append("Above password is temporary password and you will be required to change it after your next login to OPUS Container.   \n");
				textContent.append(urlChangpassword  + "?user_id=" + model.getUsrId());
				

				Mail mail = new Mail();
				mail.setFrom("noreply@nykline.com");
				mail.setSubject(subjectText);
				mail.setRecipient(model.getUsrEml());
				mail.setCcRcvrEml("");
				mail.setBccRcvrEml("");
				mail.setTextContent(textContent.toString() );
			}	 
					
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
	}
	
}
