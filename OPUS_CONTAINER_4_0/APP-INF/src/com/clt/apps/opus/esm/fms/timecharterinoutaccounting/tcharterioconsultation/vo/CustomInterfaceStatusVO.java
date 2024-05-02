/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomInterfaceStatusVO.java
*@FileTitle : CustomInterfaceStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.08.11 윤세영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomInterfaceStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomInterfaceStatusVO> models = new ArrayList<CustomInterfaceStatusVO>();
	
	/* Column Info */
	private String orgSlpFuncCd = null;
	/* Column Info */
	private String orgSlpSeqNo = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String preSlpOfcCd = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String csrDesc = null;
	/* Column Info */
	private String keyNumber = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cxlDesc = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String orgSlpSerNo = null;
	/* Column Info */
	private String orgSlpIssDt = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String preSlpFuncCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String orgSlpTpCd = null;
	/* Column Info */
	private String preSlpIssDt = null;
	/* Column Info */
	private String slpSeqNo = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String preSlpTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String preSlpSerNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String orgSlpOfcCd = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String preSlpSeqNo = null;
	/* Column Info */
	private String slpSerNo = null;
	/* Column Info */
	private String slpLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomInterfaceStatusVO() {}

	public CustomInterfaceStatusVO(String ibflag, String pagerows, String orgSlpTpCd, String orgSlpFuncCd, String orgSlpOfcCd, String orgSlpIssDt, String orgSlpSerNo, String orgSlpSeqNo, String acctCd, String effDt, String ctrCd, String slpLocCd, String csrCurrCd, String csrAmt, String csrDesc, String vndrCntCd, String vndrSeq, String vvdCd, String keyNumber, String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo, String slpSeqNo, String cxlDesc, String creUsrId, String updUsrId, String preSlpTpCd, String preSlpFuncCd, String preSlpOfcCd, String preSlpIssDt, String preSlpSerNo, String preSlpSeqNo) {
		this.orgSlpFuncCd = orgSlpFuncCd;
		this.orgSlpSeqNo = orgSlpSeqNo;
		this.vndrCntCd = vndrCntCd;
		this.slpFuncCd = slpFuncCd;
		this.preSlpOfcCd = preSlpOfcCd;
		this.csrCurrCd = csrCurrCd;
		this.csrDesc = csrDesc;
		this.keyNumber = keyNumber;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.ctrCd = ctrCd;
		this.vvdCd = vvdCd;
		this.cxlDesc = cxlDesc;
		this.acctCd = acctCd;
		this.orgSlpSerNo = orgSlpSerNo;
		this.orgSlpIssDt = orgSlpIssDt;
		this.slpTpCd = slpTpCd;
		this.preSlpFuncCd = preSlpFuncCd;
		this.updUsrId = updUsrId;
		this.orgSlpTpCd = orgSlpTpCd;
		this.preSlpIssDt = preSlpIssDt;
		this.slpSeqNo = slpSeqNo;
		this.slpOfcCd = slpOfcCd;
		this.slpIssDt = slpIssDt;
		this.preSlpTpCd = preSlpTpCd;
		this.creUsrId = creUsrId;
		this.preSlpSerNo = preSlpSerNo;
		this.vndrSeq = vndrSeq;
		this.orgSlpOfcCd = orgSlpOfcCd;
		this.csrAmt = csrAmt;
		this.preSlpSeqNo = preSlpSeqNo;
		this.slpSerNo = slpSerNo;
		this.slpLocCd = slpLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_slp_func_cd", getOrgSlpFuncCd());
		this.hashColumns.put("org_slp_seq_no", getOrgSlpSeqNo());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("pre_slp_ofc_cd", getPreSlpOfcCd());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("key_number", getKeyNumber());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cxl_desc", getCxlDesc());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("org_slp_ser_no", getOrgSlpSerNo());
		this.hashColumns.put("org_slp_iss_dt", getOrgSlpIssDt());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("pre_slp_func_cd", getPreSlpFuncCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("org_slp_tp_cd", getOrgSlpTpCd());
		this.hashColumns.put("pre_slp_iss_dt", getPreSlpIssDt());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("pre_slp_tp_cd", getPreSlpTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pre_slp_ser_no", getPreSlpSerNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("org_slp_ofc_cd", getOrgSlpOfcCd());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("pre_slp_seq_no", getPreSlpSeqNo());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		this.hashColumns.put("slp_loc_cd", getSlpLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_slp_func_cd", "orgSlpFuncCd");
		this.hashFields.put("org_slp_seq_no", "orgSlpSeqNo");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("pre_slp_ofc_cd", "preSlpOfcCd");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("key_number", "keyNumber");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cxl_desc", "cxlDesc");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("org_slp_ser_no", "orgSlpSerNo");
		this.hashFields.put("org_slp_iss_dt", "orgSlpIssDt");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("pre_slp_func_cd", "preSlpFuncCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("org_slp_tp_cd", "orgSlpTpCd");
		this.hashFields.put("pre_slp_iss_dt", "preSlpIssDt");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("pre_slp_tp_cd", "preSlpTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pre_slp_ser_no", "preSlpSerNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("org_slp_ofc_cd", "orgSlpOfcCd");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("pre_slp_seq_no", "preSlpSeqNo");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		this.hashFields.put("slp_loc_cd", "slpLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return orgSlpFuncCd
	 */
	public String getOrgSlpFuncCd() {
		return this.orgSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return orgSlpSeqNo
	 */
	public String getOrgSlpSeqNo() {
		return this.orgSlpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
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
	 * @return preSlpOfcCd
	 */
	public String getPreSlpOfcCd() {
		return this.preSlpOfcCd;
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
	 * @return csrDesc
	 */
	public String getCsrDesc() {
		return this.csrDesc;
	}
	
	/**
	 * Column Info
	 * @return keyNumber
	 */
	public String getKeyNumber() {
		return this.keyNumber;
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
	 * @return ctrCd
	 */
	public String getCtrCd() {
		return this.ctrCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return orgSlpSerNo
	 */
	public String getOrgSlpSerNo() {
		return this.orgSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @return orgSlpIssDt
	 */
	public String getOrgSlpIssDt() {
		return this.orgSlpIssDt;
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
	 * @return preSlpFuncCd
	 */
	public String getPreSlpFuncCd() {
		return this.preSlpFuncCd;
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
	 * @return orgSlpTpCd
	 */
	public String getOrgSlpTpCd() {
		return this.orgSlpTpCd;
	}
	
	/**
	 * Column Info
	 * @return preSlpIssDt
	 */
	public String getPreSlpIssDt() {
		return this.preSlpIssDt;
	}
	
	/**
	 * Column Info
	 * @return slpSeqNo
	 */
	public String getSlpSeqNo() {
		return this.slpSeqNo;
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
	 * @return preSlpTpCd
	 */
	public String getPreSlpTpCd() {
		return this.preSlpTpCd;
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
	 * @return preSlpSerNo
	 */
	public String getPreSlpSerNo() {
		return this.preSlpSerNo;
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
	 * @return orgSlpOfcCd
	 */
	public String getOrgSlpOfcCd() {
		return this.orgSlpOfcCd;
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
	 * @return preSlpSeqNo
	 */
	public String getPreSlpSeqNo() {
		return this.preSlpSeqNo;
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
	 * @return slpLocCd
	 */
	public String getSlpLocCd() {
		return this.slpLocCd;
	}
	

	/**
	 * Column Info
	 * @param orgSlpFuncCd
	 */
	public void setOrgSlpFuncCd(String orgSlpFuncCd) {
		this.orgSlpFuncCd = orgSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param orgSlpSeqNo
	 */
	public void setOrgSlpSeqNo(String orgSlpSeqNo) {
		this.orgSlpSeqNo = orgSlpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
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
	 * @param preSlpOfcCd
	 */
	public void setPreSlpOfcCd(String preSlpOfcCd) {
		this.preSlpOfcCd = preSlpOfcCd;
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
	 * @param csrDesc
	 */
	public void setCsrDesc(String csrDesc) {
		this.csrDesc = csrDesc;
	}
	
	/**
	 * Column Info
	 * @param keyNumber
	 */
	public void setKeyNumber(String keyNumber) {
		this.keyNumber = keyNumber;
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
	 * @param ctrCd
	 */
	public void setCtrCd(String ctrCd) {
		this.ctrCd = ctrCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param orgSlpSerNo
	 */
	public void setOrgSlpSerNo(String orgSlpSerNo) {
		this.orgSlpSerNo = orgSlpSerNo;
	}
	
	/**
	 * Column Info
	 * @param orgSlpIssDt
	 */
	public void setOrgSlpIssDt(String orgSlpIssDt) {
		this.orgSlpIssDt = orgSlpIssDt;
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
	 * @param preSlpFuncCd
	 */
	public void setPreSlpFuncCd(String preSlpFuncCd) {
		this.preSlpFuncCd = preSlpFuncCd;
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
	 * @param orgSlpTpCd
	 */
	public void setOrgSlpTpCd(String orgSlpTpCd) {
		this.orgSlpTpCd = orgSlpTpCd;
	}
	
	/**
	 * Column Info
	 * @param preSlpIssDt
	 */
	public void setPreSlpIssDt(String preSlpIssDt) {
		this.preSlpIssDt = preSlpIssDt;
	}
	
	/**
	 * Column Info
	 * @param slpSeqNo
	 */
	public void setSlpSeqNo(String slpSeqNo) {
		this.slpSeqNo = slpSeqNo;
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
	 * @param preSlpTpCd
	 */
	public void setPreSlpTpCd(String preSlpTpCd) {
		this.preSlpTpCd = preSlpTpCd;
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
	 * @param preSlpSerNo
	 */
	public void setPreSlpSerNo(String preSlpSerNo) {
		this.preSlpSerNo = preSlpSerNo;
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
	 * @param orgSlpOfcCd
	 */
	public void setOrgSlpOfcCd(String orgSlpOfcCd) {
		this.orgSlpOfcCd = orgSlpOfcCd;
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
	 * @param preSlpSeqNo
	 */
	public void setPreSlpSeqNo(String preSlpSeqNo) {
		this.preSlpSeqNo = preSlpSeqNo;
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
	 * @param slpLocCd
	 */
	public void setSlpLocCd(String slpLocCd) {
		this.slpLocCd = slpLocCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOrgSlpFuncCd(JSPUtil.getParameter(request, "org_slp_func_cd", ""));
		setOrgSlpSeqNo(JSPUtil.getParameter(request, "org_slp_seq_no", ""));
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setSlpFuncCd(JSPUtil.getParameter(request, "slp_func_cd", ""));
		setPreSlpOfcCd(JSPUtil.getParameter(request, "pre_slp_ofc_cd", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, "csr_curr_cd", ""));
		setCsrDesc(JSPUtil.getParameter(request, "csr_desc", ""));
		setKeyNumber(JSPUtil.getParameter(request, "key_number", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrCd(JSPUtil.getParameter(request, "ctr_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setCxlDesc(JSPUtil.getParameter(request, "cxl_desc", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setOrgSlpSerNo(JSPUtil.getParameter(request, "org_slp_ser_no", ""));
		setOrgSlpIssDt(JSPUtil.getParameter(request, "org_slp_iss_dt", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setPreSlpFuncCd(JSPUtil.getParameter(request, "pre_slp_func_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setOrgSlpTpCd(JSPUtil.getParameter(request, "org_slp_tp_cd", ""));
		setPreSlpIssDt(JSPUtil.getParameter(request, "pre_slp_iss_dt", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, "slp_seq_no", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, "slp_ofc_cd", ""));
		setSlpIssDt(JSPUtil.getParameter(request, "slp_iss_dt", ""));
		setPreSlpTpCd(JSPUtil.getParameter(request, "pre_slp_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPreSlpSerNo(JSPUtil.getParameter(request, "pre_slp_ser_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setOrgSlpOfcCd(JSPUtil.getParameter(request, "org_slp_ofc_cd", ""));
		setCsrAmt(JSPUtil.getParameter(request, "csr_amt", ""));
		setPreSlpSeqNo(JSPUtil.getParameter(request, "pre_slp_seq_no", ""));
		setSlpSerNo(JSPUtil.getParameter(request, "slp_ser_no", ""));
		setSlpLocCd(JSPUtil.getParameter(request, "slp_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomInterfaceStatusVO[]
	 */
	public CustomInterfaceStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomInterfaceStatusVO[]
	 */
	public CustomInterfaceStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomInterfaceStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orgSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_func_cd", length));
			String[] orgSlpSeqNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_seq_no", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd", length));
			String[] preSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "pre_slp_ofc_cd", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] keyNumber = (JSPUtil.getParameter(request, prefix	+ "key_number", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cxlDesc = (JSPUtil.getParameter(request, prefix	+ "cxl_desc", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] orgSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_ser_no", length));
			String[] orgSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "org_slp_iss_dt", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] preSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "pre_slp_func_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] orgSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_tp_cd", length));
			String[] preSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "pre_slp_iss_dt", length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] preSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "pre_slp_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] preSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "pre_slp_ser_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] orgSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_ofc_cd", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] preSlpSeqNo = (JSPUtil.getParameter(request, prefix	+ "pre_slp_seq_no", length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomInterfaceStatusVO();
				if (orgSlpFuncCd[i] != null)
					model.setOrgSlpFuncCd(orgSlpFuncCd[i]);
				if (orgSlpSeqNo[i] != null)
					model.setOrgSlpSeqNo(orgSlpSeqNo[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (preSlpOfcCd[i] != null)
					model.setPreSlpOfcCd(preSlpOfcCd[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (keyNumber[i] != null)
					model.setKeyNumber(keyNumber[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cxlDesc[i] != null)
					model.setCxlDesc(cxlDesc[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (orgSlpSerNo[i] != null)
					model.setOrgSlpSerNo(orgSlpSerNo[i]);
				if (orgSlpIssDt[i] != null)
					model.setOrgSlpIssDt(orgSlpIssDt[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (preSlpFuncCd[i] != null)
					model.setPreSlpFuncCd(preSlpFuncCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (orgSlpTpCd[i] != null)
					model.setOrgSlpTpCd(orgSlpTpCd[i]);
				if (preSlpIssDt[i] != null)
					model.setPreSlpIssDt(preSlpIssDt[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (preSlpTpCd[i] != null)
					model.setPreSlpTpCd(preSlpTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (preSlpSerNo[i] != null)
					model.setPreSlpSerNo(preSlpSerNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (orgSlpOfcCd[i] != null)
					model.setOrgSlpOfcCd(orgSlpOfcCd[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (preSlpSeqNo[i] != null)
					model.setPreSlpSeqNo(preSlpSeqNo[i]);
				if (slpSerNo[i] != null)
					model.setSlpSerNo(slpSerNo[i]);
				if (slpLocCd[i] != null)
					model.setSlpLocCd(slpLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomInterfaceStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomInterfaceStatusVO[]
	 */
	public CustomInterfaceStatusVO[] getCustomInterfaceStatusVOs(){
		CustomInterfaceStatusVO[] vos = (CustomInterfaceStatusVO[])models.toArray(new CustomInterfaceStatusVO[models.size()]);
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
		this.orgSlpFuncCd = this.orgSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpSeqNo = this.orgSlpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSlpOfcCd = this.preSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyNumber = this.keyNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlDesc = this.cxlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpSerNo = this.orgSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpIssDt = this.orgSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSlpFuncCd = this.preSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpTpCd = this.orgSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSlpIssDt = this.preSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSlpTpCd = this.preSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSlpSerNo = this.preSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpOfcCd = this.orgSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preSlpSeqNo = this.preSlpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
