/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : GLineInfoByFICRouteVO.java
 *@FileTitle : GLineInfoByFICRouteVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.08.01
 *@LastModifier : 송민석
 *@LastVersion : 1.0
 * 2012.08.01 송민석 
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GLineInfoByFICRouteVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<GLineInfoByFICRouteVO> models = new ArrayList<GLineInfoByFICRouteVO>();

	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String optmTrspModFlg = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String ficRoutCmbTpCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String routPntLocDefCd = null;
	/* Column Info */
	private String ficRtUseStsCd = null;
	/* Column Info */
	private String ficLoclCurrCd = null;
	/* Column Info */
	private String propFrtRtAmt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String bsePortDefCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ficGlineLoclRtAmt = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String ficGlineUpdDt = null;
	/* Column Info */
	private String prcTrspModCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String ficGlineRtAmt = null;
	/* Column Info */
	private String orgDestTpCd = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public GLineInfoByFICRouteVO() {
	}

	public GLineInfoByFICRouteVO(String ibflag, String pagerows, String ficRtUseStsCd, String ficRoutCmbTpCd, String optmTrspModFlg, String ficGlineRtAmt,
			String ficLoclCurrCd, String ficGlineLoclRtAmt, String ficGlineUpdDt, String prcCgoTpCd, String amdtSeq, String svcScpCd, String routPntLocDefCd,
			String ratUtCd, String propFrtRtAmt, String bsePortDefCd, String effDt, String trfNo, String prcTrspModCd, String rcvDeTermCd, String expDt, String currCd,
			String orgDestTpCd) {
		this.currCd = currCd;
		this.optmTrspModFlg = optmTrspModFlg;
		this.prcCgoTpCd = prcCgoTpCd;
		this.amdtSeq = amdtSeq;
		this.ficRoutCmbTpCd = ficRoutCmbTpCd;
		this.svcScpCd = svcScpCd;
		this.routPntLocDefCd = routPntLocDefCd;
		this.ficRtUseStsCd = ficRtUseStsCd;
		this.ficLoclCurrCd = ficLoclCurrCd;
		this.propFrtRtAmt = propFrtRtAmt;
		this.ratUtCd = ratUtCd;
		this.bsePortDefCd = bsePortDefCd;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.ficGlineLoclRtAmt = ficGlineLoclRtAmt;
		this.trfNo = trfNo;
		this.ficGlineUpdDt = ficGlineUpdDt;
		this.prcTrspModCd = prcTrspModCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.expDt = expDt;
		this.ficGlineRtAmt = ficGlineRtAmt;
		this.orgDestTpCd = orgDestTpCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("optm_trsp_mod_flg", getOptmTrspModFlg());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("fic_rout_cmb_tp_cd", getFicRoutCmbTpCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rout_pnt_loc_def_cd", getRoutPntLocDefCd());
		this.hashColumns.put("fic_rt_use_sts_cd", getFicRtUseStsCd());
		this.hashColumns.put("fic_locl_curr_cd", getFicLoclCurrCd());
		this.hashColumns.put("prop_frt_rt_amt", getPropFrtRtAmt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("bse_port_def_cd", getBsePortDefCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fic_gline_locl_rt_amt", getFicGlineLoclRtAmt());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("fic_gline_upd_dt", getFicGlineUpdDt());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("fic_gline_rt_amt", getFicGlineRtAmt());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("optm_trsp_mod_flg", "optmTrspModFlg");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("fic_rout_cmb_tp_cd", "ficRoutCmbTpCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("rout_pnt_loc_def_cd", "routPntLocDefCd");
		this.hashFields.put("fic_rt_use_sts_cd", "ficRtUseStsCd");
		this.hashFields.put("fic_locl_curr_cd", "ficLoclCurrCd");
		this.hashFields.put("prop_frt_rt_amt", "propFrtRtAmt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("bse_port_def_cd", "bsePortDefCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fic_gline_locl_rt_amt", "ficGlineLoclRtAmt");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("fic_gline_upd_dt", "ficGlineUpdDt");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("fic_gline_rt_amt", "ficGlineRtAmt");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}

	/**
	 * Column Info
	 * 
	 * @return optmTrspModFlg
	 */
	public String getOptmTrspModFlg() {
		return this.optmTrspModFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return ficRoutCmbTpCd
	 */
	public String getFicRoutCmbTpCd() {
		return this.ficRoutCmbTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return routPntLocDefCd
	 */
	public String getRoutPntLocDefCd() {
		return this.routPntLocDefCd;
	}

	/**
	 * Column Info
	 * 
	 * @return ficRtUseStsCd
	 */
	public String getFicRtUseStsCd() {
		return this.ficRtUseStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @return ficLoclCurrCd
	 */
	public String getFicLoclCurrCd() {
		return this.ficLoclCurrCd;
	}

	/**
	 * Column Info
	 * 
	 * @return propFrtRtAmt
	 */
	public String getPropFrtRtAmt() {
		return this.propFrtRtAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}

	/**
	 * Column Info
	 * 
	 * @return bsePortDefCd
	 */
	public String getBsePortDefCd() {
		return this.bsePortDefCd;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return ficGlineLoclRtAmt
	 */
	public String getFicGlineLoclRtAmt() {
		return this.ficGlineLoclRtAmt;
	}

	/**
	 * Column Info
	 * 
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}

	/**
	 * Column Info
	 * 
	 * @return ficGlineUpdDt
	 */
	public String getFicGlineUpdDt() {
		return this.ficGlineUpdDt;
	}

	/**
	 * Column Info
	 * 
	 * @return prcTrspModCd
	 */
	public String getPrcTrspModCd() {
		return this.prcTrspModCd;
	}

	/**
	 * Column Info
	 * 
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}

	/**
	 * Column Info
	 * 
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}

	/**
	 * Column Info
	 * 
	 * @return ficGlineRtAmt
	 */
	public String getFicGlineRtAmt() {
		return this.ficGlineRtAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	/**
	 * Column Info
	 * 
	 * @param optmTrspModFlg
	 */
	public void setOptmTrspModFlg(String optmTrspModFlg) {
		this.optmTrspModFlg = optmTrspModFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param ficRoutCmbTpCd
	 */
	public void setFicRoutCmbTpCd(String ficRoutCmbTpCd) {
		this.ficRoutCmbTpCd = ficRoutCmbTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param routPntLocDefCd
	 */
	public void setRoutPntLocDefCd(String routPntLocDefCd) {
		this.routPntLocDefCd = routPntLocDefCd;
	}

	/**
	 * Column Info
	 * 
	 * @param ficRtUseStsCd
	 */
	public void setFicRtUseStsCd(String ficRtUseStsCd) {
		this.ficRtUseStsCd = ficRtUseStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @param ficLoclCurrCd
	 */
	public void setFicLoclCurrCd(String ficLoclCurrCd) {
		this.ficLoclCurrCd = ficLoclCurrCd;
	}

	/**
	 * Column Info
	 * 
	 * @param propFrtRtAmt
	 */
	public void setPropFrtRtAmt(String propFrtRtAmt) {
		this.propFrtRtAmt = propFrtRtAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}

	/**
	 * Column Info
	 * 
	 * @param bsePortDefCd
	 */
	public void setBsePortDefCd(String bsePortDefCd) {
		this.bsePortDefCd = bsePortDefCd;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param ficGlineLoclRtAmt
	 */
	public void setFicGlineLoclRtAmt(String ficGlineLoclRtAmt) {
		this.ficGlineLoclRtAmt = ficGlineLoclRtAmt;
	}

	/**
	 * Column Info
	 * 
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}

	/**
	 * Column Info
	 * 
	 * @param ficGlineUpdDt
	 */
	public void setFicGlineUpdDt(String ficGlineUpdDt) {
		this.ficGlineUpdDt = ficGlineUpdDt;
	}

	/**
	 * Column Info
	 * 
	 * @param prcTrspModCd
	 */
	public void setPrcTrspModCd(String prcTrspModCd) {
		this.prcTrspModCd = prcTrspModCd;
	}

	/**
	 * Column Info
	 * 
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}

	/**
	 * Column Info
	 * 
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}

	/**
	 * Column Info
	 * 
	 * @param ficGlineRtAmt
	 */
	public void setFicGlineRtAmt(String ficGlineRtAmt) {
		this.ficGlineRtAmt = ficGlineRtAmt;
	}

	public String getOrgDestTpCd() {
		return orgDestTpCd;
	}

	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request, "");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setOptmTrspModFlg(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setFicRoutCmbTpCd(JSPUtil.getParameter(request, prefix + "fic_rout_cmb_tp_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_cd", ""));
		setFicRtUseStsCd(JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd", ""));
		setFicLoclCurrCd(JSPUtil.getParameter(request, prefix + "fic_locl_curr_cd", ""));
		setPropFrtRtAmt(JSPUtil.getParameter(request, prefix + "prop_frt_rt_amt", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setBsePortDefCd(JSPUtil.getParameter(request, prefix + "bse_port_def_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFicGlineLoclRtAmt(JSPUtil.getParameter(request, prefix + "fic_gline_locl_rt_amt", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setFicGlineUpdDt(JSPUtil.getParameter(request, prefix + "fic_gline_upd_dt", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setFicGlineRtAmt(JSPUtil.getParameter(request, prefix + "fic_gline_rt_amt", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return GLineInfoByFICRouteVO[]
	 */
	public GLineInfoByFICRouteVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return GLineInfoByFICRouteVO[]
	 */
	public GLineInfoByFICRouteVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GLineInfoByFICRouteVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
			String[] optmTrspModFlg = (JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix + "amdt_seq", length));
			String[] ficRoutCmbTpCd = (JSPUtil.getParameter(request, prefix + "fic_rout_cmb_tp_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd", length));
			String[] routPntLocDefCd = (JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_cd", length));
			String[] ficRtUseStsCd = (JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd", length));
			String[] ficLoclCurrCd = (JSPUtil.getParameter(request, prefix + "fic_locl_curr_cd", length));
			String[] propFrtRtAmt = (JSPUtil.getParameter(request, prefix + "prop_frt_rt_amt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix + "rat_ut_cd", length));
			String[] bsePortDefCd = (JSPUtil.getParameter(request, prefix + "bse_port_def_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix + "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] ficGlineLoclRtAmt = (JSPUtil.getParameter(request, prefix + "fic_gline_locl_rt_amt", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix + "trf_no", length));
			String[] ficGlineUpdDt = (JSPUtil.getParameter(request, prefix + "fic_gline_upd_dt", length));
			String[] prcTrspModCd = (JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix + "exp_dt", length));
			String[] ficGlineRtAmt = (JSPUtil.getParameter(request, prefix + "fic_gline_rt_amt", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", length));

			for (int i = 0; i < length; i++) {
				model = new GLineInfoByFICRouteVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (optmTrspModFlg[i] != null)
					model.setOptmTrspModFlg(optmTrspModFlg[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (ficRoutCmbTpCd[i] != null)
					model.setFicRoutCmbTpCd(ficRoutCmbTpCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (routPntLocDefCd[i] != null)
					model.setRoutPntLocDefCd(routPntLocDefCd[i]);
				if (ficRtUseStsCd[i] != null)
					model.setFicRtUseStsCd(ficRtUseStsCd[i]);
				if (ficLoclCurrCd[i] != null)
					model.setFicLoclCurrCd(ficLoclCurrCd[i]);
				if (propFrtRtAmt[i] != null)
					model.setPropFrtRtAmt(propFrtRtAmt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (bsePortDefCd[i] != null)
					model.setBsePortDefCd(bsePortDefCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ficGlineLoclRtAmt[i] != null)
					model.setFicGlineLoclRtAmt(ficGlineLoclRtAmt[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (ficGlineUpdDt[i] != null)
					model.setFicGlineUpdDt(ficGlineUpdDt[i]);
				if (prcTrspModCd[i] != null)
					model.setPrcTrspModCd(prcTrspModCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (ficGlineRtAmt[i] != null)
					model.setFicGlineRtAmt(ficGlineRtAmt[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGLineInfoByFICRouteVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return GLineInfoByFICRouteVO[]
	 */
	public GLineInfoByFICRouteVO[] getGLineInfoByFICRouteVOs() {
		GLineInfoByFICRouteVO[] vos = (GLineInfoByFICRouteVO[]) models.toArray(new GLineInfoByFICRouteVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModFlg = this.optmTrspModFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRoutCmbTpCd = this.ficRoutCmbTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefCd = this.routPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRtUseStsCd = this.ficRtUseStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficLoclCurrCd = this.ficLoclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propFrtRtAmt = this.propFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortDefCd = this.bsePortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineLoclRtAmt = this.ficGlineLoclRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineUpdDt = this.ficGlineUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd = this.prcTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficGlineRtAmt = this.ficGlineRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
