/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EasPortSoCfmInvVO.java
*@FileTitle : EasPortSoCfmInvVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.15
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.03.15 Arie 
* 1.0 Creation
* 2016.03.25 CHM-201640191 Split02-Auto Audit - Invoice Batch 개발 요청
=========================================================*/

package com.hanjin.syscommon.common.table;

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

public class EasPortSoCfmInvVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EasPortSoCfmInvVO> models = new ArrayList<EasPortSoCfmInvVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String fomlDesc = null;
	/* Column Info */
	private String expnAudRsltCd = null;
	/* Column Info */
	private String apPayDt = null;
	/* Column Info */
	private String vslTrNo = null;
	/* Column Info */
	private String autoExpnAudStsCd = null;
	/* Column Info */
	private String atchFileLnkId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invCreUsrId = null;
	/* Column Info */
	private String brthHrs = null;
	/* Column Info */
	private String payDueDt = null;
	/* Column Info */
	private String expnAudInvStsCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String depTugBotKnt = null;
	/* Column Info */
	private String portChgAudRsltRmk = null;
	/* Column Info */
	private String portChgAudRsltUsrId = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String portChgAudUsrId = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String dpIoBndCd = null;
	/* Column Info */
	private String grsRgstTongWgt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String adjAmt = null;
	/* Column Info */
	private String payTermDys = null;
	/* Column Info */
	private String calcAmt = null;
	/* Column Info */
	private String portChgAudDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String diffAmt = null;
	/* Column Info */
	private String soDtlSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String fletCtrtTpCd = null;
	/* Column Info */
	private String soSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String lstPortCd = null;
	/* Column Info */
	private String issCtyCd = null;
	/* Column Info */
	private String issDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String portChgAudChkCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String netRgstTongWgt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String invCfmDt = null;
	/* Column Info */
	private String suzGtWgt = null;
	/* Column Info */
	private String loclAmt = null;
	/* Column Info */
	private String madnVoySuzNetTongWgt = null;
	/* Column Info */
	private String sdrXchRt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String cntrVslClssCapa = null;
	/* Column Info */
	private String arrTugBotKnt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String eacNo = null;
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

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EasPortSoCfmInvVO() {}

	public EasPortSoCfmInvVO(String ibflag, String pagerows, String issCtyCd, String soSeq, String soDtlSeq, String portChgAudChkCd, String creUsrId, String creDt, String updUsrId, String updDt, String eacNo, String portChgAudRsltRmk, String portChgAudRsltUsrId, String atchFileLnkId, String expnAudRsltCd, String rhqCd, String invOfcCd, String invCfmDt, String autoExpnAudStsCd, String ydCd, String vslCd, String skdVoyNo, String skdDirCd, String invNo, String acctCd, String lgsCostCd, String vndrSeq, String currCd, String calcAmt, String adjAmt, String loclAmt, String invAmt, String fletCtrtTpCd, String cntrVslClssCapa, String csrNo, String expnAudInvStsCd, String dpIoBndCd, String vpsEtbDt, String issDt, String invCreUsrId, String diffAmt, String fomlDesc, String xprDesc, String portChgAudDt, String portChgAudUsrId, String diffRmk, String brthHrs, String lstPortCd, String stPortCd, String grsRgstTongWgt, String netRgstTongWgt, String arrTugBotKnt, String depTugBotKnt, String payTermDys, String payDueDt, String apPayDt, String suzGtWgt, String madnVoySuzNetTongWgt, String sdrXchRt, String vslTrNo) {
		this.vslCd = vslCd;
		this.fomlDesc = fomlDesc;
		this.expnAudRsltCd = expnAudRsltCd;
		this.apPayDt = apPayDt;
		this.vslTrNo = vslTrNo;
		this.autoExpnAudStsCd = autoExpnAudStsCd;
		this.atchFileLnkId = atchFileLnkId;
		this.pagerows = pagerows;
		this.invCreUsrId = invCreUsrId;
		this.brthHrs = brthHrs;
		this.payDueDt = payDueDt;
		this.expnAudInvStsCd = expnAudInvStsCd;
		this.updUsrId = updUsrId;
		this.depTugBotKnt = depTugBotKnt;
		this.portChgAudRsltRmk = portChgAudRsltRmk;
		this.portChgAudRsltUsrId = portChgAudRsltUsrId;
		this.csrNo = csrNo;
		this.portChgAudUsrId = portChgAudUsrId;
		this.rhqCd = rhqCd;
		this.dpIoBndCd = dpIoBndCd;
		this.grsRgstTongWgt = grsRgstTongWgt;
		this.skdVoyNo = skdVoyNo;
		this.adjAmt = adjAmt;
		this.payTermDys = payTermDys;
		this.calcAmt = calcAmt;
		this.portChgAudDt = portChgAudDt;
		this.creUsrId = creUsrId;
		this.diffAmt = diffAmt;
		this.soDtlSeq = soDtlSeq;
		this.vndrSeq = vndrSeq;
		this.vpsEtbDt = vpsEtbDt;
		this.currCd = currCd;
		this.fletCtrtTpCd = fletCtrtTpCd;
		this.soSeq = soSeq;
		this.creDt = creDt;
		this.lstPortCd = lstPortCd;
		this.issCtyCd = issCtyCd;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.portChgAudChkCd = portChgAudChkCd;
		this.acctCd = acctCd;
		this.invAmt = invAmt;
		this.invOfcCd = invOfcCd;
		this.netRgstTongWgt = netRgstTongWgt;
		this.updDt = updDt;
		this.invCfmDt = invCfmDt;
		this.suzGtWgt = suzGtWgt;
		this.loclAmt = loclAmt;
		this.madnVoySuzNetTongWgt = madnVoySuzNetTongWgt;
		this.sdrXchRt = sdrXchRt;
		this.skdDirCd = skdDirCd;
		this.cntrVslClssCapa = cntrVslClssCapa;
		this.arrTugBotKnt = arrTugBotKnt;
		this.invNo = invNo;
		this.eacNo = eacNo;
		this.diffRmk = diffRmk;
		this.ydCd = ydCd;
		this.lgsCostCd = lgsCostCd;
		this.xprDesc = xprDesc;
		this.stPortCd = stPortCd;
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
		this.hashColumns.put("vsl_tr_no", getVslTrNo());
		this.hashColumns.put("auto_expn_aud_sts_cd", getAutoExpnAudStsCd());
		this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_cre_usr_id", getInvCreUsrId());
		this.hashColumns.put("brth_hrs", getBrthHrs());
		this.hashColumns.put("pay_due_dt", getPayDueDt());
		this.hashColumns.put("expn_aud_inv_sts_cd", getExpnAudInvStsCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dep_tug_bot_knt", getDepTugBotKnt());
		this.hashColumns.put("port_chg_aud_rslt_rmk", getPortChgAudRsltRmk());
		this.hashColumns.put("port_chg_aud_rslt_usr_id", getPortChgAudRsltUsrId());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("port_chg_aud_usr_id", getPortChgAudUsrId());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("dp_io_bnd_cd", getDpIoBndCd());
		this.hashColumns.put("grs_rgst_tong_wgt", getGrsRgstTongWgt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("adj_amt", getAdjAmt());
		this.hashColumns.put("pay_term_dys", getPayTermDys());
		this.hashColumns.put("calc_amt", getCalcAmt());
		this.hashColumns.put("port_chg_aud_dt", getPortChgAudDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("diff_amt", getDiffAmt());
		this.hashColumns.put("so_dtl_seq", getSoDtlSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
		this.hashColumns.put("so_seq", getSoSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("lst_port_cd", getLstPortCd());
		this.hashColumns.put("iss_cty_cd", getIssCtyCd());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("port_chg_aud_chk_cd", getPortChgAudChkCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("net_rgst_tong_wgt", getNetRgstTongWgt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inv_cfm_dt", getInvCfmDt());
		this.hashColumns.put("suz_gt_wgt", getSuzGtWgt());
		this.hashColumns.put("locl_amt", getLoclAmt());
		this.hashColumns.put("madn_voy_suz_net_tong_wgt", getMadnVoySuzNetTongWgt());
		this.hashColumns.put("sdr_xch_rt", getSdrXchRt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cntr_vsl_clss_capa", getCntrVslClssCapa());
		this.hashColumns.put("arr_tug_bot_knt", getArrTugBotKnt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("eac_no", getEacNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("xpr_desc", getXprDesc());
		this.hashColumns.put("st_port_cd", getStPortCd());
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
		this.hashFields.put("vsl_tr_no", "vslTrNo");
		this.hashFields.put("auto_expn_aud_sts_cd", "autoExpnAudStsCd");
		this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_cre_usr_id", "invCreUsrId");
		this.hashFields.put("brth_hrs", "brthHrs");
		this.hashFields.put("pay_due_dt", "payDueDt");
		this.hashFields.put("expn_aud_inv_sts_cd", "expnAudInvStsCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dep_tug_bot_knt", "depTugBotKnt");
		this.hashFields.put("port_chg_aud_rslt_rmk", "portChgAudRsltRmk");
		this.hashFields.put("port_chg_aud_rslt_usr_id", "portChgAudRsltUsrId");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("port_chg_aud_usr_id", "portChgAudUsrId");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("dp_io_bnd_cd", "dpIoBndCd");
		this.hashFields.put("grs_rgst_tong_wgt", "grsRgstTongWgt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("adj_amt", "adjAmt");
		this.hashFields.put("pay_term_dys", "payTermDys");
		this.hashFields.put("calc_amt", "calcAmt");
		this.hashFields.put("port_chg_aud_dt", "portChgAudDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_amt", "diffAmt");
		this.hashFields.put("so_dtl_seq", "soDtlSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
		this.hashFields.put("so_seq", "soSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("lst_port_cd", "lstPortCd");
		this.hashFields.put("iss_cty_cd", "issCtyCd");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("port_chg_aud_chk_cd", "portChgAudChkCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("net_rgst_tong_wgt", "netRgstTongWgt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inv_cfm_dt", "invCfmDt");
		this.hashFields.put("suz_gt_wgt", "suzGtWgt");
		this.hashFields.put("locl_amt", "loclAmt");
		this.hashFields.put("madn_voy_suz_net_tong_wgt", "madnVoySuzNetTongWgt");
		this.hashFields.put("sdr_xch_rt", "sdrXchRt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cntr_vsl_clss_capa", "cntrVslClssCapa");
		this.hashFields.put("arr_tug_bot_knt", "arrTugBotKnt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("eac_no", "eacNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("xpr_desc", "xprDesc");
		this.hashFields.put("st_port_cd", "stPortCd");
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
	 * @return vslTrNo
	 */
	public String getVslTrNo() {
		return this.vslTrNo;
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
	 * @return payDueDt
	 */
	public String getPayDueDt() {
		return this.payDueDt;
	}
	
	/**
	 * Column Info
	 * @return expnAudInvStsCd
	 */
	public String getExpnAudInvStsCd() {
		return this.expnAudInvStsCd;
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
	 * @return portChgAudRsltRmk
	 */
	public String getPortChgAudRsltRmk() {
		return this.portChgAudRsltRmk;
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
	 * @return grsRgstTongWgt
	 */
	public String getGrsRgstTongWgt() {
		return this.grsRgstTongWgt;
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
	 * @return payTermDys
	 */
	public String getPayTermDys() {
		return this.payTermDys;
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
	 * @return fletCtrtTpCd
	 */
	public String getFletCtrtTpCd() {
		return this.fletCtrtTpCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return portChgAudChkCd
	 */
	public String getPortChgAudChkCd() {
		return this.portChgAudChkCd;
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
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return loclAmt
	 */
	public String getLoclAmt() {
		return this.loclAmt;
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
	 * @return arrTugBotKnt
	 */
	public String getArrTugBotKnt() {
		return this.arrTugBotKnt;
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
	 * @param vslTrNo
	 */
	public void setVslTrNo(String vslTrNo) {
		this.vslTrNo = vslTrNo;
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
	 * @param payDueDt
	 */
	public void setPayDueDt(String payDueDt) {
		this.payDueDt = payDueDt;
	}
	
	/**
	 * Column Info
	 * @param expnAudInvStsCd
	 */
	public void setExpnAudInvStsCd(String expnAudInvStsCd) {
		this.expnAudInvStsCd = expnAudInvStsCd;
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
	 * @param portChgAudRsltRmk
	 */
	public void setPortChgAudRsltRmk(String portChgAudRsltRmk) {
		this.portChgAudRsltRmk = portChgAudRsltRmk;
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
	 * @param grsRgstTongWgt
	 */
	public void setGrsRgstTongWgt(String grsRgstTongWgt) {
		this.grsRgstTongWgt = grsRgstTongWgt;
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
	 * @param payTermDys
	 */
	public void setPayTermDys(String payTermDys) {
		this.payTermDys = payTermDys;
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
	 * @param fletCtrtTpCd
	 */
	public void setFletCtrtTpCd(String fletCtrtTpCd) {
		this.fletCtrtTpCd = fletCtrtTpCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param portChgAudChkCd
	 */
	public void setPortChgAudChkCd(String portChgAudChkCd) {
		this.portChgAudChkCd = portChgAudChkCd;
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
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param loclAmt
	 */
	public void setLoclAmt(String loclAmt) {
		this.loclAmt = loclAmt;
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
	 * @param arrTugBotKnt
	 */
	public void setArrTugBotKnt(String arrTugBotKnt) {
		this.arrTugBotKnt = arrTugBotKnt;
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
		setVslTrNo(JSPUtil.getParameter(request, prefix + "vsl_tr_no", ""));
		setAutoExpnAudStsCd(JSPUtil.getParameter(request, prefix + "auto_expn_aud_sts_cd", ""));
		setAtchFileLnkId(JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvCreUsrId(JSPUtil.getParameter(request, prefix + "inv_cre_usr_id", ""));
		setBrthHrs(JSPUtil.getParameter(request, prefix + "brth_hrs", ""));
		setPayDueDt(JSPUtil.getParameter(request, prefix + "pay_due_dt", ""));
		setExpnAudInvStsCd(JSPUtil.getParameter(request, prefix + "expn_aud_inv_sts_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDepTugBotKnt(JSPUtil.getParameter(request, prefix + "dep_tug_bot_knt", ""));
		setPortChgAudRsltRmk(JSPUtil.getParameter(request, prefix + "port_chg_aud_rslt_rmk", ""));
		setPortChgAudRsltUsrId(JSPUtil.getParameter(request, prefix + "port_chg_aud_rslt_usr_id", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setPortChgAudUsrId(JSPUtil.getParameter(request, prefix + "port_chg_aud_usr_id", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setDpIoBndCd(JSPUtil.getParameter(request, prefix + "dp_io_bnd_cd", ""));
		setGrsRgstTongWgt(JSPUtil.getParameter(request, prefix + "grs_rgst_tong_wgt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setAdjAmt(JSPUtil.getParameter(request, prefix + "adj_amt", ""));
		setPayTermDys(JSPUtil.getParameter(request, prefix + "pay_term_dys", ""));
		setCalcAmt(JSPUtil.getParameter(request, prefix + "calc_amt", ""));
		setPortChgAudDt(JSPUtil.getParameter(request, prefix + "port_chg_aud_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDiffAmt(JSPUtil.getParameter(request, prefix + "diff_amt", ""));
		setSoDtlSeq(JSPUtil.getParameter(request, prefix + "so_dtl_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setFletCtrtTpCd(JSPUtil.getParameter(request, prefix + "flet_ctrt_tp_cd", ""));
		setSoSeq(JSPUtil.getParameter(request, prefix + "so_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setLstPortCd(JSPUtil.getParameter(request, prefix + "lst_port_cd", ""));
		setIssCtyCd(JSPUtil.getParameter(request, prefix + "iss_cty_cd", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPortChgAudChkCd(JSPUtil.getParameter(request, prefix + "port_chg_aud_chk_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setNetRgstTongWgt(JSPUtil.getParameter(request, prefix + "net_rgst_tong_wgt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setInvCfmDt(JSPUtil.getParameter(request, prefix + "inv_cfm_dt", ""));
		setSuzGtWgt(JSPUtil.getParameter(request, prefix + "suz_gt_wgt", ""));
		setLoclAmt(JSPUtil.getParameter(request, prefix + "locl_amt", ""));
		setMadnVoySuzNetTongWgt(JSPUtil.getParameter(request, prefix + "madn_voy_suz_net_tong_wgt", ""));
		setSdrXchRt(JSPUtil.getParameter(request, prefix + "sdr_xch_rt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCntrVslClssCapa(JSPUtil.getParameter(request, prefix + "cntr_vsl_clss_capa", ""));
		setArrTugBotKnt(JSPUtil.getParameter(request, prefix + "arr_tug_bot_knt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setEacNo(JSPUtil.getParameter(request, prefix + "eac_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setXprDesc(JSPUtil.getParameter(request, prefix + "xpr_desc", ""));
		setStPortCd(JSPUtil.getParameter(request, prefix + "st_port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EasPortSoCfmInvVO[]
	 */
	public EasPortSoCfmInvVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EasPortSoCfmInvVO[]
	 */
	public EasPortSoCfmInvVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EasPortSoCfmInvVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] fomlDesc = (JSPUtil.getParameter(request, prefix	+ "foml_desc", length));
			String[] expnAudRsltCd = (JSPUtil.getParameter(request, prefix	+ "expn_aud_rslt_cd", length));
			String[] apPayDt = (JSPUtil.getParameter(request, prefix	+ "ap_pay_dt", length));
			String[] vslTrNo = (JSPUtil.getParameter(request, prefix	+ "vsl_tr_no", length));
			String[] autoExpnAudStsCd = (JSPUtil.getParameter(request, prefix	+ "auto_expn_aud_sts_cd", length));
			String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_lnk_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invCreUsrId = (JSPUtil.getParameter(request, prefix	+ "inv_cre_usr_id", length));
			String[] brthHrs = (JSPUtil.getParameter(request, prefix	+ "brth_hrs", length));
			String[] payDueDt = (JSPUtil.getParameter(request, prefix	+ "pay_due_dt", length));
			String[] expnAudInvStsCd = (JSPUtil.getParameter(request, prefix	+ "expn_aud_inv_sts_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] depTugBotKnt = (JSPUtil.getParameter(request, prefix	+ "dep_tug_bot_knt", length));
			String[] portChgAudRsltRmk = (JSPUtil.getParameter(request, prefix	+ "port_chg_aud_rslt_rmk", length));
			String[] portChgAudRsltUsrId = (JSPUtil.getParameter(request, prefix	+ "port_chg_aud_rslt_usr_id", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] portChgAudUsrId = (JSPUtil.getParameter(request, prefix	+ "port_chg_aud_usr_id", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] dpIoBndCd = (JSPUtil.getParameter(request, prefix	+ "dp_io_bnd_cd", length));
			String[] grsRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "grs_rgst_tong_wgt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] adjAmt = (JSPUtil.getParameter(request, prefix	+ "adj_amt", length));
			String[] payTermDys = (JSPUtil.getParameter(request, prefix	+ "pay_term_dys", length));
			String[] calcAmt = (JSPUtil.getParameter(request, prefix	+ "calc_amt", length));
			String[] portChgAudDt = (JSPUtil.getParameter(request, prefix	+ "port_chg_aud_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] diffAmt = (JSPUtil.getParameter(request, prefix	+ "diff_amt", length));
			String[] soDtlSeq = (JSPUtil.getParameter(request, prefix	+ "so_dtl_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_tp_cd", length));
			String[] soSeq = (JSPUtil.getParameter(request, prefix	+ "so_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] lstPortCd = (JSPUtil.getParameter(request, prefix	+ "lst_port_cd", length));
			String[] issCtyCd = (JSPUtil.getParameter(request, prefix	+ "iss_cty_cd", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] portChgAudChkCd = (JSPUtil.getParameter(request, prefix	+ "port_chg_aud_chk_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] netRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "net_rgst_tong_wgt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] invCfmDt = (JSPUtil.getParameter(request, prefix	+ "inv_cfm_dt", length));
			String[] suzGtWgt = (JSPUtil.getParameter(request, prefix	+ "suz_gt_wgt", length));
			String[] loclAmt = (JSPUtil.getParameter(request, prefix	+ "locl_amt", length));
			String[] madnVoySuzNetTongWgt = (JSPUtil.getParameter(request, prefix	+ "madn_voy_suz_net_tong_wgt", length));
			String[] sdrXchRt = (JSPUtil.getParameter(request, prefix	+ "sdr_xch_rt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cntrVslClssCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_vsl_clss_capa", length));
			String[] arrTugBotKnt = (JSPUtil.getParameter(request, prefix	+ "arr_tug_bot_knt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] eacNo = (JSPUtil.getParameter(request, prefix	+ "eac_no", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] xprDesc = (JSPUtil.getParameter(request, prefix	+ "xpr_desc", length));
			String[] stPortCd = (JSPUtil.getParameter(request, prefix	+ "st_port_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EasPortSoCfmInvVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (fomlDesc[i] != null)
					model.setFomlDesc(fomlDesc[i]);
				if (expnAudRsltCd[i] != null)
					model.setExpnAudRsltCd(expnAudRsltCd[i]);
				if (apPayDt[i] != null)
					model.setApPayDt(apPayDt[i]);
				if (vslTrNo[i] != null)
					model.setVslTrNo(vslTrNo[i]);
				if (autoExpnAudStsCd[i] != null)
					model.setAutoExpnAudStsCd(autoExpnAudStsCd[i]);
				if (atchFileLnkId[i] != null)
					model.setAtchFileLnkId(atchFileLnkId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invCreUsrId[i] != null)
					model.setInvCreUsrId(invCreUsrId[i]);
				if (brthHrs[i] != null)
					model.setBrthHrs(brthHrs[i]);
				if (payDueDt[i] != null)
					model.setPayDueDt(payDueDt[i]);
				if (expnAudInvStsCd[i] != null)
					model.setExpnAudInvStsCd(expnAudInvStsCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (depTugBotKnt[i] != null)
					model.setDepTugBotKnt(depTugBotKnt[i]);
				if (portChgAudRsltRmk[i] != null)
					model.setPortChgAudRsltRmk(portChgAudRsltRmk[i]);
				if (portChgAudRsltUsrId[i] != null)
					model.setPortChgAudRsltUsrId(portChgAudRsltUsrId[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (portChgAudUsrId[i] != null)
					model.setPortChgAudUsrId(portChgAudUsrId[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (dpIoBndCd[i] != null)
					model.setDpIoBndCd(dpIoBndCd[i]);
				if (grsRgstTongWgt[i] != null)
					model.setGrsRgstTongWgt(grsRgstTongWgt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (adjAmt[i] != null)
					model.setAdjAmt(adjAmt[i]);
				if (payTermDys[i] != null)
					model.setPayTermDys(payTermDys[i]);
				if (calcAmt[i] != null)
					model.setCalcAmt(calcAmt[i]);
				if (portChgAudDt[i] != null)
					model.setPortChgAudDt(portChgAudDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (diffAmt[i] != null)
					model.setDiffAmt(diffAmt[i]);
				if (soDtlSeq[i] != null)
					model.setSoDtlSeq(soDtlSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (fletCtrtTpCd[i] != null)
					model.setFletCtrtTpCd(fletCtrtTpCd[i]);
				if (soSeq[i] != null)
					model.setSoSeq(soSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (lstPortCd[i] != null)
					model.setLstPortCd(lstPortCd[i]);
				if (issCtyCd[i] != null)
					model.setIssCtyCd(issCtyCd[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (portChgAudChkCd[i] != null)
					model.setPortChgAudChkCd(portChgAudChkCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (netRgstTongWgt[i] != null)
					model.setNetRgstTongWgt(netRgstTongWgt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (invCfmDt[i] != null)
					model.setInvCfmDt(invCfmDt[i]);
				if (suzGtWgt[i] != null)
					model.setSuzGtWgt(suzGtWgt[i]);
				if (loclAmt[i] != null)
					model.setLoclAmt(loclAmt[i]);
				if (madnVoySuzNetTongWgt[i] != null)
					model.setMadnVoySuzNetTongWgt(madnVoySuzNetTongWgt[i]);
				if (sdrXchRt[i] != null)
					model.setSdrXchRt(sdrXchRt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cntrVslClssCapa[i] != null)
					model.setCntrVslClssCapa(cntrVslClssCapa[i]);
				if (arrTugBotKnt[i] != null)
					model.setArrTugBotKnt(arrTugBotKnt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (eacNo[i] != null)
					model.setEacNo(eacNo[i]);
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
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEasPortSoCfmInvVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EasPortSoCfmInvVO[]
	 */
	public EasPortSoCfmInvVO[] getEasPortSoCfmInvVOs(){
		EasPortSoCfmInvVO[] vos = (EasPortSoCfmInvVO[])models.toArray(new EasPortSoCfmInvVO[models.size()]);
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
		this.vslTrNo = this.vslTrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoExpnAudStsCd = this.autoExpnAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkId = this.atchFileLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCreUsrId = this.invCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brthHrs = this.brthHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDueDt = this.payDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnAudInvStsCd = this.expnAudInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depTugBotKnt = this.depTugBotKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portChgAudRsltRmk = this.portChgAudRsltRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portChgAudRsltUsrId = this.portChgAudRsltUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portChgAudUsrId = this.portChgAudUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpIoBndCd = this.dpIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRgstTongWgt = this.grsRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjAmt = this.adjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermDys = this.payTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcAmt = this.calcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portChgAudDt = this.portChgAudDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffAmt = this.diffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soDtlSeq = this.soDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtTpCd = this.fletCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soSeq = this.soSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstPortCd = this.lstPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issCtyCd = this.issCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portChgAudChkCd = this.portChgAudChkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netRgstTongWgt = this.netRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCfmDt = this.invCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.suzGtWgt = this.suzGtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAmt = this.loclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.madnVoySuzNetTongWgt = this.madnVoySuzNetTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdrXchRt = this.sdrXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVslClssCapa = this.cntrVslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrTugBotKnt = this.arrTugBotKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacNo = this.eacNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xprDesc = this.xprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stPortCd = this.stPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
