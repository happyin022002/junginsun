/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOBunkerRegisterEAIDBDAO.java
*@FileTitle : BOD, BOR Monthly Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.01
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.01 정윤태
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.basic.TCharterIOBunkerRegisterBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerInterfaceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.enisEsm.EAIHeaderType;
import com.hanjin.irep.enisEsm.ESM0630001Document;
import com.hanjin.irep.enisEsm.ESM0630001Document.ESM0630001;
import com.hanjin.irep.enisEsm.ESM0630001Document.ESM0630001.DataArea;
import com.hanjin.irep.enisEsm.ESM0630001Document.ESM0630001.DataArea.BunkerInfoCollection;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxDocClient;

/**
 * NIS2010 TCharterIOBunkerRegisterEAIDBDAO <br>
 * - NIS2010-TimeCharterInOutAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon-Tae, Jung
 * @see TCharterIOBunkerRegisterBCImpl 참조
 * @since J2EE 1.5
 */

public class TCharterIOBunkerRegisterEAIDAO extends EAIDAOSupport {

	private transient Logger log = Logger.getLogger(TCharterIOBunkerRegisterEAIDAO.class.getName());
	
	/**
	 * Bunker 테이블에서 Interface 할 데이타를 EAI서버로 전송.<br>
	 * 
	 * @param searchBunkerInterfaceVO List<SearchBunkerInterfaceVO>
	 * @throws DAOException
	 */
	public void sendBunkerData(List<SearchBunkerInterfaceVO> searchBunkerInterfaceVO)throws DAOException {

		//Request Start
		String target = SubSystemConfigFactory.get("FMS.ESM0630001.WSDL");
		this.log.info("@@WSDL Address -->["+target+"]");
		ESM0630001Document document = ESM0630001Document.Factory.newInstance();
		
		ESM0630001 esm0630001 = document.addNewESM0630001();

		//ESM0630001 esm0630001 = ESM0630001.Factory.newInstance();
		String dateTime = "ESM063_0001" + (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
		
		//Set Header
		EAIHeaderType headerType = esm0630001.addNewEAIHeader();
		headerType.setInstanceId(dateTime);
		
		//ESM0630001.DataArea dataArea = esm0630001.addNewDataArea();
		DataArea dataArea = esm0630001.addNewDataArea();
		
		String foDoFlag = "";
		
		for(int i=0; i<searchBunkerInterfaceVO.size(); i++){	
			BunkerInfoCollection bunkerInfoCollection = dataArea.addNewBunkerInfoCollection();
			
			bunkerInfoCollection.setVESSELCODE(searchBunkerInterfaceVO.get(i).getVslCd());
			bunkerInfoCollection.setREVMONTH(searchBunkerInterfaceVO.get(i).getBnkYrmon());
			bunkerInfoCollection.setPRICE(searchBunkerInterfaceVO.get(i).getBnkPrcAmt());
			
			if(   searchBunkerInterfaceVO.get(i).getAcctItmSeq().equals("33")
			   || searchBunkerInterfaceVO.get(i).getAcctItmSeq().equals("43")) {
				foDoFlag = "FO";
			} else if(   searchBunkerInterfaceVO.get(i).getAcctItmSeq().equals("34")
					  || searchBunkerInterfaceVO.get(i).getAcctItmSeq().equals("35")) {
				foDoFlag = "DO";
			}
			
			bunkerInfoCollection.setFODOFLAG(foDoFlag);
			bunkerInfoCollection.setBODBORFLAG(searchBunkerInterfaceVO.get(i).getBnkTpCd());
			bunkerInfoCollection.setAMT(searchBunkerInterfaceVO.get(i).getTotalAmt());
			bunkerInfoCollection.setVVD(searchBunkerInterfaceVO.get(i).getBunkerVvd()); 
			bunkerInfoCollection.setQTY(searchBunkerInterfaceVO.get(i).getBnkQty());
			bunkerInfoCollection.setLIFID("ESM063_0001");	
			
		}
		
		this.log.info("Request Document -->[" + document.toString()+"]");
		TransferEAI transferEAI = new AxDocClient(target, this.getClass());
		
		transferEAI.setMessage(document.toString());
		
		String transferMsg = "";
		
		try {
			transferMsg = transferEAI.commit(headerType.getInstanceId());
		} catch (EAIException ex) {
			this.log.error(ex.getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		this.log.info("Response Document -->["+ transferMsg.toString()+"]");
		
		transferEAI.close();	
	}
}

