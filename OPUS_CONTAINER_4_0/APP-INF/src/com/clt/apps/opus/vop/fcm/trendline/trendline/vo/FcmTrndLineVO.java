/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FcmTrndLineVO.java
*@FileTitle : FcmTrndLineVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.25 진마리아 
* 1.0 Creation
* 
* History
* 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
=========================================================*/

package com.clt.apps.opus.vop.fcm.trendline.trendline.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FcmTrndLineVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmTrndLineVO> models = new ArrayList<FcmTrndLineVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String trndLineTpCd = null;
	/* Column Info */
	private String fomlDesc = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trndLineRmk = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String trndLineFmDt = null;
	/* Column Info */
	private String n2ndCoefVal = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String coefOfDtmnVal = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String opMinSpd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n2ndVarDgrVal = null;
	/* Column Info */
	private String trndLineConsVal = null;
	/* Column Info */
	private String avgBlrCsmWgt = null;
	/* Column Info */
	private String opMaxSpd = null;
	/* Column Info */
	private String trndLineToDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vslClssCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String trndLineSeq = null;
	/* Column Info */
	private String n1stVarDgrVal = null;
	/* Column Info */
	private String trndLineChtTpCd = null;
	/* Column Info */
	private String avgGnrCsmWgt = null;
	/* Column Info */
	private String n1stCoefVal = null;
	/* Column Info */
	private String vslClssSubCd = null;
	/* Column Info */
	private String trndLineTpSubCd = null;
	/* Column Info */
	private String noonRptDt = null;
	/* Column Info */
	private String trndLineNo = null;
	/* Column Info */
	private String trndLineUseTpCd = null;
	/* Column Info */
	private String avgSlpRt = null;
	/* Column Info */
	private String avgSlpOptRt = null;
	/* Column Info */
	private String aplySlpRt = null;
	/* Column Info */
	private String cntrDznCapa = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FcmTrndLineVO() {}

	public FcmTrndLineVO(String ibflag, String pagerows, String trndLineTpCd, String trndLineSeq, String trndLineChtTpCd, String trndLineFmDt, String trndLineToDt, String vslCd, String vslClssCd, String vslSlanCd, String skdDirCd, String n1stCoefVal, String n1stVarDgrVal, String n2ndCoefVal, String n2ndVarDgrVal, String trndLineConsVal, String coefOfDtmnVal, String fomlDesc, String avgGnrCsmWgt, String avgBlrCsmWgt, String opMaxSpd, String opMinSpd, String trndLineRmk, String creUsrId, String creDt, String updUsrId, String updDt, String vslClssSubCd, String trndLineTpSubCd, String noonRptDt, String trndLineNo, String trndLineUseTpCd, String avgSlpRt, String avgSlpOptRt, String aplySlpRt, String cntrDznCapa) {
		this.vslCd = vslCd;
		this.trndLineTpCd = trndLineTpCd;
		this.fomlDesc = fomlDesc;
		this.creDt = creDt;
		this.trndLineRmk = trndLineRmk;
		this.vslSlanCd = vslSlanCd;
		this.trndLineFmDt = trndLineFmDt;
		this.n2ndCoefVal = n2ndCoefVal;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.coefOfDtmnVal = coefOfDtmnVal;
		this.updUsrId = updUsrId;
		this.opMinSpd = opMinSpd;
		this.updDt = updDt;
		this.n2ndVarDgrVal = n2ndVarDgrVal;
		this.trndLineConsVal = trndLineConsVal;
		this.avgBlrCsmWgt = avgBlrCsmWgt;
		this.opMaxSpd = opMaxSpd;
		this.trndLineToDt = trndLineToDt;
		this.skdDirCd = skdDirCd;
		this.vslClssCd = vslClssCd;
		this.creUsrId = creUsrId;
		this.trndLineSeq = trndLineSeq;
		this.n1stVarDgrVal = n1stVarDgrVal;
		this.trndLineChtTpCd = trndLineChtTpCd;
		this.avgGnrCsmWgt = avgGnrCsmWgt;
		this.n1stCoefVal = n1stCoefVal;
		this.vslClssSubCd = vslClssSubCd;
		this.trndLineTpSubCd = trndLineTpSubCd;
		this.noonRptDt = noonRptDt;
		this.trndLineNo = trndLineNo;
		this.trndLineUseTpCd = trndLineUseTpCd;
		this.avgSlpRt = avgSlpRt;
		this.avgSlpOptRt = avgSlpOptRt;
		this.aplySlpRt = aplySlpRt;
		this.cntrDznCapa = cntrDznCapa;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("trnd_line_tp_cd", getTrndLineTpCd());
		this.hashColumns.put("foml_desc", getFomlDesc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trnd_line_rmk", getTrndLineRmk());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("trnd_line_fm_dt", getTrndLineFmDt());
		this.hashColumns.put("n2nd_coef_val", getN2ndCoefVal());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("coef_of_dtmn_val", getCoefOfDtmnVal());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("op_min_spd", getOpMinSpd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n2nd_var_dgr_val", getN2ndVarDgrVal());
		this.hashColumns.put("trnd_line_cons_val", getTrndLineConsVal());
		this.hashColumns.put("avg_blr_csm_wgt", getAvgBlrCsmWgt());
		this.hashColumns.put("op_max_spd", getOpMaxSpd());
		this.hashColumns.put("trnd_line_to_dt", getTrndLineToDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vsl_clss_cd", getVslClssCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("trnd_line_seq", getTrndLineSeq());
		this.hashColumns.put("n1st_var_dgr_val", getN1stVarDgrVal());
		this.hashColumns.put("trnd_line_cht_tp_cd", getTrndLineChtTpCd());
		this.hashColumns.put("avg_gnr_csm_wgt", getAvgGnrCsmWgt());
		this.hashColumns.put("n1st_coef_val", getN1stCoefVal());
		this.hashColumns.put("vsl_clss_sub_cd", getVslClssSubCd());
		this.hashColumns.put("trnd_line_tp_sub_cd", getTrndLineTpSubCd());
		this.hashColumns.put("noon_rpt_dt", getNoonRptDt());
		this.hashColumns.put("trnd_line_no", getTrndLineNo());
		this.hashColumns.put("trnd_line_use_tp_cd", getTrndLineUseTpCd());
		this.hashColumns.put("avg_slp_rt", getAvgSlpRt());
		this.hashColumns.put("avg_slp_opt_rt", getAvgSlpOptRt());
		this.hashColumns.put("aply_slp_rt", getAplySlpRt());
		this.hashColumns.put("cntr_dzn_capa", getCntrDznCapa());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("trnd_line_tp_cd", "trndLineTpCd");
		this.hashFields.put("foml_desc", "fomlDesc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trnd_line_rmk", "trndLineRmk");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("trnd_line_fm_dt", "trndLineFmDt");
		this.hashFields.put("n2nd_coef_val", "n2ndCoefVal");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("coef_of_dtmn_val", "coefOfDtmnVal");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("op_min_spd", "opMinSpd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n2nd_var_dgr_val", "n2ndVarDgrVal");
		this.hashFields.put("trnd_line_cons_val", "trndLineConsVal");
		this.hashFields.put("avg_blr_csm_wgt", "avgBlrCsmWgt");
		this.hashFields.put("op_max_spd", "opMaxSpd");
		this.hashFields.put("trnd_line_to_dt", "trndLineToDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vsl_clss_cd", "vslClssCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("trnd_line_seq", "trndLineSeq");
		this.hashFields.put("n1st_var_dgr_val", "n1stVarDgrVal");
		this.hashFields.put("trnd_line_cht_tp_cd", "trndLineChtTpCd");
		this.hashFields.put("avg_gnr_csm_wgt", "avgGnrCsmWgt");
		this.hashFields.put("n1st_coef_val", "n1stCoefVal");
		this.hashFields.put("vsl_clss_sub_cd", "vslClssSubCd");
		this.hashFields.put("trnd_line_tp_sub_cd", "trndLineTpSubCd");
		this.hashFields.put("noon_rpt_dt", "noonRptDt");
		this.hashFields.put("trnd_line_no", "trndLineNo");
		this.hashFields.put("trnd_line_use_tp_cd", "trndLineUseTpCd");
		this.hashFields.put("avg_slp_rt", "avgSlpRt");
		this.hashFields.put("avg_slp_opt_rt", "avgSlpOptRt");
		this.hashFields.put("aply_slp_rt", "aplySlpRt");
		this.hashFields.put("cntr_dzn_capa", "cntrDznCapa");
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
	 * @return trndLineTpCd
	 */
	public String getTrndLineTpCd() {
		return this.trndLineTpCd;
	}
	
	/**
	 * Column Info
	 * @return fomlDesc
	 */
	public String getFomlDesc() {
		return this.fomlDesc;
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
	 * @return trndLineRmk
	 */
	public String getTrndLineRmk() {
		return this.trndLineRmk;
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
	 * @return trndLineFmDt
	 */
	public String getTrndLineFmDt() {
		return this.trndLineFmDt;
	}
	
	/**
	 * Column Info
	 * @return n2ndCoefVal
	 */
	public String getN2ndCoefVal() {
		return this.n2ndCoefVal;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return coefOfDtmnVal
	 */
	public String getCoefOfDtmnVal() {
		return this.coefOfDtmnVal;
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
	 * @return opMinSpd
	 */
	public String getOpMinSpd() {
		return this.opMinSpd;
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
	 * @return n2ndVarDgrVal
	 */
	public String getN2ndVarDgrVal() {
		return this.n2ndVarDgrVal;
	}
	
	/**
	 * Column Info
	 * @return trndLineConsVal
	 */
	public String getTrndLineConsVal() {
		return this.trndLineConsVal;
	}
	
	/**
	 * Column Info
	 * @return avgBlrCsmWgt
	 */
	public String getAvgBlrCsmWgt() {
		return this.avgBlrCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return opMaxSpd
	 */
	public String getOpMaxSpd() {
		return this.opMaxSpd;
	}
	
	/**
	 * Column Info
	 * @return trndLineToDt
	 */
	public String getTrndLineToDt() {
		return this.trndLineToDt;
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
	 * @return vslClssCd
	 */
	public String getVslClssCd() {
		return this.vslClssCd;
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
	 * @return trndLineSeq
	 */
	public String getTrndLineSeq() {
		return this.trndLineSeq;
	}
	
	/**
	 * Column Info
	 * @return n1stVarDgrVal
	 */
	public String getN1stVarDgrVal() {
		return this.n1stVarDgrVal;
	}
	
	/**
	 * Column Info
	 * @return trndLineChtTpCd
	 */
	public String getTrndLineChtTpCd() {
		return this.trndLineChtTpCd;
	}
	
	/**
	 * Column Info
	 * @return avgGnrCsmWgt
	 */
	public String getAvgGnrCsmWgt() {
		return this.avgGnrCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return n1stCoefVal
	 */
	public String getN1stCoefVal() {
		return this.n1stCoefVal;
	}
	
	/**
	 * Column Info
	 * @return vslClssSubCd
	 */
	public String getVslClssSubCd() {
		return this.vslClssSubCd;
	}
	
	/**
	 * Column Info
	 * @return trndLineTpSubCd
	 */
	public String getTrndLineTpSubCd() {
		return this.trndLineTpSubCd;
	}
	
	/**
	 * Column Info
	 * @return noonRptDt
	 */
	public String getNoonRptDt() {
		return this.noonRptDt;
	}
	
	/**
	 * Column Info
	 * @return trndLineNo
	 */
	public String getTrndLineNo() {
		return this.trndLineNo;
	}
	
	/**
	 * Column Info
	 * @return trndLineUseTpCd
	 */
	public String getTrndLineUseTpCd() {
		return this.trndLineUseTpCd;
	}
	
	/**
	 * Column Info
	 * @return avgSlpRt
	 */
	public String getAvgSlpRt() {
		return this.avgSlpRt;
	}
	
	/**
	 * Column Info
	 * @return avgSlpOptRt
	 */
	public String getAvgSlpOptRt() {
		return this.avgSlpOptRt;
	}
	
	/**
	 * Column Info
	 * @return aplySlpRt
	 */
	public String getAplySlpRt() {
		return this.aplySlpRt;
	}
	
	/**
	 * Column Info
	 * @return cntrDznCapa
	 */
	public String getCntrDznCapa() {
		return this.cntrDznCapa;
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
	 * @param trndLineTpCd
	 */
	public void setTrndLineTpCd(String trndLineTpCd) {
		this.trndLineTpCd = trndLineTpCd;
	}
	
	/**
	 * Column Info
	 * @param fomlDesc
	 */
	public void setFomlDesc(String fomlDesc) {
		this.fomlDesc = fomlDesc;
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
	 * @param trndLineRmk
	 */
	public void setTrndLineRmk(String trndLineRmk) {
		this.trndLineRmk = trndLineRmk;
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
	 * @param trndLineFmDt
	 */
	public void setTrndLineFmDt(String trndLineFmDt) {
		this.trndLineFmDt = trndLineFmDt;
	}
	
	/**
	 * Column Info
	 * @param n2ndCoefVal
	 */
	public void setN2ndCoefVal(String n2ndCoefVal) {
		this.n2ndCoefVal = n2ndCoefVal;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param coefOfDtmnVal
	 */
	public void setCoefOfDtmnVal(String coefOfDtmnVal) {
		this.coefOfDtmnVal = coefOfDtmnVal;
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
	 * @param opMinSpd
	 */
	public void setOpMinSpd(String opMinSpd) {
		this.opMinSpd = opMinSpd;
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
	 * @param n2ndVarDgrVal
	 */
	public void setN2ndVarDgrVal(String n2ndVarDgrVal) {
		this.n2ndVarDgrVal = n2ndVarDgrVal;
	}
	
	/**
	 * Column Info
	 * @param trndLineConsVal
	 */
	public void setTrndLineConsVal(String trndLineConsVal) {
		this.trndLineConsVal = trndLineConsVal;
	}
	
	/**
	 * Column Info
	 * @param avgBlrCsmWgt
	 */
	public void setAvgBlrCsmWgt(String avgBlrCsmWgt) {
		this.avgBlrCsmWgt = avgBlrCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param opMaxSpd
	 */
	public void setOpMaxSpd(String opMaxSpd) {
		this.opMaxSpd = opMaxSpd;
	}
	
	/**
	 * Column Info
	 * @param trndLineToDt
	 */
	public void setTrndLineToDt(String trndLineToDt) {
		this.trndLineToDt = trndLineToDt;
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
	 * @param vslClssCd
	 */
	public void setVslClssCd(String vslClssCd) {
		this.vslClssCd = vslClssCd;
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
	 * @param trndLineSeq
	 */
	public void setTrndLineSeq(String trndLineSeq) {
		this.trndLineSeq = trndLineSeq;
	}
	
	/**
	 * Column Info
	 * @param n1stVarDgrVal
	 */
	public void setN1stVarDgrVal(String n1stVarDgrVal) {
		this.n1stVarDgrVal = n1stVarDgrVal;
	}
	
	/**
	 * Column Info
	 * @param trndLineChtTpCd
	 */
	public void setTrndLineChtTpCd(String trndLineChtTpCd) {
		this.trndLineChtTpCd = trndLineChtTpCd;
	}
	
	/**
	 * Column Info
	 * @param avgGnrCsmWgt
	 */
	public void setAvgGnrCsmWgt(String avgGnrCsmWgt) {
		this.avgGnrCsmWgt = avgGnrCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param n1stCoefVal
	 */
	public void setN1stCoefVal(String n1stCoefVal) {
		this.n1stCoefVal = n1stCoefVal;
	}
	
	/**
	 * Column Info
	 * @param vslClssSubCd
	 */
	public void setVslClssSubCd(String vslClssSubCd) {
		this.vslClssSubCd = vslClssSubCd;
	}
	
	/**
	 * Column Info
	 * @param trndLineTpSubCd
	 */
	public void setTrndLineTpSubCd(String trndLineTpSubCd) {
		this.trndLineTpSubCd = trndLineTpSubCd;
	}
	
	/**
	 * Column Info
	 * @param noonRptDt
	 */
	public void setNoonRptDt(String noonRptDt) {
		this.noonRptDt = noonRptDt;
	}
	
	/**
	 * Column Info
	 * @param trndLineNo
	 */
	public void setTrndLineNo(String trndLineNo) {
		this.trndLineNo = trndLineNo;
	}
	
	/**
	 * Column Info
	 * @param trndLineUseTpCd
	 */
	public void setTrndLineUseTpCd(String trndLineUseTpCd) {
		this.trndLineUseTpCd = trndLineUseTpCd;
	}
	
	/**
	 * Column Info
	 * @param avgSlpRt
	 */
	public void setAvgSlpRt(String avgSlpRt) {
		this.avgSlpRt = avgSlpRt;
	}
	
	/**
	 * Column Info
	 * @param avgSlpOptRt
	 */
	public void setAvgSlpOptRt(String avgSlpOptRt) {
		this.avgSlpOptRt = avgSlpOptRt;
	}
	
	/**
	 * Column Info
	 * @param aplySlpRt
	 */
	public void setAplySlpRt(String aplySlpRt) {
		this.aplySlpRt = aplySlpRt;
	}
	
	/**
	 * Column Info
	 * @param cntrDznCapa
	 */
	public void setCntrDznCapa(String cntrDznCapa) {
		this.cntrDznCapa = cntrDznCapa;
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
		setTrndLineTpCd(JSPUtil.getParameter(request, prefix + "trnd_line_tp_cd", ""));
		setFomlDesc(JSPUtil.getParameter(request, prefix + "foml_desc", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrndLineRmk(JSPUtil.getParameter(request, prefix + "trnd_line_rmk", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setTrndLineFmDt(JSPUtil.getParameter(request, prefix + "trnd_line_fm_dt", ""));
		setN2ndCoefVal(JSPUtil.getParameter(request, prefix + "n2nd_coef_val", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCoefOfDtmnVal(JSPUtil.getParameter(request, prefix + "coef_of_dtmn_val", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOpMinSpd(JSPUtil.getParameter(request, prefix + "op_min_spd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setN2ndVarDgrVal(JSPUtil.getParameter(request, prefix + "n2nd_var_dgr_val", ""));
		setTrndLineConsVal(JSPUtil.getParameter(request, prefix + "trnd_line_cons_val", ""));
		setAvgBlrCsmWgt(JSPUtil.getParameter(request, prefix + "avg_blr_csm_wgt", ""));
		setOpMaxSpd(JSPUtil.getParameter(request, prefix + "op_max_spd", ""));
		setTrndLineToDt(JSPUtil.getParameter(request, prefix + "trnd_line_to_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVslClssCd(JSPUtil.getParameter(request, prefix + "vsl_clss_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTrndLineSeq(JSPUtil.getParameter(request, prefix + "trnd_line_seq", ""));
		setN1stVarDgrVal(JSPUtil.getParameter(request, prefix + "n1st_var_dgr_val", ""));
		setTrndLineChtTpCd(JSPUtil.getParameter(request, prefix + "trnd_line_cht_tp_cd", ""));
		setAvgGnrCsmWgt(JSPUtil.getParameter(request, prefix + "avg_gnr_csm_wgt", ""));
		setN1stCoefVal(JSPUtil.getParameter(request, prefix + "n1st_coef_val", ""));
		setVslClssSubCd(JSPUtil.getParameter(request, prefix + "vsl_clss_sub_cd", ""));
		setTrndLineTpSubCd(JSPUtil.getParameter(request, prefix + "trnd_line_tp_sub_cd", ""));
		setNoonRptDt(JSPUtil.getParameter(request, prefix + "noon_rpt_dt", ""));
		setTrndLineNo(JSPUtil.getParameter(request, prefix + "trnd_line_no", ""));
		setTrndLineUseTpCd(JSPUtil.getParameter(request, prefix + "trnd_line_use_tp_cd", ""));
		setAvgSlpRt(JSPUtil.getParameter(request, prefix + "avg_slp_rt", ""));
		setAvgSlpOptRt(JSPUtil.getParameter(request, prefix + "avg_slp_opt_rt", ""));
		setAplySlpRt(JSPUtil.getParameter(request, prefix + "aply_slp_rt", ""));
		setCntrDznCapa(JSPUtil.getParameter(request, prefix + "cntr_dzn_capa", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmTrndLineVO[]
	 */
	public FcmTrndLineVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmTrndLineVO[]
	 */
	public FcmTrndLineVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmTrndLineVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] trndLineTpCd = (JSPUtil.getParameter(request, prefix	+ "trnd_line_tp_cd", length));
			String[] fomlDesc = (JSPUtil.getParameter(request, prefix	+ "foml_desc", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trndLineRmk = (JSPUtil.getParameter(request, prefix	+ "trnd_line_rmk", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] trndLineFmDt = (JSPUtil.getParameter(request, prefix	+ "trnd_line_fm_dt", length));
			String[] n2ndCoefVal = (JSPUtil.getParameter(request, prefix	+ "n2nd_coef_val", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] coefOfDtmnVal = (JSPUtil.getParameter(request, prefix	+ "coef_of_dtmn_val", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] opMinSpd = (JSPUtil.getParameter(request, prefix	+ "op_min_spd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n2ndVarDgrVal = (JSPUtil.getParameter(request, prefix	+ "n2nd_var_dgr_val", length));
			String[] trndLineConsVal = (JSPUtil.getParameter(request, prefix	+ "trnd_line_cons_val", length));
			String[] avgBlrCsmWgt = (JSPUtil.getParameter(request, prefix	+ "avg_blr_csm_wgt", length));
			String[] opMaxSpd = (JSPUtil.getParameter(request, prefix	+ "op_max_spd", length));
			String[] trndLineToDt = (JSPUtil.getParameter(request, prefix	+ "trnd_line_to_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vslClssCd = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] trndLineSeq = (JSPUtil.getParameter(request, prefix	+ "trnd_line_seq", length));
			String[] n1stVarDgrVal = (JSPUtil.getParameter(request, prefix	+ "n1st_var_dgr_val", length));
			String[] trndLineChtTpCd = (JSPUtil.getParameter(request, prefix	+ "trnd_line_cht_tp_cd", length));
			String[] avgGnrCsmWgt = (JSPUtil.getParameter(request, prefix	+ "avg_gnr_csm_wgt", length));
			String[] n1stCoefVal = (JSPUtil.getParameter(request, prefix	+ "n1st_coef_val", length));
			String[] vslClssSubCd = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_sub_cd", length));
			String[] trndLineTpSubCd = (JSPUtil.getParameter(request, prefix	+ "trnd_line_tp_sub_cd", length));
			String[] noonRptDt = (JSPUtil.getParameter(request, prefix	+ "noon_rpt_dt", length));
			String[] trndLineNo = (JSPUtil.getParameter(request, prefix	+ "trnd_line_no", length));
			String[] trndLineUseTpCd = (JSPUtil.getParameter(request, prefix	+ "trnd_line_use_tp_cd", length));
			String[] avgSlpRt = (JSPUtil.getParameter(request, prefix	+ "avg_slp_rt", length));
			String[] avgSlpOptRt = (JSPUtil.getParameter(request, prefix	+ "avg_slp_opt_rt", length));
			String[] aplySlpRt = (JSPUtil.getParameter(request, prefix	+ "aply_slp_rt", length));
			String[] cntrDznCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_dzn_capa", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmTrndLineVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (trndLineTpCd[i] != null)
					model.setTrndLineTpCd(trndLineTpCd[i]);
				if (fomlDesc[i] != null)
					model.setFomlDesc(fomlDesc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trndLineRmk[i] != null)
					model.setTrndLineRmk(trndLineRmk[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (trndLineFmDt[i] != null)
					model.setTrndLineFmDt(trndLineFmDt[i]);
				if (n2ndCoefVal[i] != null)
					model.setN2ndCoefVal(n2ndCoefVal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (coefOfDtmnVal[i] != null)
					model.setCoefOfDtmnVal(coefOfDtmnVal[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (opMinSpd[i] != null)
					model.setOpMinSpd(opMinSpd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n2ndVarDgrVal[i] != null)
					model.setN2ndVarDgrVal(n2ndVarDgrVal[i]);
				if (trndLineConsVal[i] != null)
					model.setTrndLineConsVal(trndLineConsVal[i]);
				if (avgBlrCsmWgt[i] != null)
					model.setAvgBlrCsmWgt(avgBlrCsmWgt[i]);
				if (opMaxSpd[i] != null)
					model.setOpMaxSpd(opMaxSpd[i]);
				if (trndLineToDt[i] != null)
					model.setTrndLineToDt(trndLineToDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vslClssCd[i] != null)
					model.setVslClssCd(vslClssCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (trndLineSeq[i] != null)
					model.setTrndLineSeq(trndLineSeq[i]);
				if (n1stVarDgrVal[i] != null)
					model.setN1stVarDgrVal(n1stVarDgrVal[i]);
				if (trndLineChtTpCd[i] != null)
					model.setTrndLineChtTpCd(trndLineChtTpCd[i]);
				if (avgGnrCsmWgt[i] != null)
					model.setAvgGnrCsmWgt(avgGnrCsmWgt[i]);
				if (n1stCoefVal[i] != null)
					model.setN1stCoefVal(n1stCoefVal[i]);
				if (vslClssSubCd[i] != null)
					model.setVslClssSubCd(vslClssSubCd[i]);
				if (trndLineTpSubCd[i] != null)
					model.setTrndLineTpSubCd(trndLineTpSubCd[i]);
				if (noonRptDt[i] != null)
					model.setNoonRptDt(noonRptDt[i]);
				if (trndLineNo[i] != null)
					model.setTrndLineNo(trndLineNo[i]);
				if (trndLineUseTpCd[i] != null)
					model.setTrndLineUseTpCd(trndLineUseTpCd[i]);
				if (avgSlpRt[i] != null)
					model.setAvgSlpRt(avgSlpRt[i]);
				if (avgSlpOptRt[i] != null)
					model.setAvgSlpOptRt(avgSlpOptRt[i]);
				if (aplySlpRt[i] != null)
					model.setAplySlpRt(aplySlpRt[i]);
				if (cntrDznCapa[i] != null)
					model.setCntrDznCapa(cntrDznCapa[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmTrndLineVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmTrndLineVO[]
	 */
	public FcmTrndLineVO[] getFcmTrndLineVOs(){
		FcmTrndLineVO[] vos = (FcmTrndLineVO[])models.toArray(new FcmTrndLineVO[models.size()]);
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
		this.trndLineTpCd = this.trndLineTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fomlDesc = this.fomlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineRmk = this.trndLineRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineFmDt = this.trndLineFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndCoefVal = this.n2ndCoefVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coefOfDtmnVal = this.coefOfDtmnVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opMinSpd = this.opMinSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVarDgrVal = this.n2ndVarDgrVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineConsVal = this.trndLineConsVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgBlrCsmWgt = this.avgBlrCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opMaxSpd = this.opMaxSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineToDt = this.trndLineToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCd = this.vslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineSeq = this.trndLineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVarDgrVal = this.n1stVarDgrVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineChtTpCd = this.trndLineChtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgGnrCsmWgt = this.avgGnrCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCoefVal = this.n1stCoefVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssSubCd = this.vslClssSubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineTpSubCd = this.trndLineTpSubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noonRptDt = this.noonRptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineNo = this.trndLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineUseTpCd = this.trndLineUseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgSlpRt = this.avgSlpRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgSlpOptRt = this.avgSlpOptRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplySlpRt = this.aplySlpRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDznCapa = this.cntrDznCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
