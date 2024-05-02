/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SearchAgrdNtwkAllocByAgmtVO.java
*@FileTitle : SearchAgrdNtwkAllocByAgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.25
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.25 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAgrdNtwkAllocByAgmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAgrdNtwkAllocByAgmtVO> models = new ArrayList<SearchAgrdNtwkAllocByAgmtVO>();
	
	/* Column Info */
	private String ovrUsdAlocChgFlg = null;
	/* Column Info */
	private String fmIocCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmSkdVoyNo = null;
	/* Column Info */
	private String agrdExpnAmt = null;
	/* Column Info */
	private String fmVvd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String fmCostWk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String chtOutAmt = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String bzcAlocFxAmt = null;
	/* Column Info */
	private String agrdTeu = null;
	/* Column Info */
	private String toRlaneCd = null;
	/* Column Info */
	private String toCostWk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmRlaneCd = null;
	/* Column Info */
	private String ovrUsdAmt = null;
	/* Column Info */
	private String fmVslCd = null;
	/* Column Info */
	private String ovrTeu = null;
	/* Column Info */
	private String fxExpnAmt = null;
	/* Column Info */
	private String smlSlsAmt = null;
	/* Column Info */
	private String ratFlg = null;
	/* Column Info */
	private String fmDirCd = null;
	/* Column Info */
	private String rto = null;
	/* Column Info */
	private String fxAmtFlg = null;
	/* Column Info */
	private String fmTrdCd = null;
	/* Column Info */
	private String tsUcAmt = null;
	/* Column Info */
	private String bsa = null;
	/* Column Info */
	private String loclTsStsCd = null;
	/* Column Info */
	private String toSkdVoyNo = null;
	/* Column Info */
	private String toIocCd = null;
	/* Column Info */
	private String ovrSltPrc = null;
	/* Column Info */
	private String toVslCd = null;
	/* Column Info */
	private String toTrdCd = null;
	/* Column Info */
	private String tsTeu = null;
	/* Column Info */
	private String ovrUsdAlocChgRto = null;
	/* Column Info */
	private String toDirCd = null;
	/* Column Info */
	private String toVvd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchAgrdNtwkAllocByAgmtVO() {}

	public SearchAgrdNtwkAllocByAgmtVO(String ibflag, String pagerows, String costYrmon, String fmCostWk, String fmTrdCd, String fmRlaneCd, String fmIocCd, String fmVslCd, String fmSkdVoyNo, String fmDirCd, String fmVvd, String tsUcAmt, String smlSlsAmt, String chtOutAmt, String toCostWk, String toTrdCd, String toRlaneCd, String toIocCd, String toVslCd, String toSkdVoyNo, String toDirCd, String toVvd, String loclTsStsCd, String ratFlg, String fxAmtFlg, String ovrUsdAlocChgFlg, String bsa, String rto, String agrdTeu, String tsTeu, String ovrTeu, String ovrUsdAlocChgRto, String ovrSltPrc, String bzcAlocFxAmt, String agrdExpnAmt, String ovrUsdAmt, String fxExpnAmt, String creUsrId, String updUsrId) {
		this.ovrUsdAlocChgFlg = ovrUsdAlocChgFlg;
		this.fmIocCd = fmIocCd;
		this.ibflag = ibflag;
		this.fmSkdVoyNo = fmSkdVoyNo;
		this.agrdExpnAmt = agrdExpnAmt;
		this.fmVvd = fmVvd;
		this.updUsrId = updUsrId;
		this.fmCostWk = fmCostWk;
		this.creUsrId = creUsrId;
		this.chtOutAmt = chtOutAmt;
		this.costYrmon = costYrmon;
		this.bzcAlocFxAmt = bzcAlocFxAmt;
		this.agrdTeu = agrdTeu;
		this.toRlaneCd = toRlaneCd;
		this.toCostWk = toCostWk;
		this.pagerows = pagerows;
		this.fmRlaneCd = fmRlaneCd;
		this.ovrUsdAmt = ovrUsdAmt;
		this.fmVslCd = fmVslCd;
		this.ovrTeu = ovrTeu;
		this.fxExpnAmt = fxExpnAmt;
		this.smlSlsAmt = smlSlsAmt;
		this.ratFlg = ratFlg;
		this.fmDirCd = fmDirCd;
		this.rto = rto;
		this.fxAmtFlg = fxAmtFlg;
		this.fmTrdCd = fmTrdCd;
		this.tsUcAmt = tsUcAmt;
		this.bsa = bsa;
		this.loclTsStsCd = loclTsStsCd;
		this.toSkdVoyNo = toSkdVoyNo;
		this.toIocCd = toIocCd;
		this.ovrSltPrc = ovrSltPrc;
		this.toVslCd = toVslCd;
		this.toTrdCd = toTrdCd;
		this.tsTeu = tsTeu;
		this.ovrUsdAlocChgRto = ovrUsdAlocChgRto;
		this.toDirCd = toDirCd;
		this.toVvd = toVvd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ovr_usd_aloc_chg_flg", getOvrUsdAlocChgFlg());
		this.hashColumns.put("fm_ioc_cd", getFmIocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_skd_voy_no", getFmSkdVoyNo());
		this.hashColumns.put("agrd_expn_amt", getAgrdExpnAmt());
		this.hashColumns.put("fm_vvd", getFmVvd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("fm_cost_wk", getFmCostWk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cht_out_amt", getChtOutAmt());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("bzc_aloc_fx_amt", getBzcAlocFxAmt());
		this.hashColumns.put("agrd_teu", getAgrdTeu());
		this.hashColumns.put("to_rlane_cd", getToRlaneCd());
		this.hashColumns.put("to_cost_wk", getToCostWk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fm_rlane_cd", getFmRlaneCd());
		this.hashColumns.put("ovr_usd_amt", getOvrUsdAmt());
		this.hashColumns.put("fm_vsl_cd", getFmVslCd());
		this.hashColumns.put("ovr_teu", getOvrTeu());
		this.hashColumns.put("fx_expn_amt", getFxExpnAmt());
		this.hashColumns.put("sml_sls_amt", getSmlSlsAmt());
		this.hashColumns.put("rat_flg", getRatFlg());
		this.hashColumns.put("fm_dir_cd", getFmDirCd());
		this.hashColumns.put("rto", getRto());
		this.hashColumns.put("fx_amt_flg", getFxAmtFlg());
		this.hashColumns.put("fm_trd_cd", getFmTrdCd());
		this.hashColumns.put("ts_uc_amt", getTsUcAmt());
		this.hashColumns.put("bsa", getBsa());
		this.hashColumns.put("locl_ts_sts_cd", getLoclTsStsCd());
		this.hashColumns.put("to_skd_voy_no", getToSkdVoyNo());
		this.hashColumns.put("to_ioc_cd", getToIocCd());
		this.hashColumns.put("ovr_slt_prc", getOvrSltPrc());
		this.hashColumns.put("to_vsl_cd", getToVslCd());
		this.hashColumns.put("to_trd_cd", getToTrdCd());
		this.hashColumns.put("ts_teu", getTsTeu());
		this.hashColumns.put("ovr_usd_aloc_chg_rto", getOvrUsdAlocChgRto());
		this.hashColumns.put("to_dir_cd", getToDirCd());
		this.hashColumns.put("to_vvd", getToVvd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ovr_usd_aloc_chg_flg", "ovrUsdAlocChgFlg");
		this.hashFields.put("fm_ioc_cd", "fmIocCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_skd_voy_no", "fmSkdVoyNo");
		this.hashFields.put("agrd_expn_amt", "agrdExpnAmt");
		this.hashFields.put("fm_vvd", "fmVvd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("fm_cost_wk", "fmCostWk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cht_out_amt", "chtOutAmt");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("bzc_aloc_fx_amt", "bzcAlocFxAmt");
		this.hashFields.put("agrd_teu", "agrdTeu");
		this.hashFields.put("to_rlane_cd", "toRlaneCd");
		this.hashFields.put("to_cost_wk", "toCostWk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fm_rlane_cd", "fmRlaneCd");
		this.hashFields.put("ovr_usd_amt", "ovrUsdAmt");
		this.hashFields.put("fm_vsl_cd", "fmVslCd");
		this.hashFields.put("ovr_teu", "ovrTeu");
		this.hashFields.put("fx_expn_amt", "fxExpnAmt");
		this.hashFields.put("sml_sls_amt", "smlSlsAmt");
		this.hashFields.put("rat_flg", "ratFlg");
		this.hashFields.put("fm_dir_cd", "fmDirCd");
		this.hashFields.put("rto", "rto");
		this.hashFields.put("fx_amt_flg", "fxAmtFlg");
		this.hashFields.put("fm_trd_cd", "fmTrdCd");
		this.hashFields.put("ts_uc_amt", "tsUcAmt");
		this.hashFields.put("bsa", "bsa");
		this.hashFields.put("locl_ts_sts_cd", "loclTsStsCd");
		this.hashFields.put("to_skd_voy_no", "toSkdVoyNo");
		this.hashFields.put("to_ioc_cd", "toIocCd");
		this.hashFields.put("ovr_slt_prc", "ovrSltPrc");
		this.hashFields.put("to_vsl_cd", "toVslCd");
		this.hashFields.put("to_trd_cd", "toTrdCd");
		this.hashFields.put("ts_teu", "tsTeu");
		this.hashFields.put("ovr_usd_aloc_chg_rto", "ovrUsdAlocChgRto");
		this.hashFields.put("to_dir_cd", "toDirCd");
		this.hashFields.put("to_vvd", "toVvd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ovrUsdAlocChgFlg
	 */
	public String getOvrUsdAlocChgFlg() {
		return this.ovrUsdAlocChgFlg;
	}
	
	/**
	 * Column Info
	 * @return fmIocCd
	 */
	public String getFmIocCd() {
		return this.fmIocCd;
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
	 * @return fmSkdVoyNo
	 */
	public String getFmSkdVoyNo() {
		return this.fmSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return agrdExpnAmt
	 */
	public String getAgrdExpnAmt() {
		return this.agrdExpnAmt;
	}
	
	/**
	 * Column Info
	 * @return fmVvd
	 */
	public String getFmVvd() {
		return this.fmVvd;
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
	 * @return fmCostWk
	 */
	public String getFmCostWk() {
		return this.fmCostWk;
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
	 * @return chtOutAmt
	 */
	public String getChtOutAmt() {
		return this.chtOutAmt;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return bzcAlocFxAmt
	 */
	public String getBzcAlocFxAmt() {
		return this.bzcAlocFxAmt;
	}
	
	/**
	 * Column Info
	 * @return agrdTeu
	 */
	public String getAgrdTeu() {
		return this.agrdTeu;
	}
	
	/**
	 * Column Info
	 * @return toRlaneCd
	 */
	public String getToRlaneCd() {
		return this.toRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return toCostWk
	 */
	public String getToCostWk() {
		return this.toCostWk;
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
	 * @return fmRlaneCd
	 */
	public String getFmRlaneCd() {
		return this.fmRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return ovrUsdAmt
	 */
	public String getOvrUsdAmt() {
		return this.ovrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return fmVslCd
	 */
	public String getFmVslCd() {
		return this.fmVslCd;
	}
	
	/**
	 * Column Info
	 * @return ovrTeu
	 */
	public String getOvrTeu() {
		return this.ovrTeu;
	}
	
	/**
	 * Column Info
	 * @return fxExpnAmt
	 */
	public String getFxExpnAmt() {
		return this.fxExpnAmt;
	}
	
	/**
	 * Column Info
	 * @return smlSlsAmt
	 */
	public String getSmlSlsAmt() {
		return this.smlSlsAmt;
	}
	
	/**
	 * Column Info
	 * @return ratFlg
	 */
	public String getRatFlg() {
		return this.ratFlg;
	}
	
	/**
	 * Column Info
	 * @return fmDirCd
	 */
	public String getFmDirCd() {
		return this.fmDirCd;
	}
	
	/**
	 * Column Info
	 * @return rto
	 */
	public String getRto() {
		return this.rto;
	}
	
	/**
	 * Column Info
	 * @return fxAmtFlg
	 */
	public String getFxAmtFlg() {
		return this.fxAmtFlg;
	}
	
	/**
	 * Column Info
	 * @return fmTrdCd
	 */
	public String getFmTrdCd() {
		return this.fmTrdCd;
	}
	
	/**
	 * Column Info
	 * @return tsUcAmt
	 */
	public String getTsUcAmt() {
		return this.tsUcAmt;
	}
	
	/**
	 * Column Info
	 * @return bsa
	 */
	public String getBsa() {
		return this.bsa;
	}
	
	/**
	 * Column Info
	 * @return loclTsStsCd
	 */
	public String getLoclTsStsCd() {
		return this.loclTsStsCd;
	}
	
	/**
	 * Column Info
	 * @return toSkdVoyNo
	 */
	public String getToSkdVoyNo() {
		return this.toSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return toIocCd
	 */
	public String getToIocCd() {
		return this.toIocCd;
	}
	
	/**
	 * Column Info
	 * @return ovrSltPrc
	 */
	public String getOvrSltPrc() {
		return this.ovrSltPrc;
	}
	
	/**
	 * Column Info
	 * @return toVslCd
	 */
	public String getToVslCd() {
		return this.toVslCd;
	}
	
	/**
	 * Column Info
	 * @return toTrdCd
	 */
	public String getToTrdCd() {
		return this.toTrdCd;
	}
	
	/**
	 * Column Info
	 * @return tsTeu
	 */
	public String getTsTeu() {
		return this.tsTeu;
	}
	
	/**
	 * Column Info
	 * @return ovrUsdAlocChgRto
	 */
	public String getOvrUsdAlocChgRto() {
		return this.ovrUsdAlocChgRto;
	}
	
	/**
	 * Column Info
	 * @return toDirCd
	 */
	public String getToDirCd() {
		return this.toDirCd;
	}
	
	/**
	 * Column Info
	 * @return toVvd
	 */
	public String getToVvd() {
		return this.toVvd;
	}
	

	/**
	 * Column Info
	 * @param ovrUsdAlocChgFlg
	 */
	public void setOvrUsdAlocChgFlg(String ovrUsdAlocChgFlg) {
		this.ovrUsdAlocChgFlg = ovrUsdAlocChgFlg;
	}
	
	/**
	 * Column Info
	 * @param fmIocCd
	 */
	public void setFmIocCd(String fmIocCd) {
		this.fmIocCd = fmIocCd;
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
	 * @param fmSkdVoyNo
	 */
	public void setFmSkdVoyNo(String fmSkdVoyNo) {
		this.fmSkdVoyNo = fmSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param agrdExpnAmt
	 */
	public void setAgrdExpnAmt(String agrdExpnAmt) {
		this.agrdExpnAmt = agrdExpnAmt;
	}
	
	/**
	 * Column Info
	 * @param fmVvd
	 */
	public void setFmVvd(String fmVvd) {
		this.fmVvd = fmVvd;
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
	 * @param fmCostWk
	 */
	public void setFmCostWk(String fmCostWk) {
		this.fmCostWk = fmCostWk;
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
	 * @param chtOutAmt
	 */
	public void setChtOutAmt(String chtOutAmt) {
		this.chtOutAmt = chtOutAmt;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param bzcAlocFxAmt
	 */
	public void setBzcAlocFxAmt(String bzcAlocFxAmt) {
		this.bzcAlocFxAmt = bzcAlocFxAmt;
	}
	
	/**
	 * Column Info
	 * @param agrdTeu
	 */
	public void setAgrdTeu(String agrdTeu) {
		this.agrdTeu = agrdTeu;
	}
	
	/**
	 * Column Info
	 * @param toRlaneCd
	 */
	public void setToRlaneCd(String toRlaneCd) {
		this.toRlaneCd = toRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param toCostWk
	 */
	public void setToCostWk(String toCostWk) {
		this.toCostWk = toCostWk;
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
	 * @param fmRlaneCd
	 */
	public void setFmRlaneCd(String fmRlaneCd) {
		this.fmRlaneCd = fmRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param ovrUsdAmt
	 */
	public void setOvrUsdAmt(String ovrUsdAmt) {
		this.ovrUsdAmt = ovrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param fmVslCd
	 */
	public void setFmVslCd(String fmVslCd) {
		this.fmVslCd = fmVslCd;
	}
	
	/**
	 * Column Info
	 * @param ovrTeu
	 */
	public void setOvrTeu(String ovrTeu) {
		this.ovrTeu = ovrTeu;
	}
	
	/**
	 * Column Info
	 * @param fxExpnAmt
	 */
	public void setFxExpnAmt(String fxExpnAmt) {
		this.fxExpnAmt = fxExpnAmt;
	}
	
	/**
	 * Column Info
	 * @param smlSlsAmt
	 */
	public void setSmlSlsAmt(String smlSlsAmt) {
		this.smlSlsAmt = smlSlsAmt;
	}
	
	/**
	 * Column Info
	 * @param ratFlg
	 */
	public void setRatFlg(String ratFlg) {
		this.ratFlg = ratFlg;
	}
	
	/**
	 * Column Info
	 * @param fmDirCd
	 */
	public void setFmDirCd(String fmDirCd) {
		this.fmDirCd = fmDirCd;
	}
	
	/**
	 * Column Info
	 * @param rto
	 */
	public void setRto(String rto) {
		this.rto = rto;
	}
	
	/**
	 * Column Info
	 * @param fxAmtFlg
	 */
	public void setFxAmtFlg(String fxAmtFlg) {
		this.fxAmtFlg = fxAmtFlg;
	}
	
	/**
	 * Column Info
	 * @param fmTrdCd
	 */
	public void setFmTrdCd(String fmTrdCd) {
		this.fmTrdCd = fmTrdCd;
	}
	
	/**
	 * Column Info
	 * @param tsUcAmt
	 */
	public void setTsUcAmt(String tsUcAmt) {
		this.tsUcAmt = tsUcAmt;
	}
	
	/**
	 * Column Info
	 * @param bsa
	 */
	public void setBsa(String bsa) {
		this.bsa = bsa;
	}
	
	/**
	 * Column Info
	 * @param loclTsStsCd
	 */
	public void setLoclTsStsCd(String loclTsStsCd) {
		this.loclTsStsCd = loclTsStsCd;
	}
	
	/**
	 * Column Info
	 * @param toSkdVoyNo
	 */
	public void setToSkdVoyNo(String toSkdVoyNo) {
		this.toSkdVoyNo = toSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param toIocCd
	 */
	public void setToIocCd(String toIocCd) {
		this.toIocCd = toIocCd;
	}
	
	/**
	 * Column Info
	 * @param ovrSltPrc
	 */
	public void setOvrSltPrc(String ovrSltPrc) {
		this.ovrSltPrc = ovrSltPrc;
	}
	
	/**
	 * Column Info
	 * @param toVslCd
	 */
	public void setToVslCd(String toVslCd) {
		this.toVslCd = toVslCd;
	}
	
	/**
	 * Column Info
	 * @param toTrdCd
	 */
	public void setToTrdCd(String toTrdCd) {
		this.toTrdCd = toTrdCd;
	}
	
	/**
	 * Column Info
	 * @param tsTeu
	 */
	public void setTsTeu(String tsTeu) {
		this.tsTeu = tsTeu;
	}
	
	/**
	 * Column Info
	 * @param ovrUsdAlocChgRto
	 */
	public void setOvrUsdAlocChgRto(String ovrUsdAlocChgRto) {
		this.ovrUsdAlocChgRto = ovrUsdAlocChgRto;
	}
	
	/**
	 * Column Info
	 * @param toDirCd
	 */
	public void setToDirCd(String toDirCd) {
		this.toDirCd = toDirCd;
	}
	
	/**
	 * Column Info
	 * @param toVvd
	 */
	public void setToVvd(String toVvd) {
		this.toVvd = toVvd;
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
		setOvrUsdAlocChgFlg(JSPUtil.getParameter(request, prefix + "ovr_usd_aloc_chg_flg", ""));
		setFmIocCd(JSPUtil.getParameter(request, prefix + "fm_ioc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmSkdVoyNo(JSPUtil.getParameter(request, prefix + "fm_skd_voy_no", ""));
		setAgrdExpnAmt(JSPUtil.getParameter(request, prefix + "agrd_expn_amt", ""));
		setFmVvd(JSPUtil.getParameter(request, prefix + "fm_vvd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFmCostWk(JSPUtil.getParameter(request, prefix + "fm_cost_wk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setChtOutAmt(JSPUtil.getParameter(request, prefix + "cht_out_amt", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setBzcAlocFxAmt(JSPUtil.getParameter(request, prefix + "bzc_aloc_fx_amt", ""));
		setAgrdTeu(JSPUtil.getParameter(request, prefix + "agrd_teu", ""));
		setToRlaneCd(JSPUtil.getParameter(request, prefix + "to_rlane_cd", ""));
		setToCostWk(JSPUtil.getParameter(request, prefix + "to_cost_wk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFmRlaneCd(JSPUtil.getParameter(request, prefix + "fm_rlane_cd", ""));
		setOvrUsdAmt(JSPUtil.getParameter(request, prefix + "ovr_usd_amt", ""));
		setFmVslCd(JSPUtil.getParameter(request, prefix + "fm_vsl_cd", ""));
		setOvrTeu(JSPUtil.getParameter(request, prefix + "ovr_teu", ""));
		setFxExpnAmt(JSPUtil.getParameter(request, prefix + "fx_expn_amt", ""));
		setSmlSlsAmt(JSPUtil.getParameter(request, prefix + "sml_sls_amt", ""));
		setRatFlg(JSPUtil.getParameter(request, prefix + "rat_flg", ""));
		setFmDirCd(JSPUtil.getParameter(request, prefix + "fm_dir_cd", ""));
		setRto(JSPUtil.getParameter(request, prefix + "rto", ""));
		setFxAmtFlg(JSPUtil.getParameter(request, prefix + "fx_amt_flg", ""));
		setFmTrdCd(JSPUtil.getParameter(request, prefix + "fm_trd_cd", ""));
		setTsUcAmt(JSPUtil.getParameter(request, prefix + "ts_uc_amt", ""));
		setBsa(JSPUtil.getParameter(request, prefix + "bsa", ""));
		setLoclTsStsCd(JSPUtil.getParameter(request, prefix + "locl_ts_sts_cd", ""));
		setToSkdVoyNo(JSPUtil.getParameter(request, prefix + "to_skd_voy_no", ""));
		setToIocCd(JSPUtil.getParameter(request, prefix + "to_ioc_cd", ""));
		setOvrSltPrc(JSPUtil.getParameter(request, prefix + "ovr_slt_prc", ""));
		setToVslCd(JSPUtil.getParameter(request, prefix + "to_vsl_cd", ""));
		setToTrdCd(JSPUtil.getParameter(request, prefix + "to_trd_cd", ""));
		setTsTeu(JSPUtil.getParameter(request, prefix + "ts_teu", ""));
		setOvrUsdAlocChgRto(JSPUtil.getParameter(request, prefix + "ovr_usd_aloc_chg_rto", ""));
		setToDirCd(JSPUtil.getParameter(request, prefix + "to_dir_cd", ""));
		setToVvd(JSPUtil.getParameter(request, prefix + "to_vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAgrdNtwkAllocByAgmtVO[]
	 */
	public SearchAgrdNtwkAllocByAgmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAgrdNtwkAllocByAgmtVO[]
	 */
	public SearchAgrdNtwkAllocByAgmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAgrdNtwkAllocByAgmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ovrUsdAlocChgFlg = (JSPUtil.getParameter(request, prefix	+ "ovr_usd_aloc_chg_flg", length));
			String[] fmIocCd = (JSPUtil.getParameter(request, prefix	+ "fm_ioc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "fm_skd_voy_no", length));
			String[] agrdExpnAmt = (JSPUtil.getParameter(request, prefix	+ "agrd_expn_amt", length));
			String[] fmVvd = (JSPUtil.getParameter(request, prefix	+ "fm_vvd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fmCostWk = (JSPUtil.getParameter(request, prefix	+ "fm_cost_wk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] chtOutAmt = (JSPUtil.getParameter(request, prefix	+ "cht_out_amt", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] bzcAlocFxAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_aloc_fx_amt", length));
			String[] agrdTeu = (JSPUtil.getParameter(request, prefix	+ "agrd_teu", length));
			String[] toRlaneCd = (JSPUtil.getParameter(request, prefix	+ "to_rlane_cd", length));
			String[] toCostWk = (JSPUtil.getParameter(request, prefix	+ "to_cost_wk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmRlaneCd = (JSPUtil.getParameter(request, prefix	+ "fm_rlane_cd", length));
			String[] ovrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ovr_usd_amt", length));
			String[] fmVslCd = (JSPUtil.getParameter(request, prefix	+ "fm_vsl_cd", length));
			String[] ovrTeu = (JSPUtil.getParameter(request, prefix	+ "ovr_teu", length));
			String[] fxExpnAmt = (JSPUtil.getParameter(request, prefix	+ "fx_expn_amt", length));
			String[] smlSlsAmt = (JSPUtil.getParameter(request, prefix	+ "sml_sls_amt", length));
			String[] ratFlg = (JSPUtil.getParameter(request, prefix	+ "rat_flg", length));
			String[] fmDirCd = (JSPUtil.getParameter(request, prefix	+ "fm_dir_cd", length));
			String[] rto = (JSPUtil.getParameter(request, prefix	+ "rto", length));
			String[] fxAmtFlg = (JSPUtil.getParameter(request, prefix	+ "fx_amt_flg", length));
			String[] fmTrdCd = (JSPUtil.getParameter(request, prefix	+ "fm_trd_cd", length));
			String[] tsUcAmt = (JSPUtil.getParameter(request, prefix	+ "ts_uc_amt", length));
			String[] bsa = (JSPUtil.getParameter(request, prefix	+ "bsa", length));
			String[] loclTsStsCd = (JSPUtil.getParameter(request, prefix	+ "locl_ts_sts_cd", length));
			String[] toSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "to_skd_voy_no", length));
			String[] toIocCd = (JSPUtil.getParameter(request, prefix	+ "to_ioc_cd", length));
			String[] ovrSltPrc = (JSPUtil.getParameter(request, prefix	+ "ovr_slt_prc", length));
			String[] toVslCd = (JSPUtil.getParameter(request, prefix	+ "to_vsl_cd", length));
			String[] toTrdCd = (JSPUtil.getParameter(request, prefix	+ "to_trd_cd", length));
			String[] tsTeu = (JSPUtil.getParameter(request, prefix	+ "ts_teu", length));
			String[] ovrUsdAlocChgRto = (JSPUtil.getParameter(request, prefix	+ "ovr_usd_aloc_chg_rto", length));
			String[] toDirCd = (JSPUtil.getParameter(request, prefix	+ "to_dir_cd", length));
			String[] toVvd = (JSPUtil.getParameter(request, prefix	+ "to_vvd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAgrdNtwkAllocByAgmtVO();
				if (ovrUsdAlocChgFlg[i] != null)
					model.setOvrUsdAlocChgFlg(ovrUsdAlocChgFlg[i]);
				if (fmIocCd[i] != null)
					model.setFmIocCd(fmIocCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmSkdVoyNo[i] != null)
					model.setFmSkdVoyNo(fmSkdVoyNo[i]);
				if (agrdExpnAmt[i] != null)
					model.setAgrdExpnAmt(agrdExpnAmt[i]);
				if (fmVvd[i] != null)
					model.setFmVvd(fmVvd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (fmCostWk[i] != null)
					model.setFmCostWk(fmCostWk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (chtOutAmt[i] != null)
					model.setChtOutAmt(chtOutAmt[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (bzcAlocFxAmt[i] != null)
					model.setBzcAlocFxAmt(bzcAlocFxAmt[i]);
				if (agrdTeu[i] != null)
					model.setAgrdTeu(agrdTeu[i]);
				if (toRlaneCd[i] != null)
					model.setToRlaneCd(toRlaneCd[i]);
				if (toCostWk[i] != null)
					model.setToCostWk(toCostWk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmRlaneCd[i] != null)
					model.setFmRlaneCd(fmRlaneCd[i]);
				if (ovrUsdAmt[i] != null)
					model.setOvrUsdAmt(ovrUsdAmt[i]);
				if (fmVslCd[i] != null)
					model.setFmVslCd(fmVslCd[i]);
				if (ovrTeu[i] != null)
					model.setOvrTeu(ovrTeu[i]);
				if (fxExpnAmt[i] != null)
					model.setFxExpnAmt(fxExpnAmt[i]);
				if (smlSlsAmt[i] != null)
					model.setSmlSlsAmt(smlSlsAmt[i]);
				if (ratFlg[i] != null)
					model.setRatFlg(ratFlg[i]);
				if (fmDirCd[i] != null)
					model.setFmDirCd(fmDirCd[i]);
				if (rto[i] != null)
					model.setRto(rto[i]);
				if (fxAmtFlg[i] != null)
					model.setFxAmtFlg(fxAmtFlg[i]);
				if (fmTrdCd[i] != null)
					model.setFmTrdCd(fmTrdCd[i]);
				if (tsUcAmt[i] != null)
					model.setTsUcAmt(tsUcAmt[i]);
				if (bsa[i] != null)
					model.setBsa(bsa[i]);
				if (loclTsStsCd[i] != null)
					model.setLoclTsStsCd(loclTsStsCd[i]);
				if (toSkdVoyNo[i] != null)
					model.setToSkdVoyNo(toSkdVoyNo[i]);
				if (toIocCd[i] != null)
					model.setToIocCd(toIocCd[i]);
				if (ovrSltPrc[i] != null)
					model.setOvrSltPrc(ovrSltPrc[i]);
				if (toVslCd[i] != null)
					model.setToVslCd(toVslCd[i]);
				if (toTrdCd[i] != null)
					model.setToTrdCd(toTrdCd[i]);
				if (tsTeu[i] != null)
					model.setTsTeu(tsTeu[i]);
				if (ovrUsdAlocChgRto[i] != null)
					model.setOvrUsdAlocChgRto(ovrUsdAlocChgRto[i]);
				if (toDirCd[i] != null)
					model.setToDirCd(toDirCd[i]);
				if (toVvd[i] != null)
					model.setToVvd(toVvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAgrdNtwkAllocByAgmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAgrdNtwkAllocByAgmtVO[]
	 */
	public SearchAgrdNtwkAllocByAgmtVO[] getSearchAgrdNtwkAllocByAgmtVOs(){
		SearchAgrdNtwkAllocByAgmtVO[] vos = (SearchAgrdNtwkAllocByAgmtVO[])models.toArray(new SearchAgrdNtwkAllocByAgmtVO[models.size()]);
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
		this.ovrUsdAlocChgFlg = this.ovrUsdAlocChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmIocCd = this.fmIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmSkdVoyNo = this.fmSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agrdExpnAmt = this.agrdExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmVvd = this.fmVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCostWk = this.fmCostWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chtOutAmt = this.chtOutAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAlocFxAmt = this.bzcAlocFxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agrdTeu = this.agrdTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRlaneCd = this.toRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCostWk = this.toCostWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRlaneCd = this.fmRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrUsdAmt = this.ovrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmVslCd = this.fmVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrTeu = this.ovrTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxExpnAmt = this.fxExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smlSlsAmt = this.smlSlsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratFlg = this.ratFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDirCd = this.fmDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rto = this.rto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxAmtFlg = this.fxAmtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTrdCd = this.fmTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsUcAmt = this.tsUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa = this.bsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTsStsCd = this.loclTsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSkdVoyNo = this.toSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toIocCd = this.toIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrSltPrc = this.ovrSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toVslCd = this.toVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTrdCd = this.toTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsTeu = this.tsTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrUsdAlocChgRto = this.ovrUsdAlocChgRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDirCd = this.toDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toVvd = this.toVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
