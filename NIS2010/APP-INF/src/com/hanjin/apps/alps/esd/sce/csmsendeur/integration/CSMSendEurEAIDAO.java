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
package com.hanjin.apps.alps.esd.sce.csmsendeur.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hanjin.apps.alps.esd.sce.csmsend.basic.CSMSendBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
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
public class CSMSendEurEAIDAO   extends EAIDAOSupport {
    
	/** EAI로 Flat File의 내용을 전송한다.
     * @param sbuf String
     * @return String
     */
    public String sendFlatFileIntoQueue(String sbuf) throws Exception{
        String resultString = "";
        try {
			resultString = sendEDIMQ(sbuf.toString());
		} catch (Exception e) {
			log.error("err  " + e.getMessage());
            throw new Exception("EAI Exception !" + e.getMessage()  );
		}
        return resultString;
    }
    
    /** EAI로 Flat File 의 내용을 전송한다.
     * @param str String
     * @return String
     */
    public String sendEDIMQ(String str) throws Exception {
		String reString = "";

		/* System properties : classpath/properties/subsystem-config.properties */
		String target = SubSystemConfigFactory.get("SCE.IBMMQ.URL"); // alias
		String transfertype = SubSystemConfigFactory.get("SCE.IBMMQ.TRANSFERTYPE"); // alias
		String channel = SubSystemConfigFactory.get("SCE.IBMMQ.CHANNEL"); // alias
		String factory = SubSystemConfigFactory.get("SCE.IBMMQ.FACTORY"); // alias
		String queue = SubSystemConfigFactory.get("SCE.ALPSSCE_UDEVHJS_CSM.IBMMQ.QUEUE"); // alias
		String targetclient = SubSystemConfigFactory.get("SCE.IBMMQ.TARGETCLIENT"); // alias 

		TransferEAI eai = new IBMSendQClient(target, this.getClass());
		// eai.setIntegrationID("ALPSSCE_T_UDEVHJS_CSM"); //<== EAI SEND QUEUE 방식에
		// 따른 연동 ID부여를 준용한다.
		eai.setTransferType(transfertype);
		eai.setChannel(channel);
		eai.setFactory(factory);
		eai.setQueue(queue);
		eai.setTargetClient(targetclient);
		eai.setMessage(str);

		// log.debug("\n >> EAI Information : " + eai.getEaiInfo() );
		try {
			reString = eai.commit("ALPSSCE_UBIZHJS_CSM" // QUEUE 이름
					+ (new SimpleDateFormat("yyyyMMddHHmmssSSS"))
							.format(new Date())); // <== EAI SEND QUEUE 방식에 따른
													// 연동 ID부여를 준용한다.
			log.debug("\n >> EAI reString(MQ) : " + reString);
		} catch (EAIException ea) {
			eai.rollback(ea);

			log.error(ea.getMessage(), ea);
			throw new EAIException(new ErrorHandler(ea).getMessage());
		}
		eai.close();

		return reString;
	}
    
   
}
