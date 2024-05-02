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
package com.clt.apps.opus.ees.mst.mstcommon.mstcommon.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
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
public class MSTCommonEAIDAO extends EAIDAOSupport {

	/**
	 * Daily informatin EDI Fleet send.<br>
	 * 
	 * @param  String flatFile
	 * @return String
	 * @exception EAIException
	 * @throws Exception
	 */
	public String sendEdiToFleet(String flatFile) throws Exception {
		String reString = "";
		/* 사용안함
		String integrationId = "MST_MST_FLEET" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
		//LIVE
		String target = SubSystemConfigFactory.get("MST.OPUSMST_UBIZCOM_FLEET.IBMMQ.URL");
		String transfertype = SubSystemConfigFactory.get("MST.OPUSMST_UBIZCOM_FLEET.IBMMQ.TRANSFERTYPE");
		String channel = SubSystemConfigFactory.get("MST.OPUSMST_UBIZCOM_FLEET.IBMMQ.CHANNEL");
		String factory = SubSystemConfigFactory.get("MST.OPUSMST_UBIZCOM_FLEET.IBMMQ.FACTORY");
		String queue = SubSystemConfigFactory.get("MST.OPUSMST_UBIZCOM_FLEET.IBMMQ.QUEUE");
		String targetclient = SubSystemConfigFactory.get("MST.OPUSMST_UBIZCOM_FLEET.IBMMQ.TARGETCLIENT");
		
		
		TransferEAI eai = new IBMSendQClient(target, this.getClass()); 
		eai.setTransferType(transfertype);
		eai.setChannel(channel);
		eai.setFactory(factory);
		eai.setQueue(queue);
		eai.setTargetClient(targetclient);
		eai.setMessage(flatFile);
		
		try {
			reString = eai.commit(integrationId); // <== EAI SEND QUEUE 
			log.info("\n\n#####################################" +
					 "\nEDI Send Result : " + reString +
					 "\n#####################################\n");
		} catch (EAIException ex) {
			eai.rollback(ex);
			log.error("\n\n [EAIDAO - sendEdiContainerMovementdo] EAIException :\n" + ex.getMessage(), ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		} 
		eai.close();
		*/
		return reString;
		
	}
	
	
	
	
	/**
	 * Equipment Fleet Info EDI send.<br>
	 * 
	 * @param  String flatFile
	 * @return String
	 * @exception EAIException
	 * @throws Exception
	 */ 
	public String sendEquipmentFleetInfo(String flatFile) throws Exception {
		String integrationId = "B003_EQUIPMENT_FLEET" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
		//LIVE
		String target = SubSystemConfigFactory.get("MST.OPUSMST_UBIZCOM_FLEET.IBMMQ.URL");
		String transfertype = SubSystemConfigFactory.get("MST.OPUSMST_UBIZCOM_FLEET.IBMMQ.TRANSFERTYPE");
		String channel = SubSystemConfigFactory.get("MST.OPUSMST_UBIZCOM_FLEET.IBMMQ.CHANNEL");
		String factory = SubSystemConfigFactory.get("MST.OPUSMST_UBIZCOM_FLEET.IBMMQ.FACTORY");
		String queue = SubSystemConfigFactory.get("MST.OPUSMST_UBIZCOM_FLEET.IBMMQ.QUEUE");
		String targetclient = SubSystemConfigFactory.get("MST.OPUSMST_UBIZCOM_FLEET.IBMMQ.TARGETCLIENT");
		
		/*String target 		= "10.82.175.72:1414";
		String transfertype = "MQJMS_TP_CLIENT_MQ_TCPIP";
		String channel 		= "CNTRCHL_T";
		String factory 		= "NYKMQ_T";
		String queue 		= "MST_T_EDI_T_FLEET";
		String targetclient = "MQJMS_CLIENT_NONJMS_MQ";
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
			reString = eai.commit(integrationId); // <== EAI SEND QUEUE 
			log.info("\n\n#####################################" +
					 "\nEDI Send Result : " + reString +
					 "\n#####################################\n");
		} catch (EAIException ex) {
			eai.rollback(ex);
			log.error("\n\n [EAIDAO - sendEquipmentFleetInfo] EAIException :\n" + ex.getMessage(), ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		} 
		eai.close();
		return reString;
	}
}
