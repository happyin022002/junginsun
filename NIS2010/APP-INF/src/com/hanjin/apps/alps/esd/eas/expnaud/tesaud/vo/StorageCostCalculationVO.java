/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StorageCostCalculationVO.java
*@FileTitle : StorageCostCalculationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class StorageCostCalculationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StorageCostCalculationVO> models = new ArrayList<StorageCostCalculationVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String lgsCostCd2 = null;
	/* Column Info */
	private String stkVolQty = null;
	/* Column Info */
	private String rowCount = null;
	/* Column Info */
	private String tmlInvTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fincVslCd = null;
	/* Column Info */
	private String toTrVolVal = null;
	/* Column Info */
	private String tmlAgmtVerNo = null;
	/* Column Info */
	private String freeDyXcldDys = null;
	/* Column Info */
	private String volTrUtCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String fmPrdDt = null;
	/* Column Info */
	private String calcVolQty = null;
	/* Column Info */
	private String tmlSoDtlSeq = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String ovrDys2 = null;
	/* Column Info */
	private String invDateType = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String dcgoIndCd = null;
	/* Column Info */
	private String calcAmt = null;
	/* Column Info */
	private String fpTeuQty = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String tmlAgmtSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String tmlSoSeq = null;
	/* Column Info */
	private String ovrDys = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String fincSkdDirCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String tmlCrrCd = null;
	/* Column Info */
	private String calcCostGrpCd = null;
	/* Column Info */
	private String atbDt = null;
	/* Column Info */
	private String calcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String stayDys = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String wrkDt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String n3ptyFlg = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String ovrVolQty = null;
	/* Column Info */
	private String tmlAgmtOfcCtyCd = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String rvisVolQty = null;
	/* Column Info */
	private String fincSkdVoyNo = null;
	/* Column Info */
	private String ctrtRt = null;
	/* Column Info */
	private String refVndrSeq = null;
	/* Column Info */
	private String calcRmk = null;
	/* Column Info */
	private String fmTrVolVal = null;
	/* Column Info */
	private String toPrdDt = null;
	/* Column Info */
	private String diffVolQty = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String payDys = null;
	/* Column Info */
	private String freeDys = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String tmlInvStsCd = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String invVolQty = null;
	/* Column Info */
	private String tmlWrkDyCd = null;
	/* Column Info */
	private String tmlSoOfcCtyCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public StorageCostCalculationVO() {}

	public StorageCostCalculationVO(String ibflag, String pagerows, String vslCd, String lgsCostCd2, String stkVolQty, String rowCount, String tmlInvTpCd, String fincVslCd, String toTrVolVal, String tmlAgmtVerNo, String freeDyXcldDys, String volTrUtCd, String cntrTpszCd, String fmPrdDt, String invXchRt, String tmlSoDtlSeq, String calcVolQty, String rhq, String revYrmon, String invDateType, String ovrDys2, String skdVoyNo, String dcgoIndCd, String calcAmt, String fpTeuQty, String pageNo, String tmlAgmtSeq, String vndrSeq, String tmlSoSeq, String ovrDys, String laneCd, String currCd, String fincSkdDirCd, String vndrLglEngNm, String tmlCrrCd, String calcCostGrpCd, String atbDt, String calcTpCd, String stayDys, String acctCd, String invAmt, String wrkDt, String invOfcCd, String n3ptyFlg, String iocCd, String ovrVolQty, String tmlAgmtOfcCtyCd, String costOfcCd, String fincSkdVoyNo, String rvisVolQty, String refVndrSeq, String ctrtRt, String calcRmk, String toPrdDt, String fmTrVolVal, String diffVolQty, String ioBndCd, String skdDirCd, String invNo, String payDys, String ydCd, String freeDys, String tmlInvStsCd, String cntrNo, String lgsCostCd, String tmlWrkDyCd, String invVolQty, String tmlSoOfcCtyCd, String creUsrNm) {
		this.vslCd = vslCd;
		this.lgsCostCd2 = lgsCostCd2;
		this.stkVolQty = stkVolQty;
		this.rowCount = rowCount;
		this.tmlInvTpCd = tmlInvTpCd;
		this.pagerows = pagerows;
		this.fincVslCd = fincVslCd;
		this.toTrVolVal = toTrVolVal;
		this.tmlAgmtVerNo = tmlAgmtVerNo;
		this.freeDyXcldDys = freeDyXcldDys;
		this.volTrUtCd = volTrUtCd;
		this.cntrTpszCd = cntrTpszCd;
		this.fmPrdDt = fmPrdDt;
		this.calcVolQty = calcVolQty;
		this.tmlSoDtlSeq = tmlSoDtlSeq;
		this.invXchRt = invXchRt;
		this.rhq = rhq;
		this.revYrmon = revYrmon;
		this.ovrDys2 = ovrDys2;
		this.invDateType = invDateType;
		this.skdVoyNo = skdVoyNo;
		this.creUsrNm = creUsrNm;
		this.dcgoIndCd = dcgoIndCd;
		this.calcAmt = calcAmt;
		this.fpTeuQty = fpTeuQty;
		this.pageNo = pageNo;
		this.tmlAgmtSeq = tmlAgmtSeq;
		this.vndrSeq = vndrSeq;
		this.tmlSoSeq = tmlSoSeq;
		this.ovrDys = ovrDys;
		this.laneCd = laneCd;
		this.currCd = currCd;
		this.fincSkdDirCd = fincSkdDirCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.tmlCrrCd = tmlCrrCd;
		this.calcCostGrpCd = calcCostGrpCd;
		this.atbDt = atbDt;
		this.calcTpCd = calcTpCd;
		this.ibflag = ibflag;
		this.stayDys = stayDys;
		this.acctCd = acctCd;
		this.invAmt = invAmt;
		this.wrkDt = wrkDt;
		this.invOfcCd = invOfcCd;
		this.n3ptyFlg = n3ptyFlg;
		this.iocCd = iocCd;
		this.ovrVolQty = ovrVolQty;
		this.tmlAgmtOfcCtyCd = tmlAgmtOfcCtyCd;
		this.costOfcCd = costOfcCd;
		this.rvisVolQty = rvisVolQty;
		this.fincSkdVoyNo = fincSkdVoyNo;
		this.ctrtRt = ctrtRt;
		this.refVndrSeq = refVndrSeq;
		this.calcRmk = calcRmk;
		this.fmTrVolVal = fmTrVolVal;
		this.toPrdDt = toPrdDt;
		this.diffVolQty = diffVolQty;
		this.ioBndCd = ioBndCd;
		this.skdDirCd = skdDirCd;
		this.invNo = invNo;
		this.payDys = payDys;
		this.freeDys = freeDys;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.tmlInvStsCd = tmlInvStsCd;
		this.lgsCostCd = lgsCostCd;
		this.invVolQty = invVolQty;
		this.tmlWrkDyCd = tmlWrkDyCd;
		this.tmlSoOfcCtyCd = tmlSoOfcCtyCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("lgs_cost_cd2", getLgsCostCd2());
		this.hashColumns.put("stk_vol_qty", getStkVolQty());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("tml_inv_tp_cd", getTmlInvTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("finc_vsl_cd", getFincVslCd());
		this.hashColumns.put("to_tr_vol_val", getToTrVolVal());
		this.hashColumns.put("tml_agmt_ver_no", getTmlAgmtVerNo());
		this.hashColumns.put("free_dy_xcld_dys", getFreeDyXcldDys());
		this.hashColumns.put("vol_tr_ut_cd", getVolTrUtCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("fm_prd_dt", getFmPrdDt());
		this.hashColumns.put("calc_vol_qty", getCalcVolQty());
		this.hashColumns.put("tml_so_dtl_seq", getTmlSoDtlSeq());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("ovr_dys2", getOvrDys2());
		this.hashColumns.put("inv_date_type", getInvDateType());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("dcgo_ind_cd", getDcgoIndCd());
		this.hashColumns.put("calc_amt", getCalcAmt());
		this.hashColumns.put("fp_teu_qty", getFpTeuQty());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("tml_agmt_seq", getTmlAgmtSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("tml_so_seq", getTmlSoSeq());
		this.hashColumns.put("ovr_dys", getOvrDys());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("finc_skd_dir_cd", getFincSkdDirCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("tml_crr_cd", getTmlCrrCd());
		this.hashColumns.put("calc_cost_grp_cd", getCalcCostGrpCd());
		this.hashColumns.put("atb_dt", getAtbDt());
		this.hashColumns.put("calc_tp_cd", getCalcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("stay_dys", getStayDys());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("wrk_dt", getWrkDt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("n3pty_flg", getN3ptyFlg());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("ovr_vol_qty", getOvrVolQty());
		this.hashColumns.put("tml_agmt_ofc_cty_cd", getTmlAgmtOfcCtyCd());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("rvis_vol_qty", getRvisVolQty());
		this.hashColumns.put("finc_skd_voy_no", getFincSkdVoyNo());
		this.hashColumns.put("ctrt_rt", getCtrtRt());
		this.hashColumns.put("ref_vndr_seq", getRefVndrSeq());
		this.hashColumns.put("calc_rmk", getCalcRmk());
		this.hashColumns.put("fm_tr_vol_val", getFmTrVolVal());
		this.hashColumns.put("to_prd_dt", getToPrdDt());
		this.hashColumns.put("diff_vol_qty", getDiffVolQty());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("pay_dys", getPayDys());
		this.hashColumns.put("free_dys", getFreeDys());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("tml_inv_sts_cd", getTmlInvStsCd());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("inv_vol_qty", getInvVolQty());
		this.hashColumns.put("tml_wrk_dy_cd", getTmlWrkDyCd());
		this.hashColumns.put("tml_so_ofc_cty_cd", getTmlSoOfcCtyCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("lgs_cost_cd2", "lgsCostCd2");
		this.hashFields.put("stk_vol_qty", "stkVolQty");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("tml_inv_tp_cd", "tmlInvTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("finc_vsl_cd", "fincVslCd");
		this.hashFields.put("to_tr_vol_val", "toTrVolVal");
		this.hashFields.put("tml_agmt_ver_no", "tmlAgmtVerNo");
		this.hashFields.put("free_dy_xcld_dys", "freeDyXcldDys");
		this.hashFields.put("vol_tr_ut_cd", "volTrUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("fm_prd_dt", "fmPrdDt");
		this.hashFields.put("calc_vol_qty", "calcVolQty");
		this.hashFields.put("tml_so_dtl_seq", "tmlSoDtlSeq");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("ovr_dys2", "ovrDys2");
		this.hashFields.put("inv_date_type", "invDateType");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("dcgo_ind_cd", "dcgoIndCd");
		this.hashFields.put("calc_amt", "calcAmt");
		this.hashFields.put("fp_teu_qty", "fpTeuQty");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("tml_agmt_seq", "tmlAgmtSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("tml_so_seq", "tmlSoSeq");
		this.hashFields.put("ovr_dys", "ovrDys");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("finc_skd_dir_cd", "fincSkdDirCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("tml_crr_cd", "tmlCrrCd");
		this.hashFields.put("calc_cost_grp_cd", "calcCostGrpCd");
		this.hashFields.put("atb_dt", "atbDt");
		this.hashFields.put("calc_tp_cd", "calcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("stay_dys", "stayDys");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("wrk_dt", "wrkDt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("n3pty_flg", "n3ptyFlg");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("ovr_vol_qty", "ovrVolQty");
		this.hashFields.put("tml_agmt_ofc_cty_cd", "tmlAgmtOfcCtyCd");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("rvis_vol_qty", "rvisVolQty");
		this.hashFields.put("finc_skd_voy_no", "fincSkdVoyNo");
		this.hashFields.put("ctrt_rt", "ctrtRt");
		this.hashFields.put("ref_vndr_seq", "refVndrSeq");
		this.hashFields.put("calc_rmk", "calcRmk");
		this.hashFields.put("fm_tr_vol_val", "fmTrVolVal");
		this.hashFields.put("to_prd_dt", "toPrdDt");
		this.hashFields.put("diff_vol_qty", "diffVolQty");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("pay_dys", "payDys");
		this.hashFields.put("free_dys", "freeDys");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("tml_inv_sts_cd", "tmlInvStsCd");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("inv_vol_qty", "invVolQty");
		this.hashFields.put("tml_wrk_dy_cd", "tmlWrkDyCd");
		this.hashFields.put("tml_so_ofc_cty_cd", "tmlSoOfcCtyCd");
		return this.hashFields;
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
	 * @return lgsCostCd2
	 */
	public String getLgsCostCd2() {
		return this.lgsCostCd2;
	}
	
	/**
	 * Column Info
	 * @return stkVolQty
	 */
	public String getStkVolQty() {
		return this.stkVolQty;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getRowCount() {
		return this.rowCount;
	}
	
	/**
	 * Column Info
	 * @return tmlInvTpCd
	 */
	public String getTmlInvTpCd() {
		return this.tmlInvTpCd;
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
	 * @return fincVslCd
	 */
	public String getFincVslCd() {
		return this.fincVslCd;
	}
	
	/**
	 * Column Info
	 * @return toTrVolVal
	 */
	public String getToTrVolVal() {
		return this.toTrVolVal;
	}
	
	/**
	 * Column Info
	 * @return tmlAgmtVerNo
	 */
	public String getTmlAgmtVerNo() {
		return this.tmlAgmtVerNo;
	}
	
	/**
	 * Column Info
	 * @return freeDyXcldDys
	 */
	public String getFreeDyXcldDys() {
		return this.freeDyXcldDys;
	}
	
	/**
	 * Column Info
	 * @return volTrUtCd
	 */
	public String getVolTrUtCd() {
		return this.volTrUtCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return fmPrdDt
	 */
	public String getFmPrdDt() {
		return this.fmPrdDt;
	}
	
	/**
	 * Column Info
	 * @return calcVolQty
	 */
	public String getCalcVolQty() {
		return this.calcVolQty;
	}
	
	/**
	 * Column Info
	 * @return tmlSoDtlSeq
	 */
	public String getTmlSoDtlSeq() {
		return this.tmlSoDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return ovrDys2
	 */
	public String getOvrDys2() {
		return this.ovrDys2;
	}
	
	/**
	 * Column Info
	 * @return invDateType
	 */
	public String getInvDateType() {
		return this.invDateType;
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
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}
	
	/**
	 * Column Info
	 * @return dcgoIndCd
	 */
	public String getDcgoIndCd() {
		return this.dcgoIndCd;
	}
	
	/**
	 * Column Info
	 * @return calcAmt
	 */
	public String getCalcAmt() {
		return this.calcAmt;
	}
	
	/**
	 * Column Info
	 * @return fpTeuQty
	 */
	public String getFpTeuQty() {
		return this.fpTeuQty;
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
	 * @return tmlAgmtSeq
	 */
	public String getTmlAgmtSeq() {
		return this.tmlAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return tmlSoSeq
	 */
	public String getTmlSoSeq() {
		return this.tmlSoSeq;
	}
	
	/**
	 * Column Info
	 * @return ovrDys
	 */
	public String getOvrDys() {
		return this.ovrDys;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return fincSkdDirCd
	 */
	public String getFincSkdDirCd() {
		return this.fincSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return tmlCrrCd
	 */
	public String getTmlCrrCd() {
		return this.tmlCrrCd;
	}
	
	/**
	 * Column Info
	 * @return calcCostGrpCd
	 */
	public String getCalcCostGrpCd() {
		return this.calcCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @return atbDt
	 */
	public String getAtbDt() {
		return this.atbDt;
	}
	
	/**
	 * Column Info
	 * @return calcTpCd
	 */
	public String getCalcTpCd() {
		return this.calcTpCd;
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
	 * @return stayDys
	 */
	public String getStayDys() {
		return this.stayDys;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return wrkDt
	 */
	public String getWrkDt() {
		return this.wrkDt;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyFlg
	 */
	public String getN3ptyFlg() {
		return this.n3ptyFlg;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return ovrVolQty
	 */
	public String getOvrVolQty() {
		return this.ovrVolQty;
	}
	
	/**
	 * Column Info
	 * @return tmlAgmtOfcCtyCd
	 */
	public String getTmlAgmtOfcCtyCd() {
		return this.tmlAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rvisVolQty
	 */
	public String getRvisVolQty() {
		return this.rvisVolQty;
	}
	
	/**
	 * Column Info
	 * @return fincSkdVoyNo
	 */
	public String getFincSkdVoyNo() {
		return this.fincSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return ctrtRt
	 */
	public String getCtrtRt() {
		return this.ctrtRt;
	}
	
	/**
	 * Column Info
	 * @return refVndrSeq
	 */
	public String getRefVndrSeq() {
		return this.refVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return calcRmk
	 */
	public String getCalcRmk() {
		return this.calcRmk;
	}
	
	/**
	 * Column Info
	 * @return fmTrVolVal
	 */
	public String getFmTrVolVal() {
		return this.fmTrVolVal;
	}
	
	/**
	 * Column Info
	 * @return toPrdDt
	 */
	public String getToPrdDt() {
		return this.toPrdDt;
	}
	
	/**
	 * Column Info
	 * @return diffVolQty
	 */
	public String getDiffVolQty() {
		return this.diffVolQty;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return payDys
	 */
	public String getPayDys() {
		return this.payDys;
	}
	
	/**
	 * Column Info
	 * @return freeDys
	 */
	public String getFreeDys() {
		return this.freeDys;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return tmlInvStsCd
	 */
	public String getTmlInvStsCd() {
		return this.tmlInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return invVolQty
	 */
	public String getInvVolQty() {
		return this.invVolQty;
	}
	
	/**
	 * Column Info
	 * @return tmlWrkDyCd
	 */
	public String getTmlWrkDyCd() {
		return this.tmlWrkDyCd;
	}
	
	/**
	 * Column Info
	 * @return tmlSoOfcCtyCd
	 */
	public String getTmlSoOfcCtyCd() {
		return this.tmlSoOfcCtyCd;
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
	 * @param lgsCostCd2
	 */
	public void setLgsCostCd2(String lgsCostCd2) {
		this.lgsCostCd2 = lgsCostCd2;
	}
	
	/**
	 * Column Info
	 * @param stkVolQty
	 */
	public void setStkVolQty(String stkVolQty) {
		this.stkVolQty = stkVolQty;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}
	
	/**
	 * Column Info
	 * @param tmlInvTpCd
	 */
	public void setTmlInvTpCd(String tmlInvTpCd) {
		this.tmlInvTpCd = tmlInvTpCd;
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
	 * @param fincVslCd
	 */
	public void setFincVslCd(String fincVslCd) {
		this.fincVslCd = fincVslCd;
	}
	
	/**
	 * Column Info
	 * @param toTrVolVal
	 */
	public void setToTrVolVal(String toTrVolVal) {
		this.toTrVolVal = toTrVolVal;
	}
	
	/**
	 * Column Info
	 * @param tmlAgmtVerNo
	 */
	public void setTmlAgmtVerNo(String tmlAgmtVerNo) {
		this.tmlAgmtVerNo = tmlAgmtVerNo;
	}
	
	/**
	 * Column Info
	 * @param freeDyXcldDys
	 */
	public void setFreeDyXcldDys(String freeDyXcldDys) {
		this.freeDyXcldDys = freeDyXcldDys;
	}
	
	/**
	 * Column Info
	 * @param volTrUtCd
	 */
	public void setVolTrUtCd(String volTrUtCd) {
		this.volTrUtCd = volTrUtCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param fmPrdDt
	 */
	public void setFmPrdDt(String fmPrdDt) {
		this.fmPrdDt = fmPrdDt;
	}
	
	/**
	 * Column Info
	 * @param calcVolQty
	 */
	public void setCalcVolQty(String calcVolQty) {
		this.calcVolQty = calcVolQty;
	}
	
	/**
	 * Column Info
	 * @param tmlSoDtlSeq
	 */
	public void setTmlSoDtlSeq(String tmlSoDtlSeq) {
		this.tmlSoDtlSeq = tmlSoDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param ovrDys2
	 */
	public void setOvrDys2(String ovrDys2) {
		this.ovrDys2 = ovrDys2;
	}
	
	/**
	 * Column Info
	 * @param invDateType
	 */
	public void setInvDateType(String invDateType) {
		this.invDateType = invDateType;
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
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}
	
	/**
	 * Column Info
	 * @param dcgoIndCd
	 */
	public void setDcgoIndCd(String dcgoIndCd) {
		this.dcgoIndCd = dcgoIndCd;
	}
	
	/**
	 * Column Info
	 * @param calcAmt
	 */
	public void setCalcAmt(String calcAmt) {
		this.calcAmt = calcAmt;
	}
	
	/**
	 * Column Info
	 * @param fpTeuQty
	 */
	public void setFpTeuQty(String fpTeuQty) {
		this.fpTeuQty = fpTeuQty;
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
	 * @param tmlAgmtSeq
	 */
	public void setTmlAgmtSeq(String tmlAgmtSeq) {
		this.tmlAgmtSeq = tmlAgmtSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param tmlSoSeq
	 */
	public void setTmlSoSeq(String tmlSoSeq) {
		this.tmlSoSeq = tmlSoSeq;
	}
	
	/**
	 * Column Info
	 * @param ovrDys
	 */
	public void setOvrDys(String ovrDys) {
		this.ovrDys = ovrDys;
	}
	
	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param fincSkdDirCd
	 */
	public void setFincSkdDirCd(String fincSkdDirCd) {
		this.fincSkdDirCd = fincSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param tmlCrrCd
	 */
	public void setTmlCrrCd(String tmlCrrCd) {
		this.tmlCrrCd = tmlCrrCd;
	}
	
	/**
	 * Column Info
	 * @param calcCostGrpCd
	 */
	public void setCalcCostGrpCd(String calcCostGrpCd) {
		this.calcCostGrpCd = calcCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @param atbDt
	 */
	public void setAtbDt(String atbDt) {
		this.atbDt = atbDt;
	}
	
	/**
	 * Column Info
	 * @param calcTpCd
	 */
	public void setCalcTpCd(String calcTpCd) {
		this.calcTpCd = calcTpCd;
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
	 * @param stayDys
	 */
	public void setStayDys(String stayDys) {
		this.stayDys = stayDys;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param wrkDt
	 */
	public void setWrkDt(String wrkDt) {
		this.wrkDt = wrkDt;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyFlg
	 */
	public void setN3ptyFlg(String n3ptyFlg) {
		this.n3ptyFlg = n3ptyFlg;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param ovrVolQty
	 */
	public void setOvrVolQty(String ovrVolQty) {
		this.ovrVolQty = ovrVolQty;
	}
	
	/**
	 * Column Info
	 * @param tmlAgmtOfcCtyCd
	 */
	public void setTmlAgmtOfcCtyCd(String tmlAgmtOfcCtyCd) {
		this.tmlAgmtOfcCtyCd = tmlAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rvisVolQty
	 */
	public void setRvisVolQty(String rvisVolQty) {
		this.rvisVolQty = rvisVolQty;
	}
	
	/**
	 * Column Info
	 * @param fincSkdVoyNo
	 */
	public void setFincSkdVoyNo(String fincSkdVoyNo) {
		this.fincSkdVoyNo = fincSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param ctrtRt
	 */
	public void setCtrtRt(String ctrtRt) {
		this.ctrtRt = ctrtRt;
	}
	
	/**
	 * Column Info
	 * @param refVndrSeq
	 */
	public void setRefVndrSeq(String refVndrSeq) {
		this.refVndrSeq = refVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param calcRmk
	 */
	public void setCalcRmk(String calcRmk) {
		this.calcRmk = calcRmk;
	}
	
	/**
	 * Column Info
	 * @param fmTrVolVal
	 */
	public void setFmTrVolVal(String fmTrVolVal) {
		this.fmTrVolVal = fmTrVolVal;
	}
	
	/**
	 * Column Info
	 * @param toPrdDt
	 */
	public void setToPrdDt(String toPrdDt) {
		this.toPrdDt = toPrdDt;
	}
	
	/**
	 * Column Info
	 * @param diffVolQty
	 */
	public void setDiffVolQty(String diffVolQty) {
		this.diffVolQty = diffVolQty;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param payDys
	 */
	public void setPayDys(String payDys) {
		this.payDys = payDys;
	}
	
	/**
	 * Column Info
	 * @param freeDys
	 */
	public void setFreeDys(String freeDys) {
		this.freeDys = freeDys;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param tmlInvStsCd
	 */
	public void setTmlInvStsCd(String tmlInvStsCd) {
		this.tmlInvStsCd = tmlInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param invVolQty
	 */
	public void setInvVolQty(String invVolQty) {
		this.invVolQty = invVolQty;
	}
	
	/**
	 * Column Info
	 * @param tmlWrkDyCd
	 */
	public void setTmlWrkDyCd(String tmlWrkDyCd) {
		this.tmlWrkDyCd = tmlWrkDyCd;
	}
	
	/**
	 * Column Info
	 * @param tmlSoOfcCtyCd
	 */
	public void setTmlSoOfcCtyCd(String tmlSoOfcCtyCd) {
		this.tmlSoOfcCtyCd = tmlSoOfcCtyCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setLgsCostCd2(JSPUtil.getParameter(request, prefix + "lgs_cost_cd2", ""));
		setStkVolQty(JSPUtil.getParameter(request, prefix + "stk_vol_qty", ""));
		setRowCount(JSPUtil.getParameter(request, prefix + "row_count", ""));
		setTmlInvTpCd(JSPUtil.getParameter(request, prefix + "tml_inv_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFincVslCd(JSPUtil.getParameter(request, prefix + "finc_vsl_cd", ""));
		setToTrVolVal(JSPUtil.getParameter(request, prefix + "to_tr_vol_val", ""));
		setTmlAgmtVerNo(JSPUtil.getParameter(request, prefix + "tml_agmt_ver_no", ""));
		setFreeDyXcldDys(JSPUtil.getParameter(request, prefix + "free_dy_xcld_dys", ""));
		setVolTrUtCd(JSPUtil.getParameter(request, prefix + "vol_tr_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setFmPrdDt(JSPUtil.getParameter(request, prefix + "fm_prd_dt", ""));
		setCalcVolQty(JSPUtil.getParameter(request, prefix + "calc_vol_qty", ""));
		setTmlSoDtlSeq(JSPUtil.getParameter(request, prefix + "tml_so_dtl_seq", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setOvrDys2(JSPUtil.getParameter(request, prefix + "ovr_dys2", ""));
		setInvDateType(JSPUtil.getParameter(request, prefix + "inv_date_type", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setDcgoIndCd(JSPUtil.getParameter(request, prefix + "dcgo_ind_cd", ""));
		setCalcAmt(JSPUtil.getParameter(request, prefix + "calc_amt", ""));
		setFpTeuQty(JSPUtil.getParameter(request, prefix + "fp_teu_qty", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setTmlAgmtSeq(JSPUtil.getParameter(request, prefix + "tml_agmt_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setTmlSoSeq(JSPUtil.getParameter(request, prefix + "tml_so_seq", ""));
		setOvrDys(JSPUtil.getParameter(request, prefix + "ovr_dys", ""));
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setFincSkdDirCd(JSPUtil.getParameter(request, prefix + "finc_skd_dir_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setTmlCrrCd(JSPUtil.getParameter(request, prefix + "tml_crr_cd", ""));
		setCalcCostGrpCd(JSPUtil.getParameter(request, prefix + "calc_cost_grp_cd", ""));
		setAtbDt(JSPUtil.getParameter(request, prefix + "atb_dt", ""));
		setCalcTpCd(JSPUtil.getParameter(request, prefix + "calc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setStayDys(JSPUtil.getParameter(request, prefix + "stay_dys", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setWrkDt(JSPUtil.getParameter(request, prefix + "wrk_dt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setN3ptyFlg(JSPUtil.getParameter(request, prefix + "n3pty_flg", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setOvrVolQty(JSPUtil.getParameter(request, prefix + "ovr_vol_qty", ""));
		setTmlAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "tml_agmt_ofc_cty_cd", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setRvisVolQty(JSPUtil.getParameter(request, prefix + "rvis_vol_qty", ""));
		setFincSkdVoyNo(JSPUtil.getParameter(request, prefix + "finc_skd_voy_no", ""));
		setCtrtRt(JSPUtil.getParameter(request, prefix + "ctrt_rt", ""));
		setRefVndrSeq(JSPUtil.getParameter(request, prefix + "ref_vndr_seq", ""));
		setCalcRmk(JSPUtil.getParameter(request, prefix + "calc_rmk", ""));
		setFmTrVolVal(JSPUtil.getParameter(request, prefix + "fm_tr_vol_val", ""));
		setToPrdDt(JSPUtil.getParameter(request, prefix + "to_prd_dt", ""));
		setDiffVolQty(JSPUtil.getParameter(request, prefix + "diff_vol_qty", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setPayDys(JSPUtil.getParameter(request, prefix + "pay_dys", ""));
		setFreeDys(JSPUtil.getParameter(request, prefix + "free_dys", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setTmlInvStsCd(JSPUtil.getParameter(request, prefix + "tml_inv_sts_cd", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setInvVolQty(JSPUtil.getParameter(request, prefix + "inv_vol_qty", ""));
		setTmlWrkDyCd(JSPUtil.getParameter(request, prefix + "tml_wrk_dy_cd", ""));
		setTmlSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "tml_so_ofc_cty_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StorageCostCalculationVO[]
	 */
	public StorageCostCalculationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StorageCostCalculationVO[]
	 */
	public StorageCostCalculationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StorageCostCalculationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] lgsCostCd2 = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd2", length));
			String[] stkVolQty = (JSPUtil.getParameter(request, prefix	+ "stk_vol_qty", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] tmlInvTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_inv_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fincVslCd = (JSPUtil.getParameter(request, prefix	+ "finc_vsl_cd", length));
			String[] toTrVolVal = (JSPUtil.getParameter(request, prefix	+ "to_tr_vol_val", length));
			String[] tmlAgmtVerNo = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_ver_no", length));
			String[] freeDyXcldDys = (JSPUtil.getParameter(request, prefix	+ "free_dy_xcld_dys", length));
			String[] volTrUtCd = (JSPUtil.getParameter(request, prefix	+ "vol_tr_ut_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] fmPrdDt = (JSPUtil.getParameter(request, prefix	+ "fm_prd_dt", length));
			String[] calcVolQty = (JSPUtil.getParameter(request, prefix	+ "calc_vol_qty", length));
			String[] tmlSoDtlSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_dtl_seq", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] ovrDys2 = (JSPUtil.getParameter(request, prefix	+ "ovr_dys2", length));
			String[] invDateType = (JSPUtil.getParameter(request, prefix	+ "inv_date_type", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] dcgoIndCd = (JSPUtil.getParameter(request, prefix	+ "dcgo_ind_cd", length));
			String[] calcAmt = (JSPUtil.getParameter(request, prefix	+ "calc_amt", length));
			String[] fpTeuQty = (JSPUtil.getParameter(request, prefix	+ "fp_teu_qty", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] tmlAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] tmlSoSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_seq", length));
			String[] ovrDys = (JSPUtil.getParameter(request, prefix	+ "ovr_dys", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] fincSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "finc_skd_dir_cd", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] tmlCrrCd = (JSPUtil.getParameter(request, prefix	+ "tml_crr_cd", length));
			String[] calcCostGrpCd = (JSPUtil.getParameter(request, prefix	+ "calc_cost_grp_cd", length));
			String[] atbDt = (JSPUtil.getParameter(request, prefix	+ "atb_dt", length));
			String[] calcTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] stayDys = (JSPUtil.getParameter(request, prefix	+ "stay_dys", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] wrkDt = (JSPUtil.getParameter(request, prefix	+ "wrk_dt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] n3ptyFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_flg", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] ovrVolQty = (JSPUtil.getParameter(request, prefix	+ "ovr_vol_qty", length));
			String[] tmlAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "tml_agmt_ofc_cty_cd", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] rvisVolQty = (JSPUtil.getParameter(request, prefix	+ "rvis_vol_qty", length));
			String[] fincSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "finc_skd_voy_no", length));
			String[] ctrtRt = (JSPUtil.getParameter(request, prefix	+ "ctrt_rt", length));
			String[] refVndrSeq = (JSPUtil.getParameter(request, prefix	+ "ref_vndr_seq", length));
			String[] calcRmk = (JSPUtil.getParameter(request, prefix	+ "calc_rmk", length));
			String[] fmTrVolVal = (JSPUtil.getParameter(request, prefix	+ "fm_tr_vol_val", length));
			String[] toPrdDt = (JSPUtil.getParameter(request, prefix	+ "to_prd_dt", length));
			String[] diffVolQty = (JSPUtil.getParameter(request, prefix	+ "diff_vol_qty", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] payDys = (JSPUtil.getParameter(request, prefix	+ "pay_dys", length));
			String[] freeDys = (JSPUtil.getParameter(request, prefix	+ "free_dys", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] tmlInvStsCd = (JSPUtil.getParameter(request, prefix	+ "tml_inv_sts_cd", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] invVolQty = (JSPUtil.getParameter(request, prefix	+ "inv_vol_qty", length));
			String[] tmlWrkDyCd = (JSPUtil.getParameter(request, prefix	+ "tml_wrk_dy_cd", length));
			String[] tmlSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "tml_so_ofc_cty_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new StorageCostCalculationVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (lgsCostCd2[i] != null)
					model.setLgsCostCd2(lgsCostCd2[i]);
				if (stkVolQty[i] != null)
					model.setStkVolQty(stkVolQty[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (tmlInvTpCd[i] != null)
					model.setTmlInvTpCd(tmlInvTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fincVslCd[i] != null)
					model.setFincVslCd(fincVslCd[i]);
				if (toTrVolVal[i] != null)
					model.setToTrVolVal(toTrVolVal[i]);
				if (tmlAgmtVerNo[i] != null)
					model.setTmlAgmtVerNo(tmlAgmtVerNo[i]);
				if (freeDyXcldDys[i] != null)
					model.setFreeDyXcldDys(freeDyXcldDys[i]);
				if (volTrUtCd[i] != null)
					model.setVolTrUtCd(volTrUtCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (fmPrdDt[i] != null)
					model.setFmPrdDt(fmPrdDt[i]);
				if (calcVolQty[i] != null)
					model.setCalcVolQty(calcVolQty[i]);
				if (tmlSoDtlSeq[i] != null)
					model.setTmlSoDtlSeq(tmlSoDtlSeq[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (ovrDys2[i] != null)
					model.setOvrDys2(ovrDys2[i]);
				if (invDateType[i] != null)
					model.setInvDateType(invDateType[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (dcgoIndCd[i] != null)
					model.setDcgoIndCd(dcgoIndCd[i]);
				if (calcAmt[i] != null)
					model.setCalcAmt(calcAmt[i]);
				if (fpTeuQty[i] != null)
					model.setFpTeuQty(fpTeuQty[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (tmlAgmtSeq[i] != null)
					model.setTmlAgmtSeq(tmlAgmtSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (tmlSoSeq[i] != null)
					model.setTmlSoSeq(tmlSoSeq[i]);
				if (ovrDys[i] != null)
					model.setOvrDys(ovrDys[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (fincSkdDirCd[i] != null)
					model.setFincSkdDirCd(fincSkdDirCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (tmlCrrCd[i] != null)
					model.setTmlCrrCd(tmlCrrCd[i]);
				if (calcCostGrpCd[i] != null)
					model.setCalcCostGrpCd(calcCostGrpCd[i]);
				if (atbDt[i] != null)
					model.setAtbDt(atbDt[i]);
				if (calcTpCd[i] != null)
					model.setCalcTpCd(calcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (stayDys[i] != null)
					model.setStayDys(stayDys[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (wrkDt[i] != null)
					model.setWrkDt(wrkDt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (n3ptyFlg[i] != null)
					model.setN3ptyFlg(n3ptyFlg[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (ovrVolQty[i] != null)
					model.setOvrVolQty(ovrVolQty[i]);
				if (tmlAgmtOfcCtyCd[i] != null)
					model.setTmlAgmtOfcCtyCd(tmlAgmtOfcCtyCd[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (rvisVolQty[i] != null)
					model.setRvisVolQty(rvisVolQty[i]);
				if (fincSkdVoyNo[i] != null)
					model.setFincSkdVoyNo(fincSkdVoyNo[i]);
				if (ctrtRt[i] != null)
					model.setCtrtRt(ctrtRt[i]);
				if (refVndrSeq[i] != null)
					model.setRefVndrSeq(refVndrSeq[i]);
				if (calcRmk[i] != null)
					model.setCalcRmk(calcRmk[i]);
				if (fmTrVolVal[i] != null)
					model.setFmTrVolVal(fmTrVolVal[i]);
				if (toPrdDt[i] != null)
					model.setToPrdDt(toPrdDt[i]);
				if (diffVolQty[i] != null)
					model.setDiffVolQty(diffVolQty[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (payDys[i] != null)
					model.setPayDys(payDys[i]);
				if (freeDys[i] != null)
					model.setFreeDys(freeDys[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (tmlInvStsCd[i] != null)
					model.setTmlInvStsCd(tmlInvStsCd[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (invVolQty[i] != null)
					model.setInvVolQty(invVolQty[i]);
				if (tmlWrkDyCd[i] != null)
					model.setTmlWrkDyCd(tmlWrkDyCd[i]);
				if (tmlSoOfcCtyCd[i] != null)
					model.setTmlSoOfcCtyCd(tmlSoOfcCtyCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStorageCostCalculationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StorageCostCalculationVO[]
	 */
	public StorageCostCalculationVO[] getStorageCostCalculationVOs(){
		StorageCostCalculationVO[] vos = (StorageCostCalculationVO[])models.toArray(new StorageCostCalculationVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd2 = this.lgsCostCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkVolQty = this.stkVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvTpCd = this.tmlInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincVslCd = this.fincVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTrVolVal = this.toTrVolVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtVerNo = this.tmlAgmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDyXcldDys = this.freeDyXcldDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volTrUtCd = this.volTrUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrdDt = this.fmPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcVolQty = this.calcVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoDtlSeq = this.tmlSoDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDys2 = this.ovrDys2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDateType = this.invDateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoIndCd = this.dcgoIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcAmt = this.calcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fpTeuQty = this.fpTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtSeq = this.tmlAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoSeq = this.tmlSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDys = this.ovrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincSkdDirCd = this.fincSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCrrCd = this.tmlCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcCostGrpCd = this.calcCostGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atbDt = this.atbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTpCd = this.calcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDys = this.stayDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrkDt = this.wrkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyFlg = this.n3ptyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrVolQty = this.ovrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtOfcCtyCd = this.tmlAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisVolQty = this.rvisVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincSkdVoyNo = this.fincSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRt = this.ctrtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refVndrSeq = this.refVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcRmk = this.calcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTrVolVal = this.fmTrVolVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrdDt = this.toPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffVolQty = this.diffVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDys = this.payDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDys = this.freeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvStsCd = this.tmlInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVolQty = this.invVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlWrkDyCd = this.tmlWrkDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoOfcCtyCd = this.tmlSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
