/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpeSDAnalysisVO.java
*@FileTitle : SpeSDAnalysisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.23
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.23 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.vo;

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

public class SpeSDAnalysisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpeSDAnalysisVO> models = new ArrayList<SpeSDAnalysisVO>();
	
	/* Column Info */
	private String sdGroup = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String spName = null;
	/* Column Info */
	private String egRhqCd = null;
	/* Column Info */
	private String evToYr = null;
	/* Column Info */
	private String evToMon = null;
	/* Column Info */
	private String spSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String evFromYr = null;
	/* Column Info */
	private String egNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String evSvcCateCd = null;
	/* Column Info */
	private String bePoint = null;
	/* Column Info */
	private String beGroup = null;
	/* Column Info */
	private String sEvSvcCateCd = null;
	/* Column Info */
	private String evYr = null;
	/* Column Info */
	private String sSpSeq = null;
	/* Column Info */
	private String mon = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String sSdGp = null;
	/* Column Info */
	private String sEgOfcCd = null;
	/* Column Info */
	private String sEgRhqCd = null;
	/* Column Info */
	private String paGroup = null;
	/* Column Info */
	private String egOfcCd = null;
	/* Column Info */
	private String evFromMon = null;
	/* Column Info */
	private String egId = null;
	/* Column Info */
	private String paPoint = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpeSDAnalysisVO() {}

	public SpeSDAnalysisVO(String ibflag, String pagerows, String egRhqCd, String egOfcCd, String evSvcCateCd, String egId, String egNm, String spSeq, String spName, String sdGroup, String paPoint, String paGroup, String bePoint, String beGroup, String sEgRhqCd, String sEgOfcCd, String sEvSvcCateCd, String sSpSeq, String mon, String fromDt, String toDt, String evYr, String evFromYr, String evToYr, String evFromMon, String evToMon, String sSdGp) {
		this.sdGroup = sdGroup;
		this.fromDt = fromDt;
		this.spName = spName;
		this.egRhqCd = egRhqCd;
		this.evToYr = evToYr;
		this.evToMon = evToMon;
		this.spSeq = spSeq;
		this.pagerows = pagerows;
		this.evFromYr = evFromYr;
		this.egNm = egNm;
		this.ibflag = ibflag;
		this.evSvcCateCd = evSvcCateCd;
		this.bePoint = bePoint;
		this.beGroup = beGroup;
		this.sEvSvcCateCd = sEvSvcCateCd;
		this.evYr = evYr;
		this.sSpSeq = sSpSeq;
		this.mon = mon;
		this.toDt = toDt;
		this.sSdGp = sSdGp;
		this.sEgOfcCd = sEgOfcCd;
		this.sEgRhqCd = sEgRhqCd;
		this.paGroup = paGroup;
		this.egOfcCd = egOfcCd;
		this.evFromMon = evFromMon;
		this.egId = egId;
		this.paPoint = paPoint;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sd_group", getSdGroup());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("sp_name", getSpName());
		this.hashColumns.put("eg_rhq_cd", getEgRhqCd());
		this.hashColumns.put("ev_to_yr", getEvToYr());
		this.hashColumns.put("ev_to_mon", getEvToMon());
		this.hashColumns.put("sp_seq", getSpSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ev_from_yr", getEvFromYr());
		this.hashColumns.put("eg_nm", getEgNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ev_svc_cate_cd", getEvSvcCateCd());
		this.hashColumns.put("be_point", getBePoint());
		this.hashColumns.put("be_group", getBeGroup());
		this.hashColumns.put("s_ev_svc_cate_cd", getSEvSvcCateCd());
		this.hashColumns.put("ev_yr", getEvYr());
		this.hashColumns.put("s_sp_seq", getSSpSeq());
		this.hashColumns.put("mon", getMon());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("s_sd_gp", getSSdGp());
		this.hashColumns.put("s_eg_ofc_cd", getSEgOfcCd());
		this.hashColumns.put("s_eg_rhq_cd", getSEgRhqCd());
		this.hashColumns.put("pa_group", getPaGroup());
		this.hashColumns.put("eg_ofc_cd", getEgOfcCd());
		this.hashColumns.put("ev_from_mon", getEvFromMon());
		this.hashColumns.put("eg_id", getEgId());
		this.hashColumns.put("pa_point", getPaPoint());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sd_group", "sdGroup");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("sp_name", "spName");
		this.hashFields.put("eg_rhq_cd", "egRhqCd");
		this.hashFields.put("ev_to_yr", "evToYr");
		this.hashFields.put("ev_to_mon", "evToMon");
		this.hashFields.put("sp_seq", "spSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ev_from_yr", "evFromYr");
		this.hashFields.put("eg_nm", "egNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ev_svc_cate_cd", "evSvcCateCd");
		this.hashFields.put("be_point", "bePoint");
		this.hashFields.put("be_group", "beGroup");
		this.hashFields.put("s_ev_svc_cate_cd", "sEvSvcCateCd");
		this.hashFields.put("ev_yr", "evYr");
		this.hashFields.put("s_sp_seq", "sSpSeq");
		this.hashFields.put("mon", "mon");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("s_sd_gp", "sSdGp");
		this.hashFields.put("s_eg_ofc_cd", "sEgOfcCd");
		this.hashFields.put("s_eg_rhq_cd", "sEgRhqCd");
		this.hashFields.put("pa_group", "paGroup");
		this.hashFields.put("eg_ofc_cd", "egOfcCd");
		this.hashFields.put("ev_from_mon", "evFromMon");
		this.hashFields.put("eg_id", "egId");
		this.hashFields.put("pa_point", "paPoint");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sdGroup
	 */
	public String getSdGroup() {
		return this.sdGroup;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
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
	 * @return egRhqCd
	 */
	public String getEgRhqCd() {
		return this.egRhqCd;
	}
	
	/**
	 * Column Info
	 * @return evToYr
	 */
	public String getEvToYr() {
		return this.evToYr;
	}
	
	/**
	 * Column Info
	 * @return evToMon
	 */
	public String getEvToMon() {
		return this.evToMon;
	}
	
	/**
	 * Column Info
	 * @return spSeq
	 */
	public String getSpSeq() {
		return this.spSeq;
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
	 * @return evFromYr
	 */
	public String getEvFromYr() {
		return this.evFromYr;
	}
	
	/**
	 * Column Info
	 * @return egNm
	 */
	public String getEgNm() {
		return this.egNm;
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
	 * @return evSvcCateCd
	 */
	public String getEvSvcCateCd() {
		return this.evSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @return bePoint
	 */
	public String getBePoint() {
		return this.bePoint;
	}
	
	/**
	 * Column Info
	 * @return beGroup
	 */
	public String getBeGroup() {
		return this.beGroup;
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
	 * @return evYr
	 */
	public String getEvYr() {
		return this.evYr;
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
	 * @return mon
	 */
	public String getMon() {
		return this.mon;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return sSdGp
	 */
	public String getSSdGp() {
		return this.sSdGp;
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
	 * @return sEgRhqCd
	 */
	public String getSEgRhqCd() {
		return this.sEgRhqCd;
	}
	
	/**
	 * Column Info
	 * @return paGroup
	 */
	public String getPaGroup() {
		return this.paGroup;
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
	 * @return evFromMon
	 */
	public String getEvFromMon() {
		return this.evFromMon;
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
	 * @return paPoint
	 */
	public String getPaPoint() {
		return this.paPoint;
	}
	

	/**
	 * Column Info
	 * @param sdGroup
	 */
	public void setSdGroup(String sdGroup) {
		this.sdGroup = sdGroup;
	}
	
	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
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
	 * @param egRhqCd
	 */
	public void setEgRhqCd(String egRhqCd) {
		this.egRhqCd = egRhqCd;
	}
	
	/**
	 * Column Info
	 * @param evToYr
	 */
	public void setEvToYr(String evToYr) {
		this.evToYr = evToYr;
	}
	
	/**
	 * Column Info
	 * @param evToMon
	 */
	public void setEvToMon(String evToMon) {
		this.evToMon = evToMon;
	}
	
	/**
	 * Column Info
	 * @param spSeq
	 */
	public void setSpSeq(String spSeq) {
		this.spSeq = spSeq;
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
	 * @param evFromYr
	 */
	public void setEvFromYr(String evFromYr) {
		this.evFromYr = evFromYr;
	}
	
	/**
	 * Column Info
	 * @param egNm
	 */
	public void setEgNm(String egNm) {
		this.egNm = egNm;
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
	 * @param evSvcCateCd
	 */
	public void setEvSvcCateCd(String evSvcCateCd) {
		this.evSvcCateCd = evSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @param bePoint
	 */
	public void setBePoint(String bePoint) {
		this.bePoint = bePoint;
	}
	
	/**
	 * Column Info
	 * @param beGroup
	 */
	public void setBeGroup(String beGroup) {
		this.beGroup = beGroup;
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
	 * @param evYr
	 */
	public void setEvYr(String evYr) {
		this.evYr = evYr;
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
	 * @param mon
	 */
	public void setMon(String mon) {
		this.mon = mon;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param sSdGp
	 */
	public void setSSdGp(String sSdGp) {
		this.sSdGp = sSdGp;
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
	 * @param sEgRhqCd
	 */
	public void setSEgRhqCd(String sEgRhqCd) {
		this.sEgRhqCd = sEgRhqCd;
	}
	
	/**
	 * Column Info
	 * @param paGroup
	 */
	public void setPaGroup(String paGroup) {
		this.paGroup = paGroup;
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
	 * @param evFromMon
	 */
	public void setEvFromMon(String evFromMon) {
		this.evFromMon = evFromMon;
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
	 * @param paPoint
	 */
	public void setPaPoint(String paPoint) {
		this.paPoint = paPoint;
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
		setSdGroup(JSPUtil.getParameter(request, prefix + "sd_group", ""));
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setSpName(JSPUtil.getParameter(request, prefix + "sp_name", ""));
		setEgRhqCd(JSPUtil.getParameter(request, prefix + "eg_rhq_cd", ""));
		setEvToYr(JSPUtil.getParameter(request, prefix + "ev_to_yr", ""));
		setEvToMon(JSPUtil.getParameter(request, prefix + "ev_to_mon", ""));
		setSpSeq(JSPUtil.getParameter(request, prefix + "sp_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEvFromYr(JSPUtil.getParameter(request, prefix + "ev_from_yr", ""));
		setEgNm(JSPUtil.getParameter(request, prefix + "eg_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEvSvcCateCd(JSPUtil.getParameter(request, prefix + "ev_svc_cate_cd", ""));
		setBePoint(JSPUtil.getParameter(request, prefix + "be_point", ""));
		setBeGroup(JSPUtil.getParameter(request, prefix + "be_group", ""));
		setSEvSvcCateCd(JSPUtil.getParameter(request, prefix + "s_ev_svc_cate_cd", ""));
		setEvYr(JSPUtil.getParameter(request, prefix + "ev_yr", ""));
		setSSpSeq(JSPUtil.getParameter(request, prefix + "s_sp_seq", ""));
		setMon(JSPUtil.getParameter(request, prefix + "mon", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setSSdGp(JSPUtil.getParameter(request, prefix + "s_sd_gp", ""));
		setSEgOfcCd(JSPUtil.getParameter(request, prefix + "s_eg_ofc_cd", ""));
		setSEgRhqCd(JSPUtil.getParameter(request, prefix + "s_eg_rhq_cd", ""));
		setPaGroup(JSPUtil.getParameter(request, prefix + "pa_group", ""));
		setEgOfcCd(JSPUtil.getParameter(request, prefix + "eg_ofc_cd", ""));
		setEvFromMon(JSPUtil.getParameter(request, prefix + "ev_from_mon", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
		setPaPoint(JSPUtil.getParameter(request, prefix + "pa_point", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpeSDAnalysisVO[]
	 */
	public SpeSDAnalysisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpeSDAnalysisVO[]
	 */
	public SpeSDAnalysisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpeSDAnalysisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sdGroup = (JSPUtil.getParameter(request, prefix	+ "sd_group", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] spName = (JSPUtil.getParameter(request, prefix	+ "sp_name", length));
			String[] egRhqCd = (JSPUtil.getParameter(request, prefix	+ "eg_rhq_cd", length));
			String[] evToYr = (JSPUtil.getParameter(request, prefix	+ "ev_to_yr", length));
			String[] evToMon = (JSPUtil.getParameter(request, prefix	+ "ev_to_mon", length));
			String[] spSeq = (JSPUtil.getParameter(request, prefix	+ "sp_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] evFromYr = (JSPUtil.getParameter(request, prefix	+ "ev_from_yr", length));
			String[] egNm = (JSPUtil.getParameter(request, prefix	+ "eg_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] evSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "ev_svc_cate_cd", length));
			String[] bePoint = (JSPUtil.getParameter(request, prefix	+ "be_point", length));
			String[] beGroup = (JSPUtil.getParameter(request, prefix	+ "be_group", length));
			String[] sEvSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "s_ev_svc_cate_cd", length));
			String[] evYr = (JSPUtil.getParameter(request, prefix	+ "ev_yr", length));
			String[] sSpSeq = (JSPUtil.getParameter(request, prefix	+ "s_sp_seq", length));
			String[] mon = (JSPUtil.getParameter(request, prefix	+ "mon", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] sSdGp = (JSPUtil.getParameter(request, prefix	+ "s_sd_gp", length));
			String[] sEgOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_ofc_cd", length));
			String[] sEgRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_eg_rhq_cd", length));
			String[] paGroup = (JSPUtil.getParameter(request, prefix	+ "pa_group", length));
			String[] egOfcCd = (JSPUtil.getParameter(request, prefix	+ "eg_ofc_cd", length));
			String[] evFromMon = (JSPUtil.getParameter(request, prefix	+ "ev_from_mon", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			String[] paPoint = (JSPUtil.getParameter(request, prefix	+ "pa_point", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpeSDAnalysisVO();
				if (sdGroup[i] != null)
					model.setSdGroup(sdGroup[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (spName[i] != null)
					model.setSpName(spName[i]);
				if (egRhqCd[i] != null)
					model.setEgRhqCd(egRhqCd[i]);
				if (evToYr[i] != null)
					model.setEvToYr(evToYr[i]);
				if (evToMon[i] != null)
					model.setEvToMon(evToMon[i]);
				if (spSeq[i] != null)
					model.setSpSeq(spSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (evFromYr[i] != null)
					model.setEvFromYr(evFromYr[i]);
				if (egNm[i] != null)
					model.setEgNm(egNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (evSvcCateCd[i] != null)
					model.setEvSvcCateCd(evSvcCateCd[i]);
				if (bePoint[i] != null)
					model.setBePoint(bePoint[i]);
				if (beGroup[i] != null)
					model.setBeGroup(beGroup[i]);
				if (sEvSvcCateCd[i] != null)
					model.setSEvSvcCateCd(sEvSvcCateCd[i]);
				if (evYr[i] != null)
					model.setEvYr(evYr[i]);
				if (sSpSeq[i] != null)
					model.setSSpSeq(sSpSeq[i]);
				if (mon[i] != null)
					model.setMon(mon[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (sSdGp[i] != null)
					model.setSSdGp(sSdGp[i]);
				if (sEgOfcCd[i] != null)
					model.setSEgOfcCd(sEgOfcCd[i]);
				if (sEgRhqCd[i] != null)
					model.setSEgRhqCd(sEgRhqCd[i]);
				if (paGroup[i] != null)
					model.setPaGroup(paGroup[i]);
				if (egOfcCd[i] != null)
					model.setEgOfcCd(egOfcCd[i]);
				if (evFromMon[i] != null)
					model.setEvFromMon(evFromMon[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				if (paPoint[i] != null)
					model.setPaPoint(paPoint[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpeSDAnalysisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpeSDAnalysisVO[]
	 */
	public SpeSDAnalysisVO[] getSpeSDAnalysisVOs(){
		SpeSDAnalysisVO[] vos = (SpeSDAnalysisVO[])models.toArray(new SpeSDAnalysisVO[models.size()]);
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
		this.sdGroup = this.sdGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spName = this.spName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egRhqCd = this.egRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evToYr = this.evToYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evToMon = this.evToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spSeq = this.spSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evFromYr = this.evFromYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egNm = this.egNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evSvcCateCd = this.evSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bePoint = this.bePoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.beGroup = this.beGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEvSvcCateCd = this.sEvSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evYr = this.evYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSpSeq = this.sSpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon = this.mon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSdGp = this.sSdGp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgOfcCd = this.sEgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEgRhqCd = this.sEgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paGroup = this.paGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egOfcCd = this.egOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evFromMon = this.evFromMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paPoint = this.paPoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
