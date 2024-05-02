/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceEdiHitBCImpl.java
*@FileTitle : HIT INVOICE EDI RECEIVE, PDF FILE ATTACH  & ACK 
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-24
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2016-06-24 SHIN DONG IL
* 1.0 최초생성
=============================================================*/

package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.basic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration.InvoiceEdiHitDBDAO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration.InvoiceEdiHitEAIDAO;
import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.hanjin.framework.component.attachment.file.upload.FileUpload;
import com.hanjin.framework.component.attachment.file.upload.FileUploadException;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiRcvVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiRcvEqVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiRcvFileVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiAckLogVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiStsHisVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiErrLogVO;
import com.jf.transfer.TransferEAI;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.event.RcvInvEdiHitEvent;

/**
 * InvoiceEdiHitBCImpl
 * @author SHIN DONG IL 
 * @see 
 * @since J2EE 1.6
 */
public class InvoiceEdiHitBCImpl   extends BasicCommandSupport implements InvoiceEdiHitBC {
	// Database Access Object
	private transient InvoiceEdiHitDBDAO dbDao=null;
	/**
	 * dbDao Object 생성
	 */
	public InvoiceEdiHitBCImpl(){
		dbDao = new InvoiceEdiHitDBDAO();
	}
	

	/**
	 * 수신된 EDI F/F String을 VO에 셋팅한다.
	 * @param str
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse getInvoiceEdiFf(String str) throws EventException {
		log.error("\n================= InvoiceEdiHitBCImpl.getInvoiceEdiFf() Start =====================");
		String invNo ="";
		String invVndrSeq ="";
		String[] ediStr = str.split("\n");

		StringBuffer sbInv = new StringBuffer(); 
		StringBuffer sbSo = new StringBuffer();
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvEdiRcvVO invEdiRcvVO = new InvEdiRcvVO();
		InvEdiRcvEqVO invEdiRcvEqVO = new InvEdiRcvEqVO();;
		List<InvEdiRcvEqVO> invEdiRcvEqVOs = new ArrayList<InvEdiRcvEqVO>();
	
		try {
			/** F/F 데이터 추출하여 VO Setting	 **/
			log.error("\n================= InvoiceEdiHitBCImpl.getInvoiceEdiFf() ediStr.length:"+ediStr.length+"=====================");
			for( int i = 0; i<ediStr.length && ediStr.length > 0 ; i++){
				String[] itemStr = ediStr[i].split(":");
				log.error("\n================= InvoiceEdiHitBCImpl.getInvoiceEdiFf() ediStr["+i+"]"+ediStr[i]+"=====================");
				if( "$$$MSGSTART".equals(itemStr[0])){
					sbInv.append(ediStr[i]).append(CHR10);
  				    invEdiRcvVO.setSndrId("HIT");
					invEdiRcvVO.setRcvrId("HJS");	
				}else if( "{TRS_INV_EDI".equals(itemStr[0].replaceAll("[\r\n]", ""))){
					sbInv.append(ediStr[i]).append(CHR10);
				}else if( itemStr.length> 1 && "VNDR_SEQ".equals(itemStr[0])){
					sbInv.append(ediStr[i]).append(CHR10);
					if( itemStr[1].length() > 0){
						invEdiRcvVO.setInvVndrSeq((itemStr[1]).trim());	
						invVndrSeq = (itemStr[1]).trim();
					}
				}else if( itemStr.length> 1 && "INV_NO".equals(itemStr[0])){
					sbInv.append(ediStr[i]).append(CHR10);
					if( itemStr[1].length() > 0){
						invEdiRcvVO.setInvNo((itemStr[1]).trim());	
						invNo = (itemStr[1]).trim();
					}	
				}else if( itemStr.length> 1 && "CURR_CD".equals(itemStr[0])){
					sbInv.append(ediStr[i]).append(CHR10);
					if( itemStr[1].length() > 0){
						invEdiRcvVO.setInvCurrCd((itemStr[1]).trim());						
					}
				}else if( itemStr.length> 1 && "ATCH_TP_CD".equals(itemStr[0])){
					sbInv.append(ediStr[i]).append(CHR10);
					if( itemStr[1].length() > 0){
						invEdiRcvVO.setInvAtchTpId((itemStr[1]).trim());						
					}
				}else if( itemStr.length> 1 && "ISS_DT".equals(itemStr[0])){
					sbInv.append(ediStr[i]).append(CHR10);
					if( itemStr[1].length() > 0){
						invEdiRcvVO.setInvIssDt((itemStr[1]).trim());						
					}
				}else if( itemStr.length> 1 && "TTL_INV_AMT".equals(itemStr[0])){
					sbInv.append(ediStr[i]).append(CHR10);
					if( itemStr[1].length() > 0){
						invEdiRcvVO.setInvTtlAmt((itemStr[1]).trim());						
					}
				}else if( itemStr.length> 1 && "AMOUNT".equals(itemStr[0])){
					sbInv.append(ediStr[i]).append(CHR10);
					if( itemStr[1].length() > 0){
						invEdiRcvVO.setInvBzcAmt((itemStr[1]).trim());						
					}
				}else if( itemStr.length> 1 && "VAT_AMT".equals(itemStr[0])){
					sbInv.append(ediStr[i]).append(CHR10);
					if( itemStr[1].length() > 0){
						invEdiRcvVO.setInvVatAmt((itemStr[1]).trim());						
					}
				}else if( itemStr.length> 1 && "WHLD_TAX_AMT".equals(itemStr[0])){
					sbInv.append(ediStr[i]).append(CHR10);
					if( itemStr[1].length() > 0){
						invEdiRcvVO.setInvWhldTaxAmt((itemStr[1]).trim());						
					}
				}else if( "}TRS_INV_EDI".equals(itemStr[0].replaceAll("[\r\n]", ""))){
					sbInv.append(ediStr[i]).append(CHR10);
					invEdiRcvVO.setEdiMsg(sbInv.toString());
				}else if( "{TRS_INV_EDI_CNTR_LIST".equals(itemStr[0].replaceAll("[\r\n]", ""))){
					sbSo.append(ediStr[i]).append(CHR10);
					invEdiRcvEqVO.setInvNo(invNo);
					invEdiRcvEqVO.setInvVndrSeq(invVndrSeq);
				}else if( itemStr.length> 1 && "CNTR_NO".equals(itemStr[0])){
					sbSo.append(ediStr[i]).append(CHR10);
					if( itemStr[1].length() > 0){
						invEdiRcvEqVO.setEqNo((itemStr[1]).trim());
					}
				}else if( itemStr.length> 1 && "CNTR_STY_CD".equals(itemStr[0])){
					sbSo.append(ediStr[i]).append(CHR10);
					if( itemStr[1].length() > 0){
						invEdiRcvEqVO.setCgoTpCd((itemStr[1]).trim());
					}
				}else if( itemStr.length> 1 && "CNTR_TPSZ_CD".equals(itemStr[0])){
					sbSo.append(ediStr[i]).append(CHR10);
					if( itemStr[1].length() > 0){
						invEdiRcvEqVO.setEqTpszCd((itemStr[1]).trim());
					}	
				}else if( itemStr.length> 1 && "IO_BND_CD".equals(itemStr[0])){
					sbSo.append(ediStr[i]).append(CHR10);
					if( itemStr[1].length() > 0){
						invEdiRcvEqVO.setTrspBndCd((itemStr[1]).trim());
					}	
				}else if( itemStr.length> 1 && "SO_NUMBER".equals(itemStr[0])){
					sbSo.append(ediStr[i]).append(CHR10);
					if( itemStr.length == 2){
						if( itemStr[1].length() > 3){
							invEdiRcvEqVO.setTrspSoOfcCtyCd((itemStr[1].substring(0,3)).trim());  
							invEdiRcvEqVO.setTrspSoSeq((itemStr[1].substring(3,itemStr[1].length())).trim());
						}
					}
				}else if( itemStr.length> 1 && "WO_NUMBER".equals(itemStr[0])){
					sbSo.append(ediStr[i]).append(CHR10);
					if( itemStr.length == 2){
						if( itemStr[1].length() > 3){
							invEdiRcvEqVO.setTrspWoOfcCtyCd((itemStr[1].substring(0,3)).trim());  
							invEdiRcvEqVO.setTrspWoSeq((itemStr[1].substring(3,itemStr[1].length())).trim());
						}
					}      
				}else if("}TRS_INV_EDI_CNTR_LIST".equals(itemStr[0].replaceAll("[\r\n]", ""))){
					sbSo.append(ediStr[i]).append(CHR10);
					invEdiRcvEqVO.setEdiMsg(sbSo.toString());
					invEdiRcvEqVOs.add(invEdiRcvEqVO);
					invEdiRcvEqVO = new InvEdiRcvEqVO();
					sbSo = new StringBuffer();
				}
			}// for( int i = 0; i<ediStr.length; i++){ End !!!

