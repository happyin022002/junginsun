/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0081MultiVO.java
*@FileTitle : EesEqr0081MultiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.10 정은호 
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

public class EesEqr0081MultiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0081MultiVO> models = new ArrayList<EesEqr0081MultiVO>();
	
	/* Column Info */
	private String fmLocDt = null;
	/* Column Info */
	private String vndrCntCd = null;
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
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toLocDt = null;
	/* Column Info */
	private String repoPlnFbRsnCd = null;
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
	private String repoPlnId = null;
	/* Column Info */
	private String nosoIssFlg = null;
	/* Column Info */
	private String cntrDel = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String tpszno = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String repoPlnFbRmk = null;
	/* Column Info */
	private String leaseTerm = null;
	/* Column Info */
	private String plnSeq = null;
	
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
	
	public EesEqr0081MultiVO() {}

	public EesEqr0081MultiVO(String ibflag, String pagerows, String repoPlnId, String refId, String plnYrwk, String coCd, String div, String trspModCd, String fmYdCd, String fmLocDt, String toYdCd, String toLocDt, String soIssFlg, String nosoIssFlg, String repoPlnFbRsnCd, String repoPlnFbRmk, String vndrAbbrNm, String vndrCntCd, String vndrSeq, String cntrno, String tpszno, String cntrDel, String soCancelFlag, String frlocRcc, String frlocEcc, String tolocEcc , String leaseTerm , String plnSeq) {
		this.fmLocDt = fmLocDt;
		this.vndrCntCd = vndrCntCd;
		this.fmYdCd = fmYdCd;
		this.div = div;
		this.refId = refId;
		this.soCancelFlag = soCancelFlag;
		this.plnYrwk = plnYrwk;
		this.trspModCd = trspModCd;
		this.toYdCd = toYdCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.toLocDt = toLocDt;
		this.repoPlnFbRsnCd = repoPlnFbRsnCd;
		this.frlocEcc = frlocEcc;
		this.soIssFlg = soIssFlg;
		this.frlocRcc = frlocRcc;
		this.coCd = coCd;
		this.tolocEcc = tolocEcc;
		this.cntrno = cntrno;
		this.repoPlnId = repoPlnId;
		this.nosoIssFlg = nosoIssFlg;
		this.cntrDel = cntrDel;
		this.vndrSeq = vndrSeq;
		this.tpszno = tpszno;
		this.vndrAbbrNm = vndrAbbrNm;
		this.repoPlnFbRmk = repoPlnFbRmk;
		this.leaseTerm = leaseTerm;
		this.plnSeq = plnSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_loc_dt", getFmLocDt());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("fm_yd_cd", getFmYdCd());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("so_cancel_flag", getSoCancelFlag());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("to_yd_cd", getToYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_loc_dt", getToLocDt());
		this.hashColumns.put("repo_pln_fb_rsn_cd", getRepoPlnFbRsnCd());
		this.hashColumns.put("frloc_ecc", getFrlocEcc());
		this.hashColumns.put("so_iss_flg", getSoIssFlg());
		this.hashColumns.put("frloc_rcc", getFrlocRcc());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("toloc_ecc", getTolocEcc());
		this.hashColumns.put("cntrno", getCntrno());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("noso_iss_flg", getNosoIssFlg());
		this.hashColumns.put("cntr_del", getCntrDel());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("tpszno", getTpszno());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("repo_pln_fb_rmk", getRepoPlnFbRmk());
		this.hashColumns.put("lease_term", getLeaseTerm());
		this.hashColumns.put("pln_seq", getPlnSeq());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_loc_dt", "fmLocDt");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("fm_yd_cd", "fmYdCd");
		this.hashFields.put("div", "div");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("so_cancel_flag", "soCancelFlag");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("to_yd_cd", "toYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_loc_dt", "toLocDt");
		this.hashFields.put("repo_pln_fb_rsn_cd", "repoPlnFbRsnCd");
		this.hashFields.put("frloc_ecc", "frlocEcc");
		this.hashFields.put("so_iss_flg", "soIssFlg");
		this.hashFields.put("frloc_rcc", "frlocRcc");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("toloc_ecc", "tolocEcc");
		this.hashFields.put("cntrno", "cntrno");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("noso_iss_flg", "nosoIssFlg");
		this.hashFields.put("cntr_del", "cntrDel");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("tpszno", "tpszno");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("repo_pln_fb_rmk", "repoPlnFbRmk");
		this.hashFields.put("lease_term", "leaseTerm");
		this.hashFields.put("pln_seq", "plnSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmLocDt
	 */
	public String getFmLocDt() {
		return this.fmLocDt;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return toLocDt
	 */
	public String getToLocDt() {
		return this.toLocDt;
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
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
	}
	
	/**
	 * Column Info
	 * @return nosoIssFlg
	 */
	public String getNosoIssFlg() {
		return this.nosoIssFlg;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return repoPlnFbRmk
	 */
	public String getRepoPlnFbRmk() {
		return this.repoPlnFbRmk;
	}
	

	/**
	 * Column Info
	 * @param fmLocDt
	 */
	public void setFmLocDt(String fmLocDt) {
		this.fmLocDt = fmLocDt;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param toLocDt
	 */
	public void setToLocDt(String toLocDt) {
		this.toLocDt = toLocDt;
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
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
	}
	
	/**
	 * Column Info
	 * @param nosoIssFlg
	 */
	public void setNosoIssFlg(String nosoIssFlg) {
		this.nosoIssFlg = nosoIssFlg;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param repoPlnFbRmk
	 */
	public void setRepoPlnFbRmk(String repoPlnFbRmk) {
		this.repoPlnFbRmk = repoPlnFbRmk;
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
	
	public String getLeaseTerm() {
		return leaseTerm;
	}

	public void setLeaseTerm(String leaseTerm) {
		this.leaseTerm = leaseTerm;
	}
	

	public String getPlnSeq() {
		return plnSeq;
	}

	public void setPlnSeq(String plnSeq) {
		this.plnSeq = plnSeq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 사용안함
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFmLocDt(JSPUtil.getParameter(request, "fm_loc_dt", ""));
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setFmYdCd(JSPUtil.getParameter(request, "fm_yd_cd", ""));
		setDiv(JSPUtil.getParameter(request, "div", ""));
		setRefId(JSPUtil.getParameter(request, "ref_id", ""));
		setSoCancelFlag(JSPUtil.getParameter(request, "so_cancel_flag", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setTrspModCd(JSPUtil.getParameter(request, "onf_hir_div_cd", ""));
		setToYdCd(JSPUtil.getParameter(request, "to_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToLocDt(JSPUtil.getParameter(request, "to_loc_dt", ""));
		setRepoPlnFbRsnCd(JSPUtil.getParameter(request, "repo_pln_fb_rsn_cd", ""));
		setFrlocEcc(JSPUtil.getParameter(request, "frloc_ecc", ""));
		setSoIssFlg(JSPUtil.getParameter(request, "so_iss_flg", ""));
		setFrlocRcc(JSPUtil.getParameter(request, "frloc_rcc", ""));
		setCoCd(JSPUtil.getParameter(request, "co_cd", ""));
		setTolocEcc(JSPUtil.getParameter(request, "toloc_ecc", ""));
		setCntrno(JSPUtil.getParameter(request, "cntrno", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setNosoIssFlg(JSPUtil.getParameter(request, "noso_iss_flg", ""));
		setCntrDel(JSPUtil.getParameter(request, "cntrdel", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setTpszno(JSPUtil.getParameter(request, "tpszno", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setRepoPlnFbRmk(JSPUtil.getParameter(request, "repo_pln_fb_rmk", ""));
		setLeaseTerm(JSPUtil.getParameter(request, "lease_term", ""));
		setPlnSeq(JSPUtil.getParameter(request, "pln_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0081MultiVO[]
	 */
	public EesEqr0081MultiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0081MultiVO[]
	 */
	public EesEqr0081MultiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0081MultiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String tpsztype = JSPUtil.getParameter(request, "tpsztype".trim(), ""); // tpsz value
	    	String[] tpszArr = tpsztype.split(","); 
	    	
			String[] fmLocDt = (JSPUtil.getParameter(request, prefix	+ "fm_loc_dt", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] fmYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_yd_cd", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));
			String[] refId = (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			String[] soCancelFlag = (JSPUtil.getParameter(request, prefix	+ "so_cancel_flag", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "onf_hir_div_cd", length));
			String[] toYdCd = (JSPUtil.getParameter(request, prefix	+ "to_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toLocDt = (JSPUtil.getParameter(request, prefix	+ "to_loc_dt", length));
			String[] repoPlnFbRsnCd = (JSPUtil.getParameter(request, prefix	+ "repo_pln_fb_rsn_cd", length));
			String[] frlocEcc = (JSPUtil.getParameter(request, prefix	+ "fm_ecc", length));
			String[] soIssFlg = (JSPUtil.getParameter(request, prefix	+ "so_iss_flg", length));
			String[] frlocRcc = (JSPUtil.getParameter(request, prefix	+ "fm_rcc", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] tolocEcc = (JSPUtil.getParameter(request, prefix	+ "to_ecc", length));
			String[] cntrno = (JSPUtil.getParameter(request, prefix	+ "cntrno", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] nosoIssFlg = (JSPUtil.getParameter(request, prefix	+ "noso_iss_flg", length));
			String[] cntrDel = (JSPUtil.getParameter(request, prefix	+ "cntrdel", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] tpszno = (JSPUtil.getParameter(request, prefix	+ "tpszno", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] repoPlnFbRmk = (JSPUtil.getParameter(request, prefix	+ "repo_pln_fb_rmk", length));
			String[] leaseTerm = (JSPUtil.getParameter(request, prefix	+ "lease_term", length));
			String[] plnSeq = (JSPUtil.getParameter(request, prefix	+ "pln_seq", length));
			
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
				model = new EesEqr0081MultiVO();
				
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
				
				if (fmLocDt[i] != null)
					model.setFmLocDt(fmLocDt[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
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
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toLocDt[i] != null)
					model.setToLocDt(toLocDt[i]);
				if (repoPlnFbRsnCd[i] != null)
					model.setRepoPlnFbRsnCd(repoPlnFbRsnCd[i]);
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
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (nosoIssFlg[i] != null)
					model.setNosoIssFlg(nosoIssFlg[i]);
				if (cntrDel[i] != null)
					model.setCntrDel(cntrDel[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (tpszno[i] != null)
					model.setTpszno(tpszno[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (repoPlnFbRmk[i] != null)
					model.setRepoPlnFbRmk(repoPlnFbRmk[i]);
				if(leaseTerm[i] != null)
					model.setLeaseTerm(leaseTerm[i]);
				if(plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0081MultiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0081MultiVO[]
	 */
	public EesEqr0081MultiVO[] getEesEqr0081MultiVOs(){
		EesEqr0081MultiVO[] vos = (EesEqr0081MultiVO[])models.toArray(new EesEqr0081MultiVO[models.size()]);
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
		this.fmLocDt = this.fmLocDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYdCd = this.fmYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCancelFlag = this.soCancelFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYdCd = this.toYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocDt = this.toLocDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnFbRsnCd = this.repoPlnFbRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frlocEcc = this.frlocEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soIssFlg = this.soIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frlocRcc = this.frlocRcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tolocEcc = this.tolocEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrno = this.cntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nosoIssFlg = this.nosoIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDel = this.cntrDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszno = this.tpszno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnFbRmk = this.repoPlnFbRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leaseTerm = this.leaseTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSeq = this.plnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
