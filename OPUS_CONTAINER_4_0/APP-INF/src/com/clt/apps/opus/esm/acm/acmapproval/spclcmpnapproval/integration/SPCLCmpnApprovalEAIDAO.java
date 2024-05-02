/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnApprovalEAIDAO.java
*@FileTitle : Special Compensation CSR Creation - Approval Request
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.05
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.07.05 김봉균
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.basic.SPCLCmpnApprovalBCImpl;
import com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnCSRINFtoAPVO;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.integration.EAIDAOSupport;
import com.clt.irep.enis.EAIHeaderType;
import com.clt.irep.enis.FNS0080003Document;
import com.clt.irep.enis.EAIHeaderType.Parameters;
import com.clt.irep.enis.EAIHeaderType.Parameters.Parameter;
import com.clt.irep.enis.FNS0080003Document.FNS0080003;
import com.clt.irep.enis.FNS0080003Document.FNS0080003.DataArea.APInvoiceCollection;
import com.clt.irep.enis.FNS0080003Document.FNS0080003.DataArea.APInvoiceCollection.APInvoiceRequest;
import com.clt.syscommon.common.table.ComAproRqstRoutVO;
import com.jf.transfer.eai.exception.EAIException;

/**
 * OPUS-ACM에 대한 EAI 처리를 담당<br>
 * - OPUS-ACM Business Logic을 처리하기 위한 EAI 작업수행.<br>
 *
 * @author SungJin Park
 * @see SPCLCmpnApprovalBCImpl 참조
 * @since J2EE 1.4
 */
public class SPCLCmpnApprovalEAIDAO extends EAIDAOSupport {

