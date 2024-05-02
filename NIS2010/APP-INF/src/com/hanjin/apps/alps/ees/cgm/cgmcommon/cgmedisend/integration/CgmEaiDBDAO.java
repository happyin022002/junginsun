/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CgmEaiDBDAO.java
*@FileTitle : CgmEai
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 두기민
*@LastVersion : 1.0
* 2016.07.18 두기민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration; 

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.basic.CgmEdiSendBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;

/**
 * ALPS CgmEaiDBDAO <br>
 * - ALPS-CgmCommon system Business Logic Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author  DOO KI MIN
 * @see CgmEdiSendBCImpl 참조
 * @since J2EE 1.6
 */
public class CgmEaiDBDAO extends EAIDAOSupport{


	/**
	 * This method sends EDI
	 * 
	 * @param  String flatFile
	 * @return String
	 * @exception EAIException
	 * @throws Exception
	 */
	public String sendEdi(String flatFile) throws Exception {
		String integrationId = "CGM.ALPSCGM_UBIZ2HJS_CHSS" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
		//LIVE
		String target = SubSystemConfigFactory.get("CGM.ALPSCGM_UBIZ2HJS_CHSS.IBMMQ.URL");
		String transfertype = SubSystemConfigFactory.get("CGM.ALPSCGM_UBIZ2HJS_CHSS.IBMMQ.TRANSFERTYPE");
		String channel = SubSystemConfigFactory.get("CGM.ALPSCGM_UBIZ2HJS_CHSS.IBMMQ.CHANNEL");
		String factory = SubSystemConfigFactory.get("CGM.ALPSCGM_UBIZ2HJS_CHSS.IBMMQ.FACTORY");
		String queue = SubSystemConfigFactory.get("CGM.ALPSCGM_UBIZ2HJS_CHSS.IBMMQ.QUEUE");
		String targetclient = SubSystemConfigFactory.get("CGM.ALPSCGM_UBIZ2HJS_CHSS.IBMMQ.TARGETCLIENT");
		
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
			log.debug("\n\n#####################################" +
					 "\nEDI 전송결과 : " + reString +
					 "\n#####################################\n");
		} catch (Exception ex) {
			eai.rollback(ex);
			log.error("\n\n [EAIDAO - sendEdi] EAIException :\n" + ex.getMessage(), ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		} 
		eai.close();
		return reString;
	}

}
