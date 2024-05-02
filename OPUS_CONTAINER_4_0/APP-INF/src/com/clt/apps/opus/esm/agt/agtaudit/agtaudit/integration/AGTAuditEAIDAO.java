/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTAuditEAIDAO.java
*@FileTitle : Agent Commission AP Actual Interface and BUMHAN EDI Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-05
*@LastModifier : Junghyung_kim
*@LastVersion : 1.0
* 2007-01-05 Junghyung_kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.basic.BRKGAuditBCImpl;
import com.clt.bizcommon.erpcom.jms.integration.SendQueueEAIDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.syscommon.common.table.COM_APRO_RQST_ROUT;
import com.clt.syscommon.common.table.ComAproRqstRoutVO;
import com.clt.irep.enis.EAIHeaderType;
import com.clt.irep.enis.FNS0080003Document;
import com.clt.irep.enis.EAIHeaderType.Parameters;
import com.clt.irep.enis.EAIHeaderType.Parameters.Parameter;
import com.clt.irep.enis.FNS0080003Document.FNS0080003;
import com.clt.irep.enis.FNS0080003Document.FNS0080003.DataArea.APInvoiceCollection;
import com.clt.irep.enis.FNS0080003Document.FNS0080003.DataArea.APInvoiceCollection.APInvoiceRequest;
import com.clt.irep.enisEsm.ESM0620001Document;
import com.clt.irep.enisEsm.ESM0620001Document.ESM0620001;
import com.clt.irep.enisEsm.ESM0620001Document.ESM0620001.DataArea.ROWSETCollection;
import com.clt.irep.enisEsm.ESM0620001Document.ESM0620001.DataArea.ROWSETCollection.ROWRequest;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.WeblogicSendQClient;

/**
 * OPUS-agt에 대한 EAI 처리를 담당<br>
 * - OPUS-agt Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author Junghyung_kim
 * @see BRKGAuditBCImpl 참조
 * @since J2EE 1.4
 */
public class AGTAuditEAIDAO extends EAIDAOSupport {

