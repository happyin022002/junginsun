/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOSettlementDBDAO.java
*@FileTitle : Owner's Account to Expenses
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.25 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomArSlipApprovalDetailVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomArSlipApprovalHeaderVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApSlipInterfaceListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.irep.enis.EAIHeaderType;
import com.clt.irep.enis.FNS0080003Document;
import com.clt.irep.enis.FNS0080003Document.FNS0080003;
import com.clt.irep.enis.FNS0080003Document.FNS0080003.DataArea.APInvoiceCollection;
import com.clt.irep.enis.FNS0080003Document.FNS0080003.DataArea.APInvoiceCollection.APInvoiceRequest;
import com.clt.irep.erp.FNS0120001Document;
import com.clt.irep.erp.FNS0120001Document.FNS0120001;
import com.clt.irep.erp.FNS0120001Document.FNS0120001.DataArea.FNSINVCollection;
import com.clt.irep.erp.FNS0120001Document.FNS0120001.DataArea.FNSINVCollection.FNSINV;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.WeblogicSendQClient;

/**
 * NIS2010 TCharterIOConsultationEAIDAO <br>
 * - NIS2010-TimeCharterInOutAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon, Seyeong
 * @see TCharterIOConsultationBCImpl 참조
 * @since J2EE 1.6
 */
public class TCharterIOConsultationEAIDAO extends EAIDAOSupport {

