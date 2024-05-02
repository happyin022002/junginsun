/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CstSkdSimDtlCalcInfoVO.java
*@FileTitle : CstSkdSimDtlCalcInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.12
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.02.12 정진우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CstSkdSimDtlCalcInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstSkdSimDtlCalcInfoVO> models = new ArrayList<CstSkdSimDtlCalcInfoVO>();
	
	/* Column Info */
	private String mnvrOutHrs = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String tmD2 = null;
	/* Column Info */
	private String stndDist = null;
	/* Column Info */
	private String bnkUnitAmt = null;
	/* Column Info */
	private String ttlChgAmt = null;
	/* Column Info */
	private String tmlProdQty = null;
	/* Column Info */
	private String portBufHrs = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String tmD4 = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crnKnt = null;
	/* Column Info */
	private String fmLocCd = null;
	/* Column Info */
	private String tp40Qty = null;
	/* Column Info */
	private String bnkUnitQty = null;
	/* Column Info */
	private String spd = null;
	/* Column Info */
	private String timeDiff = null;
	/* Column Info */
	private String tp20Qty = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String toLocCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String tsD2 = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String tsD4 = null;
	/* Column Info */
	private String mnvrInHrs = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String clptIndSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CstSkdSimDtlCalcInfoVO() {}

	public CstSkdSimDtlCalcInfoVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String clptIndSeq, String vslSlanCd, String ydCd, String vpsEtaDt, String locCd, String bseYr, String bseQtrCd, String fmLocCd, String toLocCd, String spd, String bnkUnitQty, String bnkUnitAmt, String ttlChgAmt, String stndDist, String tsD2, String tsD4, String tmD2, String tmD4, String tp20Qty, String tp40Qty, String timeDiff, String mnvrInHrs, String mnvrOutHrs, String crnKnt, String tmlProdQty, String portBufHrs) {
		this.mnvrOutHrs = mnvrOutHrs;
		this.vslCd = vslCd;
		this.tmD2 = tmD2;
		this.stndDist = stndDist;
		this.bnkUnitAmt = bnkUnitAmt;
		this.ttlChgAmt = ttlChgAmt;
		this.tmlProdQty = tmlProdQty;
		this.portBufHrs = portBufHrs;
		this.vslSlanCd = vslSlanCd;
		this.tmD4 = tmD4;
		this.vpsEtaDt = vpsEtaDt;
		this.pagerows = pagerows;
		this.bseQtrCd = bseQtrCd;
		this.vpsPortCd = vpsPortCd;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.crnKnt = crnKnt;
		this.fmLocCd = fmLocCd;
		this.tp40Qty = tp40Qty;
		this.bnkUnitQty = bnkUnitQty;
		this.spd = spd;
		this.timeDiff = timeDiff;
		this.tp20Qty = tp20Qty;
		this.skdVoyNo = skdVoyNo;
		this.toLocCd = toLocCd;
		this.bseYr = bseYr;
		this.tsD2 = tsD2;
		this.skdDirCd = skdDirCd;
		this.tsD4 = tsD4;
		this.mnvrInHrs = mnvrInHrs;
		this.ydCd = ydCd;
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnvr_out_hrs", getMnvrOutHrs());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("tm_d2", getTmD2());
		this.hashColumns.put("stnd_dist", getStndDist());
		this.hashColumns.put("bnk_unit_amt", getBnkUnitAmt());
		this.hashColumns.put("ttl_chg_amt", getTtlChgAmt());
		this.hashColumns.put("tml_prod_qty", getTmlProdQty());
		this.hashColumns.put("port_buf_hrs", getPortBufHrs());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("tm_d4", getTmD4());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("crn_knt", getCrnKnt());
		this.hashColumns.put("fm_loc_cd", getFmLocCd());
		this.hashColumns.put("tp_40_qty", getTp40Qty());
		this.hashColumns.put("bnk_unit_qty", getBnkUnitQty());
		this.hashColumns.put("spd", getSpd());
		this.hashColumns.put("time_diff", getTimeDiff());
		this.hashColumns.put("tp_20_qty", getTp20Qty());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("to_loc_cd", getToLocCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("ts_d2", getTsD2());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("ts_d4", getTsD4());
		this.hashColumns.put("mnvr_in_hrs", getMnvrInHrs());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnvr_out_hrs", "mnvrOutHrs");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("tm_d2", "tmD2");
		this.hashFields.put("stnd_dist", "stndDist");
		this.hashFields.put("bnk_unit_amt", "bnkUnitAmt");
		this.hashFields.put("ttl_chg_amt", "ttlChgAmt");
		this.hashFields.put("tml_prod_qty", "tmlProdQty");
		this.hashFields.put("port_buf_hrs", "portBufHrs");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("tm_d4", "tmD4");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("crn_knt", "crnKnt");
		this.hashFields.put("fm_loc_cd", "fmLocCd");
		this.hashFields.put("tp_40_qty", "tp40Qty");
		this.hashFields.put("bnk_unit_qty", "bnkUnitQty");
		this.hashFields.put("spd", "spd");
		this.hashFields.put("time_diff", "timeDiff");
		this.hashFields.put("tp_20_qty", "tp20Qty");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("to_loc_cd", "toLocCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("ts_d2", "tsD2");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ts_d4", "tsD4");
		this.hashFields.put("mnvr_in_hrs", "mnvrInHrs");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnvrOutHrs
	 */
	public String getMnvrOutHrs() {
		return this.mnvrOutHrs;
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
	 * @return tmD2
	 */
	public String getTmD2() {
		return this.tmD2;
	}
	
	/**
	 * Column Info
	 * @return stndDist
	 */
	public String getStndDist() {
		return this.stndDist;
	}
	
	/**
	 * Column Info
	 * @return bnkUnitAmt
	 */
	public String getBnkUnitAmt() {
		return this.bnkUnitAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlChgAmt
	 */
	public String getTtlChgAmt() {
		return this.ttlChgAmt;
	}
	
	/**
	 * Column Info
	 * @return tmlProdQty
	 */
	public String getTmlProdQty() {
		return this.tmlProdQty;
	}
	
	/**
	 * Column Info
	 * @return portBufHrs
	 */
	public String getPortBufHrs() {
		return this.portBufHrs;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return tmD4
	 */
	public String getTmD4() {
		return this.tmD4;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return crnKnt
	 */
	public String getCrnKnt() {
		return this.crnKnt;
	}
	
	/**
	 * Column Info
	 * @return fmLocCd
	 */
	public String getFmLocCd() {
		return this.fmLocCd;
	}
	
	/**
	 * Column Info
	 * @return tp40Qty
	 */
	public String getTp40Qty() {
		return this.tp40Qty;
	}
	
	/**
	 * Column Info
	 * @return bnkUnitQty
	 */
	public String getBnkUnitQty() {
		return this.bnkUnitQty;
	}
	
	/**
	 * Column Info
	 * @return spd
	 */
	public String getSpd() {
		return this.spd;
	}
	
	/**
	 * Column Info
	 * @return timeDiff
	 */
	public String getTimeDiff() {
		return this.timeDiff;
	}
	
	/**
	 * Column Info
	 * @return tp20Qty
	 */
	public String getTp20Qty() {
		return this.tp20Qty;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return toLocCd
	 */
	public String getToLocCd() {
		return this.toLocCd;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return tsD2
	 */
	public String getTsD2() {
		return this.tsD2;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return tsD4
	 */
	public String getTsD4() {
		return this.tsD4;
	}
	
	/**
	 * Column Info
	 * @return mnvrInHrs
	 */
	public String getMnvrInHrs() {
		return this.mnvrInHrs;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	

	/**
	 * Column Info
	 * @param mnvrOutHrs
	 */
	public void setMnvrOutHrs(String mnvrOutHrs) {
		this.mnvrOutHrs = mnvrOutHrs;
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
	 * @param tmD2
	 */
	public void setTmD2(String tmD2) {
		this.tmD2 = tmD2;
	}
	
	/**
	 * Column Info
	 * @param stndDist
	 */
	public void setStndDist(String stndDist) {
		this.stndDist = stndDist;
	}
	
	/**
	 * Column Info
	 * @param bnkUnitAmt
	 */
	public void setBnkUnitAmt(String bnkUnitAmt) {
		this.bnkUnitAmt = bnkUnitAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlChgAmt
	 */
	public void setTtlChgAmt(String ttlChgAmt) {
		this.ttlChgAmt = ttlChgAmt;
	}
	
	/**
	 * Column Info
	 * @param tmlProdQty
	 */
	public void setTmlProdQty(String tmlProdQty) {
		this.tmlProdQty = tmlProdQty;
	}
	
	/**
	 * Column Info
	 * @param portBufHrs
	 */
	public void setPortBufHrs(String portBufHrs) {
		this.portBufHrs = portBufHrs;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param tmD4
	 */
	public void setTmD4(String tmD4) {
		this.tmD4 = tmD4;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param crnKnt
	 */
	public void setCrnKnt(String crnKnt) {
		this.crnKnt = crnKnt;
	}
	
	/**
	 * Column Info
	 * @param fmLocCd
	 */
	public void setFmLocCd(String fmLocCd) {
		this.fmLocCd = fmLocCd;
	}
	
	/**
	 * Column Info
	 * @param tp40Qty
	 */
	public void setTp40Qty(String tp40Qty) {
		this.tp40Qty = tp40Qty;
	}
	
	/**
	 * Column Info
	 * @param bnkUnitQty
	 */
	public void setBnkUnitQty(String bnkUnitQty) {
		this.bnkUnitQty = bnkUnitQty;
	}
	
	/**
	 * Column Info
	 * @param spd
	 */
	public void setSpd(String spd) {
		this.spd = spd;
	}
	
	/**
	 * Column Info
	 * @param timeDiff
	 */
	public void setTimeDiff(String timeDiff) {
		this.timeDiff = timeDiff;
	}
	
	/**
	 * Column Info
	 * @param tp20Qty
	 */
	public void setTp20Qty(String tp20Qty) {
		this.tp20Qty = tp20Qty;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param toLocCd
	 */
	public void setToLocCd(String toLocCd) {
		this.toLocCd = toLocCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param tsD2
	 */
	public void setTsD2(String tsD2) {
		this.tsD2 = tsD2;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param tsD4
	 */
	public void setTsD4(String tsD4) {
		this.tsD4 = tsD4;
	}
	
	/**
	 * Column Info
	 * @param mnvrInHrs
	 */
	public void setMnvrInHrs(String mnvrInHrs) {
		this.mnvrInHrs = mnvrInHrs;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMnvrOutHrs(JSPUtil.getParameter(request, "mnvr_out_hrs", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setTmD2(JSPUtil.getParameter(request, "tm_d2", ""));
		setStndDist(JSPUtil.getParameter(request, "stnd_dist", ""));
		setBnkUnitAmt(JSPUtil.getParameter(request, "bnk_unit_amt", ""));
		setTtlChgAmt(JSPUtil.getParameter(request, "ttl_chg_amt", ""));
		setTmlProdQty(JSPUtil.getParameter(request, "tml_prod_qty", ""));
		setPortBufHrs(JSPUtil.getParameter(request, "port_buf_hrs", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setTmD4(JSPUtil.getParameter(request, "tm_d4", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBseQtrCd(JSPUtil.getParameter(request, "bse_qtr_cd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCrnKnt(JSPUtil.getParameter(request, "crn_knt", ""));
		setFmLocCd(JSPUtil.getParameter(request, "fm_loc_cd", ""));
		setTp40Qty(JSPUtil.getParameter(request, "tp_40_qty", ""));
		setBnkUnitQty(JSPUtil.getParameter(request, "bnk_unit_qty", ""));
		setSpd(JSPUtil.getParameter(request, "spd", ""));
		setTimeDiff(JSPUtil.getParameter(request, "time_diff", ""));
		setTp20Qty(JSPUtil.getParameter(request, "tp_20_qty", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setToLocCd(JSPUtil.getParameter(request, "to_loc_cd", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setTsD2(JSPUtil.getParameter(request, "ts_d2", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setTsD4(JSPUtil.getParameter(request, "ts_d4", ""));
		setMnvrInHrs(JSPUtil.getParameter(request, "mnvr_in_hrs", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstSkdSimDtlCalcInfoVO[]
	 */
	public CstSkdSimDtlCalcInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstSkdSimDtlCalcInfoVO[]
	 */
	public CstSkdSimDtlCalcInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstSkdSimDtlCalcInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnvrOutHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_out_hrs", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] tmD2 = (JSPUtil.getParameter(request, prefix	+ "tm_d2", length));
			String[] stndDist = (JSPUtil.getParameter(request, prefix	+ "stnd_dist", length));
			String[] bnkUnitAmt = (JSPUtil.getParameter(request, prefix	+ "bnk_unit_amt", length));
			String[] ttlChgAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_chg_amt", length));
			String[] tmlProdQty = (JSPUtil.getParameter(request, prefix	+ "tml_prod_qty", length));
			String[] portBufHrs = (JSPUtil.getParameter(request, prefix	+ "port_buf_hrs", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] tmD4 = (JSPUtil.getParameter(request, prefix	+ "tm_d4", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crnKnt = (JSPUtil.getParameter(request, prefix	+ "crn_knt", length));
			String[] fmLocCd = (JSPUtil.getParameter(request, prefix	+ "fm_loc_cd", length));
			String[] tp40Qty = (JSPUtil.getParameter(request, prefix	+ "tp_40_qty", length));
			String[] bnkUnitQty = (JSPUtil.getParameter(request, prefix	+ "bnk_unit_qty", length));
			String[] spd = (JSPUtil.getParameter(request, prefix	+ "spd", length));
			String[] timeDiff = (JSPUtil.getParameter(request, prefix	+ "time_diff", length));
			String[] tp20Qty = (JSPUtil.getParameter(request, prefix	+ "tp_20_qty", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] toLocCd = (JSPUtil.getParameter(request, prefix	+ "to_loc_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] tsD2 = (JSPUtil.getParameter(request, prefix	+ "ts_d2", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] tsD4 = (JSPUtil.getParameter(request, prefix	+ "ts_d4", length));
			String[] mnvrInHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_in_hrs", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstSkdSimDtlCalcInfoVO();
				if (mnvrOutHrs[i] != null)
					model.setMnvrOutHrs(mnvrOutHrs[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (tmD2[i] != null)
					model.setTmD2(tmD2[i]);
				if (stndDist[i] != null)
					model.setStndDist(stndDist[i]);
				if (bnkUnitAmt[i] != null)
					model.setBnkUnitAmt(bnkUnitAmt[i]);
				if (ttlChgAmt[i] != null)
					model.setTtlChgAmt(ttlChgAmt[i]);
				if (tmlProdQty[i] != null)
					model.setTmlProdQty(tmlProdQty[i]);
				if (portBufHrs[i] != null)
					model.setPortBufHrs(portBufHrs[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (tmD4[i] != null)
					model.setTmD4(tmD4[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crnKnt[i] != null)
					model.setCrnKnt(crnKnt[i]);
				if (fmLocCd[i] != null)
					model.setFmLocCd(fmLocCd[i]);
				if (tp40Qty[i] != null)
					model.setTp40Qty(tp40Qty[i]);
				if (bnkUnitQty[i] != null)
					model.setBnkUnitQty(bnkUnitQty[i]);
				if (spd[i] != null)
					model.setSpd(spd[i]);
				if (timeDiff[i] != null)
					model.setTimeDiff(timeDiff[i]);
				if (tp20Qty[i] != null)
					model.setTp20Qty(tp20Qty[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (toLocCd[i] != null)
					model.setToLocCd(toLocCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (tsD2[i] != null)
					model.setTsD2(tsD2[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (tsD4[i] != null)
					model.setTsD4(tsD4[i]);
				if (mnvrInHrs[i] != null)
					model.setMnvrInHrs(mnvrInHrs[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstSkdSimDtlCalcInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstSkdSimDtlCalcInfoVO[]
	 */
	public CstSkdSimDtlCalcInfoVO[] getCstSkdSimDtlCalcInfoVOs(){
		CstSkdSimDtlCalcInfoVO[] vos = (CstSkdSimDtlCalcInfoVO[])models.toArray(new CstSkdSimDtlCalcInfoVO[models.size()]);
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
		this.mnvrOutHrs = this.mnvrOutHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmD2 = this.tmD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndDist = this.stndDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkUnitAmt = this.bnkUnitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlChgAmt = this.ttlChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlProdQty = this.tmlProdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBufHrs = this.portBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmD4 = this.tmD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crnKnt = this.crnKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocCd = this.fmLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tp40Qty = this.tp40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkUnitQty = this.bnkUnitQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spd = this.spd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.timeDiff = this.timeDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tp20Qty = this.tp20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocCd = this.toLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsD2 = this.tsD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsD4 = this.tsD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrInHrs = this.mnvrInHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
