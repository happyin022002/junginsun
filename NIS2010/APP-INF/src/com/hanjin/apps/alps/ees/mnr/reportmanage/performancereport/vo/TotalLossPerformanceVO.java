package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

public class TotalLossPerformanceVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<TotalLossPerformanceVO> models = new ArrayList<TotalLossPerformanceVO>();
	private String dvExp = null;
	private String dsEqQty = null;
	private String irDvVal = null;
	private String cltAmt = null;
	private String dvEqQty = null;
	private String ttlLssNo = null;
	private String dsExp = null;
	private String aproOfcCd = null;
	private String tpDvVal = null;
	private String pagerows = null;
	private String ttlLssCfmDt = null;
	private String tmpseq = null;
	private String ibflag = null;
	private String dsDvVal = null;
	private String rqstEqNo = null;
	private String scBal = null;
	private String tpEqQty = null;
	private String ttlLssDtlCmplDt = null;
	private String rqstDt = null;
	private String ttlLssN3ptyTpCd = null;
	private String scExp = null;
	private String ttlLssRsnNm = null;
	private String scDvVal = null;
	private String tpExp = null;
	private String ttlLssDtlRsnNm = null;
	private String irEqQty = null;
	private String tpBal = null;
	private String irBal = null;
	private String ttlLssStsNm = null;
	private String buyerName = null;
	private String creUsrId = null;
	private String dvBal = null;
	private String scEqQty = null;
	private String irExp = null;
	private String usaEdiCd = null;
	private String ttlLssDt = null;
	private String rqstOfcCd = null;
	private String dsBal = null;
	private String ttlLssCmplNm = null;
	private String respbOfcCd = null;
	private String ttlLssRsnCd = null;
	private String ttlLssDtlCmplNm = null;
	private String dvDvVal = null;
	private String payerName = null;
	private String dsCurrCd = null;
	private String dsUsdExp = null;
	private String tpCurrCd = null;
	private String tpUsdExp = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public TotalLossPerformanceVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dv_exp", getDvExp());
		this.hashColumns.put("ds_eq_qty", getDsEqQty());
		this.hashColumns.put("ir_dv_val", getIrDvVal());
		this.hashColumns.put("clt_amt", getCltAmt());
		this.hashColumns.put("dv_eq_qty", getDvEqQty());
		this.hashColumns.put("ttl_lss_no", getTtlLssNo());
		this.hashColumns.put("ds_exp", getDsExp());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("tp_dv_val", getTpDvVal());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ttl_lss_cfm_dt", getTtlLssCfmDt());
		this.hashColumns.put("tmpseq", getTmpseq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ds_dv_val", getDsDvVal());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("sc_bal", getScBal());
		this.hashColumns.put("tp_eq_qty", getTpEqQty());
		this.hashColumns.put("ttl_lss_dtl_cmpl_dt", getTtlLssDtlCmplDt());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("ttl_lss_n3pty_tp_cd", getTtlLssN3ptyTpCd());
		this.hashColumns.put("sc_exp", getScExp());
		this.hashColumns.put("ttl_lss_rsn_nm", getTtlLssRsnNm());
		this.hashColumns.put("sc_dv_val", getScDvVal());
		this.hashColumns.put("tp_exp", getTpExp());
		this.hashColumns.put("ttl_lss_dtl_rsn_nm", getTtlLssDtlRsnNm());
		this.hashColumns.put("ir_eq_qty", getIrEqQty());
		this.hashColumns.put("tp_bal", getTpBal());
		this.hashColumns.put("ir_bal", getIrBal());
		this.hashColumns.put("ttl_lss_sts_nm", getTtlLssStsNm());
		this.hashColumns.put("buyer_name", getBuyerName());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dv_bal", getDvBal());
		this.hashColumns.put("sc_eq_qty", getScEqQty());
		this.hashColumns.put("ir_exp", getIrExp());
		this.hashColumns.put("usa_edi_cd", getUsaEdiCd());
		this.hashColumns.put("ttl_lss_dt", getTtlLssDt());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("ds_bal", getDsBal());
		this.hashColumns.put("ttl_lss_cmpl_nm", getTtlLssCmplNm());
		this.hashColumns.put("respb_ofc_cd", getRespbOfcCd());
		this.hashColumns.put("ttl_lss_rsn_cd", getTtlLssRsnCd());
		this.hashColumns.put("ttl_lss_dtl_cmpl_nm", getTtlLssDtlCmplNm());
		this.hashColumns.put("dv_dv_val", getDvDvVal());
		this.hashColumns.put("payer_name", getPayerName());
		this.hashColumns.put("ds_curr_cd", getDsCurrCd());
		this.hashColumns.put("ds_usd_exp", getDsUsdExp());
		this.hashColumns.put("tp_curr_cd", getTpCurrCd());
		this.hashColumns.put("tp_usd_exp", getTpUsdExp());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dv_exp", "dvExp");
		this.hashFields.put("ds_eq_qty", "dsEqQty");
		this.hashFields.put("ir_dv_val", "irDvVal");
		this.hashFields.put("clt_amt", "cltAmt");
		this.hashFields.put("dv_eq_qty", "dvEqQty");
		this.hashFields.put("ttl_lss_no", "ttlLssNo");
		this.hashFields.put("ds_exp", "dsExp");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("tp_dv_val", "tpDvVal");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ttl_lss_cfm_dt", "ttlLssCfmDt");
		this.hashFields.put("tmpseq", "tmpseq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ds_dv_val", "dsDvVal");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("sc_bal", "scBal");
		this.hashFields.put("tp_eq_qty", "tpEqQty");
		this.hashFields.put("ttl_lss_dtl_cmpl_dt", "ttlLssDtlCmplDt");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("ttl_lss_n3pty_tp_cd", "ttlLssN3ptyTpCd");
		this.hashFields.put("sc_exp", "scExp");
		this.hashFields.put("ttl_lss_rsn_nm", "ttlLssRsnNm");
		this.hashFields.put("sc_dv_val", "scDvVal");
		this.hashFields.put("tp_exp", "tpExp");
		this.hashFields.put("ttl_lss_dtl_rsn_nm", "ttlLssDtlRsnNm");
		this.hashFields.put("ir_eq_qty", "irEqQty");
		this.hashFields.put("tp_bal", "tpBal");
		this.hashFields.put("ir_bal", "irBal");
		this.hashFields.put("ttl_lss_sts_nm", "ttlLssStsNm");
		this.hashFields.put("buyer_name", "buyerName");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dv_bal", "dvBal");
		this.hashFields.put("sc_eq_qty", "scEqQty");
		this.hashFields.put("ir_exp", "irExp");
		this.hashFields.put("usa_edi_cd", "usaEdiCd");
		this.hashFields.put("ttl_lss_dt", "ttlLssDt");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("ds_bal", "dsBal");
		this.hashFields.put("ttl_lss_cmpl_nm", "ttlLssCmplNm");
		this.hashFields.put("respb_ofc_cd", "respbOfcCd");
		this.hashFields.put("ttl_lss_rsn_cd", "ttlLssRsnCd");
		this.hashFields.put("ttl_lss_dtl_cmpl_nm", "ttlLssDtlCmplNm");
		this.hashFields.put("dv_dv_val", "dvDvVal");
		this.hashFields.put("payer_name", "payerName");
		this.hashFields.put("ds_curr_cd", "dsCurrCd");
		this.hashFields.put("ds_usd_exp", "dsUsdExp");
		this.hashFields.put("tp_curr_cd", "tpCurrCd");
		this.hashFields.put("tp_usd_exp", "tpUsdExp");
		return this.hashFields;
	}
	public String getDvExp() {
		return this.dvExp;
	}

	public String getDsEqQty() {
		return this.dsEqQty;
	}

	public String getIrDvVal() {
		return this.irDvVal;
	}

	public String getCltAmt() {
		return this.cltAmt;
	}

	public String getDvEqQty() {
		return this.dvEqQty;
	}

	public String getTtlLssNo() {
		return this.ttlLssNo;
	}

	public String getDsExp() {
		return this.dsExp;
	}

	public String getAproOfcCd() {
		return this.aproOfcCd;
	}

	public String getTpDvVal() {
		return this.tpDvVal;
	}

	public String getPagerows() {
		return this.pagerows;
	}

	public String getTtlLssCfmDt() {
		return this.ttlLssCfmDt;
	}

	public String getTmpseq() {
		return this.tmpseq;
	}

	public String getIbflag() {
		return this.ibflag;
	}

	public String getDsDvVal() {
		return this.dsDvVal;
	}

	public String getRqstEqNo() {
		return this.rqstEqNo;
	}

	public String getScBal() {
		return this.scBal;
	}

	public String getTpEqQty() {
		return this.tpEqQty;
	}

	public String getTtlLssDtlCmplDt() {
		return this.ttlLssDtlCmplDt;
	}

	public String getRqstDt() {
		return this.rqstDt;
	}

	public String getTtlLssN3ptyTpCd() {
		return this.ttlLssN3ptyTpCd;
	}

	public String getScExp() {
		return this.scExp;
	}

	public String getTtlLssRsnNm() {
		return this.ttlLssRsnNm;
	}

	public String getScDvVal() {
		return this.scDvVal;
	}

	public String getTpExp() {
		return this.tpExp;
	}

	public String getTtlLssDtlRsnNm() {
		return this.ttlLssDtlRsnNm;
	}

	public String getIrEqQty() {
		return this.irEqQty;
	}

	public String getTpBal() {
		return this.tpBal;
	}

	public String getIrBal() {
		return this.irBal;
	}

	public String getTtlLssStsNm() {
		return this.ttlLssStsNm;
	}

	public String getBuyerName() {
		return this.buyerName;
	}

	public String getCreUsrId() {
		return this.creUsrId;
	}

	public String getDvBal() {
		return this.dvBal;
	}

	public String getScEqQty() {
		return this.scEqQty;
	}

	public String getIrExp() {
		return this.irExp;
	}

	public String getUsaEdiCd() {
		return this.usaEdiCd;
	}

	public String getTtlLssDt() {
		return this.ttlLssDt;
	}

	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}

	public String getDsBal() {
		return this.dsBal;
	}

	public String getTtlLssCmplNm() {
		return this.ttlLssCmplNm;
	}

	public String getRespbOfcCd() {
		return this.respbOfcCd;
	}

	public String getTtlLssRsnCd() {
		return this.ttlLssRsnCd;
	}

	public String getTtlLssDtlCmplNm() {
		return this.ttlLssDtlCmplNm;
	}

	public String getDvDvVal() {
		return this.dvDvVal;
	}

	public String getPayerName() {
		return this.payerName;
	}

	public String getDsCurrCd() {
		return this.dsCurrCd;
	}

	public String getDsUsdExp() {
		return this.dsUsdExp;
	}

	public String getTpCurrCd() {
		return this.tpCurrCd;
	}

	public String getTpUsdExp() {
		return this.tpUsdExp;
	}

	public void setDvExp(String dvExp) {
		this.dvExp = dvExp;
	}

	public void setDsEqQty(String dsEqQty) {
		this.dsEqQty = dsEqQty;
	}

	public void setIrDvVal(String irDvVal) {
		this.irDvVal = irDvVal;
	}

	public void setCltAmt(String cltAmt) {
		this.cltAmt = cltAmt;
	}

	public void setDvEqQty(String dvEqQty) {
		this.dvEqQty = dvEqQty;
	}

	public void setTtlLssNo(String ttlLssNo) {
		this.ttlLssNo = ttlLssNo;
	}

	public void setDsExp(String dsExp) {
		this.dsExp = dsExp;
	}

	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}

	public void setTpDvVal(String tpDvVal) {
		this.tpDvVal = tpDvVal;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public void setTtlLssCfmDt(String ttlLssCfmDt) {
		this.ttlLssCfmDt = ttlLssCfmDt;
	}

	public void setTmpseq(String tmpseq) {
		this.tmpseq = tmpseq;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public void setDsDvVal(String dsDvVal) {
		this.dsDvVal = dsDvVal;
	}

	public void setRqstEqNo(String rqstEqNo) {
		this.rqstEqNo = rqstEqNo;
	}

	public void setScBal(String scBal) {
		this.scBal = scBal;
	}

	public void setTpEqQty(String tpEqQty) {
		this.tpEqQty = tpEqQty;
	}

	public void setTtlLssDtlCmplDt(String ttlLssDtlCmplDt) {
		this.ttlLssDtlCmplDt = ttlLssDtlCmplDt;
	}

	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}

	public void setTtlLssN3ptyTpCd(String ttlLssN3ptyTpCd) {
		this.ttlLssN3ptyTpCd = ttlLssN3ptyTpCd;
	}

	public void setScExp(String scExp) {
		this.scExp = scExp;
	}

	public void setTtlLssRsnNm(String ttlLssRsnNm) {
		this.ttlLssRsnNm = ttlLssRsnNm;
	}

	public void setScDvVal(String scDvVal) {
		this.scDvVal = scDvVal;
	}

	public void setTpExp(String tpExp) {
		this.tpExp = tpExp;
	}

	public void setTtlLssDtlRsnNm(String ttlLssDtlRsnNm) {
		this.ttlLssDtlRsnNm = ttlLssDtlRsnNm;
	}

	public void setIrEqQty(String irEqQty) {
		this.irEqQty = irEqQty;
	}

	public void setTpBal(String tpBal) {
		this.tpBal = tpBal;
	}

	public void setIrBal(String irBal) {
		this.irBal = irBal;
	}

	public void setTtlLssStsNm(String ttlLssStsNm) {
		this.ttlLssStsNm = ttlLssStsNm;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public void setDvBal(String dvBal) {
		this.dvBal = dvBal;
	}

	public void setScEqQty(String scEqQty) {
		this.scEqQty = scEqQty;
	}

	public void setIrExp(String irExp) {
		this.irExp = irExp;
	}

	public void setUsaEdiCd(String usaEdiCd) {
		this.usaEdiCd = usaEdiCd;
	}

	public void setTtlLssDt(String ttlLssDt) {
		this.ttlLssDt = ttlLssDt;
	}

	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}

	public void setDsBal(String dsBal) {
		this.dsBal = dsBal;
	}

	public void setTtlLssCmplNm(String ttlLssCmplNm) {
		this.ttlLssCmplNm = ttlLssCmplNm;
	}

	public void setRespbOfcCd(String respbOfcCd) {
		this.respbOfcCd = respbOfcCd;
	}

	public void setTtlLssRsnCd(String ttlLssRsnCd) {
		this.ttlLssRsnCd = ttlLssRsnCd;
	}

	public void setTtlLssDtlCmplNm(String ttlLssDtlCmplNm) {
		this.ttlLssDtlCmplNm = ttlLssDtlCmplNm;
	}

	public void setDvDvVal(String dvDvVal) {
		this.dvDvVal = dvDvVal;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public void setDsCurrCd(String dsCurrCd) {
		this.dsCurrCd = dsCurrCd;
	}

	public void setDsUsdExp(String dsUsdExp) {
		this.dsUsdExp = dsUsdExp;
	}

	public void setTpCurrCd(String tpCurrCd) {
		this.tpCurrCd = tpCurrCd;
	}

	public void setTpUsdExp(String tpUsdExp) {
		this.tpUsdExp = tpUsdExp;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setDvExp(JSPUtil.getParameter(request, prefix + "dv_exp", ""));
		setDsEqQty(JSPUtil.getParameter(request, prefix + "ds_eq_qty", ""));
		setIrDvVal(JSPUtil.getParameter(request, prefix + "ir_dv_val", ""));
		setCltAmt(JSPUtil.getParameter(request, prefix + "clt_amt", ""));
		setDvEqQty(JSPUtil.getParameter(request, prefix + "dv_eq_qty", ""));
		setTtlLssNo(JSPUtil.getParameter(request, prefix + "ttl_lss_no", ""));
		setDsExp(JSPUtil.getParameter(request, prefix + "ds_exp", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setTpDvVal(JSPUtil.getParameter(request, prefix + "tp_dv_val", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTtlLssCfmDt(JSPUtil.getParameter(request, prefix + "ttl_lss_cfm_dt", ""));
		setTmpseq(JSPUtil.getParameter(request, prefix + "tmpseq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDsDvVal(JSPUtil.getParameter(request, prefix + "ds_dv_val", ""));
		setRqstEqNo(JSPUtil.getParameter(request, prefix + "rqst_eq_no", ""));
		setScBal(JSPUtil.getParameter(request, prefix + "sc_bal", ""));
		setTpEqQty(JSPUtil.getParameter(request, prefix + "tp_eq_qty", ""));
		setTtlLssDtlCmplDt(JSPUtil.getParameter(request, prefix + "ttl_lss_dtl_cmpl_dt", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setTtlLssN3ptyTpCd(JSPUtil.getParameter(request, prefix + "ttl_lss_n3pty_tp_cd", ""));
		setScExp(JSPUtil.getParameter(request, prefix + "sc_exp", ""));
		setTtlLssRsnNm(JSPUtil.getParameter(request, prefix + "ttl_lss_rsn_nm", ""));
		setScDvVal(JSPUtil.getParameter(request, prefix + "sc_dv_val", ""));
		setTpExp(JSPUtil.getParameter(request, prefix + "tp_exp", ""));
		setTtlLssDtlRsnNm(JSPUtil.getParameter(request, prefix + "ttl_lss_dtl_rsn_nm", ""));
		setIrEqQty(JSPUtil.getParameter(request, prefix + "ir_eq_qty", ""));
		setTpBal(JSPUtil.getParameter(request, prefix + "tp_bal", ""));
		setIrBal(JSPUtil.getParameter(request, prefix + "ir_bal", ""));
		setTtlLssStsNm(JSPUtil.getParameter(request, prefix + "ttl_lss_sts_nm", ""));
		setBuyerName(JSPUtil.getParameter(request, prefix + "buyer_name", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDvBal(JSPUtil.getParameter(request, prefix + "dv_bal", ""));
		setScEqQty(JSPUtil.getParameter(request, prefix + "sc_eq_qty", ""));
		setIrExp(JSPUtil.getParameter(request, prefix + "ir_exp", ""));
		setUsaEdiCd(JSPUtil.getParameter(request, prefix + "usa_edi_cd", ""));
		setTtlLssDt(JSPUtil.getParameter(request, prefix + "ttl_lss_dt", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setDsBal(JSPUtil.getParameter(request, prefix + "ds_bal", ""));
		setTtlLssCmplNm(JSPUtil.getParameter(request, prefix + "ttl_lss_cmpl_nm", ""));
		setRespbOfcCd(JSPUtil.getParameter(request, prefix + "respb_ofc_cd", ""));
		setTtlLssRsnCd(JSPUtil.getParameter(request, prefix + "ttl_lss_rsn_cd", ""));
		setTtlLssDtlCmplNm(JSPUtil.getParameter(request, prefix + "ttl_lss_dtl_cmpl_nm", ""));
		setDvDvVal(JSPUtil.getParameter(request, prefix + "dv_dv_val", ""));
		setPayerName(JSPUtil.getParameter(request, prefix + "payer_name", ""));
		setDsCurrCd(JSPUtil.getParameter(request, prefix + "ds_curr_cd", ""));
		setDsUsdExp(JSPUtil.getParameter(request, prefix + "ds_usd_exp", ""));
		setTpCurrCd(JSPUtil.getParameter(request, prefix + "tp_curr_cd", ""));
		setTpUsdExp(JSPUtil.getParameter(request, prefix + "tp_usd_exp", ""));
	}

	public TotalLossPerformanceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public TotalLossPerformanceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TotalLossPerformanceVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] dvExp = (JSPUtil.getParameter(request, prefix	+ "dv_exp", length));
			String[] dsEqQty = (JSPUtil.getParameter(request, prefix	+ "ds_eq_qty", length));
			String[] irDvVal = (JSPUtil.getParameter(request, prefix	+ "ir_dv_val", length));
			String[] cltAmt = (JSPUtil.getParameter(request, prefix	+ "clt_amt", length));
			String[] dvEqQty = (JSPUtil.getParameter(request, prefix	+ "dv_eq_qty", length));
			String[] ttlLssNo = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_no", length));
			String[] dsExp = (JSPUtil.getParameter(request, prefix	+ "ds_exp", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] tpDvVal = (JSPUtil.getParameter(request, prefix	+ "tp_dv_val", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ttlLssCfmDt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_cfm_dt", length));
			String[] tmpseq = (JSPUtil.getParameter(request, prefix	+ "tmpseq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dsDvVal = (JSPUtil.getParameter(request, prefix	+ "ds_dv_val", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] scBal = (JSPUtil.getParameter(request, prefix	+ "sc_bal", length));
			String[] tpEqQty = (JSPUtil.getParameter(request, prefix	+ "tp_eq_qty", length));
			String[] ttlLssDtlCmplDt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dtl_cmpl_dt", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] ttlLssN3ptyTpCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_n3pty_tp_cd", length));
			String[] scExp = (JSPUtil.getParameter(request, prefix	+ "sc_exp", length));
			String[] ttlLssRsnNm = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_rsn_nm", length));
			String[] scDvVal = (JSPUtil.getParameter(request, prefix	+ "sc_dv_val", length));
			String[] tpExp = (JSPUtil.getParameter(request, prefix	+ "tp_exp", length));
			String[] ttlLssDtlRsnNm = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dtl_rsn_nm", length));
			String[] irEqQty = (JSPUtil.getParameter(request, prefix	+ "ir_eq_qty", length));
			String[] tpBal = (JSPUtil.getParameter(request, prefix	+ "tp_bal", length));
			String[] irBal = (JSPUtil.getParameter(request, prefix	+ "ir_bal", length));
			String[] ttlLssStsNm = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_sts_nm", length));
			String[] buyerName = (JSPUtil.getParameter(request, prefix	+ "buyer_name", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] dvBal = (JSPUtil.getParameter(request, prefix	+ "dv_bal", length));
			String[] scEqQty = (JSPUtil.getParameter(request, prefix	+ "sc_eq_qty", length));
			String[] irExp = (JSPUtil.getParameter(request, prefix	+ "ir_exp", length));
			String[] usaEdiCd = (JSPUtil.getParameter(request, prefix	+ "usa_edi_cd", length));
			String[] ttlLssDt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dt", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] dsBal = (JSPUtil.getParameter(request, prefix	+ "ds_bal", length));
			String[] ttlLssCmplNm = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_cmpl_nm", length));
			String[] respbOfcCd = (JSPUtil.getParameter(request, prefix	+ "respb_ofc_cd", length));
			String[] ttlLssRsnCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_rsn_cd", length));
			String[] ttlLssDtlCmplNm = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dtl_cmpl_nm", length));
			String[] dvDvVal = (JSPUtil.getParameter(request, prefix	+ "dv_dv_val", length));
			String[] payerName = (JSPUtil.getParameter(request, prefix	+ "payer_name", length));
			String[] dsCurrCd = (JSPUtil.getParameter(request, prefix	+ "ds_curr_cd", length));
			String[] dsUsdExp = (JSPUtil.getParameter(request, prefix	+ "ds_usd_exp", length));
			String[] tpCurrCd = (JSPUtil.getParameter(request, prefix	+ "tp_curr_cd", length));
			String[] tpUsdExp = (JSPUtil.getParameter(request, prefix	+ "tp_usd_exp", length));
			for (int i = 0; i < length; i++) {
				model = new TotalLossPerformanceVO();
				if (dvExp[i] != null)
					model.setDvExp(dvExp[i]);
				if (dsEqQty[i] != null)
					model.setDsEqQty(dsEqQty[i]);
				if (irDvVal[i] != null)
					model.setIrDvVal(irDvVal[i]);
				if (cltAmt[i] != null)
					model.setCltAmt(cltAmt[i]);
				if (dvEqQty[i] != null)
					model.setDvEqQty(dvEqQty[i]);
				if (ttlLssNo[i] != null)
					model.setTtlLssNo(ttlLssNo[i]);
				if (dsExp[i] != null)
					model.setDsExp(dsExp[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (tpDvVal[i] != null)
					model.setTpDvVal(tpDvVal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ttlLssCfmDt[i] != null)
					model.setTtlLssCfmDt(ttlLssCfmDt[i]);
				if (tmpseq[i] != null)
					model.setTmpseq(tmpseq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dsDvVal[i] != null)
					model.setDsDvVal(dsDvVal[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (scBal[i] != null)
					model.setScBal(scBal[i]);
				if (tpEqQty[i] != null)
					model.setTpEqQty(tpEqQty[i]);
				if (ttlLssDtlCmplDt[i] != null)
					model.setTtlLssDtlCmplDt(ttlLssDtlCmplDt[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (ttlLssN3ptyTpCd[i] != null)
					model.setTtlLssN3ptyTpCd(ttlLssN3ptyTpCd[i]);
				if (scExp[i] != null)
					model.setScExp(scExp[i]);
				if (ttlLssRsnNm[i] != null)
					model.setTtlLssRsnNm(ttlLssRsnNm[i]);
				if (scDvVal[i] != null)
					model.setScDvVal(scDvVal[i]);
				if (tpExp[i] != null)
					model.setTpExp(tpExp[i]);
				if (ttlLssDtlRsnNm[i] != null)
					model.setTtlLssDtlRsnNm(ttlLssDtlRsnNm[i]);
				if (irEqQty[i] != null)
					model.setIrEqQty(irEqQty[i]);
				if (tpBal[i] != null)
					model.setTpBal(tpBal[i]);
				if (irBal[i] != null)
					model.setIrBal(irBal[i]);
				if (ttlLssStsNm[i] != null)
					model.setTtlLssStsNm(ttlLssStsNm[i]);
				if (buyerName[i] != null)
					model.setBuyerName(buyerName[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (dvBal[i] != null)
					model.setDvBal(dvBal[i]);
				if (scEqQty[i] != null)
					model.setScEqQty(scEqQty[i]);
				if (irExp[i] != null)
					model.setIrExp(irExp[i]);
				if (usaEdiCd[i] != null)
					model.setUsaEdiCd(usaEdiCd[i]);
				if (ttlLssDt[i] != null)
					model.setTtlLssDt(ttlLssDt[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (dsBal[i] != null)
					model.setDsBal(dsBal[i]);
				if (ttlLssCmplNm[i] != null)
					model.setTtlLssCmplNm(ttlLssCmplNm[i]);
				if (respbOfcCd[i] != null)
					model.setRespbOfcCd(respbOfcCd[i]);
				if (ttlLssRsnCd[i] != null)
					model.setTtlLssRsnCd(ttlLssRsnCd[i]);
				if (ttlLssDtlCmplNm[i] != null)
					model.setTtlLssDtlCmplNm(ttlLssDtlCmplNm[i]);
				if (dvDvVal[i] != null)
					model.setDvDvVal(dvDvVal[i]);
				if (payerName[i] != null)
					model.setPayerName(payerName[i]);
				if (dsCurrCd[i] != null)
					model.setDsCurrCd(dsCurrCd[i]);
				if (dsUsdExp[i] != null)
					model.setDsUsdExp(dsUsdExp[i]);
				if (tpCurrCd[i] != null)
					model.setTpCurrCd(tpCurrCd[i]);
				if (tpUsdExp[i] != null)
					model.setTpUsdExp(tpUsdExp[i]);
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getTotalLossPerformanceVOs();
	}

	public TotalLossPerformanceVO[] getTotalLossPerformanceVOs(){
		TotalLossPerformanceVO[] vos = (TotalLossPerformanceVO[])models.toArray(new TotalLossPerformanceVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.dvExp = this.dvExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsEqQty = this.dsEqQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irDvVal = this.irDvVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltAmt = this.cltAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvEqQty = this.dvEqQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssNo = this.ttlLssNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsExp = this.dsExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpDvVal = this.tpDvVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCfmDt = this.ttlLssCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpseq = this.tmpseq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsDvVal = this.dsDvVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo = this.rqstEqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scBal = this.scBal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpEqQty = this.tpEqQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlCmplDt = this.ttlLssDtlCmplDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssN3ptyTpCd = this.ttlLssN3ptyTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExp = this.scExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssRsnNm = this.ttlLssRsnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scDvVal = this.scDvVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpExp = this.tpExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlRsnNm = this.ttlLssDtlRsnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irEqQty = this.irEqQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpBal = this.tpBal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irBal = this.irBal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssStsNm = this.ttlLssStsNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyerName = this.buyerName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvBal = this.dvBal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scEqQty = this.scEqQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irExp = this.irExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaEdiCd = this.usaEdiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDt = this.ttlLssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsBal = this.dsBal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCmplNm = this.ttlLssCmplNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbOfcCd = this.respbOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssRsnCd = this.ttlLssRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlCmplNm = this.ttlLssDtlCmplNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvDvVal = this.dvDvVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerName = this.payerName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsCurrCd = this.dsCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsUsdExp = this.dsUsdExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCurrCd = this.tpCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpUsdExp = this.tpUsdExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}