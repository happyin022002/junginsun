/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceCreationVO.java
*@FileTitle : InvoiceCreationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.11.23 박성진 
* 1.0 Creation
=========================================================*/
  
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceCreationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceCreationVO> models = new ArrayList<InvoiceCreationVO>();
	
	/* Column Info */
	private String n3ptyExpnTpCd = null;
	/* Column Info */
	private String usrInpCtnt1 = null;
	/* Column Info */
	private String estmSvrId = null;
	/* Column Info */
	private String sCltAgnRmk = null;
	/* Column Info */
	private String sheetSetCount = null;
	/* Column Info */
	private String invDtlAmt = null;
	/* Column Info */
	private String vatXchRtOriginal = null;
	/* Column Info */
	private String n3ptyBilTpNm = null;
	/* Column Info */
	private String usrInpCtnt2 = null;
	/* Column Info */
	private String mgsetNo = null;
	/* Column Info */
	private String orgCltAgnFlg = null;
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
	private String engAddr = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String sVatAmt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String sAddr = null;
	/* Column Info */
	private String orgDueDate = null;
	/* Column Info */
	private String pkupDt = null;
	/* Column Info */
	private String n3ptyInvNoTmp = null;
	/* Column Info */
	private String delSucess = null;
	/* Column Info */
	private String sSumInvAmt = null;
	/* Column Info */
	private String sTotalAmt = null;
	/* Column Info */
	private String sDdctAmt = null;
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String newCreditnoteSeq = null;
	/* Column Info */
	private String sVndrCustAddr2 = null;
	/* Column Info */
	private String totHighEduTax = null;
	/* Column Info */
	private String orgVndrCustAddr = null;
	/* Column Info */
	private String sSteCd = null;
	/* Column Info */
	private String fincDirCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String n3ptyInvRmdNm = null;
	/* Column Info */
	private String sN3ptyInvRmdYn = null;
	/* Column Info */
	private String bkgNoAll = null;
	/* Column Info */
	private String sN3ptyNo = null;
	/* Column Info */
	private String sVatXchRt = null;
	/* Column Info */
	private String sVndrSeq = null;
	/* Column Info */
	private String sSheetSetCount = null;
	/* Column Info */
	private String sCtyNm = null;
	/* Column Info */
	private String vndrCustAddr2 = null;
	/* Column Info */
	private String sN3ptyInvRvisCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String sRhqCdForRhq = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String sRgstNo = null;
	/* Column Info */
	private String occrDt = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String newVvd = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String svcCateRmk = null;
	/* Column Info */
	private String pmntAcctNo = null;
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
	private String lastFreeDt = null;
	/* Column Info */
	private String otsDtlSeq = null;
	/* Column Info */
	private String sVndrCustEml = null;
	/* Column Info */
	private String n3ptyInvNo = null;
	/* Column Info */
	private String originalInvDtlAmt = null;
	/* Column Info */
	private String lengthN3ptyBilTpCd = null;
	/* Column Info */
	private String sInquiryonlyYn = null;
	/* Column Info */
	private String sN3ptyInvRmdCd = null;
	/* Column Info */
	private String userName = null;
	/* Column Info */
	private String sN3ptyInvStsCd = null;
	/* Column Info */
	private String lengthTrdParty = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String sInvDesc = null;
	/* Column Info */
	private String sVndrCustAddr = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sFinalFlgCheckbox = null;
	/* Column Info */
	private String damageDt = null;
	/* Column Info */
	private String sDaoN3ptyNo = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String sInvoiceCancelRemark = null;
	/* Column Info */
	private String pickUpDt = null;
	/* Column Info */
	private String weight = null;
	/* Column Info */
	private String overDay = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String userEmail = null;
	/* Column Info */
	private String totalAmt = null;
	/* Column Info */
	private String taxRgstNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String uom = null;
	/* Column Info */
	private String sZipCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String estmSeqNo = null;
	/* Column Info */
	private String waitingTm = null;
	/* Column Info */
	private String lengthN3ptyExpnTpCd = null;
	/* Column Info */
	private String vndrCustRefRmk = null;
	/* Column Info */
	private String indiataxform = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String outErpifRvisSeq = null;
	/* Column Info */
	private String orgSteCd = null;
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
	private String sTrdPartyNm = null;
	/* Column Info */
	private String newRvisCd = null;
	/* Column Info */
	private String sFrance = null;
	/* Column Info */
	private String vndrCustAddr = null;
	/* Column Info */
	private String wtHrs = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String orgCtyNm = null;
	/* Column Info */
	private String soIfSeq = null;
	/* Column Info */
	private String sRcvDueDt = null;
	/* Column Info */
	private String sLengthN3ptyBilTpCd = null;
	/* Column Info */
	private String n3ptyInvRvisSeq = null;
	/* Column Info */
	private String sFaxNo = null;
	/* Column Info */
	private String blNoAll = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String validYnCorrection = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String sDetailOtsStsCd = null;
	/* Column Info */
	private String newVslCd = null;
	/* Column Info */
	private String sVndrCustDivCd = null;
	/* Column Info */
	private String eduTax = null;
	/* Column Info */
	private String newSealNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String estmRvisNo = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String sTrdPartyCode = null;
	/* Column Info */
	private String revAmt = null;
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
	private String n3ptyInvStsCd = null;
	/* Column Info */
	private String sCltAgnFlg = null;
	/* Column Info */
	private String vndrCustNm = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String sN3ptyInvNo = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String newRvisSeq = null;
	/* Column Info */
	private String orgUsrInpCtnt2 = null;
	/* Column Info */
	private String citaNo = null;
	/* Column Info */
	private String orgUsrInpCtnt1 = null;
	/* Column Info */
	private String outErpifCreditnoteSeq = null;
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
	private String bilTpCd = null;
	/* Column Info */
	private String route = null;
	/* Column Info */
	private String rcvDueDt = null;
	/* Column Info */
	private String n3ptyInvRmdYn = null;
	/* Column Info */
	private String orgInvDesc = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String vslCd = null;
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
	private String citationNo = null;
	/* Column Info */
	private String orgDdctAmt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ftOvrDys = null;
	/* Column Info */
	private String sCorrectionYn = null;
	/* Column Info */
	private String n3ptyBilTpCd = null;
	/* Column Info */
	private String vatXchRt = null;
	/* Column Info */
	private String netAmt = null;
	/* Column Info */
	private String sPhnNo = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String outErpifRvisCd = null;
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
	private String n3ptyIfTpCd = null;
	/* Column Info */
	private String sVndrCustRefRmk = null;
	/* Column Info */
	private String sBilLoc = null;
	/* Column Info */
	private String sCustCntCd = null;
	/* Column Info */
	private String newCntrSealNo = null;
	/* Column Info */
	private String newBkgAll = null;
	/* Column Info */
	private String newEqNo = null;
	/* Column Info */
	private String sDaoN3ptyBilTpCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String otsAmt = null;
	/* Column Info */
	private String sFromCurrCd = null;
	/* Column Info */
	private String sdate = null;
	/* Column Info */
	private String revVvd = null;
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
	private String sRhqCd = null;
	/* Column Info */
	private String lengthRevVvd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String sN3ptyInvRmdNm = null;
	/* Column Info */
	private String vndrCustEml = null;
	/* Column Info */
	private String newBkgNo = null;
	/* Column Info */
	private String sInvRmk1 = null;
	/* Column Info */
	private String sIdaTaxSeq = null;
	/* Column Info */
	private String trdParty = null;
	/* Column Info */
	private String bilToLocDivCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String lengthCurrCd = null;
	/* Column Info */
	private String sNetAmt = null;
	/* Column Info */
	private String outErpifCreditnoteCd = null;
	/* Column Info */
	private String sN3ptyInvRvisSeq = null;
	/* Column Info */
	private String sInvIssRhqCd = null;
	/* Column Info */
	private String vatDtlAmt = null;
	/* Column Info */
	private String lstFreeDt = null; 

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceCreationVO() {}

	public InvoiceCreationVO(String ibflag, String pagerows, String sDaoN3ptyNo, String sDaoN3ptyBilTpCd, String sTrdPartyCode, String sHVndrCustDivCd, String sdate, String edate, String sLengthN3ptyBilTpCd, String sVndrCntCd, String sVndrSeq, String sCustCntCd, String sCustSeq, String sSumInvAmt, String sPhnNo, String sInvRmk1, String sInvRmk2, String sSheetSetCount, String sBilLoc, String sHisSeq, String sVndrCustEml, String sVatXchRt, String sFromCurrCd, String sN3ptyInvHisSeq, String sIdaTaxSeq, String cntCd, String expnTax, String eduTax, String highEduTax, String taxRgstNo, String svcCateRmk, String pmntAcctNo, String sN3ptyInvNo, String sN3ptyInvRmdCd, String sCurrCd, String indiataxform, String sFaxNo, String sVndrCustAddr, String sVndrCustAddr2, String sVndrCustNm, String sRhqCd, String userOfcCd, String addAmt, String userId, String bilTpCd, String n3ptyInvNo, String n3ptyInvRvisSeq, String sN3ptyInvRvisCd, String sRch, String sNetAmt, String sVatAmt, String sAddAmt, String sDdctAmt, String engAddr, String vndrCntCd, String vndrSeq, String custCntCd, String custSeq, String trdPartyCode, String currCd, String faxNo, String phnNo, String vndrCustAddr, String vndrCustNm, String rhqCd, String vndrCustEml, String bilToLocDivCd, String sheetSetCount, String vatXchRt, String vndrCustAddr2, String n3ptyNo, String n3ptyBilTpCd, String n3ptyBilTpNm, String eqKndNm, String eqNo, String eqTpszCd, String bkgNoAll, String blNoAll, String vvd, String vvdCd, String mgsetNo, String ydCd, String route, String newEqNo, String newSealNo, String citationNo, String weight, String uom, String waitingTm, String occrDt, String newVvd, String newBkgAll, String damageDt, String repairLocation, String lastFreeDt, String pickUpDt, String overDay, String csrNo, String glDt, String otsAmt, String invAmt, String eqKndCd, String fmNodCd, String viaNodCd, String toNodCd, String dorNodCd, String bkgNo, String blNo, String vslCd, String skdVoyNo, String fincDirCd, String estmSvrId, String originalInvDtlAmt, String soIfSeq, String lgsCostCd, String acctCd, String soNo, String revAmt, String otsDtlSeq, String newCntrSealNo, String citaNo, String cntrWgt, String n3ptyCntrWgtUtCd, String wtHrs, String newVslCd, String newBkgNo, String pkupDt, String ftOvrDys, String invDtlAmt, String skdDirCd, String n3ptyExpnTpCd, String n3ptyIfTpCd, String estmSeqNo, String estmRvisNo, String lengthN3ptyExpnTpCd, String lengthN3ptyBilTpCd, String lengthRevVvd, String revVvd, String lengthCurrCd, String lengthTrdParty, String trdParty, String sDetailN3ptyNo, String idaTaxSeq, String ofcCd, String effDt, String creUsrId, String creDt, String updUsrId, String updDt, String userName, String userEmail, String outErpifRvisSeq, String outErpifRvisCd, String outErpifCreditnoteSeq, String outErpifCreditnoteCd, String arIfNo, String n3ptyInvNoTmp, String n3ptyInvRmdNm, String n3ptyInvRmdYn, String n3ptyInvStsCd, String netAmt, String newCreditnoteCd, String newCreditnoteSeq, String newRvisCd, String newRvisSeq, String orgAdmChrg, String orgCltAgnFlg, String orgCtyNm, String orgDdctAmt, String orgDueDate, String orgInvDesc, String orgSteCd, String orgTotAmt, String orgUsrInpCtnt1, String orgUsrInpCtnt2, String orgVndrCustAddr, String orgVndrCustRefRmk, String orgZipCd, String otsStsCd, String rcvDueDt, String rgstNo, String sAddr, String sCltAgnFlg, String sCltAgnRmk, String sCorrectionYn, String sCtyNm, String sDetailOtsStsCd, String sFinalFlg, String sFinalFlgCheckbox, String sFrance, String sInquiryonlyYn, String sInvDesc, String sInvIssRhqCd, String sInvoiceCancelRemark, String sN3ptyInvRmdNm, String sN3ptyInvRmdYn, String sN3ptyInvRvisSeq, String sN3ptyInvStsCd, String sN3ptyNo, String sN3ptyOfcCd, String sRcvDueDt, String sRgstNo, String sRhqCdForRhq, String sSameVersionYn, String sSteCd, String sTotalAmt, String sTrdPartyNm, String sTrdPartyVal, String sUsrInpCtnt1, String sUsrInpCtnt2, String sVatXchRtChk, String sVndrCustDivCd, String sVndrCustRefRmk, String sZipCd, String sameVersionYn, String seq, String steCd, String totEduTax, String totExpnTax, String totHighEduTax, String totSvcTax, String totalAmt, String usrInpCtnt1, String usrInpCtnt2, String validYnCorrection, String vatAmt, String vatXchRtOriginal, String vndrCustRefRmk, String zipCd, String delSucess, String vatDtlAmt, String lstFreeDt) {
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
		this.usrInpCtnt1 = usrInpCtnt1;
		this.estmSvrId = estmSvrId;
		this.sCltAgnRmk = sCltAgnRmk;
		this.sheetSetCount = sheetSetCount;
		this.invDtlAmt = invDtlAmt;
		this.vatXchRtOriginal = vatXchRtOriginal;
		this.n3ptyBilTpNm = n3ptyBilTpNm;
		this.usrInpCtnt2 = usrInpCtnt2;
		this.mgsetNo = mgsetNo;
		this.orgCltAgnFlg = orgCltAgnFlg;
		this.pagerows = pagerows;
		this.sUsrInpCtnt2 = sUsrInpCtnt2;
		this.vvdCd = vvdCd;
		this.sUsrInpCtnt1 = sUsrInpCtnt1;
		this.edate = edate;
		this.cntCd = cntCd;
		this.sN3ptyInvHisSeq = sN3ptyInvHisSeq;
		this.engAddr = engAddr;
		this.cntrWgt = cntrWgt;
		this.sVatAmt = sVatAmt;
		this.skdVoyNo = skdVoyNo;
		this.eqTpszCd = eqTpszCd;
		this.sAddr = sAddr;
		this.orgDueDate = orgDueDate;
		this.pkupDt = pkupDt;
		this.n3ptyInvNoTmp = n3ptyInvNoTmp;
		this.delSucess = delSucess;
		this.sSumInvAmt = sSumInvAmt;
		this.sTotalAmt = sTotalAmt;
		this.sDdctAmt = sDdctAmt;
		this.userOfcCd = userOfcCd;
		this.newCreditnoteSeq = newCreditnoteSeq;
		this.sVndrCustAddr2 = sVndrCustAddr2;
		this.totHighEduTax = totHighEduTax;
		this.orgVndrCustAddr = orgVndrCustAddr;
		this.sSteCd = sSteCd;
		this.fincDirCd = fincDirCd;
		this.acctCd = acctCd;
		this.dorNodCd = dorNodCd;
		this.n3ptyInvRmdNm = n3ptyInvRmdNm;
		this.sN3ptyInvRmdYn = sN3ptyInvRmdYn;
		this.bkgNoAll = bkgNoAll;
		this.sN3ptyNo = sN3ptyNo;
		this.sVatXchRt = sVatXchRt;
		this.sVndrSeq = sVndrSeq;
		this.sSheetSetCount = sSheetSetCount;
		this.sCtyNm = sCtyNm;
		this.vndrCustAddr2 = vndrCustAddr2;
		this.sN3ptyInvRvisCd = sN3ptyInvRvisCd;
		this.ofcCd = ofcCd;
		this.sRhqCdForRhq = sRhqCdForRhq;
		this.ydCd = ydCd;
		this.lgsCostCd = lgsCostCd;
		this.viaNodCd = viaNodCd;
		this.sRgstNo = sRgstNo;
		this.occrDt = occrDt;
		this.eqKndCd = eqKndCd;
		this.newVvd = newVvd;
		this.steCd = steCd;
		this.svcCateRmk = svcCateRmk;
		this.pmntAcctNo = pmntAcctNo;
		this.toNodCd = toNodCd;
		this.glDt = glDt;
		this.sCustSeq = sCustSeq;
		this.addAmt = addAmt;
		this.sTrdPartyVal = sTrdPartyVal;
		this.sCurrCd = sCurrCd;
		this.lastFreeDt = lastFreeDt;
		this.otsDtlSeq = otsDtlSeq;
		this.sVndrCustEml = sVndrCustEml;
		this.n3ptyInvNo = n3ptyInvNo;
		this.originalInvDtlAmt = originalInvDtlAmt;
		this.lengthN3ptyBilTpCd = lengthN3ptyBilTpCd;
		this.sInquiryonlyYn = sInquiryonlyYn;
		this.sN3ptyInvRmdCd = sN3ptyInvRmdCd;
		this.userName = userName;
		this.sN3ptyInvStsCd = sN3ptyInvStsCd;
		this.lengthTrdParty = lengthTrdParty;
		this.soNo = soNo;
		this.sInvDesc = sInvDesc;
		this.sVndrCustAddr = sVndrCustAddr;
		this.vvd = vvd;
		this.creUsrId = creUsrId;
		this.sFinalFlgCheckbox = sFinalFlgCheckbox;
		this.damageDt = damageDt;
		this.sDaoN3ptyNo = sDaoN3ptyNo;
		this.faxNo = faxNo;
		this.sInvoiceCancelRemark = sInvoiceCancelRemark;
		this.pickUpDt = pickUpDt;
		this.weight = weight;
		this.overDay = overDay;
		this.creDt = creDt;
		this.userEmail = userEmail;
		this.totalAmt = totalAmt;
		this.taxRgstNo = taxRgstNo;
		this.ibflag = ibflag;
		this.uom = uom;
		this.sZipCd = sZipCd;
		this.invAmt = invAmt;
		this.estmSeqNo = estmSeqNo;
		this.waitingTm = waitingTm;
		this.lengthN3ptyExpnTpCd = lengthN3ptyExpnTpCd;
		this.vndrCustRefRmk = vndrCustRefRmk;
		this.indiataxform = indiataxform;
		this.custSeq = custSeq;
		this.outErpifRvisSeq = outErpifRvisSeq;
		this.orgSteCd = orgSteCd;
		this.sRch = sRch;
		this.sVndrCustNm = sVndrCustNm;
		this.idaTaxSeq = idaTaxSeq;
		this.eqKndNm = eqKndNm;
		this.seq = seq;
		this.sTrdPartyNm = sTrdPartyNm;
		this.newRvisCd = newRvisCd;
		this.sFrance = sFrance;
		this.vndrCustAddr = vndrCustAddr;
		this.wtHrs = wtHrs;
		this.effDt = effDt;
		this.orgCtyNm = orgCtyNm;
		this.soIfSeq = soIfSeq;
		this.sRcvDueDt = sRcvDueDt;
		this.sLengthN3ptyBilTpCd = sLengthN3ptyBilTpCd;
		this.n3ptyInvRvisSeq = n3ptyInvRvisSeq;
		this.sFaxNo = sFaxNo;
		this.blNoAll = blNoAll;
		this.custCntCd = custCntCd;
		this.updUsrId = updUsrId;
		this.validYnCorrection = validYnCorrection;
		this.rhqCd = rhqCd;
		this.sDetailOtsStsCd = sDetailOtsStsCd;
		this.newVslCd = newVslCd;
		this.sVndrCustDivCd = sVndrCustDivCd;
		this.eduTax = eduTax;
		this.newSealNo = newSealNo;
		this.bkgNo = bkgNo;
		this.estmRvisNo = estmRvisNo;
		this.zipCd = zipCd;
		this.sTrdPartyCode = sTrdPartyCode;
		this.revAmt = revAmt;
		this.sHVndrCustDivCd = sHVndrCustDivCd;
		this.rgstNo = rgstNo;
		this.otsStsCd = otsStsCd;
		this.orgZipCd = orgZipCd;
		this.expnTax = expnTax;
		this.sameVersionYn = sameVersionYn;
		this.n3ptyInvStsCd = n3ptyInvStsCd;
		this.sCltAgnFlg = sCltAgnFlg;
		this.vndrCustNm = vndrCustNm;
		this.n3ptyNo = n3ptyNo;
		this.sN3ptyInvNo = sN3ptyInvNo;
		this.arIfNo = arIfNo;
		this.newRvisSeq = newRvisSeq;
		this.orgUsrInpCtnt2 = orgUsrInpCtnt2;
		this.citaNo = citaNo;
		this.orgUsrInpCtnt1 = orgUsrInpCtnt1;
		this.outErpifCreditnoteSeq = outErpifCreditnoteSeq;
		this.totSvcTax = totSvcTax;
		this.repairLocation = repairLocation;
		this.highEduTax = highEduTax;
		this.fmNodCd = fmNodCd;
		this.vatAmt = vatAmt;
		this.orgTotAmt = orgTotAmt;
		this.sDetailN3ptyNo = sDetailN3ptyNo;
		this.bilTpCd = bilTpCd;
		this.route = route;
		this.rcvDueDt = rcvDueDt;
		this.n3ptyInvRmdYn = n3ptyInvRmdYn;
		this.orgInvDesc = orgInvDesc;
		this.vndrCntCd = vndrCntCd;
		this.vslCd = vslCd;
		this.sVatXchRtChk = sVatXchRtChk;
		this.sHisSeq = sHisSeq;
		this.trdPartyCode = trdPartyCode;
		this.n3ptyCntrWgtUtCd = n3ptyCntrWgtUtCd;
		this.newCreditnoteCd = newCreditnoteCd;
		this.sFinalFlg = sFinalFlg;
		this.citationNo = citationNo;
		this.orgDdctAmt = orgDdctAmt;
		this.blNo = blNo;
		this.ftOvrDys = ftOvrDys;
		this.sCorrectionYn = sCorrectionYn;
		this.n3ptyBilTpCd = n3ptyBilTpCd;
		this.vatXchRt = vatXchRt;
		this.netAmt = netAmt;
		this.sPhnNo = sPhnNo;
		this.userId = userId;
		this.outErpifRvisCd = outErpifRvisCd;
		this.totExpnTax = totExpnTax;
		this.sInvRmk2 = sInvRmk2;
		this.orgVndrCustRefRmk = orgVndrCustRefRmk;
		this.csrNo = csrNo;
		this.phnNo = phnNo;
		this.sSameVersionYn = sSameVersionYn;
		this.n3ptyIfTpCd = n3ptyIfTpCd;
		this.sVndrCustRefRmk = sVndrCustRefRmk;
		this.sBilLoc = sBilLoc;
		this.sCustCntCd = sCustCntCd;
		this.newCntrSealNo = newCntrSealNo;
		this.newBkgAll = newBkgAll;
		this.newEqNo = newEqNo;
		this.sDaoN3ptyBilTpCd = sDaoN3ptyBilTpCd;
		this.vndrSeq = vndrSeq;
		this.otsAmt = otsAmt;
		this.sFromCurrCd = sFromCurrCd;
		this.sdate = sdate;
		this.revVvd = revVvd;
		this.currCd = currCd;
		this.sAddAmt = sAddAmt;
		this.sVndrCntCd = sVndrCntCd;
		this.totEduTax = totEduTax;
		this.eqNo = eqNo;
		this.sN3ptyOfcCd = sN3ptyOfcCd;
		this.orgAdmChrg = orgAdmChrg;
		this.sRhqCd = sRhqCd;
		this.lengthRevVvd = lengthRevVvd;
		this.updDt = updDt;
		this.sN3ptyInvRmdNm = sN3ptyInvRmdNm;
		this.vndrCustEml = vndrCustEml;
		this.newBkgNo = newBkgNo;
		this.sInvRmk1 = sInvRmk1;
		this.sIdaTaxSeq = sIdaTaxSeq;
		this.trdParty = trdParty;
		this.bilToLocDivCd = bilToLocDivCd;
		this.skdDirCd = skdDirCd;
		this.lengthCurrCd = lengthCurrCd;
		this.sNetAmt = sNetAmt;
		this.outErpifCreditnoteCd = outErpifCreditnoteCd;
		this.sN3ptyInvRvisSeq = sN3ptyInvRvisSeq;
		this.sInvIssRhqCd = sInvIssRhqCd;
		this.vatDtlAmt = vatDtlAmt;
		this.lstFreeDt = lstFreeDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n3pty_expn_tp_cd", getN3ptyExpnTpCd());
		this.hashColumns.put("usr_inp_ctnt1", getUsrInpCtnt1());
		this.hashColumns.put("estm_svr_id", getEstmSvrId());
		this.hashColumns.put("s_clt_agn_rmk", getSCltAgnRmk());
		this.hashColumns.put("sheet_set_count", getSheetSetCount());
		this.hashColumns.put("inv_dtl_amt", getInvDtlAmt());
		this.hashColumns.put("vat_xch_rt_original", getVatXchRtOriginal());
		this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
		this.hashColumns.put("usr_inp_ctnt2", getUsrInpCtnt2());
		this.hashColumns.put("mgset_no", getMgsetNo());
		this.hashColumns.put("org_clt_agn_flg", getOrgCltAgnFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_usr_inp_ctnt2", getSUsrInpCtnt2());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("s_usr_inp_ctnt1", getSUsrInpCtnt1());
		this.hashColumns.put("edate", getEdate());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("s_n3pty_inv_his_seq", getSN3ptyInvHisSeq());
		this.hashColumns.put("eng_addr", getEngAddr());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("s_vat_amt", getSVatAmt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("s_addr", getSAddr());
		this.hashColumns.put("org_due_date", getOrgDueDate());
		this.hashColumns.put("pkup_dt", getPkupDt());
		this.hashColumns.put("n3pty_inv_no_tmp", getN3ptyInvNoTmp());
		this.hashColumns.put("del_sucess", getDelSucess());
		this.hashColumns.put("s_sum_inv_amt", getSSumInvAmt());
		this.hashColumns.put("s_total_amt", getSTotalAmt());
		this.hashColumns.put("s_ddct_amt", getSDdctAmt());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("new_creditnote_seq", getNewCreditnoteSeq());
		this.hashColumns.put("s_vndr_cust_addr2", getSVndrCustAddr2());
		this.hashColumns.put("tot_high_edu_tax", getTotHighEduTax());
		this.hashColumns.put("org_vndr_cust_addr", getOrgVndrCustAddr());
		this.hashColumns.put("s_ste_cd", getSSteCd());
		this.hashColumns.put("finc_dir_cd", getFincDirCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("n3pty_inv_rmd_nm", getN3ptyInvRmdNm());
		this.hashColumns.put("s_n3pty_inv_rmd_yn", getSN3ptyInvRmdYn());
		this.hashColumns.put("bkg_no_all", getBkgNoAll());
		this.hashColumns.put("s_n3pty_no", getSN3ptyNo());
		this.hashColumns.put("s_vat_xch_rt", getSVatXchRt());
		this.hashColumns.put("s_vndr_seq", getSVndrSeq());
		this.hashColumns.put("s_sheet_set_count", getSSheetSetCount());
		this.hashColumns.put("s_cty_nm", getSCtyNm());
		this.hashColumns.put("vndr_cust_addr2", getVndrCustAddr2());
		this.hashColumns.put("s_n3pty_inv_rvis_cd", getSN3ptyInvRvisCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("s_rhq_cd_for_rhq", getSRhqCdForRhq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("s_rgst_no", getSRgstNo());
		this.hashColumns.put("occr_dt", getOccrDt());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("new_vvd", getNewVvd());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("svc_cate_rmk", getSvcCateRmk());
		this.hashColumns.put("pmnt_acct_no", getPmntAcctNo());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("s_cust_seq", getSCustSeq());
		this.hashColumns.put("add_amt", getAddAmt());
		this.hashColumns.put("s_trd_party_val", getSTrdPartyVal());
		this.hashColumns.put("s_curr_cd", getSCurrCd());
		this.hashColumns.put("last_free_dt", getLastFreeDt());
		this.hashColumns.put("ots_dtl_seq", getOtsDtlSeq());
		this.hashColumns.put("s_vndr_cust_eml", getSVndrCustEml());
		this.hashColumns.put("n3pty_inv_no", getN3ptyInvNo());
		this.hashColumns.put("original_inv_dtl_amt", getOriginalInvDtlAmt());
		this.hashColumns.put("length_n3pty_bil_tp_cd", getLengthN3ptyBilTpCd());
		this.hashColumns.put("s_inquiryonly_yn", getSInquiryonlyYn());
		this.hashColumns.put("s_n3pty_inv_rmd_cd", getSN3ptyInvRmdCd());
		this.hashColumns.put("user_name", getUserName());
		this.hashColumns.put("s_n3pty_inv_sts_cd", getSN3ptyInvStsCd());
		this.hashColumns.put("length_trd_party", getLengthTrdParty());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("s_inv_desc", getSInvDesc());
		this.hashColumns.put("s_vndr_cust_addr", getSVndrCustAddr());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("s_final_flg_checkbox", getSFinalFlgCheckbox());
		this.hashColumns.put("damage_dt", getDamageDt());
		this.hashColumns.put("s_dao_n3pty_no", getSDaoN3ptyNo());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("s_invoice_cancel_remark", getSInvoiceCancelRemark());
		this.hashColumns.put("pick_up_dt", getPickUpDt());
		this.hashColumns.put("weight", getWeight());
		this.hashColumns.put("over_day", getOverDay());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("user_email", getUserEmail());
		this.hashColumns.put("total_amt", getTotalAmt());
		this.hashColumns.put("tax_rgst_no", getTaxRgstNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("uom", getUom());
		this.hashColumns.put("s_zip_cd", getSZipCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("estm_seq_no", getEstmSeqNo());
		this.hashColumns.put("waiting_tm", getWaitingTm());
		this.hashColumns.put("length_n3pty_expn_tp_cd", getLengthN3ptyExpnTpCd());
		this.hashColumns.put("vndr_cust_ref_rmk", getVndrCustRefRmk());
		this.hashColumns.put("indiataxform", getIndiataxform());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("out_erpif_rvis_seq", getOutErpifRvisSeq());
		this.hashColumns.put("org_ste_cd", getOrgSteCd());
		this.hashColumns.put("s_rch", getSRch());
		this.hashColumns.put("s_vndr_cust_nm", getSVndrCustNm());
		this.hashColumns.put("ida_tax_seq", getIdaTaxSeq());
		this.hashColumns.put("eq_knd_nm", getEqKndNm());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("s_trd_party_nm", getSTrdPartyNm());
		this.hashColumns.put("new_rvis_cd", getNewRvisCd());
		this.hashColumns.put("s_france", getSFrance());
		this.hashColumns.put("vndr_cust_addr", getVndrCustAddr());
		this.hashColumns.put("wt_hrs", getWtHrs());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("org_cty_nm", getOrgCtyNm());
		this.hashColumns.put("so_if_seq", getSoIfSeq());
		this.hashColumns.put("s_rcv_due_dt", getSRcvDueDt());
		this.hashColumns.put("s_length_n3pty_bil_tp_cd", getSLengthN3ptyBilTpCd());
		this.hashColumns.put("n3pty_inv_rvis_seq", getN3ptyInvRvisSeq());
		this.hashColumns.put("s_fax_no", getSFaxNo());
		this.hashColumns.put("bl_no_all", getBlNoAll());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("valid_yn_correction", getValidYnCorrection());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("s_detail_ots_sts_cd", getSDetailOtsStsCd());
		this.hashColumns.put("new_vsl_cd", getNewVslCd());
		this.hashColumns.put("s_vndr_cust_div_cd", getSVndrCustDivCd());
		this.hashColumns.put("edu_tax", getEduTax());
		this.hashColumns.put("new_seal_no", getNewSealNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("estm_rvis_no", getEstmRvisNo());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("s_trd_party_code", getSTrdPartyCode());
		this.hashColumns.put("rev_amt", getRevAmt());
		this.hashColumns.put("s_h_vndr_cust_div_cd", getSHVndrCustDivCd());
		this.hashColumns.put("rgst_no", getRgstNo());
		this.hashColumns.put("ots_sts_cd", getOtsStsCd());
		this.hashColumns.put("org_zip_cd", getOrgZipCd());
		this.hashColumns.put("expn_tax", getExpnTax());
		this.hashColumns.put("same_version_yn", getSameVersionYn());
		this.hashColumns.put("n3pty_inv_sts_cd", getN3ptyInvStsCd());
		this.hashColumns.put("s_clt_agn_flg", getSCltAgnFlg());
		this.hashColumns.put("vndr_cust_nm", getVndrCustNm());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("s_n3pty_inv_no", getSN3ptyInvNo());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("new_rvis_seq", getNewRvisSeq());
		this.hashColumns.put("org_usr_inp_ctnt2", getOrgUsrInpCtnt2());
		this.hashColumns.put("cita_no", getCitaNo());
		this.hashColumns.put("org_usr_inp_ctnt1", getOrgUsrInpCtnt1());
		this.hashColumns.put("out_erpif_creditnote_seq", getOutErpifCreditnoteSeq());
		this.hashColumns.put("tot_svc_tax", getTotSvcTax());
		this.hashColumns.put("repair_location", getRepairLocation());
		this.hashColumns.put("high_edu_tax", getHighEduTax());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("vat_amt", getVatAmt());
		this.hashColumns.put("org_tot_amt", getOrgTotAmt());
		this.hashColumns.put("s_detail_n3pty_no", getSDetailN3ptyNo());
		this.hashColumns.put("bil_tp_cd", getBilTpCd());
		this.hashColumns.put("route", getRoute());
		this.hashColumns.put("rcv_due_dt", getRcvDueDt());
		this.hashColumns.put("n3pty_inv_rmd_yn", getN3ptyInvRmdYn());
		this.hashColumns.put("org_inv_desc", getOrgInvDesc());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("s_vat_xch_rt_chk", getSVatXchRtChk());
		this.hashColumns.put("s_his_seq", getSHisSeq());
		this.hashColumns.put("trd_party_code", getTrdPartyCode());
		this.hashColumns.put("n3pty_cntr_wgt_ut_cd", getN3ptyCntrWgtUtCd());
		this.hashColumns.put("new_creditnote_cd", getNewCreditnoteCd());
		this.hashColumns.put("s_final_flg", getSFinalFlg());
		this.hashColumns.put("citation_no", getCitationNo());
		this.hashColumns.put("org_ddct_amt", getOrgDdctAmt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ft_ovr_dys", getFtOvrDys());
		this.hashColumns.put("s_correction_yn", getSCorrectionYn());
		this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
		this.hashColumns.put("vat_xch_rt", getVatXchRt());
		this.hashColumns.put("net_amt", getNetAmt());
		this.hashColumns.put("s_phn_no", getSPhnNo());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("out_erpif_rvis_cd", getOutErpifRvisCd());
		this.hashColumns.put("tot_expn_tax", getTotExpnTax());
		this.hashColumns.put("s_inv_rmk2", getSInvRmk2());
		this.hashColumns.put("org_vndr_cust_ref_rmk", getOrgVndrCustRefRmk());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("s_same_version_yn", getSSameVersionYn());
		this.hashColumns.put("n3pty_if_tp_cd", getN3ptyIfTpCd());
		this.hashColumns.put("s_vndr_cust_ref_rmk", getSVndrCustRefRmk());
		this.hashColumns.put("s_bil_loc", getSBilLoc());
		this.hashColumns.put("s_cust_cnt_cd", getSCustCntCd());
		this.hashColumns.put("new_cntr_seal_no", getNewCntrSealNo());
		this.hashColumns.put("new_bkg_all", getNewBkgAll());
		this.hashColumns.put("new_eq_no", getNewEqNo());
		this.hashColumns.put("s_dao_n3pty_bil_tp_cd", getSDaoN3ptyBilTpCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ots_amt", getOtsAmt());
		this.hashColumns.put("s_from_curr_cd", getSFromCurrCd());
		this.hashColumns.put("sdate", getSdate());
		this.hashColumns.put("rev_vvd", getRevVvd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("s_add_amt", getSAddAmt());
		this.hashColumns.put("s_vndr_cnt_cd", getSVndrCntCd());
		this.hashColumns.put("tot_edu_tax", getTotEduTax());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("s_n3pty_ofc_cd", getSN3ptyOfcCd());
		this.hashColumns.put("org_adm_chrg", getOrgAdmChrg());
		this.hashColumns.put("s_rhq_cd", getSRhqCd());
		this.hashColumns.put("length_rev_vvd", getLengthRevVvd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("s_n3pty_inv_rmd_nm", getSN3ptyInvRmdNm());
		this.hashColumns.put("vndr_cust_eml", getVndrCustEml());
		this.hashColumns.put("new_bkg_no", getNewBkgNo());
		this.hashColumns.put("s_inv_rmk1", getSInvRmk1());
		this.hashColumns.put("s_ida_tax_seq", getSIdaTaxSeq());
		this.hashColumns.put("trd_party", getTrdParty());
		this.hashColumns.put("bil_to_loc_div_cd", getBilToLocDivCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("length_curr_cd", getLengthCurrCd());
		this.hashColumns.put("s_net_amt", getSNetAmt());
		this.hashColumns.put("out_erpif_creditnote_cd", getOutErpifCreditnoteCd());
		this.hashColumns.put("s_n3pty_inv_rvis_seq", getSN3ptyInvRvisSeq());
		this.hashColumns.put("s_inv_iss_rhq_cd", getSInvIssRhqCd());
		this.hashColumns.put("vat_dtl_amt", getVatDtlAmt());
		this.hashColumns.put("lst_free_dt", getLstFreeDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n3pty_expn_tp_cd", "n3ptyExpnTpCd");
		this.hashFields.put("usr_inp_ctnt1", "usrInpCtnt1");
		this.hashFields.put("estm_svr_id", "estmSvrId");
		this.hashFields.put("s_clt_agn_rmk", "sCltAgnRmk");
		this.hashFields.put("sheet_set_count", "sheetSetCount");
		this.hashFields.put("inv_dtl_amt", "invDtlAmt");
		this.hashFields.put("vat_xch_rt_original", "vatXchRtOriginal");
		this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");
		this.hashFields.put("usr_inp_ctnt2", "usrInpCtnt2");
		this.hashFields.put("mgset_no", "mgsetNo");
		this.hashFields.put("org_clt_agn_flg", "orgCltAgnFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_usr_inp_ctnt2", "sUsrInpCtnt2");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("s_usr_inp_ctnt1", "sUsrInpCtnt1");
		this.hashFields.put("edate", "edate");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("s_n3pty_inv_his_seq", "sN3ptyInvHisSeq");
		this.hashFields.put("eng_addr", "engAddr");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("s_vat_amt", "sVatAmt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("s_addr", "sAddr");
		this.hashFields.put("org_due_date", "orgDueDate");
		this.hashFields.put("pkup_dt", "pkupDt");
		this.hashFields.put("n3pty_inv_no_tmp", "n3ptyInvNoTmp");
		this.hashFields.put("del_sucess", "delSucess");
		this.hashFields.put("s_sum_inv_amt", "sSumInvAmt");
		this.hashFields.put("s_total_amt", "sTotalAmt");
		this.hashFields.put("s_ddct_amt", "sDdctAmt");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("new_creditnote_seq", "newCreditnoteSeq");
		this.hashFields.put("s_vndr_cust_addr2", "sVndrCustAddr2");
		this.hashFields.put("tot_high_edu_tax", "totHighEduTax");
		this.hashFields.put("org_vndr_cust_addr", "orgVndrCustAddr");
		this.hashFields.put("s_ste_cd", "sSteCd");
		this.hashFields.put("finc_dir_cd", "fincDirCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("n3pty_inv_rmd_nm", "n3ptyInvRmdNm");
		this.hashFields.put("s_n3pty_inv_rmd_yn", "sN3ptyInvRmdYn");
		this.hashFields.put("bkg_no_all", "bkgNoAll");
		this.hashFields.put("s_n3pty_no", "sN3ptyNo");
		this.hashFields.put("s_vat_xch_rt", "sVatXchRt");
		this.hashFields.put("s_vndr_seq", "sVndrSeq");
		this.hashFields.put("s_sheet_set_count", "sSheetSetCount");
		this.hashFields.put("s_cty_nm", "sCtyNm");
		this.hashFields.put("vndr_cust_addr2", "vndrCustAddr2");
		this.hashFields.put("s_n3pty_inv_rvis_cd", "sN3ptyInvRvisCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("s_rhq_cd_for_rhq", "sRhqCdForRhq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("s_rgst_no", "sRgstNo");
		this.hashFields.put("occr_dt", "occrDt");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("new_vvd", "newVvd");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("svc_cate_rmk", "svcCateRmk");
		this.hashFields.put("pmnt_acct_no", "pmntAcctNo");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("s_cust_seq", "sCustSeq");
		this.hashFields.put("add_amt", "addAmt");
		this.hashFields.put("s_trd_party_val", "sTrdPartyVal");
		this.hashFields.put("s_curr_cd", "sCurrCd");
		this.hashFields.put("last_free_dt", "lastFreeDt");
		this.hashFields.put("ots_dtl_seq", "otsDtlSeq");
		this.hashFields.put("s_vndr_cust_eml", "sVndrCustEml");
		this.hashFields.put("n3pty_inv_no", "n3ptyInvNo");
		this.hashFields.put("original_inv_dtl_amt", "originalInvDtlAmt");
		this.hashFields.put("length_n3pty_bil_tp_cd", "lengthN3ptyBilTpCd");
		this.hashFields.put("s_inquiryonly_yn", "sInquiryonlyYn");
		this.hashFields.put("s_n3pty_inv_rmd_cd", "sN3ptyInvRmdCd");
		this.hashFields.put("user_name", "userName");
		this.hashFields.put("s_n3pty_inv_sts_cd", "sN3ptyInvStsCd");
		this.hashFields.put("length_trd_party", "lengthTrdParty");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("s_inv_desc", "sInvDesc");
		this.hashFields.put("s_vndr_cust_addr", "sVndrCustAddr");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("s_final_flg_checkbox", "sFinalFlgCheckbox");
		this.hashFields.put("damage_dt", "damageDt");
		this.hashFields.put("s_dao_n3pty_no", "sDaoN3ptyNo");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("s_invoice_cancel_remark", "sInvoiceCancelRemark");
		this.hashFields.put("pick_up_dt", "pickUpDt");
		this.hashFields.put("weight", "weight");
		this.hashFields.put("over_day", "overDay");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("user_email", "userEmail");
		this.hashFields.put("total_amt", "totalAmt");
		this.hashFields.put("tax_rgst_no", "taxRgstNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("uom", "uom");
		this.hashFields.put("s_zip_cd", "sZipCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("estm_seq_no", "estmSeqNo");
		this.hashFields.put("waiting_tm", "waitingTm");
		this.hashFields.put("length_n3pty_expn_tp_cd", "lengthN3ptyExpnTpCd");
		this.hashFields.put("vndr_cust_ref_rmk", "vndrCustRefRmk");
		this.hashFields.put("indiataxform", "indiataxform");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("out_erpif_rvis_seq", "outErpifRvisSeq");
		this.hashFields.put("org_ste_cd", "orgSteCd");
		this.hashFields.put("s_rch", "sRch");
		this.hashFields.put("s_vndr_cust_nm", "sVndrCustNm");
		this.hashFields.put("ida_tax_seq", "idaTaxSeq");
		this.hashFields.put("eq_knd_nm", "eqKndNm");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("s_trd_party_nm", "sTrdPartyNm");
		this.hashFields.put("new_rvis_cd", "newRvisCd");
		this.hashFields.put("s_france", "sFrance");
		this.hashFields.put("vndr_cust_addr", "vndrCustAddr");
		this.hashFields.put("wt_hrs", "wtHrs");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("org_cty_nm", "orgCtyNm");
		this.hashFields.put("so_if_seq", "soIfSeq");
		this.hashFields.put("s_rcv_due_dt", "sRcvDueDt");
		this.hashFields.put("s_length_n3pty_bil_tp_cd", "sLengthN3ptyBilTpCd");
		this.hashFields.put("n3pty_inv_rvis_seq", "n3ptyInvRvisSeq");
		this.hashFields.put("s_fax_no", "sFaxNo");
		this.hashFields.put("bl_no_all", "blNoAll");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("valid_yn_correction", "validYnCorrection");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("s_detail_ots_sts_cd", "sDetailOtsStsCd");
		this.hashFields.put("new_vsl_cd", "newVslCd");
		this.hashFields.put("s_vndr_cust_div_cd", "sVndrCustDivCd");
		this.hashFields.put("edu_tax", "eduTax");
		this.hashFields.put("new_seal_no", "newSealNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("estm_rvis_no", "estmRvisNo");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("s_trd_party_code", "sTrdPartyCode");
		this.hashFields.put("rev_amt", "revAmt");
		this.hashFields.put("s_h_vndr_cust_div_cd", "sHVndrCustDivCd");
		this.hashFields.put("rgst_no", "rgstNo");
		this.hashFields.put("ots_sts_cd", "otsStsCd");
		this.hashFields.put("org_zip_cd", "orgZipCd");
		this.hashFields.put("expn_tax", "expnTax");
		this.hashFields.put("same_version_yn", "sameVersionYn");
		this.hashFields.put("n3pty_inv_sts_cd", "n3ptyInvStsCd");
		this.hashFields.put("s_clt_agn_flg", "sCltAgnFlg");
		this.hashFields.put("vndr_cust_nm", "vndrCustNm");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("s_n3pty_inv_no", "sN3ptyInvNo");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("new_rvis_seq", "newRvisSeq");
		this.hashFields.put("org_usr_inp_ctnt2", "orgUsrInpCtnt2");
		this.hashFields.put("cita_no", "citaNo");
		this.hashFields.put("org_usr_inp_ctnt1", "orgUsrInpCtnt1");
		this.hashFields.put("out_erpif_creditnote_seq", "outErpifCreditnoteSeq");
		this.hashFields.put("tot_svc_tax", "totSvcTax");
		this.hashFields.put("repair_location", "repairLocation");
		this.hashFields.put("high_edu_tax", "highEduTax");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("vat_amt", "vatAmt");
		this.hashFields.put("org_tot_amt", "orgTotAmt");
		this.hashFields.put("s_detail_n3pty_no", "sDetailN3ptyNo");
		this.hashFields.put("bil_tp_cd", "bilTpCd");
		this.hashFields.put("route", "route");
		this.hashFields.put("rcv_due_dt", "rcvDueDt");
		this.hashFields.put("n3pty_inv_rmd_yn", "n3ptyInvRmdYn");
		this.hashFields.put("org_inv_desc", "orgInvDesc");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("s_vat_xch_rt_chk", "sVatXchRtChk");
		this.hashFields.put("s_his_seq", "sHisSeq");
		this.hashFields.put("trd_party_code", "trdPartyCode");
		this.hashFields.put("n3pty_cntr_wgt_ut_cd", "n3ptyCntrWgtUtCd");
		this.hashFields.put("new_creditnote_cd", "newCreditnoteCd");
		this.hashFields.put("s_final_flg", "sFinalFlg");
		this.hashFields.put("citation_no", "citationNo");
		this.hashFields.put("org_ddct_amt", "orgDdctAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ft_ovr_dys", "ftOvrDys");
		this.hashFields.put("s_correction_yn", "sCorrectionYn");
		this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
		this.hashFields.put("vat_xch_rt", "vatXchRt");
		this.hashFields.put("net_amt", "netAmt");
		this.hashFields.put("s_phn_no", "sPhnNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("out_erpif_rvis_cd", "outErpifRvisCd");
		this.hashFields.put("tot_expn_tax", "totExpnTax");
		this.hashFields.put("s_inv_rmk2", "sInvRmk2");
		this.hashFields.put("org_vndr_cust_ref_rmk", "orgVndrCustRefRmk");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("s_same_version_yn", "sSameVersionYn");
		this.hashFields.put("n3pty_if_tp_cd", "n3ptyIfTpCd");
		this.hashFields.put("s_vndr_cust_ref_rmk", "sVndrCustRefRmk");
		this.hashFields.put("s_bil_loc", "sBilLoc");
		this.hashFields.put("s_cust_cnt_cd", "sCustCntCd");
		this.hashFields.put("new_cntr_seal_no", "newCntrSealNo");
		this.hashFields.put("new_bkg_all", "newBkgAll");
		this.hashFields.put("new_eq_no", "newEqNo");
		this.hashFields.put("s_dao_n3pty_bil_tp_cd", "sDaoN3ptyBilTpCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ots_amt", "otsAmt");
		this.hashFields.put("s_from_curr_cd", "sFromCurrCd");
		this.hashFields.put("sdate", "sdate");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("s_add_amt", "sAddAmt");
		this.hashFields.put("s_vndr_cnt_cd", "sVndrCntCd");
		this.hashFields.put("tot_edu_tax", "totEduTax");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("s_n3pty_ofc_cd", "sN3ptyOfcCd");
		this.hashFields.put("org_adm_chrg", "orgAdmChrg");
		this.hashFields.put("s_rhq_cd", "sRhqCd");
		this.hashFields.put("length_rev_vvd", "lengthRevVvd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("s_n3pty_inv_rmd_nm", "sN3ptyInvRmdNm");
		this.hashFields.put("vndr_cust_eml", "vndrCustEml");
		this.hashFields.put("new_bkg_no", "newBkgNo");
		this.hashFields.put("s_inv_rmk1", "sInvRmk1");
		this.hashFields.put("s_ida_tax_seq", "sIdaTaxSeq");
		this.hashFields.put("trd_party", "trdParty");
		this.hashFields.put("bil_to_loc_div_cd", "bilToLocDivCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("length_curr_cd", "lengthCurrCd");
		this.hashFields.put("s_net_amt", "sNetAmt");
		this.hashFields.put("out_erpif_creditnote_cd", "outErpifCreditnoteCd");
		this.hashFields.put("s_n3pty_inv_rvis_seq", "sN3ptyInvRvisSeq");
		this.hashFields.put("s_inv_iss_rhq_cd", "sInvIssRhqCd");
		this.hashFields.put("vat_dtl_amt", "vatDtlAmt");
		this.hashFields.put("lst_free_dt", "lstFreeDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n3ptyExpnTpCd
	 */
	public String getN3ptyExpnTpCd() {
		return this.n3ptyExpnTpCd;
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
	 * @return estmSvrId
	 */
	public String getEstmSvrId() {
		return this.estmSvrId;
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
	 * @return sheetSetCount
	 */
	public String getSheetSetCount() {
		return this.sheetSetCount;
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
	 * @return vatXchRtOriginal
	 */
	public String getVatXchRtOriginal() {
		return this.vatXchRtOriginal;
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
	 * @return usrInpCtnt2
	 */
	public String getUsrInpCtnt2() {
		return this.usrInpCtnt2;
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
	 * @return orgCltAgnFlg
	 */
	public String getOrgCltAgnFlg() {
		return this.orgCltAgnFlg;
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
	 * @return engAddr
	 */
	public String getEngAddr() {
		return this.engAddr;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return orgDueDate
	 */
	public String getOrgDueDate() {
		return this.orgDueDate;
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
	 * @return n3ptyInvNoTmp
	 */
	public String getN3ptyInvNoTmp() {
		return this.n3ptyInvNoTmp;
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
	 * @return fincDirCd
	 */
	public String getFincDirCd() {
		return this.fincDirCd;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
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
	 * @return bkgNoAll
	 */
	public String getBkgNoAll() {
		return this.bkgNoAll;
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
	 * @return sVatXchRt
	 */
	public String getSVatXchRt() {
		return this.sVatXchRt;
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
	 * @return sSheetSetCount
	 */
	public String getSSheetSetCount() {
		return this.sSheetSetCount;
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
	 * @return vndrCustAddr2
	 */
	public String getVndrCustAddr2() {
		return this.vndrCustAddr2;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvRvisCd
	 */
	public String getSN3ptyInvRvisCd() {
		return this.sN3ptyInvRvisCd;
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
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
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
	 * @return occrDt
	 */
	public String getOccrDt() {
		return this.occrDt;
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
	 * @return newVvd
	 */
	public String getNewVvd() {
		return this.newVvd;
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
	 * @return pmntAcctNo
	 */
	public String getPmntAcctNo() {
		return this.pmntAcctNo;
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
	 * @return lastFreeDt
	 */
	public String getLastFreeDt() {
		return this.lastFreeDt;
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
	 * @return lengthN3ptyBilTpCd
	 */
	public String getLengthN3ptyBilTpCd() {
		return this.lengthN3ptyBilTpCd;
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
	 * @return userName
	 */
	public String getUserName() {
		return this.userName;
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
	 * @return lengthTrdParty
	 */
	public String getLengthTrdParty() {
		return this.lengthTrdParty;
	}
	
	/**
	 * Column Info
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return sDaoN3ptyNo
	 */
	public String getSDaoN3ptyNo() {
		return this.sDaoN3ptyNo;
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
	 * @return sInvoiceCancelRemark
	 */
	public String getSInvoiceCancelRemark() {
		return this.sInvoiceCancelRemark;
	}
	
	/**
	 * Column Info
	 * @return pickUpDt
	 */
	public String getPickUpDt() {
		return this.pickUpDt;
	}
	
	/**
	 * Column Info
	 * @return weight
	 */
	public String getWeight() {
		return this.weight;
	}
	
	/**
	 * Column Info
	 * @return overDay
	 */
	public String getOverDay() {
		return this.overDay;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return userEmail
	 */
	public String getUserEmail() {
		return this.userEmail;
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
	 * @return uom
	 */
	public String getUom() {
		return this.uom;
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
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return estmSeqNo
	 */
	public String getEstmSeqNo() {
		return this.estmSeqNo;
	}
	
	/**
	 * Column Info
	 * @return waitingTm
	 */
	public String getWaitingTm() {
		return this.waitingTm;
	}
	
	/**
	 * Column Info
	 * @return lengthN3ptyExpnTpCd
	 */
	public String getLengthN3ptyExpnTpCd() {
		return this.lengthN3ptyExpnTpCd;
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
	 * @return indiataxform
	 */
	public String getIndiataxform() {
		return this.indiataxform;
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
	 * @return outErpifRvisSeq
	 */
	public String getOutErpifRvisSeq() {
		return this.outErpifRvisSeq;
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
	 * @return sTrdPartyNm
	 */
	public String getSTrdPartyNm() {
		return this.sTrdPartyNm;
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
	 * @return sFrance
	 */
	public String getSFrance() {
		return this.sFrance;
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
	 * @return wtHrs
	 */
	public String getWtHrs() {
		return this.wtHrs;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return n3ptyInvRvisSeq
	 */
	public String getN3ptyInvRvisSeq() {
		return this.n3ptyInvRvisSeq;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
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
	 * @return newSealNo
	 */
	public String getNewSealNo() {
		return this.newSealNo;
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
	 * @return estmRvisNo
	 */
	public String getEstmRvisNo() {
		return this.estmRvisNo;
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
	 * @return revAmt
	 */
	public String getRevAmt() {
		return this.revAmt;
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
	 * @return n3ptyInvStsCd
	 */
	public String getN3ptyInvStsCd() {
		return this.n3ptyInvStsCd;
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
	 * @return vndrCustNm
	 */
	public String getVndrCustNm() {
		return this.vndrCustNm;
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
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
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
	 * @return outErpifCreditnoteSeq
	 */
	public String getOutErpifCreditnoteSeq() {
		return this.outErpifCreditnoteSeq;
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
	 * @return bilTpCd
	 */
	public String getBilTpCd() {
		return this.bilTpCd;
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
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
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
	 * @return citationNo
	 */
	public String getCitationNo() {
		return this.citationNo;
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
	 * @return ftOvrDys
	 */
	public String getFtOvrDys() {
		return this.ftOvrDys;
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
	 * @return n3ptyBilTpCd
	 */
	public String getN3ptyBilTpCd() {
		return this.n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @return vatXchRt
	 */
	public String getVatXchRt() {
		return this.vatXchRt;
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
	 * @return outErpifRvisCd
	 */
	public String getOutErpifRvisCd() {
		return this.outErpifRvisCd;
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
	 * @return n3ptyIfTpCd
	 */
	public String getN3ptyIfTpCd() {
		return this.n3ptyIfTpCd;
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
	 * @return newBkgAll
	 */
	public String getNewBkgAll() {
		return this.newBkgAll;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return revVvd
	 */
	public String getRevVvd() {
		return this.revVvd;
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
	 * @return sRhqCd
	 */
	public String getSRhqCd() {
		return this.sRhqCd;
	}
	
	/**
	 * Column Info
	 * @return lengthRevVvd
	 */
	public String getLengthRevVvd() {
		return this.lengthRevVvd;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return vndrCustEml
	 */
	public String getVndrCustEml() {
		return this.vndrCustEml;
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
	 * @return trdParty
	 */
	public String getTrdParty() {
		return this.trdParty;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return lengthCurrCd
	 */
	public String getLengthCurrCd() {
		return this.lengthCurrCd;
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
	 * @return outErpifCreditnoteCd
	 */
	public String getOutErpifCreditnoteCd() {
		return this.outErpifCreditnoteCd;
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
	 * @return vatDtlAmt
	 */
	public String getVatDtlAmt() {
		return this.vatDtlAmt;
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
	 * @param n3ptyExpnTpCd
	 */
	public void setN3ptyExpnTpCd(String n3ptyExpnTpCd) {
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
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
	 * @param estmSvrId
	 */
	public void setEstmSvrId(String estmSvrId) {
		this.estmSvrId = estmSvrId;
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
	 * @param sheetSetCount
	 */
	public void setSheetSetCount(String sheetSetCount) {
		this.sheetSetCount = sheetSetCount;
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
	 * @param vatXchRtOriginal
	 */
	public void setVatXchRtOriginal(String vatXchRtOriginal) {
		this.vatXchRtOriginal = vatXchRtOriginal;
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
	 * @param usrInpCtnt2
	 */
	public void setUsrInpCtnt2(String usrInpCtnt2) {
		this.usrInpCtnt2 = usrInpCtnt2;
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
	 * @param orgCltAgnFlg
	 */
	public void setOrgCltAgnFlg(String orgCltAgnFlg) {
		this.orgCltAgnFlg = orgCltAgnFlg;
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
	 * @param engAddr
	 */
	public void setEngAddr(String engAddr) {
		this.engAddr = engAddr;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param orgDueDate
	 */
	public void setOrgDueDate(String orgDueDate) {
		this.orgDueDate = orgDueDate;
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
	 * @param n3ptyInvNoTmp
	 */
	public void setN3ptyInvNoTmp(String n3ptyInvNoTmp) {
		this.n3ptyInvNoTmp = n3ptyInvNoTmp;
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
	 * @param fincDirCd
	 */
	public void setFincDirCd(String fincDirCd) {
		this.fincDirCd = fincDirCd;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
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
	 * @param bkgNoAll
	 */
	public void setBkgNoAll(String bkgNoAll) {
		this.bkgNoAll = bkgNoAll;
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
	 * @param sVatXchRt
	 */
	public void setSVatXchRt(String sVatXchRt) {
		this.sVatXchRt = sVatXchRt;
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
	 * @param sSheetSetCount
	 */
	public void setSSheetSetCount(String sSheetSetCount) {
		this.sSheetSetCount = sSheetSetCount;
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
	 * @param vndrCustAddr2
	 */
	public void setVndrCustAddr2(String vndrCustAddr2) {
		this.vndrCustAddr2 = vndrCustAddr2;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvRvisCd
	 */
	public void setSN3ptyInvRvisCd(String sN3ptyInvRvisCd) {
		this.sN3ptyInvRvisCd = sN3ptyInvRvisCd;
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
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
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
	 * @param occrDt
	 */
	public void setOccrDt(String occrDt) {
		this.occrDt = occrDt;
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
	 * @param newVvd
	 */
	public void setNewVvd(String newVvd) {
		this.newVvd = newVvd;
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
	 * @param pmntAcctNo
	 */
	public void setPmntAcctNo(String pmntAcctNo) {
		this.pmntAcctNo = pmntAcctNo;
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
	 * @param lastFreeDt
	 */
	public void setLastFreeDt(String lastFreeDt) {
		this.lastFreeDt = lastFreeDt;
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
	 * @param lengthN3ptyBilTpCd
	 */
	public void setLengthN3ptyBilTpCd(String lengthN3ptyBilTpCd) {
		this.lengthN3ptyBilTpCd = lengthN3ptyBilTpCd;
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
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @param lengthTrdParty
	 */
	public void setLengthTrdParty(String lengthTrdParty) {
		this.lengthTrdParty = lengthTrdParty;
	}
	
	/**
	 * Column Info
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param sDaoN3ptyNo
	 */
	public void setSDaoN3ptyNo(String sDaoN3ptyNo) {
		this.sDaoN3ptyNo = sDaoN3ptyNo;
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
	 * @param sInvoiceCancelRemark
	 */
	public void setSInvoiceCancelRemark(String sInvoiceCancelRemark) {
		this.sInvoiceCancelRemark = sInvoiceCancelRemark;
	}
	
	/**
	 * Column Info
	 * @param pickUpDt
	 */
	public void setPickUpDt(String pickUpDt) {
		this.pickUpDt = pickUpDt;
	}
	
	/**
	 * Column Info
	 * @param weight
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	/**
	 * Column Info
	 * @param overDay
	 */
	public void setOverDay(String overDay) {
		this.overDay = overDay;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param userEmail
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
	 * @param uom
	 */
	public void setUom(String uom) {
		this.uom = uom;
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
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param estmSeqNo
	 */
	public void setEstmSeqNo(String estmSeqNo) {
		this.estmSeqNo = estmSeqNo;
	}
	
	/**
	 * Column Info
	 * @param waitingTm
	 */
	public void setWaitingTm(String waitingTm) {
		this.waitingTm = waitingTm;
	}
	
	/**
	 * Column Info
	 * @param lengthN3ptyExpnTpCd
	 */
	public void setLengthN3ptyExpnTpCd(String lengthN3ptyExpnTpCd) {
		this.lengthN3ptyExpnTpCd = lengthN3ptyExpnTpCd;
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
	 * @param indiataxform
	 */
	public void setIndiataxform(String indiataxform) {
		this.indiataxform = indiataxform;
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
	 * @param outErpifRvisSeq
	 */
	public void setOutErpifRvisSeq(String outErpifRvisSeq) {
		this.outErpifRvisSeq = outErpifRvisSeq;
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
	 * @param sTrdPartyNm
	 */
	public void setSTrdPartyNm(String sTrdPartyNm) {
		this.sTrdPartyNm = sTrdPartyNm;
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
	 * @param sFrance
	 */
	public void setSFrance(String sFrance) {
		this.sFrance = sFrance;
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
	 * @param wtHrs
	 */
	public void setWtHrs(String wtHrs) {
		this.wtHrs = wtHrs;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param n3ptyInvRvisSeq
	 */
	public void setN3ptyInvRvisSeq(String n3ptyInvRvisSeq) {
		this.n3ptyInvRvisSeq = n3ptyInvRvisSeq;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
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
	 * @param newSealNo
	 */
	public void setNewSealNo(String newSealNo) {
		this.newSealNo = newSealNo;
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
	 * @param estmRvisNo
	 */
	public void setEstmRvisNo(String estmRvisNo) {
		this.estmRvisNo = estmRvisNo;
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
	 * @param revAmt
	 */
	public void setRevAmt(String revAmt) {
		this.revAmt = revAmt;
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
	 * @param n3ptyInvStsCd
	 */
	public void setN3ptyInvStsCd(String n3ptyInvStsCd) {
		this.n3ptyInvStsCd = n3ptyInvStsCd;
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
	 * @param vndrCustNm
	 */
	public void setVndrCustNm(String vndrCustNm) {
		this.vndrCustNm = vndrCustNm;
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
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
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
	 * @param outErpifCreditnoteSeq
	 */
	public void setOutErpifCreditnoteSeq(String outErpifCreditnoteSeq) {
		this.outErpifCreditnoteSeq = outErpifCreditnoteSeq;
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
	 * @param bilTpCd
	 */
	public void setBilTpCd(String bilTpCd) {
		this.bilTpCd = bilTpCd;
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
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
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
	 * @param citationNo
	 */
	public void setCitationNo(String citationNo) {
		this.citationNo = citationNo;
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
	 * @param ftOvrDys
	 */
	public void setFtOvrDys(String ftOvrDys) {
		this.ftOvrDys = ftOvrDys;
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
	 * @param n3ptyBilTpCd
	 */
	public void setN3ptyBilTpCd(String n3ptyBilTpCd) {
		this.n3ptyBilTpCd = n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @param vatXchRt
	 */
	public void setVatXchRt(String vatXchRt) {
		this.vatXchRt = vatXchRt;
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
	 * @param outErpifRvisCd
	 */
	public void setOutErpifRvisCd(String outErpifRvisCd) {
		this.outErpifRvisCd = outErpifRvisCd;
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
	 * @param n3ptyIfTpCd
	 */
	public void setN3ptyIfTpCd(String n3ptyIfTpCd) {
		this.n3ptyIfTpCd = n3ptyIfTpCd;
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
	 * @param newBkgAll
	 */
	public void setNewBkgAll(String newBkgAll) {
		this.newBkgAll = newBkgAll;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param revVvd
	 */
	public void setRevVvd(String revVvd) {
		this.revVvd = revVvd;
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
	 * @param sRhqCd
	 */
	public void setSRhqCd(String sRhqCd) {
		this.sRhqCd = sRhqCd;
	}
	
	/**
	 * Column Info
	 * @param lengthRevVvd
	 */
	public void setLengthRevVvd(String lengthRevVvd) {
		this.lengthRevVvd = lengthRevVvd;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param vndrCustEml
	 */
	public void setVndrCustEml(String vndrCustEml) {
		this.vndrCustEml = vndrCustEml;
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
	 * @param trdParty
	 */
	public void setTrdParty(String trdParty) {
		this.trdParty = trdParty;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param lengthCurrCd
	 */
	public void setLengthCurrCd(String lengthCurrCd) {
		this.lengthCurrCd = lengthCurrCd;
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
	 * @param outErpifCreditnoteCd
	 */
	public void setOutErpifCreditnoteCd(String outErpifCreditnoteCd) {
		this.outErpifCreditnoteCd = outErpifCreditnoteCd;
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
	 * @param vatDtlAmt
	 */
	public void setVatDtlAmt(String vatDtlAmt) {
		this.vatDtlAmt = vatDtlAmt;
	}
	
	/**
	 * Column Info
	 * @param lstFreeDt
	 */
	public void setLstFreeDt(String lstFreeDt) {
		this.lstFreeDt = lstFreeDt;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setN3ptyExpnTpCd(JSPUtil.getParameter(request, "n3pty_expn_tp_cd", ""));
		setUsrInpCtnt1(JSPUtil.getParameter(request, "usr_inp_ctnt1", ""));
		setEstmSvrId(JSPUtil.getParameter(request, "estm_svr_id", ""));
		setSCltAgnRmk(JSPUtil.getParameter(request, "s_clt_agn_rmk", ""));
		setSheetSetCount(JSPUtil.getParameter(request, "sheet_set_count", ""));
		setInvDtlAmt(JSPUtil.getParameter(request, "inv_dtl_amt", ""));
		setVatXchRtOriginal(JSPUtil.getParameter(request, "vat_xch_rt_original", ""));
		setN3ptyBilTpNm(JSPUtil.getParameter(request, "n3pty_bil_tp_nm", ""));
		setUsrInpCtnt2(JSPUtil.getParameter(request, "usr_inp_ctnt2", ""));
		setMgsetNo(JSPUtil.getParameter(request, "mgset_no", ""));
		setOrgCltAgnFlg(JSPUtil.getParameter(request, "org_clt_agn_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSUsrInpCtnt2(JSPUtil.getParameter(request, "s_usr_inp_ctnt2", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setSUsrInpCtnt1(JSPUtil.getParameter(request, "s_usr_inp_ctnt1", ""));
		setEdate(JSPUtil.getParameter(request, "edate", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setSN3ptyInvHisSeq(JSPUtil.getParameter(request, "s_n3pty_inv_his_seq", ""));
		setEngAddr(JSPUtil.getParameter(request, "eng_addr", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setSVatAmt(JSPUtil.getParameter(request, "s_vat_amt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setSAddr(JSPUtil.getParameter(request, "s_addr", ""));
		setOrgDueDate(JSPUtil.getParameter(request, "org_due_date", ""));
		setPkupDt(JSPUtil.getParameter(request, "pkup_dt", ""));
		setN3ptyInvNoTmp(JSPUtil.getParameter(request, "n3pty_inv_no_tmp", ""));
		setDelSucess(JSPUtil.getParameter(request, "del_sucess", ""));
		setSSumInvAmt(JSPUtil.getParameter(request, "s_sum_inv_amt", ""));
		setSTotalAmt(JSPUtil.getParameter(request, "s_total_amt", ""));
		setSDdctAmt(JSPUtil.getParameter(request, "s_ddct_amt", ""));
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setNewCreditnoteSeq(JSPUtil.getParameter(request, "new_creditnote_seq", ""));
		setSVndrCustAddr2(JSPUtil.getParameter(request, "s_vndr_cust_addr2", ""));
		setTotHighEduTax(JSPUtil.getParameter(request, "tot_high_edu_tax", ""));
		setOrgVndrCustAddr(JSPUtil.getParameter(request, "org_vndr_cust_addr", ""));
		setSSteCd(JSPUtil.getParameter(request, "s_ste_cd", ""));
		setFincDirCd(JSPUtil.getParameter(request, "finc_dir_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setDorNodCd(JSPUtil.getParameter(request, "dor_nod_cd", ""));
		setN3ptyInvRmdNm(JSPUtil.getParameter(request, "n3pty_inv_rmd_nm", ""));
		setSN3ptyInvRmdYn(JSPUtil.getParameter(request, "s_n3pty_inv_rmd_yn", ""));
		setBkgNoAll(JSPUtil.getParameter(request, "bkg_no_all", ""));
		setSN3ptyNo(JSPUtil.getParameter(request, "s_n3pty_no", ""));
		setSVatXchRt(JSPUtil.getParameter(request, "s_vat_xch_rt", ""));
		setSVndrSeq(JSPUtil.getParameter(request, "s_vndr_seq", ""));
		setSSheetSetCount(JSPUtil.getParameter(request, "s_sheet_set_count", ""));
		setSCtyNm(JSPUtil.getParameter(request, "s_cty_nm", ""));
		setVndrCustAddr2(JSPUtil.getParameter(request, "vndr_cust_addr2", ""));
		setSN3ptyInvRvisCd(JSPUtil.getParameter(request, "s_n3pty_inv_rvis_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setSRhqCdForRhq(JSPUtil.getParameter(request, "s_rhq_cd_for_rhq", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setLgsCostCd(JSPUtil.getParameter(request, "lgs_cost_cd", ""));
		setViaNodCd(JSPUtil.getParameter(request, "via_nod_cd", ""));
		setSRgstNo(JSPUtil.getParameter(request, "s_rgst_no", ""));
		setOccrDt(JSPUtil.getParameter(request, "occr_dt", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setNewVvd(JSPUtil.getParameter(request, "new_vvd", ""));
		setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
		setSvcCateRmk(JSPUtil.getParameter(request, "svc_cate_rmk", ""));
		setPmntAcctNo(JSPUtil.getParameter(request, "pmnt_acct_no", ""));
		setToNodCd(JSPUtil.getParameter(request, "to_nod_cd", ""));
		setGlDt(JSPUtil.getParameter(request, "gl_dt", ""));
		setSCustSeq(JSPUtil.getParameter(request, "s_cust_seq", ""));
		setAddAmt(JSPUtil.getParameter(request, "add_amt", ""));
		setSTrdPartyVal(JSPUtil.getParameter(request, "s_trd_party_val", ""));
		setSCurrCd(JSPUtil.getParameter(request, "s_curr_cd", ""));
		setLastFreeDt(JSPUtil.getParameter(request, "last_free_dt", ""));
		setOtsDtlSeq(JSPUtil.getParameter(request, "ots_dtl_seq", ""));
		setSVndrCustEml(JSPUtil.getParameter(request, "s_vndr_cust_eml", ""));
		setN3ptyInvNo(JSPUtil.getParameter(request, "n3pty_inv_no", ""));
		setOriginalInvDtlAmt(JSPUtil.getParameter(request, "original_inv_dtl_amt", ""));
		setLengthN3ptyBilTpCd(JSPUtil.getParameter(request, "length_n3pty_bil_tp_cd", ""));
		setSInquiryonlyYn(JSPUtil.getParameter(request, "s_inquiryonly_yn", ""));
		setSN3ptyInvRmdCd(JSPUtil.getParameter(request, "s_n3pty_inv_rmd_cd", ""));
		setUserName(JSPUtil.getParameter(request, "user_name", ""));
		setSN3ptyInvStsCd(JSPUtil.getParameter(request, "s_n3pty_inv_sts_cd", ""));
		setLengthTrdParty(JSPUtil.getParameter(request, "length_trd_party", ""));
		setSoNo(JSPUtil.getParameter(request, "so_no", ""));
		setSInvDesc(JSPUtil.getParameter(request, "s_inv_desc", ""));
		setSVndrCustAddr(JSPUtil.getParameter(request, "s_vndr_cust_addr", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSFinalFlgCheckbox(JSPUtil.getParameter(request, "s_final_flg_checkbox", ""));
		setDamageDt(JSPUtil.getParameter(request, "damage_dt", ""));
		setSDaoN3ptyNo(JSPUtil.getParameter(request, "s_dao_n3pty_no", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setSInvoiceCancelRemark(JSPUtil.getParameter(request, "s_invoice_cancel_remark", ""));
		setPickUpDt(JSPUtil.getParameter(request, "pick_up_dt", ""));
		setWeight(JSPUtil.getParameter(request, "weight", ""));
		setOverDay(JSPUtil.getParameter(request, "over_day", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUserEmail(JSPUtil.getParameter(request, "user_email", ""));
		setTotalAmt(JSPUtil.getParameter(request, "total_amt", ""));
		setTaxRgstNo(JSPUtil.getParameter(request, "tax_rgst_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUom(JSPUtil.getParameter(request, "uom", ""));
		setSZipCd(JSPUtil.getParameter(request, "s_zip_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setEstmSeqNo(JSPUtil.getParameter(request, "estm_seq_no", ""));
		setWaitingTm(JSPUtil.getParameter(request, "waiting_tm", ""));
		setLengthN3ptyExpnTpCd(JSPUtil.getParameter(request, "length_n3pty_expn_tp_cd", ""));
		setVndrCustRefRmk(JSPUtil.getParameter(request, "vndr_cust_ref_rmk", ""));
		setIndiataxform(JSPUtil.getParameter(request, "indiataxform", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setOutErpifRvisSeq(JSPUtil.getParameter(request, "out_erpif_rvis_seq", ""));
		setOrgSteCd(JSPUtil.getParameter(request, "org_ste_cd", ""));
		setSRch(JSPUtil.getParameter(request, "s_rch", ""));
		setSVndrCustNm(JSPUtil.getParameter(request, "s_vndr_cust_nm", ""));
		setIdaTaxSeq(JSPUtil.getParameter(request, "ida_tax_seq", ""));
		setEqKndNm(JSPUtil.getParameter(request, "eq_knd_nm", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setSTrdPartyNm(JSPUtil.getParameter(request, "s_trd_party_nm", ""));
		setNewRvisCd(JSPUtil.getParameter(request, "new_rvis_cd", ""));
		setSFrance(JSPUtil.getParameter(request, "s_france", ""));
		setVndrCustAddr(JSPUtil.getParameter(request, "vndr_cust_addr", ""));
		setWtHrs(JSPUtil.getParameter(request, "wt_hrs", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setOrgCtyNm(JSPUtil.getParameter(request, "org_cty_nm", ""));
		setSoIfSeq(JSPUtil.getParameter(request, "so_if_seq", ""));
		setSRcvDueDt(JSPUtil.getParameter(request, "s_rcv_due_dt", ""));
		setSLengthN3ptyBilTpCd(JSPUtil.getParameter(request, "s_length_n3pty_bil_tp_cd", ""));
		setN3ptyInvRvisSeq(JSPUtil.getParameter(request, "n3pty_inv_rvis_seq", ""));
		setSFaxNo(JSPUtil.getParameter(request, "s_fax_no", ""));
		setBlNoAll(JSPUtil.getParameter(request, "bl_no_all", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setValidYnCorrection(JSPUtil.getParameter(request, "valid_yn_correction", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setSDetailOtsStsCd(JSPUtil.getParameter(request, "s_detail_ots_sts_cd", ""));
		setNewVslCd(JSPUtil.getParameter(request, "new_vsl_cd", ""));
		setSVndrCustDivCd(JSPUtil.getParameter(request, "s_vndr_cust_div_cd", ""));
		setEduTax(JSPUtil.getParameter(request, "edu_tax", ""));
		setNewSealNo(JSPUtil.getParameter(request, "new_seal_no", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setEstmRvisNo(JSPUtil.getParameter(request, "estm_rvis_no", ""));
		setZipCd(JSPUtil.getParameter(request, "zip_cd", ""));
		setSTrdPartyCode(JSPUtil.getParameter(request, "s_trd_party_code", ""));
		setRevAmt(JSPUtil.getParameter(request, "rev_amt", ""));
		setSHVndrCustDivCd(JSPUtil.getParameter(request, "s_h_vndr_cust_div_cd", ""));
		setRgstNo(JSPUtil.getParameter(request, "rgst_no", ""));
		setOtsStsCd(JSPUtil.getParameter(request, "ots_sts_cd", ""));
		setOrgZipCd(JSPUtil.getParameter(request, "org_zip_cd", ""));
		setExpnTax(JSPUtil.getParameter(request, "expn_tax", ""));
		setSameVersionYn(JSPUtil.getParameter(request, "same_version_yn", ""));
		setN3ptyInvStsCd(JSPUtil.getParameter(request, "n3pty_inv_sts_cd", ""));
		setSCltAgnFlg(JSPUtil.getParameter(request, "s_clt_agn_flg", ""));
		setVndrCustNm(JSPUtil.getParameter(request, "vndr_cust_nm", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setSN3ptyInvNo(JSPUtil.getParameter(request, "s_n3pty_inv_no", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setNewRvisSeq(JSPUtil.getParameter(request, "new_rvis_seq", ""));
		setOrgUsrInpCtnt2(JSPUtil.getParameter(request, "org_usr_inp_ctnt2", ""));
		setCitaNo(JSPUtil.getParameter(request, "cita_no", ""));
		setOrgUsrInpCtnt1(JSPUtil.getParameter(request, "org_usr_inp_ctnt1", ""));
		setOutErpifCreditnoteSeq(JSPUtil.getParameter(request, "out_erpif_creditnote_seq", ""));
		setTotSvcTax(JSPUtil.getParameter(request, "tot_svc_tax", ""));
		setRepairLocation(JSPUtil.getParameter(request, "repair_location", ""));
		setHighEduTax(JSPUtil.getParameter(request, "high_edu_tax", ""));
		setFmNodCd(JSPUtil.getParameter(request, "fm_nod_cd", ""));
		setVatAmt(JSPUtil.getParameter(request, "vat_amt", ""));
		setOrgTotAmt(JSPUtil.getParameter(request, "org_tot_amt", ""));
		setSDetailN3ptyNo(JSPUtil.getParameter(request, "s_detail_n3pty_no", ""));
		setBilTpCd(JSPUtil.getParameter(request, "bil_tp_cd", ""));
		setRoute(JSPUtil.getParameter(request, "route", ""));
		setRcvDueDt(JSPUtil.getParameter(request, "rcv_due_dt", ""));
		setN3ptyInvRmdYn(JSPUtil.getParameter(request, "n3pty_inv_rmd_yn", ""));
		setOrgInvDesc(JSPUtil.getParameter(request, "org_inv_desc", ""));
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSVatXchRtChk(JSPUtil.getParameter(request, "s_vat_xch_rt_chk", ""));
		setSHisSeq(JSPUtil.getParameter(request, "s_his_seq", ""));
		setTrdPartyCode(JSPUtil.getParameter(request, "trd_party_code", ""));
		setN3ptyCntrWgtUtCd(JSPUtil.getParameter(request, "n3pty_cntr_wgt_ut_cd", ""));
		setNewCreditnoteCd(JSPUtil.getParameter(request, "new_creditnote_cd", ""));
		setSFinalFlg(JSPUtil.getParameter(request, "s_final_flg", ""));
		setCitationNo(JSPUtil.getParameter(request, "citation_no", ""));
		setOrgDdctAmt(JSPUtil.getParameter(request, "org_ddct_amt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setFtOvrDys(JSPUtil.getParameter(request, "ft_ovr_dys", ""));
		setSCorrectionYn(JSPUtil.getParameter(request, "s_correction_yn", ""));
		setN3ptyBilTpCd(JSPUtil.getParameter(request, "n3pty_bil_tp_cd", ""));
		setVatXchRt(JSPUtil.getParameter(request, "vat_xch_rt", ""));
		setNetAmt(JSPUtil.getParameter(request, "net_amt", ""));
		setSPhnNo(JSPUtil.getParameter(request, "s_phn_no", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setOutErpifRvisCd(JSPUtil.getParameter(request, "out_erpif_rvis_cd", ""));
		setTotExpnTax(JSPUtil.getParameter(request, "tot_expn_tax", ""));
		setSInvRmk2(JSPUtil.getParameter(request, "s_inv_rmk2", ""));
		setOrgVndrCustRefRmk(JSPUtil.getParameter(request, "org_vndr_cust_ref_rmk", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setSSameVersionYn(JSPUtil.getParameter(request, "s_same_version_yn", ""));
		setN3ptyIfTpCd(JSPUtil.getParameter(request, "n3pty_if_tp_cd", ""));
		setSVndrCustRefRmk(JSPUtil.getParameter(request, "s_vndr_cust_ref_rmk", ""));
		setSBilLoc(JSPUtil.getParameter(request, "s_bil_loc", ""));
		setSCustCntCd(JSPUtil.getParameter(request, "s_cust_cnt_cd", ""));
		setNewCntrSealNo(JSPUtil.getParameter(request, "new_cntr_seal_no", ""));
		setNewBkgAll(JSPUtil.getParameter(request, "new_bkg_all", ""));
		setNewEqNo(JSPUtil.getParameter(request, "new_eq_no", ""));
		setSDaoN3ptyBilTpCd(JSPUtil.getParameter(request, "s_dao_n3pty_bil_tp_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setOtsAmt(JSPUtil.getParameter(request, "ots_amt", ""));
		setSFromCurrCd(JSPUtil.getParameter(request, "s_from_curr_cd", ""));
		setSdate(JSPUtil.getParameter(request, "sdate", ""));
		setRevVvd(JSPUtil.getParameter(request, "rev_vvd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setSAddAmt(JSPUtil.getParameter(request, "s_add_amt", ""));
		setSVndrCntCd(JSPUtil.getParameter(request, "s_vndr_cnt_cd", ""));
		setTotEduTax(JSPUtil.getParameter(request, "tot_edu_tax", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setSN3ptyOfcCd(JSPUtil.getParameter(request, "s_n3pty_ofc_cd", ""));
		setOrgAdmChrg(JSPUtil.getParameter(request, "org_adm_chrg", ""));
		setSRhqCd(JSPUtil.getParameter(request, "s_rhq_cd", ""));
		setLengthRevVvd(JSPUtil.getParameter(request, "length_rev_vvd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setSN3ptyInvRmdNm(JSPUtil.getParameter(request, "s_n3pty_inv_rmd_nm", ""));
		setVndrCustEml(JSPUtil.getParameter(request, "vndr_cust_eml", ""));
		setNewBkgNo(JSPUtil.getParameter(request, "new_bkg_no", ""));
		setSInvRmk1(JSPUtil.getParameter(request, "s_inv_rmk1", ""));
		setSIdaTaxSeq(JSPUtil.getParameter(request, "s_ida_tax_seq", ""));
		setTrdParty(JSPUtil.getParameter(request, "trd_party", ""));
		setBilToLocDivCd(JSPUtil.getParameter(request, "bil_to_loc_div_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setLengthCurrCd(JSPUtil.getParameter(request, "length_curr_cd", ""));
		setSNetAmt(JSPUtil.getParameter(request, "s_net_amt", ""));
		setOutErpifCreditnoteCd(JSPUtil.getParameter(request, "out_erpif_creditnote_cd", ""));
		setSN3ptyInvRvisSeq(JSPUtil.getParameter(request, "s_n3pty_inv_rvis_seq", ""));
		setSInvIssRhqCd(JSPUtil.getParameter(request, "s_inv_iss_rhq_cd", ""));
		setVatDtlAmt(JSPUtil.getParameter(request, "vat_dtl_amt", ""));
		setLstFreeDt(JSPUtil.getParameter(request, "lst_free_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceCreationVO[]
	 */
	public InvoiceCreationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceCreationVO[]
	 */
	public InvoiceCreationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceCreationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n3ptyExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_expn_tp_cd", length));
			String[] usrInpCtnt1 = (JSPUtil.getParameter(request, prefix	+ "usr_inp_ctnt1", length));
			String[] estmSvrId = (JSPUtil.getParameter(request, prefix	+ "estm_svr_id", length));
			String[] sCltAgnRmk = (JSPUtil.getParameter(request, prefix	+ "s_clt_agn_rmk", length));
			String[] sheetSetCount = (JSPUtil.getParameter(request, prefix	+ "sheet_set_count", length));
			String[] invDtlAmt = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_amt", length));
			String[] vatXchRtOriginal = (JSPUtil.getParameter(request, prefix	+ "vat_xch_rt_original", length));
			String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_nm", length));
			String[] usrInpCtnt2 = (JSPUtil.getParameter(request, prefix	+ "usr_inp_ctnt2", length));
			String[] mgsetNo = (JSPUtil.getParameter(request, prefix	+ "mgset_no", length));
			String[] orgCltAgnFlg = (JSPUtil.getParameter(request, prefix	+ "org_clt_agn_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sUsrInpCtnt2 = (JSPUtil.getParameter(request, prefix	+ "s_usr_inp_ctnt2", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] sUsrInpCtnt1 = (JSPUtil.getParameter(request, prefix	+ "s_usr_inp_ctnt1", length));
			String[] edate = (JSPUtil.getParameter(request, prefix	+ "edate", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] sN3ptyInvHisSeq = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_his_seq", length));
			String[] engAddr = (JSPUtil.getParameter(request, prefix	+ "eng_addr", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] sVatAmt = (JSPUtil.getParameter(request, prefix	+ "s_vat_amt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] sAddr = (JSPUtil.getParameter(request, prefix	+ "s_addr", length));
			String[] orgDueDate = (JSPUtil.getParameter(request, prefix	+ "org_due_date", length));
			String[] pkupDt = (JSPUtil.getParameter(request, prefix	+ "pkup_dt", length));
			String[] n3ptyInvNoTmp = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_no_tmp", length));
			String[] delSucess = (JSPUtil.getParameter(request, prefix	+ "del_sucess", length));
			String[] sSumInvAmt = (JSPUtil.getParameter(request, prefix	+ "s_sum_inv_amt", length));
			String[] sTotalAmt = (JSPUtil.getParameter(request, prefix	+ "s_total_amt", length));
			String[] sDdctAmt = (JSPUtil.getParameter(request, prefix	+ "s_ddct_amt", length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] newCreditnoteSeq = (JSPUtil.getParameter(request, prefix	+ "new_creditnote_seq", length));
			String[] sVndrCustAddr2 = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_addr2", length));
			String[] totHighEduTax = (JSPUtil.getParameter(request, prefix	+ "tot_high_edu_tax", length));
			String[] orgVndrCustAddr = (JSPUtil.getParameter(request, prefix	+ "org_vndr_cust_addr", length));
			String[] sSteCd = (JSPUtil.getParameter(request, prefix	+ "s_ste_cd", length));
			String[] fincDirCd = (JSPUtil.getParameter(request, prefix	+ "finc_dir_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] n3ptyInvRmdNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_rmd_nm", length));
			String[] sN3ptyInvRmdYn = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_rmd_yn", length));
			String[] bkgNoAll = (JSPUtil.getParameter(request, prefix	+ "bkg_no_all", length));
			String[] sN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no", length));
			String[] sVatXchRt = (JSPUtil.getParameter(request, prefix	+ "s_vat_xch_rt", length));
			String[] sVndrSeq = (JSPUtil.getParameter(request, prefix	+ "s_vndr_seq", length));
			String[] sSheetSetCount = (JSPUtil.getParameter(request, prefix	+ "s_sheet_set_count", length));
			String[] sCtyNm = (JSPUtil.getParameter(request, prefix	+ "s_cty_nm", length));
			String[] vndrCustAddr2 = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_addr2", length));
			String[] sN3ptyInvRvisCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_rvis_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] sRhqCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_rhq_cd_for_rhq", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] sRgstNo = (JSPUtil.getParameter(request, prefix	+ "s_rgst_no", length));
			String[] occrDt = (JSPUtil.getParameter(request, prefix	+ "occr_dt", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] newVvd = (JSPUtil.getParameter(request, prefix	+ "new_vvd", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] svcCateRmk = (JSPUtil.getParameter(request, prefix	+ "svc_cate_rmk", length));
			String[] pmntAcctNo = (JSPUtil.getParameter(request, prefix	+ "pmnt_acct_no", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] sCustSeq = (JSPUtil.getParameter(request, prefix	+ "s_cust_seq", length));
			String[] addAmt = (JSPUtil.getParameter(request, prefix	+ "add_amt", length));
			String[] sTrdPartyVal = (JSPUtil.getParameter(request, prefix	+ "s_trd_party_val", length));
			String[] sCurrCd = (JSPUtil.getParameter(request, prefix	+ "s_curr_cd", length));
			String[] lastFreeDt = (JSPUtil.getParameter(request, prefix	+ "last_free_dt", length));
			String[] otsDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ots_dtl_seq", length));
			String[] sVndrCustEml = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_eml", length));
			String[] n3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_no", length));
			String[] originalInvDtlAmt = (JSPUtil.getParameter(request, prefix	+ "original_inv_dtl_amt", length));
			String[] lengthN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "length_n3pty_bil_tp_cd", length));
			String[] sInquiryonlyYn = (JSPUtil.getParameter(request, prefix	+ "s_inquiryonly_yn", length));
			String[] sN3ptyInvRmdCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_rmd_cd", length));
			String[] userName = (JSPUtil.getParameter(request, prefix	+ "user_name", length));
			String[] sN3ptyInvStsCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_sts_cd", length));
			String[] lengthTrdParty = (JSPUtil.getParameter(request, prefix	+ "length_trd_party", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] sInvDesc = (JSPUtil.getParameter(request, prefix	+ "s_inv_desc", length));
			String[] sVndrCustAddr = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_addr", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sFinalFlgCheckbox = (JSPUtil.getParameter(request, prefix	+ "s_final_flg_checkbox", length));
			String[] damageDt = (JSPUtil.getParameter(request, prefix	+ "damage_dt", length));
			String[] sDaoN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_dao_n3pty_no", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] sInvoiceCancelRemark = (JSPUtil.getParameter(request, prefix	+ "s_invoice_cancel_remark", length));
			String[] pickUpDt = (JSPUtil.getParameter(request, prefix	+ "pick_up_dt", length));
			String[] weight = (JSPUtil.getParameter(request, prefix	+ "weight", length));
			String[] overDay = (JSPUtil.getParameter(request, prefix	+ "over_day", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] userEmail = (JSPUtil.getParameter(request, prefix	+ "user_email", length));
			String[] totalAmt = (JSPUtil.getParameter(request, prefix	+ "total_amt", length));
			String[] taxRgstNo = (JSPUtil.getParameter(request, prefix	+ "tax_rgst_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] uom = (JSPUtil.getParameter(request, prefix	+ "uom", length));
			String[] sZipCd = (JSPUtil.getParameter(request, prefix	+ "s_zip_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] estmSeqNo = (JSPUtil.getParameter(request, prefix	+ "estm_seq_no", length));
			String[] waitingTm = (JSPUtil.getParameter(request, prefix	+ "waiting_tm", length));
			String[] lengthN3ptyExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "length_n3pty_expn_tp_cd", length));
			String[] vndrCustRefRmk = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_ref_rmk", length));
			String[] indiataxform = (JSPUtil.getParameter(request, prefix	+ "indiataxform", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] outErpifRvisSeq = (JSPUtil.getParameter(request, prefix	+ "out_erpif_rvis_seq", length));
			String[] orgSteCd = (JSPUtil.getParameter(request, prefix	+ "org_ste_cd", length));
			String[] sRch = (JSPUtil.getParameter(request, prefix	+ "s_rch", length));
			String[] sVndrCustNm = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_nm", length));
			String[] idaTaxSeq = (JSPUtil.getParameter(request, prefix	+ "ida_tax_seq", length));
			String[] eqKndNm = (JSPUtil.getParameter(request, prefix	+ "eq_knd_nm", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] sTrdPartyNm = (JSPUtil.getParameter(request, prefix	+ "s_trd_party_nm", length));
			String[] newRvisCd = (JSPUtil.getParameter(request, prefix	+ "new_rvis_cd", length));
			String[] sFrance = (JSPUtil.getParameter(request, prefix	+ "s_france", length));
			String[] vndrCustAddr = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_addr", length));
			String[] wtHrs = (JSPUtil.getParameter(request, prefix	+ "wt_hrs", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] orgCtyNm = (JSPUtil.getParameter(request, prefix	+ "org_cty_nm", length));
			String[] soIfSeq = (JSPUtil.getParameter(request, prefix	+ "so_if_seq", length));
			String[] sRcvDueDt = (JSPUtil.getParameter(request, prefix	+ "s_rcv_due_dt", length));
			String[] sLengthN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "s_length_n3pty_bil_tp_cd", length));
			String[] n3ptyInvRvisSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_rvis_seq", length));
			String[] sFaxNo = (JSPUtil.getParameter(request, prefix	+ "s_fax_no", length));
			String[] blNoAll = (JSPUtil.getParameter(request, prefix	+ "bl_no_all", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] validYnCorrection = (JSPUtil.getParameter(request, prefix	+ "valid_yn_correction", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] sDetailOtsStsCd = (JSPUtil.getParameter(request, prefix	+ "s_detail_ots_sts_cd", length));
			String[] newVslCd = (JSPUtil.getParameter(request, prefix	+ "new_vsl_cd", length));
			String[] sVndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_div_cd", length));
			String[] eduTax = (JSPUtil.getParameter(request, prefix	+ "edu_tax", length));
			String[] newSealNo = (JSPUtil.getParameter(request, prefix	+ "new_seal_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] estmRvisNo = (JSPUtil.getParameter(request, prefix	+ "estm_rvis_no", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] sTrdPartyCode = (JSPUtil.getParameter(request, prefix	+ "s_trd_party_code", length));
			String[] revAmt = (JSPUtil.getParameter(request, prefix	+ "rev_amt", length));
			String[] sHVndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "s_h_vndr_cust_div_cd", length));
			String[] rgstNo = (JSPUtil.getParameter(request, prefix	+ "rgst_no", length));
			String[] otsStsCd = (JSPUtil.getParameter(request, prefix	+ "ots_sts_cd", length));
			String[] orgZipCd = (JSPUtil.getParameter(request, prefix	+ "org_zip_cd", length));
			String[] expnTax = (JSPUtil.getParameter(request, prefix	+ "expn_tax", length));
			String[] sameVersionYn = (JSPUtil.getParameter(request, prefix	+ "same_version_yn", length));
			String[] n3ptyInvStsCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_sts_cd", length));
			String[] sCltAgnFlg = (JSPUtil.getParameter(request, prefix	+ "s_clt_agn_flg", length));
			String[] vndrCustNm = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_nm", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] sN3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_no", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] newRvisSeq = (JSPUtil.getParameter(request, prefix	+ "new_rvis_seq", length));
			String[] orgUsrInpCtnt2 = (JSPUtil.getParameter(request, prefix	+ "org_usr_inp_ctnt2", length));
			String[] citaNo = (JSPUtil.getParameter(request, prefix	+ "cita_no", length));
			String[] orgUsrInpCtnt1 = (JSPUtil.getParameter(request, prefix	+ "org_usr_inp_ctnt1", length));
			String[] outErpifCreditnoteSeq = (JSPUtil.getParameter(request, prefix	+ "out_erpif_creditnote_seq", length));
			String[] totSvcTax = (JSPUtil.getParameter(request, prefix	+ "tot_svc_tax", length));
			String[] repairLocation = (JSPUtil.getParameter(request, prefix	+ "repair_location", length));
			String[] highEduTax = (JSPUtil.getParameter(request, prefix	+ "high_edu_tax", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] vatAmt = (JSPUtil.getParameter(request, prefix	+ "vat_amt", length));
			String[] orgTotAmt = (JSPUtil.getParameter(request, prefix	+ "org_tot_amt", length));
			String[] sDetailN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_detail_n3pty_no", length));
			String[] bilTpCd = (JSPUtil.getParameter(request, prefix	+ "bil_tp_cd", length));
			String[] route = (JSPUtil.getParameter(request, prefix	+ "route", length));
			String[] rcvDueDt = (JSPUtil.getParameter(request, prefix	+ "rcv_due_dt", length));
			String[] n3ptyInvRmdYn = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_rmd_yn", length));
			String[] orgInvDesc = (JSPUtil.getParameter(request, prefix	+ "org_inv_desc", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] sVatXchRtChk = (JSPUtil.getParameter(request, prefix	+ "s_vat_xch_rt_chk", length));
			String[] sHisSeq = (JSPUtil.getParameter(request, prefix	+ "s_his_seq", length));
			String[] trdPartyCode = (JSPUtil.getParameter(request, prefix	+ "trd_party_code", length));
			String[] n3ptyCntrWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_cntr_wgt_ut_cd", length));
			String[] newCreditnoteCd = (JSPUtil.getParameter(request, prefix	+ "new_creditnote_cd", length));
			String[] sFinalFlg = (JSPUtil.getParameter(request, prefix	+ "s_final_flg", length));
			String[] citationNo = (JSPUtil.getParameter(request, prefix	+ "citation_no", length));
			String[] orgDdctAmt = (JSPUtil.getParameter(request, prefix	+ "org_ddct_amt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ftOvrDys = (JSPUtil.getParameter(request, prefix	+ "ft_ovr_dys", length));
			String[] sCorrectionYn = (JSPUtil.getParameter(request, prefix	+ "s_correction_yn", length));
			String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd", length));
			String[] vatXchRt = (JSPUtil.getParameter(request, prefix	+ "vat_xch_rt", length));
			String[] netAmt = (JSPUtil.getParameter(request, prefix	+ "net_amt", length));
			String[] sPhnNo = (JSPUtil.getParameter(request, prefix	+ "s_phn_no", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] outErpifRvisCd = (JSPUtil.getParameter(request, prefix	+ "out_erpif_rvis_cd", length));
			String[] totExpnTax = (JSPUtil.getParameter(request, prefix	+ "tot_expn_tax", length));
			String[] sInvRmk2 = (JSPUtil.getParameter(request, prefix	+ "s_inv_rmk2", length));
			String[] orgVndrCustRefRmk = (JSPUtil.getParameter(request, prefix	+ "org_vndr_cust_ref_rmk", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] sSameVersionYn = (JSPUtil.getParameter(request, prefix	+ "s_same_version_yn", length));
			String[] n3ptyIfTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_if_tp_cd", length));
			String[] sVndrCustRefRmk = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_ref_rmk", length));
			String[] sBilLoc = (JSPUtil.getParameter(request, prefix	+ "s_bil_loc", length));
			String[] sCustCntCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cnt_cd", length));
			String[] newCntrSealNo = (JSPUtil.getParameter(request, prefix	+ "new_cntr_seal_no", length));
			String[] newBkgAll = (JSPUtil.getParameter(request, prefix	+ "new_bkg_all", length));
			String[] newEqNo = (JSPUtil.getParameter(request, prefix	+ "new_eq_no", length));
			String[] sDaoN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "s_dao_n3pty_bil_tp_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] otsAmt = (JSPUtil.getParameter(request, prefix	+ "ots_amt", length));
			String[] sFromCurrCd = (JSPUtil.getParameter(request, prefix	+ "s_from_curr_cd", length));
			String[] sdate = (JSPUtil.getParameter(request, prefix	+ "sdate", length));
			String[] revVvd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] sAddAmt = (JSPUtil.getParameter(request, prefix	+ "s_add_amt", length));
			String[] sVndrCntCd = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cnt_cd", length));
			String[] totEduTax = (JSPUtil.getParameter(request, prefix	+ "tot_edu_tax", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] sN3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_ofc_cd", length));
			String[] orgAdmChrg = (JSPUtil.getParameter(request, prefix	+ "org_adm_chrg", length));
			String[] sRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_cd", length));
			String[] lengthRevVvd = (JSPUtil.getParameter(request, prefix	+ "length_rev_vvd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] sN3ptyInvRmdNm = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_rmd_nm", length));
			String[] vndrCustEml = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_eml", length));
			String[] newBkgNo = (JSPUtil.getParameter(request, prefix	+ "new_bkg_no", length));
			String[] sInvRmk1 = (JSPUtil.getParameter(request, prefix	+ "s_inv_rmk1", length));
			String[] sIdaTaxSeq = (JSPUtil.getParameter(request, prefix	+ "s_ida_tax_seq", length));
			String[] trdParty = (JSPUtil.getParameter(request, prefix	+ "trd_party", length));
			String[] bilToLocDivCd = (JSPUtil.getParameter(request, prefix	+ "bil_to_loc_div_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] lengthCurrCd = (JSPUtil.getParameter(request, prefix	+ "length_curr_cd", length));
			String[] sNetAmt = (JSPUtil.getParameter(request, prefix	+ "s_net_amt", length));
			String[] outErpifCreditnoteCd = (JSPUtil.getParameter(request, prefix	+ "out_erpif_creditnote_cd", length));
			String[] sN3ptyInvRvisSeq = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_rvis_seq", length));
			String[] sInvIssRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_inv_iss_rhq_cd", length));
			String[] vatDtlAmt = (JSPUtil.getParameter(request, prefix	+ "vat_dtl_amt", length));
			String[] lstFreeDt = (JSPUtil.getParameter(request, prefix	+ "lst_free_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceCreationVO();
				if (n3ptyExpnTpCd[i] != null)
					model.setN3ptyExpnTpCd(n3ptyExpnTpCd[i]);
				if (usrInpCtnt1[i] != null)
					model.setUsrInpCtnt1(usrInpCtnt1[i]);
				if (estmSvrId[i] != null)
					model.setEstmSvrId(estmSvrId[i]);
				if (sCltAgnRmk[i] != null)
					model.setSCltAgnRmk(sCltAgnRmk[i]);
				if (sheetSetCount[i] != null)
					model.setSheetSetCount(sheetSetCount[i]);
				if (invDtlAmt[i] != null)
					model.setInvDtlAmt(invDtlAmt[i]);
				if (vatXchRtOriginal[i] != null)
					model.setVatXchRtOriginal(vatXchRtOriginal[i]);
				if (n3ptyBilTpNm[i] != null)
					model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
				if (usrInpCtnt2[i] != null)
					model.setUsrInpCtnt2(usrInpCtnt2[i]);
				if (mgsetNo[i] != null)
					model.setMgsetNo(mgsetNo[i]);
				if (orgCltAgnFlg[i] != null)
					model.setOrgCltAgnFlg(orgCltAgnFlg[i]);
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
				if (engAddr[i] != null)
					model.setEngAddr(engAddr[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (sVatAmt[i] != null)
					model.setSVatAmt(sVatAmt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (sAddr[i] != null)
					model.setSAddr(sAddr[i]);
				if (orgDueDate[i] != null)
					model.setOrgDueDate(orgDueDate[i]);
				if (pkupDt[i] != null)
					model.setPkupDt(pkupDt[i]);
				if (n3ptyInvNoTmp[i] != null)
					model.setN3ptyInvNoTmp(n3ptyInvNoTmp[i]);
				if (delSucess[i] != null)
					model.setDelSucess(delSucess[i]);
				if (sSumInvAmt[i] != null)
					model.setSSumInvAmt(sSumInvAmt[i]);
				if (sTotalAmt[i] != null)
					model.setSTotalAmt(sTotalAmt[i]);
				if (sDdctAmt[i] != null)
					model.setSDdctAmt(sDdctAmt[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (newCreditnoteSeq[i] != null)
					model.setNewCreditnoteSeq(newCreditnoteSeq[i]);
				if (sVndrCustAddr2[i] != null)
					model.setSVndrCustAddr2(sVndrCustAddr2[i]);
				if (totHighEduTax[i] != null)
					model.setTotHighEduTax(totHighEduTax[i]);
				if (orgVndrCustAddr[i] != null)
					model.setOrgVndrCustAddr(orgVndrCustAddr[i]);
				if (sSteCd[i] != null)
					model.setSSteCd(sSteCd[i]);
				if (fincDirCd[i] != null)
					model.setFincDirCd(fincDirCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (n3ptyInvRmdNm[i] != null)
					model.setN3ptyInvRmdNm(n3ptyInvRmdNm[i]);
				if (sN3ptyInvRmdYn[i] != null)
					model.setSN3ptyInvRmdYn(sN3ptyInvRmdYn[i]);
				if (bkgNoAll[i] != null)
					model.setBkgNoAll(bkgNoAll[i]);
				if (sN3ptyNo[i] != null)
					model.setSN3ptyNo(sN3ptyNo[i]);
				if (sVatXchRt[i] != null)
					model.setSVatXchRt(sVatXchRt[i]);
				if (sVndrSeq[i] != null)
					model.setSVndrSeq(sVndrSeq[i]);
				if (sSheetSetCount[i] != null)
					model.setSSheetSetCount(sSheetSetCount[i]);
				if (sCtyNm[i] != null)
					model.setSCtyNm(sCtyNm[i]);
				if (vndrCustAddr2[i] != null)
					model.setVndrCustAddr2(vndrCustAddr2[i]);
				if (sN3ptyInvRvisCd[i] != null)
					model.setSN3ptyInvRvisCd(sN3ptyInvRvisCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (sRhqCdForRhq[i] != null)
					model.setSRhqCdForRhq(sRhqCdForRhq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (sRgstNo[i] != null)
					model.setSRgstNo(sRgstNo[i]);
				if (occrDt[i] != null)
					model.setOccrDt(occrDt[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (newVvd[i] != null)
					model.setNewVvd(newVvd[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (svcCateRmk[i] != null)
					model.setSvcCateRmk(svcCateRmk[i]);
				if (pmntAcctNo[i] != null)
					model.setPmntAcctNo(pmntAcctNo[i]);
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
				if (lastFreeDt[i] != null)
					model.setLastFreeDt(lastFreeDt[i]);
				if (otsDtlSeq[i] != null)
					model.setOtsDtlSeq(otsDtlSeq[i]);
				if (sVndrCustEml[i] != null)
					model.setSVndrCustEml(sVndrCustEml[i]);
				if (n3ptyInvNo[i] != null)
					model.setN3ptyInvNo(n3ptyInvNo[i]);
				if (originalInvDtlAmt[i] != null)
					model.setOriginalInvDtlAmt(originalInvDtlAmt[i]);
				if (lengthN3ptyBilTpCd[i] != null)
					model.setLengthN3ptyBilTpCd(lengthN3ptyBilTpCd[i]);
				if (sInquiryonlyYn[i] != null)
					model.setSInquiryonlyYn(sInquiryonlyYn[i]);
				if (sN3ptyInvRmdCd[i] != null)
					model.setSN3ptyInvRmdCd(sN3ptyInvRmdCd[i]);
				if (userName[i] != null)
					model.setUserName(userName[i]);
				if (sN3ptyInvStsCd[i] != null)
					model.setSN3ptyInvStsCd(sN3ptyInvStsCd[i]);
				if (lengthTrdParty[i] != null)
					model.setLengthTrdParty(lengthTrdParty[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (sInvDesc[i] != null)
					model.setSInvDesc(sInvDesc[i]);
				if (sVndrCustAddr[i] != null)
					model.setSVndrCustAddr(sVndrCustAddr[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sFinalFlgCheckbox[i] != null)
					model.setSFinalFlgCheckbox(sFinalFlgCheckbox[i]);
				if (damageDt[i] != null)
					model.setDamageDt(damageDt[i]);
				if (sDaoN3ptyNo[i] != null)
					model.setSDaoN3ptyNo(sDaoN3ptyNo[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (sInvoiceCancelRemark[i] != null)
					model.setSInvoiceCancelRemark(sInvoiceCancelRemark[i]);
				if (pickUpDt[i] != null)
					model.setPickUpDt(pickUpDt[i]);
				if (weight[i] != null)
					model.setWeight(weight[i]);
				if (overDay[i] != null)
					model.setOverDay(overDay[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (userEmail[i] != null)
					model.setUserEmail(userEmail[i]);
				if (totalAmt[i] != null)
					model.setTotalAmt(totalAmt[i]);
				if (taxRgstNo[i] != null)
					model.setTaxRgstNo(taxRgstNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (uom[i] != null)
					model.setUom(uom[i]);
				if (sZipCd[i] != null)
					model.setSZipCd(sZipCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (estmSeqNo[i] != null)
					model.setEstmSeqNo(estmSeqNo[i]);
				if (waitingTm[i] != null)
					model.setWaitingTm(waitingTm[i]);
				if (lengthN3ptyExpnTpCd[i] != null)
					model.setLengthN3ptyExpnTpCd(lengthN3ptyExpnTpCd[i]);
				if (vndrCustRefRmk[i] != null)
					model.setVndrCustRefRmk(vndrCustRefRmk[i]);
				if (indiataxform[i] != null)
					model.setIndiataxform(indiataxform[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (outErpifRvisSeq[i] != null)
					model.setOutErpifRvisSeq(outErpifRvisSeq[i]);
				if (orgSteCd[i] != null)
					model.setOrgSteCd(orgSteCd[i]);
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
				if (sTrdPartyNm[i] != null)
					model.setSTrdPartyNm(sTrdPartyNm[i]);
				if (newRvisCd[i] != null)
					model.setNewRvisCd(newRvisCd[i]);
				if (sFrance[i] != null)
					model.setSFrance(sFrance[i]);
				if (vndrCustAddr[i] != null)
					model.setVndrCustAddr(vndrCustAddr[i]);
				if (wtHrs[i] != null)
					model.setWtHrs(wtHrs[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (orgCtyNm[i] != null)
					model.setOrgCtyNm(orgCtyNm[i]);
				if (soIfSeq[i] != null)
					model.setSoIfSeq(soIfSeq[i]);
				if (sRcvDueDt[i] != null)
					model.setSRcvDueDt(sRcvDueDt[i]);
				if (sLengthN3ptyBilTpCd[i] != null)
					model.setSLengthN3ptyBilTpCd(sLengthN3ptyBilTpCd[i]);
				if (n3ptyInvRvisSeq[i] != null)
					model.setN3ptyInvRvisSeq(n3ptyInvRvisSeq[i]);
				if (sFaxNo[i] != null)
					model.setSFaxNo(sFaxNo[i]);
				if (blNoAll[i] != null)
					model.setBlNoAll(blNoAll[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (validYnCorrection[i] != null)
					model.setValidYnCorrection(validYnCorrection[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (sDetailOtsStsCd[i] != null)
					model.setSDetailOtsStsCd(sDetailOtsStsCd[i]);
				if (newVslCd[i] != null)
					model.setNewVslCd(newVslCd[i]);
				if (sVndrCustDivCd[i] != null)
					model.setSVndrCustDivCd(sVndrCustDivCd[i]);
				if (eduTax[i] != null)
					model.setEduTax(eduTax[i]);
				if (newSealNo[i] != null)
					model.setNewSealNo(newSealNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (estmRvisNo[i] != null)
					model.setEstmRvisNo(estmRvisNo[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (sTrdPartyCode[i] != null)
					model.setSTrdPartyCode(sTrdPartyCode[i]);
				if (revAmt[i] != null)
					model.setRevAmt(revAmt[i]);
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
				if (n3ptyInvStsCd[i] != null)
					model.setN3ptyInvStsCd(n3ptyInvStsCd[i]);
				if (sCltAgnFlg[i] != null)
					model.setSCltAgnFlg(sCltAgnFlg[i]);
				if (vndrCustNm[i] != null)
					model.setVndrCustNm(vndrCustNm[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (sN3ptyInvNo[i] != null)
					model.setSN3ptyInvNo(sN3ptyInvNo[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (newRvisSeq[i] != null)
					model.setNewRvisSeq(newRvisSeq[i]);
				if (orgUsrInpCtnt2[i] != null)
					model.setOrgUsrInpCtnt2(orgUsrInpCtnt2[i]);
				if (citaNo[i] != null)
					model.setCitaNo(citaNo[i]);
				if (orgUsrInpCtnt1[i] != null)
					model.setOrgUsrInpCtnt1(orgUsrInpCtnt1[i]);
				if (outErpifCreditnoteSeq[i] != null)
					model.setOutErpifCreditnoteSeq(outErpifCreditnoteSeq[i]);
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
				if (bilTpCd[i] != null)
					model.setBilTpCd(bilTpCd[i]);
				if (route[i] != null)
					model.setRoute(route[i]);
				if (rcvDueDt[i] != null)
					model.setRcvDueDt(rcvDueDt[i]);
				if (n3ptyInvRmdYn[i] != null)
					model.setN3ptyInvRmdYn(n3ptyInvRmdYn[i]);
				if (orgInvDesc[i] != null)
					model.setOrgInvDesc(orgInvDesc[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
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
				if (citationNo[i] != null)
					model.setCitationNo(citationNo[i]);
				if (orgDdctAmt[i] != null)
					model.setOrgDdctAmt(orgDdctAmt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ftOvrDys[i] != null)
					model.setFtOvrDys(ftOvrDys[i]);
				if (sCorrectionYn[i] != null)
					model.setSCorrectionYn(sCorrectionYn[i]);
				if (n3ptyBilTpCd[i] != null)
					model.setN3ptyBilTpCd(n3ptyBilTpCd[i]);
				if (vatXchRt[i] != null)
					model.setVatXchRt(vatXchRt[i]);
				if (netAmt[i] != null)
					model.setNetAmt(netAmt[i]);
				if (sPhnNo[i] != null)
					model.setSPhnNo(sPhnNo[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (outErpifRvisCd[i] != null)
					model.setOutErpifRvisCd(outErpifRvisCd[i]);
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
				if (n3ptyIfTpCd[i] != null)
					model.setN3ptyIfTpCd(n3ptyIfTpCd[i]);
				if (sVndrCustRefRmk[i] != null)
					model.setSVndrCustRefRmk(sVndrCustRefRmk[i]);
				if (sBilLoc[i] != null)
					model.setSBilLoc(sBilLoc[i]);
				if (sCustCntCd[i] != null)
					model.setSCustCntCd(sCustCntCd[i]);
				if (newCntrSealNo[i] != null)
					model.setNewCntrSealNo(newCntrSealNo[i]);
				if (newBkgAll[i] != null)
					model.setNewBkgAll(newBkgAll[i]);
				if (newEqNo[i] != null)
					model.setNewEqNo(newEqNo[i]);
				if (sDaoN3ptyBilTpCd[i] != null)
					model.setSDaoN3ptyBilTpCd(sDaoN3ptyBilTpCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (otsAmt[i] != null)
					model.setOtsAmt(otsAmt[i]);
				if (sFromCurrCd[i] != null)
					model.setSFromCurrCd(sFromCurrCd[i]);
				if (sdate[i] != null)
					model.setSdate(sdate[i]);
				if (revVvd[i] != null)
					model.setRevVvd(revVvd[i]);
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
				if (sRhqCd[i] != null)
					model.setSRhqCd(sRhqCd[i]);
				if (lengthRevVvd[i] != null)
					model.setLengthRevVvd(lengthRevVvd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (sN3ptyInvRmdNm[i] != null)
					model.setSN3ptyInvRmdNm(sN3ptyInvRmdNm[i]);
				if (vndrCustEml[i] != null)
					model.setVndrCustEml(vndrCustEml[i]);
				if (newBkgNo[i] != null)
					model.setNewBkgNo(newBkgNo[i]);
				if (sInvRmk1[i] != null)
					model.setSInvRmk1(sInvRmk1[i]);
				if (sIdaTaxSeq[i] != null)
					model.setSIdaTaxSeq(sIdaTaxSeq[i]);
				if (trdParty[i] != null)
					model.setTrdParty(trdParty[i]);
				if (bilToLocDivCd[i] != null)
					model.setBilToLocDivCd(bilToLocDivCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (lengthCurrCd[i] != null)
					model.setLengthCurrCd(lengthCurrCd[i]);
				if (sNetAmt[i] != null)
					model.setSNetAmt(sNetAmt[i]);
				if (outErpifCreditnoteCd[i] != null)
					model.setOutErpifCreditnoteCd(outErpifCreditnoteCd[i]);
				if (sN3ptyInvRvisSeq[i] != null)
					model.setSN3ptyInvRvisSeq(sN3ptyInvRvisSeq[i]);
				if (sInvIssRhqCd[i] != null)
					model.setSInvIssRhqCd(sInvIssRhqCd[i]);
				if (vatDtlAmt[i] != null)
					model.setVatDtlAmt(vatDtlAmt[i]);
				if (lstFreeDt[i] != null)
					model.setLstFreeDt(lstFreeDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceCreationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceCreationVO[]
	 */
	public InvoiceCreationVO[] getInvoiceCreationVOs(){
		InvoiceCreationVO[] vos = (InvoiceCreationVO[])models.toArray(new InvoiceCreationVO[models.size()]);
		return vos;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.n3ptyExpnTpCd = this.n3ptyExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrInpCtnt1 = this.usrInpCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSvrId = this.estmSvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCltAgnRmk = this.sCltAgnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetSetCount = this.sheetSetCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtlAmt = this.invDtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatXchRtOriginal = this.vatXchRtOriginal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpNm = this.n3ptyBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrInpCtnt2 = this.usrInpCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgsetNo = this.mgsetNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCltAgnFlg = this.orgCltAgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUsrInpCtnt2 = this.sUsrInpCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUsrInpCtnt1 = this.sUsrInpCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edate = this.edate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvHisSeq = this.sN3ptyInvHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engAddr = this.engAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVatAmt = this.sVatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAddr = this.sAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDueDate = this.orgDueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupDt = this.pkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvNoTmp = this.n3ptyInvNoTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delSucess = this.delSucess .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSumInvAmt = this.sSumInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTotalAmt = this.sTotalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDdctAmt = this.sDdctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCreditnoteSeq = this.newCreditnoteSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustAddr2 = this.sVndrCustAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totHighEduTax = this.totHighEduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgVndrCustAddr = this.orgVndrCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSteCd = this.sSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincDirCd = this.fincDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvRmdNm = this.n3ptyInvRmdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvRmdYn = this.sN3ptyInvRmdYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoAll = this.bkgNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNo = this.sN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVatXchRt = this.sVatXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrSeq = this.sVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSheetSetCount = this.sSheetSetCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCtyNm = this.sCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustAddr2 = this.vndrCustAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvRvisCd = this.sN3ptyInvRvisCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqCdForRhq = this.sRhqCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRgstNo = this.sRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.occrDt = this.occrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVvd = this.newVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCateRmk = this.svcCateRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pmntAcctNo = this.pmntAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustSeq = this.sCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addAmt = this.addAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdPartyVal = this.sTrdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCurrCd = this.sCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastFreeDt = this.lastFreeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDtlSeq = this.otsDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustEml = this.sVndrCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvNo = this.n3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalInvDtlAmt = this.originalInvDtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lengthN3ptyBilTpCd = this.lengthN3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInquiryonlyYn = this.sInquiryonlyYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvRmdCd = this.sN3ptyInvRmdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userName = this.userName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvStsCd = this.sN3ptyInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lengthTrdParty = this.lengthTrdParty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvDesc = this.sInvDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustAddr = this.sVndrCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFinalFlgCheckbox = this.sFinalFlgCheckbox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.damageDt = this.damageDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDaoN3ptyNo = this.sDaoN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvoiceCancelRemark = this.sInvoiceCancelRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickUpDt = this.pickUpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weight = this.weight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDay = this.overDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userEmail = this.userEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmt = this.totalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxRgstNo = this.taxRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uom = this.uom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sZipCd = this.sZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSeqNo = this.estmSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.waitingTm = this.waitingTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lengthN3ptyExpnTpCd = this.lengthN3ptyExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustRefRmk = this.vndrCustRefRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indiataxform = this.indiataxform .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outErpifRvisSeq = this.outErpifRvisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSteCd = this.orgSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRch = this.sRch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustNm = this.sVndrCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaTaxSeq = this.idaTaxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndNm = this.eqKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdPartyNm = this.sTrdPartyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newRvisCd = this.newRvisCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFrance = this.sFrance .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustAddr = this.vndrCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtHrs = this.wtHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCtyNm = this.orgCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soIfSeq = this.soIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRcvDueDt = this.sRcvDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLengthN3ptyBilTpCd = this.sLengthN3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvRvisSeq = this.n3ptyInvRvisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFaxNo = this.sFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoAll = this.blNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.validYnCorrection = this.validYnCorrection .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDetailOtsStsCd = this.sDetailOtsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVslCd = this.newVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustDivCd = this.sVndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eduTax = this.eduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newSealNo = this.newSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmRvisNo = this.estmRvisNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdPartyCode = this.sTrdPartyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAmt = this.revAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sHVndrCustDivCd = this.sHVndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstNo = this.rgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsStsCd = this.otsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgZipCd = this.orgZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnTax = this.expnTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sameVersionYn = this.sameVersionYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvStsCd = this.n3ptyInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCltAgnFlg = this.sCltAgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustNm = this.vndrCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvNo = this.sN3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newRvisSeq = this.newRvisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgUsrInpCtnt2 = this.orgUsrInpCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.citaNo = this.citaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgUsrInpCtnt1 = this.orgUsrInpCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outErpifCreditnoteSeq = this.outErpifCreditnoteSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSvcTax = this.totSvcTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repairLocation = this.repairLocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.highEduTax = this.highEduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatAmt = this.vatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTotAmt = this.orgTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDetailN3ptyNo = this.sDetailN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilTpCd = this.bilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.route = this.route .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDueDt = this.rcvDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvRmdYn = this.n3ptyInvRmdYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgInvDesc = this.orgInvDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVatXchRtChk = this.sVatXchRtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sHisSeq = this.sHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyCode = this.trdPartyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCntrWgtUtCd = this.n3ptyCntrWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCreditnoteCd = this.newCreditnoteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFinalFlg = this.sFinalFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.citationNo = this.citationNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDdctAmt = this.orgDdctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftOvrDys = this.ftOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCorrectionYn = this.sCorrectionYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCd = this.n3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatXchRt = this.vatXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netAmt = this.netAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPhnNo = this.sPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outErpifRvisCd = this.outErpifRvisCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totExpnTax = this.totExpnTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvRmk2 = this.sInvRmk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgVndrCustRefRmk = this.orgVndrCustRefRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSameVersionYn = this.sSameVersionYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyIfTpCd = this.n3ptyIfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustRefRmk = this.sVndrCustRefRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBilLoc = this.sBilLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCntCd = this.sCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCntrSealNo = this.newCntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newBkgAll = this.newBkgAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newEqNo = this.newEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDaoN3ptyBilTpCd = this.sDaoN3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAmt = this.otsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFromCurrCd = this.sFromCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdate = this.sdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd = this.revVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAddAmt = this.sAddAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCntCd = this.sVndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totEduTax = this.totEduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyOfcCd = this.sN3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgAdmChrg = this.orgAdmChrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqCd = this.sRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lengthRevVvd = this.lengthRevVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvRmdNm = this.sN3ptyInvRmdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustEml = this.vndrCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newBkgNo = this.newBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvRmk1 = this.sInvRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIdaTaxSeq = this.sIdaTaxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdParty = this.trdParty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToLocDivCd = this.bilToLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lengthCurrCd = this.lengthCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNetAmt = this.sNetAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outErpifCreditnoteCd = this.outErpifCreditnoteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvRvisSeq = this.sN3ptyInvRvisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvIssRhqCd = this.sInvIssRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatDtlAmt = this.vatDtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstFreeDt = this.lstFreeDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
