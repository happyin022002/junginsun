/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchMonthlyAdjustmentTabTargetGroupListVO.java
*@FileTitle : SearchMonthlyAdjustmentTabTargetGroupListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SearchMonthlyAdjustmentTabTargetGroupListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyAdjustmentTabTargetGroupListVO> models = new ArrayList<SearchMonthlyAdjustmentTabTargetGroupListVO>();
	
	/* Column Info */
	private String rlanegrp = null;
	/* Column Info */
	private String rmkcregdt = null;
	/* Column Info */
	private String mqtastepcd = null;
	/* Column Info */
	private String slevel = null;
	/* Column Info */
	private String pfmcQta = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bsagrpcd = null;
	/* Column Info */
	private String final1 = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String recentYr = null;
	/* Column Info */
	private String subjCtnt = null;
	/* Column Info */
	private String final3 = null;
	/* Column Info */
	private String final2 = null;
	/* Column Info */
	private String mqtaverno = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String convDirCd = null;
	/* Column Info */
	private String trade1 = null;
	/* Column Info */
	private String trade2 = null;
	/* Column Info */
	private String trade3 = null;
	/* Column Info */
	private String itemText = null;
	/* Column Info */
	private String yearlyTot = null;
	/* Column Info */
	private String bsemon = null;
	/* Column Info */
	private String key = null;
	/* Column Info */
	private String fcast1 = null;
	/* Column Info */
	private String finalTot = null;
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
	private String sprtGrpCd = null;
	/* Column Info */
	private String bseyr = null;
	/* Column Info */
	private String rowSeq = null;
	/* Column Info */
	private String subjctnt = null;
	/* Column Info */
	private String creseq = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String creofccd = null;
	/* Column Info */
	private String recentMon = null;
	/* Column Info */
	private String tradeTot = null;
	/* Column Info */
	private String ctrtRhqCd = null;
	/* Column Info */
	private String saqstscd = null;
	/* Column Info */
	private String adjustedTot = null;
	/* Column Info */
	private String cmtctnt = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String forecastTot = null;
	/* Column Info */
	private String rhq1 = null;
	/* Column Info */
	private String cmtCtnt = null;
	/* Column Info */
	private String rhq2 = null;
	/* Column Info */
	private String bseqqtrcd = null;
	/* Column Info */
	private String bsaGrpCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rhq3 = null;
	/* Column Info */
	private String rnk = null;
	/* Column Info */
	private String pfmcSmr = null;
	/* Column Info */
	private String sprtgrpcd = null;
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
	private String rmkCreGdt = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String rlaneGrp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchMonthlyAdjustmentTabTargetGroupListVO() {}

	public SearchMonthlyAdjustmentTabTargetGroupListVO(String ibflag, String pagerows, String recentMon, String slevel, String pfmcQta, String final1, String recentYr, String tradeTot, String final3, String final2, String adjustedTot, String forecastTot, String rhq1, String rhq2, String trade1, String trade2, String trade3, String rhq3, String itemText, String dirCd, String pfmcSmr, String yearlyTot, String finalTot, String fcast1, String fcast2, String fcast3, String yqta3, String yqta2, String yqta1, String mdlRst1, String adjusted3, String adjusted2, String rhqTot, String adjusted1, String modelTot, String mdlRst2, String mdlRst3, String rowSeq, String item, String subTrdCd, String trdCd, String key, String ctrtRhqCd, String rlaneCd, String convDirCd, String mqtastepcd, String bseyr, String bseqqtrcd, String mqtaverno, String rlanegrp, String sprtgrpcd, String bsagrpcd, String bsemon, String creseq, String subjctnt, String creofccd, String cmtctnt, String saqstscd, String rmkcregdt, String rnk, String sprtGrpCd, String bsaGrpCd, String rlaneGrp, String subjCtnt, String cmtCtnt, String rmkCreGdt) {
		this.rlanegrp = rlanegrp;
		this.rmkcregdt = rmkcregdt;
		this.mqtastepcd = mqtastepcd;
		this.slevel = slevel;
		this.pfmcQta = pfmcQta;
		this.trdCd = trdCd;
		this.bsagrpcd = bsagrpcd;
		this.final1 = final1;
		this.rlaneCd = rlaneCd;
		this.recentYr = recentYr;
		this.subjCtnt = subjCtnt;
		this.final3 = final3;
		this.final2 = final2;
		this.mqtaverno = mqtaverno;
		this.pagerows = pagerows;
		this.convDirCd = convDirCd;
		this.trade1 = trade1;
		this.trade2 = trade2;
		this.trade3 = trade3;
		this.itemText = itemText;
		this.yearlyTot = yearlyTot;
		this.bsemon = bsemon;
		this.key = key;
		this.fcast1 = fcast1;
		this.finalTot = finalTot;
		this.fcast2 = fcast2;
		this.fcast3 = fcast3;
		this.yqta3 = yqta3;
		this.yqta2 = yqta2;
		this.yqta1 = yqta1;
		this.sprtGrpCd = sprtGrpCd;
		this.bseyr = bseyr;
		this.rowSeq = rowSeq;
		this.subjctnt = subjctnt;
		this.creseq = creseq;
		this.subTrdCd = subTrdCd;
		this.creofccd = creofccd;
		this.recentMon = recentMon;
		this.tradeTot = tradeTot;
		this.ctrtRhqCd = ctrtRhqCd;
		this.saqstscd = saqstscd;
		this.adjustedTot = adjustedTot;
		this.cmtctnt = cmtctnt;
		this.ibflag = ibflag;
		this.forecastTot = forecastTot;
		this.rhq1 = rhq1;
		this.cmtCtnt = cmtCtnt;
		this.rhq2 = rhq2;
		this.bseqqtrcd = bseqqtrcd;
		this.bsaGrpCd = bsaGrpCd;
		this.dirCd = dirCd;
		this.rhq3 = rhq3;
		this.rnk = rnk;
		this.pfmcSmr = pfmcSmr;
		this.sprtgrpcd = sprtgrpcd;
		this.mdlRst1 = mdlRst1;
		this.adjusted3 = adjusted3;
		this.adjusted2 = adjusted2;
		this.rhqTot = rhqTot;
		this.adjusted1 = adjusted1;
		this.modelTot = modelTot;
		this.mdlRst2 = mdlRst2;
		this.mdlRst3 = mdlRst3;
		this.rmkCreGdt = rmkCreGdt;
		this.item = item;
		this.rlaneGrp = rlaneGrp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rlanegrp", getRlanegrp());
		this.hashColumns.put("rmkcregdt", getRmkcregdt());
		this.hashColumns.put("mqtastepcd", getMqtastepcd());
		this.hashColumns.put("slevel", getSlevel());
		this.hashColumns.put("pfmc_qta", getPfmcQta());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bsagrpcd", getBsagrpcd());
		this.hashColumns.put("final_1", getFinal1());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("recent_yr", getRecentYr());
		this.hashColumns.put("subj_ctnt", getSubjCtnt());
		this.hashColumns.put("final_3", getFinal3());
		this.hashColumns.put("final_2", getFinal2());
		this.hashColumns.put("mqtaverno", getMqtaverno());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("conv_dir_cd", getConvDirCd());
		this.hashColumns.put("trade_1", getTrade1());
		this.hashColumns.put("trade_2", getTrade2());
		this.hashColumns.put("trade_3", getTrade3());
		this.hashColumns.put("item_text", getItemText());
		this.hashColumns.put("yearly_tot", getYearlyTot());
		this.hashColumns.put("bsemon", getBsemon());
		this.hashColumns.put("key", getKey());
		this.hashColumns.put("fcast_1", getFcast1());
		this.hashColumns.put("final_tot", getFinalTot());
		this.hashColumns.put("fcast_2", getFcast2());
		this.hashColumns.put("fcast_3", getFcast3());
		this.hashColumns.put("yqta_3", getYqta3());
		this.hashColumns.put("yqta_2", getYqta2());
		this.hashColumns.put("yqta_1", getYqta1());
		this.hashColumns.put("sprt_grp_cd", getSprtGrpCd());
		this.hashColumns.put("bseyr", getBseyr());
		this.hashColumns.put("row_seq", getRowSeq());
		this.hashColumns.put("subjctnt", getSubjctnt());
		this.hashColumns.put("creseq", getCreseq());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("creofccd", getCreofccd());
		this.hashColumns.put("recent_mon", getRecentMon());
		this.hashColumns.put("trade_tot", getTradeTot());
		this.hashColumns.put("ctrt_rhq_cd", getCtrtRhqCd());
		this.hashColumns.put("saqstscd", getSaqstscd());
		this.hashColumns.put("adjusted_tot", getAdjustedTot());
		this.hashColumns.put("cmtctnt", getCmtctnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("forecast_tot", getForecastTot());
		this.hashColumns.put("rhq_1", getRhq1());
		this.hashColumns.put("cmt_ctnt", getCmtCtnt());
		this.hashColumns.put("rhq_2", getRhq2());
		this.hashColumns.put("bseqqtrcd", getBseqqtrcd());
		this.hashColumns.put("bsa_grp_cd", getBsaGrpCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rhq_3", getRhq3());
		this.hashColumns.put("rnk", getRnk());
		this.hashColumns.put("pfmc_smr", getPfmcSmr());
		this.hashColumns.put("sprtgrpcd", getSprtgrpcd());
		this.hashColumns.put("mdl_rst_1", getMdlRst1());
		this.hashColumns.put("adjusted_3", getAdjusted3());
		this.hashColumns.put("adjusted_2", getAdjusted2());
		this.hashColumns.put("rhq_tot", getRhqTot());
		this.hashColumns.put("adjusted_1", getAdjusted1());
		this.hashColumns.put("model_tot", getModelTot());
		this.hashColumns.put("mdl_rst_2", getMdlRst2());
		this.hashColumns.put("mdl_rst_3", getMdlRst3());
		this.hashColumns.put("rmk_cre_gdt", getRmkCreGdt());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("rlane_grp", getRlaneGrp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rlanegrp", "rlanegrp");
		this.hashFields.put("rmkcregdt", "rmkcregdt");
		this.hashFields.put("mqtastepcd", "mqtastepcd");
		this.hashFields.put("slevel", "slevel");
		this.hashFields.put("pfmc_qta", "pfmcQta");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bsagrpcd", "bsagrpcd");
		this.hashFields.put("final_1", "final1");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("recent_yr", "recentYr");
		this.hashFields.put("subj_ctnt", "subjCtnt");
		this.hashFields.put("final_3", "final3");
		this.hashFields.put("final_2", "final2");
		this.hashFields.put("mqtaverno", "mqtaverno");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("conv_dir_cd", "convDirCd");
		this.hashFields.put("trade_1", "trade1");
		this.hashFields.put("trade_2", "trade2");
		this.hashFields.put("trade_3", "trade3");
		this.hashFields.put("item_text", "itemText");
		this.hashFields.put("yearly_tot", "yearlyTot");
		this.hashFields.put("bsemon", "bsemon");
		this.hashFields.put("key", "key");
		this.hashFields.put("fcast_1", "fcast1");
		this.hashFields.put("final_tot", "finalTot");
		this.hashFields.put("fcast_2", "fcast2");
		this.hashFields.put("fcast_3", "fcast3");
		this.hashFields.put("yqta_3", "yqta3");
		this.hashFields.put("yqta_2", "yqta2");
		this.hashFields.put("yqta_1", "yqta1");
		this.hashFields.put("sprt_grp_cd", "sprtGrpCd");
		this.hashFields.put("bseyr", "bseyr");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("subjctnt", "subjctnt");
		this.hashFields.put("creseq", "creseq");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("creofccd", "creofccd");
		this.hashFields.put("recent_mon", "recentMon");
		this.hashFields.put("trade_tot", "tradeTot");
		this.hashFields.put("ctrt_rhq_cd", "ctrtRhqCd");
		this.hashFields.put("saqstscd", "saqstscd");
		this.hashFields.put("adjusted_tot", "adjustedTot");
		this.hashFields.put("cmtctnt", "cmtctnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("forecast_tot", "forecastTot");
		this.hashFields.put("rhq_1", "rhq1");
		this.hashFields.put("cmt_ctnt", "cmtCtnt");
		this.hashFields.put("rhq_2", "rhq2");
		this.hashFields.put("bseqqtrcd", "bseqqtrcd");
		this.hashFields.put("bsa_grp_cd", "bsaGrpCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rhq_3", "rhq3");
		this.hashFields.put("rnk", "rnk");
		this.hashFields.put("pfmc_smr", "pfmcSmr");
		this.hashFields.put("sprtgrpcd", "sprtgrpcd");
		this.hashFields.put("mdl_rst_1", "mdlRst1");
		this.hashFields.put("adjusted_3", "adjusted3");
		this.hashFields.put("adjusted_2", "adjusted2");
		this.hashFields.put("rhq_tot", "rhqTot");
		this.hashFields.put("adjusted_1", "adjusted1");
		this.hashFields.put("model_tot", "modelTot");
		this.hashFields.put("mdl_rst_2", "mdlRst2");
		this.hashFields.put("mdl_rst_3", "mdlRst3");
		this.hashFields.put("rmk_cre_gdt", "rmkCreGdt");
		this.hashFields.put("item", "item");
		this.hashFields.put("rlane_grp", "rlaneGrp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rlanegrp
	 */
	public String getRlanegrp() {
		return this.rlanegrp;
	}
	
	/**
	 * Column Info
	 * @return rmkcregdt
	 */
	public String getRmkcregdt() {
		return this.rmkcregdt;
	}
	
	/**
	 * Column Info
	 * @return mqtastepcd
	 */
	public String getMqtastepcd() {
		return this.mqtastepcd;
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
	 * @return bsagrpcd
	 */
	public String getBsagrpcd() {
		return this.bsagrpcd;
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
	 * @return subjCtnt
	 */
	public String getSubjCtnt() {
		return this.subjCtnt;
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
	 * @return mqtaverno
	 */
	public String getMqtaverno() {
		return this.mqtaverno;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return itemText
	 */
	public String getItemText() {
		return this.itemText;
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
	 * @return bsemon
	 */
	public String getBsemon() {
		return this.bsemon;
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
	 * @return fcast1
	 */
	public String getFcast1() {
		return this.fcast1;
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
	 * @return sprtGrpCd
	 */
	public String getSprtGrpCd() {
		return this.sprtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return bseyr
	 */
	public String getBseyr() {
		return this.bseyr;
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
	 * @return subjctnt
	 */
	public String getSubjctnt() {
		return this.subjctnt;
	}
	
	/**
	 * Column Info
	 * @return creseq
	 */
	public String getCreseq() {
		return this.creseq;
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
	 * @return creofccd
	 */
	public String getCreofccd() {
		return this.creofccd;
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
	 * @return tradeTot
	 */
	public String getTradeTot() {
		return this.tradeTot;
	}
	
	/**
	 * Column Info
	 * @return ctrtRhqCd
	 */
	public String getCtrtRhqCd() {
		return this.ctrtRhqCd;
	}
	
	/**
	 * Column Info
	 * @return saqstscd
	 */
	public String getSaqstscd() {
		return this.saqstscd;
	}
	
	/**
	 * Column Info
	 * @return adjustedTot
	 */
	public String getAdjustedTot() {
		return this.adjustedTot;
	}
	
	/**
	 * Column Info
	 * @return cmtctnt
	 */
	public String getCmtctnt() {
		return this.cmtctnt;
	}
	
	/**
	 * Column Info
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
	 * @return cmtCtnt
	 */
	public String getCmtCtnt() {
		return this.cmtCtnt;
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
	 * @return bseqqtrcd
	 */
	public String getBseqqtrcd() {
		return this.bseqqtrcd;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
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
	 * @return rnk
	 */
	public String getRnk() {
		return this.rnk;
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
	 * @return sprtgrpcd
	 */
	public String getSprtgrpcd() {
		return this.sprtgrpcd;
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
	 * @return rmkCreGdt
	 */
	public String getRmkCreGdt() {
		return this.rmkCreGdt;
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
	 * @return rlaneGrp
	 */
	public String getRlaneGrp() {
		return this.rlaneGrp;
	}
	

	/**
	 * Column Info
	 * @param rlanegrp
	 */
	public void setRlanegrp(String rlanegrp) {
		this.rlanegrp = rlanegrp;
	}
	
	/**
	 * Column Info
	 * @param rmkcregdt
	 */
	public void setRmkcregdt(String rmkcregdt) {
		this.rmkcregdt = rmkcregdt;
	}
	
	/**
	 * Column Info
	 * @param mqtastepcd
	 */
	public void setMqtastepcd(String mqtastepcd) {
		this.mqtastepcd = mqtastepcd;
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
	 * @param bsagrpcd
	 */
	public void setBsagrpcd(String bsagrpcd) {
		this.bsagrpcd = bsagrpcd;
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
	 * @param subjCtnt
	 */
	public void setSubjCtnt(String subjCtnt) {
		this.subjCtnt = subjCtnt;
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
	 * @param mqtaverno
	 */
	public void setMqtaverno(String mqtaverno) {
		this.mqtaverno = mqtaverno;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param itemText
	 */
	public void setItemText(String itemText) {
		this.itemText = itemText;
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
	 * @param bsemon
	 */
	public void setBsemon(String bsemon) {
		this.bsemon = bsemon;
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
	 * @param fcast1
	 */
	public void setFcast1(String fcast1) {
		this.fcast1 = fcast1;
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
	 * @param sprtGrpCd
	 */
	public void setSprtGrpCd(String sprtGrpCd) {
		this.sprtGrpCd = sprtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param bseyr
	 */
	public void setBseyr(String bseyr) {
		this.bseyr = bseyr;
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
	 * @param subjctnt
	 */
	public void setSubjctnt(String subjctnt) {
		this.subjctnt = subjctnt;
	}
	
	/**
	 * Column Info
	 * @param creseq
	 */
	public void setCreseq(String creseq) {
		this.creseq = creseq;
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
	 * @param creofccd
	 */
	public void setCreofccd(String creofccd) {
		this.creofccd = creofccd;
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
	 * @param tradeTot
	 */
	public void setTradeTot(String tradeTot) {
		this.tradeTot = tradeTot;
	}
	
	/**
	 * Column Info
	 * @param ctrtRhqCd
	 */
	public void setCtrtRhqCd(String ctrtRhqCd) {
		this.ctrtRhqCd = ctrtRhqCd;
	}
	
	/**
	 * Column Info
	 * @param saqstscd
	 */
	public void setSaqstscd(String saqstscd) {
		this.saqstscd = saqstscd;
	}
	
	/**
	 * Column Info
	 * @param adjustedTot
	 */
	public void setAdjustedTot(String adjustedTot) {
		this.adjustedTot = adjustedTot;
	}
	
	/**
	 * Column Info
	 * @param cmtctnt
	 */
	public void setCmtctnt(String cmtctnt) {
		this.cmtctnt = cmtctnt;
	}
	
	/**
	 * Column Info
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
	 * @param cmtCtnt
	 */
	public void setCmtCtnt(String cmtCtnt) {
		this.cmtCtnt = cmtCtnt;
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
	 * @param bseqqtrcd
	 */
	public void setBseqqtrcd(String bseqqtrcd) {
		this.bseqqtrcd = bseqqtrcd;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
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
	 * @param rnk
	 */
	public void setRnk(String rnk) {
		this.rnk = rnk;
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
	 * @param sprtgrpcd
	 */
	public void setSprtgrpcd(String sprtgrpcd) {
		this.sprtgrpcd = sprtgrpcd;
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
	 * @param rmkCreGdt
	 */
	public void setRmkCreGdt(String rmkCreGdt) {
		this.rmkCreGdt = rmkCreGdt;
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
	 * @param rlaneGrp
	 */
	public void setRlaneGrp(String rlaneGrp) {
		this.rlaneGrp = rlaneGrp;
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
		setRlanegrp(JSPUtil.getParameter(request, prefix + "rlanegrp", ""));
		setRmkcregdt(JSPUtil.getParameter(request, prefix + "rmkcregdt", ""));
		setMqtastepcd(JSPUtil.getParameter(request, prefix + "mqtastepcd", ""));
		setSlevel(JSPUtil.getParameter(request, prefix + "slevel", ""));
		setPfmcQta(JSPUtil.getParameter(request, prefix + "pfmc_qta", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setBsagrpcd(JSPUtil.getParameter(request, prefix + "bsagrpcd", ""));
		setFinal1(JSPUtil.getParameter(request, prefix + "final_1", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setRecentYr(JSPUtil.getParameter(request, prefix + "recent_yr", ""));
		setSubjCtnt(JSPUtil.getParameter(request, prefix + "subj_ctnt", ""));
		setFinal3(JSPUtil.getParameter(request, prefix + "final_3", ""));
		setFinal2(JSPUtil.getParameter(request, prefix + "final_2", ""));
		setMqtaverno(JSPUtil.getParameter(request, prefix + "mqtaverno", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setConvDirCd(JSPUtil.getParameter(request, prefix + "conv_dir_cd", ""));
		setTrade1(JSPUtil.getParameter(request, prefix + "trade_1", ""));
		setTrade2(JSPUtil.getParameter(request, prefix + "trade_2", ""));
		setTrade3(JSPUtil.getParameter(request, prefix + "trade_3", ""));
		setItemText(JSPUtil.getParameter(request, prefix + "item_text", ""));
		setYearlyTot(JSPUtil.getParameter(request, prefix + "yearly_tot", ""));
		setBsemon(JSPUtil.getParameter(request, prefix + "bsemon", ""));
		setKey(JSPUtil.getParameter(request, prefix + "key", ""));
		setFcast1(JSPUtil.getParameter(request, prefix + "fcast_1", ""));
		setFinalTot(JSPUtil.getParameter(request, prefix + "final_tot", ""));
		setFcast2(JSPUtil.getParameter(request, prefix + "fcast_2", ""));
		setFcast3(JSPUtil.getParameter(request, prefix + "fcast_3", ""));
		setYqta3(JSPUtil.getParameter(request, prefix + "yqta_3", ""));
		setYqta2(JSPUtil.getParameter(request, prefix + "yqta_2", ""));
		setYqta1(JSPUtil.getParameter(request, prefix + "yqta_1", ""));
		setSprtGrpCd(JSPUtil.getParameter(request, prefix + "sprt_grp_cd", ""));
		setBseyr(JSPUtil.getParameter(request, prefix + "bseyr", ""));
		setRowSeq(JSPUtil.getParameter(request, prefix + "row_seq", ""));
		setSubjctnt(JSPUtil.getParameter(request, prefix + "subjctnt", ""));
		setCreseq(JSPUtil.getParameter(request, prefix + "creseq", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setCreofccd(JSPUtil.getParameter(request, prefix + "creofccd", ""));
		setRecentMon(JSPUtil.getParameter(request, prefix + "recent_mon", ""));
		setTradeTot(JSPUtil.getParameter(request, prefix + "trade_tot", ""));
		setCtrtRhqCd(JSPUtil.getParameter(request, prefix + "ctrt_rhq_cd", ""));
		setSaqstscd(JSPUtil.getParameter(request, prefix + "saqstscd", ""));
		setAdjustedTot(JSPUtil.getParameter(request, prefix + "adjusted_tot", ""));
		setCmtctnt(JSPUtil.getParameter(request, prefix + "cmtctnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setForecastTot(JSPUtil.getParameter(request, prefix + "forecast_tot", ""));
		setRhq1(JSPUtil.getParameter(request, prefix + "rhq_1", ""));
		setCmtCtnt(JSPUtil.getParameter(request, prefix + "cmt_ctnt", ""));
		setRhq2(JSPUtil.getParameter(request, prefix + "rhq_2", ""));
		setBseqqtrcd(JSPUtil.getParameter(request, prefix + "bseqqtrcd", ""));
		setBsaGrpCd(JSPUtil.getParameter(request, prefix + "bsa_grp_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setRhq3(JSPUtil.getParameter(request, prefix + "rhq_3", ""));
		setRnk(JSPUtil.getParameter(request, prefix + "rnk", ""));
		setPfmcSmr(JSPUtil.getParameter(request, prefix + "pfmc_smr", ""));
		setSprtgrpcd(JSPUtil.getParameter(request, prefix + "sprtgrpcd", ""));
		setMdlRst1(JSPUtil.getParameter(request, prefix + "mdl_rst_1", ""));
		setAdjusted3(JSPUtil.getParameter(request, prefix + "adjusted_3", ""));
		setAdjusted2(JSPUtil.getParameter(request, prefix + "adjusted_2", ""));
		setRhqTot(JSPUtil.getParameter(request, prefix + "rhq_tot", ""));
		setAdjusted1(JSPUtil.getParameter(request, prefix + "adjusted_1", ""));
		setModelTot(JSPUtil.getParameter(request, prefix + "model_tot", ""));
		setMdlRst2(JSPUtil.getParameter(request, prefix + "mdl_rst_2", ""));
		setMdlRst3(JSPUtil.getParameter(request, prefix + "mdl_rst_3", ""));
		setRmkCreGdt(JSPUtil.getParameter(request, prefix + "rmk_cre_gdt", ""));
		setItem(JSPUtil.getParameter(request, prefix + "item", ""));
		setRlaneGrp(JSPUtil.getParameter(request, prefix + "rlane_grp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyAdjustmentTabTargetGroupListVO[]
	 */
	public SearchMonthlyAdjustmentTabTargetGroupListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyAdjustmentTabTargetGroupListVO[]
	 */
	public SearchMonthlyAdjustmentTabTargetGroupListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyAdjustmentTabTargetGroupListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rlanegrp = (JSPUtil.getParameter(request, prefix	+ "rlanegrp", length));
			String[] rmkcregdt = (JSPUtil.getParameter(request, prefix	+ "rmkcregdt", length));
			String[] mqtastepcd = (JSPUtil.getParameter(request, prefix	+ "mqtastepcd", length));
			String[] slevel = (JSPUtil.getParameter(request, prefix	+ "slevel", length));
			String[] pfmcQta = (JSPUtil.getParameter(request, prefix	+ "pfmc_qta", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bsagrpcd = (JSPUtil.getParameter(request, prefix	+ "bsagrpcd", length));
			String[] final1 = (JSPUtil.getParameter(request, prefix	+ "final_1", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] recentYr = (JSPUtil.getParameter(request, prefix	+ "recent_yr", length));
			String[] subjCtnt = (JSPUtil.getParameter(request, prefix	+ "subj_ctnt", length));
			String[] final3 = (JSPUtil.getParameter(request, prefix	+ "final_3", length));
			String[] final2 = (JSPUtil.getParameter(request, prefix	+ "final_2", length));
			String[] mqtaverno = (JSPUtil.getParameter(request, prefix	+ "mqtaverno", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			String[] trade1 = (JSPUtil.getParameter(request, prefix	+ "trade_1", length));
			String[] trade2 = (JSPUtil.getParameter(request, prefix	+ "trade_2", length));
			String[] trade3 = (JSPUtil.getParameter(request, prefix	+ "trade_3", length));
			String[] itemText = (JSPUtil.getParameter(request, prefix	+ "item_text", length));
			String[] yearlyTot = (JSPUtil.getParameter(request, prefix	+ "yearly_tot", length));
			String[] bsemon = (JSPUtil.getParameter(request, prefix	+ "bsemon", length));
			String[] key = (JSPUtil.getParameter(request, prefix	+ "key", length));
			String[] fcast1 = (JSPUtil.getParameter(request, prefix	+ "fcast_1", length));
			String[] finalTot = (JSPUtil.getParameter(request, prefix	+ "final_tot", length));
			String[] fcast2 = (JSPUtil.getParameter(request, prefix	+ "fcast_2", length));
			String[] fcast3 = (JSPUtil.getParameter(request, prefix	+ "fcast_3", length));
			String[] yqta3 = (JSPUtil.getParameter(request, prefix	+ "yqta_3", length));
			String[] yqta2 = (JSPUtil.getParameter(request, prefix	+ "yqta_2", length));
			String[] yqta1 = (JSPUtil.getParameter(request, prefix	+ "yqta_1", length));
			String[] sprtGrpCd = (JSPUtil.getParameter(request, prefix	+ "sprt_grp_cd", length));
			String[] bseyr = (JSPUtil.getParameter(request, prefix	+ "bseyr", length));
			String[] rowSeq = (JSPUtil.getParameter(request, prefix	+ "row_seq", length));
			String[] subjctnt = (JSPUtil.getParameter(request, prefix	+ "subjctnt", length));
			String[] creseq = (JSPUtil.getParameter(request, prefix	+ "creseq", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] creofccd = (JSPUtil.getParameter(request, prefix	+ "creofccd", length));
			String[] recentMon = (JSPUtil.getParameter(request, prefix	+ "recent_mon", length));
			String[] tradeTot = (JSPUtil.getParameter(request, prefix	+ "trade_tot", length));
			String[] ctrtRhqCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_rhq_cd", length));
			String[] saqstscd = (JSPUtil.getParameter(request, prefix	+ "saqstscd", length));
			String[] adjustedTot = (JSPUtil.getParameter(request, prefix	+ "adjusted_tot", length));
			String[] cmtctnt = (JSPUtil.getParameter(request, prefix	+ "cmtctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] forecastTot = (JSPUtil.getParameter(request, prefix	+ "forecast_tot", length));
			String[] rhq1 = (JSPUtil.getParameter(request, prefix	+ "rhq_1", length));
			String[] cmtCtnt = (JSPUtil.getParameter(request, prefix	+ "cmt_ctnt", length));
			String[] rhq2 = (JSPUtil.getParameter(request, prefix	+ "rhq_2", length));
			String[] bseqqtrcd = (JSPUtil.getParameter(request, prefix	+ "bseqqtrcd", length));
			String[] bsaGrpCd = (JSPUtil.getParameter(request, prefix	+ "bsa_grp_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rhq3 = (JSPUtil.getParameter(request, prefix	+ "rhq_3", length));
			String[] rnk = (JSPUtil.getParameter(request, prefix	+ "rnk", length));
			String[] pfmcSmr = (JSPUtil.getParameter(request, prefix	+ "pfmc_smr", length));
			String[] sprtgrpcd = (JSPUtil.getParameter(request, prefix	+ "sprtgrpcd", length));
			String[] mdlRst1 = (JSPUtil.getParameter(request, prefix	+ "mdl_rst_1", length));
			String[] adjusted3 = (JSPUtil.getParameter(request, prefix	+ "adjusted_3", length));
			String[] adjusted2 = (JSPUtil.getParameter(request, prefix	+ "adjusted_2", length));
			String[] rhqTot = (JSPUtil.getParameter(request, prefix	+ "rhq_tot", length));
			String[] adjusted1 = (JSPUtil.getParameter(request, prefix	+ "adjusted_1", length));
			String[] modelTot = (JSPUtil.getParameter(request, prefix	+ "model_tot", length));
			String[] mdlRst2 = (JSPUtil.getParameter(request, prefix	+ "mdl_rst_2", length));
			String[] mdlRst3 = (JSPUtil.getParameter(request, prefix	+ "mdl_rst_3", length));
			String[] rmkCreGdt = (JSPUtil.getParameter(request, prefix	+ "rmk_cre_gdt", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] rlaneGrp = (JSPUtil.getParameter(request, prefix	+ "rlane_grp", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyAdjustmentTabTargetGroupListVO();
				if (rlanegrp[i] != null)
					model.setRlanegrp(rlanegrp[i]);
				if (rmkcregdt[i] != null)
					model.setRmkcregdt(rmkcregdt[i]);
				if (mqtastepcd[i] != null)
					model.setMqtastepcd(mqtastepcd[i]);
				if (slevel[i] != null)
					model.setSlevel(slevel[i]);
				if (pfmcQta[i] != null)
					model.setPfmcQta(pfmcQta[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bsagrpcd[i] != null)
					model.setBsagrpcd(bsagrpcd[i]);
				if (final1[i] != null)
					model.setFinal1(final1[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (recentYr[i] != null)
					model.setRecentYr(recentYr[i]);
				if (subjCtnt[i] != null)
					model.setSubjCtnt(subjCtnt[i]);
				if (final3[i] != null)
					model.setFinal3(final3[i]);
				if (final2[i] != null)
					model.setFinal2(final2[i]);
				if (mqtaverno[i] != null)
					model.setMqtaverno(mqtaverno[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				if (trade1[i] != null)
					model.setTrade1(trade1[i]);
				if (trade2[i] != null)
					model.setTrade2(trade2[i]);
				if (trade3[i] != null)
					model.setTrade3(trade3[i]);
				if (itemText[i] != null)
					model.setItemText(itemText[i]);
				if (yearlyTot[i] != null)
					model.setYearlyTot(yearlyTot[i]);
				if (bsemon[i] != null)
					model.setBsemon(bsemon[i]);
				if (key[i] != null)
					model.setKey(key[i]);
				if (fcast1[i] != null)
					model.setFcast1(fcast1[i]);
				if (finalTot[i] != null)
					model.setFinalTot(finalTot[i]);
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
				if (sprtGrpCd[i] != null)
					model.setSprtGrpCd(sprtGrpCd[i]);
				if (bseyr[i] != null)
					model.setBseyr(bseyr[i]);
				if (rowSeq[i] != null)
					model.setRowSeq(rowSeq[i]);
				if (subjctnt[i] != null)
					model.setSubjctnt(subjctnt[i]);
				if (creseq[i] != null)
					model.setCreseq(creseq[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (creofccd[i] != null)
					model.setCreofccd(creofccd[i]);
				if (recentMon[i] != null)
					model.setRecentMon(recentMon[i]);
				if (tradeTot[i] != null)
					model.setTradeTot(tradeTot[i]);
				if (ctrtRhqCd[i] != null)
					model.setCtrtRhqCd(ctrtRhqCd[i]);
				if (saqstscd[i] != null)
					model.setSaqstscd(saqstscd[i]);
				if (adjustedTot[i] != null)
					model.setAdjustedTot(adjustedTot[i]);
				if (cmtctnt[i] != null)
					model.setCmtctnt(cmtctnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (forecastTot[i] != null)
					model.setForecastTot(forecastTot[i]);
				if (rhq1[i] != null)
					model.setRhq1(rhq1[i]);
				if (cmtCtnt[i] != null)
					model.setCmtCtnt(cmtCtnt[i]);
				if (rhq2[i] != null)
					model.setRhq2(rhq2[i]);
				if (bseqqtrcd[i] != null)
					model.setBseqqtrcd(bseqqtrcd[i]);
				if (bsaGrpCd[i] != null)
					model.setBsaGrpCd(bsaGrpCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rhq3[i] != null)
					model.setRhq3(rhq3[i]);
				if (rnk[i] != null)
					model.setRnk(rnk[i]);
				if (pfmcSmr[i] != null)
					model.setPfmcSmr(pfmcSmr[i]);
				if (sprtgrpcd[i] != null)
					model.setSprtgrpcd(sprtgrpcd[i]);
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
				if (rmkCreGdt[i] != null)
					model.setRmkCreGdt(rmkCreGdt[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (rlaneGrp[i] != null)
					model.setRlaneGrp(rlaneGrp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyAdjustmentTabTargetGroupListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyAdjustmentTabTargetGroupListVO[]
	 */
	public SearchMonthlyAdjustmentTabTargetGroupListVO[] getSearchMonthlyAdjustmentTabTargetGroupListVOs(){
		SearchMonthlyAdjustmentTabTargetGroupListVO[] vos = (SearchMonthlyAdjustmentTabTargetGroupListVO[])models.toArray(new SearchMonthlyAdjustmentTabTargetGroupListVO[models.size()]);
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
		this.rlanegrp = this.rlanegrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmkcregdt = this.rmkcregdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqtastepcd = this.mqtastepcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slevel = this.slevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcQta = this.pfmcQta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsagrpcd = this.bsagrpcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final1 = this.final1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentYr = this.recentYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subjCtnt = this.subjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final3 = this.final3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final2 = this.final2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqtaverno = this.mqtaverno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade1 = this.trade1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade2 = this.trade2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade3 = this.trade3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemText = this.itemText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearlyTot = this.yearlyTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsemon = this.bsemon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key = this.key .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast1 = this.fcast1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalTot = this.finalTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast2 = this.fcast2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast3 = this.fcast3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqta3 = this.yqta3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqta2 = this.yqta2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqta1 = this.yqta1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtGrpCd = this.sprtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseyr = this.bseyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq = this.rowSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subjctnt = this.subjctnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creseq = this.creseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creofccd = this.creofccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentMon = this.recentMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeTot = this.tradeTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRhqCd = this.ctrtRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saqstscd = this.saqstscd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjustedTot = this.adjustedTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmtctnt = this.cmtctnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.forecastTot = this.forecastTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq1 = this.rhq1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmtCtnt = this.cmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq2 = this.rhq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseqqtrcd = this.bseqqtrcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaGrpCd = this.bsaGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq3 = this.rhq3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnk = this.rnk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcSmr = this.pfmcSmr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtgrpcd = this.sprtgrpcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlRst1 = this.mdlRst1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjusted3 = this.adjusted3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjusted2 = this.adjusted2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqTot = this.rhqTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjusted1 = this.adjusted1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modelTot = this.modelTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlRst2 = this.mdlRst2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlRst3 = this.mdlRst3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmkCreGdt = this.rmkCreGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneGrp = this.rlaneGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
