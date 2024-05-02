/*=========================================================
*Copyright(c) 2009 EDIMgtEAIDAO
*@FileName : EDIMgtEAIDAO.java
*@FileTitle : UI_BKG-0017
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.04.21 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;

/**
 * ALPS EDIMgtEAIDAO <br>
 * - ALPS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author KIM SEUNG MIN
 * @see EDIMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class BookingUtilEAIDAO extends EAIDAOSupport {
    /**
     *  Manifest Transmit 공통 함수
     * @author 	Kim Seung Min  
     * @param 	SendFlatFileVO sendFlatFileVO
     * @return	FlatFileAckVO flatFileAckVO
     * @throws Exception
	 * @throws DAOException
     */ 
	
	public FlatFileAckVO sendFlatFile(SendFlatFileVO sendFlatFileVO ) throws Exception {
		  String reString = "";
		  // "SUBSYSTEM_NAME + "_" + BIZ Name + "_" + Sequesnce + ... ... <<DATE>>
		  String integrationId = "BKG" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
		  /* System properties : classpath/properties/subsystem-config.properties */
		  String target = SubSystemConfigFactory.get("BKG.IBMMQ.URL");
		  String transfertype = SubSystemConfigFactory.get("BKG.IBMMQ.TRANSFERTYPE");
		  String channel = SubSystemConfigFactory.get("BKG.IBMMQ.CHANNEL");
		  String factory = SubSystemConfigFactory.get("BKG.IBMMQ.FACTORY");
		  String queue = sendFlatFileVO.getQueueNm();//SubSystemConfigFactory.get("COM.TEST.IBMMQ.SEND.QUEUE");
		  String targetclient = SubSystemConfigFactory.get("BKG.IBMMQ.TARGETCLIENT");
		  
		  TransferEAI eai = new IBMSendQClient(target, this.getClass());

		  eai.setTransferType(transfertype);
		  eai.setChannel(channel);
		  eai.setFactory(factory);
		  eai.setQueue(queue);
		  //eai.setQueue("ALPSBKG_T_NACCS_EDI_SEANACCS");
		  eai.setTargetClient(targetclient);
		  //eai.setMessage("hello!!!");
		  eai.setMessage(sendFlatFileVO.getFlatFile());

		  //  eai.setObj(doc);
		  //  eai.setObj(doc);
		  
		  FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
		  flatFileAckVO.setSendId(integrationId); 

		  try {
		   reString = eai.commit(integrationId); // <== EAI SEND QUEUE 방식에 따른

		   log.info("======================================");
		   log.info("reString : " + reString);
		   log.info("======================================");   
		   if ( reString.equals("SUCCESS") )
		    flatFileAckVO.setAckStsCd("A");
		   else
		    flatFileAckVO.setAckStsCd("E");
		        } catch (Exception ea) {
		         eai.rollback(ea);
		   log.error(ea.getMessage(), ea);
		   throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
		        }
		  eai.close();
		  return flatFileAckVO;
	}
}
	
	