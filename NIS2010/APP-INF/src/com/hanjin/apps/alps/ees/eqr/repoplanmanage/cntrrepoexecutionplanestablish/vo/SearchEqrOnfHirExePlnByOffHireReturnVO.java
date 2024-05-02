/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEqrOnfHirExePlnByOffHireReturnVO.java
*@FileTitle : SearchEqrOnfHirExePlnByOffHireReturnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.10.21 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo;

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
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEqrOnfHirExePlnByOffHireReturnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEqrOnfHirExePlnByOffHireReturnVO> models = new ArrayList<SearchEqrOnfHirExePlnByOffHireReturnVO>();
	
	/* Column Info */
	private String fmLocDt = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String fmYdCd = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String allTpszVol = null;
	/* Column Info */
	private String toLocDt = null;
	/* Column Info */
	private String repoPlnFbRsnCd = null;
	/* Column Info */
	private String soRqstDt = null;
	/* Column Info */
	private String nonSoIssFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String soIssFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String plnSeq = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String onfHirDivCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String repoPlnFbRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEqrOnfHirExePlnByOffHireReturnVO() {}

	public SearchEqrOnfHirExePlnByOffHireReturnVO(String ibflag, String pagerows, String repoPlnId, String plnYrwk, String plnSeq, String refId, String coCd, String onfHirDivCd, String vndrCntCd, String vndrSeq, String vndrAbbrNm, String fmYdCd, String fmLocDt, String toYdCd, String toLocDt, String repoPlnFbRsnCd, String repoPlnFbRmk, String soRqstDt, String soIssFlg, String nonSoIssFlg, String creUsrId, String creDt, String updUsrId, String updDt, String allTpszVol) {
		this.fmLocDt = fmLocDt;
		this.vndrCntCd = vndrCntCd;
		this.fmYdCd = fmYdCd;
		this.refId = refId;
		this.creDt = creDt;
		this.plnYrwk = plnYrwk;
		this.pagerows = pagerows;
		this.toYdCd = toYdCd;
		this.ibflag = ibflag;
		this.allTpszVol = allTpszVol;
		this.toLocDt = toLocDt;
		this.repoPlnFbRsnCd = repoPlnFbRsnCd;
		this.soRqstDt = soRqstDt;
		this.nonSoIssFlg = nonSoIssFlg;
		this.updUsrId = updUsrId;
		this.soIssFlg = soIssFlg;
		this.updDt = updDt;
		this.coCd = coCd;
		this.plnSeq = plnSeq;
		this.repoPlnId = repoPlnId;
		this.creUsrId = creUsrId;
		this.onfHirDivCd = onfHirDivCd;
		this.vndrSeq = vndrSeq;
		this.vndrAbbrNm = vndrAbbrNm;
		this.repoPlnFbRmk = repoPlnFbRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_loc_dt", getFmLocDt());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("fm_yd_cd", getFmYdCd());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_yd_cd", getToYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("all_tpsz_vol", getAllTpszVol());
		this.hashColumns.put("to_loc_dt", getToLocDt());
		this.hashColumns.put("repo_pln_fb_rsn_cd", getRepoPlnFbRsnCd());
		this.hashColumns.put("so_rqst_dt", getSoRqstDt());
		this.hashColumns.put("non_so_iss_flg", getNonSoIssFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("so_iss_flg", getSoIssFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("pln_seq", getPlnSeq());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("onf_hir_div_cd", getOnfHirDivCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("repo_pln_fb_rmk", getRepoPlnFbRmk());
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
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_yd_cd", "toYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("all_tpsz_vol", "allTpszVol");
		this.hashFields.put("to_loc_dt", "toLocDt");
		this.hashFields.put("repo_pln_fb_rsn_cd", "repoPlnFbRsnCd");
		this.hashFields.put("so_rqst_dt", "soRqstDt");
		this.hashFields.put("non_so_iss_flg", "nonSoIssFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("so_iss_flg", "soIssFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("pln_seq", "plnSeq");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("onf_hir_div_cd", "onfHirDivCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("repo_pln_fb_rmk", "repoPlnFbRmk");
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
	 * @return refId
	 */
	public String getRefId() {
		return this.refId;
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
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
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
	 * @return toYdCd
	 */
	public String getToYdCd() {
		return this.toYdCd;
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
	 * @return allTpszVol
	 */
	public String getAllTpszVol() {
		return this.allTpszVol;
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
	 * @return soRqstDt
	 */
	public String getSoRqstDt() {
		return this.soRqstDt;
	}
	
	/**
	 * Column Info
	 * @return nonSoIssFlg
	 */
	public String getNonSoIssFlg() {
		return this.nonSoIssFlg;
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
	 * @return soIssFlg
	 */
	public String getSoIssFlg() {
		return this.soIssFlg;
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
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return onfHirDivCd
	 */
	public String getOnfHirDivCd() {
		return this.onfHirDivCd;
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
	 * @param refId
	 */
	public void setRefId(String refId) {
		this.refId = refId;
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
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
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
	 * @param toYdCd
	 */
	public void setToYdCd(String toYdCd) {
		this.toYdCd = toYdCd;
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
	 * @param allTpszVol
	 */
	public void setAllTpszVol(String allTpszVol) {
		this.allTpszVol = allTpszVol;
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
	 * @param soRqstDt
	 */
	public void setSoRqstDt(String soRqstDt) {
		this.soRqstDt = soRqstDt;
	}
	
	/**
	 * Column Info
	 * @param nonSoIssFlg
	 */
	public void setNonSoIssFlg(String nonSoIssFlg) {
		this.nonSoIssFlg = nonSoIssFlg;
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
	 * @param soIssFlg
	 */
	public void setSoIssFlg(String soIssFlg) {
		this.soIssFlg = soIssFlg;
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
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param onfHirDivCd
	 */
	public void setOnfHirDivCd(String onfHirDivCd) {
		this.onfHirDivCd = onfHirDivCd;
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
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFmLocDt(JSPUtil.getParameter(request, "fm_loc_dt", ""));
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setFmYdCd(JSPUtil.getParameter(request, "fm_yd_cd", ""));
		setRefId(JSPUtil.getParameter(request, "ref_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToYdCd(JSPUtil.getParameter(request, "to_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAllTpszVol(JSPUtil.getParameter(request, "all_tpsz_vol", ""));
		setToLocDt(JSPUtil.getParameter(request, "to_loc_dt", ""));
		setRepoPlnFbRsnCd(JSPUtil.getParameter(request, "repo_pln_fb_rsn_cd", ""));
		setSoRqstDt(JSPUtil.getParameter(request, "so_rqst_dt", ""));
		setNonSoIssFlg(JSPUtil.getParameter(request, "non_so_iss_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSoIssFlg(JSPUtil.getParameter(request, "so_iss_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCoCd(JSPUtil.getParameter(request, "co_cd", ""));
		setPlnSeq(JSPUtil.getParameter(request, "pln_seq", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setOnfHirDivCd(JSPUtil.getParameter(request, "onf_hir_div_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setRepoPlnFbRmk(JSPUtil.getParameter(request, "repo_pln_fb_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEqrOnfHirExePlnByOffHireReturnVO[]
	 */
	public SearchEqrOnfHirExePlnByOffHireReturnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEqrOnfHirExePlnByOffHireReturnVO[]
	 */
	public SearchEqrOnfHirExePlnByOffHireReturnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEqrOnfHirExePlnByOffHireReturnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fmLocDt = (JSPUtil.getParameter(request, prefix	+ "fm_loc_dt", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] fmYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_yd_cd", length));
			String[] refId = (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toYdCd = (JSPUtil.getParameter(request, prefix	+ "to_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] allTpszVol = (JSPUtil.getParameter(request, prefix	+ "all_tpsz_vol", length));
			String[] toLocDt = (JSPUtil.getParameter(request, prefix	+ "to_loc_dt", length));
			String[] repoPlnFbRsnCd = (JSPUtil.getParameter(request, prefix	+ "repo_pln_fb_rsn_cd", length));
			String[] soRqstDt = (JSPUtil.getParameter(request, prefix	+ "so_rqst_dt", length));
			String[] nonSoIssFlg = (JSPUtil.getParameter(request, prefix	+ "non_so_iss_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] soIssFlg = (JSPUtil.getParameter(request, prefix	+ "so_iss_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] plnSeq = (JSPUtil.getParameter(request, prefix	+ "pln_seq", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] onfHirDivCd = (JSPUtil.getParameter(request, prefix	+ "onf_hir_div_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] repoPlnFbRmk = (JSPUtil.getParameter(request, prefix	+ "repo_pln_fb_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEqrOnfHirExePlnByOffHireReturnVO();
				if (fmLocDt[i] != null)
					model.setFmLocDt(fmLocDt[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (fmYdCd[i] != null)
					model.setFmYdCd(fmYdCd[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toYdCd[i] != null)
					model.setToYdCd(toYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (allTpszVol[i] != null)
					model.setAllTpszVol(allTpszVol[i]);
				if (toLocDt[i] != null)
					model.setToLocDt(toLocDt[i]);
				if (repoPlnFbRsnCd[i] != null)
					model.setRepoPlnFbRsnCd(repoPlnFbRsnCd[i]);
				if (soRqstDt[i] != null)
					model.setSoRqstDt(soRqstDt[i]);
				if (nonSoIssFlg[i] != null)
					model.setNonSoIssFlg(nonSoIssFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (soIssFlg[i] != null)
					model.setSoIssFlg(soIssFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (onfHirDivCd[i] != null)
					model.setOnfHirDivCd(onfHirDivCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (repoPlnFbRmk[i] != null)
					model.setRepoPlnFbRmk(repoPlnFbRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEqrOnfHirExePlnByOffHireReturnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEqrOnfHirExePlnByOffHireReturnVO[]
	 */
	public SearchEqrOnfHirExePlnByOffHireReturnVO[] getSearchEqrOnfHirExePlnByOffHireReturnVOs(){
		SearchEqrOnfHirExePlnByOffHireReturnVO[] vos = (SearchEqrOnfHirExePlnByOffHireReturnVO[])models.toArray(new SearchEqrOnfHirExePlnByOffHireReturnVO[models.size()]);
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
		this.fmLocDt = this.fmLocDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYdCd = this.fmYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYdCd = this.toYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allTpszVol = this.allTpszVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocDt = this.toLocDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnFbRsnCd = this.repoPlnFbRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soRqstDt = this.soRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonSoIssFlg = this.nonSoIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soIssFlg = this.soIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSeq = this.plnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onfHirDivCd = this.onfHirDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnFbRmk = this.repoPlnFbRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
