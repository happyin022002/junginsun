/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OffdockCYInvoiceManageVO.java
*@FileTitle : OffdockCYInvoiceManageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.16   
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.vo;

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

public class OffdockCYInvoiceManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OffdockCYInvoiceManageVO> models = new ArrayList<OffdockCYInvoiceManageVO>();
	
	/* Column Info */
	private String paramRvisCntrStyCd = null;
	/* Column Info */
	private String paramCntrTpszCd = null;
	/* Column Info */
	private String tmlIfSeq = null;
	/* Column Info */
	private String paramCntrNo = null;
	/* Column Info */
	private String calcCostGrpCd = null;
	/* Column Info */
	private String mode = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tmlCalcIndCd = null;
	/* Column Info */
	private String calcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tmlCostGrpCd = null;
	/* Column Info */
	private String delCntrSeq = null;
	/* Column Info */
	private String dtlByPoolOnlyMode = null;
	/* Column Info */
	private String tmlSoCntrListSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String coinCntrFlg = null;
	/* Column Info */
	private String wrkDt = null;
	/* Column Info */
	private String fmPrdDt = null;
	/* Column Info */
	private String tmlSoDtlSeq = null;
	/* Column Info */
	private String n3ptyFlg = null;
	/* Column Info */
	private String semiAutoCalcFlg = null;
	/* Column Info */
	private String dcgoClssCd = null;
	/* Column Info */
	private String paramLgsCostCd = null;
	/* Column Info */
	private String toPrdDt = null;
	/* Column Info */
	private String delIfSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String paramRcFlg = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String plugTerm = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String paramDcgoClssCd = null;
	/* Column Info */
	private String rfMntrDys = null;
	/* Column Info */
	private String paramRvisGateInOutCd = null;
	/* Column Info */
	private String tmlSoSeq = null;
	/* Column Info */
	private String invVolQty = null;
	/* Column Info */
	private String stoDysIndCd = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String paramRvisCntrTpszCd = null;
	/* Column Info */
	private String tmpDtlSeq = null;
	/* Column Info */
	private String tmlSoOfcCtyCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OffdockCYInvoiceManageVO() {}

	public OffdockCYInvoiceManageVO(String ibflag, String pagerows, String mode, String tmlSoOfcCtyCd, String tmlSoSeq, String tmlSoDtlSeq, String vndrSeq, String invNo, String calcTpCd, String dcgoClssCd, String cntrTpszCd, String rcFlg, String ioBndCd, String lgsCostCd, String tmlCostGrpCd, String tmlCalcIndCd, String paramCntrTpszCd, String paramDcgoClssCd, String paramRcFlg, String paramLgsCostCd, String fmPrdDt, String toPrdDt, String stoDysIndCd, String ydCd, String dtlByPoolOnlyMode, String invVolQty, String wrkDt, String tmpDtlSeq, String calcCostGrpCd, String tmlSoCntrListSeq, String tmlIfSeq, String n3ptyFlg, String delIfSeq, String delCntrSeq, String paramCntrNo, String paramRvisCntrTpszCd, String paramRvisCntrStyCd, String paramRvisGateInOutCd, String coinCntrFlg, String rfMntrDys, String plugTerm, String semiAutoCalcFlg) {
		this.paramRvisCntrStyCd = paramRvisCntrStyCd;
		this.paramCntrTpszCd = paramCntrTpszCd;
		this.tmlIfSeq = tmlIfSeq;
		this.paramCntrNo = paramCntrNo;
		this.calcCostGrpCd = calcCostGrpCd;
		this.mode = mode;
		this.pagerows = pagerows;
		this.tmlCalcIndCd = tmlCalcIndCd;
		this.calcTpCd = calcTpCd;
		this.ibflag = ibflag;
		this.tmlCostGrpCd = tmlCostGrpCd;
		this.delCntrSeq = delCntrSeq;
		this.dtlByPoolOnlyMode = dtlByPoolOnlyMode;
		this.tmlSoCntrListSeq = tmlSoCntrListSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.coinCntrFlg = coinCntrFlg;
		this.wrkDt = wrkDt;
		this.fmPrdDt = fmPrdDt;
		this.tmlSoDtlSeq = tmlSoDtlSeq;
		this.n3ptyFlg = n3ptyFlg;
		this.semiAutoCalcFlg = semiAutoCalcFlg;
		this.dcgoClssCd = dcgoClssCd;
		this.paramLgsCostCd = paramLgsCostCd;
		this.toPrdDt = toPrdDt;
		this.delIfSeq = delIfSeq;
		this.ioBndCd = ioBndCd;
		this.invNo = invNo;
		this.paramRcFlg = paramRcFlg;
		this.ydCd = ydCd;
		this.plugTerm = plugTerm;
		this.vndrSeq = vndrSeq;
		this.lgsCostCd = lgsCostCd;
		this.paramDcgoClssCd = paramDcgoClssCd;
		this.rfMntrDys = rfMntrDys;
		this.paramRvisGateInOutCd = paramRvisGateInOutCd;
		this.tmlSoSeq = tmlSoSeq;
		this.invVolQty = invVolQty;
		this.stoDysIndCd = stoDysIndCd;
		this.rcFlg = rcFlg;
		this.paramRvisCntrTpszCd = paramRvisCntrTpszCd;
		this.tmpDtlSeq = tmpDtlSeq;
		this.tmlSoOfcCtyCd = tmlSoOfcCtyCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("param_rvis_cntr_sty_cd", getParamRvisCntrStyCd());
		this.hashColumns.put("param_cntr_tpsz_cd", getParamCntrTpszCd());
		this.hashColumns.put("tml_if_seq", getTmlIfSeq());
		this.hashColumns.put("param_cntr_no", getParamCntrNo());
		this.hashColumns.put("calc_cost_grp_cd", getCalcCostGrpCd());
		this.hashColumns.put("mode", getMode());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tml_calc_ind_cd", getTmlCalcIndCd());
		this.hashColumns.put("calc_tp_cd", getCalcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tml_cost_grp_cd", getTmlCostGrpCd());
		this.hashColumns.put("del_cntr_seq", getDelCntrSeq());
		this.hashColumns.put("dtl_by_pool_only_mode", getDtlByPoolOnlyMode());
		this.hashColumns.put("tml_so_cntr_list_seq", getTmlSoCntrListSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("coin_cntr_flg", getCoinCntrFlg());
		this.hashColumns.put("wrk_dt", getWrkDt());
		this.hashColumns.put("fm_prd_dt", getFmPrdDt());
		this.hashColumns.put("tml_so_dtl_seq", getTmlSoDtlSeq());
		this.hashColumns.put("n3pty_flg", getN3ptyFlg());
		this.hashColumns.put("semi_auto_calc_flg", getSemiAutoCalcFlg());
		this.hashColumns.put("dcgo_clss_cd", getDcgoClssCd());
		this.hashColumns.put("param_lgs_cost_cd", getParamLgsCostCd());
		this.hashColumns.put("to_prd_dt", getToPrdDt());
		this.hashColumns.put("del_if_seq", getDelIfSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("param_rc_flg", getParamRcFlg());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("plug_term", getPlugTerm());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("param_dcgo_clss_cd", getParamDcgoClssCd());
		this.hashColumns.put("rf_mntr_dys", getRfMntrDys());
		this.hashColumns.put("param_rvis_gate_in_out_cd", getParamRvisGateInOutCd());
		this.hashColumns.put("tml_so_seq", getTmlSoSeq());
		this.hashColumns.put("inv_vol_qty", getInvVolQty());
		this.hashColumns.put("sto_dys_ind_cd", getStoDysIndCd());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("param_rvis_cntr_tpsz_cd", getParamRvisCntrTpszCd());
		this.hashColumns.put("tmp_dtl_seq", getTmpDtlSeq());
		this.hashColumns.put("tml_so_ofc_cty_cd", getTmlSoOfcCtyCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("param_rvis_cntr_sty_cd", "paramRvisCntrStyCd");
		this.hashFields.put("param_cntr_tpsz_cd", "paramCntrTpszCd");
		this.hashFields.put("tml_if_seq", "tmlIfSeq");
		this.hashFields.put("param_cntr_no", "paramCntrNo");
		this.hashFields.put("calc_cost_grp_cd", "calcCostGrpCd");
		this.hashFields.put("mode", "mode");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tml_calc_ind_cd", "tmlCalcIndCd");
		this.hashFields.put("calc_tp_cd", "calcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tml_cost_grp_cd", "tmlCostGrpCd");
		this.hashFields.put("del_cntr_seq", "delCntrSeq");
		this.hashFields.put("dtl_by_pool_only_mode", "dtlByPoolOnlyMode");
		this.hashFields.put("tml_so_cntr_list_seq", "tmlSoCntrListSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("coin_cntr_flg", "coinCntrFlg");
		this.hashFields.put("wrk_dt", "wrkDt");
		this.hashFields.put("fm_prd_dt", "fmPrdDt");
		this.hashFields.put("tml_so_dtl_seq", "tmlSoDtlSeq");
		this.hashFields.put("n3pty_flg", "n3ptyFlg");
		this.hashFields.put("semi_auto_calc_flg", "semiAutoCalcFlg");
		this.hashFields.put("dcgo_clss_cd", "dcgoClssCd");
		this.hashFields.put("param_lgs_cost_cd", "paramLgsCostCd");
		this.hashFields.put("to_prd_dt", "toPrdDt");
		this.hashFields.put("del_if_seq", "delIfSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("param_rc_flg", "paramRcFlg");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("plug_term", "plugTerm");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("param_dcgo_clss_cd", "paramDcgoClssCd");
		this.hashFields.put("rf_mntr_dys", "rfMntrDys");
		this.hashFields.put("param_rvis_gate_in_out_cd", "paramRvisGateInOutCd");
		this.hashFields.put("tml_so_seq", "tmlSoSeq");
		this.hashFields.put("inv_vol_qty", "invVolQty");
		this.hashFields.put("sto_dys_ind_cd", "stoDysIndCd");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("param_rvis_cntr_tpsz_cd", "paramRvisCntrTpszCd");
		this.hashFields.put("tmp_dtl_seq", "tmpDtlSeq");
		this.hashFields.put("tml_so_ofc_cty_cd", "tmlSoOfcCtyCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return paramRvisCntrStyCd
	 */
	public String getParamRvisCntrStyCd() {
		return this.paramRvisCntrStyCd;
	}
	
	/**
	 * Column Info
	 * @return paramCntrTpszCd
	 */
	public String getParamCntrTpszCd() {
		return this.paramCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return tmlIfSeq
	 */
	public String getTmlIfSeq() {
		return this.tmlIfSeq;
	}
	
	/**
	 * Column Info
	 * @return paramCntrNo
	 */
	public String getParamCntrNo() {
		return this.paramCntrNo;
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
	 * @return mode
	 */
	public String getMode() {
		return this.mode;
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
	 * @return tmlCalcIndCd
	 */
	public String getTmlCalcIndCd() {
		return this.tmlCalcIndCd;
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
	 * @return tmlCostGrpCd
	 */
	public String getTmlCostGrpCd() {
		return this.tmlCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @return delCntrSeq
	 */
	public String getDelCntrSeq() {
		return this.delCntrSeq;
	}
	
	/**
	 * Column Info
	 * @return dtlByPoolOnlyMode
	 */
	public String getDtlByPoolOnlyMode() {
		return this.dtlByPoolOnlyMode;
	}
	
	/**
	 * Column Info
	 * @return tmlSoCntrListSeq
	 */
	public String getTmlSoCntrListSeq() {
		return this.tmlSoCntrListSeq;
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
	 * @return coinCntrFlg
	 */
	public String getCoinCntrFlg() {
		return this.coinCntrFlg;
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
	 * @return fmPrdDt
	 */
	public String getFmPrdDt() {
		return this.fmPrdDt;
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
	 * @return n3ptyFlg
	 */
	public String getN3ptyFlg() {
		return this.n3ptyFlg;
	}
	
	/**
	 * Column Info
	 * @return semiAutoCalcFlg
	 */
	public String getSemiAutoCalcFlg() {
		return this.semiAutoCalcFlg;
	}
	
	/**
	 * Column Info
	 * @return dcgoClssCd
	 */
	public String getDcgoClssCd() {
		return this.dcgoClssCd;
	}
	
	/**
	 * Column Info
	 * @return paramLgsCostCd
	 */
	public String getParamLgsCostCd() {
		return this.paramLgsCostCd;
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
	 * @return delIfSeq
	 */
	public String getDelIfSeq() {
		return this.delIfSeq;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return paramRcFlg
	 */
	public String getParamRcFlg() {
		return this.paramRcFlg;
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
	 * @return plugTerm
	 */
	public String getPlugTerm() {
		return this.plugTerm;
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
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return paramDcgoClssCd
	 */
	public String getParamDcgoClssCd() {
		return this.paramDcgoClssCd;
	}
	
	/**
	 * Column Info
	 * @return rfMntrDys
	 */
	public String getRfMntrDys() {
		return this.rfMntrDys;
	}
	
	/**
	 * Column Info
	 * @return paramRvisGateInOutCd
	 */
	public String getParamRvisGateInOutCd() {
		return this.paramRvisGateInOutCd;
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
	 * @return invVolQty
	 */
	public String getInvVolQty() {
		return this.invVolQty;
	}
	
	/**
	 * Column Info
	 * @return stoDysIndCd
	 */
	public String getStoDysIndCd() {
		return this.stoDysIndCd;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return paramRvisCntrTpszCd
	 */
	public String getParamRvisCntrTpszCd() {
		return this.paramRvisCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return tmpDtlSeq
	 */
	public String getTmpDtlSeq() {
		return this.tmpDtlSeq;
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
	 * @param paramRvisCntrStyCd
	 */
	public void setParamRvisCntrStyCd(String paramRvisCntrStyCd) {
		this.paramRvisCntrStyCd = paramRvisCntrStyCd;
	}
	
	/**
	 * Column Info
	 * @param paramCntrTpszCd
	 */
	public void setParamCntrTpszCd(String paramCntrTpszCd) {
		this.paramCntrTpszCd = paramCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param tmlIfSeq
	 */
	public void setTmlIfSeq(String tmlIfSeq) {
		this.tmlIfSeq = tmlIfSeq;
	}
	
	/**
	 * Column Info
	 * @param paramCntrNo
	 */
	public void setParamCntrNo(String paramCntrNo) {
		this.paramCntrNo = paramCntrNo;
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
	 * @param mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
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
	 * @param tmlCalcIndCd
	 */
	public void setTmlCalcIndCd(String tmlCalcIndCd) {
		this.tmlCalcIndCd = tmlCalcIndCd;
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
	 * @param tmlCostGrpCd
	 */
	public void setTmlCostGrpCd(String tmlCostGrpCd) {
		this.tmlCostGrpCd = tmlCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @param delCntrSeq
	 */
	public void setDelCntrSeq(String delCntrSeq) {
		this.delCntrSeq = delCntrSeq;
	}
	
	/**
	 * Column Info
	 * @param dtlByPoolOnlyMode
	 */
	public void setDtlByPoolOnlyMode(String dtlByPoolOnlyMode) {
		this.dtlByPoolOnlyMode = dtlByPoolOnlyMode;
	}
	
	/**
	 * Column Info
	 * @param tmlSoCntrListSeq
	 */
	public void setTmlSoCntrListSeq(String tmlSoCntrListSeq) {
		this.tmlSoCntrListSeq = tmlSoCntrListSeq;
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
	 * @param coinCntrFlg
	 */
	public void setCoinCntrFlg(String coinCntrFlg) {
		this.coinCntrFlg = coinCntrFlg;
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
	 * @param fmPrdDt
	 */
	public void setFmPrdDt(String fmPrdDt) {
		this.fmPrdDt = fmPrdDt;
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
	 * @param n3ptyFlg
	 */
	public void setN3ptyFlg(String n3ptyFlg) {
		this.n3ptyFlg = n3ptyFlg;
	}
	
	/**
	 * Column Info
	 * @param semiAutoCalcFlg
	 */
	public void setSemiAutoCalcFlg(String semiAutoCalcFlg) {
		this.semiAutoCalcFlg = semiAutoCalcFlg;
	}
	
	/**
	 * Column Info
	 * @param dcgoClssCd
	 */
	public void setDcgoClssCd(String dcgoClssCd) {
		this.dcgoClssCd = dcgoClssCd;
	}
	
	/**
	 * Column Info
	 * @param paramLgsCostCd
	 */
	public void setParamLgsCostCd(String paramLgsCostCd) {
		this.paramLgsCostCd = paramLgsCostCd;
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
	 * @param delIfSeq
	 */
	public void setDelIfSeq(String delIfSeq) {
		this.delIfSeq = delIfSeq;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param paramRcFlg
	 */
	public void setParamRcFlg(String paramRcFlg) {
		this.paramRcFlg = paramRcFlg;
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
	 * @param plugTerm
	 */
	public void setPlugTerm(String plugTerm) {
		this.plugTerm = plugTerm;
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
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param paramDcgoClssCd
	 */
	public void setParamDcgoClssCd(String paramDcgoClssCd) {
		this.paramDcgoClssCd = paramDcgoClssCd;
	}
	
	/**
	 * Column Info
	 * @param rfMntrDys
	 */
	public void setRfMntrDys(String rfMntrDys) {
		this.rfMntrDys = rfMntrDys;
	}
	
	/**
	 * Column Info
	 * @param paramRvisGateInOutCd
	 */
	public void setParamRvisGateInOutCd(String paramRvisGateInOutCd) {
		this.paramRvisGateInOutCd = paramRvisGateInOutCd;
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
	 * @param invVolQty
	 */
	public void setInvVolQty(String invVolQty) {
		this.invVolQty = invVolQty;
	}
	
	/**
	 * Column Info
	 * @param stoDysIndCd
	 */
	public void setStoDysIndCd(String stoDysIndCd) {
		this.stoDysIndCd = stoDysIndCd;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param paramRvisCntrTpszCd
	 */
	public void setParamRvisCntrTpszCd(String paramRvisCntrTpszCd) {
		this.paramRvisCntrTpszCd = paramRvisCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param tmpDtlSeq
	 */
	public void setTmpDtlSeq(String tmpDtlSeq) {
		this.tmpDtlSeq = tmpDtlSeq;
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
		setParamRvisCntrStyCd(JSPUtil.getParameter(request, prefix + "param_rvis_cntr_sty_cd", ""));
		setParamCntrTpszCd(JSPUtil.getParameter(request, prefix + "param_cntr_tpsz_cd", ""));
		setTmlIfSeq(JSPUtil.getParameter(request, prefix + "tml_if_seq", ""));
		setParamCntrNo(JSPUtil.getParameter(request, prefix + "param_cntr_no", ""));
		setCalcCostGrpCd(JSPUtil.getParameter(request, prefix + "calc_cost_grp_cd", ""));
		setMode(JSPUtil.getParameter(request, prefix + "mode", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTmlCalcIndCd(JSPUtil.getParameter(request, prefix + "tml_calc_ind_cd", ""));
		setCalcTpCd(JSPUtil.getParameter(request, prefix + "calc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTmlCostGrpCd(JSPUtil.getParameter(request, prefix + "tml_cost_grp_cd", ""));
		setDelCntrSeq(JSPUtil.getParameter(request, prefix + "del_cntr_seq", ""));
		setDtlByPoolOnlyMode(JSPUtil.getParameter(request, prefix + "dtl_by_pool_only_mode", ""));
		setTmlSoCntrListSeq(JSPUtil.getParameter(request, prefix + "tml_so_cntr_list_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCoinCntrFlg(JSPUtil.getParameter(request, prefix + "coin_cntr_flg", ""));
		setWrkDt(JSPUtil.getParameter(request, prefix + "wrk_dt", ""));
		setFmPrdDt(JSPUtil.getParameter(request, prefix + "fm_prd_dt", ""));
		setTmlSoDtlSeq(JSPUtil.getParameter(request, prefix + "tml_so_dtl_seq", ""));
		setN3ptyFlg(JSPUtil.getParameter(request, prefix + "n3pty_flg", ""));
		setSemiAutoCalcFlg(JSPUtil.getParameter(request, prefix + "semi_auto_calc_flg", ""));
		setDcgoClssCd(JSPUtil.getParameter(request, prefix + "dcgo_clss_cd", ""));
		setParamLgsCostCd(JSPUtil.getParameter(request, prefix + "param_lgs_cost_cd", ""));
		setToPrdDt(JSPUtil.getParameter(request, prefix + "to_prd_dt", ""));
		setDelIfSeq(JSPUtil.getParameter(request, prefix + "del_if_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setParamRcFlg(JSPUtil.getParameter(request, prefix + "param_rc_flg", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setPlugTerm(JSPUtil.getParameter(request, prefix + "plug_term", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setParamDcgoClssCd(JSPUtil.getParameter(request, prefix + "param_dcgo_clss_cd", ""));
		setRfMntrDys(JSPUtil.getParameter(request, prefix + "rf_mntr_dys", ""));
		setParamRvisGateInOutCd(JSPUtil.getParameter(request, prefix + "param_rvis_gate_in_out_cd", ""));
		setTmlSoSeq(JSPUtil.getParameter(request, prefix + "tml_so_seq", ""));
		setInvVolQty(JSPUtil.getParameter(request, prefix + "inv_vol_qty", ""));
		setStoDysIndCd(JSPUtil.getParameter(request, prefix + "sto_dys_ind_cd", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setParamRvisCntrTpszCd(JSPUtil.getParameter(request, prefix + "param_rvis_cntr_tpsz_cd", ""));
		setTmpDtlSeq(JSPUtil.getParameter(request, prefix + "tmp_dtl_seq", ""));
		setTmlSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "tml_so_ofc_cty_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OffdockCYInvoiceManageVO[]
	 */
	public OffdockCYInvoiceManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OffdockCYInvoiceManageVO[]
	 */
	public OffdockCYInvoiceManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OffdockCYInvoiceManageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] paramRvisCntrStyCd = (JSPUtil.getParameter(request, prefix	+ "param_rvis_cntr_sty_cd", length));
			String[] paramCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "param_cntr_tpsz_cd", length));
			String[] tmlIfSeq = (JSPUtil.getParameter(request, prefix	+ "tml_if_seq", length));
			String[] paramCntrNo = (JSPUtil.getParameter(request, prefix	+ "param_cntr_no", length));
			String[] calcCostGrpCd = (JSPUtil.getParameter(request, prefix	+ "calc_cost_grp_cd", length));
			String[] mode = (JSPUtil.getParameter(request, prefix	+ "mode", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tmlCalcIndCd = (JSPUtil.getParameter(request, prefix	+ "tml_calc_ind_cd", length));
			String[] calcTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tmlCostGrpCd = (JSPUtil.getParameter(request, prefix	+ "tml_cost_grp_cd", length));
			String[] delCntrSeq = (JSPUtil.getParameter(request, prefix	+ "del_cntr_seq", length));
			String[] dtlByPoolOnlyMode = (JSPUtil.getParameter(request, prefix	+ "dtl_by_pool_only_mode", length));
			String[] tmlSoCntrListSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_cntr_list_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] coinCntrFlg = (JSPUtil.getParameter(request, prefix	+ "coin_cntr_flg", length));
			String[] wrkDt = (JSPUtil.getParameter(request, prefix	+ "wrk_dt", length));
			String[] fmPrdDt = (JSPUtil.getParameter(request, prefix	+ "fm_prd_dt", length));
			String[] tmlSoDtlSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_dtl_seq", length));
			String[] n3ptyFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_flg", length));
			String[] semiAutoCalcFlg = (JSPUtil.getParameter(request, prefix	+ "semi_auto_calc_flg", length));
			String[] dcgoClssCd = (JSPUtil.getParameter(request, prefix	+ "dcgo_clss_cd", length));
			String[] paramLgsCostCd = (JSPUtil.getParameter(request, prefix	+ "param_lgs_cost_cd", length));
			String[] toPrdDt = (JSPUtil.getParameter(request, prefix	+ "to_prd_dt", length));
			String[] delIfSeq = (JSPUtil.getParameter(request, prefix	+ "del_if_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] paramRcFlg = (JSPUtil.getParameter(request, prefix	+ "param_rc_flg", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] plugTerm = (JSPUtil.getParameter(request, prefix	+ "plug_term", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] paramDcgoClssCd = (JSPUtil.getParameter(request, prefix	+ "param_dcgo_clss_cd", length));
			String[] rfMntrDys = (JSPUtil.getParameter(request, prefix	+ "rf_mntr_dys", length));
			String[] paramRvisGateInOutCd = (JSPUtil.getParameter(request, prefix	+ "param_rvis_gate_in_out_cd", length));
			String[] tmlSoSeq = (JSPUtil.getParameter(request, prefix	+ "tml_so_seq", length));
			String[] invVolQty = (JSPUtil.getParameter(request, prefix	+ "inv_vol_qty", length));
			String[] stoDysIndCd = (JSPUtil.getParameter(request, prefix	+ "sto_dys_ind_cd", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] paramRvisCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "param_rvis_cntr_tpsz_cd", length));
			String[] tmpDtlSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_dtl_seq", length));
			String[] tmlSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "tml_so_ofc_cty_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new OffdockCYInvoiceManageVO();
				if (paramRvisCntrStyCd[i] != null)
					model.setParamRvisCntrStyCd(paramRvisCntrStyCd[i]);
				if (paramCntrTpszCd[i] != null)
					model.setParamCntrTpszCd(paramCntrTpszCd[i]);
				if (tmlIfSeq[i] != null)
					model.setTmlIfSeq(tmlIfSeq[i]);
				if (paramCntrNo[i] != null)
					model.setParamCntrNo(paramCntrNo[i]);
				if (calcCostGrpCd[i] != null)
					model.setCalcCostGrpCd(calcCostGrpCd[i]);
				if (mode[i] != null)
					model.setMode(mode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tmlCalcIndCd[i] != null)
					model.setTmlCalcIndCd(tmlCalcIndCd[i]);
				if (calcTpCd[i] != null)
					model.setCalcTpCd(calcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tmlCostGrpCd[i] != null)
					model.setTmlCostGrpCd(tmlCostGrpCd[i]);
				if (delCntrSeq[i] != null)
					model.setDelCntrSeq(delCntrSeq[i]);
				if (dtlByPoolOnlyMode[i] != null)
					model.setDtlByPoolOnlyMode(dtlByPoolOnlyMode[i]);
				if (tmlSoCntrListSeq[i] != null)
					model.setTmlSoCntrListSeq(tmlSoCntrListSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (coinCntrFlg[i] != null)
					model.setCoinCntrFlg(coinCntrFlg[i]);
				if (wrkDt[i] != null)
					model.setWrkDt(wrkDt[i]);
				if (fmPrdDt[i] != null)
					model.setFmPrdDt(fmPrdDt[i]);
				if (tmlSoDtlSeq[i] != null)
					model.setTmlSoDtlSeq(tmlSoDtlSeq[i]);
				if (n3ptyFlg[i] != null)
					model.setN3ptyFlg(n3ptyFlg[i]);
				if (semiAutoCalcFlg[i] != null)
					model.setSemiAutoCalcFlg(semiAutoCalcFlg[i]);
				if (dcgoClssCd[i] != null)
					model.setDcgoClssCd(dcgoClssCd[i]);
				if (paramLgsCostCd[i] != null)
					model.setParamLgsCostCd(paramLgsCostCd[i]);
				if (toPrdDt[i] != null)
					model.setToPrdDt(toPrdDt[i]);
				if (delIfSeq[i] != null)
					model.setDelIfSeq(delIfSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (paramRcFlg[i] != null)
					model.setParamRcFlg(paramRcFlg[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (plugTerm[i] != null)
					model.setPlugTerm(plugTerm[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (paramDcgoClssCd[i] != null)
					model.setParamDcgoClssCd(paramDcgoClssCd[i]);
				if (rfMntrDys[i] != null)
					model.setRfMntrDys(rfMntrDys[i]);
				if (paramRvisGateInOutCd[i] != null)
					model.setParamRvisGateInOutCd(paramRvisGateInOutCd[i]);
				if (tmlSoSeq[i] != null)
					model.setTmlSoSeq(tmlSoSeq[i]);
				if (invVolQty[i] != null)
					model.setInvVolQty(invVolQty[i]);
				if (stoDysIndCd[i] != null)
					model.setStoDysIndCd(stoDysIndCd[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (paramRvisCntrTpszCd[i] != null)
					model.setParamRvisCntrTpszCd(paramRvisCntrTpszCd[i]);
				if (tmpDtlSeq[i] != null)
					model.setTmpDtlSeq(tmpDtlSeq[i]);
				if (tmlSoOfcCtyCd[i] != null)
					model.setTmlSoOfcCtyCd(tmlSoOfcCtyCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOffdockCYInvoiceManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OffdockCYInvoiceManageVO[]
	 */
	public OffdockCYInvoiceManageVO[] getOffdockCYInvoiceManageVOs(){
		OffdockCYInvoiceManageVO[] vos = (OffdockCYInvoiceManageVO[])models.toArray(new OffdockCYInvoiceManageVO[models.size()]);
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
		this.paramRvisCntrStyCd = this.paramRvisCntrStyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paramCntrTpszCd = this.paramCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlIfSeq = this.tmlIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paramCntrNo = this.paramCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcCostGrpCd = this.calcCostGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mode = this.mode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCalcIndCd = this.tmlCalcIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTpCd = this.calcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCostGrpCd = this.tmlCostGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntrSeq = this.delCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlByPoolOnlyMode = this.dtlByPoolOnlyMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoCntrListSeq = this.tmlSoCntrListSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coinCntrFlg = this.coinCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrkDt = this.wrkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrdDt = this.fmPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoDtlSeq = this.tmlSoDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyFlg = this.n3ptyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.semiAutoCalcFlg = this.semiAutoCalcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoClssCd = this.dcgoClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paramLgsCostCd = this.paramLgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrdDt = this.toPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delIfSeq = this.delIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paramRcFlg = this.paramRcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plugTerm = this.plugTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paramDcgoClssCd = this.paramDcgoClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMntrDys = this.rfMntrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paramRvisGateInOutCd = this.paramRvisGateInOutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoSeq = this.tmlSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVolQty = this.invVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoDysIndCd = this.stoDysIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paramRvisCntrTpszCd = this.paramRvisCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpDtlSeq = this.tmpDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoOfcCtyCd = this.tmlSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
