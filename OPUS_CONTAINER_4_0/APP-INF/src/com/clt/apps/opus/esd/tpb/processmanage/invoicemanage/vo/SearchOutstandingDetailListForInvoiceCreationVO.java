/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOutstandingDetailListForInvoiceCreationVO.java
*@FileTitle : SearchOutstandingDetailListForInvoiceCreationVO
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

public class SearchOutstandingDetailListForInvoiceCreationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOutstandingDetailListForInvoiceCreationVO> models = new ArrayList<SearchOutstandingDetailListForInvoiceCreationVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String n3ptyExpnTpCd = null;
	/* Column Info */
	private String trdPartyCode = null;
	/* Column Info */
	private String n3ptyCntrWgtUtCd = null;
	/* Column Info */
	private String estmSvrId = null;
	/* Column Info */
	private String otsDtlSeq = null;
	/* Column Info */
	private String lastFreeDt = null;
	/* Column Info */
	private String citationNo = null;
	/* Column Info */
	private String sheetSetCount = null;
	/* Column Info */
	private String invDtlAmt = null;
	/* Column Info */
	private String n3ptyBilTpNm = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mgsetNo = null;
	/* Column Info */
	private String ftOvrDys = null;
	/* Column Info */
	private String originalInvDtlAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrCustAddr = null;
	/* Column Info */
	private String wtHrs = null;
	/* Column Info */
	private String vatXchRt = null;
	/* Column Info */
	private String n3ptyBilTpCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String soIfSeq = null;
	/* Column Info */
	private String blNoAll = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String engAddr = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String n3ptyIfTpCd = null;
	/* Column Info */
	private String newVslCd = null;
	/* Column Info */
	private String newCntrSealNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String newBkgAll = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String newEqNo = null;
	/* Column Info */
	private String newSealNo = null;
	/* Column Info */
	private String estmRvisNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String damageDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String otsAmt = null;
	/* Column Info */
	private String revAmt = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String pkupDt = null;
	/* Column Info */
	private String pickUpDt = null;
	/* Column Info */
	private String weight = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String overDay = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String vndrCustNm = null;
	/* Column Info */
	private String uom = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String fincDirCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String estmSeqNo = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String citaNo = null;
	/* Column Info */
	private String waitingTm = null;
	/* Column Info */
	private String vndrCustEml = null;
	/* Column Info */
	private String newBkgNo = null;
	/* Column Info */
	private String bkgNoAll = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String repairLocation = null;
	/* Column Info */
	private String bilToLocDivCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String vndrCustAddr2 = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String route = null;
	/* Column Info */
	private String eqKndNm = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String occurDt = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String newVvd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOutstandingDetailListForInvoiceCreationVO() {}

	public SearchOutstandingDetailListForInvoiceCreationVO(String ibflag, String pagerows, String toNodCd, String vslCd, String vndrCntCd, String glDt, String trdPartyCode, String n3ptyCntrWgtUtCd, String estmSvrId, String otsDtlSeq, String lastFreeDt, String citationNo, String invDtlAmt, String sheetSetCount, String blNo, String n3ptyBilTpNm, String ftOvrDys, String mgsetNo, String originalInvDtlAmt, String wtHrs, String vndrCustAddr, String n3ptyBilTpCd, String vatXchRt, String soIfSeq, String vvdCd, String blNoAll, String custCntCd, String phnNo, String csrNo, String cntrWgt, String engAddr, String soNo, String rhqCd, String newVslCd, String newCntrSealNo, String skdVoyNo, String newBkgAll, String eqTpszCd, String vvd, String newEqNo, String newSealNo, String bkgNo, String damageDt, String vndrSeq, String otsAmt, String revAmt, String faxNo, String pkupDt, String pickUpDt, String currCd, String weight, String overDay, String eqNo, String vndrCustNm, String uom, String n3ptyNo, String acctCd, String fincDirCd, String dorNodCd, String invAmt, String citaNo, String waitingTm, String newBkgNo, String vndrCustEml, String bkgNoAll, String custSeq, String skdDirCd, String bilToLocDivCd, String repairLocation, String fmNodCd, String vndrCustAddr2, String ydCd, String route, String lgsCostCd, String eqKndNm, String viaNodCd, String eqKndCd, String occurDt, String newVvd, String n3ptyExpnTpCd, String n3ptyIfTpCd, String estmSeqNo, String estmRvisNo) {
		this.toNodCd = toNodCd;
		this.vslCd = vslCd;
		this.vndrCntCd = vndrCntCd;
		this.glDt = glDt;
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
		this.trdPartyCode = trdPartyCode;
		this.n3ptyCntrWgtUtCd = n3ptyCntrWgtUtCd;
		this.estmSvrId = estmSvrId;
		this.otsDtlSeq = otsDtlSeq;
		this.lastFreeDt = lastFreeDt;
		this.citationNo = citationNo;
		this.sheetSetCount = sheetSetCount;
		this.invDtlAmt = invDtlAmt;
		this.n3ptyBilTpNm = n3ptyBilTpNm;
		this.blNo = blNo;
		this.mgsetNo = mgsetNo;
		this.ftOvrDys = ftOvrDys;
		this.originalInvDtlAmt = originalInvDtlAmt;
		this.pagerows = pagerows;
		this.vndrCustAddr = vndrCustAddr;
		this.wtHrs = wtHrs;
		this.vatXchRt = vatXchRt;
		this.n3ptyBilTpCd = n3ptyBilTpCd;
		this.vvdCd = vvdCd;
		this.soIfSeq = soIfSeq;
		this.blNoAll = blNoAll;
		this.custCntCd = custCntCd;
		this.phnNo = phnNo;
		this.csrNo = csrNo;
		this.cntrWgt = cntrWgt;
		this.engAddr = engAddr;
		this.soNo = soNo;
		this.rhqCd = rhqCd;
		this.n3ptyIfTpCd = n3ptyIfTpCd;
		this.newVslCd = newVslCd;
		this.newCntrSealNo = newCntrSealNo;
		this.skdVoyNo = skdVoyNo;
		this.newBkgAll = newBkgAll;
		this.eqTpszCd = eqTpszCd;
		this.vvd = vvd;
		this.newEqNo = newEqNo;
		this.newSealNo = newSealNo;
		this.estmRvisNo = estmRvisNo;
		this.bkgNo = bkgNo;
		this.damageDt = damageDt;
		this.vndrSeq = vndrSeq;
		this.otsAmt = otsAmt;
		this.revAmt = revAmt;
		this.faxNo = faxNo;
		this.pkupDt = pkupDt;
		this.pickUpDt = pickUpDt;
		this.weight = weight;
		this.currCd = currCd;
		this.overDay = overDay;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.vndrCustNm = vndrCustNm;
		this.uom = uom;
		this.n3ptyNo = n3ptyNo;
		this.fincDirCd = fincDirCd;
		this.acctCd = acctCd;
		this.dorNodCd = dorNodCd;
		this.estmSeqNo = estmSeqNo;
		this.invAmt = invAmt;
		this.citaNo = citaNo;
		this.waitingTm = waitingTm;
		this.vndrCustEml = vndrCustEml;
		this.newBkgNo = newBkgNo;
		this.bkgNoAll = bkgNoAll;
		this.custSeq = custSeq;
		this.repairLocation = repairLocation;
		this.bilToLocDivCd = bilToLocDivCd;
		this.skdDirCd = skdDirCd;
		this.fmNodCd = fmNodCd;
		this.vndrCustAddr2 = vndrCustAddr2;
		this.ydCd = ydCd;
		this.route = route;
		this.eqKndNm = eqKndNm;
		this.lgsCostCd = lgsCostCd;
		this.viaNodCd = viaNodCd;
		this.occurDt = occurDt;
		this.eqKndCd = eqKndCd;
		this.newVvd = newVvd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("n3pty_expn_tp_cd", getN3ptyExpnTpCd());
		this.hashColumns.put("trd_party_code", getTrdPartyCode());
		this.hashColumns.put("n3pty_cntr_wgt_ut_cd", getN3ptyCntrWgtUtCd());
		this.hashColumns.put("estm_svr_id", getEstmSvrId());
		this.hashColumns.put("ots_dtl_seq", getOtsDtlSeq());
		this.hashColumns.put("last_free_dt", getLastFreeDt());
		this.hashColumns.put("citation_no", getCitationNo());
		this.hashColumns.put("sheet_set_count", getSheetSetCount());
		this.hashColumns.put("inv_dtl_amt", getInvDtlAmt());
		this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mgset_no", getMgsetNo());
		this.hashColumns.put("ft_ovr_dys", getFtOvrDys());
		this.hashColumns.put("original_inv_dtl_amt", getOriginalInvDtlAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_cust_addr", getVndrCustAddr());
		this.hashColumns.put("wt_hrs", getWtHrs());
		this.hashColumns.put("vat_xch_rt", getVatXchRt());
		this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("so_if_seq", getSoIfSeq());
		this.hashColumns.put("bl_no_all", getBlNoAll());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("eng_addr", getEngAddr());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("n3pty_if_tp_cd", getN3ptyIfTpCd());
		this.hashColumns.put("new_vsl_cd", getNewVslCd());
		this.hashColumns.put("new_cntr_seal_no", getNewCntrSealNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("new_bkg_all", getNewBkgAll());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("new_eq_no", getNewEqNo());
		this.hashColumns.put("new_seal_no", getNewSealNo());
		this.hashColumns.put("estm_rvis_no", getEstmRvisNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("damage_dt", getDamageDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ots_amt", getOtsAmt());
		this.hashColumns.put("rev_amt", getRevAmt());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("pkup_dt", getPkupDt());
		this.hashColumns.put("pick_up_dt", getPickUpDt());
		this.hashColumns.put("weight", getWeight());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("over_day", getOverDay());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("vndr_cust_nm", getVndrCustNm());
		this.hashColumns.put("uom", getUom());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("finc_dir_cd", getFincDirCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("estm_seq_no", getEstmSeqNo());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("cita_no", getCitaNo());
		this.hashColumns.put("waiting_tm", getWaitingTm());
		this.hashColumns.put("vndr_cust_eml", getVndrCustEml());
		this.hashColumns.put("new_bkg_no", getNewBkgNo());
		this.hashColumns.put("bkg_no_all", getBkgNoAll());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("repair_location", getRepairLocation());
		this.hashColumns.put("bil_to_loc_div_cd", getBilToLocDivCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("vndr_cust_addr2", getVndrCustAddr2());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("route", getRoute());
		this.hashColumns.put("eq_knd_nm", getEqKndNm());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("occur_dt", getOccurDt());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("new_vvd", getNewVvd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("n3pty_expn_tp_cd", "n3ptyExpnTpCd");
		this.hashFields.put("trd_party_code", "trdPartyCode");
		this.hashFields.put("n3pty_cntr_wgt_ut_cd", "n3ptyCntrWgtUtCd");
		this.hashFields.put("estm_svr_id", "estmSvrId");
		this.hashFields.put("ots_dtl_seq", "otsDtlSeq");
		this.hashFields.put("last_free_dt", "lastFreeDt");
		this.hashFields.put("citation_no", "citationNo");
		this.hashFields.put("sheet_set_count", "sheetSetCount");
		this.hashFields.put("inv_dtl_amt", "invDtlAmt");
		this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mgset_no", "mgsetNo");
		this.hashFields.put("ft_ovr_dys", "ftOvrDys");
		this.hashFields.put("original_inv_dtl_amt", "originalInvDtlAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_cust_addr", "vndrCustAddr");
		this.hashFields.put("wt_hrs", "wtHrs");
		this.hashFields.put("vat_xch_rt", "vatXchRt");
		this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("so_if_seq", "soIfSeq");
		this.hashFields.put("bl_no_all", "blNoAll");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("eng_addr", "engAddr");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("n3pty_if_tp_cd", "n3ptyIfTpCd");
		this.hashFields.put("new_vsl_cd", "newVslCd");
		this.hashFields.put("new_cntr_seal_no", "newCntrSealNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("new_bkg_all", "newBkgAll");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("new_eq_no", "newEqNo");
		this.hashFields.put("new_seal_no", "newSealNo");
		this.hashFields.put("estm_rvis_no", "estmRvisNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("damage_dt", "damageDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ots_amt", "otsAmt");
		this.hashFields.put("rev_amt", "revAmt");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("pkup_dt", "pkupDt");
		this.hashFields.put("pick_up_dt", "pickUpDt");
		this.hashFields.put("weight", "weight");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("over_day", "overDay");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("vndr_cust_nm", "vndrCustNm");
		this.hashFields.put("uom", "uom");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("finc_dir_cd", "fincDirCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("estm_seq_no", "estmSeqNo");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("cita_no", "citaNo");
		this.hashFields.put("waiting_tm", "waitingTm");
		this.hashFields.put("vndr_cust_eml", "vndrCustEml");
		this.hashFields.put("new_bkg_no", "newBkgNo");
		this.hashFields.put("bkg_no_all", "bkgNoAll");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("repair_location", "repairLocation");
		this.hashFields.put("bil_to_loc_div_cd", "bilToLocDivCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("vndr_cust_addr2", "vndrCustAddr2");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("route", "route");
		this.hashFields.put("eq_knd_nm", "eqKndNm");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("occur_dt", "occurDt");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("new_vvd", "newVvd");
		return this.hashFields;
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
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
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
	 * @return estmSvrId
	 */
	public String getEstmSvrId() {
		return this.estmSvrId;
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
	 * @return lastFreeDt
	 */
	public String getLastFreeDt() {
		return this.lastFreeDt;
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
	 * @return n3ptyBilTpNm
	 */
	public String getN3ptyBilTpNm() {
		return this.n3ptyBilTpNm;
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
	 * @return mgsetNo
	 */
	public String getMgsetNo() {
		return this.mgsetNo;
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
	 * @return originalInvDtlAmt
	 */
	public String getOriginalInvDtlAmt() {
		return this.originalInvDtlAmt;
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
	 * @return vatXchRt
	 */
	public String getVatXchRt() {
		return this.vatXchRt;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
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
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
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
	 * @return n3ptyIfTpCd
	 */
	public String getN3ptyIfTpCd() {
		return this.n3ptyIfTpCd;
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
	 * @return newCntrSealNo
	 */
	public String getNewCntrSealNo() {
		return this.newCntrSealNo;
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
	 * @return newBkgAll
	 */
	public String getNewBkgAll() {
		return this.newBkgAll;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return newSealNo
	 */
	public String getNewSealNo() {
		return this.newSealNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return revAmt
	 */
	public String getRevAmt() {
		return this.revAmt;
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
	 * @return pkupDt
	 */
	public String getPkupDt() {
		return this.pkupDt;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return overDay
	 */
	public String getOverDay() {
		return this.overDay;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
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
	 * @return uom
	 */
	public String getUom() {
		return this.uom;
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
	 * @return estmSeqNo
	 */
	public String getEstmSeqNo() {
		return this.estmSeqNo;
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
	 * @return citaNo
	 */
	public String getCitaNo() {
		return this.citaNo;
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
	 * @return bkgNoAll
	 */
	public String getBkgNoAll() {
		return this.bkgNoAll;
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
	 * @return repairLocation
	 */
	public String getRepairLocation() {
		return this.repairLocation;
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
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return eqKndNm
	 */
	public String getEqKndNm() {
		return this.eqKndNm;
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
	 * @return occurDt
	 */
	public String getOccurDt() {
		return this.occurDt;
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
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
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
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
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
	 * @param estmSvrId
	 */
	public void setEstmSvrId(String estmSvrId) {
		this.estmSvrId = estmSvrId;
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
	 * @param lastFreeDt
	 */
	public void setLastFreeDt(String lastFreeDt) {
		this.lastFreeDt = lastFreeDt;
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
	 * @param n3ptyBilTpNm
	 */
	public void setN3ptyBilTpNm(String n3ptyBilTpNm) {
		this.n3ptyBilTpNm = n3ptyBilTpNm;
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
	 * @param mgsetNo
	 */
	public void setMgsetNo(String mgsetNo) {
		this.mgsetNo = mgsetNo;
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
	 * @param originalInvDtlAmt
	 */
	public void setOriginalInvDtlAmt(String originalInvDtlAmt) {
		this.originalInvDtlAmt = originalInvDtlAmt;
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
	 * @param vatXchRt
	 */
	public void setVatXchRt(String vatXchRt) {
		this.vatXchRt = vatXchRt;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
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
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
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
	 * @param n3ptyIfTpCd
	 */
	public void setN3ptyIfTpCd(String n3ptyIfTpCd) {
		this.n3ptyIfTpCd = n3ptyIfTpCd;
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
	 * @param newCntrSealNo
	 */
	public void setNewCntrSealNo(String newCntrSealNo) {
		this.newCntrSealNo = newCntrSealNo;
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
	 * @param newBkgAll
	 */
	public void setNewBkgAll(String newBkgAll) {
		this.newBkgAll = newBkgAll;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param newSealNo
	 */
	public void setNewSealNo(String newSealNo) {
		this.newSealNo = newSealNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param revAmt
	 */
	public void setRevAmt(String revAmt) {
		this.revAmt = revAmt;
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
	 * @param pkupDt
	 */
	public void setPkupDt(String pkupDt) {
		this.pkupDt = pkupDt;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param overDay
	 */
	public void setOverDay(String overDay) {
		this.overDay = overDay;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
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
	 * @param uom
	 */
	public void setUom(String uom) {
		this.uom = uom;
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
	 * @param estmSeqNo
	 */
	public void setEstmSeqNo(String estmSeqNo) {
		this.estmSeqNo = estmSeqNo;
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
	 * @param citaNo
	 */
	public void setCitaNo(String citaNo) {
		this.citaNo = citaNo;
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
	 * @param bkgNoAll
	 */
	public void setBkgNoAll(String bkgNoAll) {
		this.bkgNoAll = bkgNoAll;
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
	 * @param repairLocation
	 */
	public void setRepairLocation(String repairLocation) {
		this.repairLocation = repairLocation;
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
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param eqKndNm
	 */
	public void setEqKndNm(String eqKndNm) {
		this.eqKndNm = eqKndNm;
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
	 * @param occurDt
	 */
	public void setOccurDt(String occurDt) {
		this.occurDt = occurDt;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToNodCd(JSPUtil.getParameter(request, "to_nod_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setGlDt(JSPUtil.getParameter(request, "gl_dt", ""));
		setN3ptyExpnTpCd(JSPUtil.getParameter(request, "n3pty_expn_tp_cd", ""));
		setTrdPartyCode(JSPUtil.getParameter(request, "trd_party_code", ""));
		setN3ptyCntrWgtUtCd(JSPUtil.getParameter(request, "n3pty_cntr_wgt_ut_cd", ""));
		setEstmSvrId(JSPUtil.getParameter(request, "estm_svr_id", ""));
		setOtsDtlSeq(JSPUtil.getParameter(request, "ots_dtl_seq", ""));
		setLastFreeDt(JSPUtil.getParameter(request, "last_free_dt", ""));
		setCitationNo(JSPUtil.getParameter(request, "citation_no", ""));
		setSheetSetCount(JSPUtil.getParameter(request, "sheet_set_count", ""));
		setInvDtlAmt(JSPUtil.getParameter(request, "inv_dtl_amt", ""));
		setN3ptyBilTpNm(JSPUtil.getParameter(request, "n3pty_bil_tp_nm", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setMgsetNo(JSPUtil.getParameter(request, "mgset_no", ""));
		setFtOvrDys(JSPUtil.getParameter(request, "ft_ovr_dys", ""));
		setOriginalInvDtlAmt(JSPUtil.getParameter(request, "original_inv_dtl_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVndrCustAddr(JSPUtil.getParameter(request, "vndr_cust_addr", ""));
		setWtHrs(JSPUtil.getParameter(request, "wt_hrs", ""));
		setVatXchRt(JSPUtil.getParameter(request, "vat_xch_rt", ""));
		setN3ptyBilTpCd(JSPUtil.getParameter(request, "n3pty_bil_tp_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setSoIfSeq(JSPUtil.getParameter(request, "so_if_seq", ""));
		setBlNoAll(JSPUtil.getParameter(request, "bl_no_all", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setEngAddr(JSPUtil.getParameter(request, "eng_addr", ""));
		setSoNo(JSPUtil.getParameter(request, "so_no", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setN3ptyIfTpCd(JSPUtil.getParameter(request, "n3pty_if_tp_cd", ""));
		setNewVslCd(JSPUtil.getParameter(request, "new_vsl_cd", ""));
		setNewCntrSealNo(JSPUtil.getParameter(request, "new_cntr_seal_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setNewBkgAll(JSPUtil.getParameter(request, "new_bkg_all", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setNewEqNo(JSPUtil.getParameter(request, "new_eq_no", ""));
		setNewSealNo(JSPUtil.getParameter(request, "new_seal_no", ""));
		setEstmRvisNo(JSPUtil.getParameter(request, "estm_rvis_no", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDamageDt(JSPUtil.getParameter(request, "damage_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setOtsAmt(JSPUtil.getParameter(request, "ots_amt", ""));
		setRevAmt(JSPUtil.getParameter(request, "rev_amt", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setPkupDt(JSPUtil.getParameter(request, "pkup_dt", ""));
		setPickUpDt(JSPUtil.getParameter(request, "pick_up_dt", ""));
		setWeight(JSPUtil.getParameter(request, "weight", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setOverDay(JSPUtil.getParameter(request, "over_day", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setVndrCustNm(JSPUtil.getParameter(request, "vndr_cust_nm", ""));
		setUom(JSPUtil.getParameter(request, "uom", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setFincDirCd(JSPUtil.getParameter(request, "finc_dir_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setDorNodCd(JSPUtil.getParameter(request, "dor_nod_cd", ""));
		setEstmSeqNo(JSPUtil.getParameter(request, "estm_seq_no", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setCitaNo(JSPUtil.getParameter(request, "cita_no", ""));
		setWaitingTm(JSPUtil.getParameter(request, "waiting_tm", ""));
		setVndrCustEml(JSPUtil.getParameter(request, "vndr_cust_eml", ""));
		setNewBkgNo(JSPUtil.getParameter(request, "new_bkg_no", ""));
		setBkgNoAll(JSPUtil.getParameter(request, "bkg_no_all", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setRepairLocation(JSPUtil.getParameter(request, "repair_location", ""));
		setBilToLocDivCd(JSPUtil.getParameter(request, "bil_to_loc_div_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, "fm_nod_cd", ""));
		setVndrCustAddr2(JSPUtil.getParameter(request, "vndr_cust_addr2", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setRoute(JSPUtil.getParameter(request, "route", ""));
		setEqKndNm(JSPUtil.getParameter(request, "eq_knd_nm", ""));
		setLgsCostCd(JSPUtil.getParameter(request, "lgs_cost_cd", ""));
		setViaNodCd(JSPUtil.getParameter(request, "via_nod_cd", ""));
		setOccurDt(JSPUtil.getParameter(request, "occur_dt", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setNewVvd(JSPUtil.getParameter(request, "new_vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOutstandingDetailListForInvoiceCreationVO[]
	 */
	public SearchOutstandingDetailListForInvoiceCreationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOutstandingDetailListForInvoiceCreationVO[]
	 */
	public SearchOutstandingDetailListForInvoiceCreationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOutstandingDetailListForInvoiceCreationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] n3ptyExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_expn_tp_cd", length));
			String[] trdPartyCode = (JSPUtil.getParameter(request, prefix	+ "trd_party_code", length));
			String[] n3ptyCntrWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_cntr_wgt_ut_cd", length));
			String[] estmSvrId = (JSPUtil.getParameter(request, prefix	+ "estm_svr_id", length));
			String[] otsDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ots_dtl_seq", length));
			String[] lastFreeDt = (JSPUtil.getParameter(request, prefix	+ "last_free_dt", length));
			String[] citationNo = (JSPUtil.getParameter(request, prefix	+ "citation_no", length));
			String[] sheetSetCount = (JSPUtil.getParameter(request, prefix	+ "sheet_set_count", length));
			String[] invDtlAmt = (JSPUtil.getParameter(request, prefix	+ "inv_dtl_amt", length));
			String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_nm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mgsetNo = (JSPUtil.getParameter(request, prefix	+ "mgset_no", length));
			String[] ftOvrDys = (JSPUtil.getParameter(request, prefix	+ "ft_ovr_dys", length));
			String[] originalInvDtlAmt = (JSPUtil.getParameter(request, prefix	+ "original_inv_dtl_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrCustAddr = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_addr", length));
			String[] wtHrs = (JSPUtil.getParameter(request, prefix	+ "wt_hrs", length));
			String[] vatXchRt = (JSPUtil.getParameter(request, prefix	+ "vat_xch_rt", length));
			String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] soIfSeq = (JSPUtil.getParameter(request, prefix	+ "so_if_seq", length));
			String[] blNoAll = (JSPUtil.getParameter(request, prefix	+ "bl_no_all", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] engAddr = (JSPUtil.getParameter(request, prefix	+ "eng_addr", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] n3ptyIfTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_if_tp_cd", length));
			String[] newVslCd = (JSPUtil.getParameter(request, prefix	+ "new_vsl_cd", length));
			String[] newCntrSealNo = (JSPUtil.getParameter(request, prefix	+ "new_cntr_seal_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] newBkgAll = (JSPUtil.getParameter(request, prefix	+ "new_bkg_all", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] newEqNo = (JSPUtil.getParameter(request, prefix	+ "new_eq_no", length));
			String[] newSealNo = (JSPUtil.getParameter(request, prefix	+ "new_seal_no", length));
			String[] estmRvisNo = (JSPUtil.getParameter(request, prefix	+ "estm_rvis_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] damageDt = (JSPUtil.getParameter(request, prefix	+ "damage_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] otsAmt = (JSPUtil.getParameter(request, prefix	+ "ots_amt", length));
			String[] revAmt = (JSPUtil.getParameter(request, prefix	+ "rev_amt", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] pkupDt = (JSPUtil.getParameter(request, prefix	+ "pkup_dt", length));
			String[] pickUpDt = (JSPUtil.getParameter(request, prefix	+ "pick_up_dt", length));
			String[] weight = (JSPUtil.getParameter(request, prefix	+ "weight", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] overDay = (JSPUtil.getParameter(request, prefix	+ "over_day", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] vndrCustNm = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_nm", length));
			String[] uom = (JSPUtil.getParameter(request, prefix	+ "uom", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] fincDirCd = (JSPUtil.getParameter(request, prefix	+ "finc_dir_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] estmSeqNo = (JSPUtil.getParameter(request, prefix	+ "estm_seq_no", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] citaNo = (JSPUtil.getParameter(request, prefix	+ "cita_no", length));
			String[] waitingTm = (JSPUtil.getParameter(request, prefix	+ "waiting_tm", length));
			String[] vndrCustEml = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_eml", length));
			String[] newBkgNo = (JSPUtil.getParameter(request, prefix	+ "new_bkg_no", length));
			String[] bkgNoAll = (JSPUtil.getParameter(request, prefix	+ "bkg_no_all", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] repairLocation = (JSPUtil.getParameter(request, prefix	+ "repair_location", length));
			String[] bilToLocDivCd = (JSPUtil.getParameter(request, prefix	+ "bil_to_loc_div_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] vndrCustAddr2 = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_addr2", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] route = (JSPUtil.getParameter(request, prefix	+ "route", length));
			String[] eqKndNm = (JSPUtil.getParameter(request, prefix	+ "eq_knd_nm", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] occurDt = (JSPUtil.getParameter(request, prefix	+ "occur_dt", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] newVvd = (JSPUtil.getParameter(request, prefix	+ "new_vvd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOutstandingDetailListForInvoiceCreationVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (n3ptyExpnTpCd[i] != null)
					model.setN3ptyExpnTpCd(n3ptyExpnTpCd[i]);
				if (trdPartyCode[i] != null)
					model.setTrdPartyCode(trdPartyCode[i]);
				if (n3ptyCntrWgtUtCd[i] != null)
					model.setN3ptyCntrWgtUtCd(n3ptyCntrWgtUtCd[i]);
				if (estmSvrId[i] != null)
					model.setEstmSvrId(estmSvrId[i]);
				if (otsDtlSeq[i] != null)
					model.setOtsDtlSeq(otsDtlSeq[i]);
				if (lastFreeDt[i] != null)
					model.setLastFreeDt(lastFreeDt[i]);
				if (citationNo[i] != null)
					model.setCitationNo(citationNo[i]);
				if (sheetSetCount[i] != null)
					model.setSheetSetCount(sheetSetCount[i]);
				if (invDtlAmt[i] != null)
					model.setInvDtlAmt(invDtlAmt[i]);
				if (n3ptyBilTpNm[i] != null)
					model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mgsetNo[i] != null)
					model.setMgsetNo(mgsetNo[i]);
				if (ftOvrDys[i] != null)
					model.setFtOvrDys(ftOvrDys[i]);
				if (originalInvDtlAmt[i] != null)
					model.setOriginalInvDtlAmt(originalInvDtlAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrCustAddr[i] != null)
					model.setVndrCustAddr(vndrCustAddr[i]);
				if (wtHrs[i] != null)
					model.setWtHrs(wtHrs[i]);
				if (vatXchRt[i] != null)
					model.setVatXchRt(vatXchRt[i]);
				if (n3ptyBilTpCd[i] != null)
					model.setN3ptyBilTpCd(n3ptyBilTpCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (soIfSeq[i] != null)
					model.setSoIfSeq(soIfSeq[i]);
				if (blNoAll[i] != null)
					model.setBlNoAll(blNoAll[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (engAddr[i] != null)
					model.setEngAddr(engAddr[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (n3ptyIfTpCd[i] != null)
					model.setN3ptyIfTpCd(n3ptyIfTpCd[i]);
				if (newVslCd[i] != null)
					model.setNewVslCd(newVslCd[i]);
				if (newCntrSealNo[i] != null)
					model.setNewCntrSealNo(newCntrSealNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (newBkgAll[i] != null)
					model.setNewBkgAll(newBkgAll[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (newEqNo[i] != null)
					model.setNewEqNo(newEqNo[i]);
				if (newSealNo[i] != null)
					model.setNewSealNo(newSealNo[i]);
				if (estmRvisNo[i] != null)
					model.setEstmRvisNo(estmRvisNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (damageDt[i] != null)
					model.setDamageDt(damageDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (otsAmt[i] != null)
					model.setOtsAmt(otsAmt[i]);
				if (revAmt[i] != null)
					model.setRevAmt(revAmt[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (pkupDt[i] != null)
					model.setPkupDt(pkupDt[i]);
				if (pickUpDt[i] != null)
					model.setPickUpDt(pickUpDt[i]);
				if (weight[i] != null)
					model.setWeight(weight[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (overDay[i] != null)
					model.setOverDay(overDay[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (vndrCustNm[i] != null)
					model.setVndrCustNm(vndrCustNm[i]);
				if (uom[i] != null)
					model.setUom(uom[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (fincDirCd[i] != null)
					model.setFincDirCd(fincDirCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (estmSeqNo[i] != null)
					model.setEstmSeqNo(estmSeqNo[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (citaNo[i] != null)
					model.setCitaNo(citaNo[i]);
				if (waitingTm[i] != null)
					model.setWaitingTm(waitingTm[i]);
				if (vndrCustEml[i] != null)
					model.setVndrCustEml(vndrCustEml[i]);
				if (newBkgNo[i] != null)
					model.setNewBkgNo(newBkgNo[i]);
				if (bkgNoAll[i] != null)
					model.setBkgNoAll(bkgNoAll[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (repairLocation[i] != null)
					model.setRepairLocation(repairLocation[i]);
				if (bilToLocDivCd[i] != null)
					model.setBilToLocDivCd(bilToLocDivCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (vndrCustAddr2[i] != null)
					model.setVndrCustAddr2(vndrCustAddr2[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (route[i] != null)
					model.setRoute(route[i]);
				if (eqKndNm[i] != null)
					model.setEqKndNm(eqKndNm[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (occurDt[i] != null)
					model.setOccurDt(occurDt[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (newVvd[i] != null)
					model.setNewVvd(newVvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOutstandingDetailListForInvoiceCreationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOutstandingDetailListForInvoiceCreationVO[]
	 */
	public SearchOutstandingDetailListForInvoiceCreationVO[] getSearchOutstandingDetailListForInvoiceCreationVOs(){
		SearchOutstandingDetailListForInvoiceCreationVO[] vos = (SearchOutstandingDetailListForInvoiceCreationVO[])models.toArray(new SearchOutstandingDetailListForInvoiceCreationVO[models.size()]);
		return vos;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyExpnTpCd = this.n3ptyExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyCode = this.trdPartyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCntrWgtUtCd = this.n3ptyCntrWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSvrId = this.estmSvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDtlSeq = this.otsDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastFreeDt = this.lastFreeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.citationNo = this.citationNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetSetCount = this.sheetSetCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtlAmt = this.invDtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpNm = this.n3ptyBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgsetNo = this.mgsetNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftOvrDys = this.ftOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalInvDtlAmt = this.originalInvDtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustAddr = this.vndrCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtHrs = this.wtHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatXchRt = this.vatXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCd = this.n3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soIfSeq = this.soIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoAll = this.blNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engAddr = this.engAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyIfTpCd = this.n3ptyIfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVslCd = this.newVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCntrSealNo = this.newCntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newBkgAll = this.newBkgAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newEqNo = this.newEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newSealNo = this.newSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmRvisNo = this.estmRvisNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.damageDt = this.damageDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAmt = this.otsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAmt = this.revAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupDt = this.pkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickUpDt = this.pickUpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weight = this.weight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDay = this.overDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustNm = this.vndrCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uom = this.uom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincDirCd = this.fincDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSeqNo = this.estmSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.citaNo = this.citaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.waitingTm = this.waitingTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustEml = this.vndrCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newBkgNo = this.newBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoAll = this.bkgNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repairLocation = this.repairLocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToLocDivCd = this.bilToLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustAddr2 = this.vndrCustAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.route = this.route .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndNm = this.eqKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.occurDt = this.occurDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVvd = this.newVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
