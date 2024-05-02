/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgChgRateVO.java
*@FileTitle : BkgChgRateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.11.26 이진서 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgChgRateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgChgRateVO> models = new ArrayList<BkgChgRateVO>();
	
	/* Column Info */
	private String noteRtSeq = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String n3ptyCustSeq = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cgoCateCd = null;
	/* Column Info */
	private String genSpclRtTpCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String n3ptyCustCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String prnHdnFlg = null;
	/* Column Info */
	private String chgUtAmt = null;
	/* Column Info */
	private String autoRatCd = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String n3ptyRcvOfcCd = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String inclOftFlg = null;
	/* Column Info */
	private String trfItmNo = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String ratAsQty = null;
	/* Column Info */
	private String imdgClssCd = null;
	private String taxFlg = null;
	private String pctBseCd = null;
	private String saveFlg = null;
	private String ifRmk = null;
	private String dpPrcsKnt = null; 
	private String vnFlg = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgChgRateVO() {}

	public BkgChgRateVO(String ibflag, String pagerows, String chgUtAmt, String autoRatCd, String currCd, String n3ptyRcvOfcCd, String frtTermCd, String ratUtCd, String inclOftFlg, String n3ptyCustSeq, String trfItmNo, String rtSeq, String chgCd, String deTermCd, String creUsrId, String bkgNo, String cgoCateCd, String chgAmt, String ratAsQty, String rcvTermCd, String n3ptyCustCntCd, String updUsrId, String prnHdnFlg, String imdgClssCd, String noteRtSeq, String propNo, String amdtSeq, String svcScpCd, String genSpclRtTpCd, String cmdtHdrSeq, String routSeq, String taxFlg, String pctBseCd, String saveFlg, String ifRmk, String dpPrcsKnt, String vnFlg) {
		this.noteRtSeq = noteRtSeq;
		this.currCd = currCd;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.n3ptyCustSeq = n3ptyCustSeq;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cgoCateCd = cgoCateCd;
		this.genSpclRtTpCd = genSpclRtTpCd;
		this.chgAmt = chgAmt;
		this.rcvTermCd = rcvTermCd;
		this.n3ptyCustCntCd = n3ptyCustCntCd;
		this.updUsrId = updUsrId;
		this.prnHdnFlg = prnHdnFlg;
		this.chgUtAmt = chgUtAmt;
		this.autoRatCd = autoRatCd;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.n3ptyRcvOfcCd = n3ptyRcvOfcCd;
		this.frtTermCd = frtTermCd;
		this.ratUtCd = ratUtCd;
		this.inclOftFlg = inclOftFlg;
		this.trfItmNo = trfItmNo;
		this.rtSeq = rtSeq;
		this.routSeq = routSeq;
		this.deTermCd = deTermCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.propNo = propNo;
		this.ratAsQty = ratAsQty;
		this.imdgClssCd = imdgClssCd;
		this.taxFlg = taxFlg;
		this.pctBseCd = pctBseCd;
		this.saveFlg = saveFlg;
		this.ifRmk = ifRmk;
		this.dpPrcsKnt = dpPrcsKnt;
		this.vnFlg = vnFlg;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("note_rt_seq", getNoteRtSeq());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("n3pty_cust_seq", getN3ptyCustSeq());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cgo_cate_cd", getCgoCateCd());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("n3pty_cust_cnt_cd", getN3ptyCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("prn_hdn_flg", getPrnHdnFlg());
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());
		this.hashColumns.put("auto_rat_cd", getAutoRatCd());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("n3pty_rcv_ofc_cd", getN3ptyRcvOfcCd());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("incl_oft_flg", getInclOftFlg());
		this.hashColumns.put("trf_itm_no", getTrfItmNo());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("tax_flg", getTaxFlg());
		this.hashColumns.put("pct_bse_cd", getPctBseCd());
		this.hashColumns.put("save_flg", getSaveFlg());
		this.hashColumns.put("if_rmk", getIfRmk());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("vn_flg", getVnFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("note_rt_seq", "noteRtSeq");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("n3pty_cust_seq", "n3ptyCustSeq");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cgo_cate_cd", "cgoCateCd");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("n3pty_cust_cnt_cd", "n3ptyCustCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("prn_hdn_flg", "prnHdnFlg");
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("auto_rat_cd", "autoRatCd");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("n3pty_rcv_ofc_cd", "n3ptyRcvOfcCd");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("incl_oft_flg", "inclOftFlg");
		this.hashFields.put("trf_itm_no", "trfItmNo");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("tax_flg", "taxFlg");
		this.hashFields.put("pct_bse_cd", "pctBseCd");
		this.hashFields.put("save_flg", "saveFlg");
		this.hashFields.put("if_rmk", "ifRmk");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("vn_flg", "vnFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return noteRtSeq
	 */
	public String getNoteRtSeq() {
		return this.noteRtSeq;
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCustSeq
	 */
	public String getN3ptyCustSeq() {
		return this.n3ptyCustSeq;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return cgoCateCd
	 */
	public String getCgoCateCd() {
		return this.cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @return genSpclRtTpCd
	 */
	public String getGenSpclRtTpCd() {
		return this.genSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
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
	 * @return n3ptyCustCntCd
	 */
	public String getN3ptyCustCntCd() {
		return this.n3ptyCustCntCd;
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
	 * @return prnHdnFlg
	 */
	public String getPrnHdnFlg() {
		return this.prnHdnFlg;
	}
	
	/**
	 * Column Info
	 * @return chgUtAmt
	 */
	public String getChgUtAmt() {
		return this.chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @return autoRatCd
	 */
	public String getAutoRatCd() {
		return this.autoRatCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return n3ptyRcvOfcCd
	 */
	public String getN3ptyRcvOfcCd() {
		return this.n3ptyRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return inclOftFlg
	 */
	public String getInclOftFlg() {
		return this.inclOftFlg;
	}
	
	/**
	 * Column Info
	 * @return trfItmNo
	 */
	public String getTrfItmNo() {
		return this.trfItmNo;
	}
	
	/**
	 * Column Info
	 * @return rtSeq
	 */
	public String getRtSeq() {
		return this.rtSeq;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return ratAsQty
	 */
	public String getRatAsQty() {
		return this.ratAsQty;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	

	/**
	 * Column Info
	 * @param noteRtSeq
	 */
	public void setNoteRtSeq(String noteRtSeq) {
		this.noteRtSeq = noteRtSeq;
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
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCustSeq
	 */
	public void setN3ptyCustSeq(String n3ptyCustSeq) {
		this.n3ptyCustSeq = n3ptyCustSeq;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param cgoCateCd
	 */
	public void setCgoCateCd(String cgoCateCd) {
		this.cgoCateCd = cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @param genSpclRtTpCd
	 */
	public void setGenSpclRtTpCd(String genSpclRtTpCd) {
		this.genSpclRtTpCd = genSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
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
	 * @param n3ptyCustCntCd
	 */
	public void setN3ptyCustCntCd(String n3ptyCustCntCd) {
		this.n3ptyCustCntCd = n3ptyCustCntCd;
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
	 * @param prnHdnFlg
	 */
	public void setPrnHdnFlg(String prnHdnFlg) {
		this.prnHdnFlg = prnHdnFlg;
	}
	
	/**
	 * Column Info
	 * @param chgUtAmt
	 */
	public void setChgUtAmt(String chgUtAmt) {
		this.chgUtAmt = chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @param autoRatCd
	 */
	public void setAutoRatCd(String autoRatCd) {
		this.autoRatCd = autoRatCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param n3ptyRcvOfcCd
	 */
	public void setN3ptyRcvOfcCd(String n3ptyRcvOfcCd) {
		this.n3ptyRcvOfcCd = n3ptyRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param inclOftFlg
	 */
	public void setInclOftFlg(String inclOftFlg) {
		this.inclOftFlg = inclOftFlg;
	}
	
	/**
	 * Column Info
	 * @param trfItmNo
	 */
	public void setTrfItmNo(String trfItmNo) {
		this.trfItmNo = trfItmNo;
	}
	
	/**
	 * Column Info
	 * @param rtSeq
	 */
	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param ratAsQty
	 */
	public void setRatAsQty(String ratAsQty) {
		this.ratAsQty = ratAsQty;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * @return the taxFlg
	 */
	public String getTaxFlg() {
		return taxFlg;
	}

	/**
	 * @param taxFlg the taxFlg to set
	 */
	public void setTaxFlg(String taxFlg) {
		this.taxFlg = taxFlg;
	}

	/**
	 * @return the pctBseCd
	 */
	public String getPctBseCd() {
		return pctBseCd;
	}

	/**
	 * @param pctBseCd the pctBseCd to set
	 */
	public void setPctBseCd(String pctBseCd) {
		this.pctBseCd = pctBseCd;
	}
	
	

	/**
	 * @return the saveFlg
	 */
	public String getSaveFlg() {
		return saveFlg;
	}

	/**
	 * @param saveFlg the saveFlg to set
	 */
	public void setSaveFlg(String saveFlg) {
		this.saveFlg = saveFlg;
	}

	/**
	 * @return the ifRmk
	 */
	public String getIfRmk() {
		return ifRmk;
	}

	/**
	 * @param ifRmk the ifRmk to set
	 */
	public void setIfRmk(String ifRmk) {
		this.ifRmk = ifRmk;
	}
	
	/**
	 * @return the dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return dpPrcsKnt;
	}

	/**
	 * @param dpPrcsKnt the dpPrcsKnt to set
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
	}

	public String getVnFlg() {
		return vnFlg;
	}

	public void setVnFlg(String vnFlg) {
		this.vnFlg = vnFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNoteRtSeq(JSPUtil.getParameter(request, "note_rt_seq", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setN3ptyCustSeq(JSPUtil.getParameter(request, "n3pty_cust_seq", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCgoCateCd(JSPUtil.getParameter(request, "cgo_cate_cd", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request, "gen_spcl_rt_tp_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setN3ptyCustCntCd(JSPUtil.getParameter(request, "n3pty_cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPrnHdnFlg(JSPUtil.getParameter(request, "prn_hdn_flg", ""));
		setChgUtAmt(JSPUtil.getParameter(request, "chg_ut_amt", ""));
		setAutoRatCd(JSPUtil.getParameter(request, "auto_rat_cd", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setN3ptyRcvOfcCd(JSPUtil.getParameter(request, "n3pty_rcv_ofc_cd", ""));
		setFrtTermCd(JSPUtil.getParameter(request, "frt_term_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setInclOftFlg(JSPUtil.getParameter(request, "incl_oft_flg", ""));
		setTrfItmNo(JSPUtil.getParameter(request, "trf_itm_no", ""));
		setRtSeq(JSPUtil.getParameter(request, "rt_seq", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setRatAsQty(JSPUtil.getParameter(request, "rat_as_qty", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setTaxFlg(JSPUtil.getParameter(request, "tax_flg", ""));
		setPctBseCd(JSPUtil.getParameter(request, "pct_bse_cd", ""));
		setSaveFlg(JSPUtil.getParameter(request, "save_flg", ""));
		setIfRmk(JSPUtil.getParameter(request, "if_rmk", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, "dp_prcs_knt", ""));
		setVnFlg(JSPUtil.getParameter(request, "vn_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgChgRateVO[]
	 */
	public BkgChgRateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgChgRateVO[]
	 */
	public BkgChgRateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgChgRateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] noteRtSeq = (JSPUtil.getParameter(request, prefix	+ "note_rt_seq", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] n3ptyCustSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_cust_seq", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cgoCateCd = (JSPUtil.getParameter(request, prefix	+ "cgo_cate_cd", length));
			String[] genSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] n3ptyCustCntCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] prnHdnFlg = (JSPUtil.getParameter(request, prefix	+ "prn_hdn_flg", length));
			String[] chgUtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ut_amt", length));
			String[] autoRatCd = (JSPUtil.getParameter(request, prefix	+ "auto_rat_cd", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] n3ptyRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_rcv_ofc_cd", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] inclOftFlg = (JSPUtil.getParameter(request, prefix	+ "incl_oft_flg", length));
			String[] trfItmNo = (JSPUtil.getParameter(request, prefix	+ "trf_itm_no", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] taxFlg = (JSPUtil.getParameter(request, prefix	+ "tax_flg", length));
			String[] pctBseCd = (JSPUtil.getParameter(request, prefix	+ "pct_bse_cd", length));
			String[] saveFlg = (JSPUtil.getParameter(request, prefix	+ "save_flg", length));
			String[] ifRmk = (JSPUtil.getParameter(request, prefix	+ "if_rmk", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] vnFlg = (JSPUtil.getParameter(request, prefix	+ "vn_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgChgRateVO();
				if (noteRtSeq[i] != null)
					model.setNoteRtSeq(noteRtSeq[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (n3ptyCustSeq[i] != null)
					model.setN3ptyCustSeq(n3ptyCustSeq[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cgoCateCd[i] != null)
					model.setCgoCateCd(cgoCateCd[i]);
				if (genSpclRtTpCd[i] != null)
					model.setGenSpclRtTpCd(genSpclRtTpCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (n3ptyCustCntCd[i] != null)
					model.setN3ptyCustCntCd(n3ptyCustCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (prnHdnFlg[i] != null)
					model.setPrnHdnFlg(prnHdnFlg[i]);
				if (chgUtAmt[i] != null)
					model.setChgUtAmt(chgUtAmt[i]);
				if (autoRatCd[i] != null)
					model.setAutoRatCd(autoRatCd[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (n3ptyRcvOfcCd[i] != null)
					model.setN3ptyRcvOfcCd(n3ptyRcvOfcCd[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (inclOftFlg[i] != null)
					model.setInclOftFlg(inclOftFlg[i]);
				if (trfItmNo[i] != null)
					model.setTrfItmNo(trfItmNo[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (ratAsQty[i] != null)
					model.setRatAsQty(ratAsQty[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (taxFlg[i] != null)
					model.setTaxFlg(taxFlg[i]);
				if (pctBseCd[i] != null)
					model.setPctBseCd(pctBseCd[i]);
				if (saveFlg[i] != null)
					model.setSaveFlg(saveFlg[i]);
				if (ifRmk[i] != null)
					model.setIfRmk(ifRmk[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (vnFlg[i] != null)
					model.setVnFlg(vnFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgChgRateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgChgRateVO[]
	 */
	public BkgChgRateVO[] getBkgChgRateVOs(){
		BkgChgRateVO[] vos = (BkgChgRateVO[])models.toArray(new BkgChgRateVO[models.size()]);
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
		this.noteRtSeq = this.noteRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCustSeq = this.n3ptyCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCateCd = this.cgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd = this.genSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCustCntCd = this.n3ptyCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnHdnFlg = this.prnHdnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgUtAmt = this.chgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRatCd = this.autoRatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyRcvOfcCd = this.n3ptyRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclOftFlg = this.inclOftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfItmNo = this.trfItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxFlg = this.taxFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctBseCd = this.pctBseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveFlg = this.saveFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRmk = this.ifRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnFlg = this.vnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
