/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VvdStlAmtVO.java
*@FileTitle : VvdStlAmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.07
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.11.07 김영오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VvdStlAmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VvdStlAmtVO> models = new ArrayList<VvdStlAmtVO>();
	
	/* Column Info */
	private String vslDzndCapa = null;
	/* Column Info */
	private String vslDeDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String maxVvdExistYn = null;
	/* Column Info */
	private String stlYrmon = null;
	/* Column Info */
	private String stlMon = null;
	/* Column Info */
	private String eStlYrmon = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String vslSeq = null;
	/* Column Info */
	private String vvdExistYn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String nrtWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String vslRgstCntCd = null;
	/* Column Info */
	private String ctrtEndDt = null;
	/* Column Info */
	private String nrtTongTaxAmt = null;
	/* Column Info */
	private String ldbCapaQty = null;
	/* Column Info */
	private String capaDiff = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fmVvdStlDt = null;
	/* Column Info */
	private String tongStlBatJbSeq = null;
	/* Column Info */
	private String endDt = null;
	/* Column Info */
	private String usgRt = null;
	/* Column Info */
	private String toVvdStlDt = null;
	/* Column Info */
	private String grsRgstTongWgt = null;
	/* Column Info */
	private String strDt = null;
	/* Column Info */
	private String actBsaCapa = null;
	/* Column Info */
	private String ctrtYear = null;
	/* Column Info */
	private String tongFletTpCd = null;
	/* Column Info */
	private String bsaCapa = null;
	/* Column Info */
	private String voyDys = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String ctrtStDt = null;
	/* Column Info */
	private String chtrBsaCapa = null;
	/* Column Info */
	private String tongTaxAmt = null;
	/* Column Info */
	private String perTonRev = null;
	/* Column Info */
	private String vslSvcTpNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VvdStlAmtVO() {}

	public VvdStlAmtVO(String ibflag, String pagerows, String vslDeDt, String vslCd, String stlYrmon, String eStlYrmon, String stlMon, String trdCd, String vslSeq, String nrtWgt, String vslRgstCntCd, String vslEngNm, String ctrtEndDt, String ldbCapaQty, String capaDiff, String fmVvdStlDt, String usgRt, String toVvdStlDt, String grsRgstTongWgt, String actBsaCapa, String ctrtYear, String tongFletTpCd, String bsaCapa, String voyDys, String slanCd, String ctrtStDt, String chtrBsaCapa, String perTonRev, String tongTaxAmt, String strDt, String endDt, String nrtTongTaxAmt, String tongStlBatJbSeq, String vslDzndCapa, String vvdExistYn, String maxVvdExistYn, String creDt, String creUsrId, String updDt, String vvdCd, String updUsrId, String vslSvcTpNm) {
		this.vslDzndCapa = vslDzndCapa;
		this.vslDeDt = vslDeDt;
		this.vslCd = vslCd;
		this.maxVvdExistYn = maxVvdExistYn;
		this.stlYrmon = stlYrmon;
		this.stlMon = stlMon;
		this.eStlYrmon = eStlYrmon;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.vslSeq = vslSeq;
		this.vvdExistYn = vvdExistYn;
		this.pagerows = pagerows;
		this.nrtWgt = nrtWgt;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.vslEngNm = vslEngNm;
		this.vslRgstCntCd = vslRgstCntCd;
		this.ctrtEndDt = ctrtEndDt;
		this.nrtTongTaxAmt = nrtTongTaxAmt;
		this.ldbCapaQty = ldbCapaQty;
		this.capaDiff = capaDiff;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.fmVvdStlDt = fmVvdStlDt;
		this.tongStlBatJbSeq = tongStlBatJbSeq;
		this.endDt = endDt;
		this.usgRt = usgRt;
		this.toVvdStlDt = toVvdStlDt;
		this.grsRgstTongWgt = grsRgstTongWgt;
		this.strDt = strDt;
		this.actBsaCapa = actBsaCapa;
		this.ctrtYear = ctrtYear;
		this.tongFletTpCd = tongFletTpCd;
		this.bsaCapa = bsaCapa;
		this.voyDys = voyDys;
		this.creUsrId = creUsrId;
		this.slanCd = slanCd;
		this.ctrtStDt = ctrtStDt;
		this.chtrBsaCapa = chtrBsaCapa;
		this.tongTaxAmt = tongTaxAmt;
		this.perTonRev = perTonRev;
		this.vslSvcTpNm = vslSvcTpNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_dznd_capa", getVslDzndCapa());
		this.hashColumns.put("vsl_de_dt", getVslDeDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("max_vvd_exist_yn", getMaxVvdExistYn());
		this.hashColumns.put("stl_yrmon", getStlYrmon());
		this.hashColumns.put("stl_mon", getStlMon());
		this.hashColumns.put("e_stl_yrmon", getEStlYrmon());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("vsl_seq", getVslSeq());
		this.hashColumns.put("vvd_exist_yn", getVvdExistYn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("nrt_wgt", getNrtWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
		this.hashColumns.put("ctrt_end_dt", getCtrtEndDt());
		this.hashColumns.put("nrt_tong_tax_amt", getNrtTongTaxAmt());
		this.hashColumns.put("ldb_capa_qty", getLdbCapaQty());
		this.hashColumns.put("capa_diff", getCapaDiff());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("fm_vvd_stl_dt", getFmVvdStlDt());
		this.hashColumns.put("tong_stl_bat_jb_seq", getTongStlBatJbSeq());
		this.hashColumns.put("end_dt", getEndDt());
		this.hashColumns.put("usg_rt", getUsgRt());
		this.hashColumns.put("to_vvd_stl_dt", getToVvdStlDt());
		this.hashColumns.put("grs_rgst_tong_wgt", getGrsRgstTongWgt());
		this.hashColumns.put("str_dt", getStrDt());
		this.hashColumns.put("act_bsa_capa", getActBsaCapa());
		this.hashColumns.put("ctrt_year", getCtrtYear());
		this.hashColumns.put("tong_flet_tp_cd", getTongFletTpCd());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("voy_dys", getVoyDys());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("ctrt_st_dt", getCtrtStDt());
		this.hashColumns.put("chtr_bsa_capa", getChtrBsaCapa());
		this.hashColumns.put("tong_tax_amt", getTongTaxAmt());
		this.hashColumns.put("per_ton_rev", getPerTonRev());
		this.hashColumns.put("vsl_svc_tp_nm", getVslSvcTpNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_dznd_capa", "vslDzndCapa");
		this.hashFields.put("vsl_de_dt", "vslDeDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("max_vvd_exist_yn", "maxVvdExistYn");
		this.hashFields.put("stl_yrmon", "stlYrmon");
		this.hashFields.put("stl_mon", "stlMon");
		this.hashFields.put("e_stl_yrmon", "eStlYrmon");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("vsl_seq", "vslSeq");
		this.hashFields.put("vvd_exist_yn", "vvdExistYn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("nrt_wgt", "nrtWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
		this.hashFields.put("ctrt_end_dt", "ctrtEndDt");
		this.hashFields.put("nrt_tong_tax_amt", "nrtTongTaxAmt");
		this.hashFields.put("ldb_capa_qty", "ldbCapaQty");
		this.hashFields.put("capa_diff", "capaDiff");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("fm_vvd_stl_dt", "fmVvdStlDt");
		this.hashFields.put("tong_stl_bat_jb_seq", "tongStlBatJbSeq");
		this.hashFields.put("end_dt", "endDt");
		this.hashFields.put("usg_rt", "usgRt");
		this.hashFields.put("to_vvd_stl_dt", "toVvdStlDt");
		this.hashFields.put("grs_rgst_tong_wgt", "grsRgstTongWgt");
		this.hashFields.put("str_dt", "strDt");
		this.hashFields.put("act_bsa_capa", "actBsaCapa");
		this.hashFields.put("ctrt_year", "ctrtYear");
		this.hashFields.put("tong_flet_tp_cd", "tongFletTpCd");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("voy_dys", "voyDys");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("ctrt_st_dt", "ctrtStDt");
		this.hashFields.put("chtr_bsa_capa", "chtrBsaCapa");
		this.hashFields.put("tong_tax_amt", "tongTaxAmt");
		this.hashFields.put("per_ton_rev", "perTonRev");
		this.hashFields.put("vsl_svc_tp_nm", "vslSvcTpNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslDzndCapa
	 */
	public String getVslDzndCapa() {
		return this.vslDzndCapa;
	}
	
	/**
	 * Column Info
	 * @return vslDeDt
	 */
	public String getVslDeDt() {
		return this.vslDeDt;
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
	 * @return maxVvdExistYn
	 */
	public String getMaxVvdExistYn() {
		return this.maxVvdExistYn;
	}
	
	/**
	 * Column Info
	 * @return stlYrmon
	 */
	public String getStlYrmon() {
		return this.stlYrmon;
	}
	
	/**
	 * Column Info
	 * @return stlMon
	 */
	public String getStlMon() {
		return this.stlMon;
	}
	
	/**
	 * Column Info
	 * @return eStlYrmon
	 */
	public String getEStlYrmon() {
		return this.eStlYrmon;
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
	 * @return vslSeq
	 */
	public String getVslSeq() {
		return this.vslSeq;
	}
	
	/**
	 * Column Info
	 * @return vvdExistYn
	 */
	public String getVvdExistYn() {
		return this.vvdExistYn;
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
	 * @return nrtWgt
	 */
	public String getNrtWgt() {
		return this.nrtWgt;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return vslRgstCntCd
	 */
	public String getVslRgstCntCd() {
		return this.vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtEndDt
	 */
	public String getCtrtEndDt() {
		return this.ctrtEndDt;
	}
	
	/**
	 * Column Info
	 * @return nrtTongTaxAmt
	 */
	public String getNrtTongTaxAmt() {
		return this.nrtTongTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return ldbCapaQty
	 */
	public String getLdbCapaQty() {
		return this.ldbCapaQty;
	}
	
	/**
	 * Column Info
	 * @return capaDiff
	 */
	public String getCapaDiff() {
		return this.capaDiff;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return fmVvdStlDt
	 */
	public String getFmVvdStlDt() {
		return this.fmVvdStlDt;
	}
	
	/**
	 * Column Info
	 * @return tongStlBatJbSeq
	 */
	public String getTongStlBatJbSeq() {
		return this.tongStlBatJbSeq;
	}
	
	/**
	 * Column Info
	 * @return endDt
	 */
	public String getEndDt() {
		return this.endDt;
	}
	
	/**
	 * Column Info
	 * @return usgRt
	 */
	public String getUsgRt() {
		return this.usgRt;
	}
	
	/**
	 * Column Info
	 * @return toVvdStlDt
	 */
	public String getToVvdStlDt() {
		return this.toVvdStlDt;
	}
	
	/**
	 * Column Info
	 * @return grsRgstTongWgt
	 */
	public String getGrsRgstTongWgt() {
		return this.grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return strDt
	 */
	public String getStrDt() {
		return this.strDt;
	}
	
	/**
	 * Column Info
	 * @return actBsaCapa
	 */
	public String getActBsaCapa() {
		return this.actBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return ctrtYear
	 */
	public String getCtrtYear() {
		return this.ctrtYear;
	}
	
	/**
	 * Column Info
	 * @return tongFletTpCd
	 */
	public String getTongFletTpCd() {
		return this.tongFletTpCd;
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
	 * @return voyDys
	 */
	public String getVoyDys() {
		return this.voyDys;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtStDt
	 */
	public String getCtrtStDt() {
		return this.ctrtStDt;
	}
	
	/**
	 * Column Info
	 * @return chtrBsaCapa
	 */
	public String getChtrBsaCapa() {
		return this.chtrBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return tongTaxAmt
	 */
	public String getTongTaxAmt() {
		return this.tongTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return perTonRev
	 */
	public String getPerTonRev() {
		return this.perTonRev;
	}
	
	/**
	 * Column Info
	 * @return vslSvcTpNm
	 */
	public String getVslSvcTpNm() {
		return this.vslSvcTpNm;
	}
	
		/**
	 * Column Info
	 * @param vslDzndCapa
	 */
	public void setVslDzndCapa(String vslDzndCapa) {
		this.vslDzndCapa = vslDzndCapa;
	}
	
	/**
	 * Column Info
	 * @param vslDeDt
	 */
	public void setVslDeDt(String vslDeDt) {
		this.vslDeDt = vslDeDt;
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
	 * @param maxVvdExistYn
	 */
	public void setMaxVvdExistYn(String maxVvdExistYn) {
		this.maxVvdExistYn = maxVvdExistYn;
	}
	
	/**
	 * Column Info
	 * @param stlYrmon
	 */
	public void setStlYrmon(String stlYrmon) {
		this.stlYrmon = stlYrmon;
	}
	
	/**
	 * Column Info
	 * @param stlMon
	 */
	public void setStlMon(String stlMon) {
		this.stlMon = stlMon;
	}
	
	/**
	 * Column Info
	 * @param eStlYrmon
	 */
	public void setEStlYrmon(String eStlYrmon) {
		this.eStlYrmon = eStlYrmon;
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
	 * @param vslSeq
	 */
	public void setVslSeq(String vslSeq) {
		this.vslSeq = vslSeq;
	}
	
	/**
	 * Column Info
	 * @param vvdExistYn
	 */
	public void setVvdExistYn(String vvdExistYn) {
		this.vvdExistYn = vvdExistYn;
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
	 * @param nrtWgt
	 */
	public void setNrtWgt(String nrtWgt) {
		this.nrtWgt = nrtWgt;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param vslRgstCntCd
	 */
	public void setVslRgstCntCd(String vslRgstCntCd) {
		this.vslRgstCntCd = vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtEndDt
	 */
	public void setCtrtEndDt(String ctrtEndDt) {
		this.ctrtEndDt = ctrtEndDt;
	}
	
	/**
	 * Column Info
	 * @param nrtTongTaxAmt
	 */
	public void setNrtTongTaxAmt(String nrtTongTaxAmt) {
		this.nrtTongTaxAmt = nrtTongTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param ldbCapaQty
	 */
	public void setLdbCapaQty(String ldbCapaQty) {
		this.ldbCapaQty = ldbCapaQty;
	}
	
	/**
	 * Column Info
	 * @param capaDiff
	 */
	public void setCapaDiff(String capaDiff) {
		this.capaDiff = capaDiff;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param fmVvdStlDt
	 */
	public void setFmVvdStlDt(String fmVvdStlDt) {
		this.fmVvdStlDt = fmVvdStlDt;
	}
	
	/**
	 * Column Info
	 * @param tongStlBatJbSeq
	 */
	public void setTongStlBatJbSeq(String tongStlBatJbSeq) {
		this.tongStlBatJbSeq = tongStlBatJbSeq;
	}
	
	/**
	 * Column Info
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	
	/**
	 * Column Info
	 * @param usgRt
	 */
	public void setUsgRt(String usgRt) {
		this.usgRt = usgRt;
	}
	
	/**
	 * Column Info
	 * @param toVvdStlDt
	 */
	public void setToVvdStlDt(String toVvdStlDt) {
		this.toVvdStlDt = toVvdStlDt;
	}
	
	/**
	 * Column Info
	 * @param grsRgstTongWgt
	 */
	public void setGrsRgstTongWgt(String grsRgstTongWgt) {
		this.grsRgstTongWgt = grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param strDt
	 */
	public void setStrDt(String strDt) {
		this.strDt = strDt;
	}
	
	/**
	 * Column Info
	 * @param actBsaCapa
	 */
	public void setActBsaCapa(String actBsaCapa) {
		this.actBsaCapa = actBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param ctrtYear
	 */
	public void setCtrtYear(String ctrtYear) {
		this.ctrtYear = ctrtYear;
	}
	
	/**
	 * Column Info
	 * @param tongFletTpCd
	 */
	public void setTongFletTpCd(String tongFletTpCd) {
		this.tongFletTpCd = tongFletTpCd;
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
	 * @param voyDys
	 */
	public void setVoyDys(String voyDys) {
		this.voyDys = voyDys;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtStDt
	 */
	public void setCtrtStDt(String ctrtStDt) {
		this.ctrtStDt = ctrtStDt;
	}
	
	/**
	 * Column Info
	 * @param chtrBsaCapa
	 */
	public void setChtrBsaCapa(String chtrBsaCapa) {
		this.chtrBsaCapa = chtrBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param tongTaxAmt
	 */
	public void setTongTaxAmt(String tongTaxAmt) {
		this.tongTaxAmt = tongTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param perTonRev
	 */
	public void setPerTonRev(String perTonRev) {
		this.perTonRev = perTonRev;
	}

	/**
	 * Column Info
	 * @param vslSvcTpNm
	 */
	public void setVslSvcTpNm(String vslSvcTpNm) {
		this.vslSvcTpNm = vslSvcTpNm;
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
		setVslDzndCapa(JSPUtil.getParameter(request, prefix + "vsl_dznd_capa", ""));
		setVslDeDt(JSPUtil.getParameter(request, prefix + "vsl_de_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setMaxVvdExistYn(JSPUtil.getParameter(request, prefix + "max_vvd_exist_yn", ""));
		setStlYrmon(JSPUtil.getParameter(request, prefix + "stl_yrmon", ""));
		setStlMon(JSPUtil.getParameter(request, prefix + "stl_mon", ""));
		setEStlYrmon(JSPUtil.getParameter(request, prefix + "e_stl_yrmon", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setVslSeq(JSPUtil.getParameter(request, prefix + "vsl_seq", ""));
		setVvdExistYn(JSPUtil.getParameter(request, prefix + "vvd_exist_yn", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNrtWgt(JSPUtil.getParameter(request, prefix + "nrt_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setVslRgstCntCd(JSPUtil.getParameter(request, prefix + "vsl_rgst_cnt_cd", ""));
		setCtrtEndDt(JSPUtil.getParameter(request, prefix + "ctrt_end_dt", ""));
		setNrtTongTaxAmt(JSPUtil.getParameter(request, prefix + "nrt_tong_tax_amt", ""));
		setLdbCapaQty(JSPUtil.getParameter(request, prefix + "ldb_capa_qty", ""));
		setCapaDiff(JSPUtil.getParameter(request, prefix + "capa_diff", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setFmVvdStlDt(JSPUtil.getParameter(request, prefix + "fm_vvd_stl_dt", ""));
		setTongStlBatJbSeq(JSPUtil.getParameter(request, prefix + "tong_stl_bat_jb_seq", ""));
		setEndDt(JSPUtil.getParameter(request, prefix + "end_dt", ""));
		setUsgRt(JSPUtil.getParameter(request, prefix + "usg_rt", ""));
		setToVvdStlDt(JSPUtil.getParameter(request, prefix + "to_vvd_stl_dt", ""));
		setGrsRgstTongWgt(JSPUtil.getParameter(request, prefix + "grs_rgst_tong_wgt", ""));
		setStrDt(JSPUtil.getParameter(request, prefix + "str_dt", ""));
		setActBsaCapa(JSPUtil.getParameter(request, prefix + "act_bsa_capa", ""));
		setCtrtYear(JSPUtil.getParameter(request, prefix + "ctrt_year", ""));
		setTongFletTpCd(JSPUtil.getParameter(request, prefix + "tong_flet_tp_cd", ""));
		setBsaCapa(JSPUtil.getParameter(request, prefix + "bsa_capa", ""));
		setVoyDys(JSPUtil.getParameter(request, prefix + "voy_dys", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setCtrtStDt(JSPUtil.getParameter(request, prefix + "ctrt_st_dt", ""));
		setChtrBsaCapa(JSPUtil.getParameter(request, prefix + "chtr_bsa_capa", ""));
		setTongTaxAmt(JSPUtil.getParameter(request, prefix + "tong_tax_amt", ""));
		setPerTonRev(JSPUtil.getParameter(request, prefix + "per_ton_rev", ""));
		setVslSvcTpNm(JSPUtil.getParameter(request, prefix + "vsl_svc_tp_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VvdStlAmtVO[]
	 */
	public VvdStlAmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VvdStlAmtVO[]
	 */
	public VvdStlAmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VvdStlAmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslDzndCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_dznd_capa", length));
			String[] vslDeDt = (JSPUtil.getParameter(request, prefix	+ "vsl_de_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] maxVvdExistYn = (JSPUtil.getParameter(request, prefix	+ "max_vvd_exist_yn", length));
			String[] stlYrmon = (JSPUtil.getParameter(request, prefix	+ "stl_yrmon", length));
			String[] stlMon = (JSPUtil.getParameter(request, prefix	+ "stl_mon", length));
			String[] eStlYrmon = (JSPUtil.getParameter(request, prefix	+ "e_stl_yrmon", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] vslSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_seq", length));
			String[] vvdExistYn = (JSPUtil.getParameter(request, prefix	+ "vvd_exist_yn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] nrtWgt = (JSPUtil.getParameter(request, prefix	+ "nrt_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd", length));
			String[] ctrtEndDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_end_dt", length));
			String[] nrtTongTaxAmt = (JSPUtil.getParameter(request, prefix	+ "nrt_tong_tax_amt", length));
			String[] ldbCapaQty = (JSPUtil.getParameter(request, prefix	+ "ldb_capa_qty", length));
			String[] capaDiff = (JSPUtil.getParameter(request, prefix	+ "capa_diff", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fmVvdStlDt = (JSPUtil.getParameter(request, prefix	+ "fm_vvd_stl_dt", length));
			String[] tongStlBatJbSeq = (JSPUtil.getParameter(request, prefix	+ "tong_stl_bat_jb_seq", length));
			String[] endDt = (JSPUtil.getParameter(request, prefix	+ "end_dt", length));
			String[] usgRt = (JSPUtil.getParameter(request, prefix	+ "usg_rt", length));
			String[] toVvdStlDt = (JSPUtil.getParameter(request, prefix	+ "to_vvd_stl_dt", length));
			String[] grsRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "grs_rgst_tong_wgt", length));
			String[] strDt = (JSPUtil.getParameter(request, prefix	+ "str_dt", length));
			String[] actBsaCapa = (JSPUtil.getParameter(request, prefix	+ "act_bsa_capa", length));
			String[] ctrtYear = (JSPUtil.getParameter(request, prefix	+ "ctrt_year", length));
			String[] tongFletTpCd = (JSPUtil.getParameter(request, prefix	+ "tong_flet_tp_cd", length));
			String[] bsaCapa = (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] voyDys = (JSPUtil.getParameter(request, prefix	+ "voy_dys", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] ctrtStDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_st_dt", length));
			String[] chtrBsaCapa = (JSPUtil.getParameter(request, prefix	+ "chtr_bsa_capa", length));
			String[] tongTaxAmt = (JSPUtil.getParameter(request, prefix	+ "tong_tax_amt", length));
			String[] perTonRev = (JSPUtil.getParameter(request, prefix	+ "per_ton_rev", length));
			String[] vslSvcTpNm = (JSPUtil.getParameter(request, prefix	+ "vsl_svc_tp_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new VvdStlAmtVO();
				if (vslDzndCapa[i] != null)
					model.setVslDzndCapa(vslDzndCapa[i]);
				if (vslDeDt[i] != null)
					model.setVslDeDt(vslDeDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (maxVvdExistYn[i] != null)
					model.setMaxVvdExistYn(maxVvdExistYn[i]);
				if (stlYrmon[i] != null)
					model.setStlYrmon(stlYrmon[i]);
				if (stlMon[i] != null)
					model.setStlMon(stlMon[i]);
				if (eStlYrmon[i] != null)
					model.setEStlYrmon(eStlYrmon[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (vslSeq[i] != null)
					model.setVslSeq(vslSeq[i]);
				if (vvdExistYn[i] != null)
					model.setVvdExistYn(vvdExistYn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (nrtWgt[i] != null)
					model.setNrtWgt(nrtWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (vslRgstCntCd[i] != null)
					model.setVslRgstCntCd(vslRgstCntCd[i]);
				if (ctrtEndDt[i] != null)
					model.setCtrtEndDt(ctrtEndDt[i]);
				if (nrtTongTaxAmt[i] != null)
					model.setNrtTongTaxAmt(nrtTongTaxAmt[i]);
				if (ldbCapaQty[i] != null)
					model.setLdbCapaQty(ldbCapaQty[i]);
				if (capaDiff[i] != null)
					model.setCapaDiff(capaDiff[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fmVvdStlDt[i] != null)
					model.setFmVvdStlDt(fmVvdStlDt[i]);
				if (tongStlBatJbSeq[i] != null)
					model.setTongStlBatJbSeq(tongStlBatJbSeq[i]);
				if (endDt[i] != null)
					model.setEndDt(endDt[i]);
				if (usgRt[i] != null)
					model.setUsgRt(usgRt[i]);
				if (toVvdStlDt[i] != null)
					model.setToVvdStlDt(toVvdStlDt[i]);
				if (grsRgstTongWgt[i] != null)
					model.setGrsRgstTongWgt(grsRgstTongWgt[i]);
				if (strDt[i] != null)
					model.setStrDt(strDt[i]);
				if (actBsaCapa[i] != null)
					model.setActBsaCapa(actBsaCapa[i]);
				if (ctrtYear[i] != null)
					model.setCtrtYear(ctrtYear[i]);
				if (tongFletTpCd[i] != null)
					model.setTongFletTpCd(tongFletTpCd[i]);
				if (bsaCapa[i] != null)
					model.setBsaCapa(bsaCapa[i]);
				if (voyDys[i] != null)
					model.setVoyDys(voyDys[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (ctrtStDt[i] != null)
					model.setCtrtStDt(ctrtStDt[i]);
				if (chtrBsaCapa[i] != null)
					model.setChtrBsaCapa(chtrBsaCapa[i]);
				if (tongTaxAmt[i] != null)
					model.setTongTaxAmt(tongTaxAmt[i]);
				if (perTonRev[i] != null)
					model.setPerTonRev(perTonRev[i]);
				if (vslSvcTpNm[i] != null)
					model.setVslSvcTpNm(vslSvcTpNm[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVvdStlAmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VvdStlAmtVO[]
	 */
	public VvdStlAmtVO[] getVvdStlAmtVOs(){
		VvdStlAmtVO[] vos = (VvdStlAmtVO[])models.toArray(new VvdStlAmtVO[models.size()]);
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
		this.vslDzndCapa = this.vslDzndCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDeDt = this.vslDeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxVvdExistYn = this.maxVvdExistYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlYrmon = this.stlYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlMon = this.stlMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eStlYrmon = this.eStlYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSeq = this.vslSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdExistYn = this.vvdExistYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nrtWgt = this.nrtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd = this.vslRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEndDt = this.ctrtEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nrtTongTaxAmt = this.nrtTongTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldbCapaQty = this.ldbCapaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capaDiff = this.capaDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmVvdStlDt = this.fmVvdStlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tongStlBatJbSeq = this.tongStlBatJbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDt = this.endDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usgRt = this.usgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toVvdStlDt = this.toVvdStlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRgstTongWgt = this.grsRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strDt = this.strDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBsaCapa = this.actBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtYear = this.ctrtYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tongFletTpCd = this.tongFletTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyDys = this.voyDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtStDt = this.ctrtStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chtrBsaCapa = this.chtrBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tongTaxAmt = this.tongTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTonRev = this.perTonRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSvcTpNm = this.vslSvcTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
