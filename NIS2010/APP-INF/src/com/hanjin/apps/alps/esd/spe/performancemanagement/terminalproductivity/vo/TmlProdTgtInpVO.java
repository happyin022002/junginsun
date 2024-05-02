/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TmlProdTgtInpVO.java
*@FileTitle : TmlProdTgtInpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.05  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TmlProdTgtInpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TmlProdTgtInpVO> models = new ArrayList<TmlProdTgtInpVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String spName = null;
	/* Column Info */
	private String isflag = null;
	/* Column Info */
	private String sSpSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String spSeq = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String prePerfRto = null;
	/* Column Info */
	private String kpiTgtRto = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String preTgtRto = null;
	/* Column Info */
	private String kpiRmk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sEvYr = null;
	/* Column Info */
	private String sEgOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String egNm = null;
	/* Column Info */
	private String egTmlProdTgtSeq = null;
	/* Column Info */
	private String sTmlCd = null;
	/* Column Info */
	private String sEgRhqCd = null;
	/* Column Info */
	private String sEvSvcCateCd = null;
	/* Column Info */
	private String egId = null;
	/* Column Info */
	private String evYr = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TmlProdTgtInpVO() {}

	public TmlProdTgtInpVO(String ibflag, String pagerows, String egId, String egNm, String evYr, String spSeq, String spName, String tmlCd, String prePerfRto, String preTgtRto, String kpiTgtRto, String kpiRmk, String sEgRhqCd, String sEgOfcCd, String sEvSvcCateCd, String sEvYr, String sTmlCd, String sSpSeq, String isflag, String creUsrId, String creDt, String updUsrId, String updDt, String egTmlProdTgtSeq) {
		this.updDt = updDt;
		this.spName = spName;
		this.isflag = isflag;
		this.sSpSeq = sSpSeq;
		this.creDt = creDt;
		this.spSeq = spSeq;
		this.tmlCd = tmlCd;
		this.prePerfRto = prePerfRto;
		this.kpiTgtRto = kpiTgtRto;
		this.pagerows = pagerows;
		this.preTgtRto = preTgtRto;
		this.kpiRmk = kpiRmk;
		this.creUsrId = creUsrId;
		this.sEvYr = sEvYr;
		this.sEgOfcCd = sEgOfcCd;
		this.ibflag = ibflag;
		this.egNm = egNm;
		this.egTmlProdTgtSeq = egTmlProdTgtSeq;
		this.sTmlCd = sTmlCd;
		this.sEgRhqCd = sEgRhqCd;
		this.sEvSvcCateCd = sEvSvcCateCd;
		this.egId = egId;
		this.evYr = evYr;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sp_name", getSpName());
		this.hashColumns.put("isflag", getIsflag());
		this.hashColumns.put("s_sp_seq", getSSpSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sp_seq", getSpSeq());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("pre_perf_rto", getPrePerfRto());
		this.hashColumns.put("kpi_tgt_rto", getKpiTgtRto());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pre_tgt_rto", getPreTgtRto());
		this.hashColumns.put("kpi_rmk", getKpiRmk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("s_ev_yr", getSEvYr());
		this.hashColumns.put("s_eg_ofc_cd", getSEgOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eg_nm", getEgNm());
		this.hashColumns.put("eg_tml_prod_tgt_seq", getEgTmlProdTgtSeq());
		this.hashColumns.put("s_tml_cd", getSTmlCd());
		this.hashColumns.put("s_eg_rhq_cd", getSEgRhqCd());
		this.hashColumns.put("s_ev_svc_cate_cd", getSEvSvcCateCd());
		this.hashColumns.put("eg_id", getEgId());
		this.hashColumns.put("ev_yr", getEvYr());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sp_name", "spName");
		this.hashFields.put("isflag", "isflag");
		this.hashFields.put("s_sp_seq", "sSpSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sp_seq", "spSeq");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("pre_perf_rto", "prePerfRto");
		this.hashFields.put("kpi_tgt_rto", "kpiTgtRto");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pre_tgt_rto", "preTgtRto");
		this.hashFields.put("kpi_rmk", "kpiRmk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("s_ev_yr", "sEvYr");
		this.hashFields.put("s_eg_ofc_cd", "sEgOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eg_nm", "egNm");
		this.hashFields.put("eg_tml_prod_tgt_seq", "egTmlProdTgtSeq");
		this.hashFields.put("s_tml_cd", "sTmlCd");
		this.hashFields.put("s_eg_rhq_cd", "sEgRhqCd");
		this.hashFields.put("s_ev_svc_cate_cd", "sEvSvcCateCd");
		this.hashFields.put("eg_id", "egId");
		this.hashFields.put("ev_yr", "evYr");
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
	 * @return spName
	 */
	public String getSpName() {
		return this.spName;
	}
	
	/**
	 * Column Info
	 * @return isflag
	 */
	public String getIsflag() {
		return this.isflag;
	}
	
	/**
	 * Column Info
	 * @return sSpSeq
	 */
	public String getSSpSeq() {
		return this.sSpSeq;
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
	 * @return spSeq
	 */
	public String getSpSeq() {
		return this.spSeq;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return preTgtRto
	 */
	public String getPreTgtRto() {
		return this.preTgtRto;
	}
	
	/**
	 * Column Info
	 * @return kpiRmk
	 */
	public String getKpiRmk() {
		return this.kpiRmk;
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
	 * @return sEvYr
	 */
	public String getSEvYr() {
		return this.sEvYr;
	}
	
	/**
	 * Column Info
	 * @return sEgOfcCd
	 */
	public String getSEgOfcCd() {
		return this.sEgOfcCd;
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
	 * @return egTmlProdTgtSeq
	 */
	public String getEgTmlProdTgtSeq() {
		return this.egTmlProdTgtSeq;
	}
	
	/**
	 * Column Info
	 * @return sTmlCd
	 */
	public String getSTmlCd() {
		return this.sTmlCd;
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
	 * @return sEvSvcCateCd
	 */
	public String getSEvSvcCateCd() {
		return this.sEvSvcCateCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param spName
	 */
	public void setSpName(String spName) {
		this.spName = spName;
	}
	
	/**
	 * Column Info
	 * @param isflag
	 */
	public void setIsflag(String isflag) {
		this.isflag = isflag;
	}
	
	/**
	 * Column Info
	 * @param sSpSeq
	 */
	public void setSSpSeq(String sSpSeq) {
		this.sSpSeq = sSpSeq;
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
	 * @param spSeq
	 */
	public void setSpSeq(String spSeq) {
		this.spSeq = spSeq;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param preTgtRto
	 */
	public void setPreTgtRto(String preTgtRto) {
		this.preTgtRto = preTgtRto;
	}
	
	/**
	 * Column Info
	 * @param kpiRmk
	 */
	public void setKpiRmk(String kpiRmk) {
		this.kpiRmk = kpiRmk;
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
	 * @param sEvYr
	 */
	public void setSEvYr(String sEvYr) {
		this.sEvYr = sEvYr;
	}
	
	/**
	 * Column Info
	 * @param sEgOfcCd
	 */
	public void setSEgOfcCd(String sEgOfcCd) {
		this.sEgOfcCd = sEgOfcCd;
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
	 * @param egTmlProdTgtSeq
	 */
	public void setEgTmlProdTgtSeq(String egTmlProdTgtSeq) {
		this.egTmlProdTgtSeq = egTmlProdTgtSeq;
	}
	
	/**
	 * Column Info
	 * @param sTmlCd
	 */
	public void setSTmlCd(String sTmlCd) {
		this.sTmlCd = sTmlCd;
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
	 * @param sEvSvcCateCd
	 */
	public void setSEvSvcCateCd(String sEvSvcCateCd) {
		this.sEvSvcCateCd = sEvSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @param egId
	 */
	public void setEgId(String egId) {
		this.egId = egId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSpName(JSPUtil.getParameter(request, prefix + "sp_name", ""));
		setIsflag(JSPUtil.getParameter(request, prefix + "isflag", ""));
		setSSpSeq(JSPUtil.getParameter(request, prefix + "s_sp_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSpSeq(JSPUtil.getParameter(request, prefix + "sp_seq", ""));
		setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
		setPrePerfRto(JSPUtil.getParameter(request, prefix + "pre_perf_rto", ""));
		setKpiTgtRto(JSPUtil.getParameter(request, prefix + "kpi_tgt_rto", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPreTgtRto(JSPUtil.getParameter(request, prefix + "pre_tgt_rto", ""));
		setKpiRmk(JSPUtil.getParameter(request, prefix + "kpi_rmk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSEvYr(JSPUtil.getParameter(request, prefix + "s_ev_yr", ""));
		setSEgOfcCd(JSPUtil.getParameter(request, prefix + "s_eg_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEgNm(JSPUtil.getParameter(request, prefix + "eg_nm", ""));
		setEgTmlProdTgtSeq(JSPUtil.getParameter(request, prefix + "eg_tml_prod_tgt_seq", ""));
		setSTmlCd(JSPUtil.getParameter(request, prefix + "s_tml_cd", ""));
		setSEgRhqCd(JSPUtil.getParameter(request, prefix + "s_eg_rhq_cd", ""));
		setSEvSvcCateCd(JSPUtil.getParameter(request, prefix + "s_ev_svc_cate_cd", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
		setEvYr(JSPUtil.getParameter(request, prefix + "ev_yr", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TmlProdTgtInpVO[]
	 */
	public TmlProdTgtInpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TmlProdTgtInpVO[]
	 */
	public TmlProdTgtInpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TmlProdTgtInpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] spName = (JSPUtil.getParameter(request, prefix	+ "sp_name", length));
			String[] isflag = (JSPUtil.getParameter(request, prefix	+ "isflag", length));
			String[] sSpSeq = (JSPUtil.getParameter(request, prefix	+ "s_sp_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] spSeq = (JSPUtil.getParameter(request, prefix	+ "sp_seq", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] prePerfRto = (JSPUtil.getParameter(request, prefix	+ "pre_perf_rto", length));
			String[] kpiTgtRto = (JSPUtil.getParameter(request, prefix	+ "kpi_tgt_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] preTgtRto = (JSPUtil.getParameter(request, prefix	+ "pre_tgt_rto", length));
			String[] kpiRmk = (JSPUtil.getParameter(request, prefix	+ "kpi_rmk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sEvYr = (JSPUtil.getParameter(request, prefix	+ "s_ev_yr", length));
			String[] sEgOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] egNm = (JSPUtil.getParameter(request, prefix	+ "eg_nm", length));
			String[] egTmlProdTgtSeq = (JSPUtil.getParameter(request, prefix	+ "eg_tml_prod_tgt_seq", length));
			String[] sTmlCd = (JSPUtil.getParameter(request, prefix	+ "s_tml_cd", length));
			String[] sEgRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_rhq_cd", length));
			String[] sEvSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "s_ev_svc_cate_cd", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			String[] evYr = (JSPUtil.getParameter(request, prefix	+ "ev_yr", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new TmlProdTgtInpVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (spName[i] != null)
					model.setSpName(spName[i]);
				if (isflag[i] != null)
					model.setIsflag(isflag[i]);
				if (sSpSeq[i] != null)
					model.setSSpSeq(sSpSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (spSeq[i] != null)
					model.setSpSeq(spSeq[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (prePerfRto[i] != null)
					model.setPrePerfRto(prePerfRto[i]);
				if (kpiTgtRto[i] != null)
					model.setKpiTgtRto(kpiTgtRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (preTgtRto[i] != null)
					model.setPreTgtRto(preTgtRto[i]);
				if (kpiRmk[i] != null)
					model.setKpiRmk(kpiRmk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sEvYr[i] != null)
					model.setSEvYr(sEvYr[i]);
				if (sEgOfcCd[i] != null)
					model.setSEgOfcCd(sEgOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (egNm[i] != null)
					model.setEgNm(egNm[i]);
				if (egTmlProdTgtSeq[i] != null)
					model.setEgTmlProdTgtSeq(egTmlProdTgtSeq[i]);
				if (sTmlCd[i] != null)
					model.setSTmlCd(sTmlCd[i]);
				if (sEgRhqCd[i] != null)
					model.setSEgRhqCd(sEgRhqCd[i]);
				if (sEvSvcCateCd[i] != null)
					model.setSEvSvcCateCd(sEvSvcCateCd[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				if (evYr[i] != null)
					model.setEvYr(evYr[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTmlProdTgtInpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TmlProdTgtInpVO[]
	 */
	public TmlProdTgtInpVO[] getTmlProdTgtInpVOs(){
		TmlProdTgtInpVO[] vos = (TmlProdTgtInpVO[])models.toArray(new TmlProdTgtInpVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spName = this.spName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isflag = this.isflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSpSeq = this.sSpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spSeq = this.spSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePerfRto = this.prePerfRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiTgtRto = this.kpiTgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preTgtRto = this.preTgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiRmk = this.kpiRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEvYr = this.sEvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgOfcCd = this.sEgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egNm = this.egNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egTmlProdTgtSeq = this.egTmlProdTgtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTmlCd = this.sTmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgRhqCd = this.sEgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEvSvcCateCd = this.sEvSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evYr = this.evYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