	/**
	 * Web Service 연동 / 싱크<br>
	 * (ESM_AGT_017) Agent Commission 정산내역을 ERP AP로 인터페이스한다.<br>
	 * 모든 데이타를 한번에 연동 처리한다.<br>
	 * 
	 * @param String csrNo
	 * @param DBRowSet rowSet
	 * @param ComAproRqstRoutVO rout
	 * @return FNS0080003Document[] 인터페이스 리턴값
	 * @throws DAOException
	 */	
	public FNS0080003Document[] transferAtOnceAGT017ToEAIByWS(String csrNo, DBRowSet rowSet, ComAproRqstRoutVO rout) throws DAOException {

		FNS0080003Document[] docReq		= null;        
        int cnt = 1;	
		
		try {
			log.debug("\n\n WebService 연동 시작 : AGT017 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n\n");

			int rsCnt = 0;
			rowSet.last();
			rsCnt = rowSet.getRow();
			rowSet.beforeFirst();
			int quot = rsCnt/100;
			int sur  = rsCnt%100;
			int arr_leng = (sur>0?(quot+1):quot);
			docReq = new FNS0080003Document[arr_leng>0?arr_leng:1];
			log.info("\n docReq="+docReq.toString());
			log.info("\n AGT START CSRNO : "+csrNo+", FNS0080003Document[] - arr_leng:"+docReq.length+" <<<<\n");
			
            String instanceId = "";
            String timestamp  = "";
            
            EAIHeaderType headerType = null;
            Parameters params = null;
            Parameter param = null;

            FNS0080003 fNS0080003Req		= null;
            APInvoiceCollection invoiceCollReq	= null;
            APInvoiceRequest invoiceReq		= null;
            String startNo = "";
            String endNo = "";
            
			if(rowSet != null) { 
				for (int i=0; i<docReq.length; i++){
		            //InstanceId, target 설정
					if((i+1) < 10 ){
						startNo = "0" + (i+1);
					}else{
						startNo = ""+(i+1);
					}
					if(arr_leng < 10 ){
						if(arr_leng == 0){
							endNo = "01";
						}else{
							endNo = "0" + arr_leng;
						}						
					}else{
						endNo = "" + arr_leng;
					}
		            timestamp = (new SimpleDateFormat("yyMMddHHmm")).format(new Date());
		            instanceId = "FNS008-" + timestamp + "AGT" + csrNo+"("+startNo+"/"+endNo+")"; //2007.05.31 modify
		            log.info("InstanceId : "+ instanceId);
		            log.info("\n docReq[i]="+docReq);
		            docReq[i] = FNS0080003Document.Factory.newInstance();
		            fNS0080003Req = docReq[i].addNewFNS0080003();
		            headerType = fNS0080003Req.addNewEAIHeader();
		            headerType.setInstanceId(instanceId);
		            params = headerType.addNewParameters();
		            param = params.addNewParameter();
		            param.setStringValue("");
		            log.info("\n transferAtOnceAGT017ToEAIByWS == "+params);
		            log.info("\n transferAtOnceAGT017ToEAIByWS == "+param);
		            invoiceCollReq = fNS0080003Req.addNewDataArea().addNewAPInvoiceCollection();
		            log.info("\n invoiceCollReq="+invoiceCollReq);
		            cnt = 1; //reset cnt
					while (cnt<=100 && rowSet.next()) {
						invoiceReq = invoiceCollReq.addNewAPInvoiceRequest();
						log.info("\n invoiceReq====="+invoiceReq);
			            setInvoiceDatas(rowSet, invoiceReq, timestamp, rout);
			            cnt++;
					}
					log.info("\n ### CSR_NO:"+csrNo+"  /  docReq["+i+"].instanceId:"+instanceId +
							  "  /  docReq["+i+"].length:"+docReq[i].getFNS0080003().getDataArea().getAPInvoiceCollection().getAPInvoiceRequestArray().length+"  <<<<<<<<<<<<<<<<<<<<< \n");
				}
			}			

		} catch (EAIException e) {
			log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		
		return docReq;
	}
	
	/**
	 * EAI 연동시 해당 VO에 데이타를 셋팅한다.<br>
	 * 
	 * @param  DBRowSet rowSet
	 * @param  APInvoiceRequest invoiceReq
	 * @param  String timestamp
	 * @param  COM_APRO_RQST_ROUT rout
	 * @throws Exception
	 */
	private void setInvoiceDatas(DBRowSet rowSet, APInvoiceRequest invoiceReq, String timestamp, ComAproRqstRoutVO rout) throws Exception {

		String title_name = "";
		String usr_jb_tit_nm = "";
		String usr_nm = "";
		
		try {
			log.info("\n invoiceReq="+invoiceReq.toString());
			if (rowSet != null) {
				invoiceReq.setLIFID((String)rowSet.getString("IF_ID"));
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
//				invoiceReq.setHATTRIBUTE1((String)rowSet.getString("HDR_ATTR_CTNT1"));
				if(rout.getAproUsrJbTitNm() == null){
					
					usr_jb_tit_nm = "";
				}else{
					usr_jb_tit_nm = rout.getAproUsrJbTitNm();
				}
				
				if(rout.getAproUsrNm() == null){
					usr_nm = "";
				}else{
					usr_nm = rout.getAproUsrNm();
				}
				
				title_name = usr_jb_tit_nm + "/" + usr_nm;
				
				invoiceReq.setHATTRIBUTE1(title_name);
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
	 * JMS 연동 / 비동기<br>
	 * 범한EDI 전송용 (ESM_AGT_010,  ESM_AGT_036) Agent Commission 내역을 Request or Approval(Audit)시 OPUS로 인터페이스한다.<br>
	 * 모든 데이타를 한번에 연동 처리한다.<br>
	 * 
	 * @param DBRowSet rowSet
	 * @throws DAOException
	 */	
	public void transferChnPantoEDIIF(DBRowSet rowSet) throws DAOException {

		ESM0620001Document[] docReq		= null;        
        int cnt = 1;	
		
		try {
			log.debug("\n\n WebService 연동 시작 : AGT062 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n\n");

			int rsCnt = 0;
			rowSet.last();
			rsCnt = rowSet.getRow();
			rowSet.beforeFirst();
//			int quot = rsCnt/100;
//			int sur  = rsCnt%100;
			int arr_leng = (rsCnt>0?rsCnt:1);
			docReq = new ESM0620001Document[arr_leng];
			log.error("\n AGT START ESM0620001Document[] - arr_leng:"+docReq.length+" <<<<\n");
			
            String instanceId = "";
            String timestamp  = "";
            
            String bkgNo = "";
            String bkgNoSplit = "";
            String agnCd = "";
            String ioBndCd = "";
            String acTpCd = "";
            int acSeq = 0;
            
            com.clt.irep.enisEsm.EAIHeaderType headerType = null;
            com.clt.irep.enisEsm.EAIHeaderType.Parameters params = null;
            com.clt.irep.enisEsm.EAIHeaderType.Parameters.Parameter param = null;

            ESM0620001 eSM0620001Req			= null;
            ROWSETCollection invoiceCollReq	= null;
            ROWRequest invoiceReq			= null;
//            String startNo = "";
//            String endNo = "";
            
            TransferEAI eai 				= null;
			eai = new WeblogicSendQClient(SubSystemConfigFactory.get("COM.SENDJMS.URL"), SendQueueEAIDAO.class);
			eai.setFactory(SubSystemConfigFactory.get("COM.SENDJMS.FACTORY"));
			eai.setQueue(SubSystemConfigFactory.get("COM.SENDJMS.QUEUE"));
			eai.setJmsType("ESM062-0001");

			if(rowSet != null) { 
				for (int i=0; i<docReq.length; i++){
		            //InstanceId, target 설정
//					if((i+1) < 10 ){
//						startNo = "0" + (i+1);
//					}else{
//						startNo = ""+i+1;
//					}
//					if(arr_leng < 10 ){
//						if(arr_leng == 0){
//							endNo = "01";
//						}else{
//							endNo = "0" + arr_leng;
//						}						
//					}else{
//						endNo = "" + arr_leng;
//					}
		            timestamp = (new SimpleDateFormat("yyMMddHHmm")).format(new Date());
//		            instanceId = "ESM062-" + timestamp + "AGT" +"("+startNo+"/"+endNo+")"; //2007.05.31 modify
		            instanceId = "ESM062-" + timestamp + "AGT";
//		            log.error("InstanceId : "+ instanceId);
		            
		            docReq[i] = ESM0620001Document.Factory.newInstance();
		            eSM0620001Req = docReq[i].addNewESM0620001();
		            headerType = eSM0620001Req.addNewEAIHeader();
//		            
		            params = headerType.addNewParameters();
		            param = params.addNewParameter();
		            param.setStringValue("");		        
		            invoiceCollReq = eSM0620001Req.addNewDataArea().addNewROWSETCollection();
		            cnt = 1; //reset cnt
					if (rowSet.next()) {
						invoiceReq = invoiceCollReq.addNewROWRequest();
						this.setInvoiceDatasEDI(rowSet, invoiceReq);
						bkgNo = (String)rowSet.getString("bkg_no");
						bkgNoSplit = (String)rowSet.getString("bkg_no_split");
						agnCd = (String)rowSet.getString("agn_cd");
						ioBndCd = (String)rowSet.getString("io_bnd_cd");
						acTpCd = (String)rowSet.getString("ac_tp_cd");
						acSeq = rowSet.getInt("ac_seq");
			            cnt++;
					}
					instanceId = instanceId + "("+bkgNo+"/"+bkgNoSplit+"/"+agnCd+"/"+ioBndCd+"/"+acTpCd+"/"+""+acSeq+")";
					headerType.setInstanceId(instanceId);
					
					log.error("\n ### docReq["+i+"].instanceId:"+instanceId +
							  "  /  docReq["+i+"].length:"+docReq[i].getESM0620001().getDataArea().getROWSETCollection().getROWRequestArray().length+"  <<<<<<<<<<<<<<<<<<<<< \n");
					
					eai.setObj(docReq[i]);
					log.info(docReq[i]);
					eai.commit(headerType.getInstanceId());
				}
			}
			
		} catch (EAIException e) {
			log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		
	}
	
	/**
	 * EAI 연동시 해당 VO에 데이타를 셋팅한다.<br>
	 * 
	 * @param  DBRowSet rowSet
	 * @param  ROWRequest invoiceReq
	 * @throws Exception
	 */
	private void setInvoiceDatasEDI(DBRowSet rowSet, ROWRequest invoiceReq) throws Exception {
		
		try {
			if (rowSet != null) {
				invoiceReq.setEAISTS((String)rowSet.getString("eai_sts"));
				invoiceReq.setEAIDT((String)rowSet.getString("eai_dt"));
				invoiceReq.setCOMPANY((String)rowSet.getString("company"));
				invoiceReq.setBKGNO((String)rowSet.getString("bkg_no"));
				invoiceReq.setBKGNOSPLIT((String)rowSet.getString("bkg_no_split"));
				invoiceReq.setAGNCD((String)rowSet.getString("agn_cd"));
				invoiceReq.setIOBNDCD((String)rowSet.getString("io_bnd_cd"));
				invoiceReq.setACTPCD((String)rowSet.getString("ac_tp_cd"));
				invoiceReq.setACSEQ(""+rowSet.getInt("ac_seq"));
				invoiceReq.setCOMMPROCSTSCD((String)rowSet.getString("comm_proc_sts_cd"));
				invoiceReq.setCOMMPROCSTSRSN((String)rowSet.getString("comm_proc_sts_rsn"));
				invoiceReq.setVNDRCNTCD((String)rowSet.getString("vndr_cnt_cd"));
				invoiceReq.setVNDRSEQ(""+rowSet.getInt("vndr_seq"));
				invoiceReq.setACTCOMMAMT(""+rowSet.getDouble("act_comm_amt"));
				invoiceReq.setACTIFCOMMAMT(""+rowSet.getDouble("act_if_comm_amt"));
				invoiceReq.setACTLOCLCOMMAMT(""+rowSet.getDouble("act_locl_comm_amt"));
				invoiceReq.setACTIFLOCLCOMMAMT(""+rowSet.getDouble("act_if_locl_comm_amt"));
				invoiceReq.setCURRCD((String)rowSet.getString("curr_cd"));
				invoiceReq.setXCHRT(""+rowSet.getDouble("xch_rt"));
				invoiceReq.setCREUSRID((String)rowSet.getString("cre_usr_id"));
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}
		
}