/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KpiPerformanceTargetVO.java
*@FileTitle : KpiPerformanceTargetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.20
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.20 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.spe.performancemanagement.kpitarget.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 백형인
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KpiPerformanceTargetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KpiPerformanceTargetVO> models = new ArrayList<KpiPerformanceTargetVO>();
	
	/* Column Info */
	private String preRsltScre = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sChkUnmap = null;
	/* Column Info */
	private String prePerAvg = null;
	/* Column Info */
	private String prePerfRto = null;
	/* Column Info */
	private String kpiTgtRto = null;
	/* Column Info */
	private String preTgtRto = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String egNm = null;
	/* Column Info */
	private String sEvSvcCateCd = null;
	/* Column Info */
	private String kpiWgtRto = null;
	/* Column Info */
	private String evYr = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String spKpiTpCd = null;
	/* Column Info */
	private String preWgtRto = null;
	/* Column Info */
	private String spKpiNm = null;
	/* Column Info */
	private String useflag = null;
	/* Column Info */
	private String spKpiTpNm = null;
	/* Column Info */
	private String sChkAll = null;
	/* Column Info */
	private String sEgOfcCd = null;
	/* Column Info */
	private String sEvYr = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sChkMap = null;
	/* Column Info */
	private String spKpiId = null;
	/* Column Info */
	private String sEgRhqCd = null;
	/* Column Info */
	private String egId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public KpiPerformanceTargetVO() {}

	public KpiPerformanceTargetVO(String ibflag, String pagerows, String updDt, String spKpiTpCd, String spKpiNm, String sChkUnmap, String spKpiTpNm, String creDt, String prePerfRto, String sChkAll, String kpiTgtRto, String preTgtRto, String sEgOfcCd, String sEvYr, String egNm, String creUsrId, String sChkMap, String spKpiId, String sEgRhqCd, String sEvSvcCateCd, String kpiWgtRto, String evYr, String egId, String updUsrId, String preRsltScre, String prePerAvg, String preWgtRto, String useflag) {
		this.preRsltScre = preRsltScre;
		this.creDt = creDt;
		this.sChkUnmap = sChkUnmap;
		this.prePerAvg = prePerAvg;
		this.prePerfRto = prePerfRto;
		this.kpiTgtRto = kpiTgtRto;
		this.preTgtRto = preTgtRto;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.egNm = egNm;
		this.sEvSvcCateCd = sEvSvcCateCd;
		this.kpiWgtRto = kpiWgtRto;
		this.evYr = evYr;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.spKpiTpCd = spKpiTpCd;
		this.preWgtRto = preWgtRto;
		this.spKpiNm = spKpiNm;
		this.useflag = useflag;
		this.spKpiTpNm = spKpiTpNm;
		this.sChkAll = sChkAll;
		this.sEgOfcCd = sEgOfcCd;
		this.sEvYr = sEvYr;
		this.creUsrId = creUsrId;
		this.sChkMap = sChkMap;
		this.spKpiId = spKpiId;
		this.sEgRhqCd = sEgRhqCd;
		this.egId = egId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pre_rslt_scre", getPreRsltScre());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("s_chk_unmap", getSChkUnmap());
		this.hashColumns.put("pre_per_avg", getPrePerAvg());
		this.hashColumns.put("pre_perf_rto", getPrePerfRto());
		this.hashColumns.put("kpi_tgt_rto", getKpiTgtRto());
		this.hashColumns.put("pre_tgt_rto", getPreTgtRto());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eg_nm", getEgNm());
		this.hashColumns.put("s_ev_svc_cate_cd", getSEvSvcCateCd());
		this.hashColumns.put("kpi_wgt_rto", getKpiWgtRto());
		this.hashColumns.put("ev_yr", getEvYr());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sp_kpi_tp_cd", getSpKpiTpCd());
		this.hashColumns.put("pre_wgt_rto", getPreWgtRto());
		this.hashColumns.put("sp_kpi_nm", getSpKpiNm());
		this.hashColumns.put("useflag", getUseflag());
		this.hashColumns.put("sp_kpi_tp_nm", getSpKpiTpNm());
		this.hashColumns.put("s_chk_all", getSChkAll());
		this.hashColumns.put("s_eg_ofc_cd", getSEgOfcCd());
		this.hashColumns.put("s_ev_yr", getSEvYr());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("s_chk_map", getSChkMap());
		this.hashColumns.put("sp_kpi_id", getSpKpiId());
		this.hashColumns.put("s_eg_rhq_cd", getSEgRhqCd());
		this.hashColumns.put("eg_id", getEgId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pre_rslt_scre", "preRsltScre");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("s_chk_unmap", "sChkUnmap");
		this.hashFields.put("pre_per_avg", "prePerAvg");
		this.hashFields.put("pre_perf_rto", "prePerfRto");
		this.hashFields.put("kpi_tgt_rto", "kpiTgtRto");
		this.hashFields.put("pre_tgt_rto", "preTgtRto");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eg_nm", "egNm");
		this.hashFields.put("s_ev_svc_cate_cd", "sEvSvcCateCd");
		this.hashFields.put("kpi_wgt_rto", "kpiWgtRto");
		this.hashFields.put("ev_yr", "evYr");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sp_kpi_tp_cd", "spKpiTpCd");
		this.hashFields.put("pre_wgt_rto", "preWgtRto");
		this.hashFields.put("sp_kpi_nm", "spKpiNm");
		this.hashFields.put("useflag", "useflag");
		this.hashFields.put("sp_kpi_tp_nm", "spKpiTpNm");
		this.hashFields.put("s_chk_all", "sChkAll");
		this.hashFields.put("s_eg_ofc_cd", "sEgOfcCd");
		this.hashFields.put("s_ev_yr", "sEvYr");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("s_chk_map", "sChkMap");
		this.hashFields.put("sp_kpi_id", "spKpiId");
		this.hashFields.put("s_eg_rhq_cd", "sEgRhqCd");
		this.hashFields.put("eg_id", "egId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return preRsltScre
	 */
	public String getPreRsltScre() {
		return this.preRsltScre;
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
	 * @return sChkUnmap
	 */
	public String getSChkUnmap() {
		return this.sChkUnmap;
	}
	
	/**
	 * Column Info
	 * @return prePerAvg
	 */
	public String getPrePerAvg() {
		return this.prePerAvg;
	}
	
	/**
	 * Column Info
	 * @return prePerfRto
	 */
	public String getPrePerfRto() {
		return this.prePerfRto;
	}
	
	/**
	 * Column Info
	 * @return kpiTgtRto
	 */
	public String getKpiTgtRto() {
		return this.kpiTgtRto;
	}
	
	/**
	 * Column Info
	 * @return preTgtRto
	 */
	public String getPreTgtRto() {
		return this.preTgtRto;
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
	 * @return egNm
	 */
	public String getEgNm() {
		return this.egNm;
	}
	
	/**
	 * Column Info
	 * @return sEvSvcCateCd
	 */
	public String getSEvSvcCateCd() {
		return this.sEvSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @return kpiWgtRto
	 */
	public String getKpiWgtRto() {
		return this.kpiWgtRto;
	}
	
	/**
	 * Column Info
	 * @return evYr
	 */
	public String getEvYr() {
		return this.evYr;
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
	 * @return spKpiTpCd
	 */
	public String getSpKpiTpCd() {
		return this.spKpiTpCd;
	}
	
	/**
	 * Column Info
	 * @return preWgtRto
	 */
	public String getPreWgtRto() {
		return this.preWgtRto;
	}
	
	/**
	 * Column Info
	 * @return spKpiNm
	 */
	public String getSpKpiNm() {
		return this.spKpiNm;
	}
	
	/**
	 * Column Info
	 * @return useflag
	 */
	public String getUseflag() {
		return this.useflag;
	}
	
	/**
	 * Column Info
	 * @return spKpiTpNm
	 */
	public String getSpKpiTpNm() {
		return this.spKpiTpNm;
	}
	
	/**
	 * Column Info
	 * @return sChkAll
	 */
	public String getSChkAll() {
		return this.sChkAll;
	}
	
	/**
	 * Column Info
	 * @return sEgOfcCd
	 */
	public String getSEgOfcCd() {
		return this.sEgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sEvYr
	 */
	public String getSEvYr() {
		return this.sEvYr;
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
	 * @return sChkMap
	 */
	public String getSChkMap() {
		return this.sChkMap;
	}
	
	/**
	 * Column Info
	 * @return spKpiId
	 */
	public String getSpKpiId() {
		return this.spKpiId;
	}
	
	/**
	 * Column Info
	 * @return sEgRhqCd
	 */
	public String getSEgRhqCd() {
		return this.sEgRhqCd;
	}
	
	/**
	 * Column Info
	 * @return egId
	 */
	public String getEgId() {
		return this.egId;
	}
	

	/**
	 * Column Info
	 * @param preRsltScre
	 */
	public void setPreRsltScre(String preRsltScre) {
		this.preRsltScre = preRsltScre;
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
	 * @param sChkUnmap
	 */
	public void setSChkUnmap(String sChkUnmap) {
		this.sChkUnmap = sChkUnmap;
	}
	
	/**
	 * Column Info
	 * @param prePerAvg
	 */
	public void setPrePerAvg(String prePerAvg) {
		this.prePerAvg = prePerAvg;
	}
	
	/**
	 * Column Info
	 * @param prePerfRto
	 */
	public void setPrePerfRto(String prePerfRto) {
		this.prePerfRto = prePerfRto;
	}
	
	/**
	 * Column Info
	 * @param kpiTgtRto
	 */
	public void setKpiTgtRto(String kpiTgtRto) {
		this.kpiTgtRto = kpiTgtRto;
	}
	
	/**
	 * Column Info
	 * @param preTgtRto
	 */
	public void setPreTgtRto(String preTgtRto) {
		this.preTgtRto = preTgtRto;
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
	 * @param egNm
	 */
	public void setEgNm(String egNm) {
		this.egNm = egNm;
	}
	
	/**
	 * Column Info
	 * @param sEvSvcCateCd
	 */
	public void setSEvSvcCateCd(String sEvSvcCateCd) {
		this.sEvSvcCateCd = sEvSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @param kpiWgtRto
	 */
	public void setKpiWgtRto(String kpiWgtRto) {
		this.kpiWgtRto = kpiWgtRto;
	}
	
	/**
	 * Column Info
	 * @param evYr
	 */
	public void setEvYr(String evYr) {
		this.evYr = evYr;
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
	 * @param spKpiTpCd
	 */
	public void setSpKpiTpCd(String spKpiTpCd) {
		this.spKpiTpCd = spKpiTpCd;
	}
	
	/**
	 * Column Info
	 * @param preWgtRto
	 */
	public void setPreWgtRto(String preWgtRto) {
		this.preWgtRto = preWgtRto;
	}
	
	/**
	 * Column Info
	 * @param spKpiNm
	 */
	public void setSpKpiNm(String spKpiNm) {
		this.spKpiNm = spKpiNm;
	}
	
	/**
	 * Column Info
	 * @param useflag
	 */
	public void setUseflag(String useflag) {
		this.useflag = useflag;
	}
	
	/**
	 * Column Info
	 * @param spKpiTpNm
	 */
	public void setSpKpiTpNm(String spKpiTpNm) {
		this.spKpiTpNm = spKpiTpNm;
	}
	
	/**
	 * Column Info
	 * @param sChkAll
	 */
	public void setSChkAll(String sChkAll) {
		this.sChkAll = sChkAll;
	}
	
	/**
	 * Column Info
	 * @param sEgOfcCd
	 */
	public void setSEgOfcCd(String sEgOfcCd) {
		this.sEgOfcCd = sEgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sEvYr
	 */
	public void setSEvYr(String sEvYr) {
		this.sEvYr = sEvYr;
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
	 * @param sChkMap
	 */
	public void setSChkMap(String sChkMap) {
		this.sChkMap = sChkMap;
	}
	
	/**
	 * Column Info
	 * @param spKpiId
	 */
	public void setSpKpiId(String spKpiId) {
		this.spKpiId = spKpiId;
	}
	
	/**
	 * Column Info
	 * @param sEgRhqCd
	 */
	public void setSEgRhqCd(String sEgRhqCd) {
		this.sEgRhqCd = sEgRhqCd;
	}
	
	/**
	 * Column Info
	 * @param egId
	 */
	public void setEgId(String egId) {
		this.egId = egId;
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
		setPreRsltScre(JSPUtil.getParameter(request, prefix + "pre_rslt_scre", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSChkUnmap(JSPUtil.getParameter(request, prefix + "s_chk_unmap", ""));
		setPrePerAvg(JSPUtil.getParameter(request, prefix + "pre_per_avg", ""));
		setPrePerfRto(JSPUtil.getParameter(request, prefix + "pre_perf_rto", ""));
		setKpiTgtRto(JSPUtil.getParameter(request, prefix + "kpi_tgt_rto", ""));
		setPreTgtRto(JSPUtil.getParameter(request, prefix + "pre_tgt_rto", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEgNm(JSPUtil.getParameter(request, prefix + "eg_nm", ""));
		setSEvSvcCateCd(JSPUtil.getParameter(request, prefix + "s_ev_svc_cate_cd", ""));
		setKpiWgtRto(JSPUtil.getParameter(request, prefix + "kpi_wgt_rto", ""));
		setEvYr(JSPUtil.getParameter(request, prefix + "ev_yr", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSpKpiTpCd(JSPUtil.getParameter(request, prefix + "sp_kpi_tp_cd", ""));
		setPreWgtRto(JSPUtil.getParameter(request, prefix + "pre_wgt_rto", ""));
		setSpKpiNm(JSPUtil.getParameter(request, prefix + "sp_kpi_nm", ""));
		setUseflag(JSPUtil.getParameter(request, prefix + "useflag", ""));
		setSpKpiTpNm(JSPUtil.getParameter(request, prefix + "sp_kpi_tp_nm", ""));
		setSChkAll(JSPUtil.getParameter(request, prefix + "s_chk_all", ""));
		setSEgOfcCd(JSPUtil.getParameter(request, prefix + "s_eg_ofc_cd", ""));
		setSEvYr(JSPUtil.getParameter(request, prefix + "s_ev_yr", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSChkMap(JSPUtil.getParameter(request, prefix + "s_chk_map", ""));
		setSpKpiId(JSPUtil.getParameter(request, prefix + "sp_kpi_id", ""));
		setSEgRhqCd(JSPUtil.getParameter(request, prefix + "s_eg_rhq_cd", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KpiPerformanceTargetVO[]
	 */
	public KpiPerformanceTargetVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KpiPerformanceTargetVO[]
	 */
	public KpiPerformanceTargetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KpiPerformanceTargetVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] preRsltScre = (JSPUtil.getParameter(request, prefix	+ "pre_rslt_scre", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sChkUnmap = (JSPUtil.getParameter(request, prefix	+ "s_chk_unmap", length));
			String[] prePerAvg = (JSPUtil.getParameter(request, prefix	+ "pre_per_avg", length));
			String[] prePerfRto = (JSPUtil.getParameter(request, prefix	+ "pre_perf_rto", length));
			String[] kpiTgtRto = (JSPUtil.getParameter(request, prefix	+ "kpi_tgt_rto", length));
			String[] preTgtRto = (JSPUtil.getParameter(request, prefix	+ "pre_tgt_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] egNm = (JSPUtil.getParameter(request, prefix	+ "eg_nm", length));
			String[] sEvSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "s_ev_svc_cate_cd", length));
			String[] kpiWgtRto = (JSPUtil.getParameter(request, prefix	+ "kpi_wgt_rto", length));
			String[] evYr = (JSPUtil.getParameter(request, prefix	+ "ev_yr", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] spKpiTpCd = (JSPUtil.getParameter(request, prefix	+ "sp_kpi_tp_cd", length));
			String[] preWgtRto = (JSPUtil.getParameter(request, prefix	+ "pre_wgt_rto", length));
			String[] spKpiNm = (JSPUtil.getParameter(request, prefix	+ "sp_kpi_nm", length));
			String[] useflag = (JSPUtil.getParameter(request, prefix	+ "useflag", length));
			String[] spKpiTpNm = (JSPUtil.getParameter(request, prefix	+ "sp_kpi_tp_nm", length));
			String[] sChkAll = (JSPUtil.getParameter(request, prefix	+ "s_chk_all", length));
			String[] sEgOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_ofc_cd", length));
			String[] sEvYr = (JSPUtil.getParameter(request, prefix	+ "s_ev_yr", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sChkMap = (JSPUtil.getParameter(request, prefix	+ "s_chk_map", length));
			String[] spKpiId = (JSPUtil.getParameter(request, prefix	+ "sp_kpi_id", length));
			String[] sEgRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_rhq_cd", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new KpiPerformanceTargetVO();
				if (preRsltScre[i] != null)
					model.setPreRsltScre(preRsltScre[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sChkUnmap[i] != null)
					model.setSChkUnmap(sChkUnmap[i]);
				if (prePerAvg[i] != null)
					model.setPrePerAvg(prePerAvg[i]);
				if (prePerfRto[i] != null)
					model.setPrePerfRto(prePerfRto[i]);
				if (kpiTgtRto[i] != null)
					model.setKpiTgtRto(kpiTgtRto[i]);
				if (preTgtRto[i] != null)
					model.setPreTgtRto(preTgtRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (egNm[i] != null)
					model.setEgNm(egNm[i]);
				if (sEvSvcCateCd[i] != null)
					model.setSEvSvcCateCd(sEvSvcCateCd[i]);
				if (kpiWgtRto[i] != null)
					model.setKpiWgtRto(kpiWgtRto[i]);
				if (evYr[i] != null)
					model.setEvYr(evYr[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (spKpiTpCd[i] != null)
					model.setSpKpiTpCd(spKpiTpCd[i]);
				if (preWgtRto[i] != null)
					model.setPreWgtRto(preWgtRto[i]);
				if (spKpiNm[i] != null)
					model.setSpKpiNm(spKpiNm[i]);
				if (useflag[i] != null)
					model.setUseflag(useflag[i]);
				if (spKpiTpNm[i] != null)
					model.setSpKpiTpNm(spKpiTpNm[i]);
				if (sChkAll[i] != null)
					model.setSChkAll(sChkAll[i]);
				if (sEgOfcCd[i] != null)
					model.setSEgOfcCd(sEgOfcCd[i]);
				if (sEvYr[i] != null)
					model.setSEvYr(sEvYr[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sChkMap[i] != null)
					model.setSChkMap(sChkMap[i]);
				if (spKpiId[i] != null)
					model.setSpKpiId(spKpiId[i]);
				if (sEgRhqCd[i] != null)
					model.setSEgRhqCd(sEgRhqCd[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKpiPerformanceTargetVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KpiPerformanceTargetVO[]
	 */
	public KpiPerformanceTargetVO[] getKpiPerformanceTargetVOs(){
		KpiPerformanceTargetVO[] vos = (KpiPerformanceTargetVO[])models.toArray(new KpiPerformanceTargetVO[models.size()]);
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
		this.preRsltScre = this.preRsltScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChkUnmap = this.sChkUnmap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePerAvg = this.prePerAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePerfRto = this.prePerfRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiTgtRto = this.kpiTgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preTgtRto = this.preTgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egNm = this.egNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEvSvcCateCd = this.sEvSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiWgtRto = this.kpiWgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evYr = this.evYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spKpiTpCd = this.spKpiTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preWgtRto = this.preWgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spKpiNm = this.spKpiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useflag = this.useflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spKpiTpNm = this.spKpiTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChkAll = this.sChkAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgOfcCd = this.sEgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEvYr = this.sEvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChkMap = this.sChkMap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spKpiId = this.spKpiId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgRhqCd = this.sEgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
