/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostInquirybyPFMCTypeVO.java
*@FileTitle : CostInquirybyPFMCTypeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.27
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.05.27 유제량 
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
 * @author 유제량
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CostInquirybyPFMCTypeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CostInquirybyPFMCTypeVO> models = new ArrayList<CostInquirybyPFMCTypeVO>();
	
	/* Column Info */
	private String fDirCdCombo = null;
	/* Column Info */
	private String fFmMon = null;
	/* Column Info */
	private String fDirCd = null;
	/* Column Info */
	private String fHulBndCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String fSelrlane = null;
	/* Column Info */
	private String costTp = null;
	/* Column Info */
	private String fVslCd = null;
	/* Column Info */
	private String loadFt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String fToMon = null;
	/* Column Info */
	private String fSkdVoyNo = null;
	/* Column Info */
	private String amt107 = null;
	/* Column Info */
	private String amt108 = null;
	/* Column Info */
	private String amt109 = null;
	/* Column Info */
	private String amt104 = null;
	/* Column Info */
	private String ttlDys = null;
	/* Column Info */
	private String amt103 = null;
	/* Column Info */
	private String fToWk = null;
	/* Column Info */
	private String amt106 = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String amt105 = null;
	/* Column Info */
	private String amt102 = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String amt101 = null;
	/* Column Info */
	private String load = null;
	/* Column Info */
	private String revVvd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String fYear = null;
	/* Column Info */
	private String fChkprd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String amt113 = null;
	/* Column Info */
	private String amt112 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amt111 = null;
	/* Column Info */
	private String amt110 = null;
	/* Column Info */
	private String amt115 = null;
	/* Column Info */
	private String amt114 = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fSeltrade = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String fSubTrdCd = null;
	/* Column Info */
	private String fnlHjsBsaCapa = null;
	/* Column Info */
	private String opTotal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CostInquirybyPFMCTypeVO() {}

	public CostInquirybyPFMCTypeVO(String ibflag, String pagerows, String costYrmon, String slsYrmon, String costWk, String trdCd, String subTrdCd, String rlaneCd, String iocCd, String revVvd, String dirCd, String hulBndCd, String costTp, String fnlHjsBsaCapa, String load, String loadFt, String ttlDys, String amt101, String amt102, String amt103, String amt104, String amt105, String amt106, String amt107, String amt108, String amt109, String amt110, String amt111, String amt112, String amt113, String amt114, String amt115, String opTotal, String creUsrId, String creDt, String updUsrId, String updDt, String fChkprd, String fYear, String fFmMon, String fToMon, String fFmWk, String fToWk, String fSeltrade, String fSubTrdCd, String fSelrlane, String fDirCdCombo, String fHulBndCd, String fVslCd, String fSkdVoyNo, String fDirCd) {
		this.fDirCdCombo = fDirCdCombo;
		this.fFmMon = fFmMon;
		this.fDirCd = fDirCd;
		this.fHulBndCd = fHulBndCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.costYrmon = costYrmon;
		this.fSelrlane = fSelrlane;
		this.costTp = costTp;
		this.fVslCd = fVslCd;
		this.loadFt = loadFt;
		this.updUsrId = updUsrId;
		this.hulBndCd = hulBndCd;
		this.fFmWk = fFmWk;
		this.fToMon = fToMon;
		this.fSkdVoyNo = fSkdVoyNo;
		this.amt107 = amt107;
		this.amt108 = amt108;
		this.amt109 = amt109;
		this.amt104 = amt104;
		this.ttlDys = ttlDys;
		this.amt103 = amt103;
		this.fToWk = fToWk;
		this.amt106 = amt106;
		this.creUsrId = creUsrId;
		this.amt105 = amt105;
		this.amt102 = amt102;
		this.costWk = costWk;
		this.amt101 = amt101;
		this.load = load;
		this.revVvd = revVvd;
		this.subTrdCd = subTrdCd;
		this.fYear = fYear;
		this.fChkprd = fChkprd;
		this.creDt = creDt;
		this.amt113 = amt113;
		this.amt112 = amt112;
		this.ibflag = ibflag;
		this.amt111 = amt111;
		this.amt110 = amt110;
		this.amt115 = amt115;
		this.amt114 = amt114;
		this.dirCd = dirCd;
		this.iocCd = iocCd;
		this.updDt = updDt;
		this.fSeltrade = fSeltrade;
		this.slsYrmon = slsYrmon;
		this.fSubTrdCd = fSubTrdCd;
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
		this.opTotal = opTotal;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_dir_cd_combo", getFDirCdCombo());
		this.hashColumns.put("f_fm_mon", getFFmMon());
		this.hashColumns.put("f_dir_cd", getFDirCd());
		this.hashColumns.put("f_hul_bnd_cd", getFHulBndCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("f_selrlane", getFSelrlane());
		this.hashColumns.put("cost_tp", getCostTp());
		this.hashColumns.put("f_vsl_cd", getFVslCd());
		this.hashColumns.put("load_ft", getLoadFt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("f_to_mon", getFToMon());
		this.hashColumns.put("f_skd_voy_no", getFSkdVoyNo());
		this.hashColumns.put("amt_1_07", getAmt107());
		this.hashColumns.put("amt_1_08", getAmt108());
		this.hashColumns.put("amt_1_09", getAmt109());
		this.hashColumns.put("amt_1_04", getAmt104());
		this.hashColumns.put("ttl_dys", getTtlDys());
		this.hashColumns.put("amt_1_03", getAmt103());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("amt_1_06", getAmt106());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("amt_1_05", getAmt105());
		this.hashColumns.put("amt_1_02", getAmt102());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("amt_1_01", getAmt101());
		this.hashColumns.put("load", getLoad());
		this.hashColumns.put("rev_vvd", getRevVvd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("f_year", getFYear());
		this.hashColumns.put("f_chkprd", getFChkprd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("amt_1_13", getAmt113());
		this.hashColumns.put("amt_1_12", getAmt112());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amt_1_11", getAmt111());
		this.hashColumns.put("amt_1_10", getAmt110());
		this.hashColumns.put("amt_1_15", getAmt115());
		this.hashColumns.put("amt_1_14", getAmt114());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("f_seltrade", getFSeltrade());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("f_sub_trd_cd", getFSubTrdCd());
		this.hashColumns.put("fnl_hjs_bsa_capa", getFnlHjsBsaCapa());
		this.hashColumns.put("op_total", getOpTotal());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_dir_cd_combo", "fDirCdCombo");
		this.hashFields.put("f_fm_mon", "fFmMon");
		this.hashFields.put("f_dir_cd", "fDirCd");
		this.hashFields.put("f_hul_bnd_cd", "fHulBndCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("f_selrlane", "fSelrlane");
		this.hashFields.put("cost_tp", "costTp");
		this.hashFields.put("f_vsl_cd", "fVslCd");
		this.hashFields.put("load_ft", "loadFt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("f_to_mon", "fToMon");
		this.hashFields.put("f_skd_voy_no", "fSkdVoyNo");
		this.hashFields.put("amt_1_07", "amt107");
		this.hashFields.put("amt_1_08", "amt108");
		this.hashFields.put("amt_1_09", "amt109");
		this.hashFields.put("amt_1_04", "amt104");
		this.hashFields.put("ttl_dys", "ttlDys");
		this.hashFields.put("amt_1_03", "amt103");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("amt_1_06", "amt106");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("amt_1_05", "amt105");
		this.hashFields.put("amt_1_02", "amt102");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("amt_1_01", "amt101");
		this.hashFields.put("load", "load");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("f_year", "fYear");
		this.hashFields.put("f_chkprd", "fChkprd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("amt_1_13", "amt113");
		this.hashFields.put("amt_1_12", "amt112");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amt_1_11", "amt111");
		this.hashFields.put("amt_1_10", "amt110");
		this.hashFields.put("amt_1_15", "amt115");
		this.hashFields.put("amt_1_14", "amt114");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("f_seltrade", "fSeltrade");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("f_sub_trd_cd", "fSubTrdCd");
		this.hashFields.put("fnl_hjs_bsa_capa", "fnlHjsBsaCapa");
		this.hashFields.put("op_total", "opTotal");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fDirCdCombo
	 */
	public String getFDirCdCombo() {
		return this.fDirCdCombo;
	}
	
	/**
	 * Column Info
	 * @return fFmMon
	 */
	public String getFFmMon() {
		return this.fFmMon;
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
	 * @return fHulBndCd
	 */
	public String getFHulBndCd() {
		return this.fHulBndCd;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return fSelrlane
	 */
	public String getFSelrlane() {
		return this.fSelrlane;
	}
	
	/**
	 * Column Info
	 * @return costTp
	 */
	public String getCostTp() {
		return this.costTp;
	}
	
	/**
	 * Column Info
	 * @return fVslCd
	 */
	public String getFVslCd() {
		return this.fVslCd;
	}
	
	/**
	 * Column Info
	 * @return loadFt
	 */
	public String getLoadFt() {
		return this.loadFt;
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
	 * @return fToMon
	 */
	public String getFToMon() {
		return this.fToMon;
	}
	
	/**
	 * Column Info
	 * @return fSkdVoyNo
	 */
	public String getFSkdVoyNo() {
		return this.fSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return amt107
	 */
	public String getAmt107() {
		return this.amt107;
	}
	
	/**
	 * Column Info
	 * @return amt108
	 */
	public String getAmt108() {
		return this.amt108;
	}
	
	/**
	 * Column Info
	 * @return amt109
	 */
	public String getAmt109() {
		return this.amt109;
	}
	
	/**
	 * Column Info
	 * @return amt104
	 */
	public String getAmt104() {
		return this.amt104;
	}
	
	/**
	 * Column Info
	 * @return ttlDys
	 */
	public String getTtlDys() {
		return this.ttlDys;
	}
	
	/**
	 * Column Info
	 * @return amt103
	 */
	public String getAmt103() {
		return this.amt103;
	}
	
	/**
	 * Column Info
	 * @return fToWk
	 */
	public String getFToWk() {
		return this.fToWk;
	}
	
	/**
	 * Column Info
	 * @return amt106
	 */
	public String getAmt106() {
		return this.amt106;
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
	 * @return amt105
	 */
	public String getAmt105() {
		return this.amt105;
	}
	
	/**
	 * Column Info
	 * @return amt102
	 */
	public String getAmt102() {
		return this.amt102;
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
	 * @return amt101
	 */
	public String getAmt101() {
		return this.amt101;
	}
	
	/**
	 * Column Info
	 * @return load
	 */
	public String getLoad() {
		return this.load;
	}
	
	/**
	 * Column Info
	 * @return revVvd
	 */
	public String getRevVvd() {
		return this.revVvd;
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
	 * @return fYear
	 */
	public String getFYear() {
		return this.fYear;
	}
	
	/**
	 * Column Info
	 * @return fChkprd
	 */
	public String getFChkprd() {
		return this.fChkprd;
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
	 * @return amt113
	 */
	public String getAmt113() {
		return this.amt113;
	}
	
	/**
	 * Column Info
	 * @return amt112
	 */
	public String getAmt112() {
		return this.amt112;
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
	 * @return amt111
	 */
	public String getAmt111() {
		return this.amt111;
	}
	
	/**
	 * Column Info
	 * @return amt110
	 */
	public String getAmt110() {
		return this.amt110;
	}
	
	/**
	 * Column Info
	 * @return amt115
	 */
	public String getAmt115() {
		return this.amt115;
	}
	
	/**
	 * Column Info
	 * @return amt114
	 */
	public String getAmt114() {
		return this.amt114;
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
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
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
	 * @return fSeltrade
	 */
	public String getFSeltrade() {
		return this.fSeltrade;
	}
	
	/**
	 * Column Info
	 * @return slsYrmon
	 */
	public String getSlsYrmon() {
		return this.slsYrmon;
	}
	
	/**
	 * Column Info
	 * @return fSubTrdCd
	 */
	public String getFSubTrdCd() {
		return this.fSubTrdCd;
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
	 * @return opTotal
	 */
	public String getOpTotal() {
		return this.opTotal;
	}
	

	/**
	 * Column Info
	 * @param fDirCdCombo
	 */
	public void setFDirCdCombo(String fDirCdCombo) {
		this.fDirCdCombo = fDirCdCombo;
	}
	
	/**
	 * Column Info
	 * @param fFmMon
	 */
	public void setFFmMon(String fFmMon) {
		this.fFmMon = fFmMon;
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
	 * @param fHulBndCd
	 */
	public void setFHulBndCd(String fHulBndCd) {
		this.fHulBndCd = fHulBndCd;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param fSelrlane
	 */
	public void setFSelrlane(String fSelrlane) {
		this.fSelrlane = fSelrlane;
	}
	
	/**
	 * Column Info
	 * @param costTp
	 */
	public void setCostTp(String costTp) {
		this.costTp = costTp;
	}
	
	/**
	 * Column Info
	 * @param fVslCd
	 */
	public void setFVslCd(String fVslCd) {
		this.fVslCd = fVslCd;
	}
	
	/**
	 * Column Info
	 * @param loadFt
	 */
	public void setLoadFt(String loadFt) {
		this.loadFt = loadFt;
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
	 * @param fToMon
	 */
	public void setFToMon(String fToMon) {
		this.fToMon = fToMon;
	}
	
	/**
	 * Column Info
	 * @param fSkdVoyNo
	 */
	public void setFSkdVoyNo(String fSkdVoyNo) {
		this.fSkdVoyNo = fSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param amt107
	 */
	public void setAmt107(String amt107) {
		this.amt107 = amt107;
	}
	
	/**
	 * Column Info
	 * @param amt108
	 */
	public void setAmt108(String amt108) {
		this.amt108 = amt108;
	}
	
	/**
	 * Column Info
	 * @param amt109
	 */
	public void setAmt109(String amt109) {
		this.amt109 = amt109;
	}
	
	/**
	 * Column Info
	 * @param amt104
	 */
	public void setAmt104(String amt104) {
		this.amt104 = amt104;
	}
	
	/**
	 * Column Info
	 * @param ttlDys
	 */
	public void setTtlDys(String ttlDys) {
		this.ttlDys = ttlDys;
	}
	
	/**
	 * Column Info
	 * @param amt103
	 */
	public void setAmt103(String amt103) {
		this.amt103 = amt103;
	}
	
	/**
	 * Column Info
	 * @param fToWk
	 */
	public void setFToWk(String fToWk) {
		this.fToWk = fToWk;
	}
	
	/**
	 * Column Info
	 * @param amt106
	 */
	public void setAmt106(String amt106) {
		this.amt106 = amt106;
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
	 * @param amt105
	 */
	public void setAmt105(String amt105) {
		this.amt105 = amt105;
	}
	
	/**
	 * Column Info
	 * @param amt102
	 */
	public void setAmt102(String amt102) {
		this.amt102 = amt102;
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
	 * @param amt101
	 */
	public void setAmt101(String amt101) {
		this.amt101 = amt101;
	}
	
	/**
	 * Column Info
	 * @param load
	 */
	public void setLoad(String load) {
		this.load = load;
	}
	
	/**
	 * Column Info
	 * @param revVvd
	 */
	public void setRevVvd(String revVvd) {
		this.revVvd = revVvd;
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
	 * @param fYear
	 */
	public void setFYear(String fYear) {
		this.fYear = fYear;
	}
	
	/**
	 * Column Info
	 * @param fChkprd
	 */
	public void setFChkprd(String fChkprd) {
		this.fChkprd = fChkprd;
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
	 * @param amt113
	 */
	public void setAmt113(String amt113) {
		this.amt113 = amt113;
	}
	
	/**
	 * Column Info
	 * @param amt112
	 */
	public void setAmt112(String amt112) {
		this.amt112 = amt112;
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
	 * @param amt111
	 */
	public void setAmt111(String amt111) {
		this.amt111 = amt111;
	}
	
	/**
	 * Column Info
	 * @param amt110
	 */
	public void setAmt110(String amt110) {
		this.amt110 = amt110;
	}
	
	/**
	 * Column Info
	 * @param amt115
	 */
	public void setAmt115(String amt115) {
		this.amt115 = amt115;
	}
	
	/**
	 * Column Info
	 * @param amt114
	 */
	public void setAmt114(String amt114) {
		this.amt114 = amt114;
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
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
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
	 * @param fSeltrade
	 */
	public void setFSeltrade(String fSeltrade) {
		this.fSeltrade = fSeltrade;
	}
	
	/**
	 * Column Info
	 * @param slsYrmon
	 */
	public void setSlsYrmon(String slsYrmon) {
		this.slsYrmon = slsYrmon;
	}
	
	/**
	 * Column Info
	 * @param fSubTrdCd
	 */
	public void setFSubTrdCd(String fSubTrdCd) {
		this.fSubTrdCd = fSubTrdCd;
	}
	
	/**
	 * Column Info
	 * @param fnlHjsBsaCapa
	 */
	public void setFnlHjsBsaCapa(String fnlHjsBsaCapa) {
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param opTotal
	 */
	public void setOpTotal(String opTotal) {
		this.opTotal = opTotal;
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
		setFDirCdCombo(JSPUtil.getParameter(request, prefix + "f_dir_cd_combo", ""));
		setFFmMon(JSPUtil.getParameter(request, prefix + "f_fm_mon", ""));
		setFDirCd(JSPUtil.getParameter(request, prefix + "f_dir_cd", ""));
		setFHulBndCd(JSPUtil.getParameter(request, prefix + "f_hul_bnd_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setFSelrlane(JSPUtil.getParameter(request, prefix + "f_selrlane", ""));
		setCostTp(JSPUtil.getParameter(request, prefix + "cost_tp", ""));
		setFVslCd(JSPUtil.getParameter(request, prefix + "f_vsl_cd", ""));
		setLoadFt(JSPUtil.getParameter(request, prefix + "load_ft", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setFFmWk(JSPUtil.getParameter(request, prefix + "f_fm_wk", ""));
		setFToMon(JSPUtil.getParameter(request, prefix + "f_to_mon", ""));
		setFSkdVoyNo(JSPUtil.getParameter(request, prefix + "f_skd_voy_no", ""));
		setAmt107(JSPUtil.getParameter(request, prefix + "amt_1_07", ""));
		setAmt108(JSPUtil.getParameter(request, prefix + "amt_1_08", ""));
		setAmt109(JSPUtil.getParameter(request, prefix + "amt_1_09", ""));
		setAmt104(JSPUtil.getParameter(request, prefix + "amt_1_04", ""));
		setTtlDys(JSPUtil.getParameter(request, prefix + "ttl_dys", ""));
		setAmt103(JSPUtil.getParameter(request, prefix + "amt_1_03", ""));
		setFToWk(JSPUtil.getParameter(request, prefix + "f_to_wk", ""));
		setAmt106(JSPUtil.getParameter(request, prefix + "amt_1_06", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAmt105(JSPUtil.getParameter(request, prefix + "amt_1_05", ""));
		setAmt102(JSPUtil.getParameter(request, prefix + "amt_1_02", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setAmt101(JSPUtil.getParameter(request, prefix + "amt_1_01", ""));
		setLoad(JSPUtil.getParameter(request, prefix + "load", ""));
		setRevVvd(JSPUtil.getParameter(request, prefix + "rev_vvd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setFYear(JSPUtil.getParameter(request, prefix + "f_year", ""));
		setFChkprd(JSPUtil.getParameter(request, prefix + "f_chkprd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAmt113(JSPUtil.getParameter(request, prefix + "amt_1_13", ""));
		setAmt112(JSPUtil.getParameter(request, prefix + "amt_1_12", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAmt111(JSPUtil.getParameter(request, prefix + "amt_1_11", ""));
		setAmt110(JSPUtil.getParameter(request, prefix + "amt_1_10", ""));
		setAmt115(JSPUtil.getParameter(request, prefix + "amt_1_15", ""));
		setAmt114(JSPUtil.getParameter(request, prefix + "amt_1_14", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setFSeltrade(JSPUtil.getParameter(request, prefix + "f_seltrade", ""));
		setSlsYrmon(JSPUtil.getParameter(request, prefix + "sls_yrmon", ""));
		setFSubTrdCd(JSPUtil.getParameter(request, prefix + "f_sub_trd_cd", ""));
		setFnlHjsBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_hjs_bsa_capa", ""));
		setOpTotal(JSPUtil.getParameter(request, prefix + "op_total", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CostInquirybyPFMCTypeVO[]
	 */
	public CostInquirybyPFMCTypeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CostInquirybyPFMCTypeVO[]
	 */
	public CostInquirybyPFMCTypeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CostInquirybyPFMCTypeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fDirCdCombo = (JSPUtil.getParameter(request, prefix	+ "f_dir_cd_combo", length));
			String[] fFmMon = (JSPUtil.getParameter(request, prefix	+ "f_fm_mon", length));
			String[] fDirCd = (JSPUtil.getParameter(request, prefix	+ "f_dir_cd", length));
			String[] fHulBndCd = (JSPUtil.getParameter(request, prefix	+ "f_hul_bnd_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] fSelrlane = (JSPUtil.getParameter(request, prefix	+ "f_selrlane", length));
			String[] costTp = (JSPUtil.getParameter(request, prefix	+ "cost_tp", length));
			String[] fVslCd = (JSPUtil.getParameter(request, prefix	+ "f_vsl_cd", length));
			String[] loadFt = (JSPUtil.getParameter(request, prefix	+ "load_ft", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] fToMon = (JSPUtil.getParameter(request, prefix	+ "f_to_mon", length));
			String[] fSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "f_skd_voy_no", length));
			String[] amt107 = (JSPUtil.getParameter(request, prefix	+ "amt_1_07", length));
			String[] amt108 = (JSPUtil.getParameter(request, prefix	+ "amt_1_08", length));
			String[] amt109 = (JSPUtil.getParameter(request, prefix	+ "amt_1_09", length));
			String[] amt104 = (JSPUtil.getParameter(request, prefix	+ "amt_1_04", length));
			String[] ttlDys = (JSPUtil.getParameter(request, prefix	+ "ttl_dys", length));
			String[] amt103 = (JSPUtil.getParameter(request, prefix	+ "amt_1_03", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] amt106 = (JSPUtil.getParameter(request, prefix	+ "amt_1_06", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] amt105 = (JSPUtil.getParameter(request, prefix	+ "amt_1_05", length));
			String[] amt102 = (JSPUtil.getParameter(request, prefix	+ "amt_1_02", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] amt101 = (JSPUtil.getParameter(request, prefix	+ "amt_1_01", length));
			String[] load = (JSPUtil.getParameter(request, prefix	+ "load", length));
			String[] revVvd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			String[] fChkprd = (JSPUtil.getParameter(request, prefix	+ "f_chkprd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] amt113 = (JSPUtil.getParameter(request, prefix	+ "amt_1_13", length));
			String[] amt112 = (JSPUtil.getParameter(request, prefix	+ "amt_1_12", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amt111 = (JSPUtil.getParameter(request, prefix	+ "amt_1_11", length));
			String[] amt110 = (JSPUtil.getParameter(request, prefix	+ "amt_1_10", length));
			String[] amt115 = (JSPUtil.getParameter(request, prefix	+ "amt_1_15", length));
			String[] amt114 = (JSPUtil.getParameter(request, prefix	+ "amt_1_14", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fSeltrade = (JSPUtil.getParameter(request, prefix	+ "f_seltrade", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] fSubTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_sub_trd_cd", length));
			String[] fnlHjsBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_hjs_bsa_capa", length));
			String[] opTotal = (JSPUtil.getParameter(request, prefix	+ "op_total", length));
			
			for (int i = 0; i < length; i++) {
				model = new CostInquirybyPFMCTypeVO();
				if (fDirCdCombo[i] != null)
					model.setFDirCdCombo(fDirCdCombo[i]);
				if (fFmMon[i] != null)
					model.setFFmMon(fFmMon[i]);
				if (fDirCd[i] != null)
					model.setFDirCd(fDirCd[i]);
				if (fHulBndCd[i] != null)
					model.setFHulBndCd(fHulBndCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (fSelrlane[i] != null)
					model.setFSelrlane(fSelrlane[i]);
				if (costTp[i] != null)
					model.setCostTp(costTp[i]);
				if (fVslCd[i] != null)
					model.setFVslCd(fVslCd[i]);
				if (loadFt[i] != null)
					model.setLoadFt(loadFt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (fToMon[i] != null)
					model.setFToMon(fToMon[i]);
				if (fSkdVoyNo[i] != null)
					model.setFSkdVoyNo(fSkdVoyNo[i]);
				if (amt107[i] != null)
					model.setAmt107(amt107[i]);
				if (amt108[i] != null)
					model.setAmt108(amt108[i]);
				if (amt109[i] != null)
					model.setAmt109(amt109[i]);
				if (amt104[i] != null)
					model.setAmt104(amt104[i]);
				if (ttlDys[i] != null)
					model.setTtlDys(ttlDys[i]);
				if (amt103[i] != null)
					model.setAmt103(amt103[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (amt106[i] != null)
					model.setAmt106(amt106[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (amt105[i] != null)
					model.setAmt105(amt105[i]);
				if (amt102[i] != null)
					model.setAmt102(amt102[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (amt101[i] != null)
					model.setAmt101(amt101[i]);
				if (load[i] != null)
					model.setLoad(load[i]);
				if (revVvd[i] != null)
					model.setRevVvd(revVvd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				if (fChkprd[i] != null)
					model.setFChkprd(fChkprd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (amt113[i] != null)
					model.setAmt113(amt113[i]);
				if (amt112[i] != null)
					model.setAmt112(amt112[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amt111[i] != null)
					model.setAmt111(amt111[i]);
				if (amt110[i] != null)
					model.setAmt110(amt110[i]);
				if (amt115[i] != null)
					model.setAmt115(amt115[i]);
				if (amt114[i] != null)
					model.setAmt114(amt114[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fSeltrade[i] != null)
					model.setFSeltrade(fSeltrade[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (fSubTrdCd[i] != null)
					model.setFSubTrdCd(fSubTrdCd[i]);
				if (fnlHjsBsaCapa[i] != null)
					model.setFnlHjsBsaCapa(fnlHjsBsaCapa[i]);
				if (opTotal[i] != null)
					model.setOpTotal(opTotal[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCostInquirybyPFMCTypeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CostInquirybyPFMCTypeVO[]
	 */
	public CostInquirybyPFMCTypeVO[] getCostInquirybyPFMCTypeVOs(){
		CostInquirybyPFMCTypeVO[] vos = (CostInquirybyPFMCTypeVO[])models.toArray(new CostInquirybyPFMCTypeVO[models.size()]);
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
		this.fDirCdCombo = this.fDirCdCombo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmMon = this.fFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDirCd = this.fDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fHulBndCd = this.fHulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSelrlane = this.fSelrlane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTp = this.costTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVslCd = this.fVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadFt = this.loadFt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToMon = this.fToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdVoyNo = this.fSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt107 = this.amt107 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt108 = this.amt108 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt109 = this.amt109 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt104 = this.amt104 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDys = this.ttlDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt103 = this.amt103 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt106 = this.amt106 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt105 = this.amt105 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt102 = this.amt102 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt101 = this.amt101 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load = this.load .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd = this.revVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkprd = this.fChkprd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt113 = this.amt113 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt112 = this.amt112 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt111 = this.amt111 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt110 = this.amt110 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt115 = this.amt115 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt114 = this.amt114 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSeltrade = this.fSeltrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSubTrdCd = this.fSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlHjsBsaCapa = this.fnlHjsBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opTotal = this.opTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
