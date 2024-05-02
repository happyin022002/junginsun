/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceEdiHitDBDAO.java
*@FileTitle : HIT INVOICE EDI RECEIVE, PDF FILE ATTACH & ACK 
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-24
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2016-06-24 SHIN DONG IL
* 1.0 최초생성
===============================================================*/

package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBC;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBCImpl;
import com.hanjin.apps.alps.esd.trs.common.trscommon.vo.TrsSOHistoryVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiRcvEqVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiRcvVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiRcvFileVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiAckLogVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiStsHisVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo.InvEdiErrLogVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * InvoiceEdiHitDBDAO
 * 
 * @author SHIN DONG IL
 * @see 
 * @since J2EE 1.6
 */
public class InvoiceEdiHitDBDAO extends DBDAOSupport {
	
	/**
	 * F/F을 EDI관련 테이블에 저장.
	 * @param invEdiRcvVO
	 * @param invEdiRcvEqVOs
	 * @return String
	 * @throws DAOException
	 */
	public String saveInvoiceEdi(InvEdiRcvVO invEdiRcvVO, List<InvEdiRcvEqVO> invEdiRcvEqVOs) throws DAOException {
		String ediRcvSeq = "";
		
		try {
				DBRowSet dRs = null;

				SQLExecuter sqlExe = new SQLExecuter("");
				Map<String, Object> paramInv = new HashMap<String, Object> ();
				Map<String, Object> paramInvEq = new HashMap<String, Object> ();
  			    Map<String, String> mapInvVO = invEdiRcvVO.getColumnValues();
				InvEdiRcvEqVO  invEdiRcvEqVO = new InvEdiRcvEqVO();  			   
				
				/** INVOICE EDI SEQUENCE 채번 ***/
				dRs = sqlExe.executeQuery(new InvoiceEdiHitDBDAOSearchInvEdiRcvSeqRSQL(), paramInv, paramInv);
				while(dRs.next()){
					ediRcvSeq = dRs.getString("EDI_RCV_SEQ");
				}
				paramInv.putAll(mapInvVO);
				paramInv.put("inv_edi_rcv_seq", ediRcvSeq);
				
				/** TRS_INV_EDI_RCV 테이블 INSERT ***/
				int resultInv = sqlExe.executeUpdate((ISQLTemplate) new InvoiceEdiHitDBDAOSaveInvEdiRcvCSQL() , paramInv, paramInv);
				if(resultInv == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to InvoiceEdiHitDBDAOSaveInvEdiRcvCSQL SQL");	
				
				/** TRS_INV_EDI_RCV_EQ 테이블 INSERT ***/
				for(int i=0; i<invEdiRcvEqVOs.size() && invEdiRcvEqVOs.size() > 0 ;i++){
					invEdiRcvEqVO.setInvEdiRcvSeq(ediRcvSeq);
					invEdiRcvEqVO.setInvNo(invEdiRcvEqVOs.get(i).getInvNo());
					invEdiRcvEqVO.setInvVndrSeq(invEdiRcvEqVOs.get(i).getInvVndrSeq());
					invEdiRcvEqVO.setTrspSoOfcCtyCd(invEdiRcvEqVOs.get(i).getTrspSoOfcCtyCd());
					invEdiRcvEqVO.setTrspSoSeq(invEdiRcvEqVOs.get(i).getTrspSoSeq());
					invEdiRcvEqVO.setTrspWoOfcCtyCd(invEdiRcvEqVOs.get(i).getTrspWoOfcCtyCd());
					invEdiRcvEqVO.setTrspWoSeq(invEdiRcvEqVOs.get(i).getTrspWoSeq());
					invEdiRcvEqVO.setCgoTpCd(invEdiRcvEqVOs.get(i).getCgoTpCd());
					invEdiRcvEqVO.setTrspBndCd(invEdiRcvEqVOs.get(i).getTrspBndCd());
					invEdiRcvEqVO.setEqTpszCd(invEdiRcvEqVOs.get(i).getEqTpszCd());
					invEdiRcvEqVO.setEqNo(invEdiRcvEqVOs.get(i).getEqNo());
					invEdiRcvEqVO.setEdiMsg(invEdiRcvEqVOs.get(i).getEdiMsg());	
					
					Map<String, String> mapInvEqVO = invEdiRcvEqVO.getColumnValues();
					paramInvEq.putAll(mapInvEqVO);
					
					int resultInvEq = sqlExe.executeUpdate((ISQLTemplate) new InvoiceEdiHitDBDAOSaveInvEdiRcvEqCSQL() , paramInvEq, paramInvEq);
					if(resultInvEq == Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to InvoiceEdiHitDBDAOSaveInvEdiRcvEqCSQL SQL");	
				}
				
				/** TRS_INV_EDI_STS_HIS 테이블 INSERT ***/
				paramInv.put("inv_edi_rcv_sts_id","R");
				int resultInvEdiStsHis = sqlExe.executeUpdate((ISQLTemplate) new InvoiceEdiHitDBDAOSaveInvEdiStsHisCSQL() , paramInv, paramInv);
				if(resultInvEdiStsHis == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to InvoiceEdiHitDBDAOSaveInvEdiStsHisCSQL SQL");	
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ediRcvSeq;	
	}
	
	/**
	 * EDI 수신 테이블에 저장된 Invoice validation check.
	 * @param ediRcvSeq
	 * @throws DAOException
	 */
	public void validationInvEdi(String ediRcvSeq) throws DAOException {
		
		try {
				DBRowSet dRsInv = null;
				DBRowSet dRsInvEq = null;
//				InvEdiRcvEqVO  invEdiRcvEqVO = new InvEdiRcvEqVO();
				SQLExecuter sqlExe = new SQLExecuter("");
				Map<String, Object> paramInv = new HashMap<String, Object> ();
				Map<String, Object> paramInvEq = new HashMap<String, Object> ();
				String invValChk ="";
				String invEqValChk ="";
  			   
				
				/** INVOICE EDI SEQUENCE 해당하는 TRS_INV_EDI_RCV 테이블 데이터 Validation check ***/
				paramInv.put("inv_edi_rcv_seq", ediRcvSeq);
				dRsInv = sqlExe.executeQuery(new InvoiceEdiHitDBDAOSearchValidationInvEdiRSQL(), paramInv, paramInv);
				while(dRsInv.next()){
					invValChk = dRsInv.getString("VAL_CHK");
				}
				
				if(invValChk.equals("Y")){
					paramInv.put("val_chk_flg", "Y");
					paramInv.put("val_rmk", "");
				}else{
					paramInv.put("val_chk_flg", "N");
					paramInv.put("val_rmk", invValChk);
				}
				/** TRS_INV_EDI_RCV 테이블 데이터 Validation 결과 Update ***/
				int resultInv = sqlExe.executeUpdate((ISQLTemplate) new InvoiceEdiHitDBDAOModifyInvEdiRcvValidUSQL() , paramInv, paramInv);
				if(resultInv == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to InvoiceEdiHitDBDAOModifyInvEdiRcvValidUSQL SQL");	
				
				/** TRS_INV_EDI_RCV_EQ 테이블 Validation Check 및 결과 업데이트  ***/
				dRsInvEq = sqlExe.executeQuery(new InvoiceEdiHitDBDAOSearchValidationInvEqEdiRSQL(), paramInv, paramInv);
				while(dRsInvEq.next()){
					invEqValChk = dRsInvEq.getString("VAL_CHK");
					
					paramInvEq.put("inv_edi_rcv_seq",ediRcvSeq);
					paramInvEq.put("inv_edi_rcv_sub_seq",dRsInvEq.getString("INV_EDI_RCV_SUB_SEQ"));
					
					if(invEqValChk.equals("Y")){
						paramInvEq.put("val_chk_flg", "Y");
						paramInvEq.put("val_rmk", "");
					}else{
						paramInvEq.put("val_chk_flg", "N");
						paramInvEq.put("val_rmk", invEqValChk);
						
						/** TRS_INV_EDI_RCV 테이블 데이터에 Validation 결과 Update ***/
						int resultInv2 = sqlExe.executeUpdate((ISQLTemplate) new InvoiceEdiHitDBDAOModifyInvEdiRcvValidUSQL() , paramInvEq, paramInvEq);
						if(resultInv2 == Statement.EXECUTE_FAILED)
							 throw new DAOException("Fail to (resultInv2)InvoiceEdiHitDBDAOModifyInvEdiRcvValidUSQL SQL");	
					}
					
					/** TRS_INV_EDI_RCV_EQ 테이블 Validation Update ***/
					int resultInvEq = sqlExe.executeUpdate((ISQLTemplate) new InvoiceEdiHitDBDAOModifyInvEdiRcvEqValidUSQL() , paramInvEq, paramInvEq);
					if(resultInvEq == Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to InvoiceEdiHitDBDAOModifyInvEdiRcvEqValidUSQL SQL");
				}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 본 테이블에 DATA SAVE(TRS_TRSP_INV_WRK, TRS_TRSP_SVC_ORD,TRS_TRSP_SO_HIS).
	 * @param invEdiRcvVO
	 * @param invEdiRcvEqVOs
	 * @throws DAOException
	 */
	public void saveInvoice(InvEdiRcvVO invEdiRcvVO, List<InvEdiRcvEqVO> invEdiRcvEqVOs) throws DAOException {

		try {
				TrsCommonBC commCommand =  new TrsCommonBCImpl();
				DBRowSet dRs = null;
				SQLExecuter sqlExe = new SQLExecuter("");
				Map<String, Object> paramInvWrk = new HashMap<String, Object> ();
				Map<String, Object> paramSo 	= new HashMap<String, Object> ();
				
				/** INVOICE Save(TRS_TRSP_INV_WRK) ***/
				String invNo 	  = invEdiRcvVO.getInvNo();
				String invVndrSeq = invEdiRcvVO.getInvVndrSeq();	
				String invDupFlg  = "N";
  			    paramInvWrk.put("inv_no", invNo);
  			    paramInvWrk.put("inv_vndr_seq",invVndrSeq);
  			    paramInvWrk.put("trsp_inv_aud_sts_cd","SV");
  			    paramInvWrk.put("wo_vndr_seq",invVndrSeq);
  				paramInvWrk.put("inv_curr_cd",invEdiRcvVO.getInvCurrCd());
  				paramInvWrk.put("inv_ttl_amt",invEdiRcvVO.getInvTtlAmt());
  				paramInvWrk.put("inv_vat_amt",invEdiRcvVO.getInvVatAmt());
  				paramInvWrk.put("inv_whid_tax_amt",invEdiRcvVO.getInvWhldTaxAmt());
  				paramInvWrk.put("inv_iss_dt",invEdiRcvVO.getInvIssDt());
  				paramInvWrk.put("inv_edi_rcv_seq",invEdiRcvVO.getInvEdiRcvSeq());
  				
  				/** EDI 수신받은 Invoice가 이미 존재하는지 확인  **/  				
				dRs = sqlExe.executeQuery(new InvoiceEdiHitDBDAOSearchInvDupChkRSQL(), paramInvWrk, paramInvWrk);
				while(dRs.next()){
					invDupFlg = dRs.getString("INV_DUP_FLG");
				}

				if(invDupFlg.equals("N")){
					/** TRS_TRSP_INV_WRK INSERT **/
					int resultInv = sqlExe.executeUpdate((ISQLTemplate) new InvoiceEdiHitDBDAOSaveInvoiceCSQL() , paramInvWrk, paramInvWrk);
					if(resultInv == Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to InvoiceEdiHitDBDAOSaveInvoiceCSQL SQL");	
					
					/** TRS_TRSP_SVC_ORD 테이블 INVOICE NO UPDATE ***/
					for(int i=0; i<invEdiRcvEqVOs.size() && invEdiRcvEqVOs.size() > 0 ;i++){
						paramSo.put("inv_curr_cd", invEdiRcvVO.getInvCurrCd());
						paramSo.put("inv_no", invNo);
						paramSo.put("inv_vndr_seq",invVndrSeq);
						paramSo.put("trsp_so_ofc_cty_cd", invEdiRcvEqVOs.get(i).getTrspSoOfcCtyCd());
						paramSo.put("trsp_so_seq",invEdiRcvEqVOs.get(i).getTrspSoSeq());
						paramSo.put("trsp_inv_act_sts_cd","O"); // Invoice 처리상태에 대한 구분코드값으로서 C(Confirm), O(Object) 값에 대한 코드
						paramSo.put("trsp_inv_calc_lgc_tp_cd","TM");
						paramSo.put("inv_xch_rt","1");
						
						int resultInvEq = sqlExe.executeUpdate((ISQLTemplate) new InvoiceEdiHitDBDAOSaveSvcOrdInvUSQL() , paramSo, paramSo);
						if(resultInvEq == Statement.EXECUTE_FAILED)
							 throw new DAOException("Fail to InvoiceEdiHitDBDAOSaveSvcOrdInvUSQL SQL");
						
						/** TRS_TRSP_SO_HIS 테이블 INSERT ***/
						TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();
						soHisVo.setTrspSoOfcCtyCd(invEdiRcvEqVOs.get(i).getTrspSoOfcCtyCd());
						soHisVo.setTrspSoSeq(invEdiRcvEqVOs.get(i).getTrspSoSeq());
						soHisVo.setTrspSoEvntCd("IS");
						soHisVo.setCreUsrId("HIT_INV_EDI");
						soHisVo.setCreOfcCd("HKGSC");
						commCommand.multiSoHistory(soHisVo);
					}
				}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Invoice Ack 송신 
	 * @param invEdiRcvVO
	 * @return InvEdiAckLogVO 
	 * @throws DAOException
	 */
	public InvEdiAckLogVO saveInvoiceEdiAckLog(InvEdiRcvVO invEdiRcvVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		Map<String, Object> param 	= new HashMap<String, Object> ();
		InvEdiAckLogVO invEdiAckLogVO = new InvEdiAckLogVO();
		DBRowSet dRs1 = null;
		DBRowSet dRs2 = null;
		DBRowSet dRs3 = null;
		
		try {	
				String 	ediRcvSeq  		= invEdiRcvVO.getInvEdiRcvSeq();
				String  invNo 	  		= invEdiRcvVO.getInvNo();
				String  invVndrSeq 		= invEdiRcvVO.getInvVndrSeq();
				String  invEdiSndYmd    = "";
				String  invEdiSndDt     = "";
				Integer  fileSeq     	= 0;
				Integer invEdiSndLogSeq = 0;
				
				log.error("\n=================saveInvoiceEdiAckLog(InvEdiRcvVO invEdiRcvVO) ediRcvSeq:"+ediRcvSeq+"==========================\n"  );

				param.put("inv_edi_rcv_seq"	,ediRcvSeq);
				param.put("inv_no"			,invNo);
				param.put("inv_vndr_seq"	,invVndrSeq);
				param.put("ack_snd_sts_cd"	,"A");
				param.put("rcvr_id"			,invEdiRcvVO.getRcvrId());
				param.put("sndr_id"			,invEdiRcvVO.getSndrId());
				
				/** 1.SEND INVOICE EDI LOG SAVE(TRS_INV_EDI_ACK_LOG) ***/
				dRs1 = sqlExe.executeQuery(new InvoiceEdiHitDBDAOSearchinvEdiAckSendDateRSQL(), param, param);
				while(dRs1.next()){
					invEdiSndYmd = dRs1.getString("ACK_SEND_YMD");
					invEdiSndDt = dRs1.getString("ACK_SEND_DT");
				}
				param.put("inv_edi_snd_dt",invEdiSndDt);
				log.error("\n================= InvoiceEdiHitBCImpl.saveInvoiceEdiAckLog(InvEdiRcvVO invEdiRcvVO) invEdiSndDt:"+invEdiSndDt+"==========================\n"  );
				dRs2 = sqlExe.executeQuery(new InvoiceEdiHitDBDAOSearchInvEdiAckLogSeqRSQL(), param, param);
				while(dRs2.next()){
					invEdiSndLogSeq = dRs2.getInt("INV_EDI_SND_LOG_SEQ");
				}

				param.put("inv_edi_snd_log_seq",invEdiSndLogSeq.toString());
				log.error("\n================= InvoiceEdiHitBCImpl.saveInvoiceEdiAckLog(InvEdiRcvVO invEdiRcvVO) invEdiSndLogSeq:"+invEdiSndLogSeq.toString()+"==========================\n"  );											   
				dRs3 = sqlExe.executeQuery(new InvoiceEdiHitDBDAOSearchInvEdiAckFileSeqRSQL(), param, param);
				while(dRs3.next()){
					fileSeq = dRs3.getInt("FILE_SEQ");
				}
				log.error("\n================= InvoiceEdiHitBCImpl.saveInvoiceEdiAckLog(InvEdiRcvVO invEdiRcvVO) fileSeq:"+fileSeq.toString()+"==========================\n"  );				
				invEdiAckLogVO.setInvEdiSndDt(invEdiSndYmd);
				invEdiAckLogVO.setInvEdiSndLogSeq(invEdiSndLogSeq.toString());
				invEdiAckLogVO.setAckSndStsCd("C");
				invEdiAckLogVO.setActSndDt(invEdiSndDt);
				invEdiAckLogVO.setSndrId(invEdiRcvVO.getRcvrId());
				invEdiAckLogVO.setRcvrId(invEdiRcvVO.getSndrId());
				invEdiAckLogVO.setFileSeq(fileSeq.toString());

				int resultLog = sqlExe.executeUpdate((ISQLTemplate) new InvoiceEdiHitDBDAOSaveInvoiceEdiAckLogCSQL() , param, param);
				if(resultLog == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to InvoiceEdiHitDBDAOSaveInvoiceEdiAckLogCSQL SQL");
				
				/** 2.SEND INVOICE EDI LOG LIST SAVE(TRS_INV_EDI_ACK_LOG_LIST) ***/
				int resultLogList = sqlExe.executeUpdate((ISQLTemplate) new InvoiceEdiHitDBDAOSaveInvoiceEdiAckLogListCSQL() , param, param);
				if(resultLogList == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to InvoiceEdiHitDBDAOSaveInvoiceEdiAckLogListCSQL SQL");
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return invEdiAckLogVO;
	}
	/**
	 * Invoice EDI Status History save 
	 * @param invEdiStsHisVO
	 * @throws DAOException
	 */
	public void saveInvEdiStsHis(InvEdiStsHisVO invEdiStsHisVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		Map<String, Object> param 	= new HashMap<String, Object> ();
		
		try {	
				Map<String, String> mapVO = invEdiStsHisVO.getColumnValues();
				param.putAll(mapVO);
				
				int resultInvEdiStsHis = sqlExe.executeUpdate((ISQLTemplate) new InvoiceEdiHitDBDAOSaveInvEdiStsHisCSQL() , param, param);
				if(resultInvEdiStsHis == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to saveInvEdiStsHis InvoiceEdiHitDBDAOSaveInvEdiStsHisCSQL SQL");
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	/**
	 * Invoice EDI PDF File 송신 
	 * @param invEdiRcvFileVO
	 * @throws DAOException
	 */
	public void saveInvEdiPdfFile(InvEdiRcvFileVO invEdiRcvFileVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		Map<String, Object> param 	= new HashMap<String, Object> ();
		
		try {	
				Map<String, String> mapVO = invEdiRcvFileVO.getColumnValues();
				param.putAll(mapVO);
				
				/** 1.SEND INVOICE EDI LOG LIST SAVE(TRS_INV_EDI_ACK_LOG_LIST) ***/
				int resultFile = sqlExe.executeUpdate((ISQLTemplate) new InvoiceEdiHitDBDAOSaveInvoicePdfFileCSQL() , param, param);
				if(resultFile == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to InvoiceEdiHitDBDAOSaveInvoicePdfFileCSQL SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * 수신한 Invoice EDI PDF File Validation  
	 * @param invEdiRcvVO
	 * @param invEdiRcvFileVO
	 * @return DBRowSet 
	 * @throws DAOException
	 */
	public DBRowSet searchEdiOrgInvoice(InvEdiRcvVO invEdiRcvVO,InvEdiRcvFileVO invEdiRcvFileVO) throws DAOException {
		DBRowSet 	dbRowset 		= null;
		SQLExecuter sqlExe 			= new SQLExecuter("");
		Map<String, Object> param 	= new HashMap<String, Object> ();
		
		try {	
				param.put("inv_no"			,invEdiRcvVO.getInvNo());
				param.put("inv_vndr_seq"	,invEdiRcvVO.getInvVndrSeq());
				param.put("file_nm"			,invEdiRcvFileVO.getFileNm());
				
				dbRowset = sqlExe.executeQuery(new InvoiceEdiHitDBDAOSearchEdiOrgInvRSQL(), param, param);
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}	
	
	/**
	 *  Invoice EDI Ack 발송시 Container 갯수와 EDI Validation 결과 조회.  
	 * @param invEdiRcvVO
	 * @return DBRowSet 
	 * @throws DAOException
	 */
	public DBRowSet searchInvEdiEqCount(InvEdiRcvVO invEdiRcvVO) throws DAOException {
		DBRowSet 	dbRowset 		= null;
		SQLExecuter sqlExe 			= new SQLExecuter("");
		Map<String, Object> param 	= new HashMap<String, Object> ();
		
		try {	
	
				param.put("inv_edi_rcv_seq"	,invEdiRcvVO.getInvEdiRcvSeq());
				
				dbRowset = sqlExe.executeQuery(new InvoiceEdiHitDBDAOSearchInvEdiEqCountRSQL(), param, param);
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}		

	/**
	 * Invoice EDI Ack Log Update 
	 * @param invEdiAckLogVO
	 * @throws DAOException
	 */
	public void modifyInvEdiAckLog(InvEdiAckLogVO invEdiAckLogVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		Map<String, Object> param 	= new HashMap<String, Object> ();
		
		try {	
				Map<String, String> mapVO = invEdiAckLogVO.getColumnValues();
				param.putAll(mapVO);
				
				/** 1.SEND INVOICE EDI LOG LIST SAVE(TRS_INV_EDI_ACK_LOG_LIST) ***/
				int resultFile = sqlExe.executeUpdate((ISQLTemplate) new InvoiceEdiHitDBDAOModifyInvoiceEdiAckLogUSQL() , param, param);
				if(resultFile == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to InvoiceEdiHitDBDAOModifyInvoiceEdiAckLogUSQL SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Invoice EDI Error Log Save 
	 * @param invEdiErrLogVO
	 * @throws DAOException
	 */
	public void saveInvEdiErrLog(InvEdiErrLogVO invEdiErrLogVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		Map<String, Object> param 	= new HashMap<String, Object> ();
		
		try {	
				Map<String, String> mapVO = invEdiErrLogVO.getColumnValues();
				param.putAll(mapVO);
				
				/** 1.SEND INVOICE EDI LOG LIST SAVE(TRS_INV_EDI_ACK_LOG_LIST) ***/
				int resultFile = sqlExe.executeUpdate((ISQLTemplate) new InvoiceEdiHitDBDAOSaveInvEdiErrLogCSQL() , param, param);
				if(resultFile == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to InvoiceEdiHitDBDAOSaveInvEdiErrLogCSQL SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
}
