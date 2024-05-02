/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOBasicRegisterEAIDAO.java
*@FileTitle : Revenue Port Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.22 최우석
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.basic.TCharterIOBasicRegisterBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.ReceiveRevenuePortVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.enisEsm.EAIHeaderType;
import com.hanjin.irep.enisEsm.ESM0640001INDocument;
import com.hanjin.irep.enisEsm.ESM0640001OUTDocument;
import com.hanjin.irep.enisEsm.ESM0640001INDocument.ESM0640001IN;
import com.hanjin.irep.enisEsm.ESM0640001OUTDocument.ESM0640001OUT;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.ws.AxDocClient;

/**
 * ALPS TCharterIOBasicRegisterEAIDAO <br>
 * - ALPS-TimeCharterInOutAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Choi Woo-Seok
 * @see TCharterIOBasicRegisterBCImpl 참조
 * @since J2EE 1.5
 */

public class TCharterIOBasicRegisterEAIDAO extends EAIDAOSupport {

	private transient Logger log = Logger.getLogger(TCharterIOBasicRegisterEAIDAO.class.getName());
	
	/**
	 * ERP 에서 Revenue Port 자료 정보를 가지고 온다<br>
	 * 
	 * @return List<ReceiveRevenuePortVO>
	 * @throws Exception
	 */
	public List<ReceiveRevenuePortVO> receiveRevenuePort() throws Exception {

		List<ReceiveRevenuePortVO> receiveRevenuePortVO = new ArrayList<ReceiveRevenuePortVO>();
		String target = SubSystemConfigFactory.get("FMS.ESM0640001.WSDL");

		try {
			ESM0640001INDocument sendDoc = ESM0640001INDocument.Factory.newInstance();
			ESM0640001IN sendEsm0640001 = ESM0640001IN.Factory.newInstance();

			// Set Header
			EAIHeaderType headerType = sendEsm0640001.addNewEAIHeader();
			headerType.setInstanceId("ESM064_0001" + (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));

			// Request Xml
			ESM0640001IN.DataArea sendDataArea = sendEsm0640001.addNewDataArea();
			ESM0640001IN.DataArea.RevPortInfoCollection revPortInfoCollection = sendDataArea.addNewRevPortInfoCollection();
			revPortInfoCollection.setLIFID("ESM064_0001");
			sendDoc.setESM0640001IN(sendEsm0640001);
			TransferEAI transferEAI = new AxDocClient(target, this.getClass());
			transferEAI.setMessage(sendDoc.toString());
			String strXml = transferEAI.commit(headerType.getInstanceId());

			// Response Xml
			ESM0640001OUTDocument recvDoc = ESM0640001OUTDocument.Factory.parse(strXml);
			ESM0640001OUT recvEsm0640001 = recvDoc.getESM0640001OUT();
			ESM0640001OUT.DataArea recvDataArea = recvEsm0640001.getDataArea();
			ESM0640001OUT.DataArea.RevPortInfoCollectionResponse revPortInfoCollectionResponse = recvDataArea.getRevPortInfoCollectionResponse();
			ESM0640001OUT.DataArea.RevPortInfoCollectionResponse.RevPortCollection revPortCollection = revPortInfoCollectionResponse.getRevPortCollection();
			ESM0640001OUT.DataArea.RevPortInfoCollectionResponse.RevPortCollection.RevPort[] revPort = revPortCollection.getRevPortArray();

			for(int i = 0; i < revPort.length; i++) {
				ReceiveRevenuePortVO data = new ReceiveRevenuePortVO();
				data.setSlanCd(revPort[i].getSLANCD());
				data.setRlaneCd(revPort[i].getRLANECD());
				data.setSkdDirCd(revPort[i].getSKDDIRCD());
				data.setRevDirCd(revPort[i].getREVDIRCD());
				data.setFletIocCd(revPort[i].getIOCCD());
				data.setStPortCd(revPort[i].getSTPORTCD());
				data.setFnlPortCd(revPort[i].getFNLPORTCD());
				receiveRevenuePortVO.add(data);
			}

			transferEAI.close();
			
		} catch (XmlException xe) {
			log.error(xe.getMessage());
			throw new Exception(new ErrorHandler(xe).getMessage(), xe);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return receiveRevenuePortVO;
	}
}

