/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationEAIDAO.java
*@FileTitle : ERP와의 Interface를 위한 EAIDAO file
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.26 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.basic.JointOperationConsultationBCImpl;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ArMnChgVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.InvDtrbVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.InvHdrVO;
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
 * OPUS JointOperationConsultationEAIDAO <br>
 * - OPUS ERP와의 Interface를 위한 EAI DAO<br>
 * 
 * @author Park Hee Dong
 * @see  JointOperationConsultationBCImpl 참조
 * @since J2EE 1.6
 */
public class JointOperationConsultationEAIDAO extends EAIDAOSupport {
	/**
	 * ERP : FNS008
	 * AP Invoice 데이터를 ERP로 Interface한다.<br>
	 * @param String csrNo
	 * @param List<InvHdrVO> invHdrVOs
	 * @param List<InvDtrbVO> invDtrbVOs
	 * @throws DAOException
	 */
	public void sendSlipApprovalToAP(String csrNo, List<InvHdrVO> invHdrVOs, List<InvDtrbVO> invDtrbVOs) throws DAOException {
		
        TransferEAI eai = null;
	    try {
			// 보낼 데이터
	        int listSize = invDtrbVOs.size();
		        
			int sendTimes = (listSize%100 > 0 ? listSize/100 + 1 : listSize/100); //나머지가 0보다 크면 몫+1, 아니면 몫
	
			FNS0080003Document[] docReqs = new FNS0080003Document[sendTimes];
	
	        String timeStamp = null;
	        EAIHeaderType eaiHeaderType = null;
	        FNS0080003 fns0080003Req = null;
	        FNS0080003.DataArea dataArea = null;
            APInvoiceCollection apInvoiceCollection = null;
            APInvoiceRequest apInvoiceRequest = null;

            int rowCnt = 0;
            
	        for (int i=0; i<sendTimes; i++) {
	
	        	docReqs[i] = FNS0080003Document.Factory.newInstance();
	        	fns0080003Req = docReqs[i].addNewFNS0080003();
	        	eaiHeaderType = fns0080003Req.addNewEAIHeader();
	            timeStamp = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
		          
	            eaiHeaderType.setInstanceId("FNS008-0003" + csrNo+"("+(i+1)+"/"+sendTimes+")");
	    		
	    		dataArea = fns0080003Req.addNewDataArea();
	
	    		apInvoiceCollection = dataArea.addNewAPInvoiceCollection();
	
	        	int currRow = 0;
	        	//2010.03.16 전체사이즈를 넘겨야함
//	        	int totCnt = 0;
//	        	if ((i + 1) == sendTimes) {
//	        		totCnt = listSize%100;
//	        	} else {
//	        		totCnt = 100;
//	        	}
	        	
	        	for (int j=rowCnt; j<listSize; j++) {
		        	
	            	currRow++;

	            	apInvoiceRequest = apInvoiceCollection.addNewAPInvoiceRequest();
	            	setAPData(apInvoiceRequest, invHdrVOs.get(0) ,invDtrbVOs.get(j), timeStamp, listSize, currRow);

	            	rowCnt++;
	
	            	//한번에 100개씩만 전송 가능
	            	if (rowCnt%100 == 0) {
	            		currRow = 0;
	            		break;
	            	}
	        	}

	        	eai = new WeblogicSendQClient(SubSystemConfigFactory.get("COM.OPUSJ.JMS.SEND.URL"), this.getClass());
    	        eai.setFactory(SubSystemConfigFactory.get("COM.OPUSJ.JMS.FACTORY")); 
    	        eai.setQueue(SubSystemConfigFactory.get("COM.OPUSJ.JMS.QUEUE"));  
    	        //eai.setDestination(SubSystemConfigFactory.get("COM.OPUSJ.JMS.DESTINATION"));
    	        eai.setDestination("FNS008-0003");
    	        log.info("========================AP Interface Start===================================");
    	        log.info(docReqs[i].toString());
    	        log.info("========================AP Interface End===================================");
    	        eai.setMessage(docReqs[i].toString()); 
    	        eai.commit(eaiHeaderType.getInstanceId());
    			
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
	 * ERP : FNS008
	 * AP - EAI 연동시 해당 VO에 데이타를 셋팅한다.<br>
	 * @param APInvoiceRequest invoiceReq
	 * @param InvHdrVO invHdrVO
	 * @param InvDtrbVO invDtrbVO
	 * @param String timeStamp
	 * @param int totCnt
	 * @param int currRow
	 * @throws Exception
	 */
	private void setAPData(APInvoiceRequest invoiceReq, InvHdrVO invHdrVO, InvDtrbVO invDtrbVO, String timeStamp, int totCnt, int currRow) throws Exception {

		try {

			invoiceReq.setLIFID("FNS008-0003");
			invoiceReq.setSEQ(timeStamp);
			invoiceReq.setTOTALCOUNT(Integer.toString(totCnt));
			invoiceReq.setROWCOUNT(Integer.toString(currRow));
			
			//Header
			invoiceReq.setHCSRNUMBER              (invHdrVO .getCsrNo           ());
			invoiceReq.setHCSRTYPE                (invHdrVO .getCsrTpCd         ());
			invoiceReq.setHINVOICEDATE            (invHdrVO .getInvDt           ());
			invoiceReq.setHTERMSDATE              (invHdrVO .getInvTermDt       ());
			invoiceReq.setHGLDATE                 (invHdrVO .getGlDt            ());
			invoiceReq.setHVENDORNO               (invHdrVO .getVndrNo          ());
			invoiceReq.setHCSRAMOUNT              (invHdrVO .getCsrAmt          ());
			invoiceReq.setHPAYMENTAMOUNT          (invHdrVO .getPayAmt          ());
			invoiceReq.setHPAYMENTDATE            (invHdrVO .getPayDt           ());
			invoiceReq.setHCSRCURRENCYCODE        (invHdrVO .getCsrCurrCd       ());
			invoiceReq.setHTERMSNAME              (invHdrVO .getVndrTermNm      ());
			invoiceReq.setHDESCRIPTION            (invHdrVO .getInvDesc         ());
			invoiceReq.setHATTRIBUTECATEGORY      (invHdrVO .getAttrCateNm      ()); 
			invoiceReq.setHATTRIBUTE1             (invHdrVO .getAttrCtnt1       ());
			invoiceReq.setHATTRIBUTE2             (invHdrVO .getAttrCtnt2       ());
			invoiceReq.setHATTRIBUTE3             (invHdrVO .getAttrCtnt3       ());
			invoiceReq.setHATTRIBUTE4             (invHdrVO .getAttrCtnt4       ());
			invoiceReq.setHATTRIBUTE5             (invHdrVO .getAttrCtnt5       ());
			invoiceReq.setHATTRIBUTE6             (invHdrVO .getAttrCtnt6       ());
			invoiceReq.setHATTRIBUTE7             (invHdrVO .getAttrCtnt7       ());
			invoiceReq.setHATTRIBUTE8             (invHdrVO .getAttrCtnt8       ());
			invoiceReq.setHATTRIBUTE9             (invHdrVO .getAttrCtnt9       ());
			invoiceReq.setHATTRIBUTE10            (invHdrVO .getAttrCtnt10      ());
			invoiceReq.setHATTRIBUTE11            (invHdrVO .getAttrCtnt11      ());
			invoiceReq.setHATTRIBUTE12            (invHdrVO .getAttrCtnt12      ());
			invoiceReq.setHATTRIBUTE13            (invHdrVO .getAttrCtnt13      ());
			invoiceReq.setHATTRIBUTE14            (invHdrVO .getAttrCtnt14      ());
			invoiceReq.setHATTRIBUTE15            (invHdrVO .getAttrCtnt15      ());
			invoiceReq.setHGLOBALATTRIBUTE1       (invHdrVO .getGloAttrCtnt1    ());
			invoiceReq.setHGLOBALATTRIBUTE2       (invHdrVO .getGloAttrCtnt2    ());
			invoiceReq.setHGLOBALATTRIBUTE3       (invHdrVO .getGloAttrCtnt3    ());
			invoiceReq.setHGLOBALATTRIBUTE4       (invHdrVO .getGloAttrCtnt4    ());
			invoiceReq.setHGLOBALATTRIBUTE5       (invHdrVO .getGloAttrCtnt5    ());
			invoiceReq.setHGLOBALATTRIBUTE6       (invHdrVO .getGloAttrCtnt6    ());
			invoiceReq.setHGLOBALATTRIBUTE7       (invHdrVO .getGloAttrCtnt7    ());
			invoiceReq.setHGLOBALATTRIBUTE8       (invHdrVO .getGloAttrCtnt8    ());
			invoiceReq.setHGLOBALATTRIBUTE9       (invHdrVO .getGloAttrCtnt9    ());
			invoiceReq.setHGLOBALATTRIBUTE10      (invHdrVO .getGloAttrCtnt10   ());
			invoiceReq.setHGLOBALATTRIBUTE11      (invHdrVO .getGloAttrCtnt11   ());
			invoiceReq.setHGLOBALATTRIBUTE12      (invHdrVO .getGloAttrCtnt12   ());
			invoiceReq.setHGLOBALATTRIBUTE13      (invHdrVO .getGloAttrCtnt13   ());
			invoiceReq.setHGLOBALATTRIBUTE14      (invHdrVO .getGloAttrCtnt14   ());
			invoiceReq.setHGLOBALATTRIBUTE15      (invHdrVO .getGloAttrCtnt15   ());
			invoiceReq.setHGLOBALATTRIBUTE16      (invHdrVO .getGloAttrCtnt16   ());
			invoiceReq.setHGLOBALATTRIBUTE17      (invHdrVO .getGloAttrCtnt17   ());
			invoiceReq.setHGLOBALATTRIBUTE18      (invHdrVO .getGloAttrCtnt18   ());
			invoiceReq.setHSOURCE                 (invHdrVO .getSrcCtnt         ());
			invoiceReq.setHPAYMENTMETHODLOOKUPCODE(invHdrVO .getPayMzdLuCd      ());
			invoiceReq.setHPAYGROUPLOOKUPCODE     (invHdrVO .getPayGrpLuCd      ());
			invoiceReq.setHACCTSCOACOMPANY        (invHdrVO .getCoaCoCd         ());
			invoiceReq.setHACCTSCOAREGION         (invHdrVO .getCoaRgnCd        ());
			invoiceReq.setHACCTSCOACENTER         (invHdrVO .getCoaCtrCd        ());
			invoiceReq.setHACCTSCOAACCOUNT        (invHdrVO .getCoaAcctCd       ());
			invoiceReq.setHACCTSCOAVVD            (invHdrVO .getCoaVvdCd        ());
			invoiceReq.setHACCTSCOAINTERCOMPANY   (invHdrVO .getCoaInterCoCd    ());
			invoiceReq.setHACCTSCOAFUTURE1        (invHdrVO .getCoaFtuN1stCd    ());
			invoiceReq.setHACCTSCOAFUTURE2        (invHdrVO .getCoaFtuN2ndCd    ());
			invoiceReq.setHPREPAYNUM              (invHdrVO .getPpdNo           ());
			invoiceReq.setHPREPAYDISTNUM          (invHdrVO .getPpdDtrbNo       ());
			invoiceReq.setHPREPAYAPPLYAMOUNT      (invHdrVO .getPpdAplyAmt      ());
			invoiceReq.setHPREPAYGLDATE           (invHdrVO .getPpdGlDt         ());
			invoiceReq.setHAPPROVEFLAG            (invHdrVO .getAproFlg         ());
			invoiceReq.setHTAXFLAG                (invHdrVO .getTaxDeclFlg      ());
			invoiceReq.setHERRORCSRNUMBER         (invHdrVO .getErrCsrNo        ());
			invoiceReq.setHINTERFACEFLAG          (invHdrVO .getIfFlg           ());
			invoiceReq.setHINTERFACEDATE          (invHdrVO .getIfDt            ());
			invoiceReq.setHINTERFACEERRORREASON   (invHdrVO .getIfErrRsn        ());
			invoiceReq.setHPREPAYMENTAPPLYFLAG    (invHdrVO .getPpayAplyFlg     ());
			invoiceReq.setHTRANSACTIONCODE        (invHdrVO .getTjOfcCd         ());
			invoiceReq.setHACTUALRATE             (invHdrVO .getActXchRt        ());
			invoiceReq.setHIMPORTERRORFLAG        (invHdrVO .getImpErrFlg       ());
			invoiceReq.setHRECEIVEERRORFLAG       (invHdrVO .getRcvErrFlg       ());
			invoiceReq.setHTAXCURRENCYEXCHANGEFLAG(invHdrVO .getTaxCurrXchFlg   ());
			invoiceReq.setHUSEREMAILID            (invHdrVO .getUsrEml          ());
			invoiceReq.setHIMPORTERRORREASON      (invHdrVO .getImpErrRsn       ());
			invoiceReq.setHRECEIVEERRORREASON     (invHdrVO .getRcvErrRsn       ());
			invoiceReq.setHFUTUREUSE1             (invHdrVO .getFtuUseCtnt1     ());
			invoiceReq.setHFUTUREUSE2             (invHdrVO .getFtuUseCtnt2     ());
			invoiceReq.setHFUTUREUSE3             (invHdrVO .getFtuUseCtnt3     ());
			invoiceReq.setHFUTUREUSE4             (invHdrVO .getFtuUseCtnt4     ());
			invoiceReq.setHFUTUREUSE5             (invHdrVO .getFtuUseCtnt5     ());

			//Detail
			invoiceReq.setLCSRNUMBER              (invDtrbVO.getCsrNo           ());
			invoiceReq.setLLINESEQUENCELEGACY     (invDtrbVO.getLineSeq         ());
			invoiceReq.setLLINENUMBERERP          (invDtrbVO.getLineNo          ());
			invoiceReq.setLLINETYPELOOKUPCODE     (invDtrbVO.getLineTpLuCd      ());
			invoiceReq.setLAMOUNT                 (invDtrbVO.getInvAmt          ());
			invoiceReq.setLDESCRIPTION            (invDtrbVO.getInvDesc         ());
			invoiceReq.setLTAXCODE                (invDtrbVO.getInvTaxCd        ());
			invoiceReq.setLDISTCOACOMPANY         (invDtrbVO.getDtrbCoaCoCd     ());
			invoiceReq.setLDISTCOAREGION          (invDtrbVO.getDtrbCoaRgnCd    ());
			invoiceReq.setLDISTCOACENTER          (invDtrbVO.getDtrbCoaCtrCd    ());
			invoiceReq.setLDISTCOAACCOUNT         (invDtrbVO.getDtrbCoaAcctCd   ());
			invoiceReq.setLDISTCOAVVD             (invDtrbVO.getDtrbCoaVvdCd    ());
			invoiceReq.setLDISTCOAINTERCOMPANY    (invDtrbVO.getDtrbCoaInterCoCd());
			invoiceReq.setLDISTCOAFUTURE1         (invDtrbVO.getDtrbCoaFtuN1stCd());
			invoiceReq.setLDISTCOAFUTURE2         (invDtrbVO.getDtrbCoaFtuN2ndCd());
			invoiceReq.setLATTRIBUTECATEGORY      (invDtrbVO.getAttrCateNm      ());
			invoiceReq.setLATTRIBUTE1             (invDtrbVO.getAttrCtnt1       ());
			invoiceReq.setLATTRIBUTE2             (invDtrbVO.getAttrCtnt2       ());
			invoiceReq.setLATTRIBUTE3             (invDtrbVO.getAttrCtnt3       ());
			invoiceReq.setLATTRIBUTE4             (invDtrbVO.getAttrCtnt4       ());
			invoiceReq.setLATTRIBUTE5             (invDtrbVO.getAttrCtnt5       ());
			invoiceReq.setLATTRIBUTE6             (invDtrbVO.getAttrCtnt6       ());
			invoiceReq.setLATTRIBUTE7             (invDtrbVO.getAttrCtnt7       ());
			invoiceReq.setLATTRIBUTE8             (invDtrbVO.getAttrCtnt8       ());
			invoiceReq.setLATTRIBUTE9             (invDtrbVO.getAttrCtnt9       ());
			invoiceReq.setLATTRIBUTE10            (invDtrbVO.getAttrCtnt10      ());
			invoiceReq.setLATTRIBUTE11            (invDtrbVO.getAttrCtnt11      ());
			invoiceReq.setLATTRIBUTE12            (invDtrbVO.getAttrCtnt12      ());
			invoiceReq.setLATTRIBUTE13            (invDtrbVO.getAttrCtnt13      ());
			invoiceReq.setLATTRIBUTE14            (invDtrbVO.getAttrCtnt14      ());
			invoiceReq.setLATTRIBUTE15            (invDtrbVO.getAttrCtnt15      ());
			invoiceReq.setLBKGNO                  (invDtrbVO.getBkgNo           ());
			invoiceReq.setLCNTRTPSZ               (invDtrbVO.getCntrTpszCd      ());
			invoiceReq.setLACTVVD                 (invDtrbVO.getActVvdCd        ());
			invoiceReq.setLDIVCD                  (invDtrbVO.getPlnSctrDivCd    ());
			invoiceReq.setLCARRCD                 (invDtrbVO.getSoCrrCd         ());
			invoiceReq.setLYDCD                   (invDtrbVO.getYdCd            ());
			invoiceReq.setLFUTUREUSE1             (invDtrbVO.getFtuUseCtnt1     ());
			invoiceReq.setLFUTUREUSE2             (invDtrbVO.getFtuUseCtnt2     ());
			invoiceReq.setLFUTUREUSE3             (invDtrbVO.getFtuUseCtnt3     ());
			invoiceReq.setLFUTUREUSE4             (invDtrbVO.getFtuUseCtnt4     ());
			invoiceReq.setLFUTUREUSE5             (invDtrbVO.getFtuUseCtnt5     ());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * ERP : FNS012
	 * AR 데이터를 ERP로 Interface한다.<br>
	 * @param String csrNo
	 * @param List<ArMnChgVO> arMnChgVOs
	 * @throws DAOException
	 */
	public void sendSlipApprovalToAR(String csrNo, List<ArMnChgVO> arMnChgVOs) throws DAOException {
		
		TransferEAI transferEAI = null;
	    try {
			// 보낼 데이터
	        int listSize = arMnChgVOs.size();
	
			FNS0120001Document fns0120001Document = null;
            FNS0120001         fns0120001    	  = null;
            FNS0120001.DataArea dataArea    = null;
    		FNSINVCollection fnsINVCollection = null;    		
    		FNSINV invoiceReq = null;
    		String timeStamp = null;

    		for (int j=0; j<listSize; j++) {
        		
        		fns0120001Document = FNS0120001Document.Factory.newInstance();
        		fns0120001		   = fns0120001Document.addNewFNS0120001();

	            com.clt.irep.erp.EAIHeaderType headerType = fns0120001.addNewEAIHeader();
	            timeStamp = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
	    		headerType.setInstanceId("FNS0120001-" + timeStamp + "-" + arMnChgVOs.get(j).getArIfNo());
	    		
	    		dataArea = fns0120001.addNewDataArea();

	    		fnsINVCollection = dataArea.addNewFNSINVCollection();

	    		invoiceReq = fnsINVCollection.addNewFNSINV();

	    		setARData(invoiceReq, arMnChgVOs.get(j), timeStamp);
	        	
        		transferEAI = new WeblogicSendQClient(SubSystemConfigFactory.get("COM.INVJ.JMS.SEND.URL"), this.getClass());
                
    			transferEAI.setFactory(SubSystemConfigFactory.get("COM.INVJ.JMS.FACTORY")); 
    			transferEAI.setQueue(SubSystemConfigFactory.get("COM.INVJ.JMS.QUEUE"));  
    			transferEAI.setDestination("FNS012-0001");
    	        log.error("========================AR Interface Start===================================");
    	        log.error(fns0120001Document.toString());
    	        log.error("========================AR Interface End===================================");
    	        transferEAI.setMessage(fns0120001Document.toString()); 
    	        transferEAI.commit(headerType.getInstanceId());
	    			
	    		transferEAI.close();
	
	        }
	
		} catch (EAIException ex) {
			if(null != transferEAI)  transferEAI.rollback(ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * AR - EAI 연동시 해당 VO에 데이타를 셋팅한다.<br>
	 * @param FNSINV fnsINV
	 * @param ArMnChgVO arMnChgVO
	 * @param String timestamp
	 * @throws Exception
	 */
	private void setARData(FNSINV fnsINV, ArMnChgVO arMnChgVO, String timeStamp) throws Exception {
	
		try {
	
			fnsINV.setLIFID             ("FNS0120001");
			fnsINV.setSEQ               (timeStamp);
			fnsINV.setTOTALCOUNT        ("1");
			fnsINV.setROWCOUNT          ("1");
			fnsINV.setFLAG              ("C");
			
			//Header
			fnsINV.setMAINIFNO          (arMnChgVO.getArIfNo   ());
			fnsINV.setMAINIFSER         (arMnChgVO.getArIfSerNo());
			fnsINV.setBLNO              (arMnChgVO.getJoBlNo   ());
			fnsINV.setBLNOTP            ("");
			fnsINV.setBKGNO             ("");
			fnsINV.setSOURCE            (arMnChgVO.getArSrcCd  ());
			fnsINV.setTRANSTYP          ("SALAR");
			fnsINV.setINVNO             (arMnChgVO.getInvNo    ());
			fnsINV.setCANO              ("");
			fnsINV.setCADT              ("");
			fnsINV.setRHQ               (arMnChgVO.getRhqCd    ());
			fnsINV.setOFC               (arMnChgVO.getArOfcCd  ());
			fnsINV.setACTCNTRYCD        (arMnChgVO.getActCustCntCd());
			fnsINV.setACTCUSTCD         (arMnChgVO.getActCustSeq  ());
			fnsINV.setINVCNTRYCD        (arMnChgVO.getActCustCntCd());
			fnsINV.setINVCUSTCD         (arMnChgVO.getActCustSeq  ());
			fnsINV.setVSL               (arMnChgVO.getVslCd    ());
			fnsINV.setVOY               (arMnChgVO.getSkdVoyNo ());
			fnsINV.setDIR               (arMnChgVO.getSkdDirCd ());
			fnsINV.setTVVD              (arMnChgVO.getTrnkVslCd   ()+
										 arMnChgVO.getTrnkSkdVoyNo()+
										 arMnChgVO.getTrnkSkdDirCd());
			fnsINV.setREVVSL            (arMnChgVO.getRevVslCd   ());
			fnsINV.setREVVOY            (arMnChgVO.getRevSkdVoyNo());
			fnsINV.setREVDIR            (arMnChgVO.getRevSkdDirCd() + arMnChgVO.getRevDirCd   ());
			fnsINV.setSADT              (arMnChgVO.getSailArrDt  ());
			fnsINV.setPOR               (arMnChgVO.getPorCd());
			fnsINV.setPOL               (arMnChgVO.getPolCd());
			fnsINV.setPOD               (arMnChgVO.getPodCd());
			fnsINV.setDEL               (arMnChgVO.getDelCd());
			fnsINV.setSCP               ("");
			fnsINV.setLANE              (arMnChgVO.getSlanCd   ());
			fnsINV.setBND               (arMnChgVO.getIoBndCd  ());
			fnsINV.setCREDITMK          (arMnChgVO.getCustCrFlg());
			fnsINV.setSLSMANCD          ("");
			fnsINV.setDUEDT             (arMnChgVO.getDueDt  ());
			fnsINV.setUSDAMT            (arMnChgVO.getUsdAmt ());
			fnsINV.setLCLAMT            (arMnChgVO.getLoclAmt());
			fnsINV.setWHFDECNO          ("");
			fnsINV.setCTTDECNO          ("");
			fnsINV.setZONEIOC           (arMnChgVO.getZnIocCd());
			fnsINV.setIFFLAG            ("");
			fnsINV.setERPIFDT           ("");
			fnsINV.setINVCOACOMPANY     (arMnChgVO.getInvCoaCoCd  ());
			fnsINV.setINVCOAREGION      (arMnChgVO.getInvCoaRgnCd ());
			fnsINV.setINVCOACENTER      (arMnChgVO.getInvCoaCtrCd ());
			fnsINV.setINVCOAACCOUNT     (arMnChgVO.getInvCoaAcctCd());
			fnsINV.setINVCOAINTERCOMPANY(arMnChgVO.getInvCoaInterCoCd());
			fnsINV.setINVCOAVVD         (arMnChgVO.getInvCoaVslCd   ()+
					                     arMnChgVO.getInvCoaVoyNo   ()+
					                     arMnChgVO.getInvCoaSkdDirCd()+
					                     arMnChgVO.getInvCoaRevDirCd());
			fnsINV.setINVCOAFUTURE1     ("000000");
			fnsINV.setINVCOAFUTURE2     ("000000");
			fnsINV.setREVLANE           (arMnChgVO.getRlaneCd  ());
			fnsINV.setCONTNO            (arMnChgVO.getInvCtrtNo());
			fnsINV.setCREDITTERM        (arMnChgVO.getCrTermDys());
			fnsINV.setSAILINGDT         (arMnChgVO.getSailDt   ());
			fnsINV.setGLDT              (arMnChgVO.getGlDt     ());
			fnsINV.setEXRATETYPE        (arMnChgVO.getXchRtTpCd());
			fnsINV.setEXRATECUSTDATE    ("");
			fnsINV.setSETOFFNO          ("");
			fnsINV.setCUSTREFNO         ("");
			fnsINV.setTAXEXRATE         (arMnChgVO.getTaxXchRt());
			fnsINV.setTAXIND            ("0");
			fnsINV.setONBOARDDT         ("");
			fnsINV.setOBLMK             ("");
			fnsINV.setCTYCD             (arMnChgVO.getArLocCd  ());
			fnsINV.setSALESOFC          (arMnChgVO.getSlsOfcCd ());
			fnsINV.setRMK               (arMnChgVO.getInvRmk   ());
			fnsINV.setCURR              (arMnChgVO.getCurrCd   ());
			fnsINV.setUSERID            (arMnChgVO.getUsrId    ());
			fnsINV.setLOGRGSTDT         (arMnChgVO.getLogUpdDt ());
			fnsINV.setLOGUPDTDT         (arMnChgVO.getLogUpdDt ());
			fnsINV.setISSDT             (arMnChgVO.getIssDt    ());
			fnsINV.setSLIPNO            (arMnChgVO.getSlpNo    ());
			fnsINV.setJOIND             (arMnChgVO.getCsrOffstNo());
			
			//Detail
			fnsINV.setDTLIFNO           (arMnChgVO.getArIfNo    ());
			fnsINV.setDTLIFSER          (arMnChgVO.getArIfSerNo ());
			fnsINV.setCHGSEQ            (arMnChgVO.getChgSeq    ());
			fnsINV.setCHGTYP            (arMnChgVO.getChgCd     ());
			fnsINV.setREPCHGTYP         (arMnChgVO.getRepChgCd  ());
			fnsINV.setCHGCUR            (arMnChgVO.getCurrCd    ());
			fnsINV.setREVTYP            (arMnChgVO.getJoRevTpCd ());
			fnsINV.setCHGAMT            (arMnChgVO.getChgAmt    ());
			fnsINV.setTAXAMT            (arMnChgVO.getTaxAmt    ());
			fnsINV.setREVCOACOMPANY     (arMnChgVO.getRevCoaCoCd());
			fnsINV.setREVCOAREGION      (arMnChgVO.getRevCoaRgnCd());
			fnsINV.setREVCOACENTER      (arMnChgVO.getRevCoaCtrCd());
			fnsINV.setREVCOAACCOUNT     (arMnChgVO.getRevCoaAcctCd());
			fnsINV.setREVCOAINTERCOMPANY(arMnChgVO.getRevCoaInterCoCd());
			fnsINV.setREVCOAVVD         (arMnChgVO.getRevCoaVslCd   ()+
					                     arMnChgVO.getRevCoaVoyNo   ()+
					                     arMnChgVO.getRevCoaSkdDirCd()+
					                     arMnChgVO.getRevCoaDirCd   ());
			fnsINV.setREVCOAFUTURE1     ("000000");
			fnsINV.setREVCOAFUTURE2     ("000000");
			fnsINV.setORICHGCUR         (arMnChgVO.getCurrCd());
			fnsINV.setORICHGAMT         (arMnChgVO.getChgAmt());
			fnsINV.setREVEFFDT          ("");
			fnsINV.setPERTYP            ("");
			fnsINV.setRATE              (arMnChgVO.getChgAmt());
			fnsINV.setRATEDAS           ("1");
			fnsINV.setSOBID             (arMnChgVO.getSobId());
			fnsINV.setCHGFULLNM         (arMnChgVO.getChgFullNm());
			fnsINV.setACCT              (arMnChgVO.getAcctCd());
			fnsINV.setCNTRNO            ("");
			fnsINV.setCNTRTPSZ          ("");
			fnsINV.setRFANO             ("");
			fnsINV.setTHIRDEXRATETYPE   ("");
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
}
