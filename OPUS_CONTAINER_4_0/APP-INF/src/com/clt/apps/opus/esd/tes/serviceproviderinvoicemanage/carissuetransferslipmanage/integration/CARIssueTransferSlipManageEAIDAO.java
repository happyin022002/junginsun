/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CARIssueTransferSlipManageEAIDAO.java
*@FileTitle : Terminal invoice CSR Creation - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-18
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-12-18 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBCImpl;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.irep.enis.EAIHeaderType;
import com.clt.irep.enis.FNS0080003Document;
import com.clt.irep.enis.FNS0080003Document.FNS0080003;
import com.clt.irep.enis.FNS0080003Document.FNS0080003.DataArea.APInvoiceCollection;
import com.clt.irep.enis.FNS0080003Document.FNS0080003.DataArea.APInvoiceCollection.APInvoiceRequest;
import com.clt.syscommon.common.table.ComAproRqstRoutVO;
import com.jf.transfer.eai.exception.EAIException;

/**
 * ENIS-ESD에 대한 EAI 처리를 담당<br>
 * - ENIS-ESD Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author jongbaemoon
 * @see CARIssueTransferSlipManageBCImpl 참조
 * @since J2EE 1.4
 */
public class CARIssueTransferSlipManageEAIDAO extends EAIDAOSupport {
	
