/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ApprovalStepSendEAIDAO.java
*@FileTitle : ERP A/P로 I/F된 CSR에 대한 Approval Step 정보 I/F 처리
*Open Issues :
*Change history :
*@LastModifyDate : 2013-03-12
*@LastModifier :
*@LastVersion : 1.0
* 2013-03-12
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.WeblogicSendQClient;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.alps.EAIHeaderType;
import com.hanjin.irep.alps.FNS0080004Document;
import com.hanjin.irep.alps.FNS0080004Document.FNS0080004;
import com.hanjin.irep.alps.FNS0080004Document.FNS0080004.DataArea.CSRApprovalCollection;
import com.hanjin.irep.alps.FNS0080004Document.FNS0080004.DataArea.CSRApprovalCollection.CSRApprovalRequest;


/**
 * ENIS-ESD에 대한 EAI 처리를 담당<br>
 * - ENIS-ESD Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author yoo
 * @see ApprovalStepSendBCImpl 참조
 * @since J2EE 1.4
 */
public class ApprovalStepSendEAIDAO extends EAIDAOSupport {
	
	/**
	 * Web Service 연동 / 싱크<br>
	 * CSR Approval Step 최종 결재 내역을 ERP A/P로 쏘기 위한 형태로 변경한다.<br>	
	 * @param rowset
	 * @param sub_sys_id
	 * @param csr_no
	 * @return FNS0080004Document
	 * @throws Exception
	 */
	public FNS0080004Document transformAproStep2EAIformat(DBRowSet rowset, String sub_sys_id, String csr_no) throws Exception {	
		log.error("\n BBBBB - ApprovalStepSendEAIDAO.transformAproStep2EAIformat : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
		
		FNS0080004Document docReq		= null;        
        String instanceId = null;
        
		try {
			log.error("\n FNS0080004Document : CSR_NO:" + JSPUtil.getNull(csr_no) + " <<<<\n");
			
			EAIHeaderType 		hearderType		= null;
            FNS0080004 			fns0080004Req	= null;
            CSRApprovalCollection invoiceCollReq	= null;
            CSRApprovalRequest 	invoiceReq		= null;
            
            /*** 
             *  instanceId 규칙
				1) 현재 규칙 -> FNS008-0004' + 날짜(yyyyMMddHHmmss) + SUB_SYS_ID + CSR_NO
				
				EX.
				1) FNS008-000420130222103712TES12SPUSBO13022200001
             */
			instanceId = "FNS008-004"+ (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date())+JSPUtil.getNull(sub_sys_id)+JSPUtil.getNull(csr_no);
            docReq = FNS0080004Document.Factory.newInstance();
            fns0080004Req = docReq.addNewFNS0080004();
            hearderType = fns0080004Req.addNewEAIHeader();
            hearderType.setInstanceId(JSPUtil.getNull(instanceId));	            
            EAIHeaderType.Parameters params = hearderType.addNewParameters();
            EAIHeaderType.Parameters.Parameter param = params.addNewParameter();
            param.setStringValue("FNS008-0004--Header");
            invoiceCollReq = fns0080004Req.addNewDataArea().addNewCSRApprovalCollection();	           
            fns0080004Req.addNewDataArea().addNewCSRApprovalCollection();
			while (rowset!=null && rowset.next()) {
				invoiceReq = invoiceCollReq.addNewCSRApprovalRequest();
	            setInvoiceData(rowset, invoiceReq);
			}
			
			log.error("\n ### CSR_NO:"+csr_no+"  /  instanceId:"+instanceId+"<<<<<<<<<<<<<<<<<<<<< \n");
		} catch (EAIException ee) {
        	log.error(ee.getMessage(),ee);
            throw new EventException(ee.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new Exception(ex.getMessage());
		}
		log.error("\n @@ transformAproStep2EAIformat - docReq : \n"+(docReq!=null?JSPUtil.getNull(docReq.toString()):"")+"\n");
		log.error("\n EEEEE - ApprovalStepSendEAIDAO.transformAproStep2EAIformat -------------------------------------- \n");
		return docReq;
	}	
	
	/**
	 * EAI 연동시 해당 VO에 데이타를 셋팅한다.<br>
	 * @param  rowset
	 * @param  invoiceReq CSRApprovalRequest
	 * @throws Exception
	 */
	private void setInvoiceData(DBRowSet rowset, CSRApprovalRequest invoiceReq) throws Exception {
		log.error("\n BBBBB - ApprovalStepSendEAIDAO.setInvoiceData -------------------------------------- \n");
		try {
			if (rowset != null) {
//				log.debug("\n\n@@@@@@@@@@@@@@@@@@@ ApprovalStepSendEAIDAO - setInvoiceData ----\n"
//						+ " CSR_NO : " + JSPUtil.getNull(rowset.getString("CSR_NO")) 
//						+ " - SRC_CTNT : " + JSPUtil.getNull(rowset.getString("SRC_CTNT")) 
//						+ " - APRO_USR_ID :" + JSPUtil.getNull(rowset.getString("APRO_USR_ID"))
//						+ "\n@@@@@@@@@@@@@@@@@@@\n\n");
				if ((rowset.getString("CSR_NO")!=null && rowset.getString("SRC_CTNT")!=null && rowset.getString("APRO_USR_ID")!=null)){
					invoiceReq.setLIFID("FNS008-0004");
					invoiceReq.setSEQ((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
					invoiceReq.setTOTALCOUNT((String)rowset.getString("TTL_ROW_KNT"));				
					invoiceReq.setROWCOUNT((String)rowset.getString("ROW_KNT"));
					invoiceReq.setCSRNUMBER((String)rowset.getString("CSR_NO"));
					invoiceReq.setCSRTYPE((String)rowset.getString("CSR_TP_CD"));
					invoiceReq.setSOURCE((String)rowset.getString("SRC_CTNT"));
					invoiceReq.setAPPROVALDATE((String)rowset.getString("APRO_DT"));
					invoiceReq.setAPPROVALOFFICE((String)rowset.getString("APRO_OFC_CD"));
					invoiceReq.setAPPROVER((String)rowset.getString("APRO_USR_ID"));
					invoiceReq.setATTRIBUTE1((String)rowset.getString("ATTR_CTNT1"));
					invoiceReq.setATTRIBUTE2((String)rowset.getString("ATTR_CTNT2"));
					invoiceReq.setATTRIBUTE3((String)rowset.getString("ATTR_CTNT3"));
					invoiceReq.setATTRIBUTE4((String)rowset.getString("ATTR_CTNT4"));
					invoiceReq.setATTRIBUTE5((String)rowset.getString("ATTR_CTNT5"));
				} else {
					log.error("\n ApprovalStepSendEAIDAO - setInvoiceData - APROSTEP DBRowSet NOT FOUND EXCEPTION!!!!!!! \n ");
					throw new Exception(" ApprovalStepSendEAIDAO - setInvoiceData - APROSTEP DBRowSet NOT FOUND EXCEPTION!!!!!!!");				
				}
			} else {
				log.error("\n ApprovalStepSendEAIDAO - setInvoiceData - APROSTEP DBRowSet NULL EXCEPTION!!!!!!! \n ");
				throw new Exception(" ApprovalStepSendEAIDAO - setInvoiceData - APROSTEP DBRowSet NULL EXCEPTION!!!!!!!");				
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		}
		log.error("\n EEEEE - ApprovalStepSendEAIDAO.setInvoiceData -------------------------------------- \n");
	}
	
	/**
	 * CSR Approval Step 최종 결재 내역을 ERP A/P로 쏘기  
	 * @param ifId
	 * @param instanceId
	 * @param strDocReq
	 * @return String
	 * @throws Exception
	 * @throws DAOException
	 */
	public String transferAproStep2EAI(String ifId, String instanceId, String strDocReq) throws Exception, DAOException {
		log.error("\n BBBBB - ApprovalStepSendEAIDAO.transferAproStep2EAI -------------------------------------- \n");
		
		TransferEAI eai = null;
		String target       =  SubSystemConfigFactory.get("COM.ALPSJ.JMS.SEND.URL");
		String factory      =  SubSystemConfigFactory.get("COM.ALPSJ.JMS.FACTORY");
		String queue        =  SubSystemConfigFactory.get("COM.ALPSJ.JMS.QUEUE");
		String retval 		=  null; 
		
		log.debug("\n\n\n @@@@ ApprovalStepSendEAIDAO - transferAproStep2EAI"
				+" - target:"+JSPUtil.getNull(target)
				+" - factory:"+JSPUtil.getNull(factory)
				+" - queue:"+JSPUtil.getNull(queue)
				+" - @@@@@@@@@@@@ \n\n\n");
		
		try {
			if (strDocReq!=null && !strDocReq.trim().equals("")){
				if (ifId!=null && !ifId.trim().equals("") && instanceId!=null && !instanceId.trim().equals("")){
					if (target!=null && !target.trim().equals("")){
						eai = new WeblogicSendQClient(JSPUtil.getNull(target),ApprovalStepSendEAIDAO.class);
						if (eai!=null){
							eai.setFactory(JSPUtil.getNull(factory));
							eai.setQueue(JSPUtil.getNull(queue));
							eai.setMessage(JSPUtil.getNull(strDocReq));
							eai.setDestination(JSPUtil.getNull(ifId));
							retval = eai.commit(JSPUtil.getNull(instanceId));
						} else {
							log.error("\n\n EAI INITIALIZING FAILURE Exception (eai null!) ~~~~~~~~~~~~~~ \n\n");
							throw new Exception("EAI INITIALIZING FAILURE Exception (eai null!)");
						}
					} else {
						log.error("\n\n EAI INITIALIZING FAILURE Exception (target null!) ~~~~~~~~~~~~~~ \n\n");
						throw new Exception("EAI INITIALIZING FAILURE Exception (target null!)");
					}
				} else {
					log.error("\n\n IfId/InstanceId NULL Exception ~~~~~~~~~~~~~~ \n\n");
					throw new Exception("IfId/InstanceId NULL Exception ");
				}
			} else {
				log.error("\n\n DOCREQ NULL Exception ~~~~~~~~~~~~~~ \n\n");
				throw new Exception("DOCREQ NULL  Exception ");
			}
//		} catch (EAIException e) {
//			eai.rollback(e);			
//        	log.error(e.getMessage(),e);
//            throw new EventException(e.getMessage());
		} catch (Exception ex) { 
			eai.rollback(ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage());
		} finally {
			if (eai!=null){
				eai.close();	
			}
		}
		log.error("\n EEEEE - ApprovalStepSendEAIDAO.transferAproStep2EAI -------------------------------------- \n");		
		return retval;
	}
}