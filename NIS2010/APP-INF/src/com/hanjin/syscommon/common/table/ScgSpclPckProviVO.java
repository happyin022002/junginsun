/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgSpclPckProviVO.java
*@FileTitle : ScgSpclPckProviVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.29
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.05.29 원종규 
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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgSpclPckProviVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgSpclPckProviVO> models = new ArrayList<ScgSpclPckProviVO>();
	
	/* Column Info */
	private String grpN3rdUseFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String capaMassMinQty = null;
	/* Column Info */
	private String capaMassMaxQty = null;
	/* Column Info */
	private String imdgPckInstrSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String condPckCd = null;
	/* Column Info */
	private String pckMtrlTpCd = null;
	/* Column Info */
	private String pckStyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imdgPckInstrCd = null;
	/* Column Info */
	private String condPckCdDesc = null;
	/* Column Info */
	private String subSeq = null;
	/* Column Info */
	private String rulePrdTyCd = null;
	/* Column Info */
	private String spclPckProviDivCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String grpN2ndMeasUtCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String capaMassUseFlg = null;
	/* Column Info */
	private String grpN1stUseFlg = null;
	/* Column Info */
	private String condPckMtrlTpCd = null;
	/* Column Info */
	private String grpN2ndUseFlg = null;
	/* Column Info */
	private String ruleAplyTpCd = null;
	/* Column Info */
	private String prmtChkCd = null;
	/* Column Info */
	private String capaMassMeasUtCd = null;
	/* Column Info */
	private String grpN1stQty = null;
	/* Column Info */
	private String imdgPckCd = null;
	/* Column Info */
	private String condPckTpCd = null;
	/* Column Info */
	private String grpN2ndQty = null;
	/* Column Info */
	private String rulePrd = null;
	/* Column Info */
	private String spclPckDesc = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String grpN3rdMeasUtCd = null;
	/* Column Info */
	private String spclPckProviCd = null;
	/* Column Info */
	private String grpN3rdQty = null;
	/* Column Info */
	private String rulePkgTpCd = null;
	/* Column Info */
	private String sppSubCd = null;
	/* Column Info */
	private String grpN1stMeasUtCd = null;
	/* Column Info */
	private String spclPckProviDesc = null;
	/* Column Info */
	private String condPckStyCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgSpclPckProviVO() {}

	public ScgSpclPckProviVO(String ibflag, String pagerows, String imdgPckInstrCd, String imdgPckInstrSeq, String spclPckProviCd, String subSeq, String capaMassMaxQty, String capaMassMeasUtCd, String capaMassMinQty, String capaMassUseFlg, String condPckCd, String condPckCdDesc, String condPckMtrlTpCd, String condPckStyCd, String condPckTpCd, String creDt, String creUsrId, String deltFlg, String grpN1stMeasUtCd, String grpN1stQty, String grpN1stUseFlg, String grpN2ndMeasUtCd, String grpN2ndQty, String grpN2ndUseFlg, String grpN3rdMeasUtCd, String grpN3rdQty, String grpN3rdUseFlg, String imdgPckCd, String spclPckDesc, String pckMtrlTpCd, String pckStyCd, String pckTpCd, String prmtChkCd, String ruleAplyTpCd, String spclPckProviDesc, String spclPckProviDivCd, String updDt, String updUsrId, String rulePrdTyCd, String rulePkgTpCd, String rulePrd, String sppSubCd) {
		this.grpN3rdUseFlg = grpN3rdUseFlg;
		this.deltFlg = deltFlg;
		this.capaMassMinQty = capaMassMinQty;
		this.capaMassMaxQty = capaMassMaxQty;
		this.imdgPckInstrSeq = imdgPckInstrSeq;
		this.creDt = creDt;
		this.condPckCd = condPckCd;
		this.pckMtrlTpCd = pckMtrlTpCd;
		this.pckStyCd = pckStyCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.imdgPckInstrCd = imdgPckInstrCd;
		this.condPckCdDesc = condPckCdDesc;
		this.subSeq = subSeq;
		this.rulePrdTyCd = rulePrdTyCd;
		this.spclPckProviDivCd = spclPckProviDivCd;
		this.pckTpCd = pckTpCd;
		this.updUsrId = updUsrId;
		this.grpN2ndMeasUtCd = grpN2ndMeasUtCd;
		this.updDt = updDt;
		this.capaMassUseFlg = capaMassUseFlg;
		this.grpN1stUseFlg = grpN1stUseFlg;
		this.condPckMtrlTpCd = condPckMtrlTpCd;
		this.grpN2ndUseFlg = grpN2ndUseFlg;
		this.ruleAplyTpCd = ruleAplyTpCd;
		this.prmtChkCd = prmtChkCd;
		this.capaMassMeasUtCd = capaMassMeasUtCd;
		this.grpN1stQty = grpN1stQty;
		this.imdgPckCd = imdgPckCd;
		this.condPckTpCd = condPckTpCd;
		this.grpN2ndQty = grpN2ndQty;
		this.rulePrd = rulePrd;
		this.spclPckDesc = spclPckDesc;
		this.creUsrId = creUsrId;
		this.grpN3rdMeasUtCd = grpN3rdMeasUtCd;
		this.spclPckProviCd = spclPckProviCd;
		this.grpN3rdQty = grpN3rdQty;
		this.rulePkgTpCd = rulePkgTpCd;
		this.sppSubCd = sppSubCd;
		this.grpN1stMeasUtCd = grpN1stMeasUtCd;
		this.spclPckProviDesc = spclPckProviDesc;
		this.condPckStyCd = condPckStyCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("grp_n3rd_use_flg", getGrpN3rdUseFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("capa_mass_min_qty", getCapaMassMinQty());
		this.hashColumns.put("capa_mass_max_qty", getCapaMassMaxQty());
		this.hashColumns.put("imdg_pck_instr_seq", getImdgPckInstrSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cond_pck_cd", getCondPckCd());
		this.hashColumns.put("pck_mtrl_tp_cd", getPckMtrlTpCd());
		this.hashColumns.put("pck_sty_cd", getPckStyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("imdg_pck_instr_cd", getImdgPckInstrCd());
		this.hashColumns.put("cond_pck_cd_desc", getCondPckCdDesc());
		this.hashColumns.put("sub_seq", getSubSeq());
		this.hashColumns.put("rule_prd_ty_cd", getRulePrdTyCd());
		this.hashColumns.put("spcl_pck_provi_div_cd", getSpclPckProviDivCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("grp_n2nd_meas_ut_cd", getGrpN2ndMeasUtCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("capa_mass_use_flg", getCapaMassUseFlg());
		this.hashColumns.put("grp_n1st_use_flg", getGrpN1stUseFlg());
		this.hashColumns.put("cond_pck_mtrl_tp_cd", getCondPckMtrlTpCd());
		this.hashColumns.put("grp_n2nd_use_flg", getGrpN2ndUseFlg());
		this.hashColumns.put("rule_aply_tp_cd", getRuleAplyTpCd());
		this.hashColumns.put("prmt_chk_cd", getPrmtChkCd());
		this.hashColumns.put("capa_mass_meas_ut_cd", getCapaMassMeasUtCd());
		this.hashColumns.put("grp_n1st_qty", getGrpN1stQty());
		this.hashColumns.put("imdg_pck_cd", getImdgPckCd());
		this.hashColumns.put("cond_pck_tp_cd", getCondPckTpCd());
		this.hashColumns.put("grp_n2nd_qty", getGrpN2ndQty());
		this.hashColumns.put("rule_prd", getRulePrd());
		this.hashColumns.put("spcl_pck_desc", getSpclPckDesc());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("grp_n3rd_meas_ut_cd", getGrpN3rdMeasUtCd());
		this.hashColumns.put("spcl_pck_provi_cd", getSpclPckProviCd());
		this.hashColumns.put("grp_n3rd_qty", getGrpN3rdQty());
		this.hashColumns.put("rule_pkg_tp_cd", getRulePkgTpCd());
		this.hashColumns.put("spp_sub_cd", getSppSubCd());
		this.hashColumns.put("grp_n1st_meas_ut_cd", getGrpN1stMeasUtCd());
		this.hashColumns.put("spcl_pck_provi_desc", getSpclPckProviDesc());
		this.hashColumns.put("cond_pck_sty_cd", getCondPckStyCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("grp_n3rd_use_flg", "grpN3rdUseFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("capa_mass_min_qty", "capaMassMinQty");
		this.hashFields.put("capa_mass_max_qty", "capaMassMaxQty");
		this.hashFields.put("imdg_pck_instr_seq", "imdgPckInstrSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cond_pck_cd", "condPckCd");
		this.hashFields.put("pck_mtrl_tp_cd", "pckMtrlTpCd");
		this.hashFields.put("pck_sty_cd", "pckStyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imdg_pck_instr_cd", "imdgPckInstrCd");
		this.hashFields.put("cond_pck_cd_desc", "condPckCdDesc");
		this.hashFields.put("sub_seq", "subSeq");
		this.hashFields.put("rule_prd_ty_cd", "rulePrdTyCd");
		this.hashFields.put("spcl_pck_provi_div_cd", "spclPckProviDivCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("grp_n2nd_meas_ut_cd", "grpN2ndMeasUtCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("capa_mass_use_flg", "capaMassUseFlg");
		this.hashFields.put("grp_n1st_use_flg", "grpN1stUseFlg");
		this.hashFields.put("cond_pck_mtrl_tp_cd", "condPckMtrlTpCd");
		this.hashFields.put("grp_n2nd_use_flg", "grpN2ndUseFlg");
		this.hashFields.put("rule_aply_tp_cd", "ruleAplyTpCd");
		this.hashFields.put("prmt_chk_cd", "prmtChkCd");
		this.hashFields.put("capa_mass_meas_ut_cd", "capaMassMeasUtCd");
		this.hashFields.put("grp_n1st_qty", "grpN1stQty");
		this.hashFields.put("imdg_pck_cd", "imdgPckCd");
		this.hashFields.put("cond_pck_tp_cd", "condPckTpCd");
		this.hashFields.put("grp_n2nd_qty", "grpN2ndQty");
		this.hashFields.put("rule_prd", "rulePrd");
		this.hashFields.put("spcl_pck_desc", "spclPckDesc");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("grp_n3rd_meas_ut_cd", "grpN3rdMeasUtCd");
		this.hashFields.put("spcl_pck_provi_cd", "spclPckProviCd");
		this.hashFields.put("grp_n3rd_qty", "grpN3rdQty");
		this.hashFields.put("rule_pkg_tp_cd", "rulePkgTpCd");
		this.hashFields.put("spp_sub_cd", "sppSubCd");
		this.hashFields.put("grp_n1st_meas_ut_cd", "grpN1stMeasUtCd");
		this.hashFields.put("spcl_pck_provi_desc", "spclPckProviDesc");
		this.hashFields.put("cond_pck_sty_cd", "condPckStyCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return grpN3rdUseFlg
	 */
	public String getGrpN3rdUseFlg() {
		return this.grpN3rdUseFlg;
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
	 * @return capaMassMinQty
	 */
	public String getCapaMassMinQty() {
		return this.capaMassMinQty;
	}
	
	/**
	 * Column Info
	 * @return capaMassMaxQty
	 */
	public String getCapaMassMaxQty() {
		return this.capaMassMaxQty;
	}
	
	/**
	 * Column Info
	 * @return imdgPckInstrSeq
	 */
	public String getImdgPckInstrSeq() {
		return this.imdgPckInstrSeq;
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
	 * @return condPckCd
	 */
	public String getCondPckCd() {
		return this.condPckCd;
	}
	
	/**
	 * Column Info
	 * @return pckMtrlTpCd
	 */
	public String getPckMtrlTpCd() {
		return this.pckMtrlTpCd;
	}
	
	/**
	 * Column Info
	 * @return pckStyCd
	 */
	public String getPckStyCd() {
		return this.pckStyCd;
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
	 * @return imdgPckInstrCd
	 */
	public String getImdgPckInstrCd() {
		return this.imdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @return condPckCdDesc
	 */
	public String getCondPckCdDesc() {
		return this.condPckCdDesc;
	}
	
	/**
	 * Column Info
	 * @return subSeq
	 */
	public String getSubSeq() {
		return this.subSeq;
	}
	
	/**
	 * Column Info
	 * @return rulePrdTyCd
	 */
	public String getRulePrdTyCd() {
		return this.rulePrdTyCd;
	}
	
	/**
	 * Column Info
	 * @return spclPckProviDivCd
	 */
	public String getSpclPckProviDivCd() {
		return this.spclPckProviDivCd;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
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
	 * @return grpN2ndMeasUtCd
	 */
	public String getGrpN2ndMeasUtCd() {
		return this.grpN2ndMeasUtCd;
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
	 * @return capaMassUseFlg
	 */
	public String getCapaMassUseFlg() {
		return this.capaMassUseFlg;
	}
	
	/**
	 * Column Info
	 * @return grpN1stUseFlg
	 */
	public String getGrpN1stUseFlg() {
		return this.grpN1stUseFlg;
	}
	
	/**
	 * Column Info
	 * @return condPckMtrlTpCd
	 */
	public String getCondPckMtrlTpCd() {
		return this.condPckMtrlTpCd;
	}
	
	/**
	 * Column Info
	 * @return grpN2ndUseFlg
	 */
	public String getGrpN2ndUseFlg() {
		return this.grpN2ndUseFlg;
	}
	
	/**
	 * Column Info
	 * @return ruleAplyTpCd
	 */
	public String getRuleAplyTpCd() {
		return this.ruleAplyTpCd;
	}
	
	/**
	 * Column Info
	 * @return prmtChkCd
	 */
	public String getPrmtChkCd() {
		return this.prmtChkCd;
	}
	
	/**
	 * Column Info
	 * @return capaMassMeasUtCd
	 */
	public String getCapaMassMeasUtCd() {
		return this.capaMassMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return grpN1stQty
	 */
	public String getGrpN1stQty() {
		return this.grpN1stQty;
	}
	
	/**
	 * Column Info
	 * @return imdgPckCd
	 */
	public String getImdgPckCd() {
		return this.imdgPckCd;
	}
	
	/**
	 * Column Info
	 * @return condPckTpCd
	 */
	public String getCondPckTpCd() {
		return this.condPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return grpN2ndQty
	 */
	public String getGrpN2ndQty() {
		return this.grpN2ndQty;
	}
	
	/**
	 * Column Info
	 * @return rulePrd
	 */
	public String getRulePrd() {
		return this.rulePrd;
	}
	
	/**
	 * Column Info
	 * @return spclPckDesc
	 */
	public String getSpclPckDesc() {
		return this.spclPckDesc;
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
	 * @return grpN3rdMeasUtCd
	 */
	public String getGrpN3rdMeasUtCd() {
		return this.grpN3rdMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return spclPckProviCd
	 */
	public String getSpclPckProviCd() {
		return this.spclPckProviCd;
	}
	
	/**
	 * Column Info
	 * @return grpN3rdQty
	 */
	public String getGrpN3rdQty() {
		return this.grpN3rdQty;
	}
	
	/**
	 * Column Info
	 * @return rulePkgTpCd
	 */
	public String getRulePkgTpCd() {
		return this.rulePkgTpCd;
	}
	
	/**
	 * Column Info
	 * @return sppSubCd
	 */
	public String getSppSubCd() {
		return this.sppSubCd;
	}
	
	/**
	 * Column Info
	 * @return grpN1stMeasUtCd
	 */
	public String getGrpN1stMeasUtCd() {
		return this.grpN1stMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return spclPckProviDesc
	 */
	public String getSpclPckProviDesc() {
		return this.spclPckProviDesc;
	}
	
	/**
	 * Column Info
	 * @return condPckStyCd
	 */
	public String getCondPckStyCd() {
		return this.condPckStyCd;
	}
	

	/**
	 * Column Info
	 * @param grpN3rdUseFlg
	 */
	public void setGrpN3rdUseFlg(String grpN3rdUseFlg) {
		this.grpN3rdUseFlg = grpN3rdUseFlg;
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
	 * @param capaMassMinQty
	 */
	public void setCapaMassMinQty(String capaMassMinQty) {
		this.capaMassMinQty = capaMassMinQty;
	}
	
	/**
	 * Column Info
	 * @param capaMassMaxQty
	 */
	public void setCapaMassMaxQty(String capaMassMaxQty) {
		this.capaMassMaxQty = capaMassMaxQty;
	}
	
	/**
	 * Column Info
	 * @param imdgPckInstrSeq
	 */
	public void setImdgPckInstrSeq(String imdgPckInstrSeq) {
		this.imdgPckInstrSeq = imdgPckInstrSeq;
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
	 * @param condPckCd
	 */
	public void setCondPckCd(String condPckCd) {
		this.condPckCd = condPckCd;
	}
	
	/**
	 * Column Info
	 * @param pckMtrlTpCd
	 */
	public void setPckMtrlTpCd(String pckMtrlTpCd) {
		this.pckMtrlTpCd = pckMtrlTpCd;
	}
	
	/**
	 * Column Info
	 * @param pckStyCd
	 */
	public void setPckStyCd(String pckStyCd) {
		this.pckStyCd = pckStyCd;
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
	 * @param imdgPckInstrCd
	 */
	public void setImdgPckInstrCd(String imdgPckInstrCd) {
		this.imdgPckInstrCd = imdgPckInstrCd;
	}
	
	/**
	 * Column Info
	 * @param condPckCdDesc
	 */
	public void setCondPckCdDesc(String condPckCdDesc) {
		this.condPckCdDesc = condPckCdDesc;
	}
	
	/**
	 * Column Info
	 * @param subSeq
	 */
	public void setSubSeq(String subSeq) {
		this.subSeq = subSeq;
	}
	
	/**
	 * Column Info
	 * @param rulePrdTyCd
	 */
	public void setRulePrdTyCd(String rulePrdTyCd) {
		this.rulePrdTyCd = rulePrdTyCd;
	}
	
	/**
	 * Column Info
	 * @param spclPckProviDivCd
	 */
	public void setSpclPckProviDivCd(String spclPckProviDivCd) {
		this.spclPckProviDivCd = spclPckProviDivCd;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
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
	 * @param grpN2ndMeasUtCd
	 */
	public void setGrpN2ndMeasUtCd(String grpN2ndMeasUtCd) {
		this.grpN2ndMeasUtCd = grpN2ndMeasUtCd;
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
	 * @param capaMassUseFlg
	 */
	public void setCapaMassUseFlg(String capaMassUseFlg) {
		this.capaMassUseFlg = capaMassUseFlg;
	}
	
	/**
	 * Column Info
	 * @param grpN1stUseFlg
	 */
	public void setGrpN1stUseFlg(String grpN1stUseFlg) {
		this.grpN1stUseFlg = grpN1stUseFlg;
	}
	
	/**
	 * Column Info
	 * @param condPckMtrlTpCd
	 */
	public void setCondPckMtrlTpCd(String condPckMtrlTpCd) {
		this.condPckMtrlTpCd = condPckMtrlTpCd;
	}
	
	/**
	 * Column Info
	 * @param grpN2ndUseFlg
	 */
	public void setGrpN2ndUseFlg(String grpN2ndUseFlg) {
		this.grpN2ndUseFlg = grpN2ndUseFlg;
	}
	
	/**
	 * Column Info
	 * @param ruleAplyTpCd
	 */
	public void setRuleAplyTpCd(String ruleAplyTpCd) {
		this.ruleAplyTpCd = ruleAplyTpCd;
	}
	
	/**
	 * Column Info
	 * @param prmtChkCd
	 */
	public void setPrmtChkCd(String prmtChkCd) {
		this.prmtChkCd = prmtChkCd;
	}
	
	/**
	 * Column Info
	 * @param capaMassMeasUtCd
	 */
	public void setCapaMassMeasUtCd(String capaMassMeasUtCd) {
		this.capaMassMeasUtCd = capaMassMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param grpN1stQty
	 */
	public void setGrpN1stQty(String grpN1stQty) {
		this.grpN1stQty = grpN1stQty;
	}
	
	/**
	 * Column Info
	 * @param imdgPckCd
	 */
	public void setImdgPckCd(String imdgPckCd) {
		this.imdgPckCd = imdgPckCd;
	}
	
	/**
	 * Column Info
	 * @param condPckTpCd
	 */
	public void setCondPckTpCd(String condPckTpCd) {
		this.condPckTpCd = condPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param grpN2ndQty
	 */
	public void setGrpN2ndQty(String grpN2ndQty) {
		this.grpN2ndQty = grpN2ndQty;
	}
	
	/**
	 * Column Info
	 * @param rulePrd
	 */
	public void setRulePrd(String rulePrd) {
		this.rulePrd = rulePrd;
	}
	
	/**
	 * Column Info
	 * @param spclPckDesc
	 */
	public void setSpclPckDesc(String spclPckDesc) {
		this.spclPckDesc = spclPckDesc;
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
	 * @param grpN3rdMeasUtCd
	 */
	public void setGrpN3rdMeasUtCd(String grpN3rdMeasUtCd) {
		this.grpN3rdMeasUtCd = grpN3rdMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param spclPckProviCd
	 */
	public void setSpclPckProviCd(String spclPckProviCd) {
		this.spclPckProviCd = spclPckProviCd;
	}
	
	/**
	 * Column Info
	 * @param grpN3rdQty
	 */
	public void setGrpN3rdQty(String grpN3rdQty) {
		this.grpN3rdQty = grpN3rdQty;
	}
	
	/**
	 * Column Info
	 * @param rulePkgTpCd
	 */
	public void setRulePkgTpCd(String rulePkgTpCd) {
		this.rulePkgTpCd = rulePkgTpCd;
	}
	
	/**
	 * Column Info
	 * @param sppSubCd
	 */
	public void setSppSubCd(String sppSubCd) {
		this.sppSubCd = sppSubCd;
	}
	
	/**
	 * Column Info
	 * @param grpN1stMeasUtCd
	 */
	public void setGrpN1stMeasUtCd(String grpN1stMeasUtCd) {
		this.grpN1stMeasUtCd = grpN1stMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param spclPckProviDesc
	 */
	public void setSpclPckProviDesc(String spclPckProviDesc) {
		this.spclPckProviDesc = spclPckProviDesc;
	}
	
	/**
	 * Column Info
	 * @param condPckStyCd
	 */
	public void setCondPckStyCd(String condPckStyCd) {
		this.condPckStyCd = condPckStyCd;
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
		setGrpN3rdUseFlg(JSPUtil.getParameter(request, prefix + "grp_n3rd_use_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCapaMassMinQty(JSPUtil.getParameter(request, prefix + "capa_mass_min_qty", ""));
		setCapaMassMaxQty(JSPUtil.getParameter(request, prefix + "capa_mass_max_qty", ""));
		setImdgPckInstrSeq(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCondPckCd(JSPUtil.getParameter(request, prefix + "cond_pck_cd", ""));
		setPckMtrlTpCd(JSPUtil.getParameter(request, prefix + "pck_mtrl_tp_cd", ""));
		setPckStyCd(JSPUtil.getParameter(request, prefix + "pck_sty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setImdgPckInstrCd(JSPUtil.getParameter(request, prefix + "imdg_pck_instr_cd", ""));
		setCondPckCdDesc(JSPUtil.getParameter(request, prefix + "cond_pck_cd_desc", ""));
		setSubSeq(JSPUtil.getParameter(request, prefix + "sub_seq", ""));
		setRulePrdTyCd(JSPUtil.getParameter(request, prefix + "rule_prd_ty_cd", ""));
		setSpclPckProviDivCd(JSPUtil.getParameter(request, prefix + "spcl_pck_provi_div_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setGrpN2ndMeasUtCd(JSPUtil.getParameter(request, prefix + "grp_n2nd_meas_ut_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCapaMassUseFlg(JSPUtil.getParameter(request, prefix + "capa_mass_use_flg", ""));
		setGrpN1stUseFlg(JSPUtil.getParameter(request, prefix + "grp_n1st_use_flg", ""));
		setCondPckMtrlTpCd(JSPUtil.getParameter(request, prefix + "cond_pck_mtrl_tp_cd", ""));
		setGrpN2ndUseFlg(JSPUtil.getParameter(request, prefix + "grp_n2nd_use_flg", ""));
		setRuleAplyTpCd(JSPUtil.getParameter(request, prefix + "rule_aply_tp_cd", ""));
		setPrmtChkCd(JSPUtil.getParameter(request, prefix + "prmt_chk_cd", ""));
		setCapaMassMeasUtCd(JSPUtil.getParameter(request, prefix + "capa_mass_meas_ut_cd", ""));
		setGrpN1stQty(JSPUtil.getParameter(request, prefix + "grp_n1st_qty", ""));
		setImdgPckCd(JSPUtil.getParameter(request, prefix + "imdg_pck_cd", ""));
		setCondPckTpCd(JSPUtil.getParameter(request, prefix + "cond_pck_tp_cd", ""));
		setGrpN2ndQty(JSPUtil.getParameter(request, prefix + "grp_n2nd_qty", ""));
		setRulePrd(JSPUtil.getParameter(request, prefix + "rule_prd", ""));
		setSpclPckDesc(JSPUtil.getParameter(request, prefix + "spcl_pck_desc", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setGrpN3rdMeasUtCd(JSPUtil.getParameter(request, prefix + "grp_n3rd_meas_ut_cd", ""));
		setSpclPckProviCd(JSPUtil.getParameter(request, prefix + "spcl_pck_provi_cd", ""));
		setGrpN3rdQty(JSPUtil.getParameter(request, prefix + "grp_n3rd_qty", ""));
		setRulePkgTpCd(JSPUtil.getParameter(request, prefix + "rule_pkg_tp_cd", ""));
		setSppSubCd(JSPUtil.getParameter(request, prefix + "spp_sub_cd", ""));
		setGrpN1stMeasUtCd(JSPUtil.getParameter(request, prefix + "grp_n1st_meas_ut_cd", ""));
		setSpclPckProviDesc(JSPUtil.getParameter(request, prefix + "spcl_pck_provi_desc", ""));
		setCondPckStyCd(JSPUtil.getParameter(request, prefix + "cond_pck_sty_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgSpclPckProviVO[]
	 */
	public ScgSpclPckProviVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgSpclPckProviVO[]
	 */
	public ScgSpclPckProviVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgSpclPckProviVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] grpN3rdUseFlg = (JSPUtil.getParameter(request, prefix	+ "grp_n3rd_use_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] capaMassMinQty = (JSPUtil.getParameter(request, prefix	+ "capa_mass_min_qty", length));
			String[] capaMassMaxQty = (JSPUtil.getParameter(request, prefix	+ "capa_mass_max_qty", length));
			String[] imdgPckInstrSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] condPckCd = (JSPUtil.getParameter(request, prefix	+ "cond_pck_cd", length));
			String[] pckMtrlTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_mtrl_tp_cd", length));
			String[] pckStyCd = (JSPUtil.getParameter(request, prefix	+ "pck_sty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] imdgPckInstrCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_instr_cd", length));
			String[] condPckCdDesc = (JSPUtil.getParameter(request, prefix	+ "cond_pck_cd_desc", length));
			String[] subSeq = (JSPUtil.getParameter(request, prefix	+ "sub_seq", length));
			String[] rulePrdTyCd = (JSPUtil.getParameter(request, prefix	+ "rule_prd_ty_cd", length));
			String[] spclPckProviDivCd = (JSPUtil.getParameter(request, prefix	+ "spcl_pck_provi_div_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] grpN2ndMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "grp_n2nd_meas_ut_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] capaMassUseFlg = (JSPUtil.getParameter(request, prefix	+ "capa_mass_use_flg", length));
			String[] grpN1stUseFlg = (JSPUtil.getParameter(request, prefix	+ "grp_n1st_use_flg", length));
			String[] condPckMtrlTpCd = (JSPUtil.getParameter(request, prefix	+ "cond_pck_mtrl_tp_cd", length));
			String[] grpN2ndUseFlg = (JSPUtil.getParameter(request, prefix	+ "grp_n2nd_use_flg", length));
			String[] ruleAplyTpCd = (JSPUtil.getParameter(request, prefix	+ "rule_aply_tp_cd", length));
			String[] prmtChkCd = (JSPUtil.getParameter(request, prefix	+ "prmt_chk_cd", length));
			String[] capaMassMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "capa_mass_meas_ut_cd", length));
			String[] grpN1stQty = (JSPUtil.getParameter(request, prefix	+ "grp_n1st_qty", length));
			String[] imdgPckCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_cd", length));
			String[] condPckTpCd = (JSPUtil.getParameter(request, prefix	+ "cond_pck_tp_cd", length));
			String[] grpN2ndQty = (JSPUtil.getParameter(request, prefix	+ "grp_n2nd_qty", length));
			String[] rulePrd = (JSPUtil.getParameter(request, prefix	+ "rule_prd", length));
			String[] spclPckDesc = (JSPUtil.getParameter(request, prefix	+ "spcl_pck_desc", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] grpN3rdMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "grp_n3rd_meas_ut_cd", length));
			String[] spclPckProviCd = (JSPUtil.getParameter(request, prefix	+ "spcl_pck_provi_cd", length));
			String[] grpN3rdQty = (JSPUtil.getParameter(request, prefix	+ "grp_n3rd_qty", length));
			String[] rulePkgTpCd = (JSPUtil.getParameter(request, prefix	+ "rule_pkg_tp_cd", length));
			String[] sppSubCd = (JSPUtil.getParameter(request, prefix	+ "spp_sub_cd", length));
			String[] grpN1stMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "grp_n1st_meas_ut_cd", length));
			String[] spclPckProviDesc = (JSPUtil.getParameter(request, prefix	+ "spcl_pck_provi_desc", length));
			String[] condPckStyCd = (JSPUtil.getParameter(request, prefix	+ "cond_pck_sty_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgSpclPckProviVO();
				if (grpN3rdUseFlg[i] != null)
					model.setGrpN3rdUseFlg(grpN3rdUseFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (capaMassMinQty[i] != null)
					model.setCapaMassMinQty(capaMassMinQty[i]);
				if (capaMassMaxQty[i] != null)
					model.setCapaMassMaxQty(capaMassMaxQty[i]);
				if (imdgPckInstrSeq[i] != null)
					model.setImdgPckInstrSeq(imdgPckInstrSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (condPckCd[i] != null)
					model.setCondPckCd(condPckCd[i]);
				if (pckMtrlTpCd[i] != null)
					model.setPckMtrlTpCd(pckMtrlTpCd[i]);
				if (pckStyCd[i] != null)
					model.setPckStyCd(pckStyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imdgPckInstrCd[i] != null)
					model.setImdgPckInstrCd(imdgPckInstrCd[i]);
				if (condPckCdDesc[i] != null)
					model.setCondPckCdDesc(condPckCdDesc[i]);
				if (subSeq[i] != null)
					model.setSubSeq(subSeq[i]);
				if (rulePrdTyCd[i] != null)
					model.setRulePrdTyCd(rulePrdTyCd[i]);
				if (spclPckProviDivCd[i] != null)
					model.setSpclPckProviDivCd(spclPckProviDivCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (grpN2ndMeasUtCd[i] != null)
					model.setGrpN2ndMeasUtCd(grpN2ndMeasUtCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (capaMassUseFlg[i] != null)
					model.setCapaMassUseFlg(capaMassUseFlg[i]);
				if (grpN1stUseFlg[i] != null)
					model.setGrpN1stUseFlg(grpN1stUseFlg[i]);
				if (condPckMtrlTpCd[i] != null)
					model.setCondPckMtrlTpCd(condPckMtrlTpCd[i]);
				if (grpN2ndUseFlg[i] != null)
					model.setGrpN2ndUseFlg(grpN2ndUseFlg[i]);
				if (ruleAplyTpCd[i] != null)
					model.setRuleAplyTpCd(ruleAplyTpCd[i]);
				if (prmtChkCd[i] != null)
					model.setPrmtChkCd(prmtChkCd[i]);
				if (capaMassMeasUtCd[i] != null)
					model.setCapaMassMeasUtCd(capaMassMeasUtCd[i]);
				if (grpN1stQty[i] != null)
					model.setGrpN1stQty(grpN1stQty[i]);
				if (imdgPckCd[i] != null)
					model.setImdgPckCd(imdgPckCd[i]);
				if (condPckTpCd[i] != null)
					model.setCondPckTpCd(condPckTpCd[i]);
				if (grpN2ndQty[i] != null)
					model.setGrpN2ndQty(grpN2ndQty[i]);
				if (rulePrd[i] != null)
					model.setRulePrd(rulePrd[i]);
				if (spclPckDesc[i] != null)
					model.setSpclPckDesc(spclPckDesc[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (grpN3rdMeasUtCd[i] != null)
					model.setGrpN3rdMeasUtCd(grpN3rdMeasUtCd[i]);
				if (spclPckProviCd[i] != null)
					model.setSpclPckProviCd(spclPckProviCd[i]);
				if (grpN3rdQty[i] != null)
					model.setGrpN3rdQty(grpN3rdQty[i]);
				if (rulePkgTpCd[i] != null)
					model.setRulePkgTpCd(rulePkgTpCd[i]);
				if (sppSubCd[i] != null)
					model.setSppSubCd(sppSubCd[i]);
				if (grpN1stMeasUtCd[i] != null)
					model.setGrpN1stMeasUtCd(grpN1stMeasUtCd[i]);
				if (spclPckProviDesc[i] != null)
					model.setSpclPckProviDesc(spclPckProviDesc[i]);
				if (condPckStyCd[i] != null)
					model.setCondPckStyCd(condPckStyCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgSpclPckProviVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgSpclPckProviVO[]
	 */
	public ScgSpclPckProviVO[] getScgSpclPckProviVOs(){
		ScgSpclPckProviVO[] vos = (ScgSpclPckProviVO[])models.toArray(new ScgSpclPckProviVO[models.size()]);
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
		this.grpN3rdUseFlg = this.grpN3rdUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capaMassMinQty = this.capaMassMinQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capaMassMaxQty = this.capaMassMaxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrSeq = this.imdgPckInstrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condPckCd = this.condPckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckMtrlTpCd = this.pckMtrlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckStyCd = this.pckStyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckInstrCd = this.imdgPckInstrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condPckCdDesc = this.condPckCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSeq = this.subSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rulePrdTyCd = this.rulePrdTyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclPckProviDivCd = this.spclPckProviDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN2ndMeasUtCd = this.grpN2ndMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capaMassUseFlg = this.capaMassUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN1stUseFlg = this.grpN1stUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condPckMtrlTpCd = this.condPckMtrlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN2ndUseFlg = this.grpN2ndUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ruleAplyTpCd = this.ruleAplyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prmtChkCd = this.prmtChkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capaMassMeasUtCd = this.capaMassMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN1stQty = this.grpN1stQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckCd = this.imdgPckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condPckTpCd = this.condPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN2ndQty = this.grpN2ndQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rulePrd = this.rulePrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclPckDesc = this.spclPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN3rdMeasUtCd = this.grpN3rdMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclPckProviCd = this.spclPckProviCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN3rdQty = this.grpN3rdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rulePkgTpCd = this.rulePkgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sppSubCd = this.sppSubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpN1stMeasUtCd = this.grpN1stMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclPckProviDesc = this.spclPckProviDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condPckStyCd = this.condPckStyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
