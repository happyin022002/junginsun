/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315SendEAIDAO.java
*@FileTitle :Edi315SendEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-19
*@LastModifier : 전병석
*@LastVersion :
* 2009-10-01 전병석 
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;

/**
 * SCE에 대한 MQ 처리를 담당<br>
 * 
 * @author YJLEE
 * @see Edi315SendBCImpl 참조
 * @since J2EE 1.4
 */
public class Edi315SendEAIDAO extends EAIDAOSupport{
	
    /** 
     * EDI 전송을 위해 저장되어진 Flat file의 내용을 MQ를 통해 eSVC로 전송한다.
     * 
     * Live Queue : ALPSSCE_UBIZHJS_315
     * Test Queue : ALPSSCE_T_UDEVHJS_315
     * @param str String
     * @return String
     * @throws Exception 
     */
    public String sendEDIMQ(String str) throws Exception 
    {
		String reString = "" ; 
		/* System properties : classpath/properties/subsystem-config.properties */
		String target       =  SubSystemConfigFactory.get("SCE.ALPSSCE_T_UDEVHJS_315.IBMMQ.URL");
		String transfertype =  SubSystemConfigFactory.get("SCE.ALPSSCE_T_UDEVHJS_315.IBMMQ.TRANSFERTYPE");
		String channel      =  SubSystemConfigFactory.get("SCE.ALPSSCE_T_UDEVHJS_315.IBMMQ.CHANNEL");
		String factory      =  SubSystemConfigFactory.get("SCE.ALPSSCE_T_UDEVHJS_315.IBMMQ.FACTORY");
		String queue        =  SubSystemConfigFactory.get("SCE.ALPSSCE_T_UDEVHJS_315.IBMMQ.QUEUE");
		String targetclient =  SubSystemConfigFactory.get("SCE.ALPSSCE_T_UDEVHJS_315.IBMMQ.TARGETCLIENT");

		TransferEAI eai = new IBMSendQClient(target, this.getClass());
			        eai.setTransferType(transfertype);
			        eai.setChannel(channel);
			        eai.setFactory(factory); 
			        eai.setQueue(queue); 
			        eai.setTargetClient(targetclient);
			        eai.setMessage(str);
	      log.debug("\n >> EAI Information : " + eai.getEaiInfo() );
	        try {
	        	reString = eai.commit("SCE315"+ (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date())); //<== EAI SEND QUEUE 방식에 따른 연동 ID부여를 준용한다.
	                log.debug("\n >> EAI reString(MQ) : " + reString );
	        } catch (EAIException e) {
	        	eai.rollback(e);
	        	log.error("err  " + e.getMessage());
	            throw new Exception("EAI Exception !" + e.getMessage()  );
	        }
	        eai.close();
	        
	        return reString;
    }
}
