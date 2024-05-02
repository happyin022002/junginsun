/*========================================================
*Copyright(c) 2009 CyberLogitec 
*ProcessChain    : NPI
*@FileName       : GroupwareMailPopupExecuteEAIDAO.java
*@FileTitle      : NIS2010
*Open Issues     :
*Change history  :
*@LastModifyDate : May 26, 2009
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
/**
 * 
 */
package com.hanjin.syscommon.common.groupwaremail.integration;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.support.schema.groupware.GetMailEpInfo;
import com.hanjin.framework.support.schema.groupware.GroupwareMailRequest;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxDocClient;

/** It's GroupwareMailPopupExecuteEAIDAO.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2EE 1.5
 * May 26, 2009
 */
public class GroupwareMailPopupExecuteEAIDAO extends EAIDAOSupport {

	/**
	 * This method opens a popup of groupware's mail.
	 * @author Jeong-Hoon, KIM
	 * @param gwSubject
	 * @param gwContents
	 * @param gwTo
	 * @param gwCc
	 * @param account
	 * @return
	 * @throws DAOException 
	 */
	public String popGroupwareWindow(String gwSubject, String gwContents, String gwTo, String gwCc,	SignOnUserAccount account) throws DAOException {
		TransferEAI transferEAI = new AxDocClient(SiteConfigFactory.getWhenNullThrowException("COM.COM012_0001.WSDL"), this.getClass());
		String returnMessage;
		try {
			returnMessage = webserviceRequest(gwSubject, gwContents, gwTo, gwCc, transferEAI, account);
		} catch (SQLException e) {
			log.error("["+e.getClass().getName()+"]"+e.getMessage());
			throw new DAOException("["+e.getClass().getName()+"]"+e.getMessage());
		} catch (Exception e) {
			log.error("["+e.getClass().getName()+"]"+e.getMessage());
			throw new DAOException("["+e.getClass().getName()+"]"+e.getMessage());
		}		
		String returnValue = webserviceResponse(transferEAI, returnMessage);		

		log.info("[GetMailEpInfoResult Response]"+returnValue);
		return returnValue;
	}
	
	/**
	 * 
	 * @param gwSubject
	 * @param gwContents
	 * @param gwTo
	 * @param gwCc
	 * @param transferEAI
	 * @param account
	 * @return
	 * @throws Exception
	 */
	private String webserviceRequest(String gwSubject, String gwContents, String gwTo, String gwCc,	TransferEAI transferEAI, SignOnUserAccount account)  throws Exception {
			String dateTime = "COM0120001" + (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
			GroupwareMailRequest eaiUtil = new GroupwareMailRequest("COM012_0001");
			GetMailEpInfo epInfo = new GetMailEpInfo();
			epInfo.setInstanceId(dateTime);
			boolean ssoEnableFlag = new Boolean(SiteConfigFactory.getWhenNullThrowException("COM.HANJIN.SSO.ENABLED"));
			if((SubSystemConfigFactory.get("COM.IAM.NAME").equals(account.getCre_usr_id()) ? true : false) && ssoEnableFlag){
				ssoGroupwarePopup(account, epInfo);
			} else if(!ssoEnableFlag){
				epInfo.setUserID("21702011"); //0915006
				epInfo.setGlobalUserId("21702011");
			} else{
				log.error("Please Check your status of SSO. Values IAM[" + SubSystemConfigFactory.get("COM.IAM.NAME") + "] account[" + account.getCre_usr_id() + "] ssoEnableFlag[" + ssoEnableFlag);
				throw new Exception("Please Check your status of SSO. Values IAM[" + SubSystemConfigFactory.get("COM.IAM.NAME") + "] account[" + account.getCre_usr_id() + "] ssoEnableFlag[" + ssoEnableFlag);
			}
			
			epInfo.setFormDistinct("MAIL_EP_1");
			epInfo.setSystemDocumentID(getSystemDocumentId());
			epInfo.setSystemName(SiteConfigFactory.getWhenNullThrowException("COM.HANJIN.SYSTEM.TYPE"));
			epInfo.setXmldom("<?xml version='1.0' encoding = 'UTF-8' ?><ROOT><SUBJECT>" +
								gwSubject +
								"</SUBJECT><TO>" +
								gwTo +
								"</TO><CC>" +
								gwCc +
								"</CC><BODY><CONTENTS><![CDATA[" +
								gwContents +
								"]]></CONTENTS></BODY></ROOT>");
			
			eaiUtil.addDataList(epInfo);
			eaiUtil.createdMsg();
			transferEAI.setMessage(eaiUtil.toString());
			String returnMessage = "";
			try {
				returnMessage = transferEAI.commit(dateTime);
			} catch (EAIException e) {
				transferEAI.rollback(e);
				log.error(e.getMessage(),e);			
				throw new DAOException("["+e.getClass().getName()+"]"+e.getMessage());
			} catch (Exception e){
				transferEAI.rollback(e);
				log.error(e.getMessage(),e);
				throw new DAOException("["+e.getClass().getName()+"]"+e.getMessage());
			}
			return returnMessage;
	}
	
	/**This method 
	 * @author Jeong-Hoon, KIM
	 * @param account
	 * @param epInfo
	 * @throws SQLException
	 * @throws DAOException
	 */
	private void ssoGroupwarePopup(SignOnUserAccount account, GetMailEpInfo epInfo) throws SQLException, DAOException {
		if (new GroupwareMailPopupExecuteEAIDAO().getGroupwareUserId(account.getUsr_id()) == null ? false : true) {
			epInfo.setUserID(getGroupwareUserId(account.getUsr_id()));
			epInfo.setGlobalUserId(account.getUsr_id());
		} else {
			throw new DAOException("Check your Id that regists in SSO."+"["+account.getUsr_id()+"]"+"["+account.getCre_usr_id()+"]");
		}
	}

	/**This method 
	 * @author Jeong-Hoon, KIM
	 * @return
	 */
	private String getSystemDocumentId() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentTime = dateFormat.format(new Date());
		String systemDocumentId = SiteConfigFactory.getWhenNullThrowException("COM.HANJIN.SYSTEM.TYPE")+"_"+currentTime+new Random().nextInt(1000);
		return systemDocumentId;
	}

	/**This method gets a groupware user Id
	 * @author Jeong-Hoon, KIM
	 * @param cre_usr_id
	 * @return
	 * @throws DAOException 
	 * @throws SQLException 
	 */
	public String getGroupwareUserId(String userId) throws SQLException, DAOException {
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("usr_id", userId);
		DBRowSet rowSet = new SQLExecuter("SysComDB").executeQuery(new GroupwareMailPopupExecuteDAOGroupwareIdRSQL(), mapParam, null);
		rowSet.next();
		String returnValue = rowSet.getString("EP_ID");
		return returnValue;
	}

	private String webserviceResponse(TransferEAI transferEAI, String returnMessage) throws DAOException {
		String[] replaces = new String[2];
		log.error("webserviceResponse : " + returnMessage);
		replaces[0] = "<COM012_0001ProcessResponse xmlns=\"http://xmlns.oracle.com/COM012_0001\"><GetMailEpInfoResult xmlns=\"http://xmlns.oracle.com/COM012_0001\">";
		replaces[1] = "</GetMailEpInfoResult></COM012_0001ProcessResponse>";
		for (int i = 0; i < replaces.length; i++) {
			returnMessage = returnMessage.replaceAll(replaces[i], "");
		}
		return returnMessage;
	}
}
