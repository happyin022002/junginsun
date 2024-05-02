/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FACAuditEAIDAO.java
*@FileTitle : FAC AP Actual Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-30
*@LastModifier : Jung-Hyung, Kim
*@LastVersion : 1.0
* 2007-01-30 Jung-Hyung, Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.irep.enis.EAIHeaderType;
import com.hanjin.irep.enis.EAIHeaderType.Parameters;
import com.hanjin.irep.enis.EAIHeaderType.Parameters.Parameter;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.irep.enis.FNS0080003Document.FNS0080003;
import com.hanjin.irep.enis.FNS0080003Document.FNS0080003.DataArea.APInvoiceCollection;
import com.hanjin.irep.enis.FNS0080003Document.FNS0080003.DataArea.APInvoiceCollection.APInvoiceRequest;
import com.hanjin.irep.enis.FNS0080003Document.FNS0080003.DataArea.APInvoiceCollection.APInvoiceResponse;
import com.hanjin.irep.enisEsm.ESM0600001Document;
import com.hanjin.irep.enisEsm.ESM0600001Document.ESM0600001;
import com.hanjin.irep.enisEsm.ESM0600001Document.ESM0600001.DataArea.BKGFACCALCSCollection;
import com.hanjin.irep.enisEsm.ESM0600001Document.ESM0600001.DataArea.BKGFACCALCSCollection.BKGFACCALCSRequest;
import com.hanjin.irep.enisEsm.ESM0600001Document.ESM0600001.DataArea.BKGFACCALCSCollection.TuxedoResponse;
import com.jf.transfer.eai.exception.EAIException;
//import com.jf.transfer.eai.ws.TransferEAI;
//import com.jf.transfer.eai.ws.AxDocClient;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.ws.AxDocClient;

/**
 * eNIS-agt에 대한 EAI 처리를 담당<br>
 * - eNIS-agt Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author Junghyung_kim
 * @see BRKGAuditBCImpl 참조
 * @since J2EE 1.4
 */
public class FACAuditEAIDAO extends EAIDAOSupport {

