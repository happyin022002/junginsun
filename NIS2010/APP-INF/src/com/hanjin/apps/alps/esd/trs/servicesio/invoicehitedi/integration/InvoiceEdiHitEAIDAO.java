/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceEdiHitEAIDAO.java
*@FileTitle :InvoiceEdiHitEAIDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-30
*@LastModifier : SHIN DONG IL
*@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;

/**
 * TRS에 대한 MQ 처리를 담당<br>
 * 
 * @author SHIN DONG IL
 * @see InvoiceEdiHitBCImpl 참조
 * @since J2EE 1.6
 */
public class InvoiceEdiHitEAIDAO extends EAIDAOSupport{
	
    /** 
     * EDI 전송을 위해 저장되어진 Flat File의 내용을 MQ를 통해 eSVC로 전송한다.
     * 
     * Live MQ : ALPSTRS_UBIZHJS_EBILL_ACK
     * Test MQ : ALPSTRS_T_UDEVHJS_EBILL_ACK
     * 
     * @param str String
     * @return String
     * @throws Exception 
     */
    public String sendEDIMQ(String str) throws Exception {
    	
		log.debug("\n ===== sendEDIMQ Start - InvoiceEdiHit InvoiceEdiHitEAIDAO ===== \n");
    	
		String retval = "" ; 
		/* System properties : classpath/properties/subsystem-config.properties */
		String target       =  SubSystemConfigFactory.get("TRS.TRS_EDI_EBILL.IBMMQ.URL");
		String transfertype =  SubSystemConfigFactory.get("TRS.TRS_EDI_EBILL.IBMMQ.TRANSFERTYPE");
		String channel      =  SubSystemConfigFactory.get("TRS.TRS_EDI_EBILL.IBMMQ.CHANNEL");
		String factory      =  SubSystemConfigFactory.get("TRS.TRS_EDI_EBILL.IBMMQ.FACTORY");
		String queue        =  SubSystemConfigFactory.get("TRS.TRS_EDI_EBILL.IBMMQ.QUEUE");
		String targetclient =  SubSystemConfigFactory.get("TRS.TRS_EDI_EBILL.IBMMQ.TARGETCLIENT");

		TransferEAI eai = null;
		
		log.debug("\n ===== target 		: "+JSPUtil.getNull(target)+"  		=====  \n");
		log.debug("\n ===== transfertype: "+JSPUtil.getNull(transfertype)+" =====  \n");
		log.debug("\n ===== channel 	: "+JSPUtil.getNull(channel)+"  	=====  \n");
		log.debug("\n ===== factory 	: "+JSPUtil.getNull(factory)+"  	=====  \n");
		log.debug("\n ===== queue 		: "+JSPUtil.getNull(queue)+"  		=====  \n");
		log.debug("\n ===== targetclient: "+JSPUtil.getNull(targetclient)+" =====  \n");		
		
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
			        retval = eai.commit("TRSEDI"+ (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));	
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
		
		log.debug("\n ===== sendEDIMQ END - InvoiceEdiHit InvoiceEdiHitEAIDAO ===== \n");
		
		return retval;
    }
}
