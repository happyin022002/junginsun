/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchContinentVO.java
*@FileTitle : SearchContinentVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.18 김태균 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchContinentVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchContinentVO> models = new ArrayList<SearchContinentVO>();
	
	/* Column Info */
	private String xcldSatFlg = null;
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String dmdtChgCmncTpCd = null;
	/* Column Info */
	private String orgDest = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String overDay = null;
	/* Column Info */
	private String cntr20ftRtAmt = null;
	/* Column Info */
	private String cntr45ftRtAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dmdtBzcTrfGrpNm = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntr40ftRtAmt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String dmdtCgoTpCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String cntrHcRtAmt = null;
	/* Column Info */
	private String dmdtCntrTpCd = null;
	/* Column Info */
	private String wknd2 = null;
	/* Column Info */
	private String ftDys = null;
	/* Column Info */
	private String expireChk = null;
	/* Column Info */
	private String xcldHolFlg = null;
	/* Column Info */
	private String wknd1 = null;
	/* Column Info */
	private String trfGrpSeq = null;
	/* Column Info */
	private String freeTime = null;
	/* Column Info */
	private String covrg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchContinentVO() {}

	public SearchContinentVO(String ibflag, String pagerows, String dmdtTrfCd, String covrg, String orgDest, String trfGrpSeq, String dmdtBzcTrfGrpNm, String effDt, String expDt, String dmdtChgCmncTpCd, String dmdtCntrTpCd, String dmdtCgoTpCd, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String freeTime, String ftDys, String currCd, String overDay, String cntr20ftRtAmt, String cntr40ftRtAmt, String cntrHcRtAmt, String cntr45ftRtAmt, String expireChk, String wknd1, String wknd2) {
		this.xcldSatFlg = xcldSatFlg;
		this.xcldSunFlg = xcldSunFlg;
		this.dmdtChgCmncTpCd = dmdtChgCmncTpCd;
		this.orgDest = orgDest;
		this.currCd = currCd;
		this.overDay = overDay;
		this.cntr20ftRtAmt = cntr20ftRtAmt;
		this.cntr45ftRtAmt = cntr45ftRtAmt;
		this.pagerows = pagerows;
		this.dmdtBzcTrfGrpNm = dmdtBzcTrfGrpNm;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.cntr40ftRtAmt = cntr40ftRtAmt;
		this.expDt = expDt;
		this.dmdtCgoTpCd = dmdtCgoTpCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.cntrHcRtAmt = cntrHcRtAmt;
		this.dmdtCntrTpCd = dmdtCntrTpCd;
		this.wknd2 = wknd2;
		this.ftDys = ftDys;
		this.expireChk = expireChk;
		this.xcldHolFlg = xcldHolFlg;
		this.wknd1 = wknd1;
		this.trfGrpSeq = trfGrpSeq;
		this.freeTime = freeTime;
		this.covrg = covrg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("dmdt_chg_cmnc_tp_cd", getDmdtChgCmncTpCd());
		this.hashColumns.put("org_dest", getOrgDest());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("over_day", getOverDay());
		this.hashColumns.put("cntr_20ft_rt_amt", getCntr20ftRtAmt());
		this.hashColumns.put("cntr_45ft_rt_amt", getCntr45ftRtAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dmdt_bzc_trf_grp_nm", getDmdtBzcTrfGrpNm());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_40ft_rt_amt", getCntr40ftRtAmt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("dmdt_cgo_tp_cd", getDmdtCgoTpCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("cntr_hc_rt_amt", getCntrHcRtAmt());
		this.hashColumns.put("dmdt_cntr_tp_cd", getDmdtCntrTpCd());
		this.hashColumns.put("wknd2", getWknd2());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("expire_chk", getExpireChk());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("wknd1", getWknd1());
		this.hashColumns.put("trf_grp_seq", getTrfGrpSeq());
		this.hashColumns.put("free_time", getFreeTime());
		this.hashColumns.put("covrg", getCovrg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
		this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
		this.hashFields.put("dmdt_chg_cmnc_tp_cd", "dmdtChgCmncTpCd");
		this.hashFields.put("org_dest", "orgDest");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("over_day", "overDay");
		this.hashFields.put("cntr_20ft_rt_amt", "cntr20ftRtAmt");
		this.hashFields.put("cntr_45ft_rt_amt", "cntr45ftRtAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dmdt_bzc_trf_grp_nm", "dmdtBzcTrfGrpNm");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_40ft_rt_amt", "cntr40ftRtAmt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("dmdt_cgo_tp_cd", "dmdtCgoTpCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("cntr_hc_rt_amt", "cntrHcRtAmt");
		this.hashFields.put("dmdt_cntr_tp_cd", "dmdtCntrTpCd");
		this.hashFields.put("wknd2", "wknd2");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("expire_chk", "expireChk");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("wknd1", "wknd1");
		this.hashFields.put("trf_grp_seq", "trfGrpSeq");
		this.hashFields.put("free_time", "freeTime");
		this.hashFields.put("covrg", "covrg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xcldSatFlg
	 */
	public String getXcldSatFlg() {
		return this.xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @return xcldSunFlg
	 */
	public String getXcldSunFlg() {
		return this.xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgCmncTpCd
	 */
	public String getDmdtChgCmncTpCd() {
		return this.dmdtChgCmncTpCd;
	}
	
	/**
	 * Column Info
	 * @return orgDest
	 */
	public String getOrgDest() {
		return this.orgDest;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return overDay
	 */
	public String getOverDay() {
		return this.overDay;
	}
	
	/**
	 * Column Info
	 * @return cntr20ftRtAmt
	 */
	public String getCntr20ftRtAmt() {
		return this.cntr20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return cntr45ftRtAmt
	 */
	public String getCntr45ftRtAmt() {
		return this.cntr45ftRtAmt;
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
	 * @return dmdtBzcTrfGrpNm
	 */
	public String getDmdtBzcTrfGrpNm() {
		return this.dmdtBzcTrfGrpNm;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return cntr40ftRtAmt
	 */
	public String getCntr40ftRtAmt() {
		return this.cntr40ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return dmdtCgoTpCd
	 */
	public String getDmdtCgoTpCd() {
		return this.dmdtCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return cntrHcRtAmt
	 */
	public String getCntrHcRtAmt() {
		return this.cntrHcRtAmt;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpCd
	 */
	public String getDmdtCntrTpCd() {
		return this.dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return wknd2
	 */
	public String getWknd2() {
		return this.wknd2;
	}
	
	/**
	 * Column Info
	 * @return ftDys
	 */
	public String getFtDys() {
		return this.ftDys;
	}
	
	/**
	 * Column Info
	 * @return expireChk
	 */
	public String getExpireChk() {
		return this.expireChk;
	}
	
	/**
	 * Column Info
	 * @return xcldHolFlg
	 */
	public String getXcldHolFlg() {
		return this.xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @return wknd1
	 */
	public String getWknd1() {
		return this.wknd1;
	}
	
	/**
	 * Column Info
	 * @return trfGrpSeq
	 */
	public String getTrfGrpSeq() {
		return this.trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return freeTime
	 */
	public String getFreeTime() {
		return this.freeTime;
	}
	
	/**
	 * Column Info
	 * @return covrg
	 */
	public String getCovrg() {
		return this.covrg;
	}
	

	/**
	 * Column Info
	 * @param xcldSatFlg
	 */
	public void setXcldSatFlg(String xcldSatFlg) {
		this.xcldSatFlg = xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @param xcldSunFlg
	 */
	public void setXcldSunFlg(String xcldSunFlg) {
		this.xcldSunFlg = xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgCmncTpCd
	 */
	public void setDmdtChgCmncTpCd(String dmdtChgCmncTpCd) {
		this.dmdtChgCmncTpCd = dmdtChgCmncTpCd;
	}
	
	/**
	 * Column Info
	 * @param orgDest
	 */
	public void setOrgDest(String orgDest) {
		this.orgDest = orgDest;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param overDay
	 */
	public void setOverDay(String overDay) {
		this.overDay = overDay;
	}
	
	/**
	 * Column Info
	 * @param cntr20ftRtAmt
	 */
	public void setCntr20ftRtAmt(String cntr20ftRtAmt) {
		this.cntr20ftRtAmt = cntr20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param cntr45ftRtAmt
	 */
	public void setCntr45ftRtAmt(String cntr45ftRtAmt) {
		this.cntr45ftRtAmt = cntr45ftRtAmt;
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
	 * @param dmdtBzcTrfGrpNm
	 */
	public void setDmdtBzcTrfGrpNm(String dmdtBzcTrfGrpNm) {
		this.dmdtBzcTrfGrpNm = dmdtBzcTrfGrpNm;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param cntr40ftRtAmt
	 */
	public void setCntr40ftRtAmt(String cntr40ftRtAmt) {
		this.cntr40ftRtAmt = cntr40ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param dmdtCgoTpCd
	 */
	public void setDmdtCgoTpCd(String dmdtCgoTpCd) {
		this.dmdtCgoTpCd = dmdtCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param cntrHcRtAmt
	 */
	public void setCntrHcRtAmt(String cntrHcRtAmt) {
		this.cntrHcRtAmt = cntrHcRtAmt;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpCd
	 */
	public void setDmdtCntrTpCd(String dmdtCntrTpCd) {
		this.dmdtCntrTpCd = dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param wknd2
	 */
	public void setWknd2(String wknd2) {
		this.wknd2 = wknd2;
	}
	
	/**
	 * Column Info
	 * @param ftDys
	 */
	public void setFtDys(String ftDys) {
		this.ftDys = ftDys;
	}
	
	/**
	 * Column Info
	 * @param expireChk
	 */
	public void setExpireChk(String expireChk) {
		this.expireChk = expireChk;
	}
	
	/**
	 * Column Info
	 * @param xcldHolFlg
	 */
	public void setXcldHolFlg(String xcldHolFlg) {
		this.xcldHolFlg = xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @param wknd1
	 */
	public void setWknd1(String wknd1) {
		this.wknd1 = wknd1;
	}
	
	/**
	 * Column Info
	 * @param trfGrpSeq
	 */
	public void setTrfGrpSeq(String trfGrpSeq) {
		this.trfGrpSeq = trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param freeTime
	 */
	public void setFreeTime(String freeTime) {
		this.freeTime = freeTime;
	}
	
	/**
	 * Column Info
	 * @param covrg
	 */
	public void setCovrg(String covrg) {
		this.covrg = covrg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setXcldSatFlg(JSPUtil.getParameter(request, "xcld_sat_flg", ""));
		setXcldSunFlg(JSPUtil.getParameter(request, "xcld_sun_flg", ""));
		setDmdtChgCmncTpCd(JSPUtil.getParameter(request, "dmdt_chg_cmnc_tp_cd", ""));
		setOrgDest(JSPUtil.getParameter(request, "org_dest", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setOverDay(JSPUtil.getParameter(request, "over_day", ""));
		setCntr20ftRtAmt(JSPUtil.getParameter(request, "cntr_20ft_rt_amt", ""));
		setCntr45ftRtAmt(JSPUtil.getParameter(request, "cntr_45ft_rt_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDmdtBzcTrfGrpNm(JSPUtil.getParameter(request, "dmdt_bzc_trf_grp_nm", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntr40ftRtAmt(JSPUtil.getParameter(request, "cntr_40ft_rt_amt", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setDmdtCgoTpCd(JSPUtil.getParameter(request, "dmdt_cgo_tp_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setCntrHcRtAmt(JSPUtil.getParameter(request, "cntr_hc_rt_amt", ""));
		setDmdtCntrTpCd(JSPUtil.getParameter(request, "dmdt_cntr_tp_cd", ""));
		setWknd2(JSPUtil.getParameter(request, "wknd2", ""));
		setFtDys(JSPUtil.getParameter(request, "ft_dys", ""));
		setExpireChk(JSPUtil.getParameter(request, "expire_chk", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, "xcld_hol_flg", ""));
		setWknd1(JSPUtil.getParameter(request, "wknd1", ""));
		setTrfGrpSeq(JSPUtil.getParameter(request, "trf_grp_seq", ""));
		setFreeTime(JSPUtil.getParameter(request, "free_time", ""));
		setCovrg(JSPUtil.getParameter(request, "covrg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchContinentVO[]
	 */
	public SearchContinentVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchContinentVO[]
	 */
	public SearchContinentVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchContinentVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg", length));
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg", length));
			String[] dmdtChgCmncTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_cmnc_tp_cd", length));
			String[] orgDest = (JSPUtil.getParameter(request, prefix	+ "org_dest", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] overDay = (JSPUtil.getParameter(request, prefix	+ "over_day", length));
			String[] cntr20ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_20ft_rt_amt", length));
			String[] cntr45ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_45ft_rt_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dmdtBzcTrfGrpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_bzc_trf_grp_nm", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntr40ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_40ft_rt_amt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] dmdtCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cgo_tp_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] cntrHcRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_hc_rt_amt", length));
			String[] dmdtCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_cd", length));
			String[] wknd2 = (JSPUtil.getParameter(request, prefix	+ "wknd2", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] expireChk = (JSPUtil.getParameter(request, prefix	+ "expire_chk", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			String[] wknd1 = (JSPUtil.getParameter(request, prefix	+ "wknd1", length));
			String[] trfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "trf_grp_seq", length));
			String[] freeTime = (JSPUtil.getParameter(request, prefix	+ "free_time", length));
			String[] covrg = (JSPUtil.getParameter(request, prefix	+ "covrg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchContinentVO();
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (dmdtChgCmncTpCd[i] != null)
					model.setDmdtChgCmncTpCd(dmdtChgCmncTpCd[i]);
				if (orgDest[i] != null)
					model.setOrgDest(orgDest[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (overDay[i] != null)
					model.setOverDay(overDay[i]);
				if (cntr20ftRtAmt[i] != null)
					model.setCntr20ftRtAmt(cntr20ftRtAmt[i]);
				if (cntr45ftRtAmt[i] != null)
					model.setCntr45ftRtAmt(cntr45ftRtAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dmdtBzcTrfGrpNm[i] != null)
					model.setDmdtBzcTrfGrpNm(dmdtBzcTrfGrpNm[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntr40ftRtAmt[i] != null)
					model.setCntr40ftRtAmt(cntr40ftRtAmt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (dmdtCgoTpCd[i] != null)
					model.setDmdtCgoTpCd(dmdtCgoTpCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (cntrHcRtAmt[i] != null)
					model.setCntrHcRtAmt(cntrHcRtAmt[i]);
				if (dmdtCntrTpCd[i] != null)
					model.setDmdtCntrTpCd(dmdtCntrTpCd[i]);
				if (wknd2[i] != null)
					model.setWknd2(wknd2[i]);
				if (ftDys[i] != null)
					model.setFtDys(ftDys[i]);
				if (expireChk[i] != null)
					model.setExpireChk(expireChk[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				if (wknd1[i] != null)
					model.setWknd1(wknd1[i]);
				if (trfGrpSeq[i] != null)
					model.setTrfGrpSeq(trfGrpSeq[i]);
				if (freeTime[i] != null)
					model.setFreeTime(freeTime[i]);
				if (covrg[i] != null)
					model.setCovrg(covrg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchContinentVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchContinentVO[]
	 */
	public SearchContinentVO[] getSearchContinentVOs(){
		SearchContinentVO[] vos = (SearchContinentVO[])models.toArray(new SearchContinentVO[models.size()]);
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
		this.xcldSatFlg = this.xcldSatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSunFlg = this.xcldSunFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgCmncTpCd = this.dmdtChgCmncTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDest = this.orgDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDay = this.overDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20ftRtAmt = this.cntr20ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr45ftRtAmt = this.cntr45ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBzcTrfGrpNm = this.dmdtBzcTrfGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr40ftRtAmt = this.cntr40ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCgoTpCd = this.dmdtCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHcRtAmt = this.cntrHcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpCd = this.dmdtCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wknd2 = this.wknd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expireChk = this.expireChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wknd1 = this.wknd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfGrpSeq = this.trfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeTime = this.freeTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.covrg = this.covrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
