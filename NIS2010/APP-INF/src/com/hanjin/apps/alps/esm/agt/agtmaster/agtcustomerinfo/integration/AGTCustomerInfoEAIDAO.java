/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTCustomerInfoEAIDAO.java
*@FileTitle : Agent Commission Customer Information Managemnet
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-01
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-12-01 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.integration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.basic.AGTCustomerInfoBCImpl;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.enisEsm.EAIHeaderType;
import com.hanjin.irep.enisEsm.ESM0560001Document;
import com.hanjin.irep.enisEsm.ESM0560001Document.ESM0560001;
import com.hanjin.irep.enisEsm.ESM0560001Document.ESM0560001.DataArea.BKGDOCRefCollection;
import com.hanjin.irep.enisEsm.ESM0560001Document.ESM0560001.DataArea.BKGDOCRefCollection.BKGDOCRefRequest;
import com.hanjin.irep.enisEsm.ESM0560001Document.ESM0560001.DataArea.BKGDOCRefCollection.BKGDOCRefResponse;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.ws.AxDocClient;

/**
 * eNIS-agt에 대한 EAI 처리를 담당<br>
 * - eNIS-agt Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author Junghyung_kim
 * @see AGTCustomerInfoBCImpl 참조
 * @since J2EE 1.4
 */
public class AGTCustomerInfoEAIDAO extends EAIDAOSupport {