	/**
	 * Web Service 연동 / 싱크<br>
	 * (ESD_TES_024) invoice 정산내역을 ERP AP로 인터페이스한다.<br>
	 * 모든 데이타를 한번에 연동 처리한다.<br>
	 * 
	 * @param rowSet 연동 데이타 DBRowSet
	 * @param csr_no String
	 * @param rout ComAproRqstRoutVO
	 * 
	 * @return FNS0080003Document[] 인터페이스 리턴값
	 * @throws DAOException
	 */	
	public FNS0080003Document[] transferAtOnceTES024ToEAIByWS(DBRowSet rowSet, String csr_no, ComAproRqstRoutVO rout) throws Exception,DAOException {	
		log.error("\n   (2-1) EAIDAO.transferAtOnceTES024ToEAIByWS : CSR_NO:" + JSPUtil.getNull(csr_no) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n");
		
        FNS0080003Document[] docReq		= null;        
        int cnt = 1;
        String instanceId = null;
        
		try {
			log.debug("\n\n   EAIDAO.dRset담기 ============================= \n\n");

			int limit = 100;
			int rsCnt = 0;
			rowSet.last();
			rsCnt = rowSet.getRow();
			rowSet.beforeFirst();
			int quot = rsCnt/limit;
			int sur  = rsCnt%limit;
			int arr_leng = (sur>0?(quot+1):quot);
			docReq = new FNS0080003Document[arr_leng>0?arr_leng:1];
			log.error("\n FNS0080003Document[] : CSR_NO:" + JSPUtil.getNull(csr_no) + " - docReq.length:"+docReq.length+" (row_cnt:"+rsCnt+")   <<<<\n");
			
            EAIHeaderType 		hearderType		= null;
            FNS0080003 			fns0080003Req	= null;
            APInvoiceCollection invoiceCollReq	= null;
            APInvoiceRequest 	invoiceReq		= null;
            
            /*** 
             *  2007-09-10일부터 2)번째 적용 완료 
             *  2008-01-18일 3)번째 규칙 제작 및 test중
             *  instanceId 규칙
             *  - 단 100개 단위에서 99개 이상(총 10000개) 넘기는 경우를 대비하여 LPAD를 3자리로 늘린다. 
				1) 이전 규칙 -> 'FNS008-0003J' + 날짜(yyyyMMddHHmmss) + 'SYS_NM' + CSR_NO + '(현배열순번/총배열갯수)'
				2) 현재 규칙 -> 'FNS008-' + 날짜(yyMMddHHmm) + 'SYS_NM' + CSR_NO + '(LPAD(현배열순번,'0',2)/LPAD(총배열갯수,'0',2))'
				3) 새   규칙 -> 'FNS008-' + 날짜(yyMMddHHmm) + 'SYS_NM' + CSR_NO + '(LPAD(현배열순번,'0',3)/LPAD(총배열갯수,'0',3))'
				
				EX.
				1) FNS008-0003J200709071037123TES12SPUSBO07090700001(2/8)
				2) FNS008-0709071037TES12SPUSBO07090700001(02/08)
				2) FNS008-0709071037TES12SPUSBO07090700001(002/008)
             */
			for (int i=0; rowSet!=null && i<docReq.length; i++){
				instanceId = "FNS008-"+ (new SimpleDateFormat("yyMMddHHmm")).format(new Date())+"TES"+JSPUtil.getNull(csr_no)+"("+JSPUtil.getLPAD(String.valueOf(i+1),3,"0")+"/"+JSPUtil.getLPAD(String.valueOf(docReq.length),3,"0")+")";				
	            docReq[i] = FNS0080003Document.Factory.newInstance();
	            fns0080003Req = docReq[i].addNewFNS0080003();
	            hearderType = fns0080003Req.addNewEAIHeader();
	            hearderType.setInstanceId(JSPUtil.getNull(instanceId));	            
	            EAIHeaderType.Parameters params = hearderType.addNewParameters();
	            EAIHeaderType.Parameters.Parameter param = params.addNewParameter();
	            param.setStringValue("FNS008-0003--Header");
	            invoiceCollReq = fns0080003Req.addNewDataArea().addNewAPInvoiceCollection();	           
	            cnt = 1; //reset cnt
				while (cnt<=limit && rowSet.next()) {
					invoiceReq = invoiceCollReq.addNewAPInvoiceRequest();
		            setInvoiceDatas(rowSet, invoiceReq, rout);
		            cnt++;
				}
				log.error("\n ### CSR_NO:"+csr_no+"  /  docReq["+i+"].instanceId:"+instanceId+
						  "  /  docReq["+i+"].length:"+docReq[i].getFNS0080003().getDataArea().getAPInvoiceCollection().getAPInvoiceRequestArray().length+"  <<<<<<<<<<<<<<<<<<<<< \n");
			}

		} catch (EAIException e) {
        	log.error(e.getMessage(),e);
            throw new EventException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		
		return docReq;
	}	
	
	/**
	 * EAI 연동시 해당 VO에 데이타를 셋팅한다.<br>
	 * 
	 * @param  rowSet 연동 데이타를 담고 있는 DBRowSet
	 * @param  bkgdocref BKGDOCRef VO 객체
	 * @throws Exception
	 */
	private void setInvoiceDatas(DBRowSet rowSet, APInvoiceRequest invoiceReq, ComAproRqstRoutVO rout) throws Exception {
	      /**
         *        <LIFID>FNS008-0003</LIFID>
        <SEQ>INVOICE별 묶음 순번(INVOICE NO 1은 1, INVOICE NO 2는 2 이런씩으로</SEQ>
        <TOTAL_COUNT/>들어갈 총 COUNT 수
        <ROW_COUNT/>SEQ(ROW SEQ --1,2,3,4 순차적으로)
         *
         **/
		//int i=0;
		
		try {
			if (rowSet != null) {				
				invoiceReq.setLIFID("FNS008-0003");
				//invoiceReq.setSEQ((String)rowSet.getString("INV_SEQ"));
				invoiceReq.setSEQ((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
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
				//invoiceReq.setHATTRIBUTE1((String)rowSet.getString("HDR_ATTR_CTNT1"));
				invoiceReq.setHATTRIBUTE1(rout!=null?(rout.getAproUsrJbTitNm()+"/"+rout.getAproUsrNm()):"");
//				invoiceReq.setHATTRIBUTE1(rout!=null?(rout.getApro_usr_jb_tit_nm()+"/"+rout.getApro_usr_nm()):"");
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
	
}