			eventResponse.setCustomData("invEdiRcvVO",invEdiRcvVO);
			eventResponse.setRsVoList(invEdiRcvEqVOs);
			log.error("\n================= InvoiceEdiHitBCImpl.getInvoiceEdiFf() End =====================\n"  );
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new EventException(e.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Invoice EDI 수신한 F/F을 EDI 수신 테이블에 저장.
	 * @param invEdiRcvVO
	 * @param invEdiRcvEqVOs 
	 * @return String
	 * @exception EventException
	 */
	public String saveInvoiceEdi(InvEdiRcvVO invEdiRcvVO, List<InvEdiRcvEqVO> invEdiRcvEqVOs)throws EventException{
		String ediRcvSeq = "";
		log.error("\n================= InvoiceEdiHitBCImpl.saveInvoiceEdi() Start ====================="  );		
		try{
			ediRcvSeq =  dbDao.saveInvoiceEdi(invEdiRcvVO,invEdiRcvEqVOs);
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new EventException(e.getMessage());
		}
		log.error("\n================= InvoiceEdiHitBCImpl.saveInvoiceEdi() ediRcvSeq :"+ediRcvSeq+"====\n"  );
		log.error("\n================= InvoiceEdiHitBCImpl.saveInvoiceEdi() End ========================\n"  );		
		return ediRcvSeq;
	}
	
	/**
	 * EDI 수신 테이블에 저장된 Invoice validation check.
	 * @param ediRcvSeq
	 * @exception EventException
	 */
	public void validationInvEdi(String ediRcvSeq)throws EventException{
		try{
			log.error("\n================= InvoiceEdiHitBCImpl.validationInvEdi(String ediRcvSeq) Start =====================\n"  );
			log.error("\n================= InvoiceEdiHitBCImpl.validationInvEdi(String ediRcvSeq) ediRcvSeq:"+ediRcvSeq+"====\n"  );
			dbDao.validationInvEdi(ediRcvSeq);
			log.error("\n================= InvoiceEdiHitBCImpl.validationInvEdi(String ediRcvSeq) End =======================\n"  );					
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new EventException(e.getMessage());
		}
	}
	/**
	 * 본 테이블에 DATA SAVE(TRS_TRSP_INV_WRK, TRS_TRSP_SVC_ORD,TRS_TRSP_SO_HIS).
	 * @param invEdiRcvVO
	 * @param invEdiRcvEqVOs
	 * @exception EventException
	 */
	public void saveInvoice(InvEdiRcvVO invEdiRcvVO, List<InvEdiRcvEqVO> invEdiRcvEqVOs)throws EventException{
			
		try{
			log.error("\n================= InvoiceEdiHitBCImpl.saveInvoice(InvEdiRcvVO invEdiRcvVO, List<InvEdiRcvEqVO> invEdiRcvEqVOs) Start =====================\n"  );
			dbDao.saveInvoice(invEdiRcvVO,invEdiRcvEqVOs);
			log.error("\n================= InvoiceEdiHitBCImpl.saveInvoice(InvEdiRcvVO invEdiRcvVO, List<InvEdiRcvEqVO> invEdiRcvEqVOs) End =====================\n"  );			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * Invoice Ack 송신 
	 * @param invEdiRcvVO
	 * @return InvEdiAckLogVO
	 * @exception EventException
	 */
	public InvEdiAckLogVO makeInvoiceEdiAckFF(InvEdiRcvVO invEdiRcvVO)throws EventException{
		InvEdiAckLogVO invEdiAckLogVO = new InvEdiAckLogVO();
		try{
			log.error("\n================= InvoiceEdiHitBCImpl.saveInvoiceEdiAck(InvEdiRcvVO invEdiRcvVO) Start ==========================\n"  );
			invEdiAckLogVO = dbDao.saveInvoiceEdiAckLog(invEdiRcvVO);
			log.error("\n================= InvoiceEdiHitBCImpl.saveInvoiceEdiAck(InvEdiRcvVO invEdiRcvVO) makeInvEdiAckFF ================\n"  );
			invEdiAckLogVO = makeInvEdiAckFF(invEdiRcvVO,invEdiAckLogVO);
			log.error("\n================= InvoiceEdiHitBCImpl.saveInvoiceEdiAck(InvEdiRcvVO invEdiRcvVO) End ============================\n"  );
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new EventException(e.getMessage());
		}
		return invEdiAckLogVO;
	}
	/**
	 * ACK 대상 EDI invoice 대상 추출 및 F/F 조합 상세
	 * <중> 본 METHOD에서는 ACK전송단위(tesEdiAckSndLogVO)로 처리하게 되어있어서, 한 ACK전송단위에서 문제가 생겨도 LOG만 남기고 Exception을 던지지 않고,
	 * 		다음 ACK전송대상으로 makeFFAckEdiInv()에서 LOOP를 돌며 처리한다.
	 *  	Exception을 던지지 않아야 계속 돌 수 있다. 
	 * @param invEdiRcvVO
	 * @param invEdiAckLogVO 
	 * @return InvEdiAckLogVO
	 * @exception EventException
	 */
	public InvEdiAckLogVO makeInvEdiAckFF(InvEdiRcvVO invEdiRcvVO,InvEdiAckLogVO invEdiAckLogVO) {
		
		log.error("\n >>>>> Start - InvoiceEdiHitBCImpl - makeInvEdiAckFF <<<<< \n");
		
		String ackSendDt = "";
		String valFlg = "Y";
		String eqCount= "";
		String recDesc="ACKNOWLEDGMENT";
		
		try {

			if (invEdiAckLogVO != null){
				StringBuffer sbFf  = new StringBuffer();
				DBRowSet dbRowset = dbDao.searchInvEdiEqCount(invEdiRcvVO);
				while(dbRowset.next()){
					valFlg = dbRowset.getString("VAL_CHK_FLG");
					eqCount = dbRowset.getString("EQ_CNT");
				}
				
				if(valFlg.equals("N")){
					recDesc = "NEGATIVE ACKNOWLEDGMENT";
				}
				/** EDI MSG HDR **/
				ackSendDt =invEdiAckLogVO.getActSndDt();
				sbFf.append("$$$MSGSTART:" + 
							JSPUtil.getRPAD(invEdiAckLogVO.getSndrId(),20," ") +
							JSPUtil.getRPAD(invEdiAckLogVO.getRcvrId(),20," ") +
							JSPUtil.getRPAD("INVACK",10," ") +  
							("TRS" + ackSendDt.substring(2,8) +  JSPUtil.getLPAD(ackSendDt,5,"0"))).append(CHR10)
							;
				
				/** HEADER_RECORD **/
				sbFf.append("{HEADER_RECORD").append(CHR10);
				sbFf.append("HEADER_RECORD_CODE:AAA").append(CHR10);
				sbFf.append("RECORD_DESCRIPTION:"+recDesc).append(CHR10);
				sbFf.append("SENDER_ID:" + JSPUtil.getNull(invEdiAckLogVO.getSndrId())).append(CHR10);
				sbFf.append("RECIPIENT_ID:" + JSPUtil.getNull(invEdiAckLogVO.getRcvrId())).append(CHR10);
				
				if (ackSendDt!=null && !ackSendDt.trim().equals("") && ackSendDt.length()>=8){
					sbFf.append("FILE_CREATION_DATE:" + JSPUtil.getNull(ackSendDt.substring(0,8))).append(CHR10);
					sbFf.append("FILE_CREATION_TIME:" + JSPUtil.getNull(ackSendDt.substring(2,8))).append(CHR10);
				}
				sbFf.append("MESSAGE_TYPE:INVACK").append(CHR10);
				sbFf.append("SEQUENCE_NUMBER:" + JSPUtil.getLPAD(JSPUtil.getNull(invEdiAckLogVO.getFileSeq()),5,"0")).append(CHR10);
				sbFf.append("}HEADER_RECORD").append(CHR10);
				
				/** DETAIL_RECORD **/
				sbFf.append("{DETAIL_RECORD").append(CHR10);
				sbFf.append("DETAIL_RECORD_CODE:DDD").append(CHR10);
				sbFf.append("DOCUMENT_TYPE:O").append(CHR10);
				sbFf.append("DOCUMENT_NUMBER:" + JSPUtil.getNull(invEdiRcvVO.getInvNo())).append(CHR10);
				if (ackSendDt!=null && !ackSendDt.trim().equals("") && ackSendDt.length()>=8){
					sbFf.append("DOCUMENT_DATE:" + JSPUtil.getNull(ackSendDt.substring(0,8))).append(CHR10);
				}
				sbFf.append("TOTAL_NO_OF_ITEMS:").append("    ").append(CHR10);
				sbFf.append("TOTAL_NO_OF_AMOUNT:").append(JSPUtil.getLPAD(invEdiRcvVO.getInvTtlAmt(),13,"0")).append(CHR10);
				sbFf.append("}DETAIL_RECORD").append(CHR10);
				
				/** TRAILER_RECORD **/
				sbFf.append("{TRAILER_RECORD").append(CHR10);
				sbFf.append("TRAILER_RECORD_CODE:ZZZ").append(CHR10);
//				sbFf.append("TOTAL_NUMBER_OF_RECORDS:" + JSPUtil.getLPAD((InvEdiAckLogVO!=null&&InvEdiAckLogVO.size()>0?Integer.toString(tesEdiSoHdrVOLst.size()):"0"),4,"0")).append(CHR10);
				sbFf.append("TOTAL_NUMBER_OF_RECORDS:"+eqCount).append(CHR10);
				sbFf.append("}TRAILER_RECORD");
				
				log.error("\n >>>>> Start - InvoiceEdiHitBCImpl - makeInvEdiAckFF F/F:\n"+sbFf.toString()+"\n============End Ack F/F================== \n");	
//				if(sbFf != null && sbFf.length() > 0) {
				invEdiAckLogVO.setEdiMsg(sbFf.toString());

			}else{
				log.error("\n >>>>>InvoiceEdiHitBCImpl - makeInvEdiAckFF() invEdiAckLogVO is Null, INV_EDI_RCV_SEQ:\n"+invEdiRcvVO.getInvEdiRcvSeq()+"<<<<<<<<<<<<<<<\n");
				/** Error Log Save **/
				InvEdiErrLogVO invEdiErrLogVO= new InvEdiErrLogVO();
				invEdiErrLogVO.setInvEdiRcvSeq(invEdiRcvVO.getInvEdiRcvSeq());
				invEdiErrLogVO.setErrMsg("invEdiAckLogVO is Null");
				dbDao.saveInvEdiErrLog(invEdiErrLogVO);
			}
			log.error("\n >>>>> End - InvoiceEdiHitBCImpl - makeInvEdiAckFF <<<<< \n");								
		} catch(Exception ex){
			log.error(ex.getMessage());
		}
       return invEdiAckLogVO;

	}
	
	/**
	 * Invoice Ack 송신 
	 * @param invEdiRcvVO
	 * @param invEdiAckLogVO
	 * @exception EventException
	 */
	public void sendInvEdiAck(InvEdiRcvVO invEdiRcvVO,InvEdiAckLogVO invEdiAckLogVO)throws EventException{
		String retval ="";

		try{
			log.error("\n>>>>>>>>>>>>> InvoiceEdiHitBCImpl.sendInvEdiAck() Start <<<<<<<<<< \n");
			if(invEdiRcvVO!=null && invEdiAckLogVO!=null ){
				log.error("\n>>>>>>>>>>>>> InvoiceEdiHitBCImpl.sendInvEdiAck() INV_EDI_SND_LOG_SEQ:"+invEdiAckLogVO.getInvEdiSndLogSeq()+"<<<<<<<<<< \n");
				InvEdiStsHisVO invEdiStsHisVO = new InvEdiStsHisVO();
				log.error("\n>>>>>>>>>>>>> InvoiceEdiHitBCImpl.sendInvEdiAck() INV_EDI_RCV_SEQ:"+invEdiRcvVO.getInvEdiRcvSeq()+"<<<<<<<<<< \n");
				log.error("\n>>>>>>>>>>>>> InvoiceEdiHitBCImpl.sendInvEdiAck() INV_NO:"+invEdiRcvVO.getInvNo()+"<<<<<<<<<< \n");
				retval = new InvoiceEdiHitEAIDAO().sendEDIMQ(invEdiAckLogVO.getEdiMsg());
				log.error("\n>>>>>>>>>>>>> InvoiceEdiHitBCImpl.sendInvEdiAck() Inv EDI Ack Result retval:"+retval+"<<<<<<<<<< \n");	
				if (!retval.equals("") && retval.trim().equals("SUCCESS")){
					invEdiAckLogVO.setAckSndStsCd("S");
					invEdiAckLogVO.setEdiRmk(retval);
					dbDao.modifyInvEdiAckLog(invEdiAckLogVO);
					
					invEdiStsHisVO.setInvEdiRcvSeq(invEdiRcvVO.getInvEdiRcvSeq());
					invEdiStsHisVO.setInvNo(invEdiRcvVO.getInvNo());
					invEdiStsHisVO.setInvVndrSeq(invEdiRcvVO.getInvVndrSeq());
					invEdiStsHisVO.setInvEdiRcvStsId("A");
					dbDao.saveInvEdiStsHis(invEdiStsHisVO);
				}else{
					invEdiAckLogVO.setAckSndStsCd("E");
					invEdiAckLogVO.setEdiRmk(retval);
					dbDao.modifyInvEdiAckLog(invEdiAckLogVO);
					
					invEdiStsHisVO.setInvEdiRcvSeq(invEdiRcvVO.getInvEdiRcvSeq());
					invEdiStsHisVO.setInvVndrSeq(invEdiRcvVO.getInvVndrSeq());
					invEdiStsHisVO.setInvEdiRcvStsId("N");
					dbDao.saveInvEdiStsHis(invEdiStsHisVO);
					/** Error Log Save **/
					InvEdiErrLogVO invEdiErrLogVO= new InvEdiErrLogVO();
					invEdiErrLogVO.setInvEdiRcvSeq(invEdiRcvVO.getInvEdiRcvSeq());
					invEdiErrLogVO.setErrMsg("ACK Send Fail");
					dbDao.saveInvEdiErrLog(invEdiErrLogVO);
				}
			}else{
				log.error("\n>>>>>>>>>>>>> InvoiceEdiHitBCImpl.sendInvEdiAck() VO Error <<<<<<<<<< \n");
				/** Error Log Save **/
				InvEdiErrLogVO invEdiErrLogVO= new InvEdiErrLogVO();
				invEdiErrLogVO.setErrMsg("invEdiRcvVO OR invEdiAckLogVO is null ");
				dbDao.saveInvEdiErrLog(invEdiErrLogVO);
			}
			log.error("\n>>>>>>>>>>>>> InvoiceEdiHitBCImpl.sendInvEdiAck() End <<<<<<<<<< \n");
	
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * Invoice Ack 송신 
	 * @param invEdiErrLogVO
	 * @exception EventException
	 */
	public void saveInvEdiErrLog(InvEdiErrLogVO invEdiErrLogVO)throws EventException{
		try{
			if(invEdiErrLogVO!=null){
				dbDao.saveInvEdiErrLog(invEdiErrLogVO);
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new EventException(e.getMessage());
		}
	}	
	
	/**
	 * Invoice PDF File 송신 
	 * @param e
	 * @exception EventException
	 */
	public void receiveInvoicePdfFile(Event e)throws EventException {
//		EventResponse eventResponse = null;
		RcvInvEdiHitEvent event = (RcvInvEdiHitEvent)e;
		InvEdiRcvFileVO invEdiRcvFileVO = new InvEdiRcvFileVO();
		InvEdiRcvVO invEdiRcvVO = new InvEdiRcvVO();

		DBRowSet dbRowset 		= null;
		log.error("\n\n >>>>>>>>>>>>> InvoiceEdiHitBCImpl.receiveInvoiceEdiPdfFile() Start <<<<<<<<<< \n\n");	
		
//		  File sourceFile   = new File("D:aaa.pdf");
//		  int fileSize    = (int)sourceFile.length();
//		  byte[] fileBuffer       = new byte[fileSize];
//		  event.setFileBuf(fileBuffer);
//		  event.setFileNm("158002_15202297_CY_HJS.PDF");
		try {
			String fileNm = event.getFileNm();
			String[] fileNmSplit = null;
			String fileSaveId = "";
			String invVndrSeq = "";
			String invNo ="";
			String rjctRmk = "";
	
			TransferEAI eai = event.getEai();
			byte[] flbuf = event.getFileBuf();
	
			if(flbuf == null){
				if(eai != null){
					flbuf = eai.getByteMessage();
					log.error("\n>>>>>>>>>>>>> InvoiceEdiHitBCImpl.receiveInvoiceEdiPdfFile() flbuf.length:"+flbuf.length+"<<<<<<<<<<");	
				}
			}

			log.error("\n InvoiceEdiHitBCImpl.receiveInvoiceEdiPdfFile FileNm:"+(fileNm!=null&&!fileNm.equals("")?fileNm:"")+"<<<<<<<<<<");
			if (fileNm!=null && !fileNm.trim().equals("")){
				fileNmSplit =  fileNm.split("_");
				if (fileNmSplit!=null && fileNmSplit.length>=2){
					if (flbuf!=null){
						//NAS에 밀어넣기 + COM TABLE 저장까지
						FileUpload fileUpload = new FileUpload();
						fileSaveId = fileUpload.doUpload(flbuf, fileNm, "TRS");
						log.error("\n>>>>>>>>>>>>>InvoiceEdiHitBCImpl.receiveInvoiceEdiPdfFile() fileSaveId:"+fileSaveId+"<<<<<<<<<<");

						//TRS FILE TABLE에 기록 남기기
						if (fileSaveId!=null && !fileSaveId.trim().equals("")){
							//VNDR+INVNO 별로 유효성 확인 작업 여기서- 유효하지 않은 경우 DB상태 삭제 처리
							//VNDR+INVNO의 invoice가 존재하면 붙여준다. EDI나 정규 invoice가 될 수 있다.
							invVndrSeq 	= fileNmSplit!=null && fileNmSplit[0]!=null ? fileNmSplit[0] : "";
							invNo		= fileNmSplit!=null && fileNmSplit[1]!=null ? fileNmSplit[1] : "";
	
							log.error("\n>>>>>>>>>>>>>InvoiceEdiHitBCImpl.receiveInvoiceEdiPdfFile() invVndrSeq:"+invVndrSeq+" - invNo:"+invNo+"<<<<<\n");
//							log.debug("\n\n ## isVaildPDFNm:"+isVaildPDFNm+"<<<<########\n\n");

							log.debug("\n>>>>>>>>>>>>>InvoiceEdiHitBCImpl.receiveInvoiceEdiPdfFile() isVaildPDFNm  if ------------ \n\n");
							/**
							 * VNDR + INVNO.로 (EDI HDR와 INV HDR)를 뒤져서,
							 * 1)VNDR + INVNO.로 접수된 INVOICE가 없을 경우 그냥 EDI FILE TABLE에만 기록하고 통과한다.(나중에 해당 INVOICE가 접수할 경우 그쪽에서 땡겨간다.)  
							 * 2)이미 접수된 INVOICE가 복수개인 경우 오류로.. 
							 * 3)이미 접수된 INVOICE가 정상적으로 접수되어 있으면 해당 INVOICE의 KEY값으로  MAPPING을 해준다.
							 * 4)이미 접수된 INVOICE의 상태가 CONFIRM상태 이상인 경우는 해당 PDF FILE은 접수가 되면 안된다.
							 */
							invEdiRcvVO.setInvVndrSeq(invVndrSeq);
							invEdiRcvVO.setInvNo(invNo);
							invEdiRcvFileVO.setFileNm(fileNm);
							dbRowset = dbDao.searchEdiOrgInvoice(invEdiRcvVO, invEdiRcvFileVO);

							if (dbRowset!=null && dbRowset.next()){
								log.error("\n\n >>>>>>>>>>>>>InvoiceEdiHitBCImpl.receiveInvoiceEdiPdfFile() dbRowset NOT NULL ------------ \n\n");
								rjctRmk = rjctRmk + (rjctRmk!=null&&!rjctRmk.trim().equals("")?"|":"") + (dbRowset.getInt("INV_CNT")>1?"DUPLICATED INVOICES FOUND":"");
//									rjctRmk = rjctRmk + (rjctRmk!=null&&!rjctRmk.trim().equals("")?"|":"") + (dbRowset.getInt("ACC_STS")>0?"INVALID INVOICE STATUS":"");
								
								if (dbRowset.getInt("INV_CNT")==0){
									log.error("\n\n >>>>>>>>>>>>>InvoiceEdiHitBCImpl.receiveInvoiceEdiPdfFile() dbRowset INV_KNT==0 ------------ \n\n");
									/* 정상적인 기접수된 invoice정보가 없는 경우 -> 그냥 넣기만 하고 invoice mapping은 나중에 전문이 접수되는 시점에 하게 그냥 둔다. */
									/*  EDI file table에만 기록한다.  */
									invEdiRcvFileVO.setSavCfmFlg("Y");
									invEdiRcvFileVO.setFileRmk("WAITING");								
									invEdiRcvFileVO.setFileNm(fileNm);
									invEdiRcvFileVO.setFileSavId(fileSaveId);
									invEdiRcvFileVO.setInvNo(invNo);
									invEdiRcvFileVO.setInvVndrSeq(invVndrSeq);
									
									dbDao.saveInvEdiPdfFile(invEdiRcvFileVO);
								} else if (dbRowset.getInt("INV_CNT")==1){
									log.error("\n\n >>>>>>>>>>>>>InvoiceEdiHitBCImpl.receiveInvoiceEdiPdfFile() dbRowset INV_KNT==1 ------------ \n\n");
									/* 정상적인 기접수된 invoice정보가 존재하며, update수행 */
									invEdiRcvFileVO.setSavCfmFlg("Y");
									invEdiRcvFileVO.setFileRmk("");								
									invEdiRcvFileVO.setFileNm(fileNm);
									invEdiRcvFileVO.setFileSavId(fileSaveId);
									invEdiRcvFileVO.setInvNo(invNo);
									invEdiRcvFileVO.setInvVndrSeq(invVndrSeq);
									
									dbDao.saveInvEdiPdfFile(invEdiRcvFileVO);
								} else {
									log.error("\n\n -- >>>>>>>>>>>>>InvoiceEdiHitBCImpl.receiveInvoiceEdiPdfFile() dbRowset INV_KNT else ------------ \n\n");
									/* 비정상적인 기접수된 invoice정보가 존재하며, update취소 */
									invEdiRcvFileVO.setSavCfmFlg("N");
									invEdiRcvFileVO.setFileRmk(rjctRmk);
									invEdiRcvFileVO.setFileNm(fileNm);
									invEdiRcvFileVO.setFileSavId(fileSaveId);
									invEdiRcvFileVO.setInvNo(invNo);
									invEdiRcvFileVO.setInvVndrSeq(invVndrSeq);

									dbDao.saveInvEdiPdfFile(invEdiRcvFileVO);
								}
							} else {
								log.error("\n>>>>>>>>>>>>>InvoiceEdiHitBCImpl.receiveInvoiceEdiPdfFile()-- dbRowset NULL ------------ \n\n");
								/* 정상적인 기접수된 invoice정보가 없는 경우 -> 그냥 넣기만 하고 invoice mapping은 나중에 전문이 접수되는 시점에 하게 그냥 둔다. */
								/*  EDI file table에만 기록한다.  */
								invEdiRcvFileVO.setSavCfmFlg("Y");
								invEdiRcvFileVO.setFileRmk("WAITING");								
								invEdiRcvFileVO.setFileNm(fileNm);
								invEdiRcvFileVO.setFileSavId(fileSaveId);		
								invEdiRcvFileVO.setInvNo(invNo);
								invEdiRcvFileVO.setInvVndrSeq(invVndrSeq);									
								dbDao.saveInvEdiPdfFile(invEdiRcvFileVO);
							}

						} else {//if (fileSaveId!=null && !fileSaveId.trim().equals(""))
							log.error("\n>>>>>>>>>>>>>InvoiceEdiHitBCImpl.receiveInvoiceEdiPdfFile() ~~~ INVALID COMMON FILE_SAV_ID ~~~~~~~~~~~~~~~~~~~~  \n\n");
							//file_sav_id이 없으면 공통TABLE의 DATA는 어쩔 수 없다.
							//==>>다만 TES FILE TABLE에 FileNm으로만 오류 기록 남기기
							invEdiRcvFileVO.setFileNm(fileNm);
							invEdiRcvFileVO.setSavCfmFlg("N");
							invEdiRcvFileVO.setFileRmk("INVALID COMMON FILE_SAV_ID");
							invEdiRcvFileVO.setInvNo(invNo);
							invEdiRcvFileVO.setInvVndrSeq(invVndrSeq);		
							dbDao.saveInvEdiPdfFile(invEdiRcvFileVO);
						}
					} else {//if (flbuf!=null)
						log.error("\n>>>>>>>>>>>>>InvoiceEdiHitBCImpl.receiveInvoiceEdiPdfFile()~~~ FileBuf NULL Exception ~~~~~~~~~~~~~~~~~~~~  \n\n");
						// FileBuf NULL Exception
						invEdiRcvFileVO.setFileNm(fileNm);
						invEdiRcvFileVO.setSavCfmFlg("N");
						invEdiRcvFileVO.setFileRmk("FileBuf NULL Exception");
						invEdiRcvFileVO.setInvNo(invNo);
						invEdiRcvFileVO.setInvVndrSeq(invVndrSeq);		
						dbDao.saveInvEdiPdfFile(invEdiRcvFileVO);
					}
				} else {//if (fileNmSplit!=null && fileNmSplit.length>=2)
					log.error("\n>>>>>>>>>>>>>InvoiceEdiHitBCImpl.receiveInvoiceEdiPdfFile()~~~ INVALID EDI FILE NAME ~~~~~~~~~~~~~~~~~~~~  \n\n");
					//유효하지 않은 fileName -> 'VNDRCD_INVNO_...' 형태로 구분자로 '_'가 중간에 와야한다.
					invEdiRcvFileVO.setSavCfmFlg("N");
					invEdiRcvFileVO.setFileRmk("INVALID EDI FILE NAME");
					invEdiRcvFileVO.setInvNo(invNo);
					invEdiRcvFileVO.setInvVndrSeq(invVndrSeq);		
					dbDao.saveInvEdiPdfFile(invEdiRcvFileVO);
				}
			} else {//if (fileNm!=null && !fileNm.trim().equals(""))
				log.error("\n>>>>>>>>>>>>>InvoiceEdiHitBCImpl.receiveInvoiceEdiPdfFile() !!!!FileNm NULL!!!!!!!!!! \n");
				invEdiRcvFileVO.setSavCfmFlg("N");
				invEdiRcvFileVO.setFileRmk("FILE NAME IS NULL");
				dbDao.saveInvEdiPdfFile(invEdiRcvFileVO);
			}
			
			log.error("\n>>>>>>>>>>>>>InvoiceEdiHitBCImpl.receiveInvoiceEdiPdfFile() END >>>>>>>>>>>>>>>>");
		} catch (FileUploadException ef) {
			log.error(ef.getMessage());
			throw new EventException(ef.getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage());
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(ex.getMessage());
		}
//		return eventResponse;
	}

}
