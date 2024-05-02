/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMonthlyQuotaAdjustmentSlsRhq0156List01VO.java
*@FileTitle : SearchMonthlyQuotaAdjustmentSlsRhq0156List01VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 최민철
*@LastVersion : 1.0
* 2009.09.21 최민철 
* 1.0 Creation 
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.vo;

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

public class SearchMonthlyQuotaAdjustmentSlsRhqListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyQuotaAdjustmentSlsRhqListVO> models = new ArrayList<SearchMonthlyQuotaAdjustmentSlsRhqListVO>();
	
	/* Column Info */
	private String initial01 = null;
	/* Column Info */
	private String cmUcAmt = null;
	/* Column Info */
	private String polSeq = null;
	/* Column Info */
	private String rhq01 = null;
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
	private String slsAqCd = null;
	/* Column Info */
	private String opfitUcAmt = null;
	/* Column Info */
	private String totRpb = null;
	/* Column Info */
	private String slsAqCdSeq = null;
	/* Column Info */
	private String laneGrp = null;
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
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String recentMonthly = null;
	/* Column Info */
	private String totLod = null;
	/* Column Info */
	private String model01 = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String recentMon = null;
	/* Column Info */
	private String mdlRsltTot = null;
	/* Column Info */
	private String slevel = null;
	/* Column Info */
	private String pfmcQta = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rhqTot = null;
	/* Column Info */
	private String fcastTot = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String itemText = null;
	/* Column Info */
	private String pfmcSmr = null;
	/* Column Info */
	private String initialTot = null;

	/* Column Info */ 
	private String fcast1    = null;
	private String fcast2    = null;
	private String fcast3    = null;
	private String initial1  = null;
	private String initial2  = null;
	private String initial3  = null;
	private String mdlRst1   = null;
	private String mdlRst2   = null;
	private String mdlRst3   = null;
	private String rhq1      = null;
	private String rhq2      = null;
	private String rhq3      = null;
	private String convDirCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyQuotaAdjustmentSlsRhqListVO() {}

	public SearchMonthlyQuotaAdjustmentSlsRhqListVO(String ibflag, String pagerows, String key, String subTrdCd, String laneGrp, String convLaneGrp, String rlaneCd, String sprtGrpCd, String bsaGrpCd, String polCd, String podCd, String slsAqCd, String slsAqCdSeq, String slsRgnOfcCd, String polSeq, String podSeq, String itemCode, String rowSeq, String item, String recentMonthly, String fcast01,
			String model01, String rhq01, String initial01, String totLod, String totRpb, String cmUcAmt, String opfitUcAmt, String raCmUcAmt, String raOpfitUcAmt, String totBsa, String lowQty, String rgnGrp, String slevel, String trdCd, String dirCd, String itemText, String pfmcQta, String pfmcSmr, String recentMon, String fcastTot, String mdlRsltTot, String rhqTot, String initialTot) {
		this.initial01 = initial01;
		this.cmUcAmt = cmUcAmt;
		this.polSeq = polSeq;
		this.rhq01 = rhq01;
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
		this.slsAqCd = slsAqCd;
		this.opfitUcAmt = opfitUcAmt;
		this.totRpb = totRpb;
		this.slsAqCdSeq = slsAqCdSeq;
		this.laneGrp = laneGrp;
		this.sprtGrpCd = sprtGrpCd;
		this.podSeq = podSeq;
		this.podCd = podCd;
		this.raCmUcAmt = raCmUcAmt;
		this.rowSeq = rowSeq;
		this.item = item;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.recentMonthly = recentMonthly;
		this.totLod = totLod;
		this.model01 = model01;
		this.subTrdCd = subTrdCd;
		this.recentMon = recentMon;
		this.mdlRsltTot = mdlRsltTot;
		this.slevel = slevel;
		this.pfmcQta = pfmcQta;
		this.trdCd = trdCd;
		this.rhqTot = rhqTot;
		this.fcastTot = fcastTot;
		this.dirCd = dirCd;
		this.itemText = itemText;
		this.pfmcSmr = pfmcSmr;
		this.initialTot = initialTot;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("initial_01", getInitial01());
		this.hashColumns.put("cm_uc_amt", getCmUcAmt());
		this.hashColumns.put("pol_seq", getPolSeq());
		this.hashColumns.put("rhq_01", getRhq01());
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
		this.hashColumns.put("sls_aq_cd", getSlsAqCd());
		this.hashColumns.put("opfit_uc_amt", getOpfitUcAmt());
		this.hashColumns.put("tot_rpb", getTotRpb());
		this.hashColumns.put("sls_aq_cd_seq", getSlsAqCdSeq());
		this.hashColumns.put("lane_grp", getLaneGrp());
		this.hashColumns.put("sprt_grp_cd", getSprtGrpCd());
		this.hashColumns.put("pod_seq", getPodSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ra_cm_uc_amt", getRaCmUcAmt());
		this.hashColumns.put("row_seq", getRowSeq());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("recent_monthly", getRecentMonthly());
		this.hashColumns.put("tot_lod", getTotLod());
		this.hashColumns.put("model_01", getModel01());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("recent_mon", getRecentMon());
		this.hashColumns.put("mdl_rslt_tot", getMdlRsltTot());
		this.hashColumns.put("slevel", getSlevel());
		this.hashColumns.put("pfmc_qta", getPfmcQta());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rhq_tot", getRhqTot());
		this.hashColumns.put("fcast_tot", getFcastTot());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("item_text", getItemText());
		this.hashColumns.put("pfmc_smr", getPfmcSmr());
		this.hashColumns.put("initial_tot", getInitialTot());
		this.hashColumns.put("fcast_1", getFcast1());
        this.hashColumns.put("fcast_2", getFcast2());
        this.hashColumns.put("fcast_3", getFcast3());
        this.hashColumns.put("initial_1", getInitial1());
        this.hashColumns.put("initial_2", getInitial2());
        this.hashColumns.put("initial_3", getInitial3());
        this.hashColumns.put("mdl_rst_1", getMdlRst1());
        this.hashColumns.put("mdl_rst_2", getMdlRst2());
        this.hashColumns.put("mdl_rst_3", getMdlRst3());
        this.hashColumns.put("rhq_1", getRhq1());
        this.hashColumns.put("rhq_2", getRhq2());
        this.hashColumns.put("rhq_3", getRhq3());
        this.hashColumns.put("conv_dir_cd", getConvDirCd());
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
		this.hashFields.put("rhq_01", "rhq01");
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
		this.hashFields.put("sls_aq_cd", "slsAqCd");
		this.hashFields.put("opfit_uc_amt", "opfitUcAmt");
		this.hashFields.put("tot_rpb", "totRpb");
		this.hashFields.put("sls_aq_cd_seq", "slsAqCdSeq");
		this.hashFields.put("lane_grp", "laneGrp");
		this.hashFields.put("sprt_grp_cd", "sprtGrpCd");
		this.hashFields.put("pod_seq", "podSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ra_cm_uc_amt", "raCmUcAmt");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("item", "item");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("recent_monthly", "recentMonthly");
		this.hashFields.put("tot_lod", "totLod");
		this.hashFields.put("model_01", "model01");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("recent_mon", "recentMon");
		this.hashFields.put("mdl_rslt_tot", "mdlRsltTot");
		this.hashFields.put("slevel", "slevel");
		this.hashFields.put("pfmc_qta", "pfmcQta");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rhq_tot", "rhqTot");
		this.hashFields.put("fcast_tot", "fcastTot");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("item_text", "itemText");
		this.hashFields.put("pfmc_smr", "pfmcSmr");
		this.hashFields.put("initial_tot", "initialTot");
		this.hashFields.put("fcast_1", "fcast1");
        this.hashFields.put("fcast_2", "fcast2");
        this.hashFields.put("fcast_3", "fcast3");
        this.hashFields.put("initial_1", "initial1");
        this.hashFields.put("initial_2", "initial2");
        this.hashFields.put("initial_3", "initial3");
        this.hashFields.put("mdl_rst_1", "mdlRst1");
        this.hashFields.put("mdl_rst_2", "mdlRst2");
        this.hashFields.put("mdl_rst_3", "mdlRst3");
        this.hashFields.put("rhq_1", "rhq1");
        this.hashFields.put("rhq_2", "rhq2");
        this.hashFields.put("rhq_3", "rhq3");
        this.hashFields.put("conv_dir_cd", "convDirCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return initial01
	 */
	public String getInitial01() {
		return this.initial01;
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
	 * @return polSeq
	 */
	public String getPolSeq() {
		return this.polSeq;
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
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return rgnGrp
	 */
	public String getRgnGrp() {
		return this.rgnGrp;
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
	 * @return fcast01
	 */
	public String getFcast01() {
		return this.fcast01;
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
	 * @return slsAqCd
	 */
	public String getSlsAqCd() {
		return this.slsAqCd;
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
	 * @return slsAqCdSeq
	 */
	public String getSlsAqCdSeq() {
		return this.slsAqCdSeq;
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
	 * @return sprtGrpCd
	 */
	public String getSprtGrpCd() {
		return this.sprtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return podSeq
	 */
	public String getPodSeq() {
		return this.podSeq;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return slsRgnOfcCd
	 */
	public String getSlsRgnOfcCd() {
		return this.slsRgnOfcCd;
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
	 * @return totLod
	 */
	public String getTotLod() {
		return this.totLod;
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
	 * @return recentMon
	 */
	public String getRecentMon() {
		return this.recentMon;
	}
	
	/**
	 * Column Info
	 * @return mdlRsltTot
	 */
	public String getMdlRsltTot() {
		return this.mdlRsltTot;
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
	 * @return rhqTot
	 */
	public String getRhqTot() {
		return this.rhqTot;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
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
	 * @return initialTot
	 */
	public String getInitialTot() {
		return this.initialTot;
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
	 * @param mdlRsltTot
	 */
	public void setMdlRsltTot(String mdlRsltTot) {
		this.mdlRsltTot = mdlRsltTot;
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
	 * @param rhqTot
	 */
	public void setRhqTot(String rhqTot) {
		this.rhqTot = rhqTot;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
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
	 * @param initialTot
	 */
	public void setInitialTot(String initialTot) {
		this.initialTot = initialTot;
	}
	
	/**
	 * Column Info
	 * @param initial01
	 */
	public void setInitial01(String initial01) {
		this.initial01 = initial01;
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
	 * @param polSeq
	 */
	public void setPolSeq(String polSeq) {
		this.polSeq = polSeq;
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
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param rgnGrp
	 */
	public void setRgnGrp(String rgnGrp) {
		this.rgnGrp = rgnGrp;
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
	 * @param fcast01
	 */
	public void setFcast01(String fcast01) {
		this.fcast01 = fcast01;
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
	 * @param slsAqCd
	 */
	public void setSlsAqCd(String slsAqCd) {
		this.slsAqCd = slsAqCd;
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
	 * @param slsAqCdSeq
	 */
	public void setSlsAqCdSeq(String slsAqCdSeq) {
		this.slsAqCdSeq = slsAqCdSeq;
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
	 * @param sprtGrpCd
	 */
	public void setSprtGrpCd(String sprtGrpCd) {
		this.sprtGrpCd = sprtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param podSeq
	 */
	public void setPodSeq(String podSeq) {
		this.podSeq = podSeq;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param slsRgnOfcCd
	 */
	public void setSlsRgnOfcCd(String slsRgnOfcCd) {
		this.slsRgnOfcCd = slsRgnOfcCd;
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
	 * @param totLod
	 */
	public void setTotLod(String totLod) {
		this.totLod = totLod;
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
	
	public String getFcast1() {
		return fcast1;
	}

	public void setFcast1(String fcast1) {
		this.fcast1 = fcast1;
	}

	public String getFcast2() {
		return fcast2;
	}

	public void setFcast2(String fcast2) {
		this.fcast2 = fcast2;
	}

	public String getFcast3() {
		return fcast3;
	}

	public void setFcast3(String fcast3) {
		this.fcast3 = fcast3;
	}

	public String getInitial1() {
		return initial1;
	}

	public void setInitial1(String initial1) {
		this.initial1 = initial1;
	}

	public String getInitial2() {
		return initial2;
	}

	public void setInitial2(String initial2) {
		this.initial2 = initial2;
	}

	public String getInitial3() {
		return initial3;
	}

	public void setInitial3(String initial3) {
		this.initial3 = initial3;
	}

	public String getMdlRst1() {
		return mdlRst1;
	}

	public void setMdlRst1(String mdlRst1) {
		this.mdlRst1 = mdlRst1;
	}

	public String getMdlRst2() {
		return mdlRst2;
	}

	public void setMdlRst2(String mdlRst2) {
		this.mdlRst2 = mdlRst2;
	}

	public String getMdlRst3() {
		return mdlRst3;
	}

	public void setMdlRst3(String mdlRst3) {
		this.mdlRst3 = mdlRst3;
	}

	public String getRhq1() {
		return rhq1;
	}

	public void setRhq1(String rhq1) {
		this.rhq1 = rhq1;
	}

	public String getRhq2() {
		return rhq2;
	}

	public void setRhq2(String rhq2) {
		this.rhq2 = rhq2;
	}

	public String getRhq3() {
		return rhq3;
	}

	public void setRhq3(String rhq3) {
		this.rhq3 = rhq3;
	}
	
	public String getConvDirCd() {
		return convDirCd;
	}

	public void setConvDirCd(String convDirCd) {
		this.convDirCd = convDirCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInitial01(JSPUtil.getParameter(request, "initial_01", ""));
		setCmUcAmt(JSPUtil.getParameter(request, "cm_uc_amt", ""));
		setPolSeq(JSPUtil.getParameter(request, "pol_seq", ""));
		setRhq01(JSPUtil.getParameter(request, "rhq_01", ""));
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
		setSlsAqCd(JSPUtil.getParameter(request, "sls_aq_cd", ""));
		setOpfitUcAmt(JSPUtil.getParameter(request, "opfit_uc_amt", ""));
		setTotRpb(JSPUtil.getParameter(request, "tot_rpb", ""));
		setSlsAqCdSeq(JSPUtil.getParameter(request, "sls_aq_cd_seq", ""));
		setLaneGrp(JSPUtil.getParameter(request, "lane_grp", ""));
		setSprtGrpCd(JSPUtil.getParameter(request, "sprt_grp_cd", ""));
		setPodSeq(JSPUtil.getParameter(request, "pod_seq", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setRaCmUcAmt(JSPUtil.getParameter(request, "ra_cm_uc_amt", ""));
		setRowSeq(JSPUtil.getParameter(request, "row_seq", ""));
		setItem(JSPUtil.getParameter(request, "item", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, "sls_rgn_ofc_cd", ""));
		setRecentMonthly(JSPUtil.getParameter(request, "recent_monthly", ""));
		setTotLod(JSPUtil.getParameter(request, "tot_lod", ""));
		setModel01(JSPUtil.getParameter(request, "model_01", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setRecentMon(JSPUtil.getParameter(request, "recent_mon", ""));
		setMdlRsltTot(JSPUtil.getParameter(request, "mdl_rslt_tot", ""));
		setSlevel(JSPUtil.getParameter(request, "slevel", ""));
		setPfmcQta(JSPUtil.getParameter(request, "pfmc_qta", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRhqTot(JSPUtil.getParameter(request, "rhq_tot", ""));
		setFcastTot(JSPUtil.getParameter(request, "fcast_tot", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setItemText(JSPUtil.getParameter(request, "item_text", ""));
		setPfmcSmr(JSPUtil.getParameter(request, "pfmc_smr", ""));
		setInitialTot(JSPUtil.getParameter(request, "initial_tot", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyQuotaAdjustmentSlsRhq0156List01VO[]
	 */
	public SearchMonthlyQuotaAdjustmentSlsRhqListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyQuotaAdjustmentSlsRhq0156List01VO[]
	 */
	public SearchMonthlyQuotaAdjustmentSlsRhqListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyQuotaAdjustmentSlsRhqListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] initial01 = (JSPUtil.getParameter(request, prefix	+ "initial_01", length));
			String[] cmUcAmt = (JSPUtil.getParameter(request, prefix	+ "cm_uc_amt", length));
			String[] polSeq = (JSPUtil.getParameter(request, prefix	+ "pol_seq", length));
			String[] rhq01 = (JSPUtil.getParameter(request, prefix	+ "rhq_01", length));
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
			String[] slsAqCd = (JSPUtil.getParameter(request, prefix	+ "sls_aq_cd", length));
			String[] opfitUcAmt = (JSPUtil.getParameter(request, prefix	+ "opfit_uc_amt", length));
			String[] totRpb = (JSPUtil.getParameter(request, prefix	+ "tot_rpb", length));
			String[] slsAqCdSeq = (JSPUtil.getParameter(request, prefix	+ "sls_aq_cd_seq", length));
			String[] laneGrp = (JSPUtil.getParameter(request, prefix	+ "lane_grp", length));
			String[] sprtGrpCd = (JSPUtil.getParameter(request, prefix	+ "sprt_grp_cd", length));
			String[] podSeq = (JSPUtil.getParameter(request, prefix	+ "pod_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] raCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "ra_cm_uc_amt", length));
			String[] rowSeq = (JSPUtil.getParameter(request, prefix	+ "row_seq", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			String[] recentMonthly = (JSPUtil.getParameter(request, prefix	+ "recent_monthly", length));
			String[] totLod = (JSPUtil.getParameter(request, prefix	+ "tot_lod", length));
			String[] model01 = (JSPUtil.getParameter(request, prefix	+ "model_01", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] recentMon = (JSPUtil.getParameter(request, prefix	+ "recent_mon", length));
			String[] mdlRsltTot = (JSPUtil.getParameter(request, prefix	+ "mdl_rslt_tot", length));
			String[] slevel = (JSPUtil.getParameter(request, prefix	+ "slevel", length));
			String[] pfmcQta = (JSPUtil.getParameter(request, prefix	+ "pfmc_qta", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rhqTot = (JSPUtil.getParameter(request, prefix	+ "rhq_tot", length));
			String[] fcastTot = (JSPUtil.getParameter(request, prefix	+ "fcast_tot", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] itemText = (JSPUtil.getParameter(request, prefix	+ "item_text", length));
			String[] pfmcSmr = (JSPUtil.getParameter(request, prefix	+ "pfmc_smr", length));
			String[] initialTot = (JSPUtil.getParameter(request, prefix	+ "initial_tot", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyQuotaAdjustmentSlsRhqListVO();
				if (initial01[i] != null)
					model.setInitial01(initial01[i]);
				if (cmUcAmt[i] != null)
					model.setCmUcAmt(cmUcAmt[i]);
				if (polSeq[i] != null)
					model.setPolSeq(polSeq[i]);
				if (rhq01[i] != null)
					model.setRhq01(rhq01[i]);
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
				if (slsAqCd[i] != null)
					model.setSlsAqCd(slsAqCd[i]);
				if (opfitUcAmt[i] != null)
					model.setOpfitUcAmt(opfitUcAmt[i]);
				if (totRpb[i] != null)
					model.setTotRpb(totRpb[i]);
				if (slsAqCdSeq[i] != null)
					model.setSlsAqCdSeq(slsAqCdSeq[i]);
				if (laneGrp[i] != null)
					model.setLaneGrp(laneGrp[i]);
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
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (recentMonthly[i] != null)
					model.setRecentMonthly(recentMonthly[i]);
				if (totLod[i] != null)
					model.setTotLod(totLod[i]);
				if (model01[i] != null)
					model.setModel01(model01[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (recentMon[i] != null)
					model.setRecentMon(recentMon[i]);
				if (mdlRsltTot[i] != null)
					model.setMdlRsltTot(mdlRsltTot[i]);
				if (slevel[i] != null)
					model.setSlevel(slevel[i]);
				if (pfmcQta[i] != null)
					model.setPfmcQta(pfmcQta[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rhqTot[i] != null)
					model.setRhqTot(rhqTot[i]);
				if (fcastTot[i] != null)
					model.setFcastTot(fcastTot[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (itemText[i] != null)
					model.setItemText(itemText[i]);
				if (pfmcSmr[i] != null)
					model.setPfmcSmr(pfmcSmr[i]);
				if (initialTot[i] != null)
					model.setInitialTot(initialTot[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyQuotaAdjustmentSlsRhq0156List01VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyQuotaAdjustmentSlsRhq0156List01VO[]
	 */
	public SearchMonthlyQuotaAdjustmentSlsRhqListVO[] getSearchMonthlyQuotaAdjustmentSlsRhq0156List01VOs(){
		SearchMonthlyQuotaAdjustmentSlsRhqListVO[] vos = (SearchMonthlyQuotaAdjustmentSlsRhqListVO[])models.toArray(new SearchMonthlyQuotaAdjustmentSlsRhqListVO[models.size()]);
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
		this.rhq01 = this.rhq01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.slsAqCd = this.slsAqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opfitUcAmt = this.opfitUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totRpb = this.totRpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsAqCdSeq = this.slsAqCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrp = this.laneGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtGrpCd = this.sprtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSeq = this.podSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmUcAmt = this.raCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq = this.rowSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentMonthly = this.recentMonthly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLod = this.totLod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.model01 = this.model01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentMon = this.recentMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlRsltTot = this.mdlRsltTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slevel = this.slevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcQta = this.pfmcQta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqTot = this.rhqTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTot = this.fcastTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemText = this.itemText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcSmr = this.pfmcSmr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initialTot = this.initialTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
