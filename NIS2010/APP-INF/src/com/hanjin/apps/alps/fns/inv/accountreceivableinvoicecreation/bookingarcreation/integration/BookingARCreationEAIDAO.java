/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationEAIDAO.java
*@FileTitle : Invoice Update by User ID
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.01 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExRateCountVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.Fns0120001VO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration.ARInvoiceExRateMgtEAIDAO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.FlatFileAckVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.SendFlatFileVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.erp.FNS0120001Document;
import com.hanjin.irep.erp.FNS0120001Document.FNS0120001;
import com.hanjin.irep.erp.FNS0120001Document.FNS0120001.DataArea.FNSINVCollection;
import com.hanjin.irep.erp.FNS0120001Document.FNS0120001.DataArea.FNSINVCollection.FNSINV;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;
import com.jf.transfer.jms.send.vandor.WeblogicSendQClient;

/**
 * ALPS BookingARCreationEAIDAO <br>
 * - ALPS-BookingARCreation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Han Dong Hoon
 * @see BookingARCreationBCImpl 참조
 * @since J2EE 1.6
 */
public class BookingARCreationEAIDAO extends EAIDAOSupport{
	
	private transient Logger log = Logger.getLogger(ARInvoiceExRateMgtEAIDAO.class.getName());
	
	/**
	 * ERP : FNS0120001
	 * EAI 전송할 매출채권 정보를 XML 형식으로 변환하여 EAI 로 전송한다. <br>
	 * 
	 * @param List<Fns0120001VO> fns0120001VOs
	 * @exception EAIException
	 */
	public void interfaceARInvoiceToERPAR(List<Fns0120001VO> fns0120001VOs) throws EAIException {
		
		TransferEAI eai = null;
		//String transferMsg = "";
		
	    try {
			// 보낼 데이터
	        int listSize = fns0120001VOs.size();
	    	
        	for (int j=0; j<listSize; j++) {
        		
    			FNS0120001Document docReq		= FNS0120001Document.Factory.newInstance();
	            FNS0120001 fns0120001Req		= docReq.addNewFNS0120001();

	            String timeStamp = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
	            
	            com.hanjin.irep.erp.EAIHeaderType headerType = fns0120001Req.addNewEAIHeader();
	    		headerType.setInstanceId("FNS0120001-" + timeStamp + "-" + fns0120001VOs.get(j).getMainIfNo());
	    		
	    		FNS0120001.DataArea dataArea = fns0120001Req.addNewDataArea();

	    		FNSINVCollection invoiceCollReq = dataArea.addNewFNSINVCollection();

	    		FNSINV invoiceReq = invoiceCollReq.addNewFNSINV();
	    		
            	setARDatas(fns0120001VOs.get(j), invoiceReq);
	        	
        		eai = new WeblogicSendQClient(SubSystemConfigFactory.get("COM.INVJ.JMS.SEND.URL"), this.getClass());
        		
    	        eai.setFactory(SubSystemConfigFactory.get("COM.INVJ.JMS.FACTORY")); 
    	        eai.setQueue(SubSystemConfigFactory.get("COM.INVJ.JMS.QUEUE"));  

    	        eai.setMessage(docReq.toString()); 
    	        
    	        eai.setDestination("FNS012-0001");
    	        eai.commit(headerType.getInstanceId());
    		
//    	        log.error("    interfaceARInvoiceToERPAR FNS012-0001 Send : " + headerType.getInstanceId());
	        }
	
	    } catch(EAIException se) {
	    	log.error("=================================");
            log.error("    ORACLE EAI 연동 에러 코드    ");
            log.error("=================================");

            log.error("getTpErrCode   : "+se.getTpErrCode());
            log.error("getTpErrDetail : "+se.getTpErrDetail());
            log.error("getTpErrNo     : "+se.getTpErrNo());
            
            if(eai != null){
            	eai.rollback(se);
    	    }
	    	
	    	log.error(se.getMessage(),se);
	    	throw new EAIException(new ErrorHandler(se).getMessage());
	    } catch(Exception ex) {
	    	
	    	if(eai != null){
	    		eai.rollback(ex);
		    }

	    	log.error(ex.getMessage(),ex);
	    	throw new EAIException(new ErrorHandler(ex).getMessage());
	    }
	    
	    if(eai != null){
	    	eai.close();
	    }

	}	
	
