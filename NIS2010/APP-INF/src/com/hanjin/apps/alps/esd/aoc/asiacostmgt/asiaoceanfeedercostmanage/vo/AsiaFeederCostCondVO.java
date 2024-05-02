/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AsiaFeederCostCondVO.java
*@FileTitle : AsiaFeederCostCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AsiaFeederCostCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AsiaFeederCostCondVO> models = new ArrayList<AsiaFeederCostCondVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String excelToDt = null;
	/* Column Info */
	private String excelCostTrfNo = null;
	/* Column Info */
	private String costFactorCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String excelFromNodCd = null;
	/* Column Info */
	private String excelSysSrcCd = null;
	/* Column Info */
	private String excelCostFactorCd = null;
	/* Column Info */
	private String excelFromDt = null;
	/* Column Info */
	private String excelDateFlg = null;
	/* Column Info */
	private String pctlIoBndCd = null;
	/* Column Info */
	private String dateFlg = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String excelAdjustmentCd = null;
	/* Column Info */
	private String sysSrcCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String adjustmentCd = null;
	/* Column Info */
	private String excelEffToDt = null;
	/* Column Info */
	private String bntFlg = null;
	/* Column Info */
	private String fromNodCd = null;
	/* Column Info */
	private String excelPctlIoBndCd = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String excelToNodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AsiaFeederCostCondVO() {}

	public AsiaFeederCostCondVO(String ibflag, String pagerows, String toNodCd, String dateFlg, String fromDt, String costTrfNo, String sysSrcCd, String costFactorCd, String adjustmentCd, String toDt, String fromNodCd, String bntFlg, String effToDt, String pctlIoBndCd, String excelDateFlg, String excelFromDt, String excelToDt, String excelEffToDt, String excelCostTrfNo, String excelPctlIoBndCd, String excelFromNodCd, String excelToNodCd, String excelCostFactorCd, String excelSysSrcCd, String excelAdjustmentCd) {
		this.toNodCd = toNodCd;
		this.fromDt = fromDt;
		this.excelToDt = excelToDt;
		this.excelCostTrfNo = excelCostTrfNo;
		this.costFactorCd = costFactorCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.excelFromNodCd = excelFromNodCd;
		this.excelSysSrcCd = excelSysSrcCd;
		this.excelCostFactorCd = excelCostFactorCd;
		this.excelFromDt = excelFromDt;
		this.excelDateFlg = excelDateFlg;
		this.pctlIoBndCd = pctlIoBndCd;
		this.dateFlg = dateFlg;
		this.costTrfNo = costTrfNo;
		this.excelAdjustmentCd = excelAdjustmentCd;
		this.sysSrcCd = sysSrcCd;
		this.toDt = toDt;
		this.adjustmentCd = adjustmentCd;
		this.excelEffToDt = excelEffToDt;
		this.bntFlg = bntFlg;
		this.fromNodCd = fromNodCd;
		this.excelPctlIoBndCd = excelPctlIoBndCd;
		this.effToDt = effToDt;
		this.excelToNodCd = excelToNodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("excel_to_dt", getExcelToDt());
		this.hashColumns.put("excel_cost_trf_no", getExcelCostTrfNo());
		this.hashColumns.put("cost_factor_cd", getCostFactorCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("excel_from_nod_cd", getExcelFromNodCd());
		this.hashColumns.put("excel_sys_src_cd", getExcelSysSrcCd());
		this.hashColumns.put("excel_cost_factor_cd", getExcelCostFactorCd());
		this.hashColumns.put("excel_from_dt", getExcelFromDt());
		this.hashColumns.put("excel_date_flg", getExcelDateFlg());
		this.hashColumns.put("pctl_io_bnd_cd", getPctlIoBndCd());
		this.hashColumns.put("date_flg", getDateFlg());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("excel_adjustment_cd", getExcelAdjustmentCd());
		this.hashColumns.put("sys_src_cd", getSysSrcCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("adjustment_cd", getAdjustmentCd());
		this.hashColumns.put("excel_eff_to_dt", getExcelEffToDt());
		this.hashColumns.put("bnt_flg", getBntFlg());
		this.hashColumns.put("from_nod_cd", getFromNodCd());
		this.hashColumns.put("excel_pctl_io_bnd_cd", getExcelPctlIoBndCd());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("excel_to_nod_cd", getExcelToNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("excel_to_dt", "excelToDt");
		this.hashFields.put("excel_cost_trf_no", "excelCostTrfNo");
		this.hashFields.put("cost_factor_cd", "costFactorCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("excel_from_nod_cd", "excelFromNodCd");
		this.hashFields.put("excel_sys_src_cd", "excelSysSrcCd");
		this.hashFields.put("excel_cost_factor_cd", "excelCostFactorCd");
		this.hashFields.put("excel_from_dt", "excelFromDt");
		this.hashFields.put("excel_date_flg", "excelDateFlg");
		this.hashFields.put("pctl_io_bnd_cd", "pctlIoBndCd");
		this.hashFields.put("date_flg", "dateFlg");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("excel_adjustment_cd", "excelAdjustmentCd");
		this.hashFields.put("sys_src_cd", "sysSrcCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("adjustment_cd", "adjustmentCd");
		this.hashFields.put("excel_eff_to_dt", "excelEffToDt");
		this.hashFields.put("bnt_flg", "bntFlg");
		this.hashFields.put("from_nod_cd", "fromNodCd");
		this.hashFields.put("excel_pctl_io_bnd_cd", "excelPctlIoBndCd");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("excel_to_nod_cd", "excelToNodCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
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
	 * @return excelToDt
	 */
	public String getExcelToDt() {
		return this.excelToDt;
	}
	
	/**
	 * Column Info
	 * @return excelCostTrfNo
	 */
	public String getExcelCostTrfNo() {
		return this.excelCostTrfNo;
	}
	
	/**
	 * Column Info
	 * @return costFactorCd
	 */
	public String getCostFactorCd() {
		return this.costFactorCd;
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
	 * @return excelFromNodCd
	 */
	public String getExcelFromNodCd() {
		return this.excelFromNodCd;
	}
	
	/**
	 * Column Info
	 * @return excelSysSrcCd
	 */
	public String getExcelSysSrcCd() {
		return this.excelSysSrcCd;
	}
	
	/**
	 * Column Info
	 * @return excelCostFactorCd
	 */
	public String getExcelCostFactorCd() {
		return this.excelCostFactorCd;
	}
	
	/**
	 * Column Info
	 * @return excelFromDt
	 */
	public String getExcelFromDt() {
		return this.excelFromDt;
	}
	
	/**
	 * Column Info
	 * @return excelDateFlg
	 */
	public String getExcelDateFlg() {
		return this.excelDateFlg;
	}
	
	/**
	 * Column Info
	 * @return pctlIoBndCd
	 */
	public String getPctlIoBndCd() {
		return this.pctlIoBndCd;
	}
	
	/**
	 * Column Info
	 * @return dateFlg
	 */
	public String getDateFlg() {
		return this.dateFlg;
	}
	
	/**
	 * Column Info
	 * @return costTrfNo
	 */
	public String getCostTrfNo() {
		return this.costTrfNo;
	}
	
	/**
	 * Column Info
	 * @return excelAdjustmentCd
	 */
	public String getExcelAdjustmentCd() {
		return this.excelAdjustmentCd;
	}
	
	/**
	 * Column Info
	 * @return sysSrcCd
	 */
	public String getSysSrcCd() {
		return this.sysSrcCd;
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
	 * @return adjustmentCd
	 */
	public String getAdjustmentCd() {
		return this.adjustmentCd;
	}
	
	/**
	 * Column Info
	 * @return excelEffToDt
	 */
	public String getExcelEffToDt() {
		return this.excelEffToDt;
	}
	
	/**
	 * Column Info
	 * @return bntFlg
	 */
	public String getBntFlg() {
		return this.bntFlg;
	}
	
	/**
	 * Column Info
	 * @return fromNodCd
	 */
	public String getFromNodCd() {
		return this.fromNodCd;
	}
	
	/**
	 * Column Info
	 * @return excelPctlIoBndCd
	 */
	public String getExcelPctlIoBndCd() {
		return this.excelPctlIoBndCd;
	}
	
	/**
	 * Column Info
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
	}
	
	/**
	 * Column Info
	 * @return excelToNodCd
	 */
	public String getExcelToNodCd() {
		return this.excelToNodCd;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
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
	 * @param excelToDt
	 */
	public void setExcelToDt(String excelToDt) {
		this.excelToDt = excelToDt;
	}
	
	/**
	 * Column Info
	 * @param excelCostTrfNo
	 */
	public void setExcelCostTrfNo(String excelCostTrfNo) {
		this.excelCostTrfNo = excelCostTrfNo;
	}
	
	/**
	 * Column Info
	 * @param costFactorCd
	 */
	public void setCostFactorCd(String costFactorCd) {
		this.costFactorCd = costFactorCd;
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
	 * @param excelFromNodCd
	 */
	public void setExcelFromNodCd(String excelFromNodCd) {
		this.excelFromNodCd = excelFromNodCd;
	}
	
	/**
	 * Column Info
	 * @param excelSysSrcCd
	 */
	public void setExcelSysSrcCd(String excelSysSrcCd) {
		this.excelSysSrcCd = excelSysSrcCd;
	}
	
	/**
	 * Column Info
	 * @param excelCostFactorCd
	 */
	public void setExcelCostFactorCd(String excelCostFactorCd) {
		this.excelCostFactorCd = excelCostFactorCd;
	}
	
	/**
	 * Column Info
	 * @param excelFromDt
	 */
	public void setExcelFromDt(String excelFromDt) {
		this.excelFromDt = excelFromDt;
	}
	
	/**
	 * Column Info
	 * @param excelDateFlg
	 */
	public void setExcelDateFlg(String excelDateFlg) {
		this.excelDateFlg = excelDateFlg;
	}
	
	/**
	 * Column Info
	 * @param pctlIoBndCd
	 */
	public void setPctlIoBndCd(String pctlIoBndCd) {
		this.pctlIoBndCd = pctlIoBndCd;
	}
	
	/**
	 * Column Info
	 * @param dateFlg
	 */
	public void setDateFlg(String dateFlg) {
		this.dateFlg = dateFlg;
	}
	
	/**
	 * Column Info
	 * @param costTrfNo
	 */
	public void setCostTrfNo(String costTrfNo) {
		this.costTrfNo = costTrfNo;
	}
	
	/**
	 * Column Info
	 * @param excelAdjustmentCd
	 */
	public void setExcelAdjustmentCd(String excelAdjustmentCd) {
		this.excelAdjustmentCd = excelAdjustmentCd;
	}
	
	/**
	 * Column Info
	 * @param sysSrcCd
	 */
	public void setSysSrcCd(String sysSrcCd) {
		this.sysSrcCd = sysSrcCd;
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
	 * @param adjustmentCd
	 */
	public void setAdjustmentCd(String adjustmentCd) {
		this.adjustmentCd = adjustmentCd;
	}
	
	/**
	 * Column Info
	 * @param excelEffToDt
	 */
	public void setExcelEffToDt(String excelEffToDt) {
		this.excelEffToDt = excelEffToDt;
	}
	
	/**
	 * Column Info
	 * @param bntFlg
	 */
	public void setBntFlg(String bntFlg) {
		this.bntFlg = bntFlg;
	}
	
	/**
	 * Column Info
	 * @param fromNodCd
	 */
	public void setFromNodCd(String fromNodCd) {
		this.fromNodCd = fromNodCd;
	}
	
	/**
	 * Column Info
	 * @param excelPctlIoBndCd
	 */
	public void setExcelPctlIoBndCd(String excelPctlIoBndCd) {
		this.excelPctlIoBndCd = excelPctlIoBndCd;
	}
	
	/**
	 * Column Info
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
	}
	
	/**
	 * Column Info
	 * @param excelToNodCd
	 */
	public void setExcelToNodCd(String excelToNodCd) {
		this.excelToNodCd = excelToNodCd;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setExcelToDt(JSPUtil.getParameter(request, prefix + "excel_to_dt", ""));
		setExcelCostTrfNo(JSPUtil.getParameter(request, prefix + "excel_cost_trf_no", ""));
		setCostFactorCd(JSPUtil.getParameter(request, prefix + "cost_factor_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setExcelFromNodCd(JSPUtil.getParameter(request, prefix + "excel_from_nod_cd", ""));
		setExcelSysSrcCd(JSPUtil.getParameter(request, prefix + "excel_sys_src_cd", ""));
		setExcelCostFactorCd(JSPUtil.getParameter(request, prefix + "excel_cost_factor_cd", ""));
		setExcelFromDt(JSPUtil.getParameter(request, prefix + "excel_from_dt", ""));
		setExcelDateFlg(JSPUtil.getParameter(request, prefix + "excel_date_flg", ""));
		setPctlIoBndCd(JSPUtil.getParameter(request, prefix + "pctl_io_bnd_cd", ""));
		setDateFlg(JSPUtil.getParameter(request, prefix + "date_flg", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setExcelAdjustmentCd(JSPUtil.getParameter(request, prefix + "excel_adjustment_cd", ""));
		setSysSrcCd(JSPUtil.getParameter(request, prefix + "sys_src_cd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setAdjustmentCd(JSPUtil.getParameter(request, prefix + "adjustment_cd", ""));
		setExcelEffToDt(JSPUtil.getParameter(request, prefix + "excel_eff_to_dt", ""));
		setBntFlg(JSPUtil.getParameter(request, prefix + "bnt_flg", ""));
		setFromNodCd(JSPUtil.getParameter(request, prefix + "from_nod_cd", ""));
		setExcelPctlIoBndCd(JSPUtil.getParameter(request, prefix + "excel_pctl_io_bnd_cd", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setExcelToNodCd(JSPUtil.getParameter(request, prefix + "excel_to_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AsiaFeederCostCondVO[]
	 */
	public AsiaFeederCostCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AsiaFeederCostCondVO[]
	 */
	public AsiaFeederCostCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AsiaFeederCostCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] excelToDt = (JSPUtil.getParameter(request, prefix	+ "excel_to_dt", length));
			String[] excelCostTrfNo = (JSPUtil.getParameter(request, prefix	+ "excel_cost_trf_no", length));
			String[] costFactorCd = (JSPUtil.getParameter(request, prefix	+ "cost_factor_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] excelFromNodCd = (JSPUtil.getParameter(request, prefix	+ "excel_from_nod_cd", length));
			String[] excelSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "excel_sys_src_cd", length));
			String[] excelCostFactorCd = (JSPUtil.getParameter(request, prefix	+ "excel_cost_factor_cd", length));
			String[] excelFromDt = (JSPUtil.getParameter(request, prefix	+ "excel_from_dt", length));
			String[] excelDateFlg = (JSPUtil.getParameter(request, prefix	+ "excel_date_flg", length));
			String[] pctlIoBndCd = (JSPUtil.getParameter(request, prefix	+ "pctl_io_bnd_cd", length));
			String[] dateFlg = (JSPUtil.getParameter(request, prefix	+ "date_flg", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] excelAdjustmentCd = (JSPUtil.getParameter(request, prefix	+ "excel_adjustment_cd", length));
			String[] sysSrcCd = (JSPUtil.getParameter(request, prefix	+ "sys_src_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] adjustmentCd = (JSPUtil.getParameter(request, prefix	+ "adjustment_cd", length));
			String[] excelEffToDt = (JSPUtil.getParameter(request, prefix	+ "excel_eff_to_dt", length));
			String[] bntFlg = (JSPUtil.getParameter(request, prefix	+ "bnt_flg", length));
			String[] fromNodCd = (JSPUtil.getParameter(request, prefix	+ "from_nod_cd", length));
			String[] excelPctlIoBndCd = (JSPUtil.getParameter(request, prefix	+ "excel_pctl_io_bnd_cd", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] excelToNodCd = (JSPUtil.getParameter(request, prefix	+ "excel_to_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AsiaFeederCostCondVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (excelToDt[i] != null)
					model.setExcelToDt(excelToDt[i]);
				if (excelCostTrfNo[i] != null)
					model.setExcelCostTrfNo(excelCostTrfNo[i]);
				if (costFactorCd[i] != null)
					model.setCostFactorCd(costFactorCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (excelFromNodCd[i] != null)
					model.setExcelFromNodCd(excelFromNodCd[i]);
				if (excelSysSrcCd[i] != null)
					model.setExcelSysSrcCd(excelSysSrcCd[i]);
				if (excelCostFactorCd[i] != null)
					model.setExcelCostFactorCd(excelCostFactorCd[i]);
				if (excelFromDt[i] != null)
					model.setExcelFromDt(excelFromDt[i]);
				if (excelDateFlg[i] != null)
					model.setExcelDateFlg(excelDateFlg[i]);
				if (pctlIoBndCd[i] != null)
					model.setPctlIoBndCd(pctlIoBndCd[i]);
				if (dateFlg[i] != null)
					model.setDateFlg(dateFlg[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (excelAdjustmentCd[i] != null)
					model.setExcelAdjustmentCd(excelAdjustmentCd[i]);
				if (sysSrcCd[i] != null)
					model.setSysSrcCd(sysSrcCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (adjustmentCd[i] != null)
					model.setAdjustmentCd(adjustmentCd[i]);
				if (excelEffToDt[i] != null)
					model.setExcelEffToDt(excelEffToDt[i]);
				if (bntFlg[i] != null)
					model.setBntFlg(bntFlg[i]);
				if (fromNodCd[i] != null)
					model.setFromNodCd(fromNodCd[i]);
				if (excelPctlIoBndCd[i] != null)
					model.setExcelPctlIoBndCd(excelPctlIoBndCd[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (excelToNodCd[i] != null)
					model.setExcelToNodCd(excelToNodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOceanFeederCostCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AsiaFeederCostCondVO[]
	 */
	public AsiaFeederCostCondVO[] getOceanFeederCostCondVOs(){
		AsiaFeederCostCondVO[] vos = (AsiaFeederCostCondVO[])models.toArray(new AsiaFeederCostCondVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelToDt = this.excelToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelCostTrfNo = this.excelCostTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costFactorCd = this.costFactorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelFromNodCd = this.excelFromNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelSysSrcCd = this.excelSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelCostFactorCd = this.excelCostFactorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelFromDt = this.excelFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelDateFlg = this.excelDateFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlIoBndCd = this.pctlIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateFlg = this.dateFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelAdjustmentCd = this.excelAdjustmentCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysSrcCd = this.sysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjustmentCd = this.adjustmentCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelEffToDt = this.excelEffToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bntFlg = this.bntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromNodCd = this.fromNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelPctlIoBndCd = this.excelPctlIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelToNodCd = this.excelToNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
