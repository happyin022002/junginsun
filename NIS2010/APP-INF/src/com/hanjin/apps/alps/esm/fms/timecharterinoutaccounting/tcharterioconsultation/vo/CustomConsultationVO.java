/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomConsultationVO.java
*@FileTitle : CustomConsultationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.06.30 최우석 
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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomConsultationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomConsultationVO> models = new ArrayList<CustomConsultationVO>();
	
	/* Column Info */
	private String rqstAmt = null;
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String csrDesc = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String evidTpCd = null;
	/* Column Info */
	private String ppayHirNo = null;
	/* Column Info */
	private String rvsSlpTpCd = null;
	/* Column Info */
	private String vatSlpFuncCd = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String diffDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String rvsSlpOfcCd = null;
	/* Column Info */
	private String cxlDesc = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String rvsSlpSerNo = null;
	/* Column Info */
	private String aproFlg = null;
	/* Column Info */
	private String vatSlpTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rvsSlpIssDt = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String vatSlpIssDt = null;
	/* Column Info */
	private String rvsSlpFuncCd = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String diffAmt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String vatSlpSerNo = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String mnlTpFlg = null;
	/* Column Info */
	private String vatSlpOfcCd = null;
	/* Column Info */
	private String slpSerNo = null;
	/* Column Info */
	private String csrUsrId = null;
	/* Column Info */
	private String aproStep = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomConsultationVO() {}

	public CustomConsultationVO(String ibflag, String pagerows, String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo, String fletCtrtNo, String csrCurrCd, String csrAmt, String csrUsrId, String csrDesc, String diffAmt, String diffDesc, String rqstAmt, String rqstDt, String effDt, String evidTpCd, String aproFlg, String aproDt, String cxlFlg, String cxlDesc, String mnlTpFlg, String rvsSlpTpCd, String rvsSlpFuncCd, String rvsSlpOfcCd, String rvsSlpIssDt, String rvsSlpSerNo, String vatSlpTpCd, String vatSlpFuncCd, String vatSlpOfcCd, String vatSlpIssDt, String vatSlpSerNo, String ppayHirNo, String creUsrId, String creDt, String updUsrId, String vndrSeq, String aproStep) {
		this.rqstAmt = rqstAmt;
		this.slpFuncCd = slpFuncCd;
		this.csrDesc = csrDesc;
		this.csrCurrCd = csrCurrCd;
		this.cxlFlg = cxlFlg;
		this.creDt = creDt;
		this.evidTpCd = evidTpCd;
		this.ppayHirNo = ppayHirNo;
		this.rvsSlpTpCd = rvsSlpTpCd;
		this.vatSlpFuncCd = vatSlpFuncCd;
		this.fletCtrtNo = fletCtrtNo;
		this.pagerows = pagerows;
		this.diffDesc = diffDesc;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.rvsSlpOfcCd = rvsSlpOfcCd;
		this.cxlDesc = cxlDesc;
		this.slpTpCd = slpTpCd;
		this.rvsSlpSerNo = rvsSlpSerNo;
		this.aproFlg = aproFlg;
		this.vatSlpTpCd = vatSlpTpCd;
		this.updUsrId = updUsrId;
		this.rvsSlpIssDt = rvsSlpIssDt;
		this.rqstDt = rqstDt;
		this.vatSlpIssDt = vatSlpIssDt;
		this.rvsSlpFuncCd = rvsSlpFuncCd;
		this.aproDt = aproDt;
		this.slpIssDt = slpIssDt;
		this.slpOfcCd = slpOfcCd;
		this.creUsrId = creUsrId;
		this.diffAmt = diffAmt;
		this.vndrSeq = vndrSeq;
		this.vatSlpSerNo = vatSlpSerNo;
		this.csrAmt = csrAmt;
		this.mnlTpFlg = mnlTpFlg;
		this.vatSlpOfcCd = vatSlpOfcCd;
		this.slpSerNo = slpSerNo;
		this.csrUsrId = csrUsrId;
		this.aproStep = aproStep;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_amt", getRqstAmt());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("evid_tp_cd", getEvidTpCd());
		this.hashColumns.put("ppay_hir_no", getPpayHirNo());
		this.hashColumns.put("rvs_slp_tp_cd", getRvsSlpTpCd());
		this.hashColumns.put("vat_slp_func_cd", getVatSlpFuncCd());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("diff_desc", getDiffDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("rvs_slp_ofc_cd", getRvsSlpOfcCd());
		this.hashColumns.put("cxl_desc", getCxlDesc());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("rvs_slp_ser_no", getRvsSlpSerNo());
		this.hashColumns.put("apro_flg", getAproFlg());
		this.hashColumns.put("vat_slp_tp_cd", getVatSlpTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rvs_slp_iss_dt", getRvsSlpIssDt());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("vat_slp_iss_dt", getVatSlpIssDt());
		this.hashColumns.put("rvs_slp_func_cd", getRvsSlpFuncCd());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("diff_amt", getDiffAmt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vat_slp_ser_no", getVatSlpSerNo());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("mnl_tp_flg", getMnlTpFlg());
		this.hashColumns.put("vat_slp_ofc_cd", getVatSlpOfcCd());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		this.hashColumns.put("csr_usr_id", getCsrUsrId());
		this.hashColumns.put("apro_step", getAproStep());		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_amt", "rqstAmt");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("evid_tp_cd", "evidTpCd");
		this.hashFields.put("ppay_hir_no", "ppayHirNo");
		this.hashFields.put("rvs_slp_tp_cd", "rvsSlpTpCd");
		this.hashFields.put("vat_slp_func_cd", "vatSlpFuncCd");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("diff_desc", "diffDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("rvs_slp_ofc_cd", "rvsSlpOfcCd");
		this.hashFields.put("cxl_desc", "cxlDesc");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("rvs_slp_ser_no", "rvsSlpSerNo");
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("vat_slp_tp_cd", "vatSlpTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rvs_slp_iss_dt", "rvsSlpIssDt");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("vat_slp_iss_dt", "vatSlpIssDt");
		this.hashFields.put("rvs_slp_func_cd", "rvsSlpFuncCd");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_amt", "diffAmt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vat_slp_ser_no", "vatSlpSerNo");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("mnl_tp_flg", "mnlTpFlg");
		this.hashFields.put("vat_slp_ofc_cd", "vatSlpOfcCd");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		this.hashFields.put("csr_usr_id", "csrUsrId");
		this.hashFields.put("apro_step", "aproStep");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rqstAmt
	 */
	public String getRqstAmt() {
		return this.rqstAmt;
	}
	
	/**
	 * Column Info
	 * @return slpFuncCd
	 */
	public String getSlpFuncCd() {
		return this.slpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return csrDesc
	 */
	public String getCsrDesc() {
		return this.csrDesc;
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
	 * @return cxlFlg
	 */
	public String getCxlFlg() {
		return this.cxlFlg;
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
	 * @return rvsSlpTpCd
	 */
	public String getRvsSlpTpCd() {
		return this.rvsSlpTpCd;
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
	 * @return diffDesc
	 */
	public String getDiffDesc() {
		return this.diffDesc;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return rvsSlpOfcCd
	 */
	public String getRvsSlpOfcCd() {
		return this.rvsSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cxlDesc
	 */
	public String getCxlDesc() {
		return this.cxlDesc;
	}
	
	/**
	 * Column Info
	 * @return slpTpCd
	 */
	public String getSlpTpCd() {
		return this.slpTpCd;
	}
	
	/**
	 * Column Info
	 * @return rvsSlpSerNo
	 */
	public String getRvsSlpSerNo() {
		return this.rvsSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @return aproFlg
	 */
	public String getAproFlg() {
		return this.aproFlg;
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
	 * @return rvsSlpIssDt
	 */
	public String getRvsSlpIssDt() {
		return this.rvsSlpIssDt;
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
	 * @return rvsSlpFuncCd
	 */
	public String getRvsSlpFuncCd() {
		return this.rvsSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
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
	 * @return slpOfcCd
	 */
	public String getSlpOfcCd() {
		return this.slpOfcCd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return csrAmt
	 */
	public String getCsrAmt() {
		return this.csrAmt;
	}
	
	/**
	 * Column Info
	 * @return mnlTpFlg
	 */
	public String getMnlTpFlg() {
		return this.mnlTpFlg;
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
	 * @return slpSerNo
	 */
	public String getSlpSerNo() {
		return this.slpSerNo;
	}
	
	/**
	 * Column Info
	 * @return csrUsrId
	 */
	public String getCsrUsrId() {
		return this.csrUsrId;
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
	 * @param rqstAmt
	 */
	public void setRqstAmt(String rqstAmt) {
		this.rqstAmt = rqstAmt;
	}
	
	/**
	 * Column Info
	 * @param slpFuncCd
	 */
	public void setSlpFuncCd(String slpFuncCd) {
		this.slpFuncCd = slpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param csrDesc
	 */
	public void setCsrDesc(String csrDesc) {
		this.csrDesc = csrDesc;
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
	 * @param cxlFlg
	 */
	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
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
	 * @param rvsSlpTpCd
	 */
	public void setRvsSlpTpCd(String rvsSlpTpCd) {
		this.rvsSlpTpCd = rvsSlpTpCd;
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
	 * @param diffDesc
	 */
	public void setDiffDesc(String diffDesc) {
		this.diffDesc = diffDesc;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param rvsSlpOfcCd
	 */
	public void setRvsSlpOfcCd(String rvsSlpOfcCd) {
		this.rvsSlpOfcCd = rvsSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cxlDesc
	 */
	public void setCxlDesc(String cxlDesc) {
		this.cxlDesc = cxlDesc;
	}
	
	/**
	 * Column Info
	 * @param slpTpCd
	 */
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
	}
	
	/**
	 * Column Info
	 * @param rvsSlpSerNo
	 */
	public void setRvsSlpSerNo(String rvsSlpSerNo) {
		this.rvsSlpSerNo = rvsSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @param aproFlg
	 */
	public void setAproFlg(String aproFlg) {
		this.aproFlg = aproFlg;
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
	 * @param rvsSlpIssDt
	 */
	public void setRvsSlpIssDt(String rvsSlpIssDt) {
		this.rvsSlpIssDt = rvsSlpIssDt;
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
	 * @param rvsSlpFuncCd
	 */
	public void setRvsSlpFuncCd(String rvsSlpFuncCd) {
		this.rvsSlpFuncCd = rvsSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
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
	 * @param slpOfcCd
	 */
	public void setSlpOfcCd(String slpOfcCd) {
		this.slpOfcCd = slpOfcCd;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param csrAmt
	 */
	public void setCsrAmt(String csrAmt) {
		this.csrAmt = csrAmt;
	}
	
	/**
	 * Column Info
	 * @param mnlTpFlg
	 */
	public void setMnlTpFlg(String mnlTpFlg) {
		this.mnlTpFlg = mnlTpFlg;
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
	 * @param slpSerNo
	 */
	public void setSlpSerNo(String slpSerNo) {
		this.slpSerNo = slpSerNo;
	}
	
	/**
	 * Column Info
	 * @param csrUsrId
	 */
	public void setCsrUsrId(String csrUsrId) {
		this.csrUsrId = csrUsrId;
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
		setRqstAmt(JSPUtil.getParameter(request, "rqst_amt", ""));
		setSlpFuncCd(JSPUtil.getParameter(request, "slp_func_cd", ""));
		setCsrDesc(JSPUtil.getParameter(request, "csr_desc", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, "csr_curr_cd", ""));
		setCxlFlg(JSPUtil.getParameter(request, "cxl_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setEvidTpCd(JSPUtil.getParameter(request, "evid_tp_cd", ""));
		setPpayHirNo(JSPUtil.getParameter(request, "ppay_hir_no", ""));
		setRvsSlpTpCd(JSPUtil.getParameter(request, "rvs_slp_tp_cd", ""));
		setVatSlpFuncCd(JSPUtil.getParameter(request, "vat_slp_func_cd", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDiffDesc(JSPUtil.getParameter(request, "diff_desc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setRvsSlpOfcCd(JSPUtil.getParameter(request, "rvs_slp_ofc_cd", ""));
		setCxlDesc(JSPUtil.getParameter(request, "cxl_desc", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setRvsSlpSerNo(JSPUtil.getParameter(request, "rvs_slp_ser_no", ""));
		setAproFlg(JSPUtil.getParameter(request, "apro_flg", ""));
		setVatSlpTpCd(JSPUtil.getParameter(request, "vat_slp_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRvsSlpIssDt(JSPUtil.getParameter(request, "rvs_slp_iss_dt", ""));
		setRqstDt(JSPUtil.getParameter(request, "rqst_dt", ""));
		setVatSlpIssDt(JSPUtil.getParameter(request, "vat_slp_iss_dt", ""));
		setRvsSlpFuncCd(JSPUtil.getParameter(request, "rvs_slp_func_cd", ""));
		setAproDt(JSPUtil.getParameter(request, "apro_dt", ""));
		setSlpIssDt(JSPUtil.getParameter(request, "slp_iss_dt", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, "slp_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setDiffAmt(JSPUtil.getParameter(request, "diff_amt", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setVatSlpSerNo(JSPUtil.getParameter(request, "vat_slp_ser_no", ""));
		setCsrAmt(JSPUtil.getParameter(request, "csr_amt", ""));
		setMnlTpFlg(JSPUtil.getParameter(request, "mnl_tp_flg", ""));
		setVatSlpOfcCd(JSPUtil.getParameter(request, "vat_slp_ofc_cd", ""));
		setSlpSerNo(JSPUtil.getParameter(request, "slp_ser_no", ""));
		setCsrUsrId(JSPUtil.getParameter(request, "csr_usr_id", ""));
		setAproStep(JSPUtil.getParameter(request, "apro_step", ""));		

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomConsultationVO[]
	 */
	public CustomConsultationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomConsultationVO[]
	 */
	public CustomConsultationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomConsultationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_amt", length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] evidTpCd = (JSPUtil.getParameter(request, prefix	+ "evid_tp_cd", length));
			String[] ppayHirNo = (JSPUtil.getParameter(request, prefix	+ "ppay_hir_no", length));
			String[] rvsSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "rvs_slp_tp_cd", length));
			String[] vatSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "vat_slp_func_cd", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] diffDesc = (JSPUtil.getParameter(request, prefix	+ "diff_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] rvsSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "rvs_slp_ofc_cd", length));
			String[] cxlDesc = (JSPUtil.getParameter(request, prefix	+ "cxl_desc", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] rvsSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "rvs_slp_ser_no", length));
			String[] aproFlg = (JSPUtil.getParameter(request, prefix	+ "apro_flg", length));
			String[] vatSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "vat_slp_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rvsSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "rvs_slp_iss_dt", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] vatSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "vat_slp_iss_dt", length));
			String[] rvsSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "rvs_slp_func_cd", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] diffAmt = (JSPUtil.getParameter(request, prefix	+ "diff_amt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vatSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "vat_slp_ser_no", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] mnlTpFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_tp_flg", length));
			String[] vatSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "vat_slp_ofc_cd", length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no", length));
			String[] csrUsrId = (JSPUtil.getParameter(request, prefix	+ "csr_usr_id", length));
			String[] aproStep = (JSPUtil.getParameter(request, prefix	+ "apro_step", length));			
			
			for (int i = 0; i < length; i++) {
				model = new CustomConsultationVO();
				if (rqstAmt[i] != null)
					model.setRqstAmt(rqstAmt[i]);
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (evidTpCd[i] != null)
					model.setEvidTpCd(evidTpCd[i]);
				if (ppayHirNo[i] != null)
					model.setPpayHirNo(ppayHirNo[i]);
				if (rvsSlpTpCd[i] != null)
					model.setRvsSlpTpCd(rvsSlpTpCd[i]);
				if (vatSlpFuncCd[i] != null)
					model.setVatSlpFuncCd(vatSlpFuncCd[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (diffDesc[i] != null)
					model.setDiffDesc(diffDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (rvsSlpOfcCd[i] != null)
					model.setRvsSlpOfcCd(rvsSlpOfcCd[i]);
				if (cxlDesc[i] != null)
					model.setCxlDesc(cxlDesc[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (rvsSlpSerNo[i] != null)
					model.setRvsSlpSerNo(rvsSlpSerNo[i]);
				if (aproFlg[i] != null)
					model.setAproFlg(aproFlg[i]);
				if (vatSlpTpCd[i] != null)
					model.setVatSlpTpCd(vatSlpTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rvsSlpIssDt[i] != null)
					model.setRvsSlpIssDt(rvsSlpIssDt[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (vatSlpIssDt[i] != null)
					model.setVatSlpIssDt(vatSlpIssDt[i]);
				if (rvsSlpFuncCd[i] != null)
					model.setRvsSlpFuncCd(rvsSlpFuncCd[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (diffAmt[i] != null)
					model.setDiffAmt(diffAmt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vatSlpSerNo[i] != null)
					model.setVatSlpSerNo(vatSlpSerNo[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (mnlTpFlg[i] != null)
					model.setMnlTpFlg(mnlTpFlg[i]);
				if (vatSlpOfcCd[i] != null)
					model.setVatSlpOfcCd(vatSlpOfcCd[i]);
				if (slpSerNo[i] != null)
					model.setSlpSerNo(slpSerNo[i]);
				if (csrUsrId[i] != null)
					model.setCsrUsrId(csrUsrId[i]);
				if (aproStep[i] != null)
					model.setAproStep(aproStep[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomConsultationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomConsultationVO[]
	 */
	public CustomConsultationVO[] getCustomConsultationVOs(){
		CustomConsultationVO[] vos = (CustomConsultationVO[])models.toArray(new CustomConsultationVO[models.size()]);
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
		this.rqstAmt = this.rqstAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evidTpCd = this.evidTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayHirNo = this.ppayHirNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsSlpTpCd = this.rvsSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatSlpFuncCd = this.vatSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffDesc = this.diffDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsSlpOfcCd = this.rvsSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlDesc = this.cxlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsSlpSerNo = this.rvsSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg = this.aproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatSlpTpCd = this.vatSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsSlpIssDt = this.rvsSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatSlpIssDt = this.vatSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsSlpFuncCd = this.rvsSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffAmt = this.diffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatSlpSerNo = this.vatSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlTpFlg = this.mnlTpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatSlpOfcCd = this.vatSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrUsrId = this.csrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproStep = this.aproStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		
	}
}
