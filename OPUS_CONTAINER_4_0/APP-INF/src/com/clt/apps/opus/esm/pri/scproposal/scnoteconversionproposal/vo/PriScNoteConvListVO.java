/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PriScNoteConvListVO.java
 *@FileTitle : PriScNoteConvListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.11.19
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2015.11.19 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author jaewonLee
 * @since J2EE 1.6
 * @see	..
 */
public class PriScNoteConvListVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PriScNoteConvListVO>  models =	new	ArrayList<PriScNoteConvListVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String amdtSeq = null;
	/*	Column Info	*/
	private String svcScpCd = null;
	/*	Column Info	*/
	private String payTermCd = null;
	/*	Column Info	*/
	private String bkgMstHblTpCd = null;
	/*	Column Info	*/
	private String convCmdtTpCd = null;
	/*	Column Info	*/
	private String noteConvSeq = null;
	/*	Column Info	*/
	private String rtApplTpCd = null;
	/*	Column Info	*/
	private String convRatUtCd = null;
	/*	Column Info	*/
	private String convDestLocCntCd = null;
	/*	Column Info	*/
	private String bkgDelTpCd = null;
	/*	Column Info	*/
	private String bkgSocFlg = null;
	/*	Column Info	*/
	private String effDt = null;
	/*	Column Info	*/
	private String bkgTsPortTpCd = null;
	/*	Column Info	*/
	private String convDestLocTpCd = null;
	/*	Column Info	*/
	private String bkgTsPortDefCd = null;
	/*	Column Info	*/
	private String bkgCmdtDefCd = null;
	/*	Column Info	*/
	private String genSpclRtTpCd = null;
	/*	Column Info	*/
	private String bkgOrgTrspModCd = null;
	/*	Column Info	*/
	private String bkgPodTpCd = null;
	/*	Column Info	*/
	private String convDestViaLocCntCd = null;
	/*	Column Info	*/
	private String convOrgViaLocTpCd = null;
	/*	Column Info	*/
	private String bkgCmdtTpCd = null;
	/*	Column Info	*/
	private String updUsrId = null;
	/*	Column Info	*/
	private String bkgIoGaCd = null;
	/*	Column Info	*/
	private String rtOpCd = null;
	/*	Column Info	*/
	private String bkgActCustCntCd = null;
	/*	Column Info	*/
	private String convCmdtDefCd = null;
	/*	Column Info	*/
	private String noteConvMapgId = null;
	/*	Column Info	*/
	private String bkgPolDefCd = null;
	/*	Column Info	*/
	private String chgRuleTpCd = null;
	/*	Column Info	*/
	private String creUsrId = null;
	/*	Column Info	*/
	private String convPrcCgoTpCd = null;
	/*	Column Info	*/
	private String convPrcDeTermCd = null;
	/*	Column Info	*/
	private String convOrgViaLocCntCd = null;
	/*	Column Info	*/
	private String bkgRatUtCd = null;
	/*	Column Info	*/
	private String bkgCnlTzCd = null;
	/*	Column Info	*/
	private String bkgDelDefCd = null;
	/*	Column Info	*/
	private String convDestLocDefCd = null;
	/*	Column Info	*/
	private String bkgUsaSvcModCd = null;
	/*	Column Info	*/
	private String bkgImdgClssCd = null;
	/*	Column Info	*/
	private String convDestViaLocTpCd = null;
	/*	Column Info	*/
	private String currCd = null;
	/*	Column Info	*/
	private String convOrgViaLocDefCd = null;
	/*	Column Info	*/
	private String bkgPrcCgoTpCd = null;
	/*	Column Info	*/
	private String creDt = null;
	/*	Column Info	*/
	private String convPrcRcvTermCd = null;
	/*	Column Info	*/
	private String bkgRcvTermCd = null;
	/*	Column Info	*/
	private String bkgDestTrspModCd = null;
	/*	Column Info	*/
	private String bkgDirCallFlg = null;
	/*	Column Info	*/
	private String bkgDelCntCd = null;
	/*	Column Info	*/
	private String usrId = null;
	/*	Column Info	*/
	private String noteHdrSeq = null;
	/*	Column Info	*/
	private String convOrgLocDefCd = null;
	/*	Column Info	*/
	private String bkgSlanCd = null;
	/*	Column Info	*/
	private String bkgPolCntCd = null;
	/*	Column Info	*/
	private String expDt = null;
	/*	Column Info	*/
	private String bkgPolTpCd = null;
	/*	Column Info	*/
	private String noteConvTpCd = null;
	/*	Column Info	*/
	private String ruleApplChgTpCd = null;
	/*	Column Info	*/
	private String updDt = null;
	/*	Column Info	*/
	private String bkgSkdDirCd = null;
	/*	Column Info	*/
	private String noteConvRuleCd = null;
	/*	Column Info	*/
	private String bkgPorTpCd = null;
	/*	Column Info	*/
	private String bkgPodDefCd = null;
	/*	Column Info	*/
	private String bkgScgGrpCmdtCd = null;
	/*	Column Info	*/
	private String noteConvChgCd = null;
	/*	Column Info	*/
	private String convOrgLocTpCd = null;
	/*	Column Info	*/
	private String bkgPorDefCd = null;
	/*	Column Info	*/
	private String bkgSkdVoyNo = null;
	/*	Column Info	*/
	private String bkgActCustSeq = null;
	/*	Column Info	*/
	private String bkgEsvcTpCd = null;
	/*	Column Info	*/
	private String convOrgLocCntCd = null;
	/*	Column Info	*/
	private String propNo = null;
	/*	Column Info	*/
	private String frtRtAmt = null;
	/*	Column Info	*/
	private String convDestViaLocDefCd = null;
	/*	Column Info	*/
	private String bkgPorCntCd = null;
	/*	Column Info	*/
	private String bkgPodCntCd = null;
	/*	Column Info	*/
	private String bkgVslCd = null;
	/*	Column Info	*/
	private String bkgDeTermCd = null;
	/*	Column Info	*/
	private String bkgMinCgoWgt = null;
	/*	Column Info	*/
	private String bkgMaxCgoWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public PriScNoteConvListVO(){}

	public PriScNoteConvListVO(String ibflag,String pagerows,String amdtSeq,String svcScpCd,String payTermCd,String bkgMstHblTpCd,String convCmdtTpCd,String noteConvSeq,String rtApplTpCd,String convRatUtCd,String convDestLocCntCd,String bkgDelTpCd,String bkgSocFlg,String effDt,String bkgTsPortTpCd,String convDestLocTpCd,String bkgTsPortDefCd,String bkgCmdtDefCd,String genSpclRtTpCd,String bkgOrgTrspModCd,String bkgPodTpCd,String convDestViaLocCntCd,String convOrgViaLocTpCd,String bkgCmdtTpCd,String updUsrId,String bkgIoGaCd,String rtOpCd,String bkgActCustCntCd,String convCmdtDefCd,String noteConvMapgId,String bkgPolDefCd,String chgRuleTpCd,String creUsrId,String convPrcCgoTpCd,String convPrcDeTermCd,String convOrgViaLocCntCd,String bkgRatUtCd,String bkgCnlTzCd,String bkgDelDefCd,String convDestLocDefCd,String bkgUsaSvcModCd,String bkgImdgClssCd,String convDestViaLocTpCd,String currCd,String convOrgViaLocDefCd,String bkgPrcCgoTpCd,String creDt,String convPrcRcvTermCd,String bkgRcvTermCd,String bkgDestTrspModCd,String bkgDirCallFlg,String bkgDelCntCd,String usrId,String noteHdrSeq,String convOrgLocDefCd,String bkgSlanCd,String bkgPolCntCd,String expDt,String bkgPolTpCd,String noteConvTpCd,String ruleApplChgTpCd,String updDt,String bkgSkdDirCd,String noteConvRuleCd,String bkgPorTpCd,String bkgPodDefCd,String bkgScgGrpCmdtCd,String noteConvChgCd,String convOrgLocTpCd,String bkgPorDefCd,String bkgSkdVoyNo,String bkgActCustSeq,String bkgEsvcTpCd,String convOrgLocCntCd,String propNo,String frtRtAmt,String convDestViaLocDefCd,String bkgPorCntCd,String bkgPodCntCd,String bkgVslCd,String bkgDeTermCd,String bkgMinCgoWgt,String bkgMaxCgoWgt)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.payTermCd = payTermCd;
		this.bkgMstHblTpCd = bkgMstHblTpCd;
		this.convCmdtTpCd = convCmdtTpCd;
		this.noteConvSeq = noteConvSeq;
		this.rtApplTpCd = rtApplTpCd;
		this.convRatUtCd = convRatUtCd;
		this.convDestLocCntCd = convDestLocCntCd;
		this.bkgDelTpCd = bkgDelTpCd;
		this.bkgSocFlg = bkgSocFlg;
		this.effDt = effDt;
		this.bkgTsPortTpCd = bkgTsPortTpCd;
		this.convDestLocTpCd = convDestLocTpCd;
		this.bkgTsPortDefCd = bkgTsPortDefCd;
		this.bkgCmdtDefCd = bkgCmdtDefCd;
		this.genSpclRtTpCd = genSpclRtTpCd;
		this.bkgOrgTrspModCd = bkgOrgTrspModCd;
		this.bkgPodTpCd = bkgPodTpCd;
		this.convDestViaLocCntCd = convDestViaLocCntCd;
		this.convOrgViaLocTpCd = convOrgViaLocTpCd;
		this.bkgCmdtTpCd = bkgCmdtTpCd;
		this.updUsrId = updUsrId;
		this.bkgIoGaCd = bkgIoGaCd;
		this.rtOpCd = rtOpCd;
		this.bkgActCustCntCd = bkgActCustCntCd;
		this.convCmdtDefCd = convCmdtDefCd;
		this.noteConvMapgId = noteConvMapgId;
		this.bkgPolDefCd = bkgPolDefCd;
		this.chgRuleTpCd = chgRuleTpCd;
		this.creUsrId = creUsrId;
		this.convPrcCgoTpCd = convPrcCgoTpCd;
		this.convPrcDeTermCd = convPrcDeTermCd;
		this.convOrgViaLocCntCd = convOrgViaLocCntCd;
		this.bkgRatUtCd = bkgRatUtCd;
		this.bkgCnlTzCd = bkgCnlTzCd;
		this.bkgDelDefCd = bkgDelDefCd;
		this.convDestLocDefCd = convDestLocDefCd;
		this.bkgUsaSvcModCd = bkgUsaSvcModCd;
		this.bkgImdgClssCd = bkgImdgClssCd;
		this.convDestViaLocTpCd = convDestViaLocTpCd;
		this.currCd = currCd;
		this.convOrgViaLocDefCd = convOrgViaLocDefCd;
		this.bkgPrcCgoTpCd = bkgPrcCgoTpCd;
		this.creDt = creDt;
		this.convPrcRcvTermCd = convPrcRcvTermCd;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.bkgDestTrspModCd = bkgDestTrspModCd;
		this.bkgDirCallFlg = bkgDirCallFlg;
		this.bkgDelCntCd = bkgDelCntCd;
		this.usrId = usrId;
		this.noteHdrSeq = noteHdrSeq;
		this.convOrgLocDefCd = convOrgLocDefCd;
		this.bkgSlanCd = bkgSlanCd;
		this.bkgPolCntCd = bkgPolCntCd;
		this.expDt = expDt;
		this.bkgPolTpCd = bkgPolTpCd;
		this.noteConvTpCd = noteConvTpCd;
		this.ruleApplChgTpCd = ruleApplChgTpCd;
		this.updDt = updDt;
		this.bkgSkdDirCd = bkgSkdDirCd;
		this.noteConvRuleCd = noteConvRuleCd;
		this.bkgPorTpCd = bkgPorTpCd;
		this.bkgPodDefCd = bkgPodDefCd;
		this.bkgScgGrpCmdtCd = bkgScgGrpCmdtCd;
		this.noteConvChgCd = noteConvChgCd;
		this.convOrgLocTpCd = convOrgLocTpCd;
		this.bkgPorDefCd = bkgPorDefCd;
		this.bkgSkdVoyNo = bkgSkdVoyNo;
		this.bkgActCustSeq = bkgActCustSeq;
		this.bkgEsvcTpCd = bkgEsvcTpCd;
		this.convOrgLocCntCd = convOrgLocCntCd;
		this.propNo = propNo;
		this.frtRtAmt = frtRtAmt;
		this.convDestViaLocDefCd = convDestViaLocDefCd;
		this.bkgPorCntCd = bkgPorCntCd;
		this.bkgPodCntCd = bkgPodCntCd;
		this.bkgVslCd = bkgVslCd;
		this.bkgDeTermCd = bkgDeTermCd;
		this.bkgMinCgoWgt = bkgMinCgoWgt;
		this.bkgMaxCgoWgt = bkgMaxCgoWgt;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pay_term_cd", getPayTermCd());
		this.hashColumns.put("bkg_mst_hbl_tp_cd", getBkgMstHblTpCd());
		this.hashColumns.put("conv_cmdt_tp_cd", getConvCmdtTpCd());
		this.hashColumns.put("note_conv_seq", getNoteConvSeq());
		this.hashColumns.put("rt_appl_tp_cd", getRtApplTpCd());
		this.hashColumns.put("conv_rat_ut_cd", getConvRatUtCd());
		this.hashColumns.put("conv_dest_loc_cnt_cd", getConvDestLocCntCd());
		this.hashColumns.put("bkg_del_tp_cd", getBkgDelTpCd());
		this.hashColumns.put("bkg_soc_flg", getBkgSocFlg());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("bkg_ts_port_tp_cd", getBkgTsPortTpCd());
		this.hashColumns.put("conv_dest_loc_tp_cd", getConvDestLocTpCd());
		this.hashColumns.put("bkg_ts_port_def_cd", getBkgTsPortDefCd());
		this.hashColumns.put("bkg_cmdt_def_cd", getBkgCmdtDefCd());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		this.hashColumns.put("bkg_org_trsp_mod_cd", getBkgOrgTrspModCd());
		this.hashColumns.put("bkg_pod_tp_cd", getBkgPodTpCd());
		this.hashColumns.put("conv_dest_via_loc_cnt_cd", getConvDestViaLocCntCd());
		this.hashColumns.put("conv_org_via_loc_tp_cd", getConvOrgViaLocTpCd());
		this.hashColumns.put("bkg_cmdt_tp_cd", getBkgCmdtTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("bkg_io_ga_cd", getBkgIoGaCd());
		this.hashColumns.put("rt_op_cd", getRtOpCd());
		this.hashColumns.put("bkg_act_cust_cnt_cd", getBkgActCustCntCd());
		this.hashColumns.put("conv_cmdt_def_cd", getConvCmdtDefCd());
		this.hashColumns.put("note_conv_mapg_id", getNoteConvMapgId());
		this.hashColumns.put("bkg_pol_def_cd", getBkgPolDefCd());
		this.hashColumns.put("chg_rule_tp_cd", getChgRuleTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("conv_prc_cgo_tp_cd", getConvPrcCgoTpCd());
		this.hashColumns.put("conv_prc_de_term_cd", getConvPrcDeTermCd());
		this.hashColumns.put("conv_org_via_loc_cnt_cd", getConvOrgViaLocCntCd());
		this.hashColumns.put("bkg_rat_ut_cd", getBkgRatUtCd());
		this.hashColumns.put("bkg_cnl_tz_cd", getBkgCnlTzCd());
		this.hashColumns.put("bkg_del_def_cd", getBkgDelDefCd());
		this.hashColumns.put("conv_dest_loc_def_cd", getConvDestLocDefCd());
		this.hashColumns.put("bkg_usa_svc_mod_cd", getBkgUsaSvcModCd());
		this.hashColumns.put("bkg_imdg_clss_cd", getBkgImdgClssCd());
		this.hashColumns.put("conv_dest_via_loc_tp_cd", getConvDestViaLocTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("conv_org_via_loc_def_cd", getConvOrgViaLocDefCd());
		this.hashColumns.put("bkg_prc_cgo_tp_cd", getBkgPrcCgoTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("conv_prc_rcv_term_cd", getConvPrcRcvTermCd());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("bkg_dest_trsp_mod_cd", getBkgDestTrspModCd());
		this.hashColumns.put("bkg_dir_call_flg", getBkgDirCallFlg());
		this.hashColumns.put("bkg_del_cnt_cd", getBkgDelCntCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("note_hdr_seq", getNoteHdrSeq());
		this.hashColumns.put("conv_org_loc_def_cd", getConvOrgLocDefCd());
		this.hashColumns.put("bkg_slan_cd", getBkgSlanCd());
		this.hashColumns.put("bkg_pol_cnt_cd", getBkgPolCntCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("bkg_pol_tp_cd", getBkgPolTpCd());
		this.hashColumns.put("note_conv_tp_cd", getNoteConvTpCd());
		this.hashColumns.put("rule_appl_chg_tp_cd", getRuleApplChgTpCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bkg_skd_dir_cd", getBkgSkdDirCd());
		this.hashColumns.put("note_conv_rule_cd", getNoteConvRuleCd());
		this.hashColumns.put("bkg_por_tp_cd", getBkgPorTpCd());
		this.hashColumns.put("bkg_pod_def_cd", getBkgPodDefCd());
		this.hashColumns.put("bkg_scg_grp_cmdt_cd", getBkgScgGrpCmdtCd());
		this.hashColumns.put("note_conv_chg_cd", getNoteConvChgCd());
		this.hashColumns.put("conv_org_loc_tp_cd", getConvOrgLocTpCd());
		this.hashColumns.put("bkg_por_def_cd", getBkgPorDefCd());
		this.hashColumns.put("bkg_skd_voy_no", getBkgSkdVoyNo());
		this.hashColumns.put("bkg_act_cust_seq", getBkgActCustSeq());
		this.hashColumns.put("bkg_esvc_tp_cd", getBkgEsvcTpCd());
		this.hashColumns.put("conv_org_loc_cnt_cd", getConvOrgLocCntCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("frt_rt_amt", getFrtRtAmt());
		this.hashColumns.put("conv_dest_via_loc_def_cd", getConvDestViaLocDefCd());
		this.hashColumns.put("bkg_por_cnt_cd", getBkgPorCntCd());
		this.hashColumns.put("bkg_pod_cnt_cd", getBkgPodCntCd());
		this.hashColumns.put("bkg_vsl_cd", getBkgVslCd());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		this.hashColumns.put("bkg_min_cgo_wgt", getBkgMinCgoWgt());
		this.hashColumns.put("bkg_max_cgo_wgt", getBkgMaxCgoWgt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("pay_term_cd", "payTermCd");
		this.hashFields.put("bkg_mst_hbl_tp_cd", "bkgMstHblTpCd");
		this.hashFields.put("conv_cmdt_tp_cd", "convCmdtTpCd");
		this.hashFields.put("note_conv_seq", "noteConvSeq");
		this.hashFields.put("rt_appl_tp_cd", "rtApplTpCd");
		this.hashFields.put("conv_rat_ut_cd", "convRatUtCd");
		this.hashFields.put("conv_dest_loc_cnt_cd", "convDestLocCntCd");
		this.hashFields.put("bkg_del_tp_cd", "bkgDelTpCd");
		this.hashFields.put("bkg_soc_flg", "bkgSocFlg");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("bkg_ts_port_tp_cd", "bkgTsPortTpCd");
		this.hashFields.put("conv_dest_loc_tp_cd", "convDestLocTpCd");
		this.hashFields.put("bkg_ts_port_def_cd", "bkgTsPortDefCd");
		this.hashFields.put("bkg_cmdt_def_cd", "bkgCmdtDefCd");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		this.hashFields.put("bkg_org_trsp_mod_cd", "bkgOrgTrspModCd");
		this.hashFields.put("bkg_pod_tp_cd", "bkgPodTpCd");
		this.hashFields.put("conv_dest_via_loc_cnt_cd", "convDestViaLocCntCd");
		this.hashFields.put("conv_org_via_loc_tp_cd", "convOrgViaLocTpCd");
		this.hashFields.put("bkg_cmdt_tp_cd", "bkgCmdtTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bkg_io_ga_cd", "bkgIoGaCd");
		this.hashFields.put("rt_op_cd", "rtOpCd");
		this.hashFields.put("bkg_act_cust_cnt_cd", "bkgActCustCntCd");
		this.hashFields.put("conv_cmdt_def_cd", "convCmdtDefCd");
		this.hashFields.put("note_conv_mapg_id", "noteConvMapgId");
		this.hashFields.put("bkg_pol_def_cd", "bkgPolDefCd");
		this.hashFields.put("chg_rule_tp_cd", "chgRuleTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("conv_prc_cgo_tp_cd", "convPrcCgoTpCd");
		this.hashFields.put("conv_prc_de_term_cd", "convPrcDeTermCd");
		this.hashFields.put("conv_org_via_loc_cnt_cd", "convOrgViaLocCntCd");
		this.hashFields.put("bkg_rat_ut_cd", "bkgRatUtCd");
		this.hashFields.put("bkg_cnl_tz_cd", "bkgCnlTzCd");
		this.hashFields.put("bkg_del_def_cd", "bkgDelDefCd");
		this.hashFields.put("conv_dest_loc_def_cd", "convDestLocDefCd");
		this.hashFields.put("bkg_usa_svc_mod_cd", "bkgUsaSvcModCd");
		this.hashFields.put("bkg_imdg_clss_cd", "bkgImdgClssCd");
		this.hashFields.put("conv_dest_via_loc_tp_cd", "convDestViaLocTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("conv_org_via_loc_def_cd", "convOrgViaLocDefCd");
		this.hashFields.put("bkg_prc_cgo_tp_cd", "bkgPrcCgoTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("conv_prc_rcv_term_cd", "convPrcRcvTermCd");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("bkg_dest_trsp_mod_cd", "bkgDestTrspModCd");
		this.hashFields.put("bkg_dir_call_flg", "bkgDirCallFlg");
		this.hashFields.put("bkg_del_cnt_cd", "bkgDelCntCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("note_hdr_seq", "noteHdrSeq");
		this.hashFields.put("conv_org_loc_def_cd", "convOrgLocDefCd");
		this.hashFields.put("bkg_slan_cd", "bkgSlanCd");
		this.hashFields.put("bkg_pol_cnt_cd", "bkgPolCntCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("bkg_pol_tp_cd", "bkgPolTpCd");
		this.hashFields.put("note_conv_tp_cd", "noteConvTpCd");
		this.hashFields.put("rule_appl_chg_tp_cd", "ruleApplChgTpCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bkg_skd_dir_cd", "bkgSkdDirCd");
		this.hashFields.put("note_conv_rule_cd", "noteConvRuleCd");
		this.hashFields.put("bkg_por_tp_cd", "bkgPorTpCd");
		this.hashFields.put("bkg_pod_def_cd", "bkgPodDefCd");
		this.hashFields.put("bkg_scg_grp_cmdt_cd", "bkgScgGrpCmdtCd");
		this.hashFields.put("note_conv_chg_cd", "noteConvChgCd");
		this.hashFields.put("conv_org_loc_tp_cd", "convOrgLocTpCd");
		this.hashFields.put("bkg_por_def_cd", "bkgPorDefCd");
		this.hashFields.put("bkg_skd_voy_no", "bkgSkdVoyNo");
		this.hashFields.put("bkg_act_cust_seq", "bkgActCustSeq");
		this.hashFields.put("bkg_esvc_tp_cd", "bkgEsvcTpCd");
		this.hashFields.put("conv_org_loc_cnt_cd", "convOrgLocCntCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("frt_rt_amt", "frtRtAmt");
		this.hashFields.put("conv_dest_via_loc_def_cd", "convDestViaLocDefCd");
		this.hashFields.put("bkg_por_cnt_cd", "bkgPorCntCd");
		this.hashFields.put("bkg_pod_cnt_cd", "bkgPodCntCd");
		this.hashFields.put("bkg_vsl_cd", "bkgVslCd");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		this.hashFields.put("bkg_min_cgo_wgt", "bkgMinCgoWgt");
		this.hashFields.put("bkg_max_cgo_wgt", "bkgMaxCgoWgt");
		return this.hashFields;
	}

	//	Getters	and	Setters

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public	String getIbflag() {
		return	this.ibflag;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public	String getPagerows() {
		return	this.pagerows;
	}

	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public	String getAmdtSeq() {
		return	this.amdtSeq;
	}

	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public	String getSvcScpCd() {
		return	this.svcScpCd;
	}

	/**
	 * Column Info
	 * @return payTermCd
	 */
	public	String getPayTermCd() {
		return	this.payTermCd;
	}

	/**
	 * Column Info
	 * @return bkgMstHblTpCd
	 */
	public	String getBkgMstHblTpCd() {
		return	this.bkgMstHblTpCd;
	}

	/**
	 * Column Info
	 * @return convCmdtTpCd
	 */
	public	String getConvCmdtTpCd() {
		return	this.convCmdtTpCd;
	}

	/**
	 * Column Info
	 * @return noteConvSeq
	 */
	public	String getNoteConvSeq() {
		return	this.noteConvSeq;
	}

	/**
	 * Column Info
	 * @return rtApplTpCd
	 */
	public	String getRtApplTpCd() {
		return	this.rtApplTpCd;
	}

	/**
	 * Column Info
	 * @return convRatUtCd
	 */
	public	String getConvRatUtCd() {
		return	this.convRatUtCd;
	}

	/**
	 * Column Info
	 * @return convDestLocCntCd
	 */
	public	String getConvDestLocCntCd() {
		return	this.convDestLocCntCd;
	}

	/**
	 * Column Info
	 * @return bkgDelTpCd
	 */
	public	String getBkgDelTpCd() {
		return	this.bkgDelTpCd;
	}

	/**
	 * Column Info
	 * @return bkgSocFlg
	 */
	public	String getBkgSocFlg() {
		return	this.bkgSocFlg;
	}

	/**
	 * Column Info
	 * @return effDt
	 */
	public	String getEffDt() {
		return	this.effDt;
	}

	/**
	 * Column Info
	 * @return bkgTsPortTpCd
	 */
	public	String getBkgTsPortTpCd() {
		return	this.bkgTsPortTpCd;
	}

	/**
	 * Column Info
	 * @return convDestLocTpCd
	 */
	public	String getConvDestLocTpCd() {
		return	this.convDestLocTpCd;
	}

	/**
	 * Column Info
	 * @return bkgTsPortDefCd
	 */
	public	String getBkgTsPortDefCd() {
		return	this.bkgTsPortDefCd;
	}

	/**
	 * Column Info
	 * @return bkgCmdtDefCd
	 */
	public	String getBkgCmdtDefCd() {
		return	this.bkgCmdtDefCd;
	}

	/**
	 * Column Info
	 * @return genSpclRtTpCd
	 */
	public	String getGenSpclRtTpCd() {
		return	this.genSpclRtTpCd;
	}

	/**
	 * Column Info
	 * @return bkgOrgTrspModCd
	 */
	public	String getBkgOrgTrspModCd() {
		return	this.bkgOrgTrspModCd;
	}

	/**
	 * Column Info
	 * @return bkgPodTpCd
	 */
	public	String getBkgPodTpCd() {
		return	this.bkgPodTpCd;
	}

	/**
	 * Column Info
	 * @return convDestViaLocCntCd
	 */
	public	String getConvDestViaLocCntCd() {
		return	this.convDestViaLocCntCd;
	}

	/**
	 * Column Info
	 * @return convOrgViaLocTpCd
	 */
	public	String getConvOrgViaLocTpCd() {
		return	this.convOrgViaLocTpCd;
	}

	/**
	 * Column Info
	 * @return bkgCmdtTpCd
	 */
	public	String getBkgCmdtTpCd() {
		return	this.bkgCmdtTpCd;
	}

	/**
	 * Column Info
	 * @return updUsrId
	 */
	public	String getUpdUsrId() {
		return	this.updUsrId;
	}

	/**
	 * Column Info
	 * @return bkgIoGaCd
	 */
	public	String getBkgIoGaCd() {
		return	this.bkgIoGaCd;
	}

	/**
	 * Column Info
	 * @return rtOpCd
	 */
	public	String getRtOpCd() {
		return	this.rtOpCd;
	}

	/**
	 * Column Info
	 * @return bkgActCustCntCd
	 */
	public	String getBkgActCustCntCd() {
		return	this.bkgActCustCntCd;
	}

	/**
	 * Column Info
	 * @return convCmdtDefCd
	 */
	public	String getConvCmdtDefCd() {
		return	this.convCmdtDefCd;
	}

	/**
	 * Column Info
	 * @return noteConvMapgId
	 */
	public	String getNoteConvMapgId() {
		return	this.noteConvMapgId;
	}

	/**
	 * Column Info
	 * @return bkgPolDefCd
	 */
	public	String getBkgPolDefCd() {
		return	this.bkgPolDefCd;
	}

	/**
	 * Column Info
	 * @return chgRuleTpCd
	 */
	public	String getChgRuleTpCd() {
		return	this.chgRuleTpCd;
	}

	/**
	 * Column Info
	 * @return creUsrId
	 */
	public	String getCreUsrId() {
		return	this.creUsrId;
	}

	/**
	 * Column Info
	 * @return convPrcCgoTpCd
	 */
	public	String getConvPrcCgoTpCd() {
		return	this.convPrcCgoTpCd;
	}

	/**
	 * Column Info
	 * @return convPrcDeTermCd
	 */
	public	String getConvPrcDeTermCd() {
		return	this.convPrcDeTermCd;
	}

	/**
	 * Column Info
	 * @return convOrgViaLocCntCd
	 */
	public	String getConvOrgViaLocCntCd() {
		return	this.convOrgViaLocCntCd;
	}

	/**
	 * Column Info
	 * @return bkgRatUtCd
	 */
	public	String getBkgRatUtCd() {
		return	this.bkgRatUtCd;
	}

	/**
	 * Column Info
	 * @return bkgCnlTzCd
	 */
	public	String getBkgCnlTzCd() {
		return	this.bkgCnlTzCd;
	}

	/**
	 * Column Info
	 * @return bkgDelDefCd
	 */
	public	String getBkgDelDefCd() {
		return	this.bkgDelDefCd;
	}

	/**
	 * Column Info
	 * @return convDestLocDefCd
	 */
	public	String getConvDestLocDefCd() {
		return	this.convDestLocDefCd;
	}

	/**
	 * Column Info
	 * @return bkgUsaSvcModCd
	 */
	public	String getBkgUsaSvcModCd() {
		return	this.bkgUsaSvcModCd;
	}

	/**
	 * Column Info
	 * @return bkgImdgClssCd
	 */
	public	String getBkgImdgClssCd() {
		return	this.bkgImdgClssCd;
	}

	/**
	 * Column Info
	 * @return convDestViaLocTpCd
	 */
	public	String getConvDestViaLocTpCd() {
		return	this.convDestViaLocTpCd;
	}

	/**
	 * Column Info
	 * @return currCd
	 */
	public	String getCurrCd() {
		return	this.currCd;
	}

	/**
	 * Column Info
	 * @return convOrgViaLocDefCd
	 */
	public	String getConvOrgViaLocDefCd() {
		return	this.convOrgViaLocDefCd;
	}

	/**
	 * Column Info
	 * @return bkgPrcCgoTpCd
	 */
	public	String getBkgPrcCgoTpCd() {
		return	this.bkgPrcCgoTpCd;
	}

	/**
	 * Column Info
	 * @return creDt
	 */
	public	String getCreDt() {
		return	this.creDt;
	}

	/**
	 * Column Info
	 * @return convPrcRcvTermCd
	 */
	public	String getConvPrcRcvTermCd() {
		return	this.convPrcRcvTermCd;
	}

	/**
	 * Column Info
	 * @return bkgRcvTermCd
	 */
	public	String getBkgRcvTermCd() {
		return	this.bkgRcvTermCd;
	}

	/**
	 * Column Info
	 * @return bkgDestTrspModCd
	 */
	public	String getBkgDestTrspModCd() {
		return	this.bkgDestTrspModCd;
	}

	/**
	 * Column Info
	 * @return bkgDirCallFlg
	 */
	public	String getBkgDirCallFlg() {
		return	this.bkgDirCallFlg;
	}

	/**
	 * Column Info
	 * @return bkgDelCntCd
	 */
	public	String getBkgDelCntCd() {
		return	this.bkgDelCntCd;
	}

	/**
	 * Column Info
	 * @return usrId
	 */
	public	String getUsrId() {
		return	this.usrId;
	}

	/**
	 * Column Info
	 * @return noteHdrSeq
	 */
	public	String getNoteHdrSeq() {
		return	this.noteHdrSeq;
	}

	/**
	 * Column Info
	 * @return convOrgLocDefCd
	 */
	public	String getConvOrgLocDefCd() {
		return	this.convOrgLocDefCd;
	}

	/**
	 * Column Info
	 * @return bkgSlanCd
	 */
	public	String getBkgSlanCd() {
		return	this.bkgSlanCd;
	}

	/**
	 * Column Info
	 * @return bkgPolCntCd
	 */
	public	String getBkgPolCntCd() {
		return	this.bkgPolCntCd;
	}

	/**
	 * Column Info
	 * @return expDt
	 */
	public	String getExpDt() {
		return	this.expDt;
	}

	/**
	 * Column Info
	 * @return bkgPolTpCd
	 */
	public	String getBkgPolTpCd() {
		return	this.bkgPolTpCd;
	}

	/**
	 * Column Info
	 * @return noteConvTpCd
	 */
	public	String getNoteConvTpCd() {
		return	this.noteConvTpCd;
	}

	/**
	 * Column Info
	 * @return ruleApplChgTpCd
	 */
	public	String getRuleApplChgTpCd() {
		return	this.ruleApplChgTpCd;
	}

	/**
	 * Column Info
	 * @return updDt
	 */
	public	String getUpdDt() {
		return	this.updDt;
	}

	/**
	 * Column Info
	 * @return bkgSkdDirCd
	 */
	public	String getBkgSkdDirCd() {
		return	this.bkgSkdDirCd;
	}

	/**
	 * Column Info
	 * @return noteConvRuleCd
	 */
	public	String getNoteConvRuleCd() {
		return	this.noteConvRuleCd;
	}

	/**
	 * Column Info
	 * @return bkgPorTpCd
	 */
	public	String getBkgPorTpCd() {
		return	this.bkgPorTpCd;
	}

	/**
	 * Column Info
	 * @return bkgPodDefCd
	 */
	public	String getBkgPodDefCd() {
		return	this.bkgPodDefCd;
	}

	/**
	 * Column Info
	 * @return bkgScgGrpCmdtCd
	 */
	public	String getBkgScgGrpCmdtCd() {
		return	this.bkgScgGrpCmdtCd;
	}

	/**
	 * Column Info
	 * @return noteConvChgCd
	 */
	public	String getNoteConvChgCd() {
		return	this.noteConvChgCd;
	}

	/**
	 * Column Info
	 * @return convOrgLocTpCd
	 */
	public	String getConvOrgLocTpCd() {
		return	this.convOrgLocTpCd;
	}

	/**
	 * Column Info
	 * @return bkgPorDefCd
	 */
	public	String getBkgPorDefCd() {
		return	this.bkgPorDefCd;
	}

	/**
	 * Column Info
	 * @return bkgSkdVoyNo
	 */
	public	String getBkgSkdVoyNo() {
		return	this.bkgSkdVoyNo;
	}

	/**
	 * Column Info
	 * @return bkgActCustSeq
	 */
	public	String getBkgActCustSeq() {
		return	this.bkgActCustSeq;
	}

	/**
	 * Column Info
	 * @return bkgEsvcTpCd
	 */
	public	String getBkgEsvcTpCd() {
		return	this.bkgEsvcTpCd;
	}

	/**
	 * Column Info
	 * @return convOrgLocCntCd
	 */
	public	String getConvOrgLocCntCd() {
		return	this.convOrgLocCntCd;
	}

	/**
	 * Column Info
	 * @return propNo
	 */
	public	String getPropNo() {
		return	this.propNo;
	}

	/**
	 * Column Info
	 * @return frtRtAmt
	 */
	public	String getFrtRtAmt() {
		return	this.frtRtAmt;
	}

	/**
	 * Column Info
	 * @return convDestViaLocDefCd
	 */
	public	String getConvDestViaLocDefCd() {
		return	this.convDestViaLocDefCd;
	}

	/**
	 * Column Info
	 * @return bkgPorCntCd
	 */
	public	String getBkgPorCntCd() {
		return	this.bkgPorCntCd;
	}

	/**
	 * Column Info
	 * @return bkgPodCntCd
	 */
	public	String getBkgPodCntCd() {
		return	this.bkgPodCntCd;
	}

	/**
	 * Column Info
	 * @return bkgVslCd
	 */
	public	String getBkgVslCd() {
		return	this.bkgVslCd;
	}

	/**
	 * Column Info
	 * @return bkgDeTermCd
	 */
	public	String getBkgDeTermCd() {
		return	this.bkgDeTermCd;
	}

	/**
	 * Column Info
	 * @return bkgMinCgoWgt
	 */
	public	String getBkgMinCgoWgt() {
		return	this.bkgMinCgoWgt;
	}

	/**
	 * Column Info
	 * @return bkgMaxCgoWgt
	 */
	public	String getBkgMaxCgoWgt() {
		return	this.bkgMaxCgoWgt;
	}

 	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
	public void	setIbflag(String ibflag ) {
		this.ibflag =	ibflag;
	}
 	/**
	 * Page Number
	 * @param  pagerows
 	 */
	public void	setPagerows(String pagerows ) {
		this.pagerows =	pagerows;
	}
 	/**
	 * Column Info
	 * @param  amdtSeq
 	 */
	public void	setAmdtSeq(String amdtSeq ) {
		this.amdtSeq =	amdtSeq;
	}
 	/**
	 * Column Info
	 * @param  svcScpCd
 	 */
	public void	setSvcScpCd(String svcScpCd ) {
		this.svcScpCd =	svcScpCd;
	}
 	/**
	 * Column Info
	 * @param  payTermCd
 	 */
	public void	setPayTermCd(String payTermCd ) {
		this.payTermCd =	payTermCd;
	}
 	/**
	 * Column Info
	 * @param  bkgMstHblTpCd
 	 */
	public void	setBkgMstHblTpCd(String bkgMstHblTpCd ) {
		this.bkgMstHblTpCd =	bkgMstHblTpCd;
	}
 	/**
	 * Column Info
	 * @param  convCmdtTpCd
 	 */
	public void	setConvCmdtTpCd(String convCmdtTpCd ) {
		this.convCmdtTpCd =	convCmdtTpCd;
	}
 	/**
	 * Column Info
	 * @param  noteConvSeq
 	 */
	public void	setNoteConvSeq(String noteConvSeq ) {
		this.noteConvSeq =	noteConvSeq;
	}
 	/**
	 * Column Info
	 * @param  rtApplTpCd
 	 */
	public void	setRtApplTpCd(String rtApplTpCd ) {
		this.rtApplTpCd =	rtApplTpCd;
	}
 	/**
	 * Column Info
	 * @param  convRatUtCd
 	 */
	public void	setConvRatUtCd(String convRatUtCd ) {
		this.convRatUtCd =	convRatUtCd;
	}
 	/**
	 * Column Info
	 * @param  convDestLocCntCd
 	 */
	public void	setConvDestLocCntCd(String convDestLocCntCd ) {
		this.convDestLocCntCd =	convDestLocCntCd;
	}
 	/**
	 * Column Info
	 * @param  bkgDelTpCd
 	 */
	public void	setBkgDelTpCd(String bkgDelTpCd ) {
		this.bkgDelTpCd =	bkgDelTpCd;
	}
 	/**
	 * Column Info
	 * @param  bkgSocFlg
 	 */
	public void	setBkgSocFlg(String bkgSocFlg ) {
		this.bkgSocFlg =	bkgSocFlg;
	}
 	/**
	 * Column Info
	 * @param  effDt
 	 */
	public void	setEffDt(String effDt ) {
		this.effDt =	effDt;
	}
 	/**
	 * Column Info
	 * @param  bkgTsPortTpCd
 	 */
	public void	setBkgTsPortTpCd(String bkgTsPortTpCd ) {
		this.bkgTsPortTpCd =	bkgTsPortTpCd;
	}
 	/**
	 * Column Info
	 * @param  convDestLocTpCd
 	 */
	public void	setConvDestLocTpCd(String convDestLocTpCd ) {
		this.convDestLocTpCd =	convDestLocTpCd;
	}
 	/**
	 * Column Info
	 * @param  bkgTsPortDefCd
 	 */
	public void	setBkgTsPortDefCd(String bkgTsPortDefCd ) {
		this.bkgTsPortDefCd =	bkgTsPortDefCd;
	}
 	/**
	 * Column Info
	 * @param  bkgCmdtDefCd
 	 */
	public void	setBkgCmdtDefCd(String bkgCmdtDefCd ) {
		this.bkgCmdtDefCd =	bkgCmdtDefCd;
	}
 	/**
	 * Column Info
	 * @param  genSpclRtTpCd
 	 */
	public void	setGenSpclRtTpCd(String genSpclRtTpCd ) {
		this.genSpclRtTpCd =	genSpclRtTpCd;
	}
 	/**
	 * Column Info
	 * @param  bkgOrgTrspModCd
 	 */
	public void	setBkgOrgTrspModCd(String bkgOrgTrspModCd ) {
		this.bkgOrgTrspModCd =	bkgOrgTrspModCd;
	}
 	/**
	 * Column Info
	 * @param  bkgPodTpCd
 	 */
	public void	setBkgPodTpCd(String bkgPodTpCd ) {
		this.bkgPodTpCd =	bkgPodTpCd;
	}
 	/**
	 * Column Info
	 * @param  convDestViaLocCntCd
 	 */
	public void	setConvDestViaLocCntCd(String convDestViaLocCntCd ) {
		this.convDestViaLocCntCd =	convDestViaLocCntCd;
	}
 	/**
	 * Column Info
	 * @param  convOrgViaLocTpCd
 	 */
	public void	setConvOrgViaLocTpCd(String convOrgViaLocTpCd ) {
		this.convOrgViaLocTpCd =	convOrgViaLocTpCd;
	}
 	/**
	 * Column Info
	 * @param  bkgCmdtTpCd
 	 */
	public void	setBkgCmdtTpCd(String bkgCmdtTpCd ) {
		this.bkgCmdtTpCd =	bkgCmdtTpCd;
	}
 	/**
	 * Column Info
	 * @param  updUsrId
 	 */
	public void	setUpdUsrId(String updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 	/**
	 * Column Info
	 * @param  bkgIoGaCd
 	 */
	public void	setBkgIoGaCd(String bkgIoGaCd ) {
		this.bkgIoGaCd =	bkgIoGaCd;
	}
 	/**
	 * Column Info
	 * @param  rtOpCd
 	 */
	public void	setRtOpCd(String rtOpCd ) {
		this.rtOpCd =	rtOpCd;
	}
 	/**
	 * Column Info
	 * @param  bkgActCustCntCd
 	 */
	public void	setBkgActCustCntCd(String bkgActCustCntCd ) {
		this.bkgActCustCntCd =	bkgActCustCntCd;
	}
 	/**
	 * Column Info
	 * @param  convCmdtDefCd
 	 */
	public void	setConvCmdtDefCd(String convCmdtDefCd ) {
		this.convCmdtDefCd =	convCmdtDefCd;
	}
 	/**
	 * Column Info
	 * @param  noteConvMapgId
 	 */
	public void	setNoteConvMapgId(String noteConvMapgId ) {
		this.noteConvMapgId =	noteConvMapgId;
	}
 	/**
	 * Column Info
	 * @param  bkgPolDefCd
 	 */
	public void	setBkgPolDefCd(String bkgPolDefCd ) {
		this.bkgPolDefCd =	bkgPolDefCd;
	}
 	/**
	 * Column Info
	 * @param  chgRuleTpCd
 	 */
	public void	setChgRuleTpCd(String chgRuleTpCd ) {
		this.chgRuleTpCd =	chgRuleTpCd;
	}
 	/**
	 * Column Info
	 * @param  creUsrId
 	 */
	public void	setCreUsrId(String creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 	/**
	 * Column Info
	 * @param  convPrcCgoTpCd
 	 */
	public void	setConvPrcCgoTpCd(String convPrcCgoTpCd ) {
		this.convPrcCgoTpCd =	convPrcCgoTpCd;
	}
 	/**
	 * Column Info
	 * @param  convPrcDeTermCd
 	 */
	public void	setConvPrcDeTermCd(String convPrcDeTermCd ) {
		this.convPrcDeTermCd =	convPrcDeTermCd;
	}
 	/**
	 * Column Info
	 * @param  convOrgViaLocCntCd
 	 */
	public void	setConvOrgViaLocCntCd(String convOrgViaLocCntCd ) {
		this.convOrgViaLocCntCd =	convOrgViaLocCntCd;
	}
 	/**
	 * Column Info
	 * @param  bkgRatUtCd
 	 */
	public void	setBkgRatUtCd(String bkgRatUtCd ) {
		this.bkgRatUtCd =	bkgRatUtCd;
	}
 	/**
	 * Column Info
	 * @param  bkgCnlTzCd
 	 */
	public void	setBkgCnlTzCd(String bkgCnlTzCd ) {
		this.bkgCnlTzCd =	bkgCnlTzCd;
	}
 	/**
	 * Column Info
	 * @param  bkgDelDefCd
 	 */
	public void	setBkgDelDefCd(String bkgDelDefCd ) {
		this.bkgDelDefCd =	bkgDelDefCd;
	}
 	/**
	 * Column Info
	 * @param  convDestLocDefCd
 	 */
	public void	setConvDestLocDefCd(String convDestLocDefCd ) {
		this.convDestLocDefCd =	convDestLocDefCd;
	}
 	/**
	 * Column Info
	 * @param  bkgUsaSvcModCd
 	 */
	public void	setBkgUsaSvcModCd(String bkgUsaSvcModCd ) {
		this.bkgUsaSvcModCd =	bkgUsaSvcModCd;
	}
 	/**
	 * Column Info
	 * @param  bkgImdgClssCd
 	 */
	public void	setBkgImdgClssCd(String bkgImdgClssCd ) {
		this.bkgImdgClssCd =	bkgImdgClssCd;
	}
 	/**
	 * Column Info
	 * @param  convDestViaLocTpCd
 	 */
	public void	setConvDestViaLocTpCd(String convDestViaLocTpCd ) {
		this.convDestViaLocTpCd =	convDestViaLocTpCd;
	}
 	/**
	 * Column Info
	 * @param  currCd
 	 */
	public void	setCurrCd(String currCd ) {
		this.currCd =	currCd;
	}
 	/**
	 * Column Info
	 * @param  convOrgViaLocDefCd
 	 */
	public void	setConvOrgViaLocDefCd(String convOrgViaLocDefCd ) {
		this.convOrgViaLocDefCd =	convOrgViaLocDefCd;
	}
 	/**
	 * Column Info
	 * @param  bkgPrcCgoTpCd
 	 */
	public void	setBkgPrcCgoTpCd(String bkgPrcCgoTpCd ) {
		this.bkgPrcCgoTpCd =	bkgPrcCgoTpCd;
	}
 	/**
	 * Column Info
	 * @param  creDt
 	 */
	public void	setCreDt(String creDt ) {
		this.creDt =	creDt;
	}
 	/**
	 * Column Info
	 * @param  convPrcRcvTermCd
 	 */
	public void	setConvPrcRcvTermCd(String convPrcRcvTermCd ) {
		this.convPrcRcvTermCd =	convPrcRcvTermCd;
	}
 	/**
	 * Column Info
	 * @param  bkgRcvTermCd
 	 */
	public void	setBkgRcvTermCd(String bkgRcvTermCd ) {
		this.bkgRcvTermCd =	bkgRcvTermCd;
	}
 	/**
	 * Column Info
	 * @param  bkgDestTrspModCd
 	 */
	public void	setBkgDestTrspModCd(String bkgDestTrspModCd ) {
		this.bkgDestTrspModCd =	bkgDestTrspModCd;
	}
 	/**
	 * Column Info
	 * @param  bkgDirCallFlg
 	 */
	public void	setBkgDirCallFlg(String bkgDirCallFlg ) {
		this.bkgDirCallFlg =	bkgDirCallFlg;
	}
 	/**
	 * Column Info
	 * @param  bkgDelCntCd
 	 */
	public void	setBkgDelCntCd(String bkgDelCntCd ) {
		this.bkgDelCntCd =	bkgDelCntCd;
	}
 	/**
	 * Column Info
	 * @param  usrId
 	 */
	public void	setUsrId(String usrId ) {
		this.usrId =	usrId;
	}
 	/**
	 * Column Info
	 * @param  noteHdrSeq
 	 */
	public void	setNoteHdrSeq(String noteHdrSeq ) {
		this.noteHdrSeq =	noteHdrSeq;
	}
 	/**
	 * Column Info
	 * @param  convOrgLocDefCd
 	 */
	public void	setConvOrgLocDefCd(String convOrgLocDefCd ) {
		this.convOrgLocDefCd =	convOrgLocDefCd;
	}
 	/**
	 * Column Info
	 * @param  bkgSlanCd
 	 */
	public void	setBkgSlanCd(String bkgSlanCd ) {
		this.bkgSlanCd =	bkgSlanCd;
	}
 	/**
	 * Column Info
	 * @param  bkgPolCntCd
 	 */
	public void	setBkgPolCntCd(String bkgPolCntCd ) {
		this.bkgPolCntCd =	bkgPolCntCd;
	}
 	/**
	 * Column Info
	 * @param  expDt
 	 */
	public void	setExpDt(String expDt ) {
		this.expDt =	expDt;
	}
 	/**
	 * Column Info
	 * @param  bkgPolTpCd
 	 */
	public void	setBkgPolTpCd(String bkgPolTpCd ) {
		this.bkgPolTpCd =	bkgPolTpCd;
	}
 	/**
	 * Column Info
	 * @param  noteConvTpCd
 	 */
	public void	setNoteConvTpCd(String noteConvTpCd ) {
		this.noteConvTpCd =	noteConvTpCd;
	}
 	/**
	 * Column Info
	 * @param  ruleApplChgTpCd
 	 */
	public void	setRuleApplChgTpCd(String ruleApplChgTpCd ) {
		this.ruleApplChgTpCd =	ruleApplChgTpCd;
	}
 	/**
	 * Column Info
	 * @param  updDt
 	 */
	public void	setUpdDt(String updDt ) {
		this.updDt =	updDt;
	}
 	/**
	 * Column Info
	 * @param  bkgSkdDirCd
 	 */
	public void	setBkgSkdDirCd(String bkgSkdDirCd ) {
		this.bkgSkdDirCd =	bkgSkdDirCd;
	}
 	/**
	 * Column Info
	 * @param  noteConvRuleCd
 	 */
	public void	setNoteConvRuleCd(String noteConvRuleCd ) {
		this.noteConvRuleCd =	noteConvRuleCd;
	}
 	/**
	 * Column Info
	 * @param  bkgPorTpCd
 	 */
	public void	setBkgPorTpCd(String bkgPorTpCd ) {
		this.bkgPorTpCd =	bkgPorTpCd;
	}
 	/**
	 * Column Info
	 * @param  bkgPodDefCd
 	 */
	public void	setBkgPodDefCd(String bkgPodDefCd ) {
		this.bkgPodDefCd =	bkgPodDefCd;
	}
 	/**
	 * Column Info
	 * @param  bkgScgGrpCmdtCd
 	 */
	public void	setBkgScgGrpCmdtCd(String bkgScgGrpCmdtCd ) {
		this.bkgScgGrpCmdtCd =	bkgScgGrpCmdtCd;
	}
 	/**
	 * Column Info
	 * @param  noteConvChgCd
 	 */
	public void	setNoteConvChgCd(String noteConvChgCd ) {
		this.noteConvChgCd =	noteConvChgCd;
	}
 	/**
	 * Column Info
	 * @param  convOrgLocTpCd
 	 */
	public void	setConvOrgLocTpCd(String convOrgLocTpCd ) {
		this.convOrgLocTpCd =	convOrgLocTpCd;
	}
 	/**
	 * Column Info
	 * @param  bkgPorDefCd
 	 */
	public void	setBkgPorDefCd(String bkgPorDefCd ) {
		this.bkgPorDefCd =	bkgPorDefCd;
	}
 	/**
	 * Column Info
	 * @param  bkgSkdVoyNo
 	 */
	public void	setBkgSkdVoyNo(String bkgSkdVoyNo ) {
		this.bkgSkdVoyNo =	bkgSkdVoyNo;
	}
 	/**
	 * Column Info
	 * @param  bkgActCustSeq
 	 */
	public void	setBkgActCustSeq(String bkgActCustSeq ) {
		this.bkgActCustSeq =	bkgActCustSeq;
	}
 	/**
	 * Column Info
	 * @param  bkgEsvcTpCd
 	 */
	public void	setBkgEsvcTpCd(String bkgEsvcTpCd ) {
		this.bkgEsvcTpCd =	bkgEsvcTpCd;
	}
 	/**
	 * Column Info
	 * @param  convOrgLocCntCd
 	 */
	public void	setConvOrgLocCntCd(String convOrgLocCntCd ) {
		this.convOrgLocCntCd =	convOrgLocCntCd;
	}
 	/**
	 * Column Info
	 * @param  propNo
 	 */
	public void	setPropNo(String propNo ) {
		this.propNo =	propNo;
	}
 	/**
	 * Column Info
	 * @param  frtRtAmt
 	 */
	public void	setFrtRtAmt(String frtRtAmt ) {
		this.frtRtAmt =	frtRtAmt;
	}
 	/**
	 * Column Info
	 * @param  convDestViaLocDefCd
 	 */
	public void	setConvDestViaLocDefCd(String convDestViaLocDefCd ) {
		this.convDestViaLocDefCd =	convDestViaLocDefCd;
	}
 	/**
	 * Column Info
	 * @param  bkgPorCntCd
 	 */
	public void	setBkgPorCntCd(String bkgPorCntCd ) {
		this.bkgPorCntCd =	bkgPorCntCd;
	}
 	/**
	 * Column Info
	 * @param  bkgPodCntCd
 	 */
	public void	setBkgPodCntCd(String bkgPodCntCd ) {
		this.bkgPodCntCd =	bkgPodCntCd;
	}
 	/**
	 * Column Info
	 * @param  bkgVslCd
 	 */
	public void	setBkgVslCd(String bkgVslCd ) {
		this.bkgVslCd =	bkgVslCd;
	}
 	/**
	 * Column Info
	 * @param  bkgDeTermCd
 	 */
	public void	setBkgDeTermCd(String bkgDeTermCd ) {
		this.bkgDeTermCd =	bkgDeTermCd;
	}
 	/**
	 * Column Info
	 * @param  bkgMinCgoWgt
 	 */
	public void	setBkgMinCgoWgt(String bkgMinCgoWgt ) {
		this.bkgMinCgoWgt =	bkgMinCgoWgt;
	}
 	/**
	 * Column Info
	 * @param  bkgMaxCgoWgt
 	 */
	public void	setBkgMaxCgoWgt(String bkgMaxCgoWgt ) {
		this.bkgMaxCgoWgt =	bkgMaxCgoWgt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAmdtSeq(JSPUtil.getParameter(request,	prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setPayTermCd(JSPUtil.getParameter(request,	prefix + "pay_term_cd", ""));
		setBkgMstHblTpCd(JSPUtil.getParameter(request,	prefix + "bkg_mst_hbl_tp_cd", ""));
		setConvCmdtTpCd(JSPUtil.getParameter(request,	prefix + "conv_cmdt_tp_cd", ""));
		setNoteConvSeq(JSPUtil.getParameter(request,	prefix + "note_conv_seq", ""));
		setRtApplTpCd(JSPUtil.getParameter(request,	prefix + "rt_appl_tp_cd", ""));
		setConvRatUtCd(JSPUtil.getParameter(request,	prefix + "conv_rat_ut_cd", ""));
		setConvDestLocCntCd(JSPUtil.getParameter(request,	prefix + "conv_dest_loc_cnt_cd", ""));
		setBkgDelTpCd(JSPUtil.getParameter(request,	prefix + "bkg_del_tp_cd", ""));
		setBkgSocFlg(JSPUtil.getParameter(request,	prefix + "bkg_soc_flg", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setBkgTsPortTpCd(JSPUtil.getParameter(request,	prefix + "bkg_ts_port_tp_cd", ""));
		setConvDestLocTpCd(JSPUtil.getParameter(request,	prefix + "conv_dest_loc_tp_cd", ""));
		setBkgTsPortDefCd(JSPUtil.getParameter(request,	prefix + "bkg_ts_port_def_cd", ""));
		setBkgCmdtDefCd(JSPUtil.getParameter(request,	prefix + "bkg_cmdt_def_cd", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request,	prefix + "gen_spcl_rt_tp_cd", ""));
		setBkgOrgTrspModCd(JSPUtil.getParameter(request,	prefix + "bkg_org_trsp_mod_cd", ""));
		setBkgPodTpCd(JSPUtil.getParameter(request,	prefix + "bkg_pod_tp_cd", ""));
		setConvDestViaLocCntCd(JSPUtil.getParameter(request,	prefix + "conv_dest_via_loc_cnt_cd", ""));
		setConvOrgViaLocTpCd(JSPUtil.getParameter(request,	prefix + "conv_org_via_loc_tp_cd", ""));
		setBkgCmdtTpCd(JSPUtil.getParameter(request,	prefix + "bkg_cmdt_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setBkgIoGaCd(JSPUtil.getParameter(request,	prefix + "bkg_io_ga_cd", ""));
		setRtOpCd(JSPUtil.getParameter(request,	prefix + "rt_op_cd", ""));
		setBkgActCustCntCd(JSPUtil.getParameter(request,	prefix + "bkg_act_cust_cnt_cd", ""));
		setConvCmdtDefCd(JSPUtil.getParameter(request,	prefix + "conv_cmdt_def_cd", ""));
		setNoteConvMapgId(JSPUtil.getParameter(request,	prefix + "note_conv_mapg_id", ""));
		setBkgPolDefCd(JSPUtil.getParameter(request,	prefix + "bkg_pol_def_cd", ""));
		setChgRuleTpCd(JSPUtil.getParameter(request,	prefix + "chg_rule_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setConvPrcCgoTpCd(JSPUtil.getParameter(request,	prefix + "conv_prc_cgo_tp_cd", ""));
		setConvPrcDeTermCd(JSPUtil.getParameter(request,	prefix + "conv_prc_de_term_cd", ""));
		setConvOrgViaLocCntCd(JSPUtil.getParameter(request,	prefix + "conv_org_via_loc_cnt_cd", ""));
		setBkgRatUtCd(JSPUtil.getParameter(request,	prefix + "bkg_rat_ut_cd", ""));
		setBkgCnlTzCd(JSPUtil.getParameter(request,	prefix + "bkg_cnl_tz_cd", ""));
		setBkgDelDefCd(JSPUtil.getParameter(request,	prefix + "bkg_del_def_cd", ""));
		setConvDestLocDefCd(JSPUtil.getParameter(request,	prefix + "conv_dest_loc_def_cd", ""));
		setBkgUsaSvcModCd(JSPUtil.getParameter(request,	prefix + "bkg_usa_svc_mod_cd", ""));
		setBkgImdgClssCd(JSPUtil.getParameter(request,	prefix + "bkg_imdg_clss_cd", ""));
		setConvDestViaLocTpCd(JSPUtil.getParameter(request,	prefix + "conv_dest_via_loc_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setConvOrgViaLocDefCd(JSPUtil.getParameter(request,	prefix + "conv_org_via_loc_def_cd", ""));
		setBkgPrcCgoTpCd(JSPUtil.getParameter(request,	prefix + "bkg_prc_cgo_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setConvPrcRcvTermCd(JSPUtil.getParameter(request,	prefix + "conv_prc_rcv_term_cd", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request,	prefix + "bkg_rcv_term_cd", ""));
		setBkgDestTrspModCd(JSPUtil.getParameter(request,	prefix + "bkg_dest_trsp_mod_cd", ""));
		setBkgDirCallFlg(JSPUtil.getParameter(request,	prefix + "bkg_dir_call_flg", ""));
		setBkgDelCntCd(JSPUtil.getParameter(request,	prefix + "bkg_del_cnt_cd", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setNoteHdrSeq(JSPUtil.getParameter(request,	prefix + "note_hdr_seq", ""));
		setConvOrgLocDefCd(JSPUtil.getParameter(request,	prefix + "conv_org_loc_def_cd", ""));
		setBkgSlanCd(JSPUtil.getParameter(request,	prefix + "bkg_slan_cd", ""));
		setBkgPolCntCd(JSPUtil.getParameter(request,	prefix + "bkg_pol_cnt_cd", ""));
		setExpDt(JSPUtil.getParameter(request,	prefix + "exp_dt", ""));
		setBkgPolTpCd(JSPUtil.getParameter(request,	prefix + "bkg_pol_tp_cd", ""));
		setNoteConvTpCd(JSPUtil.getParameter(request,	prefix + "note_conv_tp_cd", ""));
		setRuleApplChgTpCd(JSPUtil.getParameter(request,	prefix + "rule_appl_chg_tp_cd", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setBkgSkdDirCd(JSPUtil.getParameter(request,	prefix + "bkg_skd_dir_cd", ""));
		setNoteConvRuleCd(JSPUtil.getParameter(request,	prefix + "note_conv_rule_cd", ""));
		setBkgPorTpCd(JSPUtil.getParameter(request,	prefix + "bkg_por_tp_cd", ""));
		setBkgPodDefCd(JSPUtil.getParameter(request,	prefix + "bkg_pod_def_cd", ""));
		setBkgScgGrpCmdtCd(JSPUtil.getParameter(request,	prefix + "bkg_scg_grp_cmdt_cd", ""));
		setNoteConvChgCd(JSPUtil.getParameter(request,	prefix + "note_conv_chg_cd", ""));
		setConvOrgLocTpCd(JSPUtil.getParameter(request,	prefix + "conv_org_loc_tp_cd", ""));
		setBkgPorDefCd(JSPUtil.getParameter(request,	prefix + "bkg_por_def_cd", ""));
		setBkgSkdVoyNo(JSPUtil.getParameter(request,	prefix + "bkg_skd_voy_no", ""));
		setBkgActCustSeq(JSPUtil.getParameter(request,	prefix + "bkg_act_cust_seq", ""));
		setBkgEsvcTpCd(JSPUtil.getParameter(request,	prefix + "bkg_esvc_tp_cd", ""));
		setConvOrgLocCntCd(JSPUtil.getParameter(request,	prefix + "conv_org_loc_cnt_cd", ""));
		setPropNo(JSPUtil.getParameter(request,	prefix + "prop_no", ""));
		setFrtRtAmt(JSPUtil.getParameter(request,	prefix + "frt_rt_amt", ""));
		setConvDestViaLocDefCd(JSPUtil.getParameter(request,	prefix + "conv_dest_via_loc_def_cd", ""));
		setBkgPorCntCd(JSPUtil.getParameter(request,	prefix + "bkg_por_cnt_cd", ""));
		setBkgPodCntCd(JSPUtil.getParameter(request,	prefix + "bkg_pod_cnt_cd", ""));
		setBkgVslCd(JSPUtil.getParameter(request,	prefix + "bkg_vsl_cd", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request,	prefix + "bkg_de_term_cd", ""));
		setBkgMinCgoWgt(JSPUtil.getParameter(request,	prefix + "bkg_min_cgo_wgt", ""));
		setBkgMaxCgoWgt(JSPUtil.getParameter(request,	prefix + "bkg_max_cgo_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriScNoteConvListVO[]
	 */
	public PriScNoteConvListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PriScNoteConvListVO[]
	 */
	public PriScNoteConvListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PriScNoteConvListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] amdtSeq =	(JSPUtil.getParameter(request, prefix +	"amdt_seq",	length));
			String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd",	length));
			String[] payTermCd =	(JSPUtil.getParameter(request, prefix +	"pay_term_cd",	length));
			String[] bkgMstHblTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_mst_hbl_tp_cd",	length));
			String[] convCmdtTpCd =	(JSPUtil.getParameter(request, prefix +	"conv_cmdt_tp_cd",	length));
			String[] noteConvSeq =	(JSPUtil.getParameter(request, prefix +	"note_conv_seq",	length));
			String[] rtApplTpCd =	(JSPUtil.getParameter(request, prefix +	"rt_appl_tp_cd",	length));
			String[] convRatUtCd =	(JSPUtil.getParameter(request, prefix +	"conv_rat_ut_cd",	length));
			String[] convDestLocCntCd =	(JSPUtil.getParameter(request, prefix +	"conv_dest_loc_cnt_cd",	length));
			String[] bkgDelTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_del_tp_cd",	length));
			String[] bkgSocFlg =	(JSPUtil.getParameter(request, prefix +	"bkg_soc_flg",	length));
			String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt",	length));
			String[] bkgTsPortTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_ts_port_tp_cd",	length));
			String[] convDestLocTpCd =	(JSPUtil.getParameter(request, prefix +	"conv_dest_loc_tp_cd",	length));
			String[] bkgTsPortDefCd =	(JSPUtil.getParameter(request, prefix +	"bkg_ts_port_def_cd",	length));
			String[] bkgCmdtDefCd =	(JSPUtil.getParameter(request, prefix +	"bkg_cmdt_def_cd",	length));
			String[] genSpclRtTpCd =	(JSPUtil.getParameter(request, prefix +	"gen_spcl_rt_tp_cd",	length));
			String[] bkgOrgTrspModCd =	(JSPUtil.getParameter(request, prefix +	"bkg_org_trsp_mod_cd",	length));
			String[] bkgPodTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_pod_tp_cd",	length));
			String[] convDestViaLocCntCd =	(JSPUtil.getParameter(request, prefix +	"conv_dest_via_loc_cnt_cd",	length));
			String[] convOrgViaLocTpCd =	(JSPUtil.getParameter(request, prefix +	"conv_org_via_loc_tp_cd",	length));
			String[] bkgCmdtTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_cmdt_tp_cd",	length));
			String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id",	length));
			String[] bkgIoGaCd =	(JSPUtil.getParameter(request, prefix +	"bkg_io_ga_cd",	length));
			String[] rtOpCd =	(JSPUtil.getParameter(request, prefix +	"rt_op_cd",	length));
			String[] bkgActCustCntCd =	(JSPUtil.getParameter(request, prefix +	"bkg_act_cust_cnt_cd",	length));
			String[] convCmdtDefCd =	(JSPUtil.getParameter(request, prefix +	"conv_cmdt_def_cd",	length));
			String[] noteConvMapgId =	(JSPUtil.getParameter(request, prefix +	"note_conv_mapg_id",	length));
			String[] bkgPolDefCd =	(JSPUtil.getParameter(request, prefix +	"bkg_pol_def_cd",	length));
			String[] chgRuleTpCd =	(JSPUtil.getParameter(request, prefix +	"chg_rule_tp_cd",	length));
			String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id",	length));
			String[] convPrcCgoTpCd =	(JSPUtil.getParameter(request, prefix +	"conv_prc_cgo_tp_cd",	length));
			String[] convPrcDeTermCd =	(JSPUtil.getParameter(request, prefix +	"conv_prc_de_term_cd",	length));
			String[] convOrgViaLocCntCd =	(JSPUtil.getParameter(request, prefix +	"conv_org_via_loc_cnt_cd",	length));
			String[] bkgRatUtCd =	(JSPUtil.getParameter(request, prefix +	"bkg_rat_ut_cd",	length));
			String[] bkgCnlTzCd =	(JSPUtil.getParameter(request, prefix +	"bkg_cnl_tz_cd",	length));
			String[] bkgDelDefCd =	(JSPUtil.getParameter(request, prefix +	"bkg_del_def_cd",	length));
			String[] convDestLocDefCd =	(JSPUtil.getParameter(request, prefix +	"conv_dest_loc_def_cd",	length));
			String[] bkgUsaSvcModCd =	(JSPUtil.getParameter(request, prefix +	"bkg_usa_svc_mod_cd",	length));
			String[] bkgImdgClssCd =	(JSPUtil.getParameter(request, prefix +	"bkg_imdg_clss_cd",	length));
			String[] convDestViaLocTpCd =	(JSPUtil.getParameter(request, prefix +	"conv_dest_via_loc_tp_cd",	length));
			String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd",	length));
			String[] convOrgViaLocDefCd =	(JSPUtil.getParameter(request, prefix +	"conv_org_via_loc_def_cd",	length));
			String[] bkgPrcCgoTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_prc_cgo_tp_cd",	length));
			String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt",	length));
			String[] convPrcRcvTermCd =	(JSPUtil.getParameter(request, prefix +	"conv_prc_rcv_term_cd",	length));
			String[] bkgRcvTermCd =	(JSPUtil.getParameter(request, prefix +	"bkg_rcv_term_cd",	length));
			String[] bkgDestTrspModCd =	(JSPUtil.getParameter(request, prefix +	"bkg_dest_trsp_mod_cd",	length));
			String[] bkgDirCallFlg =	(JSPUtil.getParameter(request, prefix +	"bkg_dir_call_flg",	length));
			String[] bkgDelCntCd =	(JSPUtil.getParameter(request, prefix +	"bkg_del_cnt_cd",	length));
			String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id",	length));
			String[] noteHdrSeq =	(JSPUtil.getParameter(request, prefix +	"note_hdr_seq",	length));
			String[] convOrgLocDefCd =	(JSPUtil.getParameter(request, prefix +	"conv_org_loc_def_cd",	length));
			String[] bkgSlanCd =	(JSPUtil.getParameter(request, prefix +	"bkg_slan_cd",	length));
			String[] bkgPolCntCd =	(JSPUtil.getParameter(request, prefix +	"bkg_pol_cnt_cd",	length));
			String[] expDt =	(JSPUtil.getParameter(request, prefix +	"exp_dt",	length));
			String[] bkgPolTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_pol_tp_cd",	length));
			String[] noteConvTpCd =	(JSPUtil.getParameter(request, prefix +	"note_conv_tp_cd",	length));
			String[] ruleApplChgTpCd =	(JSPUtil.getParameter(request, prefix +	"rule_appl_chg_tp_cd",	length));
			String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt",	length));
			String[] bkgSkdDirCd =	(JSPUtil.getParameter(request, prefix +	"bkg_skd_dir_cd",	length));
			String[] noteConvRuleCd =	(JSPUtil.getParameter(request, prefix +	"note_conv_rule_cd",	length));
			String[] bkgPorTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_por_tp_cd",	length));
			String[] bkgPodDefCd =	(JSPUtil.getParameter(request, prefix +	"bkg_pod_def_cd",	length));
			String[] bkgScgGrpCmdtCd =	(JSPUtil.getParameter(request, prefix +	"bkg_scg_grp_cmdt_cd",	length));
			String[] noteConvChgCd =	(JSPUtil.getParameter(request, prefix +	"note_conv_chg_cd",	length));
			String[] convOrgLocTpCd =	(JSPUtil.getParameter(request, prefix +	"conv_org_loc_tp_cd",	length));
			String[] bkgPorDefCd =	(JSPUtil.getParameter(request, prefix +	"bkg_por_def_cd",	length));
			String[] bkgSkdVoyNo =	(JSPUtil.getParameter(request, prefix +	"bkg_skd_voy_no",	length));
			String[] bkgActCustSeq =	(JSPUtil.getParameter(request, prefix +	"bkg_act_cust_seq",	length));
			String[] bkgEsvcTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_esvc_tp_cd",	length));
			String[] convOrgLocCntCd =	(JSPUtil.getParameter(request, prefix +	"conv_org_loc_cnt_cd",	length));
			String[] propNo =	(JSPUtil.getParameter(request, prefix +	"prop_no",	length));
			String[] frtRtAmt =	(JSPUtil.getParameter(request, prefix +	"frt_rt_amt",	length));
			String[] convDestViaLocDefCd =	(JSPUtil.getParameter(request, prefix +	"conv_dest_via_loc_def_cd",	length));
			String[] bkgPorCntCd =	(JSPUtil.getParameter(request, prefix +	"bkg_por_cnt_cd",	length));
			String[] bkgPodCntCd =	(JSPUtil.getParameter(request, prefix +	"bkg_pod_cnt_cd",	length));
			String[] bkgVslCd =	(JSPUtil.getParameter(request, prefix +	"bkg_vsl_cd",	length));
			String[] bkgDeTermCd =	(JSPUtil.getParameter(request, prefix +	"bkg_de_term_cd",	length));
			String[] bkgMinCgoWgt =	(JSPUtil.getParameter(request, prefix +	"bkg_min_cgo_wgt",	length));
			String[] bkgMaxCgoWgt =	(JSPUtil.getParameter(request, prefix +	"bkg_max_cgo_wgt",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	PriScNoteConvListVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( amdtSeq[i] !=	null)
					model.setAmdtSeq( amdtSeq[i]);
				if ( svcScpCd[i] !=	null)
					model.setSvcScpCd( svcScpCd[i]);
				if ( payTermCd[i] !=	null)
					model.setPayTermCd( payTermCd[i]);
				if ( bkgMstHblTpCd[i] !=	null)
					model.setBkgMstHblTpCd( bkgMstHblTpCd[i]);
				if ( convCmdtTpCd[i] !=	null)
					model.setConvCmdtTpCd( convCmdtTpCd[i]);
				if ( noteConvSeq[i] !=	null)
					model.setNoteConvSeq( noteConvSeq[i]);
				if ( rtApplTpCd[i] !=	null)
					model.setRtApplTpCd( rtApplTpCd[i]);
				if ( convRatUtCd[i] !=	null)
					model.setConvRatUtCd( convRatUtCd[i]);
				if ( convDestLocCntCd[i] !=	null)
					model.setConvDestLocCntCd( convDestLocCntCd[i]);
				if ( bkgDelTpCd[i] !=	null)
					model.setBkgDelTpCd( bkgDelTpCd[i]);
				if ( bkgSocFlg[i] !=	null)
					model.setBkgSocFlg( bkgSocFlg[i]);
				if ( effDt[i] !=	null)
					model.setEffDt( effDt[i]);
				if ( bkgTsPortTpCd[i] !=	null)
					model.setBkgTsPortTpCd( bkgTsPortTpCd[i]);
				if ( convDestLocTpCd[i] !=	null)
					model.setConvDestLocTpCd( convDestLocTpCd[i]);
				if ( bkgTsPortDefCd[i] !=	null)
					model.setBkgTsPortDefCd( bkgTsPortDefCd[i]);
				if ( bkgCmdtDefCd[i] !=	null)
					model.setBkgCmdtDefCd( bkgCmdtDefCd[i]);
				if ( genSpclRtTpCd[i] !=	null)
					model.setGenSpclRtTpCd( genSpclRtTpCd[i]);
				if ( bkgOrgTrspModCd[i] !=	null)
					model.setBkgOrgTrspModCd( bkgOrgTrspModCd[i]);
				if ( bkgPodTpCd[i] !=	null)
					model.setBkgPodTpCd( bkgPodTpCd[i]);
				if ( convDestViaLocCntCd[i] !=	null)
					model.setConvDestViaLocCntCd( convDestViaLocCntCd[i]);
				if ( convOrgViaLocTpCd[i] !=	null)
					model.setConvOrgViaLocTpCd( convOrgViaLocTpCd[i]);
				if ( bkgCmdtTpCd[i] !=	null)
					model.setBkgCmdtTpCd( bkgCmdtTpCd[i]);
				if ( updUsrId[i] !=	null)
					model.setUpdUsrId( updUsrId[i]);
				if ( bkgIoGaCd[i] !=	null)
					model.setBkgIoGaCd( bkgIoGaCd[i]);
				if ( rtOpCd[i] !=	null)
					model.setRtOpCd( rtOpCd[i]);
				if ( bkgActCustCntCd[i] !=	null)
					model.setBkgActCustCntCd( bkgActCustCntCd[i]);
				if ( convCmdtDefCd[i] !=	null)
					model.setConvCmdtDefCd( convCmdtDefCd[i]);
				if ( noteConvMapgId[i] !=	null)
					model.setNoteConvMapgId( noteConvMapgId[i]);
				if ( bkgPolDefCd[i] !=	null)
					model.setBkgPolDefCd( bkgPolDefCd[i]);
				if ( chgRuleTpCd[i] !=	null)
					model.setChgRuleTpCd( chgRuleTpCd[i]);
				if ( creUsrId[i] !=	null)
					model.setCreUsrId( creUsrId[i]);
				if ( convPrcCgoTpCd[i] !=	null)
					model.setConvPrcCgoTpCd( convPrcCgoTpCd[i]);
				if ( convPrcDeTermCd[i] !=	null)
					model.setConvPrcDeTermCd( convPrcDeTermCd[i]);
				if ( convOrgViaLocCntCd[i] !=	null)
					model.setConvOrgViaLocCntCd( convOrgViaLocCntCd[i]);
				if ( bkgRatUtCd[i] !=	null)
					model.setBkgRatUtCd( bkgRatUtCd[i]);
				if ( bkgCnlTzCd[i] !=	null)
					model.setBkgCnlTzCd( bkgCnlTzCd[i]);
				if ( bkgDelDefCd[i] !=	null)
					model.setBkgDelDefCd( bkgDelDefCd[i]);
				if ( convDestLocDefCd[i] !=	null)
					model.setConvDestLocDefCd( convDestLocDefCd[i]);
				if ( bkgUsaSvcModCd[i] !=	null)
					model.setBkgUsaSvcModCd( bkgUsaSvcModCd[i]);
				if ( bkgImdgClssCd[i] !=	null)
					model.setBkgImdgClssCd( bkgImdgClssCd[i]);
				if ( convDestViaLocTpCd[i] !=	null)
					model.setConvDestViaLocTpCd( convDestViaLocTpCd[i]);
				if ( currCd[i] !=	null)
					model.setCurrCd( currCd[i]);
				if ( convOrgViaLocDefCd[i] !=	null)
					model.setConvOrgViaLocDefCd( convOrgViaLocDefCd[i]);
				if ( bkgPrcCgoTpCd[i] !=	null)
					model.setBkgPrcCgoTpCd( bkgPrcCgoTpCd[i]);
				if ( creDt[i] !=	null)
					model.setCreDt( creDt[i]);
				if ( convPrcRcvTermCd[i] !=	null)
					model.setConvPrcRcvTermCd( convPrcRcvTermCd[i]);
				if ( bkgRcvTermCd[i] !=	null)
					model.setBkgRcvTermCd( bkgRcvTermCd[i]);
				if ( bkgDestTrspModCd[i] !=	null)
					model.setBkgDestTrspModCd( bkgDestTrspModCd[i]);
				if ( bkgDirCallFlg[i] !=	null)
					model.setBkgDirCallFlg( bkgDirCallFlg[i]);
				if ( bkgDelCntCd[i] !=	null)
					model.setBkgDelCntCd( bkgDelCntCd[i]);
				if ( usrId[i] !=	null)
					model.setUsrId( usrId[i]);
				if ( noteHdrSeq[i] !=	null)
					model.setNoteHdrSeq( noteHdrSeq[i]);
				if ( convOrgLocDefCd[i] !=	null)
					model.setConvOrgLocDefCd( convOrgLocDefCd[i]);
				if ( bkgSlanCd[i] !=	null)
					model.setBkgSlanCd( bkgSlanCd[i]);
				if ( bkgPolCntCd[i] !=	null)
					model.setBkgPolCntCd( bkgPolCntCd[i]);
				if ( expDt[i] !=	null)
					model.setExpDt( expDt[i]);
				if ( bkgPolTpCd[i] !=	null)
					model.setBkgPolTpCd( bkgPolTpCd[i]);
				if ( noteConvTpCd[i] !=	null)
					model.setNoteConvTpCd( noteConvTpCd[i]);
				if ( ruleApplChgTpCd[i] !=	null)
					model.setRuleApplChgTpCd( ruleApplChgTpCd[i]);
				if ( updDt[i] !=	null)
					model.setUpdDt( updDt[i]);
				if ( bkgSkdDirCd[i] !=	null)
					model.setBkgSkdDirCd( bkgSkdDirCd[i]);
				if ( noteConvRuleCd[i] !=	null)
					model.setNoteConvRuleCd( noteConvRuleCd[i]);
				if ( bkgPorTpCd[i] !=	null)
					model.setBkgPorTpCd( bkgPorTpCd[i]);
				if ( bkgPodDefCd[i] !=	null)
					model.setBkgPodDefCd( bkgPodDefCd[i]);
				if ( bkgScgGrpCmdtCd[i] !=	null)
					model.setBkgScgGrpCmdtCd( bkgScgGrpCmdtCd[i]);
				if ( noteConvChgCd[i] !=	null)
					model.setNoteConvChgCd( noteConvChgCd[i]);
				if ( convOrgLocTpCd[i] !=	null)
					model.setConvOrgLocTpCd( convOrgLocTpCd[i]);
				if ( bkgPorDefCd[i] !=	null)
					model.setBkgPorDefCd( bkgPorDefCd[i]);
				if ( bkgSkdVoyNo[i] !=	null)
					model.setBkgSkdVoyNo( bkgSkdVoyNo[i]);
				if ( bkgActCustSeq[i] !=	null)
					model.setBkgActCustSeq( bkgActCustSeq[i]);
				if ( bkgEsvcTpCd[i] !=	null)
					model.setBkgEsvcTpCd( bkgEsvcTpCd[i]);
				if ( convOrgLocCntCd[i] !=	null)
					model.setConvOrgLocCntCd( convOrgLocCntCd[i]);
				if ( propNo[i] !=	null)
					model.setPropNo( propNo[i]);
				if ( frtRtAmt[i] !=	null)
					model.setFrtRtAmt( frtRtAmt[i]);
				if ( convDestViaLocDefCd[i] !=	null)
					model.setConvDestViaLocDefCd( convDestViaLocDefCd[i]);
				if ( bkgPorCntCd[i] !=	null)
					model.setBkgPorCntCd( bkgPorCntCd[i]);
				if ( bkgPodCntCd[i] !=	null)
					model.setBkgPodCntCd( bkgPodCntCd[i]);
				if ( bkgVslCd[i] !=	null)
					model.setBkgVslCd( bkgVslCd[i]);
				if ( bkgDeTermCd[i] !=	null)
					model.setBkgDeTermCd( bkgDeTermCd[i]);
				if ( bkgMinCgoWgt[i] !=	null)
					model.setBkgMinCgoWgt( bkgMinCgoWgt[i]);
				if ( bkgMaxCgoWgt[i] !=	null)
					model.setBkgMaxCgoWgt( bkgMaxCgoWgt[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getPriScNoteConvListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PriScNoteConvListVO[]
	 */
	public PriScNoteConvListVO[]	 getPriScNoteConvListVOs(){
		PriScNoteConvListVO[] vos = (PriScNoteConvListVO[])models.toArray(new	PriScNoteConvListVO[models.size()]);
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
	public void	unDataFormat(){
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq =	this.amdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermCd =	this.payTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMstHblTpCd =	this.bkgMstHblTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convCmdtTpCd =	this.convCmdtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvSeq =	this.noteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtApplTpCd =	this.rtApplTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convRatUtCd =	this.convRatUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDestLocCntCd =	this.convDestLocCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelTpCd =	this.bkgDelTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSocFlg =	this.bkgSocFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsPortTpCd =	this.bkgTsPortTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDestLocTpCd =	this.convDestLocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsPortDefCd =	this.bkgTsPortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCmdtDefCd =	this.bkgCmdtDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd =	this.genSpclRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOrgTrspModCd =	this.bkgOrgTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodTpCd =	this.bkgPodTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDestViaLocCntCd =	this.convDestViaLocCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convOrgViaLocTpCd =	this.convOrgViaLocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCmdtTpCd =	this.bkgCmdtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgIoGaCd =	this.bkgIoGaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtOpCd =	this.rtOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgActCustCntCd =	this.bkgActCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convCmdtDefCd =	this.convCmdtDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvMapgId =	this.noteConvMapgId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolDefCd =	this.bkgPolDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRuleTpCd =	this.chgRuleTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convPrcCgoTpCd =	this.convPrcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convPrcDeTermCd =	this.convPrcDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convOrgViaLocCntCd =	this.convOrgViaLocCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRatUtCd =	this.bkgRatUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCnlTzCd =	this.bkgCnlTzCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelDefCd =	this.bkgDelDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDestLocDefCd =	this.convDestLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgUsaSvcModCd =	this.bkgUsaSvcModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgImdgClssCd =	this.bkgImdgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDestViaLocTpCd =	this.convDestViaLocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convOrgViaLocDefCd =	this.convOrgViaLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPrcCgoTpCd =	this.bkgPrcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convPrcRcvTermCd =	this.convPrcRcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd =	this.bkgRcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDestTrspModCd =	this.bkgDestTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDirCallFlg =	this.bkgDirCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCntCd =	this.bkgDelCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteHdrSeq =	this.noteHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convOrgLocDefCd =	this.convOrgLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSlanCd =	this.bkgSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCntCd =	this.bkgPolCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt =	this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolTpCd =	this.bkgPolTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvTpCd =	this.noteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ruleApplChgTpCd =	this.ruleApplChgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSkdDirCd =	this.bkgSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvRuleCd =	this.noteConvRuleCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorTpCd =	this.bkgPorTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodDefCd =	this.bkgPodDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgScgGrpCmdtCd =	this.bkgScgGrpCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvChgCd =	this.noteConvChgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convOrgLocTpCd =	this.convOrgLocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorDefCd =	this.bkgPorDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSkdVoyNo =	this.bkgSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgActCustSeq =	this.bkgActCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgEsvcTpCd =	this.bkgEsvcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convOrgLocCntCd =	this.convOrgLocCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo =	this.propNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtRtAmt =	this.frtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDestViaLocDefCd =	this.convDestViaLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCntCd =	this.bkgPorCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCntCd =	this.bkgPodCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVslCd =	this.bkgVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd =	this.bkgDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMinCgoWgt =	this.bkgMinCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMaxCgoWgt =	this.bkgMaxCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}