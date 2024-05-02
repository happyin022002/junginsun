/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchProcessListVO.java
*@FileTitle : SearchProcessListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchProcessListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchProcessListVO> models = new ArrayList<SearchProcessListVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String trdPartyCode = null;
	/* Column Info */
	private String invIfDt = null;
	/* Column Info */
	private String tmlCrrCd = null;
	/* Column Info */
	private String n3ptyInvNo = null;
	/* Column Info */
	private String sCdKind = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cfmAmt = null;
	/* Column Info */
	private String cltActYn = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String tmlInvRjctStsCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String sCdValue = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String invAmt1 = null;
	/* Column Info */
	private String trdPartyName = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String invIfOfcCd = null;
	/* Column Info */
	private String sEdate = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String glEffDt = null;
	/* Column Info */
	private String arCurrCd = null;
	/* Column Info */
	private String calcRmk = null;
	/* Column Info */
	private String sSdate = null;
	/* Column Info */
	private String sIfOfcCd = null;
	/* Column Info */
	private String invErpIfStsCd = null;
	/* Column Info */
	private String sOfcCdForRhq = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String apArOffstNo = null;
	/* Column Info */
	private String otsStsNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String displayType = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String ifCurrCd = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String sIfRhqCd = null;
	/* Column Info */
	private String cxlCsrNo = null;
	/* Column Info */
	private String revAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchProcessListVO() {}

	public SearchProcessListVO(String ibflag, String pagerows, String costOfcCd, String csrNo, String tmlInvRjctStsCd, String invNo, String lgsCostCd, String currCd, String invAmt, String invAmt1, String tmlCrrCd, String calcRmk, String otsStsNm, String n3ptyNo, String n3ptyInvNo, String trdPartyCode, String trdPartyName, String ifCurrCd, String ifAmt, String cfmAmt, String invIfDt, String creUsrId, String invIfOfcCd, String cltActYn, String cxlCsrNo, String glEffDt, String invErpIfStsCd, String arCurrCd, String chgAmt, String apArOffstNo, String displayType, String sSdate, String sEdate, String sOfcCdForRhq, String sIfRhqCd, String sIfOfcCd, String sCdKind, String sCdValue, String revAmt) {
		this.currCd = currCd;
		this.trdPartyCode = trdPartyCode;
		this.invIfDt = invIfDt;
		this.tmlCrrCd = tmlCrrCd;
		this.n3ptyInvNo = n3ptyInvNo;
		this.sCdKind = sCdKind;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cfmAmt = cfmAmt;
		this.cltActYn = cltActYn;
		this.n3ptyNo = n3ptyNo;
		this.tmlInvRjctStsCd = tmlInvRjctStsCd;
		this.chgAmt = chgAmt;
		this.sCdValue = sCdValue;
		this.invAmt = invAmt;
		this.invAmt1 = invAmt1;
		this.trdPartyName = trdPartyName;
		this.csrNo = csrNo;
		this.invIfOfcCd = invIfOfcCd;
		this.sEdate = sEdate;
		this.costOfcCd = costOfcCd;
		this.glEffDt = glEffDt;
		this.arCurrCd = arCurrCd;
		this.calcRmk = calcRmk;
		this.sSdate = sSdate;
		this.sIfOfcCd = sIfOfcCd;
		this.invErpIfStsCd = invErpIfStsCd;
		this.sOfcCdForRhq = sOfcCdForRhq;
		this.invNo = invNo;
		this.apArOffstNo = apArOffstNo;
		this.otsStsNm = otsStsNm;
		this.creUsrId = creUsrId;
		this.displayType = displayType;
		this.lgsCostCd = lgsCostCd;
		this.ifCurrCd = ifCurrCd;
		this.ifAmt = ifAmt;
		this.sIfRhqCd = sIfRhqCd;
		this.cxlCsrNo = cxlCsrNo;
		this.revAmt = revAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("trd_party_code", getTrdPartyCode());
		this.hashColumns.put("inv_if_dt", getInvIfDt());
		this.hashColumns.put("tml_crr_cd", getTmlCrrCd());
		this.hashColumns.put("n3pty_inv_no", getN3ptyInvNo());
		this.hashColumns.put("s_cd_kind", getSCdKind());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cfm_amt", getCfmAmt());
		this.hashColumns.put("clt_act_yn", getCltActYn());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("tml_inv_rjct_sts_cd", getTmlInvRjctStsCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("s_cd_value", getSCdValue());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("inv_amt1", getInvAmt1());
		this.hashColumns.put("trd_party_name", getTrdPartyName());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("inv_if_ofc_cd", getInvIfOfcCd());
		this.hashColumns.put("s_edate", getSEdate());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("gl_eff_dt", getGlEffDt());
		this.hashColumns.put("ar_curr_cd", getArCurrCd());
		this.hashColumns.put("calc_rmk", getCalcRmk());
		this.hashColumns.put("s_sdate", getSSdate());
		this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
		this.hashColumns.put("inv_erp_if_sts_cd", getInvErpIfStsCd());
		this.hashColumns.put("s_ofc_cd_for_rhq", getSOfcCdForRhq());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ap_ar_offst_no", getApArOffstNo());
		this.hashColumns.put("ots_sts_nm", getOtsStsNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("display_type", getDisplayType());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("if_curr_cd", getIfCurrCd());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("s_if_rhq_cd", getSIfRhqCd());
		this.hashColumns.put("cxl_csr_no", getCxlCsrNo());
		this.hashColumns.put("rev_amt", getRevAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("trd_party_code", "trdPartyCode");
		this.hashFields.put("inv_if_dt", "invIfDt");
		this.hashFields.put("tml_crr_cd", "tmlCrrCd");
		this.hashFields.put("n3pty_inv_no", "n3ptyInvNo");
		this.hashFields.put("s_cd_kind", "sCdKind");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cfm_amt", "cfmAmt");
		this.hashFields.put("clt_act_yn", "cltActYn");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("tml_inv_rjct_sts_cd", "tmlInvRjctStsCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("s_cd_value", "sCdValue");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("inv_amt1", "invAmt1");
		this.hashFields.put("trd_party_name", "trdPartyName");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("inv_if_ofc_cd", "invIfOfcCd");
		this.hashFields.put("s_edate", "sEdate");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("gl_eff_dt", "glEffDt");
		this.hashFields.put("ar_curr_cd", "arCurrCd");
		this.hashFields.put("calc_rmk", "calcRmk");
		this.hashFields.put("s_sdate", "sSdate");
		this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
		this.hashFields.put("inv_erp_if_sts_cd", "invErpIfStsCd");
		this.hashFields.put("s_ofc_cd_for_rhq", "sOfcCdForRhq");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ap_ar_offst_no", "apArOffstNo");
		this.hashFields.put("ots_sts_nm", "otsStsNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("display_type", "displayType");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("if_curr_cd", "ifCurrCd");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("s_if_rhq_cd", "sIfRhqCd");
		this.hashFields.put("cxl_csr_no", "cxlCsrNo");
		this.hashFields.put("rev_amt", "revAmt");
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
	 * @return trdPartyCode
	 */
	public String getTrdPartyCode() {
		return this.trdPartyCode;
	}
	
	/**
	 * Column Info
	 * @return invIfDt
	 */
	public String getInvIfDt() {
		return this.invIfDt;
	}
	
	/**
	 * Column Info
	 * @return tmlCrrCd
	 */
	public String getTmlCrrCd() {
		return this.tmlCrrCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvNo
	 */
	public String getN3ptyInvNo() {
		return this.n3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @return sCdKind
	 */
	public String getSCdKind() {
		return this.sCdKind;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return cfmAmt
	 */
	public String getCfmAmt() {
		return this.cfmAmt;
	}
	
	/**
	 * Column Info
	 * @return cltActYn
	 */
	public String getCltActYn() {
		return this.cltActYn;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return tmlInvRjctStsCd
	 */
	public String getTmlInvRjctStsCd() {
		return this.tmlInvRjctStsCd;
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
	 * @return sCdValue
	 */
	public String getSCdValue() {
		return this.sCdValue;
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
	 * @return invAmt1
	 */
	public String getInvAmt1() {
		return this.invAmt1;
	}
	
	/**
	 * Column Info
	 * @return trdPartyName
	 */
	public String getTrdPartyName() {
		return this.trdPartyName;
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
	 * @return invIfOfcCd
	 */
	public String getInvIfOfcCd() {
		return this.invIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sEdate
	 */
	public String getSEdate() {
		return this.sEdate;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return glEffDt
	 */
	public String getGlEffDt() {
		return this.glEffDt;
	}
	
	/**
	 * Column Info
	 * @return arCurrCd
	 */
	public String getArCurrCd() {
		return this.arCurrCd;
	}
	
	/**
	 * Column Info
	 * @return calcRmk
	 */
	public String getCalcRmk() {
		return this.calcRmk;
	}
	
	/**
	 * Column Info
	 * @return sSdate
	 */
	public String getSSdate() {
		return this.sSdate;
	}
	
	/**
	 * Column Info
	 * @return sIfOfcCd
	 */
	public String getSIfOfcCd() {
		return this.sIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invErpIfStsCd
	 */
	public String getInvErpIfStsCd() {
		return this.invErpIfStsCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCdForRhq
	 */
	public String getSOfcCdForRhq() {
		return this.sOfcCdForRhq;
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
	 * @return apArOffstNo
	 */
	public String getApArOffstNo() {
		return this.apArOffstNo;
	}
	
	/**
	 * Column Info
	 * @return otsStsNm
	 */
	public String getOtsStsNm() {
		return this.otsStsNm;
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
	 * @return displayType
	 */
	public String getDisplayType() {
		return this.displayType;
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
	 * @return ifCurrCd
	 */
	public String getIfCurrCd() {
		return this.ifCurrCd;
	}
	
	/**
	 * Column Info
	 * @return ifAmt
	 */
	public String getIfAmt() {
		return this.ifAmt;
	}
	
	/**
	 * Column Info
	 * @return sIfRhqCd
	 */
	public String getSIfRhqCd() {
		return this.sIfRhqCd;
	}
	
	/**
	 * Column Info
	 * @return cxlCsrNo
	 */
	public String getCxlCsrNo() {
		return this.cxlCsrNo;
	}
	
	/**
	 * Column Info
	 * @return revAmt
	 */
	public String getRevAmt() {
		return this.revAmt;
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
	 * @param trdPartyCode
	 */
	public void setTrdPartyCode(String trdPartyCode) {
		this.trdPartyCode = trdPartyCode;
	}
	
	/**
	 * Column Info
	 * @param invIfDt
	 */
	public void setInvIfDt(String invIfDt) {
		this.invIfDt = invIfDt;
	}
	
	/**
	 * Column Info
	 * @param tmlCrrCd
	 */
	public void setTmlCrrCd(String tmlCrrCd) {
		this.tmlCrrCd = tmlCrrCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvNo
	 */
	public void setN3ptyInvNo(String n3ptyInvNo) {
		this.n3ptyInvNo = n3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @param sCdKind
	 */
	public void setSCdKind(String sCdKind) {
		this.sCdKind = sCdKind;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param cfmAmt
	 */
	public void setCfmAmt(String cfmAmt) {
		this.cfmAmt = cfmAmt;
	}
	
	/**
	 * Column Info
	 * @param cltActYn
	 */
	public void setCltActYn(String cltActYn) {
		this.cltActYn = cltActYn;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param tmlInvRjctStsCd
	 */
	public void setTmlInvRjctStsCd(String tmlInvRjctStsCd) {
		this.tmlInvRjctStsCd = tmlInvRjctStsCd;
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
	 * @param sCdValue
	 */
	public void setSCdValue(String sCdValue) {
		this.sCdValue = sCdValue;
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
	 * @param invAmt1
	 */
	public void setInvAmt1(String invAmt1) {
		this.invAmt1 = invAmt1;
	}
	
	/**
	 * Column Info
	 * @param trdPartyName
	 */
	public void setTrdPartyName(String trdPartyName) {
		this.trdPartyName = trdPartyName;
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
	 * @param invIfOfcCd
	 */
	public void setInvIfOfcCd(String invIfOfcCd) {
		this.invIfOfcCd = invIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sEdate
	 */
	public void setSEdate(String sEdate) {
		this.sEdate = sEdate;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param glEffDt
	 */
	public void setGlEffDt(String glEffDt) {
		this.glEffDt = glEffDt;
	}
	
	/**
	 * Column Info
	 * @param arCurrCd
	 */
	public void setArCurrCd(String arCurrCd) {
		this.arCurrCd = arCurrCd;
	}
	
	/**
	 * Column Info
	 * @param calcRmk
	 */
	public void setCalcRmk(String calcRmk) {
		this.calcRmk = calcRmk;
	}
	
	/**
	 * Column Info
	 * @param sSdate
	 */
	public void setSSdate(String sSdate) {
		this.sSdate = sSdate;
	}
	
	/**
	 * Column Info
	 * @param sIfOfcCd
	 */
	public void setSIfOfcCd(String sIfOfcCd) {
		this.sIfOfcCd = sIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invErpIfStsCd
	 */
	public void setInvErpIfStsCd(String invErpIfStsCd) {
		this.invErpIfStsCd = invErpIfStsCd;
	}
	
	/**
	 * Column Info
	 * @param sOfcCdForRhq
	 */
	public void setSOfcCdForRhq(String sOfcCdForRhq) {
		this.sOfcCdForRhq = sOfcCdForRhq;
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
	 * @param apArOffstNo
	 */
	public void setApArOffstNo(String apArOffstNo) {
		this.apArOffstNo = apArOffstNo;
	}
	
	/**
	 * Column Info
	 * @param otsStsNm
	 */
	public void setOtsStsNm(String otsStsNm) {
		this.otsStsNm = otsStsNm;
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
	 * @param displayType
	 */
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
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
	 * @param ifCurrCd
	 */
	public void setIfCurrCd(String ifCurrCd) {
		this.ifCurrCd = ifCurrCd;
	}
	
	/**
	 * Column Info
	 * @param ifAmt
	 */
	public void setIfAmt(String ifAmt) {
		this.ifAmt = ifAmt;
	}
	
	/**
	 * Column Info
	 * @param sIfRhqCd
	 */
	public void setSIfRhqCd(String sIfRhqCd) {
		this.sIfRhqCd = sIfRhqCd;
	}
	
	/**
	 * Column Info
	 * @param cxlCsrNo
	 */
	public void setCxlCsrNo(String cxlCsrNo) {
		this.cxlCsrNo = cxlCsrNo;
	}
	
	/**
	 * Column Info
	 * @param revAmt
	 */
	public void setRevAmt(String revAmt) {
		this.revAmt = revAmt;
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
		setTrdPartyCode(JSPUtil.getParameter(request, prefix + "trd_party_code", ""));
		setInvIfDt(JSPUtil.getParameter(request, prefix + "inv_if_dt", ""));
		setTmlCrrCd(JSPUtil.getParameter(request, prefix + "tml_crr_cd", ""));
		setN3ptyInvNo(JSPUtil.getParameter(request, prefix + "n3pty_inv_no", ""));
		setSCdKind(JSPUtil.getParameter(request, prefix + "s_cd_kind", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCfmAmt(JSPUtil.getParameter(request, prefix + "cfm_amt", ""));
		setCltActYn(JSPUtil.getParameter(request, prefix + "clt_act_yn", ""));
		setN3ptyNo(JSPUtil.getParameter(request, prefix + "n3pty_no", ""));
		setTmlInvRjctStsCd(JSPUtil.getParameter(request, prefix + "tml_inv_rjct_sts_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setSCdValue(JSPUtil.getParameter(request, prefix + "s_cd_value", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setInvAmt1(JSPUtil.getParameter(request, prefix + "inv_amt1", ""));
		setTrdPartyName(JSPUtil.getParameter(request, prefix + "trd_party_name", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setInvIfOfcCd(JSPUtil.getParameter(request, prefix + "inv_if_ofc_cd", ""));
		setSEdate(JSPUtil.getParameter(request, prefix + "s_edate", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setGlEffDt(JSPUtil.getParameter(request, prefix + "gl_eff_dt", ""));
		setArCurrCd(JSPUtil.getParameter(request, prefix + "ar_curr_cd", ""));
		setCalcRmk(JSPUtil.getParameter(request, prefix + "calc_rmk", ""));
		setSSdate(JSPUtil.getParameter(request, prefix + "s_sdate", ""));
		setSIfOfcCd(JSPUtil.getParameter(request, prefix + "s_if_ofc_cd", ""));
		setInvErpIfStsCd(JSPUtil.getParameter(request, prefix + "inv_erp_if_sts_cd", ""));
		setSOfcCdForRhq(JSPUtil.getParameter(request, prefix + "s_ofc_cd_for_rhq", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setApArOffstNo(JSPUtil.getParameter(request, prefix + "ap_ar_offst_no", ""));
		setOtsStsNm(JSPUtil.getParameter(request, prefix + "ots_sts_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDisplayType(JSPUtil.getParameter(request, prefix + "display_type", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setIfCurrCd(JSPUtil.getParameter(request, prefix + "if_curr_cd", ""));
		setIfAmt(JSPUtil.getParameter(request, prefix + "if_amt", ""));
		setSIfRhqCd(JSPUtil.getParameter(request, prefix + "s_if_rhq_cd", ""));
		setCxlCsrNo(JSPUtil.getParameter(request, prefix + "cxl_csr_no", ""));
		setCxlCsrNo(JSPUtil.getParameter(request, prefix + "rev_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchProcessListVO[]
	 */
	public SearchProcessListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchProcessListVO[]
	 */
	public SearchProcessListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchProcessListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] trdPartyCode = (JSPUtil.getParameter(request, prefix	+ "trd_party_code", length));
			String[] invIfDt = (JSPUtil.getParameter(request, prefix	+ "inv_if_dt", length));
			String[] tmlCrrCd = (JSPUtil.getParameter(request, prefix	+ "tml_crr_cd", length));
			String[] n3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_no", length));
			String[] sCdKind = (JSPUtil.getParameter(request, prefix	+ "s_cd_kind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cfmAmt = (JSPUtil.getParameter(request, prefix	+ "cfm_amt", length));
			String[] cltActYn = (JSPUtil.getParameter(request, prefix	+ "clt_act_yn", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] tmlInvRjctStsCd = (JSPUtil.getParameter(request, prefix	+ "tml_inv_rjct_sts_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] sCdValue = (JSPUtil.getParameter(request, prefix	+ "s_cd_value", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] invAmt1 = (JSPUtil.getParameter(request, prefix	+ "inv_amt1", length));
			String[] trdPartyName = (JSPUtil.getParameter(request, prefix	+ "trd_party_name", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] invIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_if_ofc_cd", length));
			String[] sEdate = (JSPUtil.getParameter(request, prefix	+ "s_edate", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] glEffDt = (JSPUtil.getParameter(request, prefix	+ "gl_eff_dt", length));
			String[] arCurrCd = (JSPUtil.getParameter(request, prefix	+ "ar_curr_cd", length));
			String[] calcRmk = (JSPUtil.getParameter(request, prefix	+ "calc_rmk", length));
			String[] sSdate = (JSPUtil.getParameter(request, prefix	+ "s_sdate", length));
			String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ofc_cd", length));
			String[] invErpIfStsCd = (JSPUtil.getParameter(request, prefix	+ "inv_erp_if_sts_cd", length));
			String[] sOfcCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd_for_rhq", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] apArOffstNo = (JSPUtil.getParameter(request, prefix	+ "ap_ar_offst_no", length));
			String[] otsStsNm = (JSPUtil.getParameter(request, prefix	+ "ots_sts_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] displayType = (JSPUtil.getParameter(request, prefix	+ "display_type", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] ifCurrCd = (JSPUtil.getParameter(request, prefix	+ "if_curr_cd", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] sIfRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_if_rhq_cd", length));
			String[] cxlCsrNo = (JSPUtil.getParameter(request, prefix	+ "cxl_csr_no", length));
			String[] revAmt = (JSPUtil.getParameter(request, prefix	+ "rev_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchProcessListVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (trdPartyCode[i] != null)
					model.setTrdPartyCode(trdPartyCode[i]);
				if (invIfDt[i] != null)
					model.setInvIfDt(invIfDt[i]);
				if (tmlCrrCd[i] != null)
					model.setTmlCrrCd(tmlCrrCd[i]);
				if (n3ptyInvNo[i] != null)
					model.setN3ptyInvNo(n3ptyInvNo[i]);
				if (sCdKind[i] != null)
					model.setSCdKind(sCdKind[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cfmAmt[i] != null)
					model.setCfmAmt(cfmAmt[i]);
				if (cltActYn[i] != null)
					model.setCltActYn(cltActYn[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (tmlInvRjctStsCd[i] != null)
					model.setTmlInvRjctStsCd(tmlInvRjctStsCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (sCdValue[i] != null)
					model.setSCdValue(sCdValue[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (invAmt1[i] != null)
					model.setInvAmt1(invAmt1[i]);
				if (trdPartyName[i] != null)
					model.setTrdPartyName(trdPartyName[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (invIfOfcCd[i] != null)
					model.setInvIfOfcCd(invIfOfcCd[i]);
				if (sEdate[i] != null)
					model.setSEdate(sEdate[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (glEffDt[i] != null)
					model.setGlEffDt(glEffDt[i]);
				if (arCurrCd[i] != null)
					model.setArCurrCd(arCurrCd[i]);
				if (calcRmk[i] != null)
					model.setCalcRmk(calcRmk[i]);
				if (sSdate[i] != null)
					model.setSSdate(sSdate[i]);
				if (sIfOfcCd[i] != null)
					model.setSIfOfcCd(sIfOfcCd[i]);
				if (invErpIfStsCd[i] != null)
					model.setInvErpIfStsCd(invErpIfStsCd[i]);
				if (sOfcCdForRhq[i] != null)
					model.setSOfcCdForRhq(sOfcCdForRhq[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (apArOffstNo[i] != null)
					model.setApArOffstNo(apArOffstNo[i]);
				if (otsStsNm[i] != null)
					model.setOtsStsNm(otsStsNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (displayType[i] != null)
					model.setDisplayType(displayType[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (ifCurrCd[i] != null)
					model.setIfCurrCd(ifCurrCd[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (sIfRhqCd[i] != null)
					model.setSIfRhqCd(sIfRhqCd[i]);
				if (cxlCsrNo[i] != null)
					model.setCxlCsrNo(cxlCsrNo[i]);
				if (revAmt[i] != null)
					model.setRevAmt(revAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchProcessListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchProcessListVO[]
	 */
	public SearchProcessListVO[] getSearchProcessListVOs(){
		SearchProcessListVO[] vos = (SearchProcessListVO[])models.toArray(new SearchProcessListVO[models.size()]);
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
		this.trdPartyCode = this.trdPartyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfDt = this.invIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCrrCd = this.tmlCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvNo = this.n3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCdKind = this.sCdKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmAmt = this.cfmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltActYn = this.cltActYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvRjctStsCd = this.tmlInvRjctStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCdValue = this.sCdValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt1 = this.invAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyName = this.trdPartyName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfOfcCd = this.invIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdate = this.sEdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt = this.glEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCurrCd = this.arCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcRmk = this.calcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSdate = this.sSdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfOfcCd = this.sIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invErpIfStsCd = this.invErpIfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCdForRhq = this.sOfcCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apArOffstNo = this.apArOffstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsStsNm = this.otsStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.displayType = this.displayType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifCurrCd = this.ifCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfRhqCd = this.sIfRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlCsrNo = this.cxlCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAmt = this.revAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
