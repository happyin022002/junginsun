/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RsltNoteConvVO.java
*@FileTitle : RsltNoteConvVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.03.31 CHLOE MIJIN SEO 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo;

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
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author CHLOE MIJIN SEO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltNoteConvVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltNoteConvVO> models = new ArrayList<RsltNoteConvVO>();
	
	/* Column Info */
	private String bkgYdCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String payTermCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String noteConvSeq = null;
	/* Column Info */
	private String rtApplTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgDelTpCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String bkgSocFlg = null;
	/* Column Info */
	private String bkgHngrBarTpCd = null;
	/* Column Info */
	private String bkgMaxCgoWgt = null;
	/* Column Info */
	private String bkgTsPortTpCd = null;
	/* Column Info */
	private String bkgTsPortDefCd = null;
	/* Column Info */
	private String bkgCmdtDefCd = null;
	/* Column Info */
	private String bkgPodTpCd = null;
	/* Column Info */
	private String bkgCmdtTpCd = null;
	/* Column Info */
	private String rtOpCd = null;
	/* Column Info */
	private String bkgMinCgoWgt = null;
	/* Column Info */
	private String chgRuleDefCd = null;
	/* Column Info */
	private String noteConvMapgId = null;
	/* Column Info */
	private String bkgPolDefCd = null;
	/* Column Info */
	private String chgRuleTpCd = null;
	/* Column Info */
	private String bkgRatUtCd = null;
	/* Column Info */
	private String bkgDelDefCd = null;
	/* Column Info */
	private String bkgImdgClssCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String bkgPrcCgoTpCd = null;
	/* Column Info */
	private String bkgDirCallFlg = null;
	/* Column Info */
	private String bkgDelCntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgSlanCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String bkgPolCntCd = null;
	/* Column Info */
	private String noteConvTpCd = null;
	/* Column Info */
	private String bkgPolTpCd = null;
	/* Column Info */
	private String noteConvRuleCd = null;
	/* Column Info */
	private String bkgSkdDirCd = null;
	/* Column Info */
	private String bkgPorTpCd = null;
	/* Column Info */
	private String bkgPodDefCd = null;
	/* Column Info */
	private String noteConvChgCd = null;
	/* Column Info */
	private String bkgPorDefCd = null;
	/* Column Info */
	private String bkgSkdVoyNo = null;
	/* Column Info */
	private String bkgEsvcTpCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String frtRtAmt = null;
	/* Column Info */
	private String bkgPorCntCd = null;
	/* Column Info */
	private String bkgPodCntCd = null;
	/* Column Info */
	private String bkgVvdCd = null;
	/* Column Info */
	private String bkgVslCd = null;
	/* Column Info */
	private String preNoteConvMapgId = null;
	/* Column Info */
	private String updUsrId = null;
		
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltNoteConvVO() {}

	public RsltNoteConvVO(String ibflag, String pagerows, String noteConvMapgId, String noteConvSeq, String noteConvTpCd, String svcScpCd, String propNo, String amdtSeq, String chgRuleDefCd, String chgRuleTpCd, String noteConvChgCd, String noteConvRuleCd, String effDt, String expDt, String rtApplTpCd, String rtOpCd, String currCd, String frtRtAmt, String payTermCd, String bkgRatUtCd, String bkgPrcCgoTpCd, String bkgImdgClssCd, String bkgCmdtTpCd, String bkgCmdtDefCd, String bkgPorTpCd, String bkgPorDefCd, String bkgPolTpCd, String bkgPolDefCd, String bkgPodTpCd, String bkgPodDefCd, String bkgDelTpCd, String bkgDelDefCd, String bkgSlanCd, String bkgVvdCd, String bkgVslCd, String bkgSkdVoyNo, String bkgSkdDirCd, String bkgMaxCgoWgt, String bkgMinCgoWgt, String bkgSocFlg, String bkgTsPortTpCd, String bkgTsPortDefCd, String bkgDirCallFlg, String bkgHngrBarTpCd, String bkgPorCntCd, String bkgPolCntCd, String bkgPodCntCd, String bkgDelCntCd, String bkgYdCd, String bkgEsvcTpCd) {
		this.bkgYdCd = bkgYdCd;
		this.amdtSeq = amdtSeq;
		this.payTermCd = payTermCd;
		this.svcScpCd = svcScpCd;
		this.noteConvSeq = noteConvSeq;
		this.rtApplTpCd = rtApplTpCd;
		this.pagerows = pagerows;
		this.bkgDelTpCd = bkgDelTpCd;
		this.effDt = effDt;
		this.bkgSocFlg = bkgSocFlg;
		this.bkgHngrBarTpCd = bkgHngrBarTpCd;
		this.bkgMaxCgoWgt = bkgMaxCgoWgt;
		this.bkgTsPortTpCd = bkgTsPortTpCd;
		this.bkgTsPortDefCd = bkgTsPortDefCd;
		this.bkgCmdtDefCd = bkgCmdtDefCd;
		this.bkgPodTpCd = bkgPodTpCd;
		this.bkgCmdtTpCd = bkgCmdtTpCd;
		this.rtOpCd = rtOpCd;
		this.bkgMinCgoWgt = bkgMinCgoWgt;
		this.chgRuleDefCd = chgRuleDefCd;
		this.noteConvMapgId = noteConvMapgId;
		this.bkgPolDefCd = bkgPolDefCd;
		this.chgRuleTpCd = chgRuleTpCd;
		this.bkgRatUtCd = bkgRatUtCd;
		this.bkgDelDefCd = bkgDelDefCd;
		this.bkgImdgClssCd = bkgImdgClssCd;
		this.currCd = currCd;
		this.bkgPrcCgoTpCd = bkgPrcCgoTpCd;
		this.bkgDirCallFlg = bkgDirCallFlg;
		this.bkgDelCntCd = bkgDelCntCd;
		this.ibflag = ibflag;
		this.bkgSlanCd = bkgSlanCd;
		this.expDt = expDt;
		this.bkgPolCntCd = bkgPolCntCd;
		this.noteConvTpCd = noteConvTpCd;
		this.bkgPolTpCd = bkgPolTpCd;
		this.noteConvRuleCd = noteConvRuleCd;
		this.bkgSkdDirCd = bkgSkdDirCd;
		this.bkgPorTpCd = bkgPorTpCd;
		this.bkgPodDefCd = bkgPodDefCd;
		this.noteConvChgCd = noteConvChgCd;
		this.bkgPorDefCd = bkgPorDefCd;
		this.bkgSkdVoyNo = bkgSkdVoyNo;
		this.bkgEsvcTpCd = bkgEsvcTpCd;
		this.propNo = propNo;
		this.frtRtAmt = frtRtAmt;
		this.bkgPorCntCd = bkgPorCntCd;
		this.bkgPodCntCd = bkgPodCntCd;
		this.bkgVvdCd = bkgVvdCd;
		this.bkgVslCd = bkgVslCd;
		this.preNoteConvMapgId = preNoteConvMapgId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_yd_cd", getBkgYdCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("pay_term_cd", getPayTermCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("note_conv_seq", getNoteConvSeq());
		this.hashColumns.put("rt_appl_tp_cd", getRtApplTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_del_tp_cd", getBkgDelTpCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("bkg_soc_flg", getBkgSocFlg());
		this.hashColumns.put("bkg_hngr_bar_tp_cd", getBkgHngrBarTpCd());
		this.hashColumns.put("bkg_max_cgo_wgt", getBkgMaxCgoWgt());
		this.hashColumns.put("bkg_ts_port_tp_cd", getBkgTsPortTpCd());
		this.hashColumns.put("bkg_ts_port_def_cd", getBkgTsPortDefCd());
		this.hashColumns.put("bkg_cmdt_def_cd", getBkgCmdtDefCd());
		this.hashColumns.put("bkg_pod_tp_cd", getBkgPodTpCd());
		this.hashColumns.put("bkg_cmdt_tp_cd", getBkgCmdtTpCd());
		this.hashColumns.put("rt_op_cd", getRtOpCd());
		this.hashColumns.put("bkg_min_cgo_wgt", getBkgMinCgoWgt());
		this.hashColumns.put("chg_rule_def_cd", getChgRuleDefCd());
		this.hashColumns.put("note_conv_mapg_id", getNoteConvMapgId());
		this.hashColumns.put("bkg_pol_def_cd", getBkgPolDefCd());
		this.hashColumns.put("chg_rule_tp_cd", getChgRuleTpCd());
		this.hashColumns.put("bkg_rat_ut_cd", getBkgRatUtCd());
		this.hashColumns.put("bkg_del_def_cd", getBkgDelDefCd());
		this.hashColumns.put("bkg_imdg_clss_cd", getBkgImdgClssCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("bkg_prc_cgo_tp_cd", getBkgPrcCgoTpCd());
		this.hashColumns.put("bkg_dir_call_flg", getBkgDirCallFlg());
		this.hashColumns.put("bkg_del_cnt_cd", getBkgDelCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_slan_cd", getBkgSlanCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("bkg_pol_cnt_cd", getBkgPolCntCd());
		this.hashColumns.put("note_conv_tp_cd", getNoteConvTpCd());
		this.hashColumns.put("bkg_pol_tp_cd", getBkgPolTpCd());
		this.hashColumns.put("note_conv_rule_cd", getNoteConvRuleCd());
		this.hashColumns.put("bkg_skd_dir_cd", getBkgSkdDirCd());
		this.hashColumns.put("bkg_por_tp_cd", getBkgPorTpCd());
		this.hashColumns.put("bkg_pod_def_cd", getBkgPodDefCd());
		this.hashColumns.put("note_conv_chg_cd", getNoteConvChgCd());
		this.hashColumns.put("bkg_por_def_cd", getBkgPorDefCd());
		this.hashColumns.put("bkg_skd_voy_no", getBkgSkdVoyNo());
		this.hashColumns.put("bkg_esvc_tp_cd", getBkgEsvcTpCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("frt_rt_amt", getFrtRtAmt());
		this.hashColumns.put("bkg_por_cnt_cd", getBkgPorCntCd());
		this.hashColumns.put("bkg_pod_cnt_cd", getBkgPodCntCd());
		this.hashColumns.put("bkg_vvd_cd", getBkgVvdCd());
		this.hashColumns.put("bkg_vsl_cd", getBkgVslCd());
		this.hashColumns.put("bkg_vsl_cd", getBkgVslCd());
		this.hashColumns.put("pre_note_conv_mapg_id", getPreNoteConvMapgId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_yd_cd", "bkgYdCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("pay_term_cd", "payTermCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("note_conv_seq", "noteConvSeq");
		this.hashFields.put("rt_appl_tp_cd", "rtApplTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_del_tp_cd", "bkgDelTpCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("bkg_soc_flg", "bkgSocFlg");
		this.hashFields.put("bkg_hngr_bar_tp_cd", "bkgHngrBarTpCd");
		this.hashFields.put("bkg_max_cgo_wgt", "bkgMaxCgoWgt");
		this.hashFields.put("bkg_ts_port_tp_cd", "bkgTsPortTpCd");
		this.hashFields.put("bkg_ts_port_def_cd", "bkgTsPortDefCd");
		this.hashFields.put("bkg_cmdt_def_cd", "bkgCmdtDefCd");
		this.hashFields.put("bkg_pod_tp_cd", "bkgPodTpCd");
		this.hashFields.put("bkg_cmdt_tp_cd", "bkgCmdtTpCd");
		this.hashFields.put("rt_op_cd", "rtOpCd");
		this.hashFields.put("bkg_min_cgo_wgt", "bkgMinCgoWgt");
		this.hashFields.put("chg_rule_def_cd", "chgRuleDefCd");
		this.hashFields.put("note_conv_mapg_id", "noteConvMapgId");
		this.hashFields.put("bkg_pol_def_cd", "bkgPolDefCd");
		this.hashFields.put("chg_rule_tp_cd", "chgRuleTpCd");
		this.hashFields.put("bkg_rat_ut_cd", "bkgRatUtCd");
		this.hashFields.put("bkg_del_def_cd", "bkgDelDefCd");
		this.hashFields.put("bkg_imdg_clss_cd", "bkgImdgClssCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("bkg_prc_cgo_tp_cd", "bkgPrcCgoTpCd");
		this.hashFields.put("bkg_dir_call_flg", "bkgDirCallFlg");
		this.hashFields.put("bkg_del_cnt_cd", "bkgDelCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_slan_cd", "bkgSlanCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("bkg_pol_cnt_cd", "bkgPolCntCd");
		this.hashFields.put("note_conv_tp_cd", "noteConvTpCd");
		this.hashFields.put("bkg_pol_tp_cd", "bkgPolTpCd");
		this.hashFields.put("note_conv_rule_cd", "noteConvRuleCd");
		this.hashFields.put("bkg_skd_dir_cd", "bkgSkdDirCd");
		this.hashFields.put("bkg_por_tp_cd", "bkgPorTpCd");
		this.hashFields.put("bkg_pod_def_cd", "bkgPodDefCd");
		this.hashFields.put("note_conv_chg_cd", "noteConvChgCd");
		this.hashFields.put("bkg_por_def_cd", "bkgPorDefCd");
		this.hashFields.put("bkg_skd_voy_no", "bkgSkdVoyNo");
		this.hashFields.put("bkg_esvc_tp_cd", "bkgEsvcTpCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("frt_rt_amt", "frtRtAmt");
		this.hashFields.put("bkg_por_cnt_cd", "bkgPorCntCd");
		this.hashFields.put("bkg_pod_cnt_cd", "bkgPodCntCd");
		this.hashFields.put("bkg_vvd_cd", "bkgVvdCd");
		this.hashFields.put("bkg_vsl_cd", "bkgVslCd");
		this.hashFields.put("pre_note_conv_mapg_id", "preNoteConvMapgId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgYdCd
	 */
	public String getBkgYdCd() {
		return this.bkgYdCd;
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
	 * @return payTermCd
	 */
	public String getPayTermCd() {
		return this.payTermCd;
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
	 * @return noteConvSeq
	 */
	public String getNoteConvSeq() {
		return this.noteConvSeq;
	}
	
	/**
	 * Column Info
	 * @return rtApplTpCd
	 */
	public String getRtApplTpCd() {
		return this.rtApplTpCd;
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
	 * @return bkgDelTpCd
	 */
	public String getBkgDelTpCd() {
		return this.bkgDelTpCd;
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
	 * @return bkgSocFlg
	 */
	public String getBkgSocFlg() {
		return this.bkgSocFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgHngrBarTpCd
	 */
	public String getBkgHngrBarTpCd() {
		return this.bkgHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgMaxCgoWgt
	 */
	public String getBkgMaxCgoWgt() {
		return this.bkgMaxCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return bkgTsPortTpCd
	 */
	public String getBkgTsPortTpCd() {
		return this.bkgTsPortTpCd;
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
	 * @return bkgCmdtDefCd
	 */
	public String getBkgCmdtDefCd() {
		return this.bkgCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPodTpCd
	 */
	public String getBkgPodTpCd() {
		return this.bkgPodTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCmdtTpCd
	 */
	public String getBkgCmdtTpCd() {
		return this.bkgCmdtTpCd;
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
	 * @return bkgMinCgoWgt
	 */
	public String getBkgMinCgoWgt() {
		return this.bkgMinCgoWgt;
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
	 * @return noteConvMapgId
	 */
	public String getNoteConvMapgId() {
		return this.noteConvMapgId;
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
	 * @return chgRuleTpCd
	 */
	public String getChgRuleTpCd() {
		return this.chgRuleTpCd;
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
	 * @return bkgDelDefCd
	 */
	public String getBkgDelDefCd() {
		return this.bkgDelDefCd;
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
	 * @return bkgPrcCgoTpCd
	 */
	public String getBkgPrcCgoTpCd() {
		return this.bkgPrcCgoTpCd;
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
	 * @return bkgDelCntCd
	 */
	public String getBkgDelCntCd() {
		return this.bkgDelCntCd;
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
	 * @return bkgPolCntCd
	 */
	public String getBkgPolCntCd() {
		return this.bkgPolCntCd;
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
	 * @return bkgPolTpCd
	 */
	public String getBkgPolTpCd() {
		return this.bkgPolTpCd;
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
	 * @return bkgSkdDirCd
	 */
	public String getBkgSkdDirCd() {
		return this.bkgSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPorTpCd
	 */
	public String getBkgPorTpCd() {
		return this.bkgPorTpCd;
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
	 * @return noteConvChgCd
	 */
	public String getNoteConvChgCd() {
		return this.noteConvChgCd;
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
	 * @return bkgSkdVoyNo
	 */
	public String getBkgSkdVoyNo() {
		return this.bkgSkdVoyNo;
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
	 * @return bkgPorCntCd
	 */
	public String getBkgPorCntCd() {
		return this.bkgPorCntCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPodCntCd
	 */
	public String getBkgPodCntCd() {
		return this.bkgPodCntCd;
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
	 * @return bkgVslCd
	 */
	public String getBkgVslCd() {
		return this.bkgVslCd;
	}
	

	/**
	 * Column Info
	 * @param bkgYdCd
	 */
	public void setBkgYdCd(String bkgYdCd) {
		this.bkgYdCd = bkgYdCd;
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
	 * @param payTermCd
	 */
	public void setPayTermCd(String payTermCd) {
		this.payTermCd = payTermCd;
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
	 * @param noteConvSeq
	 */
	public void setNoteConvSeq(String noteConvSeq) {
		this.noteConvSeq = noteConvSeq;
	}
	
	/**
	 * Column Info
	 * @param rtApplTpCd
	 */
	public void setRtApplTpCd(String rtApplTpCd) {
		this.rtApplTpCd = rtApplTpCd;
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
	 * @param bkgDelTpCd
	 */
	public void setBkgDelTpCd(String bkgDelTpCd) {
		this.bkgDelTpCd = bkgDelTpCd;
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
	 * @param bkgSocFlg
	 */
	public void setBkgSocFlg(String bkgSocFlg) {
		this.bkgSocFlg = bkgSocFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgHngrBarTpCd
	 */
	public void setBkgHngrBarTpCd(String bkgHngrBarTpCd) {
		this.bkgHngrBarTpCd = bkgHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgMaxCgoWgt
	 */
	public void setBkgMaxCgoWgt(String bkgMaxCgoWgt) {
		this.bkgMaxCgoWgt = bkgMaxCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param bkgTsPortTpCd
	 */
	public void setBkgTsPortTpCd(String bkgTsPortTpCd) {
		this.bkgTsPortTpCd = bkgTsPortTpCd;
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
	 * @param bkgCmdtDefCd
	 */
	public void setBkgCmdtDefCd(String bkgCmdtDefCd) {
		this.bkgCmdtDefCd = bkgCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPodTpCd
	 */
	public void setBkgPodTpCd(String bkgPodTpCd) {
		this.bkgPodTpCd = bkgPodTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCmdtTpCd
	 */
	public void setBkgCmdtTpCd(String bkgCmdtTpCd) {
		this.bkgCmdtTpCd = bkgCmdtTpCd;
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
	 * @param bkgMinCgoWgt
	 */
	public void setBkgMinCgoWgt(String bkgMinCgoWgt) {
		this.bkgMinCgoWgt = bkgMinCgoWgt;
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
	 * @param noteConvMapgId
	 */
	public void setNoteConvMapgId(String noteConvMapgId) {
		this.noteConvMapgId = noteConvMapgId;
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
	 * @param chgRuleTpCd
	 */
	public void setChgRuleTpCd(String chgRuleTpCd) {
		this.chgRuleTpCd = chgRuleTpCd;
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
	 * @param bkgDelDefCd
	 */
	public void setBkgDelDefCd(String bkgDelDefCd) {
		this.bkgDelDefCd = bkgDelDefCd;
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
	 * @param bkgPrcCgoTpCd
	 */
	public void setBkgPrcCgoTpCd(String bkgPrcCgoTpCd) {
		this.bkgPrcCgoTpCd = bkgPrcCgoTpCd;
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
	 * @param bkgDelCntCd
	 */
	public void setBkgDelCntCd(String bkgDelCntCd) {
		this.bkgDelCntCd = bkgDelCntCd;
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
	 * @param bkgPolCntCd
	 */
	public void setBkgPolCntCd(String bkgPolCntCd) {
		this.bkgPolCntCd = bkgPolCntCd;
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
	 * @param bkgPolTpCd
	 */
	public void setBkgPolTpCd(String bkgPolTpCd) {
		this.bkgPolTpCd = bkgPolTpCd;
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
	 * @param bkgSkdDirCd
	 */
	public void setBkgSkdDirCd(String bkgSkdDirCd) {
		this.bkgSkdDirCd = bkgSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPorTpCd
	 */
	public void setBkgPorTpCd(String bkgPorTpCd) {
		this.bkgPorTpCd = bkgPorTpCd;
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
	 * @param noteConvChgCd
	 */
	public void setNoteConvChgCd(String noteConvChgCd) {
		this.noteConvChgCd = noteConvChgCd;
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
	 * @param bkgSkdVoyNo
	 */
	public void setBkgSkdVoyNo(String bkgSkdVoyNo) {
		this.bkgSkdVoyNo = bkgSkdVoyNo;
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
	 * @param bkgPorCntCd
	 */
	public void setBkgPorCntCd(String bkgPorCntCd) {
		this.bkgPorCntCd = bkgPorCntCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPodCntCd
	 */
	public void setBkgPodCntCd(String bkgPodCntCd) {
		this.bkgPodCntCd = bkgPodCntCd;
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
	 * @param bkgVslCd
	 */
	public void setBkgVslCd(String bkgVslCd) {
		this.bkgVslCd = bkgVslCd;
	}
	
	/**
	 * Column Info
	 * @return preNoteConvMapgId
	 */
	public String getPreNoteConvMapgId() {
		return preNoteConvMapgId;
	}

	/**
	 * Column Info
	 * @param preNoteConvMapgId
	 */
	public void setPreNoteConvMapgId(String preNoteConvMapgId) {
		this.preNoteConvMapgId = preNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setBkgYdCd(JSPUtil.getParameter(request, prefix + "bkg_yd_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setPayTermCd(JSPUtil.getParameter(request, prefix + "pay_term_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setNoteConvSeq(JSPUtil.getParameter(request, prefix + "note_conv_seq", ""));
		setRtApplTpCd(JSPUtil.getParameter(request, prefix + "rt_appl_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgDelTpCd(JSPUtil.getParameter(request, prefix + "bkg_del_tp_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setBkgSocFlg(JSPUtil.getParameter(request, prefix + "bkg_soc_flg", ""));
		setBkgHngrBarTpCd(JSPUtil.getParameter(request, prefix + "bkg_hngr_bar_tp_cd", ""));
		setBkgMaxCgoWgt(JSPUtil.getParameter(request, prefix + "bkg_max_cgo_wgt", ""));
		setBkgTsPortTpCd(JSPUtil.getParameter(request, prefix + "bkg_ts_port_tp_cd", ""));
		setBkgTsPortDefCd(JSPUtil.getParameter(request, prefix + "bkg_ts_port_def_cd", ""));
		setBkgCmdtDefCd(JSPUtil.getParameter(request, prefix + "bkg_cmdt_def_cd", ""));
		setBkgPodTpCd(JSPUtil.getParameter(request, prefix + "bkg_pod_tp_cd", ""));
		setBkgCmdtTpCd(JSPUtil.getParameter(request, prefix + "bkg_cmdt_tp_cd", ""));
		setRtOpCd(JSPUtil.getParameter(request, prefix + "rt_op_cd", ""));
		setBkgMinCgoWgt(JSPUtil.getParameter(request, prefix + "bkg_min_cgo_wgt", ""));
		setChgRuleDefCd(JSPUtil.getParameter(request, prefix + "chg_rule_def_cd", ""));
		setNoteConvMapgId(JSPUtil.getParameter(request, prefix + "note_conv_mapg_id", ""));
		setBkgPolDefCd(JSPUtil.getParameter(request, prefix + "bkg_pol_def_cd", ""));
		setChgRuleTpCd(JSPUtil.getParameter(request, prefix + "chg_rule_tp_cd", ""));
		setBkgRatUtCd(JSPUtil.getParameter(request, prefix + "bkg_rat_ut_cd", ""));
		setBkgDelDefCd(JSPUtil.getParameter(request, prefix + "bkg_del_def_cd", ""));
		setBkgImdgClssCd(JSPUtil.getParameter(request, prefix + "bkg_imdg_clss_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setBkgPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_prc_cgo_tp_cd", ""));
		setBkgDirCallFlg(JSPUtil.getParameter(request, prefix + "bkg_dir_call_flg", ""));
		setBkgDelCntCd(JSPUtil.getParameter(request, prefix + "bkg_del_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgSlanCd(JSPUtil.getParameter(request, prefix + "bkg_slan_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setBkgPolCntCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cnt_cd", ""));
		setNoteConvTpCd(JSPUtil.getParameter(request, prefix + "note_conv_tp_cd", ""));
		setBkgPolTpCd(JSPUtil.getParameter(request, prefix + "bkg_pol_tp_cd", ""));
		setNoteConvRuleCd(JSPUtil.getParameter(request, prefix + "note_conv_rule_cd", ""));
		setBkgSkdDirCd(JSPUtil.getParameter(request, prefix + "bkg_skd_dir_cd", ""));
		setBkgPorTpCd(JSPUtil.getParameter(request, prefix + "bkg_por_tp_cd", ""));
		setBkgPodDefCd(JSPUtil.getParameter(request, prefix + "bkg_pod_def_cd", ""));
		setNoteConvChgCd(JSPUtil.getParameter(request, prefix + "note_conv_chg_cd", ""));
		setBkgPorDefCd(JSPUtil.getParameter(request, prefix + "bkg_por_def_cd", ""));
		setBkgSkdVoyNo(JSPUtil.getParameter(request, prefix + "bkg_skd_voy_no", ""));
		setBkgEsvcTpCd(JSPUtil.getParameter(request, prefix + "bkg_esvc_tp_cd", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setFrtRtAmt(JSPUtil.getParameter(request, prefix + "frt_rt_amt", ""));
		setBkgPorCntCd(JSPUtil.getParameter(request, prefix + "bkg_por_cnt_cd", ""));
		setBkgPodCntCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cnt_cd", ""));
		setBkgVvdCd(JSPUtil.getParameter(request, prefix + "bkg_vvd_cd", ""));
		setBkgVslCd(JSPUtil.getParameter(request, prefix + "bkg_vsl_cd", ""));
		setPreNoteConvMapgId(JSPUtil.getParameter(request, prefix + "pre_note_conv_mapg_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltNoteConvVO[]
	 */
	public RsltNoteConvVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltNoteConvVO[]
	 */
	public RsltNoteConvVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltNoteConvVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgYdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_yd_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] payTermCd = (JSPUtil.getParameter(request, prefix	+ "pay_term_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] noteConvSeq = (JSPUtil.getParameter(request, prefix	+ "note_conv_seq", length));
			String[] rtApplTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_appl_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgDelTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_tp_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] bkgSocFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_soc_flg", length));
			String[] bkgHngrBarTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_hngr_bar_tp_cd", length));
			String[] bkgMaxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_max_cgo_wgt", length));
			String[] bkgTsPortTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_port_tp_cd", length));
			String[] bkgTsPortDefCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_port_def_cd", length));
			String[] bkgCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cmdt_def_cd", length));
			String[] bkgPodTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_tp_cd", length));
			String[] bkgCmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cmdt_tp_cd", length));
			String[] rtOpCd = (JSPUtil.getParameter(request, prefix	+ "rt_op_cd", length));
			String[] bkgMinCgoWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_min_cgo_wgt", length));
			String[] chgRuleDefCd = (JSPUtil.getParameter(request, prefix	+ "chg_rule_def_cd", length));
			String[] noteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "note_conv_mapg_id", length));
			String[] bkgPolDefCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_def_cd", length));
			String[] chgRuleTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_rule_tp_cd", length));
			String[] bkgRatUtCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rat_ut_cd", length));
			String[] bkgDelDefCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_def_cd", length));
			String[] bkgImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "bkg_imdg_clss_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] bkgPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_prc_cgo_tp_cd", length));
			String[] bkgDirCallFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_dir_call_flg", length));
			String[] bkgDelCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgSlanCd = (JSPUtil.getParameter(request, prefix	+ "bkg_slan_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] bkgPolCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cnt_cd", length));
			String[] noteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "note_conv_tp_cd", length));
			String[] bkgPolTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_tp_cd", length));
			String[] noteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "note_conv_rule_cd", length));
			String[] bkgSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "bkg_skd_dir_cd", length));
			String[] bkgPorTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_tp_cd", length));
			String[] bkgPodDefCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_def_cd", length));
			String[] noteConvChgCd = (JSPUtil.getParameter(request, prefix	+ "note_conv_chg_cd", length));
			String[] bkgPorDefCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_def_cd", length));
			String[] bkgSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "bkg_skd_voy_no", length));
			String[] bkgEsvcTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_esvc_tp_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] frtRtAmt = (JSPUtil.getParameter(request, prefix	+ "frt_rt_amt", length));
			String[] bkgPorCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cnt_cd", length));
			String[] bkgPodCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cnt_cd", length));
			String[] bkgVvdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_vvd_cd", length));
			String[] bkgVslCd = (JSPUtil.getParameter(request, prefix	+ "bkg_vsl_cd", length));
			String[] preNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "pre_note_conv_mapg_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltNoteConvVO();
				if (bkgYdCd[i] != null)
					model.setBkgYdCd(bkgYdCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (payTermCd[i] != null)
					model.setPayTermCd(payTermCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (noteConvSeq[i] != null)
					model.setNoteConvSeq(noteConvSeq[i]);
				if (rtApplTpCd[i] != null)
					model.setRtApplTpCd(rtApplTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgDelTpCd[i] != null)
					model.setBkgDelTpCd(bkgDelTpCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (bkgSocFlg[i] != null)
					model.setBkgSocFlg(bkgSocFlg[i]);
				if (bkgHngrBarTpCd[i] != null)
					model.setBkgHngrBarTpCd(bkgHngrBarTpCd[i]);
				if (bkgMaxCgoWgt[i] != null)
					model.setBkgMaxCgoWgt(bkgMaxCgoWgt[i]);
				if (bkgTsPortTpCd[i] != null)
					model.setBkgTsPortTpCd(bkgTsPortTpCd[i]);
				if (bkgTsPortDefCd[i] != null)
					model.setBkgTsPortDefCd(bkgTsPortDefCd[i]);
				if (bkgCmdtDefCd[i] != null)
					model.setBkgCmdtDefCd(bkgCmdtDefCd[i]);
				if (bkgPodTpCd[i] != null)
					model.setBkgPodTpCd(bkgPodTpCd[i]);
				if (bkgCmdtTpCd[i] != null)
					model.setBkgCmdtTpCd(bkgCmdtTpCd[i]);
				if (rtOpCd[i] != null)
					model.setRtOpCd(rtOpCd[i]);
				if (bkgMinCgoWgt[i] != null)
					model.setBkgMinCgoWgt(bkgMinCgoWgt[i]);
				if (chgRuleDefCd[i] != null)
					model.setChgRuleDefCd(chgRuleDefCd[i]);
				if (noteConvMapgId[i] != null)
					model.setNoteConvMapgId(noteConvMapgId[i]);
				if (bkgPolDefCd[i] != null)
					model.setBkgPolDefCd(bkgPolDefCd[i]);
				if (chgRuleTpCd[i] != null)
					model.setChgRuleTpCd(chgRuleTpCd[i]);
				if (bkgRatUtCd[i] != null)
					model.setBkgRatUtCd(bkgRatUtCd[i]);
				if (bkgDelDefCd[i] != null)
					model.setBkgDelDefCd(bkgDelDefCd[i]);
				if (bkgImdgClssCd[i] != null)
					model.setBkgImdgClssCd(bkgImdgClssCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (bkgPrcCgoTpCd[i] != null)
					model.setBkgPrcCgoTpCd(bkgPrcCgoTpCd[i]);
				if (bkgDirCallFlg[i] != null)
					model.setBkgDirCallFlg(bkgDirCallFlg[i]);
				if (bkgDelCntCd[i] != null)
					model.setBkgDelCntCd(bkgDelCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgSlanCd[i] != null)
					model.setBkgSlanCd(bkgSlanCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (bkgPolCntCd[i] != null)
					model.setBkgPolCntCd(bkgPolCntCd[i]);
				if (noteConvTpCd[i] != null)
					model.setNoteConvTpCd(noteConvTpCd[i]);
				if (bkgPolTpCd[i] != null)
					model.setBkgPolTpCd(bkgPolTpCd[i]);
				if (noteConvRuleCd[i] != null)
					model.setNoteConvRuleCd(noteConvRuleCd[i]);
				if (bkgSkdDirCd[i] != null)
					model.setBkgSkdDirCd(bkgSkdDirCd[i]);
				if (bkgPorTpCd[i] != null)
					model.setBkgPorTpCd(bkgPorTpCd[i]);
				if (bkgPodDefCd[i] != null)
					model.setBkgPodDefCd(bkgPodDefCd[i]);
				if (noteConvChgCd[i] != null)
					model.setNoteConvChgCd(noteConvChgCd[i]);
				if (bkgPorDefCd[i] != null)
					model.setBkgPorDefCd(bkgPorDefCd[i]);
				if (bkgSkdVoyNo[i] != null)
					model.setBkgSkdVoyNo(bkgSkdVoyNo[i]);
				if (bkgEsvcTpCd[i] != null)
					model.setBkgEsvcTpCd(bkgEsvcTpCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (frtRtAmt[i] != null)
					model.setFrtRtAmt(frtRtAmt[i]);
				if (bkgPorCntCd[i] != null)
					model.setBkgPorCntCd(bkgPorCntCd[i]);
				if (bkgPodCntCd[i] != null)
					model.setBkgPodCntCd(bkgPodCntCd[i]);
				if (bkgVvdCd[i] != null)
					model.setBkgVvdCd(bkgVvdCd[i]);
				if (bkgVslCd[i] != null)
					model.setBkgVslCd(bkgVslCd[i]);
				if (preNoteConvMapgId[i] != null)
					model.setPreNoteConvMapgId(preNoteConvMapgId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltNoteConvVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltNoteConvVO[]
	 */
	public RsltNoteConvVO[] getRsltNoteConvVOs(){
		RsltNoteConvVO[] vos = (RsltNoteConvVO[])models.toArray(new RsltNoteConvVO[models.size()]);
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
		this.bkgYdCd = this.bkgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermCd = this.payTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvSeq = this.noteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtApplTpCd = this.rtApplTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelTpCd = this.bkgDelTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSocFlg = this.bkgSocFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHngrBarTpCd = this.bkgHngrBarTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMaxCgoWgt = this.bkgMaxCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsPortTpCd = this.bkgTsPortTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsPortDefCd = this.bkgTsPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCmdtDefCd = this.bkgCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodTpCd = this.bkgPodTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCmdtTpCd = this.bkgCmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtOpCd = this.rtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMinCgoWgt = this.bkgMinCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRuleDefCd = this.chgRuleDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvMapgId = this.noteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolDefCd = this.bkgPolDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRuleTpCd = this.chgRuleTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRatUtCd = this.bkgRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelDefCd = this.bkgDelDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgImdgClssCd = this.bkgImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPrcCgoTpCd = this.bkgPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDirCallFlg = this.bkgDirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCntCd = this.bkgDelCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSlanCd = this.bkgSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCntCd = this.bkgPolCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvTpCd = this.noteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolTpCd = this.bkgPolTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvRuleCd = this.noteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSkdDirCd = this.bkgSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorTpCd = this.bkgPorTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodDefCd = this.bkgPodDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvChgCd = this.noteConvChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorDefCd = this.bkgPorDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSkdVoyNo = this.bkgSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgEsvcTpCd = this.bkgEsvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtRtAmt = this.frtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCntCd = this.bkgPorCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCntCd = this.bkgPodCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVvdCd = this.bkgVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVslCd = this.bkgVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preNoteConvMapgId = this.preNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