	/**
	 * Web Service 연동 / 싱크<br>
	 * (ESM_AGT_030) FAC Shipper 관계 관리의 정보를 등록,수정,삭제 후 NIS 에 Interface 한다.<br>
	 * 모든 데이타를 한번에 연동 처리한다.<br>
	 * 
	 * @param array 연동 데이타 ArrayList
	 * @throws DAOException
	 */
	public void multiFACCustomerToShipperInterestInfoInf( ArrayList array ) throws DAOException {

		log.debug("\n\n ESM056 EAI 연동 -----------start------------ \n\n");

//		 2007. 05. 01. Hyunsu modified 
		TransferEAI eai 						= null;
		
		try {

			String target = SubSystemConfigFactory.get("AGT.ESM056.WSDL");
			
            String result							= "";
            String resString						= "";
//   		 2007. 05. 01. Hyunsu modified 
//            TransferEAI eai 						= null;
            ESM0560001Document docReq				= null;
            ESM0560001Document docRes				= null;
            ESM0560001 esm0560001					= null;
            EAIHeaderType headerType				= null;
            BKGDOCRefCollection bkgdocrefCollection = null;
            BKGDOCRefRequest bkgdocrefReq			= null;
            BKGDOCRefResponse[] bkgdocrefRes		= null;
            HashMap map 							= null;
            
            if(array != null) {

            	eai = new AxDocClient(target, this.getClass());
            	
            	// Request (연동 할 데이타를 XML형식의 데이타셋으로 만든다.) -------start-------
	            docReq = ESM0560001Document.Factory.newInstance();
	            esm0560001 = docReq.addNewESM0560001();
	            headerType = esm0560001.addNewEAIHeader();
	            EAIHeaderType.Parameters params = headerType.addNewParameters();
	            EAIHeaderType.Parameters.Parameter param = params.addNewParameter();
	            headerType.setInstanceId("ESM056-0001" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
	            param.setStringValue("ESM056-0001--Header");

	            // 새로운 Collection을 추가한다.
	            bkgdocrefCollection = esm0560001.addNewDataArea().addNewBKGDOCRefCollection(); 
	            
				Iterator it = array.iterator();

				Calendar cal	= Calendar.getInstance();
		        long time1		= cal.getTimeInMillis();
		        
				// Loop를 돌면서 데이타를 뽑아온다.
				while (it.hasNext()) {

					map = (HashMap)it.next();
     
					bkgdocrefReq = bkgdocrefCollection.addNewBKGDOCRefRequest();
					setBKGDOCRefRequest(map, bkgdocrefReq);
				}
		        
				// XML형식의 데이타셋으로 만든다.
				eai.setObj(docReq);
				// Request (연동 할 데이타를 XML형식의 데이타셋으로 만든다.) -------end-------

				// Invoke
	            log.debug("===========> INVOKE ================>\n");
//	   		 2007. 05. 01. Hyunsu modified 
				resString = eai.commit(headerType.getInstanceId());

	            // Response (연동 후 결과값을 받는다.) -------start-------
				docRes = ESM0560001Document.Factory.parse( resString );
	            esm0560001 = docRes.getESM0560001();
	            bkgdocrefCollection = esm0560001.getDataArea().getBKGDOCRefCollection();
	            bkgdocrefRes = bkgdocrefCollection.getBKGDOCRefResponseArray();

				for(int i=0; bkgdocrefRes!=null && i<bkgdocrefRes.length; i++){
					result = bkgdocrefRes[i].getEAIRESULT();
				}
				// 연동 후 결과값을 받는다. -------end-------
				
				// Result 확인 후 Exception 발생시 Exception 처리한다.
				if((result.toUpperCase()).equals("OK")) {
					log.info("\n\n ESM056 EAI Interface success");
				} else {
					log.error("\n\n ESM056 EAI Interface fail :: \n" + result);
					throw new DAOException(result);
				}
				
		        cal	= Calendar.getInstance();
		        long time2 = cal.getTimeInMillis();
		        long time3 = time2 - time1;
		        
		        log.debug("\n 처리 시간 millisecond :: " + time3);
		        log.debug("\n 처리 시간 분 :: " + time3/1000/60 + " 분" + (time3/1000)%60 + " 초 : " + time3%1000);				
            }

            log.debug("\n\n ESM056 -----------end------------ \n\n");

		} catch (EAIException e) {
//	   		 2007. 05. 01. Hyunsu modified 
			eai.rollback(e);
			
        	log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
		} catch (Exception e) {
//	   		 2007. 05. 01. Hyunsu modified 
			eai.rollback(e);
			
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
//  		 2007. 05. 01. Hyunsu modified 
		eai.close();
		
	}

	/**
	 * EAI 연동시 해당 VO에 데이타를 셋팅한다.<br>
	 * 
	 * @param map 연동 데이타를 담고 있는 HashMap
	 * @param bkgdocrefReq BKGDOCRefRequest 객체
	 * @throws Exception
	 */	
	private void setBKGDOCRefRequest( HashMap map, BKGDOCRefRequest bkgdocrefReq ) throws Exception {

		try {
			if (map != null) {

				bkgdocrefReq.setFACOFCCD((String)map.get("FACOFCCD"));
				bkgdocrefReq.setCUSTCNTCD((String)map.get("CUSTCNTCD"));
				bkgdocrefReq.setCUSTSEQ((String)map.get("CUSTSEQ"));
				bkgdocrefReq.setSHPRCNTCD((String)map.get("SHPRCNTCD"));
				bkgdocrefReq.setSHPRSEQ((String)map.get("SHPRSEQ"));
				bkgdocrefReq.setCUSTNM((String)map.get("CUSTNM"));					
				bkgdocrefReq.setSHPRNM((String)map.get("SHPRNM"));
				bkgdocrefReq.setCREUSRID((String)map.get("CREUSRID"));					
				bkgdocrefReq.setCREDT((String)map.get("CREDT"));
				bkgdocrefReq.setCUSTCNTCDOLD((String)map.get("CUSTCNTCDOLD"));
				bkgdocrefReq.setCUSTSEQOLD((String)map.get("CUSTSEQOLD"));
				bkgdocrefReq.setSHPRCNTCDOLD((String)map.get("SHPRCNTCDOLD"));
				bkgdocrefReq.setSHPRSEQOLD((String)map.get("SHPRSEQOLD"));
				bkgdocrefReq.setOPCD((String)map.get("OPCD"));
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw e;
		}
	}
}