/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnApprovalEAIDAO.java
*@FileTitle : FF Compensation CSR Creation Approval Request
*Open Issues :
*Change history :
*@LastModifyDate : 2012-05-21
*@LastModifier : SungJin Park
*@LastVersion : 1.0
* 2012-05-21 SungJin Park
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.basic.FFCmpnApprovalBCImpl;
import com.clt.apps.opus.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnCSRINFtoAPVO;
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
 * @see FFCmpnApprovalBCImpl 참조
 * @since J2EE 1.4
 */
public class FFCmpnApprovalEAIDAOB extends EAIDAOSupport {

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