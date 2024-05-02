/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TESeBillingAckManageEAIDAO.java
*@FileTitle :TESeBillingAckManageEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2013-01-22
*@LastModifier : yoo
*@LastVersion :
* 2013-01-22 yoo 
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;

/**
 * TES에 대한 MQ 처리를 담당<br>
 * 
 * @author YJLEE
 * @see Edi315SendBCImpl 참조
 * @since J2EE 1.4
 */
public class TESeBillingAckManageEAIDAO extends EAIDAOSupport{
	
    /** 
     * EDI 전송을 위해 저장되어진 Flat File의 내용을 MQ를 통해 eSVC로 전송한다.
     * 
     * Live Queue : ALPSTES_UBIZHJS_EDI
     * Test Queue : ALPSTES_T_UDEVHJS_EDI
     * 
     * @param str String
     * @return String
     * @throws Exception 
     */
    public String sendEDIMQ(String str) throws Exception {
    	
    	log.debug("\n BBBB - TESeBillingAckManageEAIDAO - sendEDIMQ ~~~~~ \n");
    	
		String retval = "" ; 
		/* System properties : classpath/properties/subsystem-config.properties */
		String target       =  SubSystemConfigFactory.get("TES.ALPSTES_UBIZHJS_EDI.IBMMQ.URL");
		String transfertype =  SubSystemConfigFactory.get("TES.ALPSTES_UBIZHJS_EDI.IBMMQ.TRANSFERTYPE");
		String channel      =  SubSystemConfigFactory.get("TES.ALPSTES_UBIZHJS_EDI.IBMMQ.CHANNEL");
		String factory      =  SubSystemConfigFactory.get("TES.ALPSTES_UBIZHJS_EDI.IBMMQ.FACTORY");
		String queue        =  SubSystemConfigFactory.get("TES.ALPSTES_UBIZHJS_EDI.IBMMQ.QUEUE");
		String targetclient =  SubSystemConfigFactory.get("TES.ALPSTES_UBIZHJS_EDI.IBMMQ.TARGETCLIENT");

		TransferEAI eai = null;
		
		log.debug("\n target:"+JSPUtil.getNull(target)+" ~~~~~~~ \n");
		log.debug("\n queue:"+JSPUtil.getNull(queue)+" ~~~~~~~ \n");
		
		try {
			if (target!=null){
				eai = new IBMSendQClient(target, this.getClass());
				if (eai!=null){
			        eai.setTransferType(JSPUtil.getNull(transfertype));
			        eai.setChannel(JSPUtil.getNull(channel));
			        eai.setFactory(JSPUtil.getNull(factory)); 
			        eai.setQueue(JSPUtil.getNull(queue)); 
			        eai.setTargetClient(JSPUtil.getNull(targetclient));
			        eai.setMessage(JSPUtil.getNull(str));
			        log.debug("\n >> EAI Information : " + eai.getEaiInfo() );
			        retval = eai.commit("TESEDI"+ (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));	
				} else {
					log.error("\n\n EAI INITIALIZING FAILURE Exception (eai null!) ~~~~~~~~~~~~~~ \n\n");
					throw new Exception("EAI INITIALIZING FAILURE Exception (eai null!)");
				}
			} else {
				log.error("\n\n EAI INITIALIZING FAILURE Exception (target null!) ~~~~~~~~~~~~~~ \n\n");
				throw new Exception("EAI INITIALIZING FAILURE Exception (target null!)");
			}
			log.debug("\n >> EAI reString(MQ) : " + retval );
		} catch (EAIException e) {
			if (eai!=null){
				eai.rollback(e);
			}
			log.error("err  " + e.getMessage());
			throw new Exception("EAI Exception !" + e.getMessage()  );
		} catch (Exception e) {
			if (eai!=null){
				eai.rollback(e);
			}
			log.error("err  " + e.getMessage());
			throw new Exception("EAI Exception !" + e.getMessage()  );
		} finally {
			if (eai!=null){
				eai.close();
			}
		}
		
		log.debug("\n EEEE - TESeBillingAckManageEAIDAO - sendEDIMQ ~~~~~ \n");
		
		return retval;
    }
}
