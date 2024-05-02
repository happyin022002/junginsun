/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : KrWharfageDecMgtEAIDAO.java
 *@FileTitle : KrWharfageDecMgtEAIDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.04.29 정재엽
 * 1.0 Creation
 * 
 * 1.1 2011.07.04 민정호 [CHM-201111125] Split 01-Split 08-ALPS Error 개발 및 테스트
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApSlipInterfaceListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.irep.enis.EAIHeaderType;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.irep.enis.FNS0080003Document.FNS0080003;
import com.hanjin.irep.enis.FNS0080003Document.FNS0080003.DataArea.APInvoiceCollection;
import com.hanjin.irep.enis.FNS0080003Document.FNS0080003.DataArea.APInvoiceCollection.APInvoiceRequest;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.WeblogicSendQClient;

/**
 * NIS2010 KrWharfageDecMgtEAIDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 WebService 작업수행.<br>
 * 
 * @author Jeong Jay Yoeb
 * @see 
 * @since J2EE 1.4
 */

public class KrWharfageDecMgtEAIDAO extends DBDAOSupport {

	/**
	 * AP Invoice 데이터를 ERP로 Interface한다.<br>
	 * 
	 * @param String csrNo
	 * @param List<SearchApSlipInterfaceListVO> searchApSlipInterfaceListVOs
	 * @throws DAOException
	 */
	public void interfaceKrWhfToAp(String csrNo, List<SearchApSlipInterfaceListVO> searchApSlipInterfaceListVOs) throws DAOException {
		
		TransferEAI eai = null;
		
	    try {
			// 보낼 데이터
	        int listSize = searchApSlipInterfaceListVOs.size();
	
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
	    			setInvoiceDatas(searchApSlipInterfaceListVOs.get(j), 
	    					invoiceReq, 
	    					timeStamp, totCnt, currRow);
	    			
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
    	        log.info("========================AP Interface Start===================================");
    	        log.info(docReqs[i].toString());
    	        log.info("========================AP Interface End===================================");
    	        eai.setMessage(docReqs[i].toString()); 
    	        eai.commit(headerType.getInstanceId());
        			
        		eai.close();

	        }
	
		} catch (EAIException ex) {
			eai.rollback(ex);
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

}