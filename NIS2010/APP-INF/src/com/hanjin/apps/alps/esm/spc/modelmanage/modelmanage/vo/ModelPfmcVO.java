/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ModelPfmcVO.java
*@FileTitle : ModelPfmcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.31
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.31 진마리아 
* 1.0 Creation
* 2013.01.31 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진 
=========================================================*/

package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ModelPfmcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ModelPfmcVO> models = new ArrayList<ModelPfmcVO>();
	
	/* Column Info */
	private String avgPfmc40 = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String avgPfmc5 = null;
	/* Column Info */
	private String avgPfmc4 = null;
	/* Column Info */
	private String avgPfmc3 = null;
	/* Column Info */
	private String avgPfmc2 = null;
	/* Column Info */
	private String avgPfmc1 = null;
	/* Column Info */
	private String rlaneBkgQty = null;
	/* Column Info */
	private String custGrpNm = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String avgPfmc37 = null;
	/* Column Info */
	private String avgPfmc38 = null;
	/* Column Info */
	private String avgPfmc35 = null;
	/* Column Info */
	private String avgPfmc36 = null;
	/* Column Info */
	private String dtlSeq = null;
	/* Column Info */
	private String avgPfmc9 = null;
	/* Column Info */
	private String avgPfmc8 = null;
	/* Column Info */
	private String avgPfmc39 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String avgPfmc7 = null;
	/* Column Info */
	private String avgPfmc6 = null;
	/* Column Info */
	private String avgPfmc30 = null;
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String slsAqCd = null;
	/* Column Info */
	private String avgPfmc32 = null;
	/* Column Info */
	private String avgPfmc31 = null;
	/* Column Info */
	private String avgPfmc34 = null;
	/* Column Info */
	private String avgPfmc33 = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String avgPfmc24 = null;
	/* Column Info */
	private String avgPfmc25 = null;
	/* Column Info */
	private String avgPfmc26 = null;
	/* Column Info */
	private String perfStYrwk = null;
	/* Column Info */
	private String avgPfmc27 = null;
	/* Column Info */
	private String avgPfmc28 = null;
	/* Column Info */
	private String avgPfmc29 = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String costYrwk = null;
	/* Column Info */
	private String avgPfmc23 = null;
	/* Column Info */
	private String avgPfmc22 = null;
	/* Column Info */
	private String avgPfmc21 = null;
	/* Column Info */
	private String avgPfmc20 = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String avgPfmc = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String perfEndYrwk = null;
	/* Column Info */
	private String avgPfmc19 = null;
	/* Column Info */
	private String avgPfmc17 = null;
	/* Column Info */
	private String avgPfmc18 = null;
	/* Column Info */
	private String avgPfmc15 = null;
	/* Column Info */
	private String avgPfmc16 = null;
	/* Column Info */
	private String avgPfmc13 = null;
	/* Column Info */
	private String avgPfmc14 = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String avgPfmc10 = null;
	/* Column Info */
	private String avgPfmc12 = null;
	/* Column Info */
	private String avgPfmc11 = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String verSeq = null;
	/* Column Info */
	private String unit = null;
	/* Column Info */
	private String rlaneCmpbAmt = null;
	/* Column Info */
	private String duration = null;
	/* Column Info */
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String smplAvgPfmc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ModelPfmcVO() {}

	public ModelPfmcVO(String ibflag, String pagerows, String costYrwk, String trdCd, String rlaneCd, String slsRgnOfcCd, String custCntCd, String custSeq, String custLglEngNm, String custGrpNm, String dtlSeq, String scNo, String rfaNo, String subTrdCd, String slsRhqCd, String slsAqCd, String rlaneBkgQty, String rlaneCmpbAmt, String creUsrId, String creDt, String updUsrId, String updDt, String ctrtOfcCd, String custGrpId, String custCd, String duration, String perfStYrwk, String perfEndYrwk, String avgPfmc, String avgPfmc1, String avgPfmc2, String avgPfmc3, String avgPfmc4, String avgPfmc5, String avgPfmc6, String avgPfmc7, String avgPfmc8, String avgPfmc9, String avgPfmc10, String avgPfmc11, String avgPfmc12, String avgPfmc13, String avgPfmc14, String avgPfmc15, String avgPfmc16, String avgPfmc17, String avgPfmc18, String avgPfmc19, String avgPfmc20, String avgPfmc21, String avgPfmc22, String avgPfmc23, String avgPfmc24, String avgPfmc25, String avgPfmc26, String avgPfmc27, String avgPfmc28, String avgPfmc29, String avgPfmc30, String avgPfmc31, String avgPfmc32, String avgPfmc33, String avgPfmc34, String avgPfmc35, String avgPfmc36, String avgPfmc37, String avgPfmc38, String avgPfmc39, String avgPfmc40, String verSeq, String unit, String smplAvgPfmc) {
		this.avgPfmc40 = avgPfmc40;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.avgPfmc5 = avgPfmc5;
		this.avgPfmc4 = avgPfmc4;
		this.avgPfmc3 = avgPfmc3;
		this.avgPfmc2 = avgPfmc2;
		this.avgPfmc1 = avgPfmc1;
		this.rlaneBkgQty = rlaneBkgQty;
		this.custGrpNm = custGrpNm;
		this.ctrtOfcCd = ctrtOfcCd;
		this.scNo = scNo;
		this.avgPfmc37 = avgPfmc37;
		this.avgPfmc38 = avgPfmc38;
		this.avgPfmc35 = avgPfmc35;
		this.avgPfmc36 = avgPfmc36;
		this.dtlSeq = dtlSeq;
		this.avgPfmc9 = avgPfmc9;
		this.avgPfmc8 = avgPfmc8;
		this.avgPfmc39 = avgPfmc39;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.avgPfmc7 = avgPfmc7;
		this.avgPfmc6 = avgPfmc6;
		this.avgPfmc30 = avgPfmc30;
		this.custGrpId = custGrpId;
		this.slsAqCd = slsAqCd;
		this.avgPfmc32 = avgPfmc32;
		this.avgPfmc31 = avgPfmc31;
		this.avgPfmc34 = avgPfmc34;
		this.avgPfmc33 = avgPfmc33;
		this.slsRhqCd = slsRhqCd;
		this.custLglEngNm = custLglEngNm;
		this.creUsrId = creUsrId;
		this.custCd = custCd;
		this.avgPfmc24 = avgPfmc24;
		this.avgPfmc25 = avgPfmc25;
		this.avgPfmc26 = avgPfmc26;
		this.perfStYrwk = perfStYrwk;
		this.avgPfmc27 = avgPfmc27;
		this.avgPfmc28 = avgPfmc28;
		this.avgPfmc29 = avgPfmc29;
		this.subTrdCd = subTrdCd;
		this.costYrwk = costYrwk;
		this.avgPfmc23 = avgPfmc23;
		this.avgPfmc22 = avgPfmc22;
		this.avgPfmc21 = avgPfmc21;
		this.avgPfmc20 = avgPfmc20;
		this.creDt = creDt;
		this.avgPfmc = avgPfmc;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.perfEndYrwk = perfEndYrwk;
		this.avgPfmc19 = avgPfmc19;
		this.avgPfmc17 = avgPfmc17;
		this.avgPfmc18 = avgPfmc18;
		this.avgPfmc15 = avgPfmc15;
		this.avgPfmc16 = avgPfmc16;
		this.avgPfmc13 = avgPfmc13;
		this.avgPfmc14 = avgPfmc14;
		this.updDt = updDt;
		this.avgPfmc10 = avgPfmc10;
		this.avgPfmc12 = avgPfmc12;
		this.avgPfmc11 = avgPfmc11;
		this.custSeq = custSeq;
		this.verSeq = verSeq;
		this.unit = unit;
		this.rlaneCmpbAmt = rlaneCmpbAmt;
		this.duration = duration;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.smplAvgPfmc = smplAvgPfmc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("avg_pfmc_40", getAvgPfmc40());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("avg_pfmc_5", getAvgPfmc5());
		this.hashColumns.put("avg_pfmc_4", getAvgPfmc4());
		this.hashColumns.put("avg_pfmc_3", getAvgPfmc3());
		this.hashColumns.put("avg_pfmc_2", getAvgPfmc2());
		this.hashColumns.put("avg_pfmc_1", getAvgPfmc1());
		this.hashColumns.put("rlane_bkg_qty", getRlaneBkgQty());
		this.hashColumns.put("cust_grp_nm", getCustGrpNm());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("avg_pfmc_37", getAvgPfmc37());
		this.hashColumns.put("avg_pfmc_38", getAvgPfmc38());
		this.hashColumns.put("avg_pfmc_35", getAvgPfmc35());
		this.hashColumns.put("avg_pfmc_36", getAvgPfmc36());
		this.hashColumns.put("dtl_seq", getDtlSeq());
		this.hashColumns.put("avg_pfmc_9", getAvgPfmc9());
		this.hashColumns.put("avg_pfmc_8", getAvgPfmc8());
		this.hashColumns.put("avg_pfmc_39", getAvgPfmc39());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("avg_pfmc_7", getAvgPfmc7());
		this.hashColumns.put("avg_pfmc_6", getAvgPfmc6());
		this.hashColumns.put("avg_pfmc_30", getAvgPfmc30());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("sls_aq_cd", getSlsAqCd());
		this.hashColumns.put("avg_pfmc_32", getAvgPfmc32());
		this.hashColumns.put("avg_pfmc_31", getAvgPfmc31());
		this.hashColumns.put("avg_pfmc_34", getAvgPfmc34());
		this.hashColumns.put("avg_pfmc_33", getAvgPfmc33());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("avg_pfmc_24", getAvgPfmc24());
		this.hashColumns.put("avg_pfmc_25", getAvgPfmc25());
		this.hashColumns.put("avg_pfmc_26", getAvgPfmc26());
		this.hashColumns.put("perf_st_yrwk", getPerfStYrwk());
		this.hashColumns.put("avg_pfmc_27", getAvgPfmc27());
		this.hashColumns.put("avg_pfmc_28", getAvgPfmc28());
		this.hashColumns.put("avg_pfmc_29", getAvgPfmc29());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("cost_yrwk", getCostYrwk());
		this.hashColumns.put("avg_pfmc_23", getAvgPfmc23());
		this.hashColumns.put("avg_pfmc_22", getAvgPfmc22());
		this.hashColumns.put("avg_pfmc_21", getAvgPfmc21());
		this.hashColumns.put("avg_pfmc_20", getAvgPfmc20());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("avg_pfmc", getAvgPfmc());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("perf_end_yrwk", getPerfEndYrwk());
		this.hashColumns.put("avg_pfmc_19", getAvgPfmc19());
		this.hashColumns.put("avg_pfmc_17", getAvgPfmc17());
		this.hashColumns.put("avg_pfmc_18", getAvgPfmc18());
		this.hashColumns.put("avg_pfmc_15", getAvgPfmc15());
		this.hashColumns.put("avg_pfmc_16", getAvgPfmc16());
		this.hashColumns.put("avg_pfmc_13", getAvgPfmc13());
		this.hashColumns.put("avg_pfmc_14", getAvgPfmc14());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("avg_pfmc_10", getAvgPfmc10());
		this.hashColumns.put("avg_pfmc_12", getAvgPfmc12());
		this.hashColumns.put("avg_pfmc_11", getAvgPfmc11());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("unit", getUnit());
		this.hashColumns.put("rlane_cmpb_amt", getRlaneCmpbAmt());
		this.hashColumns.put("duration", getDuration());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("smpl_avg_pfmc", getSmplAvgPfmc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("avg_pfmc_40", "avgPfmc40");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("avg_pfmc_5", "avgPfmc5");
		this.hashFields.put("avg_pfmc_4", "avgPfmc4");
		this.hashFields.put("avg_pfmc_3", "avgPfmc3");
		this.hashFields.put("avg_pfmc_2", "avgPfmc2");
		this.hashFields.put("avg_pfmc_1", "avgPfmc1");
		this.hashFields.put("rlane_bkg_qty", "rlaneBkgQty");
		this.hashFields.put("cust_grp_nm", "custGrpNm");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("avg_pfmc_37", "avgPfmc37");
		this.hashFields.put("avg_pfmc_38", "avgPfmc38");
		this.hashFields.put("avg_pfmc_35", "avgPfmc35");
		this.hashFields.put("avg_pfmc_36", "avgPfmc36");
		this.hashFields.put("dtl_seq", "dtlSeq");
		this.hashFields.put("avg_pfmc_9", "avgPfmc9");
		this.hashFields.put("avg_pfmc_8", "avgPfmc8");
		this.hashFields.put("avg_pfmc_39", "avgPfmc39");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("avg_pfmc_7", "avgPfmc7");
		this.hashFields.put("avg_pfmc_6", "avgPfmc6");
		this.hashFields.put("avg_pfmc_30", "avgPfmc30");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("sls_aq_cd", "slsAqCd");
		this.hashFields.put("avg_pfmc_32", "avgPfmc32");
		this.hashFields.put("avg_pfmc_31", "avgPfmc31");
		this.hashFields.put("avg_pfmc_34", "avgPfmc34");
		this.hashFields.put("avg_pfmc_33", "avgPfmc33");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("avg_pfmc_24", "avgPfmc24");
		this.hashFields.put("avg_pfmc_25", "avgPfmc25");
		this.hashFields.put("avg_pfmc_26", "avgPfmc26");
		this.hashFields.put("perf_st_yrwk", "perfStYrwk");
		this.hashFields.put("avg_pfmc_27", "avgPfmc27");
		this.hashFields.put("avg_pfmc_28", "avgPfmc28");
		this.hashFields.put("avg_pfmc_29", "avgPfmc29");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("cost_yrwk", "costYrwk");
		this.hashFields.put("avg_pfmc_23", "avgPfmc23");
		this.hashFields.put("avg_pfmc_22", "avgPfmc22");
		this.hashFields.put("avg_pfmc_21", "avgPfmc21");
		this.hashFields.put("avg_pfmc_20", "avgPfmc20");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("avg_pfmc", "avgPfmc");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("perf_end_yrwk", "perfEndYrwk");
		this.hashFields.put("avg_pfmc_19", "avgPfmc19");
		this.hashFields.put("avg_pfmc_17", "avgPfmc17");
		this.hashFields.put("avg_pfmc_18", "avgPfmc18");
		this.hashFields.put("avg_pfmc_15", "avgPfmc15");
		this.hashFields.put("avg_pfmc_16", "avgPfmc16");
		this.hashFields.put("avg_pfmc_13", "avgPfmc13");
		this.hashFields.put("avg_pfmc_14", "avgPfmc14");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("avg_pfmc_10", "avgPfmc10");
		this.hashFields.put("avg_pfmc_12", "avgPfmc12");
		this.hashFields.put("avg_pfmc_11", "avgPfmc11");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("unit", "unit");
		this.hashFields.put("rlane_cmpb_amt", "rlaneCmpbAmt");
		this.hashFields.put("duration", "duration");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("smpl_avg_pfmc", "smplAvgPfmc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc40
	 */
	public String getAvgPfmc40() {
		return this.avgPfmc40;
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
	 * @return avgPfmc5
	 */
	public String getAvgPfmc5() {
		return this.avgPfmc5;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc4
	 */
	public String getAvgPfmc4() {
		return this.avgPfmc4;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc3
	 */
	public String getAvgPfmc3() {
		return this.avgPfmc3;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc2
	 */
	public String getAvgPfmc2() {
		return this.avgPfmc2;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc1
	 */
	public String getAvgPfmc1() {
		return this.avgPfmc1;
	}
	
	/**
	 * Column Info
	 * @return rlaneBkgQty
	 */
	public String getRlaneBkgQty() {
		return this.rlaneBkgQty;
	}
	
	/**
	 * Column Info
	 * @return custGrpNm
	 */
	public String getCustGrpNm() {
		return this.custGrpNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc37
	 */
	public String getAvgPfmc37() {
		return this.avgPfmc37;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc38
	 */
	public String getAvgPfmc38() {
		return this.avgPfmc38;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc35
	 */
	public String getAvgPfmc35() {
		return this.avgPfmc35;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc36
	 */
	public String getAvgPfmc36() {
		return this.avgPfmc36;
	}
	
	/**
	 * Column Info
	 * @return dtlSeq
	 */
	public String getDtlSeq() {
		return this.dtlSeq;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc9
	 */
	public String getAvgPfmc9() {
		return this.avgPfmc9;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc8
	 */
	public String getAvgPfmc8() {
		return this.avgPfmc8;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc39
	 */
	public String getAvgPfmc39() {
		return this.avgPfmc39;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc7
	 */
	public String getAvgPfmc7() {
		return this.avgPfmc7;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc6
	 */
	public String getAvgPfmc6() {
		return this.avgPfmc6;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc30
	 */
	public String getAvgPfmc30() {
		return this.avgPfmc30;
	}
	
	/**
	 * Column Info
	 * @return custGrpId
	 */
	public String getCustGrpId() {
		return this.custGrpId;
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
	 * @return avgPfmc32
	 */
	public String getAvgPfmc32() {
		return this.avgPfmc32;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc31
	 */
	public String getAvgPfmc31() {
		return this.avgPfmc31;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc34
	 */
	public String getAvgPfmc34() {
		return this.avgPfmc34;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc33
	 */
	public String getAvgPfmc33() {
		return this.avgPfmc33;
	}
	
	/**
	 * Column Info
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc24
	 */
	public String getAvgPfmc24() {
		return this.avgPfmc24;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc25
	 */
	public String getAvgPfmc25() {
		return this.avgPfmc25;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc26
	 */
	public String getAvgPfmc26() {
		return this.avgPfmc26;
	}
	
	/**
	 * Column Info
	 * @return perfStYrwk
	 */
	public String getPerfStYrwk() {
		return this.perfStYrwk;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc27
	 */
	public String getAvgPfmc27() {
		return this.avgPfmc27;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc28
	 */
	public String getAvgPfmc28() {
		return this.avgPfmc28;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc29
	 */
	public String getAvgPfmc29() {
		return this.avgPfmc29;
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
	 * @return costYrwk
	 */
	public String getCostYrwk() {
		return this.costYrwk;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc23
	 */
	public String getAvgPfmc23() {
		return this.avgPfmc23;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc22
	 */
	public String getAvgPfmc22() {
		return this.avgPfmc22;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc21
	 */
	public String getAvgPfmc21() {
		return this.avgPfmc21;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc20
	 */
	public String getAvgPfmc20() {
		return this.avgPfmc20;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc
	 */
	public String getAvgPfmc() {
		return this.avgPfmc;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return perfEndYrwk
	 */
	public String getPerfEndYrwk() {
		return this.perfEndYrwk;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc19
	 */
	public String getAvgPfmc19() {
		return this.avgPfmc19;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc17
	 */
	public String getAvgPfmc17() {
		return this.avgPfmc17;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc18
	 */
	public String getAvgPfmc18() {
		return this.avgPfmc18;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc15
	 */
	public String getAvgPfmc15() {
		return this.avgPfmc15;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc16
	 */
	public String getAvgPfmc16() {
		return this.avgPfmc16;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc13
	 */
	public String getAvgPfmc13() {
		return this.avgPfmc13;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc14
	 */
	public String getAvgPfmc14() {
		return this.avgPfmc14;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc10
	 */
	public String getAvgPfmc10() {
		return this.avgPfmc10;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc12
	 */
	public String getAvgPfmc12() {
		return this.avgPfmc12;
	}
	
	/**
	 * Column Info
	 * @return avgPfmc11
	 */
	public String getAvgPfmc11() {
		return this.avgPfmc11;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return verSeq
	 */
	public String getVerSeq() {
		return this.verSeq;
	}
	
	/**
	 * Column Info
	 * @return unit
	 */
	public String getUnit() {
		return this.unit;
	}
	
	/**
	 * Column Info
	 * @return rlaneCmpbAmt
	 */
	public String getRlaneCmpbAmt() {
		return this.rlaneCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return duration
	 */
	public String getDuration() {
		return this.duration;
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
	 * @return smplAvgPfmc
	 */
	public String getSmplAvgPfmc() {
		return this.smplAvgPfmc;
	}
	

	/**
	 * Column Info
	 * @param avgPfmc40
	 */
	public void setAvgPfmc40(String avgPfmc40) {
		this.avgPfmc40 = avgPfmc40;
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
	 * @param avgPfmc5
	 */
	public void setAvgPfmc5(String avgPfmc5) {
		this.avgPfmc5 = avgPfmc5;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc4
	 */
	public void setAvgPfmc4(String avgPfmc4) {
		this.avgPfmc4 = avgPfmc4;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc3
	 */
	public void setAvgPfmc3(String avgPfmc3) {
		this.avgPfmc3 = avgPfmc3;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc2
	 */
	public void setAvgPfmc2(String avgPfmc2) {
		this.avgPfmc2 = avgPfmc2;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc1
	 */
	public void setAvgPfmc1(String avgPfmc1) {
		this.avgPfmc1 = avgPfmc1;
	}
	
	/**
	 * Column Info
	 * @param rlaneBkgQty
	 */
	public void setRlaneBkgQty(String rlaneBkgQty) {
		this.rlaneBkgQty = rlaneBkgQty;
	}
	
	/**
	 * Column Info
	 * @param custGrpNm
	 */
	public void setCustGrpNm(String custGrpNm) {
		this.custGrpNm = custGrpNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc37
	 */
	public void setAvgPfmc37(String avgPfmc37) {
		this.avgPfmc37 = avgPfmc37;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc38
	 */
	public void setAvgPfmc38(String avgPfmc38) {
		this.avgPfmc38 = avgPfmc38;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc35
	 */
	public void setAvgPfmc35(String avgPfmc35) {
		this.avgPfmc35 = avgPfmc35;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc36
	 */
	public void setAvgPfmc36(String avgPfmc36) {
		this.avgPfmc36 = avgPfmc36;
	}
	
	/**
	 * Column Info
	 * @param dtlSeq
	 */
	public void setDtlSeq(String dtlSeq) {
		this.dtlSeq = dtlSeq;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc9
	 */
	public void setAvgPfmc9(String avgPfmc9) {
		this.avgPfmc9 = avgPfmc9;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc8
	 */
	public void setAvgPfmc8(String avgPfmc8) {
		this.avgPfmc8 = avgPfmc8;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc39
	 */
	public void setAvgPfmc39(String avgPfmc39) {
		this.avgPfmc39 = avgPfmc39;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc7
	 */
	public void setAvgPfmc7(String avgPfmc7) {
		this.avgPfmc7 = avgPfmc7;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc6
	 */
	public void setAvgPfmc6(String avgPfmc6) {
		this.avgPfmc6 = avgPfmc6;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc30
	 */
	public void setAvgPfmc30(String avgPfmc30) {
		this.avgPfmc30 = avgPfmc30;
	}
	
	/**
	 * Column Info
	 * @param custGrpId
	 */
	public void setCustGrpId(String custGrpId) {
		this.custGrpId = custGrpId;
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
	 * @param avgPfmc32
	 */
	public void setAvgPfmc32(String avgPfmc32) {
		this.avgPfmc32 = avgPfmc32;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc31
	 */
	public void setAvgPfmc31(String avgPfmc31) {
		this.avgPfmc31 = avgPfmc31;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc34
	 */
	public void setAvgPfmc34(String avgPfmc34) {
		this.avgPfmc34 = avgPfmc34;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc33
	 */
	public void setAvgPfmc33(String avgPfmc33) {
		this.avgPfmc33 = avgPfmc33;
	}
	
	/**
	 * Column Info
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc24
	 */
	public void setAvgPfmc24(String avgPfmc24) {
		this.avgPfmc24 = avgPfmc24;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc25
	 */
	public void setAvgPfmc25(String avgPfmc25) {
		this.avgPfmc25 = avgPfmc25;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc26
	 */
	public void setAvgPfmc26(String avgPfmc26) {
		this.avgPfmc26 = avgPfmc26;
	}
	
	/**
	 * Column Info
	 * @param perfStYrwk
	 */
	public void setPerfStYrwk(String perfStYrwk) {
		this.perfStYrwk = perfStYrwk;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc27
	 */
	public void setAvgPfmc27(String avgPfmc27) {
		this.avgPfmc27 = avgPfmc27;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc28
	 */
	public void setAvgPfmc28(String avgPfmc28) {
		this.avgPfmc28 = avgPfmc28;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc29
	 */
	public void setAvgPfmc29(String avgPfmc29) {
		this.avgPfmc29 = avgPfmc29;
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
	 * @param costYrwk
	 */
	public void setCostYrwk(String costYrwk) {
		this.costYrwk = costYrwk;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc23
	 */
	public void setAvgPfmc23(String avgPfmc23) {
		this.avgPfmc23 = avgPfmc23;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc22
	 */
	public void setAvgPfmc22(String avgPfmc22) {
		this.avgPfmc22 = avgPfmc22;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc21
	 */
	public void setAvgPfmc21(String avgPfmc21) {
		this.avgPfmc21 = avgPfmc21;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc20
	 */
	public void setAvgPfmc20(String avgPfmc20) {
		this.avgPfmc20 = avgPfmc20;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc
	 */
	public void setAvgPfmc(String avgPfmc) {
		this.avgPfmc = avgPfmc;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param perfEndYrwk
	 */
	public void setPerfEndYrwk(String perfEndYrwk) {
		this.perfEndYrwk = perfEndYrwk;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc19
	 */
	public void setAvgPfmc19(String avgPfmc19) {
		this.avgPfmc19 = avgPfmc19;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc17
	 */
	public void setAvgPfmc17(String avgPfmc17) {
		this.avgPfmc17 = avgPfmc17;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc18
	 */
	public void setAvgPfmc18(String avgPfmc18) {
		this.avgPfmc18 = avgPfmc18;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc15
	 */
	public void setAvgPfmc15(String avgPfmc15) {
		this.avgPfmc15 = avgPfmc15;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc16
	 */
	public void setAvgPfmc16(String avgPfmc16) {
		this.avgPfmc16 = avgPfmc16;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc13
	 */
	public void setAvgPfmc13(String avgPfmc13) {
		this.avgPfmc13 = avgPfmc13;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc14
	 */
	public void setAvgPfmc14(String avgPfmc14) {
		this.avgPfmc14 = avgPfmc14;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc10
	 */
	public void setAvgPfmc10(String avgPfmc10) {
		this.avgPfmc10 = avgPfmc10;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc12
	 */
	public void setAvgPfmc12(String avgPfmc12) {
		this.avgPfmc12 = avgPfmc12;
	}
	
	/**
	 * Column Info
	 * @param avgPfmc11
	 */
	public void setAvgPfmc11(String avgPfmc11) {
		this.avgPfmc11 = avgPfmc11;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param verSeq
	 */
	public void setVerSeq(String verSeq) {
		this.verSeq = verSeq;
	}
	
	/**
	 * Column Info
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	/**
	 * Column Info
	 * @param rlaneCmpbAmt
	 */
	public void setRlaneCmpbAmt(String rlaneCmpbAmt) {
		this.rlaneCmpbAmt = rlaneCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
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
	 * @param smplAvgPfmc
	 */
	public void setSmplAvgPfmc(String smplAvgPfmc) {
		this.smplAvgPfmc = smplAvgPfmc;
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
		setAvgPfmc40(JSPUtil.getParameter(request, prefix + "avg_pfmc_40", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAvgPfmc5(JSPUtil.getParameter(request, prefix + "avg_pfmc_5", ""));
		setAvgPfmc4(JSPUtil.getParameter(request, prefix + "avg_pfmc_4", ""));
		setAvgPfmc3(JSPUtil.getParameter(request, prefix + "avg_pfmc_3", ""));
		setAvgPfmc2(JSPUtil.getParameter(request, prefix + "avg_pfmc_2", ""));
		setAvgPfmc1(JSPUtil.getParameter(request, prefix + "avg_pfmc_1", ""));
		setRlaneBkgQty(JSPUtil.getParameter(request, prefix + "rlane_bkg_qty", ""));
		setCustGrpNm(JSPUtil.getParameter(request, prefix + "cust_grp_nm", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setAvgPfmc37(JSPUtil.getParameter(request, prefix + "avg_pfmc_37", ""));
		setAvgPfmc38(JSPUtil.getParameter(request, prefix + "avg_pfmc_38", ""));
		setAvgPfmc35(JSPUtil.getParameter(request, prefix + "avg_pfmc_35", ""));
		setAvgPfmc36(JSPUtil.getParameter(request, prefix + "avg_pfmc_36", ""));
		setDtlSeq(JSPUtil.getParameter(request, prefix + "dtl_seq", ""));
		setAvgPfmc9(JSPUtil.getParameter(request, prefix + "avg_pfmc_9", ""));
		setAvgPfmc8(JSPUtil.getParameter(request, prefix + "avg_pfmc_8", ""));
		setAvgPfmc39(JSPUtil.getParameter(request, prefix + "avg_pfmc_39", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setAvgPfmc7(JSPUtil.getParameter(request, prefix + "avg_pfmc_7", ""));
		setAvgPfmc6(JSPUtil.getParameter(request, prefix + "avg_pfmc_6", ""));
		setAvgPfmc30(JSPUtil.getParameter(request, prefix + "avg_pfmc_30", ""));
		setCustGrpId(JSPUtil.getParameter(request, prefix + "cust_grp_id", ""));
		setSlsAqCd(JSPUtil.getParameter(request, prefix + "sls_aq_cd", ""));
		setAvgPfmc32(JSPUtil.getParameter(request, prefix + "avg_pfmc_32", ""));
		setAvgPfmc31(JSPUtil.getParameter(request, prefix + "avg_pfmc_31", ""));
		setAvgPfmc34(JSPUtil.getParameter(request, prefix + "avg_pfmc_34", ""));
		setAvgPfmc33(JSPUtil.getParameter(request, prefix + "avg_pfmc_33", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setAvgPfmc24(JSPUtil.getParameter(request, prefix + "avg_pfmc_24", ""));
		setAvgPfmc25(JSPUtil.getParameter(request, prefix + "avg_pfmc_25", ""));
		setAvgPfmc26(JSPUtil.getParameter(request, prefix + "avg_pfmc_26", ""));
		setPerfStYrwk(JSPUtil.getParameter(request, prefix + "perf_st_yrwk", ""));
		setAvgPfmc27(JSPUtil.getParameter(request, prefix + "avg_pfmc_27", ""));
		setAvgPfmc28(JSPUtil.getParameter(request, prefix + "avg_pfmc_28", ""));
		setAvgPfmc29(JSPUtil.getParameter(request, prefix + "avg_pfmc_29", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setCostYrwk(JSPUtil.getParameter(request, prefix + "cost_yrwk", ""));
		setAvgPfmc23(JSPUtil.getParameter(request, prefix + "avg_pfmc_23", ""));
		setAvgPfmc22(JSPUtil.getParameter(request, prefix + "avg_pfmc_22", ""));
		setAvgPfmc21(JSPUtil.getParameter(request, prefix + "avg_pfmc_21", ""));
		setAvgPfmc20(JSPUtil.getParameter(request, prefix + "avg_pfmc_20", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAvgPfmc(JSPUtil.getParameter(request, prefix + "avg_pfmc", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPerfEndYrwk(JSPUtil.getParameter(request, prefix + "perf_end_yrwk", ""));
		setAvgPfmc19(JSPUtil.getParameter(request, prefix + "avg_pfmc_19", ""));
		setAvgPfmc17(JSPUtil.getParameter(request, prefix + "avg_pfmc_17", ""));
		setAvgPfmc18(JSPUtil.getParameter(request, prefix + "avg_pfmc_18", ""));
		setAvgPfmc15(JSPUtil.getParameter(request, prefix + "avg_pfmc_15", ""));
		setAvgPfmc16(JSPUtil.getParameter(request, prefix + "avg_pfmc_16", ""));
		setAvgPfmc13(JSPUtil.getParameter(request, prefix + "avg_pfmc_13", ""));
		setAvgPfmc14(JSPUtil.getParameter(request, prefix + "avg_pfmc_14", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setAvgPfmc10(JSPUtil.getParameter(request, prefix + "avg_pfmc_10", ""));
		setAvgPfmc12(JSPUtil.getParameter(request, prefix + "avg_pfmc_12", ""));
		setAvgPfmc11(JSPUtil.getParameter(request, prefix + "avg_pfmc_11", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setVerSeq(JSPUtil.getParameter(request, prefix + "ver_seq", ""));
		setUnit(JSPUtil.getParameter(request, prefix + "unit", ""));
		setRlaneCmpbAmt(JSPUtil.getParameter(request, prefix + "rlane_cmpb_amt", ""));
		setDuration(JSPUtil.getParameter(request, prefix + "duration", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "sls_rgn_ofc_cd", ""));
		setSmplAvgPfmc(JSPUtil.getParameter(request, prefix + "smpl_avg_pfmc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ModelPfmcVO[]
	 */
	public ModelPfmcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ModelPfmcVO[]
	 */
	public ModelPfmcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ModelPfmcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] avgPfmc40 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_40", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] avgPfmc5 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_5", length));
			String[] avgPfmc4 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_4", length));
			String[] avgPfmc3 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_3", length));
			String[] avgPfmc2 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_2", length));
			String[] avgPfmc1 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_1", length));
			String[] rlaneBkgQty = (JSPUtil.getParameter(request, prefix	+ "rlane_bkg_qty", length));
			String[] custGrpNm = (JSPUtil.getParameter(request, prefix	+ "cust_grp_nm", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] avgPfmc37 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_37", length));
			String[] avgPfmc38 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_38", length));
			String[] avgPfmc35 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_35", length));
			String[] avgPfmc36 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_36", length));
			String[] dtlSeq = (JSPUtil.getParameter(request, prefix	+ "dtl_seq", length));
			String[] avgPfmc9 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_9", length));
			String[] avgPfmc8 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_8", length));
			String[] avgPfmc39 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_39", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] avgPfmc7 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_7", length));
			String[] avgPfmc6 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_6", length));
			String[] avgPfmc30 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_30", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] slsAqCd = (JSPUtil.getParameter(request, prefix	+ "sls_aq_cd", length));
			String[] avgPfmc32 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_32", length));
			String[] avgPfmc31 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_31", length));
			String[] avgPfmc34 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_34", length));
			String[] avgPfmc33 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_33", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] avgPfmc24 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_24", length));
			String[] avgPfmc25 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_25", length));
			String[] avgPfmc26 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_26", length));
			String[] perfStYrwk = (JSPUtil.getParameter(request, prefix	+ "perf_st_yrwk", length));
			String[] avgPfmc27 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_27", length));
			String[] avgPfmc28 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_28", length));
			String[] avgPfmc29 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_29", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] costYrwk = (JSPUtil.getParameter(request, prefix	+ "cost_yrwk", length));
			String[] avgPfmc23 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_23", length));
			String[] avgPfmc22 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_22", length));
			String[] avgPfmc21 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_21", length));
			String[] avgPfmc20 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_20", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] avgPfmc = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] perfEndYrwk = (JSPUtil.getParameter(request, prefix	+ "perf_end_yrwk", length));
			String[] avgPfmc19 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_19", length));
			String[] avgPfmc17 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_17", length));
			String[] avgPfmc18 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_18", length));
			String[] avgPfmc15 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_15", length));
			String[] avgPfmc16 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_16", length));
			String[] avgPfmc13 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_13", length));
			String[] avgPfmc14 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_14", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] avgPfmc10 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_10", length));
			String[] avgPfmc12 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_12", length));
			String[] avgPfmc11 = (JSPUtil.getParameter(request, prefix	+ "avg_pfmc_11", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq", length));
			String[] unit = (JSPUtil.getParameter(request, prefix	+ "unit", length));
			String[] rlaneCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "rlane_cmpb_amt", length));
			String[] duration = (JSPUtil.getParameter(request, prefix	+ "duration", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			String[] smplAvgPfmc = (JSPUtil.getParameter(request, prefix	+ "smpl_avg_pfmc", length));
			
			for (int i = 0; i < length; i++) {
				model = new ModelPfmcVO();
				if (avgPfmc40[i] != null)
					model.setAvgPfmc40(avgPfmc40[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (avgPfmc5[i] != null)
					model.setAvgPfmc5(avgPfmc5[i]);
				if (avgPfmc4[i] != null)
					model.setAvgPfmc4(avgPfmc4[i]);
				if (avgPfmc3[i] != null)
					model.setAvgPfmc3(avgPfmc3[i]);
				if (avgPfmc2[i] != null)
					model.setAvgPfmc2(avgPfmc2[i]);
				if (avgPfmc1[i] != null)
					model.setAvgPfmc1(avgPfmc1[i]);
				if (rlaneBkgQty[i] != null)
					model.setRlaneBkgQty(rlaneBkgQty[i]);
				if (custGrpNm[i] != null)
					model.setCustGrpNm(custGrpNm[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (avgPfmc37[i] != null)
					model.setAvgPfmc37(avgPfmc37[i]);
				if (avgPfmc38[i] != null)
					model.setAvgPfmc38(avgPfmc38[i]);
				if (avgPfmc35[i] != null)
					model.setAvgPfmc35(avgPfmc35[i]);
				if (avgPfmc36[i] != null)
					model.setAvgPfmc36(avgPfmc36[i]);
				if (dtlSeq[i] != null)
					model.setDtlSeq(dtlSeq[i]);
				if (avgPfmc9[i] != null)
					model.setAvgPfmc9(avgPfmc9[i]);
				if (avgPfmc8[i] != null)
					model.setAvgPfmc8(avgPfmc8[i]);
				if (avgPfmc39[i] != null)
					model.setAvgPfmc39(avgPfmc39[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (avgPfmc7[i] != null)
					model.setAvgPfmc7(avgPfmc7[i]);
				if (avgPfmc6[i] != null)
					model.setAvgPfmc6(avgPfmc6[i]);
				if (avgPfmc30[i] != null)
					model.setAvgPfmc30(avgPfmc30[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (slsAqCd[i] != null)
					model.setSlsAqCd(slsAqCd[i]);
				if (avgPfmc32[i] != null)
					model.setAvgPfmc32(avgPfmc32[i]);
				if (avgPfmc31[i] != null)
					model.setAvgPfmc31(avgPfmc31[i]);
				if (avgPfmc34[i] != null)
					model.setAvgPfmc34(avgPfmc34[i]);
				if (avgPfmc33[i] != null)
					model.setAvgPfmc33(avgPfmc33[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (avgPfmc24[i] != null)
					model.setAvgPfmc24(avgPfmc24[i]);
				if (avgPfmc25[i] != null)
					model.setAvgPfmc25(avgPfmc25[i]);
				if (avgPfmc26[i] != null)
					model.setAvgPfmc26(avgPfmc26[i]);
				if (perfStYrwk[i] != null)
					model.setPerfStYrwk(perfStYrwk[i]);
				if (avgPfmc27[i] != null)
					model.setAvgPfmc27(avgPfmc27[i]);
				if (avgPfmc28[i] != null)
					model.setAvgPfmc28(avgPfmc28[i]);
				if (avgPfmc29[i] != null)
					model.setAvgPfmc29(avgPfmc29[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (costYrwk[i] != null)
					model.setCostYrwk(costYrwk[i]);
				if (avgPfmc23[i] != null)
					model.setAvgPfmc23(avgPfmc23[i]);
				if (avgPfmc22[i] != null)
					model.setAvgPfmc22(avgPfmc22[i]);
				if (avgPfmc21[i] != null)
					model.setAvgPfmc21(avgPfmc21[i]);
				if (avgPfmc20[i] != null)
					model.setAvgPfmc20(avgPfmc20[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (avgPfmc[i] != null)
					model.setAvgPfmc(avgPfmc[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (perfEndYrwk[i] != null)
					model.setPerfEndYrwk(perfEndYrwk[i]);
				if (avgPfmc19[i] != null)
					model.setAvgPfmc19(avgPfmc19[i]);
				if (avgPfmc17[i] != null)
					model.setAvgPfmc17(avgPfmc17[i]);
				if (avgPfmc18[i] != null)
					model.setAvgPfmc18(avgPfmc18[i]);
				if (avgPfmc15[i] != null)
					model.setAvgPfmc15(avgPfmc15[i]);
				if (avgPfmc16[i] != null)
					model.setAvgPfmc16(avgPfmc16[i]);
				if (avgPfmc13[i] != null)
					model.setAvgPfmc13(avgPfmc13[i]);
				if (avgPfmc14[i] != null)
					model.setAvgPfmc14(avgPfmc14[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (avgPfmc10[i] != null)
					model.setAvgPfmc10(avgPfmc10[i]);
				if (avgPfmc12[i] != null)
					model.setAvgPfmc12(avgPfmc12[i]);
				if (avgPfmc11[i] != null)
					model.setAvgPfmc11(avgPfmc11[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (verSeq[i] != null)
					model.setVerSeq(verSeq[i]);
				if (unit[i] != null)
					model.setUnit(unit[i]);
				if (rlaneCmpbAmt[i] != null)
					model.setRlaneCmpbAmt(rlaneCmpbAmt[i]);
				if (duration[i] != null)
					model.setDuration(duration[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (smplAvgPfmc[i] != null)
					model.setSmplAvgPfmc(smplAvgPfmc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getModelPfmcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ModelPfmcVO[]
	 */
	public ModelPfmcVO[] getModelPfmcVOs(){
		ModelPfmcVO[] vos = (ModelPfmcVO[])models.toArray(new ModelPfmcVO[models.size()]);
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
		this.avgPfmc40 = this.avgPfmc40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc5 = this.avgPfmc5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc4 = this.avgPfmc4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc3 = this.avgPfmc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc2 = this.avgPfmc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc1 = this.avgPfmc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneBkgQty = this.rlaneBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpNm = this.custGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc37 = this.avgPfmc37 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc38 = this.avgPfmc38 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc35 = this.avgPfmc35 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc36 = this.avgPfmc36 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlSeq = this.dtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc9 = this.avgPfmc9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc8 = this.avgPfmc8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc39 = this.avgPfmc39 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc7 = this.avgPfmc7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc6 = this.avgPfmc6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc30 = this.avgPfmc30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsAqCd = this.slsAqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc32 = this.avgPfmc32 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc31 = this.avgPfmc31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc34 = this.avgPfmc34 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc33 = this.avgPfmc33 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc24 = this.avgPfmc24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc25 = this.avgPfmc25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc26 = this.avgPfmc26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfStYrwk = this.perfStYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc27 = this.avgPfmc27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc28 = this.avgPfmc28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc29 = this.avgPfmc29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrwk = this.costYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc23 = this.avgPfmc23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc22 = this.avgPfmc22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc21 = this.avgPfmc21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc20 = this.avgPfmc20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc = this.avgPfmc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfEndYrwk = this.perfEndYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc19 = this.avgPfmc19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc17 = this.avgPfmc17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc18 = this.avgPfmc18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc15 = this.avgPfmc15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc16 = this.avgPfmc16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc13 = this.avgPfmc13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc14 = this.avgPfmc14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc10 = this.avgPfmc10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc12 = this.avgPfmc12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPfmc11 = this.avgPfmc11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit = this.unit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCmpbAmt = this.rlaneCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration = this.duration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smplAvgPfmc = this.smplAvgPfmc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
