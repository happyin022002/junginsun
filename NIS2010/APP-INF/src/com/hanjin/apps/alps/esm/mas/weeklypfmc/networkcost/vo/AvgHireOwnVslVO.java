/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AvgHireOwnVslVO.java
*@FileTitle : AvgHireOwnVslVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.01.08 유제량 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo;

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
 * @author 유제량
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AvgHireOwnVslVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AvgHireOwnVslVO> models = new ArrayList<AvgHireOwnVslVO>();
	
	/* Column Info */
	private String pErrorCode = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String fYearweek = null;
	/* Column Info */
	private String fMon = null;
	/* Column Info */
	private String ownVslRmk = null;
	/* Column Info */
	private String fDirCd = null;
	/* Column Info */
	private String fYrtype = null;
	/* Column Info */
	private String fDur = null;
	/* Column Info */
	private String ttlCost = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String effToYrmon = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String fSyearmonth = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String effFmToYrmon = null;
	/* Column Info */
	private String stndCostCd = null;
	/* Column Info */
	private String effFmYrmon = null;
	/* Column Info */
	private String hbCost = null;
	/* Column Info */
	private String finCost = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String addhbCost = null;
	/* Column Info */
	private String fYearwk = null;
	/* Column Info */
	private String fTrdCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String comDtrbAmt = null;
	/* Column Info */
	private String fRlaneCd = null;
	/* Column Info */
	private String tabItem = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String vslClssCapa = null;
	/* Column Info */
	private String vslAmt = null;
	/* Column Info */
	private String fSelvessel = null;
	/* Column Info */
	private String fYear = null;
	/* Column Info */
	private String creAmt = null;
	/* Column Info */
	private String insAmt = null;
	/* Column Info */
	private String stoAmt = null;
	/* Column Info */
	private String lubAmt = null;
	/* Column Info */
	private String mnrAmt = null;
	/* Column Info */
	private String depAmt = null;
	/* Column Info */
	private String telAmt = null;
	/* Column Info */
	private String otrAmt = null;
	/* Column Info */
	private String ttlAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AvgHireOwnVslVO() {}

	public AvgHireOwnVslVO(String ibflag, String pagerows, String cntCd, String costYrmon, String costWk, String vslCd, String vslClssCapa, String effFmToYrmon, String vslAmt, String comDtrbAmt, String ttlCost, String hbCost, String addhbCost, String finCost, String updUsrId, String fYrtype, String fYearweek, String fSelvessel, String fYear, String fMon, String fDur, String tabItem, String fYearwk, String fFmWk, String stndCostCd, String pErrorCode, String fSyearmonth, String fRlaneCd, String fTrdCd, String fDirCd, String ownVslRmk, String creUsrId, String effFmYrmon, String effToYrmon, String creAmt, String insAmt, String stoAmt, String lubAmt, String mnrAmt, String depAmt, String telAmt, String otrAmt, String ttlAmt) {
		this.pErrorCode = pErrorCode;
		this.vslCd = vslCd;
		this.fYearweek = fYearweek;
		this.fMon = fMon;
		this.ownVslRmk = ownVslRmk;
		this.fDirCd = fDirCd;
		this.fYrtype = fYrtype;
		this.fDur = fDur;
		this.ttlCost = ttlCost;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.effToYrmon = effToYrmon;
		this.cntCd = cntCd;
		this.fSyearmonth = fSyearmonth;
		this.updUsrId = updUsrId;
		this.effFmToYrmon = effFmToYrmon;
		this.stndCostCd = stndCostCd;
		this.effFmYrmon = effFmYrmon;
		this.hbCost = hbCost;
		this.finCost = finCost;
		this.fFmWk = fFmWk;
		this.addhbCost = addhbCost;
		this.fYearwk = fYearwk;
		this.fTrdCd = fTrdCd;
		this.creUsrId = creUsrId;
		this.comDtrbAmt = comDtrbAmt;
		this.fRlaneCd = fRlaneCd;
		this.tabItem = tabItem;
		this.costWk = costWk;
		this.vslClssCapa = vslClssCapa;
		this.vslAmt = vslAmt;
		this.fSelvessel = fSelvessel;
		this.fYear = fYear;
		this.creAmt = creAmt;
		this.insAmt = insAmt;
		this.stoAmt = stoAmt;
		this.lubAmt = lubAmt;
		this.mnrAmt = mnrAmt;
		this.depAmt = depAmt;
		this.telAmt = telAmt;
		this.otrAmt = otrAmt;
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("p_error_code", getPErrorCode());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("f_yearweek", getFYearweek());
		this.hashColumns.put("f_mon", getFMon());
		this.hashColumns.put("own_vsl_rmk", getOwnVslRmk());
		this.hashColumns.put("f_dir_cd", getFDirCd());
		this.hashColumns.put("f_yrtype", getFYrtype());
		this.hashColumns.put("f_dur", getFDur());
		this.hashColumns.put("ttl_cost", getTtlCost());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("eff_to_yrmon", getEffToYrmon());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("f_syearmonth", getFSyearmonth());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("eff_fm_to_yrmon", getEffFmToYrmon());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		this.hashColumns.put("eff_fm_yrmon", getEffFmYrmon());
		this.hashColumns.put("hb_cost", getHbCost());
		this.hashColumns.put("fin_cost", getFinCost());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("addhb_cost", getAddhbCost());
		this.hashColumns.put("f_yearwk", getFYearwk());
		this.hashColumns.put("f_trd_cd", getFTrdCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("com_dtrb_amt", getComDtrbAmt());
		this.hashColumns.put("f_rlane_cd", getFRlaneCd());
		this.hashColumns.put("tab_item", getTabItem());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("vsl_amt", getVslAmt());
		this.hashColumns.put("f_selvessel", getFSelvessel());
		this.hashColumns.put("f_year", getFYear());
		this.hashColumns.put("cre_amt", getCreAmt());
		this.hashColumns.put("ins_amt", getInsAmt());
		this.hashColumns.put("sto_amt", getStoAmt());
		this.hashColumns.put("lub_amt", getLubAmt());
		this.hashColumns.put("mnr_amt", getMnrAmt());
		this.hashColumns.put("dep_amt", getDepAmt());
		this.hashColumns.put("tel_amt", getTelAmt());
		this.hashColumns.put("otr_amt", getOtrAmt());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("p_error_code", "pErrorCode");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("f_yearweek", "fYearweek");
		this.hashFields.put("f_mon", "fMon");
		this.hashFields.put("own_vsl_rmk", "ownVslRmk");
		this.hashFields.put("f_dir_cd", "fDirCd");
		this.hashFields.put("f_yrtype", "fYrtype");
		this.hashFields.put("f_dur", "fDur");
		this.hashFields.put("ttl_cost", "ttlCost");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("eff_to_yrmon", "effToYrmon");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("f_syearmonth", "fSyearmonth");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eff_fm_to_yrmon", "effFmToYrmon");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		this.hashFields.put("eff_fm_yrmon", "effFmYrmon");
		this.hashFields.put("hb_cost", "hbCost");
		this.hashFields.put("fin_cost", "finCost");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("addhb_cost", "addhbCost");
		this.hashFields.put("f_yearwk", "fYearwk");
		this.hashFields.put("f_trd_cd", "fTrdCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("com_dtrb_amt", "comDtrbAmt");
		this.hashFields.put("f_rlane_cd", "fRlaneCd");
		this.hashFields.put("tab_item", "tabItem");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("vsl_amt", "vslAmt");
		this.hashFields.put("f_selvessel", "fSelvessel");
		this.hashFields.put("f_year", "fYear");
		this.hashFields.put("cre_amt", "creAmt");
		this.hashFields.put("ins_amt", "insAmt");
		this.hashFields.put("sto_amt", "stoAmt");
		this.hashFields.put("lub_amt", "lubAmt");
		this.hashFields.put("mnr_amt", "mnrAmt");
		this.hashFields.put("dep_amt", "depAmt");
		this.hashFields.put("tel_amt", "telAmt");
		this.hashFields.put("otr_amt", "otrAmt");
		this.hashFields.put("ttl_amt", "ttlAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pErrorCode
	 */
	public String getPErrorCode() {
		return this.pErrorCode;
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
	 * @return fYearweek
	 */
	public String getFYearweek() {
		return this.fYearweek;
	}
	
	/**
	 * Column Info
	 * @return fMon
	 */
	public String getFMon() {
		return this.fMon;
	}
	
	/**
	 * Column Info
	 * @return ownVslRmk
	 */
	public String getOwnVslRmk() {
		return this.ownVslRmk;
	}
	
	/**
	 * Column Info
	 * @return fDirCd
	 */
	public String getFDirCd() {
		return this.fDirCd;
	}
	
	/**
	 * Column Info
	 * @return fYrtype
	 */
	public String getFYrtype() {
		return this.fYrtype;
	}
	
	/**
	 * Column Info
	 * @return fDur
	 */
	public String getFDur() {
		return this.fDur;
	}
	
	/**
	 * Column Info
	 * @return ttlCost
	 */
	public String getTtlCost() {
		return this.ttlCost;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return effToYrmon
	 */
	public String getEffToYrmon() {
		return this.effToYrmon;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return fSyearmonth
	 */
	public String getFSyearmonth() {
		return this.fSyearmonth;
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
	 * @return effFmToYrmon
	 */
	public String getEffFmToYrmon() {
		return this.effFmToYrmon;
	}
	
	/**
	 * Column Info
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
	}
	
	/**
	 * Column Info
	 * @return effFmYrmon
	 */
	public String getEffFmYrmon() {
		return this.effFmYrmon;
	}
	
	/**
	 * Column Info
	 * @return hbCost
	 */
	public String getHbCost() {
		return this.hbCost;
	}
	
	/**
	 * Column Info
	 * @return finCost
	 */
	public String getFinCost() {
		return this.finCost;
	}
	
	/**
	 * Column Info
	 * @return fFmWk
	 */
	public String getFFmWk() {
		return this.fFmWk;
	}
	
	/**
	 * Column Info
	 * @return addhbCost
	 */
	public String getAddhbCost() {
		return this.addhbCost;
	}
	
	/**
	 * Column Info
	 * @return fYearwk
	 */
	public String getFYearwk() {
		return this.fYearwk;
	}
	
	/**
	 * Column Info
	 * @return fTrdCd
	 */
	public String getFTrdCd() {
		return this.fTrdCd;
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
	 * @return comDtrbAmt
	 */
	public String getComDtrbAmt() {
		return this.comDtrbAmt;
	}
	
	/**
	 * Column Info
	 * @return fRlaneCd
	 */
	public String getFRlaneCd() {
		return this.fRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return tabItem
	 */
	public String getTabItem() {
		return this.tabItem;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return vslClssCapa
	 */
	public String getVslClssCapa() {
		return this.vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return vslAmt
	 */
	public String getVslAmt() {
		return this.vslAmt;
	}
	
	/**
	 * Column Info
	 * @return fSelvessel
	 */
	public String getFSelvessel() {
		return this.fSelvessel;
	}
	
	/**
	 * Column Info
	 * @return fYear
	 */
	public String getFYear() {
		return this.fYear;
	}
	
	/**
	 * Column Info
	 * @return creAmt
	 */
	public String getCreAmt() {
		return this.creAmt;
	}
	
	/**
	 * Column Info
	 * @return insAmt
	 */
	public String getInsAmt() {
		return this.insAmt;
	}
	
	/**
	 * Column Info
	 * @return stoAmt
	 */
	public String getStoAmt() {
		return this.stoAmt;
	}
	
	/**
	 * Column Info
	 * @return lubAmt
	 */
	public String getLubAmt() {
		return this.lubAmt;
	}
	
	/**
	 * Column Info
	 * @return mnrAmt
	 */
	public String getMnrAmt() {
		return this.mnrAmt;
	}
	
	/**
	 * Column Info
	 * @return depAmt
	 */
	public String getDepAmt() {
		return this.depAmt;
	}
	
	/**
	 * Column Info
	 * @return telAmt
	 */
	public String getTelAmt() {
		return this.telAmt;
	}
	
	/**
	 * Column Info
	 * @return otrAmt
	 */
	public String getOtrAmt() {
		return this.otrAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	

	/**
	 * Column Info
	 * @param pErrorCode
	 */
	public void setPErrorCode(String pErrorCode) {
		this.pErrorCode = pErrorCode;
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
	 * @param fYearweek
	 */
	public void setFYearweek(String fYearweek) {
		this.fYearweek = fYearweek;
	}
	
	/**
	 * Column Info
	 * @param fMon
	 */
	public void setFMon(String fMon) {
		this.fMon = fMon;
	}
	
	/**
	 * Column Info
	 * @param ownVslRmk
	 */
	public void setOwnVslRmk(String ownVslRmk) {
		this.ownVslRmk = ownVslRmk;
	}
	
	/**
	 * Column Info
	 * @param fDirCd
	 */
	public void setFDirCd(String fDirCd) {
		this.fDirCd = fDirCd;
	}
	
	/**
	 * Column Info
	 * @param fYrtype
	 */
	public void setFYrtype(String fYrtype) {
		this.fYrtype = fYrtype;
	}
	
	/**
	 * Column Info
	 * @param fDur
	 */
	public void setFDur(String fDur) {
		this.fDur = fDur;
	}
	
	/**
	 * Column Info
	 * @param ttlCost
	 */
	public void setTtlCost(String ttlCost) {
		this.ttlCost = ttlCost;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param effToYrmon
	 */
	public void setEffToYrmon(String effToYrmon) {
		this.effToYrmon = effToYrmon;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param fSyearmonth
	 */
	public void setFSyearmonth(String fSyearmonth) {
		this.fSyearmonth = fSyearmonth;
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
	 * @param effFmToYrmon
	 */
	public void setEffFmToYrmon(String effFmToYrmon) {
		this.effFmToYrmon = effFmToYrmon;
	}
	
	/**
	 * Column Info
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * Column Info
	 * @param effFmYrmon
	 */
	public void setEffFmYrmon(String effFmYrmon) {
		this.effFmYrmon = effFmYrmon;
	}
	
	/**
	 * Column Info
	 * @param hbCost
	 */
	public void setHbCost(String hbCost) {
		this.hbCost = hbCost;
	}
	
	/**
	 * Column Info
	 * @param finCost
	 */
	public void setFinCost(String finCost) {
		this.finCost = finCost;
	}
	
	/**
	 * Column Info
	 * @param fFmWk
	 */
	public void setFFmWk(String fFmWk) {
		this.fFmWk = fFmWk;
	}
	
	/**
	 * Column Info
	 * @param addhbCost
	 */
	public void setAddhbCost(String addhbCost) {
		this.addhbCost = addhbCost;
	}
	
	/**
	 * Column Info
	 * @param fYearwk
	 */
	public void setFYearwk(String fYearwk) {
		this.fYearwk = fYearwk;
	}
	
	/**
	 * Column Info
	 * @param fTrdCd
	 */
	public void setFTrdCd(String fTrdCd) {
		this.fTrdCd = fTrdCd;
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
	 * @param comDtrbAmt
	 */
	public void setComDtrbAmt(String comDtrbAmt) {
		this.comDtrbAmt = comDtrbAmt;
	}
	
	/**
	 * Column Info
	 * @param fRlaneCd
	 */
	public void setFRlaneCd(String fRlaneCd) {
		this.fRlaneCd = fRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param tabItem
	 */
	public void setTabItem(String tabItem) {
		this.tabItem = tabItem;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param vslClssCapa
	 */
	public void setVslClssCapa(String vslClssCapa) {
		this.vslClssCapa = vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param vslAmt
	 */
	public void setVslAmt(String vslAmt) {
		this.vslAmt = vslAmt;
	}
	
	/**
	 * Column Info
	 * @param fSelvessel
	 */
	public void setFSelvessel(String fSelvessel) {
		this.fSelvessel = fSelvessel;
	}
	
	/**
	 * Column Info
	 * @param fYear
	 */
	public void setFYear(String fYear) {
		this.fYear = fYear;
	}
	
	/**
	 * Column Info
	 * @param creAmt
	 */
	public void setCreAmt(String creAmt) {
		this.creAmt = creAmt;
	}
	
	/**
	 * Column Info
	 * @param insAmt
	 */
	public void setInsAmt(String insAmt) {
		this.insAmt = insAmt;
	}
	
	/**
	 * Column Info
	 * @param stoAmt
	 */
	public void setStoAmt(String stoAmt) {
		this.stoAmt = stoAmt;
	}
	
	/**
	 * Column Info
	 * @param lubAmt
	 */
	public void setLubAmt(String lubAmt) {
		this.lubAmt = lubAmt;
	}
	
	/**
	 * Column Info
	 * @param mnrAmt
	 */
	public void setMnrAmt(String mnrAmt) {
		this.mnrAmt = mnrAmt;
	}
	
	/**
	 * Column Info
	 * @param depAmt
	 */
	public void setDepAmt(String depAmt) {
		this.depAmt = depAmt;
	}
	
	/**
	 * Column Info
	 * @param telAmt
	 */
	public void setTelAmt(String telAmt) {
		this.telAmt = telAmt;
	}
	
	/**
	 * Column Info
	 * @param otrAmt
	 */
	public void setOtrAmt(String otrAmt) {
		this.otrAmt = otrAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
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
		setPErrorCode(JSPUtil.getParameter(request, prefix + "p_error_code", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setFYearweek(JSPUtil.getParameter(request, prefix + "f_yearweek", ""));
		setFMon(JSPUtil.getParameter(request, prefix + "f_mon", ""));
		setOwnVslRmk(JSPUtil.getParameter(request, prefix + "own_vsl_rmk", ""));
		setFDirCd(JSPUtil.getParameter(request, prefix + "f_dir_cd", ""));
		setFYrtype(JSPUtil.getParameter(request, prefix + "f_yrtype", ""));
		setFDur(JSPUtil.getParameter(request, prefix + "f_dur", ""));
		setTtlCost(JSPUtil.getParameter(request, prefix + "ttl_cost", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setEffToYrmon(JSPUtil.getParameter(request, prefix + "eff_to_yrmon", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setFSyearmonth(JSPUtil.getParameter(request, prefix + "f_syearmonth", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEffFmToYrmon(JSPUtil.getParameter(request, prefix + "eff_fm_to_yrmon", ""));
		setStndCostCd(JSPUtil.getParameter(request, prefix + "stnd_cost_cd", ""));
		setEffFmYrmon(JSPUtil.getParameter(request, prefix + "eff_fm_yrmon", ""));
		setHbCost(JSPUtil.getParameter(request, prefix + "hb_cost", ""));
		setFinCost(JSPUtil.getParameter(request, prefix + "fin_cost", ""));
		setFFmWk(JSPUtil.getParameter(request, prefix + "f_fm_wk", ""));
		setAddhbCost(JSPUtil.getParameter(request, prefix + "addhb_cost", ""));
		setFYearwk(JSPUtil.getParameter(request, prefix + "f_yearwk", ""));
		setFTrdCd(JSPUtil.getParameter(request, prefix + "f_trd_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setComDtrbAmt(JSPUtil.getParameter(request, prefix + "com_dtrb_amt", ""));
		setFRlaneCd(JSPUtil.getParameter(request, prefix + "f_rlane_cd", ""));
		setTabItem(JSPUtil.getParameter(request, prefix + "tab_item", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setVslClssCapa(JSPUtil.getParameter(request, prefix + "vsl_clss_capa", ""));
		setVslAmt(JSPUtil.getParameter(request, prefix + "vsl_amt", ""));
		setFSelvessel(JSPUtil.getParameter(request, prefix + "f_selvessel", ""));
		setFYear(JSPUtil.getParameter(request, prefix + "f_year", ""));
		setCreAmt(JSPUtil.getParameter(request, prefix + "cre_amt", ""));
		setInsAmt(JSPUtil.getParameter(request, prefix + "ins_amt", ""));
		setStoAmt(JSPUtil.getParameter(request, prefix + "sto_amt", ""));
		setLubAmt(JSPUtil.getParameter(request, prefix + "lub_amt", ""));
		setMnrAmt(JSPUtil.getParameter(request, prefix + "mnr_amt", ""));
		setDepAmt(JSPUtil.getParameter(request, prefix + "dep_amt", ""));
		setTelAmt(JSPUtil.getParameter(request, prefix + "tel_amt", ""));
		setOtrAmt(JSPUtil.getParameter(request, prefix + "otr_amt", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AvgHireOwnVslVO[]
	 */
	public AvgHireOwnVslVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AvgHireOwnVslVO[]
	 */
	public AvgHireOwnVslVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AvgHireOwnVslVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pErrorCode = (JSPUtil.getParameter(request, prefix	+ "p_error_code", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] fYearweek = (JSPUtil.getParameter(request, prefix	+ "f_yearweek", length));
			String[] fMon = (JSPUtil.getParameter(request, prefix	+ "f_mon", length));
			String[] ownVslRmk = (JSPUtil.getParameter(request, prefix	+ "own_vsl_rmk", length));
			String[] fDirCd = (JSPUtil.getParameter(request, prefix	+ "f_dir_cd", length));
			String[] fYrtype = (JSPUtil.getParameter(request, prefix	+ "f_yrtype", length));
			String[] fDur = (JSPUtil.getParameter(request, prefix	+ "f_dur", length));
			String[] ttlCost = (JSPUtil.getParameter(request, prefix	+ "ttl_cost", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] effToYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_to_yrmon", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] fSyearmonth = (JSPUtil.getParameter(request, prefix	+ "f_syearmonth", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] effFmToYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_fm_to_yrmon", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			String[] effFmYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_fm_yrmon", length));
			String[] hbCost = (JSPUtil.getParameter(request, prefix	+ "hb_cost", length));
			String[] finCost = (JSPUtil.getParameter(request, prefix	+ "fin_cost", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] addhbCost = (JSPUtil.getParameter(request, prefix	+ "addhb_cost", length));
			String[] fYearwk = (JSPUtil.getParameter(request, prefix	+ "f_yearwk", length));
			String[] fTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_trd_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] comDtrbAmt = (JSPUtil.getParameter(request, prefix	+ "com_dtrb_amt", length));
			String[] fRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_rlane_cd", length));
			String[] tabItem = (JSPUtil.getParameter(request, prefix	+ "tab_item", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] vslAmt = (JSPUtil.getParameter(request, prefix	+ "vsl_amt", length));
			String[] fSelvessel = (JSPUtil.getParameter(request, prefix	+ "f_selvessel", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			String[] creAmt = (JSPUtil.getParameter(request, prefix	+ "cre_amt", length));
			String[] insAmt = (JSPUtil.getParameter(request, prefix	+ "ins_amt", length));
			String[] stoAmt = (JSPUtil.getParameter(request, prefix	+ "sto_amt", length));
			String[] lubAmt = (JSPUtil.getParameter(request, prefix	+ "lub_amt", length));
			String[] mnrAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_amt", length));
			String[] depAmt = (JSPUtil.getParameter(request, prefix	+ "dep_amt", length));
			String[] telAmt = (JSPUtil.getParameter(request, prefix	+ "tel_amt", length));
			String[] otrAmt = (JSPUtil.getParameter(request, prefix	+ "otr_amt", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new AvgHireOwnVslVO();
				if (pErrorCode[i] != null)
					model.setPErrorCode(pErrorCode[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (fYearweek[i] != null)
					model.setFYearweek(fYearweek[i]);
				if (fMon[i] != null)
					model.setFMon(fMon[i]);
				if (ownVslRmk[i] != null)
					model.setOwnVslRmk(ownVslRmk[i]);
				if (fDirCd[i] != null)
					model.setFDirCd(fDirCd[i]);
				if (fYrtype[i] != null)
					model.setFYrtype(fYrtype[i]);
				if (fDur[i] != null)
					model.setFDur(fDur[i]);
				if (ttlCost[i] != null)
					model.setTtlCost(ttlCost[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (effToYrmon[i] != null)
					model.setEffToYrmon(effToYrmon[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (fSyearmonth[i] != null)
					model.setFSyearmonth(fSyearmonth[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (effFmToYrmon[i] != null)
					model.setEffFmToYrmon(effFmToYrmon[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				if (effFmYrmon[i] != null)
					model.setEffFmYrmon(effFmYrmon[i]);
				if (hbCost[i] != null)
					model.setHbCost(hbCost[i]);
				if (finCost[i] != null)
					model.setFinCost(finCost[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (addhbCost[i] != null)
					model.setAddhbCost(addhbCost[i]);
				if (fYearwk[i] != null)
					model.setFYearwk(fYearwk[i]);
				if (fTrdCd[i] != null)
					model.setFTrdCd(fTrdCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (comDtrbAmt[i] != null)
					model.setComDtrbAmt(comDtrbAmt[i]);
				if (fRlaneCd[i] != null)
					model.setFRlaneCd(fRlaneCd[i]);
				if (tabItem[i] != null)
					model.setTabItem(tabItem[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if (vslAmt[i] != null)
					model.setVslAmt(vslAmt[i]);
				if (fSelvessel[i] != null)
					model.setFSelvessel(fSelvessel[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				if (creAmt[i] != null)
					model.setCreAmt(creAmt[i]);
				if (insAmt[i] != null)
					model.setInsAmt(insAmt[i]);
				if (stoAmt[i] != null)
					model.setStoAmt(stoAmt[i]);
				if (lubAmt[i] != null)
					model.setLubAmt(lubAmt[i]);
				if (mnrAmt[i] != null)
					model.setMnrAmt(mnrAmt[i]);
				if (depAmt[i] != null)
					model.setDepAmt(depAmt[i]);
				if (telAmt[i] != null)
					model.setTelAmt(telAmt[i]);
				if (otrAmt[i] != null)
					model.setOtrAmt(otrAmt[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAvgHireOwnVslVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AvgHireOwnVslVO[]
	 */
	public AvgHireOwnVslVO[] getAvgHireOwnVslVOs(){
		AvgHireOwnVslVO[] vos = (AvgHireOwnVslVO[])models.toArray(new AvgHireOwnVslVO[models.size()]);
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
		this.pErrorCode = this.pErrorCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYearweek = this.fYearweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMon = this.fMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownVslRmk = this.ownVslRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDirCd = this.fDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYrtype = this.fYrtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDur = this.fDur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCost = this.ttlCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToYrmon = this.effToYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSyearmonth = this.fSyearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmToYrmon = this.effFmToYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmYrmon = this.effFmYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hbCost = this.hbCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finCost = this.finCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addhbCost = this.addhbCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYearwk = this.fYearwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrdCd = this.fTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comDtrbAmt = this.comDtrbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRlaneCd = this.fRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabItem = this.tabItem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslAmt = this.vslAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSelvessel = this.fSelvessel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creAmt = this.creAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insAmt = this.insAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoAmt = this.stoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lubAmt = this.lubAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrAmt = this.mnrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depAmt = this.depAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.telAmt = this.telAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrAmt = this.otrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
