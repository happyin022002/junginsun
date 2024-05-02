/*=========================================================
*Copyright(c) 2014 EDIMgtEAIDAO
*@FileName : ScgUtilEAIDAO.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.20
*@LastModifier : dongsoo
*@LastVersion : 1.0
* 2014.11.20 dongsoo
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scgutileai.integration;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.FlatFileAckVO;
import com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo.SendFlatFileVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration.SendEdiFromParnterLinesMgtDBDAOSearchCntrSequenceRSQL;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;

/**
 *  EDIMgtEAIDAO <br>
 * - CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author
 * @see EDIMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class ScgUtilEAIDAO extends EAIDAOSupport {
    /**
     *  Manifest Transmit 공통 함수
     * @author  
     * @param 	SendFlatFileVO sendFlatFileVO
     * @return	FlatFileAckVO flatFileAckVO
     * @throws Exception
	 * @throws DAOException
     */ 
	
	public FlatFileAckVO sendFlatFile(SendFlatFileVO sendFlatFileVO ) throws Exception {
		  
		String reString = "";
		
		String integrationId = "SCG" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
		
		String target        = sendFlatFileVO.getTarget();
		String transfertype  = sendFlatFileVO.getTransferType();
		String channel       = sendFlatFileVO.getChannel();
		String factory       = sendFlatFileVO.getFactory();
		String queue         = sendFlatFileVO.getQueueNm();
		String targetclient  = sendFlatFileVO.getTargetClient();
		
		TransferEAI eai = new IBMSendQClient(target, this.getClass());

		eai.setTransferType(transfertype);
		eai.setChannel(channel);
		eai.setFactory(factory);
		eai.setQueue(queue);
		eai.setTargetClient(targetclient);
		eai.setMessage(sendFlatFileVO.getFlatFile());
		
		FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
		flatFileAckVO.setSendId(integrationId); 

		try {
			reString = eai.commit(integrationId); // <== EAI SEND QUEUE 방식에 따른

			log.info("======================================");
			log.info("reString : " + reString);
			log.info("======================================");   
			if ( reString.equals("SUCCESS") )
				flatFileAckVO.setAckStsCd("S");
			else
				flatFileAckVO.setAckStsCd("F");
		} catch (Exception ea) {
			eai.rollback(ea);
		    log.error(ea.getMessage(), ea);
			throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
		}
		eai.close();
		return flatFileAckVO;
	}
}
	
	