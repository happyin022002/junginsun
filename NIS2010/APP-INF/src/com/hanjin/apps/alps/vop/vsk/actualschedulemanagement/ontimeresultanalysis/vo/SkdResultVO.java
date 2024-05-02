/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SkdResultVO.java
*@FileTitle : SkdResultVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo;

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

public class SkdResultVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SkdResultVO> models = new ArrayList<SkdResultVO>();
	
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String subTrdDirCd = null;
	/* Column Info */
	private String actBrthDt = null;
	/* Column Info */
	private String arrRmk1 = null;
	/* Column Info */
	private String arrRmk2 = null;
	/* Column Info */
	private String vskdRsltXcldCd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String xcldBrthDlayHrs = null;
	/* Column Info */
	private String depDlayRsnCd2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String depDlayRsnCd1 = null;
	/* Column Info */
	private String turnPortIndCd = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String xcldDepDlayHrs = null;
	/* Column Info */
	private String pfEtdDt = null;
	
	/* Column Info */
	private String bfrPfEtdDt = null;
	
	/* Column Info */
	private String actInpYrmon = null;
	/* Column Info */
	private String rstInpYrmon = null;
		/* Column Info */
	private String rstFlg = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String pfEtbDt = null;
	/* Column Info */
	private String depRmk1 = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String inclDepDlayHrs = null;
	/* Column Info */
	private String depRmk2 = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String actCrrCd = null;
	/* Column Info */
	private String actDepDt = null;
	/* Column Info */
	private String bfrActDepDt = null;
	/* Column Info */
	private String skdCngStsCd = null;
	/* Column Info */
	private String inclBrthDlayHrs = null;
	/* Column Info */
	private String depDlayHrs1 = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String arrDlayHrs2 = null;
	/* Column Info */
	private String arrDlayHrs1 = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String depDlayHrs2 = null;
	/* Column Info */
	private String arrDlayRsnCd1 = null;
	/* Column Info */
	private String arrDlayRsnCd2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SkdResultVO() {}

	public SkdResultVO(String ibflag, String pagerows, String rstFlg, String vslSlanCd, String vvd, String vslCd, String skdVoyNo, String subTrdDirCd, String vpsPortCd, String clptIndSeq, String clptSeq, String skdDirCd, String actInpYrmon, String rstInpYrmon, String skdCngStsCd, String pfEtbDt, String bfrPfEtdDt, String pfEtdDt, String actBrthDt, String bfrActDepDt, String actDepDt, String arrDlayHrs1, String arrDlayHrs2, String arrDlayRsnCd1, String arrDlayRsnCd2, String depDlayHrs1, String depDlayHrs2, String depDlayRsnCd1, String depDlayRsnCd2, String arrRmk1, String arrRmk2, String depRmk1, String depRmk2, String inclBrthDlayHrs, String inclDepDlayHrs, String xcldBrthDlayHrs, String xcldDepDlayHrs, String vskdRsltXcldCd, String ydCd, String contiCd, String turnPortIndCd, String actCrrCd) {
		this.contiCd = contiCd;
		this.vslCd = vslCd;
		this.subTrdDirCd = subTrdDirCd;
		this.actBrthDt = actBrthDt;
		this.arrRmk1 = arrRmk1;
		this.arrRmk2 = arrRmk2;
		this.vskdRsltXcldCd = vskdRsltXcldCd;
		this.vslSlanCd = vslSlanCd;
		this.xcldBrthDlayHrs = xcldBrthDlayHrs;
		this.depDlayRsnCd2 = depDlayRsnCd2;
		this.pagerows = pagerows;
		this.depDlayRsnCd1 = depDlayRsnCd1;
		this.turnPortIndCd = turnPortIndCd;
		this.clptSeq = clptSeq;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.xcldDepDlayHrs = xcldDepDlayHrs;
		this.pfEtdDt = pfEtdDt;
		
		this.actInpYrmon = actInpYrmon;
		this.rstInpYrmon = rstInpYrmon;
		this.rstFlg = rstFlg;
		this.skdVoyNo = skdVoyNo;
		this.pfEtbDt = pfEtbDt;
		this.bfrPfEtdDt = bfrPfEtdDt;
		
		this.depRmk1 = depRmk1;
		this.skdDirCd = skdDirCd;
		this.inclDepDlayHrs = inclDepDlayHrs;
		this.depRmk2 = depRmk2;
		this.vvd = vvd;
		this.actCrrCd = actCrrCd;
		this.actDepDt = actDepDt;
		this.bfrActDepDt = bfrActDepDt;
		
		this.skdCngStsCd = skdCngStsCd;
		this.inclBrthDlayHrs = inclBrthDlayHrs;
		this.depDlayHrs1 = depDlayHrs1;
		this.ydCd = ydCd;
		this.arrDlayHrs2 = arrDlayHrs2;
		this.arrDlayHrs1 = arrDlayHrs1;
		this.clptIndSeq = clptIndSeq;
		this.depDlayHrs2 = depDlayHrs2;
		this.arrDlayRsnCd1 = arrDlayRsnCd1;
		this.arrDlayRsnCd2 = arrDlayRsnCd2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("sub_trd_dir_cd", getSubTrdDirCd());
		this.hashColumns.put("act_brth_dt", getActBrthDt());
		this.hashColumns.put("arr_rmk1", getArrRmk1());
		this.hashColumns.put("arr_rmk2", getArrRmk2());
		this.hashColumns.put("vskd_rslt_xcld_cd", getVskdRsltXcldCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("xcld_brth_dlay_hrs", getXcldBrthDlayHrs());
		this.hashColumns.put("dep_dlay_rsn_cd2", getDepDlayRsnCd2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dep_dlay_rsn_cd1", getDepDlayRsnCd1());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("xcld_dep_dlay_hrs", getXcldDepDlayHrs());
		this.hashColumns.put("pf_etd_dt", getPfEtdDt());
		this.hashColumns.put("act_inp_yrmon", getActInpYrmon());
		this.hashColumns.put("rst_inp_yrmon", getRstInpYrmon());
		this.hashColumns.put("rst_flg", getRstFlg());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pf_etb_dt", getPfEtbDt());
		this.hashColumns.put("bfr_pf_etd_dt", getBfrPfEtdDt());
		
		this.hashColumns.put("dep_rmk1", getDepRmk1());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("incl_dep_dlay_hrs", getInclDepDlayHrs());
		this.hashColumns.put("dep_rmk2", getDepRmk2());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("act_crr_cd", getActCrrCd());
		this.hashColumns.put("act_dep_dt", getActDepDt());
		this.hashColumns.put("bfr_act_dep_dt", getBfrActDepDt());
		
		this.hashColumns.put("skd_cng_sts_cd", getSkdCngStsCd());
		this.hashColumns.put("incl_brth_dlay_hrs", getInclBrthDlayHrs());
		this.hashColumns.put("dep_dlay_hrs1", getDepDlayHrs1());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("arr_dlay_hrs2", getArrDlayHrs2());
		this.hashColumns.put("arr_dlay_hrs1", getArrDlayHrs1());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("dep_dlay_hrs2", getDepDlayHrs2());
		this.hashColumns.put("arr_dlay_rsn_cd1", getArrDlayRsnCd1());
		this.hashColumns.put("arr_dlay_rsn_cd2", getArrDlayRsnCd2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("sub_trd_dir_cd", "subTrdDirCd");
		this.hashFields.put("act_brth_dt", "actBrthDt");
		this.hashFields.put("arr_rmk1", "arrRmk1");
		this.hashFields.put("arr_rmk2", "arrRmk2");
		this.hashFields.put("vskd_rslt_xcld_cd", "vskdRsltXcldCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("xcld_brth_dlay_hrs", "xcldBrthDlayHrs");
		this.hashFields.put("dep_dlay_rsn_cd2", "depDlayRsnCd2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dep_dlay_rsn_cd1", "depDlayRsnCd1");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("xcld_dep_dlay_hrs", "xcldDepDlayHrs");
		this.hashFields.put("pf_etd_dt", "pfEtdDt");
		this.hashFields.put("bfr_pf_etd_dt", "bfrPfEtdDt");
		
		this.hashFields.put("act_inp_yrmon", "actInpYrmon");
		this.hashFields.put("rst_inp_yrmon", "rstInpYrmon");
		this.hashFields.put("rst_flg", "rstFlg");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pf_etb_dt", "pfEtbDt");
		this.hashFields.put("dep_rmk1", "depRmk1");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("incl_dep_dlay_hrs", "inclDepDlayHrs");
		this.hashFields.put("dep_rmk2", "depRmk2");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("act_crr_cd", "actCrrCd");
		this.hashFields.put("act_dep_dt", "actDepDt");
		this.hashFields.put("bfr_act_dep_dt", "bfrActDepDt");
		
		this.hashFields.put("skd_cng_sts_cd", "skdCngStsCd");
		this.hashFields.put("incl_brth_dlay_hrs", "inclBrthDlayHrs");
		this.hashFields.put("dep_dlay_hrs1", "depDlayHrs1");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("arr_dlay_hrs2", "arrDlayHrs2");
		this.hashFields.put("arr_dlay_hrs1", "arrDlayHrs1");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("dep_dlay_hrs2", "depDlayHrs2");
		this.hashFields.put("arr_dlay_rsn_cd1", "arrDlayRsnCd1");
		this.hashFields.put("arr_dlay_rsn_cd2", "arrDlayRsnCd2");
		
		this.hashFields.put("ord", "ord");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdDirCd
	 */
	public String getSubTrdDirCd() {
		return this.subTrdDirCd;
	}
	
	/**
	 * Column Info
	 * @return actBrthDt
	 */
	public String getActBrthDt() {
		return this.actBrthDt;
	}
	
	/**
	 * Column Info
	 * @return arrRmk1
	 */
	public String getArrRmk1() {
		return this.arrRmk1;
	}
	
	/**
	 * Column Info
	 * @return arrRmk2
	 */
	public String getArrRmk2() {
		return this.arrRmk2;
	}
	
	/**
	 * Column Info
	 * @return vskdRsltXcldCd
	 */
	public String getVskdRsltXcldCd() {
		return this.vskdRsltXcldCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return xcldBrthDlayHrs
	 */
	public String getXcldBrthDlayHrs() {
		return this.xcldBrthDlayHrs;
	}
	
	/**
	 * Column Info
	 * @return depDlayRsnCd2
	 */
	public String getDepDlayRsnCd2() {
		return this.depDlayRsnCd2;
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
	 * @return depDlayRsnCd1
	 */
	public String getDepDlayRsnCd1() {
		return this.depDlayRsnCd1;
	}
	
	/**
	 * Column Info
	 * @return turnPortIndCd
	 */
	public String getTurnPortIndCd() {
		return this.turnPortIndCd;
	}
	
	/**
	 * Column Info
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return xcldDepDlayHrs
	 */
	public String getXcldDepDlayHrs() {
		return this.xcldDepDlayHrs;
	}
	
	/**
	 * Column Info
	 * @return pfEtdDt
	 */
	public String getPfEtdDt() {
		return this.pfEtdDt;
	}
	
	/**
	 * Column Info
	 * @return actInpYrmon
	 */
	public String getActInpYrmon() {
		return this.actInpYrmon;
	}
	
	/**
	 * Column Info
	 * @return rstInpYrmon
	 */
	public String getRstInpYrmon() {
		return this.rstInpYrmon;
	}
	
	/**
	 * Column Info
	 * @return rstFlg
	 */
	public String getRstFlg() {
		return this.rstFlg;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return pfEtbDt
	 */
	public String getPfEtbDt() {
		return this.pfEtbDt;
	}
	
	/**
	 * Column Info
	 * @return bfrPfEtdDt
	 */
	public String getBfrPfEtdDt() {
		return this.bfrPfEtdDt;
	}
	
	/**
	 * Column Info
	 * @return depRmk1
	 */
	public String getDepRmk1() {
		return this.depRmk1;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return inclDepDlayHrs
	 */
	public String getInclDepDlayHrs() {
		return this.inclDepDlayHrs;
	}
	
	/**
	 * Column Info
	 * @return depRmk2
	 */
	public String getDepRmk2() {
		return this.depRmk2;
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
	 * @return actCrrCd
	 */
	public String getActCrrCd() {
		return this.actCrrCd;
	}
	
	/**
	 * Column Info
	 * @return actDepDt
	 */
	public String getActDepDt() {
		return this.actDepDt;
	}
	/**
	 * Column Info
	 * @return bfrActDepDt
	 */
	public String getBfrActDepDt() {
		return this.bfrActDepDt;
	}
	
	/**
	 * Column Info
	 * @return skdCngStsCd
	 */
	public String getSkdCngStsCd() {
		return this.skdCngStsCd;
	}
	
	/**
	 * Column Info
	 * @return inclBrthDlayHrs
	 */
	public String getInclBrthDlayHrs() {
		return this.inclBrthDlayHrs;
	}
	
	/**
	 * Column Info
	 * @return depDlayHrs1
	 */
	public String getDepDlayHrs1() {
		return this.depDlayHrs1;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return arrDlayHrs2
	 */
	public String getArrDlayHrs2() {
		return this.arrDlayHrs2;
	}
	
	/**
	 * Column Info
	 * @return arrDlayHrs1
	 */
	public String getArrDlayHrs1() {
		return this.arrDlayHrs1;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return depDlayHrs2
	 */
	public String getDepDlayHrs2() {
		return this.depDlayHrs2;
	}
	
	/**
	 * Column Info
	 * @return arrDlayRsnCd1
	 */
	public String getArrDlayRsnCd1() {
		return this.arrDlayRsnCd1;
	}
	
	/**
	 * Column Info
	 * @return arrDlayRsnCd2
	 */
	public String getArrDlayRsnCd2() {
		return this.arrDlayRsnCd2;
	}
	

	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdDirCd
	 */
	public void setSubTrdDirCd(String subTrdDirCd) {
		this.subTrdDirCd = subTrdDirCd;
	}
	
	/**
	 * Column Info
	 * @param actBrthDt
	 */
	public void setActBrthDt(String actBrthDt) {
		this.actBrthDt = actBrthDt;
	}
	
	/**
	 * Column Info
	 * @param arrRmk1
	 */
	public void setArrRmk1(String arrRmk1) {
		this.arrRmk1 = arrRmk1;
	}
	
	/**
	 * Column Info
	 * @param arrRmk2
	 */
	public void setArrRmk2(String arrRmk2) {
		this.arrRmk2 = arrRmk2;
	}
	
	/**
	 * Column Info
	 * @param vskdRsltXcldCd
	 */
	public void setVskdRsltXcldCd(String vskdRsltXcldCd) {
		this.vskdRsltXcldCd = vskdRsltXcldCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param xcldBrthDlayHrs
	 */
	public void setXcldBrthDlayHrs(String xcldBrthDlayHrs) {
		this.xcldBrthDlayHrs = xcldBrthDlayHrs;
	}
	
	/**
	 * Column Info
	 * @param depDlayRsnCd2
	 */
	public void setDepDlayRsnCd2(String depDlayRsnCd2) {
		this.depDlayRsnCd2 = depDlayRsnCd2;
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
	 * @param depDlayRsnCd1
	 */
	public void setDepDlayRsnCd1(String depDlayRsnCd1) {
		this.depDlayRsnCd1 = depDlayRsnCd1;
	}
	
	/**
	 * Column Info
	 * @param turnPortIndCd
	 */
	public void setTurnPortIndCd(String turnPortIndCd) {
		this.turnPortIndCd = turnPortIndCd;
	}
	
	/**
	 * Column Info
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param xcldDepDlayHrs
	 */
	public void setXcldDepDlayHrs(String xcldDepDlayHrs) {
		this.xcldDepDlayHrs = xcldDepDlayHrs;
	}
	
	/**
	 * Column Info
	 * @param pfEtdDt
	 */
	public void setPfEtdDt(String pfEtdDt) {
		this.pfEtdDt = pfEtdDt;
	}
	
	/**
	 * Column Info
	 * @param bfrPfEtdDt
	 */
	public void setBfrPfEtdDt(String bfrPfEtdDt) {
		this.bfrPfEtdDt = bfrPfEtdDt;
	}
	
	/**
	 * Column Info
	 * @param actInpYrmon
	 */
	public void setActInpYrmon(String actInpYrmon) {
		this.actInpYrmon = actInpYrmon;
	}
	
	/**
	 * Column Info
	 * @param rstInpYrmon
	 */
	public void setRstInpYrmon(String rstInpYrmon) {
		this.rstInpYrmon = rstInpYrmon;
	}
	
	/**
	 * Column Info
	 * @param rstFlg
	 */
	public void setRstFlg(String rstFlg) {
		this.rstFlg = rstFlg;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param pfEtbDt
	 */
	public void setPfEtbDt(String pfEtbDt) {
		this.pfEtbDt = pfEtbDt;
	}
	
	/**
	 * Column Info
	 * @param depRmk1
	 */
	public void setDepRmk1(String depRmk1) {
		this.depRmk1 = depRmk1;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param inclDepDlayHrs
	 */
	public void setInclDepDlayHrs(String inclDepDlayHrs) {
		this.inclDepDlayHrs = inclDepDlayHrs;
	}
	
	/**
	 * Column Info
	 * @param depRmk2
	 */
	public void setDepRmk2(String depRmk2) {
		this.depRmk2 = depRmk2;
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
	 * @param actCrrCd
	 */
	public void setActCrrCd(String actCrrCd) {
		this.actCrrCd = actCrrCd;
	}
	
	/**
	 * Column Info
	 * @param actDepDt
	 */
	public void setActDepDt(String actDepDt) {
		this.actDepDt = actDepDt;
	}
	
	/** 
	 * Column Info
	 * @param bfrActDepDt
	 */
	public void setBfrActDepDt(String bfrActDepDt) {
		this.bfrActDepDt = bfrActDepDt;
	}
	
	/**
	 * Column Info
	 * @param skdCngStsCd
	 */
	public void setSkdCngStsCd(String skdCngStsCd) {
		this.skdCngStsCd = skdCngStsCd;
	}
	
	/**
	 * Column Info
	 * @param inclBrthDlayHrs
	 */
	public void setInclBrthDlayHrs(String inclBrthDlayHrs) {
		this.inclBrthDlayHrs = inclBrthDlayHrs;
	}
	
	/**
	 * Column Info
	 * @param depDlayHrs1
	 */
	public void setDepDlayHrs1(String depDlayHrs1) {
		this.depDlayHrs1 = depDlayHrs1;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param arrDlayHrs2
	 */
	public void setArrDlayHrs2(String arrDlayHrs2) {
		this.arrDlayHrs2 = arrDlayHrs2;
	}
	
	/**
	 * Column Info
	 * @param arrDlayHrs1
	 */
	public void setArrDlayHrs1(String arrDlayHrs1) {
		this.arrDlayHrs1 = arrDlayHrs1;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param depDlayHrs2
	 */
	public void setDepDlayHrs2(String depDlayHrs2) {
		this.depDlayHrs2 = depDlayHrs2;
	}
	
	/**
	 * Column Info
	 * @param arrDlayRsnCd1
	 */
	public void setArrDlayRsnCd1(String arrDlayRsnCd1) {
		this.arrDlayRsnCd1 = arrDlayRsnCd1;
	}
	
	/**
	 * Column Info
	 * @param arrDlayRsnCd2
	 */
	public void setArrDlayRsnCd2(String arrDlayRsnCd2) {
		this.arrDlayRsnCd2 = arrDlayRsnCd2;
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
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSubTrdDirCd(JSPUtil.getParameter(request, prefix + "sub_trd_dir_cd", ""));
		setActBrthDt(JSPUtil.getParameter(request, prefix + "act_brth_dt", ""));
		setArrRmk1(JSPUtil.getParameter(request, prefix + "arr_rmk1", ""));
		setArrRmk2(JSPUtil.getParameter(request, prefix + "arr_rmk2", ""));
		setVskdRsltXcldCd(JSPUtil.getParameter(request, prefix + "vskd_rslt_xcld_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setXcldBrthDlayHrs(JSPUtil.getParameter(request, prefix + "xcld_brth_dlay_hrs", ""));
		setDepDlayRsnCd2(JSPUtil.getParameter(request, prefix + "dep_dlay_rsn_cd2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDepDlayRsnCd1(JSPUtil.getParameter(request, prefix + "dep_dlay_rsn_cd1", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setXcldDepDlayHrs(JSPUtil.getParameter(request, prefix + "xcld_dep_dlay_hrs", ""));
		setPfEtdDt(JSPUtil.getParameter(request, prefix + "pf_etd_dt", ""));
		setBfrPfEtdDt(JSPUtil.getParameter(request, prefix + "bfr_pf_etd_dt", ""));
		
		setActInpYrmon(JSPUtil.getParameter(request, prefix + "act_inp_yrmon", ""));
		setRstInpYrmon(JSPUtil.getParameter(request, prefix + "rst_inp_yrmon", ""));
		setRstFlg(JSPUtil.getParameter(request, prefix + "rst_flg", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setPfEtbDt(JSPUtil.getParameter(request, prefix + "pf_etb_dt", ""));
		setDepRmk1(JSPUtil.getParameter(request, prefix + "dep_rmk1", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setInclDepDlayHrs(JSPUtil.getParameter(request, prefix + "incl_dep_dlay_hrs", ""));
		setDepRmk2(JSPUtil.getParameter(request, prefix + "dep_rmk2", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setActCrrCd(JSPUtil.getParameter(request, prefix + "act_crr_cd", ""));
		setActDepDt(JSPUtil.getParameter(request, prefix + "act_dep_dt", ""));
		setBfrActDepDt(JSPUtil.getParameter(request, prefix + "bfr_act_dep_dt", ""));
		
		setSkdCngStsCd(JSPUtil.getParameter(request, prefix + "skd_cng_sts_cd", ""));
		setInclBrthDlayHrs(JSPUtil.getParameter(request, prefix + "incl_brth_dlay_hrs", ""));
		setDepDlayHrs1(JSPUtil.getParameter(request, prefix + "dep_dlay_hrs1", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setArrDlayHrs2(JSPUtil.getParameter(request, prefix + "arr_dlay_hrs2", ""));
		setArrDlayHrs1(JSPUtil.getParameter(request, prefix + "arr_dlay_hrs1", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setDepDlayHrs2(JSPUtil.getParameter(request, prefix + "dep_dlay_hrs2", ""));
		setArrDlayRsnCd1(JSPUtil.getParameter(request, prefix + "arr_dlay_rsn_cd1", ""));
		setArrDlayRsnCd2(JSPUtil.getParameter(request, prefix + "arr_dlay_rsn_cd2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SkdResultVO[]
	 */
	public SkdResultVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SkdResultVO[]
	 */
	public SkdResultVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SkdResultVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] subTrdDirCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_dir_cd", length));
			String[] actBrthDt = (JSPUtil.getParameter(request, prefix	+ "act_brth_dt", length));
			String[] arrRmk1 = (JSPUtil.getParameter(request, prefix	+ "arr_rmk1", length));
			String[] arrRmk2 = (JSPUtil.getParameter(request, prefix	+ "arr_rmk2", length));
			String[] vskdRsltXcldCd = (JSPUtil.getParameter(request, prefix	+ "vskd_rslt_xcld_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] xcldBrthDlayHrs = (JSPUtil.getParameter(request, prefix	+ "xcld_brth_dlay_hrs", length));
			String[] depDlayRsnCd2 = (JSPUtil.getParameter(request, prefix	+ "dep_dlay_rsn_cd2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] depDlayRsnCd1 = (JSPUtil.getParameter(request, prefix	+ "dep_dlay_rsn_cd1", length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] xcldDepDlayHrs = (JSPUtil.getParameter(request, prefix	+ "xcld_dep_dlay_hrs", length));
			String[] pfEtdDt = (JSPUtil.getParameter(request, prefix	+ "pf_etd_dt", length));
			String[] bfrPfEtdDt = (JSPUtil.getParameter(request, prefix	+ "pf_bfr_etd_dt", length));
			
			String[] actInpYrmon = (JSPUtil.getParameter(request, prefix	+ "act_inp_yrmon", length));
			String[] rstInpYrmon = (JSPUtil.getParameter(request, prefix	+ "rst_inp_yrmon", length));
			String[] rstFlg = (JSPUtil.getParameter(request, prefix	+ "rst_flg", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] pfEtbDt = (JSPUtil.getParameter(request, prefix	+ "pf_etb_dt", length));
			String[] depRmk1 = (JSPUtil.getParameter(request, prefix	+ "dep_rmk1", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] inclDepDlayHrs = (JSPUtil.getParameter(request, prefix	+ "incl_dep_dlay_hrs", length));
			String[] depRmk2 = (JSPUtil.getParameter(request, prefix	+ "dep_rmk2", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] actCrrCd = (JSPUtil.getParameter(request, prefix	+ "act_crr_cd", length));
			String[] actDepDt = (JSPUtil.getParameter(request, prefix	+ "act_dep_dt", length));
			String[] bfrActDepDt = (JSPUtil.getParameter(request, prefix	+ "bfr_act_dep_dt", length));
			String[] skdCngStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_cng_sts_cd", length));
			String[] inclBrthDlayHrs = (JSPUtil.getParameter(request, prefix	+ "incl_brth_dlay_hrs", length));
			String[] depDlayHrs1 = (JSPUtil.getParameter(request, prefix	+ "dep_dlay_hrs1", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] arrDlayHrs2 = (JSPUtil.getParameter(request, prefix	+ "arr_dlay_hrs2", length));
			String[] arrDlayHrs1 = (JSPUtil.getParameter(request, prefix	+ "arr_dlay_hrs1", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] depDlayHrs2 = (JSPUtil.getParameter(request, prefix	+ "dep_dlay_hrs2", length));
			String[] arrDlayRsnCd1 = (JSPUtil.getParameter(request, prefix	+ "arr_dlay_rsn_cd1", length));
			String[] arrDlayRsnCd2 = (JSPUtil.getParameter(request, prefix	+ "arr_dlay_rsn_cd2", length));
			
			for (int i = 0; i < length; i++) {
				model = new SkdResultVO();
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (subTrdDirCd[i] != null)
					model.setSubTrdDirCd(subTrdDirCd[i]);
				if (actBrthDt[i] != null)
					model.setActBrthDt(actBrthDt[i]);
				if (arrRmk1[i] != null)
					model.setArrRmk1(arrRmk1[i]);
				if (arrRmk2[i] != null)
					model.setArrRmk2(arrRmk2[i]);
				if (vskdRsltXcldCd[i] != null)
					model.setVskdRsltXcldCd(vskdRsltXcldCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (xcldBrthDlayHrs[i] != null)
					model.setXcldBrthDlayHrs(xcldBrthDlayHrs[i]);
				if (depDlayRsnCd2[i] != null)
					model.setDepDlayRsnCd2(depDlayRsnCd2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (depDlayRsnCd1[i] != null)
					model.setDepDlayRsnCd1(depDlayRsnCd1[i]);
				if (turnPortIndCd[i] != null)
					model.setTurnPortIndCd(turnPortIndCd[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (xcldDepDlayHrs[i] != null)
					model.setXcldDepDlayHrs(xcldDepDlayHrs[i]);
				if (pfEtdDt[i] != null)
					model.setPfEtdDt(pfEtdDt[i]);
				if (bfrPfEtdDt[i] != null)
					model.setBfrPfEtdDt(bfrPfEtdDt[i]);
				if (actInpYrmon[i] != null)
					model.setActInpYrmon(actInpYrmon[i]);
				if (rstInpYrmon[i] != null)
					model.setRstInpYrmon(rstInpYrmon[i]);
				if (rstFlg[i] != null)
					model.setRstFlg(rstFlg[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (pfEtbDt[i] != null)
					model.setPfEtbDt(pfEtbDt[i]);
				if (depRmk1[i] != null)
					model.setDepRmk1(depRmk1[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (inclDepDlayHrs[i] != null)
					model.setInclDepDlayHrs(inclDepDlayHrs[i]);
				if (depRmk2[i] != null)
					model.setDepRmk2(depRmk2[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (actCrrCd[i] != null)
					model.setActCrrCd(actCrrCd[i]);
				if (actDepDt[i] != null)
					model.setActDepDt(actDepDt[i]);
				if (bfrActDepDt[i] != null)
					model.setBfrActDepDt(bfrActDepDt[i]);
				
				if (skdCngStsCd[i] != null)
					model.setSkdCngStsCd(skdCngStsCd[i]);
				if (inclBrthDlayHrs[i] != null)
					model.setInclBrthDlayHrs(inclBrthDlayHrs[i]);
				if (depDlayHrs1[i] != null)
					model.setDepDlayHrs1(depDlayHrs1[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (arrDlayHrs2[i] != null)
					model.setArrDlayHrs2(arrDlayHrs2[i]);
				if (arrDlayHrs1[i] != null)
					model.setArrDlayHrs1(arrDlayHrs1[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (depDlayHrs2[i] != null)
					model.setDepDlayHrs2(depDlayHrs2[i]);
				if (arrDlayRsnCd1[i] != null)
					model.setArrDlayRsnCd1(arrDlayRsnCd1[i]);
				if (arrDlayRsnCd2[i] != null)
					model.setArrDlayRsnCd2(arrDlayRsnCd2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSkdResultVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SkdResultVO[]
	 */
	public SkdResultVO[] getSkdResultVOs(){
		SkdResultVO[] vos = (SkdResultVO[])models.toArray(new SkdResultVO[models.size()]);
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
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdDirCd = this.subTrdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBrthDt = this.actBrthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrRmk1 = this.arrRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrRmk2 = this.arrRmk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskdRsltXcldCd = this.vskdRsltXcldCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldBrthDlayHrs = this.xcldBrthDlayHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDlayRsnCd2 = this.depDlayRsnCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDlayRsnCd1 = this.depDlayRsnCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldDepDlayHrs = this.xcldDepDlayHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtdDt = this.pfEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrPfEtdDt = this.bfrPfEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInpYrmon = this.actInpYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstInpYrmon = this.rstInpYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstFlg = this.rstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtbDt = this.pfEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRmk1 = this.depRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclDepDlayHrs = this.inclDepDlayHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRmk2 = this.depRmk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCrrCd = this.actCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDepDt = this.actDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrActDepDt = this.bfrActDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngStsCd = this.skdCngStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclBrthDlayHrs = this.inclBrthDlayHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDlayHrs1 = this.depDlayHrs1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDlayHrs2 = this.arrDlayHrs2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDlayHrs1 = this.arrDlayHrs1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDlayHrs2 = this.depDlayHrs2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDlayRsnCd1 = this.arrDlayRsnCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDlayRsnCd2 = this.arrDlayRsnCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