	/**
	 * AP Invoice 데이터를 ERP로 Interface한다.<br>
	 * 
	 * @param csrNo String
	 * @param searchApSlipInterfaceListVO List<SearchApSlipInterfaceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unused")
	public void sendSlipApprovalToAP(String csrNo, List<SearchApSlipInterfaceListVO> searchApSlipInterfaceListVO) throws DAOException {
		
		TransferEAI eai = null;
		
	    try {
			// 보낼 데이터
	        int listSize = searchApSlipInterfaceListVO.size();
	
			int sendCnt = listSize/100;
			int modCnt  = listSize%100;
			int arrLeng = (modCnt>0?(sendCnt+1):sendCnt);
	
			FNS0080003Document[] docReqs		= new FNS0080003Document[arrLeng];
	
	        String timeStamp = null;
	        int voRowCnt = 0;
	        for (int i=0; i<arrLeng; i++) {
	
	        	docReqs[i] = FNS0080003Document.Factory.newInstance();
	        	FNS0080003 fns0080003Req		= docReqs[i].addNewFNS0080003();
	            
	            EAIHeaderType headerType = fns0080003Req.addNewEAIHeader();

	            timeStamp = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
		          
	    		headerType.setInstanceId("FNS008-0003" + csrNo+"("+(i+1)+"/"+arrLeng+")");
	    		
	    		FNS0080003.DataArea dataArea = fns0080003Req.addNewDataArea();
	
	            APInvoiceCollection invoiceCollReq	= null;
	            APInvoiceRequest invoiceReq		= null;
	        	invoiceCollReq = dataArea.addNewAPInvoiceCollection();
	
	        	int currRow = 0;
				int totCnt = 0;
	        	
	        	// 최종 마지막 데이타 건수
	        	if ((i + 1) == arrLeng) {
	        		totCnt = listSize%100;
	        		
	        	// 마지막 데이타가 아닐때
	        	} else {
	        		totCnt = 100;
	        	}
	        	
	        	for (int j=voRowCnt; j<listSize; j++) {
		        	
	            	//현재 전송될 페이지의 레코드번호(1 부터 시작)
	        		currRow++;

	            	invoiceReq = invoiceCollReq.addNewAPInvoiceRequest();
	    			setInvoiceDatas(searchApSlipInterfaceListVO.get(j), 
	    					invoiceReq, 
	    					timeStamp, listSize, currRow);
	    			
	            	//해당 VO에 실행되는 세부건수
	    			voRowCnt++;
	
	            	//한번에 100개씩만 전송 가능
	            	if (voRowCnt%100 == 0) {
	            		currRow = 0;
	            		break;
	            	}
	        	}

        		eai = new WeblogicSendQClient(SubSystemConfigFactory.get("COM.ALPSJ.JMS.SEND.URL"), this.getClass());
                
        		eai.setDestination("FNS008-0003");
    	        eai.setFactory(SubSystemConfigFactory.get("COM.ALPSJ.JMS.FACTORY")); 
    	        eai.setQueue(SubSystemConfigFactory.get("COM.ALPSJ.JMS.QUEUE"));  
    	        log.error("========================AP Interface Start===================================");
    	        log.error(docReqs[i].toString());
    	        log.error("========================AP Interface End===================================");
    	        eai.setMessage(docReqs[i].toString()); 
    	        eai.commit(headerType.getInstanceId());
        			
        		eai.close();

	        }
	
		} catch (EAIException ex) {
			if(null != eai) eai.rollback(ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * AP - EAI 연동시 해당 VO에 데이타를 셋팅한다.<br>
	 * 
	 * @param searchApSlipInterfaceListVO SearchApSlipInterfaceListVO
	 * @param invoiceReq APInvoiceRequest
	 * @param timestamp String
	 * @param totCnt int
	 * @param currRow int
	 * @throws Exception
	 */
	private void setInvoiceDatas(SearchApSlipInterfaceListVO searchApSlipInterfaceListVO, 
			APInvoiceRequest invoiceReq, 
			String timeStamp, int totCnt, int currRow) throws Exception {

		try {

			invoiceReq.setLIFID("FNS008-0003");
			invoiceReq.setSEQ(timeStamp);
			invoiceReq.setTOTALCOUNT(Integer.toString(totCnt));
			invoiceReq.setROWCOUNT(Integer.toString(currRow));
			
			//Header
			invoiceReq.setHCSRNUMBER(searchApSlipInterfaceListVO.getHdrCsrNo());
			invoiceReq.setHCSRTYPE(searchApSlipInterfaceListVO.getHdrCsrTpCd());
			invoiceReq.setHINVOICEDATE(searchApSlipInterfaceListVO.getHdrInvDt());
			invoiceReq.setHTERMSDATE(searchApSlipInterfaceListVO.getHdrInvTermDt());
			invoiceReq.setHGLDATE(searchApSlipInterfaceListVO.getHdrGlDt());
			invoiceReq.setHVENDORNO(searchApSlipInterfaceListVO.getHdrVndrNo());
			invoiceReq.setHCSRAMOUNT(searchApSlipInterfaceListVO.getHdrCsrAmt());
			invoiceReq.setHPAYMENTAMOUNT(searchApSlipInterfaceListVO.getHdrPayAmt());
			invoiceReq.setHPAYMENTDATE(searchApSlipInterfaceListVO.getHdrPayDt());
			invoiceReq.setHCSRCURRENCYCODE(searchApSlipInterfaceListVO.getHdrCsrCurrCd());
			invoiceReq.setHTERMSNAME(searchApSlipInterfaceListVO.getHdrVndrTermNm());
			invoiceReq.setHDESCRIPTION(searchApSlipInterfaceListVO.getHdrInvDesc());
			invoiceReq.setHATTRIBUTECATEGORY(searchApSlipInterfaceListVO.getHdrAttrCateNm());
			invoiceReq.setHATTRIBUTE1("");
			invoiceReq.setHATTRIBUTE2(searchApSlipInterfaceListVO.getHdrAttrCtnt2());
			invoiceReq.setHATTRIBUTE3(searchApSlipInterfaceListVO.getHdrAttrCtnt3());
			invoiceReq.setHATTRIBUTE4(searchApSlipInterfaceListVO.getHdrAttrCtnt4());
			invoiceReq.setHATTRIBUTE5(searchApSlipInterfaceListVO.getHdrAttrCtnt5());
			invoiceReq.setHATTRIBUTE6(searchApSlipInterfaceListVO.getHdrAttrCtnt6());
			invoiceReq.setHATTRIBUTE7(searchApSlipInterfaceListVO.getHdrAttrCtnt7());
			invoiceReq.setHATTRIBUTE8(searchApSlipInterfaceListVO.getHdrAttrCtnt8());
			invoiceReq.setHATTRIBUTE9(searchApSlipInterfaceListVO.getHdrAttrCtnt9());
			invoiceReq.setHATTRIBUTE10(searchApSlipInterfaceListVO.getHdrAttrCtnt10());
			invoiceReq.setHATTRIBUTE11(searchApSlipInterfaceListVO.getHdrAttrCtnt11());
			invoiceReq.setHATTRIBUTE12(searchApSlipInterfaceListVO.getHdrAttrCtnt12());
			invoiceReq.setHATTRIBUTE13(searchApSlipInterfaceListVO.getHdrAttrCtnt13());
			invoiceReq.setHATTRIBUTE14(searchApSlipInterfaceListVO.getHdrAttrCtnt14());
			invoiceReq.setHATTRIBUTE15(searchApSlipInterfaceListVO.getHdrAttrCtnt15());
			invoiceReq.setHGLOBALATTRIBUTE1(searchApSlipInterfaceListVO.getHdrGloAttrCtnt1());
			invoiceReq.setHGLOBALATTRIBUTE2(searchApSlipInterfaceListVO.getHdrGloAttrCtnt2());
			invoiceReq.setHGLOBALATTRIBUTE3(searchApSlipInterfaceListVO.getHdrGloAttrCtnt3());
			invoiceReq.setHGLOBALATTRIBUTE4(searchApSlipInterfaceListVO.getHdrGloAttrCtnt4());
			invoiceReq.setHGLOBALATTRIBUTE5(searchApSlipInterfaceListVO.getHdrGloAttrCtnt5());
			invoiceReq.setHGLOBALATTRIBUTE6(searchApSlipInterfaceListVO.getHdrGloAttrCtnt6());
			invoiceReq.setHGLOBALATTRIBUTE7(searchApSlipInterfaceListVO.getHdrGloAttrCtnt7());
			invoiceReq.setHGLOBALATTRIBUTE8(searchApSlipInterfaceListVO.getHdrGloAttrCtnt8());
			invoiceReq.setHGLOBALATTRIBUTE9(searchApSlipInterfaceListVO.getHdrGloAttrCtnt9());
			invoiceReq.setHGLOBALATTRIBUTE10(searchApSlipInterfaceListVO.getHdrGloAttrCtnt10());
			invoiceReq.setHGLOBALATTRIBUTE11(searchApSlipInterfaceListVO.getHdrGloAttrCtnt11());
			invoiceReq.setHGLOBALATTRIBUTE12(searchApSlipInterfaceListVO.getHdrGloAttrCtnt12());
			invoiceReq.setHGLOBALATTRIBUTE13(searchApSlipInterfaceListVO.getHdrGloAttrCtnt13());
			invoiceReq.setHGLOBALATTRIBUTE14(searchApSlipInterfaceListVO.getHdrGloAttrCtnt14());
			invoiceReq.setHGLOBALATTRIBUTE15(searchApSlipInterfaceListVO.getHdrGloAttrCtnt15());
			invoiceReq.setHGLOBALATTRIBUTE16(searchApSlipInterfaceListVO.getHdrGloAttrCtnt16());
			invoiceReq.setHGLOBALATTRIBUTE17(searchApSlipInterfaceListVO.getHdrGloAttrCtnt17());
			invoiceReq.setHGLOBALATTRIBUTE18(searchApSlipInterfaceListVO.getHdrGloAttrCtnt18());
			invoiceReq.setHSOURCE(searchApSlipInterfaceListVO.getHdrSrcCtnt());
			invoiceReq.setHPAYMENTMETHODLOOKUPCODE(searchApSlipInterfaceListVO.getHdrPayMzdLuCd());
			invoiceReq.setHPAYGROUPLOOKUPCODE(searchApSlipInterfaceListVO.getHdrPayGrpLuCd());
			invoiceReq.setHACCTSCOACOMPANY(searchApSlipInterfaceListVO.getHdrCoaCoCd());
			invoiceReq.setHACCTSCOAREGION(searchApSlipInterfaceListVO.getHdrCoaRgnCd());
			invoiceReq.setHACCTSCOACENTER(searchApSlipInterfaceListVO.getHdrCoaCtrCd());
			invoiceReq.setHACCTSCOAACCOUNT(searchApSlipInterfaceListVO.getHdrCoaAcctCd());
			invoiceReq.setHACCTSCOAVVD(searchApSlipInterfaceListVO.getHdrCoaVvdCd());
			invoiceReq.setHACCTSCOAINTERCOMPANY(searchApSlipInterfaceListVO.getHdrCoaInterCoCd());
			invoiceReq.setHACCTSCOAFUTURE1(searchApSlipInterfaceListVO.getHdrCoaFtuN1stCd());
			invoiceReq.setHACCTSCOAFUTURE2(searchApSlipInterfaceListVO.getHdrCoaFtuN2ndCd());
			invoiceReq.setHPREPAYNUM(searchApSlipInterfaceListVO.getHdrPpdNo());
			invoiceReq.setHPREPAYDISTNUM(searchApSlipInterfaceListVO.getHdrPpdDtrbNo());
			invoiceReq.setHPREPAYAPPLYAMOUNT(searchApSlipInterfaceListVO.getHdrPpdAplyAmt());
			invoiceReq.setHPREPAYGLDATE(searchApSlipInterfaceListVO.getHdrPpdGlDt());
			invoiceReq.setHAPPROVEFLAG(searchApSlipInterfaceListVO.getHdrAproFlg());
			invoiceReq.setHTAXFLAG(searchApSlipInterfaceListVO.getHdrTaxDeclFlg());
			invoiceReq.setHERRORCSRNUMBER(searchApSlipInterfaceListVO.getHdrErrCsrNo());
			invoiceReq.setHINTERFACEFLAG(searchApSlipInterfaceListVO.getHdrIfFlg());
			invoiceReq.setHINTERFACEDATE(searchApSlipInterfaceListVO.getHdrIfDt());
			invoiceReq.setHINTERFACEERRORREASON(searchApSlipInterfaceListVO.getHdrIfErrRsn());
			invoiceReq.setHPREPAYMENTAPPLYFLAG(searchApSlipInterfaceListVO.getHdrPpayAplyFlg());
			invoiceReq.setHTRANSACTIONCODE(searchApSlipInterfaceListVO.getHdrTjOfcCd());
			invoiceReq.setHACTUALRATE(searchApSlipInterfaceListVO.getHdrActXchRt());
			invoiceReq.setHIMPORTERRORFLAG(searchApSlipInterfaceListVO.getHdrImpErrFlg());
			invoiceReq.setHRECEIVEERRORFLAG(searchApSlipInterfaceListVO.getHdrRcvErrFlg());
			invoiceReq.setHTAXCURRENCYEXCHANGEFLAG(searchApSlipInterfaceListVO.getHdrTaxCurrXchFlg());
			invoiceReq.setHUSEREMAILID(searchApSlipInterfaceListVO.getHdrUsrEml());
			invoiceReq.setHIMPORTERRORREASON(searchApSlipInterfaceListVO.getHdrImpErrRsn());
			invoiceReq.setHRECEIVEERRORREASON(searchApSlipInterfaceListVO.getHdrRcvErrRsn());
			invoiceReq.setHFUTUREUSE1(searchApSlipInterfaceListVO.getHdrFtuUseCtnt1());
			invoiceReq.setHFUTUREUSE2(searchApSlipInterfaceListVO.getHdrFtuUseCtnt2());
			invoiceReq.setHFUTUREUSE3(searchApSlipInterfaceListVO.getHdrFtuUseCtnt3());
			invoiceReq.setHFUTUREUSE4(searchApSlipInterfaceListVO.getHdrFtuUseCtnt4());
			invoiceReq.setHFUTUREUSE5(searchApSlipInterfaceListVO.getHdrFtuUseCtnt5());
			
			//Detail
			invoiceReq.setLCSRNUMBER(searchApSlipInterfaceListVO.getDCsrNo());
			invoiceReq.setLLINESEQUENCELEGACY(searchApSlipInterfaceListVO.getDLineSeq());
			invoiceReq.setLLINENUMBERERP(searchApSlipInterfaceListVO.getDLineNo());
			invoiceReq.setLLINETYPELOOKUPCODE(searchApSlipInterfaceListVO.getDLineTpLuCd());
			invoiceReq.setLAMOUNT(searchApSlipInterfaceListVO.getDInvAmt());
			invoiceReq.setLDESCRIPTION(searchApSlipInterfaceListVO.getDInvDesc());
			invoiceReq.setLTAXCODE(searchApSlipInterfaceListVO.getDInvTaxCd());
			invoiceReq.setLDISTCOACOMPANY(searchApSlipInterfaceListVO.getDDtrbCoaCoCd());
			invoiceReq.setLDISTCOAREGION(searchApSlipInterfaceListVO.getDDtrbCoaRgnCd());
			invoiceReq.setLDISTCOACENTER(searchApSlipInterfaceListVO.getDDtrbCoaCtrCd());
			invoiceReq.setLDISTCOAACCOUNT(searchApSlipInterfaceListVO.getDDtrbCoaAcctCd());
			invoiceReq.setLDISTCOAVVD(searchApSlipInterfaceListVO.getDDtrbCoaVvdCd());
			invoiceReq.setLDISTCOAINTERCOMPANY(searchApSlipInterfaceListVO.getDDtrbCoaInterCoCd());
			invoiceReq.setLDISTCOAFUTURE1(searchApSlipInterfaceListVO.getDDtrbCoaFtuN1stCd());
			invoiceReq.setLDISTCOAFUTURE2(searchApSlipInterfaceListVO.getDDtrbCoaFtuN2ndCd());
			invoiceReq.setLATTRIBUTECATEGORY(searchApSlipInterfaceListVO.getDAttrCateNm());
			invoiceReq.setLATTRIBUTE1(searchApSlipInterfaceListVO.getDAttrCtnt1());
			invoiceReq.setLATTRIBUTE2(searchApSlipInterfaceListVO.getDAttrCtnt2());
			invoiceReq.setLATTRIBUTE3(searchApSlipInterfaceListVO.getDAttrCtnt3());
			invoiceReq.setLATTRIBUTE4(searchApSlipInterfaceListVO.getDAttrCtnt4());
			invoiceReq.setLATTRIBUTE5(searchApSlipInterfaceListVO.getDAttrCtnt5());
			invoiceReq.setLATTRIBUTE6(searchApSlipInterfaceListVO.getDAttrCtnt6());
			invoiceReq.setLATTRIBUTE7(searchApSlipInterfaceListVO.getDAttrCtnt7());
			invoiceReq.setLATTRIBUTE8(searchApSlipInterfaceListVO.getDAttrCtnt8());
			invoiceReq.setLATTRIBUTE9(searchApSlipInterfaceListVO.getDAttrCtnt9());
			invoiceReq.setLATTRIBUTE10(searchApSlipInterfaceListVO.getDAttrCtnt10());
			invoiceReq.setLATTRIBUTE11(searchApSlipInterfaceListVO.getDAttrCtnt11());
			invoiceReq.setLATTRIBUTE12(searchApSlipInterfaceListVO.getDAttrCtnt12());
			invoiceReq.setLATTRIBUTE13(searchApSlipInterfaceListVO.getDAttrCtnt13());
			invoiceReq.setLATTRIBUTE14(searchApSlipInterfaceListVO.getDAttrCtnt14());
			invoiceReq.setLATTRIBUTE15(searchApSlipInterfaceListVO.getDAttrCtnt15());
			invoiceReq.setLBKGNO(searchApSlipInterfaceListVO.getDBkgNo());
			invoiceReq.setLCNTRTPSZ(searchApSlipInterfaceListVO.getDCntrTpszCd());
			invoiceReq.setLACTVVD(searchApSlipInterfaceListVO.getDActVvdCd());
			invoiceReq.setLDIVCD(searchApSlipInterfaceListVO.getDPlnSctrDivCd());
			invoiceReq.setLCARRCD(searchApSlipInterfaceListVO.getDSoCrrCd());
			invoiceReq.setLYDCD(searchApSlipInterfaceListVO.getDYdCd());
			invoiceReq.setLFUTUREUSE1(searchApSlipInterfaceListVO.getDFtuUseCtnt1());
			invoiceReq.setLFUTUREUSE2(searchApSlipInterfaceListVO.getDFtuUseCtnt2());
			invoiceReq.setLFUTUREUSE3(searchApSlipInterfaceListVO.getDFtuUseCtnt3());
			invoiceReq.setLFUTUREUSE4(searchApSlipInterfaceListVO.getDFtuUseCtnt4());
			invoiceReq.setLFUTUREUSE5(searchApSlipInterfaceListVO.getDFtuUseCtnt5());

		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * AR 데이터를 ERP로 Interface한다.<br>
	 * 
	 * @param csrNo String
	 * @param customArSlipApprovalHeaderVO List<CustomArSlipApprovalHeaderVO>
	 * @param customArSlipApprovalDetailVO List<CustomArSlipApprovalDetailVO>
	 * @throws DAOException
	 */
	public void sendSlipApprovalToAR(String csrNo, List<CustomArSlipApprovalHeaderVO> customArSlipApprovalHeaderVO, List<CustomArSlipApprovalDetailVO> customArSlipApprovalDetailVO) throws DAOException {
		
		TransferEAI eai = null;
			
		try {
			// 보낼 데이터
	        int listSize = customArSlipApprovalDetailVO.size();
	
        	for (int j=0; j<listSize; j++) {
        		
    			FNS0120001Document docReq		= FNS0120001Document.Factory.newInstance();
	            FNS0120001 fns0120001Req		= docReq.addNewFNS0120001();

	            String timeStamp = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
	            
	            com.clt.irep.erp.EAIHeaderType headerType = fns0120001Req.addNewEAIHeader();
	    		headerType.setInstanceId("FNS0120001-" + timeStamp + "-" + customArSlipApprovalDetailVO.get(j).getArIfNo());
	    		
	    		FNS0120001.DataArea dataArea = fns0120001Req.addNewDataArea();

	    		FNSINVCollection invoiceCollReq = dataArea.addNewFNSINVCollection();

	    		FNSINV invoiceReq = invoiceCollReq.addNewFNSINV();
            	setARDatas(customArSlipApprovalHeaderVO.get(j), 
    					customArSlipApprovalDetailVO.get(j), 
    					invoiceReq, 
    					timeStamp);
	        	
        		eai = new WeblogicSendQClient(SubSystemConfigFactory.get("COM.INVJ.JMS.SEND.URL"), this.getClass());
        		
        		eai.setDestination("FNS012-0001");
    	        eai.setFactory(SubSystemConfigFactory.get("COM.INVJ.JMS.FACTORY")); 
    	        eai.setQueue(SubSystemConfigFactory.get("COM.INVJ.JMS.QUEUE"));  

    	        log.error("========================AR Interface Start===================================");
    	        log.error(docReq.toString());
    	        log.error("========================AR Interface End===================================");
    	        eai.setMessage(docReq.toString()); 
    	        eai.commit(headerType.getInstanceId());
	    			
	    		eai.close();
        	}	
	
		} catch (EAIException ex) {
			if(null != eai) eai.rollback(ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * AR - EAI 연동시 해당 VO에 데이타를 셋팅한다.<br>
	 * 
	 * @param customArSlipApprovalHeaderVO CustomArSlipApprovalHeaderVO
	 * @param customArSlipApprovalDetailVO CustomArSlipApprovalDetailVO
	 * @param invoiceReq FNSINV
	 * @param timestamp String
	 * @throws Exception
	 */
	private void setARDatas(CustomArSlipApprovalHeaderVO customArSlipApprovalHeaderVO, 
			CustomArSlipApprovalDetailVO customArSlipApprovalDetailVO, 
			FNSINV invoiceReq, 
			String timeStamp) throws Exception {
	
		try {
	
			invoiceReq.setLIFID("FNS0120001");
			invoiceReq.setSEQ(timeStamp);
			invoiceReq.setTOTALCOUNT("1");
			invoiceReq.setROWCOUNT("1");
			invoiceReq.setFLAG("C");
			
			//Header
			invoiceReq.setMAINIFNO          (customArSlipApprovalHeaderVO.getArIfNo());
			invoiceReq.setMAINIFSER         (customArSlipApprovalHeaderVO.getArIfSerNo());
			invoiceReq.setBLNO              (customArSlipApprovalHeaderVO.getBlNo());
			invoiceReq.setBLNOTP            ("");
			invoiceReq.setBKGNO             ("");
			invoiceReq.setSOURCE            (customArSlipApprovalHeaderVO.getArSrcCd());
			invoiceReq.setTRANSTYP          ("SALAR");
			invoiceReq.setINVNO             (customArSlipApprovalHeaderVO.getInvNo());
			invoiceReq.setCANO              ("");
			invoiceReq.setCADT              ("");
			invoiceReq.setRHQ               (customArSlipApprovalHeaderVO.getRhqCd());
			invoiceReq.setOFC               (customArSlipApprovalHeaderVO.getArOfcCd());
			invoiceReq.setACTCNTRYCD        (customArSlipApprovalHeaderVO.getActCustCntCd());
			invoiceReq.setACTCUSTCD         (customArSlipApprovalHeaderVO.getActCustSeq());
			invoiceReq.setINVCNTRYCD        (customArSlipApprovalHeaderVO.getActCustCntCd());
			invoiceReq.setINVCUSTCD         (customArSlipApprovalHeaderVO.getActCustSeq());
			invoiceReq.setVSL               (customArSlipApprovalHeaderVO.getVslCd());
			invoiceReq.setVOY               (customArSlipApprovalHeaderVO.getSkdVoyNo());
			invoiceReq.setDIR               (customArSlipApprovalHeaderVO.getSkdDirCd());
			invoiceReq.setTVVD              (customArSlipApprovalHeaderVO.getTrnkVslCd()+
											 customArSlipApprovalHeaderVO.getTrnkSkdVoyNo()+
											 customArSlipApprovalHeaderVO.getTrnkSkdDirCd());
			invoiceReq.setREVVSL            (customArSlipApprovalHeaderVO.getRevVslCd());
			invoiceReq.setREVVOY            (customArSlipApprovalHeaderVO.getRevSkdVoyNo());
			invoiceReq.setREVDIR            (customArSlipApprovalHeaderVO.getRevSkdDirCd()+customArSlipApprovalHeaderVO.getRevDirCd());
			invoiceReq.setSADT              (customArSlipApprovalHeaderVO.getSailArrDt());
			invoiceReq.setPOR               (customArSlipApprovalHeaderVO.getPorCd());
			invoiceReq.setPOL               (customArSlipApprovalHeaderVO.getPolCd());
			invoiceReq.setPOD               (customArSlipApprovalHeaderVO.getPodCd());
			invoiceReq.setDEL               (customArSlipApprovalHeaderVO.getDelCd());
			invoiceReq.setSCP               ("");
			invoiceReq.setLANE              (customArSlipApprovalHeaderVO.getSlanCd());
			invoiceReq.setBND               (customArSlipApprovalHeaderVO.getIoBndCd());
			invoiceReq.setCREDITMK          (customArSlipApprovalHeaderVO.getCustCrFlg());
			invoiceReq.setSLSMANCD          ("");
			invoiceReq.setDUEDT             (customArSlipApprovalHeaderVO.getDueDt());
			invoiceReq.setUSDAMT            (customArSlipApprovalHeaderVO.getUsdAmt());
			invoiceReq.setLCLAMT            (customArSlipApprovalHeaderVO.getLoclAmt());
			invoiceReq.setWHFDECNO          ("");
			invoiceReq.setCTTDECNO          ("");
			invoiceReq.setZONEIOC           (customArSlipApprovalHeaderVO.getZnIocCd());
			invoiceReq.setIFFLAG            ("");
			invoiceReq.setERPIFDT           ("");
			invoiceReq.setINVCOACOMPANY     (customArSlipApprovalHeaderVO.getInvCoaCoCd());
			invoiceReq.setINVCOAREGION      (customArSlipApprovalHeaderVO.getInvCoaRgnCd());
			invoiceReq.setINVCOACENTER      (customArSlipApprovalHeaderVO.getInvCoaCtrCd());
			invoiceReq.setINVCOAACCOUNT     (customArSlipApprovalHeaderVO.getInvCoaAcctCd());
			invoiceReq.setINVCOAINTERCOMPANY(customArSlipApprovalHeaderVO.getInvCoaInterCoCd());
			invoiceReq.setINVCOAVVD         (customArSlipApprovalHeaderVO.getInvCoaVslCd()+
					                         customArSlipApprovalHeaderVO.getInvCoaVoyNo()+
					                         customArSlipApprovalHeaderVO.getInvCoaSkdDirCd()+
					                         customArSlipApprovalHeaderVO.getInvCoaRevDirCd());
			invoiceReq.setINVCOAFUTURE1     ("000000");
			invoiceReq.setINVCOAFUTURE2     ("000000");
			invoiceReq.setREVLANE           (customArSlipApprovalHeaderVO.getRlaneCd());
			invoiceReq.setCONTNO            (customArSlipApprovalHeaderVO.getInvCtrtNo());
			invoiceReq.setCREDITTERM        (customArSlipApprovalHeaderVO.getCrTermDys());
			invoiceReq.setSAILINGDT         (customArSlipApprovalHeaderVO.getSailDt());
			invoiceReq.setGLDT              (customArSlipApprovalHeaderVO.getGlDt());
			invoiceReq.setEXRATETYPE        (customArSlipApprovalHeaderVO.getXchRtTpCd());
			invoiceReq.setEXRATECUSTDATE    ("");
			invoiceReq.setSETOFFNO          ("");
			invoiceReq.setCUSTREFNO         ("");
			invoiceReq.setTAXEXRATE         (customArSlipApprovalHeaderVO.getTaxXchRt());
			invoiceReq.setTAXIND            ("0");
			invoiceReq.setONBOARDDT         ("");
			invoiceReq.setOBLMK             ("");
			invoiceReq.setCTYCD             (customArSlipApprovalHeaderVO.getArCtyCd());
			invoiceReq.setSALESOFC          (customArSlipApprovalHeaderVO.getSlsOfcCd());
			invoiceReq.setRMK               (customArSlipApprovalHeaderVO.getInvRmkEnc());
			invoiceReq.setCURR              (customArSlipApprovalHeaderVO.getCurrCd());
			invoiceReq.setUSERID            (customArSlipApprovalHeaderVO.getUsrId());
			invoiceReq.setLOGRGSTDT         (customArSlipApprovalHeaderVO.getLogUpdDt());
			invoiceReq.setLOGUPDTDT         (customArSlipApprovalHeaderVO.getLogUpdDt());
			invoiceReq.setISSDT             (customArSlipApprovalHeaderVO.getIssDt());
			invoiceReq.setSLIPNO            (customArSlipApprovalHeaderVO.getSlpNo());
			invoiceReq.setJOIND             ("");
			
			//Detail
			invoiceReq.setDTLIFNO           (customArSlipApprovalDetailVO.getArIfNo());
			invoiceReq.setDTLIFSER          (customArSlipApprovalDetailVO.getArIfSerNo());
			invoiceReq.setCHGSEQ            (customArSlipApprovalDetailVO.getChgSeq());
			invoiceReq.setCHGTYP            (customArSlipApprovalDetailVO.getChgCd());
			invoiceReq.setREPCHGTYP         (customArSlipApprovalDetailVO.getRepChgCd());
			invoiceReq.setCHGCUR            (customArSlipApprovalDetailVO.getCurrCd());
			invoiceReq.setREVTYP            (customArSlipApprovalDetailVO.getJoRevTpCd());
			invoiceReq.setCHGAMT            (customArSlipApprovalDetailVO.getChgAmt());
			invoiceReq.setTAXAMT            (customArSlipApprovalDetailVO.getTaxAmt());
			invoiceReq.setREVCOACOMPANY     (customArSlipApprovalDetailVO.getRevCoaCoCd());
			invoiceReq.setREVCOAREGION      (customArSlipApprovalDetailVO.getRevCoaRgnCd());
			invoiceReq.setREVCOACENTER      (customArSlipApprovalDetailVO.getRevCoaCtrCd());
			invoiceReq.setREVCOAACCOUNT     (customArSlipApprovalDetailVO.getRevCoaAcctCd());
			invoiceReq.setREVCOAINTERCOMPANY(customArSlipApprovalDetailVO.getRevCoaInterCoCd());
			invoiceReq.setREVCOAVVD         (customArSlipApprovalDetailVO.getRevCoaVslCd()+
					                         customArSlipApprovalDetailVO.getRevCoaVoyNo()+
					                         customArSlipApprovalDetailVO.getRevCoaSkdDirCd()+
					                         customArSlipApprovalDetailVO.getRevCoaDirCd());
			invoiceReq.setREVCOAFUTURE1     ("000000");
			invoiceReq.setREVCOAFUTURE2     ("000000");
			invoiceReq.setORICHGCUR         (customArSlipApprovalDetailVO.getCurrCd());
			invoiceReq.setORICHGAMT         (customArSlipApprovalDetailVO.getChgAmt());
			invoiceReq.setREVEFFDT          ("");
			invoiceReq.setPERTYP            ("");
			invoiceReq.setRATE              (customArSlipApprovalDetailVO.getChgAmt());
			invoiceReq.setRATEDAS           ("1");
			invoiceReq.setSOBID             (customArSlipApprovalDetailVO.getSobId());
			invoiceReq.setCHGFULLNM         (customArSlipApprovalDetailVO.getChgFullNm());
			invoiceReq.setACCT              (customArSlipApprovalDetailVO.getAcctCd());
			invoiceReq.setCNTRNO            ("");
			invoiceReq.setCNTRTPSZ          ("");
			invoiceReq.setRFANO             ("");
			invoiceReq.setTHIRDEXRATETYPE   ("");
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}

}