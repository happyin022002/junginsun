/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HolidayMgtVO.java
*@FileTitle : HolidayMgtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.12  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HolidayMgtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HolidayMgtVO> models = new ArrayList<HolidayMgtVO>();
	
	/* Column Info */
	private String wkndTpCd = null;
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String holYr = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String cvrgRgnCd = null;
	/* Column Info */
	private String cntNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String holWkndTp = null;
	/* Column Info */
	private String cvrgCntCd = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String holDt = null;
	/* Column Info */
	private String rgnNm = null;
	/* Column Info */
	private String holDtIn = null;
	/* Column Info */
	private String holDesc = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String steNm = null;
	/* Column Info */
	private String holDays = null;
	/* Column Info */
	private String retry = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String cvrgLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HolidayMgtVO() {}

	public HolidayMgtVO(String ibflag, String pagerows, String holYr, String cntCd, String cntNm, String cvrgCntCd, String rgnCd, String rgnNm, String cvrgRgnCd, String steCd, String steNm, String locCd, String cvrgLocCd, String holDtIn, String holDt, String holDesc, String creUsrId, String creDt, String creOfcCd, String updUsrNm, String updDt, String updOfcCd, String chgCd, String wkndTpCd, String retry, String svrId, String holWkndTp, String holDays) {
		this.wkndTpCd = wkndTpCd;
		this.rgnCd = rgnCd;
		this.holYr = holYr;
		this.creDt = creDt;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.locCd = locCd;
		this.cvrgRgnCd = cvrgRgnCd;
		this.cntNm = cntNm;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.cntCd = cntCd;
		this.holWkndTp = holWkndTp;
		this.cvrgCntCd = cvrgCntCd;
		this.updOfcCd = updOfcCd;
		this.updDt = updDt;
		this.holDt = holDt;
		this.rgnNm = rgnNm;
		this.holDtIn = holDtIn;
		this.holDesc = holDesc;
		this.creUsrId = creUsrId;
		this.steNm = steNm;
		this.holDays = holDays;
		this.retry = retry;
		this.steCd = steCd;
		this.updUsrNm = updUsrNm;
		this.cvrgLocCd = cvrgLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("wknd_tp_cd", getWkndTpCd());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("hol_yr", getHolYr());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cvrg_rgn_cd", getCvrgRgnCd());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("hol_wknd_tp", getHolWkndTp());
		this.hashColumns.put("cvrg_cnt_cd", getCvrgCntCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("hol_dt", getHolDt());
		this.hashColumns.put("rgn_nm", getRgnNm());
		this.hashColumns.put("hol_dt_in", getHolDtIn());
		this.hashColumns.put("hol_desc", getHolDesc());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ste_nm", getSteNm());
		this.hashColumns.put("hol_days", getHolDays());
		this.hashColumns.put("retry", getRetry());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("cvrg_loc_cd", getCvrgLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("wknd_tp_cd", "wkndTpCd");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("hol_yr", "holYr");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cvrg_rgn_cd", "cvrgRgnCd");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("hol_wknd_tp", "holWkndTp");
		this.hashFields.put("cvrg_cnt_cd", "cvrgCntCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("hol_dt", "holDt");
		this.hashFields.put("rgn_nm", "rgnNm");
		this.hashFields.put("hol_dt_in", "holDtIn");
		this.hashFields.put("hol_desc", "holDesc");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ste_nm", "steNm");
		this.hashFields.put("hol_days", "holDays");
		this.hashFields.put("retry", "retry");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("cvrg_loc_cd", "cvrgLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return wkndTpCd
	 */
	public String getWkndTpCd() {
		return this.wkndTpCd;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
	}
	
	/**
	 * Column Info
	 * @return holYr
	 */
	public String getHolYr() {
		return this.holYr;
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
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return cvrgRgnCd
	 */
	public String getCvrgRgnCd() {
		return this.cvrgRgnCd;
	}
	
	/**
	 * Column Info
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return holWkndTp
	 */
	public String getHolWkndTp() {
		return this.holWkndTp;
	}
	
	/**
	 * Column Info
	 * @return cvrgCntCd
	 */
	public String getCvrgCntCd() {
		return this.cvrgCntCd;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return holDt
	 */
	public String getHolDt() {
		return this.holDt;
	}
	
	/**
	 * Column Info
	 * @return rgnNm
	 */
	public String getRgnNm() {
		return this.rgnNm;
	}
	
	/**
	 * Column Info
	 * @return holDtIn
	 */
	public String getHolDtIn() {
		return this.holDtIn;
	}
	
	/**
	 * Column Info
	 * @return holDesc
	 */
	public String getHolDesc() {
		return this.holDesc;
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
	 * @return steNm
	 */
	public String getSteNm() {
		return this.steNm;
	}
	
	/**
	 * Column Info
	 * @return holDays
	 */
	public String getHolDays() {
		return this.holDays;
	}
	
	/**
	 * Column Info
	 * @return retry
	 */
	public String getRetry() {
		return this.retry;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
	}
	
	/**
	 * Column Info
	 * @return cvrgLocCd
	 */
	public String getCvrgLocCd() {
		return this.cvrgLocCd;
	}
	

	/**
	 * Column Info
	 * @param wkndTpCd
	 */
	public void setWkndTpCd(String wkndTpCd) {
		this.wkndTpCd = wkndTpCd;
	}
	
	/**
	 * Column Info
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param holYr
	 */
	public void setHolYr(String holYr) {
		this.holYr = holYr;
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
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param cvrgRgnCd
	 */
	public void setCvrgRgnCd(String cvrgRgnCd) {
		this.cvrgRgnCd = cvrgRgnCd;
	}
	
	/**
	 * Column Info
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param holWkndTp
	 */
	public void setHolWkndTp(String holWkndTp) {
		this.holWkndTp = holWkndTp;
	}
	
	/**
	 * Column Info
	 * @param cvrgCntCd
	 */
	public void setCvrgCntCd(String cvrgCntCd) {
		this.cvrgCntCd = cvrgCntCd;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param holDt
	 */
	public void setHolDt(String holDt) {
		this.holDt = holDt;
	}
	
	/**
	 * Column Info
	 * @param rgnNm
	 */
	public void setRgnNm(String rgnNm) {
		this.rgnNm = rgnNm;
	}
	
	/**
	 * Column Info
	 * @param holDtIn
	 */
	public void setHolDtIn(String holDtIn) {
		this.holDtIn = holDtIn;
	}
	
	/**
	 * Column Info
	 * @param holDesc
	 */
	public void setHolDesc(String holDesc) {
		this.holDesc = holDesc;
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
	 * @param steNm
	 */
	public void setSteNm(String steNm) {
		this.steNm = steNm;
	}
	
	/**
	 * Column Info
	 * @param holDays
	 */
	public void setHolDays(String holDays) {
		this.holDays = holDays;
	}
	
	/**
	 * Column Info
	 * @param retry
	 */
	public void setRetry(String retry) {
		this.retry = retry;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * Column Info
	 * @param cvrgLocCd
	 */
	public void setCvrgLocCd(String cvrgLocCd) {
		this.cvrgLocCd = cvrgLocCd;
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
		setWkndTpCd(JSPUtil.getParameter(request, prefix + "wknd_tp_cd", ""));
		setRgnCd(JSPUtil.getParameter(request, prefix + "rgn_cd", ""));
		setHolYr(JSPUtil.getParameter(request, prefix + "hol_yr", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setCvrgRgnCd(JSPUtil.getParameter(request, prefix + "cvrg_rgn_cd", ""));
		setCntNm(JSPUtil.getParameter(request, prefix + "cnt_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setHolWkndTp(JSPUtil.getParameter(request, prefix + "hol_wknd_tp", ""));
		setCvrgCntCd(JSPUtil.getParameter(request, prefix + "cvrg_cnt_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setHolDt(JSPUtil.getParameter(request, prefix + "hol_dt", ""));
		setRgnNm(JSPUtil.getParameter(request, prefix + "rgn_nm", ""));
		setHolDtIn(JSPUtil.getParameter(request, prefix + "hol_dt_in", ""));
		setHolDesc(JSPUtil.getParameter(request, prefix + "hol_desc", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSteNm(JSPUtil.getParameter(request, prefix + "ste_nm", ""));
		setHolDays(JSPUtil.getParameter(request, prefix + "hol_days", ""));
		setRetry(JSPUtil.getParameter(request, prefix + "retry", ""));
		setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
		setCvrgLocCd(JSPUtil.getParameter(request, prefix + "cvrg_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HolidayMgtVO[]
	 */
	public HolidayMgtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HolidayMgtVO[]
	 */
	public HolidayMgtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HolidayMgtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] wkndTpCd = (JSPUtil.getParameter(request, prefix	+ "wknd_tp_cd", length));
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] holYr = (JSPUtil.getParameter(request, prefix	+ "hol_yr", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] cvrgRgnCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_rgn_cd", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] holWkndTp = (JSPUtil.getParameter(request, prefix	+ "hol_wknd_tp", length));
			String[] cvrgCntCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_cnt_cd", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] holDt = (JSPUtil.getParameter(request, prefix	+ "hol_dt", length));
			String[] rgnNm = (JSPUtil.getParameter(request, prefix	+ "rgn_nm", length));
			String[] holDtIn = (JSPUtil.getParameter(request, prefix	+ "hol_dt_in", length));
			String[] holDesc = (JSPUtil.getParameter(request, prefix	+ "hol_desc", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] steNm = (JSPUtil.getParameter(request, prefix	+ "ste_nm", length));
			String[] holDays = (JSPUtil.getParameter(request, prefix	+ "hol_days", length));
			String[] retry = (JSPUtil.getParameter(request, prefix	+ "retry", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] cvrgLocCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new HolidayMgtVO();
				if (wkndTpCd[i] != null)
					model.setWkndTpCd(wkndTpCd[i]);
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (holYr[i] != null)
					model.setHolYr(holYr[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (cvrgRgnCd[i] != null)
					model.setCvrgRgnCd(cvrgRgnCd[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (holWkndTp[i] != null)
					model.setHolWkndTp(holWkndTp[i]);
				if (cvrgCntCd[i] != null)
					model.setCvrgCntCd(cvrgCntCd[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (holDt[i] != null)
					model.setHolDt(holDt[i]);
				if (rgnNm[i] != null)
					model.setRgnNm(rgnNm[i]);
				if (holDtIn[i] != null)
					model.setHolDtIn(holDtIn[i]);
				if (holDesc[i] != null)
					model.setHolDesc(holDesc[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (steNm[i] != null)
					model.setSteNm(steNm[i]);
				if (holDays[i] != null)
					model.setHolDays(holDays[i]);
				if (retry[i] != null)
					model.setRetry(retry[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (cvrgLocCd[i] != null)
					model.setCvrgLocCd(cvrgLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHolidayMgtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HolidayMgtVO[]
	 */
	public HolidayMgtVO[] getHolidayMgtVOs(){
		HolidayMgtVO[] vos = (HolidayMgtVO[])models.toArray(new HolidayMgtVO[models.size()]);
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
		this.wkndTpCd = this.wkndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holYr = this.holYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgRgnCd = this.cvrgRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holWkndTp = this.holWkndTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgCntCd = this.cvrgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holDt = this.holDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnNm = this.rgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holDtIn = this.holDtIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holDesc = this.holDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steNm = this.steNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holDays = this.holDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.retry = this.retry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgLocCd = this.cvrgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
