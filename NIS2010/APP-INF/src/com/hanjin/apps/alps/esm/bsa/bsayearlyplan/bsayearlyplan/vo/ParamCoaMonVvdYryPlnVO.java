/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ParamCoaMonVvdYryPlnVO.java
*@FileTitle : ParamCoaMonVvdYryPlnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.24
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.01.24 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ParamCoaMonVvdYryPlnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ParamCoaMonVvdYryPlnVO> models = new ArrayList<ParamCoaMonVvdYryPlnVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String iocRuleDesc = null;
	/* Column Info */
	private String fChkprd = null;
	/* Column Info */
	private String fFmMon = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String vvdRmk = null;
	/* Column Info */
	private String fDirCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fSeldir = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String fSelrlane = null;
	/* Column Info */
	private String fVslCd = null;
	/* Column Info */
	private String n1stLodgPortEtdDt = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String lstLodgPortCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String fSeltrade = null;
	/* Column Info */
	private String fSelioc = null;
	/* Column Info */
	private String fToMon = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String fSkdVoyNo = null;
	/* Column Info */
	private String lstLodgPortEtdDt = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String fToWk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String fSelslane = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String fYear = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ParamCoaMonVvdYryPlnVO() {}

	public ParamCoaMonVvdYryPlnVO(String ibflag, String pagerows, String trdCd, String rlaneCd, String iocCd, String vslCd, String skdVoyNo, String dirCd, String costYrmon, String slsYrmon, String costWk, String slanCd, String lstLodgPortEtdDt, String n1stLodgPortEtdDt, String lstLodgPortCd, String iocRuleDesc, String subTrdCd, String vvdRmk, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String fSeltrade, String fSelrlane, String fSeldir, String fSelioc, String fSelslane, String fVslCd, String fSkdVoyNo, String fDirCd, String fChkprd, String fFmMon, String fYear, String fToMon, String fFmWk, String fToWk) {
		this.vslCd = vslCd;
		this.iocRuleDesc = iocRuleDesc;
		this.fChkprd = fChkprd;
		this.fFmMon = fFmMon;
		this.deltFlg = deltFlg;
		this.vvdRmk = vvdRmk;
		this.fDirCd = fDirCd;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.fSeldir = fSeldir;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.fSelrlane = fSelrlane;
		this.fVslCd = fVslCd;
		this.n1stLodgPortEtdDt = n1stLodgPortEtdDt;
		this.dirCd = dirCd;
		this.lstLodgPortCd = lstLodgPortCd;
		this.updUsrId = updUsrId;
		this.iocCd = iocCd;
		this.updDt = updDt;
		this.fFmWk = fFmWk;
		this.fSeltrade = fSeltrade;
		this.fSelioc = fSelioc;
		this.fToMon = fToMon;
		this.skdVoyNo = skdVoyNo;
		this.fSkdVoyNo = fSkdVoyNo;
		this.lstLodgPortEtdDt = lstLodgPortEtdDt;
		this.slsYrmon = slsYrmon;
		this.fToWk = fToWk;
		this.creUsrId = creUsrId;
		this.slanCd = slanCd;
		this.costWk = costWk;
		this.fSelslane = fSelslane;
		this.subTrdCd = subTrdCd;
		this.fYear = fYear;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ioc_rule_desc", getIocRuleDesc());
		this.hashColumns.put("f_chkprd", getFChkprd());
		this.hashColumns.put("f_fm_mon", getFFmMon());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("vvd_rmk", getVvdRmk());
		this.hashColumns.put("f_dir_cd", getFDirCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_seldir", getFSeldir());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("f_selrlane", getFSelrlane());
		this.hashColumns.put("f_vsl_cd", getFVslCd());
		this.hashColumns.put("n1st_lodg_port_etd_dt", getN1stLodgPortEtdDt());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("lst_lodg_port_cd", getLstLodgPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("f_seltrade", getFSeltrade());
		this.hashColumns.put("f_selioc", getFSelioc());
		this.hashColumns.put("f_to_mon", getFToMon());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("f_skd_voy_no", getFSkdVoyNo());
		this.hashColumns.put("lst_lodg_port_etd_dt", getLstLodgPortEtdDt());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("f_selslane", getFSelslane());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("f_year", getFYear());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ioc_rule_desc", "iocRuleDesc");
		this.hashFields.put("f_chkprd", "fChkprd");
		this.hashFields.put("f_fm_mon", "fFmMon");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("vvd_rmk", "vvdRmk");
		this.hashFields.put("f_dir_cd", "fDirCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_seldir", "fSeldir");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("f_selrlane", "fSelrlane");
		this.hashFields.put("f_vsl_cd", "fVslCd");
		this.hashFields.put("n1st_lodg_port_etd_dt", "n1stLodgPortEtdDt");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("lst_lodg_port_cd", "lstLodgPortCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("f_seltrade", "fSeltrade");
		this.hashFields.put("f_selioc", "fSelioc");
		this.hashFields.put("f_to_mon", "fToMon");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("f_skd_voy_no", "fSkdVoyNo");
		this.hashFields.put("lst_lodg_port_etd_dt", "lstLodgPortEtdDt");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("f_selslane", "fSelslane");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("f_year", "fYear");
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
	 * @return iocRuleDesc
	 */
	public String getIocRuleDesc() {
		return this.iocRuleDesc;
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
	 * @return fFmMon
	 */
	public String getFFmMon() {
		return this.fFmMon;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return vvdRmk
	 */
	public String getVvdRmk() {
		return this.vvdRmk;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return fSeldir
	 */
	public String getFSeldir() {
		return this.fSeldir;
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
	 * @return fSelrlane
	 */
	public String getFSelrlane() {
		return this.fSelrlane;
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
	 * @return n1stLodgPortEtdDt
	 */
	public String getN1stLodgPortEtdDt() {
		return this.n1stLodgPortEtdDt;
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
	 * @return lstLodgPortCd
	 */
	public String getLstLodgPortCd() {
		return this.lstLodgPortCd;
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
	 * @return fFmWk
	 */
	public String getFFmWk() {
		return this.fFmWk;
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
	 * @return fSelioc
	 */
	public String getFSelioc() {
		return this.fSelioc;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return lstLodgPortEtdDt
	 */
	public String getLstLodgPortEtdDt() {
		return this.lstLodgPortEtdDt;
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
	 * @return fToWk
	 */
	public String getFToWk() {
		return this.fToWk;
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
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return fSelslane
	 */
	public String getFSelslane() {
		return this.fSelslane;
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
	 * @param fChkprd
	 */
	public void setFChkprd(String fChkprd) {
		this.fChkprd = fChkprd;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param vvdRmk
	 */
	public void setVvdRmk(String vvdRmk) {
		this.vvdRmk = vvdRmk;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param fSeldir
	 */
	public void setFSeldir(String fSeldir) {
		this.fSeldir = fSeldir;
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
	 * @param fSelrlane
	 */
	public void setFSelrlane(String fSelrlane) {
		this.fSelrlane = fSelrlane;
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
	 * @param n1stLodgPortEtdDt
	 */
	public void setN1stLodgPortEtdDt(String n1stLodgPortEtdDt) {
		this.n1stLodgPortEtdDt = n1stLodgPortEtdDt;
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
	 * @param lstLodgPortCd
	 */
	public void setLstLodgPortCd(String lstLodgPortCd) {
		this.lstLodgPortCd = lstLodgPortCd;
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
	 * @param fFmWk
	 */
	public void setFFmWk(String fFmWk) {
		this.fFmWk = fFmWk;
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
	 * @param fSelioc
	 */
	public void setFSelioc(String fSelioc) {
		this.fSelioc = fSelioc;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param lstLodgPortEtdDt
	 */
	public void setLstLodgPortEtdDt(String lstLodgPortEtdDt) {
		this.lstLodgPortEtdDt = lstLodgPortEtdDt;
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
	 * @param fToWk
	 */
	public void setFToWk(String fToWk) {
		this.fToWk = fToWk;
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
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param fSelslane
	 */
	public void setFSelslane(String fSelslane) {
		this.fSelslane = fSelslane;
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
		setIocRuleDesc(JSPUtil.getParameter(request, prefix + "ioc_rule_desc", ""));
		setFChkprd(JSPUtil.getParameter(request, prefix + "f_chkprd", ""));
		setFFmMon(JSPUtil.getParameter(request, prefix + "f_fm_mon", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setVvdRmk(JSPUtil.getParameter(request, prefix + "vvd_rmk", ""));
		setFDirCd(JSPUtil.getParameter(request, prefix + "f_dir_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFSeldir(JSPUtil.getParameter(request, prefix + "f_seldir", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setFSelrlane(JSPUtil.getParameter(request, prefix + "f_selrlane", ""));
		setFVslCd(JSPUtil.getParameter(request, prefix + "f_vsl_cd", ""));
		setN1stLodgPortEtdDt(JSPUtil.getParameter(request, prefix + "n1st_lodg_port_etd_dt", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setLstLodgPortCd(JSPUtil.getParameter(request, prefix + "lst_lodg_port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setFFmWk(JSPUtil.getParameter(request, prefix + "f_fm_wk", ""));
		setFSeltrade(JSPUtil.getParameter(request, prefix + "f_seltrade", ""));
		setFSelioc(JSPUtil.getParameter(request, prefix + "f_selioc", ""));
		setFToMon(JSPUtil.getParameter(request, prefix + "f_to_mon", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setFSkdVoyNo(JSPUtil.getParameter(request, prefix + "f_skd_voy_no", ""));
		setLstLodgPortEtdDt(JSPUtil.getParameter(request, prefix + "lst_lodg_port_etd_dt", ""));
		setSlsYrmon(JSPUtil.getParameter(request, prefix + "sls_yrmon", ""));
		setFToWk(JSPUtil.getParameter(request, prefix + "f_to_wk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setFSelslane(JSPUtil.getParameter(request, prefix + "f_selslane", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setFYear(JSPUtil.getParameter(request, prefix + "f_year", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ParamCoaMonVvdYryPlnVO[]
	 */
	public ParamCoaMonVvdYryPlnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ParamCoaMonVvdYryPlnVO[]
	 */
	public ParamCoaMonVvdYryPlnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ParamCoaMonVvdYryPlnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] iocRuleDesc = (JSPUtil.getParameter(request, prefix	+ "ioc_rule_desc", length));
			String[] fChkprd = (JSPUtil.getParameter(request, prefix	+ "f_chkprd", length));
			String[] fFmMon = (JSPUtil.getParameter(request, prefix	+ "f_fm_mon", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] vvdRmk = (JSPUtil.getParameter(request, prefix	+ "vvd_rmk", length));
			String[] fDirCd = (JSPUtil.getParameter(request, prefix	+ "f_dir_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fSeldir = (JSPUtil.getParameter(request, prefix	+ "f_seldir", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] fSelrlane = (JSPUtil.getParameter(request, prefix	+ "f_selrlane", length));
			String[] fVslCd = (JSPUtil.getParameter(request, prefix	+ "f_vsl_cd", length));
			String[] n1stLodgPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "n1st_lodg_port_etd_dt", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] lstLodgPortCd = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] fSeltrade = (JSPUtil.getParameter(request, prefix	+ "f_seltrade", length));
			String[] fSelioc = (JSPUtil.getParameter(request, prefix	+ "f_selioc", length));
			String[] fToMon = (JSPUtil.getParameter(request, prefix	+ "f_to_mon", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] fSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "f_skd_voy_no", length));
			String[] lstLodgPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_etd_dt", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] fSelslane = (JSPUtil.getParameter(request, prefix	+ "f_selslane", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			
			for (int i = 0; i < length; i++) {
				model = new ParamCoaMonVvdYryPlnVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (iocRuleDesc[i] != null)
					model.setIocRuleDesc(iocRuleDesc[i]);
				if (fChkprd[i] != null)
					model.setFChkprd(fChkprd[i]);
				if (fFmMon[i] != null)
					model.setFFmMon(fFmMon[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (vvdRmk[i] != null)
					model.setVvdRmk(vvdRmk[i]);
				if (fDirCd[i] != null)
					model.setFDirCd(fDirCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fSeldir[i] != null)
					model.setFSeldir(fSeldir[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (fSelrlane[i] != null)
					model.setFSelrlane(fSelrlane[i]);
				if (fVslCd[i] != null)
					model.setFVslCd(fVslCd[i]);
				if (n1stLodgPortEtdDt[i] != null)
					model.setN1stLodgPortEtdDt(n1stLodgPortEtdDt[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (lstLodgPortCd[i] != null)
					model.setLstLodgPortCd(lstLodgPortCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (fSeltrade[i] != null)
					model.setFSeltrade(fSeltrade[i]);
				if (fSelioc[i] != null)
					model.setFSelioc(fSelioc[i]);
				if (fToMon[i] != null)
					model.setFToMon(fToMon[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (fSkdVoyNo[i] != null)
					model.setFSkdVoyNo(fSkdVoyNo[i]);
				if (lstLodgPortEtdDt[i] != null)
					model.setLstLodgPortEtdDt(lstLodgPortEtdDt[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (fSelslane[i] != null)
					model.setFSelslane(fSelslane[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getParamCoaMonVvdYryPlnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ParamCoaMonVvdYryPlnVO[]
	 */
	public ParamCoaMonVvdYryPlnVO[] getParamCoaMonVvdYryPlnVOs(){
		ParamCoaMonVvdYryPlnVO[] vos = (ParamCoaMonVvdYryPlnVO[])models.toArray(new ParamCoaMonVvdYryPlnVO[models.size()]);
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
		this.iocRuleDesc = this.iocRuleDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkprd = this.fChkprd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmMon = this.fFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdRmk = this.vvdRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDirCd = this.fDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSeldir = this.fSeldir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSelrlane = this.fSelrlane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVslCd = this.fVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stLodgPortEtdDt = this.n1stLodgPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortCd = this.lstLodgPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSeltrade = this.fSeltrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSelioc = this.fSelioc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToMon = this.fToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdVoyNo = this.fSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortEtdDt = this.lstLodgPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSelslane = this.fSelslane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