	/**
	 * ERP : FNS0120001
	 * AR - EAI 연동시 해당 VO에 데이타를 셋팅한다. <br>
	 * 
	 * @param Fns0120001VO fns0120001VO
	 * @param FNSINV invoiceReq
	 * @exception Exception
	 */
	private void setARDatas(Fns0120001VO fns0120001VO, FNSINV invoiceReq) throws Exception {
	
		try {
			
			invoiceReq.setLIFID              (fns0120001VO.getLifid             ());
			invoiceReq.setSEQ                (fns0120001VO.getSeq               ());
			invoiceReq.setTOTALCOUNT         (fns0120001VO.getTotalCount        ());
			invoiceReq.setROWCOUNT           (fns0120001VO.getRowCount          ());
			invoiceReq.setFLAG               (fns0120001VO.getFlag              ());
			invoiceReq.setMAINIFNO           (fns0120001VO.getMainIfNo          ());
			invoiceReq.setMAINIFSER          (fns0120001VO.getMainIfSer         ());
			invoiceReq.setBLNO               (fns0120001VO.getBlNo              ());
			invoiceReq.setBLNOTP             (fns0120001VO.getBlNoTp            ());
			invoiceReq.setBKGNO              (fns0120001VO.getBkgNo             ());
			invoiceReq.setSOURCE             (fns0120001VO.getSource            ());
			invoiceReq.setTRANSTYP           (fns0120001VO.getTransTyp          ());
			invoiceReq.setINVNO              (fns0120001VO.getInvNo             ());
			invoiceReq.setCANO               (fns0120001VO.getCaNo              ());
			invoiceReq.setCADT               (fns0120001VO.getCaDt              ());
			invoiceReq.setRHQ                (fns0120001VO.getRhq               ());
			invoiceReq.setOFC                (fns0120001VO.getOfc               ());
			invoiceReq.setACTCNTRYCD         (fns0120001VO.getActCntryCd        ());
			invoiceReq.setACTCUSTCD          (fns0120001VO.getActCustCd         ());
			invoiceReq.setINVCNTRYCD         (fns0120001VO.getInvCntryCd        ());
			invoiceReq.setINVCUSTCD          (fns0120001VO.getInvCustCd         ());
			invoiceReq.setVSL                (fns0120001VO.getVsl               ());
			invoiceReq.setVOY                (fns0120001VO.getVoy               ());
			invoiceReq.setDIR                (fns0120001VO.getDir               ());
			invoiceReq.setTVVD               (fns0120001VO.getTVvd              ());
			invoiceReq.setREVVSL             (fns0120001VO.getRevVsl            ());
			invoiceReq.setREVVOY             (fns0120001VO.getRevVoy            ());
			invoiceReq.setREVDIR             (fns0120001VO.getRevDir            ());
			invoiceReq.setSADT               (fns0120001VO.getSaDt              ());
			invoiceReq.setPOR                (fns0120001VO.getPor               ());
			invoiceReq.setPOL                (fns0120001VO.getPol               ());
			invoiceReq.setPOD                (fns0120001VO.getPod               ());
			invoiceReq.setDEL                (fns0120001VO.getDel               ());
			invoiceReq.setSCP                (fns0120001VO.getScp               ());
			invoiceReq.setLANE               (fns0120001VO.getLane              ());
			invoiceReq.setBND                (fns0120001VO.getBnd               ());
			invoiceReq.setCREDITMK           (fns0120001VO.getCreditMk          ());
			invoiceReq.setSLSMANCD           (fns0120001VO.getSlsmanCd          ());
			invoiceReq.setDUEDT              (fns0120001VO.getDueDt             ());
			invoiceReq.setUSDAMT             (fns0120001VO.getUsdAmt            ());
			invoiceReq.setLCLAMT             (fns0120001VO.getLclAmt            ());
			invoiceReq.setWHFDECNO           (fns0120001VO.getWhfDecNo          ());
			invoiceReq.setCTTDECNO           (fns0120001VO.getCttDecNo          ());
			invoiceReq.setZONEIOC            (fns0120001VO.getZoneIoc           ());
			invoiceReq.setIFFLAG             (fns0120001VO.getIfFlag            ());
			invoiceReq.setERPIFDT            (fns0120001VO.getErpIfDt           ());
			invoiceReq.setINVCOACOMPANY      (fns0120001VO.getInvCoaCompany     ());
			invoiceReq.setINVCOAREGION       (fns0120001VO.getInvCoaRegion      ());
			invoiceReq.setINVCOACENTER       (fns0120001VO.getInvCoaCenter      ());
			invoiceReq.setINVCOAACCOUNT      (fns0120001VO.getInvCoaAccount     ());
			invoiceReq.setINVCOAINTERCOMPANY (fns0120001VO.getInvCoaInterCompany());
			invoiceReq.setINVCOAVVD          (fns0120001VO.getInvCoaVvd         ());
			invoiceReq.setINVCOAFUTURE1      (fns0120001VO.getInvCoaFuture1     ());
			invoiceReq.setINVCOAFUTURE2      (fns0120001VO.getInvCoaFuture2     ());
			invoiceReq.setREVLANE            (fns0120001VO.getRevLane           ());
			invoiceReq.setCONTNO             (fns0120001VO.getContNo            ());
			invoiceReq.setCREDITTERM         (fns0120001VO.getCreditTerm        ());
			invoiceReq.setSAILINGDT          (fns0120001VO.getSailingDt         ());
			invoiceReq.setGLDT               (fns0120001VO.getGlDt              ());
			invoiceReq.setEXRATETYPE         (fns0120001VO.getExRateType        ());
			invoiceReq.setEXRATECUSTDATE     (fns0120001VO.getExRateCustDate    ());
			invoiceReq.setSETOFFNO           (fns0120001VO.getSetoffNo          ());
			invoiceReq.setCUSTREFNO          (fns0120001VO.getCustRefNo         ());
			invoiceReq.setHJSREFNO           (fns0120001VO.getHjsRefNo          ());
			invoiceReq.setTAXEXRATE          (fns0120001VO.getTaxExRate         ());
			invoiceReq.setTAXIND             (fns0120001VO.getTaxInd            ());
			invoiceReq.setONBOARDDT          (fns0120001VO.getOnboardDt         ());
			invoiceReq.setOBLMK              (fns0120001VO.getOblMk             ());
			invoiceReq.setCTYCD              (fns0120001VO.getCtyCd             ());
			invoiceReq.setSALESOFC           (fns0120001VO.getSalesOfc          ());
			invoiceReq.setRMK                (fns0120001VO.getRmk               ());
			invoiceReq.setCURR               (fns0120001VO.getCurr              ());
			invoiceReq.setUSERID             (fns0120001VO.getUserId            ());
			invoiceReq.setLOGRGSTDT          (fns0120001VO.getLogRgstDt         ());
			invoiceReq.setLOGUPDTDT          (fns0120001VO.getLogUpdtDt         ());
			invoiceReq.setISSDT              (fns0120001VO.getIssDt             ());
			invoiceReq.setSLIPNO             (fns0120001VO.getSlipNo            ());
			invoiceReq.setJOIND              (fns0120001VO.getJoInd             ());
			invoiceReq.setDTLIFNO            (fns0120001VO.getDtlIfNo           ());
			invoiceReq.setDTLIFSER           (fns0120001VO.getDtlIfSer          ());
			invoiceReq.setCHGSEQ             (fns0120001VO.getChgSeq            ());
			invoiceReq.setCHGTYP             (fns0120001VO.getChgTyp            ());
			invoiceReq.setREPCHGTYP          (fns0120001VO.getRepChgTyp         ());
			invoiceReq.setCHGCUR             (fns0120001VO.getChgCur            ());
			invoiceReq.setREVTYP             (fns0120001VO.getRevTyp            ());
			invoiceReq.setCHGAMT             (fns0120001VO.getChgAmt            ());
			invoiceReq.setTAXAMT             (fns0120001VO.getTaxAmt            ());
			invoiceReq.setREVCOACOMPANY      (fns0120001VO.getRevCoaCompany     ());
			invoiceReq.setREVCOAREGION       (fns0120001VO.getRevCoaRegion      ());
			invoiceReq.setREVCOACENTER       (fns0120001VO.getRevCoaCenter      ());
			invoiceReq.setREVCOAACCOUNT      (fns0120001VO.getRevCoaAccount     ());
			invoiceReq.setREVCOAINTERCOMPANY (fns0120001VO.getRevCoaInterCompany());
			invoiceReq.setREVCOAVVD          (fns0120001VO.getRevCoaVvd         ());
			invoiceReq.setREVCOAFUTURE1      (fns0120001VO.getRevCoaFuture1     ());
			invoiceReq.setREVCOAFUTURE2      (fns0120001VO.getRevCoaFuture2     ());
			invoiceReq.setORICHGCUR          (fns0120001VO.getOriChgCur         ());
			invoiceReq.setORICHGAMT          (fns0120001VO.getOriChgAmt         ());
			invoiceReq.setREVEFFDT           (fns0120001VO.getRevEffDt          ());
			invoiceReq.setPERTYP             (fns0120001VO.getPerTyp            ());
			invoiceReq.setRATE               (fns0120001VO.getRate              ());
			invoiceReq.setRATEDAS            (fns0120001VO.getRatedAs           ());
			invoiceReq.setSOBID              (fns0120001VO.getSobId             ());
			invoiceReq.setCHGFULLNM          (fns0120001VO.getChgFullNm         ());
			invoiceReq.setACCT               (fns0120001VO.getAcct              ());
			invoiceReq.setCNTRNO             (fns0120001VO.getCntrNo            ());
			invoiceReq.setCNTRTPSZ           (fns0120001VO.getCntrTpSz          ());
			invoiceReq.setRFANO              (fns0120001VO.getRfaNo             ());
			invoiceReq.setTHIRDEXRATETYPE    (fns0120001VO.getThirdExRateType   ());
			
			invoiceReq.setWHFDECDT           (fns0120001VO.getWhfDecDt          ());
			invoiceReq.setWHFDECVVD          (fns0120001VO.getWhfDecVvd         ());
			invoiceReq.setWHFDECOFC          (fns0120001VO.getWhfDecOfc         ());
			invoiceReq.setWHFMRNNO           (fns0120001VO.getWhfMrnNo          ());
			invoiceReq.setWHFNTCNO           (fns0120001VO.getWhfNtcNo          ());
			invoiceReq.setWHFFLAG            (fns0120001VO.getWhfFlag           ());
			invoiceReq.setWHFCSRNO           (fns0120001VO.getWhfCsrNo          ());
			
			invoiceReq.setCTRTOFCCD          (fns0120001VO.getCtrtOfcCd         ());
			invoiceReq.setWHFDECLCXLFLG		 (fns0120001VO.getWhfDeclCxlFlg		()); 
			invoiceReq.setSIREFNO			 (fns0120001VO.getSiRefNo			()); 
			invoiceReq.setRTAPLYDT		 	 (fns0120001VO.getRtAplyDt			()); 
			invoiceReq.setCRINVNO		 	 (fns0120001VO.getCrInvNo			()); 
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EAIException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	/**
	 * ERP : FNS0120001
	 * AR - EAI 연동시 해당 VO에 데이타를 셋팅한다. <br>
	 * 
	 * @param SendFlatFileVO sendFlatFileVO
	 * @return FlatFileAckVO
	 * @exception Exception
	 */	
	public FlatFileAckVO sendTerminalInvoice(SendFlatFileVO sendFlatFileVO ) throws Exception {
		String reString = "";
		String integrationId = "INV" + (new SimpleDateFormat("yyMMddHHmmss")).format(new Date());
		
		String target = SubSystemConfigFactory.get("INV.IBMMQ.URL");
		String transfertype = SubSystemConfigFactory.get("INV.IBMMQ.TRANSFERTYPE");
		String channel = SubSystemConfigFactory.get("INV.IBMMQ.CHANNEL");
		String factory = SubSystemConfigFactory.get("INV.IBMMQ.FACTORY");
		String queue = sendFlatFileVO.getQueueNm();
		String targetclient = SubSystemConfigFactory.get("INV.IBMMQ.TARGETCLIENT");
		
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
				flatFileAckVO.setAckStsCd("A");
			else
				flatFileAckVO.setAckStsCd("E");

		} catch(EAIException se) {
			eai.rollback(se);
			log.error(se.getMessage(),se);
			throw new EAIException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			eai.rollback(ex);
			log.error(ex.getMessage(),ex);
			throw new EAIException(new ErrorHandler(ex).getMessage());
		}

		eai.close();
		return flatFileAckVO;
	}	
	
	/**
	 * FNS_INV_0027<br>
	 * 경리환율, VVD 환율 등 환율 정보과 없는 경우 해당 테이블의 환율을 읽어 일괄 Update 하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return List<ExRateCountVO>
	 * @exception EventException, DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExRateCountVO> getBackEndJobResutModifyExchangeRateList(String key) throws Exception, DAOException {
		try {
			return (List<ExRateCountVO>)BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 특정 Interface Data 에 대한 Booking Interface data 를 생성하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException, DAOException
	 */
	public String getBackEndJobResutCreateBKGInvoice(String key) throws Exception, DAOException {
		try {
			return (String)BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