	/**
	 * Web Service 연동 / 싱크<br>
	 * (ESM_AGT_034) Agent Commission 정산내역을 ERP AP로 인터페이스한다.<br>
	 * 모든 데이타를 한번에 연동 처리한다.<br>
	 * 
	 * @param rowSet 연동 데이타 DBRowSet
	 * @return HashMap 인터페이스 리턴값
	 * @throws DAOException
	 */	
	public HashMap transferAtOnceAGT034ToEAIByWS(DBRowSet rowSet) throws DAOException {
		HashMap rtnHash = null;
		String isSuccess = "N";
			
//		 2007. 05. 01. Hyunsu modified 
        TransferEAI eai = null;
		
		try {
			log.debug("\n\n WebService 연동 시작 : AGT034 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n\n");

			//변수 선언
			String target = "";
			String rtnMsg = "";
            String result = "";
            String instanceId = "";
            String timestamp  = "";
            
//   		 2007. 05. 01. Hyunsu modified 
//            TransferEAI eai = null;
            EAIHeaderType headerType = null;
            Parameters params = null;
            Parameter param = null;
            
            FNS0080003Document docReq		= null;
            FNS0080003 fNS0080003Req		= null;
            APInvoiceCollection invoiceCollReq	= null;
            APInvoiceRequest invoiceReq		= null;
            FNS0080003Document docRsp		= null;
            FNS0080003 fNS0080003Rsp		= null;
            APInvoiceCollection invoiceCollRsp	= null;
            APInvoiceResponse[] invoiceRsp	= null;
            
            
			if(rowSet != null) { 
				//Request
				log.debug("===========> REQUEST ================>\n");
				
				//InstanceId, target 설정
	            timestamp = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
	            instanceId = "FNS008-0003" + "H" + timestamp;
	            target = SubSystemConfigFactory.get("AGT.FNS0080003.WSDL");
	            eai = new AxDocClient(target, this.getClass());
		        
	            docReq = FNS0080003Document.Factory.newInstance();
	            fNS0080003Req = docReq.addNewFNS0080003();
	            headerType = fNS0080003Req.addNewEAIHeader();
	            headerType.setInstanceId(instanceId);
	            params = headerType.addNewParameters();
	            param = params.addNewParameter();
	            param.setStringValue("");
	        
	            invoiceCollReq = fNS0080003Req.addNewDataArea().addNewAPInvoiceCollection();
	            
	            while (rowSet.next()) {
	            	invoiceReq = invoiceCollReq.addNewAPInvoiceRequest();
					setInvoiceDatas(rowSet, invoiceReq, timestamp);
	            }
				
				eai.setMessage(docReq.toString());
	            
	            //Invoke
	            log.debug("===========> INVOKE ================>\n");
//	   		 2007. 05. 01. Hyunsu modified 
	            rtnMsg = eai.commit(headerType.getInstanceId());
	            
	            //Response
	            log.debug("===========> RESPONSE ================>\n");
	            docRsp = FNS0080003Document.Factory.parse(rtnMsg);
	            fNS0080003Rsp = docRsp.getFNS0080003();
				invoiceCollRsp = fNS0080003Rsp.getDataArea().getAPInvoiceCollection();
	            invoiceRsp = invoiceCollRsp.getAPInvoiceResponseArray();
				
				for(int i=0; invoiceRsp!=null && i<invoiceRsp.length; i++){
					result = invoiceRsp[i].getEAIRESULT();
					log.debug("\n EAI 연동결과 :: " + result);
				}
				
				//Result 
				if((result.toUpperCase()).equals("OK")) isSuccess = "Y";	
				
			} //if(rowSet != null) { 

			log.debug("\n\n WebService 연동 끝 : AGT034 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n\n");
			
			rtnHash = new HashMap();
			rtnHash.put("isSuccess", isSuccess);
			
//	   		 2007. 05. 01. Hyunsu modified 
//			return rtnHash;
			
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
		
		return rtnHash;
	}
	
	/**
	 * Web Service 연동 / 싱크<br>
	 * FAC Commission 수정내역을 AR로 인터페이스한다.<br>
	 * 
	 * @param array 연동 데이타 String[][]
	 * @throws DAOException
	 */	
	public void modifyEAINISFACCommInfo(String[][] array) throws DAOException {

//		 2007. 05. 01. Hyunsu modified 
      TransferEAI eai 													= null;
		
		try {
			log.debug("\n\n WebService 연동 시작 : AGT060 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n\n");

			String target = SubSystemConfigFactory.get("AGT.ESM060.WSDL");

// 		 2007. 05. 01. Hyunsu modified 
//            TransferEAI eai 													= null;
            com.hanjin.irep.enisEsm.EAIHeaderType headerType					= null;
            com.hanjin.irep.enisEsm.EAIHeaderType.Parameters params				= null;
            com.hanjin.irep.enisEsm.EAIHeaderType.Parameters.Parameter param	= null;
            
            ESM0600001 esm0600001						= null;
            ESM0600001Document docReq					= null;
            ESM0600001Document docRes					= null;

            BKGFACCALCSCollection bkgfaccalcsCollReq	= null;
            BKGFACCALCSCollection bkgfaccalcsCollRes	= null;
            BKGFACCALCSRequest bkgfaccalcsReq			= null;
            TuxedoResponse[] tuxedoRes					= null;

            String rtnMsg								= "";
            
			if(array != null) { 

            	eai = new AxDocClient(target, this.getClass());
            	
            	// Request (연동 할 데이타를 XML형식의 데이타셋으로 만든다.) -------start-------
	            docReq = ESM0600001Document.Factory.newInstance();
	            esm0600001 = docReq.addNewESM0600001();
	            headerType = esm0600001.addNewEAIHeader();
	            params = headerType.addNewParameters();
	            param = params.addNewParameter();
	            
	            headerType.setInstanceId("ESM060-0001" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
	            param.setStringValue("ESM060-0001--Header");

	            // 새로운 Collection을 추가한다.
	            bkgfaccalcsCollReq = esm0600001.addNewDataArea().addNewBKGFACCALCSCollection(); 				

				bkgfaccalcsReq = bkgfaccalcsCollReq.addNewBKGFACCALCSRequest();
				setBKGFACCALCSRequest(array, bkgfaccalcsReq);
		        
				// XML형식의 데이타셋으로 만든다.
				eai.setObj(docReq);
				//log.info("message :" + eai.getObj());

	            //Invoke
	            log.debug("===========> INVOKE ================>\n");
//	    		 2007. 05. 01. Hyunsu modified 
	            rtnMsg = eai.commit(headerType.getInstanceId());
	            
	            // Response (연동 후 결과값을 받는다.) -------start-------
	            docRes = ESM0600001Document.Factory.parse(rtnMsg);
	            esm0600001 = docRes.getESM0600001();
	            bkgfaccalcsCollRes = esm0600001.getDataArea().getBKGFACCALCSCollection();
	            tuxedoRes = bkgfaccalcsCollRes.getTuxedoResponseArray();

	            int iTpRetCode = 0;
	            int tuxedoCnt = tuxedoRes.length;
	            
	            String tpRetCode = "";
	            String tpErrno =  "";
	            String tpErrDetails = "";
	            String statlin = "";

	            if(tuxedoCnt > 0){
	            	tpRetCode = tuxedoRes[0].getTpRetCode()==null?"":tuxedoRes[0].getTpRetCode(); // SQL Error
	            	tpErrno = tuxedoRes[0].getTpErrno()==null?"":tuxedoRes[0].getTpErrno(); // Tuxedo Error
	            	tpErrDetails = tuxedoRes[0].getTpErrDetails()==null?"":tuxedoRes[0].getTpErrDetails();
	            	statlin = tuxedoRes[0].getStatlin()==null?"":tuxedoRes[0].getStatlin();          	
	            }
	            
	            if(tpRetCode.length() > 0) {
	            	iTpRetCode = Integer.parseInt(tpRetCode);
	            }
	            
//	            log.debug("\n EAI 연동결과 tuxedoCnt :: " + tuxedoCnt);
//				log.debug("\n EAI 연동결과 tpRetCode :: " + tpRetCode);
//            	log.debug("\n EAI 연동결과 tpErrno :: " + tpErrno);
//            	log.debug("\n EAI 연동결과 tpErrDetails :: " + tpErrDetails);
//            	log.debug("\n EAI 연동결과 statlin :: " + statlin);
            	
	            if( tpErrno.length() == 0 ) {	// Tuxedo Error인 경우
	            	log.error("\n\n ESM060 EAI Interface fail :: \n" + "Tuxedo timeout!");
	            	throw new DAOException("Tuxedo timeout!");	            	
	            	/*
	            	if(tpErrDetails.length() == 0) {
		            	log.error("\n\n ESM060 EAI Interface fail :: \n" + "Tuxedo timeout!");
		            	throw new DAOException("Tuxedo timeout!");
	            	} else {
		            	log.error("\n\n ESM060 EAI Interface fail :: \n" + tpErrDetails);
		            	throw new DAOException(tpErrDetails);
	            	}
	            	*/
	            } else if( tpRetCode.length() == 0 ) {	// Tuxedo Error가 아니지만 Return값이 없는 경우
	            	log.error("\n\n ESM060 EAI Interface fail :: \n" + "Connect timeout!");
	            	throw new DAOException("Connect timeout!");
	            	/*
	            	if(statlin.length() == 0) {
		            	log.error("\n\n ESM060 EAI Interface fail :: \n" + "Connect timeout!");
		            	throw new DAOException("Connect timeout!");
	            	} else {
		            	log.error("\n\n ESM060 EAI Interface fail :: \n" + statlin);
		            	throw new DAOException(statlin);
	            	}
	            	*/
	            } else {
	            	// iTpRetCode이 0이 아니면 Error임.
	            	// Booking이 존재하지 않을 경우 Error처리 한다.
		            if( iTpRetCode != 0 ) {	// SQL Error인 경우(update/delete된 건수가 0일 경우에도 Error)
		            	log.error("\n\n ESM060 EAI Interface fail :: \n" + statlin);
		            	throw new DAOException(statlin);
					} else {
						log.info("\n\n ESM060 EAI Interface success :: " + statlin);
		            }
				}
	            // 연동 후 결과값을 받는다. -------end-------
			}

			log.debug("\n\n WebService 연동 끝 : AGT060 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n\n");

		} catch (EAIException e) {
//   		 2007. 05. 01. Hyunsu modified
			eai.rollback(e);
			
        	log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
		} catch (Exception e) {
//  		 2007. 05. 01. Hyunsu modified
			eai.rollback(e);
			
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
//		 2007. 05. 01. Hyunsu modified
		eai.close();
		
	}
	
	/**
	 * EAI 연동시 해당 VO에 데이타를 셋팅한다.<br>
	 * 
	 * @param  rowSet 연동 데이타를 담고 있는 DBRowSet
	 * @param  invoiceReq APInvoiceRequest 객체
	 * @throws Exception
	 */
	private void setInvoiceDatas(DBRowSet rowSet, APInvoiceRequest invoiceReq, String timestamp) throws Exception {

		try {
			if (rowSet != null) {
				invoiceReq.setLIFID((String)rowSet.getString("LIF_ID"));
				//invoiceReq.setSEQ((String)rowSet.getString("SEQ"));
				invoiceReq.setSEQ(timestamp);
				invoiceReq.setTOTALCOUNT((String)rowSet.getString("TTL_ROW_KNT"));
				invoiceReq.setROWCOUNT((String)rowSet.getString("ROW_KNT"));
				invoiceReq.setHCSRNUMBER((String)rowSet.getString("HDR_CSR_NO"));
				invoiceReq.setHCSRTYPE((String)rowSet.getString("HDR_CSR_TP_CD"));
				invoiceReq.setHINVOICEDATE((String)rowSet.getString("HDR_INV_DT"));
				invoiceReq.setHTERMSDATE((String)rowSet.getString("HDR_INV_TERM_DT"));
				invoiceReq.setHGLDATE((String)rowSet.getString("HDR_GL_DT"));
				invoiceReq.setHVENDORNO((String)rowSet.getString("HDR_VNDR_NO"));
				invoiceReq.setHCSRAMOUNT((String)rowSet.getString("HDR_CSR_AMT"));
				invoiceReq.setHPAYMENTAMOUNT((String)rowSet.getString("HDR_PAY_AMT"));
				invoiceReq.setHPAYMENTDATE((String)rowSet.getString("HDR_PAY_DT"));
				invoiceReq.setHCSRCURRENCYCODE((String)rowSet.getString("HDR_CSR_CURR_CD"));
				invoiceReq.setHTERMSNAME((String)rowSet.getString("HDR_VNDR_TERM_NM"));
				invoiceReq.setHDESCRIPTION((String)rowSet.getString("HDR_INV_DESC"));
				invoiceReq.setHATTRIBUTECATEGORY((String)rowSet.getString("HDR_ATTR_CATE_NM"));
				invoiceReq.setHATTRIBUTE1((String)rowSet.getString("HDR_ATTR_CTNT1"));
				invoiceReq.setHATTRIBUTE2((String)rowSet.getString("HDR_ATTR_CTNT2"));
				invoiceReq.setHATTRIBUTE3((String)rowSet.getString("HDR_ATTR_CTNT3"));
				invoiceReq.setHATTRIBUTE4((String)rowSet.getString("HDR_ATTR_CTNT4"));
				invoiceReq.setHATTRIBUTE5((String)rowSet.getString("HDR_ATTR_CTNT5"));
				invoiceReq.setHATTRIBUTE6((String)rowSet.getString("HDR_ATTR_CTNT6"));
				invoiceReq.setHATTRIBUTE7((String)rowSet.getString("HDR_ATTR_CTNT7"));
				invoiceReq.setHATTRIBUTE8((String)rowSet.getString("HDR_ATTR_CTNT8"));
				invoiceReq.setHATTRIBUTE9((String)rowSet.getString("HDR_ATTR_CTNT9"));
				invoiceReq.setHATTRIBUTE10((String)rowSet.getString("HDR_ATTR_CTNT10"));
				invoiceReq.setHATTRIBUTE11((String)rowSet.getString("HDR_ATTR_CTNT11"));
				invoiceReq.setHATTRIBUTE12((String)rowSet.getString("HDR_ATTR_CTNT12"));
				invoiceReq.setHATTRIBUTE13((String)rowSet.getString("HDR_ATTR_CTNT13"));
				invoiceReq.setHATTRIBUTE14((String)rowSet.getString("HDR_ATTR_CTNT14"));
				invoiceReq.setHATTRIBUTE15((String)rowSet.getString("HDR_ATTR_CTNT15"));
				invoiceReq.setHGLOBALATTRIBUTE1((String)rowSet.getString("HDR_GLO_ATTR_CTNT1"));
				invoiceReq.setHGLOBALATTRIBUTE2((String)rowSet.getString("HDR_GLO_ATTR_CTNT2"));
				invoiceReq.setHGLOBALATTRIBUTE3((String)rowSet.getString("HDR_GLO_ATTR_CTNT3"));
				invoiceReq.setHGLOBALATTRIBUTE4((String)rowSet.getString("HDR_GLO_ATTR_CTNT4"));
				invoiceReq.setHGLOBALATTRIBUTE5((String)rowSet.getString("HDR_GLO_ATTR_CTNT5"));
				invoiceReq.setHGLOBALATTRIBUTE6((String)rowSet.getString("HDR_GLO_ATTR_CTNT6"));
				invoiceReq.setHGLOBALATTRIBUTE7((String)rowSet.getString("HDR_GLO_ATTR_CTNT7"));
				invoiceReq.setHGLOBALATTRIBUTE8((String)rowSet.getString("HDR_GLO_ATTR_CTNT8"));
				invoiceReq.setHGLOBALATTRIBUTE9((String)rowSet.getString("HDR_GLO_ATTR_CTNT9"));
				invoiceReq.setHGLOBALATTRIBUTE10((String)rowSet.getString("HDR_GLO_ATTR_CTNT10"));
				invoiceReq.setHGLOBALATTRIBUTE11((String)rowSet.getString("HDR_GLO_ATTR_CTNT11"));
				invoiceReq.setHGLOBALATTRIBUTE12((String)rowSet.getString("HDR_GLO_ATTR_CTNT12"));
				invoiceReq.setHGLOBALATTRIBUTE13((String)rowSet.getString("HDR_GLO_ATTR_CTNT13"));
				invoiceReq.setHGLOBALATTRIBUTE14((String)rowSet.getString("HDR_GLO_ATTR_CTNT14"));
				invoiceReq.setHGLOBALATTRIBUTE15((String)rowSet.getString("HDR_GLO_ATTR_CTNT15"));
				invoiceReq.setHGLOBALATTRIBUTE16((String)rowSet.getString("HDR_GLO_ATTR_CTNT16"));
				invoiceReq.setHGLOBALATTRIBUTE17((String)rowSet.getString("HDR_GLO_ATTR_CTNT17"));
				invoiceReq.setHGLOBALATTRIBUTE18((String)rowSet.getString("HDR_GLO_ATTR_CTNT18"));
				invoiceReq.setHSOURCE((String)rowSet.getString("HDR_SRC_CTNT"));
				invoiceReq.setHPAYMENTMETHODLOOKUPCODE((String)rowSet.getString("HDR_PAY_MZD_LU_CD"));
				invoiceReq.setHPAYGROUPLOOKUPCODE((String)rowSet.getString("HDR_PAY_GRP_LU_CD"));
				invoiceReq.setHACCTSCOACOMPANY((String)rowSet.getString("HDR_COA_CO_CD"));
				invoiceReq.setHACCTSCOAREGION((String)rowSet.getString("HDR_COA_RGN_CD"));
				invoiceReq.setHACCTSCOACENTER((String)rowSet.getString("HDR_COA_CTR_CD"));
				invoiceReq.setHACCTSCOAACCOUNT((String)rowSet.getString("HDR_COA_ACCT_CD"));
				invoiceReq.setHACCTSCOAVVD((String)rowSet.getString("HDR_COA_VVD_CD"));
				invoiceReq.setHACCTSCOAINTERCOMPANY((String)rowSet.getString("HDR_COA_INTER_CO_CD"));
				invoiceReq.setHACCTSCOAFUTURE1((String)rowSet.getString("HDR_COA_FTU_N1ST_CD"));
				invoiceReq.setHACCTSCOAFUTURE2((String)rowSet.getString("HDR_COA_FTU_N2ND_CD"));
				invoiceReq.setHPREPAYNUM((String)rowSet.getString("HDR_PPD_NO"));
				invoiceReq.setHPREPAYDISTNUM((String)rowSet.getString("HDR_PPD_DTRB_NO"));
				invoiceReq.setHPREPAYAPPLYAMOUNT((String)rowSet.getString("HDR_PPD_APLY_AMT"));
				invoiceReq.setHPREPAYGLDATE((String)rowSet.getString("HDR_PPD_GL_DT"));
				invoiceReq.setHAPPROVEFLAG((String)rowSet.getString("HDR_APRO_FLG"));
				invoiceReq.setHTAXFLAG((String)rowSet.getString("HDR_TAX_DECL_FLG"));
				invoiceReq.setHERRORCSRNUMBER((String)rowSet.getString("HDR_ERR_CSR_NO"));
				invoiceReq.setHINTERFACEFLAG((String)rowSet.getString("HDR_IF_FLG"));
				invoiceReq.setHINTERFACEDATE((String)rowSet.getString("HDR_IF_DT"));
				invoiceReq.setHINTERFACEERRORREASON((String)rowSet.getString("HDR_IF_ERR_RSN"));
				invoiceReq.setHPREPAYMENTAPPLYFLAG((String)rowSet.getString("HDR_PPAY_APLY_FLG"));
				invoiceReq.setHTRANSACTIONCODE((String)rowSet.getString("HDR_TJ_OFC_CD"));
				invoiceReq.setHACTUALRATE((String)rowSet.getString("HDR_ACT_XCH_RT"));
				invoiceReq.setHIMPORTERRORFLAG((String)rowSet.getString("HDR_IMP_ERR_FLG"));
				invoiceReq.setHRECEIVEERRORFLAG((String)rowSet.getString("HDR_RCV_ERR_FLG"));
				invoiceReq.setHTAXCURRENCYEXCHANGEFLAG((String)rowSet.getString("HDR_TAX_CURR_XCH_FLG"));
				invoiceReq.setHUSEREMAILID((String)rowSet.getString("HDR_USR_EML"));
				invoiceReq.setHIMPORTERRORREASON((String)rowSet.getString("HDR_IMP_ERR_RSN"));
				invoiceReq.setHRECEIVEERRORREASON((String)rowSet.getString("HDR_RCV_ERR_RSN"));
				invoiceReq.setHFUTUREUSE1((String)rowSet.getString("HDR_FTU_USE_CTNT1"));
				invoiceReq.setHFUTUREUSE2((String)rowSet.getString("HDR_FTU_USE_CTNT2"));
				invoiceReq.setHFUTUREUSE3((String)rowSet.getString("HDR_FTU_USE_CTNT3"));
				invoiceReq.setHFUTUREUSE4((String)rowSet.getString("HDR_FTU_USE_CTNT4"));
				invoiceReq.setHFUTUREUSE5((String)rowSet.getString("HDR_FTU_USE_CTNT5"));
				invoiceReq.setLCSRNUMBER((String)rowSet.getString("CSR_NO"));
				invoiceReq.setLLINESEQUENCELEGACY((String)rowSet.getString("LINE_SEQ"));
				invoiceReq.setLLINENUMBERERP((String)rowSet.getString("LINE_NO"));
				invoiceReq.setLLINETYPELOOKUPCODE((String)rowSet.getString("LINE_TP_LU_CD"));
				invoiceReq.setLAMOUNT((String)rowSet.getString("INV_AMT"));
				invoiceReq.setLDESCRIPTION((String)rowSet.getString("INV_DESC"));
				invoiceReq.setLTAXCODE((String)rowSet.getString("INV_TAX_CD"));
				invoiceReq.setLDISTCOACOMPANY((String)rowSet.getString("DTRB_COA_CO_CD"));
				invoiceReq.setLDISTCOAREGION((String)rowSet.getString("DTRB_COA_RGN_CD"));
				invoiceReq.setLDISTCOACENTER((String)rowSet.getString("DTRB_COA_CTR_CD"));
				invoiceReq.setLDISTCOAACCOUNT((String)rowSet.getString("DTRB_COA_ACCT_CD"));
				invoiceReq.setLDISTCOAVVD((String)rowSet.getString("DTRB_COA_VVD_CD"));
				invoiceReq.setLDISTCOAINTERCOMPANY((String)rowSet.getString("DTRB_COA_INTER_CO_CD"));
				invoiceReq.setLDISTCOAFUTURE1((String)rowSet.getString("DTRB_COA_FTU_N1ST_CD"));
				invoiceReq.setLDISTCOAFUTURE2((String)rowSet.getString("DTRB_COA_FTU_N2ND_CD"));
				invoiceReq.setLATTRIBUTECATEGORY((String)rowSet.getString("ATTR_CATE_NM"));
				invoiceReq.setLATTRIBUTE1((String)rowSet.getString("ATTR_CTNT1"));
				invoiceReq.setLATTRIBUTE2((String)rowSet.getString("ATTR_CTNT2"));
				invoiceReq.setLATTRIBUTE3((String)rowSet.getString("ATTR_CTNT3"));
				invoiceReq.setLATTRIBUTE4((String)rowSet.getString("ATTR_CTNT4"));
				invoiceReq.setLATTRIBUTE5((String)rowSet.getString("ATTR_CTNT5"));
				invoiceReq.setLATTRIBUTE6((String)rowSet.getString("ATTR_CTNT6"));
				invoiceReq.setLATTRIBUTE7((String)rowSet.getString("ATTR_CTNT7"));
				invoiceReq.setLATTRIBUTE8((String)rowSet.getString("ATTR_CTNT8"));
				invoiceReq.setLATTRIBUTE9((String)rowSet.getString("ATTR_CTNT9"));
				invoiceReq.setLATTRIBUTE10((String)rowSet.getString("ATTR_CTNT10"));
				invoiceReq.setLATTRIBUTE11((String)rowSet.getString("ATTR_CTNT11"));
				invoiceReq.setLATTRIBUTE12((String)rowSet.getString("ATTR_CTNT12"));
				invoiceReq.setLATTRIBUTE13((String)rowSet.getString("ATTR_CTNT13"));
				invoiceReq.setLATTRIBUTE14((String)rowSet.getString("ATTR_CTNT14"));
				invoiceReq.setLATTRIBUTE15((String)rowSet.getString("ATTR_CTNT15"));
				invoiceReq.setLBKGNO((String)rowSet.getString("BKG_NO"));
				invoiceReq.setLCNTRTPSZ((String)rowSet.getString("CNTR_TPSZ_CD"));
				invoiceReq.setLACTVVD((String)rowSet.getString("ACT_VVD_CD"));
				invoiceReq.setLDIVCD((String)rowSet.getString("PLN_SCTR_DIV_CD"));
				invoiceReq.setLCARRCD((String)rowSet.getString("SO_CRR_CD"));
				invoiceReq.setLYDCD((String)rowSet.getString("YD_CD"));
				invoiceReq.setLFUTUREUSE1((String)rowSet.getString("FTU_USE_CTNT1"));
				invoiceReq.setLFUTUREUSE2((String)rowSet.getString("FTU_USE_CTNT2"));
				invoiceReq.setLFUTUREUSE3((String)rowSet.getString("FTU_USE_CTNT3"));
				invoiceReq.setLFUTUREUSE4((String)rowSet.getString("FTU_USE_CTNT4"));
				invoiceReq.setLFUTUREUSE5((String)rowSet.getString("FTU_USE_CTNT5"));
			}
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * EAI 연동시 해당 VO에 데이타를 셋팅한다.<br>
	 * 
	 * @param map 연동 데이타를 담고 있는 HashMap
	 * @param bkgfaccalcsReq bkgfaccalcsRequest 객체
	 * @throws Exception
	 */	
	private void setBKGFACCALCSRequest( String[][] array, BKGFACCALCSRequest bkgfaccalcsReq ) throws Exception {

		try {
			if (array != null) {
				bkgfaccalcsReq.setSrvcnm("BKG_FAC_CALC_S");	//SRVCNM
				bkgfaccalcsReq.setSvrId("ENT");				//SVR_ID
				bkgfaccalcsReq.setUsrl1Array(array[0]);		//USRL1
				bkgfaccalcsReq.setUsrl2Array(array[1]);		//USRL2
				bkgfaccalcsReq.setUsrd1Array(array[2]);		//USRD1
				bkgfaccalcsReq.setUsrd2Array(array[3]);		//USRD2
				bkgfaccalcsReq.setUsrd3Array(array[4]);		//USRD3
				bkgfaccalcsReq.setUsrs1Array(array[5]);		//USRS1
				bkgfaccalcsReq.setUsrs2Array(array[6]);		//USRS2
				bkgfaccalcsReq.setUsrs3Array(array[7]);		//USRS3
				bkgfaccalcsReq.setUsrs4Array(array[8]);		//USRS4
				bkgfaccalcsReq.setUsrs5Array(array[9]);		//USRS5
				bkgfaccalcsReq.setUsrs6Array(array[10]);	//USRS6
				bkgfaccalcsReq.setUsrs7Array(array[11]);	//USRS7
				bkgfaccalcsReq.setUsrs8Array(array[12]);	//USRS8
				bkgfaccalcsReq.setUsrs9Array(array[13]);	//USRS9
				bkgfaccalcsReq.setUsrs10Array(array[14]);	//USRS10
				bkgfaccalcsReq.setUsrs11Array(array[15]);	//USRS11
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw e;
		}
	}

}