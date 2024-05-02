/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FmsConsultationVO.java
*@FileTitle : FmsConsultationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.22
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.02.22 손진환 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 손진환 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FmsConsultationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FmsConsultationVO> models = new ArrayList<FmsConsultationVO>();
	
	/* Column Info */
	private String rqstAmt = null;
	/* Column Info */
	private String apCxlFlg = null;
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
	private String vatSlpFuncCd = null;
	/* Column Info */
	private String oaInterMmDesc = null;
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
	private String cxlDesc = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String aproFlg = null;
	/* Column Info */
	private String vatSlpTpCd = null;
	/* Column Info */
	private String oaInvDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String docEvidTpCd = null;
	/* Column Info */
	private String vatSlpIssDt = null;
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

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FmsConsultationVO() {}

	public FmsConsultationVO(String ibflag, String pagerows, String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo, String fletCtrtNo, String csrCurrCd, String csrAmt, String csrUsrId, String csrDesc, String diffAmt, String diffDesc, String rqstAmt, String rqstDt, String effDt, String evidTpCd, String aproFlg, String aproDt, String cxlFlg, String cxlDesc, String mnlTpFlg, String vatSlpTpCd, String vatSlpFuncCd, String vatSlpOfcCd, String vatSlpIssDt, String vatSlpSerNo, String ppayHirNo, String creUsrId, String creDt, String updUsrId, String updDt, String docEvidTpCd, String apCxlFlg, String oaInterMmDesc, String oaInvDt) {
		this.rqstAmt = rqstAmt;
		this.apCxlFlg = apCxlFlg;
		this.slpFuncCd = slpFuncCd;
		this.csrDesc = csrDesc;
		this.csrCurrCd = csrCurrCd;
		this.cxlFlg = cxlFlg;
		this.creDt = creDt;
		this.evidTpCd = evidTpCd;
		this.ppayHirNo = ppayHirNo;
		this.vatSlpFuncCd = vatSlpFuncCd;
		this.oaInterMmDesc = oaInterMmDesc;
		this.fletCtrtNo = fletCtrtNo;
		this.pagerows = pagerows;
		this.diffDesc = diffDesc;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.cxlDesc = cxlDesc;
		this.slpTpCd = slpTpCd;
		this.aproFlg = aproFlg;
		this.vatSlpTpCd = vatSlpTpCd;
		this.oaInvDt = oaInvDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.rqstDt = rqstDt;
		this.docEvidTpCd = docEvidTpCd;
		this.vatSlpIssDt = vatSlpIssDt;
		this.aproDt = aproDt;
		this.slpIssDt = slpIssDt;
		this.slpOfcCd = slpOfcCd;
		this.creUsrId = creUsrId;
		this.diffAmt = diffAmt;
		this.vatSlpSerNo = vatSlpSerNo;
		this.csrAmt = csrAmt;
		this.mnlTpFlg = mnlTpFlg;
		this.vatSlpOfcCd = vatSlpOfcCd;
		this.slpSerNo = slpSerNo;
		this.csrUsrId = csrUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_amt", getRqstAmt());
		this.hashColumns.put("ap_cxl_flg", getApCxlFlg());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("evid_tp_cd", getEvidTpCd());
		this.hashColumns.put("ppay_hir_no", getPpayHirNo());
		this.hashColumns.put("vat_slp_func_cd", getVatSlpFuncCd());
		this.hashColumns.put("oa_inter_mm_desc", getOaInterMmDesc());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("diff_desc", getDiffDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cxl_desc", getCxlDesc());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("apro_flg", getAproFlg());
		this.hashColumns.put("vat_slp_tp_cd", getVatSlpTpCd());
		this.hashColumns.put("oa_inv_dt", getOaInvDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("doc_evid_tp_cd", getDocEvidTpCd());
		this.hashColumns.put("vat_slp_iss_dt", getVatSlpIssDt());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("diff_amt", getDiffAmt());
		this.hashColumns.put("vat_slp_ser_no", getVatSlpSerNo());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("mnl_tp_flg", getMnlTpFlg());
		this.hashColumns.put("vat_slp_ofc_cd", getVatSlpOfcCd());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		this.hashColumns.put("csr_usr_id", getCsrUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_amt", "rqstAmt");
		this.hashFields.put("ap_cxl_flg", "apCxlFlg");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("evid_tp_cd", "evidTpCd");
		this.hashFields.put("ppay_hir_no", "ppayHirNo");
		this.hashFields.put("vat_slp_func_cd", "vatSlpFuncCd");
		this.hashFields.put("oa_inter_mm_desc", "oaInterMmDesc");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("diff_desc", "diffDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cxl_desc", "cxlDesc");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("vat_slp_tp_cd", "vatSlpTpCd");
		this.hashFields.put("oa_inv_dt", "oaInvDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("doc_evid_tp_cd", "docEvidTpCd");
		this.hashFields.put("vat_slp_iss_dt", "vatSlpIssDt");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_amt", "diffAmt");
		this.hashFields.put("vat_slp_ser_no", "vatSlpSerNo");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("mnl_tp_flg", "mnlTpFlg");
		this.hashFields.put("vat_slp_ofc_cd", "vatSlpOfcCd");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		this.hashFields.put("csr_usr_id", "csrUsrId");
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
	 * @return apCxlFlg
	 */
	public String getApCxlFlg() {
		return this.apCxlFlg;
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
	 * @return vatSlpFuncCd
	 */
	public String getVatSlpFuncCd() {
		return this.vatSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return oaInterMmDesc
	 */
	public String getOaInterMmDesc() {
		return this.oaInterMmDesc;
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
	 * @return oaInvDt
	 */
	public String getOaInvDt() {
		return this.oaInvDt;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return docEvidTpCd
	 */
	public String getDocEvidTpCd() {
		return this.docEvidTpCd;
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
	 * @param rqstAmt
	 */
	public void setRqstAmt(String rqstAmt) {
		this.rqstAmt = rqstAmt;
	}
	
	/**
	 * Column Info
	 * @param apCxlFlg
	 */
	public void setApCxlFlg(String apCxlFlg) {
		this.apCxlFlg = apCxlFlg;
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
	 * @param vatSlpFuncCd
	 */
	public void setVatSlpFuncCd(String vatSlpFuncCd) {
		this.vatSlpFuncCd = vatSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param oaInterMmDesc
	 */
	public void setOaInterMmDesc(String oaInterMmDesc) {
		this.oaInterMmDesc = oaInterMmDesc;
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
	 * @param oaInvDt
	 */
	public void setOaInvDt(String oaInvDt) {
		this.oaInvDt = oaInvDt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param docEvidTpCd
	 */
	public void setDocEvidTpCd(String docEvidTpCd) {
		this.docEvidTpCd = docEvidTpCd;
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
		setRqstAmt(JSPUtil.getParameter(request, prefix + "rqst_amt", ""));
		setApCxlFlg(JSPUtil.getParameter(request, prefix + "ap_cxl_flg", ""));
		setSlpFuncCd(JSPUtil.getParameter(request, prefix + "slp_func_cd", ""));
		setCsrDesc(JSPUtil.getParameter(request, prefix + "csr_desc", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, prefix + "csr_curr_cd", ""));
		setCxlFlg(JSPUtil.getParameter(request, prefix + "cxl_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEvidTpCd(JSPUtil.getParameter(request, prefix + "evid_tp_cd", ""));
		setPpayHirNo(JSPUtil.getParameter(request, prefix + "ppay_hir_no", ""));
		setVatSlpFuncCd(JSPUtil.getParameter(request, prefix + "vat_slp_func_cd", ""));
		setOaInterMmDesc(JSPUtil.getParameter(request, prefix + "oa_inter_mm_desc", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, prefix + "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDiffDesc(JSPUtil.getParameter(request, prefix + "diff_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setCxlDesc(JSPUtil.getParameter(request, prefix + "cxl_desc", ""));
		setSlpTpCd(JSPUtil.getParameter(request, prefix + "slp_tp_cd", ""));
		setAproFlg(JSPUtil.getParameter(request, prefix + "apro_flg", ""));
		setVatSlpTpCd(JSPUtil.getParameter(request, prefix + "vat_slp_tp_cd", ""));
		setOaInvDt(JSPUtil.getParameter(request, prefix + "oa_inv_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setDocEvidTpCd(JSPUtil.getParameter(request, prefix + "doc_evid_tp_cd", ""));
		setVatSlpIssDt(JSPUtil.getParameter(request, prefix + "vat_slp_iss_dt", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setSlpIssDt(JSPUtil.getParameter(request, prefix + "slp_iss_dt", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, prefix + "slp_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDiffAmt(JSPUtil.getParameter(request, prefix + "diff_amt", ""));
		setVatSlpSerNo(JSPUtil.getParameter(request, prefix + "vat_slp_ser_no", ""));
		setCsrAmt(JSPUtil.getParameter(request, prefix + "csr_amt", ""));
		setMnlTpFlg(JSPUtil.getParameter(request, prefix + "mnl_tp_flg", ""));
		setVatSlpOfcCd(JSPUtil.getParameter(request, prefix + "vat_slp_ofc_cd", ""));
		setSlpSerNo(JSPUtil.getParameter(request, prefix + "slp_ser_no", ""));
		setCsrUsrId(JSPUtil.getParameter(request, prefix + "csr_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FmsConsultationVO[]
	 */
	public FmsConsultationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FmsConsultationVO[]
	 */
	public FmsConsultationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FmsConsultationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_amt", length));
			String[] apCxlFlg = (JSPUtil.getParameter(request, prefix	+ "ap_cxl_flg", length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] evidTpCd = (JSPUtil.getParameter(request, prefix	+ "evid_tp_cd", length));
			String[] ppayHirNo = (JSPUtil.getParameter(request, prefix	+ "ppay_hir_no", length));
			String[] vatSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "vat_slp_func_cd", length));
			String[] oaInterMmDesc = (JSPUtil.getParameter(request, prefix	+ "oa_inter_mm_desc", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] diffDesc = (JSPUtil.getParameter(request, prefix	+ "diff_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] cxlDesc = (JSPUtil.getParameter(request, prefix	+ "cxl_desc", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] aproFlg = (JSPUtil.getParameter(request, prefix	+ "apro_flg", length));
			String[] vatSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "vat_slp_tp_cd", length));
			String[] oaInvDt = (JSPUtil.getParameter(request, prefix	+ "oa_inv_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] docEvidTpCd = (JSPUtil.getParameter(request, prefix	+ "doc_evid_tp_cd", length));
			String[] vatSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "vat_slp_iss_dt", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] diffAmt = (JSPUtil.getParameter(request, prefix	+ "diff_amt", length));
			String[] vatSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "vat_slp_ser_no", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] mnlTpFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_tp_flg", length));
			String[] vatSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "vat_slp_ofc_cd", length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no", length));
			String[] csrUsrId = (JSPUtil.getParameter(request, prefix	+ "csr_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new FmsConsultationVO();
				if (rqstAmt[i] != null)
					model.setRqstAmt(rqstAmt[i]);
				if (apCxlFlg[i] != null)
					model.setApCxlFlg(apCxlFlg[i]);
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
				if (vatSlpFuncCd[i] != null)
					model.setVatSlpFuncCd(vatSlpFuncCd[i]);
				if (oaInterMmDesc[i] != null)
					model.setOaInterMmDesc(oaInterMmDesc[i]);
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
				if (cxlDesc[i] != null)
					model.setCxlDesc(cxlDesc[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (aproFlg[i] != null)
					model.setAproFlg(aproFlg[i]);
				if (vatSlpTpCd[i] != null)
					model.setVatSlpTpCd(vatSlpTpCd[i]);
				if (oaInvDt[i] != null)
					model.setOaInvDt(oaInvDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (docEvidTpCd[i] != null)
					model.setDocEvidTpCd(docEvidTpCd[i]);
				if (vatSlpIssDt[i] != null)
					model.setVatSlpIssDt(vatSlpIssDt[i]);
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
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFmsConsultationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FmsConsultationVO[]
	 */
	public FmsConsultationVO[] getFmsConsultationVOs(){
		FmsConsultationVO[] vos = (FmsConsultationVO[])models.toArray(new FmsConsultationVO[models.size()]);
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
		this.rqstAmt = this.rqstAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCxlFlg = this.apCxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evidTpCd = this.evidTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayHirNo = this.ppayHirNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatSlpFuncCd = this.vatSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaInterMmDesc = this.oaInterMmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffDesc = this.diffDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlDesc = this.cxlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg = this.aproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatSlpTpCd = this.vatSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaInvDt = this.oaInvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docEvidTpCd = this.docEvidTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatSlpIssDt = this.vatSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffAmt = this.diffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatSlpSerNo = this.vatSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlTpFlg = this.mnlTpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatSlpOfcCd = this.vatSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrUsrId = this.csrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
