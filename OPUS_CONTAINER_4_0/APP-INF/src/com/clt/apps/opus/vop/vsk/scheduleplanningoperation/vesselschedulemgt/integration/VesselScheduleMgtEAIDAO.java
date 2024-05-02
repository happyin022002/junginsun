/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtEAIDAO.java
*@FileTitle : VesselScheduleMgtEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : Jeong Myounghun
*@LastVersion : 1.0
* 2009.06.22 Jeong Myounghun
* 1.0 Creation
* 
* History
* 2010.10.28 CHM-201006456-01 유혁 SKD Auto Update 기능 보완
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.integration.DAOException;
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
public class VesselScheduleMgtEAIDAO extends EAIDAOSupport {
	/**
	 * EDI : OPUSVSK_UBIZCOM_VENDOR_VSK
	 * 부산(KRPUS) 터미널에서 Costal Schedule 변경 내역, Berth Window 정보를 KL-Net, 신항만('KRPUSHN') 쪽에 EDI로 전송 한다.<br>
	 * 
	 * @param String queueName
	 * @param String flatFile
	 * @return String
	 * @exception EAIException
	 */
	public String sendEdiVslSkdCstSkdBerthWdo(String queueName, String flatFile) throws DAOException {
		
		TransferEAI eai = null;
		String reString = "";
		
		try{
			String integrationId = "VSK.OPUSVSK_UBIZCOM_VENDOR_VSK" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
	
			/* System properties : classpath/properties/subsystem-config.properties */
			String target = SubSystemConfigFactory.get("VSK.OPUSVSK_UBIZCOM_VENDOR_VSK.IBMMQ.URL");
			String transfertype = SubSystemConfigFactory.get("VSK.OPUSVSK_UBIZCOM_VENDOR_VSK.IBMMQ.TRANSFERTYPE");
			String channel = SubSystemConfigFactory.get("VSK.OPUSVSK_UBIZCOM_VENDOR_VSK.IBMMQ.CHANNEL");
			String factory = SubSystemConfigFactory.get("VSK.OPUSVSK_UBIZCOM_VENDOR_VSK.IBMMQ.FACTORY");
			String queue = queueName;//SubSystemConfigFactory.get("BKG.IBMMQ.QUEUE");
			String targetclient = SubSystemConfigFactory.get("VSK.OPUSVSK_UBIZCOM_VENDOR_VSK.IBMMQ.TARGETCLIENT");
	
			eai = new IBMSendQClient(target, this.getClass());
			eai.setTransferType(transfertype);
			eai.setChannel(channel);
			eai.setFactory(factory);
			eai.setQueue(queue);
			eai.setTargetClient(targetclient);
			eai.setMessage(flatFile);

			reString = eai.commit(integrationId); // <== EAI SEND QUEUE 방식에 따른
			log.info("#####################################");
			log.info("EDI 전송결과 : " + reString);
			log.info("#####################################");
			
			return reString;
		} catch (EAIException ea) {
			if(eai!=null){
				eai.rollback(ea);
			}
			log.error(ea.getMessage(), ea);
			throw new DAOException(new ErrorHandler(ea).getMessage(), ea);
		} catch (Exception e) {
			if(eai!=null){
				eai.rollback(e);
			}
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		} finally {
			eai.close();	
		}
	}
}
