/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnRateInfoVO.java
*@FileTitle : FFCmpnRateInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.16
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.08.16 김상수
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmaudit.ffcmpnaudit.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FFCmpnRateInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<FFCmpnRateInfoVO> models = new ArrayList<FFCmpnRateInfoVO>();

	/* Column Info */
	private String ffBxAmt = null;
	/* Column Info */
	private String ffFeuAmt = null;
	/* Column Info */
	private String porGrpTpCd = null;
	/* Column Info */
	private String ffCntSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ffDivCd = null;
	/* Column Info */
	private String podRoutCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ffTeuAmt = null;
	/* Column Info */
	private String ffCntCustNm = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String ffRfAmt = null;
	/* Column Info */
	private String fmEffDt = null;
	/* Column Info */
	private String porRoutCd = null;
	/* Column Info */
	private String shprCntNm = null;
	/* Column Info */
	private String polRoutCd = null;
	/* Column Info */
	private String polGrpTpCd = null;
	/* Column Info */
	private String ffBkgRt = null;
	/* Column Info */
	private String toEffDt = null;
	/* Column Info */
	private String ffChgCtnt = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String cmdtTpCd = null;
	/* Column Info */
	private String podGrpTpCd = null;
	/* Column Info */
	private String shprCntSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public FFCmpnRateInfoVO() {}

	public FFCmpnRateInfoVO(String ibflag, String pagerows, String ffCntSeq, String ffCntCustNm, String shprCntSeq, String shprCntNm, String porGrpTpCd, String porRoutCd, String polGrpTpCd, String polRoutCd, String podGrpTpCd, String podRoutCd, String fmEffDt, String toEffDt, String scNo, String rfaNo, String cmdtTpCd, String cmdtCd, String cmdtNm, String ffDivCd, String ffBkgRt, String ffBxAmt, String ffTeuAmt, String ffFeuAmt, String ffRfAmt, String ffChgCtnt) {
		this.ffBxAmt = ffBxAmt;
		this.ffFeuAmt = ffFeuAmt;
		this.porGrpTpCd = porGrpTpCd;
		this.ffCntSeq = ffCntSeq;
		this.pagerows = pagerows;
		this.ffDivCd = ffDivCd;
		this.podRoutCd = podRoutCd;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.ffTeuAmt = ffTeuAmt;
		this.ffCntCustNm = ffCntCustNm;
		this.cmdtCd = cmdtCd;
		this.scNo = scNo;
		this.ffRfAmt = ffRfAmt;
		this.fmEffDt = fmEffDt;
		this.porRoutCd = porRoutCd;
		this.shprCntNm = shprCntNm;
		this.polRoutCd = polRoutCd;
		this.polGrpTpCd = polGrpTpCd;
		this.ffBkgRt = ffBkgRt;
		this.toEffDt = toEffDt;
		this.ffChgCtnt = ffChgCtnt;
		this.cmdtNm = cmdtNm;
		this.cmdtTpCd = cmdtTpCd;
		this.podGrpTpCd = podGrpTpCd;
		this.shprCntSeq = shprCntSeq;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ff_bx_amt", getFfBxAmt());
		this.hashColumns.put("ff_feu_amt", getFfFeuAmt());
		this.hashColumns.put("por_grp_tp_cd", getPorGrpTpCd());
		this.hashColumns.put("ff_cnt_seq", getFfCntSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ff_div_cd", getFfDivCd());
		this.hashColumns.put("pod_rout_cd", getPodRoutCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ff_teu_amt", getFfTeuAmt());
		this.hashColumns.put("ff_cnt_cust_nm", getFfCntCustNm());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ff_rf_amt", getFfRfAmt());
		this.hashColumns.put("fm_eff_dt", getFmEffDt());
		this.hashColumns.put("por_rout_cd", getPorRoutCd());
		this.hashColumns.put("shpr_cnt_nm", getShprCntNm());
		this.hashColumns.put("pol_rout_cd", getPolRoutCd());
		this.hashColumns.put("pol_grp_tp_cd", getPolGrpTpCd());
		this.hashColumns.put("ff_bkg_rt", getFfBkgRt());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("ff_chg_ctnt", getFfChgCtnt());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("cmdt_tp_cd", getCmdtTpCd());
		this.hashColumns.put("pod_grp_tp_cd", getPodGrpTpCd());
		this.hashColumns.put("shpr_cnt_seq", getShprCntSeq());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ff_bx_amt", "ffBxAmt");
		this.hashFields.put("ff_feu_amt", "ffFeuAmt");
		this.hashFields.put("por_grp_tp_cd", "porGrpTpCd");
		this.hashFields.put("ff_cnt_seq", "ffCntSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ff_div_cd", "ffDivCd");
		this.hashFields.put("pod_rout_cd", "podRoutCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ff_teu_amt", "ffTeuAmt");
		this.hashFields.put("ff_cnt_cust_nm", "ffCntCustNm");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ff_rf_amt", "ffRfAmt");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		this.hashFields.put("por_rout_cd", "porRoutCd");
		this.hashFields.put("shpr_cnt_nm", "shprCntNm");
		this.hashFields.put("pol_rout_cd", "polRoutCd");
		this.hashFields.put("pol_grp_tp_cd", "polGrpTpCd");
		this.hashFields.put("ff_bkg_rt", "ffBkgRt");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("ff_chg_ctnt", "ffChgCtnt");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("cmdt_tp_cd", "cmdtTpCd");
		this.hashFields.put("pod_grp_tp_cd", "podGrpTpCd");
		this.hashFields.put("shpr_cnt_seq", "shprCntSeq");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return ffBxAmt
	 */
	public String getFfBxAmt() {
		return this.ffBxAmt;
	}

	/**
	 * Column Info
	 * @return ffFeuAmt
	 */
	public String getFfFeuAmt() {
		return this.ffFeuAmt;
	}

	/**
	 * Column Info
	 * @return porGrpTpCd
	 */
	public String getPorGrpTpCd() {
		return this.porGrpTpCd;
	}

	/**
	 * Column Info
	 * @return ffCntSeq
	 */
	public String getFfCntSeq() {
		return this.ffCntSeq;
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
	 * @return ffDivCd
	 */
	public String getFfDivCd() {
		return this.ffDivCd;
	}

	/**
	 * Column Info
	 * @return podRoutCd
	 */
	public String getPodRoutCd() {
		return this.podRoutCd;
	}

	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return ffTeuAmt
	 */
	public String getFfTeuAmt() {
		return this.ffTeuAmt;
	}

	/**
	 * Column Info
	 * @return ffCntCustNm
	 */
	public String getFfCntCustNm() {
		return this.ffCntCustNm;
	}

	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}

	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}

	/**
	 * Column Info
	 * @return ffRfAmt
	 */
	public String getFfRfAmt() {
		return this.ffRfAmt;
	}

	/**
	 * Column Info
	 * @return fmEffDt
	 */
	public String getFmEffDt() {
		return this.fmEffDt;
	}

	/**
	 * Column Info
	 * @return porRoutCd
	 */
	public String getPorRoutCd() {
		return this.porRoutCd;
	}

	/**
	 * Column Info
	 * @return shprCntNm
	 */
	public String getShprCntNm() {
		return this.shprCntNm;
	}

	/**
	 * Column Info
	 * @return polRoutCd
	 */
	public String getPolRoutCd() {
		return this.polRoutCd;
	}

	/**
	 * Column Info
	 * @return polGrpTpCd
	 */
	public String getPolGrpTpCd() {
		return this.polGrpTpCd;
	}

	/**
	 * Column Info
	 * @return ffBkgRt
	 */
	public String getFfBkgRt() {
		return this.ffBkgRt;
	}

	/**
	 * Column Info
	 * @return toEffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
	}

	/**
	 * Column Info
	 * @return ffChgCtnt
	 */
	public String getFfChgCtnt() {
		return this.ffChgCtnt;
	}

	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}

	/**
	 * Column Info
	 * @return cmdtTpCd
	 */
	public String getCmdtTpCd() {
		return this.cmdtTpCd;
	}

	/**
	 * Column Info
	 * @return podGrpTpCd
	 */
	public String getPodGrpTpCd() {
		return this.podGrpTpCd;
	}

	/**
	 * Column Info
	 * @return shprCntSeq
	 */
	public String getShprCntSeq() {
		return this.shprCntSeq;
	}


	/**
	 * Column Info
	 * @param ffBxAmt
	 */
	public void setFfBxAmt(String ffBxAmt) {
		this.ffBxAmt = ffBxAmt;
	}

	/**
	 * Column Info
	 * @param ffFeuAmt
	 */
	public void setFfFeuAmt(String ffFeuAmt) {
		this.ffFeuAmt = ffFeuAmt;
	}

	/**
	 * Column Info
	 * @param porGrpTpCd
	 */
	public void setPorGrpTpCd(String porGrpTpCd) {
		this.porGrpTpCd = porGrpTpCd;
	}

	/**
	 * Column Info
	 * @param ffCntSeq
	 */
	public void setFfCntSeq(String ffCntSeq) {
		this.ffCntSeq = ffCntSeq;
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
	 * @param ffDivCd
	 */
	public void setFfDivCd(String ffDivCd) {
		this.ffDivCd = ffDivCd;
	}

	/**
	 * Column Info
	 * @param podRoutCd
	 */
	public void setPodRoutCd(String podRoutCd) {
		this.podRoutCd = podRoutCd;
	}

	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param ffTeuAmt
	 */
	public void setFfTeuAmt(String ffTeuAmt) {
		this.ffTeuAmt = ffTeuAmt;
	}

	/**
	 * Column Info
	 * @param ffCntCustNm
	 */
	public void setFfCntCustNm(String ffCntCustNm) {
		this.ffCntCustNm = ffCntCustNm;
	}

	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	/**
	 * Column Info
	 * @param ffRfAmt
	 */
	public void setFfRfAmt(String ffRfAmt) {
		this.ffRfAmt = ffRfAmt;
	}

	/**
	 * Column Info
	 * @param fmEffDt
	 */
	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
	}

	/**
	 * Column Info
	 * @param porRoutCd
	 */
	public void setPorRoutCd(String porRoutCd) {
		this.porRoutCd = porRoutCd;
	}

	/**
	 * Column Info
	 * @param shprCntNm
	 */
	public void setShprCntNm(String shprCntNm) {
		this.shprCntNm = shprCntNm;
	}

	/**
	 * Column Info
	 * @param polRoutCd
	 */
	public void setPolRoutCd(String polRoutCd) {
		this.polRoutCd = polRoutCd;
	}

	/**
	 * Column Info
	 * @param polGrpTpCd
	 */
	public void setPolGrpTpCd(String polGrpTpCd) {
		this.polGrpTpCd = polGrpTpCd;
	}

	/**
	 * Column Info
	 * @param ffBkgRt
	 */
	public void setFfBkgRt(String ffBkgRt) {
		this.ffBkgRt = ffBkgRt;
	}

	/**
	 * Column Info
	 * @param toEffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
	}

	/**
	 * Column Info
	 * @param ffChgCtnt
	 */
	public void setFfChgCtnt(String ffChgCtnt) {
		this.ffChgCtnt = ffChgCtnt;
	}

	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}

	/**
	 * Column Info
	 * @param cmdtTpCd
	 */
	public void setCmdtTpCd(String cmdtTpCd) {
		this.cmdtTpCd = cmdtTpCd;
	}

	/**
	 * Column Info
	 * @param podGrpTpCd
	 */
	public void setPodGrpTpCd(String podGrpTpCd) {
		this.podGrpTpCd = podGrpTpCd;
	}

	/**
	 * Column Info
	 * @param shprCntSeq
	 */
	public void setShprCntSeq(String shprCntSeq) {
		this.shprCntSeq = shprCntSeq;
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
		setFfBxAmt(JSPUtil.getParameter(request, prefix + "ff_bx_amt", ""));
		setFfFeuAmt(JSPUtil.getParameter(request, prefix + "ff_feu_amt", ""));
		setPorGrpTpCd(JSPUtil.getParameter(request, prefix + "por_grp_tp_cd", ""));
		setFfCntSeq(JSPUtil.getParameter(request, prefix + "ff_cnt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFfDivCd(JSPUtil.getParameter(request, prefix + "ff_div_cd", ""));
		setPodRoutCd(JSPUtil.getParameter(request, prefix + "pod_rout_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFfTeuAmt(JSPUtil.getParameter(request, prefix + "ff_teu_amt", ""));
		setFfCntCustNm(JSPUtil.getParameter(request, prefix + "ff_cnt_cust_nm", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setFfRfAmt(JSPUtil.getParameter(request, prefix + "ff_rf_amt", ""));
		setFmEffDt(JSPUtil.getParameter(request, prefix + "fm_eff_dt", ""));
		setPorRoutCd(JSPUtil.getParameter(request, prefix + "por_rout_cd", ""));
		setShprCntNm(JSPUtil.getParameter(request, prefix + "shpr_cnt_nm", ""));
		setPolRoutCd(JSPUtil.getParameter(request, prefix + "pol_rout_cd", ""));
		setPolGrpTpCd(JSPUtil.getParameter(request, prefix + "pol_grp_tp_cd", ""));
		setFfBkgRt(JSPUtil.getParameter(request, prefix + "ff_bkg_rt", ""));
		setToEffDt(JSPUtil.getParameter(request, prefix + "to_eff_dt", ""));
		setFfChgCtnt(JSPUtil.getParameter(request, prefix + "ff_chg_ctnt", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setCmdtTpCd(JSPUtil.getParameter(request, prefix + "cmdt_tp_cd", ""));
		setPodGrpTpCd(JSPUtil.getParameter(request, prefix + "pod_grp_tp_cd", ""));
		setShprCntSeq(JSPUtil.getParameter(request, prefix + "shpr_cnt_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FFCmpnRateInfoVO[]
	 */
	public FFCmpnRateInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return FFCmpnRateInfoVO[]
	 */
	public FFCmpnRateInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FFCmpnRateInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ffBxAmt = (JSPUtil.getParameter(request, prefix	+ "ff_bx_amt", length));
			String[] ffFeuAmt = (JSPUtil.getParameter(request, prefix	+ "ff_feu_amt", length));
			String[] porGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "por_grp_tp_cd", length));
			String[] ffCntSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ffDivCd = (JSPUtil.getParameter(request, prefix	+ "ff_div_cd", length));
			String[] podRoutCd = (JSPUtil.getParameter(request, prefix	+ "pod_rout_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ffTeuAmt = (JSPUtil.getParameter(request, prefix	+ "ff_teu_amt", length));
			String[] ffCntCustNm = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cust_nm", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] ffRfAmt = (JSPUtil.getParameter(request, prefix	+ "ff_rf_amt", length));
			String[] fmEffDt = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt", length));
			String[] porRoutCd = (JSPUtil.getParameter(request, prefix	+ "por_rout_cd", length));
			String[] shprCntNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_nm", length));
			String[] polRoutCd = (JSPUtil.getParameter(request, prefix	+ "pol_rout_cd", length));
			String[] polGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "pol_grp_tp_cd", length));
			String[] ffBkgRt = (JSPUtil.getParameter(request, prefix	+ "ff_bkg_rt", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] ffChgCtnt = (JSPUtil.getParameter(request, prefix	+ "ff_chg_ctnt", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] cmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_tp_cd", length));
			String[] podGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "pod_grp_tp_cd", length));
			String[] shprCntSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_seq", length));

			for (int i = 0; i < length; i++) {
				model = new FFCmpnRateInfoVO();
				if (ffBxAmt[i] != null)
					model.setFfBxAmt(ffBxAmt[i]);
				if (ffFeuAmt[i] != null)
					model.setFfFeuAmt(ffFeuAmt[i]);
				if (porGrpTpCd[i] != null)
					model.setPorGrpTpCd(porGrpTpCd[i]);
				if (ffCntSeq[i] != null)
					model.setFfCntSeq(ffCntSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ffDivCd[i] != null)
					model.setFfDivCd(ffDivCd[i]);
				if (podRoutCd[i] != null)
					model.setPodRoutCd(podRoutCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ffTeuAmt[i] != null)
					model.setFfTeuAmt(ffTeuAmt[i]);
				if (ffCntCustNm[i] != null)
					model.setFfCntCustNm(ffCntCustNm[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (ffRfAmt[i] != null)
					model.setFfRfAmt(ffRfAmt[i]);
				if (fmEffDt[i] != null)
					model.setFmEffDt(fmEffDt[i]);
				if (porRoutCd[i] != null)
					model.setPorRoutCd(porRoutCd[i]);
				if (shprCntNm[i] != null)
					model.setShprCntNm(shprCntNm[i]);
				if (polRoutCd[i] != null)
					model.setPolRoutCd(polRoutCd[i]);
				if (polGrpTpCd[i] != null)
					model.setPolGrpTpCd(polGrpTpCd[i]);
				if (ffBkgRt[i] != null)
					model.setFfBkgRt(ffBkgRt[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (ffChgCtnt[i] != null)
					model.setFfChgCtnt(ffChgCtnt[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (cmdtTpCd[i] != null)
					model.setCmdtTpCd(cmdtTpCd[i]);
				if (podGrpTpCd[i] != null)
					model.setPodGrpTpCd(podGrpTpCd[i]);
				if (shprCntSeq[i] != null)
					model.setShprCntSeq(shprCntSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFFCmpnRateInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FFCmpnRateInfoVO[]
	 */
	public FFCmpnRateInfoVO[] getFFCmpnRateInfoVOs(){
		FFCmpnRateInfoVO[] vos = (FFCmpnRateInfoVO[])models.toArray(new FFCmpnRateInfoVO[models.size()]);
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
		this.ffBxAmt = this.ffBxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffFeuAmt = this.ffFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porGrpTpCd = this.porGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntSeq = this.ffCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffDivCd = this.ffDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podRoutCd = this.podRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffTeuAmt = this.ffTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCustNm = this.ffCntCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffRfAmt = this.ffRfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt = this.fmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porRoutCd = this.porRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntNm = this.shprCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polRoutCd = this.polRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polGrpTpCd = this.polGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffBkgRt = this.ffBkgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffChgCtnt = this.ffChgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTpCd = this.cmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podGrpTpCd = this.podGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntSeq = this.shprCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
