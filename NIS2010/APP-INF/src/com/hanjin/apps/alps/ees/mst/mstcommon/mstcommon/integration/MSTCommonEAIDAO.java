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
package com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.integration;

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
public class MSTCommonEAIDAO extends EAIDAOSupport {

	/**
	 * Daily 장비에 생성,삭제,변경에 대한 정보를 EDI로 Fleet 측에 송신한다.<br>
	 * 
	 * @param  String flatFile
	 * @return String
	 * @exception EAIException
	 * @throws Exception
	 */
	public String sendEdiToFleet(String flatFile) throws Exception {
		String integrationId = "MST_MST_FLEET" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
		//LIVE
		String target = SubSystemConfigFactory.get("MST.ALPSMST_UBIZ2HJS_FLEET.IBMMQ.URL");
		String transfertype = SubSystemConfigFactory.get("MST.ALPSMST_UBIZ2HJS_FLEET.IBMMQ.TRANSFERTYPE");
		String channel = SubSystemConfigFactory.get("MST.ALPSMST_UBIZ2HJS_FLEET.IBMMQ.CHANNEL");
		String factory = SubSystemConfigFactory.get("MST.ALPSMST_UBIZ2HJS_FLEET.IBMMQ.FACTORY");
		String queue = SubSystemConfigFactory.get("MST.ALPSMST_UBIZ2HJS_FLEET.IBMMQ.QUEUE");
		String targetclient = SubSystemConfigFactory.get("MST.ALPSMST_UBIZ2HJS_FLEET.IBMMQ.TARGETCLIENT");
		
		//TEST
//		String target = SubSystemConfigFactory.get("MST.ALPSMST_T_UDEVHJS_FLEET.IBMMQ.URL");
//		String transfertype = SubSystemConfigFactory.get("MST.ALPSMST_T_UDEVHJS_FLEET.IBMMQ.TRANSFERTYPE");
//		String channel = SubSystemConfigFactory.get("MST.ALPSMST_T_UDEVHJS_FLEET.IBMMQ.CHANNEL");
//		String factory = SubSystemConfigFactory.get("MST.ALPSMST_T_UDEVHJS_FLEET.IBMMQ.FACTORY");
//		String queue = SubSystemConfigFactory.get("MST.ALPSMST_T_UDEVHJS_FLEET.IBMMQ.QUEUE");
//		String targetclient = SubSystemConfigFactory.get("MST.ALPSMST_T_UDEVHJS_FLEET.IBMMQ.TARGETCLIENT");
		
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
