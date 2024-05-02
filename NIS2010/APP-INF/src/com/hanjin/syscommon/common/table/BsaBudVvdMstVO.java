/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BsaBudVvdMstVO.java
*@FileTitle : BsaBudVvdMstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.24
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.24 이행지 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 이행지
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BsaBudVvdMstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BsaBudVvdMstVO> models = new ArrayList<BsaBudVvdMstVO>();
	
	/* Column Info */
	private String incmSubChtrAmt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String iocRuleDesc = null;
	/* Column Info */
	private String incmCrsChtrAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String expnSubChtrAmt = null;
	/* Column Info */
	private String n1stPortEtdDt = null;
	/* Column Info */
	private String revPortCd = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String freeAddWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hjsBsaBfrSubCapa = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String expnBzcChtrAmt = null;
	/* Column Info */
	private String freeAddTeuCapa = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String n2ndFnlHjsBsaCapa = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String hjsBsaRto = null;
	/* Column Info */
	private String revPortEtdDt = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String coBsaCapa = null;
	/* Column Info */
	private String chtrBsaRto = null;
	/* Column Info */
	private String incmBzcChtrAmt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vslCapa = null;
	/* Column Info */
	private String bsaCapa = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String expnCrsChtrAmt = null;
	/* Column Info */
	private String bsaOpCd = null;
	/* Column Info */
	private String fnlHjsBsaCapa = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BsaBudVvdMstVO() {}

	public BsaBudVvdMstVO(String ibflag, String pagerows, String trdCd, String rlaneCd, String vslCd, String skdVoyNo, String skdDirCd, String bsaOpCd, String iocCd, String vopCd, String crrCd, String vslCapa, String bsaCapa, String fnlHjsBsaCapa, String n2ndFnlHjsBsaCapa, String coBsaCapa, String hjsBsaRto, String chtrBsaRto, String hjsBsaBfrSubCapa, String revPortCd, String revPortEtdDt, String n1stPortEtdDt, String iocRuleDesc, String expnBzcChtrAmt, String expnSubChtrAmt, String expnCrsChtrAmt, String incmBzcChtrAmt, String incmSubChtrAmt, String incmCrsChtrAmt, String freeAddTeuCapa, String freeAddWgt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.incmSubChtrAmt = incmSubChtrAmt;
		this.vslCd = vslCd;
		this.iocRuleDesc = iocRuleDesc;
		this.incmCrsChtrAmt = incmCrsChtrAmt;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.expnSubChtrAmt = expnSubChtrAmt;
		this.n1stPortEtdDt = n1stPortEtdDt;
		this.revPortCd = revPortCd;
		this.crrCd = crrCd;
		this.freeAddWgt = freeAddWgt;
		this.pagerows = pagerows;
		this.hjsBsaBfrSubCapa = hjsBsaBfrSubCapa;
		this.ibflag = ibflag;
		this.expnBzcChtrAmt = expnBzcChtrAmt;
		this.freeAddTeuCapa = freeAddTeuCapa;
		this.updUsrId = updUsrId;
		this.n2ndFnlHjsBsaCapa = n2ndFnlHjsBsaCapa;
		this.updDt = updDt;
		this.iocCd = iocCd;
		this.hjsBsaRto = hjsBsaRto;
		this.revPortEtdDt = revPortEtdDt;
		this.vopCd = vopCd;
		this.coBsaCapa = coBsaCapa;
		this.chtrBsaRto = chtrBsaRto;
		this.incmBzcChtrAmt = incmBzcChtrAmt;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.vslCapa = vslCapa;
		this.bsaCapa = bsaCapa;
		this.creUsrId = creUsrId;
		this.expnCrsChtrAmt = expnCrsChtrAmt;
		this.bsaOpCd = bsaOpCd;
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("incm_sub_chtr_amt", getIncmSubChtrAmt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ioc_rule_desc", getIocRuleDesc());
		this.hashColumns.put("incm_crs_chtr_amt", getIncmCrsChtrAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("expn_sub_chtr_amt", getExpnSubChtrAmt());
		this.hashColumns.put("n1st_port_etd_dt", getN1stPortEtdDt());
		this.hashColumns.put("rev_port_cd", getRevPortCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("free_add_wgt", getFreeAddWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hjs_bsa_bfr_sub_capa", getHjsBsaBfrSubCapa());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("expn_bzc_chtr_amt", getExpnBzcChtrAmt());
		this.hashColumns.put("free_add_teu_capa", getFreeAddTeuCapa());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("n2nd_fnl_hjs_bsa_capa", getN2ndFnlHjsBsaCapa());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("hjs_bsa_rto", getHjsBsaRto());
		this.hashColumns.put("rev_port_etd_dt", getRevPortEtdDt());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("co_bsa_capa", getCoBsaCapa());
		this.hashColumns.put("chtr_bsa_rto", getChtrBsaRto());
		this.hashColumns.put("incm_bzc_chtr_amt", getIncmBzcChtrAmt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vsl_capa", getVslCapa());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("expn_crs_chtr_amt", getExpnCrsChtrAmt());
		this.hashColumns.put("bsa_op_cd", getBsaOpCd());
		this.hashColumns.put("fnl_hjs_bsa_capa", getFnlHjsBsaCapa());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("incm_sub_chtr_amt", "incmSubChtrAmt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ioc_rule_desc", "iocRuleDesc");
		this.hashFields.put("incm_crs_chtr_amt", "incmCrsChtrAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("expn_sub_chtr_amt", "expnSubChtrAmt");
		this.hashFields.put("n1st_port_etd_dt", "n1stPortEtdDt");
		this.hashFields.put("rev_port_cd", "revPortCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("free_add_wgt", "freeAddWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hjs_bsa_bfr_sub_capa", "hjsBsaBfrSubCapa");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("expn_bzc_chtr_amt", "expnBzcChtrAmt");
		this.hashFields.put("free_add_teu_capa", "freeAddTeuCapa");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("n2nd_fnl_hjs_bsa_capa", "n2ndFnlHjsBsaCapa");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("hjs_bsa_rto", "hjsBsaRto");
		this.hashFields.put("rev_port_etd_dt", "revPortEtdDt");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("co_bsa_capa", "coBsaCapa");
		this.hashFields.put("chtr_bsa_rto", "chtrBsaRto");
		this.hashFields.put("incm_bzc_chtr_amt", "incmBzcChtrAmt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vsl_capa", "vslCapa");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("expn_crs_chtr_amt", "expnCrsChtrAmt");
		this.hashFields.put("bsa_op_cd", "bsaOpCd");
		this.hashFields.put("fnl_hjs_bsa_capa", "fnlHjsBsaCapa");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return incmSubChtrAmt
	 */
	public String getIncmSubChtrAmt() {
		return this.incmSubChtrAmt;
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
	 * @return iocRuleDesc
	 */
	public String getIocRuleDesc() {
		return this.iocRuleDesc;
	}
	
	/**
	 * Column Info
	 * @return incmCrsChtrAmt
	 */
	public String getIncmCrsChtrAmt() {
		return this.incmCrsChtrAmt;
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
	 * Column Info
	 * @return expnSubChtrAmt
	 */
	public String getExpnSubChtrAmt() {
		return this.expnSubChtrAmt;
	}
	
	/**
	 * Column Info
	 * @return n1stPortEtdDt
	 */
	public String getN1stPortEtdDt() {
		return this.n1stPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return revPortCd
	 */
	public String getRevPortCd() {
		return this.revPortCd;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return freeAddWgt
	 */
	public String getFreeAddWgt() {
		return this.freeAddWgt;
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
	 * @return hjsBsaBfrSubCapa
	 */
	public String getHjsBsaBfrSubCapa() {
		return this.hjsBsaBfrSubCapa;
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
	 * @return expnBzcChtrAmt
	 */
	public String getExpnBzcChtrAmt() {
		return this.expnBzcChtrAmt;
	}
	
	/**
	 * Column Info
	 * @return freeAddTeuCapa
	 */
	public String getFreeAddTeuCapa() {
		return this.freeAddTeuCapa;
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
	 * @return n2ndFnlHjsBsaCapa
	 */
	public String getN2ndFnlHjsBsaCapa() {
		return this.n2ndFnlHjsBsaCapa;
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
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return hjsBsaRto
	 */
	public String getHjsBsaRto() {
		return this.hjsBsaRto;
	}
	
	/**
	 * Column Info
	 * @return revPortEtdDt
	 */
	public String getRevPortEtdDt() {
		return this.revPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return vopCd
	 */
	public String getVopCd() {
		return this.vopCd;
	}
	
	/**
	 * Column Info
	 * @return coBsaCapa
	 */
	public String getCoBsaCapa() {
		return this.coBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return chtrBsaRto
	 */
	public String getChtrBsaRto() {
		return this.chtrBsaRto;
	}
	
	/**
	 * Column Info
	 * @return incmBzcChtrAmt
	 */
	public String getIncmBzcChtrAmt() {
		return this.incmBzcChtrAmt;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return vslCapa
	 */
	public String getVslCapa() {
		return this.vslCapa;
	}
	
	/**
	 * Column Info
	 * @return bsaCapa
	 */
	public String getBsaCapa() {
		return this.bsaCapa;
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
	 * @return expnCrsChtrAmt
	 */
	public String getExpnCrsChtrAmt() {
		return this.expnCrsChtrAmt;
	}
	
	/**
	 * Column Info
	 * @return bsaOpCd
	 */
	public String getBsaOpCd() {
		return this.bsaOpCd;
	}
	
	/**
	 * Column Info
	 * @return fnlHjsBsaCapa
	 */
	public String getFnlHjsBsaCapa() {
		return this.fnlHjsBsaCapa;
	}
	

	/**
	 * Column Info
	 * @param incmSubChtrAmt
	 */
	public void setIncmSubChtrAmt(String incmSubChtrAmt) {
		this.incmSubChtrAmt = incmSubChtrAmt;
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
	 * @param iocRuleDesc
	 */
	public void setIocRuleDesc(String iocRuleDesc) {
		this.iocRuleDesc = iocRuleDesc;
	}
	
	/**
	 * Column Info
	 * @param incmCrsChtrAmt
	 */
	public void setIncmCrsChtrAmt(String incmCrsChtrAmt) {
		this.incmCrsChtrAmt = incmCrsChtrAmt;
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
	 * Column Info
	 * @param expnSubChtrAmt
	 */
	public void setExpnSubChtrAmt(String expnSubChtrAmt) {
		this.expnSubChtrAmt = expnSubChtrAmt;
	}
	
	/**
	 * Column Info
	 * @param n1stPortEtdDt
	 */
	public void setN1stPortEtdDt(String n1stPortEtdDt) {
		this.n1stPortEtdDt = n1stPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param revPortCd
	 */
	public void setRevPortCd(String revPortCd) {
		this.revPortCd = revPortCd;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param freeAddWgt
	 */
	public void setFreeAddWgt(String freeAddWgt) {
		this.freeAddWgt = freeAddWgt;
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
	 * @param hjsBsaBfrSubCapa
	 */
	public void setHjsBsaBfrSubCapa(String hjsBsaBfrSubCapa) {
		this.hjsBsaBfrSubCapa = hjsBsaBfrSubCapa;
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
	 * @param expnBzcChtrAmt
	 */
	public void setExpnBzcChtrAmt(String expnBzcChtrAmt) {
		this.expnBzcChtrAmt = expnBzcChtrAmt;
	}
	
	/**
	 * Column Info
	 * @param freeAddTeuCapa
	 */
	public void setFreeAddTeuCapa(String freeAddTeuCapa) {
		this.freeAddTeuCapa = freeAddTeuCapa;
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
	 * @param n2ndFnlHjsBsaCapa
	 */
	public void setN2ndFnlHjsBsaCapa(String n2ndFnlHjsBsaCapa) {
		this.n2ndFnlHjsBsaCapa = n2ndFnlHjsBsaCapa;
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
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param hjsBsaRto
	 */
	public void setHjsBsaRto(String hjsBsaRto) {
		this.hjsBsaRto = hjsBsaRto;
	}
	
	/**
	 * Column Info
	 * @param revPortEtdDt
	 */
	public void setRevPortEtdDt(String revPortEtdDt) {
		this.revPortEtdDt = revPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param vopCd
	 */
	public void setVopCd(String vopCd) {
		this.vopCd = vopCd;
	}
	
	/**
	 * Column Info
	 * @param coBsaCapa
	 */
	public void setCoBsaCapa(String coBsaCapa) {
		this.coBsaCapa = coBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param chtrBsaRto
	 */
	public void setChtrBsaRto(String chtrBsaRto) {
		this.chtrBsaRto = chtrBsaRto;
	}
	
	/**
	 * Column Info
	 * @param incmBzcChtrAmt
	 */
	public void setIncmBzcChtrAmt(String incmBzcChtrAmt) {
		this.incmBzcChtrAmt = incmBzcChtrAmt;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param vslCapa
	 */
	public void setVslCapa(String vslCapa) {
		this.vslCapa = vslCapa;
	}
	
	/**
	 * Column Info
	 * @param bsaCapa
	 */
	public void setBsaCapa(String bsaCapa) {
		this.bsaCapa = bsaCapa;
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
	 * @param expnCrsChtrAmt
	 */
	public void setExpnCrsChtrAmt(String expnCrsChtrAmt) {
		this.expnCrsChtrAmt = expnCrsChtrAmt;
	}
	
	/**
	 * Column Info
	 * @param bsaOpCd
	 */
	public void setBsaOpCd(String bsaOpCd) {
		this.bsaOpCd = bsaOpCd;
	}
	
	/**
	 * Column Info
	 * @param fnlHjsBsaCapa
	 */
	public void setFnlHjsBsaCapa(String fnlHjsBsaCapa) {
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
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
		setIncmSubChtrAmt(JSPUtil.getParameter(request, prefix + "incm_sub_chtr_amt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setIocRuleDesc(JSPUtil.getParameter(request, prefix + "ioc_rule_desc", ""));
		setIncmCrsChtrAmt(JSPUtil.getParameter(request, prefix + "incm_crs_chtr_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setExpnSubChtrAmt(JSPUtil.getParameter(request, prefix + "expn_sub_chtr_amt", ""));
		setN1stPortEtdDt(JSPUtil.getParameter(request, prefix + "n1st_port_etd_dt", ""));
		setRevPortCd(JSPUtil.getParameter(request, prefix + "rev_port_cd", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setFreeAddWgt(JSPUtil.getParameter(request, prefix + "free_add_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setHjsBsaBfrSubCapa(JSPUtil.getParameter(request, prefix + "hjs_bsa_bfr_sub_capa", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setExpnBzcChtrAmt(JSPUtil.getParameter(request, prefix + "expn_bzc_chtr_amt", ""));
		setFreeAddTeuCapa(JSPUtil.getParameter(request, prefix + "free_add_teu_capa", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setN2ndFnlHjsBsaCapa(JSPUtil.getParameter(request, prefix + "n2nd_fnl_hjs_bsa_capa", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setHjsBsaRto(JSPUtil.getParameter(request, prefix + "hjs_bsa_rto", ""));
		setRevPortEtdDt(JSPUtil.getParameter(request, prefix + "rev_port_etd_dt", ""));
		setVopCd(JSPUtil.getParameter(request, prefix + "vop_cd", ""));
		setCoBsaCapa(JSPUtil.getParameter(request, prefix + "co_bsa_capa", ""));
		setChtrBsaRto(JSPUtil.getParameter(request, prefix + "chtr_bsa_rto", ""));
		setIncmBzcChtrAmt(JSPUtil.getParameter(request, prefix + "incm_bzc_chtr_amt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVslCapa(JSPUtil.getParameter(request, prefix + "vsl_capa", ""));
		setBsaCapa(JSPUtil.getParameter(request, prefix + "bsa_capa", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setExpnCrsChtrAmt(JSPUtil.getParameter(request, prefix + "expn_crs_chtr_amt", ""));
		setBsaOpCd(JSPUtil.getParameter(request, prefix + "bsa_op_cd", ""));
		setFnlHjsBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_hjs_bsa_capa", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BsaBudVvdMstVO[]
	 */
	public BsaBudVvdMstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BsaBudVvdMstVO[]
	 */
	public BsaBudVvdMstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BsaBudVvdMstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] incmSubChtrAmt = (JSPUtil.getParameter(request, prefix	+ "incm_sub_chtr_amt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] iocRuleDesc = (JSPUtil.getParameter(request, prefix	+ "ioc_rule_desc", length));
			String[] incmCrsChtrAmt = (JSPUtil.getParameter(request, prefix	+ "incm_crs_chtr_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] expnSubChtrAmt = (JSPUtil.getParameter(request, prefix	+ "expn_sub_chtr_amt", length));
			String[] n1stPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "n1st_port_etd_dt", length));
			String[] revPortCd = (JSPUtil.getParameter(request, prefix	+ "rev_port_cd", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] freeAddWgt = (JSPUtil.getParameter(request, prefix	+ "free_add_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hjsBsaBfrSubCapa = (JSPUtil.getParameter(request, prefix	+ "hjs_bsa_bfr_sub_capa", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] expnBzcChtrAmt = (JSPUtil.getParameter(request, prefix	+ "expn_bzc_chtr_amt", length));
			String[] freeAddTeuCapa = (JSPUtil.getParameter(request, prefix	+ "free_add_teu_capa", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] n2ndFnlHjsBsaCapa = (JSPUtil.getParameter(request, prefix	+ "n2nd_fnl_hjs_bsa_capa", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] hjsBsaRto = (JSPUtil.getParameter(request, prefix	+ "hjs_bsa_rto", length));
			String[] revPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "rev_port_etd_dt", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] coBsaCapa = (JSPUtil.getParameter(request, prefix	+ "co_bsa_capa", length));
			String[] chtrBsaRto = (JSPUtil.getParameter(request, prefix	+ "chtr_bsa_rto", length));
			String[] incmBzcChtrAmt = (JSPUtil.getParameter(request, prefix	+ "incm_bzc_chtr_amt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vslCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_capa", length));
			String[] bsaCapa = (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] expnCrsChtrAmt = (JSPUtil.getParameter(request, prefix	+ "expn_crs_chtr_amt", length));
			String[] bsaOpCd = (JSPUtil.getParameter(request, prefix	+ "bsa_op_cd", length));
			String[] fnlHjsBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_hjs_bsa_capa", length));
			
			for (int i = 0; i < length; i++) {
				model = new BsaBudVvdMstVO();
				if (incmSubChtrAmt[i] != null)
					model.setIncmSubChtrAmt(incmSubChtrAmt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (iocRuleDesc[i] != null)
					model.setIocRuleDesc(iocRuleDesc[i]);
				if (incmCrsChtrAmt[i] != null)
					model.setIncmCrsChtrAmt(incmCrsChtrAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (expnSubChtrAmt[i] != null)
					model.setExpnSubChtrAmt(expnSubChtrAmt[i]);
				if (n1stPortEtdDt[i] != null)
					model.setN1stPortEtdDt(n1stPortEtdDt[i]);
				if (revPortCd[i] != null)
					model.setRevPortCd(revPortCd[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (freeAddWgt[i] != null)
					model.setFreeAddWgt(freeAddWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hjsBsaBfrSubCapa[i] != null)
					model.setHjsBsaBfrSubCapa(hjsBsaBfrSubCapa[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (expnBzcChtrAmt[i] != null)
					model.setExpnBzcChtrAmt(expnBzcChtrAmt[i]);
				if (freeAddTeuCapa[i] != null)
					model.setFreeAddTeuCapa(freeAddTeuCapa[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (n2ndFnlHjsBsaCapa[i] != null)
					model.setN2ndFnlHjsBsaCapa(n2ndFnlHjsBsaCapa[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (hjsBsaRto[i] != null)
					model.setHjsBsaRto(hjsBsaRto[i]);
				if (revPortEtdDt[i] != null)
					model.setRevPortEtdDt(revPortEtdDt[i]);
				if (vopCd[i] != null)
					model.setVopCd(vopCd[i]);
				if (coBsaCapa[i] != null)
					model.setCoBsaCapa(coBsaCapa[i]);
				if (chtrBsaRto[i] != null)
					model.setChtrBsaRto(chtrBsaRto[i]);
				if (incmBzcChtrAmt[i] != null)
					model.setIncmBzcChtrAmt(incmBzcChtrAmt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vslCapa[i] != null)
					model.setVslCapa(vslCapa[i]);
				if (bsaCapa[i] != null)
					model.setBsaCapa(bsaCapa[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (expnCrsChtrAmt[i] != null)
					model.setExpnCrsChtrAmt(expnCrsChtrAmt[i]);
				if (bsaOpCd[i] != null)
					model.setBsaOpCd(bsaOpCd[i]);
				if (fnlHjsBsaCapa[i] != null)
					model.setFnlHjsBsaCapa(fnlHjsBsaCapa[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBsaBudVvdMstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BsaBudVvdMstVO[]
	 */
	public BsaBudVvdMstVO[] getBsaBudVvdMstVOs(){
		BsaBudVvdMstVO[] vos = (BsaBudVvdMstVO[])models.toArray(new BsaBudVvdMstVO[models.size()]);
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
		this.incmSubChtrAmt = this.incmSubChtrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocRuleDesc = this.iocRuleDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incmCrsChtrAmt = this.incmCrsChtrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnSubChtrAmt = this.expnSubChtrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPortEtdDt = this.n1stPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revPortCd = this.revPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeAddWgt = this.freeAddWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsBsaBfrSubCapa = this.hjsBsaBfrSubCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnBzcChtrAmt = this.expnBzcChtrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeAddTeuCapa = this.freeAddTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndFnlHjsBsaCapa = this.n2ndFnlHjsBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsBsaRto = this.hjsBsaRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revPortEtdDt = this.revPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coBsaCapa = this.coBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chtrBsaRto = this.chtrBsaRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incmBzcChtrAmt = this.incmBzcChtrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCapa = this.vslCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnCrsChtrAmt = this.expnCrsChtrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaOpCd = this.bsaOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlHjsBsaCapa = this.fnlHjsBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
