/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GenExpStndCostVO.java
*@FileTitle : GenExpStndCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2014.12.24 유제량 
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

public class GenExpStndCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GenExpStndCostVO> models = new ArrayList<GenExpStndCostVO>();
	
	/* Column Info */
	private String pErrorCode = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String fYearweek = null;
	/* Column Info */
	private String fMon = null;
	/* Column Info */
	private String fDirCd = null;
	/* Column Info */
	private String addTtlExpn = null;
	/* Column Info */
	private String fYrtype = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String fDur = null;
	/* Column Info */
	private String rlaneCd = null;
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
	private String dirCd = null;
	/* Column Info */
	private String addExpn = null;
	/* Column Info */
	private String fSyearmonth = null;
	/* Column Info */
	private String genExpnRto = null;
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
	private String hulBndCd = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String finExpn = null;
	/* Column Info */
	private String addhbCost = null;
	/* Column Info */
	private String fYearwk = null;
	/* Column Info */
	private String genExpn = null;
	/* Column Info */
	private String tgtGenExpn = null;
	/* Column Info */
	private String orgGenExpn = null;
	/* Column Info */
	private String fAddTtlExpn = null;
	/* Column Info */
	private String fTrdCd = null;
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
	private String diffGenExpn = null;
	/* Column Info */
	private String vslAmt = null;
	/* Column Info */
	private String fSelvessel = null;
	/* Column Info */
	private String rlaneCd1 = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String rlaneCd2 = null;
	/* Column Info */
	private String fYear = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public GenExpStndCostVO() {}

	public GenExpStndCostVO(String ibflag, String pagerows, String cntCd, String costYrmon, String costWk, String vslCd, String vslClssCapa, String effFmToYrmon, String vslAmt, String comDtrbAmt, String ttlCost, String hbCost, String addhbCost, String finCost, String updUsrId, String fYrtype, String fYearweek, String fSelvessel, String fYear, String fMon, String fDur, String tabItem, String fYearwk, String fFmWk, String stndCostCd, String pErrorCode, String fSyearmonth, String fRlaneCd, String fTrdCd, String fDirCd, String trdCd, String rlaneCd, String dirCd, String subTrdCd, String hulBndCd, String effFmYrmon, String effToYrmon, String genExpn, String addExpn, String finExpn, String genExpnRto, String fAddTtlExpn, String addTtlExpn, String orgGenExpn, String tgtGenExpn, String rlaneCd1, String rlaneCd2, String diffGenExpn) {
		this.pErrorCode = pErrorCode;
		this.vslCd = vslCd;
		this.fYearweek = fYearweek;
		this.fMon = fMon;
		this.fDirCd = fDirCd;
		this.addTtlExpn = addTtlExpn;
		this.fYrtype = fYrtype;
		this.trdCd = trdCd;
		this.fDur = fDur;
		this.rlaneCd = rlaneCd;
		this.ttlCost = ttlCost;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.effToYrmon = effToYrmon;
		this.cntCd = cntCd;
		this.dirCd = dirCd;
		this.addExpn = addExpn;
		this.fSyearmonth = fSyearmonth;
		this.genExpnRto = genExpnRto;
		this.updUsrId = updUsrId;
		this.effFmToYrmon = effFmToYrmon;
		this.stndCostCd = stndCostCd;
		this.effFmYrmon = effFmYrmon;
		this.hbCost = hbCost;
		this.finCost = finCost;
		this.hulBndCd = hulBndCd;
		this.fFmWk = fFmWk;
		this.finExpn = finExpn;
		this.addhbCost = addhbCost;
		this.fYearwk = fYearwk;
		this.genExpn = genExpn;
		this.tgtGenExpn = tgtGenExpn;
		this.orgGenExpn = orgGenExpn;
		this.fAddTtlExpn = fAddTtlExpn;
		this.fTrdCd = fTrdCd;
		this.comDtrbAmt = comDtrbAmt;
		this.fRlaneCd = fRlaneCd;
		this.tabItem = tabItem;
		this.costWk = costWk;
		this.vslClssCapa = vslClssCapa;
		this.diffGenExpn = diffGenExpn;
		this.vslAmt = vslAmt;
		this.fSelvessel = fSelvessel;
		this.rlaneCd1 = rlaneCd1;
		this.subTrdCd = subTrdCd;
		this.rlaneCd2 = rlaneCd2;
		this.fYear = fYear;
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
		this.hashColumns.put("f_dir_cd", getFDirCd());
		this.hashColumns.put("add_ttl_expn", getAddTtlExpn());
		this.hashColumns.put("f_yrtype", getFYrtype());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("f_dur", getFDur());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ttl_cost", getTtlCost());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("eff_to_yrmon", getEffToYrmon());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("add_expn", getAddExpn());
		this.hashColumns.put("f_syearmonth", getFSyearmonth());
		this.hashColumns.put("gen_expn_rto", getGenExpnRto());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("eff_fm_to_yrmon", getEffFmToYrmon());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		this.hashColumns.put("eff_fm_yrmon", getEffFmYrmon());
		this.hashColumns.put("hb_cost", getHbCost());
		this.hashColumns.put("fin_cost", getFinCost());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("fin_expn", getFinExpn());
		this.hashColumns.put("addhb_cost", getAddhbCost());
		this.hashColumns.put("f_yearwk", getFYearwk());
		this.hashColumns.put("gen_expn", getGenExpn());
		this.hashColumns.put("tgt_gen_expn", getTgtGenExpn());
		this.hashColumns.put("org_gen_expn", getOrgGenExpn());
		this.hashColumns.put("f_add_ttl_expn", getFAddTtlExpn());
		this.hashColumns.put("f_trd_cd", getFTrdCd());
		this.hashColumns.put("com_dtrb_amt", getComDtrbAmt());
		this.hashColumns.put("f_rlane_cd", getFRlaneCd());
		this.hashColumns.put("tab_item", getTabItem());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("diff_gen_expn", getDiffGenExpn());
		this.hashColumns.put("vsl_amt", getVslAmt());
		this.hashColumns.put("f_selvessel", getFSelvessel());
		this.hashColumns.put("rlane_cd1", getRlaneCd1());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("rlane_cd2", getRlaneCd2());
		this.hashColumns.put("f_year", getFYear());
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
		this.hashFields.put("f_dir_cd", "fDirCd");
		this.hashFields.put("add_ttl_expn", "addTtlExpn");
		this.hashFields.put("f_yrtype", "fYrtype");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("f_dur", "fDur");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ttl_cost", "ttlCost");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("eff_to_yrmon", "effToYrmon");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("add_expn", "addExpn");
		this.hashFields.put("f_syearmonth", "fSyearmonth");
		this.hashFields.put("gen_expn_rto", "genExpnRto");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eff_fm_to_yrmon", "effFmToYrmon");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		this.hashFields.put("eff_fm_yrmon", "effFmYrmon");
		this.hashFields.put("hb_cost", "hbCost");
		this.hashFields.put("fin_cost", "finCost");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("fin_expn", "finExpn");
		this.hashFields.put("addhb_cost", "addhbCost");
		this.hashFields.put("f_yearwk", "fYearwk");
		this.hashFields.put("gen_expn", "genExpn");
		this.hashFields.put("tgt_gen_expn", "tgtGenExpn");
		this.hashFields.put("org_gen_expn", "orgGenExpn");
		this.hashFields.put("f_add_ttl_expn", "fAddTtlExpn");
		this.hashFields.put("f_trd_cd", "fTrdCd");
		this.hashFields.put("com_dtrb_amt", "comDtrbAmt");
		this.hashFields.put("f_rlane_cd", "fRlaneCd");
		this.hashFields.put("tab_item", "tabItem");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("diff_gen_expn", "diffGenExpn");
		this.hashFields.put("vsl_amt", "vslAmt");
		this.hashFields.put("f_selvessel", "fSelvessel");
		this.hashFields.put("rlane_cd1", "rlaneCd1");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("rlane_cd2", "rlaneCd2");
		this.hashFields.put("f_year", "fYear");
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
	 * @return fDirCd
	 */
	public String getFDirCd() {
		return this.fDirCd;
	}
	
	/**
	 * Column Info
	 * @return addTtlExpn
	 */
	public String getAddTtlExpn() {
		return this.addTtlExpn;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return addExpn
	 */
	public String getAddExpn() {
		return this.addExpn;
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
	 * @return genExpnRto
	 */
	public String getGenExpnRto() {
		return this.genExpnRto;
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
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
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
	 * @return finExpn
	 */
	public String getFinExpn() {
		return this.finExpn;
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
	 * @return genExpn
	 */
	public String getGenExpn() {
		return this.genExpn;
	}
	
	/**
	 * Column Info
	 * @return tgtGenExpn
	 */
	public String getTgtGenExpn() {
		return this.tgtGenExpn;
	}
	
	/**
	 * Column Info
	 * @return orgGenExpn
	 */
	public String getOrgGenExpn() {
		return this.orgGenExpn;
	}
	
	/**
	 * Column Info
	 * @return fAddTtlExpn
	 */
	public String getFAddTtlExpn() {
		return this.fAddTtlExpn;
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
	 * @return diffGenExpn
	 */
	public String getDiffGenExpn() {
		return this.diffGenExpn;
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
	 * @return rlaneCd1
	 */
	public String getRlaneCd1() {
		return this.rlaneCd1;
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
	 * @return rlaneCd2
	 */
	public String getRlaneCd2() {
		return this.rlaneCd2;
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
	 * @param fDirCd
	 */
	public void setFDirCd(String fDirCd) {
		this.fDirCd = fDirCd;
	}
	
	/**
	 * Column Info
	 * @param addTtlExpn
	 */
	public void setAddTtlExpn(String addTtlExpn) {
		this.addTtlExpn = addTtlExpn;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param addExpn
	 */
	public void setAddExpn(String addExpn) {
		this.addExpn = addExpn;
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
	 * @param genExpnRto
	 */
	public void setGenExpnRto(String genExpnRto) {
		this.genExpnRto = genExpnRto;
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
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
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
	 * @param finExpn
	 */
	public void setFinExpn(String finExpn) {
		this.finExpn = finExpn;
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
	 * @param genExpn
	 */
	public void setGenExpn(String genExpn) {
		this.genExpn = genExpn;
	}
	
	/**
	 * Column Info
	 * @param tgtGenExpn
	 */
	public void setTgtGenExpn(String tgtGenExpn) {
		this.tgtGenExpn = tgtGenExpn;
	}
	
	/**
	 * Column Info
	 * @param orgGenExpn
	 */
	public void setOrgGenExpn(String orgGenExpn) {
		this.orgGenExpn = orgGenExpn;
	}
	
	/**
	 * Column Info
	 * @param fAddTtlExpn
	 */
	public void setFAddTtlExpn(String fAddTtlExpn) {
		this.fAddTtlExpn = fAddTtlExpn;
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
	 * @param diffGenExpn
	 */
	public void setDiffGenExpn(String diffGenExpn) {
		this.diffGenExpn = diffGenExpn;
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
	 * @param rlaneCd1
	 */
	public void setRlaneCd1(String rlaneCd1) {
		this.rlaneCd1 = rlaneCd1;
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
	 * @param rlaneCd2
	 */
	public void setRlaneCd2(String rlaneCd2) {
		this.rlaneCd2 = rlaneCd2;
	}
	
	/**
	 * Column Info
	 * @param fYear
	 */
	public void setFYear(String fYear) {
		this.fYear = fYear;
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
		setFDirCd(JSPUtil.getParameter(request, prefix + "f_dir_cd", ""));
		setAddTtlExpn(JSPUtil.getParameter(request, prefix + "add_ttl_expn", ""));
		setFYrtype(JSPUtil.getParameter(request, prefix + "f_yrtype", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setFDur(JSPUtil.getParameter(request, prefix + "f_dur", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setTtlCost(JSPUtil.getParameter(request, prefix + "ttl_cost", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setEffToYrmon(JSPUtil.getParameter(request, prefix + "eff_to_yrmon", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setAddExpn(JSPUtil.getParameter(request, prefix + "add_expn", ""));
		setFSyearmonth(JSPUtil.getParameter(request, prefix + "f_syearmonth", ""));
		setGenExpnRto(JSPUtil.getParameter(request, prefix + "gen_expn_rto", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEffFmToYrmon(JSPUtil.getParameter(request, prefix + "eff_fm_to_yrmon", ""));
		setStndCostCd(JSPUtil.getParameter(request, prefix + "stnd_cost_cd", ""));
		setEffFmYrmon(JSPUtil.getParameter(request, prefix + "eff_fm_yrmon", ""));
		setHbCost(JSPUtil.getParameter(request, prefix + "hb_cost", ""));
		setFinCost(JSPUtil.getParameter(request, prefix + "fin_cost", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setFFmWk(JSPUtil.getParameter(request, prefix + "f_fm_wk", ""));
		setFinExpn(JSPUtil.getParameter(request, prefix + "fin_expn", ""));
		setAddhbCost(JSPUtil.getParameter(request, prefix + "addhb_cost", ""));
		setFYearwk(JSPUtil.getParameter(request, prefix + "f_yearwk", ""));
		setGenExpn(JSPUtil.getParameter(request, prefix + "gen_expn", ""));
		setTgtGenExpn(JSPUtil.getParameter(request, prefix + "tgt_gen_expn", ""));
		setOrgGenExpn(JSPUtil.getParameter(request, prefix + "org_gen_expn", ""));
		setFAddTtlExpn(JSPUtil.getParameter(request, prefix + "f_add_ttl_expn", ""));
		setFTrdCd(JSPUtil.getParameter(request, prefix + "f_trd_cd", ""));
		setComDtrbAmt(JSPUtil.getParameter(request, prefix + "com_dtrb_amt", ""));
		setFRlaneCd(JSPUtil.getParameter(request, prefix + "f_rlane_cd", ""));
		setTabItem(JSPUtil.getParameter(request, prefix + "tab_item", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setVslClssCapa(JSPUtil.getParameter(request, prefix + "vsl_clss_capa", ""));
		setDiffGenExpn(JSPUtil.getParameter(request, prefix + "diff_gen_expn", ""));
		setVslAmt(JSPUtil.getParameter(request, prefix + "vsl_amt", ""));
		setFSelvessel(JSPUtil.getParameter(request, prefix + "f_selvessel", ""));
		setRlaneCd1(JSPUtil.getParameter(request, prefix + "rlane_cd1", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setRlaneCd2(JSPUtil.getParameter(request, prefix + "rlane_cd2", ""));
		setFYear(JSPUtil.getParameter(request, prefix + "f_year", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GenExpStndCostVO[]
	 */
	public GenExpStndCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GenExpStndCostVO[]
	 */
	public GenExpStndCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GenExpStndCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pErrorCode = (JSPUtil.getParameter(request, prefix	+ "p_error_code", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] fYearweek = (JSPUtil.getParameter(request, prefix	+ "f_yearweek", length));
			String[] fMon = (JSPUtil.getParameter(request, prefix	+ "f_mon", length));
			String[] fDirCd = (JSPUtil.getParameter(request, prefix	+ "f_dir_cd", length));
			String[] addTtlExpn = (JSPUtil.getParameter(request, prefix	+ "add_ttl_expn", length));
			String[] fYrtype = (JSPUtil.getParameter(request, prefix	+ "f_yrtype", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] fDur = (JSPUtil.getParameter(request, prefix	+ "f_dur", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] ttlCost = (JSPUtil.getParameter(request, prefix	+ "ttl_cost", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] effToYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_to_yrmon", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] addExpn = (JSPUtil.getParameter(request, prefix	+ "add_expn", length));
			String[] fSyearmonth = (JSPUtil.getParameter(request, prefix	+ "f_syearmonth", length));
			String[] genExpnRto = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rto", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] effFmToYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_fm_to_yrmon", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			String[] effFmYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_fm_yrmon", length));
			String[] hbCost = (JSPUtil.getParameter(request, prefix	+ "hb_cost", length));
			String[] finCost = (JSPUtil.getParameter(request, prefix	+ "fin_cost", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] finExpn = (JSPUtil.getParameter(request, prefix	+ "fin_expn", length));
			String[] addhbCost = (JSPUtil.getParameter(request, prefix	+ "addhb_cost", length));
			String[] fYearwk = (JSPUtil.getParameter(request, prefix	+ "f_yearwk", length));
			String[] genExpn = (JSPUtil.getParameter(request, prefix	+ "gen_expn", length));
			String[] tgtGenExpn = (JSPUtil.getParameter(request, prefix	+ "tgt_gen_expn", length));
			String[] orgGenExpn = (JSPUtil.getParameter(request, prefix	+ "org_gen_expn", length));
			String[] fAddTtlExpn = (JSPUtil.getParameter(request, prefix	+ "f_add_ttl_expn", length));
			String[] fTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_trd_cd", length));
			String[] comDtrbAmt = (JSPUtil.getParameter(request, prefix	+ "com_dtrb_amt", length));
			String[] fRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_rlane_cd", length));
			String[] tabItem = (JSPUtil.getParameter(request, prefix	+ "tab_item", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] diffGenExpn = (JSPUtil.getParameter(request, prefix	+ "diff_gen_expn", length));
			String[] vslAmt = (JSPUtil.getParameter(request, prefix	+ "vsl_amt", length));
			String[] fSelvessel = (JSPUtil.getParameter(request, prefix	+ "f_selvessel", length));
			String[] rlaneCd1 = (JSPUtil.getParameter(request, prefix	+ "rlane_cd1", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] rlaneCd2 = (JSPUtil.getParameter(request, prefix	+ "rlane_cd2", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			
			for (int i = 0; i < length; i++) {
				model = new GenExpStndCostVO();
				if (pErrorCode[i] != null)
					model.setPErrorCode(pErrorCode[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (fYearweek[i] != null)
					model.setFYearweek(fYearweek[i]);
				if (fMon[i] != null)
					model.setFMon(fMon[i]);
				if (fDirCd[i] != null)
					model.setFDirCd(fDirCd[i]);
				if (addTtlExpn[i] != null)
					model.setAddTtlExpn(addTtlExpn[i]);
				if (fYrtype[i] != null)
					model.setFYrtype(fYrtype[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (fDur[i] != null)
					model.setFDur(fDur[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
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
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (addExpn[i] != null)
					model.setAddExpn(addExpn[i]);
				if (fSyearmonth[i] != null)
					model.setFSyearmonth(fSyearmonth[i]);
				if (genExpnRto[i] != null)
					model.setGenExpnRto(genExpnRto[i]);
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
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (finExpn[i] != null)
					model.setFinExpn(finExpn[i]);
				if (addhbCost[i] != null)
					model.setAddhbCost(addhbCost[i]);
				if (fYearwk[i] != null)
					model.setFYearwk(fYearwk[i]);
				if (genExpn[i] != null)
					model.setGenExpn(genExpn[i]);
				if (tgtGenExpn[i] != null)
					model.setTgtGenExpn(tgtGenExpn[i]);
				if (orgGenExpn[i] != null)
					model.setOrgGenExpn(orgGenExpn[i]);
				if (fAddTtlExpn[i] != null)
					model.setFAddTtlExpn(fAddTtlExpn[i]);
				if (fTrdCd[i] != null)
					model.setFTrdCd(fTrdCd[i]);
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
				if (diffGenExpn[i] != null)
					model.setDiffGenExpn(diffGenExpn[i]);
				if (vslAmt[i] != null)
					model.setVslAmt(vslAmt[i]);
				if (fSelvessel[i] != null)
					model.setFSelvessel(fSelvessel[i]);
				if (rlaneCd1[i] != null)
					model.setRlaneCd1(rlaneCd1[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (rlaneCd2[i] != null)
					model.setRlaneCd2(rlaneCd2[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGenExpStndCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GenExpStndCostVO[]
	 */
	public GenExpStndCostVO[] getGenExpStndCostVOs(){
		GenExpStndCostVO[] vos = (GenExpStndCostVO[])models.toArray(new GenExpStndCostVO[models.size()]);
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
		this.fDirCd = this.fDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addTtlExpn = this.addTtlExpn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYrtype = this.fYrtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDur = this.fDur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCost = this.ttlCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToYrmon = this.effToYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addExpn = this.addExpn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSyearmonth = this.fSyearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRto = this.genExpnRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmToYrmon = this.effFmToYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmYrmon = this.effFmYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hbCost = this.hbCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finCost = this.finCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finExpn = this.finExpn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addhbCost = this.addhbCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYearwk = this.fYearwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpn = this.genExpn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtGenExpn = this.tgtGenExpn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgGenExpn = this.orgGenExpn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAddTtlExpn = this.fAddTtlExpn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrdCd = this.fTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comDtrbAmt = this.comDtrbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRlaneCd = this.fRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabItem = this.tabItem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffGenExpn = this.diffGenExpn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslAmt = this.vslAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSelvessel = this.fSelvessel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd1 = this.rlaneCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd2 = this.rlaneCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