	/**
	 * Web Service 연동 / 싱크<br>
	 * (ESM_ACM_0031) Agent Commission 정산내역을 ERP AP로 인터페이스한다.<br>
	 * 모든 데이타를 한번에 연동 처리한다.<br>
	 *
	 * @param String csrNo
	 * @param ComAproRqstRoutVO routInfo
	 * @param List<SPCLCmpnCSRINFtoAPVO> spCLCmpnCSRINFtoAPVOs
	 * @return FNS0080003Document[]
	 * @throws DAOException
	 */
	public FNS0080003Document[] transferAtOnceACMToEAIByWS(String csrNo, ComAproRqstRoutVO routInfo, List<SPCLCmpnCSRINFtoAPVO> spCLCmpnCSRINFtoAPVOs) throws DAOException {

		FNS0080003Document[] docReq		= null;
        int cnt = 1;

		try {
			log.debug("\n\n WebService 연동 시작 : ACM0031 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n\n");

			int voCnt = spCLCmpnCSRINFtoAPVOs.size();
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

			if(spCLCmpnCSRINFtoAPVOs != null) {
				for (int i=0; i<spCLCmpnCSRINFtoAPVOs.size(); i++) {
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
					while (cnt<=100 && spCLCmpnCSRINFtoAPVOs.get(cnt) != null) {
						invoiceReq = invoiceCollReq.addNewAPInvoiceRequest();
			            setInvoiceDatas( spCLCmpnCSRINFtoAPVOs.get(cnt), invoiceReq, timestamp, routInfo);
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
	 * @param  SPCLCmpnCSRINFtoAPVO spCLCmpnCSRINFtoAPVO
	 * @param  APInvoiceRequest invoiceReq
	 * @param  String timestamp
	 * @param  ComAproRqstRoutVO routInfo
	 * @throws Exception
	 */
	private void setInvoiceDatas( SPCLCmpnCSRINFtoAPVO spCLCmpnCSRINFtoAPVO, APInvoiceRequest invoiceReq, String timestamp, ComAproRqstRoutVO routInfo) throws Exception {

		String title_name = "";
		String usr_jb_tit_nm = "";
		String usr_nm = "";

		try {
			if (spCLCmpnCSRINFtoAPVO != null) {
				invoiceReq.setLIFID(spCLCmpnCSRINFtoAPVO.getLifId());
				invoiceReq.setSEQ(timestamp);
				invoiceReq.setTOTALCOUNT(spCLCmpnCSRINFtoAPVO.getTtlRowKnt());
				invoiceReq.setROWCOUNT(spCLCmpnCSRINFtoAPVO.getRowKnt());
				invoiceReq.setHCSRNUMBER(spCLCmpnCSRINFtoAPVO.getHdrCsrNo());
				invoiceReq.setHCSRTYPE(spCLCmpnCSRINFtoAPVO.getHdrCsrTpCd());
				invoiceReq.setHINVOICEDATE(spCLCmpnCSRINFtoAPVO.getHdrInvDt());
				invoiceReq.setHTERMSDATE(spCLCmpnCSRINFtoAPVO.getHdrInvTermDt());
				invoiceReq.setHGLDATE(spCLCmpnCSRINFtoAPVO.getHdrGlDt());
				invoiceReq.setHVENDORNO(spCLCmpnCSRINFtoAPVO.getHdrVndrNo());
				invoiceReq.setHCSRAMOUNT(spCLCmpnCSRINFtoAPVO.getHdrCsrAmt());
				invoiceReq.setHPAYMENTAMOUNT(spCLCmpnCSRINFtoAPVO.getHdrPayAmt());
				invoiceReq.setHPAYMENTDATE(spCLCmpnCSRINFtoAPVO.getHdrPayDt());
				invoiceReq.setHCSRCURRENCYCODE(spCLCmpnCSRINFtoAPVO.getHdrCsrCurrCd());
				invoiceReq.setHTERMSNAME(spCLCmpnCSRINFtoAPVO.getHdrVndrTermNm());
				invoiceReq.setHDESCRIPTION(spCLCmpnCSRINFtoAPVO.getHdrInvDesc());
				invoiceReq.setHATTRIBUTECATEGORY(spCLCmpnCSRINFtoAPVO.getHdrAttrCateNm());
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
				invoiceReq.setHATTRIBUTE2(spCLCmpnCSRINFtoAPVO.getHdrAttrCtnt2());
				invoiceReq.setHATTRIBUTE3(spCLCmpnCSRINFtoAPVO.getHdrAttrCtnt3());
				invoiceReq.setHATTRIBUTE4(spCLCmpnCSRINFtoAPVO.getHdrAttrCtnt4());
				invoiceReq.setHATTRIBUTE5(spCLCmpnCSRINFtoAPVO.getHdrAttrCtnt5());
				invoiceReq.setHATTRIBUTE6(spCLCmpnCSRINFtoAPVO.getHdrAttrCtnt6());
				invoiceReq.setHATTRIBUTE7(spCLCmpnCSRINFtoAPVO.getHdrAttrCtnt7());
				invoiceReq.setHATTRIBUTE8(spCLCmpnCSRINFtoAPVO.getHdrAttrCtnt8());
				invoiceReq.setHATTRIBUTE9(spCLCmpnCSRINFtoAPVO.getHdrAttrCtnt9());
				invoiceReq.setHATTRIBUTE10(spCLCmpnCSRINFtoAPVO.getHdrAttrCtnt10());
				invoiceReq.setHATTRIBUTE11(spCLCmpnCSRINFtoAPVO.getHdrAttrCtnt11());
				invoiceReq.setHATTRIBUTE12(spCLCmpnCSRINFtoAPVO.getHdrAttrCtnt12());
				invoiceReq.setHATTRIBUTE13(spCLCmpnCSRINFtoAPVO.getHdrAttrCtnt13());
				invoiceReq.setHATTRIBUTE14(spCLCmpnCSRINFtoAPVO.getHdrAttrCtnt14());
				invoiceReq.setHATTRIBUTE15(spCLCmpnCSRINFtoAPVO.getHdrAttrCtnt15());
				invoiceReq.setHGLOBALATTRIBUTE1(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt1());
				invoiceReq.setHGLOBALATTRIBUTE2(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt2());
				invoiceReq.setHGLOBALATTRIBUTE3(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt3());
				invoiceReq.setHGLOBALATTRIBUTE4(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt4());
				invoiceReq.setHGLOBALATTRIBUTE5(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt5());
				invoiceReq.setHGLOBALATTRIBUTE6(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt6());
				invoiceReq.setHGLOBALATTRIBUTE7(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt7());
				invoiceReq.setHGLOBALATTRIBUTE8(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt8());
				invoiceReq.setHGLOBALATTRIBUTE9(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt9());
				invoiceReq.setHGLOBALATTRIBUTE10(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt10());
				invoiceReq.setHGLOBALATTRIBUTE11(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt11());
				invoiceReq.setHGLOBALATTRIBUTE12(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt12());
				invoiceReq.setHGLOBALATTRIBUTE13(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt13());
				invoiceReq.setHGLOBALATTRIBUTE14(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt14());
				invoiceReq.setHGLOBALATTRIBUTE15(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt15());
				invoiceReq.setHGLOBALATTRIBUTE16(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt16());
				invoiceReq.setHGLOBALATTRIBUTE17(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt17());
				invoiceReq.setHGLOBALATTRIBUTE18(spCLCmpnCSRINFtoAPVO.getHdrGloAttrCtnt18());
				invoiceReq.setHSOURCE(spCLCmpnCSRINFtoAPVO.getHdrSrcCtnt());
				invoiceReq.setHPAYMENTMETHODLOOKUPCODE(spCLCmpnCSRINFtoAPVO.getHdrPayMzdLuCd());
				invoiceReq.setHPAYGROUPLOOKUPCODE(spCLCmpnCSRINFtoAPVO.getHdrPayGrpLuCd());
				invoiceReq.setHACCTSCOACOMPANY(spCLCmpnCSRINFtoAPVO.getHdrCoaCoCd());
				invoiceReq.setHACCTSCOAREGION(spCLCmpnCSRINFtoAPVO.getHdrCoaRgnCd());
				invoiceReq.setHACCTSCOACENTER(spCLCmpnCSRINFtoAPVO.getHdrCoaCtrCd());
				invoiceReq.setHACCTSCOAACCOUNT(spCLCmpnCSRINFtoAPVO.getHdrCoaAcctCd());
				invoiceReq.setHACCTSCOAVVD(spCLCmpnCSRINFtoAPVO.getHdrCoaVvdCd());
				invoiceReq.setHACCTSCOAINTERCOMPANY(spCLCmpnCSRINFtoAPVO.getHdrCoaInterCoCd());
				invoiceReq.setHACCTSCOAFUTURE1(spCLCmpnCSRINFtoAPVO.getHdrCoaFtuN1stCd());
				invoiceReq.setHACCTSCOAFUTURE2(spCLCmpnCSRINFtoAPVO.getHdrCoaFtuN2ndCd());
				invoiceReq.setHPREPAYNUM(spCLCmpnCSRINFtoAPVO.getHdrPpdNo());
				invoiceReq.setHPREPAYDISTNUM(spCLCmpnCSRINFtoAPVO.getHdrPpdDtrbNo());
				invoiceReq.setHPREPAYAPPLYAMOUNT(spCLCmpnCSRINFtoAPVO.getHdrPpdAplyAmt());
				invoiceReq.setHPREPAYGLDATE(spCLCmpnCSRINFtoAPVO.getHdrPpdGlDt());
				invoiceReq.setHAPPROVEFLAG(spCLCmpnCSRINFtoAPVO.getHdrAproFlg());
				invoiceReq.setHTAXFLAG(spCLCmpnCSRINFtoAPVO.getHdrTaxDeclFlg());
				invoiceReq.setHERRORCSRNUMBER(spCLCmpnCSRINFtoAPVO.getHdrErrCsrNo());
				invoiceReq.setHINTERFACEFLAG(spCLCmpnCSRINFtoAPVO.getHdrIfFlg());
				invoiceReq.setHINTERFACEDATE(spCLCmpnCSRINFtoAPVO.getHdrIfDt());
				invoiceReq.setHINTERFACEERRORREASON(spCLCmpnCSRINFtoAPVO.getHdrIfErrRsn());
				invoiceReq.setHPREPAYMENTAPPLYFLAG(spCLCmpnCSRINFtoAPVO.getHdrPpayAplyFlg());
				invoiceReq.setHTRANSACTIONCODE(spCLCmpnCSRINFtoAPVO.getHdrTjOfcCd());
				invoiceReq.setHACTUALRATE(spCLCmpnCSRINFtoAPVO.getHdrActXchRt());
				invoiceReq.setHIMPORTERRORFLAG(spCLCmpnCSRINFtoAPVO.getHdrImpErrFlg());
				invoiceReq.setHRECEIVEERRORFLAG(spCLCmpnCSRINFtoAPVO.getHdrRcvErrFlg());
				invoiceReq.setHTAXCURRENCYEXCHANGEFLAG(spCLCmpnCSRINFtoAPVO.getHdrTaxCurrXchFlg());
				invoiceReq.setHUSEREMAILID(spCLCmpnCSRINFtoAPVO.getHdrUsrEml());
				invoiceReq.setHIMPORTERRORREASON(spCLCmpnCSRINFtoAPVO.getHdrImpErrRsn());
				invoiceReq.setHRECEIVEERRORREASON(spCLCmpnCSRINFtoAPVO.getHdrRcvErrRsn());
				invoiceReq.setHFUTUREUSE1(spCLCmpnCSRINFtoAPVO.getHdrFtuUseCtnt1());
				invoiceReq.setHFUTUREUSE2(spCLCmpnCSRINFtoAPVO.getHdrFtuUseCtnt2());
				invoiceReq.setHFUTUREUSE3(spCLCmpnCSRINFtoAPVO.getHdrFtuUseCtnt3());
				invoiceReq.setHFUTUREUSE4(spCLCmpnCSRINFtoAPVO.getHdrFtuUseCtnt4());
				invoiceReq.setHFUTUREUSE5(spCLCmpnCSRINFtoAPVO.getHdrFtuUseCtnt5());
				invoiceReq.setLCSRNUMBER(spCLCmpnCSRINFtoAPVO.getCsrNo());
				invoiceReq.setLLINESEQUENCELEGACY(spCLCmpnCSRINFtoAPVO.getLineSeq());
				invoiceReq.setLLINENUMBERERP(spCLCmpnCSRINFtoAPVO.getLineNo());
				invoiceReq.setLLINETYPELOOKUPCODE(spCLCmpnCSRINFtoAPVO.getLineTpLuCd());
				invoiceReq.setLAMOUNT(spCLCmpnCSRINFtoAPVO.getInvAmt());
				invoiceReq.setLDESCRIPTION(spCLCmpnCSRINFtoAPVO.getInvDesc());
				invoiceReq.setLTAXCODE(spCLCmpnCSRINFtoAPVO.getInvTaxCd());
				invoiceReq.setLDISTCOACOMPANY(spCLCmpnCSRINFtoAPVO.getDtrbCoaCoCd());
				invoiceReq.setLDISTCOAREGION(spCLCmpnCSRINFtoAPVO.getDtrbCoaRgnCd());
				invoiceReq.setLDISTCOACENTER(spCLCmpnCSRINFtoAPVO.getDtrbCoaCtrCd());
				invoiceReq.setLDISTCOAACCOUNT(spCLCmpnCSRINFtoAPVO.getDtrbCoaAcctCd());
				invoiceReq.setLDISTCOAVVD(spCLCmpnCSRINFtoAPVO.getDtrbCoaVvdCd());
				invoiceReq.setLDISTCOAINTERCOMPANY(spCLCmpnCSRINFtoAPVO.getDtrbCoaInterCoCd());
				invoiceReq.setLDISTCOAFUTURE1(spCLCmpnCSRINFtoAPVO.getDtrbCoaFtuN1stCd());
				invoiceReq.setLDISTCOAFUTURE2(spCLCmpnCSRINFtoAPVO.getDtrbCoaFtuN2ndCd());
				invoiceReq.setLATTRIBUTECATEGORY(spCLCmpnCSRINFtoAPVO.getAttrCateNm());
				invoiceReq.setLATTRIBUTE1(spCLCmpnCSRINFtoAPVO.getAttrCtnt1());
				invoiceReq.setLATTRIBUTE2(spCLCmpnCSRINFtoAPVO.getAttrCtnt2());
				invoiceReq.setLATTRIBUTE3(spCLCmpnCSRINFtoAPVO.getAttrCtnt3());
				invoiceReq.setLATTRIBUTE4(spCLCmpnCSRINFtoAPVO.getAttrCtnt4());
				invoiceReq.setLATTRIBUTE5(spCLCmpnCSRINFtoAPVO.getAttrCtnt5());
				invoiceReq.setLATTRIBUTE6(spCLCmpnCSRINFtoAPVO.getAttrCtnt6());
				invoiceReq.setLATTRIBUTE7(spCLCmpnCSRINFtoAPVO.getAttrCtnt7());
				invoiceReq.setLATTRIBUTE8(spCLCmpnCSRINFtoAPVO.getAttrCtnt8());
				invoiceReq.setLATTRIBUTE9(spCLCmpnCSRINFtoAPVO.getAttrCtnt9());
				invoiceReq.setLATTRIBUTE10(spCLCmpnCSRINFtoAPVO.getAttrCtnt10());
				invoiceReq.setLATTRIBUTE11(spCLCmpnCSRINFtoAPVO.getAttrCtnt11());
				invoiceReq.setLATTRIBUTE12(spCLCmpnCSRINFtoAPVO.getAttrCtnt12());
				invoiceReq.setLATTRIBUTE13(spCLCmpnCSRINFtoAPVO.getAttrCtnt13());
				invoiceReq.setLATTRIBUTE14(spCLCmpnCSRINFtoAPVO.getAttrCtnt14());
				invoiceReq.setLATTRIBUTE15(spCLCmpnCSRINFtoAPVO.getAttrCtnt15());
				invoiceReq.setLBKGNO(spCLCmpnCSRINFtoAPVO.getBkgNo());
				invoiceReq.setLCNTRTPSZ(spCLCmpnCSRINFtoAPVO.getCntrTpszCd());
				invoiceReq.setLACTVVD(spCLCmpnCSRINFtoAPVO.getActVvdCd());
				invoiceReq.setLDIVCD(spCLCmpnCSRINFtoAPVO.getPlnSctrDivCd());
				invoiceReq.setLCARRCD(spCLCmpnCSRINFtoAPVO.getSoCrrCd());
				invoiceReq.setLYDCD(spCLCmpnCSRINFtoAPVO.getYdCd());
				invoiceReq.setLFUTUREUSE1(spCLCmpnCSRINFtoAPVO.getFtuUseCtnt1());
				invoiceReq.setLFUTUREUSE2(spCLCmpnCSRINFtoAPVO.getFtuUseCtnt2());
				invoiceReq.setLFUTUREUSE3(spCLCmpnCSRINFtoAPVO.getFtuUseCtnt3());
				invoiceReq.setLFUTUREUSE4(spCLCmpnCSRINFtoAPVO.getFtuUseCtnt4());
				invoiceReq.setLFUTUREUSE5(spCLCmpnCSRINFtoAPVO.getFtuUseCtnt5());
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
	}

}