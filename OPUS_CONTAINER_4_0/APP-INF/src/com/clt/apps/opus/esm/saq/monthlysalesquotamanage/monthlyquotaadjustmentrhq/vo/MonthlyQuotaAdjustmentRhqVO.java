/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentRhqVO.java
*@FileTitle : MonthlyQuotaAdjustmentRhqVO
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

public class MonthlyQuotaAdjustmentRhqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MonthlyQuotaAdjustmentRhqVO> models = new ArrayList<MonthlyQuotaAdjustmentRhqVO>();
	
	/* Column Info */
	private String initial01 = null;
	/* Column Info */
	private String cmUcAmt = null;
	/* Column Info */
	private String polSeq = null;
	/* Column Info */
	private String recentYearly = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lowQty = null;
	/* Column Info */
	private String convLaneGrp = null;
	/* Column Info */
	private String bsaGrpCd = null;
	/* Column Info */
	private String rgnGrp = null;
	/* Column Info */
	private String totBsa = null;
	/* Column Info */
	private String key = null;
	/* Column Info */
	private String itemCode = null;
	/* Column Info */
	private String fcast01 = null;
	/* Column Info */
	private String raOpfitUcAmt = null;
	/* Column Info */
	private String ctrtAqCd = null;
	/* Column Info */
	private String opfitUcAmt = null;
	/* Column Info */
	private String totRpb = null;
	/* Column Info */
	private String laneGrp = null;
	/* Column Info */
	private String yearly01 = null;
	/* Column Info */
	private String final01 = null;
	/* Column Info */
	private String ctrtRgnOfcCd = null;
	/* Column Info */
	private String sprtGrpCd = null;
	/* Column Info */
	private String podSeq = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String raCmUcAmt = null;
	/* Column Info */
	private String rowSeq = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String totLod = null;
	/* Column Info */
	private String recentMonthly = null;
	/* Column Info */
	private String model01 = null;
	/* Column Info */
	private String subTrdCd = null;
	
	//key값 조회시 사용할 멤버변수
	/* Column Info */
	private String inclPortFlg = null;
	/* Column Info */
	private String slsFcastPubNo = null;
	/* Column Info */
	private String saqStsCd = null;
	/* Column Info */
	private String mqtaMdlVerNo = null;
	
	//상단 리스트
	private String recentMon = null;

	private String slevel = null;

	private String pfmcQta = null;


	private String final1 = null;

	private String recentYr = null;

	private String final3 = null;

	private String final2 = null;
	private String trdCd = null;
	private String dirCd = null;

	private String forecastTot = null;

	private String initial3 = null;

	private String initial2 = null;

	private String itemText = null;


	private String initial1 = null;

	private String pfmcSmr = null;

	private String initialTot = null;

	private String finalTot = null;

	private String fcast1 = null;

	private String fcast2 = null;

	private String fcast3 = null;

	private String yqta3 = null;

	private String yqta2 = null;

	private String yqta1 = null;

	private String mdlRst1 = null;

	private String modelTot = null;

	private String mdlRst2 = null;

	private String mdlRst3 = null;
	
	private String convDirCd = null;


	//remark조회
	private String creSeq = null;
	private String bseYr = null;
	private String subjCtnt = null;
	private String bseMon = null;
	private String bseQtrCd = null;
