/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMonthlyAdjustmentTradeRhqTabLaneListVO.java
*@FileTitle : SearchMonthlyAdjustmentTradeRhqTabLaneListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 최민철
*@LastVersion : 1.0
* 2009.09.07 최민철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.vo;

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

public class SearchMonthlyAdjustmentTradeRhqTabLaneListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyAdjustmentTradeRhqTabLaneListVO> models = new ArrayList<SearchMonthlyAdjustmentTradeRhqTabLaneListVO>();
	
	/* Column Info */
	private String recentMon = null;
	/* Column Info */
	private String slevel = null;
	/* Column Info */
	private String pfmcQta = null;
	/* Column Info */
	private String final1 = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String recentYr = null;
	/* Column Info */
	private String tradeTot = null;
	/* Column Info */
	private String final3 = null;
	/* Column Info */
	private String final2 = null;
	/* Column Info */
	private String ctrtRhqCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String adjustedTot = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String forecastTot = null;
	/* Column Info */
	private String rhq1 = null;
	/* Column Info */
	private String convDirCd = null;
	/* Column Info */
	private String rhq2 = null;
	/* Column Info */
	private String trade1 = null;
	/* Column Info */
	private String trade2 = null;
	/* Column Info */
	private String trade3 = null;
	/* Column Info */
	private String rhq3 = null;
	/* Column Info */
	private String itemText = null;
	/* Column Info */
	private String pfmcSmr = null;
	/* Column Info */
	private String yearlyTot = null;
	/* Column Info */
	private String key = null;
	/* Column Info */
	private String finalTot = null;
	/* Column Info */
	private String fcast1 = null;
	/* Column Info */
	private String fcast2 = null;
	/* Column Info */
	private String fcast3 = null;
	/* Column Info */
	private String yqta3 = null;
	/* Column Info */
	private String yqta2 = null;
	/* Column Info */
	private String yqta1 = null;
	/* Column Info */
	private String mdlRst1 = null;
	/* Column Info */
	private String adjusted3 = null;
	/* Column Info */
	private String adjusted2 = null;
	/* Column Info */
	private String rhqTot = null;
	/* Column Info */
	private String adjusted1 = null;
	/* Column Info */
	private String modelTot = null;
	/* Column Info */
	private String mdlRst2 = null;
	/* Column Info */
	private String mdlRst3 = null;
	/* Column Info */
	private String rowSeq = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyAdjustmentTradeRhqTabLaneListVO() {}

	public SearchMonthlyAdjustmentTradeRhqTabLaneListVO(String ibflag, String pagerows, String key, String slevel, String ctrtRhqCd, String subTrdCd, String rlaneCd, String convDirCd, String rowSeq, String itemText, String item, String pfmcQta, String pfmcSmr, String recentYr, String recentMon, String forecastTot, String modelTot, String yearlyTot, String tradeTot, String rhqTot, String finalTot, String adjustedTot, String fcast1, String mdlRst1, String yqta1, String trade1, String rhq1, String final1, String adjusted1, String fcast2, String mdlRst2, String yqta2, String trade2, String rhq2, String final2, String adjusted2, String fcast3, String mdlRst3, String yqta3, String trade3, String rhq3, String final3, String adjusted3) {
		this.recentMon = recentMon;
		this.slevel = slevel;
		this.pfmcQta = pfmcQta;
		this.final1 = final1;
		this.rlaneCd = rlaneCd;
		this.recentYr = recentYr;
		this.tradeTot = tradeTot;
		this.final3 = final3;
		this.final2 = final2;
		this.ctrtRhqCd = ctrtRhqCd;
		this.pagerows = pagerows;
		this.adjustedTot = adjustedTot;
		this.ibflag = ibflag;
		this.forecastTot = forecastTot;
		this.rhq1 = rhq1;
		this.convDirCd = convDirCd;
		this.rhq2 = rhq2;
		this.trade1 = trade1;
		this.trade2 = trade2;
		this.trade3 = trade3;
		this.rhq3 = rhq3;
		this.itemText = itemText;
		this.pfmcSmr = pfmcSmr;
		this.yearlyTot = yearlyTot;
		this.key = key;
		this.finalTot = finalTot;
		this.fcast1 = fcast1;
		this.fcast2 = fcast2;
		this.fcast3 = fcast3;
		this.yqta3 = yqta3;
		this.yqta2 = yqta2;
		this.yqta1 = yqta1;
		this.mdlRst1 = mdlRst1;
		this.adjusted3 = adjusted3;
		this.adjusted2 = adjusted2;
		this.rhqTot = rhqTot;
		this.adjusted1 = adjusted1;
		this.modelTot = modelTot;
		this.mdlRst2 = mdlRst2;
		this.mdlRst3 = mdlRst3;
		this.rowSeq = rowSeq;
		this.item = item;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("recent_mon", getRecentMon());
		this.hashColumns.put("slevel", getSlevel());
		this.hashColumns.put("pfmc_qta", getPfmcQta());
		this.hashColumns.put("final_1", getFinal1());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("recent_yr", getRecentYr());
		this.hashColumns.put("trade_tot", getTradeTot());
		this.hashColumns.put("final_3", getFinal3());
		this.hashColumns.put("final_2", getFinal2());
		this.hashColumns.put("ctrt_rhq_cd", getCtrtRhqCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("adjusted_tot", getAdjustedTot());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("forecast_tot", getForecastTot());
		this.hashColumns.put("rhq_1", getRhq1());
		this.hashColumns.put("conv_dir_cd", getConvDirCd());
		this.hashColumns.put("rhq_2", getRhq2());
		this.hashColumns.put("trade_1", getTrade1());
		this.hashColumns.put("trade_2", getTrade2());
		this.hashColumns.put("trade_3", getTrade3());
		this.hashColumns.put("rhq_3", getRhq3());
		this.hashColumns.put("item_text", getItemText());
		this.hashColumns.put("pfmc_smr", getPfmcSmr());
		this.hashColumns.put("yearly_tot", getYearlyTot());
		this.hashColumns.put("key", getKey());
		this.hashColumns.put("final_tot", getFinalTot());
		this.hashColumns.put("fcast_1", getFcast1());
		this.hashColumns.put("fcast_2", getFcast2());
		this.hashColumns.put("fcast_3", getFcast3());
		this.hashColumns.put("yqta_3", getYqta3());
		this.hashColumns.put("yqta_2", getYqta2());
		this.hashColumns.put("yqta_1", getYqta1());
		this.hashColumns.put("mdl_rst_1", getMdlRst1());
		this.hashColumns.put("adjusted_3", getAdjusted3());
		this.hashColumns.put("adjusted_2", getAdjusted2());
		this.hashColumns.put("rhq_tot", getRhqTot());
		this.hashColumns.put("adjusted_1", getAdjusted1());
		this.hashColumns.put("model_tot", getModelTot());
		this.hashColumns.put("mdl_rst_2", getMdlRst2());
		this.hashColumns.put("mdl_rst_3", getMdlRst3());
		this.hashColumns.put("row_seq", getRowSeq());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("recent_mon", "recentMon");
		this.hashFields.put("slevel", "slevel");
		this.hashFields.put("pfmc_qta", "pfmcQta");
		this.hashFields.put("final_1", "final1");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("recent_yr", "recentYr");
		this.hashFields.put("trade_tot", "tradeTot");
		this.hashFields.put("final_3", "final3");
		this.hashFields.put("final_2", "final2");
		this.hashFields.put("ctrt_rhq_cd", "ctrtRhqCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("adjusted_tot", "adjustedTot");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("forecast_tot", "forecastTot");
		this.hashFields.put("rhq_1", "rhq1");
		this.hashFields.put("conv_dir_cd", "convDirCd");
		this.hashFields.put("rhq_2", "rhq2");
		this.hashFields.put("trade_1", "trade1");
		this.hashFields.put("trade_2", "trade2");
		this.hashFields.put("trade_3", "trade3");
		this.hashFields.put("rhq_3", "rhq3");
		this.hashFields.put("item_text", "itemText");
		this.hashFields.put("pfmc_smr", "pfmcSmr");
		this.hashFields.put("yearly_tot", "yearlyTot");
		this.hashFields.put("key", "key");
		this.hashFields.put("final_tot", "finalTot");
		this.hashFields.put("fcast_1", "fcast1");
		this.hashFields.put("fcast_2", "fcast2");
		this.hashFields.put("fcast_3", "fcast3");
		this.hashFields.put("yqta_3", "yqta3");
		this.hashFields.put("yqta_2", "yqta2");
		this.hashFields.put("yqta_1", "yqta1");
		this.hashFields.put("mdl_rst_1", "mdlRst1");
		this.hashFields.put("adjusted_3", "adjusted3");
		this.hashFields.put("adjusted_2", "adjusted2");
		this.hashFields.put("rhq_tot", "rhqTot");
		this.hashFields.put("adjusted_1", "adjusted1");
		this.hashFields.put("model_tot", "modelTot");
		this.hashFields.put("mdl_rst_2", "mdlRst2");
		this.hashFields.put("mdl_rst_3", "mdlRst3");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("item", "item");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return recentMon
	 */
	public String getRecentMon() {
		return this.recentMon;
	}
	
	/**
	 * Column Info
	 * @return slevel
	 */
	public String getSlevel() {
		return this.slevel;
	}
	
	/**
	 * Column Info
	 * @return pfmcQta
	 */
	public String getPfmcQta() {
		return this.pfmcQta;
	}
	
	/**
	 * Column Info
	 * @return final1
	 */
	public String getFinal1() {
		return this.final1;
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
	 * @return recentYr
	 */
	public String getRecentYr() {
		return this.recentYr;
	}
	
	/**
	 * Column Info
	 * @return tradeTot
	 */
	public String getTradeTot() {
		return this.tradeTot;
	}
	
	/**
	 * Column Info
	 * @return final3
	 */
	public String getFinal3() {
		return this.final3;
	}
	
	/**
	 * Column Info
	 * @return final2
	 */
	public String getFinal2() {
		return this.final2;
	}
	
	/**
	 * Column Info
	 * @return ctrtRhqCd
	 */
	public String getCtrtRhqCd() {
		return this.ctrtRhqCd;
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
	 * @return adjustedTot
	 */
	public String getAdjustedTot() {
		return this.adjustedTot;
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
	 * @return forecastTot
	 */
	public String getForecastTot() {
		return this.forecastTot;
	}
	
	/**
	 * Column Info
	 * @return rhq1
	 */
	public String getRhq1() {
		return this.rhq1;
	}
	
	/**
	 * Column Info
	 * @return convDirCd
	 */
	public String getConvDirCd() {
		return this.convDirCd;
	}
	
	/**
	 * Column Info
	 * @return rhq2
	 */
	public String getRhq2() {
		return this.rhq2;
	}
	
	/**
	 * Column Info
	 * @return trade1
	 */
	public String getTrade1() {
		return this.trade1;
	}
	
	/**
	 * Column Info
	 * @return trade2
	 */
	public String getTrade2() {
		return this.trade2;
	}
	
	/**
	 * Column Info
	 * @return trade3
	 */
	public String getTrade3() {
		return this.trade3;
	}
	
	/**
	 * Column Info
	 * @return rhq3
	 */
	public String getRhq3() {
		return this.rhq3;
	}
	
	/**
	 * Column Info
	 * @return itemText
	 */
	public String getItemText() {
		return this.itemText;
	}
	
	/**
	 * Column Info
	 * @return pfmcSmr
	 */
	public String getPfmcSmr() {
		return this.pfmcSmr;
	}
	
	/**
	 * Column Info
	 * @return yearlyTot
	 */
	public String getYearlyTot() {
		return this.yearlyTot;
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
	 * @return finalTot
	 */
	public String getFinalTot() {
		return this.finalTot;
	}
	
	/**
	 * Column Info
	 * @return fcast1
	 */
	public String getFcast1() {
		return this.fcast1;
	}
	
	/**
	 * Column Info
	 * @return fcast2
	 */
	public String getFcast2() {
		return this.fcast2;
	}
	
	/**
	 * Column Info
	 * @return fcast3
	 */
	public String getFcast3() {
		return this.fcast3;
	}
	
	/**
	 * Column Info
	 * @return yqta3
	 */
	public String getYqta3() {
		return this.yqta3;
	}
	
	/**
	 * Column Info
	 * @return yqta2
	 */
	public String getYqta2() {
		return this.yqta2;
	}
	
	/**
	 * Column Info
	 * @return yqta1
	 */
	public String getYqta1() {
		return this.yqta1;
	}
	
	/**
	 * Column Info
	 * @return mdlRst1
	 */
	public String getMdlRst1() {
		return this.mdlRst1;
	}
	
	/**
	 * Column Info
	 * @return adjusted3
	 */
	public String getAdjusted3() {
		return this.adjusted3;
	}
	
	/**
	 * Column Info
	 * @return adjusted2
	 */
	public String getAdjusted2() {
		return this.adjusted2;
	}
	
	/**
	 * Column Info
	 * @return rhqTot
	 */
	public String getRhqTot() {
		return this.rhqTot;
	}
	
	/**
	 * Column Info
	 * @return adjusted1
	 */
	public String getAdjusted1() {
		return this.adjusted1;
	}
	
	/**
	 * Column Info
	 * @return modelTot
	 */
	public String getModelTot() {
		return this.modelTot;
	}
	
	/**
	 * Column Info
	 * @return mdlRst2
	 */
	public String getMdlRst2() {
		return this.mdlRst2;
	}
	
	/**
	 * Column Info
	 * @return mdlRst3
	 */
	public String getMdlRst3() {
		return this.mdlRst3;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	

	/**
	 * Column Info
	 * @param recentMon
	 */
	public void setRecentMon(String recentMon) {
		this.recentMon = recentMon;
	}
	
	/**
	 * Column Info
	 * @param slevel
	 */
	public void setSlevel(String slevel) {
		this.slevel = slevel;
	}
	
	/**
	 * Column Info
	 * @param pfmcQta
	 */
	public void setPfmcQta(String pfmcQta) {
		this.pfmcQta = pfmcQta;
	}
	
	/**
	 * Column Info
	 * @param final1
	 */
	public void setFinal1(String final1) {
		this.final1 = final1;
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
	 * @param recentYr
	 */
	public void setRecentYr(String recentYr) {
		this.recentYr = recentYr;
	}
	
	/**
	 * Column Info
	 * @param tradeTot
	 */
	public void setTradeTot(String tradeTot) {
		this.tradeTot = tradeTot;
	}
	
	/**
	 * Column Info
	 * @param final3
	 */
	public void setFinal3(String final3) {
		this.final3 = final3;
	}
	
	/**
	 * Column Info
	 * @param final2
	 */
	public void setFinal2(String final2) {
		this.final2 = final2;
	}
	
	/**
	 * Column Info
	 * @param ctrtRhqCd
	 */
	public void setCtrtRhqCd(String ctrtRhqCd) {
		this.ctrtRhqCd = ctrtRhqCd;
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
	 * @param adjustedTot
	 */
	public void setAdjustedTot(String adjustedTot) {
		this.adjustedTot = adjustedTot;
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
	 * @param forecastTot
	 */
	public void setForecastTot(String forecastTot) {
		this.forecastTot = forecastTot;
	}
	
	/**
	 * Column Info
	 * @param rhq1
	 */
	public void setRhq1(String rhq1) {
		this.rhq1 = rhq1;
	}
	
	/**
	 * Column Info
	 * @param convDirCd
	 */
	public void setConvDirCd(String convDirCd) {
		this.convDirCd = convDirCd;
	}
	
	/**
	 * Column Info
	 * @param rhq2
	 */
	public void setRhq2(String rhq2) {
		this.rhq2 = rhq2;
	}
	
	/**
	 * Column Info
	 * @param trade1
	 */
	public void setTrade1(String trade1) {
		this.trade1 = trade1;
	}
	
	/**
	 * Column Info
	 * @param trade2
	 */
	public void setTrade2(String trade2) {
		this.trade2 = trade2;
	}
	
	/**
	 * Column Info
	 * @param trade3
	 */
	public void setTrade3(String trade3) {
		this.trade3 = trade3;
	}
	
	/**
	 * Column Info
	 * @param rhq3
	 */
	public void setRhq3(String rhq3) {
		this.rhq3 = rhq3;
	}
	
	/**
	 * Column Info
	 * @param itemText
	 */
	public void setItemText(String itemText) {
		this.itemText = itemText;
	}
	
	/**
	 * Column Info
	 * @param pfmcSmr
	 */
	public void setPfmcSmr(String pfmcSmr) {
		this.pfmcSmr = pfmcSmr;
	}
	
	/**
	 * Column Info
	 * @param yearlyTot
	 */
	public void setYearlyTot(String yearlyTot) {
		this.yearlyTot = yearlyTot;
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
	 * @param finalTot
	 */
	public void setFinalTot(String finalTot) {
		this.finalTot = finalTot;
	}
	
	/**
	 * Column Info
	 * @param fcast1
	 */
	public void setFcast1(String fcast1) {
		this.fcast1 = fcast1;
	}
	
	/**
	 * Column Info
	 * @param fcast2
	 */
	public void setFcast2(String fcast2) {
		this.fcast2 = fcast2;
	}
	
	/**
	 * Column Info
	 * @param fcast3
	 */
	public void setFcast3(String fcast3) {
		this.fcast3 = fcast3;
	}
	
	/**
	 * Column Info
	 * @param yqta3
	 */
	public void setYqta3(String yqta3) {
		this.yqta3 = yqta3;
	}
	
	/**
	 * Column Info
	 * @param yqta2
	 */
	public void setYqta2(String yqta2) {
		this.yqta2 = yqta2;
	}
	
	/**
	 * Column Info
	 * @param yqta1
	 */
	public void setYqta1(String yqta1) {
		this.yqta1 = yqta1;
	}
	
	/**
	 * Column Info
	 * @param mdlRst1
	 */
	public void setMdlRst1(String mdlRst1) {
		this.mdlRst1 = mdlRst1;
	}
	
	/**
	 * Column Info
	 * @param adjusted3
	 */
	public void setAdjusted3(String adjusted3) {
		this.adjusted3 = adjusted3;
	}
	
	/**
	 * Column Info
	 * @param adjusted2
	 */
	public void setAdjusted2(String adjusted2) {
		this.adjusted2 = adjusted2;
	}
	
	/**
	 * Column Info
	 * @param rhqTot
	 */
	public void setRhqTot(String rhqTot) {
		this.rhqTot = rhqTot;
	}
	
	/**
	 * Column Info
	 * @param adjusted1
	 */
	public void setAdjusted1(String adjusted1) {
		this.adjusted1 = adjusted1;
	}
	
	/**
	 * Column Info
	 * @param modelTot
	 */
	public void setModelTot(String modelTot) {
		this.modelTot = modelTot;
	}
	
	/**
	 * Column Info
	 * @param mdlRst2
	 */
	public void setMdlRst2(String mdlRst2) {
		this.mdlRst2 = mdlRst2;
	}
	
	/**
	 * Column Info
	 * @param mdlRst3
	 */
	public void setMdlRst3(String mdlRst3) {
		this.mdlRst3 = mdlRst3;
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
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRecentMon(JSPUtil.getParameter(request, "recent_mon", ""));
		setSlevel(JSPUtil.getParameter(request, "slevel", ""));
		setPfmcQta(JSPUtil.getParameter(request, "pfmc_qta", ""));
		setFinal1(JSPUtil.getParameter(request, "final_1", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setRecentYr(JSPUtil.getParameter(request, "recent_yr", ""));
		setTradeTot(JSPUtil.getParameter(request, "trade_tot", ""));
		setFinal3(JSPUtil.getParameter(request, "final_3", ""));
		setFinal2(JSPUtil.getParameter(request, "final_2", ""));
		setCtrtRhqCd(JSPUtil.getParameter(request, "ctrt_rhq_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAdjustedTot(JSPUtil.getParameter(request, "adjusted_tot", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setForecastTot(JSPUtil.getParameter(request, "forecast_tot", ""));
		setRhq1(JSPUtil.getParameter(request, "rhq_1", ""));
		setConvDirCd(JSPUtil.getParameter(request, "conv_dir_cd", ""));
		setRhq2(JSPUtil.getParameter(request, "rhq_2", ""));
		setTrade1(JSPUtil.getParameter(request, "trade_1", ""));
		setTrade2(JSPUtil.getParameter(request, "trade_2", ""));
		setTrade3(JSPUtil.getParameter(request, "trade_3", ""));
		setRhq3(JSPUtil.getParameter(request, "rhq_3", ""));
		setItemText(JSPUtil.getParameter(request, "item_text", ""));
		setPfmcSmr(JSPUtil.getParameter(request, "pfmc_smr", ""));
		setYearlyTot(JSPUtil.getParameter(request, "yearly_tot", ""));
		setKey(JSPUtil.getParameter(request, "key", ""));
		setFinalTot(JSPUtil.getParameter(request, "final_tot", ""));
		setFcast1(JSPUtil.getParameter(request, "fcast_1", ""));
		setFcast2(JSPUtil.getParameter(request, "fcast_2", ""));
		setFcast3(JSPUtil.getParameter(request, "fcast_3", ""));
		setYqta3(JSPUtil.getParameter(request, "yqta_3", ""));
		setYqta2(JSPUtil.getParameter(request, "yqta_2", ""));
		setYqta1(JSPUtil.getParameter(request, "yqta_1", ""));
		setMdlRst1(JSPUtil.getParameter(request, "mdl_rst_1", ""));
		setAdjusted3(JSPUtil.getParameter(request, "adjusted_3", ""));
		setAdjusted2(JSPUtil.getParameter(request, "adjusted_2", ""));
		setRhqTot(JSPUtil.getParameter(request, "rhq_tot", ""));
		setAdjusted1(JSPUtil.getParameter(request, "adjusted_1", ""));
		setModelTot(JSPUtil.getParameter(request, "model_tot", ""));
		setMdlRst2(JSPUtil.getParameter(request, "mdl_rst_2", ""));
		setMdlRst3(JSPUtil.getParameter(request, "mdl_rst_3", ""));
		setRowSeq(JSPUtil.getParameter(request, "row_seq", ""));
		setItem(JSPUtil.getParameter(request, "item", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyAdjustmentTradeRhqTabLaneListVO[]
	 */
	public SearchMonthlyAdjustmentTradeRhqTabLaneListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyAdjustmentTradeRhqTabLaneListVO[]
	 */
	public SearchMonthlyAdjustmentTradeRhqTabLaneListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyAdjustmentTradeRhqTabLaneListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] recentMon = (JSPUtil.getParameter(request, prefix	+ "recent_mon", length));
			String[] slevel = (JSPUtil.getParameter(request, prefix	+ "slevel", length));
			String[] pfmcQta = (JSPUtil.getParameter(request, prefix	+ "pfmc_qta", length));
			String[] final1 = (JSPUtil.getParameter(request, prefix	+ "final_1", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] recentYr = (JSPUtil.getParameter(request, prefix	+ "recent_yr", length));
			String[] tradeTot = (JSPUtil.getParameter(request, prefix	+ "trade_tot", length));
			String[] final3 = (JSPUtil.getParameter(request, prefix	+ "final_3", length));
			String[] final2 = (JSPUtil.getParameter(request, prefix	+ "final_2", length));
			String[] ctrtRhqCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_rhq_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] adjustedTot = (JSPUtil.getParameter(request, prefix	+ "adjusted_tot", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] forecastTot = (JSPUtil.getParameter(request, prefix	+ "forecast_tot", length));
			String[] rhq1 = (JSPUtil.getParameter(request, prefix	+ "rhq_1", length));
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			String[] rhq2 = (JSPUtil.getParameter(request, prefix	+ "rhq_2", length));
			String[] trade1 = (JSPUtil.getParameter(request, prefix	+ "trade_1", length));
			String[] trade2 = (JSPUtil.getParameter(request, prefix	+ "trade_2", length));
			String[] trade3 = (JSPUtil.getParameter(request, prefix	+ "trade_3", length));
			String[] rhq3 = (JSPUtil.getParameter(request, prefix	+ "rhq_3", length));
			String[] itemText = (JSPUtil.getParameter(request, prefix	+ "item_text", length));
			String[] pfmcSmr = (JSPUtil.getParameter(request, prefix	+ "pfmc_smr", length));
			String[] yearlyTot = (JSPUtil.getParameter(request, prefix	+ "yearly_tot", length));
			String[] key = (JSPUtil.getParameter(request, prefix	+ "key", length));
			String[] finalTot = (JSPUtil.getParameter(request, prefix	+ "final_tot", length));
			String[] fcast1 = (JSPUtil.getParameter(request, prefix	+ "fcast_1", length));
			String[] fcast2 = (JSPUtil.getParameter(request, prefix	+ "fcast_2", length));
			String[] fcast3 = (JSPUtil.getParameter(request, prefix	+ "fcast_3", length));
			String[] yqta3 = (JSPUtil.getParameter(request, prefix	+ "yqta_3", length));
			String[] yqta2 = (JSPUtil.getParameter(request, prefix	+ "yqta_2", length));
			String[] yqta1 = (JSPUtil.getParameter(request, prefix	+ "yqta_1", length));
			String[] mdlRst1 = (JSPUtil.getParameter(request, prefix	+ "mdl_rst_1", length));
			String[] adjusted3 = (JSPUtil.getParameter(request, prefix	+ "adjusted_3", length));
			String[] adjusted2 = (JSPUtil.getParameter(request, prefix	+ "adjusted_2", length));
			String[] rhqTot = (JSPUtil.getParameter(request, prefix	+ "rhq_tot", length));
			String[] adjusted1 = (JSPUtil.getParameter(request, prefix	+ "adjusted_1", length));
			String[] modelTot = (JSPUtil.getParameter(request, prefix	+ "model_tot", length));
			String[] mdlRst2 = (JSPUtil.getParameter(request, prefix	+ "mdl_rst_2", length));
			String[] mdlRst3 = (JSPUtil.getParameter(request, prefix	+ "mdl_rst_3", length));
			String[] rowSeq = (JSPUtil.getParameter(request, prefix	+ "row_seq", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyAdjustmentTradeRhqTabLaneListVO();
				if (recentMon[i] != null)
					model.setRecentMon(recentMon[i]);
				if (slevel[i] != null)
					model.setSlevel(slevel[i]);
				if (pfmcQta[i] != null)
					model.setPfmcQta(pfmcQta[i]);
				if (final1[i] != null)
					model.setFinal1(final1[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (recentYr[i] != null)
					model.setRecentYr(recentYr[i]);
				if (tradeTot[i] != null)
					model.setTradeTot(tradeTot[i]);
				if (final3[i] != null)
					model.setFinal3(final3[i]);
				if (final2[i] != null)
					model.setFinal2(final2[i]);
				if (ctrtRhqCd[i] != null)
					model.setCtrtRhqCd(ctrtRhqCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (adjustedTot[i] != null)
					model.setAdjustedTot(adjustedTot[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (forecastTot[i] != null)
					model.setForecastTot(forecastTot[i]);
				if (rhq1[i] != null)
					model.setRhq1(rhq1[i]);
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				if (rhq2[i] != null)
					model.setRhq2(rhq2[i]);
				if (trade1[i] != null)
					model.setTrade1(trade1[i]);
				if (trade2[i] != null)
					model.setTrade2(trade2[i]);
				if (trade3[i] != null)
					model.setTrade3(trade3[i]);
				if (rhq3[i] != null)
					model.setRhq3(rhq3[i]);
				if (itemText[i] != null)
					model.setItemText(itemText[i]);
				if (pfmcSmr[i] != null)
					model.setPfmcSmr(pfmcSmr[i]);
				if (yearlyTot[i] != null)
					model.setYearlyTot(yearlyTot[i]);
				if (key[i] != null)
					model.setKey(key[i]);
				if (finalTot[i] != null)
					model.setFinalTot(finalTot[i]);
				if (fcast1[i] != null)
					model.setFcast1(fcast1[i]);
				if (fcast2[i] != null)
					model.setFcast2(fcast2[i]);
				if (fcast3[i] != null)
					model.setFcast3(fcast3[i]);
				if (yqta3[i] != null)
					model.setYqta3(yqta3[i]);
				if (yqta2[i] != null)
					model.setYqta2(yqta2[i]);
				if (yqta1[i] != null)
					model.setYqta1(yqta1[i]);
				if (mdlRst1[i] != null)
					model.setMdlRst1(mdlRst1[i]);
				if (adjusted3[i] != null)
					model.setAdjusted3(adjusted3[i]);
				if (adjusted2[i] != null)
					model.setAdjusted2(adjusted2[i]);
				if (rhqTot[i] != null)
					model.setRhqTot(rhqTot[i]);
				if (adjusted1[i] != null)
					model.setAdjusted1(adjusted1[i]);
				if (modelTot[i] != null)
					model.setModelTot(modelTot[i]);
				if (mdlRst2[i] != null)
					model.setMdlRst2(mdlRst2[i]);
				if (mdlRst3[i] != null)
					model.setMdlRst3(mdlRst3[i]);
				if (rowSeq[i] != null)
					model.setRowSeq(rowSeq[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyAdjustmentTradeRhqTabLaneListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyAdjustmentTradeRhqTabLaneListVO[]
	 */
	public SearchMonthlyAdjustmentTradeRhqTabLaneListVO[] getSearchMonthlyAdjustmentTradeRhqTabLaneListVOs(){
		SearchMonthlyAdjustmentTradeRhqTabLaneListVO[] vos = (SearchMonthlyAdjustmentTradeRhqTabLaneListVO[])models.toArray(new SearchMonthlyAdjustmentTradeRhqTabLaneListVO[models.size()]);
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
		this.recentMon = this.recentMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slevel = this.slevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcQta = this.pfmcQta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final1 = this.final1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentYr = this.recentYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeTot = this.tradeTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final3 = this.final3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final2 = this.final2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRhqCd = this.ctrtRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjustedTot = this.adjustedTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.forecastTot = this.forecastTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq1 = this.rhq1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq2 = this.rhq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade1 = this.trade1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade2 = this.trade2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade3 = this.trade3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq3 = this.rhq3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemText = this.itemText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcSmr = this.pfmcSmr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearlyTot = this.yearlyTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key = this.key .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalTot = this.finalTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast1 = this.fcast1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast2 = this.fcast2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast3 = this.fcast3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqta3 = this.yqta3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqta2 = this.yqta2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqta1 = this.yqta1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlRst1 = this.mdlRst1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjusted3 = this.adjusted3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjusted2 = this.adjusted2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqTot = this.rhqTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjusted1 = this.adjusted1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modelTot = this.modelTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlRst2 = this.mdlRst2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlRst3 = this.mdlRst3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq = this.rowSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
