/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AplyRtOutVO.java
*@FileTitle : AplyRtOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.02  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo;

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

public class AplyRtOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AplyRtOutVO> models = new ArrayList<AplyRtOutVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String grpCmdt = null;
	/* Column Info */
	private String cntrSzCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String rcvTMtchFlg = null;
	/* Column Info */
	private String orgMtchFlg = null;
	/* Column Info */
	private String delTMtchFlg = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String orgCntrSzCd = null;
	/* Column Info */
	private String pctlNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String netAmtUsd = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aplyXchRto = null;
	/* Column Info */
	private String cntrTpCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String chgAmtUsd = null;
	/* Column Info */
	private String schgRt = null;
	/* Column Info */
	private String orgViaMtchFlg = null;
	/* Column Info */
	private String destViaMtchFlg = null;
	/* Column Info */
	private String chgUtAmt = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String baseRt = null;
	/* Column Info */
	private String ttlRt = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String gohMtchFlg = null;
	/* Column Info */
	private String socMtchFlg = null;
	/* Column Info */
	private String frtInclXcldDivCd = null;
	/* Column Info */
	private String destMtchFlg = null;
	/* Column Info */
	private String ratAsQty = null;
	/* Column Info */
	private String cmdtSeq = null;
	/* Column Info */
	private String gohAmt = null;
	/* Column Info */
	private String autoRatFlg = null;
	/* Column Info */
	private String cgoTpCdMtchFlg = null;
	/* Column Info */
	private String cntrTpCdMtchFlg = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String orgInlndHlgAmt = null;
	/* Column Info */
	private String orgArbAmt = null;
	/* Column Info */
	private String destArbAmt = null;
	/* Column Info */
	private String destInlndHlgAmt = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String grpCmdtNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AplyRtOutVO() {}

	public AplyRtOutVO(String ibflag, String pagerows, String cntrSzCd, String cmdtCd, String cmdtNm, String grpCmdt, String ttlRt, String baseRt, String schgRt, String effDt, String rcvTMtchFlg, String delTMtchFlg, String svcScpCd, String orgMtchFlg, String orgViaMtchFlg, String destViaMtchFlg, String destMtchFlg, String cgoTpCd, String cntrTpCd, String socMtchFlg, String gohMtchFlg, String chgCd, String currCd, String chgUtAmt, String ratUtCd, String ratAsQty, String chgAmt, String aplyXchRto, String chgAmtUsd, String frtInclXcldDivCd, String netAmtUsd, String pctlNo, String orgCntrSzCd, String frtTermCd, String cmdtSeq, String gohAmt, String autoRatFlg, String cgoTpCdMtchFlg, String cntrTpCdMtchFlg, String rcvTermCd, String deTermCd, String orgInlndHlgAmt, String orgArbAmt, String destArbAmt, String destInlndHlgAmt, String socFlg, String remark, String grpCmdtNm) {
		this.currCd = currCd;
		this.grpCmdt = grpCmdt;
		this.cntrSzCd = cntrSzCd;
		this.svcScpCd = svcScpCd;
		this.cgoTpCd = cgoTpCd;
		this.rcvTMtchFlg = rcvTMtchFlg;
		this.orgMtchFlg = orgMtchFlg;
		this.delTMtchFlg = delTMtchFlg;
		this.chgCd = chgCd;
		this.orgCntrSzCd = orgCntrSzCd;
		this.pctlNo = pctlNo;
		this.pagerows = pagerows;
		this.netAmtUsd = netAmtUsd;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.aplyXchRto = aplyXchRto;
		this.cntrTpCd = cntrTpCd;
		this.cmdtCd = cmdtCd;
		this.chgAmt = chgAmt;
		this.chgAmtUsd = chgAmtUsd;
		this.schgRt = schgRt;
		this.orgViaMtchFlg = orgViaMtchFlg;
		this.destViaMtchFlg = destViaMtchFlg;
		this.chgUtAmt = chgUtAmt;
		this.frtTermCd = frtTermCd;
		this.ratUtCd = ratUtCd;
		this.baseRt = baseRt;
		this.ttlRt = ttlRt;
		this.cmdtNm = cmdtNm;
		this.gohMtchFlg = gohMtchFlg;
		this.socMtchFlg = socMtchFlg;
		this.frtInclXcldDivCd = frtInclXcldDivCd;
		this.destMtchFlg = destMtchFlg;
		this.ratAsQty = ratAsQty;
		this.cmdtSeq = cmdtSeq;
		this.gohAmt = gohAmt;
		this.autoRatFlg = autoRatFlg;
		this.cgoTpCdMtchFlg = cgoTpCdMtchFlg;
		this.cntrTpCdMtchFlg = cntrTpCdMtchFlg;
		this.rcvTermCd = rcvTermCd;
		this.deTermCd = deTermCd;
		this.orgInlndHlgAmt = orgInlndHlgAmt;
		this.orgArbAmt = orgArbAmt;
		this.destArbAmt = destArbAmt;
		this.destInlndHlgAmt = destInlndHlgAmt;
		this.socFlg = socFlg;
		this.remark = remark;
		this.grpCmdtNm = grpCmdtNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("grp_cmdt", getGrpCmdt());
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("rcv_t_mtch_flg", getRcvTMtchFlg());
		this.hashColumns.put("org_mtch_flg", getOrgMtchFlg());
		this.hashColumns.put("del_t_mtch_flg", getDelTMtchFlg());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("org_cntr_sz_cd", getOrgCntrSzCd());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("net_amt_usd", getNetAmtUsd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aply_xch_rto", getAplyXchRto());
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("chg_amt_usd", getChgAmtUsd());
		this.hashColumns.put("schg_rt", getSchgRt());
		this.hashColumns.put("org_via_mtch_flg", getOrgViaMtchFlg());
		this.hashColumns.put("dest_via_mtch_flg", getDestViaMtchFlg());
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("base_rt", getBaseRt());
		this.hashColumns.put("ttl_rt", getTtlRt());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("goh_mtch_flg", getGohMtchFlg());
		this.hashColumns.put("soc_mtch_flg", getSocMtchFlg());
		this.hashColumns.put("frt_incl_xcld_div_cd", getFrtInclXcldDivCd());
		this.hashColumns.put("dest_mtch_flg", getDestMtchFlg());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		this.hashColumns.put("cmdt_seq", getCmdtSeq());
		this.hashColumns.put("goh_amt", getGohAmt());
		this.hashColumns.put("auto_rat_flg", getAutoRatFlg());
		this.hashColumns.put("cgo_tp_cd_mtch_flg", getCgoTpCdMtchFlg());
		this.hashColumns.put("cntr_tp_cd_mtch_flg", getCntrTpCdMtchFlg());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("org_inlnd_hlg_amt", getOrgInlndHlgAmt());
		this.hashColumns.put("org_arb_amt", getOrgArbAmt());
		this.hashColumns.put("dest_arb_amt", getDestArbAmt());
		this.hashColumns.put("dest_inlnd_hlg_amt", getDestInlndHlgAmt());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("grp_cmdt_nm", getGrpCmdtNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("grp_cmdt", "grpCmdt");
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("rcv_t_mtch_flg", "rcvTMtchFlg");
		this.hashFields.put("org_mtch_flg", "orgMtchFlg");
		this.hashFields.put("del_t_mtch_flg", "delTMtchFlg");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("org_cntr_sz_cd", "orgCntrSzCd");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("net_amt_usd", "netAmtUsd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aply_xch_rto", "aplyXchRto");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("chg_amt_usd", "chgAmtUsd");
		this.hashFields.put("schg_rt", "schgRt");
		this.hashFields.put("org_via_mtch_flg", "orgViaMtchFlg");
		this.hashFields.put("dest_via_mtch_flg", "destViaMtchFlg");
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("base_rt", "baseRt");
		this.hashFields.put("ttl_rt", "ttlRt");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("goh_mtch_flg", "gohMtchFlg");
		this.hashFields.put("soc_mtch_flg", "socMtchFlg");
		this.hashFields.put("frt_incl_xcld_div_cd", "frtInclXcldDivCd");
		this.hashFields.put("dest_mtch_flg", "destMtchFlg");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		this.hashFields.put("cmdt_seq", "cmdtSeq");
		this.hashFields.put("goh_amt", "gohAmt");
		this.hashFields.put("auto_rat_flg", "autoRatFlg");
		this.hashFields.put("cgo_tp_cd_mtch_flg", "cgoTpCdMtchFlg");
		this.hashFields.put("cntr_tp_cd_mtch_flg", "cntrTpCdMtchFlg");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("org_inlnd_hlg_amt", "orgInlndHlgAmt");
		this.hashFields.put("org_arb_amt", "orgArbAmt");
		this.hashFields.put("dest_arb_amt", "destArbAmt");
		this.hashFields.put("dest_inlnd_hlg_amt", "destInlndHlgAmt");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("grp_cmdt_nm", "grpCmdtNm");
		return this.hashFields;
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
	 * @return grpCmdt
	 */
	public String getGrpCmdt() {
		return this.grpCmdt;
	}
	
	/**
	 * Column Info
	 * @return cntrSzCd
	 */
	public String getCntrSzCd() {
		return this.cntrSzCd;
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
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return rcvTMtchFlg
	 */
	public String getRcvTMtchFlg() {
		return this.rcvTMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return orgMtchFlg
	 */
	public String getOrgMtchFlg() {
		return this.orgMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return delTMtchFlg
	 */
	public String getDelTMtchFlg() {
		return this.delTMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return orgCntrSzCd
	 */
	public String getOrgCntrSzCd() {
		return this.orgCntrSzCd;
	}
	
	/**
	 * Column Info
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
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
	 * @return netAmtUsd
	 */
	public String getNetAmtUsd() {
		return this.netAmtUsd;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return aplyXchRto
	 */
	public String getAplyXchRto() {
		return this.aplyXchRto;
	}
	
	/**
	 * Column Info
	 * @return cntrTpCd
	 */
	public String getCntrTpCd() {
		return this.cntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return chgAmtUsd
	 */
	public String getChgAmtUsd() {
		return this.chgAmtUsd;
	}
	
	/**
	 * Column Info
	 * @return schgRt
	 */
	public String getSchgRt() {
		return this.schgRt;
	}
	
	/**
	 * Column Info
	 * @return orgViaMtchFlg
	 */
	public String getOrgViaMtchFlg() {
		return this.orgViaMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return destViaMtchFlg
	 */
	public String getDestViaMtchFlg() {
		return this.destViaMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return chgUtAmt
	 */
	public String getChgUtAmt() {
		return this.chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return baseRt
	 */
	public String getBaseRt() {
		return this.baseRt;
	}
	
	/**
	 * Column Info
	 * @return ttlRt
	 */
	public String getTtlRt() {
		return this.ttlRt;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return gohMtchFlg
	 */
	public String getGohMtchFlg() {
		return this.gohMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return socMtchFlg
	 */
	public String getSocMtchFlg() {
		return this.socMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return frtInclXcldDivCd
	 */
	public String getFrtInclXcldDivCd() {
		return this.frtInclXcldDivCd;
	}
	
	/**
	 * Column Info
	 * @return destMtchFlg
	 */
	public String getDestMtchFlg() {
		return this.destMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return ratAsQty
	 */
	public String getRatAsQty() {
		return this.ratAsQty;
	}
	
	/**
	 * Column Info
	 * @return cmdtSeq
	 */
	public String getCmdtSeq() {
		return this.cmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return gohAmt
	 */
	public String getGohAmt() {
		return this.gohAmt;
	}
	
	/**
	 * Column Info
	 * @return autoRatFlg
	 */
	public String getAutoRatFlg() {
		return this.autoRatFlg;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCdMtchFlg
	 */
	public String getCgoTpCdMtchFlg() {
		return this.cgoTpCdMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrTpCdMtchFlg
	 */
	public String getCntrTpCdMtchFlg() {
		return this.cntrTpCdMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return orgInlndHlgAmt
	 */
	public String getOrgInlndHlgAmt() {
		return this.orgInlndHlgAmt;
	}
	
	/**
	 * Column Info
	 * @return orgArbAmt
	 */
	public String getOrgArbAmt() {
		return this.orgArbAmt;
	}
	
	/**
	 * Column Info
	 * @return destArbAmt
	 */
	public String getDestArbAmt() {
		return this.destArbAmt;
	}
	
	/**
	 * Column Info
	 * @return destInlndHlgAmt
	 */
	public String getDestInlndHlgAmt() {
		return this.destInlndHlgAmt;
	}
	
	/**
	 * Column Info
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return grpCmdtNm
	 */
	public String getGrpCmdtNm() {
		return this.grpCmdtNm;
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
	 * @param grpCmdt
	 */
	public void setGrpCmdt(String grpCmdt) {
		this.grpCmdt = grpCmdt;
	}
	
	/**
	 * Column Info
	 * @param cntrSzCd
	 */
	public void setCntrSzCd(String cntrSzCd) {
		this.cntrSzCd = cntrSzCd;
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
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param rcvTMtchFlg
	 */
	public void setRcvTMtchFlg(String rcvTMtchFlg) {
		this.rcvTMtchFlg = rcvTMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param orgMtchFlg
	 */
	public void setOrgMtchFlg(String orgMtchFlg) {
		this.orgMtchFlg = orgMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param delTMtchFlg
	 */
	public void setDelTMtchFlg(String delTMtchFlg) {
		this.delTMtchFlg = delTMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param orgCntrSzCd
	 */
	public void setOrgCntrSzCd(String orgCntrSzCd) {
		this.orgCntrSzCd = orgCntrSzCd;
	}
	
	/**
	 * Column Info
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
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
	 * @param netAmtUsd
	 */
	public void setNetAmtUsd(String netAmtUsd) {
		this.netAmtUsd = netAmtUsd;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param aplyXchRto
	 */
	public void setAplyXchRto(String aplyXchRto) {
		this.aplyXchRto = aplyXchRto;
	}
	
	/**
	 * Column Info
	 * @param cntrTpCd
	 */
	public void setCntrTpCd(String cntrTpCd) {
		this.cntrTpCd = cntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param chgAmtUsd
	 */
	public void setChgAmtUsd(String chgAmtUsd) {
		this.chgAmtUsd = chgAmtUsd;
	}
	
	/**
	 * Column Info
	 * @param schgRt
	 */
	public void setSchgRt(String schgRt) {
		this.schgRt = schgRt;
	}
	
	/**
	 * Column Info
	 * @param orgViaMtchFlg
	 */
	public void setOrgViaMtchFlg(String orgViaMtchFlg) {
		this.orgViaMtchFlg = orgViaMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param destViaMtchFlg
	 */
	public void setDestViaMtchFlg(String destViaMtchFlg) {
		this.destViaMtchFlg = destViaMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param chgUtAmt
	 */
	public void setChgUtAmt(String chgUtAmt) {
		this.chgUtAmt = chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param baseRt
	 */
	public void setBaseRt(String baseRt) {
		this.baseRt = baseRt;
	}
	
	/**
	 * Column Info
	 * @param ttlRt
	 */
	public void setTtlRt(String ttlRt) {
		this.ttlRt = ttlRt;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param gohMtchFlg
	 */
	public void setGohMtchFlg(String gohMtchFlg) {
		this.gohMtchFlg = gohMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param socMtchFlg
	 */
	public void setSocMtchFlg(String socMtchFlg) {
		this.socMtchFlg = socMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param frtInclXcldDivCd
	 */
	public void setFrtInclXcldDivCd(String frtInclXcldDivCd) {
		this.frtInclXcldDivCd = frtInclXcldDivCd;
	}
	
	/**
	 * Column Info
	 * @param destMtchFlg
	 */
	public void setDestMtchFlg(String destMtchFlg) {
		this.destMtchFlg = destMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param ratAsQty
	 */
	public void setRatAsQty(String ratAsQty) {
		this.ratAsQty = ratAsQty;
	}
	
	/**
	 * Column Info
	 * @param cmdtSeq
	 */
	public void setCmdtSeq(String cmdtSeq) {
		this.cmdtSeq = cmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param gohAmt
	 */
	public void setGohAmt(String gohAmt) {
		this.gohAmt = gohAmt;
	}
	
	/**
	 * Column Info
	 * @param autoRatFlg
	 */
	public void setAutoRatFlg(String autoRatFlg) {
		this.autoRatFlg = autoRatFlg;
	}
	
	/**
	 * Column Info
	 * @param cgoTpCdMtchFlg
	 */
	public void setCgoTpCdMtchFlg(String cgoTpCdMtchFlg) {
		this.cgoTpCdMtchFlg = cgoTpCdMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrTpCdMtchFlg
	 */
	public void setCntrTpCdMtchFlg(String cntrTpCdMtchFlg) {
		this.cntrTpCdMtchFlg = cntrTpCdMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param orgInlndHlgAmt
	 */
	public void setOrgInlndHlgAmt(String orgInlndHlgAmt) {
		this.orgInlndHlgAmt = orgInlndHlgAmt;
	}
	
	/**
	 * Column Info
	 * @param orgArbAmt
	 */
	public void setOrgArbAmt(String orgArbAmt) {
		this.orgArbAmt = orgArbAmt;
	}
	
	/**
	 * Column Info
	 * @param destArbAmt
	 */
	public void setDestArbAmt(String destArbAmt) {
		this.destArbAmt = destArbAmt;
	}
	
	/**
	 * Column Info
	 * @param destInlndHlgAmt
	 */
	public void setDestInlndHlgAmt(String destInlndHlgAmt) {
		this.destInlndHlgAmt = destInlndHlgAmt;
	}
	
	/**
	 * Column Info
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param grpCmdtNm
	 */
	public void setGrpCmdtNm(String grpCmdtNm) {
		this.grpCmdtNm = grpCmdtNm;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setGrpCmdt(JSPUtil.getParameter(request, prefix + "grp_cmdt", ""));
		setCntrSzCd(JSPUtil.getParameter(request, prefix + "cntr_sz_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setRcvTMtchFlg(JSPUtil.getParameter(request, prefix + "rcv_t_mtch_flg", ""));
		setOrgMtchFlg(JSPUtil.getParameter(request, prefix + "org_mtch_flg", ""));
		setDelTMtchFlg(JSPUtil.getParameter(request, prefix + "del_t_mtch_flg", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setOrgCntrSzCd(JSPUtil.getParameter(request, prefix + "org_cntr_sz_cd", ""));
		setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNetAmtUsd(JSPUtil.getParameter(request, prefix + "net_amt_usd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAplyXchRto(JSPUtil.getParameter(request, prefix + "aply_xch_rto", ""));
		setCntrTpCd(JSPUtil.getParameter(request, prefix + "cntr_tp_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setChgAmtUsd(JSPUtil.getParameter(request, prefix + "chg_amt_usd", ""));
		setSchgRt(JSPUtil.getParameter(request, prefix + "schg_rt", ""));
		setOrgViaMtchFlg(JSPUtil.getParameter(request, prefix + "org_via_mtch_flg", ""));
		setDestViaMtchFlg(JSPUtil.getParameter(request, prefix + "dest_via_mtch_flg", ""));
		setChgUtAmt(JSPUtil.getParameter(request, prefix + "chg_ut_amt", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setBaseRt(JSPUtil.getParameter(request, prefix + "base_rt", ""));
		setTtlRt(JSPUtil.getParameter(request, prefix + "ttl_rt", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setGohMtchFlg(JSPUtil.getParameter(request, prefix + "goh_mtch_flg", ""));
		setSocMtchFlg(JSPUtil.getParameter(request, prefix + "soc_mtch_flg", ""));
		setFrtInclXcldDivCd(JSPUtil.getParameter(request, prefix + "frt_incl_xcld_div_cd", ""));
		setDestMtchFlg(JSPUtil.getParameter(request, prefix + "dest_mtch_flg", ""));
		setRatAsQty(JSPUtil.getParameter(request, prefix + "rat_as_qty", ""));
		setCmdtSeq(JSPUtil.getParameter(request, prefix + "cmdt_seq", ""));
		setGohAmt(JSPUtil.getParameter(request, prefix + "goh_amt", ""));
		setAutoRatFlg(JSPUtil.getParameter(request, prefix + "auto_rat_flg", ""));
		setCgoTpCdMtchFlg(JSPUtil.getParameter(request, prefix + "cgo_tp_cd_mtch_flg", ""));
		setCntrTpCdMtchFlg(JSPUtil.getParameter(request, prefix + "cntr_tp_cd_mtch_flg", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setOrgInlndHlgAmt(JSPUtil.getParameter(request, prefix + "org_inlnd_hlg_amt", ""));
		setOrgArbAmt(JSPUtil.getParameter(request, prefix + "org_arb_amt", ""));
		setDestArbAmt(JSPUtil.getParameter(request, prefix + "dest_arb_amt", ""));
		setDestInlndHlgAmt(JSPUtil.getParameter(request, prefix + "dest_inlnd_hlg_amt", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setGrpCmdtNm(JSPUtil.getParameter(request, prefix + "grp_cmdt_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AplyRtOutVO[]
	 */
	public AplyRtOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AplyRtOutVO[]
	 */
	public AplyRtOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AplyRtOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] grpCmdt = (JSPUtil.getParameter(request, prefix	+ "grp_cmdt", length));
			String[] cntrSzCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sz_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] rcvTMtchFlg = (JSPUtil.getParameter(request, prefix	+ "rcv_t_mtch_flg", length));
			String[] orgMtchFlg = (JSPUtil.getParameter(request, prefix	+ "org_mtch_flg", length));
			String[] delTMtchFlg = (JSPUtil.getParameter(request, prefix	+ "del_t_mtch_flg", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] orgCntrSzCd = (JSPUtil.getParameter(request, prefix	+ "org_cntr_sz_cd", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] netAmtUsd = (JSPUtil.getParameter(request, prefix	+ "net_amt_usd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aplyXchRto = (JSPUtil.getParameter(request, prefix	+ "aply_xch_rto", length));
			String[] cntrTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] chgAmtUsd = (JSPUtil.getParameter(request, prefix	+ "chg_amt_usd", length));
			String[] schgRt = (JSPUtil.getParameter(request, prefix	+ "schg_rt", length));
			String[] orgViaMtchFlg = (JSPUtil.getParameter(request, prefix	+ "org_via_mtch_flg", length));
			String[] destViaMtchFlg = (JSPUtil.getParameter(request, prefix	+ "dest_via_mtch_flg", length));
			String[] chgUtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ut_amt", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] baseRt = (JSPUtil.getParameter(request, prefix	+ "base_rt", length));
			String[] ttlRt = (JSPUtil.getParameter(request, prefix	+ "ttl_rt", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] gohMtchFlg = (JSPUtil.getParameter(request, prefix	+ "goh_mtch_flg", length));
			String[] socMtchFlg = (JSPUtil.getParameter(request, prefix	+ "soc_mtch_flg", length));
			String[] frtInclXcldDivCd = (JSPUtil.getParameter(request, prefix	+ "frt_incl_xcld_div_cd", length));
			String[] destMtchFlg = (JSPUtil.getParameter(request, prefix	+ "dest_mtch_flg", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			String[] cmdtSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_seq", length));
			String[] gohAmt = (JSPUtil.getParameter(request, prefix	+ "goh_amt", length));
			String[] autoRatFlg = (JSPUtil.getParameter(request, prefix	+ "auto_rat_flg", length));
			String[] cgoTpCdMtchFlg = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd_mtch_flg", length));
			String[] cntrTpCdMtchFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_cd_mtch_flg", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] orgInlndHlgAmt = (JSPUtil.getParameter(request, prefix	+ "org_inlnd_hlg_amt", length));
			String[] orgArbAmt = (JSPUtil.getParameter(request, prefix	+ "org_arb_amt", length));
			String[] destArbAmt = (JSPUtil.getParameter(request, prefix	+ "dest_arb_amt", length));
			String[] destInlndHlgAmt = (JSPUtil.getParameter(request, prefix	+ "dest_inlnd_hlg_amt", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] grpCmdtNm = (JSPUtil.getParameter(request, prefix	+ "grp_cmdt_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new AplyRtOutVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (grpCmdt[i] != null)
					model.setGrpCmdt(grpCmdt[i]);
				if (cntrSzCd[i] != null)
					model.setCntrSzCd(cntrSzCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (rcvTMtchFlg[i] != null)
					model.setRcvTMtchFlg(rcvTMtchFlg[i]);
				if (orgMtchFlg[i] != null)
					model.setOrgMtchFlg(orgMtchFlg[i]);
				if (delTMtchFlg[i] != null)
					model.setDelTMtchFlg(delTMtchFlg[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (orgCntrSzCd[i] != null)
					model.setOrgCntrSzCd(orgCntrSzCd[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (netAmtUsd[i] != null)
					model.setNetAmtUsd(netAmtUsd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aplyXchRto[i] != null)
					model.setAplyXchRto(aplyXchRto[i]);
				if (cntrTpCd[i] != null)
					model.setCntrTpCd(cntrTpCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (chgAmtUsd[i] != null)
					model.setChgAmtUsd(chgAmtUsd[i]);
				if (schgRt[i] != null)
					model.setSchgRt(schgRt[i]);
				if (orgViaMtchFlg[i] != null)
					model.setOrgViaMtchFlg(orgViaMtchFlg[i]);
				if (destViaMtchFlg[i] != null)
					model.setDestViaMtchFlg(destViaMtchFlg[i]);
				if (chgUtAmt[i] != null)
					model.setChgUtAmt(chgUtAmt[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (baseRt[i] != null)
					model.setBaseRt(baseRt[i]);
				if (ttlRt[i] != null)
					model.setTtlRt(ttlRt[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (gohMtchFlg[i] != null)
					model.setGohMtchFlg(gohMtchFlg[i]);
				if (socMtchFlg[i] != null)
					model.setSocMtchFlg(socMtchFlg[i]);
				if (frtInclXcldDivCd[i] != null)
					model.setFrtInclXcldDivCd(frtInclXcldDivCd[i]);
				if (destMtchFlg[i] != null)
					model.setDestMtchFlg(destMtchFlg[i]);
				if (ratAsQty[i] != null)
					model.setRatAsQty(ratAsQty[i]);
				if (cmdtSeq[i] != null)
					model.setCmdtSeq(cmdtSeq[i]);
				if (gohAmt[i] != null)
					model.setGohAmt(gohAmt[i]);
				if (autoRatFlg[i] != null)
					model.setAutoRatFlg(autoRatFlg[i]);
				if (cgoTpCdMtchFlg[i] != null)
					model.setCgoTpCdMtchFlg(cgoTpCdMtchFlg[i]);
				if (cntrTpCdMtchFlg[i] != null)
					model.setCntrTpCdMtchFlg(cntrTpCdMtchFlg[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (orgInlndHlgAmt[i] != null)
					model.setOrgInlndHlgAmt(orgInlndHlgAmt[i]);
				if (orgArbAmt[i] != null)
					model.setOrgArbAmt(orgArbAmt[i]);
				if (destArbAmt[i] != null)
					model.setDestArbAmt(destArbAmt[i]);
				if (destInlndHlgAmt[i] != null)
					model.setDestInlndHlgAmt(destInlndHlgAmt[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (grpCmdtNm[i] != null)
					model.setGrpCmdtNm(grpCmdtNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAplyRtOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AplyRtOutVO[]
	 */
	public AplyRtOutVO[] getAplyRtOutVOs(){
		AplyRtOutVO[] vos = (AplyRtOutVO[])models.toArray(new AplyRtOutVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCmdt = this.grpCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzCd = this.cntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTMtchFlg = this.rcvTMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMtchFlg = this.orgMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delTMtchFlg = this.delTMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCntrSzCd = this.orgCntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netAmtUsd = this.netAmtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyXchRto = this.aplyXchRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCd = this.cntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmtUsd = this.chgAmtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schgRt = this.schgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgViaMtchFlg = this.orgViaMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destViaMtchFlg = this.destViaMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgUtAmt = this.chgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.baseRt = this.baseRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlRt = this.ttlRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gohMtchFlg = this.gohMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socMtchFlg = this.socMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtInclXcldDivCd = this.frtInclXcldDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destMtchFlg = this.destMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtSeq = this.cmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gohAmt = this.gohAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRatFlg = this.autoRatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCdMtchFlg = this.cgoTpCdMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCdMtchFlg = this.cntrTpCdMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgInlndHlgAmt = this.orgInlndHlgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgArbAmt = this.orgArbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destArbAmt = this.destArbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destInlndHlgAmt = this.destInlndHlgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCmdtNm = this.grpCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