//	private String trdCd = null;
//	private String saqStsCd = null;
//	private String rlaneCd = null;
//	private String ctrtRgnOfcCd = null;
//	private String sprtGrpCd = null;
//	private String podCd = null;
//	private String polCd = null;
//	private String bsaGrpCd = null;
//	private String dirCd = null;

	private String cmtCtnt = null;
	private String creOfcCd = null;
	private String mqtaStepCd = null;
	private String rmkCreGdt = null;
	private String rnk = null;
	private String mqtaVerNo = null;
	private String rlaneGrp = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MonthlyQuotaAdjustmentRhqVO() {}

	public MonthlyQuotaAdjustmentRhqVO(String ibflag, String pagerows, String key, String subTrdCd, String laneGrp, String convLaneGrp, String rlaneCd, String sprtGrpCd, String bsaGrpCd, String polCd, String podCd, String ctrtAqCd, String ctrtRgnOfcCd, String polSeq, String podSeq, String itemCode, String rowSeq, String item, String recentYearly, String recentMonthly, String fcast01, String model01, String yearly01, String final01, String initial01, String totLod, String totRpb, String cmUcAmt, String opfitUcAmt, String raCmUcAmt, String raOpfitUcAmt, String totBsa, String lowQty, String rgnGrp, String convDirCd) {
		this.initial01 = initial01;
		this.cmUcAmt = cmUcAmt;
		this.polSeq = polSeq;
		this.recentYearly = recentYearly;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.lowQty = lowQty;
		this.convLaneGrp = convLaneGrp;
		this.bsaGrpCd = bsaGrpCd;
		this.rgnGrp = rgnGrp;
		this.totBsa = totBsa;
		this.key = key;
		this.itemCode = itemCode;
		this.fcast01 = fcast01;
		this.raOpfitUcAmt = raOpfitUcAmt;
		this.ctrtAqCd = ctrtAqCd;
		this.opfitUcAmt = opfitUcAmt;
		this.totRpb = totRpb;
		this.laneGrp = laneGrp;
		this.yearly01 = yearly01;
		this.final01 = final01;
		this.ctrtRgnOfcCd = ctrtRgnOfcCd;
		this.sprtGrpCd = sprtGrpCd;
		this.podSeq = podSeq;
		this.podCd = podCd;
		this.raCmUcAmt = raCmUcAmt;
		this.rowSeq = rowSeq;
		this.item = item;
		this.totLod = totLod;
		this.recentMonthly = recentMonthly;
		this.model01 = model01;
		this.subTrdCd = subTrdCd;
		this.convDirCd = convDirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("initial_01", getInitial01());
		this.hashColumns.put("cm_uc_amt", getCmUcAmt());
		this.hashColumns.put("pol_seq", getPolSeq());
		this.hashColumns.put("recent_yearly", getRecentYearly());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("low_qty", getLowQty());
		this.hashColumns.put("conv_lane_grp", getConvLaneGrp());
		this.hashColumns.put("bsa_grp_cd", getBsaGrpCd());
		this.hashColumns.put("rgn_grp", getRgnGrp());
		this.hashColumns.put("tot_bsa", getTotBsa());
		this.hashColumns.put("key", getKey());
		this.hashColumns.put("item_code", getItemCode());
		this.hashColumns.put("fcast_01", getFcast01());
		this.hashColumns.put("ra_opfit_uc_amt", getRaOpfitUcAmt());
		this.hashColumns.put("ctrt_aq_cd", getCtrtAqCd());
		this.hashColumns.put("opfit_uc_amt", getOpfitUcAmt());
		this.hashColumns.put("tot_rpb", getTotRpb());
		this.hashColumns.put("lane_grp", getLaneGrp());
		this.hashColumns.put("yearly_01", getYearly01());
		this.hashColumns.put("final_01", getFinal01());
		this.hashColumns.put("ctrt_rgn_ofc_cd", getCtrtRgnOfcCd());
		this.hashColumns.put("sprt_grp_cd", getSprtGrpCd());
		this.hashColumns.put("pod_seq", getPodSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ra_cm_uc_amt", getRaCmUcAmt());
		this.hashColumns.put("row_seq", getRowSeq());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("tot_lod", getTotLod());
		this.hashColumns.put("recent_monthly", getRecentMonthly());
		this.hashColumns.put("model_01", getModel01());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("incl_port_flg", getInclPortFlg());
		this.hashColumns.put("sls_fcast_pub_no", getSlsFcastPubNo());
		this.hashColumns.put("saq_sts_cd", getSaqStsCd());
		this.hashColumns.put("mqta_mdl_ver_no", getMqtaMdlVerNo());

		this.hashColumns.put("recent_mon", getRecentMon());
		this.hashColumns.put("slevel", getSlevel());
		this.hashColumns.put("pfmc_qta", getPfmcQta());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("final_1", getFinal1());
		this.hashColumns.put("recent_yr", getRecentYr());
		this.hashColumns.put("final_3", getFinal3());
		this.hashColumns.put("final_2", getFinal2());
		this.hashColumns.put("forecast_tot", getForecastTot());
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
		this.hashColumns.put("conv_dir_cd", getConvDirCd());

		this.hashColumns.put("cre_seq", getCreSeq());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("subj_ctnt", getSubjCtnt());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("cmt_ctnt", getCmtCtnt());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("mqta_step_cd", getMqtaStepCd());
		this.hashColumns.put("rmk_cre_gdt", getRmkCreGdt());
		this.hashColumns.put("rnk", getRnk());
		this.hashColumns.put("mqta_ver_no", getMqtaVerNo());
		this.hashColumns.put("rlane_grp", getRlaneGrp());
		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("initial_01", "initial01");
		this.hashFields.put("cm_uc_amt", "cmUcAmt");
		this.hashFields.put("pol_seq", "polSeq");
		this.hashFields.put("recent_yearly", "recentYearly");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("low_qty", "lowQty");
		this.hashFields.put("conv_lane_grp", "convLaneGrp");
		this.hashFields.put("bsa_grp_cd", "bsaGrpCd");
		this.hashFields.put("rgn_grp", "rgnGrp");
		this.hashFields.put("tot_bsa", "totBsa");
		this.hashFields.put("key", "key");
		this.hashFields.put("item_code", "itemCode");
		this.hashFields.put("fcast_01", "fcast01");
		this.hashFields.put("ra_opfit_uc_amt", "raOpfitUcAmt");
		this.hashFields.put("ctrt_aq_cd", "ctrtAqCd");
		this.hashFields.put("opfit_uc_amt", "opfitUcAmt");
		this.hashFields.put("tot_rpb", "totRpb");
		this.hashFields.put("lane_grp", "laneGrp");
		this.hashFields.put("yearly_01", "yearly01");
		this.hashFields.put("final_01", "final01");
		this.hashFields.put("ctrt_rgn_ofc_cd", "ctrtRgnOfcCd");
		this.hashFields.put("sprt_grp_cd", "sprtGrpCd");
		this.hashFields.put("pod_seq", "podSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ra_cm_uc_amt", "raCmUcAmt");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("item", "item");
		this.hashFields.put("tot_lod", "totLod");
		this.hashFields.put("recent_monthly", "recentMonthly");
		this.hashFields.put("model_01", "model01");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("incl_port_flg", "inclPortFlg");
		this.hashFields.put("sls_fcast_pub_no", "slsFcastPubNo");
		this.hashFields.put("saq_sts_cd", "saqStsCd");
		this.hashFields.put("mqta_mdl_ver_no", "mqtaMdlVerNo");

		this.hashFields.put("recent_mon", "recentMon");
		this.hashFields.put("slevel", "slevel");
		this.hashFields.put("pfmc_qta", "pfmcQta");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("final_1", "final1");
		this.hashFields.put("recent_yr", "recentYr");
		this.hashFields.put("final_3", "final3");
		this.hashFields.put("final_2", "final2");
		this.hashFields.put("forecast_tot", "forecastTot");
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
		this.hashFields.put("conv_dir_cd", "convDirCd");

		this.hashFields.put("cre_seq", "creSeq");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("subj_ctnt", "subjCtnt");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("cmt_ctnt", "cmtCtnt");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("mqta_step_cd", "mqtaStepCd");
		this.hashFields.put("rmk_cre_gdt", "rmkCreGdt");
		this.hashFields.put("rnk", "rnk");
		this.hashFields.put("mqta_ver_no", "mqtaVerNo");
		this.hashFields.put("rlane_grp", "rlaneGrp");
		
		
		return this.hashFields;
	}
	
	public String getInclPortFlg() {	return this.inclPortFlg;   }
	public String getSlsFcastPubNo() {	return this.slsFcastPubNo; }
	public String getSaqStsCd() {		return this.saqStsCd;	   }
	public String getMqtaMdlVerNo() {	return this.mqtaMdlVerNo;  }
	public String getInitial01() {		return this.initial01;	   }
	public String getCmUcAmt() {		return this.cmUcAmt;	   }
	public String getPolSeq() {		    return this.polSeq;	       }
	public String getRecentYearly() {	return this.recentYearly;  }
	public String getRlaneCd() {		return this.rlaneCd;	   }
	public String getPagerows() {		return this.pagerows;	   }
	public String getPolCd() {		    return this.polCd;	       }
	public String getIbflag() {		    return this.ibflag;	       }
	public String getLowQty() {		    return this.lowQty;	       }
	public String getConvLaneGrp() {	return this.convLaneGrp;   }
	public String getBsaGrpCd() {		return this.bsaGrpCd;	   }
	public String getRgnGrp() {		    return this.rgnGrp;	       }
	public String getTotBsa() {		    return this.totBsa;	       }
	public String getKey() {		    return this.key;	       }
	public String getItemCode() {		return this.itemCode;	   }
	public String getFcast01() {		return this.fcast01;	   }
	public String getRaOpfitUcAmt() {	return this.raOpfitUcAmt;  }
	public String getCtrtAqCd() {		return this.ctrtAqCd;	   }
	public String getOpfitUcAmt() {		return this.opfitUcAmt;	   }
	public String getTotRpb() {		    return this.totRpb;	       }
	public String getLaneGrp() {		return this.laneGrp;	   }
	public String getYearly01() {		return this.yearly01;	   }
	public String getFinal01() {		return this.final01;	   }
	public String getCtrtRgnOfcCd() {	return this.ctrtRgnOfcCd;  }
	public String getSprtGrpCd() {		return this.sprtGrpCd;	   }
	public String getPodSeq() {		    return this.podSeq;	       }
	public String getPodCd() {		    return this.podCd;	       }
	public String getRaCmUcAmt() {		return this.raCmUcAmt;	   }
	public String getRowSeq() {		    return this.rowSeq;	       }
	public String getItem() {		    return this.item;	       }
	public String getTotLod() {		    return this.totLod;	       }
	public String getRecentMonthly() {	return this.recentMonthly; }
	public String getModel01() {		return this.model01;	   }
	public String getSubTrdCd() {		return this.subTrdCd;	   }
	public String getRecentMon() {		return this.recentMon;	   }
	public String getSlevel() {		    return this.slevel;	       }
	public String getPfmcQta() {		return this.pfmcQta;	   }
	public String getTrdCd() {		    return this.trdCd;	       }
	public String getFinal1() {		    return this.final1;	       }
	public String getRecentYr() {		return this.recentYr;	   }
	public String getFinal3() {		    return this.final3;	       }
	public String getFinal2() {		    return this.final2;	       }
	public String getForecastTot() {	return this.forecastTot;   }
	public String getInitial3() {		return this.initial3;	   }
	public String getInitial2() {		return this.initial2;	   }
	public String getItemText() {		return this.itemText;	   }
	public String getDirCd() {		    return this.dirCd;	       }
	public String getInitial1() {		return this.initial1;	   }
	public String getPfmcSmr() {		return this.pfmcSmr;	   }
	public String getInitialTot() {		return this.initialTot;	   }
	public String getFinalTot() {		return this.finalTot;	   }
	public String getFcast1() {		    return this.fcast1;	       }
	public String getFcast2() {		    return this.fcast2;	       }
	public String getFcast3() {		    return this.fcast3;	       }
	public String getYqta3() {		    return this.yqta3;	       }
	public String getYqta2() {		    return this.yqta2;	       }
	public String getYqta1() {		    return this.yqta1;	       }
	public String getMdlRst1() {		return this.mdlRst1;	   }
	public String getModelTot() {		return this.modelTot;	   }
	public String getMdlRst2() {		return this.mdlRst2;	   }
	public String getMdlRst3() {		return this.mdlRst3;	   }
	public String getConvDirCd() {      return convDirCd;          }
	public String getCreSeq() {		    return this.creSeq;	       }
	public String getBseYr() {		    return this.bseYr;	       }
	public String getSubjCtnt() {		return this.subjCtnt;	   }
	public String getBseMon() {		    return this.bseMon;	       }
	public String getBseQtrCd() {		return this.bseQtrCd;	   }
	public String getCmtCtnt() {		return this.cmtCtnt;	   }
	public String getCreOfcCd() {		return this.creOfcCd;	   }
	public String getMqtaStepCd() {		return this.mqtaStepCd;	   }
	public String getRmkCreGdt() {		return this.rmkCreGdt;	   }
	public String getRnk() {		    return this.rnk;	       }
	public String getMqtaVerNo() {		return this.mqtaVerNo;	   }
	public String getRlaneGrp() {		return this.rlaneGrp;	   }


	public void setInclPortFlg(String inclPortFlg) {	    this.inclPortFlg = inclPortFlg;	   }
	public void setSlsFcastPubNo(String slsFcastPubNo) {	this.slsFcastPubNo = slsFcastPubNo;}
	public void setSaqStsCd(String saqStsCd) {		        this.saqStsCd = saqStsCd;	       }
	public void setMqtaMdlVerNo(String mqtaMdlVerNo) {	    this.mqtaMdlVerNo = mqtaMdlVerNo;  }
	public void setInitial01(String initial01) {		    this.initial01 = initial01;	       }
	public void setCmUcAmt(String cmUcAmt) {		        this.cmUcAmt = cmUcAmt;	           }
	public void setPolSeq(String polSeq) {		            this.polSeq = polSeq;	           }
	public void setRecentYearly(String recentYearly) {	    this.recentYearly = recentYearly;  }
	public void setRlaneCd(String rlaneCd) {		        this.rlaneCd = rlaneCd;	           }
	public void setPagerows(String pagerows) {		        this.pagerows = pagerows;	       }
	public void setPolCd(String polCd) {		            this.polCd = polCd;	               }
	public void setIbflag(String ibflag) {		            this.ibflag = ibflag;	           }
	public void setLowQty(String lowQty) {		            this.lowQty = lowQty;	           }
	public void setConvLaneGrp(String convLaneGrp) {	    this.convLaneGrp = convLaneGrp;    }
	public void setBsaGrpCd(String bsaGrpCd) {		        this.bsaGrpCd = bsaGrpCd;	       }
	public void setRgnGrp(String rgnGrp) {		            this.rgnGrp = rgnGrp;	           }
	public void setTotBsa(String totBsa) {		            this.totBsa = totBsa;	           }
	public void setKey(String key) {		                this.key  = key;	               }
	public void setItemCode(String itemCode) {		        this.itemCode = itemCode;	       }
	public void setFcast01(String fcast01) {		        this.fcast01 = fcast01;	           }
	public void setRaOpfitUcAmt(String raOpfitUcAmt) {	    this.raOpfitUcAmt = raOpfitUcAmt;  }
	public void setCtrtAqCd(String ctrtAqCd) {		        this.ctrtAqCd = ctrtAqCd;	       }
	public void setOpfitUcAmt(String opfitUcAmt) {		    this.opfitUcAmt = opfitUcAmt;	   }
	public void setTotRpb(String totRpb) {		            this.totRpb = totRpb;	           }
	public void setLaneGrp(String laneGrp) {		        this.laneGrp = laneGrp;	           }
	public void setYearly01(String yearly01) {		        this.yearly01 = yearly01;	       }
	public void setFinal01(String final01) {		        this.final01 = final01;	           }
	public void setCtrtRgnOfcCd(String ctrtRgnOfcCd) {	    this.ctrtRgnOfcCd = ctrtRgnOfcCd;  }
	public void setSprtGrpCd(String sprtGrpCd) {		    this.sprtGrpCd = sprtGrpCd;	       }
	public void setPodSeq(String podSeq) {		            this.podSeq = podSeq;	           }
	public void setPodCd(String podCd) {		            this.podCd = podCd;	               }
	public void setRaCmUcAmt(String raCmUcAmt) {		    this.raCmUcAmt = raCmUcAmt;	       }
	public void setRowSeq(String rowSeq) {		            this.rowSeq = rowSeq;              }
	public void setItem(String item) {		                this.item= item;	               }
	public void setTotLod(String totLod) {		            this.totLod = totLod;	           }
	public void setRecentMonthly(String recentMonthly) {	this.recentMonthly = recentMonthly;}
	public void setModel01(String model01) {		        this.model01 = model01;            }
	public void setSubTrdCd(String subTrdCd) {		        this.subTrdCd = subTrdCd;	       }
	public void setConvDirCd(String convDirCd) {            this.convDirCd = convDirCd;        }
	public void setRecentMon(String recentMon) {		    this.recentMon = recentMon;	       }
	public void setSlevel(String slevel) {		            this.slevel = slevel;	           }
	public void setPfmcQta(String pfmcQta) {		        this.pfmcQta = pfmcQta;	           }
	public void setTrdCd(String trdCd) {		            this.trdCd = trdCd;	               }
	public void setFinal1(String final1) {		            this.final1 = final1;	           }
	public void setRecentYr(String recentYr) {		        this.recentYr = recentYr;	       }
	public void setFinal3(String final3) {		            this.final3 = final3;	           }
	public void setFinal2(String final2) {		            this.final2 = final2;	           }
	public void setForecastTot(String forecastTot) {	    this.forecastTot = forecastTot;	   }
	public void setInitial3(String initial3) {		        this.initial3 = initial3;	       }
	public void setInitial2(String initial2) {		        this.initial2 = initial2;	       }
	public void setItemText(String itemText) {		        this.itemText = itemText;	       }
	public void setDirCd(String dirCd) {		            this.dirCd = dirCd;	               } 
	public void setInitial1(String initial1) {		        this.initial1 = initial1;	       }
	public void setPfmcSmr(String pfmcSmr) {		        this.pfmcSmr = pfmcSmr;	           }
	public void setInitialTot(String initialTot) {		    this.initialTot = initialTot;	   }
	public void setFinalTot(String finalTot) {		        this.finalTot = finalTot;	       }
	public void setFcast1(String fcast1) {		            this.fcast1 = fcast1;	           }
	public void setFcast2(String fcast2) {		            this.fcast2 = fcast2;	           }
	public void setFcast3(String fcast3) {		            this.fcast3 = fcast3;	           }
	public void setYqta3(String yqta3) {		            this.yqta3 = yqta3;	               }
	public void setYqta2(String yqta2) {		            this.yqta2 = yqta2;	               }
	public void setYqta1(String yqta1) {		            this.yqta1 = yqta1;	               }
	public void setMdlRst1(String mdlRst1) {		        this.mdlRst1 = mdlRst1;	           }
	public void setModelTot(String modelTot) {		        this.modelTot = modelTot;	       }
	public void setMdlRst2(String mdlRst2) {		        this.mdlRst2 = mdlRst2;	           }
	public void setMdlRst3(String mdlRst3) {		        this.mdlRst3 = mdlRst3;	           }
	public void setCreSeq(String creSeq) {		            this.creSeq = creSeq;	           }
	public void setBseYr(String bseYr) {		            this.bseYr = bseYr;	               }
	public void setSubjCtnt(String subjCtnt) {		        this.subjCtnt = subjCtnt;	       }
	public void setBseMon(String bseMon) {		            this.bseMon = bseMon;	           }
	public void setBseQtrCd(String bseQtrCd) {		        this.bseQtrCd = bseQtrCd;	       }
	public void setCmtCtnt(String cmtCtnt) {		        this.cmtCtnt = cmtCtnt;	           }
	public void setCreOfcCd(String creOfcCd) {		        this.creOfcCd = creOfcCd;	       }
	public void setMqtaStepCd(String mqtaStepCd) {		    this.mqtaStepCd = mqtaStepCd;	   }
	public void setRmkCreGdt(String rmkCreGdt) {		    this.rmkCreGdt = rmkCreGdt;	       }
	public void setRnk(String rnk) {		                this.rnk = rnk;	                   }
	public void setMqtaVerNo(String mqtaVerNo) {		    this.mqtaVerNo = mqtaVerNo;	       }
	public void setRlaneGrp(String rlaneGrp) {		        this.rlaneGrp = rlaneGrp;	       }
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInitial01(JSPUtil.getParameter(request, "initial_01", ""));
		setCmUcAmt(JSPUtil.getParameter(request, "cm_uc_amt", ""));
		setPolSeq(JSPUtil.getParameter(request, "pol_seq", ""));
		setRecentYearly(JSPUtil.getParameter(request, "recent_yearly", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLowQty(JSPUtil.getParameter(request, "low_qty", ""));
		setConvLaneGrp(JSPUtil.getParameter(request, "conv_lane_grp", ""));
		setBsaGrpCd(JSPUtil.getParameter(request, "bsa_grp_cd", ""));
		setRgnGrp(JSPUtil.getParameter(request, "rgn_grp", ""));
		setTotBsa(JSPUtil.getParameter(request, "tot_bsa", ""));
		setKey(JSPUtil.getParameter(request, "key", ""));
		setItemCode(JSPUtil.getParameter(request, "item_code", ""));
		setFcast01(JSPUtil.getParameter(request, "fcast_01", ""));
		setRaOpfitUcAmt(JSPUtil.getParameter(request, "ra_opfit_uc_amt", ""));
		setCtrtAqCd(JSPUtil.getParameter(request, "ctrt_aq_cd", ""));
		setOpfitUcAmt(JSPUtil.getParameter(request, "opfit_uc_amt", ""));
		setTotRpb(JSPUtil.getParameter(request, "tot_rpb", ""));
		setLaneGrp(JSPUtil.getParameter(request, "lane_grp", ""));
		setYearly01(JSPUtil.getParameter(request, "yearly_01", ""));
		setFinal01(JSPUtil.getParameter(request, "final_01", ""));
		setCtrtRgnOfcCd(JSPUtil.getParameter(request, "ctrt_rgn_ofc_cd", ""));
		setSprtGrpCd(JSPUtil.getParameter(request, "sprt_grp_cd", ""));
		setPodSeq(JSPUtil.getParameter(request, "pod_seq", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setRaCmUcAmt(JSPUtil.getParameter(request, "ra_cm_uc_amt", ""));
		setRowSeq(JSPUtil.getParameter(request, "row_seq", ""));
		setItem(JSPUtil.getParameter(request, "item", ""));
		setTotLod(JSPUtil.getParameter(request, "tot_lod", ""));
		setRecentMonthly(JSPUtil.getParameter(request, "recent_monthly", ""));
		setModel01(JSPUtil.getParameter(request, "model_01", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setInclPortFlg(JSPUtil.getParameter(request, "incl_port_flg", ""));
		setSlsFcastPubNo(JSPUtil.getParameter(request, "sls_fcast_pub_no", ""));
		setSaqStsCd(JSPUtil.getParameter(request, "saq_sts_cd", ""));
		setMqtaMdlVerNo(JSPUtil.getParameter(request, "mqta_mdl_ver_no", ""));

		setRecentMon(JSPUtil.getParameter(request, "recent_mon", ""));
		setSlevel(JSPUtil.getParameter(request, "slevel", ""));
		setPfmcQta(JSPUtil.getParameter(request, "pfmc_qta", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setFinal1(JSPUtil.getParameter(request, "final_1", ""));
		setRecentYr(JSPUtil.getParameter(request, "recent_yr", ""));
		setFinal3(JSPUtil.getParameter(request, "final_3", ""));
		setFinal2(JSPUtil.getParameter(request, "final_2", ""));
		setForecastTot(JSPUtil.getParameter(request, "forecast_tot", ""));
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
		setConvDirCd(JSPUtil.getParameter(request, "conv_dir_cd", ""));

		setCreSeq(JSPUtil.getParameter(request, "cre_seq", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setSubjCtnt(JSPUtil.getParameter(request, "subj_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBseMon(JSPUtil.getParameter(request, "bse_mon", ""));
		setBseQtrCd(JSPUtil.getParameter(request, "bse_qtr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmtCtnt(JSPUtil.getParameter(request, "cmt_ctnt", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setMqtaStepCd(JSPUtil.getParameter(request, "mqta_step_cd", ""));
		setRmkCreGdt(JSPUtil.getParameter(request, "rmk_cre_gdt", ""));
		setRnk(JSPUtil.getParameter(request, "rnk", ""));
		setMqtaVerNo(JSPUtil.getParameter(request, "mqta_ver_no", ""));
		setRlaneGrp(JSPUtil.getParameter(request, "rlane_grp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MonthlyQuotaAdjustmentRhqVO[]
	 */
	public MonthlyQuotaAdjustmentRhqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MonthlyQuotaAdjustmentRhqVO[]
	 */
	public MonthlyQuotaAdjustmentRhqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MonthlyQuotaAdjustmentRhqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] initial01 = (JSPUtil.getParameter(request, prefix	+ "initial_01", length));
			String[] cmUcAmt = (JSPUtil.getParameter(request, prefix	+ "cm_uc_amt", length));
			String[] polSeq = (JSPUtil.getParameter(request, prefix	+ "pol_seq", length));
			String[] recentYearly = (JSPUtil.getParameter(request, prefix	+ "recent_yearly", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lowQty = (JSPUtil.getParameter(request, prefix	+ "low_qty", length));
			String[] convLaneGrp = (JSPUtil.getParameter(request, prefix	+ "conv_lane_grp", length));
			String[] bsaGrpCd = (JSPUtil.getParameter(request, prefix	+ "bsa_grp_cd", length));
			String[] rgnGrp = (JSPUtil.getParameter(request, prefix	+ "rgn_grp", length));
			String[] totBsa = (JSPUtil.getParameter(request, prefix	+ "tot_bsa", length));
			String[] key = (JSPUtil.getParameter(request, prefix	+ "key", length));
			String[] itemCode = (JSPUtil.getParameter(request, prefix	+ "item_code", length));
			String[] fcast01 = (JSPUtil.getParameter(request, prefix	+ "fcast_01", length));
			String[] raOpfitUcAmt = (JSPUtil.getParameter(request, prefix	+ "ra_opfit_uc_amt", length));
			String[] ctrtAqCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_aq_cd", length));
			String[] opfitUcAmt = (JSPUtil.getParameter(request, prefix	+ "opfit_uc_amt", length));
			String[] totRpb = (JSPUtil.getParameter(request, prefix	+ "tot_rpb", length));
			String[] laneGrp = (JSPUtil.getParameter(request, prefix	+ "lane_grp", length));
			String[] yearly01 = (JSPUtil.getParameter(request, prefix	+ "yearly_01", length));
			String[] final01 = (JSPUtil.getParameter(request, prefix	+ "final_01", length));
			String[] ctrtRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_rgn_ofc_cd", length));
			String[] sprtGrpCd = (JSPUtil.getParameter(request, prefix	+ "sprt_grp_cd", length));
			String[] podSeq = (JSPUtil.getParameter(request, prefix	+ "pod_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] raCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "ra_cm_uc_amt", length));
			String[] rowSeq = (JSPUtil.getParameter(request, prefix	+ "row_seq", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] totLod = (JSPUtil.getParameter(request, prefix	+ "tot_lod", length));
			String[] recentMonthly = (JSPUtil.getParameter(request, prefix	+ "recent_monthly", length));
			String[] model01 = (JSPUtil.getParameter(request, prefix	+ "model_01", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			String[] recentMon = (JSPUtil.getParameter(request, prefix	+ "recent_mon", length));
			String[] slevel = (JSPUtil.getParameter(request, prefix	+ "slevel", length));
			String[] pfmcQta = (JSPUtil.getParameter(request, prefix	+ "pfmc_qta", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] final1 = (JSPUtil.getParameter(request, prefix	+ "final_1", length));
			String[] recentYr = (JSPUtil.getParameter(request, prefix	+ "recent_yr", length));
			String[] final3 = (JSPUtil.getParameter(request, prefix	+ "final_3", length));
			String[] final2 = (JSPUtil.getParameter(request, prefix	+ "final_2", length));
			String[] forecastTot = (JSPUtil.getParameter(request, prefix	+ "forecast_tot", length));
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
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			
			String[] creSeq = (JSPUtil.getParameter(request, prefix	+ "cre_seq", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] subjCtnt = (JSPUtil.getParameter(request, prefix	+ "subj_ctnt", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] cmtCtnt = (JSPUtil.getParameter(request, prefix	+ "cmt_ctnt", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] mqtaStepCd = (JSPUtil.getParameter(request, prefix	+ "mqta_step_cd", length));
			String[] rmkCreGdt = (JSPUtil.getParameter(request, prefix	+ "rmk_cre_gdt", length));
			String[] rnk = (JSPUtil.getParameter(request, prefix	+ "rnk", length));
			String[] mqtaVerNo = (JSPUtil.getParameter(request, prefix	+ "mqta_ver_no", length));
			String[] rlaneGrp = (JSPUtil.getParameter(request, prefix	+ "rlane_grp", length));
			
			for (int i = 0; i < length; i++) {
				model = new MonthlyQuotaAdjustmentRhqVO();
				if (initial01[i] != null)
					model.setInitial01(initial01[i]);
				if (cmUcAmt[i] != null)
					model.setCmUcAmt(cmUcAmt[i]);
				if (polSeq[i] != null)
					model.setPolSeq(polSeq[i]);
				if (recentYearly[i] != null)
					model.setRecentYearly(recentYearly[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lowQty[i] != null)
					model.setLowQty(lowQty[i]);
				if (convLaneGrp[i] != null)
					model.setConvLaneGrp(convLaneGrp[i]);
				if (bsaGrpCd[i] != null)
					model.setBsaGrpCd(bsaGrpCd[i]);
				if (rgnGrp[i] != null)
					model.setRgnGrp(rgnGrp[i]);
				if (totBsa[i] != null)
					model.setTotBsa(totBsa[i]);
				if (key[i] != null)
					model.setKey(key[i]);
				if (itemCode[i] != null)
					model.setItemCode(itemCode[i]);
				if (fcast01[i] != null)
					model.setFcast01(fcast01[i]);
				if (raOpfitUcAmt[i] != null)
					model.setRaOpfitUcAmt(raOpfitUcAmt[i]);
				if (ctrtAqCd[i] != null)
					model.setCtrtAqCd(ctrtAqCd[i]);
				if (opfitUcAmt[i] != null)
					model.setOpfitUcAmt(opfitUcAmt[i]);
				if (totRpb[i] != null)
					model.setTotRpb(totRpb[i]);
				if (laneGrp[i] != null)
					model.setLaneGrp(laneGrp[i]);
				if (yearly01[i] != null)
					model.setYearly01(yearly01[i]);
				if (final01[i] != null)
					model.setFinal01(final01[i]);
				if (ctrtRgnOfcCd[i] != null)
					model.setCtrtRgnOfcCd(ctrtRgnOfcCd[i]);
				if (sprtGrpCd[i] != null)
					model.setSprtGrpCd(sprtGrpCd[i]);
				if (podSeq[i] != null)
					model.setPodSeq(podSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (raCmUcAmt[i] != null)
					model.setRaCmUcAmt(raCmUcAmt[i]);
				if (rowSeq[i] != null)
					model.setRowSeq(rowSeq[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (totLod[i] != null)
					model.setTotLod(totLod[i]);
				if (recentMonthly[i] != null)
					model.setRecentMonthly(recentMonthly[i]);
				if (model01[i] != null)
					model.setModel01(model01[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
		
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
				if (forecastTot[i] != null)
					model.setForecastTot(forecastTot[i]);
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
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				
				if (creSeq[i] != null)
					model.setCreSeq(creSeq[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (subjCtnt[i] != null)
					model.setSubjCtnt(subjCtnt[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (cmtCtnt[i] != null)
					model.setCmtCtnt(cmtCtnt[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (mqtaStepCd[i] != null)
					model.setMqtaStepCd(mqtaStepCd[i]);
				if (rmkCreGdt[i] != null)
					model.setRmkCreGdt(rmkCreGdt[i]);
				if (rnk[i] != null)
					model.setRnk(rnk[i]);
				if (mqtaVerNo[i] != null)
					model.setMqtaVerNo(mqtaVerNo[i]);
				if (rlaneGrp[i] != null)
					model.setRlaneGrp(rlaneGrp[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMonthlyQuotaAdjustmentRhqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MonthlyQuotaAdjustmentRhqVO[]
	 */
	public MonthlyQuotaAdjustmentRhqVO[] getMonthlyQuotaAdjustmentRhqVOs(){
		MonthlyQuotaAdjustmentRhqVO[] vos = (MonthlyQuotaAdjustmentRhqVO[])models.toArray(new MonthlyQuotaAdjustmentRhqVO[models.size()]);
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
		this.initial01 = this.initial01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmUcAmt = this.cmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSeq = this.polSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentYearly = this.recentYearly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowQty = this.lowQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convLaneGrp = this.convLaneGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaGrpCd = this.bsaGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnGrp = this.rgnGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBsa = this.totBsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key = this.key .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemCode = this.itemCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast01 = this.fcast01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raOpfitUcAmt = this.raOpfitUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtAqCd = this.ctrtAqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opfitUcAmt = this.opfitUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totRpb = this.totRpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrp = this.laneGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearly01 = this.yearly01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final01 = this.final01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRgnOfcCd = this.ctrtRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtGrpCd = this.sprtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSeq = this.podSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmUcAmt = this.raCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq = this.rowSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLod = this.totLod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentMonthly = this.recentMonthly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.model01 = this.model01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.recentMon = this.recentMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slevel = this.slevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcQta = this.pfmcQta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final1 = this.final1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentYr = this.recentYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final3 = this.final3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.final2 = this.final2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.forecastTot = this.forecastTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.creSeq = this.creSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subjCtnt = this.subjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmtCtnt = this.cmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqtaStepCd = this.mqtaStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmkCreGdt = this.rmkCreGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnk = this.rnk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqtaVerNo = this.mqtaVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneGrp = this.rlaneGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
