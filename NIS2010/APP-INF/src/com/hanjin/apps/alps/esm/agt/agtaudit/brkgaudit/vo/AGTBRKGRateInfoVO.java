/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTBRKGRateInfoVO.java
*@FileTitle : AGTBRKGRateInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.10.08 이호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo;

import java.lang.reflect.Field;
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
 * @author 이호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AGTBRKGRateInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AGTBRKGRateInfoVO> models = new ArrayList<AGTBRKGRateInfoVO>();
	
	/* Column Info */
	private String porGrpTpCd = null;
	/* Column Info */
	private String brogTeuRt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podRoutCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String brogDivCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String brogCntCustSeq = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String fmEffDt = null;
	/* Column Info */
	private String brogCntCd = null;
	/* Column Info */
	private String porRoutCd = null;
	/* Column Info */
	private String shprCntNm = null;
	/* Column Info */
	private String polRoutCd = null;
	/* Column Info */
	private String brogRfRt = null;
	/* Column Info */
	private String polGrpTpCd = null;
	/* Column Info */
	private String bkgBrogRt = null;
	/* Column Info */
	private String asbrogFeuRt = null;
	/* Column Info */
	private String brogCntCustNm = null;
	/* Column Info */
	private String brogChgCtnt = null;
	/* Column Info */
	private String toEffDt = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String cmdtTpCd = null;
	/* Column Info */
	private String brogBxRt = null;
	/* Column Info */
	private String brogCustSeq = null;
	/* Column Info */
	private String brogKndCd = null;
	/* Column Info */
	private String brogRtSeq = null;
	/* Column Info */
	private String podGrpTpCd = null;
	/* Column Info */
	private String shprCntSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AGTBRKGRateInfoVO() {}

	public AGTBRKGRateInfoVO(String ibflag, String pagerows, String brogCntCustSeq, String brogCntCustNm, String shprCntSeq, String shprCntNm, String porGrpTpCd, String porRoutCd, String polGrpTpCd, String polRoutCd, String podGrpTpCd, String podRoutCd, String fmEffDt, String toEffDt, String scNo, String rfaNo, String cmdtTpCd, String cmdtCd, String cmdtNm, String brogDivCd, String bkgBrogRt, String brogBxRt, String brogTeuRt, String asbrogFeuRt, String brogRfRt, String brogChgCtnt, String brogKndCd, String brogCntCd, String brogCustSeq, String brogRtSeq) {
		this.porGrpTpCd = porGrpTpCd;
		this.brogTeuRt = brogTeuRt;
		this.pagerows = pagerows;
		this.podRoutCd = podRoutCd;
		this.rfaNo = rfaNo;
		this.brogDivCd = brogDivCd;
		this.ibflag = ibflag;
		this.brogCntCustSeq = brogCntCustSeq;
		this.cmdtCd = cmdtCd;
		this.scNo = scNo;
		this.fmEffDt = fmEffDt;
		this.brogCntCd = brogCntCd;
		this.porRoutCd = porRoutCd;
		this.shprCntNm = shprCntNm;
		this.polRoutCd = polRoutCd;
		this.brogRfRt = brogRfRt;
		this.polGrpTpCd = polGrpTpCd;
		this.bkgBrogRt = bkgBrogRt;
		this.asbrogFeuRt = asbrogFeuRt;
		this.brogCntCustNm = brogCntCustNm;
		this.brogChgCtnt = brogChgCtnt;
		this.toEffDt = toEffDt;
		this.cmdtNm = cmdtNm;
		this.cmdtTpCd = cmdtTpCd;
		this.brogBxRt = brogBxRt;
		this.brogCustSeq = brogCustSeq;
		this.brogKndCd = brogKndCd;
		this.brogRtSeq = brogRtSeq;
		this.podGrpTpCd = podGrpTpCd;
		this.shprCntSeq = shprCntSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_grp_tp_cd", getPorGrpTpCd());
		this.hashColumns.put("brog_teu_rt", getBrogTeuRt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_rout_cd", getPodRoutCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("brog_div_cd", getBrogDivCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("brog_cnt_cust_seq", getBrogCntCustSeq());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("fm_eff_dt", getFmEffDt());
		this.hashColumns.put("brog_cnt_cd", getBrogCntCd());
		this.hashColumns.put("por_rout_cd", getPorRoutCd());
		this.hashColumns.put("shpr_cnt_nm", getShprCntNm());
		this.hashColumns.put("pol_rout_cd", getPolRoutCd());
		this.hashColumns.put("brog_rf_rt", getBrogRfRt());
		this.hashColumns.put("pol_grp_tp_cd", getPolGrpTpCd());
		this.hashColumns.put("bkg_brog_rt", getBkgBrogRt());
		this.hashColumns.put("asbrog_feu_rt", getAsbrogFeuRt());
		this.hashColumns.put("brog_cnt_cust_nm", getBrogCntCustNm());
		this.hashColumns.put("brog_chg_ctnt", getBrogChgCtnt());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("cmdt_tp_cd", getCmdtTpCd());
		this.hashColumns.put("brog_bx_rt", getBrogBxRt());
		this.hashColumns.put("brog_cust_seq", getBrogCustSeq());
		this.hashColumns.put("brog_knd_cd", getBrogKndCd());
		this.hashColumns.put("brog_rt_seq", getBrogRtSeq());
		this.hashColumns.put("pod_grp_tp_cd", getPodGrpTpCd());
		this.hashColumns.put("shpr_cnt_seq", getShprCntSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_grp_tp_cd", "porGrpTpCd");
		this.hashFields.put("brog_teu_rt", "brogTeuRt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_rout_cd", "podRoutCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("brog_div_cd", "brogDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("brog_cnt_cust_seq", "brogCntCustSeq");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		this.hashFields.put("brog_cnt_cd", "brogCntCd");
		this.hashFields.put("por_rout_cd", "porRoutCd");
		this.hashFields.put("shpr_cnt_nm", "shprCntNm");
		this.hashFields.put("pol_rout_cd", "polRoutCd");
		this.hashFields.put("brog_rf_rt", "brogRfRt");
		this.hashFields.put("pol_grp_tp_cd", "polGrpTpCd");
		this.hashFields.put("bkg_brog_rt", "bkgBrogRt");
		this.hashFields.put("asbrog_feu_rt", "asbrogFeuRt");
		this.hashFields.put("brog_cnt_cust_nm", "brogCntCustNm");
		this.hashFields.put("brog_chg_ctnt", "brogChgCtnt");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("cmdt_tp_cd", "cmdtTpCd");
		this.hashFields.put("brog_bx_rt", "brogBxRt");
		this.hashFields.put("brog_cust_seq", "brogCustSeq");
		this.hashFields.put("brog_knd_cd", "brogKndCd");
		this.hashFields.put("brog_rt_seq", "brogRtSeq");
		this.hashFields.put("pod_grp_tp_cd", "podGrpTpCd");
		this.hashFields.put("shpr_cnt_seq", "shprCntSeq");
		return this.hashFields;
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
	 * @return brogTeuRt
	 */
	public String getBrogTeuRt() {
		return this.brogTeuRt;
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
	 * Column Info
	 * @return brogDivCd
	 */
	public String getBrogDivCd() {
		return this.brogDivCd;
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
	 * @return brogCntCustSeq
	 */
	public String getBrogCntCustSeq() {
		return this.brogCntCustSeq;
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
	 * @return fmEffDt
	 */
	public String getFmEffDt() {
		return this.fmEffDt;
	}
	
	/**
	 * Column Info
	 * @return brogCntCd
	 */
	public String getBrogCntCd() {
		return this.brogCntCd;
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
	 * @return brogRfRt
	 */
	public String getBrogRfRt() {
		return this.brogRfRt;
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
	 * @return bkgBrogRt
	 */
	public String getBkgBrogRt() {
		return this.bkgBrogRt;
	}
	
	/**
	 * Column Info
	 * @return asbrogFeuRt
	 */
	public String getAsbrogFeuRt() {
		return this.asbrogFeuRt;
	}
	
	/**
	 * Column Info
	 * @return brogCntCustNm
	 */
	public String getBrogCntCustNm() {
		return this.brogCntCustNm;
	}
	
	/**
	 * Column Info
	 * @return brogChgCtnt
	 */
	public String getBrogChgCtnt() {
		return this.brogChgCtnt;
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
	 * @return brogBxRt
	 */
	public String getBrogBxRt() {
		return this.brogBxRt;
	}
	
	/**
	 * Column Info
	 * @return brogCustSeq
	 */
	public String getBrogCustSeq() {
		return this.brogCustSeq;
	}
	
	/**
	 * Column Info
	 * @return brogKndCd
	 */
	public String getBrogKndCd() {
		return this.brogKndCd;
	}
	
	/**
	 * Column Info
	 * @return brogRtSeq
	 */
	public String getBrogRtSeq() {
		return this.brogRtSeq;
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
	 * @param porGrpTpCd
	 */
	public void setPorGrpTpCd(String porGrpTpCd) {
		this.porGrpTpCd = porGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param brogTeuRt
	 */
	public void setBrogTeuRt(String brogTeuRt) {
		this.brogTeuRt = brogTeuRt;
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
	 * Column Info
	 * @param brogDivCd
	 */
	public void setBrogDivCd(String brogDivCd) {
		this.brogDivCd = brogDivCd;
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
	 * @param brogCntCustSeq
	 */
	public void setBrogCntCustSeq(String brogCntCustSeq) {
		this.brogCntCustSeq = brogCntCustSeq;
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
	 * @param fmEffDt
	 */
	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
	}
	
	/**
	 * Column Info
	 * @param brogCntCd
	 */
	public void setBrogCntCd(String brogCntCd) {
		this.brogCntCd = brogCntCd;
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
	 * @param brogRfRt
	 */
	public void setBrogRfRt(String brogRfRt) {
		this.brogRfRt = brogRfRt;
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
	 * @param bkgBrogRt
	 */
	public void setBkgBrogRt(String bkgBrogRt) {
		this.bkgBrogRt = bkgBrogRt;
	}
	
	/**
	 * Column Info
	 * @param asbrogFeuRt
	 */
	public void setAsbrogFeuRt(String asbrogFeuRt) {
		this.asbrogFeuRt = asbrogFeuRt;
	}
	
	/**
	 * Column Info
	 * @param brogCntCustNm
	 */
	public void setBrogCntCustNm(String brogCntCustNm) {
		this.brogCntCustNm = brogCntCustNm;
	}
	
	/**
	 * Column Info
	 * @param brogChgCtnt
	 */
	public void setBrogChgCtnt(String brogChgCtnt) {
		this.brogChgCtnt = brogChgCtnt;
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
	 * @param brogBxRt
	 */
	public void setBrogBxRt(String brogBxRt) {
		this.brogBxRt = brogBxRt;
	}
	
	/**
	 * Column Info
	 * @param brogCustSeq
	 */
	public void setBrogCustSeq(String brogCustSeq) {
		this.brogCustSeq = brogCustSeq;
	}
	
	/**
	 * Column Info
	 * @param brogKndCd
	 */
	public void setBrogKndCd(String brogKndCd) {
		this.brogKndCd = brogKndCd;
	}
	
	/**
	 * Column Info
	 * @param brogRtSeq
	 */
	public void setBrogRtSeq(String brogRtSeq) {
		this.brogRtSeq = brogRtSeq;
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
		setPorGrpTpCd(JSPUtil.getParameter(request, "por_grp_tp_cd", ""));
		setBrogTeuRt(JSPUtil.getParameter(request, "brog_teu_rt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodRoutCd(JSPUtil.getParameter(request, "pod_rout_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setBrogDivCd(JSPUtil.getParameter(request, "brog_div_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBrogCntCustSeq(JSPUtil.getParameter(request, "brog_cnt_cust_seq", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setFmEffDt(JSPUtil.getParameter(request, "fm_eff_dt", ""));
		setBrogCntCd(JSPUtil.getParameter(request, "brog_cnt_cd", ""));
		setPorRoutCd(JSPUtil.getParameter(request, "por_rout_cd", ""));
		setShprCntNm(JSPUtil.getParameter(request, "shpr_cnt_nm", ""));
		setPolRoutCd(JSPUtil.getParameter(request, "pol_rout_cd", ""));
		setBrogRfRt(JSPUtil.getParameter(request, "brog_rf_rt", ""));
		setPolGrpTpCd(JSPUtil.getParameter(request, "pol_grp_tp_cd", ""));
		setBkgBrogRt(JSPUtil.getParameter(request, "bkg_brog_rt", ""));
		setAsbrogFeuRt(JSPUtil.getParameter(request, "asbrog_feu_rt", ""));
		setBrogCntCustNm(JSPUtil.getParameter(request, "brog_cnt_cust_nm", ""));
		setBrogChgCtnt(JSPUtil.getParameter(request, "brog_chg_ctnt", ""));
		setToEffDt(JSPUtil.getParameter(request, "to_eff_dt", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setCmdtTpCd(JSPUtil.getParameter(request, "cmdt_tp_cd", ""));
		setBrogBxRt(JSPUtil.getParameter(request, "brog_bx_rt", ""));
		setBrogCustSeq(JSPUtil.getParameter(request, "brog_cust_seq", ""));
		setBrogKndCd(JSPUtil.getParameter(request, "brog_knd_cd", ""));
		setBrogRtSeq(JSPUtil.getParameter(request, "brog_rt_seq", ""));
		setPodGrpTpCd(JSPUtil.getParameter(request, "pod_grp_tp_cd", ""));
		setShprCntSeq(JSPUtil.getParameter(request, "shpr_cnt_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AGTBRKGRateInfoVO[]
	 */
	public AGTBRKGRateInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AGTBRKGRateInfoVO[]
	 */
	public AGTBRKGRateInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AGTBRKGRateInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "por_grp_tp_cd", length));
			String[] brogTeuRt = (JSPUtil.getParameter(request, prefix	+ "brog_teu_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podRoutCd = (JSPUtil.getParameter(request, prefix	+ "pod_rout_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] brogDivCd = (JSPUtil.getParameter(request, prefix	+ "brog_div_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] brogCntCustSeq = (JSPUtil.getParameter(request, prefix	+ "brog_cnt_cust_seq", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] fmEffDt = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt", length));
			String[] brogCntCd = (JSPUtil.getParameter(request, prefix	+ "brog_cnt_cd", length));
			String[] porRoutCd = (JSPUtil.getParameter(request, prefix	+ "por_rout_cd", length));
			String[] shprCntNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_nm", length));
			String[] polRoutCd = (JSPUtil.getParameter(request, prefix	+ "pol_rout_cd", length));
			String[] brogRfRt = (JSPUtil.getParameter(request, prefix	+ "brog_rf_rt", length));
			String[] polGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "pol_grp_tp_cd", length));
			String[] bkgBrogRt = (JSPUtil.getParameter(request, prefix	+ "bkg_brog_rt", length));
			String[] asbrogFeuRt = (JSPUtil.getParameter(request, prefix	+ "asbrog_feu_rt", length));
			String[] brogCntCustNm = (JSPUtil.getParameter(request, prefix	+ "brog_cnt_cust_nm", length));
			String[] brogChgCtnt = (JSPUtil.getParameter(request, prefix	+ "brog_chg_ctnt", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] cmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_tp_cd", length));
			String[] brogBxRt = (JSPUtil.getParameter(request, prefix	+ "brog_bx_rt", length));
			String[] brogCustSeq = (JSPUtil.getParameter(request, prefix	+ "brog_cust_seq", length));
			String[] brogKndCd = (JSPUtil.getParameter(request, prefix	+ "brog_knd_cd", length));
			String[] brogRtSeq = (JSPUtil.getParameter(request, prefix	+ "brog_rt_seq", length));
			String[] podGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "pod_grp_tp_cd", length));
			String[] shprCntSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new AGTBRKGRateInfoVO();
				if (porGrpTpCd[i] != null)
					model.setPorGrpTpCd(porGrpTpCd[i]);
				if (brogTeuRt[i] != null)
					model.setBrogTeuRt(brogTeuRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podRoutCd[i] != null)
					model.setPodRoutCd(podRoutCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (brogDivCd[i] != null)
					model.setBrogDivCd(brogDivCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (brogCntCustSeq[i] != null)
					model.setBrogCntCustSeq(brogCntCustSeq[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (fmEffDt[i] != null)
					model.setFmEffDt(fmEffDt[i]);
				if (brogCntCd[i] != null)
					model.setBrogCntCd(brogCntCd[i]);
				if (porRoutCd[i] != null)
					model.setPorRoutCd(porRoutCd[i]);
				if (shprCntNm[i] != null)
					model.setShprCntNm(shprCntNm[i]);
				if (polRoutCd[i] != null)
					model.setPolRoutCd(polRoutCd[i]);
				if (brogRfRt[i] != null)
					model.setBrogRfRt(brogRfRt[i]);
				if (polGrpTpCd[i] != null)
					model.setPolGrpTpCd(polGrpTpCd[i]);
				if (bkgBrogRt[i] != null)
					model.setBkgBrogRt(bkgBrogRt[i]);
				if (asbrogFeuRt[i] != null)
					model.setAsbrogFeuRt(asbrogFeuRt[i]);
				if (brogCntCustNm[i] != null)
					model.setBrogCntCustNm(brogCntCustNm[i]);
				if (brogChgCtnt[i] != null)
					model.setBrogChgCtnt(brogChgCtnt[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (cmdtTpCd[i] != null)
					model.setCmdtTpCd(cmdtTpCd[i]);
				if (brogBxRt[i] != null)
					model.setBrogBxRt(brogBxRt[i]);
				if (brogCustSeq[i] != null)
					model.setBrogCustSeq(brogCustSeq[i]);
				if (brogKndCd[i] != null)
					model.setBrogKndCd(brogKndCd[i]);
				if (brogRtSeq[i] != null)
					model.setBrogRtSeq(brogRtSeq[i]);
				if (podGrpTpCd[i] != null)
					model.setPodGrpTpCd(podGrpTpCd[i]);
				if (shprCntSeq[i] != null)
					model.setShprCntSeq(shprCntSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAGTBRKGRateInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AGTBRKGRateInfoVO[]
	 */
	public AGTBRKGRateInfoVO[] getAGTBRKGRateInfoVOs(){
		AGTBRKGRateInfoVO[] vos = (AGTBRKGRateInfoVO[])models.toArray(new AGTBRKGRateInfoVO[models.size()]);
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
		this.porGrpTpCd = this.porGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogTeuRt = this.brogTeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podRoutCd = this.podRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogDivCd = this.brogDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogCntCustSeq = this.brogCntCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt = this.fmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogCntCd = this.brogCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porRoutCd = this.porRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntNm = this.shprCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polRoutCd = this.polRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogRfRt = this.brogRfRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polGrpTpCd = this.polGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBrogRt = this.bkgBrogRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asbrogFeuRt = this.asbrogFeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogCntCustNm = this.brogCntCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogChgCtnt = this.brogChgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTpCd = this.cmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogBxRt = this.brogBxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogCustSeq = this.brogCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogKndCd = this.brogKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogRtSeq = this.brogRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podGrpTpCd = this.podGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntSeq = this.shprCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
