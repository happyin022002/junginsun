/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpcBkgCmpbVO.java
*@FileTitle : SpcBkgCmpbVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.13
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.02.13 진마리아 
* 1.0 Creation
* 2013.02.13 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가 
=========================================================*/

package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpcBkgCmpbVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpcBkgCmpbVO> models = new ArrayList<SpcBkgCmpbVO>();
	
	/* Column Info */
	private String strdCmpb = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String usaBkgModCd = null;
	/* Column Info */
	private String laneAvgQty = null;
	/* Column Info */
	private String strdAvgQty = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String laneGrev = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String verSeq = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String unit = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgDelCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String laneCmpb = null;
	/* Column Info */
	private String strdGrev = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String costYrwk = null;
	/* Column Info */
	private String rfaNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpcBkgCmpbVO() {}

	public SpcBkgCmpbVO(String ibflag, String pagerows, String costYrwk, String verSeq, String custLglEngNm, String scNo, String trdCd, String subTrdCd, String rlaneCd, String slsRgnOfcCd, String unit, String custCntCd, String custSeq, String slsRhqCd, String usaBkgModCd, String bkgPolCd, String bkgPodCd, String bkgDelCd, String strdCmpb, String laneCmpb, String strdGrev, String laneGrev, String strdAvgQty, String laneAvgQty, String rfaNo) {
		this.strdCmpb = strdCmpb;
		this.bkgPolCd = bkgPolCd;
		this.usaBkgModCd = usaBkgModCd;
		this.laneAvgQty = laneAvgQty;
		this.strdAvgQty = strdAvgQty;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.laneGrev = laneGrev;
		this.custSeq = custSeq;
		this.slsRhqCd = slsRhqCd;
		this.pagerows = pagerows;
		this.verSeq = verSeq;
		this.custLglEngNm = custLglEngNm;
		this.unit = unit;
		this.bkgPodCd = bkgPodCd;
		this.ibflag = ibflag;
		this.bkgDelCd = bkgDelCd;
		this.scNo = scNo;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.laneCmpb = laneCmpb;
		this.strdGrev = strdGrev;
		this.subTrdCd = subTrdCd;
		this.custCntCd = custCntCd;
		this.costYrwk = costYrwk;
		this.rfaNo = rfaNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("strd_cmpb", getStrdCmpb());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("usa_bkg_mod_cd", getUsaBkgModCd());
		this.hashColumns.put("lane_avg_qty", getLaneAvgQty());
		this.hashColumns.put("strd_avg_qty", getStrdAvgQty());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("lane_grev", getLaneGrev());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("unit", getUnit());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_del_cd", getBkgDelCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("lane_cmpb", getLaneCmpb());
		this.hashColumns.put("strd_grev", getStrdGrev());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cost_yrwk", getCostYrwk());
		this.hashColumns.put("rfa_no", getRfaNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("strd_cmpb", "strdCmpb");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("usa_bkg_mod_cd", "usaBkgModCd");
		this.hashFields.put("lane_avg_qty", "laneAvgQty");
		this.hashFields.put("strd_avg_qty", "strdAvgQty");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("lane_grev", "laneGrev");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("unit", "unit");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_del_cd", "bkgDelCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("lane_cmpb", "laneCmpb");
		this.hashFields.put("strd_grev", "strdGrev");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cost_yrwk", "costYrwk");
		this.hashFields.put("rfa_no", "rfaNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return strdCmpb
	 */
	public String getStrdCmpb() {
		return this.strdCmpb;
	}
	
	/**
	 * Column Info
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @return usaBkgModCd
	 */
	public String getUsaBkgModCd() {
		return this.usaBkgModCd;
	}
	
	/**
	 * Column Info
	 * @return laneAvgQty
	 */
	public String getLaneAvgQty() {
		return this.laneAvgQty;
	}
	
	/**
	 * Column Info
	 * @return strdAvgQty
	 */
	public String getStrdAvgQty() {
		return this.strdAvgQty;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return laneGrev
	 */
	public String getLaneGrev() {
		return this.laneGrev;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
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
	 * @return verSeq
	 */
	public String getVerSeq() {
		return this.verSeq;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return unit
	 */
	public String getUnit() {
		return this.unit;
	}
	
	/**
	 * Column Info
	 * @return bkgPodCd
	 */
	public String getBkgPodCd() {
		return this.bkgPodCd;
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
	 * @return bkgDelCd
	 */
	public String getBkgDelCd() {
		return this.bkgDelCd;
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
	 * @return slsRgnOfcCd
	 */
	public String getSlsRgnOfcCd() {
		return this.slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return laneCmpb
	 */
	public String getLaneCmpb() {
		return this.laneCmpb;
	}
	
	/**
	 * Column Info
	 * @return strdGrev
	 */
	public String getStrdGrev() {
		return this.strdGrev;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return costYrwk
	 */
	public String getCostYrwk() {
		return this.costYrwk;
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
	 * @param strdCmpb
	 */
	public void setStrdCmpb(String strdCmpb) {
		this.strdCmpb = strdCmpb;
	}
	
	/**
	 * Column Info
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @param usaBkgModCd
	 */
	public void setUsaBkgModCd(String usaBkgModCd) {
		this.usaBkgModCd = usaBkgModCd;
	}
	
	/**
	 * Column Info
	 * @param laneAvgQty
	 */
	public void setLaneAvgQty(String laneAvgQty) {
		this.laneAvgQty = laneAvgQty;
	}
	
	/**
	 * Column Info
	 * @param strdAvgQty
	 */
	public void setStrdAvgQty(String strdAvgQty) {
		this.strdAvgQty = strdAvgQty;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param laneGrev
	 */
	public void setLaneGrev(String laneGrev) {
		this.laneGrev = laneGrev;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
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
	 * @param verSeq
	 */
	public void setVerSeq(String verSeq) {
		this.verSeq = verSeq;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	/**
	 * Column Info
	 * @param bkgPodCd
	 */
	public void setBkgPodCd(String bkgPodCd) {
		this.bkgPodCd = bkgPodCd;
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
	 * @param bkgDelCd
	 */
	public void setBkgDelCd(String bkgDelCd) {
		this.bkgDelCd = bkgDelCd;
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
	 * @param slsRgnOfcCd
	 */
	public void setSlsRgnOfcCd(String slsRgnOfcCd) {
		this.slsRgnOfcCd = slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param laneCmpb
	 */
	public void setLaneCmpb(String laneCmpb) {
		this.laneCmpb = laneCmpb;
	}
	
	/**
	 * Column Info
	 * @param strdGrev
	 */
	public void setStrdGrev(String strdGrev) {
		this.strdGrev = strdGrev;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param costYrwk
	 */
	public void setCostYrwk(String costYrwk) {
		this.costYrwk = costYrwk;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
		setStrdCmpb(JSPUtil.getParameter(request, prefix + "strd_cmpb", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setUsaBkgModCd(JSPUtil.getParameter(request, prefix + "usa_bkg_mod_cd", ""));
		setLaneAvgQty(JSPUtil.getParameter(request, prefix + "lane_avg_qty", ""));
		setStrdAvgQty(JSPUtil.getParameter(request, prefix + "strd_avg_qty", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setLaneGrev(JSPUtil.getParameter(request, prefix + "lane_grev", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVerSeq(JSPUtil.getParameter(request, prefix + "ver_seq", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setUnit(JSPUtil.getParameter(request, prefix + "unit", ""));
		setBkgPodCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgDelCd(JSPUtil.getParameter(request, prefix + "bkg_del_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "sls_rgn_ofc_cd", ""));
		setLaneCmpb(JSPUtil.getParameter(request, prefix + "lane_cmpb", ""));
		setStrdGrev(JSPUtil.getParameter(request, prefix + "strd_grev", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCostYrwk(JSPUtil.getParameter(request, prefix + "cost_yrwk", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpcBkgCmpbVO[]
	 */
	public SpcBkgCmpbVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpcBkgCmpbVO[]
	 */
	public SpcBkgCmpbVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpcBkgCmpbVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] strdCmpb = (JSPUtil.getParameter(request, prefix	+ "strd_cmpb", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] usaBkgModCd = (JSPUtil.getParameter(request, prefix	+ "usa_bkg_mod_cd", length));
			String[] laneAvgQty = (JSPUtil.getParameter(request, prefix	+ "lane_avg_qty", length));
			String[] strdAvgQty = (JSPUtil.getParameter(request, prefix	+ "strd_avg_qty", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] laneGrev = (JSPUtil.getParameter(request, prefix	+ "lane_grev", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] unit = (JSPUtil.getParameter(request, prefix	+ "unit", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgDelCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			String[] laneCmpb = (JSPUtil.getParameter(request, prefix	+ "lane_cmpb", length));
			String[] strdGrev = (JSPUtil.getParameter(request, prefix	+ "strd_grev", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] costYrwk = (JSPUtil.getParameter(request, prefix	+ "cost_yrwk", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpcBkgCmpbVO();
				if (strdCmpb[i] != null)
					model.setStrdCmpb(strdCmpb[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (usaBkgModCd[i] != null)
					model.setUsaBkgModCd(usaBkgModCd[i]);
				if (laneAvgQty[i] != null)
					model.setLaneAvgQty(laneAvgQty[i]);
				if (strdAvgQty[i] != null)
					model.setStrdAvgQty(strdAvgQty[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (laneGrev[i] != null)
					model.setLaneGrev(laneGrev[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (verSeq[i] != null)
					model.setVerSeq(verSeq[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (unit[i] != null)
					model.setUnit(unit[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgDelCd[i] != null)
					model.setBkgDelCd(bkgDelCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (laneCmpb[i] != null)
					model.setLaneCmpb(laneCmpb[i]);
				if (strdGrev[i] != null)
					model.setStrdGrev(strdGrev[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (costYrwk[i] != null)
					model.setCostYrwk(costYrwk[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpcBkgCmpbVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpcBkgCmpbVO[]
	 */
	public SpcBkgCmpbVO[] getSpcBkgCmpbVOs(){
		SpcBkgCmpbVO[] vos = (SpcBkgCmpbVO[])models.toArray(new SpcBkgCmpbVO[models.size()]);
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
		this.strdCmpb = this.strdCmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaBkgModCd = this.usaBkgModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneAvgQty = this.laneAvgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strdAvgQty = this.strdAvgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrev = this.laneGrev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit = this.unit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCd = this.bkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCmpb = this.laneCmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strdGrev = this.strdGrev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrwk = this.costYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
