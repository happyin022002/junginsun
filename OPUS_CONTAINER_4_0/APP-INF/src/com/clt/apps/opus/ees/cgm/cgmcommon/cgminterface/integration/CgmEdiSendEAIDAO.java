/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CgmEdiSendEAIDAO.java
*@FileTitle : CgmEdiSendEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : P.K.S
*@LastVersion : 1.0
* 2014.11.25 P.K.S
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgminterface.integration;

import java.text.SimpleDateFormat;
import java.util.Date;


import com.clt.apps.opus.ees.cgm.cgmcommon.cgminterface.vo.ChassisShipMentFlatFileVO;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;


/**
 * COM CgmEdiSendEAIDAO <br>
 * EDI system Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author P.K.S
 * @see CgmEdiInterfaceMgtBC 참조
 * @since J2EE 1.6
 */
public class CgmEdiSendEAIDAO extends EAIDAOSupport{

	/**
	 * CHASSIS SHIPMENT 정보를 EDI에 송신 한다.<br>
	 * 
	 * @param ChassisShipMentFlatFileVO chassisShipMentFlatFileVO
	 * @return String
	 * @throws 
	 */ 
	public String sendEDIData(ChassisShipMentFlatFileVO chassisShipMentFlatFileVO) throws Exception {
		TransferEAI eai = null;
		String reString = "";
		try {
			String integrationId = "CGM" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
			
			/* System properties : classpath/properties/subsystem-config.properties */
			String target = SubSystemConfigFactory.get("CGM.OPUSCGM_UBIZCOM_CHS_SHIPMENT.IBMMQ.URL");
			String transfertype = SubSystemConfigFactory.get("CGM.OPUSCGM_UBIZCOM_CHS_SHIPMENT.IBMMQ.TRANSFERTYPE");
			String channel = SubSystemConfigFactory.get("CGM.OPUSCGM_UBIZCOM_CHS_SHIPMENT.IBMMQ.CHANNEL");
			String factory = SubSystemConfigFactory.get("CGM.OPUSCGM_UBIZCOM_CHS_SHIPMENT.IBMMQ.FACTORY");
			String queue = SubSystemConfigFactory.get("CGM.OPUSCGM_UBIZCOM_CHS_SHIPMENT.IBMMQ.QUEUE");  				// sendFlatFileVO.getQueueNm();
			String targetclient = SubSystemConfigFactory.get("CGM.OPUSCGM_UBIZCOM_CHS_SHIPMENT.IBMMQ.TARGETCLIENT");
			
			eai = new IBMSendQClient(target, this.getClass());
			
			eai.setTransferType(transfertype);
			eai.setChannel(channel);
			eai.setFactory(factory);
			eai.setQueue(queue);
			eai.setTargetClient(targetclient);
			eai.setMessage(chassisShipMentFlatFileVO.getFlatFile());
			
			reString = eai.commit(integrationId); // <== EAI SEND QUEUE 방식에 따른
			log.info("======================================");
			log.info("reString : " + reString);
			log.info("======================================");		
			if ( reString.equals("SUCCESS") )
				reString = integrationId;		
			else	
				reString = integrationId;	
				
		} catch (EAIException e) {
			eai.rollback(e);
		    log.error("EAIException : " + e.getMessage(),e);
	        throw new DAOException(e.getMessage());
		} catch (Exception e) {
			eai.rollback(e);
			log.error("Exception : " + e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}finally{
			eai.close();
		}
		return reString;
	}
}
