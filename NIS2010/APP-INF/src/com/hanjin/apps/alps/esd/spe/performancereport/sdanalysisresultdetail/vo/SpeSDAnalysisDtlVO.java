/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpeSDAnalysisDtlVO.java
*@FileTitle : SpeSDAnalysisDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.19 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.vo;

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

public class SpeSDAnalysisDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpeSDAnalysisDtlVO> models = new ArrayList<SpeSDAnalysisDtlVO>();
	
	/* Column Info */
	private String spKpiTpCd = null;
	/* Column Info */
	private String spName = null;
	/* Column Info */
	private String spKpiNm = null;
	/* Column Info */
	private String egRhqCd = null;
	/* Column Info */
	private String spKpiTpNm = null;
	/* Column Info */
	private String spSeq = null;
	/* Column Info */
	private String kpiTgtRto = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String egNm = null;
	/* Column Info */
	private String spKpiId = null;
	/* Column Info */
	private String rsltScreRto = null;
	/* Column Info */
	private String pfmc = null;
	/* Column Info */
	private String evSvcCateCd = null;
	/* Column Info */
	private String egOfcCd = null;
	/* Column Info */
	private String kpiWgtRto = null;
	/* Column Info */
	private String evYr = null;
	/* Column Info */
	private String egId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpeSDAnalysisDtlVO() {}

	public SpeSDAnalysisDtlVO(String ibflag, String pagerows, String egId, String egNm, String spSeq, String spName, String spKpiTpCd, String spKpiTpNm, String spKpiId, String spKpiNm, String kpiTgtRto, String kpiWgtRto, String rsltScreRto, String pfmc, String evYr, String egRhqCd, String egOfcCd, String evSvcCateCd) {
		this.spKpiTpCd = spKpiTpCd;
		this.spName = spName;
		this.spKpiNm = spKpiNm;
		this.egRhqCd = egRhqCd;
		this.spKpiTpNm = spKpiTpNm;
		this.spSeq = spSeq;
		this.kpiTgtRto = kpiTgtRto;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.egNm = egNm;
		this.spKpiId = spKpiId;
		this.rsltScreRto = rsltScreRto;
		this.pfmc = pfmc;
		this.evSvcCateCd = evSvcCateCd;
		this.egOfcCd = egOfcCd;
		this.kpiWgtRto = kpiWgtRto;
		this.evYr = evYr;
		this.egId = egId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sp_kpi_tp_cd", getSpKpiTpCd());
		this.hashColumns.put("sp_name", getSpName());
		this.hashColumns.put("sp_kpi_nm", getSpKpiNm());
		this.hashColumns.put("eg_rhq_cd", getEgRhqCd());
		this.hashColumns.put("sp_kpi_tp_nm", getSpKpiTpNm());
		this.hashColumns.put("sp_seq", getSpSeq());
		this.hashColumns.put("kpi_tgt_rto", getKpiTgtRto());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eg_nm", getEgNm());
		this.hashColumns.put("sp_kpi_id", getSpKpiId());
		this.hashColumns.put("rslt_scre_rto", getRsltScreRto());
		this.hashColumns.put("pfmc", getPfmc());
		this.hashColumns.put("ev_svc_cate_cd", getEvSvcCateCd());
		this.hashColumns.put("eg_ofc_cd", getEgOfcCd());
		this.hashColumns.put("kpi_wgt_rto", getKpiWgtRto());
		this.hashColumns.put("ev_yr", getEvYr());
		this.hashColumns.put("eg_id", getEgId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sp_kpi_tp_cd", "spKpiTpCd");
		this.hashFields.put("sp_name", "spName");
		this.hashFields.put("sp_kpi_nm", "spKpiNm");
		this.hashFields.put("eg_rhq_cd", "egRhqCd");
		this.hashFields.put("sp_kpi_tp_nm", "spKpiTpNm");
		this.hashFields.put("sp_seq", "spSeq");
		this.hashFields.put("kpi_tgt_rto", "kpiTgtRto");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eg_nm", "egNm");
		this.hashFields.put("sp_kpi_id", "spKpiId");
		this.hashFields.put("rslt_scre_rto", "rsltScreRto");
		this.hashFields.put("pfmc", "pfmc");
		this.hashFields.put("ev_svc_cate_cd", "evSvcCateCd");
		this.hashFields.put("eg_ofc_cd", "egOfcCd");
		this.hashFields.put("kpi_wgt_rto", "kpiWgtRto");
		this.hashFields.put("ev_yr", "evYr");
		this.hashFields.put("eg_id", "egId");
		return this.hashFields;
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
	 * @return spName
	 */
	public String getSpName() {
		return this.spName;
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
	 * @return egRhqCd
	 */
	public String getEgRhqCd() {
		return this.egRhqCd;
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
	 * @return spSeq
	 */
	public String getSpSeq() {
		return this.spSeq;
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
	 * @return spKpiId
	 */
	public String getSpKpiId() {
		return this.spKpiId;
	}
	
	/**
	 * Column Info
	 * @return rsltScreRto
	 */
	public String getRsltScreRto() {
		return this.rsltScreRto;
	}
	
	/**
	 * Column Info
	 * @return pfmc
	 */
	public String getPfmc() {
		return this.pfmc;
	}
	
	/**
	 * Column Info
	 * @return evSvcCateCd
	 */
	public String getEvSvcCateCd() {
		return this.evSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @return egOfcCd
	 */
	public String getEgOfcCd() {
		return this.egOfcCd;
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
	 * @return egId
	 */
	public String getEgId() {
		return this.egId;
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
	 * @param spName
	 */
	public void setSpName(String spName) {
		this.spName = spName;
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
	 * @param egRhqCd
	 */
	public void setEgRhqCd(String egRhqCd) {
		this.egRhqCd = egRhqCd;
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
	 * @param spSeq
	 */
	public void setSpSeq(String spSeq) {
		this.spSeq = spSeq;
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
	 * @param spKpiId
	 */
	public void setSpKpiId(String spKpiId) {
		this.spKpiId = spKpiId;
	}
	
	/**
	 * Column Info
	 * @param rsltScreRto
	 */
	public void setRsltScreRto(String rsltScreRto) {
		this.rsltScreRto = rsltScreRto;
	}
	
	/**
	 * Column Info
	 * @param pfmc
	 */
	public void setPfmc(String pfmc) {
		this.pfmc = pfmc;
	}
	
	/**
	 * Column Info
	 * @param evSvcCateCd
	 */
	public void setEvSvcCateCd(String evSvcCateCd) {
		this.evSvcCateCd = evSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @param egOfcCd
	 */
	public void setEgOfcCd(String egOfcCd) {
		this.egOfcCd = egOfcCd;
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
		setSpKpiTpCd(JSPUtil.getParameter(request, prefix + "sp_kpi_tp_cd", ""));
		setSpName(JSPUtil.getParameter(request, prefix + "sp_name", ""));
		setSpKpiNm(JSPUtil.getParameter(request, prefix + "sp_kpi_nm", ""));
		setEgRhqCd(JSPUtil.getParameter(request, prefix + "eg_rhq_cd", ""));
		setSpKpiTpNm(JSPUtil.getParameter(request, prefix + "sp_kpi_tp_nm", ""));
		setSpSeq(JSPUtil.getParameter(request, prefix + "sp_seq", ""));
		setKpiTgtRto(JSPUtil.getParameter(request, prefix + "kpi_tgt_rto", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEgNm(JSPUtil.getParameter(request, prefix + "eg_nm", ""));
		setSpKpiId(JSPUtil.getParameter(request, prefix + "sp_kpi_id", ""));
		setRsltScreRto(JSPUtil.getParameter(request, prefix + "rslt_scre_rto", ""));
		setPfmc(JSPUtil.getParameter(request, prefix + "pfmc", ""));
		setEvSvcCateCd(JSPUtil.getParameter(request, prefix + "ev_svc_cate_cd", ""));
		setEgOfcCd(JSPUtil.getParameter(request, prefix + "eg_ofc_cd", ""));
		setKpiWgtRto(JSPUtil.getParameter(request, prefix + "kpi_wgt_rto", ""));
		setEvYr(JSPUtil.getParameter(request, prefix + "ev_yr", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpeSDAnalysisDtlVO[]
	 */
	public SpeSDAnalysisDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpeSDAnalysisDtlVO[]
	 */
	public SpeSDAnalysisDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpeSDAnalysisDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] spKpiTpCd = (JSPUtil.getParameter(request, prefix	+ "sp_kpi_tp_cd", length));
			String[] spName = (JSPUtil.getParameter(request, prefix	+ "sp_name", length));
			String[] spKpiNm = (JSPUtil.getParameter(request, prefix	+ "sp_kpi_nm", length));
			String[] egRhqCd = (JSPUtil.getParameter(request, prefix	+ "eg_rhq_cd", length));
			String[] spKpiTpNm = (JSPUtil.getParameter(request, prefix	+ "sp_kpi_tp_nm", length));
			String[] spSeq = (JSPUtil.getParameter(request, prefix	+ "sp_seq", length));
			String[] kpiTgtRto = (JSPUtil.getParameter(request, prefix	+ "kpi_tgt_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] egNm = (JSPUtil.getParameter(request, prefix	+ "eg_nm", length));
			String[] spKpiId = (JSPUtil.getParameter(request, prefix	+ "sp_kpi_id", length));
			String[] rsltScreRto = (JSPUtil.getParameter(request, prefix	+ "rslt_scre_rto", length));
			String[] pfmc = (JSPUtil.getParameter(request, prefix	+ "pfmc", length));
			String[] evSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "ev_svc_cate_cd", length));
			String[] egOfcCd = (JSPUtil.getParameter(request, prefix	+ "eg_ofc_cd", length));
			String[] kpiWgtRto = (JSPUtil.getParameter(request, prefix	+ "kpi_wgt_rto", length));
			String[] evYr = (JSPUtil.getParameter(request, prefix	+ "ev_yr", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpeSDAnalysisDtlVO();
				if (spKpiTpCd[i] != null)
					model.setSpKpiTpCd(spKpiTpCd[i]);
				if (spName[i] != null)
					model.setSpName(spName[i]);
				if (spKpiNm[i] != null)
					model.setSpKpiNm(spKpiNm[i]);
				if (egRhqCd[i] != null)
					model.setEgRhqCd(egRhqCd[i]);
				if (spKpiTpNm[i] != null)
					model.setSpKpiTpNm(spKpiTpNm[i]);
				if (spSeq[i] != null)
					model.setSpSeq(spSeq[i]);
				if (kpiTgtRto[i] != null)
					model.setKpiTgtRto(kpiTgtRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (egNm[i] != null)
					model.setEgNm(egNm[i]);
				if (spKpiId[i] != null)
					model.setSpKpiId(spKpiId[i]);
				if (rsltScreRto[i] != null)
					model.setRsltScreRto(rsltScreRto[i]);
				if (pfmc[i] != null)
					model.setPfmc(pfmc[i]);
				if (evSvcCateCd[i] != null)
					model.setEvSvcCateCd(evSvcCateCd[i]);
				if (egOfcCd[i] != null)
					model.setEgOfcCd(egOfcCd[i]);
				if (kpiWgtRto[i] != null)
					model.setKpiWgtRto(kpiWgtRto[i]);
				if (evYr[i] != null)
					model.setEvYr(evYr[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpeSDAnalysisDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpeSDAnalysisDtlVO[]
	 */
	public SpeSDAnalysisDtlVO[] getSpeSDAnalysisDtlVOs(){
		SpeSDAnalysisDtlVO[] vos = (SpeSDAnalysisDtlVO[])models.toArray(new SpeSDAnalysisDtlVO[models.size()]);
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
		this.spKpiTpCd = this.spKpiTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spName = this.spName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spKpiNm = this.spKpiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egRhqCd = this.egRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spKpiTpNm = this.spKpiTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spSeq = this.spSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiTgtRto = this.kpiTgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egNm = this.egNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spKpiId = this.spKpiId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltScreRto = this.rsltScreRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmc = this.pfmc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evSvcCateCd = this.evSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egOfcCd = this.egOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiWgtRto = this.kpiWgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evYr = this.evYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
