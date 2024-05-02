/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VgmDashboardVO.java
*@FileTitle : VgmDashboardVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.25  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VgmDashboardVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VgmDashboardVO> models = new ArrayList<VgmDashboardVO>();
	
	/* Column Info */
	private String ttlQtyF = null;
	/* Column Info */
	private String emlRslt = null;
	/* Column Info */
	private String inCustCntCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String inVgm = null;
	/* Column Info */
	private String inBkgOfcCd = null;
	/* Column Info */
	private String boardFromDt = null;
	/* Column Info */
	private String clsUsr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String qtyCntr = null;
	/* Column Info */
	private String inDt = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String vgmVia = null;
	/* Column Info */
	private String vgmClzFlg = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String unit = null;
	/* Column Info */
	private String emlAddr = null;
	/* Column Info */
	private String boardToDt = null;
	/* Column Info */
	private String inCustNm = null;
	/* Column Info */
	private String ttlBkg = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String emlDt = null;
	/* Column Info */
	private String ttlQtyT = null;
	/* Column Info */
	private String ediRslt = null;
	/* Column Info */
	private String ttlNonRcvdVgm = null;
	/* Column Info */
	private String ff = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inVvd = null;
	/* Column Info */
	private String bkgToDt = null;
	/* Column Info */
	private String qtyBkg = null;
	/* Column Info */
	private String ttlNonVgm = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String inUsr = null;
	/* Column Info */
	private String fstEtd = null;
	/* Column Info */
	private String ttlVgm = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ediId = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Column Info */
	private String vgmWgtUtCd = null;
	/* Column Info */
	private String inPodCd = null;
	/* Column Info */
	private String inCustSeq = null;
	/* Column Info */
	private String ediDt = null;
	/* Column Info */
	private String sz = null;
	/* Column Info */
	private String ttlClzBkg = null;
	/* Column Info */
	private String bkgFromDt = null;
	/* Column Info */
	private String pBkgCustTpCd = null;
	/* Column Info */
	private String cm = null;
	/* Column Info */
	private String vgmOpt = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String clsDt = null;
	/* Column Info */
	private String num = null;
	/* Column Info */
	private String xterVgmWgt = null;
	/* Column Info */
	private String xterVgmWgtUtCd = null;
	/* Column Info */
	private String esig = null;
	/* Column Info */
	private String vgmVal = null;
	/* Column Info */
	private String mssSig = null;
	/* Column Info */
	private String lateUpd = null;
	/* Column Info */
	private String vgmWgtUpdUsrId = null;
	/* Column Info */
	private String vgmWgtUpdDt = null;
	/* Column Info */
	private String vgmCutOffTm = null;
	/* Column Info */
	private String denseRank = null;
	/* Column Info */
	private String inPolYdCd = null;
	/* Column Info */
	private String inPodYdCd = null;
	/* Column Info */
	private String inPolLt = null;
	/* Column Info */
	private String inPodLt = null;
	/* Column Info */
	private String check = null;
	/* Column Info */
	private String bkgNoList = null;
	/* Column Info */
	private String sup = null;
	/* Column Info */
	private String vgmSeq = null;
	/* Column Info */
	private String esigCoNm = null;
	/* Column Info */
	private String xterSndrId = null;
	/* Column Info */
	private String xterVgmDocId = null;
	/* Column Info */
	private String xterVgmRqstSeq = null;
	/* Column Info */
	private String xterVgmUsrId = null;
	/* Column Info */
	private String lt = null;
	/* Column Info */
	private String multBkgNo = null;
	/* Column Info */
	private String wgtTpCd = null;
	/* Column Info */
	private String srchMltBkg = null;
	/* Column Info */
	private String trnkVvd = null;
	/* Column Info */
	private String vgmBkgNo = null;
	/* Column Info */
	private String ovrPayld = null;
	/* Column Info */
	private String diff5Pct = null;
	/* Column Info */
	private String diff10Pct = null;
	/* Column Info */
	private String payldPlsTare = null;
	/* Column Info */
	private String cgoPlsTare = null;
	/* Column Info */
	private String diffPct = null;
	/* Column Info */
	private String refId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VgmDashboardVO() {}

	public VgmDashboardVO(String ibflag, String pagerows, String bkgNo, String blNo, String bkgOfcCd, String polCd, String podCd, String qtyBkg, String qtyCntr, String fstEtd, String cntrNo, String sz, String vgmWgt, String vgmWgtUtCd, String wgt, String unit, String cm, String shpr, String ff, String vgmVia, String inUsr, String inDt, String emlAddr, String emlRslt, String emlDt, String ediId, String ediRslt, String ediDt, String vgmClzFlg, String clsUsr, String clsDt, String ttlBkg, String ttlQtyF, String ttlQtyT, String ttlVgm, String ttlNonVgm, String ttlNonRcvdVgm, String ttlClzBkg, String inVvd, String inPolCd, String inPodCd, String rcvTermCd, String deTermCd, String inBkgOfcCd, String vgmOpt, String inVgm, String boardFromDt, String boardToDt, String bkgFromDt, String bkgToDt, String pBkgCustTpCd, String inCustCntCd, String inCustSeq, String inCustNm, String num, String xterVgmWgt, String xterVgmWgtUtCd, String esig, String vgmVal, String mssSig, String lateUpd, String vgmWgtUpdUsrId, String vgmWgtUpdDt, String vgmCutOffTm, String denseRank, String inPolYdCd, String inPodYdCd, String inPolLt, String inPodLt, String check, String bkgNoList, String sup, String vgmSeq, String esigCoNm, String xterSndrId, String xterVgmDocId, String xterVgmRqstSeq, String xterVgmUsrId, String lt, String multBkgNo, String wgtTpCd, String srchMltBkg, String trnkVvd, String vgmBkgNo, String ovrPayld, String diff5Pct, String diff10Pct, String payldPlsTare, String cgoPlsTare, String diffPct, String refId) {
		this.ttlQtyF = ttlQtyF;
		this.emlRslt = emlRslt;
		this.inCustCntCd = inCustCntCd;
		this.blNo = blNo;
		this.bkgNo = bkgNo;
		this.inVgm = inVgm;
		this.inBkgOfcCd = inBkgOfcCd;
		this.boardFromDt = boardFromDt;
		this.clsUsr = clsUsr;
		this.pagerows = pagerows;
		this.shpr = shpr;
		this.qtyCntr = qtyCntr;
		this.inDt = inDt;
		this.wgt = wgt;
		this.vgmVia = vgmVia;
		this.vgmClzFlg = vgmClzFlg;
		this.deTermCd = deTermCd;
		this.unit = unit;
		this.emlAddr = emlAddr;
		this.boardToDt = boardToDt;
		this.inCustNm = inCustNm;
		this.ttlBkg = ttlBkg;
		this.bkgOfcCd = bkgOfcCd;
		this.emlDt = emlDt;
		this.ttlQtyT = ttlQtyT;
		this.ediRslt = ediRslt;
		this.ttlNonRcvdVgm = ttlNonRcvdVgm;
		this.ff = ff;
		this.ibflag = ibflag;
		this.inVvd = inVvd;
		this.bkgToDt = bkgToDt;
		this.qtyBkg = qtyBkg;
		this.ttlNonVgm = ttlNonVgm;
		this.polCd = polCd;
		this.inUsr = inUsr;
		this.fstEtd = fstEtd;
		this.ttlVgm = ttlVgm;
		this.inPolCd = inPolCd;
		this.podCd = podCd;
		this.ediId = ediId;
		this.vgmWgt = vgmWgt;
		this.vgmWgtUtCd = vgmWgtUtCd;
		this.inPodCd = inPodCd;
		this.inCustSeq = inCustSeq;
		this.ediDt = ediDt;
		this.sz = sz;
		this.ttlClzBkg = ttlClzBkg;
		this.bkgFromDt = bkgFromDt;
		this.pBkgCustTpCd = pBkgCustTpCd;
		this.cm = cm;
		this.vgmOpt = vgmOpt;
		this.rcvTermCd = rcvTermCd;
		this.cntrNo = cntrNo;
		this.clsDt = clsDt;
		this.num = num;
		this.xterVgmWgt = xterVgmWgt;
		this.xterVgmWgtUtCd = xterVgmWgtUtCd;
		this.esig = esig;
		this.vgmVal = vgmVal;
		this.mssSig = mssSig;
		this.lateUpd = lateUpd;
		this.vgmWgtUpdUsrId = vgmWgtUpdUsrId;
		this.vgmWgtUpdDt = vgmWgtUpdDt;
		this.vgmCutOffTm = vgmCutOffTm;
		this.denseRank = denseRank;
		this.inPolYdCd = inPolYdCd;
		this.inPodYdCd = inPodYdCd;
		this.inPolLt = inPolLt;
		this.inPodLt = inPodLt;
		this.check = check;
		this.bkgNoList = bkgNoList;
		this.sup = sup;
		this.vgmSeq = vgmSeq;
		this.esigCoNm = esigCoNm;
		this.xterSndrId = xterSndrId;
		this.xterVgmDocId = xterVgmDocId;
		this.xterVgmRqstSeq = xterVgmRqstSeq;
		this.xterVgmUsrId = xterVgmUsrId;
		this.lt = lt;
		this.multBkgNo = multBkgNo;
		this.wgtTpCd = wgtTpCd;
		this.srchMltBkg = srchMltBkg;
		this.trnkVvd = trnkVvd;
		this.vgmBkgNo = vgmBkgNo;
		this.ovrPayld = ovrPayld;
		this.diff5Pct = diff5Pct;
		this.diff10Pct = diff10Pct;
		this.payldPlsTare = payldPlsTare;
		this.cgoPlsTare = cgoPlsTare;
		this.diffPct = diffPct;
		this.refId = refId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ttl_qty_f", getTtlQtyF());
		this.hashColumns.put("eml_rslt", getEmlRslt());
		this.hashColumns.put("in_cust_cnt_cd", getInCustCntCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("in_vgm", getInVgm());
		this.hashColumns.put("in_bkg_ofc_cd", getInBkgOfcCd());
		this.hashColumns.put("board_from_dt", getBoardFromDt());
		this.hashColumns.put("cls_usr", getClsUsr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("qty_cntr", getQtyCntr());
		this.hashColumns.put("in_dt", getInDt());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("vgm_via", getVgmVia());
		this.hashColumns.put("vgm_clz_flg", getVgmClzFlg());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("unit", getUnit());
		this.hashColumns.put("eml_addr", getEmlAddr());
		this.hashColumns.put("board_to_dt", getBoardToDt());
		this.hashColumns.put("in_cust_nm", getInCustNm());
		this.hashColumns.put("ttl_bkg", getTtlBkg());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("eml_dt", getEmlDt());
		this.hashColumns.put("ttl_qty_t", getTtlQtyT());
		this.hashColumns.put("edi_rslt", getEdiRslt());
		this.hashColumns.put("ttl_non_rcvd_vgm", getTtlNonRcvdVgm());
		this.hashColumns.put("ff", getFf());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_vvd", getInVvd());
		this.hashColumns.put("bkg_to_dt", getBkgToDt());
		this.hashColumns.put("qty_bkg", getQtyBkg());
		this.hashColumns.put("ttl_non_vgm", getTtlNonVgm());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("in_usr", getInUsr());
		this.hashColumns.put("fst_etd", getFstEtd());
		this.hashColumns.put("ttl_vgm", getTtlVgm());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("edi_id", getEdiId());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		this.hashColumns.put("in_pod_cd", getInPodCd());
		this.hashColumns.put("in_cust_seq", getInCustSeq());
		this.hashColumns.put("edi_dt", getEdiDt());
		this.hashColumns.put("sz", getSz());
		this.hashColumns.put("ttl_clz_bkg", getTtlClzBkg());
		this.hashColumns.put("bkg_from_dt", getBkgFromDt());
		this.hashColumns.put("p_bkg_cust_tp_cd", getPBkgCustTpCd());
		this.hashColumns.put("cm", getCm());
		this.hashColumns.put("vgm_opt", getVgmOpt());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cls_dt", getClsDt());
		this.hashColumns.put("num", getNum());
		this.hashColumns.put("xter_vgm_wgt", getXterVgmWgt());
		this.hashColumns.put("xter_vgm_wgt_ut_cd", getXterVgmWgtUtCd());
		this.hashColumns.put("esig", getEsig());
		this.hashColumns.put("vgm_val", getVgmVal());
		this.hashColumns.put("mss_sig", getMssSig());
		this.hashColumns.put("late_upd", getLateUpd());
		this.hashColumns.put("vgm_wgt_upd_usr_id", getVgmWgtUpdUsrId());
		this.hashColumns.put("vgm_wgt_upd_dt", getVgmWgtUpdDt());
		this.hashColumns.put("vgm_cut_off_tm", getVgmCutOffTm());
		this.hashColumns.put("dense_rank", getDenseRank());
		this.hashColumns.put("in_pol_yd_cd", getInPolYdCd());
		this.hashColumns.put("in_pod_yd_cd", getInPodYdCd());
		this.hashColumns.put("in_pol_lt", getInPolLt());
		this.hashColumns.put("in_pod_lt", getInPodLt());
		this.hashColumns.put("check", getCheck());
		this.hashColumns.put("bkg_no_list", getBkgNoList());
		this.hashColumns.put("sup", getSup());
		this.hashColumns.put("vgm_seq", getVgmSeq());
		this.hashColumns.put("esig_co_nm", getEsigCoNm());
		this.hashColumns.put("xter_sndr_id", getXterSndrId());
		this.hashColumns.put("xter_vgm_doc_id", getXterVgmDocId());
		this.hashColumns.put("xter_vgm_rqst_seq", getXterVgmRqstSeq());
		this.hashColumns.put("xter_vgm_usr_id", getXterVgmUsrId());
		this.hashColumns.put("lt", getLt());
		this.hashColumns.put("mult_bkg_no", getMultBkgNo());
		this.hashColumns.put("wgt_tp_cd", getWgtTpCd());
		this.hashColumns.put("srch_mlt_bkg", getSrchMltBkg());
		this.hashColumns.put("trnk_vvd", getTrnkVvd());
		this.hashColumns.put("vgm_bkg_no", getVgmBkgNo());
		this.hashColumns.put("ovr_payld", getOvrPayld());
		this.hashColumns.put("diff_5_pct", getDiff5Pct());
		this.hashColumns.put("diff_10_pct", getDiff10Pct());
		this.hashColumns.put("payld_pls_tare", getPayldPlsTare());
		this.hashColumns.put("cgo_pls_tare", getCgoPlsTare());
		this.hashColumns.put("diff_pct", getDiffPct());
		this.hashColumns.put("ref_id", getRefId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ttl_qty_f", "ttlQtyF");
		this.hashFields.put("eml_rslt", "emlRslt");
		this.hashFields.put("in_cust_cnt_cd", "inCustCntCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("in_vgm", "inVgm");
		this.hashFields.put("in_bkg_ofc_cd", "inBkgOfcCd");
		this.hashFields.put("board_from_dt", "boardFromDt");
		this.hashFields.put("cls_usr", "clsUsr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("qty_cntr", "qtyCntr");
		this.hashFields.put("in_dt", "inDt");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("vgm_via", "vgmVia");
		this.hashFields.put("vgm_clz_flg", "vgmClzFlg");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("unit", "unit");
		this.hashFields.put("eml_addr", "emlAddr");
		this.hashFields.put("board_to_dt", "boardToDt");
		this.hashFields.put("in_cust_nm", "inCustNm");
		this.hashFields.put("ttl_bkg", "ttlBkg");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("eml_dt", "emlDt");
		this.hashFields.put("ttl_qty_t", "ttlQtyT");
		this.hashFields.put("edi_rslt", "ediRslt");
		this.hashFields.put("ttl_non_rcvd_vgm", "ttlNonRcvdVgm");
		this.hashFields.put("ff", "ff");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_vvd", "inVvd");
		this.hashFields.put("bkg_to_dt", "bkgToDt");
		this.hashFields.put("qty_bkg", "qtyBkg");
		this.hashFields.put("ttl_non_vgm", "ttlNonVgm");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("in_usr", "inUsr");
		this.hashFields.put("fst_etd", "fstEtd");
		this.hashFields.put("ttl_vgm", "ttlVgm");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("in_pod_cd", "inPodCd");
		this.hashFields.put("in_cust_seq", "inCustSeq");
		this.hashFields.put("edi_dt", "ediDt");
		this.hashFields.put("sz", "sz");
		this.hashFields.put("ttl_clz_bkg", "ttlClzBkg");
		this.hashFields.put("bkg_from_dt", "bkgFromDt");
		this.hashFields.put("p_bkg_cust_tp_cd", "pBkgCustTpCd");
		this.hashFields.put("cm", "cm");
		this.hashFields.put("vgm_opt", "vgmOpt");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cls_dt", "clsDt");
		this.hashFields.put("num", "num");
		this.hashFields.put("xter_vgm_wgt", "xterVgmWgt");
		this.hashFields.put("xter_vgm_wgt_ut_cd", "xterVgmWgtUtCd");
		this.hashFields.put("esig", "esig");
		this.hashFields.put("vgm_val", "vgmVal");
		this.hashFields.put("mss_sig", "mssSig");
		this.hashFields.put("late_upd", "lateUpd");
		this.hashFields.put("vgm_wgt_upd_usr_id", "vgmWgtUpdUsrId");
		this.hashFields.put("vgm_wgt_upd_dt", "vgmWgtUpdDt");
		this.hashFields.put("vgm_cut_off_tm", "vgmCutOffTm");
		this.hashFields.put("dense_rank", "denseRank");
		this.hashFields.put("in_pol_yd_cd", "inPolYdCd");
		this.hashFields.put("in_pod_yd_cd", "inPodYdCd");
		this.hashFields.put("in_pol_lt", "inPolLt");
		this.hashFields.put("in_pod_lt", "inPodLt");
		this.hashFields.put("check", "check");
		this.hashFields.put("bkg_no_list", "bkgNoList");
		this.hashFields.put("sup", "sup");
		this.hashFields.put("vgm_seq", "vgmSeq");
		this.hashFields.put("esig_co_nm", "esigCoNm");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("xter_vgm_doc_id", "xterVgmDocId");
		this.hashFields.put("xter_vgm_rqst_seq", "xterVgmRqstSeq");
		this.hashFields.put("xter_vgm_usr_id", "xterVgmUsrId");
		this.hashFields.put("lt", "lt");
		this.hashFields.put("mult_bkg_no", "multBkgNo");
		this.hashFields.put("wgt_tp_cd", "wgtTpCd");
		this.hashFields.put("srch_mlt_bkg", "srchMltBkg");
		this.hashFields.put("trnk_vvd", "trnkVvd");
		this.hashFields.put("vgm_bkg_no", "vgmBkgNo");
		this.hashFields.put("ovr_payld", "ovrPayld");
		this.hashFields.put("diff_5_pct", "diff5Pct");
		this.hashFields.put("diff_10_pct", "diff10Pct");
		this.hashFields.put("payld_pls_tare", "payldPlsTare");
		this.hashFields.put("cgo_pls_tare", "cgoPlsTare");
		this.hashFields.put("diff_pct", "diffPct");
		this.hashFields.put("ref_id", "refId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ttlQtyF
	 */
	public String getTtlQtyF() {
		return this.ttlQtyF;
	}
	
	/**
	 * Column Info
	 * @return emlRslt
	 */
	public String getEmlRslt() {
		return this.emlRslt;
	}
	
	/**
	 * Column Info
	 * @return inCustCntCd
	 */
	public String getInCustCntCd() {
		return this.inCustCntCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return inVgm
	 */
	public String getInVgm() {
		return this.inVgm;
	}
	
	/**
	 * Column Info
	 * @return inBkgOfcCd
	 */
	public String getInBkgOfcCd() {
		return this.inBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return boardFromDt
	 */
	public String getBoardFromDt() {
		return this.boardFromDt;
	}
	
	/**
	 * Column Info
	 * @return clsUsr
	 */
	public String getClsUsr() {
		return this.clsUsr;
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
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}
	
	/**
	 * Column Info
	 * @return qtyCntr
	 */
	public String getQtyCntr() {
		return this.qtyCntr;
	}
	
	/**
	 * Column Info
	 * @return inDt
	 */
	public String getInDt() {
		return this.inDt;
	}
	
	/**
	 * Column Info
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
	}
	
	/**
	 * Column Info
	 * @return vgmVia
	 */
	public String getVgmVia() {
		return this.vgmVia;
	}
	
	/**
	 * Column Info
	 * @return vgmClzFlg
	 */
	public String getVgmClzFlg() {
		return this.vgmClzFlg;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return unit
	 */
	public String getUnit() {
		return this.unit;
	}
	
	/**
	 * Column Info
	 * @return emlAddr
	 */
	public String getEmlAddr() {
		return this.emlAddr;
	}
	
	/**
	 * Column Info
	 * @return boardToDt
	 */
	public String getBoardToDt() {
		return this.boardToDt;
	}
	
	/**
	 * Column Info
	 * @return inCustNm
	 */
	public String getInCustNm() {
		return this.inCustNm;
	}
	
	/**
	 * Column Info
	 * @return ttlBkg
	 */
	public String getTtlBkg() {
		return this.ttlBkg;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return emlDt
	 */
	public String getEmlDt() {
		return this.emlDt;
	}
	
	/**
	 * Column Info
	 * @return ttlQtyT
	 */
	public String getTtlQtyT() {
		return this.ttlQtyT;
	}
	
	/**
	 * Column Info
	 * @return ediRslt
	 */
	public String getEdiRslt() {
		return this.ediRslt;
	}
	
	/**
	 * Column Info
	 * @return ttlNonRcvdVgm
	 */
	public String getTtlNonRcvdVgm() {
		return this.ttlNonRcvdVgm;
	}
	
	/**
	 * Column Info
	 * @return ff
	 */
	public String getFf() {
		return this.ff;
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
	 * @return inVvd
	 */
	public String getInVvd() {
		return this.inVvd;
	}
	
	/**
	 * Column Info
	 * @return bkgToDt
	 */
	public String getBkgToDt() {
		return this.bkgToDt;
	}
	
	/**
	 * Column Info
	 * @return qtyBkg
	 */
	public String getQtyBkg() {
		return this.qtyBkg;
	}
	
	/**
	 * Column Info
	 * @return ttlNonVgm
	 */
	public String getTtlNonVgm() {
		return this.ttlNonVgm;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return inUsr
	 */
	public String getInUsr() {
		return this.inUsr;
	}
	
	/**
	 * Column Info
	 * @return fstEtd
	 */
	public String getFstEtd() {
		return this.fstEtd;
	}
	
	/**
	 * Column Info
	 * @return ttlVgm
	 */
	public String getTtlVgm() {
		return this.ttlVgm;
	}
	
	/**
	 * Column Info
	 * @return inPolCd
	 */
	public String getInPolCd() {
		return this.inPolCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return ediId
	 */
	public String getEdiId() {
		return this.ediId;
	}
	
	/**
	 * Column Info
	 * @return vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtUtCd
	 */
	public String getVgmWgtUtCd() {
		return this.vgmWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return inPodCd
	 */
	public String getInPodCd() {
		return this.inPodCd;
	}
	
	/**
	 * Column Info
	 * @return inCustSeq
	 */
	public String getInCustSeq() {
		return this.inCustSeq;
	}
	
	/**
	 * Column Info
	 * @return ediDt
	 */
	public String getEdiDt() {
		return this.ediDt;
	}
	
	/**
	 * Column Info
	 * @return sz
	 */
	public String getSz() {
		return this.sz;
	}
	
	/**
	 * Column Info
	 * @return ttlClzBkg
	 */
	public String getTtlClzBkg() {
		return this.ttlClzBkg;
	}
	
	/**
	 * Column Info
	 * @return bkgFromDt
	 */
	public String getBkgFromDt() {
		return this.bkgFromDt;
	}
	
	/**
	 * Column Info
	 * @return pBkgCustTpCd
	 */
	public String getPBkgCustTpCd() {
		return this.pBkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return cm
	 */
	public String getCm() {
		return this.cm;
	}
	
	/**
	 * Column Info
	 * @return vgmOpt
	 */
	public String getVgmOpt() {
		return this.vgmOpt;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return clsDt
	 */
	public String getClsDt() {
		return this.clsDt;
	}
	
	/**
	 * Column Info
	 * @return num
	 */
	public String getNum() {
		return this.num;
	}
	
	/**
	 * Column Info
	 * @return xterVgmWgt
	 */
	public String getXterVgmWgt() {
		return this.xterVgmWgt;
	}
	
	/**
	 * Column Info
	 * @return xterVgmWgtUtCd
	 */
	public String getXterVgmWgtUtCd() {
		return this.xterVgmWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return esig
	 */
	public String getEsig() {
		return this.esig;
	}
	
	/**
	 * Column Info
	 * @return vgmVal
	 */
	public String getVgmVal() {
		return this.vgmVal;
	}
	
	/**
	 * Column Info
	 * @return mssSig
	 */
	public String getMssSig() {
		return this.mssSig;
	}
	
	/**
	 * Column Info
	 * @return lateUpd
	 */
	public String getLateUpd() {
		return this.lateUpd;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtUpdUsrId
	 */
	public String getVgmWgtUpdUsrId() {
		return this.vgmWgtUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtUpdDt
	 */
	public String getVgmWgtUpdDt() {
		return this.vgmWgtUpdDt;
	}
	
	/**
	 * Column Info
	 * @return vgmCutOffTm
	 */
	public String getVgmCutOffTm() {
		return this.vgmCutOffTm;
	}
	
	/**
	 * Column Info
	 * @return denseRank
	 */
	public String getDenseRank() {
		return this.denseRank;
	}
	
	/**
	 * Column Info
	 * @return inPolYdCd
	 */
	public String getInPolYdCd() {
		return this.inPolYdCd;
	}
	
	/**
	 * Column Info
	 * @return inPodYdCd
	 */
	public String getInPodYdCd() {
		return this.inPodYdCd;
	}
	
	/**
	 * Column Info
	 * @return inPolLt
	 */
	public String getInPolLt() {
		return this.inPolLt;
	}
	
	/**
	 * Column Info
	 * @return inPodLt
	 */
	public String getInPodLt() {
		return this.inPodLt;
	}
	
	/**
	 * Column Info
	 * @return check
	 */
	public String getCheck() {
		return this.check;
	}
	
	/**
	 * Column Info
	 * @return bkgNoList
	 */
	public String getBkgNoList() {
		return this.bkgNoList;
	}
	
	/**
	 * Column Info
	 * @return sup
	 */
	public String getSup() {
		return this.sup;
	}
	
	/**
	 * Column Info
	 * @return vgmSeq
	 */
	public String getVgmSeq() {
		return this.vgmSeq;
	}
	
	/**
	 * Column Info
	 * @return esigCoNm
	 */
	public String getEsigCoNm() {
		return this.esigCoNm;
	}
	
	/**
	 * Column Info
	 * @return xterSndrId
	 */
	public String getXterSndrId() {
		return this.xterSndrId;
	}
	
	/**
	 * Column Info
	 * @return xterVgmDocId
	 */
	public String getXterVgmDocId() {
		return this.xterVgmDocId;
	}
	
	/**
	 * Column Info
	 * @return xterVgmRqstSeq
	 */
	public String getXterVgmRqstSeq() {
		return this.xterVgmRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return xterVgmUsrId
	 */
	public String getXterVgmUsrId() {
		return this.xterVgmUsrId;
	}
	
	/**
	 * Column Info
	 * @return lt
	 */
	public String getLt() {
		return this.lt;
	}
	
	/**
	 * Column Info
	 * @return multBkgNo
	 */
	public String getMultBkgNo() {
		return this.multBkgNo;
	}
	
	/**
	 * Column Info
	 * @return wgtTpCd
	 */
	public String getWgtTpCd() {
		return this.wgtTpCd;
	}
	
	/**
	 * Column Info
	 * @return srchMltBkg
	 */
	public String getSrchMltBkg() {
		return this.srchMltBkg;
	}
	
	/**
	 * Column Info
	 * @return trnkVvd
	 */
	public String getTrnkVvd() {
		return this.trnkVvd;
	}
	
	/**
	 * Column Info
	 * @return vgmBkgNo
	 */
	public String getVgmBkgNo() {
		return this.vgmBkgNo;
	}
	
	/**
	 * Column Info
	 * @return ovrPayld
	 */
	public String getOvrPayld() {
		return this.ovrPayld;
	}
	
	/**
	 * Column Info
	 * @return diff5Pct
	 */
	public String getDiff5Pct() {
		return this.diff5Pct;
	}
	
	/**
	 * Column Info
	 * @return diff10Pct
	 */
	public String getDiff10Pct() {
		return this.diff10Pct;
	}
	
	/**
	 * Column Info
	 * @return payldPlsTare
	 */
	public String getPayldPlsTare() {
		return this.payldPlsTare;
	}
	
	/**
	 * Column Info
	 * @return cgoPlsTare
	 */
	public String getCgoPlsTare() {
		return this.cgoPlsTare;
	}
	
	/**
	 * Column Info
	 * @return diffPct
	 */
	public String getDiffPct() {
		return this.diffPct;
	}

	/**
	 * Column Info
	 * @return refId
	 */
	public String getRefId() {
		return this.refId;
	}
	
	/**
	 * Column Info
	 * @param ttlQtyF
	 */
	public void setTtlQtyF(String ttlQtyF) {
		this.ttlQtyF = ttlQtyF;
	}
	
	/**
	 * Column Info
	 * @param emlRslt
	 */
	public void setEmlRslt(String emlRslt) {
		this.emlRslt = emlRslt;
	}
	
	/**
	 * Column Info
	 * @param inCustCntCd
	 */
	public void setInCustCntCd(String inCustCntCd) {
		this.inCustCntCd = inCustCntCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param inVgm
	 */
	public void setInVgm(String inVgm) {
		this.inVgm = inVgm;
	}
	
	/**
	 * Column Info
	 * @param inBkgOfcCd
	 */
	public void setInBkgOfcCd(String inBkgOfcCd) {
		this.inBkgOfcCd = inBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param boardFromDt
	 */
	public void setBoardFromDt(String boardFromDt) {
		this.boardFromDt = boardFromDt;
	}
	
	/**
	 * Column Info
	 * @param clsUsr
	 */
	public void setClsUsr(String clsUsr) {
		this.clsUsr = clsUsr;
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
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}
	
	/**
	 * Column Info
	 * @param qtyCntr
	 */
	public void setQtyCntr(String qtyCntr) {
		this.qtyCntr = qtyCntr;
	}
	
	/**
	 * Column Info
	 * @param inDt
	 */
	public void setInDt(String inDt) {
		this.inDt = inDt;
	}
	
	/**
	 * Column Info
	 * @param wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
	}
	
	/**
	 * Column Info
	 * @param vgmVia
	 */
	public void setVgmVia(String vgmVia) {
		this.vgmVia = vgmVia;
	}
	
	/**
	 * Column Info
	 * @param vgmClzFlg
	 */
	public void setVgmClzFlg(String vgmClzFlg) {
		this.vgmClzFlg = vgmClzFlg;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	/**
	 * Column Info
	 * @param emlAddr
	 */
	public void setEmlAddr(String emlAddr) {
		this.emlAddr = emlAddr;
	}
	
	/**
	 * Column Info
	 * @param boardToDt
	 */
	public void setBoardToDt(String boardToDt) {
		this.boardToDt = boardToDt;
	}
	
	/**
	 * Column Info
	 * @param inCustNm
	 */
	public void setInCustNm(String inCustNm) {
		this.inCustNm = inCustNm;
	}
	
	/**
	 * Column Info
	 * @param ttlBkg
	 */
	public void setTtlBkg(String ttlBkg) {
		this.ttlBkg = ttlBkg;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param emlDt
	 */
	public void setEmlDt(String emlDt) {
		this.emlDt = emlDt;
	}
	
	/**
	 * Column Info
	 * @param ttlQtyT
	 */
	public void setTtlQtyT(String ttlQtyT) {
		this.ttlQtyT = ttlQtyT;
	}
	
	/**
	 * Column Info
	 * @param ediRslt
	 */
	public void setEdiRslt(String ediRslt) {
		this.ediRslt = ediRslt;
	}
	
	/**
	 * Column Info
	 * @param ttlNonRcvdVgm
	 */
	public void setTtlNonRcvdVgm(String ttlNonRcvdVgm) {
		this.ttlNonRcvdVgm = ttlNonRcvdVgm;
	}
	
	/**
	 * Column Info
	 * @param ff
	 */
	public void setFf(String ff) {
		this.ff = ff;
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
	 * @param inVvd
	 */
	public void setInVvd(String inVvd) {
		this.inVvd = inVvd;
	}
	
	/**
	 * Column Info
	 * @param bkgToDt
	 */
	public void setBkgToDt(String bkgToDt) {
		this.bkgToDt = bkgToDt;
	}
	
	/**
	 * Column Info
	 * @param qtyBkg
	 */
	public void setQtyBkg(String qtyBkg) {
		this.qtyBkg = qtyBkg;
	}
	
	/**
	 * Column Info
	 * @param ttlNonVgm
	 */
	public void setTtlNonVgm(String ttlNonVgm) {
		this.ttlNonVgm = ttlNonVgm;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param inUsr
	 */
	public void setInUsr(String inUsr) {
		this.inUsr = inUsr;
	}
	
	/**
	 * Column Info
	 * @param fstEtd
	 */
	public void setFstEtd(String fstEtd) {
		this.fstEtd = fstEtd;
	}
	
	/**
	 * Column Info
	 * @param ttlVgm
	 */
	public void setTtlVgm(String ttlVgm) {
		this.ttlVgm = ttlVgm;
	}
	
	/**
	 * Column Info
	 * @param inPolCd
	 */
	public void setInPolCd(String inPolCd) {
		this.inPolCd = inPolCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param ediId
	 */
	public void setEdiId(String ediId) {
		this.ediId = ediId;
	}
	
	/**
	 * Column Info
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param inPodCd
	 */
	public void setInPodCd(String inPodCd) {
		this.inPodCd = inPodCd;
	}
	
	/**
	 * Column Info
	 * @param inCustSeq
	 */
	public void setInCustSeq(String inCustSeq) {
		this.inCustSeq = inCustSeq;
	}
	
	/**
	 * Column Info
	 * @param ediDt
	 */
	public void setEdiDt(String ediDt) {
		this.ediDt = ediDt;
	}
	
	/**
	 * Column Info
	 * @param sz
	 */
	public void setSz(String sz) {
		this.sz = sz;
	}
	
	/**
	 * Column Info
	 * @param ttlClzBkg
	 */
	public void setTtlClzBkg(String ttlClzBkg) {
		this.ttlClzBkg = ttlClzBkg;
	}
	
	/**
	 * Column Info
	 * @param bkgFromDt
	 */
	public void setBkgFromDt(String bkgFromDt) {
		this.bkgFromDt = bkgFromDt;
	}
	
	/**
	 * Column Info
	 * @param pBkgCustTpCd
	 */
	public void setPBkgCustTpCd(String pBkgCustTpCd) {
		this.pBkgCustTpCd = pBkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param cm
	 */
	public void setCm(String cm) {
		this.cm = cm;
	}
	
	/**
	 * Column Info
	 * @param vgmOpt
	 */
	public void setVgmOpt(String vgmOpt) {
		this.vgmOpt =vgmOpt;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param clsDt
	 */
	public void setClsDt(String clsDt) {
		this.clsDt = clsDt;
	}
	
	/**
	 * Column Info
	 * @param num
	 */
	public void setNum(String num) {
		this.num = num;
	}
	
	/**
	 * Column Info
	 * @param xterVgmWgt
	 */
	public void setXterVgmWgt(String xterVgmWgt) {
		this.xterVgmWgt = xterVgmWgt;
	}
	
	/**
	 * Column Info
	 * @param xterVgmWgtUtCd
	 */
	public void setXterVgmWgtUtCd(String xterVgmWgtUtCd) {
		this.xterVgmWgtUtCd = xterVgmWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param esig
	 */
	public void setEsig(String esig) {
		this.esig = esig;
	}
	
	/**
	 * Column Info
	 * @param vgmVal
	 */
	public void setVgmVal(String vgmVal) {
		this.vgmVal = vgmVal;
	}
	
	/**
	 * Column Info
	 * @param mssSig
	 */
	public void setMssSig(String mssSig) {
		this.mssSig = mssSig;
	}
	
	/**
	 * Column Info
	 * @param lateUpd
	 */
	public void setLateUpd(String lateUpd) {
		this.lateUpd = lateUpd;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtUpdUsrId
	 */
	public void setVgmWgtUpdUsrId(String vgmWgtUpdUsrId) {
		this.vgmWgtUpdUsrId = vgmWgtUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtUpdDt
	 */
	public void setVgmWgtUpdDt(String vgmWgtUpdDt) {
		this.vgmWgtUpdDt = vgmWgtUpdDt;
	}
	
	/**
	 * Column Info
	 * @param vgmCutOffTm
	 */
	public void setVgmCutOffTm(String vgmCutOffTm) {
		this.vgmCutOffTm = vgmCutOffTm;
	}
	
	/**
	 * Column Info
	 * @param denseRank
	 */
	public void setDenseRank(String denseRank) {
		this.denseRank = denseRank;
	}
	
	/**
	 * Column Info
	 * @param inPolYdCd
	 */
	public void setInPolYdCd(String inPolYdCd) {
		this.inPolYdCd = inPolYdCd;
	}
	
	/**
	 * Column Info
	 * @param inPodYdCd
	 */
	public void setInPodYdCd(String inPodYdCd) {
		this.inPodYdCd = inPodYdCd;
	}
	
	/**
	 * Column Info
	 * @param inPolLt
	 */
	public void setInPolLt(String inPolLt) {
		this.inPolLt = inPolLt;
	}
	
	/**
	 * Column Info
	 * @param inPodLt
	 */
	public void setInPodLt(String inPodLt) {
		this.inPodLt = inPodLt;
	}
	
	/**
	 * Column Info
	 * @param check
	 */
	public void setCheck(String check) {
		this.check = check;
	}
	
	/**
	 * Column Info
	 * @param bkgNoList
	 */
	public void setBkgNoList(String bkgNoList) {
		this.bkgNoList = bkgNoList;
	}
	
	/**
	 * Column Info
	 * @param sup
	 */
	public void setSup(String sup) {
		this.sup = sup;
	}
	
	/**
	 * Column Info
	 * @param vgmSeq
	 */
	public void setVgmSeq(String vgmSeq) {
		this.vgmSeq = vgmSeq;
	}
	
	/**
	 * Column Info
	 * @param esigCoNm
	 */
	public void setEsigCoNm(String esigCoNm) {
		this.esigCoNm = esigCoNm;
	}
	
	/**
	 * Column Info
	 * @param xterSndrId
	 */
	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
	}
	
	/**
	 * Column Info
	 * @param xterVgmDocId
	 */
	public void setXterVgmDocId(String xterVgmDocId) {
		this.xterVgmDocId = xterVgmDocId;
	}
	
	/**
	 * Column Info
	 * @param xterVgmRqstSeq
	 */
	public void setXterVgmRqstSeq(String xterVgmRqstSeq) {
		this.xterVgmRqstSeq = xterVgmRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param xterVgmUsrId
	 */
	public void setXterVgmUsrId(String xterVgmUsrId) {
		this.xterVgmUsrId = xterVgmUsrId;
	}
	
	/**
	 * Column Info
	 * @param lt
	 */
	public void setLt(String lt) {
		this.lt = lt;
	}
	
	/**
	 * Column Info
	 * @param multBkgNo
	 */
	public void setMultBkgNo(String multBkgNo) {
		this.multBkgNo = multBkgNo;
	}
	
	/**
	 * Column Info
	 * @param wgtTpCd
	 */
	public void setWgtTpCd(String wgtTpCd) {
		this.wgtTpCd = wgtTpCd;
	}
	
	/**
	 * Column Info
	 * @param srchMltBkg
	 */
	public void setSrchMltBkg(String srchMltBkg) {
		this.srchMltBkg = srchMltBkg;
	}
	
	/**
	 * Column Info
	 * @param trnkVvd
	 */
	public void setTrnkVvd(String trnkVvd) {
		this.trnkVvd = trnkVvd;
	}
	
	/**
	 * Column Info
	 * @param vgmBkgNo
	 */
	public void setVgmBkgNo(String vgmBkgNo) {
		this.vgmBkgNo = vgmBkgNo;
	}
	
	/**
	 * Column Info
	 * @param ovrPayld
	 */
	public void setOvrPayld(String ovrPayld) {
		this.ovrPayld = ovrPayld;
	}
	
	/**
	 * Column Info
	 * @param diff5Pct
	 */
	public void setDiff5Pct(String diff5Pct) {
		this.diff5Pct = diff5Pct;
	}
	
	/**
	 * Column Info
	 * @param diff10Pct
	 */
	public void setDiff10Pct(String diff10Pct) {
		this.diff10Pct = diff10Pct;
	}
	
	/**
	 * Column Info
	 * @param payldPlsTare
	 */
	public void setPayldPlsTare(String payldPlsTare) {
		this.payldPlsTare = payldPlsTare;
	}
	
	/**
	 * Column Info
	 * @param cgoPlsTare
	 */
	public void setCgoPlsTare(String cgoPlsTare) {
		this.cgoPlsTare = cgoPlsTare;
	}
	
	/**
	 * Column Info
	 * @param diffPct
	 */
	public void setDiffPct(String diffPct) {
		this.diffPct = diffPct;
	}
	
	/**
	 * Column Info
	 * @param refId
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setTtlQtyF(JSPUtil.getParameter(request, prefix + "ttl_qty_f", ""));
		setEmlRslt(JSPUtil.getParameter(request, prefix + "eml_rslt", ""));
		setInCustCntCd(JSPUtil.getParameter(request, prefix + "in_cust_cnt_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setInVgm(JSPUtil.getParameter(request, prefix + "in_vgm", ""));
		setInBkgOfcCd(JSPUtil.getParameter(request, prefix + "in_bkg_ofc_cd", ""));
		setBoardFromDt(JSPUtil.getParameter(request, prefix + "board_from_dt", ""));
		setClsUsr(JSPUtil.getParameter(request, prefix + "cls_usr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setShpr(JSPUtil.getParameter(request, prefix + "shpr", ""));
		setQtyCntr(JSPUtil.getParameter(request, prefix + "qty_cntr", ""));
		setInDt(JSPUtil.getParameter(request, prefix + "in_dt", ""));
		setWgt(JSPUtil.getParameter(request, prefix + "wgt", ""));
		setVgmVia(JSPUtil.getParameter(request, prefix + "vgm_via", ""));
		setVgmClzFlg(JSPUtil.getParameter(request, prefix + "vgm_clz_flg", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setUnit(JSPUtil.getParameter(request, prefix + "unit", ""));
		setEmlAddr(JSPUtil.getParameter(request, prefix + "eml_addr", ""));
		setBoardToDt(JSPUtil.getParameter(request, prefix + "board_to_dt", ""));
		setInCustNm(JSPUtil.getParameter(request, prefix + "in_cust_nm", ""));
		setTtlBkg(JSPUtil.getParameter(request, prefix + "ttl_bkg", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setEmlDt(JSPUtil.getParameter(request, prefix + "eml_dt", ""));
		setTtlQtyT(JSPUtil.getParameter(request, prefix + "ttl_qty_t", ""));
		setEdiRslt(JSPUtil.getParameter(request, prefix + "edi_rslt", ""));
		setTtlNonRcvdVgm(JSPUtil.getParameter(request, prefix + "ttl_non_rcvd_vgm", ""));
		setFf(JSPUtil.getParameter(request, prefix + "ff", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInVvd(JSPUtil.getParameter(request, prefix + "in_vvd", ""));
		setBkgToDt(JSPUtil.getParameter(request, prefix + "bkg_to_dt", ""));
		setQtyBkg(JSPUtil.getParameter(request, prefix + "qty_bkg", ""));
		setTtlNonVgm(JSPUtil.getParameter(request, prefix + "ttl_non_vgm", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setInUsr(JSPUtil.getParameter(request, prefix + "in_usr", ""));
		setFstEtd(JSPUtil.getParameter(request, prefix + "fst_etd", ""));
		setTtlVgm(JSPUtil.getParameter(request, prefix + "ttl_vgm", ""));
		setInPolCd(JSPUtil.getParameter(request, prefix + "in_pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setEdiId(JSPUtil.getParameter(request, prefix + "edi_id", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
		setInPodCd(JSPUtil.getParameter(request, prefix + "in_pod_cd", ""));
		setInCustSeq(JSPUtil.getParameter(request, prefix + "in_cust_seq", ""));
		setEdiDt(JSPUtil.getParameter(request, prefix + "edi_dt", ""));
		setSz(JSPUtil.getParameter(request, prefix + "sz", ""));
		setTtlClzBkg(JSPUtil.getParameter(request, prefix + "ttl_clz_bkg", ""));
		setBkgFromDt(JSPUtil.getParameter(request, prefix + "bkg_from_dt", ""));
		setPBkgCustTpCd(JSPUtil.getParameter(request, prefix + "p_bkg_cust_tp_cd", ""));
		setCm(JSPUtil.getParameter(request, prefix + "cm", ""));
		setVgmOpt(JSPUtil.getParameter(request, prefix + "vgm_opt", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setClsDt(JSPUtil.getParameter(request, prefix + "cls_dt", ""));
		setNum(JSPUtil.getParameter(request, prefix + "num", ""));
		setXterVgmWgt(JSPUtil.getParameter(request, prefix + "xter_vgm_wgt", ""));
		setXterVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "xter_vgm_wgt_ut_cd", ""));
		setEsig(JSPUtil.getParameter(request, prefix + "esig", ""));
		setVgmVal(JSPUtil.getParameter(request, prefix + "vgm_val", ""));
		setMssSig(JSPUtil.getParameter(request, prefix + "mss_sig", ""));
		setLateUpd(JSPUtil.getParameter(request, prefix + "late_upd", ""));
		setVgmWgtUpdUsrId(JSPUtil.getParameter(request, prefix + "vgm_wgt_upd_usr_id", ""));
		setVgmWgtUpdDt(JSPUtil.getParameter(request, prefix + "vgm_wgt_upd_dt", ""));
		setVgmCutOffTm(JSPUtil.getParameter(request, prefix + "vgm_cut_off_tm", ""));
		setDenseRank(JSPUtil.getParameter(request, prefix + "dense_rank", ""));
		setInPolYdCd(JSPUtil.getParameter(request, prefix + "in_pol_yd_cd", ""));
		setInPodYdCd(JSPUtil.getParameter(request, prefix + "in_pod_yd_cd", ""));
		setInPolLt(JSPUtil.getParameter(request, prefix + "in_pol_lt", ""));
		setInPodLt(JSPUtil.getParameter(request, prefix + "in_pod_lt", ""));
		setCheck(JSPUtil.getParameter(request, prefix + "check", ""));
		setBkgNoList(JSPUtil.getParameter(request, prefix + "bkg_no_list", ""));
		setSup(JSPUtil.getParameter(request, prefix + "sup", ""));
		setVgmSeq(JSPUtil.getParameter(request, prefix + "vgm_seq", ""));
		setEsigCoNm(JSPUtil.getParameter(request, prefix + "esig_co_nm", ""));
		setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
		setXterVgmDocId(JSPUtil.getParameter(request, prefix + "xter_vgm_doc_id", ""));
		setXterVgmRqstSeq(JSPUtil.getParameter(request, prefix + "xter_vgm_rqst_seq", ""));
		setXterVgmUsrId(JSPUtil.getParameter(request, prefix + "xter_vgm_usr_id", ""));
		setLt(JSPUtil.getParameter(request, prefix + "lt", ""));
		setMultBkgNo(JSPUtil.getParameter(request, prefix + "mult_bkg_no", ""));
		setWgtTpCd(JSPUtil.getParameter(request, prefix + "wgt_tp_cd", ""));
		setSrchMltBkg(JSPUtil.getParameter(request, prefix + "srch_mlt_bkg", ""));
		setTrnkVvd(JSPUtil.getParameter(request, prefix + "trnk_vvd", ""));
		setVgmBkgNo(JSPUtil.getParameter(request, prefix + "vgm_bkg_no", ""));
		setOvrPayld(JSPUtil.getParameter(request, prefix + "ovr_payld", ""));
		setDiff5Pct(JSPUtil.getParameter(request, prefix + "diff_5_pct", ""));
		setDiff10Pct(JSPUtil.getParameter(request, prefix + "diff_10_pct", ""));
		setPayldPlsTare(JSPUtil.getParameter(request, prefix + "payld_pls_tare", ""));
		setCgoPlsTare(JSPUtil.getParameter(request, prefix + "cgo_pls_tare", ""));
		setDiffPct(JSPUtil.getParameter(request, prefix + "diff_pct", ""));
		setRefId(JSPUtil.getParameter(request, prefix + "ref_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VgmDashboardVO[]
	 */
	public VgmDashboardVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VgmDashboardVO[]
	 */
	public VgmDashboardVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VgmDashboardVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ttlQtyF = (JSPUtil.getParameter(request, prefix	+ "ttl_qty_f", length));
			String[] emlRslt = (JSPUtil.getParameter(request, prefix	+ "eml_rslt", length));
			String[] inCustCntCd = (JSPUtil.getParameter(request, prefix	+ "in_cust_cnt_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] inVgm = (JSPUtil.getParameter(request, prefix	+ "in_vgm", length));
			String[] inBkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "in_bkg_ofc_cd", length));
			String[] boardFromDt = (JSPUtil.getParameter(request, prefix	+ "board_from_dt", length));
			String[] clsUsr = (JSPUtil.getParameter(request, prefix	+ "cls_usr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] qtyCntr = (JSPUtil.getParameter(request, prefix	+ "qty_cntr", length));
			String[] inDt = (JSPUtil.getParameter(request, prefix	+ "in_dt", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] vgmVia = (JSPUtil.getParameter(request, prefix	+ "vgm_via", length));
			String[] vgmClzFlg = (JSPUtil.getParameter(request, prefix	+ "vgm_clz_flg", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] unit = (JSPUtil.getParameter(request, prefix	+ "unit", length));
			String[] emlAddr = (JSPUtil.getParameter(request, prefix	+ "eml_addr", length));
			String[] boardToDt = (JSPUtil.getParameter(request, prefix	+ "board_to_dt", length));
			String[] inCustNm = (JSPUtil.getParameter(request, prefix	+ "in_cust_nm", length));
			String[] ttlBkg = (JSPUtil.getParameter(request, prefix	+ "ttl_bkg", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] emlDt = (JSPUtil.getParameter(request, prefix	+ "eml_dt", length));
			String[] ttlQtyT = (JSPUtil.getParameter(request, prefix	+ "ttl_qty_t", length));
			String[] ediRslt = (JSPUtil.getParameter(request, prefix	+ "edi_rslt", length));
			String[] ttlNonRcvdVgm = (JSPUtil.getParameter(request, prefix	+ "ttl_non_rcvd_vgm", length));
			String[] ff = (JSPUtil.getParameter(request, prefix	+ "ff", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inVvd = (JSPUtil.getParameter(request, prefix	+ "in_vvd", length));
			String[] bkgToDt = (JSPUtil.getParameter(request, prefix	+ "bkg_to_dt", length));
			String[] qtyBkg = (JSPUtil.getParameter(request, prefix	+ "qty_bkg", length));
			String[] ttlNonVgm = (JSPUtil.getParameter(request, prefix	+ "ttl_non_vgm", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] inUsr = (JSPUtil.getParameter(request, prefix	+ "in_usr", length));
			String[] fstEtd = (JSPUtil.getParameter(request, prefix	+ "fst_etd", length));
			String[] ttlVgm = (JSPUtil.getParameter(request, prefix	+ "ttl_vgm", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ediId = (JSPUtil.getParameter(request, prefix	+ "edi_id", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_ut_cd", length));
			String[] inPodCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_cd", length));
			String[] inCustSeq = (JSPUtil.getParameter(request, prefix	+ "in_cust_seq", length));
			String[] ediDt = (JSPUtil.getParameter(request, prefix	+ "edi_dt", length));
			String[] sz = (JSPUtil.getParameter(request, prefix	+ "sz", length));
			String[] ttlClzBkg = (JSPUtil.getParameter(request, prefix	+ "ttl_clz_bkg", length));
			String[] bkgFromDt = (JSPUtil.getParameter(request, prefix	+ "bkg_from_dt", length));
			String[] pBkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "p_bkg_cust_tp_cd", length));
			String[] cm = (JSPUtil.getParameter(request, prefix	+ "cm", length));
			String[] vgmOpt = (JSPUtil.getParameter(request, prefix	+ "vgm_opt", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] clsDt = (JSPUtil.getParameter(request, prefix	+ "cls_dt", length));
			String[] num = (JSPUtil.getParameter(request, prefix	+ "num", length));
			String[] xterVgmWgt = (JSPUtil.getParameter(request, prefix	+ "xter_vgm_wgt", length));
			String[] xterVgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "xter_vgm_wgt_ut_cd", length));
			String[] esig = (JSPUtil.getParameter(request, prefix	+ "esig", length));
			String[] vgmVal = (JSPUtil.getParameter(request, prefix	+ "vgm_val", length));
			String[] mssSig = (JSPUtil.getParameter(request, prefix	+ "mss_sig", length));
			String[] lateUpd = (JSPUtil.getParameter(request, prefix	+ "late_upd", length));
			String[] vgmWgtUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_upd_usr_id", length));
			String[] vgmWgtUpdDt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_upd_dt", length));
			String[] vgmCutOffTm = (JSPUtil.getParameter(request, prefix	+ "vgm_cut_off_tm", length));
			String[] denseRank = (JSPUtil.getParameter(request, prefix	+ "dense_rank", length));
			String[] inPolYdCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_yd_cd", length));
			String[] inPodYdCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_yd_cd", length));
			String[] inPolLt = (JSPUtil.getParameter(request, prefix	+ "in_pol_lt", length));
			String[] inPodLt = (JSPUtil.getParameter(request, prefix	+ "in_pod_lt", length));
			String[] check = (JSPUtil.getParameter(request, prefix	+ "check", length));
			String[] bkgNoList = (JSPUtil.getParameter(request, prefix	+ "bkg_no_list", length));
			String[] sup = (JSPUtil.getParameter(request, prefix	+ "sup", length));
			String[] vgmSeq = (JSPUtil.getParameter(request, prefix	+ "vgm_seq", length));
			String[] esigCoNm = (JSPUtil.getParameter(request, prefix	+ "esig_co_nm", length));
			String[] xterSndrId = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			String[] xterVgmDocId = (JSPUtil.getParameter(request, prefix	+ "xter_vgm_doc_id", length));
			String[] xterVgmRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_vgm_rqst_seq", length));
			String[] xterVgmUsrId = (JSPUtil.getParameter(request, prefix	+ "xter_vgm_usr_id", length));
			String[] lt = (JSPUtil.getParameter(request, prefix	+ "lt", length));
			String[] multBkgNo = (JSPUtil.getParameter(request, prefix	+ "mult_bkg_no", length));
			String[] wgtTpCd = (JSPUtil.getParameter(request, prefix	+ "wgt_tp_cd", length));
			String[] srchMltBkg = (JSPUtil.getParameter(request, prefix	+ "srch_mlt_bkg", length));
			String[] trnkVvd = (JSPUtil.getParameter(request, prefix	+ "trnk_vvd", length));
			String[] vgmBkgNo = (JSPUtil.getParameter(request, prefix	+ "vgm_bkg_no", length));
			String[] ovrPayld = (JSPUtil.getParameter(request, prefix	+ "over_payld", length));
			String[] diff5Pct = (JSPUtil.getParameter(request, prefix	+ "diff_5_pct", length));
			String[] diff10Pct = (JSPUtil.getParameter(request, prefix	+ "diff_10_pct", length));
			String[] payldPlsTare = (JSPUtil.getParameter(request, prefix	+ "payld_pls_tare", length));
			String[] cgoPlsTare = (JSPUtil.getParameter(request, prefix	+ "cgo_pls_tare", length));
			String[] diffPct = (JSPUtil.getParameter(request, prefix	+ "diff_pct", length));
			String[] refId = (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new VgmDashboardVO();
				if (ttlQtyF[i] != null)
					model.setTtlQtyF(ttlQtyF[i]);
				if (emlRslt[i] != null)
					model.setEmlRslt(emlRslt[i]);
				if (inCustCntCd[i] != null)
					model.setInCustCntCd(inCustCntCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (inVgm[i] != null)
					model.setInVgm(inVgm[i]);
				if (inBkgOfcCd[i] != null)
					model.setInBkgOfcCd(inBkgOfcCd[i]);
				if (boardFromDt[i] != null)
					model.setBoardFromDt(boardFromDt[i]);
				if (clsUsr[i] != null)
					model.setClsUsr(clsUsr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (qtyCntr[i] != null)
					model.setQtyCntr(qtyCntr[i]);
				if (inDt[i] != null)
					model.setInDt(inDt[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (vgmVia[i] != null)
					model.setVgmVia(vgmVia[i]);
				if (vgmClzFlg[i] != null)
					model.setVgmClzFlg(vgmClzFlg[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (unit[i] != null)
					model.setUnit(unit[i]);
				if (emlAddr[i] != null)
					model.setEmlAddr(emlAddr[i]);
				if (boardToDt[i] != null)
					model.setBoardToDt(boardToDt[i]);
				if (inCustNm[i] != null)
					model.setInCustNm(inCustNm[i]);
				if (ttlBkg[i] != null)
					model.setTtlBkg(ttlBkg[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (emlDt[i] != null)
					model.setEmlDt(emlDt[i]);
				if (ttlQtyT[i] != null)
					model.setTtlQtyT(ttlQtyT[i]);
				if (ediRslt[i] != null)
					model.setEdiRslt(ediRslt[i]);
				if (ttlNonRcvdVgm[i] != null)
					model.setTtlNonRcvdVgm(ttlNonRcvdVgm[i]);
				if (ff[i] != null)
					model.setFf(ff[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inVvd[i] != null)
					model.setInVvd(inVvd[i]);
				if (bkgToDt[i] != null)
					model.setBkgToDt(bkgToDt[i]);
				if (qtyBkg[i] != null)
					model.setQtyBkg(qtyBkg[i]);
				if (ttlNonVgm[i] != null)
					model.setTtlNonVgm(ttlNonVgm[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (inUsr[i] != null)
					model.setInUsr(inUsr[i]);
				if (fstEtd[i] != null)
					model.setFstEtd(fstEtd[i]);
				if (ttlVgm[i] != null)
					model.setTtlVgm(ttlVgm[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ediId[i] != null)
					model.setEdiId(ediId[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				if (inPodCd[i] != null)
					model.setInPodCd(inPodCd[i]);
				if (inCustSeq[i] != null)
					model.setInCustSeq(inCustSeq[i]);
				if (ediDt[i] != null)
					model.setEdiDt(ediDt[i]);
				if (sz[i] != null)
					model.setSz(sz[i]);
				if (ttlClzBkg[i] != null)
					model.setTtlClzBkg(ttlClzBkg[i]);
				if (bkgFromDt[i] != null)
					model.setBkgFromDt(bkgFromDt[i]);
				if (pBkgCustTpCd[i] != null)
					model.setPBkgCustTpCd(pBkgCustTpCd[i]);
				if (cm[i] != null)
					model.setCm(cm[i]);
				if (vgmOpt[i] != null)
					model.setVgmOpt(vgmOpt[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (clsDt[i] != null)
					model.setClsDt(clsDt[i]);
				if (num[i] != null)
					model.setNum(num[i]);
				if (xterVgmWgt[i] != null)
					model.setXterVgmWgt(xterVgmWgt[i]);
				if (xterVgmWgtUtCd[i] != null)
					model.setXterVgmWgtUtCd(xterVgmWgtUtCd[i]);
				if (esig[i] != null)
					model.setEsig(esig[i]);
				if (vgmVal[i] != null)
					model.setVgmVal(vgmVal[i]);
				if (mssSig[i] != null)
					model.setMssSig(mssSig[i]);
				if (lateUpd[i] != null)
					model.setLateUpd(lateUpd[i]);
				if (vgmWgtUpdUsrId[i] != null)
					model.setVgmWgtUpdUsrId(vgmWgtUpdUsrId[i]);
				if (vgmWgtUpdDt[i] != null)
					model.setVgmWgtUpdDt(vgmWgtUpdDt[i]);
				if (vgmCutOffTm[i] != null)
					model.setVgmCutOffTm(vgmCutOffTm[i]);
				if (denseRank[i] != null)
					model.setDenseRank(denseRank[i]);
				if (inPolYdCd[i] != null)
					model.setInPolYdCd(inPolYdCd[i]);
				if (inPodYdCd[i] != null)
					model.setInPodYdCd(inPodYdCd[i]);
				if (inPolLt[i] != null)
					model.setInPolLt(inPolLt[i]);
				if (inPodLt[i] != null)
					model.setInPodLt(inPodLt[i]);
				if (check[i] != null)
					model.setCheck(check[i]);
				if (bkgNoList[i] != null)
					model.setBkgNoList(bkgNoList[i]);
				if (sup[i] != null)
					model.setSup(sup[i]);
				if (vgmSeq[i] != null)
					model.setVgmSeq(vgmSeq[i]);
				if (esigCoNm[i] != null)
					model.setEsigCoNm(esigCoNm[i]);
				if (xterSndrId[i] != null)
					model.setXterSndrId(xterSndrId[i]);
				if (xterVgmDocId[i] != null)
					model.setXterVgmDocId(xterVgmDocId[i]);
				if (xterVgmRqstSeq[i] != null)
					model.setXterVgmRqstSeq(xterVgmRqstSeq[i]);
				if (xterVgmUsrId[i] != null)
					model.setXterVgmUsrId(xterVgmUsrId[i]);
				if (lt[i] != null)
					model.setLt(lt[i]);
				if (multBkgNo[i] != null)
					model.setMultBkgNo(multBkgNo[i]);
				if (wgtTpCd[i] != null)
					model.setWgtTpCd(wgtTpCd[i]);
				if (srchMltBkg[i] != null)
					model.setSrchMltBkg(srchMltBkg[i]);
				if (trnkVvd[i] != null)
					model.setTrnkVvd(trnkVvd[i]);
				if (vgmBkgNo[i] != null)
					model.setVgmBkgNo(vgmBkgNo[i]);
				if (ovrPayld[i] != null)
					model.setOvrPayld(ovrPayld[i]);
				if (diff5Pct[i] != null)
					model.setDiff5Pct(diff5Pct[i]);
				if (diff10Pct[i] != null)
					model.setDiff10Pct(diff10Pct[i]);
				if (payldPlsTare[i] != null)
					model.setPayldPlsTare(payldPlsTare[i]);
				if (cgoPlsTare[i] != null)
					model.setCgoPlsTare(cgoPlsTare[i]);
				if (diffPct[i] != null)
					model.setDiffPct(diffPct[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVgmDashboardVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VgmDashboardVO[]
	 */
	public VgmDashboardVO[] getVgmDashboardVOs(){
		VgmDashboardVO[] vos = (VgmDashboardVO[])models.toArray(new VgmDashboardVO[models.size()]);
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
		this.ttlQtyF = this.ttlQtyF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlRslt = this.emlRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCustCntCd = this.inCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVgm = this.inVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBkgOfcCd = this.inBkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boardFromDt = this.boardFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clsUsr = this.clsUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyCntr = this.qtyCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDt = this.inDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVia = this.vgmVia .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmClzFlg = this.vgmClzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit = this.unit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlAddr = this.emlAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boardToDt = this.boardToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCustNm = this.inCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBkg = this.ttlBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlDt = this.emlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlQtyT = this.ttlQtyT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRslt = this.ediRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlNonRcvdVgm = this.ttlNonRcvdVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ff = this.ff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvd = this.inVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgToDt = this.bkgToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyBkg = this.qtyBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlNonVgm = this.ttlNonVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inUsr = this.inUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fstEtd = this.fstEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlVgm = this.ttlVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId = this.ediId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd = this.vgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodCd = this.inPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCustSeq = this.inCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediDt = this.ediDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sz = this.sz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlClzBkg = this.ttlClzBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFromDt = this.bkgFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBkgCustTpCd = this.pBkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm = this.cm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmOpt = this.vgmOpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clsDt = this.clsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.num = this.num .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterVgmWgt = this.xterVgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterVgmWgtUtCd = this.xterVgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esig = this.esig .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVal = this.vgmVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mssSig = this.mssSig .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lateUpd = this.lateUpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUpdUsrId = this.vgmWgtUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUpdDt = this.vgmWgtUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCutOffTm = this.vgmCutOffTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.denseRank = this.denseRank .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolYdCd = this.inPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodYdCd = this.inPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolLt = this.inPolLt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodLt = this.inPodLt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.check = this.check .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoList = this.bkgNoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sup = this.sup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmSeq = this.vgmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esigCoNm = this.esigCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId = this.xterSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterVgmDocId = this.xterVgmDocId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterVgmRqstSeq = this.xterVgmRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterVgmUsrId = this.xterVgmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lt = this.lt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.multBkgNo = this.multBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtTpCd = this.wgtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchMltBkg = this.srchMltBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvd = this.trnkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmBkgNo = this.vgmBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrPayld = this.ovrPayld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff5Pct = this.diff5Pct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff10Pct = this.diff10Pct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payldPlsTare = this.payldPlsTare .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoPlsTare = this.cgoPlsTare .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffPct = this.diffPct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
