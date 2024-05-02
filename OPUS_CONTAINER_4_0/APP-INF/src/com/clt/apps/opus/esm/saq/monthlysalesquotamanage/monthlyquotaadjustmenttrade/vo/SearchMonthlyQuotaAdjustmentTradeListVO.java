/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMonthlyQuotaAdjustmentTradeListVO.java
*@FileTitle : SearchMonthlyQuotaAdjustmentTradeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 최민철
*@LastVersion : 1.0
* 2009.08.19 최민철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.vo;

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
 * @author 최민철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyQuotaAdjustmentTradeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyQuotaAdjustmentTradeListVO> models = new ArrayList<SearchMonthlyQuotaAdjustmentTradeListVO>();
	
	/* Column Info */
	private String cmUcAmt = null;
	/* Column Info */
	private String recentYearly = null;
	/* Column Info */
	private String rhq01 = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grpSeq = null;
	/* Column Info */
	private String lowQty = null;
	/* Column Info */
	private String convLaneGrp = null;
	/* Column Info */
	private String bsaGrpCd = null;
	/* Column Info */
	private String totBsa = null;
	/* Column Info */
	private String key = null;
	/* Column Info */
	private String itemCode = null;
	/* Column Info */
	private String laneGrp02 = null;
	/* Column Info */
	private String fcast01 = null;
	/* Column Info */
	private String laneGrp01 = null;
	/* Column Info */
	private String raOpfitUcAmt = null;
	/* Column Info */
	private String opfitUcAmt = null;
	/* Column Info */
	private String totRpb = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String laneGrp = null;
	/* Column Info */
	private String yearly01 = null;
	/* Column Info */
	private String final01 = null;
	/* Column Info */
	private String sprtGrpCd = null;
	/* Column Info */
	private String raCmUcAmt = null;
	/* Column Info */
	private String rowSeq = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String adjusted01 = null;
	/* Column Info */
	private String totLod = null;
	/* Column Info */
	private String recentMonthly = null;
	/* Column Info */
	private String model01 = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String trade01 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyQuotaAdjustmentTradeListVO() {}

	public SearchMonthlyQuotaAdjustmentTradeListVO(String ibflag, String pagerows, String key, String subTrdCd, String laneGrp, String convLaneGrp, String laneGrp01, String laneGrp02, String rlaneCd, String sprtGrpCd, String bsaGrpCd, String grpSeq, String rhqCd, String rowSeq, String itemCode, String item, String recentYearly, String recentMonthly, String fcast01, String model01, String yearly01, String trade01, String rhq01, String final01, String adjusted01, String totLod, String totRpb, String cmUcAmt, String opfitUcAmt, String raCmUcAmt, String raOpfitUcAmt, String totBsa, String lowQty) {
		this.cmUcAmt = cmUcAmt;
		this.recentYearly = recentYearly;
		this.rhq01 = rhq01;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.grpSeq = grpSeq;
		this.lowQty = lowQty;
		this.convLaneGrp = convLaneGrp;
		this.bsaGrpCd = bsaGrpCd;
		this.totBsa = totBsa;
		this.key = key;
		this.itemCode = itemCode;
		this.laneGrp02 = laneGrp02;
		this.fcast01 = fcast01;
		this.laneGrp01 = laneGrp01;
		this.raOpfitUcAmt = raOpfitUcAmt;
		this.opfitUcAmt = opfitUcAmt;
		this.totRpb = totRpb;
		this.rhqCd = rhqCd;
		this.laneGrp = laneGrp;
		this.yearly01 = yearly01;
		this.final01 = final01;
		this.sprtGrpCd = sprtGrpCd;
		this.raCmUcAmt = raCmUcAmt;
		this.rowSeq = rowSeq;
		this.item = item;
		this.adjusted01 = adjusted01;
		this.totLod = totLod;
		this.recentMonthly = recentMonthly;
		this.model01 = model01;
		this.subTrdCd = subTrdCd;
		this.trade01 = trade01;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cm_uc_amt", getCmUcAmt());
		this.hashColumns.put("recent_yearly", getRecentYearly());
		this.hashColumns.put("rhq_01", getRhq01());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grp_seq", getGrpSeq());
		this.hashColumns.put("low_qty", getLowQty());
		this.hashColumns.put("conv_lane_grp", getConvLaneGrp());
		this.hashColumns.put("bsa_grp_cd", getBsaGrpCd());
		this.hashColumns.put("tot_bsa", getTotBsa());
		this.hashColumns.put("key", getKey());
		this.hashColumns.put("item_code", getItemCode());
		this.hashColumns.put("lane_grp02", getLaneGrp02());
		this.hashColumns.put("fcast_01", getFcast01());
		this.hashColumns.put("lane_grp01", getLaneGrp01());
		this.hashColumns.put("ra_opfit_uc_amt", getRaOpfitUcAmt());
		this.hashColumns.put("opfit_uc_amt", getOpfitUcAmt());
		this.hashColumns.put("tot_rpb", getTotRpb());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("lane_grp", getLaneGrp());
		this.hashColumns.put("yearly_01", getYearly01());
		this.hashColumns.put("final_01", getFinal01());
		this.hashColumns.put("sprt_grp_cd", getSprtGrpCd());
		this.hashColumns.put("ra_cm_uc_amt", getRaCmUcAmt());
		this.hashColumns.put("row_seq", getRowSeq());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("adjusted_01", getAdjusted01());
		this.hashColumns.put("tot_lod", getTotLod());
		this.hashColumns.put("recent_monthly", getRecentMonthly());
		this.hashColumns.put("model_01", getModel01());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("trade_01", getTrade01());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cm_uc_amt", "cmUcAmt");
		this.hashFields.put("recent_yearly", "recentYearly");
		this.hashFields.put("rhq_01", "rhq01");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grp_seq", "grpSeq");
		this.hashFields.put("low_qty", "lowQty");
		this.hashFields.put("conv_lane_grp", "convLaneGrp");
		this.hashFields.put("bsa_grp_cd", "bsaGrpCd");
		this.hashFields.put("tot_bsa", "totBsa");
		this.hashFields.put("key", "key");
		this.hashFields.put("item_code", "itemCode");
		this.hashFields.put("lane_grp02", "laneGrp02");
		this.hashFields.put("fcast_01", "fcast01");
		this.hashFields.put("lane_grp01", "laneGrp01");
		this.hashFields.put("ra_opfit_uc_amt", "raOpfitUcAmt");
		this.hashFields.put("opfit_uc_amt", "opfitUcAmt");
		this.hashFields.put("tot_rpb", "totRpb");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("lane_grp", "laneGrp");
		this.hashFields.put("yearly_01", "yearly01");
		this.hashFields.put("final_01", "final01");
		this.hashFields.put("sprt_grp_cd", "sprtGrpCd");
		this.hashFields.put("ra_cm_uc_amt", "raCmUcAmt");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("item", "item");
		this.hashFields.put("adjusted_01", "adjusted01");
		this.hashFields.put("tot_lod", "totLod");
		this.hashFields.put("recent_monthly", "recentMonthly");
		this.hashFields.put("model_01", "model01");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("trade_01", "trade01");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cmUcAmt
	 */
	public String getCmUcAmt() {
		return this.cmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return recentYearly
	 */
	public String getRecentYearly() {
		return this.recentYearly;
	}
	
	/**
	 * Column Info
	 * @return rhq01
	 */
	public String getRhq01() {
		return this.rhq01;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return grpSeq
	 */
	public String getGrpSeq() {
		return this.grpSeq;
	}
	
	/**
	 * Column Info
	 * @return lowQty
	 */
	public String getLowQty() {
		return this.lowQty;
	}
	
	/**
	 * Column Info
	 * @return convLaneGrp
	 */
	public String getConvLaneGrp() {
		return this.convLaneGrp;
	}
	
	/**
	 * Column Info
	 * @return bsaGrpCd
	 */
	public String getBsaGrpCd() {
		return this.bsaGrpCd;
	}
	
	/**
	 * Column Info
	 * @return totBsa
	 */
	public String getTotBsa() {
		return this.totBsa;
	}
	
	/**
	 * Column Info
	 * @return key
	 */
	public String getKey() {
		return this.key;
	}
	
	/**
	 * Column Info
	 * @return itemCode
	 */
	public String getItemCode() {
		return this.itemCode;
	}
	
	/**
	 * Column Info
	 * @return laneGrp02
	 */
	public String getLaneGrp02() {
		return this.laneGrp02;
	}
	
	/**
	 * Column Info
	 * @return fcast01
	 */
	public String getFcast01() {
		return this.fcast01;
	}
	
	/**
	 * Column Info
	 * @return laneGrp01
	 */
	public String getLaneGrp01() {
		return this.laneGrp01;
	}
	
	/**
	 * Column Info
	 * @return raOpfitUcAmt
	 */
	public String getRaOpfitUcAmt() {
		return this.raOpfitUcAmt;
	}
	
	/**
	 * Column Info
	 * @return opfitUcAmt
	 */
	public String getOpfitUcAmt() {
		return this.opfitUcAmt;
	}
	
	/**
	 * Column Info
	 * @return totRpb
	 */
	public String getTotRpb() {
		return this.totRpb;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return laneGrp
	 */
	public String getLaneGrp() {
		return this.laneGrp;
	}
	
	/**
	 * Column Info
	 * @return yearly01
	 */
	public String getYearly01() {
		return this.yearly01;
	}
	
	/**
	 * Column Info
	 * @return final01
	 */
	public String getFinal01() {
		return this.final01;
	}
	
	/**
	 * Column Info
	 * @return sprtGrpCd
	 */
	public String getSprtGrpCd() {
		return this.sprtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return raCmUcAmt
	 */
	public String getRaCmUcAmt() {
		return this.raCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return rowSeq
	 */
	public String getRowSeq() {
		return this.rowSeq;
	}
	
	/**
	 * Column Info
	 * @return item
	 */
	public String getItem() {
		return this.item;
	}
	
	/**
	 * Column Info
	 * @return adjusted01
	 */
	public String getAdjusted01() {
		return this.adjusted01;
	}
	
	/**
	 * Column Info
	 * @return totLod
	 */
	public String getTotLod() {
		return this.totLod;
	}
	
	/**
	 * Column Info
	 * @return recentMonthly
	 */
	public String getRecentMonthly() {
		return this.recentMonthly;
	}
	
	/**
	 * Column Info
	 * @return model01
	 */
	public String getModel01() {
		return this.model01;
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
	 * @return trade01
	 */
	public String getTrade01() {
		return this.trade01;
	}
	

	/**
	 * Column Info
	 * @param cmUcAmt
	 */
	public void setCmUcAmt(String cmUcAmt) {
		this.cmUcAmt = cmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param recentYearly
	 */
	public void setRecentYearly(String recentYearly) {
		this.recentYearly = recentYearly;
	}
	
	/**
	 * Column Info
	 * @param rhq01
	 */
	public void setRhq01(String rhq01) {
		this.rhq01 = rhq01;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param grpSeq
	 */
	public void setGrpSeq(String grpSeq) {
		this.grpSeq = grpSeq;
	}
	
	/**
	 * Column Info
	 * @param lowQty
	 */
	public void setLowQty(String lowQty) {
		this.lowQty = lowQty;
	}
	
	/**
	 * Column Info
	 * @param convLaneGrp
	 */
	public void setConvLaneGrp(String convLaneGrp) {
		this.convLaneGrp = convLaneGrp;
	}
	
	/**
	 * Column Info
	 * @param bsaGrpCd
	 */
	public void setBsaGrpCd(String bsaGrpCd) {
		this.bsaGrpCd = bsaGrpCd;
	}
	
	/**
	 * Column Info
	 * @param totBsa
	 */
	public void setTotBsa(String totBsa) {
		this.totBsa = totBsa;
	}
	
	/**
	 * Column Info
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * Column Info
	 * @param itemCode
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	/**
	 * Column Info
	 * @param laneGrp02
	 */
	public void setLaneGrp02(String laneGrp02) {
		this.laneGrp02 = laneGrp02;
	}
	
	/**
	 * Column Info
	 * @param fcast01
	 */
	public void setFcast01(String fcast01) {
		this.fcast01 = fcast01;
	}
	
	/**
	 * Column Info
	 * @param laneGrp01
	 */
	public void setLaneGrp01(String laneGrp01) {
		this.laneGrp01 = laneGrp01;
	}
	
	/**
	 * Column Info
	 * @param raOpfitUcAmt
	 */
	public void setRaOpfitUcAmt(String raOpfitUcAmt) {
		this.raOpfitUcAmt = raOpfitUcAmt;
	}
	
	/**
	 * Column Info
	 * @param opfitUcAmt
	 */
	public void setOpfitUcAmt(String opfitUcAmt) {
		this.opfitUcAmt = opfitUcAmt;
	}
	
	/**
	 * Column Info
	 * @param totRpb
	 */
	public void setTotRpb(String totRpb) {
		this.totRpb = totRpb;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param laneGrp
	 */
	public void setLaneGrp(String laneGrp) {
		this.laneGrp = laneGrp;
	}
	
	/**
	 * Column Info
	 * @param yearly01
	 */
	public void setYearly01(String yearly01) {
		this.yearly01 = yearly01;
	}
	
	/**
	 * Column Info
	 * @param final01
	 */
	public void setFinal01(String final01) {
		this.final01 = final01;
	}
	
	/**
	 * Column Info
	 * @param sprtGrpCd
	 */
	public void setSprtGrpCd(String sprtGrpCd) {
		this.sprtGrpCd = sprtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param raCmUcAmt
	 */
	public void setRaCmUcAmt(String raCmUcAmt) {
		this.raCmUcAmt = raCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param rowSeq
	 */
	public void setRowSeq(String rowSeq) {
		this.rowSeq = rowSeq;
	}
	
	/**
	 * Column Info
	 * @param item
	 */
	public void setItem(String item) {
		this.item = item;
	}
	
	/**
	 * Column Info
	 * @param adjusted01
	 */
	public void setAdjusted01(String adjusted01) {
		this.adjusted01 = adjusted01;
	}
	
	/**
	 * Column Info
	 * @param totLod
	 */
	public void setTotLod(String totLod) {
		this.totLod = totLod;
	}
	
	/**
	 * Column Info
	 * @param recentMonthly
	 */
	public void setRecentMonthly(String recentMonthly) {
		this.recentMonthly = recentMonthly;
	}
	
	/**
	 * Column Info
	 * @param model01
	 */
	public void setModel01(String model01) {
		this.model01 = model01;
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
	 * @param trade01
	 */
	public void setTrade01(String trade01) {
		this.trade01 = trade01;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCmUcAmt(JSPUtil.getParameter(request, "cm_uc_amt", ""));
		setRecentYearly(JSPUtil.getParameter(request, "recent_yearly", ""));
		setRhq01(JSPUtil.getParameter(request, "rhq_01", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGrpSeq(JSPUtil.getParameter(request, "grp_seq", ""));
		setLowQty(JSPUtil.getParameter(request, "low_qty", ""));
		setConvLaneGrp(JSPUtil.getParameter(request, "conv_lane_grp", ""));
		setBsaGrpCd(JSPUtil.getParameter(request, "bsa_grp_cd", ""));
		setTotBsa(JSPUtil.getParameter(request, "tot_bsa", ""));
		setKey(JSPUtil.getParameter(request, "key", ""));
		setItemCode(JSPUtil.getParameter(request, "item_code", ""));
		setLaneGrp02(JSPUtil.getParameter(request, "lane_grp02", ""));
		setFcast01(JSPUtil.getParameter(request, "fcast_01", ""));
		setLaneGrp01(JSPUtil.getParameter(request, "lane_grp01", ""));
		setRaOpfitUcAmt(JSPUtil.getParameter(request, "ra_opfit_uc_amt", ""));
		setOpfitUcAmt(JSPUtil.getParameter(request, "opfit_uc_amt", ""));
		setTotRpb(JSPUtil.getParameter(request, "tot_rpb", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setLaneGrp(JSPUtil.getParameter(request, "lane_grp", ""));
		setYearly01(JSPUtil.getParameter(request, "yearly_01", ""));
		setFinal01(JSPUtil.getParameter(request, "final_01", ""));
		setSprtGrpCd(JSPUtil.getParameter(request, "sprt_grp_cd", ""));
		setRaCmUcAmt(JSPUtil.getParameter(request, "ra_cm_uc_amt", ""));
		setRowSeq(JSPUtil.getParameter(request, "row_seq", ""));
		setItem(JSPUtil.getParameter(request, "item", ""));
		setAdjusted01(JSPUtil.getParameter(request, "adjusted_01", ""));
		setTotLod(JSPUtil.getParameter(request, "tot_lod", ""));
		setRecentMonthly(JSPUtil.getParameter(request, "recent_monthly", ""));
		setModel01(JSPUtil.getParameter(request, "model_01", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setTrade01(JSPUtil.getParameter(request, "trade_01", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchMonthlyQuotaAdjustmentTradeListVO[]
	 */
	public SearchMonthlyQuotaAdjustmentTradeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchMonthlyQuotaAdjustmentTradeListVO[]
	 */
	public SearchMonthlyQuotaAdjustmentTradeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyQuotaAdjustmentTradeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cmUcAmt = (JSPUtil.getParameter(request, prefix	+ "cm_uc_amt", length));
			String[] recentYearly = (JSPUtil.getParameter(request, prefix	+ "recent_yearly", length));
			String[] rhq01 = (JSPUtil.getParameter(request, prefix	+ "rhq_01", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grpSeq = (JSPUtil.getParameter(request, prefix	+ "grp_seq", length));
			String[] lowQty = (JSPUtil.getParameter(request, prefix	+ "low_qty", length));
			String[] convLaneGrp = (JSPUtil.getParameter(request, prefix	+ "conv_lane_grp", length));
			String[] bsaGrpCd = (JSPUtil.getParameter(request, prefix	+ "bsa_grp_cd", length));
			String[] totBsa = (JSPUtil.getParameter(request, prefix	+ "tot_bsa", length));
			String[] key = (JSPUtil.getParameter(request, prefix	+ "key", length));
			String[] itemCode = (JSPUtil.getParameter(request, prefix	+ "item_code", length));
			String[] laneGrp02 = (JSPUtil.getParameter(request, prefix	+ "lane_grp02", length));
			String[] fcast01 = (JSPUtil.getParameter(request, prefix	+ "fcast_01", length));
			String[] laneGrp01 = (JSPUtil.getParameter(request, prefix	+ "lane_grp01", length));
			String[] raOpfitUcAmt = (JSPUtil.getParameter(request, prefix	+ "ra_opfit_uc_amt", length));
			String[] opfitUcAmt = (JSPUtil.getParameter(request, prefix	+ "opfit_uc_amt", length));
			String[] totRpb = (JSPUtil.getParameter(request, prefix	+ "tot_rpb", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] laneGrp = (JSPUtil.getParameter(request, prefix	+ "lane_grp", length));
			String[] yearly01 = (JSPUtil.getParameter(request, prefix	+ "yearly_01", length));
			String[] final01 = (JSPUtil.getParameter(request, prefix	+ "final_01", length));
			String[] sprtGrpCd = (JSPUtil.getParameter(request, prefix	+ "sprt_grp_cd", length));
			String[] raCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "ra_cm_uc_amt", length));
			String[] rowSeq = (JSPUtil.getParameter(request, prefix	+ "row_seq", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] adjusted01 = (JSPUtil.getParameter(request, prefix	+ "adjusted_01", length));
			String[] totLod = (JSPUtil.getParameter(request, prefix	+ "tot_lod", length));
			String[] recentMonthly = (JSPUtil.getParameter(request, prefix	+ "recent_monthly", length));
			String[] model01 = (JSPUtil.getParameter(request, prefix	+ "model_01", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] trade01 = (JSPUtil.getParameter(request, prefix	+ "trade_01", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyQuotaAdjustmentTradeListVO();
				if (cmUcAmt[i] != null)
					model.setCmUcAmt(cmUcAmt[i]);
				if (recentYearly[i] != null)
					model.setRecentYearly(recentYearly[i]);
				if (rhq01[i] != null)
					model.setRhq01(rhq01[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grpSeq[i] != null)
					model.setGrpSeq(grpSeq[i]);
				if (lowQty[i] != null)
					model.setLowQty(lowQty[i]);
				if (convLaneGrp[i] != null)
					model.setConvLaneGrp(convLaneGrp[i]);
				if (bsaGrpCd[i] != null)
					model.setBsaGrpCd(bsaGrpCd[i]);
				if (totBsa[i] != null)
					model.setTotBsa(totBsa[i]);
				if (key[i] != null)
					model.setKey(key[i]);
				if (itemCode[i] != null)
					model.setItemCode(itemCode[i]);
				if (laneGrp02[i] != null)
					model.setLaneGrp02(laneGrp02[i]);
				if (fcast01[i] != null)
					model.setFcast01(fcast01[i]);
				if (laneGrp01[i] != null)
					model.setLaneGrp01(laneGrp01[i]);
				if (raOpfitUcAmt[i] != null)
					model.setRaOpfitUcAmt(raOpfitUcAmt[i]);
				if (opfitUcAmt[i] != null)
					model.setOpfitUcAmt(opfitUcAmt[i]);
				if (totRpb[i] != null)
					model.setTotRpb(totRpb[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (laneGrp[i] != null)
					model.setLaneGrp(laneGrp[i]);
				if (yearly01[i] != null)
					model.setYearly01(yearly01[i]);
				if (final01[i] != null)
					model.setFinal01(final01[i]);
				if (sprtGrpCd[i] != null)
					model.setSprtGrpCd(sprtGrpCd[i]);
				if (raCmUcAmt[i] != null)
					model.setRaCmUcAmt(raCmUcAmt[i]);
				if (rowSeq[i] != null)
					model.setRowSeq(rowSeq[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (adjusted01[i] != null)
					model.setAdjusted01(adjusted01[i]);
				if (totLod[i] != null)
					model.setTotLod(totLod[i]);
				if (recentMonthly[i] != null)
					model.setRecentMonthly(recentMonthly[i]);
				if (model01[i] != null)
					model.setModel01(model01[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (trade01[i] != null)
					model.setTrade01(trade01[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyQuotaAdjustmentTradeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchMonthlyQuotaAdjustmentTradeListVO[]
	 */
	public SearchMonthlyQuotaAdjustmentTradeListVO[] getSearchMonthlyQuotaAdjustmentTradeListVOs(){
		SearchMonthlyQuotaAdjustmentTradeListVO[] vos = (SearchMonthlyQuotaAdjustmentTradeListVO[])models.toArray(new SearchMonthlyQuotaAdjustmentTradeListVO[models.size()]);
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
		this.cmUcAmt = this.cmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentYearly = this.recentYearly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq01 = this.rhq01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpSeq = this.grpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowQty = this.lowQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convLaneGrp = this.convLaneGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaGrpCd = this.bsaGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBsa = this.totBsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key = this.key .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemCode = this.itemCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrp02 = this.laneGrp02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast01 = this.fcast01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrp01 = this.laneGrp01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raOpfitUcAmt = this.raOpfitUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opfitUcAmt = this.opfitUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totRpb = this.totRpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrp = this.laneGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearly01 = this.yearly01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final01 = this.final01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtGrpCd = this.sprtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmUcAmt = this.raCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq = this.rowSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjusted01 = this.adjusted01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLod = this.totLod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentMonthly = this.recentMonthly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.model01 = this.model01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade01 = this.trade01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
