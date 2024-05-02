/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SalesFcstDtlVO.java
*@FileTitle : SalesFcstDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.04  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo;

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

public class SalesFcstDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SalesFcstDtlVO> models = new ArrayList<SalesFcstDtlVO>();
	
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String totalQty = null;
	/* Column Info */
	private String polEccCd = null;
	/* Column Info */
	private String fmDate = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String fcastTtlQty = null;
	/* Column Info */
	private String toWeek = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String d2FcastRto = null;
	/* Column Info */
	private String d2Qty = null;
	/* Column Info */
	private String locGrpCd = null;
	/* Column Info */
	private String createChkBox = null;
	/* Column Info */
	private String fmWeek = null;
	/* Column Info */
	private String avgTtDys = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String d7Qty = null;
	/* Column Info */
	private String polEtbDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bseDt = null;
	/* Column Info */
	private String d5FcastRto = null;
	/* Column Info */
	private String d4Qty = null;
	/* Column Info */
	private String d4FcastRto = null;
	/* Column Info */
	private String cntrPkupSccCd = null;
	/* Column Info */
	private String d5Qty = null;
	/* Column Info */
	private String d7FcastRto = null;
	/* Column Info */
	private String week = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SalesFcstDtlVO() {}

	public SalesFcstDtlVO(String ibflag, String pagerows, String week, String bseDt, String cntrPkupSccCd, String rlaneCd, String vvd, String slsOfcCd, String polEccCd, String polEtbDt, String fcastTtlQty, String totalQty, String d2Qty, String d4Qty, String d5Qty, String d7Qty, String avgTtDys, String d2FcastRto, String d4FcastRto, String d5FcastRto, String d7FcastRto, String locGrpCd, String locCd, String fmWeek, String toWeek, String createChkBox, String fmDate, String toDate) {
		this.rlaneCd = rlaneCd;
		this.totalQty = totalQty;
		this.polEccCd = polEccCd;
		this.fmDate = fmDate;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.fcastTtlQty = fcastTtlQty;
		this.toWeek = toWeek;
		this.slsOfcCd = slsOfcCd;
		this.d2FcastRto = d2FcastRto;
		this.d2Qty = d2Qty;
		this.locGrpCd = locGrpCd;
		this.createChkBox = createChkBox;
		this.fmWeek = fmWeek;
		this.avgTtDys = avgTtDys;
		this.toDate = toDate;
		this.d7Qty = d7Qty;
		this.polEtbDt = polEtbDt;
		this.vvd = vvd;
		this.bseDt = bseDt;
		this.d5FcastRto = d5FcastRto;
		this.d4Qty = d4Qty;
		this.d4FcastRto = d4FcastRto;
		this.cntrPkupSccCd = cntrPkupSccCd;
		this.d5Qty = d5Qty;
		this.d7FcastRto = d7FcastRto;
		this.week = week;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("total_qty", getTotalQty());
		this.hashColumns.put("pol_ecc_cd", getPolEccCd());
		this.hashColumns.put("fm_date", getFmDate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("fcast_ttl_qty", getFcastTtlQty());
		this.hashColumns.put("to_week", getToWeek());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("d2_fcast_rto", getD2FcastRto());
		this.hashColumns.put("d2_qty", getD2Qty());
		this.hashColumns.put("loc_grp_cd", getLocGrpCd());
		this.hashColumns.put("create_chk_box", getCreateChkBox());
		this.hashColumns.put("fm_week", getFmWeek());
		this.hashColumns.put("avg_tt_dys", getAvgTtDys());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("d7_qty", getD7Qty());
		this.hashColumns.put("pol_etb_dt", getPolEtbDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bse_dt", getBseDt());
		this.hashColumns.put("d5_fcast_rto", getD5FcastRto());
		this.hashColumns.put("d4_qty", getD4Qty());
		this.hashColumns.put("d4_fcast_rto", getD4FcastRto());
		this.hashColumns.put("cntr_pkup_scc_cd", getCntrPkupSccCd());
		this.hashColumns.put("d5_qty", getD5Qty());
		this.hashColumns.put("d7_fcast_rto", getD7FcastRto());
		this.hashColumns.put("week", getWeek());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("total_qty", "totalQty");
		this.hashFields.put("pol_ecc_cd", "polEccCd");
		this.hashFields.put("fm_date", "fmDate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("fcast_ttl_qty", "fcastTtlQty");
		this.hashFields.put("to_week", "toWeek");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("d2_fcast_rto", "d2FcastRto");
		this.hashFields.put("d2_qty", "d2Qty");
		this.hashFields.put("loc_grp_cd", "locGrpCd");
		this.hashFields.put("create_chk_box", "createChkBox");
		this.hashFields.put("fm_week", "fmWeek");
		this.hashFields.put("avg_tt_dys", "avgTtDys");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("d7_qty", "d7Qty");
		this.hashFields.put("pol_etb_dt", "polEtbDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bse_dt", "bseDt");
		this.hashFields.put("d5_fcast_rto", "d5FcastRto");
		this.hashFields.put("d4_qty", "d4Qty");
		this.hashFields.put("d4_fcast_rto", "d4FcastRto");
		this.hashFields.put("cntr_pkup_scc_cd", "cntrPkupSccCd");
		this.hashFields.put("d5_qty", "d5Qty");
		this.hashFields.put("d7_fcast_rto", "d7FcastRto");
		this.hashFields.put("week", "week");
		return this.hashFields;
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
	 * @return totalQty
	 */
	public String getTotalQty() {
		return this.totalQty;
	}
	
	/**
	 * Column Info
	 * @return polEccCd
	 */
	public String getPolEccCd() {
		return this.polEccCd;
	}
	
	/**
	 * Column Info
	 * @return fmDate
	 */
	public String getFmDate() {
		return this.fmDate;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return fcastTtlQty
	 */
	public String getFcastTtlQty() {
		return this.fcastTtlQty;
	}
	
	/**
	 * Column Info
	 * @return toWeek
	 */
	public String getToWeek() {
		return this.toWeek;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return d2FcastRto
	 */
	public String getD2FcastRto() {
		return this.d2FcastRto;
	}
	
	/**
	 * Column Info
	 * @return d2Qty
	 */
	public String getD2Qty() {
		return this.d2Qty;
	}
	
	/**
	 * Column Info
	 * @return locGrpCd
	 */
	public String getLocGrpCd() {
		return this.locGrpCd;
	}
	
	/**
	 * Column Info
	 * @return createChkBox
	 */
	public String getCreateChkBox() {
		return this.createChkBox;
	}
	
	/**
	 * Column Info
	 * @return fmWeek
	 */
	public String getFmWeek() {
		return this.fmWeek;
	}
	
	/**
	 * Column Info
	 * @return avgTtDys
	 */
	public String getAvgTtDys() {
		return this.avgTtDys;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return d7Qty
	 */
	public String getD7Qty() {
		return this.d7Qty;
	}
	
	/**
	 * Column Info
	 * @return polEtbDt
	 */
	public String getPolEtbDt() {
		return this.polEtbDt;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return bseDt
	 */
	public String getBseDt() {
		return this.bseDt;
	}
	
	/**
	 * Column Info
	 * @return d5FcastRto
	 */
	public String getD5FcastRto() {
		return this.d5FcastRto;
	}
	
	/**
	 * Column Info
	 * @return d4Qty
	 */
	public String getD4Qty() {
		return this.d4Qty;
	}
	
	/**
	 * Column Info
	 * @return d4FcastRto
	 */
	public String getD4FcastRto() {
		return this.d4FcastRto;
	}
	
	/**
	 * Column Info
	 * @return cntrPkupSccCd
	 */
	public String getCntrPkupSccCd() {
		return this.cntrPkupSccCd;
	}
	
	/**
	 * Column Info
	 * @return d5Qty
	 */
	public String getD5Qty() {
		return this.d5Qty;
	}
	
	/**
	 * Column Info
	 * @return d7FcastRto
	 */
	public String getD7FcastRto() {
		return this.d7FcastRto;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
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
	 * @param totalQty
	 */
	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}
	
	/**
	 * Column Info
	 * @param polEccCd
	 */
	public void setPolEccCd(String polEccCd) {
		this.polEccCd = polEccCd;
	}
	
	/**
	 * Column Info
	 * @param fmDate
	 */
	public void setFmDate(String fmDate) {
		this.fmDate = fmDate;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param fcastTtlQty
	 */
	public void setFcastTtlQty(String fcastTtlQty) {
		this.fcastTtlQty = fcastTtlQty;
	}
	
	/**
	 * Column Info
	 * @param toWeek
	 */
	public void setToWeek(String toWeek) {
		this.toWeek = toWeek;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param d2FcastRto
	 */
	public void setD2FcastRto(String d2FcastRto) {
		this.d2FcastRto = d2FcastRto;
	}
	
	/**
	 * Column Info
	 * @param d2Qty
	 */
	public void setD2Qty(String d2Qty) {
		this.d2Qty = d2Qty;
	}
	
	/**
	 * Column Info
	 * @param locGrpCd
	 */
	public void setLocGrpCd(String locGrpCd) {
		this.locGrpCd = locGrpCd;
	}
	
	/**
	 * Column Info
	 * @param createChkBox
	 */
	public void setCreateChkBox(String createChkBox) {
		this.createChkBox = createChkBox;
	}
	
	/**
	 * Column Info
	 * @param fmWeek
	 */
	public void setFmWeek(String fmWeek) {
		this.fmWeek = fmWeek;
	}
	
	/**
	 * Column Info
	 * @param avgTtDys
	 */
	public void setAvgTtDys(String avgTtDys) {
		this.avgTtDys = avgTtDys;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param d7Qty
	 */
	public void setD7Qty(String d7Qty) {
		this.d7Qty = d7Qty;
	}
	
	/**
	 * Column Info
	 * @param polEtbDt
	 */
	public void setPolEtbDt(String polEtbDt) {
		this.polEtbDt = polEtbDt;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param bseDt
	 */
	public void setBseDt(String bseDt) {
		this.bseDt = bseDt;
	}
	
	/**
	 * Column Info
	 * @param d5FcastRto
	 */
	public void setD5FcastRto(String d5FcastRto) {
		this.d5FcastRto = d5FcastRto;
	}
	
	/**
	 * Column Info
	 * @param d4Qty
	 */
	public void setD4Qty(String d4Qty) {
		this.d4Qty = d4Qty;
	}
	
	/**
	 * Column Info
	 * @param d4FcastRto
	 */
	public void setD4FcastRto(String d4FcastRto) {
		this.d4FcastRto = d4FcastRto;
	}
	
	/**
	 * Column Info
	 * @param cntrPkupSccCd
	 */
	public void setCntrPkupSccCd(String cntrPkupSccCd) {
		this.cntrPkupSccCd = cntrPkupSccCd;
	}
	
	/**
	 * Column Info
	 * @param d5Qty
	 */
	public void setD5Qty(String d5Qty) {
		this.d5Qty = d5Qty;
	}
	
	/**
	 * Column Info
	 * @param d7FcastRto
	 */
	public void setD7FcastRto(String d7FcastRto) {
		this.d7FcastRto = d7FcastRto;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
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
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setTotalQty(JSPUtil.getParameter(request, prefix + "total_qty", ""));
		setPolEccCd(JSPUtil.getParameter(request, prefix + "pol_ecc_cd", ""));
		setFmDate(JSPUtil.getParameter(request, prefix + "fm_date", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setFcastTtlQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_qty", ""));
		setToWeek(JSPUtil.getParameter(request, prefix + "to_week", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setD2FcastRto(JSPUtil.getParameter(request, prefix + "d2_fcast_rto", ""));
		setD2Qty(JSPUtil.getParameter(request, prefix + "d2_qty", ""));
		setLocGrpCd(JSPUtil.getParameter(request, prefix + "loc_grp_cd", ""));
		setCreateChkBox(JSPUtil.getParameter(request, prefix + "create_chk_box", ""));
		setFmWeek(JSPUtil.getParameter(request, prefix + "fm_week", ""));
		setAvgTtDys(JSPUtil.getParameter(request, prefix + "avg_tt_dys", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setD7Qty(JSPUtil.getParameter(request, prefix + "d7_qty", ""));
		setPolEtbDt(JSPUtil.getParameter(request, prefix + "pol_etb_dt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBseDt(JSPUtil.getParameter(request, prefix + "bse_dt", ""));
		setD5FcastRto(JSPUtil.getParameter(request, prefix + "d5_fcast_rto", ""));
		setD4Qty(JSPUtil.getParameter(request, prefix + "d4_qty", ""));
		setD4FcastRto(JSPUtil.getParameter(request, prefix + "d4_fcast_rto", ""));
		setCntrPkupSccCd(JSPUtil.getParameter(request, prefix + "cntr_pkup_scc_cd", ""));
		setD5Qty(JSPUtil.getParameter(request, prefix + "d5_qty", ""));
		setD7FcastRto(JSPUtil.getParameter(request, prefix + "d7_fcast_rto", ""));
		setWeek(JSPUtil.getParameter(request, prefix + "week", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SalesFcstDtlVO[]
	 */
	public SalesFcstDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SalesFcstDtlVO[]
	 */
	public SalesFcstDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SalesFcstDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] totalQty = (JSPUtil.getParameter(request, prefix	+ "total_qty", length));
			String[] polEccCd = (JSPUtil.getParameter(request, prefix	+ "pol_ecc_cd", length));
			String[] fmDate = (JSPUtil.getParameter(request, prefix	+ "fm_date", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] fcastTtlQty = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_qty", length));
			String[] toWeek = (JSPUtil.getParameter(request, prefix	+ "to_week", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] d2FcastRto = (JSPUtil.getParameter(request, prefix	+ "d2_fcast_rto", length));
			String[] d2Qty = (JSPUtil.getParameter(request, prefix	+ "d2_qty", length));
			String[] locGrpCd = (JSPUtil.getParameter(request, prefix	+ "loc_grp_cd", length));
			String[] createChkBox = (JSPUtil.getParameter(request, prefix	+ "create_chk_box", length));
			String[] fmWeek = (JSPUtil.getParameter(request, prefix	+ "fm_week", length));
			String[] avgTtDys = (JSPUtil.getParameter(request, prefix	+ "avg_tt_dys", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] d7Qty = (JSPUtil.getParameter(request, prefix	+ "d7_qty", length));
			String[] polEtbDt = (JSPUtil.getParameter(request, prefix	+ "pol_etb_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bseDt = (JSPUtil.getParameter(request, prefix	+ "bse_dt", length));
			String[] d5FcastRto = (JSPUtil.getParameter(request, prefix	+ "d5_fcast_rto", length));
			String[] d4Qty = (JSPUtil.getParameter(request, prefix	+ "d4_qty", length));
			String[] d4FcastRto = (JSPUtil.getParameter(request, prefix	+ "d4_fcast_rto", length));
			String[] cntrPkupSccCd = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_scc_cd", length));
			String[] d5Qty = (JSPUtil.getParameter(request, prefix	+ "d5_qty", length));
			String[] d7FcastRto = (JSPUtil.getParameter(request, prefix	+ "d7_fcast_rto", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			
			for (int i = 0; i < length; i++) {
				model = new SalesFcstDtlVO();
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (totalQty[i] != null)
					model.setTotalQty(totalQty[i]);
				if (polEccCd[i] != null)
					model.setPolEccCd(polEccCd[i]);
				if (fmDate[i] != null)
					model.setFmDate(fmDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (fcastTtlQty[i] != null)
					model.setFcastTtlQty(fcastTtlQty[i]);
				if (toWeek[i] != null)
					model.setToWeek(toWeek[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (d2FcastRto[i] != null)
					model.setD2FcastRto(d2FcastRto[i]);
				if (d2Qty[i] != null)
					model.setD2Qty(d2Qty[i]);
				if (locGrpCd[i] != null)
					model.setLocGrpCd(locGrpCd[i]);
				if (createChkBox[i] != null)
					model.setCreateChkBox(createChkBox[i]);
				if (fmWeek[i] != null)
					model.setFmWeek(fmWeek[i]);
				if (avgTtDys[i] != null)
					model.setAvgTtDys(avgTtDys[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (d7Qty[i] != null)
					model.setD7Qty(d7Qty[i]);
				if (polEtbDt[i] != null)
					model.setPolEtbDt(polEtbDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bseDt[i] != null)
					model.setBseDt(bseDt[i]);
				if (d5FcastRto[i] != null)
					model.setD5FcastRto(d5FcastRto[i]);
				if (d4Qty[i] != null)
					model.setD4Qty(d4Qty[i]);
				if (d4FcastRto[i] != null)
					model.setD4FcastRto(d4FcastRto[i]);
				if (cntrPkupSccCd[i] != null)
					model.setCntrPkupSccCd(cntrPkupSccCd[i]);
				if (d5Qty[i] != null)
					model.setD5Qty(d5Qty[i]);
				if (d7FcastRto[i] != null)
					model.setD7FcastRto(d7FcastRto[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSalesFcstDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SalesFcstDtlVO[]
	 */
	public SalesFcstDtlVO[] getSalesFcstDtlVOs(){
		SalesFcstDtlVO[] vos = (SalesFcstDtlVO[])models.toArray(new SalesFcstDtlVO[models.size()]);
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
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalQty = this.totalQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEccCd = this.polEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDate = this.fmDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlQty = this.fcastTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWeek = this.toWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2FcastRto = this.d2FcastRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Qty = this.d2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrpCd = this.locGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.createChkBox = this.createChkBox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmWeek = this.fmWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgTtDys = this.avgTtDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7Qty = this.d7Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtbDt = this.polEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseDt = this.bseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5FcastRto = this.d5FcastRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Qty = this.d4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4FcastRto = this.d4FcastRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupSccCd = this.cntrPkupSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5Qty = this.d5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7FcastRto = this.d7FcastRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
