package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

public class CustomMnrTtlLssRqstHdrVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<CustomMnrTtlLssRqstHdrVO> models = new ArrayList<CustomMnrTtlLssRqstHdrVO>();
	private String dvExp = null;
	private String dsEqQty = null;
	private String irDvVal = null;
	private String dvEqQty = null;
	private String ttlLssNo = null;
	private String dsExp = null;
	private String mnrStsRefNo = null;
	private String creDt = null;
	private String aproOfcCd = null;
	private String tpDvVal = null;
	private String pagerows = null;
	private String ttlLssCfmDt = null;
	private String ibflag = null;
	private String dsDvVal = null;
	private String tpEqQty = null;
	private String ttlLssIssDt = null;
	private String updUsrId = null;
	private String updDt = null;
	private String ttlLssCfmId = null;
	private String rqstDt = null;
	private String scExp = null;
	private String scDvVal = null;
	private String tpExp = null;
	private String ttlLssDtlRsnNm = null;
	private String dsVal = null;
	private String irEqQty = null;
	private String tpBal = null;
	private String creUsrId = null;
	private String dvBal = null;
	private String irVal = null;
	private String scEqQty = null;
	private String scVal = null;
	private String irExp = null;
	private String ttlLssDt = null;
	private String ttlLssRmk = null;
	private String ttlLssDtlRsnCd = null;
	private String rqstOfcCd = null;
	private String fileSeq = null;
	private String respbOfcCd = null;
	private String ttlLssRsnCd = null;
	private String ttlLssStsCd = null;
	private String respbOfcNm = null;
	private String dvDvVal = null;
	private String searchTtlLssNo = null;
	private String wrtfNo = null;
	private String wrtfRqstDt = null;
	private String wrtfStsCd = null;
	private String wrtfCltAmt = null;
	private String amtLoss = null;
	private String ttlLssRsnNm = null;
	private String dsCurrCd = null;
	private String dsUsdExp = null;
	private String tpCurrCd = null;
	private String tpUsdExp = null;
	
	private String accFlg = null;
	private String accDt = null;
	private String accVslCd = null;
	private String accSkdVoyNo = null;
	private String accSkdDirCd = null;
	private String accPortCd = null;
	private String pageSeparator = null;
	

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CustomMnrTtlLssRqstHdrVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dv_exp", getDvExp());
		this.hashColumns.put("ds_eq_qty", getDsEqQty());
		this.hashColumns.put("ir_dv_val", getIrDvVal());
		this.hashColumns.put("dv_eq_qty", getDvEqQty());
		this.hashColumns.put("ttl_lss_no", getTtlLssNo());
		this.hashColumns.put("ds_exp", getDsExp());
		this.hashColumns.put("mnr_sts_ref_no", getMnrStsRefNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("tp_dv_val", getTpDvVal());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ttl_lss_cfm_dt", getTtlLssCfmDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ds_dv_val", getDsDvVal());
		this.hashColumns.put("tp_eq_qty", getTpEqQty());
		this.hashColumns.put("ttl_lss_iss_dt", getTtlLssIssDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ttl_lss_cfm_id", getTtlLssCfmId());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("sc_exp", getScExp());
		this.hashColumns.put("sc_dv_val", getScDvVal());
		this.hashColumns.put("tp_exp", getTpExp());
		this.hashColumns.put("ttl_lss_dtl_rsn_nm", getTtlLssDtlRsnNm());
		this.hashColumns.put("ds_val", getDsVal());
		this.hashColumns.put("ir_eq_qty", getIrEqQty());
		this.hashColumns.put("tp_bal", getTpBal());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dv_bal", getDvBal());
		this.hashColumns.put("ir_val", getIrVal());
		this.hashColumns.put("sc_eq_qty", getScEqQty());
		this.hashColumns.put("sc_val", getScVal());
		this.hashColumns.put("ir_exp", getIrExp());
		this.hashColumns.put("ttl_lss_dt", getTtlLssDt());
		this.hashColumns.put("ttl_lss_rmk", getTtlLssRmk());
		this.hashColumns.put("ttl_lss_dtl_rsn_cd", getTtlLssDtlRsnCd());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("respb_ofc_cd", getRespbOfcCd());
		this.hashColumns.put("ttl_lss_rsn_cd", getTtlLssRsnCd());
		this.hashColumns.put("ttl_lss_sts_cd", getTtlLssStsCd());
		this.hashColumns.put("respb_ofc_nm", getRespbOfcNm());
		this.hashColumns.put("dv_dv_val", getDvDvVal());
		this.hashColumns.put("search_ttl_lss_no", getSearchTtlLssNo());
		this.hashColumns.put("wrtf_no", getWrtfNo());
		this.hashColumns.put("wrtf_rqst_dt", getWrtfRqstDt());
		this.hashColumns.put("wrtf_sts_cd", getWrtfStsCd());
		this.hashColumns.put("wrtf_clt_amt", getWrtfCltAmt());
		this.hashColumns.put("amt_loss", getAmtLoss());
		this.hashColumns.put("ttl_lss_rsn_nm", getTtlLssRsnNm());
		this.hashColumns.put("ds_curr_cd", getDsCurrCd());
		this.hashColumns.put("ds_usd_exp", getDsUsdExp());
		this.hashColumns.put("tp_curr_cd", getTpCurrCd());
		this.hashColumns.put("tp_usd_exp", getTpUsdExp());
		
		this.hashColumns.put("acc_flg", getAccFlg());
		this.hashColumns.put("acc_dt", getAccDt());
		this.hashColumns.put("acc_vsl_cd", getAccVslCd());
		this.hashColumns.put("acc_skd_voy_no", getAccSkdVoyNo());
		this.hashColumns.put("acc_skd_dir_cd", getAccSkdDirCd());
		this.hashColumns.put("acc_port_cd", getAccPortCd());
		this.hashColumns.put("page_separator", getPageSeparator());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dv_exp", "dvExp");
		this.hashFields.put("ds_eq_qty", "dsEqQty");
		this.hashFields.put("ir_dv_val", "irDvVal");
		this.hashFields.put("dv_eq_qty", "dvEqQty");
		this.hashFields.put("ttl_lss_no", "ttlLssNo");
		this.hashFields.put("ds_exp", "dsExp");
		this.hashFields.put("mnr_sts_ref_no", "mnrStsRefNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("tp_dv_val", "tpDvVal");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ttl_lss_cfm_dt", "ttlLssCfmDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ds_dv_val", "dsDvVal");
		this.hashFields.put("tp_eq_qty", "tpEqQty");
		this.hashFields.put("ttl_lss_iss_dt", "ttlLssIssDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ttl_lss_cfm_id", "ttlLssCfmId");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("sc_exp", "scExp");
		this.hashFields.put("sc_dv_val", "scDvVal");
		this.hashFields.put("tp_exp", "tpExp");
		this.hashFields.put("ttl_lss_dtl_rsn_nm", "ttlLssDtlRsnNm");
		this.hashFields.put("ds_val", "dsVal");
		this.hashFields.put("ir_eq_qty", "irEqQty");
		this.hashFields.put("tp_bal", "tpBal");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dv_bal", "dvBal");
		this.hashFields.put("ir_val", "irVal");
		this.hashFields.put("sc_eq_qty", "scEqQty");
		this.hashFields.put("sc_val", "scVal");
		this.hashFields.put("ir_exp", "irExp");
		this.hashFields.put("ttl_lss_dt", "ttlLssDt");
		this.hashFields.put("ttl_lss_rmk", "ttlLssRmk");
		this.hashFields.put("ttl_lss_dtl_rsn_cd", "ttlLssDtlRsnCd");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("respb_ofc_cd", "respbOfcCd");
		this.hashFields.put("ttl_lss_rsn_cd", "ttlLssRsnCd");
		this.hashFields.put("ttl_lss_sts_cd", "ttlLssStsCd");
		this.hashFields.put("respb_ofc_nm", "respbOfcNm");
		this.hashFields.put("dv_dv_val", "dvDvVal");
		this.hashFields.put("search_ttl_lss_no", "searchTtlLssNo");
		this.hashFields.put("wrtf_no", "wrtfNo");
		this.hashFields.put("wrtf_rqst_dt", "wrtfRqstDt");
		this.hashFields.put("wrtf_sts_cd", "wrtfStsCd");
		this.hashFields.put("wrtf_clt_amt", "wrtfCltAmt");
		this.hashFields.put("amt_loss", "amtLoss");
		this.hashFields.put("ttl_lss_rsn_nm", "ttlLssRsnNm");
		this.hashFields.put("ds_curr_cd", "dsCurrCd");
		this.hashFields.put("ds_usd_exp", "dsUsdExp");
		this.hashFields.put("tp_curr_cd", "tpCurrCd");
		this.hashFields.put("tp_usd_exp", "tpUsdExp");
		this.hashFields.put("acc_flg", "accFlg");
		this.hashFields.put("acc_dt", "accDt");
		this.hashFields.put("acc_vsl_cd", "accVslCd");
		this.hashFields.put("acc_skd_voy_no", "accSkdVoyNo");
		this.hashFields.put("acc_skd_dir_cd", "accSkdDirCd");
		this.hashFields.put("acc_port_cd", "accPortCd");
		this.hashFields.put("page_separator", "pageSeparator");
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

	public String getDvEqQty() {
		return this.dvEqQty;
	}

	public String getTtlLssNo() {
		return this.ttlLssNo;
	}

	public String getDsExp() {
		return this.dsExp;
	}

	public String getMnrStsRefNo() {
		return this.mnrStsRefNo;
	}

	public String getCreDt() {
		return this.creDt;
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

	public String getIbflag() {
		return this.ibflag;
	}

	public String getDsDvVal() {
		return this.dsDvVal;
	}

	public String getTpEqQty() {
		return this.tpEqQty;
	}

	public String getTtlLssIssDt() {
		return this.ttlLssIssDt;
	}

	public String getUpdUsrId() {
		return this.updUsrId;
	}

	public String getUpdDt() {
		return this.updDt;
	}

	public String getTtlLssCfmId() {
		return this.ttlLssCfmId;
	}

	public String getRqstDt() {
		return this.rqstDt;
	}

	public String getScExp() {
		return this.scExp;
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

	public String getDsVal() {
		return this.dsVal;
	}

	public String getIrEqQty() {
		return this.irEqQty;
	}

	public String getTpBal() {
		return this.tpBal;
	}

	public String getCreUsrId() {
		return this.creUsrId;
	}

	public String getDvBal() {
		return this.dvBal;
	}

	public String getIrVal() {
		return this.irVal;
	}

	public String getScEqQty() {
		return this.scEqQty;
	}

	public String getScVal() {
		return this.scVal;
	}

	public String getIrExp() {
		return this.irExp;
	}

	public String getTtlLssDt() {
		return this.ttlLssDt;
	}

	public String getTtlLssRmk() {
		return this.ttlLssRmk;
	}

	public String getTtlLssDtlRsnCd() {
		return this.ttlLssDtlRsnCd;
	}

	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}

	public String getFileSeq() {
		return this.fileSeq;
	}

	public String getRespbOfcCd() {
		return this.respbOfcCd;
	}

	public String getTtlLssRsnCd() {
		return this.ttlLssRsnCd;
	}

	public String getTtlLssStsCd() {
		return this.ttlLssStsCd;
	}

	public String getRespbOfcNm() {
		return this.respbOfcNm;
	}

	public String getDvDvVal() {
		return this.dvDvVal;
	}

	public String getSearchTtlLssNo() {
		return this.searchTtlLssNo;
	}

	public String getWrtfNo() {
		return this.wrtfNo;
	}

	public String getWrtfRqstDt() {
		return this.wrtfRqstDt;
	}

	public String getWrtfStsCd() {
		return this.wrtfStsCd;
	}

	public String getWrtfCltAmt() {
		return this.wrtfCltAmt;
	}

	public String getAmtLoss() {
		return this.amtLoss;
	}

	public String getTtlLssRsnNm() {
		return this.ttlLssRsnNm;
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
	
	public String getAccFlg() {
		return this.accFlg;
	}
	
	public String getAccDt() {
		return this.accDt;
	}
	
	public String getAccVslCd() {
		return this.accVslCd;
	}
	
	public String getAccSkdVoyNo() {
		return this.accSkdVoyNo;
	}
	
	public String getAccSkdDirCd() {
		return this.accSkdDirCd;
	}
	
	public String getAccPortCd() {
		return this.accPortCd;
	}
	
	public String getPageSeparator() {
		return this.pageSeparator;
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

	public void setDvEqQty(String dvEqQty) {
		this.dvEqQty = dvEqQty;
	}

	public void setTtlLssNo(String ttlLssNo) {
		this.ttlLssNo = ttlLssNo;
	}

	public void setDsExp(String dsExp) {
		this.dsExp = dsExp;
	}

	public void setMnrStsRefNo(String mnrStsRefNo) {
		this.mnrStsRefNo = mnrStsRefNo;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
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

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public void setDsDvVal(String dsDvVal) {
		this.dsDvVal = dsDvVal;
	}

	public void setTpEqQty(String tpEqQty) {
		this.tpEqQty = tpEqQty;
	}

	public void setTtlLssIssDt(String ttlLssIssDt) {
		this.ttlLssIssDt = ttlLssIssDt;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	public void setTtlLssCfmId(String ttlLssCfmId) {
		this.ttlLssCfmId = ttlLssCfmId;
	}

	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}

	public void setScExp(String scExp) {
		this.scExp = scExp;
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

	public void setDsVal(String dsVal) {
		this.dsVal = dsVal;
	}

	public void setIrEqQty(String irEqQty) {
		this.irEqQty = irEqQty;
	}

	public void setTpBal(String tpBal) {
		this.tpBal = tpBal;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public void setDvBal(String dvBal) {
		this.dvBal = dvBal;
	}

	public void setIrVal(String irVal) {
		this.irVal = irVal;
	}

	public void setScEqQty(String scEqQty) {
		this.scEqQty = scEqQty;
	}

	public void setScVal(String scVal) {
		this.scVal = scVal;
	}

	public void setIrExp(String irExp) {
		this.irExp = irExp;
	}

	public void setTtlLssDt(String ttlLssDt) {
		this.ttlLssDt = ttlLssDt;
	}

	public void setTtlLssRmk(String ttlLssRmk) {
		this.ttlLssRmk = ttlLssRmk;
	}

	public void setTtlLssDtlRsnCd(String ttlLssDtlRsnCd) {
		this.ttlLssDtlRsnCd = ttlLssDtlRsnCd;
	}

	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}

	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}

	public void setRespbOfcCd(String respbOfcCd) {
		this.respbOfcCd = respbOfcCd;
	}

	public void setTtlLssRsnCd(String ttlLssRsnCd) {
		this.ttlLssRsnCd = ttlLssRsnCd;
	}

	public void setTtlLssStsCd(String ttlLssStsCd) {
		this.ttlLssStsCd = ttlLssStsCd;
	}

	public void setRespbOfcNm(String respbOfcNm) {
		this.respbOfcNm = respbOfcNm;
	}

	public void setDvDvVal(String dvDvVal) {
		this.dvDvVal = dvDvVal;
	}

	public void setSearchTtlLssNo(String searchTtlLssNo) {
		this.searchTtlLssNo = searchTtlLssNo;
	}

	public void setWrtfNo(String wrtfNo) {
		this.wrtfNo = wrtfNo;
	}

	public void setWrtfRqstDt(String wrtfRqstDt) {
		this.wrtfRqstDt = wrtfRqstDt;
	}

	public void setWrtfStsCd(String wrtfStsCd) {
		this.wrtfStsCd = wrtfStsCd;
	}

	public void setWrtfCltAmt(String wrtfCltAmt) {
		this.wrtfCltAmt = wrtfCltAmt;
	}

	public void setAmtLoss(String amtLoss) {
		this.amtLoss = amtLoss;
	}

	public void setTtlLssRsnNm(String ttlLssRsnNm) {
		this.ttlLssRsnNm = ttlLssRsnNm;
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
	
	public void setAccFlg(String accFlg) {
		this.accFlg = accFlg;
	}
	
	public void setAccDt(String accDt) {
		this.accDt = accDt;
	}
	
	public void setAccVslCd(String accVslCd) {
		this.accVslCd = accVslCd;
	}
	
	public void setAccSkdVoyNo(String accSkdVoyNo) {
		this.accSkdVoyNo = accSkdVoyNo;
	}
	
	public void setAccSkdDirCd(String accSkdDirCd) {
		this.accSkdDirCd = accSkdDirCd;
	}
	
	public void setAccPortCd(String accPortCd) {
		this.accPortCd = accPortCd;
	}
	
	public void setPageSeparator(String pageSeparator) {
		this.pageSeparator = pageSeparator;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setDvExp(JSPUtil.getParameter(request, prefix + "dv_exp", ""));
		setDsEqQty(JSPUtil.getParameter(request, prefix + "ds_eq_qty", ""));
		setIrDvVal(JSPUtil.getParameter(request, prefix + "ir_dv_val", ""));
		setDvEqQty(JSPUtil.getParameter(request, prefix + "dv_eq_qty", ""));
		setTtlLssNo(JSPUtil.getParameter(request, prefix + "ttl_lss_no", ""));
		setDsExp(JSPUtil.getParameter(request, prefix + "ds_exp", ""));
		setMnrStsRefNo(JSPUtil.getParameter(request, prefix + "mnr_sts_ref_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setTpDvVal(JSPUtil.getParameter(request, prefix + "tp_dv_val", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTtlLssCfmDt(JSPUtil.getParameter(request, prefix + "ttl_lss_cfm_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDsDvVal(JSPUtil.getParameter(request, prefix + "ds_dv_val", ""));
		setTpEqQty(JSPUtil.getParameter(request, prefix + "tp_eq_qty", ""));
		setTtlLssIssDt(JSPUtil.getParameter(request, prefix + "ttl_lss_iss_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTtlLssCfmId(JSPUtil.getParameter(request, prefix + "ttl_lss_cfm_id", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setScExp(JSPUtil.getParameter(request, prefix + "sc_exp", ""));
		setScDvVal(JSPUtil.getParameter(request, prefix + "sc_dv_val", ""));
		setTpExp(JSPUtil.getParameter(request, prefix + "tp_exp", ""));
		setTtlLssDtlRsnNm(JSPUtil.getParameter(request, prefix + "ttl_lss_dtl_rsn_nm", ""));
		setDsVal(JSPUtil.getParameter(request, prefix + "ds_val", ""));
		setIrEqQty(JSPUtil.getParameter(request, prefix + "ir_eq_qty", ""));
		setTpBal(JSPUtil.getParameter(request, prefix + "tp_bal", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDvBal(JSPUtil.getParameter(request, prefix + "dv_bal", ""));
		setIrVal(JSPUtil.getParameter(request, prefix + "ir_val", ""));
		setScEqQty(JSPUtil.getParameter(request, prefix + "sc_eq_qty", ""));
		setScVal(JSPUtil.getParameter(request, prefix + "sc_val", ""));
		setIrExp(JSPUtil.getParameter(request, prefix + "ir_exp", ""));
		setTtlLssDt(JSPUtil.getParameter(request, prefix + "ttl_lss_dt", ""));
		setTtlLssRmk(JSPUtil.getParameter(request, prefix + "ttl_lss_rmk", ""));
		setTtlLssDtlRsnCd(JSPUtil.getParameter(request, prefix + "ttl_lss_dtl_rsn_cd", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setRespbOfcCd(JSPUtil.getParameter(request, prefix + "respb_ofc_cd", ""));
		setTtlLssRsnCd(JSPUtil.getParameter(request, prefix + "ttl_lss_rsn_cd", ""));
		setTtlLssStsCd(JSPUtil.getParameter(request, prefix + "ttl_lss_sts_cd", ""));
		setRespbOfcNm(JSPUtil.getParameter(request, prefix + "respb_ofc_nm", ""));
		setDvDvVal(JSPUtil.getParameter(request, prefix + "dv_dv_val", ""));
		setSearchTtlLssNo(JSPUtil.getParameter(request, prefix + "search_ttl_lss_no", ""));
		setWrtfNo(JSPUtil.getParameter(request, prefix + "wrtf_no", ""));
		setWrtfRqstDt(JSPUtil.getParameter(request, prefix + "wrtf_rqst_dt", ""));
		setWrtfStsCd(JSPUtil.getParameter(request, prefix + "wrtf_sts_cd", ""));
		setWrtfCltAmt(JSPUtil.getParameter(request, prefix + "wrtf_clt_amt", ""));
		setAmtLoss(JSPUtil.getParameter(request, prefix + "amt_loss", ""));
		setTtlLssRsnNm(JSPUtil.getParameter(request, prefix + "ttl_lss_rsn_nm", ""));
		setDsCurrCd(JSPUtil.getParameter(request, prefix + "ds_curr_cd", ""));
		setDsUsdExp(JSPUtil.getParameter(request, prefix + "ds_usd_exp", ""));
		setTpCurrCd(JSPUtil.getParameter(request, prefix + "tp_curr_cd", ""));
		setTpUsdExp(JSPUtil.getParameter(request, prefix + "tp_usd_exp", ""));
		setAccFlg(JSPUtil.getParameter(request, prefix + "acc_flg", ""));
		setAccDt(JSPUtil.getParameter(request, prefix + "acc_dt", ""));
		setAccVslCd(JSPUtil.getParameter(request, prefix + "acc_vsl_cd", ""));
		setAccSkdVoyNo(JSPUtil.getParameter(request, prefix + "acc_skd_voy_no", ""));
		setAccSkdDirCd(JSPUtil.getParameter(request, prefix + "acc_skd_dir_cd", ""));
		setAccPortCd(JSPUtil.getParameter(request, prefix + "acc_port_cd", ""));
		setPageSeparator(JSPUtil.getParameter(request, prefix + "page_separator", ""));
	}

	public CustomMnrTtlLssRqstHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CustomMnrTtlLssRqstHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrTtlLssRqstHdrVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] dvExp = (JSPUtil.getParameter(request, prefix	+ "dv_exp", length));
			String[] dsEqQty = (JSPUtil.getParameter(request, prefix	+ "ds_eq_qty", length));
			String[] irDvVal = (JSPUtil.getParameter(request, prefix	+ "ir_dv_val", length));
			String[] dvEqQty = (JSPUtil.getParameter(request, prefix	+ "dv_eq_qty", length));
			String[] ttlLssNo = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_no", length));
			String[] dsExp = (JSPUtil.getParameter(request, prefix	+ "ds_exp", length));
			String[] mnrStsRefNo = (JSPUtil.getParameter(request, prefix	+ "mnr_sts_ref_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] tpDvVal = (JSPUtil.getParameter(request, prefix	+ "tp_dv_val", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ttlLssCfmDt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_cfm_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dsDvVal = (JSPUtil.getParameter(request, prefix	+ "ds_dv_val", length));
			String[] tpEqQty = (JSPUtil.getParameter(request, prefix	+ "tp_eq_qty", length));
			String[] ttlLssIssDt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_iss_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ttlLssCfmId = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_cfm_id", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] scExp = (JSPUtil.getParameter(request, prefix	+ "sc_exp", length));
			String[] scDvVal = (JSPUtil.getParameter(request, prefix	+ "sc_dv_val", length));
			String[] tpExp = (JSPUtil.getParameter(request, prefix	+ "tp_exp", length));
			String[] ttlLssDtlRsnNm = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dtl_rsn_nm", length));
			String[] dsVal = (JSPUtil.getParameter(request, prefix	+ "ds_val", length));
			String[] irEqQty = (JSPUtil.getParameter(request, prefix	+ "ir_eq_qty", length));
			String[] tpBal = (JSPUtil.getParameter(request, prefix	+ "tp_bal", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] dvBal = (JSPUtil.getParameter(request, prefix	+ "dv_bal", length));
			String[] irVal = (JSPUtil.getParameter(request, prefix	+ "ir_val", length));
			String[] scEqQty = (JSPUtil.getParameter(request, prefix	+ "sc_eq_qty", length));
			String[] scVal = (JSPUtil.getParameter(request, prefix	+ "sc_val", length));
			String[] irExp = (JSPUtil.getParameter(request, prefix	+ "ir_exp", length));
			String[] ttlLssDt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dt", length));
			String[] ttlLssRmk = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_rmk", length));
			String[] ttlLssDtlRsnCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dtl_rsn_cd", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] respbOfcCd = (JSPUtil.getParameter(request, prefix	+ "respb_ofc_cd", length));
			String[] ttlLssRsnCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_rsn_cd", length));
			String[] ttlLssStsCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_sts_cd", length));
			String[] respbOfcNm = (JSPUtil.getParameter(request, prefix	+ "respb_ofc_nm", length));
			String[] dvDvVal = (JSPUtil.getParameter(request, prefix	+ "dv_dv_val", length));
			String[] searchTtlLssNo = (JSPUtil.getParameter(request, prefix	+ "search_ttl_lss_no", length));
			String[] wrtfNo = (JSPUtil.getParameter(request, prefix	+ "wrtf_no", length));
			String[] wrtfRqstDt = (JSPUtil.getParameter(request, prefix	+ "wrtf_rqst_dt", length));
			String[] wrtfStsCd = (JSPUtil.getParameter(request, prefix	+ "wrtf_sts_cd", length));
			String[] wrtfCltAmt = (JSPUtil.getParameter(request, prefix	+ "wrtf_clt_amt", length));
			String[] amtLoss = (JSPUtil.getParameter(request, prefix	+ "amt_loss", length));
			String[] ttlLssRsnNm = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_rsn_nm", length));
			String[] dsCurrCd = (JSPUtil.getParameter(request, prefix	+ "ds_curr_cd", length));
			String[] dsUsdExp = (JSPUtil.getParameter(request, prefix	+ "ds_usd_exp", length));
			String[] tpCurrCd = (JSPUtil.getParameter(request, prefix	+ "tp_curr_cd", length));
			String[] tpUsdExp = (JSPUtil.getParameter(request, prefix	+ "tp_usd_exp", length));
			String[] accFlg = (JSPUtil.getParameter(request, prefix	+ "acc_flg", length));
			String[] accDt = (JSPUtil.getParameter(request, prefix	+ "acc_dt", length));
			String[] accVslCd = (JSPUtil.getParameter(request, prefix	+ "acc_vsl_cd", length));
			String[] accSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "acc_skd_voy_no", length));
			String[] accSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "acc_skd_dir_cd", length));
			String[] accPortCd = (JSPUtil.getParameter(request, prefix	+ "acc_port_cd", length));
			String[] pageSeparator = (JSPUtil.getParameter(request, prefix	+ "page_separator", length));
			for (int i = 0; i < length; i++) {
				model = new CustomMnrTtlLssRqstHdrVO();
				if (dvExp[i] != null)
					model.setDvExp(dvExp[i]);
				if (dsEqQty[i] != null)
					model.setDsEqQty(dsEqQty[i]);
				if (irDvVal[i] != null)
					model.setIrDvVal(irDvVal[i]);
				if (dvEqQty[i] != null)
					model.setDvEqQty(dvEqQty[i]);
				if (ttlLssNo[i] != null)
					model.setTtlLssNo(ttlLssNo[i]);
				if (dsExp[i] != null)
					model.setDsExp(dsExp[i]);
				if (mnrStsRefNo[i] != null)
					model.setMnrStsRefNo(mnrStsRefNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (tpDvVal[i] != null)
					model.setTpDvVal(tpDvVal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ttlLssCfmDt[i] != null)
					model.setTtlLssCfmDt(ttlLssCfmDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dsDvVal[i] != null)
					model.setDsDvVal(dsDvVal[i]);
				if (tpEqQty[i] != null)
					model.setTpEqQty(tpEqQty[i]);
				if (ttlLssIssDt[i] != null)
					model.setTtlLssIssDt(ttlLssIssDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ttlLssCfmId[i] != null)
					model.setTtlLssCfmId(ttlLssCfmId[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (scExp[i] != null)
					model.setScExp(scExp[i]);
				if (scDvVal[i] != null)
					model.setScDvVal(scDvVal[i]);
				if (tpExp[i] != null)
					model.setTpExp(tpExp[i]);
				if (ttlLssDtlRsnNm[i] != null)
					model.setTtlLssDtlRsnNm(ttlLssDtlRsnNm[i]);
				if (dsVal[i] != null)
					model.setDsVal(dsVal[i]);
				if (irEqQty[i] != null)
					model.setIrEqQty(irEqQty[i]);
				if (tpBal[i] != null)
					model.setTpBal(tpBal[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (dvBal[i] != null)
					model.setDvBal(dvBal[i]);
				if (irVal[i] != null)
					model.setIrVal(irVal[i]);
				if (scEqQty[i] != null)
					model.setScEqQty(scEqQty[i]);
				if (scVal[i] != null)
					model.setScVal(scVal[i]);
				if (irExp[i] != null)
					model.setIrExp(irExp[i]);
				if (ttlLssDt[i] != null)
					model.setTtlLssDt(ttlLssDt[i]);
				if (ttlLssRmk[i] != null)
					model.setTtlLssRmk(ttlLssRmk[i]);
				if (ttlLssDtlRsnCd[i] != null)
					model.setTtlLssDtlRsnCd(ttlLssDtlRsnCd[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (respbOfcCd[i] != null)
					model.setRespbOfcCd(respbOfcCd[i]);
				if (ttlLssRsnCd[i] != null)
					model.setTtlLssRsnCd(ttlLssRsnCd[i]);
				if (ttlLssStsCd[i] != null)
					model.setTtlLssStsCd(ttlLssStsCd[i]);
				if (respbOfcNm[i] != null)
					model.setRespbOfcNm(respbOfcNm[i]);
				if (dvDvVal[i] != null)
					model.setDvDvVal(dvDvVal[i]);
				if (searchTtlLssNo[i] != null)
					model.setSearchTtlLssNo(searchTtlLssNo[i]);
				if (wrtfNo[i] != null)
					model.setWrtfNo(wrtfNo[i]);
				if (wrtfRqstDt[i] != null)
					model.setWrtfRqstDt(wrtfRqstDt[i]);
				if (wrtfStsCd[i] != null)
					model.setWrtfStsCd(wrtfStsCd[i]);
				if (wrtfCltAmt[i] != null)
					model.setWrtfCltAmt(wrtfCltAmt[i]);
				if (amtLoss[i] != null)
					model.setAmtLoss(amtLoss[i]);
				if (ttlLssRsnNm[i] != null)
					model.setTtlLssRsnNm(ttlLssRsnNm[i]);
				if (dsCurrCd[i] != null)
					model.setDsCurrCd(dsCurrCd[i]);
				if (dsUsdExp[i] != null)
					model.setDsUsdExp(dsUsdExp[i]);
				if (tpCurrCd[i] != null)
					model.setTpCurrCd(tpCurrCd[i]);
				if (tpUsdExp[i] != null)
					model.setTpUsdExp(tpUsdExp[i]);
				if (accFlg[i] != null)
					model.setAccFlg(accFlg[i]);
				if (accDt[i] != null)
					model.setAccDt(accDt[i]);
				if (accVslCd[i] != null)
					model.setAccVslCd(accVslCd[i]);
				if (accSkdVoyNo[i] != null)
					model.setAccSkdVoyNo(accSkdVoyNo[i]);
				if (accSkdDirCd[i] != null)
					model.setAccSkdDirCd(accSkdDirCd[i]);
				if (accPortCd[i] != null)
					model.setAccPortCd(accPortCd[i]);
				if (pageSeparator[i] != null)
					model.setPageSeparator(pageSeparator[i]);
				
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getCustomMnrTtlLssRqstHdrVOs();
	}

	public CustomMnrTtlLssRqstHdrVO[] getCustomMnrTtlLssRqstHdrVOs(){
		CustomMnrTtlLssRqstHdrVO[] vos = (CustomMnrTtlLssRqstHdrVO[])models.toArray(new CustomMnrTtlLssRqstHdrVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.dvExp = this.dvExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsEqQty = this.dsEqQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irDvVal = this.irDvVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvEqQty = this.dvEqQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssNo = this.ttlLssNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsExp = this.dsExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrStsRefNo = this.mnrStsRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpDvVal = this.tpDvVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCfmDt = this.ttlLssCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsDvVal = this.dsDvVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpEqQty = this.tpEqQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssIssDt = this.ttlLssIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCfmId = this.ttlLssCfmId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExp = this.scExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scDvVal = this.scDvVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpExp = this.tpExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlRsnNm = this.ttlLssDtlRsnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsVal = this.dsVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irEqQty = this.irEqQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpBal = this.tpBal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvBal = this.dvBal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irVal = this.irVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scEqQty = this.scEqQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scVal = this.scVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irExp = this.irExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDt = this.ttlLssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssRmk = this.ttlLssRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlRsnCd = this.ttlLssDtlRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbOfcCd = this.respbOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssRsnCd = this.ttlLssRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssStsCd = this.ttlLssStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbOfcNm = this.respbOfcNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvDvVal = this.dvDvVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchTtlLssNo = this.searchTtlLssNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfNo = this.wrtfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfRqstDt = this.wrtfRqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfStsCd = this.wrtfStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfCltAmt = this.wrtfCltAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtLoss = this.amtLoss.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssRsnNm = this.ttlLssRsnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsCurrCd = this.dsCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsUsdExp = this.dsUsdExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCurrCd = this.tpCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpUsdExp = this.tpUsdExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accFlg = this.accFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accDt = this.accDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accVslCd = this.accVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accSkdVoyNo = this.accSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accSkdDirCd = this.accSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accPortCd = this.accPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageSeparator = this.pageSeparator.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}