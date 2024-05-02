/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AgentActualINFtoAPCheckVO.java
*@FileTitle : AgentActualINFtoAPCheckVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.04
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.04.04 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgentActualINFtoAPCheckVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgentActualINFtoAPCheckVO> models = new ArrayList<AgentActualINFtoAPCheckVO>();
	
	/* Column Info */
	private String aproStep = null;
	/* Column Info */
	private String errVvdLvlBkgNo = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String dtrbCnt = null;
	/* Column Info */
	private String fincRgnCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String asaCurrCd = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String errVvdLvlVvdCd = null;
	/* Column Info */
	private String sRevChg = null;
	/* Column Info */
	private String errBkgCreDt = null;
	/* Column Info */
	private String pgmNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String errBkgNo = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String errVvdLvlFlgBkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String vndrNo = null;
	/* Column Info */
	private String creUsrEml = null;
	/* Column Info */
	private String errVvd = null;
	/* Column Info */
	private String tjOfcCd = null;
	/* Column Info */
	private String invTaxRt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String payGrpLuCd = null;
	/* Column Info */
	private String apOfcCd = null;
	/* Column Info */
	private String vndrTermNm = null;
	/* Column Info */
	private String errVvdBkgNo = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String offsetFlg = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String payMzdLuCd = null;
	/* Column Info */
	private String comAprNos = null;
	/* Column Info */
	private String invTermDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String errVvdLvlFlgVvdCd = null;
	/* Column Info */
	private String asaCnt = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String asaNo = null;
	/* Column Info */
	private String coaIntrCmpyCd = null;
	/* Column Info */
	private String srcCtnt = null;
	/* Column Info */
	private String apCtrCd = null;
	/* Column Info */
	private String localDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AgentActualINFtoAPCheckVO() {}

	public AgentActualINFtoAPCheckVO(String ibflag, String pagerows, String errVvdLvlBkgNo, String aproStep, String glDt, String currCd, String fincRgnCd, String dtrbCnt, String asaCurrCd, String csrCurrCd, String errVvdLvlVvdCd, String errBkgCreDt, String pgmNo, String errBkgNo, String agnCd, String errVvdLvlFlgBkgNo, String invDesc, String vndrNo, String creUsrEml, String errVvd, String tjOfcCd, String invTaxRt, String updUsrId, String invDt, String csrNo, String vndrTermNm, String apOfcCd, String payGrpLuCd, String errVvdBkgNo, String arHdQtrOfcCd, String offsetFlg, String creUsrNm, String arOfcCd, String creUsrId, String invTermDt, String comAprNos, String payMzdLuCd, String errVvdLvlFlgVvdCd, String vndrSeq, String asaCnt, String csrAmt, String srcCtnt, String coaIntrCmpyCd, String asaNo, String apCtrCd, String localDt, String sRevChg) {
		this.aproStep = aproStep;
		this.errVvdLvlBkgNo = errVvdLvlBkgNo;
		this.glDt = glDt;
		this.dtrbCnt = dtrbCnt;
		this.fincRgnCd = fincRgnCd;
		this.currCd = currCd;
		this.asaCurrCd = asaCurrCd;
		this.csrCurrCd = csrCurrCd;
		this.errVvdLvlVvdCd = errVvdLvlVvdCd;
		this.sRevChg = sRevChg;
		this.errBkgCreDt = errBkgCreDt;
		this.pgmNo = pgmNo;
		this.pagerows = pagerows;
		this.errBkgNo = errBkgNo;
		this.agnCd = agnCd;
		this.errVvdLvlFlgBkgNo = errVvdLvlFlgBkgNo;
		this.ibflag = ibflag;
		this.invDesc = invDesc;
		this.vndrNo = vndrNo;
		this.creUsrEml = creUsrEml;
		this.errVvd = errVvd;
		this.tjOfcCd = tjOfcCd;
		this.invTaxRt = invTaxRt;
		this.updUsrId = updUsrId;
		this.invDt = invDt;
		this.csrNo = csrNo;
		this.payGrpLuCd = payGrpLuCd;
		this.apOfcCd = apOfcCd;
		this.vndrTermNm = vndrTermNm;
		this.errVvdBkgNo = errVvdBkgNo;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.offsetFlg = offsetFlg;
		this.creUsrNm = creUsrNm;
		this.arOfcCd = arOfcCd;
		this.creUsrId = creUsrId;
		this.payMzdLuCd = payMzdLuCd;
		this.comAprNos = comAprNos;
		this.invTermDt = invTermDt;
		this.vndrSeq = vndrSeq;
		this.errVvdLvlFlgVvdCd = errVvdLvlFlgVvdCd;
		this.asaCnt = asaCnt;
		this.csrAmt = csrAmt;
		this.asaNo = asaNo;
		this.coaIntrCmpyCd = coaIntrCmpyCd;
		this.srcCtnt = srcCtnt;
		this.apCtrCd = apCtrCd;
		this.localDt = localDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apro_step", getAproStep());
		this.hashColumns.put("err_vvd_lvl_bkg_no", getErrVvdLvlBkgNo());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("dtrb_cnt", getDtrbCnt());
		this.hashColumns.put("finc_rgn_cd", getFincRgnCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("asa_curr_cd", getAsaCurrCd());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("err_vvd_lvl_vvd_cd", getErrVvdLvlVvdCd());
		this.hashColumns.put("s_rev_chg", getSRevChg());
		this.hashColumns.put("err_bkg_cre_dt", getErrBkgCreDt());
		this.hashColumns.put("pgm_no", getPgmNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("err_bkg_no", getErrBkgNo());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("err_vvd_lvl_flg_bkg_no", getErrVvdLvlFlgBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("cre_usr_eml", getCreUsrEml());
		this.hashColumns.put("err_vvd", getErrVvd());
		this.hashColumns.put("tj_ofc_cd", getTjOfcCd());
		this.hashColumns.put("inv_tax_rt", getInvTaxRt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("pay_grp_lu_cd", getPayGrpLuCd());
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());
		this.hashColumns.put("vndr_term_nm", getVndrTermNm());
		this.hashColumns.put("err_vvd_bkg_no", getErrVvdBkgNo());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("offset_flg", getOffsetFlg());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());
		this.hashColumns.put("com_apr_nos", getComAprNos());
		this.hashColumns.put("inv_term_dt", getInvTermDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("err_vvd_lvl_flg_vvd_cd", getErrVvdLvlFlgVvdCd());
		this.hashColumns.put("asa_cnt", getAsaCnt());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("asa_no", getAsaNo());
		this.hashColumns.put("coa_intr_cmpy_cd", getCoaIntrCmpyCd());
		this.hashColumns.put("src_ctnt", getSrcCtnt());
		this.hashColumns.put("ap_ctr_cd", getApCtrCd());
		this.hashColumns.put("local_dt", getLocalDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apro_step", "aproStep");
		this.hashFields.put("err_vvd_lvl_bkg_no", "errVvdLvlBkgNo");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("dtrb_cnt", "dtrbCnt");
		this.hashFields.put("finc_rgn_cd", "fincRgnCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("asa_curr_cd", "asaCurrCd");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("err_vvd_lvl_vvd_cd", "errVvdLvlVvdCd");
		this.hashFields.put("s_rev_chg", "sRevChg");
		this.hashFields.put("err_bkg_cre_dt", "errBkgCreDt");
		this.hashFields.put("pgm_no", "pgmNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("err_bkg_no", "errBkgNo");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("err_vvd_lvl_flg_bkg_no", "errVvdLvlFlgBkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("cre_usr_eml", "creUsrEml");
		this.hashFields.put("err_vvd", "errVvd");
		this.hashFields.put("tj_ofc_cd", "tjOfcCd");
		this.hashFields.put("inv_tax_rt", "invTaxRt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("pay_grp_lu_cd", "payGrpLuCd");
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("vndr_term_nm", "vndrTermNm");
		this.hashFields.put("err_vvd_bkg_no", "errVvdBkgNo");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("offset_flg", "offsetFlg");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("com_apr_nos", "comAprNos");
		this.hashFields.put("inv_term_dt", "invTermDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("err_vvd_lvl_flg_vvd_cd", "errVvdLvlFlgVvdCd");
		this.hashFields.put("asa_cnt", "asaCnt");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("coa_intr_cmpy_cd", "coaIntrCmpyCd");
		this.hashFields.put("src_ctnt", "srcCtnt");
		this.hashFields.put("ap_ctr_cd", "apCtrCd");
		this.hashFields.put("local_dt", "localDt");
		return this.hashFields;
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
	 * @return errVvdLvlBkgNo
	 */
	public String getErrVvdLvlBkgNo() {
		return this.errVvdLvlBkgNo;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
	}
	
	/**
	 * Column Info
	 * @return dtrbCnt
	 */
	public String getDtrbCnt() {
		return this.dtrbCnt;
	}
	
	/**
	 * Column Info
	 * @return fincRgnCd
	 */
	public String getFincRgnCd() {
		return this.fincRgnCd;
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
	 * @return asaCurrCd
	 */
	public String getAsaCurrCd() {
		return this.asaCurrCd;
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
	 * @return errVvdLvlVvdCd
	 */
	public String getErrVvdLvlVvdCd() {
		return this.errVvdLvlVvdCd;
	}
	
	/**
	 * Column Info
	 * @return sRevChg
	 */
	public String getSRevChg() {
		return this.sRevChg;
	}
	
	/**
	 * Column Info
	 * @return errBkgCreDt
	 */
	public String getErrBkgCreDt() {
		return this.errBkgCreDt;
	}
	
	/**
	 * Column Info
	 * @return pgmNo
	 */
	public String getPgmNo() {
		return this.pgmNo;
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
	 * @return errBkgNo
	 */
	public String getErrBkgNo() {
		return this.errBkgNo;
	}
	
	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
	}
	
	/**
	 * Column Info
	 * @return errVvdLvlFlgBkgNo
	 */
	public String getErrVvdLvlFlgBkgNo() {
		return this.errVvdLvlFlgBkgNo;
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
	 * @return invDesc
	 */
	public String getInvDesc() {
		return this.invDesc;
	}
	
	/**
	 * Column Info
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrEml
	 */
	public String getCreUsrEml() {
		return this.creUsrEml;
	}
	
	/**
	 * Column Info
	 * @return errVvd
	 */
	public String getErrVvd() {
		return this.errVvd;
	}
	
	/**
	 * Column Info
	 * @return tjOfcCd
	 */
	public String getTjOfcCd() {
		return this.tjOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invTaxRt
	 */
	public String getInvTaxRt() {
		return this.invTaxRt;
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
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
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
	 * @return payGrpLuCd
	 */
	public String getPayGrpLuCd() {
		return this.payGrpLuCd;
	}
	
	/**
	 * Column Info
	 * @return apOfcCd
	 */
	public String getApOfcCd() {
		return this.apOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vndrTermNm
	 */
	public String getVndrTermNm() {
		return this.vndrTermNm;
	}
	
	/**
	 * Column Info
	 * @return errVvdBkgNo
	 */
	public String getErrVvdBkgNo() {
		return this.errVvdBkgNo;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return offsetFlg
	 */
	public String getOffsetFlg() {
		return this.offsetFlg;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return payMzdLuCd
	 */
	public String getPayMzdLuCd() {
		return this.payMzdLuCd;
	}
	
	/**
	 * Column Info
	 * @return comAprNos
	 */
	public String getComAprNos() {
		return this.comAprNos;
	}
	
	/**
	 * Column Info
	 * @return invTermDt
	 */
	public String getInvTermDt() {
		return this.invTermDt;
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
	 * @return errVvdLvlFlgVvdCd
	 */
	public String getErrVvdLvlFlgVvdCd() {
		return this.errVvdLvlFlgVvdCd;
	}
	
	/**
	 * Column Info
	 * @return asaCnt
	 */
	public String getAsaCnt() {
		return this.asaCnt;
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
	 * @return asaNo
	 */
	public String getAsaNo() {
		return this.asaNo;
	}
	
	/**
	 * Column Info
	 * @return coaIntrCmpyCd
	 */
	public String getCoaIntrCmpyCd() {
		return this.coaIntrCmpyCd;
	}
	
	/**
	 * Column Info
	 * @return srcCtnt
	 */
	public String getSrcCtnt() {
		return this.srcCtnt;
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
	 * @return localDt
	 */
	public String getLocalDt() {
		return this.localDt;
	}
	

	/**
	 * Column Info
	 * @param aproStep
	 */
	public void setAproStep(String aproStep) {
		this.aproStep = aproStep;
	}
	
	/**
	 * Column Info
	 * @param errVvdLvlBkgNo
	 */
	public void setErrVvdLvlBkgNo(String errVvdLvlBkgNo) {
		this.errVvdLvlBkgNo = errVvdLvlBkgNo;
	}
	
	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
	}
	
	/**
	 * Column Info
	 * @param dtrbCnt
	 */
	public void setDtrbCnt(String dtrbCnt) {
		this.dtrbCnt = dtrbCnt;
	}
	
	/**
	 * Column Info
	 * @param fincRgnCd
	 */
	public void setFincRgnCd(String fincRgnCd) {
		this.fincRgnCd = fincRgnCd;
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
	 * @param asaCurrCd
	 */
	public void setAsaCurrCd(String asaCurrCd) {
		this.asaCurrCd = asaCurrCd;
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
	 * @param errVvdLvlVvdCd
	 */
	public void setErrVvdLvlVvdCd(String errVvdLvlVvdCd) {
		this.errVvdLvlVvdCd = errVvdLvlVvdCd;
	}
	
	/**
	 * Column Info
	 * @param sRevChg
	 */
	public void setSRevChg(String sRevChg) {
		this.sRevChg = sRevChg;
	}
	
	/**
	 * Column Info
	 * @param errBkgCreDt
	 */
	public void setErrBkgCreDt(String errBkgCreDt) {
		this.errBkgCreDt = errBkgCreDt;
	}
	
	/**
	 * Column Info
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
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
	 * @param errBkgNo
	 */
	public void setErrBkgNo(String errBkgNo) {
		this.errBkgNo = errBkgNo;
	}
	
	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}
	
	/**
	 * Column Info
	 * @param errVvdLvlFlgBkgNo
	 */
	public void setErrVvdLvlFlgBkgNo(String errVvdLvlFlgBkgNo) {
		this.errVvdLvlFlgBkgNo = errVvdLvlFlgBkgNo;
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
	 * @param invDesc
	 */
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
	}
	
	/**
	 * Column Info
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrEml
	 */
	public void setCreUsrEml(String creUsrEml) {
		this.creUsrEml = creUsrEml;
	}
	
	/**
	 * Column Info
	 * @param errVvd
	 */
	public void setErrVvd(String errVvd) {
		this.errVvd = errVvd;
	}
	
	/**
	 * Column Info
	 * @param tjOfcCd
	 */
	public void setTjOfcCd(String tjOfcCd) {
		this.tjOfcCd = tjOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invTaxRt
	 */
	public void setInvTaxRt(String invTaxRt) {
		this.invTaxRt = invTaxRt;
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
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
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
	 * @param payGrpLuCd
	 */
	public void setPayGrpLuCd(String payGrpLuCd) {
		this.payGrpLuCd = payGrpLuCd;
	}
	
	/**
	 * Column Info
	 * @param apOfcCd
	 */
	public void setApOfcCd(String apOfcCd) {
		this.apOfcCd = apOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vndrTermNm
	 */
	public void setVndrTermNm(String vndrTermNm) {
		this.vndrTermNm = vndrTermNm;
	}
	
	/**
	 * Column Info
	 * @param errVvdBkgNo
	 */
	public void setErrVvdBkgNo(String errVvdBkgNo) {
		this.errVvdBkgNo = errVvdBkgNo;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param offsetFlg
	 */
	public void setOffsetFlg(String offsetFlg) {
		this.offsetFlg = offsetFlg;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param payMzdLuCd
	 */
	public void setPayMzdLuCd(String payMzdLuCd) {
		this.payMzdLuCd = payMzdLuCd;
	}
	
	/**
	 * Column Info
	 * @param comAprNos
	 */
	public void setComAprNos(String comAprNos) {
		this.comAprNos = comAprNos;
	}
	
	/**
	 * Column Info
	 * @param invTermDt
	 */
	public void setInvTermDt(String invTermDt) {
		this.invTermDt = invTermDt;
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
	 * @param errVvdLvlFlgVvdCd
	 */
	public void setErrVvdLvlFlgVvdCd(String errVvdLvlFlgVvdCd) {
		this.errVvdLvlFlgVvdCd = errVvdLvlFlgVvdCd;
	}
	
	/**
	 * Column Info
	 * @param asaCnt
	 */
	public void setAsaCnt(String asaCnt) {
		this.asaCnt = asaCnt;
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
	 * @param asaNo
	 */
	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
	}
	
	/**
	 * Column Info
	 * @param coaIntrCmpyCd
	 */
	public void setCoaIntrCmpyCd(String coaIntrCmpyCd) {
		this.coaIntrCmpyCd = coaIntrCmpyCd;
	}
	
	/**
	 * Column Info
	 * @param srcCtnt
	 */
	public void setSrcCtnt(String srcCtnt) {
		this.srcCtnt = srcCtnt;
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
	 * @param localDt
	 */
	public void setLocalDt(String localDt) {
		this.localDt = localDt;
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
		setAproStep(JSPUtil.getParameter(request, prefix + "apro_step", ""));
		setErrVvdLvlBkgNo(JSPUtil.getParameter(request, prefix + "err_vvd_lvl_bkg_no", ""));
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setDtrbCnt(JSPUtil.getParameter(request, prefix + "dtrb_cnt", ""));
		setFincRgnCd(JSPUtil.getParameter(request, prefix + "finc_rgn_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setAsaCurrCd(JSPUtil.getParameter(request, prefix + "asa_curr_cd", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, prefix + "csr_curr_cd", ""));
		setErrVvdLvlVvdCd(JSPUtil.getParameter(request, prefix + "err_vvd_lvl_vvd_cd", ""));
		setSRevChg(JSPUtil.getParameter(request, prefix + "s_rev_chg", ""));
		setErrBkgCreDt(JSPUtil.getParameter(request, prefix + "err_bkg_cre_dt", ""));
		setPgmNo(JSPUtil.getParameter(request, prefix + "pgm_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setErrBkgNo(JSPUtil.getParameter(request, prefix + "err_bkg_no", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setErrVvdLvlFlgBkgNo(JSPUtil.getParameter(request, prefix + "err_vvd_lvl_flg_bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvDesc(JSPUtil.getParameter(request, prefix + "inv_desc", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setCreUsrEml(JSPUtil.getParameter(request, prefix + "cre_usr_eml", ""));
		setErrVvd(JSPUtil.getParameter(request, prefix + "err_vvd", ""));
		setTjOfcCd(JSPUtil.getParameter(request, prefix + "tj_ofc_cd", ""));
		setInvTaxRt(JSPUtil.getParameter(request, prefix + "inv_tax_rt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setPayGrpLuCd(JSPUtil.getParameter(request, prefix + "pay_grp_lu_cd", ""));
		setApOfcCd(JSPUtil.getParameter(request, prefix + "ap_ofc_cd", ""));
		setVndrTermNm(JSPUtil.getParameter(request, prefix + "vndr_term_nm", ""));
		setErrVvdBkgNo(JSPUtil.getParameter(request, prefix + "err_vvd_bkg_no", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setOffsetFlg(JSPUtil.getParameter(request, prefix + "offset_flg", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request, prefix + "pay_mzd_lu_cd", ""));
		setComAprNos(JSPUtil.getParameter(request, prefix + "com_apr_nos", ""));
		setInvTermDt(JSPUtil.getParameter(request, prefix + "inv_term_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setErrVvdLvlFlgVvdCd(JSPUtil.getParameter(request, prefix + "err_vvd_lvl_flg_vvd_cd", ""));
		setAsaCnt(JSPUtil.getParameter(request, prefix + "asa_cnt", ""));
		setCsrAmt(JSPUtil.getParameter(request, prefix + "csr_amt", ""));
		setAsaNo(JSPUtil.getParameter(request, prefix + "asa_no", ""));
		setCoaIntrCmpyCd(JSPUtil.getParameter(request, prefix + "coa_intr_cmpy_cd", ""));
		setSrcCtnt(JSPUtil.getParameter(request, prefix + "src_ctnt", ""));
		setApCtrCd(JSPUtil.getParameter(request, prefix + "ap_ctr_cd", ""));
		setLocalDt(JSPUtil.getParameter(request, prefix + "local_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgentActualINFtoAPCheckVO[]
	 */
	public AgentActualINFtoAPCheckVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgentActualINFtoAPCheckVO[]
	 */
	public AgentActualINFtoAPCheckVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgentActualINFtoAPCheckVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aproStep = (JSPUtil.getParameter(request, prefix	+ "apro_step", length));
			String[] errVvdLvlBkgNo = (JSPUtil.getParameter(request, prefix	+ "err_vvd_lvl_bkg_no", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] dtrbCnt = (JSPUtil.getParameter(request, prefix	+ "dtrb_cnt", length));
			String[] fincRgnCd = (JSPUtil.getParameter(request, prefix	+ "finc_rgn_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] asaCurrCd = (JSPUtil.getParameter(request, prefix	+ "asa_curr_cd", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] errVvdLvlVvdCd = (JSPUtil.getParameter(request, prefix	+ "err_vvd_lvl_vvd_cd", length));
			String[] sRevChg = (JSPUtil.getParameter(request, prefix	+ "s_rev_chg", length));
			String[] errBkgCreDt = (JSPUtil.getParameter(request, prefix	+ "err_bkg_cre_dt", length));
			String[] pgmNo = (JSPUtil.getParameter(request, prefix	+ "pgm_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] errBkgNo = (JSPUtil.getParameter(request, prefix	+ "err_bkg_no", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] errVvdLvlFlgBkgNo = (JSPUtil.getParameter(request, prefix	+ "err_vvd_lvl_flg_bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] creUsrEml = (JSPUtil.getParameter(request, prefix	+ "cre_usr_eml", length));
			String[] errVvd = (JSPUtil.getParameter(request, prefix	+ "err_vvd", length));
			String[] tjOfcCd = (JSPUtil.getParameter(request, prefix	+ "tj_ofc_cd", length));
			String[] invTaxRt = (JSPUtil.getParameter(request, prefix	+ "inv_tax_rt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] payGrpLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_grp_lu_cd", length));
			String[] apOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ofc_cd", length));
			String[] vndrTermNm = (JSPUtil.getParameter(request, prefix	+ "vndr_term_nm", length));
			String[] errVvdBkgNo = (JSPUtil.getParameter(request, prefix	+ "err_vvd_bkg_no", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] offsetFlg = (JSPUtil.getParameter(request, prefix	+ "offset_flg", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] payMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_mzd_lu_cd", length));
			String[] comAprNos = (JSPUtil.getParameter(request, prefix	+ "com_apr_nos", length));
			String[] invTermDt = (JSPUtil.getParameter(request, prefix	+ "inv_term_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] errVvdLvlFlgVvdCd = (JSPUtil.getParameter(request, prefix	+ "err_vvd_lvl_flg_vvd_cd", length));
			String[] asaCnt = (JSPUtil.getParameter(request, prefix	+ "asa_cnt", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] asaNo = (JSPUtil.getParameter(request, prefix	+ "asa_no", length));
			String[] coaIntrCmpyCd = (JSPUtil.getParameter(request, prefix	+ "coa_intr_cmpy_cd", length));
			String[] srcCtnt = (JSPUtil.getParameter(request, prefix	+ "src_ctnt", length));
			String[] apCtrCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctr_cd", length));
			String[] localDt = (JSPUtil.getParameter(request, prefix	+ "local_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgentActualINFtoAPCheckVO();
				if (aproStep[i] != null)
					model.setAproStep(aproStep[i]);
				if (errVvdLvlBkgNo[i] != null)
					model.setErrVvdLvlBkgNo(errVvdLvlBkgNo[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (dtrbCnt[i] != null)
					model.setDtrbCnt(dtrbCnt[i]);
				if (fincRgnCd[i] != null)
					model.setFincRgnCd(fincRgnCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (asaCurrCd[i] != null)
					model.setAsaCurrCd(asaCurrCd[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (errVvdLvlVvdCd[i] != null)
					model.setErrVvdLvlVvdCd(errVvdLvlVvdCd[i]);
				if (sRevChg[i] != null)
					model.setSRevChg(sRevChg[i]);
				if (errBkgCreDt[i] != null)
					model.setErrBkgCreDt(errBkgCreDt[i]);
				if (pgmNo[i] != null)
					model.setPgmNo(pgmNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (errBkgNo[i] != null)
					model.setErrBkgNo(errBkgNo[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (errVvdLvlFlgBkgNo[i] != null)
					model.setErrVvdLvlFlgBkgNo(errVvdLvlFlgBkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (creUsrEml[i] != null)
					model.setCreUsrEml(creUsrEml[i]);
				if (errVvd[i] != null)
					model.setErrVvd(errVvd[i]);
				if (tjOfcCd[i] != null)
					model.setTjOfcCd(tjOfcCd[i]);
				if (invTaxRt[i] != null)
					model.setInvTaxRt(invTaxRt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (payGrpLuCd[i] != null)
					model.setPayGrpLuCd(payGrpLuCd[i]);
				if (apOfcCd[i] != null)
					model.setApOfcCd(apOfcCd[i]);
				if (vndrTermNm[i] != null)
					model.setVndrTermNm(vndrTermNm[i]);
				if (errVvdBkgNo[i] != null)
					model.setErrVvdBkgNo(errVvdBkgNo[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (offsetFlg[i] != null)
					model.setOffsetFlg(offsetFlg[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (payMzdLuCd[i] != null)
					model.setPayMzdLuCd(payMzdLuCd[i]);
				if (comAprNos[i] != null)
					model.setComAprNos(comAprNos[i]);
				if (invTermDt[i] != null)
					model.setInvTermDt(invTermDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (errVvdLvlFlgVvdCd[i] != null)
					model.setErrVvdLvlFlgVvdCd(errVvdLvlFlgVvdCd[i]);
				if (asaCnt[i] != null)
					model.setAsaCnt(asaCnt[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (asaNo[i] != null)
					model.setAsaNo(asaNo[i]);
				if (coaIntrCmpyCd[i] != null)
					model.setCoaIntrCmpyCd(coaIntrCmpyCd[i]);
				if (srcCtnt[i] != null)
					model.setSrcCtnt(srcCtnt[i]);
				if (apCtrCd[i] != null)
					model.setApCtrCd(apCtrCd[i]);
				if (localDt[i] != null)
					model.setLocalDt(localDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgentActualINFtoAPCheckVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgentActualINFtoAPCheckVO[]
	 */
	public AgentActualINFtoAPCheckVO[] getAgentActualINFtoAPCheckVOs(){
		AgentActualINFtoAPCheckVO[] vos = (AgentActualINFtoAPCheckVO[])models.toArray(new AgentActualINFtoAPCheckVO[models.size()]);
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
		this.aproStep = this.aproStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errVvdLvlBkgNo = this.errVvdLvlBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCnt = this.dtrbCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincRgnCd = this.fincRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaCurrCd = this.asaCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errVvdLvlVvdCd = this.errVvdLvlVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRevChg = this.sRevChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errBkgCreDt = this.errBkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNo = this.pgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errBkgNo = this.errBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errVvdLvlFlgBkgNo = this.errVvdLvlFlgBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrEml = this.creUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errVvd = this.errVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tjOfcCd = this.tjOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxRt = this.invTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payGrpLuCd = this.payGrpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfcCd = this.apOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrTermNm = this.vndrTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errVvdBkgNo = this.errVvdBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offsetFlg = this.offsetFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd = this.payMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comAprNos = this.comAprNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTermDt = this.invTermDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errVvdLvlFlgVvdCd = this.errVvdLvlFlgVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaCnt = this.asaCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo = this.asaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaIntrCmpyCd = this.coaIntrCmpyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcCtnt = this.srcCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCtrCd = this.apCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localDt = this.localDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
