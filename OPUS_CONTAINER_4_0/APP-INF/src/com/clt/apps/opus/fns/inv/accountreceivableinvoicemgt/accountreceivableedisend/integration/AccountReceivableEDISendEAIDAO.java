/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : AccountReceivableEDISendEAIDAO.java
 *@FileTitle : BackEndJob 결과Data조회
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.14
 *@LastModifier : JungJin Park
 *@LastVersion : 1.0
 * 2009.10.14
 * 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;
 
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;

/**
 * BackEndJob관련 LoadFile정보를 읽기위한 EAIDAO
 *  
 * @author JungJin Park
 * @see AccountReceivableEDISendEAIDAO
 * @since J2EE 1.4
 */
public class AccountReceivableEDISendEAIDAO extends EAIDAOSupport {
	private transient Logger log = Logger.getLogger(AccountReceivableEDISendEAIDAO.class.getName());
 
	/**
	 * EAI로 Flat filed의 내용을 전송한다.
	 * 
	 * @param String mqName
	 * @param String flatFile
	 * @return String
	 */
	public String sendToEDI(String mqName, String flatFile) throws Exception {
		String reString = "";
		String integrationId = SubSystemConfigFactory.get("INV.OPUSINV_UBIZCOM_INVOICE.IBMMQ.QUEUE") + (new SimpleDateFormat("yyMMddHHmmss")).format(new Date());

		String target = SubSystemConfigFactory.get("INV.IBMMQ.URL");
		String transfertype = SubSystemConfigFactory.get("INV.IBMMQ.TRANSFERTYPE");
		String channel = SubSystemConfigFactory.get("INV.IBMMQ.CHANNEL");
		String factory = SubSystemConfigFactory.get("INV.IBMMQ.FACTORY");
		String targetclient = SubSystemConfigFactory.get("INV.IBMMQ.TARGETCLIENT");

		TransferEAI eai = new IBMSendQClient(target, this.getClass());

		eai.setTransferType(transfertype);
		eai.setChannel(channel);
		eai.setFactory(factory);
		eai.setQueue(mqName);
		eai.setTargetClient(targetclient);
		eai.setMessage(flatFile);

		try {
			reString = eai.commit(integrationId); // <== EAI SEND QUEUE 방식에 따른
//			log.info("======================================");
//			log.info("reString : " + reString);
//			log.info("======================================");
		} catch (EAIException se) {
			eai.rollback(se);
			log.error(se.getMessage(), se);
			throw new EAIException(new ErrorHandler(se).getMessage());
		}

		eai.close();
		return reString;
	}
	/**
	 * EAI로 Flat filed의 내용을 전송한다.
	 *
	 * @param String recipient
	 * @param String mqName
	 * @param String flatFile
	 * @return String
	 */
	public String sendToEDI(String recipient ,String mqName, String flatFile) throws Exception {
		String reString = "";
		String integrationId = SubSystemConfigFactory.get("INV.ALPSINV_UBIZHJS_INVOICE.IBMMQ.QUEUE") + (new SimpleDateFormat("yyMMddHHmmss")).format(new Date());

		String target = SubSystemConfigFactory.get("INV.IBMMQ.URL");
		String transfertype = SubSystemConfigFactory.get("INV.IBMMQ.TRANSFERTYPE");
		String channel = SubSystemConfigFactory.get("INV.IBMMQ.CHANNEL");
		String factory = SubSystemConfigFactory.get("INV.IBMMQ.FACTORY");
		String targetclient = SubSystemConfigFactory.get("INV.IBMMQ.TARGETCLIENT");

		TransferEAI eai = new IBMSendQClient(target, this.getClass());

		eai.setTransferType(transfertype);
		eai.setChannel(channel);
		eai.setFactory(factory);
		eai.setQueue(mqName);
		eai.setTargetClient(targetclient);
		eai.setMessage(flatFile);

		try {
			reString = eai.commit(integrationId); // <== EAI SEND QUEUE 방식에 따른
			log.info("\n======================================");
			log.info("\nreString : " + reString);
			log.info("\n======================================");
		} catch (EAIException se) {
			eai.rollback(se);
			log.error(se.getMessage(), se);
			throw new EAIException(new ErrorHandler(se).getMessage());
		}

		eai.close();
		return reString;
	}	
}
