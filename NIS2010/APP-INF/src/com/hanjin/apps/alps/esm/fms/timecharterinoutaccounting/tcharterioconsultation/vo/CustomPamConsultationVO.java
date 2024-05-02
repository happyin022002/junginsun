/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomPamConsultationVO.java
*@FileTitle : CustomPamConsultationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.28 정윤태 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomPamConsultationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomPamConsultationVO> models = new ArrayList<CustomPamConsultationVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String balanceAmt = null;
	/* Column Info */
	private String drAmt = null;
	/* Column Info */
	private String fletCtrtTpCd = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String evidTpCd = null;
	/* Column Info */
	private String ppayHirNo = null;
	/* Column Info */
	private String chkAcctCd = null;
	/* Column Info */
	private String slpDesc = null;
	/* Column Info */
	private String vatSlpFuncCd = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slpTp = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String ownrCd = null;
	/* Column Info */
	private String vatFlg = null;
	/* Column Info */
	private String usdLoclXchRt = null;
	/* Column Info */
	private String vatSlpTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String chkBunkerVvd = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String vatSlpIssDt = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String evidTpCdVal = null;
	/* Column Info */
	private String diffAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vatSlpSerNo = null;
	/* Column Info */
	private String chkCtrCd = null;
	/* Column Info */
	private String vatSlpOfcCd = null;
	/* Column Info */
	private String apCtrCd = null;
	/* Column Info */
	private String preWorkFlag = null;
	/* Column Info */
	private String autoFlg = null;
	/* Column Info */
	private String taxIssCd = null;
	/* Column Info */
	private String aproStep = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomPamConsultationVO() {}

	public CustomPamConsultationVO(String ibflag, String pagerows, String slpOfcCd, String apCtrCd, String locCd, String chkAcctCd, String chkCtrCd, String chkBunkerVvd, String preWorkFlag, String evidTpCdVal, String usdLoclXchRt, String fletCtrtNo, String vslCd, String vslEngNm, String fletCtrtTpCd, String csrCurrCd, String slpIssDt, String usrNm, String csrNo, String slpDesc, String slpTp, String evidTpCd, String rqstDt, String effDt, String ownrCd, String vatSlpTpCd, String vatSlpFuncCd, String vatSlpOfcCd, String vatSlpIssDt, String vatSlpSerNo, String ppayHirNo, String vatFlg, String creUsrId, String updUsrId, String drAmt, String diffAmt, String balanceAmt, String autoFlg, String taxIssCd, String aproStep) {
		this.vslCd = vslCd;
		this.balanceAmt = balanceAmt;
		this.drAmt = drAmt;
		this.fletCtrtTpCd = fletCtrtTpCd;
		this.csrCurrCd = csrCurrCd;
		this.evidTpCd = evidTpCd;
		this.ppayHirNo = ppayHirNo;
		this.chkAcctCd = chkAcctCd;
		this.slpDesc = slpDesc;
		this.vatSlpFuncCd = vatSlpFuncCd;
		this.fletCtrtNo = fletCtrtNo;
		this.pagerows = pagerows;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.slpTp = slpTp;
		this.effDt = effDt;
		this.vslEngNm = vslEngNm;
		this.usrNm = usrNm;
		this.ownrCd = ownrCd;
		this.vatFlg = vatFlg;
		this.usdLoclXchRt = usdLoclXchRt;
		this.vatSlpTpCd = vatSlpTpCd;
		this.updUsrId = updUsrId;
		this.chkBunkerVvd = chkBunkerVvd;
		this.csrNo = csrNo;
		this.rqstDt = rqstDt;
		this.vatSlpIssDt = vatSlpIssDt;
		this.slpOfcCd = slpOfcCd;
		this.slpIssDt = slpIssDt;
		this.evidTpCdVal = evidTpCdVal;
		this.diffAmt = diffAmt;
		this.creUsrId = creUsrId;
		this.vatSlpSerNo = vatSlpSerNo;
		this.chkCtrCd = chkCtrCd;
		this.vatSlpOfcCd = vatSlpOfcCd;
		this.apCtrCd = apCtrCd;
		this.preWorkFlag = preWorkFlag;
		this.autoFlg = autoFlg;
		this.taxIssCd = taxIssCd;
		this.aproStep = aproStep;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("balance_amt", getBalanceAmt());
		this.hashColumns.put("dr_amt", getDrAmt());
		this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("evid_tp_cd", getEvidTpCd());
		this.hashColumns.put("ppay_hir_no", getPpayHirNo());
		this.hashColumns.put("chk_acct_cd", getChkAcctCd());
		this.hashColumns.put("slp_desc", getSlpDesc());
		this.hashColumns.put("vat_slp_func_cd", getVatSlpFuncCd());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slp_tp", getSlpTp());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("ownr_cd", getOwnrCd());
		this.hashColumns.put("vat_flg", getVatFlg());
		this.hashColumns.put("usd_locl_xch_rt", getUsdLoclXchRt());
		this.hashColumns.put("vat_slp_tp_cd", getVatSlpTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("chk_bunker_vvd", getChkBunkerVvd());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("vat_slp_iss_dt", getVatSlpIssDt());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("evid_tp_cd_val", getEvidTpCdVal());
		this.hashColumns.put("diff_amt", getDiffAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vat_slp_ser_no", getVatSlpSerNo());
		this.hashColumns.put("chk_ctr_cd", getChkCtrCd());
		this.hashColumns.put("vat_slp_ofc_cd", getVatSlpOfcCd());
		this.hashColumns.put("ap_ctr_cd", getApCtrCd());
		this.hashColumns.put("pre_work_flag", getPreWorkFlag());
		this.hashColumns.put("auto_flg", getAutoFlg());
		this.hashColumns.put("tax_iss_cd", getTaxIssCd());
		this.hashColumns.put("apro_step", getAproStep());		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("balance_amt", "balanceAmt");
		this.hashFields.put("dr_amt", "drAmt");
		this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("evid_tp_cd", "evidTpCd");
		this.hashFields.put("ppay_hir_no", "ppayHirNo");
		this.hashFields.put("chk_acct_cd", "chkAcctCd");
		this.hashFields.put("slp_desc", "slpDesc");
		this.hashFields.put("vat_slp_func_cd", "vatSlpFuncCd");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slp_tp", "slpTp");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("ownr_cd", "ownrCd");
		this.hashFields.put("vat_flg", "vatFlg");
		this.hashFields.put("usd_locl_xch_rt", "usdLoclXchRt");
		this.hashFields.put("vat_slp_tp_cd", "vatSlpTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("chk_bunker_vvd", "chkBunkerVvd");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("vat_slp_iss_dt", "vatSlpIssDt");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("evid_tp_cd_val", "evidTpCdVal");
		this.hashFields.put("diff_amt", "diffAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vat_slp_ser_no", "vatSlpSerNo");
		this.hashFields.put("chk_ctr_cd", "chkCtrCd");
		this.hashFields.put("vat_slp_ofc_cd", "vatSlpOfcCd");
		this.hashFields.put("ap_ctr_cd", "apCtrCd");
		this.hashFields.put("pre_work_flag", "preWorkFlag");
		this.hashFields.put("auto_flg", "autoFlg");
		this.hashFields.put("tax_iss_cd", "taxIssCd");
		this.hashFields.put("apro_step", "aproStep");		
				
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
	 * @return balanceAmt
	 */
	public String getBalanceAmt() {
		return this.balanceAmt;
	}
	
	/**
	 * Column Info
	 * @return drAmt
	 */
	public String getDrAmt() {
		return this.drAmt;
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
	 * @return csrCurrCd
	 */
	public String getCsrCurrCd() {
		return this.csrCurrCd;
	}
	
	/**
	 * Column Info
	 * @return evidTpCd
	 */
	public String getEvidTpCd() {
		return this.evidTpCd;
	}
	
	/**
	 * Column Info
	 * @return ppayHirNo
	 */
	public String getPpayHirNo() {
		return this.ppayHirNo;
	}
	
	/**
	 * Column Info
	 * @return chkAcctCd
	 */
	public String getChkAcctCd() {
		return this.chkAcctCd;
	}
	
	/**
	 * Column Info
	 * @return slpDesc
	 */
	public String getSlpDesc() {
		return this.slpDesc;
	}
	
	/**
	 * Column Info
	 * @return vatSlpFuncCd
	 */
	public String getVatSlpFuncCd() {
		return this.vatSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return fletCtrtNo
	 */
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return slpTp
	 */
	public String getSlpTp() {
		return this.slpTp;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
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
	 * @return ownrCd
	 */
	public String getOwnrCd() {
		return this.ownrCd;
	}
	
	/**
	 * Column Info
	 * @return vatFlg
	 */
	public String getVatFlg() {
		return this.vatFlg;
	}
	
	/**
	 * Column Info
	 * @return usdLoclXchRt
	 */
	public String getUsdLoclXchRt() {
		return this.usdLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @return vatSlpTpCd
	 */
	public String getVatSlpTpCd() {
		return this.vatSlpTpCd;
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
	 * @return chkBunkerVvd
	 */
	public String getChkBunkerVvd() {
		return this.chkBunkerVvd;
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
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return vatSlpIssDt
	 */
	public String getVatSlpIssDt() {
		return this.vatSlpIssDt;
	}
	
	/**
	 * Column Info
	 * @return slpOfcCd
	 */
	public String getSlpOfcCd() {
		return this.slpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return slpIssDt
	 */
	public String getSlpIssDt() {
		return this.slpIssDt;
	}
	
	/**
	 * Column Info
	 * @return evidTpCdVal
	 */
	public String getEvidTpCdVal() {
		return this.evidTpCdVal;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return vatSlpSerNo
	 */
	public String getVatSlpSerNo() {
		return this.vatSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @return chkCtrCd
	 */
	public String getChkCtrCd() {
		return this.chkCtrCd;
	}
	
	/**
	 * Column Info
	 * @return vatSlpOfcCd
	 */
	public String getVatSlpOfcCd() {
		return this.vatSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return apCtrCd
	 */
	public String getApCtrCd() {
		return this.apCtrCd;
	}
	
	/**
	 * Column Info
	 * @return preWorkFlag
	 */
	public String getPreWorkFlag() {
		return this.preWorkFlag;
	}
	
	/**
	 * Column Info
	 * @return preWorkFlag
	 */
	public String getAutoFlg() {
		return this.autoFlg;
	}
	
	/**
	 * Column Info
	 * @return taxIssCd
	 */
	public String getTaxIssCd() {
		return this.taxIssCd;
	}
	
	/**
	 * Column Info
	 * @return aproStep
	 */
	public String getAproStep() {
		return this.aproStep;
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
	 * @param balanceAmt
	 */
	public void setBalanceAmt(String balanceAmt) {
		this.balanceAmt = balanceAmt;
	}
	
	/**
	 * Column Info
	 * @param drAmt
	 */
	public void setDrAmt(String drAmt) {
		this.drAmt = drAmt;
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
	 * @param csrCurrCd
	 */
	public void setCsrCurrCd(String csrCurrCd) {
		this.csrCurrCd = csrCurrCd;
	}
	
	/**
	 * Column Info
	 * @param evidTpCd
	 */
	public void setEvidTpCd(String evidTpCd) {
		this.evidTpCd = evidTpCd;
	}
	
	/**
	 * Column Info
	 * @param ppayHirNo
	 */
	public void setPpayHirNo(String ppayHirNo) {
		this.ppayHirNo = ppayHirNo;
	}
	
	/**
	 * Column Info
	 * @param chkAcctCd
	 */
	public void setChkAcctCd(String chkAcctCd) {
		this.chkAcctCd = chkAcctCd;
	}
	
	/**
	 * Column Info
	 * @param slpDesc
	 */
	public void setSlpDesc(String slpDesc) {
		this.slpDesc = slpDesc;
	}
	
	/**
	 * Column Info
	 * @param vatSlpFuncCd
	 */
	public void setVatSlpFuncCd(String vatSlpFuncCd) {
		this.vatSlpFuncCd = vatSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param fletCtrtNo
	 */
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param slpTp
	 */
	public void setSlpTp(String slpTp) {
		this.slpTp = slpTp;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
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
	 * @param ownrCd
	 */
	public void setOwnrCd(String ownrCd) {
		this.ownrCd = ownrCd;
	}
	
	/**
	 * Column Info
	 * @param vatFlg
	 */
	public void setVatFlg(String vatFlg) {
		this.vatFlg = vatFlg;
	}
	
	/**
	 * Column Info
	 * @param usdLoclXchRt
	 */
	public void setUsdLoclXchRt(String usdLoclXchRt) {
		this.usdLoclXchRt = usdLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @param vatSlpTpCd
	 */
	public void setVatSlpTpCd(String vatSlpTpCd) {
		this.vatSlpTpCd = vatSlpTpCd;
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
	 * @param chkBunkerVvd
	 */
	public void setChkBunkerVvd(String chkBunkerVvd) {
		this.chkBunkerVvd = chkBunkerVvd;
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
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param vatSlpIssDt
	 */
	public void setVatSlpIssDt(String vatSlpIssDt) {
		this.vatSlpIssDt = vatSlpIssDt;
	}
	
	/**
	 * Column Info
	 * @param slpOfcCd
	 */
	public void setSlpOfcCd(String slpOfcCd) {
		this.slpOfcCd = slpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param slpIssDt
	 */
	public void setSlpIssDt(String slpIssDt) {
		this.slpIssDt = slpIssDt;
	}
	
	/**
	 * Column Info
	 * @param evidTpCdVal
	 */
	public void setEvidTpCdVal(String evidTpCdVal) {
		this.evidTpCdVal = evidTpCdVal;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param vatSlpSerNo
	 */
	public void setVatSlpSerNo(String vatSlpSerNo) {
		this.vatSlpSerNo = vatSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @param chkCtrCd
	 */
	public void setChkCtrCd(String chkCtrCd) {
		this.chkCtrCd = chkCtrCd;
	}
	
	/**
	 * Column Info
	 * @param vatSlpOfcCd
	 */
	public void setVatSlpOfcCd(String vatSlpOfcCd) {
		this.vatSlpOfcCd = vatSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param apCtrCd
	 */
	public void setApCtrCd(String apCtrCd) {
		this.apCtrCd = apCtrCd;
	}
	
	/**
	 * Column Info
	 * @param preWorkFlag
	 */
	public void setPreWorkFlag(String preWorkFlag) {
		this.preWorkFlag = preWorkFlag;
	}
	
	/**
	 * Column Info
	 * @param autoFlg
	 */
	public void setAutoFlg(String autoFlg) {
		this.autoFlg = autoFlg;
	}
	
	/**
	 * Column Info
	 * @param taxIssCd
	 */
	public void setTaxIssCd(String taxIssCd) {
		this.taxIssCd = taxIssCd;
	}
	
	/**
	 * Column Info
	 * @param aproStep
	 */
	public void setAproStep(String aproStep) {
		this.aproStep = aproStep;
	}
	
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBalanceAmt(JSPUtil.getParameter(request, "balance_amt", ""));
		setDrAmt(JSPUtil.getParameter(request, "dr_amt", ""));
		setFletCtrtTpCd(JSPUtil.getParameter(request, "flet_ctrt_tp_cd", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, "csr_curr_cd", ""));
		setEvidTpCd(JSPUtil.getParameter(request, "evid_tp_cd", ""));
		setPpayHirNo(JSPUtil.getParameter(request, "ppay_hir_no", ""));
		setChkAcctCd(JSPUtil.getParameter(request, "chk_acct_cd", ""));
		setSlpDesc(JSPUtil.getParameter(request, "slp_desc", ""));
		setVatSlpFuncCd(JSPUtil.getParameter(request, "vat_slp_func_cd", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlpTp(JSPUtil.getParameter(request, "slp_tp", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setOwnrCd(JSPUtil.getParameter(request, "ownr_cd", ""));
		setVatFlg(JSPUtil.getParameter(request, "vat_flg", ""));
		setUsdLoclXchRt(JSPUtil.getParameter(request, "usd_locl_xch_rt", ""));
		setVatSlpTpCd(JSPUtil.getParameter(request, "vat_slp_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setChkBunkerVvd(JSPUtil.getParameter(request, "chk_bunker_vvd", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setRqstDt(JSPUtil.getParameter(request, "rqst_dt", ""));
		setVatSlpIssDt(JSPUtil.getParameter(request, "vat_slp_iss_dt", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, "slp_ofc_cd", ""));
		setSlpIssDt(JSPUtil.getParameter(request, "slp_iss_dt", ""));
		setEvidTpCdVal(JSPUtil.getParameter(request, "evid_tp_cd_val", ""));
		setDiffAmt(JSPUtil.getParameter(request, "diff_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setVatSlpSerNo(JSPUtil.getParameter(request, "vat_slp_ser_no", ""));
		setChkCtrCd(JSPUtil.getParameter(request, "chk_ctr_cd", ""));
		setVatSlpOfcCd(JSPUtil.getParameter(request, "vat_slp_ofc_cd", ""));
		setApCtrCd(JSPUtil.getParameter(request, "ap_ctr_cd", ""));
		setPreWorkFlag(JSPUtil.getParameter(request, "pre_work_flag", ""));
		setAutoFlg(JSPUtil.getParameter(request, "auto_flg", ""));
		setTaxIssCd(JSPUtil.getParameter(request, "tax_iss_cd", ""));
		setAproStep(JSPUtil.getParameter(request, "apro_step", ""));								
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomPamConsultationVO[]
	 */
	public CustomPamConsultationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomPamConsultationVO[]
	 */
	public CustomPamConsultationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomPamConsultationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] balanceAmt = (JSPUtil.getParameter(request, prefix	+ "balance_amt", length));
			String[] drAmt = (JSPUtil.getParameter(request, prefix	+ "dr_amt", length));
			String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_tp_cd", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] evidTpCd = (JSPUtil.getParameter(request, prefix	+ "evid_tp_cd", length));
			String[] ppayHirNo = (JSPUtil.getParameter(request, prefix	+ "ppay_hir_no", length));
			String[] chkAcctCd = (JSPUtil.getParameter(request, prefix	+ "chk_acct_cd", length));
			String[] slpDesc = (JSPUtil.getParameter(request, prefix	+ "slp_desc", length));
			String[] vatSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "vat_slp_func_cd", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slpTp = (JSPUtil.getParameter(request, prefix	+ "slp_tp", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] ownrCd = (JSPUtil.getParameter(request, prefix	+ "ownr_cd", length));
			String[] vatFlg = (JSPUtil.getParameter(request, prefix	+ "vat_flg", length));
			String[] usdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_locl_xch_rt", length));
			String[] vatSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "vat_slp_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] chkBunkerVvd = (JSPUtil.getParameter(request, prefix	+ "chk_bunker_vvd", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] vatSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "vat_slp_iss_dt", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] evidTpCdVal = (JSPUtil.getParameter(request, prefix	+ "evid_tp_cd_val", length));
			String[] diffAmt = (JSPUtil.getParameter(request, prefix	+ "diff_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vatSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "vat_slp_ser_no", length));
			String[] chkCtrCd = (JSPUtil.getParameter(request, prefix	+ "chk_ctr_cd", length));
			String[] vatSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "vat_slp_ofc_cd", length));
			String[] apCtrCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctr_cd", length));
			String[] preWorkFlag = (JSPUtil.getParameter(request, prefix	+ "pre_work_flag", length));
			String[] autoFlg = (JSPUtil.getParameter(request, prefix	+ "auto_flg", length));
			String[] taxIssCd = (JSPUtil.getParameter(request, prefix	+ "tax_iss_cd", length));
			String[] aproStep = (JSPUtil.getParameter(request, prefix	+ "apro_step", length));			
						
			for (int i = 0; i < length; i++) {
				model = new CustomPamConsultationVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (balanceAmt[i] != null)
					model.setBalanceAmt(balanceAmt[i]);
				if (drAmt[i] != null)
					model.setDrAmt(drAmt[i]);
				if (fletCtrtTpCd[i] != null)
					model.setFletCtrtTpCd(fletCtrtTpCd[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (evidTpCd[i] != null)
					model.setEvidTpCd(evidTpCd[i]);
				if (ppayHirNo[i] != null)
					model.setPpayHirNo(ppayHirNo[i]);
				if (chkAcctCd[i] != null)
					model.setChkAcctCd(chkAcctCd[i]);
				if (slpDesc[i] != null)
					model.setSlpDesc(slpDesc[i]);
				if (vatSlpFuncCd[i] != null)
					model.setVatSlpFuncCd(vatSlpFuncCd[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slpTp[i] != null)
					model.setSlpTp(slpTp[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (ownrCd[i] != null)
					model.setOwnrCd(ownrCd[i]);
				if (vatFlg[i] != null)
					model.setVatFlg(vatFlg[i]);
				if (usdLoclXchRt[i] != null)
					model.setUsdLoclXchRt(usdLoclXchRt[i]);
				if (vatSlpTpCd[i] != null)
					model.setVatSlpTpCd(vatSlpTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (chkBunkerVvd[i] != null)
					model.setChkBunkerVvd(chkBunkerVvd[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (vatSlpIssDt[i] != null)
					model.setVatSlpIssDt(vatSlpIssDt[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (evidTpCdVal[i] != null)
					model.setEvidTpCdVal(evidTpCdVal[i]);
				if (diffAmt[i] != null)
					model.setDiffAmt(diffAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vatSlpSerNo[i] != null)
					model.setVatSlpSerNo(vatSlpSerNo[i]);
				if (chkCtrCd[i] != null)
					model.setChkCtrCd(chkCtrCd[i]);
				if (vatSlpOfcCd[i] != null)
					model.setVatSlpOfcCd(vatSlpOfcCd[i]);
				if (apCtrCd[i] != null)
					model.setApCtrCd(apCtrCd[i]);
				if (preWorkFlag[i] != null)
					model.setPreWorkFlag(preWorkFlag[i]);
				if (autoFlg[i] != null)
					model.setAutoFlg(autoFlg[i]);
				if (taxIssCd[i] != null)
					model.setTaxIssCd(taxIssCd[i]);
				if (aproStep[i] != null)
					model.setAproStep(aproStep[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomPamConsultationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomPamConsultationVO[]
	 */
	public CustomPamConsultationVO[] getCustomPamConsultationVOs(){
		CustomPamConsultationVO[] vos = (CustomPamConsultationVO[])models.toArray(new CustomPamConsultationVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balanceAmt = this.balanceAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drAmt = this.drAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtTpCd = this.fletCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evidTpCd = this.evidTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayHirNo = this.ppayHirNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkAcctCd = this.chkAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpDesc = this.slpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatSlpFuncCd = this.vatSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTp = this.slpTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrCd = this.ownrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatFlg = this.vatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLoclXchRt = this.usdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatSlpTpCd = this.vatSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkBunkerVvd = this.chkBunkerVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatSlpIssDt = this.vatSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evidTpCdVal = this.evidTpCdVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffAmt = this.diffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatSlpSerNo = this.vatSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCtrCd = this.chkCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatSlpOfcCd = this.vatSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCtrCd = this.apCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preWorkFlag = this.preWorkFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoFlg = this.autoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxIssCd = this.taxIssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproStep = this.aproStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		
	}
}
