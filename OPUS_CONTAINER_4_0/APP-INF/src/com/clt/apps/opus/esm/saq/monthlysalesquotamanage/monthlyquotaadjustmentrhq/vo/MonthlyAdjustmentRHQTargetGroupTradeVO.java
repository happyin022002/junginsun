/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MonthlyAdjustmentRHQTargetGroupTradeVO.java
*@FileTitle : MonthlyAdjustmentRHQTargetGroupTradeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 김태호
*@LastVersion : 1.0
* 2009.09.10 김태호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.vo;

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
 * @author 김태호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MonthlyAdjustmentRHQTargetGroupTradeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MonthlyAdjustmentRHQTargetGroupTradeVO> models = new ArrayList<MonthlyAdjustmentRHQTargetGroupTradeVO>();
	
	/* Column Info */
	private String recentMon = null;
	/* Column Info */
	private String slevel = null;
	/* Column Info */
	private String pfmcQta = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String final1 = null;
	/* Column Info */
	private String recentYr = null;
	/* Column Info */
	private String final3 = null;
	/* Column Info */
	private String final2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String forecastTot = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String initial3 = null;
	/* Column Info */
	private String initial2 = null;
	/* Column Info */
	private String itemText = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String initial1 = null;
	/* Column Info */
	private String pfmcSmr = null;
	/* Column Info */
	private String initialTot = null;
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
	private String modelTot = null;
	/* Column Info */
	private String mdlRst2 = null;
	/* Column Info */
	private String mdlRst3 = null;
	/* Column Info */
	private String rowSeq = null;
	/* Column Info */
	private String item = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MonthlyAdjustmentRHQTargetGroupTradeVO() {}

	public MonthlyAdjustmentRHQTargetGroupTradeVO(String ibflag, String pagerows, String slevel, String trdCd, String dirCd, String rowSeq, String itemText, String item, String pfmcQta, String pfmcSmr, String recentYr, String recentMon, String forecastTot, String modelTot, String initialTot, String finalTot, String fcast1, String mdlRst1, String yqta1, String final1, String initial1, String fcast2, String mdlRst2, String yqta2, String final2, String initial2, String fcast3, String mdlRst3, String yqta3, String final3, String initial3) {
		this.recentMon = recentMon;
		this.slevel = slevel;
		this.pfmcQta = pfmcQta;
		this.trdCd = trdCd;
		this.final1 = final1;
		this.recentYr = recentYr;
		this.final3 = final3;
		this.final2 = final2;
		this.pagerows = pagerows;
		this.forecastTot = forecastTot;
		this.ibflag = ibflag;
		this.initial3 = initial3;
		this.initial2 = initial2;
		this.itemText = itemText;
		this.dirCd = dirCd;
		this.initial1 = initial1;
		this.pfmcSmr = pfmcSmr;
		this.initialTot = initialTot;
		this.finalTot = finalTot;
		this.fcast1 = fcast1;
		this.fcast2 = fcast2;
		this.fcast3 = fcast3;
		this.yqta3 = yqta3;
		this.yqta2 = yqta2;
		this.yqta1 = yqta1;
		this.mdlRst1 = mdlRst1;
		this.modelTot = modelTot;
		this.mdlRst2 = mdlRst2;
		this.mdlRst3 = mdlRst3;
		this.rowSeq = rowSeq;
		this.item = item;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("recent_mon", getRecentMon());
		this.hashColumns.put("slevel", getSlevel());
		this.hashColumns.put("pfmc_qta", getPfmcQta());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("final_1", getFinal1());
		this.hashColumns.put("recent_yr", getRecentYr());
		this.hashColumns.put("final_3", getFinal3());
		this.hashColumns.put("final_2", getFinal2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("forecast_tot", getForecastTot());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("initial_3", getInitial3());
		this.hashColumns.put("initial_2", getInitial2());
		this.hashColumns.put("item_text", getItemText());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("initial_1", getInitial1());
		this.hashColumns.put("pfmc_smr", getPfmcSmr());
		this.hashColumns.put("initial_tot", getInitialTot());
		this.hashColumns.put("final_tot", getFinalTot());
		this.hashColumns.put("fcast_1", getFcast1());
		this.hashColumns.put("fcast_2", getFcast2());
		this.hashColumns.put("fcast_3", getFcast3());
		this.hashColumns.put("yqta_3", getYqta3());
		this.hashColumns.put("yqta_2", getYqta2());
		this.hashColumns.put("yqta_1", getYqta1());
		this.hashColumns.put("mdl_rst_1", getMdlRst1());
		this.hashColumns.put("model_tot", getModelTot());
		this.hashColumns.put("mdl_rst_2", getMdlRst2());
		this.hashColumns.put("mdl_rst_3", getMdlRst3());
		this.hashColumns.put("row_seq", getRowSeq());
		this.hashColumns.put("item", getItem());
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
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("final_1", "final1");
		this.hashFields.put("recent_yr", "recentYr");
		this.hashFields.put("final_3", "final3");
		this.hashFields.put("final_2", "final2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("forecast_tot", "forecastTot");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("initial_3", "initial3");
		this.hashFields.put("initial_2", "initial2");
		this.hashFields.put("item_text", "itemText");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("initial_1", "initial1");
		this.hashFields.put("pfmc_smr", "pfmcSmr");
		this.hashFields.put("initial_tot", "initialTot");
		this.hashFields.put("final_tot", "finalTot");
		this.hashFields.put("fcast_1", "fcast1");
		this.hashFields.put("fcast_2", "fcast2");
		this.hashFields.put("fcast_3", "fcast3");
		this.hashFields.put("yqta_3", "yqta3");
		this.hashFields.put("yqta_2", "yqta2");
		this.hashFields.put("yqta_1", "yqta1");
		this.hashFields.put("mdl_rst_1", "mdlRst1");
		this.hashFields.put("model_tot", "modelTot");
		this.hashFields.put("mdl_rst_2", "mdlRst2");
		this.hashFields.put("mdl_rst_3", "mdlRst3");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("item", "item");
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return recentYr
	 */
	public String getRecentYr() {
		return this.recentYr;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return forecastTot
	 */
	public String getForecastTot() {
		return this.forecastTot;
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
	 * @return initial3
	 */
	public String getInitial3() {
		return this.initial3;
	}
	
	/**
	 * Column Info
	 * @return initial2
	 */
	public String getInitial2() {
		return this.initial2;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return initial1
	 */
	public String getInitial1() {
		return this.initial1;
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
	 * @return initialTot
	 */
	public String getInitialTot() {
		return this.initialTot;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param recentYr
	 */
	public void setRecentYr(String recentYr) {
		this.recentYr = recentYr;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param forecastTot
	 */
	public void setForecastTot(String forecastTot) {
		this.forecastTot = forecastTot;
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
	 * @param initial3
	 */
	public void setInitial3(String initial3) {
		this.initial3 = initial3;
	}
	
	/**
	 * Column Info
	 * @param initial2
	 */
	public void setInitial2(String initial2) {
		this.initial2 = initial2;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param initial1
	 */
	public void setInitial1(String initial1) {
		this.initial1 = initial1;
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
	 * @param initialTot
	 */
	public void setInitialTot(String initialTot) {
		this.initialTot = initialTot;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRecentMon(JSPUtil.getParameter(request, "recent_mon", ""));
		setSlevel(JSPUtil.getParameter(request, "slevel", ""));
		setPfmcQta(JSPUtil.getParameter(request, "pfmc_qta", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setFinal1(JSPUtil.getParameter(request, "final_1", ""));
		setRecentYr(JSPUtil.getParameter(request, "recent_yr", ""));
		setFinal3(JSPUtil.getParameter(request, "final_3", ""));
		setFinal2(JSPUtil.getParameter(request, "final_2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setForecastTot(JSPUtil.getParameter(request, "forecast_tot", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInitial3(JSPUtil.getParameter(request, "initial_3", ""));
		setInitial2(JSPUtil.getParameter(request, "initial_2", ""));
		setItemText(JSPUtil.getParameter(request, "item_text", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setInitial1(JSPUtil.getParameter(request, "initial_1", ""));
		setPfmcSmr(JSPUtil.getParameter(request, "pfmc_smr", ""));
		setInitialTot(JSPUtil.getParameter(request, "initial_tot", ""));
		setFinalTot(JSPUtil.getParameter(request, "final_tot", ""));
		setFcast1(JSPUtil.getParameter(request, "fcast_1", ""));
		setFcast2(JSPUtil.getParameter(request, "fcast_2", ""));
		setFcast3(JSPUtil.getParameter(request, "fcast_3", ""));
		setYqta3(JSPUtil.getParameter(request, "yqta_3", ""));
		setYqta2(JSPUtil.getParameter(request, "yqta_2", ""));
		setYqta1(JSPUtil.getParameter(request, "yqta_1", ""));
		setMdlRst1(JSPUtil.getParameter(request, "mdl_rst_1", ""));
		setModelTot(JSPUtil.getParameter(request, "model_tot", ""));
		setMdlRst2(JSPUtil.getParameter(request, "mdl_rst_2", ""));
		setMdlRst3(JSPUtil.getParameter(request, "mdl_rst_3", ""));
		setRowSeq(JSPUtil.getParameter(request, "row_seq", ""));
		setItem(JSPUtil.getParameter(request, "item", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MonthlyAdjustmentRHQTargetGroupTradeVO[]
	 */
	public MonthlyAdjustmentRHQTargetGroupTradeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MonthlyAdjustmentRHQTargetGroupTradeVO[]
	 */
	public MonthlyAdjustmentRHQTargetGroupTradeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MonthlyAdjustmentRHQTargetGroupTradeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] recentMon = (JSPUtil.getParameter(request, prefix	+ "recent_mon", length));
			String[] slevel = (JSPUtil.getParameter(request, prefix	+ "slevel", length));
			String[] pfmcQta = (JSPUtil.getParameter(request, prefix	+ "pfmc_qta", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] final1 = (JSPUtil.getParameter(request, prefix	+ "final_1", length));
			String[] recentYr = (JSPUtil.getParameter(request, prefix	+ "recent_yr", length));
			String[] final3 = (JSPUtil.getParameter(request, prefix	+ "final_3", length));
			String[] final2 = (JSPUtil.getParameter(request, prefix	+ "final_2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] forecastTot = (JSPUtil.getParameter(request, prefix	+ "forecast_tot", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] initial3 = (JSPUtil.getParameter(request, prefix	+ "initial_3", length));
			String[] initial2 = (JSPUtil.getParameter(request, prefix	+ "initial_2", length));
			String[] itemText = (JSPUtil.getParameter(request, prefix	+ "item_text", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] initial1 = (JSPUtil.getParameter(request, prefix	+ "initial_1", length));
			String[] pfmcSmr = (JSPUtil.getParameter(request, prefix	+ "pfmc_smr", length));
			String[] initialTot = (JSPUtil.getParameter(request, prefix	+ "initial_tot", length));
			String[] finalTot = (JSPUtil.getParameter(request, prefix	+ "final_tot", length));
			String[] fcast1 = (JSPUtil.getParameter(request, prefix	+ "fcast_1", length));
			String[] fcast2 = (JSPUtil.getParameter(request, prefix	+ "fcast_2", length));
			String[] fcast3 = (JSPUtil.getParameter(request, prefix	+ "fcast_3", length));
			String[] yqta3 = (JSPUtil.getParameter(request, prefix	+ "yqta_3", length));
			String[] yqta2 = (JSPUtil.getParameter(request, prefix	+ "yqta_2", length));
			String[] yqta1 = (JSPUtil.getParameter(request, prefix	+ "yqta_1", length));
			String[] mdlRst1 = (JSPUtil.getParameter(request, prefix	+ "mdl_rst_1", length));
			String[] modelTot = (JSPUtil.getParameter(request, prefix	+ "model_tot", length));
			String[] mdlRst2 = (JSPUtil.getParameter(request, prefix	+ "mdl_rst_2", length));
			String[] mdlRst3 = (JSPUtil.getParameter(request, prefix	+ "mdl_rst_3", length));
			String[] rowSeq = (JSPUtil.getParameter(request, prefix	+ "row_seq", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			
			for (int i = 0; i < length; i++) {
				model = new MonthlyAdjustmentRHQTargetGroupTradeVO();
				if (recentMon[i] != null)
					model.setRecentMon(recentMon[i]);
				if (slevel[i] != null)
					model.setSlevel(slevel[i]);
				if (pfmcQta[i] != null)
					model.setPfmcQta(pfmcQta[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (final1[i] != null)
					model.setFinal1(final1[i]);
				if (recentYr[i] != null)
					model.setRecentYr(recentYr[i]);
				if (final3[i] != null)
					model.setFinal3(final3[i]);
				if (final2[i] != null)
					model.setFinal2(final2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (forecastTot[i] != null)
					model.setForecastTot(forecastTot[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (initial3[i] != null)
					model.setInitial3(initial3[i]);
				if (initial2[i] != null)
					model.setInitial2(initial2[i]);
				if (itemText[i] != null)
					model.setItemText(itemText[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (initial1[i] != null)
					model.setInitial1(initial1[i]);
				if (pfmcSmr[i] != null)
					model.setPfmcSmr(pfmcSmr[i]);
				if (initialTot[i] != null)
					model.setInitialTot(initialTot[i]);
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
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMonthlyAdjustmentRHQTargetGroupTradeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MonthlyAdjustmentRHQTargetGroupTradeVO[]
	 */
	public MonthlyAdjustmentRHQTargetGroupTradeVO[] getMonthlyAdjustmentRHQTargetGroupTradeVOs(){
		MonthlyAdjustmentRHQTargetGroupTradeVO[] vos = (MonthlyAdjustmentRHQTargetGroupTradeVO[])models.toArray(new MonthlyAdjustmentRHQTargetGroupTradeVO[models.size()]);
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
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final1 = this.final1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentYr = this.recentYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final3 = this.final3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final2 = this.final2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.forecastTot = this.forecastTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initial3 = this.initial3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initial2 = this.initial2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemText = this.itemText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initial1 = this.initial1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcSmr = this.pfmcSmr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initialTot = this.initialTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalTot = this.finalTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast1 = this.fcast1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast2 = this.fcast2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast3 = this.fcast3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqta3 = this.yqta3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqta2 = this.yqta2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqta1 = this.yqta1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlRst1 = this.mdlRst1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modelTot = this.modelTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlRst2 = this.mdlRst2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlRst3 = this.mdlRst3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq = this.rowSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
