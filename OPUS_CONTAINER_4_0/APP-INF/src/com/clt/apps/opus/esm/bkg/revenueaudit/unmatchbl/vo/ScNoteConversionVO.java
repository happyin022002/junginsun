/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ScNoteConversionVO.java
*@FileTitle : ScNoteConversionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScNoteConversionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScNoteConversionVO> models = new ArrayList<ScNoteConversionVO>();
	
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String bkgMstHblTpCd = null;
	/* Column Info */
	private String payTermCd = null;
	/* Column Info */
	private String noteConvSeq = null;
	/* Column Info */
	private String convRatUtCd = null;
	/* Column Info */
	private String rtApplTpCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String noteClssCd = null;
	/* Column Info */
	private String bkgSocFlg = null;
	/* Column Info */
	private String bkgTsPortDefCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String bkgCmdtDefCd = null;
	/* Column Info */
	private String genSpclRtTpCd = null;
	/* Column Info */
	private String bkgOrgTrspModCd = null;
	/* Column Info */
	private String bkgIoGaCd = null;
	/* Column Info */
	private String rtOpCd = null;
	/* Column Info */
	private String chgRuleDefCd = null;
	/* Column Info */
	private String convCmdtDefCd = null;
	/* Column Info */
	private String rtPattTpCd = null;
	/* Column Info */
	private String bkgPolDefCd = null;
	/* Column Info */
	private String convPrcCgoTpCd = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String convPrcDeTermCd = null;
	/* Column Info */
	private String bkgRatUtCd = null;
	/* Column Info */
	private String bkgCnlTzCd = null;
	/* Column Info */
	private String convDestLocDefCd = null;
	/* Column Info */
	private String bkgDelDefCd = null;
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String bkgUsaSvcModCd = null;
	/* Column Info */
	private String bkgImdgClssCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String convOrgViaLocDefCd = null;
	/* Column Info */
	private String bkgPrcCgoTpCd = null;
	/* Column Info */
	private String convPrcRcvTermCd = null;
	/* Column Info */
	private String bkgDestTrspModCd = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String bkgDirCallFlg = null;
	/* Column Info */
	private String noteCtnt = null;
	/* Column Info */
	private String bkgActCustDefCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scCnt = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String convOrgLocDefCd = null;
	/* Column Info */
	private String ignTrfFlg = null;
	/* Column Info */
	private String bkgSlanCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String noteConvTpCd = null;
	/* Column Info */
	private String ruleApplChgTpCd = null;
	/* Column Info */
	private String ruleApplChgCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String noteConvRuleCd = null;
	/* Column Info */
	private String bkgPodDefCd = null;
	/* Column Info */
	private String bkgScgGrpCmdtCd = null;
	/* Column Info */
	private String bkgPorDefCd = null;
	/* Column Info */
	private String bkgEsvcTpCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String frtRtAmt = null;
	/* Column Info */
	private String convDestViaLocDefCd = null;
	/* Column Info */
	private String bkgVvdCd = null;
	/* Column Info */
	private String bkgDeTermCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ScNoteConversionVO() {}

	public ScNoteConversionVO(String ibflag, String pagerows, String amdtSeq, String svcScpCd, String bkgMstHblTpCd, String payTermCd, String noteConvSeq, String convRatUtCd, String rtApplTpCd, String chgCd, String effDt, String noteClssCd, String bkgSocFlg, String bkgTsPortDefCd, String scNo, String genSpclRtTpCd, String bkgCmdtDefCd, String bkgOrgTrspModCd, String bkgIoGaCd, String rtOpCd, String convCmdtDefCd, String chgRuleDefCd, String rtPattTpCd, String bkgPolDefCd, String convPrcCgoTpCd, String ctrtPtyNm, String convPrcDeTermCd, String bkgRatUtCd, String bkgCnlTzCd, String convDestLocDefCd, String bkgDelDefCd, String dpSeq, String bkgUsaSvcModCd, String bkgImdgClssCd, String currCd, String convOrgViaLocDefCd, String bkgPrcCgoTpCd, String convPrcRcvTermCd, String bkgDestTrspModCd, String bkgRcvTermCd, String bkgDirCallFlg, String noteCtnt, String bkgActCustDefCd, String scCnt, String usrNm, String convOrgLocDefCd, String ignTrfFlg, String bkgSlanCd, String expDt, String noteConvTpCd, String ruleApplChgTpCd, String ruleApplChgCd, String updDt, String noteConvRuleCd, String bkgPodDefCd, String bkgScgGrpCmdtCd, String bkgPorDefCd, String bkgEsvcTpCd, String propNo, String frtRtAmt, String convDestViaLocDefCd, String bkgVvdCd, String bkgDeTermCd) {
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.bkgMstHblTpCd = bkgMstHblTpCd;
		this.payTermCd = payTermCd;
		this.noteConvSeq = noteConvSeq;
		this.convRatUtCd = convRatUtCd;
		this.rtApplTpCd = rtApplTpCd;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.noteClssCd = noteClssCd;
		this.bkgSocFlg = bkgSocFlg;
		this.bkgTsPortDefCd = bkgTsPortDefCd;
		this.scNo = scNo;
		this.bkgCmdtDefCd = bkgCmdtDefCd;
		this.genSpclRtTpCd = genSpclRtTpCd;
		this.bkgOrgTrspModCd = bkgOrgTrspModCd;
		this.bkgIoGaCd = bkgIoGaCd;
		this.rtOpCd = rtOpCd;
		this.chgRuleDefCd = chgRuleDefCd;
		this.convCmdtDefCd = convCmdtDefCd;
		this.rtPattTpCd = rtPattTpCd;
		this.bkgPolDefCd = bkgPolDefCd;
		this.convPrcCgoTpCd = convPrcCgoTpCd;
		this.ctrtPtyNm = ctrtPtyNm;
		this.convPrcDeTermCd = convPrcDeTermCd;
		this.bkgRatUtCd = bkgRatUtCd;
		this.bkgCnlTzCd = bkgCnlTzCd;
		this.convDestLocDefCd = convDestLocDefCd;
		this.bkgDelDefCd = bkgDelDefCd;
		this.dpSeq = dpSeq;
		this.bkgUsaSvcModCd = bkgUsaSvcModCd;
		this.bkgImdgClssCd = bkgImdgClssCd;
		this.currCd = currCd;
		this.convOrgViaLocDefCd = convOrgViaLocDefCd;
		this.bkgPrcCgoTpCd = bkgPrcCgoTpCd;
		this.convPrcRcvTermCd = convPrcRcvTermCd;
		this.bkgDestTrspModCd = bkgDestTrspModCd;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.bkgDirCallFlg = bkgDirCallFlg;
		this.noteCtnt = noteCtnt;
		this.bkgActCustDefCd = bkgActCustDefCd;
		this.ibflag = ibflag;
		this.scCnt = scCnt;
		this.usrNm = usrNm;
		this.convOrgLocDefCd = convOrgLocDefCd;
		this.ignTrfFlg = ignTrfFlg;
		this.bkgSlanCd = bkgSlanCd;
		this.expDt = expDt;
		this.noteConvTpCd = noteConvTpCd;
		this.ruleApplChgTpCd = ruleApplChgTpCd;
		this.ruleApplChgCd = ruleApplChgCd;
		this.updDt = updDt;
		this.noteConvRuleCd = noteConvRuleCd;
		this.bkgPodDefCd = bkgPodDefCd;
		this.bkgScgGrpCmdtCd = bkgScgGrpCmdtCd;
		this.bkgPorDefCd = bkgPorDefCd;
		this.bkgEsvcTpCd = bkgEsvcTpCd;
		this.propNo = propNo;
		this.frtRtAmt = frtRtAmt;
		this.convDestViaLocDefCd = convDestViaLocDefCd;
		this.bkgVvdCd = bkgVvdCd;
		this.bkgDeTermCd = bkgDeTermCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("bkg_mst_hbl_tp_cd", getBkgMstHblTpCd());
		this.hashColumns.put("pay_term_cd", getPayTermCd());
		this.hashColumns.put("note_conv_seq", getNoteConvSeq());
		this.hashColumns.put("conv_rat_ut_cd", getConvRatUtCd());
		this.hashColumns.put("rt_appl_tp_cd", getRtApplTpCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("note_clss_cd", getNoteClssCd());
		this.hashColumns.put("bkg_soc_flg", getBkgSocFlg());
		this.hashColumns.put("bkg_ts_port_def_cd", getBkgTsPortDefCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("bkg_cmdt_def_cd", getBkgCmdtDefCd());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		this.hashColumns.put("bkg_org_trsp_mod_cd", getBkgOrgTrspModCd());
		this.hashColumns.put("bkg_io_ga_cd", getBkgIoGaCd());
		this.hashColumns.put("rt_op_cd", getRtOpCd());
		this.hashColumns.put("chg_rule_def_cd", getChgRuleDefCd());
		this.hashColumns.put("conv_cmdt_def_cd", getConvCmdtDefCd());
		this.hashColumns.put("rt_patt_tp_cd", getRtPattTpCd());
		this.hashColumns.put("bkg_pol_def_cd", getBkgPolDefCd());
		this.hashColumns.put("conv_prc_cgo_tp_cd", getConvPrcCgoTpCd());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("conv_prc_de_term_cd", getConvPrcDeTermCd());
		this.hashColumns.put("bkg_rat_ut_cd", getBkgRatUtCd());
		this.hashColumns.put("bkg_cnl_tz_cd", getBkgCnlTzCd());
		this.hashColumns.put("conv_dest_loc_def_cd", getConvDestLocDefCd());
		this.hashColumns.put("bkg_del_def_cd", getBkgDelDefCd());
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("bkg_usa_svc_mod_cd", getBkgUsaSvcModCd());
		this.hashColumns.put("bkg_imdg_clss_cd", getBkgImdgClssCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("conv_org_via_loc_def_cd", getConvOrgViaLocDefCd());
		this.hashColumns.put("bkg_prc_cgo_tp_cd", getBkgPrcCgoTpCd());
		this.hashColumns.put("conv_prc_rcv_term_cd", getConvPrcRcvTermCd());
		this.hashColumns.put("bkg_dest_trsp_mod_cd", getBkgDestTrspModCd());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("bkg_dir_call_flg", getBkgDirCallFlg());
		this.hashColumns.put("note_ctnt", getNoteCtnt());
		this.hashColumns.put("bkg_act_cust_def_cd", getBkgActCustDefCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sc_cnt", getScCnt());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("conv_org_loc_def_cd", getConvOrgLocDefCd());
		this.hashColumns.put("ign_trf_flg", getIgnTrfFlg());
		this.hashColumns.put("bkg_slan_cd", getBkgSlanCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("note_conv_tp_cd", getNoteConvTpCd());
		this.hashColumns.put("rule_appl_chg_tp_cd", getRuleApplChgTpCd());
		this.hashColumns.put("rule_appl_chg_cd", getRuleApplChgCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("note_conv_rule_cd", getNoteConvRuleCd());
		this.hashColumns.put("bkg_pod_def_cd", getBkgPodDefCd());
		this.hashColumns.put("bkg_scg_grp_cmdt_cd", getBkgScgGrpCmdtCd());
		this.hashColumns.put("bkg_por_def_cd", getBkgPorDefCd());
		this.hashColumns.put("bkg_esvc_tp_cd", getBkgEsvcTpCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("frt_rt_amt", getFrtRtAmt());
		this.hashColumns.put("conv_dest_via_loc_def_cd", getConvDestViaLocDefCd());
		this.hashColumns.put("bkg_vvd_cd", getBkgVvdCd());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("bkg_mst_hbl_tp_cd", "bkgMstHblTpCd");
		this.hashFields.put("pay_term_cd", "payTermCd");
		this.hashFields.put("note_conv_seq", "noteConvSeq");
		this.hashFields.put("conv_rat_ut_cd", "convRatUtCd");
		this.hashFields.put("rt_appl_tp_cd", "rtApplTpCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("note_clss_cd", "noteClssCd");
		this.hashFields.put("bkg_soc_flg", "bkgSocFlg");
		this.hashFields.put("bkg_ts_port_def_cd", "bkgTsPortDefCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("bkg_cmdt_def_cd", "bkgCmdtDefCd");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		this.hashFields.put("bkg_org_trsp_mod_cd", "bkgOrgTrspModCd");
		this.hashFields.put("bkg_io_ga_cd", "bkgIoGaCd");
		this.hashFields.put("rt_op_cd", "rtOpCd");
		this.hashFields.put("chg_rule_def_cd", "chgRuleDefCd");
		this.hashFields.put("conv_cmdt_def_cd", "convCmdtDefCd");
		this.hashFields.put("rt_patt_tp_cd", "rtPattTpCd");
		this.hashFields.put("bkg_pol_def_cd", "bkgPolDefCd");
		this.hashFields.put("conv_prc_cgo_tp_cd", "convPrcCgoTpCd");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("conv_prc_de_term_cd", "convPrcDeTermCd");
		this.hashFields.put("bkg_rat_ut_cd", "bkgRatUtCd");
		this.hashFields.put("bkg_cnl_tz_cd", "bkgCnlTzCd");
		this.hashFields.put("conv_dest_loc_def_cd", "convDestLocDefCd");
		this.hashFields.put("bkg_del_def_cd", "bkgDelDefCd");
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("bkg_usa_svc_mod_cd", "bkgUsaSvcModCd");
		this.hashFields.put("bkg_imdg_clss_cd", "bkgImdgClssCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("conv_org_via_loc_def_cd", "convOrgViaLocDefCd");
		this.hashFields.put("bkg_prc_cgo_tp_cd", "bkgPrcCgoTpCd");
		this.hashFields.put("conv_prc_rcv_term_cd", "convPrcRcvTermCd");
		this.hashFields.put("bkg_dest_trsp_mod_cd", "bkgDestTrspModCd");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("bkg_dir_call_flg", "bkgDirCallFlg");
		this.hashFields.put("note_ctnt", "noteCtnt");
		this.hashFields.put("bkg_act_cust_def_cd", "bkgActCustDefCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_cnt", "scCnt");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("conv_org_loc_def_cd", "convOrgLocDefCd");
		this.hashFields.put("ign_trf_flg", "ignTrfFlg");
		this.hashFields.put("bkg_slan_cd", "bkgSlanCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("note_conv_tp_cd", "noteConvTpCd");
		this.hashFields.put("rule_appl_chg_tp_cd", "ruleApplChgTpCd");
		this.hashFields.put("rule_appl_chg_cd", "ruleApplChgCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("note_conv_rule_cd", "noteConvRuleCd");
		this.hashFields.put("bkg_pod_def_cd", "bkgPodDefCd");
		this.hashFields.put("bkg_scg_grp_cmdt_cd", "bkgScgGrpCmdtCd");
		this.hashFields.put("bkg_por_def_cd", "bkgPorDefCd");
		this.hashFields.put("bkg_esvc_tp_cd", "bkgEsvcTpCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("frt_rt_amt", "frtRtAmt");
		this.hashFields.put("conv_dest_via_loc_def_cd", "convDestViaLocDefCd");
		this.hashFields.put("bkg_vvd_cd", "bkgVvdCd");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgMstHblTpCd
	 */
	public String getBkgMstHblTpCd() {
		return this.bkgMstHblTpCd;
	}
	
	/**
	 * Column Info
	 * @return payTermCd
	 */
	public String getPayTermCd() {
		return this.payTermCd;
	}
	
	/**
	 * Column Info
	 * @return noteConvSeq
	 */
	public String getNoteConvSeq() {
		return this.noteConvSeq;
	}
	
	/**
	 * Column Info
	 * @return convRatUtCd
	 */
	public String getConvRatUtCd() {
		return this.convRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return rtApplTpCd
	 */
	public String getRtApplTpCd() {
		return this.rtApplTpCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return noteClssCd
	 */
	public String getNoteClssCd() {
		return this.noteClssCd;
	}
	
	/**
	 * Column Info
	 * @return bkgSocFlg
	 */
	public String getBkgSocFlg() {
		return this.bkgSocFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgTsPortDefCd
	 */
	public String getBkgTsPortDefCd() {
		return this.bkgTsPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return bkgCmdtDefCd
	 */
	public String getBkgCmdtDefCd() {
		return this.bkgCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @return genSpclRtTpCd
	 */
	public String getGenSpclRtTpCd() {
		return this.genSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOrgTrspModCd
	 */
	public String getBkgOrgTrspModCd() {
		return this.bkgOrgTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return bkgIoGaCd
	 */
	public String getBkgIoGaCd() {
		return this.bkgIoGaCd;
	}
	
	/**
	 * Column Info
	 * @return rtOpCd
	 */
	public String getRtOpCd() {
		return this.rtOpCd;
	}
	
	/**
	 * Column Info
	 * @return chgRuleDefCd
	 */
	public String getChgRuleDefCd() {
		return this.chgRuleDefCd;
	}
	
	/**
	 * Column Info
	 * @return convCmdtDefCd
	 */
	public String getConvCmdtDefCd() {
		return this.convCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @return rtPattTpCd
	 */
	public String getRtPattTpCd() {
		return this.rtPattTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPolDefCd
	 */
	public String getBkgPolDefCd() {
		return this.bkgPolDefCd;
	}
	
	/**
	 * Column Info
	 * @return convPrcCgoTpCd
	 */
	public String getConvPrcCgoTpCd() {
		return this.convPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtPtyNm
	 */
	public String getCtrtPtyNm() {
		return this.ctrtPtyNm;
	}
	
	/**
	 * Column Info
	 * @return convPrcDeTermCd
	 */
	public String getConvPrcDeTermCd() {
		return this.convPrcDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRatUtCd
	 */
	public String getBkgRatUtCd() {
		return this.bkgRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCnlTzCd
	 */
	public String getBkgCnlTzCd() {
		return this.bkgCnlTzCd;
	}
	
	/**
	 * Column Info
	 * @return convDestLocDefCd
	 */
	public String getConvDestLocDefCd() {
		return this.convDestLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDelDefCd
	 */
	public String getBkgDelDefCd() {
		return this.bkgDelDefCd;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgUsaSvcModCd
	 */
	public String getBkgUsaSvcModCd() {
		return this.bkgUsaSvcModCd;
	}
	
	/**
	 * Column Info
	 * @return bkgImdgClssCd
	 */
	public String getBkgImdgClssCd() {
		return this.bkgImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return convOrgViaLocDefCd
	 */
	public String getConvOrgViaLocDefCd() {
		return this.convOrgViaLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPrcCgoTpCd
	 */
	public String getBkgPrcCgoTpCd() {
		return this.bkgPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return convPrcRcvTermCd
	 */
	public String getConvPrcRcvTermCd() {
		return this.convPrcRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDestTrspModCd
	 */
	public String getBkgDestTrspModCd() {
		return this.bkgDestTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRcvTermCd
	 */
	public String getBkgRcvTermCd() {
		return this.bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDirCallFlg
	 */
	public String getBkgDirCallFlg() {
		return this.bkgDirCallFlg;
	}
	
	/**
	 * Column Info
	 * @return noteCtnt
	 */
	public String getNoteCtnt() {
		return this.noteCtnt;
	}
	
	/**
	 * Column Info
	 * @return bkgActCustDefCd
	 */
	public String getBkgActCustDefCd() {
		return this.bkgActCustDefCd;
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
	 * @return scCnt
	 */
	public String getScCnt() {
		return this.scCnt;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return convOrgLocDefCd
	 */
	public String getConvOrgLocDefCd() {
		return this.convOrgLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return ignTrfFlg
	 */
	public String getIgnTrfFlg() {
		return this.ignTrfFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgSlanCd
	 */
	public String getBkgSlanCd() {
		return this.bkgSlanCd;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return noteConvTpCd
	 */
	public String getNoteConvTpCd() {
		return this.noteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return ruleApplChgTpCd
	 */
	public String getRuleApplChgTpCd() {
		return this.ruleApplChgTpCd;
	}
	
	/**
	 * Column Info
	 * @return ruleApplChgCd
	 */
	public String getRuleApplChgCd() {
		return this.ruleApplChgCd;
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
	 * @return noteConvRuleCd
	 */
	public String getNoteConvRuleCd() {
		return this.noteConvRuleCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPodDefCd
	 */
	public String getBkgPodDefCd() {
		return this.bkgPodDefCd;
	}
	
	/**
	 * Column Info
	 * @return bkgScgGrpCmdtCd
	 */
	public String getBkgScgGrpCmdtCd() {
		return this.bkgScgGrpCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPorDefCd
	 */
	public String getBkgPorDefCd() {
		return this.bkgPorDefCd;
	}
	
	/**
	 * Column Info
	 * @return bkgEsvcTpCd
	 */
	public String getBkgEsvcTpCd() {
		return this.bkgEsvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return frtRtAmt
	 */
	public String getFrtRtAmt() {
		return this.frtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return convDestViaLocDefCd
	 */
	public String getConvDestViaLocDefCd() {
		return this.convDestViaLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return bkgVvdCd
	 */
	public String getBkgVvdCd() {
		return this.bkgVvdCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDeTermCd
	 */
	public String getBkgDeTermCd() {
		return this.bkgDeTermCd;
	}
	

	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgMstHblTpCd
	 */
	public void setBkgMstHblTpCd(String bkgMstHblTpCd) {
		this.bkgMstHblTpCd = bkgMstHblTpCd;
	}
	
	/**
	 * Column Info
	 * @param payTermCd
	 */
	public void setPayTermCd(String payTermCd) {
		this.payTermCd = payTermCd;
	}
	
	/**
	 * Column Info
	 * @param noteConvSeq
	 */
	public void setNoteConvSeq(String noteConvSeq) {
		this.noteConvSeq = noteConvSeq;
	}
	
	/**
	 * Column Info
	 * @param convRatUtCd
	 */
	public void setConvRatUtCd(String convRatUtCd) {
		this.convRatUtCd = convRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param rtApplTpCd
	 */
	public void setRtApplTpCd(String rtApplTpCd) {
		this.rtApplTpCd = rtApplTpCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param noteClssCd
	 */
	public void setNoteClssCd(String noteClssCd) {
		this.noteClssCd = noteClssCd;
	}
	
	/**
	 * Column Info
	 * @param bkgSocFlg
	 */
	public void setBkgSocFlg(String bkgSocFlg) {
		this.bkgSocFlg = bkgSocFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgTsPortDefCd
	 */
	public void setBkgTsPortDefCd(String bkgTsPortDefCd) {
		this.bkgTsPortDefCd = bkgTsPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param bkgCmdtDefCd
	 */
	public void setBkgCmdtDefCd(String bkgCmdtDefCd) {
		this.bkgCmdtDefCd = bkgCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @param genSpclRtTpCd
	 */
	public void setGenSpclRtTpCd(String genSpclRtTpCd) {
		this.genSpclRtTpCd = genSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOrgTrspModCd
	 */
	public void setBkgOrgTrspModCd(String bkgOrgTrspModCd) {
		this.bkgOrgTrspModCd = bkgOrgTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param bkgIoGaCd
	 */
	public void setBkgIoGaCd(String bkgIoGaCd) {
		this.bkgIoGaCd = bkgIoGaCd;
	}
	
	/**
	 * Column Info
	 * @param rtOpCd
	 */
	public void setRtOpCd(String rtOpCd) {
		this.rtOpCd = rtOpCd;
	}
	
	/**
	 * Column Info
	 * @param chgRuleDefCd
	 */
	public void setChgRuleDefCd(String chgRuleDefCd) {
		this.chgRuleDefCd = chgRuleDefCd;
	}
	
	/**
	 * Column Info
	 * @param convCmdtDefCd
	 */
	public void setConvCmdtDefCd(String convCmdtDefCd) {
		this.convCmdtDefCd = convCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @param rtPattTpCd
	 */
	public void setRtPattTpCd(String rtPattTpCd) {
		this.rtPattTpCd = rtPattTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPolDefCd
	 */
	public void setBkgPolDefCd(String bkgPolDefCd) {
		this.bkgPolDefCd = bkgPolDefCd;
	}
	
	/**
	 * Column Info
	 * @param convPrcCgoTpCd
	 */
	public void setConvPrcCgoTpCd(String convPrcCgoTpCd) {
		this.convPrcCgoTpCd = convPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtPtyNm
	 */
	public void setCtrtPtyNm(String ctrtPtyNm) {
		this.ctrtPtyNm = ctrtPtyNm;
	}
	
	/**
	 * Column Info
	 * @param convPrcDeTermCd
	 */
	public void setConvPrcDeTermCd(String convPrcDeTermCd) {
		this.convPrcDeTermCd = convPrcDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRatUtCd
	 */
	public void setBkgRatUtCd(String bkgRatUtCd) {
		this.bkgRatUtCd = bkgRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCnlTzCd
	 */
	public void setBkgCnlTzCd(String bkgCnlTzCd) {
		this.bkgCnlTzCd = bkgCnlTzCd;
	}
	
	/**
	 * Column Info
	 * @param convDestLocDefCd
	 */
	public void setConvDestLocDefCd(String convDestLocDefCd) {
		this.convDestLocDefCd = convDestLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDelDefCd
	 */
	public void setBkgDelDefCd(String bkgDelDefCd) {
		this.bkgDelDefCd = bkgDelDefCd;
	}
	
	/**
	 * Column Info
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgUsaSvcModCd
	 */
	public void setBkgUsaSvcModCd(String bkgUsaSvcModCd) {
		this.bkgUsaSvcModCd = bkgUsaSvcModCd;
	}
	
	/**
	 * Column Info
	 * @param bkgImdgClssCd
	 */
	public void setBkgImdgClssCd(String bkgImdgClssCd) {
		this.bkgImdgClssCd = bkgImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param convOrgViaLocDefCd
	 */
	public void setConvOrgViaLocDefCd(String convOrgViaLocDefCd) {
		this.convOrgViaLocDefCd = convOrgViaLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPrcCgoTpCd
	 */
	public void setBkgPrcCgoTpCd(String bkgPrcCgoTpCd) {
		this.bkgPrcCgoTpCd = bkgPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param convPrcRcvTermCd
	 */
	public void setConvPrcRcvTermCd(String convPrcRcvTermCd) {
		this.convPrcRcvTermCd = convPrcRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDestTrspModCd
	 */
	public void setBkgDestTrspModCd(String bkgDestTrspModCd) {
		this.bkgDestTrspModCd = bkgDestTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRcvTermCd
	 */
	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDirCallFlg
	 */
	public void setBkgDirCallFlg(String bkgDirCallFlg) {
		this.bkgDirCallFlg = bkgDirCallFlg;
	}
	
	/**
	 * Column Info
	 * @param noteCtnt
	 */
	public void setNoteCtnt(String noteCtnt) {
		this.noteCtnt = noteCtnt;
	}
	
	/**
	 * Column Info
	 * @param bkgActCustDefCd
	 */
	public void setBkgActCustDefCd(String bkgActCustDefCd) {
		this.bkgActCustDefCd = bkgActCustDefCd;
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
	 * @param scCnt
	 */
	public void setScCnt(String scCnt) {
		this.scCnt = scCnt;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param convOrgLocDefCd
	 */
	public void setConvOrgLocDefCd(String convOrgLocDefCd) {
		this.convOrgLocDefCd = convOrgLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param ignTrfFlg
	 */
	public void setIgnTrfFlg(String ignTrfFlg) {
		this.ignTrfFlg = ignTrfFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgSlanCd
	 */
	public void setBkgSlanCd(String bkgSlanCd) {
		this.bkgSlanCd = bkgSlanCd;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param noteConvTpCd
	 */
	public void setNoteConvTpCd(String noteConvTpCd) {
		this.noteConvTpCd = noteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param ruleApplChgTpCd
	 */
	public void setRuleApplChgTpCd(String ruleApplChgTpCd) {
		this.ruleApplChgTpCd = ruleApplChgTpCd;
	}
	
	/**
	 * Column Info
	 * @param ruleApplChgCd
	 */
	public void setRuleApplChgCd(String ruleApplChgCd) {
		this.ruleApplChgCd = ruleApplChgCd;
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
	 * @param noteConvRuleCd
	 */
	public void setNoteConvRuleCd(String noteConvRuleCd) {
		this.noteConvRuleCd = noteConvRuleCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPodDefCd
	 */
	public void setBkgPodDefCd(String bkgPodDefCd) {
		this.bkgPodDefCd = bkgPodDefCd;
	}
	
	/**
	 * Column Info
	 * @param bkgScgGrpCmdtCd
	 */
	public void setBkgScgGrpCmdtCd(String bkgScgGrpCmdtCd) {
		this.bkgScgGrpCmdtCd = bkgScgGrpCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPorDefCd
	 */
	public void setBkgPorDefCd(String bkgPorDefCd) {
		this.bkgPorDefCd = bkgPorDefCd;
	}
	
	/**
	 * Column Info
	 * @param bkgEsvcTpCd
	 */
	public void setBkgEsvcTpCd(String bkgEsvcTpCd) {
		this.bkgEsvcTpCd = bkgEsvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param frtRtAmt
	 */
	public void setFrtRtAmt(String frtRtAmt) {
		this.frtRtAmt = frtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param convDestViaLocDefCd
	 */
	public void setConvDestViaLocDefCd(String convDestViaLocDefCd) {
		this.convDestViaLocDefCd = convDestViaLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param bkgVvdCd
	 */
	public void setBkgVvdCd(String bkgVvdCd) {
		this.bkgVvdCd = bkgVvdCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDeTermCd
	 */
	public void setBkgDeTermCd(String bkgDeTermCd) {
		this.bkgDeTermCd = bkgDeTermCd;
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
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setBkgMstHblTpCd(JSPUtil.getParameter(request, prefix + "bkg_mst_hbl_tp_cd", ""));
		setPayTermCd(JSPUtil.getParameter(request, prefix + "pay_term_cd", ""));
		setNoteConvSeq(JSPUtil.getParameter(request, prefix + "note_conv_seq", ""));
		setConvRatUtCd(JSPUtil.getParameter(request, prefix + "conv_rat_ut_cd", ""));
		setRtApplTpCd(JSPUtil.getParameter(request, prefix + "rt_appl_tp_cd", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setNoteClssCd(JSPUtil.getParameter(request, prefix + "note_clss_cd", ""));
		setBkgSocFlg(JSPUtil.getParameter(request, prefix + "bkg_soc_flg", ""));
		setBkgTsPortDefCd(JSPUtil.getParameter(request, prefix + "bkg_ts_port_def_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setBkgCmdtDefCd(JSPUtil.getParameter(request, prefix + "bkg_cmdt_def_cd", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request, prefix + "gen_spcl_rt_tp_cd", ""));
		setBkgOrgTrspModCd(JSPUtil.getParameter(request, prefix + "bkg_org_trsp_mod_cd", ""));
		setBkgIoGaCd(JSPUtil.getParameter(request, prefix + "bkg_io_ga_cd", ""));
		setRtOpCd(JSPUtil.getParameter(request, prefix + "rt_op_cd", ""));
		setChgRuleDefCd(JSPUtil.getParameter(request, prefix + "chg_rule_def_cd", ""));
		setConvCmdtDefCd(JSPUtil.getParameter(request, prefix + "conv_cmdt_def_cd", ""));
		setRtPattTpCd(JSPUtil.getParameter(request, prefix + "rt_patt_tp_cd", ""));
		setBkgPolDefCd(JSPUtil.getParameter(request, prefix + "bkg_pol_def_cd", ""));
		setConvPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "conv_prc_cgo_tp_cd", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, prefix + "ctrt_pty_nm", ""));
		setConvPrcDeTermCd(JSPUtil.getParameter(request, prefix + "conv_prc_de_term_cd", ""));
		setBkgRatUtCd(JSPUtil.getParameter(request, prefix + "bkg_rat_ut_cd", ""));
		setBkgCnlTzCd(JSPUtil.getParameter(request, prefix + "bkg_cnl_tz_cd", ""));
		setConvDestLocDefCd(JSPUtil.getParameter(request, prefix + "conv_dest_loc_def_cd", ""));
		setBkgDelDefCd(JSPUtil.getParameter(request, prefix + "bkg_del_def_cd", ""));
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setBkgUsaSvcModCd(JSPUtil.getParameter(request, prefix + "bkg_usa_svc_mod_cd", ""));
		setBkgImdgClssCd(JSPUtil.getParameter(request, prefix + "bkg_imdg_clss_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setConvOrgViaLocDefCd(JSPUtil.getParameter(request, prefix + "conv_org_via_loc_def_cd", ""));
		setBkgPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_prc_cgo_tp_cd", ""));
		setConvPrcRcvTermCd(JSPUtil.getParameter(request, prefix + "conv_prc_rcv_term_cd", ""));
		setBkgDestTrspModCd(JSPUtil.getParameter(request, prefix + "bkg_dest_trsp_mod_cd", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", ""));
		setBkgDirCallFlg(JSPUtil.getParameter(request, prefix + "bkg_dir_call_flg", ""));
		setNoteCtnt(JSPUtil.getParameter(request, prefix + "note_ctnt", ""));
		setBkgActCustDefCd(JSPUtil.getParameter(request, prefix + "bkg_act_cust_def_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScCnt(JSPUtil.getParameter(request, prefix + "sc_cnt", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setConvOrgLocDefCd(JSPUtil.getParameter(request, prefix + "conv_org_loc_def_cd", ""));
		setIgnTrfFlg(JSPUtil.getParameter(request, prefix + "ign_trf_flg", ""));
		setBkgSlanCd(JSPUtil.getParameter(request, prefix + "bkg_slan_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setNoteConvTpCd(JSPUtil.getParameter(request, prefix + "note_conv_tp_cd", ""));
		setRuleApplChgTpCd(JSPUtil.getParameter(request, prefix + "rule_appl_chg_tp_cd", ""));
		setRuleApplChgCd(JSPUtil.getParameter(request, prefix + "rule_appl_chg_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setNoteConvRuleCd(JSPUtil.getParameter(request, prefix + "note_conv_rule_cd", ""));
		setBkgPodDefCd(JSPUtil.getParameter(request, prefix + "bkg_pod_def_cd", ""));
		setBkgScgGrpCmdtCd(JSPUtil.getParameter(request, prefix + "bkg_scg_grp_cmdt_cd", ""));
		setBkgPorDefCd(JSPUtil.getParameter(request, prefix + "bkg_por_def_cd", ""));
		setBkgEsvcTpCd(JSPUtil.getParameter(request, prefix + "bkg_esvc_tp_cd", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setFrtRtAmt(JSPUtil.getParameter(request, prefix + "frt_rt_amt", ""));
		setConvDestViaLocDefCd(JSPUtil.getParameter(request, prefix + "conv_dest_via_loc_def_cd", ""));
		setBkgVvdCd(JSPUtil.getParameter(request, prefix + "bkg_vvd_cd", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request, prefix + "bkg_de_term_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScNoteConversionVO[]
	 */
	public ScNoteConversionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScNoteConversionVO[]
	 */
	public ScNoteConversionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScNoteConversionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] bkgMstHblTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_mst_hbl_tp_cd", length));
			String[] payTermCd = (JSPUtil.getParameter(request, prefix	+ "pay_term_cd", length));
			String[] noteConvSeq = (JSPUtil.getParameter(request, prefix	+ "note_conv_seq", length));
			String[] convRatUtCd = (JSPUtil.getParameter(request, prefix	+ "conv_rat_ut_cd", length));
			String[] rtApplTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_appl_tp_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] noteClssCd = (JSPUtil.getParameter(request, prefix	+ "note_clss_cd", length));
			String[] bkgSocFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_soc_flg", length));
			String[] bkgTsPortDefCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_port_def_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] bkgCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cmdt_def_cd", length));
			String[] genSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd", length));
			String[] bkgOrgTrspModCd = (JSPUtil.getParameter(request, prefix	+ "bkg_org_trsp_mod_cd", length));
			String[] bkgIoGaCd = (JSPUtil.getParameter(request, prefix	+ "bkg_io_ga_cd", length));
			String[] rtOpCd = (JSPUtil.getParameter(request, prefix	+ "rt_op_cd", length));
			String[] chgRuleDefCd = (JSPUtil.getParameter(request, prefix	+ "chg_rule_def_cd", length));
			String[] convCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "conv_cmdt_def_cd", length));
			String[] rtPattTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_patt_tp_cd", length));
			String[] bkgPolDefCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_def_cd", length));
			String[] convPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "conv_prc_cgo_tp_cd", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] convPrcDeTermCd = (JSPUtil.getParameter(request, prefix	+ "conv_prc_de_term_cd", length));
			String[] bkgRatUtCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rat_ut_cd", length));
			String[] bkgCnlTzCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cnl_tz_cd", length));
			String[] convDestLocDefCd = (JSPUtil.getParameter(request, prefix	+ "conv_dest_loc_def_cd", length));
			String[] bkgDelDefCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_def_cd", length));
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] bkgUsaSvcModCd = (JSPUtil.getParameter(request, prefix	+ "bkg_usa_svc_mod_cd", length));
			String[] bkgImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "bkg_imdg_clss_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] convOrgViaLocDefCd = (JSPUtil.getParameter(request, prefix	+ "conv_org_via_loc_def_cd", length));
			String[] bkgPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_prc_cgo_tp_cd", length));
			String[] convPrcRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "conv_prc_rcv_term_cd", length));
			String[] bkgDestTrspModCd = (JSPUtil.getParameter(request, prefix	+ "bkg_dest_trsp_mod_cd", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] bkgDirCallFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_dir_call_flg", length));
			String[] noteCtnt = (JSPUtil.getParameter(request, prefix	+ "note_ctnt", length));
			String[] bkgActCustDefCd = (JSPUtil.getParameter(request, prefix	+ "bkg_act_cust_def_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scCnt = (JSPUtil.getParameter(request, prefix	+ "sc_cnt", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] convOrgLocDefCd = (JSPUtil.getParameter(request, prefix	+ "conv_org_loc_def_cd", length));
			String[] ignTrfFlg = (JSPUtil.getParameter(request, prefix	+ "ign_trf_flg", length));
			String[] bkgSlanCd = (JSPUtil.getParameter(request, prefix	+ "bkg_slan_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] noteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "note_conv_tp_cd", length));
			String[] ruleApplChgTpCd = (JSPUtil.getParameter(request, prefix	+ "rule_appl_chg_tp_cd", length));
			String[] ruleApplChgCd = (JSPUtil.getParameter(request, prefix	+ "rule_appl_chg_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] noteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "note_conv_rule_cd", length));
			String[] bkgPodDefCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_def_cd", length));
			String[] bkgScgGrpCmdtCd = (JSPUtil.getParameter(request, prefix	+ "bkg_scg_grp_cmdt_cd", length));
			String[] bkgPorDefCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_def_cd", length));
			String[] bkgEsvcTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_esvc_tp_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] frtRtAmt = (JSPUtil.getParameter(request, prefix	+ "frt_rt_amt", length));
			String[] convDestViaLocDefCd = (JSPUtil.getParameter(request, prefix	+ "conv_dest_via_loc_def_cd", length));
			String[] bkgVvdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_vvd_cd", length));
			String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_de_term_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScNoteConversionVO();
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (bkgMstHblTpCd[i] != null)
					model.setBkgMstHblTpCd(bkgMstHblTpCd[i]);
				if (payTermCd[i] != null)
					model.setPayTermCd(payTermCd[i]);
				if (noteConvSeq[i] != null)
					model.setNoteConvSeq(noteConvSeq[i]);
				if (convRatUtCd[i] != null)
					model.setConvRatUtCd(convRatUtCd[i]);
				if (rtApplTpCd[i] != null)
					model.setRtApplTpCd(rtApplTpCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (noteClssCd[i] != null)
					model.setNoteClssCd(noteClssCd[i]);
				if (bkgSocFlg[i] != null)
					model.setBkgSocFlg(bkgSocFlg[i]);
				if (bkgTsPortDefCd[i] != null)
					model.setBkgTsPortDefCd(bkgTsPortDefCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (bkgCmdtDefCd[i] != null)
					model.setBkgCmdtDefCd(bkgCmdtDefCd[i]);
				if (genSpclRtTpCd[i] != null)
					model.setGenSpclRtTpCd(genSpclRtTpCd[i]);
				if (bkgOrgTrspModCd[i] != null)
					model.setBkgOrgTrspModCd(bkgOrgTrspModCd[i]);
				if (bkgIoGaCd[i] != null)
					model.setBkgIoGaCd(bkgIoGaCd[i]);
				if (rtOpCd[i] != null)
					model.setRtOpCd(rtOpCd[i]);
				if (chgRuleDefCd[i] != null)
					model.setChgRuleDefCd(chgRuleDefCd[i]);
				if (convCmdtDefCd[i] != null)
					model.setConvCmdtDefCd(convCmdtDefCd[i]);
				if (rtPattTpCd[i] != null)
					model.setRtPattTpCd(rtPattTpCd[i]);
				if (bkgPolDefCd[i] != null)
					model.setBkgPolDefCd(bkgPolDefCd[i]);
				if (convPrcCgoTpCd[i] != null)
					model.setConvPrcCgoTpCd(convPrcCgoTpCd[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (convPrcDeTermCd[i] != null)
					model.setConvPrcDeTermCd(convPrcDeTermCd[i]);
				if (bkgRatUtCd[i] != null)
					model.setBkgRatUtCd(bkgRatUtCd[i]);
				if (bkgCnlTzCd[i] != null)
					model.setBkgCnlTzCd(bkgCnlTzCd[i]);
				if (convDestLocDefCd[i] != null)
					model.setConvDestLocDefCd(convDestLocDefCd[i]);
				if (bkgDelDefCd[i] != null)
					model.setBkgDelDefCd(bkgDelDefCd[i]);
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (bkgUsaSvcModCd[i] != null)
					model.setBkgUsaSvcModCd(bkgUsaSvcModCd[i]);
				if (bkgImdgClssCd[i] != null)
					model.setBkgImdgClssCd(bkgImdgClssCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (convOrgViaLocDefCd[i] != null)
					model.setConvOrgViaLocDefCd(convOrgViaLocDefCd[i]);
				if (bkgPrcCgoTpCd[i] != null)
					model.setBkgPrcCgoTpCd(bkgPrcCgoTpCd[i]);
				if (convPrcRcvTermCd[i] != null)
					model.setConvPrcRcvTermCd(convPrcRcvTermCd[i]);
				if (bkgDestTrspModCd[i] != null)
					model.setBkgDestTrspModCd(bkgDestTrspModCd[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (bkgDirCallFlg[i] != null)
					model.setBkgDirCallFlg(bkgDirCallFlg[i]);
				if (noteCtnt[i] != null)
					model.setNoteCtnt(noteCtnt[i]);
				if (bkgActCustDefCd[i] != null)
					model.setBkgActCustDefCd(bkgActCustDefCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scCnt[i] != null)
					model.setScCnt(scCnt[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (convOrgLocDefCd[i] != null)
					model.setConvOrgLocDefCd(convOrgLocDefCd[i]);
				if (ignTrfFlg[i] != null)
					model.setIgnTrfFlg(ignTrfFlg[i]);
				if (bkgSlanCd[i] != null)
					model.setBkgSlanCd(bkgSlanCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (noteConvTpCd[i] != null)
					model.setNoteConvTpCd(noteConvTpCd[i]);
				if (ruleApplChgTpCd[i] != null)
					model.setRuleApplChgTpCd(ruleApplChgTpCd[i]);
				if (ruleApplChgCd[i] != null)
					model.setRuleApplChgCd(ruleApplChgCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (noteConvRuleCd[i] != null)
					model.setNoteConvRuleCd(noteConvRuleCd[i]);
				if (bkgPodDefCd[i] != null)
					model.setBkgPodDefCd(bkgPodDefCd[i]);
				if (bkgScgGrpCmdtCd[i] != null)
					model.setBkgScgGrpCmdtCd(bkgScgGrpCmdtCd[i]);
				if (bkgPorDefCd[i] != null)
					model.setBkgPorDefCd(bkgPorDefCd[i]);
				if (bkgEsvcTpCd[i] != null)
					model.setBkgEsvcTpCd(bkgEsvcTpCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (frtRtAmt[i] != null)
					model.setFrtRtAmt(frtRtAmt[i]);
				if (convDestViaLocDefCd[i] != null)
					model.setConvDestViaLocDefCd(convDestViaLocDefCd[i]);
				if (bkgVvdCd[i] != null)
					model.setBkgVvdCd(bkgVvdCd[i]);
				if (bkgDeTermCd[i] != null)
					model.setBkgDeTermCd(bkgDeTermCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScNoteConversionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScNoteConversionVO[]
	 */
	public ScNoteConversionVO[] getScNoteConversionVOs(){
		ScNoteConversionVO[] vos = (ScNoteConversionVO[])models.toArray(new ScNoteConversionVO[models.size()]);
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
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMstHblTpCd = this.bkgMstHblTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermCd = this.payTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvSeq = this.noteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convRatUtCd = this.convRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtApplTpCd = this.rtApplTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteClssCd = this.noteClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSocFlg = this.bkgSocFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsPortDefCd = this.bkgTsPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCmdtDefCd = this.bkgCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd = this.genSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOrgTrspModCd = this.bkgOrgTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgIoGaCd = this.bkgIoGaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtOpCd = this.rtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRuleDefCd = this.chgRuleDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convCmdtDefCd = this.convCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtPattTpCd = this.rtPattTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolDefCd = this.bkgPolDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convPrcCgoTpCd = this.convPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convPrcDeTermCd = this.convPrcDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRatUtCd = this.bkgRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCnlTzCd = this.bkgCnlTzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDestLocDefCd = this.convDestLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelDefCd = this.bkgDelDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgUsaSvcModCd = this.bkgUsaSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgImdgClssCd = this.bkgImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convOrgViaLocDefCd = this.convOrgViaLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPrcCgoTpCd = this.bkgPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convPrcRcvTermCd = this.convPrcRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDestTrspModCd = this.bkgDestTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDirCallFlg = this.bkgDirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt = this.noteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgActCustDefCd = this.bkgActCustDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scCnt = this.scCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convOrgLocDefCd = this.convOrgLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ignTrfFlg = this.ignTrfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSlanCd = this.bkgSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvTpCd = this.noteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ruleApplChgTpCd = this.ruleApplChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ruleApplChgCd = this.ruleApplChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvRuleCd = this.noteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodDefCd = this.bkgPodDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgScgGrpCmdtCd = this.bkgScgGrpCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorDefCd = this.bkgPorDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgEsvcTpCd = this.bkgEsvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtRtAmt = this.frtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDestViaLocDefCd = this.convDestViaLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVvdCd = this.bkgVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd = this.bkgDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
