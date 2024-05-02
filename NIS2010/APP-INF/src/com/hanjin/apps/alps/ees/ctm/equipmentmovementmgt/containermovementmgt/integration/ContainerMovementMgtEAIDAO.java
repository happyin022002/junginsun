/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBEAIDAO.java
*@FileTitle : VesselScheduleMgtDBEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : Jeong Myounghun
*@LastVersion : 1.0
* 2009.06.22 Jeong Myounghun
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;

/**
 * It's ASynch IBM MQ Listener 
 * @author Jeong Myounghun
 * @see 
 * @since J2EE 1.6
 * June 22, 2009
 */
public class ContainerMovementMgtEAIDAO extends EAIDAOSupport {

	/**
	 * 주한진 : NIS_UBIZHJS_EQMVMT
	 * EDI : 한국지역 Movement에 대하여 EDI메시지를 전송한다.<br>
	 * 
	 * @param  String flatFile
	 * @return String
	 * @exception EAIException
	 * @throws Exception
	 */
	public String sendEdiContainerMovementdo(String flatFile) throws Exception {
		String integrationId = "CTM_CTM406_0001" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
		String target = SubSystemConfigFactory.get("CTM.ALPSCTM_UDEVHJS_EQMVMT.IBMMQ.URL");
		String transfertype = SubSystemConfigFactory.get("CTM.ALPSCTM_UDEVHJS_EQMVMT.IBMMQ.TRANSFERTYPE");
		String channel = SubSystemConfigFactory.get("CTM.ALPSCTM_UDEVHJS_EQMVMT.IBMMQ.CHANNEL");
		String factory = SubSystemConfigFactory.get("CTM.ALPSCTM_UDEVHJS_EQMVMT.IBMMQ.FACTORY");
		String queue = SubSystemConfigFactory.get("CTM.ALPSCTM_UDEVHJS_EQMVMT.IBMMQ.QUEUE");
		String targetclient = SubSystemConfigFactory.get("CTM.ALPSCTM_UDEVHJS_EQMVMT.IBMMQ.TARGETCLIENT");
/*
			CTM.ALPSCTM_UDEVHJS_EQMVMT.IBMMQ.URL = 203.246.142.42:7001
			CTM.ALPSCTM_UDEVHJS_EQMVMT.IBMMQ.TRANSFERTYPE=MQJMS_TP_CLIENT_MQ_TCPIP
			CTM.ALPSCTM_UDEVHJS_EQMVMT.IBMMQ.CHANNEL=WEBCHL  
			CTM.ALPSCTM_UDEVHJS_EQMVMT.IBMMQ.FACTORY=NIS2010_T
			CTM.ALPSCTM_UDEVHJS_EQMVMT.IBMMQ.QUEUE = ALPSCTM_T_UDEVHJS_EQMVMT
			CTM.ALPSCTM_UDEVHJS_EQMVMT.IBMMQ.TARGETCLIENT=MQJMS_CLIENT_NONJMS_MQ
*/

		TransferEAI eai = new IBMSendQClient(target, this.getClass());
		eai.setTransferType(transfertype);
		eai.setChannel(channel);
		eai.setFactory(factory);
		eai.setQueue(queue);
		eai.setTargetClient(targetclient);
		eai.setMessage(flatFile);

		String reString = "";
		try {
			reString = eai.commit(integrationId); // <== EAI SEND QUEUE 방식에 따른
			log.info("\n\n#####################################" +
					 "\nEDI 전송결과 : " + reString +
					 "\n#####################################\n");
		} catch (EAIException ex) {
			eai.rollback(ex);
			log.error("\n\n [EAIDAO - sendEdiContainerMovementdo] EAIException :\n" + ex.getMessage(), ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		} 
		eai.close();
		return reString;
	}
}
