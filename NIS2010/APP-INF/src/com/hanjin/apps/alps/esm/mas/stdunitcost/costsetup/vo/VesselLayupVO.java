/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselLayupVO.java
*@FileTitle : VesselLayupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo;

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

public class VesselLayupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VesselLayupVO> models = new ArrayList<VesselLayupVO>();
	
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String sunCostAmt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String fYearweek = null;
	/* Column Info */
	private String vslCdTtl = null;
	/* Column Info */
	private String thuCostAmt = null;
	/* Column Info */
	private String tueCostAmt = null;
	/* Column Info */
	private String monCostAmt = null;
	/* Column Info */
	private String mergeCd = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String wedCostAmt = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String friCostAmt = null;
	/* Column Info */
	private String wkPeriod = null;
	/* Column Info */
	private String satCostAmt = null;
	/* Column Info */
	private String stndCostCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VesselLayupVO() {}

	public VesselLayupVO(String ibflag, String pagerows, String mergeCd, String fYearweek, String costYr, String costWk, String costYrmon, String rlaneCd, String vslCd, String vslCdTtl, String stndCostCd, String stndCostNm, String sunCostAmt, String monCostAmt, String tueCostAmt, String wedCostAmt, String thuCostAmt, String friCostAmt, String satCostAmt, String ttlAmt, String dpSeq, String usrId, String wkPeriod) {
		this.dpSeq = dpSeq;
		this.sunCostAmt = sunCostAmt;
		this.vslCd = vslCd;
		this.fYearweek = fYearweek;
		this.vslCdTtl = vslCdTtl;
		this.thuCostAmt = thuCostAmt;
		this.tueCostAmt = tueCostAmt;
		this.monCostAmt = monCostAmt;
		this.mergeCd = mergeCd;
		this.ttlAmt = ttlAmt;
		this.rlaneCd = rlaneCd;
		this.wedCostAmt = wedCostAmt;
		this.stndCostNm = stndCostNm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.usrId = usrId;
		this.costYr = costYr;
		this.costWk = costWk;
		this.friCostAmt = friCostAmt;
		this.wkPeriod = wkPeriod;
		this.satCostAmt = satCostAmt;
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("sun_cost_amt", getSunCostAmt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("f_yearweek", getFYearweek());
		this.hashColumns.put("vsl_cd_ttl", getVslCdTtl());
		this.hashColumns.put("thu_cost_amt", getThuCostAmt());
		this.hashColumns.put("tue_cost_amt", getTueCostAmt());
		this.hashColumns.put("mon_cost_amt", getMonCostAmt());
		this.hashColumns.put("merge_cd", getMergeCd());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("wed_cost_amt", getWedCostAmt());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("fri_cost_amt", getFriCostAmt());
		this.hashColumns.put("wk_period", getWkPeriod());
		this.hashColumns.put("sat_cost_amt", getSatCostAmt());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("sun_cost_amt", "sunCostAmt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("f_yearweek", "fYearweek");
		this.hashFields.put("vsl_cd_ttl", "vslCdTtl");
		this.hashFields.put("thu_cost_amt", "thuCostAmt");
		this.hashFields.put("tue_cost_amt", "tueCostAmt");
		this.hashFields.put("mon_cost_amt", "monCostAmt");
		this.hashFields.put("merge_cd", "mergeCd");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("wed_cost_amt", "wedCostAmt");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("fri_cost_amt", "friCostAmt");
		this.hashFields.put("wk_period", "wkPeriod");
		this.hashFields.put("sat_cost_amt", "satCostAmt");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
	}
	
	/**
	 * Column Info
	 * @return sunCostAmt
	 */
	public String getSunCostAmt() {
		return this.sunCostAmt;
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
	 * @return fYearweek
	 */
	public String getFYearweek() {
		return this.fYearweek;
	}
	
	/**
	 * Column Info
	 * @return vslCdTtl
	 */
	public String getVslCdTtl() {
		return this.vslCdTtl;
	}
	
	/**
	 * Column Info
	 * @return thuCostAmt
	 */
	public String getThuCostAmt() {
		return this.thuCostAmt;
	}
	
	/**
	 * Column Info
	 * @return tueCostAmt
	 */
	public String getTueCostAmt() {
		return this.tueCostAmt;
	}
	
	/**
	 * Column Info
	 * @return monCostAmt
	 */
	public String getMonCostAmt() {
		return this.monCostAmt;
	}
	
	/**
	 * Column Info
	 * @return mergeCd
	 */
	public String getMergeCd() {
		return this.mergeCd;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return wedCostAmt
	 */
	public String getWedCostAmt() {
		return this.wedCostAmt;
	}
	
	/**
	 * Column Info
	 * @return stndCostNm
	 */
	public String getStndCostNm() {
		return this.stndCostNm;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return costYr
	 */
	public String getCostYr() {
		return this.costYr;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return friCostAmt
	 */
	public String getFriCostAmt() {
		return this.friCostAmt;
	}
	
	/**
	 * Column Info
	 * @return wkPeriod
	 */
	public String getWkPeriod() {
		return this.wkPeriod;
	}
	
	/**
	 * Column Info
	 * @return satCostAmt
	 */
	public String getSatCostAmt() {
		return this.satCostAmt;
	}
	
	/**
	 * Column Info
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
	}
	

	/**
	 * Column Info
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}
	
	/**
	 * Column Info
	 * @param sunCostAmt
	 */
	public void setSunCostAmt(String sunCostAmt) {
		this.sunCostAmt = sunCostAmt;
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
	 * @param fYearweek
	 */
	public void setFYearweek(String fYearweek) {
		this.fYearweek = fYearweek;
	}
	
	/**
	 * Column Info
	 * @param vslCdTtl
	 */
	public void setVslCdTtl(String vslCdTtl) {
		this.vslCdTtl = vslCdTtl;
	}
	
	/**
	 * Column Info
	 * @param thuCostAmt
	 */
	public void setThuCostAmt(String thuCostAmt) {
		this.thuCostAmt = thuCostAmt;
	}
	
	/**
	 * Column Info
	 * @param tueCostAmt
	 */
	public void setTueCostAmt(String tueCostAmt) {
		this.tueCostAmt = tueCostAmt;
	}
	
	/**
	 * Column Info
	 * @param monCostAmt
	 */
	public void setMonCostAmt(String monCostAmt) {
		this.monCostAmt = monCostAmt;
	}
	
	/**
	 * Column Info
	 * @param mergeCd
	 */
	public void setMergeCd(String mergeCd) {
		this.mergeCd = mergeCd;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param wedCostAmt
	 */
	public void setWedCostAmt(String wedCostAmt) {
		this.wedCostAmt = wedCostAmt;
	}
	
	/**
	 * Column Info
	 * @param stndCostNm
	 */
	public void setStndCostNm(String stndCostNm) {
		this.stndCostNm = stndCostNm;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param costYr
	 */
	public void setCostYr(String costYr) {
		this.costYr = costYr;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param friCostAmt
	 */
	public void setFriCostAmt(String friCostAmt) {
		this.friCostAmt = friCostAmt;
	}
	
	/**
	 * Column Info
	 * @param wkPeriod
	 */
	public void setWkPeriod(String wkPeriod) {
		this.wkPeriod = wkPeriod;
	}
	
	/**
	 * Column Info
	 * @param satCostAmt
	 */
	public void setSatCostAmt(String satCostAmt) {
		this.satCostAmt = satCostAmt;
	}
	
	/**
	 * Column Info
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
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
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setSunCostAmt(JSPUtil.getParameter(request, prefix + "sun_cost_amt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setFYearweek(JSPUtil.getParameter(request, prefix + "f_yearweek", ""));
		setVslCdTtl(JSPUtil.getParameter(request, prefix + "vsl_cd_ttl", ""));
		setThuCostAmt(JSPUtil.getParameter(request, prefix + "thu_cost_amt", ""));
		setTueCostAmt(JSPUtil.getParameter(request, prefix + "tue_cost_amt", ""));
		setMonCostAmt(JSPUtil.getParameter(request, prefix + "mon_cost_amt", ""));
		setMergeCd(JSPUtil.getParameter(request, prefix + "merge_cd", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setWedCostAmt(JSPUtil.getParameter(request, prefix + "wed_cost_amt", ""));
		setStndCostNm(JSPUtil.getParameter(request, prefix + "stnd_cost_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCostYr(JSPUtil.getParameter(request, prefix + "cost_yr", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setFriCostAmt(JSPUtil.getParameter(request, prefix + "fri_cost_amt", ""));
		setWkPeriod(JSPUtil.getParameter(request, prefix + "wk_period", ""));
		setSatCostAmt(JSPUtil.getParameter(request, prefix + "sat_cost_amt", ""));
		setStndCostCd(JSPUtil.getParameter(request, prefix + "stnd_cost_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VesselLayupVO[]
	 */
	public VesselLayupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VesselLayupVO[]
	 */
	public VesselLayupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VesselLayupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] sunCostAmt = (JSPUtil.getParameter(request, prefix	+ "sun_cost_amt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] fYearweek = (JSPUtil.getParameter(request, prefix	+ "f_yearweek", length));
			String[] vslCdTtl = (JSPUtil.getParameter(request, prefix	+ "vsl_cd_ttl", length));
			String[] thuCostAmt = (JSPUtil.getParameter(request, prefix	+ "thu_cost_amt", length));
			String[] tueCostAmt = (JSPUtil.getParameter(request, prefix	+ "tue_cost_amt", length));
			String[] monCostAmt = (JSPUtil.getParameter(request, prefix	+ "mon_cost_amt", length));
			String[] mergeCd = (JSPUtil.getParameter(request, prefix	+ "merge_cd", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] wedCostAmt = (JSPUtil.getParameter(request, prefix	+ "wed_cost_amt", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] friCostAmt = (JSPUtil.getParameter(request, prefix	+ "fri_cost_amt", length));
			String[] wkPeriod = (JSPUtil.getParameter(request, prefix	+ "wk_period", length));
			String[] satCostAmt = (JSPUtil.getParameter(request, prefix	+ "sat_cost_amt", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new VesselLayupVO();
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (sunCostAmt[i] != null)
					model.setSunCostAmt(sunCostAmt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (fYearweek[i] != null)
					model.setFYearweek(fYearweek[i]);
				if (vslCdTtl[i] != null)
					model.setVslCdTtl(vslCdTtl[i]);
				if (thuCostAmt[i] != null)
					model.setThuCostAmt(thuCostAmt[i]);
				if (tueCostAmt[i] != null)
					model.setTueCostAmt(tueCostAmt[i]);
				if (monCostAmt[i] != null)
					model.setMonCostAmt(monCostAmt[i]);
				if (mergeCd[i] != null)
					model.setMergeCd(mergeCd[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (wedCostAmt[i] != null)
					model.setWedCostAmt(wedCostAmt[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (friCostAmt[i] != null)
					model.setFriCostAmt(friCostAmt[i]);
				if (wkPeriod[i] != null)
					model.setWkPeriod(wkPeriod[i]);
				if (satCostAmt[i] != null)
					model.setSatCostAmt(satCostAmt[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVesselLayupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VesselLayupVO[]
	 */
	public VesselLayupVO[] getVesselLayupVOs(){
		VesselLayupVO[] vos = (VesselLayupVO[])models.toArray(new VesselLayupVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sunCostAmt = this.sunCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYearweek = this.fYearweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCdTtl = this.vslCdTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thuCostAmt = this.thuCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tueCostAmt = this.tueCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monCostAmt = this.monCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mergeCd = this.mergeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wedCostAmt = this.wedCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.friCostAmt = this.friCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkPeriod = this.wkPeriod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.satCostAmt = this.satCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
