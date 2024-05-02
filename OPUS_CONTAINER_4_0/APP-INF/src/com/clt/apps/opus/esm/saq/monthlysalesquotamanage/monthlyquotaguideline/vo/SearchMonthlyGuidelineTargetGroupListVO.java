/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMonthlyGuidelineTargetGroupListVO.java
*@FileTitle : SearchMonthlyGuidelineTargetGroupListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2009.08.03 김민아 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.vo;

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
 * @author 김민아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyGuidelineTargetGroupListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyGuidelineTargetGroupListVO> models = new ArrayList<SearchMonthlyGuidelineTargetGroupListVO>();
	
	/* Column Info */
	private String finalTgt1 = null;
	/* Column Info */
	private String finalTgt2 = null;
	/* Column Info */
	private String recentMon = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String final1 = null;
	/* Column Info */
	private String recentYr = null;
	/* Column Info */
	private String tradeTot = null;
	/* Column Info */
	private String finalTgt3 = null;
	/* Column Info */
	private String final3 = null;
	/* Column Info */
	private String final2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String adjustedTot = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rhq1 = null;
	/* Column Info */
	private String rhq2 = null;
	/* Column Info */
	private String trade1 = null;
	/* Column Info */
	private String trade2 = null;
	/* Column Info */
	private String trade3 = null;
	/* Column Info */
	private String finalTgtTot = null;
	/* Column Info */
	private String initial3 = null;
	/* Column Info */
	private String subSeq = null;
	/* Column Info */
	private String initial2 = null;
	/* Column Info */
	private String yqtaTot = null;
	/* Column Info */
	private String rhq3 = null;
	/* Column Info */
	private String initial1 = null;
	/* Column Info */
	private String itemText = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String initialTot = null;
	/* Column Info */
	private String finalTot = null;
	/* Column Info */
	private String fcast1 = null;
	/* Column Info */
	private String fcast2 = null;
	/* Column Info */
	private String mdlRstTot = null;
	/* Column Info */
	private String fcast3 = null;
	/* Column Info */
	private String yqta3 = null;
	/* Column Info */
	private String yqta2 = null;
	/* Column Info */
	private String dirSeq = null;
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
	private String mdlRst2 = null;
	/* Column Info */
	private String mdlRst3 = null;
	/* Column Info */
	private String fcastTot = null;
	/* Column Info */
	private String recentTgtMon = null;
	/* Column Info */
	private String rowSeq = null;
	/* Column Info */
	private String item = null;
	

	/* Column Info */
	private String saqStsCd = null;
	/* Column Info */
	private String mqtaMdlVerNo = null;
	/* Column Info */
	private String slsFcastPubNo = null;
	/* Column Info */
	private String trdDir = null;

	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyGuidelineTargetGroupListVO() {}

	public SearchMonthlyGuidelineTargetGroupListVO(String ibflag, String pagerows, String subSeq, String trdCd, String dirSeq, String dirCd, String rowSeq, String itemText, String item, String recentYr, String recentMon, String recentTgtMon, String fcastTot, String mdlRstTot, String yqtaTot, String tradeTot, String rhqTot, String finalTot, String adjustedTot, String initialTot, String finalTgtTot, String fcast1, String mdlRst1, String yqta1, String trade1, String rhq1, String final1, String adjusted1, String initial1, String finalTgt1, String fcast2, String mdlRst2, String yqta2, String trade2, String rhq2, String final2, String adjusted2, String initial2, String finalTgt2, String fcast3, String mdlRst3, String yqta3, String trade3, String rhq3, String final3, String adjusted3, String initial3, String finalTgt3) {
		this.finalTgt1 = finalTgt1;
		this.finalTgt2 = finalTgt2;
		this.recentMon = recentMon;
		this.trdCd = trdCd;
		this.final1 = final1;
		this.recentYr = recentYr;
		this.tradeTot = tradeTot;
		this.finalTgt3 = finalTgt3;
		this.final3 = final3;
		this.final2 = final2;
		this.pagerows = pagerows;
		this.adjustedTot = adjustedTot;
		this.ibflag = ibflag;
		this.rhq1 = rhq1;
		this.rhq2 = rhq2;
		this.trade1 = trade1;
		this.trade2 = trade2;
		this.trade3 = trade3;
		this.finalTgtTot = finalTgtTot;
		this.initial3 = initial3;
		this.subSeq = subSeq;
		this.initial2 = initial2;
		this.yqtaTot = yqtaTot;
		this.rhq3 = rhq3;
		this.initial1 = initial1;
		this.itemText = itemText;
		this.dirCd = dirCd;
		this.initialTot = initialTot;
		this.finalTot = finalTot;
		this.fcast1 = fcast1;
		this.fcast2 = fcast2;
		this.mdlRstTot = mdlRstTot;
		this.fcast3 = fcast3;
		this.yqta3 = yqta3;
		this.yqta2 = yqta2;
		this.dirSeq = dirSeq;
		this.yqta1 = yqta1;
		this.mdlRst1 = mdlRst1;
		this.adjusted3 = adjusted3;
		this.adjusted2 = adjusted2;
		this.rhqTot = rhqTot;
		this.adjusted1 = adjusted1;
		this.mdlRst2 = mdlRst2;
		this.mdlRst3 = mdlRst3;
		this.fcastTot = fcastTot;
		this.recentTgtMon = recentTgtMon;
		this.rowSeq = rowSeq;
		this.item = item;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("final_tgt_1", getFinalTgt1());
		this.hashColumns.put("final_tgt_2", getFinalTgt2());
		this.hashColumns.put("recent_mon", getRecentMon());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("final_1", getFinal1());
		this.hashColumns.put("recent_yr", getRecentYr());
		this.hashColumns.put("trade_tot", getTradeTot());
		this.hashColumns.put("final_tgt_3", getFinalTgt3());
		this.hashColumns.put("final_3", getFinal3());
		this.hashColumns.put("final_2", getFinal2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("adjusted_tot", getAdjustedTot());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rhq_1", getRhq1());
		this.hashColumns.put("rhq_2", getRhq2());
		this.hashColumns.put("trade_1", getTrade1());
		this.hashColumns.put("trade_2", getTrade2());
		this.hashColumns.put("trade_3", getTrade3());
		this.hashColumns.put("final_tgt_tot", getFinalTgtTot());
		this.hashColumns.put("initial_3", getInitial3());
		this.hashColumns.put("sub_seq", getSubSeq());
		this.hashColumns.put("initial_2", getInitial2());
		this.hashColumns.put("yqta_tot", getYqtaTot());
		this.hashColumns.put("rhq_3", getRhq3());
		this.hashColumns.put("initial_1", getInitial1());
		this.hashColumns.put("item_text", getItemText());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("initial_tot", getInitialTot());
		this.hashColumns.put("final_tot", getFinalTot());
		this.hashColumns.put("fcast_1", getFcast1());
		this.hashColumns.put("fcast_2", getFcast2());
		this.hashColumns.put("mdl_rst_tot", getMdlRstTot());
		this.hashColumns.put("fcast_3", getFcast3());
		this.hashColumns.put("yqta_3", getYqta3());
		this.hashColumns.put("yqta_2", getYqta2());
		this.hashColumns.put("dir_seq", getDirSeq());
		this.hashColumns.put("yqta_1", getYqta1());
		this.hashColumns.put("mdl_rst_1", getMdlRst1());
		this.hashColumns.put("adjusted_3", getAdjusted3());
		this.hashColumns.put("adjusted_2", getAdjusted2());
		this.hashColumns.put("rhq_tot", getRhqTot());
		this.hashColumns.put("adjusted_1", getAdjusted1());
		this.hashColumns.put("mdl_rst_2", getMdlRst2());
		this.hashColumns.put("mdl_rst_3", getMdlRst3());
		this.hashColumns.put("fcast_tot", getFcastTot());
		this.hashColumns.put("recent_tgt_mon", getRecentTgtMon());
		this.hashColumns.put("row_seq", getRowSeq());
		this.hashColumns.put("item", getItem());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("final_tgt_1", "finalTgt1");
		this.hashFields.put("final_tgt_2", "finalTgt2");
		this.hashFields.put("recent_mon", "recentMon");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("final_1", "final1");
		this.hashFields.put("recent_yr", "recentYr");
		this.hashFields.put("trade_tot", "tradeTot");
		this.hashFields.put("final_tgt_3", "finalTgt3");
		this.hashFields.put("final_3", "final3");
		this.hashFields.put("final_2", "final2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("adjusted_tot", "adjustedTot");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rhq_1", "rhq1");
		this.hashFields.put("rhq_2", "rhq2");
		this.hashFields.put("trade_1", "trade1");
		this.hashFields.put("trade_2", "trade2");
		this.hashFields.put("trade_3", "trade3");
		this.hashFields.put("final_tgt_tot", "finalTgtTot");
		this.hashFields.put("initial_3", "initial3");
		this.hashFields.put("sub_seq", "subSeq");
		this.hashFields.put("initial_2", "initial2");
		this.hashFields.put("yqta_tot", "yqtaTot");
		this.hashFields.put("rhq_3", "rhq3");
		this.hashFields.put("initial_1", "initial1");
		this.hashFields.put("item_text", "itemText");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("initial_tot", "initialTot");
		this.hashFields.put("final_tot", "finalTot");
		this.hashFields.put("fcast_1", "fcast1");
		this.hashFields.put("fcast_2", "fcast2");
		this.hashFields.put("mdl_rst_tot", "mdlRstTot");
		this.hashFields.put("fcast_3", "fcast3");
		this.hashFields.put("yqta_3", "yqta3");
		this.hashFields.put("yqta_2", "yqta2");
		this.hashFields.put("dir_seq", "dirSeq");
		this.hashFields.put("yqta_1", "yqta1");
		this.hashFields.put("mdl_rst_1", "mdlRst1");
		this.hashFields.put("adjusted_3", "adjusted3");
		this.hashFields.put("adjusted_2", "adjusted2");
		this.hashFields.put("rhq_tot", "rhqTot");
		this.hashFields.put("adjusted_1", "adjusted1");
		this.hashFields.put("mdl_rst_2", "mdlRst2");
		this.hashFields.put("mdl_rst_3", "mdlRst3");
		this.hashFields.put("fcast_tot", "fcastTot");
		this.hashFields.put("recent_tgt_mon", "recentTgtMon");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("item", "item");
		this.hashFields.put("unit", "unit");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return finalTgt1
	 */
	public String getFinalTgt1() {
		return this.finalTgt1;
	}
	
	/**
	 * Column Info
	 * @return finalTgt2
	 */
	public String getFinalTgt2() {
		return this.finalTgt2;
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
	 * @return tradeTot
	 */
	public String getTradeTot() {
		return this.tradeTot;
	}
	
	/**
	 * Column Info
	 * @return finalTgt3
	 */
	public String getFinalTgt3() {
		return this.finalTgt3;
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
	 * @return rhq1
	 */
	public String getRhq1() {
		return this.rhq1;
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
	 * @return finalTgtTot
	 */
	public String getFinalTgtTot() {
		return this.finalTgtTot;
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
	 * @return subSeq
	 */
	public String getSubSeq() {
		return this.subSeq;
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
	 * @return yqtaTot
	 */
	public String getYqtaTot() {
		return this.yqtaTot;
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
	 * @return initial1
	 */
	public String getInitial1() {
		return this.initial1;
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
	 * @return mdlRstTot
	 */
	public String getMdlRstTot() {
		return this.mdlRstTot;
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
	 * @return dirSeq
	 */
	public String getDirSeq() {
		return this.dirSeq;
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
	 * @return fcastTot
	 */
	public String getFcastTot() {
		return this.fcastTot;
	}
	
	/**
	 * Column Info
	 * @return recentTgtMon
	 */
	public String getRecentTgtMon() {
		return this.recentTgtMon;
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
	 * @return saqStsCd
	 */	
	public String getSaqStsCd() {
		return saqStsCd;
	}
	/**
	 * Column Info
	 * @return mqtaMdlVerNo
	 */
	public String getMqtaMdlVerNo() {
		return mqtaMdlVerNo;
	}
	/**
	 * Column Info
	 * @return slsFcastPubNo
	 */
	public String getSlsFcastPubNo() {
		return slsFcastPubNo;
	}
	/**
	 * Column Info
	 * @return trdDir
	 */
	public String getTrdDir() {
		return trdDir;
	}
	
	

	/**
	 * Column Info
	 * @param finalTgt1
	 */
	public void setFinalTgt1(String finalTgt1) {
		this.finalTgt1 = finalTgt1;
	}
	
	/**
	 * Column Info
	 * @param finalTgt2
	 */
	public void setFinalTgt2(String finalTgt2) {
		this.finalTgt2 = finalTgt2;
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
	 * @param tradeTot
	 */
	public void setTradeTot(String tradeTot) {
		this.tradeTot = tradeTot;
	}
	
	/**
	 * Column Info
	 * @param finalTgt3
	 */
	public void setFinalTgt3(String finalTgt3) {
		this.finalTgt3 = finalTgt3;
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
	 * @param rhq1
	 */
	public void setRhq1(String rhq1) {
		this.rhq1 = rhq1;
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
	 * @param finalTgtTot
	 */
	public void setFinalTgtTot(String finalTgtTot) {
		this.finalTgtTot = finalTgtTot;
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
	 * @param subSeq
	 */
	public void setSubSeq(String subSeq) {
		this.subSeq = subSeq;
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
	 * @param yqtaTot
	 */
	public void setYqtaTot(String yqtaTot) {
		this.yqtaTot = yqtaTot;
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
	 * @param initial1
	 */
	public void setInitial1(String initial1) {
		this.initial1 = initial1;
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
	 * @param mdlRstTot
	 */
	public void setMdlRstTot(String mdlRstTot) {
		this.mdlRstTot = mdlRstTot;
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
	 * @param dirSeq
	 */
	public void setDirSeq(String dirSeq) {
		this.dirSeq = dirSeq;
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
	 * @param fcastTot
	 */
	public void setFcastTot(String fcastTot) {
		this.fcastTot = fcastTot;
	}
	
	/**
	 * Column Info
	 * @param recentTgtMon
	 */
	public void setRecentTgtMon(String recentTgtMon) {
		this.recentTgtMon = recentTgtMon;
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
	 * @param saqStsCd
	 */	
	public void setSaqStsCd(String saqStsCd) {
		this.saqStsCd = saqStsCd;
	}
	/**
	 * Column Info
	 * @param mqtaMdlVerNo
	 */
	public void setMqtaMdlVerNo(String mqtaMdlVerNo) {
		this.mqtaMdlVerNo = mqtaMdlVerNo;
	}
	/**
	 * Column Info
	 * @param slsFcastPubNo
	 */
	public void setSlsFcastPubNo(String slsFcastPubNo) {
		this.slsFcastPubNo = slsFcastPubNo;
	}
	/**
	 * Column Info
	 * @param trdDir
	 */
	public void setTrdDir(String trdDir) {
		this.trdDir = trdDir;
	}
	
	
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFinalTgt1(JSPUtil.getParameter(request, "final_tgt_1", ""));
		setFinalTgt2(JSPUtil.getParameter(request, "final_tgt_2", ""));
		setRecentMon(JSPUtil.getParameter(request, "recent_mon", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setFinal1(JSPUtil.getParameter(request, "final_1", ""));
		setRecentYr(JSPUtil.getParameter(request, "recent_yr", ""));
		setTradeTot(JSPUtil.getParameter(request, "trade_tot", ""));
		setFinalTgt3(JSPUtil.getParameter(request, "final_tgt_3", ""));
		setFinal3(JSPUtil.getParameter(request, "final_3", ""));
		setFinal2(JSPUtil.getParameter(request, "final_2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAdjustedTot(JSPUtil.getParameter(request, "adjusted_tot", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRhq1(JSPUtil.getParameter(request, "rhq_1", ""));
		setRhq2(JSPUtil.getParameter(request, "rhq_2", ""));
		setTrade1(JSPUtil.getParameter(request, "trade_1", ""));
		setTrade2(JSPUtil.getParameter(request, "trade_2", ""));
		setTrade3(JSPUtil.getParameter(request, "trade_3", ""));
		setFinalTgtTot(JSPUtil.getParameter(request, "final_tgt_tot", ""));
		setInitial3(JSPUtil.getParameter(request, "initial_3", ""));
		setSubSeq(JSPUtil.getParameter(request, "sub_seq", ""));
		setInitial2(JSPUtil.getParameter(request, "initial_2", ""));
		setYqtaTot(JSPUtil.getParameter(request, "yqta_tot", ""));
		setRhq3(JSPUtil.getParameter(request, "rhq_3", ""));
		setInitial1(JSPUtil.getParameter(request, "initial_1", ""));
		setItemText(JSPUtil.getParameter(request, "item_text", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setInitialTot(JSPUtil.getParameter(request, "initial_tot", ""));
		setFinalTot(JSPUtil.getParameter(request, "final_tot", ""));
		setFcast1(JSPUtil.getParameter(request, "fcast_1", ""));
		setFcast2(JSPUtil.getParameter(request, "fcast_2", ""));
		setMdlRstTot(JSPUtil.getParameter(request, "mdl_rst_tot", ""));
		setFcast3(JSPUtil.getParameter(request, "fcast_3", ""));
		setYqta3(JSPUtil.getParameter(request, "yqta_3", ""));
		setYqta2(JSPUtil.getParameter(request, "yqta_2", ""));
		setDirSeq(JSPUtil.getParameter(request, "dir_seq", ""));
		setYqta1(JSPUtil.getParameter(request, "yqta_1", ""));
		setMdlRst1(JSPUtil.getParameter(request, "mdl_rst_1", ""));
		setAdjusted3(JSPUtil.getParameter(request, "adjusted_3", ""));
		setAdjusted2(JSPUtil.getParameter(request, "adjusted_2", ""));
		setRhqTot(JSPUtil.getParameter(request, "rhq_tot", ""));
		setAdjusted1(JSPUtil.getParameter(request, "adjusted_1", ""));
		setMdlRst2(JSPUtil.getParameter(request, "mdl_rst_2", ""));
		setMdlRst3(JSPUtil.getParameter(request, "mdl_rst_3", ""));
		setFcastTot(JSPUtil.getParameter(request, "fcast_tot", ""));
		setRecentTgtMon(JSPUtil.getParameter(request, "recent_tgt_mon", ""));
		setRowSeq(JSPUtil.getParameter(request, "row_seq", ""));
		setItem(JSPUtil.getParameter(request, "item", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyGuidelineTargetGroupListVO[]
	 */
	public SearchMonthlyGuidelineTargetGroupListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyGuidelineTargetGroupListVO[]
	 */
	public SearchMonthlyGuidelineTargetGroupListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyGuidelineTargetGroupListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] finalTgt1 = (JSPUtil.getParameter(request, prefix	+ "final_tgt_1", length));
			String[] finalTgt2 = (JSPUtil.getParameter(request, prefix	+ "final_tgt_2", length));
			String[] recentMon = (JSPUtil.getParameter(request, prefix	+ "recent_mon", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] final1 = (JSPUtil.getParameter(request, prefix	+ "final_1", length));
			String[] recentYr = (JSPUtil.getParameter(request, prefix	+ "recent_yr", length));
			String[] tradeTot = (JSPUtil.getParameter(request, prefix	+ "trade_tot", length));
			String[] finalTgt3 = (JSPUtil.getParameter(request, prefix	+ "final_tgt_3", length));
			String[] final3 = (JSPUtil.getParameter(request, prefix	+ "final_3", length));
			String[] final2 = (JSPUtil.getParameter(request, prefix	+ "final_2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] adjustedTot = (JSPUtil.getParameter(request, prefix	+ "adjusted_tot", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rhq1 = (JSPUtil.getParameter(request, prefix	+ "rhq_1", length));
			String[] rhq2 = (JSPUtil.getParameter(request, prefix	+ "rhq_2", length));
			String[] trade1 = (JSPUtil.getParameter(request, prefix	+ "trade_1", length));
			String[] trade2 = (JSPUtil.getParameter(request, prefix	+ "trade_2", length));
			String[] trade3 = (JSPUtil.getParameter(request, prefix	+ "trade_3", length));
			String[] finalTgtTot = (JSPUtil.getParameter(request, prefix	+ "final_tgt_tot", length));
			String[] initial3 = (JSPUtil.getParameter(request, prefix	+ "initial_3", length));
			String[] subSeq = (JSPUtil.getParameter(request, prefix	+ "sub_seq", length));
			String[] initial2 = (JSPUtil.getParameter(request, prefix	+ "initial_2", length));
			String[] yqtaTot = (JSPUtil.getParameter(request, prefix	+ "yqta_tot", length));
			String[] rhq3 = (JSPUtil.getParameter(request, prefix	+ "rhq_3", length));
			String[] initial1 = (JSPUtil.getParameter(request, prefix	+ "initial_1", length));
			String[] itemText = (JSPUtil.getParameter(request, prefix	+ "item_text", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] initialTot = (JSPUtil.getParameter(request, prefix	+ "initial_tot", length));
			String[] finalTot = (JSPUtil.getParameter(request, prefix	+ "final_tot", length));
			String[] fcast1 = (JSPUtil.getParameter(request, prefix	+ "fcast_1", length));
			String[] fcast2 = (JSPUtil.getParameter(request, prefix	+ "fcast_2", length));
			String[] mdlRstTot = (JSPUtil.getParameter(request, prefix	+ "mdl_rst_tot", length));
			String[] fcast3 = (JSPUtil.getParameter(request, prefix	+ "fcast_3", length));
			String[] yqta3 = (JSPUtil.getParameter(request, prefix	+ "yqta_3", length));
			String[] yqta2 = (JSPUtil.getParameter(request, prefix	+ "yqta_2", length));
			String[] dirSeq = (JSPUtil.getParameter(request, prefix	+ "dir_seq", length));
			String[] yqta1 = (JSPUtil.getParameter(request, prefix	+ "yqta_1", length));
			String[] mdlRst1 = (JSPUtil.getParameter(request, prefix	+ "mdl_rst_1", length));
			String[] adjusted3 = (JSPUtil.getParameter(request, prefix	+ "adjusted_3", length));
			String[] adjusted2 = (JSPUtil.getParameter(request, prefix	+ "adjusted_2", length));
			String[] rhqTot = (JSPUtil.getParameter(request, prefix	+ "rhq_tot", length));
			String[] adjusted1 = (JSPUtil.getParameter(request, prefix	+ "adjusted_1", length));
			String[] mdlRst2 = (JSPUtil.getParameter(request, prefix	+ "mdl_rst_2", length));
			String[] mdlRst3 = (JSPUtil.getParameter(request, prefix	+ "mdl_rst_3", length));
			String[] fcastTot = (JSPUtil.getParameter(request, prefix	+ "fcast_tot", length));
			String[] recentTgtMon = (JSPUtil.getParameter(request, prefix	+ "recent_tgt_mon", length));
			String[] rowSeq = (JSPUtil.getParameter(request, prefix	+ "row_seq", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyGuidelineTargetGroupListVO();
				if (finalTgt1[i] != null)
					model.setFinalTgt1(finalTgt1[i]);
				if (finalTgt2[i] != null)
					model.setFinalTgt2(finalTgt2[i]);
				if (recentMon[i] != null)
					model.setRecentMon(recentMon[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (final1[i] != null)
					model.setFinal1(final1[i]);
				if (recentYr[i] != null)
					model.setRecentYr(recentYr[i]);
				if (tradeTot[i] != null)
					model.setTradeTot(tradeTot[i]);
				if (finalTgt3[i] != null)
					model.setFinalTgt3(finalTgt3[i]);
				if (final3[i] != null)
					model.setFinal3(final3[i]);
				if (final2[i] != null)
					model.setFinal2(final2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (adjustedTot[i] != null)
					model.setAdjustedTot(adjustedTot[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rhq1[i] != null)
					model.setRhq1(rhq1[i]);
				if (rhq2[i] != null)
					model.setRhq2(rhq2[i]);
				if (trade1[i] != null)
					model.setTrade1(trade1[i]);
				if (trade2[i] != null)
					model.setTrade2(trade2[i]);
				if (trade3[i] != null)
					model.setTrade3(trade3[i]);
				if (finalTgtTot[i] != null)
					model.setFinalTgtTot(finalTgtTot[i]);
				if (initial3[i] != null)
					model.setInitial3(initial3[i]);
				if (subSeq[i] != null)
					model.setSubSeq(subSeq[i]);
				if (initial2[i] != null)
					model.setInitial2(initial2[i]);
				if (yqtaTot[i] != null)
					model.setYqtaTot(yqtaTot[i]);
				if (rhq3[i] != null)
					model.setRhq3(rhq3[i]);
				if (initial1[i] != null)
					model.setInitial1(initial1[i]);
				if (itemText[i] != null)
					model.setItemText(itemText[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (initialTot[i] != null)
					model.setInitialTot(initialTot[i]);
				if (finalTot[i] != null)
					model.setFinalTot(finalTot[i]);
				if (fcast1[i] != null)
					model.setFcast1(fcast1[i]);
				if (fcast2[i] != null)
					model.setFcast2(fcast2[i]);
				if (mdlRstTot[i] != null)
					model.setMdlRstTot(mdlRstTot[i]);
				if (fcast3[i] != null)
					model.setFcast3(fcast3[i]);
				if (yqta3[i] != null)
					model.setYqta3(yqta3[i]);
				if (yqta2[i] != null)
					model.setYqta2(yqta2[i]);
				if (dirSeq[i] != null)
					model.setDirSeq(dirSeq[i]);
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
				if (mdlRst2[i] != null)
					model.setMdlRst2(mdlRst2[i]);
				if (mdlRst3[i] != null)
					model.setMdlRst3(mdlRst3[i]);
				if (fcastTot[i] != null)
					model.setFcastTot(fcastTot[i]);
				if (recentTgtMon[i] != null)
					model.setRecentTgtMon(recentTgtMon[i]);
				if (rowSeq[i] != null)
					model.setRowSeq(rowSeq[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyGuidelineTargetGroupListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyGuidelineTargetGroupListVO[]
	 */
	public SearchMonthlyGuidelineTargetGroupListVO[] getSearchMonthlyGuidelineTargetGroupListVOs(){
		SearchMonthlyGuidelineTargetGroupListVO[] vos = (SearchMonthlyGuidelineTargetGroupListVO[])models.toArray(new SearchMonthlyGuidelineTargetGroupListVO[models.size()]);
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
		this.finalTgt1 = this.finalTgt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalTgt2 = this.finalTgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentMon = this.recentMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final1 = this.final1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentYr = this.recentYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeTot = this.tradeTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalTgt3 = this.finalTgt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final3 = this.final3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final2 = this.final2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjustedTot = this.adjustedTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq1 = this.rhq1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq2 = this.rhq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade1 = this.trade1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade2 = this.trade2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade3 = this.trade3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalTgtTot = this.finalTgtTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initial3 = this.initial3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSeq = this.subSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initial2 = this.initial2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqtaTot = this.yqtaTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq3 = this.rhq3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initial1 = this.initial1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemText = this.itemText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initialTot = this.initialTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalTot = this.finalTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast1 = this.fcast1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast2 = this.fcast2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlRstTot = this.mdlRstTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast3 = this.fcast3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqta3 = this.yqta3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqta2 = this.yqta2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirSeq = this.dirSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqta1 = this.yqta1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlRst1 = this.mdlRst1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjusted3 = this.adjusted3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjusted2 = this.adjusted2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqTot = this.rhqTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjusted1 = this.adjusted1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlRst2 = this.mdlRst2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlRst3 = this.mdlRst3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTot = this.fcastTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentTgtMon = this.recentTgtMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq = this.rowSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
