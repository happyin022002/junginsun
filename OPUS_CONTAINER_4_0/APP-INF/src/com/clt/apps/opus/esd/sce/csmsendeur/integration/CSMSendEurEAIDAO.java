/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : CSMSendEAIDAO.java
 *@FileTitle : EDI와 EAI 연동 관련 데이터 생성 및 전송
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016-06-15
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.csmsendeur.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.clt.apps.opus.esd.sce.csmsend.basic.CSMSendBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;

/**
 * SCEM에 대한 DB / EAI 처리를 담당<br>
 * - SCEM Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author
 * @see CSMSendBCImpl 참조
 * @since J2EE 1.4
 */
public class CSMSendEurEAIDAO extends EAIDAOSupport {

	/**
	 * EAI로 Flat File의 내용을 전송한다.
	 * 
	 * @param sbuf String
	 * @return String
	 */
	public String sendFlatFileIntoQueue(String sbuf) throws Exception {
		String resultString = "";
		try {
			resultString = sendEDIMQ(sbuf.toString());
		} catch (Exception e) {
			log.error("err  " + e.getMessage());
			throw new Exception("EAI Exception !" + e.getMessage());
		}
		return resultString;
	}

	/**
	 * EAI로 Flat File 의 내용을 전송한다.
	 * 
	 * @param str String
	 * @return String
	 */
	public String sendEDIMQ(String str) throws Exception {
		String reString = "";
		String target = SubSystemConfigFactory.get("SCE.OPUSSCE_T_UDEVCOM_CSM.IBMMQ.URL"); // alias
		String transfertype = SubSystemConfigFactory.get("SCE.OPUSSCE_T_UDEVCOM_CSM.IBMMQ.TRANSFERTYPE"); // alias
		String channel = SubSystemConfigFactory.get("SCE.OPUSSCE_T_UDEVCOM_CSM.IBMMQ.CHANNEL"); // alias
		String factory = SubSystemConfigFactory.get("SCE.OPUSSCE_T_UDEVCOM_CSM.IBMMQ.FACTORY"); // alias
		String queue = SubSystemConfigFactory.get("SCE.OPUSSCE_T_UDEVCOM_CSM.IBMMQ.QUEUE"); // alias
		String targetclient = SubSystemConfigFactory.get("SCE.OPUSSCE_T_UDEVCOM_CSM.IBMMQ.TARGETCLIENT"); // alias

		TransferEAI eai = new IBMSendQClient(target, this.getClass());
		eai.setTransferType(transfertype);
		eai.setChannel(channel);
		eai.setFactory(factory);
		eai.setQueue(queue);
		eai.setTargetClient(targetclient);
		eai.setMessage(str);

		try {
			reString = eai.commit("OPUSSCE_T_UDEVCOM_CSM" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
		} catch (EAIException ea) {
			eai.rollback(ea);

			log.error(ea.getMessage(), ea);
			throw new EAIException(new ErrorHandler(ea).getMessage());
		}
		eai.close();

		return reString;
	}
}
