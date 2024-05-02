/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EtaSendMoniVO.java
*@FileTitle : EtaSendMoniVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.09 진마리아 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EtaSendMoniVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EtaSendMoniVO> models = new ArrayList<EtaSendMoniVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String actBrthDt = null;
	/* Column Info */
	private String crntRpmPwr = null;
	/* Column Info */
	private String trsmOwnrCd = null;
	/* Column Info */
	private String actArrDt = null;
	/* Column Info */
	private String actDepDt = null;
	/* Column Info */	
	private String tmlCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String rpmAdjDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trsmMzdNm = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lstFlg = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String toEtaDt = null;
	/* Column Info */
	private String trsmMzdCd = null;
	/* Column Info */
	private String ntcEtaDt = null;
	/* Column Info */
	private String difOverArrDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ntcEtbDt = null;
	/* Column Info */
	private String orgRpmPwr = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String fmEtaDt = null;
	/* Column Info */
	private String vskdPortRhqCd = null;
	/* Column Info */
	private String vopPortCtrlOfcCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String actCrrCd = null;
	/* Column Info */
	private String difOverBrthDt = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String trsmHisSeq = null;
	/* Column Info */
	private String trsmLoclDt = null;
	/* Column Info */
	private String esvcVndrSeq = null;
	
	/* Column Info */
	private String trsmPurpCd = null;
	
	/* Column Info */
	private String stwDifHrs = null;	
	
	/* Column Info */
	private String pobDt = null;	
	/* Column Info */
	private String drpAnkDt = null;	
	/* Column Info */
	private String difCstActArrDt = null;	
	/* Column Info */
	private String difCstActBrthDt = null;	
	/* Column Info */
	private String difCstNtcArrDt = null;	
	/* Column Info */
	private String difCstNtcBrthDt = null;	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EtaSendMoniVO() {}

	public EtaSendMoniVO(String ibflag, String pagerows, String rhqOfcCd, String ctrlOfcCd, String vpsPortCd, String ydCd, String slanCd, String vvd, String vslEngNm, String actCrrCd, String vpsEtaDt, String vpsEtbDt, String actArrDt, String actBrthDt, String actDepDt, String ntcEtaDt, String ntcEtbDt, String trsmLoclDt, String updUsrId, String difOverArrDt, String difOverBrthDt, String trsmMzdCd, String rpmAdjDt, String orgRpmPwr, String crntRpmPwr, String esvcVndrSeq, String trsmHisSeq, String trsmOwnrCd, String fmEtaDt, String toEtaDt, String vskdPortRhqCd, String vopPortCtrlOfcCd, String tmlCd, String vslCd, String skdVoyNo, String skdDirCd, String trsmMzdNm, String lstFlg, String trsmPurpCd, String stwDifHrs) {
		this.vslCd = vslCd;
		this.vpsEtbDt = vpsEtbDt;
		this.actBrthDt = actBrthDt;
		this.actDepDt = actDepDt;
		this.crntRpmPwr = crntRpmPwr;
		this.trsmOwnrCd = trsmOwnrCd;
		this.actArrDt = actArrDt;
		this.tmlCd = tmlCd;
		this.vpsEtaDt = vpsEtaDt;
		this.rpmAdjDt = rpmAdjDt;
		this.pagerows = pagerows;
		this.trsmMzdNm = trsmMzdNm;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.lstFlg = lstFlg;
		this.vslEngNm = vslEngNm;
		this.toEtaDt = toEtaDt;
		this.trsmMzdCd = trsmMzdCd;
		this.ntcEtaDt = ntcEtaDt;
		this.difOverArrDt = difOverArrDt;
		this.updUsrId = updUsrId;
		this.ntcEtbDt = ntcEtbDt;
		this.orgRpmPwr = orgRpmPwr;
		this.skdVoyNo = skdVoyNo;
		this.ctrlOfcCd = ctrlOfcCd;
		this.skdDirCd = skdDirCd;
		this.fmEtaDt = fmEtaDt;
		this.vskdPortRhqCd = vskdPortRhqCd;
		this.vopPortCtrlOfcCd = vopPortCtrlOfcCd;
		this.vvd = vvd;
		this.rhqOfcCd = rhqOfcCd;
		this.actCrrCd = actCrrCd;
		this.difOverBrthDt = difOverBrthDt;
		this.slanCd = slanCd;
		this.ydCd = ydCd;
		this.trsmHisSeq = trsmHisSeq;
		this.trsmLoclDt = trsmLoclDt;
		this.esvcVndrSeq = esvcVndrSeq;
		this.trsmPurpCd = trsmPurpCd;
		
		this.stwDifHrs = stwDifHrs;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("act_brth_dt", getActBrthDt());
		this.hashColumns.put("act_dep_dt", getActDepDt());
		this.hashColumns.put("crnt_rpm_pwr", getCrntRpmPwr());
		this.hashColumns.put("trsm_ownr_cd", getTrsmOwnrCd());
		this.hashColumns.put("act_arr_dt", getActArrDt());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("rpm_adj_dt", getRpmAdjDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trsm_mzd_nm", getTrsmMzdNm());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lst_flg", getLstFlg());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("to_eta_dt", getToEtaDt());
		this.hashColumns.put("trsm_mzd_cd", getTrsmMzdCd());
		this.hashColumns.put("ntc_eta_dt", getNtcEtaDt());
		this.hashColumns.put("dif_over_arr_dt", getDifOverArrDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ntc_etb_dt", getNtcEtbDt());
		this.hashColumns.put("org_rpm_pwr", getOrgRpmPwr());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("fm_eta_dt", getFmEtaDt());
		this.hashColumns.put("vskd_port_rhq_cd", getVskdPortRhqCd());
		this.hashColumns.put("vop_port_ctrl_ofc_cd", getVopPortCtrlOfcCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("act_crr_cd", getActCrrCd());
		this.hashColumns.put("dif_over_brth_dt", getdifOverBrthDt());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("trsm_his_seq", getTrsmHisSeq());
		this.hashColumns.put("trsm_locl_dt", getTrsmLoclDt());
		this.hashColumns.put("esvc_vndr_seq", getEsvcVndrSeq());
		this.hashColumns.put("trsm_purp_cd", getTrsmPurpCd());
		
		this.hashColumns.put("stw_dif_hrs", getStwDifHrs());
		
		this.hashColumns.put("pob_dt"				, getPobDt());
		this.hashColumns.put("drp_ank_dt"			, getDrpAnkDt());
		this.hashColumns.put("dif_cst_act_arr_dt"	, getDifCstActArrDt());
		this.hashColumns.put("dif_cst_act_brth_dt"	, getDifCstActBrthDt());
		this.hashColumns.put("dif_cst_ntc_arr_dt"	, getDifCstNtcArrDt());
		this.hashColumns.put("dif_cst_ntc_brth_dt"	, getDifCstNtcBrthDt());
		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("act_brth_dt", "actBrthDt");
		this.hashFields.put("act_dep_dt", "actDepDt");
		this.hashFields.put("crnt_rpm_pwr", "crntRpmPwr");
		this.hashFields.put("trsm_ownr_cd", "trsmOwnrCd");
		this.hashFields.put("act_arr_dt", "actArrDt");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("rpm_adj_dt", "rpmAdjDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trsm_mzd_nm", "trsmMzdNm");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lst_flg", "lstFlg");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("to_eta_dt", "toEtaDt");
		this.hashFields.put("trsm_mzd_cd", "trsmMzdCd");
		this.hashFields.put("ntc_eta_dt", "ntcEtaDt");
		this.hashFields.put("dif_over_arr_dt", "difOverArrDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ntc_etb_dt", "ntcEtbDt");
		this.hashFields.put("org_rpm_pwr", "orgRpmPwr");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("fm_eta_dt", "fmEtaDt");
		this.hashFields.put("vskd_port_rhq_cd", "vskdPortRhqCd");
		this.hashFields.put("vop_port_ctrl_ofc_cd", "vopPortCtrlOfcCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("act_crr_cd", "actCrrCd");
		this.hashFields.put("dif_over_brth_dt", "difOverBrthDt");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("trsm_his_seq", "trsmHisSeq");
		this.hashFields.put("trsm_locl_dt", "trsmLoclDt");
		this.hashFields.put("esvc_vndr_seq", "esvcVndrSeq");
		this.hashFields.put("trsm_purp_cd", "trsmPurpCd");
		
		this.hashFields.put("stw_dif_hrs", "stwDifHrs");
		
		this.hashFields.put("pob_dt", "pobDt");
		this.hashFields.put("drp_ank_dt", "drpAnkDt");
		this.hashFields.put("dif_cst_act_arr_dt", "difCstActArrDt");
		this.hashFields.put("dif_cst_act_brth_dt", "difCstActBrthDt");
		this.hashFields.put("dif_cst_ntc_arr_dt", "difCstNtcArrDt");
		this.hashFields.put("dif_cst_ntc_brth_dt", "difCstNtcBrthDt");
		
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
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return actBrthDt
	 */
	public String getActBrthDt() {
		return this.actBrthDt;
	}
	
	/**
	 * Column Info
	 * @return actDepDt
	 */
	public String getActDepDt() {
		return this.actDepDt;
	}	
	
	/**
	 * Column Info
	 * @return crntRpmPwr
	 */
	public String getCrntRpmPwr() {
		return this.crntRpmPwr;
	}
	
	/**
	 * Column Info
	 * @return trsmOwnrCd
	 */
	public String getTrsmOwnrCd() {
		return this.trsmOwnrCd;
	}
	
	/**
	 * Column Info
	 * @return actArrDt
	 */
	public String getActArrDt() {
		return this.actArrDt;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return rpmAdjDt
	 */
	public String getRpmAdjDt() {
		return this.rpmAdjDt;
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
	 * @return trsmMzdNm
	 */
	public String getTrsmMzdNm() {
		return this.trsmMzdNm;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return lstFlg
	 */
	public String getLstFlg() {
		return this.lstFlg;
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
	 * @return toEtaDt
	 */
	public String getToEtaDt() {
		return this.toEtaDt;
	}
	
	/**
	 * Column Info
	 * @return trsmMzdCd
	 */
	public String getTrsmMzdCd() {
		return this.trsmMzdCd;
	}
	
	/**
	 * Column Info
	 * @return ntcEtaDt
	 */
	public String getNtcEtaDt() {
		return this.ntcEtaDt;
	}
	
	/**
	 * Column Info
	 * @return difOverArrDt
	 */
	public String getDifOverArrDt() {
		return this.difOverArrDt;
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
	 * @return ntcEtbDt
	 */
	public String getNtcEtbDt() {
		return this.ntcEtbDt;
	}
	
	/**
	 * Column Info
	 * @return orgRpmPwr
	 */
	public String getOrgRpmPwr() {
		return this.orgRpmPwr;
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
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
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
	 * @return fmEtaDt
	 */
	public String getFmEtaDt() {
		return this.fmEtaDt;
	}
	
	/**
	 * Column Info
	 * @return vskdPortRhqCd
	 */
	public String getVskdPortRhqCd() {
		return this.vskdPortRhqCd;
	}
	
	/**
	 * Column Info
	 * @return vopPortCtrlOfcCd
	 */
	public String getVopPortCtrlOfcCd() {
		return this.vopPortCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return actCrrCd
	 */
	public String getActCrrCd() {
		return this.actCrrCd;
	}
	
	/**
	 * Column Info
	 * @return difOverBrthDt
	 */
	public String getdifOverBrthDt() {
		return this.difOverBrthDt;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return trsmHisSeq
	 */
	public String getTrsmHisSeq() {
		return this.trsmHisSeq;
	}
	
	/**
	 * Column Info
	 * @return trsmLoclDt
	 */
	public String getTrsmLoclDt() {
		return this.trsmLoclDt;
	}
	
	/**
	 * Column Info
	 * @return esvcVndrSeq
	 */
	public String getEsvcVndrSeq() {
		return this.esvcVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return trsmPurpCd
	 */
	public String getTrsmPurpCd() {
		return this.trsmPurpCd;
	}	
	
	/**
	 * Column Info
	 * @return stwDifHrs
	 */
	public String getStwDifHrs() {
		return this.stwDifHrs;
	}	

	/**
	 * Column Info
	 * @return pobDt
	 */
	public String getPobDt() {
		return this.pobDt;
	}	
	/**
	 * Column Info
	 * @return drpAnkDt
	 */
	public String getDrpAnkDt() {
		return this.drpAnkDt;
	}	
	/**
	 * Column Info
	 * @return difCstActArrDt
	 */
	public String getDifCstActArrDt() {
		return this.difCstActArrDt;
	}	
	/**
	 * Column Info
	 * @return difCstActBrthDt
	 */
	public String getDifCstActBrthDt() {
		return this.difCstActBrthDt;
	}	
	/**
	 * Column Info
	 * @return difCstNtcArrDt
	 */
	public String getDifCstNtcArrDt() {
		return this.difCstNtcArrDt;
	}	
	/**
	 * Column Info
	 * @return difCstNtcBrthDt
	 */
	public String getDifCstNtcBrthDt() {
		return this.difCstNtcBrthDt;
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
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param actBrthDt
	 */
	public void setActBrthDt(String actBrthDt) {
		this.actBrthDt = actBrthDt;
	}
	
	/**
	 * Column Info
	 * @param actDepDt
	 */
	public void setActDepDt(String actDepDt) {
		this.actDepDt = actDepDt;
	}	
	
	/**
	 * Column Info
	 * @param crntRpmPwr
	 */
	public void setCrntRpmPwr(String crntRpmPwr) {
		this.crntRpmPwr = crntRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param trsmOwnrCd
	 */
	public void setTrsmOwnrCd(String trsmOwnrCd) {
		this.trsmOwnrCd = trsmOwnrCd;
	}
	
	/**
	 * Column Info
	 * @param actArrDt
	 */
	public void setActArrDt(String actArrDt) {
		this.actArrDt = actArrDt;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param rpmAdjDt
	 */
	public void setRpmAdjDt(String rpmAdjDt) {
		this.rpmAdjDt = rpmAdjDt;
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
	 * @param trsmMzdNm
	 */
	public void setTrsmMzdNm(String trsmMzdNm) {
		this.trsmMzdNm = trsmMzdNm;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param lstFlg
	 */
	public void setLstFlg(String lstFlg) {
		this.lstFlg = lstFlg;
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
	 * @param toEtaDt
	 */
	public void setToEtaDt(String toEtaDt) {
		this.toEtaDt = toEtaDt;
	}
	
	/**
	 * Column Info
	 * @param trsmMzdCd
	 */
	public void setTrsmMzdCd(String trsmMzdCd) {
		this.trsmMzdCd = trsmMzdCd;
	}
	
	/**
	 * Column Info
	 * @param ntcEtaDt
	 */
	public void setNtcEtaDt(String ntcEtaDt) {
		this.ntcEtaDt = ntcEtaDt;
	}
	
	/**
	 * Column Info
	 * @param difOverArrDt
	 */
	public void setDifOverArrDt(String difOverArrDt) {
		this.difOverArrDt = difOverArrDt;
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
	 * @param ntcEtbDt
	 */
	public void setNtcEtbDt(String ntcEtbDt) {
		this.ntcEtbDt = ntcEtbDt;
	}
	
	/**
	 * Column Info
	 * @param orgRpmPwr
	 */
	public void setOrgRpmPwr(String orgRpmPwr) {
		this.orgRpmPwr = orgRpmPwr;
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
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
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
	 * @param fmEtaDt
	 */
	public void setFmEtaDt(String fmEtaDt) {
		this.fmEtaDt = fmEtaDt;
	}
	
	/**
	 * Column Info
	 * @param vskdPortRhqCd
	 */
	public void setVskdPortRhqCd(String vskdPortRhqCd) {
		this.vskdPortRhqCd = vskdPortRhqCd;
	}
	
	/**
	 * Column Info
	 * @param vopPortCtrlOfcCd
	 */
	public void setVopPortCtrlOfcCd(String vopPortCtrlOfcCd) {
		this.vopPortCtrlOfcCd = vopPortCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param actCrrCd
	 */
	public void setActCrrCd(String actCrrCd) {
		this.actCrrCd = actCrrCd;
	}
	
	/**
	 * Column Info
	 * @param difOverBrthDt
	 */
	public void setdifOverBrthDt(String difOverBrthDt) {
		this.difOverBrthDt = difOverBrthDt;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param trsmHisSeq
	 */
	public void setTrsmHisSeq(String trsmHisSeq) {
		this.trsmHisSeq = trsmHisSeq;
	}
	
	/**
	 * Column Info
	 * @param trsmLoclDt
	 */
	public void setTrsmLoclDt(String trsmLoclDt) {
		this.trsmLoclDt = trsmLoclDt;
	}
	
	/**
	 * Column Info
	 * @param esvcVndrSeq
	 */
	public void setEsvcVndrSeq(String esvcVndrSeq) {
		this.esvcVndrSeq = esvcVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param trsmPurpCd
	 */
	public void setTrsmPurpCd(String trsmPurpCd) {
		this.trsmPurpCd = trsmPurpCd;
	}	
	
	/**
	 * Column Info
	 * @param stwDifHrs
	 */
	public void setStwDifHrs(String stwDifHrs) {
		this.stwDifHrs = stwDifHrs;
	}		

	/**
	 * Column Info
	 * @param pobDt
	 */
	public void setPobDt(String pobDt) {
		this.pobDt = pobDt;
	}		
	
	/**
	 * Column Info
	 * @param drpAnkDt
	 */
	public void setDrpAnkDt(String drpAnkDt) {
		this.drpAnkDt = drpAnkDt;
	}		
	
	/**
	 * Column Info
	 * @param difCstActArrDt
	 */
	public void setDifCstActArrDt(String difCstActArrDt) {
		this.difCstActArrDt = difCstActArrDt;
	}		
	
	/**
	 * Column Info
	 * @param difCstActBrthDt
	 */
	public void setDifCstActBrthDt(String difCstActBrthDt) {
		this.difCstActBrthDt = difCstActBrthDt;
	}		
	
	/**
	 * Column Info
	 * @param difCstNtcArrDt
	 */
	public void setDifCstNtcArrDt(String difCstNtcArrDt) {
		this.difCstNtcArrDt = difCstNtcArrDt;
	}		
	
	/**
	 * Column Info
	 * @param difCstNtcBrthDt
	 */
	public void setDifCstNtcBrthDt(String difCstNtcBrthDt) {
		this.difCstNtcBrthDt = difCstNtcBrthDt;
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
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setActBrthDt(JSPUtil.getParameter(request, prefix + "act_brth_dt", ""));
		setActDepDt(JSPUtil.getParameter(request, prefix + "act_dep_dt", ""));
		setCrntRpmPwr(JSPUtil.getParameter(request, prefix + "crnt_rpm_pwr", ""));
		setTrsmOwnrCd(JSPUtil.getParameter(request, prefix + "trsm_ownr_cd", ""));
		setActArrDt(JSPUtil.getParameter(request, prefix + "act_arr_dt", ""));
		setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setRpmAdjDt(JSPUtil.getParameter(request, prefix + "rpm_adj_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrsmMzdNm(JSPUtil.getParameter(request, prefix + "trsm_mzd_nm", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLstFlg(JSPUtil.getParameter(request, prefix + "lst_flg", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setToEtaDt(JSPUtil.getParameter(request, prefix + "to_eta_dt", ""));
		setTrsmMzdCd(JSPUtil.getParameter(request, prefix + "trsm_mzd_cd", ""));
		setNtcEtaDt(JSPUtil.getParameter(request, prefix + "ntc_eta_dt", ""));
		setDifOverArrDt(JSPUtil.getParameter(request, prefix + "dif_over_arr_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setNtcEtbDt(JSPUtil.getParameter(request, prefix + "ntc_etb_dt", ""));
		setOrgRpmPwr(JSPUtil.getParameter(request, prefix + "org_rpm_pwr", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setFmEtaDt(JSPUtil.getParameter(request, prefix + "fm_eta_dt", ""));
		setVskdPortRhqCd(JSPUtil.getParameter(request, prefix + "vskd_port_rhq_cd", ""));
		setVopPortCtrlOfcCd(JSPUtil.getParameter(request, prefix + "vop_port_ctrl_ofc_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setActCrrCd(JSPUtil.getParameter(request, prefix + "act_crr_cd", ""));
		setdifOverBrthDt(JSPUtil.getParameter(request, prefix + "dif_over_brth_dt", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setTrsmHisSeq(JSPUtil.getParameter(request, prefix + "trsm_his_seq", ""));
		setTrsmLoclDt(JSPUtil.getParameter(request, prefix + "trsm_locl_dt", ""));
		setEsvcVndrSeq(JSPUtil.getParameter(request, prefix + "esvc_vndr_seq", ""));
		setTrsmPurpCd(JSPUtil.getParameter(request, prefix + "trsm_purp_cd", ""));
		setStwDifHrs(JSPUtil.getParameter(request, prefix + "stw_dif_hrs", ""));	
		
		setPobDt(JSPUtil.getParameter(request, prefix + "pob_dt", ""));	
		setDrpAnkDt(JSPUtil.getParameter(request, prefix + "drp_ank_dt", ""));	
		setDifCstActArrDt(JSPUtil.getParameter(request, prefix + "dif_cst_act_arr_dt", ""));	
		setDifCstActBrthDt(JSPUtil.getParameter(request, prefix + "stw_dif_hrs", ""));	
		setDifCstNtcArrDt(JSPUtil.getParameter(request, prefix + "dif_cst_ntc_arr_dt", ""));	
		setDifCstNtcBrthDt(JSPUtil.getParameter(request, prefix + "dif_cst_ntc_brth_dt", ""));	
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EtaSendMoniVO[]
	 */
	public EtaSendMoniVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EtaSendMoniVO[]
	 */
	public EtaSendMoniVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EtaSendMoniVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] actBrthDt = (JSPUtil.getParameter(request, prefix	+ "act_brth_dt", length));
			String[] actDepDt = (JSPUtil.getParameter(request, prefix	+ "act_dep_dt", length));
			String[] crntRpmPwr = (JSPUtil.getParameter(request, prefix	+ "crnt_rpm_pwr", length));
			String[] trsmOwnrCd = (JSPUtil.getParameter(request, prefix	+ "trsm_ownr_cd", length));
			String[] actArrDt = (JSPUtil.getParameter(request, prefix	+ "act_arr_dt", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] rpmAdjDt = (JSPUtil.getParameter(request, prefix	+ "rpm_adj_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trsmMzdNm = (JSPUtil.getParameter(request, prefix	+ "trsm_mzd_nm", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lstFlg = (JSPUtil.getParameter(request, prefix	+ "lst_flg", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] toEtaDt = (JSPUtil.getParameter(request, prefix	+ "to_eta_dt", length));
			String[] trsmMzdCd = (JSPUtil.getParameter(request, prefix	+ "trsm_mzd_cd", length));
			String[] ntcEtaDt = (JSPUtil.getParameter(request, prefix	+ "ntc_eta_dt", length));
			String[] difOverArrDt = (JSPUtil.getParameter(request, prefix	+ "dif_over_arr_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ntcEtbDt = (JSPUtil.getParameter(request, prefix	+ "ntc_etb_dt", length));
			String[] orgRpmPwr = (JSPUtil.getParameter(request, prefix	+ "org_rpm_pwr", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] fmEtaDt = (JSPUtil.getParameter(request, prefix	+ "fm_eta_dt", length));
			String[] vskdPortRhqCd = (JSPUtil.getParameter(request, prefix	+ "vskd_port_rhq_cd", length));
			String[] vopPortCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "vop_port_ctrl_ofc_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] actCrrCd = (JSPUtil.getParameter(request, prefix	+ "act_crr_cd", length));
			String[] difOverBrthDt = (JSPUtil.getParameter(request, prefix	+ "dif_over_brth_dt", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] trsmHisSeq = (JSPUtil.getParameter(request, prefix	+ "trsm_his_seq", length));
			String[] trsmLoclDt = (JSPUtil.getParameter(request, prefix	+ "trsm_locl_dt", length));
			String[] esvcVndrSeq = (JSPUtil.getParameter(request, prefix	+ "esvc_vndr_seq", length));
			String[] trsmPurpCd = (JSPUtil.getParameter(request, prefix	+ "trsm_purp_cd", length));
			String[] stwDifHrs = (JSPUtil.getParameter(request, prefix	+ "stw_dif_hrs", length));
			
			String[] pobDt 			= (JSPUtil.getParameter(request, prefix	+ "pob_dt", length));
			String[] drpAnkDt 		= (JSPUtil.getParameter(request, prefix	+ "drp_ank_dt", length));
			String[] difCstActArrDt = (JSPUtil.getParameter(request, prefix	+ "dif_cst_act_arr_dt", length));
			String[] difCstActBrthDt= (JSPUtil.getParameter(request, prefix	+ "dif_cst_act_brth_dt", length));
			String[] difCstNtcArrDt = (JSPUtil.getParameter(request, prefix	+ "dif_cst_ntc_arr_dt", length));
			String[] difCstNtcBrthDt= (JSPUtil.getParameter(request, prefix	+ "dif_cst_ntc_brth_dt", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new EtaSendMoniVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (actBrthDt[i] != null)
					model.setActBrthDt(actBrthDt[i]);
				if (actDepDt[i] != null)
					model.setActDepDt(actDepDt[i]);				
				if (crntRpmPwr[i] != null)
					model.setCrntRpmPwr(crntRpmPwr[i]);
				if (trsmOwnrCd[i] != null)
					model.setTrsmOwnrCd(trsmOwnrCd[i]);
				if (actArrDt[i] != null)
					model.setActArrDt(actArrDt[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (rpmAdjDt[i] != null)
					model.setRpmAdjDt(rpmAdjDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trsmMzdNm[i] != null)
					model.setTrsmMzdNm(trsmMzdNm[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lstFlg[i] != null)
					model.setLstFlg(lstFlg[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (toEtaDt[i] != null)
					model.setToEtaDt(toEtaDt[i]);
				if (trsmMzdCd[i] != null)
					model.setTrsmMzdCd(trsmMzdCd[i]);
				if (ntcEtaDt[i] != null)
					model.setNtcEtaDt(ntcEtaDt[i]);
				if (difOverArrDt[i] != null)
					model.setDifOverArrDt(difOverArrDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ntcEtbDt[i] != null)
					model.setNtcEtbDt(ntcEtbDt[i]);
				if (orgRpmPwr[i] != null)
					model.setOrgRpmPwr(orgRpmPwr[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (fmEtaDt[i] != null)
					model.setFmEtaDt(fmEtaDt[i]);
				if (vskdPortRhqCd[i] != null)
					model.setVskdPortRhqCd(vskdPortRhqCd[i]);
				if (vopPortCtrlOfcCd[i] != null)
					model.setVopPortCtrlOfcCd(vopPortCtrlOfcCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (actCrrCd[i] != null)
					model.setActCrrCd(actCrrCd[i]);
				if (difOverBrthDt[i] != null)
					model.setdifOverBrthDt(difOverBrthDt[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (trsmHisSeq[i] != null)
					model.setTrsmHisSeq(trsmHisSeq[i]);
				if (trsmLoclDt[i] != null)
					model.setTrsmLoclDt(trsmLoclDt[i]);
				if (esvcVndrSeq[i] != null)
					model.setEsvcVndrSeq(esvcVndrSeq[i]);
				if (trsmPurpCd[i] != null)
					model.setTrsmPurpCd(trsmPurpCd[i]);	
				if (stwDifHrs[i] != null)
					model.setStwDifHrs(stwDifHrs[i]);	
				
				if (pobDt[i] != null)
					model.setPobDt(pobDt[i]);	
				if (drpAnkDt[i] != null)
					model.setDrpAnkDt(drpAnkDt[i]);	
				if (difCstActArrDt[i] != null)
					model.setDifCstActArrDt(difCstActArrDt[i]);	
				if (difCstActBrthDt[i] != null)
					model.setDifCstActBrthDt(difCstActBrthDt[i]);	
				if (difCstNtcArrDt[i] != null)
					model.setDifCstNtcArrDt(difCstNtcArrDt[i]);	
				if (difCstNtcBrthDt[i] != null)
					model.setDifCstNtcBrthDt(difCstNtcBrthDt[i]);	

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEtaSendMoniVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EtaSendMoniVO[]
	 */
	public EtaSendMoniVO[] getEtaSendMoniVOs(){
		EtaSendMoniVO[] vos = (EtaSendMoniVO[])models.toArray(new EtaSendMoniVO[models.size()]);
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
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBrthDt = this.actBrthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDepDt = this.actDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.crntRpmPwr = this.crntRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmOwnrCd = this.trsmOwnrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actArrDt = this.actArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rpmAdjDt = this.rpmAdjDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmMzdNm = this.trsmMzdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstFlg = this.lstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtaDt = this.toEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmMzdCd = this.trsmMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEtaDt = this.ntcEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.difOverArrDt = this.difOverArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEtbDt = this.ntcEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRpmPwr = this.orgRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEtaDt = this.fmEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskdPortRhqCd = this.vskdPortRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopPortCtrlOfcCd = this.vopPortCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCrrCd = this.actCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.difOverBrthDt = this.difOverBrthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmHisSeq = this.trsmHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmLoclDt = this.trsmLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esvcVndrSeq = this.esvcVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmPurpCd = this.trsmPurpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwDifHrs = this.stwDifHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
