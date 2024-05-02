/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTAuditEAIDAO.java
*@FileTitle : Agent Commission AP Actual Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-05
*@LastModifier : Junghyung_kim
*@LastVersion : 1.0
* 2007-01-05 Junghyung_kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.integration ;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnCSRINFtoAPVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.basic.BRKGAuditBCImpl;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.irep.enis.EAIHeaderType;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.irep.enis.EAIHeaderType.Parameters;
import com.hanjin.irep.enis.EAIHeaderType.Parameters.Parameter;
import com.hanjin.irep.enis.FNS0080003Document.FNS0080003;
import com.hanjin.irep.enis.FNS0080003Document.FNS0080003.DataArea.APInvoiceCollection;
import com.hanjin.irep.enis.FNS0080003Document.FNS0080003.DataArea.APInvoiceCollection.APInvoiceRequest;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;
import com.jf.transfer.eai.exception.EAIException;

/**
 * eNIS-agt에 대한 EAI 처리를 담당<br>
 * - eNIS-agt Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author Junghyung_kim
 * @see BRKGAuditBCImpl 참조
 * @since J2EE 1.4
 */
public class FFCmpnApprovalEAIDAO extends EAIDAOSupport {

	/**
	 * Web Service 연동 / 싱크<br>
	 * (ESM_AGT_017) Agent Commission 정산내역을 ERP AP로 인터페이스한다.<br>
	 * 모든 데이타를 한번에 연동 처리한다.<br>
	 * 
	 * @param String csrNo
	 * @param DBRowSet rowSet
	 * @param ComAproRqstRoutVO rout
	 * @return FNS0080003Document[]
	 * @throws DAOException
	 */	
	public FNS0080003Document[] transferAtOnceFFToEAIByWS(String csrNo, DBRowSet rowSet, ComAproRqstRoutVO rout) throws DAOException {

		FNS0080003Document[] docReq		= null;        
        int cnt = 1;
		
		try {
			log.debug("\n\n WebService 연동 시작 : ACM018 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n\n");

			int rsCnt = 0;
			rowSet.last();
			rsCnt = rowSet.getRow();
			rowSet.beforeFirst();
			int quot = rsCnt/100;
			int sur  = rsCnt%100;
			int arr_leng = (sur>0?(quot+1):quot);
			docReq = new FNS0080003Document[arr_leng>0?arr_leng:1];
			log.error("\n ACM(BROKERAGE) START CSRNO : "+csrNo+", FNS0080003Document[] - arr_leng:"+docReq.length+" <<<<\n");
			
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
		            instanceId = "FNS008-" + timestamp + "ACM" + csrNo+"("+startNo+"/"+endNo+")"; //2007.05.31 modify
		            log.error("InstanceId : "+ instanceId);
		            
		            docReq[i] = FNS0080003Document.Factory.newInstance();
		            fNS0080003Req = docReq[i].addNewFNS0080003();
		            headerType = fNS0080003Req.addNewEAIHeader();
		            headerType.setInstanceId(instanceId);
		            params = headerType.addNewParameters();
		            param = params.addNewParameter();
		            param.setStringValue("");
		        
		            invoiceCollReq = fNS0080003Req.addNewDataArea().addNewAPInvoiceCollection();
		            cnt = 1; //reset cnt
					while (cnt<=100 && rowSet.next()) {
						invoiceReq = invoiceCollReq.addNewAPInvoiceRequest();
			            setInvoiceDatas(rowSet, invoiceReq, timestamp, rout);
			            cnt++;
					}
					log.error("\n ### CSR_NO:"+csrNo+"  /  docReq["+i+"].instanceId:"+instanceId +
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
			if (rowSet != null) {
				invoiceReq.setLIFID((String)rowSet.getString("LIF_ID"));
//				invoiceReq.setLIFID((String)rowSet.getString("IF_ID"));
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
	 * Web Service 연동 / 싱크<br>
	 * (ESM_ACM_0030) Agent Commission 정산내역을 ERP AP로 인터페이스한다.<br>
	 * 모든 데이타를 한번에 연동 처리한다.<br>
	 * 
	 * @param String csrNo
	 * @param ComAproRqstRoutVO routInfo
	 * @param List<FFCmpnCSRINFtoAPVO> ffCmpnCSRINFtoAPVOs
	 * @return FNS0080003Document[]
	 * @throws DAOException
	 */	
	public FNS0080003Document[] transferAtOnceACMToEAIByWS(String csrNo, ComAproRqstRoutVO routInfo, List<FFCmpnCSRINFtoAPVO> ffCmpnCSRINFtoAPVOs) throws DAOException {

		FNS0080003Document[] docReq		= null;        
        int cnt = 1;
		
		try {
			log.debug("\n\n WebService 연동 시작 : ACM0030 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n\n");

			int voCnt = ffCmpnCSRINFtoAPVOs.size();
//			rowSet.last();
//			rsCnt = rowSet.getRow();
//			rowSet.beforeFirst();
			int quot = voCnt/100;
			int sur  = voCnt%100;
			int arr_leng = (sur>0?(quot+1):quot);
			docReq = new FNS0080003Document[arr_leng>0?arr_leng:1];
			log.error("\n ACM(BROKERAGE) START CSRNO : "+csrNo+", FNS0080003Document[] - arr_leng:"+docReq.length+" <<<<\n");
			
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
            
			if(ffCmpnCSRINFtoAPVOs != null) { 
				for (int i=0; i<ffCmpnCSRINFtoAPVOs.size(); i++) {
		            //InstanceId, target 설정
					if((i+1) < 10 ) {
						startNo = "0" + (i+1);
					} else {
						startNo = "" + (i+1);
					}
					if(arr_leng < 10 ) {
						if(arr_leng == 0){
							endNo = "01";
						}else{
							endNo = "0" + arr_leng;
						}
					} else {
						endNo = "" + arr_leng;
					}
		            timestamp = (new SimpleDateFormat("yyMMddHHmm")).format(new Date());
		            instanceId = "FNS008-" + timestamp + "ACM" + csrNo+"("+startNo+"/"+endNo+")";
		            log.error("InstanceId : "+ instanceId);

		            docReq[i] = FNS0080003Document.Factory.newInstance();
		            fNS0080003Req = docReq[i].addNewFNS0080003();
		            headerType = fNS0080003Req.addNewEAIHeader();
		            headerType.setInstanceId(instanceId);
		            params = headerType.addNewParameters();
		            param = params.addNewParameter();
		            param.setStringValue("");

		            invoiceCollReq = fNS0080003Req.addNewDataArea().addNewAPInvoiceCollection();
		            cnt = 1; //reset cnt
					while (cnt<=100 && ffCmpnCSRINFtoAPVOs.get(cnt) != null) {
						invoiceReq = invoiceCollReq.addNewAPInvoiceRequest();
			            setInvoiceDatas( ffCmpnCSRINFtoAPVOs.get(cnt), invoiceReq, timestamp, routInfo);
			            cnt++;
					}
					log.error("\n ### CSR_NO:"+csrNo+"  /  docReq["+i+"].instanceId:"+instanceId +
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
	 * @param  FFCmpnCSRINFtoAPVO ffCmpnCSRINFtoAPVO
	 * @param  APInvoiceRequest invoiceReq
	 * @param  String timestamp
	 * @param  ComAproRqstRoutVO routInfo
	 * @throws Exception
	 */
	private void setInvoiceDatas( FFCmpnCSRINFtoAPVO ffCmpnCSRINFtoAPVO, APInvoiceRequest invoiceReq, String timestamp, ComAproRqstRoutVO routInfo) throws Exception {

		String title_name = "";
		String usr_jb_tit_nm = "";
		String usr_nm = "";
		
		try {
			if (ffCmpnCSRINFtoAPVO != null) {
				invoiceReq.setLIFID(ffCmpnCSRINFtoAPVO.getLifId());
				invoiceReq.setSEQ(timestamp);		
				invoiceReq.setTOTALCOUNT(ffCmpnCSRINFtoAPVO.getTtlRowKnt());
				invoiceReq.setROWCOUNT(ffCmpnCSRINFtoAPVO.getRowKnt());
				invoiceReq.setHCSRNUMBER(ffCmpnCSRINFtoAPVO.getHdrCsrNo());
				invoiceReq.setHCSRTYPE(ffCmpnCSRINFtoAPVO.getHdrCsrTpCd());
				invoiceReq.setHINVOICEDATE(ffCmpnCSRINFtoAPVO.getHdrInvDt());
				invoiceReq.setHTERMSDATE(ffCmpnCSRINFtoAPVO.getHdrInvTermDt());
				invoiceReq.setHGLDATE(ffCmpnCSRINFtoAPVO.getHdrGlDt());
				invoiceReq.setHVENDORNO(ffCmpnCSRINFtoAPVO.getHdrVndrNo());
				invoiceReq.setHCSRAMOUNT(ffCmpnCSRINFtoAPVO.getHdrCsrAmt());
				invoiceReq.setHPAYMENTAMOUNT(ffCmpnCSRINFtoAPVO.getHdrPayAmt());
				invoiceReq.setHPAYMENTDATE(ffCmpnCSRINFtoAPVO.getHdrPayDt());
				invoiceReq.setHCSRCURRENCYCODE(ffCmpnCSRINFtoAPVO.getHdrCsrCurrCd());
				invoiceReq.setHTERMSNAME(ffCmpnCSRINFtoAPVO.getHdrVndrTermNm());
				invoiceReq.setHDESCRIPTION(ffCmpnCSRINFtoAPVO.getHdrInvDesc());
				invoiceReq.setHATTRIBUTECATEGORY(ffCmpnCSRINFtoAPVO.getHdrAttrCateNm());
				if(routInfo.getAproUsrJbTitNm() == null) {
					usr_jb_tit_nm = "";
				} else {
					usr_jb_tit_nm = routInfo.getAproUsrJbTitNm();
				}
				
				if(routInfo.getAproUsrNm() == null) {
					usr_nm = "";
				} else {
					usr_nm = routInfo.getAproUsrNm();
				}
				
				title_name = usr_jb_tit_nm + "/" + usr_nm;
				
				invoiceReq.setHATTRIBUTE1(title_name);
				invoiceReq.setHATTRIBUTE2(ffCmpnCSRINFtoAPVO.getHdrAttrCtnt2());
				invoiceReq.setHATTRIBUTE3(ffCmpnCSRINFtoAPVO.getHdrAttrCtnt3());
				invoiceReq.setHATTRIBUTE4(ffCmpnCSRINFtoAPVO.getHdrAttrCtnt4());
				invoiceReq.setHATTRIBUTE5(ffCmpnCSRINFtoAPVO.getHdrAttrCtnt5());
				invoiceReq.setHATTRIBUTE6(ffCmpnCSRINFtoAPVO.getHdrAttrCtnt6());
				invoiceReq.setHATTRIBUTE7(ffCmpnCSRINFtoAPVO.getHdrAttrCtnt7());
				invoiceReq.setHATTRIBUTE8(ffCmpnCSRINFtoAPVO.getHdrAttrCtnt8());
				invoiceReq.setHATTRIBUTE9(ffCmpnCSRINFtoAPVO.getHdrAttrCtnt9());
				invoiceReq.setHATTRIBUTE10(ffCmpnCSRINFtoAPVO.getHdrAttrCtnt10());
				invoiceReq.setHATTRIBUTE11(ffCmpnCSRINFtoAPVO.getHdrAttrCtnt11());
				invoiceReq.setHATTRIBUTE12(ffCmpnCSRINFtoAPVO.getHdrAttrCtnt12());
				invoiceReq.setHATTRIBUTE13(ffCmpnCSRINFtoAPVO.getHdrAttrCtnt13());
				invoiceReq.setHATTRIBUTE14(ffCmpnCSRINFtoAPVO.getHdrAttrCtnt14());
				invoiceReq.setHATTRIBUTE15(ffCmpnCSRINFtoAPVO.getHdrAttrCtnt15());
				invoiceReq.setHGLOBALATTRIBUTE1(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt1());
				invoiceReq.setHGLOBALATTRIBUTE2(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt2());
				invoiceReq.setHGLOBALATTRIBUTE3(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt3());
				invoiceReq.setHGLOBALATTRIBUTE4(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt4());
				invoiceReq.setHGLOBALATTRIBUTE5(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt5());
				invoiceReq.setHGLOBALATTRIBUTE6(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt6());
				invoiceReq.setHGLOBALATTRIBUTE7(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt7());
				invoiceReq.setHGLOBALATTRIBUTE8(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt8());
				invoiceReq.setHGLOBALATTRIBUTE9(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt9());
				invoiceReq.setHGLOBALATTRIBUTE10(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt10());
				invoiceReq.setHGLOBALATTRIBUTE11(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt11());
				invoiceReq.setHGLOBALATTRIBUTE12(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt12());
				invoiceReq.setHGLOBALATTRIBUTE13(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt13());
				invoiceReq.setHGLOBALATTRIBUTE14(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt14());
				invoiceReq.setHGLOBALATTRIBUTE15(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt15());
				invoiceReq.setHGLOBALATTRIBUTE16(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt16());
				invoiceReq.setHGLOBALATTRIBUTE17(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt17());
				invoiceReq.setHGLOBALATTRIBUTE18(ffCmpnCSRINFtoAPVO.getHdrGloAttrCtnt18());
				invoiceReq.setHSOURCE(ffCmpnCSRINFtoAPVO.getHdrSrcCtnt());
				invoiceReq.setHPAYMENTMETHODLOOKUPCODE(ffCmpnCSRINFtoAPVO.getHdrPayMzdLuCd());
				invoiceReq.setHPAYGROUPLOOKUPCODE(ffCmpnCSRINFtoAPVO.getHdrPayGrpLuCd());
				invoiceReq.setHACCTSCOACOMPANY(ffCmpnCSRINFtoAPVO.getHdrCoaCoCd());
				invoiceReq.setHACCTSCOAREGION(ffCmpnCSRINFtoAPVO.getHdrCoaRgnCd());
				invoiceReq.setHACCTSCOACENTER(ffCmpnCSRINFtoAPVO.getHdrCoaCtrCd());
				invoiceReq.setHACCTSCOAACCOUNT(ffCmpnCSRINFtoAPVO.getHdrCoaAcctCd());
				invoiceReq.setHACCTSCOAVVD(ffCmpnCSRINFtoAPVO.getHdrCoaVvdCd());
				invoiceReq.setHACCTSCOAINTERCOMPANY(ffCmpnCSRINFtoAPVO.getHdrCoaInterCoCd());
				invoiceReq.setHACCTSCOAFUTURE1(ffCmpnCSRINFtoAPVO.getHdrCoaFtuN1stCd());
				invoiceReq.setHACCTSCOAFUTURE2(ffCmpnCSRINFtoAPVO.getHdrCoaFtuN2ndCd());
				invoiceReq.setHPREPAYNUM(ffCmpnCSRINFtoAPVO.getHdrPpdNo());
				invoiceReq.setHPREPAYDISTNUM(ffCmpnCSRINFtoAPVO.getHdrPpdDtrbNo());
				invoiceReq.setHPREPAYAPPLYAMOUNT(ffCmpnCSRINFtoAPVO.getHdrPpdAplyAmt());
				invoiceReq.setHPREPAYGLDATE(ffCmpnCSRINFtoAPVO.getHdrPpdGlDt());
				invoiceReq.setHAPPROVEFLAG(ffCmpnCSRINFtoAPVO.getHdrAproFlg());
				invoiceReq.setHTAXFLAG(ffCmpnCSRINFtoAPVO.getHdrTaxDeclFlg());
				invoiceReq.setHERRORCSRNUMBER(ffCmpnCSRINFtoAPVO.getHdrErrCsrNo());
				invoiceReq.setHINTERFACEFLAG(ffCmpnCSRINFtoAPVO.getHdrIfFlg());
				invoiceReq.setHINTERFACEDATE(ffCmpnCSRINFtoAPVO.getHdrIfDt());
				invoiceReq.setHINTERFACEERRORREASON(ffCmpnCSRINFtoAPVO.getHdrIfErrRsn());
				invoiceReq.setHPREPAYMENTAPPLYFLAG(ffCmpnCSRINFtoAPVO.getHdrPpayAplyFlg());
				invoiceReq.setHTRANSACTIONCODE(ffCmpnCSRINFtoAPVO.getHdrTjOfcCd());
				invoiceReq.setHACTUALRATE(ffCmpnCSRINFtoAPVO.getHdrActXchRt());
				invoiceReq.setHIMPORTERRORFLAG(ffCmpnCSRINFtoAPVO.getHdrImpErrFlg());
				invoiceReq.setHRECEIVEERRORFLAG(ffCmpnCSRINFtoAPVO.getHdrRcvErrFlg());
				invoiceReq.setHTAXCURRENCYEXCHANGEFLAG(ffCmpnCSRINFtoAPVO.getHdrTaxCurrXchFlg());
				invoiceReq.setHUSEREMAILID(ffCmpnCSRINFtoAPVO.getHdrUsrEml());
				invoiceReq.setHIMPORTERRORREASON(ffCmpnCSRINFtoAPVO.getHdrImpErrRsn());
				invoiceReq.setHRECEIVEERRORREASON(ffCmpnCSRINFtoAPVO.getHdrRcvErrRsn());
				invoiceReq.setHFUTUREUSE1(ffCmpnCSRINFtoAPVO.getHdrFtuUseCtnt1());
				invoiceReq.setHFUTUREUSE2(ffCmpnCSRINFtoAPVO.getHdrFtuUseCtnt2());
				invoiceReq.setHFUTUREUSE3(ffCmpnCSRINFtoAPVO.getHdrFtuUseCtnt3());
				invoiceReq.setHFUTUREUSE4(ffCmpnCSRINFtoAPVO.getHdrFtuUseCtnt4());
				invoiceReq.setHFUTUREUSE5(ffCmpnCSRINFtoAPVO.getHdrFtuUseCtnt5());
				invoiceReq.setLCSRNUMBER(ffCmpnCSRINFtoAPVO.getCsrNo());
				invoiceReq.setLLINESEQUENCELEGACY(ffCmpnCSRINFtoAPVO.getLineSeq());
				invoiceReq.setLLINENUMBERERP(ffCmpnCSRINFtoAPVO.getLineNo());
				invoiceReq.setLLINETYPELOOKUPCODE(ffCmpnCSRINFtoAPVO.getLineTpLuCd());
				invoiceReq.setLAMOUNT(ffCmpnCSRINFtoAPVO.getInvAmt());
				invoiceReq.setLDESCRIPTION(ffCmpnCSRINFtoAPVO.getInvDesc());
				invoiceReq.setLTAXCODE(ffCmpnCSRINFtoAPVO.getInvTaxCd());
				invoiceReq.setLDISTCOACOMPANY(ffCmpnCSRINFtoAPVO.getDtrbCoaCoCd());
				invoiceReq.setLDISTCOAREGION(ffCmpnCSRINFtoAPVO.getDtrbCoaRgnCd());
				invoiceReq.setLDISTCOACENTER(ffCmpnCSRINFtoAPVO.getDtrbCoaCtrCd());
				invoiceReq.setLDISTCOAACCOUNT(ffCmpnCSRINFtoAPVO.getDtrbCoaAcctCd());
				invoiceReq.setLDISTCOAVVD(ffCmpnCSRINFtoAPVO.getDtrbCoaVvdCd());
				invoiceReq.setLDISTCOAINTERCOMPANY(ffCmpnCSRINFtoAPVO.getDtrbCoaInterCoCd());
				invoiceReq.setLDISTCOAFUTURE1(ffCmpnCSRINFtoAPVO.getDtrbCoaFtuN1stCd());
				invoiceReq.setLDISTCOAFUTURE2(ffCmpnCSRINFtoAPVO.getDtrbCoaFtuN2ndCd());
				invoiceReq.setLATTRIBUTECATEGORY(ffCmpnCSRINFtoAPVO.getAttrCateNm());
				invoiceReq.setLATTRIBUTE1(ffCmpnCSRINFtoAPVO.getAttrCtnt1());
				invoiceReq.setLATTRIBUTE2(ffCmpnCSRINFtoAPVO.getAttrCtnt2());
				invoiceReq.setLATTRIBUTE3(ffCmpnCSRINFtoAPVO.getAttrCtnt3());
				invoiceReq.setLATTRIBUTE4(ffCmpnCSRINFtoAPVO.getAttrCtnt4());
				invoiceReq.setLATTRIBUTE5(ffCmpnCSRINFtoAPVO.getAttrCtnt5());
				invoiceReq.setLATTRIBUTE6(ffCmpnCSRINFtoAPVO.getAttrCtnt6());
				invoiceReq.setLATTRIBUTE7(ffCmpnCSRINFtoAPVO.getAttrCtnt7());
				invoiceReq.setLATTRIBUTE8(ffCmpnCSRINFtoAPVO.getAttrCtnt8());
				invoiceReq.setLATTRIBUTE9(ffCmpnCSRINFtoAPVO.getAttrCtnt9());
				invoiceReq.setLATTRIBUTE10(ffCmpnCSRINFtoAPVO.getAttrCtnt10());
				invoiceReq.setLATTRIBUTE11(ffCmpnCSRINFtoAPVO.getAttrCtnt11());
				invoiceReq.setLATTRIBUTE12(ffCmpnCSRINFtoAPVO.getAttrCtnt12());
				invoiceReq.setLATTRIBUTE13(ffCmpnCSRINFtoAPVO.getAttrCtnt13());
				invoiceReq.setLATTRIBUTE14(ffCmpnCSRINFtoAPVO.getAttrCtnt14());
				invoiceReq.setLATTRIBUTE15(ffCmpnCSRINFtoAPVO.getAttrCtnt15());
				invoiceReq.setLBKGNO(ffCmpnCSRINFtoAPVO.getBkgNo());
				invoiceReq.setLCNTRTPSZ(ffCmpnCSRINFtoAPVO.getCntrTpszCd());
				invoiceReq.setLACTVVD(ffCmpnCSRINFtoAPVO.getActVvdCd());
				invoiceReq.setLDIVCD(ffCmpnCSRINFtoAPVO.getPlnSctrDivCd());
				invoiceReq.setLCARRCD(ffCmpnCSRINFtoAPVO.getSoCrrCd());
				invoiceReq.setLYDCD(ffCmpnCSRINFtoAPVO.getYdCd());
				invoiceReq.setLFUTUREUSE1(ffCmpnCSRINFtoAPVO.getFtuUseCtnt1());
				invoiceReq.setLFUTUREUSE2(ffCmpnCSRINFtoAPVO.getFtuUseCtnt2());
				invoiceReq.setLFUTUREUSE3(ffCmpnCSRINFtoAPVO.getFtuUseCtnt3());
				invoiceReq.setLFUTUREUSE4(ffCmpnCSRINFtoAPVO.getFtuUseCtnt4());
				invoiceReq.setLFUTUREUSE5(ffCmpnCSRINFtoAPVO.getFtuUseCtnt5());
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e); 
			throw new DAOException(e.getMessage());
		}
	}
		
}