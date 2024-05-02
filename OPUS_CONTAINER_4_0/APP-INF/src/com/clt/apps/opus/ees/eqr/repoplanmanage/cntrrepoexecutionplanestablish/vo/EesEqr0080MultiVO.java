/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0080MultiVO.java
*@FileTitle : EesEqr0080MultiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.28 정은호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0080MultiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0080MultiVO> models = new ArrayList<EesEqr0080MultiVO>();
	
	/* Column Info */
	private String repoMtyBkgFlg = null;
	/* Column Info */
	private String fmYdCd = null;
	/* Column Info */
	private String div = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String soCancelFlag = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String trspModCd = null;
	/* Column Info */
	private String toYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslLaneCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pastRepoPlnFlg = null;
	/* Column Info */
	private String toEtaDt = null;
	/* Column Info */
	private String fmEtdDt = null;
	/* Column Info */
	private String repoPlnFbRsnCd = null;
	/* Column Info */
	private String eqRepoPurpCd = null;
	/* Column Info */
	private String frlocEcc = null;
	/* Column Info */
	private String soIssFlg = null;
	/* Column Info */
	private String frlocRcc = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String tolocEcc = null;
	/* Column Info */
	private String cntrno = null;
	/* Column Info */
	private String plnSeq = null;
	/* Column Info */
	private String repoPlnId = "";
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String repobkgFlag = null;
	/* Column Info */
	private String cntrDel = null;
	/* Column Info */
	private String tpszno = null;
	/* Column Info */
	private String repoPlnFbRmk = null;
	
	private String vpsPort	= null;
	private String mtyBkgNo	= null;
	private String updUsrId	= null;

	/* input Param */
	/*
	 * type size 순서대로 해당 value를 담기위한 변수
	 */
	private List<String> tpszList = null;
	private List<String> volList = null;
	private List<String> costList = null;
	private List<String> flagList = null;
	private List<String> unitcostList = null;
	private List<String> fromcostList = null;
	private List<String> tocostList = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0080MultiVO() {}

	public EesEqr0080MultiVO(String ibflag, String pagerows, String repoPlnId, String refId, String plnYrwk, String coCd, String div, String trspModCd, String fmYdCd, String fmEtdDt, String toYdCd, String toEtaDt, String repoMtyBkgFlg, String repoPlnFbRsnCd, String repoPlnFbRmk, String eqRepoPurpCd, String vslLaneCd, String vvd, String soIssFlg, String cntrno, String tpszno, String cntrDel, String repobkgFlag, String soCancelFlag, String frlocRcc, String frlocEcc, String tolocEcc, String pastRepoPlnFlg, String plnSeq, String vpsPort) {
		this.repoMtyBkgFlg = repoMtyBkgFlg;
		this.fmYdCd = fmYdCd;
		this.div = div;
		this.refId = refId;
		this.soCancelFlag = soCancelFlag;
		this.plnYrwk = plnYrwk;
		this.trspModCd = trspModCd;
		this.toYdCd = toYdCd;
		this.pagerows = pagerows;
		this.vslLaneCd = vslLaneCd;
		this.ibflag = ibflag;
		this.pastRepoPlnFlg = pastRepoPlnFlg;
		this.toEtaDt = toEtaDt;
		this.fmEtdDt = fmEtdDt;
		this.repoPlnFbRsnCd = repoPlnFbRsnCd;
		this.eqRepoPurpCd = eqRepoPurpCd;
		this.frlocEcc = frlocEcc;
		this.soIssFlg = soIssFlg;
		this.frlocRcc = frlocRcc;
		this.coCd = coCd;
		this.tolocEcc = tolocEcc;
		this.cntrno = cntrno;
		this.plnSeq = plnSeq;
		this.repoPlnId = repoPlnId;
		this.vvd = vvd;
		this.repobkgFlag = repobkgFlag;
		this.cntrDel = cntrDel;
		this.tpszno = tpszno;
		this.repoPlnFbRmk = repoPlnFbRmk;
		this.vpsPort = vpsPort;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("repo_mty_bkg_flg", getRepoMtyBkgFlg());
		this.hashColumns.put("fm_yd_cd", getFmYdCd());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("so_cancel_flag", getSoCancelFlag());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("to_yd_cd", getToYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_lane_cd", getVslLaneCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("past_repo_pln_flg", getPastRepoPlnFlg());
		this.hashColumns.put("to_eta_dt", getToEtaDt());
		this.hashColumns.put("fm_etd_dt", getFmEtdDt());
		this.hashColumns.put("repo_pln_fb_rsn_cd", getRepoPlnFbRsnCd());
		this.hashColumns.put("eq_repo_purp_cd", getEqRepoPurpCd());
		this.hashColumns.put("frloc_ecc", getFrlocEcc());
		this.hashColumns.put("so_iss_flg", getSoIssFlg());
		this.hashColumns.put("frloc_rcc", getFrlocRcc());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("toloc_ecc", getTolocEcc());
		this.hashColumns.put("cntrno", getCntrno());
		this.hashColumns.put("pln_seq", getPlnSeq());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("repobkg_flag", getRepobkgFlag());
		this.hashColumns.put("cntr_del", getCntrDel());
		this.hashColumns.put("tpszno", getTpszno());
		this.hashColumns.put("repo_pln_fb_rmk", getRepoPlnFbRmk());
		this.hashColumns.put("mty_bkg_no", getMtyBkgNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vpsPort", getVpsPort());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("repo_mty_bkg_flg", "repoMtyBkgFlg");
		this.hashFields.put("fm_yd_cd", "fmYdCd");
		this.hashFields.put("div", "div");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("so_cancel_flag", "soCancelFlag");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("to_yd_cd", "toYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_lane_cd", "vslLaneCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("past_repo_pln_flg", "pastRepoPlnFlg");
		this.hashFields.put("to_eta_dt", "toEtaDt");
		this.hashFields.put("fm_etd_dt", "fmEtdDt");
		this.hashFields.put("repo_pln_fb_rsn_cd", "repoPlnFbRsnCd");
		this.hashFields.put("eq_repo_purp_cd", "eqRepoPurpCd");
		this.hashFields.put("frloc_ecc", "frlocEcc");
		this.hashFields.put("so_iss_flg", "soIssFlg");
		this.hashFields.put("frloc_rcc", "frlocRcc");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("toloc_ecc", "tolocEcc");
		this.hashFields.put("cntrno", "cntrno");
		this.hashFields.put("pln_seq", "plnSeq");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("repobkg_flag", "repobkgFlag");
		this.hashFields.put("cntr_del", "cntrDel");
		this.hashFields.put("tpszno", "tpszno");
		this.hashFields.put("repo_pln_fb_rmk", "repoPlnFbRmk");
		this.hashFields.put("vpsPort","vpsPort");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return repoMtyBkgFlg
	 */
	public String getRepoMtyBkgFlg() {
		return this.repoMtyBkgFlg;
	}
	
	/**
	 * Column Info
	 * @return fmYdCd
	 */
	public String getFmYdCd() {
		return this.fmYdCd;
	}
	
	/**
	 * Column Info
	 * @return div
	 */
	public String getDiv() {
		return this.div;
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
	 * @return soCancelFlag
	 */
	public String getSoCancelFlag() {
		return this.soCancelFlag;
	}
	
	/**
	 * Column Info
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
	}
	
	/**
	 * Column Info
	 * @return toYdCd
	 */
	public String getToYdCd() {
		return this.toYdCd;
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
	 * @return vslLaneCd
	 */
	public String getVslLaneCd() {
		return this.vslLaneCd;
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
	 * @return pastRepoPlnFlg
	 */
	public String getPastRepoPlnFlg() {
		return this.pastRepoPlnFlg;
	}
	
	/**
	 * Column Info
	 * @return toEtaDt
	 */
	public String getToEtaDt() {
		return this.toEtaDt;
	}
	
	/**
	 * Column Info
	 * @return fmEtdDt
	 */
	public String getFmEtdDt() {
		return this.fmEtdDt;
	}
	
	/**
	 * Column Info
	 * @return repoPlnFbRsnCd
	 */
	public String getRepoPlnFbRsnCd() {
		return this.repoPlnFbRsnCd;
	}
	
	/**
	 * Column Info
	 * @return eqRepoPurpCd
	 */
	public String getEqRepoPurpCd() {
		return this.eqRepoPurpCd;
	}
	
	/**
	 * Column Info
	 * @return frlocEcc
	 */
	public String getFrlocEcc() {
		return this.frlocEcc;
	}
	
	/**
	 * Column Info
	 * @return soIssFlg
	 */
	public String getSoIssFlg() {
		return this.soIssFlg;
	}
	
	/**
	 * Column Info
	 * @return frlocRcc
	 */
	public String getFrlocRcc() {
		return this.frlocRcc;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return tolocEcc
	 */
	public String getTolocEcc() {
		return this.tolocEcc;
	}
	
	/**
	 * Column Info
	 * @return cntrno
	 */
	public String getCntrno() {
		return this.cntrno;
	}
	
	/**
	 * Column Info
	 * @return plnSeq
	 */
	public String getPlnSeq() {
		return this.plnSeq;
	}
	
	/**
	 * Column Info
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
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
	 * @return repobkgFlag
	 */
	public String getRepobkgFlag() {
		return this.repobkgFlag;
	}
	
	/**
	 * Column Info
	 * @return cntrDel
	 */
	public String getCntrDel() {
		return this.cntrDel;
	}
	
	/**
	 * Column Info
	 * @return tpszno
	 */
	public String getTpszno() {
		return this.tpszno;
	}
	
	/**
	 * Column Info
	 * @return repoPlnFbRmk
	 */
	public String getRepoPlnFbRmk() {
		return this.repoPlnFbRmk;
	}
	
	public String getVpsPort() {
		return vpsPort;
	}

	public void setVpsPort(String vpsPort) {
		this.vpsPort = vpsPort;
	}

	/**
	 * Column Info
	 * @param repoMtyBkgFlg
	 */
	public void setRepoMtyBkgFlg(String repoMtyBkgFlg) {
		this.repoMtyBkgFlg = repoMtyBkgFlg;
	}
	
	/**
	 * Column Info
	 * @param fmYdCd
	 */
	public void setFmYdCd(String fmYdCd) {
		this.fmYdCd = fmYdCd;
	}
	
	/**
	 * Column Info
	 * @param div
	 */
	public void setDiv(String div) {
		this.div = div;
	}
	
	/**
	 * Column Info
	 * @param refId
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}
	
	/**
	 * Column Info
	 * @param soCancelFlag
	 */
	public void setSoCancelFlag(String soCancelFlag) {
		this.soCancelFlag = soCancelFlag;
	}
	
	/**
	 * Column Info
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
	}
	
	/**
	 * Column Info
	 * @param toYdCd
	 */
	public void setToYdCd(String toYdCd) {
		this.toYdCd = toYdCd;
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
	 * @param vslLaneCd
	 */
	public void setVslLaneCd(String vslLaneCd) {
		this.vslLaneCd = vslLaneCd;
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
	 * @param pastRepoPlnFlg
	 */
	public void setPastRepoPlnFlg(String pastRepoPlnFlg) {
		this.pastRepoPlnFlg = pastRepoPlnFlg;
	}
	
	/**
	 * Column Info
	 * @param toEtaDt
	 */
	public void setToEtaDt(String toEtaDt) {
		this.toEtaDt = toEtaDt;
	}
	
	/**
	 * Column Info
	 * @param fmEtdDt
	 */
	public void setFmEtdDt(String fmEtdDt) {
		this.fmEtdDt = fmEtdDt;
	}
	
	/**
	 * Column Info
	 * @param repoPlnFbRsnCd
	 */
	public void setRepoPlnFbRsnCd(String repoPlnFbRsnCd) {
		this.repoPlnFbRsnCd = repoPlnFbRsnCd;
	}
	
	/**
	 * Column Info
	 * @param eqRepoPurpCd
	 */
	public void setEqRepoPurpCd(String eqRepoPurpCd) {
		this.eqRepoPurpCd = eqRepoPurpCd;
	}
	
	/**
	 * Column Info
	 * @param frlocEcc
	 */
	public void setFrlocEcc(String frlocEcc) {
		this.frlocEcc = frlocEcc;
	}
	
	/**
	 * Column Info
	 * @param soIssFlg
	 */
	public void setSoIssFlg(String soIssFlg) {
		this.soIssFlg = soIssFlg;
	}
	
	/**
	 * Column Info
	 * @param frlocRcc
	 */
	public void setFrlocRcc(String frlocRcc) {
		this.frlocRcc = frlocRcc;
	}
	
	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param tolocEcc
	 */
	public void setTolocEcc(String tolocEcc) {
		this.tolocEcc = tolocEcc;
	}
	
	/**
	 * Column Info
	 * @param cntrno
	 */
	public void setCntrno(String cntrno) {
		this.cntrno = cntrno;
	}
	
	/**
	 * Column Info
	 * @param plnSeq
	 */
	public void setPlnSeq(String plnSeq) {
		this.plnSeq = plnSeq;
	}
	
	/**
	 * Column Info
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
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
	 * @param repobkgFlag
	 */
	public void setRepobkgFlag(String repobkgFlag) {
		this.repobkgFlag = repobkgFlag;
	}
	
	/**
	 * Column Info
	 * @param cntrDel
	 */
	public void setCntrDel(String cntrDel) {
		this.cntrDel = cntrDel;
	}
	
	/**
	 * Column Info
	 * @param tpszno
	 */
	public void setTpszno(String tpszno) {
		this.tpszno = tpszno;
	}
	
	/**
	 * Column Info
	 * @param repoPlnFbRmk
	 */
	public void setRepoPlnFbRmk(String repoPlnFbRmk) {
		this.repoPlnFbRmk = repoPlnFbRmk;
	}
	
	public String getMtyBkgNo() {
		return mtyBkgNo;
	}

	public void setMtyBkgNo(String mtyBkgNo) {
		this.mtyBkgNo = mtyBkgNo;
	}
	
	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public List<String> getTpszList() {
		return tpszList;
	}

	public void setTpszList(List<String> tpszList) {
		this.tpszList = tpszList;
	}
	
	public List<String> getVolList() {
		return volList;
	}

	public void setVolList(List<String> volList) {
		this.volList = volList;
	}

	public List<String> getCostList() {
		return costList;
	}

	public void setCostList(List<String> costList) {
		this.costList = costList;
	}

	public List<String> getFlagList() {
		return flagList;
	}

	public void setFlagList(List<String> flagList) {
		this.flagList = flagList;
	}

	public List<String> getUnitcostList() {
		return unitcostList;
	}

	public void setUnitcostList(List<String> unitcostList) {
		this.unitcostList = unitcostList;
	}

	public List<String> getFromcostList() {
		return fromcostList;
	}

	public void setFromcostList(List<String> fromcostList) {
		this.fromcostList = fromcostList;
	}

	public List<String> getTocostList() {
		return tocostList;
	}

	public void setTocostList(List<String> tocostList) {
		this.tocostList = tocostList;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRepoMtyBkgFlg(JSPUtil.getParameter(request, "repo_mty_bkg_flg", ""));
		setFmYdCd(JSPUtil.getParameter(request, "fm_yd_cd", ""));
		setDiv(JSPUtil.getParameter(request, "div", ""));
		setRefId(JSPUtil.getParameter(request, "ref_id", ""));
		setSoCancelFlag(JSPUtil.getParameter(request, "so_cancel_flag", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setTrspModCd(JSPUtil.getParameter(request, "trsp_mod_cd", ""));
		setToYdCd(JSPUtil.getParameter(request, "to_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVslLaneCd(JSPUtil.getParameter(request, "vsl_lane_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPastRepoPlnFlg(JSPUtil.getParameter(request, "past_repo_pln_flg", ""));
		setToEtaDt(JSPUtil.getParameter(request, "to_eta_dt", ""));
		setFmEtdDt(JSPUtil.getParameter(request, "fm_etd_dt", ""));
		setRepoPlnFbRsnCd(JSPUtil.getParameter(request, "repo_pln_fb_rsn_cd", ""));
		setEqRepoPurpCd(JSPUtil.getParameter(request, "eq_repo_purp_cd", ""));
		setFrlocEcc(JSPUtil.getParameter(request, "frloc_ecc", ""));
		setSoIssFlg(JSPUtil.getParameter(request, "so_iss_flg", ""));
		setFrlocRcc(JSPUtil.getParameter(request, "frloc_rcc", ""));
		setCoCd(JSPUtil.getParameter(request, "co_cd", ""));
		setTolocEcc(JSPUtil.getParameter(request, "toloc_ecc", ""));
		setCntrno(JSPUtil.getParameter(request, "cntrno", ""));
		setPlnSeq(JSPUtil.getParameter(request, "pln_seq", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setRepobkgFlag(JSPUtil.getParameter(request, "repobkg_flag", ""));
		setCntrDel(JSPUtil.getParameter(request, "cntr_del", ""));
		setTpszno(JSPUtil.getParameter(request, "tpszno", ""));
		setRepoPlnFbRmk(JSPUtil.getParameter(request, "repo_pln_fb_rmk", ""));
		setVpsPort(JSPUtil.getParameter(request, "vpsPort", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0080MultiVO[]
	 */
	public EesEqr0080MultiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0080MultiVO[]
	 */
	public EesEqr0080MultiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0080MultiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String tpsztype = JSPUtil.getParameter(request, "tpsztype".trim(), ""); // tpsz value
	    	String[] tpszArr = tpsztype.split(","); 
			
			String[] repoMtyBkgFlg = (JSPUtil.getParameter(request, prefix	+ "repo_mty_bkg_flg", length));
			String[] fmYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_yd_cd", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));
			String[] refId = (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			String[] soCancelFlag = (JSPUtil.getParameter(request, prefix	+ "so_cancel_flag", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] toYdCd = (JSPUtil.getParameter(request, prefix	+ "to_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslLaneCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pastRepoPlnFlg = (JSPUtil.getParameter(request, prefix	+ "past_repo_pln_flg", length));
			String[] toEtaDt = (JSPUtil.getParameter(request, prefix	+ "to_eta_dt", length));
			String[] fmEtdDt = (JSPUtil.getParameter(request, prefix	+ "fm_etd_dt", length));
			String[] repoPlnFbRsnCd = (JSPUtil.getParameter(request, prefix	+ "repo_pln_fb_rsn_cd", length));
			String[] eqRepoPurpCd = (JSPUtil.getParameter(request, prefix	+ "eq_repo_purp_cd", length));
			String[] frlocEcc = (JSPUtil.getParameter(request, prefix	+ "fm_ecc", length));
			String[] soIssFlg = (JSPUtil.getParameter(request, prefix	+ "so_iss_flg", length));
			String[] frlocRcc = (JSPUtil.getParameter(request, prefix	+ "fm_rcc", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] tolocEcc = (JSPUtil.getParameter(request, prefix	+ "to_ecc", length));
			String[] cntrno = (JSPUtil.getParameter(request, prefix	+ "cntrno", length));
			String[] plnSeq = (JSPUtil.getParameter(request, prefix	+ "pln_seq", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] repobkgFlag = (JSPUtil.getParameter(request, prefix	+ "repobkg_flag", length));
			String[] cntrDel = (JSPUtil.getParameter(request, prefix	+ "cntrdel", length));
			String[] tpszno = (JSPUtil.getParameter(request, prefix	+ "tpszno", length));
			String[] repoPlnFbRmk = (JSPUtil.getParameter(request, prefix	+ "repo_pln_fb_rmk", length));
			String[] vpsPort = (JSPUtil.getParameter(request, prefix	+ "vpsPort", length));
			List<String[]> volListArr = new ArrayList<String[]>();
			List<String[]> costListArr = new ArrayList<String[]>();
			List<String[]> flagListArr = new ArrayList<String[]>();
			List<String[]> unitcostListArr = new ArrayList<String[]>();
			List<String[]> fromcostListArr = new ArrayList<String[]>();
			List<String[]> tocostListArr = new ArrayList<String[]>();
			for(int i=0; i<tpszArr.length; i++) {
				String[] volArr = (JSPUtil.getParameter(request, prefix	+ "vol"+tpszArr[i], length));
				String[] costArr = (JSPUtil.getParameter(request, prefix	+ "cost"+tpszArr[i], length));
				String[] flagArr = (JSPUtil.getParameter(request, prefix	+ "flag"+tpszArr[i], length));
				String[] unitcostArr = (JSPUtil.getParameter(request, prefix	+ "unitcost"+tpszArr[i], length));
				String[] fromcostArr = (JSPUtil.getParameter(request, prefix	+ "fromcost"+tpszArr[i], length));
				String[] tocostArr = (JSPUtil.getParameter(request, prefix	+ "tocost"+tpszArr[i], length));
				
				volListArr.add(volArr);
				costListArr.add(costArr);
				flagListArr.add(flagArr);
				unitcostListArr.add(unitcostArr);
				fromcostListArr.add(fromcostArr);
				tocostListArr.add(tocostArr);
			}
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0080MultiVO();
				
				List<String> tpszList = new ArrayList<String>();
				List<String> volList = new ArrayList<String>();
				List<String> costList = new ArrayList<String>();
				List<String> flagList = new ArrayList<String>();
				List<String> unitcostList = new ArrayList<String>();
				List<String> fromcostList = new ArrayList<String>();
				List<String> tocostList = new ArrayList<String>();
				for(int t=0; t<tpszArr.length; t++) {
					String[] volArr  = (String[])volListArr.get(t);
					String[] costArr = (String[])costListArr.get(t);
					String[] flagArr = (String[])flagListArr.get(t);
					String[] unitcostArr = (String[])unitcostListArr.get(t);
					String[] fromcostArr = (String[])fromcostListArr.get(t);
					String[] tocostArr = (String[])tocostListArr.get(t);
					
					tpszList.add(tpszArr[t]);
					
					if(volArr[i] != null)
						volList.add(volArr[i]);
					if(costArr[i] != null)
						costList.add(costArr[i]);
					if(flagArr[i] != null)
						flagList.add(flagArr[i]);
					if(unitcostArr[i] != null)
						unitcostList.add(unitcostArr[i]);
					if(fromcostArr[i] != null)
						fromcostList.add(fromcostArr[i]);
					if(tocostArr[i] != null)
						tocostList.add(tocostArr[i]);
				}
				model.setTpszList(tpszList);
				model.setVolList(volList);
				model.setCostList(costList);
				model.setFlagList(flagList);
				model.setUnitcostList(unitcostList);
				model.setFromcostList(fromcostList);
				model.setTocostList(tocostList);
				
				
				if (repoMtyBkgFlg[i] != null)
					model.setRepoMtyBkgFlg(repoMtyBkgFlg[i]);
				if (fmYdCd[i] != null)
					model.setFmYdCd(fmYdCd[i]);
				if (div[i] != null)
					model.setDiv(div[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (soCancelFlag[i] != null)
					model.setSoCancelFlag(soCancelFlag[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (toYdCd[i] != null)
					model.setToYdCd(toYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslLaneCd[i] != null)
					model.setVslLaneCd(vslLaneCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pastRepoPlnFlg[i] != null)
					model.setPastRepoPlnFlg(pastRepoPlnFlg[i]);
				if (toEtaDt[i] != null)
					model.setToEtaDt(toEtaDt[i]);
				if (fmEtdDt[i] != null)
					model.setFmEtdDt(fmEtdDt[i]);
				if (repoPlnFbRsnCd[i] != null)
					model.setRepoPlnFbRsnCd(repoPlnFbRsnCd[i]);
				if (eqRepoPurpCd[i] != null)
					model.setEqRepoPurpCd(eqRepoPurpCd[i]);
				if (frlocEcc[i] != null)
					model.setFrlocEcc(frlocEcc[i]);
				if (soIssFlg[i] != null)
					model.setSoIssFlg(soIssFlg[i]);
				if (frlocRcc[i] != null)
					model.setFrlocRcc(frlocRcc[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (tolocEcc[i] != null)
					model.setTolocEcc(tolocEcc[i]);
				if (cntrno[i] != null)
					model.setCntrno(cntrno[i]);
				if (plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (repobkgFlag[i] != null)
					model.setRepobkgFlag(repobkgFlag[i]);
				if (cntrDel[i] != null)
					model.setCntrDel(cntrDel[i]);
				if (tpszno[i] != null)
					model.setTpszno(tpszno[i]);
				if (repoPlnFbRmk[i] != null)
					model.setRepoPlnFbRmk(repoPlnFbRmk[i]);
				if (vpsPort[i] != null)
					model.setVpsPort(vpsPort[i]);
				
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0080MultiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0080MultiVO[]
	 */
	public EesEqr0080MultiVO[] getEesEqr0080MultiVOs(){
		EesEqr0080MultiVO[] vos = (EesEqr0080MultiVO[])models.toArray(new EesEqr0080MultiVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.repoMtyBkgFlg = this.repoMtyBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYdCd = this.fmYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCancelFlag = this.soCancelFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYdCd = this.toYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneCd = this.vslLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pastRepoPlnFlg = this.pastRepoPlnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtaDt = this.toEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEtdDt = this.fmEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnFbRsnCd = this.repoPlnFbRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRepoPurpCd = this.eqRepoPurpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frlocEcc = this.frlocEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soIssFlg = this.soIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frlocRcc = this.frlocRcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tolocEcc = this.tolocEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrno = this.cntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSeq = this.plnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repobkgFlag = this.repobkgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDel = this.cntrDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszno = this.tpszno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnFbRmk = this.repoPlnFbRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
