/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EACInqEacVO.java
*@FileTitle : EACInqEacVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo;

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
 * @author 백형인
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EACInqEacVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EACInqEacVO> models = new ArrayList<EACInqEacVO>();
	
	/* Column Info */
	private String sRhqOfcCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String tpbOfcCd = null;
	/* Column Info */
	private String vndrCustDivNm = null;
	/* Column Info */
	private String eacInpDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String audrOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cfmAmt = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String cfmCurrCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String invAudUsdAmt = null;
	/* Column Info */
	private String eqKndNm = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String eacAproTpNm = null;
	/* Column Info */
	private String sN3tpySrcCd = null;
	/* Column Info */
	private String sEacExpnTpCd = null;
	/* Column Info */
	private String eacExpnTpNm = null;
	/* Column Info */
	private String sEacYrmonTo = null;
	/* Column Info */
	private String sOtsStsCd = null;
	/* Column Info */
	private String sEacYrmonFr = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String eacBilTpNm = null;
	/* Column Info */
	private String eacYrmon = null;
	/* Column Info */
	private String sVndrCustDivCd = null;
	/* Column Info */
	private String eacTpNm = null;
	/* Column Info */
	private String sEacTpCd = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String eacNo = null;
	/* Column Info */
	private String otsStsNm = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String tpbRocOfcCd = null;
	/* Column Info */
	private String eacCostDesc = null;
	/* Column Info */
	private String sN3tpySrcNm = null;
	/* Column Info */
	private String invAudAmt = null;
	/* Column Info */
	private String n3ptySrcCd = null;
	/* Column Info */
	private String n3ptySrcNm = null;
	/* Column Info */
	private String sOtsStsDtlCd = null;
	/* Column Info */
	private String respbOfcCd = null;
	/* Column Info */
	private String n3ptySrcNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EACInqEacVO() {}

	public EACInqEacVO(String ibflag, String pagerows, String eacNo, String rhqOfcCd, String audrOfcCd, String eacAproTpNm, String eacInpDt, String eacYrmon, String eacExpnTpNm, String eacTpNm, String eacBilTpNm, String respbOfcCd, String vndrCustDivNm, String n3ptySrcCd, String n3ptySrcNm, String eacCostDesc, String vndrNm, String n3ptySrcNo, String invAudUsdAmt, String n3ptyNo, String tpbOfcCd, String eqKndNm, String eqNo, String bkgNo, String blNo, String vvdCd, String cfmCurrCd, String cfmAmt, String tpbRocOfcCd, String otsStsNm, String currCd, String invAudAmt, String sRhqOfcCd, String sOfcCd, String sEacYrmonFr, String sEacYrmonTo, String sOtsStsCd, String sOtsStsDtlCd, String sEacExpnTpCd, String sEacTpCd, String sVndrCustDivCd, String sN3tpySrcCd, String sN3tpySrcNm) {
		this.sRhqOfcCd = sRhqOfcCd;
		this.currCd = currCd;
		this.tpbOfcCd = tpbOfcCd;
		this.vndrCustDivNm = vndrCustDivNm;
		this.eacInpDt = eacInpDt;
		this.blNo = blNo;
		this.audrOfcCd = audrOfcCd;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.ibflag = ibflag;
		this.cfmAmt = cfmAmt;
		this.eqNo = eqNo;
		this.cfmCurrCd = cfmCurrCd;
		this.vvdCd = vvdCd;
		this.invAudUsdAmt = invAudUsdAmt;
		this.eqKndNm = eqKndNm;
		this.n3ptyNo = n3ptyNo;
		this.eacAproTpNm = eacAproTpNm;
		this.sN3tpySrcCd = sN3tpySrcCd;
		this.sEacExpnTpCd = sEacExpnTpCd;
		this.eacExpnTpNm = eacExpnTpNm;
		this.sEacYrmonTo = sEacYrmonTo;
		this.sOtsStsCd = sOtsStsCd;
		this.sEacYrmonFr = sEacYrmonFr;
		this.sOfcCd = sOfcCd;
		this.eacBilTpNm = eacBilTpNm;
		this.eacYrmon = eacYrmon;
		this.sVndrCustDivCd = sVndrCustDivCd;
		this.eacTpNm = eacTpNm;
		this.sEacTpCd = sEacTpCd;
		this.rhqOfcCd = rhqOfcCd;
		this.eacNo = eacNo;
		this.otsStsNm = otsStsNm;
		this.bkgNo = bkgNo;
		this.tpbRocOfcCd = tpbRocOfcCd;
		this.eacCostDesc = eacCostDesc;
		this.sN3tpySrcNm = sN3tpySrcNm;
		this.invAudAmt = invAudAmt;
		this.n3ptySrcCd = n3ptySrcCd;
		this.n3ptySrcNm = n3ptySrcNm;
		this.sOtsStsDtlCd = sOtsStsDtlCd;
		this.respbOfcCd = respbOfcCd;
		this.n3ptySrcNo = n3ptySrcNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("tpb_ofc_cd", getTpbOfcCd());
		this.hashColumns.put("vndr_cust_div_nm", getVndrCustDivNm());
		this.hashColumns.put("eac_inp_dt", getEacInpDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("audr_ofc_cd", getAudrOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cfm_amt", getCfmAmt());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cfm_curr_cd", getCfmCurrCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("inv_aud_usd_amt", getInvAudUsdAmt());
		this.hashColumns.put("eq_knd_nm", getEqKndNm());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("eac_apro_tp_nm", getEacAproTpNm());
		this.hashColumns.put("s_n3tpy_src_cd", getSN3tpySrcCd());
		this.hashColumns.put("s_eac_expn_tp_cd", getSEacExpnTpCd());
		this.hashColumns.put("eac_expn_tp_nm", getEacExpnTpNm());
		this.hashColumns.put("s_eac_yrmon_to", getSEacYrmonTo());
		this.hashColumns.put("s_ots_sts_cd", getSOtsStsCd());
		this.hashColumns.put("s_eac_yrmon_fr", getSEacYrmonFr());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("eac_bil_tp_nm", getEacBilTpNm());
		this.hashColumns.put("eac_yrmon", getEacYrmon());
		this.hashColumns.put("s_vndr_cust_div_cd", getSVndrCustDivCd());
		this.hashColumns.put("eac_tp_nm", getEacTpNm());
		this.hashColumns.put("s_eac_tp_cd", getSEacTpCd());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("eac_no", getEacNo());
		this.hashColumns.put("ots_sts_nm", getOtsStsNm());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("tpb_roc_ofc_cd", getTpbRocOfcCd());
		this.hashColumns.put("eac_cost_desc", getEacCostDesc());
		this.hashColumns.put("s_n3tpy_src_nm", getSN3tpySrcNm());
		this.hashColumns.put("inv_aud_amt", getInvAudAmt());
		this.hashColumns.put("n3pty_src_cd", getN3ptySrcCd());
		this.hashColumns.put("n3pty_src_nm", getN3ptySrcNm());
		this.hashColumns.put("s_ots_sts_dtl_cd", getSOtsStsDtlCd());
		this.hashColumns.put("respb_ofc_cd", getRespbOfcCd());
		this.hashColumns.put("n3pty_src_no", getN3ptySrcNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("tpb_ofc_cd", "tpbOfcCd");
		this.hashFields.put("vndr_cust_div_nm", "vndrCustDivNm");
		this.hashFields.put("eac_inp_dt", "eacInpDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("audr_ofc_cd", "audrOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cfm_amt", "cfmAmt");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cfm_curr_cd", "cfmCurrCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("inv_aud_usd_amt", "invAudUsdAmt");
		this.hashFields.put("eq_knd_nm", "eqKndNm");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("eac_apro_tp_nm", "eacAproTpNm");
		this.hashFields.put("s_n3tpy_src_cd", "sN3tpySrcCd");
		this.hashFields.put("s_eac_expn_tp_cd", "sEacExpnTpCd");
		this.hashFields.put("eac_expn_tp_nm", "eacExpnTpNm");
		this.hashFields.put("s_eac_yrmon_to", "sEacYrmonTo");
		this.hashFields.put("s_ots_sts_cd", "sOtsStsCd");
		this.hashFields.put("s_eac_yrmon_fr", "sEacYrmonFr");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("eac_bil_tp_nm", "eacBilTpNm");
		this.hashFields.put("eac_yrmon", "eacYrmon");
		this.hashFields.put("s_vndr_cust_div_cd", "sVndrCustDivCd");
		this.hashFields.put("eac_tp_nm", "eacTpNm");
		this.hashFields.put("s_eac_tp_cd", "sEacTpCd");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("eac_no", "eacNo");
		this.hashFields.put("ots_sts_nm", "otsStsNm");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("tpb_roc_ofc_cd", "tpbRocOfcCd");
		this.hashFields.put("eac_cost_desc", "eacCostDesc");
		this.hashFields.put("s_n3tpy_src_nm", "sN3tpySrcNm");
		this.hashFields.put("inv_aud_amt", "invAudAmt");
		this.hashFields.put("n3pty_src_cd", "n3ptySrcCd");
		this.hashFields.put("n3pty_src_nm", "n3ptySrcNm");
		this.hashFields.put("s_ots_sts_dtl_cd", "sOtsStsDtlCd");
		this.hashFields.put("respb_ofc_cd", "respbOfcCd");
		this.hashFields.put("n3pty_src_no", "n3ptySrcNo");
		return this.hashFields;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return tpbOfcCd
	 */
	public String getTpbOfcCd() {
		return this.tpbOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vndrCustDivNm
	 */
	public String getVndrCustDivNm() {
		return this.vndrCustDivNm;
	}
	
	/**
	 * Column Info
	 * @return eacInpDt
	 */
	public String getEacInpDt() {
		return this.eacInpDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return audrOfcCd
	 */
	public String getAudrOfcCd() {
		return this.audrOfcCd;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return cfmCurrCd
	 */
	public String getCfmCurrCd() {
		return this.cfmCurrCd;
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
	 * @return invAudUsdAmt
	 */
	public String getInvAudUsdAmt() {
		return this.invAudUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return eqKndNm
	 */
	public String getEqKndNm() {
		return this.eqKndNm;
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
	 * @return eacAproTpNm
	 */
	public String getEacAproTpNm() {
		return this.eacAproTpNm;
	}
	
	/**
	 * Column Info
	 * @return sN3tpySrcCd
	 */
	public String getSN3tpySrcCd() {
		return this.sN3tpySrcCd;
	}
	
	/**
	 * Column Info
	 * @return sEacExpnTpCd
	 */
	public String getSEacExpnTpCd() {
		return this.sEacExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @return eacExpnTpNm
	 */
	public String getEacExpnTpNm() {
		return this.eacExpnTpNm;
	}
	
	/**
	 * Column Info
	 * @return sEacYrmonTo
	 */
	public String getSEacYrmonTo() {
		return this.sEacYrmonTo;
	}
	
	/**
	 * Column Info
	 * @return sOtsStsCd
	 */
	public String getSOtsStsCd() {
		return this.sOtsStsCd;
	}
	
	/**
	 * Column Info
	 * @return sEacYrmonFr
	 */
	public String getSEacYrmonFr() {
		return this.sEacYrmonFr;
	}
	
	/**
	 * Column Info
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eacBilTpNm
	 */
	public String getEacBilTpNm() {
		return this.eacBilTpNm;
	}
	
	/**
	 * Column Info
	 * @return eacYrmon
	 */
	public String getEacYrmon() {
		return this.eacYrmon;
	}
	
	/**
	 * Column Info
	 * @return sVndrCustDivCd
	 */
	public String getSVndrCustDivCd() {
		return this.sVndrCustDivCd;
	}
	
	/**
	 * Column Info
	 * @return eacTpNm
	 */
	public String getEacTpNm() {
		return this.eacTpNm;
	}
	
	/**
	 * Column Info
	 * @return sEacTpCd
	 */
	public String getSEacTpCd() {
		return this.sEacTpCd;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
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
	 * @return otsStsNm
	 */
	public String getOtsStsNm() {
		return this.otsStsNm;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return tpbRocOfcCd
	 */
	public String getTpbRocOfcCd() {
		return this.tpbRocOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eacCostDesc
	 */
	public String getEacCostDesc() {
		return this.eacCostDesc;
	}
	
	/**
	 * Column Info
	 * @return sN3tpySrcNm
	 */
	public String getSN3tpySrcNm() {
		return this.sN3tpySrcNm;
	}
	
	/**
	 * Column Info
	 * @return invAudAmt
	 */
	public String getInvAudAmt() {
		return this.invAudAmt;
	}
	
	/**
	 * Column Info
	 * @return n3ptySrcCd
	 */
	public String getN3ptySrcCd() {
		return this.n3ptySrcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptySrcNm
	 */
	public String getN3ptySrcNm() {
		return this.n3ptySrcNm;
	}
	
	/**
	 * Column Info
	 * @return sOtsStsDtlCd
	 */
	public String getSOtsStsDtlCd() {
		return this.sOtsStsDtlCd;
	}
	
	/**
	 * Column Info
	 * @return respbOfcCd
	 */
	public String getRespbOfcCd() {
		return this.respbOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptySrcNo
	 */
	public String getN3ptySrcNo() {
		return this.n3ptySrcNo;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param tpbOfcCd
	 */
	public void setTpbOfcCd(String tpbOfcCd) {
		this.tpbOfcCd = tpbOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vndrCustDivNm
	 */
	public void setVndrCustDivNm(String vndrCustDivNm) {
		this.vndrCustDivNm = vndrCustDivNm;
	}
	
	/**
	 * Column Info
	 * @param eacInpDt
	 */
	public void setEacInpDt(String eacInpDt) {
		this.eacInpDt = eacInpDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param audrOfcCd
	 */
	public void setAudrOfcCd(String audrOfcCd) {
		this.audrOfcCd = audrOfcCd;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param cfmCurrCd
	 */
	public void setCfmCurrCd(String cfmCurrCd) {
		this.cfmCurrCd = cfmCurrCd;
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
	 * @param invAudUsdAmt
	 */
	public void setInvAudUsdAmt(String invAudUsdAmt) {
		this.invAudUsdAmt = invAudUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param eqKndNm
	 */
	public void setEqKndNm(String eqKndNm) {
		this.eqKndNm = eqKndNm;
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
	 * @param eacAproTpNm
	 */
	public void setEacAproTpNm(String eacAproTpNm) {
		this.eacAproTpNm = eacAproTpNm;
	}
	
	/**
	 * Column Info
	 * @param sN3tpySrcCd
	 */
	public void setSN3tpySrcCd(String sN3tpySrcCd) {
		this.sN3tpySrcCd = sN3tpySrcCd;
	}
	
	/**
	 * Column Info
	 * @param sEacExpnTpCd
	 */
	public void setSEacExpnTpCd(String sEacExpnTpCd) {
		this.sEacExpnTpCd = sEacExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @param eacExpnTpNm
	 */
	public void setEacExpnTpNm(String eacExpnTpNm) {
		this.eacExpnTpNm = eacExpnTpNm;
	}
	
	/**
	 * Column Info
	 * @param sEacYrmonTo
	 */
	public void setSEacYrmonTo(String sEacYrmonTo) {
		this.sEacYrmonTo = sEacYrmonTo;
	}
	
	/**
	 * Column Info
	 * @param sOtsStsCd
	 */
	public void setSOtsStsCd(String sOtsStsCd) {
		this.sOtsStsCd = sOtsStsCd;
	}
	
	/**
	 * Column Info
	 * @param sEacYrmonFr
	 */
	public void setSEacYrmonFr(String sEacYrmonFr) {
		this.sEacYrmonFr = sEacYrmonFr;
	}
	
	/**
	 * Column Info
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eacBilTpNm
	 */
	public void setEacBilTpNm(String eacBilTpNm) {
		this.eacBilTpNm = eacBilTpNm;
	}
	
	/**
	 * Column Info
	 * @param eacYrmon
	 */
	public void setEacYrmon(String eacYrmon) {
		this.eacYrmon = eacYrmon;
	}
	
	/**
	 * Column Info
	 * @param sVndrCustDivCd
	 */
	public void setSVndrCustDivCd(String sVndrCustDivCd) {
		this.sVndrCustDivCd = sVndrCustDivCd;
	}
	
	/**
	 * Column Info
	 * @param eacTpNm
	 */
	public void setEacTpNm(String eacTpNm) {
		this.eacTpNm = eacTpNm;
	}
	
	/**
	 * Column Info
	 * @param sEacTpCd
	 */
	public void setSEacTpCd(String sEacTpCd) {
		this.sEacTpCd = sEacTpCd;
	}
	
	/**
	 * Column Info
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
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
	 * @param otsStsNm
	 */
	public void setOtsStsNm(String otsStsNm) {
		this.otsStsNm = otsStsNm;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param tpbRocOfcCd
	 */
	public void setTpbRocOfcCd(String tpbRocOfcCd) {
		this.tpbRocOfcCd = tpbRocOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eacCostDesc
	 */
	public void setEacCostDesc(String eacCostDesc) {
		this.eacCostDesc = eacCostDesc;
	}
	
	/**
	 * Column Info
	 * @param sN3tpySrcNm
	 */
	public void setSN3tpySrcNm(String sN3tpySrcNm) {
		this.sN3tpySrcNm = sN3tpySrcNm;
	}
	
	/**
	 * Column Info
	 * @param invAudAmt
	 */
	public void setInvAudAmt(String invAudAmt) {
		this.invAudAmt = invAudAmt;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcCd
	 */
	public void setN3ptySrcCd(String n3ptySrcCd) {
		this.n3ptySrcCd = n3ptySrcCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcNm
	 */
	public void setN3ptySrcNm(String n3ptySrcNm) {
		this.n3ptySrcNm = n3ptySrcNm;
	}
	
	/**
	 * Column Info
	 * @param sOtsStsDtlCd
	 */
	public void setSOtsStsDtlCd(String sOtsStsDtlCd) {
		this.sOtsStsDtlCd = sOtsStsDtlCd;
	}
	
	/**
	 * Column Info
	 * @param respbOfcCd
	 */
	public void setRespbOfcCd(String respbOfcCd) {
		this.respbOfcCd = respbOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcNo
	 */
	public void setN3ptySrcNo(String n3ptySrcNo) {
		this.n3ptySrcNo = n3ptySrcNo;
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
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setTpbOfcCd(JSPUtil.getParameter(request, prefix + "tpb_ofc_cd", ""));
		setVndrCustDivNm(JSPUtil.getParameter(request, prefix + "vndr_cust_div_nm", ""));
		setEacInpDt(JSPUtil.getParameter(request, prefix + "eac_inp_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setAudrOfcCd(JSPUtil.getParameter(request, prefix + "audr_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCfmAmt(JSPUtil.getParameter(request, prefix + "cfm_amt", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setCfmCurrCd(JSPUtil.getParameter(request, prefix + "cfm_curr_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setInvAudUsdAmt(JSPUtil.getParameter(request, prefix + "inv_aud_usd_amt", ""));
		setEqKndNm(JSPUtil.getParameter(request, prefix + "eq_knd_nm", ""));
		setN3ptyNo(JSPUtil.getParameter(request, prefix + "n3pty_no", ""));
		setEacAproTpNm(JSPUtil.getParameter(request, prefix + "eac_apro_tp_nm", ""));
		setSN3tpySrcCd(JSPUtil.getParameter(request, prefix + "s_n3tpy_src_cd", ""));
		setSEacExpnTpCd(JSPUtil.getParameter(request, prefix + "s_eac_expn_tp_cd", ""));
		setEacExpnTpNm(JSPUtil.getParameter(request, prefix + "eac_expn_tp_nm", ""));
		setSEacYrmonTo(JSPUtil.getParameter(request, prefix + "s_eac_yrmon_to", ""));
		setSOtsStsCd(JSPUtil.getParameter(request, prefix + "s_ots_sts_cd", ""));
		setSEacYrmonFr(JSPUtil.getParameter(request, prefix + "s_eac_yrmon_fr", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setEacBilTpNm(JSPUtil.getParameter(request, prefix + "eac_bil_tp_nm", ""));
		setEacYrmon(JSPUtil.getParameter(request, prefix + "eac_yrmon", ""));
		setSVndrCustDivCd(JSPUtil.getParameter(request, prefix + "s_vndr_cust_div_cd", ""));
		setEacTpNm(JSPUtil.getParameter(request, prefix + "eac_tp_nm", ""));
		setSEacTpCd(JSPUtil.getParameter(request, prefix + "s_eac_tp_cd", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setEacNo(JSPUtil.getParameter(request, prefix + "eac_no", ""));
		setOtsStsNm(JSPUtil.getParameter(request, prefix + "ots_sts_nm", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTpbRocOfcCd(JSPUtil.getParameter(request, prefix + "tpb_roc_ofc_cd", ""));
		setEacCostDesc(JSPUtil.getParameter(request, prefix + "eac_cost_desc", ""));
		setSN3tpySrcNm(JSPUtil.getParameter(request, prefix + "s_n3tpy_src_nm", ""));
		setInvAudAmt(JSPUtil.getParameter(request, prefix + "inv_aud_amt", ""));
		setN3ptySrcCd(JSPUtil.getParameter(request, prefix + "n3pty_src_cd", ""));
		setN3ptySrcNm(JSPUtil.getParameter(request, prefix + "n3pty_src_nm", ""));
		setSOtsStsDtlCd(JSPUtil.getParameter(request, prefix + "s_ots_sts_dtl_cd", ""));
		setRespbOfcCd(JSPUtil.getParameter(request, prefix + "respb_ofc_cd", ""));
		setN3ptySrcNo(JSPUtil.getParameter(request, prefix + "n3pty_src_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EACInqEacVO[]
	 */
	public EACInqEacVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EACInqEacVO[]
	 */
	public EACInqEacVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EACInqEacVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] tpbOfcCd = (JSPUtil.getParameter(request, prefix	+ "tpb_ofc_cd", length));
			String[] vndrCustDivNm = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_div_nm", length));
			String[] eacInpDt = (JSPUtil.getParameter(request, prefix	+ "eac_inp_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] audrOfcCd = (JSPUtil.getParameter(request, prefix	+ "audr_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cfmAmt = (JSPUtil.getParameter(request, prefix	+ "cfm_amt", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] cfmCurrCd = (JSPUtil.getParameter(request, prefix	+ "cfm_curr_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] invAudUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_aud_usd_amt", length));
			String[] eqKndNm = (JSPUtil.getParameter(request, prefix	+ "eq_knd_nm", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] eacAproTpNm = (JSPUtil.getParameter(request, prefix	+ "eac_apro_tp_nm", length));
			String[] sN3tpySrcCd = (JSPUtil.getParameter(request, prefix	+ "s_n3tpy_src_cd", length));
			String[] sEacExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "s_eac_expn_tp_cd", length));
			String[] eacExpnTpNm = (JSPUtil.getParameter(request, prefix	+ "eac_expn_tp_nm", length));
			String[] sEacYrmonTo = (JSPUtil.getParameter(request, prefix	+ "s_eac_yrmon_to", length));
			String[] sOtsStsCd = (JSPUtil.getParameter(request, prefix	+ "s_ots_sts_cd", length));
			String[] sEacYrmonFr = (JSPUtil.getParameter(request, prefix	+ "s_eac_yrmon_fr", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] eacBilTpNm = (JSPUtil.getParameter(request, prefix	+ "eac_bil_tp_nm", length));
			String[] eacYrmon = (JSPUtil.getParameter(request, prefix	+ "eac_yrmon", length));
			String[] sVndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_div_cd", length));
			String[] eacTpNm = (JSPUtil.getParameter(request, prefix	+ "eac_tp_nm", length));
			String[] sEacTpCd = (JSPUtil.getParameter(request, prefix	+ "s_eac_tp_cd", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] eacNo = (JSPUtil.getParameter(request, prefix	+ "eac_no", length));
			String[] otsStsNm = (JSPUtil.getParameter(request, prefix	+ "ots_sts_nm", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] tpbRocOfcCd = (JSPUtil.getParameter(request, prefix	+ "tpb_roc_ofc_cd", length));
			String[] eacCostDesc = (JSPUtil.getParameter(request, prefix	+ "eac_cost_desc", length));
			String[] sN3tpySrcNm = (JSPUtil.getParameter(request, prefix	+ "s_n3tpy_src_nm", length));
			String[] invAudAmt = (JSPUtil.getParameter(request, prefix	+ "inv_aud_amt", length));
			String[] n3ptySrcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_cd", length));
			String[] n3ptySrcNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_nm", length));
			String[] sOtsStsDtlCd = (JSPUtil.getParameter(request, prefix	+ "s_ots_sts_dtl_cd", length));
			String[] respbOfcCd = (JSPUtil.getParameter(request, prefix	+ "respb_ofc_cd", length));
			String[] n3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new EACInqEacVO();
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (tpbOfcCd[i] != null)
					model.setTpbOfcCd(tpbOfcCd[i]);
				if (vndrCustDivNm[i] != null)
					model.setVndrCustDivNm(vndrCustDivNm[i]);
				if (eacInpDt[i] != null)
					model.setEacInpDt(eacInpDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (audrOfcCd[i] != null)
					model.setAudrOfcCd(audrOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cfmAmt[i] != null)
					model.setCfmAmt(cfmAmt[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (cfmCurrCd[i] != null)
					model.setCfmCurrCd(cfmCurrCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (invAudUsdAmt[i] != null)
					model.setInvAudUsdAmt(invAudUsdAmt[i]);
				if (eqKndNm[i] != null)
					model.setEqKndNm(eqKndNm[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (eacAproTpNm[i] != null)
					model.setEacAproTpNm(eacAproTpNm[i]);
				if (sN3tpySrcCd[i] != null)
					model.setSN3tpySrcCd(sN3tpySrcCd[i]);
				if (sEacExpnTpCd[i] != null)
					model.setSEacExpnTpCd(sEacExpnTpCd[i]);
				if (eacExpnTpNm[i] != null)
					model.setEacExpnTpNm(eacExpnTpNm[i]);
				if (sEacYrmonTo[i] != null)
					model.setSEacYrmonTo(sEacYrmonTo[i]);
				if (sOtsStsCd[i] != null)
					model.setSOtsStsCd(sOtsStsCd[i]);
				if (sEacYrmonFr[i] != null)
					model.setSEacYrmonFr(sEacYrmonFr[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (eacBilTpNm[i] != null)
					model.setEacBilTpNm(eacBilTpNm[i]);
				if (eacYrmon[i] != null)
					model.setEacYrmon(eacYrmon[i]);
				if (sVndrCustDivCd[i] != null)
					model.setSVndrCustDivCd(sVndrCustDivCd[i]);
				if (eacTpNm[i] != null)
					model.setEacTpNm(eacTpNm[i]);
				if (sEacTpCd[i] != null)
					model.setSEacTpCd(sEacTpCd[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (eacNo[i] != null)
					model.setEacNo(eacNo[i]);
				if (otsStsNm[i] != null)
					model.setOtsStsNm(otsStsNm[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (tpbRocOfcCd[i] != null)
					model.setTpbRocOfcCd(tpbRocOfcCd[i]);
				if (eacCostDesc[i] != null)
					model.setEacCostDesc(eacCostDesc[i]);
				if (sN3tpySrcNm[i] != null)
					model.setSN3tpySrcNm(sN3tpySrcNm[i]);
				if (invAudAmt[i] != null)
					model.setInvAudAmt(invAudAmt[i]);
				if (n3ptySrcCd[i] != null)
					model.setN3ptySrcCd(n3ptySrcCd[i]);
				if (n3ptySrcNm[i] != null)
					model.setN3ptySrcNm(n3ptySrcNm[i]);
				if (sOtsStsDtlCd[i] != null)
					model.setSOtsStsDtlCd(sOtsStsDtlCd[i]);
				if (respbOfcCd[i] != null)
					model.setRespbOfcCd(respbOfcCd[i]);
				if (n3ptySrcNo[i] != null)
					model.setN3ptySrcNo(n3ptySrcNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEACInqEacVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EACInqEacVO[]
	 */
	public EACInqEacVO[] getEACInqEacVOs(){
		EACInqEacVO[] vos = (EACInqEacVO[])models.toArray(new EACInqEacVO[models.size()]);
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
		this.sRhqOfcCd = this.sRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbOfcCd = this.tpbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustDivNm = this.vndrCustDivNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacInpDt = this.eacInpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audrOfcCd = this.audrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmAmt = this.cfmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmCurrCd = this.cfmCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAudUsdAmt = this.invAudUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndNm = this.eqKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacAproTpNm = this.eacAproTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3tpySrcCd = this.sN3tpySrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacExpnTpCd = this.sEacExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacExpnTpNm = this.eacExpnTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacYrmonTo = this.sEacYrmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOtsStsCd = this.sOtsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacYrmonFr = this.sEacYrmonFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacBilTpNm = this.eacBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacYrmon = this.eacYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustDivCd = this.sVndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacTpNm = this.eacTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacTpCd = this.sEacTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacNo = this.eacNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsStsNm = this.otsStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbRocOfcCd = this.tpbRocOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacCostDesc = this.eacCostDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3tpySrcNm = this.sN3tpySrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAudAmt = this.invAudAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcCd = this.n3ptySrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcNm = this.n3ptySrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOtsStsDtlCd = this.sOtsStsDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbOfcCd = this.respbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcNo = this.n3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
