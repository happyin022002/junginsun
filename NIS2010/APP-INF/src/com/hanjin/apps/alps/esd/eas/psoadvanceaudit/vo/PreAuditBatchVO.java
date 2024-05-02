/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PreAuditBatchVO.java
*@FileTitle : PreAuditBatchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.05
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.04.05 Arie 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo;

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
 * @author Arie
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PreAuditBatchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PreAuditBatchVO> models = new ArrayList<PreAuditBatchVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String fomlDesc = null;
	/* Column Info */
	private String expnAudRsltCd = null;
	/* Column Info */
	private String apPayDt = null;
	/* Column Info */
	private String atchFileLnkId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String autoExpnAudStsCd = null;
	/* Column Info */
	private String invCreUsrId = null;
	/* Column Info */
	private String brthHrs = null;
	/* Column Info */
	private String vslTrNo = null;
	/* Column Info */
	private String audRlstFlg = null;
	/* Column Info */
	private String payDueDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String depTugBotKnt = null;
	/* Column Info */
	private String portChgAudRsltUsrId = null;
	/* Column Info */
	private String portChgAudRsltRmk = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String portChgAudUsrId = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String dpIoBndCd = null;
	/* Column Info */
	private String toDatetime = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String adjAmt = null;
	/* Column Info */
	private String grsRgstTongWgt = null;
	/* Column Info */
	private String batchTpCd = null;
	/* Column Info */
	private String payTermDys = null;
	/* Column Info */
	private String selectFlg = null;
	/* Column Info */
	private String calcAmt = null;
	/* Column Info */
	private String portChgAudDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String diffAmt = null;
	/* Column Info */
	private String nightFlg = null;
	/* Column Info */
	private String soDtlSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String sRhqOfcCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String disInvOfcCd = null;
	/* Column Info */
	private String soSeq = null;
	/* Column Info */
	private String lstPortCd = null;
	/* Column Info */
	private String issCtyCd = null;
	/* Column Info */
	private String issDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sToDt = null;
	/* Column Info */
	private String portChgAudChkCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String eacIfFlg = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String sFmDt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String netRgstTongWgt = null;
	/* Column Info */
	private String invCfmDt = null;
	/* Column Info */
	private String suzGtWgt = null;
	/* Column Info */
	private String madnVoySuzNetTongWgt = null;
	/* Column Info */
	private String sdrXchRt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String cntrVslClssCapa = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String eacNo = null;
	/* Column Info */
	private String arrTugBotKnt = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String xprDesc = null;
	/* Column Info */
	private String stPortCd = null;
	/* Column Info */
	private String sel = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PreAuditBatchVO() {}

	public PreAuditBatchVO(String ibflag, String pagerows, String sel, String selectFlg, String issCtyCd, String soSeq, String soDtlSeq, String eacNo, String vslCd, String cntrVslClssCapa, String portChgAudChkCd, String autoExpnAudStsCd, String rhqCd, String invOfcCd, String port, String ydCd, String skdVoyNo, String skdDirCd, String vvd, String dpIoBndCd, String vpsEtbDt, String acctCd, String lgsCostCd, String vndrSeq, String invNo, String invCreUsrId, String issDt, String currCd, String calcAmt, String adjAmt, String invAmt, String diffAmt, String fomlDesc, String xprDesc, String diffRmk, String brthHrs, String stPortCd, String netRgstTongWgt, String arrTugBotKnt, String depTugBotKnt, String grsRgstTongWgt, String lstPortCd, String suzGtWgt, String madnVoySuzNetTongWgt, String nightFlg, String sdrXchRt, String vslTrNo, String updUsrId, String portChgAudUsrId, String portChgAudDt, String portChgAudRsltRmk, String portChgAudRsltUsrId, String payTermDys, String csrNo, String payDueDt, String apPayDt, String disInvOfcCd, String updDt, String atchFileLnkId, String expnAudRsltCd, String invCfmDt, String audRlstFlg, String eacIfFlg, String creUsrId, String batchTpCd, String toDatetime, String sFmDt, String sToDt, String sRhqOfcCd, String creOfcCd) {
		this.vslCd = vslCd;
		this.fomlDesc = fomlDesc;
		this.expnAudRsltCd = expnAudRsltCd;
		this.apPayDt = apPayDt;
		this.atchFileLnkId = atchFileLnkId;
		this.pagerows = pagerows;
		this.autoExpnAudStsCd = autoExpnAudStsCd;
		this.invCreUsrId = invCreUsrId;
		this.brthHrs = brthHrs;
		this.vslTrNo = vslTrNo;
		this.audRlstFlg = audRlstFlg;
		this.payDueDt = payDueDt;
		this.updUsrId = updUsrId;
		this.depTugBotKnt = depTugBotKnt;
		this.portChgAudRsltUsrId = portChgAudRsltUsrId;
		this.portChgAudRsltRmk = portChgAudRsltRmk;
		this.csrNo = csrNo;
		this.portChgAudUsrId = portChgAudUsrId;
		this.rhqCd = rhqCd;
		this.dpIoBndCd = dpIoBndCd;
		this.toDatetime = toDatetime;
		this.skdVoyNo = skdVoyNo;
		this.adjAmt = adjAmt;
		this.grsRgstTongWgt = grsRgstTongWgt;
		this.batchTpCd = batchTpCd;
		this.payTermDys = payTermDys;
		this.selectFlg = selectFlg;
		this.calcAmt = calcAmt;
		this.portChgAudDt = portChgAudDt;
		this.vvd = vvd;
		this.creUsrId = creUsrId;
		this.diffAmt = diffAmt;
		this.nightFlg = nightFlg;
		this.soDtlSeq = soDtlSeq;
		this.vndrSeq = vndrSeq;
		this.port = port;
		this.sRhqOfcCd = sRhqOfcCd;
		this.vpsEtbDt = vpsEtbDt;
		this.currCd = currCd;
		this.disInvOfcCd = disInvOfcCd;
		this.soSeq = soSeq;
		this.lstPortCd = lstPortCd;
		this.issCtyCd = issCtyCd;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.sToDt = sToDt;
		this.portChgAudChkCd = portChgAudChkCd;
		this.creOfcCd = creOfcCd;
		this.eacIfFlg = eacIfFlg;
		this.acctCd = acctCd;
		this.invAmt = invAmt;
		this.sFmDt = sFmDt;
		this.invOfcCd = invOfcCd;
		this.updDt = updDt;
		this.netRgstTongWgt = netRgstTongWgt;
		this.invCfmDt = invCfmDt;
		this.suzGtWgt = suzGtWgt;
		this.madnVoySuzNetTongWgt = madnVoySuzNetTongWgt;
		this.sdrXchRt = sdrXchRt;
		this.skdDirCd = skdDirCd;
		this.cntrVslClssCapa = cntrVslClssCapa;
		this.invNo = invNo;
		this.eacNo = eacNo;
		this.arrTugBotKnt = arrTugBotKnt;
		this.diffRmk = diffRmk;
		this.ydCd = ydCd;
		this.lgsCostCd = lgsCostCd;
		this.xprDesc = xprDesc;
		this.stPortCd = stPortCd;
		this.sel = sel;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("foml_desc", getFomlDesc());
		this.hashColumns.put("expn_aud_rslt_cd", getExpnAudRsltCd());
		this.hashColumns.put("ap_pay_dt", getApPayDt());
		this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("auto_expn_aud_sts_cd", getAutoExpnAudStsCd());
		this.hashColumns.put("inv_cre_usr_id", getInvCreUsrId());
		this.hashColumns.put("brth_hrs", getBrthHrs());
		this.hashColumns.put("vsl_tr_no", getVslTrNo());
		this.hashColumns.put("aud_rlst_flg", getAudRlstFlg());
		this.hashColumns.put("pay_due_dt", getPayDueDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dep_tug_bot_knt", getDepTugBotKnt());
		this.hashColumns.put("port_chg_aud_rslt_usr_id", getPortChgAudRsltUsrId());
		this.hashColumns.put("port_chg_aud_rslt_rmk", getPortChgAudRsltRmk());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("port_chg_aud_usr_id", getPortChgAudUsrId());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("dp_io_bnd_cd", getDpIoBndCd());
		this.hashColumns.put("to_datetime", getToDatetime());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("adj_amt", getAdjAmt());
		this.hashColumns.put("grs_rgst_tong_wgt", getGrsRgstTongWgt());
		this.hashColumns.put("batch_tp_cd", getBatchTpCd());
		this.hashColumns.put("pay_term_dys", getPayTermDys());
		this.hashColumns.put("select_flg", getSelectFlg());
		this.hashColumns.put("calc_amt", getCalcAmt());
		this.hashColumns.put("port_chg_aud_dt", getPortChgAudDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("diff_amt", getDiffAmt());
		this.hashColumns.put("night_flg", getNightFlg());
		this.hashColumns.put("so_dtl_seq", getSoDtlSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("dis_inv_ofc_cd", getDisInvOfcCd());
		this.hashColumns.put("so_seq", getSoSeq());
		this.hashColumns.put("lst_port_cd", getLstPortCd());
		this.hashColumns.put("iss_cty_cd", getIssCtyCd());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_to_dt", getSToDt());
		this.hashColumns.put("port_chg_aud_chk_cd", getPortChgAudChkCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("eac_if_flg", getEacIfFlg());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("s_fm_dt", getSFmDt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("net_rgst_tong_wgt", getNetRgstTongWgt());
		this.hashColumns.put("inv_cfm_dt", getInvCfmDt());
		this.hashColumns.put("suz_gt_wgt", getSuzGtWgt());
		this.hashColumns.put("madn_voy_suz_net_tong_wgt", getMadnVoySuzNetTongWgt());
		this.hashColumns.put("sdr_xch_rt", getSdrXchRt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cntr_vsl_clss_capa", getCntrVslClssCapa());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("eac_no", getEacNo());
		this.hashColumns.put("arr_tug_bot_knt", getArrTugBotKnt());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("xpr_desc", getXprDesc());
		this.hashColumns.put("st_port_cd", getStPortCd());
		this.hashColumns.put("sel", getSel());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("foml_desc", "fomlDesc");
		this.hashFields.put("expn_aud_rslt_cd", "expnAudRsltCd");
		this.hashFields.put("ap_pay_dt", "apPayDt");
		this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("auto_expn_aud_sts_cd", "autoExpnAudStsCd");
		this.hashFields.put("inv_cre_usr_id", "invCreUsrId");
		this.hashFields.put("brth_hrs", "brthHrs");
		this.hashFields.put("vsl_tr_no", "vslTrNo");
		this.hashFields.put("aud_rlst_flg", "audRlstFlg");
		this.hashFields.put("pay_due_dt", "payDueDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dep_tug_bot_knt", "depTugBotKnt");
		this.hashFields.put("port_chg_aud_rslt_usr_id", "portChgAudRsltUsrId");
		this.hashFields.put("port_chg_aud_rslt_rmk", "portChgAudRsltRmk");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("port_chg_aud_usr_id", "portChgAudUsrId");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("dp_io_bnd_cd", "dpIoBndCd");
		this.hashFields.put("to_datetime", "toDatetime");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("adj_amt", "adjAmt");
		this.hashFields.put("grs_rgst_tong_wgt", "grsRgstTongWgt");
		this.hashFields.put("batch_tp_cd", "batchTpCd");
		this.hashFields.put("pay_term_dys", "payTermDys");
		this.hashFields.put("select_flg", "selectFlg");
		this.hashFields.put("calc_amt", "calcAmt");
		this.hashFields.put("port_chg_aud_dt", "portChgAudDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_amt", "diffAmt");
		this.hashFields.put("night_flg", "nightFlg");
		this.hashFields.put("so_dtl_seq", "soDtlSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("port", "port");
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("dis_inv_ofc_cd", "disInvOfcCd");
		this.hashFields.put("so_seq", "soSeq");
		this.hashFields.put("lst_port_cd", "lstPortCd");
		this.hashFields.put("iss_cty_cd", "issCtyCd");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_to_dt", "sToDt");
		this.hashFields.put("port_chg_aud_chk_cd", "portChgAudChkCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("eac_if_flg", "eacIfFlg");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("s_fm_dt", "sFmDt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("net_rgst_tong_wgt", "netRgstTongWgt");
		this.hashFields.put("inv_cfm_dt", "invCfmDt");
		this.hashFields.put("suz_gt_wgt", "suzGtWgt");
		this.hashFields.put("madn_voy_suz_net_tong_wgt", "madnVoySuzNetTongWgt");
		this.hashFields.put("sdr_xch_rt", "sdrXchRt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cntr_vsl_clss_capa", "cntrVslClssCapa");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("eac_no", "eacNo");
		this.hashFields.put("arr_tug_bot_knt", "arrTugBotKnt");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("xpr_desc", "xprDesc");
		this.hashFields.put("st_port_cd", "stPortCd");
		this.hashFields.put("sel", "sel");
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
	 * @return fomlDesc
	 */
	public String getFomlDesc() {
		return this.fomlDesc;
	}
	
	/**
	 * Column Info
	 * @return expnAudRsltCd
	 */
	public String getExpnAudRsltCd() {
		return this.expnAudRsltCd;
	}
	
	/**
	 * Column Info
	 * @return apPayDt
	 */
	public String getApPayDt() {
		return this.apPayDt;
	}
	
	/**
	 * Column Info
	 * @return atchFileLnkId
	 */
	public String getAtchFileLnkId() {
		return this.atchFileLnkId;
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
	 * @return autoExpnAudStsCd
	 */
	public String getAutoExpnAudStsCd() {
		return this.autoExpnAudStsCd;
	}
	
	/**
	 * Column Info
	 * @return invCreUsrId
	 */
	public String getInvCreUsrId() {
		return this.invCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return brthHrs
	 */
	public String getBrthHrs() {
		return this.brthHrs;
	}
	
	/**
	 * Column Info
	 * @return vslTrNo
	 */
	public String getVslTrNo() {
		return this.vslTrNo;
	}
	
	/**
	 * Column Info
	 * @return audRlstFlg
	 */
	public String getAudRlstFlg() {
		return this.audRlstFlg;
	}
	
	/**
	 * Column Info
	 * @return payDueDt
	 */
	public String getPayDueDt() {
		return this.payDueDt;
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
	 * @return depTugBotKnt
	 */
	public String getDepTugBotKnt() {
		return this.depTugBotKnt;
	}
	
	/**
	 * Column Info
	 * @return portChgAudRsltUsrId
	 */
	public String getPortChgAudRsltUsrId() {
		return this.portChgAudRsltUsrId;
	}
	
	/**
	 * Column Info
	 * @return portChgAudRsltRmk
	 */
	public String getPortChgAudRsltRmk() {
		return this.portChgAudRsltRmk;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return portChgAudUsrId
	 */
	public String getPortChgAudUsrId() {
		return this.portChgAudUsrId;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return dpIoBndCd
	 */
	public String getDpIoBndCd() {
		return this.dpIoBndCd;
	}
	
	/**
	 * Column Info
	 * @return toDatetime
	 */
	public String getToDatetime() {
		return this.toDatetime;
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
	 * @return adjAmt
	 */
	public String getAdjAmt() {
		return this.adjAmt;
	}
	
	/**
	 * Column Info
	 * @return grsRgstTongWgt
	 */
	public String getGrsRgstTongWgt() {
		return this.grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return batchTpCd
	 */
	public String getBatchTpCd() {
		return this.batchTpCd;
	}
	
	/**
	 * Column Info
	 * @return payTermDys
	 */
	public String getPayTermDys() {
		return this.payTermDys;
	}
	
	/**
	 * Column Info
	 * @return selectFlg
	 */
	public String getSelectFlg() {
		return this.selectFlg;
	}
	
	/**
	 * Column Info
	 * @return calcAmt
	 */
	public String getCalcAmt() {
		return this.calcAmt;
	}
	
	/**
	 * Column Info
	 * @return portChgAudDt
	 */
	public String getPortChgAudDt() {
		return this.portChgAudDt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return diffAmt
	 */
	public String getDiffAmt() {
		return this.diffAmt;
	}
	
	/**
	 * Column Info
	 * @return nightFlg
	 */
	public String getNightFlg() {
		return this.nightFlg;
	}
	
	/**
	 * Column Info
	 * @return soDtlSeq
	 */
	public String getSoDtlSeq() {
		return this.soDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return sRhqOfcCd
	 */
	public String getSRhqOfcCd() {
		return this.sRhqOfcCd;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return disInvOfcCd
	 */
	public String getDisInvOfcCd() {
		return this.disInvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return soSeq
	 */
	public String getSoSeq() {
		return this.soSeq;
	}
	
	/**
	 * Column Info
	 * @return lstPortCd
	 */
	public String getLstPortCd() {
		return this.lstPortCd;
	}
	
	/**
	 * Column Info
	 * @return issCtyCd
	 */
	public String getIssCtyCd() {
		return this.issCtyCd;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
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
	 * @return sToDt
	 */
	public String getSToDt() {
		return this.sToDt;
	}
	
	/**
	 * Column Info
	 * @return portChgAudChkCd
	 */
	public String getPortChgAudChkCd() {
		return this.portChgAudChkCd;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eacIfFlg
	 */
	public String getEacIfFlg() {
		return this.eacIfFlg;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return sFmDt
	 */
	public String getSFmDt() {
		return this.sFmDt;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
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
	 * @return netRgstTongWgt
	 */
	public String getNetRgstTongWgt() {
		return this.netRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return invCfmDt
	 */
	public String getInvCfmDt() {
		return this.invCfmDt;
	}
	
	/**
	 * Column Info
	 * @return suzGtWgt
	 */
	public String getSuzGtWgt() {
		return this.suzGtWgt;
	}
	
	/**
	 * Column Info
	 * @return madnVoySuzNetTongWgt
	 */
	public String getMadnVoySuzNetTongWgt() {
		return this.madnVoySuzNetTongWgt;
	}
	
	/**
	 * Column Info
	 * @return sdrXchRt
	 */
	public String getSdrXchRt() {
		return this.sdrXchRt;
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
	 * @return cntrVslClssCapa
	 */
	public String getCntrVslClssCapa() {
		return this.cntrVslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return eacNo
	 */
	public String getEacNo() {
		return this.eacNo;
	}
	
	/**
	 * Column Info
	 * @return arrTugBotKnt
	 */
	public String getArrTugBotKnt() {
		return this.arrTugBotKnt;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
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
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return xprDesc
	 */
	public String getXprDesc() {
		return this.xprDesc;
	}
	
	/**
	 * Column Info
	 * @return stPortCd
	 */
	public String getStPortCd() {
		return this.stPortCd;
	}
	
	/**
	 * Column Info
	 * @return sel
	 */
	public String getSel() {
		return this.sel;
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
	 * @param fomlDesc
	 */
	public void setFomlDesc(String fomlDesc) {
		this.fomlDesc = fomlDesc;
	}
	
	/**
	 * Column Info
	 * @param expnAudRsltCd
	 */
	public void setExpnAudRsltCd(String expnAudRsltCd) {
		this.expnAudRsltCd = expnAudRsltCd;
	}
	
	/**
	 * Column Info
	 * @param apPayDt
	 */
	public void setApPayDt(String apPayDt) {
		this.apPayDt = apPayDt;
	}
	
	/**
	 * Column Info
	 * @param atchFileLnkId
	 */
	public void setAtchFileLnkId(String atchFileLnkId) {
		this.atchFileLnkId = atchFileLnkId;
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
	 * @param autoExpnAudStsCd
	 */
	public void setAutoExpnAudStsCd(String autoExpnAudStsCd) {
		this.autoExpnAudStsCd = autoExpnAudStsCd;
	}
	
	/**
	 * Column Info
	 * @param invCreUsrId
	 */
	public void setInvCreUsrId(String invCreUsrId) {
		this.invCreUsrId = invCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param brthHrs
	 */
	public void setBrthHrs(String brthHrs) {
		this.brthHrs = brthHrs;
	}
	
	/**
	 * Column Info
	 * @param vslTrNo
	 */
	public void setVslTrNo(String vslTrNo) {
		this.vslTrNo = vslTrNo;
	}
	
	/**
	 * Column Info
	 * @param audRlstFlg
	 */
	public void setAudRlstFlg(String audRlstFlg) {
		this.audRlstFlg = audRlstFlg;
	}
	
	/**
	 * Column Info
	 * @param payDueDt
	 */
	public void setPayDueDt(String payDueDt) {
		this.payDueDt = payDueDt;
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
	 * @param depTugBotKnt
	 */
	public void setDepTugBotKnt(String depTugBotKnt) {
		this.depTugBotKnt = depTugBotKnt;
	}
	
	/**
	 * Column Info
	 * @param portChgAudRsltUsrId
	 */
	public void setPortChgAudRsltUsrId(String portChgAudRsltUsrId) {
		this.portChgAudRsltUsrId = portChgAudRsltUsrId;
	}
	
	/**
	 * Column Info
	 * @param portChgAudRsltRmk
	 */
	public void setPortChgAudRsltRmk(String portChgAudRsltRmk) {
		this.portChgAudRsltRmk = portChgAudRsltRmk;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param portChgAudUsrId
	 */
	public void setPortChgAudUsrId(String portChgAudUsrId) {
		this.portChgAudUsrId = portChgAudUsrId;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param dpIoBndCd
	 */
	public void setDpIoBndCd(String dpIoBndCd) {
		this.dpIoBndCd = dpIoBndCd;
	}
	
	/**
	 * Column Info
	 * @param toDatetime
	 */
	public void setToDatetime(String toDatetime) {
		this.toDatetime = toDatetime;
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
	 * @param adjAmt
	 */
	public void setAdjAmt(String adjAmt) {
		this.adjAmt = adjAmt;
	}
	
	/**
	 * Column Info
	 * @param grsRgstTongWgt
	 */
	public void setGrsRgstTongWgt(String grsRgstTongWgt) {
		this.grsRgstTongWgt = grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param batchTpCd
	 */
	public void setBatchTpCd(String batchTpCd) {
		this.batchTpCd = batchTpCd;
	}
	
	/**
	 * Column Info
	 * @param payTermDys
	 */
	public void setPayTermDys(String payTermDys) {
		this.payTermDys = payTermDys;
	}
	
	/**
	 * Column Info
	 * @param selectFlg
	 */
	public void setSelectFlg(String selectFlg) {
		this.selectFlg = selectFlg;
	}
	
	/**
	 * Column Info
	 * @param calcAmt
	 */
	public void setCalcAmt(String calcAmt) {
		this.calcAmt = calcAmt;
	}
	
	/**
	 * Column Info
	 * @param portChgAudDt
	 */
	public void setPortChgAudDt(String portChgAudDt) {
		this.portChgAudDt = portChgAudDt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param diffAmt
	 */
	public void setDiffAmt(String diffAmt) {
		this.diffAmt = diffAmt;
	}
	
	/**
	 * Column Info
	 * @param nightFlg
	 */
	public void setNightFlg(String nightFlg) {
		this.nightFlg = nightFlg;
	}
	
	/**
	 * Column Info
	 * @param soDtlSeq
	 */
	public void setSoDtlSeq(String soDtlSeq) {
		this.soDtlSeq = soDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param sRhqOfcCd
	 */
	public void setSRhqOfcCd(String sRhqOfcCd) {
		this.sRhqOfcCd = sRhqOfcCd;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param disInvOfcCd
	 */
	public void setDisInvOfcCd(String disInvOfcCd) {
		this.disInvOfcCd = disInvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param soSeq
	 */
	public void setSoSeq(String soSeq) {
		this.soSeq = soSeq;
	}
	
	/**
	 * Column Info
	 * @param lstPortCd
	 */
	public void setLstPortCd(String lstPortCd) {
		this.lstPortCd = lstPortCd;
	}
	
	/**
	 * Column Info
	 * @param issCtyCd
	 */
	public void setIssCtyCd(String issCtyCd) {
		this.issCtyCd = issCtyCd;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
	 * @param sToDt
	 */
	public void setSToDt(String sToDt) {
		this.sToDt = sToDt;
	}
	
	/**
	 * Column Info
	 * @param portChgAudChkCd
	 */
	public void setPortChgAudChkCd(String portChgAudChkCd) {
		this.portChgAudChkCd = portChgAudChkCd;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eacIfFlg
	 */
	public void setEacIfFlg(String eacIfFlg) {
		this.eacIfFlg = eacIfFlg;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param sFmDt
	 */
	public void setSFmDt(String sFmDt) {
		this.sFmDt = sFmDt;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
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
	 * @param netRgstTongWgt
	 */
	public void setNetRgstTongWgt(String netRgstTongWgt) {
		this.netRgstTongWgt = netRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param invCfmDt
	 */
	public void setInvCfmDt(String invCfmDt) {
		this.invCfmDt = invCfmDt;
	}
	
	/**
	 * Column Info
	 * @param suzGtWgt
	 */
	public void setSuzGtWgt(String suzGtWgt) {
		this.suzGtWgt = suzGtWgt;
	}
	
	/**
	 * Column Info
	 * @param madnVoySuzNetTongWgt
	 */
	public void setMadnVoySuzNetTongWgt(String madnVoySuzNetTongWgt) {
		this.madnVoySuzNetTongWgt = madnVoySuzNetTongWgt;
	}
	
	/**
	 * Column Info
	 * @param sdrXchRt
	 */
	public void setSdrXchRt(String sdrXchRt) {
		this.sdrXchRt = sdrXchRt;
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
	 * @param cntrVslClssCapa
	 */
	public void setCntrVslClssCapa(String cntrVslClssCapa) {
		this.cntrVslClssCapa = cntrVslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param eacNo
	 */
	public void setEacNo(String eacNo) {
		this.eacNo = eacNo;
	}
	
	/**
	 * Column Info
	 * @param arrTugBotKnt
	 */
	public void setArrTugBotKnt(String arrTugBotKnt) {
		this.arrTugBotKnt = arrTugBotKnt;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
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
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param xprDesc
	 */
	public void setXprDesc(String xprDesc) {
		this.xprDesc = xprDesc;
	}
	
	/**
	 * Column Info
	 * @param stPortCd
	 */
	public void setStPortCd(String stPortCd) {
		this.stPortCd = stPortCd;
	}
	
	/**
	 * Column Info
	 * @param sel
	 */
	public void setSel(String sel) {
		this.sel = sel;
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
		setFomlDesc(JSPUtil.getParameter(request, prefix + "foml_desc", ""));
		setExpnAudRsltCd(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_cd", ""));
		setApPayDt(JSPUtil.getParameter(request, prefix + "ap_pay_dt", ""));
		setAtchFileLnkId(JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAutoExpnAudStsCd(JSPUtil.getParameter(request, prefix + "auto_expn_aud_sts_cd", ""));
		setInvCreUsrId(JSPUtil.getParameter(request, prefix + "inv_cre_usr_id", ""));
		setBrthHrs(JSPUtil.getParameter(request, prefix + "brth_hrs", ""));
		setVslTrNo(JSPUtil.getParameter(request, prefix + "vsl_tr_no", ""));
		setAudRlstFlg(JSPUtil.getParameter(request, prefix + "aud_rlst_flg", ""));
		setPayDueDt(JSPUtil.getParameter(request, prefix + "pay_due_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDepTugBotKnt(JSPUtil.getParameter(request, prefix + "dep_tug_bot_knt", ""));
		setPortChgAudRsltUsrId(JSPUtil.getParameter(request, prefix + "port_chg_aud_rslt_usr_id", ""));
		setPortChgAudRsltRmk(JSPUtil.getParameter(request, prefix + "port_chg_aud_rslt_rmk", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setPortChgAudUsrId(JSPUtil.getParameter(request, prefix + "port_chg_aud_usr_id", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setDpIoBndCd(JSPUtil.getParameter(request, prefix + "dp_io_bnd_cd", ""));
		setToDatetime(JSPUtil.getParameter(request, prefix + "to_datetime", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setAdjAmt(JSPUtil.getParameter(request, prefix + "adj_amt", ""));
		setGrsRgstTongWgt(JSPUtil.getParameter(request, prefix + "grs_rgst_tong_wgt", ""));
		setBatchTpCd(JSPUtil.getParameter(request, prefix + "batch_tp_cd", ""));
		setPayTermDys(JSPUtil.getParameter(request, prefix + "pay_term_dys", ""));
		setSelectFlg(JSPUtil.getParameter(request, prefix + "select_flg", ""));
		setCalcAmt(JSPUtil.getParameter(request, prefix + "calc_amt", ""));
		setPortChgAudDt(JSPUtil.getParameter(request, prefix + "port_chg_aud_dt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDiffAmt(JSPUtil.getParameter(request, prefix + "diff_amt", ""));
		setNightFlg(JSPUtil.getParameter(request, prefix + "night_flg", ""));
		setSoDtlSeq(JSPUtil.getParameter(request, prefix + "so_dtl_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDisInvOfcCd(JSPUtil.getParameter(request, prefix + "dis_inv_ofc_cd", ""));
		setSoSeq(JSPUtil.getParameter(request, prefix + "so_seq", ""));
		setLstPortCd(JSPUtil.getParameter(request, prefix + "lst_port_cd", ""));
		setIssCtyCd(JSPUtil.getParameter(request, prefix + "iss_cty_cd", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSToDt(JSPUtil.getParameter(request, prefix + "s_to_dt", ""));
		setPortChgAudChkCd(JSPUtil.getParameter(request, prefix + "port_chg_aud_chk_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setEacIfFlg(JSPUtil.getParameter(request, prefix + "eac_if_flg", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setSFmDt(JSPUtil.getParameter(request, prefix + "s_fm_dt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setNetRgstTongWgt(JSPUtil.getParameter(request, prefix + "net_rgst_tong_wgt", ""));
		setInvCfmDt(JSPUtil.getParameter(request, prefix + "inv_cfm_dt", ""));
		setSuzGtWgt(JSPUtil.getParameter(request, prefix + "suz_gt_wgt", ""));
		setMadnVoySuzNetTongWgt(JSPUtil.getParameter(request, prefix + "madn_voy_suz_net_tong_wgt", ""));
		setSdrXchRt(JSPUtil.getParameter(request, prefix + "sdr_xch_rt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCntrVslClssCapa(JSPUtil.getParameter(request, prefix + "cntr_vsl_clss_capa", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setEacNo(JSPUtil.getParameter(request, prefix + "eac_no", ""));
		setArrTugBotKnt(JSPUtil.getParameter(request, prefix + "arr_tug_bot_knt", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setXprDesc(JSPUtil.getParameter(request, prefix + "xpr_desc", ""));
		setStPortCd(JSPUtil.getParameter(request, prefix + "st_port_cd", ""));
		setSel(JSPUtil.getParameter(request, prefix + "sel", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PreAuditBatchVO[]
	 */
	public PreAuditBatchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PreAuditBatchVO[]
	 */
	public PreAuditBatchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PreAuditBatchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] fomlDesc = (JSPUtil.getParameter(request, prefix	+ "foml_desc", length));
			String[] expnAudRsltCd = (JSPUtil.getParameter(request, prefix	+ "expn_aud_rslt_cd", length));
			String[] apPayDt = (JSPUtil.getParameter(request, prefix	+ "ap_pay_dt", length));
			String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_lnk_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] autoExpnAudStsCd = (JSPUtil.getParameter(request, prefix	+ "auto_expn_aud_sts_cd", length));
			String[] invCreUsrId = (JSPUtil.getParameter(request, prefix	+ "inv_cre_usr_id", length));
			String[] brthHrs = (JSPUtil.getParameter(request, prefix	+ "brth_hrs", length));
			String[] vslTrNo = (JSPUtil.getParameter(request, prefix	+ "vsl_tr_no", length));
			String[] audRlstFlg = (JSPUtil.getParameter(request, prefix	+ "aud_rlst_flg", length));
			String[] payDueDt = (JSPUtil.getParameter(request, prefix	+ "pay_due_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] depTugBotKnt = (JSPUtil.getParameter(request, prefix	+ "dep_tug_bot_knt", length));
			String[] portChgAudRsltUsrId = (JSPUtil.getParameter(request, prefix	+ "port_chg_aud_rslt_usr_id", length));
			String[] portChgAudRsltRmk = (JSPUtil.getParameter(request, prefix	+ "port_chg_aud_rslt_rmk", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] portChgAudUsrId = (JSPUtil.getParameter(request, prefix	+ "port_chg_aud_usr_id", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] dpIoBndCd = (JSPUtil.getParameter(request, prefix	+ "dp_io_bnd_cd", length));
			String[] toDatetime = (JSPUtil.getParameter(request, prefix	+ "to_datetime", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] adjAmt = (JSPUtil.getParameter(request, prefix	+ "adj_amt", length));
			String[] grsRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "grs_rgst_tong_wgt", length));
			String[] batchTpCd = (JSPUtil.getParameter(request, prefix	+ "batch_tp_cd", length));
			String[] payTermDys = (JSPUtil.getParameter(request, prefix	+ "pay_term_dys", length));
			String[] selectFlg = (JSPUtil.getParameter(request, prefix	+ "select_flg", length));
			String[] calcAmt = (JSPUtil.getParameter(request, prefix	+ "calc_amt", length));
			String[] portChgAudDt = (JSPUtil.getParameter(request, prefix	+ "port_chg_aud_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] diffAmt = (JSPUtil.getParameter(request, prefix	+ "diff_amt", length));
			String[] nightFlg = (JSPUtil.getParameter(request, prefix	+ "night_flg", length));
			String[] soDtlSeq = (JSPUtil.getParameter(request, prefix	+ "so_dtl_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] disInvOfcCd = (JSPUtil.getParameter(request, prefix	+ "dis_inv_ofc_cd", length));
			String[] soSeq = (JSPUtil.getParameter(request, prefix	+ "so_seq", length));
			String[] lstPortCd = (JSPUtil.getParameter(request, prefix	+ "lst_port_cd", length));
			String[] issCtyCd = (JSPUtil.getParameter(request, prefix	+ "iss_cty_cd", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sToDt = (JSPUtil.getParameter(request, prefix	+ "s_to_dt", length));
			String[] portChgAudChkCd = (JSPUtil.getParameter(request, prefix	+ "port_chg_aud_chk_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] eacIfFlg = (JSPUtil.getParameter(request, prefix	+ "eac_if_flg", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] sFmDt = (JSPUtil.getParameter(request, prefix	+ "s_fm_dt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] netRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "net_rgst_tong_wgt", length));
			String[] invCfmDt = (JSPUtil.getParameter(request, prefix	+ "inv_cfm_dt", length));
			String[] suzGtWgt = (JSPUtil.getParameter(request, prefix	+ "suz_gt_wgt", length));
			String[] madnVoySuzNetTongWgt = (JSPUtil.getParameter(request, prefix	+ "madn_voy_suz_net_tong_wgt", length));
			String[] sdrXchRt = (JSPUtil.getParameter(request, prefix	+ "sdr_xch_rt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cntrVslClssCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_vsl_clss_capa", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] eacNo = (JSPUtil.getParameter(request, prefix	+ "eac_no", length));
			String[] arrTugBotKnt = (JSPUtil.getParameter(request, prefix	+ "arr_tug_bot_knt", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] xprDesc = (JSPUtil.getParameter(request, prefix	+ "xpr_desc", length));
			String[] stPortCd = (JSPUtil.getParameter(request, prefix	+ "st_port_cd", length));
			String[] sel = (JSPUtil.getParameter(request, prefix	+ "sel", length));
			
			for (int i = 0; i < length; i++) {
				model = new PreAuditBatchVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (fomlDesc[i] != null)
					model.setFomlDesc(fomlDesc[i]);
				if (expnAudRsltCd[i] != null)
					model.setExpnAudRsltCd(expnAudRsltCd[i]);
				if (apPayDt[i] != null)
					model.setApPayDt(apPayDt[i]);
				if (atchFileLnkId[i] != null)
					model.setAtchFileLnkId(atchFileLnkId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (autoExpnAudStsCd[i] != null)
					model.setAutoExpnAudStsCd(autoExpnAudStsCd[i]);
				if (invCreUsrId[i] != null)
					model.setInvCreUsrId(invCreUsrId[i]);
				if (brthHrs[i] != null)
					model.setBrthHrs(brthHrs[i]);
				if (vslTrNo[i] != null)
					model.setVslTrNo(vslTrNo[i]);
				if (audRlstFlg[i] != null)
					model.setAudRlstFlg(audRlstFlg[i]);
				if (payDueDt[i] != null)
					model.setPayDueDt(payDueDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (depTugBotKnt[i] != null)
					model.setDepTugBotKnt(depTugBotKnt[i]);
				if (portChgAudRsltUsrId[i] != null)
					model.setPortChgAudRsltUsrId(portChgAudRsltUsrId[i]);
				if (portChgAudRsltRmk[i] != null)
					model.setPortChgAudRsltRmk(portChgAudRsltRmk[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (portChgAudUsrId[i] != null)
					model.setPortChgAudUsrId(portChgAudUsrId[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (dpIoBndCd[i] != null)
					model.setDpIoBndCd(dpIoBndCd[i]);
				if (toDatetime[i] != null)
					model.setToDatetime(toDatetime[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (adjAmt[i] != null)
					model.setAdjAmt(adjAmt[i]);
				if (grsRgstTongWgt[i] != null)
					model.setGrsRgstTongWgt(grsRgstTongWgt[i]);
				if (batchTpCd[i] != null)
					model.setBatchTpCd(batchTpCd[i]);
				if (payTermDys[i] != null)
					model.setPayTermDys(payTermDys[i]);
				if (selectFlg[i] != null)
					model.setSelectFlg(selectFlg[i]);
				if (calcAmt[i] != null)
					model.setCalcAmt(calcAmt[i]);
				if (portChgAudDt[i] != null)
					model.setPortChgAudDt(portChgAudDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (diffAmt[i] != null)
					model.setDiffAmt(diffAmt[i]);
				if (nightFlg[i] != null)
					model.setNightFlg(nightFlg[i]);
				if (soDtlSeq[i] != null)
					model.setSoDtlSeq(soDtlSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (disInvOfcCd[i] != null)
					model.setDisInvOfcCd(disInvOfcCd[i]);
				if (soSeq[i] != null)
					model.setSoSeq(soSeq[i]);
				if (lstPortCd[i] != null)
					model.setLstPortCd(lstPortCd[i]);
				if (issCtyCd[i] != null)
					model.setIssCtyCd(issCtyCd[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sToDt[i] != null)
					model.setSToDt(sToDt[i]);
				if (portChgAudChkCd[i] != null)
					model.setPortChgAudChkCd(portChgAudChkCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (eacIfFlg[i] != null)
					model.setEacIfFlg(eacIfFlg[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (sFmDt[i] != null)
					model.setSFmDt(sFmDt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (netRgstTongWgt[i] != null)
					model.setNetRgstTongWgt(netRgstTongWgt[i]);
				if (invCfmDt[i] != null)
					model.setInvCfmDt(invCfmDt[i]);
				if (suzGtWgt[i] != null)
					model.setSuzGtWgt(suzGtWgt[i]);
				if (madnVoySuzNetTongWgt[i] != null)
					model.setMadnVoySuzNetTongWgt(madnVoySuzNetTongWgt[i]);
				if (sdrXchRt[i] != null)
					model.setSdrXchRt(sdrXchRt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cntrVslClssCapa[i] != null)
					model.setCntrVslClssCapa(cntrVslClssCapa[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (eacNo[i] != null)
					model.setEacNo(eacNo[i]);
				if (arrTugBotKnt[i] != null)
					model.setArrTugBotKnt(arrTugBotKnt[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (xprDesc[i] != null)
					model.setXprDesc(xprDesc[i]);
				if (stPortCd[i] != null)
					model.setStPortCd(stPortCd[i]);
				if (sel[i] != null)
					model.setSel(sel[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPreAuditBatchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PreAuditBatchVO[]
	 */
	public PreAuditBatchVO[] getPreAuditBatchVOs(){
		PreAuditBatchVO[] vos = (PreAuditBatchVO[])models.toArray(new PreAuditBatchVO[models.size()]);
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
		this.fomlDesc = this.fomlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnAudRsltCd = this.expnAudRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayDt = this.apPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkId = this.atchFileLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoExpnAudStsCd = this.autoExpnAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCreUsrId = this.invCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brthHrs = this.brthHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTrNo = this.vslTrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audRlstFlg = this.audRlstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDueDt = this.payDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depTugBotKnt = this.depTugBotKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portChgAudRsltUsrId = this.portChgAudRsltUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portChgAudRsltRmk = this.portChgAudRsltRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portChgAudUsrId = this.portChgAudUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpIoBndCd = this.dpIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDatetime = this.toDatetime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjAmt = this.adjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRgstTongWgt = this.grsRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batchTpCd = this.batchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermDys = this.payTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selectFlg = this.selectFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcAmt = this.calcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portChgAudDt = this.portChgAudDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffAmt = this.diffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nightFlg = this.nightFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soDtlSeq = this.soDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqOfcCd = this.sRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disInvOfcCd = this.disInvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soSeq = this.soSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstPortCd = this.lstPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issCtyCd = this.issCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToDt = this.sToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portChgAudChkCd = this.portChgAudChkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacIfFlg = this.eacIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFmDt = this.sFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netRgstTongWgt = this.netRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCfmDt = this.invCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.suzGtWgt = this.suzGtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.madnVoySuzNetTongWgt = this.madnVoySuzNetTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdrXchRt = this.sdrXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVslClssCapa = this.cntrVslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacNo = this.eacNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrTugBotKnt = this.arrTugBotKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xprDesc = this.xprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stPortCd = this.stPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sel = this.sel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
