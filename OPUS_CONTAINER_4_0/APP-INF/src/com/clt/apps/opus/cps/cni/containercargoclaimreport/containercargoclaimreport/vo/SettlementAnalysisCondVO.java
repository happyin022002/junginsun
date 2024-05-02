/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SettlementAnalysisCondVO.java
*@FileTitle : SettlementAnalysisCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.01.12 양정란 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 양정란
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SettlementAnalysisCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SettlementAnalysisCondVO> models = new ArrayList<SettlementAnalysisCondVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String fromPeriod = null;
	/* Column Info */
	private String fromCgoClmStlUsdAmt = null;
	/* Column Info */
	private String fromClmtUsdAmt = null;
	/* Column Info */
	private String trnkRefVvdNo = null;
	/* Column Info */
	private String vt = null;
	/* Column Info */
	private String clmtClmPtyNo = null;
	/* Column Info */
	private String clmCgoTpCd = null;
	/* Column Info */
	private String clmtClmAgnPtyNo = null;
	/* Column Info */
	private String n1stPreTsLocCd = null;
	/* Column Info */
	private String hndlOfcCd = null;
	/* Column Info */
	private String slvClmPtyNo = null;
	/* Column Info */
	private String fvd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sveyClmPtyNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crrTermCd = null;
	/* Column Info */
	private String area = null;
	/* Column Info */
	private String classCd = null;
	/* Column Info */
	private String reportBy = null;
	/* Column Info */
	private String lablClmPtyNo = null;
	/* Column Info */
	private String lit = null;
	/* Column Info */
	private String mjrClmDmgLssCd = null;
	/* Column Info */
	private String n1stPstTsLocCd = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String toCgoClmStlUsdAmt = null;
	/* Column Info */
	private String mgrUsrId = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String toPeriod = null;
	/* Column Info */
	private String toClmtUsdAmt = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String clmStlAuthUsrId = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cgoClmStlTpCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String fmalClmRcvOfcCd = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String cgoClmInciNo = null;
	/* Column Info */
	private String minrClmDmgLssCd = null;
	/* Column Info */
	private String inciPlcTpCd = null;
	/* Column Info */
	private String insurClmPtyNo = null;
	/* Column Info */
	private String cgoClmTpCd = null;
	/* Column Info */
	private String hdlrOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SettlementAnalysisCondVO() {}

	public SettlementAnalysisCondVO(String ibflag, String pagerows, String reportBy, String classCd, String period, String fromPeriod, String toPeriod, String area, String status, String vt, String pageNo, String hdlrOfcCd, String hdlrUsrId, String mgrUsrId, String hndlOfcCd, String lablClmPtyNo, String sveyClmPtyNo, String fmalClmRcvOfcCd, String clmtClmPtyNo, String clmtClmAgnPtyNo, String slvClmPtyNo, String insurClmPtyNo, String clmStlAuthUsrId, String trnkRefVvdNo, String porCd, String polCd, String podCd, String delCd, String fvd, String n1stPreTsLocCd, String n1stPstTsLocCd, String crrTermCd, String inciPlcTpCd, String slanCd, String clmCgoTpCd, String cgoClmTpCd, String mjrClmDmgLssCd, String minrClmDmgLssCd, String lit, String cgoClmStlTpCd, String fromClmtUsdAmt, String toClmtUsdAmt, String fromCgoClmStlUsdAmt, String toCgoClmStlUsdAmt, String cgoClmInciNo) {
		this.porCd = porCd;
		this.fromPeriod = fromPeriod;
		this.fromCgoClmStlUsdAmt = fromCgoClmStlUsdAmt;
		this.fromClmtUsdAmt = fromClmtUsdAmt;
		this.trnkRefVvdNo = trnkRefVvdNo;
		this.vt = vt;
		this.clmtClmPtyNo = clmtClmPtyNo;
		this.clmCgoTpCd = clmCgoTpCd;
		this.clmtClmAgnPtyNo = clmtClmAgnPtyNo;
		this.n1stPreTsLocCd = n1stPreTsLocCd;
		this.hndlOfcCd = hndlOfcCd;
		this.slvClmPtyNo = slvClmPtyNo;
		this.fvd = fvd;
		this.pagerows = pagerows;
		this.sveyClmPtyNo = sveyClmPtyNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.crrTermCd = crrTermCd;
		this.area = area;
		this.classCd = classCd;
		this.reportBy = reportBy;
		this.lablClmPtyNo = lablClmPtyNo;
		this.lit = lit;
		this.mjrClmDmgLssCd = mjrClmDmgLssCd;
		this.n1stPstTsLocCd = n1stPstTsLocCd;
		this.status = status;
		this.toCgoClmStlUsdAmt = toCgoClmStlUsdAmt;
		this.mgrUsrId = mgrUsrId;
		this.delCd = delCd;
		this.toPeriod = toPeriod;
		this.toClmtUsdAmt = toClmtUsdAmt;
		this.period = period;
		this.clmStlAuthUsrId = clmStlAuthUsrId;
		this.hdlrUsrId = hdlrUsrId;
		this.podCd = podCd;
		this.cgoClmStlTpCd = cgoClmStlTpCd;
		this.slanCd = slanCd;
		this.fmalClmRcvOfcCd = fmalClmRcvOfcCd;
		this.pageNo = pageNo;
		this.cgoClmInciNo = cgoClmInciNo;
		this.minrClmDmgLssCd = minrClmDmgLssCd;
		this.inciPlcTpCd = inciPlcTpCd;
		this.insurClmPtyNo = insurClmPtyNo;
		this.cgoClmTpCd = cgoClmTpCd;
		this.hdlrOfcCd = hdlrOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("from_period", getFromPeriod());
		this.hashColumns.put("from_cgo_clm_stl_usd_amt", getFromCgoClmStlUsdAmt());
		this.hashColumns.put("from_clmt_usd_amt", getFromClmtUsdAmt());
		this.hashColumns.put("trnk_ref_vvd_no", getTrnkRefVvdNo());
		this.hashColumns.put("vt", getVt());
		this.hashColumns.put("clmt_clm_pty_no", getClmtClmPtyNo());
		this.hashColumns.put("clm_cgo_tp_cd", getClmCgoTpCd());
		this.hashColumns.put("clmt_clm_agn_pty_no", getClmtClmAgnPtyNo());
		this.hashColumns.put("n1st_pre_ts_loc_cd", getN1stPreTsLocCd());
		this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
		this.hashColumns.put("slv_clm_pty_no", getSlvClmPtyNo());
		this.hashColumns.put("fvd", getFvd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svey_clm_pty_no", getSveyClmPtyNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("crr_term_cd", getCrrTermCd());
		this.hashColumns.put("area", getArea());
		this.hashColumns.put("class_cd", getClassCd());
		this.hashColumns.put("report_by", getReportBy());
		this.hashColumns.put("labl_clm_pty_no", getLablClmPtyNo());
		this.hashColumns.put("lit", getLit());
		this.hashColumns.put("mjr_clm_dmg_lss_cd", getMjrClmDmgLssCd());
		this.hashColumns.put("n1st_pst_ts_loc_cd", getN1stPstTsLocCd());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("to_cgo_clm_stl_usd_amt", getToCgoClmStlUsdAmt());
		this.hashColumns.put("mgr_usr_id", getMgrUsrId());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("to_period", getToPeriod());
		this.hashColumns.put("to_clmt_usd_amt", getToClmtUsdAmt());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("clm_stl_auth_usr_id", getClmStlAuthUsrId());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cgo_clm_stl_tp_cd", getCgoClmStlTpCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("fmal_clm_rcv_ofc_cd", getFmalClmRcvOfcCd());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("cgo_clm_inci_no", getCgoClmInciNo());
		this.hashColumns.put("minr_clm_dmg_lss_cd", getMinrClmDmgLssCd());
		this.hashColumns.put("inci_plc_tp_cd", getInciPlcTpCd());
		this.hashColumns.put("insur_clm_pty_no", getInsurClmPtyNo());
		this.hashColumns.put("cgo_clm_tp_cd", getCgoClmTpCd());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("from_period", "fromPeriod");
		this.hashFields.put("from_cgo_clm_stl_usd_amt", "fromCgoClmStlUsdAmt");
		this.hashFields.put("from_clmt_usd_amt", "fromClmtUsdAmt");
		this.hashFields.put("trnk_ref_vvd_no", "trnkRefVvdNo");
		this.hashFields.put("vt", "vt");
		this.hashFields.put("clmt_clm_pty_no", "clmtClmPtyNo");
		this.hashFields.put("clm_cgo_tp_cd", "clmCgoTpCd");
		this.hashFields.put("clmt_clm_agn_pty_no", "clmtClmAgnPtyNo");
		this.hashFields.put("n1st_pre_ts_loc_cd", "n1stPreTsLocCd");
		this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
		this.hashFields.put("slv_clm_pty_no", "slvClmPtyNo");
		this.hashFields.put("fvd", "fvd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svey_clm_pty_no", "sveyClmPtyNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("crr_term_cd", "crrTermCd");
		this.hashFields.put("area", "area");
		this.hashFields.put("class_cd", "classCd");
		this.hashFields.put("report_by", "reportBy");
		this.hashFields.put("labl_clm_pty_no", "lablClmPtyNo");
		this.hashFields.put("lit", "lit");
		this.hashFields.put("mjr_clm_dmg_lss_cd", "mjrClmDmgLssCd");
		this.hashFields.put("n1st_pst_ts_loc_cd", "n1stPstTsLocCd");
		this.hashFields.put("status", "status");
		this.hashFields.put("to_cgo_clm_stl_usd_amt", "toCgoClmStlUsdAmt");
		this.hashFields.put("mgr_usr_id", "mgrUsrId");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("to_period", "toPeriod");
		this.hashFields.put("to_clmt_usd_amt", "toClmtUsdAmt");
		this.hashFields.put("period", "period");
		this.hashFields.put("clm_stl_auth_usr_id", "clmStlAuthUsrId");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cgo_clm_stl_tp_cd", "cgoClmStlTpCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("fmal_clm_rcv_ofc_cd", "fmalClmRcvOfcCd");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("cgo_clm_inci_no", "cgoClmInciNo");
		this.hashFields.put("minr_clm_dmg_lss_cd", "minrClmDmgLssCd");
		this.hashFields.put("inci_plc_tp_cd", "inciPlcTpCd");
		this.hashFields.put("insur_clm_pty_no", "insurClmPtyNo");
		this.hashFields.put("cgo_clm_tp_cd", "cgoClmTpCd");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return fromPeriod
	 */
	public String getFromPeriod() {
		return this.fromPeriod;
	}
	
	/**
	 * Column Info
	 * @return fromCgoClmStlUsdAmt
	 */
	public String getFromCgoClmStlUsdAmt() {
		return this.fromCgoClmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return fromClmtUsdAmt
	 */
	public String getFromClmtUsdAmt() {
		return this.fromClmtUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return trnkRefVvdNo
	 */
	public String getTrnkRefVvdNo() {
		return this.trnkRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return vt
	 */
	public String getVt() {
		return this.vt;
	}
	
	/**
	 * Column Info
	 * @return clmtClmPtyNo
	 */
	public String getClmtClmPtyNo() {
		return this.clmtClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return clmCgoTpCd
	 */
	public String getClmCgoTpCd() {
		return this.clmCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return clmtClmAgnPtyNo
	 */
	public String getClmtClmAgnPtyNo() {
		return this.clmtClmAgnPtyNo;
	}
	
	/**
	 * Column Info
	 * @return n1stPreTsLocCd
	 */
	public String getN1stPreTsLocCd() {
		return this.n1stPreTsLocCd;
	}
	
	/**
	 * Column Info
	 * @return hndlOfcCd
	 */
	public String getHndlOfcCd() {
		return this.hndlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return slvClmPtyNo
	 */
	public String getSlvClmPtyNo() {
		return this.slvClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return fvd
	 */
	public String getFvd() {
		return this.fvd;
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
	 * @return sveyClmPtyNo
	 */
	public String getSveyClmPtyNo() {
		return this.sveyClmPtyNo;
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
	 * @return crrTermCd
	 */
	public String getCrrTermCd() {
		return this.crrTermCd;
	}
	
	/**
	 * Column Info
	 * @return area
	 */
	public String getArea() {
		return this.area;
	}
	
	/**
	 * Column Info
	 * @return classCd
	 */
	public String getClassCd() {
		return this.classCd;
	}
	
	/**
	 * Column Info
	 * @return reportBy
	 */
	public String getReportBy() {
		return this.reportBy;
	}
	
	/**
	 * Column Info
	 * @return lablClmPtyNo
	 */
	public String getLablClmPtyNo() {
		return this.lablClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return lit
	 */
	public String getLit() {
		return this.lit;
	}
	
	/**
	 * Column Info
	 * @return mjrClmDmgLssCd
	 */
	public String getMjrClmDmgLssCd() {
		return this.mjrClmDmgLssCd;
	}
	
	/**
	 * Column Info
	 * @return n1stPstTsLocCd
	 */
	public String getN1stPstTsLocCd() {
		return this.n1stPstTsLocCd;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return toCgoClmStlUsdAmt
	 */
	public String getToCgoClmStlUsdAmt() {
		return this.toCgoClmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return mgrUsrId
	 */
	public String getMgrUsrId() {
		return this.mgrUsrId;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return toPeriod
	 */
	public String getToPeriod() {
		return this.toPeriod;
	}
	
	/**
	 * Column Info
	 * @return toClmtUsdAmt
	 */
	public String getToClmtUsdAmt() {
		return this.toClmtUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
	}
	
	/**
	 * Column Info
	 * @return clmStlAuthUsrId
	 */
	public String getClmStlAuthUsrId() {
		return this.clmStlAuthUsrId;
	}
	
	/**
	 * Column Info
	 * @return hdlrUsrId
	 */
	public String getHdlrUsrId() {
		return this.hdlrUsrId;
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
	 * @return cgoClmStlTpCd
	 */
	public String getCgoClmStlTpCd() {
		return this.cgoClmStlTpCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return fmalClmRcvOfcCd
	 */
	public String getFmalClmRcvOfcCd() {
		return this.fmalClmRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return cgoClmInciNo
	 */
	public String getCgoClmInciNo() {
		return this.cgoClmInciNo;
	}
	
	/**
	 * Column Info
	 * @return minrClmDmgLssCd
	 */
	public String getMinrClmDmgLssCd() {
		return this.minrClmDmgLssCd;
	}
	
	/**
	 * Column Info
	 * @return inciPlcTpCd
	 */
	public String getInciPlcTpCd() {
		return this.inciPlcTpCd;
	}
	
	/**
	 * Column Info
	 * @return insurClmPtyNo
	 */
	public String getInsurClmPtyNo() {
		return this.insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return cgoClmTpCd
	 */
	public String getCgoClmTpCd() {
		return this.cgoClmTpCd;
	}
	
	/**
	 * Column Info
	 * @return hdlrOfcCd
	 */
	public String getHdlrOfcCd() {
		return this.hdlrOfcCd;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param fromPeriod
	 */
	public void setFromPeriod(String fromPeriod) {
		this.fromPeriod = fromPeriod;
	}
	
	/**
	 * Column Info
	 * @param fromCgoClmStlUsdAmt
	 */
	public void setFromCgoClmStlUsdAmt(String fromCgoClmStlUsdAmt) {
		this.fromCgoClmStlUsdAmt = fromCgoClmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param fromClmtUsdAmt
	 */
	public void setFromClmtUsdAmt(String fromClmtUsdAmt) {
		this.fromClmtUsdAmt = fromClmtUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param trnkRefVvdNo
	 */
	public void setTrnkRefVvdNo(String trnkRefVvdNo) {
		this.trnkRefVvdNo = trnkRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param vt
	 */
	public void setVt(String vt) {
		this.vt = vt;
	}
	
	/**
	 * Column Info
	 * @param clmtClmPtyNo
	 */
	public void setClmtClmPtyNo(String clmtClmPtyNo) {
		this.clmtClmPtyNo = clmtClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param clmCgoTpCd
	 */
	public void setClmCgoTpCd(String clmCgoTpCd) {
		this.clmCgoTpCd = clmCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param clmtClmAgnPtyNo
	 */
	public void setClmtClmAgnPtyNo(String clmtClmAgnPtyNo) {
		this.clmtClmAgnPtyNo = clmtClmAgnPtyNo;
	}
	
	/**
	 * Column Info
	 * @param n1stPreTsLocCd
	 */
	public void setN1stPreTsLocCd(String n1stPreTsLocCd) {
		this.n1stPreTsLocCd = n1stPreTsLocCd;
	}
	
	/**
	 * Column Info
	 * @param hndlOfcCd
	 */
	public void setHndlOfcCd(String hndlOfcCd) {
		this.hndlOfcCd = hndlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param slvClmPtyNo
	 */
	public void setSlvClmPtyNo(String slvClmPtyNo) {
		this.slvClmPtyNo = slvClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param fvd
	 */
	public void setFvd(String fvd) {
		this.fvd = fvd;
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
	 * @param sveyClmPtyNo
	 */
	public void setSveyClmPtyNo(String sveyClmPtyNo) {
		this.sveyClmPtyNo = sveyClmPtyNo;
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
	 * @param crrTermCd
	 */
	public void setCrrTermCd(String crrTermCd) {
		this.crrTermCd = crrTermCd;
	}
	
	/**
	 * Column Info
	 * @param area
	 */
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	 * Column Info
	 * @param classCd
	 */
	public void setClassCd(String classCd) {
		this.classCd = classCd;
	}
	
	/**
	 * Column Info
	 * @param reportBy
	 */
	public void setReportBy(String reportBy) {
		this.reportBy = reportBy;
	}
	
	/**
	 * Column Info
	 * @param lablClmPtyNo
	 */
	public void setLablClmPtyNo(String lablClmPtyNo) {
		this.lablClmPtyNo = lablClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param lit
	 */
	public void setLit(String lit) {
		this.lit = lit;
	}
	
	/**
	 * Column Info
	 * @param mjrClmDmgLssCd
	 */
	public void setMjrClmDmgLssCd(String mjrClmDmgLssCd) {
		this.mjrClmDmgLssCd = mjrClmDmgLssCd;
	}
	
	/**
	 * Column Info
	 * @param n1stPstTsLocCd
	 */
	public void setN1stPstTsLocCd(String n1stPstTsLocCd) {
		this.n1stPstTsLocCd = n1stPstTsLocCd;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param toCgoClmStlUsdAmt
	 */
	public void setToCgoClmStlUsdAmt(String toCgoClmStlUsdAmt) {
		this.toCgoClmStlUsdAmt = toCgoClmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param mgrUsrId
	 */
	public void setMgrUsrId(String mgrUsrId) {
		this.mgrUsrId = mgrUsrId;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param toPeriod
	 */
	public void setToPeriod(String toPeriod) {
		this.toPeriod = toPeriod;
	}
	
	/**
	 * Column Info
	 * @param toClmtUsdAmt
	 */
	public void setToClmtUsdAmt(String toClmtUsdAmt) {
		this.toClmtUsdAmt = toClmtUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * Column Info
	 * @param clmStlAuthUsrId
	 */
	public void setClmStlAuthUsrId(String clmStlAuthUsrId) {
		this.clmStlAuthUsrId = clmStlAuthUsrId;
	}
	
	/**
	 * Column Info
	 * @param hdlrUsrId
	 */
	public void setHdlrUsrId(String hdlrUsrId) {
		this.hdlrUsrId = hdlrUsrId;
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
	 * @param cgoClmStlTpCd
	 */
	public void setCgoClmStlTpCd(String cgoClmStlTpCd) {
		this.cgoClmStlTpCd = cgoClmStlTpCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param fmalClmRcvOfcCd
	 */
	public void setFmalClmRcvOfcCd(String fmalClmRcvOfcCd) {
		this.fmalClmRcvOfcCd = fmalClmRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param cgoClmInciNo
	 */
	public void setCgoClmInciNo(String cgoClmInciNo) {
		this.cgoClmInciNo = cgoClmInciNo;
	}
	
	/**
	 * Column Info
	 * @param minrClmDmgLssCd
	 */
	public void setMinrClmDmgLssCd(String minrClmDmgLssCd) {
		this.minrClmDmgLssCd = minrClmDmgLssCd;
	}
	
	/**
	 * Column Info
	 * @param inciPlcTpCd
	 */
	public void setInciPlcTpCd(String inciPlcTpCd) {
		this.inciPlcTpCd = inciPlcTpCd;
	}
	
	/**
	 * Column Info
	 * @param insurClmPtyNo
	 */
	public void setInsurClmPtyNo(String insurClmPtyNo) {
		this.insurClmPtyNo = insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param cgoClmTpCd
	 */
	public void setCgoClmTpCd(String cgoClmTpCd) {
		this.cgoClmTpCd = cgoClmTpCd;
	}
	
	/**
	 * Column Info
	 * @param hdlrOfcCd
	 */
	public void setHdlrOfcCd(String hdlrOfcCd) {
		this.hdlrOfcCd = hdlrOfcCd;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setFromPeriod(JSPUtil.getParameter(request, prefix + "from_period", ""));
		setFromCgoClmStlUsdAmt(JSPUtil.getParameter(request, prefix + "from_cgo_clm_stl_usd_amt", ""));
		setFromClmtUsdAmt(JSPUtil.getParameter(request, prefix + "from_clmt_usd_amt", ""));
		setTrnkRefVvdNo(JSPUtil.getParameter(request, prefix + "trnk_ref_vvd_no", ""));
		setVt(JSPUtil.getParameter(request, prefix + "vt", ""));
		setClmtClmPtyNo(JSPUtil.getParameter(request, prefix + "clmt_clm_pty_no", ""));
		setClmCgoTpCd(JSPUtil.getParameter(request, prefix + "clm_cgo_tp_cd", ""));
		setClmtClmAgnPtyNo(JSPUtil.getParameter(request, prefix + "clmt_clm_agn_pty_no", ""));
		setN1stPreTsLocCd(JSPUtil.getParameter(request, prefix + "n1st_pre_ts_loc_cd", ""));
		setHndlOfcCd(JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", ""));
		setSlvClmPtyNo(JSPUtil.getParameter(request, prefix + "slv_clm_pty_no", ""));
		setFvd(JSPUtil.getParameter(request, prefix + "fvd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSveyClmPtyNo(JSPUtil.getParameter(request, prefix + "svey_clm_pty_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCrrTermCd(JSPUtil.getParameter(request, prefix + "crr_term_cd", ""));
		setArea(JSPUtil.getParameter(request, prefix + "area", ""));
		setClassCd(JSPUtil.getParameter(request, prefix + "class_cd", ""));
		setReportBy(JSPUtil.getParameter(request, prefix + "report_by", ""));
		setLablClmPtyNo(JSPUtil.getParameter(request, prefix + "labl_clm_pty_no", ""));
		setLit(JSPUtil.getParameter(request, prefix + "lit", ""));
		setMjrClmDmgLssCd(JSPUtil.getParameter(request, prefix + "mjr_clm_dmg_lss_cd", ""));
		setN1stPstTsLocCd(JSPUtil.getParameter(request, prefix + "n1st_pst_ts_loc_cd", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setToCgoClmStlUsdAmt(JSPUtil.getParameter(request, prefix + "to_cgo_clm_stl_usd_amt", ""));
		setMgrUsrId(JSPUtil.getParameter(request, prefix + "mgr_usr_id", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setToPeriod(JSPUtil.getParameter(request, prefix + "to_period", ""));
		setToClmtUsdAmt(JSPUtil.getParameter(request, prefix + "to_clmt_usd_amt", ""));
		setPeriod(JSPUtil.getParameter(request, prefix + "period", ""));
		setClmStlAuthUsrId(JSPUtil.getParameter(request, prefix + "clm_stl_auth_usr_id", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, prefix + "hdlr_usr_id", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCgoClmStlTpCd(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_tp_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setFmalClmRcvOfcCd(JSPUtil.getParameter(request, prefix + "fmal_clm_rcv_ofc_cd", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setCgoClmInciNo(JSPUtil.getParameter(request, prefix + "cgo_clm_inci_no", ""));
		setMinrClmDmgLssCd(JSPUtil.getParameter(request, prefix + "minr_clm_dmg_lss_cd", ""));
		setInciPlcTpCd(JSPUtil.getParameter(request, prefix + "inci_plc_tp_cd", ""));
		setInsurClmPtyNo(JSPUtil.getParameter(request, prefix + "insur_clm_pty_no", ""));
		setCgoClmTpCd(JSPUtil.getParameter(request, prefix + "cgo_clm_tp_cd", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, prefix + "hdlr_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SettlementAnalysisCondVO[]
	 */
	public SettlementAnalysisCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SettlementAnalysisCondVO[]
	 */
	public SettlementAnalysisCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SettlementAnalysisCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] fromPeriod = (JSPUtil.getParameter(request, prefix	+ "from_period", length));
			String[] fromCgoClmStlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "from_cgo_clm_stl_usd_amt", length));
			String[] fromClmtUsdAmt = (JSPUtil.getParameter(request, prefix	+ "from_clmt_usd_amt", length));
			String[] trnkRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "trnk_ref_vvd_no", length));
			String[] vt = (JSPUtil.getParameter(request, prefix	+ "vt", length));
			String[] clmtClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clmt_clm_pty_no", length));
			String[] clmCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "clm_cgo_tp_cd", length));
			String[] clmtClmAgnPtyNo = (JSPUtil.getParameter(request, prefix	+ "clmt_clm_agn_pty_no", length));
			String[] n1stPreTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pre_ts_loc_cd", length));
			String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_cd", length));
			String[] slvClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "slv_clm_pty_no", length));
			String[] fvd = (JSPUtil.getParameter(request, prefix	+ "fvd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sveyClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "svey_clm_pty_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crrTermCd = (JSPUtil.getParameter(request, prefix	+ "crr_term_cd", length));
			String[] area = (JSPUtil.getParameter(request, prefix	+ "area", length));
			String[] classCd = (JSPUtil.getParameter(request, prefix	+ "class_cd", length));
			String[] reportBy = (JSPUtil.getParameter(request, prefix	+ "report_by", length));
			String[] lablClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "labl_clm_pty_no", length));
			String[] lit = (JSPUtil.getParameter(request, prefix	+ "lit", length));
			String[] mjrClmDmgLssCd = (JSPUtil.getParameter(request, prefix	+ "mjr_clm_dmg_lss_cd", length));
			String[] n1stPstTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pst_ts_loc_cd", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] toCgoClmStlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "to_cgo_clm_stl_usd_amt", length));
			String[] mgrUsrId = (JSPUtil.getParameter(request, prefix	+ "mgr_usr_id", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] toPeriod = (JSPUtil.getParameter(request, prefix	+ "to_period", length));
			String[] toClmtUsdAmt = (JSPUtil.getParameter(request, prefix	+ "to_clmt_usd_amt", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] clmStlAuthUsrId = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_usr_id", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cgoClmStlTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_tp_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] fmalClmRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_ofc_cd", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] cgoClmInciNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_inci_no", length));
			String[] minrClmDmgLssCd = (JSPUtil.getParameter(request, prefix	+ "minr_clm_dmg_lss_cd", length));
			String[] inciPlcTpCd = (JSPUtil.getParameter(request, prefix	+ "inci_plc_tp_cd", length));
			String[] insurClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_no", length));
			String[] cgoClmTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_tp_cd", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SettlementAnalysisCondVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (fromPeriod[i] != null)
					model.setFromPeriod(fromPeriod[i]);
				if (fromCgoClmStlUsdAmt[i] != null)
					model.setFromCgoClmStlUsdAmt(fromCgoClmStlUsdAmt[i]);
				if (fromClmtUsdAmt[i] != null)
					model.setFromClmtUsdAmt(fromClmtUsdAmt[i]);
				if (trnkRefVvdNo[i] != null)
					model.setTrnkRefVvdNo(trnkRefVvdNo[i]);
				if (vt[i] != null)
					model.setVt(vt[i]);
				if (clmtClmPtyNo[i] != null)
					model.setClmtClmPtyNo(clmtClmPtyNo[i]);
				if (clmCgoTpCd[i] != null)
					model.setClmCgoTpCd(clmCgoTpCd[i]);
				if (clmtClmAgnPtyNo[i] != null)
					model.setClmtClmAgnPtyNo(clmtClmAgnPtyNo[i]);
				if (n1stPreTsLocCd[i] != null)
					model.setN1stPreTsLocCd(n1stPreTsLocCd[i]);
				if (hndlOfcCd[i] != null)
					model.setHndlOfcCd(hndlOfcCd[i]);
				if (slvClmPtyNo[i] != null)
					model.setSlvClmPtyNo(slvClmPtyNo[i]);
				if (fvd[i] != null)
					model.setFvd(fvd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sveyClmPtyNo[i] != null)
					model.setSveyClmPtyNo(sveyClmPtyNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crrTermCd[i] != null)
					model.setCrrTermCd(crrTermCd[i]);
				if (area[i] != null)
					model.setArea(area[i]);
				if (classCd[i] != null)
					model.setClassCd(classCd[i]);
				if (reportBy[i] != null)
					model.setReportBy(reportBy[i]);
				if (lablClmPtyNo[i] != null)
					model.setLablClmPtyNo(lablClmPtyNo[i]);
				if (lit[i] != null)
					model.setLit(lit[i]);
				if (mjrClmDmgLssCd[i] != null)
					model.setMjrClmDmgLssCd(mjrClmDmgLssCd[i]);
				if (n1stPstTsLocCd[i] != null)
					model.setN1stPstTsLocCd(n1stPstTsLocCd[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (toCgoClmStlUsdAmt[i] != null)
					model.setToCgoClmStlUsdAmt(toCgoClmStlUsdAmt[i]);
				if (mgrUsrId[i] != null)
					model.setMgrUsrId(mgrUsrId[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (toPeriod[i] != null)
					model.setToPeriod(toPeriod[i]);
				if (toClmtUsdAmt[i] != null)
					model.setToClmtUsdAmt(toClmtUsdAmt[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (clmStlAuthUsrId[i] != null)
					model.setClmStlAuthUsrId(clmStlAuthUsrId[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cgoClmStlTpCd[i] != null)
					model.setCgoClmStlTpCd(cgoClmStlTpCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (fmalClmRcvOfcCd[i] != null)
					model.setFmalClmRcvOfcCd(fmalClmRcvOfcCd[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (cgoClmInciNo[i] != null)
					model.setCgoClmInciNo(cgoClmInciNo[i]);
				if (minrClmDmgLssCd[i] != null)
					model.setMinrClmDmgLssCd(minrClmDmgLssCd[i]);
				if (inciPlcTpCd[i] != null)
					model.setInciPlcTpCd(inciPlcTpCd[i]);
				if (insurClmPtyNo[i] != null)
					model.setInsurClmPtyNo(insurClmPtyNo[i]);
				if (cgoClmTpCd[i] != null)
					model.setCgoClmTpCd(cgoClmTpCd[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSettlementAnalysisCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SettlementAnalysisCondVO[]
	 */
	public SettlementAnalysisCondVO[] getSettlementAnalysisCondVOs(){
		SettlementAnalysisCondVO[] vos = (SettlementAnalysisCondVO[])models.toArray(new SettlementAnalysisCondVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromPeriod = this.fromPeriod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromCgoClmStlUsdAmt = this.fromCgoClmStlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromClmtUsdAmt = this.fromClmtUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkRefVvdNo = this.trnkRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vt = this.vt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtClmPtyNo = this.clmtClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCgoTpCd = this.clmCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtClmAgnPtyNo = this.clmtClmAgnPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPreTsLocCd = this.n1stPreTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcCd = this.hndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slvClmPtyNo = this.slvClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fvd = this.fvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sveyClmPtyNo = this.sveyClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrTermCd = this.crrTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.area = this.area .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.classCd = this.classCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportBy = this.reportBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablClmPtyNo = this.lablClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lit = this.lit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mjrClmDmgLssCd = this.mjrClmDmgLssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPstTsLocCd = this.n1stPstTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCgoClmStlUsdAmt = this.toCgoClmStlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgrUsrId = this.mgrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPeriod = this.toPeriod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toClmtUsdAmt = this.toClmtUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthUsrId = this.clmStlAuthUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlTpCd = this.cgoClmStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvOfcCd = this.fmalClmRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmInciNo = this.cgoClmInciNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minrClmDmgLssCd = this.minrClmDmgLssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciPlcTpCd = this.inciPlcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNo = this.insurClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmTpCd = this.cgoClmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
