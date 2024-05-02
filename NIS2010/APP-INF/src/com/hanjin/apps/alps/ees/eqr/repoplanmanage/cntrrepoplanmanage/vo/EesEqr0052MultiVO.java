/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0052MultiVO.java
*@FileTitle : EesEqr0052MultiVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		Lee Byoung Hun				2009.09.02		1.0 최초 생성
*
*@LastModifyDate : 2009.09.02
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.02  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0052MultiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0052MultiVO> models = new ArrayList<EesEqr0052MultiVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String trspCostAmt = null;
	/* Column Info */
	private String trspModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslLaneCd = null;
	/* Column Info */
	private String fmYrwk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmEccCostAmt = null;
	/* Column Info */
	private String toEtaDt = null;
	/* Column Info */
	private String fmEtdDt = null;
	/* Column Info */
	private String pastRepoPlnFlg = null;
	/* Column Info */
	private List<String> cntrTpszCd = null;
	/* Column Info */
	private List<String> cntrQty = null;
	/* Column Info */
	private List<String> lodgDchgCostAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String toEccCd = null;
	/* Column Info */
	private String plnUcAmt = null;
	/* Column Info */
	private String toEccCostAmt = null;
	/* Column Info */
	private String ldisTsFlg = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String plnSeq = null;
	/* Column Info */
	private String lodgPortCostAmt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String fmEccCd = null;
	/* Column Info */
	private String toYrwk = null;
	/* Column Info */
	private String dchgPortCostAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0052MultiVO() {}

	public EesEqr0052MultiVO(String ibflag, String pagerows, String repoPlnId, String plnYrwk, String plnSeq, String vslLaneCd, String vslCd, String skdVoyNo, String skdDirCd, String fmEccCd, String toEccCd, String fmEtdDt, String toEtaDt, String trspModCd, String pastRepoPlnFlg, String ldisTsFlg, String cntrTpszCd, String cntrQty, String lodgDchgCostAmt, String updUsrId, String plnUcAmt, String lodgPortCostAmt, String dchgPortCostAmt, String trspCostAmt, String fmEccCostAmt, String toEccCostAmt, String fmYrwk, String toYrwk) {
		this.vslCd = vslCd;
		this.plnYrwk = plnYrwk;
		this.trspCostAmt = trspCostAmt;
		this.trspModCd = trspModCd;
		this.pagerows = pagerows;
		this.vslLaneCd = vslLaneCd;
		this.fmYrwk = fmYrwk;
		this.ibflag = ibflag;
		this.fmEccCostAmt = fmEccCostAmt;
		this.toEtaDt = toEtaDt;
		this.fmEtdDt = fmEtdDt;
		this.pastRepoPlnFlg = pastRepoPlnFlg;
		this.updUsrId = updUsrId;
		this.toEccCd = toEccCd;
		this.plnUcAmt = plnUcAmt;
		this.toEccCostAmt = toEccCostAmt;
		this.ldisTsFlg = ldisTsFlg;
		this.skdVoyNo = skdVoyNo;
		this.plnSeq = plnSeq;
		this.lodgPortCostAmt = lodgPortCostAmt;
		this.skdDirCd = skdDirCd;
		this.repoPlnId = repoPlnId;
		this.fmEccCd = fmEccCd;
		this.toYrwk = toYrwk;
		this.dchgPortCostAmt = dchgPortCostAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("trsp_cost_amt", getTrspCostAmt());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_lane_cd", getVslLaneCd());
		this.hashColumns.put("fm_yrwk", getFmYrwk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_ecc_cost_amt", getFmEccCostAmt());
		this.hashColumns.put("to_eta_dt", getToEtaDt());
		this.hashColumns.put("fm_etd_dt", getFmEtdDt());
		this.hashColumns.put("past_repo_pln_flg", getPastRepoPlnFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("to_ecc_cd", getToEccCd());
		this.hashColumns.put("pln_uc_amt", getPlnUcAmt());
		this.hashColumns.put("to_ecc_cost_amt", getToEccCostAmt());
		this.hashColumns.put("ldis_ts_flg", getLdisTsFlg());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pln_seq", getPlnSeq());
		this.hashColumns.put("lodg_port_cost_amt", getLodgPortCostAmt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("fm_ecc_cd", getFmEccCd());
		this.hashColumns.put("to_yrwk", getToYrwk());
		this.hashColumns.put("dchg_port_cost_amt", getDchgPortCostAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("trsp_cost_amt", "trspCostAmt");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_lane_cd", "vslLaneCd");
		this.hashFields.put("fm_yrwk", "fmYrwk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_ecc_cost_amt", "fmEccCostAmt");
		this.hashFields.put("to_eta_dt", "toEtaDt");
		this.hashFields.put("fm_etd_dt", "fmEtdDt");
		this.hashFields.put("past_repo_pln_flg", "pastRepoPlnFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("lodg_dchg_cost_amt", "lodgDchgCostAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("to_ecc_cd", "toEccCd");
		this.hashFields.put("tablenm", "tablenm");
		this.hashFields.put("pln_uc_amt", "plnUcAmt");
		this.hashFields.put("to_ecc_cost_amt", "toEccCostAmt");
		this.hashFields.put("ldis_ts_flg", "ldisTsFlg");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pln_seq", "plnSeq");
		this.hashFields.put("lodg_port_cost_amt", "lodgPortCostAmt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("fm_ecc_cd", "fmEccCd");
		this.hashFields.put("to_yrwk", "toYrwk");
		this.hashFields.put("dchg_port_cost_amt", "dchgPortCostAmt");
		return this.hashFields;
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
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}
	
	/**
	 * Column Info
	 * @return trspCostAmt
	 */
	public String getTrspCostAmt() {
		return this.trspCostAmt;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
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
	 * Column Info
	 * @return fmYrwk
	 */
	public String getFmYrwk() {
		return this.fmYrwk;
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
	 * @return fmEccCostAmt
	 */
	public String getFmEccCostAmt() {
		return this.fmEccCostAmt;
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
	 * @return pastRepoPlnFlg
	 */
	public String getPastRepoPlnFlg() {
		return this.pastRepoPlnFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public List<String> getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public List<String> getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return lodgDchgCostAmt
	 */
	public List<String> getLodgDchgCostAmt() {
		return this.lodgDchgCostAmt;
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
	 * @return toEccCd
	 */
	public String getToEccCd() {
		return this.toEccCd;
	}
	
	/**
	 * Column Info
	 * @return plnUcAmt
	 */
	public String getPlnUcAmt() {
		return this.plnUcAmt;
	}
	
	/**
	 * Column Info
	 * @return toEccCostAmt
	 */
	public String getToEccCostAmt() {
		return this.toEccCostAmt;
	}
	
	/**
	 * Column Info
	 * @return ldisTsFlg
	 */
	public String getLdisTsFlg() {
		return this.ldisTsFlg;
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
	 * @return plnSeq
	 */
	public String getPlnSeq() {
		return this.plnSeq;
	}
	
	/**
	 * Column Info
	 * @return lodgPortCostAmt
	 */
	public String getLodgPortCostAmt() {
		return this.lodgPortCostAmt;
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
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
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
	 * @return toYrwk
	 */
	public String getToYrwk() {
		return this.toYrwk;
	}
	
	/**
	 * Column Info
	 * @return dchgPortCostAmt
	 */
	public String getDchgPortCostAmt() {
		return this.dchgPortCostAmt;
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
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}
	
	/**
	 * Column Info
	 * @param trspCostAmt
	 */
	public void setTrspCostAmt(String trspCostAmt) {
		this.trspCostAmt = trspCostAmt;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
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
	 * Column Info
	 * @param fmYrwk
	 */
	public void setFmYrwk(String fmYrwk) {
		this.fmYrwk = fmYrwk;
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
	 * @param fmEccCostAmt
	 */
	public void setFmEccCostAmt(String fmEccCostAmt) {
		this.fmEccCostAmt = fmEccCostAmt;
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
	 * @param pastRepoPlnFlg
	 */
	public void setPastRepoPlnFlg(String pastRepoPlnFlg) {
		this.pastRepoPlnFlg = pastRepoPlnFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(List<String> cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(List<String> cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param lodgDchgCostAmt
	 */
	public void setLodgDchgCostAmt(List<String> lodgDchgCostAmt) {
		this.lodgDchgCostAmt = lodgDchgCostAmt;
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
	 * @param toEccCd
	 */
	public void setToEccCd(String toEccCd) {
		this.toEccCd = toEccCd;
	}
	
	/**
	 * Column Info
	 * @param plnUcAmt
	 */
	public void setPlnUcAmt(String plnUcAmt) {
		this.plnUcAmt = plnUcAmt;
	}
	
	/**
	 * Column Info
	 * @param toEccCostAmt
	 */
	public void setToEccCostAmt(String toEccCostAmt) {
		this.toEccCostAmt = toEccCostAmt;
	}
	
	/**
	 * Column Info
	 * @param ldisTsFlg
	 */
	public void setLdisTsFlg(String ldisTsFlg) {
		this.ldisTsFlg = ldisTsFlg;
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
	 * @param plnSeq
	 */
	public void setPlnSeq(String plnSeq) {
		this.plnSeq = plnSeq;
	}
	
	/**
	 * Column Info
	 * @param lodgPortCostAmt
	 */
	public void setLodgPortCostAmt(String lodgPortCostAmt) {
		this.lodgPortCostAmt = lodgPortCostAmt;
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
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
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
	 * @param toYrwk
	 */
	public void setToYrwk(String toYrwk) {
		this.toYrwk = toYrwk;
	}
	
	/**
	 * Column Info
	 * @param dchgPortCostAmt
	 */
	public void setDchgPortCostAmt(String dchgPortCostAmt) {
		this.dchgPortCostAmt = dchgPortCostAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setTrspCostAmt(JSPUtil.getParameter(request, "trsp_cost_amt", ""));
		setTrspModCd(JSPUtil.getParameter(request, "trsp_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVslLaneCd(JSPUtil.getParameter(request, "vsl_lane_cd", ""));
		setFmYrwk(JSPUtil.getParameter(request, "fm_yrwk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmEccCostAmt(JSPUtil.getParameter(request, "fm_ecc_cost_amt", ""));
		setToEtaDt(JSPUtil.getParameter(request, "to_eta_dt", ""));
		setFmEtdDt(JSPUtil.getParameter(request, "fm_etd_dt", ""));
		setPastRepoPlnFlg(JSPUtil.getParameter(request, "past_repo_pln_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setToEccCd(JSPUtil.getParameter(request, "to_ecc_cd", ""));
		setPlnUcAmt(JSPUtil.getParameter(request, "pln_uc_amt", ""));
		setToEccCostAmt(JSPUtil.getParameter(request, "to_ecc_cost_amt", ""));
		setLdisTsFlg(JSPUtil.getParameter(request, "ldis_ts_flg", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setPlnSeq(JSPUtil.getParameter(request, "pln_seq", ""));
		setLodgPortCostAmt(JSPUtil.getParameter(request, "lodg_port_cost_amt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setFmEccCd(JSPUtil.getParameter(request, "fm_ecc_cd", ""));
		setToYrwk(JSPUtil.getParameter(request, "to_yrwk", ""));
		setDchgPortCostAmt(JSPUtil.getParameter(request, "dchg_port_cost_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0052MultiVO[]
	 */
	public EesEqr0052MultiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0052MultiVO[]
	 */
	public EesEqr0052MultiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0052MultiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] trspCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_amt", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslLaneCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_cd", length));
			String[] fmYrwk = (JSPUtil.getParameter(request, prefix	+ "fm_yrwk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmEccCostAmt = (JSPUtil.getParameter(request, prefix	+ "fm_ecc_cost_amt", length));
			String[] toEtaDt = (JSPUtil.getParameter(request, prefix	+ "to_eta_dt", length));
			String[] fmEtdDt = (JSPUtil.getParameter(request, prefix	+ "fm_etd_dt", length));
			String[] pastRepoPlnFlg = (JSPUtil.getParameter(request, prefix	+ "past_repo_pln_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] toEccCd = (JSPUtil.getParameter(request, prefix	+ "to_ecc_cd", length));
			String[] plnUcAmt = (JSPUtil.getParameter(request, prefix	+ "pln_uc_amt", length));
			String[] toEccCostAmt = (JSPUtil.getParameter(request, prefix	+ "to_ecc_cost_amt", length));
			String[] ldisTsFlg = (JSPUtil.getParameter(request, prefix	+ "ldis_ts_flg", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] plnSeq = (JSPUtil.getParameter(request, prefix	+ "pln_seq", length));
			String[] lodgPortCostAmt = (JSPUtil.getParameter(request, prefix	+ "lodg_port_cost_amt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] fmEccCd = (JSPUtil.getParameter(request, prefix	+ "fm_ecc_cd", length));
			String[] toYrwk = (JSPUtil.getParameter(request, prefix	+ "to_yrwk", length));
			String[] dchgPortCostAmt = (JSPUtil.getParameter(request, prefix	+ "dchg_port_cost_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0052MultiVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (trspCostAmt[i] != null)
					model.setTrspCostAmt(trspCostAmt[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslLaneCd[i] != null)
					model.setVslLaneCd(vslLaneCd[i]);
				if (fmYrwk[i] != null)
					model.setFmYrwk(fmYrwk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmEccCostAmt[i] != null)
					model.setFmEccCostAmt(fmEccCostAmt[i]);
				if (toEtaDt[i] != null)
					model.setToEtaDt(toEtaDt[i]);
				if (fmEtdDt[i] != null)
					model.setFmEtdDt(fmEtdDt[i]);
				if (pastRepoPlnFlg[i] != null)
					model.setPastRepoPlnFlg(pastRepoPlnFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (toEccCd[i] != null)
					model.setToEccCd(toEccCd[i]);
				if (plnUcAmt[i] != null)
					model.setPlnUcAmt(plnUcAmt[i]);
				if (toEccCostAmt[i] != null)
					model.setToEccCostAmt(toEccCostAmt[i]);
				if (ldisTsFlg[i] != null)
					model.setLdisTsFlg(ldisTsFlg[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				if (lodgPortCostAmt[i] != null)
					model.setLodgPortCostAmt(lodgPortCostAmt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (fmEccCd[i] != null)
					model.setFmEccCd(fmEccCd[i]);
				if (toYrwk[i] != null)
					model.setToYrwk(toYrwk[i]);
				if (dchgPortCostAmt[i] != null)
					model.setDchgPortCostAmt(dchgPortCostAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0052MultiVOs();
	}
	
	/**
	 * EES_EQR_0052 최적화된 REPO InOut 계획 수량 조회/수정 화면에서 사용함.
	 * 
	 * @param request
	 * @param pirfix
	 * @return
	 */
	public EesEqr0052MultiVO[] fromRequestGridArrayList(HttpServletRequest request, String pirfix) {
		EesEqr0052MultiVO model = null;
		int length = request.getParameterValues("ibflag").length;
		String[] prefix = null;
		
		if (!(pirfix.equals(""))){
			prefix = pirfix.split(",");
        }
		
		try {
			String[] ibflag             =  (JSPUtil.getParameter(request, "ibflag", length));
			String[] repo_pln_id        =  (JSPUtil.getParameter(request, "repo_pln_id", length));
			String[] pln_yrwk           =  (JSPUtil.getParameter(request, "pln_yrwk", length));
			String[] pln_seq           =  (JSPUtil.getParameter(request, "pln_seq", length));
			String[] vsl_lane_cd        =  (JSPUtil.getParameter(request, "vsl_lane_cd", length));
			String[] vvd             	=  (JSPUtil.getParameter(request, "vvd", length));
			String[] fm_ecc_cd          =  (JSPUtil.getParameter(request, "fm_ecc_cd", length));
			String[] to_ecc_cd          =  (JSPUtil.getParameter(request, "to_ecc_cd", length));
			String[] fm_etd_dt          =  (JSPUtil.getParameter(request, "fm_etd_dt", length));
			String[] to_eta_dt          =  (JSPUtil.getParameter(request, "to_eta_dt", length));				
			List<String[]> cntr_tpsz_cd_arr    =  new ArrayList<String[]>();
			List<String[]> cntr_qty_arr       	=  new ArrayList<String[]>();
			List<String[]> lodg_dchg_cost_amt_arr =  new ArrayList<String[]>();
			String[] trsp_mod_cd        =  (JSPUtil.getParameter(request, "trsp_mod_cd", length));
			String[] past_repo_pln_flg  =  (JSPUtil.getParameter(request, "past_repo_pln_flg", length));
			String[] ldis_ts_flg        =  (JSPUtil.getParameter(request, "ts", length));
			for (int k = 0 ; k < prefix.length ; k++) {
				String[] qtyArr = (JSPUtil.getParameter(request, prefix[k].toLowerCase() + "cntr_qty", length));
				String[] amtArr = (JSPUtil.getParameter(request, prefix[k].toLowerCase() + "lodg_dchg_cost_amt", length));
				
				cntr_tpsz_cd_arr.add(prefix);
				cntr_qty_arr.add(qtyArr);
				lodg_dchg_cost_amt_arr.add(amtArr);
			}
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0052MultiVO();
				
				model.setIbflag            		  ( ibflag[i]);
				model.setRepoPlnId       		  ( repo_pln_id[i]);
				model.setPlnYrwk          		  ( pln_yrwk[i]);
				model.setPlnSeq          		  ( pln_seq[i]);
				
				// Vessel
				if(trsp_mod_cd[i].equals("V")){
					model.setVslLaneCd       		  ( vsl_lane_cd[i]);					
					model.setVslCd            		  ( vvd[i].substring(0,4));
					model.setSkdVoyNo        		  ( vvd[i].substring(4,vvd[i].length()-1));
					model.setSkdDirCd        		  ( vvd[i].substring(vvd[i].length()-1,vvd[i].length()));
					
				// Inland
				}else{
					model.setVslLaneCd       		  ("");					
					model.setVslCd            		  ("");
					model.setSkdVoyNo        		  ("");
					model.setSkdDirCd        		  ("");
				}
				
				model.setFmEtdDt         		  ( fm_etd_dt[i]);
				model.setToEtaDt         		  ( to_eta_dt[i]);
				model.setFmEccCd         		  ( fm_ecc_cd[i]);					
				model.setToEccCd         		  ( to_ecc_cd[i]);
				model.setTrspModCd       		  ( trsp_mod_cd[i]);
				model.setPastRepoPlnFlg        ( past_repo_pln_flg[i]);
				model.setLdisTsFlg              ( ldis_ts_flg[i]);
				
				List<String> cntr_tpsz_cd = new ArrayList<String>();
				List<String> cntr_qty = new ArrayList<String>();
				List<String> lodg_dchg_cost_amt = new ArrayList<String>();
				for (int k=0 ; k < prefix.length ; k++){
					String[] cntrQtyArr  = (String[])cntr_qty_arr.get(k);
					String[] lodgDchgCostAmtArr  = (String[])lodg_dchg_cost_amt_arr.get(k);
					
					cntr_tpsz_cd.add(prefix[k]);
					cntr_qty.add(cntrQtyArr[i]);
					lodg_dchg_cost_amt.add(lodgDchgCostAmtArr[i]);
				}
				model.setCntrTpszCd(cntr_tpsz_cd);
				model.setCntrQty(cntr_qty);
				model.setLodgDchgCostAmt(lodg_dchg_cost_amt);
				
				models.add(model);
			}
		} catch (Exception ex) {
			return null;
		}
		return getEesEqr0052MultiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0052MultiVO[]
	 */
	public EesEqr0052MultiVO[] getEesEqr0052MultiVOs(){
		EesEqr0052MultiVO[] vos = (EesEqr0052MultiVO[])models.toArray(new EesEqr0052MultiVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostAmt = this.trspCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneCd = this.vslLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYrwk = this.fmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEccCostAmt = this.fmEccCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtaDt = this.toEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEtdDt = this.fmEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pastRepoPlnFlg = this.pastRepoPlnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEccCd = this.toEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnUcAmt = this.plnUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEccCostAmt = this.toEccCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldisTsFlg = this.ldisTsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSeq = this.plnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodgPortCostAmt = this.lodgPortCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEccCd = this.fmEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYrwk = this.toYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgPortCostAmt = this.dchgPortCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	
}
