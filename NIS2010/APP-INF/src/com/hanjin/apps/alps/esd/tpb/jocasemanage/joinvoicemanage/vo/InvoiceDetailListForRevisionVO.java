/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceDetailListForRevisionVO.java
*@FileTitle : InvoiceDetailListForRevisionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.10.19 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceDetailListForRevisionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceDetailListForRevisionVO> models = new ArrayList<InvoiceDetailListForRevisionVO>();
	
	/* Column Info */
	private String expnTotalAmt = null;
	/* Column Info */
	private String ddctAmt = null;
	/* Column Info */
	private String estmSvrId = null;
	/* Column Info */
	private String usrInpCtnt1 = null;
	/* Column Info */
	private String sCltAgnRmk = null;
	/* Column Info */
	private String invDtlAmt = null;
	/* Column Info */
	private String n3ptyBilTpNm = null;
	/* Column Info */
	private String vatXchRtOriginal = null;
	/* Column Info */
	private String orgCltAgnFlg = null;
	/* Column Info */
	private String mgsetNo = null;
	/* Column Info */
	private String usrInpCtnt2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sUsrInpCtnt2 = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String sUsrInpCtnt1 = null;
	/* Column Info */
	private String edate = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String sN3ptyInvHisSeq = null;
	/* Column Info */
	private String lstExpense = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String engAddr = null;
	/* Column Info */
	private String sVatAmt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String sAddr = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String orgDueDate = null;
	/* Column Info */
	private String n3ptyInvNoTmp = null;
	/* Column Info */
	private String pkupDt = null;
	/* Column Info */
	private String delSucess = null;
	/* Column Info */
	private String sSumInvAmt = null;
	/* Column Info */
	private String sTotalAmt = null;
	/* Column Info */
	private String sDdctAmt = null;
	/* Column Info */
	private String cltAgnFlg = null;
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String newCreditnoteSeq = null;
	/* Column Info */
	private String sVndrCustAddr2 = null;
	/* Column Info */
	private String isFrance = null;
	/* Column Info */
	private String totHighEduTax = null;
	/* Column Info */
	private String orgVndrCustAddr = null;
	/* Column Info */
	private String sSteCd = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String france = null;
	/* Column Info */
	private String lstFreeDt = null;
	/* Column Info */
	private String n3ptyInvRmdNm = null;
	/* Column Info */
	private String sN3ptyInvRmdYn = null;
	/* Column Info */
	private String erpifYn = null;
	/* Column Info */
	private String bkgNoAll = null;
	/* Column Info */
	private String cnt = null;
	/* Column Info */
	private String sN3ptyNo = null;
	/* Column Info */
	private String sVndrSeq = null;
	/* Column Info */
	private String sVatXchRt = null;
	/* Column Info */
	private String lstInvoiceTotal = null;
	/* Column Info */
	private String sCtyNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String sRhqCdForRhq = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String invAmtSts = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String sRgstNo = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String svcCateRmk = null;
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String sCustSeq = null;
	/* Column Info */
	private String addAmt = null;
	/* Column Info */
	private String sTrdPartyVal = null;
	/* Column Info */
	private String sCurrCd = null;
	/* Column Info */
	private String otsDtlSeq = null;
	/* Column Info */
	private String sVndrCustEml = null;
	/* Column Info */
	private String n3ptyInvNo = null;
	/* Column Info */
	private String originalInvDtlAmt = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String sInquiryonlyYn = null;
	/* Column Info */
	private String sN3ptyInvRmdCd = null;
	/* Column Info */
	private String sN3ptyInvStsCd = null;
	/* Column Info */
	private String finalFlg = null;
	/* Column Info */
	private String detailOtsStsCd = null;
	/* Column Info */
	private String sInvDesc = null;
	/* Column Info */
	private String sVndrCustAddr = null;
	/* Column Info */
	private String invIssRhqCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String sFinalFlgCheckbox = null;
	/* Column Info */
	private String damageDt = null;
	/* Column Info */
	private String detailN3ptyNo = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String ctyNm = null;
	/* Column Info */
	private String sInvoiceCancelRemark = null;
	/* Column Info */
	private String totalAmt = null;
	/* Column Info */
	private String taxRgstNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sZipCd = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String n3ptyInvDtlSeq = null;
	/* Column Info */
	private String vndrCustRefRmk = null;
	/* Column Info */
	private String cltAgnRmk = null;
	/* Column Info */
	private String occrDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String orgSteCd = null;
	/* Column Info */
	private String invIssOfcCd = null;
	/* Column Info */
	private String sRch = null;
	/* Column Info */
	private String sVndrCustNm = null;
	/* Column Info */
	private String idaTaxSeq = null;
	/* Column Info */
	private String eqKndNm = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String lnkN3ptyInvNo = null;
	/* Column Info */
	private String newRvisCd = null;
	/* Column Info */
	private String sTrdPartyNm = null;
	/* Column Info */
	private String sFrance = null;
	/* Column Info */
	private String wtHrs = null;
	/* Column Info */
	private String vndrCustAddr = null;
	/* Column Info */
	private String orgCtyNm = null;
	/* Column Info */
	private String soIfSeq = null;
	/* Column Info */
	private String sRcvDueDt = null;
	/* Column Info */
	private String sLengthN3ptyBilTpCd = null;
	/* Column Info */
	private String sFaxNo = null;
	/* Column Info */
	private String blNoAll = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String validYnCorrection = null;
	/* Column Info */
	private String sDetailOtsStsCd = null;
	/* Column Info */
	private String newVslCd = null;
	/* Column Info */
	private String lstTax = null;
	/* Column Info */
	private String sVndrCustDivCd = null;
	/* Column Info */
	private String eduTax = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String sTrdPartyCode = null;
	/* Column Info */
	private String sHVndrCustDivCd = null;
	/* Column Info */
	private String rgstNo = null;
	/* Column Info */
	private String otsStsCd = null;
	/* Column Info */
	private String orgZipCd = null;
	/* Column Info */
	private String expnTax = null;
	/* Column Info */
	private String sameVersionYn = null;
	/* Column Info */
	private String sCltAgnFlg = null;
	/* Column Info */
	private String n3ptyInvStsCd = null;
	/* Column Info */
	private String vndrCustNm = null;
	/* Column Info */
	private String newRvisSeq = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String sN3ptyInvNo = null;
	/* Column Info */
	private String orgUsrInpCtnt2 = null;
	/* Column Info */
	private String citaNo = null;
	/* Column Info */
	private String orgUsrInpCtnt1 = null;
	/* Column Info */
	private String totSvcTax = null;
	/* Column Info */
	private String repairLocation = null;
	/* Column Info */
	private String highEduTax = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String vatAmt = null;
	/* Column Info */
	private String orgTotAmt = null;
	/* Column Info */
	private String sDetailN3ptyNo = null;
	/* Column Info */
	private String route = null;
	/* Column Info */
	private String rcvDueDt = null;
	/* Column Info */
	private String n3ptyInvRmdYn = null;
	/* Column Info */
	private String orgInvDesc = null;
	/* Column Info */
	private String monXchRt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String sVatXchRtChk = null;
	/* Column Info */
	private String sHisSeq = null;
	/* Column Info */
	private String trdPartyCode = null;
	/* Column Info */
	private String n3ptyCntrWgtUtCd = null;
	/* Column Info */
	private String newCreditnoteCd = null;
	/* Column Info */
	private String sFinalFlg = null;
	/* Column Info */
	private String orgDdctAmt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sCorrectionYn = null;
	/* Column Info */
	private String ftOvrDys = null;
	/* Column Info */
	private String n3ptyBilTpCd = null;
	/* Column Info */
	private String netAmt = null;
	/* Column Info */
	private String sPhnNo = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String totExpnTax = null;
	/* Column Info */
	private String sInvRmk2 = null;
	/* Column Info */
	private String orgVndrCustRefRmk = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String sSameVersionYn = null;
	/* Column Info */
	private String sVndrCustRefRmk = null;
	/* Column Info */
	private String sBilLoc = null;
	/* Column Info */
	private String sCustCntCd = null;
	/* Column Info */
	private String newCntrSealNo = null;
	/* Column Info */
	private String newEqNo = null;
	/* Column Info */
	private String sDaoN3ptyBilTpCd = null;
	/* Column Info */
	private String otsAmt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String sFromCurrCd = null;
	/* Column Info */
	private String sdate = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String sAddAmt = null;
	/* Column Info */
	private String sVndrCntCd = null;
	/* Column Info */
	private String totEduTax = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String sN3ptyOfcCd = null;
	/* Column Info */
	private String orgAdmChrg = null;
	/* Column Info */
	private String sN3ptyInvRmdNm = null;
	/* Column Info */
	private String newBkgNo = null;
	/* Column Info */
	private String vndrCustEml = null;
	/* Column Info */
	private String sInvRmk1 = null;
	/* Column Info */
	private String sIdaTaxSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String bilToLocDivCd = null;
	/* Column Info */
	private String sNetAmt = null;
	/* Column Info */
	private String sN3ptyInvRvisSeq = null;
	/* Column Info */
	private String sInvIssRhqCd = null;
	/* Column Info */
	private String prcsCnt = null;
	/* Column Info */
	private String vatDtlChk = null;
	/* Column Info */
	private String vatDtlAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceDetailListForRevisionVO() {}

	public InvoiceDetailListForRevisionVO(String ibflag, String pagerows, String sDaoN3ptyBilTpCd, String sN3ptyInvRmdCd, String sTrdPartyCode, String sHVndrCustDivCd, String sdate, String edate, String sLengthN3ptyBilTpCd, String sVndrCntCd, String sVndrSeq, String sCustCntCd, String sCustSeq, String sN3ptyOfcCd, String sTrdPartyNm, String sSumInvAmt, String sPhnNo, String sInvRmk1, String sInvRmk2, String sBilLoc, String sCltAgnRmk, String sHisSeq, String sDetailN3ptyNo, String sDetailOtsStsCd, String sVndrCustEml, String sFinalFlg, String sVatXchRt, String sFrance, String sFromCurrCd, String sN3ptyInvHisSeq, String sSameVersionYn, String sInvIssRhqCd, String sN3ptyInvStsCd, String erpifYn, String sCorrectionYn, String sInquiryonlyYn, String sInvoiceCancelRemark, String orgDueDate, String orgAdmChrg, String orgDdctAmt, String orgTotAmt, String invAmtSts, String orgInvDesc, String orgCltAgnFlg, String orgUsrInpCtnt1, String orgVndrCustAddr, String orgCtyNm, String orgSteCd, String orgZipCd, String orgUsrInpCtnt2, String orgVndrCustRefRmk, String cntCd, String sIdaTaxSeq, String sN3ptyNo, String sN3ptyInvNo, String sCurrCd, String sVatXchRtChk, String sFinalFlgCheckbox, String sFaxNo, String sCltAgnFlg, String sUsrInpCtnt1, String sVndrCustNm, String sVndrCustAddr, String sCtyNm, String sSteCd, String sZipCd, String sUsrInpCtnt2, String sVndrCustDivCd, String sTrdPartyVal, String sVndrCustRefRmk, String sRcvDueDt, String sRgstNo, String sRch, String sVndrCustAddr2, String sNetAmt, String sAddAmt, String sDdctAmt, String sVatAmt, String sTotalAmt, String totExpnTax, String totEduTax, String totHighEduTax, String totSvcTax, String taxRgstNo, String svcCateRmk, String lstExpense, String lstTax, String lstInvoiceTotal, String sInvDesc, String sAddr, String sN3ptyInvRmdNm, String sN3ptyInvRmdYn, String seq, String n3ptyInvNo, String n3ptyNo, String n3ptyBilTpCd, String n3ptyBilTpNm, String eqKndNm, String eqNo, String eqTpszCd, String bkgNoAll, String blNoAll, String vvd, String vvdCd, String mgsetNo, String ydCd, String route, String newEqNo, String newCntrSealNo, String citaNo, String cntrWgt, String n3ptyCntrWgtUtCd, String wtHrs, String occrDt, String newVslCd, String newBkgNo, String damageDt, String repairLocation, String lstFreeDt, String pkupDt, String ftOvrDys, String csrNo, String glDt, String otsAmt, String invDtlAmt, String eqKndCd, String fmNodCd, String viaNodCd, String toNodCd, String dorNodCd, String bkgNo, String blNo, String vslCd, String skdVoyNo, String skdDirCd, String estmSvrId, String n3ptyInvDtlSeq, String originalInvDtlAmt, String soIfSeq, String otsDtlSeq, String engAddr, String vndrCntCd, String vndrSeq, String custCntCd, String custSeq, String trdPartyCode, String currCd, String faxNo, String phnNo, String vndrCustAddr, String vndrCustNm, String rgstNo, String vndrCustRefRmk, String bilToLocDivCd, String cltAgnRmk, String cltAgnFlg, String n3ptyInvStsCd, String invDesc, String vndrCustEml, String rcvDueDt, String n3ptyInvRmdYn, String n3ptyInvRmdNm, String hisSeq, String finalFlg, String detailN3ptyNo, String detailOtsStsCd, String monXchRt, String netAmt, String vatAmt, String addAmt, String ddctAmt, String totalAmt, String vatXchRtOriginal, String france, String lnkN3ptyInvNo, String ctyNm, String steCd, String zipCd, String usrInpCtnt1, String usrInpCtnt2, String invIssOfcCd, String sameVersionYn, String invIssRhqCd, String idaTaxSeq, String expnTax, String eduTax, String highEduTax, String expnTotalAmt, String userOfcCd, String otsStsCd, String cnt, String isFrance, String userId, String ofcCd, String validYnCorrection, String newRvisSeq, String newRvisCd, String newCreditnoteSeq, String newCreditnoteCd, String sN3ptyInvRvisSeq, String sRhqCdForRhq, String n3ptyInvNoTmp, String delSucess, String prcsCnt, String vatDtlChk, String vatDtlAmt) {
		this.expnTotalAmt = expnTotalAmt;
		this.ddctAmt = ddctAmt;
		this.estmSvrId = estmSvrId;
		this.usrInpCtnt1 = usrInpCtnt1;
		this.sCltAgnRmk = sCltAgnRmk;
		this.invDtlAmt = invDtlAmt;
		this.n3ptyBilTpNm = n3ptyBilTpNm;
		this.vatXchRtOriginal = vatXchRtOriginal;
		this.orgCltAgnFlg = orgCltAgnFlg;
		this.mgsetNo = mgsetNo;
		this.usrInpCtnt2 = usrInpCtnt2;
		this.pagerows = pagerows;
		this.sUsrInpCtnt2 = sUsrInpCtnt2;
		this.vvdCd = vvdCd;
		this.sUsrInpCtnt1 = sUsrInpCtnt1;
		this.edate = edate;
		this.cntCd = cntCd;
		this.sN3ptyInvHisSeq = sN3ptyInvHisSeq;
		this.lstExpense = lstExpense;
		this.cntrWgt = cntrWgt;
		this.engAddr = engAddr;
		this.sVatAmt = sVatAmt;
		this.skdVoyNo = skdVoyNo;
		this.sAddr = sAddr;
		this.eqTpszCd = eqTpszCd;
		this.orgDueDate = orgDueDate;
		this.n3ptyInvNoTmp = n3ptyInvNoTmp;
		this.pkupDt = pkupDt;
		this.delSucess = delSucess;
		this.sSumInvAmt = sSumInvAmt;
		this.sTotalAmt = sTotalAmt;
		this.sDdctAmt = sDdctAmt;
		this.cltAgnFlg = cltAgnFlg;
		this.userOfcCd = userOfcCd;
		this.newCreditnoteSeq = newCreditnoteSeq;
		this.sVndrCustAddr2 = sVndrCustAddr2;
		this.isFrance = isFrance;
		this.totHighEduTax = totHighEduTax;
		this.orgVndrCustAddr = orgVndrCustAddr;
		this.sSteCd = sSteCd;
		this.dorNodCd = dorNodCd;
		this.france = france;
		this.lstFreeDt = lstFreeDt;
		this.n3ptyInvRmdNm = n3ptyInvRmdNm;
		this.sN3ptyInvRmdYn = sN3ptyInvRmdYn;
		this.erpifYn = erpifYn;
		this.bkgNoAll = bkgNoAll;
		this.cnt = cnt;
		this.sN3ptyNo = sN3ptyNo;
		this.sVndrSeq = sVndrSeq;
		this.sVatXchRt = sVatXchRt;
		this.lstInvoiceTotal = lstInvoiceTotal;
		this.sCtyNm = sCtyNm;
		this.ofcCd = ofcCd;
		this.sRhqCdForRhq = sRhqCdForRhq;
		this.ydCd = ydCd;
		this.invAmtSts = invAmtSts;
		this.viaNodCd = viaNodCd;
		this.sRgstNo = sRgstNo;
		this.eqKndCd = eqKndCd;
		this.steCd = steCd;
		this.svcCateRmk = svcCateRmk;
		this.toNodCd = toNodCd;
		this.glDt = glDt;
		this.sCustSeq = sCustSeq;
		this.addAmt = addAmt;
		this.sTrdPartyVal = sTrdPartyVal;
		this.sCurrCd = sCurrCd;
		this.otsDtlSeq = otsDtlSeq;
		this.sVndrCustEml = sVndrCustEml;
		this.n3ptyInvNo = n3ptyInvNo;
		this.originalInvDtlAmt = originalInvDtlAmt;
		this.invDesc = invDesc;
		this.sInquiryonlyYn = sInquiryonlyYn;
		this.sN3ptyInvRmdCd = sN3ptyInvRmdCd;
		this.sN3ptyInvStsCd = sN3ptyInvStsCd;
		this.finalFlg = finalFlg;
		this.detailOtsStsCd = detailOtsStsCd;
		this.sInvDesc = sInvDesc;
		this.sVndrCustAddr = sVndrCustAddr;
		this.invIssRhqCd = invIssRhqCd;
		this.vvd = vvd;
		this.sFinalFlgCheckbox = sFinalFlgCheckbox;
		this.damageDt = damageDt;
		this.detailN3ptyNo = detailN3ptyNo;
		this.faxNo = faxNo;
		this.ctyNm = ctyNm;
		this.sInvoiceCancelRemark = sInvoiceCancelRemark;
		this.totalAmt = totalAmt;
		this.taxRgstNo = taxRgstNo;
		this.ibflag = ibflag;
		this.sZipCd = sZipCd;
		this.hisSeq = hisSeq;
		this.n3ptyInvDtlSeq = n3ptyInvDtlSeq;
		this.vndrCustRefRmk = vndrCustRefRmk;
		this.cltAgnRmk = cltAgnRmk;
		this.occrDt = occrDt;
		this.custSeq = custSeq;
		this.orgSteCd = orgSteCd;
		this.invIssOfcCd = invIssOfcCd;
		this.sRch = sRch;
		this.sVndrCustNm = sVndrCustNm;
		this.idaTaxSeq = idaTaxSeq;
		this.eqKndNm = eqKndNm;
		this.seq = seq;
		this.lnkN3ptyInvNo = lnkN3ptyInvNo;
		this.newRvisCd = newRvisCd;
		this.sTrdPartyNm = sTrdPartyNm;
		this.sFrance = sFrance;
		this.wtHrs = wtHrs;
		this.vndrCustAddr = vndrCustAddr;
		this.orgCtyNm = orgCtyNm;
		this.soIfSeq = soIfSeq;
		this.sRcvDueDt = sRcvDueDt;
		this.sLengthN3ptyBilTpCd = sLengthN3ptyBilTpCd;
		this.sFaxNo = sFaxNo;
		this.blNoAll = blNoAll;
		this.custCntCd = custCntCd;
		this.validYnCorrection = validYnCorrection;
		this.sDetailOtsStsCd = sDetailOtsStsCd;
		this.newVslCd = newVslCd;
		this.lstTax = lstTax;
		this.sVndrCustDivCd = sVndrCustDivCd;
		this.eduTax = eduTax;
		this.bkgNo = bkgNo;
		this.zipCd = zipCd;
		this.sTrdPartyCode = sTrdPartyCode;
		this.sHVndrCustDivCd = sHVndrCustDivCd;
		this.rgstNo = rgstNo;
		this.otsStsCd = otsStsCd;
		this.orgZipCd = orgZipCd;
		this.expnTax = expnTax;
		this.sameVersionYn = sameVersionYn;
		this.sCltAgnFlg = sCltAgnFlg;
		this.n3ptyInvStsCd = n3ptyInvStsCd;
		this.vndrCustNm = vndrCustNm;
		this.newRvisSeq = newRvisSeq;
		this.n3ptyNo = n3ptyNo;
		this.sN3ptyInvNo = sN3ptyInvNo;
		this.orgUsrInpCtnt2 = orgUsrInpCtnt2;
		this.citaNo = citaNo;
		this.orgUsrInpCtnt1 = orgUsrInpCtnt1;
		this.totSvcTax = totSvcTax;
		this.repairLocation = repairLocation;
		this.highEduTax = highEduTax;
		this.fmNodCd = fmNodCd;
		this.vatAmt = vatAmt;
		this.orgTotAmt = orgTotAmt;
		this.sDetailN3ptyNo = sDetailN3ptyNo;
		this.route = route;
		this.rcvDueDt = rcvDueDt;
		this.n3ptyInvRmdYn = n3ptyInvRmdYn;
		this.orgInvDesc = orgInvDesc;
		this.monXchRt = monXchRt;
		this.vslCd = vslCd;
		this.vndrCntCd = vndrCntCd;
		this.sVatXchRtChk = sVatXchRtChk;
		this.sHisSeq = sHisSeq;
		this.trdPartyCode = trdPartyCode;
		this.n3ptyCntrWgtUtCd = n3ptyCntrWgtUtCd;
		this.newCreditnoteCd = newCreditnoteCd;
		this.sFinalFlg = sFinalFlg;
		this.orgDdctAmt = orgDdctAmt;
		this.blNo = blNo;
		this.sCorrectionYn = sCorrectionYn;
		this.ftOvrDys = ftOvrDys;
		this.n3ptyBilTpCd = n3ptyBilTpCd;
		this.netAmt = netAmt;
		this.sPhnNo = sPhnNo;
		this.userId = userId;
		this.totExpnTax = totExpnTax;
		this.sInvRmk2 = sInvRmk2;
		this.orgVndrCustRefRmk = orgVndrCustRefRmk;
		this.csrNo = csrNo;
		this.phnNo = phnNo;
		this.sSameVersionYn = sSameVersionYn;
		this.sVndrCustRefRmk = sVndrCustRefRmk;
		this.sBilLoc = sBilLoc;
		this.sCustCntCd = sCustCntCd;
		this.newCntrSealNo = newCntrSealNo;
		this.newEqNo = newEqNo;
		this.sDaoN3ptyBilTpCd = sDaoN3ptyBilTpCd;
		this.otsAmt = otsAmt;
		this.vndrSeq = vndrSeq;
		this.sFromCurrCd = sFromCurrCd;
		this.sdate = sdate;
		this.currCd = currCd;
		this.sAddAmt = sAddAmt;
		this.sVndrCntCd = sVndrCntCd;
		this.totEduTax = totEduTax;
		this.eqNo = eqNo;
		this.sN3ptyOfcCd = sN3ptyOfcCd;
		this.orgAdmChrg = orgAdmChrg;
		this.sN3ptyInvRmdNm = sN3ptyInvRmdNm;
		this.newBkgNo = newBkgNo;
		this.vndrCustEml = vndrCustEml;
		this.sInvRmk1 = sInvRmk1;
		this.sIdaTaxSeq = sIdaTaxSeq;
		this.skdDirCd = skdDirCd;
		this.bilToLocDivCd = bilToLocDivCd;
		this.sNetAmt = sNetAmt;
		this.sN3ptyInvRvisSeq = sN3ptyInvRvisSeq;
		this.sInvIssRhqCd = sInvIssRhqCd;
		this.prcsCnt = prcsCnt;
		this.vatDtlChk = vatDtlChk;
		this.vatDtlAmt = vatDtlAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("expn_total_amt", getExpnTotalAmt());
		this.hashColumns.put("ddct_amt", getDdctAmt());
		this.hashColumns.put("estm_svr_id", getEstmSvrId());
		this.hashColumns.put("usr_inp_ctnt1", getUsrInpCtnt1());
		this.hashColumns.put("s_clt_agn_rmk", getSCltAgnRmk());
		this.hashColumns.put("inv_dtl_amt", getInvDtlAmt());
		this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
		this.hashColumns.put("vat_xch_rt_original", getVatXchRtOriginal());
		this.hashColumns.put("org_clt_agn_flg", getOrgCltAgnFlg());
		this.hashColumns.put("mgset_no", getMgsetNo());
		this.hashColumns.put("usr_inp_ctnt2", getUsrInpCtnt2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_usr_inp_ctnt2", getSUsrInpCtnt2());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("s_usr_inp_ctnt1", getSUsrInpCtnt1());
		this.hashColumns.put("edate", getEdate());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("s_n3pty_inv_his_seq", getSN3ptyInvHisSeq());
		this.hashColumns.put("lst_expense", getLstExpense());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("eng_addr", getEngAddr());
		this.hashColumns.put("s_vat_amt", getSVatAmt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("s_addr", getSAddr());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("org_due_date", getOrgDueDate());
		this.hashColumns.put("n3pty_inv_no_tmp", getN3ptyInvNoTmp());
		this.hashColumns.put("pkup_dt", getPkupDt());
		this.hashColumns.put("del_sucess", getDelSucess());
		this.hashColumns.put("s_sum_inv_amt", getSSumInvAmt());
		this.hashColumns.put("s_total_amt", getSTotalAmt());
		this.hashColumns.put("s_ddct_amt", getSDdctAmt());
		this.hashColumns.put("clt_agn_flg", getCltAgnFlg());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("new_creditnote_seq", getNewCreditnoteSeq());
		this.hashColumns.put("s_vndr_cust_addr2", getSVndrCustAddr2());
		this.hashColumns.put("is_france", getIsFrance());
		this.hashColumns.put("tot_high_edu_tax", getTotHighEduTax());
		this.hashColumns.put("org_vndr_cust_addr", getOrgVndrCustAddr());
		this.hashColumns.put("s_ste_cd", getSSteCd());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("france", getFrance());
		this.hashColumns.put("lst_free_dt", getLstFreeDt());
		this.hashColumns.put("n3pty_inv_rmd_nm", getN3ptyInvRmdNm());
		this.hashColumns.put("s_n3pty_inv_rmd_yn", getSN3ptyInvRmdYn());
		this.hashColumns.put("erpif_yn", getErpifYn());
		this.hashColumns.put("bkg_no_all", getBkgNoAll());
		this.hashColumns.put("cnt", getCnt());
		this.hashColumns.put("s_n3pty_no", getSN3ptyNo());
		this.hashColumns.put("s_vndr_seq", getSVndrSeq());
		this.hashColumns.put("s_vat_xch_rt", getSVatXchRt());
		this.hashColumns.put("lst_invoice_total", getLstInvoiceTotal());
		this.hashColumns.put("s_cty_nm", getSCtyNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("s_rhq_cd_for_rhq", getSRhqCdForRhq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("inv_amt_sts", getInvAmtSts());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("s_rgst_no", getSRgstNo());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("svc_cate_rmk", getSvcCateRmk());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("s_cust_seq", getSCustSeq());
		this.hashColumns.put("add_amt", getAddAmt());
		this.hashColumns.put("s_trd_party_val", getSTrdPartyVal());
		this.hashColumns.put("s_curr_cd", getSCurrCd());
		this.hashColumns.put("ots_dtl_seq", getOtsDtlSeq());
		this.hashColumns.put("s_vndr_cust_eml", getSVndrCustEml());
		this.hashColumns.put("n3pty_inv_no", getN3ptyInvNo());
		this.hashColumns.put("original_inv_dtl_amt", getOriginalInvDtlAmt());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("s_inquiryonly_yn", getSInquiryonlyYn());
		this.hashColumns.put("s_n3pty_inv_rmd_cd", getSN3ptyInvRmdCd());
		this.hashColumns.put("s_n3pty_inv_sts_cd", getSN3ptyInvStsCd());
		this.hashColumns.put("final_flg", getFinalFlg());
		this.hashColumns.put("detail_ots_sts_cd", getDetailOtsStsCd());
		this.hashColumns.put("s_inv_desc", getSInvDesc());
		this.hashColumns.put("s_vndr_cust_addr", getSVndrCustAddr());
		this.hashColumns.put("inv_iss_rhq_cd", getInvIssRhqCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("s_final_flg_checkbox", getSFinalFlgCheckbox());
		this.hashColumns.put("damage_dt", getDamageDt());
		this.hashColumns.put("detail_n3pty_no", getDetailN3ptyNo());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("s_invoice_cancel_remark", getSInvoiceCancelRemark());
		this.hashColumns.put("total_amt", getTotalAmt());
		this.hashColumns.put("tax_rgst_no", getTaxRgstNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_zip_cd", getSZipCd());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("n3pty_inv_dtl_seq", getN3ptyInvDtlSeq());
		this.hashColumns.put("vndr_cust_ref_rmk", getVndrCustRefRmk());
		this.hashColumns.put("clt_agn_rmk", getCltAgnRmk());
		this.hashColumns.put("occr_dt", getOccrDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("org_ste_cd", getOrgSteCd());
		this.hashColumns.put("inv_iss_ofc_cd", getInvIssOfcCd());
		this.hashColumns.put("s_rch", getSRch());
		this.hashColumns.put("s_vndr_cust_nm", getSVndrCustNm());
		this.hashColumns.put("ida_tax_seq", getIdaTaxSeq());
		this.hashColumns.put("eq_knd_nm", getEqKndNm());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("lnk_n3pty_inv_no", getLnkN3ptyInvNo());
		this.hashColumns.put("new_rvis_cd", getNewRvisCd());
		this.hashColumns.put("s_trd_party_nm", getSTrdPartyNm());
		this.hashColumns.put("s_france", getSFrance());
		this.hashColumns.put("wt_hrs", getWtHrs());
		this.hashColumns.put("vndr_cust_addr", getVndrCustAddr());
		this.hashColumns.put("org_cty_nm", getOrgCtyNm());
		this.hashColumns.put("so_if_seq", getSoIfSeq());
		this.hashColumns.put("s_rcv_due_dt", getSRcvDueDt());
		this.hashColumns.put("s_length_n3pty_bil_tp_cd", getSLengthN3ptyBilTpCd());
		this.hashColumns.put("s_fax_no", getSFaxNo());
		this.hashColumns.put("bl_no_all", getBlNoAll());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("valid_yn_correction", getValidYnCorrection());
		this.hashColumns.put("s_detail_ots_sts_cd", getSDetailOtsStsCd());
		this.hashColumns.put("new_vsl_cd", getNewVslCd());
		this.hashColumns.put("lst_tax", getLstTax());
		this.hashColumns.put("s_vndr_cust_div_cd", getSVndrCustDivCd());
		this.hashColumns.put("edu_tax", getEduTax());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("s_trd_party_code", getSTrdPartyCode());
		this.hashColumns.put("s_h_vndr_cust_div_cd", getSHVndrCustDivCd());
		this.hashColumns.put("rgst_no", getRgstNo());
		this.hashColumns.put("ots_sts_cd", getOtsStsCd());
		this.hashColumns.put("org_zip_cd", getOrgZipCd());
		this.hashColumns.put("expn_tax", getExpnTax());
		this.hashColumns.put("same_version_yn", getSameVersionYn());
		this.hashColumns.put("s_clt_agn_flg", getSCltAgnFlg());
		this.hashColumns.put("n3pty_inv_sts_cd", getN3ptyInvStsCd());
		this.hashColumns.put("vndr_cust_nm", getVndrCustNm());
		this.hashColumns.put("new_rvis_seq", getNewRvisSeq());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("s_n3pty_inv_no", getSN3ptyInvNo());
		this.hashColumns.put("org_usr_inp_ctnt2", getOrgUsrInpCtnt2());
		this.hashColumns.put("cita_no", getCitaNo());
		this.hashColumns.put("org_usr_inp_ctnt1", getOrgUsrInpCtnt1());
		this.hashColumns.put("tot_svc_tax", getTotSvcTax());
		this.hashColumns.put("repair_location", getRepairLocation());
		this.hashColumns.put("high_edu_tax", getHighEduTax());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("vat_amt", getVatAmt());
		this.hashColumns.put("org_tot_amt", getOrgTotAmt());
		this.hashColumns.put("s_detail_n3pty_no", getSDetailN3ptyNo());
		this.hashColumns.put("route", getRoute());
		this.hashColumns.put("rcv_due_dt", getRcvDueDt());
		this.hashColumns.put("n3pty_inv_rmd_yn", getN3ptyInvRmdYn());
		this.hashColumns.put("org_inv_desc", getOrgInvDesc());
		this.hashColumns.put("mon_xch_rt", getMonXchRt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("s_vat_xch_rt_chk", getSVatXchRtChk());
		this.hashColumns.put("s_his_seq", getSHisSeq());
		this.hashColumns.put("trd_party_code", getTrdPartyCode());
		this.hashColumns.put("n3pty_cntr_wgt_ut_cd", getN3ptyCntrWgtUtCd());
		this.hashColumns.put("new_creditnote_cd", getNewCreditnoteCd());
		this.hashColumns.put("s_final_flg", getSFinalFlg());
		this.hashColumns.put("org_ddct_amt", getOrgDdctAmt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("s_correction_yn", getSCorrectionYn());
		this.hashColumns.put("ft_ovr_dys", getFtOvrDys());
		this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
		this.hashColumns.put("net_amt", getNetAmt());
		this.hashColumns.put("s_phn_no", getSPhnNo());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("tot_expn_tax", getTotExpnTax());
		this.hashColumns.put("s_inv_rmk2", getSInvRmk2());
		this.hashColumns.put("org_vndr_cust_ref_rmk", getOrgVndrCustRefRmk());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("s_same_version_yn", getSSameVersionYn());
		this.hashColumns.put("s_vndr_cust_ref_rmk", getSVndrCustRefRmk());
		this.hashColumns.put("s_bil_loc", getSBilLoc());
		this.hashColumns.put("s_cust_cnt_cd", getSCustCntCd());
		this.hashColumns.put("new_cntr_seal_no", getNewCntrSealNo());
		this.hashColumns.put("new_eq_no", getNewEqNo());
		this.hashColumns.put("s_dao_n3pty_bil_tp_cd", getSDaoN3ptyBilTpCd());
		this.hashColumns.put("ots_amt", getOtsAmt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("s_from_curr_cd", getSFromCurrCd());
		this.hashColumns.put("sdate", getSdate());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("s_add_amt", getSAddAmt());
		this.hashColumns.put("s_vndr_cnt_cd", getSVndrCntCd());
		this.hashColumns.put("tot_edu_tax", getTotEduTax());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("s_n3pty_ofc_cd", getSN3ptyOfcCd());
		this.hashColumns.put("org_adm_chrg", getOrgAdmChrg());
		this.hashColumns.put("s_n3pty_inv_rmd_nm", getSN3ptyInvRmdNm());
		this.hashColumns.put("new_bkg_no", getNewBkgNo());
		this.hashColumns.put("vndr_cust_eml", getVndrCustEml());
		this.hashColumns.put("s_inv_rmk1", getSInvRmk1());
		this.hashColumns.put("s_ida_tax_seq", getSIdaTaxSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("bil_to_loc_div_cd", getBilToLocDivCd());
		this.hashColumns.put("s_net_amt", getSNetAmt());
		this.hashColumns.put("s_n3pty_inv_rvis_seq", getSN3ptyInvRvisSeq());
		this.hashColumns.put("s_inv_iss_rhq_cd", getSInvIssRhqCd());
		this.hashColumns.put("prcs_cnt", getPrcsCnt());
		this.hashColumns.put("vat_dtl_chk", getVatDtlChk());
		this.hashColumns.put("vat_dtl_amt", getVatDtlAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("expn_total_amt", "expnTotalAmt");
		this.hashFields.put("ddct_amt", "ddctAmt");
		this.hashFields.put("estm_svr_id", "estmSvrId");
		this.hashFields.put("usr_inp_ctnt1", "usrInpCtnt1");
		this.hashFields.put("s_clt_agn_rmk", "sCltAgnRmk");
		this.hashFields.put("inv_dtl_amt", "invDtlAmt");
		this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");
		this.hashFields.put("vat_xch_rt_original", "vatXchRtOriginal");
		this.hashFields.put("org_clt_agn_flg", "orgCltAgnFlg");
		this.hashFields.put("mgset_no", "mgsetNo");
		this.hashFields.put("usr_inp_ctnt2", "usrInpCtnt2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_usr_inp_ctnt2", "sUsrInpCtnt2");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("s_usr_inp_ctnt1", "sUsrInpCtnt1");
		this.hashFields.put("edate", "edate");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("s_n3pty_inv_his_seq", "sN3ptyInvHisSeq");
		this.hashFields.put("lst_expense", "lstExpense");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("eng_addr", "engAddr");
		this.hashFields.put("s_vat_amt", "sVatAmt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("s_addr", "sAddr");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("org_due_date", "orgDueDate");
		this.hashFields.put("n3pty_inv_no_tmp", "n3ptyInvNoTmp");
		this.hashFields.put("pkup_dt", "pkupDt");
		this.hashFields.put("del_sucess", "delSucess");
		this.hashFields.put("s_sum_inv_amt", "sSumInvAmt");
		this.hashFields.put("s_total_amt", "sTotalAmt");
		this.hashFields.put("s_ddct_amt", "sDdctAmt");
		this.hashFields.put("clt_agn_flg", "cltAgnFlg");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("new_creditnote_seq", "newCreditnoteSeq");
		this.hashFields.put("s_vndr_cust_addr2", "sVndrCustAddr2");
		this.hashFields.put("is_france", "isFrance");
		this.hashFields.put("tot_high_edu_tax", "totHighEduTax");
		this.hashFields.put("org_vndr_cust_addr", "orgVndrCustAddr");
		this.hashFields.put("s_ste_cd", "sSteCd");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("france", "france");
		this.hashFields.put("lst_free_dt", "lstFreeDt");
		this.hashFields.put("n3pty_inv_rmd_nm", "n3ptyInvRmdNm");
		this.hashFields.put("s_n3pty_inv_rmd_yn", "sN3ptyInvRmdYn");
		this.hashFields.put("erpif_yn", "erpifYn");
		this.hashFields.put("bkg_no_all", "bkgNoAll");
		this.hashFields.put("cnt", "cnt");
		this.hashFields.put("s_n3pty_no", "sN3ptyNo");
		this.hashFields.put("s_vndr_seq", "sVndrSeq");
		this.hashFields.put("s_vat_xch_rt", "sVatXchRt");
		this.hashFields.put("lst_invoice_total", "lstInvoiceTotal");
		this.hashFields.put("s_cty_nm", "sCtyNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("s_rhq_cd_for_rhq", "sRhqCdForRhq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("inv_amt_sts", "invAmtSts");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("s_rgst_no", "sRgstNo");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("svc_cate_rmk", "svcCateRmk");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("s_cust_seq", "sCustSeq");
		this.hashFields.put("add_amt", "addAmt");
		this.hashFields.put("s_trd_party_val", "sTrdPartyVal");
		this.hashFields.put("s_curr_cd", "sCurrCd");
		this.hashFields.put("ots_dtl_seq", "otsDtlSeq");
		this.hashFields.put("s_vndr_cust_eml", "sVndrCustEml");
		this.hashFields.put("n3pty_inv_no", "n3ptyInvNo");
		this.hashFields.put("original_inv_dtl_amt", "originalInvDtlAmt");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("s_inquiryonly_yn", "sInquiryonlyYn");
		this.hashFields.put("s_n3pty_inv_rmd_cd", "sN3ptyInvRmdCd");
		this.hashFields.put("s_n3pty_inv_sts_cd", "sN3ptyInvStsCd");
		this.hashFields.put("final_flg", "finalFlg");
		this.hashFields.put("detail_ots_sts_cd", "detailOtsStsCd");
		this.hashFields.put("s_inv_desc", "sInvDesc");
		this.hashFields.put("s_vndr_cust_addr", "sVndrCustAddr");
		this.hashFields.put("inv_iss_rhq_cd", "invIssRhqCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("s_final_flg_checkbox", "sFinalFlgCheckbox");
		this.hashFields.put("damage_dt", "damageDt");
		this.hashFields.put("detail_n3pty_no", "detailN3ptyNo");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("s_invoice_cancel_remark", "sInvoiceCancelRemark");
		this.hashFields.put("total_amt", "totalAmt");
		this.hashFields.put("tax_rgst_no", "taxRgstNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_zip_cd", "sZipCd");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("n3pty_inv_dtl_seq", "n3ptyInvDtlSeq");
		this.hashFields.put("vndr_cust_ref_rmk", "vndrCustRefRmk");
		this.hashFields.put("clt_agn_rmk", "cltAgnRmk");
		this.hashFields.put("occr_dt", "occrDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("org_ste_cd", "orgSteCd");
		this.hashFields.put("inv_iss_ofc_cd", "invIssOfcCd");
		this.hashFields.put("s_rch", "sRch");
		this.hashFields.put("s_vndr_cust_nm", "sVndrCustNm");
		this.hashFields.put("ida_tax_seq", "idaTaxSeq");
		this.hashFields.put("eq_knd_nm", "eqKndNm");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("lnk_n3pty_inv_no", "lnkN3ptyInvNo");
		this.hashFields.put("new_rvis_cd", "newRvisCd");
		this.hashFields.put("s_trd_party_nm", "sTrdPartyNm");
		this.hashFields.put("s_france", "sFrance");
		this.hashFields.put("wt_hrs", "wtHrs");
		this.hashFields.put("vndr_cust_addr", "vndrCustAddr");
		this.hashFields.put("org_cty_nm", "orgCtyNm");
		this.hashFields.put("so_if_seq", "soIfSeq");
		this.hashFields.put("s_rcv_due_dt", "sRcvDueDt");
		this.hashFields.put("s_length_n3pty_bil_tp_cd", "sLengthN3ptyBilTpCd");
		this.hashFields.put("s_fax_no", "sFaxNo");
		this.hashFields.put("bl_no_all", "blNoAll");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("valid_yn_correction", "validYnCorrection");
		this.hashFields.put("s_detail_ots_sts_cd", "sDetailOtsStsCd");
		this.hashFields.put("new_vsl_cd", "newVslCd");
		this.hashFields.put("lst_tax", "lstTax");
		this.hashFields.put("s_vndr_cust_div_cd", "sVndrCustDivCd");
		this.hashFields.put("edu_tax", "eduTax");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("s_trd_party_code", "sTrdPartyCode");
		this.hashFields.put("s_h_vndr_cust_div_cd", "sHVndrCustDivCd");
		this.hashFields.put("rgst_no", "rgstNo");
		this.hashFields.put("ots_sts_cd", "otsStsCd");
		this.hashFields.put("org_zip_cd", "orgZipCd");
		this.hashFields.put("expn_tax", "expnTax");
		this.hashFields.put("same_version_yn", "sameVersionYn");
		this.hashFields.put("s_clt_agn_flg", "sCltAgnFlg");
		this.hashFields.put("n3pty_inv_sts_cd", "n3ptyInvStsCd");
		this.hashFields.put("vndr_cust_nm", "vndrCustNm");
		this.hashFields.put("new_rvis_seq", "newRvisSeq");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("s_n3pty_inv_no", "sN3ptyInvNo");
		this.hashFields.put("org_usr_inp_ctnt2", "orgUsrInpCtnt2");
		this.hashFields.put("cita_no", "citaNo");
		this.hashFields.put("org_usr_inp_ctnt1", "orgUsrInpCtnt1");
		this.hashFields.put("tot_svc_tax", "totSvcTax");
		this.hashFields.put("repair_location", "repairLocation");
		this.hashFields.put("high_edu_tax", "highEduTax");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("vat_amt", "vatAmt");
		this.hashFields.put("org_tot_amt", "orgTotAmt");
		this.hashFields.put("s_detail_n3pty_no", "sDetailN3ptyNo");
		this.hashFields.put("route", "route");
		this.hashFields.put("rcv_due_dt", "rcvDueDt");
		this.hashFields.put("n3pty_inv_rmd_yn", "n3ptyInvRmdYn");
		this.hashFields.put("org_inv_desc", "orgInvDesc");
		this.hashFields.put("mon_xch_rt", "monXchRt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("s_vat_xch_rt_chk", "sVatXchRtChk");
		this.hashFields.put("s_his_seq", "sHisSeq");
		this.hashFields.put("trd_party_code", "trdPartyCode");
		this.hashFields.put("n3pty_cntr_wgt_ut_cd", "n3ptyCntrWgtUtCd");
		this.hashFields.put("new_creditnote_cd", "newCreditnoteCd");
		this.hashFields.put("s_final_flg", "sFinalFlg");
		this.hashFields.put("org_ddct_amt", "orgDdctAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("s_correction_yn", "sCorrectionYn");
		this.hashFields.put("ft_ovr_dys", "ftOvrDys");
		this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
		this.hashFields.put("net_amt", "netAmt");
		this.hashFields.put("s_phn_no", "sPhnNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("tot_expn_tax", "totExpnTax");
		this.hashFields.put("s_inv_rmk2", "sInvRmk2");
		this.hashFields.put("org_vndr_cust_ref_rmk", "orgVndrCustRefRmk");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("s_same_version_yn", "sSameVersionYn");
		this.hashFields.put("s_vndr_cust_ref_rmk", "sVndrCustRefRmk");
		this.hashFields.put("s_bil_loc", "sBilLoc");
		this.hashFields.put("s_cust_cnt_cd", "sCustCntCd");
		this.hashFields.put("new_cntr_seal_no", "newCntrSealNo");
		this.hashFields.put("new_eq_no", "newEqNo");
		this.hashFields.put("s_dao_n3pty_bil_tp_cd", "sDaoN3ptyBilTpCd");
		this.hashFields.put("ots_amt", "otsAmt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("s_from_curr_cd", "sFromCurrCd");
		this.hashFields.put("sdate", "sdate");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("s_add_amt", "sAddAmt");
		this.hashFields.put("s_vndr_cnt_cd", "sVndrCntCd");
		this.hashFields.put("tot_edu_tax", "totEduTax");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("s_n3pty_ofc_cd", "sN3ptyOfcCd");
		this.hashFields.put("org_adm_chrg", "orgAdmChrg");
		this.hashFields.put("s_n3pty_inv_rmd_nm", "sN3ptyInvRmdNm");
		this.hashFields.put("new_bkg_no", "newBkgNo");
		this.hashFields.put("vndr_cust_eml", "vndrCustEml");
		this.hashFields.put("s_inv_rmk1", "sInvRmk1");
		this.hashFields.put("s_ida_tax_seq", "sIdaTaxSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("bil_to_loc_div_cd", "bilToLocDivCd");
		this.hashFields.put("s_net_amt", "sNetAmt");
		this.hashFields.put("s_n3pty_inv_rvis_seq", "sN3ptyInvRvisSeq");
		this.hashFields.put("s_inv_iss_rhq_cd", "sInvIssRhqCd");
		this.hashFields.put("prcs_cnt", "prcsCnt");
		this.hashFields.put("vat_dtl_chk", "vatDtlChk");
		this.hashFields.put("vat_dtl_amt", "vatDtlAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return expnTotalAmt
	 */
	public String getExpnTotalAmt() {
		return this.expnTotalAmt;
	}
	
	/**
	 * Column Info
	 * @return ddctAmt
	 */
	public String getDdctAmt() {
		return this.ddctAmt;
	}
	
	/**
	 * Column Info
	 * @return estmSvrId
	 */
	public String getEstmSvrId() {
		return this.estmSvrId;
	}
	
	/**
	 * Column Info
	 * @return usrInpCtnt1
	 */
	public String getUsrInpCtnt1() {
		return this.usrInpCtnt1;
	}
	
	/**
	 * Column Info
	 * @return sCltAgnRmk
	 */
	public String getSCltAgnRmk() {
		return this.sCltAgnRmk;
	}
	
	/**
	 * Column Info
	 * @return invDtlAmt
	 */
	public String getInvDtlAmt() {
		return this.invDtlAmt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTpNm
	 */
	public String getN3ptyBilTpNm() {
		return this.n3ptyBilTpNm;
	}
	
	/**
	 * Column Info
	 * @return vatXchRtOriginal
	 */
	public String getVatXchRtOriginal() {
		return this.vatXchRtOriginal;
	}
	
	/**
	 * Column Info
	 * @return orgCltAgnFlg
	 */
	public String getOrgCltAgnFlg() {
		return this.orgCltAgnFlg;
	}
	
	/**
	 * Column Info
	 * @return mgsetNo
	 */
	public String getMgsetNo() {
		return this.mgsetNo;
	}
	
	/**
	 * Column Info
	 * @return usrInpCtnt2
	 */
	public String getUsrInpCtnt2() {
		return this.usrInpCtnt2;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return sUsrInpCtnt2
	 */
	public String getSUsrInpCtnt2() {
		return this.sUsrInpCtnt2;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return sUsrInpCtnt1
	 */
	public String getSUsrInpCtnt1() {
		return this.sUsrInpCtnt1;
	}
	
	/**
	 * Column Info
	 * @return edate
	 */
	public String getEdate() {
		return this.edate;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvHisSeq
	 */
	public String getSN3ptyInvHisSeq() {
		return this.sN3ptyInvHisSeq;
	}
	
	/**
	 * Column Info
	 * @return lstExpense
	 */
	public String getLstExpense() {
		return this.lstExpense;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return engAddr
	 */
	public String getEngAddr() {
		return this.engAddr;
	}
	
	/**
	 * Column Info
	 * @return sVatAmt
	 */
	public String getSVatAmt() {
		return this.sVatAmt;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return sAddr
	 */
	public String getSAddr() {
		return this.sAddr;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return orgDueDate
	 */
	public String getOrgDueDate() {
		return this.orgDueDate;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvNoTmp
	 */
	public String getN3ptyInvNoTmp() {
		return this.n3ptyInvNoTmp;
	}
	
	/**
	 * Column Info
	 * @return pkupDt
	 */
	public String getPkupDt() {
		return this.pkupDt;
	}
	
	/**
	 * Column Info
	 * @return delSucess
	 */
	public String getDelSucess() {
		return this.delSucess;
	}
	
	/**
	 * Column Info
	 * @return sSumInvAmt
	 */
	public String getSSumInvAmt() {
		return this.sSumInvAmt;
	}
	
	/**
	 * Column Info
	 * @return sTotalAmt
	 */
	public String getSTotalAmt() {
		return this.sTotalAmt;
	}
	
	/**
	 * Column Info
	 * @return sDdctAmt
	 */
	public String getSDdctAmt() {
		return this.sDdctAmt;
	}
	
	/**
	 * Column Info
	 * @return cltAgnFlg
	 */
	public String getCltAgnFlg() {
		return this.cltAgnFlg;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
	}
	
	/**
	 * Column Info
	 * @return newCreditnoteSeq
	 */
	public String getNewCreditnoteSeq() {
		return this.newCreditnoteSeq;
	}
	
	/**
	 * Column Info
	 * @return sVndrCustAddr2
	 */
	public String getSVndrCustAddr2() {
		return this.sVndrCustAddr2;
	}
	
	/**
	 * Column Info
	 * @return isFrance
	 */
	public String getIsFrance() {
		return this.isFrance;
	}
	
	/**
	 * Column Info
	 * @return totHighEduTax
	 */
	public String getTotHighEduTax() {
		return this.totHighEduTax;
	}
	
	/**
	 * Column Info
	 * @return orgVndrCustAddr
	 */
	public String getOrgVndrCustAddr() {
		return this.orgVndrCustAddr;
	}
	
	/**
	 * Column Info
	 * @return sSteCd
	 */
	public String getSSteCd() {
		return this.sSteCd;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}
	
	/**
	 * Column Info
	 * @return france
	 */
	public String getFrance() {
		return this.france;
	}
	
	/**
	 * Column Info
	 * @return lstFreeDt
	 */
	public String getLstFreeDt() {
		return this.lstFreeDt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvRmdNm
	 */
	public String getN3ptyInvRmdNm() {
		return this.n3ptyInvRmdNm;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvRmdYn
	 */
	public String getSN3ptyInvRmdYn() {
		return this.sN3ptyInvRmdYn;
	}
	
	/**
	 * Column Info
	 * @return erpifYn
	 */
	public String getErpifYn() {
		return this.erpifYn;
	}
	
	/**
	 * Column Info
	 * @return bkgNoAll
	 */
	public String getBkgNoAll() {
		return this.bkgNoAll;
	}
	
	/**
	 * Column Info
	 * @return cnt
	 */
	public String getCnt() {
		return this.cnt;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyNo
	 */
	public String getSN3ptyNo() {
		return this.sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return sVndrSeq
	 */
	public String getSVndrSeq() {
		return this.sVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return sVatXchRt
	 */
	public String getSVatXchRt() {
		return this.sVatXchRt;
	}
	
	/**
	 * Column Info
	 * @return lstInvoiceTotal
	 */
	public String getLstInvoiceTotal() {
		return this.lstInvoiceTotal;
	}
	
	/**
	 * Column Info
	 * @return sCtyNm
	 */
	public String getSCtyNm() {
		return this.sCtyNm;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return sRhqCdForRhq
	 */
	public String getSRhqCdForRhq() {
		return this.sRhqCdForRhq;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return invAmtSts
	 */
	public String getInvAmtSts() {
		return this.invAmtSts;
	}
	
	/**
	 * Column Info
	 * @return viaNodCd
	 */
	public String getViaNodCd() {
		return this.viaNodCd;
	}
	
	/**
	 * Column Info
	 * @return sRgstNo
	 */
	public String getSRgstNo() {
		return this.sRgstNo;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}
	
	/**
	 * Column Info
	 * @return svcCateRmk
	 */
	public String getSvcCateRmk() {
		return this.svcCateRmk;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
	}
	
	/**
	 * Column Info
	 * @return sCustSeq
	 */
	public String getSCustSeq() {
		return this.sCustSeq;
	}
	
	/**
	 * Column Info
	 * @return addAmt
	 */
	public String getAddAmt() {
		return this.addAmt;
	}
	
	/**
	 * Column Info
	 * @return sTrdPartyVal
	 */
	public String getSTrdPartyVal() {
		return this.sTrdPartyVal;
	}
	
	/**
	 * Column Info
	 * @return sCurrCd
	 */
	public String getSCurrCd() {
		return this.sCurrCd;
	}
	
	/**
	 * Column Info
	 * @return otsDtlSeq
	 */
	public String getOtsDtlSeq() {
		return this.otsDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return sVndrCustEml
	 */
	public String getSVndrCustEml() {
		return this.sVndrCustEml;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvNo
	 */
	public String getN3ptyInvNo() {
		return this.n3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @return originalInvDtlAmt
	 */
	public String getOriginalInvDtlAmt() {
		return this.originalInvDtlAmt;
	}
	
	/**
	 * Column Info
	 * @return invDesc
	 */
	public String getInvDesc() {
		return this.invDesc;
	}
	
	/**
	 * Column Info
	 * @return sInquiryonlyYn
	 */
	public String getSInquiryonlyYn() {
		return this.sInquiryonlyYn;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvRmdCd
	 */
	public String getSN3ptyInvRmdCd() {
		return this.sN3ptyInvRmdCd;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvStsCd
	 */
	public String getSN3ptyInvStsCd() {
		return this.sN3ptyInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return finalFlg
	 */
	public String getFinalFlg() {
		return this.finalFlg;
	}
	
	/**
	 * Column Info
	 * @return detailOtsStsCd
	 */
	public String getDetailOtsStsCd() {
		return this.detailOtsStsCd;
	}
	
	/**
	 * Column Info
	 * @return sInvDesc
	 */
	public String getSInvDesc() {
		return this.sInvDesc;
	}
	
	/**
	 * Column Info
	 * @return sVndrCustAddr
	 */
	public String getSVndrCustAddr() {
		return this.sVndrCustAddr;
	}
	
	/**
	 * Column Info
	 * @return invIssRhqCd
	 */
	public String getInvIssRhqCd() {
		return this.invIssRhqCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return sFinalFlgCheckbox
	 */
	public String getSFinalFlgCheckbox() {
		return this.sFinalFlgCheckbox;
	}
	
	/**
	 * Column Info
	 * @return damageDt
	 */
	public String getDamageDt() {
		return this.damageDt;
	}
	
	/**
	 * Column Info
	 * @return detailN3ptyNo
	 */
	public String getDetailN3ptyNo() {
		return this.detailN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return ctyNm
	 */
	public String getCtyNm() {
		return this.ctyNm;
	}
	
	/**
	 * Column Info
	 * @return sInvoiceCancelRemark
	 */
	public String getSInvoiceCancelRemark() {
		return this.sInvoiceCancelRemark;
	}
	
	/**
	 * Column Info
	 * @return totalAmt
	 */
	public String getTotalAmt() {
		return this.totalAmt;
	}
	
	/**
	 * Column Info
	 * @return taxRgstNo
	 */
	public String getTaxRgstNo() {
		return this.taxRgstNo;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return sZipCd
	 */
	public String getSZipCd() {
		return this.sZipCd;
	}
	
	/**
	 * Column Info
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvDtlSeq
	 */
	public String getN3ptyInvDtlSeq() {
		return this.n3ptyInvDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrCustRefRmk
	 */
	public String getVndrCustRefRmk() {
		return this.vndrCustRefRmk;
	}
	
	/**
	 * Column Info
	 * @return cltAgnRmk
	 */
	public String getCltAgnRmk() {
		return this.cltAgnRmk;
	}
	
	/**
	 * Column Info
	 * @return occrDt
	 */
	public String getOccrDt() {
		return this.occrDt;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return orgSteCd
	 */
	public String getOrgSteCd() {
		return this.orgSteCd;
	}
	
	/**
	 * Column Info
	 * @return invIssOfcCd
	 */
	public String getInvIssOfcCd() {
		return this.invIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sRch
	 */
	public String getSRch() {
		return this.sRch;
	}
	
	/**
	 * Column Info
	 * @return sVndrCustNm
	 */
	public String getSVndrCustNm() {
		return this.sVndrCustNm;
	}
	
	/**
	 * Column Info
	 * @return idaTaxSeq
	 */
	public String getIdaTaxSeq() {
		return this.idaTaxSeq;
	}
	
	/**
	 * Column Info
	 * @return eqKndNm
	 */
	public String getEqKndNm() {
		return this.eqKndNm;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return lnkN3ptyInvNo
	 */
	public String getLnkN3ptyInvNo() {
		return this.lnkN3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @return newRvisCd
	 */
	public String getNewRvisCd() {
		return this.newRvisCd;
	}
	
	/**
	 * Column Info
	 * @return sTrdPartyNm
	 */
	public String getSTrdPartyNm() {
		return this.sTrdPartyNm;
	}
	
	/**
	 * Column Info
	 * @return sFrance
	 */
	public String getSFrance() {
		return this.sFrance;
	}
	
	/**
	 * Column Info
	 * @return wtHrs
	 */
	public String getWtHrs() {
		return this.wtHrs;
	}
	
	/**
	 * Column Info
	 * @return vndrCustAddr
	 */
	public String getVndrCustAddr() {
		return this.vndrCustAddr;
	}
	
	/**
	 * Column Info
	 * @return orgCtyNm
	 */
	public String getOrgCtyNm() {
		return this.orgCtyNm;
	}
	
	/**
	 * Column Info
	 * @return soIfSeq
	 */
	public String getSoIfSeq() {
		return this.soIfSeq;
	}
	
	/**
	 * Column Info
	 * @return sRcvDueDt
	 */
	public String getSRcvDueDt() {
		return this.sRcvDueDt;
	}
	
	/**
	 * Column Info
	 * @return sLengthN3ptyBilTpCd
	 */
	public String getSLengthN3ptyBilTpCd() {
		return this.sLengthN3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @return sFaxNo
	 */
	public String getSFaxNo() {
		return this.sFaxNo;
	}
	
	/**
	 * Column Info
	 * @return blNoAll
	 */
	public String getBlNoAll() {
		return this.blNoAll;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return validYnCorrection
	 */
	public String getValidYnCorrection() {
		return this.validYnCorrection;
	}
	
	/**
	 * Column Info
	 * @return sDetailOtsStsCd
	 */
	public String getSDetailOtsStsCd() {
		return this.sDetailOtsStsCd;
	}
	
	/**
	 * Column Info
	 * @return newVslCd
	 */
	public String getNewVslCd() {
		return this.newVslCd;
	}
	
	/**
	 * Column Info
	 * @return lstTax
	 */
	public String getLstTax() {
		return this.lstTax;
	}
	
	/**
	 * Column Info
	 * @return sVndrCustDivCd
	 */
	public String getSVndrCustDivCd() {
		return this.sVndrCustDivCd;
	}
	
	/**
	 * Column Info
	 * @return eduTax
	 */
	public String getEduTax() {
		return this.eduTax;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return sTrdPartyCode
	 */
	public String getSTrdPartyCode() {
		return this.sTrdPartyCode;
	}
	
	/**
	 * Column Info
	 * @return sHVndrCustDivCd
	 */
	public String getSHVndrCustDivCd() {
		return this.sHVndrCustDivCd;
	}
	
	/**
	 * Column Info
	 * @return rgstNo
	 */
	public String getRgstNo() {
		return this.rgstNo;
	}
	
	/**
	 * Column Info
	 * @return otsStsCd
	 */
	public String getOtsStsCd() {
		return this.otsStsCd;
	}
	
	/**
	 * Column Info
	 * @return orgZipCd
	 */
	public String getOrgZipCd() {
		return this.orgZipCd;
	}
	
	/**
	 * Column Info
	 * @return expnTax
	 */
	public String getExpnTax() {
		return this.expnTax;
	}
	
	/**
	 * Column Info
	 * @return sameVersionYn
	 */
	public String getSameVersionYn() {
		return this.sameVersionYn;
	}
	
	/**
	 * Column Info
	 * @return sCltAgnFlg
	 */
	public String getSCltAgnFlg() {
		return this.sCltAgnFlg;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvStsCd
	 */
	public String getN3ptyInvStsCd() {
		return this.n3ptyInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return vndrCustNm
	 */
	public String getVndrCustNm() {
		return this.vndrCustNm;
	}
	
	/**
	 * Column Info
	 * @return newRvisSeq
	 */
	public String getNewRvisSeq() {
		return this.newRvisSeq;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvNo
	 */
	public String getSN3ptyInvNo() {
		return this.sN3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @return orgUsrInpCtnt2
	 */
	public String getOrgUsrInpCtnt2() {
		return this.orgUsrInpCtnt2;
	}
	
	/**
	 * Column Info
	 * @return citaNo
	 */
	public String getCitaNo() {
		return this.citaNo;
	}
	
	/**
	 * Column Info
	 * @return orgUsrInpCtnt1
	 */
	public String getOrgUsrInpCtnt1() {
		return this.orgUsrInpCtnt1;
	}
	
	/**
	 * Column Info
	 * @return totSvcTax
	 */
	public String getTotSvcTax() {
		return this.totSvcTax;
	}
	
	/**
	 * Column Info
	 * @return repairLocation
	 */
	public String getRepairLocation() {
		return this.repairLocation;
	}
	
	/**
	 * Column Info
	 * @return highEduTax
	 */
	public String getHighEduTax() {
		return this.highEduTax;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return vatAmt
	 */
	public String getVatAmt() {
		return this.vatAmt;
	}
	
	/**
	 * Column Info
	 * @return orgTotAmt
	 */
	public String getOrgTotAmt() {
		return this.orgTotAmt;
	}
	
	/**
	 * Column Info
	 * @return sDetailN3ptyNo
	 */
	public String getSDetailN3ptyNo() {
		return this.sDetailN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return route
	 */
	public String getRoute() {
		return this.route;
	}
	
	/**
	 * Column Info
	 * @return rcvDueDt
	 */
	public String getRcvDueDt() {
		return this.rcvDueDt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvRmdYn
	 */
	public String getN3ptyInvRmdYn() {
		return this.n3ptyInvRmdYn;
	}
	
	/**
	 * Column Info
	 * @return orgInvDesc
	 */
	public String getOrgInvDesc() {
		return this.orgInvDesc;
	}
	
	/**
	 * Column Info
	 * @return monXchRt
	 */
	public String getMonXchRt() {
		return this.monXchRt;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return sVatXchRtChk
	 */
	public String getSVatXchRtChk() {
		return this.sVatXchRtChk;
	}
	
	/**
	 * Column Info
	 * @return sHisSeq
	 */
	public String getSHisSeq() {
		return this.sHisSeq;
	}
	
	/**
	 * Column Info
	 * @return trdPartyCode
	 */
	public String getTrdPartyCode() {
		return this.trdPartyCode;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCntrWgtUtCd
	 */
	public String getN3ptyCntrWgtUtCd() {
		return this.n3ptyCntrWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return newCreditnoteCd
	 */
	public String getNewCreditnoteCd() {
		return this.newCreditnoteCd;
	}
	
	/**
	 * Column Info
	 * @return sFinalFlg
	 */
	public String getSFinalFlg() {
		return this.sFinalFlg;
	}
	
	/**
	 * Column Info
	 * @return orgDdctAmt
	 */
	public String getOrgDdctAmt() {
		return this.orgDdctAmt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return sCorrectionYn
	 */
	public String getSCorrectionYn() {
		return this.sCorrectionYn;
	}
	
	/**
	 * Column Info
	 * @return ftOvrDys
	 */
	public String getFtOvrDys() {
		return this.ftOvrDys;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTpCd
	 */
	public String getN3ptyBilTpCd() {
		return this.n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @return netAmt
	 */
	public String getNetAmt() {
		return this.netAmt;
	}
	
	/**
	 * Column Info
	 * @return sPhnNo
	 */
	public String getSPhnNo() {
		return this.sPhnNo;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return totExpnTax
	 */
	public String getTotExpnTax() {
		return this.totExpnTax;
	}
	
	/**
	 * Column Info
	 * @return sInvRmk2
	 */
	public String getSInvRmk2() {
		return this.sInvRmk2;
	}
	
	/**
	 * Column Info
	 * @return orgVndrCustRefRmk
	 */
	public String getOrgVndrCustRefRmk() {
		return this.orgVndrCustRefRmk;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return sSameVersionYn
	 */
	public String getSSameVersionYn() {
		return this.sSameVersionYn;
	}
	
	/**
	 * Column Info
	 * @return sVndrCustRefRmk
	 */
	public String getSVndrCustRefRmk() {
		return this.sVndrCustRefRmk;
	}
	
	/**
	 * Column Info
	 * @return sBilLoc
	 */
	public String getSBilLoc() {
		return this.sBilLoc;
	}
	
	/**
	 * Column Info
	 * @return sCustCntCd
	 */
	public String getSCustCntCd() {
		return this.sCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return newCntrSealNo
	 */
	public String getNewCntrSealNo() {
		return this.newCntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return newEqNo
	 */
	public String getNewEqNo() {
		return this.newEqNo;
	}
	
	/**
	 * Column Info
	 * @return sDaoN3ptyBilTpCd
	 */
	public String getSDaoN3ptyBilTpCd() {
		return this.sDaoN3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @return otsAmt
	 */
	public String getOtsAmt() {
		return this.otsAmt;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return sFromCurrCd
	 */
	public String getSFromCurrCd() {
		return this.sFromCurrCd;
	}
	
	/**
	 * Column Info
	 * @return sdate
	 */
	public String getSdate() {
		return this.sdate;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return sAddAmt
	 */
	public String getSAddAmt() {
		return this.sAddAmt;
	}
	
	/**
	 * Column Info
	 * @return sVndrCntCd
	 */
	public String getSVndrCntCd() {
		return this.sVndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return totEduTax
	 */
	public String getTotEduTax() {
		return this.totEduTax;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyOfcCd
	 */
	public String getSN3ptyOfcCd() {
		return this.sN3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @return orgAdmChrg
	 */
	public String getOrgAdmChrg() {
		return this.orgAdmChrg;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvRmdNm
	 */
	public String getSN3ptyInvRmdNm() {
		return this.sN3ptyInvRmdNm;
	}
	
	/**
	 * Column Info
	 * @return newBkgNo
	 */
	public String getNewBkgNo() {
		return this.newBkgNo;
	}
	
	/**
	 * Column Info
	 * @return vndrCustEml
	 */
	public String getVndrCustEml() {
		return this.vndrCustEml;
	}
	
	/**
	 * Column Info
	 * @return sInvRmk1
	 */
	public String getSInvRmk1() {
		return this.sInvRmk1;
	}
	
	/**
	 * Column Info
	 * @return sIdaTaxSeq
	 */
	public String getSIdaTaxSeq() {
		return this.sIdaTaxSeq;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return bilToLocDivCd
	 */
	public String getBilToLocDivCd() {
		return this.bilToLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return sNetAmt
	 */
	public String getSNetAmt() {
		return this.sNetAmt;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvRvisSeq
	 */
	public String getSN3ptyInvRvisSeq() {
		return this.sN3ptyInvRvisSeq;
	}
	
	/**
	 * Column Info
	 * @return sInvIssRhqCd
	 */
	public String getSInvIssRhqCd() {
		return this.sInvIssRhqCd;
	}
	
	/**
	 * Column Info
	 * @return prcsCnt
	 */
	public String getPrcsCnt() {
		return this.prcsCnt;
	}
	
	/**
	 * Column Info
	 * @return vatDtlChk
	 */
	public String getVatDtlChk() {
		return this.vatDtlChk;
	}
	
	/**
	 * Column Info
	 * @return vatDtlAmt
	 */
	public String getVatDtlAmt() {
		return this.vatDtlAmt;
	}
	

	/**
	 * Column Info
	 * @param expnTotalAmt
	 */
	public void setExpnTotalAmt(String expnTotalAmt) {
		this.expnTotalAmt = expnTotalAmt;
	}
	
	/**
	 * Column Info
	 * @param ddctAmt
	 */
	public void setDdctAmt(String ddctAmt) {
		this.ddctAmt = ddctAmt;
	}
	
	/**
	 * Column Info
	 * @param estmSvrId
	 */
	public void setEstmSvrId(String estmSvrId) {
		this.estmSvrId = estmSvrId;
	}
	
	/**
	 * Column Info
	 * @param usrInpCtnt1
	 */
	public void setUsrInpCtnt1(String usrInpCtnt1) {
		this.usrInpCtnt1 = usrInpCtnt1;
	}
	
	/**
	 * Column Info
	 * @param sCltAgnRmk
	 */
	public void setSCltAgnRmk(String sCltAgnRmk) {
		this.sCltAgnRmk = sCltAgnRmk;
	}
	
	/**
	 * Column Info
	 * @param invDtlAmt
	 */
	public void setInvDtlAmt(String invDtlAmt) {
		this.invDtlAmt = invDtlAmt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTpNm
	 */
	public void setN3ptyBilTpNm(String n3ptyBilTpNm) {
		this.n3ptyBilTpNm = n3ptyBilTpNm;
	}
	
	/**
	 * Column Info
	 * @param vatXchRtOriginal
	 */
	public void setVatXchRtOriginal(String vatXchRtOriginal) {
		this.vatXchRtOriginal = vatXchRtOriginal;
	}
	
	/**
	 * Column Info
	 * @param orgCltAgnFlg
	 */
	public void setOrgCltAgnFlg(String orgCltAgnFlg) {
		this.orgCltAgnFlg = orgCltAgnFlg;
	}
	
	/**
	 * Column Info
	 * @param mgsetNo
	 */
	public void setMgsetNo(String mgsetNo) {
		this.mgsetNo = mgsetNo;
	}
	
	/**
	 * Column Info
	 * @param usrInpCtnt2
	 */
	public void setUsrInpCtnt2(String usrInpCtnt2) {
		this.usrInpCtnt2 = usrInpCtnt2;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param sUsrInpCtnt2
	 */
	public void setSUsrInpCtnt2(String sUsrInpCtnt2) {
		this.sUsrInpCtnt2 = sUsrInpCtnt2;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param sUsrInpCtnt1
	 */
	public void setSUsrInpCtnt1(String sUsrInpCtnt1) {
		this.sUsrInpCtnt1 = sUsrInpCtnt1;
	}
	
	/**
	 * Column Info
	 * @param edate
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvHisSeq
	 */
	public void setSN3ptyInvHisSeq(String sN3ptyInvHisSeq) {
		this.sN3ptyInvHisSeq = sN3ptyInvHisSeq;
	}
	
	/**
	 * Column Info
	 * @param lstExpense
	 */
	public void setLstExpense(String lstExpense) {
		this.lstExpense = lstExpense;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param engAddr
	 */
	public void setEngAddr(String engAddr) {
		this.engAddr = engAddr;
	}
	
	/**
	 * Column Info
	 * @param sVatAmt
	 */
	public void setSVatAmt(String sVatAmt) {
		this.sVatAmt = sVatAmt;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param sAddr
	 */
	public void setSAddr(String sAddr) {
		this.sAddr = sAddr;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param orgDueDate
	 */
	public void setOrgDueDate(String orgDueDate) {
		this.orgDueDate = orgDueDate;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvNoTmp
	 */
	public void setN3ptyInvNoTmp(String n3ptyInvNoTmp) {
		this.n3ptyInvNoTmp = n3ptyInvNoTmp;
	}
	
	/**
	 * Column Info
	 * @param pkupDt
	 */
	public void setPkupDt(String pkupDt) {
		this.pkupDt = pkupDt;
	}
	
	/**
	 * Column Info
	 * @param delSucess
	 */
	public void setDelSucess(String delSucess) {
		this.delSucess = delSucess;
	}
	
	/**
	 * Column Info
	 * @param sSumInvAmt
	 */
	public void setSSumInvAmt(String sSumInvAmt) {
		this.sSumInvAmt = sSumInvAmt;
	}
	
	/**
	 * Column Info
	 * @param sTotalAmt
	 */
	public void setSTotalAmt(String sTotalAmt) {
		this.sTotalAmt = sTotalAmt;
	}
	
	/**
	 * Column Info
	 * @param sDdctAmt
	 */
	public void setSDdctAmt(String sDdctAmt) {
		this.sDdctAmt = sDdctAmt;
	}
	
	/**
	 * Column Info
	 * @param cltAgnFlg
	 */
	public void setCltAgnFlg(String cltAgnFlg) {
		this.cltAgnFlg = cltAgnFlg;
	}
	
	/**
	 * Column Info
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * Column Info
	 * @param newCreditnoteSeq
	 */
	public void setNewCreditnoteSeq(String newCreditnoteSeq) {
		this.newCreditnoteSeq = newCreditnoteSeq;
	}
	
	/**
	 * Column Info
	 * @param sVndrCustAddr2
	 */
	public void setSVndrCustAddr2(String sVndrCustAddr2) {
		this.sVndrCustAddr2 = sVndrCustAddr2;
	}
	
	/**
	 * Column Info
	 * @param isFrance
	 */
	public void setIsFrance(String isFrance) {
		this.isFrance = isFrance;
	}
	
	/**
	 * Column Info
	 * @param totHighEduTax
	 */
	public void setTotHighEduTax(String totHighEduTax) {
		this.totHighEduTax = totHighEduTax;
	}
	
	/**
	 * Column Info
	 * @param orgVndrCustAddr
	 */
	public void setOrgVndrCustAddr(String orgVndrCustAddr) {
		this.orgVndrCustAddr = orgVndrCustAddr;
	}
	
	/**
	 * Column Info
	 * @param sSteCd
	 */
	public void setSSteCd(String sSteCd) {
		this.sSteCd = sSteCd;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	
	/**
	 * Column Info
	 * @param france
	 */
	public void setFrance(String france) {
		this.france = france;
	}
	
	/**
	 * Column Info
	 * @param lstFreeDt
	 */
	public void setLstFreeDt(String lstFreeDt) {
		this.lstFreeDt = lstFreeDt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvRmdNm
	 */
	public void setN3ptyInvRmdNm(String n3ptyInvRmdNm) {
		this.n3ptyInvRmdNm = n3ptyInvRmdNm;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvRmdYn
	 */
	public void setSN3ptyInvRmdYn(String sN3ptyInvRmdYn) {
		this.sN3ptyInvRmdYn = sN3ptyInvRmdYn;
	}
	
	/**
	 * Column Info
	 * @param erpifYn
	 */
	public void setErpifYn(String erpifYn) {
		this.erpifYn = erpifYn;
	}
	
	/**
	 * Column Info
	 * @param bkgNoAll
	 */
	public void setBkgNoAll(String bkgNoAll) {
		this.bkgNoAll = bkgNoAll;
	}
	
	/**
	 * Column Info
	 * @param cnt
	 */
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyNo
	 */
	public void setSN3ptyNo(String sN3ptyNo) {
		this.sN3ptyNo = sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param sVndrSeq
	 */
	public void setSVndrSeq(String sVndrSeq) {
		this.sVndrSeq = sVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param sVatXchRt
	 */
	public void setSVatXchRt(String sVatXchRt) {
		this.sVatXchRt = sVatXchRt;
	}
	
	/**
	 * Column Info
	 * @param lstInvoiceTotal
	 */
	public void setLstInvoiceTotal(String lstInvoiceTotal) {
		this.lstInvoiceTotal = lstInvoiceTotal;
	}
	
	/**
	 * Column Info
	 * @param sCtyNm
	 */
	public void setSCtyNm(String sCtyNm) {
		this.sCtyNm = sCtyNm;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param sRhqCdForRhq
	 */
	public void setSRhqCdForRhq(String sRhqCdForRhq) {
		this.sRhqCdForRhq = sRhqCdForRhq;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param invAmtSts
	 */
	public void setInvAmtSts(String invAmtSts) {
		this.invAmtSts = invAmtSts;
	}
	
	/**
	 * Column Info
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * Column Info
	 * @param sRgstNo
	 */
	public void setSRgstNo(String sRgstNo) {
		this.sRgstNo = sRgstNo;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Column Info
	 * @param svcCateRmk
	 */
	public void setSvcCateRmk(String svcCateRmk) {
		this.svcCateRmk = svcCateRmk;
	}
	
	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
	}
	
	/**
	 * Column Info
	 * @param sCustSeq
	 */
	public void setSCustSeq(String sCustSeq) {
		this.sCustSeq = sCustSeq;
	}
	
	/**
	 * Column Info
	 * @param addAmt
	 */
	public void setAddAmt(String addAmt) {
		this.addAmt = addAmt;
	}
	
	/**
	 * Column Info
	 * @param sTrdPartyVal
	 */
	public void setSTrdPartyVal(String sTrdPartyVal) {
		this.sTrdPartyVal = sTrdPartyVal;
	}
	
	/**
	 * Column Info
	 * @param sCurrCd
	 */
	public void setSCurrCd(String sCurrCd) {
		this.sCurrCd = sCurrCd;
	}
	
	/**
	 * Column Info
	 * @param otsDtlSeq
	 */
	public void setOtsDtlSeq(String otsDtlSeq) {
		this.otsDtlSeq = otsDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param sVndrCustEml
	 */
	public void setSVndrCustEml(String sVndrCustEml) {
		this.sVndrCustEml = sVndrCustEml;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvNo
	 */
	public void setN3ptyInvNo(String n3ptyInvNo) {
		this.n3ptyInvNo = n3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @param originalInvDtlAmt
	 */
	public void setOriginalInvDtlAmt(String originalInvDtlAmt) {
		this.originalInvDtlAmt = originalInvDtlAmt;
	}
	
	/**
	 * Column Info
	 * @param invDesc
	 */
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
	}
	
	/**
	 * Column Info
	 * @param sInquiryonlyYn
	 */
	public void setSInquiryonlyYn(String sInquiryonlyYn) {
		this.sInquiryonlyYn = sInquiryonlyYn;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvRmdCd
	 */
	public void setSN3ptyInvRmdCd(String sN3ptyInvRmdCd) {
		this.sN3ptyInvRmdCd = sN3ptyInvRmdCd;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvStsCd
	 */
	public void setSN3ptyInvStsCd(String sN3ptyInvStsCd) {
		this.sN3ptyInvStsCd = sN3ptyInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param finalFlg
	 */
	public void setFinalFlg(String finalFlg) {
		this.finalFlg = finalFlg;
	}
	
	/**
	 * Column Info
	 * @param detailOtsStsCd
	 */
	public void setDetailOtsStsCd(String detailOtsStsCd) {
		this.detailOtsStsCd = detailOtsStsCd;
	}
	
	/**
	 * Column Info
	 * @param sInvDesc
	 */
	public void setSInvDesc(String sInvDesc) {
		this.sInvDesc = sInvDesc;
	}
	
	/**
	 * Column Info
	 * @param sVndrCustAddr
	 */
	public void setSVndrCustAddr(String sVndrCustAddr) {
		this.sVndrCustAddr = sVndrCustAddr;
	}
	
	/**
	 * Column Info
	 * @param invIssRhqCd
	 */
	public void setInvIssRhqCd(String invIssRhqCd) {
		this.invIssRhqCd = invIssRhqCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param sFinalFlgCheckbox
	 */
	public void setSFinalFlgCheckbox(String sFinalFlgCheckbox) {
		this.sFinalFlgCheckbox = sFinalFlgCheckbox;
	}
	
	/**
	 * Column Info
	 * @param damageDt
	 */
	public void setDamageDt(String damageDt) {
		this.damageDt = damageDt;
	}
	
	/**
	 * Column Info
	 * @param detailN3ptyNo
	 */
	public void setDetailN3ptyNo(String detailN3ptyNo) {
		this.detailN3ptyNo = detailN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param ctyNm
	 */
	public void setCtyNm(String ctyNm) {
		this.ctyNm = ctyNm;
	}
	
	/**
	 * Column Info
	 * @param sInvoiceCancelRemark
	 */
	public void setSInvoiceCancelRemark(String sInvoiceCancelRemark) {
		this.sInvoiceCancelRemark = sInvoiceCancelRemark;
	}
	
	/**
	 * Column Info
	 * @param totalAmt
	 */
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	/**
	 * Column Info
	 * @param taxRgstNo
	 */
	public void setTaxRgstNo(String taxRgstNo) {
		this.taxRgstNo = taxRgstNo;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param sZipCd
	 */
	public void setSZipCd(String sZipCd) {
		this.sZipCd = sZipCd;
	}
	
	/**
	 * Column Info
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvDtlSeq
	 */
	public void setN3ptyInvDtlSeq(String n3ptyInvDtlSeq) {
		this.n3ptyInvDtlSeq = n3ptyInvDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrCustRefRmk
	 */
	public void setVndrCustRefRmk(String vndrCustRefRmk) {
		this.vndrCustRefRmk = vndrCustRefRmk;
	}
	
	/**
	 * Column Info
	 * @param cltAgnRmk
	 */
	public void setCltAgnRmk(String cltAgnRmk) {
		this.cltAgnRmk = cltAgnRmk;
	}
	
	/**
	 * Column Info
	 * @param occrDt
	 */
	public void setOccrDt(String occrDt) {
		this.occrDt = occrDt;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param orgSteCd
	 */
	public void setOrgSteCd(String orgSteCd) {
		this.orgSteCd = orgSteCd;
	}
	
	/**
	 * Column Info
	 * @param invIssOfcCd
	 */
	public void setInvIssOfcCd(String invIssOfcCd) {
		this.invIssOfcCd = invIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sRch
	 */
	public void setSRch(String sRch) {
		this.sRch = sRch;
	}
	
	/**
	 * Column Info
	 * @param sVndrCustNm
	 */
	public void setSVndrCustNm(String sVndrCustNm) {
		this.sVndrCustNm = sVndrCustNm;
	}
	
	/**
	 * Column Info
	 * @param idaTaxSeq
	 */
	public void setIdaTaxSeq(String idaTaxSeq) {
		this.idaTaxSeq = idaTaxSeq;
	}
	
	/**
	 * Column Info
	 * @param eqKndNm
	 */
	public void setEqKndNm(String eqKndNm) {
		this.eqKndNm = eqKndNm;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param lnkN3ptyInvNo
	 */
	public void setLnkN3ptyInvNo(String lnkN3ptyInvNo) {
		this.lnkN3ptyInvNo = lnkN3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @param newRvisCd
	 */
	public void setNewRvisCd(String newRvisCd) {
		this.newRvisCd = newRvisCd;
	}
	
	/**
	 * Column Info
	 * @param sTrdPartyNm
	 */
	public void setSTrdPartyNm(String sTrdPartyNm) {
		this.sTrdPartyNm = sTrdPartyNm;
	}
	
	/**
	 * Column Info
	 * @param sFrance
	 */
	public void setSFrance(String sFrance) {
		this.sFrance = sFrance;
	}
	
	/**
	 * Column Info
	 * @param wtHrs
	 */
	public void setWtHrs(String wtHrs) {
		this.wtHrs = wtHrs;
	}
	
	/**
	 * Column Info
	 * @param vndrCustAddr
	 */
	public void setVndrCustAddr(String vndrCustAddr) {
		this.vndrCustAddr = vndrCustAddr;
	}
	
	/**
	 * Column Info
	 * @param orgCtyNm
	 */
	public void setOrgCtyNm(String orgCtyNm) {
		this.orgCtyNm = orgCtyNm;
	}
	
	/**
	 * Column Info
	 * @param soIfSeq
	 */
	public void setSoIfSeq(String soIfSeq) {
		this.soIfSeq = soIfSeq;
	}
	
	/**
	 * Column Info
	 * @param sRcvDueDt
	 */
	public void setSRcvDueDt(String sRcvDueDt) {
		this.sRcvDueDt = sRcvDueDt;
	}
	
	/**
	 * Column Info
	 * @param sLengthN3ptyBilTpCd
	 */
	public void setSLengthN3ptyBilTpCd(String sLengthN3ptyBilTpCd) {
		this.sLengthN3ptyBilTpCd = sLengthN3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @param sFaxNo
	 */
	public void setSFaxNo(String sFaxNo) {
		this.sFaxNo = sFaxNo;
	}
	
	/**
	 * Column Info
	 * @param blNoAll
	 */
	public void setBlNoAll(String blNoAll) {
		this.blNoAll = blNoAll;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param validYnCorrection
	 */
	public void setValidYnCorrection(String validYnCorrection) {
		this.validYnCorrection = validYnCorrection;
	}
	
	/**
	 * Column Info
	 * @param sDetailOtsStsCd
	 */
	public void setSDetailOtsStsCd(String sDetailOtsStsCd) {
		this.sDetailOtsStsCd = sDetailOtsStsCd;
	}
	
	/**
	 * Column Info
	 * @param newVslCd
	 */
	public void setNewVslCd(String newVslCd) {
		this.newVslCd = newVslCd;
	}
	
	/**
	 * Column Info
	 * @param lstTax
	 */
	public void setLstTax(String lstTax) {
		this.lstTax = lstTax;
	}
	
	/**
	 * Column Info
	 * @param sVndrCustDivCd
	 */
	public void setSVndrCustDivCd(String sVndrCustDivCd) {
		this.sVndrCustDivCd = sVndrCustDivCd;
	}
	
	/**
	 * Column Info
	 * @param eduTax
	 */
	public void setEduTax(String eduTax) {
		this.eduTax = eduTax;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param sTrdPartyCode
	 */
	public void setSTrdPartyCode(String sTrdPartyCode) {
		this.sTrdPartyCode = sTrdPartyCode;
	}
	
	/**
	 * Column Info
	 * @param sHVndrCustDivCd
	 */
	public void setSHVndrCustDivCd(String sHVndrCustDivCd) {
		this.sHVndrCustDivCd = sHVndrCustDivCd;
	}
	
	/**
	 * Column Info
	 * @param rgstNo
	 */
	public void setRgstNo(String rgstNo) {
		this.rgstNo = rgstNo;
	}
	
	/**
	 * Column Info
	 * @param otsStsCd
	 */
	public void setOtsStsCd(String otsStsCd) {
		this.otsStsCd = otsStsCd;
	}
	
	/**
	 * Column Info
	 * @param orgZipCd
	 */
	public void setOrgZipCd(String orgZipCd) {
		this.orgZipCd = orgZipCd;
	}
	
	/**
	 * Column Info
	 * @param expnTax
	 */
	public void setExpnTax(String expnTax) {
		this.expnTax = expnTax;
	}
	
	/**
	 * Column Info
	 * @param sameVersionYn
	 */
	public void setSameVersionYn(String sameVersionYn) {
		this.sameVersionYn = sameVersionYn;
	}
	
	/**
	 * Column Info
	 * @param sCltAgnFlg
	 */
	public void setSCltAgnFlg(String sCltAgnFlg) {
		this.sCltAgnFlg = sCltAgnFlg;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvStsCd
	 */
	public void setN3ptyInvStsCd(String n3ptyInvStsCd) {
		this.n3ptyInvStsCd = n3ptyInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param vndrCustNm
	 */
	public void setVndrCustNm(String vndrCustNm) {
		this.vndrCustNm = vndrCustNm;
	}
	
	/**
	 * Column Info
	 * @param newRvisSeq
	 */
	public void setNewRvisSeq(String newRvisSeq) {
		this.newRvisSeq = newRvisSeq;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvNo
	 */
	public void setSN3ptyInvNo(String sN3ptyInvNo) {
		this.sN3ptyInvNo = sN3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @param orgUsrInpCtnt2
	 */
	public void setOrgUsrInpCtnt2(String orgUsrInpCtnt2) {
		this.orgUsrInpCtnt2 = orgUsrInpCtnt2;
	}
	
	/**
	 * Column Info
	 * @param citaNo
	 */
	public void setCitaNo(String citaNo) {
		this.citaNo = citaNo;
	}
	
	/**
	 * Column Info
	 * @param orgUsrInpCtnt1
	 */
	public void setOrgUsrInpCtnt1(String orgUsrInpCtnt1) {
		this.orgUsrInpCtnt1 = orgUsrInpCtnt1;
	}
	
	/**
	 * Column Info
	 * @param totSvcTax
	 */
	public void setTotSvcTax(String totSvcTax) {
		this.totSvcTax = totSvcTax;
	}
	
	/**
	 * Column Info
	 * @param repairLocation
	 */
	public void setRepairLocation(String repairLocation) {
		this.repairLocation = repairLocation;
	}
	
	/**
	 * Column Info
	 * @param highEduTax
	 */
	public void setHighEduTax(String highEduTax) {
		this.highEduTax = highEduTax;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param vatAmt
	 */
	public void setVatAmt(String vatAmt) {
		this.vatAmt = vatAmt;
	}
	
	/**
	 * Column Info
	 * @param orgTotAmt
	 */
	public void setOrgTotAmt(String orgTotAmt) {
		this.orgTotAmt = orgTotAmt;
	}
	
	/**
	 * Column Info
	 * @param sDetailN3ptyNo
	 */
	public void setSDetailN3ptyNo(String sDetailN3ptyNo) {
		this.sDetailN3ptyNo = sDetailN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param route
	 */
	public void setRoute(String route) {
		this.route = route;
	}
	
	/**
	 * Column Info
	 * @param rcvDueDt
	 */
	public void setRcvDueDt(String rcvDueDt) {
		this.rcvDueDt = rcvDueDt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvRmdYn
	 */
	public void setN3ptyInvRmdYn(String n3ptyInvRmdYn) {
		this.n3ptyInvRmdYn = n3ptyInvRmdYn;
	}
	
	/**
	 * Column Info
	 * @param orgInvDesc
	 */
	public void setOrgInvDesc(String orgInvDesc) {
		this.orgInvDesc = orgInvDesc;
	}
	
	/**
	 * Column Info
	 * @param monXchRt
	 */
	public void setMonXchRt(String monXchRt) {
		this.monXchRt = monXchRt;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param sVatXchRtChk
	 */
	public void setSVatXchRtChk(String sVatXchRtChk) {
		this.sVatXchRtChk = sVatXchRtChk;
	}
	
	/**
	 * Column Info
	 * @param sHisSeq
	 */
	public void setSHisSeq(String sHisSeq) {
		this.sHisSeq = sHisSeq;
	}
	
	/**
	 * Column Info
	 * @param trdPartyCode
	 */
	public void setTrdPartyCode(String trdPartyCode) {
		this.trdPartyCode = trdPartyCode;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCntrWgtUtCd
	 */
	public void setN3ptyCntrWgtUtCd(String n3ptyCntrWgtUtCd) {
		this.n3ptyCntrWgtUtCd = n3ptyCntrWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param newCreditnoteCd
	 */
	public void setNewCreditnoteCd(String newCreditnoteCd) {
		this.newCreditnoteCd = newCreditnoteCd;
	}
	
	/**
	 * Column Info
	 * @param sFinalFlg
	 */
	public void setSFinalFlg(String sFinalFlg) {
		this.sFinalFlg = sFinalFlg;
	}
	
	/**
	 * Column Info
	 * @param orgDdctAmt
	 */
	public void setOrgDdctAmt(String orgDdctAmt) {
		this.orgDdctAmt = orgDdctAmt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param sCorrectionYn
	 */
	public void setSCorrectionYn(String sCorrectionYn) {
		this.sCorrectionYn = sCorrectionYn;
	}
	
	/**
	 * Column Info
	 * @param ftOvrDys
	 */
	public void setFtOvrDys(String ftOvrDys) {
		this.ftOvrDys = ftOvrDys;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTpCd
	 */
	public void setN3ptyBilTpCd(String n3ptyBilTpCd) {
		this.n3ptyBilTpCd = n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @param netAmt
	 */
	public void setNetAmt(String netAmt) {
		this.netAmt = netAmt;
	}
	
	/**
	 * Column Info
	 * @param sPhnNo
	 */
	public void setSPhnNo(String sPhnNo) {
		this.sPhnNo = sPhnNo;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param totExpnTax
	 */
	public void setTotExpnTax(String totExpnTax) {
		this.totExpnTax = totExpnTax;
	}
	
	/**
	 * Column Info
	 * @param sInvRmk2
	 */
	public void setSInvRmk2(String sInvRmk2) {
		this.sInvRmk2 = sInvRmk2;
	}
	
	/**
	 * Column Info
	 * @param orgVndrCustRefRmk
	 */
	public void setOrgVndrCustRefRmk(String orgVndrCustRefRmk) {
		this.orgVndrCustRefRmk = orgVndrCustRefRmk;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param sSameVersionYn
	 */
	public void setSSameVersionYn(String sSameVersionYn) {
		this.sSameVersionYn = sSameVersionYn;
	}
	
	/**
	 * Column Info
	 * @param sVndrCustRefRmk
	 */
	public void setSVndrCustRefRmk(String sVndrCustRefRmk) {
		this.sVndrCustRefRmk = sVndrCustRefRmk;
	}
	
	/**
	 * Column Info
	 * @param sBilLoc
	 */
	public void setSBilLoc(String sBilLoc) {
		this.sBilLoc = sBilLoc;
	}
	
	/**
	 * Column Info
	 * @param sCustCntCd
	 */
	public void setSCustCntCd(String sCustCntCd) {
		this.sCustCntCd = sCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param newCntrSealNo
	 */
	public void setNewCntrSealNo(String newCntrSealNo) {
		this.newCntrSealNo = newCntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param newEqNo
	 */
	public void setNewEqNo(String newEqNo) {
		this.newEqNo = newEqNo;
	}
	
	/**
	 * Column Info
	 * @param sDaoN3ptyBilTpCd
	 */
	public void setSDaoN3ptyBilTpCd(String sDaoN3ptyBilTpCd) {
		this.sDaoN3ptyBilTpCd = sDaoN3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @param otsAmt
	 */
	public void setOtsAmt(String otsAmt) {
		this.otsAmt = otsAmt;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param sFromCurrCd
	 */
	public void setSFromCurrCd(String sFromCurrCd) {
		this.sFromCurrCd = sFromCurrCd;
	}
	
	/**
	 * Column Info
	 * @param sdate
	 */
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param sAddAmt
	 */
	public void setSAddAmt(String sAddAmt) {
		this.sAddAmt = sAddAmt;
	}
	
	/**
	 * Column Info
	 * @param sVndrCntCd
	 */
	public void setSVndrCntCd(String sVndrCntCd) {
		this.sVndrCntCd = sVndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param totEduTax
	 */
	public void setTotEduTax(String totEduTax) {
		this.totEduTax = totEduTax;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyOfcCd
	 */
	public void setSN3ptyOfcCd(String sN3ptyOfcCd) {
		this.sN3ptyOfcCd = sN3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @param orgAdmChrg
	 */
	public void setOrgAdmChrg(String orgAdmChrg) {
		this.orgAdmChrg = orgAdmChrg;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvRmdNm
	 */
	public void setSN3ptyInvRmdNm(String sN3ptyInvRmdNm) {
		this.sN3ptyInvRmdNm = sN3ptyInvRmdNm;
	}
	
	/**
	 * Column Info
	 * @param newBkgNo
	 */
	public void setNewBkgNo(String newBkgNo) {
		this.newBkgNo = newBkgNo;
	}
	
	/**
	 * Column Info
	 * @param vndrCustEml
	 */
	public void setVndrCustEml(String vndrCustEml) {
		this.vndrCustEml = vndrCustEml;
	}
	
	/**
	 * Column Info
	 * @param sInvRmk1
	 */
	public void setSInvRmk1(String sInvRmk1) {
		this.sInvRmk1 = sInvRmk1;
	}
	
	/**
	 * Column Info
	 * @param sIdaTaxSeq
	 */
	public void setSIdaTaxSeq(String sIdaTaxSeq) {
		this.sIdaTaxSeq = sIdaTaxSeq;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param bilToLocDivCd
	 */
	public void setBilToLocDivCd(String bilToLocDivCd) {
		this.bilToLocDivCd = bilToLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param sNetAmt
	 */
	public void setSNetAmt(String sNetAmt) {
		this.sNetAmt = sNetAmt;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvRvisSeq
	 */
	public void setSN3ptyInvRvisSeq(String sN3ptyInvRvisSeq) {
		this.sN3ptyInvRvisSeq = sN3ptyInvRvisSeq;
	}
	
	/**
	 * Column Info
	 * @param sInvIssRhqCd
	 */
	public void setSInvIssRhqCd(String sInvIssRhqCd) {
		this.sInvIssRhqCd = sInvIssRhqCd;
	}
	
	/**
	 * Column Info
	 * @param prcsCnt
	 */
	public void setPrcsCnt(String prcsCnt) {
		this.prcsCnt = prcsCnt;
	}
	
	/**
	 * Column Info
	 * @param vatDtlChk
	 */
	public void setVatDtlChk(String vatDtlChk) {
		this.vatDtlChk = vatDtlChk;
	}
	
	/**
	 * Column Info
	 * @param vatDtlAmt
	 */
	public void setVatDtlAmt(String vatDtlAmt) {
		this.vatDtlAmt = vatDtlAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setExpnTotalAmt(JSPUtil.getParameter(request, "expn_total_amt", ""));
		setDdctAmt(JSPUtil.getParameter(request, "ddct_amt", ""));
		setEstmSvrId(JSPUtil.getParameter(request, "estm_svr_id", ""));
		setUsrInpCtnt1(JSPUtil.getParameter(request, "usr_inp_ctnt1", ""));
		setSCltAgnRmk(JSPUtil.getParameter(request, "s_clt_agn_rmk", ""));
		setInvDtlAmt(JSPUtil.getParameter(request, "inv_dtl_amt", ""));
		setN3ptyBilTpNm(JSPUtil.getParameter(request, "n3pty_bil_tp_nm", ""));
		setVatXchRtOriginal(JSPUtil.getParameter(request, "vat_xch_rt_original", ""));
		setOrgCltAgnFlg(JSPUtil.getParameter(request, "org_clt_agn_flg", ""));
		setMgsetNo(JSPUtil.getParameter(request, "mgset_no", ""));
		setUsrInpCtnt2(JSPUtil.getParameter(request, "usr_inp_ctnt2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSUsrInpCtnt2(JSPUtil.getParameter(request, "s_usr_inp_ctnt2", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setSUsrInpCtnt1(JSPUtil.getParameter(request, "s_usr_inp_ctnt1", ""));
		setEdate(JSPUtil.getParameter(request, "edate", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setSN3ptyInvHisSeq(JSPUtil.getParameter(request, "s_n3pty_inv_his_seq", ""));
		setLstExpense(JSPUtil.getParameter(request, "lst_expense", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setEngAddr(JSPUtil.getParameter(request, "eng_addr", ""));
		setSVatAmt(JSPUtil.getParameter(request, "s_vat_amt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSAddr(JSPUtil.getParameter(request, "s_addr", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setOrgDueDate(JSPUtil.getParameter(request, "org_due_date", ""));
		setN3ptyInvNoTmp(JSPUtil.getParameter(request, "n3pty_inv_no_tmp", ""));
		setPkupDt(JSPUtil.getParameter(request, "pkup_dt", ""));
		setDelSucess(JSPUtil.getParameter(request, "del_sucess", ""));
		setSSumInvAmt(JSPUtil.getParameter(request, "s_sum_inv_amt", ""));
		setSTotalAmt(JSPUtil.getParameter(request, "s_total_amt", ""));
		setSDdctAmt(JSPUtil.getParameter(request, "s_ddct_amt", ""));
		setCltAgnFlg(JSPUtil.getParameter(request, "clt_agn_flg", ""));
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setNewCreditnoteSeq(JSPUtil.getParameter(request, "new_creditnote_seq", ""));
		setSVndrCustAddr2(JSPUtil.getParameter(request, "s_vndr_cust_addr2", ""));
		setIsFrance(JSPUtil.getParameter(request, "is_france", ""));
		setTotHighEduTax(JSPUtil.getParameter(request, "tot_high_edu_tax", ""));
		setOrgVndrCustAddr(JSPUtil.getParameter(request, "org_vndr_cust_addr", ""));
		setSSteCd(JSPUtil.getParameter(request, "s_ste_cd", ""));
		setDorNodCd(JSPUtil.getParameter(request, "dor_nod_cd", ""));
		setFrance(JSPUtil.getParameter(request, "france", ""));
		setLstFreeDt(JSPUtil.getParameter(request, "lst_free_dt", ""));
		setN3ptyInvRmdNm(JSPUtil.getParameter(request, "n3pty_inv_rmd_nm", ""));
		setSN3ptyInvRmdYn(JSPUtil.getParameter(request, "s_n3pty_inv_rmd_yn", ""));
		setErpifYn(JSPUtil.getParameter(request, "erpif_yn", ""));
		setBkgNoAll(JSPUtil.getParameter(request, "bkg_no_all", ""));
		setCnt(JSPUtil.getParameter(request, "cnt", ""));
		setSN3ptyNo(JSPUtil.getParameter(request, "s_n3pty_no", ""));
		setSVndrSeq(JSPUtil.getParameter(request, "s_vndr_seq", ""));
		setSVatXchRt(JSPUtil.getParameter(request, "s_vat_xch_rt", ""));
		setLstInvoiceTotal(JSPUtil.getParameter(request, "lst_invoice_total", ""));
		setSCtyNm(JSPUtil.getParameter(request, "s_cty_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setSRhqCdForRhq(JSPUtil.getParameter(request, "s_rhq_cd_for_rhq", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setInvAmtSts(JSPUtil.getParameter(request, "inv_amt_sts", ""));
		setViaNodCd(JSPUtil.getParameter(request, "via_nod_cd", ""));
		setSRgstNo(JSPUtil.getParameter(request, "s_rgst_no", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
		setSvcCateRmk(JSPUtil.getParameter(request, "svc_cate_rmk", ""));
		setToNodCd(JSPUtil.getParameter(request, "to_nod_cd", ""));
		setGlDt(JSPUtil.getParameter(request, "gl_dt", ""));
		setSCustSeq(JSPUtil.getParameter(request, "s_cust_seq", ""));
		setAddAmt(JSPUtil.getParameter(request, "add_amt", ""));
		setSTrdPartyVal(JSPUtil.getParameter(request, "s_trd_party_val", ""));
		setSCurrCd(JSPUtil.getParameter(request, "s_curr_cd", ""));
		setOtsDtlSeq(JSPUtil.getParameter(request, "ots_dtl_seq", ""));
		setSVndrCustEml(JSPUtil.getParameter(request, "s_vndr_cust_eml", ""));
		setN3ptyInvNo(JSPUtil.getParameter(request, "n3pty_inv_no", ""));
		setOriginalInvDtlAmt(JSPUtil.getParameter(request, "original_inv_dtl_amt", ""));
		setInvDesc(JSPUtil.getParameter(request, "inv_desc", ""));
		setSInquiryonlyYn(JSPUtil.getParameter(request, "s_inquiryonly_yn", ""));
		setSN3ptyInvRmdCd(JSPUtil.getParameter(request, "s_n3pty_inv_rmd_cd", ""));
		setSN3ptyInvStsCd(JSPUtil.getParameter(request, "s_n3pty_inv_sts_cd", ""));
		setFinalFlg(JSPUtil.getParameter(request, "final_flg", ""));
		setDetailOtsStsCd(JSPUtil.getParameter(request, "detail_ots_sts_cd", ""));
		setSInvDesc(JSPUtil.getParameter(request, "s_inv_desc", ""));
		setSVndrCustAddr(JSPUtil.getParameter(request, "s_vndr_cust_addr", ""));
		setInvIssRhqCd(JSPUtil.getParameter(request, "inv_iss_rhq_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setSFinalFlgCheckbox(JSPUtil.getParameter(request, "s_final_flg_checkbox", ""));
		setDamageDt(JSPUtil.getParameter(request, "damage_dt", ""));
		setDetailN3ptyNo(JSPUtil.getParameter(request, "detail_n3pty_no", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setCtyNm(JSPUtil.getParameter(request, "cty_nm", ""));
		setSInvoiceCancelRemark(JSPUtil.getParameter(request, "s_invoice_cancel_remark", ""));
		setTotalAmt(JSPUtil.getParameter(request, "total_amt", ""));
		setTaxRgstNo(JSPUtil.getParameter(request, "tax_rgst_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSZipCd(JSPUtil.getParameter(request, "s_zip_cd", ""));
		setHisSeq(JSPUtil.getParameter(request, "his_seq", ""));
		setN3ptyInvDtlSeq(JSPUtil.getParameter(request, "n3pty_inv_dtl_seq", ""));
		setVndrCustRefRmk(JSPUtil.getParameter(request, "vndr_cust_ref_rmk", ""));
		setCltAgnRmk(JSPUtil.getParameter(request, "clt_agn_rmk", ""));
		setOccrDt(JSPUtil.getParameter(request, "occr_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setOrgSteCd(JSPUtil.getParameter(request, "org_ste_cd", ""));
		setInvIssOfcCd(JSPUtil.getParameter(request, "inv_iss_ofc_cd", ""));
		setSRch(JSPUtil.getParameter(request, "s_rch", ""));
		setSVndrCustNm(JSPUtil.getParameter(request, "s_vndr_cust_nm", ""));
		setIdaTaxSeq(JSPUtil.getParameter(request, "ida_tax_seq", ""));
		setEqKndNm(JSPUtil.getParameter(request, "eq_knd_nm", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setLnkN3ptyInvNo(JSPUtil.getParameter(request, "lnk_n3pty_inv_no", ""));
		setNewRvisCd(JSPUtil.getParameter(request, "new_rvis_cd", ""));
		setSTrdPartyNm(JSPUtil.getParameter(request, "s_trd_party_nm", ""));
		setSFrance(JSPUtil.getParameter(request, "s_france", ""));
		setWtHrs(JSPUtil.getParameter(request, "wt_hrs", ""));
		setVndrCustAddr(JSPUtil.getParameter(request, "vndr_cust_addr", ""));
		setOrgCtyNm(JSPUtil.getParameter(request, "org_cty_nm", ""));
		setSoIfSeq(JSPUtil.getParameter(request, "so_if_seq", ""));
		setSRcvDueDt(JSPUtil.getParameter(request, "s_rcv_due_dt", ""));
		setSLengthN3ptyBilTpCd(JSPUtil.getParameter(request, "s_length_n3pty_bil_tp_cd", ""));
		setSFaxNo(JSPUtil.getParameter(request, "s_fax_no", ""));
		setBlNoAll(JSPUtil.getParameter(request, "bl_no_all", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setValidYnCorrection(JSPUtil.getParameter(request, "valid_yn_correction", ""));
		setSDetailOtsStsCd(JSPUtil.getParameter(request, "s_detail_ots_sts_cd", ""));
		setNewVslCd(JSPUtil.getParameter(request, "new_vsl_cd", ""));
		setLstTax(JSPUtil.getParameter(request, "lst_tax", ""));
		setSVndrCustDivCd(JSPUtil.getParameter(request, "s_vndr_cust_div_cd", ""));
		setEduTax(JSPUtil.getParameter(request, "edu_tax", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setZipCd(JSPUtil.getParameter(request, "zip_cd", ""));
		setSTrdPartyCode(JSPUtil.getParameter(request, "s_trd_party_code", ""));
		setSHVndrCustDivCd(JSPUtil.getParameter(request, "s_h_vndr_cust_div_cd", ""));
		setRgstNo(JSPUtil.getParameter(request, "rgst_no", ""));
		setOtsStsCd(JSPUtil.getParameter(request, "ots_sts_cd", ""));
		setOrgZipCd(JSPUtil.getParameter(request, "org_zip_cd", ""));
		setExpnTax(JSPUtil.getParameter(request, "expn_tax", ""));
		setSameVersionYn(JSPUtil.getParameter(request, "same_version_yn", ""));
		setSCltAgnFlg(JSPUtil.getParameter(request, "s_clt_agn_flg", ""));
		setN3ptyInvStsCd(JSPUtil.getParameter(request, "n3pty_inv_sts_cd", ""));
		setVndrCustNm(JSPUtil.getParameter(request, "vndr_cust_nm", ""));
		setNewRvisSeq(JSPUtil.getParameter(request, "new_rvis_seq", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setSN3ptyInvNo(JSPUtil.getParameter(request, "s_n3pty_inv_no", ""));
		setOrgUsrInpCtnt2(JSPUtil.getParameter(request, "org_usr_inp_ctnt2", ""));
		setCitaNo(JSPUtil.getParameter(request, "cita_no", ""));
		setOrgUsrInpCtnt1(JSPUtil.getParameter(request, "org_usr_inp_ctnt1", ""));
		setTotSvcTax(JSPUtil.getParameter(request, "tot_svc_tax", ""));
		setRepairLocation(JSPUtil.getParameter(request, "repair_location", ""));
		setHighEduTax(JSPUtil.getParameter(request, "high_edu_tax", ""));
		setFmNodCd(JSPUtil.getParameter(request, "fm_nod_cd", ""));
		setVatAmt(JSPUtil.getParameter(request, "vat_amt", ""));
		setOrgTotAmt(JSPUtil.getParameter(request, "org_tot_amt", ""));
		setSDetailN3ptyNo(JSPUtil.getParameter(request, "s_detail_n3pty_no", ""));
		setRoute(JSPUtil.getParameter(request, "route", ""));
		setRcvDueDt(JSPUtil.getParameter(request, "rcv_due_dt", ""));
		setN3ptyInvRmdYn(JSPUtil.getParameter(request, "n3pty_inv_rmd_yn", ""));
		setOrgInvDesc(JSPUtil.getParameter(request, "org_inv_desc", ""));
		setMonXchRt(JSPUtil.getParameter(request, "mon_xch_rt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setSVatXchRtChk(JSPUtil.getParameter(request, "s_vat_xch_rt_chk", ""));
		setSHisSeq(JSPUtil.getParameter(request, "s_his_seq", ""));
		setTrdPartyCode(JSPUtil.getParameter(request, "trd_party_code", ""));
		setN3ptyCntrWgtUtCd(JSPUtil.getParameter(request, "n3pty_cntr_wgt_ut_cd", ""));
		setNewCreditnoteCd(JSPUtil.getParameter(request, "new_creditnote_cd", ""));
		setSFinalFlg(JSPUtil.getParameter(request, "s_final_flg", ""));
		setOrgDdctAmt(JSPUtil.getParameter(request, "org_ddct_amt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSCorrectionYn(JSPUtil.getParameter(request, "s_correction_yn", ""));
		setFtOvrDys(JSPUtil.getParameter(request, "ft_ovr_dys", ""));
		setN3ptyBilTpCd(JSPUtil.getParameter(request, "n3pty_bil_tp_cd", ""));
		setNetAmt(JSPUtil.getParameter(request, "net_amt", ""));
		setSPhnNo(JSPUtil.getParameter(request, "s_phn_no", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setTotExpnTax(JSPUtil.getParameter(request, "tot_expn_tax", ""));
		setSInvRmk2(JSPUtil.getParameter(request, "s_inv_rmk2", ""));
		setOrgVndrCustRefRmk(JSPUtil.getParameter(request, "org_vndr_cust_ref_rmk", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setSSameVersionYn(JSPUtil.getParameter(request, "s_same_version_yn", ""));
		setSVndrCustRefRmk(JSPUtil.getParameter(request, "s_vndr_cust_ref_rmk", ""));
		setSBilLoc(JSPUtil.getParameter(request, "s_bil_loc", ""));
		setSCustCntCd(JSPUtil.getParameter(request, "s_cust_cnt_cd", ""));
		setNewCntrSealNo(JSPUtil.getParameter(request, "new_cntr_seal_no", ""));
		setNewEqNo(JSPUtil.getParameter(request, "new_eq_no", ""));
		setSDaoN3ptyBilTpCd(JSPUtil.getParameter(request, "s_dao_n3pty_bil_tp_cd", ""));
		setOtsAmt(JSPUtil.getParameter(request, "ots_amt", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setSFromCurrCd(JSPUtil.getParameter(request, "s_from_curr_cd", ""));
		setSdate(JSPUtil.getParameter(request, "sdate", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setSAddAmt(JSPUtil.getParameter(request, "s_add_amt", ""));
		setSVndrCntCd(JSPUtil.getParameter(request, "s_vndr_cnt_cd", ""));
		setTotEduTax(JSPUtil.getParameter(request, "tot_edu_tax", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setSN3ptyOfcCd(JSPUtil.getParameter(request, "s_n3pty_ofc_cd", ""));
		setOrgAdmChrg(JSPUtil.getParameter(request, "org_adm_chrg", ""));
		setSN3ptyInvRmdNm(JSPUtil.getParameter(request, "s_n3pty_inv_rmd_nm", ""));
		setNewBkgNo(JSPUtil.getParameter(request, "new_bkg_no", ""));
		setVndrCustEml(JSPUtil.getParameter(request, "vndr_cust_eml", ""));
		setSInvRmk1(JSPUtil.getParameter(request, "s_inv_rmk1", ""));
		setSIdaTaxSeq(JSPUtil.getParameter(request, "s_ida_tax_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setBilToLocDivCd(JSPUtil.getParameter(request, "bil_to_loc_div_cd", ""));
		setSNetAmt(JSPUtil.getParameter(request, "s_net_amt", ""));
		setSN3ptyInvRvisSeq(JSPUtil.getParameter(request, "s_n3pty_inv_rvis_seq", ""));
		setSInvIssRhqCd(JSPUtil.getParameter(request, "s_inv_iss_rhq_cd", ""));
		setPrcsCnt(JSPUtil.getParameter(request, "prcs_cnt", ""));
		setVatDtlChk(JSPUtil.getParameter(request, "vat_dtl_chk", ""));
		setVatDtlAmt(JSPUtil.getParameter(request, "vat_dtl_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceDetailListForRevisionVO[]
	 */
	public InvoiceDetailListForRevisionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceDetailListForRevisionVO[]
	 */
	public InvoiceDetailListForRevisionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceDetailListForRevisionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] expnTotalAmt = (JSPUtil.getParameter(request, prefix	+ "expn_total_amt", length));
			String[] ddctAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_amt", length));
			String[] estmSvrId = (JSPUtil.getParameter(request, prefix	+ "estm_svr_id", length));
			String[] usrInpCtnt1 = (JSPUtil.getParameter(request, prefix	+ "usr_inp_ctnt1", length));
			String[] sCltAgnRmk = (JSPUtil.getParameter(request, prefix	+ "s_clt_agn_rmk", length));
			String[] invDtlAmt = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_amt", length));
			String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_nm", length));
			String[] vatXchRtOriginal = (JSPUtil.getParameter(request, prefix	+ "vat_xch_rt_original", length));
			String[] orgCltAgnFlg = (JSPUtil.getParameter(request, prefix	+ "org_clt_agn_flg", length));
			String[] mgsetNo = (JSPUtil.getParameter(request, prefix	+ "mgset_no", length));
			String[] usrInpCtnt2 = (JSPUtil.getParameter(request, prefix	+ "usr_inp_ctnt2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sUsrInpCtnt2 = (JSPUtil.getParameter(request, prefix	+ "s_usr_inp_ctnt2", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] sUsrInpCtnt1 = (JSPUtil.getParameter(request, prefix	+ "s_usr_inp_ctnt1", length));
			String[] edate = (JSPUtil.getParameter(request, prefix	+ "edate", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] sN3ptyInvHisSeq = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_his_seq", length));
			String[] lstExpense = (JSPUtil.getParameter(request, prefix	+ "lst_expense", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] engAddr = (JSPUtil.getParameter(request, prefix	+ "eng_addr", length));
			String[] sVatAmt = (JSPUtil.getParameter(request, prefix	+ "s_vat_amt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] sAddr = (JSPUtil.getParameter(request, prefix	+ "s_addr", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] orgDueDate = (JSPUtil.getParameter(request, prefix	+ "org_due_date", length));
			String[] n3ptyInvNoTmp = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_no_tmp", length));
			String[] pkupDt = (JSPUtil.getParameter(request, prefix	+ "pkup_dt", length));
			String[] delSucess = (JSPUtil.getParameter(request, prefix	+ "del_sucess", length));
			String[] sSumInvAmt = (JSPUtil.getParameter(request, prefix	+ "s_sum_inv_amt", length));
			String[] sTotalAmt = (JSPUtil.getParameter(request, prefix	+ "s_total_amt", length));
			String[] sDdctAmt = (JSPUtil.getParameter(request, prefix	+ "s_ddct_amt", length));
			String[] cltAgnFlg = (JSPUtil.getParameter(request, prefix	+ "clt_agn_flg", length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] newCreditnoteSeq = (JSPUtil.getParameter(request, prefix	+ "new_creditnote_seq", length));
			String[] sVndrCustAddr2 = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_addr2", length));
			String[] isFrance = (JSPUtil.getParameter(request, prefix	+ "is_france", length));
			String[] totHighEduTax = (JSPUtil.getParameter(request, prefix	+ "tot_high_edu_tax", length));
			String[] orgVndrCustAddr = (JSPUtil.getParameter(request, prefix	+ "org_vndr_cust_addr", length));
			String[] sSteCd = (JSPUtil.getParameter(request, prefix	+ "s_ste_cd", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] france = (JSPUtil.getParameter(request, prefix	+ "france", length));
			String[] lstFreeDt = (JSPUtil.getParameter(request, prefix	+ "lst_free_dt", length));
			String[] n3ptyInvRmdNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_rmd_nm", length));
			String[] sN3ptyInvRmdYn = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_rmd_yn", length));
			String[] erpifYn = (JSPUtil.getParameter(request, prefix	+ "erpif_yn", length));
			String[] bkgNoAll = (JSPUtil.getParameter(request, prefix	+ "bkg_no_all", length));
			String[] cnt = (JSPUtil.getParameter(request, prefix	+ "cnt", length));
			String[] sN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no", length));
			String[] sVndrSeq = (JSPUtil.getParameter(request, prefix	+ "s_vndr_seq", length));
			String[] sVatXchRt = (JSPUtil.getParameter(request, prefix	+ "s_vat_xch_rt", length));
			String[] lstInvoiceTotal = (JSPUtil.getParameter(request, prefix	+ "lst_invoice_total", length));
			String[] sCtyNm = (JSPUtil.getParameter(request, prefix	+ "s_cty_nm", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] sRhqCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_rhq_cd_for_rhq", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] invAmtSts = (JSPUtil.getParameter(request, prefix	+ "inv_amt_sts", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] sRgstNo = (JSPUtil.getParameter(request, prefix	+ "s_rgst_no", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] svcCateRmk = (JSPUtil.getParameter(request, prefix	+ "svc_cate_rmk", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] sCustSeq = (JSPUtil.getParameter(request, prefix	+ "s_cust_seq", length));
			String[] addAmt = (JSPUtil.getParameter(request, prefix	+ "add_amt", length));
			String[] sTrdPartyVal = (JSPUtil.getParameter(request, prefix	+ "s_trd_party_val", length));
			String[] sCurrCd = (JSPUtil.getParameter(request, prefix	+ "s_curr_cd", length));
			String[] otsDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ots_dtl_seq", length));
			String[] sVndrCustEml = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_eml", length));
			String[] n3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_no", length));
			String[] originalInvDtlAmt = (JSPUtil.getParameter(request, prefix	+ "original_inv_dtl_amt", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] sInquiryonlyYn = (JSPUtil.getParameter(request, prefix	+ "s_inquiryonly_yn", length));
			String[] sN3ptyInvRmdCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_rmd_cd", length));
			String[] sN3ptyInvStsCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_sts_cd", length));
			String[] finalFlg = (JSPUtil.getParameter(request, prefix	+ "final_flg", length));
			String[] detailOtsStsCd = (JSPUtil.getParameter(request, prefix	+ "detail_ots_sts_cd", length));
			String[] sInvDesc = (JSPUtil.getParameter(request, prefix	+ "s_inv_desc", length));
			String[] sVndrCustAddr = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_addr", length));
			String[] invIssRhqCd = (JSPUtil.getParameter(request, prefix	+ "inv_iss_rhq_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] sFinalFlgCheckbox = (JSPUtil.getParameter(request, prefix	+ "s_final_flg_checkbox", length));
			String[] damageDt = (JSPUtil.getParameter(request, prefix	+ "damage_dt", length));
			String[] detailN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "detail_n3pty_no", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] ctyNm = (JSPUtil.getParameter(request, prefix	+ "cty_nm", length));
			String[] sInvoiceCancelRemark = (JSPUtil.getParameter(request, prefix	+ "s_invoice_cancel_remark", length));
			String[] totalAmt = (JSPUtil.getParameter(request, prefix	+ "total_amt", length));
			String[] taxRgstNo = (JSPUtil.getParameter(request, prefix	+ "tax_rgst_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sZipCd = (JSPUtil.getParameter(request, prefix	+ "s_zip_cd", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] n3ptyInvDtlSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_dtl_seq", length));
			String[] vndrCustRefRmk = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_ref_rmk", length));
			String[] cltAgnRmk = (JSPUtil.getParameter(request, prefix	+ "clt_agn_rmk", length));
			String[] occrDt = (JSPUtil.getParameter(request, prefix	+ "occr_dt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] orgSteCd = (JSPUtil.getParameter(request, prefix	+ "org_ste_cd", length));
			String[] invIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_iss_ofc_cd", length));
			String[] sRch = (JSPUtil.getParameter(request, prefix	+ "s_rch", length));
			String[] sVndrCustNm = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_nm", length));
			String[] idaTaxSeq = (JSPUtil.getParameter(request, prefix	+ "ida_tax_seq", length));
			String[] eqKndNm = (JSPUtil.getParameter(request, prefix	+ "eq_knd_nm", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] lnkN3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "lnk_n3pty_inv_no", length));
			String[] newRvisCd = (JSPUtil.getParameter(request, prefix	+ "new_rvis_cd", length));
			String[] sTrdPartyNm = (JSPUtil.getParameter(request, prefix	+ "s_trd_party_nm", length));
			String[] sFrance = (JSPUtil.getParameter(request, prefix	+ "s_france", length));
			String[] wtHrs = (JSPUtil.getParameter(request, prefix	+ "wt_hrs", length));
			String[] vndrCustAddr = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_addr", length));
			String[] orgCtyNm = (JSPUtil.getParameter(request, prefix	+ "org_cty_nm", length));
			String[] soIfSeq = (JSPUtil.getParameter(request, prefix	+ "so_if_seq", length));
			String[] sRcvDueDt = (JSPUtil.getParameter(request, prefix	+ "s_rcv_due_dt", length));
			String[] sLengthN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "s_length_n3pty_bil_tp_cd", length));
			String[] sFaxNo = (JSPUtil.getParameter(request, prefix	+ "s_fax_no", length));
			String[] blNoAll = (JSPUtil.getParameter(request, prefix	+ "bl_no_all", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] validYnCorrection = (JSPUtil.getParameter(request, prefix	+ "valid_yn_correction", length));
			String[] sDetailOtsStsCd = (JSPUtil.getParameter(request, prefix	+ "s_detail_ots_sts_cd", length));
			String[] newVslCd = (JSPUtil.getParameter(request, prefix	+ "new_vsl_cd", length));
			String[] lstTax = (JSPUtil.getParameter(request, prefix	+ "lst_tax", length));
			String[] sVndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_div_cd", length));
			String[] eduTax = (JSPUtil.getParameter(request, prefix	+ "edu_tax", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] sTrdPartyCode = (JSPUtil.getParameter(request, prefix	+ "s_trd_party_code", length));
			String[] sHVndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "s_h_vndr_cust_div_cd", length));
			String[] rgstNo = (JSPUtil.getParameter(request, prefix	+ "rgst_no", length));
			String[] otsStsCd = (JSPUtil.getParameter(request, prefix	+ "ots_sts_cd", length));
			String[] orgZipCd = (JSPUtil.getParameter(request, prefix	+ "org_zip_cd", length));
			String[] expnTax = (JSPUtil.getParameter(request, prefix	+ "expn_tax", length));
			String[] sameVersionYn = (JSPUtil.getParameter(request, prefix	+ "same_version_yn", length));
			String[] sCltAgnFlg = (JSPUtil.getParameter(request, prefix	+ "s_clt_agn_flg", length));
			String[] n3ptyInvStsCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_sts_cd", length));
			String[] vndrCustNm = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_nm", length));
			String[] newRvisSeq = (JSPUtil.getParameter(request, prefix	+ "new_rvis_seq", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] sN3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_no", length));
			String[] orgUsrInpCtnt2 = (JSPUtil.getParameter(request, prefix	+ "org_usr_inp_ctnt2", length));
			String[] citaNo = (JSPUtil.getParameter(request, prefix	+ "cita_no", length));
			String[] orgUsrInpCtnt1 = (JSPUtil.getParameter(request, prefix	+ "org_usr_inp_ctnt1", length));
			String[] totSvcTax = (JSPUtil.getParameter(request, prefix	+ "tot_svc_tax", length));
			String[] repairLocation = (JSPUtil.getParameter(request, prefix	+ "repair_location", length));
			String[] highEduTax = (JSPUtil.getParameter(request, prefix	+ "high_edu_tax", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] vatAmt = (JSPUtil.getParameter(request, prefix	+ "vat_amt", length));
			String[] orgTotAmt = (JSPUtil.getParameter(request, prefix	+ "org_tot_amt", length));
			String[] sDetailN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_detail_n3pty_no", length));
			String[] route = (JSPUtil.getParameter(request, prefix	+ "route", length));
			String[] rcvDueDt = (JSPUtil.getParameter(request, prefix	+ "rcv_due_dt", length));
			String[] n3ptyInvRmdYn = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_rmd_yn", length));
			String[] orgInvDesc = (JSPUtil.getParameter(request, prefix	+ "org_inv_desc", length));
			String[] monXchRt = (JSPUtil.getParameter(request, prefix	+ "mon_xch_rt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] sVatXchRtChk = (JSPUtil.getParameter(request, prefix	+ "s_vat_xch_rt_chk", length));
			String[] sHisSeq = (JSPUtil.getParameter(request, prefix	+ "s_his_seq", length));
			String[] trdPartyCode = (JSPUtil.getParameter(request, prefix	+ "trd_party_code", length));
			String[] n3ptyCntrWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_cntr_wgt_ut_cd", length));
			String[] newCreditnoteCd = (JSPUtil.getParameter(request, prefix	+ "new_creditnote_cd", length));
			String[] sFinalFlg = (JSPUtil.getParameter(request, prefix	+ "s_final_flg", length));
			String[] orgDdctAmt = (JSPUtil.getParameter(request, prefix	+ "org_ddct_amt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sCorrectionYn = (JSPUtil.getParameter(request, prefix	+ "s_correction_yn", length));
			String[] ftOvrDys = (JSPUtil.getParameter(request, prefix	+ "ft_ovr_dys", length));
			String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd", length));
			String[] netAmt = (JSPUtil.getParameter(request, prefix	+ "net_amt", length));
			String[] sPhnNo = (JSPUtil.getParameter(request, prefix	+ "s_phn_no", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] totExpnTax = (JSPUtil.getParameter(request, prefix	+ "tot_expn_tax", length));
			String[] sInvRmk2 = (JSPUtil.getParameter(request, prefix	+ "s_inv_rmk2", length));
			String[] orgVndrCustRefRmk = (JSPUtil.getParameter(request, prefix	+ "org_vndr_cust_ref_rmk", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] sSameVersionYn = (JSPUtil.getParameter(request, prefix	+ "s_same_version_yn", length));
			String[] sVndrCustRefRmk = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_ref_rmk", length));
			String[] sBilLoc = (JSPUtil.getParameter(request, prefix	+ "s_bil_loc", length));
			String[] sCustCntCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cnt_cd", length));
			String[] newCntrSealNo = (JSPUtil.getParameter(request, prefix	+ "new_cntr_seal_no", length));
			String[] newEqNo = (JSPUtil.getParameter(request, prefix	+ "new_eq_no", length));
			String[] sDaoN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "s_dao_n3pty_bil_tp_cd", length));
			String[] otsAmt = (JSPUtil.getParameter(request, prefix	+ "ots_amt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] sFromCurrCd = (JSPUtil.getParameter(request, prefix	+ "s_from_curr_cd", length));
			String[] sdate = (JSPUtil.getParameter(request, prefix	+ "sdate", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] sAddAmt = (JSPUtil.getParameter(request, prefix	+ "s_add_amt", length));
			String[] sVndrCntCd = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cnt_cd", length));
			String[] totEduTax = (JSPUtil.getParameter(request, prefix	+ "tot_edu_tax", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] sN3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_ofc_cd", length));
			String[] orgAdmChrg = (JSPUtil.getParameter(request, prefix	+ "org_adm_chrg", length));
			String[] sN3ptyInvRmdNm = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_rmd_nm", length));
			String[] newBkgNo = (JSPUtil.getParameter(request, prefix	+ "new_bkg_no", length));
			String[] vndrCustEml = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_eml", length));
			String[] sInvRmk1 = (JSPUtil.getParameter(request, prefix	+ "s_inv_rmk1", length));
			String[] sIdaTaxSeq = (JSPUtil.getParameter(request, prefix	+ "s_ida_tax_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] bilToLocDivCd = (JSPUtil.getParameter(request, prefix	+ "bil_to_loc_div_cd", length));
			String[] sNetAmt = (JSPUtil.getParameter(request, prefix	+ "s_net_amt", length));
			String[] sN3ptyInvRvisSeq = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_rvis_seq", length));
			String[] sInvIssRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_inv_iss_rhq_cd", length));
			String[] prcsCnt = (JSPUtil.getParameter(request, prefix	+ "prcs_cnt", length));
			String[] vatDtlChk = (JSPUtil.getParameter(request, prefix	+ "vat_dtl_chk", length));
			String[] vatDtlAmt = (JSPUtil.getParameter(request, prefix	+ "vat_dtl_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceDetailListForRevisionVO();
				if (expnTotalAmt[i] != null)
					model.setExpnTotalAmt(expnTotalAmt[i]);
				if (ddctAmt[i] != null)
					model.setDdctAmt(ddctAmt[i]);
				if (estmSvrId[i] != null)
					model.setEstmSvrId(estmSvrId[i]);
				if (usrInpCtnt1[i] != null)
					model.setUsrInpCtnt1(usrInpCtnt1[i]);
				if (sCltAgnRmk[i] != null)
					model.setSCltAgnRmk(sCltAgnRmk[i]);
				if (invDtlAmt[i] != null)
					model.setInvDtlAmt(invDtlAmt[i]);
				if (n3ptyBilTpNm[i] != null)
					model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
				if (vatXchRtOriginal[i] != null)
					model.setVatXchRtOriginal(vatXchRtOriginal[i]);
				if (orgCltAgnFlg[i] != null)
					model.setOrgCltAgnFlg(orgCltAgnFlg[i]);
				if (mgsetNo[i] != null)
					model.setMgsetNo(mgsetNo[i]);
				if (usrInpCtnt2[i] != null)
					model.setUsrInpCtnt2(usrInpCtnt2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sUsrInpCtnt2[i] != null)
					model.setSUsrInpCtnt2(sUsrInpCtnt2[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (sUsrInpCtnt1[i] != null)
					model.setSUsrInpCtnt1(sUsrInpCtnt1[i]);
				if (edate[i] != null)
					model.setEdate(edate[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (sN3ptyInvHisSeq[i] != null)
					model.setSN3ptyInvHisSeq(sN3ptyInvHisSeq[i]);
				if (lstExpense[i] != null)
					model.setLstExpense(lstExpense[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (engAddr[i] != null)
					model.setEngAddr(engAddr[i]);
				if (sVatAmt[i] != null)
					model.setSVatAmt(sVatAmt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (sAddr[i] != null)
					model.setSAddr(sAddr[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (orgDueDate[i] != null)
					model.setOrgDueDate(orgDueDate[i]);
				if (n3ptyInvNoTmp[i] != null)
					model.setN3ptyInvNoTmp(n3ptyInvNoTmp[i]);
				if (pkupDt[i] != null)
					model.setPkupDt(pkupDt[i]);
				if (delSucess[i] != null)
					model.setDelSucess(delSucess[i]);
				if (sSumInvAmt[i] != null)
					model.setSSumInvAmt(sSumInvAmt[i]);
				if (sTotalAmt[i] != null)
					model.setSTotalAmt(sTotalAmt[i]);
				if (sDdctAmt[i] != null)
					model.setSDdctAmt(sDdctAmt[i]);
				if (cltAgnFlg[i] != null)
					model.setCltAgnFlg(cltAgnFlg[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (newCreditnoteSeq[i] != null)
					model.setNewCreditnoteSeq(newCreditnoteSeq[i]);
				if (sVndrCustAddr2[i] != null)
					model.setSVndrCustAddr2(sVndrCustAddr2[i]);
				if (isFrance[i] != null)
					model.setIsFrance(isFrance[i]);
				if (totHighEduTax[i] != null)
					model.setTotHighEduTax(totHighEduTax[i]);
				if (orgVndrCustAddr[i] != null)
					model.setOrgVndrCustAddr(orgVndrCustAddr[i]);
				if (sSteCd[i] != null)
					model.setSSteCd(sSteCd[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (france[i] != null)
					model.setFrance(france[i]);
				if (lstFreeDt[i] != null)
					model.setLstFreeDt(lstFreeDt[i]);
				if (n3ptyInvRmdNm[i] != null)
					model.setN3ptyInvRmdNm(n3ptyInvRmdNm[i]);
				if (sN3ptyInvRmdYn[i] != null)
					model.setSN3ptyInvRmdYn(sN3ptyInvRmdYn[i]);
				if (erpifYn[i] != null)
					model.setErpifYn(erpifYn[i]);
				if (bkgNoAll[i] != null)
					model.setBkgNoAll(bkgNoAll[i]);
				if (cnt[i] != null)
					model.setCnt(cnt[i]);
				if (sN3ptyNo[i] != null)
					model.setSN3ptyNo(sN3ptyNo[i]);
				if (sVndrSeq[i] != null)
					model.setSVndrSeq(sVndrSeq[i]);
				if (sVatXchRt[i] != null)
					model.setSVatXchRt(sVatXchRt[i]);
				if (lstInvoiceTotal[i] != null)
					model.setLstInvoiceTotal(lstInvoiceTotal[i]);
				if (sCtyNm[i] != null)
					model.setSCtyNm(sCtyNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (sRhqCdForRhq[i] != null)
					model.setSRhqCdForRhq(sRhqCdForRhq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (invAmtSts[i] != null)
					model.setInvAmtSts(invAmtSts[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (sRgstNo[i] != null)
					model.setSRgstNo(sRgstNo[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (svcCateRmk[i] != null)
					model.setSvcCateRmk(svcCateRmk[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (sCustSeq[i] != null)
					model.setSCustSeq(sCustSeq[i]);
				if (addAmt[i] != null)
					model.setAddAmt(addAmt[i]);
				if (sTrdPartyVal[i] != null)
					model.setSTrdPartyVal(sTrdPartyVal[i]);
				if (sCurrCd[i] != null)
					model.setSCurrCd(sCurrCd[i]);
				if (otsDtlSeq[i] != null)
					model.setOtsDtlSeq(otsDtlSeq[i]);
				if (sVndrCustEml[i] != null)
					model.setSVndrCustEml(sVndrCustEml[i]);
				if (n3ptyInvNo[i] != null)
					model.setN3ptyInvNo(n3ptyInvNo[i]);
				if (originalInvDtlAmt[i] != null)
					model.setOriginalInvDtlAmt(originalInvDtlAmt[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (sInquiryonlyYn[i] != null)
					model.setSInquiryonlyYn(sInquiryonlyYn[i]);
				if (sN3ptyInvRmdCd[i] != null)
					model.setSN3ptyInvRmdCd(sN3ptyInvRmdCd[i]);
				if (sN3ptyInvStsCd[i] != null)
					model.setSN3ptyInvStsCd(sN3ptyInvStsCd[i]);
				if (finalFlg[i] != null)
					model.setFinalFlg(finalFlg[i]);
				if (detailOtsStsCd[i] != null)
					model.setDetailOtsStsCd(detailOtsStsCd[i]);
				if (sInvDesc[i] != null)
					model.setSInvDesc(sInvDesc[i]);
				if (sVndrCustAddr[i] != null)
					model.setSVndrCustAddr(sVndrCustAddr[i]);
				if (invIssRhqCd[i] != null)
					model.setInvIssRhqCd(invIssRhqCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (sFinalFlgCheckbox[i] != null)
					model.setSFinalFlgCheckbox(sFinalFlgCheckbox[i]);
				if (damageDt[i] != null)
					model.setDamageDt(damageDt[i]);
				if (detailN3ptyNo[i] != null)
					model.setDetailN3ptyNo(detailN3ptyNo[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (ctyNm[i] != null)
					model.setCtyNm(ctyNm[i]);
				if (sInvoiceCancelRemark[i] != null)
					model.setSInvoiceCancelRemark(sInvoiceCancelRemark[i]);
				if (totalAmt[i] != null)
					model.setTotalAmt(totalAmt[i]);
				if (taxRgstNo[i] != null)
					model.setTaxRgstNo(taxRgstNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sZipCd[i] != null)
					model.setSZipCd(sZipCd[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (n3ptyInvDtlSeq[i] != null)
					model.setN3ptyInvDtlSeq(n3ptyInvDtlSeq[i]);
				if (vndrCustRefRmk[i] != null)
					model.setVndrCustRefRmk(vndrCustRefRmk[i]);
				if (cltAgnRmk[i] != null)
					model.setCltAgnRmk(cltAgnRmk[i]);
				if (occrDt[i] != null)
					model.setOccrDt(occrDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (orgSteCd[i] != null)
					model.setOrgSteCd(orgSteCd[i]);
				if (invIssOfcCd[i] != null)
					model.setInvIssOfcCd(invIssOfcCd[i]);
				if (sRch[i] != null)
					model.setSRch(sRch[i]);
				if (sVndrCustNm[i] != null)
					model.setSVndrCustNm(sVndrCustNm[i]);
				if (idaTaxSeq[i] != null)
					model.setIdaTaxSeq(idaTaxSeq[i]);
				if (eqKndNm[i] != null)
					model.setEqKndNm(eqKndNm[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (lnkN3ptyInvNo[i] != null)
					model.setLnkN3ptyInvNo(lnkN3ptyInvNo[i]);
				if (newRvisCd[i] != null)
					model.setNewRvisCd(newRvisCd[i]);
				if (sTrdPartyNm[i] != null)
					model.setSTrdPartyNm(sTrdPartyNm[i]);
				if (sFrance[i] != null)
					model.setSFrance(sFrance[i]);
				if (wtHrs[i] != null)
					model.setWtHrs(wtHrs[i]);
				if (vndrCustAddr[i] != null)
					model.setVndrCustAddr(vndrCustAddr[i]);
				if (orgCtyNm[i] != null)
					model.setOrgCtyNm(orgCtyNm[i]);
				if (soIfSeq[i] != null)
					model.setSoIfSeq(soIfSeq[i]);
				if (sRcvDueDt[i] != null)
					model.setSRcvDueDt(sRcvDueDt[i]);
				if (sLengthN3ptyBilTpCd[i] != null)
					model.setSLengthN3ptyBilTpCd(sLengthN3ptyBilTpCd[i]);
				if (sFaxNo[i] != null)
					model.setSFaxNo(sFaxNo[i]);
				if (blNoAll[i] != null)
					model.setBlNoAll(blNoAll[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (validYnCorrection[i] != null)
					model.setValidYnCorrection(validYnCorrection[i]);
				if (sDetailOtsStsCd[i] != null)
					model.setSDetailOtsStsCd(sDetailOtsStsCd[i]);
				if (newVslCd[i] != null)
					model.setNewVslCd(newVslCd[i]);
				if (lstTax[i] != null)
					model.setLstTax(lstTax[i]);
				if (sVndrCustDivCd[i] != null)
					model.setSVndrCustDivCd(sVndrCustDivCd[i]);
				if (eduTax[i] != null)
					model.setEduTax(eduTax[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (sTrdPartyCode[i] != null)
					model.setSTrdPartyCode(sTrdPartyCode[i]);
				if (sHVndrCustDivCd[i] != null)
					model.setSHVndrCustDivCd(sHVndrCustDivCd[i]);
				if (rgstNo[i] != null)
					model.setRgstNo(rgstNo[i]);
				if (otsStsCd[i] != null)
					model.setOtsStsCd(otsStsCd[i]);
				if (orgZipCd[i] != null)
					model.setOrgZipCd(orgZipCd[i]);
				if (expnTax[i] != null)
					model.setExpnTax(expnTax[i]);
				if (sameVersionYn[i] != null)
					model.setSameVersionYn(sameVersionYn[i]);
				if (sCltAgnFlg[i] != null)
					model.setSCltAgnFlg(sCltAgnFlg[i]);
				if (n3ptyInvStsCd[i] != null)
					model.setN3ptyInvStsCd(n3ptyInvStsCd[i]);
				if (vndrCustNm[i] != null)
					model.setVndrCustNm(vndrCustNm[i]);
				if (newRvisSeq[i] != null)
					model.setNewRvisSeq(newRvisSeq[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (sN3ptyInvNo[i] != null)
					model.setSN3ptyInvNo(sN3ptyInvNo[i]);
				if (orgUsrInpCtnt2[i] != null)
					model.setOrgUsrInpCtnt2(orgUsrInpCtnt2[i]);
				if (citaNo[i] != null)
					model.setCitaNo(citaNo[i]);
				if (orgUsrInpCtnt1[i] != null)
					model.setOrgUsrInpCtnt1(orgUsrInpCtnt1[i]);
				if (totSvcTax[i] != null)
					model.setTotSvcTax(totSvcTax[i]);
				if (repairLocation[i] != null)
					model.setRepairLocation(repairLocation[i]);
				if (highEduTax[i] != null)
					model.setHighEduTax(highEduTax[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (vatAmt[i] != null)
					model.setVatAmt(vatAmt[i]);
				if (orgTotAmt[i] != null)
					model.setOrgTotAmt(orgTotAmt[i]);
				if (sDetailN3ptyNo[i] != null)
					model.setSDetailN3ptyNo(sDetailN3ptyNo[i]);
				if (route[i] != null)
					model.setRoute(route[i]);
				if (rcvDueDt[i] != null)
					model.setRcvDueDt(rcvDueDt[i]);
				if (n3ptyInvRmdYn[i] != null)
					model.setN3ptyInvRmdYn(n3ptyInvRmdYn[i]);
				if (orgInvDesc[i] != null)
					model.setOrgInvDesc(orgInvDesc[i]);
				if (monXchRt[i] != null)
					model.setMonXchRt(monXchRt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (sVatXchRtChk[i] != null)
					model.setSVatXchRtChk(sVatXchRtChk[i]);
				if (sHisSeq[i] != null)
					model.setSHisSeq(sHisSeq[i]);
				if (trdPartyCode[i] != null)
					model.setTrdPartyCode(trdPartyCode[i]);
				if (n3ptyCntrWgtUtCd[i] != null)
					model.setN3ptyCntrWgtUtCd(n3ptyCntrWgtUtCd[i]);
				if (newCreditnoteCd[i] != null)
					model.setNewCreditnoteCd(newCreditnoteCd[i]);
				if (sFinalFlg[i] != null)
					model.setSFinalFlg(sFinalFlg[i]);
				if (orgDdctAmt[i] != null)
					model.setOrgDdctAmt(orgDdctAmt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sCorrectionYn[i] != null)
					model.setSCorrectionYn(sCorrectionYn[i]);
				if (ftOvrDys[i] != null)
					model.setFtOvrDys(ftOvrDys[i]);
				if (n3ptyBilTpCd[i] != null)
					model.setN3ptyBilTpCd(n3ptyBilTpCd[i]);
				if (netAmt[i] != null)
					model.setNetAmt(netAmt[i]);
				if (sPhnNo[i] != null)
					model.setSPhnNo(sPhnNo[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (totExpnTax[i] != null)
					model.setTotExpnTax(totExpnTax[i]);
				if (sInvRmk2[i] != null)
					model.setSInvRmk2(sInvRmk2[i]);
				if (orgVndrCustRefRmk[i] != null)
					model.setOrgVndrCustRefRmk(orgVndrCustRefRmk[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (sSameVersionYn[i] != null)
					model.setSSameVersionYn(sSameVersionYn[i]);
				if (sVndrCustRefRmk[i] != null)
					model.setSVndrCustRefRmk(sVndrCustRefRmk[i]);
				if (sBilLoc[i] != null)
					model.setSBilLoc(sBilLoc[i]);
				if (sCustCntCd[i] != null)
					model.setSCustCntCd(sCustCntCd[i]);
				if (newCntrSealNo[i] != null)
					model.setNewCntrSealNo(newCntrSealNo[i]);
				if (newEqNo[i] != null)
					model.setNewEqNo(newEqNo[i]);
				if (sDaoN3ptyBilTpCd[i] != null)
					model.setSDaoN3ptyBilTpCd(sDaoN3ptyBilTpCd[i]);
				if (otsAmt[i] != null)
					model.setOtsAmt(otsAmt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (sFromCurrCd[i] != null)
					model.setSFromCurrCd(sFromCurrCd[i]);
				if (sdate[i] != null)
					model.setSdate(sdate[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (sAddAmt[i] != null)
					model.setSAddAmt(sAddAmt[i]);
				if (sVndrCntCd[i] != null)
					model.setSVndrCntCd(sVndrCntCd[i]);
				if (totEduTax[i] != null)
					model.setTotEduTax(totEduTax[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (sN3ptyOfcCd[i] != null)
					model.setSN3ptyOfcCd(sN3ptyOfcCd[i]);
				if (orgAdmChrg[i] != null)
					model.setOrgAdmChrg(orgAdmChrg[i]);
				if (sN3ptyInvRmdNm[i] != null)
					model.setSN3ptyInvRmdNm(sN3ptyInvRmdNm[i]);
				if (newBkgNo[i] != null)
					model.setNewBkgNo(newBkgNo[i]);
				if (vndrCustEml[i] != null)
					model.setVndrCustEml(vndrCustEml[i]);
				if (sInvRmk1[i] != null)
					model.setSInvRmk1(sInvRmk1[i]);
				if (sIdaTaxSeq[i] != null)
					model.setSIdaTaxSeq(sIdaTaxSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (bilToLocDivCd[i] != null)
					model.setBilToLocDivCd(bilToLocDivCd[i]);
				if (sNetAmt[i] != null)
					model.setSNetAmt(sNetAmt[i]);
				if (sN3ptyInvRvisSeq[i] != null)
					model.setSN3ptyInvRvisSeq(sN3ptyInvRvisSeq[i]);
				if (sInvIssRhqCd[i] != null)
					model.setSInvIssRhqCd(sInvIssRhqCd[i]);
				if (prcsCnt[i] != null)
					model.setPrcsCnt(prcsCnt[i]);
				if (vatDtlChk[i] != null)
					model.setVatDtlChk(vatDtlChk[i]);
				if (vatDtlAmt[i] != null)
					model.setVatDtlAmt(vatDtlAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceDetailListForRevisionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceDetailListForRevisionVO[]
	 */
	public InvoiceDetailListForRevisionVO[] getInvoiceDetailListForRevisionVOs(){
		InvoiceDetailListForRevisionVO[] vos = (InvoiceDetailListForRevisionVO[])models.toArray(new InvoiceDetailListForRevisionVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.expnTotalAmt = this.expnTotalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctAmt = this.ddctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSvrId = this.estmSvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrInpCtnt1 = this.usrInpCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCltAgnRmk = this.sCltAgnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtlAmt = this.invDtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpNm = this.n3ptyBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatXchRtOriginal = this.vatXchRtOriginal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCltAgnFlg = this.orgCltAgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgsetNo = this.mgsetNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrInpCtnt2 = this.usrInpCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUsrInpCtnt2 = this.sUsrInpCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUsrInpCtnt1 = this.sUsrInpCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edate = this.edate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvHisSeq = this.sN3ptyInvHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstExpense = this.lstExpense .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engAddr = this.engAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVatAmt = this.sVatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAddr = this.sAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDueDate = this.orgDueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvNoTmp = this.n3ptyInvNoTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupDt = this.pkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delSucess = this.delSucess .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSumInvAmt = this.sSumInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTotalAmt = this.sTotalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDdctAmt = this.sDdctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltAgnFlg = this.cltAgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCreditnoteSeq = this.newCreditnoteSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustAddr2 = this.sVndrCustAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isFrance = this.isFrance .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totHighEduTax = this.totHighEduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgVndrCustAddr = this.orgVndrCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSteCd = this.sSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.france = this.france .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstFreeDt = this.lstFreeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvRmdNm = this.n3ptyInvRmdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvRmdYn = this.sN3ptyInvRmdYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpifYn = this.erpifYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoAll = this.bkgNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt = this.cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNo = this.sN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrSeq = this.sVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVatXchRt = this.sVatXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstInvoiceTotal = this.lstInvoiceTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCtyNm = this.sCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqCdForRhq = this.sRhqCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmtSts = this.invAmtSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRgstNo = this.sRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCateRmk = this.svcCateRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustSeq = this.sCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addAmt = this.addAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdPartyVal = this.sTrdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCurrCd = this.sCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDtlSeq = this.otsDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustEml = this.sVndrCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvNo = this.n3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalInvDtlAmt = this.originalInvDtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInquiryonlyYn = this.sInquiryonlyYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvRmdCd = this.sN3ptyInvRmdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvStsCd = this.sN3ptyInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalFlg = this.finalFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailOtsStsCd = this.detailOtsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvDesc = this.sInvDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustAddr = this.sVndrCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssRhqCd = this.invIssRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFinalFlgCheckbox = this.sFinalFlgCheckbox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.damageDt = this.damageDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailN3ptyNo = this.detailN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvoiceCancelRemark = this.sInvoiceCancelRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmt = this.totalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxRgstNo = this.taxRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sZipCd = this.sZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvDtlSeq = this.n3ptyInvDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustRefRmk = this.vndrCustRefRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltAgnRmk = this.cltAgnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.occrDt = this.occrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSteCd = this.orgSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssOfcCd = this.invIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRch = this.sRch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustNm = this.sVndrCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaTaxSeq = this.idaTaxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndNm = this.eqKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkN3ptyInvNo = this.lnkN3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newRvisCd = this.newRvisCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdPartyNm = this.sTrdPartyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFrance = this.sFrance .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtHrs = this.wtHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustAddr = this.vndrCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCtyNm = this.orgCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soIfSeq = this.soIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRcvDueDt = this.sRcvDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLengthN3ptyBilTpCd = this.sLengthN3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFaxNo = this.sFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoAll = this.blNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.validYnCorrection = this.validYnCorrection .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDetailOtsStsCd = this.sDetailOtsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVslCd = this.newVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstTax = this.lstTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustDivCd = this.sVndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eduTax = this.eduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdPartyCode = this.sTrdPartyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sHVndrCustDivCd = this.sHVndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstNo = this.rgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsStsCd = this.otsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgZipCd = this.orgZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnTax = this.expnTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sameVersionYn = this.sameVersionYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCltAgnFlg = this.sCltAgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvStsCd = this.n3ptyInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustNm = this.vndrCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newRvisSeq = this.newRvisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvNo = this.sN3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgUsrInpCtnt2 = this.orgUsrInpCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.citaNo = this.citaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgUsrInpCtnt1 = this.orgUsrInpCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSvcTax = this.totSvcTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repairLocation = this.repairLocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.highEduTax = this.highEduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatAmt = this.vatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTotAmt = this.orgTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDetailN3ptyNo = this.sDetailN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.route = this.route .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDueDt = this.rcvDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvRmdYn = this.n3ptyInvRmdYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgInvDesc = this.orgInvDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monXchRt = this.monXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVatXchRtChk = this.sVatXchRtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sHisSeq = this.sHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyCode = this.trdPartyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCntrWgtUtCd = this.n3ptyCntrWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCreditnoteCd = this.newCreditnoteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFinalFlg = this.sFinalFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDdctAmt = this.orgDdctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCorrectionYn = this.sCorrectionYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftOvrDys = this.ftOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCd = this.n3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netAmt = this.netAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPhnNo = this.sPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totExpnTax = this.totExpnTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvRmk2 = this.sInvRmk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgVndrCustRefRmk = this.orgVndrCustRefRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSameVersionYn = this.sSameVersionYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustRefRmk = this.sVndrCustRefRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBilLoc = this.sBilLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCntCd = this.sCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCntrSealNo = this.newCntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newEqNo = this.newEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDaoN3ptyBilTpCd = this.sDaoN3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAmt = this.otsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFromCurrCd = this.sFromCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdate = this.sdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAddAmt = this.sAddAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCntCd = this.sVndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totEduTax = this.totEduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyOfcCd = this.sN3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgAdmChrg = this.orgAdmChrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvRmdNm = this.sN3ptyInvRmdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newBkgNo = this.newBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustEml = this.vndrCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvRmk1 = this.sInvRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIdaTaxSeq = this.sIdaTaxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToLocDivCd = this.bilToLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNetAmt = this.sNetAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvRvisSeq = this.sN3ptyInvRvisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvIssRhqCd = this.sInvIssRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcsCnt = this.prcsCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatDtlChk = this.vatDtlChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatDtlAmt = this.vatDtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
