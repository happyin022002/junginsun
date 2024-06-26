/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EqrVslLdisPlnCodTmpVO.java
*@FileTitle : EqrVslLdisPlnCodTmpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.02 채창호 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EqrVslLdisPlnCodTmpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqrVslLdisPlnCodTmpVO> models = new ArrayList<EqrVslLdisPlnCodTmpVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String toEtbDt = null;
	/* Column Info */
	private String toEccCd = null;
	/* Column Info */
	private String prePlnFmEtdDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String plnSeq = null;
	/* Column Info */
	private String trspModCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String vslLaneCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmEccCd = null;
	/* Column Info */
	private String prePlnToEtaDt = null;
	/* Column Info */
	private String prePlnFmEccCd = null;
	/* Column Info */
	private String pastRepoPlnFlg = null;
	/* Column Info */
	private String fmEtdDt = null;
	/* Column Info */
	private String prePlnToEccCd = null;
	/* Column Info */
	private String prePlnTsFlg = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EqrVslLdisPlnCodTmpVO() {}

	public EqrVslLdisPlnCodTmpVO(String ibflag, String pagerows, String repoPlnId, String plnYrwk, String plnSeq, String trspModCd, String vslLaneCd, String vslCd, String skdVoyNo, String skdDirCd, String fmEccCd, String fmEtdDt, String toEccCd, String toEtbDt, String pastRepoPlnFlg, String prePlnFmEccCd, String prePlnFmEtdDt, String prePlnToEccCd, String prePlnToEtaDt, String prePlnTsFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.vslCd = vslCd;
		this.toEtbDt = toEtbDt;
		this.toEccCd = toEccCd;
		this.prePlnFmEtdDt = prePlnFmEtdDt;
		this.creDt = creDt;
		this.skdVoyNo = skdVoyNo;
		this.plnYrwk = plnYrwk;
		this.plnSeq = plnSeq;
		this.trspModCd = trspModCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.repoPlnId = repoPlnId;
		this.vslLaneCd = vslLaneCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.fmEccCd = fmEccCd;
		this.prePlnToEtaDt = prePlnToEtaDt;
		this.prePlnFmEccCd = prePlnFmEccCd;
		this.pastRepoPlnFlg = pastRepoPlnFlg;
		this.fmEtdDt = fmEtdDt;
		this.prePlnToEccCd = prePlnToEccCd;
		this.prePlnTsFlg = prePlnTsFlg;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("to_etb_dt", getToEtbDt());
		this.hashColumns.put("to_ecc_cd", getToEccCd());
		this.hashColumns.put("pre_pln_fm_etd_dt", getPrePlnFmEtdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("pln_seq", getPlnSeq());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("vsl_lane_cd", getVslLaneCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_ecc_cd", getFmEccCd());
		this.hashColumns.put("pre_pln_to_eta_dt", getPrePlnToEtaDt());
		this.hashColumns.put("pre_pln_fm_ecc_cd", getPrePlnFmEccCd());
		this.hashColumns.put("past_repo_pln_flg", getPastRepoPlnFlg());
		this.hashColumns.put("fm_etd_dt", getFmEtdDt());
		this.hashColumns.put("pre_pln_to_ecc_cd", getPrePlnToEccCd());
		this.hashColumns.put("pre_pln_ts_flg", getPrePlnTsFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("to_etb_dt", "toEtbDt");
		this.hashFields.put("to_ecc_cd", "toEccCd");
		this.hashFields.put("pre_pln_fm_etd_dt", "prePlnFmEtdDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("pln_seq", "plnSeq");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("vsl_lane_cd", "vslLaneCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_ecc_cd", "fmEccCd");
		this.hashFields.put("pre_pln_to_eta_dt", "prePlnToEtaDt");
		this.hashFields.put("pre_pln_fm_ecc_cd", "prePlnFmEccCd");
		this.hashFields.put("past_repo_pln_flg", "pastRepoPlnFlg");
		this.hashFields.put("fm_etd_dt", "fmEtdDt");
		this.hashFields.put("pre_pln_to_ecc_cd", "prePlnToEccCd");
		this.hashFields.put("pre_pln_ts_flg", "prePlnTsFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return toEtbDt
	 */
	public String getToEtbDt() {
		return this.toEtbDt;
	}
	
	/**
	 * Column Info
	 * @return toEccCd
	 */
	public String getToEccCd() {
		return this.toEccCd;
	}
	
	/**
	 * Column Info
	 * @return prePlnFmEtdDt
	 */
	public String getPrePlnFmEtdDt() {
		return this.prePlnFmEtdDt;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return plnSeq
	 */
	public String getPlnSeq() {
		return this.plnSeq;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
	}
	
	/**
	 * Column Info
	 * @return vslLaneCd
	 */
	public String getVslLaneCd() {
		return this.vslLaneCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return fmEccCd
	 */
	public String getFmEccCd() {
		return this.fmEccCd;
	}
	
	/**
	 * Column Info
	 * @return prePlnToEtaDt
	 */
	public String getPrePlnToEtaDt() {
		return this.prePlnToEtaDt;
	}
	
	/**
	 * Column Info
	 * @return prePlnFmEccCd
	 */
	public String getPrePlnFmEccCd() {
		return this.prePlnFmEccCd;
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
	 * @return fmEtdDt
	 */
	public String getFmEtdDt() {
		return this.fmEtdDt;
	}
	
	/**
	 * Column Info
	 * @return prePlnToEccCd
	 */
	public String getPrePlnToEccCd() {
		return this.prePlnToEccCd;
	}
	
	/**
	 * Column Info
	 * @return prePlnTsFlg
	 */
	public String getPrePlnTsFlg() {
		return this.prePlnTsFlg;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param toEtbDt
	 */
	public void setToEtbDt(String toEtbDt) {
		this.toEtbDt = toEtbDt;
	}
	
	/**
	 * Column Info
	 * @param toEccCd
	 */
	public void setToEccCd(String toEccCd) {
		this.toEccCd = toEccCd;
	}
	
	/**
	 * Column Info
	 * @param prePlnFmEtdDt
	 */
	public void setPrePlnFmEtdDt(String prePlnFmEtdDt) {
		this.prePlnFmEtdDt = prePlnFmEtdDt;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param plnSeq
	 */
	public void setPlnSeq(String plnSeq) {
		this.plnSeq = plnSeq;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
	}
	
	/**
	 * Column Info
	 * @param vslLaneCd
	 */
	public void setVslLaneCd(String vslLaneCd) {
		this.vslLaneCd = vslLaneCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param fmEccCd
	 */
	public void setFmEccCd(String fmEccCd) {
		this.fmEccCd = fmEccCd;
	}
	
	/**
	 * Column Info
	 * @param prePlnToEtaDt
	 */
	public void setPrePlnToEtaDt(String prePlnToEtaDt) {
		this.prePlnToEtaDt = prePlnToEtaDt;
	}
	
	/**
	 * Column Info
	 * @param prePlnFmEccCd
	 */
	public void setPrePlnFmEccCd(String prePlnFmEccCd) {
		this.prePlnFmEccCd = prePlnFmEccCd;
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
	 * @param fmEtdDt
	 */
	public void setFmEtdDt(String fmEtdDt) {
		this.fmEtdDt = fmEtdDt;
	}
	
	/**
	 * Column Info
	 * @param prePlnToEccCd
	 */
	public void setPrePlnToEccCd(String prePlnToEccCd) {
		this.prePlnToEccCd = prePlnToEccCd;
	}
	
	/**
	 * Column Info
	 * @param prePlnTsFlg
	 */
	public void setPrePlnTsFlg(String prePlnTsFlg) {
		this.prePlnTsFlg = prePlnTsFlg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setToEtbDt(JSPUtil.getParameter(request, "to_etb_dt", ""));
		setToEccCd(JSPUtil.getParameter(request, "to_ecc_cd", ""));
		setPrePlnFmEtdDt(JSPUtil.getParameter(request, "pre_pln_fm_etd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setPlnSeq(JSPUtil.getParameter(request, "pln_seq", ""));
		setTrspModCd(JSPUtil.getParameter(request, "trsp_mod_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setVslLaneCd(JSPUtil.getParameter(request, "vsl_lane_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmEccCd(JSPUtil.getParameter(request, "fm_ecc_cd", ""));
		setPrePlnToEtaDt(JSPUtil.getParameter(request, "pre_pln_to_eta_dt", ""));
		setPrePlnFmEccCd(JSPUtil.getParameter(request, "pre_pln_fm_ecc_cd", ""));
		setPastRepoPlnFlg(JSPUtil.getParameter(request, "past_repo_pln_flg", ""));
		setFmEtdDt(JSPUtil.getParameter(request, "fm_etd_dt", ""));
		setPrePlnToEccCd(JSPUtil.getParameter(request, "pre_pln_to_ecc_cd", ""));
		setPrePlnTsFlg(JSPUtil.getParameter(request, "pre_pln_ts_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqrVslLdisPlnCodTmpVO[]
	 */
	public EqrVslLdisPlnCodTmpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqrVslLdisPlnCodTmpVO[]
	 */
	public EqrVslLdisPlnCodTmpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqrVslLdisPlnCodTmpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] toEtbDt = (JSPUtil.getParameter(request, prefix	+ "to_etb_dt", length));
			String[] toEccCd = (JSPUtil.getParameter(request, prefix	+ "to_ecc_cd", length));
			String[] prePlnFmEtdDt = (JSPUtil.getParameter(request, prefix	+ "pre_pln_fm_etd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] plnSeq = (JSPUtil.getParameter(request, prefix	+ "pln_seq", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] vslLaneCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmEccCd = (JSPUtil.getParameter(request, prefix	+ "fm_ecc_cd", length));
			String[] prePlnToEtaDt = (JSPUtil.getParameter(request, prefix	+ "pre_pln_to_eta_dt", length));
			String[] prePlnFmEccCd = (JSPUtil.getParameter(request, prefix	+ "pre_pln_fm_ecc_cd", length));
			String[] pastRepoPlnFlg = (JSPUtil.getParameter(request, prefix	+ "past_repo_pln_flg", length));
			String[] fmEtdDt = (JSPUtil.getParameter(request, prefix	+ "fm_etd_dt", length));
			String[] prePlnToEccCd = (JSPUtil.getParameter(request, prefix	+ "pre_pln_to_ecc_cd", length));
			String[] prePlnTsFlg = (JSPUtil.getParameter(request, prefix	+ "pre_pln_ts_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqrVslLdisPlnCodTmpVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (toEtbDt[i] != null)
					model.setToEtbDt(toEtbDt[i]);
				if (toEccCd[i] != null)
					model.setToEccCd(toEccCd[i]);
				if (prePlnFmEtdDt[i] != null)
					model.setPrePlnFmEtdDt(prePlnFmEtdDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (vslLaneCd[i] != null)
					model.setVslLaneCd(vslLaneCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmEccCd[i] != null)
					model.setFmEccCd(fmEccCd[i]);
				if (prePlnToEtaDt[i] != null)
					model.setPrePlnToEtaDt(prePlnToEtaDt[i]);
				if (prePlnFmEccCd[i] != null)
					model.setPrePlnFmEccCd(prePlnFmEccCd[i]);
				if (pastRepoPlnFlg[i] != null)
					model.setPastRepoPlnFlg(pastRepoPlnFlg[i]);
				if (fmEtdDt[i] != null)
					model.setFmEtdDt(fmEtdDt[i]);
				if (prePlnToEccCd[i] != null)
					model.setPrePlnToEccCd(prePlnToEccCd[i]);
				if (prePlnTsFlg[i] != null)
					model.setPrePlnTsFlg(prePlnTsFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqrVslLdisPlnCodTmpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqrVslLdisPlnCodTmpVO[]
	 */
	public EqrVslLdisPlnCodTmpVO[] getEqrVslLdisPlnCodTmpVOs(){
		EqrVslLdisPlnCodTmpVO[] vos = (EqrVslLdisPlnCodTmpVO[])models.toArray(new EqrVslLdisPlnCodTmpVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtbDt = this.toEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEccCd = this.toEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePlnFmEtdDt = this.prePlnFmEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSeq = this.plnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneCd = this.vslLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEccCd = this.fmEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePlnToEtaDt = this.prePlnToEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePlnFmEccCd = this.prePlnFmEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pastRepoPlnFlg = this.pastRepoPlnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEtdDt = this.fmEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePlnToEccCd = this.prePlnToEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePlnTsFlg = this.prePlnTsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
