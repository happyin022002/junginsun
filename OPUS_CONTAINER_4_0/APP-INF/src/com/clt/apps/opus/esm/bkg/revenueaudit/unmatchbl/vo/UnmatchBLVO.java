/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UnmatchBLVO.java
*@FileTitle : UnmatchBLVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.11.24 김대호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo;

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
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UnmatchBLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UnmatchBLVO> models = new ArrayList<UnmatchBLVO>();
	
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String revAudDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String n1stUmchFndDt = null;
	/* Column Info */
	private String umchItmSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String stlMnlDiffAmt = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String lstUmchFndDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ctrtTpCd = null;
	/* Column Info */
	private String ctrtItmLog = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revAudStsCd = null;
	/* Column Info */
	private String stlDt = null;
	/* Column Info */
	private String umchRsnRmk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String stlBkgCorrNo = null;
	/* Column Info */
	private String caFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rgnGrpAvcRmk = null;
	/* Column Info */
	private String umchBkgSeq = null;
	/* Column Info */
	private String ratUtQty = null;
	/* Column Info */
	private String mtchUmchTpCd = null;
	/* Column Info */
	private String bkgCorrNo = null;
	/* Column Info */
	private String maxUmchBkgSeq = null;
	/* Column Info */
	private String corrNo = null;
	/* Column Info */
	private String bkgItmLog = null;
	/* Column Info */
	private String revAudTpCd = null;
	/* Column Info */
	private String stlSysDiffAmt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String umchTpDesc = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String mtchUmchTpDesc = null;
	/* Column Info */
	private String umchTpCd = null;
	/* Column Info */
	private String frtRtAmt = null;
	/* Column Info */
	private String revAudStlKndCd = null;
	/* Column Info */
	private String umchBkgCtrtTpCd = null;
	/* Column Info */
	private String stlUsrId = null;
	/* Column Info */
	private String scRtTp = null;
	/* Column Info */
	private String hinterFlg = null;
	/* Column Info */
	private String frtTermCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UnmatchBLVO() {}

	public UnmatchBLVO(String ibflag, String pagerows, String blNo, String bkgNo, String bkgCorrNo, String bkgItmLog, String bkgStsCd, String caFlg, String chgCd, String corrNo, String ctrtItmLog, String ctrtTpCd, String currCd, String frtRtAmt, String interRmk, String lstUmchFndDt, String maxUmchBkgSeq, String n1stUmchFndDt, String revAudStsCd, String revAudStlKndCd, String ratUtCd, String ratUtQty, String result, String revAudDt, String revAudTpCd, String rgnGrpAvcRmk, String stlBkgCorrNo, String stlDt, String stlMnlDiffAmt, String stlSysDiffAmt, String stlUsrId, String svcScpCd, String umchBkgCtrtTpCd, String umchBkgSeq, String umchItmSeq, String umchTpCd, String umchTpDesc, String mtchUmchTpCd, String mtchUmchTpDesc, String umchRsnRmk, String creUsrId, String creDt, String updUsrId, String updDt, String scRtTp, String hinterFlg, String frtTermCd) {
		this.result = result;
		this.revAudDt = revAudDt;
		this.currCd = currCd;
		this.n1stUmchFndDt = n1stUmchFndDt;
		this.umchItmSeq = umchItmSeq;
		this.svcScpCd = svcScpCd;
		this.stlMnlDiffAmt = stlMnlDiffAmt;
		this.bkgStsCd = bkgStsCd;
		this.lstUmchFndDt = lstUmchFndDt;
		this.creDt = creDt;
		this.ctrtTpCd = ctrtTpCd;
		this.ctrtItmLog = ctrtItmLog;
		this.blNo = blNo;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.revAudStsCd = revAudStsCd;
		this.stlDt = stlDt;
		this.umchRsnRmk = umchRsnRmk;
		this.ibflag = ibflag;
		this.interRmk = interRmk;
		this.stlBkgCorrNo = stlBkgCorrNo;
		this.caFlg = caFlg;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.rgnGrpAvcRmk = rgnGrpAvcRmk;
		this.umchBkgSeq = umchBkgSeq;
		this.ratUtQty = ratUtQty;
		this.mtchUmchTpCd = mtchUmchTpCd;
		this.bkgCorrNo = bkgCorrNo;
		this.maxUmchBkgSeq = maxUmchBkgSeq;
		this.corrNo = corrNo;
		this.bkgItmLog = bkgItmLog;
		this.revAudTpCd = revAudTpCd;
		this.stlSysDiffAmt = stlSysDiffAmt;
		this.ratUtCd = ratUtCd;
		this.creUsrId = creUsrId;
		this.umchTpDesc = umchTpDesc;
		this.bkgNo = bkgNo;
		this.mtchUmchTpDesc = mtchUmchTpDesc;
		this.umchTpCd = umchTpCd;
		this.frtRtAmt = frtRtAmt;
		this.revAudStlKndCd = revAudStlKndCd;
		this.umchBkgCtrtTpCd = umchBkgCtrtTpCd;
		this.stlUsrId = stlUsrId;
		this.scRtTp = scRtTp;
		this.hinterFlg = hinterFlg;
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("rev_aud_dt", getRevAudDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("n1st_umch_fnd_dt", getN1stUmchFndDt());
		this.hashColumns.put("umch_itm_seq", getUmchItmSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("stl_mnl_diff_amt", getStlMnlDiffAmt());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("lst_umch_fnd_dt", getLstUmchFndDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ctrt_tp_cd", getCtrtTpCd());
		this.hashColumns.put("ctrt_itm_log", getCtrtItmLog());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_aud_sts_cd", getRevAudStsCd());
		this.hashColumns.put("stl_dt", getStlDt());
		this.hashColumns.put("umch_rsn_rmk", getUmchRsnRmk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("stl_bkg_corr_no", getStlBkgCorrNo());
		this.hashColumns.put("ca_flg", getCaFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rgn_grp_avc_rmk", getRgnGrpAvcRmk());
		this.hashColumns.put("umch_bkg_seq", getUmchBkgSeq());
		this.hashColumns.put("rat_ut_qty", getRatUtQty());
		this.hashColumns.put("mtch_umch_tp_cd", getMtchUmchTpCd());
		this.hashColumns.put("bkg_corr_no", getBkgCorrNo());
		this.hashColumns.put("max_umch_bkg_seq", getMaxUmchBkgSeq());
		this.hashColumns.put("corr_no", getCorrNo());
		this.hashColumns.put("bkg_itm_log", getBkgItmLog());
		this.hashColumns.put("rev_aud_tp_cd", getRevAudTpCd());
		this.hashColumns.put("stl_sys_diff_amt", getStlSysDiffAmt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("umch_tp_desc", getUmchTpDesc());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("mtch_umch_tp_desc", getMtchUmchTpDesc());
		this.hashColumns.put("umch_tp_cd", getUmchTpCd());
		this.hashColumns.put("frt_rt_amt", getFrtRtAmt());
		this.hashColumns.put("rev_aud_stl_knd_cd", getRevAudStlKndCd());
		this.hashColumns.put("umch_bkg_ctrt_tp_cd", getUmchBkgCtrtTpCd());
		this.hashColumns.put("stl_usr_id", getStlUsrId());
		this.hashColumns.put("sc_rt_tp", getScRtTp());
		this.hashColumns.put("hinter_flg", getHinterFlg());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("result", "result");
		this.hashFields.put("rev_aud_dt", "revAudDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("n1st_umch_fnd_dt", "n1stUmchFndDt");
		this.hashFields.put("umch_itm_seq", "umchItmSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("stl_mnl_diff_amt", "stlMnlDiffAmt");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("lst_umch_fnd_dt", "lstUmchFndDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ctrt_tp_cd", "ctrtTpCd");
		this.hashFields.put("ctrt_itm_log", "ctrtItmLog");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_aud_sts_cd", "revAudStsCd");
		this.hashFields.put("stl_dt", "stlDt");
		this.hashFields.put("umch_rsn_rmk", "umchRsnRmk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("stl_bkg_corr_no", "stlBkgCorrNo");
		this.hashFields.put("ca_flg", "caFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rgn_grp_avc_rmk", "rgnGrpAvcRmk");
		this.hashFields.put("umch_bkg_seq", "umchBkgSeq");
		this.hashFields.put("rat_ut_qty", "ratUtQty");
		this.hashFields.put("mtch_umch_tp_cd", "mtchUmchTpCd");
		this.hashFields.put("bkg_corr_no", "bkgCorrNo");
		this.hashFields.put("max_umch_bkg_seq", "maxUmchBkgSeq");
		this.hashFields.put("corr_no", "corrNo");
		this.hashFields.put("bkg_itm_log", "bkgItmLog");
		this.hashFields.put("rev_aud_tp_cd", "revAudTpCd");
		this.hashFields.put("stl_sys_diff_amt", "stlSysDiffAmt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("umch_tp_desc", "umchTpDesc");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("mtch_umch_tp_desc", "mtchUmchTpDesc");
		this.hashFields.put("umch_tp_cd", "umchTpCd");
		this.hashFields.put("frt_rt_amt", "frtRtAmt");
		this.hashFields.put("rev_aud_stl_knd_cd", "revAudStlKndCd");
		this.hashFields.put("umch_bkg_ctrt_tp_cd", "umchBkgCtrtTpCd");
		this.hashFields.put("stl_usr_id", "stlUsrId");
		this.hashFields.put("sc_rt_tp", "scRtTp");
		this.hashFields.put("hinter_flg", "hinterFlg");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Column Info
	 * @return revAudDt
	 */
	public String getRevAudDt() {
		return this.revAudDt;
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
	 * @return n1stUmchFndDt
	 */
	public String getN1stUmchFndDt() {
		return this.n1stUmchFndDt;
	}
	
	/**
	 * Column Info
	 * @return umchItmSeq
	 */
	public String getUmchItmSeq() {
		return this.umchItmSeq;
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
	 * @return stlMnlDiffAmt
	 */
	public String getStlMnlDiffAmt() {
		return this.stlMnlDiffAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return lstUmchFndDt
	 */
	public String getLstUmchFndDt() {
		return this.lstUmchFndDt;
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
	 * @return ctrtTpCd
	 */
	public String getCtrtTpCd() {
		return this.ctrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtItmLog
	 */
	public String getCtrtItmLog() {
		return this.ctrtItmLog;
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
	 * Column Info
	 * @return revAudStsCd
	 */
	public String getRevAudStsCd() {
		return this.revAudStsCd;
	}
	
	/**
	 * Column Info
	 * @return stlDt
	 */
	public String getStlDt() {
		return this.stlDt;
	}
	
	/**
	 * Column Info
	 * @return umchRsnRmk
	 */
	public String getUmchRsnRmk() {
		return this.umchRsnRmk;
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
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return stlBkgCorrNo
	 */
	public String getStlBkgCorrNo() {
		return this.stlBkgCorrNo;
	}
	
	/**
	 * Column Info
	 * @return caFlg
	 */
	public String getCaFlg() {
		return this.caFlg;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return rgnGrpAvcRmk
	 */
	public String getRgnGrpAvcRmk() {
		return this.rgnGrpAvcRmk;
	}
	
	/**
	 * Column Info
	 * @return umchBkgSeq
	 */
	public String getUmchBkgSeq() {
		return this.umchBkgSeq;
	}
	
	/**
	 * Column Info
	 * @return ratUtQty
	 */
	public String getRatUtQty() {
		return this.ratUtQty;
	}
	
	/**
	 * Column Info
	 * @return mtchUmchTpCd
	 */
	public String getMtchUmchTpCd() {
		return this.mtchUmchTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCorrNo
	 */
	public String getBkgCorrNo() {
		return this.bkgCorrNo;
	}
	
	/**
	 * Column Info
	 * @return maxUmchBkgSeq
	 */
	public String getMaxUmchBkgSeq() {
		return this.maxUmchBkgSeq;
	}
	
	/**
	 * Column Info
	 * @return corrNo
	 */
	public String getCorrNo() {
		return this.corrNo;
	}
	
	/**
	 * Column Info
	 * @return bkgItmLog
	 */
	public String getBkgItmLog() {
		return this.bkgItmLog;
	}
	
	/**
	 * Column Info
	 * @return revAudTpCd
	 */
	public String getRevAudTpCd() {
		return this.revAudTpCd;
	}
	
	/**
	 * Column Info
	 * @return stlSysDiffAmt
	 */
	public String getStlSysDiffAmt() {
		return this.stlSysDiffAmt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return umchTpDesc
	 */
	public String getUmchTpDesc() {
		return this.umchTpDesc;
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
	 * @return mtchUmchTpDesc
	 */
	public String getMtchUmchTpDesc() {
		return this.mtchUmchTpDesc;
	}
	
	/**
	 * Column Info
	 * @return umchTpCd
	 */
	public String getUmchTpCd() {
		return this.umchTpCd;
	}
	
	/**
	 * Column Info
	 * @return frtRtAmt
	 */
	public String getFrtRtAmt() {
		return this.frtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return revAudStlKndCd
	 */
	public String getRevAudStlKndCd() {
		return this.revAudStlKndCd;
	}
	
	/**
	 * Column Info
	 * @return umchBkgCtrtTpCd
	 */
	public String getUmchBkgCtrtTpCd() {
		return this.umchBkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return stlUsrId
	 */
	public String getStlUsrId() {
		return this.stlUsrId;
	}
	
	/**
	 * Column Info
	 * @return scRtTp
	 */
	public String getScRtTp() {
		return this.scRtTp;
	}
	
	/**
	 * Column Info
	 * @return hinterFlg
	 */
	public String getHinterFlg() {
		return this.hinterFlg;
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
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Column Info
	 * @param revAudDt
	 */
	public void setRevAudDt(String revAudDt) {
		this.revAudDt = revAudDt;
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
	 * @param n1stUmchFndDt
	 */
	public void setN1stUmchFndDt(String n1stUmchFndDt) {
		this.n1stUmchFndDt = n1stUmchFndDt;
	}
	
	/**
	 * Column Info
	 * @param umchItmSeq
	 */
	public void setUmchItmSeq(String umchItmSeq) {
		this.umchItmSeq = umchItmSeq;
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
	 * @param stlMnlDiffAmt
	 */
	public void setStlMnlDiffAmt(String stlMnlDiffAmt) {
		this.stlMnlDiffAmt = stlMnlDiffAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param lstUmchFndDt
	 */
	public void setLstUmchFndDt(String lstUmchFndDt) {
		this.lstUmchFndDt = lstUmchFndDt;
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
	 * @param ctrtTpCd
	 */
	public void setCtrtTpCd(String ctrtTpCd) {
		this.ctrtTpCd = ctrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtItmLog
	 */
	public void setCtrtItmLog(String ctrtItmLog) {
		this.ctrtItmLog = ctrtItmLog;
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
	 * Column Info
	 * @param revAudStsCd
	 */
	public void setRevAudStsCd(String revAudStsCd) {
		this.revAudStsCd = revAudStsCd;
	}
	
	/**
	 * Column Info
	 * @param stlDt
	 */
	public void setStlDt(String stlDt) {
		this.stlDt = stlDt;
	}
	
	/**
	 * Column Info
	 * @param umchRsnRmk
	 */
	public void setUmchRsnRmk(String umchRsnRmk) {
		this.umchRsnRmk = umchRsnRmk;
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
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param stlBkgCorrNo
	 */
	public void setStlBkgCorrNo(String stlBkgCorrNo) {
		this.stlBkgCorrNo = stlBkgCorrNo;
	}
	
	/**
	 * Column Info
	 * @param caFlg
	 */
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param rgnGrpAvcRmk
	 */
	public void setRgnGrpAvcRmk(String rgnGrpAvcRmk) {
		this.rgnGrpAvcRmk = rgnGrpAvcRmk;
	}
	
	/**
	 * Column Info
	 * @param umchBkgSeq
	 */
	public void setUmchBkgSeq(String umchBkgSeq) {
		this.umchBkgSeq = umchBkgSeq;
	}
	
	/**
	 * Column Info
	 * @param ratUtQty
	 */
	public void setRatUtQty(String ratUtQty) {
		this.ratUtQty = ratUtQty;
	}
	
	/**
	 * Column Info
	 * @param mtchUmchTpCd
	 */
	public void setMtchUmchTpCd(String mtchUmchTpCd) {
		this.mtchUmchTpCd = mtchUmchTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCorrNo
	 */
	public void setBkgCorrNo(String bkgCorrNo) {
		this.bkgCorrNo = bkgCorrNo;
	}
	
	/**
	 * Column Info
	 * @param maxUmchBkgSeq
	 */
	public void setMaxUmchBkgSeq(String maxUmchBkgSeq) {
		this.maxUmchBkgSeq = maxUmchBkgSeq;
	}
	
	/**
	 * Column Info
	 * @param corrNo
	 */
	public void setCorrNo(String corrNo) {
		this.corrNo = corrNo;
	}
	
	/**
	 * Column Info
	 * @param bkgItmLog
	 */
	public void setBkgItmLog(String bkgItmLog) {
		this.bkgItmLog = bkgItmLog;
	}
	
	/**
	 * Column Info
	 * @param revAudTpCd
	 */
	public void setRevAudTpCd(String revAudTpCd) {
		this.revAudTpCd = revAudTpCd;
	}
	
	/**
	 * Column Info
	 * @param stlSysDiffAmt
	 */
	public void setStlSysDiffAmt(String stlSysDiffAmt) {
		this.stlSysDiffAmt = stlSysDiffAmt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param umchTpDesc
	 */
	public void setUmchTpDesc(String umchTpDesc) {
		this.umchTpDesc = umchTpDesc;
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
	 * @param mtchUmchTpDesc
	 */
	public void setMtchUmchTpDesc(String mtchUmchTpDesc) {
		this.mtchUmchTpDesc = mtchUmchTpDesc;
	}
	
	/**
	 * Column Info
	 * @param umchTpCd
	 */
	public void setUmchTpCd(String umchTpCd) {
		this.umchTpCd = umchTpCd;
	}
	
	/**
	 * Column Info
	 * @param frtRtAmt
	 */
	public void setFrtRtAmt(String frtRtAmt) {
		this.frtRtAmt = frtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param revAudStlKndCd
	 */
	public void setRevAudStlKndCd(String revAudStlKndCd) {
		this.revAudStlKndCd = revAudStlKndCd;
	}
	
	/**
	 * Column Info
	 * @param umchBkgCtrtTpCd
	 */
	public void setUmchBkgCtrtTpCd(String umchBkgCtrtTpCd) {
		this.umchBkgCtrtTpCd = umchBkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param stlUsrId
	 */
	public void setStlUsrId(String stlUsrId) {
		this.stlUsrId = stlUsrId;
	}
	
	/**
	 * Column Info
	 * @param scRtTp
	 */
	public void setScRtTp(String scRtTp) {
		this.scRtTp = scRtTp;
	}
	
	/**
	 * Column Info
	 * @param hinterFlg
	 */
	public void setHinterFlg(String hinterFlg) {
		this.hinterFlg = hinterFlg;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setResult(JSPUtil.getParameter(request, "result", ""));
		setRevAudDt(JSPUtil.getParameter(request, "rev_aud_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setN1stUmchFndDt(JSPUtil.getParameter(request, "n1st_umch_fnd_dt", ""));
		setUmchItmSeq(JSPUtil.getParameter(request, "umch_itm_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setStlMnlDiffAmt(JSPUtil.getParameter(request, "stl_mnl_diff_amt", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setLstUmchFndDt(JSPUtil.getParameter(request, "lst_umch_fnd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCtrtTpCd(JSPUtil.getParameter(request, "ctrt_tp_cd", ""));
		setCtrtItmLog(JSPUtil.getParameter(request, "ctrt_itm_log", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRevAudStsCd(JSPUtil.getParameter(request, "rev_aud_sts_cd", ""));
		setStlDt(JSPUtil.getParameter(request, "stl_dt", ""));
		setUmchRsnRmk(JSPUtil.getParameter(request, "umch_rsn_rmk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInterRmk(JSPUtil.getParameter(request, "inter_rmk", ""));
		setStlBkgCorrNo(JSPUtil.getParameter(request, "stl_bkg_corr_no", ""));
		setCaFlg(JSPUtil.getParameter(request, "ca_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRgnGrpAvcRmk(JSPUtil.getParameter(request, "rgn_grp_avc_rmk", ""));
		setUmchBkgSeq(JSPUtil.getParameter(request, "umch_bkg_seq", ""));
		setRatUtQty(JSPUtil.getParameter(request, "rat_ut_qty", ""));
		setMtchUmchTpCd(JSPUtil.getParameter(request, "mtch_umch_tp_cd", ""));
		setBkgCorrNo(JSPUtil.getParameter(request, "bkg_corr_no", ""));
		setMaxUmchBkgSeq(JSPUtil.getParameter(request, "max_umch_bkg_seq", ""));
		setCorrNo(JSPUtil.getParameter(request, "corr_no", ""));
		setBkgItmLog(JSPUtil.getParameter(request, "bkg_itm_log", ""));
		setRevAudTpCd(JSPUtil.getParameter(request, "rev_aud_tp_cd", ""));
		setStlSysDiffAmt(JSPUtil.getParameter(request, "stl_sys_diff_amt", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUmchTpDesc(JSPUtil.getParameter(request, "umch_tp_desc", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setMtchUmchTpDesc(JSPUtil.getParameter(request, "mtch_umch_tp_desc", ""));
		setUmchTpCd(JSPUtil.getParameter(request, "umch_tp_cd", ""));
		setFrtRtAmt(JSPUtil.getParameter(request, "frt_rt_amt", ""));
		setRevAudStlKndCd(JSPUtil.getParameter(request, "rev_aud_stl_knd_cd", ""));
		setUmchBkgCtrtTpCd(JSPUtil.getParameter(request, "umch_bkg_ctrt_tp_cd", ""));
		setStlUsrId(JSPUtil.getParameter(request, "stl_usr_id", ""));
		setScRtTp(JSPUtil.getParameter(request, "sc_rt_tp", ""));
		setHinterFlg(JSPUtil.getParameter(request, "hinter_flg", ""));
		setFrtTermCd(JSPUtil.getParameter(request, "frt_term_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UnmatchBLVO[]
	 */
	public UnmatchBLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UnmatchBLVO[]
	 */
	public UnmatchBLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UnmatchBLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] revAudDt = (JSPUtil.getParameter(request, prefix	+ "rev_aud_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] n1stUmchFndDt = (JSPUtil.getParameter(request, prefix	+ "n1st_umch_fnd_dt", length));
			String[] umchItmSeq = (JSPUtil.getParameter(request, prefix	+ "umch_itm_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] stlMnlDiffAmt = (JSPUtil.getParameter(request, prefix	+ "stl_mnl_diff_amt", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] lstUmchFndDt = (JSPUtil.getParameter(request, prefix	+ "lst_umch_fnd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ctrtTpCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_tp_cd", length));
			String[] ctrtItmLog = (JSPUtil.getParameter(request, prefix	+ "ctrt_itm_log", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revAudStsCd = (JSPUtil.getParameter(request, prefix	+ "rev_aud_sts_cd", length));
			String[] stlDt = (JSPUtil.getParameter(request, prefix	+ "stl_dt", length));
			String[] umchRsnRmk = (JSPUtil.getParameter(request, prefix	+ "umch_rsn_rmk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] stlBkgCorrNo = (JSPUtil.getParameter(request, prefix	+ "stl_bkg_corr_no", length));
			String[] caFlg = (JSPUtil.getParameter(request, prefix	+ "ca_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rgnGrpAvcRmk = (JSPUtil.getParameter(request, prefix	+ "rgn_grp_avc_rmk", length));
			String[] umchBkgSeq = (JSPUtil.getParameter(request, prefix	+ "umch_bkg_seq", length));
			String[] ratUtQty = (JSPUtil.getParameter(request, prefix	+ "rat_ut_qty", length));
			String[] mtchUmchTpCd = (JSPUtil.getParameter(request, prefix	+ "mtch_umch_tp_cd", length));
			String[] bkgCorrNo = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_no", length));
			String[] maxUmchBkgSeq = (JSPUtil.getParameter(request, prefix	+ "max_umch_bkg_seq", length));
			String[] corrNo = (JSPUtil.getParameter(request, prefix	+ "corr_no", length));
			String[] bkgItmLog = (JSPUtil.getParameter(request, prefix	+ "bkg_itm_log", length));
			String[] revAudTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_aud_tp_cd", length));
			String[] stlSysDiffAmt = (JSPUtil.getParameter(request, prefix	+ "stl_sys_diff_amt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] umchTpDesc = (JSPUtil.getParameter(request, prefix	+ "umch_tp_desc", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] mtchUmchTpDesc = (JSPUtil.getParameter(request, prefix	+ "mtch_umch_tp_desc", length));
			String[] umchTpCd = (JSPUtil.getParameter(request, prefix	+ "umch_tp_cd", length));
			String[] frtRtAmt = (JSPUtil.getParameter(request, prefix	+ "frt_rt_amt", length));
			String[] revAudStlKndCd = (JSPUtil.getParameter(request, prefix	+ "rev_aud_stl_knd_cd", length));
			String[] umchBkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "umch_bkg_ctrt_tp_cd", length));
			String[] stlUsrId = (JSPUtil.getParameter(request, prefix	+ "stl_usr_id", length));
			String[] scRtTp = (JSPUtil.getParameter(request, prefix	+ "sc_rt_tp", length));
			String[] hinterFlg = (JSPUtil.getParameter(request, prefix	+ "hinter_flg", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new UnmatchBLVO();
				if (result[i] != null)
					model.setResult(result[i]);
				if (revAudDt[i] != null)
					model.setRevAudDt(revAudDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (n1stUmchFndDt[i] != null)
					model.setN1stUmchFndDt(n1stUmchFndDt[i]);
				if (umchItmSeq[i] != null)
					model.setUmchItmSeq(umchItmSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (stlMnlDiffAmt[i] != null)
					model.setStlMnlDiffAmt(stlMnlDiffAmt[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (lstUmchFndDt[i] != null)
					model.setLstUmchFndDt(lstUmchFndDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ctrtTpCd[i] != null)
					model.setCtrtTpCd(ctrtTpCd[i]);
				if (ctrtItmLog[i] != null)
					model.setCtrtItmLog(ctrtItmLog[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revAudStsCd[i] != null)
					model.setRevAudStsCd(revAudStsCd[i]);
				if (stlDt[i] != null)
					model.setStlDt(stlDt[i]);
				if (umchRsnRmk[i] != null)
					model.setUmchRsnRmk(umchRsnRmk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (stlBkgCorrNo[i] != null)
					model.setStlBkgCorrNo(stlBkgCorrNo[i]);
				if (caFlg[i] != null)
					model.setCaFlg(caFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rgnGrpAvcRmk[i] != null)
					model.setRgnGrpAvcRmk(rgnGrpAvcRmk[i]);
				if (umchBkgSeq[i] != null)
					model.setUmchBkgSeq(umchBkgSeq[i]);
				if (ratUtQty[i] != null)
					model.setRatUtQty(ratUtQty[i]);
				if (mtchUmchTpCd[i] != null)
					model.setMtchUmchTpCd(mtchUmchTpCd[i]);
				if (bkgCorrNo[i] != null)
					model.setBkgCorrNo(bkgCorrNo[i]);
				if (maxUmchBkgSeq[i] != null)
					model.setMaxUmchBkgSeq(maxUmchBkgSeq[i]);
				if (corrNo[i] != null)
					model.setCorrNo(corrNo[i]);
				if (bkgItmLog[i] != null)
					model.setBkgItmLog(bkgItmLog[i]);
				if (revAudTpCd[i] != null)
					model.setRevAudTpCd(revAudTpCd[i]);
				if (stlSysDiffAmt[i] != null)
					model.setStlSysDiffAmt(stlSysDiffAmt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (umchTpDesc[i] != null)
					model.setUmchTpDesc(umchTpDesc[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (mtchUmchTpDesc[i] != null)
					model.setMtchUmchTpDesc(mtchUmchTpDesc[i]);
				if (umchTpCd[i] != null)
					model.setUmchTpCd(umchTpCd[i]);
				if (frtRtAmt[i] != null)
					model.setFrtRtAmt(frtRtAmt[i]);
				if (revAudStlKndCd[i] != null)
					model.setRevAudStlKndCd(revAudStlKndCd[i]);
				if (umchBkgCtrtTpCd[i] != null)
					model.setUmchBkgCtrtTpCd(umchBkgCtrtTpCd[i]);
				if (stlUsrId[i] != null)
					model.setStlUsrId(stlUsrId[i]);
				if (scRtTp[i] != null)
					model.setScRtTp(scRtTp[i]);
				if (hinterFlg[i] != null)
					model.setHinterFlg(hinterFlg[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUnmatchBLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UnmatchBLVO[]
	 */
	public UnmatchBLVO[] getUnmatchBLVOs(){
		UnmatchBLVO[] vos = (UnmatchBLVO[])models.toArray(new UnmatchBLVO[models.size()]);
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
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudDt = this.revAudDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stUmchFndDt = this.n1stUmchFndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchItmSeq = this.umchItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlMnlDiffAmt = this.stlMnlDiffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstUmchFndDt = this.lstUmchFndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtTpCd = this.ctrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtItmLog = this.ctrtItmLog .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudStsCd = this.revAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlDt = this.stlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchRsnRmk = this.umchRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlBkgCorrNo = this.stlBkgCorrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlg = this.caFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnGrpAvcRmk = this.rgnGrpAvcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchBkgSeq = this.umchBkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtQty = this.ratUtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtchUmchTpCd = this.mtchUmchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrNo = this.bkgCorrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxUmchBkgSeq = this.maxUmchBkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrNo = this.corrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgItmLog = this.bkgItmLog .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudTpCd = this.revAudTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlSysDiffAmt = this.stlSysDiffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchTpDesc = this.umchTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtchUmchTpDesc = this.mtchUmchTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchTpCd = this.umchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtRtAmt = this.frtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudStlKndCd = this.revAudStlKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchBkgCtrtTpCd = this.umchBkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlUsrId = this.stlUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRtTp = this.scRtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hinterFlg = this.hinterFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
